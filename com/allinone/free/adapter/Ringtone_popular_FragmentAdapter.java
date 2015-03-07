package com.allinone.free.adapter;

import android.content.Context;
import android.content.SharedPreferences;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;
import java.util.List;

public class Ringtone_popular_FragmentAdapter extends BaseAdapter
{
  private MyApplcation app;
  private Context ctx;
  private List<DownloadMovieItem> list;

  public Ringtone_popular_FragmentAdapter(Context paramContext, List<DownloadMovieItem> paramList)
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
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ViewHolder();
      paramView = View.inflate(this.ctx, 2130903123, null);
      localViewHolder.ringtoneicon = ((ImageView)paramView.findViewById(2131230922));
      localViewHolder.ringtonetitle = ((TextView)paramView.findViewById(2131231026));
      localViewHolder.ringtonecat = ((TextView)paramView.findViewById(2131231027));
      localViewHolder.ringtone_ratingbar = ((RatingBar)paramView.findViewById(2131231028));
      localViewHolder.ringtone_download_bt = ((Button)paramView.findViewById(2131231029));
      localViewHolder.list_bg = ((RelativeLayout)paramView.findViewById(2131230973));
      paramView.setTag(localViewHolder);
    }
    while (true)
    {
      int i = -1;
      try
      {
        int j = this.ctx.getSharedPreferences("ringtone_popular_data", 0).getInt("ringtone_popular_selector", -1);
        i = j;
        label157: if (i == paramInt)
          localViewHolder.list_bg.setBackgroundResource(2130837686);
        while (true)
        {
          localViewHolder.ringtonetitle.setText(localDownloadMovieItem.getTitle());
          localViewHolder.ringtonecat.setText(localDownloadMovieItem.getCat());
          localViewHolder.ringtone_ratingbar.setRating(localDownloadMovieItem.getRating().floatValue());
          localViewHolder.ringtone_download_bt.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              new Thread(new Runnable()
              {
                public void run()
                {
                  publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=ringtone&id=" + this.val$in_fo.getId() + "&title=" + this.val$in_fo.getTitle() + "&cat=" + this.val$in_fo.getCat() + "&downloads=" + this.val$in_fo.getDownloads());
                }
              }).start();
              Message localMessage = new Message();
              localMessage.what = 680;
              localMessage.getData().putString("ringtoneid", localDownloadMovieItem.getId());
              localMessage.getData().putString("ringtonetitle", localDownloadMovieItem.getTitle());
              publicTools.ringtonepopularhandler.sendMessage(localMessage);
            }
          });
          return paramView;
          localViewHolder = (ViewHolder)paramView.getTag();
          break;
          localViewHolder.list_bg.setBackgroundResource(2130837663);
        }
      }
      catch (Exception localException)
      {
        break label157;
      }
    }
  }

  class ViewHolder
  {
    private RelativeLayout list_bg;
    private Button ringtone_download_bt;
    private RatingBar ringtone_ratingbar;
    private TextView ringtonecat;
    private ImageView ringtoneicon;
    private TextView ringtonetitle;

    ViewHolder()
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.adapter.Ringtone_popular_FragmentAdapter
 * JD-Core Version:    0.6.2
 */