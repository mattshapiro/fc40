package com.umeng.message.proguard;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class aX extends aW
{
  protected static final String a = "AsyncHttp.client";
  private final ThreadPoolExecutor b = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
  private final Map<Context, List<WeakReference<Future<?>>>> c = new WeakHashMap();

  private HttpEntity a(bb parambb)
  {
    HttpEntity localHttpEntity = null;
    if (parambb != null)
      localHttpEntity = parambb.a();
    return localHttpEntity;
  }

  private void a(Context paramContext, DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpHost paramHttpHost, HttpUriRequest paramHttpUriRequest, String paramString, aZ paramaZ)
  {
    if (paramString != null)
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    Future localFuture = this.b.submit(new aY(paramContext, paramDefaultHttpClient, paramHttpContext, paramHttpHost, paramHttpUriRequest, paramaZ));
    if (paramContext != null)
    {
      Object localObject = (List)this.c.get(paramContext);
      if (localObject == null)
      {
        localObject = new LinkedList();
        this.c.put(paramContext, localObject);
      }
      ((List)localObject).add(new WeakReference(localFuture));
    }
  }

  public void cancelRequests(Context paramContext, boolean paramBoolean)
  {
    List localList = (List)this.c.get(paramContext);
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Future localFuture = (Future)((WeakReference)localIterator.next()).get();
        if (localFuture != null)
          localFuture.cancel(paramBoolean);
      }
    }
    this.c.remove(paramContext);
  }

  public void get(Context paramContext, String paramString, aZ paramaZ)
  {
    get(paramContext, null, paramString, null, null, paramaZ);
  }

  public void get(Context paramContext, String paramString, bb parambb, aZ paramaZ)
  {
    get(paramContext, null, paramString, null, parambb, paramaZ);
  }

  public void get(Context paramContext, String paramString, HttpHost paramHttpHost, aZ paramaZ)
  {
    get(paramContext, paramHttpHost, paramString, null, null, paramaZ);
  }

  public void get(Context paramContext, HttpHost paramHttpHost, String paramString, bb parambb, aZ paramaZ)
  {
    get(paramContext, paramHttpHost, paramString, null, parambb, paramaZ);
  }

  public void get(Context paramContext, HttpHost paramHttpHost, String paramString, Header[] paramArrayOfHeader, bb parambb, aZ paramaZ)
  {
    HttpGet localHttpGet = new HttpGet(a(paramString, parambb));
    if (paramArrayOfHeader != null)
      localHttpGet.setHeaders(paramArrayOfHeader);
    a(paramContext, getHttpClient(), getHttpContext(), paramHttpHost, localHttpGet, null, paramaZ);
  }

  public void post(Context paramContext, String paramString1, bb parambb, String paramString2, aZ paramaZ)
  {
    post(paramContext, paramString1, null, parambb, paramString2, paramaZ);
  }

  public void post(Context paramContext, String paramString1, Header[] paramArrayOfHeader, bb parambb, String paramString2, aZ paramaZ)
  {
    HttpPost localHttpPost = new HttpPost(paramString1);
    if (parambb != null)
      localHttpPost.setEntity(a(parambb));
    if (paramArrayOfHeader != null)
      localHttpPost.setHeaders(paramArrayOfHeader);
    a(paramContext, getHttpClient(), getHttpContext(), null, localHttpPost, paramString2, paramaZ);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.aX
 * JD-Core Version:    0.6.2
 */