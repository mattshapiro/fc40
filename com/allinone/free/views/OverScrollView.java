package com.allinone.free.views;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import java.util.Timer;
import java.util.TimerTask;

public class OverScrollView extends ScrollView
{
  public static final String TAG = "PullToRefreshLayout";
  private static final int TRIGGER_HEIGHT = 120;
  public float MOVE_SPEED = 8.0F;
  private boolean canPullDown = true;
  private boolean canPullUp = true;
  private float downY;
  private boolean isLayout = false;
  private float lastY;
  private int mEvents;
  private OverScrollListener mOverScrollListener;
  private OverScrollTinyListener mOverScrollTinyListener;
  private int mOverScrollTrigger = 120;
  private float overScrollDistance;
  public float pullDownY = 0.0F;
  private float pullUpY = 0.0F;
  private View pullableView;
  private float radio = 2.0F;
  private MyTimer timer;
  Handler updateHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      OverScrollView.this.MOVE_SPEED = ((float)(5.0D + 15.0D * Math.tan(1.570796326794897D / OverScrollView.this.getMeasuredHeight() * (OverScrollView.this.pullDownY + Math.abs(OverScrollView.this.pullUpY)))));
      if (OverScrollView.this.pullDownY > 0.0F)
      {
        OverScrollView localOverScrollView2 = OverScrollView.this;
        localOverScrollView2.pullDownY -= OverScrollView.this.MOVE_SPEED;
      }
      while (true)
      {
        if (OverScrollView.this.pullDownY < 0.0F)
        {
          OverScrollView.this.pullDownY = 0.0F;
          OverScrollView.this.timer.cancel();
        }
        if (OverScrollView.this.pullUpY > 0.0F)
        {
          OverScrollView.this.pullUpY = 0.0F;
          OverScrollView.this.timer.cancel();
        }
        OverScrollView.this.requestLayout();
        return;
        if (OverScrollView.this.pullUpY < 0.0F)
        {
          OverScrollView localOverScrollView1 = OverScrollView.this;
          localOverScrollView1.pullUpY += OverScrollView.this.MOVE_SPEED;
        }
      }
    }
  };

  public OverScrollView(Context paramContext)
  {
    super(paramContext);
    initView(paramContext);
  }

  public OverScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initView(paramContext);
  }

  public OverScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }

  private void hide()
  {
    this.timer.schedule(5L);
  }

  private void initView(Context paramContext)
  {
    this.timer = new MyTimer(this.updateHandler);
    setFadingEdgeLength(0);
  }

  private boolean isCanPullDown()
  {
    return (getScrollY() == 0) || (this.pullableView.getHeight() < getHeight() + getScrollY());
  }

  private boolean isCanPullUp()
  {
    return this.pullableView.getHeight() <= getHeight() + getScrollY();
  }

  private boolean isOnBottom()
  {
    return getScrollY() + getHeight() == this.pullableView.getHeight();
  }

  private boolean isOnTop()
  {
    return getScrollY() == 0;
  }

  private void overScrollTrigger()
  {
    if (this.mOverScrollListener == null);
    do
    {
      return;
      if ((this.overScrollDistance > this.mOverScrollTrigger) && (this.overScrollDistance >= 0.0F))
        this.mOverScrollListener.headerScroll();
    }
    while ((this.overScrollDistance >= -this.mOverScrollTrigger) || (this.overScrollDistance >= 0.0F));
    this.mOverScrollListener.footerScroll();
  }

  private void releasePull()
  {
    this.canPullDown = true;
    this.canPullUp = true;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
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
    try
    {
      while (true)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
        this.downY = paramMotionEvent.getY();
        this.lastY = this.downY;
        this.timer.cancel();
        this.mEvents = 0;
        releasePull();
        continue;
        this.mEvents = -1;
        continue;
        float f = paramMotionEvent.getY() - this.lastY;
        if (this.mEvents == 0)
          if ((this.canPullDown) && (isCanPullDown()))
          {
            this.pullDownY += f / this.radio;
            if (paramMotionEvent.getY() - this.lastY < 0.0F)
              this.pullDownY = (f + this.pullDownY);
            if (this.pullDownY < 0.0F)
            {
              this.pullDownY = 0.0F;
              this.canPullDown = false;
              this.canPullUp = true;
            }
            if (this.pullDownY > getMeasuredHeight())
              this.pullDownY = getMeasuredHeight();
            this.overScrollDistance = this.pullDownY;
          }
        while (true)
        {
          this.lastY = paramMotionEvent.getY();
          this.radio = ((float)(2.0D + 3.0D * Math.tan(1.570796326794897D / getMeasuredHeight() * (this.pullDownY + Math.abs(this.pullUpY)))));
          requestLayout();
          if (this.pullDownY + Math.abs(this.pullUpY) > 8.0F)
            paramMotionEvent.setAction(3);
          if (this.mOverScrollTinyListener == null)
            break;
          this.mOverScrollTinyListener.scrollDistance((int)f, (int)this.overScrollDistance);
          break;
          if ((this.canPullUp) && (isCanPullUp()))
          {
            this.pullUpY += f / this.radio;
            if (paramMotionEvent.getY() - this.lastY > 0.0F)
              this.pullUpY = (f + this.pullUpY);
            if (this.pullUpY > 0.0F)
            {
              this.pullUpY = 0.0F;
              this.canPullDown = true;
              this.canPullUp = false;
            }
            if (this.pullUpY < -getMeasuredHeight())
              this.pullUpY = (-getMeasuredHeight());
            this.overScrollDistance = this.pullUpY;
          }
          else
          {
            releasePull();
            continue;
            this.mEvents = 0;
          }
        }
        hide();
        overScrollTrigger();
        if ((this.mOverScrollTinyListener != null) && ((isCanPullDown()) || (isCanPullUp())))
        {
          this.mOverScrollTinyListener.scrollLoosen();
          continue;
          if ((this.mOverScrollTinyListener != null) && ((isCanPullDown()) || (isCanPullUp())))
            this.mOverScrollTinyListener.scrollLoosen();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }

  public OverScrollListener getOverScrollListener()
  {
    return this.mOverScrollListener;
  }

  public OverScrollTinyListener getOverScrollTinyListener()
  {
    return this.mOverScrollTinyListener;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.isLayout)
    {
      this.pullableView = getChildAt(0);
      this.isLayout = true;
    }
    this.pullableView.layout(0, (int)(this.pullDownY + this.pullUpY), this.pullableView.getMeasuredWidth(), (int)(this.pullDownY + this.pullUpY) + this.pullableView.getMeasuredHeight());
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
 * Qualified Name:     com.allinone.free.views.OverScrollView
 * JD-Core Version:    0.6.2
 */