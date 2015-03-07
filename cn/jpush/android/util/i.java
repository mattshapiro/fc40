package cn.jpush.android.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class i
{
  public static String a;
  private static final String z;

  static
  {
    String str1 = "\030%\007 +,\021S=b>\0246ck\ff\r*";
    int i = -1;
    Object localObject1 = str1.toCharArray();
    int j = localObject1.length;
    int k;
    label21: int i2;
    if (j <= 1)
    {
      k = 0;
      Object localObject2 = localObject1;
      int m = k;
      int n = j;
      Object localObject3 = localObject1;
      while (true)
      {
        int i1 = localObject3[k];
        switch (m % 5)
        {
        default:
          i2 = 6;
          label80: localObject3[k] = ((char)(i2 ^ i1));
          k = m + 1;
          if (n != 0)
            break label117;
          localObject3 = localObject2;
          m = k;
          k = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label117: j = n;
      localObject1 = localObject2;
    }
    while (true)
    {
      if (j > k)
        break label21;
      String str2 = new String((char[])localObject1).intern();
      switch (i)
      {
      default:
        z = str2;
        str1 = "\030%\007 K,8\032\006N)1\023";
        i = 0;
        break;
        i2 = 97;
        break label80;
        i2 = 92;
        break label80;
        i2 = 126;
        break label80;
        i2 = 89;
        break;
      case 0:
        a = str2;
        return;
        k = 0;
      }
    }
  }

  public static String a()
  {
    return new SimpleDateFormat(z).format(new Date());
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.i
 * JD-Core Version:    0.6.2
 */