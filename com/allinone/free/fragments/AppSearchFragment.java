package com.allinone.free.fragments;

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
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.allinone.free.activity.AppDetailsActivity;
import com.allinone.free.adapter.AppsearchFragmentAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.refresh.PullableListView.OnLoadListener;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;

public class AppSearchFragment extends BaseFragment
  implements PullableListView.OnLoadListener, OnDismissCallback
{
  private AppsearchFragmentAdapter adapter;
  private BroadcastReceiver appsearch = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      AppSearchFragment.this.list.clear();
      ((RelativeLayout)AppSearchFragment.this.listView.findViewById(2131230960)).setVisibility(8);
      AppSearchFragment.this.listView.setVisibility(8);
      new AppSearchFragment.Mya1(AppSearchFragment.this).execute(new Void[0]);
    }
  };
  private FinalDBChen db;
  private TypeDbUtils dbUtils = null;
  private HashMap<String, Integer> default_options;
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
        Toast.makeText(AppSearchFragment.this.getActivity(), "Failed to connect server.", 0).show();
        return;
      case 2:
        AppSearchFragment.this.Mydialog();
        return;
      case 3:
      }
      Toast.makeText(AppSearchFragment.this.getActivity(), "'" + AppSearchFragment.this.sp2.getString("apptitlesearch", "this app") + "' is added to download queue.", 0).show();
    }
  };
  private HashMap<String, String> headers;
  private ArrayList<DownloadMovieItem> list = new ArrayList();
  private PullableListView listView;
  private int next = 1;
  private int page = 1;
  private ProgressWheel progressWheel = null;
  private publicTools publictools = null;
  private SharedPreferences sp2;
  private SharedPreferences spnetworkre;
  private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;

  private void AppsearchlistViewbottom()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50.0F));
    this.listView.setLayoutParams(localLayoutParams);
  }

  private void Mydialog()
  {
    new AlertDialog.Builder(getActivity()).setTitle(getString(2131099715)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    }).show();
  }

  private void ShowResult(String paramString)
  {
    this.list.addAll(Myutils.parseApplist(paramString));
    if (this.page == 1)
    {
      this.adapter = new AppsearchFragmentAdapter(getActivity(), this.list);
      this.listView.setAdapter(this.adapter);
      this.swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(this.adapter);
      this.swingBottomInAnimationAdapter.setListView(this.listView);
      this.listView.setAdapter(this.swingBottomInAnimationAdapter);
    }
    this.listView.setHasMoreData(true);
    this.progressWheel.setVisibility(8);
    this.adapter.notifyDataSetChanged();
  }

  private void downwifi()
  {
    final LianwangDialog localLianwangDialog = new LianwangDialog(getActivity(), 2131165279);
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
        AppSearchFragment.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  private void failfile()
  {
    publicTools.app_search_handler = new Handler()
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
              publicTools.getUrl("http://android.downloadatoz.com/_201409/market/report_fail.php?type=" + AppSearchFragment.3.this.type + "&id=" + AppSearchFragment.3.this.id);
              Log.v("yyy", "-------http://android.downloadatoz.com/_201409/market/report_fail.php?type=" + AppSearchFragment.3.this.type + "&id=" + AppSearchFragment.3.this.id);
            }
          }).start();
        }
      }
    };
  }

  @SuppressLint({"NewApi"})
  private void init(View paramView)
  {
    this.sp2 = getActivity().getSharedPreferences("datasearch", 0);
    this.publictools = new publicTools(getActivity());
    this.headers = new HashMap();
    this.headers.put("AIOD", "1");
    this.headers.put("Referer", publicTools.get_a_random_user_webview());
    this.default_options = new HashMap();
    this.default_options.put("save_cookie", Integer.valueOf(0));
    this.default_options.put("send_cookie", Integer.valueOf(0));
    this.default_options.put("show_header", Integer.valueOf(0));
    this.default_options.put("redirect", Integer.valueOf(1));
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.spnetworkre = getActivity().getSharedPreferences("network", 0);
    this.db = new FinalDBChen(getmContext(), getActivity().getDatabasePath("download.db").getAbsolutePath());
    this.progressWheel = ((ProgressWheel)paramView.findViewById(2131230812));
    this.listView = ((PullableListView)paramView.findViewById(2131230831));
    this.listView.setOnLoadListener(this);
    this.listView.setHasMoreData(false);
    new Mya1().execute(new Void[0]);
    this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Intent localIntent = new Intent(AppSearchFragment.this.getActivity(), AppDetailsActivity.class);
        localIntent.putExtra("id", ((DownloadMovieItem)AppSearchFragment.this.list.get(paramAnonymousInt)).getId());
        AppSearchFragment.this.startActivity(localIntent);
      }
    });
  }

  private void myhandler()
  {
    publicTools.appsearchhandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 780:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          String str1 = paramAnonymousMessage.getData().getString("appid");
          String str2 = paramAnonymousMessage.getData().getString("apptitle");
          AppSearchFragment.this.sp2.edit().putString("apptitlesearch", str2).commit();
          String str3 = paramAnonymousMessage.getData().getString("appicon");
          if ((AppSearchFragment.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(AppSearchFragment.this.getActivity()) != 1))
          {
            AppSearchFragment.this.downwifi();
            return;
          }
          if (AppSearchFragment.this.dbUtils.queryfile(str1) == null)
          {
            AppSearchFragment.this.MydownloadApk(str1, str2, str3);
            Log.v("sq", "MydownloadApk");
          }
          else
          {
            Toast.makeText(AppSearchFragment.this.getActivity(), "It has been in downloading list already.", 1).show();
          }
        }
      }
    };
  }

  public void MydownloadApk(final String paramString1, final String paramString2, final String paramString3)
  {
    String str = publicTools.getCode(paramString1);
    if (str.equals(""))
    {
      Toast.makeText(getActivity(), "Failed to connect server. Please try again.", 0).show();
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
        Log.v("re", "///////" + this.content);
        String str1 = "";
        Matcher localMatcher = Pattern.compile("Location: ([^\n\r\t]+)").matcher(this.content);
        if (localMatcher.find())
          str1 = localMatcher.group(1);
        Log.v("bbbb", str1);
        if (str1.equals(""))
        {
          Message localMessage1 = new Message();
          localMessage1.what = 1;
          AppSearchFragment.this.handler.sendMessage(localMessage1);
          return null;
        }
        if (AppSearchFragment.this.db.findItemsByWhereAndWhereValue("downloadUrl", str1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
        {
          Message localMessage2 = new Message();
          localMessage2.what = 2;
          AppSearchFragment.this.handler.sendMessage(localMessage2);
          return null;
        }
        String str2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + AppSearchFragment.this.getActivity().getPackageName(), paramString1 + ".apk").getAbsolutePath();
        this.d.setDownloadUrl(str1);
        this.d.setFilePath(str2);
        Log.v("fefe", str1);
        this.d.setDownloadState(Integer.valueOf(4));
        this.d.setMovieName(paramString2);
        this.d.setMovieHeadImagePath(paramString3);
        this.d.setFile_id(paramString1);
        this.d.setType("app");
        this.d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
        AppSearchFragment.this.toDownload(this.d);
        Myutils.getInstance();
        Myutils.list.add(this.d);
        Message localMessage3 = new Message();
        localMessage3.what = 3;
        AppSearchFragment.this.handler.sendMessage(localMessage3);
        return null;
      }

      protected void onPostExecute(Void paramAnonymousVoid)
      {
        super.onPostExecute(paramAnonymousVoid);
        AppSearchFragment.this.progressWheel.setVisibility(8);
      }

      protected void onPreExecute()
      {
        super.onPreExecute();
        AppSearchFragment.this.progressWheel.setVisibility(0);
        this.options = AppSearchFragment.this.default_options;
        this.options.put("show_header", Integer.valueOf(1));
        this.options.put("redirect", Integer.valueOf(0));
        Log.v("re", "///////" + this.url);
      }
    }
    .execute(new Void[0]);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903071, null, false);
    setmContext(getActivity());
    Myutils.getInstance();
    Myutils.type_current = "app_search";
    init(localView);
    initView();
    myhandler();
    failfile();
    AppsearchlistViewbottom();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("appsearch");
    getActivity().registerReceiver(this.appsearch, localIntentFilter);
    return localView;
  }

  public void onDismiss(ListView paramListView, int[] paramArrayOfInt)
  {
  }

  public void onLoad(PullableListView paramPullableListView)
  {
    if (this.list.size() > 0)
    {
      this.next = ((DownloadMovieItem)this.list.get(-1 + this.list.size())).getHas_next_page();
      Log.v("wew", this.next);
    }
    if (this.next == 1)
    {
      this.page = (1 + this.page);
      new Mya1().execute(new Void[0]);
      return;
    }
    this.listView.setHasMoreData(false);
    Log.v("wew", "setHasMoreData" + this.next);
  }

  public void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(getActivity());
  }

  public void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(getActivity());
  }

  public void toDownload(DownloadMovieItem paramDownloadMovieItem)
  {
    paramDownloadMovieItem.setDownloadState(Integer.valueOf(7));
    getMyApp().setStartDownloadMovieItem(paramDownloadMovieItem);
    getActivity().sendBroadcast(new Intent().setAction("download"));
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

  class Mya1 extends AsyncTask<Void, Void, String>
  {
    private Boolean is_expired = Boolean.valueOf(false);
    private Boolean is_tag = Boolean.valueOf(true);
    private SharedPreferences sp;

    Mya1()
    {
    }

    protected String doInBackground(Void[] paramArrayOfVoid)
    {
      StringBuilder localStringBuilder = new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_more.php?keyword=");
      Myutils.getInstance();
      return publicTools.getUrl(Myutils.searchkeywords + "&page=" + AppSearchFragment.this.page);
    }

    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (paramString == null)
        return;
      AppSearchFragment.this.ShowResult(paramString);
      ((RelativeLayout)AppSearchFragment.this.listView.findViewById(2131230960)).setVisibility(0);
      AppSearchFragment.this.listView.setVisibility(0);
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      AppSearchFragment.this.progressWheel.setVisibility(0);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.fragments.AppSearchFragment
 * JD-Core Version:    0.6.2
 */