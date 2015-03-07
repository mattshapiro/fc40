package net.tsz.afinal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.tsz.afinal.bitmap.core.BitmapCache;
import net.tsz.afinal.bitmap.core.BitmapCache.ImageCacheParams;
import net.tsz.afinal.bitmap.core.BitmapCommonUtils;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;
import net.tsz.afinal.bitmap.core.BitmapProcess;
import net.tsz.afinal.bitmap.display.Displayer;
import net.tsz.afinal.bitmap.display.SimpleDisplayer;
import net.tsz.afinal.bitmap.download.Downloader;
import net.tsz.afinal.bitmap.download.SimpleHttpDownloader;
import net.tsz.afinal.core.AsyncTask;

public class FinalBitmap
{
  private static ExecutorService bitmapLoadAndDisplayExecutor;
  private static FinalBitmap mFinalBitmap;
  private static BitmapCache mImageCache;
  private HashMap<String, BitmapDisplayConfig> configMap = new HashMap();
  private FinalBitmapConfig mConfig;
  private Context mContext;
  private boolean mExitTasksEarly = false;
  private boolean mPauseWork = false;
  private final Object mPauseWorkLock = new Object();

  private FinalBitmap(Context paramContext)
  {
    this.mContext = paramContext;
    this.mConfig = new FinalBitmapConfig(paramContext);
    configDiskCachePath(BitmapCommonUtils.getDiskCacheDir(paramContext, "afinalCache").getAbsolutePath());
    configDisplayer(new SimpleDisplayer());
    configDownlader(new SimpleHttpDownloader());
  }

  public static boolean checkImageTask(Object paramObject, ImageView paramImageView)
  {
    BitmapLoadAndDisplayTask localBitmapLoadAndDisplayTask = getBitmapTaskFromImageView(paramImageView);
    if (localBitmapLoadAndDisplayTask != null)
    {
      Object localObject = localBitmapLoadAndDisplayTask.data;
      if ((localObject == null) || (!localObject.equals(paramObject)))
        localBitmapLoadAndDisplayTask.cancel(true);
    }
    else
    {
      return true;
    }
    return false;
  }

  private void clearCacheInBackgroud(String paramString)
  {
    if (mImageCache != null)
      mImageCache.clearCache(paramString);
  }

  private void clearCacheInternalInBackgroud()
  {
    if (mImageCache != null)
      mImageCache.clearCache();
    if ((this.mConfig != null) && (this.mConfig.bitmapProcess != null))
      this.mConfig.bitmapProcess.clearCacheInternal();
  }

  private void clearDiskCacheInBackgroud()
  {
    if (mImageCache != null)
      mImageCache.clearDiskCache();
    if ((this.mConfig != null) && (this.mConfig.bitmapProcess != null))
      this.mConfig.bitmapProcess.clearCacheInternal();
  }

  private void clearDiskCacheInBackgroud(String paramString)
  {
    if (mImageCache != null)
      mImageCache.clearDiskCache(paramString);
  }

  private void clearMemoryCacheInBackgroud()
  {
    if (mImageCache != null)
      mImageCache.clearMemoryCache();
  }

  private void clearMemoryCacheInBackgroud(String paramString)
  {
    if (mImageCache != null)
      mImageCache.clearMemoryCache(paramString);
  }

  private void closeCacheInternalInBackgroud()
  {
    if (mImageCache != null)
    {
      mImageCache.close();
      mImageCache = null;
    }
    if ((this.mConfig != null) && (this.mConfig.bitmapProcess != null))
      this.mConfig.bitmapProcess.clearCacheInternal();
  }

  private FinalBitmap configBitmapLoadThreadSize(int paramInt)
  {
    if (paramInt >= 1)
      this.mConfig.poolSize = paramInt;
    return this;
  }

  private FinalBitmap configDiskCachePath(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      this.mConfig.cachePath = paramString;
    return this;
  }

  private FinalBitmap configDiskCacheSize(int paramInt)
  {
    this.mConfig.diskCacheSize = paramInt;
    return this;
  }

  private FinalBitmap configMemoryCachePercent(float paramFloat)
  {
    this.mConfig.memCacheSizePercent = paramFloat;
    return this;
  }

  private FinalBitmap configMemoryCacheSize(int paramInt)
  {
    this.mConfig.memCacheSize = paramInt;
    return this;
  }

  public static FinalBitmap create(Context paramContext)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  public static FinalBitmap create(Context paramContext, String paramString)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.configDiskCachePath(paramString);
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  public static FinalBitmap create(Context paramContext, String paramString, float paramFloat)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.configDiskCachePath(paramString);
      mFinalBitmap.configMemoryCachePercent(paramFloat);
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  public static FinalBitmap create(Context paramContext, String paramString, float paramFloat, int paramInt)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.configDiskCachePath(paramString);
      mFinalBitmap.configBitmapLoadThreadSize(paramInt);
      mFinalBitmap.configMemoryCachePercent(paramFloat);
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  public static FinalBitmap create(Context paramContext, String paramString, float paramFloat, int paramInt1, int paramInt2)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.configDiskCachePath(paramString);
      mFinalBitmap.configBitmapLoadThreadSize(paramInt2);
      mFinalBitmap.configMemoryCachePercent(paramFloat);
      mFinalBitmap.configDiskCacheSize(paramInt1);
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  public static FinalBitmap create(Context paramContext, String paramString, int paramInt)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.configDiskCachePath(paramString);
      mFinalBitmap.configMemoryCacheSize(paramInt);
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  public static FinalBitmap create(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.configDiskCachePath(paramString);
      mFinalBitmap.configBitmapLoadThreadSize(paramInt2);
      mFinalBitmap.configMemoryCacheSize(paramInt1);
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  public static FinalBitmap create(Context paramContext, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (mFinalBitmap == null)
    {
      mFinalBitmap = new FinalBitmap(paramContext.getApplicationContext());
      mFinalBitmap.configDiskCachePath(paramString);
      mFinalBitmap.configBitmapLoadThreadSize(paramInt3);
      mFinalBitmap.configMemoryCacheSize(paramInt1);
      mFinalBitmap.configDiskCacheSize(paramInt2);
      mFinalBitmap.init();
    }
    return mFinalBitmap;
  }

  private void doDisplay(ImageView paramImageView, String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramImageView == null));
    do
    {
      return;
      if (paramBitmapDisplayConfig == null)
        paramBitmapDisplayConfig = this.mConfig.defaultDisplayConfig;
      BitmapCache localBitmapCache = mImageCache;
      Bitmap localBitmap = null;
      if (localBitmapCache != null)
        localBitmap = mImageCache.getBitmapFromMemCache(paramString);
      if (localBitmap != null)
      {
        paramImageView.setImageBitmap(localBitmap);
        return;
      }
    }
    while (!checkImageTask(paramString, paramImageView));
    BitmapLoadAndDisplayTask localBitmapLoadAndDisplayTask = new BitmapLoadAndDisplayTask(paramImageView, paramBitmapDisplayConfig);
    paramImageView.setImageDrawable(new AsyncDrawable(this.mContext.getResources(), paramBitmapDisplayConfig.getLoadingBitmap(), localBitmapLoadAndDisplayTask));
    localBitmapLoadAndDisplayTask.executeOnExecutor(bitmapLoadAndDisplayExecutor, new Object[] { paramString });
  }

  private void flushCacheInternalInBackgroud()
  {
    if (mImageCache != null)
      mImageCache.flush();
    if ((this.mConfig != null) && (this.mConfig.bitmapProcess != null))
      this.mConfig.bitmapProcess.flushCacheInternal();
  }

  private static BitmapLoadAndDisplayTask getBitmapTaskFromImageView(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      Drawable localDrawable = paramImageView.getDrawable();
      if ((localDrawable instanceof AsyncDrawable))
        return ((AsyncDrawable)localDrawable).getBitmapWorkerTask();
    }
    return null;
  }

  private BitmapDisplayConfig getDisplayConfig()
  {
    BitmapDisplayConfig localBitmapDisplayConfig = new BitmapDisplayConfig();
    localBitmapDisplayConfig.setAnimation(this.mConfig.defaultDisplayConfig.getAnimation());
    localBitmapDisplayConfig.setAnimationType(this.mConfig.defaultDisplayConfig.getAnimationType());
    localBitmapDisplayConfig.setBitmapHeight(this.mConfig.defaultDisplayConfig.getBitmapHeight());
    localBitmapDisplayConfig.setBitmapWidth(this.mConfig.defaultDisplayConfig.getBitmapWidth());
    localBitmapDisplayConfig.setLoadfailBitmap(this.mConfig.defaultDisplayConfig.getLoadfailBitmap());
    localBitmapDisplayConfig.setLoadingBitmap(this.mConfig.defaultDisplayConfig.getLoadingBitmap());
    return localBitmapDisplayConfig;
  }

  private FinalBitmap init()
  {
    this.mConfig.init();
    BitmapCache.ImageCacheParams localImageCacheParams = new BitmapCache.ImageCacheParams(this.mConfig.cachePath);
    if ((this.mConfig.memCacheSizePercent > 0.05D) && (this.mConfig.memCacheSizePercent < 0.8D))
      localImageCacheParams.setMemCacheSizePercent(this.mContext, this.mConfig.memCacheSizePercent);
    while (true)
    {
      if (this.mConfig.diskCacheSize > 5242880)
        localImageCacheParams.setDiskCacheSize(this.mConfig.diskCacheSize);
      mImageCache = new BitmapCache(localImageCacheParams);
      bitmapLoadAndDisplayExecutor = Executors.newFixedThreadPool(this.mConfig.poolSize, new ThreadFactory()
      {
        public Thread newThread(Runnable paramAnonymousRunnable)
        {
          Thread localThread = new Thread(paramAnonymousRunnable);
          localThread.setPriority(4);
          return localThread;
        }
      });
      CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(1);
      localCacheExecutecTask.execute(arrayOfObject);
      return this;
      if (this.mConfig.memCacheSize > 2097152)
        localImageCacheParams.setMemCacheSize(this.mConfig.memCacheSize);
      else
        localImageCacheParams.setMemCacheSizePercent(this.mContext, 0.3F);
    }
  }

  private void initDiskCacheInternalInBackgroud()
  {
    if (mImageCache != null)
      mImageCache.initDiskCache();
    if ((this.mConfig != null) && (this.mConfig.bitmapProcess != null))
      this.mConfig.bitmapProcess.initHttpDiskCache();
  }

  private Bitmap processBitmap(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    if ((this.mConfig != null) && (this.mConfig.bitmapProcess != null))
      return this.mConfig.bitmapProcess.processBitmap(paramString, paramBitmapDisplayConfig);
    return null;
  }

  public void clearCache()
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0);
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public void clearCache(String paramString)
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(6);
    arrayOfObject[1] = paramString;
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public void clearDiskCache()
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(5);
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public void clearDiskCache(String paramString)
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(8);
    arrayOfObject[1] = paramString;
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public void clearMemoryCache()
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(4);
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public void clearMemoryCache(String paramString)
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(7);
    arrayOfObject[1] = paramString;
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public void closeCache()
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(3);
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public FinalBitmap configBitmapMaxHeight(int paramInt)
  {
    this.mConfig.defaultDisplayConfig.setBitmapHeight(paramInt);
    return this;
  }

  public FinalBitmap configBitmapMaxWidth(int paramInt)
  {
    this.mConfig.defaultDisplayConfig.setBitmapWidth(paramInt);
    return this;
  }

  public FinalBitmap configCalculateBitmapSizeWhenDecode(boolean paramBoolean)
  {
    if ((this.mConfig != null) && (this.mConfig.bitmapProcess != null))
      this.mConfig.bitmapProcess.configCalculateBitmap(paramBoolean);
    return this;
  }

  public void configCompressFormat(Bitmap.CompressFormat paramCompressFormat)
  {
    mImageCache.setCompressFormat(paramCompressFormat);
  }

  public FinalBitmap configDisplayer(Displayer paramDisplayer)
  {
    this.mConfig.displayer = paramDisplayer;
    return this;
  }

  public FinalBitmap configDownlader(Downloader paramDownloader)
  {
    this.mConfig.downloader = paramDownloader;
    return this;
  }

  public FinalBitmap configLoadfailImage(int paramInt)
  {
    this.mConfig.defaultDisplayConfig.setLoadfailBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), paramInt));
    return this;
  }

  public FinalBitmap configLoadfailImage(Bitmap paramBitmap)
  {
    this.mConfig.defaultDisplayConfig.setLoadfailBitmap(paramBitmap);
    return this;
  }

  public FinalBitmap configLoadingImage(int paramInt)
  {
    this.mConfig.defaultDisplayConfig.setLoadingBitmap(BitmapFactory.decodeResource(this.mContext.getResources(), paramInt));
    return this;
  }

  public FinalBitmap configLoadingImage(Bitmap paramBitmap)
  {
    this.mConfig.defaultDisplayConfig.setLoadingBitmap(paramBitmap);
    return this;
  }

  public void display(ImageView paramImageView, String paramString)
  {
    doDisplay(paramImageView, paramString, null);
  }

  public void display(ImageView paramImageView, String paramString, int paramInt1, int paramInt2)
  {
    BitmapDisplayConfig localBitmapDisplayConfig = (BitmapDisplayConfig)this.configMap.get(paramInt1 + "_" + paramInt2);
    if (localBitmapDisplayConfig == null)
    {
      localBitmapDisplayConfig = getDisplayConfig();
      localBitmapDisplayConfig.setBitmapHeight(paramInt2);
      localBitmapDisplayConfig.setBitmapWidth(paramInt1);
      this.configMap.put(paramInt1 + "_" + paramInt2, localBitmapDisplayConfig);
    }
    doDisplay(paramImageView, paramString, localBitmapDisplayConfig);
  }

  public void display(ImageView paramImageView, String paramString, int paramInt1, int paramInt2, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    BitmapDisplayConfig localBitmapDisplayConfig = (BitmapDisplayConfig)this.configMap.get(paramInt1 + "_" + paramInt2 + "_" + String.valueOf(paramBitmap1) + "_" + String.valueOf(paramBitmap2));
    if (localBitmapDisplayConfig == null)
    {
      localBitmapDisplayConfig = getDisplayConfig();
      localBitmapDisplayConfig.setBitmapHeight(paramInt2);
      localBitmapDisplayConfig.setBitmapWidth(paramInt1);
      localBitmapDisplayConfig.setLoadingBitmap(paramBitmap1);
      localBitmapDisplayConfig.setLoadfailBitmap(paramBitmap2);
      this.configMap.put(paramInt1 + "_" + paramInt2 + "_" + String.valueOf(paramBitmap1) + "_" + String.valueOf(paramBitmap2), localBitmapDisplayConfig);
    }
    doDisplay(paramImageView, paramString, localBitmapDisplayConfig);
  }

  public void display(ImageView paramImageView, String paramString, Bitmap paramBitmap)
  {
    BitmapDisplayConfig localBitmapDisplayConfig = (BitmapDisplayConfig)this.configMap.get(String.valueOf(paramBitmap));
    if (localBitmapDisplayConfig == null)
    {
      localBitmapDisplayConfig = getDisplayConfig();
      localBitmapDisplayConfig.setLoadingBitmap(paramBitmap);
      this.configMap.put(String.valueOf(paramBitmap), localBitmapDisplayConfig);
    }
    doDisplay(paramImageView, paramString, localBitmapDisplayConfig);
  }

  public void display(ImageView paramImageView, String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    BitmapDisplayConfig localBitmapDisplayConfig = (BitmapDisplayConfig)this.configMap.get(String.valueOf(paramBitmap1) + "_" + String.valueOf(paramBitmap2));
    if (localBitmapDisplayConfig == null)
    {
      localBitmapDisplayConfig = getDisplayConfig();
      localBitmapDisplayConfig.setLoadingBitmap(paramBitmap1);
      localBitmapDisplayConfig.setLoadfailBitmap(paramBitmap2);
      this.configMap.put(String.valueOf(paramBitmap1) + "_" + String.valueOf(paramBitmap2), localBitmapDisplayConfig);
    }
    doDisplay(paramImageView, paramString, localBitmapDisplayConfig);
  }

  public void display(ImageView paramImageView, String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    doDisplay(paramImageView, paramString, paramBitmapDisplayConfig);
  }

  public void exitTasksEarly(boolean paramBoolean)
  {
    this.mExitTasksEarly = paramBoolean;
    if (paramBoolean)
      pauseWork(false);
  }

  public void flushCache()
  {
    CacheExecutecTask localCacheExecutecTask = new CacheExecutecTask(null);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(2);
    localCacheExecutecTask.execute(arrayOfObject);
  }

  public Bitmap getBitmapFromCache(String paramString)
  {
    Bitmap localBitmap = getBitmapFromMemoryCache(paramString);
    if (localBitmap == null)
      localBitmap = getBitmapFromDiskCache(paramString);
    return localBitmap;
  }

  public Bitmap getBitmapFromDiskCache(String paramString)
  {
    return mImageCache.getBitmapFromDiskCache(paramString);
  }

  public Bitmap getBitmapFromMemoryCache(String paramString)
  {
    return mImageCache.getBitmapFromMemCache(paramString);
  }

  public void onDestroy()
  {
    closeCache();
  }

  public void onPause()
  {
    setExitTasksEarly(true);
    flushCache();
  }

  public void onResume()
  {
    setExitTasksEarly(false);
  }

  public void pauseWork(boolean paramBoolean)
  {
    synchronized (this.mPauseWorkLock)
    {
      this.mPauseWork = paramBoolean;
      if (!this.mPauseWork)
        this.mPauseWorkLock.notifyAll();
      return;
    }
  }

  public void setExitTasksEarly(boolean paramBoolean)
  {
    this.mExitTasksEarly = paramBoolean;
  }

  private static class AsyncDrawable extends BitmapDrawable
  {
    private final WeakReference<FinalBitmap.BitmapLoadAndDisplayTask> bitmapWorkerTaskReference;

    public AsyncDrawable(Resources paramResources, Bitmap paramBitmap, FinalBitmap.BitmapLoadAndDisplayTask paramBitmapLoadAndDisplayTask)
    {
      super(paramBitmap);
      this.bitmapWorkerTaskReference = new WeakReference(paramBitmapLoadAndDisplayTask);
    }

    public FinalBitmap.BitmapLoadAndDisplayTask getBitmapWorkerTask()
    {
      return (FinalBitmap.BitmapLoadAndDisplayTask)this.bitmapWorkerTaskReference.get();
    }
  }

  private class BitmapLoadAndDisplayTask extends AsyncTask<Object, Void, Bitmap>
  {
    private Object data;
    private final BitmapDisplayConfig displayConfig;
    private final WeakReference<ImageView> imageViewReference;

    public BitmapLoadAndDisplayTask(ImageView paramBitmapDisplayConfig, BitmapDisplayConfig arg3)
    {
      this.imageViewReference = new WeakReference(paramBitmapDisplayConfig);
      Object localObject;
      this.displayConfig = localObject;
    }

    private ImageView getAttachedImageView()
    {
      ImageView localImageView = (ImageView)this.imageViewReference.get();
      if (this == FinalBitmap.getBitmapTaskFromImageView(localImageView))
        return localImageView;
      return null;
    }

    protected Bitmap doInBackground(Object[] paramArrayOfObject)
    {
      this.data = paramArrayOfObject[0];
      String str = String.valueOf(this.data);
      synchronized (FinalBitmap.this.mPauseWorkLock)
      {
        while (true)
        {
          if ((!FinalBitmap.this.mPauseWork) || (isCancelled()))
          {
            BitmapCache localBitmapCache = FinalBitmap.mImageCache;
            Bitmap localBitmap = null;
            if (localBitmapCache != null)
            {
              boolean bool1 = isCancelled();
              localBitmap = null;
              if (!bool1)
              {
                ImageView localImageView = getAttachedImageView();
                localBitmap = null;
                if (localImageView != null)
                {
                  boolean bool2 = FinalBitmap.this.mExitTasksEarly;
                  localBitmap = null;
                  if (!bool2)
                    localBitmap = FinalBitmap.mImageCache.getBitmapFromDiskCache(str);
                }
              }
            }
            if ((localBitmap == null) && (!isCancelled()) && (getAttachedImageView() != null) && (!FinalBitmap.this.mExitTasksEarly))
              localBitmap = FinalBitmap.this.processBitmap(str, this.displayConfig);
            if ((localBitmap != null) && (FinalBitmap.mImageCache != null))
              FinalBitmap.mImageCache.addBitmapToCache(str, localBitmap);
            return localBitmap;
          }
          try
          {
            FinalBitmap.this.mPauseWorkLock.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
          }
        }
      }
    }

    protected void onCancelled(Bitmap paramBitmap)
    {
      super.onCancelled(paramBitmap);
      synchronized (FinalBitmap.this.mPauseWorkLock)
      {
        FinalBitmap.this.mPauseWorkLock.notifyAll();
        return;
      }
    }

    protected void onPostExecute(Bitmap paramBitmap)
    {
      if ((isCancelled()) || (FinalBitmap.this.mExitTasksEarly))
        paramBitmap = null;
      ImageView localImageView = getAttachedImageView();
      if ((paramBitmap != null) && (localImageView != null))
        FinalBitmap.this.mConfig.displayer.loadCompletedisplay(localImageView, paramBitmap, this.displayConfig);
      while ((paramBitmap != null) || (localImageView == null))
        return;
      FinalBitmap.this.mConfig.displayer.loadFailDisplay(localImageView, this.displayConfig.getLoadfailBitmap());
    }
  }

  private class CacheExecutecTask extends AsyncTask<Object, Void, Void>
  {
    public static final int MESSAGE_CLEAR = 0;
    public static final int MESSAGE_CLEAR_DISK = 5;
    public static final int MESSAGE_CLEAR_KEY = 6;
    public static final int MESSAGE_CLEAR_KEY_IN_DISK = 8;
    public static final int MESSAGE_CLEAR_KEY_IN_MEMORY = 7;
    public static final int MESSAGE_CLEAR_MEMORY = 4;
    public static final int MESSAGE_CLOSE = 3;
    public static final int MESSAGE_FLUSH = 2;
    public static final int MESSAGE_INIT_DISK_CACHE = 1;

    private CacheExecutecTask()
    {
    }

    protected Void doInBackground(Object[] paramArrayOfObject)
    {
      switch (((Integer)paramArrayOfObject[0]).intValue())
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      }
      while (true)
      {
        return null;
        FinalBitmap.this.clearCacheInternalInBackgroud();
        continue;
        FinalBitmap.this.initDiskCacheInternalInBackgroud();
        continue;
        FinalBitmap.this.clearMemoryCacheInBackgroud();
        FinalBitmap.this.flushCacheInternalInBackgroud();
        continue;
        FinalBitmap.this.clearMemoryCacheInBackgroud();
        FinalBitmap.this.closeCacheInternalInBackgroud();
        FinalBitmap.this.clearMemoryCacheInBackgroud();
        continue;
        FinalBitmap.this.clearDiskCacheInBackgroud();
        continue;
        FinalBitmap.this.clearCacheInBackgroud(String.valueOf(paramArrayOfObject[1]));
        continue;
        FinalBitmap.this.clearMemoryCacheInBackgroud(String.valueOf(paramArrayOfObject[1]));
        continue;
        FinalBitmap.this.clearDiskCacheInBackgroud(String.valueOf(paramArrayOfObject[1]));
      }
    }
  }

  private class FinalBitmapConfig
  {
    public BitmapProcess bitmapProcess;
    public String cachePath;
    public BitmapDisplayConfig defaultDisplayConfig = new BitmapDisplayConfig();
    public int diskCacheSize;
    public Displayer displayer;
    public Downloader downloader;
    public int memCacheSize;
    public float memCacheSizePercent;
    public int originalDiskCacheSize = 31457280;
    public int poolSize = 3;

    public FinalBitmapConfig(Context arg2)
    {
      this.defaultDisplayConfig.setAnimation(null);
      this.defaultDisplayConfig.setAnimationType(1);
      Object localObject;
      int i = (int)Math.floor(localObject.getResources().getDisplayMetrics().widthPixels / 4);
      this.defaultDisplayConfig.setBitmapHeight(i);
      this.defaultDisplayConfig.setBitmapWidth(i);
    }

    public void init()
    {
      if (this.downloader == null)
        this.downloader = new SimpleHttpDownloader();
      if (this.displayer == null)
        this.displayer = new SimpleDisplayer();
      this.bitmapProcess = new BitmapProcess(this.downloader, this.cachePath, this.originalDiskCacheSize);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.FinalBitmap
 * JD-Core Version:    0.6.2
 */