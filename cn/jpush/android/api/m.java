package cn.jpush.android.api;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.data.d;
import cn.jpush.android.data.s;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.k;
import cn.jpush.android.util.x;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.zip.Adler32;

public final class m
{
  private static Queue<Integer> a;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[41];
    int i = 0;
    String str1 = "";
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
        i3 = 91;
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
        str1 = "\020UWC5\030UAF{\022VOC/TJHM/\033\032FC2\030_DＮ2\031[GG\016\006V\032\002";
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
        str1 = "\032UTK=\035YAV2\033T";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024mq\034+sd";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "[SCM5";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\026UD[";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "\025JP";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024IL/\021TT\f\025;nid\0227{tk\024:eor\036:d";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024IL/\021TT\f\025;nid\0227{tk\024:eor\036:d}\013&ux{u";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = ":UTK=\035YAV2\033ThG7\004_R";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024an\036&n";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024ez\017&{";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024nm\017=|ia\032 sol\004 cpg";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024IL/\021TT\f\b-itg\026+|un\027'yrg\036:ecc\0171}op\002";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "\032UTK=\025YTK4\032eNW6";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024nm\017=|ia\032 sol\0040vg\027;jep\0045hg\022";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024IL/\021TT\f\b-itg\026+|un\027'yrg\036:eaa\017=un";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024pw\b<eif";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024nm\017=|ia\032 sol\0047unv\036:nv\022 ve";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024nm\017=|ia\032 sol\004=~";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024IL/\021TT\f\b<uw}\0358uav\004\"seu\0045ytk\024:";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        i = 25;
        str1 = "Zh";
        j = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i] = str2;
        i = 26;
        str1 = "";
        j = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i] = str2;
        i = 27;
        str1 = "&\036IF";
        j = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i] = str2;
        i = 28;
        str1 = "\007NAV>+XAP\004\035WAE>+LIG,";
        j = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i] = str2;
        i = 29;
        str1 = "&\036LC\"\033OT";
        j = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[i] = str2;
        i = 30;
        str1 = "\034NTRa[\025";
        j = 29;
        localObject1 = localObject2;
        break;
      case 29:
        localObject1[i] = str2;
        i = 31;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024hv\0268erg\b";
        j = 30;
        localObject1 = localObject2;
        break;
      case 30:
        localObject1[i] = str2;
        i = 32;
        str1 = "\022SLGa[\025";
        j = 31;
        localObject1 = localObject2;
        break;
      case 31:
        localObject1[i] = str2;
        i = 33;
        str1 = "'_NF{\004OSJ{\006_CG2\002_D\0029\006UAF8\025IT\002/\033\032DG-\021VOR>\006\032DG=\035TEF{\006_CG2\002_R";
        j = 32;
        localObject1 = localObject2;
        break;
      case 32:
        localObject1[i] = str2;
        i = 34;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024IL/\021TT\f\025;nid\0227{tk\024:erg\0301svg\037";
        j = 33;
        localObject1 = localObject2;
        break;
      case 33:
        localObject1[i] = str2;
        i = 35;
        str1 = "\027T\016H+\001IH\f:\032^RM2\020\024hv\0268epc\017<";
        j = 34;
        localObject1 = localObject2;
        break;
      case 34:
        localObject1[i] = str2;
        i = 36;
        str1 = "ZJEP6\035ISK4\032\024jr\016'ro\036'iae\036";
        j = 35;
        localObject1 = localObject2;
        break;
      case 35:
        localObject1[i] = str2;
        i = 37;
        str1 = "";
        j = 36;
        localObject1 = localObject2;
        break;
      case 36:
        localObject1[i] = str2;
        i = 38;
        str1 = "\036JUQ3+TOV2\022SCC/\035UN}2\027UN";
        j = 37;
        localObject1 = localObject2;
        break;
      case 37:
        localObject1[i] = str2;
        i = 39;
        str1 = "&\036DP:\003[BN>";
        j = 38;
        localObject1 = localObject2;
        break;
      case 38:
        localObject1[i] = str2;
        i = 40;
        str1 = "";
        j = 39;
        localObject1 = localObject2;
        break;
      case 39:
        localObject1[i] = str2;
        z = localObject2;
        a = new LinkedList();
        return;
        i3 = 116;
        continue;
        i3 = 58;
        continue;
        i3 = 32;
        continue;
        i3 = 34;
      }
    }
  }

  public static int a(int paramInt)
  {
    int i = 17301586;
    switch (paramInt)
    {
    case 1:
    default:
    case -1:
      while (true)
      {
        return i;
        String str = z[39];
        String[] arrayOfString = new String[1];
        arrayOfString[0] = z[38];
        HashMap localHashMap = a(str, arrayOfString);
        try
        {
          int j = ((Integer)localHashMap.get(z[38])).intValue();
          i = j;
          if (i <= 0)
            return 17301618;
        }
        catch (Exception localException)
        {
          while (true)
          {
            x.f();
            i = 0;
          }
        }
      }
    case 0:
      return 17301647;
    case 2:
      return 17301618;
    case 3:
    }
    return 17301567;
  }

  public static int a(d paramd, int paramInt)
  {
    String str = paramd.c;
    if (!ai.a(paramd.d))
      str = paramd.d;
    return a(str, paramInt);
  }

  private static int a(String paramString, int paramInt)
  {
    int j;
    if (TextUtils.isEmpty(paramString))
    {
      x.c();
      j = 0;
    }
    do
    {
      return j;
      try
      {
        int k = Integer.valueOf(paramString).intValue();
        return k;
      }
      catch (Exception localException)
      {
        x.f();
        Adler32 localAdler32 = new Adler32();
        localAdler32.update(paramString.getBytes());
        int i = (int)localAdler32.getValue();
        if (i < 0)
          i = Math.abs(i);
        j = i + 13889152 * paramInt;
      }
    }
    while (j >= 0);
    return Math.abs(j);
  }

  // ERROR //
  public static Notification a(Context paramContext, int paramInt, Intent paramIntent, d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iload 4
    //   2: ifeq +446 -> 448
    //   5: invokestatic 168	cn/jpush/android/util/x:c	()V
    //   8: aload_0
    //   9: invokevirtual 202	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   12: aload_0
    //   13: invokevirtual 205	android/content/Context:getPackageName	()Ljava/lang/String;
    //   16: sipush 256
    //   19: invokevirtual 211	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   22: getfield 217	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   25: getfield 223	android/content/pm/ApplicationInfo:icon	I
    //   28: istore 6
    //   30: iload 6
    //   32: ifge +12 -> 44
    //   35: aload_3
    //   36: getfield 226	cn/jpush/android/data/d:x	I
    //   39: invokestatic 228	cn/jpush/android/api/m:a	(I)I
    //   42: istore 6
    //   44: new 230	android/app/Notification
    //   47: dup
    //   48: invokespecial 231	android/app/Notification:<init>	()V
    //   51: astore 7
    //   53: aload 7
    //   55: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   58: putfield 240	android/app/Notification:when	J
    //   61: aload 7
    //   63: iload 6
    //   65: putfield 241	android/app/Notification:icon	I
    //   68: aload 7
    //   70: aload_3
    //   71: getfield 244	cn/jpush/android/data/d:B	Ljava/lang/String;
    //   74: putfield 248	android/app/Notification:tickerText	Ljava/lang/CharSequence;
    //   77: aload 7
    //   79: aload_3
    //   80: getfield 250	cn/jpush/android/data/d:z	I
    //   83: invokestatic 253	cn/jpush/android/api/m:b	(I)I
    //   86: putfield 256	android/app/Notification:flags	I
    //   89: aload_3
    //   90: getfield 259	cn/jpush/android/data/d:p	I
    //   93: tableswitch	default:+31 -> 124, 0:+293->386, 1:+281->374, 2:+287->380, 3:+299->392
    //   125: istore 8
    //   127: aload 7
    //   129: iload 8
    //   131: putfield 262	android/app/Notification:defaults	I
    //   134: aload_3
    //   135: getfield 266	cn/jpush/android/data/d:h	Z
    //   138: ifeq +22 -> 160
    //   141: aload 7
    //   143: iconst_3
    //   144: putfield 262	android/app/Notification:defaults	I
    //   147: aload_0
    //   148: invokestatic 271	cn/jpush/android/util/a:p	(Landroid/content/Context;)Z
    //   151: ifeq +9 -> 160
    //   154: aload 7
    //   156: iconst_0
    //   157: putfield 262	android/app/Notification:defaults	I
    //   160: iload 5
    //   162: ifeq +236 -> 398
    //   165: aload_0
    //   166: iload_1
    //   167: aload_2
    //   168: ldc_w 272
    //   171: invokestatic 278	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   174: astore 9
    //   176: aload_3
    //   177: getfield 281	cn/jpush/android/data/d:Q	Ljava/lang/String;
    //   180: invokestatic 157	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   183: ifne +246 -> 429
    //   186: aload_3
    //   187: getfield 281	cn/jpush/android/data/d:Q	Ljava/lang/String;
    //   190: invokestatic 287	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   193: astore 11
    //   195: aload 11
    //   197: ifnull +220 -> 417
    //   200: getstatic 109	cn/jpush/android/api/m:z	[Ljava/lang/String;
    //   203: bipush 27
    //   205: aaload
    //   206: astore 12
    //   208: iconst_1
    //   209: anewarray 13	java/lang/String
    //   212: astore 13
    //   214: aload 13
    //   216: iconst_0
    //   217: getstatic 109	cn/jpush/android/api/m:z	[Ljava/lang/String;
    //   220: bipush 28
    //   222: aaload
    //   223: aastore
    //   224: aload 12
    //   226: aload 13
    //   228: invokestatic 122	cn/jpush/android/api/m:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/HashMap;
    //   231: getstatic 109	cn/jpush/android/api/m:z	[Ljava/lang/String;
    //   234: bipush 28
    //   236: aaload
    //   237: invokevirtual 128	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   240: checkcast 130	java/lang/Integer
    //   243: astore 14
    //   245: getstatic 109	cn/jpush/android/api/m:z	[Ljava/lang/String;
    //   248: bipush 29
    //   250: aaload
    //   251: astore 15
    //   253: iconst_1
    //   254: anewarray 13	java/lang/String
    //   257: astore 16
    //   259: aload 16
    //   261: iconst_0
    //   262: getstatic 109	cn/jpush/android/api/m:z	[Ljava/lang/String;
    //   265: bipush 26
    //   267: aaload
    //   268: aastore
    //   269: aload 15
    //   271: aload 16
    //   273: invokestatic 122	cn/jpush/android/api/m:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/util/HashMap;
    //   276: getstatic 109	cn/jpush/android/api/m:z	[Ljava/lang/String;
    //   279: bipush 26
    //   281: aaload
    //   282: invokevirtual 128	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   285: checkcast 130	java/lang/Integer
    //   288: astore 17
    //   290: aload 14
    //   292: ifnull +120 -> 412
    //   295: aload 17
    //   297: ifnull +115 -> 412
    //   300: aload 14
    //   302: invokevirtual 134	java/lang/Integer:intValue	()I
    //   305: ifle +107 -> 412
    //   308: aload 17
    //   310: invokevirtual 134	java/lang/Integer:intValue	()I
    //   313: ifle +99 -> 412
    //   316: new 289	android/widget/RemoteViews
    //   319: dup
    //   320: aload_0
    //   321: invokevirtual 205	android/content/Context:getPackageName	()Ljava/lang/String;
    //   324: aload 17
    //   326: invokevirtual 134	java/lang/Integer:intValue	()I
    //   329: invokespecial 292	android/widget/RemoteViews:<init>	(Ljava/lang/String;I)V
    //   332: astore 18
    //   334: aload 18
    //   336: aload 14
    //   338: invokevirtual 134	java/lang/Integer:intValue	()I
    //   341: aload 11
    //   343: invokevirtual 296	android/widget/RemoteViews:setImageViewBitmap	(ILandroid/graphics/Bitmap;)V
    //   346: aload 7
    //   348: aload 18
    //   350: putfield 300	android/app/Notification:contentView	Landroid/widget/RemoteViews;
    //   353: aload 7
    //   355: aload 9
    //   357: putfield 304	android/app/Notification:contentIntent	Landroid/app/PendingIntent;
    //   360: aload 7
    //   362: areturn
    //   363: astore 19
    //   365: iconst_m1
    //   366: istore 6
    //   368: invokestatic 306	cn/jpush/android/util/x:h	()V
    //   371: goto -341 -> 30
    //   374: iconst_1
    //   375: istore 8
    //   377: goto -250 -> 127
    //   380: iconst_2
    //   381: istore 8
    //   383: goto -256 -> 127
    //   386: iconst_m1
    //   387: istore 8
    //   389: goto -262 -> 127
    //   392: iconst_4
    //   393: istore 8
    //   395: goto -268 -> 127
    //   398: aload_0
    //   399: iload_1
    //   400: aload_2
    //   401: ldc_w 272
    //   404: invokestatic 309	android/app/PendingIntent:getActivity	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   407: astore 9
    //   409: goto -233 -> 176
    //   412: invokestatic 312	cn/jpush/android/util/x:e	()V
    //   415: aconst_null
    //   416: areturn
    //   417: invokestatic 312	cn/jpush/android/util/x:e	()V
    //   420: aconst_null
    //   421: areturn
    //   422: astore 10
    //   424: invokestatic 315	cn/jpush/android/util/x:i	()V
    //   427: aconst_null
    //   428: areturn
    //   429: aload 7
    //   431: aload_0
    //   432: aload_3
    //   433: getfield 318	cn/jpush/android/data/d:A	Ljava/lang/String;
    //   436: aload_3
    //   437: getfield 244	cn/jpush/android/data/d:B	Ljava/lang/String;
    //   440: aload 9
    //   442: invokevirtual 322	android/app/Notification:setLatestEventInfo	(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V
    //   445: goto -85 -> 360
    //   448: iconst_m1
    //   449: istore 6
    //   451: goto -421 -> 30
    //
    // Exception table:
    //   from	to	target	type
    //   8	30	363	android/content/pm/PackageManager$NameNotFoundException
    //   186	195	422	java/lang/Exception
    //   200	290	422	java/lang/Exception
    //   300	360	422	java/lang/Exception
    //   412	415	422	java/lang/Exception
    //   417	420	422	java/lang/Exception
  }

  public static HashMap<String, Integer> a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    if ((ai.a(paramString)) || (paramArrayOfString == null) || (paramArrayOfString.length == 0))
      throw new NullPointerException(z[24]);
    HashMap localHashMap = new HashMap();
    try
    {
      String str1 = cn.jpush.android.a.d.getPackageName();
      for (Class localClass : Class.forName(str1 + z[25]).getDeclaredClasses())
        if (localClass.getName().contains(paramString))
        {
          int m = paramArrayOfString.length;
          while (i < m)
          {
            String str2 = paramArrayOfString[i];
            localHashMap.put(str2, Integer.valueOf(localClass.getDeclaredField(str2).getInt(str2)));
            i++;
          }
        }
    }
    catch (Exception localException)
    {
      x.i();
    }
    return localHashMap;
  }

  public static void a(Context paramContext)
  {
    while (true)
    {
      Integer localInteger = (Integer)a.poll();
      if (localInteger == null)
        break;
      a(paramContext, localInteger.intValue());
    }
  }

  public static void a(Context paramContext, int paramInt)
  {
    new StringBuilder(z[2]).append(paramInt).toString();
    x.c();
    if (paramContext == null)
      paramContext = cn.jpush.android.a.d;
    ((NotificationManager)paramContext.getSystemService(z[3])).cancel(paramInt);
  }

  public static void a(Context paramContext, d paramd)
  {
    if (Thread.currentThread().getId() == PushService.a)
    {
      x.d();
      new Thread(new n(paramContext, paramd)).start();
      return;
    }
    b(paramContext, paramd);
  }

  public static void a(Context paramContext, d paramd, int paramInt)
  {
    new StringBuilder(z[37]).append(paramd.c).toString();
    x.c();
    if (paramContext == null)
      paramContext = cn.jpush.android.a.d;
    ((NotificationManager)paramContext.getSystemService(z[3])).cancel(a(paramd, paramInt));
  }

  public static void a(Context paramContext, d paramd, boolean paramBoolean1, boolean paramBoolean2)
  {
    x.b();
    int i = a(paramd, 0);
    if ((paramd.h) && (paramd.e))
    {
      NotificationManager localNotificationManager2 = (NotificationManager)paramContext.getSystemService(z[3]);
      String str2;
      String str3;
      String str4;
      if ((paramd instanceof s))
      {
        str2 = paramd.B;
        str3 = paramd.A;
        str4 = paramd.l;
        if (!ai.a(paramd.m))
          break label233;
      }
      HashMap localHashMap;
      label233: for (String str5 = paramContext.getPackageName(); ; str5 = paramd.m)
      {
        localHashMap = new HashMap();
        localHashMap.put(z[20], paramd.c);
        localHashMap.put(z[5], paramd.c);
        localHashMap.put(z[12], str2);
        if (!TextUtils.isEmpty(str3))
          localHashMap.put(z[21], str3);
        if (!ai.a(str4))
          localHashMap.put(z[13], str4);
        if (!ai.a(str4))
          localHashMap.put(z[13], str4);
        if (!ai.a(str2))
          break;
        a(paramContext, localHashMap, 0, "", str5, paramd);
        return;
      }
      PushNotificationBuilder localPushNotificationBuilder = JPushInterface.b(paramd.f);
      String str6 = localPushNotificationBuilder.a();
      Notification localNotification2 = localPushNotificationBuilder.a(str2, localHashMap);
      if ((localNotification2 != null) && (!ai.a(str2)))
      {
        Intent localIntent2;
        if (!paramd.f())
          if (cn.jpush.android.util.a.d(paramContext, PushReceiver.class.getCanonicalName()))
          {
            localIntent2 = new Intent(z[10] + UUID.randomUUID().toString());
            localIntent2.setClass(paramContext, PushReceiver.class);
            localIntent2.putExtra(z[14], paramd.g);
          }
        while (true)
        {
          a(localIntent2, localHashMap, i);
          localIntent2.putExtra(z[12], str2);
          localIntent2.putExtra(z[8], str5);
          if (!ai.a(str6))
            localIntent2.putExtra(z[18], str6);
          PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent2, 1073741824);
          localNotification2.contentIntent = localPendingIntent;
          if (!JPushInterface.a(paramd.f))
          {
            if (1 == paramd.g)
              paramd.z = 1;
            localNotification2.flags = b(paramd.z);
            if (localNotification2.defaults == 0)
              localNotification2.defaults = 3;
          }
          if (cn.jpush.android.util.a.p(paramContext))
            localNotification2.defaults = 0;
          localNotificationManager2.notify(i, localNotification2);
          if ((!a.contains(Integer.valueOf(i))) && (paramd.g != 1))
            a.offer(Integer.valueOf(i));
          if (a.size() > ae.a(paramContext, z[17], 2147483647));
          try
          {
            int j = ((Integer)a.poll()).intValue();
            if (j != 0)
              localNotificationManager2.cancel(j);
            if (1 != paramd.g)
              ServiceInterface.a(paramd.c, 1018, paramContext);
            a(paramContext, localHashMap, i, str6, str5, paramd);
            return;
            x.d();
            localIntent2 = new Intent(z[9]);
            localIntent2.addCategory(str5);
            continue;
            localPendingIntent = PendingIntent.getActivity(paramContext, i, cn.jpush.android.util.a.a(paramContext, paramd, false), 134217728);
          }
          catch (Exception localException)
          {
            while (true)
              x.f();
          }
        }
      }
      x.d(z[11], z[16]);
      return;
    }
    NotificationManager localNotificationManager1 = (NotificationManager)paramContext.getSystemService(z[3]);
    Intent localIntent1;
    if ((paramd.R != null) && (paramd.R.size() > 0))
    {
      localIntent1 = new Intent();
      localIntent1.putExtra(z[7], paramd);
      localIntent1.setAction(z[19]);
      localIntent1.addCategory(z[15]);
    }
    for (Notification localNotification1 = a(paramContext, i, localIntent1, paramd, paramBoolean1, true); ; localNotification1 = a(paramContext, i, cn.jpush.android.util.a.a(paramContext, paramd, paramBoolean2), paramd, paramBoolean1, false))
    {
      if ((paramd instanceof s))
        ((s)paramd).S.length();
      if (localNotification1 != null)
        break;
      x.e();
      return;
    }
    if ((!paramBoolean1) && (!TextUtils.isEmpty(paramd.y)))
    {
      p localp = new p(paramContext.getMainLooper(), localNotification1, localNotificationManager1);
      String str1 = paramContext.getFilesDir().getAbsolutePath() + z[6];
      cn.jpush.android.util.n.a(paramd.y, str1, new o(localp, i, paramd));
      return;
    }
    ServiceInterface.a(paramd.c, 1018, paramContext);
    localNotificationManager1.notify(i, localNotification1);
  }

  public static void a(Context paramContext, String paramString)
  {
    new StringBuilder(z[4]).append(paramString).toString();
    x.c();
    if (paramContext == null)
      paramContext = cn.jpush.android.a.d;
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService(z[3]);
    localNotificationManager.cancel(a(paramString, 0));
    localNotificationManager.cancel(a(paramString, 1));
  }

  private static void a(Context paramContext, Map<String, String> paramMap, int paramInt, String paramString1, String paramString2, d paramd)
  {
    x.b(z[11], z[33]);
    Intent localIntent = new Intent(z[34]);
    a(localIntent, paramMap, paramInt);
    if (!ai.a(paramString1))
      localIntent.putExtra(z[18], paramString1);
    if ((paramd.f()) && ((paramd instanceof s)))
    {
      s locals = (s)paramd;
      if (locals.ab.startsWith(z[32]))
        locals.ab = locals.ab.replaceFirst(z[32], "");
      localIntent.putExtra(z[35], locals.ab);
      if ((locals.Y != null) && (locals.Y.size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String str1 = k.b(paramContext, paramd.c);
        Iterator localIterator = locals.Y.iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          if (str2.startsWith(z[30]))
            str2 = cn.jpush.android.util.m.c(str2);
          if (ai.a(localStringBuilder.toString()))
            localStringBuilder.append(str1).append(str2);
          else
            localStringBuilder.append(",").append(str1).append(str2);
        }
        localIntent.putExtra(z[31], localStringBuilder.toString());
      }
    }
    localIntent.addCategory(paramString2);
    paramContext.sendBroadcast(localIntent, paramString2 + z[36]);
  }

  private static void a(Intent paramIntent, Map<String, String> paramMap, int paramInt)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramIntent.putExtra(str, (String)paramMap.get(str));
    }
    if (paramInt != 0)
      paramIntent.putExtra(z[22], paramInt);
  }

  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0:
    default:
      return 1;
    case 1:
      return 16;
    case 2:
    }
    return 32;
  }

  public static void b(Context paramContext, d paramd)
  {
    d locald2;
    d locald1;
    if ((!ai.a(paramd.t)) && (!paramd.u))
    {
      locald2 = d.a(paramContext, paramd);
      if (locald2 == null)
      {
        x.f();
        locald1 = null;
        if (locald1 != null)
          break label50;
      }
    }
    label50: label102: 
    do
    {
      do
      {
        return;
        locald2.u = true;
        locald1 = paramd;
        break;
        if (paramd.D < 0)
          break label102;
      }
      while (d(paramContext, paramd) == null);
      Intent localIntent = new Intent();
      localIntent.setAction(z[23]);
      localIntent.putExtra(z[7], paramd);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    while (c(paramContext, paramd) == null);
    a(paramContext, paramd, false, false);
  }

  private static d c(Context paramContext, d paramd)
  {
    if ((!ai.a(paramd.r)) && (!paramd.s))
    {
      x.d();
      byte[] arrayOfByte = cn.jpush.android.util.n.a(paramd.r, 5, 5000L, 4);
      if (arrayOfByte != null)
        try
        {
          int i = paramd.r.lastIndexOf("/");
          String str1 = paramd.r.substring(i + 1);
          String str2 = k.a(paramContext, paramd.c) + str1;
          if (cn.jpush.android.util.m.a(str2, arrayOfByte, paramContext))
          {
            paramd.Q = str2;
            paramd.s = true;
            new StringBuilder(z[0]).append(str2).toString();
            x.b();
            return paramd;
          }
          x.f();
          return null;
        }
        catch (Exception localException)
        {
          x.h();
          return null;
        }
      new StringBuilder(z[40]).append(paramd.r).toString();
      x.e();
      paramd = null;
    }
    return paramd;
  }

  private static d d(Context paramContext, d paramd)
  {
    if (!ai.a(paramd.G))
    {
      x.d();
      byte[] arrayOfByte = cn.jpush.android.util.n.a(paramd.G, 5, 5000L, 4);
      if (arrayOfByte != null)
        try
        {
          int i = paramd.G.lastIndexOf("/");
          String str1 = paramd.G.substring(i + 1);
          String str2 = k.a(paramContext, paramd.c) + str1;
          if (cn.jpush.android.util.m.a(str2, arrayOfByte, paramContext))
          {
            paramd.H = str2;
            new StringBuilder(z[0]).append(str2).toString();
            x.b();
            return paramd;
          }
          x.f();
          return null;
        }
        catch (Exception localException)
        {
          x.h();
          return null;
        }
      new StringBuilder(z[1]).append(paramd.H).toString();
      x.e();
      paramd = null;
    }
    return paramd;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.m
 * JD-Core Version:    0.6.2
 */