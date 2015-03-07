package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LimitedDiscCache extends BaseDiscCache
{
  private final AtomicInteger cacheSize;
  private final Map<File, Long> lastUsageDates = Collections.synchronizedMap(new HashMap());
  private final int sizeLimit;

  public LimitedDiscCache(File paramFile, int paramInt)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator(), paramInt);
  }

  public LimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator, int paramInt)
  {
    super(paramFile, paramFileNameGenerator);
    this.sizeLimit = paramInt;
    this.cacheSize = new AtomicInteger();
    calculateCacheSizeAndFillUsageMap();
  }

  private void calculateCacheSizeAndFillUsageMap()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        int i = 0;
        File[] arrayOfFile = LimitedDiscCache.this.cacheDir.listFiles();
        int j;
        if (arrayOfFile != null)
          j = arrayOfFile.length;
        for (int k = 0; ; k++)
        {
          if (k >= j)
          {
            LimitedDiscCache.this.cacheSize.set(i);
            return;
          }
          File localFile = arrayOfFile[k];
          i += LimitedDiscCache.this.getSize(localFile);
          LimitedDiscCache.this.lastUsageDates.put(localFile, Long.valueOf(localFile.lastModified()));
        }
      }
    }).start();
  }

  private int removeNext()
  {
    int i;
    if (this.lastUsageDates.isEmpty())
      i = 0;
    while (true)
    {
      return i;
      Object localObject1 = null;
      File localFile = null;
      Set localSet = this.lastUsageDates.entrySet();
      synchronized (this.lastUsageDates)
      {
        Iterator localIterator = localSet.iterator();
        Map.Entry localEntry;
        label131: Long localLong;
        do
        {
          while (true)
          {
            if (!localIterator.hasNext())
            {
              i = getSize(localFile);
              if (!localFile.delete())
                break;
              this.lastUsageDates.remove(localFile);
              return i;
            }
            localEntry = (Map.Entry)localIterator.next();
            if (localFile != null)
              break label131;
            localFile = (File)localEntry.getKey();
            localObject1 = (Long)localEntry.getValue();
          }
          localLong = (Long)localEntry.getValue();
        }
        while (localLong.longValue() >= ((Long)localObject1).longValue());
        localObject1 = localLong;
        localFile = (File)localEntry.getKey();
      }
    }
  }

  public void clear()
  {
    this.lastUsageDates.clear();
    this.cacheSize.set(0);
    super.clear();
  }

  public File get(String paramString)
  {
    File localFile = super.get(paramString);
    Long localLong = Long.valueOf(System.currentTimeMillis());
    localFile.setLastModified(localLong.longValue());
    this.lastUsageDates.put(localFile, localLong);
    return localFile;
  }

  protected abstract int getSize(File paramFile);

  public void put(String paramString, File paramFile)
  {
    int i = getSize(paramFile);
    int k;
    for (int j = this.cacheSize.get(); ; j = this.cacheSize.addAndGet(-k))
    {
      if (j + i <= this.sizeLimit);
      do
      {
        this.cacheSize.addAndGet(i);
        Long localLong = Long.valueOf(System.currentTimeMillis());
        paramFile.setLastModified(localLong.longValue());
        this.lastUsageDates.put(paramFile, localLong);
        return;
        k = removeNext();
      }
      while (k == 0);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.LimitedDiscCache
 * JD-Core Version:    0.6.2
 */