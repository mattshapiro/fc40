package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import java.io.IOException;
import java.io.InputStream;

public class BaseImageDecoder
  implements ImageDecoder
{
  protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
  protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
  protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d° [%2$s]";
  protected static final String LOG_SABSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
  protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
  protected boolean loggingEnabled;

  public BaseImageDecoder()
  {
  }

  public BaseImageDecoder(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }

  protected Bitmap considerExactScaleAndOrientaiton(Bitmap paramBitmap, ImageDecodingInfo paramImageDecodingInfo, int paramInt, boolean paramBoolean)
  {
    Matrix localMatrix = new Matrix();
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    ImageSize localImageSize1;
    ImageSize localImageSize2;
    ViewScaleType localViewScaleType;
    if ((localImageScaleType == ImageScaleType.EXACTLY) || (localImageScaleType == ImageScaleType.EXACTLY_STRETCHED))
    {
      localImageSize1 = new ImageSize(paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt);
      localImageSize2 = paramImageDecodingInfo.getTargetSize();
      localViewScaleType = paramImageDecodingInfo.getViewScaleType();
      if (localImageScaleType != ImageScaleType.EXACTLY_STRETCHED)
        break label279;
    }
    label279: for (boolean bool = true; ; bool = false)
    {
      float f = ImageSizeUtils.computeImageScale(localImageSize1, localImageSize2, localViewScaleType, bool);
      if (Float.compare(f, 1.0F) != 0)
      {
        localMatrix.setScale(f, f);
        if (this.loggingEnabled)
        {
          Object[] arrayOfObject3 = new Object[4];
          arrayOfObject3[0] = localImageSize1;
          arrayOfObject3[1] = localImageSize1.scale(f);
          arrayOfObject3[2] = Float.valueOf(f);
          arrayOfObject3[3] = paramImageDecodingInfo.getImageKey();
          L.i("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", arrayOfObject3);
        }
      }
      if (paramBoolean)
      {
        localMatrix.postScale(-1.0F, 1.0F);
        if (this.loggingEnabled)
        {
          Object[] arrayOfObject2 = new Object[1];
          arrayOfObject2[0] = paramImageDecodingInfo.getImageKey();
          L.i("Flip image horizontally [%s]", arrayOfObject2);
        }
      }
      if (paramInt != 0)
      {
        localMatrix.postRotate(paramInt);
        if (this.loggingEnabled)
        {
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = Integer.valueOf(paramInt);
          arrayOfObject1[1] = paramImageDecodingInfo.getImageKey();
          L.i("Rotate image on %1$d° [%2$s]", arrayOfObject1);
        }
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
      if (localBitmap != paramBitmap)
        paramBitmap.recycle();
      return localBitmap;
    }
  }

  public Bitmap decode(ImageDecodingInfo paramImageDecodingInfo)
    throws IOException
  {
    ImageFileInfo localImageFileInfo = defineImageSizeAndRotation(getImageStream(paramImageDecodingInfo), paramImageDecodingInfo.getImageUri());
    BitmapFactory.Options localOptions = prepareDecodingOptions(localImageFileInfo.imageSize, paramImageDecodingInfo);
    Bitmap localBitmap = decodeStream(getImageStream(paramImageDecodingInfo), localOptions);
    if (localBitmap == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramImageDecodingInfo.getImageKey();
      L.e("Image can't be decoded [%s]", arrayOfObject);
      return localBitmap;
    }
    return considerExactScaleAndOrientaiton(localBitmap, paramImageDecodingInfo, localImageFileInfo.exif.rotation, localImageFileInfo.exif.flipHorizontal);
  }

  protected Bitmap decodeStream(InputStream paramInputStream, BitmapFactory.Options paramOptions)
    throws IOException
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
      return localBitmap;
    }
    finally
    {
      IoUtils.closeSilently(paramInputStream);
    }
  }

  protected ExifInfo defineExifOrientation(String paramString1, String paramString2)
  {
    boolean bool1 = "image/jpeg".equalsIgnoreCase(paramString2);
    boolean bool2 = false;
    int i = 0;
    if (bool1)
    {
      ImageDownloader.Scheme localScheme1 = ImageDownloader.Scheme.ofUri(paramString1);
      ImageDownloader.Scheme localScheme2 = ImageDownloader.Scheme.FILE;
      bool2 = false;
      i = 0;
      if (localScheme1 != localScheme2);
    }
    try
    {
      int j = new ExifInterface(ImageDownloader.Scheme.FILE.crop(paramString1)).getAttributeInt("Orientation", 1);
      i = 0;
      bool2 = false;
      switch (j)
      {
      default:
      case 2:
      case 1:
      case 7:
      case 6:
      case 4:
      case 3:
      case 5:
      case 8:
      }
      while (true)
      {
        return new ExifInfo(i, bool2);
        bool2 = true;
        i = 0;
        continue;
        bool2 = true;
        i = 90;
        continue;
        bool2 = true;
        i = 180;
        continue;
        bool2 = true;
        i = 270;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        L.w("Can't read EXIF tags from file [%s]", new Object[] { paramString1 });
        bool2 = false;
        i = 0;
      }
    }
  }

  protected ImageFileInfo defineImageSizeAndRotation(InputStream paramInputStream, String paramString)
    throws IOException
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    while (true)
    {
      try
      {
        BitmapFactory.decodeStream(paramInputStream, null, localOptions);
        IoUtils.closeSilently(paramInputStream);
        if (Build.VERSION.SDK_INT >= 5)
        {
          localExifInfo = defineExifOrientation(paramString, localOptions.outMimeType);
          return new ImageFileInfo(new ImageSize(localOptions.outWidth, localOptions.outHeight, localExifInfo.rotation), localExifInfo);
        }
      }
      finally
      {
        IoUtils.closeSilently(paramInputStream);
      }
      ExifInfo localExifInfo = new ExifInfo();
    }
  }

  protected InputStream getImageStream(ImageDecodingInfo paramImageDecodingInfo)
    throws IOException
  {
    return paramImageDecodingInfo.getDownloader().getStream(paramImageDecodingInfo.getImageUri(), paramImageDecodingInfo.getExtraForDownloader());
  }

  protected BitmapFactory.Options prepareDecodingOptions(ImageSize paramImageSize, ImageDecodingInfo paramImageDecodingInfo)
  {
    ImageScaleType localImageScaleType = paramImageDecodingInfo.getImageScaleType();
    ImageSize localImageSize = paramImageDecodingInfo.getTargetSize();
    int i = 1;
    if (localImageScaleType != ImageScaleType.NONE)
      if (localImageScaleType != ImageScaleType.IN_SAMPLE_POWER_OF_2)
        break label113;
    label113: for (boolean bool = true; ; bool = false)
    {
      i = ImageSizeUtils.computeImageSampleSize(paramImageSize, localImageSize, paramImageDecodingInfo.getViewScaleType(), bool);
      if (this.loggingEnabled)
      {
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = paramImageSize;
        arrayOfObject[1] = paramImageSize.scaleDown(i);
        arrayOfObject[2] = Integer.valueOf(i);
        arrayOfObject[3] = paramImageDecodingInfo.getImageKey();
        L.i("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", arrayOfObject);
      }
      BitmapFactory.Options localOptions = paramImageDecodingInfo.getDecodingOptions();
      localOptions.inSampleSize = i;
      return localOptions;
    }
  }

  public void setLoggingEnabled(boolean paramBoolean)
  {
    this.loggingEnabled = paramBoolean;
  }

  protected static class ExifInfo
  {
    final boolean flipHorizontal;
    final int rotation;

    ExifInfo()
    {
      this.rotation = 0;
      this.flipHorizontal = false;
    }

    ExifInfo(int paramInt, boolean paramBoolean)
    {
      this.rotation = paramInt;
      this.flipHorizontal = paramBoolean;
    }
  }

  protected static class ImageFileInfo
  {
    final BaseImageDecoder.ExifInfo exif;
    final ImageSize imageSize;

    ImageFileInfo(ImageSize paramImageSize, BaseImageDecoder.ExifInfo paramExifInfo)
    {
      this.imageSize = paramImageSize;
      this.exif = paramExifInfo;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.BaseImageDecoder
 * JD-Core Version:    0.6.2
 */