package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import cn.jpush.android.api.m;
import cn.jpush.android.data.d;
import cn.jpush.android.data.l;
import cn.jpush.android.data.p;
import cn.jpush.android.data.y;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.JavascriptCallback;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.lang.ref.WeakReference;

public class WebViewCallback
  implements JavascriptCallback
{
  private static final String[] z;
  private final WeakReference<Activity> a;
  private final d b;

  static
  {
    Object localObject1 = new String[20];
    int i = 0;
    String str1 = "q~`X\021Gwn\032\023Ep8\034\035Qun\027\023B;/X";
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
        i3 = 114;
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
        str1 = "out\031\036O\"\025\027Uhc\037\027rbr\035R@tpX\026Ill\024\035G\"UR";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "suj\031\034BwgX\033Hog\026\006\006!\"";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "q~`.\033ClA\031\036Jyc\033\031";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "Eu,\022\002ShjV\023Hp\027\033B5G &tZ";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "rsgX\023Eok\016\033Rb\"\026\023K~\"\021\001\006uw\024\036\006tpX\027Kkv\001^\006\\k\016\027\006nrV\\";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "rsgX\023Eok\016\033Rb\"\026\023K~\"\021\001\006rl\016\023JrfTRart\035RSk,V";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "Eu,\022\002ShjV\023Hp\027\033B5C;&oMK,+yKC*3k";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "out\031\036O\"\031\021Rrm\026;B;d\n\035K;U\035\020\0066\"";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "q~`X\021Gwn\032\023Ep8\013\032IlV\027\023Uo\"UR";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "\n;w\n\036\034";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "Oxm\026;B;q\020\035SwfX\020C;k\026\006\0066\"";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "suj\031\034BwgX\033Hog\026\006\006!\"\033\034\bqr\r\001N5c\026\026Ttk\034\\Ouv\035\034R5C;&oTL'3eOK.;rB]7\"cUF=6";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "\n;q\020\035Swf;\036IhgB";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "q~`X\021Gwn\032\023Ep8\033\036OxiX_\006za\f\033IuK\034H";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "\n;q\020\035Swf;\023Hxg\024<Iok\036\033Ezv\021\035H!";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "q~`X\021Gwn\032\023Ep8\035\nCxw\f\027khe5\027Uhc\037\027\0066\"";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "Eu,\022\002ShjV\023Hp\027\033B5k\026\006CuvV3eOK7<yIK;:vNQ0-eZN40gXI";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 38;
        continue;
        i3 = 27;
        continue;
        i3 = 2;
        continue;
        i3 = 120;
      }
    }
  }

  public WebViewCallback(Context paramContext, d paramd)
  {
    this.a = new WeakReference((Activity)paramContext);
    this.b = paramd;
  }

  private void userClick(String paramString)
  {
    try
    {
      int j = Integer.parseInt(paramString);
      i = j;
      ServiceInterface.a(this.b.c, i, (Context)this.a.get());
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        new StringBuilder(z[8]).append(paramString).toString();
        int i = 1100;
        x.f();
      }
    }
  }

  // ERROR //
  public void click(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 83	cn/jpush/android/ui/WebViewCallback:a	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 105	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: ifnull +123 -> 130
    //   10: new 114	java/lang/StringBuilder
    //   13: dup
    //   14: getstatic 71	cn/jpush/android/ui/WebViewCallback:z	[Ljava/lang/String;
    //   17: bipush 15
    //   19: aaload
    //   20: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: getstatic 71	cn/jpush/android/ui/WebViewCallback:z	[Ljava/lang/String;
    //   30: bipush 14
    //   32: aaload
    //   33: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_2
    //   37: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: getstatic 71	cn/jpush/android/ui/WebViewCallback:z	[Ljava/lang/String;
    //   43: bipush 16
    //   45: aaload
    //   46: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_3
    //   50: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: pop
    //   57: invokestatic 132	cn/jpush/android/util/x:c	()V
    //   60: aload_0
    //   61: aload_1
    //   62: invokespecial 134	cn/jpush/android/ui/WebViewCallback:userClick	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokestatic 140	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   69: istore 9
    //   71: iload 9
    //   73: istore 6
    //   75: aload_3
    //   76: invokestatic 140	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   79: istore 11
    //   81: iload 6
    //   83: istore 7
    //   85: iload 11
    //   87: istore 8
    //   89: iload 8
    //   91: ifeq +21 -> 112
    //   94: aload_0
    //   95: getfield 83	cn/jpush/android/ui/WebViewCallback:a	Ljava/lang/ref/WeakReference;
    //   98: invokevirtual 105	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   101: checkcast 107	android/content/Context
    //   104: aload_0
    //   105: getfield 85	cn/jpush/android/ui/WebViewCallback:b	Lcn/jpush/android/data/d;
    //   108: iconst_0
    //   109: invokestatic 145	cn/jpush/android/api/m:a	(Landroid/content/Context;Lcn/jpush/android/data/d;I)V
    //   112: iload 7
    //   114: ifeq +16 -> 130
    //   117: aload_0
    //   118: getfield 83	cn/jpush/android/ui/WebViewCallback:a	Ljava/lang/ref/WeakReference;
    //   121: invokevirtual 105	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   124: checkcast 78	android/app/Activity
    //   127: invokevirtual 148	android/app/Activity:finish	()V
    //   130: return
    //   131: astore 5
    //   133: iconst_0
    //   134: istore 6
    //   136: iload 6
    //   138: istore 7
    //   140: iconst_0
    //   141: istore 8
    //   143: goto -54 -> 89
    //   146: astore 10
    //   148: goto -12 -> 136
    //
    // Exception table:
    //   from	to	target	type
    //   65	71	131	java/lang/Exception
    //   75	81	146	java/lang/Exception
  }

  public void close()
  {
    if (this.a.get() != null)
    {
      x.c();
      ((Activity)this.a.get()).finish();
    }
  }

  public void createShortcut(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      int j = Integer.parseInt(paramString3);
      i = j;
      if (this.a.get() == null)
        return;
    }
    catch (Exception localException)
    {
      int i;
      while (true)
      {
        new StringBuilder(z[11]).append(paramString3).toString();
        x.c();
        i = 0;
      }
      new StringBuilder(z[12]).append(paramString1).append(z[10]).append(paramString2).toString();
      x.c();
      a.a((Context)this.a.get(), paramString1, paramString2, m.a(i));
    }
  }

  public void download(String paramString)
  {
    if (this.a.get() == null)
      return;
    new StringBuilder(z[0]).append(paramString).toString();
    x.c();
    Context localContext = (Context)this.a.get();
    d locald = this.b;
    if (locald.a())
    {
      l locall = (l)locald;
      if (TextUtils.isEmpty(locall.ac))
        locall.ac = paramString;
      if (!TextUtils.isEmpty(locall.ah))
      {
        a.e(localContext, locall.ah);
        m.a(localContext, locall, 0);
        m.a(localContext, locall, 1);
      }
    }
    else if (locald.b())
    {
      y localy = (y)locald;
      if (TextUtils.isEmpty(localy.W))
        localy.W = paramString;
      if (!TextUtils.isEmpty(localy.aa))
        localContext.startActivity(a.a(localContext, locald, false));
    }
    else
    {
      new StringBuilder(z[1]).append(locald.o).toString();
      x.e();
      return;
    }
    ServiceInterface.a(localContext, locald);
  }

  public void download(String paramString1, String paramString2)
  {
    if (this.a.get() == null)
      return;
    userClick(paramString1);
    download(paramString2);
    m.a((Context)this.a.get(), this.b, 0);
    ((Activity)this.a.get()).finish();
  }

  public void download(String paramString1, String paramString2, String paramString3)
  {
    new StringBuilder(z[19]).append(paramString3).toString();
    x.b();
    download(paramString1, paramString2);
  }

  public void executeMsgMessage(String paramString)
  {
    if (PushService.b)
    {
      new StringBuilder(z[17]).append(paramString).toString();
      x.c();
      if (this.a.get() != null);
    }
    else
    {
      return;
    }
    p.a((Context)this.a.get(), paramString);
  }

  public void showToast(String paramString)
  {
    if (this.a.get() != null)
    {
      new StringBuilder(z[9]).append(paramString).toString();
      x.c();
      Toast.makeText((Context)this.a.get(), paramString, 0).show();
    }
  }

  public void startActivityByIntent(String paramString1, String paramString2)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null)
      return;
    try
    {
      Intent localIntent = new Intent(paramString1);
      localIntent.addCategory(localContext.getPackageName());
      localIntent.putExtra(z[4], paramString2);
      localIntent.setFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException)
    {
      x.e(z[3], z[2] + paramString1);
    }
  }

  public void startActivityByName(String paramString1, String paramString2)
  {
    if (ai.a(paramString1))
      x.e(z[3], z[5]);
    Context localContext = (Context)this.a.get();
    if (localContext == null);
    while (true)
    {
      return;
      try
      {
        Class localClass = Class.forName(paramString1);
        if (localClass != null)
        {
          Intent localIntent = new Intent(localContext, localClass);
          localIntent.putExtra(z[7], paramString2);
          localIntent.setFlags(268435456);
          localContext.startActivity(localIntent);
          return;
        }
      }
      catch (Exception localException)
      {
        x.e(z[3], z[6]);
      }
    }
  }

  public void startMainActivity(String paramString)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null)
      return;
    try
    {
      a.h(localContext, paramString);
      return;
    }
    catch (Exception localException)
    {
      x.e(z[3], z[13]);
    }
  }

  public void triggerNativeAction(String paramString)
  {
    Context localContext = (Context)this.a.get();
    if (localContext == null)
      return;
    a.b(localContext, z[18], paramString);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.WebViewCallback
 * JD-Core Version:    0.6.2
 */