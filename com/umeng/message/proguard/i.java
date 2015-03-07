package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class i
{
  public static final int a = 4096;
  public static final int b = 4;
  public static final int c = 8;
  private final byte[] d;
  private final int e;
  private int f;
  private final OutputStream g;

  private i(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    this.g = paramOutputStream;
    this.d = paramArrayOfByte;
    this.f = 0;
    this.e = paramArrayOfByte.length;
  }

  private i(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.g = null;
    this.d = paramArrayOfByte;
    this.f = paramInt1;
    this.e = (paramInt1 + paramInt2);
  }

  static int a(int paramInt)
  {
    if (paramInt > 4096)
      paramInt = 4096;
    return paramInt;
  }

  public static int a(int paramInt, t paramt)
  {
    return o(paramInt) + a(paramt);
  }

  public static int a(t paramt)
  {
    int i = paramt.b();
    return i + q(i);
  }

  public static i a(OutputStream paramOutputStream)
  {
    return a(paramOutputStream, 4096);
  }

  public static i a(OutputStream paramOutputStream, int paramInt)
  {
    return new i(paramOutputStream, new byte[paramInt]);
  }

  public static i a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static i a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new i(paramArrayOfByte, paramInt1, paramInt2);
  }

  public static int b(double paramDouble)
  {
    return 8;
  }

  public static int b(float paramFloat)
  {
    return 4;
  }

  public static int b(int paramInt, double paramDouble)
  {
    return o(paramInt) + b(paramDouble);
  }

  public static int b(int paramInt, float paramFloat)
  {
    return o(paramInt) + b(paramFloat);
  }

  public static int b(int paramInt, t paramt)
  {
    return 2 * o(1) + i(2, paramInt) + a(3, paramt);
  }

  public static int b(int paramInt, String paramString)
  {
    return o(paramInt) + b(paramString);
  }

  public static int b(int paramInt, boolean paramBoolean)
  {
    return o(paramInt) + b(paramBoolean);
  }

  public static int b(g paramg)
  {
    return q(paramg.a()) + paramg.a();
  }

  public static int b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      int i = q(arrayOfByte.length);
      int j = arrayOfByte.length;
      return j + i;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported.", localUnsupportedEncodingException);
    }
  }

  public static int b(boolean paramBoolean)
  {
    return 1;
  }

  public static int c(int paramInt, g paramg)
  {
    return o(paramInt) + b(paramg);
  }

  public static int d(int paramInt, g paramg)
  {
    return 2 * o(1) + i(2, paramInt) + c(3, paramg);
  }

  public static int d(y paramy)
  {
    return paramy.d();
  }

  private void d()
    throws IOException
  {
    if (this.g == null)
      throw new a();
    this.g.write(this.d, 0, this.f);
    this.f = 0;
  }

  public static int e(int paramInt, y paramy)
  {
    return 2 * o(paramInt) + d(paramy);
  }

  public static int e(y paramy)
  {
    return d(paramy);
  }

  public static int f(int paramInt, long paramLong)
  {
    return o(paramInt) + f(paramLong);
  }

  public static int f(int paramInt, y paramy)
  {
    return e(paramInt, paramy);
  }

  public static int f(long paramLong)
  {
    return l(paramLong);
  }

  public static int f(y paramy)
  {
    int i = paramy.d();
    return i + q(i);
  }

  public static int g(int paramInt1, int paramInt2)
  {
    return o(paramInt1) + h(paramInt2);
  }

  public static int g(int paramInt, long paramLong)
  {
    return o(paramInt) + g(paramLong);
  }

  public static int g(int paramInt, y paramy)
  {
    return o(paramInt) + f(paramy);
  }

  public static int g(long paramLong)
  {
    return l(paramLong);
  }

  public static int h(int paramInt)
  {
    if (paramInt >= 0)
      return q(paramInt);
    return 10;
  }

  public static int h(int paramInt1, int paramInt2)
  {
    return o(paramInt1) + i(paramInt2);
  }

  public static int h(int paramInt, long paramLong)
  {
    return o(paramInt) + h(paramLong);
  }

  public static int h(int paramInt, y paramy)
  {
    return 2 * o(1) + i(2, paramInt) + g(3, paramy);
  }

  public static int h(long paramLong)
  {
    return 8;
  }

  public static int i(int paramInt)
  {
    return 4;
  }

  public static int i(int paramInt1, int paramInt2)
  {
    return o(paramInt1) + j(paramInt2);
  }

  public static int i(int paramInt, long paramLong)
  {
    return o(paramInt) + i(paramLong);
  }

  public static int i(long paramLong)
  {
    return 8;
  }

  public static int j(int paramInt)
  {
    return q(paramInt);
  }

  public static int j(int paramInt1, int paramInt2)
  {
    return o(paramInt1) + k(paramInt2);
  }

  public static int j(int paramInt, long paramLong)
  {
    return o(paramInt) + j(paramLong);
  }

  public static int j(long paramLong)
  {
    return l(n(paramLong));
  }

  public static int k(int paramInt)
  {
    return h(paramInt);
  }

  public static int k(int paramInt1, int paramInt2)
  {
    return o(paramInt1) + l(paramInt2);
  }

  public static int l(int paramInt)
  {
    return 4;
  }

  public static int l(int paramInt1, int paramInt2)
  {
    return o(paramInt1) + m(paramInt2);
  }

  public static int l(long paramLong)
  {
    if ((0xFFFFFF80 & paramLong) == 0L)
      return 1;
    if ((0xFFFFC000 & paramLong) == 0L)
      return 2;
    if ((0xFFE00000 & paramLong) == 0L)
      return 3;
    if ((0xF0000000 & paramLong) == 0L)
      return 4;
    if ((0x0 & paramLong) == 0L)
      return 5;
    if ((0x0 & paramLong) == 0L)
      return 6;
    if ((0x0 & paramLong) == 0L)
      return 7;
    if ((0x0 & paramLong) == 0L)
      return 8;
    if ((0x0 & paramLong) == 0L)
      return 9;
    return 10;
  }

  public static int m(int paramInt)
  {
    return q(s(paramInt));
  }

  public static long n(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }

  public static int o(int paramInt)
  {
    return q(S.a(paramInt, 0));
  }

  public static int q(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0)
      return 1;
    if ((paramInt & 0xFFFFC000) == 0)
      return 2;
    if ((0xFFE00000 & paramInt) == 0)
      return 3;
    if ((0xF0000000 & paramInt) == 0)
      return 4;
    return 5;
  }

  public static int s(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }

  public void a()
    throws IOException
  {
    if (this.g != null)
      d();
  }

  public void a(byte paramByte)
    throws IOException
  {
    if (this.f == this.e)
      d();
    byte[] arrayOfByte = this.d;
    int i = this.f;
    this.f = (i + 1);
    arrayOfByte[i] = paramByte;
  }

  public void a(double paramDouble)
    throws IOException
  {
    m(Double.doubleToRawLongBits(paramDouble));
  }

  public void a(float paramFloat)
    throws IOException
  {
    r(Float.floatToRawIntBits(paramFloat));
  }

  public void a(int paramInt, double paramDouble)
    throws IOException
  {
    m(paramInt, 1);
    a(paramDouble);
  }

  public void a(int paramInt, float paramFloat)
    throws IOException
  {
    m(paramInt, 5);
    a(paramFloat);
  }

  public void a(int paramInt1, int paramInt2)
    throws IOException
  {
    m(paramInt1, 0);
    b(paramInt2);
  }

  public void a(int paramInt, long paramLong)
    throws IOException
  {
    m(paramInt, 0);
    a(paramLong);
  }

  public void a(int paramInt, g paramg)
    throws IOException
  {
    m(paramInt, 2);
    a(paramg);
  }

  public void a(int paramInt, y paramy)
    throws IOException
  {
    m(paramInt, 3);
    a(paramy);
    m(paramInt, 4);
  }

  public void a(int paramInt, String paramString)
    throws IOException
  {
    m(paramInt, 2);
    a(paramString);
  }

  public void a(int paramInt, boolean paramBoolean)
    throws IOException
  {
    m(paramInt, 0);
    a(paramBoolean);
  }

  public void a(long paramLong)
    throws IOException
  {
    k(paramLong);
  }

  public void a(g paramg)
    throws IOException
  {
    p(paramg.a());
    c(paramg);
  }

  public void a(g paramg, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.e - this.f >= paramInt2)
    {
      paramg.b(this.d, paramInt1, this.f, paramInt2);
      this.f = (paramInt2 + this.f);
      return;
    }
    int i = this.e - this.f;
    paramg.b(this.d, paramInt1, this.f, i);
    int j = paramInt1 + i;
    int k = paramInt2 - i;
    this.f = this.e;
    d();
    if (k <= this.e)
    {
      paramg.b(this.d, j, 0, k);
      this.f = k;
      return;
    }
    InputStream localInputStream = paramg.j();
    if (j != localInputStream.skip(j))
      throw new IllegalStateException("Skip failed? Should never happen.");
    int n;
    int m;
    do
    {
      this.g.write(this.d, 0, n);
      k -= n;
      if (k <= 0)
        break;
      m = Math.min(k, this.e);
      n = localInputStream.read(this.d, 0, m);
    }
    while (n == m);
    throw new IllegalStateException("Read failed? Should never happen");
  }

  public void a(y paramy)
    throws IOException
  {
    paramy.a(this);
  }

  public void a(String paramString)
    throws IOException
  {
    byte[] arrayOfByte = paramString.getBytes("UTF-8");
    p(arrayOfByte.length);
    b(arrayOfByte);
  }

  public void a(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      n(i);
      return;
    }
  }

  public int b()
  {
    if (this.g == null)
      return this.e - this.f;
    throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
  }

  public void b(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      p(paramInt);
      return;
    }
    k(paramInt);
  }

  public void b(int paramInt1, int paramInt2)
    throws IOException
  {
    m(paramInt1, 5);
    c(paramInt2);
  }

  public void b(int paramInt, long paramLong)
    throws IOException
  {
    m(paramInt, 0);
    b(paramLong);
  }

  public void b(int paramInt, g paramg)
    throws IOException
  {
    m(1, 3);
    c(2, paramInt);
    a(3, paramg);
    m(1, 4);
  }

  public void b(int paramInt, y paramy)
    throws IOException
  {
    a(paramInt, paramy);
  }

  public void b(long paramLong)
    throws IOException
  {
    k(paramLong);
  }

  public void b(y paramy)
    throws IOException
  {
    a(paramy);
  }

  public void b(byte[] paramArrayOfByte)
    throws IOException
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.e - this.f >= paramInt2)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.d, this.f, paramInt2);
      this.f = (paramInt2 + this.f);
      return;
    }
    int i = this.e - this.f;
    System.arraycopy(paramArrayOfByte, paramInt1, this.d, this.f, i);
    int j = paramInt1 + i;
    int k = paramInt2 - i;
    this.f = this.e;
    d();
    if (k <= this.e)
    {
      System.arraycopy(paramArrayOfByte, j, this.d, 0, k);
      this.f = k;
      return;
    }
    this.g.write(paramArrayOfByte, j, k);
  }

  public void c()
  {
    if (b() != 0)
      throw new IllegalStateException("Did not write as much data as expected.");
  }

  public void c(int paramInt)
    throws IOException
  {
    r(paramInt);
  }

  public void c(int paramInt1, int paramInt2)
    throws IOException
  {
    m(paramInt1, 0);
    d(paramInt2);
  }

  public void c(int paramInt, long paramLong)
    throws IOException
  {
    m(paramInt, 1);
    c(paramLong);
  }

  public void c(int paramInt, y paramy)
    throws IOException
  {
    m(paramInt, 2);
    c(paramy);
  }

  public void c(long paramLong)
    throws IOException
  {
    m(paramLong);
  }

  public void c(g paramg)
    throws IOException
  {
    a(paramg, 0, paramg.a());
  }

  public void c(y paramy)
    throws IOException
  {
    p(paramy.d());
    paramy.a(this);
  }

  public void d(int paramInt)
    throws IOException
  {
    p(paramInt);
  }

  public void d(int paramInt1, int paramInt2)
    throws IOException
  {
    m(paramInt1, 0);
    e(paramInt2);
  }

  public void d(int paramInt, long paramLong)
    throws IOException
  {
    m(paramInt, 1);
    d(paramLong);
  }

  public void d(int paramInt, y paramy)
    throws IOException
  {
    m(1, 3);
    c(2, paramInt);
    c(3, paramy);
    m(1, 4);
  }

  public void d(long paramLong)
    throws IOException
  {
    m(paramLong);
  }

  public void e(int paramInt)
    throws IOException
  {
    b(paramInt);
  }

  public void e(int paramInt1, int paramInt2)
    throws IOException
  {
    m(paramInt1, 5);
    f(paramInt2);
  }

  public void e(int paramInt, long paramLong)
    throws IOException
  {
    m(paramInt, 0);
    e(paramLong);
  }

  public void e(long paramLong)
    throws IOException
  {
    k(n(paramLong));
  }

  public void f(int paramInt)
    throws IOException
  {
    r(paramInt);
  }

  public void f(int paramInt1, int paramInt2)
    throws IOException
  {
    m(paramInt1, 0);
    g(paramInt2);
  }

  public void g(int paramInt)
    throws IOException
  {
    p(s(paramInt));
  }

  public void k(long paramLong)
    throws IOException
  {
    while (true)
    {
      if ((0xFFFFFF80 & paramLong) == 0L)
      {
        n((int)paramLong);
        return;
      }
      n(0x80 | 0x7F & (int)paramLong);
      paramLong >>>= 7;
    }
  }

  public void m(int paramInt1, int paramInt2)
    throws IOException
  {
    p(S.a(paramInt1, paramInt2));
  }

  public void m(long paramLong)
    throws IOException
  {
    n(0xFF & (int)paramLong);
    n(0xFF & (int)(paramLong >> 8));
    n(0xFF & (int)(paramLong >> 16));
    n(0xFF & (int)(paramLong >> 24));
    n(0xFF & (int)(paramLong >> 32));
    n(0xFF & (int)(paramLong >> 40));
    n(0xFF & (int)(paramLong >> 48));
    n(0xFF & (int)(paramLong >> 56));
  }

  public void n(int paramInt)
    throws IOException
  {
    a((byte)paramInt);
  }

  public void p(int paramInt)
    throws IOException
  {
    while (true)
    {
      if ((paramInt & 0xFFFFFF80) == 0)
      {
        n(paramInt);
        return;
      }
      n(0x80 | paramInt & 0x7F);
      paramInt >>>= 7;
    }
  }

  public void r(int paramInt)
    throws IOException
  {
    n(paramInt & 0xFF);
    n(0xFF & paramInt >> 8);
    n(0xFF & paramInt >> 16);
    n(0xFF & paramInt >> 24);
  }

  public static class a extends IOException
  {
    private static final long a = -6947486886997889499L;

    a()
    {
      super();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.i
 * JD-Core Version:    0.6.2
 */