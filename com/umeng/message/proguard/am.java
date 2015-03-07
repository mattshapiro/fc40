package com.umeng.message.proguard;

import android.content.Context;
import java.util.zip.Adler32;

public class am
{
  static String a = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
  static final Object b = new Object();
  static final byte c = 1;
  private static al d = null;

  static long a(al paramal)
  {
    if (paramal != null)
    {
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramal.f();
      arrayOfObject[1] = paramal.e();
      arrayOfObject[2] = Long.valueOf(paramal.b());
      arrayOfObject[3] = paramal.d();
      arrayOfObject[4] = paramal.c();
      String str = String.format("%s%s%s%s%s", arrayOfObject);
      if (!ad.a(str))
      {
        Adler32 localAdler32 = new Adler32();
        localAdler32.reset();
        localAdler32.update(str.getBytes());
        return localAdler32.getValue();
      }
    }
    return 0L;
  }

  public static al a(Context paramContext)
  {
    while (true)
    {
      try
      {
        if (d != null)
        {
          localal = d;
          return localal;
        }
        if (paramContext != null)
        {
          localal = b(paramContext);
          d = localal;
          continue;
        }
      }
      finally
      {
      }
      al localal = null;
    }
  }

  private static al b(Context paramContext)
  {
    if (paramContext != null)
    {
      new al();
      while (true)
      {
        String str1;
        synchronized (b)
        {
          str1 = ao.a(paramContext).a();
          if (!ad.a(str1))
          {
            if (!str1.endsWith("\n"))
              break label146;
            str2 = str1.substring(0, -1 + str1.length());
            al localal = new al();
            long l = System.currentTimeMillis();
            String str3 = ab.a(paramContext);
            String str4 = ab.b(paramContext);
            localal.c(str3);
            localal.a(str3);
            localal.b(l);
            localal.b(str4);
            localal.d(str2);
            localal.a(a(localal));
            return localal;
          }
        }
        label146: String str2 = str1;
      }
    }
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.am
 * JD-Core Version:    0.6.2
 */