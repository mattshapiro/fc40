package com.allinone.free.adapter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import java.util.List;

public class RingtoneAdapter extends BaseAdapter
  implements View.OnClickListener
{
  private MyApplcation app;
  Context ctx;
  boolean isAlarm = false;
  boolean isMusic = false;
  boolean isNotification = false;
  boolean isRingtone = false;
  private LinearLayout l1;
  private LinearLayout l2;
  private LinearLayout l3;
  private LinearLayout l4;
  private List<DownloadMovieItem> list;
  private PopupWindow mWindow;
  LinearLayout mystandard;
  private String new_file_path;
  private RelativeLayout popodismiss;
  SharedPreferences sp = null;
  private View view;

  public RingtoneAdapter(Context paramContext, List<DownloadMovieItem> paramList)
  {
    this.ctx = paramContext;
    this.list = paramList;
    this.app = ((MyApplcation)paramContext.getApplicationContext());
    this.sp = paramContext.getSharedPreferences("data", 0);
  }

  private void initPopuWindow1(View paramView)
  {
    if (this.mWindow == null)
    {
      this.view = LayoutInflater.from(this.ctx).inflate(2130903125, null);
      this.mWindow = new PopupWindow(this.view, -1, -1);
      this.l1 = ((LinearLayout)this.view.findViewById(2131230736));
      this.l2 = ((LinearLayout)this.view.findViewById(2131231036));
      this.l3 = ((LinearLayout)this.view.findViewById(2131231037));
      this.l4 = ((LinearLayout)this.view.findViewById(2131231038));
      this.popodismiss = ((RelativeLayout)this.view.findViewById(2131231035));
    }
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    this.mWindow.setBackgroundDrawable(localColorDrawable);
    WindowManager.LayoutParams localLayoutParams = ((Activity)this.ctx).getWindow().getAttributes();
    localLayoutParams.alpha = 0.1F;
    ((Activity)this.ctx).getWindow().setAttributes(localLayoutParams);
    this.mWindow.setOutsideTouchable(true);
    this.mWindow.setFocusable(true);
    this.mWindow.showAtLocation((View)paramView.getParent(), 17, 0, 0);
    this.mWindow.update();
    this.mWindow.setOnDismissListener(new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        WindowManager.LayoutParams localLayoutParams = ((Activity)RingtoneAdapter.this.ctx).getWindow().getAttributes();
        localLayoutParams.alpha = 1.0F;
        ((Activity)RingtoneAdapter.this.ctx).getWindow().setAttributes(localLayoutParams);
      }
    });
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
    Log.v("position", "position=======" + paramInt);
    ViewHolder localViewHolder;
    if (paramView == null)
    {
      localViewHolder = new ViewHolder();
      paramView = View.inflate(this.ctx, 2130903122, null);
      localViewHolder.my_delete_movie = ((ImageView)paramView.findViewById(2131231021));
      localViewHolder.my_test_head_image = ((ImageView)paramView.findViewById(2131231022));
      localViewHolder.my_movie_name_item = ((TextView)paramView.findViewById(2131231023));
      localViewHolder.my_totalsize = ((TextView)paramView.findViewById(2131231024));
      localViewHolder.my_stop_download_bt = ((Button)paramView.findViewById(2131231025));
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
          RingtoneAdapter.this.initPopuWindow1(paramAnonymousView);
          RingtoneAdapter.this.new_file_path = (Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "ringtone/" + localDownloadMovieItem.getFile_id() + ".mp3");
          publicTools.make_path_ready(Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "ringtone");
          try
          {
            publicTools.copyFile(localDownloadMovieItem.getFilePath(), RingtoneAdapter.this.new_file_path);
            RingtoneAdapter.this.sp.edit().putString("movivename", localDownloadMovieItem.getMovieName()).commit();
            RingtoneAdapter.this.l1.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                RingtoneAdapter.this.setRingtone(7, RingtoneAdapter.this.new_file_path);
                RingtoneAdapter.this.mWindow.dismiss();
              }
            });
            RingtoneAdapter.this.l2.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                RingtoneAdapter.this.setRingtone(1, RingtoneAdapter.this.new_file_path);
                RingtoneAdapter.this.mWindow.dismiss();
              }
            });
            RingtoneAdapter.this.l3.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                RingtoneAdapter.this.setRingtone(2, RingtoneAdapter.this.new_file_path);
                RingtoneAdapter.this.mWindow.dismiss();
              }
            });
            RingtoneAdapter.this.l4.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                RingtoneAdapter.this.setRingtone(4, RingtoneAdapter.this.new_file_path);
                RingtoneAdapter.this.mWindow.dismiss();
              }
            });
            RingtoneAdapter.this.popodismiss.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                RingtoneAdapter.this.mWindow.dismiss();
              }
            });
            return;
          }
          catch (Exception localException)
          {
            while (true)
              localException.printStackTrace();
          }
        }
      });
      localViewHolder.my_delete_movie.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("ringtonedelete");
          localIntent.putExtra("position", paramInt);
          RingtoneAdapter.this.ctx.sendBroadcast(localIntent);
        }
      });
      localViewHolder.my_test_head_image.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Intent localIntent = new Intent();
          localIntent.setAction("ringtoneplay");
          localIntent.putExtra("ringtoneposition", localDownloadMovieItem.getFilePath());
          localIntent.putExtra("ringtonepositiontitle", localDownloadMovieItem.getMovieName());
          Log.v("ringtoneposition", localDownloadMovieItem.getFilePath());
          RingtoneAdapter.this.ctx.sendBroadcast(localIntent);
        }
      });
      return paramView;
      localViewHolder = (ViewHolder)paramView.getTag();
    }
  }

  public void onClick(View paramView)
  {
  }

  public void setRingtone(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 3:
    case 5:
    case 6:
    default:
    case 1:
    case 2:
    case 4:
    case 7:
    }
    while (true)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_data", paramString);
      localContentValues.put("title", this.sp.getString("movivename", "AAA"));
      localContentValues.put("mime_type", "audio/mp3");
      localContentValues.put("is_ringtone", Boolean.valueOf(this.isRingtone));
      localContentValues.put("is_notification", Boolean.valueOf(this.isNotification));
      localContentValues.put("is_alarm", Boolean.valueOf(this.isAlarm));
      localContentValues.put("is_music", Boolean.valueOf(this.isMusic));
      Uri localUri1 = MediaStore.Audio.Media.getContentUriForPath(paramString);
      this.ctx.getContentResolver().delete(localUri1, "_data=\"" + this.new_file_path + "\"", null);
      Uri localUri2 = this.ctx.getContentResolver().insert(localUri1, localContentValues);
      RingtoneManager.setActualDefaultRingtoneUri(this.ctx, paramInt, localUri2);
      Log.v("ringType", paramInt);
      return;
      this.isRingtone = true;
      continue;
      this.isNotification = true;
      continue;
      this.isAlarm = true;
      continue;
      this.isMusic = true;
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
 * Qualified Name:     com.allinone.free.adapter.RingtoneAdapter
 * JD-Core Version:    0.6.2
 */