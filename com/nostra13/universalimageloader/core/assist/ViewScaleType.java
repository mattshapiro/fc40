package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

public enum ViewScaleType
{
  static
  {
    CROP = new ViewScaleType("CROP", 1);
    ViewScaleType[] arrayOfViewScaleType = new ViewScaleType[2];
    arrayOfViewScaleType[0] = FIT_INSIDE;
    arrayOfViewScaleType[1] = CROP;
  }

  public static ViewScaleType fromImageView(ImageView paramImageView)
  {
    switch ($SWITCH_TABLE$android$widget$ImageView$ScaleType()[paramImageView.getScaleType().ordinal()])
    {
    default:
      return CROP;
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    return FIT_INSIDE;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ViewScaleType
 * JD-Core Version:    0.6.2
 */