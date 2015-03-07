package com.allinone.free.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.allinone.free.adapter.RingtoneAdapter;
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

public class RingtoneFragment extends Fragment
{
  private RingtoneAdapter adapter = null;
  private ImageView charingtone;
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
        RingtoneFragment.this.currenttime.setText(Player.formatTime(RingtoneFragment.this.player.mediaPlayer.getCurrentPosition()));
        return;
      }
      catch (Exception localException)
      {
      }
    }
  };
  boolean isAlarm = false;
  boolean isMusic = false;
  boolean isNotification = false;
  boolean isRingtone = false;
  private Boolean istag = Boolean.valueOf(true);
  private List<DownloadMovieItem> listdd;
  private BroadcastReceiver mBroadcastReceiver_delete = new BroadcastReceiver()
  {
    private int pos;

    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      this.pos = paramAnonymousIntent.getIntExtra("position", 0);
      new AlertDialog.Builder(RingtoneFragment.this.getActivity()).setTitle(RingtoneFragment.this.getString(2131099715)).setMessage(RingtoneFragment.this.getString(2131099723) + ((DownloadMovieItem)RingtoneFragment.this.listdd.get(this.pos)).getFilePath() + "?").setNegativeButton(RingtoneFragment.this.getString(2131099722), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          paramAnonymous2DialogInterface.dismiss();
        }
      }).setPositiveButton(RingtoneFragment.this.getString(2131099723), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          RingtoneFragment.this.dbUtils.deletefile(((DownloadMovieItem)RingtoneFragment.this.listdd.get(RingtoneFragment.1.this.pos)).getFile_id());
          File localFile = new File(((DownloadMovieItem)RingtoneFragment.this.listdd.get(RingtoneFragment.1.this.pos)).getFilePath());
          if (localFile.exists())
            localFile.delete();
          RingtoneFragment.this.listdd.remove(RingtoneFragment.1.this.pos);
          RingtoneFragment.this.adapter.notifyDataSetChanged();
        }
      }).show();
    }
  };
  private PopupWindow mWindow;
  private SeekBar musicProgress;
  private RelativeLayout playbarringtone;
  private Player player;
  private ImageView playpauseringtone;
  private ListView ringtone_lv;
  private TextView ringtonenotice;
  private BroadcastReceiver ringtoneplay = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      final String str1 = paramAnonymousIntent.getStringExtra("ringtoneposition");
      String str2 = paramAnonymousIntent.getStringExtra("ringtonepositiontitle");
      RingtoneFragment.this.title.setText(str2);
      RingtoneFragment.this.playbarringtone.setVisibility(0);
      new Thread(new Runnable()
      {
        public void run()
        {
          Looper.prepare();
          RingtoneFragment.this.player.playUrl(str1);
          RingtoneFragment.this.timer = new Timer();
          RingtoneFragment.this.task = new TimerTask()
          {
            public void run()
            {
              Message localMessage = new Message();
              localMessage.what = 100;
              RingtoneFragment.this.handler.sendMessage(localMessage);
            }
          };
          RingtoneFragment.this.timer.schedule(RingtoneFragment.this.task, 0L, 1000L);
        }
      }).start();
    }
  };

  @SuppressLint({"ShowToast"})
  private BroadcastReceiver ringtonesuccessful = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      List localList = RingtoneFragment.this.listdd;
      Myutils.getInstance();
      localList.add(Myutils.successItem);
      RingtoneFragment.this.ringtone_lv.setAdapter(RingtoneFragment.this.adapter);
      RingtoneFragment.this.adapter.notifyDataSetChanged();
    }
  };
  BroadcastReceiver showBroadcast = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      RingtoneFragment.this.totaltime.setText(Player.formatTime(RingtoneFragment.this.player.mediaPlayer.getDuration()));
    }
  };
  private BroadcastReceiver stopringtone = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      RingtoneFragment.this.charingtone.performClick();
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
    this.playpauseringtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RingtoneFragment.this.istag.booleanValue())
        {
          RingtoneFragment.this.player.pause();
          RingtoneFragment.this.playpauseringtone.setBackgroundResource(2130837730);
          RingtoneFragment.this.istag = Boolean.valueOf(false);
          return;
        }
        RingtoneFragment.this.player.play();
        RingtoneFragment.this.playpauseringtone.setBackgroundResource(2130837732);
        RingtoneFragment.this.istag = Boolean.valueOf(true);
      }
    });
    this.charingtone.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RingtoneFragment.this.player.mediaPlayer.isPlaying())
        {
          RingtoneFragment.this.player.pause();
          RingtoneFragment.this.playpauseringtone.setBackgroundResource(2130837732);
          RingtoneFragment.this.istag = Boolean.valueOf(true);
          RingtoneFragment.this.playbarringtone.setVisibility(8);
          return;
        }
        RingtoneFragment.this.playpauseringtone.setBackgroundResource(2130837732);
        RingtoneFragment.this.istag = Boolean.valueOf(true);
        RingtoneFragment.this.playbarringtone.setVisibility(8);
      }
    });
  }

  private void init(View paramView)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("ringtone", "timesort");
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.ringtonenotice = ((TextView)paramView.findViewById(2131231031));
    this.ringtone_lv = ((ListView)paramView.findViewById(2131231030));
    this.adapter = new RingtoneAdapter(getActivity(), this.listdd);
    this.ringtone_lv.setAdapter(this.adapter);
    this.playpauseringtone = ((ImageView)paramView.findViewById(2131231033));
    this.charingtone = ((ImageView)paramView.findViewById(2131231034));
    this.playbarringtone = ((RelativeLayout)paramView.findViewById(2131231032));
    this.totaltime = ((TextView)paramView.findViewById(2131230841));
    this.currenttime = ((TextView)paramView.findViewById(2131230839));
    this.title = ((TextView)paramView.findViewById(2131230836));
    this.musicProgress = ((SeekBar)paramView.findViewById(2131230840));
  }

  public void RingtoneSort(String paramString)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("ringtone", paramString);
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.ringtone_lv = ((ListView)this.view.findViewById(2131231030));
    this.adapter = new RingtoneAdapter(getActivity(), this.listdd);
    this.ringtone_lv.setAdapter(this.adapter);
  }

  public void Ringtonedeletall()
  {
    this.dbUtils.deleteallfile("ringtone");
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
    this.view = paramLayoutInflater.inflate(2130903124, null, false);
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("ringtonedelete");
    getActivity().registerReceiver(this.mBroadcastReceiver_delete, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("ringtonesuccessful");
    getActivity().registerReceiver(this.ringtonesuccessful, localIntentFilter2);
    IntentFilter localIntentFilter3 = new IntentFilter();
    localIntentFilter3.addAction("ringtoneplay");
    getActivity().registerReceiver(this.ringtoneplay, localIntentFilter3);
    IntentFilter localIntentFilter4 = new IntentFilter();
    localIntentFilter4.addAction("show");
    getActivity().registerReceiver(this.showBroadcast, localIntentFilter4);
    IntentFilter localIntentFilter5 = new IntentFilter();
    localIntentFilter5.addAction("mp3play");
    getActivity().registerReceiver(this.stopringtone, localIntentFilter5);
    init(this.view);
    buildLister();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ringtone_lv.getLayoutParams();
    localLayoutParams.setMargins(0, 0, 0, 140);
    this.ringtone_lv.setLayoutParams(localLayoutParams);
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
      this.ringtonenotice.setVisibility(8);
    while (true)
    {
      this.adapter.notifyDataSetChanged();
      MobclickAgent.onResume(getActivity());
      return;
      this.ringtonenotice.setVisibility(0);
    }
  }

  public void setRingtone(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 3:
    case 5:
    case 6:
    default:
    case 1:
    case 2:
    case 4:
    case 7:
    }
    while (true)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_data", paramString);
      localContentValues.put("mime_type", "audio/*");
      localContentValues.put("is_ringtone", Boolean.valueOf(this.isRingtone));
      localContentValues.put("is_notification", Boolean.valueOf(this.isNotification));
      localContentValues.put("is_alarm", Boolean.valueOf(this.isAlarm));
      localContentValues.put("is_music", Boolean.valueOf(this.isMusic));
      Uri localUri1 = MediaStore.Audio.Media.getContentUriForPath(paramString);
      Uri localUri2 = getActivity().getContentResolver().insert(localUri1, localContentValues);
      RingtoneManager.setActualDefaultRingtoneUri(getActivity(), 1, localUri2);
      return;
      this.isAlarm = true;
      continue;
      this.isNotification = true;
      continue;
      this.isRingtone = true;
      this.isMusic = true;
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
      this.progress = (paramInt * RingtoneFragment.this.player.mediaPlayer.getDuration() / paramSeekBar.getMax());
    }

    public void onStartTrackingTouch(SeekBar paramSeekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      RingtoneFragment.this.player.mediaPlayer.seekTo(this.progress);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.fragments.RingtoneFragment
 * JD-Core Version:    0.6.2
 */