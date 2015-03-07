package com.allinone.free.refresh;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PullableListView extends ListView
  implements Pullable
{
  public static final int INIT = 0;
  public static final int LOADING = 1;
  public static final int NO_MORE_DATA = 2;
  private boolean autoLoad = true;
  private boolean canLoad = true;
  private boolean hasMoreData = true;
  private AnimationDrawable mLoadAnim;
  private ImageView mLoadingView;
  private View mLoadmoreView;
  private OnLoadListener mOnLoadListener;
  private TextView mStateTextView;
  private int state = 0;

  public PullableListView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }

  public PullableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }

  public PullableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }

  private void changeState(int paramInt)
  {
    this.state = paramInt;
    switch (paramInt)
    {
    default:
      return;
    case 0:
      this.mLoadAnim.stop();
      this.mLoadingView.setVisibility(4);
      this.mStateTextView.setText(2131099758);
      return;
    case 1:
      this.mLoadingView.setVisibility(0);
      this.mLoadAnim.start();
      this.mStateTextView.setText(2131099759);
      return;
    case 2:
    }
    this.mLoadAnim.stop();
    this.mLoadingView.setVisibility(4);
    this.mStateTextView.setText("No More Data");
  }

  private void checkLoad()
  {
    if ((reachBottom()) && (this.mOnLoadListener != null) && (this.state != 1) && (this.canLoad) && (this.autoLoad) && (this.hasMoreData))
      load();
  }

  private void init(Context paramContext)
  {
    this.mLoadmoreView = LayoutInflater.from(paramContext).inflate(2130903104, null);
    this.mLoadingView = ((ImageView)this.mLoadmoreView.findViewById(2131230961));
    this.mLoadingView.setBackgroundResource(2130968578);
    this.mLoadAnim = ((AnimationDrawable)this.mLoadingView.getBackground());
    this.mStateTextView = ((TextView)this.mLoadmoreView.findViewById(2131230962));
    this.mLoadmoreView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((PullableListView.this.state != 1) && (PullableListView.this.hasMoreData))
          PullableListView.this.load();
      }
    });
    addFooterView(this.mLoadmoreView, null, false);
  }

  private void load()
  {
    changeState(1);
    this.mOnLoadListener.onLoad(this);
  }

  private boolean reachBottom()
  {
    if (getCount() == 0);
    while ((getLastVisiblePosition() == -1 + getCount()) && (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null) && (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getTop() < getMeasuredHeight()) && (!canPullDown()))
      return true;
    return false;
  }

  public boolean canPullDown()
  {
    if (getCount() == 0);
    while ((getFirstVisiblePosition() == 0) && (getChildAt(0).getTop() >= 0))
      return true;
    return false;
  }

  public boolean canPullUp()
  {
    return false;
  }

  public void enableAutoLoad(boolean paramBoolean)
  {
    this.autoLoad = paramBoolean;
  }

  public void finishLoading()
  {
    changeState(0);
  }

  public boolean isHasMoreData()
  {
    return this.hasMoreData;
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    checkLoad();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.canLoad = false;
      continue;
      this.canLoad = true;
      checkLoad();
    }
  }

  public void setHasMoreData(boolean paramBoolean)
  {
    this.hasMoreData = paramBoolean;
    if (!paramBoolean)
    {
      changeState(2);
      return;
    }
    changeState(0);
  }

  public void setLoadmoreVisible(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (getFooterViewsCount() == 0)
        addFooterView(this.mLoadmoreView, null, false);
      return;
    }
    removeFooterView(this.mLoadmoreView);
  }

  public void setOnLoadListener(OnLoadListener paramOnLoadListener)
  {
    this.mOnLoadListener = paramOnLoadListener;
  }

  public static abstract interface OnLoadListener
  {
    public abstract void onLoad(PullableListView paramPullableListView);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.refresh.PullableListView
 * JD-Core Version:    0.6.2
 */