package com.tvstore.ok;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: M3uParser.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0005J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0017\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tvstore/ok/M3uParser;", "", "<init>", "()V", "TAG", "", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "USER_AGENTS", "", "[Ljava/lang/String;", "parseFromUrl", "", "Lcom/tvstore/ok/Movie;", ImagesContract.URL, "fetchInternal", "useHttps", "", "parse", "content", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class M3uParser {
    private static final String TAG = "M3uParser";
    public static final M3uParser INSTANCE = new M3uParser();

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private static final Lazy client = LazyKt.lazy(new Function0() { // from class: com.tvstore.ok.M3uParser$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            OkHttpClient okHttpClient;
            okHttpClient = NetworkUtils.INSTANCE.getOkHttpClient();
            return okHttpClient;
        }
    });
    private static final String[] USER_AGENTS = {"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36", "Mozilla/5.0 (Android 13; Mobile; rv:109.0) Gecko/119.0 Firefox/119.0", "Dalvik/2.1.0 (Linux; U; Android 13; Pixel 7 Build/TQ3A.230705.001)"};

    private M3uParser() {
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) client.getValue();
    }

    public final List<Movie> parseFromUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String obj = StringsKt.trim((CharSequence) url).toString();
        if (StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null)) {
            return fetchInternal(obj, StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null));
        }
        List<Movie> fetchInternal = fetchInternal(obj, true);
        if (!fetchInternal.isEmpty()) {
            return fetchInternal;
        }
        Log.d(TAG, "HTTPS failed or empty, trying HTTP...");
        return fetchInternal(obj, false);
    }

    private final List<Movie> fetchInternal(String url, boolean useHttps) {
        ArrayList arrayList = new ArrayList();
        String replace$default = StringsKt.replace$default(StringsKt.trim((CharSequence) url).toString(), " ", "", false, 4, (Object) null);
        if (!StringsKt.startsWith$default(replace$default, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(replace$default, "https://", false, 2, (Object) null)) {
            replace$default = useHttps ? "https://" + replace$default : "http://" + replace$default;
        }
        String str = replace$default;
        Log.d(TAG, "Fetching M3U: " + str);
        for (String str2 : USER_AGENTS) {
            try {
                Response execute = getClient().newCall(new Request.Builder().url(str).header(HttpHeaders.USER_AGENT, str2).header(HttpHeaders.ACCEPT, "text/plain,application/octet-stream,*/*").header(HttpHeaders.CACHE_CONTROL, "no-cache").build()).execute();
                try {
                    Response response = execute;
                    Log.d(TAG, "Response from: " + response.request().url().getUrl() + ", Code: " + response.code());
                    if (response.isSuccessful()) {
                        ResponseBody body = response.body();
                        if (body != null) {
                            String string = body.string();
                            if (!StringsKt.contains((CharSequence) string, (CharSequence) "#EXTM3U", true) && !StringsKt.contains((CharSequence) string, (CharSequence) "#EXTINF", true)) {
                                if (string.length() > 500 && StringsKt.startsWith$default(StringsKt.trim((CharSequence) string).toString(), "http", false, 2, (Object) null)) {
                                    Log.d(TAG, "Raw link list detected");
                                    List<Movie> parse = INSTANCE.parse(string);
                                    CloseableKt.closeFinally(execute, null);
                                    return parse;
                                }
                                Log.w(TAG, "Content received but doesn't look like M3U. Preview: " + StringsKt.take(string, 100));
                            }
                            Log.d(TAG, "Valid M3U content detected (" + string.length() + " chars)");
                            List<Movie> parse2 = INSTANCE.parse(string);
                            CloseableKt.closeFinally(execute, null);
                            return parse2;
                        }
                    } else if (response.code() == 301 || response.code() == 302 || response.code() == 307 || response.code() == 308) {
                        String header$default = Response.header$default(response, HttpHeaders.LOCATION, null, 2, null);
                        Log.d(TAG, "Manual redirect needed to: " + header$default);
                        if (header$default != null && !Intrinsics.areEqual(header$default, str)) {
                            List<Movie> parseFromUrl = INSTANCE.parseFromUrl(header$default);
                            CloseableKt.closeFinally(execute, null);
                            return parseFromUrl;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(execute, null);
                    Unit unit2 = Unit.INSTANCE;
                } finally {
                    try {
                        break;
                    } catch (Throwable th) {
                    }
                }
            } catch (Exception e) {
                Integer.valueOf(Log.e(TAG, "Error with User-Agent [" + str2 + "]: " + e.getMessage()));
            }
        }
        return arrayList;
    }

    public final List<Movie> parse(String content) {
        Iterator<String> it;
        String str;
        String substringAfterLast$default;
        String str2;
        String str3;
        String str4;
        String str5;
        int i;
        List<String> groupValues;
        List<String> groupValues2;
        List<String> groupValues3;
        List<String> groupValues4;
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        List<String> split = new Regex("\\r\\n|\\r|\\n").split(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(content, "\ufeff", "", false, 4, (Object) null), "\ufffe", "", false, 4, (Object) null), "\u200b", "", false, 4, (Object) null), "\u200c", "", false, 4, (Object) null), "\u200d", "", false, 4, (Object) null), " ", " ", false, 4, (Object) null), 0);
        Regex regex = new Regex("tvg-id=[\"']?([^\"',]+)[\"']?");
        Regex regex2 = new Regex("tvg-name=[\"']?([^\"',]+)[\"']?");
        Regex regex3 = new Regex("tvg-logo=\"([^\"]+)\"");
        Regex regex4 = new Regex("group-title=\"([^\"]+)\"");
        Iterator<String> it2 = split.iterator();
        long j = 0;
        Movie movie = null;
        while (it2.hasNext()) {
            String obj = StringsKt.trim((CharSequence) it2.next()).toString();
            String str6 = obj;
            if (str6.length() == 0) {
                it = it2;
            } else if (StringsKt.startsWith$default(obj, "#EXTINF", z, 2, (Object) null)) {
                long j2 = j + 1;
                Movie movie2 = new Movie(j, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null);
                int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str6, ",", 0, false, 6, (Object) null);
                if (lastIndexOf$default != -1) {
                    String substring = obj.substring(lastIndexOf$default + 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    movie2.setTitle(StringsKt.trim((CharSequence) substring).toString());
                }
                MatchResult find$default = Regex.find$default(regex, str6, 0, 2, null);
                String str7 = (find$default == null || (groupValues4 = find$default.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues4, 1);
                MatchResult find$default2 = Regex.find$default(regex2, str6, 0, 2, null);
                String str8 = (find$default2 == null || (groupValues3 = find$default2.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues3, 1);
                if (str7 == null) {
                    str7 = str8 == null ? movie2.getTitle() : str8;
                }
                movie2.setTvgId(str7);
                MatchResult find$default3 = Regex.find$default(regex3, str6, 0, 2, null);
                String str9 = (find$default3 == null || (groupValues2 = find$default3.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues2, 1);
                movie2.setCardImageUrl(str9);
                movie2.setBackgroundImageUrl(str9);
                MatchResult find$default4 = Regex.find$default(regex4, str6, 0, 2, null);
                String str10 = (find$default4 == null || (groupValues = find$default4.getGroupValues()) == null) ? null : (String) CollectionsKt.getOrNull(groupValues, 1);
                if (str10 == null) {
                    str10 = "Khác";
                }
                movie2.setCategory(str10);
                movie2.setStudio(movie2.getCategory());
                movie = movie2;
                j = j2;
                z = false;
            } else {
                long j3 = j;
                if (StringsKt.startsWith$default(obj, "#EXTVLCOPT:", false, 2, (Object) null)) {
                    if (movie == null) {
                        long j4 = j3 + 1;
                        str5 = "[\\p{Cc}\\p{Cf}]";
                        it = it2;
                        i = 2;
                        str4 = str6;
                        movie = new Movie(j3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null);
                        j = j4;
                    } else {
                        str4 = str6;
                        str5 = "[\\p{Cc}\\p{Cf}]";
                        j = j3;
                        it = it2;
                        i = 2;
                    }
                    if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "http-user-agent=", false, i, (Object) null)) {
                        movie.setUserAgent(StringsKt.trim((CharSequence) StringsKt.substringAfter$default(obj, "http-user-agent=", (String) null, i, (Object) null)).toString());
                    } else if (StringsKt.contains$default((CharSequence) str4, (CharSequence) "http-referrer=", false, i, (Object) null) || StringsKt.contains$default((CharSequence) str4, (CharSequence) "http-referer=", false, i, (Object) null)) {
                        movie.setReferrer(new Regex(str5).replace(StringsKt.trim((CharSequence) StringsKt.substringAfter$default(obj, "=", (String) null, i, (Object) null)).toString(), ""));
                    }
                } else {
                    String str11 = str6;
                    j = j3;
                    it = it2;
                    if (StringsKt.startsWith$default(obj, "#KODIPROP", false, 2, (Object) null)) {
                        if (movie == null) {
                            str3 = "http";
                            str2 = "[\\p{Cc}\\p{Cf}]";
                            str11 = str11;
                            movie = new Movie(j, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null);
                            j++;
                        } else {
                            str2 = "[\\p{Cc}\\p{Cf}]";
                            str3 = "http";
                        }
                        if (StringsKt.contains$default((CharSequence) str11, (CharSequence) "manifest_type", false, 2, (Object) null)) {
                            movie.setManifestType(StringsKt.trim((CharSequence) StringsKt.substringAfter$default(obj, "manifest_type=", (String) null, 2, (Object) null)).toString());
                        } else {
                            String str12 = "clearkey";
                            if (StringsKt.contains$default((CharSequence) str11, (CharSequence) "license_type", false, 2, (Object) null)) {
                                String obj2 = StringsKt.trim((CharSequence) StringsKt.substringAfter$default(obj, "license_type=", (String) null, 2, (Object) null)).toString();
                                String str13 = obj2;
                                if (StringsKt.contains((CharSequence) str13, (CharSequence) "widevine", true)) {
                                    str12 = "widevine";
                                } else if (!StringsKt.contains((CharSequence) str13, (CharSequence) "clearkey", true)) {
                                    str12 = obj2;
                                }
                                movie.setDrmType(str12);
                            } else if (StringsKt.contains$default((CharSequence) str11, (CharSequence) "license_key", false, 2, (Object) null)) {
                                String replace = new Regex(str2).replace(StringsKt.trim((CharSequence) StringsKt.substringAfter$default(obj, "license_key=", (String) null, 2, (Object) null)).toString(), "");
                                if (StringsKt.startsWith$default(replace, str3, false, 2, (Object) null)) {
                                    movie.setDrmLicenseUrl(replace);
                                    if (StringsKt.contains((CharSequence) replace, (CharSequence) "clearkey", true) && movie.getDrmType() == null) {
                                        movie.setDrmType("clearkey");
                                    }
                                } else {
                                    movie.setClearKey(replace);
                                    if (movie.getDrmType() == null) {
                                        movie.setDrmType("clearkey");
                                    }
                                }
                            }
                        }
                    } else if (!StringsKt.startsWith$default(obj, "#", false, 2, (Object) null) && (StringsKt.startsWith$default(obj, "http", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str11, (CharSequence) ".m3u8", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str11, (CharSequence) ".mpd", false, 2, (Object) null) || movie != null)) {
                        if (movie == null) {
                            str = str11;
                            Movie movie3 = new Movie(j, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null);
                            j++;
                            movie = movie3;
                        } else {
                            str = str11;
                        }
                        movie.setVideoUrl(StringsKt.trim((CharSequence) new Regex("[\\x00-\\x1F\\x7F]").replace(new Regex("[\\s\\p{Cc}\\p{Cf}]").replace(str, ""), "")).toString());
                        String title = movie.getTitle();
                        if (title == null || title.length() == 0) {
                            String videoUrl = movie.getVideoUrl();
                            movie.setTitle((videoUrl == null || (substringAfterLast$default = StringsKt.substringAfterLast$default(videoUrl, "/", (String) null, 2, (Object) null)) == null) ? null : StringsKt.substringBefore$default(substringAfterLast$default, "?", (String) null, 2, (Object) null));
                        }
                        arrayList.add(movie);
                        movie = null;
                    }
                }
            }
            it2 = it;
            z = false;
        }
        Log.d(TAG, "Parsed " + arrayList.size() + " movies");
        return arrayList;
    }
}
