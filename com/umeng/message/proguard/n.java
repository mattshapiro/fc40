package com.umeng.message.proguard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class n
{
  private static volatile boolean a = false;
  private static final n c = new n(true);
  private final Map<a, q.f<?, ?>> b;

  n()
  {
    this.b = new HashMap();
  }

  n(n paramn)
  {
    if (paramn == c)
    {
      this.b = Collections.emptyMap();
      return;
    }
    this.b = Collections.unmodifiableMap(paramn.b);
  }

  private n(boolean paramBoolean)
  {
    this.b = Collections.emptyMap();
  }

  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }

  public static boolean e()
  {
    return a;
  }

  public static n f()
  {
    return new n();
  }

  public static n g()
  {
    return c;
  }

  public <ContainingType extends y> q.f<ContainingType, ?> a(ContainingType paramContainingType, int paramInt)
  {
    return (q.f)this.b.get(new a(paramContainingType, paramInt));
  }

  public final void a(q.f<?, ?> paramf)
  {
    this.b.put(new a(paramf.a(), paramf.b()), paramf);
  }

  public n d()
  {
    return new n(this);
  }

  private static final class a
  {
    private final Object a;
    private final int b;

    a(Object paramObject, int paramInt)
    {
      this.a = paramObject;
      this.b = paramInt;
    }

    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a));
      a locala;
      do
      {
        return false;
        locala = (a)paramObject;
      }
      while ((this.a != locala.a) || (this.b != locala.b));
      return true;
    }

    public int hashCode()
    {
      return 65535 * System.identityHashCode(this.a) + this.b;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.n
 * JD-Core Version:    0.6.2
 */