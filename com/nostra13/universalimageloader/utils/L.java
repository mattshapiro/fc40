package com.nostra13.universalimageloader.utils;

import android.util.Log;

public final class L
{
  private static final String LOG_FORMAT = "%1$s\n%2$s";

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
  }

  public static void e(String paramString, Object[] paramArrayOfObject)
  {
  }

  public static void e(Throwable paramThrowable)
  {
  }

  public static void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
  }

  public static void i(String paramString, Object[] paramArrayOfObject)
  {
  }

  private static void log(int paramInt, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length > 0)
      paramString = String.format(paramString, paramArrayOfObject);
    if (paramThrowable == null)
      return;
    if (paramString == null);
    for (String str = paramThrowable.getMessage(); ; str = paramString)
    {
      String.format("%1$s\n%2$s", new Object[] { str, Log.getStackTraceString(paramThrowable) });
      return;
    }
  }

  public static void w(String paramString, Object[] paramArrayOfObject)
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.L
 * JD-Core Version:    0.6.2
 */