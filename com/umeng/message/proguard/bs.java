package com.umeng.message.proguard;

import java.text.SimpleDateFormat;
import java.util.Date;

public class bs
{
  public static long a(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyyMMddHHmmss").parse(paramString).getTime();
      return l;
    }
    catch (Throwable localThrowable)
    {
    }
    return -1L;
  }

  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(paramLong));
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return "none";
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bs
 * JD-Core Version:    0.6.2
 */