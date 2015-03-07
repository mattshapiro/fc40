package com.umeng.message.proguard;

public class bz
{
  private static final String a = "ThreadUtil";
  private static int b;

  private static int a()
  {
    try
    {
      int i = b;
      b = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void a(Runnable paramRunnable)
  {
    if (paramRunnable != null);
    try
    {
      new Thread(paramRunnable, "agoo-thread-" + a()).start();
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.e("ThreadUtil", "startTread", localThrowable);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bz
 * JD-Core Version:    0.6.2
 */