package com.umeng.update.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class c
{
  private static float a = 1.0F;

  public c(Context paramContext)
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
 * Qualified Name:     com.umeng.update.util.c
 * JD-Core Version:    0.6.2
 */