package com.allinone.free.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.allinone.free.adapter.Mp3Adapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.Player;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Mp3Fragment extends Fragment
{
  private Mp3Adapter adapter = null;
  private ImageView champ3;
  TextView currenttime;
  private TypeDbUtils dbUtils = null;
  Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      switch (paramAnonymousMessage.what)
      {
      default:
        return;
      case 100:
      }
      try
      {
        Mp3Fragment.this.currenttime.setText(Player.formatTime(Mp3Fragment.this.player.mediaPlayer.getCurrentPosition()));
        return;
      }
      catch (Exception localException)
      {
      }
    }
  };
  private Boolean istag = Boolean.valueOf(true);
  private List<DownloadMovieItem> listdd;
  private BroadcastReceiver mBroadcastReceiver_delete = new BroadcastReceiver()
  {
    private int pos;

    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      this.pos = paramAnonymousIntent.getIntExtra("position", 0);
      new AlertDialog.Builder(Mp3Fragment.this.getActivity()).setTitle(Mp3Fragment.this.getString(2131099715)).setMessage(Mp3Fragment.this.getString(2131099723) + ((DownloadMovieItem)Mp3Fragment.this.listdd.get(this.pos)).getFilePath() + "?").setNegativeButton(Mp3Fragment.this.getString(2131099722), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          paramAnonymous2DialogInterface.dismiss();
        }
      }).setPositiveButton(Mp3Fragment.this.getString(2131099723), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          Mp3Fragment.this.dbUtils.deletefile(((DownloadMovieItem)Mp3Fragment.this.listdd.get(Mp3Fragment.1.this.pos)).getFile_id());
          File localFile = new File(((DownloadMovieItem)Mp3Fragment.this.listdd.get(Mp3Fragment.1.this.pos)).getFilePath());
          if (localFile.exists())
            localFile.delete();
          Mp3Fragment.this.listdd.remove(Mp3Fragment.1.this.pos);
          Mp3Fragment.this.adapter.notifyDataSetChanged();
        }
      }).show();
    }
  };
  private ListView mp3_lv;
  private TextView mp3notice;
  private BroadcastReceiver mp3play = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      final String str1 = paramAnonymousIntent.getStringExtra("mp3position");
      String str2 = paramAnonymousIntent.getStringExtra("mp3positiontitle");
      Mp3Fragment.this.title.setText(str2);
      Mp3Fragment.this.playbarmp3.setVisibility(0);
      new Thread(new Runnable()
      {
        public void run()
        {
          Looper.prepare();
          Mp3Fragment.this.player.playUrl(str1);
          Mp3Fragment.this.timer = new Timer();
          Mp3Fragment.this.task = new TimerTask()
          {
            public void run()
            {
              Message localMessage = new Message();
              localMessage.what = 100;
              Mp3Fragment.this.handler.sendMessage(localMessage);
            }
          };
          Mp3Fragment.this.timer.schedule(Mp3Fragment.this.task, 0L, 1000L);
        }
      }).start();
    }
  };

  @SuppressLint({"ShowToast"})
  private BroadcastReceiver mp3successful = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      List localList = Mp3Fragment.this.listdd;
      Myutils.getInstance();
      localList.add(Myutils.successItem);
      Mp3Fragment.this.mp3_lv.setAdapter(Mp3Fragment.this.adapter);
      Mp3Fragment.this.adapter.notifyDataSetChanged();
    }
  };
  private SeekBar musicProgress;
  private RelativeLayout playbarmp3;
  private Player player;
  private ImageView playpausemp3;
  BroadcastReceiver showBroadcast = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      try
      {
        Mp3Fragment.this.totaltime.setText(Player.formatTime(Mp3Fragment.this.player.mediaPlayer.getDuration()));
        return;
      }
      catch (Exception localException)
      {
      }
    }
  };
  private BroadcastReceiver stopmp3 = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      Mp3Fragment.this.champ3.performClick();
    }
  };
  private TimerTask task;
  private Timer timer;
  TextView title;
  TextView totaltime;
  private View view;

  private void buildLister()
  {
    this.musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
    this.player = new Player(getActivity(), this.musicProgress);
    this.playpausemp3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Mp3Fragment.this.istag.booleanValue())
        {
          Mp3Fragment.this.player.pause();
          Mp3Fragment.this.playpausemp3.setBackgroundResource(2130837730);
          Mp3Fragment.this.istag = Boolean.valueOf(false);
          return;
        }
        Mp3Fragment.this.player.play();
        Mp3Fragment.this.playpausemp3.setBackgroundResource(2130837732);
        Mp3Fragment.this.istag = Boolean.valueOf(true);
      }
    });
    this.champ3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (Mp3Fragment.this.player.mediaPlayer.isPlaying())
        {
          Mp3Fragment.this.player.pause();
          Mp3Fragment.this.playpausemp3.setBackgroundResource(2130837732);
          Mp3Fragment.this.istag = Boolean.valueOf(true);
          Mp3Fragment.this.playbarmp3.setVisibility(8);
          return;
        }
        Mp3Fragment.this.playpausemp3.setBackgroundResource(2130837732);
        Mp3Fragment.this.istag = Boolean.valueOf(true);
        Mp3Fragment.this.playbarmp3.setVisibility(8);
      }
    });
  }

  private void init(View paramView)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("mp3", "timesort");
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.mp3_lv = ((ListView)paramView.findViewById(2131230979));
    this.mp3notice = ((TextView)paramView.findViewById(2131230980));
    this.adapter = new Mp3Adapter(getActivity(), this.listdd);
    this.mp3_lv.setAdapter(this.adapter);
    this.playpausemp3 = ((ImageView)paramView.findViewById(2131230982));
    this.champ3 = ((ImageView)paramView.findViewById(2131230983));
    this.playbarmp3 = ((RelativeLayout)paramView.findViewById(2131230981));
    this.totaltime = ((TextView)paramView.findViewById(2131230841));
    this.currenttime = ((TextView)paramView.findViewById(2131230839));
    this.title = ((TextView)paramView.findViewById(2131230836));
    this.musicProgress = ((SeekBar)paramView.findViewById(2131230840));
  }

  public void Mp3Sort(String paramString)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("mp3", paramString);
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.mp3_lv = ((ListView)this.view.findViewById(2131230979));
    this.adapter = new Mp3Adapter(getActivity(), this.listdd);
    this.mp3_lv.setAdapter(this.adapter);
  }

  public void Mp3deletall()
  {
    this.dbUtils.deleteallfile("mp3");
    for (int i = 0; ; i++)
    {
      if (i >= this.listdd.size())
      {
        this.listdd.removeAll(this.listdd);
        this.adapter.notifyDataSetChanged();
        return;
      }
      File localFile = new File(((DownloadMovieItem)this.listdd.get(i)).getFilePath());
      if (localFile.exists())
        localFile.delete();
    }
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.view = paramLayoutInflater.inflate(2130903108, null, false);
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("mp3delete");
    getActivity().registerReceiver(this.mBroadcastReceiver_delete, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("mp3successful");
    getActivity().registerReceiver(this.mp3successful, localIntentFilter2);
    IntentFilter localIntentFilter3 = new IntentFilter();
    localIntentFilter3.addAction("mp3play");
    getActivity().registerReceiver(this.mp3play, localIntentFilter3);
    IntentFilter localIntentFilter4 = new IntentFilter();
    localIntentFilter4.addAction("show");
    getActivity().registerReceiver(this.showBroadcast, localIntentFilter4);
    IntentFilter localIntentFilter5 = new IntentFilter();
    localIntentFilter5.addAction("ringtoneplay");
    getActivity().registerReceiver(this.stopmp3, localIntentFilter5);
    init(this.view);
    buildLister();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mp3_lv.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 140);
    this.mp3_lv.setLayoutParams(localLayoutParams);
    return this.view;
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
    if (this.player.mediaPlayer.isPlaying())
    {
      this.player.pause();
      this.player.stop();
    }
    if (this.player != null)
      this.player = null;
  }

  public void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(getActivity());
  }

  public void onResume()
  {
    super.onResume();
    if (this.listdd.size() > 0)
      this.mp3notice.setVisibility(8);
    this.adapter.notifyDataSetChanged();
    MobclickAgent.onResume(getActivity());
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
      this.progress = (paramInt * Mp3Fragment.this.player.mediaPlayer.getDuration() / paramSeekBar.getMax());
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      Mp3Fragment.this.player.mediaPlayer.seekTo(this.progress);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.fragments.Mp3Fragment
 * JD-Core Version:    0.6.2
 */