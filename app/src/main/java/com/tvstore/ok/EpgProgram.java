package com.tvstore.ok;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.tvprovider.media.tv.TvContractCompat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: EpgData.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0017HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\f¨\u0006\""}, d2 = {"Lcom/tvstore/ok/EpgProgram;", "", TvContractCompat.ProgramColumns.COLUMN_TITLE, "", "startTime", "Ljava/util/Date;", "stopTime", TvContractCompat.Channels.COLUMN_DESCRIPTION, "channelId", "<init>", "(Ljava/lang/String;Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getStartTime", "()Ljava/util/Date;", "getStopTime", "getDescription", "getChannelId", "fullTitle", "getFullTitle", "isCurrent", "", "getProgress", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final /* data */ class EpgProgram {
    private final String channelId;
    private final String description;
    private final Date startTime;
    private final Date stopTime;
    private final String title;

    public static /* synthetic */ EpgProgram copy$default(EpgProgram epgProgram, String str, Date date, Date date2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = epgProgram.title;
        }
        if ((i & 2) != 0) {
            date = epgProgram.startTime;
        }
        if ((i & 4) != 0) {
            date2 = epgProgram.stopTime;
        }
        if ((i & 8) != 0) {
            str2 = epgProgram.description;
        }
        if ((i & 16) != 0) {
            str3 = epgProgram.channelId;
        }
        String str4 = str3;
        Date date3 = date2;
        return epgProgram.copy(str, date, date3, str2, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final Date getStartTime() {
        return this.startTime;
    }

    /* renamed from: component3, reason: from getter */
    public final Date getStopTime() {
        return this.stopTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    public final EpgProgram copy(String title, Date startTime, Date stopTime, String description, String channelId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(stopTime, "stopTime");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        return new EpgProgram(title, startTime, stopTime, description, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EpgProgram)) {
            return false;
        }
        EpgProgram epgProgram = (EpgProgram) other;
        return Intrinsics.areEqual(this.title, epgProgram.title) && Intrinsics.areEqual(this.startTime, epgProgram.startTime) && Intrinsics.areEqual(this.stopTime, epgProgram.stopTime) && Intrinsics.areEqual(this.description, epgProgram.description) && Intrinsics.areEqual(this.channelId, epgProgram.channelId);
    }

    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.startTime.hashCode()) * 31) + this.stopTime.hashCode()) * 31;
        String str = this.description;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.channelId.hashCode();
    }

    public String toString() {
        return "EpgProgram(title=" + this.title + ", startTime=" + this.startTime + ", stopTime=" + this.stopTime + ", description=" + this.description + ", channelId=" + this.channelId + ")";
    }

    public EpgProgram(String title, Date startTime, Date stopTime, String str, String channelId) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(stopTime, "stopTime");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        this.title = title;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.description = str;
        this.channelId = channelId;
    }

    public /* synthetic */ EpgProgram(String str, Date date, Date date2, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, date, date2, (i & 8) != 0 ? null : str2, str3);
    }

    public final String getTitle() {
        return this.title;
    }

    public final Date getStartTime() {
        return this.startTime;
    }

    public final Date getStopTime() {
        return this.stopTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getFullTitle() {
        String str = this.description;
        if (str == null || StringsKt.isBlank(str) || Intrinsics.areEqual(this.description, this.title)) {
            return this.title;
        }
        return this.title + ": " + this.description;
    }

    public final boolean isCurrent() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        Calendar calendar = Calendar.getInstance(timeZone);
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(this.startTime);
        Calendar calendar3 = Calendar.getInstance(timeZone);
        calendar3.setTime(this.stopTime);
        int i = (calendar.get(11) * 60) + calendar.get(12);
        int i2 = (calendar2.get(11) * 60) + calendar2.get(12);
        int i3 = (calendar3.get(11) * 60) + calendar3.get(12);
        if (i3 <= i2) {
            i3 += 1440;
        }
        if (i < i2 && i3 > 1440) {
            i += 1440;
        }
        return i >= i2 && i < i3;
    }

    public final int getProgress() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+7");
        Calendar calendar = Calendar.getInstance(timeZone);
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTime(this.startTime);
        Calendar calendar3 = Calendar.getInstance(timeZone);
        calendar3.setTime(this.stopTime);
        int i = (calendar.get(11) * 3600) + (calendar.get(12) * 60) + calendar.get(13);
        int i2 = (calendar2.get(11) * 3600) + (calendar2.get(12) * 60) + calendar2.get(13);
        int i3 = (calendar3.get(11) * 3600) + (calendar3.get(12) * 60) + calendar3.get(13);
        if (i3 <= i2) {
            i3 += 86400;
        }
        if (i < i2 && i3 > 86400) {
            i += 86400;
        }
        int i4 = i3 - i2;
        if (i4 <= 0) {
            return 0;
        }
        return RangesKt.coerceIn((int) (((i - i2) / i4) * 100.0f), 0, 100);
    }
}
