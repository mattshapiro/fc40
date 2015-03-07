package com.umeng.message.proguard;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class u extends AbstractList<String>
  implements v, RandomAccess
{
  public static final v a = new Q(new u());
  private final List<Object> b;

  public u()
  {
    this.b = new ArrayList();
  }

  public u(v paramv)
  {
    this.b = new ArrayList(paramv.size());
    addAll(paramv);
  }

  public u(List<String> paramList)
  {
    this.b = new ArrayList(paramList);
  }

  private String a(Object paramObject)
  {
    if ((paramObject instanceof String))
      return (String)paramObject;
    return ((g)paramObject).h();
  }

  public String a(int paramInt)
  {
    Object localObject = this.b.get(paramInt);
    if ((localObject instanceof String))
      return (String)localObject;
    g localg = (g)localObject;
    String str = localg.h();
    if (localg.i())
      this.b.set(paramInt, str);
    return str;
  }

  public String a(int paramInt, String paramString)
  {
    return a(this.b.set(paramInt, paramString));
  }

  public List<?> a()
  {
    return Collections.unmodifiableList(this.b);
  }

  public void a(g paramg)
  {
    this.b.add(paramg);
    this.modCount = (1 + this.modCount);
  }

  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    if ((paramCollection instanceof v))
      paramCollection = ((v)paramCollection).a();
    boolean bool = this.b.addAll(paramInt, paramCollection);
    this.modCount = (1 + this.modCount);
    return bool;
  }

  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }

  public String b(int paramInt)
  {
    Object localObject = this.b.remove(paramInt);
    this.modCount = (1 + this.modCount);
    return a(localObject);
  }

  public void b(int paramInt, String paramString)
  {
    this.b.add(paramInt, paramString);
    this.modCount = (1 + this.modCount);
  }

  public g c(int paramInt)
  {
    Object localObject = this.b.get(paramInt);
    if ((localObject instanceof String))
    {
      g localg = g.a((String)localObject);
      this.b.set(paramInt, localg);
      return localg;
    }
    return (g)localObject;
  }

  public void clear()
  {
    this.b.clear();
    this.modCount = (1 + this.modCount);
  }

  public int size()
  {
    return this.b.size();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.u
 * JD-Core Version:    0.6.2
 */