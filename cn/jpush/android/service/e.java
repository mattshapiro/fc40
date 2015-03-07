package cn.jpush.android.service;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.api.m;

final class e extends Handler
{
  e(DownloadService paramDownloadService)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    m.a(this.a, paramMessage.what);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.e
 * JD-Core Version:    0.6.2
 */