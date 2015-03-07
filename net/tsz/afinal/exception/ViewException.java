package net.tsz.afinal.exception;

import java.io.PrintStream;

public class ViewException extends AfinalException
{
  private static final long serialVersionUID = 1L;
  private String strMsg = null;

  public ViewException(String paramString)
  {
    this.strMsg = paramString;
  }

  public void printStackTrace()
  {
    if (this.strMsg != null)
      System.err.println(this.strMsg);
    super.printStackTrace();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.exception.ViewException
 * JD-Core Version:    0.6.2
 */