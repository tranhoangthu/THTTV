package com.tvstore.ok;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.tvprovider.media.tv.TvContractCompat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EpgAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0014\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/tvstore/ok/EpgAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tvstore/ok/EpgAdapter$ViewHolder;", "programs", "", "Lcom/tvstore/ok/EpgProgram;", "<init>", "(Ljava/util/List;)V", "timeFormat", "Ljava/text/SimpleDateFormat;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "setPrograms", "newPrograms", "ViewHolder", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class EpgAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<EpgProgram> programs;
    private final SimpleDateFormat timeFormat;

    public EpgAdapter(List<EpgProgram> programs) {
        Intrinsics.checkNotNullParameter(programs, "programs");
        this.programs = programs;
        this.timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
    }

    /* compiled from: EpgAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/tvstore/ok/EpgAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "root", "getRoot", "()Landroid/view/View;", "startTime", "Landroid/widget/TextView;", "getStartTime", "()Landroid/widget/TextView;", "endTime", "getEndTime", TypedValues.TransitionType.S_DURATION, "getDuration", TvContractCompat.ProgramColumns.COLUMN_TITLE, "getTitle", "liveBadge", "getLiveBadge", "progressContainer", "getProgressContainer", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView duration;
        private final TextView endTime;
        private final TextView liveBadge;
        private final ProgressBar progressBar;
        private final View progressContainer;
        private final View root;
        private final TextView startTime;
        private final TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.epg_item_root);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.root = findViewById;
            View findViewById2 = view.findViewById(R.id.epg_item_start);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.startTime = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.epg_item_end);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.endTime = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.epg_item_duration);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.duration = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.epg_item_title);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.title = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.epg_live_badge);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.liveBadge = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.epg_progress_container);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
            this.progressContainer = findViewById7;
            View findViewById8 = view.findViewById(R.id.epg_item_progress);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
            this.progressBar = (ProgressBar) findViewById8;
        }

        public final View getRoot() {
            return this.root;
        }

        public final TextView getStartTime() {
            return this.startTime;
        }

        public final TextView getEndTime() {
            return this.endTime;
        }

        public final TextView getDuration() {
            return this.duration;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final TextView getLiveBadge() {
            return this.liveBadge;
        }

        public final View getProgressContainer() {
            return this.progressContainer;
        }

        public final ProgressBar getProgressBar() {
            return this.progressBar;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_epg, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        EpgProgram epgProgram = this.programs.get(position);
        boolean isCurrent = epgProgram.isCurrent();
        holder.getStartTime().setText(this.timeFormat.format(epgProgram.getStartTime()));
        holder.getEndTime().setText(this.timeFormat.format(epgProgram.getStopTime()));
        long time = epgProgram.getStopTime().getTime() - epgProgram.getStartTime().getTime();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        holder.getDuration().setText("(" + (time / 60000) + " phút)");
        holder.getTitle().setText(epgProgram.getFullTitle());
        if (isCurrent) {
            holder.getRoot().setBackgroundColor(Color.parseColor("#1FFF9800"));
            holder.getTitle().setTextColor(Color.parseColor("#FF9800"));
            holder.getLiveBadge().setVisibility(0);
            holder.getProgressContainer().setVisibility(0);
            holder.getProgressBar().setProgress(epgProgram.getProgress());
            holder.getStartTime().setTextColor(Color.parseColor("#FF9800"));
            holder.getEndTime().setTextColor(Color.parseColor("#FF9800"));
            return;
        }
        holder.getRoot().setBackgroundColor(0);
        holder.getTitle().setTextColor(-1);
        holder.getLiveBadge().setVisibility(8);
        holder.getProgressContainer().setVisibility(8);
        holder.getStartTime().setTextColor(-1);
        holder.getEndTime().setTextColor(-1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.programs.size();
    }

    public final void setPrograms(List<EpgProgram> newPrograms) {
        Intrinsics.checkNotNullParameter(newPrograms, "newPrograms");
        this.programs = newPrograms;
        notifyDataSetChanged();
    }
}
