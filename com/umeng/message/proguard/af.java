package com.umeng.message.proguard;

import android.util.Log;

public class af
{
  public static final String a = af.class.getName();
  public static final int b = 86400000;

  public static boolean a(long paramLong, int paramInt)
  {
    if ((System.currentTimeMillis() - paramLong) / 86400000L < paramInt);
    for (boolean bool = true; ; bool = false)
    {
      if (Y.a)
        Log.d(a, "isUpToDate: " + bool + "; oldTimestamp: " + paramLong + "; currentTimestamp" + System.currentTimeMillis());
      return bool;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.af
 * JD-Core Version:    0.6.2
 */