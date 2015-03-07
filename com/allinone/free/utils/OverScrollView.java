package com.allinone.free.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;

public class OverScrollView extends ScrollView
{
  private static final int BOTTOM_OVERSCROLL_STATE = 2;
  private static final float ELASTICITY_COEFFICIENT = 0.25F;
  private static final int INVALID_POINTER = -1;
  private static final int NO_OVERSCROLL_STATE = 0;
  private static final int OVERSCROLL_MAX_HEIGHT = 1200;
  private static final int TOP_OVERSCROLL_STATE = 1;
  private static final int TRIGGER_HEIGHT = 120;
  private int inertanceY;
  private boolean isInertance;
  private boolean isOnTouch;
  private boolean isRecord;
  private int mActivePointerId = -1;
  private OverScrollWarpLayout mContentLayout;
  private boolean mIsBanQuickScroll;
  private boolean mIsUseInertance = true;
  private boolean mIsUseOverScroll = true;
  private float mLastMotionY;
  private OverScrollListener mOverScrollListener;
  private OverScrollTinyListener mOverScrollTinyListener;
  private int mOverScrollTrigger = 120;
  private OnScrollListener mScrollListener;
  private int overScrollDistance;
  private int overScrollSate;

  public OverScrollView(Context paramContext)
  {
    this(paramContext, null);
  }

  public OverScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public OverScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initScrollView();
  }

  private void initOverScrollLayout()
  {
    setFillViewport(true);
    if (this.mContentLayout == null)
    {
      View localView = getChildAt(0);
      this.mContentLayout = new OverScrollWarpLayout(getContext());
      removeAllViews();
      this.mContentLayout.addView(localView);
      addView(this.mContentLayout, new FrameLayout.LayoutParams(-1, -1));
    }
  }

  private void initScrollView()
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      setOverScrollMode(2);
      return;
    }
    ViewCompat.setOverScrollMode(this, 2);
  }

  private void invalidateState()
  {
    if (this.mContentLayout.getScrollerCurrY() == 0)
      this.overScrollSate = 0;
    if (this.mContentLayout.getScrollerCurrY() < 0)
      this.overScrollSate = 1;
    if (this.mContentLayout.getScrollerCurrY() > 0)
      this.overScrollSate = 2;
  }

  private boolean isOnBottom()
  {
    return getScrollY() + getHeight() == this.mContentLayout.getHeight();
  }

  private boolean isOnTop()
  {
    return getScrollY() == 0;
  }

  private void onSecondaryPointerUp(MotionEvent paramMotionEvent)
  {
    int i = (0xFF00 & paramMotionEvent.getAction()) >> 8;
    if (paramMotionEvent.getPointerId(i) == this.mActivePointerId)
      if (i != 0)
        break label50;
    label50: for (int j = 1; ; j = 0)
    {
      this.mLastMotionY = ((int)paramMotionEvent.getY(j));
      this.mActivePointerId = paramMotionEvent.getPointerId(j);
      return;
    }
  }

  private void overScrollTrigger()
  {
    if (this.mOverScrollListener == null);
    do
    {
      return;
      if ((this.overScrollDistance > this.mOverScrollTrigger) && (isOnBottom()))
        this.mOverScrollListener.footerScroll();
    }
    while ((this.overScrollDistance >= -this.mOverScrollTrigger) || (!isOnTop()));
    this.mOverScrollListener.headerScroll();
  }

  public void computeScroll()
  {
    if (!this.mIsBanQuickScroll)
      super.computeScroll();
  }

  public void fling(int paramInt)
  {
    this.inertanceY = (paramInt * 50 / 5000);
    super.fling(paramInt);
  }

  public int getScrollHeight()
  {
    return this.mContentLayout.getHeight() - getHeight();
  }

  public int getScrollState()
  {
    invalidateState();
    return this.overScrollSate;
  }

  public boolean isOverScrolled()
  {
    return (isOnTop()) || (isOnBottom());
  }

  protected void onAttachedToWindow()
  {
    initOverScrollLayout();
    super.onAttachedToWindow();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.mIsUseOverScroll)
      return super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    case 3:
    }
    while (true)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (isOverScrolled())
      {
        this.isRecord = true;
        this.mLastMotionY = ((int)paramMotionEvent.getY());
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        continue;
        if ((this.isRecord) && (Math.abs(paramMotionEvent.getY() - this.mLastMotionY) > 20.0F))
        {
          return true;
          if (this.isRecord)
            this.isRecord = false;
        }
      }
    }
  }

  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mIsUseInertance) && (!this.isInertance) && (paramInt2 != 0))
      this.isInertance = true;
    if ((paramBoolean2) && (!this.isOnTouch) && (this.isInertance))
    {
      this.mContentLayout.smoothScrollBy(0, this.inertanceY);
      this.mContentLayout.smoothScrollToNormal();
      this.inertanceY = 0;
    }
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.mScrollListener != null) && (this.overScrollDistance == 0))
      this.mScrollListener.onScroll(paramInt1, paramInt2, paramInt3, paramInt4);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.isOnTouch = true;
    if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
    {
      if (this.mOverScrollTinyListener != null)
        this.mOverScrollTinyListener.scrollLoosen();
      this.isOnTouch = false;
    }
    if (!this.mIsUseOverScroll)
      return super.onTouchEvent(paramMotionEvent);
    if (!isOverScrolled())
    {
      this.mLastMotionY = ((int)paramMotionEvent.getY());
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 4:
    default:
    case 0:
    case 5:
    case 6:
    case 2:
    case 1:
    case 3:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      this.mLastMotionY = ((int)paramMotionEvent.getY());
      continue;
      int k = paramMotionEvent.getActionIndex();
      this.mLastMotionY = ((int)paramMotionEvent.getY(k));
      this.mActivePointerId = paramMotionEvent.getPointerId(k);
      continue;
      onSecondaryPointerUp(paramMotionEvent);
      if (this.mActivePointerId != -1)
      {
        this.mLastMotionY = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.mActivePointerId)));
        continue;
        if (this.isRecord)
        {
          int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i != -1)
          {
            float f = paramMotionEvent.getY(i);
            int j = (int)(this.mLastMotionY - f);
            this.mLastMotionY = f;
            if ((Math.abs(this.overScrollDistance) >= 1200) && (j * this.overScrollDistance > 0))
              j = 0;
            if (this.overScrollDistance * (j + this.overScrollDistance) < 0)
            {
              this.mContentLayout.smoothScrollToNormal();
              this.overScrollDistance = 0;
            }
            else if (((!isOnBottom()) && (this.overScrollDistance > 0)) || ((!isOnTop()) && (this.overScrollDistance < 0)))
            {
              this.mContentLayout.smoothScrollToNormal();
              this.overScrollDistance = 0;
            }
            else
            {
              if (j * this.overScrollDistance > 0)
                j = (int)(0.25F * j);
              if (this.overScrollDistance == 0)
                j = (int)(0.5F * (0.25F * j));
              if ((this.overScrollDistance != 0) || (j != 0))
              {
                if (Math.abs(j) > 20)
                  if (j <= 0)
                    break label470;
                label470: for (j = 20; ; j = -20)
                {
                  this.overScrollDistance = (j + this.overScrollDistance);
                  if ((!isOnTop()) || (this.overScrollDistance <= 0) || (isOnBottom()))
                    break label477;
                  this.overScrollDistance = 0;
                  break;
                }
                label477: if ((isOnBottom()) && (this.overScrollDistance < 0) && (!isOnTop()))
                {
                  this.overScrollDistance = 0;
                }
                else
                {
                  this.mContentLayout.smoothScrollBy(0, j);
                  if (this.mOverScrollTinyListener != null)
                    this.mOverScrollTinyListener.scrollDistance(j, this.overScrollDistance);
                  return true;
                  this.mContentLayout.smoothScrollToNormal();
                  overScrollTrigger();
                  this.overScrollDistance = 0;
                  this.isRecord = false;
                  this.mActivePointerId = -1;
                }
              }
            }
          }
        }
      }
    }
  }

  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }

  public void setOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }

  public void setOverScroll(boolean paramBoolean)
  {
    this.mIsUseOverScroll = paramBoolean;
  }

  public void setOverScrollListener(OverScrollListener paramOverScrollListener)
  {
    this.mOverScrollListener = paramOverScrollListener;
  }

  public void setOverScrollTinyListener(OverScrollTinyListener paramOverScrollTinyListener)
  {
    this.mOverScrollTinyListener = paramOverScrollTinyListener;
  }

  public void setOverScrollTrigger(int paramInt)
  {
    if (paramInt >= 30)
      this.mOverScrollTrigger = paramInt;
  }

  public void setQuickScroll(boolean paramBoolean)
  {
    if (paramBoolean);
    for (boolean bool = false; ; bool = true)
    {
      this.mIsBanQuickScroll = bool;
      return;
    }
  }

  public void setUseInertance(boolean paramBoolean)
  {
    this.mIsUseInertance = paramBoolean;
  }

  public static abstract interface OnScrollListener
  {
    public abstract void onScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }

  public static abstract interface OverScrollListener
  {
    public abstract void footerScroll();

    public abstract void headerScroll();
  }

  public static abstract interface OverScrollTinyListener
  {
    public abstract void scrollDistance(int paramInt1, int paramInt2);

    public abstract void scrollLoosen();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.OverScrollView
 * JD-Core Version:    0.6.2
 */