package com.tvstore.ok;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.tvprovider.media.tv.TvContractCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tvstore.ok.LicenseManager;
import com.tvstore.ok.MobileMainFragment;
import com.tvstore.ok.MovieList;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: MobileMainFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0003+,-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\nH\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\b\u0010*\u001a\u00020\u0015H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/tvstore/ok/MobileMainFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "categoryRecycler", "Landroidx/recyclerview/widget/RecyclerView;", "channelRecycler", "mHandler", "Landroid/os/Handler;", "selectedCategory", "", "searchQuery", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "loadData", "", "forceReloadUI", "setupCategories", "updateChannelList", "removeVietnameseTones", "str", "showSourceSelector", "showSourceManager", "showCategoryVisibilityManager", "showMobileSettings", "refreshSourceData", "showColumnSettings", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "confirmUiSwitch", "mode", "showAddSourceDialog", "showFakeErrorDialog", "showFeedbackDialog", "showPendingDialog", "showActualAddSourceDialog", "CategoryTabAdapter", "MobileMovieAdapter", "SettingItem", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class MobileMainFragment extends Fragment {
    private RecyclerView categoryRecycler;
    private RecyclerView channelRecycler;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private String selectedCategory = "Tất cả";
    private String searchQuery = "";

    /* compiled from: MobileMainFragment.kt */
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_mobile_main, container, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.category_recycler);
        this.categoryRecycler = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        this.channelRecycler = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("okPrefs", 0);
        boolean z = getResources().getConfiguration().orientation == 2;
        int i = sharedPreferences.getInt(z ? "mobile_columns_landscape" : "mobile_columns_portrait", z ? 3 : 2);
        RecyclerView recyclerView2 = this.channelRecycler;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), i));
        }
        View findViewById = inflate.findViewById(R.id.btn_source);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileMainFragment.this.showSourceSelector();
                }
            });
        }
        View findViewById2 = inflate.findViewById(R.id.btn_settings);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileMainFragment.this.showMobileSettings();
                }
            });
        }
        final EditText editText = (EditText) inflate.findViewById(R.id.search_input);
        final ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.btn_clear_search);
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() { // from class: com.tvstore.ok.MobileMainFragment$onCreateView$3
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    String str;
                    String str2;
                    MobileMainFragment mobileMainFragment = MobileMainFragment.this;
                    if (s == null || (str = s.toString()) == null) {
                        str = "";
                    }
                    mobileMainFragment.searchQuery = str;
                    ImageButton imageButton2 = imageButton;
                    if (imageButton2 != null) {
                        str2 = MobileMainFragment.this.searchQuery;
                        imageButton2.setVisibility(str2.length() > 0 ? 0 : 8);
                    }
                    MobileMainFragment.this.updateChannelList();
                }
            });
        }
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileMainFragment.onCreateView$lambda$2(editText, this, view);
                }
            });
        }
        if (editText != null) {
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda17
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                    return MobileMainFragment.onCreateView$lambda$3(MobileMainFragment.this, editText, textView, i2, keyEvent);
                }
            });
        }
        loadData();
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreateView$lambda$2(EditText editText, MobileMainFragment mobileMainFragment, View view) {
        if (editText != null) {
            editText.setText("");
        }
        mobileMainFragment.searchQuery = "";
        mobileMainFragment.updateChannelList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean onCreateView$lambda$3(MobileMainFragment mobileMainFragment, EditText editText, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        Object systemService = mobileMainFragment.requireActivity().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadData() {
        MovieList.INSTANCE.getMovies(new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MobileMainFragment.loadData$lambda$5(MobileMainFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit loadData$lambda$5(final MobileMainFragment mobileMainFragment, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mobileMainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                MobileMainFragment.loadData$lambda$5$lambda$4(MobileMainFragment.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void loadData$lambda$5$lambda$4(MobileMainFragment mobileMainFragment) {
        if (mobileMainFragment.isAdded()) {
            mobileMainFragment.forceReloadUI();
        }
    }

    public final void forceReloadUI() {
        setupCategories();
        updateChannelList();
        TvHomeManager tvHomeManager = TvHomeManager.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        tvHomeManager.updateHomeChannels(requireActivity);
    }

    private final void setupCategories() {
        List mutableListOf = CollectionsKt.mutableListOf("Tất cả");
        if (!MovieList.INSTANCE.getFavoriteMovies().isEmpty()) {
            mutableListOf.add("❤️ Yêu thích");
        }
        mutableListOf.addAll(MovieList.INSTANCE.getCategories());
        if (!mutableListOf.contains(this.selectedCategory)) {
            this.selectedCategory = "Tất cả";
        }
        RecyclerView recyclerView = this.categoryRecycler;
        if (recyclerView != null) {
            recyclerView.setAdapter(new CategoryTabAdapter(this, mutableListOf, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MobileMainFragment.setupCategories$lambda$6(MobileMainFragment.this, (String) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit setupCategories$lambda$6(MobileMainFragment mobileMainFragment, String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        mobileMainFragment.selectedCategory = category;
        mobileMainFragment.updateChannelList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void updateChannelList() {
        ArrayList moviesByCategory;
        String str = this.selectedCategory;
        switch (str.hashCode()) {
            case -1115456805:
                if (str.equals("Hình ảnh")) {
                    moviesByCategory = MovieList.INSTANCE.getLocalImages();
                    break;
                }
                moviesByCategory = MovieList.INSTANCE.getMoviesByCategory(this.selectedCategory);
                break;
            case 82650203:
                if (str.equals("Video")) {
                    moviesByCategory = MovieList.INSTANCE.getLocalVideos();
                    break;
                }
                moviesByCategory = MovieList.INSTANCE.getMoviesByCategory(this.selectedCategory);
                break;
            case 663577645:
                if (str.equals("❤️ Yêu thích")) {
                    moviesByCategory = MovieList.INSTANCE.getFavoriteMovies();
                    break;
                }
                moviesByCategory = MovieList.INSTANCE.getMoviesByCategory(this.selectedCategory);
                break;
            case 1063433757:
                if (str.equals("Tất cả")) {
                    moviesByCategory = MovieList.INSTANCE.getMovies();
                    break;
                }
                moviesByCategory = MovieList.INSTANCE.getMoviesByCategory(this.selectedCategory);
                break;
            case 2077865586:
                if (str.equals("Âm thanh")) {
                    moviesByCategory = MovieList.INSTANCE.getLocalAudios();
                    break;
                }
                moviesByCategory = MovieList.INSTANCE.getMoviesByCategory(this.selectedCategory);
                break;
            default:
                moviesByCategory = MovieList.INSTANCE.getMoviesByCategory(this.selectedCategory);
                break;
        }
        String obj = StringsKt.trim((CharSequence) this.searchQuery).toString();
        if (obj.length() != 0) {
            String removeVietnameseTones = removeVietnameseTones(obj);
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : moviesByCategory) {
                String title = ((Movie) obj2).getTitle();
                if (title == null) {
                    title = "";
                }
                if (StringsKt.contains$default((CharSequence) removeVietnameseTones(title), (CharSequence) removeVietnameseTones, false, 2, (Object) null)) {
                    arrayList.add(obj2);
                }
            }
            moviesByCategory = arrayList;
        }
        boolean z = Intrinsics.areEqual(this.selectedCategory, "Video") || Intrinsics.areEqual(this.selectedCategory, "Hình ảnh") || Intrinsics.areEqual(this.selectedCategory, "Âm thanh") || StringsKt.contains$default((CharSequence) this.selectedCategory, (CharSequence) "Yêu thích", false, 2, (Object) null);
        if (moviesByCategory.isEmpty() && z) {
            moviesByCategory = CollectionsKt.listOf(new Movie(-999L, "Thư mục trống", null, null, "", "", null, null, null, null, null, null, null, null, null, 32716, null));
        }
        RecyclerView recyclerView = this.channelRecycler;
        if (recyclerView != null) {
            recyclerView.setAdapter(new MobileMovieAdapter(this, moviesByCategory, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return MobileMainFragment.updateChannelList$lambda$8(MobileMainFragment.this, (Movie) obj3);
                }
            }, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj3) {
                    return MobileMainFragment.updateChannelList$lambda$9(MobileMainFragment.this, (Movie) obj3);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateChannelList$lambda$8(MobileMainFragment mobileMainFragment, Movie movie) {
        Intrinsics.checkNotNullParameter(movie, "movie");
        Intent intent = new Intent(mobileMainFragment.requireActivity(), (Class<?>) PlaybackActivity.class);
        intent.putExtra(DetailsActivity.MOVIE, movie);
        mobileMainFragment.startActivity(intent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit updateChannelList$lambda$9(MobileMainFragment mobileMainFragment, Movie movie) {
        Intrinsics.checkNotNullParameter(movie, "movie");
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.toggleFavorite(requireActivity, movie);
        Toast.makeText(mobileMainFragment.requireActivity(), MovieList.INSTANCE.isFavorite(movie) ? "❤️ Đã thêm yêu thích" : "💔 Đã xóa yêu thích", 0).show();
        mobileMainFragment.setupCategories();
        mobileMainFragment.updateChannelList();
        return Unit.INSTANCE;
    }

    private final String removeVietnameseTones(String str) {
        String replaceAll = Pattern.compile("\\p{InCombiningDiacriticalMarks}+").matcher(Normalizer.normalize(str, Normalizer.Form.NFD)).replaceAll("");
        Intrinsics.checkNotNullExpressionValue(replaceAll, "replaceAll(...)");
        String lowerCase = StringsKt.replace$default(StringsKt.replace$default(replaceAll, (char) 273, 'd', false, 4, (Object) null), (char) 272, 'D', false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSourceSelector() {
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
        new AlertDialog.Builder(requireActivity()).setTitle("Chọn nguồn TV").setSingleChoiceItems((String[]) arrayList.toArray(new String[0]), MovieList.INSTANCE.getCurrentSourceIndex(), new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda37
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.showSourceSelector$lambda$13(MobileMainFragment.this, dialogInterface, i);
            }
        }).setNeutralButton("Quản lý", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.this.showSourceManager();
            }
        }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showSourceSelector$lambda$13(final MobileMainFragment mobileMainFragment, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.switchSource(requireActivity, i, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MobileMainFragment.showSourceSelector$lambda$13$lambda$12(MobileMainFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showSourceSelector$lambda$13$lambda$12(final MobileMainFragment mobileMainFragment, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mobileMainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                MobileMainFragment.this.loadData();
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSourceManager() {
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
        new AlertDialog.Builder(requireActivity()).setTitle("Quản lý nguồn (Nhấn để xóa)").setItems((String[]) arrayList.toArray(new String[0]), new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                new AlertDialog.Builder(r0.requireActivity()).setTitle("Xác nhận xóa").setMessage("Bạn có chắc chắn muốn xóa nguồn: " + ((MovieList.TvSource) sources.get(i)).getName() + "?").setPositiveButton("Xóa", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda29
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface2, int i2) {
                        MobileMainFragment.showSourceManager$lambda$17$lambda$16(MobileMainFragment.this, i, dialogInterface2, i2);
                    }
                }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showSourceManager$lambda$17$lambda$16(MobileMainFragment mobileMainFragment, int i, DialogInterface dialogInterface, int i2) {
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.deleteSource(requireActivity, i);
        Toast.makeText(mobileMainFragment.requireActivity(), "Đã xóa nguồn", 0).show();
        mobileMainFragment.loadData();
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
        new AlertDialog.Builder(requireActivity()).setTitle("Chọn nhóm kênh muốn HIỂN THỊ").setMultiChoiceItems(strArr, CollectionsKt.toBooleanArray(arrayList), new DialogInterface.OnMultiChoiceClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda22
            @Override // android.content.DialogInterface.OnMultiChoiceClickListener
            public final void onClick(DialogInterface dialogInterface, int i, boolean z) {
                MobileMainFragment.showCategoryVisibilityManager$lambda$19(MobileMainFragment.this, strArr, dialogInterface, i, z);
            }
        }).setPositiveButton("Xong", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda31
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.showCategoryVisibilityManager$lambda$20(MobileMainFragment.this, dialogInterface, i);
            }
        }).setNeutralButton("Hiện tất cả", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda32
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.showCategoryVisibilityManager$lambda$22(strArr, this, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showCategoryVisibilityManager$lambda$19(MobileMainFragment mobileMainFragment, String[] strArr, DialogInterface dialogInterface, int i, boolean z) {
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.toggleCategoryVisibility(requireActivity, strArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showCategoryVisibilityManager$lambda$20(MobileMainFragment mobileMainFragment, DialogInterface dialogInterface, int i) {
        mobileMainFragment.forceReloadUI();
        Toast.makeText(mobileMainFragment.requireActivity(), "Đã cập nhật danh sách nhóm", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMobileSettings() {
        final List listOf = CollectionsKt.listOf((Object[]) new SettingItem[]{new SettingItem(R.drawable.ic_add_box, "Thêm nguồn mới"), new SettingItem(R.drawable.ic_settings_gear, "Quản lý nguồn"), new SettingItem(R.drawable.ic_sync, "Cập nhật dữ liệu nguồn"), new SettingItem(R.drawable.ic_menu_channels, "Ẩn/Hiện nhóm kênh"), new SettingItem(R.drawable.ic_settings_gear, "Số cột hiển thị"), new SettingItem(R.drawable.ic_tv, "Giao diện TV"), new SettingItem(R.drawable.ic_update, "Kiểm tra cập nhật"), new SettingItem(R.drawable.ic_sync, "Đặt lại mặc định"), new SettingItem(R.drawable.ic_info, "Phiên bản: 2.6")});
        final FragmentActivity requireActivity = requireActivity();
        new AlertDialog.Builder(requireActivity()).setTitle("Cài đặt").setAdapter(new ArrayAdapter<SettingItem>(listOf, requireActivity) { // from class: com.tvstore.ok.MobileMainFragment$showMobileSettings$adapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                FragmentActivity fragmentActivity = requireActivity;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                View view = super.getView(position, convertView, parent);
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
                TextView textView = (TextView) view;
                MobileMainFragment.SettingItem item = getItem(position);
                Intrinsics.checkNotNull(item);
                MobileMainFragment.SettingItem settingItem = item;
                textView.setText(settingItem.getText());
                float f = getContext().getResources().getDisplayMetrics().density;
                int i = (int) (24.0f * f);
                Drawable drawable = ContextCompat.getDrawable(getContext(), settingItem.getIconRes());
                if (drawable != null) {
                    drawable.setBounds(0, 0, i, i);
                    drawable.setTint(textView.getCurrentTextColor());
                } else {
                    drawable = null;
                }
                textView.setCompoundDrawables(drawable, null, null, null);
                textView.setCompoundDrawablePadding((int) (12.0f * f));
                return textView;
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.showMobileSettings$lambda$23(MobileMainFragment.this, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showMobileSettings$lambda$23(MobileMainFragment mobileMainFragment, DialogInterface dialogInterface, int i) {
        switch (i) {
            case 0:
                mobileMainFragment.showAddSourceDialog();
                return;
            case 1:
                mobileMainFragment.showSourceManager();
                return;
            case 2:
                AppHelper.refreshSourceData(mobileMainFragment);
                return;
            case 3:
                mobileMainFragment.showCategoryVisibilityManager();
                return;
            case 4:
                mobileMainFragment.showColumnSettings();
                return;
            case 5:
                mobileMainFragment.confirmUiSwitch("tv");
                return;
            case 6:
                UpdateManager updateManager = UpdateManager.INSTANCE;
                FragmentActivity requireActivity = mobileMainFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                updateManager.checkUpdate(requireActivity, "hieu-TQS/ok", true);
                return;
            case 7:
                mobileMainFragment.confirmUiSwitch("auto");
                return;
            default:
                return;
        }
    }

    private final void refreshSourceData() {
        AppHelper.refreshSourceData(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit refreshSourceData$lambda$25(final MobileMainFragment mobileMainFragment, final List movies) {
        Intrinsics.checkNotNullParameter(movies, "movies");
        mobileMainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                MobileMainFragment.refreshSourceData$lambda$25$lambda$24(MobileMainFragment.this, movies);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void refreshSourceData$lambda$25$lambda$24(MobileMainFragment mobileMainFragment, List list) {
        if (mobileMainFragment.isAdded()) {
            if (!list.isEmpty()) {
                mobileMainFragment.forceReloadUI();
                Toast.makeText(mobileMainFragment.requireActivity(), "✅ Đã cập nhật " + list.size() + " kênh", 0).show();
                return;
            }
            Toast.makeText(mobileMainFragment.requireActivity(), "❌ Không thể cập nhật!", 0).show();
        }
    }

    private final void showColumnSettings() {
        final SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("okPrefs", 0);
        boolean z = getResources().getConfiguration().orientation == 2;
        final String str = z ? "mobile_columns_landscape" : "mobile_columns_portrait";
        final String str2 = z ? " (Ngang)" : " (Dọc)";
        new AlertDialog.Builder(requireActivity()).setTitle("Số cột hiển thị".concat(str2)).setSingleChoiceItems(new String[]{"2 cột", "3 cột", "4 cột", "5 cột", "6 cột"}, RangesKt.coerceIn(sharedPreferences.getInt(str, z ? 3 : 2) - 2, 0, 4), new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda27
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.showColumnSettings$lambda$26(sharedPreferences, str, this, str2, dialogInterface, i);
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showColumnSettings$lambda$26(SharedPreferences sharedPreferences, String str, MobileMainFragment mobileMainFragment, String str2, DialogInterface dialogInterface, int i) {
        int i2 = i + 2;
        sharedPreferences.edit().putInt(str, i2).apply();
        RecyclerView recyclerView = mobileMainFragment.channelRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(mobileMainFragment.getContext(), i2));
        }
        dialogInterface.dismiss();
        Toast.makeText(mobileMainFragment.requireActivity(), "Đã cập nhật số cột cho màn hình" + str2, 0).show();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("okPrefs", 0);
        boolean z = newConfig.orientation == 2;
        int i = sharedPreferences.getInt(z ? "mobile_columns_landscape" : "mobile_columns_portrait", z ? 3 : 2);
        RecyclerView recyclerView = this.channelRecycler;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), i));
        }
    }

    private final void confirmUiSwitch(final String mode) {
        new AlertDialog.Builder(requireActivity()).setTitle("Xác nhận").setMessage("Giao diện sẽ thay đổi ngay.").setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda26
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.confirmUiSwitch$lambda$27(MobileMainFragment.this, mode, dialogInterface, i);
            }
        }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void confirmUiSwitch$lambda$27(MobileMainFragment mobileMainFragment, String str, DialogInterface dialogInterface, int i) {
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.setUiMode(requireActivity, str);
        mobileMainFragment.requireActivity().recreate();
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
        licenseManager.checkLicense(requireActivity, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MobileMainFragment.showAddSourceDialog$lambda$29(MobileMainFragment.this, progressDialog, (LicenseManager.LicenseStatus) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showAddSourceDialog$lambda$29(MobileMainFragment mobileMainFragment, ProgressDialog progressDialog, LicenseManager.LicenseStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (!mobileMainFragment.isAdded()) {
            return Unit.INSTANCE;
        }
        progressDialog.dismiss();
        int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
        if (i == 1) {
            mobileMainFragment.showActualAddSourceDialog();
        } else if (i == 2) {
            mobileMainFragment.showPendingDialog();
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            mobileMainFragment.showFakeErrorDialog();
        }
        return Unit.INSTANCE;
    }

    private final void showFakeErrorDialog() {
        new AlertDialog.Builder(requireActivity()).setTitle("Đã xảy ra lỗi").setMessage("Đã xảy ra lỗi không mong muốn, tính năng hiện không khả dụng.\n\nVui lòng liên hệ nhà phát triển để được hỗ trợ.").setCancelable(true).setPositiveButton("Liên hệ", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda18
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.this.showFeedbackDialog();
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFeedbackDialog() {
        final FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        FragmentActivity fragmentActivity = requireActivity;
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
        new AlertDialog.Builder(fragmentActivity).setTitle("Gửi phản hồi").setView(linearLayout).setPositiveButton("Gửi", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda28
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.showFeedbackDialog$lambda$37(editText, requireActivity, this, dialogInterface, i);
            }
        }).setNegativeButton("Huỷ", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showFeedbackDialog$lambda$37(EditText editText, final FragmentActivity fragmentActivity, final MobileMainFragment mobileMainFragment, DialogInterface dialogInterface, int i) {
        String obj = StringsKt.trim((CharSequence) editText.getText().toString()).toString();
        if (obj.length() == 0) {
            Toast.makeText(fragmentActivity, "Vui lòng nhập nội dung!", 0).show();
            mobileMainFragment.showFeedbackDialog();
            return;
        }
        FragmentActivity fragmentActivity2 = fragmentActivity;
        final ProgressDialog progressDialog = new ProgressDialog(fragmentActivity2);
        progressDialog.setMessage("Đang gửi...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        LicenseManager.INSTANCE.registerDevice(fragmentActivity2, obj, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return MobileMainFragment.showFeedbackDialog$lambda$37$lambda$36(MobileMainFragment.this, progressDialog, fragmentActivity, ((Boolean) obj2).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showFeedbackDialog$lambda$37$lambda$36(final MobileMainFragment mobileMainFragment, ProgressDialog progressDialog, FragmentActivity fragmentActivity, boolean z) {
        if (!mobileMainFragment.isAdded()) {
            return Unit.INSTANCE;
        }
        progressDialog.dismiss();
        if (z) {
            new AlertDialog.Builder(fragmentActivity).setTitle("Đã gửi").setMessage("Cảm ơn bạn đã phản hồi! Nhà phát triển sẽ kiểm tra và liên hệ lại sớm nhất có thể.").setPositiveButton("OK", (DialogInterface.OnClickListener) null).show();
        } else {
            new AlertDialog.Builder(fragmentActivity).setTitle("Gửi thất bại").setMessage("Không thể gửi phản hồi lúc này.\n\nVui lòng kiểm tra kết nối mạng và thử lại sau.").setPositiveButton("Thử lại", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda2
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MobileMainFragment.this.showFeedbackDialog();
                }
            }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
        }
        return Unit.INSTANCE;
    }

    private final void showPendingDialog() {
        new AlertDialog.Builder(requireActivity()).setTitle("Đã gửi").setMessage("Cảm ơn bạn đã phản hồi! Chúng tôi đã ghi nhận và đang kiểm tra sự cố.\n\nVui lòng thử lại sau ít phút.").setPositiveButton("Thử lại", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda36
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MobileMainFragment.this.showAddSourceDialog();
            }
        }).setNegativeButton("Đóng", (DialogInterface.OnClickListener) null).show();
    }

    private final void showActualAddSourceDialog() {
        LinearLayout linearLayout = new LinearLayout(requireActivity());
        linearLayout.setOrientation(1);
        linearLayout.setPadding(50, 20, 50, 20);
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
        button.setText("Chọn file .m3u từ máy");
        float f = button.getResources().getDisplayMetrics().density;
        int i = (int) (24.0f * f);
        Drawable drawable = ContextCompat.getDrawable(button.getContext(), R.drawable.ic_storage);
        if (drawable != null) {
            drawable.setBounds(0, 0, i, i);
            drawable.setTint(-1);
        } else {
            drawable = null;
        }
        button.setCompoundDrawables(drawable, null, null, null);
        button.setCompoundDrawablePadding((int) (8.0f * f));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileMainFragment.showActualAddSourceDialog$lambda$45$lambda$44(MobileMainFragment.this, view);
            }
        });
        linearLayout.addView(button);
        new AlertDialog.Builder(requireActivity()).setTitle("Thêm nguồn").setView(linearLayout).setPositiveButton("Lưu và Mở", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MobileMainFragment.showActualAddSourceDialog$lambda$51(editText, editText2, this, dialogInterface, i2);
            }
        }).setNeutralButton("Chỉ Lưu", new DialogInterface.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MobileMainFragment.showActualAddSourceDialog$lambda$55(editText, editText2, this, dialogInterface, i2);
            }
        }).setNegativeButton("Hủy", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$45$lambda$44(MobileMainFragment mobileMainFragment, View view) {
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        MainActivity mainActivity = requireActivity instanceof MainActivity ? (MainActivity) requireActivity : null;
        if (mainActivity != null) {
            mainActivity.openFilePicker();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$51(EditText editText, EditText editText2, final MobileMainFragment mobileMainFragment, DialogInterface dialogInterface, int i) {
        String obj = editText.getText().toString();
        String obj2 = editText2.getText().toString();
        if (obj.length() <= 0 || obj2.length() <= 0) {
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(mobileMainFragment.requireActivity());
        progressDialog.setMessage("Đang kiểm tra...");
        progressDialog.show();
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.addSource(requireActivity, obj, obj2, true, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return MobileMainFragment.showActualAddSourceDialog$lambda$51$lambda$50(MobileMainFragment.this, progressDialog, ((Boolean) obj3).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showActualAddSourceDialog$lambda$51$lambda$50(final MobileMainFragment mobileMainFragment, final ProgressDialog progressDialog, final boolean z) {
        mobileMainFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                MobileMainFragment.showActualAddSourceDialog$lambda$51$lambda$50$lambda$49(progressDialog, z, mobileMainFragment);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$51$lambda$50$lambda$49(ProgressDialog progressDialog, boolean z, final MobileMainFragment mobileMainFragment) {
        progressDialog.dismiss();
        if (z) {
            MovieList.INSTANCE.getMovies(new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda35
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MobileMainFragment.showActualAddSourceDialog$lambda$51$lambda$50$lambda$49$lambda$48(MobileMainFragment.this, (List) obj);
                }
            });
        } else {
            Toast.makeText(mobileMainFragment.requireActivity(), "URL không hợp lệ!", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showActualAddSourceDialog$lambda$51$lambda$50$lambda$49$lambda$48(final MobileMainFragment mobileMainFragment, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mobileMainFragment.mHandler.post(new Runnable() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                MobileMainFragment.showActualAddSourceDialog$lambda$51$lambda$50$lambda$49$lambda$48$lambda$47(MobileMainFragment.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$51$lambda$50$lambda$49$lambda$48$lambda$47(MobileMainFragment mobileMainFragment) {
        if (mobileMainFragment.isAdded()) {
            mobileMainFragment.forceReloadUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$55(EditText editText, EditText editText2, final MobileMainFragment mobileMainFragment, DialogInterface dialogInterface, int i) {
        String obj = editText.getText().toString();
        String obj2 = editText2.getText().toString();
        if (obj.length() <= 0 || obj2.length() <= 0) {
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(mobileMainFragment.requireActivity());
        progressDialog.setMessage("Đang kiểm tra...");
        progressDialog.show();
        MovieList movieList = MovieList.INSTANCE;
        FragmentActivity requireActivity = mobileMainFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        movieList.addSource(requireActivity, obj, obj2, false, new Function1() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj3) {
                return MobileMainFragment.showActualAddSourceDialog$lambda$55$lambda$54(MobileMainFragment.this, progressDialog, ((Boolean) obj3).booleanValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit showActualAddSourceDialog$lambda$55$lambda$54(final MobileMainFragment mobileMainFragment, final ProgressDialog progressDialog, final boolean z) {
        mobileMainFragment.requireActivity().runOnUiThread(new Runnable() { // from class: com.tvstore.ok.MobileMainFragment$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                MobileMainFragment.showActualAddSourceDialog$lambda$55$lambda$54$lambda$53(progressDialog, z, mobileMainFragment);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showActualAddSourceDialog$lambda$55$lambda$54$lambda$53(ProgressDialog progressDialog, boolean z, MobileMainFragment mobileMainFragment) {
        progressDialog.dismiss();
        if (z) {
            Toast.makeText(mobileMainFragment.requireActivity(), "Đã lưu nguồn!", 0).show();
        } else {
            Toast.makeText(mobileMainFragment.requireActivity(), "URL không hợp lệ!", 0).show();
        }
    }

    /* compiled from: MobileMainFragment.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0015B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ \u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\t2\u000e\u0010\u0012\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tvstore/ok/MobileMainFragment$CategoryTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tvstore/ok/MobileMainFragment$CategoryTabAdapter$ViewHolder;", "Lcom/tvstore/ok/MobileMainFragment;", "categories", "", "", "onCategoryClick", "Lkotlin/Function1;", "", "<init>", "(Lcom/tvstore/ok/MobileMainFragment;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public final class CategoryTabAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<String> categories;
        private final Function1<String, Unit> onCategoryClick;
        final /* synthetic */ MobileMainFragment this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public CategoryTabAdapter(MobileMainFragment mobileMainFragment, List<String> categories, Function1<? super String, Unit> onCategoryClick) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(onCategoryClick, "onCategoryClick");
            this.this$0 = mobileMainFragment;
            this.categories = categories;
            this.onCategoryClick = onCategoryClick;
        }

        /* compiled from: MobileMainFragment.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/tvstore/ok/MobileMainFragment$CategoryTabAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/tvstore/ok/MobileMainFragment$CategoryTabAdapter;Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes3.dex */
        public final class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView name;
            final /* synthetic */ CategoryTabAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(CategoryTabAdapter categoryTabAdapter, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0 = categoryTabAdapter;
                View findViewById = view.findViewById(R.id.tab_name);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.name = (TextView) findViewById;
            }

            public final TextView getName() {
                return this.name;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile_category_tab, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new ViewHolder(this, inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final String str = this.categories.get(position);
            holder.getName().setText(str);
            if (Intrinsics.areEqual(str, this.this$0.selectedCategory)) {
                holder.getName().setBackgroundColor(Color.parseColor("#CC0000"));
            } else {
                holder.getName().setBackgroundColor(Color.parseColor("#333333"));
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$CategoryTabAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileMainFragment.CategoryTabAdapter.onBindViewHolder$lambda$0(MobileMainFragment.CategoryTabAdapter.this, str, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$0(CategoryTabAdapter categoryTabAdapter, String str, View view) {
            categoryTabAdapter.onCategoryClick.invoke(str);
            categoryTabAdapter.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.categories.size();
        }
    }

    /* compiled from: MobileMainFragment.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0017B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\t2\u000e\u0010\u0014\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/tvstore/ok/MobileMainFragment$MobileMovieAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tvstore/ok/MobileMainFragment$MobileMovieAdapter$ViewHolder;", "Lcom/tvstore/ok/MobileMainFragment;", "movies", "", "Lcom/tvstore/ok/Movie;", "onClick", "Lkotlin/Function1;", "", "onLongClick", "<init>", "(Lcom/tvstore/ok/MobileMainFragment;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "selectedPosition", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "ViewHolder", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public final class MobileMovieAdapter extends RecyclerView.Adapter<ViewHolder> {
        private final List<Movie> movies;
        private final Function1<Movie, Unit> onClick;
        private final Function1<Movie, Unit> onLongClick;
        private int selectedPosition;
        final /* synthetic */ MobileMainFragment this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public MobileMovieAdapter(MobileMainFragment mobileMainFragment, List<Movie> movies, Function1<? super Movie, Unit> onClick, Function1<? super Movie, Unit> onLongClick) {
            Intrinsics.checkNotNullParameter(movies, "movies");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
            this.this$0 = mobileMainFragment;
            this.movies = movies;
            this.onClick = onClick;
            this.onLongClick = onLongClick;
            this.selectedPosition = -1;
        }

        /* compiled from: MobileMainFragment.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/tvstore/ok/MobileMainFragment$MobileMovieAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/tvstore/ok/MobileMainFragment$MobileMovieAdapter;Landroid/view/View;)V", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", TvContractCompat.ProgramColumns.COLUMN_TITLE, "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes3.dex */
        public final class ViewHolder extends RecyclerView.ViewHolder {
            private final CardView card;
            private final ImageView image;
            final /* synthetic */ MobileMovieAdapter this$0;
            private final TextView title;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(MobileMovieAdapter mobileMovieAdapter, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0 = mobileMovieAdapter;
                View findViewById = view.findViewById(R.id.card_view);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.card = (CardView) findViewById;
                View findViewById2 = view.findViewById(R.id.movie_image);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.image = (ImageView) findViewById2;
                View findViewById3 = view.findViewById(R.id.movie_title);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.title = (TextView) findViewById3;
            }

            public final CardView getCard() {
                return this.card;
            }

            public final ImageView getImage() {
                return this.image;
            }

            public final TextView getTitle() {
                return this.title;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile_movie, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new ViewHolder(this, inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder holder, final int position) {
            DiskCacheStrategy diskCacheStrategy;
            Intrinsics.checkNotNullParameter(holder, "holder");
            final Movie movie = this.movies.get(position);
            boolean isFavorite = MovieList.INSTANCE.isFavorite(movie);
            TextView title = holder.getTitle();
            String str = isFavorite ? "❤️ " : "";
            title.setText(str + movie.getTitle());
            holder.getTitle().setSelected(this.selectedPosition == position);
            if (this.selectedPosition == position) {
                holder.getCard().setCardBackgroundColor(Color.parseColor("#FF9800"));
            } else {
                holder.getCard().setCardBackgroundColor(Color.parseColor("#1A1A1A"));
            }
            String cardImageUrl = movie.getCardImageUrl();
            String str2 = cardImageUrl;
            if (str2 != null && str2.length() != 0) {
                boolean startsWith$default = StringsKt.startsWith$default(cardImageUrl, "content://", false, 2, (Object) null);
                RequestManager with = Glide.with(holder.itemView.getContext());
                Object obj = cardImageUrl;
                if (startsWith$default) {
                    obj = Uri.parse(cardImageUrl);
                }
                RequestBuilder<Drawable> load = with.load(obj);
                if (startsWith$default) {
                    diskCacheStrategy = DiskCacheStrategy.RESOURCE;
                } else {
                    diskCacheStrategy = DiskCacheStrategy.ALL;
                }
                Intrinsics.checkNotNull(load.diskCacheStrategy(diskCacheStrategy).timeout(10000).dontAnimate().fitCenter().placeholder(R.drawable.app_icon_your_company).error(R.drawable.app_icon_your_company).into(holder.getImage()));
            } else {
                holder.getImage().setImageResource(R.drawable.app_icon_your_company);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.MobileMainFragment$MobileMovieAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MobileMainFragment.MobileMovieAdapter.onBindViewHolder$lambda$0(Movie.this, this, position, view);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tvstore.ok.MobileMainFragment$MobileMovieAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return MobileMainFragment.MobileMovieAdapter.onBindViewHolder$lambda$1(Movie.this, this, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$0(Movie movie, MobileMovieAdapter mobileMovieAdapter, int i, View view) {
            if (movie.getId() < 0) {
                return;
            }
            int i2 = mobileMovieAdapter.selectedPosition;
            if (i2 == i) {
                mobileMovieAdapter.onClick.invoke(movie);
                return;
            }
            mobileMovieAdapter.selectedPosition = i;
            if (i2 != -1) {
                mobileMovieAdapter.notifyItemChanged(i2);
            }
            mobileMovieAdapter.notifyItemChanged(mobileMovieAdapter.selectedPosition);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final boolean onBindViewHolder$lambda$1(Movie movie, MobileMovieAdapter mobileMovieAdapter, View view) {
            if (movie.getId() < 0) {
                return true;
            }
            mobileMovieAdapter.onLongClick.invoke(movie);
            return true;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.movies.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MobileMainFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0005H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/tvstore/ok/MobileMainFragment$SettingItem;", "", "iconRes", "", "text", "", "<init>", "(ILjava/lang/String;)V", "getIconRes", "()I", "getText", "()Ljava/lang/String;", "toString", "component1", "component2", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
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

        public String toString() {
            return this.text;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showCategoryVisibilityManager$lambda$22(String[] strArr, MobileMainFragment mobileMainFragment, DialogInterface dialogInterface, int i) {
        for (String str : strArr) {
            if (MovieList.INSTANCE.isCategoryHidden(str)) {
                MovieList movieList = MovieList.INSTANCE;
                FragmentActivity requireActivity = mobileMainFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
                movieList.toggleCategoryVisibility(requireActivity, str);
            }
        }
        mobileMainFragment.forceReloadUI();
    }
}
