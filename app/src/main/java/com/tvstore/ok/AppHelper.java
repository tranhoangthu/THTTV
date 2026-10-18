package com.tvstore.ok;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class AppHelper {
    private static final String TAG = "AppHelper";
    public static final String PLAYLIST_URL = "https://raw.githubusercontent.com/tranhoangthu/HTTV/main/playlist.m3u";

    public static void checkAutoPlayLastChannel(Fragment fragment) {
        try {
            if (fragment == null || !fragment.isAdded()) return;
            MovieList movieList = MovieList.INSTANCE;
            if (movieList.isStartup()) {
                movieList.setStartup(false);
                List<Movie> history = movieList.getHistoryMovies();
                if (history != null && !history.isEmpty()) {
                    Movie lastMovie = history.get(0);
                    if (lastMovie != null) {
                        Activity activity = fragment.getActivity();
                        if (activity != null) {
                            Log.d(TAG, "Tự động mở kênh cuối: " + lastMovie.getTitle());
                            Intent intent = new Intent(activity, PlaybackActivity.class);
                            intent.putExtra(DetailsActivity.MOVIE, (Serializable) lastMovie);
                            fragment.startActivity(intent);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in checkAutoPlayLastChannel", e);
        }
    }

    public static void downloadLatestPlaylist(final Context context, final Runnable onDone) {
        if (context == null) return;
        new Thread(new Runnable() {
            @Override
            public void run() {
                boolean success = false;
                try {
                    URL url = new URL(PLAYLIST_URL);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(8000);
                    conn.setReadTimeout(12000);
                    conn.setRequestProperty("User-Agent", "Mozilla/5.0");
                    conn.connect();
                    if (conn.getResponseCode() == 200) {
                        File targetFile = new File(context.getFilesDir(), "httv_playlist.m3u");
                        File tempFile = new File(context.getFilesDir(), "httv_playlist.m3u.tmp");
                        InputStream is = conn.getInputStream();
                        FileOutputStream fos = new FileOutputStream(tempFile);
                        byte[] buf = new byte[8192];
                        int len;
                        while ((len = is.read(buf)) > 0) {
                            fos.write(buf, 0, len);
                        }
                        fos.flush();
                        fos.close();
                        is.close();

                        if (tempFile.length() > 500) {
                            if (targetFile.exists()) {
                                targetFile.delete();
                            }
                            tempFile.renameTo(targetFile);
                            success = true;
                            Log.d(TAG, "Đã tải thành công playlist.m3u mới (" + targetFile.length() + " bytes)");
                        } else {
                            tempFile.delete();
                        }
                    }
                    conn.disconnect();
                } catch (Exception e) {
                    Log.e(TAG, "Lỗi tải playlist", e);
                }

                if (onDone != null) {
                    new Handler(Looper.getMainLooper()).post(onDone);
                }
            }
        }).start();
    }

    public static void refreshSourceData(final Fragment fragment) {
        if (fragment == null || !fragment.isAdded()) return;
        final Context ctx = fragment.getActivity();
        if (ctx == null) return;

        Toast.makeText(ctx, "Đang tải và cập nhật danh sách kênh mới...", Toast.LENGTH_SHORT).show();
        downloadLatestPlaylist(ctx, new Runnable() {
            @Override
            public void run() {
                MovieList.INSTANCE.getMovies(new Function1<List<Movie>, Unit>() {
                    @Override
                    public Unit invoke(List<Movie> list) {
                        if (fragment.isAdded()) {
                            if (list != null && !list.isEmpty()) {
                                Toast.makeText(ctx, "✅ Đã cập nhật " + list.size() + " kênh mới nhất!", Toast.LENGTH_SHORT).show();
                                if (fragment instanceof MainFragment) {
                                    ((MainFragment) fragment).rebuildAdapter();
                                } else if (fragment instanceof MobileMainFragment) {
                                    ((MobileMainFragment) fragment).forceReloadUI();
                                }
                            } else {
                                Toast.makeText(ctx, "❌ Không thể cập nhật danh sách!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        });
    }
}
