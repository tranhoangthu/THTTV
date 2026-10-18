package com.tvstore.ok;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.tvprovider.media.tv.Channel;
import androidx.tvprovider.media.tv.ChannelLogoUtils;
import androidx.tvprovider.media.tv.PreviewProgram;
import androidx.tvprovider.media.tv.TvContractCompat;
import androidx.tvprovider.media.tv.WatchNextProgram;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class TvHomeManager {
    public static final TvHomeManager INSTANCE = new TvHomeManager();
    private static final String TAG = "TvHomeManager";

    public static final String CHANNEL_RECENT = "thttv_recent";
    public static final String CHANNEL_VTV = "thttv_vtv";
    public static final String CHANNEL_SPORTS = "thttv_sports";
    public static final String CHANNEL_LOCAL = "thttv_local";

    private TvHomeManager() {}

    public void updateHomeChannels(final Context context) {
        if (context == null) return;
        new Thread(new Runnable() {
            @Override
            public void run() {
                TvHomeManager.this.doUpdate(context);
            }
        }).start();
    }

    private void doUpdate(Context context) {
        try {
            List<Movie> allMovies = MovieList.INSTANCE.getMovies();
            if (allMovies == null || allMovies.isEmpty()) {
                Log.d(TAG, "Movies chưa được tải, bỏ qua cập nhật home screen");
                return;
            }

            // 1. Dọn dẹp triệt để các kênh zombie/trùng lặp cũ
            cleanZombieAndDuplicateChannels(context);

            // 2. Kênh "Xem gần đây"
            List<Movie> recentList = new ArrayList<>(MovieList.INSTANCE.getHistoryMovies());
            if (recentList.isEmpty()) {
                for (int i = 0; i < Math.min(30, allMovies.size()); i++) {
                    recentList.add(allMovies.get(i));
                }
            } else if (recentList.size() > 30) {
                recentList = recentList.subList(0, 30);
            }
            long recentChId = getOrCreateChannel(context, CHANNEL_RECENT, "Xem gần đây");
            if (recentChId > 0) {
                updatePreviewPrograms(context, recentChId, recentList);
            }

            // 3. Kênh "VTV"
            List<Movie> vtvList = new ArrayList<>();
            for (Movie m : allMovies) {
                String cat = m.getCategory();
                String title = m.getTitle();
                boolean isVtv = (cat != null && cat.equalsIgnoreCase("VTV")) ||
                                (title != null && title.toUpperCase().contains("VTV"));
                if (isVtv) {
                    vtvList.add(m);
                    if (vtvList.size() >= 35) break;
                }
            }
            long vtvChId = getOrCreateChannel(context, CHANNEL_VTV, "VTV");
            if (vtvChId > 0) {
                updatePreviewPrograms(context, vtvChId, vtvList);
            }

            // 4. Kênh "Thể thao"
            List<Movie> sportsList = new ArrayList<>();
            for (Movie m : allMovies) {
                String cat = m.getCategory() != null ? m.getCategory().toLowerCase() : "";
                String title = m.getTitle() != null ? m.getTitle().toLowerCase() : "";
                boolean isSports = cat.contains("thể thao") || cat.contains("thao") || cat.contains("⚽") ||
                                   cat.contains("cola") || cat.contains("gà vàng") || cat.contains("khán đài") ||
                                   cat.contains("xôi chè") || title.contains("sports") || title.contains("sport") ||
                                   title.contains("bóng đá") || title.contains("k+");
                if (isSports) {
                    sportsList.add(m);
                    if (sportsList.size() >= 35) break;
                }
            }
            long sportsChId = getOrCreateChannel(context, CHANNEL_SPORTS, "Thể thao");
            if (sportsChId > 0) {
                updatePreviewPrograms(context, sportsChId, sportsList);
            }

            // 5. Kênh "Địa phương"
            List<Movie> localList = new ArrayList<>();
            for (Movie m : allMovies) {
                String cat = m.getCategory() != null ? m.getCategory().toLowerCase() : "";
                if (cat.contains("địa phương") || cat.contains("tỉnh")) {
                    localList.add(m);
                    if (localList.size() >= 45) break;
                }
            }
            long localChId = getOrCreateChannel(context, CHANNEL_LOCAL, "Địa phương");
            if (localChId > 0) {
                updatePreviewPrograms(context, localChId, localList);
            }

            Log.d(TAG, "Home screen update complete with 4 distinct channels");
        } catch (Exception e) {
            Log.e(TAG, "Home screen update failed", e);
        }
    }

    private void cleanZombieAndDuplicateChannels(Context context) {
        try {
            Cursor cursor = context.getContentResolver().query(
                TvContractCompat.Channels.CONTENT_URI,
                new String[]{"_id", "internal_provider_id", "display_name"},
                null,
                null,
                null
            );
            if (cursor != null) {
                Set<String> validIds = new HashSet<>();
                validIds.add(CHANNEL_RECENT);
                validIds.add(CHANNEL_VTV);
                validIds.add(CHANNEL_SPORTS);
                validIds.add(CHANNEL_LOCAL);

                Set<String> seenIds = new HashSet<>();
                while (cursor.moveToNext()) {
                    long id = cursor.getLong(0);
                    String pid = cursor.getString(1);
                    String name = cursor.getString(2);

                    boolean isZombie = pid == null || !validIds.contains(pid) ||
                                       "ok_main_channel".equals(pid) || "HTTV".equals(name);
                    boolean isDup = pid != null && seenIds.contains(pid);

                    if (isZombie || isDup) {
                        try {
                            context.getContentResolver().delete(
                                ContentUris.withAppendedId(TvContractCompat.Channels.CONTENT_URI, id),
                                null,
                                null
                            );
                            Log.d(TAG, "Đã xóa kênh zombie/trùng: id=" + id + ", name=" + name + ", pid=" + pid);
                        } catch (Exception ignored) {}
                    } else {
                        seenIds.add(pid);
                    }
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(TAG, "Lỗi dọn dẹp kênh zombie", e);
        }
    }

    private long getOrCreateChannel(Context context, String internalId, String displayName) {
        try {
            Cursor cursor = context.getContentResolver().query(
                TvContractCompat.Channels.CONTENT_URI,
                new String[]{"_id", "browsable"},
                "internal_provider_id = ?",
                new String[]{internalId},
                null
            );
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        long id = cursor.getLong(0);
                        int browsable = cursor.getInt(1);
                        Log.d(TAG, "Channel đã tồn tại: " + displayName + ", id=" + id);
                        if (browsable == 0) {
                            try {
                                TvContractCompat.requestChannelBrowsable(context, id);
                            } catch (Exception ignored) {}
                        }
                        return id;
                    }
                } finally {
                    cursor.close();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Lỗi truy vấn channel: " + internalId, e);
        }

        try {
            Channel.Builder builder = new Channel.Builder()
                .setType(TvContractCompat.Channels.TYPE_PREVIEW)
                .setDisplayName(displayName)
                .setAppLinkIntentUri(Uri.parse("ok://home"))
                .setInternalProviderId(internalId);

            Uri uri = context.getContentResolver().insert(
                TvContractCompat.Channels.CONTENT_URI,
                builder.build().toContentValues()
            );
            long parseId = uri != null ? ContentUris.parseId(uri) : -1L;
            if (parseId > 0) {
                Log.d(TAG, "Channel mới được tạo: " + displayName + ", id=" + parseId);
                try {
                    ChannelLogoUtils.storeChannelLogo(
                        context,
                        parseId,
                        Uri.parse("android.resource://" + context.getPackageName() + "/" + R.mipmap.ic_launcher)
                    );
                } catch (Exception ignored) {}
                try {
                    TvContractCompat.requestChannelBrowsable(context, parseId);
                } catch (Exception ignored) {}
            }
            return parseId;
        } catch (Exception e) {
            Log.e(TAG, "Lỗi tạo channel: " + displayName, e);
            return -1L;
        }
    }

    private void updatePreviewPrograms(Context context, long channelId, List<Movie> list) {
        try {
            int deleted = context.getContentResolver().delete(
                TvContractCompat.PreviewPrograms.CONTENT_URI,
                "channel_id = ?",
                new String[]{String.valueOf(channelId)}
            );
            Log.d(TAG, "Đã xóa " + deleted + " preview programs cũ trên channel " + channelId);
        } catch (Exception e) {
            Log.e(TAG, "Lỗi xóa preview programs cũ", e);
        }

        if (list == null || list.isEmpty()) return;

        Log.d(TAG, "Chuẩn bị thêm " + list.size() + " preview programs cho channel " + channelId);
        for (Movie movie : list) {
            try {
                String videoUrl = movie.getVideoUrl();
                if (videoUrl != null && (videoUrl.startsWith("content://") || videoUrl.startsWith("file://"))) {
                    continue;
                }

                Intent intent = new Intent(context, PlaybackActivity.class);
                intent.putExtra(DetailsActivity.MOVIE, (Serializable) movie);
                intent.putExtra("movie_url", movie.getVideoUrl());
                intent.putExtra("movie_id", movie.getId());
                intent.putExtra("movie_title", movie.getTitle());
                intent.putExtra("movie_ua", movie.getUserAgent());
                intent.putExtra("movie_drm_type", movie.getDrmType());
                intent.putExtra("movie_drm_url", movie.getDrmLicenseUrl());
                intent.putExtra("movie_clearkey", movie.getClearKey());
                intent.putExtra("movie_referrer", movie.getReferrer());
                intent.putExtra("movie_category", movie.getCategory());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);

                String title = movie.getTitle();
                if (title == null || title.isEmpty()) {
                    title = "Kênh không tên";
                }
                String category = movie.getCategory();
                if (category == null) {
                    category = "";
                }

                PreviewProgram.Builder builder = new PreviewProgram.Builder()
                    .setChannelId(channelId)
                    .setType(6)
                    .setTitle(title)
                    .setDescription(category)
                    .setIntentUri(Uri.parse(intent.toUri(1)))
                    .setInternalProviderId(String.valueOf(movie.getId()))
                    .setLive(true);

                String cardImageUrl = movie.getCardImageUrl();
                if (cardImageUrl != null && !cardImageUrl.isEmpty()) {
                    builder.setPosterArtUri(Uri.parse(cardImageUrl));
                }

                context.getContentResolver().insert(
                    TvContractCompat.PreviewPrograms.CONTENT_URI,
                    builder.build().toContentValues()
                );
            } catch (Exception e) {
                Log.e(TAG, "Lỗi thêm preview program: " + movie.getTitle(), e);
            }
        }
    }
}
