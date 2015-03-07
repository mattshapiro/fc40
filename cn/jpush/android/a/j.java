package cn.jpush.android.a;

import android.net.wifi.ScanResult;
import cn.jpush.android.util.x;
import org.json.JSONObject;

public final class j
  implements Comparable<j>
{
  private static final String[] z;
  public final String a;
  public final int b;
  public final String c;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "-Z|";
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
          i3 = 57;
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
        str1 = "!\\z\"X(Yk\030J?";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "?T~\023X bj\tK)S~\tQ";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 76;
        break label96;
        i3 = 61;
        break label96;
        i3 = 25;
        break label96;
        i3 = 125;
        break label96;
        m = 0;
      }
    }
  }

  public j(i parami, ScanResult paramScanResult)
  {
    this.a = paramScanResult.BSSID;
    this.b = paramScanResult.level;
    this.c = paramScanResult.SSID;
  }

  public j(i parami, String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
  }

  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      String str = this.a;
      localJSONObject.put(z[1], str);
      int i = this.b;
      localJSONObject.put(z[2], i);
      localJSONObject.put(z[0], 0);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      x.j();
    }
    return localJSONObject;
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    j localj;
    do
    {
      return true;
      if (!(paramObject instanceof j))
        break;
      localj = (j)paramObject;
    }
    while ((localj.b == this.b) && (localj.a.equals(this.a)));
    return false;
  }

  public final int hashCode()
  {
    return this.b ^ this.a.hashCode();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.j
 * JD-Core Version:    0.6.2
 */