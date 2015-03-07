package cn.jpush.android.api;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RemoteViews;
import cn.jpush.android.a;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;

final class p extends Handler
{
  private static final String[] z;
  private NotificationManager a;
  private Notification b;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "\005\017@cT\017";
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
          i3 = 55;
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
        str1 = "\001\031`eV\013\031Zr";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "\n\025sg\r\b{";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 108;
        break label96;
        i3 = 124;
        break label96;
        i3 = 19;
        break label96;
        i3 = 22;
        break label96;
        m = 0;
      }
    }
  }

  public p(Looper paramLooper, Notification paramNotification, NotificationManager paramNotificationManager)
  {
    super(paramLooper);
    this.b = paramNotification;
    this.a = paramNotificationManager;
  }

  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Bundle localBundle = paramMessage.getData();
    boolean bool = localBundle.getBoolean(z[0]);
    String str1 = localBundle.getString(z[2]);
    if ((bool) && (!TextUtils.isEmpty(str1)));
    while (true)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFile(str1);
        if (localBitmap != null)
          this.b.contentView.setImageViewBitmap(16908294, localBitmap);
        String str2 = localBundle.getString(z[1]);
        if (!ai.a(str2))
          ServiceInterface.a(str2, 1018, a.d);
        this.a.notify(paramMessage.what, this.b);
        return;
      }
      catch (Exception localException)
      {
        x.j();
        continue;
      }
      x.b();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.p
 * JD-Core Version:    0.6.2
 */