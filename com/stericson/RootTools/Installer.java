package com.stericson.RootTools;

import android.content.Context;
import java.io.File;
import java.io.IOException;

class Installer
{
  private static final String BOGUS_FILE_NAME = "bogus";
  private static final String LOG_TAG = "RootTools::Installer";
  private Context context;
  private String filesPath;

  public Installer(Context paramContext)
    throws IOException
  {
    this.context = paramContext;
    this.filesPath = paramContext.getFilesDir().getCanonicalPath();
  }

  // ERROR //
  protected boolean installBinary(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 31	java/io/File
    //   3: dup
    //   4: new 47	java/lang/StringBuilder
    //   7: dup
    //   8: aload_0
    //   9: getfield 37	com/stericson/RootTools/Installer:filesPath	Ljava/lang/String;
    //   12: invokestatic 53	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   15: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   21: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_2
    //   25: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: invokevirtual 71	java/io/File:exists	()Z
    //   41: ifne +144 -> 185
    //   44: aload_0
    //   45: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   48: ldc 8
    //   50: invokevirtual 75	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   53: invokevirtual 80	java/io/FileInputStream:close	()V
    //   56: aload_0
    //   57: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   60: invokevirtual 84	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   63: iload_1
    //   64: invokevirtual 90	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   67: astore 17
    //   69: aconst_null
    //   70: astore 18
    //   72: new 92	java/io/FileOutputStream
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   81: astore 19
    //   83: sipush 4096
    //   86: newarray byte
    //   88: astore 25
    //   90: aload 17
    //   92: aload 25
    //   94: invokevirtual 101	java/io/InputStream:read	([B)I
    //   97: istore 29
    //   99: iconst_m1
    //   100: iload 29
    //   102: if_icmpne +227 -> 329
    //   105: aload 19
    //   107: ifnull +8 -> 115
    //   110: aload 19
    //   112: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   115: aload 17
    //   117: invokevirtual 103	java/io/InputStream:close	()V
    //   120: new 105	com/stericson/RootTools/InternalMethods
    //   123: dup
    //   124: invokespecial 106	com/stericson/RootTools/InternalMethods:<init>	()V
    //   127: astore 32
    //   129: iconst_1
    //   130: anewarray 49	java/lang/String
    //   133: astore 34
    //   135: aload 34
    //   137: iconst_0
    //   138: new 47	java/lang/StringBuilder
    //   141: dup
    //   142: ldc 108
    //   144: invokespecial 56	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_3
    //   148: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc 110
    //   153: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 37	com/stericson/RootTools/Installer:filesPath	Ljava/lang/String;
    //   160: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: getstatic 59	java/io/File:separator	Ljava/lang/String;
    //   166: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: aastore
    //   177: aload 32
    //   179: aload 34
    //   181: iconst_m1
    //   182: invokevirtual 114	com/stericson/RootTools/InternalMethods:doExec	([Ljava/lang/String;I)V
    //   185: iconst_1
    //   186: ireturn
    //   187: astore 7
    //   189: aconst_null
    //   190: astore 8
    //   192: aload_0
    //   193: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   196: ldc 8
    //   198: iconst_0
    //   199: invokevirtual 118	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   202: astore 8
    //   204: aload 8
    //   206: ldc 120
    //   208: invokevirtual 124	java/lang/String:getBytes	()[B
    //   211: invokevirtual 128	java/io/FileOutputStream:write	([B)V
    //   214: aload 8
    //   216: ifnull -160 -> 56
    //   219: aload 8
    //   221: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   224: aload_0
    //   225: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   228: ldc 8
    //   230: invokevirtual 132	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   233: pop
    //   234: goto -178 -> 56
    //   237: astore 16
    //   239: goto -183 -> 56
    //   242: astore 12
    //   244: getstatic 138	com/stericson/RootTools/RootTools:debugMode	Z
    //   247: ifeq +14 -> 261
    //   250: ldc 11
    //   252: aload 12
    //   254: invokevirtual 139	java/lang/Exception:toString	()Ljava/lang/String;
    //   257: invokestatic 145	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   260: pop
    //   261: aload 8
    //   263: ifnull +18 -> 281
    //   266: aload 8
    //   268: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   271: aload_0
    //   272: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   275: ldc 8
    //   277: invokevirtual 132	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   280: pop
    //   281: iconst_0
    //   282: ireturn
    //   283: astore 9
    //   285: aload 8
    //   287: ifnull +18 -> 305
    //   290: aload 8
    //   292: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   295: aload_0
    //   296: getfield 23	com/stericson/RootTools/Installer:context	Landroid/content/Context;
    //   299: ldc 8
    //   301: invokevirtual 132	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   304: pop
    //   305: aload 9
    //   307: athrow
    //   308: astore 5
    //   310: getstatic 138	com/stericson/RootTools/RootTools:debugMode	Z
    //   313: ifeq +14 -> 327
    //   316: ldc 11
    //   318: aload 5
    //   320: invokevirtual 146	java/io/IOException:toString	()Ljava/lang/String;
    //   323: invokestatic 145	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   326: pop
    //   327: iconst_0
    //   328: ireturn
    //   329: aload 19
    //   331: aload 25
    //   333: iconst_0
    //   334: iload 29
    //   336: invokevirtual 149	java/io/FileOutputStream:write	([BII)V
    //   339: goto -249 -> 90
    //   342: astore 26
    //   344: getstatic 138	com/stericson/RootTools/RootTools:debugMode	Z
    //   347: ifeq +14 -> 361
    //   350: ldc 11
    //   352: aload 26
    //   354: invokevirtual 146	java/io/IOException:toString	()Ljava/lang/String;
    //   357: invokestatic 145	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   360: pop
    //   361: aload 19
    //   363: ifnull +8 -> 371
    //   366: aload 19
    //   368: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   371: iconst_0
    //   372: ireturn
    //   373: astore 20
    //   375: getstatic 138	com/stericson/RootTools/RootTools:debugMode	Z
    //   378: ifeq +14 -> 392
    //   381: ldc 11
    //   383: aload 20
    //   385: invokevirtual 150	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   388: invokestatic 145	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   391: pop
    //   392: aload 18
    //   394: ifnull +8 -> 402
    //   397: aload 18
    //   399: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   402: iconst_0
    //   403: ireturn
    //   404: astore 21
    //   406: aload 18
    //   408: ifnull +8 -> 416
    //   411: aload 18
    //   413: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   416: aload 21
    //   418: athrow
    //   419: astore 30
    //   421: getstatic 138	com/stericson/RootTools/RootTools:debugMode	Z
    //   424: ifeq +14 -> 438
    //   427: ldc 11
    //   429: aload 30
    //   431: invokevirtual 146	java/io/IOException:toString	()Ljava/lang/String;
    //   434: invokestatic 145	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   437: pop
    //   438: iconst_0
    //   439: ireturn
    //   440: astore 27
    //   442: goto -71 -> 371
    //   445: astore 23
    //   447: goto -45 -> 402
    //   450: astore 22
    //   452: goto -36 -> 416
    //   455: astore 35
    //   457: goto -342 -> 115
    //   460: astore 33
    //   462: goto -277 -> 185
    //   465: astore 21
    //   467: aload 19
    //   469: astore 18
    //   471: goto -65 -> 406
    //   474: astore 20
    //   476: aload 19
    //   478: astore 18
    //   480: goto -105 -> 375
    //   483: astore 10
    //   485: goto -180 -> 305
    //   488: astore 13
    //   490: goto -209 -> 281
    //
    // Exception table:
    //   from	to	target	type
    //   44	56	187	java/io/FileNotFoundException
    //   219	234	237	java/io/IOException
    //   192	214	242	java/lang/Exception
    //   192	214	283	finally
    //   244	261	283	finally
    //   44	56	308	java/io/IOException
    //   90	99	342	java/io/IOException
    //   329	339	342	java/io/IOException
    //   72	83	373	java/io/FileNotFoundException
    //   72	83	404	finally
    //   375	392	404	finally
    //   115	120	419	java/io/IOException
    //   366	371	440	java/io/IOException
    //   397	402	445	java/io/IOException
    //   411	416	450	java/io/IOException
    //   110	115	455	java/io/IOException
    //   120	185	460	java/util/concurrent/TimeoutException
    //   83	90	465	finally
    //   90	99	465	finally
    //   329	339	465	finally
    //   344	361	465	finally
    //   83	90	474	java/io/FileNotFoundException
    //   90	99	474	java/io/FileNotFoundException
    //   329	339	474	java/io/FileNotFoundException
    //   344	361	474	java/io/FileNotFoundException
    //   290	305	483	java/io/IOException
    //   266	281	488	java/io/IOException
  }

  protected boolean isBinaryInstalled(String paramString)
  {
    boolean bool1 = new File(this.filesPath + File.separator + paramString).exists();
    boolean bool2 = false;
    if (bool1)
      bool2 = true;
    return bool2;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Installer
 * JD-Core Version:    0.6.2
 */