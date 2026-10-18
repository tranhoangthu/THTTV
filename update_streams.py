import os
import sys
import urllib.request
import ssl

sys.stdout.reconfigure(encoding='utf-8')

ctx = ssl.create_default_context()
ctx.check_hostname = False
ctx.verify_mode = ssl.CERT_NONE

HEADERS = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36'
}

def download_file(url, out_path):
    print(f"Downloading {url} -> {out_path}...")
    try:
        req = urllib.request.Request(url, headers=HEADERS)
        with urllib.request.urlopen(req, timeout=20, context=ctx) as resp:
            content = resp.read()
            with open(out_path, 'wb') as f:
                f.write(content)
        print(f"  Success: {len(content)} bytes")
        return True
    except Exception as e:
        print(f"  Failed: {e}")
        return False

# 1. Update VietAnhTV live streams
download_file('https://tv.vietanhtv.top/tivi/index.php?u=tranhoangthu&p=hoangthu@2008', 'vietanhtv.m3u')

# 2. Update VietXiaomi streams
download_file('https://raw.githubusercontent.com/vietng228/ximaotv/refs/heads/main/vietxiaomi.m3u', 'vietxiaomi.m3u')

# 3. Update EPG IO & Blaosolar if needed
if not os.path.exists('epg_io.xml') or os.path.getsize('epg_io.xml') < 10000:
    download_file('https://epg.io.vn/epg.xml', 'epg_io.xml')

if not os.path.exists('epg_blaosolar.xml') or os.path.getsize('epg_blaosolar.xml') < 10000:
    download_file('https://epg.blaosolar.vn/schedule/epg.xml', 'epg_blaosolar.xml')

# 4. Rebuild unified playlist
import build_httv_playlist
print("Playlist update completed successfully!")
