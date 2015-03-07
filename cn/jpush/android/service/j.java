package cn.jpush.android.service;

import cn.jpush.android.data.d;

final class j
  implements Runnable
{
  j(PushService paramPushService, d paramd)
  {
  }

  public final void run()
  {
    ServiceInterface.a(this.b.getApplicationContext(), this.a);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.j
 * JD-Core Version:    0.6.2
 */