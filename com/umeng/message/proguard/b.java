package com.umeng.message.proguard;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

public abstract class b
  implements y
{
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    i locali = i.a(paramOutputStream, i.a(d()));
    a(locali);
    locali.a();
  }

  public void b(OutputStream paramOutputStream)
    throws IOException
  {
    int i = d();
    i locali = i.a(paramOutputStream, i.a(i + i.q(i)));
    locali.p(i);
    a(locali);
    locali.a();
  }

  O e()
  {
    return new O(this);
  }

  public g f()
  {
    try
    {
      g.b localb = g.d(d());
      a(localb.b());
      g localg = localb.a();
      return localg;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", localIOException);
    }
  }

  public byte[] g()
  {
    try
    {
      byte[] arrayOfByte = new byte[d()];
      i locali = i.a(arrayOfByte);
      a(locali);
      locali.c();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public static abstract class a<BuilderType extends a>
    implements y.a
  {
    protected static O a(y paramy)
    {
      return new O(paramy);
    }

    private static void a(Iterable<?> paramIterable)
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
        if (localIterator.next() == null)
          throw new NullPointerException();
    }

    protected static <T> void a(Iterable<T> paramIterable, Collection<? super T> paramCollection)
    {
      if ((paramIterable instanceof v))
      {
        a(((v)paramIterable).a());
        if (!(paramIterable instanceof Collection))
          break label45;
        paramCollection.addAll((Collection)paramIterable);
      }
      while (true)
      {
        return;
        a(paramIterable);
        break;
        label45: Iterator localIterator = paramIterable.iterator();
        while (localIterator.hasNext())
          paramCollection.add(localIterator.next());
      }
    }

    public BuilderType b(g paramg)
      throws s
    {
      try
      {
        h localh = paramg.k();
        b(localh);
        localh.a(0);
        return this;
      }
      catch (s locals)
      {
        throw locals;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", localIOException);
      }
    }

    public BuilderType b(g paramg, n paramn)
      throws s
    {
      try
      {
        h localh = paramg.k();
        b(localh, paramn);
        localh.a(0);
        return this;
      }
      catch (s locals)
      {
        throw locals;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", localIOException);
      }
    }

    public BuilderType b(h paramh)
      throws IOException
    {
      return b(paramh, n.g());
    }

    public abstract BuilderType b(h paramh, n paramn)
      throws IOException;

    public BuilderType b(byte[] paramArrayOfByte)
      throws s
    {
      return b(paramArrayOfByte, 0, paramArrayOfByte.length);
    }

    public BuilderType b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws s
    {
      try
      {
        h localh = h.a(paramArrayOfByte, paramInt1, paramInt2);
        b(localh);
        localh.a(0);
        return this;
      }
      catch (s locals)
      {
        throw locals;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", localIOException);
      }
    }

    public BuilderType b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, n paramn)
      throws s
    {
      try
      {
        h localh = h.a(paramArrayOfByte, paramInt1, paramInt2);
        b(localh, paramn);
        localh.a(0);
        return this;
      }
      catch (s locals)
      {
        throw locals;
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", localIOException);
      }
    }

    public BuilderType b(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramn);
    }

    public boolean b(InputStream paramInputStream)
      throws IOException
    {
      return b(paramInputStream, n.g());
    }

    public boolean b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      int i = paramInputStream.read();
      if (i == -1)
        return false;
      c(new a(paramInputStream, h.a(i, paramInputStream)), paramn);
      return true;
    }

    public BuilderType c(InputStream paramInputStream)
      throws IOException
    {
      h localh = h.a(paramInputStream);
      b(localh);
      localh.a(0);
      return this;
    }

    public BuilderType c(InputStream paramInputStream, n paramn)
      throws IOException
    {
      h localh = h.a(paramInputStream);
      b(localh, paramn);
      localh.a(0);
      return this;
    }

    public abstract BuilderType f();

    static final class a extends FilterInputStream
    {
      private int a;

      a(InputStream paramInputStream, int paramInt)
      {
        super();
        this.a = paramInt;
      }

      public int available()
        throws IOException
      {
        return Math.min(super.available(), this.a);
      }

      public int read()
        throws IOException
      {
        int i;
        if (this.a <= 0)
          i = -1;
        do
        {
          return i;
          i = super.read();
        }
        while (i < 0);
        this.a = (-1 + this.a);
        return i;
      }

      public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
        throws IOException
      {
        int i;
        if (this.a <= 0)
          i = -1;
        do
        {
          return i;
          i = super.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.a));
        }
        while (i < 0);
        this.a -= i;
        return i;
      }

      public long skip(long paramLong)
        throws IOException
      {
        long l = super.skip(Math.min(paramLong, this.a));
        if (l >= 0L)
          this.a = ((int)(this.a - l));
        return l;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.b
 * JD-Core Version:    0.6.2
 */