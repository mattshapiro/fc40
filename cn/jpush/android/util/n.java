package cn.jpush.android.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONObject;

public final class n
{
  public static boolean a;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[40];
    int i = 0;
    String str1 = "$\004\037a).\b\005=qwRQ*e";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label36: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label52: int i2;
    int i3;
    if (k <= 1)
    {
      localObject4 = localObject3;
      n = m;
      i1 = k;
      localObject5 = localObject3;
      i2 = localObject5[m];
      switch (n % 5)
      {
      default:
        i3 = 69;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[m] = ((char)(i3 ^ i2));
      m = n + 1;
      if (i1 == 0)
      {
        localObject5 = localObject4;
        n = m;
        m = i1;
        break label52;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "\b\037\031b7g\034\003h+ K\003b67\004\037t g\030\005f12\030Q*e";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "{W\027f,+\016\025X2.\037\031X7\"\037\003n 4UO";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "&\b\005n*)Q\031s178\030j5+\0166b1gFQ";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "{W\024u7(\031O9";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\004\007\036t ";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = ")\004\005'$$\b\024w1&\t\035bs[G'hg";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "kK\004u)}";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "\024\016\003q 5K\024u7(\031Q*e";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "\022?7*}";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "\024\016\003q 5K\003b67\004\037t g\r\020n)2\031\024=qw[Q*e";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "{W\027f,+\016\0259{";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "\004\004\037i $\037\030h+";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "\004\004\037s )\037\\K )\f\005o";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "4\016\003q 5K\003b67\004\037t g\r\020n)2\031\024'hg";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "&\b\005n*)Q\031s17,\024sejK";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "t\f\006f5";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "4\037\020s04K\022h!\"Q";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = " \021\030w";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "$\006\006f5";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "\037F0w5j \024~";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "v[_7kwE@0w";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        i = 25;
        str1 = "&\005\025u*.\017_w 5\006\030t6.\004\037)\004\004(4T\026\030%4S\022\b9:X\026\023*%B";
        j = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i] = str2;
        i = 26;
        str1 = "\006\b\022b53F4i&(\017\030i\"";
        j = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i] = str2;
        i = 27;
        str1 = "";
        j = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i] = str2;
        i = 28;
        str1 = "\006\b\022b53";
        j = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i] = str2;
        i = 29;
        str1 = "\006\036\005o*5\002\013f1.\004\037";
        j = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[i] = str2;
        i = 30;
        str1 = "$\004\037i $\037\030q,3\022";
        j = 29;
        localObject1 = localObject2;
        break;
      case 29:
        localObject1[i] = str2;
        i = 31;
        str1 = "&\033\001k,$\n\005n*)D\033t*)";
        j = 30;
        localObject1 = localObject2;
        break;
      case 30:
        localObject1[i] = str2;
        i = 32;
        str1 = "\005\n\002n&g";
        j = 31;
        localObject1 = localObject2;
        break;
      case 31:
        localObject1[i] = str2;
        i = 33;
        str1 = "2\005\030p$7";
        j = 32;
        localObject1 = localObject2;
        break;
      case 32:
        localObject1[i] = str2;
        i = 34;
        str1 = "/\037\005wk5\004\004s i\017\024a$2\007\005*55\004\t~";
        j = 33;
        localObject1 = localObject2;
        break;
      case 33:
        localObject1[i] = str2;
        i = 35;
        str1 = "\004\004\037s )\037\\B+$\004\025n+ ";
        j = 34;
        localObject1 = localObject2;
        break;
      case 34:
        localObject1[i] = str2;
        i = 36;
        str1 = "\016$4&\"\033\005n*)Q\025b'2\f";
        j = 35;
        localObject1 = localObject2;
        break;
      case 35:
        localObject1[i] = str2;
        i = 37;
        str1 = "&\b\005n*)Q\025h2)\007\036f!\016\006\020` gFQr7+Q";
        j = 36;
        localObject1 = localObject2;
        break;
      case 36:
        localObject1[i] = str2;
        i = 38;
        str1 = "{W\037b10\004\003l 5\031\036u{y";
        j = 37;
        localObject1 = localObject2;
        break;
      case 37:
        localObject1[i] = str2;
        i = 39;
        str1 = "\r;$T\rj85L";
        j = 38;
        localObject1 = localObject2;
        break;
      case 38:
        localObject1[i] = str2;
        z = localObject2;
        a = false;
        return;
        i3 = 71;
        continue;
        i3 = 107;
        continue;
        i3 = 113;
        continue;
        i3 = 7;
      }
    }
  }

  public static int a(Context paramContext, JSONObject paramJSONObject, boolean paramBoolean)
  {
    String str1 = ac.a(2);
    if (!URLUtil.isHttpUrl(str1))
    {
      x.f();
      return -1;
    }
    HttpPost localHttpPost = new HttpPost(str1);
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    if (paramContext.getPackageManager().checkPermission(z[25], paramContext.getPackageName()) == 0)
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(z[30])).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.getType() != 1))
      {
        String str5 = localNetworkInfo.getExtraInfo();
        if ((str5 != null) && ((str5.equals(z[22])) || (str5.equals(z[19])) || (str5.equals(z[33]))))
          localDefaultHttpClient.getParams().setParameter(z[34], new HttpHost(z[24], 80));
      }
    }
    String str2 = "";
    if (paramJSONObject != null)
      str2 = paramJSONObject.toString();
    if (ai.a(str2))
    {
      x.c();
      return -2;
    }
    localHttpPost.addHeader(z[28], z[31]);
    localHttpPost.addHeader(z[26], z[21]);
    localHttpPost.addHeader(z[35], z[21]);
    localHttpPost.addHeader(z[23], a.v(paramContext));
    String str3;
    int i;
    if (str2 == null)
    {
      str3 = ac.a(paramContext);
      if (!ai.a(str3))
        break label343;
      x.c();
      i = 0;
    }
    while (true)
    {
      if (i != 0)
        break label405;
      x.c();
      return -3;
      str3 = ac.a(paramContext, str2, 2);
      break;
      label343: String str4 = ac.b(str3);
      if (ai.a(str4))
      {
        x.c();
        i = 0;
      }
      else
      {
        localHttpPost.addHeader(z[29], z[32] + str4);
        i = 1;
      }
    }
    try
    {
      label405: byte[] arrayOfByte1 = str2.getBytes(z[10]);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(arrayOfByte1);
      localGZIPOutputStream.close();
      byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      ByteArrayEntity localByteArrayEntity = new ByteArrayEntity(arrayOfByte2);
      localByteArrayEntity.setContentEncoding(z[21]);
      localHttpPost.setEntity(localByteArrayEntity);
      try
      {
        int j = localDefaultHttpClient.execute(localHttpPost).getStatusLine().getStatusCode();
        new StringBuilder(z[20]).append(j).toString();
        x.c();
        switch (j)
        {
        default:
          if (j / 100 == 5)
            return 500;
        case 401:
          x.e();
          return 401;
        case 404:
          return 404;
        case 429:
          return 429;
          return -5;
        case 200:
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        new StringBuilder(z[27]).append(localClientProtocolException.getMessage()).toString();
        x.f();
        return -1;
      }
      catch (IOException localIOException2)
      {
        while (true)
        {
          new StringBuilder(z[36]).append(localIOException2.getMessage()).toString();
          x.f();
        }
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      return -4;
    }
    catch (IOException localIOException1)
    {
      return -4;
    }
    return 200;
  }

  // ERROR //
  public static String a(String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: new 244	java/lang/StringBuilder
    //   3: dup
    //   4: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   7: iconst_3
    //   8: aaload
    //   9: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: pop
    //   20: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   23: lload_2
    //   24: ldc2_w 320
    //   27: lcmp
    //   28: iflt +11 -> 39
    //   31: lload_2
    //   32: ldc2_w 322
    //   35: lcmp
    //   36: ifle +7 -> 43
    //   39: ldc2_w 324
    //   42: lstore_2
    //   43: new 327	org/apache/http/client/methods/HttpGet
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 328	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   51: astore 5
    //   53: aload 5
    //   55: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   58: bipush 15
    //   60: aaload
    //   61: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   64: iconst_5
    //   65: aaload
    //   66: invokevirtual 329	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aconst_null
    //   70: astore 6
    //   72: iconst_0
    //   73: istore 7
    //   75: iconst_1
    //   76: putstatic 108	cn/jpush/android/util/n:a	Z
    //   79: invokestatic 332	cn/jpush/android/util/n:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   82: aload 5
    //   84: invokevirtual 293	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   87: astore 10
    //   89: aload 10
    //   91: ifnull +109 -> 200
    //   94: aload 10
    //   96: invokeinterface 299 1 0
    //   101: astore 11
    //   103: aload 11
    //   105: ifnull +95 -> 200
    //   108: aload 10
    //   110: invokeinterface 299 1 0
    //   115: invokeinterface 304 1 0
    //   120: istore 12
    //   122: iload 12
    //   124: sipush 200
    //   127: if_icmplt +183 -> 310
    //   130: iload 12
    //   132: sipush 300
    //   135: if_icmpge +175 -> 310
    //   138: aload 10
    //   140: invokeinterface 336 1 0
    //   145: astore 6
    //   147: aload 6
    //   149: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   152: bipush 10
    //   154: aaload
    //   155: invokestatic 341	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   158: astore 15
    //   160: aload 15
    //   162: ifnonnull +13 -> 175
    //   165: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   168: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   171: iconst_4
    //   172: aaload
    //   173: astore 15
    //   175: aload 10
    //   177: ifnull +15 -> 192
    //   180: aload 6
    //   182: ifnull +10 -> 192
    //   185: aload 6
    //   187: invokeinterface 349 1 0
    //   192: aload 15
    //   194: areturn
    //   195: astore 8
    //   197: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   200: iinc 7 1
    //   203: iload 7
    //   205: iconst_5
    //   206: if_icmplt +14 -> 220
    //   209: aload 5
    //   211: invokevirtual 352	org/apache/http/client/methods/HttpGet:abort	()V
    //   214: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   217: iconst_2
    //   218: aaload
    //   219: areturn
    //   220: lload_2
    //   221: invokestatic 358	java/lang/Thread:sleep	(J)V
    //   224: goto -149 -> 75
    //   227: astore 9
    //   229: goto -154 -> 75
    //   232: astore 26
    //   234: invokestatic 361	cn/jpush/android/util/x:i	()V
    //   237: aload 15
    //   239: areturn
    //   240: astore 24
    //   242: invokestatic 364	cn/jpush/android/util/x:g	()V
    //   245: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   248: iconst_4
    //   249: aaload
    //   250: astore 15
    //   252: aload 10
    //   254: ifnull -62 -> 192
    //   257: aload 6
    //   259: ifnull -67 -> 192
    //   262: aload 6
    //   264: invokeinterface 349 1 0
    //   269: aload 15
    //   271: areturn
    //   272: astore 25
    //   274: invokestatic 361	cn/jpush/android/util/x:i	()V
    //   277: aload 15
    //   279: areturn
    //   280: astore 22
    //   282: aload 10
    //   284: ifnull +15 -> 299
    //   287: aload 6
    //   289: ifnull +10 -> 299
    //   292: aload 6
    //   294: invokeinterface 349 1 0
    //   299: aload 22
    //   301: athrow
    //   302: astore 23
    //   304: invokestatic 361	cn/jpush/android/util/x:i	()V
    //   307: goto -8 -> 299
    //   310: iload 12
    //   312: sipush 400
    //   315: if_icmplt +242 -> 557
    //   318: iload 12
    //   320: sipush 500
    //   323: if_icmpge +234 -> 557
    //   326: sipush 400
    //   329: iload 12
    //   331: if_icmpne +34 -> 365
    //   334: new 244	java/lang/StringBuilder
    //   337: dup
    //   338: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   341: bipush 11
    //   343: aaload
    //   344: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   347: aload_0
    //   348: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: pop
    //   355: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   358: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   361: bipush 12
    //   363: aaload
    //   364: areturn
    //   365: sipush 401
    //   368: iload 12
    //   370: if_icmpne +33 -> 403
    //   373: new 244	java/lang/StringBuilder
    //   376: dup
    //   377: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   380: bipush 9
    //   382: aaload
    //   383: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   386: aload_0
    //   387: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: pop
    //   394: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   397: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   400: iconst_4
    //   401: aaload
    //   402: areturn
    //   403: sipush 404
    //   406: iload 12
    //   408: if_icmpne +33 -> 441
    //   411: new 244	java/lang/StringBuilder
    //   414: dup
    //   415: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   418: bipush 13
    //   420: aaload
    //   421: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   424: aload_0
    //   425: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   431: pop
    //   432: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   435: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   438: iconst_4
    //   439: aaload
    //   440: areturn
    //   441: sipush 406
    //   444: iload 12
    //   446: if_icmpne +33 -> 479
    //   449: new 244	java/lang/StringBuilder
    //   452: dup
    //   453: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   456: bipush 6
    //   458: aaload
    //   459: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   462: aload_0
    //   463: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: pop
    //   470: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   473: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   476: iconst_4
    //   477: aaload
    //   478: areturn
    //   479: sipush 408
    //   482: iload 12
    //   484: if_icmpne +33 -> 517
    //   487: new 244	java/lang/StringBuilder
    //   490: dup
    //   491: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   494: bipush 14
    //   496: aaload
    //   497: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   500: aload_0
    //   501: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: pop
    //   508: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   511: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   514: iconst_4
    //   515: aaload
    //   516: areturn
    //   517: aconst_null
    //   518: astore 15
    //   520: sipush 409
    //   523: iload 12
    //   525: if_icmpne -333 -> 192
    //   528: new 244	java/lang/StringBuilder
    //   531: dup
    //   532: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   535: iconst_0
    //   536: aaload
    //   537: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   540: aload_0
    //   541: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: pop
    //   548: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   551: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   554: iconst_4
    //   555: aaload
    //   556: areturn
    //   557: iload 12
    //   559: sipush 500
    //   562: if_icmplt +55 -> 617
    //   565: iload 12
    //   567: sipush 600
    //   570: if_icmpge +47 -> 617
    //   573: new 244	java/lang/StringBuilder
    //   576: dup
    //   577: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   580: bipush 8
    //   582: aaload
    //   583: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   586: iload 12
    //   588: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   594: bipush 7
    //   596: aaload
    //   597: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: aload_0
    //   601: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: pop
    //   608: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   611: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   614: iconst_4
    //   615: aaload
    //   616: areturn
    //   617: new 244	java/lang/StringBuilder
    //   620: dup
    //   621: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   624: iconst_1
    //   625: aaload
    //   626: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   629: iload 12
    //   631: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   637: bipush 7
    //   639: aaload
    //   640: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: aload_0
    //   644: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: pop
    //   651: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   654: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   657: iconst_4
    //   658: aaload
    //   659: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   75	89	195	java/lang/Exception
    //   94	103	195	java/lang/Exception
    //   220	224	227	java/lang/InterruptedException
    //   185	192	232	java/io/IOException
    //   138	160	240	java/lang/Exception
    //   165	175	240	java/lang/Exception
    //   262	269	272	java/io/IOException
    //   138	160	280	finally
    //   165	175	280	finally
    //   242	252	280	finally
    //   292	299	302	java/io/IOException
  }

  public static DefaultHttpClient a()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setContentCharset(localBasicHttpParams, z[10]);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, z[39]);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    return new DefaultHttpClient(localBasicHttpParams);
  }

  public static void a(String paramString1, String paramString2, p paramp)
  {
    try
    {
      new StringBuilder(z[37]).append(paramString1).toString();
      x.b();
      if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null))
        paramp.a(false, "");
      while (true)
      {
        return;
        new Thread(new o(paramString1.trim(), paramString2, paramp)).start();
      }
    }
    finally
    {
    }
  }

  public static boolean a(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || (paramString.equals(z[4])) || (paramString.equals(z[12])) || (paramString.equals(z[2])) || (paramString.equals(z[38]));
  }

  public static byte[] a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    byte[] arrayOfByte = null;
    for (int i = 0; i < 4; i++)
    {
      arrayOfByte = b(paramString, 5, 5000L);
      if (arrayOfByte != null)
        break;
    }
    return arrayOfByte;
  }

  // ERROR //
  private static byte[] b(String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifle +9 -> 10
    //   4: iload_1
    //   5: bipush 10
    //   7: if_icmple +5 -> 12
    //   10: iconst_1
    //   11: istore_1
    //   12: lload_2
    //   13: ldc2_w 320
    //   16: lcmp
    //   17: iflt +11 -> 28
    //   20: lload_2
    //   21: ldc2_w 322
    //   24: lcmp
    //   25: ifle +7 -> 32
    //   28: ldc2_w 324
    //   31: lstore_2
    //   32: new 244	java/lang/StringBuilder
    //   35: dup
    //   36: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   39: bipush 18
    //   41: aaload
    //   42: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   45: aload_0
    //   46: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: pop
    //   53: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   56: new 327	org/apache/http/client/methods/HttpGet
    //   59: dup
    //   60: aload_0
    //   61: invokespecial 328	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   64: astore 5
    //   66: aload 5
    //   68: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   71: bipush 15
    //   73: aaload
    //   74: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   77: iconst_5
    //   78: aaload
    //   79: invokevirtual 329	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: iconst_0
    //   83: istore 6
    //   85: iconst_1
    //   86: putstatic 108	cn/jpush/android/util/n:a	Z
    //   89: invokestatic 332	cn/jpush/android/util/n:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   92: aload 5
    //   94: invokevirtual 293	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   97: astore 11
    //   99: aload 11
    //   101: ifnull +65 -> 166
    //   104: aload 11
    //   106: invokeinterface 299 1 0
    //   111: invokeinterface 304 1 0
    //   116: istore 12
    //   118: sipush 200
    //   121: iload 12
    //   123: if_icmpne +296 -> 419
    //   126: aload 11
    //   128: invokeinterface 336 1 0
    //   133: astore 23
    //   135: aload 23
    //   137: astore 17
    //   139: aload 17
    //   141: ifnonnull +68 -> 209
    //   144: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   147: aload 17
    //   149: ifnull +10 -> 159
    //   152: aload 17
    //   154: invokeinterface 349 1 0
    //   159: aconst_null
    //   160: areturn
    //   161: astore 7
    //   163: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   166: iinc 6 1
    //   169: iload 6
    //   171: iload_1
    //   172: if_icmplt +10 -> 182
    //   175: aload 5
    //   177: invokevirtual 352	org/apache/http/client/methods/HttpGet:abort	()V
    //   180: aconst_null
    //   181: areturn
    //   182: lload_2
    //   183: iload 6
    //   185: i2l
    //   186: lmul
    //   187: lstore 8
    //   189: lload 8
    //   191: invokestatic 358	java/lang/Thread:sleep	(J)V
    //   194: goto -109 -> 85
    //   197: astore 10
    //   199: goto -114 -> 85
    //   202: astore 32
    //   204: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   207: aconst_null
    //   208: areturn
    //   209: aload 11
    //   211: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   214: bipush 16
    //   216: aaload
    //   217: invokeinterface 424 2 0
    //   222: astore 25
    //   224: aload 25
    //   226: ifnull +65 -> 291
    //   229: aload 25
    //   231: invokeinterface 429 1 0
    //   236: astore 26
    //   238: aload 26
    //   240: ifnull +57 -> 297
    //   243: aload 26
    //   245: invokestatic 435	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   248: istore 27
    //   250: aload 11
    //   252: invokeinterface 336 1 0
    //   257: invokestatic 438	org/apache/http/util/EntityUtils:toByteArray	(Lorg/apache/http/HttpEntity;)[B
    //   260: astore 28
    //   262: iload 27
    //   264: ifne +39 -> 303
    //   267: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   270: aload 17
    //   272: ifnull -113 -> 159
    //   275: aload 17
    //   277: invokeinterface 349 1 0
    //   282: aconst_null
    //   283: areturn
    //   284: astore 29
    //   286: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   289: aconst_null
    //   290: areturn
    //   291: aconst_null
    //   292: astore 26
    //   294: goto -56 -> 238
    //   297: iconst_0
    //   298: istore 27
    //   300: goto -50 -> 250
    //   303: aload 28
    //   305: arraylength
    //   306: iload 27
    //   308: if_icmpge +27 -> 335
    //   311: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   314: aload 17
    //   316: ifnull -157 -> 159
    //   319: aload 17
    //   321: invokeinterface 349 1 0
    //   326: aconst_null
    //   327: areturn
    //   328: astore 31
    //   330: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   333: aconst_null
    //   334: areturn
    //   335: aload 17
    //   337: ifnull +10 -> 347
    //   340: aload 17
    //   342: invokeinterface 349 1 0
    //   347: aload 28
    //   349: areturn
    //   350: astore 30
    //   352: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   355: goto -8 -> 347
    //   358: astore 20
    //   360: aconst_null
    //   361: astore 21
    //   363: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   366: aload 21
    //   368: ifnull -209 -> 159
    //   371: aload 21
    //   373: invokeinterface 349 1 0
    //   378: aconst_null
    //   379: areturn
    //   380: astore 22
    //   382: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   385: aconst_null
    //   386: areturn
    //   387: astore 16
    //   389: aconst_null
    //   390: astore 17
    //   392: aload 16
    //   394: astore 18
    //   396: aload 17
    //   398: ifnull +10 -> 408
    //   401: aload 17
    //   403: invokeinterface 349 1 0
    //   408: aload 18
    //   410: athrow
    //   411: astore 19
    //   413: invokestatic 344	cn/jpush/android/util/x:h	()V
    //   416: goto -8 -> 408
    //   419: sipush 400
    //   422: iload 12
    //   424: if_icmpne +29 -> 453
    //   427: new 244	java/lang/StringBuilder
    //   430: dup
    //   431: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   434: bipush 17
    //   436: aaload
    //   437: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   440: aload_0
    //   441: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: pop
    //   448: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   451: aconst_null
    //   452: areturn
    //   453: sipush 404
    //   456: iload 12
    //   458: if_icmpne +29 -> 487
    //   461: new 244	java/lang/StringBuilder
    //   464: dup
    //   465: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   468: bipush 13
    //   470: aaload
    //   471: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: aload_0
    //   475: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: pop
    //   482: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   485: aconst_null
    //   486: areturn
    //   487: new 244	java/lang/StringBuilder
    //   490: dup
    //   491: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   494: iconst_1
    //   495: aaload
    //   496: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: iload 12
    //   501: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   504: getstatic 106	cn/jpush/android/util/n:z	[Ljava/lang/String;
    //   507: bipush 7
    //   509: aaload
    //   510: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: aload_0
    //   514: invokevirtual 249	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 250	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: pop
    //   521: invokestatic 221	cn/jpush/android/util/x:c	()V
    //   524: aconst_null
    //   525: areturn
    //   526: astore 18
    //   528: goto -132 -> 396
    //   531: astore 18
    //   533: aload 21
    //   535: astore 17
    //   537: goto -141 -> 396
    //   540: astore 24
    //   542: aload 17
    //   544: astore 21
    //   546: goto -183 -> 363
    //   549: astore 33
    //   551: aconst_null
    //   552: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   85	99	161	java/lang/Exception
    //   189	194	197	java/lang/InterruptedException
    //   152	159	202	java/io/IOException
    //   275	282	284	java/io/IOException
    //   319	326	328	java/io/IOException
    //   340	347	350	java/io/IOException
    //   126	135	358	java/lang/Exception
    //   371	378	380	java/io/IOException
    //   126	135	387	finally
    //   401	408	411	java/io/IOException
    //   144	147	526	finally
    //   209	224	526	finally
    //   229	238	526	finally
    //   243	250	526	finally
    //   250	262	526	finally
    //   267	270	526	finally
    //   303	314	526	finally
    //   363	366	531	finally
    //   144	147	540	java/lang/Exception
    //   209	224	540	java/lang/Exception
    //   229	238	540	java/lang/Exception
    //   243	250	540	java/lang/Exception
    //   250	262	540	java/lang/Exception
    //   267	270	540	java/lang/Exception
    //   303	314	540	java/lang/Exception
    //   56	66	549	java/lang/Exception
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.n
 * JD-Core Version:    0.6.2
 */