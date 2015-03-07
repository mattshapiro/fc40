package net.tsz.afinal.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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

public class AjaxParams
{
  private static String ENCODING = "UTF-8";
  protected ConcurrentHashMap<String, FileWrapper> fileParams;
  protected ConcurrentHashMap<String, String> urlParams;

  public AjaxParams()
  {
    init();
  }

  public AjaxParams(String paramString1, String paramString2)
  {
    init();
    put(paramString1, paramString2);
  }

  public AjaxParams(Map<String, String> paramMap)
  {
    init();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      put((String)localEntry.getKey(), (String)localEntry.getValue());
    }
  }

  public AjaxParams(Object[] paramArrayOfObject)
  {
    init();
    int i = paramArrayOfObject.length;
    if (i % 2 != 0)
      throw new IllegalArgumentException("Supplied arguments must be even");
    for (int j = 0; ; j += 2)
    {
      if (j >= i)
        return;
      put(String.valueOf(paramArrayOfObject[j]), String.valueOf(paramArrayOfObject[(j + 1)]));
    }
  }

  private void init()
  {
    this.urlParams = new ConcurrentHashMap();
    this.fileParams = new ConcurrentHashMap();
  }

  public HttpEntity getEntity()
  {
    if (!this.fileParams.isEmpty())
    {
      MultipartEntity localMultipartEntity = new MultipartEntity();
      Iterator localIterator1 = this.urlParams.entrySet().iterator();
      int i;
      int j;
      Iterator localIterator2;
      while (true)
      {
        if (!localIterator1.hasNext())
        {
          i = 0;
          j = -1 + this.fileParams.entrySet().size();
          localIterator2 = this.fileParams.entrySet().iterator();
          if (localIterator2.hasNext())
            break;
          return localMultipartEntity;
        }
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        localMultipartEntity.addPart((String)localEntry1.getKey(), (String)localEntry1.getValue());
      }
      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
      FileWrapper localFileWrapper = (FileWrapper)localEntry2.getValue();
      boolean bool;
      if (localFileWrapper.inputStream != null)
      {
        if (i != j)
          break label207;
        bool = true;
        label162: if (localFileWrapper.contentType == null)
          break label213;
        localMultipartEntity.addPart((String)localEntry2.getKey(), localFileWrapper.getFileName(), localFileWrapper.inputStream, localFileWrapper.contentType, bool);
      }
      while (true)
      {
        i++;
        break;
        label207: bool = false;
        break label162;
        label213: localMultipartEntity.addPart((String)localEntry2.getKey(), localFileWrapper.getFileName(), localFileWrapper.inputStream, bool);
      }
    }
    try
    {
      UrlEncodedFormEntity localUrlEncodedFormEntity = new UrlEncodedFormEntity(getParamsList(), ENCODING);
      return localUrlEncodedFormEntity;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return null;
  }

  public String getParamString()
  {
    return URLEncodedUtils.format(getParamsList(), ENCODING);
  }

  protected List<BasicNameValuePair> getParamsList()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.urlParams.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localLinkedList;
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localLinkedList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
    }
  }

  public void put(String paramString, File paramFile)
    throws FileNotFoundException
  {
    put(paramString, new FileInputStream(paramFile), paramFile.getName());
  }

  public void put(String paramString, InputStream paramInputStream)
  {
    put(paramString, paramInputStream, null);
  }

  public void put(String paramString1, InputStream paramInputStream, String paramString2)
  {
    put(paramString1, paramInputStream, paramString2, null);
  }

  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramInputStream != null))
      this.fileParams.put(paramString1, new FileWrapper(paramInputStream, paramString2, paramString3));
  }

  public void put(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
      this.urlParams.put(paramString1, paramString2);
  }

  public void remove(String paramString)
  {
    this.urlParams.remove(paramString);
    this.fileParams.remove(paramString);
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.urlParams.entrySet().iterator();
    Iterator localIterator2;
    if (!localIterator1.hasNext())
      localIterator2 = this.fileParams.entrySet().iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        return localStringBuilder.toString();
        Map.Entry localEntry1 = (Map.Entry)localIterator1.next();
        if (localStringBuilder.length() > 0)
          localStringBuilder.append("&");
        localStringBuilder.append((String)localEntry1.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry1.getValue());
        break;
      }
      Map.Entry localEntry2 = (Map.Entry)localIterator2.next();
      if (localStringBuilder.length() > 0)
        localStringBuilder.append("&");
      localStringBuilder.append((String)localEntry2.getKey());
      localStringBuilder.append("=");
      localStringBuilder.append("FILE");
    }
  }

  private static class FileWrapper
  {
    public String contentType;
    public String fileName;
    public InputStream inputStream;

    public FileWrapper(InputStream paramInputStream, String paramString1, String paramString2)
    {
      this.inputStream = paramInputStream;
      this.fileName = paramString1;
      this.contentType = paramString2;
    }

    public String getFileName()
    {
      if (this.fileName != null)
        return this.fileName;
      return "nofilename";
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.AjaxParams
 * JD-Core Version:    0.6.2
 */