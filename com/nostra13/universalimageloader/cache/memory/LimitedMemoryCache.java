package com.nostra13.universalimageloader.cache.memory;

import com.nostra13.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LimitedMemoryCache<K, V> extends BaseMemoryCache<K, V>
{
  private static final int MAX_NORMAL_CACHE_SIZE = 16777216;
  private static final int MAX_NORMAL_CACHE_SIZE_IN_MB = 16;
  private final AtomicInteger cacheSize;
  private final List<V> hardCache = Collections.synchronizedList(new LinkedList());
  private final int sizeLimit;

  public LimitedMemoryCache(int paramInt)
  {
    this.sizeLimit = paramInt;
    this.cacheSize = new AtomicInteger();
    if (paramInt > 16777216)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(16);
      L.w("You set too large memory cache size (more than %1$d Mb)", arrayOfObject);
    }
  }

  public void clear()
  {
    this.hardCache.clear();
    this.cacheSize.set(0);
    super.clear();
  }

  protected abstract int getSize(V paramV);

  protected int getSizeLimit()
  {
    return this.sizeLimit;
  }

  public boolean put(K paramK, V paramV)
  {
    int i = getSize(paramV);
    int j = getSizeLimit();
    int k = this.cacheSize.get();
    boolean bool = false;
    if (i < j);
    while (true)
    {
      if (k + i <= j)
      {
        this.hardCache.add(paramV);
        this.cacheSize.addAndGet(i);
        bool = true;
        super.put(paramK, paramV);
        return bool;
      }
      Object localObject = removeNext();
      if (this.hardCache.remove(localObject))
        k = this.cacheSize.addAndGet(-getSize(localObject));
    }
  }

  public void remove(K paramK)
  {
    Object localObject = super.get(paramK);
    if ((localObject != null) && (this.hardCache.remove(localObject)))
      this.cacheSize.addAndGet(-getSize(localObject));
    super.remove(paramK);
  }

  protected abstract V removeNext();
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache
 * JD-Core Version:    0.6.2
 */