package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.api.q;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.k;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;

final class t extends Thread
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "";
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
          i3 = 42;
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
        str1 = "K=6$F";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "\003<.,\020Jz";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 101;
        break label96;
        i3 = 85;
        break label96;
        i3 = 66;
        break label96;
        i3 = 73;
        break label96;
        m = 0;
      }
    }
  }

  t(s params1, Context paramContext, s params2)
  {
  }

  public final void run()
  {
    if (this.c.W == 1)
    {
      ServiceInterface.a(this.c.c, 995, this.a);
      cn.jpush.android.api.m.a(this.a, this.c);
    }
    String str1;
    String str2;
    do
    {
      str1 = this.b.c;
      str2 = this.b.a;
      if (this.c.X)
        break;
      ServiceInterface.a(str1, 995, this.a);
      cn.jpush.android.api.m.a(this.a, this.b);
      do
      {
        return;
        if (this.c.W == 2)
        {
          x.c();
          q.a(this.a, this.b);
          break;
        }
      }
      while ((this.c.S.equals("0")) || (this.c.S.length() > 1));
    }
    while (this.c.W == 0);
    new StringBuilder(z[0]).append(this.c.W).toString();
    x.c();
    return;
    if (!p.a(str2))
    {
      ServiceInterface.a(str1, 996, this.a);
      return;
    }
    String str3 = null;
    int i = 0;
    label210: String str4;
    if (i < 4)
    {
      str3 = n.a(str2, 5, 5000L);
      if (!n.a(str3))
        str4 = str3;
    }
    for (int j = 1; ; j = 0)
    {
      if (j == 0)
      {
        x.c();
        ServiceInterface.a(str1, 1014, this.a);
        ServiceInterface.a(str1, 1021, a.b(this.a, str2), this.a);
        return;
        i++;
        break label210;
      }
      String str5 = str2.substring(0, 1 + str2.lastIndexOf("/"));
      boolean bool = d.a(this.b.Y, this.a, str5, str1, this.b.f());
      if ((this.c.q) && (!bool))
      {
        x.c();
        ServiceInterface.a(str1, 1014, this.a);
        return;
      }
      if (this.b.f());
      for (String str6 = k.b(this.a, str1) + str1 + z[1]; ; str6 = k.a(this.a, str1) + str1)
      {
        if (!cn.jpush.android.util.m.a(str6, str4, this.a))
          break label506;
        this.b.ab = (z[2] + str6);
        ServiceInterface.a(str1, 995, this.a);
        if (this.c.W != 0)
          break;
        cn.jpush.android.api.m.a(this.a, this.b);
        return;
      }
      label506: ServiceInterface.a(str1, 1014, this.a);
      return;
      str4 = str3;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.t
 * JD-Core Version:    0.6.2
 */