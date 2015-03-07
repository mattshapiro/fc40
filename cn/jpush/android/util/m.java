package cn.jpush.android.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class m
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[4];
    String str1 = "6'\b S";
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
        str1 = "";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        str1 = "\002\020:d\004\rI-\016\002\007+E\037\016\037\bd\007\006Sc-\r\n\037+]\n\027\033t";
        j = 2;
        arrayOfString2 = arrayOfString1;
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        j = 3;
        arrayOfString2 = arrayOfString1;
        str1 = "OS-b\005\027\026 yQ";
        i = 2;
        break;
      case 2:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 99;
        break label96;
        i3 = 115;
        break label96;
        i3 = 78;
        break label96;
        i3 = 13;
        break label96;
        m = 0;
      }
    }
  }

  public static ArrayList<String> a(InputStream paramInputStream)
  {
    ArrayList localArrayList = new ArrayList();
    InputStreamReader localInputStreamReader;
    BufferedReader localBufferedReader;
    try
    {
      localInputStreamReader = new InputStreamReader(paramInputStream, z[0]);
      localBufferedReader = new BufferedReader(localInputStreamReader, 2048);
      while (true)
      {
        String str1 = localBufferedReader.readLine();
        if (str1 == null)
          break;
        String str2 = str1.trim();
        if (!"".equals(str2))
          localArrayList.add(str2);
      }
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
      return localArrayList;
    }
    localInputStreamReader.close();
    localBufferedReader.close();
    return localArrayList;
  }

  public static void a(String paramString)
  {
    File localFile1 = new File(paramString);
    if (localFile1.exists())
    {
      if (localFile1.isDirectory())
        for (File localFile2 : localFile1.listFiles())
        {
          a(localFile2.getAbsolutePath());
          localFile2.delete();
        }
      localFile1.delete();
    }
  }

  // ERROR //
  public static boolean a(String paramString1, String paramString2, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +16 -> 17
    //   4: new 106	java/lang/IllegalArgumentException
    //   7: dup
    //   8: getstatic 32	cn/jpush/android/util/m:z	[Ljava/lang/String;
    //   11: iconst_1
    //   12: aaload
    //   13: invokespecial 107	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: new 109	java/lang/StringBuilder
    //   20: dup
    //   21: getstatic 32	cn/jpush/android/util/m:z	[Ljava/lang/String;
    //   24: iconst_2
    //   25: aaload
    //   26: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: getstatic 32	cn/jpush/android/util/m:z	[Ljava/lang/String;
    //   36: iconst_3
    //   37: aaload
    //   38: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_1
    //   42: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: pop
    //   49: invokestatic 120	cn/jpush/android/util/x:b	()V
    //   52: aload_0
    //   53: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +89 -> 145
    //   59: aload_1
    //   60: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   63: ifne +82 -> 145
    //   66: new 80	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 4
    //   76: aload 4
    //   78: invokevirtual 86	java/io/File:exists	()Z
    //   81: ifne +9 -> 90
    //   84: aload 4
    //   86: invokevirtual 129	java/io/File:createNewFile	()Z
    //   89: pop
    //   90: new 131	java/io/FileOutputStream
    //   93: dup
    //   94: aload 4
    //   96: invokespecial 134	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   99: astore 6
    //   101: aload 6
    //   103: aload_1
    //   104: getstatic 32	cn/jpush/android/util/m:z	[Ljava/lang/String;
    //   107: iconst_0
    //   108: aaload
    //   109: invokevirtual 138	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   112: invokevirtual 142	java/io/FileOutputStream:write	([B)V
    //   115: aload 6
    //   117: invokevirtual 145	java/io/FileOutputStream:flush	()V
    //   120: aload 6
    //   122: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   125: iconst_1
    //   126: ireturn
    //   127: aload 6
    //   129: ifnull +8 -> 137
    //   132: aload 6
    //   134: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   137: aload 7
    //   139: athrow
    //   140: astore 5
    //   142: invokestatic 149	cn/jpush/android/util/x:h	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore 7
    //   149: goto -22 -> 127
    //   152: astore 7
    //   154: aconst_null
    //   155: astore 6
    //   157: goto -30 -> 127
    //
    // Exception table:
    //   from	to	target	type
    //   66	90	140	java/io/IOException
    //   120	125	140	java/io/IOException
    //   132	137	140	java/io/IOException
    //   137	140	140	java/io/IOException
    //   101	120	147	finally
    //   90	101	152	finally
  }

  // ERROR //
  public static boolean a(String paramString, byte[] paramArrayOfByte, android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 155	cn/jpush/android/util/k:a	(Landroid/content/Context;)V
    //   4: aload_0
    //   5: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +75 -> 83
    //   11: aload_1
    //   12: arraylength
    //   13: ifle +70 -> 83
    //   16: new 80	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore_3
    //   25: aload_3
    //   26: invokevirtual 86	java/io/File:exists	()Z
    //   29: ifne +8 -> 37
    //   32: aload_3
    //   33: invokevirtual 129	java/io/File:createNewFile	()Z
    //   36: pop
    //   37: new 131	java/io/FileOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 134	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore 4
    //   47: aload 4
    //   49: aload_1
    //   50: invokevirtual 142	java/io/FileOutputStream:write	([B)V
    //   53: aload 4
    //   55: invokevirtual 145	java/io/FileOutputStream:flush	()V
    //   58: aload 4
    //   60: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   63: iconst_1
    //   64: ireturn
    //   65: astore 5
    //   67: aconst_null
    //   68: astore 4
    //   70: aload 4
    //   72: ifnull +8 -> 80
    //   75: aload 4
    //   77: invokevirtual 146	java/io/FileOutputStream:close	()V
    //   80: aload 5
    //   82: athrow
    //   83: iconst_0
    //   84: ireturn
    //   85: astore 5
    //   87: goto -17 -> 70
    //
    // Exception table:
    //   from	to	target	type
    //   37	47	65	finally
    //   47	58	85	finally
  }

  public static String b(String paramString)
  {
    if (!ai.a(paramString))
    {
      int i = paramString.lastIndexOf(".");
      int j = paramString.length();
      if ((i > 0) && (i + 1 != j))
        return paramString.substring(i, paramString.length());
    }
    return "";
  }

  public static String c(String paramString)
  {
    if (ai.a(paramString))
      return "";
    return paramString.substring(1 + paramString.lastIndexOf("/"), paramString.length());
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.m
 * JD-Core Version:    0.6.2
 */