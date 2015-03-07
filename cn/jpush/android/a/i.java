package cn.jpush.android.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

public final class i
{
  private static final String z;
  private WifiManager a;

  static
  {
    Object localObject1 = "2MR\017".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    int m;
    Object localObject3;
    label27: int n;
    int i1;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      m = i;
      localObject3 = localObject1;
      n = localObject3[j];
      switch (k % 5)
      {
      default:
        i1 = 25;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject3[j] = ((char)(i1 ^ n));
      j = k + 1;
      if (m == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = m;
        break label27;
      }
      i = m;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i1 = 69;
      continue;
      i1 = 36;
      continue;
      i1 = 52;
      continue;
      i1 = 102;
    }
  }

  public i(Context paramContext)
  {
    this.a = ((WifiManager)paramContext.getSystemService(z));
  }

  private List<j> d()
  {
    if (!a())
      return new ArrayList();
    WifiInfo localWifiInfo = this.a.getConnectionInfo();
    if (localWifiInfo != null);
    for (j localj1 = new j(this, localWifiInfo.getBSSID(), localWifiInfo.getRssi(), localWifiInfo.getSSID()); ; localj1 = null)
    {
      ArrayList localArrayList = new ArrayList();
      if (localj1 != null)
        localArrayList.add(localj1);
      List localList = this.a.getScanResults();
      if ((localList != null) && (localList.size() > 0))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          j localj2 = new j(this, (ScanResult)localIterator.next());
          if (!localj2.c.equals(localj1.c))
            localArrayList.add(localj2);
        }
      }
      return localArrayList;
    }
  }

  public final boolean a()
  {
    try
    {
      boolean bool = this.a.isWifiEnabled();
      return bool;
    }
    catch (Exception localException)
    {
      x.j();
    }
    return false;
  }

  public final WifiManager b()
  {
    return this.a;
  }

  public final JSONArray c()
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = d().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return localJSONArray;
        localJSONArray.put(((j)localIterator.next()).a());
      }
    }
    catch (Exception localException)
    {
      x.j();
    }
    return localJSONArray;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.i
 * JD-Core Version:    0.6.2
 */