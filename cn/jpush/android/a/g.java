package cn.jpush.android.a;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import cn.jpush.android.util.x;

public final class g
{
  private static final String[] z;
  public double a;
  public double b;
  private Context c;
  private LocationManager d;
  private Location e;
  private String f;
  private long g;
  private final LocationListener h = new h(this);

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "\nZDfgSB\ra?S\024F`1K]N+1\020\024\\%)T\036\004%q\024\031Z%)T\036\004%r\022\033\n=6\027\005";
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
          i3 = 19;
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
        str1 = "\035\027Kfg\030\027F";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "\026\b[";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 113;
        break label96;
        i3 = 120;
        break label96;
        i3 = 40;
        break label96;
        i3 = 7;
        break label96;
        m = 0;
      }
    }
  }

  public g(Context paramContext)
  {
    this.c = paramContext;
    String str = z[1];
    this.d = ((LocationManager)this.c.getSystemService(str));
  }

  private void a(Location paramLocation)
  {
    if (paramLocation != null)
      try
      {
        this.a = paramLocation.getLatitude();
        this.b = paramLocation.getLongitude();
        this.g = System.currentTimeMillis();
        String str = z[0];
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Double.valueOf(this.a);
        arrayOfObject[1] = Double.valueOf(this.b);
        arrayOfObject[2] = Double.valueOf(paramLocation.getAltitude());
        arrayOfObject[3] = Float.valueOf(paramLocation.getBearing());
        arrayOfObject[4] = Float.valueOf(paramLocation.getAccuracy());
        this.f = String.format(str, arrayOfObject);
        return;
      }
      catch (Exception localException)
      {
        localException.getMessage();
        x.f();
      }
    this.f = "";
  }

  public final boolean a()
  {
    return this.d.isProviderEnabled(z[2]);
  }

  public final void b()
  {
    Criteria localCriteria = new Criteria();
    localCriteria.setAccuracy(1);
    localCriteria.setAltitudeRequired(false);
    localCriteria.setBearingRequired(false);
    localCriteria.setCostAllowed(true);
    localCriteria.setPowerRequirement(1);
    String str = this.d.getBestProvider(localCriteria, true);
    this.e = this.d.getLastKnownLocation(str);
    if (this.e != null)
      a(this.e);
    this.d.requestLocationUpdates(str, 2000L, 10.0F, this.h);
  }

  public final void c()
  {
    this.d.removeUpdates(this.h);
  }

  public final String d()
  {
    return this.f;
  }

  public final long e()
  {
    return this.g;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.g
 * JD-Core Version:    0.6.2
 */