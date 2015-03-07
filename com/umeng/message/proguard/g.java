package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class g
  implements Iterable<Byte>
{
  static final int a = 128;
  static final int b = 256;
  static final int c = 8192;
  public static final g d;

  static
  {
    if (!g.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      e = bool;
      d = new w(new byte[0]);
      return;
    }
  }

  public static g a(InputStream paramInputStream)
    throws IOException
  {
    return a(paramInputStream, 256, 8192);
  }

  public static g a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return a(paramInputStream, paramInt, paramInt);
  }

  public static g a(InputStream paramInputStream, int paramInt1, int paramInt2)
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      g localg = b(paramInputStream, paramInt1);
      if (localg == null)
        return a(localArrayList);
      localArrayList.add(localg);
      paramInt1 = Math.min(paramInt1 * 2, paramInt2);
    }
  }

  public static g a(Iterable<g> paramIterable)
  {
    ArrayList localArrayList;
    if (!(paramIterable instanceof Collection))
    {
      localArrayList = new ArrayList();
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
        localArrayList.add((g)localIterator.next());
    }
    for (Object localObject = localArrayList; ((Collection)localObject).isEmpty(); localObject = (Collection)paramIterable)
      return d;
    return a(((Collection)localObject).iterator(), ((Collection)localObject).size());
  }

  public static g a(String paramString)
  {
    try
    {
      w localw = new w(paramString.getBytes("UTF-8"));
      return localw;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }

  public static g a(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    return new w(paramString1.getBytes(paramString2));
  }

  public static g a(ByteBuffer paramByteBuffer)
  {
    return a(paramByteBuffer, paramByteBuffer.remaining());
  }

  public static g a(ByteBuffer paramByteBuffer, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return new w(arrayOfByte);
  }

  private static g a(Iterator<g> paramIterator, int paramInt)
  {
    if ((!e) && (paramInt < 1))
      throw new AssertionError();
    if (paramInt == 1)
      return (g)paramIterator.next();
    int i = paramInt >>> 1;
    return a(paramIterator, i).b(a(paramIterator, paramInt - i));
  }

  public static g a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new w(arrayOfByte);
  }

  private static g b(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = 0;
    while (true)
    {
      int j;
      if (i < paramInt)
      {
        j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j != -1);
      }
      else
      {
        if (i != 0)
          break;
        return null;
      }
      i += j;
    }
    return a(arrayOfByte, 0, i);
  }

  public static c c(int paramInt)
  {
    return new c(paramInt);
  }

  static b d(int paramInt)
  {
    return new b(paramInt, null);
  }

  public static c l()
  {
    return new c(128);
  }

  public abstract byte a(int paramInt);

  public abstract int a();

  protected abstract int a(int paramInt1, int paramInt2, int paramInt3);

  public abstract g a(int paramInt1, int paramInt2);

  public abstract void a(OutputStream paramOutputStream)
    throws IOException;

  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    b(paramArrayOfByte, 0, paramInt, a());
  }

  protected abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);

  public boolean a(g paramg)
  {
    int i = a();
    int j = paramg.a();
    boolean bool1 = false;
    if (i >= j)
    {
      boolean bool2 = a(0, paramg.a()).equals(paramg);
      bool1 = false;
      if (bool2)
        bool1 = true;
    }
    return bool1;
  }

  protected abstract int b(int paramInt1, int paramInt2, int paramInt3);

  public g b(int paramInt)
  {
    return a(paramInt, a());
  }

  public g b(g paramg)
  {
    int i = a();
    int j = paramg.a();
    if (i + j >= 2147483647L)
      throw new IllegalArgumentException("ByteString would be too long: " + i + "+" + j);
    return E.a(this, paramg);
  }

  public abstract String b(String paramString)
    throws UnsupportedEncodingException;

  public abstract void b(ByteBuffer paramByteBuffer);

  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < 0)
      throw new IndexOutOfBoundsException("Source offset < 0: " + paramInt1);
    if (paramInt2 < 0)
      throw new IndexOutOfBoundsException("Target offset < 0: " + paramInt2);
    if (paramInt3 < 0)
      throw new IndexOutOfBoundsException("Length < 0: " + paramInt3);
    if (paramInt1 + paramInt3 > a())
      throw new IndexOutOfBoundsException("Source end offset < 0: " + (paramInt1 + paramInt3));
    if (paramInt2 + paramInt3 > paramArrayOfByte.length)
      throw new IndexOutOfBoundsException("Target end offset < 0: " + (paramInt2 + paramInt3));
    if (paramInt3 > 0)
      a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }

  public abstract a c();

  public boolean d()
  {
    return a() == 0;
  }

  public byte[] e()
  {
    int i = a();
    byte[] arrayOfByte = new byte[i];
    a(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }

  public abstract boolean equals(Object paramObject);

  public abstract ByteBuffer f();

  public abstract List<ByteBuffer> g();

  public String h()
  {
    try
    {
      String str = b("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }

  public abstract int hashCode();

  public abstract boolean i();

  public abstract InputStream j();

  public abstract h k();

  protected abstract int m();

  protected abstract boolean n();

  protected abstract int o();

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.toHexString(System.identityHashCode(this));
    arrayOfObject[1] = Integer.valueOf(a());
    return String.format("<ByteString@%s size=%d>", arrayOfObject);
  }

  public static abstract interface a extends Iterator<Byte>
  {
    public abstract byte b();
  }

  static final class b
  {
    private final i a;
    private final byte[] b;

    private b(int paramInt)
    {
      this.b = new byte[paramInt];
      this.a = i.a(this.b);
    }

    public g a()
    {
      this.a.c();
      return new w(this.b);
    }

    public i b()
    {
      return this.a;
    }
  }

  public static final class c extends OutputStream
  {
    private static final byte[] a = new byte[0];
    private final int b;
    private final ArrayList<g> c;
    private int d;
    private byte[] e;
    private int f;

    c(int paramInt)
    {
      if (paramInt < 0)
        throw new IllegalArgumentException("Buffer size < 0");
      this.b = paramInt;
      this.c = new ArrayList();
      this.e = new byte[paramInt];
    }

    private void a(int paramInt)
    {
      this.c.add(new w(this.e));
      this.d += this.e.length;
      this.e = new byte[Math.max(this.b, Math.max(paramInt, this.d >>> 1))];
      this.f = 0;
    }

    private byte[] a(byte[] paramArrayOfByte, int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt));
      return arrayOfByte;
    }

    private void d()
    {
      if (this.f < this.e.length)
        if (this.f > 0)
        {
          byte[] arrayOfByte = a(this.e, this.f);
          this.c.add(new w(arrayOfByte));
        }
      while (true)
      {
        this.d += this.f;
        this.f = 0;
        return;
        this.c.add(new w(this.e));
        this.e = a;
      }
    }

    public g a()
    {
      try
      {
        d();
        g localg = g.a(this.c);
        return localg;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void a(OutputStream paramOutputStream)
      throws IOException
    {
      byte[] arrayOfByte;
      int i;
      try
      {
        g[] arrayOfg = (g[])this.c.toArray(new g[this.c.size()]);
        arrayOfByte = this.e;
        i = this.f;
        int j = arrayOfg.length;
        for (int k = 0; k < j; k++)
          arrayOfg[k].a(paramOutputStream);
      }
      finally
      {
      }
      paramOutputStream.write(a(arrayOfByte, i));
    }

    public int b()
    {
      try
      {
        int i = this.d;
        int j = this.f;
        int k = i + j;
        return k;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public void c()
    {
      try
      {
        this.c.clear();
        this.d = 0;
        this.f = 0;
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public String toString()
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.toHexString(System.identityHashCode(this));
      arrayOfObject[1] = Integer.valueOf(b());
      return String.format("<ByteString.Output@%s size=%d>", arrayOfObject);
    }

    public void write(int paramInt)
    {
      try
      {
        if (this.f == this.e.length)
          a(1);
        byte[] arrayOfByte = this.e;
        int i = this.f;
        this.f = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
        return;
      }
      finally
      {
      }
    }

    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        if (paramInt2 <= this.e.length - this.f)
          System.arraycopy(paramArrayOfByte, paramInt1, this.e, this.f, paramInt2);
        int k;
        for (this.f = (paramInt2 + this.f); ; this.f = k)
        {
          return;
          int i = this.e.length - this.f;
          System.arraycopy(paramArrayOfByte, paramInt1, this.e, this.f, i);
          int j = paramInt1 + i;
          k = paramInt2 - i;
          a(k);
          System.arraycopy(paramArrayOfByte, j, this.e, 0, k);
        }
      }
      finally
      {
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.g
 * JD-Core Version:    0.6.2
 */