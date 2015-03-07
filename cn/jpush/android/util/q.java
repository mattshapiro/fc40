package cn.jpush.android.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public final class q
{
  public static String[] a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      String[] arrayOfString = localPackageManager.getPackageInfo(paramContext.getPackageName(), 4096).requestedPermissions;
      return arrayOfString;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      x.j();
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.q
 * JD-Core Version:    0.6.2
 */