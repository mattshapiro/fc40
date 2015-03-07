package com.nostra13.universalimageloader.core.download;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;

public class HttpClientImageDownloader extends BaseImageDownloader
{
  private HttpClient httpClient;

  public HttpClientImageDownloader(Context paramContext, HttpClient paramHttpClient)
  {
    super(paramContext);
    this.httpClient = paramHttpClient;
  }

  protected InputStream getStreamFromNetwork(String paramString, Object paramObject)
    throws IOException
  {
    HttpGet localHttpGet = new HttpGet(paramString);
    return new BufferedHttpEntity(this.httpClient.execute(localHttpGet).getEntity()).getContent();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.HttpClientImageDownloader
 * JD-Core Version:    0.6.2
 */