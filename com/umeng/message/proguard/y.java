package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface y extends z
{
  public abstract a O();

  public abstract a P();

  public abstract void a(i parami)
    throws IOException;

  public abstract void a(OutputStream paramOutputStream)
    throws IOException;

  public abstract void b(OutputStream paramOutputStream)
    throws IOException;

  public abstract int d();

  public abstract g f();

  public abstract byte[] g();

  public abstract B<? extends y> m();

  public static abstract interface a extends z, Cloneable
  {
    public abstract y al();

    public abstract y am();

    public abstract boolean b(InputStream paramInputStream)
      throws IOException;

    public abstract boolean b(InputStream paramInputStream, n paramn)
      throws IOException;

    public abstract a c(g paramg)
      throws s;

    public abstract a c(g paramg, n paramn)
      throws s;

    public abstract a c(h paramh)
      throws IOException;

    public abstract a c(h paramh, n paramn)
      throws IOException;

    public abstract a c(byte[] paramArrayOfByte)
      throws s;

    public abstract a c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws s;

    public abstract a c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, n paramn)
      throws s;

    public abstract a c(byte[] paramArrayOfByte, n paramn)
      throws s;

    public abstract a d(InputStream paramInputStream)
      throws IOException;

    public abstract a d(InputStream paramInputStream, n paramn)
      throws IOException;

    public abstract a g();

    public abstract a h();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.y
 * JD-Core Version:    0.6.2
 */