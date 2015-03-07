package cn.jpush.android.util;

import org.json.JSONException;
import org.json.JSONObject;

final class u
  implements Runnable
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "X+aC\022`\035aR";
    int i = -1;
    String[] arrayOfString2 = arrayOfString1;
    int j = 0;
    Object localObject1 = str1.toCharArray();
    int k = localObject1.length;
    int m;
    label35: int i3;
    if (k <= 1)
    {
      m = 0;
      Object localObject2 = localObject1;
      int n = m;
      int i1 = k;
      Object localObject3 = localObject1;
      while (true)
      {
        int i2 = localObject3[m];
        switch (n % 5)
        {
        default:
          i3 = 125;
          label96: localObject3[m] = ((char)(i3 ^ i2));
          m = n + 1;
          if (i1 != 0)
            break label133;
          localObject3 = localObject2;
          n = m;
          m = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label133: k = i1;
      localObject1 = localObject2;
    }
    while (true)
    {
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject1).intern();
      switch (i)
      {
      default:
        arrayOfString2[j] = str2;
        str1 = "`\034tO\017fYhO\032(";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 18;
        break label96;
        i3 = 121;
        break label96;
        i3 = 4;
        break label96;
        i3 = 32;
        break label96;
        m = 0;
      }
    }
  }

  u(JSONObject paramJSONObject)
  {
  }

  public final void run()
  {
    try
    {
      x.c(z[0], z[1] + this.a.toString(1));
      return;
    }
    catch (JSONException localJSONException)
    {
      x.c(z[0], z[1] + this.a.toString());
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.u
 * JD-Core Version:    0.6.2
 */