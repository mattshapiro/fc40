package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.allinone.free.dialog.DownloadpathCustomDialog;
import com.allinone.free.fragments.AppFragment;
import com.allinone.free.fragments.Mp3Fragment;
import com.allinone.free.fragments.RingtoneFragment;
import com.allinone.free.fragments.VideoFragment;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.views.SyncHorizontalScrollView;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import java.util.Map;

public class FileActivity extends SherlockFragmentActivity
  implements View.OnClickListener
{
  public static final String[] tabTitle = { "App", "MP3", "Ringtone", "Video" };
  private static Typeface typeFace = null;
  private int currentIndicatorLeft = 0;
  private int currentfragment_id = 0;
  public DownlaodActivity downlaodActivity;
  TextView file;
  private ImageView filemore;
  private int indicatorWidth;
  private ImageView iv_nav_indicator;
  private RelativeLayout l1;
  private RelativeLayout l2;
  private RelativeLayout l3;
  private RelativeLayout l4;
  private TabFragmentPagerAdapter mAdapter;
  private SyncHorizontalScrollView mHsv;
  private LayoutInflater mInflater;
  private ViewPager mViewPager;
  private PopupWindow mWindow;
  private Map<Integer, Fragment> map;
  private RadioGroup rg_nav_content;
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
        FileActivity.this.currentfragment_id = paramAnonymousInt;
        Log.v("mkmk", "切换页面" + FileActivity.this.currentfragment_id);
        if ((FileActivity.this.rg_nav_content != null) && (FileActivity.this.rg_nav_content.getChildCount() > paramAnonymousInt))
          ((RadioButton)FileActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).performClick();
      }
    });
    this.rg_nav_content.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        FileActivity.this.currentfragment_id = paramAnonymousInt;
        Log.v("mkmk", "切换页面" + FileActivity.this.currentfragment_id);
        SyncHorizontalScrollView localSyncHorizontalScrollView;
        if (FileActivity.this.rg_nav_content.getChildAt(paramAnonymousInt) != null)
        {
          TranslateAnimation localTranslateAnimation = new TranslateAnimation(FileActivity.this.currentIndicatorLeft, ((RadioButton)FileActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft(), 0.0F, 0.0F);
          localTranslateAnimation.setInterpolator(new LinearInterpolator());
          localTranslateAnimation.setDuration(100L);
          localTranslateAnimation.setFillAfter(true);
          FileActivity.this.iv_nav_indicator.startAnimation(localTranslateAnimation);
          FileActivity.this.mViewPager.setCurrentItem(paramAnonymousInt);
          FileActivity.this.currentIndicatorLeft = ((RadioButton)FileActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft();
          localSyncHorizontalScrollView = FileActivity.this.mHsv;
          if (paramAnonymousInt <= 1)
            break label220;
        }
        label220: for (int i = ((RadioButton)FileActivity.this.rg_nav_content.getChildAt(paramAnonymousInt)).getLeft(); ; i = 0)
        {
          localSyncHorizontalScrollView.smoothScrollTo(i - ((RadioButton)FileActivity.this.rg_nav_content.getChildAt(1)).getLeft(), 0);
          return;
        }
      }
    });
  }

  private void buildComponents()
  {
    this.rg_nav_content = ((RadioGroup)findViewById(2131230861));
    this.mViewPager = ((ViewPager)findViewById(2131230864));
    this.mHsv = ((SyncHorizontalScrollView)findViewById(2131230859));
    this.iv_nav_indicator = ((ImageView)findViewById(2131230862));
    this.map = new HashMap();
  }

  private void init()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.indicatorWidth = (localDisplayMetrics.widthPixels / 4);
    ViewGroup.LayoutParams localLayoutParams = this.iv_nav_indicator.getLayoutParams();
    localLayoutParams.width = this.indicatorWidth;
    this.iv_nav_indicator.setLayoutParams(localLayoutParams);
    this.mInflater = ((LayoutInflater)getSystemService("layout_inflater"));
    initNavigationHSV();
    this.filemore = ((ImageView)findViewById(2131230901));
    this.file = ((TextView)findViewById(2131230900));
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.file.setTypeface(typeFace);
    this.mAdapter = new TabFragmentPagerAdapter(getSupportFragmentManager());
    this.mViewPager.setAdapter(this.mAdapter);
    this.rg_nav_content.getChildAt(0).performClick();
    this.filemore.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FileActivity.this.popuWindow();
        FileActivity.this.mWindow.showAtLocation(paramAnonymousView, 53, 0, DisplayUtil.dip2px(FileActivity.this.getApplicationContext(), 14.0F));
        FileActivity.this.l3.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            String str;
            switch (FileActivity.this.currentfragment_id)
            {
            default:
              str = FileActivity.this.getString(2131099727);
            case 0:
            case 1:
            case 2:
            case 3:
            }
            while (true)
            {
              new AlertDialog.Builder(FileActivity.this).setTitle(FileActivity.this.getString(2131099715)).setMessage(str).setPositiveButton(FileActivity.this.getString(2131099723), new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  switch (FileActivity.this.currentfragment_id)
                  {
                  default:
                    return;
                  case 0:
                    ((AppFragment)FileActivity.this.mAdapter.getItem(FileActivity.this.currentfragment_id)).Appdeletall();
                    return;
                  case 1:
                    ((Mp3Fragment)FileActivity.this.mAdapter.getItem(FileActivity.this.currentfragment_id)).Mp3deletall();
                    return;
                  case 2:
                    ((RingtoneFragment)FileActivity.this.mAdapter.getItem(FileActivity.this.currentfragment_id)).Ringtonedeletall();
                    return;
                  case 3:
                  }
                  ((VideoFragment)FileActivity.this.mAdapter.getItem(FileActivity.this.currentfragment_id)).Videodeletall();
                }
              }).setNegativeButton(FileActivity.this.getString(2131099722), new DialogInterface.OnClickListener()
              {
                public void onClick(DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                }
              }).show();
              return;
              str = FileActivity.this.getString(2131099728);
              continue;
              str = FileActivity.this.getString(2131099729);
              continue;
              str = FileActivity.this.getString(2131099730);
              continue;
              str = FileActivity.this.getString(2131099731);
            }
          }
        });
        FileActivity.this.l4.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            final DownloadpathCustomDialog localDownloadpathCustomDialog = new DownloadpathCustomDialog(FileActivity.this, 2131165279);
            localDownloadpathCustomDialog.setCanceledOnTouchOutside(false);
            localDownloadpathCustomDialog.show();
            ((Button)localDownloadpathCustomDialog.findViewById(2131230895)).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous3View)
              {
                localDownloadpathCustomDialog.dismiss();
              }
            });
          }
        });
      }
    });
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

  @SuppressLint({"NewApi"})
  private void popuWindow()
  {
    View localView = LayoutInflater.from(this).inflate(2130903090, null);
    this.l1 = ((RelativeLayout)localView.findViewById(2131230892));
    this.l2 = ((RelativeLayout)localView.findViewById(2131230893));
    this.l3 = ((RelativeLayout)localView.findViewById(2131230894));
    this.l4 = ((RelativeLayout)localView.findViewById(2131230902));
    this.l1.setOnClickListener(this);
    this.l2.setOnClickListener(this);
    this.l4.setOnClickListener(this);
    this.mWindow = new PopupWindow(localView);
    getWindowManager().getDefaultDisplay().getHeight();
    int i = getWindowManager().getDefaultDisplay().getWidth();
    this.mWindow.setWidth(50 + i / 2);
    this.mWindow.setHeight(-2);
    this.mWindow.setFocusable(true);
    this.mWindow.setAnimationStyle(2131165282);
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    this.mWindow.setBackgroundDrawable(localColorDrawable);
  }

  @SuppressLint({"NewApi"})
  public void onClick(View paramView)
  {
    String str = "timesort";
    switch (paramView.getId())
    {
    default:
      switch (this.currentfragment_id)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      break;
    case 2131230892:
    case 2131230893:
    }
    while (true)
    {
      this.mWindow.dismiss();
      return;
      str = "timesort";
      break;
      str = "zimusort";
      break;
      ((AppFragment)this.mAdapter.getItem(this.currentfragment_id)).AppSort(str);
      continue;
      ((Mp3Fragment)this.mAdapter.getItem(this.currentfragment_id)).Mp3Sort(str);
      continue;
      ((RingtoneFragment)this.mAdapter.getItem(this.currentfragment_id)).RingtoneSort(str);
      continue;
      ((VideoFragment)this.mAdapter.getItem(this.currentfragment_id)).VideoSort(str);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903089);
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
      return FileActivity.tabTitle.length;
    }

    public Fragment getItem(int paramInt)
    {
      Object localObject = (Fragment)FileActivity.this.map.get(Integer.valueOf(paramInt));
      if (localObject != null)
        return localObject;
      switch (paramInt)
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        FileActivity.this.map.put(Integer.valueOf(paramInt), localObject);
        return localObject;
        localObject = new AppFragment();
        continue;
        localObject = new Mp3Fragment();
        continue;
        localObject = new RingtoneFragment();
        continue;
        localObject = new VideoFragment();
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.FileActivity
 * JD-Core Version:    0.6.2
 */