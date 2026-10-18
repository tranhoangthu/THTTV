package com.tvstore.ok;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.leanback.app.ErrorSupportFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorFragment.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\r\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/tvstore/ok/ErrorFragment;", "Landroidx/leanback/app/ErrorSupportFragment;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setErrorContent", "setErrorContent$app", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class ErrorFragment extends ErrorSupportFragment {
    private static final boolean TRANSLUCENT = true;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.app_name));
    }

    public final void setErrorContent$app() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        setImageDrawable(ContextCompat.getDrawable(activity, androidx.leanback.R.drawable.lb_ic_sad_cloud));
        setMessage(getResources().getString(R.string.error_fragment_message));
        setDefaultBackground(TRANSLUCENT);
        setButtonText(getResources().getString(R.string.dismiss_error));
        setButtonClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.ErrorFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorFragment.setErrorContent$lambda$0(ErrorFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setErrorContent$lambda$0(ErrorFragment errorFragment, View view) {
        FragmentManager fragmentManager = errorFragment.getFragmentManager();
        Intrinsics.checkNotNull(fragmentManager);
        fragmentManager.beginTransaction().remove(errorFragment).commit();
    }
}
