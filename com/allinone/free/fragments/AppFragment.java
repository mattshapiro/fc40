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
import com.allinone.free.adapter.AppAdapter;
import com.allinone.free.db.TypeDbUtils;
import com.allinone.free.mydownload.DownloadMovieItem;
import com.allinone.free.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ValidFragment"})
public class AppFragment extends Fragment
{
  private AppAdapter adapter = null;
  private ListView app_lv;
  private TextView appnotice;
  private BroadcastReceiver appsuccessful = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      List localList = AppFragment.this.listdd;
      Myutils.getInstance();
      localList.add(Myutils.successItem);
      AppFragment.this.app_lv.setAdapter(AppFragment.this.adapter);
      AppFragment.this.adapter.notifyDataSetChanged();
    }
  };
  private TypeDbUtils dbUtils = null;
  private BroadcastReceiver jingmo = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      AppFragment.this.adapter.notifyDataSetChanged();
    }
  };
  private List<DownloadMovieItem> listdd;
  private BroadcastReceiver mBroadcastReceiver_delete = new BroadcastReceiver()
  {
    private int pos;

    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      this.pos = paramAnonymousIntent.getIntExtra("position", 0);
      new AlertDialog.Builder(AppFragment.this.getActivity()).setTitle(AppFragment.this.getString(2131099715)).setMessage(AppFragment.this.getString(2131099723) + ((DownloadMovieItem)AppFragment.this.listdd.get(this.pos)).getFilePath() + "?").setNegativeButton(AppFragment.this.getString(2131099722), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          paramAnonymous2DialogInterface.dismiss();
        }
      }).setPositiveButton(AppFragment.this.getString(2131099723), new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
        {
          AppFragment.this.dbUtils.deletefile(((DownloadMovieItem)AppFragment.this.listdd.get(AppFragment.1.this.pos)).getFile_id());
          File localFile = new File(((DownloadMovieItem)AppFragment.this.listdd.get(AppFragment.1.this.pos)).getFilePath());
          if (localFile.exists())
            localFile.delete();
          AppFragment.this.listdd.remove(AppFragment.1.this.pos);
          AppFragment.this.adapter.notifyDataSetChanged();
        }
      }).show();
    }
  };
  private View view;

  private void init(View paramView)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("app", "timesort");
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.appnotice = ((TextView)paramView.findViewById(2131230855));
    this.app_lv = ((ListView)paramView.findViewById(2131230854));
    this.adapter = new AppAdapter(getActivity(), this.listdd);
    this.app_lv.setAdapter(this.adapter);
  }

  public void AppSort(String paramString)
  {
    if (this.dbUtils == null)
      this.dbUtils = new TypeDbUtils(getActivity());
    this.listdd = this.dbUtils.queryApk("app", paramString);
    if (this.listdd == null)
      this.listdd = new ArrayList();
    this.app_lv = ((ListView)this.view.findViewById(2131230854));
    this.adapter = new AppAdapter(getActivity(), this.listdd);
    this.app_lv.setAdapter(this.adapter);
  }

  public void Appdeletall()
  {
    this.dbUtils.deleteallfile("app");
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
    this.view = paramLayoutInflater.inflate(2130903074, null, false);
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("delete");
    getActivity().registerReceiver(this.mBroadcastReceiver_delete, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("appsuccessful");
    getActivity().registerReceiver(this.appsuccessful, localIntentFilter2);
    IntentFilter localIntentFilter3 = new IntentFilter();
    localIntentFilter3.addAction("jingmoanzhuang");
    getActivity().registerReceiver(this.jingmo, localIntentFilter3);
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
 * Qualified Name:     com.allinone.free.fragments.AppFragment
 * JD-Core Version:    0.6.2
 */