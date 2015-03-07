package com.allinone.free.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetWorkUtil
{
  public static int getAPNType(Context paramContext)
  {
    int i = -1;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return i;
    int j = localNetworkInfo.getType();
    if (j == 0)
    {
      Log.e("networkInfo.getExtraInfo()", "networkInfo.getExtraInfo() is " + localNetworkInfo.getExtraInfo());
      if (localNetworkInfo.getExtraInfo().toLowerCase().equals("cmnet"))
        i = 3;
    }
    while (true)
    {
      return i;
      i = 2;
      continue;
      if (j == 1)
        i = 1;
    }
  }

  public static boolean isMobileConnected(Context paramContext)
  {
    boolean bool = false;
    if (paramContext != null)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(0);
      bool = false;
      if (localNetworkInfo != null)
        bool = localNetworkInfo.isAvailable();
    }
    return bool;
  }

  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext != null)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo != null)
        return localNetworkInfo.isAvailable();
    }
    return false;
  }

  public static boolean isWifiConnected(Context paramContext)
  {
    if (paramContext != null)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1);
      if (localNetworkInfo != null)
        return localNetworkInfo.isAvailable();
    }
    return false;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.NetWorkUtil
 * JD-Core Version:    0.6.2
 */