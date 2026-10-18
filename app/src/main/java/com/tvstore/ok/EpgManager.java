package com.tvstore.ok;

import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.tvprovider.media.tv.TvContractCompat;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: EpgManager.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0014\u0010\"\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\u001e\u0010%\u001a\u0004\u0018\u00010\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005J\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005J\u001e\u0010(\u001a\u0004\u0018\u00010\u00122\b\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/tvstore/ok/EpgManager;", "", "<init>", "()V", "TAG", "", "EPG_URL", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "dateFormat", "Ljava/text/SimpleDateFormat;", "epgCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tvstore/ok/EpgProgram;", "channelAliasMap", "resolvedIdCache", "isUpdating", "", "callbacks", "", "Lkotlin/Function0;", "", "fetchEpg", "callback", "parseEpg", "inputStream", "Ljava/io/InputStream;", "normalizeTitle", TvContractCompat.ProgramColumns.COLUMN_TITLE, "resolveId", "tvgId", "performResolveId", "getCurrentProgram", "channelTitle", "getPrograms", "getNextProgram", "EpgProgramBuilder", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class EpgManager {
    private static final String EPG_URL = "https://vnepg.site/epg.xml";
    private static final String TAG = "EpgManager";
    private static boolean isUpdating;
    public static final EpgManager INSTANCE = new EpgManager();

    /* renamed from: client$delegate, reason: from kotlin metadata */
    private static final Lazy client = LazyKt.lazy(new Function0() { // from class: com.tvstore.ok.EpgManager$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            OkHttpClient okHttpClient;
            okHttpClient = NetworkUtils.INSTANCE.getOkHttpClient();
            return okHttpClient;
        }
    });
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss Z", Locale.US);
    private static final ConcurrentHashMap<String, List<EpgProgram>> epgCache = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> channelAliasMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> resolvedIdCache = new ConcurrentHashMap<>();
    private static final List<Function0<Unit>> callbacks = new ArrayList();

    private EpgManager() {
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) client.getValue();
    }

    public final void fetchEpg(Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!epgCache.isEmpty()) {
            callback.invoke();
            return;
        }
        List<Function0<Unit>> list = callbacks;
        synchronized (list) {
            list.add(callback);
            if (isUpdating) {
                return;
            }
            isUpdating = true;
            Unit unit = Unit.INSTANCE;
            new Thread(new Runnable() { // from class: com.tvstore.ok.EpgManager$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    EpgManager.fetchEpg$lambda$6();
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void fetchEpg$lambda$6() {
        ResponseBody body;
        InputStream byteStream;
        try {
            try {
                Request build = new Request.Builder().url(EPG_URL).build();
                EpgManager epgManager = INSTANCE;
                Response execute = epgManager.getClient().newCall(build).execute();
                try {
                    Response response = execute;
                    if (response.isSuccessful() && (body = response.body()) != null && (byteStream = body.byteStream()) != null) {
                        epgManager.parseEpg(byteStream);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(execute, null);
                    List<Function0<Unit>> list = callbacks;
                    synchronized (list) {
                        isUpdating = false;
                        ArrayList arrayList = new ArrayList(list);
                        list.clear();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((Function0) it.next()).invoke();
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                } finally {
                }
            } catch (Throwable th) {
                List<Function0<Unit>> list2 = callbacks;
                synchronized (list2) {
                    isUpdating = false;
                    ArrayList arrayList2 = new ArrayList(list2);
                    list2.clear();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((Function0) it2.next()).invoke();
                    }
                    Unit unit3 = Unit.INSTANCE;
                    throw th;
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "EPG Fetch Error", e);
            List<Function0<Unit>> list3 = callbacks;
            synchronized (list3) {
                isUpdating = false;
                ArrayList arrayList3 = new ArrayList(list3);
                list3.clear();
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    ((Function0) it3.next()).invoke();
                }
                Unit unit4 = Unit.INSTANCE;
            }
        }
    }

    private final void parseEpg(InputStream inputStream) {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        newPullParser.setInput(inputStream, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        EpgProgramBuilder epgProgramBuilder = null;
        String str = null;
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            String name = newPullParser.getName();
            if (eventType != 2) {
                if (eventType == 3) {
                    if (Intrinsics.areEqual(name, "programme") && epgProgramBuilder != null) {
                        EpgProgram build = epgProgramBuilder.build();
                        if (build != null) {
                            String channelId = build.getChannelId();
                            Object obj = linkedHashMap.get(channelId);
                            if (obj == null) {
                                obj = (List) new ArrayList();
                                linkedHashMap.put(channelId, obj);
                            }
                            ((List) obj).add(build);
                        }
                        epgProgramBuilder = null;
                    } else if (Intrinsics.areEqual(name, TvContractCompat.PARAM_CHANNEL)) {
                        str = null;
                    }
                }
            } else if (name != null) {
                switch (name.hashCode()) {
                    case -968778980:
                        if (name.equals("programme")) {
                            String attributeValue = newPullParser.getAttributeValue(null, TtmlNode.START);
                            String attributeValue2 = newPullParser.getAttributeValue(null, "stop");
                            String attributeValue3 = newPullParser.getAttributeValue(null, TvContractCompat.PARAM_CHANNEL);
                            Intrinsics.checkNotNull(attributeValue3);
                            Intrinsics.checkNotNull(attributeValue);
                            Intrinsics.checkNotNull(attributeValue2);
                            epgProgramBuilder = new EpgProgramBuilder(attributeValue3, attributeValue, attributeValue2);
                            break;
                        } else {
                            break;
                        }
                    case 3079825:
                        if (name.equals("desc") && epgProgramBuilder != null) {
                            epgProgramBuilder.setDescription(newPullParser.nextText());
                            break;
                        }
                        break;
                    case 110371416:
                        if (name.equals(TvContractCompat.ProgramColumns.COLUMN_TITLE) && epgProgramBuilder != null) {
                            epgProgramBuilder.setTitle(newPullParser.nextText());
                            break;
                        }
                        break;
                    case 738950403:
                        if (name.equals(TvContractCompat.PARAM_CHANNEL)) {
                            str = newPullParser.getAttributeValue(null, TtmlNode.ATTR_ID);
                            break;
                        } else {
                            break;
                        }
                    case 1568910518:
                        if (name.equals("display-name") && str != null) {
                            String nextText = newPullParser.nextText();
                            Intrinsics.checkNotNullExpressionValue(nextText, "nextText(...)");
                            String lowerCase = StringsKt.trim((CharSequence) nextText).toString().toLowerCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                            linkedHashMap2.put(lowerCase, str);
                            break;
                        }
                        break;
                }
            }
        }
        ConcurrentHashMap<String, List<EpgProgram>> concurrentHashMap = epgCache;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(linkedHashMap);
        ConcurrentHashMap<String, String> concurrentHashMap2 = channelAliasMap;
        concurrentHashMap2.clear();
        concurrentHashMap2.putAll(linkedHashMap2);
        resolvedIdCache.clear();
    }

    private final String normalizeTitle(String title) {
        String lowerCase = StringsKt.trim((CharSequence) title).toString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(lowerCase, " hd", "", false, 4, (Object) null), " sd", "", false, 4, (Object) null), " fhd", "", false, 4, (Object) null), " 4k", "", false, 4, (Object) null), " k+", "", false, 4, (Object) null), " ", "", false, 4, (Object) null);
    }

    private final String resolveId(String tvgId) {
        String str = null;
        if (tvgId != null) {
            String str2 = tvgId;
            if (StringsKt.trim((CharSequence) str2).toString().length() != 0) {
                String obj = StringsKt.trim((CharSequence) str2).toString();
                ConcurrentHashMap<String, String> concurrentHashMap = resolvedIdCache;
                String str3 = concurrentHashMap.get(obj);
                if (str3 != null) {
                    if (Intrinsics.areEqual(str3, "NULL_SENTINEL")) {
                        return null;
                    }
                    return str3;
                }
                str = performResolveId(obj);
                concurrentHashMap.put(obj, str != null ? str : "NULL_SENTINEL");
            }
        }
        return str;
    }

    private final String performResolveId(String tvgId) {
        Object obj;
        Object obj2;
        Object obj3;
        String lowerCase = tvgId.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Set<String> keySet = epgCache.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        Iterator<T> it = keySet.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            String str = (String) obj2;
            Intrinsics.checkNotNull(str);
            String lowerCase2 = str.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase2, lowerCase)) {
                break;
            }
        }
        String str2 = (String) obj2;
        if (str2 != null) {
            return str2;
        }
        ConcurrentHashMap<String, String> concurrentHashMap = channelAliasMap;
        String str3 = concurrentHashMap.get(lowerCase);
        if (str3 == null) {
            String normalizeTitle = normalizeTitle(tvgId);
            Set<String> keySet2 = concurrentHashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet2, "<get-keys>(...)");
            Iterator<T> it2 = keySet2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj3 = null;
                    break;
                }
                obj3 = it2.next();
                String str4 = (String) obj3;
                EpgManager epgManager = INSTANCE;
                Intrinsics.checkNotNull(str4);
                if (Intrinsics.areEqual(epgManager.normalizeTitle(str4), normalizeTitle)) {
                    break;
                }
            }
            String str5 = (String) obj3;
            if (str5 != null) {
                str3 = channelAliasMap.get(str5);
            }
        }
        if (str3 == null) {
            String normalizeTitle2 = normalizeTitle(tvgId);
            Set<String> keySet3 = epgCache.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet3, "<get-keys>(...)");
            Iterator<T> it3 = keySet3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                String str6 = (String) next;
                EpgManager epgManager2 = INSTANCE;
                Intrinsics.checkNotNull(str6);
                if (Intrinsics.areEqual(epgManager2.normalizeTitle(str6), normalizeTitle2)) {
                    obj = next;
                    break;
                }
            }
            String str7 = (String) obj;
            if (str7 != null) {
                return str7;
            }
        }
        return str3;
    }

    public static /* synthetic */ EpgProgram getCurrentProgram$default(EpgManager epgManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return epgManager.getCurrentProgram(str, str2);
    }

    public final EpgProgram getCurrentProgram(String tvgId, String channelTitle) {
        List<EpgProgram> list;
        String resolveId = resolveId(tvgId);
        if (resolveId == null && channelTitle != null) {
            resolveId = resolveId(channelTitle);
        }
        Object obj = null;
        if (resolveId == null || (list = epgCache.get(resolveId)) == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((EpgProgram) next).isCurrent()) {
                obj = next;
                break;
            }
        }
        return (EpgProgram) obj;
    }

    public static /* synthetic */ List getPrograms$default(EpgManager epgManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return epgManager.getPrograms(str, str2);
    }

    public final List<EpgProgram> getPrograms(String tvgId, String channelTitle) {
        String resolveId = resolveId(tvgId);
        if (resolveId == null && channelTitle != null) {
            resolveId = resolveId(channelTitle);
        }
        if (resolveId == null) {
            return CollectionsKt.emptyList();
        }
        List<EpgProgram> list = epgCache.get(resolveId);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static /* synthetic */ EpgProgram getNextProgram$default(EpgManager epgManager, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return epgManager.getNextProgram(str, str2);
    }

    public final EpgProgram getNextProgram(String tvgId, String channelTitle) {
        String resolveId = resolveId(tvgId);
        if (resolveId == null && channelTitle != null) {
            resolveId = resolveId(channelTitle);
        }
        Object obj = null;
        if (resolveId == null) {
            return null;
        }
        Date date = new Date();
        List<EpgProgram> list = epgCache.get(resolveId);
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((EpgProgram) obj2).getStartTime().after(date)) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            obj = it.next();
            if (it.hasNext()) {
                Date startTime = ((EpgProgram) obj).getStartTime();
                do {
                    Object next = it.next();
                    Date startTime2 = ((EpgProgram) next).getStartTime();
                    if (startTime.compareTo(startTime2) > 0) {
                        obj = next;
                        startTime = startTime2;
                    }
                } while (it.hasNext());
            }
        }
        return (EpgProgram) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EpgManager.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/tvstore/ok/EpgManager$EpgProgramBuilder;", "", "channelId", "", "startStr", "stopStr", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChannelId", "()Ljava/lang/String;", "getStartStr", "getStopStr", TvContractCompat.ProgramColumns.COLUMN_TITLE, "getTitle", "setTitle", "(Ljava/lang/String;)V", TvContractCompat.Channels.COLUMN_DESCRIPTION, "getDescription", "setDescription", "build", "Lcom/tvstore/ok/EpgProgram;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class EpgProgramBuilder {
        private final String channelId;
        private String description;
        private final String startStr;
        private final String stopStr;
        private String title;

        public EpgProgramBuilder(String channelId, String startStr, String stopStr) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(startStr, "startStr");
            Intrinsics.checkNotNullParameter(stopStr, "stopStr");
            this.channelId = channelId;
            this.startStr = startStr;
            this.stopStr = stopStr;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getStartStr() {
            return this.startStr;
        }

        public final String getStopStr() {
            return this.stopStr;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getDescription() {
            return this.description;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final EpgProgram build() {
            if (this.title == null) {
                return null;
            }
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7"));
                String substring = this.startStr.substring(0, 14);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                Date parse = simpleDateFormat.parse(substring);
                String substring2 = this.stopStr.substring(0, 14);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                Date parse2 = simpleDateFormat.parse(substring2);
                String str = this.title;
                Intrinsics.checkNotNull(str);
                Intrinsics.checkNotNull(parse);
                Intrinsics.checkNotNull(parse2);
                return new EpgProgram(str, parse, parse2, this.description, this.channelId);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
