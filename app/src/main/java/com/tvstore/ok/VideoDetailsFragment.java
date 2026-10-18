package com.tvstore.ok;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.app.DetailsSupportFragmentBackgroundController;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: VideoDetailsFragment.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/tvstore/ok/VideoDetailsFragment;", "Landroidx/leanback/app/DetailsSupportFragment;", "<init>", "()V", "mDetailsBackground", "Landroidx/leanback/app/DetailsSupportFragmentBackgroundController;", "mPresenterSelector", "Landroidx/leanback/widget/ClassPresenterSelector;", "mAdapter", "Landroidx/leanback/widget/ArrayObjectAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initializeBackground", "movie", "Lcom/tvstore/ok/Movie;", "setupDetailsOverviewRow", "setupDetailsOverviewRowPresenter", "setupRelatedMovieListRow", "convertDpToPixel", "", "context", "Landroid/content/Context;", "dp", "ItemViewClickedListener", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class VideoDetailsFragment extends DetailsSupportFragment {
    private static final long ACTION_BUY = 3;
    private static final long ACTION_RENT = 2;
    private static final long ACTION_WATCH_TRAILER = 1;
    private static final int DETAIL_THUMB_HEIGHT = 274;
    private static final int DETAIL_THUMB_WIDTH = 274;
    private static final int NUM_COLS = 10;
    private static final String TAG = "VideoDetailsFragment";
    private ArrayObjectAdapter mAdapter;
    private DetailsSupportFragmentBackgroundController mDetailsBackground;
    private ClassPresenterSelector mPresenterSelector;

    @Override // androidx.leanback.app.DetailsSupportFragment, androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate DetailsFragment");
        super.onCreate(savedInstanceState);
        this.mDetailsBackground = new DetailsSupportFragmentBackgroundController(this);
        Movie movie = (Movie) requireActivity().getIntent().getSerializableExtra(DetailsActivity.MOVIE);
        if (movie != null) {
            this.mPresenterSelector = new ClassPresenterSelector();
            ClassPresenterSelector classPresenterSelector = this.mPresenterSelector;
            ArrayObjectAdapter arrayObjectAdapter = null;
            if (classPresenterSelector == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPresenterSelector");
                classPresenterSelector = null;
            }
            this.mAdapter = new ArrayObjectAdapter(classPresenterSelector);
            setupDetailsOverviewRow(movie);
            setupDetailsOverviewRowPresenter(movie);
            setupRelatedMovieListRow();
            ArrayObjectAdapter arrayObjectAdapter2 = this.mAdapter;
            if (arrayObjectAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                arrayObjectAdapter = arrayObjectAdapter2;
            }
            setAdapter(arrayObjectAdapter);
            initializeBackground(movie);
            setOnItemViewClickedListener(new ItemViewClickedListener(this, movie));
            return;
        }
        startActivity(new Intent(requireActivity(), (Class<?>) MainActivity.class));
    }

    private final void initializeBackground(Movie movie) {
        DetailsSupportFragmentBackgroundController detailsSupportFragmentBackgroundController = this.mDetailsBackground;
        if (detailsSupportFragmentBackgroundController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDetailsBackground");
            detailsSupportFragmentBackgroundController = null;
        }
        detailsSupportFragmentBackgroundController.enableParallax();
        Glide.with(requireActivity()).asBitmap().load(movie.getBackgroundImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).timeout(5000).dontAnimate().centerCrop().error(R.drawable.default_background).into((RequestBuilder) new CustomTarget<Bitmap>() { // from class: com.tvstore.ok.VideoDetailsFragment$initializeBackground$1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                DetailsSupportFragmentBackgroundController detailsSupportFragmentBackgroundController2;
                ArrayObjectAdapter arrayObjectAdapter;
                ArrayObjectAdapter arrayObjectAdapter2;
                Intrinsics.checkNotNullParameter(resource, "resource");
                detailsSupportFragmentBackgroundController2 = VideoDetailsFragment.this.mDetailsBackground;
                ArrayObjectAdapter arrayObjectAdapter3 = null;
                if (detailsSupportFragmentBackgroundController2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDetailsBackground");
                    detailsSupportFragmentBackgroundController2 = null;
                }
                detailsSupportFragmentBackgroundController2.setCoverBitmap(resource);
                arrayObjectAdapter = VideoDetailsFragment.this.mAdapter;
                if (arrayObjectAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    arrayObjectAdapter = null;
                }
                arrayObjectAdapter2 = VideoDetailsFragment.this.mAdapter;
                if (arrayObjectAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                } else {
                    arrayObjectAdapter3 = arrayObjectAdapter2;
                }
                arrayObjectAdapter.notifyItemRangeChanged(0, arrayObjectAdapter3.size());
            }
        });
    }

    private final void setupDetailsOverviewRow(Movie movie) {
        Log.d(TAG, "doInBackground: " + movie);
        final DetailsOverviewRow detailsOverviewRow = new DetailsOverviewRow(movie);
        detailsOverviewRow.setImageDrawable(ContextCompat.getDrawable(requireActivity(), R.drawable.default_background));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        final int convertDpToPixel = convertDpToPixel(requireActivity, 274);
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        final int convertDpToPixel2 = convertDpToPixel(requireActivity2, 274);
        Glide.with(requireActivity()).load(movie.getCardImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).timeout(5000).dontAnimate().fitCenter().error(R.drawable.default_background).into((RequestBuilder) new CustomTarget<Drawable>(convertDpToPixel, convertDpToPixel2) { // from class: com.tvstore.ok.VideoDetailsFragment$setupDetailsOverviewRow$1
            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Drawable) obj, (Transition<? super Drawable>) transition);
            }

            public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                ArrayObjectAdapter arrayObjectAdapter;
                ArrayObjectAdapter arrayObjectAdapter2;
                Intrinsics.checkNotNullParameter(resource, "resource");
                Log.d("VideoDetailsFragment", "details overview card image url ready: " + resource);
                detailsOverviewRow.setImageDrawable(resource);
                arrayObjectAdapter = this.mAdapter;
                ArrayObjectAdapter arrayObjectAdapter3 = null;
                if (arrayObjectAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    arrayObjectAdapter = null;
                }
                arrayObjectAdapter2 = this.mAdapter;
                if (arrayObjectAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                } else {
                    arrayObjectAdapter3 = arrayObjectAdapter2;
                }
                arrayObjectAdapter.notifyItemRangeChanged(0, arrayObjectAdapter3.size());
            }
        });
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter();
        arrayObjectAdapter.add(new Action(1L, getResources().getString(R.string.watch_trailer_1), getResources().getString(R.string.watch_trailer_2)));
        arrayObjectAdapter.add(new Action(2L, getResources().getString(R.string.rent_1), getResources().getString(R.string.rent_2)));
        arrayObjectAdapter.add(new Action(3L, getResources().getString(R.string.buy_1), getResources().getString(R.string.buy_2)));
        detailsOverviewRow.setActionsAdapter(arrayObjectAdapter);
        ArrayObjectAdapter arrayObjectAdapter2 = this.mAdapter;
        if (arrayObjectAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            arrayObjectAdapter2 = null;
        }
        arrayObjectAdapter2.add(detailsOverviewRow);
    }

    private final void setupDetailsOverviewRowPresenter(final Movie movie) {
        FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter = new FullWidthDetailsOverviewRowPresenter(new DetailsDescriptionPresenter());
        fullWidthDetailsOverviewRowPresenter.setBackgroundColor(ContextCompat.getColor(requireActivity(), R.color.selected_background));
        FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
        fullWidthDetailsOverviewSharedElementHelper.setSharedElementEnterTransition(requireActivity(), DetailsActivity.SHARED_ELEMENT_NAME);
        fullWidthDetailsOverviewRowPresenter.setListener(fullWidthDetailsOverviewSharedElementHelper);
        fullWidthDetailsOverviewRowPresenter.setParticipatingEntranceTransition(true);
        fullWidthDetailsOverviewRowPresenter.setOnActionClickedListener(new OnActionClickedListener() { // from class: com.tvstore.ok.VideoDetailsFragment$$ExternalSyntheticLambda0
            @Override // androidx.leanback.widget.OnActionClickedListener
            public final void onActionClicked(Action action) {
                VideoDetailsFragment.setupDetailsOverviewRowPresenter$lambda$0(VideoDetailsFragment.this, movie, action);
            }
        });
        ClassPresenterSelector classPresenterSelector = this.mPresenterSelector;
        if (classPresenterSelector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenterSelector");
            classPresenterSelector = null;
        }
        classPresenterSelector.addClassPresenter(DetailsOverviewRow.class, fullWidthDetailsOverviewRowPresenter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupDetailsOverviewRowPresenter$lambda$0(VideoDetailsFragment videoDetailsFragment, Movie movie, Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action.getId() == 1) {
            Intent intent = new Intent(videoDetailsFragment.requireActivity(), (Class<?>) PlaybackActivity.class);
            intent.putExtra(DetailsActivity.MOVIE, movie);
            videoDetailsFragment.startActivity(intent);
            return;
        }
        Toast.makeText(videoDetailsFragment.requireActivity(), action.toString(), 0).show();
    }

    private final void setupRelatedMovieListRow() {
        List<Movie> list = MovieList.INSTANCE.getList();
        if (list.isEmpty()) {
            return;
        }
        String[] strArr = {getString(R.string.related_movies)};
        List shuffled = CollectionsKt.shuffled(list);
        ClassPresenterSelector classPresenterSelector = null;
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new CardPresenter(null, 1, null));
        for (int i = 0; i < 10; i++) {
            arrayObjectAdapter.add(shuffled.get(i % shuffled.size()));
        }
        HeaderItem headerItem = new HeaderItem(0L, strArr[0]);
        ArrayObjectAdapter arrayObjectAdapter2 = this.mAdapter;
        if (arrayObjectAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            arrayObjectAdapter2 = null;
        }
        arrayObjectAdapter2.add(new ListRow(headerItem, arrayObjectAdapter));
        ClassPresenterSelector classPresenterSelector2 = this.mPresenterSelector;
        if (classPresenterSelector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPresenterSelector");
        } else {
            classPresenterSelector = classPresenterSelector2;
        }
        classPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
    }

    private final int convertDpToPixel(Context context, int dp) {
        return MathKt.roundToInt(dp * context.getApplicationContext().getResources().getDisplayMetrics().density);
    }

    /* compiled from: VideoDetailsFragment.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tvstore/ok/VideoDetailsFragment$ItemViewClickedListener;", "Landroidx/leanback/widget/OnItemViewClickedListener;", "movie", "Lcom/tvstore/ok/Movie;", "<init>", "(Lcom/tvstore/ok/VideoDetailsFragment;Lcom/tvstore/ok/Movie;)V", "onItemClicked", "", "itemViewHolder", "Landroidx/leanback/widget/Presenter$ViewHolder;", "item", "", "rowViewHolder", "Landroidx/leanback/widget/RowPresenter$ViewHolder;", "row", "Landroidx/leanback/widget/Row;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    private final class ItemViewClickedListener implements OnItemViewClickedListener {
        private final Movie movie;
        final /* synthetic */ VideoDetailsFragment this$0;

        public ItemViewClickedListener(VideoDetailsFragment videoDetailsFragment, Movie movie) {
            Intrinsics.checkNotNullParameter(movie, "movie");
            this.this$0 = videoDetailsFragment;
            this.movie = movie;
        }

        @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
        public void onItemClicked(Presenter.ViewHolder itemViewHolder, Object item, RowPresenter.ViewHolder rowViewHolder, Row row) {
            Intrinsics.checkNotNullParameter(itemViewHolder, "itemViewHolder");
            Intrinsics.checkNotNullParameter(rowViewHolder, "rowViewHolder");
            Intrinsics.checkNotNullParameter(row, "row");
            if (item instanceof Movie) {
                Log.d(VideoDetailsFragment.TAG, "Item: " + item);
                Intent intent = new Intent(this.this$0.requireActivity(), (Class<?>) DetailsActivity.class);
                intent.putExtra(this.this$0.getResources().getString(R.string.movie), this.movie);
                FragmentActivity requireActivity = this.this$0.requireActivity();
                View view = itemViewHolder.view;
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
                ImageView mainImageView = ((ImageCardView) view).getMainImageView();
                Intrinsics.checkNotNull(mainImageView);
                this.this$0.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity, mainImageView, DetailsActivity.SHARED_ELEMENT_NAME).toBundle());
            }
        }
    }
}
