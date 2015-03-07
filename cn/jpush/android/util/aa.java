package cn.jpush.android.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Inflater;

public final class aa
{
  private static final String z;

  static
  {
    Object localObject1 = ",nC<\b".toCharArray();
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
        i1 = 48;
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
      i1 = 121;
      continue;
      i1 = 58;
      continue;
      i1 = 5;
      continue;
      i1 = 17;
    }
  }

  private static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return "";
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte = new byte[1024];
      while (!localInflater.finished())
        localByteArrayOutputStream.write(arrayOfByte, 0, localInflater.inflate(arrayOfByte));
    }
    catch (Exception localException)
    {
      x.j();
      localInflater.end();
      try
      {
        localByteArrayOutputStream.close();
        return "";
      }
      catch (IOException localIOException2)
      {
        x.j();
        return "";
      }
      String str = new String(localByteArrayOutputStream.toByteArray(), z);
      localInflater.end();
      try
      {
        localByteArrayOutputStream.close();
        return str;
      }
      catch (IOException localIOException3)
      {
        x.j();
        return "";
      }
    }
    finally
    {
      localInflater.end();
      try
      {
        localByteArrayOutputStream.close();
        throw localObject;
      }
      catch (IOException localIOException1)
      {
        x.j();
      }
    }
    return "";
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = b(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, arrayOfByte.length);
    return a(arrayOfByte);
  }

  private static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    for (int i = 0; i < 4; i++)
      arrayOfByte[i] = ((byte)(0xFF & paramInt >>> 8 * (-1 + arrayOfByte.length - i)));
    return arrayOfByte;
  }

  public static byte[] a(int paramInt1, int paramInt2)
  {
    int i = 0;
    byte[] arrayOfByte1 = a(paramInt1);
    int j = 2;
    byte[] arrayOfByte2 = new byte[j];
    int k = arrayOfByte1.length - j;
    int m;
    if (j > arrayOfByte1.length)
    {
      m = j - arrayOfByte1.length;
      j = arrayOfByte1.length;
    }
    while (true)
    {
      System.arraycopy(arrayOfByte1, i, arrayOfByte2, m, j);
      return arrayOfByte2;
      i = k;
      m = 0;
    }
  }

  public static byte[] a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes();
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = b(paramInt2);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, arrayOfByte.length);
    return (int)b(arrayOfByte);
  }

  private static final long b(byte[] paramArrayOfByte)
  {
    long l = 0L;
    for (int i = 0; i < -1 + paramArrayOfByte.length; i++)
      l += ((0xFF & paramArrayOfByte[i]) << 8 * (-1 + paramArrayOfByte.length - i));
    return l + (0xFF & paramArrayOfByte[(-1 + paramArrayOfByte.length)]);
  }

  private static byte[] b(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = 0;
    return arrayOfByte;
  }

  public static long c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = b(8);
    System.arraycopy(paramArrayOfByte, 21, arrayOfByte, 0, arrayOfByte.length);
    return b(arrayOfByte);
  }

  public static String d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      byte[] arrayOfByte = b(paramInt2);
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, arrayOfByte.length);
      String str = new String(arrayOfByte, z);
      return str;
    }
    catch (Exception localException)
    {
      x.j();
    }
    return "";
  }

  public static byte[] e(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      System.arraycopy(a(paramInt1), 0, paramArrayOfByte, paramInt2, 4);
      return paramArrayOfByte;
    }
    catch (Exception localException)
    {
      x.j();
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.aa
 * JD-Core Version:    0.6.2
 */