package com.allinone.free.fragments;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.allinone.free.adapter.VideoAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ValidFragment"})
public class VideoFragment extends Fragment
{
  private VideoAdapter adapter = null;
  private TextView appnotice;
  private TypeDbUtils dbUtils = null;
  private List<DownloadMovieItem> listdd;
  private BroadcastReceiver mBroadcastReceiver_delete = new BroadcastReceiver()
  {
    private int pos;

    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      this.pos = paramAnonymousIntent.getIntExtra("position", 0);
      new AlertDialog.Builder(VideoFragment.this.getActivity()).setTitle(VideoFragment.this.getString(2131099715)).setMessage(VideoFragment.this.getString(2131099723) + ((DownloadMovieItem)VideoFragment.this.listdd.get(this.pos)).getFilePath() + "?").setNegativeButton(VideoFragment.this.getString(2131099722), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          paramAnonymous2DialogInterface.dismiss();
        }
      }).setPositiveButton(VideoFragment.this.getString(2131099723), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          VideoFragment.this.dbUtils.deletefile(((DownloadMovieItem)VideoFragment.this.listdd.get(VideoFragment.1.this.pos)).getFile_id());
          File localFile = new File(((DownloadMovieItem)VideoFragment.this.listdd.get(VideoFragment.1.this.pos)).getFilePath());
          if (localFile.exists())
            localFile.delete();
          VideoFragment.this.listdd.remove(VideoFragment.1.this.pos);
          VideoFragment.this.adapter.notifyDataSetChanged();
        }
      }).show();
    }
  };
  private ListView video_lv;
  private BroadcastReceiver videosuccessful = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      List localList = VideoFragment.this.listdd;
      Myutils.getInstance();
      localList.add(Myutils.successItem);
      VideoFragment.this.video_lv.setAdapter(VideoFragment.this.adapter);
      VideoFragment.this.adapter.notifyDataSetChanged();
    }
  };
  private View view;

  private void init(View paramView)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("video", "timesort");
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.appnotice = ((TextView)paramView.findViewById(2131231079));
    this.video_lv = ((ListView)paramView.findViewById(2131231078));
    this.adapter = new VideoAdapter(getActivity(), this.listdd);
    this.video_lv.setAdapter(this.adapter);
  }

  public void VideoSort(String paramString)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("video", paramString);
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.video_lv = ((ListView)this.view.findViewById(2131231078));
    this.adapter = new VideoAdapter(getActivity(), this.listdd);
    this.video_lv.setAdapter(this.adapter);
  }

  public void Videodeletall()
  {
    this.dbUtils.deleteallfile("video");
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
    this.view = paramLayoutInflater.inflate(2130903141, null, false);
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("videodelete");
    getActivity().registerReceiver(this.mBroadcastReceiver_delete, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("videosuccessful");
    getActivity().registerReceiver(this.videosuccessful, localIntentFilter2);
    init(this.view);
    return this.view;
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
      this.appnotice.setVisibility(8);
    this.adapter.notifyDataSetChanged();
    MobclickAgent.onResume(getActivity());
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.fragments.VideoFragment
 * JD-Core Version:    0.6.2
 */