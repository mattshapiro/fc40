package com.umeng.message.proguard;

import android.content.Context;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class bd extends aW
{
  private static final String a = "SyncHttp.client";

  public a get(Context paramContext, String paramString, bb parambb)
    throws Exception
  {
    return get(paramContext, null, paramString, parambb);
  }

  public a get(Context paramContext, HttpHost paramHttpHost, String paramString, bb parambb)
    throws Exception
  {
    HttpGet localHttpGet;
    try
    {
      localHttpGet = new HttpGet(a(paramString, parambb));
      if (!aU.a(paramContext))
      {
        aJ.c("SyncHttp.client", "network connection error[" + localHttpGet.getURI().toString() + "]");
        throw new RuntimeException("network connection error[" + localHttpGet.getURI().toString() + "]");
      }
    }
    catch (IOException localIOException)
    {
      aJ.e("SyncHttp.client", "request url error:[" + paramString + "]", localIOException);
      throw localIOException;
    }
    DefaultHttpClient localDefaultHttpClient = getHttpClient();
    if (paramHttpHost != null)
      localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", paramHttpHost);
    HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpGet);
    a locala = new a();
    StatusLine localStatusLine = localHttpResponse.getStatusLine();
    locala.a = localStatusLine.getStatusCode();
    if (localStatusLine.getStatusCode() >= 300)
    {
      aJ.c("SyncHttp.client", "request url [" + localHttpGet.getURI().toString() + "]  result code:[" + localStatusLine.getStatusCode() + "]");
      return locala;
    }
    HttpEntity localHttpEntity = localHttpResponse.getEntity();
    String str = null;
    if (localHttpEntity != null)
    {
      str = EntityUtils.toString(new BufferedHttpEntity(localHttpEntity), "UTF-8");
      locala.b = str;
    }
    aJ.c("SyncHttp.client", "request url:[" + localHttpGet.getURI().toString() + "] : result code [" + localStatusLine.getStatusCode() + "]:[" + str + "]");
    return locala;
  }

  public static class a
  {
    public int a;
    public String b;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bd
 * JD-Core Version:    0.6.2
 */