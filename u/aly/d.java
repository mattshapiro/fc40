package u.aly;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d
{
  private final String a = "umeng_it.cache";
  private File b;
  private as c = null;
  private long d;
  private long e;
  private Set<a> f = new HashSet();

  public d(Context paramContext)
  {
    this.b = new File(paramContext.getFilesDir(), "umeng_it.cache");
    this.e = 86400000L;
  }

  private void a(as paramas)
  {
    if (paramas != null);
    try
    {
      try
      {
        byte[] arrayOfByte = new ci().a(paramas);
        if (arrayOfByte != null)
          bv.a(this.b, arrayOfByte);
        return;
      }
      finally
      {
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void g()
  {
    as localas = new as();
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localas.a(localArrayList);
        localas.a(localHashMap);
      }
      try
      {
        this.c = localas;
        return;
        a locala = (a)localIterator.next();
        if (!locala.c())
          continue;
        if (locala.d() != null)
          localHashMap.put(locala.b(), locala.d());
        if ((locala.e() == null) || (locala.e().isEmpty()))
          continue;
        localArrayList.addAll(locala.e());
      }
      finally
      {
      }
    }
  }

  // ERROR //
  private as h()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	u/aly/d:b	Ljava/io/File;
    //   4: invokevirtual 131	java/io/File:exists	()Z
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: new 133	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 45	u/aly/d:b	Ljava/io/File;
    //   20: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokestatic 139	u/aly/bv:b	(Ljava/io/InputStream;)[B
    //   28: astore 4
    //   30: new 69	u/aly/as
    //   33: dup
    //   34: invokespecial 70	u/aly/as:<init>	()V
    //   37: astore 5
    //   39: new 141	u/aly/cc
    //   42: dup
    //   43: invokespecial 142	u/aly/cc:<init>	()V
    //   46: aload 5
    //   48: aload 4
    //   50: invokevirtual 145	u/aly/cc:a	(Lu/aly/bz;[B)V
    //   53: aload_1
    //   54: invokestatic 148	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   57: aload 5
    //   59: areturn
    //   60: astore_2
    //   61: aconst_null
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 66	java/lang/Exception:printStackTrace	()V
    //   67: aload_1
    //   68: invokestatic 148	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   71: aconst_null
    //   72: areturn
    //   73: astore 6
    //   75: aconst_null
    //   76: astore_1
    //   77: aload 6
    //   79: astore_3
    //   80: aload_1
    //   81: invokestatic 148	u/aly/bv:c	(Ljava/io/InputStream;)V
    //   84: aload_3
    //   85: athrow
    //   86: astore_3
    //   87: goto -7 -> 80
    //   90: astore_2
    //   91: goto -28 -> 63
    //
    // Exception table:
    //   from	to	target	type
    //   12	24	60	java/lang/Exception
    //   12	24	73	finally
    //   24	53	86	finally
    //   63	67	86	finally
    //   24	53	90	java/lang/Exception
  }

  public void a()
  {
    long l = System.currentTimeMillis();
    Iterator localIterator;
    int i;
    if (l - this.d >= this.e)
    {
      localIterator = this.f.iterator();
      i = 0;
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if (i != 0)
        {
          g();
          f();
        }
        this.d = l;
        return;
      }
      a locala = (a)localIterator.next();
      if (!locala.c())
        i = 1;
      else if (locala.a())
        i = 1;
    }
  }

  public void a(long paramLong)
  {
    this.e = paramLong;
  }

  public void a(a parama)
  {
    this.f.add(parama);
  }

  public as b()
  {
    return this.c;
  }

  public String c()
  {
    return null;
  }

  public void d()
  {
    Iterator localIterator = this.f.iterator();
    for (int i = 0; ; i = 1)
    {
      a locala;
      do
      {
        if (!localIterator.hasNext())
        {
          if (i != 0)
          {
            this.c.b(false);
            f();
          }
          return;
        }
        locala = (a)localIterator.next();
      }
      while ((!locala.c()) || (locala.e() == null) || (locala.e().isEmpty()));
      locala.a(null);
    }
  }

  public void e()
  {
    as localas = h();
    if (localas == null)
      return;
    ArrayList localArrayList = new ArrayList(this.f.size());
    while (true)
    {
      Iterator localIterator2;
      try
      {
        this.c = localas;
        Iterator localIterator1 = this.f.iterator();
        if (!localIterator1.hasNext())
        {
          localIterator2 = localArrayList.iterator();
          if (!localIterator2.hasNext())
            g();
        }
        else
        {
          a locala1 = (a)localIterator1.next();
          locala1.a(this.c);
          if (locala1.c())
            continue;
          localArrayList.add(locala1);
          continue;
        }
      }
      finally
      {
      }
      a locala2 = (a)localIterator2.next();
      this.f.remove(locala2);
    }
  }

  public void f()
  {
    if (this.c != null)
      a(this.c);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.d
 * JD-Core Version:    0.6.2
 */