package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j
{
  private static final String a;
  private static Map<String, String> b;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[19];
    int i = 0;
    String str1 = "+KEA:\036_UD;\"^o[<'T";
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
        i3 = 82;
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
        str1 = "\"KEm;/]_";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "3^C]>4OY]<";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = " K@m$$IC[=/UQ_7";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = " K@m$$IC[=/X_V7";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\013kea\032\036z`b\031\004b";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = ",TTW>";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\"SQ\\<$W";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "p\025\007\034c";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "\013kea\032\036xxs\034\017~|";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "-Z^U' \\U";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "5R]W(.UU";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = ".HoD73HY]<";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "2_[m$$IC[=/";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = " K@m9$B";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "(OY_7";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "5B@W";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "%^F[1$dY\\4.";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        z = localObject2;
        a = j.class.getSimpleName();
        b = null;
        return;
        i3 = 65;
        continue;
        i3 = 59;
        continue;
        i3 = 48;
        continue;
        i3 = 50;
      }
    }
  }

  // ERROR //
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 74	cn/jpush/android/util/j:a	Ljava/lang/String;
    //   3: pop
    //   4: invokestatic 86	cn/jpush/android/util/x:c	()V
    //   7: aload_0
    //   8: invokestatic 89	cn/jpush/android/util/j:b	(Landroid/content/Context;)Ljava/util/Map;
    //   11: astore_2
    //   12: aload_2
    //   13: ifnull +12 -> 25
    //   16: aload_2
    //   17: invokeinterface 95 1 0
    //   22: ifeq +4 -> 26
    //   25: return
    //   26: getstatic 76	cn/jpush/android/util/j:b	Ljava/util/Map;
    //   29: ifnonnull +432 -> 461
    //   32: new 97	java/util/HashMap
    //   35: dup
    //   36: invokespecial 98	java/util/HashMap:<init>	()V
    //   39: astore_3
    //   40: aload_0
    //   41: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   44: iconst_0
    //   45: aaload
    //   46: iconst_0
    //   47: invokevirtual 104	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   50: astore 4
    //   52: aload 4
    //   54: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   57: iconst_1
    //   58: aaload
    //   59: aconst_null
    //   60: invokeinterface 110 3 0
    //   65: astore 5
    //   67: aload 4
    //   69: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   72: iconst_2
    //   73: aaload
    //   74: aconst_null
    //   75: invokeinterface 110 3 0
    //   80: astore 6
    //   82: aload 4
    //   84: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   87: bipush 7
    //   89: aaload
    //   90: aconst_null
    //   91: invokeinterface 110 3 0
    //   96: astore 7
    //   98: aload 4
    //   100: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   103: bipush 15
    //   105: aaload
    //   106: aconst_null
    //   107: invokeinterface 110 3 0
    //   112: astore 8
    //   114: aload 4
    //   116: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   119: iconst_4
    //   120: aaload
    //   121: aconst_null
    //   122: invokeinterface 110 3 0
    //   127: astore 9
    //   129: aload 4
    //   131: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   134: iconst_3
    //   135: aaload
    //   136: aconst_null
    //   137: invokeinterface 110 3 0
    //   142: astore 10
    //   144: aload 4
    //   146: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   149: bipush 10
    //   151: aaload
    //   152: aconst_null
    //   153: invokeinterface 110 3 0
    //   158: astore 11
    //   160: aload 4
    //   162: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   165: bipush 11
    //   167: aaload
    //   168: aconst_null
    //   169: invokeinterface 110 3 0
    //   174: astore 12
    //   176: aload 4
    //   178: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   181: bipush 13
    //   183: aaload
    //   184: aconst_null
    //   185: invokeinterface 110 3 0
    //   190: astore 13
    //   192: aload 4
    //   194: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   197: bipush 6
    //   199: aaload
    //   200: aconst_null
    //   201: invokeinterface 110 3 0
    //   206: astore 14
    //   208: aload 5
    //   210: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   213: ifne +17 -> 230
    //   216: aload_3
    //   217: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   220: iconst_1
    //   221: aaload
    //   222: aload 5
    //   224: invokeinterface 119 3 0
    //   229: pop
    //   230: aload 6
    //   232: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   235: ifne +17 -> 252
    //   238: aload_3
    //   239: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   242: iconst_2
    //   243: aaload
    //   244: aload 6
    //   246: invokeinterface 119 3 0
    //   251: pop
    //   252: aload 7
    //   254: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   257: ifne +18 -> 275
    //   260: aload_3
    //   261: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   264: bipush 7
    //   266: aaload
    //   267: aload 7
    //   269: invokeinterface 119 3 0
    //   274: pop
    //   275: aload 8
    //   277: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   280: ifne +18 -> 298
    //   283: aload_3
    //   284: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   287: bipush 15
    //   289: aaload
    //   290: aload 8
    //   292: invokeinterface 119 3 0
    //   297: pop
    //   298: aload 9
    //   300: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   303: ifne +17 -> 320
    //   306: aload_3
    //   307: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   310: iconst_4
    //   311: aaload
    //   312: aload 9
    //   314: invokeinterface 119 3 0
    //   319: pop
    //   320: aload 10
    //   322: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   325: ifne +17 -> 342
    //   328: aload_3
    //   329: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   332: iconst_3
    //   333: aaload
    //   334: aload 10
    //   336: invokeinterface 119 3 0
    //   341: pop
    //   342: aload 11
    //   344: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   347: ifne +18 -> 365
    //   350: aload_3
    //   351: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   354: bipush 12
    //   356: aaload
    //   357: aload 11
    //   359: invokeinterface 119 3 0
    //   364: pop
    //   365: aload 11
    //   367: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   370: ifne +18 -> 388
    //   373: aload_3
    //   374: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   377: bipush 10
    //   379: aaload
    //   380: aload 11
    //   382: invokeinterface 119 3 0
    //   387: pop
    //   388: aload 12
    //   390: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   393: ifne +18 -> 411
    //   396: aload_3
    //   397: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   400: bipush 11
    //   402: aaload
    //   403: aload 12
    //   405: invokeinterface 119 3 0
    //   410: pop
    //   411: aload 13
    //   413: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   416: ifne +18 -> 434
    //   419: aload_3
    //   420: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   423: bipush 13
    //   425: aaload
    //   426: aload 13
    //   428: invokeinterface 119 3 0
    //   433: pop
    //   434: aload 14
    //   436: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   439: ifne +18 -> 457
    //   442: aload_3
    //   443: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   446: bipush 6
    //   448: aaload
    //   449: aload 14
    //   451: invokeinterface 119 3 0
    //   456: pop
    //   457: aload_3
    //   458: putstatic 76	cn/jpush/android/util/j:b	Ljava/util/Map;
    //   461: getstatic 76	cn/jpush/android/util/j:b	Ljava/util/Map;
    //   464: astore 15
    //   466: aload 15
    //   468: ifnull +13 -> 481
    //   471: aload 15
    //   473: invokeinterface 95 1 0
    //   478: ifeq +146 -> 624
    //   481: iconst_1
    //   482: istore 16
    //   484: iload 16
    //   486: ifeq +76 -> 562
    //   489: aload_2
    //   490: putstatic 76	cn/jpush/android/util/j:b	Ljava/util/Map;
    //   493: aload_0
    //   494: aload_2
    //   495: invokestatic 122	cn/jpush/android/util/j:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   498: new 124	org/json/JSONObject
    //   501: dup
    //   502: aload_2
    //   503: invokespecial 127	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   506: astore 21
    //   508: aload 21
    //   510: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   513: bipush 16
    //   515: aaload
    //   516: getstatic 133	cn/jpush/android/service/PushService:m	J
    //   519: invokestatic 139	java/lang/System:currentTimeMillis	()J
    //   522: ldc2_w 140
    //   525: ldiv
    //   526: getstatic 144	cn/jpush/android/service/PushService:n	J
    //   529: lsub
    //   530: invokestatic 150	java/lang/Math:abs	(J)J
    //   533: ladd
    //   534: invokevirtual 153	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   537: pop
    //   538: aload 21
    //   540: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   543: bipush 17
    //   545: aaload
    //   546: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   549: bipush 18
    //   551: aaload
    //   552: invokevirtual 156	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   555: pop
    //   556: aload_0
    //   557: aload 21
    //   559: invokestatic 161	cn/jpush/android/util/ac:a	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   562: invokestatic 166	cn/jpush/android/api/c:a	()Lcn/jpush/android/api/c;
    //   565: aload_0
    //   566: invokevirtual 169	cn/jpush/android/api/c:c	(Landroid/content/Context;)Lorg/json/JSONObject;
    //   569: astore 17
    //   571: aload 17
    //   573: ifnull -548 -> 25
    //   576: new 124	org/json/JSONObject
    //   579: dup
    //   580: aload_2
    //   581: invokespecial 127	org/json/JSONObject:<init>	(Ljava/util/Map;)V
    //   584: astore 18
    //   586: aload 18
    //   588: ifnull +25 -> 613
    //   591: aload 18
    //   593: invokevirtual 173	org/json/JSONObject:length	()I
    //   596: ifle +17 -> 613
    //   599: aload 17
    //   601: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   604: bipush 18
    //   606: aaload
    //   607: aload 18
    //   609: invokevirtual 156	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   612: pop
    //   613: aload_0
    //   614: aload 17
    //   616: invokestatic 161	cn/jpush/android/util/ac:a	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   619: aload_0
    //   620: invokestatic 175	cn/jpush/android/api/c:b	(Landroid/content/Context;)V
    //   623: return
    //   624: aload_2
    //   625: aload 15
    //   627: invokevirtual 179	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   630: ifne +9 -> 639
    //   633: iconst_1
    //   634: istore 16
    //   636: goto -152 -> 484
    //   639: iconst_0
    //   640: istore 16
    //   642: goto -158 -> 484
    //   645: astore 22
    //   647: getstatic 74	cn/jpush/android/util/j:a	Ljava/lang/String;
    //   650: pop
    //   651: aload 22
    //   653: invokevirtual 182	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   656: pop
    //   657: invokestatic 185	cn/jpush/android/util/x:f	()V
    //   660: return
    //   661: astore 19
    //   663: goto -50 -> 613
    //
    // Exception table:
    //   from	to	target	type
    //   498	562	645	org/json/JSONException
    //   599	613	661	org/json/JSONException
  }

  private static void a(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap == null);
    Set localSet;
    do
    {
      return;
      localSet = paramMap.keySet();
    }
    while ((localSet == null) || (localSet.size() <= 0));
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences(z[0], 0).edit();
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localEditor.putString(str, (String)paramMap.get(str));
    }
    localEditor.commit();
  }

  // ERROR //
  private static Map<String, String> b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 230	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   4: astore_1
    //   5: aload_0
    //   6: invokevirtual 233	android/content/Context:getPackageName	()Ljava/lang/String;
    //   9: astore_2
    //   10: new 97	java/util/HashMap
    //   13: dup
    //   14: invokespecial 98	java/util/HashMap:<init>	()V
    //   17: astore_3
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore 5
    //   24: aconst_null
    //   25: astore 6
    //   27: aconst_null
    //   28: astore 7
    //   30: aconst_null
    //   31: astore 8
    //   33: aconst_null
    //   34: astore 9
    //   36: aconst_null
    //   37: astore 10
    //   39: aconst_null
    //   40: astore 11
    //   42: invokestatic 237	cn/jpush/android/util/a:c	()Ljava/lang/String;
    //   45: astore 4
    //   47: aload_0
    //   48: invokestatic 240	cn/jpush/android/util/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   51: astore 5
    //   53: aload_1
    //   54: aload_2
    //   55: sipush 128
    //   58: invokevirtual 246	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   61: astore 30
    //   63: aconst_null
    //   64: astore 11
    //   66: aconst_null
    //   67: astore 10
    //   69: aconst_null
    //   70: astore 9
    //   72: aconst_null
    //   73: astore 8
    //   75: aconst_null
    //   76: astore 7
    //   78: aconst_null
    //   79: astore 6
    //   81: aload 30
    //   83: ifnull +64 -> 147
    //   86: aload 30
    //   88: getfield 252	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   91: astore 31
    //   93: aconst_null
    //   94: astore 11
    //   96: aconst_null
    //   97: astore 10
    //   99: aconst_null
    //   100: astore 9
    //   102: aconst_null
    //   103: astore 8
    //   105: aconst_null
    //   106: astore 7
    //   108: aconst_null
    //   109: astore 6
    //   111: aload 31
    //   113: ifnull +34 -> 147
    //   116: aload 30
    //   118: getfield 252	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   121: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   124: bipush 9
    //   126: aaload
    //   127: invokevirtual 257	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 6
    //   132: aload 30
    //   134: getfield 252	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   137: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   140: iconst_5
    //   141: aaload
    //   142: invokevirtual 257	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: astore 7
    //   147: aload_1
    //   148: aload_2
    //   149: iconst_0
    //   150: invokevirtual 261	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   153: astore 32
    //   155: new 263	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   162: aload 32
    //   164: getfield 270	android/content/pm/PackageInfo:versionCode	I
    //   167: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: astore 8
    //   175: aload 32
    //   177: getfield 280	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   180: astore 9
    //   182: aload 9
    //   184: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   187: bipush 14
    //   189: aaload
    //   190: ldc_w 282
    //   193: invokevirtual 285	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   196: astore 9
    //   198: new 263	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   205: getstatic 290	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   208: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: astore 10
    //   216: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   219: bipush 8
    //   221: aaload
    //   222: astore 11
    //   224: getstatic 298	android/os/Build:MODEL	Ljava/lang/String;
    //   227: astore 13
    //   229: aload_0
    //   230: invokevirtual 302	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   233: invokevirtual 308	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   236: getfield 314	android/content/res/Configuration:locale	Ljava/util/Locale;
    //   239: invokevirtual 317	java/util/Locale:toString	()Ljava/lang/String;
    //   242: astore 34
    //   244: aload 34
    //   246: astore 14
    //   248: invokestatic 323	java/util/TimeZone:getDefault	()Ljava/util/TimeZone;
    //   251: invokevirtual 326	java/util/TimeZone:getRawOffset	()I
    //   254: i2l
    //   255: ldc2_w 327
    //   258: ldiv
    //   259: lstore 35
    //   261: lload 35
    //   263: lconst_0
    //   264: lcmp
    //   265: ifle +278 -> 543
    //   268: new 263	java/lang/StringBuilder
    //   271: dup
    //   272: ldc_w 330
    //   275: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: lload 35
    //   280: invokevirtual 336	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   283: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: astore 37
    //   288: aload 37
    //   290: astore 18
    //   292: aload 4
    //   294: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   297: ifne +17 -> 314
    //   300: aload_3
    //   301: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   304: iconst_1
    //   305: aaload
    //   306: aload 4
    //   308: invokeinterface 119 3 0
    //   313: pop
    //   314: aload 5
    //   316: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   319: ifne +17 -> 336
    //   322: aload_3
    //   323: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   326: iconst_2
    //   327: aaload
    //   328: aload 5
    //   330: invokeinterface 119 3 0
    //   335: pop
    //   336: aload 6
    //   338: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   341: ifne +18 -> 359
    //   344: aload_3
    //   345: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   348: bipush 7
    //   350: aaload
    //   351: aload 6
    //   353: invokeinterface 119 3 0
    //   358: pop
    //   359: aload 7
    //   361: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   364: ifne +18 -> 382
    //   367: aload_3
    //   368: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   371: bipush 15
    //   373: aaload
    //   374: aload 7
    //   376: invokeinterface 119 3 0
    //   381: pop
    //   382: aload 8
    //   384: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   387: ifne +17 -> 404
    //   390: aload_3
    //   391: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   394: iconst_4
    //   395: aaload
    //   396: aload 8
    //   398: invokeinterface 119 3 0
    //   403: pop
    //   404: aload 9
    //   406: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   409: ifne +17 -> 426
    //   412: aload_3
    //   413: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   416: iconst_3
    //   417: aaload
    //   418: aload 9
    //   420: invokeinterface 119 3 0
    //   425: pop
    //   426: aload 10
    //   428: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   431: ifne +18 -> 449
    //   434: aload_3
    //   435: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   438: bipush 12
    //   440: aaload
    //   441: aload 10
    //   443: invokeinterface 119 3 0
    //   448: pop
    //   449: aload 14
    //   451: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   454: ifne +18 -> 472
    //   457: aload_3
    //   458: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   461: bipush 10
    //   463: aaload
    //   464: aload 14
    //   466: invokeinterface 119 3 0
    //   471: pop
    //   472: aload 18
    //   474: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   477: ifne +18 -> 495
    //   480: aload_3
    //   481: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   484: bipush 11
    //   486: aaload
    //   487: aload 18
    //   489: invokeinterface 119 3 0
    //   494: pop
    //   495: aload 11
    //   497: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   500: ifne +18 -> 518
    //   503: aload_3
    //   504: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   507: bipush 13
    //   509: aaload
    //   510: aload 11
    //   512: invokeinterface 119 3 0
    //   517: pop
    //   518: aload 13
    //   520: invokestatic 115	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   523: ifne +18 -> 541
    //   526: aload_3
    //   527: getstatic 67	cn/jpush/android/util/j:z	[Ljava/lang/String;
    //   530: bipush 6
    //   532: aaload
    //   533: aload 13
    //   535: invokeinterface 119 3 0
    //   540: pop
    //   541: aload_3
    //   542: areturn
    //   543: lload 35
    //   545: lconst_0
    //   546: lcmp
    //   547: ifge +26 -> 573
    //   550: new 263	java/lang/StringBuilder
    //   553: dup
    //   554: ldc_w 338
    //   557: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   560: lload 35
    //   562: invokevirtual 336	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   565: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: astore 18
    //   570: goto -278 -> 292
    //   573: new 263	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 264	java/lang/StringBuilder:<init>	()V
    //   580: lload 35
    //   582: invokevirtual 336	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   585: invokevirtual 277	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: astore 38
    //   590: aload 38
    //   592: astore 18
    //   594: goto -302 -> 292
    //   597: astore 12
    //   599: aconst_null
    //   600: astore 13
    //   602: aconst_null
    //   603: astore 14
    //   605: aload 12
    //   607: astore 15
    //   609: getstatic 74	cn/jpush/android/util/j:a	Ljava/lang/String;
    //   612: pop
    //   613: aload 15
    //   615: invokevirtual 339	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   618: pop
    //   619: invokestatic 185	cn/jpush/android/util/x:f	()V
    //   622: aconst_null
    //   623: astore 18
    //   625: goto -333 -> 292
    //   628: astore 33
    //   630: aload 33
    //   632: astore 15
    //   634: aconst_null
    //   635: astore 14
    //   637: goto -28 -> 609
    //   640: astore 15
    //   642: goto -33 -> 609
    //
    // Exception table:
    //   from	to	target	type
    //   42	63	597	java/lang/Exception
    //   86	93	597	java/lang/Exception
    //   116	147	597	java/lang/Exception
    //   147	229	597	java/lang/Exception
    //   229	244	628	java/lang/Exception
    //   248	261	640	java/lang/Exception
    //   268	288	640	java/lang/Exception
    //   550	570	640	java/lang/Exception
    //   573	590	640	java/lang/Exception
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.j
 * JD-Core Version:    0.6.2
 */