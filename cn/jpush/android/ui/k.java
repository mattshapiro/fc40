package cn.jpush.android.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;

final class k extends Handler
{
  k(PushActivity paramPushActivity)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1:
    case 3:
    default:
    case 0:
    case 2:
    case 4:
    case 5:
    case 6:
    }
    do
    {
      return;
      this.a.setRequestedOrientation(0);
      PushActivity.c(this.a).removeMessages(0);
      PushActivity.c(this.a).removeMessages(1);
      sendEmptyMessageDelayed(1, 1000L);
      return;
      this.a.setRequestedOrientation(1);
      PushActivity.c(this.a).removeMessages(2);
      PushActivity.c(this.a).removeMessages(3);
      sendEmptyMessageDelayed(3, 1000L);
      return;
      this.a.setRequestedOrientation(1);
      PushActivity.c(this.a).removeMessages(4);
      PushActivity.c(this.a).removeMessages(5);
      sendEmptyMessageDelayed(5, 1000L);
      return;
      PushActivity.d(this.a);
      return;
    }
    while (PushActivity.e(this.a) == null);
    PushActivity.e(this.a).dismiss();
    a.e(this.a.getApplicationContext(), (String)paramMessage.obj);
    ServiceInterface.a(PushActivity.a(this.a), 1007, this.a);
    this.a.finish();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.k
 * JD-Core Version:    0.6.2
 */