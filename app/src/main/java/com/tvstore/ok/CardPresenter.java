package com.tvstore.ok;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* compiled from: CardPresenter.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R+\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010¨\u0006&"}, d2 = {"Lcom/tvstore/ok/CardPresenter;", "Landroidx/leanback/widget/Presenter;", "onLongClick", "Lkotlin/Function1;", "Lcom/tvstore/ok/Movie;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "mDefaultCardImage", "Landroid/graphics/drawable/Drawable;", "<set-?>", "", "sSelectedBackgroundColor", "getSSelectedBackgroundColor", "()I", "setSSelectedBackgroundColor", "(I)V", "sSelectedBackgroundColor$delegate", "Lkotlin/properties/ReadWriteProperty;", "sDefaultBackgroundColor", "getSDefaultBackgroundColor", "setSDefaultBackgroundColor", "sDefaultBackgroundColor$delegate", "onCreateViewHolder", "Landroidx/leanback/widget/Presenter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "onBindViewHolder", "viewHolder", "item", "", "onUnbindViewHolder", "updateCardBackgroundColor", "view", "Landroidx/leanback/widget/ImageCardView;", "selected", "", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class CardPresenter extends Presenter {
    private Drawable mDefaultCardImage;
    private final Function1<Movie, Unit> onLongClick;

    /* renamed from: sDefaultBackgroundColor$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty sDefaultBackgroundColor;

    /* renamed from: sSelectedBackgroundColor$delegate, reason: from kotlin metadata */
    private final ReadWriteProperty sSelectedBackgroundColor;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CardPresenter.class, "sSelectedBackgroundColor", "getSSelectedBackgroundColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(CardPresenter.class, "sDefaultBackgroundColor", "getSDefaultBackgroundColor()I", 0))};
    private static final String TAG = "CardPresenter";
    private static final int CARD_WIDTH = 190;
    private static final int CARD_HEIGHT = 107;

    /* JADX WARN: Multi-variable type inference failed */
    public CardPresenter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardPresenter(Function1<? super Movie, Unit> function1) {
        this.onLongClick = function1;
        this.sSelectedBackgroundColor = Delegates.INSTANCE.notNull();
        this.sDefaultBackgroundColor = Delegates.INSTANCE.notNull();
    }

    public /* synthetic */ CardPresenter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    private final int getSSelectedBackgroundColor() {
        return ((Number) this.sSelectedBackgroundColor.getValue(this, $$delegatedProperties[0])).intValue();
    }

    private final void setSSelectedBackgroundColor(int i) {
        this.sSelectedBackgroundColor.setValue(this, $$delegatedProperties[0], Integer.valueOf(i));
    }

    private final int getSDefaultBackgroundColor() {
        return ((Number) this.sDefaultBackgroundColor.getValue(this, $$delegatedProperties[1])).intValue();
    }

    private final void setSDefaultBackgroundColor(int i) {
        this.sDefaultBackgroundColor.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.tvstore.ok.CardPresenter$onCreateViewHolder$cardView$1] */
    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Log.d(TAG, "onCreateViewHolder");
        setSDefaultBackgroundColor(ContextCompat.getColor(parent.getContext(), R.color.default_background));
        setSSelectedBackgroundColor(ContextCompat.getColor(parent.getContext(), R.color.selected_background));
        this.mDefaultCardImage = ContextCompat.getDrawable(parent.getContext(), R.drawable.movie);
        final Context context = parent.getContext();
        ?? r0 = new ImageCardView(context) { // from class: com.tvstore.ok.CardPresenter$onCreateViewHolder$cardView$1
            @Override // androidx.leanback.widget.BaseCardView, android.view.View
            public void setSelected(boolean selected) {
                CardPresenter.this.updateCardBackgroundColor(this, selected);
                super.setSelected(selected);
            }
        };
        r0.setFocusable(true);
        r0.setFocusableInTouchMode(true);
        updateCardBackgroundColor((ImageCardView) r0, false);
        return new Presenter.ViewHolder((View) r0);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object item) {
        DiskCacheStrategy diskCacheStrategy;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tvstore.ok.Movie");
        final Movie movie = (Movie) item;
        View view = viewHolder.view;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        imageCardView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tvstore.ok.CardPresenter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return CardPresenter.onBindViewHolder$lambda$0(CardPresenter.this, movie, view2);
            }
        });
        Context context = viewHolder.view.getContext();
        float f = context.getResources().getDisplayMetrics().density;
        int i = (int) (CARD_WIDTH * f);
        int i2 = (int) (CARD_HEIGHT * f);
        Log.d(TAG, "onBindViewHolder");
        imageCardView.setTitleText(movie.getTitle());
        imageCardView.setContentText(movie.getStudio());
        imageCardView.setMainImageDimensions(i, i2);
        ImageView mainImageView = imageCardView.getMainImageView();
        if (mainImageView != null) {
            mainImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            mainImageView.setPadding(8, 8, 8, 8);
        }
        String cardImageUrl = movie.getCardImageUrl();
        String str = cardImageUrl;
        if (str != null && str.length() != 0) {
            boolean startsWith$default = StringsKt.startsWith$default(cardImageUrl, "content://", false, 2, (Object) null);
            RequestManager with = Glide.with(context);
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
            RequestBuilder error = load.diskCacheStrategy(diskCacheStrategy).timeout(10000).dontAnimate().override(i, i2).fitCenter().placeholder(R.drawable.app_icon_your_company).error(R.drawable.app_icon_your_company);
            ImageView mainImageView2 = imageCardView.getMainImageView();
            Intrinsics.checkNotNull(mainImageView2);
            error.into(mainImageView2);
            return;
        }
        ImageView mainImageView3 = imageCardView.getMainImageView();
        if (mainImageView3 != null) {
            mainImageView3.setImageResource(R.drawable.app_icon_your_company);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean onBindViewHolder$lambda$0(CardPresenter cardPresenter, Movie movie, View view) {
        Function1<Movie, Unit> function1 = cardPresenter.onLongClick;
        if (function1 == null) {
            return true;
        }
        function1.invoke(movie);
        return true;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Log.d(TAG, "onUnbindViewHolder");
        View view = viewHolder.view;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.leanback.widget.ImageCardView");
        ImageCardView imageCardView = (ImageCardView) view;
        imageCardView.setBadgeImage(null);
        imageCardView.setMainImage(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCardBackgroundColor(ImageCardView view, boolean selected) {
        int sSelectedBackgroundColor = selected ? getSSelectedBackgroundColor() : getSDefaultBackgroundColor();
        view.setBackgroundColor(sSelectedBackgroundColor);
        view.setInfoAreaBackgroundColor(sSelectedBackgroundColor);
    }
}
