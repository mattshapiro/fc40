package com.umeng.message.proguard;

import android.content.Context;

public abstract interface bi
{
  public static final int h = 307;
  public static final int i = 504;
  public static final int j = 404;
  public static final int k = 408;

  public abstract void addHeader(String paramString1, String paramString2);

  public abstract void close();

  public abstract void connect(Context paramContext, String paramString, long paramLong, bh parambh);

  public abstract void disconnect(int paramInt);

  public abstract bf readyState();
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bi
 * JD-Core Version:    0.6.2
 */