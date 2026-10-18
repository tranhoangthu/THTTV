package com.tvstore.ok;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.ArrayList;
import java.util.List;

public final class StreamFailoverManager {
    public static String currentUrl = "";
    public static int serverIndex = 0;
    public static List<String> serverList = null;

    private static final long TIMEOUT_MS = 3500;
    private static Handler watchdogHandler = null;
    private static Runnable watchdogRunnable = null;

    public static void initChannel(String str) {
        cancelTimeout();
        if (str == null) {
            str = "";
        }
        if (str.equals(currentUrl)) {
            return;
        }
        currentUrl = str;
        serverIndex = 0;
        String[] split = str.split("\\|");
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            String trim = str2.trim();
            if (!trim.isEmpty() && !trim.contains("404.m3u8")) {
                arrayList.add(trim);
            }
        }
        serverList = arrayList;
    }

    public static String getCurrentStreamUrl(String str) {
        initChannel(str);
        List<String> list = serverList;
        return (list == null || serverIndex >= list.size()) ? str : serverList.get(serverIndex);
    }

    public static void onBuffering(final Context context, final ExoPlayer exoPlayer) {
        if (serverList == null || serverList.size() <= 1 || exoPlayer == null) {
            return;
        }
        cancelTimeout();
        if (watchdogHandler == null) {
            watchdogHandler = new Handler(Looper.getMainLooper());
        }
        watchdogRunnable = new Runnable() {
            @Override
            public void run() {
                tryNextServer(context, exoPlayer);
            }
        };
        watchdogHandler.postDelayed(watchdogRunnable, TIMEOUT_MS);
    }

    public static void onPlaybackReady() {
        cancelTimeout();
    }

    public static void cancelTimeout() {
        if (watchdogHandler != null && watchdogRunnable != null) {
            watchdogHandler.removeCallbacks(watchdogRunnable);
            watchdogRunnable = null;
        }
    }

    public static boolean tryNextServer(Context context, ExoPlayer exoPlayer) {
        cancelTimeout();
        List<String> list = serverList;
        if (list == null || exoPlayer == null || serverIndex + 1 >= list.size()) {
            return false;
        }
        int i = serverIndex + 1;
        serverIndex = i;
        String str = serverList.get(i);
        if (context != null) {
            Toast.makeText(context, "Đổi sang server dự phòng (" + (serverIndex + 1) + "/" + serverList.size() + ")...", Toast.LENGTH_SHORT).show();
        }
        MediaItem.Builder uri = new MediaItem.Builder().setUri(Uri.parse(str));
        if (str.toLowerCase().contains(".mpd")) {
            uri.setMimeType("application/dash+xml");
        } else {
            uri.setMimeType("application/x-mpegURL");
        }
        exoPlayer.setMediaItem(uri.build());
        exoPlayer.prepare();
        exoPlayer.setPlayWhenReady(true);
        onBuffering(context, exoPlayer);
        return true;
    }
}

