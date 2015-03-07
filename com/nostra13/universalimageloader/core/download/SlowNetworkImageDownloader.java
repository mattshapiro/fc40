package com.nostra13.universalimageloader.core.download;

import com.nostra13.universalimageloader.core.assist.FlushedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SlowNetworkImageDownloader
  implements ImageDownloader
{
  private final ImageDownloader wrappedDownloader;

  public SlowNetworkImageDownloader(ImageDownloader paramImageDownloader)
  {
    this.wrappedDownloader = paramImageDownloader;
  }

  public InputStream getStream(String paramString, Object paramObject)
    throws IOException
  {
    InputStream localInputStream = this.wrappedDownloader.getStream(paramString, paramObject);
    switch ($SWITCH_TABLE$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme()[ImageDownloader.Scheme.ofUri(paramString).ordinal()])
    {
    default:
      return localInputStream;
    case 1:
    case 2:
    }
    return new FlushedInputStream(localInputStream);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.SlowNetworkImageDownloader
 * JD-Core Version:    0.6.2
 */