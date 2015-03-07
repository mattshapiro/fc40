package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.k;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;

final class m extends Thread
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "'M[\rsn\013";
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
          i3 = 73;
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
        str1 = "oLC\005%";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 65;
        break label96;
        i3 = 36;
        break label96;
        i3 = 55;
        break label96;
        i3 = 104;
        break label96;
        m = 0;
      }
    }
  }

  m(l paraml1, l paraml2, Context paramContext, int paramInt)
  {
  }

  public final void run()
  {
    String str1 = this.a.ad.j;
    String str2 = this.a.c;
    if (!p.a(str1))
    {
      ServiceInterface.a(this.a.c, 996, this.b);
      return;
    }
    if (!this.a.ad.i)
    {
      ServiceInterface.a(str2, this.c, this.b);
      l.a(this.d, this.a, this.b);
      return;
    }
    String str3 = null;
    int i = 0;
    String str4;
    if (i < 4)
    {
      str3 = n.a(str1, 5, 5000L);
      if (!n.a(str3))
        str4 = str3;
    }
    for (int j = 1; ; j = 0)
    {
      if (j == 0)
      {
        ServiceInterface.a(str2, 1014, this.b);
        ServiceInterface.a(str2, 1021, a.b(this.b, str1), this.b);
        x.c();
        return;
        i++;
        break;
      }
      String str5 = str1.substring(0, 1 + str1.lastIndexOf("/"));
      if (!d.a(this.a.ad.k, this.b, str5, str2, this.a.f()))
      {
        x.c();
        ServiceInterface.a(str2, 1014, this.b);
        return;
      }
      if (this.a.f());
      for (String str6 = k.b(this.b, str2) + str2 + z[1]; cn.jpush.android.util.m.a(str6, str4, this.b); str6 = k.a(this.b, str2) + str2)
      {
        this.a.ad.n = (z[0] + str6);
        ServiceInterface.a(str2, this.c, this.b);
        l.a(this.d, this.a, this.b);
        return;
      }
      ServiceInterface.a(str2, 1014, this.b);
      return;
      str4 = str3;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.m
 * JD-Core Version:    0.6.2
 */