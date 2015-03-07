package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class ah
{
  private static SharedPreferences a;
  private static final String z;

  static
  {
    Object localObject1 = "\024g\034n$\024g\024y>8p\022t+\016t".toCharArray();
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
        i1 = 77;
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
      a = null;
      return;
      i1 = 103;
      continue;
      i1 = 19;
      continue;
      i1 = 125;
      continue;
      i1 = 26;
    }
  }

  public static long a(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext);
    return a.getLong(paramString, 0L);
  }

  private static SharedPreferences a(Context paramContext)
  {
    if (a == null)
      a = paramContext.getSharedPreferences(z, 0);
    return a;
  }

  public static void b(Context paramContext, String paramString, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramContext).edit();
    localEditor.putLong(paramString, paramLong);
    localEditor.commit();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.ah
 * JD-Core Version:    0.6.2
 */