package com.stericson.RootTools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public class RootTools
{
  public static boolean debugMode = false;
  public static int lastExitCode;
  public static List<String> lastFoundBinaryPaths = new ArrayList();
  public static int shellDelay = 0;
  public static String utilPath;

  public static boolean checkUtil(String paramString)
  {
    Iterator localIterator;
    if (findBinary(paramString))
      localIterator = lastFoundBinaryPaths.iterator();
    String str;
    int i;
    do
    {
      Permissions localPermissions;
      do
      {
        if (!localIterator.hasNext())
          return false;
        str = (String)localIterator.next();
        localPermissions = getFilePermissions(str + "/" + paramString);
      }
      while (localPermissions == null);
      i = localPermissions.getPermissions();
    }
    while ((i != 755) && (i != 777) && (i != 775));
    utilPath = str + "/" + paramString;
    return true;
  }

  public static boolean checkUtils(String[] paramArrayOfString)
    throws Exception
  {
    int i = paramArrayOfString.length;
    int j = 0;
    boolean bool2;
    if (j >= i)
    {
      bool2 = true;
      label13: return bool2;
    }
    String str = paramArrayOfString[j];
    if (!checkUtil(str))
    {
      if (!checkUtil("busybox"))
        break label48;
      fixUtil(str, utilPath);
    }
    while (true)
    {
      j++;
      break;
      label48: boolean bool1 = checkUtil("toolbox");
      bool2 = false;
      if (!bool1)
        break label13;
      fixUtil(str, utilPath);
    }
  }

  public static boolean findBinary(String paramString)
  {
    int i = 0;
    boolean bool1 = false;
    lastFoundBinaryPaths.clear();
    log(InternalVariables.TAG, "Checking for " + paramString);
    String str1;
    try
    {
      Iterator localIterator = getPath().iterator();
      while (true)
      {
        boolean bool2 = localIterator.hasNext();
        if (!bool2)
        {
          if (!bool1)
          {
            log(InternalVariables.TAG, "Trying second method");
            log(InternalVariables.TAG, "Checking for " + paramString);
            arrayOfString = new String[] { "/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/" };
            int j = arrayOfString.length;
            if (i < j)
              break;
          }
          return bool1;
        }
        String str2 = (String)localIterator.next();
        if (new File(str2 + "/" + paramString).exists())
        {
          log(paramString + " was found here: " + str2);
          lastFoundBinaryPaths.add(str2);
          bool1 = true;
        }
        else
        {
          log(paramString + " was NOT found here: " + str2);
        }
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
        log(InternalVariables.TAG, "TimeoutException!!!");
    }
    catch (Exception localException)
    {
      String[] arrayOfString;
      while (true)
        log(InternalVariables.TAG, paramString + " was not found, more information MAY be available with Debugging on.");
      str1 = arrayOfString[i];
      if (!new File(str1 + paramString).exists())
        break label402;
    }
    log(paramString + " was found here: " + str1);
    lastFoundBinaryPaths.add(str1);
    bool1 = true;
    while (true)
    {
      i++;
      break;
      label402: log(paramString + " was NOT found here: " + str1);
    }
  }

  public static void fixUtil(String paramString1, String paramString2)
  {
    try
    {
      remount("/system", "rw");
      Iterator localIterator;
      if (findBinary(paramString1))
        localIterator = lastFoundBinaryPaths.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          String[] arrayOfString = new String[2];
          arrayOfString[0] = (paramString2 + " ln -s " + paramString2 + " /system/bin/" + paramString1);
          arrayOfString[1] = (paramString2 + " chmod 0755 /system/bin/" + paramString1);
          sendShell(arrayOfString, 10, InternalVariables.timeout);
          remount("/system", "ro");
          return;
        }
        String str = (String)localIterator.next();
        sendShell(paramString2 + " rm " + str + "/" + paramString1, InternalVariables.timeout);
      }
    }
    catch (Exception localException)
    {
    }
  }

  public static List<String> getBusyBoxApplets()
    throws Exception
  {
    List localList = sendShell("busybox --list", InternalVariables.timeout);
    if (localList != null)
      return localList;
    throw new Exception();
  }

  public static String getBusyBoxVersion()
  {
    log(InternalVariables.TAG, "Getting BusyBox Version");
    InternalVariables.busyboxVersion = null;
    try
    {
      new InternalMethods().doExec(new String[] { "busybox" }, InternalVariables.timeout);
      return InternalVariables.busyboxVersion;
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
        log(InternalVariables.TAG, "TimeoutException!!!");
    }
    catch (Exception localException)
    {
      log(InternalVariables.TAG, "BusyBox was not found, more information MAY be available with Debugging on.");
    }
    return "";
  }

  public static Permissions getFilePermissions(String paramString)
  {
    return getFilePermissionsSymlinks(paramString);
  }

  // ERROR //
  public static Permissions getFilePermissionsSymlinks(String paramString)
  {
    // Byte code:
    //   0: getstatic 106	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
    //   3: new 53	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 211
    //   9: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 111	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: new 138	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: invokevirtual 142	java/io/File:exists	()Z
    //   33: ifeq +282 -> 315
    //   36: ldc 206
    //   38: astore_1
    //   39: new 53	java/lang/StringBuilder
    //   42: dup
    //   43: aload_0
    //   44: invokestatic 57	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   47: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: ldc 213
    //   52: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 146	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   61: iconst_4
    //   62: anewarray 51	java/lang/String
    //   65: astore_3
    //   66: aload_3
    //   67: iconst_0
    //   68: new 53	java/lang/StringBuilder
    //   71: dup
    //   72: ldc 215
    //   74: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_0
    //   78: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: aastore
    //   85: aload_3
    //   86: iconst_1
    //   87: new 53	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 217
    //   93: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aastore
    //   104: aload_3
    //   105: iconst_2
    //   106: new 53	java/lang/StringBuilder
    //   109: dup
    //   110: ldc 219
    //   112: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   115: aload_0
    //   116: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: aastore
    //   123: aload_3
    //   124: iconst_3
    //   125: new 53	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 221
    //   131: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: aload_0
    //   135: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: aastore
    //   142: aload_3
    //   143: iconst_0
    //   144: getstatic 173	com/stericson/RootTools/InternalVariables:timeout	I
    //   147: invokestatic 177	com/stericson/RootTools/RootTools:sendShell	([Ljava/lang/String;II)Ljava/util/List;
    //   150: invokeinterface 39 1 0
    //   155: astore 4
    //   157: aload 4
    //   159: invokeinterface 45 1 0
    //   164: ifne +6 -> 170
    //   167: goto +148 -> 315
    //   170: aload 4
    //   172: invokeinterface 49 1 0
    //   177: checkcast 51	java/lang/String
    //   180: astore 5
    //   182: aload 5
    //   184: ldc 223
    //   186: invokevirtual 227	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   189: iconst_0
    //   190: aaload
    //   191: invokevirtual 230	java/lang/String:length	()I
    //   194: bipush 10
    //   196: if_icmpne +119 -> 315
    //   199: new 53	java/lang/StringBuilder
    //   202: dup
    //   203: ldc 232
    //   205: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload 5
    //   210: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 146	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   219: aload 5
    //   221: ldc 223
    //   223: invokevirtual 227	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   226: astore 9
    //   228: aload 9
    //   230: bipush 254
    //   232: aload 9
    //   234: arraylength
    //   235: iadd
    //   236: aaload
    //   237: ldc 234
    //   239: invokevirtual 237	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   242: ifeq +17 -> 259
    //   245: ldc 239
    //   247: invokestatic 146	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   250: aload 9
    //   252: iconst_m1
    //   253: aload 9
    //   255: arraylength
    //   256: iadd
    //   257: aaload
    //   258: astore_1
    //   259: new 197	com/stericson/RootTools/InternalMethods
    //   262: dup
    //   263: invokespecial 198	com/stericson/RootTools/InternalMethods:<init>	()V
    //   266: aload 5
    //   268: invokevirtual 241	com/stericson/RootTools/InternalMethods:getPermissions	(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;
    //   271: astore 8
    //   273: aload 8
    //   275: ifnull -118 -> 157
    //   278: aload 8
    //   280: aload_1
    //   281: invokevirtual 244	com/stericson/RootTools/Permissions:setSymlink	(Ljava/lang/String;)V
    //   284: aload 8
    //   286: areturn
    //   287: astore 7
    //   289: aload 7
    //   291: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokestatic 146	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   297: goto -140 -> 157
    //   300: astore_2
    //   301: aload_2
    //   302: invokevirtual 247	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokestatic 146	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;)V
    //   308: aconst_null
    //   309: areturn
    //   310: astore 6
    //   312: goto -53 -> 259
    //   315: aconst_null
    //   316: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   259	273	287	java/lang/Exception
    //   278	284	287	java/lang/Exception
    //   61	157	300	java/lang/Exception
    //   157	167	300	java/lang/Exception
    //   170	219	300	java/lang/Exception
    //   289	297	300	java/lang/Exception
    //   219	259	310	java/lang/Exception
  }

  public static ArrayList<Mount> getMounts()
    throws Exception
  {
    InternalVariables.mounts = new InternalMethods().getMounts();
    if (InternalVariables.mounts != null)
      return InternalVariables.mounts;
    throw new Exception();
  }

  public static Set<String> getPath()
    throws Exception
  {
    if (InternalVariables.path != null)
      return InternalVariables.path;
    if (new InternalMethods().returnPath())
      return InternalVariables.path;
    throw new Exception();
  }

  public static long getSpace(String paramString)
  {
    int i = 0;
    InternalVariables.getSpaceFor = paramString;
    int j = 0;
    String[] arrayOfString1 = new String[1];
    arrayOfString1[0] = ("df " + paramString);
    try
    {
      new InternalMethods().doExec(arrayOfString1, -1);
      label45: log("Looking for Space");
      String[] arrayOfString2;
      int m;
      int n;
      int i1;
      String[] arrayOfString3;
      int i2;
      if (InternalVariables.space != null)
      {
        log("First Method");
        arrayOfString2 = InternalVariables.space;
        int k = arrayOfString2.length;
        m = 0;
        if (m < k)
          break label136;
        n = 0;
        i1 = 3;
        log("Second Method");
        if (!InternalVariables.space[0].startsWith(paramString))
          i1 = 2;
        arrayOfString3 = InternalVariables.space;
        i2 = arrayOfString3.length;
      }
      while (true)
      {
        if (i >= i2)
        {
          log("Returning -1, space could not be determined.");
          return -1L;
          label136: String str1 = arrayOfString2[m];
          log(str1);
          if (j != 0)
            return new InternalMethods().getConvertedSpace(str1);
          if (str1.equals("used,"))
            j = 1;
          m++;
          break;
        }
        String str2 = arrayOfString3[i];
        log(str2);
        if (str2.length() > 0)
        {
          log(str2 + "Valid");
          if (n == i1)
            return new InternalMethods().getConvertedSpace(str2);
          n++;
        }
        i++;
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      break label45;
    }
  }

  public static String getSymlink(File paramFile)
  {
    log("Looking for Symlink for " + paramFile.toString());
    if (paramFile.exists())
    {
      log("File exists");
      try
      {
        String[] arrayOfString = ((String)sendShell("ls -l " + paramFile, InternalVariables.timeout).get(0)).split(" ");
        if (arrayOfString[(-2 + arrayOfString.length)].equals("->"))
        {
          log("Symlink found.");
          String str = arrayOfString[(-1 + arrayOfString.length)];
          return str;
        }
      }
      catch (Exception localException)
      {
      }
    }
    log("Symlink not found");
    return "";
  }

  public static ArrayList<Symlink> getSymlinks(String paramString)
    throws Exception
  {
    InternalMethods localInternalMethods = new InternalMethods();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("find " + paramString + " -type l -exec ls -l {} \\; > /data/local/symlinks.txt;");
    localInternalMethods.doExec(arrayOfString, -1);
    InternalVariables.symlinks = new InternalMethods().getSymLinks();
    if (InternalVariables.symlinks != null)
      return InternalVariables.symlinks;
    throw new Exception();
  }

  public static String getWorkingToolbox()
  {
    if (checkUtil("busybox"))
      return "busybox";
    if (checkUtil("toolbox"))
      return "toolbox";
    return "";
  }

  public static boolean hasEnoughSpaceOnSdCard(long paramLong)
  {
    log(InternalVariables.TAG, "Checking SDcard size and that it is mounted as RW");
    if (!Environment.getExternalStorageState().equals("mounted"));
    StatFs localStatFs;
    do
    {
      return false;
      localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    }
    while (paramLong >= localStatFs.getBlockSize() * localStatFs.getAvailableBlocks());
    return true;
  }

  public static boolean installBinary(Context paramContext, int paramInt, String paramString)
  {
    return installBinary(paramContext, paramInt, paramString, "700");
  }

  public static boolean installBinary(Context paramContext, int paramInt, String paramString1, String paramString2)
  {
    try
    {
      Installer localInstaller = new Installer(paramContext);
      return localInstaller.installBinary(paramInt, paramString1, paramString2);
    }
    catch (IOException localIOException)
    {
      if (debugMode)
        localIOException.printStackTrace();
    }
    return false;
  }

  public static boolean isAccessGiven()
    throws TimeoutException
  {
    shellDelay = 500;
    log(InternalVariables.TAG, "Checking for Root access");
    InternalVariables.accessGiven = false;
    new InternalMethods().doExec(new String[] { "id" }, InternalVariables.timeout);
    shellDelay = 0;
    return InternalVariables.accessGiven;
  }

  public static boolean isAppletAvailable(String paramString)
  {
    try
    {
      Iterator localIterator = getBusyBoxApplets().iterator();
      boolean bool;
      do
      {
        if (!localIterator.hasNext())
          return false;
        bool = ((String)localIterator.next()).equals(paramString);
      }
      while (!bool);
      return true;
    }
    catch (Exception localException)
    {
      log(localException.toString());
    }
    return false;
  }

  public static boolean isBusyboxAvailable()
  {
    return findBinary("busybox");
  }

  public static boolean isNativeToolsReady(int paramInt, Context paramContext)
  {
    log(InternalVariables.TAG, "Preparing Native Tools");
    Installer localInstaller;
    for (InternalVariables.nativeToolsReady = false; ; InternalVariables.nativeToolsReady = localInstaller.installBinary(paramInt, "nativetools", "700"))
      try
      {
        localInstaller = new Installer(paramContext);
        if (localInstaller.isBinaryInstalled("nativetools"))
        {
          InternalVariables.nativeToolsReady = true;
          bool1 = InternalVariables.nativeToolsReady;
          return bool1;
        }
      }
      catch (IOException localIOException)
      {
        boolean bool2;
        do
        {
          bool2 = debugMode;
          boolean bool1 = false;
        }
        while (!bool2);
        localIOException.printStackTrace();
        return false;
      }
  }

  public static boolean isProcessRunning(String paramString)
    throws TimeoutException
  {
    log(InternalVariables.TAG, "Checks if process is running: " + paramString);
    InternalVariables.pid = null;
    InternalMethods localInternalMethods = new InternalMethods();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = ("busybox pidof " + paramString);
    localInternalMethods.doExec(arrayOfString, InternalVariables.timeout);
    return InternalVariables.pid != null;
  }

  public static boolean isRootAvailable()
  {
    return findBinary("su");
  }

  // ERROR //
  public static boolean killProcess(String paramString)
  {
    // Byte code:
    //   0: getstatic 106	com/stericson/RootTools/InternalVariables:TAG	Ljava/lang/String;
    //   3: new 53	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 407
    //   10: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 111	com/stericson/RootTools/RootTools:log	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aconst_null
    //   24: putstatic 399	com/stericson/RootTools/InternalVariables:pid	Ljava/lang/String;
    //   27: new 197	com/stericson/RootTools/InternalMethods
    //   30: dup
    //   31: invokespecial 198	com/stericson/RootTools/InternalMethods:<init>	()V
    //   34: astore_1
    //   35: iconst_1
    //   36: anewarray 51	java/lang/String
    //   39: astore_3
    //   40: aload_3
    //   41: iconst_0
    //   42: new 53	java/lang/StringBuilder
    //   45: dup
    //   46: ldc_w 401
    //   49: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_0
    //   53: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aastore
    //   60: aload_1
    //   61: aload_3
    //   62: getstatic 173	com/stericson/RootTools/InternalVariables:timeout	I
    //   65: invokevirtual 202	com/stericson/RootTools/InternalMethods:doExec	([Ljava/lang/String;I)V
    //   68: getstatic 399	com/stericson/RootTools/InternalVariables:pid	Ljava/lang/String;
    //   71: ifnull +60 -> 131
    //   74: new 197	com/stericson/RootTools/InternalMethods
    //   77: dup
    //   78: invokespecial 198	com/stericson/RootTools/InternalMethods:<init>	()V
    //   81: astore 4
    //   83: iconst_1
    //   84: anewarray 51	java/lang/String
    //   87: astore 6
    //   89: aload 6
    //   91: iconst_0
    //   92: new 53	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 409
    //   99: invokespecial 60	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: getstatic 399	com/stericson/RootTools/InternalVariables:pid	Ljava/lang/String;
    //   105: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aastore
    //   112: aload 4
    //   114: aload 6
    //   116: getstatic 173	com/stericson/RootTools/InternalVariables:timeout	I
    //   119: invokevirtual 202	com/stericson/RootTools/InternalMethods:doExec	([Ljava/lang/String;I)V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_2
    //   125: iconst_0
    //   126: ireturn
    //   127: astore 5
    //   129: iconst_0
    //   130: ireturn
    //   131: iconst_0
    //   132: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   27	68	124	java/util/concurrent/TimeoutException
    //   74	122	127	java/util/concurrent/TimeoutException
  }

  public static void log(String paramString)
  {
    log(null, paramString);
  }

  public static void log(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.equals("")) && (debugMode))
    {
      if (paramString1 != null)
        Log.d(paramString1, paramString2);
    }
    else
      return;
    Log.d(InternalVariables.TAG, paramString2);
  }

  public static Intent offerBusyBox(Activity paramActivity, int paramInt)
  {
    log(InternalVariables.TAG, "Launching Market for BusyBox");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox"));
    paramActivity.startActivityForResult(localIntent, paramInt);
    return localIntent;
  }

  public static void offerBusyBox(Activity paramActivity)
  {
    log(InternalVariables.TAG, "Launching Market for BusyBox");
    paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=stericson.busybox")));
  }

  public static Intent offerSuperUser(Activity paramActivity, int paramInt)
  {
    log(InternalVariables.TAG, "Launching Market for SuperUser");
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.noshufou.android.su"));
    paramActivity.startActivityForResult(localIntent, paramInt);
    return localIntent;
  }

  public static void offerSuperUser(Activity paramActivity)
  {
    log(InternalVariables.TAG, "Launching Market for SuperUser");
    paramActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.noshufou.android.su")));
  }

  public static boolean remount(String paramString1, String paramString2)
  {
    return new Remounter().remount(paramString1, paramString2);
  }

  public static void restartAndroid()
    throws TimeoutException
  {
    log(InternalVariables.TAG, "Restart Android");
    new InternalMethods().doExec(new String[] { "busybox killall -9 zygote" }, InternalVariables.timeout);
  }

  public static void runBinary(Context paramContext, String paramString1, String paramString2)
  {
    new Runner(paramContext, paramString1, paramString2).start();
  }

  public static List<String> sendShell(String paramString, int paramInt)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(paramString, null, paramInt);
  }

  public static List<String> sendShell(String paramString, Result paramResult, int paramInt)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(new String[] { paramString }, 0, paramResult, paramInt);
  }

  public static List<String> sendShell(String[] paramArrayOfString, int paramInt1, int paramInt2)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(paramArrayOfString, paramInt1, null, paramInt2);
  }

  public static List<String> sendShell(String[] paramArrayOfString, int paramInt1, Result paramResult, int paramInt2)
    throws IOException, RootToolsException, TimeoutException
  {
    return sendShell(paramArrayOfString, paramInt1, paramResult, true, paramInt2);
  }

  public static List<String> sendShell(String[] paramArrayOfString, int paramInt1, Result paramResult, boolean paramBoolean, int paramInt2)
    throws IOException, RootToolsException, TimeoutException
  {
    return new Executer().sendShell(paramArrayOfString, paramInt1, paramResult, paramBoolean, paramInt2);
  }

  public static abstract class Result
    implements IResult
  {
    private Serializable data = null;
    private int error = 0;
    private Process process = null;

    public Serializable getData()
    {
      return this.data;
    }

    public int getError()
    {
      return this.error;
    }

    public Process getProcess()
    {
      return this.process;
    }

    public abstract void onComplete(int paramInt);

    public abstract void onFailure(Exception paramException);

    public abstract void process(String paramString)
      throws Exception;

    public abstract void processError(String paramString)
      throws Exception;

    public Result setData(Serializable paramSerializable)
    {
      this.data = paramSerializable;
      return this;
    }

    public Result setError(int paramInt)
    {
      this.error = paramInt;
      return this;
    }

    public Result setProcess(Process paramProcess)
    {
      this.process = paramProcess;
      return this;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.RootTools
 * JD-Core Version:    0.6.2
 */