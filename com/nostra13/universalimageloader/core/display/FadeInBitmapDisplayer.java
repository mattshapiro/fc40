package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class FadeInBitmapDisplayer
  implements BitmapDisplayer
{
  private final int durationMillis;

  public FadeInBitmapDisplayer(int paramInt)
  {
    this.durationMillis = paramInt;
  }

  public static void animate(ImageView paramImageView, int paramInt)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setDuration(paramInt);
    localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
    paramImageView.startAnimation(localAlphaAnimation);
  }

  public Bitmap display(Bitmap paramBitmap, ImageView paramImageView)
  {
    paramImageView.setImageBitmap(paramBitmap);
    animate(paramImageView, this.durationMillis);
    return paramBitmap;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
 * JD-Core Version:    0.6.2
 */