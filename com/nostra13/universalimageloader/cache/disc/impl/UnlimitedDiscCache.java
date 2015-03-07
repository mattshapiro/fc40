package com.nostra13.universalimageloader.cache.disc.impl;

import com.nostra13.universalimageloader.cache.disc.BaseDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public class UnlimitedDiscCache extends BaseDiscCache
{
  public UnlimitedDiscCache(File paramFile)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator());
  }

  public UnlimitedDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    super(paramFile, paramFileNameGenerator);
  }

  public void put(String paramString, File paramFile)
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache
 * JD-Core Version:    0.6.2
 */