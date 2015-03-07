package u.aly;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.ReportPolicy.a;
import com.umeng.analytics.ReportPolicy.b;
import com.umeng.analytics.ReportPolicy.c;
import com.umeng.analytics.ReportPolicy.d;
import com.umeng.analytics.ReportPolicy.e;
import com.umeng.analytics.ReportPolicy.f;
import com.umeng.analytics.g;

public final class j
  implements com.umeng.analytics.onlineconfig.c, o
{
  private q a = null;
  private r b = null;
  private ReportPolicy.e c = null;
  private g d = null;
  private w e = null;
  private d f = null;
  private int g = 10;
  private Context h;

  public j(Context paramContext)
  {
    this.h = paramContext;
    this.a = new q(paramContext);
    this.f = h.a(paramContext);
    this.e = new w(paramContext);
    this.b = new r(paramContext);
    this.b.a(this.e);
    this.d = g.a(paramContext);
    int[] arrayOfInt = AnalyticsConfig.getReportPolicy(this.h);
    a(arrayOfInt[0], arrayOfInt[1]);
  }

  private bf a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    try
    {
      bf localbf = new bf();
      new cc().a(localbf, paramArrayOfByte);
      return localbf;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 2:
    case 3:
    default:
      this.c = new ReportPolicy.a();
    case 1:
    case 6:
    case 4:
    case 0:
    case 5:
    case 7:
    }
    while (true)
    {
      bj.c("MobclickAgent", "report policy:" + paramInt1 + " interval:" + paramInt2);
      return;
      this.c = new ReportPolicy.a();
      continue;
      this.c = new ReportPolicy.b(this.e, paramInt2);
      continue;
      this.c = new ReportPolicy.d(this.e);
      continue;
      this.c = new ReportPolicy.e();
      continue;
      this.c = new ReportPolicy.f(this.h);
      continue;
      this.c = new ReportPolicy.c(this.a, paramInt2);
    }
  }

  private boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    if (!bi.l(this.h))
    {
      if (bj.a)
        bj.c("MobclickAgent", "network is unavailable");
      bool = false;
    }
    while ((this.e.b()) || ((bj.a) && (bi.w(this.h))))
      return bool;
    return this.c.a(paramBoolean);
  }

  private byte[] a(bf parambf)
  {
    try
    {
      byte[] arrayOfByte = new ci().a(parambf);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private boolean d()
  {
    return this.a.b() > this.g;
  }

  private void e()
  {
    try
    {
      if (this.e.b())
        this.a.a(new ah(this.e.j()));
      f();
      return;
    }
    catch (Throwable localThrowable)
    {
      do
        (localThrowable instanceof OutOfMemoryError);
      while (localThrowable == null);
      localThrowable.printStackTrace();
    }
  }

  private void f()
  {
    g localg = g.a(this.h);
    boolean bool = localg.f();
    byte[] arrayOfByte2;
    if (bool)
      arrayOfByte2 = localg.d();
    switch (this.b.a(arrayOfByte2))
    {
    default:
    case 2:
    case 3:
      do
      {
        do
        {
          return;
          this.f.a();
          byte[] arrayOfByte1 = c();
          if (arrayOfByte1 == null)
          {
            bj.e("MobclickAgent", "message is null");
            return;
          }
          arrayOfByte2 = c.a(this.h, AnalyticsConfig.getAppkey(this.h), arrayOfByte1).c();
          localg.c();
          break;
          if (this.e.i())
            this.e.h();
          this.f.d();
          this.e.g();
        }
        while (!bool);
        localg.e();
        return;
        this.e.g();
      }
      while (!bool);
      localg.e();
      return;
    case 1:
    }
    if (!bool)
      localg.b(arrayOfByte2);
    bj.b("MobclickAgent", "connection error");
  }

  public void a()
  {
    if (bi.l(this.h))
      e();
    while (!bj.a)
      return;
    bj.c("MobclickAgent", "network is unavailable");
  }

  public void a(int paramInt, long paramLong)
  {
    AnalyticsConfig.setReportPolicy(paramInt, (int)paramLong);
    a(paramInt, (int)paramLong);
  }

  public void a(p paramp)
  {
    if (paramp != null)
      this.a.a(paramp);
    if (a(paramp instanceof bd))
      e();
    while (!d())
      return;
    b();
  }

  public void b()
  {
    if (this.a.b() > 0);
    try
    {
      byte[] arrayOfByte = c();
      if (arrayOfByte != null)
        this.d.a(arrayOfByte);
      return;
    }
    catch (Throwable localThrowable)
    {
      do
        if ((localThrowable instanceof OutOfMemoryError))
          this.d.c();
      while (localThrowable == null);
      localThrowable.printStackTrace();
    }
  }

  public void b(p paramp)
  {
    this.a.a(paramp);
  }

  // ERROR //
  protected byte[] c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	u/aly/j:h	Landroid/content/Context;
    //   4: invokestatic 213	com/umeng/analytics/AnalyticsConfig:getAppkey	(Landroid/content/Context;)Ljava/lang/String;
    //   7: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +13 -> 23
    //   13: ldc 97
    //   15: ldc_w 264
    //   18: invokestatic 239	u/aly/bj:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aconst_null
    //   22: areturn
    //   23: aload_0
    //   24: getfield 45	u/aly/j:h	Landroid/content/Context;
    //   27: invokestatic 68	com/umeng/analytics/g:a	(Landroid/content/Context;)Lcom/umeng/analytics/g;
    //   30: invokevirtual 266	com/umeng/analytics/g:b	()[B
    //   33: astore_2
    //   34: aload_2
    //   35: ifnonnull +21 -> 56
    //   38: aconst_null
    //   39: astore_3
    //   40: aload_3
    //   41: ifnonnull +24 -> 65
    //   44: aload_0
    //   45: getfield 31	u/aly/j:a	Lu/aly/q;
    //   48: invokevirtual 172	u/aly/q:b	()I
    //   51: ifne +14 -> 65
    //   54: aconst_null
    //   55: areturn
    //   56: aload_0
    //   57: aload_2
    //   58: invokespecial 268	u/aly/j:a	([B)Lu/aly/bf;
    //   61: astore_3
    //   62: goto -22 -> 40
    //   65: aload_3
    //   66: ifnonnull +173 -> 239
    //   69: new 82	u/aly/bf
    //   72: dup
    //   73: invokespecial 83	u/aly/bf:<init>	()V
    //   76: astore 4
    //   78: aload_0
    //   79: getfield 31	u/aly/j:a	Lu/aly/q;
    //   82: aload 4
    //   84: invokevirtual 271	u/aly/q:a	(Lu/aly/bf;)V
    //   87: getstatic 152	u/aly/bj:a	Z
    //   90: ifeq +49 -> 139
    //   93: aload 4
    //   95: invokevirtual 274	u/aly/bf:B	()Z
    //   98: ifeq +41 -> 139
    //   101: aload 4
    //   103: invokevirtual 278	u/aly/bf:z	()Ljava/util/List;
    //   106: invokeinterface 284 1 0
    //   111: astore 9
    //   113: iconst_0
    //   114: istore 10
    //   116: aload 9
    //   118: invokeinterface 289 1 0
    //   123: ifne +82 -> 205
    //   126: iload 10
    //   128: ifne +11 -> 139
    //   131: ldc 97
    //   133: ldc_w 291
    //   136: invokestatic 209	u/aly/bj:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: aload 4
    //   142: invokespecial 293	u/aly/j:a	(Lu/aly/bf;)[B
    //   145: astore 7
    //   147: aload 7
    //   149: astore 6
    //   151: getstatic 152	u/aly/bj:a	Z
    //   154: ifeq +91 -> 245
    //   157: ldc 97
    //   159: aload 4
    //   161: invokevirtual 294	u/aly/bf:toString	()Ljava/lang/String;
    //   164: invokestatic 122	u/aly/bj:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload 6
    //   169: areturn
    //   170: astore 8
    //   172: ldc 97
    //   174: ldc_w 296
    //   177: invokestatic 239	u/aly/bj:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 6
    //   182: areturn
    //   183: astore_1
    //   184: ldc 97
    //   186: ldc_w 298
    //   189: aload_1
    //   190: invokestatic 301	u/aly/bj:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   193: aload_0
    //   194: getfield 45	u/aly/j:h	Landroid/content/Context;
    //   197: invokestatic 68	com/umeng/analytics/g:a	(Landroid/content/Context;)Lcom/umeng/analytics/g;
    //   200: invokevirtual 221	com/umeng/analytics/g:c	()V
    //   203: aconst_null
    //   204: areturn
    //   205: aload 9
    //   207: invokeinterface 305 1 0
    //   212: checkcast 249	u/aly/bd
    //   215: invokevirtual 308	u/aly/bd:p	()I
    //   218: istore 11
    //   220: iload 11
    //   222: ifle -106 -> 116
    //   225: iconst_1
    //   226: istore 10
    //   228: goto -112 -> 116
    //   231: astore 5
    //   233: aconst_null
    //   234: astore 6
    //   236: goto -64 -> 172
    //   239: aload_3
    //   240: astore 4
    //   242: goto -164 -> 78
    //   245: aload 6
    //   247: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   151	167	170	java/lang/Exception
    //   0	21	183	java/lang/Exception
    //   23	34	183	java/lang/Exception
    //   44	54	183	java/lang/Exception
    //   56	62	183	java/lang/Exception
    //   69	78	183	java/lang/Exception
    //   78	113	183	java/lang/Exception
    //   116	126	183	java/lang/Exception
    //   131	139	183	java/lang/Exception
    //   172	180	183	java/lang/Exception
    //   205	220	183	java/lang/Exception
    //   139	147	231	java/lang/Exception
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.j
 * JD-Core Version:    0.6.2
 */