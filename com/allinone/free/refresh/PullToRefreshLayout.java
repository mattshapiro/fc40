package com.allinone.free.refresh;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;

public class PullToRefreshLayout extends RelativeLayout
{
  public static final int DONE = 3;
  public static final int FAIL = 1;
  public static final int INIT = 0;
  public static final int REFRESHING = 2;
  public static final int RELEASE_TO_REFRESH = 1;
  public static final int SUCCEED = 0;
  public static final String TAG = "PullToRefreshLayout";
  public float MOVE_SPEED = 8.0F;
  private float downY;
  private boolean isLayout = false;
  private boolean isTouch = false;
  private float lastY;
  private int mEvents;
  private OnRefreshListener mListener;
  public float pullDownY = 0.0F;
  private View pullView;
  private View pullableView;
  private float radio = 2.0F;
  private float refreshDist = 200.0F;
  private View refreshStateImageView;
  private TextView refreshStateTextView;
  private View refreshView;
  private RotateAnimation refreshingAnimation;
  private View refreshingView;
  private RotateAnimation rotateAnimation;
  private int state = 0;
  private MyTimer timer;
  Handler updateHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      PullToRefreshLayout.this.MOVE_SPEED = ((float)(8.0D + 20.0D * Math.tan(1.570796326794897D / PullToRefreshLayout.this.getMeasuredHeight() * PullToRefreshLayout.this.pullDownY)));
      if ((!PullToRefreshLayout.this.isTouch) && (PullToRefreshLayout.this.state == 2) && (PullToRefreshLayout.this.pullDownY <= PullToRefreshLayout.this.refreshDist))
      {
        PullToRefreshLayout.this.pullDownY = PullToRefreshLayout.this.refreshDist;
        PullToRefreshLayout.this.timer.cancel();
      }
      if (PullToRefreshLayout.this.pullDownY > 0.0F)
      {
        PullToRefreshLayout localPullToRefreshLayout = PullToRefreshLayout.this;
        localPullToRefreshLayout.pullDownY -= PullToRefreshLayout.this.MOVE_SPEED;
      }
      if (PullToRefreshLayout.this.pullDownY <= 0.0F)
      {
        PullToRefreshLayout.this.pullDownY = 0.0F;
        PullToRefreshLayout.this.pullView.clearAnimation();
        if (PullToRefreshLayout.this.state != 2)
          PullToRefreshLayout.this.changeState(0);
        PullToRefreshLayout.this.timer.cancel();
      }
      PullToRefreshLayout.this.requestLayout();
    }
  };

  public PullToRefreshLayout(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }

  public PullToRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }

  public PullToRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }

  private void changeState(int paramInt)
  {
    this.state = paramInt;
    switch (this.state)
    {
    default:
      return;
    case 0:
      this.refreshStateImageView.setVisibility(8);
      this.refreshStateTextView.setText(2131099753);
      this.pullView.startAnimation((RotateAnimation)AnimationUtils.loadAnimation(getContext(), 2130968580));
      this.pullView.setVisibility(0);
      return;
    case 1:
      this.refreshStateTextView.setText(2131099754);
      this.pullView.startAnimation(this.rotateAnimation);
      return;
    case 2:
    }
    this.pullView.clearAnimation();
    this.refreshingView.setVisibility(0);
    this.pullView.setVisibility(4);
    this.refreshingView.startAnimation(this.refreshingAnimation);
    this.refreshStateTextView.setText(2131099755);
  }

  private void hide()
  {
    this.timer.schedule(5L);
  }

  private void initView()
  {
    this.pullView = this.refreshView.findViewById(2131231017);
    this.refreshStateTextView = ((TextView)this.refreshView.findViewById(2131231015));
    this.refreshingView = this.refreshView.findViewById(2131231013);
    this.refreshStateImageView = this.refreshView.findViewById(2131231016);
  }

  private void initView(Context paramContext)
  {
    this.timer = new MyTimer(this.updateHandler);
    this.rotateAnimation = ((RotateAnimation)AnimationUtils.loadAnimation(paramContext, 2130968579));
    this.refreshingAnimation = ((RotateAnimation)AnimationUtils.loadAnimation(paramContext, 2130968581));
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    this.rotateAnimation.setInterpolator(localLinearInterpolator);
    this.refreshingAnimation.setInterpolator(localLinearInterpolator);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    case 3:
    case 4:
    default:
    case 0:
    case 5:
    case 6:
    case 2:
    case 1:
    }
    while (true)
    {
      super.dispatchTouchEvent(paramMotionEvent);
      return true;
      this.downY = paramMotionEvent.getY();
      this.lastY = this.downY;
      this.timer.cancel();
      this.mEvents = 0;
      continue;
      this.mEvents = -1;
      continue;
      if (this.mEvents == 0)
        if (((Pullable)this.pullableView).canPullDown())
        {
          this.pullDownY += (paramMotionEvent.getY() - this.lastY) / this.radio;
          if (paramMotionEvent.getY() - this.lastY < 0.0F)
            this.pullDownY += paramMotionEvent.getY() - this.lastY;
          if (this.pullDownY < 0.0F)
            this.pullDownY = 0.0F;
          if (this.pullDownY > getMeasuredHeight())
            this.pullDownY = getMeasuredHeight();
          if (this.state == 2)
            this.isTouch = true;
        }
      while (true)
      {
        this.lastY = paramMotionEvent.getY();
        this.radio = ((float)(2.0D + 3.0D * Math.tan(1.570796326794897D / getMeasuredHeight() * this.pullDownY)));
        requestLayout();
        if ((this.pullDownY <= this.refreshDist) && ((this.state == 1) || (this.state == 3)))
          changeState(0);
        if ((this.pullDownY >= this.refreshDist) && (this.state == 0))
          changeState(1);
        if (this.pullDownY <= 8.0F)
          break;
        paramMotionEvent.setAction(3);
        break;
        this.mEvents = 0;
      }
      if (this.pullDownY > this.refreshDist)
        this.isTouch = false;
      if (this.state == 1)
      {
        changeState(2);
        if (this.mListener != null)
          this.mListener.onRefresh(this);
      }
      hide();
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.isLayout)
    {
      this.refreshView = getChildAt(0);
      this.pullableView = getChildAt(1);
      this.isLayout = true;
      initView();
      this.refreshDist = ((ViewGroup)this.refreshView).getChildAt(0).getMeasuredHeight();
    }
    this.refreshView.layout(0, (int)this.pullDownY - this.refreshView.getMeasuredHeight(), this.refreshView.getMeasuredWidth(), (int)this.pullDownY);
    this.pullableView.layout(0, (int)this.pullDownY, this.pullableView.getMeasuredWidth(), (int)this.pullDownY + this.pullableView.getMeasuredHeight());
  }

  public void refreshFinish(int paramInt)
  {
    this.refreshingView.clearAnimation();
    this.refreshingView.setVisibility(8);
    switch (paramInt)
    {
    default:
      this.refreshStateImageView.setVisibility(0);
      this.refreshStateTextView.setText(2131099757);
      this.refreshStateImageView.setBackgroundResource(2130837738);
    case 0:
    }
    while (true)
    {
      new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          PullToRefreshLayout.this.changeState(3);
          if (!PullToRefreshLayout.this.isTouch)
            PullToRefreshLayout.this.hide();
        }
      }
      .sendEmptyMessageDelayed(0, 1000L);
      return;
      this.refreshStateImageView.setVisibility(0);
      this.refreshStateTextView.setText(2131099756);
      this.refreshStateImageView.setBackgroundResource(2130837739);
    }
  }

  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.mListener = paramOnRefreshListener;
  }

  class MyTimer
  {
    private Handler handler;
    private MyTask mTask;
    private Timer timer;

    public MyTimer(Handler arg2)
    {
      Object localObject;
      this.handler = localObject;
      this.timer = new Timer();
    }

    public void cancel()
    {
      if (this.mTask != null)
      {
        this.mTask.cancel();
        this.mTask = null;
      }
    }

    public void schedule(long paramLong)
    {
      if (this.mTask != null)
      {
        this.mTask.cancel();
        this.mTask = null;
      }
      this.mTask = new MyTask(this.handler);
      this.timer.schedule(this.mTask, 0L, paramLong);
    }

    class MyTask extends TimerTask
    {
      private Handler handler;

      public MyTask(Handler arg2)
      {
        Object localObject;
        this.handler = localObject;
      }

      public void run()
      {
        this.handler.obtainMessage().sendToTarget();
      }
    }
  }

  public static abstract interface OnRefreshListener
  {
    public abstract void onRefresh(PullToRefreshLayout paramPullToRefreshLayout);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.refresh.PullToRefreshLayout
 * JD-Core Version:    0.6.2
 */