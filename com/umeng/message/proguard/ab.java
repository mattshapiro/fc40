package com.umeng.message.proguard;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

public class ab
{
  public static final String a()
  {
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = (int)System.nanoTime();
    int k = new Random().nextInt();
    int m = new Random().nextInt();
    byte[] arrayOfByte1 = Z.a(i);
    byte[] arrayOfByte2 = Z.a(j);
    byte[] arrayOfByte3 = Z.a(k);
    byte[] arrayOfByte4 = Z.a(m);
    byte[] arrayOfByte5 = new byte[16];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 0, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 4, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 8, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 12, 4);
    return X.b(arrayOfByte5, 2);
  }

  public static String a(Context paramContext)
  {
    Object localObject = null;
    if (paramContext != null);
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        String str1 = localTelephonyManager.getDeviceId();
        str2 = str1;
        localObject = str2;
        if (ad.a((String)localObject))
          localObject = a();
        return localObject;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localObject = null;
        continue;
        String str2 = null;
      }
    }
  }

  public static String b(Context paramContext)
  {
    Object localObject = null;
    if (paramContext != null);
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        String str1 = localTelephonyManager.getSubscriberId();
        str2 = str1;
        localObject = str2;
        if (ad.a((String)localObject))
          localObject = a();
        return localObject;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localObject = null;
        continue;
        String str2 = null;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.ab
 * JD-Core Version:    0.6.2
 */