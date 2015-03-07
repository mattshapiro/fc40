package com.haarman.listviewanimations.itemmanipulation.contextualundo;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.RecyclerListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContextualUndoAdapter extends BaseAdapterDecorator
  implements ContextualUndoListViewTouchListener.Callback
{
  private Map<View, Animator> mActiveAnimators = new ConcurrentHashMap();
  private final int mAnimationTime = 150;
  private long mCurrentRemovedId;
  private ContextualUndoView mCurrentRemovedView;
  private DeleteItemCallback mDeleteItemCallback;
  private final int mUndoActionId;
  private final int mUndoLayoutId;

  public ContextualUndoAdapter(BaseAdapter paramBaseAdapter, int paramInt1, int paramInt2)
  {
    super(paramBaseAdapter);
    this.mUndoLayoutId = paramInt1;
    this.mUndoActionId = paramInt2;
    this.mCurrentRemovedId = -1L;
  }

  private void clearCurrentRemovedView()
  {
    this.mCurrentRemovedView = null;
    this.mCurrentRemovedId = -1L;
  }

  private void performRemoval()
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.mCurrentRemovedView.getHeight();
    arrayOfInt[1] = 1;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(arrayOfInt).setDuration(150L);
    localValueAnimator.addListener(new RemoveViewAnimatorListenerAdapter(this.mCurrentRemovedView));
    localValueAnimator.addUpdateListener(new RemoveViewAnimatorUpdateListener(this.mCurrentRemovedView));
    localValueAnimator.start();
    this.mActiveAnimators.put(this.mCurrentRemovedView, localValueAnimator);
    clearCurrentRemovedView();
  }

  private void removePreviousContextualUndoIfPresent()
  {
    if (this.mCurrentRemovedView != null)
      performRemoval();
  }

  private void restoreViewPosition(View paramView)
  {
    ViewHelper.setAlpha(paramView, 1.0F);
    ViewHelper.setTranslationX(paramView, 0.0F);
  }

  private void setCurrentRemovedView(ContextualUndoView paramContextualUndoView)
  {
    this.mCurrentRemovedView = paramContextualUndoView;
    this.mCurrentRemovedId = paramContextualUndoView.getItemId();
  }

  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ContextualUndoView localContextualUndoView = (ContextualUndoView)paramView;
    if (localContextualUndoView == null)
    {
      localContextualUndoView = new ContextualUndoView(paramViewGroup.getContext(), this.mUndoLayoutId);
      localContextualUndoView.findViewById(this.mUndoActionId).setOnClickListener(new UndoListener(localContextualUndoView));
    }
    localContextualUndoView.updateContentView(super.getView(paramInt, localContextualUndoView.getContentView(), paramViewGroup));
    long l = getItemId(paramInt);
    if (l == this.mCurrentRemovedId)
    {
      localContextualUndoView.displayUndo();
      this.mCurrentRemovedView = localContextualUndoView;
    }
    while (true)
    {
      localContextualUndoView.setItemId(l);
      return localContextualUndoView;
      localContextualUndoView.displayContentView();
    }
  }

  public void onListScrolled()
  {
    if (this.mCurrentRemovedView != null)
      performRemoval();
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    this.mCurrentRemovedId = ((Bundle)paramParcelable).getLong("mCurrentRemovedId", -1L);
  }

  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("mCurrentRemovedId", this.mCurrentRemovedId);
    return localBundle;
  }

  public void onViewSwiped(View paramView, int paramInt)
  {
    ContextualUndoView localContextualUndoView = (ContextualUndoView)paramView;
    if (localContextualUndoView.isContentDisplayed())
    {
      restoreViewPosition(localContextualUndoView);
      localContextualUndoView.displayUndo();
      removePreviousContextualUndoIfPresent();
      setCurrentRemovedView(localContextualUndoView);
    }
    while (this.mCurrentRemovedView == null)
      return;
    performRemoval();
  }

  public void setDeleteItemCallback(DeleteItemCallback paramDeleteItemCallback)
  {
    this.mDeleteItemCallback = paramDeleteItemCallback;
  }

  public void setListView(ListView paramListView)
  {
    super.setListView(paramListView);
    ContextualUndoListViewTouchListener localContextualUndoListViewTouchListener = new ContextualUndoListViewTouchListener(paramListView, this);
    paramListView.setOnTouchListener(localContextualUndoListViewTouchListener);
    paramListView.setOnScrollListener(localContextualUndoListViewTouchListener.makeScrollListener());
    paramListView.setRecyclerListener(new RecycleViewListener(null));
  }

  public static abstract interface DeleteItemCallback
  {
    public abstract void deleteItem(int paramInt);
  }

  private class RecycleViewListener
    implements AbsListView.RecyclerListener
  {
    private RecycleViewListener()
    {
    }

    public void onMovedToScrapHeap(View paramView)
    {
      Animator localAnimator = (Animator)ContextualUndoAdapter.this.mActiveAnimators.get(paramView);
      if (localAnimator != null)
        localAnimator.cancel();
    }
  }

  private class RemoveViewAnimatorListenerAdapter extends AnimatorListenerAdapter
  {
    private final View mDismissView;
    private final int mOriginalHeight;

    public RemoveViewAnimatorListenerAdapter(View arg2)
    {
      Object localObject;
      this.mDismissView = localObject;
      this.mOriginalHeight = localObject.getHeight();
    }

    private void deleteCurrentItem()
    {
      ContextualUndoView localContextualUndoView = (ContextualUndoView)this.mDismissView;
      int i = ContextualUndoAdapter.this.getListView().getPositionForView(localContextualUndoView);
      ContextualUndoAdapter.this.mDeleteItemCallback.deleteItem(i);
    }

    private void restoreViewDimension(View paramView)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.height = this.mOriginalHeight;
      paramView.setLayoutParams(localLayoutParams);
    }

    public void onAnimationEnd(Animator paramAnimator)
    {
      ContextualUndoAdapter.this.mActiveAnimators.remove(this.mDismissView);
      ContextualUndoAdapter.this.restoreViewPosition(this.mDismissView);
      restoreViewDimension(this.mDismissView);
      deleteCurrentItem();
    }
  }

  private class RemoveViewAnimatorUpdateListener
    implements ValueAnimator.AnimatorUpdateListener
  {
    private final View mDismissView;
    private final ViewGroup.LayoutParams mLayoutParams;

    public RemoveViewAnimatorUpdateListener(View arg2)
    {
      Object localObject;
      this.mDismissView = localObject;
      this.mLayoutParams = localObject.getLayoutParams();
    }

    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      this.mLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.mDismissView.setLayoutParams(this.mLayoutParams);
    }
  }

  private class UndoListener
    implements View.OnClickListener
  {
    private final ContextualUndoView mContextualUndoView;

    public UndoListener(ContextualUndoView arg2)
    {
      Object localObject;
      this.mContextualUndoView = localObject;
    }

    private void animateViewComingBack()
    {
      ViewPropertyAnimator.animate(this.mContextualUndoView).translationX(0.0F).setDuration(150L).setListener(null);
    }

    private void moveViewOffScreen()
    {
      ViewHelper.setTranslationX(this.mContextualUndoView, this.mContextualUndoView.getWidth());
    }

    public void onClick(View paramView)
    {
      ContextualUndoAdapter.this.clearCurrentRemovedView();
      this.mContextualUndoView.displayContentView();
      moveViewOffScreen();
      animateViewComingBack();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.itemmanipulation.contextualundo.ContextualUndoAdapter
 * JD-Core Version:    0.6.2
 */