package cn.jpush.android;

import android.os.Environment;
import java.io.File;

public abstract interface b
{
  public static final String a;
  public static final String b;

  static
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator);
    String str1 = "[vb\t)\035";
    int i = -1;
    Object localObject1 = str1.toCharArray();
    int j = localObject1.length;
    int k;
    if (j <= 1)
      k = 0;
    label273: 
    while (true)
    {
      Object localObject2 = localObject1;
      int m = k;
      int n = j;
      Object localObject3 = localObject1;
      int i1 = localObject3[k];
      int i2;
      switch (m % 5)
      {
      default:
        i2 = 90;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        localObject3[k] = ((char)(i2 ^ i1));
        k = m + 1;
        if (n != 0)
          break label169;
        localObject3 = localObject2;
        m = k;
        k = n;
        break;
        i2 = 117;
        continue;
        i2 = 28;
        continue;
        i2 = 18;
        continue;
        i2 = 124;
      }
      label169: j = n;
      localObject1 = localObject2;
      while (true)
      {
        if (j > k)
          break label273;
        String str2 = new String((char[])localObject1).intern();
        switch (i)
        {
        default:
          a = str2 + File.separator;
          localStringBuilder = new StringBuilder().append(a);
          str1 = "[vb\t)\035";
          i = 0;
          break;
        case 0:
          b = str2;
          return;
          k = 0;
        }
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.b
 * JD-Core Version:    0.6.2
 */