package com.tvstore.ok;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.tvprovider.media.tv.Channel;
import androidx.tvprovider.media.tv.ChannelLogoUtils;
import androidx.tvprovider.media.tv.PreviewProgram;
import androidx.tvprovider.media.tv.TvContractCompat;
import androidx.tvprovider.media.tv.WatchNextProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TvHomeManager.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0003J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0003J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fH\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tvstore/ok/TvHomeManager;", "", "<init>", "()V", "TAG", "", "CHANNEL_INTERNAL_ID", "updateHomeChannels", "", "context", "Landroid/content/Context;", "getOrCreateChannel", "", "updatePreviewPrograms", "channelId", "updateWatchNext", "publishToWatchNext", "movie", "Lcom/tvstore/ok/Movie;", "type", "", "timeMs", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TvHomeManager {
    private static final String CHANNEL_INTERNAL_ID = "ok_main_channel";
    public static final TvHomeManager INSTANCE = new TvHomeManager();
    private static final String TAG = "TvHomeManager";

    private TvHomeManager() {
    }

    public final void updateHomeChannels(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        new Thread(new Runnable() { // from class: com.tvstore.ok.TvHomeManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TvHomeManager.updateHomeChannels$lambda$0(context);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void updateHomeChannels$lambda$0(Context context) {
        try {
            if (MovieList.INSTANCE.getMovies().isEmpty()) {
                Log.d(TAG, "Movies chưa được tải, bỏ qua cập nhật home screen");
                return;
            }
            TvHomeManager tvHomeManager = INSTANCE;
            long orCreateChannel = tvHomeManager.getOrCreateChannel(context);
            if (orCreateChannel <= 0) {
                Log.e(TAG, "Không thể tạo/lấy channel ID");
            } else {
                tvHomeManager.updatePreviewPrograms(context, orCreateChannel);
                Log.d(TAG, "Preview programs cập nhật thành công, channelId=" + orCreateChannel);
            }
            tvHomeManager.updateWatchNext(context);
            Log.d(TAG, "Home screen update complete");
        } catch (Exception e) {
            Log.e(TAG, "Home screen update failed", e);
        }
    }

    private final long getOrCreateChannel(Context context) {
        try {
            Cursor query = context.getContentResolver().query(TvContractCompat.Channels.CONTENT_URI, new String[]{"_id", "browsable"}, "internal_provider_id = ?", new String[]{CHANNEL_INTERNAL_ID}, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst()) {
                        long j = cursor2.getLong(0);
                        int i = cursor2.getInt(1);
                        Log.d(TAG, "Channel đã tồn tại: id=" + j + ", browsable=" + i);
                        if (i == 0) {
                            try {
                                TvContractCompat.requestChannelBrowsable(context, j);
                                Log.d(TAG, "Đã yêu cầu browsable cho channel " + j);
                            } catch (Exception e) {
                                Log.e(TAG, "Lỗi yêu cầu browsable", e);
                            }
                        }
                        CloseableKt.closeFinally(cursor, null);
                        return j;
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
        } catch (Exception e2) {
            Log.e(TAG, "Lỗi truy vấn channel", e2);
        }
        Channel.Builder displayName = new Channel.Builder().setType(TvContractCompat.Channels.TYPE_PREVIEW).setDisplayName("XemTV24H - OkPlayer");
        Uri parse = Uri.parse("ok://home");
        Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
        try {
            Uri insert = context.getContentResolver().insert(TvContractCompat.Channels.CONTENT_URI, displayName.setAppLinkIntentUri(parse).setInternalProviderId(CHANNEL_INTERNAL_ID).build().toContentValues());
            long parseId = insert != null ? ContentUris.parseId(insert) : -1L;
            if (parseId > 0) {
                Log.d(TAG, "Channel mới được tạo: id=" + parseId);
                try {
                    ChannelLogoUtils.storeChannelLogo(context, parseId, Uri.parse("android.resource://" + context.getPackageName() + "/" + R.mipmap.ic_launcher));
                } catch (Exception e3) {
                    Log.e(TAG, "Lỗi set logo", e3);
                }
                try {
                    TvContractCompat.requestChannelBrowsable(context, parseId);
                    Log.d(TAG, "Đã yêu cầu browsable cho channel mới " + parseId);
                } catch (Exception e4) {
                    Log.e(TAG, "Không thể yêu cầu quyền hiển thị kênh", e4);
                }
            }
            return parseId;
        } catch (Exception e5) {
            Log.e(TAG, "Lỗi tạo channel", e5);
            return -1L;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updatePreviewPrograms(Context context, long channelId) {
        try {
            Log.d(TAG, "Đã xóa " + context.getContentResolver().delete(TvContractCompat.PreviewPrograms.CONTENT_URI, "channel_id = ?", new String[]{String.valueOf(channelId)}) + " preview programs cũ");
        } catch (Exception e) {
            Log.e(TAG, "Lỗi xóa preview programs cũ", e);
        }
        List<Movie> favoriteMovies = MovieList.INSTANCE.getFavoriteMovies();
        ArrayList arrayList = new ArrayList();
        for (Object obj : favoriteMovies) {
            Movie movie = (Movie) obj;
            String videoUrl = movie.getVideoUrl();
            if (!(videoUrl != null ? StringsKt.startsWith$default(videoUrl, "content://", false, 2, (Object) null) : false)) {
                String videoUrl2 = movie.getVideoUrl();
                if (!(videoUrl2 != null ? StringsKt.startsWith$default(videoUrl2, "file://", false, 2, (Object) null) : false)) {
                    arrayList.add(obj);
                }
            }
        }
        List take = CollectionsKt.take(arrayList, 10);
        if (take.isEmpty()) {
            take = CollectionsKt.take(MovieList.INSTANCE.getMovies(), 10);
        }
        List<Movie> list = take;
        Log.d(TAG, "Chuẩn bị thêm " + list.size() + " preview programs");
        for (Movie movie2 : list) {
            try {
                Intent intent = new Intent(context, (Class<?>) PlaybackActivity.class);
                intent.putExtra(DetailsActivity.MOVIE, movie2);
                intent.putExtra("movie_url", movie2.getVideoUrl());
                intent.putExtra("movie_id", movie2.getId());
                intent.putExtra("movie_title", movie2.getTitle());
                intent.putExtra("movie_ua", movie2.getUserAgent());
                intent.putExtra("movie_drm_type", movie2.getDrmType());
                intent.putExtra("movie_drm_url", movie2.getDrmLicenseUrl());
                intent.putExtra("movie_clearkey", movie2.getClearKey());
                intent.putExtra("movie_referrer", movie2.getReferrer());
                intent.putExtra("movie_category", movie2.getCategory());
                intent.addFlags(268468224);
                PreviewProgram.Builder type = new PreviewProgram.Builder().setChannelId(channelId).setType(6);
                String title = movie2.getTitle();
                if (title == null) {
                    title = "Kênh không tên";
                }
                PreviewProgram.Builder builder = (PreviewProgram.Builder) type.setTitle(title);
                String category = movie2.getCategory();
                if (category == null) {
                    category = "";
                }
                PreviewProgram.Builder builder2 = (PreviewProgram.Builder) builder.setDescription(category);
                String uri = intent.toUri(1);
                Intrinsics.checkNotNullExpressionValue(uri, "toUri(...)");
                Uri parse = Uri.parse(uri);
                Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
                PreviewProgram.Builder live = builder2.setIntentUri(parse).setInternalProviderId(String.valueOf(movie2.getId())).setLive(true);
                String cardImageUrl = movie2.getCardImageUrl();
                if (cardImageUrl != null) {
                    if (cardImageUrl.length() <= 0) {
                        cardImageUrl = null;
                    }
                    if (cardImageUrl != null) {
                        Uri parse2 = Uri.parse(cardImageUrl);
                        Intrinsics.checkNotNullExpressionValue(parse2, "parse(this)");
                    }
                }
                context.getContentResolver().insert(TvContractCompat.PreviewPrograms.CONTENT_URI, live.build().toContentValues());
            } catch (Exception e2) {
                Log.e(TAG, "Lỗi thêm preview program: " + movie2.getTitle(), e2);
            }
        }
    }

    private final void updateWatchNext(Context context) {
        int i = 0;
        try {
            Cursor query = context.getContentResolver().query(TvContractCompat.WatchNextPrograms.CONTENT_URI, new String[]{"_id"}, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    while (cursor2.moveToNext()) {
                        try {
                            context.getContentResolver().delete(TvContractCompat.buildWatchNextProgramUri(cursor2.getLong(0)), null, null);
                        } catch (Exception unused) {
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Lỗi xóa Watch Next cũ", e);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - 1000000;
        int i2 = 0;
        for (Object obj : CollectionsKt.reversed(CollectionsKt.take(MovieList.INSTANCE.getHistoryMovies(), 5))) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Movie movie = (Movie) obj;
            if (!MovieList.INSTANCE.isFavorite(movie)) {
                INSTANCE.publishToWatchNext(context, movie, 0, j + (i2 * 1000));
            }
            i2 = i3;
        }
        List<Movie> favoriteMovies = MovieList.INSTANCE.getFavoriteMovies();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : favoriteMovies) {
            Movie movie2 = (Movie) obj2;
            String videoUrl = movie2.getVideoUrl();
            if (!(videoUrl != null ? StringsKt.startsWith$default(videoUrl, "content://", false, 2, (Object) null) : false)) {
                String videoUrl2 = movie2.getVideoUrl();
                if (!(videoUrl2 != null ? StringsKt.startsWith$default(videoUrl2, "file://", false, 2, (Object) null) : false)) {
                    arrayList.add(obj2);
                }
            }
        }
        for (Object obj3 : CollectionsKt.reversed(CollectionsKt.take(arrayList, 5))) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            INSTANCE.publishToWatchNext(context, (Movie) obj3, 3, (currentTimeMillis - 500000) + (i * 1000));
            i = i4;
        }
        Log.d(TAG, "Watch Next updated: Favorites first, then History");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void publishToWatchNext(Context context, Movie movie, int type, long timeMs) {
        try {
            Intent intent = new Intent(context, (Class<?>) PlaybackActivity.class);
            intent.putExtra(DetailsActivity.MOVIE, movie);
            intent.putExtra("movie_url", movie.getVideoUrl());
            intent.putExtra("movie_id", movie.getId());
            intent.putExtra("movie_title", movie.getTitle());
            intent.putExtra("movie_ua", movie.getUserAgent());
            intent.putExtra("movie_drm_type", movie.getDrmType());
            intent.putExtra("movie_drm_url", movie.getDrmLicenseUrl());
            intent.putExtra("movie_clearkey", movie.getClearKey());
            intent.putExtra("movie_referrer", movie.getReferrer());
            intent.putExtra("movie_category", movie.getCategory());
            intent.addFlags(268468224);
            WatchNextProgram.Builder type2 = new WatchNextProgram.Builder().setWatchNextType(type).setType(6);
            String title = movie.getTitle();
            if (title == null) {
                title = "Kênh không tên";
            }
            WatchNextProgram.Builder builder = (WatchNextProgram.Builder) type2.setTitle(title);
            String category = movie.getCategory();
            if (category == null) {
                category = "";
            }
            WatchNextProgram.Builder builder2 = (WatchNextProgram.Builder) builder.setDescription("Kênh: " + category);
            String uri = intent.toUri(1);
            Intrinsics.checkNotNullExpressionValue(uri, "toUri(...)");
            Uri parse = Uri.parse(uri);
            Intrinsics.checkNotNullExpressionValue(parse, "parse(this)");
            WatchNextProgram.Builder intentUri = builder2.setIntentUri(parse);
            long id = movie.getId();
            String videoUrl = movie.getVideoUrl();
            WatchNextProgram.Builder browsable = intentUri.setInternalProviderId("ok_" + id + "_" + (videoUrl != null ? videoUrl.hashCode() : 0)).setLastEngagementTimeUtcMillis(timeMs).setBrowsable(true);
            String cardImageUrl = movie.getCardImageUrl();
            if (cardImageUrl != null) {
                if (cardImageUrl.length() <= 0) {
                    cardImageUrl = null;
                }
                if (cardImageUrl != null) {
                    Uri parse2 = Uri.parse(cardImageUrl);
                    Intrinsics.checkNotNullExpressionValue(parse2, "parse(this)");
                }
            }
            context.getContentResolver().insert(TvContractCompat.WatchNextPrograms.CONTENT_URI, browsable.build().toContentValues());
        } catch (Exception e) {
            Log.e(TAG, "Lỗi khi chèn kênh vào hàng Watch Next: " + movie.getTitle(), e);
        }
    }
}
