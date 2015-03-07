package cn.jpush.android.util;

import android.content.Context;
import cn.jpush.android.data.w;
import org.json.JSONException;
import org.json.JSONObject;

public final class ag
{
  private static final String[] z;

  static
  {
    Object localObject1 = new String[19];
    int i = 0;
    String str1 = "eeKHbsx\r\farj\021Karb\006Q<ag\n@sjG\004QfTn\025M`r_\fOw";
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
        i3 = 18;
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
        str1 = "jd\006C~Yo\013Q";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "ed\013LMo{";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "ud\020Pqc";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "u~\006Awux:Fwrj\fNa";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "rb\bGa";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "ed\020LfY8:";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "ed\020LfY;:\023";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "ed\020LfY::\021";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "hn\021";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "o\fOw";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "jd\002K|Y\nVsj";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "u~\006Awco:V}v";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "jd\002K|Ym\004K~co";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "bj\021G";
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
        str1 = "r\034[?KFHFv";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "rr\025G";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "`j\fNwbT\021Mb";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 6;
        continue;
        i3 = 11;
        continue;
        i3 = 101;
        continue;
        i3 = 34;
      }
    }
  }

  private static JSONObject a(w paramw)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put(z[9], paramw.b());
      localJSONObject1.put(z[2], paramw.c());
      localJSONObject1.put(z[1], paramw.d());
      localJSONObject1.put(z[3], paramw.e());
      localJSONObject1.put(z[5], paramw.g());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put(z[7], paramw.h());
      localJSONObject2.put(z[8], paramw.i());
      localJSONObject2.put(z[6], paramw.j());
      localJSONObject1.put(z[4], localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }

  // ERROR //
  public static void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: new 68	org/json/JSONObject
    //   8: dup
    //   9: invokespecial 70	org/json/JSONObject:<init>	()V
    //   12: astore_1
    //   13: aload_1
    //   14: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   17: bipush 10
    //   19: aaload
    //   20: getstatic 114	cn/jpush/android/service/PushService:m	J
    //   23: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   26: ldc2_w 121
    //   29: ldiv
    //   30: getstatic 125	cn/jpush/android/service/PushService:n	J
    //   33: lsub
    //   34: invokestatic 131	java/lang/Math:abs	(J)J
    //   37: ladd
    //   38: invokevirtual 134	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   41: pop
    //   42: aload_1
    //   43: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   46: bipush 17
    //   48: aaload
    //   49: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   52: bipush 15
    //   54: aaload
    //   55: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload_1
    //   60: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   63: bipush 14
    //   65: aaload
    //   66: new 136	java/text/SimpleDateFormat
    //   69: dup
    //   70: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   73: bipush 16
    //   75: aaload
    //   76: invokespecial 139	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   79: new 141	java/util/Date
    //   82: dup
    //   83: ldc2_w 121
    //   86: aload_0
    //   87: invokestatic 144	cn/jpush/android/util/ag:b	(Landroid/content/Context;)J
    //   90: lmul
    //   91: invokespecial 147	java/util/Date:<init>	(J)V
    //   94: invokevirtual 151	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   97: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   100: pop
    //   101: new 153	cn/jpush/android/data/u
    //   104: dup
    //   105: aload_0
    //   106: invokespecial 155	cn/jpush/android/data/u:<init>	(Landroid/content/Context;)V
    //   109: astore 10
    //   111: aload 10
    //   113: invokevirtual 157	cn/jpush/android/data/u:a	()V
    //   116: aload_1
    //   117: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   120: bipush 11
    //   122: aaload
    //   123: aload 10
    //   125: iconst_1
    //   126: invokevirtual 160	cn/jpush/android/data/u:a	(Z)I
    //   129: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   132: pop
    //   133: aload_1
    //   134: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   137: bipush 13
    //   139: aaload
    //   140: aload 10
    //   142: iconst_0
    //   143: invokevirtual 160	cn/jpush/android/data/u:a	(Z)I
    //   146: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   149: pop
    //   150: new 162	org/json/JSONArray
    //   153: dup
    //   154: invokespecial 163	org/json/JSONArray:<init>	()V
    //   157: astore 13
    //   159: aload 10
    //   161: invokevirtual 166	cn/jpush/android/data/u:d	()Landroid/database/Cursor;
    //   164: astore 14
    //   166: aload 14
    //   168: astore_3
    //   169: aload_3
    //   170: ifnull +37 -> 207
    //   173: aload_3
    //   174: invokestatic 169	cn/jpush/android/data/u:a	(Landroid/database/Cursor;)Lcn/jpush/android/data/w;
    //   177: astore 21
    //   179: aload 21
    //   181: ifnull +14 -> 195
    //   184: aload 21
    //   186: invokevirtual 171	cn/jpush/android/data/w:a	()Ljava/lang/String;
    //   189: invokestatic 176	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   192: ifeq +160 -> 352
    //   195: invokestatic 180	cn/jpush/android/util/x:c	()V
    //   198: aload_3
    //   199: invokeinterface 186 1 0
    //   204: ifne -31 -> 173
    //   207: aload_1
    //   208: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   211: bipush 18
    //   213: aaload
    //   214: aload 13
    //   216: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   219: pop
    //   220: new 162	org/json/JSONArray
    //   223: dup
    //   224: invokespecial 163	org/json/JSONArray:<init>	()V
    //   227: astore 16
    //   229: aload 10
    //   231: invokevirtual 188	cn/jpush/android/data/u:e	()Landroid/database/Cursor;
    //   234: astore 17
    //   236: aload 17
    //   238: astore_3
    //   239: aload_3
    //   240: ifnull +37 -> 277
    //   243: aload_3
    //   244: invokestatic 169	cn/jpush/android/data/u:a	(Landroid/database/Cursor;)Lcn/jpush/android/data/w;
    //   247: astore 19
    //   249: aload 19
    //   251: ifnull +14 -> 265
    //   254: aload 19
    //   256: invokevirtual 171	cn/jpush/android/data/w:a	()Ljava/lang/String;
    //   259: invokestatic 176	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   262: ifeq +125 -> 387
    //   265: invokestatic 180	cn/jpush/android/util/x:c	()V
    //   268: aload_3
    //   269: invokeinterface 186 1 0
    //   274: ifne -31 -> 243
    //   277: aload_1
    //   278: getstatic 62	cn/jpush/android/util/ag:z	[Ljava/lang/String;
    //   281: bipush 12
    //   283: aaload
    //   284: aload 16
    //   286: invokevirtual 79	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   289: pop
    //   290: aload 10
    //   292: invokevirtual 190	cn/jpush/android/data/u:b	()V
    //   295: aload_0
    //   296: aload_1
    //   297: invokestatic 195	cn/jpush/android/util/ac:a	(Landroid/content/Context;Lorg/json/JSONObject;)V
    //   300: aload_3
    //   301: ifnull +9 -> 310
    //   304: aload_3
    //   305: invokeinterface 198 1 0
    //   310: aload_0
    //   311: invokestatic 120	java/lang/System:currentTimeMillis	()J
    //   314: ldc2_w 121
    //   317: ldiv
    //   318: invokestatic 201	cn/jpush/android/util/ag:a	(Landroid/content/Context;J)V
    //   321: new 153	cn/jpush/android/data/u
    //   324: dup
    //   325: aload_0
    //   326: invokespecial 155	cn/jpush/android/data/u:<init>	(Landroid/content/Context;)V
    //   329: astore 6
    //   331: aload 6
    //   333: ifnull -329 -> 4
    //   336: aload 6
    //   338: invokevirtual 157	cn/jpush/android/data/u:a	()V
    //   341: aload 6
    //   343: invokevirtual 202	cn/jpush/android/data/u:c	()V
    //   346: aload 6
    //   348: invokevirtual 190	cn/jpush/android/data/u:b	()V
    //   351: return
    //   352: aload 13
    //   354: aload 21
    //   356: invokestatic 204	cn/jpush/android/util/ag:b	(Lcn/jpush/android/data/w;)Lorg/json/JSONObject;
    //   359: invokevirtual 207	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   362: pop
    //   363: goto -165 -> 198
    //   366: astore_2
    //   367: invokestatic 210	cn/jpush/android/util/x:f	()V
    //   370: aload_2
    //   371: invokevirtual 107	org/json/JSONException:printStackTrace	()V
    //   374: aload_3
    //   375: ifnull -65 -> 310
    //   378: aload_3
    //   379: invokeinterface 198 1 0
    //   384: goto -74 -> 310
    //   387: aload 16
    //   389: aload 19
    //   391: invokestatic 212	cn/jpush/android/util/ag:a	(Lcn/jpush/android/data/w;)Lorg/json/JSONObject;
    //   394: invokevirtual 207	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   397: pop
    //   398: goto -130 -> 268
    //   401: astore 4
    //   403: aload_3
    //   404: astore 5
    //   406: aload 5
    //   408: ifnull +10 -> 418
    //   411: aload 5
    //   413: invokeinterface 198 1 0
    //   418: aload 4
    //   420: athrow
    //   421: astore 4
    //   423: aconst_null
    //   424: astore 5
    //   426: goto -20 -> 406
    //   429: astore_2
    //   430: aconst_null
    //   431: astore_3
    //   432: goto -65 -> 367
    //
    // Exception table:
    //   from	to	target	type
    //   173	179	366	org/json/JSONException
    //   184	195	366	org/json/JSONException
    //   195	198	366	org/json/JSONException
    //   198	207	366	org/json/JSONException
    //   207	220	366	org/json/JSONException
    //   243	249	366	org/json/JSONException
    //   254	265	366	org/json/JSONException
    //   265	268	366	org/json/JSONException
    //   268	277	366	org/json/JSONException
    //   277	300	366	org/json/JSONException
    //   352	363	366	org/json/JSONException
    //   387	398	366	org/json/JSONException
    //   173	179	401	finally
    //   184	195	401	finally
    //   195	198	401	finally
    //   198	207	401	finally
    //   207	220	401	finally
    //   243	249	401	finally
    //   254	265	401	finally
    //   265	268	401	finally
    //   268	277	401	finally
    //   277	300	401	finally
    //   352	363	401	finally
    //   367	374	401	finally
    //   387	398	401	finally
    //   13	166	421	finally
    //   220	236	421	finally
    //   13	166	429	org/json/JSONException
    //   220	236	429	org/json/JSONException
  }

  public static void a(Context paramContext, long paramLong)
  {
    if (paramContext == null)
      return;
    ah.b(paramContext, z[0], paramLong);
  }

  public static long b(Context paramContext)
  {
    if (paramContext == null)
      return -1L;
    return ah.a(paramContext, z[0], 0L);
  }

  private static JSONObject b(w paramw)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[9], paramw.b());
      localJSONObject.put(z[2], paramw.c());
      localJSONObject.put(z[1], paramw.d());
      localJSONObject.put(z[3], paramw.e());
      localJSONObject.put(z[5], paramw.g());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.ag
 * JD-Core Version:    0.6.2
 */