package com.umeng.message.proguard;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class bb
{
  private static String b = "UTF-8";
  protected ConcurrentHashMap<String, String> a;

  public bb()
  {
    d();
  }

  public bb(String paramString1, String paramString2)
  {
    d();
    a(paramString1, paramString2);
  }

  public bb(Map<String, String> paramMap)
  {
    d();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      a((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }

  private void d()
  {
    this.a = new ConcurrentHashMap();
  }

  public HttpEntity a()
  {
    try
    {
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(b(), b);
      return localUrlEncodedFormEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }

  public void a(String paramString)
  {
    this.a.remove(paramString);
  }

  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
      this.a.put(paramString1, paramString2);
  }

  protected List<BasicNameValuePair> b()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
    return localLinkedList;
  }

  public String c()
  {
    return URLEncodedUtils.format(b(), b);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append("&");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.bb
 * JD-Core Version:    0.6.2
 */