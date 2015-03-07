package com.allinone.free.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;
import com.allinone.free.activity.MyMainActivity;
import com.umeng.fb.example.CustomActivity;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MyReceiver extends BroadcastReceiver
{
  private static final String TAG = "JPush";

  private static String printBundle(Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localStringBuilder.toString();
      String str = (String)localIterator.next();
      if (str.equals(JPushInterface.EXTRA_NOTIFICATION_ID))
        localStringBuilder.append("\nkey:" + str + ", value:" + paramBundle.getInt(str));
      else
        localStringBuilder.append("\nkey:" + str + ", value:" + paramBundle.getString(str));
    }
  }

  private void processCustomMessage(Context paramContext, Bundle paramBundle)
  {
    if (JpushMainActivity.isForeground)
    {
      String str = paramBundle.getString(JPushInterface.EXTRA_MESSAGE);
      paramBundle.getString(JPushInterface.EXTRA_EXTRA);
      Intent localIntent = new Intent("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION");
      localIntent.putExtra("message", str);
      paramContext.sendBroadcast(localIntent);
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (JPushInterface.ACTION_REGISTRATION_ID.equals(paramIntent.getAction()))
    {
      String str4 = localBundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
      Log.v("kiki", "[MyReceiver] 接收Registration Id : " + str4);
    }
    JSONObject localJSONObject2;
    String str1;
    do
    {
      while (true)
      {
        return;
        if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(paramIntent.getAction()))
        {
          Log.d("JPush", "[MyReceiver] 接收到推送下来的自定义消息: " + localBundle.getString(JPushInterface.EXTRA_MESSAGE));
          processCustomMessage(paramContext, localBundle);
          return;
        }
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(paramIntent.getAction()))
        {
          Log.d("JPush", "[MyReceiver] 接收到推送下来的通知");
          int i = localBundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
          Log.d("JPush", "[MyReceiver] 接收到推送下来的通知的ID: " + i);
          return;
        }
        if (!JPushInterface.ACTION_NOTIFICATION_OPENED.equals(paramIntent.getAction()))
          break label453;
        Log.d("JPush", "[MyReceiver] 用户点击打开了通知");
        JPushInterface.reportNotificationOpened(paramContext, localBundle.getString(JPushInterface.EXTRA_MSG_ID));
        try
        {
          JSONObject localJSONObject1 = new JSONObject(localBundle.getString(JPushInterface.EXTRA_EXTRA));
          if (localJSONObject1.isNull("key"))
          {
            Intent localIntent1 = new Intent(paramContext, CustomActivity.class);
            localIntent1.setFlags(268435456);
            paramContext.startActivity(localIntent1);
          }
          localJSONObject2 = new JSONObject(localJSONObject1.getString("key"));
          if (localJSONObject2.getString("type").equals("base"))
          {
            str1 = localJSONObject2.getString("page");
            if (str1.equals("home"))
            {
              Intent localIntent2 = new Intent(paramContext, MyMainActivity.class);
              localIntent2.setFlags(268435456);
              localIntent2.putExtra("jpush", "jpushfan");
              paramContext.startActivity(localIntent2);
              return;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          return;
        }
      }
      if (str1.equals("recommendid"))
      {
        String str3 = localJSONObject2.getString("id");
        Intent localIntent4 = new Intent(paramContext, MyMainActivity.class);
        localIntent4.putExtra("myid", str3);
        localIntent4.setFlags(268435456);
        paramContext.startActivity(localIntent4);
        return;
      }
    }
    while (!str1.equals("googleid"));
    String str2 = localJSONObject2.getString("google_id");
    Intent localIntent3 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str2));
    localIntent3.setFlags(268435456);
    paramContext.startActivity(localIntent3);
    return;
    label453: if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(paramIntent.getAction()))
    {
      Log.d("JPush", "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + localBundle.getString(JPushInterface.EXTRA_EXTRA));
      return;
    }
    Log.d("JPush", "[MyReceiver] Unhandled intent - " + paramIntent.getAction());
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.jpush.MyReceiver
 * JD-Core Version:    0.6.2
 */