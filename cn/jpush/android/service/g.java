package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.data.k;
import cn.jpush.android.util.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class g
{
  private static g a;
  private static ExecutorService b;
  private static cn.jpush.android.data.i f;
  private static k g;
  private static final String[] z;
  private Handler c = null;
  private Context d = null;
  private String e = "";

  static
  {
    Object localObject1 = new String[14];
    int i = 0;
    String str1 = "(T6Z\007?\021\027Z\022;]\025Z\0053W2V\020.X4[Q";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label36: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label52: int i2;
    int i3;
    if (k <= 1)
    {
      localObject4 = localObject3;
      n = m;
      i1 = k;
      localObject5 = localObject3;
      i2 = localObject5[m];
      switch (n % 5)
      {
      default:
        i3 = 113;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[m] = ((char)(i3 ^ i2));
      m = n + 1;
      if (i1 == 0)
      {
        localObject5 = localObject4;
        n = m;
        m = i1;
        break label52;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "\020a.F\031\026^8T\035\024^/\\\0273R:A\0305_\030P\037.T)";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "(T6Z\007?\0217Z\022;]{V\036/_/\025Kz";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "*^(AQ>T7T\b?U{\017Q";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = ".C2R\026?C\027{:3]7e\0035R>F\002`\021";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "tA>G\0343B(\\\0364\037\021e$\ty\004x4\tb\032r4";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "7T(F\020=T";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "9_u_\001/B3\033\0204U)Z\030>\0372[\005?_/\033?\025e\022s8\031p\017|>\024n\tp2\037x\rp5\005a\tz)\003";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = ")T5Q\024(x?";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = ";A+|\025";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "4^/\\\0273R:\\\0364n/L\001?";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "9]>T\003zP7YQ6^8T\035z_4A\030<X8T\0053^5\025";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = ";U?\025=5R:Y?5E2S\0309P/\\\0364";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "3_2AQ\026^8T\035\024^/\\\0273R:A\0305_{V\020)E{P\t*Ea";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        z = localObject2;
        a = null;
        b = Executors.newSingleThreadExecutor();
        f = null;
        g = new k();
        return;
        i3 = 90;
        continue;
        i3 = 49;
        continue;
        i3 = 91;
        continue;
        i3 = 53;
      }
    }
  }

  private g(Context paramContext)
  {
    x.c();
    this.c = new Handler(Looper.getMainLooper());
    this.d = paramContext;
    this.e = this.d.getPackageName();
  }

  public static g a(Context paramContext)
  {
    x.c();
    if (a == null)
      a = new g(paramContext);
    return a;
  }

  private void a(long paramLong1, long paramLong2)
  {
    x.c();
    if (paramLong1 < 0L)
      x.f();
    while (this.c == null)
      return;
    i locali = new i(this, paramLong1);
    if (paramLong2 <= 0L)
    {
      x.c();
      this.c.post(locali);
      return;
    }
    new StringBuilder(z[3]).append(paramLong2).toString();
    x.c();
    this.c.postDelayed(locali, paramLong2);
  }

  private void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    x.c();
    Intent localIntent = new Intent(z[7]);
    localIntent.putExtra(z[8], paramString3);
    localIntent.putExtra(z[9], paramString2);
    localIntent.putExtra(z[6], paramString1);
    localIntent.putExtra(z[10], 1);
    localIntent.addCategory(paramString2);
    paramContext.sendOrderedBroadcast(localIntent, paramString2 + z[5]);
    x.c();
  }

  // ERROR //
  public static boolean a(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: getstatic 66	cn/jpush/android/service/g:z	[Ljava/lang/String;
    //   3: iconst_1
    //   4: aaload
    //   5: getstatic 66	cn/jpush/android/service/g:z	[Ljava/lang/String;
    //   8: iconst_0
    //   9: aaload
    //   10: invokestatic 232	cn/jpush/android/util/x:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   16: ifnonnull +14 -> 30
    //   19: new 176	cn/jpush/android/data/i
    //   22: dup
    //   23: aload_0
    //   24: invokespecial 177	cn/jpush/android/data/i:<init>	(Landroid/content/Context;)V
    //   27: putstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   30: aconst_null
    //   31: astore_3
    //   32: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   35: invokevirtual 179	cn/jpush/android/data/i:a	()V
    //   38: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   41: lload_1
    //   42: iconst_0
    //   43: invokevirtual 235	cn/jpush/android/data/i:a	(JI)Landroid/database/Cursor;
    //   46: astore 8
    //   48: aload 8
    //   50: astore 5
    //   52: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   55: pop
    //   56: aload 5
    //   58: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   61: invokestatic 197	cn/jpush/android/data/i:a	(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V
    //   64: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   67: invokevirtual 237	cn/jpush/android/data/k:b	()I
    //   70: ifle +60 -> 130
    //   73: new 134	java/lang/StringBuilder
    //   76: dup
    //   77: getstatic 66	cn/jpush/android/service/g:z	[Ljava/lang/String;
    //   80: iconst_2
    //   81: aaload
    //   82: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   85: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   88: invokevirtual 237	cn/jpush/android/data/k:b	()I
    //   91: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: pop
    //   98: invokestatic 98	cn/jpush/android/util/x:c	()V
    //   101: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   104: lload_1
    //   105: iconst_0
    //   106: iconst_1
    //   107: iconst_0
    //   108: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   111: invokevirtual 199	cn/jpush/android/data/k:d	()Ljava/lang/String;
    //   114: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   117: invokevirtual 206	cn/jpush/android/data/k:f	()J
    //   120: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   123: invokevirtual 208	cn/jpush/android/data/k:e	()J
    //   126: invokevirtual 211	cn/jpush/android/data/i:b	(JIIILjava/lang/String;JJ)Z
    //   129: pop
    //   130: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   133: invokevirtual 216	cn/jpush/android/data/i:b	()V
    //   136: aload 5
    //   138: ifnull +10 -> 148
    //   141: aload 5
    //   143: invokeinterface 219 1 0
    //   148: iconst_1
    //   149: ireturn
    //   150: astore 7
    //   152: aload_3
    //   153: ifnull -5 -> 148
    //   156: aload_3
    //   157: invokeinterface 219 1 0
    //   162: iconst_1
    //   163: ireturn
    //   164: astore 4
    //   166: aconst_null
    //   167: astore 5
    //   169: aload 4
    //   171: astore 6
    //   173: aload 5
    //   175: ifnull +10 -> 185
    //   178: aload 5
    //   180: invokeinterface 219 1 0
    //   185: aload 6
    //   187: athrow
    //   188: astore 6
    //   190: goto -17 -> 173
    //   193: astore 9
    //   195: aload 5
    //   197: astore_3
    //   198: goto -46 -> 152
    //
    // Exception table:
    //   from	to	target	type
    //   32	48	150	java/lang/Exception
    //   32	48	164	finally
    //   52	130	188	finally
    //   130	136	188	finally
    //   52	130	193	java/lang/Exception
    //   130	136	193	java/lang/Exception
  }

  public static void b(Context paramContext)
  {
    x.b(z[1], z[11]);
    if (f == null)
      f = new cn.jpush.android.data.i(paramContext);
    f.a();
    if (f.c())
      x.c();
    f.b();
  }

  // ERROR //
  public final boolean a(Context paramContext, cn.jpush.android.data.JPushLocalNotification paramJPushLocalNotification)
  {
    // Byte code:
    //   0: getstatic 66	cn/jpush/android/service/g:z	[Ljava/lang/String;
    //   3: iconst_1
    //   4: aaload
    //   5: getstatic 66	cn/jpush/android/service/g:z	[Ljava/lang/String;
    //   8: bipush 12
    //   10: aaload
    //   11: invokestatic 232	cn/jpush/android/util/x:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   17: lstore_3
    //   18: aload_2
    //   19: invokevirtual 250	cn/jpush/android/data/JPushLocalNotification:getBroadcastTime	()J
    //   22: lload_3
    //   23: lsub
    //   24: lstore 5
    //   26: aload_1
    //   27: invokestatic 256	cn/jpush/android/service/ServiceInterface:j	(Landroid/content/Context;)Z
    //   30: ifeq +6 -> 36
    //   33: invokestatic 98	cn/jpush/android/util/x:c	()V
    //   36: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   39: ifnonnull +14 -> 53
    //   42: new 176	cn/jpush/android/data/i
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 177	cn/jpush/android/data/i:<init>	(Landroid/content/Context;)V
    //   50: putstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   53: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   56: invokevirtual 179	cn/jpush/android/data/i:a	()V
    //   59: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   62: aload_2
    //   63: invokevirtual 259	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   66: iconst_0
    //   67: invokevirtual 235	cn/jpush/android/data/i:a	(JI)Landroid/database/Cursor;
    //   70: astore 12
    //   72: aload 12
    //   74: astore 10
    //   76: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   79: pop
    //   80: aload 10
    //   82: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   85: invokestatic 197	cn/jpush/android/data/i:a	(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V
    //   88: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   91: invokevirtual 204	cn/jpush/android/data/k:a	()I
    //   94: i2l
    //   95: aload_2
    //   96: invokevirtual 259	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   99: lcmp
    //   100: ifeq +65 -> 165
    //   103: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   106: aload_2
    //   107: invokevirtual 259	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   110: iconst_1
    //   111: iconst_0
    //   112: iconst_0
    //   113: aload_2
    //   114: invokevirtual 262	cn/jpush/android/data/JPushLocalNotification:toJSON	()Ljava/lang/String;
    //   117: aload_2
    //   118: invokevirtual 250	cn/jpush/android/data/JPushLocalNotification:getBroadcastTime	()J
    //   121: lload_3
    //   122: invokevirtual 265	cn/jpush/android/data/i:a	(JIIILjava/lang/String;JJ)J
    //   125: pop2
    //   126: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   129: invokevirtual 216	cn/jpush/android/data/i:b	()V
    //   132: aload 10
    //   134: ifnull +10 -> 144
    //   137: aload 10
    //   139: invokeinterface 219 1 0
    //   144: lload 5
    //   146: ldc2_w 266
    //   149: lcmp
    //   150: ifge +86 -> 236
    //   153: aload_0
    //   154: aload_2
    //   155: invokevirtual 259	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   158: lload 5
    //   160: invokespecial 269	cn/jpush/android/service/g:a	(JJ)V
    //   163: iconst_1
    //   164: ireturn
    //   165: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   168: aload_2
    //   169: invokevirtual 259	cn/jpush/android/data/JPushLocalNotification:getNotificationId	()J
    //   172: iconst_1
    //   173: iconst_0
    //   174: iconst_0
    //   175: aload_2
    //   176: invokevirtual 262	cn/jpush/android/data/JPushLocalNotification:toJSON	()Ljava/lang/String;
    //   179: aload_2
    //   180: invokevirtual 250	cn/jpush/android/data/JPushLocalNotification:getBroadcastTime	()J
    //   183: lload_3
    //   184: invokevirtual 211	cn/jpush/android/data/i:b	(JIIILjava/lang/String;JJ)Z
    //   187: pop
    //   188: goto -62 -> 126
    //   191: astore 13
    //   193: aload 10
    //   195: astore 8
    //   197: aload 8
    //   199: ifnull -55 -> 144
    //   202: aload 8
    //   204: invokeinterface 219 1 0
    //   209: goto -65 -> 144
    //   212: astore 9
    //   214: aconst_null
    //   215: astore 10
    //   217: aload 9
    //   219: astore 11
    //   221: aload 10
    //   223: ifnull +10 -> 233
    //   226: aload 10
    //   228: invokeinterface 219 1 0
    //   233: aload 11
    //   235: athrow
    //   236: iconst_1
    //   237: ireturn
    //   238: astore 11
    //   240: goto -19 -> 221
    //   243: astore 7
    //   245: aconst_null
    //   246: astore 8
    //   248: goto -51 -> 197
    //
    // Exception table:
    //   from	to	target	type
    //   76	126	191	java/lang/Exception
    //   126	132	191	java/lang/Exception
    //   165	188	191	java/lang/Exception
    //   53	72	212	finally
    //   76	126	238	finally
    //   126	132	238	finally
    //   165	188	238	finally
    //   53	72	243	java/lang/Exception
  }

  // ERROR //
  public final void c(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 98	cn/jpush/android/util/x:c	()V
    //   3: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   6: ifnonnull +14 -> 20
    //   9: new 176	cn/jpush/android/data/i
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 177	cn/jpush/android/data/i:<init>	(Landroid/content/Context;)V
    //   17: putstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   20: aconst_null
    //   21: astore 4
    //   23: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   26: invokevirtual 179	cn/jpush/android/data/i:a	()V
    //   29: invokestatic 185	java/lang/System:currentTimeMillis	()J
    //   32: lstore 9
    //   34: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   37: lload 9
    //   39: ldc2_w 266
    //   42: invokevirtual 272	cn/jpush/android/data/i:a	(JJ)Landroid/database/Cursor;
    //   45: astore 11
    //   47: aload 11
    //   49: astore 4
    //   51: aload 4
    //   53: invokeinterface 194 1 0
    //   58: ifeq +45 -> 103
    //   61: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   64: pop
    //   65: aload 4
    //   67: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   70: invokestatic 197	cn/jpush/android/data/i:a	(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V
    //   73: aload_0
    //   74: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   77: invokevirtual 204	cn/jpush/android/data/k:a	()I
    //   80: i2l
    //   81: getstatic 84	cn/jpush/android/service/g:g	Lcn/jpush/android/data/k;
    //   84: invokevirtual 206	cn/jpush/android/data/k:f	()J
    //   87: lload 9
    //   89: lsub
    //   90: invokespecial 269	cn/jpush/android/service/g:a	(JJ)V
    //   93: aload 4
    //   95: invokeinterface 214 1 0
    //   100: ifne -39 -> 61
    //   103: getstatic 78	cn/jpush/android/service/g:f	Lcn/jpush/android/data/i;
    //   106: invokevirtual 216	cn/jpush/android/data/i:b	()V
    //   109: aload 4
    //   111: ifnull +93 -> 204
    //   114: aload 4
    //   116: invokeinterface 219 1 0
    //   121: return
    //   122: astore 8
    //   124: aload 4
    //   126: ifnull +78 -> 204
    //   129: aload 4
    //   131: invokeinterface 219 1 0
    //   136: return
    //   137: astore_2
    //   138: new 134	java/lang/StringBuilder
    //   141: dup
    //   142: getstatic 66	cn/jpush/android/service/g:z	[Ljava/lang/String;
    //   145: bipush 13
    //   147: aaload
    //   148: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_2
    //   152: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: pop
    //   159: invokestatic 98	cn/jpush/android/util/x:c	()V
    //   162: aload_2
    //   163: invokevirtual 228	java/lang/Exception:printStackTrace	()V
    //   166: return
    //   167: astore 5
    //   169: aconst_null
    //   170: astore 6
    //   172: aload 5
    //   174: astore 7
    //   176: aload 6
    //   178: ifnull +10 -> 188
    //   181: aload 6
    //   183: invokeinterface 219 1 0
    //   188: aload 7
    //   190: athrow
    //   191: astore 12
    //   193: aload 4
    //   195: astore 6
    //   197: aload 12
    //   199: astore 7
    //   201: goto -25 -> 176
    //   204: return
    //
    // Exception table:
    //   from	to	target	type
    //   23	47	122	java/lang/Exception
    //   51	61	122	java/lang/Exception
    //   61	103	122	java/lang/Exception
    //   103	109	122	java/lang/Exception
    //   3	20	137	java/lang/Exception
    //   114	121	137	java/lang/Exception
    //   129	136	137	java/lang/Exception
    //   181	188	137	java/lang/Exception
    //   188	191	137	java/lang/Exception
    //   23	47	167	finally
    //   51	61	191	finally
    //   61	103	191	finally
    //   103	109	191	finally
  }

  public final void d(Context paramContext)
  {
    x.c();
    b.execute(new h(this, paramContext));
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.g
 * JD-Core Version:    0.6.2
 */