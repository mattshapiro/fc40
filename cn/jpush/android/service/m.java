package cn.jpush.android.service;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.api.b;
import cn.jpush.android.api.d;
import cn.jpush.android.util.x;

final class m extends Handler
{
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[4];
    String str1 = "";
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
          i3 = 109;
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
        str1 = "W2\004\034M\035z";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        str1 = "";
        j = 2;
        arrayOfString2 = arrayOfString1;
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        j = 3;
        arrayOfString2 = arrayOfString1;
        str1 = "C4K\002\035U)\rF\fN>\027\007\004Dt\f\006\031E4\021F.o\024+-.t\023*&";
        i = 2;
        break;
      case 2:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 32;
        break label96;
        i3 = 90;
        break label96;
        i3 = 101;
        break label96;
        i3 = 104;
        break label96;
        m = 0;
      }
    }
  }

  m(PushService paramPushService)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default:
      new StringBuilder(z[0]).append(paramMessage.what).toString();
      x.b();
    case 1001:
    case 1003:
    case 1002:
    case 1004:
    case 1005:
    case 1007:
    case 1008:
    case 1006:
    }
    while (true)
    {
      return;
      x.c();
      PushService.c(this.a);
      this.a.stopSelf();
      this.a.a(0, z[3]);
      return;
      this.a.stopSelf();
      return;
      if ((PushService.d(this.a) == null) || (!PushService.d(this.a).isAlive()))
        continue;
      PushService.e(this.a);
      return;
      PushService.b(this.a, true);
      return;
      PushService.b(this.a, false);
      return;
      x.f();
      PushService.f(this.a);
      return;
      try
      {
        int m = ((Integer)paramMessage.obj).intValue();
        k = m;
        if (!PushService.c(this.a, k))
          continue;
        new StringBuilder(z[2]).append(k).append(z[1]).append(paramMessage.what).toString();
        x.f();
        PushService.f(this.a);
        return;
      }
      catch (Exception localException2)
      {
        while (true)
          int k = 0;
      }
      try
      {
        int j = ((Integer)paramMessage.obj).intValue();
        i = j;
        if (i == 0)
          continue;
        b localb = ServiceInterface.a(i);
        if (localb != null)
        {
          TagAliasCallback localTagAliasCallback = localb.c;
          if (localTagAliasCallback != null)
            localTagAliasCallback.gotResult(d.b, localb.a, localb.b);
        }
        ServiceInterface.b(i);
        return;
      }
      catch (Exception localException1)
      {
        while (true)
          int i = 0;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.m
 * JD-Core Version:    0.6.2
 */