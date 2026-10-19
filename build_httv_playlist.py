import os
import sys

sys.stdout.reconfigure(encoding='utf-8')

root_dir = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
admin_dir = os.path.join(root_dir, 'THTTV-Admin')
sys.path.insert(0, admin_dir)

import server_manager

if __name__ == '__main__':
    print("=" * 60)
    print("  THT TV - BỘ TẠO PLAYLIST ĐA MÁY CHỦ (MULTI-SERVER)")
    print("  Ưu tiên: SERVER 3 (VMT TV) + TVPlus + VietPlay KTV")
    print("=" * 60)
    
    res = server_manager.generate_unified_playlist()
    
    print(f"\n[OK] Đã tạo thành công {res['totalChannels']} kênh truyền hình!")
    print(f"[*] Máy chủ ưu tiên số 1 (Primary): {res['primaryServer']}")
    print(f"[*] Thứ tự ưu tiên máy chủ: {res['priority']}")
    print("\n[*] Danh sách tệp đã cập nhật:")
    for f in res['writtenFiles']:
        print(f"    -> {f}")
    print("\nHoàn tất!")
