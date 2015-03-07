package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.adapter.PopularFragmentAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.mydownload.BaseActivity;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
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

public class PopularActivity extends BaseActivity
{
  private static Typeface typeFace = null;
  private PopularFragmentAdapter adapter;
  private MyApplcation app;
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  private HashMap<String, Integer> default_options;
  private Button downloadapk;
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
        Toast.makeText(PopularActivity.this, "Failed to connect server.", 0).show();
        return;
      case 2:
        PopularActivity.this.Mydialog();
        return;
      case 3:
      }
      Myutils.getInstance();
      if (Myutils.istagpp.booleanValue())
      {
        Toast.makeText(PopularActivity.this, "'" + PopularActivity.this.sp.getString("apptitlePP", "this app") + "' is added to download queue.", 0).show();
        return;
      }
      Toast.makeText(PopularActivity.this, "'" + PopularActivity.this.ppmodel.getTitle() + "' is added to download queue.", 0).show();
    }
  };
  private ArrayList<DownloadMovieItem> list;
  private String myid = null;
  private TextView popular;
  private TextView popularauthortitle;
  private ImageView popularicon;
  private ListView popularlv;
  private RatingBar popularrating;
  private TextView populartitle;
  private Boolean ppapk = Boolean.valueOf(false);
  private DownloadMovieItem ppmodel;
  private ProgressWheel progressWheel = null;
  private publicTools publictools = null;
  private ImageView recommendmore;
  private String recommendurl = null;
  private TextView shot_dec;
  private SharedPreferences sp;
  private SharedPreferences spnetworkre;
  private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
  private String url_id = "";

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
    //   0: ldc 130
    //   2: new 132	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 134
    //   8: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 76	com/allinone/free/activity/PopularActivity:myid	Ljava/lang/String;
    //   15: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: invokestatic 151	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   24: pop
    //   25: aload_0
    //   26: getfield 76	com/allinone/free/activity/PopularActivity:myid	Ljava/lang/String;
    //   29: ifnonnull +178 -> 207
    //   32: getstatic 157	com/allinone/free/utils/Myutils:setting_json	Lorg/json/JSONObject;
    //   35: ldc 159
    //   37: invokevirtual 165	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   40: iconst_1
    //   41: if_icmpne +26 -> 67
    //   44: ldc 166
    //   46: ldc 168
    //   48: invokestatic 151	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   51: pop
    //   52: getstatic 157	com/allinone/free/utils/Myutils:setting_json	Lorg/json/JSONObject;
    //   55: ldc 170
    //   57: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   60: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   63: pop
    //   64: invokestatic 183	com/allinone/free/utils/Myutils:saveSetting	()V
    //   67: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   70: getstatic 157	com/allinone/free/utils/Myutils:setting_json	Lorg/json/JSONObject;
    //   73: ldc 170
    //   75: invokevirtual 187	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   78: lsub
    //   79: ldc2_w 188
    //   82: lcmp
    //   83: ifge +106 -> 189
    //   86: aload_0
    //   87: invokevirtual 193	com/allinone/free/activity/PopularActivity:getResources	()Landroid/content/res/Resources;
    //   90: ldc 194
    //   92: invokevirtual 200	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   95: astore 6
    //   97: aload 6
    //   99: invokevirtual 206	java/io/InputStream:available	()I
    //   102: newarray byte
    //   104: astore 7
    //   106: aload 6
    //   108: aload 7
    //   110: invokevirtual 210	java/io/InputStream:read	([B)I
    //   113: pop
    //   114: aload 6
    //   116: invokevirtual 213	java/io/InputStream:close	()V
    //   119: aload_0
    //   120: new 215	java/lang/String
    //   123: dup
    //   124: aload 7
    //   126: invokespecial 218	java/lang/String:<init>	([B)V
    //   129: putfield 74	com/allinone/free/activity/PopularActivity:url_id	Ljava/lang/String;
    //   132: aload_0
    //   133: new 132	java/lang/StringBuilder
    //   136: dup
    //   137: ldc 220
    //   139: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 74	com/allinone/free/activity/PopularActivity:url_id	Ljava/lang/String;
    //   146: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: putfield 78	com/allinone/free/activity/PopularActivity:recommendurl	Ljava/lang/String;
    //   155: ldc 130
    //   157: new 132	java/lang/StringBuilder
    //   160: dup
    //   161: ldc 222
    //   163: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload_0
    //   167: getfield 78	com/allinone/free/activity/PopularActivity:recommendurl	Ljava/lang/String;
    //   170: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 151	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   179: pop
    //   180: return
    //   181: astore_3
    //   182: aload_3
    //   183: invokevirtual 225	org/json/JSONException:printStackTrace	()V
    //   186: goto -119 -> 67
    //   189: aload_0
    //   190: ldc 227
    //   192: putfield 78	com/allinone/free/activity/PopularActivity:recommendurl	Ljava/lang/String;
    //   195: ldc 130
    //   197: ldc 229
    //   199: invokestatic 151	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   202: pop
    //   203: return
    //   204: astore 4
    //   206: return
    //   207: aload_0
    //   208: getfield 76	com/allinone/free/activity/PopularActivity:myid	Ljava/lang/String;
    //   211: ldc 72
    //   213: invokevirtual 233	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   216: ifne -36 -> 180
    //   219: ldc 130
    //   221: new 132	java/lang/StringBuilder
    //   224: dup
    //   225: ldc 235
    //   227: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: aload_0
    //   231: getfield 76	com/allinone/free/activity/PopularActivity:myid	Ljava/lang/String;
    //   234: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 151	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   243: pop
    //   244: aload_0
    //   245: new 132	java/lang/StringBuilder
    //   248: dup
    //   249: ldc 220
    //   251: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 76	com/allinone/free/activity/PopularActivity:myid	Ljava/lang/String;
    //   258: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: putfield 78	com/allinone/free/activity/PopularActivity:recommendurl	Ljava/lang/String;
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
        PopularActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  private void failfile()
  {
    publicTools.popular_handler = new Handler()
    {
      private String id;
      private String type;

      public void handleMessage(Message paramAnonymousMessage)
      {
        this.type = paramAnonymousMessage.getData().getString("type");
        this.id = paramAnonymousMessage.getData().getString("id");
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
              publicTools.getUrl("http://android.downloadatoz.com/_201409/market/report_fail.php?type=" + PopularActivity.3.this.type + "&id=" + PopularActivity.3.this.id);
            }
          }).start();
        }
      }
    };
  }

  private void init()
  {
    this.publictools = new publicTools(this);
    this.popular = ((TextView)findViewById(2131230999));
    typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.popular.setTypeface(typeFace);
    this.sp = getSharedPreferences("data4", 0);
    this.default_options = new HashMap();
    this.default_options.put("save_cookie", Integer.valueOf(0));
    this.default_options.put("send_cookie", Integer.valueOf(0));
    this.default_options.put("show_header", Integer.valueOf(0));
    this.default_options.put("redirect", Integer.valueOf(1));
    this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
    this.spnetworkre = getSharedPreferences("network", 0);
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(this);
    this.recommendmore = ((ImageView)findViewById(2131231000));
    this.app = ((MyApplcation)getApplicationContext());
    this.progressWheel = ((ProgressWheel)findViewById(2131230812));
    View localView = View.inflate(this, 2130903117, null);
    this.populartitle = ((TextView)localView.findViewById(2131231004));
    this.popularicon = ((ImageView)localView.findViewById(2131231002));
    this.popularauthortitle = ((TextView)localView.findViewById(2131231005));
    this.popularrating = ((RatingBar)localView.findViewById(2131231006));
    this.shot_dec = ((TextView)localView.findViewById(2131231007));
    this.downloadapk = ((Button)localView.findViewById(2131230828));
    this.googleplay = ((Button)localView.findViewById(2131230829));
    this.popularlv = ((ListView)findViewById(2131231001));
    new Mya1().execute(new Void[0]);
    this.popularlv.addHeaderView(localView, null, false);
    this.popularlv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Intent localIntent = new Intent(PopularActivity.this, AppDetailsActivity.class);
        localIntent.putExtra("id", ((DownloadMovieItem)PopularActivity.this.list.get(paramAnonymousInt - 1)).getId());
        PopularActivity.this.startActivity(localIntent);
      }
    });
    this.downloadapk.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Myutils.getInstance();
        Myutils.istagpp = Boolean.valueOf(false);
        new Thread(new Runnable()
        {
          public void run()
          {
            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=" + PopularActivity.this.ppmodel.getId() + "&from=apk");
          }
        }).start();
        if ((PopularActivity.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(PopularActivity.this.getApplicationContext()) != 1))
        {
          PopularActivity.this.downwifi();
          return;
        }
        if (PopularActivity.this.dbUtils.queryfile(PopularActivity.this.ppmodel.getId()) == null)
        {
          PopularActivity.this.MydownloadApk(PopularActivity.this.ppmodel.getId(), PopularActivity.this.ppmodel.getTitle(), PopularActivity.this.ppmodel.getIcon());
          PopularActivity.this.ppapk = Boolean.valueOf(true);
          return;
        }
        PopularActivity.this.Mydialog();
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
            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=" + PopularActivity.this.ppmodel.getId() + "&from=google");
          }
        }).start();
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + PopularActivity.this.ppmodel.getId()));
        PopularActivity.this.startActivity(localIntent);
      }
    });
    this.recommendmore.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new PopularActivity.Mya1(PopularActivity.this).execute(new Void[0]);
      }
    });
  }

  @SuppressLint({"HandlerLeak"})
  private void myhandler()
  {
    publicTools.popuhandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 111:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          String str1 = paramAnonymousMessage.getData().getString("appid");
          String str2 = paramAnonymousMessage.getData().getString("apptitle");
          PopularActivity.this.sp.edit().putString("apptitlePP", str2).commit();
          String str3 = paramAnonymousMessage.getData().getString("appicon");
          if ((PopularActivity.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(PopularActivity.this.getApplicationContext()) != 1))
          {
            PopularActivity.this.downwifi();
            return;
          }
          if (PopularActivity.this.dbUtils.queryfile(str1) == null)
            PopularActivity.this.MydownloadApk(str1, str2, str3);
          else
            PopularActivity.this.Mydialog();
        }
      }
    };
  }

  private void pplistViewbottom()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.popularlv.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, DisplayUtil.dip2px(getApplicationContext(), 94.0F));
    this.popularlv.setLayoutParams(localLayoutParams);
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
          PopularActivity.this.handler.sendMessage(localMessage1);
          return null;
        }
        if (PopularActivity.this.db.findItemsByWhereAndWhereValue("downloadUrl", str1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
        {
          Message localMessage2 = new Message();
          localMessage2.what = 2;
          PopularActivity.this.handler.sendMessage(localMessage2);
          return null;
        }
        String str2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + PopularActivity.this.getPackageName(), paramString1 + ".apk").getAbsolutePath();
        this.d.setDownloadUrl(str1);
        this.d.setFilePath(str2);
        Log.v("lklk", str1);
        this.d.setDownloadState(Integer.valueOf(4));
        this.d.setMovieName(paramString2);
        this.d.setMovieHeadImagePath(paramString3);
        this.d.setFile_id(paramString1);
        this.d.setType("app");
        this.d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
        PopularActivity.this.toDownload(this.d);
        Myutils.getInstance();
        Myutils.list.add(this.d);
        Message localMessage3 = new Message();
        localMessage3.what = 3;
        PopularActivity.this.handler.sendMessage(localMessage3);
        return null;
      }

      protected void onPostExecute(Void paramAnonymousVoid)
      {
        super.onPostExecute(paramAnonymousVoid);
        PopularActivity.this.progressWheel.setVisibility(8);
      }

      protected void onPreExecute()
      {
        super.onPreExecute();
        PopularActivity.this.progressWheel.setVisibility(0);
        this.options = PopularActivity.this.default_options;
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
    setContentView(2130903116);
    Recommed_Url();
    init();
    Myutils.getInstance();
    Myutils.type_current = "popularapk";
    try
    {
      this.myid = getIntent().getStringExtra("myid");
      label43: initView();
      myhandler();
      failfile();
      pplistViewbottom();
      return;
    }
    catch (Exception localException)
    {
      break label43;
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

  class Mya1 extends AsyncTask<Void, Void, ArrayList<DownloadMovieItem>>
  {
    Mya1()
    {
    }

    protected ArrayList<DownloadMovieItem> doInBackground(Void[] paramArrayOfVoid)
    {
      String str;
      if (publicTools.isNetworkAvailable(PopularActivity.this))
      {
        str = publicTools.getUrl(PopularActivity.this.recommendurl);
        PopularActivity.this.list = new ArrayList();
        if (str == null);
      }
      try
      {
        localJSONObject1 = new JSONObject(str);
        if (localJSONObject1.getInt("status") == 1)
          PopularActivity.this.ppmodel = new DownloadMovieItem();
      }
      catch (JSONException localJSONException)
      {
        try
        {
          JSONObject localJSONObject1;
          if (!localJSONObject1.isNull("pdt"))
          {
            JSONObject localJSONObject3 = localJSONObject1.getJSONObject("pdt");
            PopularActivity.this.ppmodel.setId(localJSONObject3.getString("id"));
            PopularActivity.this.ppmodel.setIcon(localJSONObject3.getString("icon"));
            PopularActivity.this.ppmodel.setTitle(localJSONObject3.getString("title"));
            PopularActivity.this.ppmodel.setAuthor_title(localJSONObject3.getString("author_title"));
            PopularActivity.this.ppmodel.setShort_desc(localJSONObject3.getString("short_desc"));
            PopularActivity.this.ppmodel.setRating(Float.valueOf(Float.parseFloat(localJSONObject3.getString("rating"))));
          }
          label197: JSONArray localJSONArray = localJSONObject1.getJSONArray("list");
          int i = 0;
          int j = localJSONArray.length();
          if (i >= j);
          while (true)
          {
            return PopularActivity.this.list;
            return null;
            DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
            JSONObject localJSONObject2 = localJSONArray.getJSONObject(i);
            localDownloadMovieItem.setId(localJSONObject2.getString("id"));
            localDownloadMovieItem.setSerial(localJSONObject2.getString("serial"));
            localDownloadMovieItem.setTitle(localJSONObject2.getString("title"));
            localDownloadMovieItem.setAuthor_title(localJSONObject2.getString("author_title"));
            localDownloadMovieItem.setIcon(localJSONObject2.getString("icon"));
            localDownloadMovieItem.setSize(localJSONObject2.getString("size"));
            localDownloadMovieItem.setRating(Float.valueOf(Float.parseFloat(localJSONObject2.getString("rating"))));
            localDownloadMovieItem.setPrice(localJSONObject2.getString("price"));
            localDownloadMovieItem.setHas_apk(localJSONObject2.getString("has_apk"));
            PopularActivity.this.list.add(localDownloadMovieItem);
            i++;
            break;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          break label197;
        }
      }
    }

    protected void onPostExecute(ArrayList<DownloadMovieItem> paramArrayList)
    {
      super.onPostExecute(paramArrayList);
      if (paramArrayList == null)
        return;
      PopularActivity.this.adapter = new PopularFragmentAdapter(PopularActivity.this, paramArrayList);
      PopularActivity.this.popularlv.setAdapter(PopularActivity.this.adapter);
      PopularActivity.this.progressWheel.setVisibility(8);
      PopularActivity.this.adapter.notifyDataSetChanged();
      try
      {
        PopularActivity.this.app.asyncLoadImage(PopularActivity.this.ppmodel.getIcon(), PopularActivity.this.popularicon);
        PopularActivity.this.populartitle.setText(PopularActivity.this.ppmodel.getTitle());
        PopularActivity.this.popularauthortitle.setText(PopularActivity.this.ppmodel.getAuthor_title());
        PopularActivity.this.popularrating.setRating(PopularActivity.this.ppmodel.getRating().floatValue());
        PopularActivity.this.shot_dec.setText(PopularActivity.this.ppmodel.getShort_desc());
        return;
      }
      catch (Exception localException)
      {
      }
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      PopularActivity.this.progressWheel.setVisibility(0);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.PopularActivity
 * JD-Core Version:    0.6.2
 */