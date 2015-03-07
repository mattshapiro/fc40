package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.umeng.common.message.Log;
import com.umeng.message.entity.UMessage;
import java.lang.reflect.Method;
import org.android.agoo.client.BaseIntentService;
import org.json.JSONObject;

public abstract class UmengBaseIntentService extends BaseIntentService
{
  private static final String a = UmengBaseIntentService.class.getName();
  private static final String b = "android.intent.action.BOOT_COMPLETED";

  private void a(Context paramContext, UMessage paramUMessage)
  {
    if (PushAgent.getInstance(paramContext).isIncludesUmengUpdateSDK())
    {
      UpdateActionReceiver localUpdateActionReceiver = new UpdateActionReceiver(paramUMessage);
      IntentFilter localIntentFilter = new IntentFilter("com.umeng.message.action.autoupdate");
      LocalBroadcastManager.getInstance(paramContext).registerReceiver(localUpdateActionReceiver, localIntentFilter);
    }
    try
    {
      Class localClass = Class.forName("com.umeng.update.UmengUpdateAgent");
      Class[] arrayOfClass1 = new Class[1];
      arrayOfClass1[0] = Boolean.TYPE;
      Method localMethod1 = localClass.getMethod("setUpdateAutoPopup", arrayOfClass1);
      Method localMethod2 = localClass.getMethod("update", new Class[] { Context.class });
      Class[] arrayOfClass2 = new Class[1];
      arrayOfClass2[0] = Boolean.TYPE;
      Method localMethod3 = localClass.getMethod("setUpdateFromPushMessage", arrayOfClass2);
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Boolean.valueOf(false);
      localMethod1.invoke(localClass, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Boolean.valueOf(true);
      localMethod3.invoke(localClass, arrayOfObject2);
      localMethod2.invoke(localClass, new Object[] { paramContext });
      Log.c(a, "autoUpdate");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Log.c(a, localException.toString());
    }
  }

  protected final Class<?> getAgooService()
  {
    return UmengService.class.getClass();
  }

  protected void onError(Context paramContext, String paramString)
  {
    Log.c(a, "onError()[" + paramString + "]");
  }

  protected void onMessage(Context paramContext, Intent paramIntent)
  {
    if (Process.getElapsedCpuTime() < 3000L)
    {
      Log.a(a, "App is launched by push message");
      PushAgent.setAppLaunchByMessage();
    }
    String str = paramIntent.getStringExtra("body");
    Log.c(a, "onMessage():[" + str + "]");
    try
    {
      UMessage localUMessage = new UMessage(new JSONObject(str));
      UTrack.getInstance(getApplicationContext()).a(localUMessage);
      MsgLogStore.getInstance(paramContext).addLogIdType(localUMessage.msg_id, localUMessage.display_type);
      if (TextUtils.equals("autoupdate", localUMessage.display_type))
        a(paramContext, localUMessage);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  protected void onRegistered(Context paramContext, String paramString)
  {
    Log.c(a, "onRegistered()[" + paramString + "]");
    try
    {
      UTrack.getInstance(getApplicationContext()).trackRegister();
    }
    catch (Exception localException1)
    {
      try
      {
        while (true)
        {
          IUmengRegisterCallback localIUmengRegisterCallback = PushAgent.getInstance(paramContext).getRegisterCallback();
          if (localIUmengRegisterCallback != null)
            localIUmengRegisterCallback.onRegistered(paramString);
          return;
          localException1 = localException1;
          localException1.printStackTrace();
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }

  protected void onUnregistered(Context paramContext, String paramString)
  {
    Log.c(a, "onUnregistered()[" + paramString + "]");
    try
    {
      IUmengUnregisterCallback localIUmengUnregisterCallback = PushAgent.getInstance(paramContext).getUnregisterCallback();
      if (localIUmengUnregisterCallback != null)
        localIUmengUnregisterCallback.onUnregistered(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  protected boolean shouldProcessMessage(Context paramContext, Intent paramIntent)
  {
    return PushAgent.getInstance(paramContext).isEnabled();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengBaseIntentService
 * JD-Core Version:    0.6.2
 */