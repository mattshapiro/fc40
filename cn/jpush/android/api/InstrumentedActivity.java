package cn.jpush.android.api;

import android.app.Activity;

public class InstrumentedActivity extends Activity
{
  protected void onPause()
  {
    super.onPause();
    JPushInterface.onPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    JPushInterface.onResume(this);
  }

  public void onStart()
  {
    super.onStart();
  }

  public void onStop()
  {
    super.onStop();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.InstrumentedActivity
 * JD-Core Version:    0.6.2
 */