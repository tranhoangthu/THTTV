package com.tvstore.ok;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.leanback.widget.RowPresenter;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.tvstore.ok.LicenseManager;
import com.tvstore.ok.MainFragment;
import com.tvstore.ok.MovieList;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MainFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 '2\u00020\u0001:\u0005#$%&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002J\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001c\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\rH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\rH\u0002J\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/tvstore/ok/MainFragment;", "Landroidx/leanback/app/BrowseSupportFragment;", "<init>", "()V", "mHandler", "Landroid/os/Handler;", "mBackgroundManager", "Landroidx/leanback/app/BackgroundManager;", "mDefaultBackground", "Landroid/graphics/drawable/Drawable;", "mMetrics", "Landroid/util/DisplayMetrics;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityCreated", "onStart", "prepareBackgroundManager", "setupUIElements", "loadRows", "rebuildAdapter", "showCategoryVisibilityManager", "showSourceSelector", "showSourceManager", "showAddSourceDialog", "showFakeErrorDialog", "showFeedbackDialog", "showPendingDialog", "showRegistrationDialog", "showActualAddSourceDialog", "setupEventListeners", "refreshSourceData", "IconHeaderItem", "IconHeaderPresenter", "SettingItem", "GridItemPresenter", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class MainFragment extends BrowseSupportFragment {
    private static final String TAG = "MainFragment";
    private BackgroundManager mBackgroundManager;
    private Drawable mDefaultBackground;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private DisplayMetrics mMetrics;

    /* compiled from: MainFragment.kt */
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

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("XemTV24H - OkPlayer");
        setBadgeDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.app_icon_your_company));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareBackgroundManager();
        setupUIElements();
        setTitle("XemTV24H - OkPlayer");
        setBadgeDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.app_icon_your_company));
        prepareEntranceTransition();
        loadRows();
        EpgManager.INSTANCE.fetchEpg(new Function0() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MainFragment.onActivityCreated$lambda$1(MainFragment.this);
            }
        });
        setupEventListeners();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onActivityCreated$lambda$1(final MainFragment mainFragment) {
        mainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda32
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.onActivityCreated$lambda$1$lambda$0(MainFragment.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onActivityCreated$lambda$1$lambda$0(MainFragment mainFragment) {
        if (mainFragment.isAdded()) {
            mainFragment.rebuildAdapter();
        }
    }

    @Override // androidx.leanback.app.BrowseSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View view;
        View findViewById;
        super.onStart();
        int identifier = getResources().getIdentifier("browse_title_group", TtmlNode.ATTR_ID, requireActivity().getPackageName());
        if (identifier == 0 || (view = getView()) == null || (findViewById = view.findViewById(identifier)) == null) {
            return;
        }
        findViewById.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                MainFragment.onStart$lambda$3$lambda$2(view2, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.getMarginStart() == 0) {
            return;
        }
        marginLayoutParams.setMarginStart(0);
        findViewById.setLayoutParams(marginLayoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onStart$lambda$3$lambda$2(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.getMarginStart() == 0) {
            return;
        }
        marginLayoutParams.setMarginStart(0);
        view.setLayoutParams(marginLayoutParams);
    }

    private final void prepareBackgroundManager() {
        BackgroundManager backgroundManager = BackgroundManager.getInstance(requireActivity());
        Intrinsics.checkNotNullExpressionValue(backgroundManager, "getInstance(...)");
        this.mBackgroundManager = backgroundManager;
        DisplayMetrics displayMetrics = null;
        if (backgroundManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBackgroundManager");
            backgroundManager = null;
        }
        backgroundManager.attach(requireActivity().getWindow());
        this.mDefaultBackground = ContextCompat.getDrawable(requireActivity(), R.drawable.default_background);
        this.mMetrics = new DisplayMetrics();
        Display defaultDisplay = requireActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics2 = this.mMetrics;
        if (displayMetrics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMetrics");
        } else {
            displayMetrics = displayMetrics2;
        }
        defaultDisplay.getMetrics(displayMetrics);
    }

    private final void setupUIElements() {
        setTitle("XemTV24H - OkPlayer");
        setBadgeDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.app_icon_your_company));
        setHeadersState(1);
        setHeadersTransitionOnBackEnabled(true);
        final IconHeaderPresenter iconHeaderPresenter = new IconHeaderPresenter();
        setHeaderPresenterSelector(new PresenterSelector() { // from class: com.tvstore.ok.MainFragment$setupUIElements$1
            @Override // androidx.leanback.widget.PresenterSelector
            public Presenter getPresenter(Object item) {
                return MainFragment.IconHeaderPresenter.this;
            }
        });
        setBrandColor(ContextCompat.getColor(requireActivity(), R.color.fastlane_background));
        setSearchAffordanceColor(ContextCompat.getColor(requireActivity(), R.color.search_opaque));
        setOnSearchClickedListener(new View.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r0.startActivity(new Intent(MainFragment.this.requireActivity(), (Class<?>) SearchActivity.class));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadRows() {
        MovieList.INSTANCE.getMovies(new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainFragment.loadRows$lambda$6(MainFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit loadRows$lambda$6(final MainFragment mainFragment, List list) {
        Intrinsics.checkNotNullParameter(list, "<unused var>");
        mainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.loadRows$lambda$6$lambda$5(MainFragment.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadRows$lambda$6$lambda$5(MainFragment mainFragment) {
        if (mainFragment.isAdded()) {
            mainFragment.rebuildAdapter();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00fe, code lost:
    
        if (r9 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void rebuildAdapter() {
        /*
            Method dump skipped, instructions count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.MainFragment.rebuildAdapter():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuildAdapter$lambda$8(final MainFragment mainFragment, Movie movie) {
        Intrinsics.checkNotNullParameter(movie, "movie");
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.toggleFavorite(requireActivity, movie);
        Toast.makeText(mainFragment.requireActivity(), MovieList.INSTANCE.isFavorite(movie) ? "❤️ Đã thêm yêu thích" : "💔 Đã xóa yêu thích", 0).show();
        mainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.rebuildAdapter$lambda$8$lambda$7(MainFragment.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void rebuildAdapter$lambda$8$lambda$7(MainFragment mainFragment) {
        if (mainFragment.isAdded()) {
            mainFragment.rebuildAdapter();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void rebuildAdapter$lambda$18(MainFragment mainFragment, Movie movie) {
        if (mainFragment.isAdded()) {
            Intent intent = new Intent(mainFragment.requireActivity(), (Class<?>) PlaybackActivity.class);
            intent.putExtra(DetailsActivity.MOVIE, movie);
            mainFragment.startActivity(intent);
        }
    }

    private final void showCategoryVisibilityManager() {
        final String[] strArr = (String[]) CollectionsKt.sorted(MovieList.INSTANCE.getAllCategories()).toArray(new String[0]);
        if (strArr.length == 0) {
            Toast.makeText(requireActivity(), "Chưa có danh sách nhóm!", 0).show();
            return;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(Boolean.valueOf(!MovieList.INSTANCE.isCategoryHidden(str)));
        }
        new AlertDialog.Builder(requireActivity()).setTitle("Chọn nhóm kênh muốn HIỂN THỊ").setMultiChoiceItems(strArr, CollectionsKt.toBooleanArray(arrayList), new DialogInterface.OnMultiChoiceClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda21
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                MainFragment.showCategoryVisibilityManager$lambda$20(MainFragment.this, strArr, dialogInterface, i, z);
            }
        }).setPositiveButton("Xong", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda23
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.showCategoryVisibilityManager$lambda$21(MainFragment.this, dialogInterface, i);
            }
        }).setNeutralButton("Hiện tất cả", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda24
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.showCategoryVisibilityManager$lambda$23(strArr, this, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showCategoryVisibilityManager$lambda$20(MainFragment mainFragment, String[] strArr, DialogInterface dialogInterface, int i, boolean z) {
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.toggleCategoryVisibility(requireActivity, strArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showCategoryVisibilityManager$lambda$21(MainFragment mainFragment, DialogInterface dialogInterface, int i) {
        mainFragment.rebuildAdapter();
        Toast.makeText(mainFragment.requireActivity(), "Đã cập nhật danh sách nhóm", 0).show();
    }

    private final void showSourceSelector() {
        List<MovieList.TvSource> sources = MovieList.INSTANCE.getSources();
        if (sources.isEmpty()) {
            showAddSourceDialog();
            return;
        }
        List<MovieList.TvSource> list = sources;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MovieList.TvSource) it.next()).getName());
        }
        new AlertDialog.Builder(requireActivity()).setTitle("Chọn nguồn TV").setSingleChoiceItems((String[]) arrayList.toArray(new String[0]), MovieList.INSTANCE.getCurrentSourceIndex(), new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda20
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.showSourceSelector$lambda$27(MainFragment.this, dialogInterface, i);
            }
        }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showSourceSelector$lambda$27(final MainFragment mainFragment, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.switchSource(requireActivity, i, new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainFragment.showSourceSelector$lambda$27$lambda$26(MainFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showSourceSelector$lambda$27$lambda$26(final MainFragment mainFragment, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.this.loadRows();
            }
        });
        return Unit.INSTANCE;
    }

    private final void showSourceManager() {
        final List<MovieList.TvSource> sources = MovieList.INSTANCE.getSources();
        if (sources.isEmpty()) {
            Toast.makeText(requireActivity(), "Chưa có nguồn nào!", 0).show();
            return;
        }
        List<MovieList.TvSource> list = sources;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (MovieList.TvSource tvSource : list) {
            arrayList.add(tvSource.getName() + "\n" + tvSource.getUrl());
        }
        new AlertDialog.Builder(requireActivity()).setTitle("Quản lý nguồn (Nhấn để xóa)").setItems((String[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                new AlertDialog.Builder(r0.requireActivity()).setTitle("Xác nhận xóa").setMessage("Bạn có chắc chắn muốn xóa nguồn: " + ((MovieList.TvSource) sources.get(i)).getName() + "?").setPositiveButton("Xóa", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda12
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i2) {
                        MainFragment.showSourceManager$lambda$30$lambda$29(MainFragment.this, i, dialogInterface2, i2);
                    }
                }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showSourceManager$lambda$30$lambda$29(MainFragment mainFragment, int i, DialogInterface dialogInterface, int i2) {
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.deleteSource(requireActivity, i);
        Toast.makeText(mainFragment.requireActivity(), "Đã xóa nguồn", 0).show();
        mainFragment.loadRows();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAddSourceDialog() {
        final ProgressDialog progressDialog = new ProgressDialog(requireActivity());
        progressDialog.setMessage("Đang tải...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        LicenseManager licenseManager = LicenseManager.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        licenseManager.checkLicense(requireActivity, new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainFragment.showAddSourceDialog$lambda$32(MainFragment.this, progressDialog, (LicenseManager.LicenseStatus) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showAddSourceDialog$lambda$32(MainFragment mainFragment, ProgressDialog progressDialog, LicenseManager.LicenseStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (!mainFragment.isAdded()) {
            return Unit.INSTANCE;
        }
        progressDialog.dismiss();
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            mainFragment.showActualAddSourceDialog();
        } else if (i == 2) {
            mainFragment.showPendingDialog();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            mainFragment.showFakeErrorDialog();
        }
        return Unit.INSTANCE;
    }

    private final void showFakeErrorDialog() {
        new AlertDialog.Builder(requireActivity()).setTitle("Đã xảy ra lỗi").setMessage("Đã xảy ra lỗi không mong muốn, tính năng hiện không khả dụng.\n\nVui lòng liên hệ nhà phát triển để được hỗ trợ.").setCancelable(true).setPositiveButton("Liên hệ", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.this.showFeedbackDialog();
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFeedbackDialog() {
        final FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        FragmentActivity fragmentActivity = requireActivity;
        LicenseManager.INSTANCE.getDeviceId(fragmentActivity);
        String loadDeviceName = LicenseManager.INSTANCE.loadDeviceName(fragmentActivity);
        LinearLayout linearLayout = new LinearLayout(fragmentActivity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding(50, 30, 50, 20);
        TextView textView = new TextView(fragmentActivity);
        textView.setText("Hãy để lại thông tin để nhà phát triển kiểm tra và phản hồi sớm nhất:");
        textView.setTextColor(Color.parseColor("#CCCCCC"));
        textView.setTextSize(13.0f);
        textView.setPadding(0, 0, 0, 16);
        linearLayout.addView(textView);
        final EditText editText = new EditText(fragmentActivity);
        editText.setHint("Nhập nội dung phản hồi...");
        editText.setText(loadDeviceName);
        editText.setInputType(1);
        editText.setMaxLines(1);
        editText.setSingleLine(true);
        linearLayout.addView(editText);
        new AlertDialog.Builder(fragmentActivity).setTitle("Gửi phản hồi").setView(linearLayout).setPositiveButton("Gửi", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda33
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.showFeedbackDialog$lambda$40(editText, requireActivity, this, dialogInterface, i);
            }
        }).setNegativeButton("Huỷ", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showFeedbackDialog$lambda$40(EditText editText, final FragmentActivity fragmentActivity, final MainFragment mainFragment, DialogInterface dialogInterface, int i) {
        String obj = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (obj.length() == 0) {
            Toast.makeText(fragmentActivity, "Vui lòng nhập nội dung!", 0).show();
            mainFragment.showFeedbackDialog();
            return;
        }
        FragmentActivity fragmentActivity2 = fragmentActivity;
        final ProgressDialog progressDialog = new ProgressDialog(fragmentActivity2);
        progressDialog.setMessage("Đang gửi...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        LicenseManager.INSTANCE.registerDevice(fragmentActivity2, obj, new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return MainFragment.showFeedbackDialog$lambda$40$lambda$39(MainFragment.this, progressDialog, fragmentActivity, ((Boolean) obj2).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFeedbackDialog$lambda$40$lambda$39(final MainFragment mainFragment, ProgressDialog progressDialog, FragmentActivity fragmentActivity, boolean z) {
        if (!mainFragment.isAdded()) {
            return Unit.INSTANCE;
        }
        progressDialog.dismiss();
        if (z) {
            new AlertDialog.Builder(fragmentActivity).setTitle("Đã gửi").setMessage("Cảm ơn bạn đã phản hồi! Nhà phát triển sẽ kiểm tra và liên hệ lại sớm nhất có thể.").setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
        } else {
            new AlertDialog.Builder(fragmentActivity).setTitle("Gửi thất bại").setMessage("Không thể gửi phản hồi lúc này.\n\nVui lòng kiểm tra kết nối mạng và thử lại sau.").setPositiveButton("Thử lại", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MainFragment.this.showFeedbackDialog();
                }
            }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
        }
        return Unit.INSTANCE;
    }

    private final void showPendingDialog() {
        new AlertDialog.Builder(requireActivity()).setTitle("Đã gửi").setMessage("Cảm ơn bạn đã phản hồi! Chúng tôi đã ghi nhận và đang kiểm tra sự cố.\n\nVui lòng thử lại sau ít phút.").setPositiveButton("Thử lại", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda14
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.this.showAddSourceDialog();
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    private final void showRegistrationDialog() {
        showFakeErrorDialog();
    }

    private final void showActualAddSourceDialog() {
        LinearLayout linearLayout = new LinearLayout(requireActivity());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(40, 20, 40, 20);
        final EditText editText = new EditText(requireActivity());
        editText.setHint("Tên nguồn");
        editText.setInputType(1);
        editText.setImeOptions(5);
        editText.setMaxLines(1);
        editText.setSingleLine(true);
        final EditText editText2 = new EditText(requireActivity());
        editText2.setHint("URL");
        editText2.setText("https://byvn.net/");
        editText2.setInputType(17);
        editText2.setImeOptions(6);
        editText2.setMaxLines(1);
        editText2.setSingleLine(true);
        editText2.setSelection(editText2.getText().length());
        linearLayout.addView(editText);
        linearLayout.addView(editText2);
        TextView textView = new TextView(requireActivity());
        textView.setText("--- HOẶC ---");
        textView.setGravity(17);
        textView.setPadding(0, 10, 0, 10);
        linearLayout.addView(textView);
        Button button = new Button(requireActivity());
        button.setText("📁 Chọn file .m3u từ máy");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainFragment.showActualAddSourceDialog$lambda$47$lambda$46(MainFragment.this, view);
            }
        });
        linearLayout.addView(button);
        new AlertDialog.Builder(requireActivity()).setTitle("Thêm nguồn mới").setView(linearLayout).setPositiveButton("Lưu và Mở", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda17
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.showActualAddSourceDialog$lambda$52(editText, editText2, this, dialogInterface, i);
            }
        }).setNeutralButton("Chỉ Lưu", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MainFragment.showActualAddSourceDialog$lambda$56(editText, editText2, this, dialogInterface, i);
            }
        }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$47$lambda$46(MainFragment mainFragment, View view) {
        FragmentActivity requireActivity = mainFragment.requireActivity();
        MainActivity mainActivity = requireActivity instanceof MainActivity ? (MainActivity) requireActivity : null;
        if (mainActivity != null) {
            mainActivity.openFilePicker();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$52(EditText editText, EditText editText2, final MainFragment mainFragment, DialogInterface dialogInterface, int i) {
        String obj = editText.getText().toString();
        String obj2 = editText2.getText().toString();
        if (obj.length() <= 0 || obj2.length() <= 0) {
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(mainFragment.requireActivity());
        progressDialog.setMessage("Đang kiểm tra...");
        progressDialog.show();
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.addSource(requireActivity, obj, obj2, true, new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return MainFragment.showActualAddSourceDialog$lambda$52$lambda$51(MainFragment.this, progressDialog, ((Boolean) obj3).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showActualAddSourceDialog$lambda$52$lambda$51(final MainFragment mainFragment, final ProgressDialog progressDialog, final boolean z) {
        mainFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.showActualAddSourceDialog$lambda$52$lambda$51$lambda$50(progressDialog, z, mainFragment);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$52$lambda$51$lambda$50(ProgressDialog progressDialog, boolean z, final MainFragment mainFragment) {
        progressDialog.dismiss();
        if (z) {
            MovieList.INSTANCE.getMovies(new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainFragment.showActualAddSourceDialog$lambda$52$lambda$51$lambda$50$lambda$49(MainFragment.this, (List) obj);
                }
            });
        } else {
            Toast.makeText(mainFragment.requireActivity(), "URL không hợp lệ!", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showActualAddSourceDialog$lambda$52$lambda$51$lambda$50$lambda$49(MainFragment mainFragment, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mainFragment.loadRows();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$56(EditText editText, EditText editText2, final MainFragment mainFragment, DialogInterface dialogInterface, int i) {
        String obj = editText.getText().toString();
        String obj2 = editText2.getText().toString();
        if (obj.length() <= 0 || obj2.length() <= 0) {
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(mainFragment.requireActivity());
        progressDialog.setMessage("Đang kiểm tra...");
        progressDialog.show();
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.addSource(requireActivity, obj, obj2, false, new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return MainFragment.showActualAddSourceDialog$lambda$56$lambda$55(MainFragment.this, progressDialog, ((Boolean) obj3).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showActualAddSourceDialog$lambda$56$lambda$55(final MainFragment mainFragment, final ProgressDialog progressDialog, final boolean z) {
        mainFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.showActualAddSourceDialog$lambda$56$lambda$55$lambda$54(progressDialog, z, mainFragment);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$56$lambda$55$lambda$54(ProgressDialog progressDialog, boolean z, MainFragment mainFragment) {
        progressDialog.dismiss();
        if (z) {
            Toast.makeText(mainFragment.requireActivity(), "Đã lưu nguồn!", 0).show();
        } else {
            Toast.makeText(mainFragment.requireActivity(), "URL không hợp lệ!", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/tvstore/ok/MainFragment$IconHeaderItem;", "Landroidx/leanback/widget/HeaderItem;", TtmlNode.ATTR_ID, "", "name", "", "iconRes", "", "<init>", "(JLjava/lang/String;I)V", "getIconRes", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class IconHeaderItem extends HeaderItem {
        private final int iconRes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IconHeaderItem(long j, String name, int i) {
            super(j, name);
            Intrinsics.checkNotNullParameter(name, "name");
            this.iconRes = i;
        }

        public final int getIconRes() {
            return this.iconRes;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainFragment.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lcom/tvstore/ok/MainFragment$IconHeaderPresenter;", "Landroidx/leanback/widget/RowHeaderPresenter;", "<init>", "(Lcom/tvstore/ok/MainFragment;)V", "onCreateViewHolder", "Landroidx/leanback/widget/Presenter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "", "viewHolder", "item", "", "onSelectLevelChanged", "holder", "Landroidx/leanback/widget/RowHeaderPresenter$ViewHolder;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public final class IconHeaderPresenter extends RowHeaderPresenter {
        public IconHeaderPresenter() {
        }

        @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
        public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Presenter.ViewHolder onCreateViewHolder = super.onCreateViewHolder(parent);
            Intrinsics.checkNotNullExpressionValue(onCreateViewHolder, "onCreateViewHolder(...)");
            View view = onCreateViewHolder.view;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) view;
            linearLayout.setOrientation(0);
            ImageView imageView = new ImageView(parent.getContext());
            imageView.setId(View.generateViewId());
            float f = parent.getContext().getResources().getDisplayMetrics().density;
            int i = (int) (16.0f * f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.setMarginEnd((int) (8.0f * f));
            layoutParams.gravity = 16;
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setColorFilter(-1);
            imageView.setBackground(null);
            imageView.setPadding(0, 0, 0, 0);
            linearLayout.addView(imageView, 0);
            return onCreateViewHolder;
        }

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0041, code lost:
        
            if (r12 == null) goto L8;
         */
        @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onBindViewHolder(androidx.leanback.widget.Presenter.ViewHolder r11, java.lang.Object r12) {
            /*
                r10 = this;
                java.lang.String r0 = "viewHolder"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                java.lang.String r0 = "null cannot be cast to non-null type androidx.leanback.widget.ListRow"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r12, r0)
                r0 = r12
                androidx.leanback.widget.ListRow r0 = (androidx.leanback.widget.ListRow) r0
                androidx.leanback.widget.HeaderItem r0 = r0.getHeaderItem()
                android.view.View r1 = r11.view
                java.lang.String r2 = "null cannot be cast to non-null type android.widget.LinearLayout"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
                android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
                r2 = 0
                android.view.View r3 = r1.getChildAt(r2)
                java.lang.String r4 = "null cannot be cast to non-null type android.widget.ImageView"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
                android.widget.ImageView r3 = (android.widget.ImageView) r3
                super.onBindViewHolder(r11, r12)
                boolean r12 = r0 instanceof com.tvstore.ok.MainFragment.IconHeaderItem
                r4 = 0
                if (r12 == 0) goto Lc2
                com.tvstore.ok.MainFragment$IconHeaderItem r0 = (com.tvstore.ok.MainFragment.IconHeaderItem) r0
                java.lang.String r12 = r0.getName()
                if (r12 == 0) goto L43
                java.util.Locale r5 = java.util.Locale.ROOT
                java.lang.String r12 = r12.toUpperCase(r5)
                java.lang.String r5 = "toUpperCase(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r5)
                if (r12 != 0) goto L45
            L43:
                java.lang.String r12 = ""
            L45:
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                java.lang.String r5 = "XemTV24H - OkPlayer"
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                r6 = 2
                boolean r5 = kotlin.text.StringsKt.contains$default(r12, r5, r2, r6, r4)
                r3.setVisibility(r2)
                int r0 = r0.getIconRes()
                r3.setImageResource(r0)
                android.content.Context r0 = r1.getContext()
                android.content.res.Resources r0 = r0.getResources()
                android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
                float r0 = r0.density
                r7 = 16
                r8 = 1090519040(0x41000000, float:8.0)
                if (r5 == 0) goto L8f
                r12 = 1107296256(0x42000000, float:32.0)
                float r12 = r12 * r0
                int r12 = (int) r12
                android.widget.LinearLayout$LayoutParams r5 = new android.widget.LinearLayout$LayoutParams
                r5.<init>(r12, r12)
                float r8 = r8 * r0
                int r12 = (int) r8
                r5.setMarginEnd(r12)
                r5.gravity = r7
                android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
                r3.setLayoutParams(r5)
                r3.clearColorFilter()
                r1.setFocusable(r2)
                r1.setFocusableInTouchMode(r2)
                goto Lc7
            L8f:
                r5 = 1098907648(0x41800000, float:16.0)
                float r5 = r5 * r0
                int r5 = (int) r5
                android.widget.LinearLayout$LayoutParams r9 = new android.widget.LinearLayout$LayoutParams
                r9.<init>(r5, r5)
                float r8 = r8 * r0
                int r0 = (int) r8
                r9.setMarginEnd(r0)
                r9.gravity = r7
                android.view.ViewGroup$LayoutParams r9 = (android.view.ViewGroup.LayoutParams) r9
                r3.setLayoutParams(r9)
                java.lang.String r0 = "THÍCH"
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r12 = kotlin.text.StringsKt.contains$default(r12, r0, r2, r6, r4)
                if (r12 == 0) goto Lb6
                r12 = -65536(0xffffffffffff0000, float:NaN)
                r3.setColorFilter(r12)
                goto Lba
            Lb6:
                r12 = -1
                r3.setColorFilter(r12)
            Lba:
                r12 = 1
                r1.setFocusable(r12)
                r1.setFocusableInTouchMode(r12)
                goto Lc7
            Lc2:
                r12 = 8
                r3.setVisibility(r12)
            Lc7:
                r12 = 1065353216(0x3f800000, float:1.0)
                r1.setAlpha(r12)
                android.view.View r12 = r11.view
                r12.setBackground(r4)
                android.view.View r11 = r11.view
                r11.setBackgroundColor(r2)
                r1.setBackground(r4)
                r1.setBackgroundColor(r2)
                com.tvstore.ok.MainFragment$IconHeaderPresenter$$ExternalSyntheticLambda0 r11 = new com.tvstore.ok.MainFragment$IconHeaderPresenter$$ExternalSyntheticLambda0
                r11.<init>()
                r1.setOnFocusChangeListener(r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.MainFragment.IconHeaderPresenter.onBindViewHolder(androidx.leanback.widget.Presenter$ViewHolder, java.lang.Object):void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$2(LinearLayout linearLayout, View view, boolean z) {
            CharSequence text;
            String obj;
            CharSequence text2;
            String obj2;
            int identifier = linearLayout.getContext().getResources().getIdentifier("row_header", TtmlNode.ATTR_ID, linearLayout.getContext().getPackageName());
            TextView textView = identifier != 0 ? (TextView) linearLayout.findViewById(identifier) : null;
            View childAt = linearLayout.getChildAt(0);
            ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
            if (z) {
                if (textView != null) {
                    textView.setTypeface(null, 1);
                }
                if (textView != null) {
                    textView.setTextColor(Color.parseColor("#FF9800"));
                }
                if (imageView == null || imageView.getVisibility() != 0) {
                    return;
                }
                if (textView != null && (text2 = textView.getText()) != null && (obj2 = text2.toString()) != null) {
                    String upperCase = obj2.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    if (upperCase != null && StringsKt.contains$default((CharSequence) upperCase, (CharSequence) "THÍCH", false, 2, (Object) null)) {
                        imageView.setColorFilter(SupportMenu.CATEGORY_MASK);
                        return;
                    }
                }
                imageView.setColorFilter(Color.parseColor("#FF9800"));
                return;
            }
            if (textView != null) {
                textView.setTypeface(null, 0);
            }
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#EEEEEE"));
            }
            if (imageView == null || imageView.getVisibility() != 0) {
                return;
            }
            if (textView != null && (text = textView.getText()) != null && (obj = text.toString()) != null) {
                String upperCase2 = obj.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                if (upperCase2 != null && StringsKt.contains$default((CharSequence) upperCase2, (CharSequence) "THÍCH", false, 2, (Object) null)) {
                    imageView.setColorFilter(SupportMenu.CATEGORY_MASK);
                    return;
                }
            }
            imageView.setColorFilter(-1);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x0109  */
        @Override // androidx.leanback.widget.RowHeaderPresenter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSelectLevelChanged(androidx.leanback.widget.RowHeaderPresenter.ViewHolder r14) {
            /*
                Method dump skipped, instructions count: 305
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.MainFragment.IconHeaderPresenter.onSelectLevelChanged(androidx.leanback.widget.RowHeaderPresenter$ViewHolder):void");
        }
    }

    private final void setupEventListeners() {
        setOnItemViewClickedListener(new OnItemViewClickedListener() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda31
            @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
            public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
                MainFragment.setupEventListeners$lambda$57(MainFragment.this, viewHolder, obj, viewHolder2, row);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupEventListeners$lambda$57(MainFragment mainFragment, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof Movie) {
            if (((Movie) obj).getId() < 0) {
                return;
            }
            Intent intent = new Intent(mainFragment.getActivity(), (Class<?>) PlaybackActivity.class);
            intent.putExtra(DetailsActivity.MOVIE, (Serializable) obj);
            mainFragment.startActivity(intent);
            return;
        }
        if (obj instanceof SettingItem) {
            String text = ((SettingItem) obj).getText();
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) "Nguồn:", false, 2, (Object) null)) {
                mainFragment.showSourceSelector();
                return;
            }
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) "Thêm nguồn", false, 2, (Object) null)) {
                mainFragment.showAddSourceDialog();
                return;
            }
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) "Quản lý nguồn", false, 2, (Object) null)) {
                mainFragment.showSourceManager();
                return;
            }
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) "Ẩn/Hiện nhóm", false, 2, (Object) null)) {
                mainFragment.showCategoryVisibilityManager();
                return;
            }
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) "dữ liệu nguồn", false, 2, (Object) null)) {
                mainFragment.refreshSourceData();
                return;
            }
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) "Mobile", false, 2, (Object) null)) {
                MovieList movieList = MovieList.INSTANCE;
                FragmentActivity requireActivity = mainFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                movieList.setUiMode(requireActivity, "mobile");
                mainFragment.requireActivity().recreate();
                return;
            }
            if (StringsKt.contains$default((CharSequence) text, (CharSequence) "cập nhật", false, 2, (Object) null)) {
                UpdateManager updateManager = UpdateManager.INSTANCE;
                FragmentActivity requireActivity2 = mainFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
                updateManager.checkUpdate(requireActivity2, "hieu-TQS/ok", true);
            }
        }
    }

    private final void refreshSourceData() {
        Toast.makeText(requireActivity(), "Đang cập nhật dữ liệu...", 0).show();
        MovieList.INSTANCE.getMovies(new Function1() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainFragment.refreshSourceData$lambda$59(MainFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit refreshSourceData$lambda$59(final MainFragment mainFragment, final List movies) {
        Intrinsics.checkNotNullParameter(movies, "movies");
        mainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MainFragment$$ExternalSyntheticLambda27
            @Override // java.lang.Runnable
            public final void run() {
                MainFragment.refreshSourceData$lambda$59$lambda$58(MainFragment.this, movies);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void refreshSourceData$lambda$59$lambda$58(MainFragment mainFragment, List list) {
        if (mainFragment.isAdded()) {
            if (!list.isEmpty()) {
                Toast.makeText(mainFragment.requireActivity(), "✅ Đã cập nhật " + list.size() + " kênh", 0).show();
                mainFragment.rebuildAdapter();
                return;
            }
            Toast.makeText(mainFragment.requireActivity(), "❌ Không thể cập nhật!", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/tvstore/ok/MainFragment$SettingItem;", "", "iconRes", "", "text", "", "<init>", "(ILjava/lang/String;)V", "getIconRes", "()I", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final /* data */ class SettingItem {
        private final int iconRes;
        private final String text;

        public static /* synthetic */ SettingItem copy$default(SettingItem settingItem, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = settingItem.iconRes;
            }
            if ((i2 & 2) != 0) {
                str = settingItem.text;
            }
            return settingItem.copy(i, str);
        }

        /* renamed from: component1, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* renamed from: component2, reason: from getter */
        public final String getText() {
            return this.text;
        }

        public final SettingItem copy(int iconRes, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            return new SettingItem(iconRes, text);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SettingItem)) {
                return false;
            }
            SettingItem settingItem = (SettingItem) other;
            return this.iconRes == settingItem.iconRes && Intrinsics.areEqual(this.text, settingItem.text);
        }

        public int hashCode() {
            return (this.iconRes * 31) + this.text.hashCode();
        }

        public String toString() {
            return "SettingItem(iconRes=" + this.iconRes + ", text=" + this.text + ")";
        }

        public SettingItem(int i, String text) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.iconRes = i;
            this.text = text;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MainFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/tvstore/ok/MainFragment$GridItemPresenter;", "Landroidx/leanback/widget/Presenter;", "<init>", "(Lcom/tvstore/ok/MainFragment;)V", "sSelectedBackgroundColor", "", "sDefaultBackgroundColor", "onCreateViewHolder", "Landroidx/leanback/widget/Presenter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "", "vh", "item", "", "onUnbindViewHolder", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public final class GridItemPresenter extends Presenter {
        private int sDefaultBackgroundColor;
        private int sSelectedBackgroundColor;

        @Override // androidx.leanback.widget.Presenter
        public void onUnbindViewHolder(Presenter.ViewHolder vh) {
            Intrinsics.checkNotNullParameter(vh, "vh");
        }

        public GridItemPresenter() {
        }

        @Override // androidx.leanback.widget.Presenter
        public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            if (this.sDefaultBackgroundColor == 0) {
                this.sDefaultBackgroundColor = ContextCompat.getColor(parent.getContext(), R.color.default_background);
                this.sSelectedBackgroundColor = ContextCompat.getColor(parent.getContext(), R.color.selected_background);
            }
            LinearLayout linearLayout = new LinearLayout(parent.getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            float f = parent.getContext().getResources().getDisplayMetrics().density;
            linearLayout.setLayoutParams(new ViewGroup.LayoutParams((int) (190.0f * f), (int) (159.0f * f)));
            linearLayout.setFocusable(true);
            linearLayout.setFocusableInTouchMode(true);
            linearLayout.setBackgroundColor(this.sDefaultBackgroundColor);
            linearLayout.setPadding(16, 16, 16, 16);
            linearLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tvstore.ok.MainFragment$GridItemPresenter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    view.setBackgroundColor(r2 ? r0.sSelectedBackgroundColor : MainFragment.GridItemPresenter.this.sDefaultBackgroundColor);
                }
            });
            ImageView imageView = new ImageView(parent.getContext());
            float f2 = parent.getContext().getResources().getDisplayMetrics().density;
            int i = (int) (48.0f * f2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
            layoutParams.bottomMargin = (int) (8.0f * f2);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setColorFilter(-1);
            linearLayout.addView(imageView);
            TextView textView = new TextView(parent.getContext());
            textView.setTextColor(-1);
            textView.setGravity(17);
            textView.setTextSize(14.0f);
            textView.setTypeface(null, 1);
            textView.setMaxLines(4);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout.addView(textView);
            return new Presenter.ViewHolder(linearLayout);
        }

        @Override // androidx.leanback.widget.Presenter
        public void onBindViewHolder(Presenter.ViewHolder vh, Object item) {
            Intrinsics.checkNotNullParameter(vh, "vh");
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tvstore.ok.MainFragment.SettingItem");
            SettingItem settingItem = (SettingItem) item;
            View view = vh.view;
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout = (LinearLayout) view;
            View childAt = linearLayout.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
            View childAt2 = linearLayout.getChildAt(1);
            Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.TextView");
            ((ImageView) childAt).setImageResource(settingItem.getIconRes());
            ((TextView) childAt2).setText(settingItem.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showCategoryVisibilityManager$lambda$23(String[] strArr, MainFragment mainFragment, DialogInterface dialogInterface, int i) {
        for (String str : strArr) {
            if (MovieList.INSTANCE.isCategoryHidden(str)) {
                MovieList movieList = MovieList.INSTANCE;
                FragmentActivity requireActivity = mainFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                movieList.toggleCategoryVisibility(requireActivity, str);
            }
        }
        mainFragment.rebuildAdapter();
    }
}
