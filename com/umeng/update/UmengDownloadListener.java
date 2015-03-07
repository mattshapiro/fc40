package com.umeng.update;

public abstract interface UmengDownloadListener
{
  public abstract void OnDownloadEnd(int paramInt, String paramString);

  public abstract void OnDownloadStart();

  public abstract void OnDownloadUpdate(int paramInt);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.UmengDownloadListener
 * JD-Core Version:    0.6.2
 */