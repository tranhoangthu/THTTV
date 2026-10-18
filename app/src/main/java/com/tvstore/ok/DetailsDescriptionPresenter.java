package com.tvstore.ok;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.leanback.widget.AbstractDetailsDescriptionPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailsDescriptionPresenter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/tvstore/ok/DetailsDescriptionPresenter;", "Landroidx/leanback/widget/AbstractDetailsDescriptionPresenter;", "<init>", "()V", "onBindDescription", "", "viewHolder", "Landroidx/leanback/widget/AbstractDetailsDescriptionPresenter$ViewHolder;", "item", "", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DetailsDescriptionPresenter extends AbstractDetailsDescriptionPresenter {
    @Override // androidx.leanback.widget.AbstractDetailsDescriptionPresenter
    protected void onBindDescription(AbstractDetailsDescriptionPresenter.ViewHolder viewHolder, Object item) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(item, "item");
        Movie movie = (Movie) item;
        viewHolder.getTitle().setText(movie.getTitle());
        viewHolder.getSubtitle().setText(movie.getStudio());
        viewHolder.getBody().setText(movie.getDescription());
    }
}
