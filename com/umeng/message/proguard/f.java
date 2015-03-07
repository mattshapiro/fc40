package com.umeng.message.proguard;

import java.util.NoSuchElementException;

class f extends w
{
  private final int g;
  private final int h;

  f(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    super(paramArrayOfByte);
    if (paramInt1 < 0)
      throw new IllegalArgumentException("Offset too small: " + paramInt1);
    if (paramInt2 < 0)
      throw new IllegalArgumentException("Length too small: " + paramInt1);
    if (paramInt1 + paramInt2 > paramArrayOfByte.length)
      throw new IllegalArgumentException("Offset+Length too large: " + paramInt1 + "+" + paramInt2);
    this.g = paramInt1;
    this.h = paramInt2;
  }

  public byte a(int paramInt)
  {
    if (paramInt < 0)
      throw new ArrayIndexOutOfBoundsException("Index too small: " + paramInt);
    if (paramInt >= a())
      throw new ArrayIndexOutOfBoundsException("Index too large: " + paramInt + ", " + a());
    return this.f[(paramInt + this.g)];
  }

  public int a()
  {
    return this.h;
  }

  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.f, paramInt1 + b(), paramArrayOfByte, paramInt2, paramInt3);
  }

  protected int b()
  {
    return this.g;
  }

  public g.a c()
  {
    return new a(null);
  }

  private class a
    implements g.a
  {
    private int b = f.this.b();
    private final int c = this.b + f.this.a();

    private a()
    {
    }

    public Byte a()
    {
      return Byte.valueOf(b());
    }

    public byte b()
    {
      if (this.b >= this.c)
        throw new NoSuchElementException();
      byte[] arrayOfByte = f.this.f;
      int i = this.b;
      this.b = (i + 1);
      return arrayOfByte[i];
    }

    public boolean hasNext()
    {
      return this.b < this.c;
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.f
 * JD-Core Version:    0.6.2
 */