package cn.jpush.android.util;

import cn.jpush.android.service.PushService;

public final class aj
{
  private static final String[] z;
  private String a;
  private String b;
  private boolean c = false;
  private long d;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "tl|FU0,4Fv852\016d+a7\tsyf";
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
          i3 = 1;
          label95: localObject3[m] = ((char)(i3 ^ i2));
          m = n + 1;
          if (i1 != 0)
            break label132;
          localObject3 = localObject2;
          n = m;
          m = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label132: k = i1;
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
        str1 = "~{q";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "42";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 89;
        break label95;
        i3 = 65;
        break label95;
        i3 = 81;
        break label95;
        i3 = 102;
        break label95;
        m = 0;
      }
    }
  }

  public aj(String paramString1, String paramString2)
  {
    if (PushService.b)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.d = System.currentTimeMillis();
    }
  }

  public final void a()
  {
    if (PushService.b)
    {
      new StringBuilder(z[0]).append(this.b).append(z[1]).append(System.currentTimeMillis() - this.d).append(z[2]).toString();
      x.c();
      if (!this.c)
        this.d = System.currentTimeMillis();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.aj
 * JD-Core Version:    0.6.2
 */