package com.umeng.update.net;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.SparseArray;
import android.widget.Toast;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import u.upd.a;
import u.upd.l;
import u.upd.n;

public class DownloadingService extends Service
{
  private static final long C = 8000L;
  private static final long D = 500L;
  private static Map<a.a, Messenger> E = new HashMap();
  private static SparseArray<c.b> F = new SparseArray();
  private static Boolean I = Boolean.valueOf(false);
  static final int a = 1;
  static final int b = 2;
  static final int c = 3;
  static final int d = 4;
  static final int e = 5;
  static final int f = 6;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  public static final int m = 6;
  public static final int n = 7;
  static final int o = 100;
  static final String p = "filename";
  public static boolean r = false;
  private static final String t = DownloadingService.class.getName();
  private static final long w = 104857600L;
  private static final long x = 10485760L;
  private static final long y = 259200000L;
  private static final int z = 3;
  private Context A;
  private Handler B;
  private e G;
  private boolean H = true;
  a q;
  final Messenger s = new Messenger(new c());
  private NotificationManager u;
  private c v;

  static
  {
    r = false;
  }

  private void a(a.a parama)
  {
    u.upd.b.c(t, "startDownload([mComponentName:" + parama.a + " mTitle:" + parama.b + " mUrl:" + parama.c + "])");
    int i1 = this.v.a(parama);
    b localb = new b(getApplicationContext(), parama, i1, 0, this.q);
    c.b localb1 = new c.b(parama, i1);
    this.G.a(i1);
    localb1.a(F);
    localb1.a = localb;
    localb.start();
    e();
    boolean bool = r;
    int i2 = 0;
    if (bool);
    while (true)
    {
      if (i2 >= F.size())
        return;
      c.b localb2 = (c.b)F.valueAt(i2);
      u.upd.b.c(t, "Running task " + localb2.e.b);
      i2++;
    }
  }

  private void a(final String paramString)
  {
    synchronized (I)
    {
      if (!I.booleanValue())
      {
        u.upd.b.c(t, "show single toast.[" + paramString + "]");
        I = Boolean.valueOf(true);
        this.B.post(new Runnable()
        {
          public void run()
          {
            Toast.makeText(DownloadingService.b(DownloadingService.this), paramString, 0).show();
          }
        });
        this.B.postDelayed(new Runnable()
        {
          public void run()
          {
            DownloadingService.a(Boolean.valueOf(false));
          }
        }
        , 1200L);
      }
      return;
    }
  }

  private void d()
  {
    Iterator localIterator = this.G.a().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Integer localInteger = (Integer)localIterator.next();
      this.u.cancel(localInteger.intValue());
    }
  }

  private void e()
  {
    if (r)
    {
      int i1 = E.size();
      int i2 = F.size();
      u.upd.b.a(t, "Client size =" + i1 + "   cacheSize = " + i2);
      if (i1 != i2)
        throw new RuntimeException("Client size =" + i1 + "   cacheSize = " + i2);
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    u.upd.b.c(t, "onBind ");
    return this.s.getBinder();
  }

  public void onCreate()
  {
    super.onCreate();
    if (r)
    {
      u.upd.b.a = true;
      Debug.waitForDebugger();
    }
    u.upd.b.c(t, "onCreate ");
    this.u = ((NotificationManager)getSystemService("notification"));
    this.A = this;
    this.G = new e(this.A);
    this.v = new c(F, E, this.G);
    this.B = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
          return;
        case 5:
          a.a locala2 = (a.a)paramAnonymousMessage.obj;
          int j = paramAnonymousMessage.arg2;
          while (true)
          {
            PendingIntent localPendingIntent2;
            try
            {
              String str4 = paramAnonymousMessage.getData().getString("filename");
              j.a(str4, 39, -1, -1);
              u.upd.b.c(DownloadingService.a(), "Cancel old notification....");
              Intent localIntent = new Intent("android.intent.action.VIEW");
              localIntent.addFlags(268435456);
              localIntent.setDataAndType(Uri.fromFile(new File(str4)), "application/vnd.android.package-archive");
              localPendingIntent2 = PendingIntent.getActivity(DownloadingService.b(DownloadingService.this), 0, localIntent, 134217728);
              if (locala2.h)
              {
                Notification localNotification2 = new Notification(17301634, DownloadingService.b(DownloadingService.this).getString(l.m(DownloadingService.b(DownloadingService.this))), System.currentTimeMillis());
                localNotification2.setLatestEventInfo(DownloadingService.b(DownloadingService.this), locala2.b, DownloadingService.b(DownloadingService.this).getString(l.m(DownloadingService.b(DownloadingService.this))), localPendingIntent2);
                localObject = localNotification2;
                ((Notification)localObject).flags = 16;
                DownloadingService.a(DownloadingService.this, (NotificationManager)DownloadingService.this.getSystemService("notification"));
                DownloadingService.c(DownloadingService.this).notify(j + 1, (Notification)localObject);
                u.upd.b.c(DownloadingService.a(), "Show new  notification....");
                boolean bool = DownloadingService.a(DownloadingService.this).a(DownloadingService.b(DownloadingService.this));
                String str5 = DownloadingService.a();
                Object[] arrayOfObject1 = new Object[1];
                arrayOfObject1[0] = Boolean.valueOf(bool);
                u.upd.b.c(str5, String.format("isAppOnForeground = %1$B", arrayOfObject1));
                if ((bool) && (!locala2.h))
                {
                  DownloadingService.c(DownloadingService.this).cancel(j + 1);
                  DownloadingService.b(DownloadingService.this).startActivity(localIntent);
                }
                String str6 = DownloadingService.a();
                Object[] arrayOfObject2 = new Object[2];
                arrayOfObject2[0] = locala2.b;
                arrayOfObject2[1] = str4;
                u.upd.b.a(str6, String.format("%1$10s downloaded. Saved to: %2$s", arrayOfObject2));
                return;
              }
            }
            catch (Exception localException)
            {
              u.upd.b.b(DownloadingService.a(), "can not install. " + localException.getMessage());
              DownloadingService.c(DownloadingService.this).cancel(j + 1);
              return;
            }
            Notification localNotification3 = new Notification(17301634, DownloadingService.b(DownloadingService.this).getString(l.k(DownloadingService.b(DownloadingService.this))), System.currentTimeMillis());
            localNotification3.setLatestEventInfo(DownloadingService.b(DownloadingService.this), locala2.b, DownloadingService.b(DownloadingService.this).getString(l.k(DownloadingService.b(DownloadingService.this))), localPendingIntent2);
            Object localObject = localNotification3;
          }
        case 6:
        }
        a.a locala1 = (a.a)paramAnonymousMessage.obj;
        int i = paramAnonymousMessage.arg2;
        String str1 = paramAnonymousMessage.getData().getString("filename");
        DownloadingService.c(DownloadingService.this).cancel(i);
        Notification localNotification1 = new Notification(17301633, DownloadingService.b(DownloadingService.this).getString(l.n(DownloadingService.b(DownloadingService.this))), System.currentTimeMillis());
        PendingIntent localPendingIntent1 = PendingIntent.getActivity(DownloadingService.b(DownloadingService.this), 0, new Intent(), 134217728);
        localNotification1.setLatestEventInfo(DownloadingService.b(DownloadingService.this), a.v(DownloadingService.b(DownloadingService.this)), DownloadingService.b(DownloadingService.this).getString(l.n(DownloadingService.b(DownloadingService.this))), localPendingIntent1);
        DownloadingService.c(DownloadingService.this).notify(i + 1, localNotification1);
        String str2 = str1.replace(".patch", ".apk");
        String str3 = DeltaUpdate.a(DownloadingService.this);
        c localc = DownloadingService.a(DownloadingService.this);
        localc.getClass();
        new c.c(localc, DownloadingService.b(DownloadingService.this), i, locala1, str2).execute(new String[] { str3, str2, str1 });
      }
    };
    this.q = new a()
    {
      SparseArray<Long> a = new SparseArray();

      public void a(int paramAnonymousInt)
      {
        if (DownloadingService.b().indexOfKey(paramAnonymousInt) >= 0)
        {
          c.b localb = (c.b)DownloadingService.b().get(paramAnonymousInt);
          long[] arrayOfLong = localb.f;
          int i = 0;
          if (arrayOfLong != null)
          {
            boolean bool = arrayOfLong[1] < 0L;
            i = 0;
            if (bool)
            {
              i = (int)(100.0F * ((float)arrayOfLong[0] / (float)arrayOfLong[1]));
              if (i > 100)
                i = 99;
            }
          }
          if (!localb.e.h)
          {
            this.a.put(paramAnonymousInt, Long.valueOf(-1L));
            c.a locala = DownloadingService.a(DownloadingService.this).a(DownloadingService.this, localb.e, paramAnonymousInt, i);
            localb.b = locala;
            DownloadingService.c(DownloadingService.this).notify(paramAnonymousInt, locala.d());
          }
        }
      }

      public void a(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (DownloadingService.b().indexOfKey(paramAnonymousInt1) >= 0)
        {
          c.b localb = (c.b)DownloadingService.b().get(paramAnonymousInt1);
          a.a locala = localb.e;
          long l = System.currentTimeMillis();
          if ((!locala.h) && (l - ((Long)this.a.get(paramAnonymousInt1)).longValue() > 500L))
          {
            this.a.put(paramAnonymousInt1, Long.valueOf(l));
            c.a locala1 = localb.b;
            locala1.a(100, paramAnonymousInt2, false).a(String.valueOf(paramAnonymousInt2) + "%");
            DownloadingService.c(DownloadingService.this).notify(paramAnonymousInt1, locala1.d());
          }
          String str = DownloadingService.a();
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = Integer.valueOf(paramAnonymousInt1);
          arrayOfObject[1] = Integer.valueOf(paramAnonymousInt2);
          arrayOfObject[2] = locala.b;
          u.upd.b.c(str, String.format("%3$10s Notification: mNotificationId = %1$15s\t|\tprogress = %2$15s", arrayOfObject));
        }
      }

      public void a(int paramAnonymousInt, Exception paramAnonymousException)
      {
        if (DownloadingService.b().indexOfKey(paramAnonymousInt) >= 0)
          DownloadingService.a(DownloadingService.this).b(DownloadingService.b(DownloadingService.this), paramAnonymousInt);
      }

      public void a(int paramAnonymousInt, String paramAnonymousString)
      {
        a.a locala;
        Bundle localBundle;
        if (DownloadingService.b().indexOfKey(paramAnonymousInt) >= 0)
        {
          c.b localb = (c.b)DownloadingService.b().get(paramAnonymousInt);
          if (localb != null)
          {
            locala = localb.e;
            b.a(DownloadingService.b(DownloadingService.this)).a(locala.a, locala.c, 100);
            localBundle = new Bundle();
            localBundle.putString("filename", paramAnonymousString);
            if (!locala.a.equalsIgnoreCase("delta_update"))
              break label138;
            Message localMessage3 = Message.obtain();
            localMessage3.what = 6;
            localMessage3.arg1 = 1;
            localMessage3.obj = locala;
            localMessage3.arg2 = paramAnonymousInt;
            localMessage3.setData(localBundle);
            DownloadingService.d(DownloadingService.this).sendMessage(localMessage3);
          }
        }
        return;
        label138: Message localMessage1 = Message.obtain();
        localMessage1.what = 5;
        localMessage1.arg1 = 1;
        localMessage1.obj = locala;
        localMessage1.arg2 = paramAnonymousInt;
        localMessage1.setData(localBundle);
        DownloadingService.d(DownloadingService.this).sendMessage(localMessage1);
        Message localMessage2 = Message.obtain();
        localMessage2.what = 5;
        localMessage2.arg1 = 1;
        localMessage2.arg2 = paramAnonymousInt;
        localMessage2.setData(localBundle);
        try
        {
          if (DownloadingService.c().get(locala) != null)
            ((Messenger)DownloadingService.c().get(locala)).send(localMessage2);
          DownloadingService.a(DownloadingService.this).b(DownloadingService.b(DownloadingService.this), paramAnonymousInt);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          DownloadingService.a(DownloadingService.this).b(DownloadingService.b(DownloadingService.this), paramAnonymousInt);
        }
      }
    };
  }

  public void onDestroy()
  {
    try
    {
      b.a(getApplicationContext()).a(259200);
      b.a(getApplicationContext()).finalize();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      while (true)
        u.upd.b.b(t, localException.getMessage());
    }
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
      this.v.a(this, paramIntent);
    if ((Build.VERSION.SDK_INT >= 19) && ((this.G.b()) || (this.H)));
    try
    {
      Intent localIntent = new Intent(getApplicationContext(), getClass());
      localIntent.setPackage(getPackageName());
      PendingIntent localPendingIntent = PendingIntent.getService(getApplicationContext(), 1, localIntent, 1073741824);
      ((AlarmManager)getApplicationContext().getSystemService("alarm")).set(3, 5000L + SystemClock.elapsedRealtime(), localPendingIntent);
      label114: if (this.H)
      {
        d();
        this.H = false;
      }
      return 1;
    }
    catch (Exception localException)
    {
      break label114;
    }
  }

  static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(int paramInt1, int paramInt2);

    public abstract void a(int paramInt, Exception paramException);

    public abstract void a(int paramInt, String paramString);
  }

  class b extends Thread
  {
    private Context b;
    private boolean c;
    private File d;
    private int e = 0;
    private long f = -1L;
    private long g = -1L;
    private int h = -1;
    private int i;
    private DownloadingService.a j;
    private a.a k;

    public b(Context parama, a.a paramInt1, int paramInt2, int parama1, DownloadingService.a arg6)
    {
      try
      {
        this.b = parama;
        this.k = paramInt1;
        this.e = parama1;
        if (DownloadingService.b().indexOfKey(paramInt2) >= 0)
        {
          long[] arrayOfLong = ((c.b)DownloadingService.b().get(paramInt2)).f;
          if ((arrayOfLong != null) && (arrayOfLong.length > 1))
          {
            this.f = arrayOfLong[0];
            this.g = arrayOfLong[1];
          }
        }
        Object localObject;
        this.j = localObject;
        this.i = paramInt2;
        boolean[] arrayOfBoolean = new boolean[1];
        this.d = j.a("/apk", parama, arrayOfBoolean);
        this.c = arrayOfBoolean[0];
        if (this.c);
        for (long l = 104857600L; ; l = 10485760L)
        {
          j.a(this.d, l, 259200000L);
          String str = a(this.k);
          this.d = new File(this.d, str);
          return;
        }
      }
      catch (Exception localException)
      {
        u.upd.b.c(DownloadingService.a(), localException.getMessage(), localException);
        this.j.a(this.i, localException);
      }
    }

    private String a(a.a parama)
    {
      if (this.k.e != null);
      for (String str = this.k.e + ".apk.tmp"; ; str = n.a(this.k.c) + ".apk.tmp")
      {
        if (this.k.a.equalsIgnoreCase("delta_update"))
          str = str.replace(".apk", ".patch");
        return str;
      }
    }

    private HttpURLConnection a(URL paramURL, File paramFile)
      throws IOException
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
      localHttpURLConnection.addRequestProperty("Connection", "keep-alive");
      localHttpURLConnection.setConnectTimeout(5000);
      localHttpURLConnection.setReadTimeout(10000);
      if ((paramFile.exists()) && (paramFile.length() > 0L))
      {
        String str1 = DownloadingService.a();
        String str2 = this.k.b + " getFileLength: %1$15s";
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Long.valueOf(paramFile.length());
        u.upd.b.c(str1, String.format(str2, arrayOfObject));
        localHttpURLConnection.setRequestProperty("Range", "bytes=" + paramFile.length() + "-");
      }
      return localHttpURLConnection;
    }

    private void a()
    {
      u.upd.b.c(DownloadingService.a(), "wait for repeating Test network repeat count=" + this.e);
      try
      {
        if (!this.k.g)
        {
          Thread.sleep(8000L);
          if (this.g < 1L)
          {
            a(false);
            return;
          }
          a(true);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        a(localInterruptedException);
        DownloadingService.a(DownloadingService.this).b(this.b, this.i);
        return;
      }
      c.b localb = (c.b)DownloadingService.b().get(this.i);
      localb.f[0] = this.f;
      localb.f[1] = this.g;
      localb.f[2] = this.e;
      String str = f.a(this.i, "continue");
      Intent localIntent = new Intent(this.b, DownloadingService.class);
      localIntent.putExtra("com.umeng.broadcast.download.msg", str);
      DownloadingService.a(DownloadingService.this).a(DownloadingService.this, localIntent);
      DownloadingService.a(DownloadingService.this, this.b.getString(l.c(this.b)));
      u.upd.b.c(DownloadingService.a(), "changed play state button on op-notification.");
    }

    private void a(File paramFile, String paramString)
      throws RemoteException
    {
      u.upd.b.c(DownloadingService.a(), "itemMd5 " + this.k.d);
      u.upd.b.c(DownloadingService.a(), "fileMd5 " + n.a(paramFile));
      Message localMessage;
      if ((this.k.d != null) && (!this.k.d.equalsIgnoreCase(n.a(paramFile))))
      {
        if (!this.k.a.equalsIgnoreCase("delta_update"))
          break label237;
        DownloadingService.c(DownloadingService.this).cancel(this.i);
        Bundle localBundle = new Bundle();
        localBundle.putString("filename", paramString);
        localMessage = Message.obtain();
        localMessage.what = 5;
        localMessage.arg1 = 3;
        localMessage.arg2 = this.i;
        localMessage.setData(localBundle);
      }
      label237: 
      do
      {
        try
        {
          if (DownloadingService.c().get(this.k) != null)
            ((Messenger)DownloadingService.c().get(this.k)).send(localMessage);
          DownloadingService.a(DownloadingService.this).b(this.b, this.i);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          DownloadingService.a(DownloadingService.this).b(this.b, this.i);
          return;
        }
        ((Messenger)DownloadingService.c().get(this.k)).send(Message.obtain(null, 5, 0, 0));
      }
      while (this.k.h);
      DownloadingService.a(DownloadingService.this).b(this.b, this.i);
      Notification localNotification = new Notification(17301634, this.b.getString(l.i(this.b)), System.currentTimeMillis());
      PendingIntent localPendingIntent = PendingIntent.getActivity(this.b, 0, new Intent(), 0);
      localNotification.setLatestEventInfo(this.b, a.v(this.b), this.k.b + this.b.getString(l.i(this.b)), localPendingIntent);
      localNotification.flags = (0x10 | localNotification.flags);
      DownloadingService.c(DownloadingService.this).notify(this.i, localNotification);
    }

    private void a(Exception paramException)
    {
      u.upd.b.b(DownloadingService.a(), "can not install. " + paramException.getMessage());
      if (this.j != null)
        this.j.a(this.i, paramException);
      DownloadingService.a(DownloadingService.this).a(this.k, this.f, this.g, this.e);
    }

    // ERROR //
    private void a(boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   4: invokevirtual 413	java/io/File:getName	()Ljava/lang/String;
      //   7: astore_2
      //   8: new 415	java/io/FileOutputStream
      //   11: dup
      //   12: aload_0
      //   13: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   16: iconst_1
      //   17: invokespecial 418	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
      //   20: astore_3
      //   21: aload_0
      //   22: getfield 81	com/umeng/update/net/DownloadingService$b:c	Z
      //   25: ifne +1803 -> 1828
      //   28: aload_0
      //   29: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   32: invokevirtual 421	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   35: iconst_3
      //   36: invokestatic 424	com/umeng/update/net/j:a	(Ljava/lang/String;I)Z
      //   39: ifne +1789 -> 1828
      //   42: aload_3
      //   43: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   46: aload_0
      //   47: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   50: aload_2
      //   51: ldc_w 428
      //   54: invokevirtual 432	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   57: astore 75
      //   59: aload_0
      //   60: aload_0
      //   61: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   64: aload_2
      //   65: invokevirtual 436	android/content/Context:getFileStreamPath	(Ljava/lang/String;)Ljava/io/File;
      //   68: putfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   71: aload 75
      //   73: astore 9
      //   75: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   78: astore 35
      //   80: iconst_2
      //   81: anewarray 215	java/lang/Object
      //   84: astore 36
      //   86: aload 36
      //   88: iconst_0
      //   89: aload_0
      //   90: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   93: getfield 158	com/umeng/update/net/a$a:c	Ljava/lang/String;
      //   96: aastore
      //   97: aload 36
      //   99: iconst_1
      //   100: aload_0
      //   101: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   104: invokevirtual 421	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   107: aastore
      //   108: aload 35
      //   110: ldc_w 438
      //   113: aload 36
      //   115: invokestatic 224	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   118: invokestatic 226	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   121: aload_0
      //   122: new 168	java/net/URL
      //   125: dup
      //   126: aload_0
      //   127: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   130: getfield 158	com/umeng/update/net/a$a:c	Ljava/lang/String;
      //   133: invokespecial 439	java/net/URL:<init>	(Ljava/lang/String;)V
      //   136: aload_0
      //   137: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   140: invokespecial 441	com/umeng/update/net/DownloadingService$b:a	(Ljava/net/URL;Ljava/io/File;)Ljava/net/HttpURLConnection;
      //   143: astore 37
      //   145: aload 37
      //   147: invokevirtual 444	java/net/HttpURLConnection:connect	()V
      //   150: aload 37
      //   152: invokevirtual 448	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   155: astore 38
      //   157: aload 38
      //   159: astore 10
      //   161: iload_1
      //   162: ifne +165 -> 327
      //   165: lconst_0
      //   166: lstore 67
      //   168: aload_0
      //   169: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   172: invokevirtual 205	java/io/File:exists	()Z
      //   175: ifeq +27 -> 202
      //   178: aload_0
      //   179: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   182: invokevirtual 209	java/io/File:length	()J
      //   185: lconst_0
      //   186: lcmp
      //   187: ifle +15 -> 202
      //   190: lload 67
      //   192: aload_0
      //   193: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   196: invokevirtual 209	java/io/File:length	()J
      //   199: ladd
      //   200: lstore 67
      //   202: aload_0
      //   203: lload 67
      //   205: putfield 38	com/umeng/update/net/DownloadingService$b:f	J
      //   208: aload_0
      //   209: lload 67
      //   211: aload 37
      //   213: invokevirtual 452	java/net/HttpURLConnection:getContentLength	()I
      //   216: i2l
      //   217: ladd
      //   218: putfield 40	com/umeng/update/net/DownloadingService$b:g	J
      //   221: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   224: astore 69
      //   226: iconst_1
      //   227: anewarray 215	java/lang/Object
      //   230: astore 70
      //   232: aload 70
      //   234: iconst_0
      //   235: aload_0
      //   236: getfield 38	com/umeng/update/net/DownloadingService$b:f	J
      //   239: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   242: aastore
      //   243: aload 69
      //   245: ldc_w 454
      //   248: aload 70
      //   250: invokestatic 224	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   253: invokestatic 226	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   256: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   259: astore 71
      //   261: iconst_1
      //   262: anewarray 215	java/lang/Object
      //   265: astore 72
      //   267: aload 72
      //   269: iconst_0
      //   270: aload 37
      //   272: invokevirtual 452	java/net/HttpURLConnection:getContentLength	()I
      //   275: invokestatic 459	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   278: aastore
      //   279: aload 71
      //   281: ldc_w 461
      //   284: aload 72
      //   286: invokestatic 224	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   289: invokestatic 226	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   292: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   295: astore 73
      //   297: iconst_1
      //   298: anewarray 215	java/lang/Object
      //   301: astore 74
      //   303: aload 74
      //   305: iconst_0
      //   306: aload_0
      //   307: getfield 40	com/umeng/update/net/DownloadingService$b:g	J
      //   310: invokestatic 220	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   313: aastore
      //   314: aload 73
      //   316: ldc_w 463
      //   319: aload 74
      //   321: invokestatic 224	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   324: invokestatic 226	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   327: sipush 4096
      //   330: newarray byte
      //   332: astore 40
      //   334: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   337: new 122	java/lang/StringBuilder
      //   340: dup
      //   341: aload_0
      //   342: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   345: getfield 211	com/umeng/update/net/a$a:b	Ljava/lang/String;
      //   348: invokestatic 128	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   351: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   354: ldc_w 465
      //   357: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: aload_0
      //   361: getfield 40	com/umeng/update/net/DownloadingService$b:g	J
      //   364: invokestatic 468	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   367: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   370: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   373: invokestatic 226	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;)V
      //   376: aload_0
      //   377: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   380: invokestatic 473	com/umeng/update/net/b:a	(Landroid/content/Context;)Lcom/umeng/update/net/b;
      //   383: aload_0
      //   384: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   387: getfield 142	com/umeng/update/net/a$a:a	Ljava/lang/String;
      //   390: aload_0
      //   391: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   394: getfield 158	com/umeng/update/net/a$a:c	Ljava/lang/String;
      //   397: invokevirtual 476	com/umeng/update/net/b:a	(Ljava/lang/String;Ljava/lang/String;)Z
      //   400: pop
      //   401: iconst_0
      //   402: istore 42
      //   404: aload_0
      //   405: getfield 42	com/umeng/update/net/DownloadingService$b:h	I
      //   408: ifge +1426 -> 1834
      //   411: aload 10
      //   413: aload 40
      //   415: invokevirtual 482	java/io/InputStream:read	([B)I
      //   418: istore 63
      //   420: iload 63
      //   422: ifgt +94 -> 516
      //   425: goto +1409 -> 1834
      //   428: aload 10
      //   430: invokevirtual 483	java/io/InputStream:close	()V
      //   433: aload 9
      //   435: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   438: aload_0
      //   439: getfield 42	com/umeng/update/net/DownloadingService$b:h	I
      //   442: iconst_1
      //   443: if_icmpne +482 -> 925
      //   446: invokestatic 51	com/umeng/update/net/DownloadingService:b	()Landroid/util/SparseArray;
      //   449: aload_0
      //   450: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   453: invokevirtual 61	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   456: checkcast 63	com/umeng/update/net/c$b
      //   459: astore 57
      //   461: aload 57
      //   463: getfield 66	com/umeng/update/net/c$b:f	[J
      //   466: iconst_0
      //   467: aload_0
      //   468: getfield 38	com/umeng/update/net/DownloadingService$b:f	J
      //   471: lastore
      //   472: aload 57
      //   474: getfield 66	com/umeng/update/net/c$b:f	[J
      //   477: iconst_1
      //   478: aload_0
      //   479: getfield 40	com/umeng/update/net/DownloadingService$b:g	J
      //   482: lastore
      //   483: aload 57
      //   485: getfield 66	com/umeng/update/net/c$b:f	[J
      //   488: iconst_2
      //   489: aload_0
      //   490: getfield 34	com/umeng/update/net/DownloadingService$b:e	I
      //   493: i2l
      //   494: lastore
      //   495: aload 10
      //   497: ifnull +8 -> 505
      //   500: aload 10
      //   502: invokevirtual 483	java/io/InputStream:close	()V
      //   505: aload 9
      //   507: ifnull +8 -> 515
      //   510: aload 9
      //   512: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   515: return
      //   516: aload 9
      //   518: aload 40
      //   520: iconst_0
      //   521: iload 63
      //   523: invokevirtual 487	java/io/FileOutputStream:write	([BII)V
      //   526: aload_0
      //   527: aload_0
      //   528: getfield 38	com/umeng/update/net/DownloadingService$b:f	J
      //   531: iload 63
      //   533: i2l
      //   534: ladd
      //   535: putfield 38	com/umeng/update/net/DownloadingService$b:f	J
      //   538: iload 42
      //   540: iconst_1
      //   541: iadd
      //   542: istore 64
      //   544: iload 42
      //   546: bipush 50
      //   548: irem
      //   549: ifne +310 -> 859
      //   552: aload_0
      //   553: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   556: invokestatic 491	u/upd/a:l	(Landroid/content/Context;)Z
      //   559: istore 65
      //   561: iconst_0
      //   562: istore 43
      //   564: iload 65
      //   566: ifeq -138 -> 428
      //   569: aload_0
      //   570: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   573: invokestatic 493	u/upd/a:k	(Landroid/content/Context;)Z
      //   576: ifne +200 -> 776
      //   579: aload_0
      //   580: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   583: getfield 495	com/umeng/update/net/a$a:i	Z
      //   586: ifeq +190 -> 776
      //   589: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   592: ldc_w 497
      //   595: invokestatic 407	u/upd/b:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   598: new 166	java/io/IOException
      //   601: dup
      //   602: ldc_w 497
      //   605: invokespecial 498	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   608: athrow
      //   609: astore 39
      //   611: aload 39
      //   613: astore 6
      //   615: aload 9
      //   617: astore 5
      //   619: aload 10
      //   621: astore 7
      //   623: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   626: aload 6
      //   628: invokevirtual 499	java/io/IOException:getMessage	()Ljava/lang/String;
      //   631: aload 6
      //   633: invokestatic 109	u/upd/b:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
      //   636: iconst_1
      //   637: aload_0
      //   638: getfield 34	com/umeng/update/net/DownloadingService$b:e	I
      //   641: iadd
      //   642: istore 16
      //   644: aload_0
      //   645: iload 16
      //   647: putfield 34	com/umeng/update/net/DownloadingService$b:e	I
      //   650: iload 16
      //   652: iconst_3
      //   653: if_icmple +799 -> 1452
      //   656: aload_0
      //   657: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   660: getfield 244	com/umeng/update/net/a$a:g	Z
      //   663: istore 17
      //   665: iload 17
      //   667: ifne +785 -> 1452
      //   670: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   673: ldc_w 501
      //   676: invokestatic 407	u/upd/b:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   679: invokestatic 350	com/umeng/update/net/DownloadingService:c	()Ljava/util/Map;
      //   682: aload_0
      //   683: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   686: invokeinterface 355 2 0
      //   691: checkcast 357	android/os/Messenger
      //   694: aconst_null
      //   695: iconst_5
      //   696: iconst_0
      //   697: iconst_0
      //   698: invokestatic 364	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
      //   701: invokevirtual 361	android/os/Messenger:send	(Landroid/os/Message;)V
      //   704: aload_0
      //   705: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   708: invokestatic 259	com/umeng/update/net/DownloadingService:a	(Lcom/umeng/update/net/DownloadingService;)Lcom/umeng/update/net/c;
      //   711: aload_0
      //   712: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   715: aload_0
      //   716: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   719: invokevirtual 264	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
      //   722: aload_0
      //   723: aload 6
      //   725: invokespecial 256	com/umeng/update/net/DownloadingService$b:a	(Ljava/lang/Exception;)V
      //   728: aload_0
      //   729: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   732: invokestatic 504	com/umeng/update/net/DownloadingService:d	(Lcom/umeng/update/net/DownloadingService;)Landroid/os/Handler;
      //   735: new 506	com/umeng/update/net/DownloadingService$b$1
      //   738: dup
      //   739: aload_0
      //   740: invokespecial 509	com/umeng/update/net/DownloadingService$b$1:<init>	(Lcom/umeng/update/net/DownloadingService$b;)V
      //   743: invokevirtual 515	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   746: pop
      //   747: aload 7
      //   749: ifnull +8 -> 757
      //   752: aload 7
      //   754: invokevirtual 483	java/io/InputStream:close	()V
      //   757: aload 5
      //   759: ifnull -244 -> 515
      //   762: aload 5
      //   764: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   767: return
      //   768: astore 18
      //   770: aload 18
      //   772: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   775: return
      //   776: ldc_w 519
      //   779: aload_0
      //   780: getfield 38	com/umeng/update/net/DownloadingService$b:f	J
      //   783: l2f
      //   784: fmul
      //   785: aload_0
      //   786: getfield 40	com/umeng/update/net/DownloadingService$b:g	J
      //   789: l2f
      //   790: fdiv
      //   791: f2i
      //   792: istore 66
      //   794: iload 66
      //   796: bipush 100
      //   798: if_icmple +7 -> 805
      //   801: bipush 99
      //   803: istore 66
      //   805: aload_0
      //   806: getfield 68	com/umeng/update/net/DownloadingService$b:j	Lcom/umeng/update/net/DownloadingService$a;
      //   809: ifnull +18 -> 827
      //   812: aload_0
      //   813: getfield 68	com/umeng/update/net/DownloadingService$b:j	Lcom/umeng/update/net/DownloadingService$a;
      //   816: aload_0
      //   817: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   820: iload 66
      //   822: invokeinterface 522 3 0
      //   827: aload_0
      //   828: iload 66
      //   830: invokespecial 524	com/umeng/update/net/DownloadingService$b:b	(I)V
      //   833: aload_0
      //   834: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   837: invokestatic 473	com/umeng/update/net/b:a	(Landroid/content/Context;)Lcom/umeng/update/net/b;
      //   840: aload_0
      //   841: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   844: getfield 142	com/umeng/update/net/a$a:a	Ljava/lang/String;
      //   847: aload_0
      //   848: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   851: getfield 158	com/umeng/update/net/a$a:c	Ljava/lang/String;
      //   854: iload 66
      //   856: invokevirtual 527	com/umeng/update/net/b:a	(Ljava/lang/String;Ljava/lang/String;I)V
      //   859: iload 64
      //   861: istore 42
      //   863: goto -459 -> 404
      //   866: astore 61
      //   868: aload 61
      //   870: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   873: aload 9
      //   875: ifnull -360 -> 515
      //   878: aload 9
      //   880: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   883: return
      //   884: astore 62
      //   886: aload 62
      //   888: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   891: return
      //   892: astore 59
      //   894: aload 9
      //   896: ifnull +8 -> 904
      //   899: aload 9
      //   901: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   904: aload 59
      //   906: athrow
      //   907: astore 60
      //   909: aload 60
      //   911: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   914: goto -10 -> 904
      //   917: astore 58
      //   919: aload 58
      //   921: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   924: return
      //   925: aload_0
      //   926: getfield 42	com/umeng/update/net/DownloadingService$b:h	I
      //   929: iconst_2
      //   930: if_icmpne +124 -> 1054
      //   933: aload_0
      //   934: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   937: invokestatic 259	com/umeng/update/net/DownloadingService:a	(Lcom/umeng/update/net/DownloadingService;)Lcom/umeng/update/net/c;
      //   940: aload_0
      //   941: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   944: aload_0
      //   945: getfield 38	com/umeng/update/net/DownloadingService$b:f	J
      //   948: aload_0
      //   949: getfield 40	com/umeng/update/net/DownloadingService$b:g	J
      //   952: aload_0
      //   953: getfield 34	com/umeng/update/net/DownloadingService$b:e	I
      //   956: i2l
      //   957: invokevirtual 410	com/umeng/update/net/c:a	(Lcom/umeng/update/net/a$a;JJJ)V
      //   960: aload_0
      //   961: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   964: invokestatic 315	com/umeng/update/net/DownloadingService:c	(Lcom/umeng/update/net/DownloadingService;)Landroid/app/NotificationManager;
      //   967: aload_0
      //   968: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   971: invokevirtual 320	android/app/NotificationManager:cancel	(I)V
      //   974: aload 10
      //   976: ifnull +8 -> 984
      //   979: aload 10
      //   981: invokevirtual 483	java/io/InputStream:close	()V
      //   984: aload 9
      //   986: ifnull -471 -> 515
      //   989: aload 9
      //   991: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   994: return
      //   995: astore 52
      //   997: aload 52
      //   999: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1002: return
      //   1003: astore 55
      //   1005: aload 55
      //   1007: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1010: aload 9
      //   1012: ifnull -497 -> 515
      //   1015: aload 9
      //   1017: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1020: return
      //   1021: astore 56
      //   1023: aload 56
      //   1025: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1028: return
      //   1029: astore 53
      //   1031: aload 9
      //   1033: ifnull +8 -> 1041
      //   1036: aload 9
      //   1038: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1041: aload 53
      //   1043: athrow
      //   1044: astore 54
      //   1046: aload 54
      //   1048: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1051: goto -10 -> 1041
      //   1054: iload 43
      //   1056: ifne +122 -> 1178
      //   1059: invokestatic 101	com/umeng/update/net/DownloadingService:a	()Ljava/lang/String;
      //   1062: new 122	java/lang/StringBuilder
      //   1065: dup
      //   1066: ldc_w 529
      //   1069: invokespecial 131	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1072: aload_0
      //   1073: getfield 34	com/umeng/update/net/DownloadingService$b:e	I
      //   1076: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1079: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1082: invokestatic 407	u/upd/b:b	(Ljava/lang/String;Ljava/lang/String;)V
      //   1085: invokestatic 350	com/umeng/update/net/DownloadingService:c	()Ljava/util/Map;
      //   1088: aload_0
      //   1089: getfield 46	com/umeng/update/net/DownloadingService$b:k	Lcom/umeng/update/net/a$a;
      //   1092: invokeinterface 355 2 0
      //   1097: checkcast 357	android/os/Messenger
      //   1100: aconst_null
      //   1101: iconst_5
      //   1102: iconst_0
      //   1103: iconst_0
      //   1104: invokestatic 364	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
      //   1107: invokevirtual 361	android/os/Messenger:send	(Landroid/os/Message;)V
      //   1110: aload_0
      //   1111: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   1114: invokestatic 259	com/umeng/update/net/DownloadingService:a	(Lcom/umeng/update/net/DownloadingService;)Lcom/umeng/update/net/c;
      //   1117: aload_0
      //   1118: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   1121: aload_0
      //   1122: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   1125: invokevirtual 264	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
      //   1128: aload_0
      //   1129: getfield 68	com/umeng/update/net/DownloadingService$b:j	Lcom/umeng/update/net/DownloadingService$a;
      //   1132: ifnull +17 -> 1149
      //   1135: aload_0
      //   1136: getfield 68	com/umeng/update/net/DownloadingService$b:j	Lcom/umeng/update/net/DownloadingService$a;
      //   1139: aload_0
      //   1140: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   1143: aconst_null
      //   1144: invokeinterface 114 3 0
      //   1149: aload 10
      //   1151: ifnull +8 -> 1159
      //   1154: aload 10
      //   1156: invokevirtual 483	java/io/InputStream:close	()V
      //   1159: aload 9
      //   1161: ifnull -646 -> 515
      //   1164: aload 9
      //   1166: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1169: return
      //   1170: astore 47
      //   1172: aload 47
      //   1174: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1177: return
      //   1178: aload_0
      //   1179: invokespecial 531	com/umeng/update/net/DownloadingService$b:b	()V
      //   1182: new 93	java/io/File
      //   1185: dup
      //   1186: aload_0
      //   1187: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   1190: invokevirtual 534	java/io/File:getParent	()Ljava/lang/String;
      //   1193: aload_0
      //   1194: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   1197: invokevirtual 413	java/io/File:getName	()Ljava/lang/String;
      //   1200: ldc_w 536
      //   1203: ldc_w 538
      //   1206: invokevirtual 156	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
      //   1209: invokespecial 540	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   1212: astore 44
      //   1214: aload_0
      //   1215: getfield 79	com/umeng/update/net/DownloadingService$b:d	Ljava/io/File;
      //   1218: aload 44
      //   1220: invokevirtual 544	java/io/File:renameTo	(Ljava/io/File;)Z
      //   1223: pop
      //   1224: aload 44
      //   1226: invokevirtual 421	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   1229: astore 46
      //   1231: aload_0
      //   1232: aload 44
      //   1234: aload 46
      //   1236: invokespecial 546	com/umeng/update/net/DownloadingService$b:a	(Ljava/io/File;Ljava/lang/String;)V
      //   1239: aload_0
      //   1240: getfield 68	com/umeng/update/net/DownloadingService$b:j	Lcom/umeng/update/net/DownloadingService$a;
      //   1243: ifnull -94 -> 1149
      //   1246: aload_0
      //   1247: getfield 68	com/umeng/update/net/DownloadingService$b:j	Lcom/umeng/update/net/DownloadingService$a;
      //   1250: aload_0
      //   1251: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   1254: aload 46
      //   1256: invokeinterface 549 3 0
      //   1261: goto -112 -> 1149
      //   1264: astore 28
      //   1266: aload_0
      //   1267: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   1270: invokestatic 259	com/umeng/update/net/DownloadingService:a	(Lcom/umeng/update/net/DownloadingService;)Lcom/umeng/update/net/c;
      //   1273: aload_0
      //   1274: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   1277: aload_0
      //   1278: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   1281: invokevirtual 264	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
      //   1284: aload 28
      //   1286: invokevirtual 550	android/os/RemoteException:printStackTrace	()V
      //   1289: aload 10
      //   1291: ifnull +8 -> 1299
      //   1294: aload 10
      //   1296: invokevirtual 483	java/io/InputStream:close	()V
      //   1299: aload 9
      //   1301: ifnull -786 -> 515
      //   1304: aload 9
      //   1306: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1309: return
      //   1310: astore 29
      //   1312: aload 29
      //   1314: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1317: return
      //   1318: astore 25
      //   1320: aload 25
      //   1322: invokevirtual 550	android/os/RemoteException:printStackTrace	()V
      //   1325: aload_0
      //   1326: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   1329: invokestatic 259	com/umeng/update/net/DownloadingService:a	(Lcom/umeng/update/net/DownloadingService;)Lcom/umeng/update/net/c;
      //   1332: aload_0
      //   1333: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   1336: aload_0
      //   1337: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   1340: invokevirtual 264	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
      //   1343: aload_0
      //   1344: aload 6
      //   1346: invokespecial 256	com/umeng/update/net/DownloadingService$b:a	(Ljava/lang/Exception;)V
      //   1349: aload_0
      //   1350: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   1353: invokestatic 504	com/umeng/update/net/DownloadingService:d	(Lcom/umeng/update/net/DownloadingService;)Landroid/os/Handler;
      //   1356: new 506	com/umeng/update/net/DownloadingService$b$1
      //   1359: dup
      //   1360: aload_0
      //   1361: invokespecial 509	com/umeng/update/net/DownloadingService$b$1:<init>	(Lcom/umeng/update/net/DownloadingService$b;)V
      //   1364: invokevirtual 515	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1367: pop
      //   1368: goto -621 -> 747
      //   1371: astore 8
      //   1373: aload 5
      //   1375: astore 9
      //   1377: aload 7
      //   1379: astore 10
      //   1381: aload 10
      //   1383: ifnull +8 -> 1391
      //   1386: aload 10
      //   1388: invokevirtual 483	java/io/InputStream:close	()V
      //   1391: aload 9
      //   1393: ifnull +8 -> 1401
      //   1396: aload 9
      //   1398: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1401: aload 8
      //   1403: athrow
      //   1404: astore 23
      //   1406: aload_0
      //   1407: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   1410: invokestatic 259	com/umeng/update/net/DownloadingService:a	(Lcom/umeng/update/net/DownloadingService;)Lcom/umeng/update/net/c;
      //   1413: aload_0
      //   1414: getfield 44	com/umeng/update/net/DownloadingService$b:b	Landroid/content/Context;
      //   1417: aload_0
      //   1418: getfield 70	com/umeng/update/net/DownloadingService$b:i	I
      //   1421: invokevirtual 264	com/umeng/update/net/c:b	(Landroid/content/Context;I)V
      //   1424: aload_0
      //   1425: aload 6
      //   1427: invokespecial 256	com/umeng/update/net/DownloadingService$b:a	(Ljava/lang/Exception;)V
      //   1430: aload_0
      //   1431: getfield 29	com/umeng/update/net/DownloadingService$b:a	Lcom/umeng/update/net/DownloadingService;
      //   1434: invokestatic 504	com/umeng/update/net/DownloadingService:d	(Lcom/umeng/update/net/DownloadingService;)Landroid/os/Handler;
      //   1437: new 506	com/umeng/update/net/DownloadingService$b$1
      //   1440: dup
      //   1441: aload_0
      //   1442: invokespecial 509	com/umeng/update/net/DownloadingService$b$1:<init>	(Lcom/umeng/update/net/DownloadingService$b;)V
      //   1445: invokevirtual 515	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   1448: pop
      //   1449: aload 23
      //   1451: athrow
      //   1452: aload_0
      //   1453: invokespecial 552	com/umeng/update/net/DownloadingService$b:a	()V
      //   1456: goto -709 -> 747
      //   1459: astore 21
      //   1461: aload 21
      //   1463: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1466: aload 5
      //   1468: ifnull -953 -> 515
      //   1471: aload 5
      //   1473: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1476: return
      //   1477: astore 22
      //   1479: aload 22
      //   1481: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1484: return
      //   1485: astore 19
      //   1487: aload 5
      //   1489: ifnull +8 -> 1497
      //   1492: aload 5
      //   1494: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1497: aload 19
      //   1499: athrow
      //   1500: astore 20
      //   1502: aload 20
      //   1504: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1507: goto -10 -> 1497
      //   1510: astore 32
      //   1512: aload 32
      //   1514: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1517: aload 9
      //   1519: ifnull -1004 -> 515
      //   1522: aload 9
      //   1524: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1527: return
      //   1528: astore 33
      //   1530: aload 33
      //   1532: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1535: return
      //   1536: astore 30
      //   1538: aload 9
      //   1540: ifnull +8 -> 1548
      //   1543: aload 9
      //   1545: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1548: aload 30
      //   1550: athrow
      //   1551: astore 31
      //   1553: aload 31
      //   1555: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1558: goto -10 -> 1548
      //   1561: astore 14
      //   1563: aload 14
      //   1565: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1568: aload 9
      //   1570: ifnull -169 -> 1401
      //   1573: aload 9
      //   1575: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1578: goto -177 -> 1401
      //   1581: astore 15
      //   1583: aload 15
      //   1585: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1588: goto -187 -> 1401
      //   1591: astore 12
      //   1593: aload 9
      //   1595: ifnull +8 -> 1603
      //   1598: aload 9
      //   1600: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1603: aload 12
      //   1605: athrow
      //   1606: astore 13
      //   1608: aload 13
      //   1610: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1613: goto -10 -> 1603
      //   1616: astore 11
      //   1618: aload 11
      //   1620: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1623: goto -222 -> 1401
      //   1626: astore 50
      //   1628: aload 50
      //   1630: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1633: aload 9
      //   1635: ifnull -1120 -> 515
      //   1638: aload 9
      //   1640: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1643: return
      //   1644: astore 51
      //   1646: aload 51
      //   1648: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1651: return
      //   1652: astore 48
      //   1654: aload 9
      //   1656: ifnull +8 -> 1664
      //   1659: aload 9
      //   1661: invokevirtual 427	java/io/FileOutputStream:close	()V
      //   1664: aload 48
      //   1666: athrow
      //   1667: astore 49
      //   1669: aload 49
      //   1671: invokevirtual 518	java/io/IOException:printStackTrace	()V
      //   1674: goto -10 -> 1664
      //   1677: astore 8
      //   1679: aconst_null
      //   1680: astore 9
      //   1682: aconst_null
      //   1683: astore 10
      //   1685: goto -304 -> 1381
      //   1688: astore 8
      //   1690: aload_3
      //   1691: astore 9
      //   1693: aconst_null
      //   1694: astore 10
      //   1696: goto -315 -> 1381
      //   1699: astore 8
      //   1701: aload 75
      //   1703: astore 9
      //   1705: aconst_null
      //   1706: astore 10
      //   1708: goto -327 -> 1381
      //   1711: astore 8
      //   1713: aconst_null
      //   1714: astore 10
      //   1716: goto -335 -> 1381
      //   1719: astore 8
      //   1721: goto -340 -> 1381
      //   1724: astore 28
      //   1726: aconst_null
      //   1727: astore 9
      //   1729: aconst_null
      //   1730: astore 10
      //   1732: goto -466 -> 1266
      //   1735: astore 28
      //   1737: aload_3
      //   1738: astore 9
      //   1740: aconst_null
      //   1741: astore 10
      //   1743: goto -477 -> 1266
      //   1746: astore 28
      //   1748: aload 75
      //   1750: astore 9
      //   1752: aconst_null
      //   1753: astore 10
      //   1755: goto -489 -> 1266
      //   1758: astore 28
      //   1760: aconst_null
      //   1761: astore 10
      //   1763: goto -497 -> 1266
      //   1766: astore 77
      //   1768: aload 77
      //   1770: astore 6
      //   1772: aconst_null
      //   1773: astore 5
      //   1775: aconst_null
      //   1776: astore 7
      //   1778: goto -1155 -> 623
      //   1781: astore 4
      //   1783: aload_3
      //   1784: astore 5
      //   1786: aload 4
      //   1788: astore 6
      //   1790: aconst_null
      //   1791: astore 7
      //   1793: goto -1170 -> 623
      //   1796: astore 76
      //   1798: aload 75
      //   1800: astore 5
      //   1802: aload 76
      //   1804: astore 6
      //   1806: aconst_null
      //   1807: astore 7
      //   1809: goto -1186 -> 623
      //   1812: astore 34
      //   1814: aload 34
      //   1816: astore 6
      //   1818: aload 9
      //   1820: astore 5
      //   1822: aconst_null
      //   1823: astore 7
      //   1825: goto -1202 -> 623
      //   1828: aload_3
      //   1829: astore 9
      //   1831: goto -1756 -> 75
      //   1834: iconst_1
      //   1835: istore 43
      //   1837: goto -1409 -> 428
      //
      // Exception table:
      //   from	to	target	type
      //   168	202	609	java/io/IOException
      //   202	327	609	java/io/IOException
      //   327	401	609	java/io/IOException
      //   404	420	609	java/io/IOException
      //   428	495	609	java/io/IOException
      //   516	538	609	java/io/IOException
      //   552	561	609	java/io/IOException
      //   569	609	609	java/io/IOException
      //   776	794	609	java/io/IOException
      //   805	827	609	java/io/IOException
      //   827	859	609	java/io/IOException
      //   925	974	609	java/io/IOException
      //   1059	1149	609	java/io/IOException
      //   1178	1261	609	java/io/IOException
      //   762	767	768	java/io/IOException
      //   500	505	866	java/io/IOException
      //   878	883	884	java/io/IOException
      //   500	505	892	finally
      //   868	873	892	finally
      //   899	904	907	java/io/IOException
      //   510	515	917	java/io/IOException
      //   989	994	995	java/io/IOException
      //   979	984	1003	java/io/IOException
      //   1015	1020	1021	java/io/IOException
      //   979	984	1029	finally
      //   1005	1010	1029	finally
      //   1036	1041	1044	java/io/IOException
      //   1164	1169	1170	java/io/IOException
      //   168	202	1264	android/os/RemoteException
      //   202	327	1264	android/os/RemoteException
      //   327	401	1264	android/os/RemoteException
      //   404	420	1264	android/os/RemoteException
      //   428	495	1264	android/os/RemoteException
      //   516	538	1264	android/os/RemoteException
      //   552	561	1264	android/os/RemoteException
      //   569	609	1264	android/os/RemoteException
      //   776	794	1264	android/os/RemoteException
      //   805	827	1264	android/os/RemoteException
      //   827	859	1264	android/os/RemoteException
      //   925	974	1264	android/os/RemoteException
      //   1059	1149	1264	android/os/RemoteException
      //   1178	1261	1264	android/os/RemoteException
      //   1304	1309	1310	java/io/IOException
      //   670	704	1318	android/os/RemoteException
      //   623	650	1371	finally
      //   656	665	1371	finally
      //   704	747	1371	finally
      //   1325	1368	1371	finally
      //   1406	1452	1371	finally
      //   1452	1456	1371	finally
      //   670	704	1404	finally
      //   1320	1325	1404	finally
      //   752	757	1459	java/io/IOException
      //   1471	1476	1477	java/io/IOException
      //   752	757	1485	finally
      //   1461	1466	1485	finally
      //   1492	1497	1500	java/io/IOException
      //   1294	1299	1510	java/io/IOException
      //   1522	1527	1528	java/io/IOException
      //   1294	1299	1536	finally
      //   1512	1517	1536	finally
      //   1543	1548	1551	java/io/IOException
      //   1386	1391	1561	java/io/IOException
      //   1573	1578	1581	java/io/IOException
      //   1386	1391	1591	finally
      //   1563	1568	1591	finally
      //   1598	1603	1606	java/io/IOException
      //   1396	1401	1616	java/io/IOException
      //   1154	1159	1626	java/io/IOException
      //   1638	1643	1644	java/io/IOException
      //   1154	1159	1652	finally
      //   1628	1633	1652	finally
      //   1659	1664	1667	java/io/IOException
      //   8	21	1677	finally
      //   21	59	1688	finally
      //   59	71	1699	finally
      //   75	157	1711	finally
      //   168	202	1719	finally
      //   202	327	1719	finally
      //   327	401	1719	finally
      //   404	420	1719	finally
      //   428	495	1719	finally
      //   516	538	1719	finally
      //   552	561	1719	finally
      //   569	609	1719	finally
      //   776	794	1719	finally
      //   805	827	1719	finally
      //   827	859	1719	finally
      //   925	974	1719	finally
      //   1059	1149	1719	finally
      //   1178	1261	1719	finally
      //   1266	1289	1719	finally
      //   8	21	1724	android/os/RemoteException
      //   21	59	1735	android/os/RemoteException
      //   59	71	1746	android/os/RemoteException
      //   75	157	1758	android/os/RemoteException
      //   8	21	1766	java/io/IOException
      //   21	59	1781	java/io/IOException
      //   59	71	1796	java/io/IOException
      //   75	157	1812	java/io/IOException
    }

    private void b()
    {
      if (this.k.f != null)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("dsize", String.valueOf(this.g));
        localHashMap.put("dtime", n.a().split(" ")[1]);
        localHashMap.put("ptimes", String.valueOf(this.e));
        DownloadingService.a(DownloadingService.this).a(localHashMap, true, this.k.f);
      }
    }

    private void b(int paramInt)
      throws RemoteException
    {
      try
      {
        if (DownloadingService.c().get(this.k) != null)
          ((Messenger)DownloadingService.c().get(this.k)).send(Message.obtain(null, 3, paramInt, 0));
        return;
      }
      catch (DeadObjectException localDeadObjectException)
      {
        String str = DownloadingService.a();
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.k.b;
        u.upd.b.b(str, String.format("Service Client for downloading %1$15s is dead. Removing messenger from the service", arrayOfObject));
        DownloadingService.c().put(this.k, null);
      }
    }

    public void a(int paramInt)
    {
      this.h = paramInt;
    }

    public void run()
    {
      this.e = 0;
      try
      {
        if (this.j != null)
          this.j.a(this.i);
        boolean bool1 = this.f < 0L;
        boolean bool2 = false;
        if (bool1)
          bool2 = true;
        a(bool2);
        if (DownloadingService.c().size() <= 0)
          DownloadingService.this.stopSelf();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }

  class c extends Handler
  {
    c()
    {
    }

    public void handleMessage(Message paramMessage)
    {
      u.upd.b.c(DownloadingService.a(), "IncomingHandler(msg.what:" + paramMessage.what + " msg.arg1:" + paramMessage.arg1 + " msg.arg2:" + paramMessage.arg2 + " msg.replyTo:" + paramMessage.replyTo);
      switch (paramMessage.what)
      {
      default:
        super.handleMessage(paramMessage);
        return;
      case 4:
      }
      Bundle localBundle = paramMessage.getData();
      u.upd.b.c(DownloadingService.a(), "IncomingHandler(msg.getData():" + localBundle);
      a.a locala = a.a.a(localBundle);
      if (DownloadingService.a(DownloadingService.this).a(locala, DownloadingService.r, paramMessage.replyTo))
      {
        u.upd.b.a(DownloadingService.a(), locala.b + " is already in downloading list. ");
        int i = DownloadingService.a(DownloadingService.this).b(locala);
        if ((i != -1) && (((c.b)DownloadingService.b().get(i)).a == null))
        {
          String str = f.a(i, "continue");
          Intent localIntent = new Intent(DownloadingService.b(DownloadingService.this), DownloadingService.class);
          localIntent.putExtra("com.umeng.broadcast.download.msg", str);
          DownloadingService.a(DownloadingService.this).a(DownloadingService.this, localIntent);
          return;
        }
        Toast.makeText(DownloadingService.b(DownloadingService.this), l.b(DownloadingService.b(DownloadingService.this)), 0).show();
        Message localMessage3 = Message.obtain();
        localMessage3.what = 2;
        localMessage3.arg1 = 2;
        localMessage3.arg2 = 0;
        try
        {
          paramMessage.replyTo.send(localMessage3);
          return;
        }
        catch (RemoteException localRemoteException3)
        {
          localRemoteException3.printStackTrace();
          return;
        }
      }
      if (a.l(DownloadingService.this.getApplicationContext()))
      {
        DownloadingService.c().put(locala, paramMessage.replyTo);
        Message localMessage2 = Message.obtain();
        localMessage2.what = 1;
        localMessage2.arg1 = 1;
        localMessage2.arg2 = 0;
        try
        {
          paramMessage.replyTo.send(localMessage2);
          DownloadingService.a(DownloadingService.this, locala);
          return;
        }
        catch (RemoteException localRemoteException2)
        {
          while (true)
            localRemoteException2.printStackTrace();
        }
      }
      Toast.makeText(DownloadingService.b(DownloadingService.this), l.a(DownloadingService.b(DownloadingService.this)), 0).show();
      Message localMessage1 = Message.obtain();
      localMessage1.what = 2;
      localMessage1.arg1 = 4;
      localMessage1.arg2 = 0;
      try
      {
        paramMessage.replyTo.send(localMessage1);
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        localRemoteException1.printStackTrace();
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.net.DownloadingService
 * JD-Core Version:    0.6.2
 */