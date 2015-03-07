package com.allinone.free.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.MyApplcation;

public class BaseFragment extends Fragment
  implements ContentValue
{
  private SharedPreferences.Editor edit;
  private Context mContext;
  private MyApplcation myApp;
  private SharedPreferences sp;

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
    MyApplcation localMyApplcation = (MyApplcation)getActivity().getApplication();
    setSp(getActivity().getSharedPreferences("config", 0));
    this.edit = getSp().edit();
    setMyApp(localMyApplcation);
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
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.fragments.BaseFragment
 * JD-Core Version:    0.6.2
 */