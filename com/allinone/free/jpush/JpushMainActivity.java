package com.allinone.free.jpush;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import com.umeng.analytics.MobclickAgent;

public class JpushMainActivity extends Activity
{
  public static final String KEY_EXTRAS = "extras";
  public static final String KEY_MESSAGE = "message";
  public static final String KEY_TITLE = "title";
  public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
  public static boolean isForeground = false;
  private MessageReceiver mMessageReceiver;

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903099);
    registerMessageReceiver();
  }

  protected void onDestroy()
  {
    unregisterReceiver(this.mMessageReceiver);
    super.onDestroy();
  }

  protected void onPause()
  {
    isForeground = false;
    JPushInterface.init(this);
    MobclickAgent.onPause(this);
    super.onPause();
  }

  protected void onResume()
  {
    isForeground = true;
    JPushInterface.onResume(this);
    MobclickAgent.onResume(this);
    super.onResume();
  }

  public void registerMessageReceiver()
  {
    this.mMessageReceiver = new MessageReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.setPriority(1000);
    localIntentFilter.addAction("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION");
    registerReceiver(this.mMessageReceiver, localIntentFilter);
  }

  public class MessageReceiver extends BroadcastReceiver
  {
    public MessageReceiver()
    {
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION".equals(paramIntent.getAction()))
      {
        String str = paramIntent.getStringExtra("message");
        paramIntent.getStringExtra("extras");
        new StringBuilder().append("message : " + str + "\n");
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.jpush.JpushMainActivity
 * JD-Core Version:    0.6.2
 */