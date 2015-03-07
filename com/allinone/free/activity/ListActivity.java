package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.dialog.MyCustomDialog;
import com.allinone.free.dialog.NointentDialog;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.Player;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class ListActivity extends BaseActivity
  implements View.OnClickListener
{
  private static Typeface typeFace = null;
  private AdView adView;
  private EditText auto_edit;
  private String banner_type_name;
  private ImageView cha;
  private TextView currenttime;
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  HashMap<String, Integer> default_options;
  private MyCustomDialog dialog;
  private ImageView fan;
  Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default:
      case 100:
      case 250:
        do
        {
          return;
          try
          {
            ListActivity.this.currenttime.setText(Player.formatTime(ListActivity.this.player.mediaPlayer.getCurrentPosition()));
            return;
          }
          catch (Exception localException)
          {
            return;
          }
          Log.v("lolo", "8888888888888");
          String str = ListActivity.this.sptitle.getString("title", "this is a new title");
          ListActivity.this.playbar.setVisibility(0);
          ListActivity.this.title.setText(str);
        }
        while (!ListActivity.this.banner_type_name.equals("admob"));
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)ListActivity.this.playbar.getLayoutParams();
        localLayoutParams.setMargins(0, 0, 0, 150);
        ListActivity.this.playbar.setLayoutParams(localLayoutParams);
        return;
      case 50:
        ListActivity.this.listwebview.loadUrl(paramAnonymousMessage.getData().getString("apk_url"));
        return;
      case 500:
      }
      ListActivity.this.listwebview.loadUrl(paramAnonymousMessage.getData().getString("mp3_ringtone_url"));
    }
  };
  private HashMap<String, String> headers;
  private Boolean istag = Boolean.valueOf(true);
  private RelativeLayout jiapan;
  private String keyword_type = null;
  private String keyword_url = null;
  private LinearLayout listactivitybanner;
  private ImageView listrelode;
  private String listtitle = null;
  private WebView listwebview;
  private SeekBar musicProgress;
  int mytotaltime = 0;
  private ImageView net_hint_img_list;
  private RelativeLayout playbar;
  private Player player;
  private ImageView playpause;
  private ProgressWheel progressWheel = null;
  private publicTools publictools = null;
  BroadcastReceiver showBroadcast = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      ListActivity.this.totaltime.setText(Player.formatTime(ListActivity.this.player.mediaPlayer.getDuration()));
      ListActivity.this.mytotaltime = ListActivity.this.player.mediaPlayer.getDuration();
      ListActivity.this.unregisterReceiver(this);
    }
  };
  private String sort = null;
  private SharedPreferences sp_config = null;
  private SharedPreferences spnetwork;
  private SharedPreferences sptitle;
  private TimerTask task;
  private Timer timer;
  private TextView title;
  private TextView totaltime;
  private String type_url = null;
  private Mywebview webviewclient;

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

  private void buildLister()
  {
    this.fan.setOnClickListener(this);
    this.playpause.setOnClickListener(this);
    this.cha.setOnClickListener(this);
    this.listrelode.setOnClickListener(this);
    this.musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
    this.player = new Player(this, this.musicProgress);
    this.auto_edit.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousKeyEvent.getAction() == 0) && (paramAnonymousInt == 66))
        {
          if (ListActivity.this.sort.equals("app"))
          {
            ListActivity.this.keyword_type = "app_list";
            Log.v("dfdf", ListActivity.this.keyword_type);
          }
          while (!ListActivity.this.auto_edit.getText().equals(""))
          {
            ListActivity.this.keyword_url = ("http://android.downloadatoz.com/_201409/market/" + ListActivity.this.keyword_type + ".php?keyword=" + ListActivity.this.auto_edit.getText() + "&page=1");
            ListActivity.this.listwebview.loadUrl(ListActivity.this.keyword_url, ListActivity.this.headers);
            ListActivity.this.type_url = ListActivity.this.keyword_url;
            Log.v("xxc", ListActivity.this.keyword_url);
            return true;
            if (ListActivity.this.sort.equals("mp3"))
            {
              ListActivity.this.keyword_type = "mp3_list";
              Log.v("dfdf", ListActivity.this.keyword_type);
            }
            else if (ListActivity.this.sort.equals("ringtone"))
            {
              ListActivity.this.keyword_type = "ringtone_list";
              Log.v("dfdf", ListActivity.this.keyword_type);
            }
          }
        }
        return false;
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
        ListActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  @SuppressLint({"SetJavaScriptEnabled", "ResourceAsColor", "NewApi"})
  private void init()
  {
    this.jiapan = ((RelativeLayout)findViewById(2131230946));
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(this);
    this.sp_config = getSharedPreferences("banner_type", 0);
    this.listactivitybanner = ((LinearLayout)findViewById(2131230951));
    this.spnetwork = getSharedPreferences("network", 0);
    this.listwebview = ((WebView)findViewById(2131230949));
    this.fan = ((ImageView)findViewById(2131230808));
    this.dialog = new MyCustomDialog(this, 2131165278);
    this.listrelode = ((ImageView)findViewById(2131230948));
    this.progressWheel = ((ProgressWheel)findViewById(2131230812));
    this.auto_edit = ((EditText)findViewById(2131230947));
    this.net_hint_img_list = ((ImageView)findViewById(2131230950));
    this.net_hint_img_list.setVisibility(8);
    this.type_url = getIntent().getStringExtra("type_url");
    this.sort = getIntent().getStringExtra("sort");
    this.listtitle = getIntent().getStringExtra("listtitle");
    this.auto_edit.setHint(this.listtitle + " ...");
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.auto_edit.setTypeface(typeFace);
    String str = Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache";
    WebSettings localWebSettings = this.listwebview.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCachePath(str);
    localWebSettings.setDatabasePath(str);
    localWebSettings.setAppCacheEnabled(true);
    initView();
    try
    {
      this.listwebview.getSettings().setUserAgentString(Myutils.setting_json.getString("agent"));
      this.listwebview.addJavascriptInterface(new scriptInterface(this), "ListActivity");
      this.headers = new HashMap();
      this.headers.put("AIOD", "1");
      this.headers.put("Referer", publicTools.get_a_random_user_webview());
      this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
      this.webviewclient = new Mywebview();
      this.listwebview.setWebViewClient(this.webviewclient);
      this.listwebview.loadUrl(this.type_url, this.headers);
      this.banner_type_name = this.sp_config.getString("banner_type", "admob");
      if (this.banner_type_name.equals("admob"))
      {
        this.adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-1054623928013334/2194439000");
        this.listactivitybanner.addView(this.adView);
        this.adView.loadAd(new AdRequest());
      }
      this.jiapan.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        private int preHeight = 0;

        public void onGlobalLayout()
        {
          int i = ListActivity.this.jiapan.getRootView().getHeight() - ListActivity.this.jiapan.getHeight();
          System.out.println("height differ = " + i);
          if (this.preHeight == i)
            return;
          this.preHeight = i;
          if (i > 100)
          {
            ListActivity.this.listactivitybanner.setVisibility(8);
            ListActivity.this.listrelode.setVisibility(8);
            return;
          }
          ListActivity.this.listactivitybanner.setVisibility(0);
          ListActivity.this.listrelode.setVisibility(0);
        }
      });
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private void init2()
  {
    this.playpause = ((ImageView)findViewById(2131230833));
    this.cha = ((ImageView)findViewById(2131230837));
    this.playbar = ((RelativeLayout)findViewById(2131230832));
    this.totaltime = ((TextView)findViewById(2131230841));
    this.currenttime = ((TextView)findViewById(2131230839));
    this.title = ((TextView)findViewById(2131230836));
    this.musicProgress = ((SeekBar)findViewById(2131230840));
  }

  private void myhandler()
  {
    publicTools.dmhandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
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
          new ListActivity.scriptInterface(ListActivity.this, ListActivity.this.getApplicationContext()).i_report_fail(paramAnonymousMessage.getData().getString("type"), paramAnonymousMessage.getData().getString("id"));
          Log.v("abcd", "失效的type===" + paramAnonymousMessage.getData().getString("type") + "失效的id===" + paramAnonymousMessage.getData().getString("id"));
        }
      }
    };
  }

  public void MydownloadApk(String paramString1, String paramString2, String paramString3)
  {
    DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
    String str1 = publicTools.getCode(paramString1);
    Log.v("ioio", str1);
    if (str1.equals(""))
    {
      Toast.makeText(getApplicationContext(), "Failed to connect server. Please try again.", 0).show();
      return;
    }
    String str2 = "http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=" + paramString1 + "&stamp=" + str1;
    Log.v("ioio", str2);
    new HashMap();
    HashMap localHashMap = this.default_options;
    localHashMap.put("show_header", Integer.valueOf(1));
    localHashMap.put("redirect", Integer.valueOf(0));
    String str3 = publicTools.getDataFromURL(str2, localHashMap);
    String str4 = "";
    Matcher localMatcher = Pattern.compile("Location: ([^\n\r\t]+)").matcher(str3);
    if (localMatcher.find())
      str4 = localMatcher.group(1);
    Log.v("uiui", str4);
    if (str4.equals(""))
    {
      Toast.makeText(getApplicationContext(), "Failed to connect server.", 0).show();
      return;
    }
    if (this.db.findItemsByWhereAndWhereValue("downloadUrl", str4, DownloadMovieItem.class, "downloadtask", null).size() > 0)
    {
      Mydialog();
      return;
    }
    String str5 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + getPackageName(), paramString1 + ".apk").getAbsolutePath();
    localDownloadMovieItem.setDownloadUrl(str4);
    Log.v("fvfv", str4);
    localDownloadMovieItem.setFilePath(str5);
    localDownloadMovieItem.setDownloadState(Integer.valueOf(4));
    localDownloadMovieItem.setMovieName(paramString2);
    localDownloadMovieItem.setMovieHeadImagePath(paramString3);
    localDownloadMovieItem.setFile_id(paramString1);
    localDownloadMovieItem.setType("app");
    localDownloadMovieItem.setCreate_time(Long.valueOf(System.currentTimeMillis()));
    toDownload(localDownloadMovieItem);
    Myutils.getInstance();
    Myutils.list.add(localDownloadMovieItem);
    Log.v("opop", "我的包名" + paramString1);
    Toast.makeText(getApplicationContext(), "'" + localDownloadMovieItem.getMovieName() + "' is added to download queue.", 0).show();
  }

  public void MydownloadMp3AndRingtone(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
    if (this.db.findItemsByWhereAndWhereValue("file_id", paramString1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
    {
      Mydialog();
      return;
    }
    String str = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + getPackageName(), paramString1 + ".mp3").getAbsolutePath();
    localDownloadMovieItem.setDownloadUrl(paramString3);
    localDownloadMovieItem.setFilePath(str);
    localDownloadMovieItem.setDownloadState(Integer.valueOf(4));
    localDownloadMovieItem.setMovieName(paramString2);
    localDownloadMovieItem.setFile_id(paramString1);
    localDownloadMovieItem.setMovieHeadImagePath(paramString4);
    if (this.sort.equals("mp3"))
      localDownloadMovieItem.setType("mp3");
    while (true)
    {
      localDownloadMovieItem.setCreate_time(Long.valueOf(System.currentTimeMillis()));
      toDownload(localDownloadMovieItem);
      Myutils.getInstance();
      Myutils.list.add(localDownloadMovieItem);
      Toast.makeText(getApplicationContext(), "'" + localDownloadMovieItem.getMovieName() + "' is added to download queue.", 0).show();
      return;
      if (this.sort.equals("ringtone"))
        localDownloadMovieItem.setType("ringtone");
    }
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
    case 2131230808:
      finish();
      return;
    case 2131230948:
      if (!publicTools.isNetworkAvailable(this))
      {
        final NointentDialog localNointentDialog = new NointentDialog(this, 2131165279);
        localNointentDialog.setCanceledOnTouchOutside(false);
        localNointentDialog.show();
        Button localButton1 = (Button)localNointentDialog.findViewById(2131230944);
        Button localButton2 = (Button)localNointentDialog.findViewById(2131230945);
        localButton1.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            localNointentDialog.dismiss();
          }
        });
        localButton2.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            ListActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            localNointentDialog.dismiss();
          }
        });
        return;
      }
      this.net_hint_img_list.setVisibility(8);
      this.listwebview.loadUrl(this.type_url, this.headers);
      return;
    case 2131230833:
      if (this.istag.booleanValue())
      {
        this.player.pause();
        this.playpause.setBackgroundResource(2130837730);
        this.istag = Boolean.valueOf(false);
        return;
      }
      this.player.play();
      this.playpause.setBackgroundResource(2130837732);
      this.istag = Boolean.valueOf(true);
      return;
    case 2131230837:
    }
    this.player.pause();
    this.playpause.setBackgroundResource(2130837732);
    this.istag = Boolean.valueOf(true);
    this.playbar.setVisibility(8);
    this.listwebview.loadUrl("javascript:i_reset_playing();");
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.listwebview.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 0);
    this.listwebview.setLayoutParams(localLayoutParams);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903101);
    setmContext(this);
    this.publictools = new publicTools(getApplicationContext());
    init2();
    init();
    buildLister();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("show");
    registerReceiver(this.showBroadcast, localIntentFilter);
    this.default_options = new HashMap();
    this.default_options.put("save_cookie", Integer.valueOf(0));
    this.default_options.put("send_cookie", Integer.valueOf(0));
    this.default_options.put("show_header", Integer.valueOf(0));
    this.default_options.put("redirect", Integer.valueOf(1));
    myhandler();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.timer != null)
    {
      this.timer.cancel();
      this.timer = null;
    }
    if (this.task != null)
    {
      this.task.cancel();
      this.task = null;
    }
    if (this.player.mediaPlayer.isPlaying())
    {
      this.player.pause();
      this.player.stop();
    }
    if (this.player != null)
      this.player = null;
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

  public class Mywebview extends WebViewClient
  {
    public Mywebview()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      ListActivity.this.progressWheel.setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      ListActivity.this.progressWheel.setVisibility(0);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      ListActivity.this.listwebview.loadData("", "text/html", "UTF-8");
      ListActivity.this.net_hint_img_list.setVisibility(0);
    }

    @SuppressLint({"NewApi"})
    public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
    {
      Matcher localMatcher = Pattern.compile("/watch\\?ajax=1.*&v=([a-zA-Z0-9]+)").matcher(paramString);
      if (localMatcher.find())
        Log.v("cvcv", "GOOD:" + paramString + "     id:" + localMatcher.group(1));
      return super.shouldInterceptRequest(paramWebView, paramString);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      super.shouldOverrideUrlLoading(paramWebView, paramString);
      ListActivity.this.net_hint_img_list.setVisibility(8);
      if (publicTools.is_good_domain(paramString))
      {
        paramWebView.loadUrl(paramString, ListActivity.this.headers);
        ListActivity.this.type_url = paramString;
      }
      while (true)
      {
        return false;
        Toast.makeText(ListActivity.this.getApplicationContext(), "222222222", 1).show();
      }
    }
  }

  class SeekBarChangeEvent
    implements SeekBar.OnSeekBarChangeListener
  {
    int progress;

    SeekBarChangeEvent()
    {
    }

    public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      try
      {
        this.progress = (paramInt * ListActivity.this.player.mediaPlayer.getDuration() / paramSeekBar.getMax());
        return;
      }
      catch (Exception localException)
      {
      }
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      ListActivity.this.player.mediaPlayer.seekTo(this.progress);
    }
  }

  private class scriptInterface
  {
    private Context context;

    public scriptInterface(Context arg2)
    {
      Object localObject;
      this.context = localObject;
    }

    @JavascriptInterface
    public void i_download_app(String paramString1, String paramString2, String paramString3)
    {
      if ((ListActivity.this.spnetwork.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(ListActivity.this.getApplicationContext()) != 1))
      {
        ListActivity.this.downwifi();
        return;
      }
      if (ListActivity.this.dbUtils.queryfile(paramString1) == null)
      {
        ListActivity.this.MydownloadApk(paramString1, paramString2, paramString3);
        return;
      }
      ListActivity.this.Mydialog();
    }

    @JavascriptInterface
    public void i_download_app_google(String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + paramString));
      ListActivity.this.startActivity(localIntent);
    }

    @JavascriptInterface
    public void i_download_music(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      if ((ListActivity.this.spnetwork.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(ListActivity.this.getApplicationContext()) != 1))
      {
        ListActivity.this.downwifi();
        return;
      }
      if (ListActivity.this.dbUtils.queryfile(paramString2) == null)
      {
        ListActivity.this.MydownloadMp3AndRingtone(paramString2, paramString3, paramString4, paramString5);
        return;
      }
      ListActivity.this.Mydialog();
    }

    @JavascriptInterface
    public void i_get_pdt_result(String paramString1, String paramString2, String paramString3)
    {
      String str1 = publicTools.getDataFromURL(paramString2, ListActivity.this.default_options);
      Log.v("rtrt", paramString1 + str1);
      String str2 = Base64.encodeToString(str1.getBytes(), 0).replace("\n", "").replace("\r", "");
      Message localMessage = new Message();
      localMessage.what = 500;
      localMessage.getData().putString("mp3_ringtone_url", "javascript:i_parse_pdt_result('" + str2 + "', '" + paramString3 + "');");
      ListActivity.this.handler.sendMessage(localMessage);
    }

    @JavascriptInterface
    public void i_get_ringtone_result(String paramString1, String paramString2)
    {
      Log.v("rtrt", "ringtone_url:" + paramString1 + "***************");
    }

    @JavascriptInterface
    public void i_get_search_result(final String paramString, final int paramInt)
    {
      Log.v("klkl", "url:" + paramString);
      new Thread(new Runnable()
      {
        public void run()
        {
          String str = Base64.encodeToString(publicTools.getDataFromURL(paramString, ListActivity.this.default_options).getBytes(), 0).replace("\n", "").replace("\r", "");
          Message localMessage = new Message();
          localMessage.what = 50;
          localMessage.getData().putString("apk_url", "javascript:i_parse_search_result('" + str + "','" + paramInt + "');");
          ListActivity.this.handler.sendMessage(localMessage);
        }
      }).start();
    }

    @JavascriptInterface
    public void i_go_to_app_detail(String paramString)
    {
      Intent localIntent = new Intent(ListActivity.this, AppDetailActivity.class);
      localIntent.putExtra("appdetail_url", paramString);
      ListActivity.this.startActivity(localIntent);
    }

    @JavascriptInterface
    public void i_play_music(String paramString1, String paramString2, String paramString3, final String paramString4)
    {
      Toast.makeText(ListActivity.this.getApplicationContext(), "Loading......", 1).show();
      ListActivity.this.sptitle = ListActivity.this.getSharedPreferences("datatitle", 0);
      ListActivity.this.sptitle.edit().putString("title", paramString3).commit();
      Message localMessage = new Message();
      localMessage.what = 250;
      ListActivity.this.handler.sendMessage(localMessage);
      Log.v("lolo", "play------------------");
      new Thread(new Runnable()
      {
        public void run()
        {
          ListActivity.this.player.playUrl(paramString4);
          ListActivity.this.timer = new Timer();
          ListActivity.this.task = new TimerTask()
          {
            public void run()
            {
              Message localMessage = new Message();
              localMessage.what = 100;
              ListActivity.this.handler.sendMessage(localMessage);
            }
          };
          ListActivity.this.timer.schedule(ListActivity.this.task, 0L, 1000L);
        }
      }).start();
    }

    @JavascriptInterface
    public void i_report_fail(final String paramString1, final String paramString2)
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          publicTools.getUrl("http://android.downloadatoz.com/_201409/market/report_fail.php?type=" + paramString1 + "&id=" + paramString2);
        }
      }).start();
      Log.v("zxzx", "------------------------------");
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.ListActivity
 * JD-Core Version:    0.6.2
 */