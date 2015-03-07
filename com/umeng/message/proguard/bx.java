package com.umeng.message.proguard;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class bx
{
  public static void a(Context paramContext)
  {
    if (paramContext != null);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      String str = paramContext.getPackageName();
      ActivityInfo[] arrayOfActivityInfo;
      try
      {
        PackageInfo localPackageInfo = localPackageManager.getPackageInfo(str, 2);
        arrayOfActivityInfo = localPackageInfo.receivers;
        if (arrayOfActivityInfo == null)
          break label135;
        if (arrayOfActivityInfo.length == 0)
          return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        throw new IllegalStateException("Could not get receivers for package " + str);
      }
      int i = arrayOfActivityInfo.length;
      for (int j = 0; j < i; j++)
      {
        ComponentName localComponentName = new ComponentName(paramContext, arrayOfActivityInfo[j].name);
        if (localPackageManager.getComponentEnabledSetting(localComponentName) == 2)
          localPackageManager.setComponentEnabledSetting(localComponentName, 1, 1);
        localPackageManager.setComponentEnabledSetting(localComponentName, 1, 1);
      }
      label135: return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static void a(Context paramContext, Class<?> paramClass)
  {
    if ((paramContext != null) && (paramClass != null))
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
          return;
        if (localPackageManager.getApplicationEnabledSetting(paramContext.getPackageName()) > -1)
        {
          ComponentName localComponentName = new ComponentName(paramContext, paramClass);
          if (localPackageManager.getComponentEnabledSetting(localComponentName) != 2)
          {
            localPackageManager.setComponentEnabledSetting(localComponentName, 2, 1);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
      }
  }

  public static void b(Context paramContext, Class<?> paramClass)
  {
    if ((paramContext != null) && (paramClass != null))
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null)
          return;
        if (localPackageManager.getApplicationEnabledSetting(paramContext.getPackageName()) > -1)
        {
          ComponentName localComponentName = new ComponentName(paramContext, paramClass);
          int i = localPackageManager.getComponentEnabledSetting(localComponentName);
          if ((i != 1) && (i != 0))
          {
            localPackageManager.setComponentEnabledSetting(localComponentName, 1, 1);
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
      }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bx
 * JD-Core Version:    0.6.2
 */