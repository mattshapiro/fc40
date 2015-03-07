package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LargestLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap>
{
  private final Map<Bitmap, Integer> valueSizes = Collections.synchronizedMap(new HashMap());

  public LargestLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
  }

  public void clear()
  {
    this.valueSizes.clear();
    super.clear();
  }

  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  protected int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
    {
      this.valueSizes.put(paramBitmap, Integer.valueOf(getSize(paramBitmap)));
      return true;
    }
    return false;
  }

  public void remove(String paramString)
  {
    Bitmap localBitmap = (Bitmap)super.get(paramString);
    if (localBitmap != null)
      this.valueSizes.remove(localBitmap);
    super.remove(paramString);
  }

  protected Bitmap removeNext()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Set localSet = this.valueSizes.entrySet();
    synchronized (this.valueSizes)
    {
      Iterator localIterator = localSet.iterator();
      Map.Entry localEntry;
      Integer localInteger;
      do
      {
        while (true)
        {
          if (!localIterator.hasNext())
          {
            this.valueSizes.remove(localObject2);
            return localObject2;
          }
          localEntry = (Map.Entry)localIterator.next();
          if (localObject2 != null)
            break;
          localObject2 = (Bitmap)localEntry.getKey();
          localObject1 = (Integer)localEntry.getValue();
        }
        localInteger = (Integer)localEntry.getValue();
      }
      while (localInteger.intValue() <= ((Integer)localObject1).intValue());
      localObject1 = localInteger;
      localObject2 = (Bitmap)localEntry.getKey();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LargestLimitedMemoryCache
 * JD-Core Version:    0.6.2
 */