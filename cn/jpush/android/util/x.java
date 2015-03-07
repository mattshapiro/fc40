package cn.jpush.android.util;

import android.util.Log;
import cn.jpush.android.service.PushService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public final class x
{
  private static final SimpleDateFormat a;
  private static ArrayList<String> b;
  private static boolean c;
  private static boolean d;
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "gr";
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
          i3 = 97;
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
        str1 = "p\002jo\t";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        str1 = "w\0371x\005e\032W&\fWhlo>i\001L";
        j = 2;
        arrayOfString2 = arrayOfString1;
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        a = new SimpleDateFormat(z[2]);
        b = new ArrayList();
        c = false;
        d = false;
        return;
        i3 = 58;
        break label96;
        i3 = 82;
        break label96;
        i3 = 31;
        break label96;
        i3 = 28;
        break label96;
        m = 0;
      }
    }
  }

  public static void a(String paramString1, String paramString2)
  {
    if ((PushService.b) && (a(2)))
      Log.v(z[1], "[" + paramString1 + z[0] + paramString2);
  }

  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((PushService.b) && (a(5)))
      Log.w(z[1], "[" + paramString1 + z[0] + paramString2, paramThrowable);
  }

  public static boolean a()
  {
    return false;
  }

  private static boolean a(int paramInt)
  {
    return paramInt >= PushService.d;
  }

  public static void b()
  {
  }

  public static void b(String paramString1, String paramString2)
  {
    if ((PushService.b) && (a(3)))
      Log.d(z[1], "[" + paramString1 + z[0] + paramString2);
  }

  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((PushService.b) && (a(6)))
      Log.e(z[1], "[" + paramString1 + z[0] + paramString2, paramThrowable);
  }

  public static void c()
  {
  }

  public static void c(String paramString1, String paramString2)
  {
    if ((PushService.b) && (a(4)))
      Log.i(z[1], "[" + paramString1 + z[0] + paramString2);
  }

  public static void d()
  {
  }

  public static void d(String paramString1, String paramString2)
  {
    if ((PushService.b) && (a(5)))
      Log.w(z[1], "[" + paramString1 + z[0] + paramString2);
  }

  public static void e()
  {
  }

  public static void e(String paramString1, String paramString2)
  {
    if ((PushService.b) && (a(6)))
      Log.e(z[1], "[" + paramString1 + z[0] + paramString2);
  }

  public static void f()
  {
  }

  public static void g()
  {
  }

  public static void h()
  {
  }

  public static void i()
  {
  }

  public static void j()
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.x
 * JD-Core Version:    0.6.2
 */