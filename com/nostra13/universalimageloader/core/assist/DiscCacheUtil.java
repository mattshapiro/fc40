package com.nostra13.universalimageloader.core.assist;

import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import java.io.File;

public final class DiscCacheUtil
{
  public static File findInCache(String paramString, DiscCacheAware paramDiscCacheAware)
  {
    File localFile = paramDiscCacheAware.get(paramString);
    if (localFile.exists())
      return localFile;
    return null;
  }

  public static boolean removeFromCache(String paramString, DiscCacheAware paramDiscCacheAware)
  {
    return paramDiscCacheAware.get(paramString).delete();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.DiscCacheUtil
 * JD-Core Version:    0.6.2
 */