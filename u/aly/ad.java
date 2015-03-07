package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ad extends ao
  implements p
{
  public ad(String paramString, Map<String, Object> paramMap)
  {
    a(paramString);
    b(System.currentTimeMillis());
    if (paramMap.size() > 0)
      a(b(paramMap));
    if (this.d > 0);
    for (int i = this.d; ; i = 1)
    {
      a(i);
      return;
    }
  }

  private HashMap<String, az> b(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    HashMap localHashMap = new HashMap();
    int i = 0;
    label213: 
    while (true)
    {
      if ((i >= 10) || (!localIterator.hasNext()))
        return localHashMap;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      az localaz = new az();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof String))
        localaz.b((String)localObject);
      while (true)
      {
        if (!localaz.l())
          break label213;
        localHashMap.put((String)localEntry.getKey(), localaz);
        i++;
        break;
        if ((localObject instanceof Long))
          localaz.b(((Long)localObject).longValue());
        else if ((localObject instanceof Integer))
          localaz.b(((Integer)localObject).longValue());
        else if ((localObject instanceof Float))
          localaz.b(((Float)localObject).longValue());
        else if ((localObject instanceof Double))
          localaz.b(((Double)localObject).longValue());
      }
    }
  }

  public void a(bf parambf, String paramString)
  {
    Iterator localIterator;
    av localav;
    if (parambf.s() > 0)
    {
      localIterator = parambf.u().iterator();
      if (localIterator.hasNext());
    }
    else
    {
      localav = null;
    }
    while (true)
    {
      if (localav == null)
      {
        localav = new av();
        localav.a(paramString);
        parambf.a(localav);
      }
      localav.b(this);
      return;
      localav = (av)localIterator.next();
      if (!paramString.equals(localav.c()))
        break;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.ad
 * JD-Core Version:    0.6.2
 */