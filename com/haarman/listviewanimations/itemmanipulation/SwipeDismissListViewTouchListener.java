package com.haarman.listviewanimations.itemmanipulation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"Recycle"})
public class SwipeDismissListViewTouchListener
  implements View.OnTouchListener
{
  private long mAnimationTime;
  private OnDismissCallback mCallback;
  private int mDismissAnimationRefCount = 0;
  private int mDownPosition;
  private View mDownView;
  private float mDownX;
  private float mDownY;
  private ListView mListView;
  private int mMaxFlingVelocity;
  private int mMinFlingVelocity;
  private boolean mPaused;
  private List<PendingDismissData> mPendingDismisses = new ArrayList();
  private int mSlop;
  private boolean mSwiping;
  private VelocityTracker mVelocityTracker;
  private int mViewWidth = 1;

  public SwipeDismissListViewTouchListener(ListView paramListView, OnDismissCallback paramOnDismissCallback)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramListView.getContext());
    this.mSlop = localViewConfiguration.getScaledTouchSlop();
    this.mMinFlingVelocity = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.mAnimationTime = paramListView.getContext().getResources().getInteger(17694720);
    this.mListView = paramListView;
    this.mCallback = paramOnDismissCallback;
  }

  private void performDismiss(final View paramView, int paramInt)
  {
    final ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramView.getHeight(), 1 }).setDuration(this.mAnimationTime);
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        SwipeDismissListViewTouchListener localSwipeDismissListViewTouchListener = SwipeDismissListViewTouchListener.this;
        localSwipeDismissListViewTouchListener.mDismissAnimationRefCount = (-1 + localSwipeDismissListViewTouchListener.mDismissAnimationRefCount);
        int[] arrayOfInt;
        int i;
        Iterator localIterator;
        if (SwipeDismissListViewTouchListener.this.mDismissAnimationRefCount == 0)
        {
          Collections.sort(SwipeDismissListViewTouchListener.this.mPendingDismisses);
          arrayOfInt = new int[SwipeDismissListViewTouchListener.this.mPendingDismisses.size()];
          i = -1 + SwipeDismissListViewTouchListener.this.mPendingDismisses.size();
          if (i >= 0)
            break label128;
          SwipeDismissListViewTouchListener.this.mCallback.onDismiss(SwipeDismissListViewTouchListener.this.mListView, arrayOfInt);
          localIterator = SwipeDismissListViewTouchListener.this.mPendingDismisses.iterator();
        }
        while (true)
        {
          if (!localIterator.hasNext())
          {
            SwipeDismissListViewTouchListener.this.mPendingDismisses.clear();
            return;
            label128: arrayOfInt[i] = ((SwipeDismissListViewTouchListener.PendingDismissData)SwipeDismissListViewTouchListener.this.mPendingDismisses.get(i)).position;
            i--;
            break;
          }
          SwipeDismissListViewTouchListener.PendingDismissData localPendingDismissData = (SwipeDismissListViewTouchListener.PendingDismissData)localIterator.next();
          ViewHelper.setAlpha(localPendingDismissData.view, 1.0F);
          ViewHelper.setTranslationX(localPendingDismissData.view, 0.0F);
          ViewGroup.LayoutParams localLayoutParams = localPendingDismissData.view.getLayoutParams();
          localLayoutParams.height = 0;
          localPendingDismissData.view.setLayoutParams(localLayoutParams);
        }
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        localLayoutParams.height = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        paramView.setLayoutParams(localLayoutParams);
      }
    });
    this.mPendingDismisses.add(new PendingDismissData(paramInt, paramView));
    localValueAnimator.start();
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
    label320: label367: float f1;
    label531: label541: 
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
                this.mDownY = paramMotionEvent.getRawY();
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
        float f3 = paramMotionEvent.getRawX() - this.mDownX;
        this.mVelocityTracker.addMovement(paramMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000);
        float f4 = Math.abs(this.mVelocityTracker.getXVelocity());
        float f5 = Math.abs(this.mVelocityTracker.getYVelocity());
        int i;
        int j;
        int m;
        if (Math.abs(f3) > this.mViewWidth / 2)
        {
          i = 1;
          if (f3 > 0.0F)
          {
            j = 1;
            if (i == 0)
              break label541;
            final View localView1 = this.mDownView;
            final int k = this.mDownPosition;
            this.mDismissAnimationRefCount = (1 + this.mDismissAnimationRefCount);
            ViewPropertyAnimator localViewPropertyAnimator1 = ViewPropertyAnimator.animate(this.mDownView);
            if (j == 0)
              break label531;
            m = this.mViewWidth;
            ViewPropertyAnimator localViewPropertyAnimator2 = localViewPropertyAnimator1.translationX(m).alpha(0.0F).setDuration(this.mAnimationTime);
            AnimatorListenerAdapter local1 = new AnimatorListenerAdapter()
            {
              public void onAnimationEnd(Animator paramAnonymousAnimator)
              {
                SwipeDismissListViewTouchListener.this.performDismiss(localView1, k);
              }
            };
            localViewPropertyAnimator2.setListener(local1);
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
          break label320;
          boolean bool1 = this.mMinFlingVelocity < f4;
          i = 0;
          j = 0;
          if (bool1)
            break label320;
          boolean bool2 = f4 < this.mMaxFlingVelocity;
          i = 0;
          j = 0;
          if (bool2)
            break label320;
          boolean bool3 = f5 < f4;
          i = 0;
          j = 0;
          if (!bool3)
            break label320;
          i = 1;
          if (this.mVelocityTracker.getXVelocity() > 0.0F);
          for (j = 1; ; j = 0)
            break;
          m = -this.mViewWidth;
          break label367;
          ViewPropertyAnimator.animate(this.mDownView).translationX(0.0F).alpha(1.0F).setDuration(this.mAnimationTime).setListener(null);
        }
      }
      while ((this.mVelocityTracker == null) || (this.mPaused));
      this.mVelocityTracker.addMovement(paramMotionEvent);
      f1 = paramMotionEvent.getRawX() - this.mDownX;
      float f2 = paramMotionEvent.getRawY() - this.mDownY;
      if ((Math.abs(f1) > this.mSlop) && (Math.abs(f1) > Math.abs(f2)))
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

  class PendingDismissData
    implements Comparable<PendingDismissData>
  {
    public int position;
    public View view;

    public PendingDismissData(int paramView, View arg3)
    {
      this.position = paramView;
      Object localObject;
      this.view = localObject;
    }

    public int compareTo(PendingDismissData paramPendingDismissData)
    {
      return paramPendingDismissData.position - this.position;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.itemmanipulation.SwipeDismissListViewTouchListener
 * JD-Core Version:    0.6.2
 */