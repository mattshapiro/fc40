package com.umeng.message;

import android.content.Context;
import com.umeng.message.proguard.aL;
import com.umeng.message.proguard.an;

public class UmengUT
  implements aL
{
  private volatile boolean b = false;

  public void commitEvent(int paramInt, Object paramObject)
  {
  }

  public void commitEvent(int paramInt, Object paramObject1, Object paramObject2)
  {
  }

  public void commitEvent(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3)
  {
  }

  public void commitEvent(int paramInt, Object paramObject1, Object paramObject2, Object paramObject3, String[] paramArrayOfString)
  {
  }

  public String getUtdId(Context paramContext)
  {
    try
    {
      String str = an.a(paramContext);
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public void onCaughException(Throwable paramThrowable)
  {
  }

  public void start(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
  }

  public void stop(Context paramContext)
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.UmengUT
 * JD-Core Version:    0.6.2
 */