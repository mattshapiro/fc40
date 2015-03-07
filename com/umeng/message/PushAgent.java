package com.umeng.message;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import com.umeng.common.message.Log;
import com.umeng.message.proguard.aD.e;
import com.umeng.message.tag.TagManager;
import java.util.Random;
import org.android.agoo.client.AgooSettings;
import org.json.JSONException;

public class PushAgent
{
  public static boolean DEBUG = false;
  private static PushAgent a;
  private static boolean d = false;
  private static final String e = PushAgent.class.getName();
  private TagManager b;
  private Context c;
  private UHandler f;
  private UHandler g;
  private Object h;
  private IUmengRegisterCallback i;
  private IUmengUnregisterCallback j;

  private PushAgent(Context paramContext)
  {
    try
    {
      this.c = paramContext;
      this.b = TagManager.getInstance(paramContext);
      this.f = new UmengMessageHandler();
      this.g = new UmengNotificationClickHandler();
      return;
    }
    catch (Exception localException)
    {
      Log.b(e, localException.getMessage());
    }
  }

  public static PushAgent getInstance(Context paramContext)
  {
    try
    {
      if (a == null)
        a = new PushAgent(paramContext.getApplicationContext());
      PushAgent localPushAgent = a;
      return localPushAgent;
    }
    finally
    {
    }
  }

  public static boolean isAppLaunchByMessage()
  {
    return d;
  }

  public static void setAppLaunchByMessage()
  {
    d = true;
  }

  public boolean addAlias(String paramString1, String paramString2)
    throws aD.e, JSONException, Exception
  {
    return UTrack.getInstance(this.c).addAlias(paramString1, paramString2);
  }

  public void disable()
  {
    try
    {
      MessageSharedPrefs.getInstance(this.c).f();
      if (UmengRegistrar.isRegistered(this.c))
        UmengRegistrar.unregister(this.c);
      return;
    }
    catch (Exception localException)
    {
      Log.b(e, localException.getMessage());
    }
  }

  public void disable(IUmengUnregisterCallback paramIUmengUnregisterCallback)
  {
    setUnregisterCallback(paramIUmengUnregisterCallback);
    disable();
  }

  public void enable()
  {
    try
    {
      if (Build.VERSION.SDK_INT < 8)
      {
        Log.b(e, "Push SDK does not work for Android Verion < 8");
        return;
      }
      MessageSharedPrefs.getInstance(this.c).e();
      Log.c(e, "enable(): register");
      UmengRegistrar.register(this.c, getMessageAppkey(), getMessageSecret());
      return;
    }
    catch (Exception localException)
    {
      Log.b(e, localException.getMessage());
    }
  }

  public void enable(IUmengRegisterCallback paramIUmengRegisterCallback)
  {
    setRegisterCallback(paramIUmengRegisterCallback);
    enable();
  }

  public boolean getMergeNotificaiton()
  {
    return MessageSharedPrefs.getInstance(this.c).getMergeNotificaiton();
  }

  public String getMessageAppkey()
  {
    String str = MessageSharedPrefs.getInstance(this.c).getMessageAppKey();
    if (TextUtils.isEmpty(str))
      str = DeviceConfig.getAppkey(this.c);
    return str;
  }

  public String getMessageChannel()
  {
    String str = MessageSharedPrefs.getInstance(this.c).getMessageChannel();
    if (TextUtils.isEmpty(str))
      str = DeviceConfig.getChannel(this.c);
    return str;
  }

  public UHandler getMessageHandler()
  {
    return this.f;
  }

  public String getMessageSecret()
  {
    String str = MessageSharedPrefs.getInstance(this.c).getMessageAppSecret();
    if (TextUtils.isEmpty(str))
      str = DeviceConfig.getMetaData(this.c, "UMENG_MESSAGE_SECRET");
    return str;
  }

  public int getMuteDurationSeconds()
  {
    return MessageSharedPrefs.getInstance(this.c).k();
  }

  public int getNoDisturbEndHour()
  {
    return MessageSharedPrefs.getInstance(this.c).c();
  }

  public int getNoDisturbEndMinute()
  {
    return MessageSharedPrefs.getInstance(this.c).d();
  }

  public int getNoDisturbStartHour()
  {
    return MessageSharedPrefs.getInstance(this.c).a();
  }

  public int getNoDisturbStartMinute()
  {
    return MessageSharedPrefs.getInstance(this.c).b();
  }

  public UHandler getNotificationClickHandler()
  {
    return this.g;
  }

  public boolean getNotificationOnForeground()
  {
    return MessageSharedPrefs.getInstance(this.c).getNotificaitonOnForeground();
  }

  public String getPushIntentServiceClass()
  {
    return MessageSharedPrefs.getInstance(this.c).getPushIntentServiceClass();
  }

  public IUmengRegisterCallback getRegisterCallback()
  {
    return this.i;
  }

  public String getRegistrationId()
  {
    return UmengRegistrar.getRegistrationId(this.c);
  }

  public TagManager getTagManager()
  {
    return this.b;
  }

  public IUmengUnregisterCallback getUnregisterCallback()
  {
    return this.j;
  }

  public Object getUpdateResponse()
  {
    return this.h;
  }

  public boolean isEnabled()
  {
    try
    {
      boolean bool = MessageSharedPrefs.getInstance(this.c).g();
      return bool;
    }
    catch (Exception localException)
    {
      Log.b(e, localException.getMessage());
    }
    return false;
  }

  public boolean isIncludesUmengUpdateSDK()
  {
    try
    {
      Class localClass2 = Class.forName("com.umeng.update.UmengUpdateAgent");
      localClass1 = localClass2;
      if (localClass1 != null)
        return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        localClassNotFoundException.printStackTrace();
        Class localClass1 = null;
      }
    }
    return false;
  }

  public boolean isRegistered()
  {
    return UmengRegistrar.isRegistered(this.c);
  }

  public void onAppStart()
  {
    long l = 0L;
    UmengRegistrar.checkRegisteredToUmeng(this.c);
    if (!UmengRegistrar.isRegistered(this.c))
      return;
    if (MessageSharedPrefs.getInstance(this.c).getAppLaunchLogSendPolicy() == 1)
      Log.c(e, "launch_policy=1, skip sending app launch info.");
    while (true)
    {
      if (isAppLaunchByMessage())
        l = Math.abs(new Random().nextLong() % MsgConstant.a);
      UTrack.getInstance(this.c).sendCachedMsgLog(l);
      return;
      if (!MessageSharedPrefs.getInstance(this.c).hasAppLaunchLogSentToday())
        UTrack.getInstance(this.c).trackAppLaunch(l);
    }
  }

  public boolean removeAlias(String paramString1, String paramString2)
    throws aD.e, JSONException, Exception
  {
    return UTrack.getInstance(this.c).removeAlias(paramString1, paramString2);
  }

  public void setAppkeyAndSecret(String paramString1, String paramString2)
  {
    MessageSharedPrefs.getInstance(this.c).setMessageAppKey(paramString1);
    MessageSharedPrefs.getInstance(this.c).setMessageAppSecret(paramString2);
  }

  public void setDebugMode(boolean paramBoolean)
  {
    AgooSettings.setDebugMode(paramBoolean);
    Log.LOG = paramBoolean;
    AgooSettings.setLog(this.c, true, false);
  }

  public void setMergeNotificaiton(boolean paramBoolean)
  {
    MessageSharedPrefs.getInstance(this.c).setMergeNotificaiton(paramBoolean);
  }

  public void setMessageChannel(String paramString)
  {
    MessageSharedPrefs.getInstance(this.c).setMessageChannel(paramString);
  }

  public void setMessageHandler(UHandler paramUHandler)
  {
    this.f = paramUHandler;
  }

  public void setMuteDurationSeconds(int paramInt)
  {
    MessageSharedPrefs.getInstance(this.c).a(paramInt);
  }

  public void setNoDisturbMode(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    MessageSharedPrefs.getInstance(this.c).a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setNotificaitonOnForeground(boolean paramBoolean)
  {
    MessageSharedPrefs.getInstance(this.c).setNotificaitonOnForeground(paramBoolean);
  }

  public void setNotificationClickHandler(UHandler paramUHandler)
  {
    this.g = paramUHandler;
  }

  public <U extends UmengBaseIntentService> void setPushIntentServiceClass(Class<U> paramClass)
  {
    MessageSharedPrefs.getInstance(this.c).setPushIntentServiceClass(paramClass);
  }

  public void setRegisterCallback(IUmengRegisterCallback paramIUmengRegisterCallback)
  {
    this.i = paramIUmengRegisterCallback;
  }

  public void setUnregisterCallback(IUmengUnregisterCallback paramIUmengUnregisterCallback)
  {
    this.j = paramIUmengUnregisterCallback;
  }

  public void setUpdateResponse(Object paramObject)
  {
    this.h = paramObject;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.PushAgent
 * JD-Core Version:    0.6.2
 */