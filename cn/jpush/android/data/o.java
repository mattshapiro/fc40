package cn.jpush.android.data;

import cn.jpush.android.util.h;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  implements Serializable
{
  private static final String[] z;
  public String a;
  public String b;
  public String c;
  public String d;
  public boolean e;
  public String f;
  public String g;
  public String h;
  public boolean i;
  public String j;
  public ArrayList<String> k = new ArrayList();
  public String l;
  public String m;
  public String n;

  static
  {
    Object localObject1 = new String[14];
    int i1 = 0;
    String str1 = "\007-\016s@9=\016Aq,2";
    int i2 = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int i3 = localObject3.length;
    int i4 = 0;
    label36: Object localObject4;
    int i5;
    int i6;
    Object localObject5;
    label52: int i7;
    int i8;
    if (i3 <= 1)
    {
      localObject4 = localObject3;
      i5 = i4;
      i6 = i3;
      localObject5 = localObject3;
      i7 = localObject5[i4];
      switch (i5 % 5)
      {
      default:
        i8 = 16;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i4] = ((char)(i8 ^ i7));
      i4 = i5 + 1;
      if (i6 == 0)
      {
        localObject5 = localObject4;
        i5 = i4;
        i4 = i6;
        break label52;
      }
      i3 = i6;
      localObject3 = localObject4;
      if (i3 > i4)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (i2)
      {
      default:
        localObject1[i1] = str2;
        i1 = 1;
        str1 = "\0073\b~~\b;\037y";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "\0073\006pw=\n\nex";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "9\005\030r*?";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "9\005\031tc";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "9\005\002v7";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "9\005\002|q??4db4";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        i1 = 7;
        str1 = "9\005\002r6\005\036c|";
        i2 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i1] = str2;
        i1 = 8;
        str1 = "9\005\037xd4?";
        i2 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i1] = str2;
        i1 = 9;
        str1 = "9\005\035tb";
        i2 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i1] = str2;
        i1 = 10;
        str1 = "9\005\016db4";
        i2 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i1] = str2;
        i1 = 11;
        str1 = "9\005\016cu+";
        i2 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i1] = str2;
        i1 = 12;
        str1 = "9\005\037h`=";
        i2 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i1] = str2;
        i1 = 13;
        str1 = "9\005\030xj=";
        i2 = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i1] = str2;
        z = localObject2;
        return;
        i8 = 88;
        continue;
        i8 = 90;
        continue;
        i8 = 107;
        continue;
        i8 = 17;
      }
    }
  }

  public o(l paraml)
  {
  }

  private JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[8], this.a);
      localJSONObject.put(z[7], this.b);
      localJSONObject.put(z[9], this.c);
      localJSONObject.put(z[12], this.d);
      String str1 = z[3];
      int i1;
      String str2;
      int i2;
      if (this.e)
      {
        i1 = 0;
        localJSONObject.put(str1, i1);
        localJSONObject.put(z[13], this.f);
        localJSONObject.put(z[5], this.g);
        localJSONObject.put(z[6], this.h);
        localJSONObject.put(z[10], this.j);
        str2 = z[4];
        boolean bool = this.i;
        i2 = 0;
        if (!bool)
          break label209;
      }
      while (true)
      {
        localJSONObject.put(str2, i2);
        localJSONObject.put(z[11], h.a(this.k));
        return localJSONObject;
        i1 = 1;
        break;
        label209: i2 = 1;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public final String toString()
  {
    JSONObject localJSONObject = a();
    try
    {
      localJSONObject.put(z[1], this.l);
      localJSONObject.put(z[2], this.m);
      localJSONObject.put(z[0], this.n);
      label47: return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      break label47;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.o
 * JD-Core Version:    0.6.2
 */