package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class h
{
  private static final int l = 64;
  private static final int m = 67108864;
  private static final int n = 4096;
  private final byte[] a;
  private int b;
  private int c;
  private int d;
  private final InputStream e;
  private int f;
  private int g;
  private int h = 2147483647;
  private int i;
  private int j = 64;
  private int k = 67108864;

  private h(InputStream paramInputStream)
  {
    this.a = new byte[4096];
    this.b = 0;
    this.d = 0;
    this.g = 0;
    this.e = paramInputStream;
  }

  private h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = (paramInt1 + paramInt2);
    this.d = paramInt1;
    this.g = (-paramInt1);
    this.e = null;
  }

  private void B()
  {
    this.b += this.c;
    int i1 = this.g + this.b;
    if (i1 > this.h)
    {
      this.c = (i1 - this.h);
      this.b -= this.c;
      return;
    }
    this.c = 0;
  }

  public static int a(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if ((paramInt & 0x80) == 0)
      return paramInt;
    paramInt &= 127;
    for (int i1 = 7; ; i1 += 7)
    {
      if (i1 >= 32)
        break label68;
      int i3 = paramInputStream.read();
      if (i3 == -1)
        throw s.b();
      paramInt |= (i3 & 0x7F) << i1;
      if ((i3 & 0x80) == 0)
        break;
    }
    label68: int i2;
    do
    {
      i1 += 7;
      if (i1 >= 64)
        break;
      i2 = paramInputStream.read();
      if (i2 == -1)
        throw s.b();
    }
    while ((i2 & 0x80) != 0);
    return paramInt;
    throw s.d();
  }

  public static long a(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }

  public static h a(InputStream paramInputStream)
  {
    return new h(paramInputStream);
  }

  public static h a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static h a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    h localh = new h(paramArrayOfByte, paramInt1, paramInt2);
    try
    {
      localh.f(paramInt2);
      return localh;
    }
    catch (s locals)
    {
      throw new IllegalArgumentException(locals);
    }
  }

  private boolean a(boolean paramBoolean)
    throws IOException
  {
    if (this.d < this.b)
      throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    if (this.g + this.b == this.h)
    {
      if (paramBoolean)
        throw s.b();
      return false;
    }
    this.g += this.b;
    this.d = 0;
    if (this.e == null);
    for (int i1 = -1; ; i1 = this.e.read(this.a))
    {
      this.b = i1;
      if ((this.b != 0) && (this.b >= -1))
        break;
      throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.b + "\nThe InputStream implementation is buggy.");
    }
    if (this.b == -1)
    {
      this.b = 0;
      if (paramBoolean)
        throw s.b();
      return false;
    }
    B();
    int i2 = this.g + this.b + this.c;
    if ((i2 > this.k) || (i2 < 0))
      throw s.i();
    return true;
  }

  static int b(InputStream paramInputStream)
    throws IOException
  {
    int i1 = paramInputStream.read();
    if (i1 == -1)
      throw s.b();
    return a(i1, paramInputStream);
  }

  public static int c(int paramInt)
  {
    return paramInt >>> 1 ^ -(paramInt & 0x1);
  }

  public byte A()
    throws IOException
  {
    if (this.d == this.b)
      a(true);
    byte[] arrayOfByte = this.a;
    int i1 = this.d;
    this.d = (i1 + 1);
    return arrayOfByte[i1];
  }

  public int a()
    throws IOException
  {
    if (y())
    {
      this.f = 0;
      return 0;
    }
    this.f = s();
    if (S.b(this.f) == 0)
      throw s.e();
    return this.f;
  }

  public <T extends y> T a(int paramInt, B<T> paramB, n paramn)
    throws IOException
  {
    if (this.i >= this.j)
      throw s.h();
    this.i = (1 + this.i);
    y localy = (y)paramB.d(this, paramn);
    a(S.a(paramInt, 4));
    this.i = (-1 + this.i);
    return localy;
  }

  public <T extends y> T a(B<T> paramB, n paramn)
    throws IOException
  {
    int i1 = s();
    if (this.i >= this.j)
      throw s.h();
    int i2 = f(i1);
    this.i = (1 + this.i);
    y localy = (y)paramB.d(this, paramn);
    a(0);
    this.i = (-1 + this.i);
    g(i2);
    return localy;
  }

  public void a(int paramInt)
    throws s
  {
    if (this.f != paramInt)
      throw s.f();
  }

  public void a(int paramInt, y.a parama)
    throws IOException
  {
    a(paramInt, parama, null);
  }

  public void a(int paramInt, y.a parama, n paramn)
    throws IOException
  {
    if (this.i >= this.j)
      throw s.h();
    this.i = (1 + this.i);
    parama.c(this, paramn);
    a(S.a(paramInt, 4));
    this.i = (-1 + this.i);
  }

  public void a(y.a parama, n paramn)
    throws IOException
  {
    int i1 = s();
    if (this.i >= this.j)
      throw s.h();
    int i2 = f(i1);
    this.i = (1 + this.i);
    parama.c(this, paramn);
    a(0);
    this.i = (-1 + this.i);
    g(i2);
  }

  public void b()
    throws IOException
  {
    int i1;
    do
      i1 = a();
    while ((i1 != 0) && (b(i1)));
  }

  public boolean b(int paramInt)
    throws IOException
  {
    switch (S.a(paramInt))
    {
    default:
      throw s.g();
    case 0:
      g();
      return true;
    case 1:
      v();
      return true;
    case 2:
      i(s());
      return true;
    case 3:
      b();
      a(S.a(S.b(paramInt), 4));
      return true;
    case 4:
      return false;
    case 5:
    }
    u();
    return true;
  }

  public double c()
    throws IOException
  {
    return Double.longBitsToDouble(v());
  }

  public float d()
    throws IOException
  {
    return Float.intBitsToFloat(u());
  }

  public int d(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Recursion limit cannot be negative: " + paramInt);
    int i1 = this.j;
    this.j = paramInt;
    return i1;
  }

  public int e(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Size limit cannot be negative: " + paramInt);
    int i1 = this.k;
    this.k = paramInt;
    return i1;
  }

  public long e()
    throws IOException
  {
    return t();
  }

  public int f(int paramInt)
    throws s
  {
    if (paramInt < 0)
      throw s.c();
    int i1 = paramInt + (this.g + this.d);
    int i2 = this.h;
    if (i1 > i2)
      throw s.b();
    this.h = i1;
    B();
    return i2;
  }

  public long f()
    throws IOException
  {
    return t();
  }

  public int g()
    throws IOException
  {
    return s();
  }

  public void g(int paramInt)
  {
    this.h = paramInt;
    B();
  }

  public long h()
    throws IOException
  {
    return v();
  }

  public byte[] h(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw s.c();
    if (paramInt + (this.g + this.d) > this.h)
    {
      i(this.h - this.g - this.d);
      throw s.b();
    }
    if (paramInt <= this.b - this.d)
    {
      byte[] arrayOfByte5 = new byte[paramInt];
      System.arraycopy(this.a, this.d, arrayOfByte5, 0, paramInt);
      this.d = (paramInt + this.d);
      return arrayOfByte5;
    }
    if (paramInt < 4096)
    {
      byte[] arrayOfByte4 = new byte[paramInt];
      int i10 = this.b - this.d;
      System.arraycopy(this.a, this.d, arrayOfByte4, 0, i10);
      this.d = this.b;
      a(true);
      while (paramInt - i10 > this.b)
      {
        System.arraycopy(this.a, 0, arrayOfByte4, i10, this.b);
        i10 += this.b;
        this.d = this.b;
        a(true);
      }
      System.arraycopy(this.a, 0, arrayOfByte4, i10, paramInt - i10);
      this.d = (paramInt - i10);
      return arrayOfByte4;
    }
    int i1 = this.d;
    int i2 = this.b;
    this.g += this.b;
    this.d = 0;
    this.b = 0;
    int i3 = paramInt - (i2 - i1);
    ArrayList localArrayList = new ArrayList();
    int i8;
    for (int i4 = i3; i4 > 0; i4 = i8)
    {
      byte[] arrayOfByte3 = new byte[Math.min(i4, 4096)];
      int i7 = 0;
      while (i7 < arrayOfByte3.length)
      {
        if (this.e == null);
        for (int i9 = -1; i9 == -1; i9 = this.e.read(arrayOfByte3, i7, arrayOfByte3.length - i7))
          throw s.b();
        this.g = (i9 + this.g);
        i7 += i9;
      }
      i8 = i4 - arrayOfByte3.length;
      localArrayList.add(arrayOfByte3);
    }
    byte[] arrayOfByte1 = new byte[paramInt];
    int i5 = i2 - i1;
    System.arraycopy(this.a, i1, arrayOfByte1, 0, i5);
    Iterator localIterator = localArrayList.iterator();
    int i6 = i5;
    while (localIterator.hasNext())
    {
      byte[] arrayOfByte2 = (byte[])localIterator.next();
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i6, arrayOfByte2.length);
      i6 += arrayOfByte2.length;
    }
    return arrayOfByte1;
  }

  public int i()
    throws IOException
  {
    return u();
  }

  public void i(int paramInt)
    throws IOException
  {
    if (paramInt < 0)
      throw s.c();
    if (paramInt + (this.g + this.d) > this.h)
    {
      i(this.h - this.g - this.d);
      throw s.b();
    }
    if (paramInt <= this.b - this.d)
    {
      this.d = (paramInt + this.d);
      return;
    }
    int i1 = this.b - this.d;
    this.d = this.b;
    a(true);
    while (paramInt - i1 > this.b)
    {
      i1 += this.b;
      this.d = this.b;
      a(true);
    }
    this.d = (paramInt - i1);
  }

  public boolean j()
    throws IOException
  {
    return s() != 0;
  }

  public String k()
    throws IOException
  {
    int i1 = s();
    if ((i1 <= this.b - this.d) && (i1 > 0))
    {
      String str = new String(this.a, this.d, i1, "UTF-8");
      this.d = (i1 + this.d);
      return str;
    }
    return new String(h(i1), "UTF-8");
  }

  public g l()
    throws IOException
  {
    int i1 = s();
    if (i1 == 0)
      return g.d;
    if ((i1 <= this.b - this.d) && (i1 > 0))
    {
      g localg = g.a(this.a, this.d, i1);
      this.d = (i1 + this.d);
      return localg;
    }
    return g.a(h(i1));
  }

  public int m()
    throws IOException
  {
    return s();
  }

  public int n()
    throws IOException
  {
    return s();
  }

  public int o()
    throws IOException
  {
    return u();
  }

  public long p()
    throws IOException
  {
    return v();
  }

  public int q()
    throws IOException
  {
    return c(s());
  }

  public long r()
    throws IOException
  {
    return a(t());
  }

  public int s()
    throws IOException
  {
    int i1 = A();
    if (i1 >= 0);
    int i9;
    do
    {
      return i1;
      int i2 = i1 & 0x7F;
      int i3 = A();
      if (i3 >= 0)
        return i2 | i3 << 7;
      int i4 = i2 | (i3 & 0x7F) << 7;
      int i5 = A();
      if (i5 >= 0)
        return i4 | i5 << 14;
      int i6 = i4 | (i5 & 0x7F) << 14;
      int i7 = A();
      if (i7 >= 0)
        return i6 | i7 << 21;
      int i8 = i6 | (i7 & 0x7F) << 21;
      i9 = A();
      i1 = i8 | i9 << 28;
    }
    while (i9 >= 0);
    for (int i10 = 0; ; i10++)
    {
      if (i10 >= 5)
        break label151;
      if (A() >= 0)
        break;
    }
    label151: throw s.d();
  }

  public long t()
    throws IOException
  {
    int i1 = 0;
    long l1 = 0L;
    while (i1 < 64)
    {
      int i2 = A();
      l1 |= (i2 & 0x7F) << i1;
      if ((i2 & 0x80) == 0)
        return l1;
      i1 += 7;
    }
    throw s.d();
  }

  public int u()
    throws IOException
  {
    int i1 = A();
    int i2 = A();
    int i3 = A();
    int i4 = A();
    return i1 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16 | (i4 & 0xFF) << 24;
  }

  public long v()
    throws IOException
  {
    int i1 = A();
    int i2 = A();
    int i3 = A();
    int i4 = A();
    int i5 = A();
    int i6 = A();
    int i7 = A();
    int i8 = A();
    return 0xFF & i1 | (0xFF & i2) << 8 | (0xFF & i3) << 16 | (0xFF & i4) << 24 | (0xFF & i5) << 32 | (0xFF & i6) << 40 | (0xFF & i7) << 48 | (0xFF & i8) << 56;
  }

  public void w()
  {
    this.g = (-this.d);
  }

  public int x()
  {
    if (this.h == 2147483647)
      return -1;
    int i1 = this.g + this.d;
    return this.h - i1;
  }

  public boolean y()
    throws IOException
  {
    int i1 = this.d;
    int i2 = this.b;
    boolean bool1 = false;
    if (i1 == i2)
    {
      boolean bool2 = a(false);
      bool1 = false;
      if (!bool2)
        bool1 = true;
    }
    return bool1;
  }

  public int z()
  {
    return this.g + this.d;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.h
 * JD-Core Version:    0.6.2
 */