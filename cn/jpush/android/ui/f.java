package cn.jpush.android.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jpush.android.a;
import cn.jpush.android.data.d;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.x;

public final class f extends WebViewClient
{
  private static final String[] z;
  private final d a;

  static
  {
    Object localObject1 = new String[22];
    int i = 0;
    String str1 = "\0321\tbl\022;Cym\017:\003d-\036'\031bbU\013(HW";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label36: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label52: int i2;
    int i3;
    if (k <= 1)
    {
      localObject4 = localObject3;
      n = m;
      i1 = k;
      localObject5 = localObject3;
      i2 = localObject5[m];
      switch (n % 5)
      {
      default:
        i3 = 3;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[m] = ((char)(i3 ^ i2));
      m = n + 1;
      if (i1 == 0)
      {
        localObject5 = localObject4;
        n = m;
        m = i1;
        break label52;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = ".-\0010u\032*\001u#\022,M*";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "**\bbz(+\037ym\034eM";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "Ul\n`";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = ".-\004*#";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\026>\004|w\024";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "D;\004bf\030+Pvb\027,\b";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "U2\035#";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "\023+\031`";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "\0133\fymT+\bhw";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "\0176\031|fF";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "\0321\tbl\022;Cym\017:\003d-\036'\031bbU\f8RI>\0349";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "\0321\tbl\022;Cym\017:\003d-\036'\031bbU\032 QJ7";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "\0376\037u`\017b";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "\0321\tbl\022;Cym\017:\003d-\032<\031yl\025q;YF,";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "]<\002~w\0361\031-";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "\0321\tbl\022;Cym\017:\003d-\032<\031yl\025q>UM?";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "U2\035$";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "\r6\tulTu";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "\032*\tylTu";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "];\004bf\030+Pvb\027,\b";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 123;
        continue;
        i3 = 95;
        continue;
        i3 = 109;
        continue;
        i3 = 16;
      }
    }
  }

  public f(d paramd)
  {
    this.a = paramd;
  }

  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Context localContext = paramWebView.getContext();
    new StringBuilder(z[1]).append(paramString).toString();
    x.d();
    String str1;
    try
    {
      str1 = String.format(z[18], new Object[] { paramString });
      if (this.a.O)
      {
        localContext.startActivity(new Intent(z[14], Uri.parse(paramString)));
        ServiceInterface.a(this.a.c, 1016, str1, a.d);
        return true;
      }
      if (paramString.endsWith(z[7]))
      {
        Intent localIntent1 = new Intent(z[14]);
        localIntent1.setDataAndType(Uri.parse(paramString), z[20]);
        paramWebView.getContext().startActivity(localIntent1);
        return true;
      }
    }
    catch (Exception localException)
    {
      x.f();
      return true;
    }
    if ((paramString.endsWith(z[17])) || (paramString.endsWith(z[3])))
    {
      Intent localIntent2 = new Intent(z[14]);
      localIntent2.setDataAndType(Uri.parse(paramString), z[19]);
      paramWebView.getContext().startActivity(localIntent2);
      return true;
    }
    if (paramString.startsWith(z[8]))
    {
      paramWebView.loadUrl(paramString);
      ServiceInterface.a(this.a.c, 1016, str1, a.d);
    }
    else if ((paramString != null) && (paramString.startsWith(z[5])))
    {
      if ((paramString.lastIndexOf(z[13]) < 0) && (!paramString.startsWith(z[5])))
        if (paramString.indexOf("?") <= 0)
          break label640;
      label640: String str6;
      for (paramString = paramString + z[21]; ; paramString = str6)
      {
        paramString.lastIndexOf(z[13]);
        int i = paramString.indexOf("?");
        String str2 = paramString.substring(0, i);
        String str3 = paramString.substring(i);
        new StringBuilder(z[4]).append(str2).toString();
        x.b();
        new StringBuilder(z[2]).append(str3).toString();
        x.b();
        boolean bool = str2.startsWith(z[5]);
        Intent localIntent3 = null;
        if (bool)
        {
          String[] arrayOfString1 = str2.split(":");
          localIntent3 = null;
          if (arrayOfString1 != null)
          {
            int j = arrayOfString1.length;
            localIntent3 = null;
            if (j == 2)
            {
              int k = 6 + str3.indexOf(z[10]);
              int m = str3.indexOf(z[15]);
              String str4 = str3.substring(k, m);
              String str5 = str3.substring(m + 9);
              String[] arrayOfString2 = new String[1];
              arrayOfString2[0] = arrayOfString1[1];
              localIntent3 = new Intent(z[16]);
              localIntent3.setType(z[9]);
              localIntent3.putExtra(z[12], arrayOfString2);
              localIntent3.putExtra(z[11], str4);
              localIntent3.putExtra(z[0], str5);
            }
          }
        }
        if (localIntent3 != null)
          localContext.startActivity(localIntent3);
        ServiceInterface.a(this.a.c, 1016, str1, a.d);
        return true;
        str6 = paramString + z[6];
      }
    }
    return false;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.f
 * JD-Core Version:    0.6.2
 */