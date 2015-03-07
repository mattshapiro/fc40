package org.android.agoo.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.text.TextUtils;
import com.umeng.message.proguard.aJ;

public class IppFacade
{
  private static String a = IppFacade.class.getSimpleName();
  private static final String b = "org.agoo.android.intent.action.PING2";

  public static void performProtectOnlyOnce(Context paramContext)
  {
    if (paramContext == null);
    while (true)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramContext.getPackageName()))
        {
          new Thread(new Runnable()
          {
            private ServiceConnection b = new ServiceConnection()
            {
              public void onServiceConnected(ComponentName paramAnonymous2ComponentName, IBinder paramAnonymous2IBinder)
              {
                try
                {
                  IppFacade.1.this.a.unbindService(this);
                  return;
                }
                catch (Throwable localThrowable)
                {
                }
              }

              public void onServiceDisconnected(ComponentName paramAnonymous2ComponentName)
              {
              }
            };

            private boolean a(String paramAnonymousString)
            {
              return this.a.getPackageManager().getLaunchIntentForPackage(paramAnonymousString) != null;
            }

            public void run()
            {
              try
              {
                if (a("com.eg.android.AlipayGphone"))
                {
                  Intent localIntent = new Intent();
                  localIntent.setAction("org.agoo.android.intent.action.PING2");
                  if (this.a.bindService(localIntent, this.b, 1))
                  {
                    aJ.c(IppFacade.a(), "ippfacade binded--->[org.agoo.android.intent.action.PING2] success");
                    return;
                  }
                  aJ.d(IppFacade.a(), "ippfacade binded--->[org.agoo.android.intent.action.PING2] failed");
                  return;
                }
              }
              catch (Throwable localThrowable)
              {
              }
            }
          }).start();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.client.IppFacade
 * JD-Core Version:    0.6.2
 */