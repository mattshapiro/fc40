package u.aly;

import android.content.Context;
import com.umeng.analytics.e;
import com.umeng.analytics.f;
import com.umeng.analytics.onlineconfig.a;
import com.umeng.analytics.onlineconfig.c;

public final class k
  implements o
{
  private static k c;
  private o a;
  private Context b;

  private k(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new j(this.b);
  }

  public static k a(Context paramContext)
  {
    try
    {
      if ((c == null) && (paramContext != null))
        c = new k(paramContext);
      k localk = c;
      return localk;
    }
    finally
    {
    }
  }

  public void a()
  {
    e.b(new f()
    {
      public void a()
      {
        k.a(k.this).a();
      }
    });
  }

  public void a(a parama)
  {
    if ((parama != null) && (this.a != null))
      parama.a((c)this.a);
  }

  public void a(o paramo)
  {
    this.a = paramo;
  }

  public void a(final p paramp)
  {
    e.b(new f()
    {
      public void a()
      {
        k.a(k.this).a(paramp);
      }
    });
  }

  public void b()
  {
    e.b(new f()
    {
      public void a()
      {
        k.a(k.this).b();
      }
    });
  }

  public void b(p paramp)
  {
    this.a.b(paramp);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.k
 * JD-Core Version:    0.6.2
 */