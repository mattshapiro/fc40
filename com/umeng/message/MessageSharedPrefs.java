package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MessageSharedPrefs
{
  private static MessageSharedPrefs c;
  private Context a;
  private SharedPreferences b;

  private MessageSharedPrefs(Context paramContext)
  {
    this.a = paramContext;
    int i = Build.VERSION.SDK_INT;
    int j = 0;
    if (i > 11)
      j = 4;
    this.b = paramContext.getSharedPreferences("umeng_message_state", j);
  }

  public static MessageSharedPrefs getInstance(Context paramContext)
  {
    try
    {
      if (c == null)
        c = new MessageSharedPrefs(paramContext);
      MessageSharedPrefs localMessageSharedPrefs = c;
      return localMessageSharedPrefs;
    }
    finally
    {
    }
  }

  int a()
  {
    return this.b.getInt("KEY_NO_DISTURB_START_HOUR", 23);
  }

  void a(int paramInt)
  {
    this.b.edit().putInt("mute_duration", paramInt).commit();
  }

  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.edit().putInt("KEY_NO_DISTURB_START_HOUR", paramInt1).putInt("KEY_NO_DISTURB_START_MINUTE", paramInt2).putInt("KEY_NO_DISTURB_END_HOUR", paramInt3).putInt("KEY_NO_DISTURB_END_MINUTE", paramInt4).commit();
  }

  void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    Map localMap = this.b.getAll();
    if ((localMap != null) && (localMap.size() > 0))
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        if (str.startsWith("KEY_REGISTERED_TO_UMENG_"))
          localEditor.remove(str);
      }
    }
    localEditor.putBoolean("KEY_REGISTERED_TO_UMENG_" + paramString, paramBoolean).commit();
  }

  boolean a(String paramString)
  {
    String str = "KEY_REGISTERED_TO_UMENG_" + paramString;
    return this.b.getBoolean(str, false);
  }

  public void addAlias(String paramString1, String paramString2)
  {
    String str1 = String.format("ALIAS_%s", new Object[] { paramString2 });
    String str2 = this.b.getString(str1, null);
    int i = getAliasCount();
    SharedPreferences.Editor localEditor = this.b.edit();
    if (str2 == null)
      localEditor.putInt("ALIAS_COUNT", i + 1);
    localEditor.putString(str1, paramString1).commit();
  }

  public void addTags(String[] paramArrayOfString)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = String.format("UMENG_TAG_%s", new Object[] { paramArrayOfString[j] });
      if (!this.b.getBoolean(str, false))
      {
        localEditor.putBoolean(str, true);
        localEditor.putInt("UMENG_TAG_COUNT", 1 + getTagCount());
      }
    }
    localEditor.commit();
  }

  int b()
  {
    return this.b.getInt("KEY_NO_DISTURB_START_MINUTE", 0);
  }

  boolean b(String paramString)
  {
    return this.b.getBoolean("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX" + paramString, false);
  }

  int c()
  {
    return this.b.getInt("KEY_NO_DISTURB_END_HOUR", 7);
  }

  void c(String paramString)
  {
    this.b.edit().putBoolean("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX" + paramString, true).commit();
  }

  int d()
  {
    return this.b.getInt("KEY_NO_DISTURB_END_MINUTE", 0);
  }

  void d(String paramString)
  {
    this.b.edit().remove("KEY_MSG_RESOURCE_DOWNLOAD_PREFIX" + paramString).commit();
  }

  void e()
  {
    this.b.edit().putBoolean("KEY_ENEABLED", true).commit();
  }

  void e(String paramString)
  {
    this.b.edit().putString("last_msg_id", paramString).commit();
  }

  void f()
  {
    this.b.edit().putBoolean("KEY_ENEABLED", false).commit();
  }

  boolean g()
  {
    return this.b.getBoolean("KEY_ENEABLED", false);
  }

  public int getAliasCount()
  {
    return this.b.getInt("ALIAS_COUNT", 0);
  }

  public int getAppLaunchLogSendPolicy()
  {
    return this.b.getInt("KEY_APP_LAUNCH_LOG_SEND_POLICY", -1);
  }

  public long getAppLaunchLogSentAt()
  {
    return this.b.getLong("KEY_LAUNCH_LOG_SENT_MARK", 0L);
  }

  public String getLastAlias(String paramString)
  {
    String str = String.format("ALIAS_%s", new Object[] { paramString });
    return this.b.getString(str, "");
  }

  public boolean getMergeNotificaiton()
  {
    return this.b.getBoolean("KEY_MERGE_NOTIFICATION", true);
  }

  public String getMessageAppKey()
  {
    return this.b.getString("KEY_UMENG_MESSAGE_APP_KEY", "");
  }

  public String getMessageAppSecret()
  {
    return this.b.getString("KEY_UMENG_MESSAGE_APP_SECRET", "");
  }

  public String getMessageChannel()
  {
    return this.b.getString("KEY_UMENG_MESSAGE_APP_CHANNEL", "");
  }

  public boolean getNotificaitonOnForeground()
  {
    return this.b.getBoolean("KEY_SET_NOTIFICATION_ON_FOREGROUND", true);
  }

  public String getPushIntentServiceClass()
  {
    String str1 = this.b.getString("KEY_PUSH_INTENT_SERVICE_CLASSNAME", MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME);
    String str2 = this.b.getString("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE", null);
    String str3 = DeviceConfig.getAppVersionCode(this.a);
    try
    {
      Class.forName(str1);
      if ((TextUtils.equals(str2, str3)) && (!TextUtils.equals(str3, "Unknown")))
        return str1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME;
    }
    return MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME;
  }

  public int getSerialNo()
  {
    return this.b.getInt("serial_no", 1);
  }

  public int getTagCount()
  {
    return this.b.getInt("UMENG_TAG_COUNT", 0);
  }

  public int getTagRemain()
  {
    return this.b.getInt("UMENG_TAG_REMAIN", 64);
  }

  public int getTagSendPolicy()
  {
    return this.b.getInt("KEY_TAG_SEND_POLICY", -1);
  }

  boolean h()
  {
    return this.b.getBoolean("KEY_CACHE_FILE_TRANSFER_TO_SQL", false);
  }

  public boolean hasAppLaunchLogSentToday()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(getAppLaunchLogSentAt());
    Calendar localCalendar2 = Calendar.getInstance();
    return (localCalendar1.get(6) == localCalendar2.get(6)) && (localCalendar1.get(1) == localCalendar2.get(1));
  }

  boolean i()
  {
    return this.b.edit().putBoolean("KEY_CACHE_FILE_TRANSFER_TO_SQL", true).commit();
  }

  public boolean isAliasSet(String paramString1, String paramString2)
  {
    String str1 = String.format("ALIAS_%s", new Object[] { paramString2 });
    String str2 = this.b.getString(str1, null);
    return (paramString1 != null) && (paramString1.equals(str2));
  }

  public boolean isAliaseTypeSet(String paramString)
  {
    String str = String.format("ALIAS_%s", new Object[] { paramString });
    return this.b.contains(str);
  }

  public boolean isTagSet(String paramString)
  {
    String str = String.format("UMENG_TAG_%s", new Object[] { paramString });
    return this.b.getBoolean(str, false);
  }

  String j()
  {
    return this.b.getString("last_msg_id", "");
  }

  int k()
  {
    return this.b.getInt("mute_duration", 60);
  }

  public void removeAlias(String paramString1, String paramString2)
  {
    String str = String.format("ALIAS_%s", new Object[] { paramString2 });
    if (this.b.contains(str))
    {
      int i = -1 + getAliasCount();
      SharedPreferences.Editor localEditor = this.b.edit();
      localEditor.remove(str);
      localEditor.putInt("ALIAS_COUNT", i);
      localEditor.commit();
    }
  }

  public void removeTags(String[] paramArrayOfString)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = String.format("UMENG_TAG_%s", new Object[] { paramArrayOfString[j] });
      if (this.b.getBoolean(str, false))
      {
        localEditor.remove(str);
        localEditor.putInt("UMENG_TAG_COUNT", -1 + getTagCount());
      }
    }
    localEditor.commit();
  }

  public void resetTags()
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    Map localMap = this.b.getAll();
    if ((localMap != null) && (localMap.size() > 0))
    {
      Iterator localIterator = localMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)((Map.Entry)localIterator.next()).getKey();
        if (str.startsWith("UMENG_TAG_"))
          localEditor.remove(str);
      }
    }
    localEditor.commit();
  }

  public void setAppLaunchLogSendPolicy(int paramInt)
  {
    this.b.edit().putInt("KEY_APP_LAUNCH_LOG_SEND_POLICY", paramInt).commit();
  }

  public void setAppLaunchLogSentAt(long paramLong)
  {
    this.b.edit().putLong("KEY_LAUNCH_LOG_SENT_MARK", Calendar.getInstance().getTimeInMillis()).commit();
  }

  public void setMergeNotificaiton(boolean paramBoolean)
  {
    this.b.edit().putBoolean("KEY_MERGE_NOTIFICATION", paramBoolean).commit();
  }

  public void setMessageAppKey(String paramString)
  {
    this.b.edit().putString("KEY_UMENG_MESSAGE_APP_KEY", paramString).commit();
  }

  public void setMessageAppSecret(String paramString)
  {
    this.b.edit().putString("KEY_UMENG_MESSAGE_APP_SECRET", paramString).commit();
  }

  public void setMessageChannel(String paramString)
  {
    this.b.edit().putString("KEY_UMENG_MESSAGE_APP_CHANNEL", paramString).commit();
  }

  public void setNotificaitonOnForeground(boolean paramBoolean)
  {
    this.b.edit().putBoolean("KEY_SET_NOTIFICATION_ON_FOREGROUND", paramBoolean).commit();
  }

  public <U extends UmengBaseIntentService> void setPushIntentServiceClass(Class<U> paramClass)
  {
    if (paramClass == null)
    {
      this.b.edit().remove("KEY_PUSH_INTENT_SERVICE_CLASSNAME").remove("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE").commit();
      return;
    }
    String str1 = paramClass.getName();
    String str2 = DeviceConfig.getAppVersionCode(this.a);
    this.b.edit().putString("KEY_PUSH_INTENT_SERVICE_CLASSNAME", str1).putString("KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE", str2).commit();
  }

  public void setSerialNo(int paramInt)
  {
    this.b.edit().putInt("serial_no", paramInt).commit();
  }

  public void setTagRemain(int paramInt)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putInt("UMENG_TAG_REMAIN", paramInt);
    localEditor.commit();
  }

  public void setTagSendPolicy(int paramInt)
  {
    this.b.edit().putInt("KEY_TAG_SEND_POLICY", paramInt).commit();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.MessageSharedPrefs
 * JD-Core Version:    0.6.2
 */