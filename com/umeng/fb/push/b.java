package com.umeng.fb.push;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.Builder;
import com.umeng.fb.ConversationActivity;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.Store;
import com.umeng.fb.res.g;
import com.umeng.fb.util.Log;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements c
{
  private static final String a = b.class.getName();
  private static c b;
  private Context c;
  private Class<?> d;
  private SharedPreferences e;
  private final String f = "feedback_push";
  private final String g = "alias";
  private final String h = "umeng_feedback";
  private final String i = "feedback_id";
  private final String j = "switch";
  private List k;
  private c.a l;
  private boolean m = false;
  private String n;
  private boolean o;
  private int p;
  private String q;

  private b(Context paramContext)
  {
    this.c = paramContext;
    this.k = new ArrayList();
    this.e = this.c.getSharedPreferences("feedback_push", 0);
  }

  public static c a(Context paramContext)
  {
    if (b == null)
      b = new b(paramContext);
    return b;
  }

  private void a()
  {
    Log.c(a, "setAlias UUID " + Store.getInstance(this.c).getDeviceUUID());
    if (!this.e.getBoolean("alias", false))
      new Thread()
      {
        public void run()
        {
          int i = 0;
          while (true)
            if (i < 10)
              try
              {
                if (PushAgent.getInstance(b.a(b.this)).addAlias(Store.getInstance(b.a(b.this)).getDeviceUUID(), "umeng_feedback"))
                {
                  b.b(b.this).edit().putBoolean("alias", true).apply();
                  return;
                }
                sleep(1000L);
                i++;
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
        }
      }
      .start();
  }

  private void a(List paramList, String paramString1, String paramString2)
  {
    String str2;
    if (this.p == 1)
    {
      String str4 = this.c.getResources().getString(g.b(this.c));
      str2 = String.format(Locale.US, str4, new Object[] { paramString2 });
    }
    try
    {
      NotificationManager localNotificationManager = (NotificationManager)this.c.getSystemService("notification");
      String str3 = this.c.getString(g.a(this.c));
      int i1 = this.c.getPackageManager().getPackageInfo(this.c.getPackageName(), 0).applicationInfo.icon;
      if (this.d != null);
      for (Intent localIntent = new Intent(this.c, this.d); ; localIntent = new Intent(this.c, ConversationActivity.class))
      {
        localIntent.setFlags(131072);
        localIntent.putExtra("conversation_id", paramString1);
        int i2 = (int)SystemClock.uptimeMillis();
        PendingIntent localPendingIntent = PendingIntent.getActivity(this.c, i2, localIntent, 134217728);
        localNotificationManager.notify(0, new NotificationCompat.Builder(this.c).setSmallIcon(i1).setContentTitle(str3).setTicker(str3).setContentText(str2).setAutoCancel(true).setContentIntent(localPendingIntent).build());
        return;
        String str1 = this.c.getResources().getString(g.c(this.c));
        Locale localLocale = Locale.US;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(this.p);
        str2 = String.format(localLocale, str1, arrayOfObject);
        break;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private boolean a(String paramString)
  {
    try
    {
      String str = new JSONObject(paramString).optString("feedback_id", null);
      if (str == null)
        return false;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return false;
    }
    return true;
  }

  public void clearPushInfo()
  {
    this.p = 0;
    this.q = "";
  }

  public boolean dealFBMessage(FBMessage paramFBMessage)
  {
    Log.c(a, "received push message  - " + paramFBMessage.custom);
    if (!a(paramFBMessage.custom))
      return false;
    if (this.e == null)
      this.e = this.c.getSharedPreferences("feedback_push", 0);
    this.o = this.e.getBoolean("switch", false);
    if (!this.o)
      return true;
    while (true)
    {
      String str;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramFBMessage.custom);
        str = localJSONObject.getString("feedback_id");
        if (str != null)
        {
          if (this.p < 1)
            this.q = Reply.fromJson(localJSONObject).content;
          this.k.add(str);
          this.p = (1 + this.p);
        }
        if (!this.m)
          break label215;
        if ((this.n != null) && (this.n.endsWith(str)))
        {
          this.l.onAddPushDevReply();
          return true;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return false;
      }
      a(this.k, str, this.q);
      continue;
      label215: a(this.k, str, this.q);
    }
  }

  public void disable()
  {
    this.e.edit().putBoolean("switch", false).apply();
    this.o = false;
  }

  public void enable()
  {
    this.e.edit().putBoolean("switch", true).apply();
    this.o = true;
  }

  public void init(Class<?> paramClass, boolean paramBoolean)
  {
    this.d = paramClass;
    init(paramBoolean);
  }

  public void init(boolean paramBoolean)
  {
    a();
    if (paramBoolean)
      return;
    try
    {
      UmengMessageHandler local1 = new UmengMessageHandler()
      {
        public void dealWithCustomMessage(Context paramAnonymousContext, UMessage paramAnonymousUMessage)
        {
          b.this.dealFBMessage(new FBMessage(paramAnonymousUMessage.custom));
        }
      };
      PushAgent.getInstance(this.c).setMessageHandler(local1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public boolean onFBMessage(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("body");
    try
    {
      UMessage localUMessage = new UMessage(new JSONObject(str));
      return dealFBMessage(new FBMessage(localUMessage.custom));
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }

  public void setConversationId(String paramString)
  {
    this.n = paramString;
  }

  public void setFBPushCallbacks(c.a parama)
  {
    this.l = parama;
  }

  public void setFbFragmentTag(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.push.b
 * JD-Core Version:    0.6.2
 */