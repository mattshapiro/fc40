package com.umeng.update.net;

import android.os.AsyncTask;
import u.upd.b;
import u.upd.e;
import u.upd.f;
import u.upd.f.a;

public class g extends u.upd.g
{
  private static final String a = g.class.getName();

  public f.a a(e parame)
  {
    f localf = (f)a(parame, f.class);
    if (localf == null)
      return f.a.b;
    return localf.a;
  }

  public void a(e parame, a parama)
  {
    try
    {
      new b(parame, parama).execute(new Integer[0]);
      return;
    }
    catch (Exception localException)
    {
      do
        b.b(a, "", localException);
      while (parama == null);
      parama.a(f.a.b);
    }
  }

  public static abstract interface a
  {
    public abstract void a();

    public abstract void a(f.a parama);
  }

  private class b extends AsyncTask<Integer, Integer, f.a>
  {
    private e b;
    private g.a c;

    public b(e parama, g.a arg3)
    {
      this.b = parama;
      Object localObject;
      this.c = localObject;
    }

    protected f.a a(Integer[] paramArrayOfInteger)
    {
      return g.this.a(this.b);
    }

    protected void a(f.a parama)
    {
      if (this.c != null)
        this.c.a(parama);
    }

    protected void onPreExecute()
    {
      if (this.c != null)
        this.c.a();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.net.g
 * JD-Core Version:    0.6.2
 */