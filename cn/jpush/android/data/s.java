package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.util.h;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import org.json.JSONObject;

public final class s extends d
{
  private static final String[] bb;
  public int W;
  public boolean X;
  public ArrayList<String> Y = new ArrayList();
  public String Z = "";
  public String a;
  public String aa = "";
  public String ab;

  static
  {
    Object localObject1 = new String[6];
    int i = 0;
    String str1 = "J\026D6\"S";
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
        i3 = 87;
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
        str1 = "[&n*;";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "[&~*2M";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "[&h08I";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "[&i=$";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "X\013t5\bP\fv";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        bb = localObject2;
        return;
        i3 = 62;
        continue;
        i3 = 121;
        continue;
        i3 = 27;
        continue;
        i3 = 88;
      }
    }
  }

  public s()
  {
    this.o = 0;
  }

  public final void a(Context paramContext)
  {
    x.b();
    new t(this, paramContext, this).start();
  }

  public final boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    x.b();
    this.a = paramJSONObject.optString(bb[1], "").trim();
    this.W = paramJSONObject.optInt(bb[3], 0);
    if (paramJSONObject.optInt(bb[4], 0) == 0);
    for (boolean bool = true; ; bool = false)
    {
      this.X = bool;
      if (this.X)
        this.Y = h.a(paramJSONObject.optJSONArray(bb[2]));
      this.Z = paramJSONObject.optString(bb[5], "");
      this.aa = paramJSONObject.optString(bb[0], "");
      return true;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.s
 * JD-Core Version:    0.6.2
 */