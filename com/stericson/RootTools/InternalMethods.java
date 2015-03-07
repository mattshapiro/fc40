package com.stericson.RootTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.TimeoutException;

class InternalMethods
{
  protected void doExec(String[] paramArrayOfString, int paramInt)
    throws TimeoutException
  {
    Worker localWorker = new Worker(paramArrayOfString, null);
    localWorker.start();
    if (paramInt == -1)
      paramInt = 300000;
    long l = paramInt;
    try
    {
      localWorker.join(l);
      Thread.sleep(RootTools.shellDelay);
      if (localWorker.exit != -911)
        return;
      throw new TimeoutException();
    }
    catch (InterruptedException localInterruptedException)
    {
      localWorker.interrupt();
      Thread.currentThread().interrupt();
    }
    throw new TimeoutException();
  }

  protected long getConvertedSpace(String paramString)
  {
    double d = 1.0D;
    while (true)
    {
      char c;
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        int i = 0;
        if (i >= paramString.length())
          return ()Math.ceil(d * Double.valueOf(localStringBuffer.toString()).doubleValue());
        c = paramString.charAt(i);
        if ((!Character.isDigit(c)) && (c != '.'))
        {
          if (c != 'm')
            if (c != 'M')
              break label112;
        }
        else
        {
          localStringBuffer.append(paramString.charAt(i));
          i++;
          continue;
        }
      }
      catch (Exception localException)
      {
        return -1L;
      }
      d = 1024.0D;
      continue;
      label112: if ((c == 'g') || (c == 'G'))
        d = 1048576.0D;
    }
  }

  protected ArrayList<Mount> getMounts()
    throws FileNotFoundException, IOException
  {
    LineNumberReader localLineNumberReader = new LineNumberReader(new FileReader("/proc/mounts"));
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str = localLineNumberReader.readLine();
      if (str == null)
        return localArrayList;
      RootTools.log(str);
      String[] arrayOfString = str.split(" ");
      localArrayList.add(new Mount(new File(arrayOfString[0]), new File(arrayOfString[1]), arrayOfString[2], arrayOfString[3]));
    }
  }

  protected Permissions getPermissions(String paramString)
  {
    String str = paramString.split(" ")[0];
    if ((str.length() == 10) && ((str.charAt(0) == '-') || (str.charAt(0) == 'd') || (str.charAt(0) == 'l')) && ((str.charAt(1) == '-') || (str.charAt(1) == 'r')) && ((str.charAt(2) == '-') || (str.charAt(2) == 'w')))
    {
      RootTools.log(str);
      Permissions localPermissions = new Permissions();
      localPermissions.setType(str.substring(0, 1));
      RootTools.log(localPermissions.getType());
      localPermissions.setUserPermissions(str.substring(1, 4));
      RootTools.log(localPermissions.getUserPermissions());
      localPermissions.setGroupPermissions(str.substring(4, 7));
      RootTools.log(localPermissions.getGroupPermissions());
      localPermissions.setOtherPermissions(str.substring(7, 10));
      RootTools.log(localPermissions.getOtherPermissions());
      localPermissions.setPermissions(Integer.parseInt(new StringBuilder(String.valueOf(Integer.toString(parsePermissions(localPermissions.getUserPermissions())))).append(Integer.toString(parsePermissions(localPermissions.getGroupPermissions()))).toString() + Integer.toString(parsePermissions(localPermissions.getOtherPermissions()))));
      return localPermissions;
    }
    return null;
  }

  protected ArrayList<Symlink> getSymLinks()
    throws FileNotFoundException, IOException
  {
    LineNumberReader localLineNumberReader = new LineNumberReader(new FileReader("/data/local/symlinks.txt"));
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str = localLineNumberReader.readLine();
      if (str == null)
        return localArrayList;
      RootTools.log(str);
      String[] arrayOfString = str.split(" ");
      localArrayList.add(new Symlink(new File(arrayOfString[(-3 + arrayOfString.length)]), new File(arrayOfString[(-1 + arrayOfString.length)])));
    }
  }

  protected int parsePermissions(String paramString)
  {
    int i;
    int j;
    if (paramString.charAt(0) == 'r')
    {
      i = 4;
      RootTools.log("permission " + i);
      RootTools.log("character " + paramString.charAt(0));
      if (paramString.charAt(1) != 'w')
        break label176;
      j = i + 2;
      label68: RootTools.log("permission " + j);
      RootTools.log("character " + paramString.charAt(1));
      if (paramString.charAt(2) != 'x')
        break label183;
    }
    label176: label183: for (int k = j + 1; ; k = j + 0)
    {
      RootTools.log("permission " + k);
      RootTools.log("character " + paramString.charAt(2));
      return k;
      i = 0;
      break;
      j = i + 0;
      break label68;
    }
  }

  protected boolean returnPath()
    throws TimeoutException
  {
    if (!new File("/data/local/tmp").exists())
      doExec(new String[] { "mkdir /data/local/tmp" }, InternalVariables.timeout);
    try
    {
      InternalVariables.path = new HashSet();
      doExec(new String[] { "dd if=/init.rc of=/data/local/tmp/init.rc", "chmod 0777 /data/local/tmp/init.rc" }, InternalVariables.timeout);
      LineNumberReader localLineNumberReader = new LineNumberReader(new FileReader("/data/local/tmp/init.rc"));
      String str;
      do
      {
        str = localLineNumberReader.readLine();
        if (str == null)
          return false;
        RootTools.log(str);
      }
      while (!str.contains("export PATH"));
      InternalVariables.path = new HashSet(Arrays.asList(str.substring(str.indexOf("/")).split(":")));
      return true;
    }
    catch (Exception localException)
    {
      if (RootTools.debugMode)
      {
        RootTools.log("Error: " + localException.getMessage());
        localException.printStackTrace();
      }
    }
    return false;
  }

  private static class Worker extends Thread
  {
    private String[] commands;
    public int exit = -911;

    private Worker(String[] paramArrayOfString)
    {
      this.commands = paramArrayOfString;
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_1
      //   2: aconst_null
      //   3: astore_2
      //   4: aconst_null
      //   5: astore_3
      //   6: aconst_null
      //   7: astore 4
      //   9: invokestatic 31	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   12: invokevirtual 34	java/lang/Runtime:gc	()V
      //   15: invokestatic 31	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
      //   18: ldc 36
      //   20: invokevirtual 40	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
      //   23: astore_1
      //   24: new 42	java/io/DataOutputStream
      //   27: dup
      //   28: aload_1
      //   29: invokevirtual 48	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
      //   32: invokespecial 51	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
      //   35: astore 17
      //   37: new 53	java/io/InputStreamReader
      //   40: dup
      //   41: aload_1
      //   42: invokevirtual 57	java/lang/Process:getInputStream	()Ljava/io/InputStream;
      //   45: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   48: astore 18
      //   50: new 53	java/io/InputStreamReader
      //   53: dup
      //   54: aload_1
      //   55: invokevirtual 63	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
      //   58: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
      //   61: astore 19
      //   63: new 65	java/io/BufferedReader
      //   66: dup
      //   67: aload 18
      //   69: invokespecial 68	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   72: astore 20
      //   74: new 65	java/io/BufferedReader
      //   77: dup
      //   78: aload 19
      //   80: invokespecial 68	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   83: astore 21
      //   85: aload_0
      //   86: getfield 17	com/stericson/RootTools/InternalMethods$Worker:commands	[Ljava/lang/String;
      //   89: astore 23
      //   91: aload 23
      //   93: arraylength
      //   94: istore 24
      //   96: iconst_0
      //   97: istore 25
      //   99: iload 25
      //   101: iload 24
      //   103: if_icmplt +89 -> 192
      //   106: aload 17
      //   108: ldc 70
      //   110: invokevirtual 74	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   113: aload 17
      //   115: invokevirtual 77	java/io/DataOutputStream:flush	()V
      //   118: aload 20
      //   120: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   123: astore 26
      //   125: aload 21
      //   127: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   130: astore 27
      //   132: goto +869 -> 1001
      //   135: aload 27
      //   137: ifnonnull +465 -> 602
      //   140: aload_0
      //   141: aload_1
      //   142: invokevirtual 85	java/lang/Process:waitFor	()I
      //   145: putfield 15	com/stericson/RootTools/InternalMethods$Worker:exit	I
      //   148: aload_1
      //   149: ifnull +7 -> 156
      //   152: aload_1
      //   153: invokevirtual 88	java/lang/Process:destroy	()V
      //   156: aload 17
      //   158: ifnull +13 -> 171
      //   161: aload 17
      //   163: invokevirtual 77	java/io/DataOutputStream:flush	()V
      //   166: aload 17
      //   168: invokevirtual 91	java/io/DataOutputStream:close	()V
      //   171: aload 18
      //   173: ifnull +8 -> 181
      //   176: aload 18
      //   178: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   181: aload 19
      //   183: ifnull +668 -> 851
      //   186: aload 19
      //   188: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   191: return
      //   192: aload 23
      //   194: iload 25
      //   196: aaload
      //   197: astore 32
      //   199: new 94	java/lang/StringBuilder
      //   202: dup
      //   203: ldc 96
      //   205: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   208: aload 32
      //   210: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   213: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   216: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   219: aload 17
      //   221: new 94	java/lang/StringBuilder
      //   224: dup
      //   225: aload 32
      //   227: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   230: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   233: ldc 118
      //   235: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   238: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   241: invokevirtual 74	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
      //   244: aload 17
      //   246: invokevirtual 77	java/io/DataOutputStream:flush	()V
      //   249: iinc 25 1
      //   252: goto -153 -> 99
      //   255: aload_0
      //   256: getfield 17	com/stericson/RootTools/InternalMethods$Worker:commands	[Ljava/lang/String;
      //   259: iconst_0
      //   260: aaload
      //   261: ldc 120
      //   263: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   266: ifeq +51 -> 317
      //   269: new 126	java/util/HashSet
      //   272: dup
      //   273: aload 26
      //   275: ldc 128
      //   277: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   280: invokestatic 138	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
      //   283: invokespecial 141	java/util/HashSet:<init>	(Ljava/util/Collection;)V
      //   286: invokeinterface 147 1 0
      //   291: astore 31
      //   293: aload 31
      //   295: invokeinterface 153 1 0
      //   300: ifne +171 -> 471
      //   303: getstatic 159	com/stericson/RootTools/InternalVariables:accessGiven	Z
      //   306: ifne +11 -> 317
      //   309: getstatic 163	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
      //   312: ldc 165
      //   314: invokestatic 168	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;Ljava/lang/String;)V
      //   317: aload_0
      //   318: getfield 17	com/stericson/RootTools/InternalMethods$Worker:commands	[Ljava/lang/String;
      //   321: iconst_0
      //   322: aaload
      //   323: ldc 170
      //   325: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   328: ifeq +43 -> 371
      //   331: aload 26
      //   333: aload_0
      //   334: getfield 17	com/stericson/RootTools/InternalMethods$Worker:commands	[Ljava/lang/String;
      //   337: iconst_0
      //   338: aaload
      //   339: iconst_2
      //   340: aload_0
      //   341: getfield 17	com/stericson/RootTools/InternalMethods$Worker:commands	[Ljava/lang/String;
      //   344: iconst_0
      //   345: aaload
      //   346: invokevirtual 177	java/lang/String:length	()I
      //   349: invokevirtual 181	java/lang/String:substring	(II)Ljava/lang/String;
      //   352: invokevirtual 184	java/lang/String:trim	()Ljava/lang/String;
      //   355: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   358: ifeq +13 -> 371
      //   361: aload 26
      //   363: ldc 128
      //   365: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   368: putstatic 191	com/stericson/RootTools/InternalVariables:space	[Ljava/lang/String;
      //   371: aload_0
      //   372: getfield 17	com/stericson/RootTools/InternalMethods$Worker:commands	[Ljava/lang/String;
      //   375: iconst_0
      //   376: aaload
      //   377: ldc 193
      //   379: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   382: ifeq +25 -> 407
      //   385: aload 26
      //   387: ldc 195
      //   389: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   392: ifeq +15 -> 407
      //   395: aload 26
      //   397: ldc 128
      //   399: invokevirtual 132	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
      //   402: iconst_1
      //   403: aaload
      //   404: putstatic 198	com/stericson/RootTools/InternalVariables:busyboxVersion	Ljava/lang/String;
      //   407: aload_0
      //   408: getfield 17	com/stericson/RootTools/InternalMethods$Worker:commands	[Ljava/lang/String;
      //   411: iconst_0
      //   412: aaload
      //   413: ldc 200
      //   415: invokevirtual 174	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   418: ifeq +38 -> 456
      //   421: aload 26
      //   423: ldc 202
      //   425: invokevirtual 124	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   428: ifne +28 -> 456
      //   431: new 94	java/lang/StringBuilder
      //   434: dup
      //   435: ldc 204
      //   437: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   440: aload 26
      //   442: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   445: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   448: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   451: aload 26
      //   453: putstatic 207	com/stericson/RootTools/InternalVariables:pid	Ljava/lang/String;
      //   456: aload 26
      //   458: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   461: aload 20
      //   463: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   466: astore 26
      //   468: goto +533 -> 1001
      //   471: aload 31
      //   473: invokeinterface 211 1 0
      //   478: checkcast 112	java/lang/String
      //   481: invokevirtual 214	java/lang/String:toLowerCase	()Ljava/lang/String;
      //   484: ldc 216
      //   486: invokevirtual 188	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   489: ifeq -196 -> 293
      //   492: iconst_1
      //   493: putstatic 159	com/stericson/RootTools/InternalVariables:accessGiven	Z
      //   496: getstatic 163	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
      //   499: ldc 218
      //   501: invokestatic 168	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;Ljava/lang/String;)V
      //   504: goto -201 -> 303
      //   507: astore 22
      //   509: aload 19
      //   511: astore 7
      //   513: aload 18
      //   515: astore 8
      //   517: aload 17
      //   519: astore 6
      //   521: aload_1
      //   522: ifnull +7 -> 529
      //   525: aload_1
      //   526: invokevirtual 88	java/lang/Process:destroy	()V
      //   529: aload 6
      //   531: ifnull +13 -> 544
      //   534: aload 6
      //   536: invokevirtual 77	java/io/DataOutputStream:flush	()V
      //   539: aload 6
      //   541: invokevirtual 91	java/io/DataOutputStream:close	()V
      //   544: aload 8
      //   546: ifnull +8 -> 554
      //   549: aload 8
      //   551: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   554: aload 7
      //   556: ifnull -365 -> 191
      //   559: aload 7
      //   561: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   564: return
      //   565: astore 9
      //   567: getstatic 221	com/stericson/RootTools/RootTools:debugMode	Z
      //   570: ifeq -379 -> 191
      //   573: new 94	java/lang/StringBuilder
      //   576: dup
      //   577: ldc 223
      //   579: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   582: aload 9
      //   584: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   587: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   590: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   593: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   596: aload 9
      //   598: invokevirtual 229	java/lang/Exception:printStackTrace	()V
      //   601: return
      //   602: aload 27
      //   604: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   607: aload 21
      //   609: invokevirtual 81	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   612: astore 30
      //   614: aload 30
      //   616: astore 27
      //   618: goto -483 -> 135
      //   621: astore 14
      //   623: getstatic 221	com/stericson/RootTools/RootTools:debugMode	Z
      //   626: ifeq +31 -> 657
      //   629: new 94	java/lang/StringBuilder
      //   632: dup
      //   633: ldc 223
      //   635: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   638: aload 14
      //   640: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   643: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   646: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   649: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   652: aload 14
      //   654: invokevirtual 229	java/lang/Exception:printStackTrace	()V
      //   657: aload_1
      //   658: ifnull +7 -> 665
      //   661: aload_1
      //   662: invokevirtual 88	java/lang/Process:destroy	()V
      //   665: aload_2
      //   666: ifnull +11 -> 677
      //   669: aload_2
      //   670: invokevirtual 77	java/io/DataOutputStream:flush	()V
      //   673: aload_2
      //   674: invokevirtual 91	java/io/DataOutputStream:close	()V
      //   677: aload_3
      //   678: ifnull +7 -> 685
      //   681: aload_3
      //   682: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   685: aload 4
      //   687: ifnull -496 -> 191
      //   690: aload 4
      //   692: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   695: return
      //   696: astore 15
      //   698: getstatic 221	com/stericson/RootTools/RootTools:debugMode	Z
      //   701: ifeq -510 -> 191
      //   704: new 94	java/lang/StringBuilder
      //   707: dup
      //   708: ldc 223
      //   710: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   713: aload 15
      //   715: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   718: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   721: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   724: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   727: aload 15
      //   729: invokevirtual 229	java/lang/Exception:printStackTrace	()V
      //   732: return
      //   733: astore 11
      //   735: aload_1
      //   736: ifnull +7 -> 743
      //   739: aload_1
      //   740: invokevirtual 88	java/lang/Process:destroy	()V
      //   743: aload_2
      //   744: ifnull +11 -> 755
      //   747: aload_2
      //   748: invokevirtual 77	java/io/DataOutputStream:flush	()V
      //   751: aload_2
      //   752: invokevirtual 91	java/io/DataOutputStream:close	()V
      //   755: aload_3
      //   756: ifnull +7 -> 763
      //   759: aload_3
      //   760: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   763: aload 4
      //   765: ifnull +8 -> 773
      //   768: aload 4
      //   770: invokevirtual 92	java/io/InputStreamReader:close	()V
      //   773: aload 11
      //   775: athrow
      //   776: astore 12
      //   778: getstatic 221	com/stericson/RootTools/RootTools:debugMode	Z
      //   781: ifeq -8 -> 773
      //   784: new 94	java/lang/StringBuilder
      //   787: dup
      //   788: ldc 223
      //   790: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   793: aload 12
      //   795: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   798: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   801: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   804: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   807: aload 12
      //   809: invokevirtual 229	java/lang/Exception:printStackTrace	()V
      //   812: goto -39 -> 773
      //   815: astore 28
      //   817: getstatic 221	com/stericson/RootTools/RootTools:debugMode	Z
      //   820: ifeq +31 -> 851
      //   823: new 94	java/lang/StringBuilder
      //   826: dup
      //   827: ldc 223
      //   829: invokespecial 98	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   832: aload 28
      //   834: invokevirtual 226	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   837: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   840: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   843: invokestatic 110	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
      //   846: aload 28
      //   848: invokevirtual 229	java/lang/Exception:printStackTrace	()V
      //   851: return
      //   852: astore 10
      //   854: goto -325 -> 529
      //   857: astore 16
      //   859: goto -194 -> 665
      //   862: astore 13
      //   864: goto -121 -> 743
      //   867: astore 29
      //   869: goto -713 -> 156
      //   872: astore 11
      //   874: aload 17
      //   876: astore_2
      //   877: aconst_null
      //   878: astore 4
      //   880: aconst_null
      //   881: astore_3
      //   882: goto -147 -> 735
      //   885: astore 11
      //   887: aload 18
      //   889: astore_3
      //   890: aload 17
      //   892: astore_2
      //   893: aconst_null
      //   894: astore 4
      //   896: goto -161 -> 735
      //   899: astore 11
      //   901: aload 19
      //   903: astore 4
      //   905: aload 18
      //   907: astore_3
      //   908: aload 17
      //   910: astore_2
      //   911: goto -176 -> 735
      //   914: astore 14
      //   916: aload 17
      //   918: astore_2
      //   919: aconst_null
      //   920: astore 4
      //   922: aconst_null
      //   923: astore_3
      //   924: goto -301 -> 623
      //   927: astore 14
      //   929: aload 18
      //   931: astore_3
      //   932: aload 17
      //   934: astore_2
      //   935: aconst_null
      //   936: astore 4
      //   938: goto -315 -> 623
      //   941: astore 14
      //   943: aload 19
      //   945: astore 4
      //   947: aload 18
      //   949: astore_3
      //   950: aload 17
      //   952: astore_2
      //   953: goto -330 -> 623
      //   956: astore 5
      //   958: aconst_null
      //   959: astore 6
      //   961: aconst_null
      //   962: astore 7
      //   964: aconst_null
      //   965: astore 8
      //   967: goto -446 -> 521
      //   970: astore 34
      //   972: aload 17
      //   974: astore 6
      //   976: aconst_null
      //   977: astore 7
      //   979: aconst_null
      //   980: astore 8
      //   982: goto -461 -> 521
      //   985: astore 33
      //   987: aload 18
      //   989: astore 8
      //   991: aload 17
      //   993: astore 6
      //   995: aconst_null
      //   996: astore 7
      //   998: goto -477 -> 521
      //   1001: aload 26
      //   1003: ifnonnull -748 -> 255
      //   1006: goto -871 -> 135
      //
      // Exception table:
      //   from	to	target	type
      //   63	96	507	java/lang/InterruptedException
      //   106	132	507	java/lang/InterruptedException
      //   140	148	507	java/lang/InterruptedException
      //   192	249	507	java/lang/InterruptedException
      //   255	293	507	java/lang/InterruptedException
      //   293	303	507	java/lang/InterruptedException
      //   303	317	507	java/lang/InterruptedException
      //   317	371	507	java/lang/InterruptedException
      //   371	407	507	java/lang/InterruptedException
      //   407	456	507	java/lang/InterruptedException
      //   456	468	507	java/lang/InterruptedException
      //   471	504	507	java/lang/InterruptedException
      //   602	614	507	java/lang/InterruptedException
      //   534	544	565	java/lang/Exception
      //   549	554	565	java/lang/Exception
      //   559	564	565	java/lang/Exception
      //   9	37	621	java/lang/Exception
      //   669	677	696	java/lang/Exception
      //   681	685	696	java/lang/Exception
      //   690	695	696	java/lang/Exception
      //   9	37	733	finally
      //   623	657	733	finally
      //   747	755	776	java/lang/Exception
      //   759	763	776	java/lang/Exception
      //   768	773	776	java/lang/Exception
      //   161	171	815	java/lang/Exception
      //   176	181	815	java/lang/Exception
      //   186	191	815	java/lang/Exception
      //   525	529	852	java/lang/Exception
      //   661	665	857	java/lang/Exception
      //   739	743	862	java/lang/Exception
      //   152	156	867	java/lang/Exception
      //   37	50	872	finally
      //   50	63	885	finally
      //   63	96	899	finally
      //   106	132	899	finally
      //   140	148	899	finally
      //   192	249	899	finally
      //   255	293	899	finally
      //   293	303	899	finally
      //   303	317	899	finally
      //   317	371	899	finally
      //   371	407	899	finally
      //   407	456	899	finally
      //   456	468	899	finally
      //   471	504	899	finally
      //   602	614	899	finally
      //   37	50	914	java/lang/Exception
      //   50	63	927	java/lang/Exception
      //   63	96	941	java/lang/Exception
      //   106	132	941	java/lang/Exception
      //   140	148	941	java/lang/Exception
      //   192	249	941	java/lang/Exception
      //   255	293	941	java/lang/Exception
      //   293	303	941	java/lang/Exception
      //   303	317	941	java/lang/Exception
      //   317	371	941	java/lang/Exception
      //   371	407	941	java/lang/Exception
      //   407	456	941	java/lang/Exception
      //   456	468	941	java/lang/Exception
      //   471	504	941	java/lang/Exception
      //   602	614	941	java/lang/Exception
      //   9	37	956	java/lang/InterruptedException
      //   37	50	970	java/lang/InterruptedException
      //   50	63	985	java/lang/InterruptedException
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.InternalMethods
 * JD-Core Version:    0.6.2
 */