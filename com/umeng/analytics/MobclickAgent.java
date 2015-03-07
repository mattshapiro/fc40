package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import com.umeng.analytics.social.UMPlatformData;
import com.umeng.analytics.social.UMSocialService;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import u.aly.bi;
import u.aly.bj;

public class MobclickAgent
{
  private static final String a = "input map is null";
  private static final d b = new d();

  public static void flush(Context paramContext)
  {
    b.d(paramContext);
  }

  public static d getAgent()
  {
    return b;
  }

  public static String getConfigParams(Context paramContext, String paramString)
  {
    return g.a(paramContext).g().getString(paramString, "");
  }

  public static void onEvent(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString, null, -1L, 1);
  }

  public static void onEvent(Context paramContext, String paramString, int paramInt)
  {
    b.a(paramContext, paramString, null, -1L, paramInt);
  }

  public static void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      bj.a("MobclickAgent", "label is null or empty");
      return;
    }
    b.a(paramContext, paramString1, paramString2, -1L, 1);
  }

  public static void onEvent(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      bj.a("MobclickAgent", "label is null or empty");
      return;
    }
    b.a(paramContext, paramString1, paramString2, -1L, paramInt);
  }

  public static void onEvent(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    if (paramMap == null)
    {
      bj.b("MobclickAgent", "input map is null");
      return;
    }
    b.a(paramContext, paramString, new HashMap(paramMap), -1L);
  }

  public static void onEventBegin(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString, null);
  }

  public static void onEventBegin(Context paramContext, String paramString1, String paramString2)
  {
    b.a(paramContext, paramString1, paramString2);
  }

  public static void onEventDuration(Context paramContext, String paramString, long paramLong)
  {
    if (paramLong <= 0L)
    {
      bj.a("MobclickAgent", "duration is not valid in onEventDuration");
      return;
    }
    b.a(paramContext, paramString, null, paramLong, 1);
  }

  public static void onEventDuration(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      bj.a("MobclickAgent", "label is null or empty");
      return;
    }
    if (paramLong <= 0L)
    {
      bj.a("MobclickAgent", "duration is not valid in onEventDuration");
      return;
    }
    b.a(paramContext, paramString1, paramString2, paramLong, 1);
  }

  public static void onEventDuration(Context paramContext, String paramString, Map<String, String> paramMap, long paramLong)
  {
    if (paramLong <= 0L)
    {
      bj.a("MobclickAgent", "duration is not valid in onEventDuration");
      return;
    }
    if (paramMap == null)
    {
      bj.b("MobclickAgent", "input map is null");
      return;
    }
    b.a(paramContext, paramString, new HashMap(paramMap), paramLong);
  }

  public static void onEventEnd(Context paramContext, String paramString)
  {
    b.b(paramContext, paramString, null);
  }

  public static void onEventEnd(Context paramContext, String paramString1, String paramString2)
  {
    b.b(paramContext, paramString1, paramString2);
  }

  public static void onEventValue(Context paramContext, String paramString, Map<String, String> paramMap, int paramInt)
  {
    if (paramMap == null);
    for (HashMap localHashMap = new HashMap(); ; localHashMap = new HashMap(paramMap))
    {
      localHashMap.put("__ct__", Integer.valueOf(paramInt));
      b.a(paramContext, paramString, localHashMap, -1L);
      return;
    }
  }

  public static void onKVEventBegin(Context paramContext, String paramString1, Map<String, String> paramMap, String paramString2)
  {
    if (paramMap == null)
    {
      bj.b("MobclickAgent", "input map is null");
      return;
    }
    b.a(paramContext, paramString1, new HashMap(paramMap), paramString2);
  }

  public static void onKVEventEnd(Context paramContext, String paramString1, String paramString2)
  {
    b.c(paramContext, paramString1, paramString2);
  }

  public static void onKillProcess(Context paramContext)
  {
    b.e(paramContext);
  }

  public static void onPageEnd(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b.b(paramString);
      return;
    }
    bj.b("MobclickAgent", "pageName is null or empty");
  }

  public static void onPageStart(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      b.a(paramString);
      return;
    }
    bj.b("MobclickAgent", "pageName is null or empty");
  }

  public static void onPause(Context paramContext)
  {
    b.c(paramContext);
  }

  public static void onResume(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    b.b(paramContext);
  }

  public static void onResume(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      bj.b("MobclickAgent", "unexpected empty appkey in onResume");
      return;
    }
    AnalyticsConfig.setAppkey(paramString1);
    AnalyticsConfig.setChannel(paramString2);
    b.b(paramContext);
  }

  public static void onSocialEvent(Context paramContext, String paramString, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "context is null in onShareEvent");
      return;
    }
    com.umeng.analytics.social.e.e = "3";
    UMSocialService.share(paramContext, paramString, paramArrayOfUMPlatformData);
  }

  public static void onSocialEvent(Context paramContext, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "context is null in onShareEvent");
      return;
    }
    com.umeng.analytics.social.e.e = "3";
    UMSocialService.share(paramContext, paramArrayOfUMPlatformData);
  }

  public static void openActivityDurationTrack(boolean paramBoolean)
  {
    AnalyticsConfig.ACTIVITY_DURATION_OPEN = paramBoolean;
  }

  public static void reportError(Context paramContext, String paramString)
  {
    b.a(paramContext, paramString);
  }

  public static void reportError(Context paramContext, Throwable paramThrowable)
  {
    b.a(paramContext, paramThrowable);
  }

  public static void setAutoLocation(boolean paramBoolean)
  {
  }

  public static void setCatchUncaughtExceptions(boolean paramBoolean)
  {
    AnalyticsConfig.CATCH_EXCEPTION = paramBoolean;
  }

  public static void setDebugMode(boolean paramBoolean)
  {
    bj.a = paramBoolean;
    com.umeng.analytics.social.e.v = paramBoolean;
  }

  public static void setEnableEventBuffer(boolean paramBoolean)
  {
    AnalyticsConfig.ENABLE_MEMORY_BUFFER = paramBoolean;
  }

  public static void setOnlineConfigureListener(UmengOnlineConfigureListener paramUmengOnlineConfigureListener)
  {
    b.a(paramUmengOnlineConfigureListener);
  }

  public static void setOpenGLContext(GL10 paramGL10)
  {
    if (paramGL10 != null)
    {
      String[] arrayOfString = bi.a(paramGL10);
      if (arrayOfString.length == 2)
      {
        AnalyticsConfig.GPU_VENDER = arrayOfString[0];
        AnalyticsConfig.GPU_RENDERER = arrayOfString[1];
      }
    }
  }

  public static void setSessionContinueMillis(long paramLong)
  {
    AnalyticsConfig.kContinueSessionMillis = paramLong;
  }

  public static void setUserID(Context paramContext, String paramString1, String paramString2, Gender paramGender, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2))
        break label55;
      label14: if ((paramInt <= 0) || (paramInt >= 200))
        break label67;
    }
    while (true)
    {
      g.a(paramContext).a(paramString1, paramString2, paramInt, paramGender.value);
      return;
      bj.c("MobclickAgent", "userID is null or empty");
      paramString1 = null;
      break;
      label55: bj.a("MobclickAgent", "id source is null or empty");
      paramString2 = null;
      break label14;
      label67: bj.a("MobclickAgent", "not a valid age!");
      paramInt = -1;
    }
  }

  public static void setWrapper(String paramString1, String paramString2)
  {
    b.a(paramString1, paramString2);
  }

  public static void updateOnlineConfig(Context paramContext)
  {
    b.a(paramContext);
  }

  public static void updateOnlineConfig(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      bj.b("MobclickAgent", "unexpected empty appkey in onResume");
      return;
    }
    AnalyticsConfig.setAppkey(paramString1);
    AnalyticsConfig.setChannel(paramString2);
    b.a(paramContext);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.MobclickAgent
 * JD-Core Version:    0.6.2
 */