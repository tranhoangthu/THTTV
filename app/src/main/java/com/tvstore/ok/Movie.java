package com.tvstore.ok;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.tvprovider.media.tv.TvContractCompat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Movie.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\bC\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 N2\u00020\u0001:\u0001NB¹\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\b\u00107\u001a\u00020\u0005H\u0016J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J»\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KHÖ\u0003J\t\u0010L\u001a\u00020MHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001c¨\u0006O"}, d2 = {"Lcom/tvstore/ok/Movie;", "Ljava/io/Serializable;", TtmlNode.ATTR_ID, "", TvContractCompat.ProgramColumns.COLUMN_TITLE, "", TvContractCompat.Channels.COLUMN_DESCRIPTION, "backgroundImageUrl", "cardImageUrl", "videoUrl", "studio", "category", "drmLicenseUrl", "clearKey", "drmType", "tvgId", "userAgent", "referrer", "manifestType", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "setId", "(J)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getBackgroundImageUrl", "setBackgroundImageUrl", "getCardImageUrl", "setCardImageUrl", "getVideoUrl", "setVideoUrl", "getStudio", "setStudio", "getCategory", "setCategory", "getDrmLicenseUrl", "setDrmLicenseUrl", "getClearKey", "setClearKey", "getDrmType", "setDrmType", "getTvgId", "setTvgId", "getUserAgent", "setUserAgent", "getReferrer", "setReferrer", "getManifestType", "setManifestType", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", "other", "", "hashCode", "", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final /* data */ class Movie implements Serializable {
    public static final long serialVersionUID = 727566175075960653L;
    private String backgroundImageUrl;
    private String cardImageUrl;
    private String category;
    private String clearKey;
    private String description;
    private String drmLicenseUrl;
    private String drmType;
    private long id;
    private String manifestType;
    private String referrer;
    private String studio;
    private String title;
    private String tvgId;
    private String userAgent;
    private String videoUrl;

    public Movie() {
        this(0L, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public static /* synthetic */ Movie copy$default(Movie movie, long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, Object obj) {
        long j2 = (i & 1) != 0 ? movie.id : j;
        return movie.copy(j2, (i & 2) != 0 ? movie.title : str, (i & 4) != 0 ? movie.description : str2, (i & 8) != 0 ? movie.backgroundImageUrl : str3, (i & 16) != 0 ? movie.cardImageUrl : str4, (i & 32) != 0 ? movie.videoUrl : str5, (i & 64) != 0 ? movie.studio : str6, (i & 128) != 0 ? movie.category : str7, (i & 256) != 0 ? movie.drmLicenseUrl : str8, (i & 512) != 0 ? movie.clearKey : str9, (i & 1024) != 0 ? movie.drmType : str10, (i & 2048) != 0 ? movie.tvgId : str11, (i & 4096) != 0 ? movie.userAgent : str12, (i & 8192) != 0 ? movie.referrer : str13, (i & 16384) != 0 ? movie.manifestType : str14);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getClearKey() {
        return this.clearKey;
    }

    /* renamed from: component11, reason: from getter */
    public final String getDrmType() {
        return this.drmType;
    }

    /* renamed from: component12, reason: from getter */
    public final String getTvgId() {
        return this.tvgId;
    }

    /* renamed from: component13, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    /* renamed from: component14, reason: from getter */
    public final String getReferrer() {
        return this.referrer;
    }

    /* renamed from: component15, reason: from getter */
    public final String getManifestType() {
        return this.manifestType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getBackgroundImageUrl() {
        return this.backgroundImageUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCardImageUrl() {
        return this.cardImageUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final String getStudio() {
        return this.studio;
    }

    /* renamed from: component8, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDrmLicenseUrl() {
        return this.drmLicenseUrl;
    }

    public final Movie copy(long id, String title, String description, String backgroundImageUrl, String cardImageUrl, String videoUrl, String studio, String category, String drmLicenseUrl, String clearKey, String drmType, String tvgId, String userAgent, String referrer, String manifestType) {
        return new Movie(id, title, description, backgroundImageUrl, cardImageUrl, videoUrl, studio, category, drmLicenseUrl, clearKey, drmType, tvgId, userAgent, referrer, manifestType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) other;
        return this.id == movie.id && Intrinsics.areEqual(this.title, movie.title) && Intrinsics.areEqual(this.description, movie.description) && Intrinsics.areEqual(this.backgroundImageUrl, movie.backgroundImageUrl) && Intrinsics.areEqual(this.cardImageUrl, movie.cardImageUrl) && Intrinsics.areEqual(this.videoUrl, movie.videoUrl) && Intrinsics.areEqual(this.studio, movie.studio) && Intrinsics.areEqual(this.category, movie.category) && Intrinsics.areEqual(this.drmLicenseUrl, movie.drmLicenseUrl) && Intrinsics.areEqual(this.clearKey, movie.clearKey) && Intrinsics.areEqual(this.drmType, movie.drmType) && Intrinsics.areEqual(this.tvgId, movie.tvgId) && Intrinsics.areEqual(this.userAgent, movie.userAgent) && Intrinsics.areEqual(this.referrer, movie.referrer) && Intrinsics.areEqual(this.manifestType, movie.manifestType);
    }

    public int hashCode() {
        int m = Movie$$ExternalSyntheticBackport0.m(this.id) * 31;
        String str = this.title;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundImageUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cardImageUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.videoUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.studio;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.category;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.drmLicenseUrl;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.clearKey;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.drmType;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.tvgId;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.userAgent;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.referrer;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.manifestType;
        return hashCode13 + (str14 != null ? str14.hashCode() : 0);
    }

    public Movie(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.id = j;
        this.title = str;
        this.description = str2;
        this.backgroundImageUrl = str3;
        this.cardImageUrl = str4;
        this.videoUrl = str5;
        this.studio = str6;
        this.category = str7;
        this.drmLicenseUrl = str8;
        this.clearKey = str9;
        this.drmType = str10;
        this.tvgId = str11;
        this.userAgent = str12;
        this.referrer = str13;
        this.manifestType = str14;
    }

    public /* synthetic */ Movie(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) != 0 ? null : str13, (i & 16384) != 0 ? null : str14);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
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

    public final String getBackgroundImageUrl() {
        return this.backgroundImageUrl;
    }

    public final void setBackgroundImageUrl(String str) {
        this.backgroundImageUrl = str;
    }

    public final String getCardImageUrl() {
        return this.cardImageUrl;
    }

    public final void setCardImageUrl(String str) {
        this.cardImageUrl = str;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public final String getStudio() {
        return this.studio;
    }

    public final void setStudio(String str) {
        this.studio = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getDrmLicenseUrl() {
        return this.drmLicenseUrl;
    }

    public final void setDrmLicenseUrl(String str) {
        this.drmLicenseUrl = str;
    }

    public final String getClearKey() {
        return this.clearKey;
    }

    public final void setClearKey(String str) {
        this.clearKey = str;
    }

    public final String getDrmType() {
        return this.drmType;
    }

    public final void setDrmType(String str) {
        this.drmType = str;
    }

    public final String getTvgId() {
        return this.tvgId;
    }

    public final void setTvgId(String str) {
        this.tvgId = str;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public final void setUserAgent(String str) {
        this.userAgent = str;
    }

    public final String getReferrer() {
        return this.referrer;
    }

    public final void setReferrer(String str) {
        this.referrer = str;
    }

    public final String getManifestType() {
        return this.manifestType;
    }

    public final void setManifestType(String str) {
        this.manifestType = str;
    }

    public String toString() {
        return "Movie{id=" + this.id + ", title='" + this.title + "', videoUrl='" + this.videoUrl + "', backgroundImageUrl='" + this.backgroundImageUrl + "', cardImageUrl='" + this.cardImageUrl + "'}";
    }
}
