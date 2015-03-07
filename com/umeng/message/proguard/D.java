package com.umeng.message.proguard;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class D<MType extends p, BType extends p.a, IType extends A>
  implements p.b
{
  private p.b a;
  private List<MType> b;
  private boolean c;
  private List<L<MType, BType, IType>> d;
  private boolean e;
  private b<MType, BType, IType> f;
  private a<MType, BType, IType> g;
  private c<MType, BType, IType> h;

  public D(List<MType> paramList, boolean paramBoolean1, p.b paramb, boolean paramBoolean2)
  {
    this.b = paramList;
    this.c = paramBoolean1;
    this.a = paramb;
    this.e = paramBoolean2;
  }

  private MType a(int paramInt, boolean paramBoolean)
  {
    if (this.d == null)
      return (p)this.b.get(paramInt);
    L localL = (L)this.d.get(paramInt);
    if (localL == null)
      return (p)this.b.get(paramInt);
    if (paramBoolean)
      return localL.d();
    return localL.c();
  }

  private void j()
  {
    if (!this.c)
    {
      this.b = new ArrayList(this.b);
      this.c = true;
    }
  }

  private void k()
  {
    if (this.d == null)
    {
      this.d = new ArrayList(this.b.size());
      for (int i = 0; i < this.b.size(); i++)
        this.d.add(null);
    }
  }

  private void l()
  {
    if ((this.e) && (this.a != null))
    {
      this.a.a();
      this.e = false;
    }
  }

  private void m()
  {
    if (this.f != null)
      this.f.a();
    if (this.g != null)
      this.g.a();
    if (this.h != null)
      this.h.a();
  }

  public D<MType, BType, IType> a(int paramInt, MType paramMType)
  {
    if (paramMType == null)
      throw new NullPointerException();
    j();
    this.b.set(paramInt, paramMType);
    if (this.d != null)
    {
      L localL = (L)this.d.set(paramInt, null);
      if (localL != null)
        localL.b();
    }
    l();
    m();
    return this;
  }

  public D<MType, BType, IType> a(MType paramMType)
  {
    if (paramMType == null)
      throw new NullPointerException();
    j();
    this.b.add(paramMType);
    if (this.d != null)
      this.d.add(null);
    l();
    m();
    return this;
  }

  public D<MType, BType, IType> a(Iterable<? extends MType> paramIterable)
  {
    Iterator localIterator1 = paramIterable.iterator();
    while (localIterator1.hasNext())
      if ((p)localIterator1.next() == null)
        throw new NullPointerException();
    if ((paramIterable instanceof Collection))
    {
      if (((Collection)paramIterable).size() == 0)
        return this;
      j();
      Iterator localIterator3 = paramIterable.iterator();
      while (localIterator3.hasNext())
        a((p)localIterator3.next());
    }
    j();
    Iterator localIterator2 = paramIterable.iterator();
    while (localIterator2.hasNext())
      a((p)localIterator2.next());
    l();
    m();
    return this;
  }

  public MType a(int paramInt)
  {
    return a(paramInt, false);
  }

  public void a()
  {
    l();
  }

  public D<MType, BType, IType> b(int paramInt, MType paramMType)
  {
    if (paramMType == null)
      throw new NullPointerException();
    j();
    this.b.add(paramInt, paramMType);
    if (this.d != null)
      this.d.add(paramInt, null);
    l();
    m();
    return this;
  }

  public BType b(int paramInt)
  {
    k();
    Object localObject = (L)this.d.get(paramInt);
    if (localObject == null)
    {
      L localL = new L((p)this.b.get(paramInt), this, this.e);
      this.d.set(paramInt, localL);
      localObject = localL;
    }
    return ((L)localObject).e();
  }

  public BType b(MType paramMType)
  {
    j();
    k();
    L localL = new L(paramMType, this, this.e);
    this.b.add(null);
    this.d.add(localL);
    l();
    m();
    return localL.e();
  }

  public void b()
  {
    this.a = null;
  }

  public int c()
  {
    return this.b.size();
  }

  public IType c(int paramInt)
  {
    if (this.d == null)
      return (A)this.b.get(paramInt);
    L localL = (L)this.d.get(paramInt);
    if (localL == null)
      return (A)this.b.get(paramInt);
    return localL.f();
  }

  public BType c(int paramInt, MType paramMType)
  {
    j();
    k();
    L localL = new L(paramMType, this, this.e);
    this.b.add(paramInt, null);
    this.d.add(paramInt, localL);
    l();
    m();
    return localL.e();
  }

  public void d(int paramInt)
  {
    j();
    this.b.remove(paramInt);
    if (this.d != null)
    {
      L localL = (L)this.d.remove(paramInt);
      if (localL != null)
        localL.b();
    }
    l();
    m();
  }

  public boolean d()
  {
    return this.b.isEmpty();
  }

  public void e()
  {
    this.b = Collections.emptyList();
    this.c = false;
    if (this.d != null)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        L localL = (L)localIterator.next();
        if (localL != null)
          localL.b();
      }
      this.d = null;
    }
    l();
    m();
  }

  public List<MType> f()
  {
    this.e = true;
    if ((!this.c) && (this.d == null))
      return this.b;
    int j;
    if (!this.c)
    {
      j = 0;
      if (j >= this.b.size())
        break label173;
      x localx = (x)this.b.get(j);
      L localL = (L)this.d.get(j);
      if ((localL == null) || (localL.d() == localx));
    }
    label173: for (int k = 0; ; k = 1)
    {
      if (k != 0)
      {
        return this.b;
        j++;
        break;
      }
      j();
      for (int i = 0; i < this.b.size(); i++)
        this.b.set(i, a(i, true));
      this.b = Collections.unmodifiableList(this.b);
      this.c = false;
      return this.b;
    }
  }

  public List<MType> g()
  {
    if (this.f == null)
      this.f = new b(this);
    return this.f;
  }

  public List<BType> h()
  {
    if (this.g == null)
      this.g = new a(this);
    return this.g;
  }

  public List<IType> i()
  {
    if (this.h == null)
      this.h = new c(this);
    return this.h;
  }

  private static class a<MType extends p, BType extends p.a, IType extends A> extends AbstractList<BType>
    implements List<BType>
  {
    D<MType, BType, IType> a;

    a(D<MType, BType, IType> paramD)
    {
      this.a = paramD;
    }

    public BType a(int paramInt)
    {
      return this.a.b(paramInt);
    }

    void a()
    {
      this.modCount = (1 + this.modCount);
    }

    public int size()
    {
      return this.a.c();
    }
  }

  private static class b<MType extends p, BType extends p.a, IType extends A> extends AbstractList<MType>
    implements List<MType>
  {
    D<MType, BType, IType> a;

    b(D<MType, BType, IType> paramD)
    {
      this.a = paramD;
    }

    public MType a(int paramInt)
    {
      return this.a.a(paramInt);
    }

    void a()
    {
      this.modCount = (1 + this.modCount);
    }

    public int size()
    {
      return this.a.c();
    }
  }

  private static class c<MType extends p, BType extends p.a, IType extends A> extends AbstractList<IType>
    implements List<IType>
  {
    D<MType, BType, IType> a;

    c(D<MType, BType, IType> paramD)
    {
      this.a = paramD;
    }

    public IType a(int paramInt)
    {
      return this.a.c(paramInt);
    }

    void a()
    {
      this.modCount = (1 + this.modCount);
    }

    public int size()
    {
      return this.a.c();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.D
 * JD-Core Version:    0.6.2
 */