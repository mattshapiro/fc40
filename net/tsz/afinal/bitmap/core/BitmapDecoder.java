package net.tsz.afinal.bitmap.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.FileDescriptor;

public class BitmapDecoder
{
  private static final String TAG = "BitmapDecoder";

  public static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    int k = 1;
    float f1;
    float f2;
    if ((i > paramInt2) || (j > paramInt1))
    {
      if (j <= i)
        break label74;
      k = Math.round(i / paramInt2);
      f1 = j * i;
      f2 = 2 * (paramInt1 * paramInt2);
    }
    while (true)
    {
      if (f1 / (k * k) <= f2)
      {
        return k;
        label74: k = Math.round(j / paramInt1);
        break;
      }
      k++;
    }
  }

  public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("BitmapDecoder", "decodeSampledBitmapFromDescriptor内存溢出，如果频繁出现这个情况 可以尝试配置增加内存缓存大小");
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }

  public static Bitmap decodeSampledBitmapFromFile(String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("BitmapDecoder", "decodeSampledBitmapFromFile内存溢出，如果频繁出现这个情况 可以尝试配置增加内存缓存大小");
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }

  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt2, paramInt3);
    localOptions.inJustDecodeBounds = false;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("BitmapDecoder", "decodeSampledBitmapFromResource内存溢出，如果频繁出现这个情况 可以尝试配置增加内存缓存大小");
      localOutOfMemoryError.printStackTrace();
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.core.BitmapDecoder
 * JD-Core Version:    0.6.2
 */