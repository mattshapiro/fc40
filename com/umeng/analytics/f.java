package com.umeng.analytics;

public abstract class f
  implements Runnable
{
  public abstract void a();

  public void run()
  {
    try
    {
      a();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localThrowable == null);
      localThrowable.printStackTrace();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.f
 * JD-Core Version:    0.6.2
 */