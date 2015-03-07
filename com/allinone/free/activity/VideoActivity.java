package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.adapter.VideodownloadAdapter;
import com.allinone.free.dialog.ErrorDialog;
import com.allinone.free.dialog.RestaryDownloadDialog;
import com.allinone.free.dialog.VideoDownloadDialog;
import com.allinone.free.model.VideoModel;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoActivity extends BaseActivity
  implements View.OnClickListener
{
  private static Typeface typeFace = null;
  private AdView adView;
  private VideodownloadAdapter adapter;
  private MyApplcation app;
  private String banner_type_name;
  private FinalDBChen db;
  private ImageView fan;
  Handler hander = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
        VideoActivity.this.videodownloader.setVisibility(0);
        VideoActivity.this.videodownloader2.setVisibility(8);
        VideoActivity.this.tvloading.setVisibility(8);
        VideoActivity.this.progressWheel.setVisibility(8);
        return;
      case 2:
        VideoActivity.this.videodownloader2.setVisibility(0);
        VideoActivity.this.videodownloader.setVisibility(8);
        return;
      case 3:
      }
      VideoActivity.this.adapter.notifyDataSetChanged();
    }
  };
  private LinearLayout lieshow;
  private VideoModel model;
  private ImageView mychafan;
  private ImageView net_hint_img_list;
  private ProgressWheel progressWheel = null;
  private SharedPreferences sp_config = null;
  private TextView tvloading;
  private ImageView video_download_img;
  private ListView video_download_item_listview;
  private String video_home_url = "http://m.youtube.com/";
  private String video_info_url = "";
  private TextView video_title;
  private LinearLayout videobanner;
  private Button videodownloader;
  private Button videodownloader2;
  private RelativeLayout videojianpan;
  private Button videoreload;
  private TextView videotitle;
  private WebView videowebview;
  private Mywebview webviewclient;

  private void Bottom2()
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.lieshow.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 0);
    this.lieshow.setLayoutParams(localLayoutParams);
  }

  private void Error_dialog()
  {
    final ErrorDialog localErrorDialog = new ErrorDialog(this, 2131165279);
    localErrorDialog.setCanceledOnTouchOutside(false);
    localErrorDialog.show();
    ((Button)localErrorDialog.findViewById(2131230753)).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localErrorDialog.dismiss();
      }
    });
  }

  private void Mydialog()
  {
    new AlertDialog.Builder(this).setTitle(getString(2131099715)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).show();
  }

  private void Mywebview1()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.videowebview.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, DisplayUtil.dip2px(this, 88.0F));
    this.videowebview.setLayoutParams(localLayoutParams);
  }

  private void Mywebview2()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.videowebview.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, DisplayUtil.dip2px(this, 38.0F));
    this.videowebview.setLayoutParams(localLayoutParams);
  }

  private void buildListener()
  {
    this.fan.setOnClickListener(this);
    this.mychafan.setOnClickListener(this);
    this.videodownloader.setOnClickListener(this);
    this.videodownloader2.setOnClickListener(this);
    this.videoreload.setOnClickListener(this);
    this.videowebview.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 4) && (VideoActivity.this.videowebview.canGoBack()))
        {
          VideoActivity.this.videowebview.goBack();
          if (VideoActivity.this.videowebview.getUrl().contains("//m.youtube.com"))
          {
            if (VideoActivity.this.videowebview.getUrl().contains("v="))
            {
              Message localMessage1 = new Message();
              localMessage1.what = 1;
              VideoActivity.this.hander.sendMessage(localMessage1);
            }
          }
          else
            return true;
          Message localMessage2 = new Message();
          localMessage2.what = 2;
          VideoActivity.this.hander.sendMessage(localMessage2);
          return true;
        }
        return false;
      }
    });
  }

  private void dowload_video(final ArrayList<VideoModel> paramArrayList)
  {
    final VideoDownloadDialog localVideoDownloadDialog = new VideoDownloadDialog(this, 2131165279);
    localVideoDownloadDialog.setCanceledOnTouchOutside(false);
    if (paramArrayList.size() > 0)
    {
      localVideoDownloadDialog.show();
      this.video_download_img = ((ImageView)localVideoDownloadDialog.findViewById(2131231092));
      this.videotitle = ((TextView)localVideoDownloadDialog.findViewById(2131231093));
      this.video_download_item_listview = ((ListView)localVideoDownloadDialog.findViewById(2131231094));
      this.app.asyncLoadImage(this.model.getVideo_item_img(), this.video_download_img);
      this.videotitle.setText(this.model.getVideo_item_title());
      new Thread(new Runnable()
      {
        public void run()
        {
          int i = 0;
          while (true)
          {
            if (i >= paramArrayList.size())
              return;
            try
            {
              HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(((VideoModel)paramArrayList.get(i)).getVideo_item_url()).openConnection();
              localHttpURLConnection.setRequestProperty("Accept-Encoding", "identity");
              localHttpURLConnection.connect();
              String str = localHttpURLConnection.getContentLength();
              Log.v("sss", ((VideoModel)paramArrayList.get(i)).getVideo_item_url() + ":" + str);
              ((VideoModel)paramArrayList.get(i)).setVideo_item_size(str);
              Message localMessage = new Message();
              localMessage.what = 3;
              VideoActivity.this.hander.sendMessage(localMessage);
              i++;
            }
            catch (Exception localException)
            {
              while (true)
                localException.printStackTrace();
            }
          }
        }
      }).start();
      this.adapter = new VideodownloadAdapter(this, paramArrayList);
      this.video_download_item_listview.setAdapter(this.adapter);
      this.video_download_item_listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
        {
          try
          {
            VideoActivity.this.VideoDownload(((VideoModel)paramArrayList.get(paramAnonymousInt)).getVideo_item_id(), ((VideoModel)paramArrayList.get(paramAnonymousInt)).getVideo_item_title(), ((VideoModel)paramArrayList.get(paramAnonymousInt)).getVideo_item_url(), ((VideoModel)paramArrayList.get(paramAnonymousInt)).getVideo_item_img());
            new Thread(new Runnable()
            {
              public void run()
              {
                publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id=" + ((VideoModel)this.val$list.get(paramAnonymousInt)).getVideo_item_id());
              }
            }).start();
            localVideoDownloadDialog.dismiss();
            return;
          }
          catch (Exception localException)
          {
            while (true)
              localException.printStackTrace();
          }
        }
      });
    }
  }

  private void init()
  {
    this.videojianpan = ((RelativeLayout)findViewById(2131231080));
    this.sp_config = getSharedPreferences("banner_type", 0);
    this.fan = ((ImageView)findViewById(2131231081));
    this.tvloading = ((TextView)findViewById(2131231086));
    this.video_title = ((TextView)findViewById(2131231082));
    this.videowebview = ((WebView)findViewById(2131231085));
    this.mychafan = ((ImageView)findViewById(2131231083));
    this.videobanner = ((LinearLayout)findViewById(2131231091));
    this.progressWheel = ((ProgressWheel)findViewById(2131230812));
    this.net_hint_img_list = ((ImageView)findViewById(2131230950));
    this.net_hint_img_list.setVisibility(8);
    this.videodownloader = ((Button)findViewById(2131231088));
    this.videodownloader2 = ((Button)findViewById(2131231089));
    this.videoreload = ((Button)findViewById(2131231090));
    this.lieshow = ((LinearLayout)findViewById(2131231087));
    this.app = ((MyApplcation)getApplicationContext());
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.video_title.setTypeface(typeFace);
    this.banner_type_name = this.sp_config.getString("banner_type", "admob");
    if (this.banner_type_name.equals("admob"))
    {
      this.adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-1054623928013334/2194439000");
      this.videobanner.addView(this.adView);
      this.adView.loadAd(new AdRequest());
      Mywebview1();
      return;
    }
    Bottom2();
    Mywebview2();
  }

  public void VideoDownload(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
    if (this.db.findItemsByWhereAndWhereValue("file_id", paramString1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
    {
      Mydialog();
      return;
    }
    String str = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + getPackageName(), paramString1 + "." + this.model.getVideo_item_format()).getAbsolutePath();
    localDownloadMovieItem.setDownloadUrl(paramString3);
    Log.v("erer", paramString3);
    localDownloadMovieItem.setFilePath(str);
    localDownloadMovieItem.setDownloadState(Integer.valueOf(4));
    localDownloadMovieItem.setMovieName(paramString2);
    localDownloadMovieItem.setFile_id(paramString1);
    Log.v("sdsd", paramString3 + "********" + paramString1 + "*********" + paramString2 + "**********" + this.model.getVideo_item_format());
    localDownloadMovieItem.setMovieHeadImagePath(paramString4);
    localDownloadMovieItem.setType("video");
    localDownloadMovieItem.setCreate_time(Long.valueOf(System.currentTimeMillis()));
    toDownload(localDownloadMovieItem);
    Myutils.getInstance();
    Myutils.list.add(localDownloadMovieItem);
    Toast.makeText(getApplicationContext(), "'" + localDownloadMovieItem.getMovieName() + "' is added to download queue.", 0).show();
  }

  public void initView()
  {
    super.initView();
    new FinalDBChen(getmContext(), "download.db", new DownloadMovieItem(), "downloadtask", null);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131231081:
      do
      {
        return;
        if (!this.videowebview.canGoBack())
          break;
        this.videowebview.goBack();
      }
      while (!this.videowebview.getUrl().contains("//m.youtube.com"));
      if (this.videowebview.getUrl().contains("v="))
      {
        Message localMessage1 = new Message();
        localMessage1.what = 1;
        this.hander.sendMessage(localMessage1);
        return;
      }
      Message localMessage2 = new Message();
      localMessage2.what = 2;
      this.hander.sendMessage(localMessage2);
      return;
      finish();
      return;
    case 2131231083:
      finish();
      return;
    case 2131231088:
      new MyAsyncTask().execute(new Void[0]);
      return;
    case 2131231090:
    }
    this.videowebview.loadUrl(this.videowebview.getUrl());
  }

  @SuppressLint({"SetJavaScriptEnabled", "ResourceAsColor"})
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903142);
    this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
    initView();
    init();
    buildListener();
    this.videowebview.getSettings().setJavaScriptEnabled(true);
    this.webviewclient = new Mywebview();
    this.videowebview.setWebViewClient(this.webviewclient);
    this.videowebview.loadUrl(this.video_home_url);
    this.videodownloader2.setVisibility(0);
    this.videodownloader.setVisibility(8);
    this.videowebview.setBackgroundColor(Color.argb(0, 0, 0, 0));
  }

  protected void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(this);
  }

  public void toDownload(DownloadMovieItem paramDownloadMovieItem)
  {
    Log.v("mymy", "ssssss");
    paramDownloadMovieItem.setDownloadState(Integer.valueOf(7));
    getMyApp().setStartDownloadMovieItem(paramDownloadMovieItem);
    sendBroadcast(new Intent().setAction("download"));
    if (this.db.findItemsByWhereAndWhereValue("movieName", paramDownloadMovieItem.getMovieName(), DownloadMovieItem.class, "downloadtask", null).size() == 0)
    {
      this.db.insertObject(paramDownloadMovieItem, "downloadtask");
      return;
    }
    FinalDBChen localFinalDBChen = this.db;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramDownloadMovieItem.getMovieName();
    localFinalDBChen.updateValuesByJavaBean("downloadtask", "movieName=?", arrayOfString, paramDownloadMovieItem);
  }

  class MyAsyncTask extends AsyncTask<Void, Void, ArrayList<VideoModel>>
  {
    MyAsyncTask()
    {
    }

    protected ArrayList<VideoModel> doInBackground(Void[] paramArrayOfVoid)
    {
      String str1 = publicTools.getUrl(VideoActivity.this.video_info_url);
      ArrayList localArrayList = new ArrayList();
      if (str1 == null)
        VideoActivity.this.Error_dialog();
      while (true)
      {
        return localArrayList;
        HashMap localHashMap = new HashMap();
        localHashMap.put("content", str1);
        String str2 = publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/youtube_parse.php", localHashMap);
        JSONObject localJSONObject1;
        String str3;
        String str4;
        String str5;
        try
        {
          localJSONObject1 = new JSONObject(str2);
          if (localJSONObject1.getInt("status") != 1)
            continue;
          str3 = localJSONObject1.getString("img");
          str4 = localJSONObject1.getString("id");
          str5 = localJSONObject1.getString("title");
          if (str4 == null)
          {
            VideoActivity.this.Error_dialog();
            return localArrayList;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return localArrayList;
        }
        JSONArray localJSONArray = localJSONObject1.getJSONArray("downloads");
        for (int i = 0; i < localJSONArray.length(); i++)
        {
          VideoActivity.this.model = new VideoModel();
          JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
          VideoActivity.this.model.setVideo_item_format(localJSONObject2.getString("format"));
          VideoActivity.this.model.setVideo_item_type(localJSONObject2.getString("type"));
          VideoActivity.this.model.setVideo_item_title(str5);
          VideoActivity.this.model.setVideo_item_id(str4);
          VideoActivity.this.model.setVideo_item_img(str3);
          String str6 = localJSONObject2.getString("url");
          VideoActivity.this.model.setVideo_item_url(str6);
          localArrayList.add(VideoActivity.this.model);
        }
      }
    }

    protected void onPostExecute(final ArrayList<VideoModel> paramArrayList)
    {
      super.onPostExecute(paramArrayList);
      VideoActivity.this.tvloading.setVisibility(8);
      VideoActivity.this.progressWheel.setVisibility(8);
      if (paramArrayList.size() == 0)
      {
        final RestaryDownloadDialog localRestaryDownloadDialog = new RestaryDownloadDialog(VideoActivity.this, 2131165279);
        localRestaryDownloadDialog.setCanceledOnTouchOutside(false);
        localRestaryDownloadDialog.show();
        Button localButton1 = (Button)localRestaryDownloadDialog.findViewById(2131231019);
        Button localButton2 = (Button)localRestaryDownloadDialog.findViewById(2131231020);
        localButton1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            localRestaryDownloadDialog.dismiss();
          }
        });
        localButton2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            localRestaryDownloadDialog.dismiss();
            new VideoActivity.MyAsyncTask(VideoActivity.this).execute(new Void[0]);
            VideoActivity.this.dowload_video(paramArrayList);
          }
        });
        return;
      }
      VideoActivity.this.dowload_video(paramArrayList);
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      VideoActivity.this.progressWheel.setVisibility(0);
      VideoActivity.this.tvloading.setVisibility(0);
    }
  }

  public class Mywebview extends WebViewClient
  {
    public Mywebview()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      VideoActivity.this.progressWheel.setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      VideoActivity.this.progressWheel.setVisibility(0);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      VideoActivity.this.videowebview.loadData("", "text/html", "UTF-8");
      VideoActivity.this.net_hint_img_list.setVisibility(0);
    }

    @SuppressLint({"NewApi"})
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      if (paramString.contains("//m.youtube.com"))
      {
        Log.v("lklk", "load:" + paramString);
        Matcher localMatcher = Pattern.compile("/watch\\?.*v=([^&]+)").matcher(paramString);
        if (!localMatcher.find())
          break label167;
        Log.v("cvcv", "GOOD:" + paramString + "     id:" + localMatcher.group(1));
        Message localMessage2 = new Message();
        localMessage2.what = 1;
        VideoActivity.this.hander.sendMessage(localMessage2);
        VideoActivity.this.video_info_url = ("http://www.youtube.com/get_video_info?&video_id=" + localMatcher.group(1) + "&asv=3&el=detailpage&hl=en_US");
        Log.i("getUrl", VideoActivity.this.video_info_url);
      }
      while (true)
      {
        return super.shouldInterceptRequest(paramWebView, paramString);
        label167: if ((!paramString.contains("/feed")) && (!paramString.contains("/_get_ads")) && (!paramString.contains("/guide_ajax")))
        {
          Log.v("cvcv", "BAD:" + paramString);
          Message localMessage1 = new Message();
          localMessage1.what = 2;
          VideoActivity.this.hander.sendMessage(localMessage1);
        }
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.VideoActivity
 * JD-Core Version:    0.6.2
 */