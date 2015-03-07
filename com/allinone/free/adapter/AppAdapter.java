package com.allinone.free.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
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

public class AppAdapter extends BaseAdapter
{
  private MyApplcation app;
  Context ctx;
  private ViewHolder holder = null;
  private List<DownloadMovieItem> list;

  public AppAdapter(Context paramContext, List<DownloadMovieItem> paramList)
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
      paramView = View.inflate(this.ctx, 2130903072, null);
      this.holder.my_delete_movie = ((ImageView)paramView.findViewById(2131230843));
      this.holder.my_test_head_image = ((ImageView)paramView.findViewById(2131230844));
      this.holder.my_movie_name_item = ((TextView)paramView.findViewById(2131230845));
      this.holder.my_totalsize = ((TextView)paramView.findViewById(2131230846));
      this.holder.my_stop_download_bt = ((Button)paramView.findViewById(2131230847));
      paramView.setTag(this.holder);
    }
    while (true)
    {
      this.holder.my_totalsize.setText(localDownloadMovieItem.getFileSize());
      this.holder.my_movie_name_item.setText(localDownloadMovieItem.getMovieName());
      this.app.asyncLoadImage(localDownloadMovieItem.getMovieHeadImagePath(), this.holder.my_test_head_image);
      try
      {
        if (this.ctx.getPackageManager().getPackageInfo(localDownloadMovieItem.getFile_id(), 0) != null)
        {
          this.holder.my_stop_download_bt.setBackgroundResource(2130837729);
          this.holder.my_stop_download_bt.setText("Open");
          Log.v("uiui", "有包名");
        }
        while (true)
        {
          this.holder.my_stop_download_bt.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              if (AppAdapter.this.holder.my_stop_download_bt.getText().equals("Open"));
              try
              {
                Intent localIntent2 = AppAdapter.this.ctx.getPackageManager().getLaunchIntentForPackage(localDownloadMovieItem.getFile_id());
                AppAdapter.this.ctx.startActivity(localIntent2);
                return;
                Intent localIntent1 = new Intent("android.intent.action.VIEW");
                localIntent1.setDataAndType(Uri.parse("file://" + localDownloadMovieItem.getFilePath()), "application/vnd.android.package-archive");
                AppAdapter.this.ctx.startActivity(localIntent1);
                return;
              }
              catch (Exception localException)
              {
              }
            }
          });
          this.holder.my_delete_movie.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              Intent localIntent = new Intent();
              localIntent.setAction("delete");
              localIntent.putExtra("position", paramInt);
              AppAdapter.this.ctx.sendBroadcast(localIntent);
            }
          });
          return paramView;
          this.holder = ((ViewHolder)paramView.getTag());
          break;
          this.holder.my_stop_download_bt.setBackgroundResource(2130837675);
          this.holder.my_stop_download_bt.setText("Install");
          Log.v("uiui", "没有包名");
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (true)
          localNameNotFoundException.printStackTrace();
      }
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
 * Qualified Name:     com.allinone.free.adapter.AppAdapter
 * JD-Core Version:    0.6.2
 */