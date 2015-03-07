package com.allinone.free.mydownload;

import java.io.File;
import java.io.Serializable;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.HttpHandler;

public class DownloadFile
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private boolean isStop;
  private HttpHandler<File> mHttpHandler;

  public HttpHandler<File> getmHttpHandler()
  {
    return this.mHttpHandler;
  }

  public boolean isStop()
  {
    this.isStop = getmHttpHandler().isStop();
    return this.isStop;
  }

  public void setStop(boolean paramBoolean)
  {
    this.isStop = paramBoolean;
  }

  public void setmHttpHandler(HttpHandler<File> paramHttpHandler)
  {
    this.mHttpHandler = paramHttpHandler;
  }

  public DownloadFile startDownloadFileByUrl(String paramString1, String paramString2, AjaxCallBack<File> paramAjaxCallBack)
  {
    if (paramAjaxCallBack == null)
      throw new RuntimeException("AjaxCallBack对象不能为null");
    setmHttpHandler(new FinalHttp().download(paramString1, paramString2, true, paramAjaxCallBack));
    return this;
  }

  public DownloadFile startDownloadFileByUrlNoCatch(String paramString1, String paramString2, AjaxCallBack<File> paramAjaxCallBack)
  {
    if (paramAjaxCallBack == null)
      throw new RuntimeException("AjaxCallBack对象不能为null");
    setmHttpHandler(new FinalHttp().download(paramString1, paramString2, true, paramAjaxCallBack));
    return this;
  }

  public void stopDownload()
  {
    if (getmHttpHandler() != null)
    {
      getmHttpHandler().stop();
      getmHttpHandler().cancel(true);
      if (!getmHttpHandler().isStop())
      {
        getmHttpHandler().stop();
        getmHttpHandler().cancel(true);
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.mydownload.DownloadFile
 * JD-Core Version:    0.6.2
 */