package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class MemoryCacheUtil
{
  private static final String URI_AND_SIZE_SEPARATOR = "_";
  private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";

  public static Comparator<String> createFuzzyKeyComparator()
  {
    return new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString1.substring(0, paramAnonymousString1.lastIndexOf("_")).compareTo(paramAnonymousString2.substring(0, paramAnonymousString2.lastIndexOf("_")));
      }
    };
  }

  public static List<String> findCacheKeysForImageUri(String paramString, MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMemoryCacheAware.keys().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      String str = (String)localIterator.next();
      if (str.startsWith(paramString))
        localArrayList.add(str);
    }
  }

  public static List<Bitmap> findCachedBitmapsForImageUri(String paramString, MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramMemoryCacheAware.keys().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      String str = (String)localIterator.next();
      if (str.startsWith(paramString))
        localArrayList.add((Bitmap)paramMemoryCacheAware.get(str));
    }
  }

  public static String generateKey(String paramString, ImageSize paramImageSize)
  {
    return paramString + "_" + paramImageSize.getWidth() + "x" + paramImageSize.getHeight();
  }

  public static void removeFromCache(String paramString, MemoryCacheAware<String, Bitmap> paramMemoryCacheAware)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramMemoryCacheAware.keys().iterator();
    Iterator localIterator2;
    if (!localIterator1.hasNext())
      localIterator2 = localArrayList.iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        return;
        String str = (String)localIterator1.next();
        if (!str.startsWith(paramString))
          break;
        localArrayList.add(str);
        break;
      }
      paramMemoryCacheAware.remove((String)localIterator2.next());
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.MemoryCacheUtil
 * JD-Core Version:    0.6.2
 */