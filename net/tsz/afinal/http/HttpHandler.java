package net.tsz.afinal.http;

import android.os.SystemClock;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import net.tsz.afinal.core.AsyncTask;
import net.tsz.afinal.http.entityhandler.EntityCallBack;
import net.tsz.afinal.http.entityhandler.FileEntityHandler;
import net.tsz.afinal.http.entityhandler.StringEntityHandler;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class HttpHandler<T> extends AsyncTask<Object, Object, Object>
  implements EntityCallBack
{
  private static final int UPDATE_FAILURE = 3;
  private static final int UPDATE_LOADING = 2;
  private static final int UPDATE_START = 1;
  private static final int UPDATE_SUCCESS = 4;
  private final AjaxCallBack<T> callback;
  private String charset;
  private final AbstractHttpClient client;
  private final HttpContext context;
  private int executionCount = 0;
  private HttpResponse httpResponse;
  private HttpUriRequest httpUriRequest;
  private boolean isResume = false;
  private final FileEntityHandler mFileEntityHandler = new FileEntityHandler();
  private final StringEntityHandler mStrEntityHandler = new StringEntityHandler();
  private String targetUrl = null;
  private long time;

  public HttpHandler(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, AjaxCallBack<T> paramAjaxCallBack, String paramString)
  {
    this.client = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.callback = paramAjaxCallBack;
    this.charset = paramString;
  }

  private void handleResponse(HttpResponse paramHttpResponse)
  {
    this.httpResponse = paramHttpResponse;
    StatusLine localStatusLine = paramHttpResponse.getStatusLine();
    if (localStatusLine.getStatusCode() >= 300)
    {
      String str = "response status error code:" + localStatusLine.getStatusCode();
      if ((localStatusLine.getStatusCode() == 416) && (this.isResume))
        str = str + " \n maybe you have download complete.";
      Object[] arrayOfObject3 = new Object[3];
      arrayOfObject3[0] = Integer.valueOf(3);
      arrayOfObject3[1] = new HttpResponseException(localStatusLine.getStatusCode(), localStatusLine.getReasonPhrase());
      arrayOfObject3[2] = str;
      publishProgress(arrayOfObject3);
      return;
    }
    while (true)
    {
      HttpEntity localHttpEntity;
      try
      {
        localHttpEntity = paramHttpResponse.getEntity();
        localObject1 = null;
        if (localHttpEntity != null)
        {
          this.time = SystemClock.uptimeMillis();
          if (this.targetUrl != null)
            localObject1 = this.mFileEntityHandler.handleEntity(localHttpEntity, this, this.targetUrl, this.isResume);
        }
        else
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = Integer.valueOf(4);
          arrayOfObject2[1] = localObject1;
          publishProgress(arrayOfObject2);
          return;
        }
      }
      catch (IOException localIOException)
      {
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = Integer.valueOf(3);
        arrayOfObject1[1] = localIOException;
        arrayOfObject1[2] = localIOException.getMessage();
        publishProgress(arrayOfObject1);
        return;
      }
      Object localObject2 = this.mStrEntityHandler.handleEntity(localHttpEntity, this, this.charset);
      Object localObject1 = localObject2;
    }
  }

  private void makeRequestWithRetries(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    this.httpUriRequest = paramHttpUriRequest;
    if ((this.isResume) && (this.targetUrl != null))
    {
      File localFile = new File(this.targetUrl);
      long l = 0L;
      if ((localFile.isFile()) && (localFile.exists()))
        l = localFile.length();
      if (l > 0L)
        paramHttpUriRequest.setHeader("RANGE", "bytes=" + l + "-");
    }
    boolean bool = true;
    Object localObject = null;
    HttpRequestRetryHandler localHttpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
    while (true)
    {
      if (!bool)
      {
        if (localObject == null)
          break;
        throw ((Throwable)localObject);
      }
      try
      {
        if (!isCancelled())
        {
          HttpResponse localHttpResponse = this.client.execute(paramHttpUriRequest, this.context);
          if (!isCancelled())
            handleResponse(localHttpResponse);
        }
        return;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = Integer.valueOf(3);
        arrayOfObject[1] = localUnknownHostException;
        arrayOfObject[2] = "unknownHostException：can't resolve host";
        publishProgress(arrayOfObject);
        return;
      }
      catch (IOException localIOException)
      {
        localObject = localIOException;
        int k = 1 + this.executionCount;
        this.executionCount = k;
        bool = localHttpRequestRetryHandler.retryRequest((IOException)localObject, k, this.context);
      }
      catch (NullPointerException localNullPointerException)
      {
        localObject = new IOException("NPE in HttpClient" + localNullPointerException.getMessage());
        int j = 1 + this.executionCount;
        this.executionCount = j;
        bool = localHttpRequestRetryHandler.retryRequest((IOException)localObject, j, this.context);
      }
      catch (Exception localException)
      {
        localObject = new IOException("Exception" + localException.getMessage());
        int i = 1 + this.executionCount;
        this.executionCount = i;
        bool = localHttpRequestRetryHandler.retryRequest((IOException)localObject, i, this.context);
      }
    }
    throw new IOException("未知网络错误");
  }

  public void callBack(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if ((this.callback != null) && (this.callback.isProgress()))
    {
      if (!paramBoolean)
        break label59;
      Object[] arrayOfObject2 = new Object[3];
      arrayOfObject2[0] = Integer.valueOf(2);
      arrayOfObject2[1] = Long.valueOf(paramLong1);
      arrayOfObject2[2] = Long.valueOf(paramLong2);
      publishProgress(arrayOfObject2);
    }
    label59: long l;
    do
    {
      return;
      l = SystemClock.uptimeMillis();
    }
    while (l - this.time < this.callback.getRate());
    this.time = l;
    Object[] arrayOfObject1 = new Object[3];
    arrayOfObject1[0] = Integer.valueOf(2);
    arrayOfObject1[1] = Long.valueOf(paramLong1);
    arrayOfObject1[2] = Long.valueOf(paramLong2);
    publishProgress(arrayOfObject1);
  }

  protected Object doInBackground(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3))
    {
      this.targetUrl = String.valueOf(paramArrayOfObject[1]);
      this.isResume = ((Boolean)paramArrayOfObject[2]).booleanValue();
    }
    try
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(1);
      publishProgress(arrayOfObject2);
      makeRequestWithRetries((HttpUriRequest)paramArrayOfObject[0]);
      return null;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = Integer.valueOf(3);
        arrayOfObject1[1] = localIOException;
        arrayOfObject1[2] = localIOException.getMessage();
        publishProgress(arrayOfObject1);
      }
    }
  }

  public HttpResponse getHttpResponse()
  {
    return this.httpResponse;
  }

  public HttpUriRequest getHttpUriRequest()
  {
    return this.httpUriRequest;
  }

  public boolean isStop()
  {
    return this.mFileEntityHandler.isStop();
  }

  protected void onProgressUpdate(Object[] paramArrayOfObject)
  {
    switch (Integer.valueOf(String.valueOf(paramArrayOfObject[0])).intValue())
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      super.onProgressUpdate(paramArrayOfObject);
      return;
      if (this.callback != null)
      {
        this.callback.onStart();
        continue;
        if (this.callback != null)
        {
          this.callback.onLoading(Long.valueOf(String.valueOf(paramArrayOfObject[1])).longValue(), Long.valueOf(String.valueOf(paramArrayOfObject[2])).longValue());
          continue;
          if (this.callback != null)
          {
            this.callback.onFailure((Throwable)paramArrayOfObject[1], (String)paramArrayOfObject[2]);
            continue;
            if (this.callback != null)
              this.callback.onSuccess(paramArrayOfObject[1]);
          }
        }
      }
    }
  }

  public void setHttpResponse(HttpResponse paramHttpResponse)
  {
    this.httpResponse = paramHttpResponse;
  }

  public void setHttpUriRequest(HttpUriRequest paramHttpUriRequest)
  {
    this.httpUriRequest = paramHttpUriRequest;
  }

  public void setRate(int paramInt)
  {
    if (this.callback != null)
      this.callback.setRate(paramInt);
  }

  public void stop()
  {
    this.mFileEntityHandler.setStop(true);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.HttpHandler
 * JD-Core Version:    0.6.2
 */