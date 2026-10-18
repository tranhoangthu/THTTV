package com.tvstore.ok;

import android.content.DialogInterface;
import android.widget.EditText;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda7 implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ MainActivity f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda7(EditText editText, MainActivity mainActivity, String str) {
        this.f$0 = editText;
        this.f$1 = mainActivity;
        this.f$2 = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.showRegistrationDialog$lambda$26(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
