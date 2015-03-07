package com.umeng.message.proguard;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class w extends g
{
  protected final byte[] f;
  private int g = 0;

  w(byte[] paramArrayOfByte)
  {
    this.f = paramArrayOfByte;
  }

  public byte a(int paramInt)
  {
    return this.f[paramInt];
  }

  public int a()
  {
    return this.f.length;
  }

  protected int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 + b();
    return R.a(paramInt1, this.f, i, i + paramInt3);
  }

  public g a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IndexOutOfBoundsException("Beginning index: " + paramInt1 + " < 0");
    if (paramInt2 > a())
      throw new IndexOutOfBoundsException("End index: " + paramInt2 + " > " + a());
    int i = paramInt2 - paramInt1;
    if (i < 0)
      throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + paramInt1 + ", " + paramInt2);
    if (i == 0)
      return g.d;
    return new f(this.f, paramInt1 + b(), i);
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(e());
  }

  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    System.arraycopy(this.f, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
  }

  boolean a(w paramw, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramw.a())
      throw new IllegalArgumentException("Length too large: " + paramInt2 + a());
    if (paramInt1 + paramInt2 > paramw.a())
      throw new IllegalArgumentException("Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + paramw.a());
    byte[] arrayOfByte1 = this.f;
    byte[] arrayOfByte2 = paramw.f;
    int i = paramInt2 + b();
    int j = b();
    for (int k = paramInt1 + paramw.b(); j < i; k++)
    {
      if (arrayOfByte1[j] != arrayOfByte2[k])
        return false;
      j++;
    }
    return true;
  }

  protected int b()
  {
    return 0;
  }

  protected int b(int paramInt1, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = this.f;
    int i = paramInt2 + b();
    int j = i + paramInt3;
    while (i < j)
    {
      paramInt1 = paramInt1 * 31 + arrayOfByte[i];
      i++;
    }
    return paramInt1;
  }

  public String b(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(this.f, b(), a(), paramString);
  }

  public void b(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.put(this.f, b(), a());
  }

  public g.a c()
  {
    return new a(null);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this)
      return true;
    if (!(paramObject instanceof g))
      return false;
    if (a() != ((g)paramObject).a())
      return false;
    if (a() == 0)
      return true;
    if ((paramObject instanceof w))
      return a((w)paramObject, 0, a());
    if ((paramObject instanceof E))
      return paramObject.equals(this);
    throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + paramObject.getClass());
  }

  public ByteBuffer f()
  {
    return ByteBuffer.wrap(this.f, b(), a()).asReadOnlyBuffer();
  }

  public List<ByteBuffer> g()
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(f());
    return localArrayList;
  }

  public int hashCode()
  {
    int i = this.g;
    if (i == 0)
    {
      int j = a();
      i = b(j, 0, j);
      if (i == 0)
        i = 1;
      this.g = i;
    }
    return i;
  }

  public boolean i()
  {
    int i = b();
    return R.a(this.f, i, i + a());
  }

  public InputStream j()
  {
    return new ByteArrayInputStream(this.f, b(), a());
  }

  public h k()
  {
    return h.a(this.f, b(), a());
  }

  protected int m()
  {
    return 0;
  }

  protected boolean n()
  {
    return true;
  }

  protected int o()
  {
    return this.g;
  }

  private class a
    implements g.a
  {
    private int b = 0;
    private final int c = w.this.a();

    private a()
    {
    }

    public Byte a()
    {
      return Byte.valueOf(b());
    }

    public byte b()
    {
      try
      {
        byte[] arrayOfByte = w.this.f;
        int i = this.b;
        this.b = (i + 1);
        byte b1 = arrayOfByte[i];
        return b1;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        throw new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
      }
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
 * Qualified Name:     com.umeng.message.proguard.w
 * JD-Core Version:    0.6.2
 */