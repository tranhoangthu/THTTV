package com.tvstore.ok;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.tvprovider.media.tv.TvContractCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: ChannelAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!BW\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0011J\u0014\u0010\u001f\u001a\u00020\u000b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/tvstore/ok/ChannelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tvstore/ok/ChannelAdapter$ViewHolder;", "channels", "", "Lcom/tvstore/ok/Movie;", "currentChannelId", "", "masterChannels", "onChannelClick", "Lkotlin/Function1;", "", "onChannelLongClick", "<init>", "(Ljava/util/List;JLjava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "masterChannelIndices", "", "", "logoTransform", "Lcom/bumptech/glide/load/resource/bitmap/RoundedCorners;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "getItemCount", "updateCurrentChannel", "channelId", "getCurrentChannelPosition", "updateData", "newChannels", "ViewHolder", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class ChannelAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Movie> channels;
    private long currentChannelId;
    private final RoundedCorners logoTransform;
    private final Map<Long, Integer> masterChannelIndices;
    private final List<Movie> masterChannels;
    private final Function1<Movie, Unit> onChannelClick;
    private final Function1<Movie, Unit> onChannelLongClick;

    public /* synthetic */ ChannelAdapter(List list, long j, List list2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j, list2, function1, (i & 16) != 0 ? null : function12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelAdapter(List<Movie> channels, long j, List<Movie> masterChannels, Function1<? super Movie, Unit> onChannelClick, Function1<? super Movie, Unit> function1) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        Intrinsics.checkNotNullParameter(masterChannels, "masterChannels");
        Intrinsics.checkNotNullParameter(onChannelClick, "onChannelClick");
        this.channels = channels;
        this.currentChannelId = j;
        this.masterChannels = masterChannels;
        this.onChannelClick = onChannelClick;
        this.onChannelLongClick = function1;
        List<Movie> list = masterChannels;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            Movie ch = (Movie) obj;
            if (ch != null) {
                String cat = ch.getCategory();
                if (cat == null || !MovieList.INSTANCE.isCategoryHidden(cat)) {
                    arrayList.add(TuplesKt.to(Long.valueOf(ch.getId()), Integer.valueOf(i)));
                    i++;
                }
            }
        }
        this.masterChannelIndices = MapsKt.toMap(arrayList);
        this.logoTransform = new RoundedCorners(12);
    }

    /* compiled from: ChannelAdapter.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/tvstore/ok/ChannelAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", TvContractCompat.Channels.Logo.CONTENT_DIRECTORY, "Landroid/widget/ImageView;", "getLogo", "()Landroid/widget/ImageView;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "epg", "getEpg", "category", "getCategory", "playing", "getPlaying", "root", "getRoot", "()Landroid/view/View;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView category;
        private final TextView epg;
        private final ImageView logo;
        private final TextView name;
        private final TextView playing;
        private final View root;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.channel_logo);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            this.logo = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.channel_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            this.name = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.channel_epg);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
            this.epg = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.channel_category);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            this.category = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.channel_playing);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
            this.playing = (TextView) findViewById5;
            View findViewById6 = view.findViewById(R.id.channel_item_root);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
            this.root = findViewById6;
        }

        public final ImageView getLogo() {
            return this.logo;
        }

        public final TextView getName() {
            return this.name;
        }

        public final TextView getEpg() {
            return this.epg;
        }

        public final TextView getCategory() {
            return this.category;
        }

        public final TextView getPlaying() {
            return this.playing;
        }

        public final View getRoot() {
            return this.root;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_channel, parent, false);
        Intrinsics.checkNotNull(inflate);
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final Movie movie = this.channels.get(position);
        boolean isFavorite = MovieList.INSTANCE.isFavorite(movie);
        Integer num = this.masterChannelIndices.get(Long.valueOf(movie.getId()));
        int intValue = num != null ? num.intValue() : -1;
        int i = intValue >= 0 ? intValue + 1 : position + 1;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%d. ", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        TextView name = holder.getName();
        String str = isFavorite ? "❤️ " : "";
        String title = movie.getTitle();
        if (title == null) {
            title = "Kênh " + i;
        }
        name.setText(format + str + title);
        TextView category = holder.getCategory();
        String category2 = movie.getCategory();
        category.setText(category2 != null ? category2 : "");
        EpgProgram currentProgram = EpgManager.INSTANCE.getCurrentProgram(movie.getTvgId(), movie.getTitle());
        if (currentProgram != null) {
            holder.getEpg().setText(currentProgram.getTitle());
            holder.getEpg().setVisibility(0);
        } else {
            holder.getEpg().setVisibility(8);
        }
        boolean z = movie.getId() == this.currentChannelId;
        holder.getPlaying().setVisibility(z ? 0 : 8);
        if (z) {
            holder.getRoot().setBackgroundColor(Color.parseColor("#33FFFFFF"));
        } else {
            holder.getRoot().setBackgroundColor(0);
        }
        Glide.with(holder.itemView.getContext()).load(movie.getCardImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).timeout(5000).dontAnimate().transform(this.logoTransform).fitCenter().placeholder(R.drawable.app_icon_your_company).error(R.drawable.app_icon_your_company).into(holder.getLogo());
        holder.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.ChannelAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelAdapter.this.onChannelClick.invoke(movie);
            }
        });
        holder.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tvstore.ok.ChannelAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return ChannelAdapter.onBindViewHolder$lambda$2(ChannelAdapter.this, movie, view);
            }
        });
        holder.getRoot().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tvstore.ok.ChannelAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                ChannelAdapter.onBindViewHolder$lambda$3(Movie.this, this, view, z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean onBindViewHolder$lambda$2(ChannelAdapter channelAdapter, Movie movie, View view) {
        Function1<Movie, Unit> function1 = channelAdapter.onChannelLongClick;
        if (function1 == null) {
            return true;
        }
        function1.invoke(movie);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onBindViewHolder$lambda$3(Movie movie, ChannelAdapter channelAdapter, View view, boolean z) {
        if (z) {
            view.setBackgroundColor(Color.parseColor("#55FFFFFF"));
        } else if (movie.getId() == channelAdapter.currentChannelId) {
            view.setBackgroundColor(Color.parseColor("#33FFFFFF"));
        } else {
            view.setBackgroundColor(0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.channels.size();
    }

    public final void updateCurrentChannel(long channelId) {
        this.currentChannelId = channelId;
        notifyDataSetChanged();
    }

    public final int getCurrentChannelPosition() {
        Iterator<Movie> it = this.channels.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getId() == this.currentChannelId) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final void updateData(List<Movie> newChannels) {
        Intrinsics.checkNotNullParameter(newChannels, "newChannels");
        this.channels = newChannels;
        notifyDataSetChanged();
    }
}
