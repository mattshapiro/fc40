package cn.jpush.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.x;
import java.util.Calendar;

public class AlarmReceiver extends BroadcastReceiver
{
  private static final String[] z;

  static
  {
    Object localObject1 = new String[6];
    int i = 0;
    String str1 = "I+\nx6T9*i\027T;";
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
        i3 = 69;
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
        str1 = "R,;";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "M\0216i R.9q";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "T*-x";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "A49o(";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 32;
        continue;
        i3 = 88;
        continue;
        i3 = 88;
        continue;
        i3 = 29;
      }
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    x.c();
    if (!cn.jpush.android.a.a(paramContext.getApplicationContext()));
    PendingIntent localPendingIntent;
    boolean bool;
    Calendar localCalendar;
    do
    {
      return;
      localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, paramIntent, 0);
      bool = ae.a(paramContext, z[0], z[3]).equals(z[3]);
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(System.currentTimeMillis());
    }
    while (!bool);
    int i = ae.a(paramContext, z[2], PushService.i);
    localCalendar.add(13, i);
    String str = z[5];
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(i);
    String.format(str, arrayOfObject);
    x.d();
    ((AlarmManager)paramContext.getSystemService(z[4])).set(0, localCalendar.getTimeInMillis(), localPendingIntent);
    Intent localIntent = new Intent(paramContext, PushService.class);
    localIntent.putExtra(z[1], z[1]);
    paramContext.startService(localIntent);
    cn.jpush.android.util.a.m(paramContext);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.AlarmReceiver
 * JD-Core Version:    0.6.2
 */