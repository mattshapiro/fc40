package cn.jpush.android.util;

 enum b
{
  private static final String[] z;

  static
  {
    Object localObject1 = new String[5];
    int i = 0;
    String str1 = "\037DB9~\036HP/{\tNY/n\023@F5m\tDR#";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label35: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label51: int i2;
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
        i3 = 61;
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
        break label51;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "\037DB9~\036HP/{\tNY/x\003UQ\"s\032MG$r\t@S5";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "\037DB9~\036HP/{\tNY/n\002R";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "\037DB9~\036HP/{\tNY/s\036V";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "\037DB9~\036HP/{\tNY/n\036U@9s\034";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        z = localObject2;
        a = new b(z[3], 0);
        b = new b(z[4], 1);
        c = new b(z[1], 2);
        d = new b(z[0], 3);
        e = new b(z[2], 4);
        b[] arrayOfb = new b[5];
        arrayOfb[0] = a;
        arrayOfb[1] = b;
        arrayOfb[2] = c;
        arrayOfb[3] = d;
        arrayOfb[4] = e;
        f = arrayOfb;
        return;
        i3 = 91;
        continue;
        i3 = 1;
        continue;
        i3 = 20;
        continue;
        i3 = 112;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.b
 * JD-Core Version:    0.6.2
 */