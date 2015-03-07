package com.umeng.message.proguard;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

public class aa
{
  public static final String a = "Wi-Fi";
  public static final String b = "00-00-00-00-00-00";
  private static final String c = "NetworkUtils";
  private static ConnectivityManager d = null;
  private static final int[] e = { 4, 7, 2, 1 };

  private static String a(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (0xFF & paramInt >> 8) + "." + (0xFF & paramInt >> 16) + "." + (0xFF & paramInt >> 24);
  }

  public static boolean a(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = c(paramContext);
    if (localConnectivityManager != null)
      try
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if (localNetworkInfo != null)
        {
          boolean bool = localNetworkInfo.isConnected();
          return bool;
        }
      }
      catch (Exception localException)
      {
        Log.e("NetworkUtils", localException.toString());
      }
    while (true)
    {
      return false;
      Log.e("NetworkUtils", "connManager is null!");
    }
  }

  public static boolean b(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = c(paramContext);
    if (localConnectivityManager != null);
    while (true)
    {
      int k;
      try
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if (localNetworkInfo != null)
        {
          int i = localNetworkInfo.getSubtype();
          if (Y.a)
            Log.d("NetworkUtils", "subType:" + i + ": name:" + localNetworkInfo.getSubtypeName());
          int[] arrayOfInt = e;
          int j = arrayOfInt.length;
          k = 0;
          if (k >= j)
            break label135;
          if (arrayOfInt[k] != i)
            break label137;
          return true;
        }
        Log.e("NetworkUtils", "networkInfo is null!");
        return false;
      }
      catch (Exception localException)
      {
        Log.e("NetworkUtils", localException.toString());
        return false;
      }
      Log.e("NetworkUtils", "connManager is null!");
      label135: return false;
      label137: k++;
    }
  }

  public static ConnectivityManager c(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.e("NetworkUtils", "context is null!");
      return null;
    }
    if (d == null)
      d = (ConnectivityManager)paramContext.getSystemService("connectivity");
    return d;
  }

  public static String[] d(Context paramContext)
  {
    String[] arrayOfString = { "Unknown", "Unknown" };
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
      {
        arrayOfString[0] = "Unknown";
        return arrayOfString;
      }
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager == null)
      {
        arrayOfString[0] = "Unknown";
        return arrayOfString;
      }
      NetworkInfo localNetworkInfo1 = localConnectivityManager.getNetworkInfo(1);
      if ((localNetworkInfo1 != null) && (localNetworkInfo1.getState() == NetworkInfo.State.CONNECTED))
      {
        arrayOfString[0] = "Wi-Fi";
        return arrayOfString;
      }
      NetworkInfo localNetworkInfo2 = localConnectivityManager.getNetworkInfo(0);
      if ((localNetworkInfo2 != null) && (localNetworkInfo2.getState() == NetworkInfo.State.CONNECTED))
      {
        arrayOfString[0] = "2G/3G";
        arrayOfString[1] = localNetworkInfo2.getSubtypeName();
        return arrayOfString;
      }
    }
    catch (Exception localException)
    {
    }
    return arrayOfString;
  }

  public static String e(Context paramContext)
  {
    if (paramContext != null)
    {
      WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (localWifiInfo != null)
      {
        String str = localWifiInfo.getMacAddress();
        if (ad.a(str))
          str = "00-00-00-00-00-00";
        return str;
      }
      return "00-00-00-00-00-00";
    }
    return "00-00-00-00-00-00";
  }

  public static String f(Context paramContext)
  {
    if (paramContext != null)
      try
      {
        WifiInfo localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (localWifiInfo != null)
        {
          String str = a(localWifiInfo.getIpAddress());
          return str;
        }
        return null;
      }
      catch (Exception localException)
      {
      }
    return null;
  }

  public static boolean g(Context paramContext)
  {
    boolean bool1 = false;
    if (paramContext != null);
    try
    {
      boolean bool2 = d(paramContext)[0].equals("Wi-Fi");
      bool1 = false;
      if (bool2)
        bool1 = true;
      return bool1;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.aa
 * JD-Core Version:    0.6.2
 */