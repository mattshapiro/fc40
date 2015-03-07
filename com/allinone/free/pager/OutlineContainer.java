package com.allinone.free.pager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;

public class OutlineContainer extends FrameLayout
  implements Animatable
{
  private static final long ANIMATION_DURATION = 500L;
  private static final long FRAME_DURATION = 16L;
  private float mAlpha = 1.0F;
  private final Interpolator mInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      float f = paramAnonymousFloat - 1.0F;
      return 1.0F + f * (f * f);
    }
  };
  private boolean mIsRunning = false;
  private Paint mOutlinePaint;
  private long mStartTime;
  private final Runnable mUpdater = new Runnable()
  {
    public void run()
    {
      long l = AnimationUtils.currentAnimationTimeMillis() - OutlineContainer.this.mStartTime;
      if (l >= 500L)
      {
        OutlineContainer.this.mAlpha = 0.0F;
        OutlineContainer.this.invalidate();
        OutlineContainer.this.stop();
        return;
      }
      OutlineContainer.this.mAlpha = OutlineContainer.this.mInterpolator.getInterpolation(1.0F - (float)l / 500.0F);
      OutlineContainer.this.invalidate();
      OutlineContainer.this.postDelayed(OutlineContainer.this.mUpdater, 16L);
    }
  };

  public OutlineContainer(Context paramContext)
  {
    super(paramContext);
    init();
  }

  public OutlineContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }

  public OutlineContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }

  private void init()
  {
    this.mOutlinePaint = new Paint();
    this.mOutlinePaint.setAntiAlias(true);
    this.mOutlinePaint.setStrokeWidth(Util.dpToPx(getResources(), 2));
    this.mOutlinePaint.setColor(getResources().getColor(2131361807));
    this.mOutlinePaint.setStyle(Paint.Style.STROKE);
    int i = Util.dpToPx(getResources(), 10);
    setPadding(i, i, i, i);
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i = Util.dpToPx(getResources(), 5);
    if (this.mOutlinePaint.getColor() != JazzyViewPager.sOutlineColor)
      this.mOutlinePaint.setColor(JazzyViewPager.sOutlineColor);
    this.mOutlinePaint.setAlpha((int)(255.0F * this.mAlpha));
    paramCanvas.drawRect(new Rect(i, i, getMeasuredWidth() - i, getMeasuredHeight() - i), this.mOutlinePaint);
  }

  public boolean isRunning()
  {
    return this.mIsRunning;
  }

  public void setOutlineAlpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
  }

  public void start()
  {
    if (this.mIsRunning)
      return;
    this.mIsRunning = true;
    this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
    post(this.mUpdater);
  }

  public void stop()
  {
    if (!this.mIsRunning)
      return;
    this.mIsRunning = false;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.pager.OutlineContainer
 * JD-Core Version:    0.6.2
 */