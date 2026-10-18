package com.tvstore.ok;

import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlaybackActivity.kt */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/tvstore/ok/PlaybackActivity$onCreate$3", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "userTouching", "", "onProgressChanged", "", "seekBar", "Landroid/widget/SeekBar;", "progress", "", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class PlaybackActivity$onCreate$3 implements SeekBar.OnSeekBarChangeListener {
    final /* synthetic */ PlaybackActivity this$0;
    private boolean userTouching;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaybackActivity$onCreate$3(PlaybackActivity playbackActivity) {
        this.this$0 = playbackActivity;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        TextView textView;
        String formatMillis;
        Runnable runnable;
        Handler handler;
        Runnable runnable2;
        Handler handler2;
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        if (fromUser) {
            Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
            TextView textView2 = null;
            PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
            if (playbackVideoFragment == null || !playbackVideoFragment.isLiveStream()) {
                long duration = playbackVideoFragment != null ? playbackVideoFragment.getDuration() : 0L;
                if (duration <= 0) {
                    return;
                }
                long j = (duration * progress) / 1000;
                textView = this.this$0.programStartTime;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("programStartTime");
                } else {
                    textView2 = textView;
                }
                formatMillis = this.this$0.formatMillis(j);
                textView2.setText(formatMillis);
                if (this.userTouching) {
                    return;
                }
                if (playbackVideoFragment != null) {
                    playbackVideoFragment.seekTo(j);
                }
                runnable = this.this$0.hideInfoRunnable;
                if (runnable != null) {
                    handler2 = this.this$0.handler;
                    handler2.removeCallbacks(runnable);
                }
                final PlaybackActivity playbackActivity = this.this$0;
                playbackActivity.hideInfoRunnable = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$onCreate$3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackActivity$onCreate$3.onProgressChanged$lambda$1(PlaybackActivity.this);
                    }
                };
                handler = this.this$0.handler;
                runnable2 = this.this$0.hideInfoRunnable;
                Intrinsics.checkNotNull(runnable2);
                handler.postDelayed(runnable2, 5000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onProgressChanged$lambda$1(PlaybackActivity playbackActivity) {
        LinearLayout linearLayout;
        Handler handler;
        PlaybackActivity$updateInfoRunnable$1 playbackActivity$updateInfoRunnable$1;
        boolean z;
        linearLayout = playbackActivity.channelInfoPopup;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        View findViewById = playbackActivity.findViewById(R.id.btn_play_pause_center);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        handler = playbackActivity.handler;
        playbackActivity$updateInfoRunnable$1 = playbackActivity.updateInfoRunnable;
        handler.removeCallbacks(playbackActivity$updateInfoRunnable$1);
        z = playbackActivity.isOverlayVisible;
        if (z) {
            return;
        }
        playbackActivity.findViewById(R.id.mobile_controls).setVisibility(8);
        View findViewById2 = playbackActivity.findViewById(R.id.mobile_controls_left);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        Runnable runnable;
        Handler handler;
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if (playbackVideoFragment == null || !playbackVideoFragment.isLiveStream()) {
            this.userTouching = true;
            runnable = this.this$0.hideInfoRunnable;
            if (runnable != null) {
                handler = this.this$0.handler;
                handler.removeCallbacks(runnable);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        Handler handler;
        Runnable runnable;
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        Fragment findFragmentById = this.this$0.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if (playbackVideoFragment == null || !playbackVideoFragment.isLiveStream()) {
            this.userTouching = false;
            long duration = playbackVideoFragment != null ? playbackVideoFragment.getDuration() : 0L;
            if (duration <= 0) {
                return;
            }
            long progress = (duration * seekBar.getProgress()) / 1000;
            if (playbackVideoFragment != null) {
                playbackVideoFragment.seekTo(progress);
            }
            final PlaybackActivity playbackActivity = this.this$0;
            playbackActivity.hideInfoRunnable = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$onCreate$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackActivity.this.hideChannelInfo();
                }
            };
            handler = this.this$0.handler;
            runnable = this.this$0.hideInfoRunnable;
            Intrinsics.checkNotNull(runnable);
            handler.postDelayed(runnable, 5000L);
        }
    }
}
