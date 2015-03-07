package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;

final class q extends Thread
{
  q(String paramString1, Context paramContext, String paramString2)
  {
  }

  public final void run()
  {
    String str = null;
    int i = 0;
    do
    {
      j = 0;
      if (i >= 4)
        break;
      i++;
      str = n.a(this.a, 5, 8000L);
    }
    while (n.a(str));
    int j = 1;
    if ((j != 0) && (!TextUtils.isEmpty(str)))
    {
      p.a(this.b, str);
      return;
    }
    ServiceInterface.a(this.c, 1021, a.b(this.b, this.a), this.b);
    ServiceInterface.a(this.c, 996, this.b);
    x.c();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.q
 * JD-Core Version:    0.6.2
 */