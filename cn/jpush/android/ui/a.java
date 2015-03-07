package cn.jpush.android.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.io.InputStream;

public final class a extends RelativeLayout
{
  private static final String[] z;
  ImageView a;
  View.OnTouchListener b = new b(this);
  private final Context c;
  private WebView d;
  private c e = new c(this);

  static
  {
    String[] arrayOfString1 = new String[4];
    String str1 = "fO)!uxLr";
    int i = -1;
    String[] arrayOfString2 = arrayOfString1;
    int j = 0;
    Object localObject1 = str1.toCharArray();
    int k = localObject1.length;
    int m;
    label35: int i3;
    if (k <= 1)
    {
      m = 0;
      Object localObject2 = localObject1;
      int n = m;
      int i1 = k;
      Object localObject3 = localObject1;
      while (true)
      {
        int i2 = localObject3[m];
        switch (n % 5)
        {
        default:
          i3 = 32;
          label96: localObject3[m] = ((char)(i3 ^ i2));
          m = n + 1;
          if (i1 != 0)
            break label133;
          localObject3 = localObject2;
          n = m;
          m = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label133: k = i1;
      localObject1 = localObject2;
    }
    while (true)
    {
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject1).intern();
      switch (i)
      {
      default:
        arrayOfString2[j] = str2;
        str1 = "`P=6HUC$*So\0168+G";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        str1 = "@p=6H]E*";
        j = 2;
        arrayOfString2 = arrayOfString1;
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        j = 3;
        arrayOfString2 = arrayOfString1;
        str1 = "_t\016h\030";
        i = 2;
        break;
      case 2:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 10;
        break label96;
        i3 = 32;
        break label96;
        i3 = 72;
        break label96;
        i3 = 69;
        break label96;
        m = 0;
      }
    }
  }

  public a(Context paramContext, cn.jpush.android.data.d paramd)
  {
    super(paramContext);
    this.c = paramContext;
    ProgressBar localProgressBar = new ProgressBar(paramContext, null, 16842872);
    localProgressBar.setMax(100);
    localProgressBar.setLayoutParams(new RelativeLayout.LayoutParams(-1, cn.jpush.android.util.a.a(paramContext, 5.0F)));
    this.d = new WebView(paramContext);
    this.d.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.d.setScrollbarFadingEnabled(true);
    this.d.setScrollBarStyle(33554432);
    WebSettings localWebSettings = this.d.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setDefaultTextEncodingName(z[3]);
    localWebSettings.setSupportZoom(true);
    localWebSettings.setCacheMode(2);
    this.d.addJavascriptInterface(new WebViewCallback(paramContext, paramd), z[2]);
    this.d.setWebChromeClient(new d(localProgressBar));
    this.d.setWebViewClient(new f(paramd));
    this.d.setOnTouchListener(this.b);
    addView(localProgressBar, new RelativeLayout.LayoutParams(-1, cn.jpush.android.util.a.a(paramContext, 5.0F)));
    addView(this.d, new RelativeLayout.LayoutParams(-1, -1));
  }

  public final void a()
  {
    removeAllViews();
    if (this.d != null)
    {
      this.d.removeAllViews();
      this.d.destroy();
      this.d = null;
    }
    if (this.a != null)
      this.a = null;
  }

  public final void a(View.OnClickListener paramOnClickListener)
  {
    Context localContext = this.c;
    x.c();
    this.a = new ImageView(localContext);
    try
    {
      InputStream localInputStream = localContext.getResources().getAssets().open(z[1]);
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(localInputStream);
      this.a.setImageDrawable(localBitmapDrawable);
      this.a.setVisibility(4);
      try
      {
        localInputStream.close();
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(cn.jpush.android.util.a.a(localContext, 40.0F), cn.jpush.android.util.a.a(localContext, 40.0F));
        localLayoutParams.addRule(10, -1);
        localLayoutParams.addRule(11, -1);
        addView(this.a, localLayoutParams);
        this.e.sendEmptyMessage(0);
        label126: if (this.a != null)
          this.a.setOnClickListener(paramOnClickListener);
        return;
      }
      catch (IOException localIOException2)
      {
        break label126;
      }
    }
    catch (IOException localIOException1)
    {
      break label126;
    }
  }

  public final void a(String paramString)
  {
    if (this.d != null)
    {
      new StringBuilder(z[0]).append(paramString).toString();
      x.c();
      this.d.loadUrl(paramString);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.a
 * JD-Core Version:    0.6.2
 */