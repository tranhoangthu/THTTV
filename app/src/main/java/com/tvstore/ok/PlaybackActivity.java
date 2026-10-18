package com.tvstore.ok;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.PictureInPictureParams;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.util.Rational;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.actions.SearchIntents;
import com.tvstore.ok.PlaybackActivity;
import java.io.Serializable;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: PlaybackActivity.kt */
@Metadata(d1 = {"\u0000\u0089\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001Q\b\u0007\u0018\u00002\u00020\u0001:\u0002ç\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010r\u001a\u00020 J\u0012\u0010z\u001a\u00020{2\b\u0010|\u001a\u0004\u0018\u00010xH\u0014J\u0012\u0010}\u001a\u00020{2\b\u0010~\u001a\u0004\u0018\u00010\u007fH\u0014J\u0012\u0010\u0080\u0001\u001a\u00020{2\u0007\u0010\u0081\u0001\u001a\u00020 H\u0002J\t\u0010\u0082\u0001\u001a\u00020{H\u0002J\u0012\u0010\u0083\u0001\u001a\u00020{2\u0007\u0010\u0084\u0001\u001a\u00020mH\u0002J\u0012\u0010\u0085\u0001\u001a\u00020{2\u0007\u0010\u0084\u0001\u001a\u00020mH\u0002J\u0012\u0010\u0086\u0001\u001a\u00020{2\u0007\u0010\u0087\u0001\u001a\u00020mH\u0002J\t\u0010\u0088\u0001\u001a\u00020{H\u0002J\t\u0010\u0089\u0001\u001a\u00020{H\u0002J\t\u0010\u008a\u0001\u001a\u00020{H\u0002J\u001b\u0010\u008b\u0001\u001a\u00020{2\u0007\u0010\u008c\u0001\u001a\u00020m2\u0007\u0010\u008d\u0001\u001a\u00020mH\u0002J\u0012\u0010\u008e\u0001\u001a\u00020{2\t\b\u0002\u0010\u008f\u0001\u001a\u00020 J\u0007\u0010\u0090\u0001\u001a\u00020{J\u0019\u0010\u0091\u0001\u001a\u00020{2\u0007\u0010\u0092\u0001\u001a\u00020m2\u0007\u0010\u0093\u0001\u001a\u00020@J\u0010\u0010\u0094\u0001\u001a\u00020{2\u0007\u0010\u0095\u0001\u001a\u00020@J\u0012\u0010\u0096\u0001\u001a\u00020G2\u0007\u0010\u0097\u0001\u001a\u00020>H\u0002J\u001b\u0010\u0098\u0001\u001a\u00020{2\u0007\u0010\u0099\u0001\u001a\u00020@2\u0007\u0010\u009a\u0001\u001a\u00020GH\u0002J\u0013\u0010\u009c\u0001\u001a\u00020 2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0002J\t\u0010\u009f\u0001\u001a\u00020{H\u0002J\u000f\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020]0IH\u0002J\t\u0010¡\u0001\u001a\u00020{H\u0002J\u0012\u0010¢\u0001\u001a\u00020{2\u0007\u0010£\u0001\u001a\u00020GH\u0002J\u001d\u0010¤\u0001\u001a\u00020{2\u0007\u0010¥\u0001\u001a\u00020]2\t\b\u0002\u0010¦\u0001\u001a\u00020 H\u0002J\u0010\u0010§\u0001\u001a\u00020{2\u0007\u0010¨\u0001\u001a\u00020 J\u0014\u0010©\u0001\u001a\u00020{2\t\u0010¥\u0001\u001a\u0004\u0018\u00010]H\u0002J\t\u0010ª\u0001\u001a\u00020{H\u0002J\t\u0010«\u0001\u001a\u00020{H\u0002J\t\u0010¬\u0001\u001a\u00020{H\u0002J\t\u0010\u00ad\u0001\u001a\u00020{H\u0002J\t\u0010®\u0001\u001a\u00020{H\u0002J\t\u0010¯\u0001\u001a\u00020{H\u0002J\t\u0010°\u0001\u001a\u00020{H\u0002J\t\u0010±\u0001\u001a\u00020{H\u0002J\u0007\u0010²\u0001\u001a\u00020{J\t\u0010³\u0001\u001a\u00020{H\u0002J\u0012\u0010´\u0001\u001a\u00020{2\u0007\u0010¥\u0001\u001a\u00020]H\u0002J\u0012\u0010¶\u0001\u001a\u00020{2\u0007\u0010¥\u0001\u001a\u00020]H\u0002J\u0012\u0010·\u0001\u001a\u00020{2\u0007\u0010¸\u0001\u001a\u00020 H\u0002J\u0013\u0010»\u0001\u001a\u00020 2\b\u0010¼\u0001\u001a\u00030½\u0001H\u0017J'\u0010¾\u0001\u001a\u00020{2\u0007\u0010¿\u0001\u001a\u00020@2\u0007\u0010À\u0001\u001a\u00020 2\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002J'\u0010Ã\u0001\u001a\u00020{2\u0007\u0010¿\u0001\u001a\u00020@2\u0007\u0010À\u0001\u001a\u00020 2\n\u0010Á\u0001\u001a\u0005\u0018\u00010Â\u0001H\u0002J\u0012\u0010Ä\u0001\u001a\u00020{2\u0007\u0010¿\u0001\u001a\u00020@H\u0002J\u0012\u0010Å\u0001\u001a\u00020{2\u0007\u0010Æ\u0001\u001a\u00020 H\u0002J\t\u0010Ç\u0001\u001a\u00020{H\u0002J\t\u0010È\u0001\u001a\u00020{H\u0002J\t\u0010É\u0001\u001a\u00020{H\u0002J\t\u0010Ê\u0001\u001a\u00020{H\u0002J\t\u0010Ë\u0001\u001a\u00020{H\u0002J\t\u0010Ì\u0001\u001a\u00020{H\u0002J\u0012\u0010Í\u0001\u001a\u00020{2\u0007\u0010Æ\u0001\u001a\u00020 H\u0002J\u001e\u0010Î\u0001\u001a\u00020 2\u0007\u0010¿\u0001\u001a\u00020@2\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0016J\t\u0010Ï\u0001\u001a\u00020{H\u0002J\u0012\u0010Ð\u0001\u001a\u00020{2\u0007\u0010Ñ\u0001\u001a\u00020 H\u0016J\u0012\u0010Ò\u0001\u001a\u00020{2\u0007\u0010Ó\u0001\u001a\u00020@H\u0002J\t\u0010Ô\u0001\u001a\u00020{H\u0002J\t\u0010Õ\u0001\u001a\u00020{H\u0002J\t\u0010Ö\u0001\u001a\u00020{H\u0002J\u0012\u0010×\u0001\u001a\u00020G2\u0007\u0010Ø\u0001\u001a\u00020GH\u0002J\u0012\u0010Ù\u0001\u001a\u00020{2\u0007\u0010Ú\u0001\u001a\u00020GH\u0002J\t\u0010Û\u0001\u001a\u00020{H\u0002J\u0010\u0010Ü\u0001\u001a\u00020{2\u0007\u0010¨\u0001\u001a\u00020 J\t\u0010Ý\u0001\u001a\u00020{H\u0014J\t\u0010Þ\u0001\u001a\u00020{H\u0002J\t\u0010ß\u0001\u001a\u00020{H\u0014J\u001c\u0010à\u0001\u001a\u00020{2\u0007\u0010á\u0001\u001a\u00020 2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0016J\t\u0010ä\u0001\u001a\u00020{H\u0014J\t\u0010å\u0001\u001a\u00020{H\u0014J\t\u0010æ\u0001\u001a\u00020{H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\"09X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020G0IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0004\n\u0002\u0010RR\u0010\u0010S\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010V\u001a\u00060Wj\u0002`XX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020>X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020@X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010^\u001a\b\u0012\u0004\u0012\u00020]0IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020MX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010n\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020mX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010v\u001a\u0010\u0012\f\u0012\n y*\u0004\u0018\u00010x0x0wX\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u009b\u0001\u001a\u00020OX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010µ\u0001\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010¹\u0001\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006è\u0001"}, d2 = {"Lcom/tvstore/ok/PlaybackActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "channelOverlay", "Landroid/widget/LinearLayout;", "channelList", "Landroidx/recyclerview/widget/RecyclerView;", "channelInfoPopup", "infoChannelNumber", "Landroid/widget/TextView;", "infoChannelName", "infoChannelCategory", "infoChannelLogo", "Landroid/widget/ImageView;", "programStartTime", "programStopTime", "miniChannelPopup", "miniChannelLogo", "miniChannelNumber", "epgOverlay", "epgList", "epgInfoLayout", "timelineLayout", "currentProgramTitle", "epgProgressBar", "Landroid/widget/SeekBar;", "vodSeekProgress", "Landroid/widget/ProgressBar;", "epgAdapter", "Lcom/tvstore/ok/EpgAdapter;", "isEpgVisible", "", "gestureFeedback", "Landroid/view/View;", "gestureIcon", "gestureText", "audioManager", "Landroid/media/AudioManager;", "gestureDetector", "Landroid/view/GestureDetector;", "hudLeft", "pbBrightness", "hudRight", "pbVolume", "lockOverlay", "btnUnlock", "Landroid/widget/ImageButton;", "isLocked", "audioOverlay", "Landroid/widget/RelativeLayout;", "audioLogo", "audioBgImage", "audioName", "audioCategory", "audioGlow", "eqBars", "", "isAudioAnimating", "random", "Ljava/util/Random;", "lastDoubleTapTime", "", "accumulatedSeekSeconds", "", "channelAdapter", "Lcom/tvstore/ok/ChannelAdapter;", "categoryList", "categoryAdapter", "Lcom/tvstore/ok/PlaybackActivity$CategoryAdapter;", "activeCategory", "", "categories", "", "lastSelectedCategory", "isOverlayVisible", "handler", "Landroid/os/Handler;", "hideInfoRunnable", "Ljava/lang/Runnable;", "updateInfoRunnable", "com/tvstore/ok/PlaybackActivity$updateInfoRunnable$1", "Lcom/tvstore/ok/PlaybackActivity$updateInfoRunnable$1;", "hideOverlayRunnable", "channelNumberOverlay", "channelNumberText", "channelNumberBuffer", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "channelNumberRunnable", "CHANNEL_INPUT_TIMEOUT", "MAX_CHANNEL_DIGITS", "currentMovie", "Lcom/tvstore/ok/Movie;", "allChannels", "seekHandler", "leftSeekRunnable", "rightSeekRunnable", "isSeeking", "pendingSeekPosition", "isDvdSeekMode", "dvdSeekSpeed", "isForwardDvdSeek", "dvdSeekRunnable", "dvdSeekHandler", "isGestureStarted", "activeGestureType", "initialVolume", "initialBrightness", "", "currentZoomX", "currentZoomY", "isManualZoom", "currentPresetMode", "isManualZoomActive", "panX", "panY", "videoContainer", "voiceSearchLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onNewIntent", "", "intent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "toggleLock", "lock", "setupGestures", "handleVolumeGesture", "totalDeltaY", "handleBrightnessGesture", "handleSeekGesture", "deltaX", "hideHUDs", "applyZoomTransform", "clampPan", "handlePanGesture", "distanceX", "distanceY", "resetZoom", "showFeedback", "resetZoomHard", "setZoom", "scale", "axis", "applyPresetAspectMode", "modeIndex", "formatMillis", "ms", "showGestureFeedback", "iconRes", "text", "hideGestureRunnable", "isTvDevice", "context", "Landroid/content/Context;", "setupChannelList", "getFilteredChannels", "filterChannelList", "scrollCategoryToCenter", "category", "switchChannel", "movie", "isFromDpad", "setAudioOverlayPlaybackState", "isPlaying", "updateAudioOverlay", "startAudioAnimations", "animateEqBars", "stopAudioAnimations", "showOverlay", "resetHideOverlayTimer", "hideOverlay", "showEpg", "hideEpg", "hideChannelInfo", "updateCenterControlsState", "showChannelInfo", "hideMiniInfoRunnable", "showMiniChannelInfo", "switchToAdjacentChannel", "next", "longPressRunnable", "isLongPressTriggered", "dispatchKeyEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "handleSinglePressAction", "keyCode", "isVod", "fragment", "Lcom/tvstore/ok/PlaybackVideoFragment;", "handleLongPressAction", "handleDvdSeekKeyEvent", "startDvdSeek", "isForward", "cycleDvdSeekSpeed", "updateDvdSeekUI", "startDvdSeekRunnable", "stopDvdSeekRunnable", "stopDvdSeek", "stopContinuousSeek", "startContinuousSeek", "onKeyLongPress", "hideSystemUI", "onWindowFocusChanged", "hasFocus", "appendChannelDigit", "digit", "showChannelNumberOverlay", "hideChannelNumberOverlay", "commitChannelNumber", "removeAccents", CmcdData.Factory.STREAMING_FORMAT_SS, "handleVoiceSearch", SearchIntents.EXTRA_QUERY, "startVoiceSearch", "updatePlayPauseUI", "onDestroy", "enterPipMode", "onUserLeaveHint", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onStop", "exitPlayback", "CategoryAdapter", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class PlaybackActivity extends FragmentActivity {
    private int accumulatedSeekSeconds;
    private int activeGestureType;
    private ImageView audioBgImage;
    private TextView audioCategory;
    private View audioGlow;
    private ImageView audioLogo;
    private AudioManager audioManager;
    private TextView audioName;
    private RelativeLayout audioOverlay;
    private ImageButton btnUnlock;
    private CategoryAdapter categoryAdapter;
    private RecyclerView categoryList;
    private ChannelAdapter channelAdapter;
    private LinearLayout channelInfoPopup;
    private RecyclerView channelList;
    private LinearLayout channelNumberOverlay;
    private Runnable channelNumberRunnable;
    private TextView channelNumberText;
    private LinearLayout channelOverlay;
    private Movie currentMovie;
    private int currentPresetMode;
    private TextView currentProgramTitle;
    private Runnable dvdSeekRunnable;
    private EpgAdapter epgAdapter;
    private LinearLayout epgInfoLayout;
    private RecyclerView epgList;
    private LinearLayout epgOverlay;
    private SeekBar epgProgressBar;
    private GestureDetector gestureDetector;
    private View gestureFeedback;
    private ImageView gestureIcon;
    private TextView gestureText;
    private final Runnable hideGestureRunnable;
    private Runnable hideInfoRunnable;
    private Runnable hideMiniInfoRunnable;
    private Runnable hideOverlayRunnable;
    private View hudLeft;
    private View hudRight;
    private TextView infoChannelCategory;
    private ImageView infoChannelLogo;
    private TextView infoChannelName;
    private TextView infoChannelNumber;
    private int initialVolume;
    private boolean isAudioAnimating;
    private boolean isDvdSeekMode;
    private boolean isEpgVisible;
    private boolean isGestureStarted;
    private boolean isLocked;
    private boolean isLongPressTriggered;
    private boolean isManualZoom;
    private boolean isOverlayVisible;
    private boolean isSeeking;
    private long lastDoubleTapTime;
    private String lastSelectedCategory;
    private Runnable leftSeekRunnable;
    private View lockOverlay;
    private Runnable longPressRunnable;
    private ImageView miniChannelLogo;
    private TextView miniChannelNumber;
    private LinearLayout miniChannelPopup;
    private float panX;
    private float panY;
    private ProgressBar pbBrightness;
    private ProgressBar pbVolume;
    private long pendingSeekPosition;
    private TextView programStartTime;
    private TextView programStopTime;
    private Runnable rightSeekRunnable;
    private LinearLayout timelineLayout;
    private View videoContainer;
    private ProgressBar vodSeekProgress;
    private final ActivityResultLauncher<Intent> voiceSearchLauncher;
    private final List<View> eqBars = new ArrayList();
    private final Random random = new Random();
    private String activeCategory = "Tất cả";
    private List<String> categories = CollectionsKt.emptyList();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final PlaybackActivity$updateInfoRunnable$1 updateInfoRunnable = new PlaybackActivity$updateInfoRunnable$1(this);
    private final StringBuilder channelNumberBuffer = new StringBuilder();
    private final long CHANNEL_INPUT_TIMEOUT = 1500;
    private final int MAX_CHANNEL_DIGITS = 3;
    private List<Movie> allChannels = CollectionsKt.emptyList();
    private final Handler seekHandler = new Handler(Looper.getMainLooper());
    private int dvdSeekSpeed = 1;
    private boolean isForwardDvdSeek = true;
    private final Handler dvdSeekHandler = new Handler(Looper.getMainLooper());
    private float initialBrightness = 0.5f;
    private float currentZoomX = 1.0f;
    private float currentZoomY = 1.0f;

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return true;
    }

    public PlaybackActivity() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda42
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PlaybackActivity.voiceSearchLauncher$lambda$0(PlaybackActivity.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.voiceSearchLauncher = registerForActivityResult;
        this.hideGestureRunnable = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda43
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.hideGestureRunnable$lambda$31(PlaybackActivity.this);
            }
        };
    }

    /* renamed from: isManualZoomActive, reason: from getter */
    public final boolean getIsManualZoom() {
        return this.isManualZoom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void voiceSearchLauncher$lambda$0(PlaybackActivity playbackActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            ArrayList<String> stringArrayListExtra = data != null ? data.getStringArrayListExtra("android.speech.extra.RESULTS") : null;
            String str = stringArrayListExtra != null ? (String) CollectionsKt.firstOrNull((List) stringArrayListExtra) : null;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            playbackActivity.handleVoiceSearch(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(DetailsActivity.MOVIE) : null;
        Movie movie = serializableExtra instanceof Movie ? (Movie) serializableExtra : null;
        if (movie != null) {
            Log.d("PlaybackActivity", "onNewIntent: Switching to " + movie.getTitle());
            switchChannel$default(this, movie, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        String stringExtra;
        super.onCreate(savedInstanceState);
        getWindow().addFlags(128);
        hideSystemUI();
        PlaybackActivity playbackActivity = this;
        NetworkUtils.INSTANCE.initSecurity(playbackActivity);
        MovieList.INSTANCE.init(playbackActivity);
        EpgManager.INSTANCE.fetchEpg(new Function0() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return PlaybackActivity.onCreate$lambda$2(PlaybackActivity.this);
            }
        });
        if (!isTvDevice(playbackActivity) && !Intrinsics.areEqual(MovieList.INSTANCE.getUiMode(), "tv")) {
            setRequestedOrientation(6);
        }
        setContentView(R.layout.activity_playback);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.tvstore.ok.PlaybackActivity$onCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
            
                if (r0.getVisibility() == 0) goto L26;
             */
            @Override // androidx.activity.OnBackPressedCallback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void handleOnBackPressed() {
                /*
                    r3 = this;
                    com.tvstore.ok.PlaybackActivity r0 = com.tvstore.ok.PlaybackActivity.this
                    boolean r0 = com.tvstore.ok.PlaybackActivity.access$isLocked$p(r0)
                    com.tvstore.ok.PlaybackActivity r1 = com.tvstore.ok.PlaybackActivity.this
                    if (r0 == 0) goto L19
                    android.content.Context r1 = (android.content.Context) r1
                    java.lang.String r0 = "Màn hình đang khóa. Vui lòng mở khóa để thoát."
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    r2 = 0
                    android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r2)
                    r0.show()
                    return
                L19:
                    androidx.fragment.app.FragmentManager r0 = r1.getSupportFragmentManager()
                    int r1 = com.tvstore.ok.R.id.video_fragment_container
                    androidx.fragment.app.Fragment r0 = r0.findFragmentById(r1)
                    boolean r1 = r0 instanceof com.tvstore.ok.PlaybackVideoFragment
                    r2 = 0
                    if (r1 == 0) goto L2b
                    com.tvstore.ok.PlaybackVideoFragment r0 = (com.tvstore.ok.PlaybackVideoFragment) r0
                    goto L2c
                L2b:
                    r0 = r2
                L2c:
                    if (r0 == 0) goto L36
                    boolean r0 = r0.onBackPressed()
                    r1 = 1
                    if (r0 != r1) goto L36
                    return
                L36:
                    com.tvstore.ok.PlaybackActivity r0 = com.tvstore.ok.PlaybackActivity.this
                    r1 = r0
                    android.content.Context r1 = (android.content.Context) r1
                    boolean r0 = com.tvstore.ok.PlaybackActivity.access$isTvDevice(r0, r1)
                    if (r0 == 0) goto L6f
                    com.tvstore.ok.PlaybackActivity r0 = com.tvstore.ok.PlaybackActivity.this
                    android.widget.LinearLayout r0 = com.tvstore.ok.PlaybackActivity.access$getChannelInfoPopup$p(r0)
                    if (r0 != 0) goto L4f
                    java.lang.String r0 = "channelInfoPopup"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    r0 = r2
                L4f:
                    int r0 = r0.getVisibility()
                    if (r0 == 0) goto L69
                    com.tvstore.ok.PlaybackActivity r0 = com.tvstore.ok.PlaybackActivity.this
                    android.widget.LinearLayout r0 = com.tvstore.ok.PlaybackActivity.access$getMiniChannelPopup$p(r0)
                    if (r0 != 0) goto L63
                    java.lang.String r0 = "miniChannelPopup"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    r0 = r2
                L63:
                    int r0 = r0.getVisibility()
                    if (r0 != 0) goto L6f
                L69:
                    com.tvstore.ok.PlaybackActivity r0 = com.tvstore.ok.PlaybackActivity.this
                    r0.hideChannelInfo()
                    return
                L6f:
                    com.tvstore.ok.PlaybackActivity r0 = com.tvstore.ok.PlaybackActivity.this
                    android.widget.LinearLayout r0 = com.tvstore.ok.PlaybackActivity.access$getChannelOverlay$p(r0)
                    if (r0 != 0) goto L7d
                    java.lang.String r0 = "channelOverlay"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    r0 = r2
                L7d:
                    int r0 = r0.getVisibility()
                    com.tvstore.ok.PlaybackActivity r1 = com.tvstore.ok.PlaybackActivity.this
                    if (r0 != 0) goto L89
                    com.tvstore.ok.PlaybackActivity.access$hideOverlay(r1)
                    return
                L89:
                    android.widget.LinearLayout r0 = com.tvstore.ok.PlaybackActivity.access$getEpgOverlay$p(r1)
                    if (r0 != 0) goto L95
                    java.lang.String r0 = "epgOverlay"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    goto L96
                L95:
                    r2 = r0
                L96:
                    int r0 = r2.getVisibility()
                    com.tvstore.ok.PlaybackActivity r1 = com.tvstore.ok.PlaybackActivity.this
                    if (r0 != 0) goto La2
                    com.tvstore.ok.PlaybackActivity.access$hideEpg(r1)
                    return
                La2:
                    com.tvstore.ok.PlaybackActivity.access$exitPlayback(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.PlaybackActivity$onCreate$2.handleOnBackPressed():void");
            }
        });
        Object systemService = getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        setupGestures();
        View findViewById = findViewById(R.id.channel_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.channelOverlay = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.channel_list);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.channelList = (RecyclerView) findViewById2;
        View findViewById3 = findViewById(R.id.category_list);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.categoryList = (RecyclerView) findViewById3;
        View findViewById4 = findViewById(R.id.channel_info_popup);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.channelInfoPopup = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.info_channel_number);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.infoChannelNumber = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.info_channel_name);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        this.infoChannelName = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.info_channel_category);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        this.infoChannelCategory = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.info_channel_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        this.infoChannelLogo = (ImageView) findViewById8;
        View findViewById9 = findViewById(R.id.program_start_time);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        this.programStartTime = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.program_stop_time);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(...)");
        this.programStopTime = (TextView) findViewById10;
        RecyclerView recyclerView = this.channelList;
        Object obj = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(playbackActivity));
        RecyclerView recyclerView2 = this.channelList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelList");
            recyclerView2 = null;
        }
        recyclerView2.setItemViewCacheSize(20);
        RecyclerView recyclerView3 = this.categoryList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(playbackActivity, 0, false));
        View findViewById11 = findViewById(R.id.mini_channel_popup);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(...)");
        this.miniChannelPopup = (LinearLayout) findViewById11;
        View findViewById12 = findViewById(R.id.mini_channel_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(...)");
        this.miniChannelLogo = (ImageView) findViewById12;
        View findViewById13 = findViewById(R.id.mini_channel_number);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(...)");
        this.miniChannelNumber = (TextView) findViewById13;
        View findViewById14 = findViewById(R.id.epg_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(...)");
        this.epgOverlay = (LinearLayout) findViewById14;
        View findViewById15 = findViewById(R.id.epg_list);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(...)");
        this.epgList = (RecyclerView) findViewById15;
        View findViewById16 = findViewById(R.id.epg_info_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(...)");
        this.epgInfoLayout = (LinearLayout) findViewById16;
        View findViewById17 = findViewById(R.id.timeline_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(...)");
        this.timelineLayout = (LinearLayout) findViewById17;
        View findViewById18 = findViewById(R.id.current_program_title);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(...)");
        this.currentProgramTitle = (TextView) findViewById18;
        View findViewById19 = findViewById(R.id.epg_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "findViewById(...)");
        this.epgProgressBar = (SeekBar) findViewById19;
        View findViewById20 = findViewById(R.id.vod_seek_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "findViewById(...)");
        this.vodSeekProgress = (ProgressBar) findViewById20;
        RecyclerView recyclerView4 = this.epgList;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgList");
            recyclerView4 = null;
        }
        recyclerView4.setLayoutManager(new LinearLayoutManager(playbackActivity));
        RecyclerView recyclerView5 = this.epgList;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgList");
            recyclerView5 = null;
        }
        recyclerView5.setItemViewCacheSize(20);
        SeekBar seekBar = this.epgProgressBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgProgressBar");
            seekBar = null;
        }
        seekBar.setOnSeekBarChangeListener(new PlaybackActivity$onCreate$3(this));
        View findViewById21 = findViewById(R.id.btn_play_pause_center);
        if (findViewById21 != null) {
            findViewById21.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.onCreate$lambda$5(PlaybackActivity.this, view);
                }
            });
        }
        View findViewById22 = findViewById(R.id.btn_prev_center);
        if (findViewById22 != null) {
            findViewById22.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.onCreate$lambda$8(PlaybackActivity.this, view);
                }
            });
        }
        View findViewById23 = findViewById(R.id.btn_next_center);
        if (findViewById23 != null) {
            findViewById23.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.onCreate$lambda$11(PlaybackActivity.this, view);
                }
            });
        }
        View findViewById24 = findViewById(R.id.gesture_feedback_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "findViewById(...)");
        this.gestureFeedback = findViewById24;
        View findViewById25 = findViewById(R.id.seek_center_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "findViewById(...)");
        this.gestureIcon = (ImageView) findViewById25;
        View findViewById26 = findViewById(R.id.seek_center_text);
        Intrinsics.checkNotNullExpressionValue(findViewById26, "findViewById(...)");
        this.gestureText = (TextView) findViewById26;
        View findViewById27 = findViewById(R.id.hud_left);
        Intrinsics.checkNotNullExpressionValue(findViewById27, "findViewById(...)");
        this.hudLeft = findViewById27;
        View findViewById28 = findViewById(R.id.pb_brightness);
        Intrinsics.checkNotNullExpressionValue(findViewById28, "findViewById(...)");
        this.pbBrightness = (ProgressBar) findViewById28;
        View findViewById29 = findViewById(R.id.hud_right);
        Intrinsics.checkNotNullExpressionValue(findViewById29, "findViewById(...)");
        this.hudRight = findViewById29;
        View findViewById30 = findViewById(R.id.pb_volume);
        Intrinsics.checkNotNullExpressionValue(findViewById30, "findViewById(...)");
        this.pbVolume = (ProgressBar) findViewById30;
        View findViewById31 = findViewById(R.id.lock_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById31, "findViewById(...)");
        this.lockOverlay = findViewById31;
        View findViewById32 = findViewById(R.id.btn_unlock);
        Intrinsics.checkNotNullExpressionValue(findViewById32, "findViewById(...)");
        this.btnUnlock = (ImageButton) findViewById32;
        View findViewById33 = findViewById(R.id.channel_number_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById33, "findViewById(...)");
        this.channelNumberOverlay = (LinearLayout) findViewById33;
        View findViewById34 = findViewById(R.id.channel_number_text);
        Intrinsics.checkNotNullExpressionValue(findViewById34, "findViewById(...)");
        this.channelNumberText = (TextView) findViewById34;
        findViewById(R.id.btn_lock).setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackActivity.onCreate$lambda$12(PlaybackActivity.this, view);
            }
        });
        ImageButton imageButton = this.btnUnlock;
        if (imageButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnUnlock");
            imageButton = null;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlaybackActivity.this.toggleLock(false);
            }
        });
        View findViewById35 = findViewById(R.id.btn_channels);
        if (findViewById35 != null) {
            findViewById35.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.this.showOverlay();
                }
            });
        }
        View findViewById36 = findViewById(R.id.btn_back);
        if (findViewById36 != null) {
            findViewById36.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.this.exitPlayback();
                }
            });
        }
        View findViewById37 = findViewById(R.id.btn_epg);
        if (findViewById37 != null) {
            findViewById37.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda15
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.this.showEpg();
                }
            });
        }
        View findViewById38 = findViewById(R.id.btn_voice_search);
        if (findViewById38 != null) {
            findViewById38.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda16
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.this.startVoiceSearch();
                }
            });
        }
        View findViewById39 = findViewById(R.id.btn_quality);
        if (findViewById39 != null) {
            findViewById39.setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda52
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.onCreate$lambda$18(PlaybackActivity.this, view);
                }
            });
        }
        View findViewById40 = findViewById(R.id.audio_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById40, "findViewById(...)");
        this.audioOverlay = (RelativeLayout) findViewById40;
        View findViewById41 = findViewById(R.id.audio_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById41, "findViewById(...)");
        this.audioLogo = (ImageView) findViewById41;
        View findViewById42 = findViewById(R.id.audio_bg_image);
        Intrinsics.checkNotNullExpressionValue(findViewById42, "findViewById(...)");
        this.audioBgImage = (ImageView) findViewById42;
        View findViewById43 = findViewById(R.id.audio_channel_name);
        Intrinsics.checkNotNullExpressionValue(findViewById43, "findViewById(...)");
        this.audioName = (TextView) findViewById43;
        View findViewById44 = findViewById(R.id.audio_channel_category);
        Intrinsics.checkNotNullExpressionValue(findViewById44, "findViewById(...)");
        this.audioCategory = (TextView) findViewById44;
        View findViewById45 = findViewById(R.id.audio_glow);
        Intrinsics.checkNotNullExpressionValue(findViewById45, "findViewById(...)");
        this.audioGlow = findViewById45;
        for (int i = 1; i < 9; i++) {
            View findViewById46 = findViewById(getResources().getIdentifier("eq_bar_" + i, TtmlNode.ATTR_ID, getPackageName()));
            if (findViewById46 != null) {
                this.eqBars.add(findViewById46);
            }
        }
        Serializable serializableExtra = getIntent().getSerializableExtra(DetailsActivity.MOVIE);
        Movie movie = serializableExtra instanceof Movie ? (Movie) serializableExtra : null;
        this.currentMovie = movie;
        if (movie == null && (stringExtra = getIntent().getStringExtra("movie_url")) != null) {
            Iterator<T> it = MovieList.INSTANCE.getMovies().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((Movie) next).getVideoUrl(), stringExtra)) {
                    obj = next;
                    break;
                }
            }
            Movie movie2 = (Movie) obj;
            this.currentMovie = movie2;
            if (movie2 == null) {
                this.currentMovie = new Movie(getIntent().getLongExtra("movie_id", 0L), getIntent().getStringExtra("movie_title"), null, null, null, stringExtra, null, getIntent().getStringExtra("movie_category"), getIntent().getStringExtra("movie_drm_url"), getIntent().getStringExtra("movie_clearkey"), getIntent().getStringExtra("movie_drm_type"), null, getIntent().getStringExtra("movie_ua"), getIntent().getStringExtra("movie_referrer"), null, 18524, null);
                Log.d("PlaybackActivity", "Tạo movie tạm đầy đủ từ intent extras cho URL: " + stringExtra);
            }
        }
        List<Movie> movies = MovieList.INSTANCE.getMovies();
        this.allChannels = movies;
        if (movies.isEmpty()) {
            MovieList.INSTANCE.getMovies(new Function1() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return PlaybackActivity.onCreate$lambda$23(PlaybackActivity.this, (List) obj2);
                }
            });
        }
        Movie movie3 = this.currentMovie;
        if (movie3 != null) {
            MovieList.INSTANCE.addToHistory(playbackActivity, movie3);
            showChannelInfo(movie3);
        }
        setupChannelList();
        updateAudioOverlay(this.currentMovie);
        View findViewById47 = findViewById(R.id.video_fragment_container);
        Intrinsics.checkNotNullExpressionValue(findViewById47, "findViewById(...)");
        this.videoContainer = findViewById47;
        findViewById(R.id.gesture_overlay).setOnTouchListener(new View.OnTouchListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PlaybackActivity.onCreate$lambda$26(PlaybackActivity.this, view, motionEvent);
            }
        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.video_fragment_container, new PlaybackVideoFragment()).commitAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$2(final PlaybackActivity playbackActivity) {
        playbackActivity.runOnUiThread(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.onCreate$lambda$2$lambda$1(PlaybackActivity.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$2$lambda$1(PlaybackActivity playbackActivity) {
        ChannelAdapter channelAdapter = playbackActivity.channelAdapter;
        if (channelAdapter != null) {
            channelAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$5(final PlaybackActivity playbackActivity, View view) {
        Fragment findFragmentById = playbackActivity.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if (playbackVideoFragment != null) {
            playbackVideoFragment.togglePlayPause();
        }
        playbackActivity.updateCenterControlsState();
        Runnable runnable = playbackActivity.hideInfoRunnable;
        if (runnable != null) {
            playbackActivity.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda40
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.this.hideChannelInfo();
            }
        };
        playbackActivity.hideInfoRunnable = runnable2;
        Handler handler = playbackActivity.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$8(final PlaybackActivity playbackActivity, View view) {
        playbackActivity.switchToAdjacentChannel(false);
        Runnable runnable = playbackActivity.hideInfoRunnable;
        if (runnable != null) {
            playbackActivity.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda37
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.this.hideChannelInfo();
            }
        };
        playbackActivity.hideInfoRunnable = runnable2;
        Handler handler = playbackActivity.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$11(final PlaybackActivity playbackActivity, View view) {
        playbackActivity.switchToAdjacentChannel(true);
        Runnable runnable = playbackActivity.hideInfoRunnable;
        if (runnable != null) {
            playbackActivity.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.this.hideChannelInfo();
            }
        };
        playbackActivity.hideInfoRunnable = runnable2;
        Handler handler = playbackActivity.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$12(PlaybackActivity playbackActivity, View view) {
        playbackActivity.toggleLock(true);
        playbackActivity.hideOverlay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$18(PlaybackActivity playbackActivity, View view) {
        Fragment findFragmentById = playbackActivity.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if (playbackVideoFragment != null) {
            playbackVideoFragment.showQualitySelector();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCreate$lambda$23(final PlaybackActivity playbackActivity, final List channels) {
        Intrinsics.checkNotNullParameter(channels, "channels");
        playbackActivity.runOnUiThread(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.onCreate$lambda$23$lambda$22(PlaybackActivity.this, channels);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$23$lambda$22(PlaybackActivity playbackActivity, List list) {
        Object obj;
        ExoPlayer exoPlayer;
        playbackActivity.allChannels = list;
        playbackActivity.setupChannelList();
        Movie movie = playbackActivity.currentMovie;
        if (movie != null) {
            Intrinsics.checkNotNull(movie);
            if (movie.getVideoUrl() != null) {
                Iterator<T> it = playbackActivity.allChannels.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    String videoUrl = ((Movie) obj).getVideoUrl();
                    Movie movie2 = playbackActivity.currentMovie;
                    Intrinsics.checkNotNull(movie2);
                    if (Intrinsics.areEqual(videoUrl, movie2.getVideoUrl())) {
                        break;
                    }
                }
                Movie movie3 = (Movie) obj;
                if (movie3 != null) {
                    playbackActivity.currentMovie = movie3;
                    playbackActivity.getIntent().putExtra(DetailsActivity.MOVIE, movie3);
                    playbackActivity.updateAudioOverlay(movie3);
                    Fragment findFragmentById = playbackActivity.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
                    PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
                    boolean z = false;
                    if (playbackVideoFragment != null && (exoPlayer = playbackVideoFragment.getExoPlayer()) != null && exoPlayer.isPlaying()) {
                        z = true;
                    }
                    playbackActivity.setAudioOverlayPlaybackState(z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean onCreate$lambda$26(final PlaybackActivity playbackActivity, View view, MotionEvent motionEvent) {
        GestureDetector gestureDetector = null;
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (playbackActivity.isSeeking) {
                Fragment findFragmentById = playbackActivity.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
                PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
                if (playbackVideoFragment != null) {
                    playbackVideoFragment.seekTo(playbackActivity.pendingSeekPosition);
                }
                playbackActivity.isSeeking = false;
                playbackActivity.handler.postDelayed(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda18
                    @Override // java.lang.Runnable
                    public final void run() {
                        PlaybackActivity.onCreate$lambda$26$lambda$25(PlaybackActivity.this);
                    }
                }, 1000L);
            }
            playbackActivity.isGestureStarted = false;
            playbackActivity.activeGestureType = 0;
            playbackActivity.hideHUDs();
        }
        if (!playbackActivity.isLocked) {
            GestureDetector gestureDetector2 = playbackActivity.gestureDetector;
            if (gestureDetector2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
            } else {
                gestureDetector = gestureDetector2;
            }
            gestureDetector.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void onCreate$lambda$26$lambda$25(PlaybackActivity playbackActivity) {
        View view = playbackActivity.gestureFeedback;
        ProgressBar progressBar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureFeedback");
            view = null;
        }
        view.setVisibility(8);
        View findViewById = playbackActivity.findViewById(R.id.seek_left_layout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = playbackActivity.findViewById(R.id.seek_right_layout);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        View findViewById3 = playbackActivity.findViewById(R.id.seek_center_layout);
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
        ProgressBar progressBar2 = playbackActivity.vodSeekProgress;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vodSeekProgress");
        } else {
            progressBar = progressBar2;
        }
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.view.View] */
    public final void toggleLock(boolean lock) {
        this.isLocked = lock;
        ImageButton imageButton = null;
        if (lock) {
            Toast.makeText(this, "Đã khóa cảm ứng", 0).show();
            View view = this.lockOverlay;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lockOverlay");
                view = null;
            }
            view.setVisibility(0);
            ImageButton imageButton2 = this.btnUnlock;
            if (imageButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnUnlock");
                imageButton2 = null;
            }
            imageButton2.setVisibility(0);
            ImageButton imageButton3 = this.btnUnlock;
            if (imageButton3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnUnlock");
            } else {
                imageButton = imageButton3;
            }
            imageButton.setAlpha(1.0f);
            return;
        }
        Toast.makeText(this, "Đã mở khóa", 0).show();
        ?? r5 = this.lockOverlay;
        if (r5 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("lockOverlay");
        } else {
            imageButton = r5;
        }
        imageButton.setVisibility(8);
        showOverlay();
    }

    private final void setupGestures() {
        this.gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() { // from class: com.tvstore.ok.PlaybackActivity$setupGestures$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                LinearLayout linearLayout;
                boolean z;
                Movie movie;
                Intrinsics.checkNotNullParameter(e, "e");
                linearLayout = PlaybackActivity.this.channelInfoPopup;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
                    linearLayout = null;
                }
                int visibility = linearLayout.getVisibility();
                PlaybackActivity playbackActivity = PlaybackActivity.this;
                if (visibility != 0) {
                    z = playbackActivity.isOverlayVisible;
                    PlaybackActivity playbackActivity2 = PlaybackActivity.this;
                    if (z) {
                        playbackActivity2.hideOverlay();
                        return true;
                    }
                    movie = playbackActivity2.currentMovie;
                    if (movie == null) {
                        return true;
                    }
                    PlaybackActivity.this.showChannelInfo(movie);
                    return true;
                }
                playbackActivity.hideChannelInfo();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                float f;
                float f2;
                long j;
                int i;
                int i2;
                int i3;
                Intrinsics.checkNotNullParameter(e, "e");
                f = PlaybackActivity.this.currentZoomX;
                if (f <= 1.01f) {
                    f2 = PlaybackActivity.this.currentZoomY;
                    if (f2 <= 1.01f) {
                        int i4 = PlaybackActivity.this.getResources().getDisplayMetrics().widthPixels;
                        Fragment findFragmentById = PlaybackActivity.this.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
                        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean z = e.getX() < ((float) (i4 / 2));
                        j = PlaybackActivity.this.lastDoubleTapTime;
                        long j2 = currentTimeMillis - j;
                        PlaybackActivity playbackActivity = PlaybackActivity.this;
                        if (j2 < 1500) {
                            i3 = playbackActivity.accumulatedSeekSeconds;
                            playbackActivity.accumulatedSeekSeconds = i3 + 10;
                        } else {
                            playbackActivity.accumulatedSeekSeconds = 10;
                        }
                        PlaybackActivity.this.lastDoubleTapTime = currentTimeMillis;
                        if (z) {
                            if (playbackVideoFragment != null) {
                                playbackVideoFragment.seekRelative(-10000L);
                            }
                            PlaybackActivity playbackActivity2 = PlaybackActivity.this;
                            int i5 = R.drawable.ic_fast_rewind;
                            i2 = PlaybackActivity.this.accumulatedSeekSeconds;
                            playbackActivity2.showGestureFeedback(i5, "-" + i2 + CmcdData.Factory.STREAMING_FORMAT_SS);
                        } else {
                            if (playbackVideoFragment != null) {
                                playbackVideoFragment.seekRelative(Renderer.DEFAULT_DURATION_TO_PROGRESS_US);
                            }
                            PlaybackActivity playbackActivity3 = PlaybackActivity.this;
                            int i6 = R.drawable.ic_fast_forward;
                            i = PlaybackActivity.this.accumulatedSeekSeconds;
                            playbackActivity3.showGestureFeedback(i6, "+" + i + CmcdData.Factory.STREAMING_FORMAT_SS);
                        }
                        return true;
                    }
                }
                PlaybackActivity.resetZoom$default(PlaybackActivity.this, false, 1, null);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                float f;
                float f2;
                boolean z;
                int i;
                AudioManager audioManager;
                Intrinsics.checkNotNullParameter(e2, "e2");
                if (e1 == null) {
                    return false;
                }
                f = PlaybackActivity.this.currentZoomX;
                if (f <= 1.01f) {
                    f2 = PlaybackActivity.this.currentZoomY;
                    if (f2 <= 1.01f) {
                        float x = e2.getX() - e1.getX();
                        float y = e1.getY() - e2.getY();
                        z = PlaybackActivity.this.isGestureStarted;
                        if (z) {
                            i = PlaybackActivity.this.activeGestureType;
                            if (i == 1) {
                                PlaybackActivity.this.handleSeekGesture(x);
                            } else if (i == 2) {
                                float x2 = e1.getX();
                                float f3 = PlaybackActivity.this.getResources().getDisplayMetrics().widthPixels / 2;
                                PlaybackActivity playbackActivity = PlaybackActivity.this;
                                if (x2 > f3) {
                                    playbackActivity.handleVolumeGesture(y);
                                } else {
                                    playbackActivity.handleBrightnessGesture(y);
                                }
                            }
                            return true;
                        }
                        if (Math.abs(x) > 30.0f || Math.abs(y) > 30.0f) {
                            PlaybackActivity.this.isGestureStarted = true;
                            PlaybackActivity.this.activeGestureType = Math.abs(x) > Math.abs(y) ? 1 : 2;
                            PlaybackActivity playbackActivity2 = PlaybackActivity.this;
                            audioManager = playbackActivity2.audioManager;
                            if (audioManager == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("audioManager");
                                audioManager = null;
                            }
                            playbackActivity2.initialVolume = audioManager.getStreamVolume(3);
                            WindowManager.LayoutParams attributes = PlaybackActivity.this.getWindow().getAttributes();
                            PlaybackActivity.this.initialBrightness = attributes.screenBrightness < 0.0f ? 0.5f : attributes.screenBrightness;
                        }
                        return true;
                    }
                }
                PlaybackActivity.this.handlePanGesture(distanceX, distanceY);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleVolumeGesture(float totalDeltaY) {
        AudioManager audioManager = this.audioManager;
        ProgressBar progressBar = null;
        if (audioManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            audioManager = null;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        AudioManager audioManager2 = this.audioManager;
        if (audioManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            audioManager2 = null;
        }
        audioManager2.getStreamVolume(3);
        int coerceIn = RangesKt.coerceIn(this.initialVolume + ((int) ((totalDeltaY / getResources().getDisplayMetrics().heightPixels) * streamMaxVolume * 0.5f)), 0, streamMaxVolume);
        AudioManager audioManager3 = this.audioManager;
        if (audioManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioManager");
            audioManager3 = null;
        }
        audioManager3.setStreamVolume(3, coerceIn, 0);
        View view = this.hudRight;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hudRight");
            view = null;
        }
        view.setVisibility(0);
        ProgressBar progressBar2 = this.pbVolume;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbVolume");
            progressBar2 = null;
        }
        progressBar2.setMax(streamMaxVolume);
        ProgressBar progressBar3 = this.pbVolume;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbVolume");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setProgress(coerceIn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleBrightnessGesture(float totalDeltaY) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        float coerceIn = RangesKt.coerceIn(this.initialBrightness + ((totalDeltaY / getResources().getDisplayMetrics().heightPixels) * 0.5f), 0.01f, 1.0f);
        attributes.screenBrightness = coerceIn;
        getWindow().setAttributes(attributes);
        View view = this.hudLeft;
        ProgressBar progressBar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hudLeft");
            view = null;
        }
        view.setVisibility(0);
        ProgressBar progressBar2 = this.pbBrightness;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbBrightness");
            progressBar2 = null;
        }
        progressBar2.setMax(100);
        ProgressBar progressBar3 = this.pbBrightness;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbBrightness");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setProgress((int) (coerceIn * 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSeekGesture(float deltaX) {
        Movie movie;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        ProgressBar progressBar = null;
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if (playbackVideoFragment == null || playbackVideoFragment.isLiveStream()) {
            return;
        }
        long duration = playbackVideoFragment.getDuration();
        if (duration <= 0) {
            return;
        }
        this.isSeeking = true;
        LinearLayout linearLayout = this.channelInfoPopup;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
            linearLayout = null;
        }
        if (linearLayout.getVisibility() != 0 && (movie = this.currentMovie) != null) {
            showChannelInfo(movie);
        }
        long j = (deltaX / getResources().getDisplayMetrics().widthPixels) * 300.0f;
        long coerceIn = RangesKt.coerceIn((1000 * j) + playbackVideoFragment.getPosition(), 0L, duration);
        this.pendingSeekPosition = coerceIn;
        int i = (int) ((coerceIn * 100) / duration);
        ProgressBar progressBar2 = this.vodSeekProgress;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vodSeekProgress");
            progressBar2 = null;
        }
        progressBar2.setVisibility(0);
        ProgressBar progressBar3 = this.vodSeekProgress;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vodSeekProgress");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setProgress(i);
        showGestureFeedback(deltaX > 0.0f ? R.drawable.ic_fast_forward : R.drawable.ic_fast_rewind, (formatMillis(this.pendingSeekPosition) + " / " + formatMillis(duration)) + " (" + (j > 0 ? "+" : "") + j + "s)");
    }

    private final void hideHUDs() {
        this.handler.postDelayed(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.hideHUDs$lambda$29(PlaybackActivity.this);
            }
        }, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideHUDs$lambda$29(PlaybackActivity playbackActivity) {
        View view = playbackActivity.hudLeft;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hudLeft");
            view = null;
        }
        view.setVisibility(8);
        View view3 = playbackActivity.hudRight;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hudRight");
        } else {
            view2 = view3;
        }
        view2.setVisibility(8);
    }

    private final void applyZoomTransform() {
        View view = this.videoContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view = null;
        }
        view.setScaleX(this.currentZoomX);
        View view3 = this.videoContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view3 = null;
        }
        view3.setScaleY(this.currentZoomY);
        View view4 = this.videoContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view4 = null;
        }
        view4.setTranslationX(this.panX);
        View view5 = this.videoContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        } else {
            view2 = view5;
        }
        view2.setTranslationY(this.panY);
    }

    private final void clampPan() {
        if (this.currentZoomX <= 1.0f && this.currentZoomY <= 1.0f) {
            this.panX = 0.0f;
            this.panY = 0.0f;
            return;
        }
        float f = getResources().getDisplayMetrics().widthPixels;
        float f2 = getResources().getDisplayMetrics().heightPixels;
        float f3 = this.currentZoomX;
        float f4 = f3 > 1.0f ? (f * (f3 - 1.0f)) / 2.0f : 0.0f;
        float f5 = this.currentZoomY;
        float f6 = f5 > 1.0f ? (f2 * (f5 - 1.0f)) / 2.0f : 0.0f;
        this.panX = RangesKt.coerceIn(this.panX, -f4, f4);
        this.panY = RangesKt.coerceIn(this.panY, -f6, f6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePanGesture(float distanceX, float distanceY) {
        this.panX -= distanceX;
        this.panY -= distanceY;
        clampPan();
        applyZoomTransform();
    }

    public static /* synthetic */ void resetZoom$default(PlaybackActivity playbackActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        playbackActivity.resetZoom(z);
    }

    public final void resetZoom(boolean showFeedback) {
        this.isManualZoom = false;
        View view = this.videoContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view = null;
        }
        view.animate().scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setDuration(250L).withEndAction(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.resetZoom$lambda$30(PlaybackActivity.this);
            }
        }).start();
        if (showFeedback) {
            Toast.makeText(this, "🔍 Tỉ lệ: 100%", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void resetZoom$lambda$30(PlaybackActivity playbackActivity) {
        playbackActivity.currentZoomX = 1.0f;
        playbackActivity.currentZoomY = 1.0f;
        playbackActivity.panX = 0.0f;
        playbackActivity.panY = 0.0f;
    }

    public final void resetZoomHard() {
        this.isManualZoom = false;
        View view = this.videoContainer;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view = null;
        }
        view.animate().cancel();
        View view3 = this.videoContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view3 = null;
        }
        view3.setScaleX(1.0f);
        View view4 = this.videoContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view4 = null;
        }
        view4.setScaleY(1.0f);
        View view5 = this.videoContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view5 = null;
        }
        view5.setTranslationX(0.0f);
        View view6 = this.videoContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        } else {
            view2 = view6;
        }
        view2.setTranslationY(0.0f);
        this.currentZoomX = 1.0f;
        this.currentZoomY = 1.0f;
        this.panX = 0.0f;
        this.panY = 0.0f;
    }

    public final void setZoom(float scale, int axis) {
        this.isManualZoom = true;
        if (axis == 1) {
            this.currentZoomX = RangesKt.coerceIn(scale, 0.5f, 3.0f);
        } else if (axis == 2) {
            this.currentZoomY = RangesKt.coerceIn(scale, 0.5f, 3.0f);
        } else {
            this.currentZoomX = RangesKt.coerceIn(scale, 0.5f, 3.0f);
            this.currentZoomY = RangesKt.coerceIn(scale, 0.5f, 3.0f);
        }
        clampPan();
        View view = this.videoContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view = null;
        }
        view.animate().scaleX(this.currentZoomX).scaleY(this.currentZoomY).translationX(this.panX).translationY(this.panY).setDuration(80L).start();
    }

    public final void applyPresetAspectMode(int modeIndex) {
        int i;
        int i2;
        float f;
        float f2;
        String str;
        this.currentPresetMode = modeIndex;
        this.isManualZoom = false;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        View view = null;
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if (playbackVideoFragment != null) {
            playbackVideoFragment.setResizeModeFit();
        }
        if (playbackVideoFragment != null) {
            playbackVideoFragment.setCurrentModeIndex$app(modeIndex);
        }
        if (modeIndex == 0) {
            resetZoomHard();
            Toast.makeText(this, "⏹️ Chế độ: Chuẩn (Fit)", 0).show();
            return;
        }
        int videoWidth = playbackVideoFragment != null ? playbackVideoFragment.getVideoWidth() : 16;
        int videoHeight = playbackVideoFragment != null ? playbackVideoFragment.getVideoHeight() : 9;
        int i3 = videoWidth > 0 ? videoWidth : 16;
        int i4 = videoHeight > 0 ? videoHeight : 9;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        View view2 = this.videoContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view2 = null;
        }
        if (view2.getWidth() > 0) {
            View view3 = this.videoContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
                view3 = null;
            }
            i = view3.getWidth();
        } else {
            i = displayMetrics.widthPixels;
        }
        float f3 = i;
        View view4 = this.videoContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
            view4 = null;
        }
        if (view4.getHeight() > 0) {
            View view5 = this.videoContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
                view5 = null;
            }
            i2 = view5.getHeight();
        } else {
            i2 = displayMetrics.heightPixels;
        }
        float f4 = f3 / i2;
        float f5 = i3 / i4;
        if (modeIndex != 1) {
            f = 1.0f;
            if (modeIndex == 2) {
                if (f5 < f4) {
                    f = f4 / f5;
                } else {
                    f2 = f5 / f4;
                }
            }
            f2 = 1.0f;
        } else {
            f = f5 < f4 ? f4 / f5 : f5 / f4;
            f2 = f;
        }
        this.currentZoomX = f;
        this.currentZoomY = f2;
        this.panX = 0.0f;
        this.panY = 0.0f;
        View view6 = this.videoContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
        } else {
            view = view6;
        }
        view.animate().scaleX(this.currentZoomX).scaleY(this.currentZoomY).translationX(this.panX).translationY(this.panY).setDuration(150L).start();
        if (modeIndex == 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str = "🔍 Phóng to (Zoom) ×" + format;
        } else if (modeIndex == 2) {
            str = "⇔ Kéo giãn (Fill)";
        } else {
            str = "Chuẩn (Fit)";
        }
        Toast.makeText(this, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String formatMillis(long ms) {
        long j = ms / 1000;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j / 3600), Long.valueOf((j % 3600) / 60), Long.valueOf(j % 60)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showGestureFeedback(int iconRes, String text) {
        View view = this.gestureFeedback;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureFeedback");
            view = null;
        }
        view.setVisibility(0);
        View findViewById = findViewById(R.id.seek_left_layout);
        View findViewById2 = findViewById(R.id.seek_right_layout);
        View findViewById3 = findViewById(R.id.seek_center_layout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
        if (iconRes == R.drawable.ic_fast_rewind) {
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            TextView textView = (TextView) findViewById(R.id.seek_left_text);
            if (textView != null) {
                textView.setText(text);
            }
        } else if (iconRes == R.drawable.ic_fast_forward) {
            if (findViewById2 != null) {
                findViewById2.setVisibility(0);
            }
            TextView textView2 = (TextView) findViewById(R.id.seek_right_text);
            if (textView2 != null) {
                textView2.setText(text);
            }
        } else {
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
            ImageView imageView = (ImageView) findViewById(R.id.seek_center_icon);
            if (imageView != null) {
                imageView.setImageResource(iconRes);
            }
            TextView textView3 = (TextView) findViewById(R.id.seek_center_text);
            if (textView3 != null) {
                textView3.setText(text);
            }
        }
        this.handler.removeCallbacks(this.hideGestureRunnable);
        this.handler.postDelayed(this.hideGestureRunnable, 1500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideGestureRunnable$lambda$31(PlaybackActivity playbackActivity) {
        if (playbackActivity.isSeeking) {
            return;
        }
        View view = playbackActivity.gestureFeedback;
        ProgressBar progressBar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureFeedback");
            view = null;
        }
        view.setVisibility(8);
        View findViewById = playbackActivity.findViewById(R.id.seek_left_layout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = playbackActivity.findViewById(R.id.seek_right_layout);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        View findViewById3 = playbackActivity.findViewById(R.id.seek_center_layout);
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
        ProgressBar progressBar2 = playbackActivity.vodSeekProgress;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vodSeekProgress");
        } else {
            progressBar = progressBar2;
        }
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isTvDevice(Context context) {
        Object systemService = context.getSystemService("uimode");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
        return ((UiModeManager) systemService).getCurrentModeType() == 4;
    }

    private final void setupChannelList() {
        List<Movie> movies = MovieList.INSTANCE.getMovies();
        this.allChannels = movies;
        if (movies.isEmpty() || this.currentMovie == null) {
            return;
        }
        List<Movie> list = this.allChannels;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            String category = ((Movie) it.next()).getCategory();
            if (category != null) {
                arrayList.add(category);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!StringsKt.isBlank((String) obj)) {
                arrayList2.add(obj);
            }
        }
        this.categories = CollectionsKt.plus((Collection) CollectionsKt.listOf((Object[]) new String[]{"Tất cả", "❤️ Yêu thích"}), (Iterable) CollectionsKt.distinct(arrayList2));
        this.categoryAdapter = new CategoryAdapter(this.categories, this.activeCategory, new Function1() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PlaybackActivity.setupChannelList$lambda$36(PlaybackActivity.this, (String) obj2);
            }
        });
        RecyclerView recyclerView = this.categoryList;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            recyclerView = null;
        }
        recyclerView.setAdapter(this.categoryAdapter);
        List<Movie> filteredChannels = getFilteredChannels();
        Movie movie = this.currentMovie;
        Intrinsics.checkNotNull(movie);
        this.channelAdapter = new ChannelAdapter(filteredChannels, movie.getId(), this.allChannels, new Function1() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PlaybackActivity.setupChannelList$lambda$37(PlaybackActivity.this, (Movie) obj2);
            }
        }, new Function1() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return PlaybackActivity.setupChannelList$lambda$38(PlaybackActivity.this, (Movie) obj2);
            }
        });
        RecyclerView recyclerView3 = this.channelList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelList");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(this.channelAdapter);
        RecyclerView recyclerView4 = this.channelList;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelList");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setOnTouchListener(new View.OnTouchListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda27
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PlaybackActivity.setupChannelList$lambda$39(PlaybackActivity.this, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit setupChannelList$lambda$36(final PlaybackActivity playbackActivity, String selectedCategory) {
        Intrinsics.checkNotNullParameter(selectedCategory, "selectedCategory");
        playbackActivity.activeCategory = selectedCategory;
        playbackActivity.lastSelectedCategory = selectedCategory;
        CategoryAdapter categoryAdapter = playbackActivity.categoryAdapter;
        if (categoryAdapter != null) {
            categoryAdapter.notifyDataSetChanged();
        }
        playbackActivity.filterChannelList();
        playbackActivity.scrollCategoryToCenter(selectedCategory);
        RecyclerView recyclerView = playbackActivity.channelList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelList");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda46
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.setupChannelList$lambda$36$lambda$35(PlaybackActivity.this);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupChannelList$lambda$36$lambda$35(final PlaybackActivity playbackActivity) {
        ChannelAdapter channelAdapter = playbackActivity.channelAdapter;
        if ((channelAdapter != null ? channelAdapter.getItemCount() : 0) > 0) {
            RecyclerView recyclerView = playbackActivity.channelList;
            RecyclerView recyclerView2 = null;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelList");
                recyclerView = null;
            }
            recyclerView.scrollToPosition(0);
            RecyclerView recyclerView3 = playbackActivity.channelList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelList");
            } else {
                recyclerView2 = recyclerView3;
            }
            recyclerView2.post(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda28
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackActivity.setupChannelList$lambda$36$lambda$35$lambda$34(PlaybackActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void setupChannelList$lambda$36$lambda$35$lambda$34(PlaybackActivity playbackActivity) {
        View view;
        RecyclerView recyclerView = playbackActivity.channelList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelList");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(0);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit setupChannelList$lambda$37(PlaybackActivity playbackActivity, Movie selectedChannel) {
        Intrinsics.checkNotNullParameter(selectedChannel, "selectedChannel");
        playbackActivity.hideOverlay();
        switchChannel$default(playbackActivity, selectedChannel, false, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit setupChannelList$lambda$38(PlaybackActivity playbackActivity, Movie channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        PlaybackActivity playbackActivity2 = playbackActivity;
        Toast.makeText(playbackActivity2, MovieList.INSTANCE.toggleFavorite(playbackActivity2, channel) ? "❤️ Đã thêm" : "💔 Đã xóa", 0).show();
        ChannelAdapter channelAdapter = playbackActivity.channelAdapter;
        if (channelAdapter != null) {
            channelAdapter.notifyDataSetChanged();
        }
        if (Intrinsics.areEqual(playbackActivity.activeCategory, "❤️ Yêu thích")) {
            playbackActivity.filterChannelList();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean setupChannelList$lambda$39(PlaybackActivity playbackActivity, View view, MotionEvent motionEvent) {
        playbackActivity.resetHideOverlayTimer();
        return false;
    }

    private final List<Movie> getFilteredChannels() {
        String str = this.activeCategory;
        if (Intrinsics.areEqual(str, "Tất cả")) {
            return this.allChannels;
        }
        boolean areEqual = Intrinsics.areEqual(str, "❤️ Yêu thích");
        List<Movie> list = this.allChannels;
        if (areEqual) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (MovieList.INSTANCE.isFavorite((Movie) obj)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list) {
            if (Intrinsics.areEqual(((Movie) obj2).getCategory(), this.activeCategory)) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    private final void filterChannelList() {
        List<Movie> filteredChannels = getFilteredChannels();
        ChannelAdapter channelAdapter = this.channelAdapter;
        if (channelAdapter != null) {
            channelAdapter.updateData(filteredChannels);
        }
    }

    private final void scrollCategoryToCenter(String category) {
        final int indexOf = this.categories.indexOf(category);
        if (indexOf < 0) {
            return;
        }
        RecyclerView recyclerView = this.categoryList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            recyclerView = null;
        }
        recyclerView.post(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.scrollCategoryToCenter$lambda$43(PlaybackActivity.this, indexOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void scrollCategoryToCenter$lambda$43(final PlaybackActivity playbackActivity, final int i) {
        RecyclerView recyclerView = playbackActivity.categoryList;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            recyclerView = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        final LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return;
        }
        View findViewByPosition = linearLayoutManager.findViewByPosition(i);
        if (findViewByPosition != null) {
            int width = findViewByPosition.getWidth();
            RecyclerView recyclerView3 = playbackActivity.categoryList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            } else {
                recyclerView2 = recyclerView3;
            }
            linearLayoutManager.scrollToPositionWithOffset(i, (recyclerView2.getWidth() - width) / 2);
            return;
        }
        RecyclerView recyclerView4 = playbackActivity.categoryList;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            recyclerView4 = null;
        }
        recyclerView4.scrollToPosition(i);
        RecyclerView recyclerView5 = playbackActivity.categoryList;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
        } else {
            recyclerView2 = recyclerView5;
        }
        recyclerView2.post(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.scrollCategoryToCenter$lambda$43$lambda$42(LinearLayoutManager.this, i, playbackActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void scrollCategoryToCenter$lambda$43$lambda$42(LinearLayoutManager linearLayoutManager, int i, PlaybackActivity playbackActivity) {
        View findViewByPosition = linearLayoutManager.findViewByPosition(i);
        if (findViewByPosition == null) {
            return;
        }
        int width = findViewByPosition.getWidth();
        RecyclerView recyclerView = playbackActivity.categoryList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryList");
            recyclerView = null;
        }
        linearLayoutManager.scrollToPositionWithOffset(i, (recyclerView.getWidth() - width) / 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlaybackActivity.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u0012H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/tvstore/ok/PlaybackActivity$CategoryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tvstore/ok/PlaybackActivity$CategoryAdapter$ViewHolder;", "categories", "", "", "activeCategory", "onCategoryClick", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "updateActive", "category", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "holder", "position", "updateItemStyle", "textView", "Landroid/widget/TextView;", "isSelected", "", "hasFocus", "getItemCount", "ViewHolder", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes3.dex */
    public static final class CategoryAdapter extends RecyclerView.Adapter<ViewHolder> {
        private String activeCategory;
        private final List<String> categories;
        private final Function1<String, Unit> onCategoryClick;

        /* JADX WARN: Multi-variable type inference failed */
        public CategoryAdapter(List<String> categories, String activeCategory, Function1<? super String, Unit> onCategoryClick) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            Intrinsics.checkNotNullParameter(activeCategory, "activeCategory");
            Intrinsics.checkNotNullParameter(onCategoryClick, "onCategoryClick");
            this.categories = categories;
            this.activeCategory = activeCategory;
            this.onCategoryClick = onCategoryClick;
        }

        /* compiled from: PlaybackActivity.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/tvstore/ok/PlaybackActivity$CategoryAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "app"}, k = 1, mv = {2, 2, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes3.dex */
        public static final class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView name;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "view");
                View findViewById = view.findViewById(R.id.category_name);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.name = (TextView) findViewById;
            }

            public final TextView getName() {
                return this.name;
            }
        }

        public final void updateActive(String category) {
            Intrinsics.checkNotNullParameter(category, "category");
            this.activeCategory = category;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_playback_category, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new ViewHolder(inflate);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            final String str = this.categories.get(position);
            holder.getName().setText(str);
            updateItemStyle(holder.getName(), Intrinsics.areEqual(str, this.activeCategory), holder.getName().hasFocus());
            holder.getName().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tvstore.ok.PlaybackActivity$CategoryAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    r0.updateItemStyle(holder.getName(), Intrinsics.areEqual(str, PlaybackActivity.CategoryAdapter.this.activeCategory), z);
                }
            });
            holder.getName().setOnClickListener(new View.OnClickListener() { // from class: com.tvstore.ok.PlaybackActivity$CategoryAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlaybackActivity.CategoryAdapter.onBindViewHolder$lambda$1(PlaybackActivity.CategoryAdapter.this, str, view);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static final void onBindViewHolder$lambda$1(CategoryAdapter categoryAdapter, String str, View view) {
            categoryAdapter.activeCategory = str;
            categoryAdapter.notifyDataSetChanged();
            categoryAdapter.onCategoryClick.invoke(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void updateItemStyle(TextView textView, boolean isSelected, boolean hasFocus) {
            textView.getContext();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(32.0f);
            if (hasFocus) {
                gradientDrawable.setColor(Color.parseColor("#FF9800"));
                gradientDrawable.setStroke(4, -1);
                textView.setTextColor(-1);
            } else if (isSelected) {
                gradientDrawable.setColor(Color.parseColor("#FF9800"));
                textView.setTextColor(-1);
            } else {
                gradientDrawable.setColor(Color.parseColor("#33FFFFFF"));
                textView.setTextColor(Color.parseColor("#BBBBBB"));
            }
            textView.setBackground(gradientDrawable);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.categories.size();
        }
    }

    static /* synthetic */ void switchChannel$default(PlaybackActivity playbackActivity, Movie movie, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        playbackActivity.switchChannel(movie, z);
    }

    private final void switchChannel(Movie movie, boolean isFromDpad) {
        Movie movie2 = this.currentMovie;
        if (Intrinsics.areEqual(movie2 != null ? movie2.getVideoUrl() : null, movie.getVideoUrl())) {
            Toast.makeText(this, "Đang tải lại kênh...", 0).show();
        }
        this.currentMovie = movie;
        this.lastSelectedCategory = null;
        getIntent().putExtra(DetailsActivity.MOVIE, movie);
        MovieList.INSTANCE.addToHistory(this, movie);
        ChannelAdapter channelAdapter = this.channelAdapter;
        if (channelAdapter != null) {
            channelAdapter.updateCurrentChannel(movie.getId());
        }
        resetZoomHard();
        showChannelInfo(movie);
        getSupportFragmentManager().beginTransaction().replace(R.id.video_fragment_container, new PlaybackVideoFragment()).commitAllowingStateLoss();
        updateAudioOverlay(movie);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r0 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setAudioOverlayPlaybackState(boolean r7) {
        /*
            r6 = this;
            com.tvstore.ok.Movie r0 = r6.currentMovie
            if (r0 == 0) goto L17
            java.lang.String r0 = r0.getCategory()
            if (r0 == 0) goto L17
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            if (r0 != 0) goto L19
        L17:
            java.lang.String r0 = ""
        L19:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.String r1 = "radio"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default(r0, r1, r2, r3, r4)
            java.lang.String r5 = "audioOverlay"
            if (r1 != 0) goto L52
            java.lang.String r1 = "nhạc"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.contains$default(r0, r1, r2, r3, r4)
            if (r1 != 0) goto L52
            java.lang.String r1 = "music"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.contains$default(r0, r1, r2, r3, r4)
            if (r1 != 0) goto L52
            java.lang.String r1 = "audio"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = kotlin.text.StringsKt.contains$default(r0, r1, r2, r3, r4)
            if (r1 != 0) goto L52
            java.lang.String r1 = "nghe"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r0 = kotlin.text.StringsKt.contains$default(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L64
        L52:
            if (r7 == 0) goto L64
            android.widget.RelativeLayout r7 = r6.audioOverlay
            if (r7 != 0) goto L5c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L5d
        L5c:
            r4 = r7
        L5d:
            r4.setVisibility(r2)
            r6.startAudioAnimations()
            return
        L64:
            android.widget.RelativeLayout r7 = r6.audioOverlay
            if (r7 != 0) goto L6c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L6d
        L6c:
            r4 = r7
        L6d:
            r7 = 8
            r4.setVisibility(r7)
            r6.stopAudioAnimations()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.PlaybackActivity.setAudioOverlayPlaybackState(boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        if (r0 == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateAudioOverlay(com.tvstore.ok.Movie r7) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.PlaybackActivity.updateAudioOverlay(com.tvstore.ok.Movie):void");
    }

    private final void startAudioAnimations() {
        if (this.isAudioAnimating) {
            return;
        }
        this.isAudioAnimating = true;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_X, 1.0f, 1.2f);
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.SCALE_Y, 1.0f, 1.2f);
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat((Property<?, Float>) View.ALPHA, 0.6f, 1.0f);
        View view = this.audioGlow;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioGlow");
            view = null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, ofFloat, ofFloat2, ofFloat3);
        ofPropertyValuesHolder.setDuration(1500L);
        ofPropertyValuesHolder.setRepeatCount(-1);
        ofPropertyValuesHolder.setRepeatMode(2);
        ofPropertyValuesHolder.start();
        animateEqBars();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateEqBars() {
        if (this.isAudioAnimating) {
            Iterator<T> it = this.eqBars.iterator();
            while (it.hasNext()) {
                ((View) it.next()).animate().scaleY((this.random.nextFloat() * 1.25f) + 0.25f).setDuration(this.random.nextInt(300) + 200).withLayer().start();
            }
            this.handler.postDelayed(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda32
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackActivity.this.animateEqBars();
                }
            }, 500L);
        }
    }

    private final void stopAudioAnimations() {
        this.isAudioAnimating = false;
        View view = this.audioGlow;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioGlow");
            view = null;
        }
        view.animate().cancel();
        View view3 = this.audioGlow;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("audioGlow");
        } else {
            view2 = view3;
        }
        view2.clearAnimation();
        for (View view4 : this.eqBars) {
            view4.animate().cancel();
            view4.setScaleY(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showOverlay() {
        Movie movie;
        if (this.isOverlayVisible) {
            resetHideOverlayTimer();
            return;
        }
        if (this.isEpgVisible) {
            hideEpg();
        }
        List<Movie> movies = MovieList.INSTANCE.getMovies();
        this.allChannels = movies;
        if (movies.isEmpty()) {
            return;
        }
        if (this.channelAdapter == null) {
            setupChannelList();
        }
        String str = this.lastSelectedCategory;
        if (str == null && ((movie = this.currentMovie) == null || (str = movie.getCategory()) == null)) {
            str = "Tất cả";
        }
        String str2 = this.categories.contains(str) ? str : "Tất cả";
        this.activeCategory = str2;
        CategoryAdapter categoryAdapter = this.categoryAdapter;
        if (categoryAdapter != null) {
            categoryAdapter.updateActive(str2);
        }
        filterChannelList();
        scrollCategoryToCenter(this.activeCategory);
        this.isOverlayVisible = true;
        hideChannelInfo();
        LinearLayout linearLayout = this.channelOverlay;
        RecyclerView recyclerView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            linearLayout = null;
        }
        linearLayout.bringToFront();
        float f = 320.0f * getResources().getDisplayMetrics().density;
        LinearLayout linearLayout2 = this.channelOverlay;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            linearLayout2 = null;
        }
        linearLayout2.setTranslationX(-f);
        LinearLayout linearLayout3 = this.channelOverlay;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = this.channelOverlay;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            linearLayout4 = null;
        }
        linearLayout4.setLayerType(2, null);
        try {
            Glide.with((FragmentActivity) this).pauseRequests();
        } catch (Exception unused) {
        }
        LinearLayout linearLayout5 = this.channelOverlay;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            linearLayout5 = null;
        }
        linearLayout5.animate().translationX(0.0f).setDuration(250L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda30
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.showOverlay$lambda$48(PlaybackActivity.this);
            }
        }).start();
        if (!isTvDevice(this)) {
            findViewById(R.id.mobile_controls).setVisibility(0);
            View findViewById = findViewById(R.id.mobile_controls_left);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        ChannelAdapter channelAdapter = this.channelAdapter;
        final int currentChannelPosition = channelAdapter != null ? channelAdapter.getCurrentChannelPosition() : -1;
        if (currentChannelPosition < 0) {
            currentChannelPosition = 0;
        }
        ChannelAdapter channelAdapter2 = this.channelAdapter;
        if ((channelAdapter2 != null ? channelAdapter2.getItemCount() : 0) > currentChannelPosition) {
            RecyclerView recyclerView2 = this.channelList;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelList");
                recyclerView2 = null;
            }
            recyclerView2.scrollToPosition(currentChannelPosition);
            RecyclerView recyclerView3 = this.channelList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelList");
            } else {
                recyclerView = recyclerView3;
            }
            recyclerView.post(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda31
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackActivity.showOverlay$lambda$49(PlaybackActivity.this, currentChannelPosition);
                }
            });
        }
        resetHideOverlayTimer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showOverlay$lambda$48(PlaybackActivity playbackActivity) {
        LinearLayout linearLayout = playbackActivity.channelOverlay;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            linearLayout = null;
        }
        linearLayout.setLayerType(0, null);
        try {
            Glide.with((FragmentActivity) playbackActivity).resumeRequests();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showOverlay$lambda$49(PlaybackActivity playbackActivity, int i) {
        View view;
        RecyclerView recyclerView = playbackActivity.channelList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelList");
            recyclerView = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
        if (findViewHolderForAdapterPosition == null || (view = findViewHolderForAdapterPosition.itemView) == null) {
            return;
        }
        view.requestFocus();
    }

    private final void resetHideOverlayTimer() {
        Runnable runnable = this.hideOverlayRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda29
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.resetHideOverlayTimer$lambda$51(PlaybackActivity.this);
            }
        };
        this.hideOverlayRunnable = runnable2;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, 8000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void resetHideOverlayTimer$lambda$51(PlaybackActivity playbackActivity) {
        playbackActivity.hideOverlay();
        playbackActivity.hideEpg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideOverlay() {
        if (this.isOverlayVisible) {
            this.isOverlayVisible = false;
            float f = 320.0f * getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = this.channelOverlay;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
                linearLayout = null;
            }
            linearLayout.setLayerType(2, null);
            try {
                Glide.with((FragmentActivity) this).pauseRequests();
            } catch (Exception unused) {
            }
            LinearLayout linearLayout3 = this.channelOverlay;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            } else {
                linearLayout2 = linearLayout3;
            }
            linearLayout2.animate().translationX(-f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackActivity.hideOverlay$lambda$52(PlaybackActivity.this);
                }
            }).start();
            findViewById(R.id.mobile_controls).setVisibility(8);
            View findViewById = findViewById(R.id.mobile_controls_left);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            Runnable runnable = this.hideOverlayRunnable;
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideOverlay$lambda$52(PlaybackActivity playbackActivity) {
        LinearLayout linearLayout = playbackActivity.channelOverlay;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
            linearLayout = null;
        }
        linearLayout.setLayerType(0, null);
        LinearLayout linearLayout3 = playbackActivity.channelOverlay;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelOverlay");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setVisibility(8);
        try {
            Glide.with((FragmentActivity) playbackActivity).resumeRequests();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEpg() {
        if (this.isEpgVisible) {
            resetHideOverlayTimer();
            return;
        }
        if (this.isOverlayVisible) {
            hideOverlay();
        }
        Movie movie = this.currentMovie;
        RecyclerView recyclerView = null;
        String tvgId = movie != null ? movie.getTvgId() : null;
        EpgManager epgManager = EpgManager.INSTANCE;
        Movie movie2 = this.currentMovie;
        List<EpgProgram> programs = epgManager.getPrograms(tvgId, movie2 != null ? movie2.getTitle() : null);
        int i = 0;
        if (programs.isEmpty()) {
            Toast.makeText(this, "Không có lịch phát sóng", 0).show();
            return;
        }
        this.isEpgVisible = true;
        hideChannelInfo();
        LinearLayout linearLayout = this.epgOverlay;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            linearLayout = null;
        }
        linearLayout.bringToFront();
        float f = 320.0f * getResources().getDisplayMetrics().density;
        LinearLayout linearLayout2 = this.epgOverlay;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            linearLayout2 = null;
        }
        linearLayout2.setTranslationX(f);
        LinearLayout linearLayout3 = this.epgOverlay;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = this.epgOverlay;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            linearLayout4 = null;
        }
        linearLayout4.setLayerType(2, null);
        LinearLayout linearLayout5 = this.epgOverlay;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            linearLayout5 = null;
        }
        linearLayout5.animate().translationX(0.0f).setDuration(250L).setInterpolator(new DecelerateInterpolator()).withEndAction(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.showEpg$lambda$54(PlaybackActivity.this);
            }
        }).start();
        EpgAdapter epgAdapter = this.epgAdapter;
        if (epgAdapter == null) {
            this.epgAdapter = new EpgAdapter(programs);
            RecyclerView recyclerView2 = this.epgList;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("epgList");
                recyclerView2 = null;
            }
            recyclerView2.setAdapter(this.epgAdapter);
            RecyclerView recyclerView3 = this.epgList;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("epgList");
                recyclerView3 = null;
            }
            recyclerView3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda50
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return PlaybackActivity.showEpg$lambda$55(PlaybackActivity.this, view, motionEvent);
                }
            });
        } else if (epgAdapter != null) {
            epgAdapter.setPrograms(programs);
        }
        Iterator<EpgProgram> it = programs.iterator();
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().isCurrent()) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            RecyclerView recyclerView4 = this.epgList;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("epgList");
            } else {
                recyclerView = recyclerView4;
            }
            recyclerView.scrollToPosition(i);
        }
        resetHideOverlayTimer();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showEpg$lambda$54(PlaybackActivity playbackActivity) {
        LinearLayout linearLayout = playbackActivity.epgOverlay;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            linearLayout = null;
        }
        linearLayout.setLayerType(0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean showEpg$lambda$55(PlaybackActivity playbackActivity, View view, MotionEvent motionEvent) {
        playbackActivity.resetHideOverlayTimer();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideEpg() {
        if (this.isEpgVisible) {
            this.isEpgVisible = false;
            float f = 320.0f * getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = this.epgOverlay;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
                linearLayout = null;
            }
            linearLayout.setLayerType(2, null);
            LinearLayout linearLayout3 = this.epgOverlay;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            } else {
                linearLayout2 = linearLayout3;
            }
            linearLayout2.animate().translationX(f).setDuration(200L).setInterpolator(new AccelerateInterpolator()).withEndAction(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda48
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackActivity.hideEpg$lambda$57(PlaybackActivity.this);
                }
            }).start();
            Runnable runnable = this.hideOverlayRunnable;
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideEpg$lambda$57(PlaybackActivity playbackActivity) {
        LinearLayout linearLayout = playbackActivity.epgOverlay;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
            linearLayout = null;
        }
        linearLayout.setLayerType(0, null);
        LinearLayout linearLayout3 = playbackActivity.epgOverlay;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgOverlay");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setVisibility(8);
    }

    public final void hideChannelInfo() {
        LinearLayout linearLayout = this.channelInfoPopup;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        LinearLayout linearLayout3 = this.miniChannelPopup;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniChannelPopup");
        } else {
            linearLayout2 = linearLayout3;
        }
        linearLayout2.setVisibility(8);
        View findViewById = findViewById(R.id.center_controls_layout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.handler.removeCallbacks(this.updateInfoRunnable);
        Runnable runnable = this.hideInfoRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        if (this.isOverlayVisible || this.isEpgVisible) {
            return;
        }
        findViewById(R.id.mobile_controls).setVisibility(8);
        View findViewById2 = findViewById(R.id.mobile_controls_left);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCenterControlsState() {
        ImageButton imageButton;
        View findViewById = findViewById(R.id.center_controls_layout);
        if (findViewById == null || (imageButton = (ImageButton) findViewById(R.id.btn_play_pause_center)) == null) {
            return;
        }
        View findViewById2 = findViewById(R.id.btn_prev_center);
        View findViewById3 = findViewById(R.id.btn_next_center);
        boolean isTvDevice = isTvDevice(this);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        LinearLayout linearLayout = null;
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        boolean z = playbackVideoFragment != null && playbackVideoFragment.isPlaying();
        LinearLayout linearLayout2 = this.channelInfoPopup;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
        } else {
            linearLayout = linearLayout2;
        }
        boolean z2 = linearLayout.getVisibility() == 0;
        if (!isTvDevice) {
            if (z2) {
                findViewById.setVisibility(0);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(0);
                }
                if (findViewById3 != null) {
                    findViewById3.setVisibility(0);
                }
                imageButton.setVisibility(0);
                imageButton.setImageResource(z ? R.drawable.ic_pause_circle : R.drawable.ic_play_arrow);
                return;
            }
            findViewById.setVisibility(8);
            return;
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
        if (!z && z2) {
            findViewById.setVisibility(0);
            imageButton.setVisibility(0);
            imageButton.setImageResource(R.drawable.ic_pause_circle);
            return;
        }
        findViewById.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showChannelInfo(Movie movie) {
        String str;
        String str2;
        LinearLayout linearLayout = this.channelInfoPopup;
        SeekBar seekBar = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
            linearLayout = null;
        }
        linearLayout.bringToFront();
        LinearLayout linearLayout2 = this.channelInfoPopup;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
            linearLayout2 = null;
        }
        linearLayout2.setElevation(100.0f);
        LinearLayout linearLayout3 = this.channelInfoPopup;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(0);
        Iterator<Movie> it = this.allChannels.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getId() == movie.getId()) {
                break;
            } else {
                i++;
            }
        }
        String valueOf = i >= 0 ? String.valueOf(i + 1) : "";
        TextView textView = this.infoChannelNumber;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoChannelNumber");
            textView = null;
        }
        textView.setText(valueOf);
        TextView textView2 = this.infoChannelName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoChannelName");
            textView2 = null;
        }
        String title = movie.getTitle();
        textView2.setText(title != null ? title : "");
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if (playbackVideoFragment == null || (str = playbackVideoFragment.getCurrentFormatInfo()) == null) {
            str = "";
        }
        String category = movie.getCategory();
        String str3 = category != null ? category : "";
        TextView textView3 = this.infoChannelCategory;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoChannelCategory");
            textView3 = null;
        }
        if (str.length() > 0) {
            if (str3.length() > 0) {
                str = str3 + " • " + str;
            }
            str2 = str;
        } else {
            str2 = str3;
        }
        textView3.setText(str2);
        this.handler.removeCallbacks(this.updateInfoRunnable);
        this.updateInfoRunnable.run();
        if (!isFinishing() && !isDestroyed()) {
            RequestBuilder fitCenter = Glide.with((FragmentActivity) this).load(movie.getCardImageUrl()).placeholder(R.drawable.app_icon_your_company).error(R.drawable.app_icon_your_company).fitCenter();
            ImageView imageView = this.infoChannelLogo;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("infoChannelLogo");
                imageView = null;
            }
            fitCenter.into(imageView);
        }
        ImageView imageView2 = this.infoChannelLogo;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("infoChannelLogo");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        updateCenterControlsState();
        boolean z = (playbackVideoFragment != null ? playbackVideoFragment.getDuration() : 0L) > 0;
        long duration = playbackVideoFragment != null ? playbackVideoFragment.getDuration() : 0L;
        if (z && duration > 0) {
            SeekBar seekBar2 = this.epgProgressBar;
            if (seekBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("epgProgressBar");
                seekBar2 = null;
            }
            seekBar2.setKeyProgressIncrement(RangesKt.coerceAtLeast((int) (10000000 / duration), 1));
        }
        SeekBar seekBar3 = this.epgProgressBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgProgressBar");
            seekBar3 = null;
        }
        seekBar3.setFocusable(false);
        SeekBar seekBar4 = this.epgProgressBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("epgProgressBar");
        } else {
            seekBar = seekBar4;
        }
        seekBar.setFocusableInTouchMode(false);
        if (!isTvDevice(this)) {
            findViewById(R.id.mobile_controls).setVisibility(0);
            View findViewById = findViewById(R.id.mobile_controls_left);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        Runnable runnable = this.hideInfoRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.this.hideChannelInfo();
            }
        };
        this.hideInfoRunnable = runnable2;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, 8000L);
    }

    private final void showMiniChannelInfo(Movie movie) {
        hideChannelInfo();
        LinearLayout linearLayout = this.miniChannelPopup;
        ImageView imageView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniChannelPopup");
            linearLayout = null;
        }
        linearLayout.bringToFront();
        LinearLayout linearLayout2 = this.miniChannelPopup;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniChannelPopup");
            linearLayout2 = null;
        }
        linearLayout2.setElevation(100.0f);
        LinearLayout linearLayout3 = this.miniChannelPopup;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniChannelPopup");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(0);
        Iterator<Movie> it = this.allChannels.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (it.next().getId() == movie.getId()) {
                break;
            } else {
                i++;
            }
        }
        TextView textView = this.miniChannelNumber;
        if (i >= 0) {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("miniChannelNumber");
                textView = null;
            }
            textView.setText(String.valueOf(i + 1));
            TextView textView2 = this.miniChannelNumber;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("miniChannelNumber");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("miniChannelNumber");
                textView = null;
            }
            textView.setVisibility(8);
        }
        if (!isFinishing() && !isDestroyed()) {
            RequestBuilder fitCenter = Glide.with((FragmentActivity) this).load(movie.getCardImageUrl()).placeholder(R.drawable.app_icon_your_company).error(R.drawable.app_icon_your_company).fitCenter();
            ImageView imageView2 = this.miniChannelLogo;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("miniChannelLogo");
            } else {
                imageView = imageView2;
            }
            fitCenter.into(imageView);
        }
        Runnable runnable = this.hideMiniInfoRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.showMiniChannelInfo$lambda$65(PlaybackActivity.this);
            }
        };
        this.hideMiniInfoRunnable = runnable2;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void showMiniChannelInfo$lambda$65(PlaybackActivity playbackActivity) {
        LinearLayout linearLayout = playbackActivity.miniChannelPopup;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("miniChannelPopup");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
    }

    private final void switchToAdjacentChannel(boolean next) {
        int size;
        int size2;
        if (this.allChannels.isEmpty() || this.currentMovie == null) {
            return;
        }
        if (this.isDvdSeekMode) {
            stopDvdSeek();
        }
        Iterator<Movie> it = this.allChannels.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            Movie next2 = it.next();
            Movie movie = this.currentMovie;
            if (movie != null && next2.getId() == movie.getId()) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        List<Movie> list = this.allChannels;
        if (next) {
            size = i + 1;
            size2 = list.size();
        } else {
            size = (i - 1) + list.size();
            size2 = this.allChannels.size();
        }
        switchChannel(this.allChannels.get(size % size2), true);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:41:0x0094. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fd  */
    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean dispatchKeyEvent(android.view.KeyEvent r12) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tvstore.ok.PlaybackActivity.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void dispatchKeyEvent$lambda$69(PlaybackActivity playbackActivity, int i, boolean z, PlaybackVideoFragment playbackVideoFragment) {
        playbackActivity.isLongPressTriggered = true;
        playbackActivity.handleLongPressAction(i, z, playbackVideoFragment);
    }

    private final void handleSinglePressAction(int keyCode, boolean isVod, PlaybackVideoFragment fragment) {
        if (keyCode != 66) {
            switch (keyCode) {
                case 21:
                    showOverlay();
                    return;
                case 22:
                    showEpg();
                    return;
                case 23:
                    break;
                default:
                    return;
            }
        }
        LinearLayout linearLayout = this.channelInfoPopup;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
            linearLayout = null;
        }
        if (linearLayout.getVisibility() == 0) {
            if (fragment != null) {
                fragment.togglePlayPause();
            }
            Movie movie = this.currentMovie;
            if (movie == null) {
                return;
            }
            showChannelInfo(movie);
            return;
        }
        Movie movie2 = this.currentMovie;
        if (movie2 == null) {
            return;
        }
        showChannelInfo(movie2);
    }

    private final void handleLongPressAction(int keyCode, boolean isVod, PlaybackVideoFragment fragment) {
        if (keyCode != 66) {
            switch (keyCode) {
                case 21:
                    if (isVod) {
                        startDvdSeek(false);
                        return;
                    }
                    return;
                case 22:
                    if (isVod) {
                        startDvdSeek(true);
                        return;
                    }
                    return;
                case 23:
                    break;
                default:
                    return;
            }
        }
        if (fragment != null) {
            fragment.showQualitySelector();
        }
    }

    private final void handleDvdSeekKeyEvent(int keyCode) {
        if (keyCode != 4) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 21:
                        if (!this.isForwardDvdSeek) {
                            cycleDvdSeekSpeed();
                            return;
                        } else {
                            startDvdSeek(false);
                            return;
                        }
                    case 22:
                        if (this.isForwardDvdSeek) {
                            cycleDvdSeekSpeed();
                            return;
                        } else {
                            startDvdSeek(true);
                            return;
                        }
                    case 23:
                        break;
                    default:
                        return;
                }
            }
            stopDvdSeek();
            return;
        }
        stopDvdSeek();
    }

    private final void startDvdSeek(boolean isForward) {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        if ((playbackVideoFragment != null ? playbackVideoFragment.getDuration() : 0L) <= 0) {
            return;
        }
        this.isDvdSeekMode = true;
        this.isForwardDvdSeek = isForward;
        this.dvdSeekSpeed = 2;
        if (playbackVideoFragment != null && playbackVideoFragment.isPlaying()) {
            playbackVideoFragment.togglePlayPause();
        }
        Movie movie = this.currentMovie;
        if (movie != null) {
            showChannelInfo(movie);
        }
        updateDvdSeekUI();
        startDvdSeekRunnable();
    }

    private final void cycleDvdSeekSpeed() {
        int i = this.dvdSeekSpeed;
        int i2 = 4;
        if (i != 2) {
            if (i != 4) {
                i2 = 16;
                if (i != 8) {
                    i2 = i != 16 ? i != 32 ? 2 : 64 : 32;
                }
            } else {
                i2 = 8;
            }
        }
        this.dvdSeekSpeed = i2;
        updateDvdSeekUI();
    }

    private final void updateDvdSeekUI() {
        View findViewById = findViewById(R.id.seek_left_layout);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = findViewById(R.id.seek_right_layout);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        View findViewById3 = findViewById(R.id.seek_center_layout);
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
        String str = this.dvdSeekSpeed + "x";
        View view = this.gestureFeedback;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureFeedback");
            view = null;
        }
        view.setVisibility(0);
        if (this.isForwardDvdSeek) {
            View findViewById4 = findViewById(R.id.seek_right_layout);
            if (findViewById4 != null) {
                findViewById4.setVisibility(0);
            }
            TextView textView = (TextView) findViewById(R.id.seek_right_text);
            if (textView != null) {
                textView.setText(str);
            }
        } else {
            View findViewById5 = findViewById(R.id.seek_left_layout);
            if (findViewById5 != null) {
                findViewById5.setVisibility(0);
            }
            TextView textView2 = (TextView) findViewById(R.id.seek_left_text);
            if (textView2 != null) {
                textView2.setText(str);
            }
        }
        this.handler.removeCallbacks(this.hideGestureRunnable);
        Runnable runnable = this.hideInfoRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
    }

    private final void startDvdSeekRunnable() {
        stopDvdSeekRunnable();
        Runnable runnable = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$startDvdSeekRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                int i;
                boolean z;
                Fragment findFragmentById = PlaybackActivity.this.getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
                PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
                if (playbackVideoFragment != null) {
                    PlaybackActivity playbackActivity = PlaybackActivity.this;
                    i = playbackActivity.dvdSeekSpeed;
                    long j = (i / 2) * 5000;
                    z = playbackActivity.isForwardDvdSeek;
                    if (z) {
                        playbackVideoFragment.seekRelative(j);
                    } else {
                        playbackVideoFragment.seekRelative(-j);
                    }
                }
                handler = PlaybackActivity.this.dvdSeekHandler;
                handler.postDelayed(this, 1000L);
            }
        };
        this.dvdSeekRunnable = runnable;
        Handler handler = this.dvdSeekHandler;
        Intrinsics.checkNotNull(runnable);
        handler.post(runnable);
    }

    private final void stopDvdSeekRunnable() {
        Runnable runnable = this.dvdSeekRunnable;
        if (runnable != null) {
            this.dvdSeekHandler.removeCallbacks(runnable);
        }
        this.dvdSeekRunnable = null;
    }

    private final void stopDvdSeek() {
        if (this.isDvdSeekMode) {
            this.isDvdSeekMode = false;
            stopDvdSeekRunnable();
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
            View view = null;
            PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
            if (playbackVideoFragment != null && !playbackVideoFragment.isPlaying()) {
                playbackVideoFragment.togglePlayPause();
            }
            View view2 = this.gestureFeedback;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gestureFeedback");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            View findViewById = findViewById(R.id.seek_left_layout);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = findViewById(R.id.seek_right_layout);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            View findViewById3 = findViewById(R.id.seek_center_layout);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            Toast.makeText(this, "Tiếp tục phát", 0).show();
            Movie movie = this.currentMovie;
            if (movie == null) {
                return;
            }
            showChannelInfo(movie);
        }
    }

    private final void stopContinuousSeek() {
        Runnable runnable = this.leftSeekRunnable;
        if (runnable != null) {
            this.seekHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.rightSeekRunnable;
        if (runnable2 != null) {
            this.seekHandler.removeCallbacks(runnable2);
        }
        this.leftSeekRunnable = null;
        this.rightSeekRunnable = null;
    }

    private final void startContinuousSeek(final boolean isForward) {
        Movie movie;
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
        LinearLayout linearLayout = null;
        final PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
        LinearLayout linearLayout2 = this.channelInfoPopup;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
        } else {
            linearLayout = linearLayout2;
        }
        if (linearLayout.getVisibility() != 0 && (movie = this.currentMovie) != null) {
            showChannelInfo(movie);
        }
        Runnable runnable = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$startContinuousSeek$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                Handler handler;
                boolean z = isForward;
                PlaybackVideoFragment playbackVideoFragment2 = playbackVideoFragment;
                if (z) {
                    if (playbackVideoFragment2 != null) {
                        playbackVideoFragment2.seekRelative(DashMediaSource.DEFAULT_FALLBACK_TARGET_LIVE_OFFSET_MS);
                    }
                    this.showGestureFeedback(R.drawable.ic_fast_forward, "Tua nhanh >>");
                } else {
                    if (playbackVideoFragment2 != null) {
                        playbackVideoFragment2.seekRelative(-30000L);
                    }
                    this.showGestureFeedback(R.drawable.ic_fast_rewind, "<< Tua lùi");
                }
                handler = this.seekHandler;
                handler.postDelayed(this, 500L);
            }
        };
        if (isForward) {
            this.rightSeekRunnable = runnable;
        } else {
            this.leftSeekRunnable = runnable;
        }
        this.seekHandler.post(runnable);
    }

    private final void hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
        windowInsetsControllerCompat.setSystemBarsBehavior(2);
        if (Build.VERSION.SDK_INT < 30) {
            getWindow().addFlags(1024);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private final void appendChannelDigit(int digit) {
        this.channelNumberBuffer.append(digit);
        showChannelNumberOverlay();
        Runnable runnable = this.channelNumberRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        if (this.channelNumberBuffer.length() >= this.MAX_CHANNEL_DIGITS) {
            commitChannelNumber();
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.this.commitChannelNumber();
            }
        };
        this.channelNumberRunnable = runnable2;
        Handler handler = this.handler;
        Intrinsics.checkNotNull(runnable2);
        handler.postDelayed(runnable2, this.CHANNEL_INPUT_TIMEOUT);
    }

    private final void showChannelNumberOverlay() {
        TextView textView = this.channelNumberText;
        LinearLayout linearLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberText");
            textView = null;
        }
        textView.setText(this.channelNumberBuffer.toString());
        LinearLayout linearLayout2 = this.channelNumberOverlay;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberOverlay");
            linearLayout2 = null;
        }
        if (linearLayout2.getVisibility() != 0) {
            LinearLayout linearLayout3 = this.channelNumberOverlay;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNumberOverlay");
                linearLayout3 = null;
            }
            linearLayout3.setAlpha(0.0f);
            LinearLayout linearLayout4 = this.channelNumberOverlay;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNumberOverlay");
                linearLayout4 = null;
            }
            linearLayout4.setVisibility(0);
            LinearLayout linearLayout5 = this.channelNumberOverlay;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNumberOverlay");
            } else {
                linearLayout = linearLayout5;
            }
            linearLayout.animate().alpha(1.0f).setDuration(150L).start();
        }
    }

    private final void hideChannelNumberOverlay() {
        LinearLayout linearLayout = this.channelNumberOverlay;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberOverlay");
            linearLayout = null;
        }
        linearLayout.animate().alpha(0.0f).setDuration(300L).withEndAction(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.hideChannelNumberOverlay$lambda$80(PlaybackActivity.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void hideChannelNumberOverlay$lambda$80(PlaybackActivity playbackActivity) {
        LinearLayout linearLayout = playbackActivity.channelNumberOverlay;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberOverlay");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitChannelNumber() {
        Runnable runnable = this.channelNumberRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        TextView textView = null;
        this.channelNumberRunnable = null;
        String sb = this.channelNumberBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        StringsKt.clear(this.channelNumberBuffer);
        if (sb.length() == 0) {
            hideChannelNumberOverlay();
            return;
        }
        Integer intOrNull = StringsKt.toIntOrNull(sb);
        if (intOrNull == null || intOrNull.intValue() < 1 || intOrNull.intValue() > this.allChannels.size()) {
            TextView textView2 = this.channelNumberText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNumberText");
                textView2 = null;
            }
            textView2.setText(sb + " ✕");
            TextView textView3 = this.channelNumberText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelNumberText");
            } else {
                textView = textView3;
            }
            textView.setTextColor(Color.parseColor("#FF6B6B"));
            this.handler.postDelayed(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    PlaybackActivity.commitChannelNumber$lambda$82(PlaybackActivity.this);
                }
            }, 1200L);
            Toast.makeText(this, "Không tìm thấy kênh " + sb, 0).show();
            return;
        }
        Movie movie = this.allChannels.get(intOrNull.intValue() - 1);
        TextView textView4 = this.channelNumberText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberText");
            textView4 = null;
        }
        textView4.setText(sb + " ✓");
        TextView textView5 = this.channelNumberText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberText");
            textView5 = null;
        }
        textView5.setTextColor(Color.parseColor("#4ADE80"));
        this.handler.postDelayed(new Runnable() { // from class: com.tvstore.ok.PlaybackActivity$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                PlaybackActivity.commitChannelNumber$lambda$83(PlaybackActivity.this);
            }
        }, 800L);
        Movie movie2 = this.currentMovie;
        if (movie2 != null && movie.getId() == movie2.getId()) {
            Toast.makeText(this, "Đang tải lại kênh...", 0).show();
        }
        switchChannel$default(this, movie, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void commitChannelNumber$lambda$82(PlaybackActivity playbackActivity) {
        TextView textView = playbackActivity.channelNumberText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberText");
            textView = null;
        }
        textView.setTextColor(-1);
        playbackActivity.hideChannelNumberOverlay();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void commitChannelNumber$lambda$83(PlaybackActivity playbackActivity) {
        TextView textView = playbackActivity.channelNumberText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelNumberText");
            textView = null;
        }
        textView.setTextColor(-1);
        playbackActivity.hideChannelNumberOverlay();
    }

    private final String removeAccents(String s) {
        String normalize = Normalizer.normalize(s, Normalizer.Form.NFD);
        Regex regex = new Regex("\\p{InCombiningDiacriticalMarks}+");
        Intrinsics.checkNotNull(normalize);
        return StringsKt.replace$default(StringsKt.replace$default(regex.replace(normalize, ""), (char) 273, 'd', false, 4, (Object) null), (char) 272, 'D', false, 4, (Object) null);
    }

    private final void handleVoiceSearch(String query) {
        Object obj;
        String lowerCase = removeAccents(query).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Iterator<T> it = this.allChannels.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String title = ((Movie) obj).getTitle();
            if (title == null) {
                title = "";
            }
            String lowerCase2 = removeAccents(title).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) lowerCase, false, 2, (Object) null)) {
                break;
            }
        }
        Movie movie = (Movie) obj;
        if (movie != null) {
            Toast.makeText(this, "Đang mở: " + movie.getTitle(), 0).show();
            switchChannel$default(this, movie, false, 2, null);
            return;
        }
        Toast.makeText(this, "Không tìm thấy kênh: " + query, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startVoiceSearch() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.PROMPT", "Đọc tên kênh cần mở...");
        try {
            this.voiceSearchLauncher.launch(intent);
        } catch (Exception unused) {
            Toast.makeText(this, "Thiết bị không hỗ trợ tìm kiếm giọng nói", 0).show();
        }
    }

    public final void updatePlayPauseUI(boolean isPlaying) {
        ImageButton imageButton = (ImageButton) findViewById(R.id.btn_play_pause_center);
        if (imageButton != null) {
            imageButton.setImageResource(isPlaying ? R.drawable.ic_pause_circle : R.drawable.ic_play_arrow);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacks(this.updateInfoRunnable);
        Runnable runnable = this.hideInfoRunnable;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.hideOverlayRunnable;
        if (runnable2 != null) {
            this.handler.removeCallbacks(runnable2);
        }
        Runnable runnable3 = this.channelNumberRunnable;
        if (runnable3 != null) {
            this.handler.removeCallbacks(runnable3);
        }
        this.handler.removeCallbacks(this.hideGestureRunnable);
        this.handler.removeCallbacksAndMessages(null);
        this.seekHandler.removeCallbacksAndMessages(null);
        stopAudioAnimations();
    }

    private final void enterPipMode() {
        PictureInPictureParams.Builder aspectRatio;
        PictureInPictureParams build;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        PlaybackActivity playbackActivity = this;
        if (isTvDevice(playbackActivity)) {
            return;
        }
        try {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.video_fragment_container);
            PlaybackVideoFragment playbackVideoFragment = findFragmentById instanceof PlaybackVideoFragment ? (PlaybackVideoFragment) findFragmentById : null;
            Rational rational = new Rational(RangesKt.coerceIn(playbackVideoFragment != null ? playbackVideoFragment.getVideoWidth() : 16, 1, 2390), RangesKt.coerceIn(playbackVideoFragment != null ? playbackVideoFragment.getVideoHeight() : 9, 1, 2390));
            NoticeManager$$ExternalSyntheticApiModelOutline0.m436m();
            aspectRatio = NoticeManager$$ExternalSyntheticApiModelOutline0.m().setAspectRatio(rational);
            build = aspectRatio.build();
            enterPictureInPictureMode(build);
        } catch (Exception e) {
            Log.e("PlaybackActivity", "PiP error: " + e.getMessage());
            Toast.makeText(playbackActivity, "Điện thoại không hỗ trợ PiP", 0).show();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (Build.VERSION.SDK_INT < 26 || isTvDevice(this)) {
            return;
        }
        enterPipMode();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        Movie movie;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        if (isInPictureInPictureMode) {
            LinearLayout linearLayout = this.channelInfoPopup;
            View view = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelInfoPopup");
                linearLayout = null;
            }
            linearLayout.setVisibility(8);
            View findViewById = findViewById(R.id.center_controls_layout);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            View findViewById2 = findViewById(R.id.btn_play_pause_center);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            this.handler.removeCallbacks(this.updateInfoRunnable);
            Runnable runnable = this.hideInfoRunnable;
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
            hideOverlay();
            hideEpg();
            findViewById(R.id.mobile_controls).setVisibility(8);
            View findViewById3 = findViewById(R.id.mobile_controls_left);
            if (findViewById3 != null) {
                findViewById3.setVisibility(8);
            }
            View view2 = this.gestureFeedback;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gestureFeedback");
                view2 = null;
            }
            view2.setVisibility(8);
            View view3 = this.lockOverlay;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lockOverlay");
            } else {
                view = view3;
            }
            view.setVisibility(8);
            return;
        }
        if (isFinishing() || (movie = this.currentMovie) == null) {
            return;
        }
        showChannelInfo(movie);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (Build.VERSION.SDK_INT >= 26) {
            isInPictureInPictureMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (Build.VERSION.SDK_INT >= 26) {
            isInPictureInPictureMode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exitPlayback() {
        if (isTaskRoot()) {
            Intent intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.addFlags(335544320);
            startActivity(intent);
        }
        finish();
    }
}
