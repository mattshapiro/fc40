package com.umeng.message;

import android.content.Context;
import org.android.agoo.client.BaseBroadcastReceiver;

public class UmengBroadcastReceiver extends BaseBroadcastReceiver
{
  protected String a(Context paramContext)
  {
    return PushAgent.getInstance(paramContext).getPushIntentServiceClass();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengBroadcastReceiver
 * JD-Core Version:    0.6.2
 */