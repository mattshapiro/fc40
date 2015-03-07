package com.haarman.listviewanimations.swinginadapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.nineoldandroids.animation.Animator;

public abstract class SingleAnimationAdapter extends AnimationAdapter
{
  public SingleAnimationAdapter(BaseAdapter paramBaseAdapter)
  {
    super(paramBaseAdapter);
  }

  protected abstract Animator getAnimator(ViewGroup paramViewGroup, View paramView);

  public Animator[] getAnimators(ViewGroup paramViewGroup, View paramView)
  {
    return new Animator[] { getAnimator(paramViewGroup, paramView) };
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.swinginadapters.SingleAnimationAdapter
 * JD-Core Version:    0.6.2
 */