package com.allinone.free.adapter;

import android.content.Context;
import android.text.format.Formatter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.allinone.free.model.VideoModel;
import java.util.List;

public class VideodownloadAdapter extends BaseAdapter
{
  Context ctx;
  private List<VideoModel> list;

  public VideodownloadAdapter(Context paramContext, List<VideoModel> paramList)
  {
    this.ctx = paramContext;
    this.list = paramList;
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
    VideoModel localVideoModel = (VideoModel)this.list.get(paramInt);
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ViewHolder();
      paramView = View.inflate(this.ctx, 2130903139, null);
      localViewHolder.tv_format = ((TextView)paramView.findViewById(2131231068));
      localViewHolder.tv_type = ((TextView)paramView.findViewById(2131231069));
      localViewHolder.tv_size = ((TextView)paramView.findViewById(2131231070));
      paramView.setTag(localViewHolder);
    }
    while (true)
    {
      localViewHolder.tv_format.setText(localVideoModel.getVideo_item_format() + " " + "/" + " ");
      localViewHolder.tv_type.setText(localVideoModel.getVideo_item_type());
      try
      {
        String str = Formatter.formatFileSize(this.ctx, Long.parseLong(localVideoModel.getVideo_item_size()));
        Log.v("size", localVideoModel.getVideo_item_size());
        if ((!localVideoModel.getVideo_item_size().equals("-1")) && (!localVideoModel.getVideo_item_size().equals("0")))
          localViewHolder.tv_size.setText("Size: " + str);
        return paramView;
        localViewHolder = (ViewHolder)paramView.getTag();
      }
      catch (Exception localException)
      {
      }
    }
    return paramView;
  }

  class ViewHolder
  {
    TextView tv_format;
    TextView tv_size;
    TextView tv_type;

    ViewHolder()
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.adapter.VideodownloadAdapter
 * JD-Core Version:    0.6.2
 */