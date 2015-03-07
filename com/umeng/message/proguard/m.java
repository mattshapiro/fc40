package com.umeng.message.proguard;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class m extends n
{
  private static final m c = new m(true);
  private final Map<String, b> a;
  private final Map<a, b> b;

  private m()
  {
    this.a = new HashMap();
    this.b = new HashMap();
  }

  private m(m paramm)
  {
    super(paramm);
    this.a = Collections.unmodifiableMap(paramm.a);
    this.b = Collections.unmodifiableMap(paramm.b);
  }

  private m(boolean paramBoolean)
  {
    super(n.g());
    this.a = Collections.emptyMap();
    this.b = Collections.emptyMap();
  }

  public static m a()
  {
    return new m();
  }

  private void a(b paramb)
  {
    if (!paramb.a.t())
      throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
    this.a.put(paramb.a.d(), paramb);
    this.b.put(new a(paramb.a.u(), paramb.a.f()), paramb);
    k.f localf = paramb.a;
    if ((localf.u().g().o()) && (localf.i() == k.f.b.k) && (localf.m()) && (localf.v() == localf.w()))
      this.a.put(localf.w().d(), paramb);
  }

  public static m b()
  {
    return c;
  }

  public b a(k.a parama, int paramInt)
  {
    return (b)this.b.get(new a(parama, paramInt));
  }

  public b a(String paramString)
  {
    return (b)this.a.get(paramString);
  }

  public void a(k.f paramf)
  {
    if (paramf.g() == k.f.a.i)
      throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
    a(new b(paramf, null, null));
  }

  public void a(k.f paramf, x paramx)
  {
    if (paramf.g() != k.f.a.i)
      throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
    a(new b(paramf, paramx, null));
  }

  public void a(p.h<?, ?> paramh)
  {
    if (paramh.a().g() == k.f.a.i)
    {
      if (paramh.b() == null)
        throw new IllegalStateException("Registered message-type extension had null default instance: " + paramh.a().d());
      a(new b(paramh.a(), paramh.b(), null));
      return;
    }
    a(new b(paramh.a(), null, null));
  }

  public m c()
  {
    return new m(this);
  }

  private static final class a
  {
    private final k.a a;
    private final int b;

    a(k.a parama, int paramInt)
    {
      this.a = parama;
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
      return 65535 * this.a.hashCode() + this.b;
    }
  }

  public static final class b
  {
    public final k.f a;
    public final x b;

    private b(k.f paramf)
    {
      this.a = paramf;
      this.b = null;
    }

    private b(k.f paramf, x paramx)
    {
      this.a = paramf;
      this.b = paramx;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.m
 * JD-Core Version:    0.6.2
 */