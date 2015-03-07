package com.allinone.free.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  private static String getHashString(MessageDigest paramMessageDigest)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    byte[] arrayOfByte = paramMessageDigest.digest();
    int i = arrayOfByte.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localStringBuilder.toString();
      int k = arrayOfByte[j];
      localStringBuilder.append(Integer.toHexString(0xF & k >> 4));
      localStringBuilder.append(Integer.toHexString(k & 0xF));
    }
  }

  public static String getMD5(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      String str = getHashString(localMessageDigest);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }

  public static String getMd5Name(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      String str = new BigInteger(localMessageDigest.digest()).abs().toString(36);
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.MD5
 * JD-Core Version:    0.6.2
 */