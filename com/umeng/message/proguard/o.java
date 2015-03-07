package com.umeng.message.proguard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class o<FieldDescriptorType extends a<FieldDescriptorType>>
{
  private static final o d = new o(true);
  private final M<FieldDescriptorType, Object> a;
  private boolean b;
  private boolean c = false;

  private o()
  {
    this.a = M.a(16);
  }

  private o(boolean paramBoolean)
  {
    this.a = M.a(0);
    c();
  }

  private static int a(S.a parama, int paramInt, Object paramObject)
  {
    int i = i.o(paramInt);
    if (parama == S.a.j)
      i *= 2;
    return i + b(parama, paramObject);
  }

  static int a(S.a parama, boolean paramBoolean)
  {
    if (paramBoolean)
      return 2;
    return parama.b();
  }

  public static <T extends a<T>> o<T> a()
  {
    return new o();
  }

  public static Object a(h paramh, S.a parama)
    throws IOException
  {
    switch (1.b[parama.ordinal()])
    {
    default:
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1:
      return Double.valueOf(paramh.c());
    case 2:
      return Float.valueOf(paramh.d());
    case 3:
      return Long.valueOf(paramh.f());
    case 4:
      return Long.valueOf(paramh.e());
    case 5:
      return Integer.valueOf(paramh.g());
    case 6:
      return Long.valueOf(paramh.h());
    case 7:
      return Integer.valueOf(paramh.i());
    case 8:
      return Boolean.valueOf(paramh.j());
    case 9:
      return paramh.k();
    case 10:
      return paramh.l();
    case 11:
      return Integer.valueOf(paramh.m());
    case 12:
      return Integer.valueOf(paramh.o());
    case 13:
      return Long.valueOf(paramh.p());
    case 14:
      return Integer.valueOf(paramh.q());
    case 15:
      return Long.valueOf(paramh.r());
    case 16:
      throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
    case 17:
      throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
    case 18:
    }
    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
  }

  private static void a(S.a parama, Object paramObject)
  {
    if (paramObject == null)
      throw new NullPointerException();
    int i = 1.a[parama.a().ordinal()];
    boolean bool1 = false;
    switch (i)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    }
    while (!bool1)
    {
      throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      bool1 = paramObject instanceof Integer;
      continue;
      bool1 = paramObject instanceof Long;
      continue;
      bool1 = paramObject instanceof Float;
      continue;
      bool1 = paramObject instanceof Double;
      continue;
      bool1 = paramObject instanceof Boolean;
      continue;
      bool1 = paramObject instanceof String;
      continue;
      bool1 = paramObject instanceof g;
      continue;
      bool1 = paramObject instanceof r.a;
      continue;
      if (!(paramObject instanceof y))
      {
        boolean bool2 = paramObject instanceof t;
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
    }
  }

  private static void a(i parami, S.a parama, int paramInt, Object paramObject)
    throws IOException
  {
    if (parama == S.a.j)
    {
      parami.a(paramInt, (y)paramObject);
      return;
    }
    parami.m(paramInt, a(parama, false));
    a(parami, parama, paramObject);
  }

  private static void a(i parami, S.a parama, Object paramObject)
    throws IOException
  {
    switch (1.b[parama.ordinal()])
    {
    default:
      return;
    case 1:
      parami.a(((Double)paramObject).doubleValue());
      return;
    case 2:
      parami.a(((Float)paramObject).floatValue());
      return;
    case 3:
      parami.b(((Long)paramObject).longValue());
      return;
    case 4:
      parami.a(((Long)paramObject).longValue());
      return;
    case 5:
      parami.b(((Integer)paramObject).intValue());
      return;
    case 6:
      parami.c(((Long)paramObject).longValue());
      return;
    case 7:
      parami.c(((Integer)paramObject).intValue());
      return;
    case 8:
      parami.a(((Boolean)paramObject).booleanValue());
      return;
    case 9:
      parami.a((String)paramObject);
      return;
    case 16:
      parami.a((y)paramObject);
      return;
    case 17:
      parami.c((y)paramObject);
      return;
    case 10:
      parami.a((g)paramObject);
      return;
    case 11:
      parami.d(((Integer)paramObject).intValue());
      return;
    case 12:
      parami.f(((Integer)paramObject).intValue());
      return;
    case 13:
      parami.d(((Long)paramObject).longValue());
      return;
    case 14:
      parami.g(((Integer)paramObject).intValue());
      return;
    case 15:
      parami.e(((Long)paramObject).longValue());
      return;
    case 18:
    }
    parami.e(((r.a)paramObject).a());
  }

  public static void a(a<?> parama, Object paramObject, i parami)
    throws IOException
  {
    S.a locala = parama.j();
    int i = parama.f();
    if (parama.n())
    {
      List localList = (List)paramObject;
      if (parama.o())
      {
        parami.m(i, 2);
        int j = 0;
        Iterator localIterator2 = localList.iterator();
        while (localIterator2.hasNext())
          j += b(locala, localIterator2.next());
        parami.p(j);
        Iterator localIterator3 = localList.iterator();
        while (localIterator3.hasNext())
          a(parami, locala, localIterator3.next());
      }
      Iterator localIterator1 = localList.iterator();
      while (localIterator1.hasNext())
        a(parami, locala, i, localIterator1.next());
    }
    if ((paramObject instanceof t))
    {
      a(parami, locala, i, ((t)paramObject).a());
      return;
    }
    a(parami, locala, i, paramObject);
  }

  private void a(Map.Entry<FieldDescriptorType, Object> paramEntry, i parami)
    throws IOException
  {
    a locala = (a)paramEntry.getKey();
    if ((locala.h() == S.b.i) && (!locala.n()) && (!locala.o()))
    {
      parami.d(((a)paramEntry.getKey()).f(), (y)paramEntry.getValue());
      return;
    }
    a(locala, paramEntry.getValue(), parami);
  }

  private void a(Map<FieldDescriptorType, Object> paramMap, Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((localObject instanceof t))
    {
      paramMap.put(locala, ((t)localObject).a());
      return;
    }
    paramMap.put(locala, localObject);
  }

  private boolean a(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    if (locala.h() == S.b.i)
    {
      if (locala.n())
      {
        Iterator localIterator = ((List)paramEntry.getValue()).iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (((y)localIterator.next()).a());
        return false;
      }
      Object localObject = paramEntry.getValue();
      if ((localObject instanceof y))
      {
        if (!((y)localObject).a())
          return false;
      }
      else
      {
        if ((localObject instanceof t))
          return true;
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      }
    }
    return true;
  }

  private static int b(S.a parama, Object paramObject)
  {
    switch (1.b[parama.ordinal()])
    {
    default:
      throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
    case 1:
      return i.b(((Double)paramObject).doubleValue());
    case 2:
      return i.b(((Float)paramObject).floatValue());
    case 3:
      return i.g(((Long)paramObject).longValue());
    case 4:
      return i.f(((Long)paramObject).longValue());
    case 5:
      return i.h(((Integer)paramObject).intValue());
    case 6:
      return i.h(((Long)paramObject).longValue());
    case 7:
      return i.i(((Integer)paramObject).intValue());
    case 8:
      return i.b(((Boolean)paramObject).booleanValue());
    case 9:
      return i.b((String)paramObject);
    case 16:
      return i.d((y)paramObject);
    case 10:
      return i.b((g)paramObject);
    case 11:
      return i.j(((Integer)paramObject).intValue());
    case 12:
      return i.l(((Integer)paramObject).intValue());
    case 13:
      return i.i(((Long)paramObject).longValue());
    case 14:
      return i.m(((Integer)paramObject).intValue());
    case 15:
      return i.j(((Long)paramObject).longValue());
    case 17:
      if ((paramObject instanceof t))
        return i.a((t)paramObject);
      return i.f((y)paramObject);
    case 18:
    }
    return i.k(((r.a)paramObject).a());
  }

  public static <T extends a<T>> o<T> b()
  {
    return d;
  }

  private void b(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject1 = paramEntry.getValue();
    if ((localObject1 instanceof t))
      localObject1 = ((t)localObject1).a();
    if (locala.n())
    {
      Object localObject3 = b(locala);
      if (localObject3 == null)
      {
        this.a.a(locala, new ArrayList((List)localObject1));
        return;
      }
      ((List)localObject3).addAll((List)localObject1);
      return;
    }
    if (locala.h() == S.b.i)
    {
      Object localObject2 = b(locala);
      if (localObject2 == null)
      {
        this.a.a(locala, localObject1);
        return;
      }
      this.a.a(locala, locala.a(((y)localObject2).O(), (y)localObject1).am());
      return;
    }
    this.a.a(locala, localObject1);
  }

  public static int c(a<?> parama, Object paramObject)
  {
    int i = 0;
    S.a locala = parama.j();
    int j = parama.f();
    if (parama.n())
    {
      if (parama.o())
      {
        Iterator localIterator2 = ((List)paramObject).iterator();
        while (localIterator2.hasNext())
          i += b(locala, localIterator2.next());
        i = i + i.o(j) + i.q(i);
      }
      while (true)
      {
        return i;
        Iterator localIterator1 = ((List)paramObject).iterator();
        while (localIterator1.hasNext())
          i += a(locala, j, localIterator1.next());
      }
    }
    return a(locala, j, paramObject);
  }

  private int c(Map.Entry<FieldDescriptorType, Object> paramEntry)
  {
    a locala = (a)paramEntry.getKey();
    Object localObject = paramEntry.getValue();
    if ((locala.h() == S.b.i) && (!locala.n()) && (!locala.o()))
    {
      if ((localObject instanceof t))
        return i.b(((a)paramEntry.getKey()).f(), (t)localObject);
      return i.h(((a)paramEntry.getKey()).f(), (y)localObject);
    }
    return c(locala, localObject);
  }

  public Object a(FieldDescriptorType paramFieldDescriptorType, int paramInt)
  {
    if (!paramFieldDescriptorType.n())
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
      throw new IndexOutOfBoundsException();
    return ((List)localObject).get(paramInt);
  }

  public void a(i parami)
    throws IOException
  {
    for (int i = 0; i < this.a.c(); i++)
    {
      Map.Entry localEntry2 = this.a.c(i);
      a((a)localEntry2.getKey(), localEntry2.getValue(), parami);
    }
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      a((a)localEntry1.getKey(), localEntry1.getValue(), parami);
    }
  }

  public void a(FieldDescriptorType paramFieldDescriptorType, int paramInt, Object paramObject)
  {
    if (!paramFieldDescriptorType.n())
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
      throw new IndexOutOfBoundsException();
    a(paramFieldDescriptorType.j(), paramObject);
    ((List)localObject).set(paramInt, paramObject);
  }

  public void a(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (paramFieldDescriptorType.n())
    {
      if (!(paramObject instanceof List))
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((List)paramObject);
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        a(paramFieldDescriptorType.j(), localObject);
      }
      paramObject = localArrayList;
    }
    while (true)
    {
      if ((paramObject instanceof t))
        this.c = true;
      this.a.a(paramFieldDescriptorType, paramObject);
      return;
      a(paramFieldDescriptorType.j(), paramObject);
    }
  }

  public void a(o<FieldDescriptorType> paramo)
  {
    for (int i = 0; i < paramo.a.c(); i++)
      b(paramo.a.c(i));
    Iterator localIterator = paramo.a.e().iterator();
    while (localIterator.hasNext())
      b((Map.Entry)localIterator.next());
  }

  public boolean a(FieldDescriptorType paramFieldDescriptorType)
  {
    if (paramFieldDescriptorType.n())
      throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    return this.a.get(paramFieldDescriptorType) != null;
  }

  public Object b(FieldDescriptorType paramFieldDescriptorType)
  {
    Object localObject = this.a.get(paramFieldDescriptorType);
    if ((localObject instanceof t))
      localObject = ((t)localObject).a();
    return localObject;
  }

  public void b(i parami)
    throws IOException
  {
    for (int i = 0; i < this.a.c(); i++)
      a(this.a.c(i), parami);
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
      a((Map.Entry)localIterator.next(), parami);
  }

  public void b(FieldDescriptorType paramFieldDescriptorType, Object paramObject)
  {
    if (!paramFieldDescriptorType.n())
      throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    a(paramFieldDescriptorType.j(), paramObject);
    Object localObject1 = b(paramFieldDescriptorType);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = new ArrayList();
      this.a.a(paramFieldDescriptorType, localObject2);
    }
    while (true)
    {
      ((List)localObject2).add(paramObject);
      return;
      localObject2 = (List)localObject1;
    }
  }

  public void c()
  {
    if (this.b)
      return;
    this.a.a();
    this.b = true;
  }

  public void c(FieldDescriptorType paramFieldDescriptorType)
  {
    this.a.remove(paramFieldDescriptorType);
    if (this.a.isEmpty())
      this.c = false;
  }

  public int d(FieldDescriptorType paramFieldDescriptorType)
  {
    if (!paramFieldDescriptorType.n())
      throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    Object localObject = b(paramFieldDescriptorType);
    if (localObject == null)
      return 0;
    return ((List)localObject).size();
  }

  public boolean d()
  {
    return this.b;
  }

  public o<FieldDescriptorType> e()
  {
    o localo = a();
    for (int i = 0; i < this.a.c(); i++)
    {
      Map.Entry localEntry2 = this.a.c(i);
      localo.a((a)localEntry2.getKey(), localEntry2.getValue());
    }
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      localo.a((a)localEntry1.getKey(), localEntry1.getValue());
    }
    localo.c = this.c;
    return localo;
  }

  public void f()
  {
    this.a.clear();
    this.c = false;
  }

  public Map<FieldDescriptorType, Object> g()
  {
    if (this.c)
    {
      M localM = M.a(16);
      for (int i = 0; i < this.a.c(); i++)
        a(localM, this.a.c(i));
      Iterator localIterator = this.a.e().iterator();
      while (localIterator.hasNext())
        a(localM, (Map.Entry)localIterator.next());
      if (this.a.b())
        localM.a();
      return localM;
    }
    if (this.a.b())
      return this.a;
    return Collections.unmodifiableMap(this.a);
  }

  public Iterator<Map.Entry<FieldDescriptorType, Object>> h()
  {
    if (this.c)
      return new t.b(this.a.entrySet().iterator());
    return this.a.entrySet().iterator();
  }

  public boolean i()
  {
    for (int i = 0; i < this.a.c(); i++)
      if (!a(this.a.c(i)))
        return false;
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
      if (!a((Map.Entry)localIterator.next()))
        return false;
    return true;
  }

  public int j()
  {
    int i = 0;
    int j = 0;
    while (i < this.a.c())
    {
      Map.Entry localEntry2 = this.a.c(i);
      j += c((a)localEntry2.getKey(), localEntry2.getValue());
      i++;
    }
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator.next();
      j += c((a)localEntry1.getKey(), localEntry1.getValue());
    }
    return j;
  }

  public int k()
  {
    int i = 0;
    int j = 0;
    while (i < this.a.c())
    {
      j += c(this.a.c(i));
      i++;
    }
    Iterator localIterator = this.a.e().iterator();
    while (localIterator.hasNext())
      j += c((Map.Entry)localIterator.next());
    return j;
  }

  public static abstract interface a<T extends a<T>> extends Comparable<T>
  {
    public abstract y.a a(y.a parama, y paramy);

    public abstract int f();

    public abstract S.b h();

    public abstract S.a j();

    public abstract boolean n();

    public abstract boolean o();

    public abstract r.b<?> y();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.o
 * JD-Core Version:    0.6.2
 */