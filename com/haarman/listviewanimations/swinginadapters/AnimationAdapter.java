package com.haarman.listviewanimations.swinginadapters;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import junit.framework.Assert;

public abstract class AnimationAdapter extends BaseAdapterDecorator
{
  protected static final long DEFAULTANIMATIONDELAYMILLIS = 100L;
  protected static final long DEFAULTANIMATIONDURATIONMILLIS = 300L;
  private static final long INITIALDELAYMILLIS = 150L;
  private long mAnimationStartMillis = -1L;
  private SparseArray<AnimationInfo> mAnimators = new SparseArray();
  private boolean mHasParentAnimationAdapter;
  private int mLastAnimatedPosition = -1;

  public AnimationAdapter(BaseAdapter paramBaseAdapter)
  {
    super(paramBaseAdapter);
    if ((paramBaseAdapter instanceof AnimationAdapter))
      ((AnimationAdapter)paramBaseAdapter).setHasParentAnimationAdapter(true);
  }

  private void animateView(int paramInt, ViewGroup paramViewGroup, View paramView)
  {
    if (this.mAnimationStartMillis == -1L)
      this.mAnimationStartMillis = System.currentTimeMillis();
    hideView(paramView);
    if ((this.mDecoratedBaseAdapter instanceof AnimationAdapter));
    for (Animator[] arrayOfAnimator1 = ((AnimationAdapter)this.mDecoratedBaseAdapter).getAnimators(paramViewGroup, paramView); ; arrayOfAnimator1 = new Animator[0])
    {
      Animator[] arrayOfAnimator2 = getAnimators(paramViewGroup, paramView);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(concatAnimators(arrayOfAnimator1, arrayOfAnimator2, localObjectAnimator));
      localAnimatorSet.setStartDelay(calculateAnimationDelay());
      localAnimatorSet.setDuration(getAnimationDurationMillis());
      localAnimatorSet.start();
      this.mAnimators.put(paramView.hashCode(), new AnimationInfo(paramInt, localAnimatorSet));
      return;
    }
  }

  private void animateViewIfNecessary(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt > this.mLastAnimatedPosition) && (!this.mHasParentAnimationAdapter))
    {
      animateView(paramInt, paramViewGroup, paramView);
      this.mLastAnimatedPosition = paramInt;
    }
  }

  private long calculateAnimationDelay()
  {
    if (1 + (getListView().getLastVisiblePosition() - getListView().getFirstVisiblePosition()) < this.mLastAnimatedPosition);
    for (long l = getAnimationDelayMillis(); ; l = (1 + this.mLastAnimatedPosition) * getAnimationDelayMillis() + (150L + this.mAnimationStartMillis) - System.currentTimeMillis())
      return Math.max(0L, l);
  }

  private Animator[] concatAnimators(Animator[] paramArrayOfAnimator1, Animator[] paramArrayOfAnimator2, Animator paramAnimator)
  {
    Animator[] arrayOfAnimator = new Animator[1 + (paramArrayOfAnimator1.length + paramArrayOfAnimator2.length)];
    int i = 0;
    if (i >= paramArrayOfAnimator2.length);
    for (int j = 0; ; j++)
    {
      if (j >= paramArrayOfAnimator1.length)
      {
        arrayOfAnimator[(-1 + arrayOfAnimator.length)] = paramAnimator;
        return arrayOfAnimator;
        arrayOfAnimator[i] = paramArrayOfAnimator2[i];
        i++;
        break;
      }
      arrayOfAnimator[i] = paramArrayOfAnimator1[j];
      i++;
    }
  }

  private void hideView(View paramView)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.setDuration(0L);
    localAnimatorSet.start();
  }

  protected abstract long getAnimationDelayMillis();

  protected abstract long getAnimationDurationMillis();

  public abstract Animator[] getAnimators(ViewGroup paramViewGroup, View paramView);

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = this.mHasParentAnimationAdapter;
    int i = 0;
    if (!bool)
    {
      Assert.assertNotNull("Call setListView() on this AnimationAdapter before setAdapter()!", getListView());
      i = 0;
      if (paramView != null)
      {
        int j = paramView.hashCode();
        AnimationInfo localAnimationInfo = (AnimationInfo)this.mAnimators.get(j);
        i = 0;
        if (localAnimationInfo != null)
        {
          if (localAnimationInfo.position == paramInt)
            break label116;
          localAnimationInfo.animator.end();
          this.mAnimators.remove(j);
        }
      }
    }
    while (true)
    {
      View localView = super.getView(paramInt, paramView, paramViewGroup);
      if ((!this.mHasParentAnimationAdapter) && (i == 0))
        animateViewIfNecessary(paramInt, localView, paramViewGroup);
      return localView;
      label116: i = 1;
    }
  }

  public void reset()
  {
    this.mAnimators.clear();
    this.mLastAnimatedPosition = -1;
    this.mAnimationStartMillis = -1L;
    if ((getDecoratedBaseAdapter() instanceof AnimationAdapter))
      ((AnimationAdapter)getDecoratedBaseAdapter()).reset();
  }

  public void setHasParentAnimationAdapter(boolean paramBoolean)
  {
    this.mHasParentAnimationAdapter = paramBoolean;
  }

  private class AnimationInfo
  {
    public Animator animator;
    public int position;

    public AnimationInfo(int paramAnimator, Animator arg3)
    {
      this.position = paramAnimator;
      Object localObject;
      this.animator = localObject;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.swinginadapters.AnimationAdapter
 * JD-Core Version:    0.6.2
 */