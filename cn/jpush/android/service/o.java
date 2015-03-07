package cn.jpush.android.service;

final class o
  implements Runnable
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "2LeIK\fLx^\n\006L+K\n\bEnIKL\004+";
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
          i3 = 107;
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
        str1 = "4m";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 97;
        break label96;
        i3 = 41;
        break label96;
        i3 = 11;
        break label96;
        i3 = 45;
        break label96;
        m = 0;
      }
    }
  }

  o(String paramString, byte[] paramArrayOfByte)
  {
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 48	java/net/DatagramSocket
    //   5: dup
    //   6: invokespecial 49	java/net/DatagramSocket:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: sipush 20000
    //   14: invokevirtual 53	java/net/DatagramSocket:setSoTimeout	(I)V
    //   17: new 55	java/io/ByteArrayOutputStream
    //   20: dup
    //   21: invokespecial 56	java/io/ByteArrayOutputStream:<init>	()V
    //   24: astore 13
    //   26: aload 13
    //   28: aload_0
    //   29: getfield 37	cn/jpush/android/service/o:a	Ljava/lang/String;
    //   32: invokevirtual 60	java/lang/String:getBytes	()[B
    //   35: invokevirtual 64	java/io/ByteArrayOutputStream:write	([B)V
    //   38: aload 13
    //   40: aload_0
    //   41: getfield 39	cn/jpush/android/service/o:b	[B
    //   44: invokevirtual 64	java/io/ByteArrayOutputStream:write	([B)V
    //   47: aload 13
    //   49: invokevirtual 67	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   52: astore 14
    //   54: new 55	java/io/ByteArrayOutputStream
    //   57: dup
    //   58: invokespecial 56	java/io/ByteArrayOutputStream:<init>	()V
    //   61: astore 15
    //   63: aload 15
    //   65: aload 14
    //   67: arraylength
    //   68: iconst_2
    //   69: invokestatic 72	cn/jpush/android/util/aa:a	(II)[B
    //   72: invokevirtual 64	java/io/ByteArrayOutputStream:write	([B)V
    //   75: aload 15
    //   77: aload 14
    //   79: invokevirtual 64	java/io/ByteArrayOutputStream:write	([B)V
    //   82: aload 15
    //   84: invokevirtual 67	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: astore 16
    //   89: getstatic 34	cn/jpush/android/service/o:z	[Ljava/lang/String;
    //   92: iconst_1
    //   93: aaload
    //   94: aload_0
    //   95: getfield 37	cn/jpush/android/service/o:a	Ljava/lang/String;
    //   98: invokevirtual 76	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: ifeq +45 -> 146
    //   104: invokestatic 81	cn/jpush/android/service/ServiceInterface:c	()Ljava/lang/String;
    //   107: astore 17
    //   109: invokestatic 85	cn/jpush/android/service/ServiceInterface:d	()I
    //   112: istore 19
    //   114: aload_2
    //   115: new 87	java/net/DatagramPacket
    //   118: dup
    //   119: aload 16
    //   121: aload 16
    //   123: arraylength
    //   124: aload 17
    //   126: invokestatic 93	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   129: iload 19
    //   131: invokespecial 96	java/net/DatagramPacket:<init>	([BILjava/net/InetAddress;I)V
    //   134: invokevirtual 100	java/net/DatagramSocket:send	(Ljava/net/DatagramPacket;)V
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 103	java/net/DatagramSocket:close	()V
    //   145: return
    //   146: invokestatic 106	cn/jpush/android/service/ServiceInterface:e	()Ljava/lang/String;
    //   149: astore 17
    //   151: invokestatic 109	cn/jpush/android/service/ServiceInterface:f	()I
    //   154: istore 18
    //   156: iload 18
    //   158: istore 19
    //   160: goto -46 -> 114
    //   163: astore 21
    //   165: aconst_null
    //   166: astore_2
    //   167: invokestatic 114	cn/jpush/android/util/x:h	()V
    //   170: new 16	java/lang/String
    //   173: dup
    //   174: aload_0
    //   175: getfield 39	cn/jpush/android/service/o:b	[B
    //   178: invokespecial 116	java/lang/String:<init>	([B)V
    //   181: astore 6
    //   183: new 118	java/lang/StringBuilder
    //   186: dup
    //   187: getstatic 34	cn/jpush/android/service/o:z	[Ljava/lang/String;
    //   190: iconst_0
    //   191: aaload
    //   192: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload 6
    //   197: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: pop
    //   204: invokestatic 130	cn/jpush/android/util/x:c	()V
    //   207: getstatic 135	cn/jpush/android/a:d	Landroid/content/Context;
    //   210: aload_0
    //   211: getfield 37	cn/jpush/android/service/o:a	Ljava/lang/String;
    //   214: aload 6
    //   216: invokestatic 140	cn/jpush/android/data/r:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   219: pop
    //   220: aload_2
    //   221: ifnull -76 -> 145
    //   224: aload_2
    //   225: invokevirtual 103	java/net/DatagramSocket:close	()V
    //   228: return
    //   229: astore 20
    //   231: aconst_null
    //   232: astore_2
    //   233: invokestatic 114	cn/jpush/android/util/x:h	()V
    //   236: new 16	java/lang/String
    //   239: dup
    //   240: aload_0
    //   241: getfield 39	cn/jpush/android/service/o:b	[B
    //   244: invokespecial 116	java/lang/String:<init>	([B)V
    //   247: astore 10
    //   249: new 118	java/lang/StringBuilder
    //   252: dup
    //   253: getstatic 34	cn/jpush/android/service/o:z	[Ljava/lang/String;
    //   256: iconst_0
    //   257: aaload
    //   258: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: aload 10
    //   263: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: pop
    //   270: invokestatic 130	cn/jpush/android/util/x:c	()V
    //   273: getstatic 135	cn/jpush/android/a:d	Landroid/content/Context;
    //   276: aload_0
    //   277: getfield 37	cn/jpush/android/service/o:a	Ljava/lang/String;
    //   280: aload 10
    //   282: invokestatic 140	cn/jpush/android/data/r:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   285: pop
    //   286: aload_2
    //   287: ifnull -142 -> 145
    //   290: aload_2
    //   291: invokevirtual 103	java/net/DatagramSocket:close	()V
    //   294: return
    //   295: astore 5
    //   297: aload_1
    //   298: ifnull +7 -> 305
    //   301: aload_1
    //   302: invokevirtual 103	java/net/DatagramSocket:close	()V
    //   305: aload 5
    //   307: athrow
    //   308: astore 4
    //   310: aload_2
    //   311: astore_1
    //   312: aload 4
    //   314: astore 5
    //   316: goto -19 -> 297
    //   319: astore 9
    //   321: goto -88 -> 233
    //   324: astore_3
    //   325: goto -158 -> 167
    //
    // Exception table:
    //   from	to	target	type
    //   2	10	163	java/net/SocketException
    //   2	10	229	java/io/IOException
    //   2	10	295	finally
    //   10	114	308	finally
    //   114	137	308	finally
    //   146	156	308	finally
    //   167	220	308	finally
    //   233	286	308	finally
    //   10	114	319	java/io/IOException
    //   114	137	319	java/io/IOException
    //   146	156	319	java/io/IOException
    //   10	114	324	java/net/SocketException
    //   114	137	324	java/net/SocketException
    //   146	156	324	java/net/SocketException
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.o
 * JD-Core Version:    0.6.2
 */