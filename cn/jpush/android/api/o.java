package cn.jpush.android.api;

import android.os.Bundle;
import android.os.Message;
import cn.jpush.android.data.d;

final class o
  implements cn.jpush.android.util.p
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "U~G?L_";
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
          i3 = 47;
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
        str1 = "Zdx/]y|";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "Qhg9N[h].";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 60;
        break label96;
        i3 = 13;
        break label96;
        i3 = 20;
        break label96;
        i3 = 74;
        break label96;
        m = 0;
      }
    }
  }

  o(p paramp, int paramInt, d paramd)
  {
  }

  public final void a(boolean paramBoolean, String paramString)
  {
    Message localMessage = this.a.obtainMessage(this.b);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean(z[0], paramBoolean);
    localBundle.putString(z[1], paramString);
    localBundle.putString(z[2], this.c.c);
    localMessage.setData(localBundle);
    localMessage.sendToTarget();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.o
 * JD-Core Version:    0.6.2
 */