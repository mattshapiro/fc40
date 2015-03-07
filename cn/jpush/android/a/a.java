package cn.jpush.android.a;

import cn.jpush.android.util.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  private static final String z;
  private int a;
  private int b;
  private int c;
  private int d;
  private String e;
  private double f;
  private double g;

  static
  {
    Object localObject1 = "~+\035/mi@\032h; mRhljk\027&dFf\013$uwp=%e`+Doe)+\022%bd}\027%oD{\033+Bjm\033h; mRhljk\027&dKl\n=nwb=%e`+Doe)+\f+elf*3q`+Dh$v+Rhmd}\\p$c%\\&ob+Dogx".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    int m;
    Object localObject3;
    label27: int n;
    int i1;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      m = i;
      localObject3 = localObject1;
      n = localObject3[j];
      switch (k % 5)
      {
      default:
        i1 = 1;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject3[j] = ((char)(i1 ^ n));
      j = k + 1;
      if (m == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = m;
        break label27;
      }
      i = m;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i1 = 5;
      continue;
      i1 = 9;
      continue;
      i1 = 126;
      continue;
      i1 = 74;
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final void a(int paramInt)
  {
    this.a = paramInt;
  }

  public final void a(String paramString)
  {
    this.e = paramString;
  }

  public final JSONArray b()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(new JSONObject(toString()));
      return localJSONArray;
    }
    catch (JSONException localJSONException)
    {
      a.class.getSimpleName();
      localJSONException.getMessage();
      x.f();
    }
    return null;
  }

  public final void b(int paramInt)
  {
    this.b = paramInt;
  }

  public final void c(int paramInt)
  {
    this.c = paramInt;
  }

  public final void d(int paramInt)
  {
    this.d = paramInt;
  }

  public String toString()
  {
    try
    {
      String str1 = z;
      Object[] arrayOfObject = new Object[7];
      arrayOfObject[0] = Integer.valueOf(this.a);
      arrayOfObject[1] = Integer.valueOf(this.b);
      arrayOfObject[2] = Integer.valueOf(this.d);
      arrayOfObject[3] = Integer.valueOf(this.c);
      arrayOfObject[4] = this.e;
      arrayOfObject[5] = Double.valueOf(this.f);
      arrayOfObject[6] = Double.valueOf(this.g);
      String str2 = String.format(str1, arrayOfObject);
      return str2;
    }
    catch (Exception localException)
    {
    }
    return "";
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.a
 * JD-Core Version:    0.6.2
 */