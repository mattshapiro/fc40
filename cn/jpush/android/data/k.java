package cn.jpush.android.data;

public final class k
{
  private static final String[] z;
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private String e = "";
  private long f = 0L;
  private long g = 0L;

  static
  {
    Object localObject1 = new String[7];
    int i = 0;
    String str1 = "1f\003S0~\003xn";
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
        i3 = 12;
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
        str1 = "1f\003S6i~\037mn";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "\037~i\f`\035~~\004j:rk\031e<N/H2ekMW?U\004hn";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "1f\003S2un2x:|oP";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "1f\003S'hz\b1";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "1f\003S'cc\nk6cU\031e>t7";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "1f\003S!tg\002z6,";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 83;
        continue;
        i3 = 17;
        continue;
        i3 = 10;
        continue;
        i3 = 109;
      }
    }
  }

  public final int a()
  {
    return this.a;
  }

  public final void a(int paramInt)
  {
    this.a = paramInt;
  }

  public final void a(long paramLong)
  {
    this.g = paramLong;
  }

  public final void a(String paramString)
  {
    this.e = paramString;
  }

  public final int b()
  {
    return this.b;
  }

  public final void b(int paramInt)
  {
    this.b = paramInt;
  }

  public final void b(long paramLong)
  {
    this.f = paramLong;
  }

  public final int c()
  {
    return this.c;
  }

  public final void c(int paramInt)
  {
    this.c = paramInt;
  }

  public final String d()
  {
    return this.e;
  }

  public final void d(int paramInt)
  {
    this.d = paramInt;
  }

  public final long e()
  {
    return this.g;
  }

  public final long f()
  {
    return this.f;
  }

  public final String toString()
  {
    return z[2] + this.a + z[0] + this.b + z[6] + this.c + z[4] + this.d + z[1] + this.e + z[5] + this.f + z[3] + this.g + "]";
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.k
 * JD-Core Version:    0.6.2
 */