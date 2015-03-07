package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import cn.jpush.android.util.x;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public final class a
{
  public static boolean b;
  private static final String[] z;
  public boolean a = false;
  private b c = null;
  private long d = 0L;
  private long e = 0L;
  private Bundle f;

  static
  {
    Object localObject1 = new String[25];
    int i = 0;
    String str1 = "DZ/TV";
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
        i3 = 110;
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
        str1 = "|j\\Y\ryk\n\022Nt|\033\026\034=.\035\013\0271o\016\030\007.DY";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "Ra\007\027\013rzI\r\007|kI\026\033e\"I\r\034h.\033\034\035e.DY";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "[^\034\n\006<]-2";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "D}\f\013CPi\f\027\032";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "sw\035\034\035,";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "Rb\006\n\013";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "Co\007\036\013";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "=.\017\020\002t@\b\024\013+";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "1}\b\017\013wg\005\034>pz\001C";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "bz\006\tNua\036\027\002~o\rY\fh.\034\n\013c ";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "=.\017\020\002tZ\006\r\017}B\f\027\tefS";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "bz\b\013\032Aa\032\r\007~`SY";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "?o\031\022";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "pm\035\020\0014\r\026\031b\006\030\n1#I\f\034}4";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "Ef\fY\034t}\006\f\034rkI\035\001t}I\027\001e.\f\001\007bzITN";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "Ao\033\030\0031k\033\013\001c.HXNd|\005C";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "Ra\007\r\013zD5\013i\035\021";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "vk\035Y\032ykI\037\007}kI\r\001eo\005Y\002t`\016\r\0061h\033\026\0031f\035\r\0361g\032Y^?";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        z = localObject2;
        b = true;
        return;
        i3 = 17;
        continue;
        i3 = 14;
        continue;
        i3 = 105;
        continue;
        i3 = 121;
      }
    }
  }

  public a(Context paramContext, cn.jpush.android.data.d paramd, Bundle paramBundle, c paramc, int paramInt)
  {
    x.b();
    this.a = false;
    this.f = paramBundle;
    this.c = new b(this, paramContext.getMainLooper(), paramc);
    this.c.sendEmptyMessageDelayed(0, 2000L);
    int j;
    while (true)
    {
      if (!b)
      {
        x.d();
        this.c.removeCallbacksAndMessages(null);
        this.a = true;
        paramc.a(1);
      }
      do
      {
        do
        {
          return;
          if (this.a)
          {
            x.d();
            this.c.removeCallbacksAndMessages(null);
            paramc.a(1);
            return;
          }
          if (paramd.P != 0)
            break;
          x.e();
        }
        while (paramc == null);
        this.a = true;
        DownloadService.a.remove(paramd);
        this.c.removeCallbacksAndMessages(null);
        paramc.a(2);
        return;
        if (i < 3)
          break;
        x.e();
      }
      while (paramc == null);
      this.a = true;
      DownloadService.a.remove(paramd);
      this.c.removeCallbacksAndMessages(null);
      paramc.a(2);
      return;
      j = a(paramContext, paramc, paramd);
      paramd.P = (-1 + paramd.P);
      if (j == -1)
      {
        new StringBuilder(z[3]).append(paramd.P).toString();
        x.c();
        try
        {
          Thread.sleep(3000L);
        }
        catch (InterruptedException localInterruptedException2)
        {
        }
      }
      else if (j == 0)
      {
        new StringBuilder(z[2]).append(paramd.P).toString();
        x.c();
        try
        {
          Thread.sleep(3000L);
        }
        catch (InterruptedException localInterruptedException1)
        {
        }
      }
      else
      {
        if (j == 1)
        {
          x.c();
          this.c.removeCallbacksAndMessages(null);
          this.a = true;
          return;
        }
        if (j != 2)
          break;
        new StringBuilder(z[1]).append(paramd.P).toString();
        x.c();
        i++;
      }
    }
    if (j == -3)
    {
      this.a = true;
      DownloadService.a.remove(paramd);
      this.c.removeCallbacksAndMessages(null);
      paramc.a(3);
      return;
    }
    x.c();
    this.a = true;
    DownloadService.a.remove(paramd);
    this.c.removeCallbacksAndMessages(null);
    paramc.a(2);
  }

  private static int a(long paramLong)
  {
    long l = paramLong / 10485760L;
    int i;
    if (l < 1L)
      i = 10;
    while (true)
    {
      return (int)(1.1D * i);
      if (l > 5L)
        i = 50;
      else
        i = (int)(l * 10L);
    }
  }

  // ERROR //
  private int a(Context paramContext, c paramc, cn.jpush.android.data.d paramd)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual 200	cn/jpush/android/data/d:d	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload_3
    //   7: invokevirtual 203	cn/jpush/android/data/d:g	()Ljava/lang/String;
    //   10: astore 5
    //   12: ldc 205
    //   14: astore 6
    //   16: ldc 205
    //   18: astore 7
    //   20: aload_3
    //   21: invokevirtual 208	cn/jpush/android/data/d:a	()Z
    //   24: ifeq +455 -> 479
    //   27: aload_1
    //   28: invokestatic 213	cn/jpush/android/util/k:b	(Landroid/content/Context;)Ljava/lang/String;
    //   31: astore 6
    //   33: new 157	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   40: aload_3
    //   41: getfield 217	cn/jpush/android/data/d:c	Ljava/lang/String;
    //   44: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   50: bipush 19
    //   52: aaload
    //   53: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 7
    //   61: aload 4
    //   63: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifne +1982 -> 2048
    //   69: aload 6
    //   71: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: ifne +1974 -> 2048
    //   77: aload 7
    //   79: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifne +1966 -> 2048
    //   85: new 157	java/lang/StringBuilder
    //   88: dup
    //   89: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   92: bipush 20
    //   94: aaload
    //   95: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload 4
    //   100: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   106: bipush 11
    //   108: aaload
    //   109: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload 6
    //   114: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   120: bipush 10
    //   122: aaload
    //   123: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 7
    //   128: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: pop
    //   135: invokestatic 124	cn/jpush/android/util/x:d	()V
    //   138: new 228	java/io/File
    //   141: dup
    //   142: aload 6
    //   144: invokespecial 229	java/io/File:<init>	(Ljava/lang/String;)V
    //   147: astore 10
    //   149: aload 10
    //   151: invokevirtual 232	java/io/File:isDirectory	()Z
    //   154: ifne +9 -> 163
    //   157: aload 10
    //   159: invokevirtual 235	java/io/File:mkdirs	()Z
    //   162: pop
    //   163: aload_0
    //   164: getfield 105	cn/jpush/android/service/a:f	Landroid/os/Bundle;
    //   167: aload 4
    //   169: ldc2_w 236
    //   172: invokevirtual 243	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   175: lstore 11
    //   177: lconst_0
    //   178: lstore 13
    //   180: aconst_null
    //   181: astore 15
    //   183: aconst_null
    //   184: astore 16
    //   186: aconst_null
    //   187: astore 17
    //   189: aconst_null
    //   190: astore 18
    //   192: aconst_null
    //   193: astore 19
    //   195: lload 11
    //   197: lconst_0
    //   198: lcmp
    //   199: ifgt +951 -> 1150
    //   202: new 228	java/io/File
    //   205: dup
    //   206: aload 6
    //   208: aload 7
    //   210: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: astore 20
    //   215: aload 20
    //   217: invokevirtual 249	java/io/File:exists	()Z
    //   220: ifeq +13 -> 233
    //   223: aload 20
    //   225: invokevirtual 253	java/io/File:length	()J
    //   228: lconst_0
    //   229: lcmp
    //   230: ifgt +753 -> 983
    //   233: invokestatic 103	cn/jpush/android/util/x:b	()V
    //   236: aload 4
    //   238: ldc2_w 236
    //   241: invokestatic 256	cn/jpush/android/service/a:a	(Ljava/lang/String;J)Lorg/apache/http/client/methods/HttpGet;
    //   244: astore 21
    //   246: invokestatic 259	cn/jpush/android/service/a:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   249: astore 22
    //   251: aload 22
    //   253: aload 21
    //   255: invokevirtual 265	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   258: astore 38
    //   260: aload 38
    //   262: ifnull +580 -> 842
    //   265: aload 38
    //   267: invokeinterface 271 1 0
    //   272: invokeinterface 277 1 0
    //   277: istore 39
    //   279: iload 39
    //   281: sipush 200
    //   284: if_icmpne +478 -> 762
    //   287: aload 38
    //   289: invokeinterface 281 1 0
    //   294: astore 40
    //   296: aload 40
    //   298: astore 24
    //   300: aload 24
    //   302: invokeinterface 286 1 0
    //   307: ifeq +440 -> 747
    //   310: aload 38
    //   312: invokestatic 289	cn/jpush/android/service/a:a	(Lorg/apache/http/HttpResponse;)J
    //   315: lstore 48
    //   317: aload_0
    //   318: getfield 105	cn/jpush/android/service/a:f	Landroid/os/Bundle;
    //   321: aload 4
    //   323: lload 48
    //   325: invokevirtual 293	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   328: aload_3
    //   329: lload 48
    //   331: invokestatic 295	cn/jpush/android/service/a:a	(J)I
    //   334: putfield 139	cn/jpush/android/data/d:P	I
    //   337: aload 24
    //   339: invokeinterface 299 1 0
    //   344: astore 50
    //   346: aload 50
    //   348: astore 30
    //   350: aload 30
    //   352: ifnull +380 -> 732
    //   355: new 301	java/io/BufferedInputStream
    //   358: dup
    //   359: aload 30
    //   361: invokespecial 304	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   364: astore 57
    //   366: aload 20
    //   368: invokevirtual 307	java/io/File:delete	()Z
    //   371: pop
    //   372: aload 20
    //   374: invokevirtual 310	java/io/File:createNewFile	()Z
    //   377: pop
    //   378: new 312	java/io/FileOutputStream
    //   381: dup
    //   382: aload 20
    //   384: invokespecial 315	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   387: astore 67
    //   389: new 317	java/io/BufferedOutputStream
    //   392: dup
    //   393: aload 67
    //   395: invokespecial 320	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   398: astore 25
    //   400: sipush 1024
    //   403: newarray byte
    //   405: astore 75
    //   407: aload 57
    //   409: aload 75
    //   411: invokevirtual 324	java/io/BufferedInputStream:read	([B)I
    //   414: istore 76
    //   416: iload 76
    //   418: iconst_m1
    //   419: if_icmpeq +197 -> 616
    //   422: aload_0
    //   423: getfield 99	cn/jpush/android/service/a:a	Z
    //   426: ifeq +124 -> 550
    //   429: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   432: new 198	cn/jpush/android/d
    //   435: dup
    //   436: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   439: bipush 14
    //   441: aaload
    //   442: invokespecial 325	cn/jpush/android/d:<init>	(Ljava/lang/String;)V
    //   445: athrow
    //   446: astore 74
    //   448: aload 67
    //   450: astore 26
    //   452: aload 57
    //   454: astore 27
    //   456: aload 30
    //   458: astore 28
    //   460: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   463: aload 28
    //   465: aload 27
    //   467: aload 26
    //   469: aload 25
    //   471: aload 24
    //   473: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   476: bipush 254
    //   478: ireturn
    //   479: aload_3
    //   480: invokevirtual 333	cn/jpush/android/data/d:b	()Z
    //   483: ifeq +18 -> 501
    //   486: aload_1
    //   487: invokestatic 335	cn/jpush/android/util/k:c	(Landroid/content/Context;)Ljava/lang/String;
    //   490: astore 6
    //   492: aload_3
    //   493: getfield 217	cn/jpush/android/data/d:c	Ljava/lang/String;
    //   496: astore 7
    //   498: goto -437 -> 61
    //   501: aload_3
    //   502: invokevirtual 337	cn/jpush/android/data/d:f	()Z
    //   505: ifeq -444 -> 61
    //   508: aload_1
    //   509: aload_3
    //   510: getfield 217	cn/jpush/android/data/d:c	Ljava/lang/String;
    //   513: invokestatic 340	cn/jpush/android/util/k:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   516: astore 6
    //   518: new 157	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   525: aload_3
    //   526: getfield 217	cn/jpush/android/data/d:c	Ljava/lang/String;
    //   529: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_3
    //   533: invokevirtual 200	cn/jpush/android/data/d:d	()Ljava/lang/String;
    //   536: invokestatic 345	cn/jpush/android/util/m:b	(Ljava/lang/String;)Ljava/lang/String;
    //   539: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: astore 7
    //   547: goto -486 -> 61
    //   550: aload 25
    //   552: aload 75
    //   554: iconst_0
    //   555: iload 76
    //   557: invokevirtual 349	java/io/BufferedOutputStream:write	([BII)V
    //   560: lload 13
    //   562: iload 76
    //   564: i2l
    //   565: ladd
    //   566: lstore 13
    //   568: aload_0
    //   569: lload 13
    //   571: putfield 95	cn/jpush/android/service/a:d	J
    //   574: aload_0
    //   575: lload 48
    //   577: putfield 97	cn/jpush/android/service/a:e	J
    //   580: goto -173 -> 407
    //   583: astore 73
    //   585: aload 25
    //   587: astore 18
    //   589: aload 67
    //   591: astore 17
    //   593: aload 57
    //   595: astore 16
    //   597: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   600: aload 30
    //   602: aload 16
    //   604: aload 17
    //   606: aload 18
    //   608: aload 24
    //   610: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   613: bipush 254
    //   615: ireturn
    //   616: aload 25
    //   618: invokevirtual 352	java/io/BufferedOutputStream:flush	()V
    //   621: aload 20
    //   623: ifnull +64 -> 687
    //   626: aload 20
    //   628: invokevirtual 253	java/io/File:length	()J
    //   631: lload 48
    //   633: lcmp
    //   634: ifne +53 -> 687
    //   637: aload 5
    //   639: aload 20
    //   641: invokestatic 357	cn/jpush/android/util/g:a	(Ljava/lang/String;Ljava/io/File;)Z
    //   644: ifeq +43 -> 687
    //   647: aload_0
    //   648: getfield 105	cn/jpush/android/service/a:f	Landroid/os/Bundle;
    //   651: aload 4
    //   653: invokevirtual 359	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   656: aload_2
    //   657: ifnull +15 -> 672
    //   660: aload_2
    //   661: aload 20
    //   663: invokevirtual 362	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   666: iconst_0
    //   667: invokeinterface 365 3 0
    //   672: aload 30
    //   674: aload 57
    //   676: aload 67
    //   678: aload 25
    //   680: aload 24
    //   682: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   685: iconst_1
    //   686: ireturn
    //   687: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   690: aload 20
    //   692: invokevirtual 307	java/io/File:delete	()Z
    //   695: ifne +22 -> 717
    //   698: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   701: aload 30
    //   703: aload 57
    //   705: aload 67
    //   707: aload 25
    //   709: aload 24
    //   711: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   714: bipush 254
    //   716: ireturn
    //   717: aload 30
    //   719: aload 57
    //   721: aload 67
    //   723: aload 25
    //   725: aload 24
    //   727: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   730: iconst_2
    //   731: ireturn
    //   732: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   735: aload 30
    //   737: aconst_null
    //   738: aconst_null
    //   739: aconst_null
    //   740: aload 24
    //   742: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   745: iconst_0
    //   746: ireturn
    //   747: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   750: aconst_null
    //   751: aconst_null
    //   752: aconst_null
    //   753: aconst_null
    //   754: aload 24
    //   756: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   759: bipush 254
    //   761: ireturn
    //   762: iload 39
    //   764: sipush 404
    //   767: if_icmpne +39 -> 806
    //   770: new 157	java/lang/StringBuilder
    //   773: dup
    //   774: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   777: bipush 21
    //   779: aaload
    //   780: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   783: aload 4
    //   785: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: pop
    //   792: invokestatic 169	cn/jpush/android/util/x:c	()V
    //   795: aconst_null
    //   796: aconst_null
    //   797: aconst_null
    //   798: aconst_null
    //   799: aconst_null
    //   800: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   803: bipush 253
    //   805: ireturn
    //   806: new 157	java/lang/StringBuilder
    //   809: dup
    //   810: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   813: bipush 15
    //   815: aaload
    //   816: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   819: iload 39
    //   821: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   824: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: pop
    //   828: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   831: aconst_null
    //   832: aconst_null
    //   833: aconst_null
    //   834: aconst_null
    //   835: aconst_null
    //   836: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   839: bipush 254
    //   841: ireturn
    //   842: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   845: aconst_null
    //   846: aconst_null
    //   847: aconst_null
    //   848: aconst_null
    //   849: aconst_null
    //   850: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   853: iconst_0
    //   854: ireturn
    //   855: astore 37
    //   857: aconst_null
    //   858: astore 24
    //   860: aconst_null
    //   861: astore 30
    //   863: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   866: aload 30
    //   868: aload 16
    //   870: aload 17
    //   872: aload 18
    //   874: aload 24
    //   876: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   879: bipush 254
    //   881: ireturn
    //   882: astore 36
    //   884: aconst_null
    //   885: astore 24
    //   887: aconst_null
    //   888: astore 30
    //   890: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   893: aload 30
    //   895: aload 16
    //   897: aload 17
    //   899: aload 18
    //   901: aload 24
    //   903: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   906: bipush 254
    //   908: ireturn
    //   909: astore 35
    //   911: aconst_null
    //   912: astore 24
    //   914: aconst_null
    //   915: astore 30
    //   917: invokestatic 370	cn/jpush/android/util/x:h	()V
    //   920: aload 30
    //   922: aload 16
    //   924: aload 17
    //   926: aload 18
    //   928: aload 24
    //   930: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   933: iconst_m1
    //   934: ireturn
    //   935: astore 34
    //   937: aconst_null
    //   938: astore 24
    //   940: aconst_null
    //   941: astore 30
    //   943: invokestatic 373	cn/jpush/android/util/x:i	()V
    //   946: aload 30
    //   948: aload 16
    //   950: aload 17
    //   952: aload 18
    //   954: aload 24
    //   956: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   959: bipush 254
    //   961: ireturn
    //   962: astore 31
    //   964: aconst_null
    //   965: astore 30
    //   967: aload 30
    //   969: aload 16
    //   971: aload 17
    //   973: aload 18
    //   975: aload 19
    //   977: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   980: aload 31
    //   982: athrow
    //   983: aload 20
    //   985: invokevirtual 253	java/io/File:length	()J
    //   988: lconst_0
    //   989: lcmp
    //   990: ifle +154 -> 1144
    //   993: aload 4
    //   995: ldc2_w 236
    //   998: invokestatic 256	cn/jpush/android/service/a:a	(Ljava/lang/String;J)Lorg/apache/http/client/methods/HttpGet;
    //   1001: astore 86
    //   1003: invokestatic 259	cn/jpush/android/service/a:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   1006: astore 87
    //   1008: aload 87
    //   1010: aload 86
    //   1012: invokevirtual 265	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   1015: invokestatic 289	cn/jpush/android/service/a:a	(Lorg/apache/http/HttpResponse;)J
    //   1018: lstore 91
    //   1020: aload 20
    //   1022: invokevirtual 253	java/io/File:length	()J
    //   1025: lload 91
    //   1027: lcmp
    //   1028: ifne +35 -> 1063
    //   1031: aload 5
    //   1033: aload 20
    //   1035: invokestatic 357	cn/jpush/android/util/g:a	(Ljava/lang/String;Ljava/io/File;)Z
    //   1038: ifeq +25 -> 1063
    //   1041: invokestatic 169	cn/jpush/android/util/x:c	()V
    //   1044: aload_2
    //   1045: ifnull +2232 -> 3277
    //   1048: aload_2
    //   1049: aload 20
    //   1051: invokevirtual 362	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1054: iconst_1
    //   1055: invokeinterface 365 3 0
    //   1060: goto +2217 -> 3277
    //   1063: new 157	java/lang/StringBuilder
    //   1066: dup
    //   1067: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   1070: bipush 18
    //   1072: aaload
    //   1073: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1076: aload 20
    //   1078: invokevirtual 253	java/io/File:length	()J
    //   1081: invokevirtual 376	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1084: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   1087: bipush 16
    //   1089: aaload
    //   1090: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: lload 91
    //   1095: invokevirtual 376	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1098: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: pop
    //   1102: invokestatic 124	cn/jpush/android/util/x:d	()V
    //   1105: aload 20
    //   1107: invokevirtual 307	java/io/File:delete	()Z
    //   1110: ifne +9 -> 1119
    //   1113: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1116: bipush 254
    //   1118: ireturn
    //   1119: iconst_2
    //   1120: ireturn
    //   1121: astore 90
    //   1123: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   1126: bipush 254
    //   1128: ireturn
    //   1129: astore 89
    //   1131: invokestatic 370	cn/jpush/android/util/x:h	()V
    //   1134: iconst_m1
    //   1135: ireturn
    //   1136: astore 88
    //   1138: invokestatic 373	cn/jpush/android/util/x:i	()V
    //   1141: bipush 254
    //   1143: ireturn
    //   1144: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1147: bipush 254
    //   1149: ireturn
    //   1150: invokestatic 124	cn/jpush/android/util/x:d	()V
    //   1153: new 228	java/io/File
    //   1156: dup
    //   1157: aload 6
    //   1159: aload 7
    //   1161: invokespecial 246	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1164: astore 94
    //   1166: aload 94
    //   1168: invokevirtual 249	java/io/File:exists	()Z
    //   1171: ifeq +331 -> 1502
    //   1174: invokestatic 103	cn/jpush/android/util/x:b	()V
    //   1177: aload 94
    //   1179: invokevirtual 253	java/io/File:length	()J
    //   1182: lstore 95
    //   1184: lload 95
    //   1186: lstore 13
    //   1188: new 157	java/lang/StringBuilder
    //   1191: dup
    //   1192: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   1195: bipush 17
    //   1197: aaload
    //   1198: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1201: lload 95
    //   1203: invokevirtual 376	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: pop
    //   1210: invokestatic 124	cn/jpush/android/util/x:d	()V
    //   1213: aload_3
    //   1214: getfield 139	cn/jpush/android/data/d:P	I
    //   1217: iconst_m1
    //   1218: if_icmpne +15 -> 1233
    //   1221: invokestatic 169	cn/jpush/android/util/x:c	()V
    //   1224: aload_3
    //   1225: lload 11
    //   1227: invokestatic 295	cn/jpush/android/service/a:a	(J)I
    //   1230: putfield 139	cn/jpush/android/data/d:P	I
    //   1233: aload 4
    //   1235: lload 95
    //   1237: invokestatic 256	cn/jpush/android/service/a:a	(Ljava/lang/String;J)Lorg/apache/http/client/methods/HttpGet;
    //   1240: astore 100
    //   1242: invokestatic 259	cn/jpush/android/service/a:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   1245: astore 101
    //   1247: aload 101
    //   1249: aload 100
    //   1251: invokevirtual 265	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   1254: astore 109
    //   1256: aconst_null
    //   1257: astore 18
    //   1259: aconst_null
    //   1260: astore 17
    //   1262: aconst_null
    //   1263: astore 15
    //   1265: aconst_null
    //   1266: astore 16
    //   1268: aconst_null
    //   1269: astore 19
    //   1271: aload 109
    //   1273: ifnull +661 -> 1934
    //   1276: aload 109
    //   1278: invokeinterface 271 1 0
    //   1283: invokeinterface 277 1 0
    //   1288: istore 110
    //   1290: iload 110
    //   1292: sipush 200
    //   1295: if_icmpeq +11 -> 1306
    //   1298: iload 110
    //   1300: sipush 206
    //   1303: if_icmpne +491 -> 1794
    //   1306: aload 109
    //   1308: invokeinterface 281 1 0
    //   1313: astore 19
    //   1315: aload 19
    //   1317: invokeinterface 286 1 0
    //   1322: istore 111
    //   1324: aconst_null
    //   1325: astore 18
    //   1327: aconst_null
    //   1328: astore 17
    //   1330: aconst_null
    //   1331: astore 15
    //   1333: aconst_null
    //   1334: astore 16
    //   1336: iload 111
    //   1338: ifeq +441 -> 1779
    //   1341: lload 13
    //   1343: aload 109
    //   1345: invokestatic 289	cn/jpush/android/service/a:a	(Lorg/apache/http/HttpResponse;)J
    //   1348: ladd
    //   1349: lload 11
    //   1351: lcmp
    //   1352: istore 112
    //   1354: aconst_null
    //   1355: astore 18
    //   1357: aconst_null
    //   1358: astore 17
    //   1360: aconst_null
    //   1361: astore 15
    //   1363: aconst_null
    //   1364: astore 16
    //   1366: iload 112
    //   1368: ifne +361 -> 1729
    //   1371: aload 19
    //   1373: invokeinterface 299 1 0
    //   1378: astore 113
    //   1380: aload 113
    //   1382: ifnull +332 -> 1714
    //   1385: new 301	java/io/BufferedInputStream
    //   1388: dup
    //   1389: aload 113
    //   1391: invokespecial 304	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1394: astore 120
    //   1396: new 312	java/io/FileOutputStream
    //   1399: dup
    //   1400: aload 94
    //   1402: iconst_1
    //   1403: invokespecial 379	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   1406: astore 121
    //   1408: new 317	java/io/BufferedOutputStream
    //   1411: dup
    //   1412: aload 121
    //   1414: invokespecial 320	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1417: astore 122
    //   1419: sipush 1024
    //   1422: newarray byte
    //   1424: astore 130
    //   1426: aload 120
    //   1428: aload 130
    //   1430: invokevirtual 324	java/io/BufferedInputStream:read	([B)I
    //   1433: istore 131
    //   1435: iload 131
    //   1437: iconst_m1
    //   1438: if_icmpeq +157 -> 1595
    //   1441: aload_0
    //   1442: getfield 99	cn/jpush/android/service/a:a	Z
    //   1445: ifeq +80 -> 1525
    //   1448: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   1451: new 198	cn/jpush/android/d
    //   1454: dup
    //   1455: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   1458: bipush 14
    //   1460: aaload
    //   1461: invokespecial 325	cn/jpush/android/d:<init>	(Ljava/lang/String;)V
    //   1464: athrow
    //   1465: astore 129
    //   1467: aload 122
    //   1469: astore 18
    //   1471: aload 121
    //   1473: astore 17
    //   1475: aload 120
    //   1477: astore 16
    //   1479: aload 113
    //   1481: astore 15
    //   1483: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   1486: aload 15
    //   1488: aload 16
    //   1490: aload 17
    //   1492: aload 18
    //   1494: aload 19
    //   1496: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1499: bipush 254
    //   1501: ireturn
    //   1502: invokestatic 103	cn/jpush/android/util/x:b	()V
    //   1505: lconst_0
    //   1506: lstore 95
    //   1508: aload 94
    //   1510: invokevirtual 310	java/io/File:createNewFile	()Z
    //   1513: pop
    //   1514: goto -326 -> 1188
    //   1517: astore 97
    //   1519: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   1522: bipush 254
    //   1524: ireturn
    //   1525: aload 122
    //   1527: aload 130
    //   1529: iconst_0
    //   1530: iload 131
    //   1532: invokevirtual 349	java/io/BufferedOutputStream:write	([BII)V
    //   1535: lload 13
    //   1537: iload 131
    //   1539: i2l
    //   1540: ladd
    //   1541: lstore 13
    //   1543: aload_0
    //   1544: lload 13
    //   1546: putfield 95	cn/jpush/android/service/a:d	J
    //   1549: aload_0
    //   1550: lload 11
    //   1552: putfield 97	cn/jpush/android/service/a:e	J
    //   1555: goto -129 -> 1426
    //   1558: astore 128
    //   1560: aload 122
    //   1562: astore 18
    //   1564: aload 121
    //   1566: astore 17
    //   1568: aload 120
    //   1570: astore 16
    //   1572: aload 113
    //   1574: astore 15
    //   1576: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   1579: aload 15
    //   1581: aload 16
    //   1583: aload 17
    //   1585: aload 18
    //   1587: aload 19
    //   1589: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1592: bipush 254
    //   1594: ireturn
    //   1595: aload 122
    //   1597: invokevirtual 352	java/io/BufferedOutputStream:flush	()V
    //   1600: invokestatic 169	cn/jpush/android/util/x:c	()V
    //   1603: aload 94
    //   1605: ifnull +64 -> 1669
    //   1608: aload 94
    //   1610: invokevirtual 253	java/io/File:length	()J
    //   1613: lload 11
    //   1615: lcmp
    //   1616: ifne +53 -> 1669
    //   1619: aload 5
    //   1621: aload 94
    //   1623: invokestatic 357	cn/jpush/android/util/g:a	(Ljava/lang/String;Ljava/io/File;)Z
    //   1626: ifeq +43 -> 1669
    //   1629: aload_0
    //   1630: getfield 105	cn/jpush/android/service/a:f	Landroid/os/Bundle;
    //   1633: aload 4
    //   1635: invokevirtual 359	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   1638: aload_2
    //   1639: ifnull +15 -> 1654
    //   1642: aload_2
    //   1643: aload 94
    //   1645: invokevirtual 362	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1648: iconst_0
    //   1649: invokeinterface 365 3 0
    //   1654: aload 113
    //   1656: aload 120
    //   1658: aload 121
    //   1660: aload 122
    //   1662: aload 19
    //   1664: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1667: iconst_1
    //   1668: ireturn
    //   1669: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   1672: aload 94
    //   1674: invokevirtual 307	java/io/File:delete	()Z
    //   1677: ifne +22 -> 1699
    //   1680: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1683: aload 113
    //   1685: aload 120
    //   1687: aload 121
    //   1689: aload 122
    //   1691: aload 19
    //   1693: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1696: bipush 254
    //   1698: ireturn
    //   1699: aload 113
    //   1701: aload 120
    //   1703: aload 121
    //   1705: aload 122
    //   1707: aload 19
    //   1709: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1712: iconst_2
    //   1713: ireturn
    //   1714: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   1717: aload 113
    //   1719: aconst_null
    //   1720: aconst_null
    //   1721: aconst_null
    //   1722: aload 19
    //   1724: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1727: iconst_0
    //   1728: ireturn
    //   1729: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1732: aload_0
    //   1733: getfield 105	cn/jpush/android/service/a:f	Landroid/os/Bundle;
    //   1736: aload 4
    //   1738: invokevirtual 359	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   1741: aload 94
    //   1743: invokevirtual 307	java/io/File:delete	()Z
    //   1746: istore 144
    //   1748: aconst_null
    //   1749: astore 18
    //   1751: aconst_null
    //   1752: astore 17
    //   1754: aconst_null
    //   1755: astore 15
    //   1757: aconst_null
    //   1758: astore 16
    //   1760: iload 144
    //   1762: ifne +6 -> 1768
    //   1765: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1768: aconst_null
    //   1769: aconst_null
    //   1770: aconst_null
    //   1771: aconst_null
    //   1772: aload 19
    //   1774: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1777: iconst_0
    //   1778: ireturn
    //   1779: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1782: aconst_null
    //   1783: aconst_null
    //   1784: aconst_null
    //   1785: aconst_null
    //   1786: aload 19
    //   1788: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1791: bipush 254
    //   1793: ireturn
    //   1794: iload 110
    //   1796: sipush 416
    //   1799: if_icmpne +55 -> 1854
    //   1802: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1805: aload_0
    //   1806: getfield 105	cn/jpush/android/service/a:f	Landroid/os/Bundle;
    //   1809: aload 4
    //   1811: invokevirtual 359	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   1814: aload 94
    //   1816: invokevirtual 307	java/io/File:delete	()Z
    //   1819: istore 147
    //   1821: aconst_null
    //   1822: astore 18
    //   1824: aconst_null
    //   1825: astore 17
    //   1827: aconst_null
    //   1828: astore 15
    //   1830: aconst_null
    //   1831: astore 16
    //   1833: aconst_null
    //   1834: astore 19
    //   1836: iload 147
    //   1838: ifne +6 -> 1844
    //   1841: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   1844: aconst_null
    //   1845: aconst_null
    //   1846: aconst_null
    //   1847: aconst_null
    //   1848: aconst_null
    //   1849: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1852: iconst_0
    //   1853: ireturn
    //   1854: iload 110
    //   1856: sipush 404
    //   1859: if_icmpne +39 -> 1898
    //   1862: new 157	java/lang/StringBuilder
    //   1865: dup
    //   1866: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   1869: bipush 21
    //   1871: aaload
    //   1872: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1875: aload 4
    //   1877: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1883: pop
    //   1884: invokestatic 169	cn/jpush/android/util/x:c	()V
    //   1887: aconst_null
    //   1888: aconst_null
    //   1889: aconst_null
    //   1890: aconst_null
    //   1891: aconst_null
    //   1892: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1895: bipush 253
    //   1897: ireturn
    //   1898: new 157	java/lang/StringBuilder
    //   1901: dup
    //   1902: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   1905: bipush 15
    //   1907: aaload
    //   1908: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1911: iload 110
    //   1913: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1916: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1919: pop
    //   1920: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   1923: aconst_null
    //   1924: aconst_null
    //   1925: aconst_null
    //   1926: aconst_null
    //   1927: aconst_null
    //   1928: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1931: bipush 254
    //   1933: ireturn
    //   1934: invokestatic 141	cn/jpush/android/util/x:e	()V
    //   1937: aconst_null
    //   1938: aconst_null
    //   1939: aconst_null
    //   1940: aconst_null
    //   1941: aconst_null
    //   1942: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1945: iconst_0
    //   1946: ireturn
    //   1947: astore 108
    //   1949: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   1952: aload 15
    //   1954: aload 16
    //   1956: aload 17
    //   1958: aload 18
    //   1960: aload 19
    //   1962: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1965: bipush 254
    //   1967: ireturn
    //   1968: astore 107
    //   1970: invokestatic 328	cn/jpush/android/util/x:j	()V
    //   1973: aload 15
    //   1975: aload 16
    //   1977: aload 17
    //   1979: aload 18
    //   1981: aload 19
    //   1983: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   1986: bipush 254
    //   1988: ireturn
    //   1989: astore 106
    //   1991: invokestatic 370	cn/jpush/android/util/x:h	()V
    //   1994: aload 15
    //   1996: aload 16
    //   1998: aload 17
    //   2000: aload 18
    //   2002: aload 19
    //   2004: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   2007: iconst_m1
    //   2008: ireturn
    //   2009: astore 105
    //   2011: invokestatic 373	cn/jpush/android/util/x:i	()V
    //   2014: aload 15
    //   2016: aload 16
    //   2018: aload 17
    //   2020: aload 18
    //   2022: aload 19
    //   2024: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   2027: bipush 254
    //   2029: ireturn
    //   2030: astore 103
    //   2032: aload 15
    //   2034: aload 16
    //   2036: aload 17
    //   2038: aload 18
    //   2040: aload 19
    //   2042: invokestatic 331	cn/jpush/android/service/a:a	(Ljava/io/InputStream;Ljava/io/BufferedInputStream;Ljava/io/FileOutputStream;Ljava/io/BufferedOutputStream;Lorg/apache/http/HttpEntity;)V
    //   2045: aload 103
    //   2047: athrow
    //   2048: new 157	java/lang/StringBuilder
    //   2051: dup
    //   2052: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   2055: bipush 22
    //   2057: aaload
    //   2058: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2061: aload 4
    //   2063: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   2069: bipush 13
    //   2071: aaload
    //   2072: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2075: aload 6
    //   2077: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2080: getstatic 84	cn/jpush/android/service/a:z	[Ljava/lang/String;
    //   2083: bipush 12
    //   2085: aaload
    //   2086: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2089: aload 7
    //   2091: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2097: pop
    //   2098: invokestatic 367	cn/jpush/android/util/x:f	()V
    //   2101: bipush 254
    //   2103: ireturn
    //   2104: astore 103
    //   2106: aload 113
    //   2108: astore 15
    //   2110: aconst_null
    //   2111: astore 18
    //   2113: aconst_null
    //   2114: astore 17
    //   2116: aconst_null
    //   2117: astore 16
    //   2119: goto -87 -> 2032
    //   2122: astore 103
    //   2124: aload 120
    //   2126: astore 16
    //   2128: aload 113
    //   2130: astore 15
    //   2132: aconst_null
    //   2133: astore 18
    //   2135: aconst_null
    //   2136: astore 17
    //   2138: goto -106 -> 2032
    //   2141: astore 103
    //   2143: aload 121
    //   2145: astore 17
    //   2147: aload 120
    //   2149: astore 16
    //   2151: aload 113
    //   2153: astore 15
    //   2155: aconst_null
    //   2156: astore 18
    //   2158: goto -126 -> 2032
    //   2161: astore 127
    //   2163: aload 122
    //   2165: astore 18
    //   2167: aload 121
    //   2169: astore 17
    //   2171: aload 120
    //   2173: astore 16
    //   2175: aload 127
    //   2177: astore 103
    //   2179: aload 113
    //   2181: astore 15
    //   2183: goto -151 -> 2032
    //   2186: astore 119
    //   2188: aload 113
    //   2190: astore 15
    //   2192: aconst_null
    //   2193: astore 18
    //   2195: aconst_null
    //   2196: astore 17
    //   2198: aconst_null
    //   2199: astore 16
    //   2201: goto -190 -> 2011
    //   2204: astore 143
    //   2206: aload 120
    //   2208: astore 16
    //   2210: aload 113
    //   2212: astore 15
    //   2214: aconst_null
    //   2215: astore 18
    //   2217: aconst_null
    //   2218: astore 17
    //   2220: goto -209 -> 2011
    //   2223: astore 137
    //   2225: aload 121
    //   2227: astore 17
    //   2229: aload 120
    //   2231: astore 16
    //   2233: aload 113
    //   2235: astore 15
    //   2237: aconst_null
    //   2238: astore 18
    //   2240: goto -229 -> 2011
    //   2243: astore 126
    //   2245: aload 122
    //   2247: astore 18
    //   2249: aload 121
    //   2251: astore 17
    //   2253: aload 120
    //   2255: astore 16
    //   2257: aload 113
    //   2259: astore 15
    //   2261: goto -250 -> 2011
    //   2264: astore 118
    //   2266: aload 113
    //   2268: astore 15
    //   2270: aconst_null
    //   2271: astore 18
    //   2273: aconst_null
    //   2274: astore 17
    //   2276: aconst_null
    //   2277: astore 16
    //   2279: goto -288 -> 1991
    //   2282: astore 142
    //   2284: aload 120
    //   2286: astore 16
    //   2288: aload 113
    //   2290: astore 15
    //   2292: aconst_null
    //   2293: astore 18
    //   2295: aconst_null
    //   2296: astore 17
    //   2298: goto -307 -> 1991
    //   2301: astore 136
    //   2303: aload 121
    //   2305: astore 17
    //   2307: aload 120
    //   2309: astore 16
    //   2311: aload 113
    //   2313: astore 15
    //   2315: aconst_null
    //   2316: astore 18
    //   2318: goto -327 -> 1991
    //   2321: astore 125
    //   2323: aload 122
    //   2325: astore 18
    //   2327: aload 121
    //   2329: astore 17
    //   2331: aload 120
    //   2333: astore 16
    //   2335: aload 113
    //   2337: astore 15
    //   2339: goto -348 -> 1991
    //   2342: astore 117
    //   2344: aload 113
    //   2346: astore 15
    //   2348: aconst_null
    //   2349: astore 18
    //   2351: aconst_null
    //   2352: astore 17
    //   2354: aconst_null
    //   2355: astore 16
    //   2357: goto -387 -> 1970
    //   2360: astore 141
    //   2362: aload 120
    //   2364: astore 16
    //   2366: aload 113
    //   2368: astore 15
    //   2370: aconst_null
    //   2371: astore 18
    //   2373: aconst_null
    //   2374: astore 17
    //   2376: goto -406 -> 1970
    //   2379: astore 135
    //   2381: aload 121
    //   2383: astore 17
    //   2385: aload 120
    //   2387: astore 16
    //   2389: aload 113
    //   2391: astore 15
    //   2393: aconst_null
    //   2394: astore 18
    //   2396: goto -426 -> 1970
    //   2399: astore 124
    //   2401: aload 122
    //   2403: astore 18
    //   2405: aload 121
    //   2407: astore 17
    //   2409: aload 120
    //   2411: astore 16
    //   2413: aload 113
    //   2415: astore 15
    //   2417: goto -447 -> 1970
    //   2420: astore 116
    //   2422: aload 113
    //   2424: astore 15
    //   2426: aconst_null
    //   2427: astore 18
    //   2429: aconst_null
    //   2430: astore 17
    //   2432: aconst_null
    //   2433: astore 16
    //   2435: goto -486 -> 1949
    //   2438: astore 140
    //   2440: aload 120
    //   2442: astore 16
    //   2444: aload 113
    //   2446: astore 15
    //   2448: aconst_null
    //   2449: astore 18
    //   2451: aconst_null
    //   2452: astore 17
    //   2454: goto -505 -> 1949
    //   2457: astore 134
    //   2459: aload 121
    //   2461: astore 17
    //   2463: aload 120
    //   2465: astore 16
    //   2467: aload 113
    //   2469: astore 15
    //   2471: aconst_null
    //   2472: astore 18
    //   2474: goto -525 -> 1949
    //   2477: astore 123
    //   2479: aload 122
    //   2481: astore 18
    //   2483: aload 121
    //   2485: astore 17
    //   2487: aload 120
    //   2489: astore 16
    //   2491: aload 113
    //   2493: astore 15
    //   2495: goto -546 -> 1949
    //   2498: astore 104
    //   2500: aconst_null
    //   2501: astore 18
    //   2503: aconst_null
    //   2504: astore 17
    //   2506: aconst_null
    //   2507: astore 15
    //   2509: aconst_null
    //   2510: astore 16
    //   2512: goto -936 -> 1576
    //   2515: astore 115
    //   2517: aload 113
    //   2519: astore 15
    //   2521: aconst_null
    //   2522: astore 18
    //   2524: aconst_null
    //   2525: astore 17
    //   2527: aconst_null
    //   2528: astore 16
    //   2530: goto -954 -> 1576
    //   2533: astore 139
    //   2535: aload 120
    //   2537: astore 16
    //   2539: aload 113
    //   2541: astore 15
    //   2543: aconst_null
    //   2544: astore 18
    //   2546: aconst_null
    //   2547: astore 17
    //   2549: goto -973 -> 1576
    //   2552: astore 133
    //   2554: aload 121
    //   2556: astore 17
    //   2558: aload 120
    //   2560: astore 16
    //   2562: aload 113
    //   2564: astore 15
    //   2566: aconst_null
    //   2567: astore 18
    //   2569: goto -993 -> 1576
    //   2572: astore 102
    //   2574: aconst_null
    //   2575: astore 18
    //   2577: aconst_null
    //   2578: astore 17
    //   2580: aconst_null
    //   2581: astore 15
    //   2583: aconst_null
    //   2584: astore 16
    //   2586: goto -1103 -> 1483
    //   2589: astore 114
    //   2591: aload 113
    //   2593: astore 15
    //   2595: aconst_null
    //   2596: astore 18
    //   2598: aconst_null
    //   2599: astore 17
    //   2601: aconst_null
    //   2602: astore 16
    //   2604: goto -1121 -> 1483
    //   2607: astore 138
    //   2609: aload 120
    //   2611: astore 16
    //   2613: aload 113
    //   2615: astore 15
    //   2617: aconst_null
    //   2618: astore 18
    //   2620: aconst_null
    //   2621: astore 17
    //   2623: goto -1140 -> 1483
    //   2626: astore 132
    //   2628: aload 121
    //   2630: astore 17
    //   2632: aload 120
    //   2634: astore 16
    //   2636: aload 113
    //   2638: astore 15
    //   2640: aconst_null
    //   2641: astore 18
    //   2643: goto -1160 -> 1483
    //   2646: astore 47
    //   2648: aload 24
    //   2650: astore 19
    //   2652: aload 47
    //   2654: astore 31
    //   2656: aconst_null
    //   2657: astore 18
    //   2659: aconst_null
    //   2660: astore 17
    //   2662: aconst_null
    //   2663: astore 16
    //   2665: aconst_null
    //   2666: astore 30
    //   2668: goto -1701 -> 967
    //   2671: astore 33
    //   2673: aload 24
    //   2675: astore 19
    //   2677: aload 33
    //   2679: astore 31
    //   2681: goto -1714 -> 967
    //   2684: astore 64
    //   2686: aload 24
    //   2688: astore 19
    //   2690: aload 57
    //   2692: astore 16
    //   2694: aload 64
    //   2696: astore 31
    //   2698: aconst_null
    //   2699: astore 18
    //   2701: aconst_null
    //   2702: astore 17
    //   2704: goto -1737 -> 967
    //   2707: astore 83
    //   2709: aload 67
    //   2711: astore 17
    //   2713: aload 57
    //   2715: astore 16
    //   2717: aload 24
    //   2719: astore 19
    //   2721: aload 83
    //   2723: astore 31
    //   2725: aconst_null
    //   2726: astore 18
    //   2728: goto -1761 -> 967
    //   2731: astore 72
    //   2733: aload 25
    //   2735: astore 18
    //   2737: aload 67
    //   2739: astore 17
    //   2741: aload 57
    //   2743: astore 16
    //   2745: aload 24
    //   2747: astore 19
    //   2749: aload 72
    //   2751: astore 31
    //   2753: goto -1786 -> 967
    //   2756: astore 29
    //   2758: aload 26
    //   2760: astore 17
    //   2762: aload 27
    //   2764: astore 16
    //   2766: aload 28
    //   2768: astore 30
    //   2770: aload 24
    //   2772: astore 19
    //   2774: aload 29
    //   2776: astore 31
    //   2778: aload 25
    //   2780: astore 18
    //   2782: goto -1815 -> 967
    //   2785: astore 46
    //   2787: aconst_null
    //   2788: astore 18
    //   2790: aconst_null
    //   2791: astore 17
    //   2793: aconst_null
    //   2794: astore 16
    //   2796: aconst_null
    //   2797: astore 30
    //   2799: goto -1856 -> 943
    //   2802: astore 56
    //   2804: aconst_null
    //   2805: astore 18
    //   2807: aconst_null
    //   2808: astore 17
    //   2810: aconst_null
    //   2811: astore 16
    //   2813: goto -1870 -> 943
    //   2816: astore 63
    //   2818: aload 57
    //   2820: astore 16
    //   2822: aconst_null
    //   2823: astore 18
    //   2825: aconst_null
    //   2826: astore 17
    //   2828: goto -1885 -> 943
    //   2831: astore 82
    //   2833: aload 67
    //   2835: astore 17
    //   2837: aload 57
    //   2839: astore 16
    //   2841: aconst_null
    //   2842: astore 18
    //   2844: goto -1901 -> 943
    //   2847: astore 71
    //   2849: aload 25
    //   2851: astore 18
    //   2853: aload 67
    //   2855: astore 17
    //   2857: aload 57
    //   2859: astore 16
    //   2861: goto -1918 -> 943
    //   2864: astore 45
    //   2866: aconst_null
    //   2867: astore 18
    //   2869: aconst_null
    //   2870: astore 17
    //   2872: aconst_null
    //   2873: astore 16
    //   2875: aconst_null
    //   2876: astore 30
    //   2878: goto -1961 -> 917
    //   2881: astore 55
    //   2883: aconst_null
    //   2884: astore 18
    //   2886: aconst_null
    //   2887: astore 17
    //   2889: aconst_null
    //   2890: astore 16
    //   2892: goto -1975 -> 917
    //   2895: astore 62
    //   2897: aload 57
    //   2899: astore 16
    //   2901: aconst_null
    //   2902: astore 18
    //   2904: aconst_null
    //   2905: astore 17
    //   2907: goto -1990 -> 917
    //   2910: astore 81
    //   2912: aload 67
    //   2914: astore 17
    //   2916: aload 57
    //   2918: astore 16
    //   2920: aconst_null
    //   2921: astore 18
    //   2923: goto -2006 -> 917
    //   2926: astore 70
    //   2928: aload 25
    //   2930: astore 18
    //   2932: aload 67
    //   2934: astore 17
    //   2936: aload 57
    //   2938: astore 16
    //   2940: goto -2023 -> 917
    //   2943: astore 44
    //   2945: aconst_null
    //   2946: astore 18
    //   2948: aconst_null
    //   2949: astore 17
    //   2951: aconst_null
    //   2952: astore 16
    //   2954: aconst_null
    //   2955: astore 30
    //   2957: goto -2067 -> 890
    //   2960: astore 54
    //   2962: aconst_null
    //   2963: astore 18
    //   2965: aconst_null
    //   2966: astore 17
    //   2968: aconst_null
    //   2969: astore 16
    //   2971: goto -2081 -> 890
    //   2974: astore 61
    //   2976: aload 57
    //   2978: astore 16
    //   2980: aconst_null
    //   2981: astore 18
    //   2983: aconst_null
    //   2984: astore 17
    //   2986: goto -2096 -> 890
    //   2989: astore 80
    //   2991: aload 67
    //   2993: astore 17
    //   2995: aload 57
    //   2997: astore 16
    //   2999: aconst_null
    //   3000: astore 18
    //   3002: goto -2112 -> 890
    //   3005: astore 69
    //   3007: aload 25
    //   3009: astore 18
    //   3011: aload 67
    //   3013: astore 17
    //   3015: aload 57
    //   3017: astore 16
    //   3019: goto -2129 -> 890
    //   3022: astore 43
    //   3024: aconst_null
    //   3025: astore 18
    //   3027: aconst_null
    //   3028: astore 17
    //   3030: aconst_null
    //   3031: astore 16
    //   3033: aconst_null
    //   3034: astore 30
    //   3036: goto -2173 -> 863
    //   3039: astore 53
    //   3041: aconst_null
    //   3042: astore 18
    //   3044: aconst_null
    //   3045: astore 17
    //   3047: aconst_null
    //   3048: astore 16
    //   3050: goto -2187 -> 863
    //   3053: astore 60
    //   3055: aload 57
    //   3057: astore 16
    //   3059: aconst_null
    //   3060: astore 18
    //   3062: aconst_null
    //   3063: astore 17
    //   3065: goto -2202 -> 863
    //   3068: astore 79
    //   3070: aload 67
    //   3072: astore 17
    //   3074: aload 57
    //   3076: astore 16
    //   3078: aconst_null
    //   3079: astore 18
    //   3081: goto -2218 -> 863
    //   3084: astore 68
    //   3086: aload 25
    //   3088: astore 18
    //   3090: aload 67
    //   3092: astore 17
    //   3094: aload 57
    //   3096: astore 16
    //   3098: goto -2235 -> 863
    //   3101: astore 32
    //   3103: aconst_null
    //   3104: astore 24
    //   3106: aconst_null
    //   3107: astore 18
    //   3109: aconst_null
    //   3110: astore 17
    //   3112: aconst_null
    //   3113: astore 16
    //   3115: aconst_null
    //   3116: astore 30
    //   3118: goto -2521 -> 597
    //   3121: astore 42
    //   3123: aconst_null
    //   3124: astore 18
    //   3126: aconst_null
    //   3127: astore 17
    //   3129: aconst_null
    //   3130: astore 16
    //   3132: aconst_null
    //   3133: astore 30
    //   3135: goto -2538 -> 597
    //   3138: astore 52
    //   3140: aconst_null
    //   3141: astore 18
    //   3143: aconst_null
    //   3144: astore 17
    //   3146: aconst_null
    //   3147: astore 16
    //   3149: goto -2552 -> 597
    //   3152: astore 59
    //   3154: aload 57
    //   3156: astore 16
    //   3158: aconst_null
    //   3159: astore 18
    //   3161: aconst_null
    //   3162: astore 17
    //   3164: goto -2567 -> 597
    //   3167: astore 78
    //   3169: aload 67
    //   3171: astore 17
    //   3173: aload 57
    //   3175: astore 16
    //   3177: aconst_null
    //   3178: astore 18
    //   3180: goto -2583 -> 597
    //   3183: astore 23
    //   3185: aconst_null
    //   3186: astore 24
    //   3188: aconst_null
    //   3189: astore 25
    //   3191: aconst_null
    //   3192: astore 26
    //   3194: aconst_null
    //   3195: astore 27
    //   3197: aconst_null
    //   3198: astore 28
    //   3200: goto -2740 -> 460
    //   3203: astore 41
    //   3205: aconst_null
    //   3206: astore 25
    //   3208: aconst_null
    //   3209: astore 26
    //   3211: aconst_null
    //   3212: astore 27
    //   3214: aconst_null
    //   3215: astore 28
    //   3217: goto -2757 -> 460
    //   3220: astore 51
    //   3222: aload 30
    //   3224: astore 28
    //   3226: aconst_null
    //   3227: astore 25
    //   3229: aconst_null
    //   3230: astore 26
    //   3232: aconst_null
    //   3233: astore 27
    //   3235: goto -2775 -> 460
    //   3238: astore 58
    //   3240: aload 57
    //   3242: astore 27
    //   3244: aload 30
    //   3246: astore 28
    //   3248: aconst_null
    //   3249: astore 25
    //   3251: aconst_null
    //   3252: astore 26
    //   3254: goto -2794 -> 460
    //   3257: astore 77
    //   3259: aload 67
    //   3261: astore 26
    //   3263: aload 57
    //   3265: astore 27
    //   3267: aload 30
    //   3269: astore 28
    //   3271: aconst_null
    //   3272: astore 25
    //   3274: goto -2814 -> 460
    //   3277: iconst_1
    //   3278: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   400	407	446	java/lang/NumberFormatException
    //   407	416	446	java/lang/NumberFormatException
    //   422	446	446	java/lang/NumberFormatException
    //   550	560	446	java/lang/NumberFormatException
    //   568	580	446	java/lang/NumberFormatException
    //   616	621	446	java/lang/NumberFormatException
    //   626	656	446	java/lang/NumberFormatException
    //   660	672	446	java/lang/NumberFormatException
    //   687	701	446	java/lang/NumberFormatException
    //   400	407	583	org/apache/http/client/ClientProtocolException
    //   407	416	583	org/apache/http/client/ClientProtocolException
    //   422	446	583	org/apache/http/client/ClientProtocolException
    //   550	560	583	org/apache/http/client/ClientProtocolException
    //   568	580	583	org/apache/http/client/ClientProtocolException
    //   616	621	583	org/apache/http/client/ClientProtocolException
    //   626	656	583	org/apache/http/client/ClientProtocolException
    //   660	672	583	org/apache/http/client/ClientProtocolException
    //   687	701	583	org/apache/http/client/ClientProtocolException
    //   251	260	855	java/lang/IllegalStateException
    //   265	279	855	java/lang/IllegalStateException
    //   287	296	855	java/lang/IllegalStateException
    //   770	795	855	java/lang/IllegalStateException
    //   806	831	855	java/lang/IllegalStateException
    //   842	845	855	java/lang/IllegalStateException
    //   251	260	882	java/io/FileNotFoundException
    //   265	279	882	java/io/FileNotFoundException
    //   287	296	882	java/io/FileNotFoundException
    //   770	795	882	java/io/FileNotFoundException
    //   806	831	882	java/io/FileNotFoundException
    //   842	845	882	java/io/FileNotFoundException
    //   251	260	909	java/io/IOException
    //   265	279	909	java/io/IOException
    //   287	296	909	java/io/IOException
    //   770	795	909	java/io/IOException
    //   806	831	909	java/io/IOException
    //   842	845	909	java/io/IOException
    //   251	260	935	cn/jpush/android/d
    //   265	279	935	cn/jpush/android/d
    //   287	296	935	cn/jpush/android/d
    //   770	795	935	cn/jpush/android/d
    //   806	831	935	cn/jpush/android/d
    //   842	845	935	cn/jpush/android/d
    //   251	260	962	finally
    //   265	279	962	finally
    //   287	296	962	finally
    //   770	795	962	finally
    //   806	831	962	finally
    //   842	845	962	finally
    //   1008	1044	1121	org/apache/http/client/ClientProtocolException
    //   1048	1060	1121	org/apache/http/client/ClientProtocolException
    //   1063	1116	1121	org/apache/http/client/ClientProtocolException
    //   1008	1044	1129	java/io/IOException
    //   1048	1060	1129	java/io/IOException
    //   1063	1116	1129	java/io/IOException
    //   1008	1044	1136	cn/jpush/android/d
    //   1048	1060	1136	cn/jpush/android/d
    //   1063	1116	1136	cn/jpush/android/d
    //   1419	1426	1465	java/lang/NumberFormatException
    //   1426	1435	1465	java/lang/NumberFormatException
    //   1441	1465	1465	java/lang/NumberFormatException
    //   1525	1535	1465	java/lang/NumberFormatException
    //   1543	1555	1465	java/lang/NumberFormatException
    //   1595	1603	1465	java/lang/NumberFormatException
    //   1608	1638	1465	java/lang/NumberFormatException
    //   1642	1654	1465	java/lang/NumberFormatException
    //   1669	1683	1465	java/lang/NumberFormatException
    //   1508	1514	1517	java/io/IOException
    //   1419	1426	1558	org/apache/http/client/ClientProtocolException
    //   1426	1435	1558	org/apache/http/client/ClientProtocolException
    //   1441	1465	1558	org/apache/http/client/ClientProtocolException
    //   1525	1535	1558	org/apache/http/client/ClientProtocolException
    //   1543	1555	1558	org/apache/http/client/ClientProtocolException
    //   1595	1603	1558	org/apache/http/client/ClientProtocolException
    //   1608	1638	1558	org/apache/http/client/ClientProtocolException
    //   1642	1654	1558	org/apache/http/client/ClientProtocolException
    //   1669	1683	1558	org/apache/http/client/ClientProtocolException
    //   1247	1256	1947	java/lang/IllegalStateException
    //   1276	1290	1947	java/lang/IllegalStateException
    //   1306	1324	1947	java/lang/IllegalStateException
    //   1341	1354	1947	java/lang/IllegalStateException
    //   1371	1380	1947	java/lang/IllegalStateException
    //   1729	1748	1947	java/lang/IllegalStateException
    //   1765	1768	1947	java/lang/IllegalStateException
    //   1779	1782	1947	java/lang/IllegalStateException
    //   1802	1821	1947	java/lang/IllegalStateException
    //   1841	1844	1947	java/lang/IllegalStateException
    //   1862	1887	1947	java/lang/IllegalStateException
    //   1898	1923	1947	java/lang/IllegalStateException
    //   1934	1937	1947	java/lang/IllegalStateException
    //   1247	1256	1968	java/io/FileNotFoundException
    //   1276	1290	1968	java/io/FileNotFoundException
    //   1306	1324	1968	java/io/FileNotFoundException
    //   1341	1354	1968	java/io/FileNotFoundException
    //   1371	1380	1968	java/io/FileNotFoundException
    //   1729	1748	1968	java/io/FileNotFoundException
    //   1765	1768	1968	java/io/FileNotFoundException
    //   1779	1782	1968	java/io/FileNotFoundException
    //   1802	1821	1968	java/io/FileNotFoundException
    //   1841	1844	1968	java/io/FileNotFoundException
    //   1862	1887	1968	java/io/FileNotFoundException
    //   1898	1923	1968	java/io/FileNotFoundException
    //   1934	1937	1968	java/io/FileNotFoundException
    //   1247	1256	1989	java/io/IOException
    //   1276	1290	1989	java/io/IOException
    //   1306	1324	1989	java/io/IOException
    //   1341	1354	1989	java/io/IOException
    //   1371	1380	1989	java/io/IOException
    //   1729	1748	1989	java/io/IOException
    //   1765	1768	1989	java/io/IOException
    //   1779	1782	1989	java/io/IOException
    //   1802	1821	1989	java/io/IOException
    //   1841	1844	1989	java/io/IOException
    //   1862	1887	1989	java/io/IOException
    //   1898	1923	1989	java/io/IOException
    //   1934	1937	1989	java/io/IOException
    //   1247	1256	2009	cn/jpush/android/d
    //   1276	1290	2009	cn/jpush/android/d
    //   1306	1324	2009	cn/jpush/android/d
    //   1341	1354	2009	cn/jpush/android/d
    //   1371	1380	2009	cn/jpush/android/d
    //   1729	1748	2009	cn/jpush/android/d
    //   1765	1768	2009	cn/jpush/android/d
    //   1779	1782	2009	cn/jpush/android/d
    //   1802	1821	2009	cn/jpush/android/d
    //   1841	1844	2009	cn/jpush/android/d
    //   1862	1887	2009	cn/jpush/android/d
    //   1898	1923	2009	cn/jpush/android/d
    //   1934	1937	2009	cn/jpush/android/d
    //   1247	1256	2030	finally
    //   1276	1290	2030	finally
    //   1306	1324	2030	finally
    //   1341	1354	2030	finally
    //   1371	1380	2030	finally
    //   1483	1486	2030	finally
    //   1576	1579	2030	finally
    //   1729	1748	2030	finally
    //   1765	1768	2030	finally
    //   1779	1782	2030	finally
    //   1802	1821	2030	finally
    //   1841	1844	2030	finally
    //   1862	1887	2030	finally
    //   1898	1923	2030	finally
    //   1934	1937	2030	finally
    //   1949	1952	2030	finally
    //   1970	1973	2030	finally
    //   1991	1994	2030	finally
    //   2011	2014	2030	finally
    //   1385	1396	2104	finally
    //   1714	1717	2104	finally
    //   1396	1408	2122	finally
    //   1408	1419	2141	finally
    //   1419	1426	2161	finally
    //   1426	1435	2161	finally
    //   1441	1465	2161	finally
    //   1525	1535	2161	finally
    //   1543	1555	2161	finally
    //   1595	1603	2161	finally
    //   1608	1638	2161	finally
    //   1642	1654	2161	finally
    //   1669	1683	2161	finally
    //   1385	1396	2186	cn/jpush/android/d
    //   1714	1717	2186	cn/jpush/android/d
    //   1396	1408	2204	cn/jpush/android/d
    //   1408	1419	2223	cn/jpush/android/d
    //   1419	1426	2243	cn/jpush/android/d
    //   1426	1435	2243	cn/jpush/android/d
    //   1441	1465	2243	cn/jpush/android/d
    //   1525	1535	2243	cn/jpush/android/d
    //   1543	1555	2243	cn/jpush/android/d
    //   1595	1603	2243	cn/jpush/android/d
    //   1608	1638	2243	cn/jpush/android/d
    //   1642	1654	2243	cn/jpush/android/d
    //   1669	1683	2243	cn/jpush/android/d
    //   1385	1396	2264	java/io/IOException
    //   1714	1717	2264	java/io/IOException
    //   1396	1408	2282	java/io/IOException
    //   1408	1419	2301	java/io/IOException
    //   1419	1426	2321	java/io/IOException
    //   1426	1435	2321	java/io/IOException
    //   1441	1465	2321	java/io/IOException
    //   1525	1535	2321	java/io/IOException
    //   1543	1555	2321	java/io/IOException
    //   1595	1603	2321	java/io/IOException
    //   1608	1638	2321	java/io/IOException
    //   1642	1654	2321	java/io/IOException
    //   1669	1683	2321	java/io/IOException
    //   1385	1396	2342	java/io/FileNotFoundException
    //   1714	1717	2342	java/io/FileNotFoundException
    //   1396	1408	2360	java/io/FileNotFoundException
    //   1408	1419	2379	java/io/FileNotFoundException
    //   1419	1426	2399	java/io/FileNotFoundException
    //   1426	1435	2399	java/io/FileNotFoundException
    //   1441	1465	2399	java/io/FileNotFoundException
    //   1525	1535	2399	java/io/FileNotFoundException
    //   1543	1555	2399	java/io/FileNotFoundException
    //   1595	1603	2399	java/io/FileNotFoundException
    //   1608	1638	2399	java/io/FileNotFoundException
    //   1642	1654	2399	java/io/FileNotFoundException
    //   1669	1683	2399	java/io/FileNotFoundException
    //   1385	1396	2420	java/lang/IllegalStateException
    //   1714	1717	2420	java/lang/IllegalStateException
    //   1396	1408	2438	java/lang/IllegalStateException
    //   1408	1419	2457	java/lang/IllegalStateException
    //   1419	1426	2477	java/lang/IllegalStateException
    //   1426	1435	2477	java/lang/IllegalStateException
    //   1441	1465	2477	java/lang/IllegalStateException
    //   1525	1535	2477	java/lang/IllegalStateException
    //   1543	1555	2477	java/lang/IllegalStateException
    //   1595	1603	2477	java/lang/IllegalStateException
    //   1608	1638	2477	java/lang/IllegalStateException
    //   1642	1654	2477	java/lang/IllegalStateException
    //   1669	1683	2477	java/lang/IllegalStateException
    //   1247	1256	2498	org/apache/http/client/ClientProtocolException
    //   1276	1290	2498	org/apache/http/client/ClientProtocolException
    //   1306	1324	2498	org/apache/http/client/ClientProtocolException
    //   1341	1354	2498	org/apache/http/client/ClientProtocolException
    //   1371	1380	2498	org/apache/http/client/ClientProtocolException
    //   1729	1748	2498	org/apache/http/client/ClientProtocolException
    //   1765	1768	2498	org/apache/http/client/ClientProtocolException
    //   1779	1782	2498	org/apache/http/client/ClientProtocolException
    //   1802	1821	2498	org/apache/http/client/ClientProtocolException
    //   1841	1844	2498	org/apache/http/client/ClientProtocolException
    //   1862	1887	2498	org/apache/http/client/ClientProtocolException
    //   1898	1923	2498	org/apache/http/client/ClientProtocolException
    //   1934	1937	2498	org/apache/http/client/ClientProtocolException
    //   1385	1396	2515	org/apache/http/client/ClientProtocolException
    //   1714	1717	2515	org/apache/http/client/ClientProtocolException
    //   1396	1408	2533	org/apache/http/client/ClientProtocolException
    //   1408	1419	2552	org/apache/http/client/ClientProtocolException
    //   1247	1256	2572	java/lang/NumberFormatException
    //   1276	1290	2572	java/lang/NumberFormatException
    //   1306	1324	2572	java/lang/NumberFormatException
    //   1341	1354	2572	java/lang/NumberFormatException
    //   1371	1380	2572	java/lang/NumberFormatException
    //   1729	1748	2572	java/lang/NumberFormatException
    //   1765	1768	2572	java/lang/NumberFormatException
    //   1779	1782	2572	java/lang/NumberFormatException
    //   1802	1821	2572	java/lang/NumberFormatException
    //   1841	1844	2572	java/lang/NumberFormatException
    //   1862	1887	2572	java/lang/NumberFormatException
    //   1898	1923	2572	java/lang/NumberFormatException
    //   1934	1937	2572	java/lang/NumberFormatException
    //   1385	1396	2589	java/lang/NumberFormatException
    //   1714	1717	2589	java/lang/NumberFormatException
    //   1396	1408	2607	java/lang/NumberFormatException
    //   1408	1419	2626	java/lang/NumberFormatException
    //   300	346	2646	finally
    //   747	750	2646	finally
    //   355	366	2671	finally
    //   597	600	2671	finally
    //   732	735	2671	finally
    //   863	866	2671	finally
    //   890	893	2671	finally
    //   917	920	2671	finally
    //   943	946	2671	finally
    //   366	389	2684	finally
    //   389	400	2707	finally
    //   400	407	2731	finally
    //   407	416	2731	finally
    //   422	446	2731	finally
    //   550	560	2731	finally
    //   568	580	2731	finally
    //   616	621	2731	finally
    //   626	656	2731	finally
    //   660	672	2731	finally
    //   687	701	2731	finally
    //   460	463	2756	finally
    //   300	346	2785	cn/jpush/android/d
    //   747	750	2785	cn/jpush/android/d
    //   355	366	2802	cn/jpush/android/d
    //   732	735	2802	cn/jpush/android/d
    //   366	389	2816	cn/jpush/android/d
    //   389	400	2831	cn/jpush/android/d
    //   400	407	2847	cn/jpush/android/d
    //   407	416	2847	cn/jpush/android/d
    //   422	446	2847	cn/jpush/android/d
    //   550	560	2847	cn/jpush/android/d
    //   568	580	2847	cn/jpush/android/d
    //   616	621	2847	cn/jpush/android/d
    //   626	656	2847	cn/jpush/android/d
    //   660	672	2847	cn/jpush/android/d
    //   687	701	2847	cn/jpush/android/d
    //   300	346	2864	java/io/IOException
    //   747	750	2864	java/io/IOException
    //   355	366	2881	java/io/IOException
    //   732	735	2881	java/io/IOException
    //   366	389	2895	java/io/IOException
    //   389	400	2910	java/io/IOException
    //   400	407	2926	java/io/IOException
    //   407	416	2926	java/io/IOException
    //   422	446	2926	java/io/IOException
    //   550	560	2926	java/io/IOException
    //   568	580	2926	java/io/IOException
    //   616	621	2926	java/io/IOException
    //   626	656	2926	java/io/IOException
    //   660	672	2926	java/io/IOException
    //   687	701	2926	java/io/IOException
    //   300	346	2943	java/io/FileNotFoundException
    //   747	750	2943	java/io/FileNotFoundException
    //   355	366	2960	java/io/FileNotFoundException
    //   732	735	2960	java/io/FileNotFoundException
    //   366	389	2974	java/io/FileNotFoundException
    //   389	400	2989	java/io/FileNotFoundException
    //   400	407	3005	java/io/FileNotFoundException
    //   407	416	3005	java/io/FileNotFoundException
    //   422	446	3005	java/io/FileNotFoundException
    //   550	560	3005	java/io/FileNotFoundException
    //   568	580	3005	java/io/FileNotFoundException
    //   616	621	3005	java/io/FileNotFoundException
    //   626	656	3005	java/io/FileNotFoundException
    //   660	672	3005	java/io/FileNotFoundException
    //   687	701	3005	java/io/FileNotFoundException
    //   300	346	3022	java/lang/IllegalStateException
    //   747	750	3022	java/lang/IllegalStateException
    //   355	366	3039	java/lang/IllegalStateException
    //   732	735	3039	java/lang/IllegalStateException
    //   366	389	3053	java/lang/IllegalStateException
    //   389	400	3068	java/lang/IllegalStateException
    //   400	407	3084	java/lang/IllegalStateException
    //   407	416	3084	java/lang/IllegalStateException
    //   422	446	3084	java/lang/IllegalStateException
    //   550	560	3084	java/lang/IllegalStateException
    //   568	580	3084	java/lang/IllegalStateException
    //   616	621	3084	java/lang/IllegalStateException
    //   626	656	3084	java/lang/IllegalStateException
    //   660	672	3084	java/lang/IllegalStateException
    //   687	701	3084	java/lang/IllegalStateException
    //   251	260	3101	org/apache/http/client/ClientProtocolException
    //   265	279	3101	org/apache/http/client/ClientProtocolException
    //   287	296	3101	org/apache/http/client/ClientProtocolException
    //   770	795	3101	org/apache/http/client/ClientProtocolException
    //   806	831	3101	org/apache/http/client/ClientProtocolException
    //   842	845	3101	org/apache/http/client/ClientProtocolException
    //   300	346	3121	org/apache/http/client/ClientProtocolException
    //   747	750	3121	org/apache/http/client/ClientProtocolException
    //   355	366	3138	org/apache/http/client/ClientProtocolException
    //   732	735	3138	org/apache/http/client/ClientProtocolException
    //   366	389	3152	org/apache/http/client/ClientProtocolException
    //   389	400	3167	org/apache/http/client/ClientProtocolException
    //   251	260	3183	java/lang/NumberFormatException
    //   265	279	3183	java/lang/NumberFormatException
    //   287	296	3183	java/lang/NumberFormatException
    //   770	795	3183	java/lang/NumberFormatException
    //   806	831	3183	java/lang/NumberFormatException
    //   842	845	3183	java/lang/NumberFormatException
    //   300	346	3203	java/lang/NumberFormatException
    //   747	750	3203	java/lang/NumberFormatException
    //   355	366	3220	java/lang/NumberFormatException
    //   732	735	3220	java/lang/NumberFormatException
    //   366	389	3238	java/lang/NumberFormatException
    //   389	400	3257	java/lang/NumberFormatException
  }

  private static long a(HttpResponse paramHttpResponse)
  {
    long l = Long.valueOf(paramHttpResponse.getFirstHeader(z[23]).getValue()).longValue();
    if (l <= 0L)
      throw new cn.jpush.android.d(z[24]);
    return l;
  }

  private static HttpGet a(String paramString, long paramLong)
  {
    HttpGet localHttpGet = new HttpGet(paramString);
    localHttpGet.addHeader(z[9], z[7]);
    localHttpGet.addHeader(z[5], z[4]);
    if (paramLong >= 0L)
      localHttpGet.addHeader(z[8], z[6] + paramLong + "-");
    return localHttpGet;
  }

  private static DefaultHttpClient a()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, z[0]);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    return new DefaultHttpClient(localBasicHttpParams);
  }

  private static void a(InputStream paramInputStream, BufferedInputStream paramBufferedInputStream, FileOutputStream paramFileOutputStream, BufferedOutputStream paramBufferedOutputStream, HttpEntity paramHttpEntity)
  {
    if (paramBufferedOutputStream != null);
    try
    {
      paramBufferedOutputStream.close();
      if (paramFileOutputStream == null);
    }
    catch (IOException localIOException2)
    {
      try
      {
        paramFileOutputStream.close();
        if (paramBufferedInputStream == null);
      }
      catch (IOException localIOException2)
      {
        try
        {
          paramBufferedInputStream.close();
          if (paramInputStream == null);
        }
        catch (IOException localIOException2)
        {
          try
          {
            paramInputStream.close();
            if (paramHttpEntity == null);
          }
          catch (IOException localIOException2)
          {
            try
            {
              while (true)
              {
                paramHttpEntity.consumeContent();
                return;
                localIOException5 = localIOException5;
                continue;
                localIOException4 = localIOException4;
                continue;
                localIOException3 = localIOException3;
              }
              localIOException2 = localIOException2;
            }
            catch (IOException localIOException1)
            {
            }
          }
        }
      }
    }
  }

  public static boolean a(int paramInt)
  {
    return (2 == paramInt) || (3 == paramInt);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.a
 * JD-Core Version:    0.6.2
 */