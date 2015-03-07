package com.haarman.listviewanimations.itemmanipulation;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class AnimateDismissAdapter<T> extends BaseAdapterDecorator
{
  private OnDismissCallback mCallback;

  public AnimateDismissAdapter(BaseAdapter paramBaseAdapter, OnDismissCallback paramOnDismissCallback)
  {
    super(paramBaseAdapter);
    this.mCallback = paramOnDismissCallback;
  }

  private Animator createAnimatorForView(final View paramView)
  {
    final ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramView.getHeight(), 0 });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public void onAnimationCancel(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        localLayoutParams.height = 0;
        paramView.setLayoutParams(localLayoutParams);
      }

      public void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
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
    return localValueAnimator;
  }

  private List<View> getVisibleViewsForPositions(Collection<Integer> paramCollection)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; ; i++)
    {
      if (i >= getListView().getChildCount())
        return localArrayList;
      View localView = getListView().getChildAt(i);
      if (paramCollection.contains(Integer.valueOf(getListView().getPositionForView(localView))))
        localArrayList.add(localView);
    }
  }

  private void invokeCallback(Collection<Integer> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection);
    Collections.sort(localArrayList);
    int[] arrayOfInt = new int[localArrayList.size()];
    for (int i = 0; ; i++)
    {
      if (i >= localArrayList.size())
      {
        this.mCallback.onDismiss(getListView(), arrayOfInt);
        return;
      }
      arrayOfInt[i] = ((Integer)localArrayList.get(-1 + localArrayList.size() - i)).intValue();
    }
  }

  public void animateDismiss(int paramInt)
  {
    Integer[] arrayOfInteger = new Integer[1];
    arrayOfInteger[0] = Integer.valueOf(paramInt);
    animateDismiss(Arrays.asList(arrayOfInteger));
  }

  public void animateDismiss(Collection<Integer> paramCollection)
  {
    final ArrayList localArrayList1 = new ArrayList(paramCollection);
    Assert.assertNotNull("Call setListView() on this AnimateDismissAdapter before calling setAdapter()!", getListView());
    List localList = getVisibleViewsForPositions(localArrayList1);
    if (!localList.isEmpty())
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = localList.iterator();
      AnimatorSet localAnimatorSet;
      Animator[] arrayOfAnimator;
      if (!localIterator.hasNext())
      {
        localAnimatorSet = new AnimatorSet();
        arrayOfAnimator = new Animator[localArrayList2.size()];
      }
      for (int i = 0; ; i++)
      {
        if (i >= arrayOfAnimator.length)
        {
          localAnimatorSet.playTogether(arrayOfAnimator);
          localAnimatorSet.addListener(new Animator.AnimatorListener()
          {
            public void onAnimationCancel(Animator paramAnonymousAnimator)
            {
            }

            public void onAnimationEnd(Animator paramAnonymousAnimator)
            {
              AnimateDismissAdapter.this.invokeCallback(localArrayList1);
            }

            public void onAnimationRepeat(Animator paramAnonymousAnimator)
            {
            }

            public void onAnimationStart(Animator paramAnonymousAnimator)
            {
            }
          });
          localAnimatorSet.start();
          return;
          localArrayList2.add(createAnimatorForView((View)localIterator.next()));
          break;
        }
        arrayOfAnimator[i] = ((Animator)localArrayList2.get(i));
      }
    }
    invokeCallback(localArrayList1);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.itemmanipulation.AnimateDismissAdapter
 * JD-Core Version:    0.6.2
 */