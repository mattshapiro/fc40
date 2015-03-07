package cn.jpush.android;

public enum c
{
  private static final String[] z;

  static
  {
    Object localObject1 = new String[18];
    int i1 = 0;
    String str1 = "3\031W(:0\021J96,\023@\"(4\023N.";
    int i2 = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int i3 = localObject3.length;
    int i4 = 0;
    label36: Object localObject4;
    int i5;
    int i6;
    Object localObject5;
    label52: int i7;
    int i8;
    if (i3 <= 1)
    {
      localObject4 = localObject3;
      i5 = i4;
      i6 = i3;
      localObject5 = localObject3;
      i7 = localObject5[i4];
      switch (i5 % 5)
      {
      default:
        i8 = 105;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i4] = ((char)(i8 ^ i7));
      i4 = i5 + 1;
      if (i6 == 0)
      {
        localObject5 = localObject4;
        i5 = i4;
        i4 = i6;
        break label52;
      }
      i3 = i6;
      localObject3 = localObject4;
      if (i3 > i4)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (i2)
      {
      default:
        localObject1[i1] = str2;
        i1 = 1;
        str1 = "3\031W(:0\021J96(\007T56,\033J8";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "3\031W(:0\021J96(\007T566\027P";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "3\031W(:0\021J965\023_";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "3\031W(:0\021J960\023U)+=\023S";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "3\031W(:0\021J964\035@2<,";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "3\031W(:0\021J96<\027D>!9\034I8%1\026";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        i1 = 7;
        str1 = "3\031W(:0\021J96=\034F?%=\021O3'=\036N9";
        i2 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i1] = str2;
        i1 = 8;
        str1 = "3\031W(:0\021J96<\027D>!9\034I8%1\0265";
        i2 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i1] = str2;
        i1 = 9;
        str1 = "3\031W(:0\021J965\027T.(?\027";
        i2 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i1] = str2;
        i1 = 10;
        str1 = "3\031W(:0\021J96?\027S>!9\034I8%1\0265";
        i2 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i1] = str2;
        i1 = 11;
        str1 = "3\031W(:0\021J96-\034U8.;\032F3'=\033C";
        i2 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i1] = str2;
        i1 = 12;
        str1 = "3\031W(:0\021J96*\027@";
        i2 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i1] = str2;
        i1 = 13;
        str1 = "3\031W(:0\021J964\035@4'";
        i2 = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i1] = str2;
        i1 = 14;
        str1 = "3\031W(:0\rC8?1\021B)&3\027I\";=\002H/=";
        i2 = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i1] = str2;
        i1 = 15;
        str1 = "3\031W(:0\021J96?\027S>!9\034I8%1\026";
        i2 = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i1] = str2;
        i1 = 16;
        str1 = "3\031W(:0\021J96;\036N8',\001B3-5\001@";
        i2 = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i1] = str2;
        i1 = 17;
        str1 = "3\031W(:0\021J965\027T.(?\027B9";
        i2 = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i1] = str2;
        z = localObject2;
        a = new c(z[12], 0);
        b = new c(z[13], 1);
        c = new c(z[4], 2);
        d = new c(z[9], 3);
        e = new c(z[17], 4);
        f = new c(z[5], 5);
        g = new c(z[15], 6);
        h = new c(z[6], 7);
        i = new c(z[3], 8);
        j = new c(z[2], 9);
        k = new c(z[0], 10);
        l = new c(z[7], 11);
        m = new c(z[1], 12);
        n = new c(z[14], 13);
        o = new c(z[11], 14);
        p = new c(z[16], 15);
        q = new c(z[10], 16);
        r = new c(z[8], 17);
        c[] arrayOfc = new c[18];
        arrayOfc[0] = a;
        arrayOfc[1] = b;
        arrayOfc[2] = c;
        arrayOfc[3] = d;
        arrayOfc[4] = e;
        arrayOfc[5] = f;
        arrayOfc[6] = g;
        arrayOfc[7] = h;
        arrayOfc[8] = i;
        arrayOfc[9] = j;
        arrayOfc[10] = k;
        arrayOfc[11] = l;
        arrayOfc[12] = m;
        arrayOfc[13] = n;
        arrayOfc[14] = o;
        arrayOfc[15] = p;
        arrayOfc[16] = q;
        arrayOfc[17] = r;
        s = arrayOfc;
        return;
        i8 = 120;
        continue;
        i8 = 82;
        continue;
        i8 = 7;
        continue;
        i8 = 125;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.c
 * JD-Core Version:    0.6.2
 */