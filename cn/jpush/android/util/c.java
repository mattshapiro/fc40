package cn.jpush.android.util;

import java.io.UnsupportedEncodingException;

public class c
{
  private static final String z;

  static
  {
    Object localObject1 = "h\021eka~\013\001".toCharArray();
    int i = localObject1.length;
    int j;
    int i1;
    if (i <= 1)
    {
      j = 0;
      Object localObject2 = localObject1;
      int k = j;
      int m = i;
      Object localObject3 = localObject1;
      while (true)
      {
        int n = localObject3[j];
        switch (k % 5)
        {
        default:
          i1 = 50;
          label72: localObject3[j] = ((char)(i1 ^ n));
          j = k + 1;
          if (m != 0)
            break label105;
          localObject3 = localObject2;
          k = j;
          j = m;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label105: i = m;
      localObject1 = localObject2;
    }
    while (i <= j)
    {
      z = new String((char[])localObject1).intern();
      boolean bool1 = c.class.desiredAssertionStatus();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      a = bool2;
      return;
      i1 = 61;
      break label72;
      i1 = 66;
      break label72;
      i1 = 72;
      break label72;
      i1 = 42;
      break label72;
      j = 0;
    }
  }

  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 1;
    while (true)
    {
      int j;
      e locale;
      int k;
      int m;
      int n;
      try
      {
        j = paramArrayOfByte.length;
        locale = new e(10, null);
        k = 4 * (j / 3);
        if (locale.d)
        {
          if (j % 3 > 0)
            k += 4;
          if ((!locale.e) || (j <= 0))
            break label184;
          m = 1 + (j - 1) / 57;
          if (!locale.f)
            break label191;
          i = 2;
          break label191;
          locale.a = new byte[n];
          locale.a(paramArrayOfByte, 0, j, true);
          if ((a) || (locale.b == n))
            break label164;
          throw new AssertionError();
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new AssertionError(localUnsupportedEncodingException);
      }
      switch (j % 3)
      {
      case 0:
        String str = new String(locale.a, z);
        return str;
        n = k;
        continue;
        n = k + i * m;
        break;
      default:
        break;
      case 1:
        k += 2;
        break;
      case 2:
        label164: label184: label191: k += 3;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.c
 * JD-Core Version:    0.6.2
 */