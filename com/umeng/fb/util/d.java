package com.umeng.fb.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.umeng.fb.model.Store;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONObject;

public class d
{
  public static final String a = System.getProperty("line.separator");
  private static final String b = d.class.getName();

  public static String a(String paramString)
  {
    int i = 0;
    if (paramString == null)
      return null;
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes();
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.reset();
      localMessageDigest.update(arrayOfByte1);
      byte[] arrayOfByte2 = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      while (i < arrayOfByte2.length)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Byte.valueOf(arrayOfByte2[i]);
        localStringBuffer.append(String.format("%02X", arrayOfObject));
        i++;
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Exception localException)
    {
    }
    return paramString.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
  }

  public static JSONObject a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("device_id", b.f(paramContext));
      localJSONObject.put("idmd5", b.g(paramContext));
      localJSONObject.put("device_model", Build.MODEL);
      localJSONObject.put("appkey", b.p(paramContext));
      localJSONObject.put("channel", b.t(paramContext));
      localJSONObject.put("app_version", b.d(paramContext));
      localJSONObject.put("version_code", b.c(paramContext));
      localJSONObject.put("sdk_type", "Android");
      localJSONObject.put("sdk_version", "5.1.0.20150115");
      localJSONObject.put("os", "Android");
      localJSONObject.put("os_version", Build.VERSION.RELEASE);
      localJSONObject.put("country", b.o(paramContext)[0]);
      localJSONObject.put("language", b.o(paramContext)[1]);
      localJSONObject.put("timezone", b.n(paramContext));
      localJSONObject.put("resolution", b.r(paramContext));
      localJSONObject.put("access", b.j(paramContext)[0]);
      localJSONObject.put("access_subtype", b.j(paramContext)[1]);
      localJSONObject.put("carrier", b.h(paramContext));
      localJSONObject.put("cpu", b.a());
      localJSONObject.put("package", b.u(paramContext));
      localJSONObject.put("uid", Store.getInstance(paramContext).getUid());
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }

  public static void a(Context paramContext, String paramString)
  {
    paramContext.startActivity(paramContext.getPackageManager().getLaunchIntentForPackage(paramString));
  }

  public static String b(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      byte[] arrayOfByte = localMessageDigest.digest();
      StringBuffer localStringBuffer = new StringBuffer();
      for (int i = 0; i < arrayOfByte.length; i++)
        localStringBuffer.append(Integer.toHexString(0xFF & arrayOfByte[i]));
      String str = localStringBuffer.toString();
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Log.a(b, "getMD5 error", localNoSuchAlgorithmException);
    }
    return "";
  }

  public static boolean b(Context paramContext, String paramString)
  {
    try
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.util.d
 * JD-Core Version:    0.6.2
 */