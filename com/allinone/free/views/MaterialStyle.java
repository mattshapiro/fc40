package com.allinone.free.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.allinone.free.R.styleable;

public class MaterialStyle
{
  public static final int TYPE_HEADBAR_BACK_BTN = 1;
  public static final int TYPE_HEADBAR_RIGHT_BTN = 2;
  public static final int TYPE_HEADER_CENTER_BTN = 3;
  public static final int TYPE_NORMAL_BTN;
  private int ANIM_FAST_TIME = 125;
  private final int ANIM_SLEEP_TIME = 10;
  private final int ANIM_SLOW_TIME = 200;
  private final int SHAPE_MODE_EQUAL = 0;
  private final int SHAPE_MODE_HEIGHT = 2;
  private final int SHAPE_MODE_WIDTH = 1;
  private final int STATUS_ANIM_FAST = 1;
  private final int STATUS_ANIM_SLOWLY = 2;
  private final int STATUS_NORMAL = 0;
  private final int STATUS_PRESSED = 3;
  private final int STATUS_TO_NORMAL = 4;
  private float actionDownX;
  private float actionDownY;
  private int animFastTimes;
  private int animSlowTimes;
  private PaintFlagsDrawFilter drawFilter = new PaintFlagsDrawFilter(0, 3);
  private boolean hasClick = false;
  private Paint mAnimBottomPaint = new Paint();
  private int mAnimColorAlpha = 0;
  private int mAnimColorAlphaFastSpeed;
  private int mAnimColorAlphaMax = 15;
  private int mAnimColorAlphaSlowSpeed;
  private int mAnimColorAlphaToNormalSpeed;
  private int mAnimFullColor = -1;
  private int mAnimMode = 0;
  private int mBackgroundColor = 0;
  private Drawable mBackgroundDrawable;
  private int mBackgroundHeight;
  private int mBackgroundWidth;
  private IMaterial mCallBack;
  private float mCirRSpeedFast;
  private float mCirRSpeedSlow;
  private Paint mCirclePaint = new Paint();
  private float mCircleRadius;
  private float mCircleRadiusMax;
  private View mDependView;
  private boolean mNeedDelayClick = true;
  private Path mPath = new Path();
  private int status = 0;
  private int type = 0;

  @SuppressLint({"NewApi"})
  public MaterialStyle(View paramView, AttributeSet paramAttributeSet)
  {
    this.mCallBack = ((IMaterial)paramView);
    this.mDependView = paramView;
    paramView.setClickable(true);
    setBackgroundColor(0);
    this.animSlowTimes = 20;
    this.animFastTimes = (this.ANIM_FAST_TIME / 10);
    if (Build.VERSION.SDK_INT >= 11)
      paramView.setLayerType(1, null);
    paramView.setWillNotDraw(false);
    if (paramAttributeSet != null)
    {
      TypedArray localTypedArray = paramView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.LButtonStyle);
      this.mNeedDelayClick = localTypedArray.getBoolean(2, true);
      this.mAnimFullColor = localTypedArray.getInt(0, -1);
      this.mBackgroundDrawable = localTypedArray.getDrawable(1);
      if (this.mBackgroundDrawable != null)
      {
        this.mBackgroundWidth = this.mBackgroundDrawable.getIntrinsicWidth();
        this.mBackgroundHeight = this.mBackgroundDrawable.getIntrinsicHeight();
      }
      this.type = localTypedArray.getInt(3, 0);
      localTypedArray.recycle();
    }
  }

  private int getHeight()
  {
    if (this.mDependView == null)
      return 0;
    return this.mDependView.getHeight();
  }

  private int getWidth()
  {
    if (this.mDependView == null)
      return 0;
    return this.mDependView.getWidth();
  }

  private void init()
  {
    float f1 = this.mDependView.getWidth();
    float f2 = this.mDependView.getHeight();
    if ((f1 <= 0.0F) || (f2 <= 0.0F))
      return;
    int i;
    if (Math.min(f1, f2) / Math.max(f1, f2) > 0.8F)
    {
      i = 1;
      if (i == 0)
        break label140;
      this.mAnimMode = 0;
      label59: switch (this.type)
      {
      default:
      case 1:
      case 2:
      case 0:
      case 3:
      }
    }
    while (true)
    {
      this.mCirRSpeedSlow = ((this.mCircleRadiusMax - this.mCircleRadius) / this.animSlowTimes);
      this.mCirRSpeedFast = ((this.mCircleRadiusMax - this.mCircleRadius) / this.animFastTimes);
      initColorInfo();
      return;
      i = 0;
      break;
      label140: if (f1 > f2)
      {
        this.mAnimMode = 1;
        break label59;
      }
      this.mAnimMode = 2;
      break label59;
      this.mCircleRadius = (f2 / 2.0F);
      this.mCircleRadiusMax = f1;
      if (this.mAnimFullColor == -1)
      {
        this.mAnimFullColor = 822083583;
        continue;
        this.mCircleRadius = (Math.min(f1, f2) / 4.0F);
        if (this.mAnimMode == 0);
        for (this.mCircleRadiusMax = (Math.min(f1, f2) / 2.0F); this.mAnimFullColor == -1; this.mCircleRadiusMax = (Math.max(f1, f2) / 2.0F))
        {
          this.mAnimFullColor = 805306368;
          break;
        }
        this.mCircleRadius = (Math.min(f1, f2) / 4.0F);
        this.mCircleRadiusMax = (Math.max(f1, f2) / 2.0F);
        if (this.mAnimFullColor == -1)
          this.mAnimFullColor = 822083583;
      }
    }
  }

  private void initColorInfo()
  {
    this.mAnimBottomPaint.setColor(Color.rgb(Color.red(this.mAnimFullColor), Color.green(this.mAnimFullColor), Color.blue(this.mAnimFullColor)));
    this.mAnimColorAlphaMax = Color.alpha(this.mAnimFullColor);
    this.mCirclePaint.setColor(Color.rgb(Color.red(this.mAnimFullColor), Color.green(this.mAnimFullColor), Color.blue(this.mAnimFullColor)));
    this.mCirclePaint.setAlpha(this.mAnimColorAlphaMax);
    this.mAnimBottomPaint.setAlpha(0);
    this.mAnimColorAlphaSlowSpeed = (this.mAnimColorAlphaMax / this.animSlowTimes);
    this.mAnimColorAlphaFastSpeed = (this.mAnimColorAlphaMax / this.animFastTimes);
    if (this.mAnimColorAlphaSlowSpeed < 1)
      this.mAnimColorAlphaSlowSpeed = 1;
    if (this.mAnimColorAlphaFastSpeed < 1)
      this.mAnimColorAlphaFastSpeed = 1;
    this.mAnimColorAlphaToNormalSpeed = this.mAnimColorAlphaFastSpeed;
  }

  private void move()
  {
    if ((this.status == 0) || (this.status == 3))
      return;
    if (this.status == 2)
    {
      this.mAnimColorAlpha += this.mAnimColorAlphaSlowSpeed;
      this.mCircleRadius += this.mCirRSpeedSlow;
    }
    while (true)
    {
      if (this.mAnimColorAlpha >= this.mAnimColorAlphaMax)
        this.mAnimColorAlpha = this.mAnimColorAlphaMax;
      if (this.mAnimColorAlpha < 0)
        this.mAnimColorAlpha = 0;
      this.mAnimBottomPaint.setAlpha(this.mAnimColorAlpha);
      if (this.mCircleRadius > this.mCircleRadiusMax)
        this.mCircleRadius = this.mCircleRadiusMax;
      if ((this.mAnimColorAlpha <= 0) || (this.mAnimColorAlpha >= this.mAnimColorAlphaMax))
        reset();
      this.mDependView.invalidate();
      return;
      if (this.status == 1)
      {
        this.mAnimColorAlpha += this.mAnimColorAlphaFastSpeed;
        this.mCircleRadius += this.mCirRSpeedFast;
      }
      else if (this.status == 4)
      {
        this.mAnimColorAlpha -= this.mAnimColorAlphaToNormalSpeed;
        this.mCircleRadius = this.mCircleRadiusMax;
      }
    }
  }

  private void reset()
  {
    switch (this.status)
    {
    default:
    case 1:
    case 3:
    case 2:
    case 4:
    }
    while (true)
    {
      this.mDependView.invalidate();
      return;
      this.mCircleRadius = this.mCircleRadiusMax;
      this.status = 4;
      continue;
      this.status = 3;
      if ((this.type == 1) || (this.type == 2))
      {
        this.mCircleRadius = getWidth();
        continue;
        if ((this.mNeedDelayClick) && (this.hasClick))
        {
          if (this.mCallBack != null)
            this.mCallBack.perfirmSuperClick();
          this.hasClick = false;
        }
        resetStatus();
      }
    }
  }

  public void dispatchKeyEvent()
  {
  }

  public void doDraw(Canvas paramCanvas)
  {
    if ((this.mCircleRadius == 0.0F) || (this.mCircleRadiusMax == 0.0F))
      init();
    paramCanvas.setDrawFilter(this.drawFilter);
    paramCanvas.save();
    if (this.mBackgroundDrawable != null)
    {
      this.mBackgroundDrawable.setBounds(0, 0, getWidth(), getHeight());
      this.mBackgroundDrawable.draw(paramCanvas);
      switch (this.status)
      {
      case 0:
      default:
      case 3:
      case 1:
      case 2:
      case 4:
      }
    }
    while (true)
    {
      paramCanvas.restore();
      move();
      return;
      if (this.mBackgroundColor == 0)
        break;
      paramCanvas.drawColor(this.mBackgroundColor);
      break;
      switch (this.type)
      {
      default:
        break;
      case 0:
        if (this.mAnimMode == 0)
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.min(getWidth(), getHeight()) / 2, this.mAnimBottomPaint);
        break;
      case 1:
        paramCanvas.drawCircle(0.0F, getHeight() / 2, getWidth(), this.mAnimBottomPaint);
        break;
      case 2:
        paramCanvas.drawCircle(getWidth(), getHeight() / 2, getWidth(), this.mAnimBottomPaint);
        continue;
        paramCanvas.drawPaint(this.mAnimBottomPaint);
        break;
      case 3:
        paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, Math.max(getWidth(), getHeight()) / 2, this.mAnimBottomPaint);
        continue;
        switch (this.type)
        {
        default:
          break;
        case 0:
          this.mPath.reset();
          this.mPath.addCircle(this.actionDownX, this.actionDownY, this.mCircleRadius, Path.Direction.CCW);
          paramCanvas.drawPath(this.mPath, this.mCirclePaint);
          paramCanvas.clipPath(this.mPath, Region.Op.XOR);
          if (this.mAnimMode == 0)
            paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mCircleRadiusMax, this.mAnimBottomPaint);
          break;
        case 1:
          this.mPath.reset();
          this.mPath.addCircle(0.0F, getHeight() / 2, this.mCircleRadius, Path.Direction.CCW);
          paramCanvas.drawPath(this.mPath, this.mCirclePaint);
          paramCanvas.clipPath(this.mPath, Region.Op.XOR);
          paramCanvas.drawCircle(0.0F, getHeight() / 2, this.mCircleRadiusMax, this.mAnimBottomPaint);
          break;
        case 2:
          this.mPath.reset();
          this.mPath.addCircle(getWidth(), getHeight() / 2, this.mCircleRadius, Path.Direction.CCW);
          paramCanvas.drawPath(this.mPath, this.mCirclePaint);
          paramCanvas.clipPath(this.mPath, Region.Op.XOR);
          paramCanvas.drawCircle(getWidth(), getHeight() / 2, this.mCircleRadiusMax, this.mAnimBottomPaint);
          continue;
          paramCanvas.drawPaint(this.mAnimBottomPaint);
          break;
        case 3:
          this.mPath.reset();
          this.mPath.addCircle(getWidth() / 2, getHeight() / 2, this.mCircleRadius, Path.Direction.CCW);
          paramCanvas.drawPath(this.mPath, this.mCirclePaint);
          paramCanvas.clipPath(this.mPath, Region.Op.XOR);
          paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mCircleRadiusMax, this.mAnimBottomPaint);
          continue;
          switch (this.type)
          {
          default:
            break;
          case 0:
            if (this.mAnimMode == 0)
              paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mCircleRadius, this.mAnimBottomPaint);
            break;
          case 1:
            paramCanvas.drawCircle(0.0F, getHeight() / 2, this.mCircleRadius, this.mAnimBottomPaint);
            break;
          case 2:
            paramCanvas.drawCircle(getWidth(), getHeight() / 2, this.mCircleRadius, this.mAnimBottomPaint);
            continue;
            paramCanvas.drawPaint(this.mAnimBottomPaint);
            break;
          case 3:
            paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mCircleRadius, this.mAnimBottomPaint);
          }
          break;
        }
        break;
      }
    }
  }

  public int[] getMeasureSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n;
    int i1;
    if (i == 1073741824)
    {
      n = j;
      if (k != 1073741824)
        break label90;
      i1 = m;
    }
    while (true)
    {
      return new int[] { n, i1 };
      if (i == -2147483648)
      {
        n = Math.min(this.mBackgroundWidth, j);
        break;
      }
      n = this.mBackgroundWidth;
      break;
      label90: if (k == -2147483648)
        i1 = Math.min(this.mBackgroundHeight, m);
      else
        i1 = this.mBackgroundHeight;
    }
  }

  public boolean needBackgroundMeasure()
  {
    return (this.mBackgroundWidth > 0) && (this.mBackgroundHeight > 0);
  }

  public void onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
    case 0:
    case 3:
    case 4:
    case 1:
    }
    while (true)
    {
      this.mDependView.invalidate();
      return;
      if (this.status != 0)
        resetStatus();
      this.actionDownX = paramMotionEvent.getX();
      this.actionDownY = paramMotionEvent.getY();
      switch (this.mAnimMode)
      {
      default:
      case 0:
      case 1:
      case 2:
      }
      while (true)
      {
        this.status = 2;
        break;
        this.actionDownX = (getWidth() / 2);
        this.actionDownY = (getHeight() / 2);
        continue;
        this.actionDownY = (getHeight() / 2);
        continue;
        this.actionDownX = (getWidth() / 2);
      }
      if (this.status == 2)
        this.status = 1;
      if (this.status == 3)
        reset();
      else if (this.status == 2)
        this.status = 1;
    }
  }

  public void onVisibilityChanged(View paramView, int paramInt)
  {
    if (paramInt != 0)
      resetStatus();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean)
      resetStatus();
  }

  public void performClick()
  {
    if (this.status != 4)
      this.status = 1;
    if (!this.mNeedDelayClick)
      if (this.mCallBack != null)
        this.mCallBack.perfirmSuperClick();
    do
    {
      return;
      if (this.status != 3)
        break;
    }
    while (this.mCallBack == null);
    this.mCallBack.perfirmSuperClick();
    return;
    this.hasClick = true;
  }

  public void resetStatus()
  {
    this.status = 0;
    this.hasClick = false;
    this.mCircleRadius = (getHeight() / 4);
    this.mAnimColorAlpha = 0;
  }

  public void setBackground(Drawable paramDrawable)
  {
    this.mBackgroundDrawable = paramDrawable;
    this.mBackgroundColor = 0;
    if (this.mBackgroundDrawable != null)
    {
      this.mBackgroundWidth = this.mBackgroundDrawable.getIntrinsicWidth();
      this.mBackgroundHeight = this.mBackgroundDrawable.getIntrinsicHeight();
    }
    this.mDependView.requestLayout();
    this.mDependView.invalidate();
  }

  public void setBackgroundColor(int paramInt)
  {
    this.mBackgroundDrawable = null;
    this.mBackgroundColor = paramInt;
  }

  public void setColor(int paramInt)
  {
    this.mAnimFullColor = paramInt;
    initColorInfo();
  }

  public void setDelayClick(boolean paramBoolean)
  {
    this.mNeedDelayClick = paramBoolean;
  }

  public void setType(int paramInt)
  {
    this.type = paramInt;
    init();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.views.MaterialStyle
 * JD-Core Version:    0.6.2
 */