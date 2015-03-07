package cn.jpush.android.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.data.d;
import cn.jpush.android.ui.f;
import cn.jpush.android.util.x;

final class r
  implements Runnable
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[4];
    String str1 = "\0077vu";
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
          i3 = 26;
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
        str1 = ":\027D(\"";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        str1 = "\030*lau\030";
        j = 2;
        arrayOfString2 = arrayOfString1;
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        j = 3;
        arrayOfString2 = arrayOfString1;
        str1 = "%\023wvr8&`";
        i = 2;
        break;
      case 2:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 111;
        break label96;
        i3 = 67;
        break label96;
        i3 = 2;
        break label96;
        i3 = 5;
        break label96;
        m = 0;
      }
    }
  }

  r(d paramd, Context paramContext)
  {
  }

  public final void run()
  {
    if (((this.a instanceof cn.jpush.android.data.s)) && (this.a.f()))
    {
      x.c();
      String str = ((cn.jpush.android.data.s)this.a).a;
      WindowManager localWindowManager = (WindowManager)this.b.getSystemService(z[2]);
      WebView localWebView = new WebView(this.b);
      ImageButton localImageButton = new ImageButton(this.b);
      q.a(this.b, localWindowManager, localWebView, localImageButton);
      localWebView.setHorizontalScrollBarEnabled(false);
      localWebView.setVerticalScrollBarEnabled(false);
      localWebView.setScrollbarFadingEnabled(true);
      localWebView.setScrollBarStyle(33554432);
      WebSettings localWebSettings = localWebView.getSettings();
      localWebSettings.setJavaScriptEnabled(true);
      localWebSettings.setDefaultTextEncodingName(z[1]);
      localWebSettings.setSupportZoom(true);
      localWebSettings.setCacheMode(2);
      localWebView.addJavascriptInterface(new t(this.b, this.a, localWindowManager, localWebView, localImageButton), z[3]);
      localWebView.setWebViewClient(new f(this.a));
      if ((!TextUtils.isEmpty(str)) && (str.startsWith(z[0])))
        localWebView.loadUrl(str);
      localImageButton.setOnClickListener(new s(this, localWindowManager, localWebView, localImageButton));
      return;
    }
    x.f();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.r
 * JD-Core Version:    0.6.2
 */