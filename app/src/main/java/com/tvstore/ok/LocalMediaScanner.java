package com.tvstore.ok;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: LocalMediaScanner.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/tvstore/ok/LocalMediaScanner;", "", "<init>", "()V", "TAG", "", "scanLocalMedia", "", "Lcom/tvstore/ok/Movie;", "context", "Landroid/content/Context;", "formatDuration", "ms", "", "formatSize", "bytes", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class LocalMediaScanner {
    public static final LocalMediaScanner INSTANCE = new LocalMediaScanner();
    private static final String TAG = "LocalMediaScanner";

    private LocalMediaScanner() {
    }

    public final List<Movie> scanLocalMedia(Context context) {
        String str;
        long j;
        String str2;
        long j2;
        int i;
        int i2;
        long j3;
        Cursor cursor;
        int i3;
        long j4;
        String str3;
        Cursor cursor2;
        int i4;
        long j5;
        String str4 = "album_id";
        String str5 = TAG;
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        try {
            Cursor query = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name", TypedValues.TransitionType.S_DURATION, "_size"}, null, null, "date_added DESC");
            try {
                if (query != null) {
                    try {
                        Cursor cursor3 = query;
                        try {
                            Cursor cursor4 = cursor3;
                            int columnIndexOrThrow = cursor4.getColumnIndexOrThrow("_id");
                            j = 0;
                            int columnIndexOrThrow2 = cursor4.getColumnIndexOrThrow("_display_name");
                            int columnIndex = cursor4.getColumnIndex(TypedValues.TransitionType.S_DURATION);
                            int columnIndex2 = cursor4.getColumnIndex("_size");
                            while (cursor4.moveToNext()) {
                                String str6 = str4;
                                str = str5;
                                try {
                                    long j6 = cursor4.getLong(columnIndexOrThrow);
                                    String string = cursor4.getString(columnIndexOrThrow2);
                                    if (string == null) {
                                        string = "Unknown Video";
                                    }
                                    String str7 = string;
                                    Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j6);
                                    Intrinsics.checkNotNullExpressionValue(withAppendedId, "withAppendedId(...)");
                                    String uri = withAppendedId.toString();
                                    Intrinsics.checkNotNullExpressionValue(uri, "toString(...)");
                                    if (columnIndex >= 0) {
                                        str2 = uri;
                                        j2 = cursor4.getLong(columnIndex);
                                    } else {
                                        str2 = uri;
                                        j2 = 0;
                                    }
                                    if (columnIndex2 >= 0) {
                                        i = columnIndexOrThrow2;
                                        i2 = columnIndex;
                                        j3 = cursor4.getLong(columnIndex2);
                                    } else {
                                        i = columnIndexOrThrow2;
                                        i2 = columnIndex;
                                        j3 = 0;
                                    }
                                    StringBuilder sb = new StringBuilder();
                                    int i5 = columnIndex2;
                                    sb.append("🎬 Video");
                                    if (j2 > 0) {
                                        sb.append(" • " + INSTANCE.formatDuration(j2));
                                    }
                                    if (j3 > 0) {
                                        sb.append(" • " + INSTANCE.formatSize(j3));
                                    }
                                    arrayList.add(new Movie(j6, str7, null, str2, str2, withAppendedId.toString(), sb.toString(), "🎬 Video", null, null, null, null, null, null, null, 32516, null));
                                    str4 = str6;
                                    str5 = str;
                                    columnIndexOrThrow2 = i;
                                    columnIndex = i2;
                                    columnIndex2 = i5;
                                } catch (Throwable th) {
                                    th = th;
                                    Throwable th2 = th;
                                    try {
                                        throw th2;
                                    } catch (Throwable th3) {
                                        CloseableKt.closeFinally(cursor3, th2);
                                        throw th3;
                                    }
                                }
                            }
                            String str8 = str4;
                            str = str5;
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(cursor3, null);
                            str4 = str8;
                        } catch (Throwable th4) {
                            th = th4;
                            str = str5;
                        }
                    } catch (Exception e) {
                        e = e;
                        Log.e(str5, "Error scanning local media", e);
                        return arrayList;
                    }
                } else {
                    str = TAG;
                    j = 0;
                }
                Cursor query2 = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name", TypedValues.TransitionType.S_DURATION, "_size", str4}, null, null, "date_added DESC");
                if (query2 != null) {
                    cursor = query2;
                    try {
                        Cursor cursor5 = cursor;
                        int columnIndexOrThrow3 = cursor5.getColumnIndexOrThrow("_id");
                        int columnIndexOrThrow4 = cursor5.getColumnIndexOrThrow("_display_name");
                        int columnIndex3 = cursor5.getColumnIndex(TypedValues.TransitionType.S_DURATION);
                        int columnIndex4 = cursor5.getColumnIndex("_size");
                        int columnIndex5 = cursor5.getColumnIndex(str4);
                        while (cursor5.moveToNext()) {
                            long j7 = cursor5.getLong(columnIndexOrThrow3);
                            String string2 = cursor5.getString(columnIndexOrThrow4);
                            if (string2 == null) {
                                string2 = "Unknown Audio";
                            }
                            String str9 = string2;
                            Uri withAppendedId2 = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, j7);
                            Intrinsics.checkNotNullExpressionValue(withAppendedId2, "withAppendedId(...)");
                            if (columnIndex5 >= 0) {
                                j4 = j7;
                                i3 = columnIndex5;
                                str3 = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), cursor5.getLong(columnIndex5)).toString();
                            } else {
                                i3 = columnIndex5;
                                j4 = j7;
                                str3 = null;
                            }
                            long j8 = columnIndex3 >= 0 ? cursor5.getLong(columnIndex3) : j;
                            if (columnIndex4 >= 0) {
                                cursor2 = cursor5;
                                i4 = columnIndexOrThrow3;
                                j5 = cursor5.getLong(columnIndex4);
                            } else {
                                cursor2 = cursor5;
                                i4 = columnIndexOrThrow3;
                                j5 = j;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            int i6 = columnIndex3;
                            sb2.append("🎵 Audio");
                            if (j8 > j) {
                                sb2.append(" • " + INSTANCE.formatDuration(j8));
                            }
                            if (j5 > j) {
                                sb2.append(" • " + INSTANCE.formatSize(j5));
                            }
                            arrayList.add(new Movie(j4 + C.NANOS_PER_SECOND, str9, null, str3, str3, withAppendedId2.toString(), sb2.toString(), "🎵 Audio", null, null, null, null, null, null, null, 32516, null));
                            columnIndex5 = i3;
                            columnIndexOrThrow3 = i4;
                            cursor5 = cursor2;
                            columnIndex3 = i6;
                        }
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(cursor, null);
                    } finally {
                    }
                }
                Cursor query3 = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_display_name", "_size"}, null, null, "date_added DESC");
                if (query3 != null) {
                    cursor = query3;
                    try {
                        Cursor cursor6 = cursor;
                        int columnIndexOrThrow5 = cursor6.getColumnIndexOrThrow("_id");
                        int columnIndexOrThrow6 = cursor6.getColumnIndexOrThrow("_display_name");
                        int columnIndex6 = cursor6.getColumnIndex("_size");
                        while (cursor6.moveToNext()) {
                            long j9 = cursor6.getLong(columnIndexOrThrow5);
                            String string3 = cursor6.getString(columnIndexOrThrow6);
                            if (string3 == null) {
                                string3 = "Unknown Image";
                            }
                            String str10 = string3;
                            Uri withAppendedId3 = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j9);
                            Intrinsics.checkNotNullExpressionValue(withAppendedId3, "withAppendedId(...)");
                            long j10 = columnIndex6 >= 0 ? cursor6.getLong(columnIndex6) : j;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("🖼️ Image");
                            if (j10 > j) {
                                sb3.append(" • " + INSTANCE.formatSize(j10));
                            }
                            arrayList.add(new Movie(j9 + 2000000000, str10, null, withAppendedId3.toString(), withAppendedId3.toString(), withAppendedId3.toString(), sb3.toString(), "🖼️ Image", null, null, null, null, null, null, null, 32516, null));
                        }
                        Unit unit3 = Unit.INSTANCE;
                        CloseableKt.closeFinally(cursor, null);
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                str5 = str;
                Log.d(str5, "Scanned " + arrayList.size() + " local media files");
                return arrayList;
            } catch (Exception e2) {
                e = e2;
                str5 = str;
                Log.e(str5, "Error scanning local media", e);
                return arrayList;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private final String formatDuration(long ms) {
        long j = ms / 1000;
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        long j4 = j % 60;
        if (j2 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j3), Long.valueOf(j4)}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    private final String formatSize(long bytes) {
        if (bytes >= 1073741824) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(bytes / 1.073741824E9d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        if (bytes >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf(bytes / 1048576.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format("%.0f KB", Arrays.copyOf(new Object[]{Double.valueOf(bytes / 1024.0d)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        return format3;
    }
}
