package com.allinone.free.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;
import java.util.List;

public class AppsearchFragmentAdapter extends BaseAdapter
{
  private MyApplcation app;
  private Context ctx;
  private ViewHolder holder = null;
  private List<DownloadMovieItem> list;

  public AppsearchFragmentAdapter(Context paramContext, List<DownloadMovieItem> paramList)
  {
    this.ctx = paramContext;
    this.list = paramList;
    try
    {
      this.app = ((MyApplcation)paramContext.getApplicationContext());
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void addItem(ArrayList<DownloadMovieItem> paramArrayList)
  {
    this.list.addAll(paramArrayList);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    if ((this.list != null) && (this.list.size() > 0))
      return this.list.size();
    return 0;
  }

  public Object getItem(int paramInt)
  {
    return this.list.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final DownloadMovieItem localDownloadMovieItem = (DownloadMovieItem)this.list.get(paramInt);
    if (paramView == null)
    {
      this.holder = new ViewHolder();
      paramView = View.inflate(this.ctx, 2130903073, null);
      this.holder.appicon = ((ImageView)paramView.findViewById(2131230848));
      this.holder.apptitle = ((TextView)paramView.findViewById(2131230849));
      this.holder.appprice = ((TextView)paramView.findViewById(2131230853));
      this.holder.appauthortitle = ((TextView)paramView.findViewById(2131230850));
      this.holder.app_ratingbar = ((RatingBar)paramView.findViewById(2131230851));
      this.holder.app_download_bt = ((Button)paramView.findViewById(2131230852));
      paramView.setTag(this.holder);
    }
    while (true)
    {
      this.holder.apptitle.setText(localDownloadMovieItem.getTitle());
      this.holder.appauthortitle.setText(localDownloadMovieItem.getAuthor_title());
      this.holder.appprice.setText(localDownloadMovieItem.getPrice());
      this.holder.app_ratingbar.setRating(localDownloadMovieItem.getRating().floatValue());
      this.app.asyncLoadImage(localDownloadMovieItem.getIcon(), this.holder.appicon);
      this.holder.app_download_bt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          new Thread(new Runnable()
          {
            public void run()
            {
              publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=" + this.val$in_fo.getId() + "&from=apk");
            }
          }).start();
          Message localMessage = new Message();
          localMessage.what = 780;
          localMessage.getData().putString("appid", localDownloadMovieItem.getId());
          localMessage.getData().putString("apptitle", localDownloadMovieItem.getTitle());
          localMessage.getData().putString("appicon", localDownloadMovieItem.getIcon());
          publicTools.appsearchhandler.sendMessage(localMessage);
        }
      });
      return paramView;
      this.holder = ((ViewHolder)paramView.getTag());
    }
  }

  class ViewHolder
  {
    private Button app_download_bt;
    private RatingBar app_ratingbar;
    private TextView appauthortitle;
    private ImageView appicon;
    private TextView appprice;
    private TextView apptitle;

    ViewHolder()
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.adapter.AppsearchFragmentAdapter
 * JD-Core Version:    0.6.2
 */