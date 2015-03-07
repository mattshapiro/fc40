package cn.jpush.android.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k
{
  public static final String a = new String((char[])localObject4).intern() + File.separator;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[7];
    int i = 0;
    String str1 = "ID8( \tl2c6\007q7c";
    int j = -1;
    Object localObject2 = localObject1;
    int i9;
    label133: String str2;
    while (true)
    {
      Object localObject3 = str1.toCharArray();
      int k = localObject3.length;
      int m = 0;
      if (k <= 1);
      while (k > m)
      {
        Object localObject7 = localObject3;
        int i6 = m;
        int i7 = k;
        Object localObject8 = localObject3;
        while (true)
        {
          int i8 = localObject8[m];
          switch (i6 % 5)
          {
          default:
            i9 = 82;
            localObject8[m] = ((char)(i9 ^ i8));
            m = i6 + 1;
            if (i7 != 0)
              break label133;
            localObject8 = localObject7;
            i6 = m;
            m = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        k = i7;
        localObject3 = localObject7;
      }
      str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "I7";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "\002d\"-r\002l$vr";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "\002l$";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "2m3l&\007w1)&Fa?>hF";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "8^fak;~e1v";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "I4";
        j = 5;
        localObject1 = localObject2;
      case 5:
      }
    }
    localObject1[i] = str2;
    z = localObject2;
    StringBuilder localStringBuilder = new StringBuilder().append(File.separator);
    Object localObject4 = "\024l5$".toCharArray();
    int n = localObject4.length;
    int i1 = 0;
    if (n <= 1);
    label371: label507: 
    while (n > i1)
    {
      Object localObject5 = localObject4;
      int i2 = i1;
      int i3 = n;
      Object localObject6 = localObject4;
      int i4 = localObject6[i1];
      int i5;
      switch (i2 % 5)
      {
      default:
        i5 = 82;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        localObject6[i1] = ((char)(i5 ^ i4));
        i1 = i2 + 1;
        if (i3 != 0)
          break label507;
        localObject6 = localObject5;
        i2 = i1;
        i1 = i3;
        break label371;
        i9 = 102;
        break;
        i9 = 5;
        break;
        i9 = 86;
        break;
        i9 = 76;
        break;
        i5 = 102;
        continue;
        i5 = 5;
        continue;
        i5 = 86;
        continue;
        i5 = 76;
      }
      n = i3;
      localObject4 = localObject5;
    }
  }

  public static String a(Context paramContext, String paramString)
  {
    String str = paramContext.getFilesDir() + "/" + paramString;
    File localFile = new File(str);
    if (!localFile.exists())
      localFile.mkdir();
    return str + "/";
  }

  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      paramString = "";
    while (paramString.lastIndexOf(File.separator) == 0)
      return paramString;
    return paramString + File.separator;
  }

  public static void a(Context paramContext)
  {
    if (a.a())
    {
      String str1 = e(paramContext);
      String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
      File localFile1 = new File(str2 + str1);
      if (!localFile1.isDirectory())
        localFile1.mkdirs();
      File localFile2 = new File(str2 + str1 + z[6]);
      if (!localFile2.isDirectory())
        localFile2.mkdirs();
      File localFile3 = new File(str2 + str1 + z[1]);
      if (!localFile3.isDirectory())
        localFile3.mkdirs();
      File localFile4 = new File(str2 + str1 + File.separator + paramContext.getPackageName());
      if (!localFile4.isDirectory())
        localFile4.mkdirs();
      return;
    }
    x.f();
  }

  private static boolean a(File paramFile)
  {
    while (true)
    {
      int j;
      try
      {
        if (!paramFile.exists())
          return false;
        if (paramFile.isFile())
          return paramFile.delete();
        String[] arrayOfString = paramFile.list();
        int i = arrayOfString.length;
        j = 0;
        if (j < i)
        {
          File localFile = new File(paramFile, arrayOfString[j]);
          if (localFile.isDirectory())
            a(localFile);
          else
            localFile.delete();
        }
      }
      catch (Exception localException)
      {
        x.f();
        return false;
      }
      boolean bool = paramFile.delete();
      return bool;
      j++;
    }
  }

  public static String b(Context paramContext)
  {
    if (a.a())
    {
      String str1 = a(Environment.getExternalStorageDirectory().getAbsolutePath());
      String str2 = str1 + e(paramContext) + z[6];
      if (!new File(str2).isDirectory())
        a(paramContext);
      return str2 + File.separator;
    }
    return "";
  }

  public static String b(Context paramContext, String paramString)
  {
    if (a.a())
    {
      String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
      String str3 = str2 + z[0] + paramContext.getPackageName() + File.separator + paramString + File.separator;
      File localFile3 = new File(str3);
      if (!localFile3.exists())
        localFile3.mkdirs();
      return str3;
    }
    File localFile1 = new File(paramContext.getFilesDir() + a);
    if ((localFile1.exists()) && (localFile1.isDirectory()))
    {
      File[] arrayOfFile = localFile1.listFiles();
      if (arrayOfFile.length > 10)
      {
        Arrays.sort(arrayOfFile, new l());
        a(arrayOfFile[(-1 + arrayOfFile.length)]);
      }
    }
    String str1 = paramContext.getFilesDir() + a + paramString;
    File localFile2 = new File(str1);
    if (!localFile2.exists())
      localFile2.mkdirs();
    return str1 + "/";
  }

  public static String c(Context paramContext)
  {
    if (a.a())
    {
      String str1 = a(Environment.getExternalStorageDirectory().getAbsolutePath());
      String str2 = str1 + e(paramContext) + z[1];
      if (!new File(str2).isDirectory())
        a(paramContext);
      return str2 + "/";
    }
    return "";
  }

  public static void d(Context paramContext)
  {
    File[] arrayOfFile = paramContext.getFilesDir().listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    if (j < i)
    {
      File localFile = arrayOfFile[j];
      String str = localFile.getName();
      if (TextUtils.isEmpty(str));
      for (boolean bool = false; ; bool = Pattern.compile(z[5]).matcher(str).matches())
      {
        if (bool)
          m.a(localFile.getAbsolutePath());
        j++;
        break;
      }
    }
  }

  private static String e(Context paramContext)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
    String str1 = localSharedPreferences.getString(z[3], "");
    String str3;
    File localFile1;
    String str4;
    if (TextUtils.isEmpty(str1))
    {
      String str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
      str3 = z[0];
      localFile1 = new File(str2 + str3);
      if (!localFile1.exists())
        break label298;
      ArrayList localArrayList = new ArrayList();
      for (File localFile2 : localFile1.listFiles())
        if (localFile2.isDirectory())
        {
          localArrayList.add(localFile2.getName());
          new StringBuilder(z[2]).append(localFile2.getName()).toString();
          x.b();
        }
      int k = localArrayList.size();
      if (k <= 0)
        break label264;
      String str5 = (String)localArrayList.get(k / 2);
      str4 = str3 + str5;
    }
    while (true)
    {
      new StringBuilder(z[4]).append(str4).toString();
      x.d();
      localSharedPreferences.edit().putString(z[3], str4).commit();
      return str1;
      label264: str4 = str3 + UUID.randomUUID().toString().substring(0, 5);
      continue;
      label298: localFile1.mkdirs();
      str4 = str3 + UUID.randomUUID().toString().substring(0, 5);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.k
 * JD-Core Version:    0.6.2
 */