package com.umeng.message.proguard;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.android.agoo.client.AgooSettings;
import org.android.agoo.helper.a;
import org.android.agoo.helper.a.b;
import org.android.agoo.net.mtop.MtopHttpChunked;
import org.android.agoo.net.mtop.MtopRequest;

public class aS extends aP
{
  private static final String L = "Hb";
  private static final String M = "Dye";
  private static final String N = "X-AT";
  private static final String O = "X-COMMAND";
  private static final int Q = 456139;
  private static final int R = 456126;
  private static final String e = "MessagePush";
  private static final String f = "init_connect";
  private static final String g = "network_change_connect";
  private static final String h = "screen_on_connect";
  private static final String i = "error_connect";
  private static final String j = "heart_connect";
  private static final String k = "host_error_connect";
  private static final String l = "network_error_connect";
  private static final String m = "heart_connect_network_wap";
  private volatile long A = -1L;
  private volatile boolean B = false;
  private volatile b C;
  private volatile a D;
  private volatile MtopHttpChunked E = null;
  private volatile String F;
  private volatile aT G;
  private volatile a H;
  private volatile int I = -1;
  private volatile AlarmManager J = null;
  private volatile String K = null;
  private BroadcastReceiver P = new BroadcastReceiver()
  {
    private volatile int b = 0;

    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      String str = paramAnonymousIntent.getAction();
      if (TextUtils.equals(str, "android.intent.action.SCREEN_ON"))
      {
        aJ.c("MessagePush", "screen_on");
        bf localbf = aS.a(aS.this).readyState();
        if ((localbf != bf.b) && (localbf != bf.a))
          aS.a(aS.this, aS.b(aS.this), "screen_on_connect");
      }
      do
      {
        do
          return;
        while (!TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE"));
        this.b = (1 + this.b);
      }
      while (this.b <= 1);
      aJ.c("MessagePush", "network_change");
      aS.a(aS.this, aS.c(aS.this), "network_change_connect");
    }
  };
  private volatile long n;
  private volatile long o;
  private volatile long p;
  private volatile long q;
  private volatile long r;
  private volatile long s;
  private volatile long t;
  private volatile long u;
  private volatile long v;
  private volatile long w;
  private volatile long x;
  private volatile long y;
  private volatile long z;

  public aS(Context paramContext, aR paramaR)
  {
    super(paramContext, paramaR);
    aN.a(paramContext);
    this.G = new aT(AgooSettings.isAgooTestMode(paramContext), super.d());
    this.n = this.G.c();
    this.o = this.G.d();
    this.v = this.G.e();
    this.t = this.G.f();
    this.q = this.G.h();
    this.p = this.G.g();
    this.r = this.G.j();
    this.s = this.G.l();
    this.u = this.G.k();
    this.z = this.G.i();
    this.y = this.G.b();
    this.w = this.G.m();
    this.x = this.G.a();
    this.F = paramContext.getPackageName();
    this.K = aI.b(paramContext);
    this.J = ((AlarmManager)paramContext.getSystemService("alarm"));
    this.H = new a(paramContext, d());
    this.E = new MtopHttpChunked();
    this.E.setDefaultAppkey(this.b);
    this.E.setDefaultAppSecret(this.c);
    this.D = new a(null);
    this.C = new b();
  }

  private final void a(int paramInt, Map<String, String> paramMap)
  {
    switch (paramInt)
    {
    default:
      if (a(paramMap))
      {
        e("ERRCODE_AUTH_REJECT");
        return;
      }
      break;
    case 404:
      d(n(), "error_connect");
      return;
    case 408:
      d(n(), "error_connect");
      return;
    case 504:
      d(n(), "error_connect");
      return;
    }
    d(n(), "error_connect");
  }

  private void a(long paramLong, String paramString)
  {
    if (this.D == null)
    {
      aJ.c("MessagePush", "open heart==[null]");
      return;
    }
    if (!TextUtils.isEmpty(paramString));
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 >= 20)
        this.x = (i1 * 1000);
      if (this.x <= this.w)
      {
        l1 = 2L * this.x;
        this.y = this.x;
        aJ.c("MessagePush", "heart[" + this.I + "]heart--->[start checktime:" + this.y + "|timeout:" + l1 + "ms][current-thread-name:" + Thread.currentThread().getName() + "]");
        this.D.a(this.y, l1, paramLong);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      while (true)
      {
        aJ.e("MessagePush", "startHeart(" + paramString + ")", localThrowable);
        continue;
        this.y = (this.x / 2L);
        long l1 = ()(1.1D * this.x);
      }
    }
  }

  private void a(Context paramContext)
  {
    this.x = this.G.a();
    this.E.addHeader("Hb", "" + this.x / 1000L);
  }

  private void a(boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        if (!aU.a(this.a))
        {
          aJ.c("MessagePush", "connectManager[network connectedOrConnecting failed]");
          d(n(), "network_error_connect");
          return;
        }
        if ((paramBoolean) && (this.H != null))
        {
          this.H.a(new a.b()
          {
            public void a(int paramAnonymousInt, String paramAnonymousString)
            {
              aJ.c("MessagePush", "connect_host[" + paramAnonymousString + "]---->[" + paramAnonymousInt + "]");
              aN.a(aS.this.a, paramAnonymousInt, paramAnonymousString);
              if ((paramAnonymousInt == 408) || (paramAnonymousInt == 307))
              {
                aS.d(aS.this, aS.j(aS.this), "host_error_connect");
                return;
              }
              aS.d(aS.this, aS.k(aS.this), "host_error_connect");
            }

            public void a(String paramAnonymousString)
            {
              if (!TextUtils.isEmpty(paramAnonymousString))
              {
                String str = String.format("http://%s/rest/api3.do", new Object[] { paramAnonymousString });
                aS.a(aS.this).setBaseUrl(str);
                aS.i(aS.this);
              }
            }
          });
          continue;
        }
      }
      finally
      {
      }
      k();
    }
  }

  private void a(char[] paramArrayOfChar, long paramLong)
  {
    try
    {
      if (paramArrayOfChar.length == 1)
      {
        aJ.c("MessagePush", "connect[" + this.I + "]--->[onHeart()]");
        this.A = System.currentTimeMillis();
        return;
      }
      String str;
      int i1;
      if (paramArrayOfChar.length == 6)
      {
        aJ.c("MessagePush", "cs[1]:[" + paramArrayOfChar[1] + "]cs[2]:[" + paramArrayOfChar[2] + "]|cs[3]:[" + paramArrayOfChar[3] + "]|cs[4]:[" + paramArrayOfChar[5] + "]");
        p();
        str = new String(paramArrayOfChar);
        i1 = 1000 * ('Ϩ' * paramArrayOfChar[2] + 'd' * paramArrayOfChar[3] + '\n' * paramArrayOfChar[4] + paramArrayOfChar[5]);
      }
      switch (paramArrayOfChar[1])
      {
      case '\001':
        aJ.c("MessagePush", "connect[" + this.I + "][nginx_lease_timeout][" + str + "][random time conntect][httpchunked connect time:" + (System.currentTimeMillis() - paramLong) + "ms]");
        aN.a(this.a, paramLong, "onNginxError", "[nginx_lease_timeout][" + str + "]");
        d(this.o, "error_connect");
        return;
      case '\002':
        aJ.c("MessagePush", "connect[" + this.I + "][nginx_connect_mtop_error][" + str + "][delay time: " + i1 + " ms connect]--httpchunked connect time:" + (System.currentTimeMillis() - paramLong) + "ms]");
        aN.a(this.a, paramLong, "onNginxError", "[nginx_connect_mtop_error][" + str + "]");
        d(this.G.a(i1), "error_connect");
        return;
      case '':
        aJ.c("MessagePush", "connect[" + this.I + "][nginx_connect_mtop_error][" + str + "] [random time conntect][httpchunked connect time:" + (System.currentTimeMillis() - paramLong) + "ms]");
        aN.a(this.a, paramLong, "onNginxError", "[nginx_connect_mtop_error][" + str + "]");
        d(this.o + i1, "error_connect");
        return;
      case '\003':
        aJ.c("MessagePush", "connect[" + this.I + "][nginx_connect_mtop_error][" + str + "][delay time: " + i1 + " ms connect][httpchunked connect time:" + (System.currentTimeMillis() - paramLong) + "ms]");
        aN.a(this.a, paramLong, "onNginxError", "[nginx_config_update][" + str + "]");
        d(this.G.a(i1), "error_connect");
        return;
      case '':
        aJ.c("MessagePush", "connect[" + this.I + "][nginx_config_update][" + str + "][random time conntect connect][httpchunked connect time==" + (System.currentTimeMillis() - paramLong) + "ms]");
        aN.a(this.a, paramLong, "onNginxError", "[nginx_config_update][" + str + "]");
        d(this.o + i1, "error_connect");
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private boolean a(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      String str1 = (String)paramMap.get("MTOP-ST");
      if (!TextUtils.isEmpty(str1))
        try
        {
          String str2 = URLDecoder.decode(str1, "utf-8");
          aJ.c("MessagePush", "handlerError---->[MTOP-ST_ERROR_CODE][" + str2 + "]");
          int i1 = str2.indexOf("ERRCODE_AUTH_REJECT");
          if (i1 != -1)
            return true;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
        }
    }
    return false;
  }

  private void b(long paramLong, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals("0", paramString)));
    try
    {
      int i1 = Integer.parseInt(paramString);
      if (i1 > 0)
        aI.a(this.a, paramLong, i1);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.e("MessagePush", "handlerDye(" + paramString + ")" + localThrowable.getMessage());
    }
  }

  private void b(Context paramContext)
  {
    this.E.addHeader("X-COMMAND", "vote=" + this.K);
  }

  private void c(long paramLong, String paramString)
  {
    if ((this.C != null) && (this.B))
      this.C.a(paramLong, paramString, false);
  }

  private void d(long paramLong, String paramString)
  {
    if ((this.C != null) && (this.B))
      this.C.a(paramLong, paramString, true);
  }

  private void g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.E.addHeader("X-AT", paramString);
  }

  private void h()
  {
    try
    {
      if (this.a != null)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.a.registerReceiver(this.P, localIntentFilter);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("MessagePush", "initReceiver", localThrowable);
    }
  }

  private void h(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.a != null))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("org.agoo.android.intent.action.RECEIVE");
      localIntent.putExtra("x_command_type", true);
      localIntent.putExtra("x_command", paramString);
      this.a.sendBroadcast(localIntent);
    }
  }

  private void i()
  {
    try
    {
      if (this.a != null)
        this.a.unregisterReceiver(this.P);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("MessagePush", "unregisterReceiver", localThrowable);
    }
  }

  private void j()
  {
    if (this.C != null)
      b.a(this.C);
    h();
  }

  private void k()
  {
    a(this.a);
    b(this.a);
    MtopRequest localMtopRequest = new MtopRequest();
    localMtopRequest.setApi("mtop.push.msg.new");
    localMtopRequest.setV("6.0");
    localMtopRequest.setAppKey(super.b());
    localMtopRequest.setAppSecret(super.a());
    localMtopRequest.setTtId(super.c());
    localMtopRequest.setDeviceId(super.d());
    localMtopRequest.putParams("appPackage", this.a.getPackageName());
    localMtopRequest.putParams("agooSdkVersion", Long.valueOf(AgooSettings.getAgooReleaseTime()));
    localMtopRequest.putParams("deviceId", super.d());
    localMtopRequest.putParams("vote", this.K);
    this.E.connect(this.a, localMtopRequest, this.z, new bh()
    {
      private long b = -1L;

      public void a()
      {
        aJ.c("MessagePush", "connect[" + aS.d(aS.this) + "]--->[onClose()]");
        aN.a(aS.this.a, this.b, "onClose");
        aS.f(aS.this);
      }

      public void a(int paramAnonymousInt, Map<String, String> paramAnonymousMap)
      {
        aS.a(aS.this, paramAnonymousInt);
        aJ.c("MessagePush", "connect[" + aS.d(aS.this) + "]--->[onOpen()]");
        aS.e(aS.this);
        aS.a(aS.this, System.currentTimeMillis());
        this.b = System.currentTimeMillis();
        aS.b(aS.this, this.b, (String)paramAnonymousMap.get("Hb"));
        aS.a(aS.this, (String)paramAnonymousMap.get("X-AT"));
        aS.b(aS.this, (String)paramAnonymousMap.get("X-COMMAND"));
        aS.c(aS.this, this.b, (String)paramAnonymousMap.get("Dye"));
      }

      public void a(int paramAnonymousInt, Map<String, String> paramAnonymousMap, Throwable paramAnonymousThrowable)
      {
        aS.a(aS.this, -1L);
        aJ.c("MessagePush", "connect[" + aS.d(aS.this) + "]--->httpStatusCode[" + paramAnonymousInt + "]:Throwable[" + paramAnonymousThrowable.getMessage() + "]");
        aN.a(aS.this.a, this.b, "onError", "" + paramAnonymousInt);
        aS.f(aS.this);
        aS.a(aS.this, paramAnonymousInt, paramAnonymousMap);
      }

      public void a(String paramAnonymousString)
      {
        if (!aS.g(aS.this))
          return;
        aS.a(aS.this, System.currentTimeMillis());
        aJ.c("MessagePush", "connect[" + aS.d(aS.this) + "]--->[" + paramAnonymousString + "][lastHeartTime:" + aS.h(aS.this) + "]");
        aS.this.f(paramAnonymousString);
      }

      public void a(char[] paramAnonymousArrayOfChar)
      {
        if (!aS.g(aS.this))
          return;
        aS.a(aS.this, paramAnonymousArrayOfChar, this.b);
      }
    });
  }

  private long l()
  {
    if (new aU(this.a).a())
    {
      aJ.c("MessagePush", "current network [*wap]");
      this.u = (2L * this.u);
      if (this.u >= this.s)
        this.u = this.s;
      return this.u;
    }
    this.u = this.G.k();
    return -1L;
  }

  private void m()
  {
    this.r = this.G.j();
    this.o = this.G.d();
  }

  private long n()
  {
    long l1 = l();
    if (l1 != -1L)
      return l1;
    this.r = (2L * this.r);
    if (this.r >= this.s)
      this.r = this.s;
    return this.r;
  }

  private void o()
  {
    try
    {
      boolean bool = this.B;
      if (!bool);
      while (true)
      {
        return;
        this.B = false;
        aJ.c("MessagePush", "[stopping]");
        m();
        if (this.E != null)
        {
          bf localbf = this.E.readyState();
          if ((localbf == bf.b) || (localbf == bf.a))
          {
            aJ.c("MessagePush", "[stop]:[close http chunked]");
            this.E.close();
            this.E = null;
          }
        }
        if (this.C != null)
        {
          this.C.a();
          this.C = null;
        }
        aJ.c("MessagePush", "[stoped]");
      }
    }
    finally
    {
    }
  }

  private void p()
  {
    try
    {
      if (this.D != null)
        this.D.b();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void q()
  {
    try
    {
      p();
      this.D = null;
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void e()
  {
    try
    {
      boolean bool = this.B;
      if (bool);
      while (true)
      {
        return;
        this.B = true;
        aJ.c("MessagePush", "MessagePush [starting]");
        j();
        d(this.n, "init_connect");
      }
    }
    finally
    {
    }
  }

  public boolean f()
  {
    try
    {
      bf localbf1 = this.E.readyState();
      if (localbf1 != bf.a)
      {
        bf localbf2 = bf.b;
        if (localbf1 != localbf2);
      }
      else
      {
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
    }
    return this.B;
  }

  public void g()
  {
    try
    {
      boolean bool = this.B;
      if (!bool);
      while (true)
      {
        return;
        try
        {
          aJ.c("MessagePush", "[destroying]");
          q();
          o();
          i();
          aN.b(this.a);
          this.B = false;
          aJ.c("MessagePush", "[destroyed]");
        }
        catch (Throwable localThrowable)
        {
        }
      }
    }
    finally
    {
    }
  }

  private class a extends BroadcastReceiver
  {
    private static final String b = "agoo_action_heart";
    private IntentFilter c = null;
    private PendingIntent d = null;
    private Intent e = null;
    private volatile boolean f = false;
    private volatile long g = -1L;
    private long h = -1L;

    private a()
    {
    }

    public void a()
    {
      try
      {
        this.c = new IntentFilter();
        this.c.addAction("agoo_action_heart");
        aS.this.a.registerReceiver(this, this.c);
        this.e = new Intent("agoo_action_heart");
        this.e.setPackage(aS.l(aS.this));
        this.d = PendingIntent.getBroadcast(aS.this.a, 456126, this.e, 268435456);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    public void a(long paramLong1, long paramLong2, long paramLong3)
    {
      try
      {
        boolean bool = this.f;
        if (bool);
        while (true)
        {
          return;
          this.f = true;
          this.h = paramLong3;
          this.g = paramLong2;
          aS.a(aS.this, -1L);
          a();
          aS.n(aS.this).cancel(this.d);
          aS.n(aS.this).setRepeating(1, System.currentTimeMillis(), paramLong1, this.d);
        }
      }
      finally
      {
      }
    }

    public void b()
    {
      try
      {
        boolean bool = this.f;
        if (!bool);
        while (true)
        {
          return;
          aS.a(aS.this, -1L);
          this.f = false;
          aJ.c("MessagePush", "connect[" + aS.d(aS.this) + "]heart--->[stopping]");
          if (aS.n(aS.this) != null)
            aS.n(aS.this).cancel(this.d);
          if (this.d != null)
            this.d.cancel();
          if (aS.this.a != null)
            aS.this.a.unregisterReceiver(this);
          aJ.c("MessagePush", "connect[" + aS.d(aS.this) + "]heart--->[stoped]");
        }
      }
      catch (Throwable localThrowable)
      {
        while (true)
          aJ.e("MessagePush", "heart", localThrowable);
      }
      finally
      {
      }
    }

    public void onReceive(final Context paramContext, final Intent paramIntent)
    {
      bz.a(new Runnable()
      {
        private void a(long paramAnonymousLong)
        {
          aJ.c("MessagePush", "connect[" + aS.d(aS.this) + "]heart[" + paramAnonymousLong + " ms]timeout--->[reconnect:" + aS.m(aS.this) + "ms]");
          aN.a(paramContext, paramAnonymousLong, aS.a.c(aS.a.this));
          long l = aS.j(aS.this);
          if (l != -1L)
          {
            aS.d(aS.this, l, "heart_connect_network_wap");
            return;
          }
          aS.d(aS.this, aS.m(aS.this), "heart_connect");
        }

        public void run()
        {
          if (TextUtils.equals("agoo_action_heart", paramIntent.getAction()))
          {
            bf localbf = aS.a(aS.this).readyState();
            long l = System.currentTimeMillis() - aS.h(aS.this);
            if ((aS.a.a(aS.a.this)) && (localbf == bf.b) && (aS.h(aS.this) > -1L) && (l > aS.a.b(aS.a.this)))
              a(l);
          }
        }
      });
    }
  }

  private class b extends BroadcastReceiver
    implements Handler.Callback
  {
    private static final String b = "agoo_action_re_connect";
    private static final int c = 10000;
    private static final int d = 2000;
    private static final int e = 0;
    private static final int f = 1;
    private static final int g = 2;
    private static final int h = 3;
    private static final int i = -1;
    private volatile IntentFilter j = null;
    private volatile PendingIntent k = null;
    private volatile Intent l = null;
    private volatile Handler m = null;
    private volatile HandlerThread n = null;
    private volatile boolean o = false;
    private volatile boolean p = false;
    private volatile long q = -1L;
    private volatile String r;
    private Lock s = new ReentrantLock();

    public b()
    {
      b();
    }

    private boolean a(int paramInt, long paramLong)
    {
      try
      {
        bf localbf = aS.a(aS.this).readyState();
        if (localbf == bf.a)
        {
          aJ.c("MessagePush", "connect[" + paramInt + "][state:" + localbf + "][interval:" + paramLong + "]");
          return false;
        }
        if (localbf == bf.b)
          aS.a(aS.this).disconnect(paramInt);
        return true;
      }
      catch (Throwable localThrowable)
      {
      }
      return false;
    }

    private void b()
    {
      try
      {
        this.j = new IntentFilter();
        this.j.addAction("agoo_action_re_connect");
        aS.this.a.registerReceiver(this, this.j);
        d();
        this.o = false;
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    private void c()
    {
      try
      {
        if (this.k != null)
        {
          this.k.cancel();
          aS.n(aS.this).cancel(this.k);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    private void d()
    {
      try
      {
        this.n = new HandlerThread("reconnect");
        this.n.start();
        this.m = new Handler(this.n.getLooper(), this);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }

    public void a()
    {
      try
      {
        if (aS.this.a != null)
          aS.this.a.unregisterReceiver(this);
        if (this.k != null)
          aS.n(aS.this).cancel(this.k);
        return;
      }
      catch (Throwable localThrowable)
      {
        while (true)
          aJ.d("MessagePush", "reconnect stop", localThrowable);
      }
      finally
      {
      }
    }

    public void a(long paramLong)
    {
      try
      {
        this.s.lock();
        aJ.c("MessagePush", "handleConnect[interval:" + paramLong + "][state:" + this.r + "]");
        this.l = new Intent("agoo_action_re_connect");
        this.l.setPackage(aS.l(aS.this));
        if (this.k != null)
        {
          this.k.cancel();
          aS.n(aS.this).cancel(this.k);
        }
        aS.f(aS.this);
        boolean bool = a(aS.d(aS.this), paramLong);
        if (!bool)
          return;
        this.k = PendingIntent.getBroadcast(aS.this.a, 456139, this.l, 134217728);
        aS.n(aS.this).set(1, paramLong + System.currentTimeMillis(), this.k);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
      finally
      {
        this.s.unlock();
      }
    }

    public void a(long paramLong, String paramString, boolean paramBoolean)
    {
      try
      {
        if (this.m != null)
          if (!paramBoolean)
          {
            if (!this.o)
            {
              this.o = true;
              aJ.c("MessagePush", "tryConnect[interval:" + paramLong + "][state:" + paramString + "]");
              if ((paramLong < this.q) && (this.q != -1L))
                this.m.sendEmptyMessage(3);
              this.q = paramLong;
              this.p = true;
              this.r = paramString;
              this.m.sendEmptyMessage(0);
              this.m.sendEmptyMessageDelayed(1, 10000L);
            }
          }
          else
          {
            aJ.c("MessagePush", "forceConnect[interval:" + paramLong + "][state:" + paramString + "]");
            if ((paramLong < this.q) && (this.q != -1L))
              this.m.sendEmptyMessage(3);
            this.q = paramLong;
            this.p = true;
            this.r = paramString;
            this.m.sendEmptyMessageDelayed(-1, 2000L);
            return;
          }
      }
      catch (Throwable localThrowable)
      {
      }
    }

    public boolean handleMessage(Message paramMessage)
    {
      try
      {
        switch (paramMessage.what)
        {
        case 0:
          a(this.q);
          break;
        case 1:
          this.o = false;
          break;
        case 2:
          aS.a(aS.this, this.p);
          break;
        case 3:
          c();
          break;
        case -1:
          a(this.q);
        }
        label88: return true;
      }
      catch (Throwable localThrowable)
      {
        break label88;
      }
    }

    public void onReceive(Context paramContext, Intent paramIntent)
    {
      try
      {
        if ((TextUtils.equals("agoo_action_re_connect", paramIntent.getAction())) && (this.m != null))
          this.m.sendEmptyMessage(2);
        return;
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.aS
 * JD-Core Version:    0.6.2
 */