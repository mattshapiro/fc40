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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.publicTools;
import java.util.ArrayList;
import java.util.List;

public class Mp3searchFragmentAdapter extends BaseAdapter
{
  private MyApplcation app;
  private Context ctx;
  private List<DownloadMovieItem> list;

  public Mp3searchFragmentAdapter(Context paramContext, List<DownloadMovieItem> paramList)
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
      paramView = View.inflate(this.ctx, 2130903107, null);
      localViewHolder.mp3icon = ((ImageView)paramView.findViewById(2131230920));
      localViewHolder.mp3title = ((TextView)paramView.findViewById(2131230974));
      localViewHolder.mp3album_title = ((TextView)paramView.findViewById(2131230975));
      localViewHolder.mp3artist_title = ((TextView)paramView.findViewById(2131230976));
      localViewHolder.mp3size = ((TextView)paramView.findViewById(2131230977));
      localViewHolder.mp3_download_bt = ((Button)paramView.findViewById(2131230978));
      localViewHolder.list_bg = ((RelativeLayout)paramView.findViewById(2131230973));
      paramView.setTag(localViewHolder);
    }
    while (true)
    {
      int i = -1;
      try
      {
        int j = this.ctx.getSharedPreferences("mp3_search_data", 0).getInt("mp3_search_selector", -1);
        i = j;
        label171: if (i == paramInt)
          localViewHolder.list_bg.setBackgroundResource(2130837686);
        while (true)
        {
          localViewHolder.mp3title.setText(localDownloadMovieItem.getTitle());
          localViewHolder.mp3album_title.setText(localDownloadMovieItem.getAlbum_title());
          localViewHolder.mp3artist_title.setText(localDownloadMovieItem.getArtist_title());
          localViewHolder.mp3size.setText(localDownloadMovieItem.getSize());
          localViewHolder.mp3_download_bt.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              new Thread(new Runnable()
              {
                public void run()
                {
                  publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=mp3&id=" + this.val$in_fo.getId() + "&title=" + this.val$in_fo.getTitle() + "&album_title=" + this.val$in_fo.getAlbum_title() + "&artist_title=" + this.val$in_fo.getArtist_title() + "&size=" + this.val$in_fo.getSize());
                }
              }).start();
              Message localMessage = new Message();
              localMessage.what = 880;
              localMessage.getData().putString("mp3id", localDownloadMovieItem.getId());
              localMessage.getData().putString("mp3title", localDownloadMovieItem.getTitle());
              publicTools.mp3searchhandler.sendMessage(localMessage);
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
        break label171;
      }
    }
  }

  class ViewHolder
  {
    private RelativeLayout list_bg;
    private Button mp3_download_bt;
    private TextView mp3album_title;
    private TextView mp3artist_title;
    private ImageView mp3icon;
    private TextView mp3size;
    private TextView mp3title;

    ViewHolder()
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.adapter.Mp3searchFragmentAdapter
 * JD-Core Version:    0.6.2
 */