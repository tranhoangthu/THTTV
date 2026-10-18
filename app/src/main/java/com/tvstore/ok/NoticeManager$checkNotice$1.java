package com.tvstore.ok;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import com.google.gson.Gson;
import com.tvstore.ok.NoticeManager;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: NoticeManager.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/tvstore/ok/NoticeManager$checkNotice$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class NoticeManager$checkNotice$1 implements Callback {
    final /* synthetic */ Context $context;

    NoticeManager$checkNotice$1(Context context) {
        this.$context = context;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException e) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(e, "e");
        Log.e("NoticeManager", "Failed to fetch notice", e);
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        ResponseBody body;
        String string;
        Gson gson;
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(response, "response");
        if (!response.isSuccessful() || (body = response.body()) == null || (string = body.string()) == null) {
            return;
        }
        try {
            gson = NoticeManager.gson;
            final NoticeManager.Notice notice = (NoticeManager.Notice) gson.fromJson(string, NoticeManager.Notice.class);
            if (notice == null) {
                return;
            }
            SharedPreferences sharedPreferences = this.$context.getSharedPreferences("ok_prefs", 0);
            int i = sharedPreferences.getInt("last_notice_id", -1);
            if (notice.getShowAlways() || notice.getId() > i) {
                Handler handler = new Handler(Looper.getMainLooper());
                final Context context = this.$context;
                handler.post(new Runnable() { // from class: com.tvstore.ok.NoticeManager$checkNotice$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        NoticeManager.INSTANCE.showNoticeDialog(context, notice);
                    }
                });
                if (notice.getShowAlways()) {
                    return;
                }
                sharedPreferences.edit().putInt("last_notice_id", notice.getId()).apply();
            }
        } catch (Exception e) {
            Log.e("NoticeManager", "Failed to parse notice JSON", e);
        }
    }
}
