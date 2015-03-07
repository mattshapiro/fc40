package cn.jpush.android.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import cn.jpush.android.service.PushService;
import cn.jpush.android.util.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  implements Thread.UncaughtExceptionHandler
{
  private static c b;
  private static final String[] z;
  public boolean a = false;
  private Thread.UncaughtExceptionHandler c = null;
  private Context d;

  static
  {
    Object localObject1 = new String[14];
    int i = 0;
    String str1 = "WA\037\004ObD\004\024FHV\002\003BER\017\007ST^\004(AT]\017";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label36: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label52: int i2;
    int i3;
    if (k <= 1)
    {
      localObject4 = localObject3;
      n = m;
      i1 = k;
      localObject5 = localObject3;
      i2 = localObject5[m];
      switch (n % 5)
      {
      default:
        i3 = 39;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[m] = ((char)(i3 ^ i2));
      m = n + 1;
      if (i1 == 0)
      {
        localObject5 = localObject4;
        n = m;
        m = i1;
        break label52;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "^^\037\031S";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "NE\013\024LIC\013\024B";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "KT\030\004NR_\004\026JX";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "PT\031\004FZT";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "SD\006\033";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "KT\030\004NR_\t\030CX";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "^C\013\004OIX\007\022";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "^C\013\004Ob]\005\020";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "IH\032\022";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "^C\013\004OQ^\r\004";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "TE\003\032B";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        z = localObject2;
        b = new c();
        return;
        i3 = 61;
        continue;
        i3 = 49;
        continue;
        i3 = 106;
        continue;
        i3 = 119;
      }
    }
  }

  public static c a()
  {
    return b;
  }

  private JSONArray a(Context paramContext, Throwable paramThrowable)
  {
    JSONArray localJSONArray = d(paramContext);
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    String str1 = localStringWriter.toString();
    if (localJSONArray == null)
      localJSONArray = new JSONArray();
    int i = 0;
    try
    {
      if (i < localJSONArray.length())
      {
        localJSONObject1 = localJSONArray.optJSONObject(i);
        if ((localJSONObject1 == null) || (!str1.equals(localJSONObject1.getString(z[2]))))
          break label355;
        int k = 1 + localJSONObject1.getInt(z[1]);
        localJSONObject1.put(z[1], k);
        localJSONObject1.put(z[7], System.currentTimeMillis());
        j = i;
        if (localJSONObject1 != null)
        {
          localJSONArray = a(localJSONArray, j);
          localJSONArray.put(localJSONObject1);
          return localJSONArray;
        }
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put(z[7], System.currentTimeMillis());
        localJSONObject2.put(z[2], str1);
        localJSONObject2.put(z[4], paramThrowable.toString());
        localJSONObject2.put(z[1], 1);
        localJSONObject2.put(z[8], a.d(paramContext));
        PackageInfo localPackageInfo = this.d.getPackageManager().getPackageInfo(this.d.getPackageName(), 1);
        if (localPackageInfo != null)
          if (localPackageInfo.versionName != null)
            break label332;
        label332: for (String str2 = z[5]; ; str2 = localPackageInfo.versionName)
        {
          String str3 = localPackageInfo.versionCode;
          localJSONObject2.put(z[3], str2);
          localJSONObject2.put(z[6], str3);
          localJSONArray.put(localJSONObject2);
          return localJSONArray;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        return localJSONArray;
        JSONObject localJSONObject1 = null;
        int j = 0;
        continue;
        label355: i++;
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONArray;
  }

  private static JSONArray a(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null)
      return null;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (true)
    {
      if ((i >= paramJSONArray.length()) || (i != paramInt));
      try
      {
        localJSONArray.put(paramJSONArray.get(i));
        label39: i++;
        continue;
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        break label39;
      }
    }
  }

  private static void a(Context paramContext, JSONArray paramJSONArray)
  {
    String str = paramJSONArray.toString();
    if ((str != null) && (str.length() > 0) && (paramContext != null));
    try
    {
      FileOutputStream localFileOutputStream = paramContext.openFileOutput(z[0], 0);
      localFileOutputStream.write(str.getBytes());
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
  }

  public static void b(Context paramContext)
  {
    File localFile = new File(paramContext.getFilesDir(), z[0]);
    if (localFile.exists())
      localFile.delete();
  }

  private static JSONArray d(Context paramContext)
  {
    if (!new File(paramContext.getFilesDir(), z[0]).exists())
      return null;
    JSONArray localJSONArray;
    try
    {
      FileInputStream localFileInputStream = paramContext.openFileInput(z[0]);
      byte[] arrayOfByte = new byte[1024];
      StringBuffer localStringBuffer = new StringBuffer();
      while (true)
      {
        int i = localFileInputStream.read(arrayOfByte);
        if (i == -1)
          break;
        localStringBuffer.append(new String(arrayOfByte, 0, i));
      }
      if (localStringBuffer.toString().length() > 0)
        localJSONArray = new JSONArray(localStringBuffer.toString());
      else
        localJSONArray = null;
    }
    catch (Exception localException)
    {
      localJSONArray = null;
    }
    return localJSONArray;
  }

  public final void a(Context paramContext)
  {
    this.d = paramContext;
    if (this.c == null)
      this.c = Thread.getDefaultUncaughtExceptionHandler();
    Thread.setDefaultUncaughtExceptionHandler(this);
    this.a = true;
  }

  public final JSONObject c(Context paramContext)
  {
    if (!this.a);
    JSONArray localJSONArray;
    do
    {
      return null;
      localJSONArray = d(paramContext);
    }
    while (localJSONArray == null);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[12], localJSONArray);
      localJSONObject.put(z[13], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
      localJSONObject.put(z[11], z[10]);
      localJSONObject.put(z[9], a.d(paramContext));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    JSONArray localJSONArray = a(this.d, paramThrowable);
    b(this.d);
    a(this.d, localJSONArray);
    if (this.c != this)
      this.c.uncaughtException(paramThread, paramThrowable);
    throw new RuntimeException(paramThrowable);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.c
 * JD-Core Version:    0.6.2
 */