package com.umeng.message.proguard;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public abstract class p extends a
  implements Serializable
{
  private static final long a = 1L;
  protected static boolean m = false;

  protected p()
  {
  }

  protected p(a<?> parama)
  {
  }

  public static <ContainingType extends x, Type> h<ContainingType, Type> a(x paramx1, final int paramInt, Class paramClass, x paramx2)
  {
    return new h(new f()
    {
      public k.f a()
      {
        return (k.f)this.a.J().i().get(paramInt);
      }
    }
    , paramClass, paramx2, null);
  }

  public static <ContainingType extends x, Type> h<ContainingType, Type> a(Class paramClass, x paramx)
  {
    return new h(null, paramClass, paramx, null);
  }

  static void ac()
  {
    m = true;
  }

  private static Object b(Method paramMethod, Object paramObject, Object[] paramArrayOfObject)
  {
    try
    {
      Object localObject = paramMethod.invoke(paramObject, paramArrayOfObject);
      return localObject;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable = localInvocationTargetException.getCause();
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      if ((localThrowable instanceof Error))
        throw ((Error)localThrowable);
      throw new RuntimeException("Unexpected exception thrown by generated accessor method.", localThrowable);
    }
  }

  private static Method b(Class paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      Method localMethod = paramClass.getMethod(paramString, paramArrayOfClass);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new RuntimeException("Generated message class \"" + paramClass.getName() + "\" missing method \"" + paramString + "\".", localNoSuchMethodException);
    }
  }

  private Map<k.f, Object> h()
  {
    TreeMap localTreeMap = new TreeMap();
    Iterator localIterator = g.a(l()).h().iterator();
    while (localIterator.hasNext())
    {
      k.f localf = (k.f)localIterator.next();
      if (localf.n())
      {
        List localList = (List)b(localf);
        if (!localList.isEmpty())
          localTreeMap.put(localf, localList);
      }
      else if (a_(localf))
      {
        localTreeMap.put(localf, b(localf));
      }
    }
    return localTreeMap;
  }

  protected Object I()
    throws ObjectStreamException
  {
    return new q.g(this);
  }

  public k.a J()
  {
    return g.a(l());
  }

  public Object a(k.f paramf, int paramInt)
  {
    return g.a(l(), paramf).a(this, paramInt);
  }

  public boolean a()
  {
    Iterator localIterator1 = J().h().iterator();
    while (true)
      if (localIterator1.hasNext())
      {
        k.f localf = (k.f)localIterator1.next();
        if ((localf.k()) && (!a_(localf)))
          return false;
        if (localf.g() == k.f.a.i)
        {
          if (localf.n())
          {
            Iterator localIterator2 = ((List)b(localf)).iterator();
            if (!localIterator2.hasNext())
              continue;
            if (((x)localIterator2.next()).a())
              break;
            return false;
          }
          if ((a_(localf)) && (!((x)b(localf)).a()))
            return false;
        }
      }
    return true;
  }

  protected boolean a(h paramh, P.a parama, n paramn, int paramInt)
    throws IOException
  {
    return parama.a(paramInt, paramh);
  }

  public Map<k.f, Object> a_()
  {
    return Collections.unmodifiableMap(h());
  }

  public boolean a_(k.f paramf)
  {
    return g.a(l(), paramf).b(this);
  }

  protected void ad()
  {
  }

  protected abstract x.a b(b paramb);

  public Object b(k.f paramf)
  {
    return g.a(l(), paramf).a(this);
  }

  public P b_()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }

  public int c(k.f paramf)
  {
    return g.a(l(), paramf).c(this);
  }

  protected abstract g l();

  public B<? extends x> m()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }

  public static abstract class a<BuilderType extends a> extends a.a<BuilderType>
  {
    private p.b a;
    private a<BuilderType>.a b;
    private boolean c;
    private P d = P.c();

    protected a()
    {
      this(null);
    }

    protected a(p.b paramb)
    {
      this.a = paramb;
    }

    private Map<k.f, Object> k()
    {
      TreeMap localTreeMap = new TreeMap();
      Iterator localIterator = p.g.a(l()).h().iterator();
      while (localIterator.hasNext())
      {
        k.f localf = (k.f)localIterator.next();
        if (localf.n())
        {
          List localList = (List)b(localf);
          if (!localList.isEmpty())
            localTreeMap.put(localf, localList);
        }
        else if (a_(localf))
        {
          localTreeMap.put(localf, b(localf));
        }
      }
      return localTreeMap;
    }

    public k.a J()
    {
      return p.g.a(l());
    }

    public BuilderType a(k.f paramf, int paramInt, Object paramObject)
    {
      p.g.a(l(), paramf).a(this, paramInt, paramObject);
      return this;
    }

    public BuilderType a(k.f paramf, Object paramObject)
    {
      p.g.a(l(), paramf).a(this, paramObject);
      return this;
    }

    public x.a a(k.f paramf)
    {
      return p.g.a(l(), paramf).e(this);
    }

    public Object a(k.f paramf, int paramInt)
    {
      return p.g.a(l(), paramf).a(this, paramInt);
    }

    public boolean a()
    {
      Iterator localIterator1 = J().h().iterator();
      while (true)
        if (localIterator1.hasNext())
        {
          k.f localf = (k.f)localIterator1.next();
          if ((localf.k()) && (!a_(localf)))
            return false;
          if (localf.g() == k.f.a.i)
          {
            if (localf.n())
            {
              Iterator localIterator2 = ((List)b(localf)).iterator();
              if (!localIterator2.hasNext())
                continue;
              if (((x)localIterator2.next()).a())
                break;
              return false;
            }
            if ((a_(localf)) && (!((x)b(localf)).a()))
              return false;
          }
        }
      return true;
    }

    protected boolean a(h paramh, P.a parama, n paramn, int paramInt)
      throws IOException
    {
      return parama.a(paramInt, paramh);
    }

    void aA()
    {
      this.a = null;
    }

    protected void aB()
    {
      if (this.a != null)
        aC();
    }

    protected void aC()
    {
      this.c = true;
    }

    protected boolean aD()
    {
      return this.c;
    }

    protected p.b aE()
    {
      if (this.b == null)
        this.b = new a(null);
      return this.b;
    }

    protected final void aF()
    {
      if ((this.c) && (this.a != null))
      {
        this.a.a();
        this.c = false;
      }
    }

    public Map<k.f, Object> a_()
    {
      return Collections.unmodifiableMap(k());
    }

    public boolean a_(k.f paramf)
    {
      return p.g.a(l(), paramf).b(this);
    }

    public BuilderType ah()
    {
      this.d = P.c();
      aF();
      return this;
    }

    public BuilderType ai()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public BuilderType b(k.f paramf, Object paramObject)
    {
      p.g.a(l(), paramf).b(this, paramObject);
      return this;
    }

    public Object b(k.f paramf)
    {
      Object localObject = p.g.a(l(), paramf).a(this);
      if (paramf.n())
        localObject = Collections.unmodifiableList((List)localObject);
      return localObject;
    }

    public final P b_()
    {
      return this.d;
    }

    public int c(k.f paramf)
    {
      return p.g.a(l(), paramf).c(this);
    }

    public final BuilderType c(P paramP)
    {
      this.d = paramP;
      aF();
      return this;
    }

    public final BuilderType d(P paramP)
    {
      this.d = P.a(this.d).a(paramP).b();
      aF();
      return this;
    }

    public BuilderType d(k.f paramf)
    {
      p.g.a(l(), paramf).d(this);
      return this;
    }

    public x.a g(k.f paramf)
    {
      return p.g.a(l(), paramf).a();
    }

    protected abstract p.g l();

    private class a
      implements p.b
    {
      private a()
      {
      }

      public void a()
      {
        p.a.this.aF();
      }
    }
  }

  protected static abstract interface b
  {
    public abstract void a();
  }

  public static abstract class c<MessageType extends p.d, BuilderType extends c> extends p.a<BuilderType>
    implements p.e<MessageType>
  {
    private o<k.f> a = o.b();

    protected c()
    {
    }

    protected c(p.b paramb)
    {
      super();
    }

    private void e(p.h<MessageType, ?> paramh)
    {
      if (paramh.a().u() != J())
        throw new IllegalArgumentException("Extension is for type \"" + paramh.a().u().d() + "\" which does not match message type \"" + J().d() + "\".");
    }

    private void h(k.f paramf)
    {
      if (paramf.u() != J())
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void k()
    {
      if (this.a.d())
        this.a = this.a.e();
    }

    private o<k.f> m()
    {
      this.a.c();
      return this.a;
    }

    public BuilderType A()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public BuilderType B()
    {
      this.a = o.b();
      return (c)super.ah();
    }

    public final <Type> BuilderType a(p.h<MessageType, List<Type>> paramh, int paramInt, Type paramType)
    {
      e(paramh);
      k();
      k.f localf = paramh.a();
      this.a.a(localf, paramInt, p.h.d(paramh, paramType));
      aF();
      return this;
    }

    public final <Type> BuilderType a(p.h<MessageType, Type> paramh, Type paramType)
    {
      e(paramh);
      k();
      k.f localf = paramh.a();
      this.a.a(localf, p.h.c(paramh, paramType));
      aF();
      return this;
    }

    public Object a(k.f paramf, int paramInt)
    {
      if (paramf.t())
      {
        h(paramf);
        return this.a.a(paramf, paramInt);
      }
      return super.a(paramf, paramInt);
    }

    public final <Type> Type a(p.h<MessageType, List<Type>> paramh, int paramInt)
    {
      e(paramh);
      k.f localf = paramh.a();
      return p.h.b(paramh, this.a.a(localf, paramInt));
    }

    protected final void a(p.d paramd)
    {
      k();
      this.a.a(p.d.a(paramd));
      aF();
    }

    public boolean a()
    {
      return (super.a()) && (af());
    }

    protected boolean a(h paramh, P.a parama, n paramn, int paramInt)
      throws IOException
    {
      return a.a.a(paramh, parama, paramn, J(), this, null, paramInt);
    }

    public final <Type> boolean a(p.h<MessageType, Type> paramh)
    {
      e(paramh);
      return this.a.a(paramh.a());
    }

    public Map<k.f, Object> a_()
    {
      Map localMap = p.a.a(this);
      localMap.putAll(this.a.g());
      return Collections.unmodifiableMap(localMap);
    }

    public boolean a_(k.f paramf)
    {
      if (paramf.t())
      {
        h(paramf);
        return this.a.a(paramf);
      }
      return super.a_(paramf);
    }

    protected boolean af()
    {
      return this.a.i();
    }

    public final <Type> int b(p.h<MessageType, List<Type>> paramh)
    {
      e(paramh);
      k.f localf = paramh.a();
      return this.a.d(localf);
    }

    public final <Type> BuilderType b(p.h<MessageType, List<Type>> paramh, Type paramType)
    {
      e(paramh);
      k();
      k.f localf = paramh.a();
      this.a.b(localf, p.h.d(paramh, paramType));
      aF();
      return this;
    }

    public Object b(k.f paramf)
    {
      if (paramf.t())
      {
        h(paramf);
        Object localObject = this.a.b(paramf);
        if (localObject == null)
        {
          if (paramf.g() == k.f.a.i)
            localObject = l.a(paramf.w());
        }
        else
          return localObject;
        return paramf.r();
      }
      return super.b(paramf);
    }

    public int c(k.f paramf)
    {
      if (paramf.t())
      {
        h(paramf);
        return this.a.d(paramf);
      }
      return super.c(paramf);
    }

    public BuilderType c(k.f paramf, int paramInt, Object paramObject)
    {
      if (paramf.t())
      {
        h(paramf);
        k();
        this.a.a(paramf, paramInt, paramObject);
        aF();
        return this;
      }
      return (c)super.a(paramf, paramInt, paramObject);
    }

    public final <Type> Type c(p.h<MessageType, Type> paramh)
    {
      e(paramh);
      k.f localf = paramh.a();
      Object localObject = this.a.b(localf);
      if (localObject == null)
      {
        if (localf.n())
          return Collections.emptyList();
        if (localf.g() == k.f.a.i)
          return paramh.b();
        return p.h.a(paramh, localf.r());
      }
      return p.h.a(paramh, localObject);
    }

    public final <Type> BuilderType d(p.h<MessageType, ?> paramh)
    {
      e(paramh);
      k();
      this.a.c(paramh.a());
      aF();
      return this;
    }

    public BuilderType e(k.f paramf)
    {
      if (paramf.t())
      {
        h(paramf);
        k();
        this.a.c(paramf);
        aF();
        return this;
      }
      return (c)super.d(paramf);
    }

    public BuilderType e(k.f paramf, Object paramObject)
    {
      if (paramf.t())
      {
        h(paramf);
        k();
        this.a.a(paramf, paramObject);
        aF();
        return this;
      }
      return (c)super.a(paramf, paramObject);
    }

    public BuilderType f(k.f paramf, Object paramObject)
    {
      if (paramf.t())
      {
        h(paramf);
        k();
        this.a.b(paramf, paramObject);
        aF();
        return this;
      }
      return (c)super.b(paramf, paramObject);
    }
  }

  public static abstract class d<MessageType extends d> extends p
    implements p.e<MessageType>
  {
    private final o<k.f> a;

    protected d()
    {
      this.a = o.a();
    }

    protected d(p.c<MessageType, ?> paramc)
    {
      super();
      this.a = p.c.a(paramc);
    }

    private void d(k.f paramf)
    {
      if (paramf.u() != J())
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    private void d(p.h<MessageType, ?> paramh)
    {
      if (paramh.a().u() != J())
        throw new IllegalArgumentException("Extension is for type \"" + paramh.a().u().d() + "\" which does not match message type \"" + J().d() + "\".");
    }

    protected boolean W()
    {
      return this.a.i();
    }

    protected d<MessageType>.a X()
    {
      return new a(false, null);
    }

    protected d<MessageType>.a Y()
    {
      return new a(true, null);
    }

    protected int Z()
    {
      return this.a.j();
    }

    public Object a(k.f paramf, int paramInt)
    {
      if (paramf.t())
      {
        d(paramf);
        return this.a.a(paramf, paramInt);
      }
      return super.a(paramf, paramInt);
    }

    public final <Type> Type a(p.h<MessageType, List<Type>> paramh, int paramInt)
    {
      d(paramh);
      k.f localf = paramh.a();
      return p.h.b(paramh, this.a.a(localf, paramInt));
    }

    public boolean a()
    {
      return (super.a()) && (W());
    }

    protected boolean a(h paramh, P.a parama, n paramn, int paramInt)
      throws IOException
    {
      return a.a.a(paramh, parama, paramn, J(), null, this.a, paramInt);
    }

    public final <Type> boolean a(p.h<MessageType, Type> paramh)
    {
      d(paramh);
      return this.a.a(paramh.a());
    }

    public Map<k.f, Object> a_()
    {
      Map localMap = p.a(this);
      localMap.putAll(ab());
      return Collections.unmodifiableMap(localMap);
    }

    public boolean a_(k.f paramf)
    {
      if (paramf.t())
      {
        d(paramf);
        return this.a.a(paramf);
      }
      return super.a_(paramf);
    }

    protected int aa()
    {
      return this.a.k();
    }

    protected Map<k.f, Object> ab()
    {
      return this.a.g();
    }

    protected void ad()
    {
      this.a.c();
    }

    public final <Type> int b(p.h<MessageType, List<Type>> paramh)
    {
      d(paramh);
      k.f localf = paramh.a();
      return this.a.d(localf);
    }

    public Object b(k.f paramf)
    {
      if (paramf.t())
      {
        d(paramf);
        Object localObject = this.a.b(paramf);
        if (localObject == null)
        {
          if (paramf.g() == k.f.a.i)
            localObject = l.a(paramf.w());
        }
        else
          return localObject;
        return paramf.r();
      }
      return super.b(paramf);
    }

    public int c(k.f paramf)
    {
      if (paramf.t())
      {
        d(paramf);
        return this.a.d(paramf);
      }
      return super.c(paramf);
    }

    public final <Type> Type c(p.h<MessageType, Type> paramh)
    {
      d(paramh);
      k.f localf = paramh.a();
      Object localObject = this.a.b(localf);
      if (localObject == null)
      {
        if (localf.n())
          return Collections.emptyList();
        if (localf.g() == k.f.a.i)
          return paramh.b();
        return p.h.a(paramh, localf.r());
      }
      return p.h.a(paramh, localObject);
    }

    protected class a
    {
      private final Iterator<Map.Entry<k.f, Object>> b = p.d.a(p.d.this).h();
      private Map.Entry<k.f, Object> c;
      private final boolean d;

      private a(boolean arg2)
      {
        if (this.b.hasNext())
          this.c = ((Map.Entry)this.b.next());
        boolean bool;
        this.d = bool;
      }

      public void a(int paramInt, i parami)
        throws IOException
      {
        while ((this.c != null) && (((k.f)this.c.getKey()).f() < paramInt))
        {
          k.f localf = (k.f)this.c.getKey();
          if ((this.d) && (localf.h() == S.b.i) && (!localf.n()))
            if ((this.c instanceof t.a))
              parami.b(localf.f(), ((t.a)this.c).a().c());
          while (true)
          {
            if (!this.b.hasNext())
              break label165;
            this.c = ((Map.Entry)this.b.next());
            break;
            parami.d(localf.f(), (x)this.c.getValue());
            continue;
            o.a(localf, this.c.getValue(), parami);
          }
          label165: this.c = null;
        }
      }
    }
  }

  public static abstract interface e<MessageType extends p.d> extends A
  {
    public abstract <Type> Type a(p.h<MessageType, List<Type>> paramh, int paramInt);

    public abstract <Type> boolean a(p.h<MessageType, Type> paramh);

    public abstract <Type> int b(p.h<MessageType, List<Type>> paramh);

    public abstract <Type> Type c(p.h<MessageType, Type> paramh);
  }

  private static abstract interface f
  {
    public abstract k.f a();
  }

  public static final class g
  {
    private final k.a a;
    private final a[] b;
    private String[] c;
    private volatile boolean d;

    public g(k.a parama, String[] paramArrayOfString)
    {
      this.a = parama;
      this.c = paramArrayOfString;
      this.b = new a[parama.h().size()];
      this.d = false;
    }

    public g(k.a parama, String[] paramArrayOfString, Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
    {
      this(parama, paramArrayOfString);
      a(paramClass, paramClass1);
    }

    private a a(k.f paramf)
    {
      if (paramf.u() != this.a)
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
      if (paramf.t())
        throw new IllegalArgumentException("This type does not have extensions.");
      return this.b[paramf.a()];
    }

    public g a(Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
    {
      if (this.d)
        return this;
      try
      {
        if (this.d)
          return this;
      }
      finally
      {
      }
      for (int i = 0; ; i++)
        if (i < this.b.length)
        {
          k.f localf = (k.f)this.a.h().get(i);
          if (localf.n())
          {
            if (localf.g() == k.f.a.i)
              this.b[i] = new d(localf, this.c[i], paramClass, paramClass1);
            else if (localf.g() == k.f.a.h)
              this.b[i] = new b(localf, this.c[i], paramClass, paramClass1);
            else
              this.b[i] = new c(localf, this.c[i], paramClass, paramClass1);
          }
          else if (localf.g() == k.f.a.i)
            this.b[i] = new g(localf, this.c[i], paramClass, paramClass1);
          else if (localf.g() == k.f.a.h)
            this.b[i] = new e(localf, this.c[i], paramClass, paramClass1);
          else
            this.b[i] = new f(localf, this.c[i], paramClass, paramClass1);
        }
        else
        {
          this.d = true;
          this.c = null;
          return this;
        }
    }

    private static abstract interface a
    {
      public abstract x.a a();

      public abstract Object a(p.a parama);

      public abstract Object a(p.a parama, int paramInt);

      public abstract Object a(p paramp);

      public abstract Object a(p paramp, int paramInt);

      public abstract void a(p.a parama, int paramInt, Object paramObject);

      public abstract void a(p.a parama, Object paramObject);

      public abstract void b(p.a parama, Object paramObject);

      public abstract boolean b(p.a parama);

      public abstract boolean b(p paramp);

      public abstract int c(p.a parama);

      public abstract int c(p paramp);

      public abstract void d(p.a parama);

      public abstract x.a e(p.a parama);
    }

    private static final class b extends p.g.c
    {
      private final Method k = p.a(this.a, "valueOf", new Class[] { k.e.class });
      private final Method l = p.a(this.a, "getValueDescriptor", new Class[0]);

      b(k.f paramf, String paramString, Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
      }

      public Object a(p.a parama)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)super.a(parama)).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          localArrayList.add(p.a(this.l, localObject, new Object[0]));
        }
        return Collections.unmodifiableList(localArrayList);
      }

      public Object a(p.a parama, int paramInt)
      {
        return p.a(this.l, super.a(parama, paramInt), new Object[0]);
      }

      public Object a(p paramp)
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = ((List)super.a(paramp)).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = localIterator.next();
          localArrayList.add(p.a(this.l, localObject, new Object[0]));
        }
        return Collections.unmodifiableList(localArrayList);
      }

      public Object a(p paramp, int paramInt)
      {
        return p.a(this.l, super.a(paramp, paramInt), new Object[0]);
      }

      public void a(p.a parama, int paramInt, Object paramObject)
      {
        super.a(parama, paramInt, p.a(this.k, null, new Object[] { paramObject }));
      }

      public void b(p.a parama, Object paramObject)
      {
        super.b(parama, p.a(this.k, null, new Object[] { paramObject }));
      }
    }

    private static class c
      implements p.g.a
    {
      protected final Class a;
      protected final Method b;
      protected final Method c;
      protected final Method d;
      protected final Method e;
      protected final Method f;
      protected final Method g;
      protected final Method h;
      protected final Method i;
      protected final Method j;

      c(k.f paramf, String paramString, Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
      {
        this.b = p.a(paramClass, "get" + paramString + "List", new Class[0]);
        this.c = p.a(paramClass1, "get" + paramString + "List", new Class[0]);
        String str1 = "get" + paramString;
        Class[] arrayOfClass1 = new Class[1];
        arrayOfClass1[0] = Integer.TYPE;
        this.d = p.a(paramClass, str1, arrayOfClass1);
        String str2 = "get" + paramString;
        Class[] arrayOfClass2 = new Class[1];
        arrayOfClass2[0] = Integer.TYPE;
        this.e = p.a(paramClass1, str2, arrayOfClass2);
        this.a = this.d.getReturnType();
        String str3 = "set" + paramString;
        Class[] arrayOfClass3 = new Class[2];
        arrayOfClass3[0] = Integer.TYPE;
        arrayOfClass3[1] = this.a;
        this.f = p.a(paramClass1, str3, arrayOfClass3);
        String str4 = "add" + paramString;
        Class[] arrayOfClass4 = new Class[1];
        arrayOfClass4[0] = this.a;
        this.g = p.a(paramClass1, str4, arrayOfClass4);
        this.h = p.a(paramClass, "get" + paramString + "Count", new Class[0]);
        this.i = p.a(paramClass1, "get" + paramString + "Count", new Class[0]);
        this.j = p.a(paramClass1, "clear" + paramString, new Class[0]);
      }

      public x.a a()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }

      public Object a(p.a parama)
      {
        return p.a(this.c, parama, new Object[0]);
      }

      public Object a(p.a parama, int paramInt)
      {
        Method localMethod = this.e;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        return p.a(localMethod, parama, arrayOfObject);
      }

      public Object a(p paramp)
      {
        return p.a(this.b, paramp, new Object[0]);
      }

      public Object a(p paramp, int paramInt)
      {
        Method localMethod = this.d;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        return p.a(localMethod, paramp, arrayOfObject);
      }

      public void a(p.a parama, int paramInt, Object paramObject)
      {
        Method localMethod = this.f;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramInt);
        arrayOfObject[1] = paramObject;
        p.a(localMethod, parama, arrayOfObject);
      }

      public void a(p.a parama, Object paramObject)
      {
        d(parama);
        Iterator localIterator = ((List)paramObject).iterator();
        while (localIterator.hasNext())
          b(parama, localIterator.next());
      }

      public void b(p.a parama, Object paramObject)
      {
        p.a(this.g, parama, new Object[] { paramObject });
      }

      public boolean b(p.a parama)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }

      public boolean b(p paramp)
      {
        throw new UnsupportedOperationException("hasField() called on a repeated field.");
      }

      public int c(p.a parama)
      {
        return ((Integer)p.a(this.i, parama, new Object[0])).intValue();
      }

      public int c(p paramp)
      {
        return ((Integer)p.a(this.h, paramp, new Object[0])).intValue();
      }

      public void d(p.a parama)
      {
        p.a(this.j, parama, new Object[0]);
      }

      public x.a e(p.a parama)
      {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
    }

    private static final class d extends p.g.c
    {
      private final Method k = p.a(this.a, "newBuilder", new Class[0]);

      d(k.f paramf, String paramString, Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
      }

      private Object a(Object paramObject)
      {
        if (this.a.isInstance(paramObject))
          return paramObject;
        return ((x.a)p.a(this.k, null, new Object[0])).c((x)paramObject).ak();
      }

      public x.a a()
      {
        return (x.a)p.a(this.k, null, new Object[0]);
      }

      public void a(p.a parama, int paramInt, Object paramObject)
      {
        super.a(parama, paramInt, a(paramObject));
      }

      public void b(p.a parama, Object paramObject)
      {
        super.b(parama, a(paramObject));
      }
    }

    private static final class e extends p.g.f
    {
      private Method h = p.a(this.a, "valueOf", new Class[] { k.e.class });
      private Method i = p.a(this.a, "getValueDescriptor", new Class[0]);

      e(k.f paramf, String paramString, Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
      }

      public Object a(p.a parama)
      {
        return p.a(this.i, super.a(parama), new Object[0]);
      }

      public Object a(p paramp)
      {
        return p.a(this.i, super.a(paramp), new Object[0]);
      }

      public void a(p.a parama, Object paramObject)
      {
        super.a(parama, p.a(this.h, null, new Object[] { paramObject }));
      }
    }

    private static class f
      implements p.g.a
    {
      protected final Class<?> a;
      protected final Method b;
      protected final Method c;
      protected final Method d;
      protected final Method e;
      protected final Method f;
      protected final Method g;

      f(k.f paramf, String paramString, Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
      {
        this.b = p.a(paramClass, "get" + paramString, new Class[0]);
        this.c = p.a(paramClass1, "get" + paramString, new Class[0]);
        this.a = this.b.getReturnType();
        String str = "set" + paramString;
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = this.a;
        this.d = p.a(paramClass1, str, arrayOfClass);
        this.e = p.a(paramClass, "has" + paramString, new Class[0]);
        this.f = p.a(paramClass1, "has" + paramString, new Class[0]);
        this.g = p.a(paramClass1, "clear" + paramString, new Class[0]);
      }

      public x.a a()
      {
        throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
      }

      public Object a(p.a parama)
      {
        return p.a(this.c, parama, new Object[0]);
      }

      public Object a(p.a parama, int paramInt)
      {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }

      public Object a(p paramp)
      {
        return p.a(this.b, paramp, new Object[0]);
      }

      public Object a(p paramp, int paramInt)
      {
        throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
      }

      public void a(p.a parama, int paramInt, Object paramObject)
      {
        throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
      }

      public void a(p.a parama, Object paramObject)
      {
        p.a(this.d, parama, new Object[] { paramObject });
      }

      public void b(p.a parama, Object paramObject)
      {
        throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
      }

      public boolean b(p.a parama)
      {
        return ((Boolean)p.a(this.f, parama, new Object[0])).booleanValue();
      }

      public boolean b(p paramp)
      {
        return ((Boolean)p.a(this.e, paramp, new Object[0])).booleanValue();
      }

      public int c(p.a parama)
      {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }

      public int c(p paramp)
      {
        throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
      }

      public void d(p.a parama)
      {
        p.a(this.g, parama, new Object[0]);
      }

      public x.a e(p.a parama)
      {
        throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
      }
    }

    private static final class g extends p.g.f
    {
      private final Method h = p.a(this.a, "newBuilder", new Class[0]);
      private final Method i;

      g(k.f paramf, String paramString, Class<? extends p> paramClass, Class<? extends p.a> paramClass1)
      {
        super(paramString, paramClass, paramClass1);
        this.i = p.a(paramClass1, "get" + paramString + "Builder", new Class[0]);
      }

      private Object a(Object paramObject)
      {
        if (this.a.isInstance(paramObject))
          return paramObject;
        return ((x.a)p.a(this.h, null, new Object[0])).c((x)paramObject).aj();
      }

      public x.a a()
      {
        return (x.a)p.a(this.h, null, new Object[0]);
      }

      public void a(p.a parama, Object paramObject)
      {
        super.a(parama, a(paramObject));
      }

      public x.a e(p.a parama)
      {
        return (x.a)p.a(this.i, parama, new Object[0]);
      }
    }
  }

  public static final class h<ContainingType extends x, Type>
  {
    private p.f a;
    private final Class b;
    private final x c;
    private final Method d;
    private final Method e;

    private h(p.f paramf, Class paramClass, x paramx)
    {
      if ((x.class.isAssignableFrom(paramClass)) && (!paramClass.isInstance(paramx)))
        throw new IllegalArgumentException("Bad messageDefaultInstance for " + paramClass.getName());
      this.a = paramf;
      this.b = paramClass;
      this.c = paramx;
      if (C.class.isAssignableFrom(paramClass))
      {
        this.d = p.a(paramClass, "valueOf", new Class[] { k.e.class });
        this.e = p.a(paramClass, "getValueDescriptor", new Class[0]);
        return;
      }
      this.d = null;
      this.e = null;
    }

    private Object a(Object paramObject)
    {
      k.f localf = a();
      if (localf.n())
      {
        if ((localf.g() == k.f.a.i) || (localf.g() == k.f.a.h))
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((List)paramObject).iterator();
          while (localIterator.hasNext())
            localArrayList.add(b(localIterator.next()));
          paramObject = localArrayList;
        }
        return paramObject;
      }
      return b(paramObject);
    }

    private Object b(Object paramObject)
    {
      k.f localf = a();
      switch (p.2.a[localf.g().ordinal()])
      {
      default:
      case 1:
        do
          return paramObject;
        while (this.b.isInstance(paramObject));
        return this.c.N().c((x)paramObject).ak();
      case 2:
      }
      Method localMethod = this.d;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ((k.e)paramObject);
      return p.a(localMethod, null, arrayOfObject);
    }

    private Object c(Object paramObject)
    {
      k.f localf = a();
      if (localf.n())
      {
        if (localf.g() == k.f.a.h)
        {
          ArrayList localArrayList = new ArrayList();
          Iterator localIterator = ((List)paramObject).iterator();
          while (localIterator.hasNext())
            localArrayList.add(d(localIterator.next()));
          paramObject = localArrayList;
        }
        return paramObject;
      }
      return d(paramObject);
    }

    private Object d(Object paramObject)
    {
      k.f localf = a();
      switch (p.2.a[localf.g().ordinal()])
      {
      default:
        return paramObject;
      case 2:
      }
      return p.a(this.e, paramObject, new Object[0]);
    }

    public k.f a()
    {
      if (this.a == null)
        throw new IllegalStateException("getDescriptor() called before internalInit()");
      return this.a.a();
    }

    public void a(final k.f paramf)
    {
      if (this.a != null)
        throw new IllegalStateException("Already initialized.");
      this.a = new p.f()
      {
        public k.f a()
        {
          return paramf;
        }
      };
    }

    public x b()
    {
      return this.c;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.p
 * JD-Core Version:    0.6.2
 */