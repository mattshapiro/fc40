package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class af
{
  private static af c;
  private static final String z;
  private final String a = z;
  private SharedPreferences b = null;

  static
  {
    Object localObject1 = "+#\037*225\032x\017\025\003>".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    int m;
    Object localObject3;
    label27: int n;
    int i1;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      m = i;
      localObject3 = localObject1;
      n = localObject3[j];
      switch (k % 5)
      {
      default:
        i1 = 23;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject3[j] = ((char)(i1 ^ n));
      j = k + 1;
      if (m == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = m;
        break label27;
      }
      i = m;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i1 = 97;
      continue;
      i1 = 115;
      continue;
      i1 = 106;
      continue;
      i1 = 89;
    }
  }

  private SharedPreferences a(Context paramContext)
  {
    if (this.b == null);
    try
    {
      this.b = paramContext.getSharedPreferences(z, 0);
      return this.b;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static af a()
  {
    if (c == null)
      c = new af();
    return c;
  }

  public final long a(Context paramContext, String paramString, long paramLong)
  {
    return a(paramContext).getLong(paramString, paramLong);
  }

  public final String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext).getString(paramString1, null);
  }

  public final void b(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext).edit().putLong(paramString, paramLong).commit();
  }

  public final void b(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext).edit().putString(paramString1, paramString2).commit();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.af
 * JD-Core Version:    0.6.2
 */