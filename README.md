# HTTV - Ứng Dụng Xem Truyền Hình Đa Nền Tảng (Android TV & Mobile)

<p align="center">
  <img src="logos/tv_banner.png" alt="HTTV Banner" width="480">
</p>

**HTTV** là ứng dụng xem truyền hình trực tuyến bản địa (Native Android Leanback & Touch UI), hỗ trợ hoàn hảo cho cả **Android TV, TV Box** và **Điện thoại Android**.

---

## 🌟 Tính Năng Nổi Bật

- **Giao diện thuần Android TV (Google TV Leanback)**:
  - Thiết kế thẻ bài (Card Grid) đẹp mắt, trực quan, hỗ trợ Remote D-pad 100%.
  - Tự động nhận diện thiết bị TV hoặc Điện thoại để hiển thị giao diện tối ưu nhất.
- **Hệ Thống Lịch Phát Sóng (EPG) & Kho Logo Blaosolar Tối Ưu**:
  - Tích hợp trực tiếp nguồn EPG chuẩn tốc độ cao: `https://epg.blaosolar.vn/schedule/epg.xml`.
  - Hiển thị đầy đủ lịch phát sóng trực tiếp (tên chương trình hiện tại, sắp phát, mô tả chi tiết).
  - Tích hợp kho logo chuẩn HD từ hệ thống CDN Blaosolar (`https://image*.blaosolar.vn/logo/...`), tải cực nhanh và sắc nét.
- **Tự động Đôn Số Kênh Khi Ẩn Nhóm**:
  - Khi ẩn bớt danh mục kênh trong mục *Cài đặt > Ẩn/Hiện nhóm kênh*, toàn bộ số thứ tự các kênh hiển thị sẽ tự động đôn lên liên tục (1, 2, 3...) không bị nhảy số hay ngắt quãng.
  - Nhập số kênh trực tiếp trên Remote TV (ví dụ bấm `1`, `2`, `5`) sẽ tự động chuyển đúng vào kênh hiển thị.
- **Tách Biệt Nhóm Thể Thao, Bóng Đá Trực Tiếp & Radio Chuyên Biệt**:
  - Danh mục **Thể Thao**: Tổng hợp tất cả các kênh thể thao trong nước và quốc tế (ON Sports, SPOTV, TV360 Thể Thao...).
  - Danh mục **Bóng Đá Trực Tiếp**: Các luồng phát trực tiếp các trận đấu đỉnh cao (Ngoại Hạng Anh, C1, La Liga, V-League...).
  - Danh mục **Radio**: Tổng hợp đầy đủ các kênh VOV, VOH, ZingRadio đài phát thanh toàn quốc.
- **Hỗ Trợ Đa Server Mượt Mà (Server 1, Server 2...)**:
  - Mỗi kênh tích hợp các nguồn dự phòng được gắn nhãn `Server 1`, `Server 2`, `Server 3` (không hiển thị tên nhà cung cấp) giúp dễ dàng chuyển đổi khi một đường truyền gặp sự cố.
  - Tích hợp sẵn playlist offline bên trong ứng dụng (`assets/httv_playlist.m3u`) - mở app là xem ngay không cần chờ mạng tải danh sách.
  - Đồng bộ trực tiếp từ GitHub repository: `https://raw.githubusercontent.com/tranhoangthu/HTTV/main/playlist.m3u`.
- **Trình Phát Đa Năng (ExoPlayer)**:
  - Hỗ trợ m3u8 (HLS), mpd (DASH), ClearKey DRM, chuyển kênh siêu tốc, điều chỉnh tỷ lệ khung hình, tua tiến/lùi nhanh.

---

## 📱 Cài Đặt Ứng Dụng

File cài đặt APK đã được build hoàn chỉnh và ký số:
👉 **[Tải file HTTV.apk](release/HTTV.apk)**

### Hướng dẫn cài trên Android TV:
1. Tải file `HTTV.apk` chép vào USB.
2. Cắm USB vào Android TV / TV Box.
3. Dùng ứng dụng quản lý file (File Commander, X-plore...) mở file `HTTV.apk` và chọn **Cài đặt**.
4. Mở ứng dụng **HTTV** và thưởng thức!

---

## 🛠 Cấu Trúc Dự Án

```
HTTV/
├── app/
│   ├── src/main/
│   │   ├── java/com/tvstore/ok/   # Mã nguồn Native Kotlin/Java
│   │   ├── res/                   # Giao diện XML, Drawables, Mipmaps
│   │   ├── assets/                # Playlist tích hợp offline
│   │   └── AndroidManifest.xml    # Cấu hình đa nền tảng TV & Mobile
├── logos/                         # Bộ nhận diện thương hiệu HTTV
├── release/                       # File APK hoàn chỉnh sẵn sàng sử dụng
├── playlist.m3u                   # Danh sách kênh trực tuyến chính
└── README.md
```

---
*Phát triển và bảo trì bởi tranhoangthu.*
