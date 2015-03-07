package cn.jpush.android.api;

import android.app.Notification;
import android.widget.RemoteViews;
import cn.jpush.android.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import java.util.Map;

public class DefaultPushNotificationBuilder
  implements PushNotificationBuilder
{
  private static final String[] z;
  protected String b;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "ajgU0[l!R<Nq.T1\017f(U+Jk3\033+@%4S0X+g|6Y`gN/\001";
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
          i3 = 95;
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
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "k`!Z*Cq\027N,GK(O6Il$Z+Fj)y*Fi#^-";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 47;
        break label96;
        i3 = 5;
        break label96;
        i3 = 71;
        break label96;
        i3 = 59;
        break label96;
        m = 0;
      }
    }
  }

  public final Notification a(String paramString, Map<String, String> paramMap)
  {
    if (ai.a(paramString))
    {
      x.d(z[2], z[0]);
      return null;
    }
    if (paramMap.containsKey(z[1]))
      this.b = ((String)paramMap.get(z[1]));
    if (this.b == null)
      this.b = a.c;
    Notification localNotification = new Notification(a.a, paramString, System.currentTimeMillis());
    a(localNotification);
    if (this.b == null)
      this.b = a.c;
    RemoteViews localRemoteViews = b(paramString);
    if (localRemoteViews != null)
    {
      localNotification.contentView = localRemoteViews;
      return localNotification;
    }
    localNotification.setLatestEventInfo(a.d, this.b, paramString, null);
    return localNotification;
  }

  public String a()
  {
    return null;
  }

  void a(Notification paramNotification)
  {
  }

  RemoteViews b(String paramString)
  {
    return null;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.DefaultPushNotificationBuilder
 * JD-Core Version:    0.6.2
 */