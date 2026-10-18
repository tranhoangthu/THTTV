package com.tvstore.ok;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.tvstore.ok.UpdateManager;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: UpdateManager.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/tvstore/ok/UpdateManager$checkUpdate$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class UpdateManager$checkUpdate$1 implements Callback {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $manual;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UpdateManager$checkUpdate$1(boolean z, Context context) {
        this.$manual = z;
        this.$context = context;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        Log.e("UpdateManager", "Failed to check update", e);
        if (this.$manual) {
            Handler handler = new Handler(Looper.getMainLooper());
            final Context context = this.$context;
            handler.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$checkUpdate$1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    Toast.makeText(context, "Lỗi kiểm tra cập nhật", 0).show();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        String string;
        Gson gson;
        boolean isNewerVersion;
        final String str = "1.0";
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful()) {
            Log.e("UpdateManager", "GitHub API response error: " + response.code());
            if (this.$manual) {
                Handler handler = new Handler(Looper.getMainLooper());
                final Context context = this.$context;
                handler.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$checkUpdate$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(context, "Không thể kết nối đến máy chủ cập nhật", 0).show();
                    }
                });
                return;
            }
            return;
        }
        ResponseBody body = response.body();
        if (body == null || (string = body.string()) == null) {
            return;
        }
        try {
            gson = UpdateManager.gson;
            final UpdateManager.GitHubRelease gitHubRelease = (UpdateManager.GitHubRelease) gson.fromJson(string, UpdateManager.GitHubRelease.class);
            final String obj = StringsKt.trim((CharSequence) StringsKt.replace$default(gitHubRelease.getTagName(), "v", "", false, 4, (Object) null)).toString();
            try {
                String str2 = this.$context.getPackageManager().getPackageInfo(this.$context.getPackageName(), 0).versionName;
                if (str2 != null) {
                    str = str2;
                }
            } catch (Exception unused) {
            }
            isNewerVersion = UpdateManager.INSTANCE.isNewerVersion(obj, str);
            if (isNewerVersion) {
                List<UpdateManager.Asset> assets = gitHubRelease.getAssets();
                final UpdateManager.Asset asset = null;
                if (assets != null) {
                    Iterator<T> it = assets.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (StringsKt.endsWith$default(((UpdateManager.Asset) next).getName(), ".apk", false, 2, (Object) null)) {
                            asset = next;
                            break;
                        }
                    }
                    asset = asset;
                }
                if (asset != null) {
                    Handler handler2 = new Handler(Looper.getMainLooper());
                    final Context context2 = this.$context;
                    handler2.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$checkUpdate$1$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            UpdateManager$checkUpdate$1.onResponse$lambda$3(context2, obj, gitHubRelease, asset);
                        }
                    });
                    return;
                } else {
                    if (this.$manual) {
                        Handler handler3 = new Handler(Looper.getMainLooper());
                        final Context context3 = this.$context;
                        handler3.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$checkUpdate$1$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                Toast.makeText(context3, "Không tìm thấy file cài đặt trong bản phát hành mới nhất", 0).show();
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            if (this.$manual) {
                Handler handler4 = new Handler(Looper.getMainLooper());
                final Context context4 = this.$context;
                handler4.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$checkUpdate$1$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(context4, "Ứng dụng đã ở phiên bản mới nhất (" + str + ")", 0).show();
                    }
                });
            }
        } catch (Exception e) {
            Log.e("UpdateManager", "Failed to parse release JSON", e);
            if (this.$manual) {
                Handler handler5 = new Handler(Looper.getMainLooper());
                final Context context5 = this.$context;
                handler5.post(new Runnable() { // from class: com.tvstore.ok.UpdateManager$checkUpdate$1$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        Toast.makeText(context5, "Lỗi dữ liệu bản cập nhật", 0).show();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onResponse$lambda$3(Context context, String str, UpdateManager.GitHubRelease gitHubRelease, UpdateManager.Asset asset) {
        UpdateManager updateManager = UpdateManager.INSTANCE;
        String body = gitHubRelease.getBody();
        if (body == null) {
            body = "";
        }
        updateManager.showUpdateDialog(context, str, body, asset.getBrowserDownloadUrl());
    }
}
