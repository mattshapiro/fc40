package com.allinone.free.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.OvershootInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;

public class OverScrollWarpLayout extends LinearLayout
{
  private static final float OVERSHOOT_TENSION = 0.75F;
  private Scroller mScroller;

  public OverScrollWarpLayout(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    this.mScroller = new Scroller(getContext(), new OvershootInterpolator(0.75F));
  }

  public OverScrollWarpLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.mScroller = new Scroller(getContext(), new OvershootInterpolator(0.75F));
  }

  public void computeScroll()
  {
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
    }
    super.computeScroll();
  }

  public final int getScrollerCurrY()
  {
    return this.mScroller.getCurrY();
  }

  public void smoothScrollBy(int paramInt1, int paramInt2)
  {
    this.mScroller.startScroll(this.mScroller.getFinalX(), this.mScroller.getFinalY(), paramInt1, paramInt2);
    invalidate();
  }

  public void smoothScrollTo(int paramInt1, int paramInt2)
  {
    smoothScrollBy(paramInt1 - this.mScroller.getFinalX(), paramInt2 - this.mScroller.getFinalY());
  }

  public final void smoothScrollToNormal()
  {
    smoothScrollTo(0, 0);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.OverScrollWarpLayout
 * JD-Core Version:    0.6.2
 */