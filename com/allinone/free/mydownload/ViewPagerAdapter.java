package com.allinone.free.mydownload;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter
{
  public List<View> mListViews;

  public ViewPagerAdapter(List<View> paramList)
  {
    this.mListViews = paramList;
  }

  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    ((ViewPager)paramView).removeView((View)this.mListViews.get(paramInt));
  }

  public int getCount()
  {
    return this.mListViews.size();
  }

  public Object instantiateItem(View paramView, int paramInt)
  {
    ((ViewPager)paramView).addView((View)this.mListViews.get(paramInt), 0);
    return this.mListViews.get(paramInt);
  }

  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.mydownload.ViewPagerAdapter
 * JD-Core Version:    0.6.2
 */