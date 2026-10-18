package com.tvstore.ok;

import android.app.ProgressDialog;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda17 implements Function1 {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ ProgressDialog f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda17(MainActivity mainActivity, ProgressDialog progressDialog, String str, boolean z) {
        this.f$0 = mainActivity;
        this.f$1 = progressDialog;
        this.f$2 = str;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MainActivity.validateAndAddSource$lambda$38(this.f$0, this.f$1, this.f$2, this.f$3, ((Boolean) obj).booleanValue());
    }
}
