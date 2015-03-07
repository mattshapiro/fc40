package com.allinone.free.mydownload;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import net.tsz.afinal.http.AjaxCallBack;

public class DownloadTask
  implements ContentValue
{
  private boolean comeDb;
  private FinalDBChen db;
  private DownloadMovieItem down;
  private DownloadFile downloadFile;
  BroadcastReceiver downloadingbBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      String str1 = paramAnonymousIntent.getStringExtra("type");
      Log.v("mjmj", "*******" + str1);
      if (str1.equals("pause"))
        if (DownloadTask.this.mc != null)
        {
          Button localButton2 = (Button)DownloadTask.this.view.findViewById(2131230959);
          DownloadTask.this.down.getDownloadFile().stopDownload();
          if (localButton2 != null)
            localButton2.setBackgroundResource(2130837755);
          DownloadTask.this.mc.clickState = true;
        }
      do
      {
        return;
        if (str1.equals("resume"))
        {
          Button localButton1 = (Button)DownloadTask.this.view.findViewById(2131230959);
          TextView localTextView = (TextView)DownloadTask.this.view.findViewById(2131230958);
          if (localButton1 != null)
          {
            localButton1.setBackgroundResource(2130837755);
            localButton1.setVisibility(4);
            localTextView.setTextColor(Color.parseColor("#cccccc"));
            localTextView.setText(DownloadTask.this.mContext.getString(2131099697));
          }
          String str2 = DownloadTask.this.down.getDownloadUrl();
          String str3 = DownloadTask.this.down.getFilePath();
          DownloadTask.this.down.setDownloadFile(new DownloadFile().startDownloadFileByUrl(str2, str3, new DownloadTask.CallBackFuc(DownloadTask.this, DownloadTask.this.view, DownloadTask.this.down)));
          return;
        }
      }
      while (!str1.equals("delete"));
      DownloadTask.this.onDeleteTaskListener.onDelete(DownloadTask.this.view, DownloadTask.this.down, Boolean.valueOf(true));
    }
  };
  private Context mContext;
  private MyOnClick mc;
  private OnDeleteTaskListener onDeleteTaskListener;
  private int screenWidth;
  private View view;

  public DownloadTask(Context paramContext, View paramView, DownloadMovieItem paramDownloadMovieItem, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.view = paramView;
    this.down = paramDownloadMovieItem;
    this.comeDb = paramBoolean;
    ((ImageView)paramView.findViewById(2131230952)).setOnClickListener(new DeleteClick());
    this.db = new FinalDBChen(paramContext, paramContext.getDatabasePath("download.db").getAbsolutePath());
    gotoDownload(paramDownloadMovieItem, paramView);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("downloadingbBroadcastReceiver");
    paramContext.registerReceiver(this.downloadingbBroadcastReceiver, localIntentFilter);
  }

  public OnDeleteTaskListener getOnDeleteTaskListener()
  {
    return this.onDeleteTaskListener;
  }

  public void gotoDownload(DownloadMovieItem paramDownloadMovieItem, View paramView)
  {
    String str1 = paramDownloadMovieItem.getDownloadUrl();
    String str2 = paramDownloadMovieItem.getFilePath();
    if (this.comeDb)
    {
      Button localButton = (Button)paramView.findViewById(2131230959);
      localButton.setBackgroundResource(2130837755);
      localButton.setOnClickListener(new MyOnClick(13, paramDownloadMovieItem, localButton));
      return;
    }
    this.downloadFile = new DownloadFile().startDownloadFileByUrl(str1, str2, new CallBackFuc(paramView, paramDownloadMovieItem));
    paramDownloadMovieItem.setDownloadFile(this.downloadFile);
  }

  public Boolean is_valid_file(String paramString1, String paramString2)
  {
    Log.v("erer", "111111" + paramString1 + "2222222" + paramString2);
    double d1 = 0.0D;
    try
    {
      if ((!paramString1.equals("")) && (paramString1 != null))
        if (paramString1.contains("MB"))
        {
          double d2 = Double.parseDouble(paramString1.replace("MB", "").trim());
          d1 = d2 * 1024.0D;
        }
      label80: 
      while (d1 < 2.0D)
      {
        Log.v("abcd", "小于2kb");
        return Boolean.valueOf(false);
        d1 = Double.parseDouble(paramString1.replace("KB", "").trim());
        Log.v("abcd", "file_size===" + d1);
        continue;
        Boolean localBoolean = Boolean.valueOf(false);
        return localBoolean;
      }
      if (d1 < 200.0D)
      {
        Object localObject = "";
        try
        {
          String str = readFile(paramString2);
          localObject = str;
          Matcher localMatcher = Pattern.compile("</([a-zA-Z]{2,5})>").matcher((CharSequence)localObject);
          Log.v("ffff", "content===" + (String)localObject + "******" + "m.find()" + localMatcher.find());
          if ((!((String)localObject).equals("")) && (!localMatcher.find()))
            break label285;
          Log.v("abcd", "小于200kb");
          return Boolean.valueOf(false);
        }
        catch (Exception localException2)
        {
          while (true)
            localException2.printStackTrace();
        }
      }
      else
      {
        Log.v("abcd", "文件有效");
      }
      label285: return Boolean.valueOf(true);
    }
    catch (Exception localException1)
    {
      break label80;
    }
  }

  public String readFile(String paramString)
    throws IOException
  {
    String str = "";
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString));
      byte[] arrayOfByte = new byte[1024];
      localFileInputStream.read(arrayOfByte);
      str = arrayOfByte.toString();
      localFileInputStream.close();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return str;
  }

  public void setOnDeleteTaskListener(OnDeleteTaskListener paramOnDeleteTaskListener)
  {
    this.onDeleteTaskListener = paramOnDeleteTaskListener;
  }

  class CallBackFuc extends AjaxCallBack<File>
  {
    private int cu;
    private TextView current_progress;
    private DownloadMovieItem down;
    private TextView kb;
    private TextView movie_name_item;
    private ProgressBar p;
    private Button stop_download_bt;
    private TextView totalSize;
    private View view;

    public CallBackFuc(View paramDownloadMovieItem, DownloadMovieItem arg3)
    {
      DownloadMovieItem localDownloadMovieItem;
      this.down = localDownloadMovieItem;
      this.view = paramDownloadMovieItem;
      if (paramDownloadMovieItem != null)
      {
        this.p = ((ProgressBar)paramDownloadMovieItem.findViewById(2131230956));
        DownloadTask.this.screenWidth = DownloadTask.this.mContext.getResources().getDisplayMetrics().widthPixels;
        if (DownloadTask.this.screenWidth < 500)
        {
          ViewGroup.LayoutParams localLayoutParams = this.p.getLayoutParams();
          localLayoutParams.width = 186;
          this.p.setLayoutParams(localLayoutParams);
        }
        this.kb = ((TextView)paramDownloadMovieItem.findViewById(2131230957));
        this.totalSize = ((TextView)paramDownloadMovieItem.findViewById(2131230955));
        this.stop_download_bt = ((Button)paramDownloadMovieItem.findViewById(2131230959));
        this.stop_download_bt.setBackgroundResource(2130837754);
        this.current_progress = ((TextView)paramDownloadMovieItem.findViewById(2131230958));
        this.movie_name_item = ((TextView)paramDownloadMovieItem.findViewById(2131230954));
        this.stop_download_bt.setVisibility(4);
        this.stop_download_bt.setBackgroundResource(2130837754);
        this.movie_name_item.setText(localDownloadMovieItem.getMovieName());
        this.current_progress.setTextColor(Color.parseColor("#cccccc"));
        this.current_progress.setText(DownloadTask.this.mContext.getString(2131099697));
        DownloadTask.this.mc = new DownloadTask.MyOnClick(DownloadTask.this, 7, localDownloadMovieItem, this.stop_download_bt);
        DownloadTask.this.mc.setCurrent_progress(this.current_progress);
        this.stop_download_bt.setOnClickListener(DownloadTask.this.mc);
      }
    }

    public void onFailure(Throwable paramThrowable, String paramString)
    {
      Log.v("wewe", "aaaaaaa" + paramString + "bbbbb" + paramThrowable);
      if (TextUtils.isEmpty(this.down.getFileSize()))
        this.down.setFileSize("0.0B");
      this.down.setDownloadState(Integer.valueOf(5));
      FinalDBChen localFinalDBChen = DownloadTask.this.db;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.down.getMovieName();
      localFinalDBChen.updateValuesByJavaBean("downloadtask", "movieName=?", arrayOfString, this.down);
      if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("416")))
      {
        Intent localIntent2 = new Intent();
        localIntent2.putExtra("downloadType", 6);
        localIntent2.setAction("downloadType");
        ((MyApplcation)DownloadTask.this.mContext.getApplicationContext()).setDownloadSuccess(this.down);
        DownloadTask.this.mContext.sendBroadcast(localIntent2);
        String str = Formatter.formatFileSize(DownloadTask.this.mContext, new File(this.down.getFilePath()).length());
        if (this.view != null)
        {
          this.kb.setVisibility(4);
          this.totalSize.setText(str);
          this.current_progress.setText(DownloadTask.this.mContext.getString(2131099701));
          this.p.setMax(100);
          this.p.setProgress(100);
          this.stop_download_bt.setVisibility(0);
          this.stop_download_bt.setBackgroundResource(2130837755);
          this.stop_download_bt.setOnClickListener(new DownloadTask.MyOnClick(DownloadTask.this, 6, this.down, this.stop_download_bt));
        }
        return;
      }
      if (this.view != null)
      {
        this.kb.setVisibility(4);
        if (this.stop_download_bt.getVisibility() == 4)
          this.stop_download_bt.setVisibility(0);
        this.stop_download_bt.setBackgroundResource(2130837621);
        this.stop_download_bt.setText(DownloadTask.this.mContext.getString(2131099702));
        this.stop_download_bt.setTextColor(Color.parseColor("#333333"));
        this.current_progress.setTextColor(Color.parseColor("#f39801"));
        this.current_progress.setText(DownloadTask.this.mContext.getString(2131099703));
        DownloadTask.MyOnClick localMyOnClick = new DownloadTask.MyOnClick(DownloadTask.this, 5, this.down, this.stop_download_bt);
        localMyOnClick.setCurrent_progress(this.current_progress);
        this.stop_download_bt.setOnClickListener(localMyOnClick);
        Intent localIntent1 = new Intent();
        localIntent1.putExtra("downloadType", 5);
        localIntent1.setAction("downloadType");
        ((MyApplcation)DownloadTask.this.mContext.getApplicationContext()).setDownloadSuccess(this.down);
        DownloadTask.this.mContext.sendBroadcast(localIntent1);
      }
      Toast.makeText(DownloadTask.this.mContext, "Failed to download '" + this.down.getMovieName() + "'. Please try again.", 0).show();
    }

    public void onLoading(long paramLong1, long paramLong2)
    {
      boolean bool = paramLong2 < this.cu;
      int i = 0;
      if (bool)
      {
        i = (int)(paramLong2 - this.cu);
        this.cu = ((int)paramLong2);
      }
      String str1 = Formatter.formatFileSize(DownloadTask.this.mContext, i) + "/s";
      int j = (int)(100L * paramLong2 / paramLong1);
      if (this.view != null)
      {
        String str2 = Formatter.formatFileSize(DownloadTask.this.mContext, paramLong2);
        this.current_progress.setText(j + "%");
        this.down.setPercentage(j + "%");
        this.down.setProgressCount(Long.valueOf(paramLong1));
        this.down.setCurrentProgress(Long.valueOf(paramLong2));
        String str3 = Formatter.formatFileSize(DownloadTask.this.mContext, paramLong1);
        this.down.setFileSize(str3);
        this.totalSize.setText(str2 + "/" + str3);
        this.kb.setText(str1);
        if (this.kb.getVisibility() == 4)
          this.kb.setVisibility(0);
        this.p.setMax((int)paramLong1);
        this.p.setProgress((int)paramLong2);
        if (this.stop_download_bt.getVisibility() == 4)
        {
          this.stop_download_bt.setVisibility(0);
          this.stop_download_bt.setText("");
          this.stop_download_bt.setBackgroundResource(2130837754);
        }
        this.down.setDownloadState(Integer.valueOf(2));
        FinalDBChen localFinalDBChen = DownloadTask.this.db;
        String[] arrayOfString = new String[1];
        arrayOfString[0] = this.down.getMovieName();
        localFinalDBChen.updateValuesByJavaBean("downloadtask", "movieName=?", arrayOfString, this.down);
      }
    }

    public void onStart()
    {
      this.down.setDownloadState(Integer.valueOf(7));
      FinalDBChen localFinalDBChen = DownloadTask.this.db;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.down.getMovieName();
      localFinalDBChen.updateValuesByJavaBean("downloadtask", "movieName=?", arrayOfString, this.down);
      Intent localIntent = new Intent();
      localIntent.putExtra("downloadType", 7);
      localIntent.setAction("downloadType");
      ((MyApplcation)DownloadTask.this.mContext.getApplicationContext()).setDownloadSuccess(this.down);
      DownloadTask.this.mContext.sendBroadcast(localIntent);
      super.onStart();
    }

    public void onSuccess(File paramFile)
    {
      if (this.view != null)
      {
        this.kb.setVisibility(4);
        this.current_progress.setText(DownloadTask.this.mContext.getString(2131099701));
        this.stop_download_bt.setBackgroundResource(2130837755);
        this.stop_download_bt.setOnClickListener(new DownloadTask.MyOnClick(DownloadTask.this, 6, this.down, this.stop_download_bt));
      }
      this.down.setDownloadState(Integer.valueOf(6));
      FinalDBChen localFinalDBChen = DownloadTask.this.db;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.down.getMovieName();
      localFinalDBChen.updateValuesByJavaBean("downloadtask", "movieName=?", arrayOfString, this.down);
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("downloadType", 6);
      localIntent1.setAction("downloadType");
      Myutils.getInstance();
      Myutils.successItem = this.down;
      Log.v("erer", "11111111" + this.down.getType() + this.down.getFile_id());
      MyApplcation localMyApplcation = (MyApplcation)DownloadTask.this.mContext.getApplicationContext();
      localIntent1.setAction("successful");
      Intent localIntent2 = new Intent();
      if (this.down.getType().equals("mp3"))
      {
        Log.v("erer", "2222222222");
        localIntent2.setAction("mp3successful");
      }
      while (true)
      {
        LinearLayout localLinearLayout;
        if (DownloadTask.this.is_valid_file(this.down.getFileSize(), this.down.getFilePath()).booleanValue())
        {
          localMyApplcation.setDownloadSuccess(this.down);
          localLinearLayout = (LinearLayout)this.view.getParent();
        }
        try
        {
          localLinearLayout.removeView(this.view);
          label324: DownloadTask.this.mContext.sendBroadcast(localIntent1);
          DownloadTask.this.mContext.sendBroadcast(localIntent2);
          if (this.down.getType().equals("app"))
          {
            Intent localIntent3 = new Intent("android.intent.action.VIEW");
            localIntent3.setDataAndType(Uri.parse("file://" + this.down.getFilePath()), "application/vnd.android.package-archive");
            DownloadTask.this.mContext.startActivity(localIntent3);
            Intent localIntent4 = new Intent();
            localIntent4.setAction("jingmoanzhuang");
            DownloadTask.this.mContext.sendBroadcast(localIntent4);
          }
          super.onSuccess(paramFile);
          return;
          if (this.down.getType().equals("ringtone"))
          {
            localIntent2.setAction("ringtonesuccessful");
            continue;
          }
          if (this.down.getType().equals("app"))
          {
            Log.v("erer", "33333333");
            localIntent2.setAction("appsuccessful");
            continue;
          }
          if (!this.down.getType().equals("video"))
            continue;
          Log.v("erer", "33333333");
          localIntent2.setAction("videosuccessful");
          continue;
          Message localMessage = new Message();
          localMessage.what = 1212;
          localMessage.getData().putString("type", this.down.getType());
          localMessage.getData().putString("id", this.down.getFile_id());
          if (this.down.getType().equals("app"))
          {
            Myutils.getInstance();
            if (Myutils.type_current.equals("app_recent"))
              publicTools.app_recent_handler.sendMessage(localMessage);
          }
          while (true)
          {
            Log.v("hhh", this.down.getFile_id() + "*****" + this.down.getType());
            this.current_progress.setText("Invalid");
            this.current_progress.setTextColor(Color.parseColor("#f39801"));
            this.kb.setVisibility(0);
            this.kb.setText("0KB/s");
            break;
            if (this.down.getType().equals("app"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("app_popular"))
                publicTools.app_popular_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("mp3"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("mp3_recent"))
                publicTools.mp3_recent_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("mp3"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("mp3_popular"))
                publicTools.mp3_popular_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("ringtone"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("ringtone_recent"))
                publicTools.ringtone_recent_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("ringtone"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("ringtone_popular"))
                publicTools.ringtone_popular_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("app"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("app_search"))
                publicTools.app_search_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("mp3"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("mp3_search"))
                publicTools.mp3_search_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("ringtone"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("ringtone_search"))
                publicTools.ringtone_search_handler.sendMessage(localMessage);
            }
            else if (this.down.getType().equals("app"))
            {
              Myutils.getInstance();
              if (Myutils.type_current.equals("popularapk"))
                publicTools.popular_handler.sendMessage(localMessage);
            }
          }
        }
        catch (Exception localException)
        {
          break label324;
        }
      }
    }
  }

  class DeleteClick
    implements View.OnClickListener
  {
    DeleteClick()
    {
    }

    public void onClick(View paramView)
    {
      if (DownloadTask.this.onDeleteTaskListener != null)
        DownloadTask.this.onDeleteTaskListener.onDelete(DownloadTask.this.view, DownloadTask.this.down, Boolean.valueOf(false));
    }
  }

  public class MyOnClick
    implements View.OnClickListener
  {
    private Button button;
    public boolean clickState = false;
    private TextView current_progress;
    private DownloadMovieItem downItem;
    public int state;

    public MyOnClick(int paramDownloadMovieItem, DownloadMovieItem paramButton, Button arg4)
    {
      this.state = paramDownloadMovieItem;
      this.downItem = paramButton;
      Object localObject;
      this.button = localObject;
    }

    public TextView getCurrent_progress()
    {
      return this.current_progress;
    }

    public void onClick(View paramView)
    {
      String str1 = this.downItem.getMovieName();
      switch (this.state)
      {
      case 6:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      default:
        return;
      case 5:
        Toast.makeText(DownloadTask.this.mContext, "'" + str1 + "' resumes downloading.", 0).show();
        this.button.setVisibility(4);
        this.current_progress.setTextColor(Color.parseColor("#cccccc"));
        this.current_progress.setText("Waiting in queue");
        DownloadTask.this.gotoDownload(DownloadTask.this.down, DownloadTask.this.view);
        return;
      case 7:
        if (this.clickState)
        {
          DownloadTask.this.gotoDownload(DownloadTask.this.down, DownloadTask.this.view);
          Toast.makeText(DownloadTask.this.mContext, "'" + str1 + "' starts downloading.", 0).show();
          if (this.button != null)
          {
            this.button.setVisibility(4);
            this.current_progress.setTextColor(Color.parseColor("#cccccc"));
            this.current_progress.setText(DownloadTask.this.mContext.getString(2131099697));
          }
          this.clickState = false;
          return;
        }
        DownloadTask.this.down.getDownloadFile().stopDownload();
        Toast.makeText(DownloadTask.this.mContext, "'" + str1 + "' is paused.", 0).show();
        if (this.button != null)
          this.button.setBackgroundResource(2130837755);
        this.clickState = true;
        return;
      case 13:
      }
      String str2 = DownloadTask.this.down.getDownloadUrl();
      String str3 = DownloadTask.this.down.getFilePath();
      DownloadTask.this.down.setDownloadFile(new DownloadFile().startDownloadFileByUrl(str2, str3, new DownloadTask.CallBackFuc(DownloadTask.this, DownloadTask.this.view, DownloadTask.this.down)));
    }

    public void setCurrent_progress(TextView paramTextView)
    {
      this.current_progress = paramTextView;
    }
  }

  public static abstract interface OnDeleteTaskListener
  {
    public abstract void onDelete(View paramView, DownloadMovieItem paramDownloadMovieItem, Boolean paramBoolean);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.mydownload.DownloadTask
 * JD-Core Version:    0.6.2
 */