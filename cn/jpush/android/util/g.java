package cn.jpush.android.util;

import java.io.File;

public final class g
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[5];
    String str1 = "T9;";
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
          i3 = 80;
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
        str1 = "m\025kt=}H.2\"v\020.'5k\013k&pp\0164t";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        str1 = "9\031at>v\t.:5|\031.78|\036et\035]H.7?}\030\"t\"|\t{&>9\t|!5";
        j = 2;
        arrayOfString2 = arrayOfString1;
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        str1 = "t\031;t9w]z<59\036b=5m]h=<|G.";
        j = 3;
        arrayOfString2 = arrayOfString1;
        i = 2;
        break;
      case 2:
        arrayOfString2[j] = str2;
        j = 4;
        arrayOfString2 = arrayOfString1;
        str1 = "t\031;t6k\022ct#|\017x1\"9\016g05#]";
        i = 3;
        break;
      case 3:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 25;
        break label96;
        i3 = 125;
        break label96;
        i3 = 14;
        break label96;
        i3 = 84;
        break label96;
        m = 0;
      }
    }
  }

  public static boolean a(String paramString, File paramFile)
  {
    new StringBuilder(z[4]).append(paramString).toString();
    x.c();
    if ((paramString == null) || ("".equals(paramString)))
    {
      new StringBuilder(z[1]).append(paramString).append(z[2]).toString();
      x.c();
      return true;
    }
    if ((!paramFile.exists()) || (paramFile.length() == 0L))
      return false;
    String str = b(paramFile);
    new StringBuilder(z[3]).append(str).toString();
    x.c();
    if ((str != null) && (!"".equals(str)) && (str.equals(paramString)))
    {
      x.c();
      return true;
    }
    x.c();
    return false;
  }

  // ERROR //
  private static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: new 80	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: sipush 1024
    //   12: newarray byte
    //   14: astore 9
    //   16: getstatic 34	cn/jpush/android/util/g:z	[Ljava/lang/String;
    //   19: iconst_0
    //   20: aaload
    //   21: invokestatic 89	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   24: astore 10
    //   26: aload_1
    //   27: aload 9
    //   29: invokevirtual 95	java/io/InputStream:read	([B)I
    //   32: istore 11
    //   34: iload 11
    //   36: ifle +13 -> 49
    //   39: aload 10
    //   41: aload 9
    //   43: iconst_0
    //   44: iload 11
    //   46: invokevirtual 99	java/security/MessageDigest:update	([BII)V
    //   49: iload 11
    //   51: iconst_m1
    //   52: if_icmpne -26 -> 26
    //   55: aload_1
    //   56: ifnull +7 -> 63
    //   59: aload_1
    //   60: invokevirtual 102	java/io/InputStream:close	()V
    //   63: aload 10
    //   65: invokevirtual 106	java/security/MessageDigest:digest	()[B
    //   68: astore 7
    //   70: aload 7
    //   72: areturn
    //   73: astore 12
    //   75: invokestatic 109	cn/jpush/android/util/x:h	()V
    //   78: aconst_null
    //   79: areturn
    //   80: astore 13
    //   82: aconst_null
    //   83: astore_1
    //   84: invokestatic 109	cn/jpush/android/util/x:h	()V
    //   87: aconst_null
    //   88: astore 7
    //   90: aload_1
    //   91: ifnull -21 -> 70
    //   94: aload_1
    //   95: invokevirtual 102	java/io/InputStream:close	()V
    //   98: aconst_null
    //   99: areturn
    //   100: astore 8
    //   102: invokestatic 109	cn/jpush/android/util/x:h	()V
    //   105: aconst_null
    //   106: areturn
    //   107: astore 5
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 4
    //   114: ifnull +8 -> 122
    //   117: aload 4
    //   119: invokevirtual 102	java/io/InputStream:close	()V
    //   122: aload 5
    //   124: athrow
    //   125: astore 6
    //   127: invokestatic 109	cn/jpush/android/util/x:h	()V
    //   130: aconst_null
    //   131: areturn
    //   132: astore_3
    //   133: aload_1
    //   134: astore 4
    //   136: aload_3
    //   137: astore 5
    //   139: goto -27 -> 112
    //   142: astore_2
    //   143: goto -59 -> 84
    //
    // Exception table:
    //   from	to	target	type
    //   59	63	73	java/io/IOException
    //   0	9	80	java/lang/Exception
    //   94	98	100	java/io/IOException
    //   0	9	107	finally
    //   117	122	125	java/io/IOException
    //   9	26	132	finally
    //   26	34	132	finally
    //   39	49	132	finally
    //   84	87	132	finally
    //   9	26	142	java/lang/Exception
    //   26	34	142	java/lang/Exception
    //   39	49	142	java/lang/Exception
  }

  private static String b(File paramFile)
  {
    byte[] arrayOfByte = a(paramFile);
    String str = "";
    if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      for (int i = 0; i < arrayOfByte.length; i++)
        str = str + Integer.toString(256 + (0xFF & arrayOfByte[i]), 16).substring(1);
    return str;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.g
 * JD-Core Version:    0.6.2
 */