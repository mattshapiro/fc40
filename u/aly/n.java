package u.aly;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class n
{
  private final int a = 128;
  private final int b = 256;
  private l c;
  private Context d;
  private k e;

  public n(Context paramContext)
  {
    if (paramContext == null)
      throw new RuntimeException("Context is null, can't track event");
    this.d = paramContext.getApplicationContext();
    this.c = new l(this.d);
    l locall = this.c;
    if (AnalyticsConfig.ENABLE_MEMORY_BUFFER);
    for (boolean bool = false; ; bool = true)
    {
      locall.a(bool);
      this.e = k.a(this.d);
      return;
    }
  }

  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.trim().getBytes().length;
      if ((i > 0) && (i <= 128))
        return true;
    }
    bj.b("MobclickAgent", "Event id is empty or too long in tracking Event");
    return false;
  }

  private boolean a(Map<String, Object> paramMap)
  {
    if ((paramMap == null) || (paramMap.isEmpty()))
    {
      bj.b("MobclickAgent", "map is null or empty in onEvent");
      return false;
    }
    Iterator localIterator = paramMap.entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext())
        return true;
      localEntry = (Map.Entry)localIterator.next();
      if (!a((String)localEntry.getKey()))
        return false;
      if (localEntry.getValue() == null)
        return false;
    }
    while ((!(localEntry.getValue() instanceof String)) || (b(localEntry.getValue().toString())));
    return false;
  }

  private boolean b(String paramString)
  {
    if (paramString == null);
    while (paramString.trim().getBytes().length <= 256)
      return true;
    bj.b("MobclickAgent", "Event label or value is empty or too long in tracking Event");
    return false;
  }

  public void a(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) || (!b(paramString2)))
      return;
    this.c.a(ab.b(paramString1, paramString2, null), ab.a(paramString1, paramString2, null));
  }

  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if ((!a(paramString1)) || (!b(paramString2)))
      return;
    HashMap localHashMap = new HashMap();
    if (paramString2 == null)
      paramString2 = "";
    localHashMap.put(paramString1, paramString2);
    this.e.a(new ab(paramString1, localHashMap, paramLong, paramInt));
  }

  public void a(String paramString, Map<String, Object> paramMap)
  {
    try
    {
      if (!a(paramString))
        return;
      this.e.a(new ad(paramString, paramMap));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", localException);
    }
  }

  public void a(String paramString, Map<String, Object> paramMap, long paramLong)
  {
    try
    {
      if (!a(paramString))
        return;
      if (a(paramMap))
      {
        this.e.a(new ab(paramString, paramMap, paramLong, -1));
        return;
      }
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", localException);
    }
  }

  public void a(String paramString1, Map<String, Object> paramMap, String paramString2)
  {
    if (!a(paramString1));
    while (!a(paramMap))
      return;
    this.c.a(ab.b(paramString1, paramString2, paramMap), ab.a(paramString1, paramString2, paramMap));
  }

  public void b(String paramString1, String paramString2)
  {
    if ((!a(paramString1)) || (!b(paramString2)));
    aa localaa;
    do
    {
      return;
      localaa = this.c.b(ab.b(paramString1, paramString2, null));
    }
    while (localaa == null);
    a(paramString1, paramString2, (int)(System.currentTimeMillis() - localaa.a), 0);
  }

  public void c(String paramString1, String paramString2)
  {
    if (!a(paramString1));
    aa localaa;
    do
    {
      return;
      localaa = this.c.b(ab.b(paramString1, paramString2, null));
    }
    while (localaa == null);
    int i = (int)(System.currentTimeMillis() - localaa.a);
    a(paramString1, localaa.d, i);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.n
 * JD-Core Version:    0.6.2
 */