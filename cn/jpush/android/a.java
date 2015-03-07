package cn.jpush.android;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import cn.jpush.android.api.k;
import cn.jpush.android.util.ab;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  public static int a;
  public static String b;
  public static String c;
  public static Context d;
  public static String e;
  public static String f;
  public static int g;
  public static String h;
  public static boolean i;
  private static AtomicBoolean j;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[19];
    int k = 0;
    String str1 = "";
    int m = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int n = localObject3.length;
    int i1 = 0;
    label36: Object localObject4;
    int i2;
    int i3;
    Object localObject5;
    label52: int i4;
    int i5;
    if (n <= 1)
    {
      localObject4 = localObject3;
      i2 = i1;
      i3 = n;
      localObject5 = localObject3;
      i4 = localObject5[i1];
      switch (i2 % 5)
      {
      default:
        i5 = 102;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i1] = ((char)(i5 ^ i4));
      i1 = i2 + 1;
      if (i3 == 0)
      {
        localObject5 = localObject4;
        i2 = i1;
        i1 = i3;
        break label52;
      }
      n = i3;
      localObject3 = localObject4;
      if (n > i1)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (m)
      {
      default:
        localObject1[k] = str2;
        k = 1;
        str1 = "=;5\016\026\r6$\023\002Ru6\027\017\00404V\022\007u7\023\022H6%\004\024\r;$V\007\030%<\037\005\t!9\031\bH<>\020\t";
        localObject1 = localObject2;
        m = 0;
        break;
      case 0:
        localObject1[k] = str2;
        k = 2;
        str1 = "\0164<\005\003";
        m = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[k] = str2;
        k = 3;
        str1 = "&\032p\033\003\0344p\022\007\0344p\022\003\016<>\023\002H<>V\013\t;9\020\003\033!~";
        m = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[k] = str2;
        k = 4;
        str1 = "\0050$\027\002\t!1LF\t% =\003\021u}V";
        m = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[k] = str2;
        k = 5;
        str1 = "";
        m = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[k] = str2;
        k = 6;
        str1 = "\0050$\027\002\t!1LF\t% =\003\021u}V\b\007!p\022\003\016<>\023\002H<>V\013\t;9\020\003\033!";
        m = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[k] = str2;
        k = 7;
        str1 = "";
        m = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[k] = str2;
        k = 8;
        str1 = "\0050$\027\002\t!1LF+4>V\b\007!p\021\003\034u\021\006\026\004<3\027\022\001:>?\b\016:";
        m = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[k] = str2;
        k = 9;
        str1 = "\0024&\027H\0060$X\026\03206\023\024!\005&@'\f1\"\023\025\0330#";
        m = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[k] = str2;
        k = 10;
        str1 = "\0024&\027H\0060$X\026\03206\023\024!\005&B5\03443\035";
        m = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[k] = str2;
        k = 11;
        str1 = "\"\005%\005\016H61\030\b\007!p\024\003H<>\037\022\0014<\037\034\r1p\025\t\005%5\032\003\0340<\017F\f 5V\022\007u\036#*$u1\006\026!;6\031H";
        m = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[k] = str2;
        k = 12;
        str1 = "\0050$\027\002\t!1LF\013=1\030\b\r9p[F";
        m = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[k] = str2;
        k = 13;
        str1 = "";
        m = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[k] = str2;
        k = 14;
        str1 = "\"\005\005%.7\026\0307(&\020\034";
        m = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[k] = str2;
        k = 15;
        str1 = "";
        m = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[k] = str2;
        k = 16;
        str1 = "\034'%\023";
        m = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[k] = str2;
        k = 17;
        str1 = "";
        m = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[k] = str2;
        k = 18;
        str1 = "!;&\027\n\0011p\027\026\030\0365\017FRu";
        m = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[k] = str2;
        z = localObject2;
        j = new AtomicBoolean(false);
        i = false;
        return;
        i5 = 104;
        continue;
        i5 = 85;
        continue;
        i5 = 80;
        continue;
        i5 = 118;
      }
    }
  }

  public static boolean a(Context paramContext)
  {
    if (j.get())
      return true;
    x.c();
    ab.a(paramContext.getApplicationContext());
    ApplicationInfo localApplicationInfo1 = b(paramContext);
    if (localApplicationInfo1 == null)
    {
      x.e(z[0], z[11]);
      return false;
    }
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      g = localPackageInfo.versionCode;
      String str3 = localPackageInfo.versionName;
      h = str3;
      if (str3.length() > 30)
        h = h.substring(0, 30);
      d = paramContext.getApplicationContext();
      if ((Build.VERSION.SDK_INT >= 14) && ((paramContext instanceof Application)))
      {
        boolean bool = cn.jpush.android.util.a.i(paramContext);
        k.a = bool;
        if (bool)
          k.a((Application)paramContext.getApplicationContext());
      }
      b = paramContext.getPackageName();
      a = localApplicationInfo1.icon;
      if (a == 0)
        x.e(z[0], z[5]);
      c = paramContext.getPackageManager().getApplicationLabel(localApplicationInfo1).toString();
    }
    catch (Exception localException)
    {
      try
      {
        ApplicationInfo localApplicationInfo2 = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (localApplicationInfo2 != null);
        for (localBundle = localApplicationInfo2.metaData; ; localBundle = null)
        {
          if (localBundle == null)
            break label533;
          String str1 = localBundle.getString(z[17]);
          f = str1;
          if (!ai.a(str1))
            break label331;
          x.e(z[0], z[6]);
          return false;
          localException = localException;
          x.b(z[0], z[7]);
          break;
          x.b(z[0], z[8]);
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        Bundle localBundle;
        while (true)
        {
          x.a(z[0], z[1], localNameNotFoundException);
          localBundle = null;
        }
        label331: if (f.length() != 24)
        {
          x.e(z[0], z[18] + f + z[15]);
          return false;
        }
        x.b(z[0], z[4] + f);
        String str2 = localBundle.getString(z[14]);
        e = str2;
        if (!ai.a(str2))
          break label500;
      }
    }
    x.b(z[0], z[13]);
    while (true)
    {
      if (Build.VERSION.SDK_INT == 8)
      {
        System.setProperty(z[10], z[16]);
        System.setProperty(z[9], z[2]);
      }
      j.set(true);
      return true;
      label500: x.b(z[0], z[12] + e);
      continue;
      label533: x.b(z[0], z[3]);
    }
  }

  private static ApplicationInfo b(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0);
      return localApplicationInfo;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      x.b(z[0], z[1], localNameNotFoundException);
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a
 * JD-Core Version:    0.6.2
 */