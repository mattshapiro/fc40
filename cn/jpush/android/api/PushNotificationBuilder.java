package cn.jpush.android.api;

import android.app.Notification;
import java.util.Map;

public abstract interface PushNotificationBuilder
{
  public abstract Notification a(String paramString, Map<String, String> paramMap);

  public abstract String a();
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.PushNotificationBuilder
 * JD-Core Version:    0.6.2
 */