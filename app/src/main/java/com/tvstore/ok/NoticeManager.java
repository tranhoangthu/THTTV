package com.tvstore.ok;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.tvprovider.media.tv.TvContractCompat;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;

/* compiled from: NoticeManager.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tvstore/ok/NoticeManager;", "", "<init>", "()V", "TAG", "", "NOTICE_URL", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "checkNotice", "", "context", "Landroid/content/Context;", "showNoticeDialog", "notice", "Lcom/tvstore/ok/NoticeManager$Notice;", "Notice", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class NoticeManager {
    private static final String NOTICE_URL = "https://github.com/hakison/xiaomi/blob/main/ok.json";
    private static final String TAG = "NoticeManager";
    public static final NoticeManager INSTANCE = new NoticeManager();

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private static final Lazy client = LazyKt.lazy(new Function0() { // from class: com.tvstore.ok.NoticeManager$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            OkHttpClient okHttpClient;
            okHttpClient = NetworkUtils.INSTANCE.getOkHttpClient();
            return okHttpClient;
        }
    });
    private static final Gson gson = new Gson();

    public final void checkNotice(Context context) {
    }

    private NoticeManager() {
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) client.getValue();
    }

    /* compiled from: NoticeManager.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/tvstore/ok/NoticeManager$Notice;", "", TtmlNode.ATTR_ID, "", TvContractCompat.ProgramColumns.COLUMN_TITLE, "", "message", "showAlways", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;Z)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getMessage", "getShowAlways", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final /* data */ class Notice {

        @SerializedName(TtmlNode.ATTR_ID)
        private final int id;

        @SerializedName("message")
        private final String message;

        @SerializedName("show_always")
        private final boolean showAlways;

        @SerializedName(TvContractCompat.ProgramColumns.COLUMN_TITLE)
        private final String title;

        public static /* synthetic */ Notice copy$default(Notice notice, int i, String str, String str2, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = notice.id;
            }
            if ((i2 & 2) != 0) {
                str = notice.title;
            }
            if ((i2 & 4) != 0) {
                str2 = notice.message;
            }
            if ((i2 & 8) != 0) {
                z = notice.showAlways;
            }
            return notice.copy(i, str, str2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getShowAlways() {
            return this.showAlways;
        }

        public final Notice copy(int id, String title, String message, boolean showAlways) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            return new Notice(id, title, message, showAlways);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Notice)) {
                return false;
            }
            Notice notice = (Notice) other;
            return this.id == notice.id && Intrinsics.areEqual(this.title, notice.title) && Intrinsics.areEqual(this.message, notice.message) && this.showAlways == notice.showAlways;
        }

        public int hashCode() {
            return (((((this.id * 31) + this.title.hashCode()) * 31) + this.message.hashCode()) * 31) + Movie$$ExternalSyntheticBackport0.m(this.showAlways);
        }

        public String toString() {
            return "Notice(id=" + this.id + ", title=" + this.title + ", message=" + this.message + ", showAlways=" + this.showAlways + ")";
        }

        public Notice(int i, String title, String message, boolean z) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            this.id = i;
            this.title = title;
            this.message = message;
            this.showAlways = z;
        }

        public /* synthetic */ Notice(int i, String str, String str2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, str, str2, (i2 & 8) != 0 ? false : z);
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getMessage() {
            return this.message;
        }

        public final boolean getShowAlways() {
            return this.showAlways;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showNoticeDialog(Context context, Notice notice) {
        Spanned fromHtml;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(StringsKt.replace$default(notice.getMessage(), "\n", "<br>", false, 4, (Object) null), 0);
        } else {
            fromHtml = Html.fromHtml(StringsKt.replace$default(notice.getMessage(), "\n", "<br>", false, 4, (Object) null));
        }
        try {
            new AlertDialog.Builder(context).setTitle(notice.getTitle()).setMessage(fromHtml).setPositiveButton("Đã hiểu", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.NoticeManager$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).setCancelable(true).show();
        } catch (Exception e) {
            Log.e(TAG, "Failed to show notice dialog", e);
        }
    }
}
