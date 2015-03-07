package org.android.agoo.net.mtop;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bt;
import java.io.ByteArrayInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class MtopRequestHelper
{
  public static final String SPLIT_STR = "&";
  private static final String a = "MtopRequestHelper";

  private static long a()
  {
    return System.currentTimeMillis() / 1000L;
  }

  private static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong, String paramString7, String paramString8)
    throws Throwable
  {
    try
    {
      String str1 = bt.a(new ByteArrayInputStream(paramString1.getBytes("UTF-8")));
      StringBuffer localStringBuffer = new StringBuffer();
      if ((paramString8 != null) && (!"".equals(paramString8)))
      {
        localStringBuffer.append(paramString8);
        localStringBuffer.append("&");
      }
      localStringBuffer.append(paramString2);
      localStringBuffer.append("&");
      localStringBuffer.append(str1);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString3);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString4);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString5);
      localStringBuffer.append("&");
      localStringBuffer.append(paramString6);
      localStringBuffer.append("&");
      localStringBuffer.append(bt.a(new ByteArrayInputStream(paramString7.getBytes("UTF-8"))));
      localStringBuffer.append("&");
      localStringBuffer.append(paramLong);
      String str2 = bt.a(new ByteArrayInputStream(localStringBuffer.toString().getBytes("UTF-8")));
      return str2;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }

  private static String a(Map<String, Object> paramMap)
  {
    return new JSONObject(paramMap).toString();
  }

  public static void checkAppKeyAndAppSecret(MtopRequest paramMtopRequest, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramMtopRequest.getAppKey())))
      paramMtopRequest.setAppKey(paramString1);
    if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramMtopRequest.getAppSecret())))
      paramMtopRequest.setAppSecret(paramString2);
  }

  public static bb getUrlWithRequestParams(Context paramContext, MtopRequest paramMtopRequest)
    throws Throwable
  {
    bb localbb = new bb();
    localbb.a("api", paramMtopRequest.getApi());
    localbb.a("v", paramMtopRequest.getV());
    long l = paramMtopRequest.getTime();
    if (l <= 0L)
      l = a();
    localbb.a("t", "" + l);
    localbb.a("imei", "umeng");
    localbb.a("imsi", "umeng");
    localbb.a("ttid", paramMtopRequest.getTtId());
    localbb.a("appKey", paramMtopRequest.getAppKey());
    if (!TextUtils.isEmpty(paramMtopRequest.getDeviceId()))
      localbb.a("deviceId", paramMtopRequest.getDeviceId());
    Map localMap = paramMtopRequest.getSysParams();
    if (localMap != null)
    {
      Iterator localIterator = localMap.entrySet().iterator();
      if (localIterator != null)
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if ((localEntry != null) && (!TextUtils.isEmpty((CharSequence)localEntry.getKey())) && (!TextUtils.isEmpty((CharSequence)localEntry.getValue())))
            localbb.a((String)localEntry.getKey(), (String)localEntry.getValue());
        }
    }
    String str1 = a(paramMtopRequest.getParams());
    String str2 = paramMtopRequest.getAppKey();
    String str3 = paramMtopRequest.getAppSecret();
    if (TextUtils.isEmpty(str2))
      throw new NullPointerException("appKey is null");
    if (paramMtopRequest.isHasSigin())
      localbb.a("sign", a(str2, str3, paramMtopRequest.getApi(), paramMtopRequest.getV(), "umeng", "umeng", l, str1, paramMtopRequest.getEcode()));
    localbb.a("data", str1);
    if ((paramMtopRequest.getSId() != null) || (!"".equals(paramMtopRequest.getSId())))
      localbb.a("sid", paramMtopRequest.getSId());
    return localbb;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.net.mtop.MtopRequestHelper
 * JD-Core Version:    0.6.2
 */