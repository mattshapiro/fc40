package cn.jpush.android.service;

import android.text.TextUtils;
import cn.jpush.android.util.x;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
{
  private static final HashMap<Integer, String> a;
  private static final HashMap<Integer, String> b;
  private static long c = 0L;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[8];
    int i = 0;
    String str1 = "7}?\"i\025}t)t\020|&le\rw1l+B";
    int j = -1;
    Object localObject2 = localObject1;
    int i10;
    label133: String str2;
    while (true)
    {
      Object localObject3 = str1.toCharArray();
      int k = localObject3.length;
      int m = 0;
      if (k <= 1);
      while (k > m)
      {
        Object localObject7 = localObject3;
        int i7 = m;
        int i8 = k;
        Object localObject8 = localObject3;
        while (true)
        {
          int i9 = localObject8[m];
          switch (i7 % 5)
          {
          default:
            i10 = 6;
            localObject8[m] = ((char)(i10 ^ i9));
            m = i7 + 1;
            if (i8 != 0)
              break label133;
            localObject8 = localObject7;
            i7 = m;
            m = i8;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        k = i8;
        localObject3 = localObject7;
      }
      str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "7}?\"i\025}t>c\022|&8&\001|0)&O3";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "\020~\"";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "\003c$%b";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "\003c$\023g\006w\013>k\024";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\026j$)";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "\003p %i\f";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\003w0";
        j = 6;
        localObject1 = localObject2;
      case 6:
      }
    }
    localObject1[i] = str2;
    z = localObject2;
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    Integer localInteger = Integer.valueOf(0);
    String str3 = "-X";
    int n = -1;
    label407: label545: String str4;
    while (true)
    {
      Object localObject4 = str3.toCharArray();
      int i1 = localObject4.length;
      int i2 = 0;
      if (i1 <= 1);
      while (i1 > i2)
      {
        Object localObject5 = localObject4;
        int i3 = i2;
        int i4 = i1;
        Object localObject6 = localObject4;
        int i5 = localObject6[i2];
        int i6;
        switch (i3 % 5)
        {
        default:
          i6 = 6;
        case 0:
        case 1:
        case 2:
        case 3:
        }
        while (true)
        {
          localObject6[i2] = ((char)(i6 ^ i5));
          i2 = i3 + 1;
          if (i4 != 0)
            break label545;
          localObject6 = localObject5;
          i3 = i2;
          i2 = i4;
          break label407;
          i10 = 98;
          break;
          i10 = 19;
          break;
          i10 = 84;
          break;
          i10 = 76;
          break;
          i6 = 98;
          continue;
          i6 = 19;
          continue;
          i6 = 84;
          continue;
          i6 = 76;
        }
        i1 = i4;
        localObject4 = localObject5;
      }
      str4 = new String((char[])localObject4).intern();
      switch (n)
      {
      default:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(-1001);
        str3 = "'k7)c\006369`\004v&lu\013i1b&21-u\00737#h\026r78&\021f$<i\020gz";
        n = 0;
        break;
      case 0:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(-1000);
        str3 = "!|:\"c\001g=#hBu5%j\007wzlV\016v5?cBp<)e\t3-#s\02037#h\fv78o\r}t-h\0063&)r\020jt g\026v&m";
        n = 1;
        break;
      case 1:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(-998);
        str3 = "1v:(o\ftt*g\0131(&\rat8o\017v;9rL3\004 c\003`1lT\007g&5&\016r )tC";
        n = 2;
        break;
      case 2:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(-997);
        str3 = "0v7)o\024z:+&\004r= c\0063;>&\026z9)i\027gzlV\016v5?cBA18t\03338-r\007au";
        n = 3;
        break;
      case 3:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(-996);
        str3 = "!|:\"c\001g=#hBz'le\016|')bL3\004 c\003`1lT\007g&5&\016r )tC";
        n = 4;
        break;
      case 4:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(-994);
        str3 = "0v'<i\f`1lr\013~1#s\026=t\034j\007r')&0v >B58c\0202";
        n = 5;
        break;
      case 5:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(-993);
        str3 = "+}\"-j\013wt?i\001x18(BC8)g\021vt\036c\026a-lj\003g1>'";
        n = 6;
        break;
      case 6:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(11);
        str3 = "$r= c\0063 #&\020v3%u\026v&m";
        n = 7;
        break;
      case 7:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(1005);
        str3 = ";|!>&\003c$\007c\03335\"bBr:(t\rz0lv\003p?-a\0073:-k\00735>cB};8&\017r /n\007wzlV\016v5?cBw;9d\016vt/n\007p?lr\nv9lg\001p;>b\013}3lr\r3\025<v\016z7-r\013|:l\rft/t\007r )bB|:lV\ra -jL";
        n = 8;
        break;
      case 8:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(1006);
        str3 = ";|!lg\fw&#o\0063$-e\tr3)&\fr9)&\013`t\"i\026314o\021gxlV\016v5?cBa1+o\021g1>&\033|!>&\022r7-m\005vt\"g\017vt%hBC;>r\003z";
        n = 9;
        break;
      case 9:
        localHashMap.put(localInteger, str4);
        localHashMap = a;
        localInteger = Integer.valueOf(1007);
        str3 = "+}\"-j\013wt\005k\007zxlT\007t=?r\007at-a\003z:b";
        n = 10;
        break;
      case 10:
        localHashMap.put(localInteger, str4);
        localHashMap = new HashMap();
        b = localHashMap;
        localInteger = Integer.valueOf(995);
        str3 = "/v'?g\005vt\006U-]t<g\020`=\"aB`!/e\007v0";
        n = 11;
        break;
      case 11:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(996);
        str3 = "/v'?g\005vt\006U-]t<g\020`=\"aBu5%j\007w";
        n = 12;
        break;
      case 12:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(997);
        str3 = "/v'?g\005vt-j\020v5(Ba1/c\013e1(*Bt=:cBf$";
        n = 13;
        break;
      case 13:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(998);
        str3 = "/v'?g\005vt-j\020v5(Ba1/c\013e1(*B` %j\0163$>i\001v'?";
        n = 14;
        break;
      case 14:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1000);
        str3 = "7`1>&\001=/m\007wt-h\0063;<c\fv0lr\nvt\001c\021`5+c";
        n = 15;
        break;
      case 15:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1001);
        str3 = "/v'?g\005vt(i\025}8#g\0063'9e\001v1(";
        n = 16;
        break;
      case 16:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1002);
        str3 = "/v'?g\005vt>c\001v=:c\0063'9e\001v1(";
        n = 17;
        break;
      case 17:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1003);
        str3 = "/v'?g\005vt?o\016v:/cBw;;h\016|5(&\021f7/c\007w";
        n = 18;
        break;
      case 18:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1004);
        str3 = "4z0)iB`= c\fp1lb\rd: g\rwt?s\001p1)b";
        n = 19;
        break;
      case 19:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1005);
        str3 = "7`1>&\001=/m\007wt:o\006v;lg\fwt&s\017c1(&\026|t9t\0163\031)u\021r3)&Jq&#q\021v&e";
        n = 20;
        break;
      case 20:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1008);
        str3 = "4z0)iBz'l`\ra7)&\001;?c\006365&\027`1>";
        n = 21;
        break;
      case 21:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1007);
        str3 = "7`1>&\001=/m\007wtkI)4";
        n = 22;
        break;
      case 22:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1006);
        str3 = "7`1>&\001=/m\007wtkE\003}7)jE";
        n = 23;
        break;
      case 23:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1011);
        str3 = "&|#\"j\rr0l`\003z8)b";
        n = 24;
        break;
      case 24:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1012);
        str3 = "7`1>&\001=/m\007wt8iBw;;h\016|5(&\003t5%h";
        n = 25;
        break;
      case 25:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1013);
        str3 = "6{1l`\0131lg\016a1-b\033314o\021gt-h\0063'-k\0073'%|\007=t\bi\f4 lb\rd: i\003wt-a\003z:b";
        n = 26;
        break;
      case 26:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1100);
        str3 = "+}\"-j\013wt<g\020r9li\0203!\"c\032c1/r\007wt>c\021f88(";
        n = 27;
        break;
      case 27:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1014);
        str3 = "$r= c\0063 #&\022a1 i\003wt>c\023f=>c\0063&)u\rf&/c";
        n = 28;
        break;
      case 28:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1015);
        str3 = "7`1>&\001=/m\007wt%h\021g5 jBr8)t\0263;\"&\021g58s\02136-tBr28c\02030#q\f;-b\013}3l`\013}=?n\007wz";
        n = 29;
        break;
      case 29:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1016);
        str3 = "7`1>&\001=/m\007wt8n\0073#)d\024z1;!\0213!>j";
        n = 30;
        break;
      case 30:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1017);
        str3 = "7`1>&\001=/m\007wt/g\016t-e\026z;\"";
        n = 31;
        break;
      case 31:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1018);
        str3 = "6{1lK\007`'-a\0073'$i\0253=\"&\026{1lu\026r 9uBq5>";
        n = 32;
        break;
      case 32:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1019);
        str3 = "!=/mBr$<j\013` lg\fwt?n\rdt8n\0073\031)u\021r3)";
        n = 33;
        break;
      case 33:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1020);
        str3 = "&|#\"&\013~5+cBu5%j\007w";
        n = 34;
        break;
      case 34:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1021);
        str3 = "&|#\"&\ng9 &\004r= c\006";
        n = 35;
        break;
      case 35:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1022);
        str3 = "&|#\"&/v'?g\005vt*g\0131(";
        n = 36;
        break;
      case 36:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1030);
        str3 = "";
        n = 37;
        break;
      case 37:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1031);
        str3 = "1g;<&\022f'$&\021v&:o\001v";
        n = 38;
        break;
      case 38:
        localHashMap.put(localInteger, str4);
        localHashMap = b;
        localInteger = Integer.valueOf(1032);
        str3 = "0v'9k\0073$9u\n3')t\024z7)";
        n = 39;
      case 39:
      }
    }
    localHashMap.put(localInteger, str4);
  }

  public static String a(int paramInt)
  {
    if (!a.containsKey(Integer.valueOf(paramInt)))
    {
      new StringBuilder(z[0]).append(paramInt).toString();
      x.c();
      return null;
    }
    return (String)a.get(Integer.valueOf(paramInt));
  }

  public static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(z[6], z[7]);
      localJSONObject.put(z[3], paramString);
      localJSONObject.put(z[5], z[4]);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public static String b(int paramInt)
  {
    if (!b.containsKey(Integer.valueOf(paramInt)))
    {
      new StringBuilder(z[1]).append(paramInt).toString();
      x.c();
      return "";
    }
    return (String)b.get(Integer.valueOf(paramInt));
  }

  public static JSONObject b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(z[6], z[2]);
      localJSONObject.put(z[3], paramString);
      localJSONObject.put(z[5], z[4]);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.p
 * JD-Core Version:    0.6.2
 */