package cn.jpush.android.ui;

import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public final class d extends WebChromeClient
{
  private final ProgressBar a;
  private Handler b = new e(this);

  public d(ProgressBar paramProgressBar)
  {
    this.a = paramProgressBar;
  }

  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if (this.a != null)
    {
      if (this.a.getVisibility() != 0)
        this.a.setVisibility(0);
      this.a.setProgress(paramInt);
      if (this.a.getProgress() == 100)
        this.b.sendEmptyMessageDelayed(0, 500L);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.d
 * JD-Core Version:    0.6.2
 */