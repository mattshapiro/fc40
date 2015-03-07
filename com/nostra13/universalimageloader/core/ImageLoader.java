package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.MemoryCacheUtil;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FakeBitmapDisplayer;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;
import java.util.concurrent.locks.ReentrantLock;

public class ImageLoader
{
  private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
  private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
  private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
  static final String LOG_DESTROY = "Destroy ImageLoader";
  static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
  static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
  public static final String TAG = ImageLoader.class.getSimpleName();
  private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
  private static volatile ImageLoader instance;
  private ImageLoaderConfiguration configuration;
  private final ImageLoadingListener emptyListener = new SimpleImageLoadingListener();
  private ImageLoaderEngine engine;
  private final BitmapDisplayer fakeBitmapDisplayer = new FakeBitmapDisplayer();

  private void checkConfiguration()
  {
    if (this.configuration == null)
      throw new IllegalStateException("ImageLoader must be init with configuration before using");
  }

  public static ImageLoader getInstance()
  {
    if (instance == null);
    try
    {
      if (instance == null)
        instance = new ImageLoader();
      return instance;
    }
    finally
    {
    }
  }

  public void cancelDisplayTask(ImageView paramImageView)
  {
    this.engine.cancelDisplayTaskFor(paramImageView);
  }

  public void clearDiscCache()
  {
    checkConfiguration();
    this.configuration.discCache.clear();
  }

  public void clearMemoryCache()
  {
    checkConfiguration();
    this.configuration.memoryCache.clear();
  }

  public void denyNetworkDownloads(boolean paramBoolean)
  {
    this.engine.denyNetworkDownloads(paramBoolean);
  }

  public void destroy()
  {
    if ((this.configuration != null) && (this.configuration.loggingEnabled))
      L.d("Destroy ImageLoader", new Object[0]);
    stop();
    this.engine = null;
    this.configuration = null;
  }

  public void displayImage(String paramString, ImageView paramImageView)
  {
    displayImage(paramString, paramImageView, null, null);
  }

  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions)
  {
    displayImage(paramString, paramImageView, paramDisplayImageOptions, null);
  }

  public void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    checkConfiguration();
    if (paramImageView == null)
      throw new IllegalArgumentException("Wrong arguments were passed to displayImage() method (ImageView reference must not be null)");
    if (paramImageLoadingListener == null)
      paramImageLoadingListener = this.emptyListener;
    if (paramDisplayImageOptions == null)
      paramDisplayImageOptions = this.configuration.defaultDisplayImageOptions;
    if (TextUtils.isEmpty(paramString))
    {
      this.engine.cancelDisplayTaskFor(paramImageView);
      paramImageLoadingListener.onLoadingStarted(paramString, paramImageView);
      if (paramDisplayImageOptions.shouldShowImageForEmptyUri())
        paramImageView.setImageResource(paramDisplayImageOptions.getImageForEmptyUri());
      while (true)
      {
        paramImageLoadingListener.onLoadingComplete(paramString, paramImageView, null);
        return;
        paramImageView.setImageBitmap(null);
      }
    }
    ImageSize localImageSize = ImageSizeUtils.defineTargetSizeForView(paramImageView, this.configuration.maxImageWidthForMemoryCache, this.configuration.maxImageHeightForMemoryCache);
    String str = MemoryCacheUtil.generateKey(paramString, localImageSize);
    this.engine.prepareDisplayTaskFor(paramImageView, str);
    paramImageLoadingListener.onLoadingStarted(paramString, paramImageView);
    Bitmap localBitmap = (Bitmap)this.configuration.memoryCache.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (this.configuration.loggingEnabled)
        L.i("Load image from memory cache [%s]", new Object[] { str });
      if (paramDisplayImageOptions.shouldPostProcess())
      {
        ReentrantLock localReentrantLock2 = this.engine.getLockForUri(paramString);
        ImageLoadingInfo localImageLoadingInfo2 = new ImageLoadingInfo(paramString, paramImageView, localImageSize, str, paramDisplayImageOptions, paramImageLoadingListener, localReentrantLock2);
        ProcessAndDisplayImageTask localProcessAndDisplayImageTask = new ProcessAndDisplayImageTask(this.engine, localBitmap, localImageLoadingInfo2, paramDisplayImageOptions.getHandler());
        this.engine.submit(localProcessAndDisplayImageTask);
        return;
      }
      paramDisplayImageOptions.getDisplayer().display(localBitmap, paramImageView);
      paramImageLoadingListener.onLoadingComplete(paramString, paramImageView, localBitmap);
      return;
    }
    if (paramDisplayImageOptions.shouldShowStubImage())
      paramImageView.setImageResource(paramDisplayImageOptions.getStubImage());
    while (true)
    {
      ReentrantLock localReentrantLock1 = this.engine.getLockForUri(paramString);
      ImageLoadingInfo localImageLoadingInfo1 = new ImageLoadingInfo(paramString, paramImageView, localImageSize, str, paramDisplayImageOptions, paramImageLoadingListener, localReentrantLock1);
      LoadAndDisplayImageTask localLoadAndDisplayImageTask = new LoadAndDisplayImageTask(this.engine, localImageLoadingInfo1, paramDisplayImageOptions.getHandler());
      this.engine.submit(localLoadAndDisplayImageTask);
      return;
      if (paramDisplayImageOptions.isResetViewBeforeLoading())
        paramImageView.setImageBitmap(null);
    }
  }

  public void displayImage(String paramString, ImageView paramImageView, ImageLoadingListener paramImageLoadingListener)
  {
    displayImage(paramString, paramImageView, null, paramImageLoadingListener);
  }

  public DiscCacheAware getDiscCache()
  {
    checkConfiguration();
    return this.configuration.discCache;
  }

  public String getLoadingUriForView(ImageView paramImageView)
  {
    return this.engine.getLoadingUriForView(paramImageView);
  }

  public MemoryCacheAware<String, Bitmap> getMemoryCache()
  {
    checkConfiguration();
    return this.configuration.memoryCache;
  }

  public void handleSlowNetwork(boolean paramBoolean)
  {
    this.engine.handleSlowNetwork(paramBoolean);
  }

  public void init(ImageLoaderConfiguration paramImageLoaderConfiguration)
  {
    if (paramImageLoaderConfiguration == null)
      try
      {
        throw new IllegalArgumentException("ImageLoader configuration can not be initialized with null");
      }
      finally
      {
      }
    if (this.configuration == null)
    {
      if (paramImageLoaderConfiguration.loggingEnabled)
        L.d("Initialize ImageLoader with configuration", new Object[0]);
      this.engine = new ImageLoaderEngine(paramImageLoaderConfiguration);
      this.configuration = paramImageLoaderConfiguration;
    }
    while (true)
    {
      return;
      L.w("Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.", new Object[0]);
    }
  }

  public boolean isInited()
  {
    return this.configuration != null;
  }

  public void loadImage(String paramString, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, null, paramDisplayImageOptions, paramImageLoadingListener);
  }

  public void loadImage(String paramString, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, null, null, paramImageLoadingListener);
  }

  public void loadImage(String paramString, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener)
  {
    checkConfiguration();
    if (paramImageSize == null)
      paramImageSize = new ImageSize(this.configuration.maxImageWidthForMemoryCache, this.configuration.maxImageHeightForMemoryCache);
    if (paramDisplayImageOptions == null)
      paramDisplayImageOptions = this.configuration.defaultDisplayImageOptions;
    if ((paramDisplayImageOptions.getDisplayer() instanceof FakeBitmapDisplayer));
    for (DisplayImageOptions localDisplayImageOptions = paramDisplayImageOptions; ; localDisplayImageOptions = new DisplayImageOptions.Builder().cloneFrom(paramDisplayImageOptions).displayer(this.fakeBitmapDisplayer).build())
    {
      ImageView localImageView = new ImageView(this.configuration.context);
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramImageSize.getWidth(), paramImageSize.getHeight()));
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      displayImage(paramString, localImageView, localDisplayImageOptions, paramImageLoadingListener);
      return;
    }
  }

  public void loadImage(String paramString, ImageSize paramImageSize, ImageLoadingListener paramImageLoadingListener)
  {
    loadImage(paramString, paramImageSize, null, paramImageLoadingListener);
  }

  public void pause()
  {
    this.engine.pause();
  }

  public void resume()
  {
    this.engine.resume();
  }

  public void stop()
  {
    this.engine.stop();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoader
 * JD-Core Version:    0.6.2
 */