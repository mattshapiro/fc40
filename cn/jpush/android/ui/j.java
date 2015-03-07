package cn.jpush.android.ui;

import android.view.View;
import android.view.View.OnClickListener;
import cn.jpush.android.api.m;
import cn.jpush.android.service.ServiceInterface;

final class j
  implements View.OnClickListener
{
  j(PushActivity paramPushActivity)
  {
  }

  public final void onClick(View paramView)
  {
    ServiceInterface.a(PushActivity.a(this.a), 1006, this.a);
    m.a(this.a, PushActivity.b(this.a), 0);
    this.a.finish();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.j
 * JD-Core Version:    0.6.2
 */