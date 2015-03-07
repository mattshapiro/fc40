package cn.jpush.android.service;

import cn.jpush.android.util.x;

final class k
  implements Runnable
{
  k(PushService paramPushService)
  {
  }

  public final void run()
  {
    PushService.a(this.a, true);
    PushService.a(this.a, false, true, true);
    x.c();
    PushService.b(this.a);
    PushService.a(this.a, false);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.k
 * JD-Core Version:    0.6.2
 */