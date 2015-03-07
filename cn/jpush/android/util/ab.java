package cn.jpush.android.util;

public final class ab extends f
{
  private static final String z;

  static
  {
    Object localObject1 = "\036!{{\"+\"o~/+2{{>\033<Qj?\035=jm8".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    int m;
    Object localObject3;
    label27: int n;
    int i1;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      m = i;
      localObject3 = localObject1;
      n = localObject3[j];
      switch (k % 5)
      {
      default:
        i1 = 74;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject3[j] = ((char)(i1 ^ n));
      j = k + 1;
      if (m == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = m;
        break label27;
      }
      i = m;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i1 = 116;
      continue;
      i1 = 81;
      continue;
      i1 = 14;
      continue;
      i1 = 8;
    }
  }

  public static String a(String paramString)
  {
    return b(z + paramString, "");
  }

  public static void c(String paramString1, String paramString2)
  {
    a(z + paramString1, paramString2);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.ab
 * JD-Core Version:    0.6.2
 */