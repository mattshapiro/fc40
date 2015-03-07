package com.allinone.free.mydownload;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyApplcation extends Application
{
  public static final boolean DEVELOPER_MODE;
  private static final String TAG = MyApplcation.class.getName();
  private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener(null);
  private List<DownloadMovieItem> downloadItems = new ArrayList();
  private DownloadMovieItem downloadSuccess;
  private ImageLoader imageLoader = ImageLoader.getInstance();
  private List<DownloadMovieItem> list;
  private PushAgent mPushAgent;
  private DisplayImageOptions options = new DisplayImageOptions.Builder().cacheOnDisc().showStubImage(2130837634).build();
  private ViewPager pager;
  private DownloadMovieItem startDownloadMovieItem;
  private DownloadMovieItem stopOrStartDownloadMovieItem;

  public static void initImageLoader(Context paramContext)
  {
    ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(paramContext).threadPriority(3).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator()).tasksProcessingOrder(QueueProcessingType.LIFO).enableLogging().build();
    ImageLoader.getInstance().init(localImageLoaderConfiguration);
  }

  public void asyncLoadImage(String paramString, ImageView paramImageView)
  {
    this.imageLoader.displayImage(paramString, paramImageView, this.options, this.animateFirstListener);
  }

  public List<DownloadMovieItem> getDownloadItems()
  {
    return this.downloadItems;
  }

  public DownloadMovieItem getDownloadSuccess()
  {
    return this.downloadSuccess;
  }

  public List<DownloadMovieItem> getListData()
  {
    return this.list;
  }

  public ViewPager getPager()
  {
    return this.pager;
  }

  public DownloadMovieItem getStartDownloadMovieItem()
  {
    return this.startDownloadMovieItem;
  }

  public DownloadMovieItem getStopOrStartDownloadMovieItem()
  {
    return this.stopOrStartDownloadMovieItem;
  }

  public void onCreate()
  {
    super.onCreate();
    this.list = new ArrayList();
    initImageLoader(getApplicationContext());
    this.mPushAgent = PushAgent.getInstance(this);
    UmengMessageHandler local1 = new UmengMessageHandler()
    {
      public void dealWithCustomMessage(final Context paramAnonymousContext, final UMessage paramAnonymousUMessage)
      {
        new Handler(MyApplcation.this.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            UTrack.getInstance(MyApplcation.this.getApplicationContext()).trackMsgClick(paramAnonymousUMessage);
            Toast.makeText(paramAnonymousContext, paramAnonymousUMessage.custom, 1).show();
          }
        });
      }

      public Notification getNotification(Context paramAnonymousContext, UMessage paramAnonymousUMessage)
      {
        switch (paramAnonymousUMessage.builder_id)
        {
        default:
          return super.getNotification(paramAnonymousContext, paramAnonymousUMessage);
        case 1:
        }
        NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramAnonymousContext);
        RemoteViews localRemoteViews = new RemoteViews(paramAnonymousContext.getPackageName(), 2130903114);
        localRemoteViews.setTextViewText(2131230994, paramAnonymousUMessage.title);
        localRemoteViews.setTextViewText(2131230995, paramAnonymousUMessage.text);
        localRemoteViews.setImageViewBitmap(2131230993, getLargeIcon(paramAnonymousContext, paramAnonymousUMessage));
        localRemoteViews.setImageViewResource(2131230996, getSmallIconId(paramAnonymousContext, paramAnonymousUMessage));
        localBuilder.setContent(localRemoteViews);
        localBuilder.setAutoCancel(true);
        Notification localNotification = localBuilder.build();
        localNotification.contentView = localRemoteViews;
        return localNotification;
      }
    };
    this.mPushAgent.setMessageHandler(local1);
    UmengNotificationClickHandler local2 = new UmengNotificationClickHandler()
    {
      public void dealWithCustomAction(Context paramAnonymousContext, UMessage paramAnonymousUMessage)
      {
        Toast.makeText(paramAnonymousContext, paramAnonymousUMessage.custom, 1).show();
      }
    };
    this.mPushAgent.setNotificationClickHandler(local2);
  }

  public void setDownloadItems(List<DownloadMovieItem> paramList)
  {
    this.downloadItems = paramList;
  }

  public void setDownloadSuccess(DownloadMovieItem paramDownloadMovieItem)
  {
    this.downloadSuccess = paramDownloadMovieItem;
  }

  public void setListData(List<DownloadMovieItem> paramList)
  {
    this.list = paramList;
  }

  public void setPager(ViewPager paramViewPager)
  {
    this.pager = paramViewPager;
  }

  public void setStartDownloadMovieItem(DownloadMovieItem paramDownloadMovieItem)
  {
    this.startDownloadMovieItem = paramDownloadMovieItem;
  }

  public void setStopOrStartDownloadMovieItem(DownloadMovieItem paramDownloadMovieItem)
  {
    this.stopOrStartDownloadMovieItem = paramDownloadMovieItem;
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
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.mydownload.MyApplcation
 * JD-Core Version:    0.6.2
 */