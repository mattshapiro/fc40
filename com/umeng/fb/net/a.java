package com.umeng.fb.net;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.Store;
import com.umeng.fb.model.UserInfo;
import com.umeng.fb.util.Log;
import com.umeng.fb.util.b;
import com.umeng.fb.util.c;
import com.umeng.fb.util.d;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static final String a = "http://fb.umeng.com";
  public static final String b = "http://fb.umeng.com/api/v2/user/getuid";
  public static final String c = "http://fb.umeng.com/api/v2/feedback/reply/new";
  public static final String d = "http://fb.umeng.com/api/v2/feedback/reply/show";
  public static final String e = "http://fb.umeng.com/api/v2/feedback/new";
  public static final String f = "http://fb.umeng.com/api/v2/user/update";
  private static final String g = a.class.getName();
  private static final int n = 10000;
  private Context h;
  private final String i = "multipart/form-data";
  private final String j = "UTF-8";
  private final String k = "--";
  private final String l = UUID.randomUUID().toString();
  private final String m = "\r\n";

  public a(Context paramContext)
  {
    this.h = paramContext;
    b();
  }

  private String a(Map<String, String> paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuffer.append("--");
      localStringBuffer.append(this.l);
      localStringBuffer.append("\r\n");
      localStringBuffer.append("Content-Disposition: form-data; name=\"" + (String)localEntry.getKey() + "\"" + "\r\n");
      localStringBuffer.append("Content-Type: text/plain; charset=UTF-8\r\n");
      localStringBuffer.append("\r\n");
      localStringBuffer.append((String)localEntry.getValue());
      localStringBuffer.append("\r\n");
    }
    return localStringBuffer.toString();
  }

  private Map<String, String> a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = d.a(this.h);
    try
    {
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, localJSONObject.getString(str));
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localHashMap.put("feedback_id", paramString1);
      localHashMap.put("reply_id", paramString2);
      localHashMap.put("device_uuid", Store.getInstance(this.h).getDeviceUUID());
      localHashMap.put("type", "user_reply");
    }
    return localHashMap;
  }

  private JSONObject a(Reply paramReply, Map<String, String> paramMap, String paramString)
    throws IOException
  {
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Charset", "UTF-8");
      localHttpURLConnection.setRequestProperty("Connection", "keep-alive");
      localHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + this.l);
      localDataOutputStream = new DataOutputStream(localHttpURLConnection.getOutputStream());
      localDataOutputStream.write(a(paramMap).getBytes());
      File localFile = new File(c.b(this.h) + paramReply.reply_id + ".opus");
      if (!localFile.exists())
      {
        Log.c("uploadFile", "File does not exist --" + localFile.getAbsolutePath());
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--");
      localStringBuilder.append(this.l);
      localStringBuilder.append("\r\n");
      localStringBuilder.append("Content-Disposition: form-data; name=\"voice\"; filename=\"" + paramReply.reply_id + "\"" + "\r\n");
      localStringBuilder.append("Content-Type: application/octet-stream\r\n");
      localStringBuilder.append("\r\n");
      localDataOutputStream.write(localStringBuilder.toString().getBytes());
      localFileInputStream = new FileInputStream(localFile);
      byte[] arrayOfByte = new byte[1024];
      while (true)
      {
        int i1 = localFileInputStream.read(arrayOfByte);
        if (i1 == -1)
          break;
        localDataOutputStream.write(arrayOfByte, 0, i1);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      HttpURLConnection localHttpURLConnection;
      DataOutputStream localDataOutputStream;
      FileInputStream localFileInputStream;
      localMalformedURLException.printStackTrace();
      return null;
      localFileInputStream.close();
      localDataOutputStream.write("\r\n".getBytes());
      localDataOutputStream.write(("--" + this.l + "--" + "\r\n").getBytes());
      localDataOutputStream.flush();
      localDataOutputStream.close();
      JSONObject localJSONObject = a(localHttpURLConnection.getInputStream());
      localHttpURLConnection.disconnect();
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private static JSONObject a(InputStream paramInputStream)
    throws IOException, JSONException
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      String str = localBufferedReader.readLine();
      if (str == null)
        break;
      localStringBuilder.append(str);
    }
    localBufferedReader.close();
    return new JSONObject(localStringBuilder.toString());
  }

  private static JSONObject a(String paramString)
    throws IOException
  {
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      if (localHttpURLConnection.getResponseCode() != 200)
        throw new RuntimeException("Failed : HTTP error code : " + localHttpURLConnection.getResponseCode());
    }
    catch (MalformedURLException localMalformedURLException)
    {
      HttpURLConnection localHttpURLConnection;
      localMalformedURLException.printStackTrace();
      return null;
      JSONObject localJSONObject = a(localHttpURLConnection.getInputStream());
      localHttpURLConnection.disconnect();
      Log.c(g, "\t " + localJSONObject);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private static JSONObject a(String paramString, Map<String, Object> paramMap)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if ((localStringBuilder.charAt(-1 + localStringBuilder.length()) != '?') && (paramMap.size() > 0))
      localStringBuilder.append('?');
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = "" + paramMap.get(str1);
      localStringBuilder.append(URLEncoder.encode(str1, "UTF-8") + "=" + URLEncoder.encode(str2, "UTF-8") + "&");
    }
    if ('&' == localStringBuilder.charAt(-1 + localStringBuilder.length()))
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    return a(localStringBuilder.toString());
  }

  private static JSONObject a(JSONObject paramJSONObject, String paramString)
    throws IOException
  {
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoOutput(true);
      localHttpURLConnection.setRequestMethod("POST");
      localHttpURLConnection.setRequestProperty("Content-Type", "application/json");
      localHttpURLConnection.setConnectTimeout(10000);
      localHttpURLConnection.setReadTimeout(10000);
      String str = paramJSONObject.toString();
      BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
      localBufferedOutputStream.write(str.getBytes());
      localBufferedOutputStream.flush();
      if (localHttpURLConnection.getResponseCode() != 200)
        throw new RuntimeException("Failed : HTTP error code : " + localHttpURLConnection.getResponseCode());
    }
    catch (MalformedURLException localMalformedURLException)
    {
      HttpURLConnection localHttpURLConnection;
      localMalformedURLException.printStackTrace();
      return null;
      JSONObject localJSONObject = a(localHttpURLConnection.getInputStream());
      localHttpURLConnection.disconnect();
      Log.c(g, "\t response:\n" + localJSONObject);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  private Map<String, String> b(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      if (c(paramJSONObject))
      {
        String str = paramJSONObject.getJSONObject("data").getString("feedback_id");
        long l1 = paramJSONObject.getJSONObject("data").getLong("created_at");
        localHashMap.put("feedback_id", str);
        localHashMap.put("created_at", Long.valueOf(l1));
      }
      return localHashMap;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localHashMap;
  }

  private static void b()
  {
    if (Integer.parseInt(Build.VERSION.SDK) < 8)
      System.setProperty("http.keepAlive", "false");
  }

  private boolean c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null);
    while (true)
    {
      return false;
      try
      {
        String str = paramJSONObject.getString("status");
        if (str != null)
        {
          boolean bool = str.equals("200");
          if (bool)
            return true;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return false;
  }

  public String a()
  {
    try
    {
      JSONObject localJSONObject1 = d.a(this.h);
      localStringBuilder = new StringBuilder("http://fb.umeng.com/api/v2/user/getuid");
      localStringBuilder.append("?");
      Iterator localIterator = localJSONObject1.keys();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str3 = localJSONObject1.get(str2).toString();
        localStringBuilder.append(URLEncoder.encode(str2, "UTF-8") + "=" + URLEncoder.encode(str3, "UTF-8") + "&");
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder;
      String str1 = "";
      while (true)
      {
        return str1;
        if ('&' == localStringBuilder.charAt(-1 + localStringBuilder.length()))
          localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        JSONObject localJSONObject2 = a(localStringBuilder.toString());
        if (!c(localJSONObject2))
          break;
        str1 = localJSONObject2.getJSONObject("data").getString("uid");
        Store.getInstance(this.h).setUid(str1);
      }
    }
    finally
    {
    }
  }

  public List<Reply> a(String paramString, long paramLong)
    throws IOException, JSONException
  {
    ArrayList localArrayList;
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("feedback_id", paramString);
      localHashMap.put("appkey", b.p(this.h));
      localHashMap.put("updated_at", Long.valueOf(paramLong));
      JSONObject localJSONObject = a("http://fb.umeng.com/api/v2/feedback/reply/show", localHashMap);
      Log.c(g, "getDevReply resp: " + localJSONObject);
      JSONArray localJSONArray = localJSONObject.getJSONObject("data").getJSONArray("result");
      localArrayList = new ArrayList();
      int i1 = 0;
      while (true)
      {
        int i2 = localJSONArray.length();
        if (i1 < i2)
          try
          {
            localArrayList.add(Reply.fromJson(localJSONArray.getJSONObject(i1)));
            i1++;
          }
          catch (JSONException localJSONException)
          {
            while (true)
              localJSONException.printStackTrace();
          }
      }
    }
    finally
    {
    }
    return localArrayList;
  }

  public Map a(String paramString, Reply paramReply)
  {
    try
    {
      if ("text_reply".equals(paramReply.content_type))
      {
        JSONObject localJSONObject2 = d.a(this.h);
        localJSONObject2.put("content", paramReply.content);
        localJSONObject2.put("feedback_id", paramString);
        localJSONObject2.put("reply_id", paramReply.reply_id);
        localJSONObject2.put("device_uuid", Store.getInstance(this.h).getDeviceUUID());
        localJSONObject2.put("type", "user_reply");
        JSONObject localJSONObject3 = a(localJSONObject2, "http://fb.umeng.com/api/v2/feedback/reply/new");
        localObject2 = localJSONObject3;
      }
      while (true)
      {
        Map localMap = b((JSONObject)localObject2);
        return localMap;
        boolean bool = "audio_reply".equals(paramReply.content_type);
        localObject2 = null;
        if (bool)
        {
          JSONObject localJSONObject1 = a(paramReply, a(paramString, paramReply.reply_id), "http://fb.umeng.com/api/v2/feedback/reply/new");
          localObject2 = localJSONObject1;
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        Object localObject2 = null;
      }
    }
    finally
    {
    }
  }

  public boolean a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = d.a(this.h);
      localJSONObject.put("uid", Store.getInstance(this.h).getUid());
      localJSONObject.put("userinfo", paramJSONObject.toString());
      boolean bool2 = c(a(localJSONObject, "http://fb.umeng.com/api/v2/user/update"));
      bool1 = bool2;
      return bool1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool1 = false;
      }
    }
    finally
    {
    }
  }

  public Map b(String paramString, Reply paramReply)
  {
    try
    {
      new HashMap();
      try
      {
        if ("text_reply".equals(paramReply.content_type))
        {
          JSONObject localJSONObject2 = d.a(this.h);
          localJSONObject2.put("content", paramReply.content);
          localJSONObject2.put("uid", Store.getInstance(this.h).getUid());
          localJSONObject2.put("device_uuid", Store.getInstance(this.h).getDeviceUUID());
          localJSONObject2.put("feedback_id", paramString);
          if (Store.getInstance(this.h).getUserInfo().getRemarkJson() != null)
            localJSONObject2.put("remark", Store.getInstance(this.h).getUserInfo().getRemarkJson().toString());
          JSONObject localJSONObject3 = a(localJSONObject2, "http://fb.umeng.com/api/v2/feedback/new");
          localObject2 = localJSONObject3;
        }
        while (true)
        {
          Map localMap = b((JSONObject)localObject2);
          return localMap;
          boolean bool = "audio_reply".equals(paramReply.content_type);
          localObject2 = null;
          if (bool)
          {
            JSONObject localJSONObject1 = a(paramReply, a(paramString, paramReply.reply_id), "http://fb.umeng.com/api/v2/feedback/new");
            localObject2 = localJSONObject1;
          }
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          localException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
    finally
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.net.a
 * JD-Core Version:    0.6.2
 */