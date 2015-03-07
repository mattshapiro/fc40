package com.umeng.message.proguard;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

public class br
{
  private static String a = Build.BRAND;
  private static final String b = "agoo_xiaomi";
  private static final String c = "agoo_huawei";
  private static final String d = "com.xiaomi.xmsf";
  private static final String e = "com.huawei.android.pushagent";
  private static final String f = "Huawei".toLowerCase();
  private static final String g = "Xiaomi".toLowerCase();

  public static void a(Context paramContext)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(a)))
      return;
    bz.a(new Runnable()
    {
      public void run()
      {
        try
        {
          PackageManager localPackageManager = this.a.getPackageManager();
          if ((TextUtils.equals(br.a(), br.b().toLowerCase())) && (localPackageManager.getPackageInfo("com.huawei.android.pushagent", 4) != null))
            aN.i(this.a, "agoo_huawei");
          if (TextUtils.equals(br.c(), br.b().toLowerCase()))
          {
            PackageInfo localPackageInfo = localPackageManager.getPackageInfo("com.xiaomi.xmsf", 4);
            if ((localPackageInfo != null) && (localPackageInfo.versionCode >= 105))
              aN.i(this.a, "agoo_xiaomi");
          }
          return;
        }
        catch (Throwable localThrowable)
        {
        }
      }
    });
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.br
 * JD-Core Version:    0.6.2
 */