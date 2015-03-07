package com.allinone.free.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ToggleButton;

public class LSwitch extends ToggleButton
{
  public static int screenHeight;
  private final int ANIM_TIME = 100;
  private final int STATUS_ANIM_TO_OFF = 1;
  private final int STATUS_ANIM_TO_ON = 2;
  private final int STATUS_MOVE_BY_TOUCH = 3;
  private final int STATUS_NORMAL = 0;
  private boolean canMove = false;
  private PaintFlagsDrawFilter drawFilter = new PaintFlagsDrawFilter(0, 3);
  long lastTime;
  private final int mAnimCheckedColor = 1711516148;
  private final int mAnimNotCheckedColor = 1720091524;
  private final int mCheckedColor = -16537100;
  private float mLastX;
  private final int mNotCheckedColor = -7961724;
  private Paint mPaintAnim = new Paint();
  private Paint mPaintChecked = new Paint();
  private Paint mPaintLine = new Paint();
  private Paint mPaintNotChecked = new Paint();
  private Paint mPaintTemp = new Paint();
  private float mPostionX;
  private RectF mRectFOff;
  private RectF mRectFOn;
  private float mScaleMax = 0.5F;
  private float mScaleMin = 0.1F;
  private float mStrokeWidthScale = 0.0F;
  private int mWarpHeight;
  private int mWarpWidth;
  private boolean needSuperClick = true;
  private float offsetSpeed = 5.0F;
  private float scaleSpeed = 0.01F;
  private int status = 0;

  public LSwitch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundColor(0);
    if (screenHeight <= 0)
      screenHeight = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getHeight();
    this.mWarpHeight = ((int)(60 * screenHeight / 1280.0F));
    this.mWarpWidth = (2 * this.mWarpHeight);
  }

  private void init()
  {
    if ((getHeight() == 0) || (getWidth() == 0))
      return;
    int i = getHeight();
    int j = getWidth();
    getWidth();
    getWidth();
    int k = 0;
    float f1 = 0.1F * this.mWarpHeight;
    float f2;
    int n;
    float f3;
    if (j >= i * 2)
    {
      int i1 = i * 2;
      f2 = i - 2.0F * f1;
      n = (j - i1) / 2;
      f3 = i1 - f2 - f1 * 2.0F;
      this.offsetSpeed = ((i1 - f3 - this.mPostionX) / 6.666667F);
    }
    while (true)
    {
      this.mRectFOff = new RectF();
      this.mRectFOff.left = (f1 + n);
      this.mRectFOff.top = (f1 + k);
      this.mRectFOff.right = (f2 + this.mRectFOff.left);
      this.mRectFOff.bottom = (f2 + this.mRectFOff.top);
      this.mPostionX = this.mRectFOff.left;
      this.mRectFOn = new RectF();
      this.mRectFOn.left = (f3 + this.mRectFOff.left);
      this.mRectFOn.top = this.mRectFOff.top;
      this.mRectFOn.right = (f3 + this.mRectFOff.right);
      this.mRectFOn.bottom = this.mRectFOff.bottom;
      this.mPaintChecked.setColor(-16537100);
      this.mPaintChecked.setStyle(Paint.Style.FILL);
      this.mPaintNotChecked.setColor(-7961724);
      this.mPaintNotChecked.setStyle(Paint.Style.STROKE);
      this.mPaintNotChecked.setStrokeWidth(0.1F * this.mRectFOff.width());
      this.mPaintTemp.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      this.mPaintAnim.setStyle(Paint.Style.STROKE);
      this.mPaintLine.setStyle(Paint.Style.STROKE);
      this.mPaintLine.setStrokeWidth(0.1F * this.mRectFOff.width());
      this.scaleSpeed = ((this.mScaleMax - this.mScaleMin) / 6.666667F);
      return;
      int m = j / 2;
      f2 = m - 2.0F * f1;
      k = (i - m) / 2;
      f3 = j - f2 - f1 * 2.0F;
      this.offsetSpeed = ((j - f3 - this.mPostionX) / 6.666667F);
      n = 0;
    }
  }

  private void move()
  {
    if ((this.status == 0) || (this.status == 3))
      return;
    switch (this.status)
    {
    default:
      this.mPaintAnim.setStrokeWidth(this.mRectFOff.width() * this.mStrokeWidthScale);
      if (this.mPostionX <= this.mRectFOff.left)
        this.mPostionX = this.mRectFOff.left;
      break;
    case 1:
    case 2:
    }
    while (true)
    {
      invalidate();
      return;
      this.mPostionX -= this.offsetSpeed;
      if (this.mPostionX <= this.mRectFOff.left)
        this.mPostionX = this.mRectFOff.left;
      this.mStrokeWidthScale -= this.scaleSpeed;
      if (this.mStrokeWidthScale <= this.mScaleMin)
        this.mStrokeWidthScale = this.mScaleMin;
      if ((this.mPostionX > this.mRectFOff.left) || (this.mStrokeWidthScale > this.mScaleMin))
        break;
      this.status = 0;
      break;
      this.mPostionX += this.offsetSpeed;
      if (this.mPostionX >= this.mRectFOn.left)
        this.mPostionX = this.mRectFOn.left;
      this.mStrokeWidthScale += this.scaleSpeed;
      if (this.mStrokeWidthScale >= this.mScaleMax)
        this.mStrokeWidthScale = this.mScaleMax;
      if ((this.mPostionX < this.mRectFOn.left) || (this.mStrokeWidthScale < this.mScaleMax))
        break;
      this.status = 0;
      break;
      if (this.mPostionX >= this.mRectFOn.left)
        this.mPostionX = this.mRectFOn.left;
    }
  }

  private void moveByTouch(float paramFloat)
  {
    this.mPostionX = (paramFloat + this.mPostionX);
    if (this.mPostionX <= this.mRectFOff.left)
      this.mPostionX = this.mRectFOff.left;
    while (this.mPostionX < this.mRectFOn.left)
      return;
    this.mPostionX = this.mRectFOn.left;
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled())
      return true;
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.mRectFOff == null)
    {
      init();
      this.lastTime = System.currentTimeMillis();
    }
    this.lastTime = System.currentTimeMillis();
    paramCanvas.setDrawFilter(this.drawFilter);
    Paint localPaint1 = this.mPaintLine;
    int i;
    if (isChecked())
    {
      i = 1711516148;
      localPaint1.setColor(i);
      if (this.status != 0)
        break label241;
      if (!isChecked())
        break label156;
      paramCanvas.drawCircle(this.mRectFOn.centerX(), this.mRectFOn.centerY(), this.mRectFOn.width() / 2.0F, this.mPaintChecked);
      paramCanvas.drawLine(this.mRectFOff.left, this.mRectFOff.centerY(), this.mRectFOn.left, this.mRectFOff.centerY(), this.mPaintLine);
    }
    for (this.mPostionX = this.mRectFOn.left; ; this.mPostionX = this.mRectFOff.left)
    {
      move();
      return;
      i = 1720091524;
      break;
      label156: paramCanvas.drawCircle(this.mRectFOff.centerX(), this.mRectFOff.centerY(), 0.9F * (this.mRectFOff.width() / 2.0F), this.mPaintNotChecked);
      paramCanvas.drawLine(this.mRectFOff.right, this.mRectFOff.centerY(), this.mRectFOn.right, this.mRectFOff.centerY(), this.mPaintLine);
    }
    label241: Paint localPaint2 = this.mPaintAnim;
    if (isChecked());
    for (int j = -16537100; ; j = -7961724)
    {
      localPaint2.setColor(j);
      paramCanvas.drawCircle(this.mPostionX + this.mRectFOff.width() / 2.0F, this.mRectFOff.centerY(), this.mRectFOff.width() / 2.0F * (1.0F - this.mStrokeWidthScale), this.mPaintAnim);
      paramCanvas.drawLine(this.mRectFOff.left, this.mRectFOff.centerY(), this.mPostionX, this.mRectFOff.centerY(), this.mPaintLine);
      paramCanvas.drawLine(this.mPostionX + this.mRectFOff.width(), this.mRectFOff.centerY(), this.mRectFOn.right, this.mRectFOff.centerY(), this.mPaintLine);
      break;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    int n = j;
    int i1 = m;
    switch (i)
    {
    default:
    case 1073741824:
    case -2147483648:
    case 0:
    }
    while (true)
    {
      setMeasuredDimension(n, i1);
      return;
      n = j;
      switch (k)
      {
      default:
        break;
      case -2147483648:
        i1 = Math.max(Math.min(this.mWarpHeight, m), j / 2);
        break;
      case 1073741824:
        i1 = m;
        break;
      case 0:
        i1 = Math.min(this.mWarpHeight, j / 2);
        continue;
        switch (k)
        {
        default:
          break;
        case -2147483648:
          n = Math.min(this.mWarpWidth, j);
          i1 = Math.min(this.mWarpHeight, m);
          break;
        case 1073741824:
          n = Math.max(Math.min(this.mWarpWidth, j), m * 2);
          i1 = m;
          break;
        case 0:
          n = Math.min(this.mWarpWidth, j);
          i1 = this.mWarpHeight;
          if (n > i1 * 2)
          {
            n = i1 * 2;
          }
          else
          {
            i1 = n / 2;
            continue;
            switch (k)
            {
            default:
              break;
            case -2147483648:
              n = this.mWarpWidth;
              i1 = Math.min(this.mWarpHeight, m);
              if (n > i1 * 2)
                n = i1 * 2;
              break;
            case 1073741824:
              n = Math.min(this.mWarpWidth, m * 2);
              i1 = m;
              continue;
              i1 = n / 2;
              break;
            case 0:
              n = this.mWarpWidth;
              i1 = this.mWarpHeight;
              if (n > i1 * 2)
                n = i1 * 2;
              else
                i1 = n / 2;
              break;
            }
          }
          break;
        }
        break;
      }
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mRectFOff == null)
      init();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    case 4:
    }
    do
    {
      do
      {
        do
        {
          return super.onTouchEvent(paramMotionEvent);
          this.canMove = false;
        }
        while (((!isChecked()) || (paramMotionEvent.getX() <= getWidth() / 2)) && ((isChecked()) || (paramMotionEvent.getX() >= getWidth() / 2)));
        if (isChecked());
        for (float f = this.mScaleMax; ; f = this.mScaleMin)
        {
          this.mStrokeWidthScale = f;
          this.mPaintAnim.setStrokeWidth(this.mRectFOff.width() * this.mStrokeWidthScale);
          this.canMove = true;
          this.status = 3;
          this.mLastX = paramMotionEvent.getX();
          invalidate();
          break;
        }
      }
      while (!this.canMove);
      moveByTouch(paramMotionEvent.getX() - this.mLastX);
      this.mLastX = paramMotionEvent.getX();
      invalidate();
      if ((this.needSuperClick) && (((isChecked()) && (this.mPostionX <= (getWidth() - this.mRectFOff.width()) / 2.0F)) || ((!isChecked()) && (this.mPostionX >= (getWidth() - this.mRectFOff.width()) / 2.0F))))
        this.needSuperClick = false;
      return true;
      if (this.canMove)
        moveByTouch(paramMotionEvent.getX() - this.mLastX);
    }
    while (!this.canMove);
    if (isChecked())
      if (this.mPostionX <= (getWidth() - this.mRectFOff.width()) / 2.0F)
      {
        setChecked(false);
        this.status = 1;
      }
    while (true)
    {
      invalidate();
      if (this.needSuperClick)
        break;
      this.needSuperClick = true;
      return true;
      this.status = 2;
      continue;
      if (this.mPostionX >= (getWidth() - this.mRectFOff.width()) / 2.0F)
      {
        setChecked(true);
        this.status = 2;
      }
      else
      {
        this.status = 1;
      }
    }
  }

  public boolean performClick()
  {
    if (isChecked());
    for (int i = 1; ; i = 2)
    {
      this.status = i;
      return super.performClick();
    }
  }

  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 2; ; i = 1)
    {
      this.status = i;
      super.setChecked(paramBoolean);
      invalidate();
      return;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.views.LSwitch
 * JD-Core Version:    0.6.2
 */