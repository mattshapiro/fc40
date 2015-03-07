package com.umeng.common.message;

public class Log
{
  public static boolean LOG = false;

  public static void a(String paramString1, String paramString2)
  {
    if (LOG)
      android.util.Log.i(paramString1, paramString2);
  }

  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    if (LOG)
      android.util.Log.i(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void b(String paramString1, String paramString2)
  {
    if (LOG)
      android.util.Log.e(paramString1, paramString2);
  }

  public static void b(String paramString1, String paramString2, Exception paramException)
  {
    if (LOG)
    {
      android.util.Log.e(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
      for (StackTraceElement localStackTraceElement : paramException.getStackTrace())
        android.util.Log.e(paramString1, "        at\t " + localStackTraceElement.toString());
    }
  }

  public static void c(String paramString1, String paramString2)
  {
    if (LOG)
      android.util.Log.d(paramString1, paramString2);
  }

  public static void c(String paramString1, String paramString2, Exception paramException)
  {
    if (LOG)
      android.util.Log.d(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void d(String paramString1, String paramString2)
  {
    if (LOG)
      android.util.Log.v(paramString1, paramString2);
  }

  public static void d(String paramString1, String paramString2, Exception paramException)
  {
    if (LOG)
      android.util.Log.v(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
  }

  public static void e(String paramString1, String paramString2)
  {
    if (LOG)
      android.util.Log.w(paramString1, paramString2);
  }

  public static void e(String paramString1, String paramString2, Exception paramException)
  {
    if (LOG)
    {
      android.util.Log.w(paramString1, paramException.toString() + ":  [" + paramString2 + "]");
      for (StackTraceElement localStackTraceElement : paramException.getStackTrace())
        android.util.Log.w(paramString1, "        at\t " + localStackTraceElement.toString());
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.common.message.Log
 * JD-Core Version:    0.6.2
 */