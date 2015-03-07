package com.allinone.free.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.pager.JazzyViewPager;
import com.allinone.free.pager.JazzyViewPager.TransitionEffect;
import com.allinone.free.pager.OutlineContainer;
import com.umeng.analytics.MobclickAgent;
import java.util.ArrayList;

public class ImagePagerActivity extends Activity
  implements ViewPager.OnPageChangeListener
{
  private MyApplcation app;
  private LayoutInflater inflater;
  private ArrayList<DownloadMovieItem> list;
  private int screenshotpos;
  private JazzyViewPager viewPager;

  private void init()
  {
    this.app = ((MyApplcation)getApplicationContext());
    this.viewPager = ((JazzyViewPager)findViewById(2131230867));
    JazzyViewPager.TransitionEffect localTransitionEffect = JazzyViewPager.TransitionEffect.Tablet;
    this.viewPager.setTransitionEffect(localTransitionEffect);
    this.viewPager.setOnPageChangeListener(this);
    this.viewPager.setAdapter(new MyPageAdapter(this.list));
    this.viewPager.setCurrentItem(this.screenshotpos);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903076);
    this.list = ((ArrayList)getIntent().getSerializableExtra("screenshotlist"));
    this.screenshotpos = getIntent().getIntExtra("screenshotpos", 0);
    init();
  }

  public void onPageScrollStateChanged(int paramInt)
  {
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public void onPageSelected(int paramInt)
  {
    this.screenshotpos = paramInt;
  }

  protected void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(this);
  }

  private class MyPageAdapter extends PagerAdapter
  {
    ArrayList<DownloadMovieItem> list;

    static
    {
      if (!ImagePagerActivity.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    public MyPageAdapter()
    {
      Object localObject;
      this.list = localObject;
      ImagePagerActivity.this.inflater = ImagePagerActivity.this.getLayoutInflater();
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView(ImagePagerActivity.this.viewPager.findViewFromObject(paramInt));
    }

    public int getCount()
    {
      if ((this.list == null) || (this.list.size() == 0))
        return this.list.size();
      return this.list.size();
    }

    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = ImagePagerActivity.this.inflater.inflate(2130903097, paramViewGroup, false);
      assert (localView != null);
      ImageView localImageView = (ImageView)localView.findViewById(2131230942);
      ImagePagerActivity.this.app.asyncLoadImage(((DownloadMovieItem)this.list.get(paramInt)).getScreenshots(), localImageView);
      ((JazzyViewPager)paramViewGroup).addView(localView, -1, -1);
      ImagePagerActivity.this.viewPager.setObjectForPosition(localView, paramInt);
      return localView;
    }

    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      if ((paramView instanceof OutlineContainer))
        if (((OutlineContainer)paramView).getChildAt(0) != paramObject);
      while (paramView == paramObject)
      {
        return true;
        return false;
      }
      return false;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.ImagePagerActivity
 * JD-Core Version:    0.6.2
 */