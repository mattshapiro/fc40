package net.tsz.afinal.bitmap.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;

public class BitmapCommonUtils
{
  private static final String TAG = "BitmapCommonUtils";

  public static int getBitmapSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  public static File getDiskCacheDir(Context paramContext, String paramString)
  {
    if ("mounted".equals(Environment.getExternalStorageState()));
    for (String str = getExternalCacheDir(paramContext).getPath(); ; str = paramContext.getCacheDir().getPath())
      return new File(str + File.separator + paramString);
  }

  public static File getExternalCacheDir(Context paramContext)
  {
    String str = "/Android/data/" + paramContext.getPackageName() + "/cache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + str);
  }

  public static long getUsableSpace(File paramFile)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramFile.getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return l * i;
    }
    catch (Exception localException)
    {
      Log.e("BitmapCommonUtils", "获取 sdcard 缓存大小 出错，请查看AndroidManifest.xml 是否添加了sdcard的访问权限");
      localException.printStackTrace();
    }
    return -1L;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.core.BitmapCommonUtils
 * JD-Core Version:    0.6.2
 */