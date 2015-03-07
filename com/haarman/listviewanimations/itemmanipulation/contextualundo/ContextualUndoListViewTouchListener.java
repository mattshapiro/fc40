package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

public class ContextualUndoListViewTouchListener
  implements View.OnTouchListener
{
  private long mAnimationTime;
  private Callback mCallback;
  private int mDownPosition;
  private View mDownView;
  private float mDownX;
  private ListView mListView;
  private int mMaxFlingVelocity;
  private int mMinFlingVelocity;
  private boolean mPaused;
  private int mSlop;
  private boolean mSwiping;
  private VelocityTracker mVelocityTracker;
  private int mViewWidth = 1;

  public ContextualUndoListViewTouchListener(ListView paramListView, Callback paramCallback)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramListView.getContext());
    this.mSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mAnimationTime = paramListView.getContext().getResources().getInteger(17694720);
    this.mListView = paramListView;
    this.mCallback = paramCallback;
  }

  public AbsListView.OnScrollListener makeScrollListener()
  {
    return new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        int i = 1;
        ContextualUndoListViewTouchListener localContextualUndoListViewTouchListener = ContextualUndoListViewTouchListener.this;
        if (paramAnonymousInt != i);
        while (true)
        {
          localContextualUndoListViewTouchListener.setEnabled(i);
          if (ContextualUndoListViewTouchListener.this.mPaused)
            ContextualUndoListViewTouchListener.this.mCallback.onListScrolled();
          return;
          i = 0;
        }
      }
    };
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.mViewWidth < 2)
      this.mViewWidth = this.mListView.getWidth();
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    label312: label349: float f1;
    label513: label523: 
    do
    {
      do
      {
        do
        {
          return false;
          if (this.mPaused)
            return false;
          Rect localRect = new Rect();
          int n = this.mListView.getChildCount();
          int[] arrayOfInt = new int[2];
          this.mListView.getLocationOnScreen(arrayOfInt);
          int i1 = (int)paramMotionEvent.getRawX() - arrayOfInt[0];
          int i2 = (int)paramMotionEvent.getRawY() - arrayOfInt[1];
          for (int i3 = 0; ; i3++)
          {
            if (i3 >= n);
            while (true)
            {
              if (this.mDownView != null)
              {
                this.mDownX = paramMotionEvent.getRawX();
                this.mDownPosition = this.mListView.getPositionForView(this.mDownView);
                this.mVelocityTracker = VelocityTracker.obtain();
                this.mVelocityTracker.addMovement(paramMotionEvent);
              }
              paramView.onTouchEvent(paramMotionEvent);
              return true;
              View localView2 = this.mListView.getChildAt(i3);
              localView2.getHitRect(localRect);
              if (!localRect.contains(i1, i2))
                break;
              this.mDownView = localView2;
            }
          }
        }
        while (this.mVelocityTracker == null);
        float f2 = paramMotionEvent.getRawX() - this.mDownX;
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f3 = Math.abs(this.mVelocityTracker.getXVelocity());
        float f4 = Math.abs(this.mVelocityTracker.getYVelocity());
        int i;
        int j;
        int m;
        if (Math.abs(f2) > this.mViewWidth / 2)
        {
          i = 1;
          if (f2 > 0.0F)
          {
            j = 1;
            if (i == 0)
              break label523;
            final View localView1 = this.mDownView;
            final int k = this.mDownPosition;
            ViewPropertyAnimator localViewPropertyAnimator1 = ViewPropertyAnimator.animate(this.mDownView);
            if (j == 0)
              break label513;
            m = this.mViewWidth;
            ViewPropertyAnimator localViewPropertyAnimator2 = localViewPropertyAnimator1.translationX(m).alpha(0.0F).setDuration(this.mAnimationTime);
            AnimatorListenerAdapter local2 = new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                ContextualUndoListViewTouchListener.this.mCallback.onViewSwiped(localView1, k);
              }
            };
            localViewPropertyAnimator2.setListener(local2);
          }
        }
        while (true)
        {
          this.mVelocityTracker = null;
          this.mDownX = 0.0F;
          this.mDownView = null;
          this.mDownPosition = -1;
          this.mSwiping = false;
          break;
          j = 0;
          break label312;
          boolean bool1 = this.mMinFlingVelocity < f3;
          i = 0;
          j = 0;
          if (bool1)
            break label312;
          boolean bool2 = f3 < this.mMaxFlingVelocity;
          i = 0;
          j = 0;
          if (bool2)
            break label312;
          boolean bool3 = f4 < f3;
          i = 0;
          j = 0;
          if (!bool3)
            break label312;
          i = 1;
          if (this.mVelocityTracker.getXVelocity() > 0.0F);
          for (j = 1; ; j = 0)
            break;
          m = -this.mViewWidth;
          break label349;
          ViewPropertyAnimator.animate(this.mDownView).translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener(null);
        }
      }
      while ((this.mVelocityTracker == null) || (this.mPaused));
      this.mVelocityTracker.addMovement(paramMotionEvent);
      f1 = paramMotionEvent.getRawX() - this.mDownX;
      if (Math.abs(f1) > this.mSlop)
      {
        this.mSwiping = true;
        this.mListView.requestDisallowInterceptTouchEvent(true);
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(0x3 | paramMotionEvent.getActionIndex() << 8);
        this.mListView.onTouchEvent(localMotionEvent);
      }
    }
    while (!this.mSwiping);
    ViewHelper.setTranslationX(this.mDownView, f1);
    ViewHelper.setAlpha(this.mDownView, Math.max(0.0F, Math.min(1.0F, 1.0F - 2.0F * Math.abs(f1) / this.mViewWidth)));
    return true;
  }

  public void setEnabled(boolean paramBoolean)
  {
    if (paramBoolean);
    for (boolean bool = false; ; bool = true)
    {
      this.mPaused = bool;
      return;
    }
  }

  public static abstract interface Callback
  {
    public abstract void onListScrolled();

    public abstract void onViewSwiped(View paramView, int paramInt);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.itemmanipulation.contextualundo.ContextualUndoListViewTouchListener
 * JD-Core Version:    0.6.2
 */