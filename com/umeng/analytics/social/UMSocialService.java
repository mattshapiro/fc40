package com.umeng.analytics.social;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;

public abstract class UMSocialService
{
  private static void a(Context paramContext, b paramb, String paramString, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    if (paramArrayOfUMPlatformData != null);
    while (true)
    {
      int i;
      int j;
      try
      {
        i = paramArrayOfUMPlatformData.length;
        j = 0;
        break label90;
        new a(f.a(paramContext, paramString, paramArrayOfUMPlatformData), paramb, paramArrayOfUMPlatformData).execute(new Void[0]);
        return;
        if (!paramArrayOfUMPlatformData[j].isValid())
          throw new a("parameter is not valid.");
      }
      catch (a locala)
      {
        Log.e("MobclickAgent", "unable send event.", locala);
        return;
        j++;
      }
      catch (Exception localException)
      {
        Log.e("MobclickAgent", "", localException);
        return;
      }
      label90: if (j < i);
    }
  }

  public static void share(Context paramContext, String paramString, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    a(paramContext, null, paramString, paramArrayOfUMPlatformData);
  }

  public static void share(Context paramContext, UMPlatformData[] paramArrayOfUMPlatformData)
  {
    a(paramContext, null, null, paramArrayOfUMPlatformData);
  }

  private static class a extends AsyncTask<Void, Void, d>
  {
    String a = paramArrayOfString[0];
    String b = paramArrayOfString[1];
    UMSocialService.b c;
    UMPlatformData[] d;

    public a(String[] paramArrayOfString, UMSocialService.b paramb, UMPlatformData[] paramArrayOfUMPlatformData)
    {
      this.c = paramb;
      this.d = paramArrayOfUMPlatformData;
    }

    protected d a(Void[] paramArrayOfVoid)
    {
      String str1;
      if (TextUtils.isEmpty(this.b))
        str1 = c.a(this.a);
      while (true)
      {
        int i;
        try
        {
          JSONObject localJSONObject = new JSONObject(str1);
          i = localJSONObject.optInt("st");
          if (i == 0)
          {
            j = -404;
            d locald = new d(j);
            String str2 = localJSONObject.optString("msg");
            if (!TextUtils.isEmpty(str2))
              locald.a(str2);
            String str3 = localJSONObject.optString("data");
            if (!TextUtils.isEmpty(str3))
              locald.b(str3);
            return locald;
            str1 = c.a(this.a, this.b);
            continue;
          }
        }
        catch (Exception localException)
        {
          return new d(-99, localException);
        }
        int j = i;
      }
    }

    protected void a(d paramd)
    {
      if (this.c != null)
        this.c.a(paramd, this.d);
    }

    protected void onPreExecute()
    {
      if (this.c != null)
        this.c.a();
    }
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(d paramd, UMPlatformData[] paramArrayOfUMPlatformData);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.UMSocialService
 * JD-Core Version:    0.6.2
 */