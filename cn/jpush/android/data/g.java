package cn.jpush.android.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.jpush.android.ui.WebViewCallback;
import cn.jpush.android.ui.f;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.util.Random;

public final class g extends LinearLayout
{
  private static final String[] E;
  private WebView A;
  private d B;
  private Bitmap C;
  private Bitmap D;
  int[][] a = { { 0, 0 }, { 1, 1 }, { 0, 1 } };
  Handler b = new h(this);
  private LinearLayout c;
  private LinearLayout d;
  private LinearLayout e;
  private LinearLayout f;
  private LinearLayout g;
  private LinearLayout h;
  private ImageView i;
  private TextView j;
  private ScrollView k;
  private TextView l;
  private TextView m;
  private TextView n;
  private TextView o;
  private TextView p;
  private TextView q;
  private ImageView r;
  private Button s;
  private Button t;
  private Context u;
  private Bitmap v = null;
  private Bitmap w = null;
  private int x = 0;
  private int y;
  private float z;

  static
  {
    Object localObject1 = new String[12];
    int i1 = 0;
    String str1 = "f\032\032;T{/\r";
    int i2 = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int i3 = localObject3.length;
    int i4 = 0;
    label36: Object localObject4;
    int i5;
    int i6;
    Object localObject5;
    label52: int i7;
    int i8;
    if (i3 <= 1)
    {
      localObject4 = localObject3;
      i5 = i4;
      i6 = i3;
      localObject5 = localObject3;
      i7 = localObject5[i4];
      switch (i5 % 5)
      {
      default:
        i8 = 60;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i4] = ((char)(i8 ^ i7));
      i4 = i5 + 1;
      if (i6 == 0)
      {
        localObject5 = localObject4;
        i5 = i4;
        i4 = i6;
        break label52;
      }
      i3 = i6;
      localObject3 = localObject4;
      if (i3 > i4)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (i2)
      {
      default:
        localObject1[i1] = str2;
        i1 = 1;
        str1 = "@%\016,i^&U";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "y\036)e\004";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "轃亼交纅";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "_>\016:c\035";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "_>\016:c\034";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "叺淂";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        i1 = 7;
        str1 = "烁镊輀亾";
        i2 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i1] = str2;
        i1 = 8;
        str1 = "H/\t\027UO%\001";
        i2 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i1] = str2;
        i1 = 9;
        str1 = "丧輷實袍";
        i2 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i1] = str2;
        i1 = 10;
        str1 = "H/\t\027UA-";
        i2 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i1] = str2;
        i1 = 11;
        str1 = "\f仰讫剎";
        i2 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i1] = str2;
        E = localObject2;
        return;
        i8 = 44;
        continue;
        i8 = 74;
        continue;
        i8 = 111;
        continue;
        i8 = 72;
      }
    }
  }

  public g(Context paramContext, d paramd)
  {
    super(paramContext, null);
    x.c();
    this.u = paramContext;
    this.B = paramd;
    this.y = this.u.getResources().getDisplayMetrics().widthPixels;
    this.z = this.u.getResources().getDisplayMetrics().density;
    try
    {
      this.v = BitmapFactory.decodeStream(this.u.getAssets().open(E[5]));
      this.w = BitmapFactory.decodeStream(this.u.getAssets().open(E[4]));
      label174: this.x = new Random().nextInt(this.a.length);
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
      setLayoutParams(localLayoutParams1);
      setOrientation(1);
      setPadding(5, 5, 5, 5);
      this.c = new LinearLayout(this.u);
      this.c.setOrientation(1);
      this.c.setGravity(17);
      this.c.setPadding(1, 1, 1, 1);
      this.c.setBackgroundColor(Color.rgb(117, 117, 117));
      addView(this.c, localLayoutParams1);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, 75);
      this.d = new LinearLayout(this.u);
      this.d.setBackgroundColor(Color.rgb(0, 160, 200));
      this.d.setPadding(5, 5, 5, 5);
      this.d.setOrientation(0);
      this.d.setGravity(17);
      this.c.addView(this.d, localLayoutParams2);
      LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(72, 72);
      this.i = new ImageView(this.u);
      this.i.setScaleType(ImageView.ScaleType.FIT_XY);
      try
      {
        Bitmap localBitmap2 = BitmapFactory.decodeStream(this.u.getAssets().open(E[8]));
        if (localBitmap2 != null)
          this.i.setImageBitmap(localBitmap2);
        label450: this.d.addView(this.i, localLayoutParams3);
        LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        this.j = new TextView(this.u);
        this.j.setMaxEms(10);
        this.j.setMaxLines(1);
        this.j.setSingleLine(true);
        this.j.setTextColor(-16777216);
        this.j.setPadding(15, 0, 0, 0);
        this.j.setTextSize(20.0F);
        this.d.addView(this.j, localLayoutParams4);
        LinearLayout.LayoutParams localLayoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        this.k = new ScrollView(this.u);
        localLayoutParams5.weight = 1.0F;
        this.c.addView(this.k, localLayoutParams5);
        LinearLayout.LayoutParams localLayoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        this.e = new LinearLayout(this.u);
        this.e.setOrientation(1);
        this.k.addView(this.e, localLayoutParams6);
        LinearLayout.LayoutParams localLayoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams7.setMargins(0, 1, 0, 0);
        this.l = new TextView(this.u);
        this.l.setPadding(20, 5, 0, 5);
        this.l.setBackgroundColor(Color.rgb(229, 229, 229));
        this.l.setText(E[7]);
        this.l.setTextColor(-16777216);
        this.l.setTextSize(15.0F);
        this.e.addView(this.l, localLayoutParams7);
        LinearLayout.LayoutParams localLayoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams8.setMargins(0, 1, 0, 0);
        LinearLayout localLinearLayout1 = new LinearLayout(this.u);
        localLinearLayout1.setBackgroundColor(Color.rgb(247, 248, 249));
        localLinearLayout1.setGravity(17);
        this.e.addView(localLinearLayout1, localLayoutParams8);
        LinearLayout.LayoutParams localLayoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout.LayoutParams localLayoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams10.weight = 1.0F;
        LinearLayout localLinearLayout2 = new LinearLayout(this.u);
        localLinearLayout2.setOrientation(1);
        localLinearLayout1.addView(localLinearLayout2, localLayoutParams10);
        this.m = new TextView(this.u);
        this.m.setPadding(20, 10, 5, 5);
        this.m.setTextColor(-16777216);
        this.m.setTextSize(12.0F);
        localLinearLayout2.addView(this.m, localLayoutParams9);
        this.n = new TextView(this.u);
        this.n.setPadding(20, 5, 5, 5);
        this.n.setTextColor(-16777216);
        this.n.setTextSize(12.0F);
        localLinearLayout2.addView(this.n, localLayoutParams9);
        this.o = new TextView(this.u);
        this.o.setPadding(20, 5, 5, 10);
        this.o.setTextColor(-16777216);
        this.o.setTextSize(12.0F);
        localLinearLayout2.addView(this.o, localLayoutParams9);
        LinearLayout.LayoutParams localLayoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        localLayoutParams10.weight = 1.0F;
        this.h = new LinearLayout(this.u);
        this.h.setOrientation(1);
        this.h.setGravity(17);
        this.h.setPadding(0, 0, 100, 0);
        localLinearLayout1.addView(this.h, localLayoutParams11);
        a(this.h);
        this.p = new TextView(this.u);
        this.p.setBackgroundColor(Color.rgb(229, 229, 229));
        this.l.setTextSize(15.0F);
        this.p.setPadding(20, 5, 5, 5);
        this.p.setTextColor(-16777216);
        this.p.setText(E[3]);
        this.e.addView(this.p, localLayoutParams7);
        LinearLayout.LayoutParams localLayoutParams12 = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams12.setMargins(0, 1, 0, 0);
        this.q = new TextView(this.u);
        this.q.setBackgroundColor(Color.rgb(247, 248, 249));
        this.q.setTextSize(12.0F);
        this.q.setPadding(20, 20, 20, 20);
        this.q.setTextColor(-16777216);
        this.e.addView(this.q, localLayoutParams12);
        LinearLayout.LayoutParams localLayoutParams13 = new LinearLayout.LayoutParams(-1, -2);
        this.g = new LinearLayout(this.u);
        this.g.setOrientation(1);
        this.g.setGravity(17);
        this.g.setPadding(0, 20, 0, 0);
        this.e.addView(this.g, localLayoutParams13);
        LinearLayout.LayoutParams localLayoutParams14 = new LinearLayout.LayoutParams((int)(220.0F * this.z), (int)(300.0F * this.z));
        this.r = new ImageView(this.u);
        this.r.setScaleType(ImageView.ScaleType.FIT_XY);
        try
        {
          Bitmap localBitmap1 = BitmapFactory.decodeStream(this.u.getAssets().open(E[10]));
          if (localBitmap1 != null)
            this.r.setImageBitmap(localBitmap1);
          label1496: this.g.addView(this.r, localLayoutParams14);
          LinearLayout.LayoutParams localLayoutParams15 = new LinearLayout.LayoutParams(-1, -2);
          this.f = new LinearLayout(this.u);
          this.f.setBackgroundColor(Color.rgb(0, 160, 200));
          this.f.setPadding(5, 5, 5, 5);
          this.f.setOrientation(0);
          this.f.setGravity(17);
          this.c.addView(this.f, localLayoutParams15);
          LinearLayout.LayoutParams localLayoutParams16 = new LinearLayout.LayoutParams(this.y / 2, -2);
          this.s = new Button(this.u);
          this.s.setText(E[9]);
          this.f.addView(this.s, localLayoutParams16);
          this.t = new Button(this.u);
          this.t.setText(E[6]);
          this.f.addView(this.t, localLayoutParams16);
          return;
        }
        catch (IOException localIOException3)
        {
          break label1496;
        }
      }
      catch (IOException localIOException2)
      {
        break label450;
      }
    }
    catch (IOException localIOException1)
    {
      break label174;
    }
  }

  private void a(LinearLayout paramLinearLayout)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    LinearLayout localLinearLayout = new LinearLayout(this.u);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    paramLinearLayout.addView(localLinearLayout, localLayoutParams);
    if (this.v != null)
      for (int i3 = 0; i3 < 3; i3++)
      {
        ImageView localImageView4 = new ImageView(this.u);
        localImageView4.setImageBitmap(this.v);
        localLinearLayout.addView(localImageView4, localLayoutParams);
      }
    int[] arrayOfInt = this.a[this.x];
    int i1 = arrayOfInt.length;
    int i2 = 0;
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    if (i1 == 2)
    {
      ImageView localImageView1 = new ImageView(this.u);
      if (arrayOfInt[0] == 0)
      {
        localBitmap1 = this.v;
        localImageView1.setImageBitmap(localBitmap1);
        localLinearLayout.addView(localImageView1, localLayoutParams);
        ImageView localImageView2 = new ImageView(this.u);
        if (arrayOfInt[1] != 0)
          break label296;
        localBitmap2 = this.v;
        label183: localImageView2.setImageBitmap(localBitmap2);
        localLinearLayout.addView(localImageView2, localLayoutParams);
      }
    }
    while (true)
    {
      Random localRandom = new Random();
      TextView localTextView = new TextView(this.u);
      localTextView.setPadding(10, 5, 5, 5);
      localTextView.setTextSize(15.0F);
      localTextView.setText(String.valueOf(200 + localRandom.nextInt(2000)) + E[11]);
      paramLinearLayout.addView(localTextView, localLayoutParams);
      return;
      localBitmap1 = this.w;
      break;
      label296: localBitmap2 = this.w;
      break label183;
      while (i2 < 2)
      {
        ImageView localImageView3 = new ImageView(this.u);
        localImageView3.setImageBitmap(this.w);
        localLinearLayout.addView(localImageView3, localLayoutParams);
        i2++;
      }
    }
  }

  public final void a()
  {
    if (this.A != null)
      this.A.destroy();
  }

  public final void a(View.OnClickListener paramOnClickListener)
  {
    if (this.t != null)
      this.t.setOnClickListener(paramOnClickListener);
  }

  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    new StringBuilder(E[1]).append(paramString).toString();
    x.c();
    if (this.e != null)
    {
      this.d.setVisibility(8);
      this.e.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.weight = 1.0F;
      this.A = new WebView(this.u);
      this.A.clearCache(true);
      this.A.getSettings().setJavaScriptEnabled(true);
      this.A.getSettings().setDefaultTextEncodingName(E[2]);
      this.A.getSettings().setSupportZoom(true);
      this.A.getSettings().setCacheMode(2);
      this.A.addJavascriptInterface(new WebViewCallback(this.u, this.B), E[0]);
      this.A.setWebViewClient(new f(this.B));
      this.A.loadUrl(paramString);
      this.A.requestFocus();
      this.e.addView(this.A, localLayoutParams);
      this.s.setVisibility(8);
      this.t.setVisibility(0);
    }
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.g
 * JD-Core Version:    0.6.2
 */