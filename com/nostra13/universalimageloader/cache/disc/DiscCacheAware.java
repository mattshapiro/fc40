package com.nostra13.universalimageloader.cache.disc;

import java.io.File;

public abstract interface DiscCacheAware
{
  public abstract void clear();

  public abstract File get(String paramString);

  public abstract void put(String paramString, File paramFile);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.DiscCacheAware
 * JD-Core Version:    0.6.2
 */