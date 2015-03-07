package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.jpush.android.a;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class ae
{
  private static SharedPreferences a;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[49];
    int i = 0;
    String str1 = "\022c;\031%\005";
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
        i3 = 76;
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
        str1 = "";
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
        str1 = "\fU>'>\025I$\023?\004t\0324)\022c$2";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "\fE?4>\004h>\025%\022V%5";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\f\\#6\031\005v\003\026";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "\fU/4:\004t\006/?\025O\032";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\fN%58";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "\fO\032";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "\007g&5)";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "\tr>6\023\023c:)>\025Y9/?>s8*";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "\fO$2)\023p+*";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "\022h)";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "\bu\r#8&i%! \004G.\">\004u9";
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
        str1 = "\fU/4:\004t\006/?\025N%58";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "\fU/4:\004t\006/?\025V%48";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "\bu\031# \007M#* \004b\007)(\004";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "\ri)\0225\021c";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "\bu\030#?\025g82\036\025e";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "\f@#4?\025J%!+\004b\003(";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "\025t?#";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "\022c>f%\022J%%-\025o%(\t\017g(*)\005&>)vA";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        i = 25;
        str1 = "\004t8)>\022";
        j = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i] = str2;
        i = 26;
        str1 = "\fT/6#\023r\032'/\ng-#\005\017`%\t\"-i-!)\005O$";
        j = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i] = str2;
        i = 27;
        str1 = "\023t&2";
        j = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i] = str2;
        i = 28;
        str1 = "\022c>f\b#Aj2#[&";
        j = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i] = str2;
        i = 29;
        str1 = "%D\r";
        j = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[i] = str2;
        i = 30;
        str1 = "\022c>f!2r+48.h\0375)\023V8#?\004h>f8\016<j";
        j = 29;
        localObject1 = localObject2;
        break;
      case 29:
        localObject1[i] = str2;
        i = 31;
        str1 = "\fV%48";
        j = 30;
        localObject1 = localObject2;
        break;
      case 30:
        localObject1[i] = str2;
        i = 32;
        str1 = "";
        j = 31;
        localObject1 = localObject2;
        break;
      case 31:
        localObject1[i] = str2;
        i = 33;
        str1 = "\022c>f!2r+48.h\004#8\026i8-\017\016h$#/\025c.f8\016<j";
        j = 32;
        localObject1 = localObject2;
        break;
      case 32:
        localObject1[i] = str2;
        i = 34;
        str1 = "\f\\#6\031\005v\032)>\025";
        j = 33;
        localObject1 = localObject2;
        break;
      case 33:
        localObject1[i] = str2;
        i = 35;
        str1 = "\002hd,<\024u\"h?\004t<#>\002i$ %\006";
        j = 34;
        localObject1 = localObject2;
        break;
      case 34:
        localObject1[i] = str2;
        i = 36;
        str1 = "\025o'#}[&";
        j = 35;
        localObject1 = localObject2;
        break;
      case 35:
        localObject1[i] = str2;
        i = 37;
        str1 = "I]{k{<}{j{\034/\025nd";
        j = 36;
        localObject1 = localObject2;
        break;
      case 36:
        localObject1[i] = str2;
        i = 38;
        str1 = "\002j%5)\021s9.";
        j = 37;
        localObject1 = localObject2;
        break;
      case 37:
        localObject1[i] = str2;
        i = 39;
        str1 = "\021s9.\030\bk/\n#\002g&";
        j = 38;
        localObject1 = localObject2;
        break;
      case 38:
        localObject1[i] = str2;
        i = 40;
        str1 = "I]zku<z{\035|L?\027:~:6gu\021HZ\024n\027Q+s\0330P]zku<zx\035|L5\027o";
        j = 39;
        localObject1 = localObject2;
        break;
      case 39:
        localObject1[i] = str2;
        i = 41;
        str1 = "\ti?4vA";
        j = 40;
        localObject1 = localObject2;
        break;
      case 40:
        localObject1[i] = str2;
        i = 42;
        str1 = "";
        j = 41;
        localObject1 = localObject2;
        break;
      case 41:
        localObject1[i] = str2;
        i = 43;
        str1 = "(h<' \bbj #\023k+2`Av?5$5o'#v";
        j = 42;
        localObject1 = localObject2;
        break;
      case 42:
        localObject1[i] = str2;
        i = 44;
        str1 = "Hzb";
        j = 43;
        localObject1 = localObject2;
        break;
      case 43:
        localObject1[i] = str2;
        i = 45;
        str1 = "L/an";
        j = 44;
        localObject1 = localObject2;
        break;
      case 44:
        localObject1[i] = str2;
        i = 46;
        str1 = "\bu\013(?\026c8";
        j = 45;
        localObject1 = localObject2;
        break;
      case 45:
        localObject1[i] = str2;
        i = 47;
        str1 = "=X";
        j = 46;
        localObject1 = localObject2;
        break;
      case 46:
        localObject1[i] = str2;
        i = 48;
        str1 = "H/";
        j = 47;
        localObject1 = localObject2;
        break;
      case 47:
        localObject1[i] = str2;
        z = localObject2;
        a = null;
        return;
        i3 = 97;
        continue;
        i3 = 6;
        continue;
        i3 = 74;
        continue;
        i3 = 70;
      }
    }
  }

  public static int a(Context paramContext, String paramString, int paramInt)
  {
    c(paramContext);
    return a.getInt(paramString, paramInt);
  }

  public static long a(Context paramContext, String paramString, long paramLong)
  {
    c(paramContext);
    return a.getLong(paramString, paramLong);
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    c(paramContext);
    return a.getString(paramString1, paramString2);
  }

  private static void a()
  {
    x.d();
    String str1 = a.getString(z[29], z[25]);
    String str2;
    label135: String str3;
    label189: String str4;
    label266: int i;
    label323: String str5;
    label406: String str7;
    label495: String str8;
    label552: String str14;
    if (!str1.equals(z[25]))
    {
      if (str1.toLowerCase().equals(z[23]))
      {
        PushService.b = true;
        new StringBuilder(z[28]).append(str1).toString();
        x.c();
      }
    }
    else
    {
      str2 = a.getString(z[14], z[25]);
      if (!str2.equals(z[25]))
      {
        if (!str2.toLowerCase().equals(z[23]))
          break label1217;
        PushService.C = true;
      }
      str3 = a.getString(z[13], z[25]);
      if (!str3.equals(z[25]))
      {
        if (!str3.toLowerCase().equals(z[23]))
          break label1240;
        PushService.d(true);
        new StringBuilder(z[24]).append(str3).toString();
        x.c();
      }
      str4 = a.getString(z[3], z[25]);
      if (!str4.equals(z[25]))
      {
        if (!str4.toLowerCase().equals(z[23]))
          break label1263;
        PushService.q = true;
        new StringBuilder(z[30]).append(str4).toString();
        x.c();
      }
      i = a.getInt(z[12], -1);
      if (i != -1)
      {
        if (i != 1)
          break label1286;
        PushService.r = true;
        new StringBuilder(z[33]).append(PushService.r).toString();
        x.c();
      }
      str5 = a.getString(z[22], z[25]);
      if (!str5.equals(z[25]))
      {
        if (!str5.toLowerCase().equals(z[23]))
          break label1298;
        PushService.B = true;
      }
      String str6 = a.getString(z[10], "");
      if (!ai.a(str6))
        ac.a(str6);
      str7 = a.getString(z[18], z[25]);
      if (!str7.equals(z[25]))
      {
        if (!str7.toLowerCase().equals(z[23]))
          break label1322;
        PushService.c(true);
      }
      str8 = a.getString(z[20], z[25]);
      if (!str8.equals(z[25]))
      {
        if (!str8.toLowerCase().equals(z[23]))
          break label1346;
        PushService.b(true);
      }
      int j = a.getInt(z[2], -1);
      if (j != -1)
        PushService.d(j);
      int k = a.getInt(z[11], -1);
      if (k != -1)
      {
        PushService.i = k;
        ServiceInterface.d(a.d);
      }
      int m = a.getInt(z[31], -1);
      if (m != -1)
      {
        PushService.p = m;
        PushService.a(m);
      }
      String str9 = a.getString(z[8], z[25]);
      if (!str9.equals(z[25]))
      {
        PushService.o = str9;
        PushService.a(str9);
      }
      String str10 = a.getString(z[6], z[25]);
      if (!str10.equals(z[25]))
        PushService.d(str10);
      String str11 = a.getString(z[16], z[25]);
      if (!str11.equals(z[25]))
        PushService.c(str11);
      int n = a.getInt(z[1], -1);
      if (n != -1)
        PushService.d = n;
      String str12 = a.getString(z[7], z[25]);
      if (!str12.equals(z[25]))
        PushService.b(str12);
      int i1 = a.getInt(z[17], -1);
      if (i1 != -1)
        PushService.b(i1);
      String str13 = a.getString(z[19], z[25]);
      if (!str13.equals(z[25]))
        PushService.A = str13;
      str14 = a.getString(z[26], z[25]);
      if (!str14.equals(z[25]))
      {
        if (!str14.toLowerCase().equals(z[23]))
          break label1370;
        PushService.a(true);
      }
    }
    while (true)
    {
      int i2 = a.getInt(z[21], -1);
      if (i2 != -1)
        PushService.c(i2);
      int i3 = a.getInt(z[4], -1);
      if (i3 != -1)
        PushService.D = i3;
      int i4 = a.getInt(z[15], -1);
      if (i4 != -1)
        ServiceInterface.c(i4);
      int i5 = a.getInt(z[34], -1);
      if (i5 != -1)
        ServiceInterface.d(i5);
      String str15 = a.getString(z[32], z[25]);
      if (!str15.equals(z[25]))
        ServiceInterface.a(str15);
      String str16 = a.getString(z[5], z[25]);
      if (!str16.equals(z[25]))
        ServiceInterface.b(str16);
      long l = a.getLong(z[27], -1L);
      if (-1L != l)
        PushService.e = l;
      return;
      if (!str1.toLowerCase().equals(z[9]))
        break;
      PushService.b = false;
      break;
      label1217: if (!str2.toLowerCase().equals(z[9]))
        break label135;
      PushService.C = false;
      break label135;
      label1240: if (!str3.toLowerCase().equals(z[9]))
        break label189;
      PushService.d(false);
      break label189;
      label1263: if (!str4.toLowerCase().equals(z[9]))
        break label266;
      PushService.q = false;
      break label266;
      label1286: if (i != 0)
        break label323;
      PushService.r = false;
      break label323;
      label1298: if (!str5.toLowerCase().equals(z[9]))
        break label406;
      PushService.B = false;
      break label406;
      label1322: if (!str7.toLowerCase().equals(z[9]))
        break label495;
      PushService.c(false);
      break label495;
      label1346: if (!str8.toLowerCase().equals(z[9]))
        break label552;
      PushService.b(false);
      break label552;
      label1370: if (str14.toLowerCase().equals(z[9]))
        PushService.a(false);
    }
  }

  public static void a(Context paramContext)
  {
    try
    {
      c(paramContext);
      a();
      return;
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
    }
  }

  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    int i = 1;
    SharedPreferences.Editor localEditor = c(paramContext).edit();
    String str1 = paramJSONObject.optString(z[29], z[25]);
    if (!str1.equals(z[25]))
      localEditor.putString(z[29], str1);
    String str2 = paramJSONObject.optString(z[26], z[25]);
    if (!str2.equals(z[25]))
      localEditor.putString(z[26], str2);
    int j = paramJSONObject.optInt(z[11], -1);
    if (j != -1)
      localEditor.putInt(z[11], j);
    int k = paramJSONObject.optInt(z[12], -1);
    if (k != -1)
      localEditor.putInt(z[12], k);
    int m = paramJSONObject.optInt(z[2], -1);
    if (m != -1)
      localEditor.putInt(z[2], m);
    String str3 = paramJSONObject.optString(z[20], z[25]);
    if (!str3.equals(z[25]))
      localEditor.putString(z[20], str3);
    String str4 = paramJSONObject.optString(z[8], z[25]);
    if (!str4.equals(z[25]))
      localEditor.putString(z[8], str4);
    String str5 = paramJSONObject.optString(z[6], z[25]);
    if (!str5.equals(z[25]))
      localEditor.putString(z[6], str5);
    String str6 = paramJSONObject.optString(z[7], z[25]);
    if (!str6.equals(z[25]))
      localEditor.putString(z[7], str6);
    int n = paramJSONObject.optInt(z[31], -1);
    if (n != -1)
      localEditor.putInt(z[31], n);
    String str7 = paramJSONObject.optString(z[16], z[25]);
    if (!str7.equals(z[25]))
      localEditor.putString(z[16], str7);
    String str8 = paramJSONObject.optString(z[3], z[25]);
    if (!str8.equals(z[25]))
      localEditor.putString(z[3], str8);
    String str9 = paramJSONObject.optString(z[13], z[25]);
    if (!str9.equals(z[25]))
      localEditor.putString(z[13], str9);
    String str10 = paramJSONObject.optString(z[18], z[25]);
    if (!str10.equals(z[25]))
      localEditor.putString(z[18], str10);
    String str11 = paramJSONObject.optString(z[19], z[25]);
    if (!str11.equals(z[25]))
      localEditor.putString(z[19], str11);
    String str12 = paramJSONObject.optString(z[22], z[25]);
    if (!str12.equals(z[25]))
      localEditor.putString(z[22], str12);
    String str13 = paramJSONObject.optString(z[14], z[25]);
    if (!str13.equals(z[25]))
      localEditor.putString(z[14], str13);
    int i1 = paramJSONObject.optInt(z[17], -1);
    if (i1 != -1)
      localEditor.putInt(z[17], i1);
    int i2 = paramJSONObject.optInt(z[15], -1);
    if (i2 != -1)
      localEditor.putInt(z[15], i2);
    int i3 = paramJSONObject.optInt(z[34], -1);
    if (i3 != -1)
      localEditor.putInt(z[34], i3);
    String str14 = paramJSONObject.optString(z[32], z[25]);
    if (!str14.equals(z[25]))
      localEditor.putString(z[32], str14);
    String str15 = paramJSONObject.optString(z[5], z[25]);
    if (!str15.equals(z[25]))
      localEditor.putString(z[5], str15);
    int i4 = paramJSONObject.optInt(z[i], -1);
    if (i4 != -1)
      localEditor.putInt(z[i], i4);
    String str16 = paramJSONObject.optString(z[46], z[25]);
    if (!str16.equals(z[25]))
      localEditor.putString(z[46], str16);
    String str17 = paramJSONObject.optString(z[38], z[25]);
    if (!str17.equals(z[25]))
      localEditor.putString(z[38], str17);
    String str18 = paramJSONObject.optString(z[39], z[25]);
    String[] arrayOfString1;
    ArrayList localArrayList;
    int i6;
    String[] arrayOfString3;
    if (!str18.equals(z[25]))
    {
      String str19 = z[40];
      if (!Pattern.compile(z[37] + str19 + z[44] + str19 + z[45] + str19 + z[48]).matcher(str18).matches())
        break label1650;
      arrayOfString1 = str18.split("_");
      String str20 = arrayOfString1[i];
      new StringBuilder(z[36]).append(str20).toString();
      x.b();
      String[] arrayOfString2 = str20.split("-");
      localArrayList = new ArrayList();
      int i5 = arrayOfString2.length;
      i6 = 0;
      if (i6 < i5)
      {
        String str22 = arrayOfString2[i6];
        new StringBuilder(z[41]).append(str22).toString();
        x.b();
        arrayOfString3 = str22.split(z[47]);
      }
    }
    while (true)
    {
      int i7;
      try
      {
        Integer localInteger1 = Integer.valueOf(Integer.parseInt(arrayOfString3[0]));
        Integer localInteger2 = Integer.valueOf(Integer.parseInt(arrayOfString3[1]));
        if (localInteger2.intValue() > localInteger1.intValue())
        {
          i7 = localInteger1.intValue();
          if (i7 <= localInteger2.intValue())
          {
            if (localArrayList.contains(Integer.valueOf(i7)))
              break label1678;
            localArrayList.add(String.valueOf(i7));
            break label1678;
          }
        }
        else
        {
          new StringBuilder(z[43]).append(str18).toString();
          x.f();
          i = 0;
        }
        i6++;
      }
      catch (Exception localException)
      {
        new StringBuilder(z[43]).append(str18).toString();
        x.j();
        i = 0;
        continue;
      }
      if (i != 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfString1[0] + "_");
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          localStringBuilder.append((String)localIterator.next());
          localStringBuilder.append("-");
        }
        localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        String str21 = localStringBuilder.toString();
        localEditor.putString(z[39], str21);
        new StringBuilder(z[42]).append(str21).toString();
        x.c();
      }
      while (true)
      {
        long l = paramJSONObject.optLong(z[27], -1L);
        if (l != -1L)
          localEditor.putLong(z[27], l);
        localEditor.commit();
        a();
        return;
        label1650: new StringBuilder(z[43]).append(str18).toString();
        x.f();
      }
      label1678: i7++;
    }
  }

  public static short b(Context paramContext)
  {
    SharedPreferences.Editor localEditor = c(paramContext).edit();
    short s = (short)((1 + a.getInt(z[0], 100)) % 32767);
    localEditor.putInt(z[0], s);
    localEditor.commit();
    return s;
  }

  public static void b(Context paramContext, String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = c(paramContext).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }

  public static void b(Context paramContext, String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = c(paramContext).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }

  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = c(paramContext).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }

  private static SharedPreferences c(Context paramContext)
  {
    if (a == null)
      a = paramContext.getSharedPreferences(z[35], 0);
    return a;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.ae
 * JD-Core Version:    0.6.2
 */