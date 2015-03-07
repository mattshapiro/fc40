package net.tsz.afinal.bitmap.display;

import android.graphics.Bitmap;
import android.widget.ImageView;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;

public abstract interface Displayer
{
  public abstract void loadCompletedisplay(ImageView paramImageView, Bitmap paramBitmap, BitmapDisplayConfig paramBitmapDisplayConfig);

  public abstract void loadFailDisplay(ImageView paramImageView, Bitmap paramBitmap);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.display.Displayer
 * JD-Core Version:    0.6.2
 */