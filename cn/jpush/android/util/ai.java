package cn.jpush.android.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ai
{
  private static String a;
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "\r<)\0375\b;,\0248|OXhD{";
    int i = -1;
    String[] arrayOfString2 = arrayOfString1;
    int j = 0;
    Object localObject1 = str1.toCharArray();
    int k = localObject1.length;
    int m;
    label35: int i3;
    if (k <= 1)
    {
      m = 0;
      Object localObject2 = localObject1;
      int n = m;
      int i1 = k;
      Object localObject3 = localObject1;
      while (true)
      {
        int i2 = localObject3[m];
        switch (n % 5)
        {
        default:
          i3 = 1;
          label95: localObject3[m] = ((char)(i3 ^ i2));
          m = n + 1;
          if (i1 != 0)
            break label132;
          localObject3 = localObject2;
          n = m;
          m = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label132: k = i1;
      localObject1 = localObject2;
    }
    while (true)
    {
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject1).intern();
      switch (i)
      {
      default:
        arrayOfString2[j] = str2;
        str1 = "pI.";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        a = z[0];
        return;
        i3 = 61;
        break label95;
        i3 = 13;
        break label95;
        i3 = 27;
        break label95;
        i3 = 44;
        break label95;
        m = 0;
      }
    }
  }

  public static boolean a(String paramString)
  {
    if (paramString == null);
    while ((paramString.length() == 0) || (paramString.trim().length() == 0))
      return true;
    return false;
  }

  public static boolean a(String paramString1, String paramString2)
  {
    if (paramString1 == null);
    while (paramString2 == null)
      return false;
    return paramString1.equals(paramString2);
  }

  public static String b(String paramString)
  {
    int i = 0;
    if ((paramString == null) || ("".equals(paramString)))
      return null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(z[1]);
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      if (arrayOfByte == null)
        return "";
      StringBuffer localStringBuffer = new StringBuffer(2 * arrayOfByte.length);
      while (i < arrayOfByte.length)
      {
        int j = arrayOfByte[i];
        localStringBuffer.append(z[0].charAt(0xF & j >> 4)).append(z[0].charAt(j & 0xF));
        i++;
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.ai
 * JD-Core Version:    0.6.2
 */