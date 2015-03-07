package com.allinone.free.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.allinone.free.R.styleable;

public class LDrawerButton extends LButton
{
  private final String TAG = "LDrawerButton";
  private int mBaseDegrees;
  private int mCenterX;
  private int mCenterY;
  private int mCurrentDegrees = 0;
  private boolean mIsLeftGravity;
  private float mLeftOffsetY;
  private int mLine1TopBase;
  private int mLine2TopBase;
  private int mLine3TopBase;
  private int mLineHalfWidth;
  private int mLineLeftBase;
  private float mLineLeftOffset;
  private Paint mLinePaint = new Paint();
  private int mLineRightBase;
  private int mLineSplit;
  private float mRightOffsetY;
  private int mSplitHalfHeight;
  private int mStrokeWidth;

  public LDrawerButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mIsLeftGravity = i;
    this.mBaseDegrees = 0;
    this.mLinePaint.setColor(-1);
    TypedArray localTypedArray;
    int j;
    if (paramAttributeSet != null)
    {
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LButtonStyle);
      if (localTypedArray.getInt(3, i) == 2)
        break label115;
      this.mIsLeftGravity = i;
      setDelayClick(localTypedArray.getBoolean(2, false));
      boolean bool = this.mIsLeftGravity;
      j = 0;
      if (!bool)
        break label120;
    }
    while (true)
    {
      this.mBaseDegrees = j;
      localTypedArray.recycle();
      return;
      label115: i = 0;
      break;
      label120: j = 180;
    }
  }

  private void initDrawer()
  {
    if ((getWidth() == 0) || (getHeight() == 0))
      return;
    this.mCenterX = (getWidth() / 2);
    this.mCenterY = (getHeight() / 2);
    this.mStrokeWidth = (getHeight() / 35);
    this.mLinePaint.setStrokeWidth(this.mStrokeWidth);
    this.mLineSplit = (3 * this.mStrokeWidth);
    this.mLineHalfWidth = ((int)(getHeight() / 4.5F));
    this.mLineLeftBase = (this.mCenterX - this.mLineHalfWidth);
    this.mLineRightBase = (this.mCenterX + this.mLineHalfWidth);
    this.mLine1TopBase = (this.mCenterY - this.mLineSplit - this.mStrokeWidth);
    this.mLine2TopBase = this.mCenterY;
    this.mLine3TopBase = (this.mCenterY + this.mLineSplit + this.mStrokeWidth);
    this.mSplitHalfHeight = (this.mLine3TopBase - this.mLine2TopBase);
  }

  public void onDrag(boolean paramBoolean, float paramFloat)
  {
    float f;
    label52: int i;
    if (paramFloat < 0.0F)
    {
      paramFloat = 0.0F;
      this.mLineLeftOffset = (paramFloat * this.mLineHalfWidth);
      this.mLeftOffsetY = (paramFloat * (this.mSplitHalfHeight / 1.5F));
      this.mRightOffsetY = (paramFloat * this.mSplitHalfHeight);
      if (!paramBoolean)
        break label98;
      f = 1.0F - paramFloat;
      i = (int)(180.0F * f);
      if (!paramBoolean)
        break label103;
    }
    label98: label103: for (int j = 180; ; j = 0)
    {
      this.mCurrentDegrees = (j + i + this.mBaseDegrees);
      invalidate();
      return;
      if (paramFloat <= 1.0F)
        break;
      paramFloat = 1.0F;
      break;
      f = paramFloat;
      break label52;
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.mCenterX == 0) || (this.mCenterY == 0))
      initDrawer();
    paramCanvas.rotate(this.mCurrentDegrees, this.mCenterX, this.mCenterY);
    paramCanvas.drawLine(this.mLineLeftBase + this.mLineLeftOffset, this.mLine1TopBase - this.mLeftOffsetY, this.mLineRightBase, this.mLine1TopBase + this.mRightOffsetY, this.mLinePaint);
    paramCanvas.drawLine(this.mLineLeftBase + this.mLineLeftOffset / 3.0F, this.mLine2TopBase, this.mLineRightBase, this.mLine2TopBase, this.mLinePaint);
    paramCanvas.drawLine(this.mLineLeftBase + this.mLineLeftOffset, this.mLine3TopBase + this.mLeftOffsetY, this.mLineRightBase, this.mLine3TopBase - this.mRightOffsetY, this.mLinePaint);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.views.LDrawerButton
 * JD-Core Version:    0.6.2
 */