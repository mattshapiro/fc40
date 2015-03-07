package cn.jpush.android.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.RemoteViews;
import cn.jpush.android.api.m;
import cn.jpush.android.data.l;
import cn.jpush.android.data.p;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DownloadService extends IntentService
{
  public static ConcurrentLinkedQueue<cn.jpush.android.data.d> a;
  private static Bundle b;
  private static final String[] z;
  private NotificationManager c;
  private cn.jpush.android.data.d d;
  private f e;
  private Notification f;
  private RemoteViews g;
  private Integer h = Integer.valueOf(0);
  private Integer i = Integer.valueOf(0);
  private Integer j = Integer.valueOf(0);
  private Integer k = Integer.valueOf(0);
  private Integer l = Integer.valueOf(0);
  private Handler m = new e(this);

  static
  {
    Object localObject1 = new String[22];
    int n = 0;
    String str1 = "曒斏爌朜嶽中轂寈毥ｃ译炆冿容袊〤";
    int i1 = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int i2 = localObject3.length;
    int i3 = 0;
    label36: Object localObject4;
    int i4;
    int i5;
    Object localObject5;
    label52: int i6;
    int i7;
    if (i2 <= 1)
    {
      localObject4 = localObject3;
      i4 = i3;
      i5 = i2;
      localObject5 = localObject3;
      i6 = localObject5[i3];
      switch (i4 % 5)
      {
      default:
        i7 = 79;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i3] = ((char)(i7 ^ i6));
      i3 = i4 + 1;
      if (i5 == 0)
      {
        localObject5 = localObject4;
        i4 = i3;
        i3 = i5;
        break label52;
      }
      i2 = i5;
      localObject3 = localObject4;
      if (i2 > i3)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (i1)
      {
      default:
        localObject1[n] = str2;
        n = 1;
        str1 = "";
        localObject1 = localObject2;
        i1 = 0;
        break;
      case 0:
        localObject1[n] = str2;
        n = 2;
        str1 = "DP I";
        i1 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[n] = str2;
        n = 3;
        str1 = "宯裺十巂乄轛害殑＼许炟凄寍裵き";
        i1 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[n] = str2;
        n = 4;
        str1 = "bP3^#I^ c*TI-S*";
        i1 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[n] = str2;
        n = 5;
        str1 = "彵割缕绬乂叉甗う稽呁似绘纩主輲Ｇ";
        i1 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[n] = str2;
        n = 6;
        str1 = "中轂贀溠奾敮〽讳稽呁炟凄醉斀乄轛＾";
        i1 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[n] = str2;
        n = 7;
        str1 = "中轂奵贕き译稲告炉冴釫斏乏轍ｎ";
        i1 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[n] = str2;
        n = 8;
        str1 = "中轂乩\036a\b\037";
        i1 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[n] = str2;
        n = 9;
        str1 = "HP0o.SK+B:H";
        i1 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[n] = str2;
        n = 10;
        str1 = "hPdU!B\037*_;OY-S.RV+^a\006V7\020)OS!`.RWdU\"VK=\020p\006\022d";
        i1 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[n] = str2;
        n = 11;
        str1 = "KP1^;C[";
        i1 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[n] = str2;
        n = 12;
        str1 = "uK%B;OQ#\020;I\037 _8HS+Q+\006\022d]*UL%W*o[~";
        i1 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[n] = str2;
        n = 13;
        str1 = "cG!S:RZd_#B\037 _8HS+Q+\006K%C$\006\022dC&\\Z~";
        i1 = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[n] = str2;
        n = 14;
        str1 = "VM+W=CL7o-GM";
        i1 = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[n] = str2;
        n = 15;
        str1 = "RV0\\*";
        i1 = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[n] = str2;
        n = 16;
        str1 = "O\\+^";
        i1 = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[n] = str2;
        n = 17;
        str1 = "t\033-T";
        i1 = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[n] = str2;
        n = 18;
        str1 = "t\033(Q6IJ0";
        i1 = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[n] = str2;
        n = 19;
        str1 = "RZ<D\020VM+W=CL7";
        i1 = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[n] = str2;
        n = 20;
        str1 = "HP0Y)O\\%D&IQ\033\\._P1D";
        i1 = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[n] = str2;
        n = 21;
        str1 = "HP0Y)O\\%D&IQ";
        i1 = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[n] = str2;
        z = localObject2;
        a = new ConcurrentLinkedQueue();
        return;
        i7 = 38;
        continue;
        i7 = 63;
        continue;
        i7 = 68;
        continue;
        i7 = 48;
      }
    }
  }

  public DownloadService()
  {
    super(z[4]);
  }

  public static void a(Context paramContext)
  {
    int n = a.size();
    new StringBuilder(z[13]).append(n).toString();
    x.c();
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      cn.jpush.android.data.d locald1 = (cn.jpush.android.data.d)a.poll();
      if (locald1 == null)
        break;
      if (locald1.M)
      {
        new StringBuilder(z[12]).append(locald1.c).toString();
        x.c();
        ServiceInterface.a(paramContext, locald1);
      }
      else
      {
        x.b();
        localArrayList.add(locald1);
      }
    }
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      cn.jpush.android.data.d locald2 = (cn.jpush.android.data.d)localIterator.next();
      a.offer(locald2);
    }
  }

  private void a(cn.jpush.android.data.d paramd, int paramInt, long paramLong1, long paramLong2)
  {
    if (this.f == null)
    {
      this.f = new Notification();
      this.f.icon = 17301633;
      this.f.when = System.currentTimeMillis();
      this.f.flags = 2;
      this.f.defaults = 4;
      Intent localIntent2 = new Intent();
      PendingIntent localPendingIntent2 = PendingIntent.getActivity(getApplicationContext(), paramInt, localIntent2, 134217728);
      this.f.contentIntent = localPendingIntent2;
    }
    String str1 = paramd.A;
    String str2 = z[8];
    int n = (int)(100.0F * ((float)paramLong1 / (float)paramLong2));
    if (paramLong2 > 0L)
      str2 = str2 + n + "%";
    if ((this.l != null) && (this.l.intValue() > 0))
    {
      if (this.g == null)
      {
        this.g = new RemoteViews(getPackageName(), this.l.intValue());
        this.g.setTextViewText(this.h.intValue(), str1);
        this.g.setImageViewResource(this.j.intValue(), cn.jpush.android.a.a);
      }
      this.g.setTextViewText(this.k.intValue(), n + "%");
      this.g.setProgressBar(this.i.intValue(), 100, n, false);
      this.f.contentView = this.g;
    }
    while (true)
    {
      this.c.notify(paramInt, this.f);
      return;
      Intent localIntent1 = new Intent();
      PendingIntent localPendingIntent1 = PendingIntent.getActivity(getApplicationContext(), paramInt, localIntent1, 134217728);
      this.f.setLatestEventInfo(this, str1, str2, localPendingIntent1);
    }
  }

  private void a(cn.jpush.android.data.d paramd, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2 = paramd.c();
    Intent localIntent;
    if ((paramd.a()) && (!paramBoolean))
    {
      localIntent = new Intent();
      localIntent.putExtra(z[2], paramd);
      localIntent.setClass(getApplicationContext(), PushReceiver.class);
      localIntent.setAction(z[bool1]);
      if (paramd.c())
        paramd.B = z[0];
    }
    while (true)
    {
      int n = m.a(paramd, 0);
      Notification localNotification = m.a(getApplicationContext(), n, localIntent, paramd, bool2, bool1);
      if (localNotification == null)
        break;
      this.c.notify(n, localNotification);
      return;
      paramd.B = z[3];
      continue;
      localIntent = cn.jpush.android.util.a.a(getApplicationContext(), paramd, false);
      bool1 = false;
    }
    x.f();
  }

  public static boolean a()
  {
    return a.size() > 0;
  }

  public void onCreate()
  {
    x.c();
    super.onCreate();
    this.e = new f(this, getApplicationContext());
    this.c = ((NotificationManager)getSystemService(z[21]));
    if (b == null)
      b = new Bundle();
    try
    {
      if (this.l.intValue() == 0)
      {
        String str1 = z[18];
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = z[20];
        HashMap localHashMap1 = m.a(str1, arrayOfString1);
        if (localHashMap1.size() > 0)
          this.l = ((Integer)localHashMap1.get(z[20]));
        String str2 = z[17];
        String[] arrayOfString2 = new String[4];
        arrayOfString2[0] = z[15];
        arrayOfString2[1] = z[14];
        arrayOfString2[2] = z[16];
        arrayOfString2[3] = z[19];
        HashMap localHashMap2 = m.a(str2, arrayOfString2);
        if (localHashMap2.size() > 0)
        {
          this.h = ((Integer)localHashMap2.get(z[15]));
          this.i = ((Integer)localHashMap2.get(z[14]));
          this.j = ((Integer)localHashMap2.get(z[16]));
          this.k = ((Integer)localHashMap2.get(z[19]));
        }
      }
      return;
    }
    catch (Exception localException)
    {
      x.i();
    }
  }

  public void onDestroy()
  {
    x.c();
    super.onDestroy();
  }

  protected void onHandleIntent(Intent paramIntent)
  {
    x.c();
    this.d = ((cn.jpush.android.data.d)paramIntent.getSerializableExtra(z[2]));
    if (this.d == null)
    {
      x.e();
      return;
    }
    if (!Environment.getExternalStorageState().equals(z[11]))
    {
      x.e();
      this.e.sendEmptyMessage(0);
      return;
    }
    if (this.d.N)
    {
      x.c();
      return;
    }
    if (this.d.L)
      ServiceInterface.a(this.d.c, 1012, this);
    if (!a.contains(this.d))
      a.offer(this.d);
    int n = m.a(this.d, 1);
    cn.jpush.android.data.d locald = this.d;
    boolean bool;
    if (locald.f())
    {
      bool = true;
      Thread.currentThread().setPriority(1);
      new a(this, this.d, b, new d(this, bool, n), 3000);
      return;
    }
    int i1;
    if (locald.a())
    {
      l locall = (l)locald;
      if (!p.a(locall.Y, locall.Z, this))
      {
        a(locald, n, 0L, 0L);
        i1 = 0;
      }
    }
    while (true)
    {
      if ((i1 != 0) || (locald.b()))
      {
        bool = true;
        break;
        i1 = 1;
        continue;
      }
      bool = false;
      break;
      i1 = 0;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.DownloadService
 * JD-Core Version:    0.6.2
 */