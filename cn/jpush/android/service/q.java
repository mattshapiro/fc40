package cn.jpush.android.service;

import android.content.Context;
import java.lang.reflect.Method;

public final class q
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "vr{";
    int i = -1;
    String[] arrayOfString2 = arrayOfString1;
    int j = 0;
    Object localObject1 = str1.toCharArray();
    int k = localObject1.length;
    int m;
    label35: int i3;
    if (k <= 1)
    {
      m = 0;
      Object localObject2 = localObject1;
      int n = m;
      int i1 = k;
      Object localObject3 = localObject1;
      while (true)
      {
        int i2 = localObject3[m];
        switch (n % 5)
        {
        default:
          i3 = 3;
          label95: localObject3[m] = ((char)(i3 ^ i2));
          m = n + 1;
          if (i1 != 0)
            break label132;
          localObject3 = localObject2;
          n = m;
          m = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label132: k = i1;
      localObject1 = localObject2;
    }
    while (true)
    {
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject1).intern();
      switch (i)
      {
      default:
        arrayOfString2[j] = str2;
        str1 = "pykwlxs!jp?Dvvwtz_wlar}qjtd";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 17;
        break label95;
        i3 = 23;
        break label95;
        i3 = 15;
        break label95;
        i3 = 5;
        break label95;
        m = 0;
      }
    }
  }

  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Class localClass = paramContext.getClassLoader().loadClass(z[1]);
      Class[] arrayOfClass = { String.class, String.class };
      Method localMethod = localClass.getMethod(z[0], arrayOfClass);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = new String(paramString1);
      arrayOfObject[1] = new String(paramString2);
      String str = (String)localMethod.invoke(localClass, arrayOfObject);
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw localIllegalArgumentException;
    }
    catch (Exception localException)
    {
    }
    return paramString2;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.q
 * JD-Core Version:    0.6.2
 */