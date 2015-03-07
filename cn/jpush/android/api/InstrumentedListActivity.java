package cn.jpush.android.api;

import android.app.ListActivity;

public class InstrumentedListActivity extends ListActivity
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
 * Qualified Name:     cn.jpush.android.api.InstrumentedListActivity
 * JD-Core Version:    0.6.2
 */