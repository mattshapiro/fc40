package com.stericson.RootTools;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Remounter
{
  private Mount findMountPointRecursive(String paramString)
  {
    File localFile;
    do
      try
      {
        ArrayList localArrayList = RootTools.getMounts();
        localFile = new File(paramString);
        continue;
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Mount localMount = (Mount)localIterator.next();
          boolean bool = localMount.getMountPoint().equals(localFile);
          if (bool)
            return localMount;
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException(localIOException);
      }
      catch (Exception localException)
      {
        if (RootTools.debugMode)
          localException.printStackTrace();
        return null;
      }
    while (localFile != null);
    return null;
  }

  // ERROR //
  protected boolean remount(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 69
    //   2: astore_3
    //   3: ldc 71
    //   5: invokestatic 75	com/stericson/RootTools/RootTools:checkUtil	(Ljava/lang/String;)Z
    //   8: ifeq +367 -> 375
    //   11: getstatic 79	com/stericson/RootTools/RootTools:utilPath	Ljava/lang/String;
    //   14: astore_3
    //   15: aload_1
    //   16: ldc 81
    //   18: invokevirtual 86	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   21: ifeq +15 -> 36
    //   24: aload_1
    //   25: iconst_0
    //   26: aload_1
    //   27: ldc 81
    //   29: invokevirtual 90	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   32: invokevirtual 94	java/lang/String:substring	(II)Ljava/lang/String;
    //   35: astore_1
    //   36: iconst_0
    //   37: istore 4
    //   39: iload 4
    //   41: ifeq +349 -> 390
    //   44: aload_0
    //   45: aload_1
    //   46: invokespecial 96	com/stericson/RootTools/Remounter:findMountPointRecursive	(Ljava/lang/String;)Lcom/stericson/RootTools/Mount;
    //   49: astore 12
    //   51: getstatic 101	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
    //   54: new 103	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 105
    //   60: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload 12
    //   65: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   68: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   71: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 116
    //   76: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   83: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 128	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   92: pop
    //   93: aload 12
    //   95: invokevirtual 132	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   98: aload_2
    //   99: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   102: invokeinterface 137 2 0
    //   107: ifne +201 -> 308
    //   110: new 139	com/stericson/RootTools/InternalMethods
    //   113: dup
    //   114: invokespecial 140	com/stericson/RootTools/InternalMethods:<init>	()V
    //   117: astore 15
    //   119: iconst_3
    //   120: anewarray 83	java/lang/String
    //   123: astore 17
    //   125: new 103	java/lang/StringBuilder
    //   128: dup
    //   129: aload_3
    //   130: invokestatic 144	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokespecial 106	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   136: ldc 146
    //   138: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 18
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: astore 19
    //   152: aload 19
    //   154: iconst_0
    //   155: aload_2
    //   156: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   159: aastore
    //   160: aload 19
    //   162: iconst_1
    //   163: aload 12
    //   165: invokevirtual 149	com/stericson/RootTools/Mount:getDevice	()Ljava/io/File;
    //   168: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   171: aastore
    //   172: aload 19
    //   174: iconst_2
    //   175: aload 12
    //   177: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   180: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   183: aastore
    //   184: aload 17
    //   186: iconst_0
    //   187: aload 18
    //   189: aload 19
    //   191: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   194: aastore
    //   195: iconst_3
    //   196: anewarray 4	java/lang/Object
    //   199: astore 20
    //   201: aload 20
    //   203: iconst_0
    //   204: aload_2
    //   205: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   208: aastore
    //   209: aload 20
    //   211: iconst_1
    //   212: aload 12
    //   214: invokevirtual 149	com/stericson/RootTools/Mount:getDevice	()Ljava/io/File;
    //   217: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   220: aastore
    //   221: aload 20
    //   223: iconst_2
    //   224: aload 12
    //   226: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   229: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   232: aastore
    //   233: aload 17
    //   235: iconst_1
    //   236: ldc 155
    //   238: aload 20
    //   240: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   243: aastore
    //   244: iconst_3
    //   245: anewarray 4	java/lang/Object
    //   248: astore 21
    //   250: aload 21
    //   252: iconst_0
    //   253: aload_2
    //   254: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   257: aastore
    //   258: aload 21
    //   260: iconst_1
    //   261: aload 12
    //   263: invokevirtual 149	com/stericson/RootTools/Mount:getDevice	()Ljava/io/File;
    //   266: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   269: aastore
    //   270: aload 21
    //   272: iconst_2
    //   273: aload 12
    //   275: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   278: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   281: aastore
    //   282: aload 17
    //   284: iconst_2
    //   285: ldc 157
    //   287: aload 21
    //   289: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   292: aastore
    //   293: aload 15
    //   295: aload 17
    //   297: iconst_m1
    //   298: invokevirtual 161	com/stericson/RootTools/InternalMethods:doExec	([Ljava/lang/String;I)V
    //   301: aload_0
    //   302: aload_1
    //   303: invokespecial 96	com/stericson/RootTools/Remounter:findMountPointRecursive	(Ljava/lang/String;)Lcom/stericson/RootTools/Mount;
    //   306: astore 12
    //   308: getstatic 101	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
    //   311: new 103	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   318: aload 12
    //   320: invokevirtual 132	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   323: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   326: ldc 167
    //   328: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_2
    //   332: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   335: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 128	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   344: pop
    //   345: aload 12
    //   347: invokevirtual 132	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   350: aload_2
    //   351: invokevirtual 119	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   354: invokeinterface 137 2 0
    //   359: ifeq +152 -> 511
    //   362: aload 12
    //   364: invokevirtual 132	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   367: invokevirtual 168	java/lang/Object:toString	()Ljava/lang/String;
    //   370: invokestatic 171	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   373: iconst_1
    //   374: ireturn
    //   375: ldc 173
    //   377: invokestatic 75	com/stericson/RootTools/RootTools:checkUtil	(Ljava/lang/String;)Z
    //   380: ifeq -365 -> 15
    //   383: getstatic 79	com/stericson/RootTools/RootTools:utilPath	Ljava/lang/String;
    //   386: astore_3
    //   387: goto -372 -> 15
    //   390: invokestatic 20	com/stericson/RootTools/RootTools:getMounts	()Ljava/util/ArrayList;
    //   393: invokevirtual 31	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   396: astore 6
    //   398: aload 6
    //   400: invokeinterface 37 1 0
    //   405: istore 7
    //   407: iload 7
    //   409: ifne +30 -> 439
    //   412: iload 4
    //   414: ifne -375 -> 39
    //   417: new 22	java/io/File
    //   420: dup
    //   421: aload_1
    //   422: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   425: invokevirtual 176	java/io/File:getParent	()Ljava/lang/String;
    //   428: invokevirtual 177	java/lang/String:toString	()Ljava/lang/String;
    //   431: astore 11
    //   433: aload 11
    //   435: astore_1
    //   436: goto -397 -> 39
    //   439: aload 6
    //   441: invokeinterface 41 1 0
    //   446: checkcast 43	com/stericson/RootTools/Mount
    //   449: astore 8
    //   451: aload 8
    //   453: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   456: invokevirtual 178	java/io/File:toString	()Ljava/lang/String;
    //   459: invokestatic 171	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   462: aload_1
    //   463: aload 8
    //   465: invokevirtual 47	com/stericson/RootTools/Mount:getMountPoint	()Ljava/io/File;
    //   468: invokevirtual 178	java/io/File:toString	()Ljava/lang/String;
    //   471: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   474: istore 9
    //   476: iload 9
    //   478: ifeq -80 -> 398
    //   481: iconst_1
    //   482: istore 4
    //   484: goto -72 -> 412
    //   487: astore 5
    //   489: getstatic 60	com/stericson/RootTools/RootTools:debugMode	Z
    //   492: ifeq +8 -> 500
    //   495: aload 5
    //   497: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   500: iconst_0
    //   501: ireturn
    //   502: astore 10
    //   504: aload 10
    //   506: invokevirtual 63	java/lang/Exception:printStackTrace	()V
    //   509: iconst_0
    //   510: ireturn
    //   511: aload 12
    //   513: invokevirtual 132	com/stericson/RootTools/Mount:getFlags	()Ljava/util/Set;
    //   516: invokevirtual 168	java/lang/Object:toString	()Ljava/lang/String;
    //   519: invokestatic 171	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   522: iconst_0
    //   523: ireturn
    //   524: astore 16
    //   526: goto -225 -> 301
    //
    // Exception table:
    //   from	to	target	type
    //   390	398	487	java/lang/Exception
    //   398	407	487	java/lang/Exception
    //   439	476	487	java/lang/Exception
    //   417	433	502	java/lang/Exception
    //   110	301	524	java/util/concurrent/TimeoutException
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Remounter
 * JD-Core Version:    0.6.2
 */