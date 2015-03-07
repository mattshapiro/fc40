package net.tsz.afinal.core;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractCollection<E>
  implements Collection<E>
{
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    boolean bool = false;
    Iterator localIterator = paramCollection.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return bool;
      if (add(localIterator.next()))
        bool = true;
    }
  }

  public void clear()
  {
    Iterator localIterator = iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      localIterator.next();
      localIterator.remove();
    }
  }

  public boolean contains(Object paramObject)
  {
    boolean bool = true;
    Iterator localIterator = iterator();
    if (paramObject != null)
      if (localIterator.hasNext());
    while (true)
    {
      bool = false;
      while (localIterator.next() == null)
      {
        return bool;
        if (!paramObject.equals(localIterator.next()))
          break;
        return bool;
      }
      if (localIterator.hasNext());
    }
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    do
      if (!localIterator.hasNext())
        return true;
    while (contains(localIterator.next()));
    return false;
  }

  public boolean isEmpty()
  {
    return size() == 0;
  }

  public abstract Iterator<E> iterator();

  public boolean remove(Object paramObject)
  {
    Iterator localIterator = iterator();
    if (paramObject != null)
      if (localIterator.hasNext());
    while (true)
    {
      return false;
      if (!paramObject.equals(localIterator.next()))
        break;
      localIterator.remove();
      return true;
      do
        if (localIterator.next() == null)
        {
          localIterator.remove();
          return true;
        }
      while (localIterator.hasNext());
    }
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    Iterator localIterator = iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return bool;
      if (paramCollection.contains(localIterator.next()))
      {
        localIterator.remove();
        bool = true;
      }
    }
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    Iterator localIterator = iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return bool;
      if (!paramCollection.contains(localIterator.next()))
      {
        localIterator.remove();
        bool = true;
      }
    }
  }

  public abstract int size();

  public Object[] toArray()
  {
    int i = size();
    Iterator localIterator = iterator();
    Object[] arrayOfObject = new Object[i];
    int k;
    for (int j = 0; ; j = k)
    {
      if (j >= i)
        return arrayOfObject;
      k = j + 1;
      arrayOfObject[j] = localIterator.next();
    }
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    int i = size();
    int j = 0;
    if (i > paramArrayOfT.length)
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), i);
    Iterator localIterator = iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if (j < paramArrayOfT.length)
          paramArrayOfT[j] = null;
        return paramArrayOfT;
      }
      Object localObject = (Object)localIterator.next();
      int k = j + 1;
      paramArrayOfT[j] = localObject;
      j = k;
    }
  }

  public String toString()
  {
    if (isEmpty())
      return "[]";
    StringBuilder localStringBuilder = new StringBuilder(16 * size());
    localStringBuilder.append('[');
    Iterator localIterator = iterator();
    label106: 
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      Object localObject = localIterator.next();
      if (localObject != this)
        localStringBuilder.append(localObject);
      while (true)
      {
        if (!localIterator.hasNext())
          break label106;
        localStringBuilder.append(", ");
        break;
        localStringBuilder.append("(this Collection)");
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.core.AbstractCollection
 * JD-Core Version:    0.6.2
 */