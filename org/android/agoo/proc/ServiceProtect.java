package org.android.agoo.proc;

import android.content.Context;
import android.util.Log;

class ServiceProtect
{
  private static final String a = "ServiceProtect";
  private static volatile boolean b = false;

  private static int a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (b)
      try
      {
        int i = start(paramString1, paramString2, paramString3, paramInt);
        return i;
      }
      catch (Throwable localThrowable)
      {
        Log.e("ServiceProtect", "startp", localThrowable);
      }
    return -1;
  }

  static void a(Context paramContext)
  {
    if (d.a(paramContext).b().a())
    {
      d.a(paramContext).a();
      d.a(paramContext).c();
    }
    b = true;
  }

  static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (c())
      a(paramString1, paramString2, paramString3, paramInt);
  }

  static boolean a()
  {
    return b;
  }

  static void b()
  {
    if (b);
    try
    {
      stop();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }

  static boolean c()
  {
    if (b);
    while (true)
    {
      try
      {
        int j = hasRted();
        i = j;
        if (i != 1)
          break;
        return true;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      int i = 0;
    }
    return false;
  }

  private static native int hasRted();

  private static native int start(String paramString1, String paramString2, String paramString3, int paramInt);

  private static native void startTest(String paramString1, String paramString2, String paramString3, int paramInt);

  private static native void stop();
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.proc.ServiceProtect
 * JD-Core Version:    0.6.2
 */