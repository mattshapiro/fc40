package net.tsz.afinal.bitmap.display;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;

public class SimpleDisplayer
  implements Displayer
{
  private void animationDisplay(ImageView paramImageView, Bitmap paramBitmap, Animation paramAnimation)
  {
    if (paramAnimation != null)
    {
      paramAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
      paramImageView.startAnimation(paramAnimation);
    }
    paramImageView.setImageBitmap(paramBitmap);
  }

  private void fadeInDisplay(ImageView paramImageView, Bitmap paramBitmap)
  {
    Drawable[] arrayOfDrawable = new Drawable[2];
    arrayOfDrawable[0] = new ColorDrawable(17170445);
    arrayOfDrawable[1] = new BitmapDrawable(paramImageView.getResources(), paramBitmap);
    TransitionDrawable localTransitionDrawable = new TransitionDrawable(arrayOfDrawable);
    paramImageView.setImageDrawable(localTransitionDrawable);
    localTransitionDrawable.startTransition(300);
  }

  public void loadCompletedisplay(ImageView paramImageView, Bitmap paramBitmap, BitmapDisplayConfig paramBitmapDisplayConfig)
  {
    switch (paramBitmapDisplayConfig.getAnimationType())
    {
    default:
      return;
    case 1:
      fadeInDisplay(paramImageView, paramBitmap);
      return;
    case 0:
    }
    animationDisplay(paramImageView, paramBitmap, paramBitmapDisplayConfig.getAnimation());
  }

  public void loadFailDisplay(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramImageView.setImageBitmap(paramBitmap);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.display.SimpleDisplayer
 * JD-Core Version:    0.6.2
 */