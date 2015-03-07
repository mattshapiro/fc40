package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;

public class NetworkDeniedImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;

  public NetworkDeniedImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }

  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default:
      return this.wrappedDownloader.getStream(paramString, paramObject);
    case 1:
    case 2:
    }
    throw new IllegalStateException();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.NetworkDeniedImageDownloader
 * JD-Core Version:    0.6.2
 */