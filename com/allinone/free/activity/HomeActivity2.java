package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.allinone.free.dialog.MyCustomDialog;
import com.allinone.free.dialog.NointentDialog;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class HomeActivity2 extends BaseActivity
  implements View.OnClickListener
{
  private static Typeface typeFace = null;
  private String app = "http://android.downloadatoz.com/_201409/market/app_list.php";
  private FinalDBChen db;
  private MyCustomDialog dialog;
  private List<DownloadMovieItem> ds;
  private String font = "http://android.downloadatoz.com/_201409/market/font_list.php";
  private HashMap<String, String> headers;
  private TextView hometv1;
  private String homeurl = "http://android.downloadatoz.com/_201409/market/index.php";
  private WebView homewebview;
  private RelativeLayout l1;
  private RelativeLayout l3;
  private RelativeLayout l4;
  private PopupWindow mWindow;
  private String manga = "http://android.downloadatoz.com/_201409/market/manga_list.php";
  private ImageView more;
  private String mp3 = "http://android.downloadatoz.com/_201409/market/mp3_list.php";
  private ImageView net_hint_img;
  private ProgressWheel progressWheel = null;
  private publicTools publictools = null;
  private String ringtone = "http://android.downloadatoz.com/_201409/market/ringtone_list.php";
  private String video = "http://android.downloadatoz.com/_201409/market/video_list.php";
  Mywebview webviewclient;

  private void buildListern()
  {
    this.more.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HomeActivity2.this.popuWindow();
        HomeActivity2.this.mWindow.showAsDropDown(paramAnonymousView);
      }
    });
  }

  private void popuWindow()
  {
    View localView = LayoutInflater.from(this).inflate(2130903096, null);
    this.l1 = ((RelativeLayout)localView.findViewById(2131230892));
    this.l3 = ((RelativeLayout)localView.findViewById(2131230894));
    this.l4 = ((RelativeLayout)localView.findViewById(2131230902));
    this.l1.setOnClickListener(this);
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

  @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
  public void initView()
  {
    new FinalDBChen(getmContext(), "download.db", new DownloadMovieItem(), "downloadtask", null);
    this.dialog = new MyCustomDialog(this, 2131165278);
    this.progressWheel = ((ProgressWheel)findViewById(2131230812));
    this.more = ((ImageView)findViewById(2131230915));
    this.homewebview = ((WebView)findViewById(2131230940));
    this.net_hint_img = ((ImageView)findViewById(2131230941));
    this.net_hint_img.setVisibility(8);
    this.hometv1 = ((TextView)findViewById(2131230913));
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.hometv1.setTypeface(typeFace);
    publicTools.make_path_ready(Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache");
    String str = Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache";
    WebSettings localWebSettings = this.homewebview.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCachePath(str);
    localWebSettings.setDatabasePath(str);
    localWebSettings.setAppCacheEnabled(true);
    publicTools.set_a_random_user_agent();
    try
    {
      this.homewebview.getSettings().setUserAgentString(Myutils.setting_json.getString("agent"));
      this.homewebview.addJavascriptInterface(new scriptInterface(this), "HomeActivity2");
      this.headers = new HashMap();
      this.headers.put("AIOD", "1");
      this.headers.put("X-REQUESTED-WITH", "");
      this.headers.put("Referer", publicTools.get_a_random_user_webview());
      this.webviewclient = new Mywebview();
      this.homewebview.setWebViewClient(this.webviewclient);
      this.homewebview.loadUrl(this.homeurl, this.headers);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
    case 2131230892:
    case 2131230894:
    case 2131230902:
    }
    while (true)
    {
      this.mWindow.dismiss();
      return;
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
            HomeActivity2.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            localNointentDialog.dismiss();
          }
        });
      }
      else
      {
        this.net_hint_img.setVisibility(8);
        this.homewebview.loadUrl(this.homeurl, this.headers);
        continue;
        startActivity(new Intent(this, MySettingsActivity.class));
        continue;
        Intent localIntent = new Intent(this, ContentUsActivity.class);
        localIntent.putExtra("guanggao_url", Myutils.contactus_url_home);
        startActivity(localIntent);
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903095);
    setmContext(this);
    this.publictools = new publicTools(getApplicationContext());
    initView();
    buildListern();
    this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
    this.ds = this.db.findItemsByWhereAndWhereValue(null, null, DownloadMovieItem.class, "downloadtask", null);
    if (publicTools.isNetworkAvailable(this))
      publicTools.resetServerTime();
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

  public class Mywebview extends WebViewClient
  {
    public Mywebview()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      HomeActivity2.this.progressWheel.setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      HomeActivity2.this.progressWheel.setVisibility(0);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      HomeActivity2.this.homewebview.loadData("", "text/html", "UTF-8");
      HomeActivity2.this.net_hint_img.setVisibility(0);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      super.shouldOverrideUrlLoading(paramWebView, paramString);
      HomeActivity2.this.net_hint_img.setVisibility(8);
      if (!publicTools.is_good_domain(paramString))
      {
        Intent localIntent = new Intent(HomeActivity2.this, ContentUsActivity.class);
        localIntent.putExtra("guanggao_url", paramString);
        HomeActivity2.this.startActivity(localIntent);
        paramWebView.stopLoading();
      }
      return false;
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
    public void i_go_to_downloader(String paramString)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.listactvity");
      if (paramString.equals("app"))
      {
        localIntent.putExtra("type_url", HomeActivity2.this.app + "?" + Math.random());
        localIntent.putExtra("sort", "app");
        localIntent.putExtra("listtitle", "Search App");
      }
      while (true)
      {
        HomeActivity2.this.startActivity(localIntent);
        return;
        if (paramString.equals("mp3"))
        {
          localIntent.putExtra("type_url", HomeActivity2.this.mp3 + "?" + Math.random());
          localIntent.putExtra("sort", "mp3");
          localIntent.putExtra("listtitle", "Search Mp3");
        }
        else if (paramString.equals("ringtone"))
        {
          localIntent.putExtra("type_url", HomeActivity2.this.ringtone + "?" + Math.random());
          localIntent.putExtra("sort", "ringtone");
          localIntent.putExtra("listtitle", "Search Ringtone");
        }
        else if (paramString.equals("video"))
        {
          localIntent.putExtra("type_url", HomeActivity2.this.video + "?" + Math.random());
          localIntent.putExtra("sort", "video");
          localIntent.putExtra("listtitle", "Search Video");
        }
        else if (paramString.equals("font"))
        {
          localIntent.putExtra("type_url", HomeActivity2.this.font + "?" + Math.random());
          localIntent.putExtra("sort", "font");
          localIntent.putExtra("listtitle", "Search Font");
        }
        else if (paramString.equals("manga"))
        {
          localIntent.putExtra("type_url", HomeActivity2.this.manga + "?" + Math.random());
          localIntent.putExtra("sort", "manga");
          localIntent.putExtra("listtitle", "Search Manga");
        }
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.HomeActivity2
 * JD-Core Version:    0.6.2
 */