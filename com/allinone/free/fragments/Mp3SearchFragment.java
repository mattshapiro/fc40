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
import android.media.MediaPlayer;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import com.allinone.free.adapter.Mp3searchFragmentAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.dialog.LianwangDialog;
import com.allinone.free.model.Model;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.mydownload.MyApplcation;
import com.allinone.free.refresh.PullableListView;
import com.allinone.free.refresh.PullableListView.OnLoadListener;
import com.allinone.free.utils.DisplayUtil;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.NetWorkUtil;
import com.allinone.free.utils.Player;
import com.allinone.free.utils.ProgressWheel;
import com.allinone.free.utils.publicTools;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONException;
import org.json.JSONObject;

public class Mp3SearchFragment extends BaseFragment
  implements PullableListView.OnLoadListener, OnDismissCallback, View.OnClickListener
{
  private Mp3searchFragmentAdapter adapter;
  private ImageView cha;
  private TextView currenttime;
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
      case 300:
      }
      while (true)
      {
        return;
        try
        {
          Mp3SearchFragment.this.currenttime.setText(Player.formatTime(Mp3SearchFragment.this.player.mediaPlayer.getCurrentPosition()));
          if (Mp3SearchFragment.this.playbar.getVisibility() == 8)
          {
            Mp3SearchFragment.this.player.pause();
            return;
          }
        }
        catch (Exception localException)
        {
        }
      }
    }
  };
  private Boolean istag = Boolean.valueOf(true);
  private ArrayList<DownloadMovieItem> list = new ArrayList();
  private PullableListView listView;
  private Model model;
  private BroadcastReceiver mp3search = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      Mp3SearchFragment.this.list.clear();
      ((RelativeLayout)Mp3SearchFragment.this.listView.findViewById(2131230960)).setVisibility(8);
      Mp3SearchFragment.this.listView.setVisibility(8);
      new Mp3SearchFragment.Mya1(Mp3SearchFragment.this).execute(new Void[0]);
    }
  };
  private SeekBar musicProgress;
  int mytotaltime = 0;
  private int next = 1;
  private int page = 1;
  private RelativeLayout playbar;
  private Player player;
  private ImageView playpause;
  private ProgressWheel progressWheel = null;
  private publicTools publictools = null;
  BroadcastReceiver showBroadcast = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      Mp3SearchFragment.this.totaltime.setText(Player.formatTime(Mp3SearchFragment.this.player.mediaPlayer.getDuration()));
      Mp3SearchFragment.this.mytotaltime = Mp3SearchFragment.this.player.mediaPlayer.getDuration();
      Mp3SearchFragment.this.getActivity().unregisterReceiver(this);
    }
  };
  private SharedPreferences spnetworkre;
  private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
  private TimerTask task;
  private Timer timer;
  private TextView title;
  private TextView totaltime;

  private void Mp3searchlistViewbottom()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.listView.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50.0F));
    this.listView.setLayoutParams(localLayoutParams);
  }

  private void Mp3searchplaybarbottom()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.playbar.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, DisplayUtil.dip2px(getActivity(), 50.0F));
    this.playbar.setLayoutParams(localLayoutParams);
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
    this.list.addAll(Myutils.parseMp3list(paramString));
    if (this.page == 1)
    {
      this.adapter = new Mp3searchFragmentAdapter(getActivity(), this.list);
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
        Mp3SearchFragment.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
        localLianwangDialog.dismiss();
      }
    });
  }

  private void failfile()
  {
    publicTools.mp3_search_handler = new Handler()
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
              publicTools.getUrl("http://android.downloadatoz.com/_201409/market/report_fail.php?type=" + Mp3SearchFragment.5.this.type + "&id=" + Mp3SearchFragment.5.this.id);
            }
          }).start();
        }
      }
    };
  }

  @SuppressLint({"NewApi"})
  private void init(View paramView)
  {
    this.publictools = new publicTools(getActivity());
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
  }

  private void init2(View paramView)
  {
    this.playpause = ((ImageView)paramView.findViewById(2131230833));
    this.cha = ((ImageView)paramView.findViewById(2131230837));
    this.playbar = ((RelativeLayout)paramView.findViewById(2131230832));
    this.totaltime = ((TextView)paramView.findViewById(2131230841));
    this.currenttime = ((TextView)paramView.findViewById(2131230839));
    this.title = ((TextView)paramView.findViewById(2131230836));
    this.musicProgress = ((SeekBar)paramView.findViewById(2131230840));
    this.playpause.setOnClickListener(this);
    this.cha.setOnClickListener(this);
    this.musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
    this.player = new Player(getActivity(), this.musicProgress);
  }

  private void myhandler()
  {
    publicTools.mp3searchhandler = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 880:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          Log.v("jj", "1111111");
          final String str1 = paramAnonymousMessage.getData().getString("mp3id");
          final String str2 = paramAnonymousMessage.getData().getString("mp3title");
          if ((Mp3SearchFragment.this.spnetworkre.getBoolean("isopen", false)) && (NetWorkUtil.getAPNType(Mp3SearchFragment.this.getActivity()) != 1))
          {
            Mp3SearchFragment.this.downwifi();
            return;
          }
          if (Mp3SearchFragment.this.dbUtils.queryfile(str1) == null)
            new AsyncTask()
            {
              private Model model;

              protected Void doInBackground(Void[] paramAnonymous2ArrayOfVoid)
              {
                String str1 = publicTools.getUrl("http://mp3box.to/user/download/?song=" + str1);
                HashMap localHashMap = new HashMap();
                localHashMap.put("content", str1);
                Log.v("jj", "33" + str1 + "*****" + str1);
                String str2 = publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/mp3_pdt_parser.php?id=" + str1, localHashMap);
                Log.v("jj", "2222" + str2);
                try
                {
                  JSONObject localJSONObject = new JSONObject(str2);
                  if (localJSONObject.getInt("status") == 1)
                  {
                    this.model = new Model();
                    this.model.setMp3url(localJSONObject.getString("url"));
                  }
                  return null;
                }
                catch (JSONException localJSONException)
                {
                  while (true)
                    localJSONException.printStackTrace();
                }
              }

              protected void onPostExecute(Void paramAnonymous2Void)
              {
                super.onPostExecute(paramAnonymous2Void);
                try
                {
                  Mp3SearchFragment.this.MydownloadMp3AndRingtone(str1, str2, this.model.getMp3url());
                  Mp3SearchFragment.this.progressWheel.setVisibility(8);
                  return;
                }
                catch (Exception localException)
                {
                  while (true)
                    Toast.makeText(Mp3SearchFragment.this.getActivity(), Mp3SearchFragment.this.getString(2131099762), 1).show();
                }
              }

              protected void onPreExecute()
              {
                super.onPreExecute();
                Mp3SearchFragment.this.progressWheel.setVisibility(0);
              }
            }
            .execute(new Void[0]);
          else
            Mp3SearchFragment.this.Mydialog();
        }
      }
    };
  }

  public void MydownloadMp3AndRingtone(String paramString1, String paramString2, String paramString3)
  {
    DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
    if (this.db.findItemsByWhereAndWhereValue("file_id", paramString1, DownloadMovieItem.class, "downloadtask", null).size() > 0)
    {
      Mydialog();
      return;
    }
    String str = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + getActivity().getPackageName(), paramString1 + ".mp3").getAbsolutePath();
    localDownloadMovieItem.setDownloadUrl(paramString3);
    localDownloadMovieItem.setFilePath(str);
    localDownloadMovieItem.setDownloadState(Integer.valueOf(4));
    localDownloadMovieItem.setMovieName(paramString2);
    localDownloadMovieItem.setFile_id(paramString1);
    localDownloadMovieItem.setMovieHeadImagePath("http://android.downloadatoz.com/_201409/market/img/mp3.png");
    localDownloadMovieItem.setType("mp3");
    localDownloadMovieItem.setCreate_time(Long.valueOf(System.currentTimeMillis()));
    toDownload(localDownloadMovieItem);
    Myutils.getInstance();
    Myutils.list.add(localDownloadMovieItem);
    Toast.makeText(getActivity(), "'" + localDownloadMovieItem.getMovieName() + "' is added to download queue.", 0).show();
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
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903071, null, false);
    setmContext(getActivity());
    Myutils.getInstance();
    Myutils.type_current = "mp3_search";
    init(localView);
    init2(localView);
    initView();
    myhandler();
    failfile();
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("show");
    getActivity().registerReceiver(this.showBroadcast, localIntentFilter1);
    this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, final int paramAnonymousInt, long paramAnonymousLong)
      {
        SharedPreferences.Editor localEditor = Mp3SearchFragment.this.getActivity().getSharedPreferences("mp3_search_data", 0).edit();
        localEditor.putInt("mp3_search_selector", paramAnonymousInt);
        localEditor.commit();
        Mp3SearchFragment.this.playbar.setVisibility(0);
        Mp3SearchFragment.this.title.setText(((DownloadMovieItem)Mp3SearchFragment.this.list.get(paramAnonymousInt)).getTitle());
        Mp3SearchFragment.this.playpause.setBackgroundResource(2130837732);
        Log.v("rr", ((DownloadMovieItem)Mp3SearchFragment.this.list.get(paramAnonymousInt)).getId());
        new AsyncTask()
        {
          protected Void doInBackground(Void[] paramAnonymous2ArrayOfVoid)
          {
            String str1 = publicTools.getUrl("http://mp3box.to/user/download/?song=" + ((DownloadMovieItem)Mp3SearchFragment.this.list.get(paramAnonymousInt)).getId());
            HashMap localHashMap = new HashMap();
            localHashMap.put("content", str1);
            Log.v("jj", "*****" + ((DownloadMovieItem)Mp3SearchFragment.this.list.get(paramAnonymousInt)).getId());
            String str2 = publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/mp3_pdt_parser.php?id=" + ((DownloadMovieItem)Mp3SearchFragment.this.list.get(paramAnonymousInt)).getId(), localHashMap);
            Log.v("jj", "2222" + str2);
            try
            {
              JSONObject localJSONObject = new JSONObject(str2);
              if (localJSONObject.getInt("status") == 1)
              {
                Mp3SearchFragment.this.model = new Model();
                Mp3SearchFragment.this.model.setMp3url(localJSONObject.getString("url"));
              }
            }
            catch (JSONException localJSONException)
            {
              try
              {
                while (true)
                {
                  Mp3SearchFragment.this.player.playUrl(Mp3SearchFragment.this.model.getMp3url());
                  Mp3SearchFragment.this.timer = new Timer();
                  Mp3SearchFragment.this.task = new TimerTask()
                  {
                    public void run()
                    {
                      Message localMessage = new Message();
                      localMessage.what = 300;
                      Mp3SearchFragment.this.handler.sendMessage(localMessage);
                    }
                  };
                  Mp3SearchFragment.this.timer.schedule(Mp3SearchFragment.this.task, 0L, 1000L);
                  label316: return null;
                  localJSONException = localJSONException;
                  localJSONException.printStackTrace();
                }
              }
              catch (Exception localException)
              {
                break label316;
              }
            }
          }

          protected void onPostExecute(Void paramAnonymous2Void)
          {
            super.onPostExecute(paramAnonymous2Void);
            Mp3SearchFragment.this.progressWheel.setVisibility(8);
            if (paramAnonymous2Void == null);
          }

          protected void onPreExecute()
          {
            super.onPreExecute();
            Mp3SearchFragment.this.progressWheel.setVisibility(0);
          }
        }
        .execute(new Void[0]);
        Mp3SearchFragment.this.adapter.notifyDataSetChanged();
      }
    });
    Mp3searchlistViewbottom();
    Mp3searchplaybarbottom();
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("mp3search");
    getActivity().registerReceiver(this.mp3search, localIntentFilter2);
    return localView;
  }

  public void onDestroy()
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
    try
    {
      this.player.pause();
      this.player.stop();
      label57: if (this.player != null)
        this.player = null;
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
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
    Log.v("mymy", "ssssss");
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
      StringBuilder localStringBuilder = new StringBuilder("http://mp3box.to/search?q=");
      Myutils.getInstance();
      String str1 = Myutils.searchkeywords + "&page=" + Mp3SearchFragment.this.page;
      String str2 = publicTools.getUrl(str1);
      Log.v("ttt", "url=" + str1);
      Log.v("ttt", "content=" + str2);
      HashMap localHashMap = new HashMap();
      localHashMap.put("content", str2);
      String str3 = publicTools.doHttpPost("http://android.downloadatoz.com/_201409/market/mp3_list_more_parser.php", localHashMap);
      Log.v("ttt", str3);
      return str3;
    }

    protected void onPostExecute(String paramString)
    {
      super.onPostExecute(paramString);
      if (paramString == null)
        return;
      Mp3SearchFragment.this.ShowResult(paramString);
      ((RelativeLayout)Mp3SearchFragment.this.listView.findViewById(2131230960)).setVisibility(0);
      Mp3SearchFragment.this.listView.setVisibility(0);
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      Mp3SearchFragment.this.progressWheel.setVisibility(0);
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
        this.progress = (paramInt * Mp3SearchFragment.this.player.mediaPlayer.getDuration() / paramSeekBar.getMax());
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
      Mp3SearchFragment.this.player.mediaPlayer.seekTo(this.progress);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.fragments.Mp3SearchFragment
 * JD-Core Version:    0.6.2
 */