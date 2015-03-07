package com.nostra13.universalimageloader.cache.disc;

import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import java.io.File;

public abstract class BaseDiscCache
  implements DiscCacheAware
{
  private static final String ERROR_ARG_NULL = "\"%s\" argument must be not null";
  protected File cacheDir;
  private FileNameGenerator fileNameGenerator;

  public BaseDiscCache(File paramFile)
  {
    this(paramFile, DefaultConfigurationFactory.createFileNameGenerator());
  }

  public BaseDiscCache(File paramFile, FileNameGenerator paramFileNameGenerator)
  {
    if (paramFile == null)
      throw new IllegalArgumentException("cacheDir\"%s\" argument must be not null");
    if (paramFileNameGenerator == null)
      throw new IllegalArgumentException("fileNameGenerator\"%s\" argument must be not null");
    this.cacheDir = paramFile;
    this.fileNameGenerator = paramFileNameGenerator;
  }

  public void clear()
  {
    File[] arrayOfFile = this.cacheDir.listFiles();
    int i;
    if (arrayOfFile != null)
      i = arrayOfFile.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      arrayOfFile[j].delete();
    }
  }

  public File get(String paramString)
  {
    String str = this.fileNameGenerator.generate(paramString);
    return new File(this.cacheDir, str);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.BaseDiscCache
 * JD-Core Version:    0.6.2
 */