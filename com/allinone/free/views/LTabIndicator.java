package com.allinone.free.views;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class LTabIndicator extends HorizontalScrollView
{
  private int currentPosition = 0;
  private float currentPositionOffset = 0.0F;
  private Paint diviPaint;
  private int dividerColor = 436207616;
  private int dividerPadding = 12;
  private int dividerWidth = 1;
  private boolean enableDivider = false;
  private boolean enableExpand = true;
  private int indicatorColor = -553648129;
  private float indicatorHeight = 3.0F;
  private boolean indicatorOnTop = false;
  private int lastScrollX = 0;
  private int mAnimColor = -1962934273;
  private Paint mBaseLinePaint = new Paint();
  private Paint mCurrentPaint = new Paint();
  public ViewPager.OnPageChangeListener mOnPageChangeListener;
  private ViewPager mPager;
  private OnTabSelectedListener mTabSelectedListener;
  private LinearLayout mTabsContainer;
  private int scrollOffset = 52;
  private int tabCount;
  private int tabPadding = 24;
  private int tabTextSize = 16;
  private int textSelectedColor = -553648129;
  private int textUnselectColor = -1962934273;
  private int underlineColor = -1962934273;
  private float underlineHeight = 1.0F;
  private boolean viewPagerScrollWithAnimation = true;

  public LTabIndicator(Context paramContext)
  {
    this(paramContext, null);
  }

  public LTabIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public LTabIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.mTabsContainer = new LinearLayout(paramContext);
    this.mTabsContainer.setOrientation(0);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.height = ((int)TypedValue.applyDimension(1, 50.0F, localDisplayMetrics));
    this.mTabsContainer.setLayoutParams(localLayoutParams);
    addView(this.mTabsContainer);
    this.scrollOffset = ((int)TypedValue.applyDimension(1, this.scrollOffset, localDisplayMetrics));
    this.dividerPadding = ((int)TypedValue.applyDimension(1, this.dividerPadding, localDisplayMetrics));
    this.tabPadding = ((int)TypedValue.applyDimension(1, this.tabPadding, localDisplayMetrics));
    this.dividerWidth = ((int)TypedValue.applyDimension(1, this.dividerWidth, localDisplayMetrics));
    this.indicatorHeight = TypedValue.applyDimension(1, this.indicatorHeight, localDisplayMetrics);
    this.underlineHeight = TypedValue.applyDimension(1, this.underlineHeight, localDisplayMetrics);
    this.mCurrentPaint.setAntiAlias(true);
    this.mCurrentPaint.setStyle(Paint.Style.FILL);
    this.mCurrentPaint.setColor(this.indicatorColor);
    this.mBaseLinePaint.setAntiAlias(true);
    this.mBaseLinePaint.setStyle(Paint.Style.FILL);
    this.mBaseLinePaint.setColor(this.underlineColor);
    this.diviPaint = new Paint();
    this.diviPaint.setAntiAlias(true);
    this.diviPaint.setStrokeWidth(this.dividerWidth);
  }

  private void addTab(final int paramInt, String paramString)
  {
    TabView localTabView = new TabView(getContext());
    localTabView.getTextView().setText(paramString);
    localTabView.setFocusable(true);
    localTabView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((LTabIndicator.this.mPager.getCurrentItem() != paramInt) && (LTabIndicator.this.mTabSelectedListener != null))
          LTabIndicator.this.mTabSelectedListener.onTabSelected(paramInt);
        LTabIndicator.this.mPager.setCurrentItem(paramInt, LTabIndicator.this.viewPagerScrollWithAnimation);
      }
    });
    if (!this.enableExpand)
      localTabView.setPadding(this.tabPadding, 0, this.tabPadding, 0);
    LinearLayout localLinearLayout = this.mTabsContainer;
    if (this.enableExpand);
    for (LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1, 1.0F); ; localLayoutParams = new LinearLayout.LayoutParams(-2, -1))
    {
      localLinearLayout.addView(localTabView, paramInt, localLayoutParams);
      return;
    }
  }

  private void scrollToChild(int paramInt1, int paramInt2)
  {
    if (this.tabCount == 0);
    int i;
    do
    {
      return;
      i = paramInt2 + this.mTabsContainer.getChildAt(paramInt1).getLeft();
      if ((paramInt1 > 0) || (paramInt2 > 0))
        i -= this.scrollOffset;
    }
    while (i == this.lastScrollX);
    this.lastScrollX = i;
    scrollTo(i, 0);
  }

  private void tabSelect(int paramInt)
  {
    int i = this.mTabsContainer.getChildCount();
    int j = 0;
    if (j >= i)
      return;
    View localView = this.mTabsContainer.getChildAt(j);
    boolean bool;
    if (j == paramInt)
    {
      bool = true;
      label34: localView.setSelected(bool);
      if (!bool)
        break label73;
      ((TabView)localView).getTextView().setTextColor(this.textSelectedColor);
    }
    while (true)
    {
      j++;
      break;
      bool = false;
      break label34;
      label73: ((TabView)localView).getTextView().setTextColor(this.textUnselectColor);
    }
  }

  private void updateTabStyles()
  {
    for (int i = 0; ; i++)
    {
      if (i >= this.tabCount)
      {
        tabSelect(this.mPager.getCurrentItem());
        return;
      }
      this.mTabsContainer.getChildAt(i).setBackgroundColor(0);
    }
  }

  public boolean getViewPagerScrollWithAnimation()
  {
    return this.viewPagerScrollWithAnimation;
  }

  public boolean isEnableDivider()
  {
    return this.enableDivider;
  }

  public boolean isEnableExpand()
  {
    return this.enableExpand;
  }

  public boolean isIndicatorOnTop()
  {
    return this.indicatorOnTop;
  }

  public void notifyDataSetChanged()
  {
    this.mTabsContainer.removeAllViews();
    this.tabCount = this.mPager.getAdapter().getCount();
    for (int i = 0; ; i++)
    {
      if (i >= this.tabCount)
      {
        updateTabStyles();
        return;
      }
      addTab(i, this.mPager.getAdapter().getPageTitle(i).toString());
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.tabCount == 0));
    label54: label327: 
    while (true)
    {
      return;
      int i = getHeight();
      float f1;
      float f2;
      if (this.indicatorOnTop)
      {
        paramCanvas.drawRect(0.0F, 0.0F, this.mTabsContainer.getWidth(), this.underlineHeight, this.mBaseLinePaint);
        View localView1 = this.mTabsContainer.getChildAt(this.currentPosition);
        f1 = localView1.getLeft();
        f2 = localView1.getRight();
        if ((this.currentPositionOffset > 0.0F) && (this.currentPosition < -1 + this.tabCount))
        {
          View localView3 = this.mTabsContainer.getChildAt(1 + this.currentPosition);
          float f3 = localView3.getLeft();
          float f4 = localView3.getRight();
          f1 = f3 * this.currentPositionOffset + f1 * (1.0F - this.currentPositionOffset);
          f2 = f4 * this.currentPositionOffset + f2 * (1.0F - this.currentPositionOffset);
        }
        if (!this.indicatorOnTop)
          break label305;
        paramCanvas.drawRect(f1, 0.0F, f2, this.indicatorHeight, this.mCurrentPaint);
      }
      while (true)
      {
        if (!this.enableDivider)
          break label327;
        this.diviPaint.setColor(this.dividerColor);
        for (int j = 0; j < -1 + this.tabCount; j++)
        {
          View localView2 = this.mTabsContainer.getChildAt(j);
          paramCanvas.drawLine(localView2.getRight(), this.dividerPadding, localView2.getRight(), i - this.dividerPadding, this.diviPaint);
        }
        break;
        paramCanvas.drawRect(0.0F, i - this.underlineHeight, this.mTabsContainer.getWidth(), i, this.mBaseLinePaint);
        break label54;
        paramCanvas.drawRect(f1, i - this.indicatorHeight, f2, i, this.mCurrentPaint);
      }
    }
  }

  public void setCurrentItem(int paramInt)
  {
    this.mPager.setCurrentItem(paramInt, this.viewPagerScrollWithAnimation);
  }

  public void setEnableDivider(boolean paramBoolean)
  {
    this.enableDivider = paramBoolean;
  }

  public void setEnableExpand(boolean paramBoolean)
  {
    this.enableExpand = paramBoolean;
  }

  public void setIndicatorOnTop(boolean paramBoolean)
  {
    this.indicatorOnTop = paramBoolean;
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.mOnPageChangeListener = paramOnPageChangeListener;
  }

  public void setOnTabReselectedListener(OnTabSelectedListener paramOnTabSelectedListener)
  {
    this.mTabSelectedListener = paramOnTabSelectedListener;
  }

  public void setTabText(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > -1 + this.mTabsContainer.getChildCount()))
      throw new RuntimeException("tabs does not have this position.");
    View localView = this.mTabsContainer.getChildAt(paramInt);
    if ((localView instanceof TextView))
      ((TextView)localView).setText(paramString);
  }

  public void setViewPager(ViewPager paramViewPager)
  {
    this.mPager = paramViewPager;
    if (paramViewPager.getAdapter() == null)
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    paramViewPager.setOnPageChangeListener(new PageListener(null));
    notifyDataSetChanged();
  }

  public void setViewPagerScrollWithAnimation(boolean paramBoolean)
  {
    this.viewPagerScrollWithAnimation = paramBoolean;
  }

  public static abstract interface OnTabSelectedListener
  {
    public abstract void onTabSelected(int paramInt);
  }

  private class PageListener
    implements ViewPager.OnPageChangeListener
  {
    private PageListener()
    {
    }

    public void onPageScrollStateChanged(int paramInt)
    {
      if (paramInt == 0)
        LTabIndicator.this.scrollToChild(LTabIndicator.this.mPager.getCurrentItem(), 0);
      if (LTabIndicator.this.mOnPageChangeListener != null)
        LTabIndicator.this.mOnPageChangeListener.onPageScrollStateChanged(paramInt);
    }

    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      LTabIndicator.this.currentPosition = paramInt1;
      LTabIndicator.this.currentPositionOffset = paramFloat;
      LTabIndicator.this.scrollToChild(paramInt1, (int)(paramFloat * LTabIndicator.this.mTabsContainer.getChildAt(paramInt1).getWidth()));
      LTabIndicator.this.invalidate();
      if (LTabIndicator.this.mOnPageChangeListener != null)
        LTabIndicator.this.mOnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }

    public void onPageSelected(int paramInt)
    {
      LTabIndicator.this.tabSelect(paramInt);
      if (LTabIndicator.this.mOnPageChangeListener != null)
        LTabIndicator.this.mOnPageChangeListener.onPageSelected(paramInt);
    }
  }

  private class TabView extends LFrameLayout
  {
    private TextView mTabText;

    public TabView(Context arg2)
    {
      this(localContext, null);
    }

    public TabView(Context paramAttributeSet, AttributeSet arg3)
    {
      super(localAttributeSet);
      init();
      setDelayClick(false);
      setColor(LTabIndicator.this.mAnimColor);
    }

    private void init()
    {
      this.mTabText = new TextView(getContext());
      this.mTabText.setTextAppearance(getContext(), 16842817);
      this.mTabText.setTextSize(LTabIndicator.this.tabTextSize / getResources().getConfiguration().fontScale);
      this.mTabText.setSingleLine(true);
      this.mTabText.setGravity(17);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      addView(this.mTabText, localLayoutParams);
    }

    public TextView getTextView()
    {
      return this.mTabText;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.views.LTabIndicator
 * JD-Core Version:    0.6.2
 */