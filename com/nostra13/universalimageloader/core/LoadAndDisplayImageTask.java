package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

final class LoadAndDisplayImageTask
  implements Runnable
{
  private static final int BUFFER_SIZE = 8192;
  private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
  private static final String LOG_CACHE_IMAGE_ON_DISC = "Cache image on disc [%s]";
  private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
  private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_DISC_CACHE = "Load image from disc cache [%s]";
  private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
  private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
  private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
  private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
  private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
  private static final String LOG_TASK_CANCELLED = "ImageView is reused for another image. Task is cancelled. [%s]";
  private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
  private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
  private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
  private static final String WARNING_POST_PROCESSOR_NULL = "Pre-processor returned null [%s]";
  private static final String WARNING_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
  private final ImageLoaderConfiguration configuration;
  private final ImageDecoder decoder;
  private final ImageDownloader downloader;
  private final ImageLoaderEngine engine;
  private final Handler handler;
  private final ImageLoadingInfo imageLoadingInfo;
  final ImageView imageView;
  final ImageLoadingListener listener;
  private final boolean loggingEnabled;
  private final String memoryCacheKey;
  private final ImageDownloader networkDeniedDownloader;
  final DisplayImageOptions options;
  private final ImageDownloader slowNetworkDownloader;
  private final ImageSize targetSize;
  final String uri;

  public LoadAndDisplayImageTask(ImageLoaderEngine paramImageLoaderEngine, ImageLoadingInfo paramImageLoadingInfo, Handler paramHandler)
  {
    this.engine = paramImageLoaderEngine;
    this.imageLoadingInfo = paramImageLoadingInfo;
    this.handler = paramHandler;
    this.configuration = paramImageLoaderEngine.configuration;
    this.downloader = this.configuration.downloader;
    this.networkDeniedDownloader = this.configuration.networkDeniedDownloader;
    this.slowNetworkDownloader = this.configuration.slowNetworkDownloader;
    this.decoder = this.configuration.decoder;
    this.loggingEnabled = this.configuration.loggingEnabled;
    this.uri = paramImageLoadingInfo.uri;
    this.memoryCacheKey = paramImageLoadingInfo.memoryCacheKey;
    this.imageView = paramImageLoadingInfo.imageView;
    this.targetSize = paramImageLoadingInfo.targetSize;
    this.options = paramImageLoadingInfo.options;
    this.listener = paramImageLoadingInfo.listener;
  }

  private boolean checkTaskIsInterrupted()
  {
    boolean bool = Thread.interrupted();
    if (bool)
      log("Task was interrupted [%s]");
    return bool;
  }

  private boolean checkTaskIsNotActual()
  {
    String str = this.engine.getLoadingUriForView(this.imageView);
    if (this.memoryCacheKey.equals(str));
    for (boolean bool = false; ; bool = true)
    {
      if (bool)
      {
        this.handler.post(new Runnable()
        {
          public void run()
          {
            LoadAndDisplayImageTask.this.listener.onLoadingCancelled(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageView);
          }
        });
        log("ImageView is reused for another image. Task is cancelled. [%s]");
      }
      return bool;
    }
  }

  private Bitmap decodeImage(String paramString)
    throws IOException
  {
    ViewScaleType localViewScaleType = ViewScaleType.fromImageView(this.imageView);
    ImageDecodingInfo localImageDecodingInfo = new ImageDecodingInfo(this.memoryCacheKey, paramString, this.targetSize, localViewScaleType, getDownloader(), this.options);
    return this.decoder.decode(localImageDecodingInfo);
  }

  private boolean delayIfNeed()
  {
    if (this.options.shouldDelayBeforeLoading())
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = Integer.valueOf(this.options.getDelayBeforeLoading());
      arrayOfObject1[1] = this.memoryCacheKey;
      log("Delay %d ms before loading...  [%s]", arrayOfObject1);
      try
      {
        Thread.sleep(this.options.getDelayBeforeLoading());
        return checkTaskIsNotActual();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.memoryCacheKey;
        L.e("Task was interrupted [%s]", arrayOfObject2);
        return true;
      }
    }
    return false;
  }

  private void downloadImage(File paramFile)
    throws IOException
  {
    InputStream localInputStream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
    try
    {
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile), 8192);
      try
      {
        IoUtils.copyStream(localInputStream, localBufferedOutputStream);
        return;
      }
      finally
      {
      }
    }
    finally
    {
      IoUtils.closeSilently(localInputStream);
    }
  }

  private boolean downloadSizedImage(File paramFile, int paramInt1, int paramInt2)
    throws IOException
  {
    ImageSize localImageSize = new ImageSize(paramInt1, paramInt2);
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();
    ImageDecodingInfo localImageDecodingInfo = new ImageDecodingInfo(this.memoryCacheKey, this.uri, localImageSize, ViewScaleType.FIT_INSIDE, getDownloader(), localDisplayImageOptions);
    Bitmap localBitmap = this.decoder.decode(localImageDecodingInfo);
    boolean bool1 = false;
    BufferedOutputStream localBufferedOutputStream;
    if (localBitmap != null)
      localBufferedOutputStream = new BufferedOutputStream(new FileOutputStream(paramFile), 8192);
    try
    {
      boolean bool2 = localBitmap.compress(this.configuration.imageCompressFormatForDiscCache, this.configuration.imageQualityForDiscCache, localBufferedOutputStream);
      bool1 = bool2;
      IoUtils.closeSilently(localBufferedOutputStream);
      if (bool1)
        localBitmap.recycle();
      return bool1;
    }
    finally
    {
      IoUtils.closeSilently(localBufferedOutputStream);
    }
  }

  private void fireImageLoadingFailedEvent(final FailReason.FailType paramFailType, final Throwable paramThrowable)
  {
    if (!Thread.interrupted())
      this.handler.post(new Runnable()
      {
        public void run()
        {
          if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail())
            LoadAndDisplayImageTask.this.imageView.setImageResource(LoadAndDisplayImageTask.this.options.getImageOnFail());
          LoadAndDisplayImageTask.this.listener.onLoadingFailed(LoadAndDisplayImageTask.this.uri, LoadAndDisplayImageTask.this.imageView, new FailReason(paramFailType, paramThrowable));
        }
      });
  }

  private ImageDownloader getDownloader()
  {
    if (this.engine.isNetworkDenied())
      return this.networkDeniedDownloader;
    if (this.engine.isSlowNetwork())
      return this.slowNetworkDownloader;
    return this.downloader;
  }

  private File getImageFileInDiscCache()
  {
    File localFile1 = this.configuration.discCache.get(this.uri);
    File localFile2 = localFile1.getParentFile();
    if ((localFile2 == null) || ((!localFile2.exists()) && (!localFile2.mkdirs())))
    {
      localFile1 = this.configuration.reserveDiscCache.get(this.uri);
      File localFile3 = localFile1.getParentFile();
      if ((localFile3 == null) || (!localFile3.exists()))
        localFile3.mkdirs();
    }
    return localFile1;
  }

  private void log(String paramString)
  {
    if (this.loggingEnabled)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.memoryCacheKey;
      L.i(paramString, arrayOfObject);
    }
  }

  private void log(String paramString, Object[] paramArrayOfObject)
  {
    if (this.loggingEnabled)
      L.i(paramString, paramArrayOfObject);
  }

  private String tryCacheImageOnDisc(File paramFile)
  {
    log("Cache image on disc [%s]");
    try
    {
      int i = this.configuration.maxImageWidthForDiscCache;
      int j = this.configuration.maxImageHeightForDiscCache;
      boolean bool;
      if (i <= 0)
      {
        bool = false;
        if (j <= 0);
      }
      else
      {
        bool = downloadSizedImage(paramFile, i, j);
      }
      if (!bool)
        downloadImage(paramFile);
      this.configuration.discCache.put(this.uri, paramFile);
      String str = ImageDownloader.Scheme.FILE.wrap(paramFile.getAbsolutePath());
      return str;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
    }
    return this.uri;
  }

  private Bitmap tryLoadBitmap()
  {
    File localFile = getImageFileInDiscCache();
    Bitmap localBitmap = null;
    try
    {
      boolean bool = localFile.exists();
      localBitmap = null;
      if (bool)
      {
        log("Load image from disc cache [%s]");
        localBitmap = decodeImage(ImageDownloader.Scheme.FILE.wrap(localFile.getAbsolutePath()));
      }
      if ((localBitmap == null) || (localBitmap.getWidth() <= 0) || (localBitmap.getHeight() <= 0))
      {
        log("Load image from network [%s]");
        if (this.options.isCacheOnDisc());
        for (String str = tryCacheImageOnDisc(localFile); !checkTaskIsNotActual(); str = this.uri)
        {
          localBitmap = decodeImage(str);
          if ((localBitmap != null) && (localBitmap.getWidth() > 0) && (localBitmap.getHeight() > 0))
            break;
          fireImageLoadingFailedEvent(FailReason.FailType.DECODING_ERROR, null);
          return localBitmap;
        }
      }
    }
    catch (IllegalStateException localIllegalStateException)
    {
      fireImageLoadingFailedEvent(FailReason.FailType.NETWORK_DENIED, null);
      return localBitmap;
    }
    catch (IOException localIOException)
    {
      L.e(localIOException);
      fireImageLoadingFailedEvent(FailReason.FailType.IO_ERROR, localIOException);
      if (localFile.exists())
      {
        localFile.delete();
        return localBitmap;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      L.e(localOutOfMemoryError);
      fireImageLoadingFailedEvent(FailReason.FailType.OUT_OF_MEMORY, localOutOfMemoryError);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable);
      fireImageLoadingFailedEvent(FailReason.FailType.UNKNOWN, localThrowable);
    }
    return localBitmap;
  }

  private boolean waitIfPaused()
  {
    AtomicBoolean localAtomicBoolean = this.engine.getPause();
    if (localAtomicBoolean.get());
    try
    {
      log("ImageLoader is paused. Waiting...  [%s]");
      try
      {
        localAtomicBoolean.wait();
        log(".. Resume loading [%s]");
        return checkTaskIsNotActual();
      }
      catch (InterruptedException localInterruptedException)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.memoryCacheKey;
        L.e("Task was interrupted [%s]", arrayOfObject);
        return true;
      }
    }
    finally
    {
    }
  }

  String getLoadingUri()
  {
    return this.uri;
  }

  public void run()
  {
    if (waitIfPaused());
    while (true)
    {
      return;
      if (delayIfNeed())
        continue;
      ReentrantLock localReentrantLock = this.imageLoadingInfo.loadFromUriLock;
      log("Start display image task [%s]");
      if (localReentrantLock.isLocked())
        log("Image already is loading. Waiting... [%s]");
      localReentrantLock.lock();
      try
      {
        boolean bool1 = checkTaskIsNotActual();
        if (bool1)
          return;
        Object localObject2 = (Bitmap)this.configuration.memoryCache.get(this.memoryCacheKey);
        if (localObject2 == null)
        {
          Bitmap localBitmap = tryLoadBitmap();
          localObject2 = localBitmap;
          if (localObject2 == null)
            return;
          if (!checkTaskIsNotActual())
          {
            boolean bool2 = checkTaskIsInterrupted();
            if (!bool2);
          }
          else
          {
            return;
          }
          if (this.options.shouldPreProcess())
          {
            log("PreProcess image before caching in memory [%s]");
            localObject2 = this.options.getPreProcessor().process((Bitmap)localObject2);
            if (localObject2 == null)
              L.w("Pre-processor returned null [%s]", new Object[0]);
          }
          if ((localObject2 != null) && (this.options.isCacheInMemory()))
          {
            log("Cache image in memory [%s]");
            this.configuration.memoryCache.put(this.memoryCacheKey, localObject2);
          }
        }
        while (true)
        {
          if ((localObject2 != null) && (this.options.shouldPostProcess()))
          {
            log("PostProcess image before displaying [%s]");
            localObject2 = this.options.getPostProcessor().process((Bitmap)localObject2);
            if (localObject2 == null)
            {
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = this.memoryCacheKey;
              L.w("Pre-processor returned null [%s]", arrayOfObject);
            }
          }
          localReentrantLock.unlock();
          if ((checkTaskIsNotActual()) || (checkTaskIsInterrupted()))
            break;
          DisplayBitmapTask localDisplayBitmapTask = new DisplayBitmapTask((Bitmap)localObject2, this.imageLoadingInfo, this.engine);
          localDisplayBitmapTask.setLoggingEnabled(this.loggingEnabled);
          this.handler.post(localDisplayBitmapTask);
          return;
          log("...Get cached bitmap from memory after waiting. [%s]");
        }
      }
      finally
      {
        localReentrantLock.unlock();
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask
 * JD-Core Version:    0.6.2
 */