package com.umeng.analytics;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static boolean a(Context paramContext)
  {
    try
    {
      int i = Process.myPid();
      Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      Object localObject2 = null;
      while (true)
      {
        boolean bool = localIterator.hasNext();
        if (!bool)
        {
          localObject1 = localObject2;
          if ((!TextUtils.isEmpty(localObject1)) && (!paramContext.getPackageName().equals(localObject1)))
            break;
          return true;
        }
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        if (localRunningAppProcessInfo.pid == i)
        {
          String str = localRunningAppProcessInfo.processName.trim();
          localObject2 = str;
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
        Object localObject1 = null;
    }
    return false;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.b
 * JD-Core Version:    0.6.2
 */