package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

public final class StorageUtils
{
  private static final String INDIVIDUAL_DIR_NAME = "uil-images";

  public static File getCacheDirectory(Context paramContext)
  {
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    File localFile = null;
    if (bool)
      localFile = getExternalCacheDir(paramContext);
    if (localFile == null)
      localFile = paramContext.getCacheDir();
    return localFile;
  }

  private static File getExternalCacheDir(Context paramContext)
  {
    File localFile = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "com.ywh.imgcache"), "allicon"), "com.ywh.imgcache"), "allicon");
    if (!localFile.exists())
    {
      if (!localFile.mkdirs())
      {
        L.w("Unable to create external cache directory", new Object[0]);
        localFile = null;
      }
    }
    else
      return localFile;
    try
    {
      new File(localFile, ".nomedia").createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
    }
    return localFile;
  }

  public static File getIndividualCacheDirectory(Context paramContext)
  {
    File localFile1 = getCacheDirectory(paramContext);
    File localFile2 = new File(localFile1, "uil-images");
    if ((!localFile2.exists()) && (!localFile2.mkdir()))
      localFile2 = localFile1;
    return localFile2;
  }

  public static File getOwnCacheDirectory(Context paramContext, String paramString)
  {
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    File localFile = null;
    if (bool)
      localFile = new File(Environment.getExternalStorageDirectory(), paramString);
    if ((localFile == null) || ((!localFile.exists()) && (!localFile.mkdirs())))
      localFile = paramContext.getCacheDir();
    return localFile;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.StorageUtils
 * JD-Core Version:    0.6.2
 */