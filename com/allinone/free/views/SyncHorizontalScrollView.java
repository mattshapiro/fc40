package com.allinone.free.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class SyncHorizontalScrollView extends HorizontalScrollView
{
  private ImageView leftImage;
  private Activity mContext;
  private ImageView rightImage;
  private View view;
  private int windowWitdh = 0;

  public SyncHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public SyncHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void setSomeParam(View paramView, ImageView paramImageView1, ImageView paramImageView2, Activity paramActivity)
  {
    this.mContext = paramActivity;
    this.view = paramView;
    this.leftImage = paramImageView1;
    this.rightImage = paramImageView2;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.mContext.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.windowWitdh = localDisplayMetrics.widthPixels;
  }

  public void showAndHideArrow()
  {
    if ((!this.mContext.isFinishing()) && (this.view != null))
    {
      measure(0, 0);
      if (this.windowWitdh >= getMeasuredWidth())
      {
        this.leftImage.setVisibility(8);
        this.rightImage.setVisibility(8);
      }
    }
    else
    {
      return;
    }
    if (getLeft() == 0)
    {
      this.leftImage.setVisibility(8);
      this.rightImage.setVisibility(0);
      return;
    }
    if (getRight() == getMeasuredWidth() - this.windowWitdh)
    {
      this.leftImage.setVisibility(0);
      this.rightImage.setVisibility(8);
      return;
    }
    this.leftImage.setVisibility(0);
    this.rightImage.setVisibility(0);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.views.SyncHorizontalScrollView
 * JD-Core Version:    0.6.2
 */