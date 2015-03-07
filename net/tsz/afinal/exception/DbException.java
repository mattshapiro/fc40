package net.tsz.afinal.exception;

public class DbException extends AfinalException
{
  private static final long serialVersionUID = 1L;

  public DbException()
  {
  }

  public DbException(String paramString)
  {
    super(paramString);
  }

  public DbException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }

  public DbException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.exception.DbException
 * JD-Core Version:    0.6.2
 */