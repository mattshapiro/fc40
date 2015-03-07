package net.tsz.afinal.http;

import java.io.IOException;
import java.net.UnknownHostException;
import net.tsz.afinal.http.entityhandler.StringEntityHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncRequestHandler
{
  private String charset;
  private final AbstractHttpClient client;
  private final HttpContext context;
  private final StringEntityHandler entityHandler = new StringEntityHandler();
  private int executionCount = 0;

  public SyncRequestHandler(AbstractHttpClient paramAbstractHttpClient, HttpContext paramHttpContext, String paramString)
  {
    this.client = paramAbstractHttpClient;
    this.context = paramHttpContext;
    this.charset = paramString;
  }

  private Object makeRequestWithRetries(HttpUriRequest paramHttpUriRequest)
    throws IOException
  {
    boolean bool = true;
    Object localObject1 = null;
    HttpRequestRetryHandler localHttpRequestRetryHandler = this.client.getHttpRequestRetryHandler();
    while (true)
    {
      if (!bool)
      {
        if (localObject1 == null)
          break;
        throw ((Throwable)localObject1);
      }
      try
      {
        HttpResponse localHttpResponse = this.client.execute(paramHttpUriRequest, this.context);
        Object localObject2 = this.entityHandler.handleEntity(localHttpResponse.getEntity(), null, this.charset);
        return localObject2;
      }
      catch (UnknownHostException localUnknownHostException)
      {
        localObject1 = localUnknownHostException;
        int m = 1 + this.executionCount;
        this.executionCount = m;
        bool = localHttpRequestRetryHandler.retryRequest((IOException)localObject1, m, this.context);
      }
      catch (IOException localIOException)
      {
        localObject1 = localIOException;
        int k = 1 + this.executionCount;
        this.executionCount = k;
        bool = localHttpRequestRetryHandler.retryRequest((IOException)localObject1, k, this.context);
      }
      catch (NullPointerException localNullPointerException)
      {
        localObject1 = new IOException("NPE in HttpClient" + localNullPointerException.getMessage());
        int j = 1 + this.executionCount;
        this.executionCount = j;
        bool = localHttpRequestRetryHandler.retryRequest((IOException)localObject1, j, this.context);
      }
      catch (Exception localException)
      {
        localObject1 = new IOException("Exception" + localException.getMessage());
        int i = 1 + this.executionCount;
        this.executionCount = i;
        bool = localHttpRequestRetryHandler.retryRequest((IOException)localObject1, i, this.context);
      }
    }
    throw new IOException("未知网络错误");
  }

  public Object sendRequest(HttpUriRequest[] paramArrayOfHttpUriRequest)
  {
    try
    {
      Object localObject = makeRequestWithRetries(paramArrayOfHttpUriRequest[0]);
      return localObject;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.SyncRequestHandler
 * JD-Core Version:    0.6.2
 */