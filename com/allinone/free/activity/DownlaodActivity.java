package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadFile;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.DownloadTask;
import com.allinone.free.mydownload.DownloadTask.OnDeleteTaskListener;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class DownlaodActivity extends Activity
  implements ContentValue
{
  private static Typeface typeFace = null;
  private MyApplcation app;
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  private HashMap<String, Integer> default_options;
  private DisplayMetrics displayMetrics;
  private Button downloadapk;
  private TextView downloaddestv;
  private TextView downloading;
  private LinearLayout downloading_pp;
  private TextView downloadingnotice;
  private ImageView downloadmore;
  private List<DownloadMovieItem> ds;
  private SharedPreferences.Editor edit;
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
        Toast.makeText(DownlaodActivity.this, "Failed to connect server.", 0).show();
        return;
      case 2:
        DownlaodActivity.this.Mydialog();
        return;
      case 3:
      }
      Toast.makeText(DownlaodActivity.this, "'" + DownlaodActivity.this.ppmodel.getTitle() + "' is added to download queue.", 0).show();
    }
  };
  private String imgurl;
  private RelativeLayout l1;
  private RelativeLayout l2;
  private RelativeLayout l3;
  private LinearLayout listview_lin;
  private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      Log.v("mymy", "mBroadcastReceiver");
      DownloadMovieItem localDownloadMovieItem = DownlaodActivity.this.getMyApp().getStartDownloadMovieItem();
      View localView = DownlaodActivity.this.getLayoutInflater().inflate(2130903102, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131230953);
      String str = localDownloadMovieItem.getMovieHeadImagePath();
      DownlaodActivity.this.app.asyncLoadImage(str, localImageView);
      localDownloadMovieItem.setDownloadState(Integer.valueOf(7));
      DownlaodActivity.this.listview_lin.addView(localView);
      new DownloadTask(DownlaodActivity.this.getmContext(), localView, localDownloadMovieItem, false).setOnDeleteTaskListener(new DownlaodActivity.DeleteTask(DownlaodActivity.this, DownlaodActivity.this.listview_lin));
      Log.v("aaa", "///////开启下载任务*************");
    }
  };
  private Context mContext;
  private PopupWindow mWindow;
  private MyApplcation myApp;
  private TextView popularauthortitle;
  private ImageView popularicon;
  private RatingBar popularrating;
  private TextView populartitle;
  private DownloadMovieItem ppmodel;
  private ProgressWheel progress_wheel;
  private int screenWidth;
  private TextView shot_dec;
  private SharedPreferences sp;
  private SharedPreferences spnetworkre;
  private BroadcastReceiver successful = new BroadcastReceiver()
  {
    public void onReceive(final Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (DownlaodActivity.this.dbUtils == null)
        DownlaodActivity.this.dbUtils = new TypeDbUtils(paramAnonymousContext);
      new Thread(new Runnable()
      {
        public void run()
        {
          Looper.prepare();
          DownloadMovieItem localDownloadMovieItem = DownlaodActivity.this.getMyApp().getDownloadSuccess();
          DownlaodActivity.this.dbUtils.insertApk(localDownloadMovieItem.getFile_id(), localDownloadMovieItem.getType(), localDownloadMovieItem.getMovieName(), localDownloadMovieItem.getMovieHeadImagePath(), localDownloadMovieItem.getFileSize(), localDownloadMovieItem.getFilePath(), localDownloadMovieItem.getCreate_time());
          FinalDBChen localFinalDBChen = new FinalDBChen(DownlaodActivity.this.getmContext(), "download.db");
          String[] arrayOfString = new String[1];
          arrayOfString[0] = localDownloadMovieItem.getFile_id();
          localFinalDBChen.deleteItem("downloadtask", "file_id=?", arrayOfString);
          Toast.makeText(paramAnonymousContext, localDownloadMovieItem.getMovieName() + DownlaodActivity.this.getString(2131099701), 1).show();
        }
      }).start();
    }
  };
  String type = "pause";

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

  private void buildListenrn()
  {
    View localView = LayoutInflater.from(this).inflate(2130903085, null);
    this.l1 = ((RelativeLayout)localView.findViewById(2131230892));
    this.l2 = ((RelativeLayout)localView.findViewById(2131230893));
    this.l3 = ((RelativeLayout)localView.findViewById(2131230894));
    this.mWindow = new PopupWindow(localView);
    getWindowManager().getDefaultDisplay().getHeight();
    int i = getWindowManager().getDefaultDisplay().getWidth();
    this.mWindow.setWidth(50 + i / 2);
    this.mWindow.setHeight(-2);
    this.mWindow.setFocusable(true);
    this.mWindow.setAnimationStyle(2131165282);
    ColorDrawable localColorDrawable = new ColorDrawable(0);
    this.mWindow.setBackgroundDrawable(localColorDrawable);
    this.downloadmore.setOnClickListener(new View.OnClickListener()
    {
      @SuppressLint({"NewApi"})
      public void onClick(View paramAnonymousView)
      {
        DownlaodActivity.this.mWindow.showAtLocation(paramAnonymousView, 53, 0, DisplayUtil.dip2px(DownlaodActivity.this.getApplicationContext(), 14.0F));
      }
    });
    this.l1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownlaodActivity.this.type = "pause";
        Intent localIntent = new Intent();
        localIntent.setAction("downloadingbBroadcastReceiver");
        localIntent.putExtra("type", DownlaodActivity.this.type);
        DownlaodActivity.this.sendBroadcast(localIntent);
        DownlaodActivity.this.mWindow.dismiss();
      }
    });
    this.l2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownlaodActivity.this.type = "resume";
        Intent localIntent = new Intent();
        localIntent.setAction("downloadingbBroadcastReceiver");
        localIntent.putExtra("type", DownlaodActivity.this.type);
        DownlaodActivity.this.sendBroadcast(localIntent);
        DownlaodActivity.this.mWindow.dismiss();
      }
    });
    this.l3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new AlertDialog.Builder(DownlaodActivity.this.getmContext()).setTitle(DownlaodActivity.this.getString(2131099715)).setMessage(DownlaodActivity.this.getString(2131099726)).setPositiveButton(2131099723, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            DownlaodActivity.this.type = "delete";
            Intent localIntent = new Intent();
            localIntent.setAction("downloadingbBroadcastReceiver");
            localIntent.putExtra("type", DownlaodActivity.this.type);
            DownlaodActivity.this.sendBroadcast(localIntent);
            DownlaodActivity.this.mWindow.dismiss();
          }
        }).setNegativeButton(2131099722, new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
          }
        }).show();
      }
    });
  }

  private void download_file()
  {
    Iterator localIterator;
    if (this.ds.size() != 0)
      localIterator = this.ds.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      DownloadMovieItem localDownloadMovieItem = (DownloadMovieItem)localIterator.next();
      View localView = getLayoutInflater().inflate(2130903102, null);
      this.listview_lin.addView(localView);
      ProgressBar localProgressBar = (ProgressBar)localView.findViewById(2131230956);
      this.displayMetrics = getResources().getDisplayMetrics();
      this.screenWidth = this.displayMetrics.widthPixels;
      Log.v("vbvb", this.screenWidth);
      if (this.screenWidth < 500)
      {
        ViewGroup.LayoutParams localLayoutParams = localProgressBar.getLayoutParams();
        localLayoutParams.width = 186;
        localProgressBar.setLayoutParams(localLayoutParams);
      }
      ((TextView)localView.findViewById(2131230954)).setText(localDownloadMovieItem.getMovieName());
      String str1 = localDownloadMovieItem.getFileSize();
      TextView localTextView1 = (TextView)localView.findViewById(2131230958);
      TextView localTextView2 = (TextView)localView.findViewById(2131230955);
      ImageView localImageView = (ImageView)localView.findViewById(2131230953);
      this.imgurl = localDownloadMovieItem.getMovieHeadImagePath();
      Log.v("mmm", "****" + this.imgurl);
      this.app.asyncLoadImage(this.imgurl, localImageView);
      double d = 0.0D;
      try
      {
        if ((!str1.equals("")) && (str1 != null))
        {
          if (str1.contains("MB"))
          {
            str1 = str1.replace("MB", "").trim();
            d = 1024.0D * Double.parseDouble(str1);
          }
        }
        else
        {
          label316: if (d >= 200.0D)
            break label569;
          localTextView1.setText("Invalid");
          localTextView1.setTextColor(Color.parseColor("#f39801"));
        }
        while (true)
        {
          long l = localDownloadMovieItem.getCurrentProgress().longValue();
          String str2 = Formatter.formatFileSize(getmContext(), l);
          if (str1.contains("null"))
            str1 = "0.00B";
          localTextView2.setText(str2 + "/" + str1);
          Button localButton = (Button)localView.findViewById(2131230959);
          localProgressBar.setMax((int)localDownloadMovieItem.getProgressCount().longValue());
          localProgressBar.setProgress((int)l);
          if (localButton.getVisibility() == 4)
            localButton.setVisibility(0);
          localBoolean = Boolean.valueOf(false);
          i = 0;
          Myutils.getInstance();
          if (i < Myutils.list.size())
            break label586;
          if (localBoolean.booleanValue())
            break;
          Log.v("aaa", "2222222222222");
          DownloadTask localDownloadTask2 = new DownloadTask(getmContext(), localView, localDownloadMovieItem, true);
          DeleteTask localDeleteTask2 = new DeleteTask(this.listview_lin);
          localDownloadTask2.setOnDeleteTaskListener(localDeleteTask2);
          break;
          str1 = str1.replace("KB", "").trim();
          d = Double.parseDouble(str1);
          break label316;
          label569: localTextView1.setText(localDownloadMovieItem.getPercentage());
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          Boolean localBoolean;
          int i;
          continue;
          label586: Myutils.getInstance();
          if (((DownloadMovieItem)Myutils.list.get(i)).getDownloadUrl().equals(localDownloadMovieItem.getDownloadUrl()))
          {
            Log.v("aaa", "1111111111111");
            DownloadTask localDownloadTask1 = new DownloadTask(getmContext(), localView, localDownloadMovieItem, false);
            DeleteTask localDeleteTask1 = new DeleteTask(this.listview_lin);
            localDownloadTask1.setOnDeleteTaskListener(localDeleteTask1);
            localBoolean = Boolean.valueOf(true);
          }
          i++;
        }
      }
    }
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
        DownlaodActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
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
    this.downloading_pp = ((LinearLayout)findViewById(2131230890));
    this.populartitle = ((TextView)findViewById(2131231004));
    this.popularicon = ((ImageView)findViewById(2131231002));
    this.popularauthortitle = ((TextView)findViewById(2131231005));
    this.popularrating = ((RatingBar)findViewById(2131231006));
    this.shot_dec = ((TextView)findViewById(2131231007));
    this.downloadapk = ((Button)findViewById(2131230828));
    this.googleplay = ((Button)findViewById(2131230829));
    this.downloaddestv = ((TextView)findViewById(2131230891));
    this.downloadapk.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DownlaodActivity.this.downloadingnotice.setVisibility(8);
        DownlaodActivity.this.downloading_pp.setVisibility(8);
        DownlaodActivity.this.downloaddestv.setVisibility(8);
        new Thread(new Runnable()
        {
          public void run()
          {
            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=" + DownlaodActivity.this.ppmodel.getId() + "&from=apk");
          }
        }).start();
        if ((DownlaodActivity.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(DownlaodActivity.this.getApplicationContext()) != 1))
        {
          DownlaodActivity.this.downwifi();
          return;
        }
        if (DownlaodActivity.this.dbUtils.queryfile(DownlaodActivity.this.ppmodel.getId()) == null)
        {
          DownlaodActivity.this.MydownloadApk(DownlaodActivity.this.ppmodel.getId(), DownlaodActivity.this.ppmodel.getTitle(), DownlaodActivity.this.ppmodel.getIcon());
          return;
        }
        DownlaodActivity.this.Mydialog();
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
            publicTools.getUrl("http://android.downloadatoz.com/_201409/market/hits.php?type=app&id=" + DownlaodActivity.this.ppmodel.getId() + "&from=google");
          }
        }).start();
        Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + DownlaodActivity.this.ppmodel.getId()));
        DownlaodActivity.this.startActivity(localIntent);
      }
    });
    this.downloading = ((TextView)findViewById(2131230885));
    this.downloadingnotice = ((TextView)findViewById(2131230887));
    this.downloadmore = ((ImageView)findViewById(2131230886));
    if (typeFace == null)
    {
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
      this.downloading.setTypeface(typeFace);
    }
  }

  private void pplistViewbottom()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.downloading_pp.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, DisplayUtil.dip2px(getApplicationContext(), 94.0F));
    this.downloading_pp.setLayoutParams(localLayoutParams);
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
          DownlaodActivity.this.handler.sendMessage(localMessage1);
          return null;
        }
        if (DownlaodActivity.this.db.findItemsByWhereAndWhereValue("downloadUrl", str1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
        {
          Message localMessage2 = new Message();
          localMessage2.what = 2;
          DownlaodActivity.this.handler.sendMessage(localMessage2);
          return null;
        }
        String str2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + DownlaodActivity.this.getPackageName(), paramString1 + ".apk").getAbsolutePath();
        this.d.setDownloadUrl(str1);
        this.d.setFilePath(str2);
        Log.v("lklk", str1);
        this.d.setDownloadState(Integer.valueOf(4));
        this.d.setMovieName(paramString2);
        this.d.setMovieHeadImagePath(paramString3);
        this.d.setFile_id(paramString1);
        this.d.setType("app");
        this.d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
        DownlaodActivity.this.toDownload(this.d);
        Myutils.getInstance();
        Myutils.list.add(this.d);
        Message localMessage3 = new Message();
        localMessage3.what = 3;
        DownlaodActivity.this.handler.sendMessage(localMessage3);
        return null;
      }

      protected void onPostExecute(Void paramAnonymousVoid)
      {
        super.onPostExecute(paramAnonymousVoid);
        DownlaodActivity.this.progress_wheel.setVisibility(8);
      }

      protected void onPreExecute()
      {
        super.onPreExecute();
        DownlaodActivity.this.progress_wheel.setVisibility(0);
        this.options = DownlaodActivity.this.default_options;
        this.options.put("show_header", Integer.valueOf(1));
        this.options.put("redirect", Integer.valueOf(0));
        Log.v("re", "///////" + this.url);
      }
    }
    .execute(new Void[0]);
  }

  public boolean getBooleanValueByConfigFile(String paramString)
  {
    return getSp().getBoolean(paramString, false);
  }

  public SharedPreferences.Editor getEdit()
  {
    return this.edit;
  }

  public int getIntegerValueByConfigFile(String paramString)
  {
    return getSp().getInt(paramString, -1);
  }

  public MyApplcation getMyApp()
  {
    return this.myApp;
  }

  public SharedPreferences getSp()
  {
    return this.sp;
  }

  public String getStringValueByConfigFile(String paramString)
  {
    return this.sp.getString(paramString, "");
  }

  public Context getmContext()
  {
    return this.mContext;
  }

  public void initView()
  {
    this.listview_lin = ((LinearLayout)findViewById(2131230889));
    MyApplcation localMyApplcation = (MyApplcation)getApplication();
    setSp(getSharedPreferences("config", 0));
    this.edit = getSp().edit();
    setMyApp(localMyApplcation);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903084);
    setmContext(this);
    initView();
    init();
    pplistViewbottom();
    try
    {
      this.app = ((MyApplcation)getApplicationContext());
      label46: IntentFilter localIntentFilter1 = new IntentFilter();
      localIntentFilter1.addAction("download");
      registerReceiver(this.mBroadcastReceiver, localIntentFilter1);
      IntentFilter localIntentFilter2 = new IntentFilter();
      localIntentFilter2.addAction("successful");
      registerReceiver(this.successful, localIntentFilter2);
      this.db = new FinalDBChen(getmContext(), getDatabasePath("download.db").getAbsolutePath());
      this.ds = this.db.findItemsByWhereAndWhereValue(null, null, DownloadMovieItem.class, "downloadtask", null);
      Log.v("mymy", "数据库中已经存在的数据" + this.ds.size());
      download_file();
      Myutils.getInstance();
      Myutils.list.clear();
      buildListenrn();
      init();
      return;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt)
      return false;
    return super.onKeyDown(paramInt, paramKeyEvent);
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
    this.ds = this.db.findItemsByWhereAndWhereValue(null, null, DownloadMovieItem.class, "downloadtask", null);
    if (this.ds.size() != 0)
    {
      this.downloading_pp.setVisibility(8);
      this.downloadingnotice.setVisibility(8);
      this.downloaddestv.setVisibility(8);
    }
    while (true)
    {
      new Mya1().execute(new Void[0]);
      return;
      this.downloading_pp.setVisibility(0);
      this.downloadingnotice.setVisibility(0);
      this.downloaddestv.setVisibility(0);
    }
  }

  public boolean putBooleanValueToConfigFile(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getSp().edit();
    localEditor.putBoolean(paramString, paramBoolean);
    return localEditor.commit();
  }

  public boolean putStringValueToConfigFile(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = getSp().edit();
    localEditor.putInt(paramString, paramInt);
    return localEditor.commit();
  }

  public boolean putStringValueToConfigFile(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = getSp().edit();
    localEditor.putString(paramString1, paramString2);
    return localEditor.commit();
  }

  public void setEdit(SharedPreferences.Editor paramEditor)
  {
    this.edit = paramEditor;
  }

  public void setMyApp(MyApplcation paramMyApplcation)
  {
    this.myApp = paramMyApplcation;
  }

  public void setSp(SharedPreferences paramSharedPreferences)
  {
    this.sp = paramSharedPreferences;
  }

  public void setmContext(Context paramContext)
  {
    this.mContext = paramContext;
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

  class DeleteTask
    implements DownloadTask.OnDeleteTaskListener
  {
    private LinearLayout lin;

    public DeleteTask(LinearLayout arg2)
    {
      Object localObject;
      this.lin = localObject;
    }

    public void onDelete(final View paramView, final DownloadMovieItem paramDownloadMovieItem, Boolean paramBoolean)
    {
      if (paramBoolean.booleanValue())
      {
        this.lin.removeView(paramView);
        DownloadFile localDownloadFile = paramDownloadMovieItem.getDownloadFile();
        if (localDownloadFile != null)
          localDownloadFile.stopDownload();
        File localFile = new File(paramDownloadMovieItem.getFilePath());
        if (localFile.exists())
          localFile.delete();
        FinalDBChen localFinalDBChen = new FinalDBChen(DownlaodActivity.this.getmContext(), "download.db");
        String[] arrayOfString = new String[1];
        arrayOfString[0] = paramDownloadMovieItem.getFile_id();
        localFinalDBChen.deleteItem("downloadtask", "file_id=?", arrayOfString);
        return;
      }
      new AlertDialog.Builder(DownlaodActivity.this.getmContext()).setTitle(DownlaodActivity.this.getString(2131099715)).setMessage(DownlaodActivity.this.getString(2131099721)).setNegativeButton(DownlaodActivity.this.getString(2131099722), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
        }
      }).setPositiveButton(DownlaodActivity.this.getString(2131099723), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          DownlaodActivity.DeleteTask.this.lin.removeView(paramView);
          DownloadFile localDownloadFile = paramDownloadMovieItem.getDownloadFile();
          if (localDownloadFile != null)
            localDownloadFile.stopDownload();
          File localFile = new File(paramDownloadMovieItem.getFilePath());
          if (localFile.exists())
            localFile.delete();
          FinalDBChen localFinalDBChen = new FinalDBChen(DownlaodActivity.this.getmContext(), "download.db");
          String[] arrayOfString = new String[1];
          arrayOfString[0] = paramDownloadMovieItem.getMovieName();
          localFinalDBChen.deleteItem("downloadtask", "movieName=?", arrayOfString);
        }
      }).show();
    }
  }

  class Mya1 extends AsyncTask<Void, Void, String>
  {
    Mya1()
    {
    }

    protected String doInBackground(Void[] paramArrayOfVoid)
    {
      String str;
      if (publicTools.isNetworkAvailable(DownlaodActivity.this))
      {
        str = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/recommend_list_more.php");
        if (str == null);
      }
      try
      {
        localJSONObject1 = new JSONObject(str);
        if (localJSONObject1.getInt("status") == 1)
          DownlaodActivity.this.ppmodel = new DownloadMovieItem();
      }
      catch (JSONException localJSONException)
      {
        try
        {
          JSONObject localJSONObject1;
          if (!localJSONObject1.isNull("pdt"))
          {
            JSONObject localJSONObject2 = localJSONObject1.getJSONObject("pdt");
            DownlaodActivity.this.ppmodel.setId(localJSONObject2.getString("id"));
            DownlaodActivity.this.ppmodel.setIcon(localJSONObject2.getString("icon"));
            DownlaodActivity.this.ppmodel.setTitle(localJSONObject2.getString("title"));
            DownlaodActivity.this.ppmodel.setAuthor_title(localJSONObject2.getString("author_title"));
            DownlaodActivity.this.ppmodel.setShort_desc(localJSONObject2.getString("short_desc"));
            DownlaodActivity.this.ppmodel.setRating(Float.valueOf(Float.parseFloat(localJSONObject2.getString("rating"))));
          }
          while (true)
          {
            label178: return str;
            return null;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
          }
        }
        catch (Exception localException)
        {
          break label178;
        }
      }
    }

    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (paramString == null)
        return;
      DownlaodActivity.this.progress_wheel.setVisibility(8);
      try
      {
        DownlaodActivity.this.app.asyncLoadImage(DownlaodActivity.this.ppmodel.getIcon(), DownlaodActivity.this.popularicon);
        DownlaodActivity.this.populartitle.setText(DownlaodActivity.this.ppmodel.getTitle());
        DownlaodActivity.this.popularauthortitle.setText(DownlaodActivity.this.ppmodel.getAuthor_title());
        DownlaodActivity.this.popularrating.setRating(DownlaodActivity.this.ppmodel.getRating().floatValue());
        DownlaodActivity.this.shot_dec.setText(DownlaodActivity.this.ppmodel.getShort_desc());
        return;
      }
      catch (Exception localException)
      {
      }
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      DownlaodActivity.this.progress_wheel.setVisibility(0);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.DownlaodActivity
 * JD-Core Version:    0.6.2
 */