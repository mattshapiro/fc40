package org.android.agoo.net.mtop;

import android.content.Context;
import com.umeng.message.proguard.bb;
import com.umeng.message.proguard.bd.a;

public abstract interface IMtopSynClient
{
  public abstract bd.a get(Context paramContext, String paramString, bb parambb)
    throws Throwable;

  public abstract Result getV3(Context paramContext, MtopRequest paramMtopRequest);

  public abstract void setBaseUrl(String paramString);

  public abstract void setDefaultAppSecret(String paramString);

  public abstract void setDefaultAppkey(String paramString);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.net.mtop.IMtopSynClient
 * JD-Core Version:    0.6.2
 */