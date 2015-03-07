package com.umeng.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.umeng.message.entity.UMessage;
import java.io.Serializable;

public class UpdateActionReceiver extends BroadcastReceiver
{
  private UMessage a;

  public UpdateActionReceiver(UMessage paramUMessage)
  {
    this.a = paramUMessage;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (PushAgent.getInstance(paramContext).isIncludesUmengUpdateSDK())
    {
      Bundle localBundle = paramIntent.getBundleExtra("UpdateListener");
      if (localBundle.getInt("UpdateStatus") == 0)
      {
        Serializable localSerializable = localBundle.getSerializable("UpdateResponse");
        PushAgent.getInstance(paramContext).setUpdateResponse(localSerializable);
        UmengMessageHandler localUmengMessageHandler = (UmengMessageHandler)PushAgent.getInstance(paramContext).getMessageHandler();
        if (localUmengMessageHandler != null)
          localUmengMessageHandler.dealWithNotificationMessage(paramContext, this.a);
      }
      LocalBroadcastManager.getInstance(paramContext).unregisterReceiver(this);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.UpdateActionReceiver
 * JD-Core Version:    0.6.2
 */