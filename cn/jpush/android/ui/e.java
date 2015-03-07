package cn.jpush.android.ui;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

final class e extends Handler
{
  e(d paramd)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (d.a(this.a) != null)
    {
      d.a(this.a).setProgress(0);
      d.a(this.a).setVisibility(8);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.e
 * JD-Core Version:    0.6.2
 */