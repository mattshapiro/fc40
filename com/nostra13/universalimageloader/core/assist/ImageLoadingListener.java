package com.nostra13.universalimageloader.core.assist;

import android.graphics.Bitmap;
import android.view.View;

public abstract interface ImageLoadingListener
{
  public abstract void onLoadingCancelled(String paramString, View paramView);

  public abstract void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap);

  public abstract void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason);

  public abstract void onLoadingStarted(String paramString, View paramView);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ImageLoadingListener
 * JD-Core Version:    0.6.2
 */