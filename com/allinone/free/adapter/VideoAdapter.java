package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.allinone.free.activity.VideoViewActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import java.util.List;

public class VideoAdapter extends BaseAdapter
{
  private MyApplcation app;
  Context ctx;
  private ViewHolder holder = null;
  private List<DownloadMovieItem> list;

  public VideoAdapter(Context paramContext, List<DownloadMovieItem> paramList)
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
    if (paramView == null)
    {
      this.holder = new ViewHolder();
      paramView = View.inflate(this.ctx, 2130903140, null);
      this.holder.my_delete_movie = ((ImageView)paramView.findViewById(2131231073));
      this.holder.my_test_head_image = ((ImageView)paramView.findViewById(2131231074));
      this.holder.my_movie_name_item = ((TextView)paramView.findViewById(2131231075));
      this.holder.my_totalsize = ((TextView)paramView.findViewById(2131231076));
      this.holder.my_stop_download_bt = ((Button)paramView.findViewById(2131231077));
      paramView.setTag(this.holder);
    }
    while (true)
    {
      this.holder.my_totalsize.setText(localDownloadMovieItem.getFileSize());
      this.holder.my_movie_name_item.setText(localDownloadMovieItem.getMovieName());
      this.app.asyncLoadImage(localDownloadMovieItem.getMovieHeadImagePath(), this.holder.my_test_head_image);
      this.holder.my_stop_download_bt.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent(VideoAdapter.this.ctx, VideoViewActivity.class);
          localIntent.putExtra("playurl", localDownloadMovieItem.getFilePath());
          VideoAdapter.this.ctx.startActivity(localIntent);
        }
      });
      this.holder.my_delete_movie.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("videodelete");
          localIntent.putExtra("position", paramInt);
          VideoAdapter.this.ctx.sendBroadcast(localIntent);
        }
      });
      return paramView;
      this.holder = ((ViewHolder)paramView.getTag());
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
 * Qualified Name:     com.allinone.free.adapter.VideoAdapter
 * JD-Core Version:    0.6.2
 */