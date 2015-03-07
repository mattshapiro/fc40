package com.allinone.free.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UpdateDialogVerison2 extends Dialog
{
  private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener(null);
  private Button btnCancel;
  private Button btnEnter;
  private Context ctx;
  private ImageLoader imageLoader = ImageLoader.getInstance();
  private ImageView imgIcon;
  private View.OnClickListener itemsOnClick;
  private DisplayImageOptions options;
  private TextView tvContent;
  private TextView tvTitle;

  public UpdateDialogVerison2(Context paramContext, int paramInt, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramInt);
    this.ctx = paramContext;
    this.itemsOnClick = paramOnClickListener;
    this.options = new DisplayImageOptions.Builder().cacheOnDisc().showImageForEmptyUri(2130837671).displayer(new RoundedBitmapDisplayer(8)).build();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903083);
    this.btnCancel = ((Button)findViewById(2131230882));
    this.btnEnter = ((Button)findViewById(2131230883));
    this.tvTitle = ((TextView)findViewById(2131230751));
    this.tvContent = ((TextView)findViewById(2131230752));
    this.imgIcon = ((ImageView)findViewById(2131230878));
    this.btnCancel.setOnClickListener(this.itemsOnClick);
    this.btnEnter.setOnClickListener(this.itemsOnClick);
  }

  public void setImgIcon(String paramString)
  {
    this.imageLoader.init(ImageLoaderConfiguration.createDefault(this.ctx));
    this.imageLoader.displayImage(paramString, this.imgIcon, this.options, this.animateFirstListener);
  }

  public void setTvContent(String paramString)
  {
    this.tvContent.setText(paramString);
  }

  public void setTvTitle(String paramString)
  {
    this.tvTitle.setText(paramString);
  }

  private static class AnimateFirstDisplayListener extends SimpleImageLoadingListener
  {
    static final List<String> displayedImages = Collections.synchronizedList(new LinkedList());

    public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap)
    {
      ImageView localImageView;
      if (paramBitmap != null)
      {
        localImageView = (ImageView)paramView;
        if (!displayedImages.contains(paramString))
          break label49;
      }
      label49: for (int i = 0; ; i = 1)
      {
        if (i != 0)
        {
          FadeInBitmapDisplayer.animate(localImageView, 500);
          displayedImages.add(paramString);
        }
        return;
      }
    }
  }

  public static abstract interface OnCustomDialogListener
  {
    public abstract void back(String paramString);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.dialog.UpdateDialogVerison2
 * JD-Core Version:    0.6.2
 */