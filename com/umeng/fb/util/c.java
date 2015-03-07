package com.umeng.fb.util;

import android.content.Context;
import java.io.File;

public class c
{
  private static final String a = c.class.getName();

  public static void a(Context paramContext)
  {
    b(c(paramContext));
  }

  public static void a(Context paramContext, String paramString)
  {
    b(b(paramContext) + paramString + ".opus");
  }

  public static boolean a(String paramString)
  {
    try
    {
      File localFile = new File(paramString);
      if (!localFile.exists())
        localFile.mkdirs();
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static String b(Context paramContext)
  {
    return paramContext.getFilesDir().getAbsolutePath() + "/umeng/fb/audio/";
  }

  public static void b(String paramString)
  {
    try
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          File localFile = new File(this.a);
          if (!localFile.exists());
          while (true)
          {
            return;
            if (localFile.isFile())
            {
              localFile.delete();
              return;
            }
            if (localFile.isDirectory())
            {
              File[] arrayOfFile = localFile.listFiles();
              int i = arrayOfFile.length;
              for (int j = 0; j < i; j++)
                arrayOfFile[j].delete();
            }
          }
        }
      }).start();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static String c(Context paramContext)
  {
    String str = paramContext.getFilesDir().getAbsolutePath() + "/umeng/fb/audio/cache/";
    Log.c(a, "getAudioCachePath=" + str);
    return str;
  }

  public static boolean c(String paramString)
  {
    return new File(paramString).exists();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.util.c
 * JD-Core Version:    0.6.2
 */