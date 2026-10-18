package com.tvstore.ok;

import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.media.PlayerAdapter;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.exoplayer.ExoPlayer;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExoPlayerAdapter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/tvstore/ok/ExoPlayerAdapter;", "Landroidx/leanback/media/PlayerAdapter;", "Landroidx/media3/common/Player$Listener;", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "<init>", "(Landroidx/media3/exoplayer/ExoPlayer;)V", "getExoPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "currentModeIndex", "", "surfaceView", "Landroid/view/View;", "containerView", "Landroid/view/ViewGroup;", "setPresetAspectMode", "", "modeIndex", "applyScaling", "setSurfaceView", "view", "onAttachedToHost", "host", "Landroidx/leanback/media/PlaybackGlueHost;", "onDetachedFromHost", "play", "pause", "getDuration", "", "getCurrentPosition", "seekTo", "position", "isPlaying", "", "onPlaybackStateChanged", "playbackState", "onIsPlayingChanged", "onVideoSizeChanged", "videoSize", "Landroidx/media3/common/VideoSize;", "onPlayerError", "error", "Landroidx/media3/common/PlaybackException;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ExoPlayerAdapter extends PlayerAdapter implements Player.Listener {
    private ViewGroup containerView;
    private int currentModeIndex;
    private final ExoPlayer exoPlayer;
    private View surfaceView;

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
    public /* synthetic */ void onVolumeChanged(float f) {
        Player.Listener.CC.$default$onVolumeChanged(this, f);
    }

    public ExoPlayerAdapter(ExoPlayer exoPlayer) {
        Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
        this.exoPlayer = exoPlayer;
        exoPlayer.addListener(this);
    }

    public final ExoPlayer getExoPlayer() {
        return this.exoPlayer;
    }

    public final void setPresetAspectMode(int modeIndex) {
        this.currentModeIndex = modeIndex;
        applyScaling();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyScaling() {
        View view;
        ViewGroup viewGroup;
        VideoSize videoSize = this.exoPlayer.getVideoSize();
        Intrinsics.checkNotNullExpressionValue(videoSize, "getVideoSize(...)");
        if (videoSize.width <= 0 || videoSize.height <= 0 || (view = this.surfaceView) == null || (viewGroup = this.containerView) == null) {
            return;
        }
        float width = viewGroup.getWidth();
        float height = viewGroup.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            viewGroup.post(new Runnable() { // from class: com.tvstore.ok.ExoPlayerAdapter$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerAdapter.this.applyScaling();
                }
            });
            return;
        }
        float f = videoSize.width / videoSize.height;
        float f2 = width / height;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int i = this.currentModeIndex;
        if (i == 0) {
            this.exoPlayer.setVideoScalingMode(1);
            if (f > f2) {
                layoutParams2.width = -1;
                layoutParams2.height = (int) (width / f);
            } else {
                layoutParams2.height = -1;
                layoutParams2.width = (int) (height * f);
            }
            layoutParams2.gravity = 17;
        } else if (i == 1) {
            this.exoPlayer.setVideoScalingMode(2);
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams2.gravity = 17;
        } else if (i == 2) {
            this.exoPlayer.setVideoScalingMode(1);
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            layoutParams2.gravity = 119;
        }
        view.setLayoutParams(layoutParams2);
    }

    public final void setSurfaceView(View view) {
        SurfaceHolder holder;
        this.surfaceView = view;
        SurfaceView surfaceView = view instanceof SurfaceView ? (SurfaceView) view : null;
        if (surfaceView == null || (holder = surfaceView.getHolder()) == null) {
            return;
        }
        holder.addCallback(new SurfaceHolder.Callback() { // from class: com.tvstore.ok.ExoPlayerAdapter$setSurfaceView$1
            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder holder2) {
                Intrinsics.checkNotNullParameter(holder2, "holder");
                ExoPlayerAdapter.this.getExoPlayer().setVideoSurfaceHolder(holder2);
                ExoPlayerAdapter.this.applyScaling();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder holder2, int format, int width, int height) {
                Intrinsics.checkNotNullParameter(holder2, "holder");
                ExoPlayerAdapter.this.applyScaling();
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder holder2) {
                Intrinsics.checkNotNullParameter(holder2, "holder");
                ExoPlayerAdapter.this.getExoPlayer().setVideoSurfaceHolder(null);
            }
        });
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onAttachedToHost(PlaybackGlueHost host) {
        Intrinsics.checkNotNullParameter(host, "host");
        super.onAttachedToHost(host);
        try {
            Field declaredField = host.getClass().getDeclaredField("mFragment");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(host);
            Fragment fragment = obj instanceof Fragment ? (Fragment) obj : null;
            KeyEvent.Callback view = fragment != null ? fragment.getView() : null;
            this.containerView = view instanceof ViewGroup ? (ViewGroup) view : null;
        } catch (Exception unused) {
        }
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void onDetachedFromHost() {
        this.exoPlayer.setVideoSurfaceHolder(null);
        this.surfaceView = null;
        this.containerView = null;
        super.onDetachedFromHost();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void play() {
        if (this.exoPlayer.getPlaybackState() == 1) {
            this.exoPlayer.prepare();
        }
        this.exoPlayer.play();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void pause() {
        this.exoPlayer.pause();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getDuration() {
        if (this.exoPlayer.getDuration() == C.TIME_UNSET) {
            return 0L;
        }
        return this.exoPlayer.getDuration();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public long getCurrentPosition() {
        return this.exoPlayer.getCurrentPosition();
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public void seekTo(long position) {
        this.exoPlayer.seekTo(position);
    }

    @Override // androidx.leanback.media.PlayerAdapter
    public boolean isPlaying() {
        return this.exoPlayer.isPlaying();
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackStateChanged(int playbackState) {
        if (playbackState == 2) {
            PlayerAdapter.Callback callback = getCallback();
            if (callback != null) {
                callback.onBufferingStateChanged(this, true);
                return;
            }
            return;
        }
        if (playbackState != 3) {
            return;
        }
        applyScaling();
        PlayerAdapter.Callback callback2 = getCallback();
        if (callback2 != null) {
            callback2.onBufferingStateChanged(this, false);
        }
        PlayerAdapter.Callback callback3 = getCallback();
        if (callback3 != null) {
            callback3.onPreparedStateChanged(this);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean isPlaying) {
        PlayerAdapter.Callback callback = getCallback();
        if (callback != null) {
            callback.onPlayStateChanged(this);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onVideoSizeChanged(VideoSize videoSize) {
        Intrinsics.checkNotNullParameter(videoSize, "videoSize");
        applyScaling();
        PlayerAdapter.Callback callback = getCallback();
        if (callback != null) {
            callback.onVideoSizeChanged(this, videoSize.width, videoSize.height);
        }
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        PlayerAdapter.Callback callback = getCallback();
        if (callback != null) {
            callback.onError(this, error.errorCode, error.getMessage());
        }
    }
}
