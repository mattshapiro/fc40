package com.umeng.message.proguard;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import org.android.agoo.client.IntentHelper;

public class by
{
  private static final String a = "ServiceUtil";

  public static void a(Context paramContext)
  {
    while (true)
    {
      try
      {
        List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningServices(2147483647);
        int i = Process.myPid();
        j = 0;
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          if (((ActivityManager.RunningServiceInfo)localIterator.next()).pid == i)
          {
            k = j + 1;
            break label83;
          }
        }
        else
        {
          if (j < 1)
            Process.killProcess(i);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      int k = j;
      label83: int j = k;
    }
  }

  public static void a(Context paramContext, Class<?> paramClass)
  {
    aJ.c("ServiceUtil", "command --->[" + paramContext.getPackageName() + ".service]:[" + "start" + "]");
    Intent localIntent = new Intent();
    localIntent.setAction(IntentHelper.getAgooStart(paramContext));
    localIntent.putExtra("method", "start");
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.startService(localIntent);
  }

  public static void b(Context paramContext, Class<?> paramClass)
  {
    aJ.c("ServiceUtil", "command --->[" + paramContext.getPackageName() + ".service]:[" + "stop" + "]");
    String str = IntentHelper.getAgooStart(paramContext);
    Intent localIntent = new Intent();
    localIntent.setAction(str);
    localIntent.putExtra("method", "stop");
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.startService(localIntent);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.by
 * JD-Core Version:    0.6.2
 */