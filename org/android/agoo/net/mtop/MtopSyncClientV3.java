package org.android.agoo.net.mtop;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bd;
import com.umeng.message.proguard.bd.a;

public class MtopSyncClientV3 extends bd
  implements IMtopSynClient
{
  private volatile String a;
  private volatile String b;
  private volatile String c;

  public Result getV3(Context paramContext, MtopRequest paramMtopRequest)
  {
    try
    {
      MtopRequestHelper.checkAppKeyAndAppSecret(paramMtopRequest, this.a, this.b);
      bb localbb = MtopRequestHelper.getUrlWithRequestParams(paramContext, paramMtopRequest);
      String str = get(paramContext, this.c, localbb).b;
      if (TextUtils.isEmpty(str))
      {
        Result localResult2 = new Result();
        localResult2.setSuccess(false);
        localResult2.setRetDesc("request result is null");
        return localResult2;
      }
      Result localResult3 = MtopResponseHelper.parse(str);
      return localResult3;
    }
    catch (Throwable localThrowable)
    {
      Result localResult1 = new Result();
      localResult1.setSuccess(false);
      localResult1.setRetDesc(localThrowable.getMessage());
      return localResult1;
    }
  }

  public void setBaseUrl(String paramString)
  {
    this.c = paramString;
  }

  public void setDefaultAppSecret(String paramString)
  {
    this.b = paramString;
  }

  public void setDefaultAppkey(String paramString)
  {
    this.a = paramString;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.net.mtop.MtopSyncClientV3
 * JD-Core Version:    0.6.2
 */