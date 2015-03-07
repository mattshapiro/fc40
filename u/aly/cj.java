package u.aly;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class cj<T extends cj<?, ?>, F extends cg>
  implements bz<T, F>
{
  private static final Map<Class<? extends dg>, dh> a = new HashMap();
  protected Object b;
  protected F c;

  static
  {
    a.put(di.class, new b(null));
    a.put(dj.class, new d(null));
  }

  protected cj()
  {
    this.c = null;
    this.b = null;
  }

  protected cj(F paramF, Object paramObject)
  {
    b(paramF, paramObject);
  }

  protected cj(cj<T, F> paramcj)
  {
    if (!paramcj.getClass().equals(getClass()))
      throw new ClassCastException();
    this.c = paramcj.c;
    this.b = a(paramcj.b);
  }

  private static Object a(Object paramObject)
  {
    if ((paramObject instanceof bz))
      paramObject = ((bz)paramObject).g();
    do
    {
      return paramObject;
      if ((paramObject instanceof ByteBuffer))
        return ca.d((ByteBuffer)paramObject);
      if ((paramObject instanceof List))
        return a((List)paramObject);
      if ((paramObject instanceof Set))
        return a((Set)paramObject);
    }
    while (!(paramObject instanceof Map));
    return a((Map)paramObject);
  }

  private static List a(List paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      localArrayList.add(a(localIterator.next()));
    }
  }

  private static Map a(Map<Object, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localHashMap;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(a(localEntry.getKey()), a(localEntry.getValue()));
    }
  }

  private static Set a(Set paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = paramSet.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localHashSet;
      localHashSet.add(a(localIterator.next()));
    }
  }

  protected abstract Object a(cy paramcy, ct paramct)
    throws cf;

  protected abstract Object a(cy paramcy, short paramShort)
    throws cf;

  protected abstract ct a(F paramF);

  public void a(int paramInt, Object paramObject)
  {
    b(b((short)paramInt), paramObject);
  }

  protected abstract void a(F paramF, Object paramObject)
    throws ClassCastException;

  public void a(cy paramcy)
    throws cf
  {
    ((dh)a.get(paramcy.D())).b().a(paramcy, this);
  }

  public Object b(F paramF)
  {
    if (paramF != this.c)
      throw new IllegalArgumentException("Cannot get the value of field " + paramF + " because union's set field is " + this.c);
    return k();
  }

  protected abstract F b(short paramShort);

  public final void b()
  {
    this.c = null;
    this.b = null;
  }

  public void b(F paramF, Object paramObject)
  {
    a(paramF, paramObject);
    this.c = paramF;
    this.b = paramObject;
  }

  public void b(cy paramcy)
    throws cf
  {
    ((dh)a.get(paramcy.D())).b().b(paramcy, this);
  }

  public Object c(int paramInt)
  {
    return b(b((short)paramInt));
  }

  protected abstract dd c();

  protected abstract void c(cy paramcy)
    throws cf;

  public boolean c(F paramF)
  {
    return this.c == paramF;
  }

  protected abstract void d(cy paramcy)
    throws cf;

  public boolean d(int paramInt)
  {
    return c(b((short)paramInt));
  }

  public F j()
  {
    return this.c;
  }

  public Object k()
  {
    return this.b;
  }

  public boolean l()
  {
    return this.c != null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<");
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append(" ");
    Object localObject;
    if (j() != null)
    {
      localObject = k();
      localStringBuilder.append(a(j()).a);
      localStringBuilder.append(":");
      if (!(localObject instanceof ByteBuffer))
        break label99;
      ca.a((ByteBuffer)localObject, localStringBuilder);
    }
    while (true)
    {
      localStringBuilder.append(">");
      return localStringBuilder.toString();
      label99: localStringBuilder.append(localObject.toString());
    }
  }

  private static class a extends di<cj>
  {
    public void a(cy paramcy, cj paramcj)
      throws cf
    {
      paramcj.c = null;
      paramcj.b = null;
      paramcy.j();
      ct localct = paramcy.l();
      paramcj.b = paramcj.a(paramcy, localct);
      if (paramcj.b != null)
        paramcj.c = paramcj.b(localct.c);
      paramcy.m();
      paramcy.l();
      paramcy.k();
    }

    public void b(cy paramcy, cj paramcj)
      throws cf
    {
      if ((paramcj.j() == null) || (paramcj.k() == null))
        throw new cz("Cannot write a TUnion with no set value!");
      paramcy.a(paramcj.c());
      paramcy.a(paramcj.a(paramcj.c));
      paramcj.c(paramcy);
      paramcy.c();
      paramcy.d();
      paramcy.b();
    }
  }

  private static class b
    implements dh
  {
    public cj.a a()
    {
      return new cj.a(null);
    }
  }

  private static class c extends dj<cj>
  {
    public void a(cy paramcy, cj paramcj)
      throws cf
    {
      paramcj.c = null;
      paramcj.b = null;
      short s = paramcy.v();
      paramcj.b = paramcj.a(paramcy, s);
      if (paramcj.b != null)
        paramcj.c = paramcj.b(s);
    }

    public void b(cy paramcy, cj paramcj)
      throws cf
    {
      if ((paramcj.j() == null) || (paramcj.k() == null))
        throw new cz("Cannot write a TUnion with no set value!");
      paramcy.a(paramcj.c.a());
      paramcj.d(paramcy);
    }
  }

  private static class d
    implements dh
  {
    public cj.c a()
    {
      return new cj.c(null);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.cj
 * JD-Core Version:    0.6.2
 */