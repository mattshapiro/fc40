package com.umeng.analytics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class e
{
  private static ExecutorService a = Executors.newSingleThreadExecutor();
  private static long b = 5L;
  private static ExecutorService c = Executors.newSingleThreadExecutor();

  public static void a()
  {
    try
    {
      if (!a.isShutdown())
        a.shutdown();
      if (!c.isShutdown())
        c.shutdown();
      a.awaitTermination(b, TimeUnit.SECONDS);
      c.awaitTermination(b, TimeUnit.SECONDS);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void a(Runnable paramRunnable)
  {
    if (a.isShutdown())
      a = Executors.newSingleThreadExecutor();
    a.execute(paramRunnable);
  }

  public static void b(Runnable paramRunnable)
  {
    if (c.isShutdown())
      c = Executors.newSingleThreadExecutor();
    c.execute(paramRunnable);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.e
 * JD-Core Version:    0.6.2
 */