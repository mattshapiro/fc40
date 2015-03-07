package com.umeng.update;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.umeng.update.net.j;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import u.upd.a;
import u.upd.l;
import u.upd.n;

public class UmengUpdateAgent
{
  private static UmengUpdateListener a = null;
  private static UmengDialogButtonListener b = null;
  private static UmengDownloadListener c = null;
  private static Context d;
  private static c e = new c();
  private static Handler f;

  static void a(int paramInt, Context paramContext, UpdateResponse paramUpdateResponse, File paramFile)
  {
    switch (paramInt)
    {
    case 6:
    default:
    case 5:
    case 7:
    }
    while (true)
    {
      if (b != null)
        b.onClick(paramInt);
      return;
      a(paramContext, paramUpdateResponse, paramFile);
      continue;
      ignoreUpdate(paramContext, paramUpdateResponse);
    }
  }

  private static void a(Context paramContext, UpdateResponse paramUpdateResponse, File paramFile)
  {
    if (paramFile == null)
    {
      startDownload(paramContext, paramUpdateResponse);
      return;
    }
    startInstall(paramContext, paramFile);
  }

  private static void b(int paramInt, UpdateResponse paramUpdateResponse)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt;
    localMessage.obj = paramUpdateResponse;
    f.sendMessage(localMessage);
  }

  private static void b(Context paramContext)
  {
    if (paramContext == null);
    try
    {
      u.upd.b.b("update", "unexpected null context in update");
      return;
      f = new Handler(paramContext.getMainLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          super.handleMessage(paramAnonymousMessage);
          if ((paramAnonymousMessage.what == 0) && (UpdateConfig.isUpdateAutoPopup()))
            UmengUpdateAgent.a(UmengUpdateAgent.a(), (UpdateResponse)paramAnonymousMessage.obj, UpdateConfig.getStyle());
          UmengUpdateAgent.a(null);
          if (UmengUpdateAgent.b() != null)
            UmengUpdateAgent.b().onUpdateReturned(paramAnonymousMessage.what, (UpdateResponse)paramAnonymousMessage.obj);
        }
      };
      c(paramContext);
      if (a.k(paramContext))
        break label78;
      if (UpdateConfig.isSilentDownload())
      {
        b(2, null);
        return;
      }
    }
    catch (Exception localException)
    {
      u.upd.b.b("update", "Exception occurred in Mobclick.update(). ", localException);
      return;
    }
    if ((UpdateConfig.isUpdateOnlyWifi()) && (!UpdateConfig.isUpdateForce()))
    {
      b(2, null);
      return;
    }
    label78: if (e.a())
    {
      b(4, null);
      u.upd.b.a("update", "Is updating now.");
      f.post(new Runnable()
      {
        public void run()
        {
          Toast.makeText(UmengUpdateAgent.this, l.b(UmengUpdateAgent.this), 0).show();
        }
      });
      return;
    }
    d = paramContext;
    new Thread(new a(paramContext.getApplicationContext())).start();
  }

  private static void b(Context paramContext, UpdateResponse paramUpdateResponse, int paramInt)
  {
    while (true)
    {
      File localFile;
      try
      {
        if (isIgnore(paramContext, paramUpdateResponse))
          return;
        localFile = downloadedFile(paramContext, paramUpdateResponse);
        if (localFile != null)
        {
          bool = true;
          if (bool)
            break label102;
          if (UpdateConfig.isSilentDownload())
            break;
          break label102;
          e.a(paramContext, paramUpdateResponse, bool, localFile);
          return;
        }
      }
      catch (Exception localException)
      {
        u.upd.b.b("update", "Fail to create update dialog box.", localException);
        return;
      }
      boolean bool = false;
      continue;
      ((NotificationManager)paramContext.getSystemService("notification")).notify(0, e.b(paramContext, paramUpdateResponse, bool, localFile).a());
      return;
    }
    startDownload(paramContext, paramUpdateResponse);
    return;
    label102: switch (paramInt)
    {
    case 0:
    case 1:
    }
  }

  private static boolean c(Context paramContext)
  {
    if (!UpdateConfig.isUpdateCheck())
      return true;
    while (true)
    {
      int i;
      try
      {
        while (true)
        {
          boolean bool1 = Class.forName(paramContext.getPackageName() + ".BuildConfig").getField("DEBUG").getBoolean(null);
          if (!bool1)
            break;
          try
          {
            if (UpdateConfig.getAppkey(paramContext) == null)
            {
              f.post(new Runnable()
              {
                public void run()
                {
                  Toast.makeText(UmengUpdateAgent.this, "Please set umeng appkey!", 1).show();
                }
              });
              return false;
            }
            localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 4101);
            ActivityInfo[] arrayOfActivityInfo = localPackageInfo.activities;
            if (arrayOfActivityInfo == null)
              break label535;
            i2 = 0;
            bool2 = false;
          }
          catch (Exception localException2)
          {
            try
            {
              PackageInfo localPackageInfo;
              while (true)
              {
                int i2;
                if (i2 >= localPackageInfo.activities.length)
                {
                  if (bool2)
                    break;
                  f.post(new Runnable()
                  {
                    public void run()
                    {
                      Toast.makeText(UmengUpdateAgent.this, "Please add Activity in AndroidManifest!", 1).show();
                    }
                  });
                  return false;
                }
                boolean bool6 = "com.umeng.update.UpdateDialogActivity".equals(localPackageInfo.activities[i2].name);
                if (bool6)
                  bool2 = true;
                i2++;
              }
              ServiceInfo[] arrayOfServiceInfo = localPackageInfo.services;
              if (arrayOfServiceInfo == null)
                break label529;
              int i1 = 0;
              bool2 = false;
              while (true)
              {
                if (i1 >= localPackageInfo.services.length)
                {
                  if (bool2)
                    break;
                  f.post(new Runnable()
                  {
                    public void run()
                    {
                      Toast.makeText(UmengUpdateAgent.this, "Please add Service in AndroidManifest!", 1).show();
                    }
                  });
                  return false;
                }
                boolean bool5 = "com.umeng.update.net.DownloadingService".equals(localPackageInfo.services[i1].name);
                if (bool5)
                  bool2 = true;
                i1++;
              }
              if (localPackageInfo.requestedPermissions == null)
                break label517;
              i = 0;
              j = 0;
              k = 0;
              m = 0;
              int n = localPackageInfo.requestedPermissions.length;
              if (i >= n)
                if ((m == 0) || (k == 0) || (j == 0))
                  break label403;
              label403: for (bool2 = true; !bool2; bool2 = false)
              {
                f.post(new Runnable()
                {
                  public void run()
                  {
                    Toast.makeText(UmengUpdateAgent.this, "Please add Permission in AndroidManifest!", 1).show();
                  }
                });
                return false;
                if ("android.permission.WRITE_EXTERNAL_STORAGE".equals(localPackageInfo.requestedPermissions[i]))
                {
                  m = 1;
                  break label541;
                }
                if ("android.permission.ACCESS_NETWORK_STATE".equals(localPackageInfo.requestedPermissions[i]))
                {
                  k = 1;
                  break label541;
                }
                boolean bool3 = "android.permission.INTERNET".equals(localPackageInfo.requestedPermissions[i]);
                if (!bool3)
                  break label541;
                j = 1;
                break label541;
              }
              while (true)
              {
                try
                {
                  boolean bool4 = "2.4.2.20140520".equals(paramContext.getString(Class.forName(paramContext.getPackageName() + ".R$string").getField("UMUpdateCheck").getInt(null)));
                  if (!bool4)
                    break label511;
                  bool2 = true;
                  if (bool2)
                    break;
                  f.post(new Runnable()
                  {
                    public void run()
                    {
                      Toast.makeText(UmengUpdateAgent.this, "Please copy all resources (res/) from SDK to your project!", 1).show();
                    }
                  });
                  label485: return bool2;
                }
                catch (Exception localException4)
                {
                  bool2 = false;
                  continue;
                }
                localException2 = localException2;
                bool2 = false;
              }
            }
            catch (Exception localException3)
            {
              break label485;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        return true;
      }
      label511: boolean bool2 = false;
      continue;
      label517: int j = 0;
      int k = 0;
      int m = 0;
      continue;
      label529: bool2 = false;
      continue;
      label535: bool2 = false;
      continue;
      label541: i++;
    }
  }

  public static File downloadedFile(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    String str = paramUpdateResponse.new_md5 + ".apk";
    try
    {
      File localFile = new File(j.a("/apk", paramContext, new boolean[1]), str);
      if (localFile.exists())
      {
        boolean bool = paramUpdateResponse.new_md5.equalsIgnoreCase(n.a(localFile));
        if (bool)
          return localFile;
      }
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return null;
    }
    return null;
  }

  public static void forceUpdate(Context paramContext)
  {
    UpdateConfig.setUpdateForce(true);
    UpdateConfig.setSilentDownload(false);
    b(paramContext.getApplicationContext());
  }

  public static void ignoreUpdate(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    UpdateConfig.saveIgnoreMd5(paramContext, paramUpdateResponse.new_md5);
  }

  public static boolean isIgnore(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    return (paramUpdateResponse.new_md5 != null) && (paramUpdateResponse.new_md5.equalsIgnoreCase(UpdateConfig.getIgnoreMd5(paramContext))) && (!UpdateConfig.isUpdateForce());
  }

  public static void setAppkey(String paramString)
  {
    UpdateConfig.setAppkey(paramString);
  }

  public static void setChannel(String paramString)
  {
    UpdateConfig.setChannel(paramString);
  }

  public static void setDefault()
  {
    setDeltaUpdate(true);
    setUpdateAutoPopup(true);
    setUpdateOnlyWifi(true);
    setRichNotification(true);
    setDialogListener(null);
    setDownloadListener(null);
    setUpdateListener(null);
    setAppkey(null);
    setChannel(null);
    setUpdateUIStyle(0);
  }

  public static void setDeltaUpdate(boolean paramBoolean)
  {
    UpdateConfig.setDeltaUpdate(paramBoolean);
  }

  public static void setDialogListener(UmengDialogButtonListener paramUmengDialogButtonListener)
  {
    b = paramUmengDialogButtonListener;
  }

  public static void setDownloadListener(UmengDownloadListener paramUmengDownloadListener)
  {
    c = paramUmengDownloadListener;
  }

  public static void setRichNotification(boolean paramBoolean)
  {
    UpdateConfig.setRichNotification(paramBoolean);
  }

  public static void setUpdateAutoPopup(boolean paramBoolean)
  {
    UpdateConfig.setUpdateAutoPopup(paramBoolean);
  }

  public static void setUpdateCheckConfig(boolean paramBoolean)
  {
    UpdateConfig.setUpdateCheck(paramBoolean);
  }

  public static void setUpdateListener(UmengUpdateListener paramUmengUpdateListener)
  {
    a = paramUmengUpdateListener;
  }

  public static void setUpdateOnlyWifi(boolean paramBoolean)
  {
    UpdateConfig.setUpdateOnlyWifi(paramBoolean);
  }

  public static void setUpdateUIStyle(int paramInt)
  {
    UpdateConfig.setStyle(paramInt);
  }

  public static void showUpdateDialog(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    b(paramContext, paramUpdateResponse, 0);
  }

  public static void showUpdateNotification(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    b(paramContext, paramUpdateResponse, 1);
  }

  public static void silentUpdate(Context paramContext)
  {
    UpdateConfig.setUpdateForce(false);
    UpdateConfig.setSilentDownload(true);
    b(paramContext.getApplicationContext());
  }

  public static void startDownload(Context paramContext, UpdateResponse paramUpdateResponse)
  {
    if ((paramUpdateResponse.delta) && (UpdateConfig.isDeltaUpdate()))
    {
      e.a(paramContext, paramUpdateResponse.origin, paramUpdateResponse.new_md5, paramUpdateResponse.path, paramUpdateResponse.patch_md5, c);
      e.b();
      return;
    }
    e.a(paramContext, paramUpdateResponse.path, paramUpdateResponse.new_md5, null, null, c);
    e.c();
  }

  public static void startInstall(Context paramContext, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.addFlags(268435456);
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    paramContext.startActivity(localIntent);
  }

  public static void update(Context paramContext)
  {
    UpdateConfig.setUpdateForce(false);
    UpdateConfig.setSilentDownload(false);
    b(paramContext.getApplicationContext());
  }

  public static void update(Context paramContext, String paramString1, String paramString2)
  {
    UpdateConfig.setAppkey(paramString1);
    UpdateConfig.setChannel(paramString2);
    update(paramContext);
  }

  static class a
    implements Runnable
  {
    Context a;

    public a(Context paramContext)
    {
      this.a = paramContext;
    }

    public void run()
    {
      try
      {
        localUpdateResponse = new b(this.a).b();
        if (localUpdateResponse == null)
        {
          UmengUpdateAgent.a(3, null);
          return;
        }
        if (!localUpdateResponse.hasUpdate)
        {
          UmengUpdateAgent.a(1, localUpdateResponse);
          return;
        }
      }
      catch (Exception localException)
      {
        UpdateResponse localUpdateResponse;
        UmengUpdateAgent.a(1, null);
        u.upd.b.a("update", "request update error", localException);
        return;
        UmengUpdateAgent.a(0, localUpdateResponse);
        return;
      }
      catch (Error localError)
      {
        u.upd.b.a("update", "request update error" + localError.getMessage());
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.UmengUpdateAgent
 * JD-Core Version:    0.6.2
 */