package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
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
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class AppDetailActivity extends BaseActivity
  implements View.OnClickListener
{
  private static Typeface typeFace = null;
  private String appdetail_url = null;
  private WebView appdetailwebview;
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  HashMap<String, Integer> default_options;
  private TextView detailback;
  private ImageView detailrelode;
  private MyCustomDialog dialog;
  private ImageView fan;
  private HashMap<String, String> headers;
  private ImageView net_hint_img_pdt;
  private ProgressWheel progressWheel = null;
  private publicTools publictools = null;
  private SharedPreferences spnetworkdetail;
  Mywebview webviewclient;

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
        AppDetailActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void init()
  {
    this.spnetworkdetail = getSharedPreferences("network", 0);
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(this);
    this.appdetailwebview = ((WebView)findViewById(2131230811));
    this.fan = ((ImageView)findViewById(2131230808));
    this.net_hint_img_pdt = ((ImageView)findViewById(2131230813));
    this.net_hint_img_pdt.setVisibility(8);
    this.progressWheel = ((ProgressWheel)findViewById(2131230812));
    this.detailback = ((TextView)findViewById(2131230809));
    this.detailrelode = ((ImageView)findViewById(2131230810));
    this.detailrelode.setOnClickListener(this);
    this.dialog = new MyCustomDialog(this, 2131165278);
    this.appdetail_url = getIntent().getStringExtra("appdetail_url");
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.detailback.setTypeface(typeFace);
    String str = Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache";
    WebSettings localWebSettings = this.appdetailwebview.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCachePath(str);
    localWebSettings.setDatabasePath(str);
    localWebSettings.setAppCacheEnabled(true);
    initView();
    try
    {
      this.appdetailwebview.getSettings().setUserAgentString(Myutils.setting_json.getString("agent"));
      this.appdetailwebview.addJavascriptInterface(new scriptInterface(this), "AppDetailActivity");
      this.headers = new HashMap();
      this.headers.put("AIOD", "1");
      this.headers.put("Referer", publicTools.get_a_random_user_webview());
      this.webviewclient = new Mywebview();
      this.appdetailwebview.setWebViewClient(this.webviewclient);
      this.appdetailwebview.loadUrl(this.appdetail_url, this.headers);
      this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
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
    Log.v("ioio", str4);
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

  public void initView()
  {
    super.initView();
    new FinalDBChen(getmContext(), "download.db", new DownloadMovieItem(), "downloadtask", null);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230809:
    default:
      return;
    case 2131230808:
      finish();
      return;
    case 2131230810:
    }
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
          AppDetailActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
          localNointentDialog.dismiss();
        }
      });
      return;
    }
    this.net_hint_img_pdt.setVisibility(8);
    this.appdetailwebview.loadUrl(this.appdetail_url, this.headers);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903069);
    setmContext(this);
    this.publictools = new publicTools(getApplicationContext());
    init();
    buildLister();
    this.default_options = new HashMap();
    this.default_options.put("save_cookie", Integer.valueOf(0));
    this.default_options.put("send_cookie", Integer.valueOf(0));
    this.default_options.put("show_header", Integer.valueOf(0));
    this.default_options.put("redirect", Integer.valueOf(1));
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
      AppDetailActivity.this.progressWheel.setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppDetailActivity.this.progressWheel.setVisibility(0);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      AppDetailActivity.this.net_hint_img_pdt.setVisibility(0);
      AppDetailActivity.this.appdetailwebview.loadData("", "text/html", "UTF-8");
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
      if ((AppDetailActivity.this.spnetworkdetail.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(AppDetailActivity.this.getApplicationContext()) != 1))
      {
        AppDetailActivity.this.downwifi();
        return;
      }
      if (AppDetailActivity.this.dbUtils.queryfile(paramString1) == null)
      {
        AppDetailActivity.this.MydownloadApk(paramString1, paramString2, paramString3);
        return;
      }
      AppDetailActivity.this.Mydialog();
    }

    @JavascriptInterface
    public void i_download_app_google(String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + paramString));
      AppDetailActivity.this.startActivity(localIntent);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.AppDetailActivity
 * JD-Core Version:    0.6.2
 */