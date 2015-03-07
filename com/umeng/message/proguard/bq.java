package com.umeng.message.proguard;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public class bq
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 0;
  public static final int d = 2;
  public static final int e = 8;
  public static final int f = 16;
  public static final int g = 32;
  private static final int h = 76;
  private static final byte i = 61;
  private static final byte j = 10;
  private static final String k = "UTF-8";
  private static final byte l = -5;
  private static final byte m = -1;
  private static final byte[] n = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] o = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
  private static final byte[] p = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private static final byte[] q = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9 };
  private static final byte[] r = { 45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final byte[] s = { -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 0, -9, -9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -9, -9, -9, -1, -9, -9, -9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, -9, -9, -9, -9, 37, -9, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, -9, -9, -9, -9 };

  private static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = b(paramInt3);
    if (paramArrayOfByte1[(paramInt1 + 2)] == 61)
    {
      paramArrayOfByte2[paramInt2] = ((byte)(((0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12) >>> 16));
      return 1;
    }
    if (paramArrayOfByte1[(paramInt1 + 3)] == 61)
    {
      int i2 = (0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]]) << 6;
      paramArrayOfByte2[paramInt2] = ((byte)(i2 >>> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(i2 >>> 8));
      return 2;
    }
    try
    {
      int i1 = (0xFF & arrayOfByte[paramArrayOfByte1[paramInt1]]) << 18 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 1)]]) << 12 | (0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 2)]]) << 6 | 0xFF & arrayOfByte[paramArrayOfByte1[(paramInt1 + 3)]];
      paramArrayOfByte2[paramInt2] = ((byte)(i1 >> 16));
      paramArrayOfByte2[(paramInt2 + 1)] = ((byte)(i1 >> 8));
      paramArrayOfByte2[(paramInt2 + 2)] = ((byte)i1);
      return 3;
    }
    catch (Throwable localThrowable)
    {
    }
    return -1;
  }

  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, 0);
  }

  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, 0);
  }

  public static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1;
    int i2;
    int i3;
    label26: int i4;
    if ((paramInt3 & 0x8) == 0)
    {
      i1 = 1;
      i2 = paramInt2 * 4 / 3;
      if (paramInt2 % 3 <= 0)
        break label149;
      i3 = 4;
      i4 = i2 + i3;
      if (i1 == 0)
        break label155;
    }
    byte[] arrayOfByte;
    int i8;
    int i9;
    label149: label155: for (int i5 = i2 / 76; ; i5 = 0)
    {
      arrayOfByte = new byte[i5 + i4];
      int i6 = paramInt2 - 2;
      int i7 = 0;
      i8 = 0;
      int i11;
      for (i9 = 0; i9 < i6; i9 = i11)
      {
        a(paramArrayOfByte, i9 + paramInt1, 3, arrayOfByte, i8, paramInt3);
        int i10 = i7 + 4;
        if ((i1 != 0) && (i10 == 76))
        {
          arrayOfByte[(i8 + 4)] = 10;
          i8++;
          i10 = 0;
        }
        i11 = i9 + 3;
        i8 += 4;
        i7 = i10;
      }
      i1 = 0;
      break;
      i3 = 0;
      break label26;
    }
    if (i9 < paramInt2)
    {
      a(paramArrayOfByte, i9 + paramInt1, paramInt2 - i9, arrayOfByte, i8, paramInt3);
      i8 += 4;
    }
    try
    {
      String str = new String(arrayOfByte, 0, i8, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return new String(arrayOfByte, 0, i8);
  }

  private static final byte[] a(int paramInt)
  {
    if ((paramInt & 0x10) == 16)
      return p;
    if ((paramInt & 0x20) == 32)
      return r;
    return n;
  }

  public static byte[] a(String paramString)
  {
    return a(paramString, 0);
  }

  public static byte[] a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    try
    {
      byte[] arrayOfByte2 = paramString.getBytes("UTF-8");
      arrayOfByte1 = arrayOfByte2;
      return b(arrayOfByte1, 0, arrayOfByte1.length, paramInt);
    }
    catch (Throwable localThrowable)
    {
      while (true)
        byte[] arrayOfByte1 = paramString.getBytes();
    }
  }

  private static byte[] a(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3, int paramInt4)
  {
    byte[] arrayOfByte = a(paramInt4);
    int i1;
    if (paramInt2 > 0)
    {
      i1 = paramArrayOfByte1[paramInt1] << 24 >>> 8;
      label22: if (paramInt2 <= 1)
        break label112;
    }
    int i5;
    label112: for (int i2 = paramArrayOfByte1[(paramInt1 + 1)] << 24 >>> 16; ; i2 = 0)
    {
      int i3 = i2 | i1;
      int i4 = 0;
      if (paramInt2 > 2)
        i4 = paramArrayOfByte1[(paramInt1 + 2)] << 24 >>> 24;
      i5 = i4 | i3;
      switch (paramInt2)
      {
      default:
        return paramArrayOfByte2;
        i1 = 0;
        break label22;
      case 3:
      case 2:
      case 1:
      }
    }
    paramArrayOfByte2[paramInt3] = arrayOfByte[(i5 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & i5 >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & i5 >>> 6)];
    paramArrayOfByte2[(paramInt3 + 3)] = arrayOfByte[(i5 & 0x3F)];
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(i5 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & i5 >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = arrayOfByte[(0x3F & i5 >>> 6)];
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
    paramArrayOfByte2[paramInt3] = arrayOfByte[(i5 >>> 18)];
    paramArrayOfByte2[(paramInt3 + 1)] = arrayOfByte[(0x3F & i5 >>> 12)];
    paramArrayOfByte2[(paramInt3 + 2)] = 61;
    paramArrayOfByte2[(paramInt3 + 3)] = 61;
    return paramArrayOfByte2;
  }

  private static final byte[] b(int paramInt)
  {
    if ((paramInt & 0x10) == 16)
      return q;
    if ((paramInt & 0x20) == 32)
      return s;
    return o;
  }

  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte1 = b(paramInt3);
    byte[] arrayOfByte2 = new byte[paramInt2 * 3 / 4];
    byte[] arrayOfByte3 = new byte[4];
    int i1 = paramInt1;
    int i2 = 0;
    int i3 = 0;
    int i7;
    int i4;
    if (i1 < paramInt1 + paramInt2)
    {
      int i5 = (byte)(0x7F & paramArrayOfByte[i1]);
      int i6 = arrayOfByte1[i5];
      if (i6 >= -5)
      {
        if (i6 < -1)
          break label159;
        i7 = i2 + 1;
        arrayOfByte3[i2] = i5;
        if (i7 <= 3)
          break label152;
        i4 = i3 + a(arrayOfByte3, 0, arrayOfByte2, i3, paramInt3);
        if (i5 != 61)
          break label131;
      }
    }
    while (true)
    {
      byte[] arrayOfByte4 = new byte[i4];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte4, 0, i4);
      return arrayOfByte4;
      return null;
      label131: int i8 = i4;
      i7 = 0;
      while (true)
      {
        i1++;
        i3 = i8;
        i2 = i7;
        break;
        label152: i8 = i3;
        continue;
        label159: i7 = i2;
        i8 = i3;
      }
      i4 = i3;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bq
 * JD-Core Version:    0.6.2
 */