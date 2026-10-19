package com.tvstore.ok;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tvstore.ok.MovieList;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MovieList.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001PB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00101\u001a\u0002022\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00106\u001a\u00020\u0005J\u0010\u00107\u001a\u0002022\u0006\u00103\u001a\u000204H\u0002J:\u00108\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000f2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u0002020=J\u0016\u0010>\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010?\u001a\u00020\u001bJ0\u0010@\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010?\u001a\u00020\u001b2\u0018\u0010<\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0018\u0012\u0004\u0012\u0002020=J\u0016\u0010A\u001a\u00020\u000f2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\"J\u0016\u0010C\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\"J\u000e\u0010D\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\"J\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\"0\u0018J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\"0\u0018J \u0010$\u001a\u0002022\u0018\u0010<\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0018\u0012\u0004\u0012\u0002020=J(\u0010G\u001a\u0002022\u0006\u00103\u001a\u0002042\u0018\u0010<\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0018\u0012\u0004\u0012\u0002020=J\u0016\u0010H\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\u0006\u0010:\u001a\u00020\u0005H\u0002J\u0016\u0010I\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010J\u001a\u00020\u0005J\u000e\u0010K\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u0005J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018J\u0014\u0010O\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\u0006\u0010J\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b \u0010!R*\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00182\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\"0\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR \u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\u00188F¢\u0006\u0006\u001a\u0004\b*\u0010\u001aR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0\u00188F¢\u0006\u0006\u001a\u0004\b,\u0010\u001aR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\"0\u00188F¢\u0006\u0006\u001a\u0004\b.\u0010\u001aR\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\"0\u00188F¢\u0006\u0006\u001a\u0004\b0\u0010\u001aR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00050\u00188F¢\u0006\u0006\u001a\u0004\bM\u0010\u001a¨\u0006Q"}, d2 = {"Lcom/tvstore/ok/MovieList;", "", "<init>", "()V", "TAG", "", "APP_VERSION", "customSources", "", "Lcom/tvstore/ok/MovieList$TvSource;", "favoriteUrls", "", "historyUrls", "hiddenCategories", "isStartup", "", "()Z", "setStartup", "(Z)V", "value", "uiMode", "getUiMode", "()Ljava/lang/String;", "sources", "", "getSources", "()Ljava/util/List;", "", "currentSourceIndex", "getCurrentSourceIndex", "()I", "currentSource", "getCurrentSource", "()Lcom/tvstore/ok/MovieList$TvSource;", "Lcom/tvstore/ok/Movie;", "movies", "getMovies", "localMedia", "getLocalMedia", "setLocalMedia", "(Ljava/util/List;)V", "localVideos", "getLocalVideos", "localImages", "getLocalImages", "localAudios", "getLocalAudios", "list", "getList", "init", "", "context", "Landroid/content/Context;", "setUiMode", "mode", "save", "addSource", "name", ImagesContract.URL, "loadNow", "callback", "Lkotlin/Function1;", "deleteSource", "index", "switchSource", "toggleFavorite", "movie", "addToHistory", "isFavorite", "getFavoriteMovies", "getHistoryMovies", "refreshFromSource", "fetchFromSource", "toggleCategoryVisibility", "category", "isCategoryHidden", "categories", "getCategories", "getAllCategories", "getMoviesByCategory", "TvSource", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class MovieList {
    public static final String APP_VERSION = "2.6";
    private static final String TAG = "MovieList";
    private static int currentSourceIndex;
    public static final MovieList INSTANCE = new MovieList();
    private static List<TvSource> customSources = new ArrayList();
    private static Set<String> favoriteUrls = new LinkedHashSet();
    private static List<String> historyUrls = new ArrayList();
    private static Set<String> hiddenCategories = new LinkedHashSet();
    private static boolean isStartup = true;
    private static String uiMode = "auto";
    private static List<Movie> movies = CollectionsKt.emptyList();
    private static List<Movie> localMedia = CollectionsKt.emptyList();

    public final List<Movie> getLocalAudios() {
        return CollectionsKt.emptyList();
    }

    public final List<Movie> getLocalImages() {
        return CollectionsKt.emptyList();
    }

    public final List<Movie> getLocalVideos() {
        return CollectionsKt.emptyList();
    }

    private MovieList() {
    }

    /* compiled from: MovieList.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/tvstore/ok/MovieList$TvSource;", "", "name", "", ImagesContract.URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final /* data */ class TvSource {
        private final String name;
        private final String url;

        public static /* synthetic */ TvSource copy$default(TvSource tvSource, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = tvSource.name;
            }
            if ((i & 2) != 0) {
                str2 = tvSource.url;
            }
            return tvSource.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public final TvSource copy(String name, String url) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            return new TvSource(name, url);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TvSource)) {
                return false;
            }
            TvSource tvSource = (TvSource) other;
            return Intrinsics.areEqual(this.name, tvSource.name) && Intrinsics.areEqual(this.url, tvSource.url);
        }

        public int hashCode() {
            return (this.name.hashCode() * 31) + this.url.hashCode();
        }

        public String toString() {
            return "TvSource(name=" + this.name + ", url=" + this.url + ")";
        }

        public TvSource(String name, String url) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(url, "url");
            this.name = name;
            this.url = url;
        }

        public final String getName() {
            return this.name;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    public final boolean isStartup() {
        return isStartup;
    }

    public final void setStartup(boolean z) {
        isStartup = z;
    }

    public final String getUiMode() {
        return uiMode;
    }

    public final List<TvSource> getSources() {
        return customSources;
    }

    public final int getCurrentSourceIndex() {
        return currentSourceIndex;
    }

    public final TvSource getCurrentSource() {
        int size = customSources.size();
        int i = currentSourceIndex;
        if (i < 0 || i >= size) {
            return null;
        }
        return customSources.get(i);
    }

    public final List<Movie> getMovies() {
        List<Movie> list = movies;
        if (list == null) return CollectionsKt.emptyList();
        ArrayList<Movie> visible = new ArrayList<>();
        for (Movie m : list) {
            if (m != null) {
                String cat = m.getCategory();
                if (cat == null || !INSTANCE.isCategoryHidden(cat)) {
                    visible.add(m);
                }
            }
        }
        return visible;
    }

    public final List<Movie> getLocalMedia() {
        return localMedia;
    }

    public final void setLocalMedia(List<Movie> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        localMedia = list;
    }

    public final List<Movie> getList() {
        return movies;
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("ok_prefs", 0);
        String string = sharedPreferences.getString("custom_sources", null);
        if (string != null) {
            ArrayList arrayList = (List) new Gson().fromJson(string, new TypeToken<List<TvSource>>() { // from class: com.tvstore.ok.MovieList$init$1$type$1
            }.getType());
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            customSources = arrayList;
        }
        String string2 = sharedPreferences.getString("favorite_urls", null);
        if (string2 != null) {
            LinkedHashSet linkedHashSet = (Set) new Gson().fromJson(string2, new TypeToken<Set<String>>() { // from class: com.tvstore.ok.MovieList$init$2$type$1
            }.getType());
            if (linkedHashSet == null) {
                linkedHashSet = new LinkedHashSet();
            }
            favoriteUrls = linkedHashSet;
        }
        String string3 = sharedPreferences.getString("history_urls", null);
        if (string3 != null) {
            ArrayList arrayList2 = (List) new Gson().fromJson(string3, new TypeToken<List<String>>() { // from class: com.tvstore.ok.MovieList$init$3$type$1
            }.getType());
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            historyUrls = arrayList2;
        }
        String string4 = sharedPreferences.getString("hidden_categories", null);
        if (string4 != null) {
            LinkedHashSet linkedHashSet2 = (Set) new Gson().fromJson(string4, new TypeToken<Set<String>>() { // from class: com.tvstore.ok.MovieList$init$4$type$1
            }.getType());
            if (linkedHashSet2 == null) {
                linkedHashSet2 = new LinkedHashSet();
            }
            hiddenCategories = linkedHashSet2;
        }
        currentSourceIndex = sharedPreferences.getInt("current_source_index", 0);
        String string5 = sharedPreferences.getString("ui_mode", "auto");
        uiMode = string5 != null ? string5 : "auto";
        Log.d(TAG, "Init: " + customSources.size() + " sources, uiMode=" + uiMode + ", hidden=" + hiddenCategories.size());
    }

    public final void setUiMode(Context context, String mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mode, "mode");
        uiMode = mode;
        save(context);
    }

    private final void save(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("ok_prefs", 0).edit();
        edit.putString("custom_sources", new Gson().toJson(customSources));
        edit.putString("favorite_urls", new Gson().toJson(favoriteUrls));
        edit.putString("history_urls", new Gson().toJson(historyUrls));
        edit.putString("hidden_categories", new Gson().toJson(hiddenCategories));
        edit.putInt("current_source_index", currentSourceIndex);
        edit.putString("ui_mode", uiMode);
        edit.apply();
    }

    public final void addSource(final Context context, final String name, String url, final boolean loadNow, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(url, "https://", false, 2, (Object) null) && !StringsKt.startsWith$default(url, "/", false, 2, (Object) null)) {
            url = "http://" + url;
        }
        final String str = url;
        new Thread(new Runnable() { // from class: com.tvstore.ok.MovieList$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MovieList.addSource$lambda$11(str, loadNow, context, callback, name);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void addSource$lambda$11(String str, boolean z, Context context, Function1 function1, String str2) {
        try {
            List<Movie> fetchFromSource = INSTANCE.fetchFromSource(str);
            if (!fetchFromSource.isEmpty()) {
                synchronized (customSources) {
                    List<TvSource> list = customSources;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual(((TvSource) it.next()).getUrl(), str)) {
                                break;
                            }
                        }
                    }
                    customSources.add(new TvSource(str2, str));
                    Unit unit = Unit.INSTANCE;
                }
                if (z || movies.isEmpty()) {
                    Iterator<TvSource> it2 = customSources.iterator();
                    int i = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i = -1;
                            break;
                        } else if (Intrinsics.areEqual(it2.next().getUrl(), str)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i != -1) {
                        currentSourceIndex = i;
                    }
                    movies = fetchFromSource;
                }
                INSTANCE.save(context);
                function1.invoke(true);
                return;
            }
            function1.invoke(false);
        } catch (Exception e) {
            Log.e(TAG, "Error adding source", e);
            function1.invoke(false);
        }
    }

    public final void deleteSource(Context context, int index) {
        Intrinsics.checkNotNullParameter(context, "context");
        synchronized (customSources) {
            if (index >= 0) {
                try {
                    if (index < customSources.size()) {
                        customSources.remove(index);
                        MovieList movieList = INSTANCE;
                        if (currentSourceIndex >= customSources.size()) {
                            currentSourceIndex = 0;
                        }
                        movies = CollectionsKt.emptyList();
                        movieList.save(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void switchSource(Context context, int index, Function1<? super List<Movie>, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (index < 0 || index >= getSources().size()) {
            return;
        }
        currentSourceIndex = index;
        movies = CollectionsKt.emptyList();
        save(context);
        getMovies(callback);
    }

    public final void clearCache() {
        movies = CollectionsKt.emptyList();
    }

    public final boolean toggleFavorite(Context context, Movie movie) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(movie, "movie");
        String videoUrl = movie.getVideoUrl();
        boolean z = false;
        if (videoUrl == null) {
            return false;
        }
        synchronized (favoriteUrls) {
            if (favoriteUrls.contains(videoUrl)) {
                favoriteUrls.remove(videoUrl);
            } else {
                favoriteUrls.add(videoUrl);
                z = true;
            }
        }
        save(context);
        try {
            TvHomeManager.INSTANCE.updateHomeChannels(context);
            return z;
        } catch (Exception e) {
            Log.e(TAG, "TvHome error", e);
            return z;
        }
    }

    public final void addToHistory(Context context, Movie movie) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(movie, "movie");
        String videoUrl = movie.getVideoUrl();
        if (videoUrl == null || StringsKt.startsWith$default(videoUrl, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(videoUrl, "file://", false, 2, (Object) null)) {
            return;
        }
        synchronized (historyUrls) {
            historyUrls.remove(videoUrl);
            historyUrls.add(0, videoUrl);
            if (historyUrls.size() > 10) {
                historyUrls = CollectionsKt.toMutableList((Collection) CollectionsKt.take(historyUrls, 10));
            }
            Unit unit = Unit.INSTANCE;
        }
        save(context);
        try {
            TvHomeManager.INSTANCE.updateHomeChannels(context);
        } catch (Exception e) {
            Log.e(TAG, "TvHome error", e);
        }
    }

    public final boolean isFavorite(Movie movie) {
        boolean contains;
        Intrinsics.checkNotNullParameter(movie, "movie");
        synchronized (favoriteUrls) {
            contains = CollectionsKt.contains(favoriteUrls, movie.getVideoUrl());
        }
        return contains;
    }

    public final List<Movie> getFavoriteMovies() {
        Set set;
        synchronized (favoriteUrls) {
            set = CollectionsKt.toSet(favoriteUrls);
        }
        List plus = CollectionsKt.plus((Collection) movies, (Iterable) localMedia);
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : plus) {
            if (hashSet.add(((Movie) obj).getVideoUrl())) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (CollectionsKt.contains(set, ((Movie) obj2).getVideoUrl())) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    public final List<Movie> getHistoryMovies() {
        List<String> list;
        Object obj;
        synchronized (historyUrls) {
            list = CollectionsKt.toList(historyUrls);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Iterator it = CollectionsKt.plus((Collection) movies, (Iterable) localMedia).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((Movie) obj).getVideoUrl(), str)) {
                    break;
                }
            }
            Movie movie = (Movie) obj;
            if (movie != null) {
                arrayList.add(movie);
            }
        }
        return arrayList;
    }

    public final void getMovies(final Function1<? super List<Movie>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final TvSource currentSource = getCurrentSource();
        if (currentSource == null) {
            callback.invoke(CollectionsKt.emptyList());
        } else {
            new Thread(new Runnable() { // from class: com.tvstore.ok.MovieList$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    MovieList.getMovies$lambda$24(MovieList.TvSource.this, callback);
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void getMovies$lambda$24(TvSource tvSource, Function1 function1) {
        try {
            Log.d(TAG, "Fetching from: " + tvSource.getUrl());
            List<Movie> fetchFromSource = INSTANCE.fetchFromSource(tvSource.getUrl());
            movies = fetchFromSource;
            Log.d(TAG, "Fetched " + fetchFromSource.size() + " movies");
            function1.invoke(movies);
        } catch (Exception e) {
            Log.e(TAG, "Fetch error", e);
            function1.invoke(CollectionsKt.emptyList());
        }
    }

    public final void refreshFromSource(Context context, Function1<? super List<Movie>, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getMovies(callback);
    }

    private final List<Movie> fetchFromSource(String url) {
        if (StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
            return M3uParser.INSTANCE.parseFromUrl(url);
        }
        File file = new File(url);
        return file.exists() ? M3uParser.INSTANCE.parse(FilesKt.readText$default(file, null, 1, null)) : CollectionsKt.emptyList();
    }

    public final void toggleCategoryVisibility(Context context, String category) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(category, "category");
        synchronized (hiddenCategories) {
            if (hiddenCategories.contains(category)) {
                hiddenCategories.remove(category);
            } else {
                hiddenCategories.add(category);
            }
        }
        save(context);
    }

    public final boolean isCategoryHidden(String category) {
        boolean contains;
        Intrinsics.checkNotNullParameter(category, "category");
        synchronized (hiddenCategories) {
            contains = hiddenCategories.contains(category);
        }
        return contains;
    }

    public final List<String> getCategories() {
        List<Movie> list = movies;
        if (list == null) return CollectionsKt.emptyList();
        ArrayList<String> foundCats = new ArrayList<>();
        for (Movie m : list) {
            if (m != null) {
                String category = m.getCategory();
                if (category != null && !category.isEmpty() && !foundCats.contains(category)) {
                    foundCats.add(category);
                }
            }
        }

        List<String> ORDERED_CATS = java.util.Arrays.asList(
            "Xem Gần Đây", "Yêu Thích", "VTV", "Thiết Yếu", "Thiết yếu", "HTV", "HTVC", "VTVcab", "SCTV",
            "Vĩnh Long", "Địa Phương", "Địa phương", "In The Box", "Giải Trí", "Thể Thao", "Thể thao",
            "THỂ THAO QUỐC TẾ", "Thể thao quốc tế", "Sự Kiện TV360", "Sự Kiện VTVPrime", "Sự Kiện FPT PLAY",
            "LIVE EVENTS", "TVB", "Quốc Tế", "Radio", "Radio ZingMP3", "Khác"
        );

        ArrayList<String> sorted = new ArrayList<>();
        if (!getHistoryMovies().isEmpty() && !INSTANCE.isCategoryHidden("Xem Gần Đây")) {
            sorted.add("Xem Gần Đây");
        }

        for (String ord : ORDERED_CATS) {
            if (ord.equals("Xem Gần Đây")) continue;
            for (String fc : foundCats) {
                if (ord.equalsIgnoreCase(fc) && !INSTANCE.isCategoryHidden(fc) && !sorted.contains(fc)) {
                    sorted.add(fc);
                }
            }
        }

        for (String fc : foundCats) {
            if (!sorted.contains(fc) && !INSTANCE.isCategoryHidden(fc)) {
                sorted.add(fc);
            }
        }

        return sorted;
    }

    public final List<String> getAllCategories() {
        List<Movie> list = movies;
        if (list == null) return CollectionsKt.emptyList();
        ArrayList<String> foundCats = new ArrayList<>();
        for (Movie m : list) {
            if (m != null) {
                String category = m.getCategory();
                if (category != null && !category.isEmpty() && !foundCats.contains(category)) {
                    foundCats.add(category);
                }
            }
        }
        return foundCats;
    }

    public final List<Movie> getMoviesByCategory(String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        if (category.equalsIgnoreCase("Xem Gần Đây") || category.equalsIgnoreCase("Gần đây")) {
            return getHistoryMovies();
        }
        if (category.equalsIgnoreCase("Yêu Thích") || category.equalsIgnoreCase("❤️ Yêu thích")) {
            return getFavoriteMovies();
        }
        List<Movie> list = movies;
        ArrayList<Movie> arrayList = new ArrayList<>();
        if (list == null) return arrayList;
        for (Movie obj : list) {
            if (obj != null && category.equalsIgnoreCase(obj.getCategory())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
