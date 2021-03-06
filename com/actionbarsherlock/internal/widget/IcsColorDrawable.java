package com.actionbarsherlock.internal.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

public class IcsColorDrawable extends Drawable
{
  private int color;
  private final Paint paint = new Paint();

  public IcsColorDrawable(int paramInt)
  {
    this.color = paramInt;
  }

  public IcsColorDrawable(ColorDrawable paramColorDrawable)
  {
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    paramColorDrawable.draw(new Canvas(localBitmap));
    this.color = localBitmap.getPixel(0, 0);
    localBitmap.recycle();
  }

  public void draw(Canvas paramCanvas)
  {
    if (this.color >>> 24 != 0)
    {
      this.paint.setColor(this.color);
      paramCanvas.drawRect(getBounds(), this.paint);
    }
  }

  public int getOpacity()
  {
    return this.color >>> 24;
  }

  public void setAlpha(int paramInt)
  {
    if (paramInt != this.color >>> 24)
    {
      this.color = (0xFFFFFF & this.color | paramInt << 24);
      invalidateSelf();
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.IcsColorDrawable
 * JD-Core Version:    0.6.2
 */