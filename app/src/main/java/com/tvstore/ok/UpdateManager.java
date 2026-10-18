package com.tvstore.ok;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* compiled from: UpdateManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002 !B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u0014J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J(\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J(\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/tvstore/ok/UpdateManager;", "", "<init>", "()V", "TAG", "", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "checkUpdate", "", "context", "Landroid/content/Context;", "repoUrl", "manual", "", "isNewerVersion", "latest", "current", "showUpdateDialog", "version", "releaseNotes", "downloadUrl", "downloadAndInstall", "installApk", "file", "Ljava/io/File;", "GitHubRelease", "Asset", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class UpdateManager {
    private static final String TAG = "UpdateManager";
    public static final UpdateManager INSTANCE = new UpdateManager();

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private static final Lazy client = LazyKt.lazy(new Function0() { // from class: com.tvstore.ok.UpdateManager$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            OkHttpClient okHttpClient;
            okHttpClient = NetworkUtils.INSTANCE.getOkHttpClient();
            return okHttpClient;
        }
    });
    private static final Gson gson = new Gson();

    private UpdateManager() {
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) client.getValue();
    }

    /* compiled from: UpdateManager.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tvstore/ok/UpdateManager$GitHubRelease;", "", "tagName", "", TtmlNode.TAG_BODY, "assets", "", "Lcom/tvstore/ok/UpdateManager$Asset;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTagName", "()Ljava/lang/String;", "getBody", "getAssets", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final /* data */ class GitHubRelease {

        @SerializedName("assets")
        private final List<Asset> assets;

        @SerializedName(TtmlNode.TAG_BODY)
        private final String body;

        @SerializedName("tag_name")
        private final String tagName;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GitHubRelease copy$default(GitHubRelease gitHubRelease, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gitHubRelease.tagName;
            }
            if ((i & 2) != 0) {
                str2 = gitHubRelease.body;
            }
            if ((i & 4) != 0) {
                list = gitHubRelease.assets;
            }
            return gitHubRelease.copy(str, str2, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTagName() {
            return this.tagName;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBody() {
            return this.body;
        }

        public final List<Asset> component3() {
            return this.assets;
        }

        public final GitHubRelease copy(String tagName, String r3, List<Asset> assets) {
            Intrinsics.checkNotNullParameter(tagName, "tagName");
            return new GitHubRelease(tagName, r3, assets);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GitHubRelease)) {
                return false;
            }
            GitHubRelease gitHubRelease = (GitHubRelease) other;
            return Intrinsics.areEqual(this.tagName, gitHubRelease.tagName) && Intrinsics.areEqual(this.body, gitHubRelease.body) && Intrinsics.areEqual(this.assets, gitHubRelease.assets);
        }

        public int hashCode() {
            int hashCode = this.tagName.hashCode() * 31;
            String str = this.body;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            List<Asset> list = this.assets;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "GitHubRelease(tagName=" + this.tagName + ", body=" + this.body + ", assets=" + this.assets + ")";
        }

        public GitHubRelease(String tagName, String str, List<Asset> list) {
            Intrinsics.checkNotNullParameter(tagName, "tagName");
            this.tagName = tagName;
            this.body = str;
            this.assets = list;
        }

        public final String getTagName() {
            return this.tagName;
        }

        public final String getBody() {
            return this.body;
        }

        public final List<Asset> getAssets() {
            return this.assets;
        }
    }

    /* compiled from: UpdateManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/tvstore/ok/UpdateManager$Asset;", "", "name", "", "browserDownloadUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getBrowserDownloadUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final /* data */ class Asset {

        @SerializedName("browser_download_url")
        private final String browserDownloadUrl;

        @SerializedName("name")
        private final String name;

        public static /* synthetic */ Asset copy$default(Asset asset, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = asset.name;
            }
            if ((i & 2) != 0) {
                str2 = asset.browserDownloadUrl;
            }
            return asset.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBrowserDownloadUrl() {
            return this.browserDownloadUrl;
        }

        public final Asset copy(String name, String browserDownloadUrl) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(browserDownloadUrl, "browserDownloadUrl");
            return new Asset(name, browserDownloadUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Asset)) {
                return false;
            }
            Asset asset = (Asset) other;
            return Intrinsics.areEqual(this.name, asset.name) && Intrinsics.areEqual(this.browserDownloadUrl, asset.browserDownloadUrl);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.browserDownloadUrl.hashCode();
        }

        public String toString() {
            return "Asset(name=" + this.name + ", browserDownloadUrl=" + this.browserDownloadUrl + ")";
        }

        public Asset(String name, String browserDownloadUrl) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(browserDownloadUrl, "browserDownloadUrl");
            this.name = name;
            this.browserDownloadUrl = browserDownloadUrl;
        }

        public final String getName() {
            return this.name;
        }

        public final String getBrowserDownloadUrl() {
            return this.browserDownloadUrl;
        }
    }

    public static /* synthetic */ void checkUpdate$default(UpdateManager updateManager, Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        updateManager.checkUpdate(context, str, z);
    }

    public final void checkUpdate(Context context, String repoUrl, boolean manual) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repoUrl, "repoUrl");
        getClient().newCall(new Request.Builder().url("https://api.github.com/repos/" + repoUrl + "/releases/latest").addHeader(HttpHeaders.ACCEPT, "application/vnd.github.v3+json").build()).enqueue(new UpdateManager$checkUpdate$1(manual, context));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean isNewerVersion(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "."
            r1 = 0
            r2 = r11
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch: java.lang.Exception -> Ld0
            java.lang.String[] r3 = new java.lang.String[]{r0}     // Catch: java.lang.Exception -> Ld0
            r6 = 6
            r7 = 0
            r4 = 0
            r5 = 0
            java.util.List r11 = kotlin.text.StringsKt.split$default(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> Ld0
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch: java.lang.Exception -> Ld0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld0
            r3 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r3)     // Catch: java.lang.Exception -> Ld0
            r2.<init>(r4)     // Catch: java.lang.Exception -> Ld0
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Exception -> Ld0
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Exception -> Ld0
        L25:
            boolean r4 = r11.hasNext()     // Catch: java.lang.Exception -> Ld0
            if (r4 == 0) goto L45
            java.lang.Object r4 = r11.next()     // Catch: java.lang.Exception -> Ld0
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> Ld0
            java.lang.Integer r4 = kotlin.text.StringsKt.toIntOrNull(r4)     // Catch: java.lang.Exception -> Ld0
            if (r4 == 0) goto L3c
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> Ld0
            goto L3d
        L3c:
            r4 = 0
        L3d:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> Ld0
            r2.add(r4)     // Catch: java.lang.Exception -> Ld0
            goto L25
        L45:
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> Ld0
            r4 = r12
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch: java.lang.Exception -> Ld0
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch: java.lang.Exception -> Ld0
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            java.util.List r11 = kotlin.text.StringsKt.split$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> Ld0
            java.lang.Iterable r11 = (java.lang.Iterable) r11     // Catch: java.lang.Exception -> Ld0
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld0
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r11, r3)     // Catch: java.lang.Exception -> Ld0
            r12.<init>(r0)     // Catch: java.lang.Exception -> Ld0
            java.util.Collection r12 = (java.util.Collection) r12     // Catch: java.lang.Exception -> Ld0
            java.util.Iterator r11 = r11.iterator()     // Catch: java.lang.Exception -> Ld0
        L67:
            boolean r0 = r11.hasNext()     // Catch: java.lang.Exception -> Ld0
            if (r0 == 0) goto L87
            java.lang.Object r0 = r11.next()     // Catch: java.lang.Exception -> Ld0
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> Ld0
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)     // Catch: java.lang.Exception -> Ld0
            if (r0 == 0) goto L7e
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> Ld0
            goto L7f
        L7e:
            r0 = 0
        L7f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> Ld0
            r12.add(r0)     // Catch: java.lang.Exception -> Ld0
            goto L67
        L87:
            java.util.List r12 = (java.util.List) r12     // Catch: java.lang.Exception -> Ld0
            int r11 = r2.size()     // Catch: java.lang.Exception -> Ld0
            int r0 = r12.size()     // Catch: java.lang.Exception -> Ld0
            int r11 = java.lang.Math.max(r11, r0)     // Catch: java.lang.Exception -> Ld0
            r0 = 0
        L96:
            if (r0 >= r11) goto Ldb
            if (r0 < 0) goto La5
            int r3 = r2.size()     // Catch: java.lang.Exception -> Ld0
            if (r0 >= r3) goto La5
            java.lang.Object r3 = r2.get(r0)     // Catch: java.lang.Exception -> Ld0
            goto La9
        La5:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Ld0
        La9:
            java.lang.Number r3 = (java.lang.Number) r3     // Catch: java.lang.Exception -> Ld0
            int r3 = r3.intValue()     // Catch: java.lang.Exception -> Ld0
            if (r0 < 0) goto Lbc
            int r4 = r12.size()     // Catch: java.lang.Exception -> Ld0
            if (r0 >= r4) goto Lbc
            java.lang.Object r4 = r12.get(r0)     // Catch: java.lang.Exception -> Ld0
            goto Lc0
        Lbc:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> Ld0
        Lc0:
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Exception -> Ld0
            int r4 = r4.intValue()     // Catch: java.lang.Exception -> Ld0
            if (r3 <= r4) goto Lca
            r11 = 1
            return r11
        Lca:
            if (r3 >= r4) goto Lcd
            return r1
        Lcd:
            int r0 = r0 + 1
            goto L96
        Ld0:
            r0 = move-exception
            r11 = r0
            java.lang.String r12 = "Version parse error"
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.String r0 = "UpdateManager"
            android.util.Log.e(r0, r12, r11)
        Ldb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.UpdateManager.isNewerVersion(java.lang.String, java.lang.String):boolean");
    }

    public final void showUpdateDialog(final Context context, final String version, final String releaseNotes, final String downloadUrl) {
        AlertDialog.Builder title = new AlertDialog.Builder(context).setTitle("🚀 Yêu cầu cập nhật (v" + version + ")");
        StringBuilder sb = new StringBuilder("Phiên bản mới của ứng dụng đã sẵn sàng. Bạn bắt buộc phải cập nhật để tiếp tục sử dụng.\n\nChi tiết:\n");
        sb.append(releaseNotes);
        title.setMessage(sb.toString()).setCancelable(false).setPositiveButton("Cập nhật ngay", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.UpdateManager$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateManager.INSTANCE.downloadAndInstall(context, version, releaseNotes, downloadUrl);
            }
        }).setNegativeButton("Bỏ qua", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.UpdateManager$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UpdateManager.showUpdateDialog$lambda$6(context, dialogInterface, i);
            }
        }).show();
    }

    public static final void showUpdateDialog$lambda$6(Context context, DialogInterface dialogInterface, int i) {
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            activity.finishAffinity();
        }
    }

    public final void downloadAndInstall(Context context, String version, String releaseNotes, String downloadUrl) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Đang tải bản cập nhật...");
        progressDialog.setProgressStyle(1);
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(100);
        progressDialog.setCancelable(false);
        progressDialog.show();
        getClient().newCall(new Request.Builder().url(downloadUrl).build()).enqueue(new UpdateManager$downloadAndInstall$1(progressDialog, context, version, releaseNotes, downloadUrl));
    }

    public final void installApk(Context context, File file) {
        try {
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            intent.addFlags(1);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "Không thể mở trình cài đặt", 0).show();
            Log.e(TAG, "Install failed", e);
        }
    }
}
