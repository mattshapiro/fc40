package cn.jpush.android.util;

import cn.jpush.android.api.d;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class z
{
  public static final Pattern a;
  public static final Pattern b;
  public static final Pattern c;
  public static final Pattern d;
  public static final Pattern e;
  public static final Pattern f = Pattern.compile(str4);
  private static final String[] z;

  static
  {
    Object localObject1 = new String[3];
    int i = 0;
    String str1 = "K\001乫i龊%wR%\002o\033F\036pHqO";
    int j = -1;
    Object localObject2 = localObject1;
    int i16;
    label133: String str2;
    while (true)
    {
      Object localObject3 = str1.toCharArray();
      int k = localObject3.length;
      int m = 0;
      if (k <= 1);
      while (k > m)
      {
        Object localObject10 = localObject3;
        int i13 = m;
        int i14 = k;
        Object localObject11 = localObject3;
        while (true)
        {
          int i15 = localObject11[m];
          switch (i13 % 5)
          {
          default:
            i16 = 47;
            localObject11[m] = ((char)(i16 ^ i15));
            m = i13 + 1;
            if (i14 != 0)
              break label133;
            localObject11 = localObject10;
            i13 = m;
            m = i14;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        k = i14;
        localObject3 = localObject10;
      }
      str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "K\001乫i龊%wR%\002o\033F\036pH![h\033%'O";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "=rClttw\021\005\002OjF}8힥參i﷠﷥wﾄ\031ttw\021\005\002OjF}8힥參i﷠﷥wﾄ\030\002HpBnttw\021\005\002OjF}8힥參i﷠﷥wﾄ\031s;s@";
        j = 1;
        localObject1 = localObject2;
      case 1:
      }
    }
    localObject1[i] = str2;
    z = localObject2;
    String str3 = "";
    int n = -1;
    label237: String str4;
    while (true)
    {
      Object localObject4 = str3.toCharArray();
      int i1 = localObject4.length;
      int i2 = 0;
      if (i1 <= 1);
      label274: label561: 
      while (i1 > i2)
      {
        Object localObject8 = localObject4;
        int i9 = i2;
        int i10 = i1;
        Object localObject9 = localObject4;
        int i11 = localObject9[i2];
        int i12;
        switch (i9 % 5)
        {
        default:
          i12 = 47;
        case 0:
        case 1:
        case 2:
        case 3:
        }
        while (true)
        {
          localObject9[i2] = ((char)(i12 ^ i11));
          i2 = i9 + 1;
          if (i10 != 0)
            break label651;
          localObject9 = localObject8;
          i9 = i2;
          i2 = i10;
          break label274;
          i16 = 21;
          break;
          i16 = 90;
          break;
          i16 = 107;
          break;
          i16 = 68;
          break;
          c = Pattern.compile(str4);
          StringBuilder localStringBuilder = new StringBuilder(z[2]).append(a);
          Object localObject5 = "<&".toCharArray();
          int i3 = localObject5.length;
          int i4 = 0;
          if (i3 <= 1);
          while (i3 > i4)
          {
            Object localObject6 = localObject5;
            int i5 = i4;
            int i6 = i3;
            Object localObject7 = localObject5;
            int i7 = localObject7[i4];
            int i8;
            switch (i5 % 5)
            {
            default:
              i8 = 47;
            case 0:
            case 1:
            case 2:
            case 3:
            }
            while (true)
            {
              localObject7[i4] = ((char)(i8 ^ i7));
              i4 = i5 + 1;
              if (i6 != 0)
                break label561;
              localObject7 = localObject6;
              i5 = i4;
              i4 = i6;
              break;
              i8 = 21;
              continue;
              i8 = 90;
              continue;
              i8 = 107;
              continue;
              i8 = 68;
            }
            i3 = i6;
            localObject5 = localObject6;
          }
          d = Pattern.compile(new String((char[])localObject5).intern() + c + ")");
          str3 = "";
          n = 2;
          break label237;
          i12 = 21;
          continue;
          i12 = 90;
          continue;
          i12 = 107;
          continue;
          i12 = 68;
        }
        i1 = i10;
        localObject4 = localObject8;
      }
      label651: str4 = new String((char[])localObject4).intern();
      switch (n)
      {
      case 1:
      default:
        a = Pattern.compile(str4);
        str3 = "";
        n = 0;
        break;
      case 0:
        b = Pattern.compile(str4);
        str3 = "=rYqt%w^\031S'\001[i\033H\001[i\026H&0t\002$\0070t\002,\007\020vRi\001Zi\026H\001[i\026H&0u\002,\007B\030\001=h^\037\0378o68\035NjFprNjF}ri\001[i\036H\001[i\026H!Y9SNkF}rNjF}ri\001Zi\026H&[ms;rYqt%w^\031S'\001[i\033H\001[i\026H&0t\002$\0070t\002,\007\020vRi\001Zi\026H\001[i\026H&0u\002,\007\027t\006ItCv\032NjFqrih0t\002!\0070t\002,\007\027\037\0378k6\037\0378c6?\035h&0u\002,\0070t\002,\007\027\037\0378c6m\006";
        n = 1;
        break;
      case 2:
        e = Pattern.compile(str4);
        str3 = "=\006@\037\0378c6otIwK\030\001HpB{\007Ir0t\002,\007@\030\006N\006Fds;\007Am\020=\001[i\026H\001[i\026IwK\030\001H\001[i\026IwK\030\001Hq0t\002,\007B";
        n = 3;
      case 3:
      }
    }
  }

  public static int a(Set<String> paramSet)
  {
    if ((paramSet == null) || (paramSet.isEmpty()))
      return 0;
    if (paramSet.size() > 100)
      return d.g;
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str == null)
        return d.e;
      if (str.getBytes().length > 40)
        return d.f;
      if (!Pattern.compile(z[0]).matcher(str).matches())
        return d.e;
    }
    return 0;
  }

  public static boolean a(String paramString)
  {
    if (paramString == null)
      return false;
    return Pattern.compile(z[1]).matcher(paramString).matches();
  }

  public static int b(String paramString)
  {
    if ((paramString == null) || (ai.a(paramString)));
    do
    {
      return 0;
      if (paramString.getBytes().length > 40)
        return d.d;
    }
    while (Pattern.compile(z[0]).matcher(paramString).matches());
    return d.c;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.z
 * JD-Core Version:    0.6.2
 */