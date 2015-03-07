package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.ai;
import org.json.JSONException;
import org.json.JSONObject;

public final class p
{
  private static final String[] z;

  static
  {
    Object localObject1 = new String[29];
    int i = 0;
    String str1 = "{\026<A";
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
        i3 = 53;
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
        str1 = "e1\fiYE;Z}G@W(";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "r\004\022|A\\#\022|A\\,'#\017\003pT\"";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "b\n6D\025O0\024|PT+";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "M<\016aZBe\026gTH\022\to_0\024NGC2/zY\frZ";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "j>\023dPH\016g\025K:\016(__0\024(S^0\027(@^3ZjPO>\017{PC9Za[Z>\026aQ\f*\bd\025\001";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "M;%aQ";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "_7\025jX&\nm";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "b\020ZEfk\026>";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "M<\016aZBe\niG_:5z\\K6\024iYa,\035EP_,\033oP\frZgGE8\023fT@\025\tg[\026U";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "A,\035W\\H";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "M;%|";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "y1\021fZ[\027{R\f+\003xP\frZ";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "M<\016aZBe\nzP|>\b{Pc-\023o\\B>\026EFK\022\037{FM8\037(\030\f0\baRE1\033d_0\0242?";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "X6\016dP";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "Y-\026";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "A:\t{TK:";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "\\-\037XT^,\037GGE8\023fT@\022\toxI,\tiRI\027{Re;Z5\025";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "^6\031`jA:\036aT";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "O0\024|PB+%|L\\:";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "b\020%Efk\026>";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "C)\037zGE;\037WX_8%aQ";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        i = 25;
        str1 = "X&\nm";
        j = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i] = str2;
        i = 26;
        str1 = "I'\016zT_";
        j = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i] = str2;
        i = 27;
        str1 = "";
        j = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i] = str2;
        i = 28;
        str1 = "y1\021fZ[1ZEfk\nzZX0\031gY\f)\037zFE0\024&\025k6\fm\025Y/Z%\025";
        j = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 44;
        continue;
        i3 = 95;
        continue;
        i3 = 122;
        continue;
        i3 = 8;
      }
    }
  }

  public static a a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    new StringBuilder(z[14]).append(paramString1).toString();
    cn.jpush.android.util.x.c();
    if (paramContext == null)
      throw new IllegalArgumentException(z[3]);
    if (TextUtils.isEmpty(paramString1))
    {
      cn.jpush.android.util.x.f();
      ServiceInterface.a(z[8], 996, paramContext);
      return null;
    }
    JSONObject localJSONObject1 = a(paramContext, z[22], paramString1);
    if (localJSONObject1 == null)
    {
      cn.jpush.android.util.x.c();
      return null;
    }
    String str = localJSONObject1.optString(z[11], "");
    if (ai.a(str));
    while (true)
    {
      if (ai.a(paramString4))
        paramString4 = localJSONObject1.optString(z[6], "");
      new StringBuilder(z[18]).append(paramString4).toString();
      cn.jpush.android.util.x.c();
      boolean bool;
      if (localJSONObject1.optInt(z[27], 0) == 1)
      {
        bool = true;
        if (!bool)
          break label454;
      }
      label454: for (int i = localJSONObject1.optInt(z[21], 0); ; i = 0)
      {
        a locala = new a();
        locala.c = paramString4;
        locala.a = localJSONObject1;
        locala.b = localJSONObject1.optInt(z[7], 3);
        locala.e = bool;
        locala.f = i;
        locala.g = localJSONObject1.optInt(z[23], 0);
        locala.i = localJSONObject1.optString(z[17], "");
        locala.j = localJSONObject1.optString(z[20], "");
        locala.k = localJSONObject1.optString(z[15], "");
        locala.l = localJSONObject1.optString(z[26], "");
        locala.m = paramString2;
        locala.n = paramString3;
        locala.d = localJSONObject1.optString(z[24], "");
        if (!ai.a(locala.i))
        {
          JSONObject localJSONObject2 = a(paramContext, paramString4, localJSONObject1, z[19]);
          if (localJSONObject2 != null)
          {
            locala.a(localJSONObject2.optString(z[16], ""));
            locala.T = localJSONObject2.optString(z[25], "");
            locala.a(true);
          }
        }
        return locala;
        bool = false;
        break;
      }
      paramString4 = str;
    }
  }

  private static JSONObject a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      cn.jpush.android.util.x.j();
      ServiceInterface.a(paramString1, 996, paramContext);
    }
    return null;
  }

  public static JSONObject a(Context paramContext, String paramString1, JSONObject paramJSONObject, String paramString2)
  {
    if (paramJSONObject == null)
    {
      cn.jpush.android.util.x.e();
      ServiceInterface.a(paramString1, 996, paramContext);
    }
    while (true)
    {
      return null;
      if (TextUtils.isEmpty(paramString2))
      {
        cn.jpush.android.util.x.e();
        return null;
      }
      try
      {
        if (!paramJSONObject.isNull(paramString2))
        {
          JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString2);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException)
      {
        cn.jpush.android.util.x.j();
        ServiceInterface.a(paramString1, 996, paramContext);
      }
    }
    return null;
  }

  public static void a(Context paramContext, a parama)
  {
    cn.jpush.android.util.x.b();
    if (paramContext == null)
      throw new IllegalArgumentException(z[3]);
    int i = parama.b;
    JSONObject localJSONObject1 = parama.a;
    String str1 = parama.c;
    if (i == 2)
    {
      String str2 = localJSONObject1.optString(z[10], "").trim();
      if (a(str2))
      {
        b(paramContext, str2, str1);
        return;
      }
      new StringBuilder(z[5]).append(str2).toString();
      cn.jpush.android.util.x.c();
      ServiceInterface.a(str1, 996, paramContext);
      return;
    }
    JSONObject localJSONObject2;
    if ((i == 1) || (i == 3) || (i == 4))
    {
      localJSONObject2 = a(paramContext, str1, localJSONObject1, z[10]);
      if (localJSONObject2 == null)
        cn.jpush.android.util.x.c();
    }
    else
    {
      new StringBuilder(z[28]).append(i).toString();
      cn.jpush.android.util.x.c();
      ServiceInterface.a(str1, 996, paramContext);
      return;
    }
    int j = localJSONObject2.optInt(z[12], -1);
    Object localObject;
    switch (j)
    {
    default:
      new StringBuilder(z[13]).append(j).toString();
      cn.jpush.android.util.x.e();
      ServiceInterface.a(str1, 996, paramContext);
      return;
    case 0:
      localObject = new s();
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      ((d)localObject).c = str1;
      ((d)localObject).b = i;
      ((d)localObject).o = j;
      ((d)localObject).h = parama.h;
      ((d)localObject).e = parama.e;
      ((d)localObject).f = parama.f;
      ((d)localObject).m = parama.m;
      ((d)localObject).d = parama.d;
      ((d)localObject).g = parama.g;
      boolean bool = ((d)localObject).b(paramContext, localJSONObject2);
      cn.jpush.android.util.x.b();
      if (!bool)
        break;
      ((d)localObject).a(paramContext);
      cn.jpush.android.util.x.b();
      return;
      localObject = new l();
      continue;
      localObject = new y();
      continue;
      localObject = new x();
    }
    cn.jpush.android.util.x.e();
  }

  public static void a(Context paramContext, String paramString)
  {
    new StringBuilder(z[9]).append(paramString).toString();
    cn.jpush.android.util.x.b();
    if (paramContext == null)
      throw new IllegalArgumentException(z[3]);
    if (TextUtils.isEmpty(paramString))
      cn.jpush.android.util.x.f();
    while (true)
    {
      return;
      JSONObject localJSONObject1 = a(paramContext, z[8], paramString);
      if (localJSONObject1 != null)
      {
        String str1 = localJSONObject1.optString(z[11], "");
        if (ai.a(str1))
          str1 = localJSONObject1.optString(z[6], "");
        int i = localJSONObject1.optInt(z[7], -1);
        if (i == 2)
        {
          String str2 = localJSONObject1.optString(z[10], "").trim();
          if (a(str2))
          {
            b(paramContext, str2, str1);
            return;
          }
          new StringBuilder(z[5]).append(str2).toString();
          cn.jpush.android.util.x.c();
          ServiceInterface.a(str1, 996, paramContext);
          return;
        }
        if (i == 1);
        for (JSONObject localJSONObject2 = a(paramContext, str1, localJSONObject1, z[10]); localJSONObject2 != null; localJSONObject2 = null)
        {
          int j = localJSONObject2.optInt(z[12], -1);
          Object localObject;
          switch (j)
          {
          default:
            new StringBuilder(z[13]).append(j).toString();
            cn.jpush.android.util.x.e();
            ServiceInterface.a(str1, 996, paramContext);
            return;
          case 0:
            localObject = new s();
          case 1:
          case 2:
          case 3:
          }
          while (true)
          {
            boolean bool = ((d)localObject).b(paramContext, localJSONObject2);
            cn.jpush.android.util.x.b();
            ((d)localObject).c = str1;
            ((d)localObject).b = i;
            ((d)localObject).o = j;
            if (!bool)
              break;
            ((d)localObject).a(paramContext);
            cn.jpush.android.util.x.b();
            return;
            localObject = new l();
            continue;
            localObject = new y();
            continue;
            localObject = new x();
          }
          cn.jpush.android.util.x.e();
          return;
        }
      }
    }
  }

  public static boolean a(String paramString)
  {
    boolean bool;
    if (TextUtils.isEmpty(paramString))
      bool = false;
    String str;
    do
    {
      return bool;
      str = paramString.trim();
      bool = str.matches(z[2]);
    }
    while (bool);
    new StringBuilder(z[1]).append(str).toString();
    cn.jpush.android.util.x.e();
    return bool;
  }

  public static boolean a(boolean paramBoolean, int paramInt, Context paramContext)
  {
    boolean bool = z[0].equalsIgnoreCase(cn.jpush.android.util.a.e(paramContext));
    return ((paramBoolean) && (paramInt == 0)) || ((paramBoolean) && (paramInt == 1) && (bool));
  }

  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    new StringBuilder(z[4]).append(paramString1).toString();
    cn.jpush.android.util.x.b();
    if (paramContext == null)
      throw new IllegalArgumentException(z[3]);
    new q(paramString1, paramContext, paramString2).start();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.p
 * JD-Core Version:    0.6.2
 */