package com.allinone.free.activity;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.dialog.WallpaperdownloadDialog;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.example.CustomActivity;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends BaseActivity
  implements View.OnClickListener
{
  private static Typeface typeFace = null;
  private String app = "http://android.downloadatoz.com/_201409/market/app_list.php";
  private RelativeLayout appframe;
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  private HashMap<String, Integer> default_options;
  private String font = "http://android.downloadatoz.com/_201409/market/font_list.php";
  private RelativeLayout fontframe;
  private RelativeLayout gameframe;
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
        Toast.makeText(HomeActivity.this, "Failed to connect server.", 0).show();
        return;
      case 2:
        HomeActivity.this.Mydialog();
        return;
      case 3:
      }
      Toast.makeText(HomeActivity.this, "'HD Wallpaper' is added to download queue.", 0).show();
    }
  };
  private TextView hometv1;
  private RelativeLayout iconframe;
  private RelativeLayout l3;
  private RelativeLayout l4;
  private PopupWindow mWindow;
  private String manga = "http://android.downloadatoz.com/_201409/market/manga_list.php";
  private RelativeLayout mangaframe;
  private ImageView more;
  private RelativeLayout movieframe;
  private String mp3 = "http://android.downloadatoz.com/_201409/market/mp3_list.php";
  private RelativeLayout mp3frame;
  private ProgressWheel progress_wheel;
  private publicTools publictools = null;
  private String ringtone = "http://android.downloadatoz.com/_201409/market/ringtone_list.php";
  private RelativeLayout ringtoneframe;
  private SharedPreferences spnetworkre;
  private RelativeLayout videoframe;
  private RelativeLayout wallpaperframe;

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

  private void buildListener()
  {
    this.appframe.setOnClickListener(this);
    this.mp3frame.setOnClickListener(this);
    this.ringtoneframe.setOnClickListener(this);
    this.videoframe.setOnClickListener(this);
    this.fontframe.setOnClickListener(this);
    this.mangaframe.setOnClickListener(this);
    this.movieframe.setOnClickListener(this);
    this.gameframe.setOnClickListener(this);
    this.iconframe.setOnClickListener(this);
    this.more.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HomeActivity.this.popuWindow();
        HomeActivity.this.mWindow.showAtLocation(paramAnonymousView, 53, 0, DisplayUtil.dip2px(HomeActivity.this.getApplicationContext(), 14.0F));
      }
    });
    this.wallpaperframe.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          PackageInfo localPackageInfo2 = HomeActivity.this.getPackageManager().getPackageInfo("com.ezapp.wallpaperhd", 0);
          localPackageInfo1 = localPackageInfo2;
          if (localPackageInfo1 == null)
          {
            final WallpaperdownloadDialog localWallpaperdownloadDialog = new WallpaperdownloadDialog(HomeActivity.this, 2131165279);
            localWallpaperdownloadDialog.setCanceledOnTouchOutside(false);
            localWallpaperdownloadDialog.show();
            ((Button)localWallpaperdownloadDialog.findViewById(2131230753)).setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                if ((HomeActivity.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(HomeActivity.this) != 1))
                {
                  HomeActivity.this.downwifi();
                  return;
                }
                if (HomeActivity.this.dbUtils.queryfile("com.ezapp.wallpaperhd") == null)
                  HomeActivity.this.MydownloadApk("com.ezapp.wallpaperhd", "HD Wallpaper Downloader", "https://lh6.ggpht.com/o-6NKHZUdbEl3HBAlnzVxVzH7_ADKtSwT7NQYvnSXvrfO6ebrAJdffxeHhe0NecD61o=w300");
                while (true)
                {
                  localWallpaperdownloadDialog.dismiss();
                  return;
                  HomeActivity.this.Mydialog();
                }
              }
            });
            return;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          while (true)
          {
            localNameNotFoundException.printStackTrace();
            PackageInfo localPackageInfo1 = null;
          }
          Intent localIntent = HomeActivity.this.getPackageManager().getLaunchIntentForPackage("com.ezapp.wallpaperhd");
          HomeActivity.this.startActivity(localIntent);
        }
      }
    });
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
        HomeActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  private void init()
  {
    this.default_options = new HashMap();
    this.default_options.put("save_cookie", Integer.valueOf(0));
    this.default_options.put("send_cookie", Integer.valueOf(0));
    this.default_options.put("show_header", Integer.valueOf(0));
    this.default_options.put("redirect", Integer.valueOf(1));
    this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
    this.spnetworkre = getSharedPreferences("network", 0);
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(this);
    this.progress_wheel = ((ProgressWheel)findViewById(2131230812));
    this.appframe = ((RelativeLayout)findViewById(2131230918));
    this.wallpaperframe = ((RelativeLayout)findViewById(2131230923));
    this.mp3frame = ((RelativeLayout)findViewById(2131230919));
    this.ringtoneframe = ((RelativeLayout)findViewById(2131230921));
    this.videoframe = ((RelativeLayout)findViewById(2131230916));
    this.fontframe = ((RelativeLayout)findViewById(2131230934));
    this.mangaframe = ((RelativeLayout)findViewById(2131230937));
    this.movieframe = ((RelativeLayout)findViewById(2131230928));
    this.gameframe = ((RelativeLayout)findViewById(2131230925));
    this.iconframe = ((RelativeLayout)findViewById(2131230931));
    this.more = ((ImageView)findViewById(2131230915));
    this.hometv1 = ((TextView)findViewById(2131230913));
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.hometv1.setTypeface(typeFace);
  }

  private void popuWindow()
  {
    View localView = LayoutInflater.from(this).inflate(2130903096, null);
    this.l3 = ((RelativeLayout)localView.findViewById(2131230894));
    this.l4 = ((RelativeLayout)localView.findViewById(2131230902));
    this.l3.setOnClickListener(this);
    this.l4.setOnClickListener(this);
    this.mWindow = new PopupWindow(localView);
    getWindowManager().getDefaultDisplay().getHeight();
    int i = getWindowManager().getDefaultDisplay().getWidth();
    this.mWindow.setWidth(50 + i / 2);
    this.mWindow.setHeight(-2);
    this.mWindow.setFocusable(true);
    this.mWindow.setAnimationStyle(2131165282);
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    this.mWindow.setBackgroundDrawable(localColorDrawable);
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
          HomeActivity.this.handler.sendMessage(localMessage1);
          return null;
        }
        if (HomeActivity.this.db.findItemsByWhereAndWhereValue("downloadUrl", str1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
        {
          Message localMessage2 = new Message();
          localMessage2.what = 2;
          HomeActivity.this.handler.sendMessage(localMessage2);
          return null;
        }
        String str2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + HomeActivity.this.getPackageName(), paramString1 + ".apk").getAbsolutePath();
        this.d.setDownloadUrl(str1);
        this.d.setFilePath(str2);
        Log.v("lklk", str1);
        this.d.setDownloadState(Integer.valueOf(4));
        this.d.setMovieName(paramString2);
        this.d.setMovieHeadImagePath(paramString3);
        this.d.setFile_id(paramString1);
        this.d.setType("app");
        this.d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
        HomeActivity.this.toDownload(this.d);
        Myutils.getInstance();
        Myutils.list.add(this.d);
        Message localMessage3 = new Message();
        localMessage3.what = 3;
        HomeActivity.this.handler.sendMessage(localMessage3);
        return null;
      }

      protected void onPostExecute(Void paramAnonymousVoid)
      {
        super.onPostExecute(paramAnonymousVoid);
        HomeActivity.this.progress_wheel.setVisibility(8);
      }

      protected void onPreExecute()
      {
        super.onPreExecute();
        HomeActivity.this.progress_wheel.setVisibility(0);
        this.options = HomeActivity.this.default_options;
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

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230918:
      startActivity(new Intent(this, AppActivity.class));
      return;
    case 2131230919:
      startActivity(new Intent(this, Mp3Activity.class));
      return;
    case 2131230921:
      startActivity(new Intent(this, RingtoneActivity.class));
      return;
    case 2131230916:
      startActivity(new Intent(this, VideoActivity.class));
      return;
    case 2131230934:
      Intent localIntent5 = new Intent(this, ComingSongActivity.class);
      localIntent5.putExtra("title", "Search Font");
      startActivity(localIntent5);
      return;
    case 2131230937:
      Intent localIntent4 = new Intent(this, ComingSongActivity.class);
      localIntent4.putExtra("title", "Search Manga");
      startActivity(localIntent4);
      return;
    case 2131230928:
      Intent localIntent3 = new Intent(this, ComingSongActivity.class);
      localIntent3.putExtra("title", "Search Moive");
      startActivity(localIntent3);
      return;
    case 2131230925:
      Intent localIntent2 = new Intent(this, ComingSongActivity.class);
      localIntent2.putExtra("title", "Search Games");
      startActivity(localIntent2);
      return;
    case 2131230931:
      Intent localIntent1 = new Intent(this, ComingSongActivity.class);
      localIntent1.putExtra("title", "Search Icon");
      startActivity(localIntent1);
      return;
    case 2131230894:
      startActivity(new Intent(this, MySettingsActivity.class));
      this.mWindow.dismiss();
      return;
    case 2131230902:
    }
    startActivity(new Intent(this, CustomActivity.class));
    this.mWindow.dismiss();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903094);
    setmContext(this);
    this.publictools = new publicTools(getApplicationContext());
    initView();
    if (publicTools.isNetworkAvailable(this));
    try
    {
      publicTools.resetServerTime();
      try
      {
        label46: if (Myutils.setting_json.getInt("run_times") != 1)
          publicTools.set_a_random_user_agent();
        init();
        buildListener();
        return;
      }
      catch (JSONException localJSONException)
      {
        while (true)
          localJSONException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      break label46;
    }
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
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.HomeActivity
 * JD-Core Version:    0.6.2
 */