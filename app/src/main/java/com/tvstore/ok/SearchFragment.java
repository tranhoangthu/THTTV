package com.tvstore.ok;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.google.android.gms.actions.SearchIntents;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SearchFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/tvstore/ok/SearchFragment;", "Landroidx/leanback/app/SearchSupportFragment;", "Landroidx/leanback/app/SearchSupportFragment$SearchResultProvider;", "<init>", "()V", "mRowsAdapter", "Landroidx/leanback/widget/ArrayObjectAdapter;", "mHandler", "Landroid/os/Handler;", "mQuery", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getResultsAdapter", "Landroidx/leanback/widget/ObjectAdapter;", "onQueryTextChange", "", "newQuery", "onQueryTextSubmit", SearchIntents.EXTRA_QUERY, "loadQuery", "mDelayedLoad", "Ljava/lang/Runnable;", "onDestroy", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class SearchFragment extends SearchSupportFragment implements SearchSupportFragment.SearchResultProvider {
    private String mQuery;
    private ArrayObjectAdapter mRowsAdapter;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Runnable mDelayedLoad = new Runnable() { // from class: com.tvstore.ok.SearchFragment$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            SearchFragment.mDelayedLoad$lambda$4(SearchFragment.this);
        }
    };

    @Override // androidx.leanback.app.SearchSupportFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mRowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setSearchResultProvider(this);
        setOnItemViewClickedListener(new OnItemViewClickedListener() { // from class: com.tvstore.ok.SearchFragment$$ExternalSyntheticLambda1
            @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
            public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
                SearchFragment.onCreate$lambda$0(SearchFragment.this, viewHolder, obj, viewHolder2, row);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$0(SearchFragment searchFragment, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof Movie) {
            Intent intent = new Intent(searchFragment.getActivity(), (Class<?>) PlaybackActivity.class);
            intent.putExtra(DetailsActivity.MOVIE, (Serializable) obj);
            searchFragment.startActivity(intent);
        }
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public ObjectAdapter getResultsAdapter() {
        ArrayObjectAdapter arrayObjectAdapter = this.mRowsAdapter;
        if (arrayObjectAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRowsAdapter");
            arrayObjectAdapter = null;
        }
        return arrayObjectAdapter;
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public boolean onQueryTextChange(String newQuery) {
        Intrinsics.checkNotNullParameter(newQuery, "newQuery");
        Log.i("SearchFragment", "Query text changed: " + newQuery);
        if (TextUtils.isEmpty(newQuery)) {
            ArrayObjectAdapter arrayObjectAdapter = this.mRowsAdapter;
            if (arrayObjectAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRowsAdapter");
                arrayObjectAdapter = null;
            }
            arrayObjectAdapter.clear();
            return true;
        }
        this.mQuery = newQuery;
        this.mHandler.removeCallbacks(this.mDelayedLoad);
        this.mHandler.postDelayed(this.mDelayedLoad, 300L);
        return true;
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public boolean onQueryTextSubmit(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        Log.i("SearchFragment", "Query text submit: " + query);
        if (TextUtils.isEmpty(query)) {
            ArrayObjectAdapter arrayObjectAdapter = this.mRowsAdapter;
            if (arrayObjectAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRowsAdapter");
                arrayObjectAdapter = null;
            }
            arrayObjectAdapter.clear();
            return true;
        }
        this.mQuery = query;
        this.mHandler.removeCallbacks(this.mDelayedLoad);
        loadQuery(query);
        return true;
    }

    private final void loadQuery(String query) {
        ArrayObjectAdapter arrayObjectAdapter;
        String lowerCase = query.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        List<Movie> movies = MovieList.INSTANCE.getMovies();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = movies.iterator();
        while (true) {
            arrayObjectAdapter = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Movie movie = (Movie) next;
            String title = movie.getTitle();
            if (title != null) {
                String lowerCase2 = title.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (lowerCase2 != null && StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                    arrayList.add(next);
                }
            }
            String category = movie.getCategory();
            if (category != null) {
                String lowerCase3 = category.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                if (lowerCase3 != null && StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase, false, 2, (Object) null)) {
                    arrayList.add(next);
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayObjectAdapter arrayObjectAdapter2 = this.mRowsAdapter;
        if (arrayObjectAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRowsAdapter");
            arrayObjectAdapter2 = null;
        }
        arrayObjectAdapter2.clear();
        if (!arrayList2.isEmpty()) {
            ArrayObjectAdapter arrayObjectAdapter3 = new ArrayObjectAdapter(new CardPresenter(null, 1, null));
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                arrayObjectAdapter3.add((Movie) it2.next());
            }
            HeaderItem headerItem = new HeaderItem("Kết quả tìm kiếm cho: " + query);
            ArrayObjectAdapter arrayObjectAdapter4 = this.mRowsAdapter;
            if (arrayObjectAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRowsAdapter");
            } else {
                arrayObjectAdapter = arrayObjectAdapter4;
            }
            arrayObjectAdapter.add(new ListRow(headerItem, arrayObjectAdapter3));
            return;
        }
        ArrayObjectAdapter arrayObjectAdapter5 = new ArrayObjectAdapter(new CardPresenter(null, 1, null));
        HeaderItem headerItem2 = new HeaderItem("Không tìm thấy kết quả cho: " + query);
        ArrayObjectAdapter arrayObjectAdapter6 = this.mRowsAdapter;
        if (arrayObjectAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRowsAdapter");
        } else {
            arrayObjectAdapter = arrayObjectAdapter6;
        }
        arrayObjectAdapter.add(new ListRow(headerItem2, arrayObjectAdapter5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void mDelayedLoad$lambda$4(SearchFragment searchFragment) {
        String str = searchFragment.mQuery;
        if (str != null) {
            searchFragment.loadQuery(str);
        }
    }

    @Override // androidx.leanback.app.SearchSupportFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mDelayedLoad);
    }
}
