package com.umeng.message.proguard;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class az
{
  private static float a = 1.0F;

  public az(Context paramContext)
  {
    a(paramContext);
  }

  public static int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat * a);
  }

  public static void a(Context paramContext)
  {
    a = paramContext.getResources().getDisplayMetrics().density;
  }

  public static int b(float paramFloat)
  {
    return (int)(0.5F + paramFloat / a);
  }

  public static int c(float paramFloat)
  {
    return (int)(0.5F + paramFloat * a);
  }

  public static int d(float paramFloat)
  {
    return (int)(0.5F + paramFloat / a);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.az
 * JD-Core Version:    0.6.2
 */