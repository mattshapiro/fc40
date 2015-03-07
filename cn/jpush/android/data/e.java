package cn.jpush.android.data;

import cn.jpush.android.util.ai;

public final class e
{
  private static final String[] z;
  public String a;
  public String b;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "";
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
          i3 = 115;
          label96: localObject3[m] = ((char)(i3 ^ i2));
          m = n + 1;
          if (i1 != 0)
            break label133;
          localObject3 = localObject2;
          n = m;
          m = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label133: k = i1;
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
        str1 = "0?Q,\0329l\013S";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 93;
        break label96;
        i3 = 76;
        break label96;
        i3 = 54;
        break label96;
        i3 = 115;
        break label96;
        m = 0;
      }
    }
  }

  public e(d paramd1, d paramd2)
  {
    this.a = paramd2.c;
    this.b = paramd2.d;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof e));
    e locale;
    do
    {
      do
      {
        return false;
        locale = (e)paramObject;
      }
      while ((ai.a(this.a)) || (ai.a(locale.a)) || (!ai.a(this.a, locale.a)));
      if ((ai.a(this.b)) && (ai.a(locale.b)))
        return true;
    }
    while ((ai.a(this.b)) || (ai.a(locale.b)) || (!ai.a(this.b, locale.b)));
    return true;
  }

  public final String toString()
  {
    return z[1] + this.a + z[0] + this.b;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.e
 * JD-Core Version:    0.6.2
 */