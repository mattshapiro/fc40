package com.umeng.message.proguard;

import java.io.UnsupportedEncodingException;

public class r
{
  public static String a(String paramString)
  {
    try
    {
      String str = new String(paramString.getBytes("ISO-8859-1"), "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", localUnsupportedEncodingException);
    }
  }

  public static boolean a(g paramg)
  {
    return paramg.i();
  }

  public static g b(String paramString)
  {
    try
    {
      g localg = g.a(paramString.getBytes("ISO-8859-1"));
      return localg;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException("Java VM does not support a standard character set.", localUnsupportedEncodingException);
    }
  }

  public static abstract interface a
  {
    public abstract int a();
  }

  public static abstract interface b<T extends r.a>
  {
    public abstract T b(int paramInt);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.r
 * JD-Core Version:    0.6.2
 */