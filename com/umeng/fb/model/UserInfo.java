package com.umeng.fb.model;

import android.text.TextUtils;
import com.umeng.fb.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo
{
  private static final String e = UserInfo.class.getName();
  int a = -1;
  String b = "";
  Map<String, String> c;
  Map<String, String> d;

  public UserInfo()
  {
    this.c = new HashMap();
    this.d = new HashMap();
  }

  UserInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.a = paramJSONObject.optInt("age_group", -1);
    this.b = paramJSONObject.optString("gender", "");
    this.c = new HashMap();
    this.d = new HashMap();
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("contact");
    if (localJSONObject1 != null)
    {
      Iterator localIterator2 = localJSONObject1.keys();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        this.c.put(str2, localJSONObject1.getString(str2));
      }
    }
    JSONObject localJSONObject2 = paramJSONObject.optJSONObject("remark");
    Log.c(e, "" + localJSONObject2);
    if (localJSONObject2 != null)
    {
      Iterator localIterator1 = localJSONObject2.keys();
      while (localIterator1.hasNext())
      {
        String str1 = (String)localIterator1.next();
        this.d.put(str1, localJSONObject2.getString(str1));
      }
    }
  }

  public int getAgeGroup()
  {
    return this.a;
  }

  public Map<String, String> getContact()
  {
    return this.c;
  }

  public String getGender()
  {
    return this.b;
  }

  public Map<String, String> getRemark()
  {
    return this.d;
  }

  public JSONObject getRemarkJson()
  {
    Map localMap = this.d;
    Object localObject = null;
    if (localMap != null)
    {
      int i = this.d.size();
      localObject = null;
      if (i <= 0);
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONException localJSONException2;
      try
      {
        Iterator localIterator = this.d.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
      }
      catch (JSONException localJSONException1)
      {
        localJSONException2 = localJSONException1;
        localObject = localJSONObject;
      }
      localJSONException2.printStackTrace();
      return localObject;
      return localJSONObject;
    }
    catch (JSONException localJSONException3)
    {
      while (true)
        localObject = null;
    }
  }

  public void setAgeGroup(int paramInt)
  {
    this.a = paramInt;
  }

  public void setContact(Map<String, String> paramMap)
  {
    this.c = paramMap;
  }

  public void setGender(String paramString)
  {
    this.b = paramString;
  }

  public void setRemark(Map<String, String> paramMap)
  {
    this.d = paramMap;
  }

  public JSONObject toJson()
  {
    JSONObject localJSONObject1 = new JSONObject();
    do
    {
      JSONObject localJSONObject3;
      try
      {
        if (this.a > -1)
          localJSONObject1.put("age_group", this.a);
        if (!TextUtils.isEmpty(this.b))
          localJSONObject1.put("gender", this.b);
        if ((this.c == null) || (this.c.size() <= 0))
          continue;
        localJSONObject3 = new JSONObject();
        Iterator localIterator2 = this.c.entrySet().iterator();
        while (localIterator2.hasNext())
        {
          Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
          localJSONObject3.put((String)localEntry2.getKey(), localEntry2.getValue());
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      localJSONObject1.put("contact", localJSONObject3);
    }
    while ((this.d == null) || (this.d.size() <= 0));
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator1 = this.d.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
      localJSONObject2.put((String)localEntry1.getKey(), localEntry1.getValue());
    }
    localJSONObject1.put("remark", localJSONObject2);
    return localJSONObject1;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.model.UserInfo
 * JD-Core Version:    0.6.2
 */