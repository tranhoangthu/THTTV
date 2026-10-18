package com.tvstore.ok;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.ExoPlayer;
import java.util.ArrayList;
import java.util.List;

public final class StreamFailoverManager {
    public static String currentUrl = "";
    public static int serverIndex = 0;
    public static List<String> serverList = null;

    public static void initChannel(String str) {
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
            if (!trim.isEmpty()) {
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

    public static boolean tryNextServer(Context context, ExoPlayer exoPlayer) {
        List<String> list = serverList;
        if (list == null || exoPlayer == null || serverIndex + 1 >= list.size()) {
            return false;
        }
        int i = serverIndex + 1;
        serverIndex = i;
        String str = serverList.get(i);
        if (context != null) {
            Toast.makeText(context, "Đổi sang server dự phòng (" + (serverIndex + 1) + "/" + serverList.size() + ")...", 0).show();
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
        return true;
    }
}
