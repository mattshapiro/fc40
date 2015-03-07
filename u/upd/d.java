package u.upd;

import android.os.AsyncTask;

public class d extends g
{
  private static final String a = d.class.getName();

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
    private d.a c;

    public b(e parama, d.a arg3)
    {
      this.b = parama;
      Object localObject;
      this.c = localObject;
    }

    protected f.a a(Integer[] paramArrayOfInteger)
    {
      return d.this.a(this.b);
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
 * Qualified Name:     u.upd.d
 * JD-Core Version:    0.6.2
 */