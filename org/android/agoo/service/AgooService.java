package org.android.agoo.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aN;
import com.umeng.message.proguard.aP;
import com.umeng.message.proguard.aR;
import com.umeng.message.proguard.aS;
import com.umeng.message.proguard.bs;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.bz;
import java.util.Iterator;
import java.util.Random;
import org.android.agoo.client.BaseRegistrar;
import org.android.agoo.client.IntentHelper;
import org.android.agoo.proc.b;
import org.json.JSONException;
import org.json.JSONObject;

public class AgooService extends b
  implements aR
{
  private static final String b = "AgooService";
  private static final String c = "head";
  private volatile aP d;
  private volatile long e;
  private volatile ReElection f = null;
  private volatile AlarmManager g = null;
  private volatile String h = null;
  private volatile String i = null;
  private volatile String j = null;
  private volatile String k = null;
  private volatile String l = null;
  private volatile String m = null;
  private final IMessageService.Stub n = new IMessageService.Stub()
  {
    public boolean ping()
      throws RemoteException
    {
      if (AgooService.a(AgooService.this) == null)
        return false;
      return AgooService.a(AgooService.this).f();
    }

    public void probe()
      throws RemoteException
    {
      bz.a(new Runnable()
      {
        public void run()
        {
          aJ.c("AgooService", "messageServiceBinder probe--->[thread_name:" + Thread.currentThread().getName() + "]");
          String str = aI.d(AgooService.b(AgooService.this));
          if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(AgooService.c(AgooService.this), str)) && (AgooService.a(AgooService.this) != null) && (AgooService.a(AgooService.this).f()))
          {
            aJ.c("AgooService", "messageService connect[ok]");
            return;
          }
          if ((TextUtils.isEmpty(AgooService.d(AgooService.this))) && (!TextUtils.equals(AgooService.d(AgooService.this), AgooService.e(AgooService.this).getPackageName())))
            aN.a(AgooService.f(AgooService.this), AgooService.d(AgooService.this));
          aJ.c("AgooService", "messageServiceBinder[need_election]");
          AgooService.a(AgooService.this, AgooService.g(AgooService.this).getPackageName(), "ERROR_NEED_ELECTION");
        }
      });
    }
  };

  private void a(String paramString, Bundle paramBundle)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("org.agoo.android.intent.action.RECEIVE");
      localIntent.setPackage(paramString);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("message_source", "apoll");
      localIntent.addFlags(32);
      this.a.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("AgooService", "handleMessage", localThrowable);
    }
  }

  private void a(String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = IntentHelper.createComandIntent(this.a, "error");
      localIntent.setPackage(paramString1);
      localIntent.putExtra("error", paramString2);
      this.a.sendBroadcast(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("AgooService", "handleError", localThrowable);
    }
  }

  private boolean f()
  {
    try
    {
      if (this.a == null)
      {
        aJ.c("AgooService", "mContext == null");
        return false;
      }
      this.h = aI.n(this.a);
      this.k = aI.q(this.a);
      this.i = aI.p(this.a);
      this.j = aI.o(this.a);
      if (TextUtils.isEmpty(this.k))
      {
        a(this.l, "ERROR_DEVICETOKEN_NULL");
        return false;
      }
      if (this.d == null)
        this.d = new aS(this.a, this);
      this.d.b(this.h);
      this.d.a(this.i);
      this.d.c(this.j);
      this.d.d(this.k);
      return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private boolean g()
  {
    try
    {
      if (!BaseRegistrar.isRegistered(this.a))
        return true;
      String str = aI.d(this.a);
      if (TextUtils.isEmpty(str))
      {
        aJ.c("AgooService", "[currentSudoPack==null]");
        return true;
      }
      if (!TextUtils.equals(this.l, str))
      {
        aJ.c("AgooService", "[currentSudoPack(" + str + ")!=appPackage(" + this.l + ")]");
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private void h()
  {
    try
    {
      if (this.d != null)
        this.d.e();
      if (this.f != null)
        this.f.start();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    try
    {
      if (!f())
      {
        a();
        return;
      }
      String str1 = paramIntent.getAction();
      String str2 = IntentHelper.getAgooStart(this.a);
      aJ.c("AgooService", "action [" + str1 + "]");
      if (TextUtils.equals(str1, str2))
      {
        String str3 = paramIntent.getStringExtra("method");
        aJ.c("AgooService", "startCommand method--->[" + str3 + "]");
        if ((!TextUtils.isEmpty(str3)) && (TextUtils.equals(str3, "start")))
        {
          h();
          return;
        }
        a();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void b()
  {
    aJ.c("AgooService", "create--->[current-thread-name:" + Thread.currentThread().getName() + "]");
    try
    {
      this.l = this.a.getPackageName();
      this.g = ((AlarmManager)getSystemService("alarm"));
      if (Build.VERSION.SDK_INT < 18)
        startForeground(-1469, new Notification());
      new Handler(Looper.getMainLooper());
      this.e = System.currentTimeMillis();
      this.f = new ReElection();
      this.d = new aS(this.a, this);
      bx.a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("AgooService", "create", localThrowable);
    }
  }

  protected void c()
  {
    try
    {
      aJ.c("AgooService", "AgooService[current-thread-name:" + Thread.currentThread().getName() + "]");
      aJ.c("AgooService", "AgooService destroying");
      aN.a(this.a, this.e);
      if (this.d != null)
        this.d.g();
      if (this.f != null)
        this.f.destory();
      aJ.c("AgooService", "AgooService destroyed");
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("AgooService", "destroy", localThrowable);
    }
  }

  protected void d()
  {
    try
    {
      aN.d(this.a);
      if (g())
      {
        a(this.l, "ERROR_NEED_ELECTION");
        a();
        return;
      }
      if (!f())
      {
        a();
        return;
      }
      h();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  protected void e()
  {
    try
    {
      aN.d(this.a);
      if (g())
      {
        a(this.l, "ERROR_NEED_ELECTION");
        a();
        return;
      }
      if (!f())
      {
        a();
        return;
      }
      h();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final IBinder onBind(Intent paramIntent)
  {
    try
    {
      String str = paramIntent.getAction();
      aJ.c("AgooService", "onBind:[" + str + "]");
      if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, "org.agoo.android.intent.action.PING")))
      {
        this.m = paramIntent.getPackage();
        IMessageService.Stub localStub = this.n;
        return localStub;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public void onHandleError(String paramString)
  {
    a(this.a.getPackageName(), paramString);
  }

  public final void onHandleMessage(String paramString)
  {
    Bundle localBundle;
    JSONObject localJSONObject1;
    String str1;
    String str2;
    String str3;
    String str4;
    try
    {
      if (TextUtils.isEmpty(paramString))
        return;
      aJ.c("AgooService", "onHandleMessage--->[current-thread-name:" + Thread.currentThread().getName() + "]");
      localBundle = new Bundle();
      localJSONObject1 = new JSONObject(paramString);
      str1 = localJSONObject1.getString("pack");
      str2 = localJSONObject1.getString("id");
      str3 = localJSONObject1.getString("type");
      str4 = localJSONObject1.getString("body");
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str4)))
      {
        aN.d(this.a, paramString);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      aN.d(this.a, paramString);
      aJ.d("AgooService", "JSONException parse errormessage content[" + paramString + "]", localThrowable);
      return;
    }
    localBundle.putString("id", str2);
    localBundle.putString("type", str3);
    localBundle.putString("body", str4);
    JSONObject localJSONObject2 = localJSONObject1.getJSONObject("head");
    Iterator localIterator = localJSONObject2.keys();
    while (true)
    {
      boolean bool = localIterator.hasNext();
      if (!bool)
        break;
      try
      {
        String str5 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str5))
        {
          String str6 = localJSONObject2.getString(str5);
          if (!TextUtils.isEmpty(str6))
            localBundle.putString(str5, str6);
        }
      }
      catch (JSONException localJSONException)
      {
        aJ.e("AgooService", "JSONException parse error[message header]", localJSONException);
      }
    }
    a(str1, localBundle);
  }

  private class ReElection extends BroadcastReceiver
  {
    private static final int b = 45613913;
    private static final String c = "agoo_action_re_election";
    private IntentFilter d = null;
    private PendingIntent e = null;
    private Intent f = null;
    private volatile boolean g = false;

    public ReElection()
    {
      try
      {
        this.g = false;
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    private void a()
    {
      try
      {
        if (this.g)
          return;
        this.d = new IntentFilter();
        this.d.addAction("agoo_action_re_election");
        AgooService.h(AgooService.this).registerReceiver(this, this.d);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    public void destory()
    {
      try
      {
        if (AgooService.l(AgooService.this) != null)
          AgooService.this.unregisterReceiver(this);
        if (this.e != null)
          this.e.cancel();
        if (AgooService.j(AgooService.this) != null)
          AgooService.j(AgooService.this).cancel(this.e);
        this.e = null;
        AgooService.a(AgooService.this, null);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    public void onReceive(final Context paramContext, Intent paramIntent)
    {
      try
      {
        if (TextUtils.equals("agoo_action_re_election", paramIntent.getAction()))
          bz.a(new Runnable()
          {
            public void run()
            {
              aJ.c("AgooService", "election---onReceive--->[current-thread-name:" + Thread.currentThread().getName() + "][" + bs.a(System.currentTimeMillis()) + "] ");
              AgooService.a(AgooService.this, paramContext.getPackageName(), "ERROR_NEED_ELECTION");
              AgooService.ReElection.a(AgooService.ReElection.this, false);
            }
          });
        return;
      }
      catch (Throwable localThrowable)
      {
        aJ.e("AgooService", "onReceive", localThrowable);
      }
    }

    public void start()
    {
      while (true)
      {
        long l1;
        try
        {
          boolean bool = this.g;
          if (bool)
            return;
          this.g = true;
          a();
          this.f = new Intent("agoo_action_re_election");
          this.f.setPackage(AgooService.c(AgooService.this));
          int i = 1320 + new Random().nextInt(120);
          l1 = System.currentTimeMillis() + 1000L * (60L * i);
          l2 = aI.c(AgooService.i(AgooService.this));
          aJ.c("AgooService", "re_election_start[timeout:" + l2 + "]");
          if (l2 > 1800000L + System.currentTimeMillis())
          {
            if (this.e != null)
            {
              this.e.cancel();
              AgooService.j(AgooService.this).cancel(this.e);
            }
            this.e = PendingIntent.getBroadcast(AgooService.k(AgooService.this), 45613913, this.f, 134217728);
            aJ.c("AgooService", "election next time[current-thread-name:" + Thread.currentThread().getName() + "][" + bs.a(l2) + "] ");
            AgooService.j(AgooService.this).set(1, l2, this.e);
            continue;
          }
        }
        catch (Throwable localThrowable)
        {
          aJ.e("AgooService", "ReElection start", localThrowable);
          continue;
        }
        finally
        {
        }
        long l2 = l1;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.service.AgooService
 * JD-Core Version:    0.6.2
 */