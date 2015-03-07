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
import android.os.Handler;
import android.os.Message;
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

public class RecommendActivity extends BaseActivity
{
  private static Typeface typeFace = null;
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  HashMap<String, Integer> default_options;
  private HashMap<String, String> headers;
  private String myid = null;
  private ImageView net_hint_img_recom;
  private ProgressWheel progressWheel = null;
  private publicTools publictools = null;
  private ImageView recommendmore;
  private TextView recommendtext;
  private String recommendurl = null;
  private WebView recomwebivew;
  private SharedPreferences spnetworkre;
  private String url_id = "";
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

  // ERROR //
  private void Recommed_Url()
  {
    // Byte code:
    //   0: ldc 97
    //   2: new 99	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 101
    //   8: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 49	com/allinone/free/activity/RecommendActivity:myid	Ljava/lang/String;
    //   15: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: aload_0
    //   26: getfield 49	com/allinone/free/activity/RecommendActivity:myid	Ljava/lang/String;
    //   29: ifnonnull +178 -> 207
    //   32: getstatic 124	com/allinone/free/utils/Myutils:setting_json	Lorg/json/JSONObject;
    //   35: ldc 126
    //   37: invokevirtual 132	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   40: iconst_1
    //   41: if_icmpne +26 -> 67
    //   44: ldc 133
    //   46: ldc 135
    //   48: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   51: pop
    //   52: getstatic 124	com/allinone/free/utils/Myutils:setting_json	Lorg/json/JSONObject;
    //   55: ldc 137
    //   57: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   60: invokevirtual 147	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   63: pop
    //   64: invokestatic 150	com/allinone/free/utils/Myutils:saveSetting	()V
    //   67: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   70: getstatic 124	com/allinone/free/utils/Myutils:setting_json	Lorg/json/JSONObject;
    //   73: ldc 137
    //   75: invokevirtual 154	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   78: lsub
    //   79: ldc2_w 155
    //   82: lcmp
    //   83: ifge +106 -> 189
    //   86: aload_0
    //   87: invokevirtual 160	com/allinone/free/activity/RecommendActivity:getResources	()Landroid/content/res/Resources;
    //   90: ldc 161
    //   92: invokevirtual 167	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   95: astore 6
    //   97: aload 6
    //   99: invokevirtual 173	java/io/InputStream:available	()I
    //   102: newarray byte
    //   104: astore 7
    //   106: aload 6
    //   108: aload 7
    //   110: invokevirtual 177	java/io/InputStream:read	([B)I
    //   113: pop
    //   114: aload 6
    //   116: invokevirtual 180	java/io/InputStream:close	()V
    //   119: aload_0
    //   120: new 182	java/lang/String
    //   123: dup
    //   124: aload 7
    //   126: invokespecial 185	java/lang/String:<init>	([B)V
    //   129: putfield 47	com/allinone/free/activity/RecommendActivity:url_id	Ljava/lang/String;
    //   132: aload_0
    //   133: new 99	java/lang/StringBuilder
    //   136: dup
    //   137: ldc 187
    //   139: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 47	com/allinone/free/activity/RecommendActivity:url_id	Ljava/lang/String;
    //   146: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: putfield 43	com/allinone/free/activity/RecommendActivity:recommendurl	Ljava/lang/String;
    //   155: ldc 97
    //   157: new 99	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 189
    //   163: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_0
    //   167: getfield 47	com/allinone/free/activity/RecommendActivity:url_id	Ljava/lang/String;
    //   170: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   179: pop
    //   180: return
    //   181: astore_3
    //   182: aload_3
    //   183: invokevirtual 192	org/json/JSONException:printStackTrace	()V
    //   186: goto -119 -> 67
    //   189: aload_0
    //   190: ldc 194
    //   192: putfield 43	com/allinone/free/activity/RecommendActivity:recommendurl	Ljava/lang/String;
    //   195: ldc 97
    //   197: ldc 196
    //   199: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   202: pop
    //   203: return
    //   204: astore 4
    //   206: return
    //   207: aload_0
    //   208: getfield 49	com/allinone/free/activity/RecommendActivity:myid	Ljava/lang/String;
    //   211: ldc 45
    //   213: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifne -36 -> 180
    //   219: ldc 97
    //   221: new 99	java/lang/StringBuilder
    //   224: dup
    //   225: ldc 202
    //   227: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 49	com/allinone/free/activity/RecommendActivity:myid	Ljava/lang/String;
    //   234: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 118	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   243: pop
    //   244: aload_0
    //   245: new 99	java/lang/StringBuilder
    //   248: dup
    //   249: ldc 187
    //   251: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 49	com/allinone/free/activity/RecommendActivity:myid	Ljava/lang/String;
    //   258: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: putfield 43	com/allinone/free/activity/RecommendActivity:recommendurl	Ljava/lang/String;
    //   267: return
    //
    // Exception table:
    //   from	to	target	type
    //   32	67	181	org/json/JSONException
    //   67	180	204	java/lang/Exception
    //   189	203	204	java/lang/Exception
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
        RecommendActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void init()
  {
    this.net_hint_img_recom = ((ImageView)findViewById(2131231011));
    this.net_hint_img_recom.setVisibility(8);
    this.recomwebivew = ((WebView)findViewById(2131231010));
    this.recommendmore = ((ImageView)findViewById(2131231000));
    this.recommendtext = ((TextView)findViewById(2131231009));
    this.progressWheel = ((ProgressWheel)findViewById(2131230812));
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(this);
    this.spnetworkre = getSharedPreferences("network", 0);
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.recommendtext.setTypeface(typeFace);
    publicTools.make_path_ready(Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache");
    String str = Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache";
    WebSettings localWebSettings = this.recomwebivew.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setCacheMode(-1);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAppCachePath(str);
    localWebSettings.setDatabasePath(str);
    localWebSettings.setAppCacheEnabled(true);
    try
    {
      if (Myutils.setting_json.getInt("run_times") == 1)
        publicTools.set_a_random_user_agent();
      this.recomwebivew.getSettings().setUserAgentString(Myutils.setting_json.getString("agent"));
      this.recomwebivew.addJavascriptInterface(new scriptInterface(this), "RecommendActivity");
      this.headers = new HashMap();
      this.headers.put("AIOD", "1");
      this.headers.put("Referer", publicTools.get_a_random_user_webview());
      this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
      this.webviewclient = new Mywebview();
      this.recomwebivew.setWebViewClient(this.webviewclient);
      this.recomwebivew.loadUrl(this.recommendurl, this.headers);
      Log.v("qqq", this.recommendurl);
      this.recommendmore.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (!publicTools.isNetworkAvailable(RecommendActivity.this))
          {
            final NointentDialog localNointentDialog = new NointentDialog(RecommendActivity.this, 2131165279);
            localNointentDialog.setCanceledOnTouchOutside(false);
            localNointentDialog.show();
            Button localButton1 = (Button)localNointentDialog.findViewById(2131230944);
            Button localButton2 = (Button)localNointentDialog.findViewById(2131230945);
            localButton1.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                localNointentDialog.dismiss();
              }
            });
            localButton2.setOnClickListener(new View.OnClickListener()
            {
              public void onClick(View paramAnonymous2View)
              {
                RecommendActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                localNointentDialog.dismiss();
              }
            });
            return;
          }
          RecommendActivity.this.net_hint_img_recom.setVisibility(8);
          RecommendActivity.this.recomwebivew.loadUrl(RecommendActivity.this.recommendurl, RecommendActivity.this.headers);
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
          new RecommendActivity.scriptInterface(RecommendActivity.this, RecommendActivity.this.getApplicationContext()).i_report_fail(paramAnonymousMessage.getData().getString("type"), paramAnonymousMessage.getData().getString("id"));
          Log.v("aaaa", "11111111111");
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
    Log.v("aaaa", str2);
    new HashMap();
    HashMap localHashMap = this.default_options;
    localHashMap.put("show_header", Integer.valueOf(1));
    localHashMap.put("redirect", Integer.valueOf(0));
    String str3 = publicTools.getDataFromURL(str2, localHashMap);
    String str4 = "";
    Matcher localMatcher = Pattern.compile("Location: ([^\n\r\t]+)").matcher(str3);
    if (localMatcher.find())
      str4 = localMatcher.group(1);
    Log.v("bbbb", str4);
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
    Log.v("lklk", str4);
    localDownloadMovieItem.setDownloadState(Integer.valueOf(4));
    localDownloadMovieItem.setMovieName(paramString2);
    localDownloadMovieItem.setMovieHeadImagePath(paramString3);
    localDownloadMovieItem.setFile_id(paramString1);
    localDownloadMovieItem.setType("app");
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

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903118);
    this.publictools = new publicTools(getApplicationContext());
    setmContext(this);
    try
    {
      this.myid = getIntent().getStringExtra("myid");
      label51: Recommed_Url();
      init();
      initView();
      this.default_options = new HashMap();
      this.default_options.put("save_cookie", Integer.valueOf(0));
      this.default_options.put("send_cookie", Integer.valueOf(0));
      this.default_options.put("show_header", Integer.valueOf(0));
      this.default_options.put("redirect", Integer.valueOf(1));
      myhandler();
      return;
    }
    catch (Exception localException)
    {
      break label51;
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

  public class Mywebview extends WebViewClient
  {
    public Mywebview()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      RecommendActivity.this.progressWheel.setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      RecommendActivity.this.progressWheel.setVisibility(0);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      RecommendActivity.this.net_hint_img_recom.setVisibility(0);
      RecommendActivity.this.recomwebivew.loadData("", "text/html", "UTF-8");
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
      if ((RecommendActivity.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(RecommendActivity.this.getApplicationContext()) != 1))
      {
        RecommendActivity.this.downwifi();
        return;
      }
      if (RecommendActivity.this.dbUtils.queryfile(paramString1) == null)
      {
        RecommendActivity.this.MydownloadApk(paramString1, paramString2, paramString3);
        return;
      }
      RecommendActivity.this.Mydialog();
    }

    @JavascriptInterface
    public void i_download_app_google(String paramString)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + paramString));
      RecommendActivity.this.startActivity(localIntent);
    }

    @JavascriptInterface
    public void i_get_search_result(String paramString, int paramInt)
    {
      String str = publicTools.getDataFromURL(paramString, RecommendActivity.this.default_options);
      Log.v("cvcv", "1111" + str);
      RecommendActivity.this.recomwebivew.loadUrl("javascript:i_parse_search_result('" + str + "','" + paramInt + "');");
    }

    @JavascriptInterface
    public void i_go_to_app_detail(String paramString)
    {
      Intent localIntent = new Intent(RecommendActivity.this, AppDetailActivity.class);
      localIntent.putExtra("appdetail_url", paramString);
      RecommendActivity.this.startActivity(localIntent);
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
 * Qualified Name:     com.allinone.free.activity.RecommendActivity
 * JD-Core Version:    0.6.2
 */