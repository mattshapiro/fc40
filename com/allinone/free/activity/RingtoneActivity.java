package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.allinone.free.fragments.RingtoneSearchFragment;
import com.allinone.free.fragments.Ringtone_Popular_Fragment;
import com.allinone.free.fragments.Ringtone_Recent_Fragment;
import com.allinone.free.utils.Myutils;
import com.allinone.free.views.SyncHorizontalScrollView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class RingtoneActivity extends SherlockFragmentActivity
{
  public static final String[] tabTitle = { "RECENT", "POPULAR" };
  private static Typeface typeFace = null;
  private AdView adView;
  private FrameLayout addlayout;
  private LinearLayout appbanner;
  private ImageView appfan;
  private String banner_type_name;
  private int currentIndicatorLeft = 0;
  private int currentfragment_id = 0;
  private EditText et_search_keywords;
  private int indicatorWidth;
  private ImageView iv_nav_indicator;
  private TabFragmentPagerAdapter mAdapter;
  private TabFragmentPagerAdapter2 mAdapter2;
  private SyncHorizontalScrollView mHsv;
  private LayoutInflater mInflater;
  private ViewPager mViewPager;
  private ViewPager mViewPager2;
  private Map<Integer, Fragment> map;
  private Map<Integer, Fragment> map2;
  private RadioGroup rg_nav_content;
  private SharedPreferences sp_config = null;
  View view = null;

  private void bindListeners()
  {
    this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
    {
      public void onPageScrollStateChanged(int paramAnonymousInt)
      {
      }

      public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2)
      {
      }

      public void onPageSelected(int paramAnonymousInt)
      {
        RingtoneActivity.this.currentfragment_id = paramAnonymousInt;
        if ((RingtoneActivity.this.rg_nav_content != null) && (RingtoneActivity.this.rg_nav_content.getChildCount() > paramAnonymousInt))
          ((RadioButton)RingtoneActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).performClick();
      }
    });
    this.rg_nav_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        RingtoneActivity.this.currentfragment_id = paramAnonymousInt;
        SyncHorizontalScrollView localSyncHorizontalScrollView;
        if (RingtoneActivity.this.rg_nav_content.getChildAt(paramAnonymousInt) != null)
        {
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(RingtoneActivity.this.currentIndicatorLeft, ((RadioButton)RingtoneActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft(), 0.0F, 0.0F);
          localTranslateAnimation.setInterpolator(new LinearInterpolator());
          localTranslateAnimation.setDuration(100L);
          localTranslateAnimation.setFillAfter(true);
          RingtoneActivity.this.iv_nav_indicator.startAnimation(localTranslateAnimation);
          RingtoneActivity.this.mViewPager.setCurrentItem(paramAnonymousInt);
          RingtoneActivity.this.currentIndicatorLeft = ((RadioButton)RingtoneActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft();
          localSyncHorizontalScrollView = RingtoneActivity.this.mHsv;
          if (paramAnonymousInt <= 1)
            break label187;
        }
        label187: for (int i = ((RadioButton)RingtoneActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft(); ; i = 0)
        {
          localSyncHorizontalScrollView.smoothScrollTo(i - ((RadioButton)RingtoneActivity.this.rg_nav_content.getChildAt(1)).getLeft(), 0);
          return;
        }
      }
    });
    this.et_search_keywords.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 66) && (!RingtoneActivity.this.et_search_keywords.getText().equals("")))
        {
          RingtoneActivity.this.mHsv.setVisibility(8);
          RingtoneActivity.this.mViewPager.setVisibility(8);
          if (RingtoneActivity.this.mAdapter2 == null)
          {
            RingtoneActivity.this.mAdapter2 = new RingtoneActivity.TabFragmentPagerAdapter2(RingtoneActivity.this, RingtoneActivity.this.getSupportFragmentManager());
            RingtoneActivity.this.mViewPager2.setAdapter(RingtoneActivity.this.mAdapter2);
          }
          RingtoneActivity.this.mViewPager2.setVisibility(0);
          if (!RingtoneActivity.this.et_search_keywords.getText().equals(""))
          {
            new Thread(new Runnable()
            {
              public void run()
              {
                String str = URLEncoder.encode(RingtoneActivity.this.et_search_keywords.getText().toString());
                Myutils.getInstance();
                Myutils.searchkeywords = str;
                Intent localIntent = new Intent();
                localIntent.setAction("ringtonesearch");
                RingtoneActivity.this.sendBroadcast(localIntent);
              }
            }).start();
            ((InputMethodManager)RingtoneActivity.this.et_search_keywords.getContext().getSystemService("input_method")).hideSoftInputFromWindow(RingtoneActivity.this.et_search_keywords.getWindowToken(), 0);
          }
        }
        return false;
      }
    });
  }

  @SuppressLint({"UseSparseArrays"})
  private void buildComponents()
  {
    this.appfan = ((ImageView)findViewById(2131230789));
    this.appfan.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RingtoneActivity.this.finish();
      }
    });
    this.appbanner = ((LinearLayout)findViewById(2131230866));
    this.sp_config = getSharedPreferences("banner_type", 0);
    this.banner_type_name = this.sp_config.getString("banner_type", "admob");
    if (this.banner_type_name.equals("admob"))
    {
      this.adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-1054623928013334/2194439000");
      this.appbanner.addView(this.adView);
      this.adView.loadAd(new AdRequest());
    }
    this.rg_nav_content = ((RadioGroup)findViewById(2131230861));
    this.mViewPager = ((ViewPager)findViewById(2131230864));
    this.mViewPager2 = ((ViewPager)findViewById(2131230865));
    this.mHsv = ((SyncHorizontalScrollView)findViewById(2131230859));
    this.iv_nav_indicator = ((ImageView)findViewById(2131230862));
    this.map = new HashMap();
    this.map2 = new HashMap();
  }

  private void init()
  {
    this.et_search_keywords = ((EditText)findViewById(2131230856));
    this.et_search_keywords.setHint("Search Ringtone");
    typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.et_search_keywords.setTypeface(typeFace);
    this.addlayout = ((FrameLayout)findViewById(2131230863));
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.indicatorWidth = (localDisplayMetrics.widthPixels / 2);
    ViewGroup.LayoutParams localLayoutParams = this.iv_nav_indicator.getLayoutParams();
    localLayoutParams.width = this.indicatorWidth;
    this.iv_nav_indicator.setLayoutParams(localLayoutParams);
    this.mInflater = ((LayoutInflater)getSystemService("layout_inflater"));
    initNavigationHSV();
    this.mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
    this.mViewPager.setAdapter(this.mAdapter);
    this.rg_nav_content.getChildAt(0).performClick();
  }

  private void initNavigationHSV()
  {
    this.rg_nav_content.removeAllViews();
    for (int i = 0; ; i++)
    {
      if (i >= tabTitle.length)
        return;
      RadioButton localRadioButton = (RadioButton)this.mInflater.inflate(2130903112, null);
      localRadioButton.setId(i);
      localRadioButton.setText(tabTitle[i]);
      localRadioButton.setLayoutParams(new ViewGroup.LayoutParams(this.indicatorWidth, -1));
      this.rg_nav_content.addView(localRadioButton);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903075);
    buildComponents();
    init();
    bindListeners();
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

  public class TabFragmentPagerAdapter extends FragmentPagerAdapter
  {
    public TabFragmentPagerAdapter(FragmentManager arg2)
    {
      super();
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
    }

    public int getCount()
    {
      return RingtoneActivity.tabTitle.length;
    }

    public Fragment getItem(int paramInt)
    {
      Object localObject = (Fragment)RingtoneActivity.this.map.get(Integer.valueOf(paramInt));
      if (localObject != null)
        return localObject;
      switch (paramInt)
      {
      default:
      case 0:
      case 1:
      }
      while (true)
      {
        RingtoneActivity.this.map.put(Integer.valueOf(paramInt), localObject);
        return localObject;
        localObject = new Ringtone_Recent_Fragment();
        continue;
        localObject = new Ringtone_Popular_Fragment();
      }
    }
  }

  private class TabFragmentPagerAdapter2 extends FragmentPagerAdapter
  {
    public TabFragmentPagerAdapter2(FragmentManager arg2)
    {
      super();
    }

    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
    }

    public int getCount()
    {
      return 1;
    }

    public Fragment getItem(int paramInt)
    {
      Fragment localFragment = (Fragment)RingtoneActivity.this.map2.get(Integer.valueOf(paramInt));
      if (localFragment != null)
        return localFragment;
      RingtoneSearchFragment localRingtoneSearchFragment = new RingtoneSearchFragment();
      RingtoneActivity.this.map2.put(Integer.valueOf(paramInt), localRingtoneSearchFragment);
      return localRingtoneSearchFragment;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.RingtoneActivity
 * JD-Core Version:    0.6.2
 */