package com.allinone.free.pager;

import android.content.res.Resources;
import android.util.TypedValue;

public class Util
{
  public static int dpToPx(Resources paramResources, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramResources.getDisplayMetrics());
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.pager.Util
 * JD-Core Version:    0.6.2
 */