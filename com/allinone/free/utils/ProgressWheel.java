package com.allinone.free.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import com.allinone.free.R.styleable;

public class ProgressWheel extends View
{
  private static final String TAG = ProgressWheel.class.getSimpleName();
  private int barColor = -1438714899;
  private float barExtraLength = 0.0F;
  private boolean barGrowingFromFront = true;
  private final int barLength = 16;
  private final int barMaxLength = 270;
  private Paint barPaint = new Paint();
  private double barSpinCycleTime = 460.0D;
  private int barWidth = 4;
  private RectF circleBounds = new RectF();
  private int circleRadius = 28;
  private boolean fillRadius = false;
  private boolean isSpinning = false;
  private long lastTimeAnimated = 0L;
  private boolean linearProgress;
  private float mProgress = 0.0F;
  private float mTargetProgress = 0.0F;
  private final long pauseGrowingTime = 200L;
  private long pausedTimeWithoutGrowing = 0L;
  private int rimColor = -6381922;
  private Paint rimPaint = new Paint();
  private int rimWidth = 4;
  private float spinSpeed = 230.0F;
  private double timeStartGrowing = 0.0D;

  public ProgressWheel(Context paramContext)
  {
    super(paramContext);
  }

  public ProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    parseAttributes(paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ProgressWheel));
  }

  private void parseAttributes(TypedArray paramTypedArray)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    this.barWidth = ((int)TypedValue.applyDimension(1, this.barWidth, localDisplayMetrics));
    this.rimWidth = ((int)TypedValue.applyDimension(1, this.rimWidth, localDisplayMetrics));
    this.circleRadius = ((int)TypedValue.applyDimension(1, this.circleRadius, localDisplayMetrics));
    this.circleRadius = ((int)paramTypedArray.getDimension(6, this.circleRadius));
    this.fillRadius = paramTypedArray.getBoolean(7, false);
    this.barWidth = ((int)paramTypedArray.getDimension(8, this.barWidth));
    this.rimWidth = ((int)paramTypedArray.getDimension(3, this.rimWidth));
    this.spinSpeed = (360.0F * paramTypedArray.getFloat(4, this.spinSpeed / 360.0F));
    this.barSpinCycleTime = paramTypedArray.getInt(5, (int)this.barSpinCycleTime);
    this.barColor = paramTypedArray.getColor(1, this.barColor);
    this.rimColor = paramTypedArray.getColor(2, this.rimColor);
    this.linearProgress = paramTypedArray.getBoolean(9, false);
    if (paramTypedArray.getBoolean(0, false))
      spin();
    paramTypedArray.recycle();
  }

  private void setupBounds(int paramInt1, int paramInt2)
  {
    int i = getPaddingTop();
    int j = getPaddingBottom();
    int k = getPaddingLeft();
    int m = getPaddingRight();
    if (!this.fillRadius)
    {
      int n = Math.min(Math.min(paramInt1 - k - m, paramInt2 - j - i), 2 * this.circleRadius - 2 * this.barWidth);
      int i1 = k + (paramInt1 - k - m - n) / 2;
      int i2 = i + (paramInt2 - i - j - n) / 2;
      this.circleBounds = new RectF(i1 + this.barWidth, i2 + this.barWidth, i1 + n - this.barWidth, i2 + n - this.barWidth);
      return;
    }
    this.circleBounds = new RectF(k + this.barWidth, i + this.barWidth, paramInt1 - m - this.barWidth, paramInt2 - j - this.barWidth);
  }

  private void setupPaints()
  {
    this.barPaint.setColor(this.barColor);
    this.barPaint.setAntiAlias(true);
    this.barPaint.setStyle(Paint.Style.STROKE);
    this.barPaint.setStrokeWidth(this.barWidth);
    this.rimPaint.setColor(this.rimColor);
    this.rimPaint.setAntiAlias(true);
    this.rimPaint.setStyle(Paint.Style.STROKE);
    this.rimPaint.setStrokeWidth(this.rimWidth);
  }

  private void updateBarLength(long paramLong)
  {
    if (this.pausedTimeWithoutGrowing >= 200L)
    {
      this.timeStartGrowing += paramLong;
      if (this.timeStartGrowing > this.barSpinCycleTime)
      {
        this.timeStartGrowing -= this.barSpinCycleTime;
        this.pausedTimeWithoutGrowing = 0L;
        if (!this.barGrowingFromFront)
          break label109;
      }
      float f1;
      label109: for (boolean bool = false; ; bool = true)
      {
        this.barGrowingFromFront = bool;
        f1 = 0.5F + (float)Math.cos(3.141592653589793D * (1.0D + this.timeStartGrowing / this.barSpinCycleTime)) / 2.0F;
        if (!this.barGrowingFromFront)
          break;
        this.barExtraLength = (f1 * 254.0F);
        return;
      }
      float f2 = 254.0F * (1.0F - f1);
      this.mProgress += this.barExtraLength - f2;
      this.barExtraLength = f2;
      return;
    }
    this.pausedTimeWithoutGrowing = (paramLong + this.pausedTimeWithoutGrowing);
  }

  public int getBarColor()
  {
    return this.barColor;
  }

  public int getBarWidth()
  {
    return this.barWidth;
  }

  public int getCircleRadius()
  {
    return this.circleRadius;
  }

  public float getProgress()
  {
    if (this.isSpinning)
      return -1.0F;
    return this.mProgress / 360.0F;
  }

  public int getRimColor()
  {
    return this.rimColor;
  }

  public int getRimWidth()
  {
    return this.rimWidth;
  }

  public float getSpinSpeed()
  {
    return this.spinSpeed / 360.0F;
  }

  public boolean isSpinning()
  {
    return this.isSpinning;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.circleBounds, 360.0F, 360.0F, false, this.rimPaint);
    int i;
    if (this.isSpinning)
    {
      i = 1;
      long l = SystemClock.uptimeMillis() - this.lastTimeAnimated;
      float f3 = (float)l * this.spinSpeed / 1000.0F;
      updateBarLength(l);
      this.mProgress = (f3 + this.mProgress);
      if (this.mProgress > 360.0F)
        this.mProgress -= 360.0F;
      this.lastTimeAnimated = SystemClock.uptimeMillis();
      float f4 = this.mProgress - 90.0F;
      float f5 = 16.0F + this.barExtraLength;
      paramCanvas.drawArc(this.circleBounds, f4, f5, false, this.barPaint);
    }
    while (true)
    {
      if (i != 0)
        invalidate();
      return;
      boolean bool1 = this.mProgress < this.mTargetProgress;
      i = 0;
      if (bool1)
      {
        i = 1;
        this.mProgress = Math.min((float)(SystemClock.uptimeMillis() - this.lastTimeAnimated) / 1000.0F * this.spinSpeed + this.mProgress, this.mTargetProgress);
        this.lastTimeAnimated = SystemClock.uptimeMillis();
      }
      float f1 = this.mProgress;
      boolean bool2 = this.linearProgress;
      float f2 = 0.0F;
      if (!bool2)
      {
        f2 = 360.0F * (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 2.0F * 2.0F));
        f1 = 360.0F * (float)(1.0D - Math.pow(1.0F - this.mProgress / 360.0F, 2.0F));
      }
      paramCanvas.drawArc(this.circleBounds, f2 - 90.0F, f1, false, this.barPaint);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = this.circleRadius + getPaddingLeft() + getPaddingRight();
    int j = this.circleRadius + getPaddingTop() + getPaddingBottom();
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int i2;
    int i3;
    if (k == 1073741824)
    {
      i2 = m;
      if ((n != 1073741824) && (k != 1073741824))
        break label127;
      i3 = i1;
    }
    while (true)
    {
      setMeasuredDimension(i2, i3);
      return;
      if (k == -2147483648)
      {
        i2 = Math.min(i, m);
        break;
      }
      i2 = i;
      break;
      label127: if (n == -2147483648)
        i3 = Math.min(j, i1);
      else
        i3 = j;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof WheelSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    WheelSavedState localWheelSavedState = (WheelSavedState)paramParcelable;
    super.onRestoreInstanceState(localWheelSavedState.getSuperState());
    this.mProgress = localWheelSavedState.mProgress;
    this.mTargetProgress = localWheelSavedState.mTargetProgress;
    this.isSpinning = localWheelSavedState.isSpinning;
    this.spinSpeed = localWheelSavedState.spinSpeed;
    this.barWidth = localWheelSavedState.barWidth;
    this.barColor = localWheelSavedState.barColor;
    this.rimWidth = localWheelSavedState.rimWidth;
    this.rimColor = localWheelSavedState.rimColor;
    this.circleRadius = localWheelSavedState.circleRadius;
    this.linearProgress = localWheelSavedState.linearProgress;
    this.fillRadius = localWheelSavedState.fillRadius;
  }

  public Parcelable onSaveInstanceState()
  {
    WheelSavedState localWheelSavedState = new WheelSavedState(super.onSaveInstanceState());
    localWheelSavedState.mProgress = this.mProgress;
    localWheelSavedState.mTargetProgress = this.mTargetProgress;
    localWheelSavedState.isSpinning = this.isSpinning;
    localWheelSavedState.spinSpeed = this.spinSpeed;
    localWheelSavedState.barWidth = this.barWidth;
    localWheelSavedState.barColor = this.barColor;
    localWheelSavedState.rimWidth = this.rimWidth;
    localWheelSavedState.rimColor = this.rimColor;
    localWheelSavedState.circleRadius = this.circleRadius;
    localWheelSavedState.linearProgress = this.linearProgress;
    localWheelSavedState.fillRadius = this.fillRadius;
    return localWheelSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setupBounds(paramInt1, paramInt2);
    setupPaints();
    invalidate();
  }

  public void resetCount()
  {
    this.mProgress = 0.0F;
    this.mTargetProgress = 0.0F;
    invalidate();
  }

  public void setBarColor(int paramInt)
  {
    this.barColor = paramInt;
    setupPaints();
    if (!this.isSpinning)
      invalidate();
  }

  public void setBarWidth(int paramInt)
  {
    this.barWidth = paramInt;
    if (!this.isSpinning)
      invalidate();
  }

  public void setCircleRadius(int paramInt)
  {
    this.circleRadius = paramInt;
    if (!this.isSpinning)
      invalidate();
  }

  public void setInstantProgress(float paramFloat)
  {
    if (this.isSpinning)
    {
      this.mProgress = 0.0F;
      this.isSpinning = false;
    }
    if (paramFloat > 1.0F)
      paramFloat -= 1.0F;
    while (paramFloat == this.mTargetProgress)
    {
      return;
      if (paramFloat < 0.0F)
        paramFloat = 0.0F;
    }
    this.mTargetProgress = Math.min(paramFloat * 360.0F, 360.0F);
    this.mProgress = this.mTargetProgress;
    this.lastTimeAnimated = SystemClock.uptimeMillis();
    invalidate();
  }

  public void setLinearProgress(boolean paramBoolean)
  {
    this.linearProgress = paramBoolean;
    if (!this.isSpinning)
      invalidate();
  }

  public void setProgress(float paramFloat)
  {
    if (this.isSpinning)
    {
      this.mProgress = 0.0F;
      this.isSpinning = false;
    }
    if (paramFloat > 1.0F)
      paramFloat -= 1.0F;
    while (paramFloat == this.mTargetProgress)
    {
      return;
      if (paramFloat < 0.0F)
        paramFloat = 0.0F;
    }
    if (this.mProgress == this.mTargetProgress)
      this.lastTimeAnimated = SystemClock.uptimeMillis();
    this.mTargetProgress = Math.min(paramFloat * 360.0F, 360.0F);
    invalidate();
  }

  public void setRimColor(int paramInt)
  {
    this.rimColor = paramInt;
    setupPaints();
    if (!this.isSpinning)
      invalidate();
  }

  public void setRimWidth(int paramInt)
  {
    this.rimWidth = paramInt;
    if (!this.isSpinning)
      invalidate();
  }

  public void setSpinSpeed(float paramFloat)
  {
    this.spinSpeed = (360.0F * paramFloat);
  }

  public void spin()
  {
    this.lastTimeAnimated = SystemClock.uptimeMillis();
    this.isSpinning = true;
    invalidate();
  }

  public void stopSpinning()
  {
    this.isSpinning = false;
    this.mProgress = 0.0F;
    this.mTargetProgress = 0.0F;
    invalidate();
  }

  static class WheelSavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator()
    {
      public ProgressWheel.WheelSavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ProgressWheel.WheelSavedState(paramAnonymousParcel, null);
      }

      public ProgressWheel.WheelSavedState[] newArray(int paramAnonymousInt)
      {
        return new ProgressWheel.WheelSavedState[paramAnonymousInt];
      }
    };
    int barColor;
    int barWidth;
    int circleRadius;
    boolean fillRadius;
    boolean isSpinning;
    boolean linearProgress;
    float mProgress;
    float mTargetProgress;
    int rimColor;
    int rimWidth;
    float spinSpeed;

    private WheelSavedState(Parcel paramParcel)
    {
      super();
      this.mProgress = paramParcel.readFloat();
      this.mTargetProgress = paramParcel.readFloat();
      boolean bool2;
      boolean bool3;
      if (paramParcel.readByte() != 0)
      {
        bool2 = bool1;
        this.isSpinning = bool2;
        this.spinSpeed = paramParcel.readFloat();
        this.barWidth = paramParcel.readInt();
        this.barColor = paramParcel.readInt();
        this.rimWidth = paramParcel.readInt();
        this.rimColor = paramParcel.readInt();
        this.circleRadius = paramParcel.readInt();
        if (paramParcel.readByte() == 0)
          break label119;
        bool3 = bool1;
        label95: this.linearProgress = bool3;
        if (paramParcel.readByte() == 0)
          break label125;
      }
      while (true)
      {
        this.fillRadius = bool1;
        return;
        bool2 = false;
        break;
        label119: bool3 = false;
        break label95;
        label125: bool1 = false;
      }
    }

    WheelSavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeFloat(this.mProgress);
      paramParcel.writeFloat(this.mTargetProgress);
      int j;
      int k;
      if (this.isSpinning)
      {
        j = i;
        paramParcel.writeByte((byte)j);
        paramParcel.writeFloat(this.spinSpeed);
        paramParcel.writeInt(this.barWidth);
        paramParcel.writeInt(this.barColor);
        paramParcel.writeInt(this.rimWidth);
        paramParcel.writeInt(this.rimColor);
        paramParcel.writeInt(this.circleRadius);
        if (!this.linearProgress)
          break label126;
        k = i;
        label99: paramParcel.writeByte((byte)k);
        if (!this.fillRadius)
          break label132;
      }
      while (true)
      {
        paramParcel.writeByte((byte)i);
        return;
        j = 0;
        break;
        label126: k = 0;
        break label99;
        label132: i = 0;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.ProgressWheel
 * JD-Core Version:    0.6.2
 */