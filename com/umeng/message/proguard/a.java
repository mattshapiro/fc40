package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class a extends b
  implements x
{
  private int a = -1;

  protected static int a(long paramLong)
  {
    return (int)(paramLong ^ paramLong >>> 32);
  }

  protected static int a(r.a parama)
  {
    return parama.a();
  }

  protected static int a(List<? extends r.a> paramList)
  {
    Iterator localIterator = paramList.iterator();
    r.a locala;
    for (int i = 1; localIterator.hasNext(); i = i * 31 + a(locala))
      locala = (r.a)localIterator.next();
    return i;
  }

  protected static int a(boolean paramBoolean)
  {
    if (paramBoolean)
      return 1231;
    return 1237;
  }

  private static String c(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append(", ");
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }

  protected int a(int paramInt, Map<k.f, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      k.f localf = (k.f)localEntry.getKey();
      Object localObject = localEntry.getValue();
      int i = paramInt * 37 + localf.f();
      if (localf.i() != k.f.b.n)
      {
        paramInt = i * 53 + localObject.hashCode();
      }
      else if (localf.n())
      {
        List localList = (List)localObject;
        paramInt = i * 53 + a(localList);
      }
      else
      {
        paramInt = i * 53 + a((r.a)localObject);
      }
    }
    return paramInt;
  }

  public void a(i parami)
    throws IOException
  {
    boolean bool = J().g().o();
    Iterator localIterator = a_().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      k.f localf = (k.f)localEntry.getKey();
      Object localObject = localEntry.getValue();
      if ((bool) && (localf.t()) && (localf.i() == k.f.b.k) && (!localf.n()))
        parami.d(localf.f(), (x)localObject);
      else
        o.a(localf, localObject, parami);
    }
    P localP = b_();
    if (bool)
    {
      localP.b(parami);
      return;
    }
    localP.a(parami);
  }

  public boolean a()
  {
    Iterator localIterator1 = J().h().iterator();
    while (localIterator1.hasNext())
    {
      k.f localf2 = (k.f)localIterator1.next();
      if ((localf2.k()) && (!a_(localf2)))
        return false;
    }
    Iterator localIterator2 = a_().entrySet().iterator();
    while (true)
      if (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        k.f localf1 = (k.f)localEntry.getKey();
        if (localf1.g() == k.f.a.i)
        {
          if (localf1.n())
          {
            Iterator localIterator3 = ((List)localEntry.getValue()).iterator();
            if (!localIterator3.hasNext())
              continue;
            if (((x)localIterator3.next()).a())
              break;
            return false;
          }
          if (!((x)localEntry.getValue()).a())
            return false;
        }
      }
    return true;
  }

  public List<String> b()
  {
    return a.a(this);
  }

  public String c()
  {
    return c(b());
  }

  public int d()
  {
    int i = this.a;
    if (i != -1)
      return i;
    boolean bool = J().g().o();
    Iterator localIterator = a_().entrySet().iterator();
    int j = 0;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      k.f localf = (k.f)localEntry.getKey();
      Object localObject = localEntry.getValue();
      if ((bool) && (localf.t()) && (localf.i() == k.f.b.k) && (!localf.n()));
      for (int m = j + i.h(localf.f(), (x)localObject); ; m = j + o.c(localf, localObject))
      {
        j = m;
        break;
      }
    }
    P localP = b_();
    if (bool);
    for (int k = j + localP.i(); ; k = j + localP.d())
    {
      this.a = k;
      return k;
    }
  }

  O e()
  {
    return a.b(this);
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == this);
    x localx;
    do
    {
      return true;
      if (!(paramObject instanceof x))
        return false;
      localx = (x)paramObject;
      if (J() != localx.J())
        return false;
    }
    while ((a_().equals(localx.a_())) && (b_().equals(localx.b_())));
    return false;
  }

  public int hashCode()
  {
    return 29 * a(779 + J().hashCode(), a_()) + b_().hashCode();
  }

  public final String toString()
  {
    return N.b(this);
  }

  public static abstract class a<BuilderType extends a> extends b.a<BuilderType>
    implements x.a
  {
    private static String a(String paramString, k.f paramf, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString);
      if (paramf.t())
        localStringBuilder.append('(').append(paramf.d()).append(')');
      while (true)
      {
        if (paramInt != -1)
          localStringBuilder.append('[').append(paramInt).append(']');
        localStringBuilder.append('.');
        return localStringBuilder.toString();
        localStringBuilder.append(paramf.c());
      }
    }

    private static void a(A paramA, String paramString, List<String> paramList)
    {
      Iterator localIterator1 = paramA.J().h().iterator();
      while (localIterator1.hasNext())
      {
        k.f localf2 = (k.f)localIterator1.next();
        if ((localf2.k()) && (!paramA.a_(localf2)))
          paramList.add(paramString + localf2.c());
      }
      Iterator localIterator2 = paramA.a_().entrySet().iterator();
      while (localIterator2.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        k.f localf1 = (k.f)localEntry.getKey();
        Object localObject = localEntry.getValue();
        if (localf1.g() == k.f.a.i)
          if (localf1.n())
          {
            int i = 0;
            Iterator localIterator3 = ((List)localObject).iterator();
            while (localIterator3.hasNext())
            {
              A localA = (A)localIterator3.next();
              int j = i + 1;
              a(localA, a(paramString, localf1, i), paramList);
              i = j;
            }
          }
          else if (paramA.a_(localf1))
          {
            a((A)localObject, a(paramString, localf1, -1), paramList);
          }
      }
    }

    private static void a(g paramg, m.b paramb, n paramn, x.a parama, o<k.f> paramo)
      throws IOException
    {
      k.f localf = paramb.a;
      boolean bool = a(parama, paramo, localf);
      if ((bool) || (n.e()))
      {
        x.a locala;
        if (bool)
        {
          locala = b(parama, paramo, localf).M();
          locala.d(paramg, paramn);
        }
        for (x localx = locala.aj(); ; localx = (x)paramb.b.m().c(paramg, paramn))
        {
          b(parama, paramo, localf, localx);
          return;
        }
      }
      t localt = new t(paramb.b, paramn, paramg);
      if (parama != null)
      {
        if ((parama instanceof p.c))
        {
          parama.d(localf, localt);
          return;
        }
        parama.d(localf, localt.a());
        return;
      }
      paramo.a(localf, localt);
    }

    private static void a(h paramh, P.a parama, n paramn, k.a parama1, x.a parama2, o<k.f> paramo)
      throws IOException
    {
      int i = 0;
      m.b localb = null;
      g localg = null;
      int j = paramh.a();
      if (j == 0)
      {
        label20: paramh.a(S.m);
        if ((localg != null) && (i != 0))
        {
          if (localb == null)
            break label158;
          a(localg, localb, paramn, parama2, paramo);
        }
      }
      label158: 
      while (localg == null)
      {
        return;
        if (j == S.n)
        {
          i = paramh.m();
          if ((i == 0) || (!(paramn instanceof m)))
            break;
          localb = ((m)paramn).a(parama1, i);
          break;
        }
        if (j == S.o)
        {
          if ((i != 0) && (localb != null) && (n.e()))
          {
            a(paramh, localb, paramn, parama2, paramo);
            localg = null;
            break;
          }
          localg = paramh.l();
          break;
        }
        if (paramh.b(j))
          break;
        break label20;
      }
      parama.a(i, P.b.a().a(localg).a());
    }

    private static void a(h paramh, m.b paramb, n paramn, x.a parama, o<k.f> paramo)
      throws IOException
    {
      k.f localf = paramb.a;
      x.a locala;
      if (a(parama, paramo, localf))
      {
        locala = b(parama, paramo, localf).M();
        paramh.a(locala, paramn);
      }
      for (x localx = locala.aj(); parama != null; localx = (x)paramh.a(paramb.b.m(), paramn))
      {
        parama.d(localf, localx);
        return;
      }
      paramo.a(localf, localx);
    }

    private static void a(x.a parama1, o<k.f> paramo, k.f paramf, x.a parama2)
    {
      x localx = b(parama1, paramo, paramf);
      if (localx != null)
        parama2.c(localx);
    }

    private static void a(x.a parama, o<k.f> paramo, k.f paramf, Object paramObject)
    {
      if (parama != null)
      {
        parama.c(paramf, paramObject);
        return;
      }
      paramo.b(paramf, paramObject);
    }

    static boolean a(h paramh, P.a parama, n paramn, k.a parama1, x.a parama2, o<k.f> paramo, int paramInt)
      throws IOException
    {
      k.f localf1 = null;
      if ((parama1.g().o()) && (paramInt == S.l))
      {
        a(paramh, parama, paramn, parama1, parama2, paramo);
        return true;
      }
      int i = S.a(paramInt);
      int j = S.b(paramInt);
      m.b localb;
      x localx2;
      k.f localf2;
      x localx1;
      label92: int k;
      int m;
      if (parama1.a(j))
        if ((paramn instanceof m))
        {
          localb = ((m)paramn).a(parama1, j);
          if (localb == null)
          {
            localx2 = null;
            localf2 = localf1;
            localx1 = localx2;
            if (localf2 != null)
              break label215;
            k = 0;
            m = 1;
          }
        }
      while (true)
      {
        if (m == 0)
          break label278;
        return parama.a(paramInt, paramh);
        localf1 = localb.a;
        localx2 = localb.b;
        if ((localx2 != null) || (localf1.g() != k.f.a.i))
          break;
        throw new IllegalStateException("Message-typed extension lacked default instance: " + localf1.d());
        localx1 = null;
        localf2 = null;
        break label92;
        if (parama2 != null)
        {
          localf2 = parama1.b(j);
          localx1 = null;
          break label92;
        }
        localx1 = null;
        localf2 = null;
        break label92;
        label215: if (i == o.a(localf2.j(), false))
        {
          k = 0;
          m = 0;
        }
        else if ((localf2.p()) && (i == o.a(localf2.j(), true)))
        {
          k = 1;
          m = 0;
        }
        else
        {
          m = 1;
          k = 0;
        }
      }
      label278: if (k != 0)
      {
        int i1 = paramh.f(paramh.s());
        if (localf2.j() == S.a.n)
          while (paramh.x() > 0)
          {
            int i2 = paramh.n();
            k.e locale = localf2.x().a(i2);
            if (locale == null)
              return true;
            a(parama2, paramo, localf2, locale);
          }
        while (paramh.x() > 0)
          a(parama2, paramo, localf2, o.a(paramh, localf2.j()));
        paramh.g(i1);
      }
      while (true)
      {
        return true;
        Object localObject;
        switch (a.1.a[localf2.i().ordinal()])
        {
        default:
          localObject = o.a(paramh, localf2.j());
        case 1:
        case 2:
        case 3:
        }
        while (true)
          if (localf2.n())
          {
            a(parama2, paramo, localf2, localObject);
            break;
            if (localx1 != null);
            for (x.a locala2 = localx1.N(); ; locala2 = parama2.g(localf2))
            {
              if (!localf2.n())
                a(parama2, paramo, localf2, locala2);
              paramh.a(localf2.f(), locala2, paramn);
              localObject = locala2.aj();
              break;
            }
            if (localx1 != null);
            for (x.a locala1 = localx1.N(); ; locala1 = parama2.g(localf2))
            {
              if (!localf2.n())
                a(parama2, paramo, localf2, locala1);
              paramh.a(locala1, paramn);
              localObject = locala1.aj();
              break;
            }
            int n = paramh.n();
            localObject = localf2.x().a(n);
            if (localObject == null)
            {
              parama.a(j, n);
              return true;
            }
          }
        b(parama2, paramo, localf2, localObject);
      }
    }

    private static boolean a(x.a parama, o<k.f> paramo, k.f paramf)
    {
      if (parama != null)
        return parama.a_(paramf);
      return paramo.a(paramf);
    }

    protected static O b(x paramx)
    {
      return new O(b(paramx));
    }

    private static x b(x.a parama, o<k.f> paramo, k.f paramf)
    {
      if (parama != null)
        return (x)parama.b(paramf);
      return (x)paramo.b(paramf);
    }

    private static List<String> b(A paramA)
    {
      ArrayList localArrayList = new ArrayList();
      a(paramA, "", localArrayList);
      return localArrayList;
    }

    private static void b(x.a parama, o<k.f> paramo, k.f paramf, Object paramObject)
    {
      if (parama != null)
      {
        parama.d(paramf, paramObject);
        return;
      }
      paramo.a(paramf, paramObject);
    }

    public BuilderType a(P paramP)
    {
      e(P.a(b_()).a(paramP).b());
      return this;
    }

    public BuilderType a(g paramg)
      throws s
    {
      return (a)super.b(paramg);
    }

    public BuilderType a(g paramg, n paramn)
      throws s
    {
      return (a)super.b(paramg, paramn);
    }

    public BuilderType a(h paramh)
      throws IOException
    {
      return a(paramh, m.b());
    }

    public BuilderType a(h paramh, n paramn)
      throws IOException
    {
      P.a locala = P.a(b_());
      int i = paramh.a();
      if (i == 0);
      while (true)
      {
        e(locala.b());
        return this;
        if (a(paramh, locala, paramn, J(), this, null, i))
          break;
      }
    }

    public BuilderType a(x paramx)
    {
      if (paramx.J() != J())
        throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
      Iterator localIterator1 = paramx.a_().entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        k.f localf = (k.f)localEntry.getKey();
        if (localf.n())
        {
          Iterator localIterator2 = ((List)localEntry.getValue()).iterator();
          while (localIterator2.hasNext())
            c(localf, localIterator2.next());
        }
        else if (localf.g() == k.f.a.i)
        {
          x localx = (x)b(localf);
          if (localx == localx.R())
            d(localf, localEntry.getValue());
          else
            d(localf, localx.N().c(localx).c((x)localEntry.getValue()).ak());
        }
        else
        {
          d(localf, localEntry.getValue());
        }
      }
      a(paramx.b_());
      return this;
    }

    public BuilderType a(InputStream paramInputStream)
      throws IOException
    {
      return (a)super.c(paramInputStream);
    }

    public BuilderType a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (a)super.c(paramInputStream, paramn);
    }

    public BuilderType a(byte[] paramArrayOfByte)
      throws s
    {
      return (a)super.b(paramArrayOfByte);
    }

    public BuilderType a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws s
    {
      return (a)super.b(paramArrayOfByte, paramInt1, paramInt2);
    }

    public BuilderType a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, n paramn)
      throws s
    {
      return (a)super.b(paramArrayOfByte, paramInt1, paramInt2, paramn);
    }

    public BuilderType a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (a)super.b(paramArrayOfByte, paramn);
    }

    public x.a a(k.f paramf)
    {
      throw new UnsupportedOperationException("getFieldBuilder() called on an unsupported message type.");
    }

    public List<String> b()
    {
      return b(this);
    }

    public boolean b(InputStream paramInputStream)
      throws IOException
    {
      return super.b(paramInputStream);
    }

    public boolean b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return super.b(paramInputStream, paramn);
    }

    public String c()
    {
      return a.b(b());
    }

    public abstract BuilderType d();

    public BuilderType e()
    {
      Iterator localIterator = a_().entrySet().iterator();
      while (localIterator.hasNext())
        f((k.f)((Map.Entry)localIterator.next()).getKey());
      return this;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.a
 * JD-Core Version:    0.6.2
 */