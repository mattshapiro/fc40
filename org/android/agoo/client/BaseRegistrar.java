package org.android.agoo.client;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aN;

public class BaseRegistrar
{
  static void a(Context paramContext)
  {
    try
    {
      e(paramContext);
      d(paramContext);
      f(paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, true);
  }

  protected static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    try
    {
      aN.a(paramContext);
      if (TextUtils.isEmpty(paramString2))
        AgooSettings.setAgooSecurityMode(paramContext, true);
      aI.j(paramContext);
      aI.a(paramContext, paramString1, paramString2, paramString3);
      aI.t(paramContext);
      b(paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  static void b(Context paramContext)
  {
    try
    {
      Intent localIntent = IntentHelper.createComandIntent(paramContext, "register");
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  static void c(Context paramContext)
  {
    try
    {
      Intent localIntent = IntentHelper.createComandIntent(paramContext, "unregister");
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void checkDevice(Context paramContext)
  {
  }

  private static final void d(Context paramContext)
  {
  }

  private static final void e(Context paramContext)
  {
  }

  private static void f(Context paramContext)
  {
  }

  public static final String getRegistrationId(Context paramContext)
  {
    try
    {
      String str = aI.q(paramContext);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public static final boolean isRegistered(Context paramContext)
  {
    try
    {
      boolean bool1 = TextUtils.isEmpty(aI.q(paramContext));
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      return bool2;
    }
    catch (Throwable localThrowable)
    {
      Log.w("BaseRegistrar", "isRegistered", localThrowable);
    }
    return false;
  }

  public static void unregister(Context paramContext)
  {
    try
    {
      aN.h(paramContext);
      aN.b(paramContext);
      aI.j(paramContext);
      c(paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.client.BaseRegistrar
 * JD-Core Version:    0.6.2
 */