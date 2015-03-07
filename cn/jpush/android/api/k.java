package cn.jpush.android.api;

import android.app.Application;
import java.util.HashMap;

public final class k
{
  public static boolean a;
  private static boolean b = true;
  private static String c = new String((char[])localObject1).intern();
  private static HashMap<String, Integer> d = new HashMap();
  private static String e = null;
  private static String f = null;
  private static String g = null;

  static
  {
    a = false;
    Object localObject1 = "".toCharArray();
    int i = localObject1.length;
    int j = 0;
    if (i <= 1);
    label140: 
    while (i > j)
    {
      Object localObject2 = localObject1;
      int k = j;
      int m = i;
      Object localObject3 = localObject1;
      int n = localObject3[j];
      int i1;
      switch (k % 5)
      {
      default:
        i1 = 24;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        localObject3[j] = ((char)(i1 ^ n));
        j = k + 1;
        if (m != 0)
          break label140;
        localObject3 = localObject2;
        k = j;
        j = m;
        break;
        i1 = 69;
        continue;
        i1 = 16;
        continue;
        i1 = 99;
        continue;
        i1 = 114;
      }
      i = m;
      localObject1 = localObject2;
    }
  }

  public static void a(Application paramApplication)
  {
    l locall = new l();
    paramApplication.unregisterActivityLifecycleCallbacks(locall);
    paramApplication.registerActivityLifecycleCallbacks(locall);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.k
 * JD-Core Version:    0.6.2
 */