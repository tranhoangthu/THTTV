package com.tvstore.ok;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.ExoPlayer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: UpdateManager.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/tvstore/ok/UpdateManager$downloadAndInstall$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class UpdateManager$downloadAndInstall$1 implements Callback {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $downloadUrl;
    final /* synthetic */ ProgressDialog $progressDialog;
    final /* synthetic */ String $releaseNotes;
    final /* synthetic */ String $version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateManager$downloadAndInstall$1(ProgressDialog progressDialog, Context context, String str, String str2, String str3) {
        this.$progressDialog = progressDialog;
        this.$context = context;
        this.$version = str;
        this.$releaseNotes = str2;
        this.$downloadUrl = str3;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        Handler handler = new Handler(Looper.getMainLooper());
        final ProgressDialog progressDialog = this.$progressDialog;
        final Context context = this.$context;
        final String str = this.$version;
        final String str2 = this.$releaseNotes;
        final String str3 = this.$downloadUrl;
        handler.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$downloadAndInstall$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                UpdateManager$downloadAndInstall$1.onFailure$lambda$0(progressDialog, context, str, str2, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onFailure$lambda$0(ProgressDialog progressDialog, Context context, String str, String str2, String str3) {
        progressDialog.dismiss();
        Toast.makeText(context, "Lỗi tải xuống cập nhật", 0).show();
        UpdateManager.INSTANCE.showUpdateDialog(context, str, str2, str3);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, final Response response) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            Handler handler = new Handler(Looper.getMainLooper());
            final ProgressDialog progressDialog = this.$progressDialog;
            final Context context = this.$context;
            final String str = this.$version;
            final String str2 = this.$releaseNotes;
            final String str3 = this.$downloadUrl;
            handler.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$downloadAndInstall$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateManager$downloadAndInstall$1.onResponse$lambda$1(progressDialog, context, response, str, str2, str3);
                }
            });
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            return;
        }
        final File file = new File(this.$context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "update.apk");
        try {
            InputStream byteStream = body.byteStream();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            long contentLength = body.getContentLength();
            byte[] bArr = new byte[8192];
            long j = 0;
            while (true) {
                int read = byteStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                    j += read;
                    if (contentLength > 0) {
                        final int i = (int) ((100 * j) / contentLength);
                        Handler handler2 = new Handler(Looper.getMainLooper());
                        final ProgressDialog progressDialog2 = this.$progressDialog;
                        handler2.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$downloadAndInstall$1$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                progressDialog2.setProgress(i);
                            }
                        });
                    }
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    byteStream.close();
                    Handler handler3 = new Handler(Looper.getMainLooper());
                    final ProgressDialog progressDialog3 = this.$progressDialog;
                    final Context context2 = this.$context;
                    final String str4 = this.$version;
                    final String str5 = this.$releaseNotes;
                    final String str6 = this.$downloadUrl;
                    handler3.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$downloadAndInstall$1$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            UpdateManager$downloadAndInstall$1.onResponse$lambda$5(progressDialog3, context2, file, str4, str5, str6);
                        }
                    });
                    return;
                }
            }
        } catch (Exception unused) {
            Handler handler4 = new Handler(Looper.getMainLooper());
            final ProgressDialog progressDialog4 = this.$progressDialog;
            final Context context3 = this.$context;
            final String str7 = this.$version;
            final String str8 = this.$releaseNotes;
            final String str9 = this.$downloadUrl;
            handler4.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$downloadAndInstall$1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    UpdateManager$downloadAndInstall$1.onResponse$lambda$6(progressDialog4, context3, str7, str8, str9);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onResponse$lambda$1(ProgressDialog progressDialog, Context context, Response response, String str, String str2, String str3) {
        progressDialog.dismiss();
        Toast.makeText(context, "Lỗi khi tải file: " + response.code(), 0).show();
        UpdateManager.INSTANCE.showUpdateDialog(context, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onResponse$lambda$5(ProgressDialog progressDialog, final Context context, File file, final String str, final String str2, final String str3) {
        progressDialog.dismiss();
        UpdateManager.INSTANCE.installApk(context, file);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tvstore.ok.UpdateManager$downloadAndInstall$1$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                UpdateManager.INSTANCE.showUpdateDialog(context, str, str2, str3);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onResponse$lambda$6(ProgressDialog progressDialog, Context context, String str, String str2, String str3) {
        progressDialog.dismiss();
        Toast.makeText(context, "Lỗi lưu file tải xuống", 0).show();
        UpdateManager.INSTANCE.showUpdateDialog(context, str, str2, str3);
    }
}
