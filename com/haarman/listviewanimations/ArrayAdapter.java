package com.haarman.listviewanimations;

import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public abstract class ArrayAdapter<T> extends BaseAdapter
{
  private ArrayList<T> mItems = new ArrayList();

  public ArrayAdapter()
  {
    this(null);
  }

  public ArrayAdapter(ArrayList<T> paramArrayList)
  {
    if (paramArrayList != null)
      this.mItems.addAll(paramArrayList);
  }

  public void add(int paramInt, T paramT)
  {
    this.mItems.add(paramInt, paramT);
    notifyDataSetChanged();
  }

  public void add(T paramT)
  {
    this.mItems.add(paramT);
    notifyDataSetChanged();
  }

  public void addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    this.mItems.addAll(paramInt, paramCollection);
    notifyDataSetChanged();
  }

  public void addAll(int paramInt, T[] paramArrayOfT)
  {
    for (int i = paramInt; ; i++)
    {
      if (i >= paramInt + paramArrayOfT.length)
      {
        notifyDataSetChanged();
        return;
      }
      this.mItems.add(i, paramArrayOfT[i]);
    }
  }

  public void addAll(Collection<? extends T> paramCollection)
  {
    this.mItems.addAll(paramCollection);
    notifyDataSetChanged();
  }

  public void addAll(T[] paramArrayOfT)
  {
    Collections.addAll(this.mItems, paramArrayOfT);
    notifyDataSetChanged();
  }

  public void clear()
  {
    this.mItems.clear();
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.mItems.size();
  }

  public T getItem(int paramInt)
  {
    return this.mItems.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int indexOf(T paramT)
  {
    return this.mItems.indexOf(paramT);
  }

  public void remove(int paramInt)
  {
    this.mItems.remove(paramInt);
    notifyDataSetChanged();
  }

  public void remove(T paramT)
  {
    this.mItems.remove(paramT);
    notifyDataSetChanged();
  }

  public void removeAll(Collection<T> paramCollection)
  {
    this.mItems.removeAll(paramCollection);
    notifyDataSetChanged();
  }

  public void removePositions(Collection<Integer> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection);
    Collections.sort(localArrayList);
    Collections.reverse(localArrayList);
    Iterator localIterator = localArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        notifyDataSetChanged();
        return;
      }
      int i = ((Integer)localIterator.next()).intValue();
      this.mItems.remove(i);
    }
  }

  public void retainAll(Collection<T> paramCollection)
  {
    this.mItems.retainAll(paramCollection);
    notifyDataSetChanged();
  }

  public void set(int paramInt, T paramT)
  {
    this.mItems.set(paramInt, paramT);
    notifyDataSetChanged();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.ArrayAdapter
 * JD-Core Version:    0.6.2
 */