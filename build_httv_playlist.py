import json
import os
import re
import ssl
import sys
import unicodedata
import urllib.request
import xml.etree.ElementTree as ET
from collections import Counter

sys.stdout.reconfigure(encoding='utf-8')

# SSL context for downloading if needed
ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

def strip_accents(text):
    if not text: return ""
    text = unicodedata.normalize('NFD', text)
    text = ''.join(c for c in text if unicodedata.category(c) != 'Mn')
    return text.replace('đ', 'd').replace('Đ', 'D')

def get_aliases(text):
    if not text: return []
    s = text.strip()
    res = {s.lower(), re.sub(r'[^a-zA-Z0-9]', '', s).lower()}
    no_acc = strip_accents(s)
    res.add(no_acc.lower())
    res.add(re.sub(r'[^a-zA-Z0-9]', '', no_acc).lower())
    
    clean = re.sub(r'\s*(hd|sd|fhd|4k)\b', '', s, flags=re.I).strip()
    clean = re.sub(r'^(kênh|kenh)\s+', '', clean, flags=re.I).strip()
    res.add(clean.lower())
    res.add(re.sub(r'[^a-zA-Z0-9]', '', clean).lower())
    clean_no_acc = strip_accents(clean)
    res.add(clean_no_acc.lower())
    res.add(re.sub(r'[^a-zA-Z0-9]', '', clean_no_acc).lower())
    return [k for k in res if k]

# 1. Load EPG IO (Priority 1 for logos - Cloudflare R2 PNGs)
print("Loading EPG IO (epg.io.vn)...")
tree_io = ET.parse('epg_io.xml')
root_io = tree_io.getroot()

io_logos = {}
io_names = {}
for ch in root_io.findall('channel'):
    cid = ch.get('id', '').strip()
    dn = ch.find('display-name')
    name = dn.text.strip() if dn is not None and dn.text else cid
    icon = ch.find('icon')
    logo = icon.get('src', '').strip() if icon is not None else ''
    if logo and logo.startswith('http'):
        io_logos[cid.lower()] = logo
        io_names[cid.lower()] = name
        for a in get_aliases(name) + get_aliases(cid):
            if a not in io_logos:
                io_logos[a] = logo

print(f"Loaded {len(io_logos)} aliases from epg.io.vn")

# 2. Load EPG Blaosolar (Priority 2 for logos & canonical channels)
print("Loading EPG Blaosolar (epg.blaosolar.vn)...")
tree_blao = ET.parse('epg_blaosolar.xml')
root_blao = tree_blao.getroot()

blao_logos = {}
for ch in root_blao.findall('channel'):
    cid = ch.get('id', '').strip()
    icon = ch.find('icon')
    logo = icon.get('src', '').strip() if icon is not None else ''
    if logo.startswith('http://image'):
        logo = logo.replace('http://', 'https://')
    if logo and logo.startswith('http'):
        blao_logos[cid.lower()] = logo
        dn = ch.find('display-name')
        if dn is not None and dn.text:
            for a in get_aliases(dn.text.strip()):
                if a not in blao_logos:
                    blao_logos[a] = logo

# Strictly Vietnamese provinces
VN_PROVINCES = [
    'an giang', 'ba ria vung tau', 'brt', 'bac lieu', 'bac giang', 'bac kan', 'bac ninh',
    'ben tre', 'binh dinh', 'btv', 'binh duong', 'binh phuoc', 'bptv', 'binh thuan',
    'ca mau', 'ctv', 'can tho', 'thpct', 'cao bang', 'da nang', 'drt', 'danangtv',
    'dak lak', 'dak nong', 'dien bien', 'dong nai', 'dnrtv', 'dong thap', 'thdt',
    'gia lai', 'ha giang', 'ha nam', 'ha noi', 'h1', 'h2', 'hanoitv', 'ha tinh',
    'hai duong', 'hai phong', 'thp', 'hau giang', 'hgtv', 'hoa binh', 'hung yen', 'hytv',
    'khanh hoa', 'ktv', 'kien giang', 'kgtv', 'kon tum', 'lai chau', 'lam dong', 'ltv',
    'lang son', 'lao cai', 'long an', 'la34', 'nam dinh', 'nghe an', 'ntv', 'ninh binh',
    'ninh thuan', 'phu tho', 'ptv', 'phu yen', 'ptp', 'quang binh', 'qbtv', 'quang nam',
    'qrt', 'quang ngai', 'ptq', 'qngtv', 'quang ninh', 'qtv', 'quang tri', 'qrtv',
    'soc trang', 'stv', 'son la', 'tay ninh', 'ttv11', 'thai binh', 'thai nguyen', 'tntv',
    'thanh hoa', 'ttv', 'thua thien hue', 'hue', 'trt', 'tien giang', 'thtg', 'tra vinh',
    'tuyen quang', 'vinh long', 'thvl', 'vinh phuc', 'yen bai'
]

def is_strictly_vietnamese_province(name):
    norm = strip_accents(name).lower()
    norm_clean = re.sub(r'[^a-z0-9]', ' ', norm)
    # Exclude national/overseas/sports
    if any(k in norm for k in ['trt world', 'vh1', 'pptv', ' fc', 'club', 'vtv', 'htv', 'sctv', 'vtvcab', 'on ', 'k+', 'spotv', 'hbo', 'cinemax', 'axn', 'cbeebies', 'cna', 'box hits', 'travel', 'radio', 'voa', 'vov', 'voh', 'bbc', 'cnn', 'nhk', 'dw']):
        return False
    return any(p in norm_clean for p in VN_PROVINCES)

def categorize_channel(name, default_cat=''):
    uname = name.upper()
    unorm = strip_accents(uname)
    
    # Radio
    if any(k in uname for k in ['VOV', 'VOH', 'RADIO', 'FM ', 'PHÁT THANH', 'PHAT THANH', 'QNR1', 'QNR2']):
        return "Radio"
        
    # VTV (Thiết yếu quốc gia)
    if any(k in uname for k in ['VTV', 'VIETNAM TODAY', 'ANTV', 'QPVN', 'QUỐC HỘI', 'QUOC HOI', 'NHÂN DÂN', 'NHAN DAN', 'TTXVN', 'VNEWS']):
        return "VTV"
        
    # HTV
    if any(k in uname for k in ['HTV', 'HTVC', 'THUẦN VIỆT', 'THUAN VIET']):
        return "HTV"
        
    # SCTV
    if 'SCTV' in uname:
        return "SCTV"
        
    # Live matches (time format hh:mm or VS or match names)
    if re.search(r'\d{1,2}:\d{2}', uname) or any(k in uname for k in [' - ', ' VS ', ' FC ', ' SC ', 'SOCOLIVE', 'GÀ VÀNG', 'GA VANG', 'CHUỐI CHIÊN', 'CHUOICHIEN', 'TRỰC TIẾP', 'TRUC TIEP', 'BLV ']):
        return "Bóng Đá Trực Tiếp"

    # Thể Thao
    if any(k in uname for k in ['K+ SPORT', 'K+ ACTION', 'SPOTV', 'SPORT', 'THỂ THAO', 'THE THAO', 'FOOTBALL', 'GOLF', 'TENNIS', 'BUNDESLIGA', 'C1', 'C2', 'C3', 'F1', 'CÔNG THỨC 1', 'KIX', 'EUROSPORT']):
        return "Thể Thao"

    # Phim Truyện
    if any(k in uname for k in ['HBO', 'CINEMAX', 'AXN', 'WARNER', 'CINEMA', 'BOX MOVIE', 'HOLLYWOOD', 'PHIM', 'DRAMAS', 'CINE', 'AFN', 'WOMAN', 'PARAMOUNT', 'HITS', 'RAP PHIM']):
        return "Phim Truyện"

    # Thiếu Nhi & Khám Phá
    if any(k in uname for k in ['CARTOON', 'BIBI', 'KIDS', 'DAVINCI', 'DREAMWORKS', 'DISCOVERY', 'ANIMAL', 'EARTH', 'HISTORY', 'DMAX', 'BBCLIFESTYLE', 'OUTDOOR', 'HAPPY KIDS', 'CBEEBIES', 'TRAVEL & LIVING', 'TLC', 'NATIONAL GEOGRAPHIC', 'NAT GEO']):
        return "Thiếu Nhi & Khám Phá"

    # Quốc Tế
    if any(k in uname for k in ['CNN', 'BBC', 'NHK', 'DW', 'BLOOMBERG', 'CNBC', 'FRANCE', 'TV5', 'ARIRANG', 'KBS', 'ABC AUSTRALIA', 'CNA', 'CHANNEL NEWS ASIA', 'FASHION', 'HGTV', 'CCTV', 'CGTN', 'AL JAZEERA', 'FOX NEWS', 'SKY NEWS', 'BOX HITS', 'MUSIC BOX']):
        return "Quốc Tế"

    # Specific default category overrides
    def_norm = strip_accents(default_cat).upper()
    if any(k in def_norm for k in ['SOCOLIVE', 'GA VANG', 'CHUOICHIEN']):
        return "Bóng Đá Trực Tiếp"
    if any(k in def_norm for k in ['SU KIEN', 'EVENT', 'FPTPLAY', 'TV360']):
        return "Thể Thao"
    if 'RAP PHIM' in def_norm or 'PHIM' in def_norm:
        return "Phim Truyện"
    if 'KHAM PHA' in def_norm or 'THIEU NHI' in def_norm:
        return "Thiếu Nhi & Khám Phá"
    if 'QUOC TE' in def_norm:
        return "Quốc Tế"
        
    # Strictly Vietnamese provinces
    if is_strictly_vietnamese_province(name):
        return "Địa Phương"
        
    return "VTVcab / Giải Trí"

# Custom canonical IDs
CUSTOM_MAP = {
    'vtv1': 'vtv1hd', 'vtv2': 'vtv2hd', 'vtv3': 'vtv3hd', 'vtv4': 'vtv4hd', 'vtv5': 'vtv5hd',
    'vtv6': 'vtv6hd', 'vtv7': 'vtv7hd', 'vtv8': 'vtv8hd', 'vtv9': 'vtv9hd', 'vtv10': 'vtv10hd',
    'vtv5taynguyen': 'vtv5hdtn', 'vtv5taynambo': 'vtv5hdtnb',
    'thvl1': 'vinhlong1hd', 'thvl2': 'vinhlong2hd', 'thvl3': 'vinhlong3hd', 'thvl4': 'vinhlong4hd', 'thvl5': 'vinhlong5hd',
    'vinhlong1': 'vinhlong1hd', 'vinhlong2': 'vinhlong2hd', 'vinhlong3': 'vinhlong3hd', 'vinhlong4': 'vinhlong4hd', 'vinhlong5': 'vinhlong5hd',
    'htv7': 'htv7hd', 'htv9': 'htv9hd', 'htv2': 'htv2hd', 'htvtt': 'htvthethaohd', 'htvthethao': 'htvthethaohd',
    'thuanviet': 'htvcthuanviethd', 'htvcthuanviet': 'htvcthuanviethd',
    'antv': 'antvhd', 'qpvn': 'qpvnhd',
    'hanoi1': 'hanoi1', 'hanoi2': 'hanoi2', 'h1': 'hanoi1', 'h2': 'hanoi2', 'hn1': 'hanoi1', 'hn2': 'hanoi2',
    'danang1': 'danang1', 'danang2': 'danang2', 'drt1': 'danang1', 'drt2': 'danang2',
    'haiphong': 'haiphong', 'thp': 'haiphong', 'thp3': 'haiphong3',
    'quangninh1': 'quangninh1', 'quangninh3': 'quangninh3', 'qtv1': 'quangninh1', 'qtv3': 'quangninh3',
    'dongthap1': 'dongthap1', 'dongthap2': 'dongthap2', 'thdt1': 'dongthap1', 'thdt2': 'dongthap2',
    'angiang1': 'angiang1', 'angiang2': 'angiang2', 'angiang3': 'angiang3',
    'dongnai1': 'dongnai1', 'dongnai2': 'dongnai2', 'dnrtv1': 'dongnai1', 'dnrtv2': 'dongnai2',
    'lamdong1': 'lamdong1', 'lamdong2': 'lamdong2', 'ltv1': 'lamdong1', 'ltv2': 'lamdong2',
    'khanhhoa1': 'khanhhoa1', 'khanhhoa': 'khanhhoa', 'ktv': 'khanhhoa',
    'quangngai1': 'quangngai', 'quangngai2': 'quangngai2',
    'onsport': 'onsports', 'onsports': 'onsports', 'onsportplus': 'onsportsplus', 'onsportsplus': 'onsportsplus',
    'onfootball': 'onfootball', 'ongolf': 'ongolf', 'onmovies': 'onmovies', 'oncine': 'oncine',
    'onviegiaitri': 'onviegiaitri', 'viegiaitri': 'onviegiaitri', 'onphimviet': 'onphimviet', 'phimviet': 'onphimviet',
    'onbibi': 'onbibi', 'bibi': 'onbibi', 'onkids': 'onkids', 'cartoonkids': 'onkids', 'onmusic': 'onmusic',
    'onstyle': 'onstyle', 'styletv': 'onstyle', 'ontrending': 'ontrending', 'trendingtv': 'ontrending',
    'onvfamily': 'onvfamily', 'vfamily': 'onvfamily', 'onviedramas': 'onviedramas', 'viedramas': 'onviedramas',
    'ono2tv': 'ono2tv', 'o2tv': 'ono2tv', 'oninfotv': 'oninfotv', 'infotv': 'oninfotv',
    'onechannel': 'onechannel', 'echannel': 'onechannel', 'onlife': 'onlife', 'lifetv': 'onlife',
    'htvcphim': 'htvcphimhd', 'htvcplus': 'htvcplushd', 'htvcdulich': 'htvcdulichhd', 'htvcgiadinh': 'htvcgiadinhhd',
    'htvcphunu': 'htvcphunuhd', 'htvccanhac': 'htvccanhachd',
    'nhk': 'nhkworld', 'tv5': 'tv5monde', 'dw': 'dw',
    'sctv1': 'sctv1hd', 'sctv2': 'sctv2hd', 'sctv3': 'sctv3hd', 'sctv4': 'sctv4hd', 'sctv6': 'sctv6hd',
    'sctv7': 'sctv7hd', 'sctv8': 'sctv8hd', 'sctv9': 'sctv9hd', 'sctv11': 'sctv11hd', 'sctv12': 'sctv12hd',
    'sctv13': 'sctv13hd', 'sctv14': 'sctv14hd', 'sctv15': 'sctv15hd', 'sctv16': 'sctv16hd', 'sctv17': 'sctv17hd',
    'sctv18': 'sctv18hd', 'sctv19': 'sctv19hd', 'sctv20': 'sctv20hd', 'sctv21': 'sctv21hd', 'sctv22': 'sctv22hd',
    'sctvphim': 'sctvhdpth', 'sctvphimtonghop': 'sctvhdpth', 'todaytv': 'sctv2hd',
    'spotv': 'spotv1', 'spotv1': 'spotv1', 'spotv2': 'spotv2',
    'hbo': 'hbohd', 'cinemax': 'cinemaxhd', 'axn': 'axnhd', 'discovery': 'discoveryhd', 'cartoonnetwork': 'cartoonhd',
    'cbeebies': 'cbeebies', 'bbccbeebies': 'cbeebies',
    'france24': 'france24eng', 'france24english': 'france24eng'
}

def clean_channel_title(name):
    # Remove emojis
    s = re.sub(r'[\U00010000-\U0010ffff]', '', name)
    s = re.sub(r'[\u2600-\u27bf]', '', s)
    s = re.sub(r'[\ufe00-\ufe0f]', '', s)
    # Remove Server / Update annotations
    s = re.sub(r'\s*-\s*Server\s*\d+', '', s, flags=re.I)
    s = re.sub(r'\s*Update:.*$', '', s, flags=re.I)
    s = re.sub(r'^(VTVCAB|VTC|SCTV)\s*\d*\s*[-–:]\s*', '', s, flags=re.I)
    s = re.sub(r'^(kênh|kenh)\s+', '', s, flags=re.I)
    s = re.sub(r'\s*[-|]\s*(Báo và PTTH|PTTH|TH|Truyền hình).*$', '', s, flags=re.I)
    return s.strip()

# Canonical channel store
# Key: canonical_id
channels_db = {}

def get_canonical_id(name):
    clean = clean_channel_title(name)
    norm = re.sub(r'[^a-zA-Z0-9]', '', strip_accents(clean)).lower()
    norm = re.sub(r'(hd|sd|fhd|4k)$', '', norm)
    if norm in CUSTOM_MAP:
        return CUSTOM_MAP[norm]
    for k, v in CUSTOM_MAP.items():
        if norm.startswith(k) or k.startswith(norm):
            return v
    return norm

def get_best_logo(cid, name, existing_logo=''):
    # Priority 1: epg.io.vn
    if cid.lower() in io_logos:
        return io_logos[cid.lower()]
    for a in get_aliases(name) + get_aliases(cid):
        if a in io_logos:
            return io_logos[a]
    # Priority 2: blaosolar
    if cid.lower() in blao_logos:
        return blao_logos[cid.lower()]
    for a in get_aliases(name) + get_aliases(cid):
        if a in blao_logos:
            return blao_logos[a]
    # Priority 3: Existing valid logo
    if existing_logo and existing_logo.startswith('http') and not any(e in existing_logo for e in ['404', 'undefined']):
        return existing_logo
    # Fallback
    clean_code = re.sub(r'[^a-zA-Z0-9]', '', strip_accents(name)).lower()
    return f"https://vnepg.site/logo/{clean_code}.png"

def add_stream_to_channel(name, url, category='', logo='', user_agent='', priority=50):
    url = url.strip()
    if not url or not url.startswith('http'):
        return
    # Filter known dead / blocked patterns
    if any(b in url for b in ['404.m3u8', 'offline.m3u8', 'error.m3u8']):
        return
        
    clean_name = clean_channel_title(name)
    cid = get_canonical_id(clean_name)
    cat = categorize_channel(clean_name, category)
    best_logo = get_best_logo(cid, clean_name, logo)
    
    if cid not in channels_db:
        channels_db[cid] = {
            'id': cid,
            'name': clean_name,
            'category': cat,
            'logo': best_logo,
            'streams': [] # list of (priority, url, user_agent)
        }
    else:
        # Update category if better
        if channels_db[cid]['category'] in ['Khác', 'Giải Trí'] and cat not in ['Khác', 'Giải Trí']:
            channels_db[cid]['category'] = cat
        # Update logo if current logo is not from epg.io.vn and new one is
        if 'r2.epg.io.vn' in best_logo and 'r2.epg.io.vn' not in channels_db[cid]['logo']:
            channels_db[cid]['logo'] = best_logo
            
    # Check if stream already exists
    if not any(s[1] == url for s in channels_db[cid]['streams']):
        channels_db[cid]['streams'].append((priority, url, user_agent))

# 3. Ingest vietanhtv.m3u (High priority: low latency, verified 200 OK)
print("Ingesting vietanhtv.m3u (Priority 10)...")
with open('vietanhtv.m3u', 'r', encoding='utf-8') as f:
    lines = [l.strip() for l in f if l.strip()]

cur_inf = None
cur_ua = ''
for l in lines:
    if l.startswith('#EXTINF'):
        cur_inf = l
    elif l.startswith('#EXTVLCOPT:http-user-agent='):
        cur_ua = l.split('=', 1)[1].strip()
    elif l.startswith('http') and cur_inf:
        title = cur_inf.split(',')[-1].strip()
        m_cat = re.search(r'group-title="([^"]+)"', cur_inf)
        cat = m_cat.group(1) if m_cat else ''
        m_logo = re.search(r'tvg-logo="([^"]+)"', cur_inf)
        logo = m_logo.group(1) if m_logo else ''
        add_stream_to_channel(title, l, category=cat, logo=logo, user_agent=cur_ua, priority=10)
        cur_inf = None
        cur_ua = ''

# 4. Ingest vietxiaomi.m3u (FPT Play streams - Priority 20)
print("Ingesting vietxiaomi.m3u (Priority 20)...")
with open('vietxiaomi.m3u', 'r', encoding='utf-8') as f:
    lines = [l.strip() for l in f if l.strip()]

cur_inf = None
cur_ua = ''
for l in lines:
    if l.startswith('#EXTINF'):
        cur_inf = l
    elif l.startswith('#EXTVLCOPT:http-user-agent='):
        cur_ua = l.split('=', 1)[1].strip()
    elif l.startswith('http') and cur_inf:
        title = cur_inf.split(',')[-1].strip()
        m_cat = re.search(r'group-title="([^"]+)"', cur_inf)
        cat = m_cat.group(1) if m_cat else ''
        m_logo = re.search(r'tvg-logo="([^"]+)"', cur_inf)
        logo = m_logo.group(1) if m_logo else ''
        add_stream_to_channel(title, l, category=cat, logo=logo, user_agent=cur_ua, priority=20)
        cur_inf = None
        cur_ua = ''

# 5. Ingest HTTV_MultiServer.json (Multi-server backups - Priority 30-50)
print("Ingesting HTTV_MultiServer.json (Priority 30-50)...")
with open('HTTV_MultiServer.json', 'r', encoding='utf-8') as f:
    multi_data = json.load(f)

for ch in multi_data.get('channels', []):
    name = ch.get('name', '').strip()
    cat = ch.get('category', '')
    logo = ch.get('logo', '')
    for idx, s in enumerate(ch.get('sources', [])):
        u = s.get('url', '').strip()
        ua = s.get('userAgent', '')
        prio = 30 + idx * 5
        add_stream_to_channel(name, u, category=cat, logo=logo, user_agent=ua, priority=prio)

print(f"Total merged distinct channels: {len(channels_db)}")

# 6. Build Unified Channel List (1 entry per channel, failover URLs joined with |)
CAT_ORDER = {
    "VTV": 1,
    "HTV": 2,
    "SCTV": 3,
    "VTVcab / Giải Trí": 4,
    "Địa Phương": 5,
    "Phim Truyện": 6,
    "Thiếu Nhi & Khám Phá": 7,
    "Thể Thao": 8,
    "Bóng Đá Trực Tiếp": 9,
    "Quốc Tế": 10,
    "Radio": 11,
    "Khác": 12
}

playlist_items = []
for cid, ch in channels_db.items():
    streams = ch['streams']
    if not streams:
        continue
    # Sort streams by priority (lowest number = highest priority)
    streams.sort(key=lambda x: x[0])
    
    # Pick top up to 4 unique stream URLs
    unique_urls = []
    uas = []
    for prio, u, ua in streams:
        if u not in unique_urls:
            unique_urls.append(u)
            if ua: uas.append(ua)
        if len(unique_urls) >= 4:
            break
            
    merged_url = "|".join(unique_urls)
    best_ua = uas[0] if uas else ""
    
    playlist_items.append({
        'tvg_id': ch['id'],
        'tvg_name': ch['name'],
        'tvg_logo': ch['logo'],
        'group_title': ch['category'],
        'title': ch['name'],
        'url': merged_url,
        'user_agent': best_ua
    })

# Sort playlist items by CAT_ORDER then title
playlist_items.sort(key=lambda x: (CAT_ORDER.get(x['group_title'], 99), x['title']))

# 7. Generate M3U file
m3u_lines = ['#EXTM3U url-tvg="https://epg.io.vn/epg.xml, https://epg.blaosolar.vn/schedule/epg.xml"\n']

for item in playlist_items:
    m3u_lines.append(f'#EXTINF:-1 tvg-id="{item["tvg_id"]}" tvg-name="{item["tvg_name"]}" tvg-logo="{item["tvg_logo"]}" group-title="{item["group_title"]}",{item["title"]}\n')
    if item['user_agent']:
        m3u_lines.append(f'#EXTVLCOPT:http-user-agent={item["user_agent"]}\n')
    m3u_lines.append(f'{item["url"]}\n')

# Write output files
destinations = [
    'httv_playlist.m3u',
    'okplayer_apktool/assets/httv_playlist.m3u',
    'HTTV-App/app/src/main/assets/httv_playlist.m3u',
    'HTTV-App/playlist.m3u'
]

for dest in destinations:
    os.makedirs(os.path.dirname(os.path.abspath(dest)), exist_ok=True)
    with open(dest, 'w', encoding='utf-8') as f:
        f.writelines(m3u_lines)
    print(f"Written -> {dest}")

print(f"\nSUCCESS! Generated {len(playlist_items)} unified channels (each with merged backup servers)!")
counts = Counter(x['group_title'] for x in playlist_items)
for cat, cnt in sorted(counts.items(), key=lambda x: CAT_ORDER.get(x[0], 99)):
    print(f"  {CAT_ORDER.get(cat, 99):2d}. [{cat}]: {cnt} channels")
