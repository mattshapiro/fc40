package net.tsz.afinal.bitmap.core;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import net.tsz.afinal.bitmap.download.Downloader;

public class BitmapProcess
{
  private static final int DEFAULT_CACHE_SIZE = 20971520;
  private static final int DISK_CACHE_INDEX = 0;
  private static final String TAG = "BitmapProcess";
  private int cacheSize;
  private Downloader downloader;
  private final Object mHttpDiskCacheLock = new Object();
  private boolean mHttpDiskCacheStarting = true;
  private File mOriginalCacheDir;
  private LruDiskCache mOriginalDiskCache;
  private boolean neverCalculate = false;

  public BitmapProcess(Downloader paramDownloader, String paramString, int paramInt)
  {
    this.mOriginalCacheDir = new File(paramString + "/original");
    this.downloader = paramDownloader;
    if (paramInt <= 0)
      paramInt = 20971520;
    this.cacheSize = paramInt;
  }

  public void clearCacheInternal()
  {
    synchronized (this.mHttpDiskCacheLock)
    {
      if (this.mOriginalDiskCache != null)
      {
        boolean bool = this.mOriginalDiskCache.isClosed();
        if (bool);
      }
      try
      {
        this.mOriginalDiskCache.delete();
        this.mOriginalDiskCache = null;
        this.mHttpDiskCacheStarting = true;
        initHttpDiskCache();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("BitmapProcess", "clearCacheInternal - " + localIOException);
      }
    }
  }

  public void closeCacheInternal()
  {
    synchronized (this.mHttpDiskCacheLock)
    {
      LruDiskCache localLruDiskCache = this.mOriginalDiskCache;
      if (localLruDiskCache != null);
      try
      {
        if (!this.mOriginalDiskCache.isClosed())
        {
          this.mOriginalDiskCache.close();
          this.mOriginalDiskCache = null;
        }
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("BitmapProcess", "closeCacheInternal - " + localIOException);
      }
    }
  }

  public void configCalculateBitmap(boolean paramBoolean)
  {
    this.neverCalculate = paramBoolean;
  }

  public void flushCacheInternal()
  {
    synchronized (this.mHttpDiskCacheLock)
    {
      LruDiskCache localLruDiskCache = this.mOriginalDiskCache;
      if (localLruDiskCache != null);
      try
      {
        this.mOriginalDiskCache.flush();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          Log.e("BitmapProcess", "flush - " + localIOException);
      }
    }
  }

  public void initHttpDiskCache()
  {
    if (!this.mOriginalCacheDir.exists())
      this.mOriginalCacheDir.mkdirs();
    synchronized (this.mHttpDiskCacheLock)
    {
      long l = BitmapCommonUtils.getUsableSpace(this.mOriginalCacheDir);
      int i = this.cacheSize;
      if (l > i);
      try
      {
        this.mOriginalDiskCache = LruDiskCache.open(this.mOriginalCacheDir, 1, 1, this.cacheSize);
        this.mHttpDiskCacheStarting = false;
        this.mHttpDiskCacheLock.notifyAll();
        return;
      }
      catch (IOException localIOException)
      {
        while (true)
          this.mOriginalDiskCache = null;
      }
    }
  }

  // ERROR //
  public android.graphics.Bitmap processBitmap(String paramString, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 139	net/tsz/afinal/bitmap/core/FileNameGenerator:generator	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 34	net/tsz/afinal/bitmap/core/BitmapProcess:mHttpDiskCacheLock	Ljava/lang/Object;
    //   9: astore 4
    //   11: aload 4
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 32	net/tsz/afinal/bitmap/core/BitmapProcess:mHttpDiskCacheStarting	Z
    //   18: ifne +183 -> 201
    //   21: aload_0
    //   22: getfield 71	net/tsz/afinal/bitmap/core/BitmapProcess:mOriginalDiskCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   25: astore 7
    //   27: aconst_null
    //   28: astore 8
    //   30: aconst_null
    //   31: astore 9
    //   33: aload 7
    //   35: ifnull +128 -> 163
    //   38: aload_0
    //   39: getfield 71	net/tsz/afinal/bitmap/core/BitmapProcess:mOriginalDiskCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   42: aload_3
    //   43: invokevirtual 143	net/tsz/afinal/bitmap/core/LruDiskCache:get	(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    //   46: astore 20
    //   48: aconst_null
    //   49: astore 9
    //   51: aload 20
    //   53: ifnonnull +62 -> 115
    //   56: aload_0
    //   57: getfield 71	net/tsz/afinal/bitmap/core/BitmapProcess:mOriginalDiskCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   60: aload_3
    //   61: invokevirtual 147	net/tsz/afinal/bitmap/core/LruDiskCache:edit	(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Editor;
    //   64: astore 21
    //   66: aconst_null
    //   67: astore 9
    //   69: aload 21
    //   71: ifnull +34 -> 105
    //   74: aload_0
    //   75: getfield 64	net/tsz/afinal/bitmap/core/BitmapProcess:downloader	Lnet/tsz/afinal/bitmap/download/Downloader;
    //   78: aload_1
    //   79: aload 21
    //   81: iconst_0
    //   82: invokevirtual 153	net/tsz/afinal/bitmap/core/LruDiskCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   85: invokeinterface 159 3 0
    //   90: istore 22
    //   92: aconst_null
    //   93: astore 9
    //   95: iload 22
    //   97: ifeq +119 -> 216
    //   100: aload 21
    //   102: invokevirtual 162	net/tsz/afinal/bitmap/core/LruDiskCache$Editor:commit	()V
    //   105: aload_0
    //   106: getfield 71	net/tsz/afinal/bitmap/core/BitmapProcess:mOriginalDiskCache	Lnet/tsz/afinal/bitmap/core/LruDiskCache;
    //   109: aload_3
    //   110: invokevirtual 143	net/tsz/afinal/bitmap/core/LruDiskCache:get	(Ljava/lang/String;)Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;
    //   113: astore 20
    //   115: aconst_null
    //   116: astore 8
    //   118: aconst_null
    //   119: astore 9
    //   121: aload 20
    //   123: ifnull +25 -> 148
    //   126: aload 20
    //   128: iconst_0
    //   129: invokevirtual 168	net/tsz/afinal/bitmap/core/LruDiskCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   132: checkcast 170	java/io/FileInputStream
    //   135: astore 9
    //   137: aload 9
    //   139: invokevirtual 174	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   142: astore 23
    //   144: aload 23
    //   146: astore 8
    //   148: aload 8
    //   150: ifnonnull +13 -> 163
    //   153: aload 9
    //   155: ifnull +8 -> 163
    //   158: aload 9
    //   160: invokevirtual 175	java/io/FileInputStream:close	()V
    //   163: aload 4
    //   165: monitorexit
    //   166: aconst_null
    //   167: astore 10
    //   169: aload 8
    //   171: ifnull +17 -> 188
    //   174: aload_0
    //   175: getfield 36	net/tsz/afinal/bitmap/core/BitmapProcess:neverCalculate	Z
    //   178: ifeq +191 -> 369
    //   181: aload 8
    //   183: invokestatic 181	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;)Landroid/graphics/Bitmap;
    //   186: astore 10
    //   188: aload 9
    //   190: ifnull +8 -> 198
    //   193: aload 9
    //   195: invokevirtual 175	java/io/FileInputStream:close	()V
    //   198: aload 10
    //   200: areturn
    //   201: aload_0
    //   202: getfield 34	net/tsz/afinal/bitmap/core/BitmapProcess:mHttpDiskCacheLock	Ljava/lang/Object;
    //   205: invokevirtual 184	java/lang/Object:wait	()V
    //   208: goto -194 -> 14
    //   211: astore 6
    //   213: goto -199 -> 14
    //   216: aload 21
    //   218: invokevirtual 187	net/tsz/afinal/bitmap/core/LruDiskCache$Editor:abort	()V
    //   221: goto -116 -> 105
    //   224: astore 17
    //   226: ldc 13
    //   228: new 40	java/lang/StringBuilder
    //   231: dup
    //   232: ldc 189
    //   234: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: aload 17
    //   239: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 94	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   248: pop
    //   249: aconst_null
    //   250: astore 8
    //   252: iconst_0
    //   253: ifne -90 -> 163
    //   256: aconst_null
    //   257: astore 8
    //   259: aload 9
    //   261: ifnull -98 -> 163
    //   264: aload 9
    //   266: invokevirtual 175	java/io/FileInputStream:close	()V
    //   269: aconst_null
    //   270: astore 8
    //   272: goto -109 -> 163
    //   275: astore 19
    //   277: aconst_null
    //   278: astore 8
    //   280: goto -117 -> 163
    //   283: astore 14
    //   285: ldc 13
    //   287: new 40	java/lang/StringBuilder
    //   290: dup
    //   291: ldc 189
    //   293: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   296: aload 14
    //   298: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 94	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   307: pop
    //   308: aconst_null
    //   309: astore 8
    //   311: iconst_0
    //   312: ifne -149 -> 163
    //   315: aconst_null
    //   316: astore 8
    //   318: aload 9
    //   320: ifnull -157 -> 163
    //   323: aload 9
    //   325: invokevirtual 175	java/io/FileInputStream:close	()V
    //   328: aconst_null
    //   329: astore 8
    //   331: goto -168 -> 163
    //   334: astore 16
    //   336: aconst_null
    //   337: astore 8
    //   339: goto -176 -> 163
    //   342: astore 12
    //   344: iconst_0
    //   345: ifne +13 -> 358
    //   348: aload 9
    //   350: ifnull +8 -> 358
    //   353: aload 9
    //   355: invokevirtual 175	java/io/FileInputStream:close	()V
    //   358: aload 12
    //   360: athrow
    //   361: astore 5
    //   363: aload 4
    //   365: monitorexit
    //   366: aload 5
    //   368: athrow
    //   369: aload 8
    //   371: aload_2
    //   372: invokevirtual 195	net/tsz/afinal/bitmap/core/BitmapDisplayConfig:getBitmapWidth	()I
    //   375: aload_2
    //   376: invokevirtual 198	net/tsz/afinal/bitmap/core/BitmapDisplayConfig:getBitmapHeight	()I
    //   379: invokestatic 204	net/tsz/afinal/bitmap/core/BitmapDecoder:decodeSampledBitmapFromDescriptor	(Ljava/io/FileDescriptor;II)Landroid/graphics/Bitmap;
    //   382: astore 10
    //   384: goto -196 -> 188
    //   387: astore 13
    //   389: goto -31 -> 358
    //   392: astore 24
    //   394: goto -231 -> 163
    //   397: astore 11
    //   399: aload 10
    //   401: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   201	208	211	java/lang/InterruptedException
    //   38	48	224	java/io/IOException
    //   56	66	224	java/io/IOException
    //   74	92	224	java/io/IOException
    //   100	105	224	java/io/IOException
    //   105	115	224	java/io/IOException
    //   126	144	224	java/io/IOException
    //   216	221	224	java/io/IOException
    //   264	269	275	java/io/IOException
    //   38	48	283	java/lang/IllegalStateException
    //   56	66	283	java/lang/IllegalStateException
    //   74	92	283	java/lang/IllegalStateException
    //   100	105	283	java/lang/IllegalStateException
    //   105	115	283	java/lang/IllegalStateException
    //   126	144	283	java/lang/IllegalStateException
    //   216	221	283	java/lang/IllegalStateException
    //   323	328	334	java/io/IOException
    //   38	48	342	finally
    //   56	66	342	finally
    //   74	92	342	finally
    //   100	105	342	finally
    //   105	115	342	finally
    //   126	144	342	finally
    //   216	221	342	finally
    //   226	249	342	finally
    //   285	308	342	finally
    //   14	27	361	finally
    //   158	163	361	finally
    //   163	166	361	finally
    //   201	208	361	finally
    //   264	269	361	finally
    //   323	328	361	finally
    //   353	358	361	finally
    //   358	361	361	finally
    //   363	366	361	finally
    //   353	358	387	java/io/IOException
    //   158	163	392	java/io/IOException
    //   193	198	397	java/io/IOException
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.core.BitmapProcess
 * JD-Core Version:    0.6.2
 */