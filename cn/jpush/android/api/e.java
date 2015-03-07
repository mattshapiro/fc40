package cn.jpush.android.api;

import android.app.Activity;
import android.app.Application;
import android.app.TabActivity;
import android.content.Context;
import cn.jpush.android.service.PushService;
import cn.jpush.android.util.ac;
import cn.jpush.android.util.af;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class e
{
  public static boolean a;
  public static boolean b;
  private static final String c;
  private static e e;
  private static final String[] z;
  private ExecutorService d = Executors.newSingleThreadExecutor();
  private String f = null;
  private String g = null;
  private ArrayList<a> h = new ArrayList();
  private long i = 30L;
  private long j = 0L;
  private long k = 0L;
  private boolean l = false;
  private boolean m = true;
  private boolean n = true;
  private boolean o = false;
  private boolean p = true;
  private WeakReference<JSONObject> q = null;
  private JSONObject r = null;
  private Object s = new Object();

  static
  {
    Object localObject1 = new String[23];
    int i1 = 0;
    String str1 = "H\t1}oT\002\035gb";
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
        i8 = 6;
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
        str1 = "Z\0176gp^36ktV\005,or^";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "R\030+cc";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "W\r1zYK\r7}c";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "Q\0347}nd\0376ord\017#mn^B(}iU";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "O\0252k";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "x\003,zcC\030b}nT\031.j&Y\tboh\033-!zoM\0056w&T\002bznR\037bccO\004-j&\001L";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        i1 = 7;
        str1 = "q<7}nh-lahi\t1{k^D\001ahO\t:z/\033\0017}r\033\016'.oU\032-ec_L+`&z\0176gpR\030; iU>'}sV\tj'";
        i2 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i1] = str2;
        i1 = 8;
        str1 = "";
        i2 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i1] = str2;
        i1 = 9;
        str1 = "N\030$#>";
        i2 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i1] = str2;
        i1 = 10;
        str1 = "_\0310orR\003,";
        i2 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i1] = str2;
        i1 = 11;
        str1 = "X\0310Qu^\0371giU31zgI\030";
        i2 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i1] = str2;
        i1 = 12;
        str1 = "Z\0176gpR\030+ku";
        i2 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i1] = str2;
        i1 = 13;
        str1 = "X\0310Qu^\t1giU3'`b";
        i2 = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i1] = str2;
        i1 = 14;
        str1 = "T\002\020kuN\001'";
        i2 = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i1] = str2;
        i1 = 15;
        str1 = "";
        i2 = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i1] = str2;
        i1 = 16;
        str1 = "K\r%k&U\r/k&_\005&`!OL/orX\004bzn^L.ouOL-`c\033\034#}u^\bbl\033\003,\\cH\031/k";
        i2 = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i1] = str2;
        i1 = 17;
        str1 = "";
        i2 = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i1] = str2;
        i1 = 18;
        str1 = "_\r6k";
        i2 = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i1] = str2;
        i1 = 19;
        str1 = "O\005/k";
        i2 = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i1] = str2;
        i1 = 20;
        str1 = "Z\0176gp^3.osU\017*";
        i2 = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i1] = str2;
        i1 = 21;
        str1 = "";
        i2 = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i1] = str2;
        i1 = 22;
        str1 = "T\002\022osH\t";
        i2 = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i1] = str2;
        z = localObject2;
        c = e.class.getSimpleName();
        e = null;
        a = false;
        b = false;
        return;
        i8 = 59;
        continue;
        i8 = 108;
        continue;
        i8 = 66;
        continue;
        i8 = 14;
      }
    }
  }

  private JSONObject a(Context paramContext, long paramLong)
  {
    af.a().b(paramContext, z[11], this.j);
    StringBuilder localStringBuilder = new StringBuilder();
    String str1 = cn.jpush.android.util.a.v(paramContext);
    if (!ai.a(str1))
      localStringBuilder.append(str1);
    String str2 = cn.jpush.android.util.a.l(paramContext);
    if (!ai.a(str2))
      localStringBuilder.append(str2);
    localStringBuilder.append(paramLong);
    this.g = cn.jpush.android.util.a.a(localStringBuilder.toString());
    af.a().b(paramContext, z[0], this.g);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a(localJSONObject);
      localJSONObject.put(z[2], PushService.m + Math.abs(paramLong / 1000L - PushService.n));
      localJSONObject.put(z[0], this.g);
      localJSONObject.put(z[5], z[20]);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  private static void a(JSONObject paramJSONObject)
  {
    String str1 = cn.jpush.android.util.i.a();
    String str2 = str1.split("_")[0];
    String str3 = str1.split("_")[1];
    paramJSONObject.put(z[18], str2);
    paramJSONObject.put(z[19], str3);
  }

  private static boolean a(String paramString)
  {
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i1 = arrayOfStackTraceElement.length;
    boolean bool = false;
    if (i1 >= 2);
    for (int i2 = 0; ; i2++)
    {
      try
      {
        if (i2 < arrayOfStackTraceElement.length)
        {
          StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i2];
          if (!localStackTraceElement.getMethodName().equals(paramString))
            continue;
          Class localClass;
          for (Object localObject = Class.forName(localStackTraceElement.getClassName()); ((Class)localObject).getSuperclass() != null; localObject = localClass)
          {
            if (((Class)localObject).getSuperclass() == Activity.class)
            {
              bool = true;
              break;
            }
            localClass = ((Class)localObject).getSuperclass();
          }
        }
      }
      catch (Exception localException)
      {
      }
      return bool;
    }
  }

  public static e b()
  {
    if (e == null);
    try
    {
      e = new e();
      return e;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private boolean c(Context paramContext, String paramString)
  {
    if (!this.p)
    {
      x.d();
      return false;
    }
    if (paramContext == null)
    {
      x.d();
      return false;
    }
    if ((paramContext instanceof Application))
    {
      x.e(c, z[6] + paramString);
      return false;
    }
    if (!a(paramString))
      throw new SecurityException(z[7]);
    return true;
  }

  private JSONObject d(Context paramContext)
  {
    if (this.r == null)
      this.r = ac.a(paramContext, z[4]);
    return this.r;
  }

  public final void a(long paramLong)
  {
    this.i = paramLong;
  }

  public final void a(Context paramContext)
  {
    if (!c(paramContext, z[14]))
      return;
    a = true;
    try
    {
      if ((Class.forName(paramContext.getClass().getName()).newInstance() instanceof TabActivity))
        this.o = false;
      if (this.o)
      {
        x.e(c, z[15]);
        return;
      }
    }
    catch (Exception localException1)
    {
      while (true)
        localException1.printStackTrace();
      this.o = true;
      this.j = System.currentTimeMillis();
      this.f = paramContext.getClass().getName();
      try
      {
        this.d.execute(new h(this, paramContext));
        return;
      }
      catch (Exception localException2)
      {
      }
    }
  }

  public final void a(Context paramContext, String paramString)
  {
    if (this.o)
    {
      x.e(c, z[8]);
      return;
    }
    this.o = true;
    this.f = paramString;
    this.j = System.currentTimeMillis();
    try
    {
      this.d.execute(new f(this, paramContext));
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public final void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public final boolean a()
  {
    return this.p;
  }

  public final void b(Context paramContext)
  {
    if (!c(paramContext, z[22]))
      return;
    b = true;
    try
    {
      if ((Class.forName(paramContext.getClass().getName()).newInstance() instanceof TabActivity))
        this.o = true;
      if (!this.o)
      {
        x.e(c, z[21]);
        return;
      }
    }
    catch (Exception localException1)
    {
      while (true)
        localException1.printStackTrace();
      this.o = false;
      if ((this.f != null) && (this.f.equals(paramContext.getClass().getName())))
      {
        this.k = System.currentTimeMillis();
        long l1 = (this.k - this.j) / 1000L;
        a locala = new a(this.f, l1);
        this.h.add(locala);
        try
        {
          this.d.execute(new i(this, paramContext));
          return;
        }
        catch (Exception localException2)
        {
          return;
        }
      }
      x.d();
    }
  }

  public final void b(Context paramContext, String paramString)
  {
    if (!this.o)
    {
      x.e(c, z[17]);
      return;
    }
    this.o = false;
    if ((this.f != null) && (this.f.equals(paramString)))
    {
      this.k = System.currentTimeMillis();
      long l1 = (this.k - this.j) / 1000L;
      a locala = new a(this.f, l1);
      this.h.add(locala);
      try
      {
        this.d.execute(new g(this, paramContext));
        return;
      }
      catch (Exception localException)
      {
        return;
      }
    }
    x.e(c, z[16]);
  }

  // ERROR //
  public final void c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 125	cn/jpush/android/api/e:f	Ljava/lang/String;
    //   4: ifnull +73 -> 77
    //   7: aload_0
    //   8: getfield 148	cn/jpush/android/api/e:o	Z
    //   11: ifeq +66 -> 77
    //   14: aload_0
    //   15: invokestatic 259	java/lang/System:currentTimeMillis	()J
    //   18: putfield 140	cn/jpush/android/api/e:k	J
    //   21: aload_0
    //   22: getfield 140	cn/jpush/android/api/e:k	J
    //   25: aload_0
    //   26: getfield 138	cn/jpush/android/api/e:j	J
    //   29: lsub
    //   30: ldc2_w 210
    //   33: ldiv
    //   34: lstore_3
    //   35: new 338	cn/jpush/android/api/a
    //   38: dup
    //   39: aload_0
    //   40: getfield 125	cn/jpush/android/api/e:f	Ljava/lang/String;
    //   43: lload_3
    //   44: invokespecial 345	cn/jpush/android/api/a:<init>	(Ljava/lang/String;J)V
    //   47: astore 5
    //   49: aload_0
    //   50: getfield 132	cn/jpush/android/api/e:h	Ljava/util/ArrayList;
    //   53: aload 5
    //   55: invokevirtual 348	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   58: pop
    //   59: aload_0
    //   60: getfield 123	cn/jpush/android/api/e:d	Ljava/util/concurrent/ExecutorService;
    //   63: new 435	cn/jpush/android/api/j
    //   66: dup
    //   67: aload_0
    //   68: aload_1
    //   69: invokespecial 436	cn/jpush/android/api/j:<init>	(Lcn/jpush/android/api/e;Landroid/content/Context;)V
    //   72: invokeinterface 422 2 0
    //   77: return
    //   78: astore_2
    //   79: return
    //   80: astore 7
    //   82: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	59	78	java/lang/Exception
    //   59	77	80	java/lang/Exception
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.e
 * JD-Core Version:    0.6.2
 */