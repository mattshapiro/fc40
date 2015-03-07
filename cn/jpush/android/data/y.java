package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.api.m;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import org.json.JSONObject;

public final class y extends d
{
  private static final String[] ab;
  public String W;
  public String X;
  public String Y;
  public String Z;
  public int a;
  public String aa;

  static
  {
    Object localObject1 = new String[6];
    int i = 0;
    String str1 = "H]\037Fhj]T^nyV\033\bsdC\021\b*=";
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
        i3 = 7;
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
        str1 = "kl\001Zk";
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
        str1 = "kl\035Far";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "kl\021]uq";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "kl\031L2";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        ab = localObject2;
        return;
        i3 = 29;
        continue;
        i3 = 51;
        continue;
        i3 = 116;
        continue;
        i3 = 40;
      }
    }
  }

  public y()
  {
    this.o = 2;
  }

  public final void a(Context paramContext)
  {
    x.b();
    ServiceInterface.a(this.c, 995, paramContext);
    if (this.a == 0)
    {
      if (a.b(paramContext))
        ServiceInterface.a(paramContext, this);
      return;
    }
    if (this.a == 1)
    {
      m.a(paramContext, this);
      return;
    }
    new StringBuilder(ab[0]).append(this.a).toString();
    x.c();
  }

  public final boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    x.b();
    this.a = paramJSONObject.optInt(ab[2], 0);
    this.W = paramJSONObject.optString(ab[1], "");
    this.X = paramJSONObject.optString(ab[4], "");
    this.Z = paramJSONObject.optString(ab[5], "");
    this.Y = paramJSONObject.optString(ab[3], "");
    return true;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.y
 * JD-Core Version:    0.6.2
 */