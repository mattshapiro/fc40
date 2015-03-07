package com.umeng.message.proguard;

import android.text.TextUtils;

public class bw
{
  public static int a(long paramLong)
  {
    return a(paramLong, null);
  }

  public static int a(long paramLong, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      byte[] arrayOfByte = paramString.getBytes();
      return (int)(Math.abs(a(arrayOfByte, 0, arrayOfByte.length, 2147483647)) % paramLong);
    }
    return (int)(Math.random() * paramLong);
  }

  public static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt3 ^ paramInt2;
    int j = paramInt2 >> 2;
    int k = i;
    int m = 0;
    while (m < j)
    {
      int i2 = m << 2;
      int i3 = 1540483477 * (((paramArrayOfByte[(3 + (paramInt1 + i2))] << 8 | 0xFF & paramArrayOfByte[(2 + (paramInt1 + i2))]) << 8 | 0xFF & paramArrayOfByte[(1 + (paramInt1 + i2))]) << 8 | 0xFF & paramArrayOfByte[(0 + (i2 + paramInt1))]);
      int i4 = 1540483477 * (i3 ^ i3 >>> 24) ^ k * 1540483477;
      m++;
      k = i4;
    }
    int n = paramInt2 - (j << 2);
    if (n != 0)
    {
      if (n >= 3)
        k ^= paramArrayOfByte[(-3 + (paramInt1 + paramInt2))] << 16;
      if (n >= 2)
        k ^= paramArrayOfByte[(-2 + (paramInt1 + paramInt2))] << 8;
      if (n >= 1)
        k ^= paramArrayOfByte[(-1 + (paramInt1 + paramInt2))];
      k *= 1540483477;
    }
    int i1 = 1540483477 * (k ^ k >>> 13);
    return i1 ^ i1 >>> 15;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bw
 * JD-Core Version:    0.6.2
 */