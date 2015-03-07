package cn.jpush.android.service;

import android.content.Context;
import cn.jpush.android.a.d;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ac;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class l extends d
{
  private static final String[] A;

  static
  {
    Object localObject1 = new String[16];
    int i = 0;
    String str1 = ",/D";
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
        str1 = "8,^\\";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "<6QQ";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "\0070TY\005\"0Y\002Q";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "'0Tg\006\"9^";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "'0Tg\030%9X";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "?&G]";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\0346QQQ':Y_\005#e\027";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "(:[T.?0@]\0038";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "'0Tg\022.3[";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "\"+^U\024";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "<6QQ.?0@]\0038";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "'0Tg\026;,";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "*3[";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "(:[T";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "%:CO\03694hL\b;:";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        A = localObject2;
        return;
        i3 = 75;
        continue;
        i3 = 95;
        continue;
        i3 = 55;
        continue;
        i3 = 56;
      }
    }
  }

  l(PushService paramPushService, Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramString, paramBoolean1, paramBoolean2);
  }

  private static boolean a(JSONArray paramJSONArray1, JSONArray paramJSONArray2, String paramString)
  {
    if (ai.a(paramString))
    {
      if (!ai.a(PushService.m()))
        return false;
    }
    else if (!paramString.equals(PushService.m()))
      return false;
    if (ai.a(PushService.n()))
    {
      if ((paramJSONArray2 != null) && (paramJSONArray2.length() != 0))
        return false;
    }
    else
    {
      if (paramJSONArray2 == null)
        return false;
      if (paramJSONArray2.length() == 0)
        return false;
      if (!PushService.n().equals(paramJSONArray2.toString()))
        return false;
      x.d();
    }
    if (ai.a(PushService.o()))
    {
      if ((paramJSONArray1 != null) && (paramJSONArray1.length() != 0))
        return false;
    }
    else
    {
      if (paramJSONArray1 == null)
        return false;
      if (paramJSONArray1.length() == 0)
        return false;
      try
      {
        String str = ((JSONObject)paramJSONArray1.get(0)).optString(A[1]);
        if (!ai.a(str))
        {
          boolean bool = str.equals(PushService.o());
          if (!bool)
            return false;
        }
      }
      catch (Exception localException)
      {
        return false;
      }
    }
    return true;
  }

  public final void d()
  {
    JSONArray localJSONArray1;
    JSONArray localJSONArray2;
    JSONArray localJSONArray3;
    String str1;
    while (true)
    {
      try
      {
        boolean bool1 = PushService.p();
        if (!bool1)
          return;
        if (this.a.equals(A[8]))
        {
          JSONArray localJSONArray7 = b();
          JSONObject localJSONObject5 = a.a(A[9], localJSONArray7);
          if ((localJSONObject5 != null) && (localJSONObject5.length() > 0))
          {
            ac.a(this.e.getApplicationContext(), localJSONObject5);
            new StringBuilder(A[3]).append(localJSONObject5).toString();
            x.d();
          }
          return;
        }
        if (this.a.equals(A[11]))
        {
          JSONArray localJSONArray6 = c();
          JSONObject localJSONObject4 = a.a(A[4], localJSONArray6);
          if ((localJSONObject4 == null) || (localJSONObject4.length() <= 0))
            continue;
          ac.a(this.e.getApplicationContext(), localJSONObject4);
          new StringBuilder(A[7]).append(localJSONObject4.toString().getBytes().length).toString();
          x.d();
          new StringBuilder(A[3]).append(localJSONObject4).toString();
          x.d();
          continue;
        }
      }
      catch (Exception localException1)
      {
        x.j();
        return;
        if (this.a.equals(A[0]))
        {
          String str2 = a();
          if (str2 == null)
            continue;
          boolean bool3 = "".equals(str2);
          if (bool3)
            continue;
          try
          {
            JSONObject localJSONObject2 = new JSONObject(str2);
            JSONArray localJSONArray5 = new JSONArray();
            localJSONArray5.put(localJSONObject2);
            JSONObject localJSONObject3 = a.a(A[12], localJSONArray5);
            if ((localJSONObject3 == null) || (localJSONObject3.length() <= 0))
              continue;
            ac.a(this.e.getApplicationContext(), localJSONObject3);
            new StringBuilder(A[3]).append(localJSONObject3).toString();
            x.d();
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.getMessage();
            x.f();
          }
          continue;
        }
      }
      finally
      {
        g();
      }
      if (this.a.equals(A[13]))
      {
        localJSONArray1 = c();
        localJSONArray2 = b();
        localJSONArray3 = new JSONArray();
        str1 = a();
        if (!a(localJSONArray1, localJSONArray2, str1))
          break;
        x.d();
      }
    }
    if (str1 != null)
    {
      boolean bool2 = "".equals(str1);
      if (bool2);
    }
    while (true)
    {
      try
      {
        while (true)
        {
          localJSONArray3.put(new JSONObject(str1));
          localJSONArray4 = localJSONArray3;
          JSONObject localJSONObject1 = new JSONObject();
          try
          {
            localJSONObject1.put(A[6], A[5]);
            localJSONObject1.put(A[10], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
            localJSONObject1.put(A[15], a.d(this.e.getApplicationContext()));
            if ((localJSONArray1 != null) && (localJSONArray1.length() > 0))
            {
              localJSONObject1.put(A[2], localJSONArray1);
              PushService.f(((JSONObject)localJSONArray1.get(0)).optString(A[1]));
            }
            if ((localJSONArray2 != null) && (localJSONArray2.length() > 0))
            {
              localJSONObject1.put(A[14], localJSONArray2);
              PushService.g(localJSONArray2.toString());
            }
            if ((localJSONArray4 != null) && (localJSONArray4.length() > 0))
            {
              localJSONObject1.put(A[0], localJSONArray4);
              PushService.h(str1);
            }
            ac.a(this.e.getApplicationContext(), localJSONObject1);
          }
          catch (JSONException localJSONException1)
          {
          }
        }
      }
      catch (Exception localException2)
      {
        localJSONArray4 = null;
        continue;
      }
      JSONArray localJSONArray4 = localJSONArray3;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.l
 * JD-Core Version:    0.6.2
 */