package com.tvstore.ok;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: NetworkUtils.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/tvstore/ok/GoogleDriveInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class GoogleDriveInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        List<String> groupValues;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String url = request.url().getUrl();
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "drive.usercontent.google.com/download", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) url, (CharSequence) "drive.google.com", false, 2, (Object) null)) {
            String queryParameter = request.url().queryParameter(TtmlNode.ATTR_ID);
            if (queryParameter == null) {
                MatchResult find$default = Regex.find$default(new Regex("/file/d/([^/]+)"), url, 0, 2, null);
                queryParameter = (find$default == null || (groupValues = find$default.getGroupValues()) == null) ? null : groupValues.get(1);
            }
            if (queryParameter != null && (StringsKt.contains$default((CharSequence) url, (CharSequence) "&at=", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) url, (CharSequence) "uuid=", false, 2, (Object) null))) {
                String str = "https://drive.google.com/uc?export=download&id=" + queryParameter;
                Log.d("NetworkUtils", "Auto-fixed expired Drive link: " + str);
                request = request.newBuilder().url(str).build();
            }
        }
        Response proceed = chain.proceed(request);
        String url2 = request.url().getUrl();
        if (StringsKt.contains$default((CharSequence) url2, (CharSequence) "drive.google.com", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) url2, (CharSequence) "drive.usercontent.google.com", false, 2, (Object) null)) {
            String header = proceed.header(HttpHeaders.CONTENT_TYPE, "");
            String str2 = header != null ? header : "";
            if (proceed.isSuccessful() && StringsKt.contains$default((CharSequence) str2, (CharSequence) "text/html", false, 2, (Object) null)) {
                MatchResult find$default2 = Regex.find$default(new Regex("(?:action|href)=\"([^\"]*confirm=[^\"]*)\""), proceed.peekBody(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED).string(), 0, 2, null);
                if (find$default2 != null) {
                    String replace$default = StringsKt.replace$default(find$default2.getGroupValues().get(1), "&amp;", "&", false, 4, (Object) null);
                    if (StringsKt.startsWith$default(replace$default, "/", false, 2, (Object) null)) {
                        replace$default = "https://drive.google.com" + replace$default;
                    }
                    Log.d("NetworkUtils", "Bypassing Google Drive virus scan. Found URL: " + replace$default);
                    List<String> headers = proceed.headers(HttpHeaders.SET_COOKIE);
                    proceed.close();
                    Request.Builder url3 = request.newBuilder().url(replace$default);
                    Iterator<String> it = headers.iterator();
                    while (it.hasNext()) {
                        url3.addHeader(HttpHeaders.COOKIE, (String) StringsKt.split$default((CharSequence) it.next(), new String[]{";"}, false, 0, 6, (Object) null).get(0));
                    }
                    return chain.proceed(url3.build());
                }
            }
        }
        return proceed;
    }
}
