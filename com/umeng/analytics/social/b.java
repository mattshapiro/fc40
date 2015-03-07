package com.umeng.analytics.social;

import android.util.Log;

public class b
{
  public static void a(String paramString1, String paramString2)
  {
    if (e.v)
      Log.i(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    if (e.v)
      Log.i(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void b(String paramString1, String paramString2)
  {
    if (e.v)
      Log.e(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Exception paramException)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    int i;
    if (e.v)
    {
      Log.e(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
      arrayOfStackTraceElement = paramException.getStackTrace();
      i = arrayOfStackTraceElement.length;
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
      Log.e(paramString1, "        at\t " + localStackTraceElement.toString());
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if (e.v)
      Log.d(paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Exception paramException)
  {
    if (e.v)
      Log.d(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void d(String paramString1, String paramString2)
  {
    if (e.v)
      Log.v(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2, Exception paramException)
  {
    if (e.v)
      Log.v(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void e(String paramString1, String paramString2)
  {
    if (e.v)
      Log.w(paramString1, paramString2);
  }

  public static void e(String paramString1, String paramString2, Exception paramException)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    int i;
    if (e.v)
    {
      Log.w(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
      arrayOfStackTraceElement = paramException.getStackTrace();
      i = arrayOfStackTraceElement.length;
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
      Log.w(paramString1, "        at\t " + localStackTraceElement.toString());
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.b
 * JD-Core Version:    0.6.2
 */