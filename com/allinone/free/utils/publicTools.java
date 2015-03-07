package com.allinone.free.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class publicTools
{
  public static Handler aa;
  public static Handler app_popular_handler;
  public static Handler app_recent_handler;
  public static Handler app_search_handler;
  public static Handler apppopularhandler;
  public static Handler apprecenthandler;
  public static JSONObject apps_in_downloading_list;
  public static Handler appsearchhandler;
  public static CookieManager cookieManager;
  public static Context ctx;
  public static Handler dmhandler;
  public static Boolean istagpp;
  public static Handler mp3_popular_handler;
  public static Handler mp3_recent_handler;
  public static Handler mp3_search_handler;
  public static Handler mp3popularhandler;
  public static Handler mp3recenthandler;
  public static Handler mp3searchhandler;
  public static Handler popuhandler;
  public static Handler popular_handler;
  public static Handler ringtone_popular_handler;
  public static Handler ringtone_recent_handler;
  public static Handler ringtone_search_handler;
  public static Handler ringtonepopularhandler;
  public static Handler ringtonerecenthandler;
  public static Handler ringtonesearchhandler;
  public static final String secret = "this_is_mobile_2014";
  public static SharedPreferences sp = null;
  public static final String timeurl = "http://android.downloadatoz.com/_201409/market/time.php";
  public static final String video_ga_tongji = "http://android.downloadatoz.com/_201409/market/hits.php?type=youtube&id=";

  public publicTools(Context paramContext)
  {
    ctx = paramContext;
    sp = paramContext.getSharedPreferences("datatime", 0);
    apps_in_downloading_list = new JSONObject();
  }

  public static void copyFile(String paramString1, String paramString2)
  {
    Log.v("xxxx", "oldPath:" + paramString1);
    Log.v("xxxx", "newPath:" + paramString2);
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString1));
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString2, false);
      byte[] arrayOfByte = new byte[1024];
      int i = 0;
      while (true)
      {
        if (i <= -1)
        {
          localFileInputStream.close();
          localFileOutputStream.flush();
          localFileOutputStream.close();
          return;
        }
        i = localFileInputStream.read(arrayOfByte);
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
    }
    catch (Exception localException)
    {
      Log.v("xxxx", "error:" + localException + ".");
      localException.printStackTrace();
    }
  }

  public static String doHttpPost(String paramString, HashMap<String, String> paramHashMap)
  {
    BasicHeader[] arrayOfBasicHeader = new BasicHeader[1];
    arrayOfBasicHeader[0] = new BasicHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows XP; DigExt)");
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpConnectionParams.setConnectionTimeout(localDefaultHttpClient.getParams(), 5000);
    HttpConnectionParams.setSoTimeout(localDefaultHttpClient.getParams(), 5000);
    ConnManagerParams.setTimeout(localDefaultHttpClient.getParams(), 5000);
    HttpPost localHttpPost = new HttpPost(paramString);
    localHttpPost.setHeaders(arrayOfBasicHeader);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    if (paramHashMap != null)
      localIterator = paramHashMap.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext());
      try
      {
        localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          String str2 = EntityUtils.toString(localHttpResponse.getEntity(), "UTF-8");
          return str2;
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localArrayList.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
        }
        else
        {
          String str1 = EntityUtils.toString(localHttpResponse.getEntity(), "UTF-8") + localHttpResponse.getStatusLine().getStatusCode() + "ERROR";
          return str1;
        }
      }
      catch (ConnectTimeoutException localConnectTimeoutException)
      {
        return "TIMEOUTERROR";
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return "OTHERERROR";
  }

  public static String getCode(String paramString)
  {
    Long localLong = getServerTime();
    if (localLong.longValue() == 0L)
      return "";
    return MD5.getMD5(paramString + localLong + "this_is_mobile_2014");
  }

  @SuppressLint({"NewApi"})
  public static String getDataFromURL(String paramString, HashMap<String, Integer> paramHashMap)
  {
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      if (((Integer)paramHashMap.get("redirect")).intValue() == 0)
        localHttpURLConnection.setInstanceFollowRedirects(false);
      if ((((Integer)paramHashMap.get("send_cookie")).intValue() == 1) && (cookieManager.getCookieStore().getCookies().size() > 0))
        localHttpURLConnection.setRequestProperty("Set-Cookie", TextUtils.join(",", cookieManager.getCookieStore().getCookies()));
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(15000);
      localHttpURLConnection.setRequestProperty("User-Agent", Myutils.setting_json.getString("agent"));
      localStringBuffer = new StringBuffer();
    }
    catch (Exception localException2)
    {
      try
      {
        HttpURLConnection localHttpURLConnection;
        StringBuffer localStringBuffer;
        int i = localHttpURLConnection.getResponseCode();
        Log.v("koko", paramString + "===" + i);
        Iterator localIterator;
        if ((i == 302) || (i == 301))
        {
          if (((Integer)paramHashMap.get("show_header")).intValue() == 1)
            localStringBuffer.append("Location: " + localHttpURLConnection.getHeaderField("Location"));
          Log.v("poi", "location:" + localHttpURLConnection.getHeaderField("Location"));
          localStringBuffer.append("");
          if (((Integer)paramHashMap.get("save_cookie")).intValue() == 1)
          {
            List localList = (List)localHttpURLConnection.getHeaderFields().get("Set-Cookie");
            if (localList != null)
            {
              localIterator = localList.iterator();
              label331: if (localIterator.hasNext())
                break label549;
            }
          }
          return localStringBuffer.toString();
        }
        while (true)
        {
          while (true)
          {
            label347: String str2 = localHttpURLConnection.getHeaderFieldKey(j);
            BufferedReader localBufferedReader;
            if (str2 == null)
              localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
            try
            {
              while (true)
              {
                String str3 = localBufferedReader.readLine();
                if (str3 == null)
                {
                  break;
                  if (((Integer)paramHashMap.get("show_header")).intValue() == 1)
                    localStringBuffer.append(str2 + ":" + localHttpURLConnection.getHeaderField(j));
                  Log.v("koko", str2 + ":" + localHttpURLConnection.getHeaderField(j));
                  j++;
                  break label347;
                }
                localStringBuffer.append(str3);
              }
            }
            catch (Exception localException1)
            {
            }
          }
          label507: localException1.printStackTrace();
          Log.v("eee", localException1);
          return "invalid";
          label549: 
          do
          {
            Log.v("koko", "非正常请求，比如网页打不开，或者没有权限");
            break;
            String str1 = (String)localIterator.next();
            cookieManager.getCookieStore().add(null, (HttpCookie)HttpCookie.parse(str1).get(0));
            break label331;
            localException2 = localException2;
            break label507;
          }
          while (i != 200);
          int j = 1;
        }
      }
      catch (Exception localException3)
      {
        break label507;
      }
    }
  }

  public static Long getServerTime()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    long l = 0L;
    try
    {
      localBoolean = Boolean.valueOf(sp.getBoolean("time_offset_is_set", false));
      l = sp.getLong("time_offset", 0L);
      Log.v("ioio", "time_offset:" + l);
      label60: if (localBoolean.booleanValue())
        return Long.valueOf(()(Math.floor(System.currentTimeMillis() / 1000L) + l));
      return Long.valueOf(0L);
    }
    catch (Exception localException)
    {
      break label60;
    }
  }

  public static String getUrl(String paramString)
  {
    try
    {
      localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setRequestMethod("GET");
      localHttpURLConnection.setConnectTimeout(15000);
      localStringBuffer = new StringBuffer();
    }
    catch (Exception localException2)
    {
      try
      {
        HttpURLConnection localHttpURLConnection;
        StringBuffer localStringBuffer;
        BufferedReader localBufferedReader;
        if (localHttpURLConnection.getResponseCode() == 200)
          localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
        try
        {
          while (true)
          {
            String str1 = localBufferedReader.readLine();
            if (str1 == null)
            {
              localStringBuffer.append("");
              String str2 = localStringBuffer.toString();
              return str2;
            }
            localStringBuffer.append(str1);
          }
        }
        catch (Exception localException1)
        {
        }
        while (true)
        {
          label107: localException1.printStackTrace();
          return null;
          localException2 = localException2;
        }
      }
      catch (Exception localException3)
      {
        break label107;
      }
    }
  }

  public static String get_a_random_user_webview()
  {
    InputStream localInputStream = ctx.getResources().openRawResource(2131034114);
    try
    {
      byte[] arrayOfByte = new byte[localInputStream.available()];
      localInputStream.read(arrayOfByte);
      String str = new String(arrayOfByte);
      localInputStream.close();
      Log.v("lolo", str);
      JSONArray localJSONArray = new JSONArray(str);
      localJSONArray.getJSONObject((int)Math.floor(Math.random() * localJSONArray.length())).get("text");
      return "http://m.downloadatoz.com/apps/com.about.wapdam.mp3.music,1186371/download.html";
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "http://m.downloadatoz.com/apps/com.about.wapdam.mp3.music,1186371/download.html";
  }

  public static boolean isNetworkAvailable(Context paramContext)
  {
    NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getAllNetworkInfo();
    if (arrayOfNetworkInfo != null);
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfNetworkInfo.length)
        return false;
      if (arrayOfNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED)
        return true;
    }
  }

  public static boolean is_app_downloading(String paramString)
  {
    Object localObject = Boolean.valueOf(false);
    int i = 0;
    try
    {
      while (true)
      {
        int j = apps_in_downloading_list.length();
        if (i >= j);
        while (true)
        {
          label21: return ((Boolean)localObject).booleanValue();
          if (!apps_in_downloading_list.getJSONObject(i).getString("url_id").equals(paramString))
            break;
          Boolean localBoolean = Boolean.valueOf(true);
          localObject = localBoolean;
        }
        i++;
      }
    }
    catch (Exception localException)
    {
      break label21;
    }
  }

  public static boolean is_good_domain(String paramString)
  {
    return (paramString.contains("93app.com/")) || (paramString.contains("downloadatoz.com/")) || (paramString.contains("liveloading.com/")) || (paramString.contains("xkee.com/"));
  }

  public static void make_path_ready(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
      localFile.mkdirs();
  }

  public static String readFile(String paramString)
  {
    Log.v("xxxx", "filename:" + paramString);
    Object localObject = "";
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(new File(paramString));
      byte[] arrayOfByte = new byte[1024];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      while (true)
      {
        if (localFileInputStream.read(arrayOfByte) == -1)
        {
          localByteArrayOutputStream.close();
          localFileInputStream.close();
          String str = localByteArrayOutputStream.toString();
          localObject = str;
          Log.v("xxxx", "content length:" + ((String)localObject).length() + ".");
          return localObject;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.v("xxxx", "error:" + localException + ".");
        localException.printStackTrace();
      }
    }
  }

  public static JSONObject read_json_from_file(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString);
      try
      {
        FileChannel localFileChannel = localFileInputStream.getChannel();
        MappedByteBuffer localMappedByteBuffer = localFileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, localFileChannel.size());
        String str = Charset.defaultCharset().decode(localMappedByteBuffer).toString();
        return new JSONObject(str);
      }
      finally
      {
        localFileInputStream.close();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject;
  }

  public static void resetServerTime()
  {
    sp.edit().putLong("time_offset", 0L).commit();
    sp.edit().putBoolean("time_offset_is_set", false).commit();
    try
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          String str = publicTools.getUrl("http://android.downloadatoz.com/_201409/market/time.php?" + System.currentTimeMillis());
          if (str != null)
          {
            Long localLong = Long.valueOf(()(Long.parseLong(str.trim()) - Math.floor(System.currentTimeMillis() / 1000L)));
            publicTools.sp.edit().putLong("time_offset", localLong.longValue()).commit();
            publicTools.sp.edit().putBoolean("time_offset_is_set", true).commit();
          }
        }
      }).start();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static void save_json_to_file(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(paramString));
      localBufferedWriter.write(paramJSONObject.toString());
      localBufferedWriter.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public static String set_a_random_user_agent()
  {
    Object localObject = "Mozilla/5.0 (Linux; Android 4.4.2; es-us; SAMSUNG SM-N900T Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/1.5 Chrome/28.0.1500.94 Mobile Safari/537.36";
    InputStream localInputStream = ctx.getResources().openRawResource(2131034113);
    try
    {
      byte[] arrayOfByte = new byte[localInputStream.available()];
      localInputStream.read(arrayOfByte);
      String str1 = new String(arrayOfByte);
      localInputStream.close();
      localJSONArray = new JSONArray(str1);
      i = 0;
      j = 0;
      if (j >= localJSONArray.length())
      {
        Log.v("max", i);
        k = (int)Math.floor(Math.random() * i);
        m = 0;
        int n = localJSONArray.length();
        if (m < n)
          break label194;
      }
    }
    catch (Exception localException)
    {
      try
      {
        while (true)
        {
          JSONArray localJSONArray;
          int i;
          int j;
          int k;
          int m;
          Myutils.setting_json.put("agent", localObject);
          Myutils.saveSetting();
          return localObject;
          JSONObject localJSONObject1 = localJSONArray.getJSONObject(j);
          localJSONObject1.put("start", i);
          i += localJSONObject1.getInt("n");
          localJSONObject1.put("end", i - 1);
          j++;
          continue;
          label194: JSONObject localJSONObject2 = localJSONArray.getJSONObject(m);
          if ((k >= localJSONObject2.getInt("start")) && (k < localJSONObject2.getInt("end")))
          {
            String str2 = localJSONObject2.getString("text");
            localObject = str2;
          }
          else
          {
            m++;
            continue;
            localException = localException;
            localException.printStackTrace();
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localObject;
  }

  public static void writeFile(String paramString1, String paramString2)
  {
    Log.v("xxxx", "content length2:" + paramString1.length() + ".");
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString2, false);
      localFileOutputStream.write(paramString1.getBytes());
      localFileOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.v("xxxx", "error2:" + localIOException + ".");
      localIOException.printStackTrace();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.publicTools
 * JD-Core Version:    0.6.2
 */