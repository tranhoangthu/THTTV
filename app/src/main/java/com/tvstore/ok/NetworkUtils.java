package com.tvstore.ok;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.security.ProviderInstaller;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.conscrypt.Conscrypt;

/* compiled from: NetworkUtils.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tvstore/ok/NetworkUtils;", "", "<init>", "()V", "TAG", "", "sharedClient", "Lokhttp3/OkHttpClient;", "initSecurity", "", "context", "Landroid/content/Context;", "warmUp", "getOkHttpClient", "buildOkHttpClient", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class NetworkUtils {
    public static final NetworkUtils INSTANCE = new NetworkUtils();
    private static final String TAG = "NetworkUtils";
    private static volatile OkHttpClient sharedClient;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean buildOkHttpClient$lambda$3(String str, SSLSession sSLSession) {
        return true;
    }

    private NetworkUtils() {
    }

    public final void initSecurity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            ProviderInstaller.installIfNeeded(context);
            Log.d(TAG, "Security provider updated via ProviderInstaller");
        } catch (Exception e) {
            Log.e(TAG, "Failed to update security provider via ProviderInstaller: " + e.getMessage());
            try {
                Security.insertProviderAt(Conscrypt.newProvider(), 1);
                Log.d(TAG, "Security provider initialized via Conscrypt");
            } catch (Exception e2) {
                Log.e(TAG, "Failed to initialize Conscrypt: " + e2.getMessage());
            }
        }
        try {
            String[] protocols = SSLContext.getDefault().getSupportedSSLParameters().getProtocols();
            Intrinsics.checkNotNull(protocols);
            Log.d(TAG, "Supported SSL Protocols: " + ArraysKt.joinToString$default(protocols, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        } catch (Exception e3) {
            Log.e(TAG, "Failed to log supported protocols: " + e3.getMessage());
        }
        warmUp();
    }

    public final void warmUp() {
        getOkHttpClient();
    }

    public final OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient;
        OkHttpClient okHttpClient2 = sharedClient;
        if (okHttpClient2 != null) {
            return okHttpClient2;
        }
        synchronized (this) {
            okHttpClient = sharedClient;
            if (okHttpClient == null) {
                okHttpClient = INSTANCE.buildOkHttpClient();
                sharedClient = okHttpClient;
            }
        }
        return okHttpClient;
    }

    private final OkHttpClient buildOkHttpClient() {
        TrustManager[] trustManagerArr = {new X509TrustManager() { // from class: com.tvstore.ok.NetworkUtils$buildOkHttpClient$trustAllCerts$1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }};
        SSLContext sSLContext = null;
        try {
            SSLContext sSLContext2 = SSLContext.getInstance("TLS");
            sSLContext2.init(null, trustManagerArr, new SecureRandom());
            sSLContext = sSLContext2;
        } catch (Exception e) {
            Log.e(TAG, "Failed to create SSLContext: " + e.getMessage());
        }
        OkHttpClient.Builder addInterceptor = new OkHttpClient.Builder().connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).followRedirects(true).followSslRedirects(true).addInterceptor(new GoogleDriveInterceptor());
        if (sSLContext != null) {
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getSocketFactory(...)");
            TrustManager trustManager = trustManagerArr[0];
            Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            addInterceptor.sslSocketFactory(socketFactory, (X509TrustManager) trustManager);
            addInterceptor.hostnameVerifier(new HostnameVerifier() { // from class: com.tvstore.ok.NetworkUtils$$ExternalSyntheticLambda0
                @Override // javax.net.ssl.HostnameVerifier
                public final boolean verify(String str, SSLSession sSLSession) {
                    return NetworkUtils.buildOkHttpClient$lambda$3(str, sSLSession);
                }
            });
        }
        return addInterceptor.build();
    }
}
