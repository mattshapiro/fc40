package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.common.message.Log;
import java.util.ArrayList;
import java.util.Iterator;

public class BootBroadcastReceiver extends BroadcastReceiver
{
  private static final String b = "BootBroadcastReceiver";
  private static final String c = "android.intent.action.BOOT_COMPLETED";
  Runnable a = new Runnable()
  {
    public void run()
    {
      Iterator localIterator = MsgLogStore.getInstance(BootBroadcastReceiver.a(BootBroadcastReceiver.this)).getMsgLogIdTypes().iterator();
      while (localIterator.hasNext())
      {
        MsgLogStore.MsgLogIdType localMsgLogIdType = (MsgLogStore.MsgLogIdType)localIterator.next();
        if ((MsgLogStore.getInstance(BootBroadcastReceiver.a(BootBroadcastReceiver.this)).getMsgLog(localMsgLogIdType.msgId) == null) && (localMsgLogIdType.msgType.equals("notification")))
          MsgLogStore.getInstance(BootBroadcastReceiver.a(BootBroadcastReceiver.this)).addLog(localMsgLogIdType.msgId, 2, System.currentTimeMillis());
      }
    }
  };
  private Context d;

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.c("BootBroadcastReceiver", "Boot this system , BootBroadcastReceiver onReceive()");
    if (paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED"))
    {
      this.d = paramContext;
      new Thread(this.a).start();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.BootBroadcastReceiver
 * JD-Core Version:    0.6.2
 */