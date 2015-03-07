package com.umeng.message.proguard;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

class t
{
  private final y a;
  private final n b;
  private g c;
  private volatile y d;
  private volatile boolean e = false;

  public t(y paramy, n paramn, g paramg)
  {
    this.a = paramy;
    this.b = paramn;
    this.c = paramg;
  }

  private void d()
  {
    if (this.d != null)
      return;
    try
    {
      if (this.d != null)
        return;
    }
    finally
    {
    }
    try
    {
      if (this.c != null)
        this.d = ((y)this.a.m().d(this.c, this.b));
      label61: return;
    }
    catch (IOException localIOException)
    {
      break label61;
    }
  }

  public y a()
  {
    d();
    return this.d;
  }

  public y a(y paramy)
  {
    y localy = this.d;
    this.d = paramy;
    this.c = null;
    this.e = true;
    return localy;
  }

  public int b()
  {
    if (this.e)
      return this.d.d();
    return this.c.a();
  }

  public g c()
  {
    if (!this.e)
      return this.c;
    try
    {
      if (!this.e)
      {
        g localg2 = this.c;
        return localg2;
      }
    }
    finally
    {
    }
    this.c = this.d.f();
    this.e = false;
    g localg1 = this.c;
    return localg1;
  }

  public boolean equals(Object paramObject)
  {
    d();
    return this.d.equals(paramObject);
  }

  public int hashCode()
  {
    d();
    return this.d.hashCode();
  }

  public String toString()
  {
    d();
    return this.d.toString();
  }

  static class a<K>
    implements Map.Entry<K, Object>
  {
    private Map.Entry<K, t> a;

    private a(Map.Entry<K, t> paramEntry)
    {
      this.a = paramEntry;
    }

    public t a()
    {
      return (t)this.a.getValue();
    }

    public K getKey()
    {
      return this.a.getKey();
    }

    public Object getValue()
    {
      t localt = (t)this.a.getValue();
      if (localt == null)
        return null;
      return localt.a();
    }

    public Object setValue(Object paramObject)
    {
      if (!(paramObject instanceof y))
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
      return ((t)this.a.getValue()).a((y)paramObject);
    }
  }

  static class b<K>
    implements Iterator<Map.Entry<K, Object>>
  {
    private Iterator<Map.Entry<K, Object>> a;

    public b(Iterator<Map.Entry<K, Object>> paramIterator)
    {
      this.a = paramIterator;
    }

    public Map.Entry<K, Object> a()
    {
      Object localObject = (Map.Entry)this.a.next();
      if ((((Map.Entry)localObject).getValue() instanceof t))
        localObject = new t.a((Map.Entry)localObject, null);
      return localObject;
    }

    public boolean hasNext()
    {
      return this.a.hasNext();
    }

    public void remove()
    {
      this.a.remove();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.t
 * JD-Core Version:    0.6.2
 */