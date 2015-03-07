package com.umeng.message.proguard;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public abstract class q extends b
  implements Serializable
{
  private static final long a = 1L;

  protected q()
  {
  }

  protected q(a parama)
  {
  }

  public static <ContainingType extends y, Type> f<ContainingType, Type> a(ContainingType paramContainingType, y paramy, r.b<?> paramb, int paramInt, S.a parama, boolean paramBoolean)
  {
    List localList = Collections.emptyList();
    f localf = new f(paramContainingType, localList, paramy, new e(paramb, paramInt, parama, true, paramBoolean, null), null);
    return localf;
  }

  public static <ContainingType extends y, Type> f<ContainingType, Type> a(ContainingType paramContainingType, Type paramType, y paramy, r.b<?> paramb, int paramInt, S.a parama)
  {
    f localf = new f(paramContainingType, paramType, paramy, new e(paramb, paramInt, parama, false, false, null), null);
    return localf;
  }

  private static <MessageType extends y> boolean b(o<e> paramo, MessageType paramMessageType, h paramh, n paramn, int paramInt)
    throws IOException
  {
    int i = 0;
    int j = S.a(paramInt);
    f localf = paramn.a(paramMessageType, S.b(paramInt));
    int k;
    if (localf == null)
      k = 1;
    while (k != 0)
    {
      return paramh.b(paramInt);
      if (j == o.a(f.a(localf).j(), false))
      {
        i = 0;
        k = 0;
      }
      else if ((e.b(f.a(localf))) && (e.c(f.a(localf)).c()) && (j == o.a(f.a(localf).j(), true)))
      {
        i = 1;
        k = 0;
      }
      else
      {
        k = 1;
        i = 0;
      }
    }
    if (i != 0)
    {
      int n = paramh.f(paramh.s());
      if (f.a(localf).j() == S.a.n)
        while (paramh.x() > 0)
        {
          int i1 = paramh.n();
          r.a locala1 = f.a(localf).y().b(i1);
          if (locala1 == null)
            return true;
          paramo.b(f.a(localf), locala1);
        }
      while (paramh.x() > 0)
      {
        Object localObject2 = o.a(paramh, f.a(localf).j());
        paramo.b(f.a(localf), localObject2);
      }
      paramh.g(n);
    }
    Object localObject1;
    while (true)
    {
      return true;
      switch (1.a[f.a(localf).h().ordinal()])
      {
      default:
        localObject1 = o.a(paramh, f.a(localf).j());
        label302: if (!f.a(localf).n())
          break label461;
        paramo.b(f.a(localf), localObject1);
      case 1:
      case 2:
      }
    }
    y localy;
    if (!f.a(localf).n())
    {
      localy = (y)paramo.b(f.a(localf));
      if (localy == null);
    }
    for (y.a locala = localy.O(); ; locala = null)
    {
      if (locala == null)
        locala = f.c(localf).P();
      if (f.a(localf).j() == S.a.j)
        paramh.a(localf.b(), locala, paramn);
      while (true)
      {
        localObject1 = locala.am();
        break;
        paramh.a(locala, paramn);
      }
      int m = paramh.n();
      localObject1 = f.a(localf).y().b(m);
      if (localObject1 != null)
        break label302;
      return true;
      label461: paramo.a(f.a(localf), localObject1);
      break;
    }
  }

  protected boolean a(h paramh, n paramn, int paramInt)
    throws IOException
  {
    return paramh.b(paramInt);
  }

  protected void b()
  {
  }

  protected Object c()
    throws ObjectStreamException
  {
    return new g(this);
  }

  public B<? extends y> m()
  {
    throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
  }

  public static abstract class a<MessageType extends q, BuilderType extends a> extends b.a<BuilderType>
  {
    public abstract BuilderType a(MessageType paramMessageType);

    protected boolean a(h paramh, n paramn, int paramInt)
      throws IOException
    {
      return paramh.b(paramInt);
    }

    public BuilderType b()
    {
      return this;
    }

    public BuilderType c()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public abstract MessageType d();
  }

  public static abstract class b<MessageType extends q.c<MessageType>, BuilderType extends b<MessageType, BuilderType>> extends q.a<MessageType, BuilderType>
    implements q.d<MessageType>
  {
    private o<q.e> a = o.b();
    private boolean b;

    private void e(q.f<MessageType, ?> paramf)
    {
      if (paramf.a() != d())
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }

    private void k()
    {
      if (!this.b)
      {
        this.a = this.a.e();
        this.b = true;
      }
    }

    private o<q.e> l()
    {
      this.a.c();
      this.b = false;
      return this.a;
    }

    public final <Type> BuilderType a(q.f<MessageType, List<Type>> paramf, int paramInt, Type paramType)
    {
      e(paramf);
      k();
      this.a.a(q.f.a(paramf), paramInt, paramType);
      return this;
    }

    public final <Type> BuilderType a(q.f<MessageType, Type> paramf, Type paramType)
    {
      e(paramf);
      k();
      this.a.a(q.f.a(paramf), paramType);
      return this;
    }

    public final <Type> Type a(q.f<MessageType, List<Type>> paramf, int paramInt)
    {
      e(paramf);
      return this.a.a(q.f.a(paramf), paramInt);
    }

    protected final void a(MessageType paramMessageType)
    {
      k();
      this.a.a(q.c.a(paramMessageType));
    }

    protected boolean a(h paramh, n paramn, int paramInt)
      throws IOException
    {
      k();
      return q.a(this.a, d(), paramh, paramn, paramInt);
    }

    public final <Type> boolean a(q.f<MessageType, Type> paramf)
    {
      e(paramf);
      return this.a.a(q.f.a(paramf));
    }

    public final <Type> int b(q.f<MessageType, List<Type>> paramf)
    {
      e(paramf);
      return this.a.d(q.f.a(paramf));
    }

    public final <Type> BuilderType b(q.f<MessageType, List<Type>> paramf, Type paramType)
    {
      e(paramf);
      k();
      this.a.b(q.f.a(paramf), paramType);
      return this;
    }

    public final <Type> Type c(q.f<MessageType, Type> paramf)
    {
      e(paramf);
      Object localObject = this.a.b(q.f.a(paramf));
      if (localObject == null)
        localObject = q.f.b(paramf);
      return localObject;
    }

    public final <Type> BuilderType d(q.f<MessageType, ?> paramf)
    {
      e(paramf);
      k();
      this.a.c(q.f.a(paramf));
      return this;
    }

    public BuilderType e()
    {
      this.a.f();
      this.b = false;
      return (b)super.b();
    }

    public BuilderType i()
    {
      throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean j()
    {
      return this.a.i();
    }
  }

  public static abstract class c<MessageType extends c<MessageType>> extends q
    implements q.d<MessageType>
  {
    private final o<q.e> a;

    protected c()
    {
      this.a = o.a();
    }

    protected c(q.b<MessageType, ?> paramb)
    {
      this.a = q.b.a(paramb);
    }

    private void d(q.f<MessageType, ?> paramf)
    {
      if (paramf.a() != Q())
        throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
    }

    public final <Type> Type a(q.f<MessageType, List<Type>> paramf, int paramInt)
    {
      d(paramf);
      return this.a.a(q.f.a(paramf), paramInt);
    }

    protected boolean a(h paramh, n paramn, int paramInt)
      throws IOException
    {
      return q.a(this.a, Q(), paramh, paramn, paramInt);
    }

    public final <Type> boolean a(q.f<MessageType, Type> paramf)
    {
      d(paramf);
      return this.a.a(q.f.a(paramf));
    }

    public final <Type> int b(q.f<MessageType, List<Type>> paramf)
    {
      d(paramf);
      return this.a.d(q.f.a(paramf));
    }

    protected void b()
    {
      this.a.c();
    }

    public final <Type> Type c(q.f<MessageType, Type> paramf)
    {
      d(paramf);
      Object localObject = this.a.b(q.f.a(paramf));
      if (localObject == null)
        localObject = q.f.b(paramf);
      return localObject;
    }

    protected boolean h()
    {
      return this.a.i();
    }

    protected c<MessageType>.a i()
    {
      return new a(false, null);
    }

    protected c<MessageType>.a j()
    {
      return new a(true, null);
    }

    protected int k()
    {
      return this.a.j();
    }

    protected int l()
    {
      return this.a.k();
    }

    protected class a
    {
      private final Iterator<Map.Entry<q.e, Object>> b = q.c.a(q.c.this).h();
      private Map.Entry<q.e, Object> c;
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
        while ((this.c != null) && (((q.e)this.c.getKey()).f() < paramInt))
        {
          q.e locale = (q.e)this.c.getKey();
          if ((this.d) && (locale.h() == S.b.i) && (!locale.n()))
            parami.d(locale.f(), (y)this.c.getValue());
          while (true)
          {
            if (!this.b.hasNext())
              break label131;
            this.c = ((Map.Entry)this.b.next());
            break;
            o.a(locale, this.c.getValue(), parami);
          }
          label131: this.c = null;
        }
      }
    }
  }

  public static abstract interface d<MessageType extends q.c> extends z
  {
    public abstract <Type> Type a(q.f<MessageType, List<Type>> paramf, int paramInt);

    public abstract <Type> boolean a(q.f<MessageType, Type> paramf);

    public abstract <Type> int b(q.f<MessageType, List<Type>> paramf);

    public abstract <Type> Type c(q.f<MessageType, Type> paramf);
  }

  private static final class e
    implements o.a<e>
  {
    private final r.b<?> a;
    private final int b;
    private final S.a c;
    private final boolean d;
    private final boolean e;

    private e(r.b<?> paramb, int paramInt, S.a parama, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramb;
      this.b = paramInt;
      this.c = parama;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
    }

    public int a(e parame)
    {
      return this.b - parame.b;
    }

    public y.a a(y.a parama, y paramy)
    {
      return ((q.a)parama).a((q)paramy);
    }

    public int f()
    {
      return this.b;
    }

    public S.b h()
    {
      return this.c.a();
    }

    public S.a j()
    {
      return this.c;
    }

    public boolean n()
    {
      return this.d;
    }

    public boolean o()
    {
      return this.e;
    }

    public r.b<?> y()
    {
      return this.a;
    }
  }

  public static final class f<ContainingType extends y, Type>
  {
    private final ContainingType a;
    private final Type b;
    private final y c;
    private final q.e d;

    private f(ContainingType paramContainingType, Type paramType, y paramy, q.e parame)
    {
      if (paramContainingType == null)
        throw new IllegalArgumentException("Null containingTypeDefaultInstance");
      if ((parame.j() == S.a.k) && (paramy == null))
        throw new IllegalArgumentException("Null messageDefaultInstance");
      this.a = paramContainingType;
      this.b = paramType;
      this.c = paramy;
      this.d = parame;
    }

    public ContainingType a()
    {
      return this.a;
    }

    public int b()
    {
      return this.d.f();
    }

    public y c()
    {
      return this.c;
    }
  }

  static final class g
    implements Serializable
  {
    private static final long a;
    private String b;
    private byte[] c;

    g(y paramy)
    {
      this.b = paramy.getClass().getName();
      this.c = paramy.g();
    }

    protected Object a()
      throws ObjectStreamException
    {
      try
      {
        y.a locala = (y.a)Class.forName(this.b).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
        locala.c(this.c);
        y localy = locala.al();
        return localy;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new RuntimeException("Unable to find proto buffer class", localClassNotFoundException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        throw new RuntimeException("Unable to find newBuilder method", localNoSuchMethodException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Unable to call newBuilder method", localIllegalAccessException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Error calling newBuilder", localInvocationTargetException.getCause());
      }
      catch (s locals)
      {
        throw new RuntimeException("Unable to understand proto buffer", locals);
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.q
 * JD-Core Version:    0.6.2
 */