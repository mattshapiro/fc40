package cn.jpush.android.service;

import android.os.PowerManager.WakeLock;

public final class r
{
  private static r a = null;
  private PowerManager.WakeLock b = null;

  public static r a()
  {
    if (a == null)
      a = new r();
    return a;
  }

  public final void a(PowerManager.WakeLock paramWakeLock)
  {
    this.b = paramWakeLock;
  }

  public final PowerManager.WakeLock b()
  {
    return this.b;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.r
 * JD-Core Version:    0.6.2
 */