package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class l extends a
{
  private final k.a a;
  private final o<k.f> b;
  private final P c;
  private int d = -1;

  private l(k.a parama, o<k.f> paramo, P paramP)
  {
    this.a = parama;
    this.b = paramo;
    this.c = paramP;
  }

  public static a a(x paramx)
  {
    return new a(paramx.J(), null).d(paramx);
  }

  public static l a(k.a parama)
  {
    return new l(parama, o.b(), P.c());
  }

  public static l a(k.a parama, g paramg)
    throws s
  {
    return a.a((a)b(parama).a(paramg));
  }

  public static l a(k.a parama, g paramg, m paramm)
    throws s
  {
    return a.a((a)b(parama).a(paramg, paramm));
  }

  public static l a(k.a parama, h paramh)
    throws IOException
  {
    return a.a((a)b(parama).a(paramh));
  }

  public static l a(k.a parama, h paramh, m paramm)
    throws IOException
  {
    return a.a((a)b(parama).a(paramh, paramm));
  }

  public static l a(k.a parama, InputStream paramInputStream)
    throws IOException
  {
    return a.a((a)b(parama).a(paramInputStream));
  }

  public static l a(k.a parama, InputStream paramInputStream, m paramm)
    throws IOException
  {
    return a.a((a)b(parama).a(paramInputStream, paramm));
  }

  public static l a(k.a parama, byte[] paramArrayOfByte)
    throws s
  {
    return a.a((a)b(parama).a(paramArrayOfByte));
  }

  public static l a(k.a parama, byte[] paramArrayOfByte, m paramm)
    throws s
  {
    return a.a((a)b(parama).a(paramArrayOfByte, paramm));
  }

  public static a b(k.a parama)
  {
    return new a(parama, null);
  }

  private static boolean b(k.a parama, o<k.f> paramo)
  {
    Iterator localIterator = parama.h().iterator();
    while (localIterator.hasNext())
    {
      k.f localf = (k.f)localIterator.next();
      if ((localf.k()) && (!paramo.a(localf)))
        return false;
    }
    return paramo.i();
  }

  private void d(k.f paramf)
  {
    if (paramf.u() != this.a)
      throw new IllegalArgumentException("FieldDescriptor does not match message type.");
  }

  public k.a J()
  {
    return this.a;
  }

  public Object a(k.f paramf, int paramInt)
  {
    d(paramf);
    return this.b.a(paramf, paramInt);
  }

  public void a(i parami)
    throws IOException
  {
    if (this.a.g().o())
    {
      this.b.b(parami);
      this.c.b(parami);
      return;
    }
    this.b.a(parami);
    this.c.a(parami);
  }

  public boolean a()
  {
    return b(this.a, this.b);
  }

  public Map<k.f, Object> a_()
  {
    return this.b.g();
  }

  public boolean a_(k.f paramf)
  {
    d(paramf);
    return this.b.a(paramf);
  }

  public Object b(k.f paramf)
  {
    d(paramf);
    Object localObject = this.b.b(paramf);
    if (localObject == null)
    {
      if (paramf.n())
        localObject = Collections.emptyList();
    }
    else
      return localObject;
    if (paramf.g() == k.f.a.i)
      return a(paramf.w());
    return paramf.r();
  }

  public P b_()
  {
    return this.c;
  }

  public int c(k.f paramf)
  {
    d(paramf);
    return this.b.d(paramf);
  }

  public int d()
  {
    int i = this.d;
    if (i != -1)
      return i;
    if (this.a.g().o());
    for (int j = this.b.k() + this.c.i(); ; j = this.b.j() + this.c.d())
    {
      this.d = j;
      return j;
    }
  }

  public l h()
  {
    return a(this.a);
  }

  public a k()
  {
    return new a(this.a, null);
  }

  public a l()
  {
    return k().d(this);
  }

  public B<l> m()
  {
    return new c()
    {
      public l c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        l.a locala = l.b(l.a(l.this));
        try
        {
          locala.a(paramAnonymoush, paramAnonymousn);
          return locala.m();
        }
        catch (s locals)
        {
          throw locals.a(locala.m());
        }
        catch (IOException localIOException)
        {
          throw new s(localIOException.getMessage()).a(locala.m());
        }
      }
    };
  }

  public static final class a extends a.a<a>
  {
    private final k.a a;
    private o<k.f> b;
    private P c;

    private a(k.a parama)
    {
      this.a = parama;
      this.b = o.a();
      this.c = P.c();
    }

    private void h(k.f paramf)
    {
      if (paramf.u() != this.a)
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private l p()
      throws s
    {
      if (!a())
        throw b(new l(this.a, this.b, this.c, null)).b();
      return m();
    }

    private void q()
    {
      if (this.b.d())
        this.b = this.b.e();
    }

    public k.a J()
    {
      return this.a;
    }

    public a a(k.f paramf, int paramInt, Object paramObject)
    {
      h(paramf);
      q();
      this.b.a(paramf, paramInt, paramObject);
      return this;
    }

    public a a(k.f paramf, Object paramObject)
    {
      h(paramf);
      q();
      this.b.a(paramf, paramObject);
      return this;
    }

    public x.a a(k.f paramf)
    {
      throw new UnsupportedOperationException("getFieldBuilder() called on a dynamic message type.");
    }

    public Object a(k.f paramf, int paramInt)
    {
      h(paramf);
      return this.b.a(paramf, paramInt);
    }

    public boolean a()
    {
      return l.a(this.a, this.b);
    }

    public Map<k.f, Object> a_()
    {
      return this.b.g();
    }

    public boolean a_(k.f paramf)
    {
      h(paramf);
      return this.b.a(paramf);
    }

    public a b(k.f paramf, Object paramObject)
    {
      h(paramf);
      q();
      this.b.b(paramf, paramObject);
      return this;
    }

    public Object b(k.f paramf)
    {
      h(paramf);
      Object localObject = this.b.b(paramf);
      if (localObject == null)
      {
        if (paramf.g() == k.f.a.i)
          localObject = l.a(paramf.w());
      }
      else
        return localObject;
      return paramf.r();
    }

    public P b_()
    {
      return this.c;
    }

    public int c(k.f paramf)
    {
      h(paramf);
      return this.b.d(paramf);
    }

    public a c(P paramP)
    {
      this.c = paramP;
      return this;
    }

    public a d(P paramP)
    {
      this.c = P.a(this.c).a(paramP).b();
      return this;
    }

    public a d(k.f paramf)
    {
      h(paramf);
      if (paramf.g() != k.f.a.i)
        throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
      return new a(paramf.w());
    }

    public a d(x paramx)
    {
      if ((paramx instanceof l))
      {
        l locall = (l)paramx;
        if (l.a(locall) != this.a)
          throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        q();
        this.b.a(l.b(locall));
        d(l.c(locall));
        return this;
      }
      return (a)super.a(paramx);
    }

    public a e(k.f paramf)
    {
      h(paramf);
      q();
      this.b.c(paramf);
      return this;
    }

    public a k()
    {
      if (this.b.d())
        this.b = o.a();
      while (true)
      {
        this.c = P.c();
        return this;
        this.b.f();
      }
    }

    public l l()
    {
      if (!a())
        throw b(new l(this.a, this.b, this.c, null));
      return m();
    }

    public l m()
    {
      this.b.c();
      return new l(this.a, this.b, this.c, null);
    }

    public a n()
    {
      a locala = new a(this.a);
      locala.b.a(this.b);
      locala.d(this.c);
      return locala;
    }

    public l o()
    {
      return l.a(this.a);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.l
 * JD-Core Version:    0.6.2
 */