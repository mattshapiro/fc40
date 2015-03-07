package net.tsz.afinal.bitmap.download;

import java.io.OutputStream;

public abstract interface Downloader
{
  public abstract boolean downloadToLocalStreamByUrl(String paramString, OutputStream paramOutputStream);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.download.Downloader
 * JD-Core Version:    0.6.2
 */