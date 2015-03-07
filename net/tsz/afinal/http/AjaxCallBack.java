package net.tsz.afinal.http;

public abstract class AjaxCallBack<T>
{
  private boolean progress = true;
  private int rate = 1000;

  public int getRate()
  {
    return this.rate;
  }

  public boolean isProgress()
  {
    return this.progress;
  }

  public void onFailure(Throwable paramThrowable, String paramString)
  {
  }

  public void onLoading(long paramLong1, long paramLong2)
  {
  }

  public void onStart()
  {
  }

  public void onSuccess(T paramT)
  {
  }

  public AjaxCallBack<T> progress(boolean paramBoolean, int paramInt)
  {
    this.progress = paramBoolean;
    this.rate = paramInt;
    return this;
  }

  public void setRate(int paramInt)
  {
    this.rate = paramInt;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.AjaxCallBack
 * JD-Core Version:    0.6.2
 */