package cn.jpush.android.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;

public final class h
{
  public static ArrayList<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
      return localArrayList;
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      String str = paramJSONArray.optString(i);
      if (!TextUtils.isEmpty(str))
        localArrayList.add(str);
    }
    return localArrayList;
  }

  public static JSONArray a(ArrayList<String> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
      localJSONArray.put((String)localIterator.next());
    return localJSONArray;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.h
 * JD-Core Version:    0.6.2
 */