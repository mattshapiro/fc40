package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.nostra13.universalimageloader.utils.L;

public class RoundedBitmapDisplayer
  implements BitmapDisplayer
{
  private final int roundPixels;

  public RoundedBitmapDisplayer(int paramInt)
  {
    this.roundPixels = paramInt;
  }

  private static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt1, Rect paramRect1, Rect paramRect2, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    RectF localRectF = new RectF(paramRect2);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-16777216);
    localCanvas.drawRoundRect(localRectF, paramInt1, paramInt1, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, paramRect1, localRectF, localPaint);
    return localBitmap;
  }

  public static Bitmap roundCorners(Bitmap paramBitmap, ImageView paramImageView, int paramInt)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = paramImageView.getWidth();
    int m = paramImageView.getHeight();
    if (k <= 0)
      k = i;
    if (m <= 0)
      m = j;
    int n;
    int i1;
    switch ($SWITCH_TABLE$android$widget$ImageView$ScaleType()[paramImageView.getScaleType().ordinal()])
    {
    case 4:
    case 5:
    case 6:
    default:
      if (k / m > i / j)
      {
        n = (int)(i / (j / m));
        i1 = m;
      }
      break;
    case 3:
    case 2:
    case 7:
    case 1:
    case 8:
    }
    while (true)
    {
      Rect localRect1 = new Rect(0, 0, i, j);
      Rect localRect2 = new Rect(0, 0, n, i1);
      try
      {
        while (true)
        {
          Bitmap localBitmap = getRoundedCornerBitmap(paramBitmap, paramInt, localRect1, localRect2, n, i1);
          return localBitmap;
          int i11;
          int i10;
          if (k / m > i / j)
          {
            i11 = Math.min(m, j);
            i10 = (int)(i / (j / i11));
          }
          while (true)
          {
            int i12 = (k - i10) / 2;
            int i13 = (m - i11) / 2;
            localRect1 = new Rect(0, 0, i, j);
            localRect2 = new Rect(i12, i13, i12 + i10, i13 + i11);
            n = k;
            i1 = m;
            break;
            i10 = Math.min(k, i);
            i11 = (int)(j / (i / i10));
          }
          n = k;
          i1 = (int)(j / (i / k));
          break;
          int i4;
          int i5;
          int i6;
          if (k / m > i / j)
          {
            i4 = i;
            i5 = (int)(m * (i / k));
            i6 = 0;
          }
          for (int i7 = (j - i5) / 2; ; i7 = 0)
          {
            n = Math.min(k, i);
            i1 = Math.min(m, j);
            int i8 = i6 + i4;
            int i9 = i7 + i5;
            localRect1 = new Rect(i6, i7, i8, i9);
            localRect2 = new Rect(0, 0, n, i1);
            break;
            i4 = (int)(k * (j / m));
            i5 = j;
            i6 = (i - i4) / 2;
          }
          n = k;
          i1 = m;
          localRect1 = new Rect(0, 0, i, j);
          localRect2 = new Rect(0, 0, n, i1);
          continue;
          n = Math.min(k, i);
          i1 = Math.min(m, j);
          int i2 = (i - n) / 2;
          int i3 = (j - i1) / 2;
          localRect1 = new Rect(i2, i3, i2 + n, i3 + i1);
          localRect2 = new Rect(0, 0, n, i1);
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        L.e(localOutOfMemoryError, "Can't create bitmap with rounded corners. Not enough memory.", new Object[0]);
      }
    }
    return paramBitmap;
  }

  public Bitmap display(Bitmap paramBitmap, ImageView paramImageView)
  {
    Bitmap localBitmap = roundCorners(paramBitmap, paramImageView, this.roundPixels);
    paramImageView.setImageBitmap(localBitmap);
    return localBitmap;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer
 * JD-Core Version:    0.6.2
 */