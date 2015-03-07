package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.widget.ImageView;

public final class SimpleBitmapDisplayer
  implements BitmapDisplayer
{
  public Bitmap display(Bitmap paramBitmap, ImageView paramImageView)
  {
    paramImageView.setImageBitmap(paramBitmap);
    return paramBitmap;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer
 * JD-Core Version:    0.6.2
 */