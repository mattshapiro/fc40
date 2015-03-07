package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import java.lang.reflect.Field;

public final class ImageSizeUtils
{
  public static int computeImageSampleSize(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int i = paramImageSize1.getWidth();
    int j = paramImageSize1.getHeight();
    int k = paramImageSize2.getWidth();
    int m = paramImageSize2.getHeight();
    int n = 1;
    int i1 = i / k;
    int i2 = j / m;
    switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$assist$ViewScaleType()[paramViewScaleType.ordinal()])
    {
    default:
    case 1:
    case 2:
    }
    while (true)
    {
      if (n < 1)
        n = 1;
      return n;
      if (paramBoolean)
        while ((i / 2 >= k) || (j / 2 >= m))
        {
          i /= 2;
          j /= 2;
          n *= 2;
        }
      n = Math.max(i1, i2);
      continue;
      if (paramBoolean)
        while ((i / 2 >= k) && (j / 2 >= m))
        {
          i /= 2;
          j /= 2;
          n *= 2;
        }
      else
        n = Math.min(i1, i2);
    }
  }

  public static float computeImageScale(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int i = paramImageSize1.getWidth();
    int j = paramImageSize1.getHeight();
    int k = paramImageSize2.getWidth();
    int m = paramImageSize2.getHeight();
    float f1 = i / k;
    float f2 = j / m;
    int n;
    if (((paramViewScaleType == ViewScaleType.FIT_INSIDE) && (f1 >= f2)) || ((paramViewScaleType == ViewScaleType.CROP) && (f1 < f2)))
      n = k;
    for (int i1 = (int)(j / f1); ; i1 = m)
    {
      float f3 = 1.0F;
      if (((!paramBoolean) && (n < i) && (i1 < j)) || ((paramBoolean) && (n != i) && (i1 != j)))
        f3 = n / i;
      return f3;
      n = (int)(i / f2);
    }
  }

  public static ImageSize defineTargetSizeForView(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = paramImageView.getContext().getResources().getDisplayMetrics();
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    int i;
    int k;
    if (localLayoutParams.width == -2)
    {
      i = 0;
      if (i <= 0)
        i = localLayoutParams.width;
      if (i <= 0)
        i = getImageViewFieldValue(paramImageView, "mMaxWidth");
      if (i <= 0)
        i = paramInt1;
      if (i <= 0)
        i = localDisplayMetrics.widthPixels;
      int j = localLayoutParams.height;
      k = 0;
      if (j != -2)
        break label156;
    }
    while (true)
    {
      if (k <= 0)
        k = localLayoutParams.height;
      if (k <= 0)
        k = getImageViewFieldValue(paramImageView, "mMaxHeight");
      if (k <= 0)
        k = paramInt2;
      if (k <= 0)
        k = localDisplayMetrics.heightPixels;
      return new ImageSize(i, k);
      i = paramImageView.getWidth();
      break;
      label156: k = paramImageView.getHeight();
    }
  }

  private static int getImageViewFieldValue(Object paramObject, String paramString)
  {
    try
    {
      Field localField = ImageView.class.getDeclaredField(paramString);
      localField.setAccessible(true);
      int i = ((Integer)localField.get(paramObject)).intValue();
      int j = 0;
      if (i > 0)
      {
        j = 0;
        if (i < 2147483647)
          j = i;
      }
      return j;
    }
    catch (Exception localException)
    {
      L.e(localException);
    }
    return 0;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.ImageSizeUtils
 * JD-Core Version:    0.6.2
 */