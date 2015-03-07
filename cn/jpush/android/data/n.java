package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.ai;

final class n extends Thread
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "QS\020\\yNY";
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
          i3 = 38;
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
        str1 = "QS\020\\yN]";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 39;
        break label96;
        i3 = 58;
        break label96;
        i3 = 117;
        break label96;
        i3 = 43;
        break label96;
        m = 0;
      }
    }
  }

  n(l paraml1, Context paramContext, int paramInt, l paraml2)
  {
  }

  public final void run()
  {
    if (p.a(this.d.ad.b))
      this.d.ad.l = d.a(this.d.ad.b, this.d.c, z[0], this.a);
    if (p.a(this.d.ad.h))
      this.d.ad.m = d.a(this.d.ad.h, this.d.c, z[1], this.a);
    if ((ai.a(this.d.ad.l)) || (ai.a(this.d.ad.m)))
    {
      ServiceInterface.a(this.d.c, 1014, this.a);
      return;
    }
    ServiceInterface.a(this.d.c, this.b, this.a);
    l.a(this.d, this.c, this.a);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.n
 * JD-Core Version:    0.6.2
 */