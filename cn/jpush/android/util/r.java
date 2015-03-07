package cn.jpush.android.util;

import android.content.Context;
import cn.jpush.android.data.f;
import cn.jpush.android.service.PushService;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
{
  private static final String[] z;
  protected int a = 0;
  protected boolean b = false;
  private int c = 2;
  private int d = 0;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  private Context i;
  private ArrayList<f> j = new ArrayList();

  static
  {
    Object localObject1 = new String[20];
    int k = 0;
    String str1 = "oNzFR@pGDEJpaiPIrpS";
    int m = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int n = localObject3.length;
    int i1 = 0;
    label36: Object localObject4;
    int i2;
    int i3;
    Object localObject5;
    label52: int i4;
    int i5;
    if (n <= 1)
    {
      localObject4 = localObject3;
      i2 = i1;
      i3 = n;
      localObject5 = localObject3;
      i4 = localObject5[i1];
      switch (i2 % 5)
      {
      default:
        i5 = 53;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i1] = ((char)(i5 ^ i4));
      i1 = i2 + 1;
      if (i3 == 0)
      {
        localObject5 = localObject4;
        i2 = i1;
        i1 = i3;
        break label52;
      }
      n = i3;
      localObject3 = localObject4;
      if (n > i1)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (m)
      {
      default:
        localObject1[k] = str2;
        k = 1;
        str1 = "旀忕夲尮Ｏ";
        localObject1 = localObject2;
        m = 0;
        break;
      case 0:
        localObject1[k] = str2;
        k = 2;
        str1 = "剌佛旣闕Ｏ";
        m = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[k] = str2;
        k = 3;
        str1 = "Or`R]znzFR@p";
        m = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[k] = str2;
        k = 4;
        str1 = "Fm{UPKv";
        m = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[k] = str2;
        k = 5;
        str1 = "Q{eD";
        m = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[k] = str2;
        k = 6;
        str1 = "Lv|LP";
        m = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[k] = str2;
        k = 7;
        str1 = "黽讦匐夆尺＿3%\023\001\025";
        m = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[k] = str2;
        k = 8;
        str1 = "视枒戅劾";
        m = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[k] = str2;
        k = 9;
        str1 = "IgcDYV";
        m = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[k] = str2;
        k = 10;
        str1 = "弥姉觶枱\033\013,";
        m = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[k] = str2;
        k = 11;
        str1 = "UcvJPQ";
        m = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[k] = str2;
        k = 12;
        str1 = "QkxD";
        m = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[k] = str2;
        k = 13;
        str1 = "HmqD";
        m = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[k] = str2;
        k = 14;
        str1 = "视枒夤贄Ｏ";
        m = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[k] = str2;
        k = 15;
        str1 = "丯抧命朾Ｏ";
        m = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[k] = str2;
        k = 16;
        str1 = "UggHZA";
        m = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[k] = str2;
        k = 17;
        str1 = "攓刲朘劀举叴挅仱［";
        m = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[k] = str2;
        k = 18;
        str1 = "丯抧樴弮Ｏ";
        m = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[k] = str2;
        k = 19;
        str1 = "旀忕筜纆Ｏ";
        m = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[k] = str2;
        z = localObject2;
        return;
        i5 = 37;
        continue;
        i5 = 2;
        continue;
        i5 = 21;
        continue;
        i5 = 33;
      }
    }
  }

  private void a(String paramString)
  {
    int k = paramString.length();
    while (k > 0)
    {
      k--;
      switch (paramString.charAt(k))
      {
      default:
        break;
      case 'd':
        this.a = (0x2 | this.a);
        break;
      case 'v':
        this.a = (0x1 | this.a);
        break;
      case 'i':
        this.a = (0x4 | this.a);
        break;
      case 'w':
        this.a = (0x8 | this.a);
        break;
      case 'e':
        this.a = (0x10 | this.a);
      }
    }
  }

  private void b()
  {
    JSONObject localJSONObject = d();
    if (localJSONObject != null)
    {
      x.b(z[0], localJSONObject.toString());
      ac.b(this.i, localJSONObject);
    }
  }

  private void c()
  {
    this.b = false;
    this.d = 0;
    this.h = 0L;
    this.e = 0L;
    this.f = 0L;
    this.a = 0;
    this.g = 0L;
    this.c = 2;
    this.i = null;
    this.j.clear();
  }

  private JSONObject d()
  {
    if (this.j == null)
      return null;
    int k = this.j.size();
    if (k <= 0)
      return null;
    JSONArray localJSONArray = new JSONArray();
    for (int m = 0; m < k; m++)
      localJSONArray.put(((f)this.j.get(m)).b());
    if (localJSONArray.length() <= 0)
      return null;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[4], localJSONArray);
      localJSONObject.put(z[5], z[3]);
      localJSONObject.put(z[6], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  protected final void a()
  {
    if (this.b)
    {
      if (System.currentTimeMillis() - this.g < this.h)
        break label32;
      b();
      c();
    }
    label32: 
    while ((this.c != 1) || (System.currentTimeMillis() - this.f < this.e))
      return;
    synchronized (this.j)
    {
      b();
      this.j.clear();
      this.d = 0;
      this.f = System.currentTimeMillis();
      return;
    }
  }

  protected final void a(Context paramContext, String paramString)
  {
    x.b(z[0], z[17] + paramString);
    x.b(z[0], z[10]);
    while (true)
    {
      try
      {
        if (this.b)
        {
          this.b = false;
          b();
          c();
        }
        this.i = paramContext;
        JSONObject localJSONObject = new JSONObject(paramString);
        String str1 = localJSONObject.getString(z[13]);
        String str2 = localJSONObject.getString(z[9]);
        if (str1 != null)
        {
          if (str1.equals(z[11]))
            this.c = 2;
        }
        else
        {
          a(str2);
          this.h = (1000L * localJSONObject.getLong(z[12]));
          x.b(z[0], z[18] + str1);
          x.b(z[0], z[19] + str2);
          if (this.c != 1)
            break label386;
          this.e = (1000L * localJSONObject.getLong(z[16]));
          this.f = System.currentTimeMillis();
          x.b(z[0], z[15] + this.e / 1000L + "s");
          if (this.h < 300000L)
            this.c = 2;
          this.g = System.currentTimeMillis();
          this.b = true;
          x.b(z[0], z[8]);
          return;
        }
        if (!str1.equals(z[16]))
          continue;
        this.c = 1;
        continue;
      }
      catch (JSONException localJSONException)
      {
        c();
        x.b(z[0], z[14] + localJSONException.getMessage());
        return;
      }
      label386: x.b(z[0], z[7]);
    }
  }

  protected final void a(f paramf)
  {
    if (this.b)
      while (true)
      {
        synchronized (this.j)
        {
          this.d += paramf.a();
          x.b(z[0], z[1] + paramf.a());
          x.b(z[0], z[2] + (this.h - (System.currentTimeMillis() - this.g)) / 1000L + "s");
          switch (this.c)
          {
          default:
            return;
          case 1:
            if (System.currentTimeMillis() - this.g >= this.h)
            {
              b();
              c();
            }
            break;
          case 2:
          }
        }
        if (System.currentTimeMillis() - this.f > this.e);
        synchronized (this.j)
        {
          b();
          this.j.clear();
          this.d = 0;
          this.f = System.currentTimeMillis();
          this.j.add(paramf);
        }
        b();
        c();
        continue;
        if (this.d >= 10240L)
        {
          b();
          this.j.clear();
          this.d = paramf.a();
        }
        this.j.add(paramf);
      }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.r
 * JD-Core Version:    0.6.2
 */