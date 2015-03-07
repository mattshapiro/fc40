package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout.LayoutParams;

public class TabsLinearLayout extends IcsLinearLayout
{
  private static final int LinearLayout_measureWithLargestChild;
  private static final int[] R_styleable_LinearLayout = { 16843476 };
  private boolean mUseLargestChild;

  public TabsLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R_styleable_LinearLayout);
    this.mUseLargestChild = localTypedArray.getBoolean(0, false);
    localTypedArray.recycle();
  }

  private void useLargestChildHorizontal()
  {
    int i = getChildCount();
    int j = 0;
    int k = 0;
    int m;
    if (k >= i)
      m = 0;
    View localView;
    for (int n = 0; ; n++)
    {
      if (n >= i)
      {
        setMeasuredDimension(m + (getPaddingLeft() + getPaddingRight()), getMeasuredHeight());
        return;
        j = Math.max(getChildAt(k).getMeasuredWidth(), j);
        k++;
        break;
      }
      localView = getChildAt(n);
      if ((localView != null) && (localView.getVisibility() != 8))
        break label95;
    }
    label95: LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
    if (localLayoutParams.weight > 0.0F)
      localView.measure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824));
    for (int i1 = m + j; ; i1 = m + localView.getMeasuredWidth())
    {
      m = i1 + (localLayoutParams.leftMargin + localLayoutParams.rightMargin);
      break;
    }
  }

  public boolean isMeasureWithLargestChildEnabled()
  {
    return this.mUseLargestChild;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() <= 2);
    int i;
    do
    {
      return;
      i = View.MeasureSpec.getMode(paramInt1);
    }
    while ((!this.mUseLargestChild) || (i != 0) || (getOrientation() != 0));
    useLargestChildHorizontal();
  }

  public void setMeasureWithLargestChildEnabled(boolean paramBoolean)
  {
    this.mUseLargestChild = paramBoolean;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.TabsLinearLayout
 * JD-Core Version:    0.6.2
 */