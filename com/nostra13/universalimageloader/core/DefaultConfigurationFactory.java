package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.disc.impl.FileCountLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiscCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;
import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultConfigurationFactory
{
  public static BitmapDisplayer createBitmapDisplayer()
  {
    return new SimpleBitmapDisplayer();
  }

  public static DiscCacheAware createDiscCache(Context paramContext, FileNameGenerator paramFileNameGenerator, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
      return new TotalSizeLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(paramContext), paramFileNameGenerator, paramInt1);
    if (paramInt2 > 0)
      return new FileCountLimitedDiscCache(StorageUtils.getIndividualCacheDirectory(paramContext), paramFileNameGenerator, paramInt2);
    return new UnlimitedDiscCache(StorageUtils.getCacheDirectory(paramContext), paramFileNameGenerator);
  }

  public static Executor createExecutor(int paramInt1, int paramInt2, QueueProcessingType paramQueueProcessingType)
  {
    int i;
    if (paramQueueProcessingType == QueueProcessingType.LIFO)
    {
      i = 1;
      if (i == 0)
        break label47;
    }
    label47: for (Object localObject = new LIFOLinkedBlockingDeque(); ; localObject = new LinkedBlockingQueue())
    {
      return new ThreadPoolExecutor(paramInt1, paramInt1, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)localObject, createThreadFactory(paramInt2));
      i = 0;
      break;
    }
  }

  public static FileNameGenerator createFileNameGenerator()
  {
    return new HashCodeFileNameGenerator();
  }

  public static ImageDecoder createImageDecoder(boolean paramBoolean)
  {
    return new BaseImageDecoder(paramBoolean);
  }

  public static ImageDownloader createImageDownloader(Context paramContext)
  {
    return new BaseImageDownloader(paramContext);
  }

  public static MemoryCacheAware<String, Bitmap> createMemoryCache(int paramInt)
  {
    if (paramInt == 0)
      paramInt = (int)(Runtime.getRuntime().maxMemory() / 8L);
    if (Build.VERSION.SDK_INT >= 9)
      return new LruMemoryCache(paramInt);
    return new LRULimitedMemoryCache(paramInt);
  }

  public static DiscCacheAware createReserveDiscCache(Context paramContext)
  {
    Object localObject = paramContext.getCacheDir();
    File localFile = new File((File)localObject, "uil-images");
    if ((localFile.exists()) || (localFile.mkdir()))
      localObject = localFile;
    return new TotalSizeLimitedDiscCache((File)localObject, 2097152);
  }

  private static ThreadFactory createThreadFactory(int paramInt)
  {
    return new DefaultThreadFactory(paramInt);
  }

  private static class DefaultThreadFactory
    implements ThreadFactory
  {
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final int threadPriority;

    DefaultThreadFactory(int paramInt)
    {
      this.threadPriority = paramInt;
      SecurityManager localSecurityManager = System.getSecurityManager();
      if (localSecurityManager != null);
      for (ThreadGroup localThreadGroup = localSecurityManager.getThreadGroup(); ; localThreadGroup = Thread.currentThread().getThreadGroup())
      {
        this.group = localThreadGroup;
        this.namePrefix = ("pool-" + poolNumber.getAndIncrement() + "-thread-");
        return;
      }
    }

    public Thread newThread(Runnable paramRunnable)
    {
      Thread localThread = new Thread(this.group, paramRunnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
      if (localThread.isDaemon())
        localThread.setDaemon(false);
      localThread.setPriority(this.threadPriority);
      return localThread;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DefaultConfigurationFactory
 * JD-Core Version:    0.6.2
 */