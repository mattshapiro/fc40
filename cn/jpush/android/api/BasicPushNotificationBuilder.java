package cn.jpush.android.api;

import android.app.Notification;
import android.content.Context;
import cn.jpush.android.a;

public class BasicPushNotificationBuilder extends DefaultPushNotificationBuilder
{
  private static final String[] z;
  protected Context a;
  public String developerArg0 = "";
  public int notificationDefaults = -1;
  public int notificationFlags = 16;
  public int statusBarDrawable = a.a;

  static
  {
    Object localObject1 = new String[5];
    int i = 0;
    String str1 = "\037C,K\037";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label35: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label51: int i2;
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
        i3 = 64;
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
        break label51;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "\016I?X`#s\035`%8h";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 64;
        continue;
        i3 = 28;
        continue;
        i3 = 115;
        continue;
        i3 = 20;
      }
    }
  }

  public BasicPushNotificationBuilder(Context paramContext)
  {
    if (paramContext == null)
      throw new IllegalArgumentException(z[1]);
    this.a = paramContext;
  }

  static PushNotificationBuilder a(String paramString)
  {
    String[] arrayOfString = paramString.split(z[0]);
    String str = arrayOfString[0];
    Object localObject;
    if (z[3].equals(str))
      localObject = new BasicPushNotificationBuilder(a.d);
    while (true)
    {
      ((BasicPushNotificationBuilder)localObject).a(arrayOfString);
      return localObject;
      if (z[4].equals(str))
        localObject = new CustomPushNotificationBuilder(a.d);
      else
        localObject = new BasicPushNotificationBuilder(a.d);
    }
  }

  public final String a()
  {
    return this.developerArg0;
  }

  final void a(Notification paramNotification)
  {
    paramNotification.defaults = this.notificationDefaults;
    paramNotification.flags = this.notificationFlags;
    paramNotification.icon = this.statusBarDrawable;
  }

  void a(String[] paramArrayOfString)
  {
    this.notificationDefaults = Integer.parseInt(paramArrayOfString[1]);
    this.notificationFlags = Integer.parseInt(paramArrayOfString[2]);
    this.statusBarDrawable = Integer.parseInt(paramArrayOfString[3]);
    this.developerArg0 = paramArrayOfString[4];
  }

  String b()
  {
    return this.notificationDefaults + z[0] + this.notificationFlags + z[0] + this.statusBarDrawable + z[0] + this.developerArg0;
  }

  public String toString()
  {
    return z[2] + b();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.BasicPushNotificationBuilder
 * JD-Core Version:    0.6.2
 */