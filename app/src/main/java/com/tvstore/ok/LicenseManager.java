package com.tvstore.ok;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.google.common.net.HttpHeaders;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: LicenseManager.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001.B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aJ\"\u0010\"\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00170$J\u0018\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J*\u0010'\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u00052\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00170$J\u0018\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0002J\u001c\u0010+\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0006\u0010-\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/tvstore/ok/LicenseManager;", "", "<init>", "()V", "TAG", "", "SHEETS_CSV_URL", "FORM_SUBMIT_URL", "FORM_ENTRY_DEVICE_ID", "FORM_ENTRY_DEVICE_NAME", "POLL_INTERVAL_MS", "", "PREFS_NAME", "KEY_STATUS", "KEY_DEVICE_NAME", "httpClient", "Lokhttp3/OkHttpClient;", "mainHandler", "Landroid/os/Handler;", "pollingRunnable", "Ljava/lang/Runnable;", "revokeCallback", "Lkotlin/Function0;", "", "getDeviceId", "context", "Landroid/content/Context;", "saveStatus", NotificationCompat.CATEGORY_STATUS, "Lcom/tvstore/ok/LicenseManager$LicenseStatus;", "loadCachedStatus", "saveDeviceName", "name", "loadDeviceName", "checkLicense", "callback", "Lkotlin/Function1;", "fetchStatusFromSheets", "deviceId", "registerDevice", "deviceName", "", "submitGoogleForm", "startPolling", "onRevoked", "stopPolling", "LicenseStatus", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class LicenseManager {
    public static final String FORM_ENTRY_DEVICE_ID = "entry.1874199911";
    public static final String FORM_ENTRY_DEVICE_NAME = "entry.1969282943";
    public static final String FORM_SUBMIT_URL = "https://docs.google.com/forms/d/e/1FAIpQLScZBaQ-bWy-mh6ZL_eWYwaMgdVNK1GlAKzcImK-gZ2K3LUmrA/formResponse";
    private static final String KEY_DEVICE_NAME = "device_name";
    private static final String KEY_STATUS = "license_status";
    private static final long POLL_INTERVAL_MS = 60000;
    private static final String PREFS_NAME = "license_prefs";
    public static final String SHEETS_CSV_URL = "https://docs.google.com/spreadsheets/d/1IVhD5DrQ8rNXC7Uaor27LPOXhu_zNMsRQKO5sO7QbZY/export?format=csv&gid=0";
    private static final String TAG = "LicenseManager";
    private static Runnable pollingRunnable;
    private static Function0<Unit> revokeCallback;
    public static final LicenseManager INSTANCE = new LicenseManager();
    private static final OkHttpClient httpClient = new OkHttpClient.Builder().connectTimeout(15, TimeUnit.SECONDS).readTimeout(15, TimeUnit.SECONDS).writeTimeout(15, TimeUnit.SECONDS).followRedirects(true).followSslRedirects(true).build();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    private final boolean submitGoogleForm(String deviceId, String deviceName) {
        return true;
    }

    public final void checkLicense(Context context, Function1<? super LicenseStatus, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke(LicenseStatus.ACTIVE);
    }

    public final void startPolling(Context context, Function0<Unit> onRevoked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onRevoked, "onRevoked");
    }

    private LicenseManager() {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: LicenseManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/tvstore/ok/LicenseManager$LicenseStatus;", "", "<init>", "(Ljava/lang/String;I)V", "APPROVED", "PENDING", "NOT_REGISTERED", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class LicenseStatus {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LicenseStatus[] $VALUES;
        public static final LicenseStatus APPROVED = new LicenseStatus("APPROVED", 0);
        public static final LicenseStatus PENDING = new LicenseStatus("PENDING", 1);
        public static final LicenseStatus NOT_REGISTERED = new LicenseStatus("NOT_REGISTERED", 2);

        private static final /* synthetic */ LicenseStatus[] $values() {
            return new LicenseStatus[]{APPROVED, PENDING, NOT_REGISTERED};
        }

        public static EnumEntries<LicenseStatus> getEntries() {
            return $ENTRIES;
        }

        public static LicenseStatus valueOf(String str) {
            return (LicenseStatus) Enum.valueOf(LicenseStatus.class, str);
        }

        public static LicenseStatus[] values() {
            return (LicenseStatus[]) $VALUES.clone();
        }

        private LicenseStatus(String str, int i) {
        }

        static {
            LicenseStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public final String getDeviceId(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return string == null ? EnvironmentCompat.MEDIA_UNKNOWN : string;
    }

    private final void saveStatus(Context context, LicenseStatus status) {
        context.getSharedPreferences(PREFS_NAME, 0).edit().putString(KEY_STATUS, status.name()).apply();
    }

    private final LicenseStatus loadCachedStatus(Context context) {
        String string = context.getSharedPreferences(PREFS_NAME, 0).getString(KEY_STATUS, "NOT_REGISTERED");
        try {
            Intrinsics.checkNotNull(string);
            return LicenseStatus.valueOf(string);
        } catch (Exception unused) {
            return LicenseStatus.NOT_REGISTERED;
        }
    }

    public final void saveDeviceName(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        context.getSharedPreferences(PREFS_NAME, 0).edit().putString(KEY_DEVICE_NAME, name).apply();
    }

    public final String loadDeviceName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getSharedPreferences(PREFS_NAME, 0).getString(KEY_DEVICE_NAME, "");
        return string == null ? "" : string;
    }

    private final LicenseStatus fetchStatusFromSheets(String deviceId, Context context) {
        String str;
        String str2;
        LicenseStatus licenseStatus;
        try {
            if (StringsKt.contains$default((CharSequence) SHEETS_CSV_URL, (CharSequence) "?", false, 2, (Object) null)) {
                str = "https://docs.google.com/spreadsheets/d/1IVhD5DrQ8rNXC7Uaor27LPOXhu_zNMsRQKO5sO7QbZY/export?format=csv&gid=0&_t=" + System.currentTimeMillis();
            } else {
                str = "https://docs.google.com/spreadsheets/d/1IVhD5DrQ8rNXC7Uaor27LPOXhu_zNMsRQKO5sO7QbZY/export?format=csv&gid=0?_t=" + System.currentTimeMillis();
            }
            Response execute = httpClient.newCall(new Request.Builder().url(str).header(HttpHeaders.CACHE_CONTROL, "no-cache").build()).execute();
            if (!execute.isSuccessful()) {
                Log.w(TAG, "Sheets HTTP error: " + execute.code());
                return loadCachedStatus(context);
            }
            ResponseBody body = execute.body();
            if (body == null || (str2 = body.string()) == null) {
                str2 = "";
            }
            List<String> lines = StringsKt.lines(str2);
            int size = lines.size();
            for (int i = 1; i < size; i++) {
                String str3 = lines.get(i);
                if (!StringsKt.isBlank(str3)) {
                    List<String> split = new Regex(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)").split(str3, 0);
                    if (split.size() > 1) {
                        if (StringsKt.equals(StringsKt.replace$default(StringsKt.trim((CharSequence) split.get(1)).toString(), "\"", "", false, 4, (Object) null), deviceId, true)) {
                            if (StringsKt.equals(split.size() > 3 ? StringsKt.replace$default(StringsKt.trim((CharSequence) split.get(3)).toString(), "\"", "", false, 4, (Object) null) : "", "OK", true)) {
                                licenseStatus = LicenseStatus.APPROVED;
                            } else {
                                licenseStatus = LicenseStatus.PENDING;
                            }
                            saveStatus(context, licenseStatus);
                            Log.d(TAG, "Device found → status=" + licenseStatus);
                            return licenseStatus;
                        }
                    }
                }
            }
            if (loadCachedStatus(context) == LicenseStatus.APPROVED) {
                saveStatus(context, LicenseStatus.NOT_REGISTERED);
                Log.w(TAG, "Device was APPROVED but now missing from Sheets → REVOKED!");
                return LicenseStatus.NOT_REGISTERED;
            }
            saveStatus(context, LicenseStatus.NOT_REGISTERED);
            return LicenseStatus.NOT_REGISTERED;
        } catch (Exception e) {
            Log.e(TAG, "Error fetching license: " + e.getMessage());
            return loadCachedStatus(context);
        }
    }

    public final void registerDevice(final Context context, final String deviceName, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String deviceId = getDeviceId(context);
        new Thread(new Runnable() { // from class: com.tvstore.ok.LicenseManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                LicenseManager.registerDevice$lambda$2(deviceId, deviceName, context, callback);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void registerDevice$lambda$2(String str, String str2, Context context, final Function1 function1) {
        LicenseManager licenseManager = INSTANCE;
        final boolean submitGoogleForm = licenseManager.submitGoogleForm(str, str2);
        if (submitGoogleForm) {
            licenseManager.saveStatus(context, LicenseStatus.PENDING);
            licenseManager.saveDeviceName(context, str2);
        }
        mainHandler.post(new Runnable() { // from class: com.tvstore.ok.LicenseManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Function1.this.invoke(Boolean.valueOf(submitGoogleForm));
            }
        });
    }

    public final void stopPolling() {
        Runnable runnable = pollingRunnable;
        if (runnable != null) {
            mainHandler.removeCallbacks(runnable);
        }
        pollingRunnable = null;
    }
}
