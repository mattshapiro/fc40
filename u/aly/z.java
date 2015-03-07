package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class z
{
  private static final String a = "activities";
  private final Map<String, Long> b = new HashMap();
  private final ArrayList<x> c = new ArrayList();

  public static List<ay> a(SharedPreferences paramSharedPreferences)
  {
    String str1 = paramSharedPreferences.getString("activities", "");
    if ("".equals(str1))
      return null;
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      int i;
      try
      {
        String[] arrayOfString = str1.split(";");
        i = 0;
        int j = arrayOfString.length;
        if (i >= j)
        {
          if (localArrayList.size() <= 0)
            break;
          return localArrayList;
        }
        String str2 = arrayOfString[i];
        if (!TextUtils.isEmpty(str2))
          localArrayList.add(new ae(str2));
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      i++;
    }
  }

  public void a()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.entrySet().iterator();
      String str = null;
      long l1 = 0L;
      Map.Entry localEntry;
      do
      {
        if (!localIterator.hasNext())
        {
          if (str != null)
            b(str);
          return;
        }
        localEntry = (Map.Entry)localIterator.next();
      }
      while (((Long)localEntry.getValue()).longValue() <= l1);
      long l2 = ((Long)localEntry.getValue()).longValue();
      str = (String)localEntry.getKey();
      l1 = l2;
    }
  }

  public void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = u.a(paramContext);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    StringBuilder localStringBuilder;
    if (this.c.size() > 0)
    {
      String str = localSharedPreferences.getString("activities", "");
      localStringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(str))
      {
        localStringBuilder.append(str);
        localStringBuilder.append(";");
      }
    }
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      if (!localIterator.hasNext())
      {
        this.c.clear();
        localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        localEditor.remove("activities");
        localEditor.putString("activities", localStringBuilder.toString());
        localEditor.commit();
        return;
      }
      x localx = (x)localIterator.next();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localx.a;
      arrayOfObject[1] = Long.valueOf(localx.b);
      localStringBuilder.append(String.format("[\"%s\",%d]", arrayOfObject));
      localStringBuilder.append(";");
    }
  }

  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
      synchronized (this.b)
      {
        this.b.put(paramString, Long.valueOf(System.currentTimeMillis()));
        return;
      }
  }

  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString));
    Long localLong;
    synchronized (this.b)
    {
      localLong = (Long)this.b.remove(paramString);
      if (localLong == null)
      {
        bj.e("MobclickAgent", String.format("please call 'onPageStart(%s)' before onPageEnd", new Object[] { paramString }));
        return;
      }
    }
    long l = System.currentTimeMillis() - localLong.longValue();
    synchronized (this.c)
    {
      this.c.add(new x(paramString, l));
      return;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.z
 * JD-Core Version:    0.6.2
 */