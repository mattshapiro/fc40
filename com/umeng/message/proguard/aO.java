package com.umeng.message.proguard;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class aO
  implements aK
{
  private static final int a = 2;
  private static final int b = 10485760;
  private volatile boolean c = true;
  private volatile boolean d = false;
  private volatile Logger e;

  public aO()
  {
    this(false, false);
  }

  public aO(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      this.c = paramBoolean1;
      this.d = paramBoolean2;
      if (a())
      {
        this.c = true;
        this.d = true;
      }
      b();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  // ERROR //
  private static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 39	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   9: ldc 42
    //   11: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: iload_0
    //   15: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   18: ldc 51
    //   20: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore_2
    //   27: new 39	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   34: ldc 42
    //   36: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_0
    //   40: invokevirtual 49	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: ldc 57
    //   45: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore_3
    //   52: ldc 59
    //   54: astore 4
    //   56: new 61	java/io/File
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: new 66	java/io/BufferedReader
    //   69: dup
    //   70: new 68	java/io/FileReader
    //   73: dup
    //   74: aload 5
    //   76: invokespecial 71	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   79: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   82: astore 6
    //   84: aload 6
    //   86: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 12
    //   91: aload 12
    //   93: invokestatic 83	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: ifne +44 -> 140
    //   99: aload 12
    //   101: iconst_0
    //   102: aload 12
    //   104: iconst_0
    //   105: invokevirtual 89	java/lang/String:indexOf	(I)I
    //   108: invokevirtual 93	java/lang/String:substring	(II)Ljava/lang/String;
    //   111: astore 19
    //   113: aload 19
    //   115: astore 4
    //   117: aload 6
    //   119: astore_1
    //   120: aload 5
    //   122: astore 10
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 96	java/io/BufferedReader:close	()V
    //   132: aload 10
    //   134: ifnull +3 -> 137
    //   137: aload 4
    //   139: areturn
    //   140: new 61	java/io/File
    //   143: dup
    //   144: aload_3
    //   145: invokespecial 64	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore 10
    //   150: aload 6
    //   152: invokevirtual 96	java/io/BufferedReader:close	()V
    //   155: new 66	java/io/BufferedReader
    //   158: dup
    //   159: new 68	java/io/FileReader
    //   162: dup
    //   163: aload 10
    //   165: invokespecial 71	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   168: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   171: astore_1
    //   172: aload_1
    //   173: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   176: astore 15
    //   178: aload 15
    //   180: ifnull -56 -> 124
    //   183: aload 15
    //   185: ldc 98
    //   187: invokevirtual 102	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   190: ifeq +31 -> 221
    //   193: aload 15
    //   195: ldc 104
    //   197: invokevirtual 107	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   200: istore 17
    //   202: iload 17
    //   204: iflt -80 -> 124
    //   207: aload 15
    //   209: iload 17
    //   211: iconst_1
    //   212: iadd
    //   213: invokevirtual 109	java/lang/String:substring	(I)Ljava/lang/String;
    //   216: astore 4
    //   218: goto -94 -> 124
    //   221: aload_1
    //   222: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   225: astore 16
    //   227: aload 16
    //   229: astore 15
    //   231: goto -53 -> 178
    //   234: astore 21
    //   236: aconst_null
    //   237: astore 6
    //   239: aload 6
    //   241: ifnull +8 -> 249
    //   244: aload 6
    //   246: invokevirtual 96	java/io/BufferedReader:close	()V
    //   249: aload_1
    //   250: ifnull -113 -> 137
    //   253: aload 4
    //   255: areturn
    //   256: astore 9
    //   258: aconst_null
    //   259: astore 10
    //   261: aload_1
    //   262: ifnull +7 -> 269
    //   265: aload_1
    //   266: invokevirtual 96	java/io/BufferedReader:close	()V
    //   269: aload 10
    //   271: ifnull +3 -> 274
    //   274: aload 9
    //   276: athrow
    //   277: astore 18
    //   279: goto -147 -> 132
    //   282: astore 8
    //   284: goto -35 -> 249
    //   287: astore 11
    //   289: goto -20 -> 269
    //   292: astore 9
    //   294: aload 5
    //   296: astore 10
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -39 -> 261
    //   303: astore 9
    //   305: aload 6
    //   307: astore_1
    //   308: aload 5
    //   310: astore 10
    //   312: goto -51 -> 261
    //   315: astore 9
    //   317: aload 6
    //   319: astore_1
    //   320: goto -59 -> 261
    //   323: astore 9
    //   325: goto -64 -> 261
    //   328: astore 20
    //   330: aload 5
    //   332: astore_1
    //   333: aconst_null
    //   334: astore 6
    //   336: goto -97 -> 239
    //   339: astore 7
    //   341: aload 5
    //   343: astore_1
    //   344: goto -105 -> 239
    //   347: astore 13
    //   349: aload 10
    //   351: astore_1
    //   352: goto -113 -> 239
    //   355: astore 14
    //   357: aload_1
    //   358: astore 6
    //   360: aload 10
    //   362: astore_1
    //   363: goto -124 -> 239
    //
    // Exception table:
    //   from	to	target	type
    //   56	66	234	java/lang/Throwable
    //   56	66	256	finally
    //   128	132	277	java/io/IOException
    //   244	249	282	java/io/IOException
    //   265	269	287	java/io/IOException
    //   66	84	292	finally
    //   84	113	303	finally
    //   140	150	303	finally
    //   150	172	315	finally
    //   172	178	323	finally
    //   183	202	323	finally
    //   207	218	323	finally
    //   221	227	323	finally
    //   66	84	328	java/lang/Throwable
    //   84	113	339	java/lang/Throwable
    //   140	150	339	java/lang/Throwable
    //   150	172	347	java/lang/Throwable
    //   172	178	355	java/lang/Throwable
    //   183	202	355	java/lang/Throwable
    //   207	218	355	java/lang/Throwable
    //   221	227	355	java/lang/Throwable
  }

  public static String a(long paramLong)
  {
    try
    {
      String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(paramLong));
      return str;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  private boolean a()
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      boolean bool = new File(localFile.getPath() + "/_agoo_log_bin_").isDirectory();
      if (bool)
        return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private static String b(Throwable paramThrowable)
  {
    if (paramThrowable == null)
      return "";
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }

  private void b()
  {
    try
    {
      if (this.d)
      {
        String str1 = c();
        String str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + str1;
        FileHandler localFileHandler = new FileHandler(str2 + "_%g.log", 10485760, 2, true);
        localFileHandler.setFormatter(new a(null));
        this.e = Logger.getLogger(str1);
        this.e.setLevel(Level.ALL);
        this.e.addHandler(localFileHandler);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private static String c()
  {
    try
    {
      String str1 = a(Process.myPid());
      if (TextUtils.isEmpty(str1))
        str1 = "AgooLog";
      String str2 = str1.replace(':', '_');
      return str2;
    }
    catch (Throwable localThrowable)
    {
    }
    return null;
  }

  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.INFO, paramString1 + ":" + paramString2);
        return;
      }
      Log.d(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      aN.a(paramThrowable);
      a(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void b(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.INFO, paramString1 + ":" + paramString2);
        return;
      }
      Log.i(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      aN.a(paramThrowable);
      b(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void c(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.INFO, paramString1 + ":" + paramString2);
        return;
      }
      Log.v(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      aN.a(paramThrowable);
      c(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void d(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.WARNING, paramString1 + ":" + paramString2);
        return;
      }
      Log.w(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      aN.a(paramThrowable);
      d(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void e(String paramString1, String paramString2)
  {
    try
    {
      if (!this.c)
        return;
      if ((this.d) && (this.e != null))
      {
        this.e.log(Level.SEVERE, paramString1 + ":" + paramString2);
        return;
      }
      Log.e(paramString1, paramString2);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      aN.a(paramThrowable);
      e(paramString1, paramString2 + '\n' + b(paramThrowable));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private static class a extends Formatter
  {
    private String a = null;

    private void a(LogRecord paramLogRecord)
    {
      int i = 0;
      while (true)
      {
        int j;
        try
        {
          Throwable localThrowable2 = paramLogRecord.getThrown();
          if (localThrowable2 == null)
            return;
          this.a = aO.a(localThrowable2);
          StackTraceElement[] arrayOfStackTraceElement = localThrowable2.getStackTrace();
          j = 0;
          if (j < arrayOfStackTraceElement.length)
          {
            String str1 = arrayOfStackTraceElement[j].getClassName();
            if (str1.startsWith(aJ.class.getName()))
            {
              i = 1;
              break label98;
            }
            if (i == 0)
              break label98;
            String str2 = arrayOfStackTraceElement[j].getMethodName();
            paramLogRecord.setSourceClassName(str1);
            paramLogRecord.setSourceMethodName(str2);
            return;
          }
        }
        catch (Throwable localThrowable1)
        {
        }
        return;
        label98: j++;
      }
    }

    public String format(LogRecord paramLogRecord)
    {
      try
      {
        a(paramLogRecord);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(aO.a(paramLogRecord.getMillis()));
        localStringBuffer.append(" ");
        if (paramLogRecord.getSourceClassName() != null)
          localStringBuffer.append(paramLogRecord.getSourceClassName());
        while (true)
        {
          if (paramLogRecord.getSourceMethodName() != null)
          {
            localStringBuffer.append(" ");
            localStringBuffer.append(paramLogRecord.getSourceMethodName());
          }
          localStringBuffer.append("[");
          localStringBuffer.append(paramLogRecord.getLevel().getLocalizedName());
          localStringBuffer.append("]-->");
          localStringBuffer.append(formatMessage(paramLogRecord));
          localStringBuffer.append("\n");
          if (!TextUtils.isEmpty(this.a))
            localStringBuffer.append(this.a);
          String str2 = localStringBuffer.toString();
          str1 = str2;
          return str1;
          localStringBuffer.append(paramLogRecord.getLoggerName());
        }
      }
      catch (Throwable localThrowable)
      {
        while (true)
          String str1 = null;
      }
      finally
      {
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.aO
 * JD-Core Version:    0.6.2
 */