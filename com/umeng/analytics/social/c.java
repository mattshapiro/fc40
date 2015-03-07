package com.umeng.analytics.social;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public abstract class c
{
  // ERROR //
  private static String a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 14	java/io/BufferedReader
    //   3: dup
    //   4: new 16	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 19	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: sipush 8192
    //   15: invokespecial 22	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   18: astore_1
    //   19: new 24	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: aload_1
    //   28: invokevirtual 29	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore 7
    //   33: aload 7
    //   35: ifnonnull +12 -> 47
    //   38: aload_0
    //   39: invokevirtual 34	java/io/InputStream:close	()V
    //   42: aload_2
    //   43: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: areturn
    //   47: aload_2
    //   48: new 24	java/lang/StringBuilder
    //   51: dup
    //   52: aload 7
    //   54: invokestatic 43	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: ldc 48
    //   62: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: goto -45 -> 27
    //   75: astore 5
    //   77: ldc 54
    //   79: ldc 56
    //   81: aload 5
    //   83: invokestatic 62	com/umeng/analytics/social/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   86: aload_0
    //   87: invokevirtual 34	java/io/InputStream:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore 6
    //   94: ldc 54
    //   96: ldc 56
    //   98: aload 6
    //   100: invokestatic 62	com/umeng/analytics/social/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_3
    //   106: aload_0
    //   107: invokevirtual 34	java/io/InputStream:close	()V
    //   110: aload_3
    //   111: athrow
    //   112: astore 4
    //   114: ldc 54
    //   116: ldc 56
    //   118: aload 4
    //   120: invokestatic 62	com/umeng/analytics/social/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   123: aconst_null
    //   124: areturn
    //   125: astore 9
    //   127: ldc 54
    //   129: ldc 56
    //   131: aload 9
    //   133: invokestatic 62	com/umeng/analytics/social/b:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V
    //   136: aconst_null
    //   137: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   27	33	75	java/io/IOException
    //   47	72	75	java/io/IOException
    //   86	90	92	java/io/IOException
    //   27	33	105	finally
    //   47	72	105	finally
    //   77	86	105	finally
    //   106	110	112	java/io/IOException
    //   38	42	125	java/io/IOException
  }

  protected static String a(String paramString)
  {
    int i = new Random().nextInt(1000);
    while (true)
    {
      InputStream localInputStream;
      try
      {
        String str1 = System.getProperty("line.separator");
        if (paramString.length() <= 1)
        {
          b.b("MobclickAgent", i + ":\tInvalid baseUrl.");
          return null;
        }
        HttpGet localHttpGet = new HttpGet(paramString);
        b.a("MobclickAgent", i + ": GET_URL: " + paramString);
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
        HttpResponse localHttpResponse = new DefaultHttpClient(localBasicHttpParams).execute(localHttpGet);
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          if (localHttpEntity == null)
            break;
          localInputStream = localHttpEntity.getContent();
          Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader != null) && (localHeader.getValue().equalsIgnoreCase("gzip")))
          {
            b.a("MobclickAgent", i + "  Use GZIPInputStream get data....");
            localObject = new GZIPInputStream(localInputStream);
            String str2 = a((InputStream)localObject);
            b.a("MobclickAgent", i + ":\tresponse: " + str1 + str2);
            if (str2 == null)
              break;
            return str2;
          }
          if ((localHeader == null) || (!localHeader.getValue().equalsIgnoreCase("deflate")))
            break label444;
          b.a("MobclickAgent", i + "  Use InflaterInputStream get data....");
          localObject = new InflaterInputStream(localInputStream);
          continue;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        b.c("MobclickAgent", i + ":\tClientProtocolException,Failed to send message." + paramString, localClientProtocolException);
        return null;
        b.a("MobclickAgent", i + ":\tFailed to get message." + paramString);
        return null;
      }
      catch (Exception localException)
      {
        b.c("MobclickAgent", i + ":\tIOException,Failed to send message." + paramString, localException);
        return null;
      }
      label444: Object localObject = localInputStream;
    }
    return null;
  }

  protected static String a(String paramString1, String paramString2)
  {
    int i = new Random().nextInt(1000);
    String str1 = System.getProperty("line.separator");
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 20000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    b.a("MobclickAgent", i + ": POST_URL: " + paramString1);
    String str2;
    while (true)
    {
      InputStream localInputStream;
      try
      {
        HttpPost localHttpPost = new HttpPost(paramString1);
        if (!TextUtils.isEmpty(paramString2))
        {
          b.a("MobclickAgent", i + ": POST_BODY: " + paramString2);
          ArrayList localArrayList = new ArrayList(1);
          localArrayList.add(new BasicNameValuePair("data", paramString2));
          localHttpPost.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        }
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        if (localHttpResponse.getStatusLine().getStatusCode() == 200)
        {
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          if (localHttpEntity == null)
            break;
          localInputStream = localHttpEntity.getContent();
          Header localHeader = localHttpResponse.getFirstHeader("Content-Encoding");
          if ((localHeader != null) && (localHeader.getValue().equalsIgnoreCase("deflate")))
          {
            localObject = new InflaterInputStream(localInputStream);
            str2 = a((InputStream)localObject);
            b.a("MobclickAgent", i + ":\tresponse: " + str1 + str2);
            if (str2 != null)
              break label421;
            return null;
          }
        }
        else
        {
          b.c("MobclickAgent", i + ":\tFailed to send message." + paramString1);
          return null;
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        b.c("MobclickAgent", i + ":\tClientProtocolException,Failed to send message." + paramString1, localClientProtocolException);
        return null;
      }
      catch (IOException localIOException)
      {
        b.c("MobclickAgent", i + ":\tIOException,Failed to send message." + paramString1, localIOException);
        return null;
      }
      Object localObject = localInputStream;
    }
    return null;
    label421: return str2;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.social.c
 * JD-Core Version:    0.6.2
 */