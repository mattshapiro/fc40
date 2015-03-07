package cn.jpush.android.api;

import android.content.Context;
import android.content.Intent;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.data.d;
import cn.jpush.android.util.JavascriptCallback;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;

final class t
  implements JavascriptCallback
{
  private static final String[] z;
  private Context a = null;
  private WindowManager b = null;
  private WebView c = null;
  private ImageButton d = null;

  static
  {
    Object localObject1 = new String[8];
    int i = 0;
    String str1 = "\tEX=\tdSr5\026X\026&r";
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
        i3 = 82;
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
        str1 = "-UEo7\023mZ~ \n{Sy\004\027IAX3\022@Tz1\025";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "\035B\030q\"\013_^53\020HDt;\032\002wX\0067zO\013!|wI\0233";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "*DS;3\035X_m;\nU\026u3\023I\026r!^BCw>^CD;7\023\\Bb~^k_m7^YF5|";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "S\001\0336^\\Wi3\023_\026!r";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "*DS;3\035X_m;\nU\026u3\023I\026r!^EXm3\022ER7r9E@~r\013\\\0305";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "\037OBr=\020\f\0336^_Bz \nmUo;\bEBb\020\007bWv7S\001\0336S\001\033z1\nE@r&\007bWv7^\026\026";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\tEX=\t{_&\026\f\013;";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 126;
        continue;
        i3 = 44;
        continue;
        i3 = 54;
        continue;
        i3 = 27;
      }
    }
  }

  public t(Context paramContext, d paramd, WindowManager paramWindowManager, WebView paramWebView, ImageButton paramImageButton)
  {
    x.c();
    this.a = paramContext;
    this.b = paramWindowManager;
    this.c = paramWebView;
    this.d = paramImageButton;
  }

  public final void close()
  {
    x.c();
    q.a(this.b, this.c, this.d);
  }

  public final int getWindowHeight()
  {
    new StringBuilder(z[0]).append(q.b()).toString();
    x.c();
    return q.b();
  }

  public final int getWindowWidth()
  {
    new StringBuilder(z[7]).append(q.a()).toString();
    x.c();
    return q.a();
  }

  public final void startActivityByName(String paramString1, String paramString2)
  {
    new StringBuilder(z[6]).append(paramString1).append(z[4]).append(paramString2).toString();
    x.c();
    if (ai.a(paramString1))
      x.e(z[1], z[3]);
    if (this.a == null);
    while (true)
    {
      return;
      try
      {
        Class localClass = Class.forName(paramString1);
        if (localClass != null)
        {
          Intent localIntent = new Intent(this.a, localClass);
          localIntent.putExtra(z[2], paramString2);
          localIntent.setFlags(268435456);
          this.a.startActivity(localIntent);
          close();
          return;
        }
      }
      catch (Exception localException)
      {
        x.e(z[1], z[5]);
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.t
 * JD-Core Version:    0.6.2
 */