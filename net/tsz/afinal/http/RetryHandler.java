package net.tsz.afinal.http;

import android.os.SystemClock;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public class RetryHandler
  implements HttpRequestRetryHandler
{
  private static final int RETRY_SLEEP_TIME_MILLIS = 1000;
  private static HashSet<Class<?>> exceptionBlacklist;
  private static HashSet<Class<?>> exceptionWhitelist = new HashSet();
  private final int maxRetries;

  static
  {
    exceptionBlacklist = new HashSet();
    exceptionWhitelist.add(NoHttpResponseException.class);
    exceptionWhitelist.add(UnknownHostException.class);
    exceptionWhitelist.add(SocketException.class);
    exceptionBlacklist.add(InterruptedIOException.class);
    exceptionBlacklist.add(SSLHandshakeException.class);
  }

  public RetryHandler(int paramInt)
  {
    this.maxRetries = paramInt;
  }

  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool = true;
    Boolean localBoolean = (Boolean)paramHttpContext.getAttribute("http.request_sent");
    int i;
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      i = 1;
      if (paramInt <= this.maxRetries)
        break label104;
      bool = false;
      label43: if (bool)
      {
        HttpUriRequest localHttpUriRequest = (HttpUriRequest)paramHttpContext.getAttribute("http.request");
        if ((localHttpUriRequest == null) || ("POST".equals(localHttpUriRequest.getMethod())))
          break label153;
      }
    }
    label153: for (bool = true; ; bool = false)
    {
      if (!bool)
        break label159;
      SystemClock.sleep(1000L);
      return bool;
      i = 0;
      break;
      label104: if (exceptionBlacklist.contains(paramIOException.getClass()))
      {
        bool = false;
        break label43;
      }
      if (exceptionWhitelist.contains(paramIOException.getClass()))
      {
        bool = true;
        break label43;
      }
      if (i != 0)
        break label43;
      bool = true;
      break label43;
    }
    label159: paramIOException.printStackTrace();
    return bool;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.RetryHandler
 * JD-Core Version:    0.6.2
 */