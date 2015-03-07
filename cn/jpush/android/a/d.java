package cn.jpush.android.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.telephony.CellLocation;
import cn.jpush.android.service.PushService;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import java.util.Date;
import org.json.JSONArray;

public abstract class d
{
  private static final String[] A;
  public static int b;
  public static boolean c;
  private static boolean f;
  public String a;
  protected boolean d;
  private boolean e = false;
  private int g;
  private b h;
  private g i;
  private Context j;
  private int[] k;
  private f l;
  private boolean m;
  private final BroadcastReceiver n = new e(this, (byte)0);
  private long o;
  private int p;
  private boolean q = false;
  private boolean r;
  private i s;
  private int t;
  private final Date u = new Date();
  private JSONArray v;
  private boolean w;
  private boolean x = false;
  private String y;
  private JSONArray z;

  static
  {
    Object localObject1 = new String[7];
    int i1 = 0;
    String str1 = "\027c\007}/\037iMa%\002#\024f&\037#0L\0018R1J\023#A7\\";
    int i2 = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int i3 = localObject3.length;
    int i4 = 0;
    label36: Object localObject4;
    int i5;
    int i6;
    Object localObject5;
    label52: int i7;
    int i8;
    if (i3 <= 1)
    {
      localObject4 = localObject3;
      i5 = i4;
      i6 = i3;
      localObject5 = localObject3;
      i7 = localObject5[i4];
      switch (i5 % 5)
      {
      default:
        i8 = 64;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i4] = ((char)(i8 ^ i7));
      i4 = i5 + 1;
      if (i6 == 0)
      {
        localObject5 = localObject4;
        i5 = i4;
        i4 = i6;
        break label52;
      }
      i3 = i6;
      localObject3 = localObject4;
      if (i3 > i4)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (i2)
      {
      default:
        localObject1[i1] = str2;
        i1 = 1;
        str1 = "\027c\007}/\037iMa%\002#\024f&\037#4F\006?R0[\001\"H<L\b7C$J\004";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "\027c\007}/\037iM%\004`\n|3\037b\r!\0015N&\\\023)Z*I\t)^7N\0243";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "\027c\007}/\037iM%\004`\n|3\037b\r!\0015N&\\\023)K*A\005)A,L\001\"D,A";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "\027c\007}/\037iM%\004`\n|3\037b\r!\003>L-H\005)Z*I\t)^7N\0243";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "\027c\007}/\037iM%\004`\n|3\037b\r!\0015N&\\\023)N,N\022%H<C\0175L7F\0178";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "\027a\017";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        A = localObject2;
        b = 15000;
        c = true;
        f = false;
        return;
        i8 = 118;
        continue;
        i8 = 13;
        continue;
        i8 = 99;
        continue;
        i8 = 15;
      }
    }
  }

  private d(Context paramContext)
  {
    this.j = paramContext.getApplicationContext();
    this.h = new b(paramContext);
    this.s = new i(paramContext);
    this.i = new g(paramContext);
  }

  private d(Context paramContext, String paramString)
  {
    this(paramContext);
    if ((paramString == null) || ("".equals(paramString)))
    {
      this.a = A[6];
      return;
    }
    this.a = paramString;
  }

  private d(Context paramContext, String paramString, boolean paramBoolean)
  {
    this(paramContext, paramString);
    this.x = paramBoolean;
  }

  public d(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramString, paramBoolean1);
    this.e = paramBoolean2;
  }

  public static boolean a(Context paramContext)
  {
    return (a.c(paramContext, A[5])) && (a.c(paramContext, A[2])) && (a.c(paramContext, A[4])) && (a.c(paramContext, A[3]));
  }

  public final String a()
  {
    String str = this.i.d();
    if (str == null)
      str = "";
    return str;
  }

  public final void a(JSONArray paramJSONArray)
  {
    this.v = paramJSONArray;
  }

  public final JSONArray b()
  {
    if (!a.c(this.j, A[5]))
      return null;
    if (this.h.e())
      return this.h.b();
    return this.v;
  }

  public final void b(JSONArray paramJSONArray)
  {
    this.z = paramJSONArray;
  }

  public final JSONArray c()
  {
    if (this.z != null)
      return this.z;
    return null;
  }

  public abstract void d();

  public final void e()
  {
    if (this.p != 1)
      return;
    CellLocation.requestLocationUpdate();
    this.p = 2;
    this.l.sendEmptyMessage(1);
    if (this.s.b().isWifiEnabled())
    {
      this.s.b().startScan();
      this.r = false;
      return;
    }
    if (!this.e)
    {
      this.l.sendEmptyMessageDelayed(5, 0L);
      return;
    }
    this.o = System.currentTimeMillis();
    if ((!c) || (!this.s.b().setWifiEnabled(true)))
    {
      this.l.sendEmptyMessageDelayed(5, 8000L);
      return;
    }
    this.r = true;
  }

  public final void f()
  {
    if (PushService.z);
    label70: label88: label349: 
    while (true)
    {
      return;
      PushService.z = true;
      this.e = false;
      this.x = false;
      if (a.c(this.j, A[5]))
      {
        this.v = this.h.c();
        if (a.c(this.j, A[2]))
          break label124;
        x.f();
        this.z = null;
        if (a.c(this.j, A[3]))
          break label275;
        x.f();
      }
      for (this.y = ""; ; this.y = this.i.d())
      {
        label124: 
        do
        {
          if ((this.q) || (this.x))
            break label349;
          d();
          return;
          x.f();
          this.v = null;
          break;
          this.w = this.s.a();
          if (!this.s.a())
          {
            if (!this.e)
            {
              this.z = null;
              break label70;
            }
            if (!a.c(this.j, A[4]))
            {
              x.f();
              this.z = null;
              break label70;
            }
            if (this.x)
              break label70;
            this.j.registerReceiver(this.n, new IntentFilter(A[0]));
            this.j.registerReceiver(this.n, new IntentFilter(A[1]));
            this.s.b().setWifiEnabled(true);
            this.q = true;
            break label70;
          }
          this.z = this.s.c();
          break label70;
          if (!this.i.a())
            break label88;
          this.i.b();
        }
        while (("" == this.i.d()) || (this.i.d() == null) || (System.currentTimeMillis() - this.i.e() >= 30000L));
        this.t = 0;
      }
    }
  }

  public final void g()
  {
    PushService.z = false;
    if ((a.c(this.j, A[3])) && (this.i.a()))
      this.i.c();
    if ((!this.w) && (a.c(this.j, A[4])))
      this.s.b().setWifiEnabled(false);
    if ((this.p > 0) && (a(this.j)))
    {
      this.j.unregisterReceiver(this.n);
      this.l = null;
      this.p = 0;
      if (!this.w)
      {
        this.d = false;
        this.s.b().setWifiEnabled(false);
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.d
 * JD-Core Version:    0.6.2
 */