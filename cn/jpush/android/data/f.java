package cn.jpush.android.data;

import cn.jpush.android.util.ai;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  private static final String[] z;
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;

  static
  {
    Object localObject1 = new String[8];
    int i = 0;
    String str1 = "cnL";
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
        i3 = 80;
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
        str1 = "z|L";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "ztFZ";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "bx]Z<}iY";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "bx]Z<";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "-w[J#f>";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "Rs";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = ".=";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 14;
        continue;
        i3 = 29;
        continue;
        i3 = 43;
        continue;
        i3 = 63;
      }
    }
  }

  public f()
  {
  }

  public f(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.a = paramInt;
    this.e = paramString1;
    this.c = paramString3;
    this.b = paramString2;
    this.d = paramString4;
  }

  public final int a()
  {
    return toString().getBytes().length;
  }

  public final JSONObject b()
  {
    int i = 1;
    JSONObject localJSONObject = new JSONObject();
    if ((ai.a(this.d)) || (ai.a(this.e)) || (ai.a(this.b)) || (ai.a(this.c)))
      i = 0;
    if (i == 0)
      return null;
    try
    {
      localJSONObject.put(z[4], this.a);
      localJSONObject.put(z[3], this.e);
      localJSONObject.put(z[2], this.d);
      localJSONObject.put(z[1], this.b);
      localJSONObject.put(z[0], this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }

  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  public final int hashCode()
  {
    return super.hashCode();
  }

  public final String toString()
  {
    if ((this.c != null) && (this.c.contains(z[6])))
      this.c.replaceAll(z[6], z[5]);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a).append(z[7]);
    localStringBuffer.append(this.e).append(z[7]);
    localStringBuffer.append(this.d).append(z[7]);
    localStringBuffer.append(this.b).append(z[7]);
    localStringBuffer.append(this.c).append(z[7]);
    return localStringBuffer.toString();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.f
 * JD-Core Version:    0.6.2
 */