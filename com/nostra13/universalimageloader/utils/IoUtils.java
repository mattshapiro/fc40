package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class IoUtils
{
  private static final int BUFFER_SIZE = 8192;

  public static void closeSilently(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[8192];
    while (true)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 8192);
      if (i == -1)
        return;
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.IoUtils
 * JD-Core Version:    0.6.2
 */