package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

class E extends g
{
  private static final int[] f;
  private final int g;
  private final g h;
  private final g i;
  private final int j;
  private final int k;
  private int l = 0;

  static
  {
    int m = 1;
    ArrayList localArrayList = new ArrayList();
    int n = m;
    while (m > 0)
    {
      localArrayList.add(Integer.valueOf(m));
      int i2 = n + m;
      n = m;
      m = i2;
    }
    localArrayList.add(Integer.valueOf(2147483647));
    f = new int[localArrayList.size()];
    for (int i1 = 0; i1 < f.length; i1++)
      f[i1] = ((Integer)localArrayList.get(i1)).intValue();
  }

  private E(g paramg1, g paramg2)
  {
    this.h = paramg1;
    this.i = paramg2;
    this.j = paramg1.a();
    this.g = (this.j + paramg2.a());
    this.k = (1 + Math.max(paramg1.m(), paramg2.m()));
  }

  static g a(g paramg1, g paramg2)
  {
    if ((paramg1 instanceof E));
    for (E localE1 = (E)paramg1; paramg2.a() == 0; localE1 = null)
      return paramg1;
    if (paramg1.a() == 0)
      return paramg2;
    int m = paramg1.a() + paramg2.a();
    if (m < 128)
      return c(paramg1, paramg2);
    if ((localE1 != null) && (localE1.i.a() + paramg2.a() < 128))
    {
      w localw = c(localE1.i, paramg2);
      return new E(localE1.h, localw);
    }
    if ((localE1 != null) && (localE1.h.m() > localE1.i.m()) && (localE1.m() > paramg2.m()))
    {
      E localE2 = new E(localE1.i, paramg2);
      return new E(localE1.h, localE2);
    }
    int n = 1 + Math.max(paramg1.m(), paramg2.m());
    if (m >= f[n])
      return new E(paramg1, paramg2);
    return a.a(new a(null), paramg1, paramg2);
  }

  static E b(g paramg1, g paramg2)
  {
    return new E(paramg1, paramg2);
  }

  private static w c(g paramg1, g paramg2)
  {
    int m = paramg1.a();
    int n = paramg2.a();
    byte[] arrayOfByte = new byte[m + n];
    paramg1.b(arrayOfByte, 0, 0, m);
    paramg2.b(arrayOfByte, 0, m, n);
    return new w(arrayOfByte);
  }

  private boolean c(g paramg)
  {
    b localb1 = new b(this, null);
    w localw1 = (w)localb1.next();
    b localb2 = new b(paramg, null);
    Object localObject1 = (w)localb2.next();
    int m = 0;
    w localw2 = localw1;
    int n = 0;
    int i1 = 0;
    int i2 = localw2.a() - n;
    int i3 = ((w)localObject1).a() - m;
    int i4 = Math.min(i2, i3);
    if (n == 0);
    for (boolean bool = localw2.a((w)localObject1, m, i4); !bool; bool = ((w)localObject1).a(localw2, n, i4))
      return false;
    int i5 = i1 + i4;
    if (i5 >= this.g)
    {
      if (i5 == this.g)
        return true;
      throw new IllegalStateException();
    }
    label181: Object localObject3;
    int i7;
    if (i4 == i2)
    {
      localw2 = (w)localb1.next();
      n = 0;
      if (i4 != i3)
        break label228;
      localObject3 = (w)localb2.next();
      i7 = 0;
    }
    while (true)
    {
      m = i7;
      localObject1 = localObject3;
      i1 = i5;
      break;
      n += i4;
      break label181;
      label228: int i6 = m + i4;
      Object localObject2 = localObject1;
      i7 = i6;
      localObject3 = localObject2;
    }
  }

  public byte a(int paramInt)
  {
    if (paramInt < 0)
      throw new ArrayIndexOutOfBoundsException("Index < 0: " + paramInt);
    if (paramInt > this.g)
      throw new ArrayIndexOutOfBoundsException("Index > length: " + paramInt + ", " + this.g);
    if (paramInt < this.j)
      return this.h.a(paramInt);
    return this.i.a(paramInt - this.j);
  }

  public int a()
  {
    return this.g;
  }

  protected int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.j)
      return this.h.a(paramInt1, paramInt2, paramInt3);
    if (paramInt2 >= this.j)
      return this.i.a(paramInt1, paramInt2 - this.j, paramInt3);
    int m = this.j - paramInt2;
    int n = this.h.a(paramInt1, paramInt2, m);
    return this.i.a(n, 0, paramInt3 - m);
  }

  public g a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IndexOutOfBoundsException("Beginning index: " + paramInt1 + " < 0");
    if (paramInt2 > this.g)
      throw new IndexOutOfBoundsException("End index: " + paramInt2 + " > " + this.g);
    int m = paramInt2 - paramInt1;
    if (m < 0)
      throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + paramInt1 + ", " + paramInt2);
    if (m == 0)
      this = g.d;
    while (m == this.g)
      return this;
    if (paramInt2 <= this.j)
      return this.h.a(paramInt1, paramInt2);
    if (paramInt1 >= this.j)
      return this.i.a(paramInt1 - this.j, paramInt2 - this.j);
    return new E(this.h.b(paramInt1), this.i.a(0, paramInt2 - this.j));
  }

  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    this.h.a(paramOutputStream);
    this.i.a(paramOutputStream);
  }

  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 + paramInt3 <= this.j)
    {
      this.h.a(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return;
    }
    if (paramInt1 >= this.j)
    {
      this.i.a(paramArrayOfByte, paramInt1 - this.j, paramInt2, paramInt3);
      return;
    }
    int m = this.j - paramInt1;
    this.h.a(paramArrayOfByte, paramInt1, paramInt2, m);
    this.i.a(paramArrayOfByte, 0, paramInt2 + m, paramInt3 - m);
  }

  protected int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 + paramInt3 <= this.j)
      return this.h.b(paramInt1, paramInt2, paramInt3);
    if (paramInt2 >= this.j)
      return this.i.b(paramInt1, paramInt2 - this.j, paramInt3);
    int m = this.j - paramInt2;
    int n = this.h.b(paramInt1, paramInt2, m);
    return this.i.b(n, 0, paramInt3 - m);
  }

  public String b(String paramString)
    throws UnsupportedEncodingException
  {
    return new String(e(), paramString);
  }

  public void b(ByteBuffer paramByteBuffer)
  {
    this.h.b(paramByteBuffer);
    this.i.b(paramByteBuffer);
  }

  public g.a c()
  {
    return new c(null);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    g localg;
    do
    {
      return true;
      if (!(paramObject instanceof g))
        return false;
      localg = (g)paramObject;
      if (this.g != localg.a())
        return false;
    }
    while (this.g == 0);
    if (this.l != 0)
    {
      int m = localg.o();
      if ((m != 0) && (this.l != m))
        return false;
    }
    return c(localg);
  }

  public ByteBuffer f()
  {
    return ByteBuffer.wrap(e()).asReadOnlyBuffer();
  }

  public List<ByteBuffer> g()
  {
    ArrayList localArrayList = new ArrayList();
    b localb = new b(this, null);
    while (localb.hasNext())
      localArrayList.add(localb.a().f());
    return localArrayList;
  }

  public int hashCode()
  {
    int m = this.l;
    if (m == 0)
    {
      m = b(this.g, 0, this.g);
      if (m == 0)
        m = 1;
      this.l = m;
    }
    return m;
  }

  public boolean i()
  {
    int m = this.h.a(0, 0, this.j);
    int n = this.i.a(m, 0, this.i.a());
    boolean bool = false;
    if (n == 0)
      bool = true;
    return bool;
  }

  public InputStream j()
  {
    return new d();
  }

  public h k()
  {
    return h.a(new d());
  }

  protected int m()
  {
    return this.k;
  }

  protected boolean n()
  {
    return this.g >= f[this.k];
  }

  protected int o()
  {
    return this.l;
  }

  private static class a
  {
    private final Stack<g> a = new Stack();

    private int a(int paramInt)
    {
      int i = Arrays.binarySearch(E.b(), paramInt);
      if (i < 0)
        i = -1 + -(i + 1);
      return i;
    }

    private g a(g paramg1, g paramg2)
    {
      a(paramg1);
      a(paramg2);
      for (Object localObject = (g)this.a.pop(); !this.a.isEmpty(); localObject = new E((g)this.a.pop(), (g)localObject, null));
      return localObject;
    }

    private void a(g paramg)
    {
      if (paramg.n())
      {
        b(paramg);
        return;
      }
      if ((paramg instanceof E))
      {
        E localE = (E)paramg;
        a(E.a(localE));
        a(E.b(localE));
        return;
      }
      throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + paramg.getClass());
    }

    private void b(g paramg)
    {
      int i = a(paramg.a());
      int j = E.b()[(i + 1)];
      if ((this.a.isEmpty()) || (((g)this.a.peek()).a() >= j))
      {
        this.a.push(paramg);
        return;
      }
      int k = E.b()[i];
      for (Object localObject = (g)this.a.pop(); (!this.a.isEmpty()) && (((g)this.a.peek()).a() < k); localObject = new E((g)this.a.pop(), (g)localObject, null));
      for (E localE = new E((g)localObject, paramg, null); !this.a.isEmpty(); localE = new E((g)this.a.pop(), localE, null))
      {
        int m = a(localE.a());
        int n = E.b()[(m + 1)];
        if (((g)this.a.peek()).a() >= n)
          break;
      }
      this.a.push(localE);
    }
  }

  private static class b
    implements Iterator<w>
  {
    private final Stack<E> a = new Stack();
    private w b = a(paramg);

    private b(g paramg)
    {
    }

    private w a(g paramg)
    {
      E localE;
      for (g localg = paramg; (localg instanceof E); localg = E.a(localE))
      {
        localE = (E)localg;
        this.a.push(localE);
      }
      return (w)localg;
    }

    private w b()
    {
      w localw;
      do
      {
        if (this.a.isEmpty())
          return null;
        localw = a(E.b((E)this.a.pop()));
      }
      while (localw.d());
      return localw;
    }

    public w a()
    {
      if (this.b == null)
        throw new NoSuchElementException();
      w localw = this.b;
      this.b = b();
      return localw;
    }

    public boolean hasNext()
    {
      return this.b != null;
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }

  private class c
    implements g.a
  {
    int a = E.this.a();
    private final E.b c = new E.b(E.this, null);
    private g.a d = this.c.a().c();

    private c()
    {
    }

    public Byte a()
    {
      return Byte.valueOf(b());
    }

    public byte b()
    {
      if (!this.d.hasNext())
        this.d = this.c.a().c();
      this.a = (-1 + this.a);
      return this.d.b();
    }

    public boolean hasNext()
    {
      return this.a > 0;
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }

  private class d extends InputStream
  {
    private E.b b;
    private w c;
    private int d;
    private int e;
    private int f;
    private int g;

    public d()
    {
      a();
    }

    private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int i = paramInt2;
      int j = paramInt1;
      while (i > 0)
      {
        b();
        if (this.c == null)
        {
          if (i != paramInt2)
            break;
          return -1;
        }
        int k = Math.min(this.d - this.e, i);
        if (paramArrayOfByte != null)
        {
          this.c.b(paramArrayOfByte, this.e, j, k);
          j += k;
        }
        this.e = (k + this.e);
        i -= k;
      }
      return paramInt2 - i;
    }

    private void a()
    {
      this.b = new E.b(E.this, null);
      this.c = this.b.a();
      this.d = this.c.a();
      this.e = 0;
      this.f = 0;
    }

    private void b()
    {
      if ((this.c != null) && (this.e == this.d))
      {
        this.f += this.d;
        this.e = 0;
        if (this.b.hasNext())
        {
          this.c = this.b.a();
          this.d = this.c.a();
        }
      }
      else
      {
        return;
      }
      this.c = null;
      this.d = 0;
    }

    public int available()
      throws IOException
    {
      int i = this.f + this.e;
      return E.this.a() - i;
    }

    public void mark(int paramInt)
    {
      this.g = (this.f + this.e);
    }

    public boolean markSupported()
    {
      return true;
    }

    public int read()
      throws IOException
    {
      b();
      if (this.c == null)
        return -1;
      w localw = this.c;
      int i = this.e;
      this.e = (i + 1);
      return 0xFF & localw.a(i);
    }

    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if (paramArrayOfByte == null)
        throw new NullPointerException();
      if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt2 > paramArrayOfByte.length - paramInt1))
        throw new IndexOutOfBoundsException();
      return a(paramArrayOfByte, paramInt1, paramInt2);
    }

    public void reset()
    {
      try
      {
        a();
        a(null, 0, this.g);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }

    public long skip(long paramLong)
    {
      if (paramLong < 0L)
        throw new IndexOutOfBoundsException();
      if (paramLong > 2147483647L)
        paramLong = 2147483647L;
      return a(null, 0, (int)paramLong);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.E
 * JD-Core Version:    0.6.2
 */