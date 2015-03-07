package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.api.m;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import org.json.JSONObject;

public final class x extends l
{
  private static final String[] bb;

  static
  {
    String[] arrayOfString1 = new String[2];
    String str1 = "GJ=gweJvzp}SvdwvAv$8";
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
          i3 = 24;
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
        str1 = "sT=VkzK!";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        bb = arrayOfString1;
        return;
        i3 = 18;
        break label96;
        i3 = 36;
        break label96;
        i3 = 86;
        break label96;
        i3 = 9;
        break label96;
        m = 0;
      }
    }
  }

  public x()
  {
    this.o = 3;
    this.ad = null;
  }

  public final void a(Context paramContext)
  {
    cn.jpush.android.util.x.b();
    if (p.a(this.Y, this.Z, paramContext))
    {
      ServiceInterface.a(paramContext, this);
      return;
    }
    if (this.ab == 1)
    {
      paramContext.startActivity(a.a(paramContext, this, true));
      return;
    }
    if (this.ab == 0)
    {
      m.a(paramContext, this, true, true);
      return;
    }
    new StringBuilder(bb[0]).append(this.ab).toString();
    cn.jpush.android.util.x.c();
  }

  public final boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    cn.jpush.android.util.x.b();
    boolean bool = super.a(paramContext, paramJSONObject);
    this.ab = paramJSONObject.optInt(bb[1], 0);
    return bool;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.x
 * JD-Core Version:    0.6.2
 */