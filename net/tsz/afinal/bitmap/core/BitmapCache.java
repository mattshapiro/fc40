package net.tsz.afinal.bitmap.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class BitmapCache
{
  private static final boolean DEFAULT_CLEAR_DISK_CACHE_ON_START = false;
  private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
  private static final int DEFAULT_COMPRESS_QUALITY = 70;
  private static final boolean DEFAULT_DISK_CACHE_ENABLED = true;
  private static final int DEFAULT_DISK_CACHE_SIZE = 20971520;
  private static final boolean DEFAULT_INIT_DISK_CACHE_ON_CREATE = false;
  private static final boolean DEFAULT_MEM_CACHE_ENABLED = true;
  private static final int DEFAULT_MEM_CACHE_SIZE = 8388608;
  private static final int DISK_CACHE_INDEX = 0;
  private static final String TAG = "ImageCache";
  private ImageCacheParams mCacheParams;
  private final Object mDiskCacheLock = new Object();
  private boolean mDiskCacheStarting = true;
  private LruDiskCache mDiskLruCache;
  private LruMemoryCache<String, Bitmap> mMemoryCache;

  public BitmapCache(ImageCacheParams paramImageCacheParams)
  {
    init(paramImageCacheParams);
  }

  private void init(ImageCacheParams paramImageCacheParams)
  {
    this.mCacheParams = paramImageCacheParams;
    if (this.mCacheParams.memoryCacheEnabled)
      this.mMemoryCache = new LruMemoryCache(this.mCacheParams.memCacheSize)
      {
        protected int sizeOf(String paramAnonymousString, Bitmap paramAnonymousBitmap)
        {
          return BitmapCommonUtils.getBitmapSize(paramAnonymousBitmap);
        }
      };
    if (paramImageCacheParams.initDiskCacheOnCreate)
      initDiskCache();
  }

  // ERROR //
  public void addBitmapToCache(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 74	net/tsz/afinal/bitmap/core/BitmapCache:mMemoryCache	Lnet/tsz/afinal/bitmap/core/LruMemoryCache;
    //   13: ifnull +24 -> 37
    //   16: aload_0
    //   17: getfield 74	net/tsz/afinal/bitmap/core/BitmapCache:mMemoryCache	Lnet/tsz/afinal/bitmap/core/LruMemoryCache;
    //   20: aload_1
    //   21: invokevirtual 92	net/tsz/afinal/bitmap/core/LruMemoryCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   24: ifnonnull +13 -> 37
    //   27: aload_0
    //   28: getfield 74	net/tsz/afinal/bitmap/core/BitmapCache:mMemoryCache	Lnet/tsz/afinal/bitmap/core/LruMemoryCache;
    //   31: aload_1
    //   32: aload_2
    //   33: invokevirtual 96	net/tsz/afinal/bitmap/core/LruMemoryCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   36: pop
    //   37: aload_0
    //   38: getfield 50	net/tsz/afinal/bitmap/core/BitmapCache:mDiskCacheLock	Ljava/lang/Object;
    //   41: astore_3
    //   42: aload_3
    //   43: monitorenter
    //   44: aload_0
    //   45: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   48: ifnull +133 -> 181
    //   51: aload_0
    //   52: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   55: invokevirtual 104	net/tsz/afinal/bitmap/core/LruDiskCache:getDirectory	()Ljava/io/File;
    //   58: ifnull +123 -> 181
    //   61: aload_0
    //   62: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   65: invokevirtual 104	net/tsz/afinal/bitmap/core/LruDiskCache:getDirectory	()Ljava/io/File;
    //   68: invokevirtual 110	java/io/File:exists	()Z
    //   71: ifne +14 -> 85
    //   74: aload_0
    //   75: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   78: invokevirtual 104	net/tsz/afinal/bitmap/core/LruDiskCache:getDirectory	()Ljava/io/File;
    //   81: invokevirtual 113	java/io/File:mkdirs	()Z
    //   84: pop
    //   85: aload_1
    //   86: invokestatic 119	net/tsz/afinal/bitmap/core/FileNameGenerator:generator	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 5
    //   91: aconst_null
    //   92: astore 6
    //   94: aload_0
    //   95: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   98: aload 5
    //   100: invokevirtual 122	net/tsz/afinal/bitmap/core/LruDiskCache:get	(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    //   103: astore 15
    //   105: aconst_null
    //   106: astore 6
    //   108: aload 15
    //   110: ifnonnull +81 -> 191
    //   113: aload_0
    //   114: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   117: aload 5
    //   119: invokevirtual 126	net/tsz/afinal/bitmap/core/LruDiskCache:edit	(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    //   122: astore 16
    //   124: aconst_null
    //   125: astore 6
    //   127: aload 16
    //   129: ifnull +42 -> 171
    //   132: aload 16
    //   134: iconst_0
    //   135: invokevirtual 132	net/tsz/afinal/bitmap/core/LruDiskCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   138: astore 6
    //   140: aload_2
    //   141: aload_0
    //   142: getfield 59	net/tsz/afinal/bitmap/core/BitmapCache:mCacheParams	Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;
    //   145: getfield 135	net/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams:compressFormat	Landroid/graphics/Bitmap$CompressFormat;
    //   148: aload_0
    //   149: getfield 59	net/tsz/afinal/bitmap/core/BitmapCache:mCacheParams	Lnet/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams;
    //   152: getfield 138	net/tsz/afinal/bitmap/core/BitmapCache$ImageCacheParams:compressQuality	I
    //   155: aload 6
    //   157: invokevirtual 144	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   160: pop
    //   161: aload 16
    //   163: invokevirtual 147	net/tsz/afinal/bitmap/core/LruDiskCache$Editor:commit	()V
    //   166: aload 6
    //   168: invokevirtual 152	java/io/OutputStream:close	()V
    //   171: aload 6
    //   173: ifnull +8 -> 181
    //   176: aload 6
    //   178: invokevirtual 152	java/io/OutputStream:close	()V
    //   181: aload_3
    //   182: monitorexit
    //   183: return
    //   184: astore 4
    //   186: aload_3
    //   187: monitorexit
    //   188: aload 4
    //   190: athrow
    //   191: aload 15
    //   193: iconst_0
    //   194: invokevirtual 158	net/tsz/afinal/bitmap/core/LruDiskCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   197: invokevirtual 161	java/io/InputStream:close	()V
    //   200: aconst_null
    //   201: astore 6
    //   203: goto -32 -> 171
    //   206: astore 12
    //   208: ldc 25
    //   210: new 163	java/lang/StringBuilder
    //   213: dup
    //   214: ldc 165
    //   216: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: aload 12
    //   221: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   230: pop
    //   231: aload 6
    //   233: ifnull -52 -> 181
    //   236: aload 6
    //   238: invokevirtual 152	java/io/OutputStream:close	()V
    //   241: goto -60 -> 181
    //   244: astore 14
    //   246: goto -65 -> 181
    //   249: astore 9
    //   251: ldc 25
    //   253: new 163	java/lang/StringBuilder
    //   256: dup
    //   257: ldc 165
    //   259: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   262: aload 9
    //   264: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   273: pop
    //   274: aload 6
    //   276: ifnull -95 -> 181
    //   279: aload 6
    //   281: invokevirtual 152	java/io/OutputStream:close	()V
    //   284: goto -103 -> 181
    //   287: astore 11
    //   289: goto -108 -> 181
    //   292: astore 7
    //   294: aload 6
    //   296: ifnull +8 -> 304
    //   299: aload 6
    //   301: invokevirtual 152	java/io/OutputStream:close	()V
    //   304: aload 7
    //   306: athrow
    //   307: astore 8
    //   309: goto -5 -> 304
    //   312: astore 18
    //   314: goto -133 -> 181
    //
    // Exception table:
    //   from	to	target	type
    //   44	85	184	finally
    //   85	91	184	finally
    //   176	181	184	finally
    //   181	183	184	finally
    //   186	188	184	finally
    //   236	241	184	finally
    //   279	284	184	finally
    //   299	304	184	finally
    //   304	307	184	finally
    //   94	105	206	java/io/IOException
    //   113	124	206	java/io/IOException
    //   132	171	206	java/io/IOException
    //   191	200	206	java/io/IOException
    //   236	241	244	java/io/IOException
    //   94	105	249	java/lang/Exception
    //   113	124	249	java/lang/Exception
    //   132	171	249	java/lang/Exception
    //   191	200	249	java/lang/Exception
    //   279	284	287	java/io/IOException
    //   94	105	292	finally
    //   113	124	292	finally
    //   132	171	292	finally
    //   191	200	292	finally
    //   208	231	292	finally
    //   251	274	292	finally
    //   299	304	307	java/io/IOException
    //   176	181	312	java/io/IOException
  }

  public void clearCache()
  {
    clearMemoryCache();
    clearDiskCache();
  }

  public void clearCache(String paramString)
  {
    clearMemoryCache(paramString);
    clearDiskCache(paramString);
  }

  public void clearDiskCache()
  {
    synchronized (this.mDiskCacheLock)
    {
      this.mDiskCacheStarting = true;
      if (this.mDiskLruCache != null)
      {
        boolean bool = this.mDiskLruCache.isClosed();
        if (bool);
      }
      try
      {
        this.mDiskLruCache.delete();
        this.mDiskLruCache = null;
        initDiskCache();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("ImageCache", "clearCache - " + localIOException);
      }
    }
  }

  public void clearDiskCache(String paramString)
  {
    synchronized (this.mDiskCacheLock)
    {
      if (this.mDiskLruCache != null)
      {
        boolean bool = this.mDiskLruCache.isClosed();
        if (bool);
      }
      try
      {
        this.mDiskLruCache.remove(paramString);
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("ImageCache", "clearCache - " + localIOException);
      }
    }
  }

  public void clearMemoryCache()
  {
    if (this.mMemoryCache != null)
      this.mMemoryCache.evictAll();
  }

  public void clearMemoryCache(String paramString)
  {
    if (this.mMemoryCache != null)
      this.mMemoryCache.remove(paramString);
  }

  public void close()
  {
    synchronized (this.mDiskCacheLock)
    {
      LruDiskCache localLruDiskCache = this.mDiskLruCache;
      if (localLruDiskCache != null);
      try
      {
        if (!this.mDiskLruCache.isClosed())
        {
          this.mDiskLruCache.close();
          this.mDiskLruCache = null;
        }
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("ImageCache", "close - " + localIOException);
      }
    }
  }

  public void flush()
  {
    synchronized (this.mDiskCacheLock)
    {
      LruDiskCache localLruDiskCache = this.mDiskLruCache;
      if (localLruDiskCache != null);
      try
      {
        this.mDiskLruCache.flush();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("ImageCache", "flush - " + localIOException);
      }
    }
  }

  // ERROR //
  public Bitmap getBitmapFromDiskCache(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 119	net/tsz/afinal/bitmap/core/FileNameGenerator:generator	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 50	net/tsz/afinal/bitmap/core/BitmapCache:mDiskCacheLock	Ljava/lang/Object;
    //   9: astore_3
    //   10: aload_3
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 52	net/tsz/afinal/bitmap/core/BitmapCache:mDiskCacheStarting	Z
    //   16: ifne +70 -> 86
    //   19: aload_0
    //   20: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   23: astore 6
    //   25: aload 6
    //   27: ifnull +109 -> 136
    //   30: aconst_null
    //   31: astore 7
    //   33: aload_0
    //   34: getfield 98	net/tsz/afinal/bitmap/core/BitmapCache:mDiskLruCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   37: aload_2
    //   38: invokevirtual 122	net/tsz/afinal/bitmap/core/LruDiskCache:get	(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    //   41: astore 13
    //   43: aconst_null
    //   44: astore 7
    //   46: aload 13
    //   48: ifnull +114 -> 162
    //   51: aload 13
    //   53: iconst_0
    //   54: invokevirtual 158	net/tsz/afinal/bitmap/core/LruDiskCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   57: astore 7
    //   59: aload 7
    //   61: ifnull +101 -> 162
    //   64: aload 7
    //   66: invokestatic 228	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   69: astore 14
    //   71: aload 7
    //   73: ifnull +8 -> 81
    //   76: aload 7
    //   78: invokevirtual 161	java/io/InputStream:close	()V
    //   81: aload_3
    //   82: monitorexit
    //   83: aload 14
    //   85: areturn
    //   86: aload_0
    //   87: getfield 50	net/tsz/afinal/bitmap/core/BitmapCache:mDiskCacheLock	Ljava/lang/Object;
    //   90: invokevirtual 231	java/lang/Object:wait	()V
    //   93: goto -81 -> 12
    //   96: astore 5
    //   98: goto -86 -> 12
    //   101: astore 10
    //   103: ldc 25
    //   105: new 163	java/lang/StringBuilder
    //   108: dup
    //   109: ldc 233
    //   111: invokespecial 168	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload 10
    //   116: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 182	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   125: pop
    //   126: aload 7
    //   128: ifnull +8 -> 136
    //   131: aload 7
    //   133: invokevirtual 161	java/io/InputStream:close	()V
    //   136: aload_3
    //   137: monitorexit
    //   138: aconst_null
    //   139: areturn
    //   140: astore 8
    //   142: aload 7
    //   144: ifnull +8 -> 152
    //   147: aload 7
    //   149: invokevirtual 161	java/io/InputStream:close	()V
    //   152: aload 8
    //   154: athrow
    //   155: astore 4
    //   157: aload_3
    //   158: monitorexit
    //   159: aload 4
    //   161: athrow
    //   162: aload 7
    //   164: ifnull -28 -> 136
    //   167: aload 7
    //   169: invokevirtual 161	java/io/InputStream:close	()V
    //   172: goto -36 -> 136
    //   175: astore 16
    //   177: goto -41 -> 136
    //   180: astore 15
    //   182: goto -101 -> 81
    //   185: astore 12
    //   187: goto -51 -> 136
    //   190: astore 9
    //   192: goto -40 -> 152
    //
    // Exception table:
    //   from	to	target	type
    //   86	93	96	java/lang/InterruptedException
    //   33	43	101	java/io/IOException
    //   51	59	101	java/io/IOException
    //   64	71	101	java/io/IOException
    //   33	43	140	finally
    //   51	59	140	finally
    //   64	71	140	finally
    //   103	126	140	finally
    //   12	25	155	finally
    //   76	81	155	finally
    //   81	83	155	finally
    //   86	93	155	finally
    //   131	136	155	finally
    //   136	138	155	finally
    //   147	152	155	finally
    //   152	155	155	finally
    //   157	159	155	finally
    //   167	172	155	finally
    //   167	172	175	java/io/IOException
    //   76	81	180	java/io/IOException
    //   131	136	185	java/io/IOException
    //   147	152	190	java/io/IOException
  }

  public Bitmap getBitmapFromMemCache(String paramString)
  {
    if (this.mMemoryCache != null)
    {
      Bitmap localBitmap = (Bitmap)this.mMemoryCache.get(paramString);
      if (localBitmap != null)
        return localBitmap;
    }
    return null;
  }

  public void initDiskCache()
  {
    synchronized (this.mDiskCacheLock)
    {
      File localFile;
      if ((this.mDiskLruCache == null) || (this.mDiskLruCache.isClosed()))
      {
        localFile = this.mCacheParams.diskCacheDir;
        if ((this.mCacheParams.diskCacheEnabled) && (localFile != null))
        {
          if (!localFile.exists())
            localFile.mkdirs();
          long l = BitmapCommonUtils.getUsableSpace(localFile);
          int i = this.mCacheParams.diskCacheSize;
          if (l <= i);
        }
      }
      try
      {
        this.mDiskLruCache = LruDiskCache.open(localFile, 1, 1, this.mCacheParams.diskCacheSize);
        this.mDiskCacheStarting = false;
        this.mDiskCacheLock.notifyAll();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          this.mCacheParams.diskCacheDir = null;
          Log.e("ImageCache", "initDiskCache - " + localIOException);
        }
      }
    }
  }

  public void setCompressFormat(Bitmap.CompressFormat paramCompressFormat)
  {
    this.mCacheParams.setCompressFormat(paramCompressFormat);
  }

  public static class ImageCacheParams
  {
    public boolean clearDiskCacheOnStart = false;
    public Bitmap.CompressFormat compressFormat = BitmapCache.DEFAULT_COMPRESS_FORMAT;
    public int compressQuality = 70;
    public File diskCacheDir;
    public boolean diskCacheEnabled = true;
    public int diskCacheSize = 20971520;
    public boolean initDiskCacheOnCreate = false;
    public int memCacheSize = 8388608;
    public boolean memoryCacheEnabled = true;

    public ImageCacheParams(File paramFile)
    {
      this.diskCacheDir = paramFile;
    }

    public ImageCacheParams(String paramString)
    {
      this.diskCacheDir = new File(paramString);
    }

    private static int getMemoryClass(Context paramContext)
    {
      return ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    }

    public void setCompressFormat(Bitmap.CompressFormat paramCompressFormat)
    {
      this.compressFormat = paramCompressFormat;
    }

    public void setDiskCacheSize(int paramInt)
    {
      this.diskCacheSize = paramInt;
    }

    public void setMemCacheSize(int paramInt)
    {
      this.memCacheSize = paramInt;
    }

    public void setMemCacheSizePercent(Context paramContext, float paramFloat)
    {
      if ((paramFloat < 0.05F) || (paramFloat > 0.8F))
        throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
      this.memCacheSize = Math.round(1024.0F * (1024.0F * (paramFloat * getMemoryClass(paramContext))));
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.core.BitmapCache
 * JD-Core Version:    0.6.2
 */