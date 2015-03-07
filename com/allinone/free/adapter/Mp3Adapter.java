package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import java.util.List;

public class Mp3Adapter extends BaseAdapter
{
  private MyApplcation app;
  Context ctx;
  private List<DownloadMovieItem> list;

  public Mp3Adapter(Context paramContext, List<DownloadMovieItem> paramList)
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

  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    final DownloadMovieItem localDownloadMovieItem = (DownloadMovieItem)this.list.get(paramInt);
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ViewHolder();
      paramView = View.inflate(this.ctx, 2130903106, null);
      localViewHolder.my_delete_movie = ((ImageView)paramView.findViewById(2131230968));
      localViewHolder.my_test_head_image = ((ImageView)paramView.findViewById(2131230969));
      localViewHolder.my_movie_name_item = ((TextView)paramView.findViewById(2131230970));
      localViewHolder.my_totalsize = ((TextView)paramView.findViewById(2131230971));
      localViewHolder.my_stop_download_bt = ((Button)paramView.findViewById(2131230972));
      paramView.setTag(localViewHolder);
    }
    while (true)
    {
      localViewHolder.my_totalsize.setText(localDownloadMovieItem.getFileSize());
      localViewHolder.my_movie_name_item.setText(localDownloadMovieItem.getMovieName());
      this.app.asyncLoadImage(localDownloadMovieItem.getMovieHeadImagePath(), localViewHolder.my_test_head_image);
      localViewHolder.my_stop_download_bt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("mp3play");
          localIntent.putExtra("mp3positiontitle", localDownloadMovieItem.getMovieName());
          localIntent.putExtra("mp3position", localDownloadMovieItem.getFilePath());
          Log.v("mp3position", localDownloadMovieItem.getFilePath());
          Mp3Adapter.this.ctx.sendBroadcast(localIntent);
        }
      });
      localViewHolder.my_delete_movie.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("mp3delete");
          localIntent.putExtra("position", paramInt);
          Mp3Adapter.this.ctx.sendBroadcast(localIntent);
        }
      });
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
    }
  }

  class ViewHolder
  {
    ImageView my_delete_movie;
    TextView my_movie_name_item;
    Button my_stop_download_bt;
    ImageView my_test_head_image;
    TextView my_totalsize;

    ViewHolder()
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.adapter.Mp3Adapter
 * JD-Core Version:    0.6.2
 */