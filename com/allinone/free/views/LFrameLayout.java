package com.allinone.free.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class LFrameLayout extends FrameLayout
  implements IMaterial
{
  private MaterialStyle mMaterialStyle;

  public LFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  @SuppressLint({"NewApi"})
  public LFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mMaterialStyle = new MaterialStyle(this, paramAttributeSet);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled())
      return false;
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (!isEnabled())
    {
      super.onDraw(paramCanvas);
      return;
    }
    this.mMaterialStyle.doDraw(paramCanvas);
    super.onDraw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mMaterialStyle != null)
    {
      if (this.mMaterialStyle.needBackgroundMeasure())
      {
        int[] arrayOfInt = this.mMaterialStyle.getMeasureSize(paramInt1, paramInt2);
        setMeasuredDimension(arrayOfInt[0], arrayOfInt[1]);
        return;
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mMaterialStyle != null)
      this.mMaterialStyle.onTouchEvent(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }

  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.mMaterialStyle != null)
      this.mMaterialStyle.onVisibilityChanged(paramView, paramInt);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.mMaterialStyle != null)
      this.mMaterialStyle.onWindowFocusChanged(paramBoolean);
  }

  public void perfirmSuperClick()
  {
    super.performClick();
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean performClick()
  {
    if (this.mMaterialStyle != null)
    {
      this.mMaterialStyle.performClick();
      return true;
    }
    return super.performClick();
  }

  public void setBackground(Drawable paramDrawable)
  {
    if (this.mMaterialStyle != null)
      this.mMaterialStyle.setBackground(paramDrawable);
  }

  public void setBackgroundColor(int paramInt)
  {
    if (this.mMaterialStyle != null)
      this.mMaterialStyle.setBackgroundColor(paramInt);
  }

  @Deprecated
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    setBackground(paramDrawable);
  }

  public void setBackgroundResource(int paramInt)
  {
    setBackground(getResources().getDrawable(paramInt));
  }

  public void setColor(int paramInt)
  {
    this.mMaterialStyle.setColor(paramInt);
  }

  public void setDelayClick(boolean paramBoolean)
  {
    this.mMaterialStyle.setDelayClick(paramBoolean);
  }

  public void setType(int paramInt)
  {
    this.mMaterialStyle.setType(paramInt);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.views.LFrameLayout
 * JD-Core Version:    0.6.2
 */