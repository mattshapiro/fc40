package cn.jpush.android.a;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

final class h
  implements LocationListener
{
  h(g paramg)
  {
  }

  public final void onLocationChanged(Location paramLocation)
  {
    g.a(this.a, paramLocation);
  }

  public final void onProviderDisabled(String paramString)
  {
    g.a(this.a, null);
    this.a.c();
  }

  public final void onProviderEnabled(String paramString)
  {
    this.a.b();
  }

  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.h
 * JD-Core Version:    0.6.2
 */