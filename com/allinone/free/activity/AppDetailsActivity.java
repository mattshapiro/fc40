package com.allinone.free.activity;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppDetailsActivity extends BaseActivity
{
  private static Typeface typeFace = null;
  private AdView adView;
  private MyApplcation app;
  private TextView appdetailauthortitle;
  private ImageView appdetailicon;
  private RatingBar appdetailratingbar;
  private TextView appdetailtitle;
  private LinearLayout banner;
  private String banner_type_name;
  private TextView date;
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  private HashMap<String, Integer> default_options;
  private TextView detail;
  private TextView detailback;
  private ImageView detailfan;
  private TextView device;
  private Button downloadapk;
  private TextView downloads;
  private Button googleplay;
  Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 1:
        Toast.makeText(AppDetailsActivity.this, "Failed to connect server.", 0).show();
        return;
      case 2:
        AppDetailsActivity.this.Mydialog();
        return;
      case 3:
      }
      Toast.makeText(AppDetailsActivity.this, "'" + AppDetailsActivity.this.model.getTitle() + "' is added to download queue.", 0).show();
    }
  };
  private String id;
  private ArrayList<DownloadMovieItem> list;
  private DownloadMovieItem model;
  private Gallery mygallery;
  private ProgressWheel progress_wheel;
  private publicTools publictools = null;
  private SharedPreferences sp_config = null;
  private SharedPreferences spnetworkre;
  private TextView version;

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

  private void downwifi()
  {
    final LianwangDialog localLianwangDialog = new LianwangDialog(this, 2131165279);
    localLianwangDialog.setCanceledOnTouchOutside(false);
    localLianwangDialog.show();
    Button localButton1 = (Button)localLianwangDialog.findViewById(2131230944);
    Button localButton2 = (Button)localLianwangDialog.findViewById(2131230945);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localLianwangDialog.dismiss();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppDetailsActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  private void failfile()
  {
    publicTools.dmhandler = new Handler()
    {
      public void handleMessage(final Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 1212:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          new Thread(new Runnable()
          {
            public void run()
            {
              publicTools.getUrl("http://android.downloadatoz.com/_201409/market/report_fail.php?type=" + paramAnonymousMessage.getData().getString("type") + "&id=" + paramAnonymousMessage.getData().getString("id"));
            }
          }).start();
        }
      }
    };
  }

  private void init()
  {
    this.publictools = new publicTools(this);
    this.detailfan = ((ImageView)findViewById(2131230814));
    this.banner = ((LinearLayout)findViewById(2131230805));
    this.sp_config = getSharedPreferences("banner_type", 0);
    this.detailfan.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppDetailsActivity.this.finish();
      }
    });
    this.detailback = ((TextView)findViewById(2131230809));
    typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.detailback.setTypeface(typeFace);
    this.default_options = new HashMap();
    this.default_options.put("save_cookie", Integer.valueOf(0));
    this.default_options.put("send_cookie", Integer.valueOf(0));
    this.default_options.put("show_header", Integer.valueOf(0));
    this.default_options.put("redirect", Integer.valueOf(1));
    this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
    this.spnetworkre = getSharedPreferences("network", 0);
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(this);
    this.app = ((MyApplcation)getApplicationContext());
    this.progress_wheel = ((ProgressWheel)findViewById(2131230812));
    this.appdetailicon = ((ImageView)findViewById(2131230815));
    this.appdetailtitle = ((TextView)findViewById(2131230816));
    this.device = ((TextView)findViewById(2131230824));
    this.appdetailauthortitle = ((TextView)findViewById(2131230817));
    this.appdetailratingbar = ((RatingBar)findViewById(2131230818));
    this.version = ((TextView)findViewById(2131230820));
    this.date = ((TextView)findViewById(2131230821));
    this.downloads = ((TextView)findViewById(2131230823));
    this.detail = ((TextView)findViewById(2131230825));
    this.mygallery = ((Gallery)findViewById(2131230826));
    this.downloadapk = ((Button)findViewById(2131230828));
    this.googleplay = ((Button)findViewById(2131230829));
    this.downloadapk.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=" + AppDetailsActivity.this.model.getId() + "&from=apk");
          }
        }).start();
        if ((AppDetailsActivity.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(AppDetailsActivity.this.getApplicationContext()) != 1))
        {
          AppDetailsActivity.this.downwifi();
          return;
        }
        if (AppDetailsActivity.this.dbUtils.queryfile(AppDetailsActivity.this.model.getId()) == null)
        {
          AppDetailsActivity.this.MydownloadApk(AppDetailsActivity.this.model.getId(), AppDetailsActivity.this.model.getTitle(), AppDetailsActivity.this.model.getIcon());
          return;
        }
        AppDetailsActivity.this.Mydialog();
      }
    });
    this.googleplay.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=" + AppDetailsActivity.this.model.getId() + "&from=google");
          }
        }).start();
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + AppDetailsActivity.this.model.getId()));
        AppDetailsActivity.this.startActivity(localIntent);
      }
    });
  }

  public void MydownloadApk(final String paramString1, final String paramString2, final String paramString3)
  {
    String str = publicTools.getCode(paramString1);
    if (str.equals(""))
    {
      Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
      return;
    }
    new AsyncTask()
    {
      String content;
      DownloadMovieItem d = new DownloadMovieItem();
      HashMap<String, Integer> options;
      String url;

      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        this.content = publicTools.getDataFromURL(this.url, this.options);
        String str1 = "";
        Matcher localMatcher = Pattern.compile("Location: ([^\n\r\t]+)").matcher(this.content);
        if (localMatcher.find())
          str1 = localMatcher.group(1);
        Log.v("bbbb", str1);
        if (str1.equals(""))
        {
          Message localMessage1 = new Message();
          localMessage1.what = 1;
          AppDetailsActivity.this.handler.sendMessage(localMessage1);
          return null;
        }
        if (AppDetailsActivity.this.db.findItemsByWhereAndWhereValue("downloadUrl", str1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
        {
          Message localMessage2 = new Message();
          localMessage2.what = 2;
          AppDetailsActivity.this.handler.sendMessage(localMessage2);
          return null;
        }
        String str2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + AppDetailsActivity.this.getPackageName(), paramString1 + ".apk").getAbsolutePath();
        this.d.setDownloadUrl(str1);
        this.d.setFilePath(str2);
        Log.v("lklk", str1);
        this.d.setDownloadState(Integer.valueOf(4));
        this.d.setMovieName(paramString2);
        this.d.setMovieHeadImagePath(paramString3);
        this.d.setFile_id(paramString1);
        this.d.setType("app");
        this.d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
        AppDetailsActivity.this.toDownload(this.d);
        Myutils.getInstance();
        Myutils.list.add(this.d);
        Message localMessage3 = new Message();
        localMessage3.what = 3;
        AppDetailsActivity.this.handler.sendMessage(localMessage3);
        return null;
      }

      protected void onPostExecute(Void paramAnonymousVoid)
      {
        super.onPostExecute(paramAnonymousVoid);
        AppDetailsActivity.this.progress_wheel.setVisibility(8);
      }

      protected void onPreExecute()
      {
        super.onPreExecute();
        AppDetailsActivity.this.progress_wheel.setVisibility(0);
        this.options = AppDetailsActivity.this.default_options;
        this.options.put("show_header", Integer.valueOf(1));
        this.options.put("redirect", Integer.valueOf(0));
        Log.v("re", "///////" + this.url);
      }
    }
    .execute(new Void[0]);
  }

  public void initView()
  {
    super.initView();
    new FinalDBChen(getmContext(), "download.db", new DownloadMovieItem(), "downloadtask", null);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903070);
    init();
    initView();
    this.id = getIntent().getStringExtra("id");
    new Mya1().execute(new Void[0]);
    failfile();
    this.banner_type_name = this.sp_config.getString("banner_type", "admob");
    if (this.banner_type_name.equals("admob"))
    {
      this.adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-1054623928013334/2194439000");
      this.banner.addView(this.adView);
      this.adView.loadAd(new AdRequest());
    }
    this.mygallery.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Intent localIntent = new Intent(AppDetailsActivity.this, ImagePagerActivity.class);
        localIntent.putExtra("screenshotlist", AppDetailsActivity.this.list);
        localIntent.putExtra("screenshotpos", paramAnonymousInt);
        AppDetailsActivity.this.startActivity(localIntent);
      }
    });
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

  private class ImageGalleryAdapter extends BaseAdapter
  {
    private Context ctx;

    public ImageGalleryAdapter(Context arg2)
    {
      Object localObject;
      this.ctx = localObject;
    }

    public int getCount()
    {
      return AppDetailsActivity.this.list.size();
    }

    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ImageView localImageView = (ImageView)paramView;
      if (localImageView == null)
        localImageView = (ImageView)AppDetailsActivity.this.getLayoutInflater().inflate(2130903098, null, false);
      localImageView.setLayoutParams(new Gallery.LayoutParams(500, 1000));
      AppDetailsActivity.this.app.asyncLoadImage(((DownloadMovieItem)AppDetailsActivity.this.list.get(paramInt)).getScreenshots(), localImageView);
      Log.v("err", ((DownloadMovieItem)AppDetailsActivity.this.list.get(paramInt)).getScreenshots() + "***********" + paramInt);
      return localImageView;
    }
  }

  class Mya1 extends AsyncTask<Void, Void, ArrayList<DownloadMovieItem>>
  {
    Mya1()
    {
    }

    protected ArrayList<DownloadMovieItem> doInBackground(Void[] paramArrayOfVoid)
    {
      String str = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=" + AppDetailsActivity.this.id);
      AppDetailsActivity.this.list = new ArrayList();
      try
      {
        JSONObject localJSONObject1 = new JSONObject(str);
        JSONArray localJSONArray;
        if (localJSONObject1.getInt("status") == 1)
        {
          AppDetailsActivity.this.model = new DownloadMovieItem();
          JSONObject localJSONObject2 = localJSONObject1.getJSONObject("pdt");
          AppDetailsActivity.this.model.setId(localJSONObject2.getString("id"));
          AppDetailsActivity.this.model.setTitle(localJSONObject2.getString("title"));
          AppDetailsActivity.this.model.setAuthor_title(localJSONObject2.getString("author_title"));
          AppDetailsActivity.this.model.setIcon(localJSONObject2.getString("icon"));
          AppDetailsActivity.this.model.setRating(Float.valueOf(Float.parseFloat(localJSONObject2.getString("rating"))));
          AppDetailsActivity.this.model.setVersion(localJSONObject2.getString("version"));
          AppDetailsActivity.this.model.setRelease_date(localJSONObject2.getString("release_date"));
          AppDetailsActivity.this.model.setDownloads(localJSONObject2.getString("downloads"));
          AppDetailsActivity.this.model.setSize(localJSONObject2.getString("size"));
          AppDetailsActivity.this.model.setPrice(localJSONObject2.getString("price"));
          AppDetailsActivity.this.model.setDetail(localJSONObject2.getString("detail"));
          AppDetailsActivity.this.model.setHas_apk(localJSONObject2.getString("has_apk"));
          localJSONArray = localJSONObject2.getJSONArray("screenshots");
        }
        for (int i = 0; ; i++)
        {
          int j = localJSONArray.length();
          if (i >= j)
            return AppDetailsActivity.this.list;
          DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
          localDownloadMovieItem.setScreenshots(localJSONArray.getString(i));
          AppDetailsActivity.this.list.add(localDownloadMovieItem);
          Log.v("ds", localJSONArray.getString(i));
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
          localJSONException.printStackTrace();
      }
    }

    protected void onPostExecute(ArrayList<DownloadMovieItem> paramArrayList)
    {
      super.onPostExecute(paramArrayList);
      AppDetailsActivity.this.app.asyncLoadImage(AppDetailsActivity.this.model.getIcon(), AppDetailsActivity.this.appdetailicon);
      AppDetailsActivity.this.appdetailtitle.setText(AppDetailsActivity.this.model.getTitle());
      AppDetailsActivity.this.appdetailauthortitle.setText(AppDetailsActivity.this.model.getAuthor_title());
      AppDetailsActivity.this.appdetailratingbar.setRating(AppDetailsActivity.this.model.getRating().floatValue());
      AppDetailsActivity.this.version.setText("Version:" + AppDetailsActivity.this.model.getVersion());
      AppDetailsActivity.this.date.setText(AppDetailsActivity.this.model.getRelease_date());
      AppDetailsActivity.this.device.setText(AppDetailsActivity.this.model.getSize());
      AppDetailsActivity.this.downloads.setText("Downloads:" + AppDetailsActivity.this.model.getDownloads());
      AppDetailsActivity.this.detail.setText(AppDetailsActivity.this.model.getDetail());
      AppDetailsActivity.this.mygallery.setAdapter(new AppDetailsActivity.ImageGalleryAdapter(AppDetailsActivity.this, AppDetailsActivity.this));
      AppDetailsActivity.this.mygallery.setSelection(1);
      AppDetailsActivity.this.progress_wheel.setVisibility(8);
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      AppDetailsActivity.this.progress_wheel.setVisibility(0);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.AppDetailsActivity
 * JD-Core Version:    0.6.2
 */