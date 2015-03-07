package com.umeng.update.net;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import u.upd.b;

public class a
{
  private static final String b = a.class.getName();
  final Messenger a = new Messenger(new b());
  private Context c;
  private d d;
  private Messenger e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String[] k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private ServiceConnection o = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      b.c(a.b(), "ServiceConnection.onServiceConnected");
      a.a(a.this, new Messenger(paramAnonymousIBinder));
      try
      {
        Message localMessage = Message.obtain(null, 4);
        a.a locala = new a.a(a.a(a.this), a.b(a.this), a.c(a.this));
        locala.d = a.d(a.this);
        locala.e = a.e(a.this);
        locala.f = a.f(a.this);
        locala.g = a.g(a.this);
        locala.h = a.h(a.this);
        locala.i = a.i(a.this);
        localMessage.setData(locala.a());
        localMessage.replyTo = a.this.a;
        a.j(a.this).send(localMessage);
        return;
      }
      catch (RemoteException localRemoteException)
      {
      }
    }

    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      b.c(a.b(), "ServiceConnection.onServiceDisconnected");
      a.a(a.this, null);
    }
  };

  public a(Context paramContext, String paramString1, String paramString2, String paramString3, d paramd)
  {
    this.c = paramContext.getApplicationContext();
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.d = paramd;
  }

  public void a()
  {
    Intent localIntent = new Intent(this.c, DownloadingService.class);
    this.c.bindService(localIntent, this.o, 1);
    this.c.startService(new Intent(this.c, DownloadingService.class));
  }

  public void a(String paramString)
  {
    this.i = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }

  public void a(String[] paramArrayOfString)
  {
    this.k = paramArrayOfString;
  }

  public void b(String paramString)
  {
    this.j = paramString;
  }

  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }

  public void c(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }

  static class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String[] f = null;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;

    public a(String paramString1, String paramString2, String paramString3)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
    }

    public static a a(Bundle paramBundle)
    {
      a locala = new a(paramBundle.getString("mComponentName"), paramBundle.getString("mTitle"), paramBundle.getString("mUrl"));
      locala.d = paramBundle.getString("mMd5");
      locala.e = paramBundle.getString("mTargetMd5");
      locala.f = paramBundle.getStringArray("reporturls");
      locala.g = paramBundle.getBoolean("rich_notification");
      locala.h = paramBundle.getBoolean("mSilent");
      locala.i = paramBundle.getBoolean("mWifiOnly");
      return locala;
    }

    public Bundle a()
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("mComponentName", this.a);
      localBundle.putString("mTitle", this.b);
      localBundle.putString("mUrl", this.c);
      localBundle.putString("mMd5", this.d);
      localBundle.putString("mTargetMd5", this.e);
      localBundle.putStringArray("reporturls", this.f);
      localBundle.putBoolean("rich_notification", this.g);
      localBundle.putBoolean("mSilent", this.h);
      localBundle.putBoolean("mWifiOnly", this.i);
      return localBundle;
    }
  }

  class b extends Handler
  {
    b()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      try
      {
        b.c(a.b(), "DownloadAgent.handleMessage(" + paramMessage.what + "): ");
        switch (paramMessage.what)
        {
        case 4:
        default:
          super.handleMessage(paramMessage);
          return;
        case 1:
          if (a.k(a.this) == null)
            return;
          a.k(a.this).d();
          return;
        case 3:
        case 5:
        case 2:
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        b.c(a.b(), "DownloadAgent.handleMessage(" + paramMessage.what + "): " + localException.getMessage());
        return;
      }
      if (a.k(a.this) != null)
      {
        a.k(a.this).a(paramMessage.arg1);
        return;
        a.l(a.this).unbindService(a.m(a.this));
        if (a.k(a.this) != null)
        {
          if ((paramMessage.arg1 == 1) || (paramMessage.arg1 == 3) || (paramMessage.arg1 == 5))
          {
            a.k(a.this).a(paramMessage.arg1, paramMessage.arg2, paramMessage.getData().getString("filename"));
            return;
          }
          a.k(a.this).a(0, 0, null);
          b.c(a.b(), "DownloadAgent.handleMessage(DownloadingService.DOWNLOAD_COMPLETE_FAIL): ");
          return;
          a.k(a.this).b(paramMessage.arg1);
        }
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.net.a
 * JD-Core Version:    0.6.2
 */