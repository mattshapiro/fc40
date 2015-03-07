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
import com.allinone.free.fragments.Mp3SearchFragment;
import com.allinone.free.fragments.Mp3_Popular_Fragment;
import com.allinone.free.fragments.Mp3_Recent_Fragment;
import com.allinone.free.utils.Myutils;
import com.allinone.free.views.SyncHorizontalScrollView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class Mp3Activity extends SherlockFragmentActivity
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
    this.appfan.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Mp3Activity.this.finish();
      }
    });
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
        Mp3Activity.this.currentfragment_id = paramAnonymousInt;
        if ((Mp3Activity.this.rg_nav_content != null) && (Mp3Activity.this.rg_nav_content.getChildCount() > paramAnonymousInt))
          ((RadioButton)Mp3Activity.this.rg_nav_content.getChildAt(paramAnonymousInt)).performClick();
      }
    });
    this.rg_nav_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        Mp3Activity.this.currentfragment_id = paramAnonymousInt;
        SyncHorizontalScrollView localSyncHorizontalScrollView;
        if (Mp3Activity.this.rg_nav_content.getChildAt(paramAnonymousInt) != null)
        {
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(Mp3Activity.this.currentIndicatorLeft, ((RadioButton)Mp3Activity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft(), 0.0F, 0.0F);
          localTranslateAnimation.setInterpolator(new LinearInterpolator());
          localTranslateAnimation.setDuration(100L);
          localTranslateAnimation.setFillAfter(true);
          Mp3Activity.this.iv_nav_indicator.startAnimation(localTranslateAnimation);
          Mp3Activity.this.mViewPager.setCurrentItem(paramAnonymousInt);
          Mp3Activity.this.currentIndicatorLeft = ((RadioButton)Mp3Activity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft();
          localSyncHorizontalScrollView = Mp3Activity.this.mHsv;
          if (paramAnonymousInt <= 1)
            break label187;
        }
        label187: for (int i = ((RadioButton)Mp3Activity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft(); ; i = 0)
        {
          localSyncHorizontalScrollView.smoothScrollTo(i - ((RadioButton)Mp3Activity.this.rg_nav_content.getChildAt(1)).getLeft(), 0);
          return;
        }
      }
    });
    this.et_search_keywords.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        int i = paramAnonymousKeyEvent.getAction();
        boolean bool = false;
        if (i == 0)
        {
          bool = false;
          if (paramAnonymousInt == 66)
          {
            if (!Mp3Activity.this.et_search_keywords.getText().equals(""))
            {
              Mp3Activity.this.mHsv.setVisibility(8);
              Mp3Activity.this.mViewPager.setVisibility(8);
              if (Mp3Activity.this.mAdapter2 == null)
              {
                Mp3Activity.this.mAdapter2 = new Mp3Activity.TabFragmentPagerAdapter2(Mp3Activity.this, Mp3Activity.this.getSupportFragmentManager());
                Mp3Activity.this.mViewPager2.setAdapter(Mp3Activity.this.mAdapter2);
              }
              Mp3Activity.this.mViewPager2.setVisibility(0);
              if (!Mp3Activity.this.et_search_keywords.getText().equals(""))
              {
                new Thread(new Runnable()
                {
                  public void run()
                  {
                    String str = URLEncoder.encode(Mp3Activity.this.et_search_keywords.getText().toString());
                    Myutils.getInstance();
                    Myutils.searchkeywords = str;
                    Intent localIntent = new Intent();
                    localIntent.setAction("mp3search");
                    Mp3Activity.this.sendBroadcast(localIntent);
                  }
                }).start();
                ((InputMethodManager)Mp3Activity.this.et_search_keywords.getContext().getSystemService("input_method")).hideSoftInputFromWindow(Mp3Activity.this.et_search_keywords.getWindowToken(), 0);
              }
            }
            bool = true;
          }
        }
        return bool;
      }
    });
  }

  @SuppressLint({"UseSparseArrays"})
  private void buildComponents()
  {
    this.appfan = ((ImageView)findViewById(2131230789));
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
    this.et_search_keywords.setHint("Search Mp3");
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
      return Mp3Activity.tabTitle.length;
    }

    public Fragment getItem(int paramInt)
    {
      Object localObject = (Fragment)Mp3Activity.this.map.get(Integer.valueOf(paramInt));
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
        Mp3Activity.this.map.put(Integer.valueOf(paramInt), localObject);
        return localObject;
        localObject = new Mp3_Recent_Fragment();
        continue;
        localObject = new Mp3_Popular_Fragment();
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
      Fragment localFragment = (Fragment)Mp3Activity.this.map2.get(Integer.valueOf(paramInt));
      if (localFragment != null)
        return localFragment;
      Mp3SearchFragment localMp3SearchFragment = new Mp3SearchFragment();
      Mp3Activity.this.map2.put(Integer.valueOf(paramInt), localMp3SearchFragment);
      return localMp3SearchFragment;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.Mp3Activity
 * JD-Core Version:    0.6.2
 */