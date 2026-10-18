package com.tvstore.ok;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.leanback.widget.SearchOrbView;
import androidx.leanback.widget.TitleViewAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomTitleView.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0012\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/tvstore/ok/CustomTitleView;", "Landroid/widget/RelativeLayout;", "Landroidx/leanback/widget/TitleViewAdapter$Provider;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mTitleTextView", "Landroid/widget/TextView;", "mTitleBadgeView", "Landroid/widget/ImageView;", "mSearchOrbView", "Landroidx/leanback/widget/SearchOrbView;", "mTitleViewAdapter", "com/tvstore/ok/CustomTitleView$mTitleViewAdapter$1", "Lcom/tvstore/ok/CustomTitleView$mTitleViewAdapter$1;", "onFinishInflate", "", "getTitleViewAdapter", "Landroidx/leanback/widget/TitleViewAdapter;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class CustomTitleView extends RelativeLayout implements TitleViewAdapter.Provider {
    private SearchOrbView mSearchOrbView;
    private ImageView mTitleBadgeView;
    private TextView mTitleTextView;
    private final CustomTitleView$mTitleViewAdapter$1 mTitleViewAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomTitleView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomTitleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tvstore.ok.CustomTitleView$mTitleViewAdapter$1] */
    public CustomTitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTitleViewAdapter = new TitleViewAdapter() { // from class: com.tvstore.ok.CustomTitleView$mTitleViewAdapter$1
            @Override // androidx.leanback.widget.TitleViewAdapter
            public View getSearchAffordanceView() {
                SearchOrbView searchOrbView;
                searchOrbView = CustomTitleView.this.mSearchOrbView;
                return searchOrbView;
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setTitle(CharSequence titleText) {
                TextView textView;
                TextView textView2;
                textView = CustomTitleView.this.mTitleTextView;
                if (textView != null) {
                    textView.setText(titleText);
                }
                textView2 = CustomTitleView.this.mTitleTextView;
                if (textView2 != null) {
                    textView2.setVisibility((titleText == null || titleText.length() == 0) ? 8 : 0);
                }
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setBadgeDrawable(Drawable drawable) {
                ImageView imageView;
                ImageView imageView2;
                imageView = CustomTitleView.this.mTitleBadgeView;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                }
                imageView2 = CustomTitleView.this.mTitleBadgeView;
                if (imageView2 != null) {
                    imageView2.setVisibility(drawable != null ? 0 : 8);
                }
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void setOnSearchClickedListener(View.OnClickListener listener) {
                SearchOrbView searchOrbView;
                searchOrbView = CustomTitleView.this.mSearchOrbView;
                if (searchOrbView != null) {
                    searchOrbView.setOnOrbClickedListener(listener);
                }
            }

            @Override // androidx.leanback.widget.TitleViewAdapter
            public void updateComponentsVisibility(int flags) {
                SearchOrbView searchOrbView;
                CustomTitleView.this.findViewById(R.id.title_left_container).setVisibility((flags & 2) == 2 ? 0 : 8);
                searchOrbView = CustomTitleView.this.mSearchOrbView;
                if (searchOrbView != null) {
                    searchOrbView.setVisibility(0);
                }
            }
        };
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mTitleTextView = (TextView) findViewById(R.id.custom_title_text);
        this.mTitleBadgeView = (ImageView) findViewById(R.id.custom_title_badge);
        this.mSearchOrbView = (SearchOrbView) findViewById(R.id.custom_title_orb);
    }

    @Override // androidx.leanback.widget.TitleViewAdapter.Provider
    public TitleViewAdapter getTitleViewAdapter() {
        return this.mTitleViewAdapter;
    }
}
