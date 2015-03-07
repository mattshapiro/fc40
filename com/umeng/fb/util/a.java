package com.umeng.fb.util;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class a
{
  public static int a;

  public static String a(byte[] paramArrayOfByte, String paramString)
    throws UnsupportedEncodingException, DataFormatException
  {
    byte[] arrayOfByte = b(paramArrayOfByte);
    if (arrayOfByte != null)
      return new String(arrayOfByte, paramString);
    return null;
  }

  public static byte[] a(String paramString1, String paramString2)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString1))
      return null;
    return a(paramString1.getBytes(paramString2));
  }

  public static byte[] a(byte[] paramArrayOfByte)
    throws IOException
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      return null;
    Deflater localDeflater = new Deflater();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    byte[] arrayOfByte = new byte[8192];
    a = 0;
    try
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        while (!localDeflater.finished())
        {
          int i = localDeflater.deflate(arrayOfByte);
          a = i + a;
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
      }
      finally
      {
      }
      if (localByteArrayOutputStream != null)
        localByteArrayOutputStream.close();
      throw localObject1;
      localDeflater.end();
      if (localByteArrayOutputStream != null)
        localByteArrayOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    finally
    {
      while (true)
      {
        Object localObject2 = localObject3;
        ByteArrayOutputStream localByteArrayOutputStream = null;
      }
    }
  }

  public static byte[] b(byte[] paramArrayOfByte)
    throws UnsupportedEncodingException, DataFormatException
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      return null;
    Inflater localInflater = new Inflater();
    localInflater.setInput(paramArrayOfByte, 0, paramArrayOfByte.length);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    while (!localInflater.needsInput())
    {
      int j = localInflater.inflate(arrayOfByte);
      localByteArrayOutputStream.write(arrayOfByte, i, j);
      i += j;
    }
    localInflater.end();
    return localByteArrayOutputStream.toByteArray();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.util.a
 * JD-Core Version:    0.6.2
 */