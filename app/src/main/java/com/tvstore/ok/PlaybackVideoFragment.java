package com.tvstore.ok;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.exoplayer.drm.LocalMediaDrmCallback;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.media3.ui.PlayerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: PlaybackVideoFragment.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\b\u0007\u0018\u0000 T2\u00020\u0001:\u0002TUB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0014\u0010,\u001a\u0004\u0018\u00010\"2\b\u0010+\u001a\u0004\u0018\u00010\"H\u0002J(\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020 2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J \u00104\u001a\u00020*2\u0006\u00105\u001a\u00020 2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\u0006\u00106\u001a\u00020 J\u000e\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020\u0019J\u0006\u00109\u001a\u00020*J\u0006\u0010:\u001a\u00020;J\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020*J\b\u0010>\u001a\u00020*H\u0002J\u0006\u0010?\u001a\u00020*J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020AJ\u0006\u0010C\u001a\u00020;J\u0006\u0010D\u001a\u00020;J\u000e\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020AJ\u000e\u0010G\u001a\u00020*2\u0006\u0010H\u001a\u00020AJ\u0006\u0010I\u001a\u00020\u0019J\u0006\u0010J\u001a\u00020\u0019J\u0006\u0010K\u001a\u00020 J\u0012\u0010L\u001a\u0004\u0018\u00010 2\u0006\u0010M\u001a\u00020 H\u0002J\u0012\u0010N\u001a\u0004\u0018\u00010 2\u0006\u0010O\u001a\u00020 H\u0002J\b\u0010P\u001a\u00020*H\u0016J\b\u0010Q\u001a\u00020*H\u0016J\b\u0010R\u001a\u00020*H\u0016J\b\u0010S\u001a\u00020*H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/tvstore/ok/PlaybackVideoFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "getExoPlayer$app", "()Landroidx/media3/exoplayer/ExoPlayer;", "setExoPlayer$app", "(Landroidx/media3/exoplayer/ExoPlayer;)V", "playerView", "Landroidx/media3/ui/PlayerView;", "playerAdapter", "Lcom/tvstore/ok/ExoPlayerAdapter;", "loadingSpinner", "Landroid/widget/ProgressBar;", "errorText", "Landroid/widget/TextView;", "localImageView", "Landroid/widget/ImageView;", "zoomDialog", "Landroid/app/Dialog;", "qualityDialog", "Landroid/app/AlertDialog;", "currentModeIndex", "", "getCurrentModeIndex$app", "()I", "setCurrentModeIndex$app", "(I)V", "modeNames", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "findSurfaceView", "fetchAndApplyClearKey", ImagesContract.URL, "userAgent", "mediaSourceFactory", "Landroidx/media3/exoplayer/source/DefaultMediaSourceFactory;", "mediaItemBuilder", "Landroidx/media3/common/MediaItem$Builder;", "applyClearKey", "keyInfo", "cycleScalingMode", "applyPresetAspectMode", "index", "setResizeModeFit", "isDialogShowing", "", "onBackPressed", "showQualitySelector", "showZoomDialog", "togglePlayPause", "getPosition", "", "getDuration", "isPlaying", "isLiveStream", "seekTo", TtmlNode.TAG_P, "seekRelative", "o", "getVideoWidth", "getVideoHeight", "getCurrentFormatInfo", "buildClearKeyJson", "c", "hexToBase64Url", CmcdData.Factory.STREAMING_FORMAT_HLS, "onPause", "onResume", "onStop", "onDestroyView", "Companion", "QualityOption", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class PlaybackVideoFragment extends Fragment {
    private static final UUID CLEARKEY_UUID;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PlaybackVideoFragment";
    private static final UUID WIDEVINE_UUID;
    private int currentModeIndex;
    private TextView errorText;
    private ExoPlayer exoPlayer;
    private ProgressBar loadingSpinner;
    private ImageView localImageView;
    private final List<String> modeNames = CollectionsKt.listOf((Object[]) new String[]{"Chuẩn", "Phóng to", "Kéo giãn"});
    private ExoPlayerAdapter playerAdapter;
    private PlayerView playerView;
    private AlertDialog qualityDialog;
    private Dialog zoomDialog;

    /* renamed from: getExoPlayer$app, reason: from getter */
    public final ExoPlayer getExoPlayer() {
        return this.exoPlayer;
    }

    public final void setExoPlayer$app(ExoPlayer exoPlayer) {
        this.exoPlayer = exoPlayer;
    }

    /* renamed from: getCurrentModeIndex$app, reason: from getter */
    public final int getCurrentModeIndex() {
        return this.currentModeIndex;
    }

    public final void setCurrentModeIndex$app(int i) {
        this.currentModeIndex = i;
    }

    /* compiled from: PlaybackVideoFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/tvstore/ok/PlaybackVideoFragment$Companion;", "", "<init>", "()V", "TAG", "", "WIDEVINE_UUID", "Ljava/util/UUID;", "getWIDEVINE_UUID", "()Ljava/util/UUID;", "CLEARKEY_UUID", "getCLEARKEY_UUID", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UUID getWIDEVINE_UUID() {
            return PlaybackVideoFragment.WIDEVINE_UUID;
        }

        public final UUID getCLEARKEY_UUID() {
            return PlaybackVideoFragment.CLEARKEY_UUID;
        }
    }

    static {
        UUID fromString = UUID.fromString("edef8ba9-79d6-4ace-a3c8-27dcd51d21ed");
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(...)");
        WIDEVINE_UUID = fromString;
        UUID CLEARKEY_UUID2 = C.CLEARKEY_UUID;
        Intrinsics.checkNotNullExpressionValue(CLEARKEY_UUID2, "CLEARKEY_UUID");
        CLEARKEY_UUID = CLEARKEY_UUID2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_playback_video, container, false);
        this.playerView = (PlayerView) inflate.findViewById(R.id.player_view);
        this.loadingSpinner = (ProgressBar) inflate.findViewById(R.id.loading_spinner);
        this.errorText = (TextView) inflate.findViewById(R.id.error_text);
        this.localImageView = (ImageView) inflate.findViewById(R.id.local_image_view);
        Intrinsics.checkNotNull(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String videoUrl;
        String category;
        ExoPlayer exoPlayer;
        String drmLicenseUrl;
        String clearKey;
        String stringExtra;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Serializable serializableExtra = activity.getIntent().getSerializableExtra(DetailsActivity.MOVIE);
        Movie movie = serializableExtra instanceof Movie ? (Movie) serializableExtra : null;
        if (movie == null && (stringExtra = activity.getIntent().getStringExtra("movie_url")) != null) {
            movie = new Movie(activity.getIntent().getLongExtra("movie_id", 0L), activity.getIntent().getStringExtra("movie_title"), null, null, null, stringExtra, null, activity.getIntent().getStringExtra("movie_category"), activity.getIntent().getStringExtra("movie_drm_url"), activity.getIntent().getStringExtra("movie_clearkey"), activity.getIntent().getStringExtra("movie_drm_type"), null, activity.getIntent().getStringExtra("movie_ua"), activity.getIntent().getStringExtra("movie_referrer"), null, 18524, null);
        }
        if (movie == null || (videoUrl = movie.getVideoUrl()) == null) {
            return;
        }
        String obj = StreamFailoverManager.getCurrentStreamUrl(StringsKt.trim((CharSequence) videoUrl).toString());
        String category2 = movie.getCategory();
        if ((category2 != null && StringsKt.contains$default((CharSequence) category2, (CharSequence) "Image", false, 2, (Object) null)) || ((category = movie.getCategory()) != null && StringsKt.contains$default((CharSequence) category, (CharSequence) "🖼️", false, 2, (Object) null))) {
            ImageView imageView = this.localImageView;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            PlayerView playerView = this.playerView;
            if (playerView != null) {
                playerView.setVisibility(8);
            }
            ProgressBar progressBar = this.loadingSpinner;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            try {
                RequestBuilder<Drawable> load = Glide.with(this).load(Uri.parse(obj));
                ImageView imageView2 = this.localImageView;
                Intrinsics.checkNotNull(imageView2);
                Intrinsics.checkNotNull(load.into(imageView2));
            } catch (Exception unused) {
            }
            FragmentActivity activity2 = getActivity();
            PlaybackActivity playbackActivity = activity2 instanceof PlaybackActivity ? (PlaybackActivity) activity2 : null;
            if (playbackActivity != null) {
                playbackActivity.updatePlayPauseUI(false);
                return;
            }
            return;
        }
        final String userAgent = movie.getUserAgent();
        if (userAgent == null) {
            userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36";
        }
        final String referrer = movie.getReferrer();
        if (referrer == null) {
            referrer = "/";
        }
        OkHttpDataSource.Factory defaultRequestProperties = new OkHttpDataSource.Factory(NetworkUtils.INSTANCE.getOkHttpClient().newBuilder().addInterceptor(new Interceptor() { // from class: com.tvstore.ok.PlaybackVideoFragment$onViewCreated$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                Request.Builder header = chain.request().newBuilder().header(HttpHeaders.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36").header(HttpHeaders.REFERER, referrer);
                return chain.proceed((chain.request().url().getUrl().contains("fpt") ? header.header(HttpHeaders.ORIGIN, "https://fptplay53.net") : header.header(HttpHeaders.ORIGIN, "https://tv360.vn")).build());
            }
        }).build()).setUserAgent(userAgent).setDefaultRequestProperties(MapsKt.mapOf(TuplesKt.to(HttpHeaders.REFERER, referrer), TuplesKt.to(HttpHeaders.ORIGIN, "")));
        Intrinsics.checkNotNullExpressionValue(defaultRequestProperties, "setDefaultRequestProperties(...)");
        DefaultMediaSourceFactory dataSourceFactory = new DefaultMediaSourceFactory(requireContext()).setDataSourceFactory(new DefaultDataSource.Factory(requireContext(), defaultRequestProperties));
        Intrinsics.checkNotNullExpressionValue(dataSourceFactory, "setDataSourceFactory(...)");
        MediaItem.Builder uri = new MediaItem.Builder().setUri(Uri.parse(obj));
        Intrinsics.checkNotNullExpressionValue(uri, "setUri(...)");
        String lowerCase = obj.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String manifestType = movie.getManifestType();
        if (manifestType == null || !StringsKt.contains((CharSequence) manifestType, (CharSequence) "mpd", true)) {
            String manifestType2 = movie.getManifestType();
            if (manifestType2 == null || !StringsKt.contains((CharSequence) manifestType2, (CharSequence) "hls", true)) {
                String str = lowerCase;
                if (StringsKt.contains$default((CharSequence) str, (CharSequence) ".m3u8", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "playlist", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) ".php", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "/vtvgo/", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str, (CharSequence) "hoiquan.dpdns.org", false, 2, (Object) null)) {
                    uri.setMimeType(MimeTypes.APPLICATION_M3U8);
                } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) ".mpd", false, 2, (Object) null)) {
                    uri.setMimeType(MimeTypes.APPLICATION_MPD);
                }
            } else {
                uri.setMimeType(MimeTypes.APPLICATION_M3U8);
            }
        } else {
            uri.setMimeType(MimeTypes.APPLICATION_MPD);
        }
        String clearKey2 = movie.getClearKey();
        if (clearKey2 != null && clearKey2.length() != 0) {
            String clearKey3 = movie.getClearKey();
            Intrinsics.checkNotNull(clearKey3);
            applyClearKey(clearKey3, dataSourceFactory, uri);
        } else {
            String drmLicenseUrl2 = movie.getDrmLicenseUrl();
            if (drmLicenseUrl2 != null && drmLicenseUrl2.length() != 0) {
                if (Intrinsics.areEqual(movie.getDrmType(), "clearkey")) {
                    String userAgent2 = movie.getUserAgent();
                    if (userAgent2 == null) {
                        userAgent2 = "Dalvik/2.1.0 (Linux; U; Android 13)";
                    }
                    String drmLicenseUrl3 = movie.getDrmLicenseUrl();
                    Intrinsics.checkNotNull(drmLicenseUrl3);
                    fetchAndApplyClearKey(drmLicenseUrl3, userAgent2, dataSourceFactory, uri);
                } else {
                    Intrinsics.checkNotNull(uri.setDrmConfiguration(new MediaItem.DrmConfiguration.Builder(Intrinsics.areEqual(movie.getDrmType(), "widevine") ? WIDEVINE_UUID : CLEARKEY_UUID).setLicenseUri(movie.getDrmLicenseUrl()).build()));
                }
            }
        }
        ExoPlayer build = new ExoPlayer.Builder(requireContext()).setRenderersFactory(new DefaultRenderersFactory(requireContext()).setEnableDecoderFallback(true)).setMediaSourceFactory(dataSourceFactory).build();
        this.exoPlayer = build;
        PlayerView playerView2 = this.playerView;
        if (playerView2 != null) {
            playerView2.setPlayer(build);
        }
        ExoPlayer exoPlayer2 = this.exoPlayer;
        Intrinsics.checkNotNull(exoPlayer2);
        ExoPlayerAdapter exoPlayerAdapter = new ExoPlayerAdapter(exoPlayer2);
        this.playerAdapter = exoPlayerAdapter;
        exoPlayerAdapter.setSurfaceView(findSurfaceView(this.playerView));
        ExoPlayer exoPlayer3 = this.exoPlayer;
        if (exoPlayer3 != null) {
            exoPlayer3.setMediaItem(uri.build());
        }
        ExoPlayer exoPlayer4 = this.exoPlayer;
        if (exoPlayer4 != null) {
            exoPlayer4.setPlayWhenReady(true);
        }
        ExoPlayer exoPlayer5 = this.exoPlayer;
        if (exoPlayer5 != null) {
            exoPlayer5.addListener(new Player.Listener() { // from class: com.tvstore.ok.PlaybackVideoFragment$onViewCreated$1
                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                    Player.Listener.CC.$default$onAudioAttributesChanged(this, audioAttributes);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onAudioSessionIdChanged(int i) {
                    Player.Listener.CC.$default$onAudioSessionIdChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                    Player.Listener.CC.$default$onAvailableCommandsChanged(this, commands);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onCues(CueGroup cueGroup) {
                    Player.Listener.CC.$default$onCues(this, cueGroup);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onCues(List list) {
                    Player.Listener.CC.$default$onCues(this, list);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                    Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                    Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onEvents(Player player, Player.Events events) {
                    Player.Listener.CC.$default$onEvents(this, player, events);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onIsLoadingChanged(boolean z) {
                    Player.Listener.CC.$default$onIsLoadingChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onLoadingChanged(boolean z) {
                    Player.Listener.CC.$default$onLoadingChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                    Player.Listener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                    Player.Listener.CC.$default$onMediaItemTransition(this, mediaItem, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                    Player.Listener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onMetadata(androidx.media3.common.Metadata metadata) {
                    Player.Listener.CC.$default$onMetadata(this, metadata);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                    Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                    Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                    Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                    Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
                    Player.Listener.CC.$default$onPlayerStateChanged(this, z, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                    Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPositionDiscontinuity(int i) {
                    Player.Listener.CC.$default$onPositionDiscontinuity(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
                    Player.Listener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onRenderedFirstFrame() {
                    Player.Listener.CC.$default$onRenderedFirstFrame(this);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onRepeatModeChanged(int i) {
                    Player.Listener.CC.$default$onRepeatModeChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                    Player.Listener.CC.$default$onSeekBackIncrementChanged(this, j);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                    Player.Listener.CC.$default$onSeekForwardIncrementChanged(this, j);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                    Player.Listener.CC.$default$onShuffleModeEnabledChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                    Player.Listener.CC.$default$onSkipSilenceEnabledChanged(this, z);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                    Player.Listener.CC.$default$onSurfaceSizeChanged(this, i, i2);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                    Player.Listener.CC.$default$onTimelineChanged(this, timeline, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                    Player.Listener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onTracksChanged(Tracks tracks) {
                    Player.Listener.CC.$default$onTracksChanged(this, tracks);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                    Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onVolumeChanged(float f) {
                    Player.Listener.CC.$default$onVolumeChanged(this, f);
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlaybackStateChanged(int state) {
                    PlaybackActivity playbackActivity2;
                    ProgressBar progressBar2;
                    TextView textView;
                    ProgressBar progressBar3;
                    TextView textView2;
                    ProgressBar progressBar4;
                    boolean z = false;
                    if (state == 1) {
                        FragmentActivity activity3 = PlaybackVideoFragment.this.getActivity();
                        playbackActivity2 = activity3 instanceof PlaybackActivity ? (PlaybackActivity) activity3 : null;
                        if (playbackActivity2 != null) {
                            playbackActivity2.setAudioOverlayPlaybackState(false);
                            return;
                        }
                        return;
                    }
                    if (state == 2) {
                        progressBar2 = PlaybackVideoFragment.this.loadingSpinner;
                        if (progressBar2 != null) {
                            progressBar2.setVisibility(0);
                        }
                        textView = PlaybackVideoFragment.this.errorText;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                        FragmentActivity activity4 = PlaybackVideoFragment.this.getActivity();
                        playbackActivity2 = activity4 instanceof PlaybackActivity ? (PlaybackActivity) activity4 : null;
                        if (playbackActivity2 != null) {
                            playbackActivity2.setAudioOverlayPlaybackState(false);
                            return;
                        }
                        return;
                    }
                    if (state != 3) {
                        if (state != 4) {
                            return;
                        }
                        progressBar4 = PlaybackVideoFragment.this.loadingSpinner;
                        if (progressBar4 != null) {
                            progressBar4.setVisibility(8);
                        }
                        FragmentActivity activity5 = PlaybackVideoFragment.this.getActivity();
                        playbackActivity2 = activity5 instanceof PlaybackActivity ? (PlaybackActivity) activity5 : null;
                        if (playbackActivity2 != null) {
                            playbackActivity2.setAudioOverlayPlaybackState(false);
                            return;
                        }
                        return;
                    }
                    progressBar3 = PlaybackVideoFragment.this.loadingSpinner;
                    if (progressBar3 != null) {
                        progressBar3.setVisibility(8);
                    }
                    textView2 = PlaybackVideoFragment.this.errorText;
                    if (textView2 != null) {
                        textView2.setVisibility(8);
                    }
                    FragmentActivity activity6 = PlaybackVideoFragment.this.getActivity();
                    playbackActivity2 = activity6 instanceof PlaybackActivity ? (PlaybackActivity) activity6 : null;
                    if (playbackActivity2 != null) {
                        ExoPlayer exoPlayer6 = PlaybackVideoFragment.this.getExoPlayer();
                        if (exoPlayer6 != null && exoPlayer6.getPlayWhenReady()) {
                            z = true;
                        }
                        playbackActivity2.setAudioOverlayPlaybackState(z);
                    }
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlayerError(PlaybackException error) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    if (StreamFailoverManager.tryNextServer(PlaybackVideoFragment.this.getContext(), PlaybackVideoFragment.this.getExoPlayer())) {
                        return;
                    }
                    ProgressBar progressBar2;
                    progressBar2 = PlaybackVideoFragment.this.loadingSpinner;
                    if (progressBar2 != null) {
                        progressBar2.setVisibility(8);
                    }
                    FragmentActivity activity3 = PlaybackVideoFragment.this.getActivity();
                    PlaybackActivity playbackActivity2 = activity3 instanceof PlaybackActivity ? (PlaybackActivity) activity3 : null;
                    if (playbackActivity2 != null) {
                        playbackActivity2.setAudioOverlayPlaybackState(false);
                    }
                    int i = error.errorCode;
                    if (i == 2001) {
                        str2 = "Lỗi kết nối mạng.";
                    } else if (i == 2004) {
                        str2 = "Lỗi server (403/404). Vui lòng thử lại sau.";
                    } else {
                        String localizedMessage = error.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "Không xác định";
                        }
                        str2 = "Lỗi phát: " + localizedMessage;
                    }
                    textView = PlaybackVideoFragment.this.errorText;
                    if (textView != null) {
                        textView.setText("⚠️ " + str2);
                    }
                    textView2 = PlaybackVideoFragment.this.errorText;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                }

                @Override // androidx.media3.common.Player.Listener
                public void onIsPlayingChanged(boolean isPlaying) {
                    ProgressBar progressBar2;
                    TextView textView;
                    if (isPlaying) {
                        progressBar2 = PlaybackVideoFragment.this.loadingSpinner;
                        if (progressBar2 != null) {
                            progressBar2.setVisibility(8);
                        }
                        textView = PlaybackVideoFragment.this.errorText;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                    }
                    FragmentActivity activity3 = PlaybackVideoFragment.this.getActivity();
                    PlaybackActivity playbackActivity2 = activity3 instanceof PlaybackActivity ? (PlaybackActivity) activity3 : null;
                    if (playbackActivity2 != null) {
                        playbackActivity2.setAudioOverlayPlaybackState(isPlaying);
                    }
                    FragmentActivity activity4 = PlaybackVideoFragment.this.getActivity();
                    PlaybackActivity playbackActivity3 = activity4 instanceof PlaybackActivity ? (PlaybackActivity) activity4 : null;
                    if (playbackActivity3 != null) {
                        playbackActivity3.updatePlayPauseUI(isPlaying);
                    }
                }
            });
        }
        if ((!Intrinsics.areEqual(movie.getDrmType(), "clearkey") || (drmLicenseUrl = movie.getDrmLicenseUrl()) == null || drmLicenseUrl.length() == 0 || !((clearKey = movie.getClearKey()) == null || clearKey.length() == 0)) && (exoPlayer = this.exoPlayer) != null) {
            exoPlayer.prepare();
        }
    }

    private final View findSurfaceView(View view) {
        if (view instanceof SurfaceView) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View findSurfaceView = findSurfaceView(viewGroup.getChildAt(i));
            if (findSurfaceView != null) {
                return findSurfaceView;
            }
        }
        return null;
    }

    private final void fetchAndApplyClearKey(String url, String userAgent, final DefaultMediaSourceFactory mediaSourceFactory, final MediaItem.Builder mediaItemBuilder) {
        final OkHttpClient okHttpClient = NetworkUtils.INSTANCE.getOkHttpClient();
        final Request build = new Request.Builder().url(url).header(HttpHeaders.USER_AGENT, userAgent).build();
        new Thread(new Runnable() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackVideoFragment.fetchAndApplyClearKey$lambda$3(OkHttpClient.this, build, this, mediaSourceFactory, mediaItemBuilder);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void fetchAndApplyClearKey$lambda$3(OkHttpClient okHttpClient, Request request, final PlaybackVideoFragment playbackVideoFragment, final DefaultMediaSourceFactory defaultMediaSourceFactory, final MediaItem.Builder builder) {
        FragmentActivity activity;
        try {
            Response execute = okHttpClient.newCall(request).execute();
            try {
                Response response = execute;
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    final String string = body != null ? body.string() : null;
                    String str = string;
                    if (str != null && str.length() != 0 && (activity = playbackVideoFragment.getActivity()) != null) {
                        activity.runOnUiThread(new Runnable() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda2
                            @Override // java.lang.Runnable
                            public final void run() {
                                PlaybackVideoFragment.fetchAndApplyClearKey$lambda$3$lambda$2$lambda$1(PlaybackVideoFragment.this, string, defaultMediaSourceFactory, builder);
                            }
                        });
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(execute, null);
            } finally {
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void fetchAndApplyClearKey$lambda$3$lambda$2$lambda$1(PlaybackVideoFragment playbackVideoFragment, String str, DefaultMediaSourceFactory defaultMediaSourceFactory, MediaItem.Builder builder) {
        playbackVideoFragment.applyClearKey(str, defaultMediaSourceFactory, builder);
        ExoPlayer exoPlayer = playbackVideoFragment.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.setMediaItem(builder.build());
        }
        ExoPlayer exoPlayer2 = playbackVideoFragment.exoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.prepare();
        }
    }

    private final void applyClearKey(String keyInfo, DefaultMediaSourceFactory mediaSourceFactory, MediaItem.Builder mediaItemBuilder) {
        String buildClearKeyJson = buildClearKeyJson(keyInfo);
        if (buildClearKeyJson != null) {
            try {
                byte[] bytes = buildClearKeyJson.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                LocalMediaDrmCallback localMediaDrmCallback = new LocalMediaDrmCallback(bytes);
                DefaultDrmSessionManager.Builder builder = new DefaultDrmSessionManager.Builder();
                UUID uuid = CLEARKEY_UUID;
                final DefaultDrmSessionManager build = builder.setUuidAndExoMediaDrmProvider(uuid, FrameworkMediaDrm.DEFAULT_PROVIDER).setMultiSession(true).build(localMediaDrmCallback);
                Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                mediaSourceFactory.setDrmSessionManagerProvider(new DrmSessionManagerProvider() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda4
                    @Override // androidx.media3.exoplayer.drm.DrmSessionManagerProvider
                    public final DrmSessionManager get(MediaItem mediaItem) {
                        return PlaybackVideoFragment.applyClearKey$lambda$5$lambda$4(DefaultDrmSessionManager.this, mediaItem);
                    }
                });
                Intrinsics.checkNotNull(mediaItemBuilder.setDrmConfiguration(new MediaItem.DrmConfiguration.Builder(uuid).build()));
            } catch (Exception unused) {
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final DrmSessionManager applyClearKey$lambda$5$lambda$4(DefaultDrmSessionManager defaultDrmSessionManager, MediaItem it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return defaultDrmSessionManager;
    }

    public final String cycleScalingMode() {
        this.currentModeIndex = (this.currentModeIndex + 1) % this.modeNames.size();
        FragmentActivity activity = getActivity();
        PlaybackActivity playbackActivity = activity instanceof PlaybackActivity ? (PlaybackActivity) activity : null;
        if (playbackActivity != null) {
            playbackActivity.applyPresetAspectMode(this.currentModeIndex);
        }
        return this.modeNames.get(this.currentModeIndex);
    }

    public final void applyPresetAspectMode(int index) {
        this.currentModeIndex = index;
        FragmentActivity activity = getActivity();
        PlaybackActivity playbackActivity = activity instanceof PlaybackActivity ? (PlaybackActivity) activity : null;
        if (playbackActivity != null) {
            playbackActivity.applyPresetAspectMode(index);
        }
    }

    public final void setResizeModeFit() {
        ExoPlayerAdapter exoPlayerAdapter = this.playerAdapter;
        if (exoPlayerAdapter != null) {
            exoPlayerAdapter.setPresetAspectMode(0);
        }
    }

    public final boolean isDialogShowing() {
        AlertDialog alertDialog;
        Dialog dialog = this.zoomDialog;
        return (dialog != null && dialog.isShowing()) || ((alertDialog = this.qualityDialog) != null && alertDialog.isShowing());
    }

    public final boolean onBackPressed() {
        Dialog dialog = this.zoomDialog;
        if (dialog != null && dialog.isShowing()) {
            Dialog dialog2 = this.zoomDialog;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            return true;
        }
        AlertDialog alertDialog = this.qualityDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return false;
        }
        AlertDialog alertDialog2 = this.qualityDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01b3, code lost:
    
        if (r6.getTrackGroup() == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01df, code lost:
    
        if (r8 == true) goto L69;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void showQualitySelector() {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.PlaybackVideoFragment.showQualitySelector():void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showQualitySelector$lambda$13(List list, PlaybackVideoFragment playbackVideoFragment, ExoPlayer exoPlayer, DialogInterface dialogInterface, int i) {
        QualityOption qualityOption = (QualityOption) list.get(i);
        if (qualityOption.isManualZoom()) {
            playbackVideoFragment.showZoomDialog();
            return;
        }
        if (qualityOption.isResizeMode()) {
            playbackVideoFragment.applyPresetAspectMode(qualityOption.getResizeModeIndex());
            return;
        }
        TrackSelectionParameters.Builder buildUpon = exoPlayer.getTrackSelectionParameters().buildUpon();
        Intrinsics.checkNotNullExpressionValue(buildUpon, "buildUpon(...)");
        if (qualityOption.getTrackGroup() == null) {
            exoPlayer.setTrackSelectionParameters(buildUpon.clearVideoSizeConstraints().clearOverridesOfType(2).build());
            Toast.makeText(playbackVideoFragment.requireContext(), "Độ phân giải: Tự động", 0).show();
            return;
        }
        TrackSelectionParameters.Builder clearOverridesOfType = buildUpon.clearVideoSizeConstraints().clearOverridesOfType(2);
        TrackGroup trackGroup = qualityOption.getTrackGroup();
        Integer trackIndex = qualityOption.getTrackIndex();
        Intrinsics.checkNotNull(trackIndex);
        exoPlayer.setTrackSelectionParameters(clearOverridesOfType.addOverride(new TrackSelectionOverride(trackGroup, (List<Integer>) CollectionsKt.listOf(trackIndex))).build());
        Toast.makeText(playbackVideoFragment.requireContext(), "Độ phân giải: " + qualityOption.getLabel(), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlaybackVideoFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\b\u0082\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\"\u001a\u00020\tHÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003Jb\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0007HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0017R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0019\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0017\"\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/tvstore/ok/PlaybackVideoFragment$QualityOption;", "", "label", "", "trackGroup", "Landroidx/media3/common/TrackGroup;", "trackIndex", "", "isResizeMode", "", "resizeModeIndex", "isManualZoom", "iconRes", "isSelected", "<init>", "(Ljava/lang/String;Landroidx/media3/common/TrackGroup;Ljava/lang/Integer;ZIZIZ)V", "getLabel", "()Ljava/lang/String;", "getTrackGroup", "()Landroidx/media3/common/TrackGroup;", "getTrackIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Z", "getResizeModeIndex", "()I", "getIconRes", "setIconRes", "(I)V", "setSelected", "(Z)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Landroidx/media3/common/TrackGroup;Ljava/lang/Integer;ZIZIZ)Lcom/tvstore/ok/PlaybackVideoFragment$QualityOption;", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final /* data */ class QualityOption {
        private int iconRes;
        private final boolean isManualZoom;
        private final boolean isResizeMode;
        private boolean isSelected;
        private final String label;
        private final int resizeModeIndex;
        private final TrackGroup trackGroup;
        private final Integer trackIndex;

        public static /* synthetic */ QualityOption copy$default(QualityOption qualityOption, String str, TrackGroup trackGroup, Integer num, boolean z, int i, boolean z2, int i2, boolean z3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = qualityOption.label;
            }
            if ((i3 & 2) != 0) {
                trackGroup = qualityOption.trackGroup;
            }
            if ((i3 & 4) != 0) {
                num = qualityOption.trackIndex;
            }
            if ((i3 & 8) != 0) {
                z = qualityOption.isResizeMode;
            }
            if ((i3 & 16) != 0) {
                i = qualityOption.resizeModeIndex;
            }
            if ((i3 & 32) != 0) {
                z2 = qualityOption.isManualZoom;
            }
            if ((i3 & 64) != 0) {
                i2 = qualityOption.iconRes;
            }
            if ((i3 & 128) != 0) {
                z3 = qualityOption.isSelected;
            }
            int i4 = i2;
            boolean z4 = z3;
            int i5 = i;
            boolean z5 = z2;
            return qualityOption.copy(str, trackGroup, num, z, i5, z5, i4, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component2, reason: from getter */
        public final TrackGroup getTrackGroup() {
            return this.trackGroup;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getTrackIndex() {
            return this.trackIndex;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getIsResizeMode() {
            return this.isResizeMode;
        }

        /* renamed from: component5, reason: from getter */
        public final int getResizeModeIndex() {
            return this.resizeModeIndex;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsManualZoom() {
            return this.isManualZoom;
        }

        /* renamed from: component7, reason: from getter */
        public final int getIconRes() {
            return this.iconRes;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final QualityOption copy(String label, TrackGroup trackGroup, Integer trackIndex, boolean isResizeMode, int resizeModeIndex, boolean isManualZoom, int iconRes, boolean isSelected) {
            Intrinsics.checkNotNullParameter(label, "label");
            return new QualityOption(label, trackGroup, trackIndex, isResizeMode, resizeModeIndex, isManualZoom, iconRes, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QualityOption)) {
                return false;
            }
            QualityOption qualityOption = (QualityOption) other;
            return Intrinsics.areEqual(this.label, qualityOption.label) && Intrinsics.areEqual(this.trackGroup, qualityOption.trackGroup) && Intrinsics.areEqual(this.trackIndex, qualityOption.trackIndex) && this.isResizeMode == qualityOption.isResizeMode && this.resizeModeIndex == qualityOption.resizeModeIndex && this.isManualZoom == qualityOption.isManualZoom && this.iconRes == qualityOption.iconRes && this.isSelected == qualityOption.isSelected;
        }

        public int hashCode() {
            int hashCode = this.label.hashCode() * 31;
            TrackGroup trackGroup = this.trackGroup;
            int hashCode2 = (hashCode + (trackGroup == null ? 0 : trackGroup.hashCode())) * 31;
            Integer num = this.trackIndex;
            return ((((((((((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + Movie$$ExternalSyntheticBackport0.m(this.isResizeMode)) * 31) + this.resizeModeIndex) * 31) + Movie$$ExternalSyntheticBackport0.m(this.isManualZoom)) * 31) + this.iconRes) * 31) + Movie$$ExternalSyntheticBackport0.m(this.isSelected);
        }

        public String toString() {
            return "QualityOption(label=" + this.label + ", trackGroup=" + this.trackGroup + ", trackIndex=" + this.trackIndex + ", isResizeMode=" + this.isResizeMode + ", resizeModeIndex=" + this.resizeModeIndex + ", isManualZoom=" + this.isManualZoom + ", iconRes=" + this.iconRes + ", isSelected=" + this.isSelected + ")";
        }

        public QualityOption(String label, TrackGroup trackGroup, Integer num, boolean z, int i, boolean z2, int i2, boolean z3) {
            Intrinsics.checkNotNullParameter(label, "label");
            this.label = label;
            this.trackGroup = trackGroup;
            this.trackIndex = num;
            this.isResizeMode = z;
            this.resizeModeIndex = i;
            this.isManualZoom = z2;
            this.iconRes = i2;
            this.isSelected = z3;
        }

        public /* synthetic */ QualityOption(String str, TrackGroup trackGroup, Integer num, boolean z, int i, boolean z2, int i2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, trackGroup, num, (i3 & 8) != 0 ? false : z, (i3 & 16) != 0 ? -1 : i, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) != 0 ? false : z3);
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final String getLabel() {
            return this.label;
        }

        public final int getResizeModeIndex() {
            return this.resizeModeIndex;
        }

        public final TrackGroup getTrackGroup() {
            return this.trackGroup;
        }

        public final Integer getTrackIndex() {
            return this.trackIndex;
        }

        public final boolean isManualZoom() {
            return this.isManualZoom;
        }

        public final boolean isResizeMode() {
            return this.isResizeMode;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public final void setIconRes(int i) {
            this.iconRes = i;
        }

        public final void setSelected(boolean z) {
            this.isSelected = z;
        }
    }

    private final void showZoomDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dialog_zoom, (ViewGroup) null);
        final Dialog dialog = new Dialog(requireContext());
        this.zoomDialog = dialog;
        dialog.setContentView(inflate);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        Window window2 = dialog.getWindow();
        if (window2 != null) {
            window2.setFlags(32, 32);
        }
        final SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.zoom_seekbar);
        final TextView textView = (TextView) inflate.findViewById(R.id.zoom_percent_text);
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 3;
        this.currentModeIndex = 0;
        FragmentActivity activity = getActivity();
        PlaybackActivity playbackActivity = activity instanceof PlaybackActivity ? (PlaybackActivity) activity : null;
        if (playbackActivity != null) {
            playbackActivity.setZoom(1.0f, 3);
        }
        final Button button = (Button) inflate.findViewById(R.id.btn_zoom_x);
        final Button button2 = (Button) inflate.findViewById(R.id.btn_zoom_y);
        final Button button3 = (Button) inflate.findViewById(R.id.btn_zoom_all);
        showZoomDialog$updateAxisButtons(this, button, button2, button3, 3);
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackVideoFragment.showZoomDialog$lambda$16(Ref.IntRef.this, this, seekBar, button, button2, button3, textView, view);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackVideoFragment.showZoomDialog$lambda$17(Ref.IntRef.this, this, seekBar, button, button2, button3, textView, view);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackVideoFragment.showZoomDialog$lambda$18(Ref.IntRef.this, seekBar, this, button, button2, button3, textView, view);
            }
        });
        seekBar.setProgress(50);
        textView.setText("100%");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.tvstore.ok.PlaybackVideoFragment$showZoomDialog$4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar s) {
                Intrinsics.checkNotNullParameter(s, "s");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar s, int p, boolean fromUser) {
                Intrinsics.checkNotNullParameter(s, "s");
                if (fromUser) {
                    PlaybackVideoFragment.showZoomDialog$updateZoom(textView, this, intRef, p);
                }
            }
        });
        inflate.findViewById(R.id.btn_zoom_reset).setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackVideoFragment.showZoomDialog$lambda$19(Ref.IntRef.this, seekBar, this, button, button2, button3, textView, view);
            }
        });
        inflate.findViewById(R.id.btn_zoom_close).setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
        seekBar.post(new Runnable() { // from class: com.tvstore.ok.PlaybackVideoFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                seekBar.requestFocus();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showZoomDialog$updateZoom(TextView textView, PlaybackVideoFragment playbackVideoFragment, Ref.IntRef intRef, int i) {
        int i2 = i + 50;
        float f = i2 / 100.0f;
        textView.setText(i2 + "%");
        FragmentActivity activity = playbackVideoFragment.getActivity();
        PlaybackActivity playbackActivity = activity instanceof PlaybackActivity ? (PlaybackActivity) activity : null;
        if (playbackActivity != null) {
            playbackActivity.setZoom(f, intRef.element);
        }
    }

    private static final void showZoomDialog$updateAxisButtons(PlaybackVideoFragment playbackVideoFragment, Button button, Button button2, Button button3, int i) {
        int parseColor = Color.parseColor("#FF6C63FF");
        int parseColor2 = Color.parseColor("#44FFFFFF");
        int parseColor3 = Color.parseColor("#FF6C63FF");
        int i2 = (int) (2.0f * playbackVideoFragment.getResources().getDisplayMetrics().density);
        float f = playbackVideoFragment.getResources().getDisplayMetrics().density * 8.0f;
        Intrinsics.checkNotNull(button);
        showZoomDialog$updateAxisButtons$applyStyle(f, parseColor3, i2, -1, parseColor, parseColor2, button, i == 1);
        Intrinsics.checkNotNull(button2);
        showZoomDialog$updateAxisButtons$applyStyle(f, parseColor3, i2, -1, parseColor, parseColor2, button2, i == 2);
        Intrinsics.checkNotNull(button3);
        showZoomDialog$updateAxisButtons$applyStyle(f, parseColor3, i2, -1, parseColor, parseColor2, button3, i == 3);
    }

    private static final void showZoomDialog$updateAxisButtons$applyStyle(float f, int i, int i2, int i3, int i4, int i5, Button button, boolean z) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setColor(i);
        gradientDrawable.setStroke(i2, i3);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f);
        if (!z) {
            i4 = i5;
        }
        gradientDrawable2.setColor(i4);
        if (z) {
            gradientDrawable2.setStroke(i2, i3);
        }
        GradientDrawable gradientDrawable3 = gradientDrawable;
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, gradientDrawable3);
        stateListDrawable.addState(new int[]{android.R.attr.state_hovered}, gradientDrawable3);
        stateListDrawable.addState(new int[0], gradientDrawable2);
        button.setBackground(stateListDrawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showZoomDialog$lambda$16(Ref.IntRef intRef, PlaybackVideoFragment playbackVideoFragment, SeekBar seekBar, Button button, Button button2, Button button3, TextView textView, View view) {
        intRef.element = 1;
        showZoomDialog$updateAxisButtons(playbackVideoFragment, button, button2, button3, 1);
        FragmentActivity activity = playbackVideoFragment.getActivity();
        PlaybackActivity playbackActivity = activity instanceof PlaybackActivity ? (PlaybackActivity) activity : null;
        if (playbackActivity != null) {
            playbackActivity.setZoom(1.0f, 2);
        }
        showZoomDialog$updateZoom(textView, playbackVideoFragment, intRef, seekBar.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showZoomDialog$lambda$17(Ref.IntRef intRef, PlaybackVideoFragment playbackVideoFragment, SeekBar seekBar, Button button, Button button2, Button button3, TextView textView, View view) {
        intRef.element = 2;
        showZoomDialog$updateAxisButtons(playbackVideoFragment, button, button2, button3, 2);
        FragmentActivity activity = playbackVideoFragment.getActivity();
        PlaybackActivity playbackActivity = activity instanceof PlaybackActivity ? (PlaybackActivity) activity : null;
        if (playbackActivity != null) {
            playbackActivity.setZoom(1.0f, 1);
        }
        showZoomDialog$updateZoom(textView, playbackVideoFragment, intRef, seekBar.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showZoomDialog$lambda$18(Ref.IntRef intRef, SeekBar seekBar, PlaybackVideoFragment playbackVideoFragment, Button button, Button button2, Button button3, TextView textView, View view) {
        intRef.element = 3;
        showZoomDialog$updateAxisButtons(playbackVideoFragment, button, button2, button3, 3);
        showZoomDialog$updateZoom(textView, playbackVideoFragment, intRef, seekBar.getProgress());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showZoomDialog$lambda$19(Ref.IntRef intRef, SeekBar seekBar, PlaybackVideoFragment playbackVideoFragment, Button button, Button button2, Button button3, TextView textView, View view) {
        intRef.element = 3;
        showZoomDialog$updateAxisButtons(playbackVideoFragment, button, button2, button3, 3);
        seekBar.setProgress(50);
        showZoomDialog$updateZoom(textView, playbackVideoFragment, intRef, 50);
    }

    public final void togglePlayPause() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer == null || !exoPlayer.isPlaying()) {
            ExoPlayer exoPlayer2 = this.exoPlayer;
            if (exoPlayer2 != null) {
                exoPlayer2.play();
                return;
            }
            return;
        }
        ExoPlayer exoPlayer3 = this.exoPlayer;
        if (exoPlayer3 != null) {
            exoPlayer3.pause();
        }
    }

    public final long getPosition() {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        ExoPlayer exoPlayer = this.exoPlayer;
        Long valueOf = exoPlayer != null ? Long.valueOf(exoPlayer.getDuration()) : null;
        Long l = (valueOf == null || valueOf.longValue() != C.TIME_UNSET) ? valueOf : null;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final boolean isPlaying() {
        ExoPlayer exoPlayer = this.exoPlayer;
        return exoPlayer != null && exoPlayer.isPlaying();
    }

    public final boolean isLiveStream() {
        ExoPlayer exoPlayer;
        ExoPlayer exoPlayer2 = this.exoPlayer;
        return (exoPlayer2 != null && exoPlayer2.isCurrentMediaItemLive()) || ((exoPlayer = this.exoPlayer) != null && exoPlayer.getDuration() == C.TIME_UNSET);
    }

    public final void seekTo(long p) {
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.seekTo(p);
        }
    }

    public final void seekRelative(long o) {
        ExoPlayer exoPlayer = this.exoPlayer;
        long currentPosition = (exoPlayer != null ? exoPlayer.getCurrentPosition() : 0L) + o;
        ExoPlayer exoPlayer2 = this.exoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.seekTo(RangesKt.coerceIn(currentPosition, 0L, getDuration()));
        }
    }

    public final int getVideoWidth() {
        VideoSize videoSize;
        ExoPlayer exoPlayer = this.exoPlayer;
        int i = (exoPlayer == null || (videoSize = exoPlayer.getVideoSize()) == null) ? 16 : videoSize.width;
        if (i > 0) {
            return i;
        }
        return 16;
    }

    public final int getVideoHeight() {
        VideoSize videoSize;
        ExoPlayer exoPlayer = this.exoPlayer;
        int i = (exoPlayer == null || (videoSize = exoPlayer.getVideoSize()) == null) ? 9 : videoSize.height;
        if (i > 0) {
            return i;
        }
        return 9;
    }

    public final String getCurrentFormatInfo() {
        VideoSize videoSize;
        ExoPlayer exoPlayer = this.exoPlayer;
        int i = (exoPlayer == null || (videoSize = exoPlayer.getVideoSize()) == null) ? 0 : videoSize.height;
        if (i <= 0) {
            return "";
        }
        return i + TtmlNode.TAG_P;
    }

    private final String buildClearKeyJson(String c) {
        String obj = StringsKt.trim((CharSequence) c).toString();
        if (StringsKt.startsWith$default(obj, "{", false, 2, (Object) null)) {
            return obj;
        }
        String str = obj;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                String hexToBase64Url = hexToBase64Url(StringsKt.trim((CharSequence) split$default.get(0)).toString());
                String hexToBase64Url2 = hexToBase64Url(StringsKt.trim((CharSequence) split$default.get(1)).toString());
                if (hexToBase64Url != null && hexToBase64Url2 != null) {
                    return "{\"keys\":[{\"kty\":\"oct\",\"kid\":\"" + hexToBase64Url + "\",\"k\":\"" + hexToBase64Url2 + "\"}],\"type\":\"temporary\"}";
                }
            }
        }
        return null;
    }

    private final String hexToBase64Url(String h) {
        try {
            int length = h.length();
            byte[] bArr = new byte[length / 2];
            IntProgression step = RangesKt.step(RangesKt.until(0, length), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    bArr[first / 2] = (byte) ((Character.digit(h.charAt(first), 16) << 4) + Character.digit(h.charAt(first + 1), 16));
                    if (first == last) {
                        break;
                    }
                    first += step2;
                }
            }
            return Base64.encodeToString(bArr, 11);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        FragmentActivity activity;
        boolean isInPictureInPictureMode;
        super.onPause();
        if (Build.VERSION.SDK_INT >= 26 && (activity = getActivity()) != null) {
            isInPictureInPictureMode = activity.isInPictureInPictureMode();
            if (isInPictureInPictureMode) {
                return;
            }
        }
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ExoPlayer exoPlayer;
        super.onResume();
        ExoPlayer exoPlayer2 = this.exoPlayer;
        if (exoPlayer2 == null || exoPlayer2.getPlaybackState() != 1 || (exoPlayer = this.exoPlayer) == null) {
            return;
        }
        exoPlayer.prepare();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
        ExoPlayer exoPlayer2 = this.exoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.stop();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        PlayerView playerView = this.playerView;
        if (playerView != null) {
            playerView.setPlayer(null);
        }
        this.playerView = null;
        ExoPlayer exoPlayer = this.exoPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        this.exoPlayer = null;
    }
}
