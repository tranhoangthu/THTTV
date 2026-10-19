package com.tvstore.ok;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.datasource.cache.ContentMetadata;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ImagesContract;
import com.tvstore.ok.LicenseManager;
import com.tvstore.ok.MovieList;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010#\u001a\u00020\u000bJ\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010'\u001a\u00020\u000bH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010*\u001a\u00020+H\u0002R(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007 \b*\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/tvstore/ok/MainActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "pickM3uFile", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "pickM3uFileFallback", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStop", "onNewIntent", "intent", "Landroid/content/Intent;", "handleIntent", "searchAndPlayChannel", SearchIntents.EXTRA_QUERY, "requestPermissionLauncher", "checkPermissionsAndScan", "scanLocalMediaInBackground", "checkInitialSetup", "showAddSourceDialog", "showPendingDialog", "showRegistrationDialog", "showActualAddSourceDialog", "validateAndAddSource", "name", ImagesContract.URL, "loadNow", "", "openFilePicker", "handleSelectedM3u", "uri", "Landroid/net/Uri;", "showUiSelectionDialog", "loadAppropriateFragment", "isTvHardware", "context", "Landroid/content/Context;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class MainActivity extends FragmentActivity {
    private final ActivityResultLauncher<String[]> pickM3uFile;
    private final ActivityResultLauncher<String> pickM3uFileFallback;
    private final ActivityResultLauncher<String[]> requestPermissionLauncher;

    /* compiled from: MainActivity.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LicenseManager.LicenseStatus.values().length];
            try {
                iArr[LicenseManager.LicenseStatus.APPROVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LicenseManager.LicenseStatus.PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LicenseManager.LicenseStatus.NOT_REGISTERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private void checkInitialSetup() {
        validateAndAddSource("", "", true);
        loadAppropriateFragment();
    }

    public static final Unit showAddSourceDialog$lambda$18(ProgressDialog progressDialog, MainActivity mainActivity, LicenseManager.LicenseStatus licenseStatus) {
        progressDialog.dismiss();
        mainActivity.validateAndAddSource("THT TV - Xem TV", "https://raw.githubusercontent.com/tranhoangthu/THTTV/main/playlist.m3u", true);
        return Unit.INSTANCE;
    }

    private final void showRegistrationDialog() {
    }

    private final void validateAndAddSource(String name, String r10, boolean loadNow) {
        MovieList.INSTANCE.addSource(this, "THT TV - Xem TV", "https://raw.githubusercontent.com/tranhoangthu/THTTV/main/playlist.m3u", true, new MainActivity$$ExternalSyntheticLambda13(this));
    }

    public MainActivity() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.OpenDocument(), new ActivityResultCallback() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda8
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.pickM3uFile$lambda$1(MainActivity.this, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.pickM3uFile = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda9
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.pickM3uFileFallback$lambda$3(MainActivity.this, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.pickM3uFileFallback = registerForActivityResult2;
        ActivityResultLauncher<String[]> registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda10
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MainActivity.requestPermissionLauncher$lambda$13(MainActivity.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult3, "registerForActivityResult(...)");
        this.requestPermissionLauncher = registerForActivityResult3;
    }

    public static final void pickM3uFile$lambda$1(MainActivity mainActivity, Uri uri) {
        if (uri != null) {
            mainActivity.handleSelectedM3u(uri);
        }
    }

    public static final void pickM3uFileFallback$lambda$3(MainActivity mainActivity, Uri uri) {
        if (uri != null) {
            mainActivity.handleSelectedM3u(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.parseColor("#121212"));
        setContentView(R.layout.activity_main);
        MainActivity mainActivity = this;
        NetworkUtils.INSTANCE.initSecurity(mainActivity);
        MovieList.INSTANCE.init(mainActivity);
        EpgManager.INSTANCE.fetchEpg(new Function0() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        });
        UpdateManager.checkUpdate$default(UpdateManager.INSTANCE, mainActivity, "hieu-TQS/ok", false, 4, null);
        NoticeManager.INSTANCE.checkNotice(mainActivity);
        checkPermissionsAndScan();
        checkInitialSetup();
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        LicenseManager.INSTANCE.startPolling(this, new Function0() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainActivity.onResume$lambda$6(MainActivity.this);
            }
        });
    }

    public static final Unit onResume$lambda$6(MainActivity mainActivity) {
        String url;
        MovieList.TvSource currentSource = MovieList.INSTANCE.getCurrentSource();
        if (currentSource != null && (url = currentSource.getUrl()) != null && StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            Toast.makeText(mainActivity, "⛔ Kết nối đã bị gian đoạn, vui lòng kiểm tra lại sau.", 1).show();
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.finishAffinity();
                }
            }, 300000L);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        LicenseManager.INSTANCE.stopPolling();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (intent != null) {
            handleIntent(intent);
        }
    }

    private final void handleIntent(Intent intent) {
        if (Intrinsics.areEqual("android.intent.action.SEARCH", intent.getAction()) || Intrinsics.areEqual("android.media.action.MEDIA_PLAY_FROM_SEARCH", intent.getAction())) {
            String stringExtra = intent.getStringExtra(SearchIntents.EXTRA_QUERY);
            String str = stringExtra;
            if (str == null || str.length() == 0) {
                return;
            }
            searchAndPlayChannel(stringExtra);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00aa A[EDGE_INSN: B:16:0x00aa->B:17:0x00aa BREAK  A[LOOP:0: B:7:0x0077->B:63:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[LOOP:0: B:7:0x0077->B:63:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void searchAndPlayChannel(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.MainActivity.searchAndPlayChannel(java.lang.String):void");
    }

    public static final void requestPermissionLauncher$lambda$13(MainActivity mainActivity, Map map) {
        Iterator it = map.entrySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                z = false;
            }
        }
        if (z) {
            mainActivity.scanLocalMediaInBackground();
        } else {
            Toast.makeText(mainActivity, "Tính năng Media Cục Bộ sẽ không hoạt động do thiếu quyền", 0).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkPermissionsAndScan() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.READ_MEDIA_VIDEO", "android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_IMAGES"};
        } else {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                arrayList.add(str);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            scanLocalMediaInBackground();
        } else {
            this.requestPermissionLauncher.launch(arrayList2.toArray(new String[0]));
        }
    }

    private final void scanLocalMediaInBackground() {
        new Thread(new Runnable() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.scanLocalMediaInBackground$lambda$16(MainActivity.this);
            }
        }).start();
    }

    public static final void scanLocalMediaInBackground$lambda$16(MainActivity mainActivity) {
        MovieList.INSTANCE.setLocalMedia(LocalMediaScanner.INSTANCE.scanLocalMedia(mainActivity));
        mainActivity.runOnUiThread(new Runnable() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.scanLocalMediaInBackground$lambda$16$lambda$15(MainActivity.this);
            }
        });
    }

    public static final void scanLocalMediaInBackground$lambda$16$lambda$15(MainActivity mainActivity) {
        Fragment findFragmentById = mainActivity.getSupportFragmentManager().findFragmentById(R.id.main_browse_fragment);
        if (findFragmentById instanceof MainFragment) {
            ((MainFragment) findFragmentById).rebuildAdapter();
        } else if (findFragmentById instanceof MobileMainFragment) {
            ((MobileMainFragment) findFragmentById).forceReloadUI();
        }
    }

    public final void showAddSourceDialog() {
        MainActivity mainActivity = this;
        final ProgressDialog progressDialog = new ProgressDialog(mainActivity);
        progressDialog.setMessage("Đang kiểm tra quyền truy cập...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        LicenseManager.INSTANCE.checkLicense(mainActivity, new Function1() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainActivity.showAddSourceDialog$lambda$18(progressDialog, this, (LicenseManager.LicenseStatus) obj);
            }
        });
    }

    private final void showPendingDialog() {
        MainActivity mainActivity = this;
        String deviceId = LicenseManager.INSTANCE.getDeviceId(mainActivity);
        new AlertDialog.Builder(mainActivity).setTitle("⏳ Đang chờ cấp quyền").setMessage("Yêu cầu của bạn đã được gửi đến nhà phát triển.\n\nVui lòng chờ xác nhận để sử dụng tính năng này.\n\nMã thiết bị: " + deviceId).setPositiveButton("Kiểm tra lại", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda15
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.showAddSourceDialog();
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    public static final void showRegistrationDialog$lambda$26(EditText editText, final MainActivity mainActivity, final String str, DialogInterface dialogInterface, int i) {
        String obj = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (obj.length() == 0) {
            Toast.makeText(mainActivity, "Vui lòng nhập tên thiết bị!", 0).show();
            mainActivity.showRegistrationDialog();
            return;
        }
        MainActivity mainActivity2 = mainActivity;
        final ProgressDialog progressDialog = new ProgressDialog(mainActivity2);
        progressDialog.setMessage("Đang gửi yêu cầu...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        LicenseManager.INSTANCE.registerDevice(mainActivity2, obj, new Function1() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return MainActivity.showRegistrationDialog$lambda$26$lambda$25(progressDialog, mainActivity, str, ((Boolean) obj2).booleanValue());
            }
        });
    }

    public static final Unit showRegistrationDialog$lambda$26$lambda$25(ProgressDialog progressDialog, MainActivity mainActivity, String str, boolean z) {
        progressDialog.dismiss();
        if (z) {
            new AlertDialog.Builder(mainActivity).setTitle("✅ Đã gửi yêu cầu!").setMessage("Yêu cầu cấp quyền đã được gửi đến nhà phát triển.\n\nVui lòng chờ xác nhận rồi thử lại.\n\nMã thiết bị: " + str).setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
        } else {
            Toast.makeText(mainActivity, "❌ Lỗi kết nối! Vui lòng thử lại.", 1).show();
        }
        return Unit.INSTANCE;
    }

    private final void showActualAddSourceDialog() {
        MainActivity mainActivity = this;
        LinearLayout linearLayout = new LinearLayout(mainActivity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(50, 20, 50, 20);
        final EditText editText = new EditText(mainActivity);
        editText.setHint("Tên nguồn");
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setMaxLines(1);
        editText.setSingleLine(true);
        final EditText editText2 = new EditText(mainActivity);
        editText2.setHint("URL");
        editText2.setText("https://byvn.net/");
        editText2.setInputType(17);
        editText2.setImeOptions(6);
        editText2.setMaxLines(1);
        editText2.setSingleLine(true);
        editText2.setSelection(editText2.getText().length());
        linearLayout.addView(editText);
        linearLayout.addView(editText2);
        TextView textView = new TextView(mainActivity);
        textView.setText("--- HOẶC ---");
        textView.setGravity(17);
        textView.setPadding(0, 10, 0, 10);
        linearLayout.addView(textView);
        Button button = new Button(mainActivity);
        button.setText("📁 Chọn file .m3u từ máy");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.openFilePicker();
            }
        });
        linearLayout.addView(button);
        new AlertDialog.Builder(mainActivity).setTitle("Thêm nguồn mới").setView(linearLayout).setCancelable(false).setPositiveButton("Lưu và Mở", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showActualAddSourceDialog$lambda$33(editText, editText2, this, dialogInterface, i);
            }
        }).setNeutralButton("Chỉ Lưu", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showActualAddSourceDialog$lambda$34(editText, editText2, this, dialogInterface, i);
            }
        }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
    }

    public static final void showActualAddSourceDialog$lambda$33(EditText editText, EditText editText2, MainActivity mainActivity, DialogInterface dialogInterface, int i) {
        String obj = editText.getText().toString();
        String obj2 = editText2.getText().toString();
        if (obj.length() > 0 && obj2.length() > 0) {
            mainActivity.validateAndAddSource(obj, obj2, true);
        } else {
            Toast.makeText(mainActivity, "Vui lòng nhập đầy đủ", 0).show();
            mainActivity.showActualAddSourceDialog();
        }
    }

    public static final void showActualAddSourceDialog$lambda$34(EditText editText, EditText editText2, MainActivity mainActivity, DialogInterface dialogInterface, int i) {
        String obj = editText.getText().toString();
        String obj2 = editText2.getText().toString();
        if (obj.length() > 0 && obj2.length() > 0) {
            mainActivity.validateAndAddSource(obj, obj2, false);
        } else {
            Toast.makeText(mainActivity, "Vui lòng nhập đầy đủ", 0).show();
            mainActivity.showActualAddSourceDialog();
        }
    }

    public static final Unit validateAndAddSource$lambda$38(final MainActivity mainActivity, final ProgressDialog progressDialog, final String str, final boolean z, final boolean z2) {
        mainActivity.runOnUiThread(new Runnable() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.validateAndAddSource$lambda$38$lambda$37(progressDialog, z2, mainActivity, str, z);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void validateAndAddSource$lambda$38$lambda$37(ProgressDialog progressDialog, boolean z, MainActivity mainActivity, String str, boolean z2) {
        progressDialog.dismiss();
        if (z) {
            Toast.makeText(mainActivity, "Đã thêm nguồn: " + str, 0).show();
            if (z2) {
                Fragment findFragmentById = mainActivity.getSupportFragmentManager().findFragmentById(R.id.main_browse_fragment);
                if (findFragmentById instanceof MainFragment) {
                    ((MainFragment) findFragmentById).rebuildAdapter();
                    return;
                } else {
                    if (findFragmentById instanceof MobileMainFragment) {
                        ((MobileMainFragment) findFragmentById).forceReloadUI();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        new AlertDialog.Builder(mainActivity).setTitle("Lỗi thêm nguồn").setMessage("Không thể tải dữ liệu từ liên kết này. Vui lòng kiểm tra lại URL hoặc kết nối mạng.").setPositiveButton("Thử lại", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda12
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.showAddSourceDialog();
            }
        }).show();
    }

    public final void openFilePicker() {
        try {
            try {
                this.pickM3uFile.launch(new String[]{"*/*"});
            } catch (Exception unused) {
                this.pickM3uFileFallback.launch("*/*");
                Unit unit = Unit.INSTANCE;
            }
        } catch (Exception unused2) {
            new AlertDialog.Builder(this).setTitle("Thiếu ứng dụng quản lý tệp").setMessage("Thiết bị của bạn không có ứng dụng quản lý tệp hệ thống. Vui lòng cài đặt một ứng dụng quản lý tệp (như X-plore hoặc File Commander) từ CH Play để sử dụng tính năng này.").setPositiveButton("Đã hiểu", (DialogInterface.OnClickListener) null).show();
        }
    }

    private final void handleSelectedM3u(Uri uri) {
        byte[] readBytes;
        String str;
        try {
            InputStream openInputStream = getContentResolver().openInputStream(uri);
            if (openInputStream != null && (readBytes = ByteStreamsKt.readBytes(openInputStream)) != null) {
                openInputStream.close();
                try {
                    str = new String(readBytes, Charsets.UTF_8);
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) "�", false, 2, (Object) null)) {
                        str = new String(readBytes, Charsets.ISO_8859_1);
                    }
                } catch (Exception unused) {
                    str = new String(readBytes, Charsets.ISO_8859_1);
                }
                File file = new File(getFilesDir(), ContentMetadata.KEY_CUSTOM_PREFIX + System.currentTimeMillis() + ".m3u");
                FilesKt.writeText(file, str, Charsets.UTF_8);
                String str2 = "M3U: " + uri.getLastPathSegment();
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                MovieList.INSTANCE.addSource(this, str2, absolutePath, true, new MainActivity$$ExternalSyntheticLambda13(this));
            }
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi đọc file: " + e.getMessage(), 0).show();
        }
    }

    public static final Unit handleSelectedM3u$lambda$40(final MainActivity mainActivity, final boolean z) {
        mainActivity.runOnUiThread(new Runnable() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.handleSelectedM3u$lambda$40$lambda$39(z, mainActivity);
            }
        });
        return Unit.INSTANCE;
    }

    public static final void handleSelectedM3u$lambda$40$lambda$39(boolean z, MainActivity mainActivity) {
        if (z) {
            Fragment findFragmentById = mainActivity.getSupportFragmentManager().findFragmentById(R.id.main_browse_fragment);
            if (findFragmentById instanceof MainFragment) {
                ((MainFragment) findFragmentById).rebuildAdapter();
            } else if (findFragmentById instanceof MobileMainFragment) {
                ((MobileMainFragment) findFragmentById).forceReloadUI();
            }
        }
    }

    private final void showUiSelectionDialog() {
        new AlertDialog.Builder(this).setTitle("Chọn giao diện").setCancelable(false).setItems(new String[]{"Giao diện TV (Leanback)", "Giao diện Điện thoại"}, new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainActivity$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.showUiSelectionDialog$lambda$41(MainActivity.this, dialogInterface, i);
            }
        }).show();
    }

    public static final void showUiSelectionDialog$lambda$41(MainActivity mainActivity, DialogInterface dialogInterface, int i) {
        MovieList.INSTANCE.setUiMode(mainActivity, i == 0 ? "tv" : "mobile");
        mainActivity.loadAppropriateFragment();
    }

    private final void loadAppropriateFragment() {
        boolean isTvHardware = Intrinsics.areEqual(MovieList.INSTANCE.getUiMode(), "tv") ? true : Intrinsics.areEqual(MovieList.INSTANCE.getUiMode(), "mobile") ? false : isTvHardware(this);
        setRequestedOrientation(isTvHardware ? 0 : -1);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_browse_fragment, isTvHardware ? new MainFragment() : new MobileMainFragment()).commit();
    }

    private final boolean isTvHardware(Context context) {
        Object systemService = context.getSystemService("uimode");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        return ((UiModeManager) systemService).getCurrentModeType() == 4;
    }
}
