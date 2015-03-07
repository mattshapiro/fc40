package cn.jpush.android.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.api.b;
import cn.jpush.android.api.m;
import cn.jpush.android.data.d;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ac;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceInterface
{
  public static long a;
  public static String b = str4;
  public static ConcurrentHashMap<Integer, b> d = new ConcurrentHashMap();
  private static String e;
  private static int f;
  private static String g;
  private static int h;
  private static boolean i = false;
  private static final String[] z;
  WeakHashMap<Integer, TagAliasCallback> c = new WeakHashMap();

  static
  {
    Object localObject1 = new String[50];
    int j = 0;
    String str1 = "";
    int k = -1;
    Object localObject2 = localObject1;
    int i11;
    label133: String str2;
    while (true)
    {
      Object localObject3 = str1.toCharArray();
      int m = localObject3.length;
      int n = 0;
      if (m <= 1);
      while (m > n)
      {
        Object localObject7 = localObject3;
        int i8 = n;
        int i9 = m;
        Object localObject8 = localObject3;
        while (true)
        {
          int i10 = localObject8[n];
          switch (i8 % 5)
          {
          default:
            i11 = 68;
            localObject8[n] = ((char)(i11 ^ i10));
            n = i8 + 1;
            if (i9 != 0)
              break label133;
            localObject8 = localObject7;
            i8 = n;
            n = i9;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        m = i9;
        localObject3 = localObject7;
      }
      str2 = new String((char[])localObject3).intern();
      switch (k)
      {
      default:
        localObject1[j] = str2;
        j = 1;
        str1 = "y$\f;dG$\021,#Oa\004-+Ga&\035~\n";
        localObject1 = localObject2;
        k = 0;
        break;
      case 0:
        localObject1[j] = str2;
        j = 2;
        str1 = "";
        k = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[j] = str2;
        j = 3;
        str1 = "m$\026)O2\0218!\n'\0200)\n\005 sd^)\007'E4\f+dC2X";
        k = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[j] = str2;
        j = 4;
        str1 = "";
        k = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[j] = str2;
        j = 5;
        str1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\027~\0162\017\021y\t";
        k = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[j] = str2;
        j = 6;
        str1 = "Y$\020)-I$=,0E1\007;";
        k = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[j] = str2;
        j = 7;
        str1 = "K1\022";
        k = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[j] = str2;
        j = 8;
        str1 = "L \016,!";
        k = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[j] = str2;
        j = 9;
        str1 = "y$\020)-I$+10O3\004>'O";
        k = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[j] = str2;
        j = 10;
        str1 = "C20:7^ \020+\026^\"";
        k = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[j] = str2;
        j = 11;
        str1 = "Y$\020)-I$B>(X$\003;=\n2\02604";
        k = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[j] = str2;
        j = 12;
        str1 = "";
        k = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[j] = str2;
        j = 13;
        str1 = "^3\027:";
        k = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[j] = str2;
        j = 14;
        str1 = "X5\001";
        k = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[j] = str2;
        j = 15;
        str1 = "Y(\016:*I$2*7B\025\0132!";
        k = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[j] = str2;
        j = 16;
        str1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\026o\0226\020\026o\0217\f\f";
        k = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[j] = str2;
        j = 17;
        str1 = "Y$\020)-I$B67\n3\0271*C/\005%F3\007> S";
        k = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[j] = str2;
        j = 18;
        str1 = "~)\0077O3\0246'Oa\013,dY5\r/4O%N-^a\0256(Fa\00562Oa\027/dK-\0160B$B>'^(\r17\n4\f+-Fa\03301\n\"\0033(\n3\007,1G$2*7Ba\017:0B.\0060Ea\020:7_,\0070B$B,!X7\013<!\004";
        k = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[j] = str2;
        j = 19;
        str1 = "\033oUqu";
        k = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[j] = str2;
        j = 20;
        str1 = "D.\0266\"K\"\0266+D\036\f*)";
        k = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[j] = str2;
        j = 21;
        str1 = "X$\021+%X5=-0I";
        k = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[j] = str2;
        j = 22;
        str1 = "K\"\0266+D{\020:4E3\026\0204O3\003+-E/BrdI.\f+!D5X";
        k = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[j] = str2;
        j = 23;
        str1 = "d\024.\023dI.\f+!R5";
        k = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[j] = str2;
        j = 24;
        str1 = "Z4\02170C,\007";
        k = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[j] = str2;
        j = 25;
        str1 = "I-\r,!Z4\0217";
        k = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[j] = str2;
        j = 26;
        str1 = "";
        k = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[j] = str2;
        j = 27;
        str1 = "k\02123-Y5B3!D&\0267~\n";
        k = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[j] = str2;
        j = 28;
        str1 = "k1\0223-Y5Bed";
        k = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[j] = str2;
        j = 29;
        str1 = "";
        k = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[j] = str2;
        j = 30;
        str1 = "I/L54_2\nq%D%\0200-No\01310O/\026q\rd\b6";
        k = 29;
        localObject1 = localObject2;
        break;
      case 29:
        localObject1[j] = str2;
        j = 31;
        str1 = "O/\006\027+_3";
        k = 30;
        localObject1 = localObject2;
        break;
      case 30:
        localObject1[j] = str2;
        j = 32;
        str1 = "Y5\003-0b.\027-";
        k = 31;
        localObject1 = localObject2;
        break;
      case 31:
        localObject1[j] = str2;
        j = 33;
        str1 = "O/\006+\tC/\021";
        k = 32;
        localObject1 = localObject2;
        break;
      case 32:
        localObject1[j] = str2;
        j = 34;
        str1 = "Y5\003-0g(\f,";
        k = 33;
        localObject1 = localObject2;
        break;
      case 33:
        localObject1[j] = str2;
        j = 35;
        str1 = "^8\022:";
        k = 34;
        localObject1 = localObject2;
        break;
      case 34:
        localObject1[j] = str2;
        j = 36;
        str1 = "X$\021*(^";
        k = 35;
        localObject1 = localObject2;
        break;
      case 35:
        localObject1[j] = str2;
        j = 37;
        str1 = "K\"\0266+D{\020:4E3\026\036'^(\r1\026O2\02730\nlB2!Y2\0038!c%X";
        k = 36;
        localObject1 = localObject2;
        break;
      case 36:
        localObject1[j] = str2;
        j = 38;
        str1 = "N \026>";
        k = 37;
        localObject1 = localObject2;
        break;
      case 37:
        localObject1[j] = str2;
        j = 39;
        str1 = "";
        k = 38;
        localObject1 = localObject2;
        break;
      case 38:
        localObject1[j] = str2;
        j = 40;
        str1 = "C5\0132!";
        k = 39;
        localObject1 = localObject2;
        break;
      case 39:
        localObject1[j] = str2;
        j = 41;
        str1 = "";
        k = 40;
        localObject1 = localObject2;
        break;
      case 40:
        localObject1[j] = str2;
        j = 42;
        str1 = "\006a\0010 O{B";
        k = 41;
        localObject1 = localObject2;
        break;
      case 41:
        localObject1[j] = str2;
        j = 43;
        str1 = "\n3\007/+X5B<+D5\00710\020a";
        k = 42;
        localObject1 = localObject2;
        break;
      case 42:
        localObject1[j] = str2;
        j = 44;
        str1 = "H.\006&";
        k = 43;
        localObject1 = localObject2;
        break;
      case 43:
        localObject1[j] = str2;
        j = 45;
        str1 = "";
        k = 44;
        localObject1 = localObject2;
        break;
      case 44:
        localObject1[j] = str2;
        j = 46;
        str1 = "";
        k = 45;
        localObject1 = localObject2;
        break;
      case 45:
        localObject1[j] = str2;
        j = 47;
        str1 = "^ \005,";
        k = 46;
        localObject1 = localObject2;
        break;
      case 46:
        localObject1[j] = str2;
        j = 48;
        str1 = "K-\013>7";
        k = 47;
        localObject1 = localObject2;
        break;
      case 47:
        localObject1[j] = str2;
        j = 49;
        str1 = "Y5\r/\033^)\020:%N";
        k = 48;
        localObject1 = localObject2;
      case 48:
      }
    }
    localObject1[j] = str2;
    z = localObject2;
    a = 0L;
    int i1 = -1;
    String str3 = "\033pUqu\031tLnr\032oWm";
    label1399: String str4;
    while (true)
    {
      Object localObject4 = str3.toCharArray();
      int i2 = localObject4.length;
      int i3 = 0;
      if (i2 <= 1);
      label1537: 
      while (i2 > i3)
      {
        Object localObject5 = localObject4;
        int i4 = i3;
        int i5 = i2;
        Object localObject6 = localObject4;
        int i6 = localObject6[i3];
        int i7;
        switch (i4 % 5)
        {
        default:
          i7 = 68;
        case 0:
        case 1:
        case 2:
        case 3:
        }
        while (true)
        {
          localObject6[i3] = ((char)(i7 ^ i6));
          i3 = i4 + 1;
          if (i5 != 0)
            break label1537;
          localObject6 = localObject5;
          i4 = i3;
          i3 = i5;
          break label1399;
          i11 = 42;
          break;
          i11 = 65;
          break;
          i11 = 98;
          break;
          i11 = 95;
          break;
          i7 = 42;
          continue;
          i7 = 65;
          continue;
          i7 = 98;
          continue;
          i7 = 95;
        }
        i2 = i5;
        localObject4 = localObject5;
      }
      str4 = new String((char[])localObject4).intern();
      switch (i1)
      {
      default:
        e = str4;
        f = 9001;
        str3 = "\033pUqu\031tLnr\032oWm";
        i1 = 0;
        break;
      case 0:
        g = str4;
        h = 9002;
        i1 = 1;
        str3 = "B5\026/~\005n\021+%^2L54_2\nq'D";
      case 1:
      }
    }
  }

  static b a(int paramInt)
  {
    return (b)d.get(Integer.valueOf(paramInt));
  }

  public static void a(Context paramContext)
  {
    if (j(paramContext));
    while (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    Intent localIntent = new Intent(paramContext, PushService.class);
    localIntent.setAction(z[30]);
    localIntent.putExtra(z[7], paramContext.getPackageName());
    paramContext.startService(localIntent);
  }

  public static void a(Context paramContext, int paramInt)
  {
    int j = ae.a(paramContext, z[6], -1);
    if (1 == j)
    {
      x.b(z[9], z[11]);
      return;
    }
    if ((1 < j) && (j > 0));
    ae.b(paramContext, z[6], 1);
    PushService.b(false);
    ae.b(paramContext, z[10], z[8]);
    Intent localIntent = new Intent(paramContext, PushService.class);
    localIntent.setAction(z[5]);
    localIntent.putExtra(z[7], paramContext.getPackageName());
    paramContext.startService(localIntent);
    a(paramContext, false);
  }

  public static void a(Context paramContext, d paramd)
  {
    x.b();
    Intent localIntent = new Intent(paramContext, DownloadService.class);
    localIntent.putExtra(z[44], paramd);
    paramContext.startService(localIntent);
  }

  public static void a(Context paramContext, String paramString)
  {
    if (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    ae.b(paramContext, z[15], paramString);
  }

  public static void a(Context paramContext, String paramString1, String paramString2, b paramb)
  {
    if (j(paramContext));
    while (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    int j = 0;
    if (paramb != null)
    {
      TagAliasCallback localTagAliasCallback = paramb.c;
      j = 0;
      if (localTagAliasCallback != null)
      {
        j = a.c(paramContext);
        Integer localInteger = Integer.valueOf(j);
        d.put(localInteger, paramb);
      }
    }
    Intent localIntent = new Intent(paramContext, PushService.class);
    localIntent.setAction(z[46]);
    localIntent.putExtra(z[48], paramString1);
    localIntent.putExtra(z[47], paramString2);
    localIntent.putExtra(z[45], j);
    paramContext.startService(localIntent);
  }

  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if (paramContext == null)
      throw new IllegalArgumentException(z[23]);
    if ((paramJSONObject != null) && (paramJSONObject.length() > 0))
    {
      ac.a(paramContext, paramJSONObject);
      new StringBuilder(z[22]).append(paramJSONObject.toString()).toString();
      x.c();
    }
  }

  private static void a(Context paramContext, boolean paramBoolean)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ComponentName localComponentName1 = new ComponentName(paramContext.getApplicationContext(), PushReceiver.class);
    ComponentName localComponentName2 = new ComponentName(paramContext.getApplicationContext(), AlarmReceiver.class);
    if (!paramBoolean)
    {
      localPackageManager.setComponentEnabledSetting(localComponentName2, 2, 1);
      return;
    }
    localPackageManager.setComponentEnabledSetting(localComponentName1, 1, 1);
    localPackageManager.setComponentEnabledSetting(localComponentName2, 1, 1);
  }

  public static void a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    Intent localIntent = new Intent(paramContext, PushService.class);
    localIntent.setAction(z[26]);
    localIntent.putExtra(z[25], paramBoolean);
    localIntent.putExtra(z[24], paramString);
    paramContext.startService(localIntent);
  }

  public static void a(String paramString)
  {
    e = paramString;
  }

  public static void a(String paramString, int paramInt, Context paramContext)
  {
    a(paramString, paramInt, null, paramContext);
  }

  public static void a(String paramString1, int paramInt, String paramString2, Context paramContext)
  {
    if (paramContext == null)
    {
      x.c();
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(z[37] + paramString1 + z[42] + paramInt + "-" + p.b(paramInt));
    if (!ai.a(paramString2))
      localStringBuffer.append(z[43] + paramString2);
    localStringBuffer.toString();
    x.c();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[39], paramString1);
      localJSONObject.put(z[36], paramInt);
      if (!ai.a(paramString2))
        localJSONObject.put(z[38], paramString2);
      localJSONObject.put(z[40], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
      localJSONObject.put(z[35], z[41]);
      ac.a(paramContext, localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
    }
  }

  public static boolean a()
  {
    return PushProtocol.GetSdkVersion() >= 160;
  }

  public static boolean a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[32], paramInt1);
      localJSONObject.put(z[34], paramInt2);
      localJSONObject.put(z[31], paramInt3);
      localJSONObject.put(z[33], paramInt4);
      a(paramContext, localJSONObject.toString());
      return true;
    }
    catch (JSONException localJSONException)
    {
    }
    return false;
  }

  public static String b()
  {
    return z[19];
  }

  static void b(int paramInt)
  {
    d.remove(Integer.valueOf(paramInt));
  }

  public static void b(Context paramContext)
  {
    if (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    Intent localIntent = new Intent(paramContext, PushService.class);
    localIntent.setAction(z[49]);
    localIntent.putExtra(z[7], paramContext.getPackageName());
    paramContext.startService(localIntent);
  }

  public static void b(Context paramContext, int paramInt)
  {
    int j = ae.a(paramContext, z[6], -1);
    if (j == 0)
    {
      x.b(z[9], z[17]);
      return;
    }
    if ((1 < j) && (j > 0));
    a(paramContext, true);
    PushService.b(true);
    ae.b(paramContext, z[10], z[13]);
    ae.b(paramContext, z[6], 0);
    Intent localIntent = new Intent(paramContext, PushService.class);
    localIntent.setAction(z[16]);
    localIntent.putExtra(z[7], paramContext.getPackageName());
    paramContext.startService(localIntent);
  }

  public static void b(String paramString)
  {
    g = paramString;
  }

  public static void c(int paramInt)
  {
    f = paramInt;
  }

  public static void c(Context paramContext)
  {
    if (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    Intent localIntent = new Intent(paramContext, PushService.class);
    Bundle localBundle = new Bundle();
    localBundle.putString(z[14], z[14]);
    localIntent.putExtras(localBundle);
    paramContext.startService(localIntent);
  }

  public static void c(Context paramContext, int paramInt)
  {
    if (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    Intent localIntent = new Intent(paramContext, PushService.class);
    Bundle localBundle = new Bundle();
    localBundle.putString(z[14], z[14]);
    localBundle.putInt(z[12], paramInt);
    localIntent.putExtras(localBundle);
    paramContext.startService(localIntent);
  }

  public static void d(int paramInt)
  {
    h = paramInt;
  }

  public static void d(Context paramContext)
  {
    if (ae.a(paramContext, z[10], z[13]).equals(z[8]))
      return;
    x.b();
    if (PushService.a())
    {
      Intent localIntent = new Intent(paramContext, PushService.class);
      localIntent.setAction(z[21]);
      paramContext.startService(localIntent);
      return;
    }
    x.d();
  }

  public static void d(Context paramContext, int paramInt)
  {
    ae.b(paramContext, z[20], paramInt);
  }

  public static void e(Context paramContext)
  {
    if (paramContext == null)
      x.c();
    while (true)
    {
      return;
      JSONArray localJSONArray1 = a.n(paramContext);
      if ((localJSONArray1 == null) || (localJSONArray1.length() == 0))
        continue;
      JSONArray localJSONArray2 = new JSONArray();
      int j = localJSONArray1.length();
      JSONArray localJSONArray3 = localJSONArray2;
      int k = 0;
      label43: if (k < j);
      try
      {
        localJSONArray3.put(localJSONArray1.getJSONObject(k));
        label61: if ((localJSONArray3.toString().length() > 15360) || (k == j - 1))
        {
          JSONObject localJSONObject2 = a.a(z[29], localJSONArray1);
          if ((localJSONObject2 != null) && (localJSONObject2.length() > 0))
            ac.a(paramContext, localJSONObject2);
          localJSONArray3 = new JSONArray();
        }
        k++;
        break label43;
        JSONObject localJSONObject1 = a.a(z[29], localJSONArray1);
        if ((localJSONObject1 == null) || (localJSONObject1.length() <= 0))
          continue;
        ac.a(paramContext, localJSONObject1);
        new StringBuilder(z[27]).append(localJSONObject1.toString().getBytes().length).toString();
        x.d();
        new StringBuilder(z[28]).append(localJSONObject1).toString();
        x.d();
        return;
      }
      catch (JSONException localJSONException)
      {
        break label61;
      }
    }
  }

  // ERROR //
  public static void f(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: invokestatic 444	cn/jpush/android/data/r:a	(Landroid/content/Context;)Landroid/database/Cursor;
    //   6: astore 6
    //   8: aload 6
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +187 -> 199
    //   15: aload_1
    //   16: invokeinterface 449 1 0
    //   21: ifle +178 -> 199
    //   24: new 286	java/lang/StringBuilder
    //   27: dup
    //   28: getstatic 141	cn/jpush/android/service/ServiceInterface:z	[Ljava/lang/String;
    //   31: iconst_3
    //   32: aaload
    //   33: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_1
    //   37: invokeinterface 449 1 0
    //   42: invokevirtual 334	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: pop
    //   49: invokestatic 411	cn/jpush/android/util/x:d	()V
    //   52: aload_1
    //   53: invokeinterface 452 1 0
    //   58: pop
    //   59: aload_1
    //   60: invokeinterface 455 1 0
    //   65: ifne +134 -> 199
    //   68: aload_1
    //   69: aload_1
    //   70: getstatic 141	cn/jpush/android/service/ServiceInterface:z	[Ljava/lang/String;
    //   73: iconst_0
    //   74: aaload
    //   75: invokeinterface 459 2 0
    //   80: invokeinterface 463 2 0
    //   85: istore 10
    //   87: aload_1
    //   88: aload_1
    //   89: getstatic 141	cn/jpush/android/service/ServiceInterface:z	[Ljava/lang/String;
    //   92: iconst_4
    //   93: aaload
    //   94: invokeinterface 459 2 0
    //   99: invokeinterface 466 2 0
    //   104: astore 11
    //   106: new 468	java/lang/Thread
    //   109: dup
    //   110: new 470	cn/jpush/android/service/o
    //   113: dup
    //   114: aload_1
    //   115: aload_1
    //   116: getstatic 141	cn/jpush/android/service/ServiceInterface:z	[Ljava/lang/String;
    //   119: iconst_2
    //   120: aaload
    //   121: invokeinterface 459 2 0
    //   126: invokeinterface 466 2 0
    //   131: aload 11
    //   133: invokevirtual 434	java/lang/String:getBytes	()[B
    //   136: invokespecial 473	cn/jpush/android/service/o:<init>	(Ljava/lang/String;[B)V
    //   139: invokespecial 476	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   142: invokevirtual 479	java/lang/Thread:start	()V
    //   145: new 286	java/lang/StringBuilder
    //   148: dup
    //   149: getstatic 141	cn/jpush/android/service/ServiceInterface:z	[Ljava/lang/String;
    //   152: iconst_1
    //   153: aaload
    //   154: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   157: aload 11
    //   159: invokevirtual 294	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 295	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: pop
    //   166: invokestatic 411	cn/jpush/android/util/x:d	()V
    //   169: aload_0
    //   170: iload 10
    //   172: invokestatic 482	cn/jpush/android/data/r:a	(Landroid/content/Context;I)Z
    //   175: pop
    //   176: aload_1
    //   177: invokeinterface 485 1 0
    //   182: pop
    //   183: goto -124 -> 59
    //   186: astore 5
    //   188: aload_1
    //   189: ifnull +9 -> 198
    //   192: aload_1
    //   193: invokeinterface 488 1 0
    //   198: return
    //   199: aload_1
    //   200: ifnull -2 -> 198
    //   203: aload_1
    //   204: invokeinterface 488 1 0
    //   209: return
    //   210: astore_2
    //   211: aconst_null
    //   212: astore_3
    //   213: aload_2
    //   214: astore 4
    //   216: aload_3
    //   217: ifnull +9 -> 226
    //   220: aload_3
    //   221: invokeinterface 488 1 0
    //   226: aload 4
    //   228: athrow
    //   229: astore 7
    //   231: aload_1
    //   232: astore_3
    //   233: aload 7
    //   235: astore 4
    //   237: goto -21 -> 216
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	186	java/lang/Exception
    //   15	59	186	java/lang/Exception
    //   59	183	186	java/lang/Exception
    //   2	8	210	finally
    //   15	59	229	finally
    //   59	183	229	finally
  }

  public static void g(Context paramContext)
  {
    m.a(paramContext);
  }

  public static boolean h(Context paramContext)
  {
    int j = ae.a(paramContext, z[6], 0);
    boolean bool = false;
    if (j > 0)
      bool = true;
    return bool;
  }

  public static int i(Context paramContext)
  {
    return ae.a(paramContext, z[6], -1);
  }

  public static boolean j(Context paramContext)
  {
    boolean bool = h(paramContext);
    if (bool)
      x.d(z[9], z[18]);
    return bool;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.ServiceInterface
 * JD-Core Version:    0.6.2
 */