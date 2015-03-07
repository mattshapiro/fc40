package cn.jpush.android.service;

import android.app.NotificationManager;
import android.os.Handler;
import cn.jpush.android.data.l;
import cn.jpush.android.data.p;
import cn.jpush.android.data.y;
import cn.jpush.android.util.x;
import java.util.concurrent.ConcurrentLinkedQueue;

final class d
  implements c
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "\032`\rK\001\036?";
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
          i3 = 111;
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
        str1 = "F%\nA\030\004i\001O\013\017aT";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "F%\032A\033\013iT";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 106;
        break label96;
        i3 = 5;
        break label96;
        i3 = 110;
        break label96;
        i3 = 46;
        break label96;
        m = 0;
      }
    }
  }

  d(DownloadService paramDownloadService, boolean paramBoolean, int paramInt)
  {
  }

  public final void a(int paramInt)
  {
    DownloadService.c(this.c).cancel(this.b);
    if (a.a(paramInt))
    {
      DownloadService.a(this.c).L = true;
      ServiceInterface.a(DownloadService.a(this.c).c, 1011, this.c);
    }
    try
    {
      str = ((l)DownloadService.a(this.c)).ac;
      ServiceInterface.a(DownloadService.a(this.c).c, 1022, cn.jpush.android.util.a.b(this.c, str), this.c);
      DownloadService.a(this.c).M = true;
      DownloadService.a(this.c, this.b, DownloadService.a(this.c), paramInt);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        String str = "";
    }
  }

  public final void a(long paramLong1, long paramLong2)
  {
    int i = (int)(100.0F * ((float)paramLong1 / (float)paramLong2));
    new StringBuilder(z[0]).append(i).append(z[1]).append(paramLong1).append(z[2]).append(paramLong2).toString();
    x.c();
    if (!this.a)
      DownloadService.a(this.c, DownloadService.a(this.c), this.b, paramLong1, paramLong2);
  }

  public final void a(String paramString, boolean paramBoolean)
  {
    DownloadService.a(this.c).N = true;
    DownloadService.a.remove(DownloadService.a(this.c));
    int i = 1001;
    if (DownloadService.a(this.c).a())
    {
      l locall = (l)DownloadService.a(this.c);
      locall.ah = paramString;
      locall.ai = false;
      if (p.a(locall.Y, locall.Z, this.c))
      {
        i = 1003;
        locall.ai = true;
      }
    }
    while (true)
    {
      for (int j = i; ; j = 1004)
      {
        if (paramBoolean)
          j = 1013;
        ServiceInterface.a(DownloadService.a(this.c).c, j, this.c);
        if (!DownloadService.a(this.c).f())
          DownloadService.b(this.c).sendEmptyMessageDelayed(this.b, 500L);
        DownloadService.a(this.c).M = true;
        DownloadService.a(this.c, DownloadService.a(this.c));
        return;
        if (!DownloadService.a(this.c).b())
          break;
        ((y)DownloadService.a(this.c)).aa = paramString;
      }
      if (DownloadService.a(this.c).f())
        DownloadService.a(this.c).U = paramString;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.d
 * JD-Core Version:    0.6.2
 */