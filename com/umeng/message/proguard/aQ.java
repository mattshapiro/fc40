package com.umeng.message.proguard;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.client.AgooSettings;
import org.android.agoo.net.mtop.IMtopAsynClient;
import org.android.agoo.net.mtop.MtopAsyncClientV3;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopResponseHandler;

public class aQ extends aP
{
  private static final String e = "AnnouncementControl";
  private static final String f = "action_announcement_message";
  private static final long g = 10800000L;
  private static final long h = 7200L;
  private static final String m = "ANNOUNCEMENT_NEWEST_STORAGE";
  private static final String n = "ANNOUNCEMENT_NEWEST_ID";
  private volatile Context i;
  private AtomicBoolean j = new AtomicBoolean(false);
  private volatile a k = null;
  private IMtopAsynClient l;

  public aQ(Context paramContext, aR paramaR)
  {
    super(paramContext, paramaR);
    this.i = paramContext;
    this.j.set(false);
    this.k = new a(paramContext, null);
    this.l = new MtopAsyncClientV3();
    this.l.setBaseUrl(AgooSettings.getPullUrl(paramContext));
  }

  private static long a(int paramInt1, int paramInt2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    localCalendar.set(11, paramInt1);
    localCalendar.set(12, paramInt2);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }

  private String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("ANNOUNCEMENT_NEWEST_STORAGE", 4).getString("ANNOUNCEMENT_NEWEST_ID", null);
  }

  private static String b(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong));
  }

  private void i()
  {
    MtopRequest localMtopRequest = new MtopRequest();
    localMtopRequest.setApi("mtop.push.msg.announcement");
    localMtopRequest.setV("5.0");
    localMtopRequest.setAppKey(super.b());
    localMtopRequest.setAppSecret(super.a());
    localMtopRequest.setTtId(super.c());
    String str = a(this.i);
    if (!TextUtils.isEmpty(str))
    {
      aJ.c("AnnouncementControl", "synMessage newestId[" + str + "]");
      localMtopRequest.putParams("Newest_id", str);
    }
    this.l.getV3(this.a, localMtopRequest, new MtopResponseHandler()
    {
      public void onFailure(Throwable paramAnonymousThrowable, String paramAnonymousString)
      {
        aQ.this.e(paramAnonymousString);
      }

      public void onSuccess(String paramAnonymousString)
      {
        aQ.this.f(paramAnonymousString);
      }
    });
  }

  public void e()
  {
    try
    {
      if (this.j.get())
        aJ.c("AnnouncementControl", "AnnouncementControl [started]");
      while (true)
      {
        return;
        long l1 = a(23, 30) + bw.a(7200L, null);
        this.k.a(l1);
      }
    }
    finally
    {
    }
  }

  public boolean f()
  {
    return false;
  }

  public void g()
  {
    try
    {
      aJ.c("AnnouncementControl", "AnnouncementControl--->[destroy]");
      h();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void h()
  {
    try
    {
      boolean bool = this.j.get();
      if (!bool);
      while (true)
      {
        return;
        aJ.c("AnnouncementControl", "AnnouncementControl--->[stop]");
        this.j.set(false);
        if (this.k != null)
          this.k.a();
      }
    }
    finally
    {
    }
  }

  private class a extends BroadcastReceiver
  {
    private Context b;
    private IntentFilter c = null;
    private String d = null;

    private a(Context arg2)
    {
      Object localObject;
      this.b = localObject;
      this.d = localObject.getPackageName();
      this.c = new IntentFilter();
      this.c.addAction("action_announcement_message");
      localObject.registerReceiver(this, this.c);
    }

    public void a()
    {
      if ((this != null) && (this.b != null))
        this.b.unregisterReceiver(this);
    }

    public void a(long paramLong)
    {
      try
      {
        aJ.c("AnnouncementControl", "AnnouncementControl--->[start][targetTime:" + aQ.a(paramLong) + "][interval:" + 10800000L + " ms]");
        AlarmManager localAlarmManager = (AlarmManager)this.b.getSystemService("alarm");
        Intent localIntent = new Intent("action_announcement_message");
        localIntent.setPackage(this.d);
        localAlarmManager.setRepeating(1, paramLong, 10800000L, PendingIntent.getBroadcast(aQ.b(aQ.this), 170347134, localIntent, 134217728));
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("action_announcement_message".equals(paramIntent.getAction()))
        aQ.a(aQ.this);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.aQ
 * JD-Core Version:    0.6.2
 */