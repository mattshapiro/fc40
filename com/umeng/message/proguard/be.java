package com.umeng.message.proguard;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpException;

abstract class be
  implements bi
{
  protected static final int g = 8192;
  private static final char l = '\r';
  private static final char m = '\n';
  private static final String n = "UTF-8";
  private static final String o = "HttpChunked";
  private static final char[] x = { ' ' };
  protected volatile bf a = bf.d;
  protected volatile InputStream b = null;
  protected volatile int c = -1;
  protected volatile boolean d = true;
  protected volatile String e;
  protected volatile Map<String, String> f = new HashMap();
  private volatile ThreadPoolExecutor p = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
  private volatile bh q;
  private volatile Future<?> r = null;
  private volatile Future<?> s = null;
  private volatile String t;
  private volatile int u;
  private volatile int v = -1;
  private AtomicBoolean w = new AtomicBoolean(false);

  private void a(Context paramContext)
  {
    try
    {
      aU localaU = new aU(paramContext);
      if (localaU.a())
      {
        this.t = localaU.d();
        this.u = localaU.e();
        return;
      }
      this.t = null;
      this.u = -1;
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public static char byteToChar(byte[] paramArrayOfByte)
  {
    return (char)((0xFF & paramArrayOfByte[0]) << 8 | 0xFF & paramArrayOfByte[1]);
  }

  private void l()
  {
    this.v = -1;
  }

  private boolean m()
  {
    return (this.a == bf.c) || (this.a == bf.d);
  }

  protected void a()
  {
    callError(false);
    this.v = new Random().nextInt(10000);
  }

  protected final void a(int paramInt, Throwable paramThrowable)
  {
    disconnect(b());
    if (this.q != null)
      this.q.a(paramInt, new HashMap(), paramThrowable);
  }

  protected final void a(int paramInt, Map<String, String> paramMap)
  {
    disconnect(b());
    if (this.q != null)
      this.q.a(paramInt, paramMap, new HttpException("http chunked connectId:[" + b() + "] http Status code==" + paramInt));
  }

  protected abstract void a(String paramString);

  protected final void a(Map<String, String> paramMap)
  {
    if (this.q != null)
    {
      this.a = bf.b;
      this.q.a(b(), paramMap);
    }
  }

  protected final void a(char[] paramArrayOfChar)
  {
    if (this.q != null)
      this.q.a(paramArrayOfChar);
  }

  public void addHeader(String paramString1, String paramString2)
  {
    this.f.put(paramString1, paramString2);
  }

  protected int b()
  {
    return this.v;
  }

  protected final void b(String paramString)
  {
    this.q.a(paramString);
  }

  protected abstract void c();

  public void callError(boolean paramBoolean)
  {
    this.w.set(paramBoolean);
  }

  public final void close()
  {
    try
    {
      this.p.submit(new Runnable()
      {
        public void run()
        {
          try
          {
            be.this.disconnect(be.this.b());
            aJ.c("HttpChunked", "http chunked closing");
            be.this.d();
            aJ.c("HttpChunked", "http chunked closed");
            be.a(be.this);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      });
      if ((this.p != null) && (this.p.isShutdown()))
        this.p.shutdownNow();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public final void connect(Context paramContext, final String paramString, final long paramLong, bh parambh)
  {
    if (parambh == null)
    {
      aJ.c("HttpChunked", "eventHandler == null ");
      return;
    }
    this.e = paramString;
    if ((this.a == bf.b) || (this.a == bf.a))
    {
      aJ.c("HttpChunked", "http chunked connect url: [" + paramString + "] connectId:[" + b() + "] connecting......");
      return;
    }
    a(paramContext);
    this.q = parambh;
    this.a = bf.a;
    this.r = this.p.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          be.this.a();
          be.this.a(paramString);
          return;
        }
        catch (Throwable localThrowable)
        {
        }
      }
    });
    this.s = this.p.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          SystemClock.sleep(paramLong);
          label7: if ((be.this.a == bf.a) && (!be.this.hasCallError()))
          {
            be.this.callError(true);
            aJ.e("HttpChunked", "http chunked connect url: [" + this.b + "] connectId:[" + be.this.b() + "] http Status code==" + 408);
            be.this.a(408, new HttpException("connectId:[" + be.this.b() + "] http Status code==" + 408));
            be.a(be.this);
            be.this.g();
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          break label7;
        }
      }
    });
  }

  protected abstract void d();

  public final void disconnect(final int paramInt)
  {
    aJ.c("HttpChunked", "http chunked disconnect(" + paramInt + ")");
    if (b() != paramInt)
    {
      aJ.c("HttpChunked", "http chunked connect cId[" + paramInt + "] != mCId[" + b() + "]");
      this.a = bf.d;
      return;
    }
    if (m())
    {
      aJ.c("HttpChunked", "http chunked connect[" + paramInt + "] connection has been closed");
      return;
    }
    this.a = bf.c;
    this.p.submit(new Runnable()
    {
      public void run()
      {
        try
        {
          be.this.f();
          be.this.g();
          aJ.c("HttpChunked", "http chunked connect[" + paramInt + "] connection disconnecting");
          be.this.c();
          aJ.c("HttpChunked", "http chunked connect[" + paramInt + "] connection disconnected");
          be.this.h();
          return;
        }
        catch (Throwable localThrowable)
        {
        }
      }
    });
    this.a = bf.d;
  }

  protected final void e()
  {
    char[] arrayOfChar;
    InputStreamReader localInputStreamReader;
    StringBuffer localStringBuffer;
    int i;
    int j;
    try
    {
      arrayOfChar = new char[6];
      localInputStreamReader = new InputStreamReader(this.b, "UTF-8");
      localStringBuffer = new StringBuffer(8192);
      i = 0;
      while (true)
      {
        j = localInputStreamReader.read();
        if (j == -1)
          break;
        if (j != 32)
          break label376;
        a(x);
      }
    }
    catch (Throwable localThrowable)
    {
      if (!this.w.get())
      {
        this.w.set(true);
        aJ.d("HttpChunked", "Throwable connectId:[" + b() + "]==>", localThrowable);
        a(504, localThrowable);
      }
    }
    return;
    label126: int k;
    int i2;
    while (k == 64)
    {
      int i1 = (char)k;
      arrayOfChar[0] = i1;
      j = k;
      i2 = 0;
      label150: if (i2 >= 6)
        break label376;
      j = localInputStreamReader.read();
      arrayOfChar[(i2 + 1)] = ((char)j);
      if (i2 < 5)
        break label383;
      a(arrayOfChar);
      k = j;
    }
    label190: if (k != 10)
    {
      if (i == 0)
        break label389;
      localStringBuffer.append('\r');
      i = 0;
    }
    while (true)
    {
      label216: k = localInputStreamReader.read();
      if (k >= 0)
        break label190;
      if (TextUtils.isEmpty(localStringBuffer.toString()))
        break;
      b(localStringBuffer.toString());
      localStringBuffer.setLength(0);
      break;
      label376: label383: 
      do
      {
        localStringBuffer.append((char)k);
        break label216;
        if (this.a != bf.b)
          break;
        aJ.c("HttpChunked", "connectId:[" + b() + "]==>server data is abort");
        if (!hasCallError())
        {
          callError(true);
          a(504, new IOException("connectId:[" + b() + "] server data is abort"));
        }
        disconnect(b());
        return;
        k = j;
        break label126;
        i2++;
        break label150;
      }
      while (k != 13);
      label389: i = 1;
    }
  }

  protected final void f()
  {
    if (this.s != null)
      this.s.cancel(true);
  }

  protected final void g()
  {
    if (this.r != null)
      this.r.cancel(true);
  }

  protected final void h()
  {
    if ((this.q == null) && (m()));
    while (this.a != bf.b)
      return;
    this.q.a();
  }

  public boolean hasCallError()
  {
    return this.w.get();
  }

  protected final String i()
  {
    return this.t;
  }

  protected final int j()
  {
    return this.u;
  }

  protected final boolean k()
  {
    return (this.t != null) && (this.u != -1);
  }

  public final bf readyState()
  {
    return this.a;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.be
 * JD-Core Version:    0.6.2
 */