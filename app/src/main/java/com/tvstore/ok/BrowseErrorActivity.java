package com.tvstore.ok;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.common.C;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrowseErrorActivity.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/tvstore/ok/BrowseErrorActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "mErrorFragment", "Lcom/tvstore/ok/ErrorFragment;", "mSpinnerFragment", "Lcom/tvstore/ok/BrowseErrorActivity$SpinnerFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "testError", "SpinnerFragment", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class BrowseErrorActivity extends FragmentActivity {
    private ErrorFragment mErrorFragment;
    private SpinnerFragment mSpinnerFragment;
    private static final long TIMER_DELAY = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private static final int SPINNER_WIDTH = 100;
    private static final int SPINNER_HEIGHT = 100;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_browse_fragment, new MainFragment()).commitNow();
        }
        testError();
    }

    private final void testError() {
        this.mErrorFragment = new ErrorFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R.id.main_browse_fragment;
        ErrorFragment errorFragment = this.mErrorFragment;
        SpinnerFragment spinnerFragment = null;
        if (errorFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorFragment");
            errorFragment = null;
        }
        beginTransaction.add(i, errorFragment).commit();
        this.mSpinnerFragment = new SpinnerFragment();
        FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
        int i2 = R.id.main_browse_fragment;
        SpinnerFragment spinnerFragment2 = this.mSpinnerFragment;
        if (spinnerFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerFragment");
        } else {
            spinnerFragment = spinnerFragment2;
        }
        beginTransaction2.add(i2, spinnerFragment).commit();
        Looper myLooper = Looper.myLooper();
        Intrinsics.checkNotNull(myLooper);
        new Handler(myLooper).postDelayed(new Runnable() { // from class: com.tvstore.ok.BrowseErrorActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BrowseErrorActivity.testError$lambda$0(BrowseErrorActivity.this);
            }
        }, TIMER_DELAY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void testError$lambda$0(BrowseErrorActivity browseErrorActivity) {
        FragmentTransaction beginTransaction = browseErrorActivity.getSupportFragmentManager().beginTransaction();
        SpinnerFragment spinnerFragment = browseErrorActivity.mSpinnerFragment;
        ErrorFragment errorFragment = null;
        if (spinnerFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerFragment");
            spinnerFragment = null;
        }
        beginTransaction.remove(spinnerFragment).commit();
        ErrorFragment errorFragment2 = browseErrorActivity.mErrorFragment;
        if (errorFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mErrorFragment");
        } else {
            errorFragment = errorFragment2;
        }
        errorFragment.setErrorContent$app();
    }

    /* compiled from: BrowseErrorActivity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/tvstore/ok/BrowseErrorActivity$SpinnerFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class SpinnerFragment extends Fragment {
        @Override // androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            ProgressBar progressBar = new ProgressBar(container != null ? container.getContext() : null);
            if (container instanceof FrameLayout) {
                progressBar.setLayoutParams(new FrameLayout.LayoutParams(BrowseErrorActivity.SPINNER_WIDTH, BrowseErrorActivity.SPINNER_HEIGHT, 17));
            }
            return progressBar;
        }
    }
}
