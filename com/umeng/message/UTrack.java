package com.umeng.message;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import com.umeng.common.message.Log;
import com.umeng.common.message.b;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.aB.a;
import com.umeng.message.proguard.aB.a.b;
import com.umeng.message.proguard.aB.a.d;
import com.umeng.message.proguard.aD;
import com.umeng.message.proguard.aD.e;
import com.umeng.message.proguard.aE;
import com.umeng.message.proguard.ax;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class UTrack
{
  private static final String a = UTrack.class.getName();
  private static UTrack c;
  private static boolean f = false;
  private static boolean g = false;
  private static boolean h = false;
  private JSONObject b;
  private ScheduledThreadPoolExecutor d;
  private Context e;

  private UTrack(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
    b();
    this.d = new ScheduledThreadPoolExecutor(4 * Runtime.getRuntime().availableProcessors());
  }

  private JSONObject a(JSONObject paramJSONObject, String paramString)
    throws aD.e, JSONException, Exception
  {
    String str = aD.c(paramString).H().r("application/json").i(paramJSONObject.toString()).b("UTF-8");
    Log.c(a, "sendRequest() url=" + paramString + "\n request = " + paramJSONObject + "\n response = " + str);
    return new JSONObject(str);
  }

  private void a(final String paramString, final int paramInt, long paramLong)
  {
    if (!c())
      return;
    if (TextUtils.isEmpty(paramString))
    {
      Log.b(a, "trackMsgLog: empty msgId");
      return;
    }
    final long l1 = System.currentTimeMillis();
    MsgLogStore.getInstance(this.e).addLog(paramString, paramInt, l1);
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        UTrack.a(UTrack.this, paramString, paramInt, l1);
      }
    };
    if ((paramLong > 0L) && (paramInt != 1));
    for (long l2 = Math.abs(new Random().nextLong() % paramLong); ; l2 = 0L)
    {
      String str = a;
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt);
      arrayOfObject[2] = Long.valueOf(paramLong);
      arrayOfObject[3] = Long.valueOf(l2);
      Log.c(str, String.format("trackMsgLog(msgId=%s, actionType=%d, random=%d, delay=%d)", arrayOfObject));
      this.d.schedule(local1, l2, TimeUnit.MILLISECONDS);
      return;
    }
  }

  private void b()
  {
    b localb;
    if (this.b == null)
    {
      localb = new b();
      localb.b(this.e, new String[0]);
      Context localContext = this.e;
      String[] arrayOfString = new String[2];
      arrayOfString[0] = PushAgent.getInstance(this.e).getMessageAppkey();
      arrayOfString[1] = PushAgent.getInstance(this.e).getMessageChannel();
      localb.a(localContext, arrayOfString);
      this.b = new JSONObject();
    }
    try
    {
      localb.b(this.b);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void b(String paramString, int paramInt, long paramLong)
  {
    try
    {
      JSONObject localJSONObject = e();
      localJSONObject.put("msg_id", paramString);
      localJSONObject.put("action_type", paramInt);
      localJSONObject.put("ts", paramLong);
      aE localaE = new aE(this.e);
      aB.a locala = localaE.a(localaE.a(localJSONObject), MsgConstant.LOG_ENDPOINT);
      if ((locala != null) && (locala.p().equals(aB.a.d.a)))
      {
        MsgLogStore.getInstance(this.e).removeLog(paramString, paramInt);
        if (paramInt != 0)
          MsgLogStore.getInstance(this.e).removeLogIdType(paramString);
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private boolean c()
  {
    if (TextUtils.isEmpty(DeviceConfig.getUtdid(this.e)))
    {
      Log.b(a, "UTDID is empty");
      return false;
    }
    if (TextUtils.isEmpty(UmengRegistrar.getRegistrationId(this.e)))
    {
      Log.b(a, "RegistrationId is empty");
      return false;
    }
    return true;
  }

  // ERROR //
  private String d()
  {
    // Byte code:
    //   0: invokestatic 319	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   3: ldc_w 321
    //   6: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 103	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   21: invokestatic 326	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   24: invokevirtual 331	java/io/File:getPath	()Ljava/lang/String;
    //   27: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc_w 333
    //   33: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: getfield 46	com/umeng/message/UTrack:e	Landroid/content/Context;
    //   40: invokevirtual 336	android/content/Context:getPackageName	()Ljava/lang/String;
    //   43: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc_w 338
    //   49: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_2
    //   56: getstatic 28	com/umeng/message/UTrack:a	Ljava/lang/String;
    //   59: new 103	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 340
    //   69: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_2
    //   73: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 123	com/umeng/common/message/Log:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: new 328	java/io/File
    //   85: dup
    //   86: aload_2
    //   87: ldc_w 342
    //   90: invokespecial 344	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: astore_3
    //   94: aload_3
    //   95: invokevirtual 347	java/io/File:exists	()Z
    //   98: istore 4
    //   100: iload 4
    //   102: ifeq +212 -> 314
    //   105: new 349	java/io/BufferedReader
    //   108: dup
    //   109: new 351	java/io/FileReader
    //   112: dup
    //   113: aload_3
    //   114: invokespecial 354	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   117: invokespecial 357	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   120: astore 5
    //   122: aload 5
    //   124: invokevirtual 360	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   127: astore 12
    //   129: aload 12
    //   131: ifnull +57 -> 188
    //   134: aload 12
    //   136: ldc_w 362
    //   139: invokevirtual 365	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   142: ifeq -20 -> 122
    //   145: aload 12
    //   147: ldc_w 362
    //   150: invokevirtual 368	java/lang/String:length	()I
    //   153: invokevirtual 372	java/lang/String:substring	(I)Ljava/lang/String;
    //   156: astore 13
    //   158: aload 5
    //   160: ifnull +8 -> 168
    //   163: aload 5
    //   165: invokevirtual 375	java/io/BufferedReader:close	()V
    //   168: aload 13
    //   170: areturn
    //   171: astore 14
    //   173: aload 14
    //   175: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   178: goto -10 -> 168
    //   181: astore_1
    //   182: aload_1
    //   183: invokevirtual 237	java/lang/Exception:printStackTrace	()V
    //   186: aconst_null
    //   187: areturn
    //   188: aload 5
    //   190: ifnull +124 -> 314
    //   193: aload 5
    //   195: invokevirtual 375	java/io/BufferedReader:close	()V
    //   198: aconst_null
    //   199: areturn
    //   200: astore 15
    //   202: aload 15
    //   204: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   207: aconst_null
    //   208: areturn
    //   209: astore 6
    //   211: aconst_null
    //   212: astore 5
    //   214: aload 6
    //   216: invokevirtual 377	java/io/FileNotFoundException:printStackTrace	()V
    //   219: aload 5
    //   221: ifnull +93 -> 314
    //   224: aload 5
    //   226: invokevirtual 375	java/io/BufferedReader:close	()V
    //   229: aconst_null
    //   230: areturn
    //   231: astore 9
    //   233: aload 9
    //   235: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   238: aconst_null
    //   239: areturn
    //   240: astore 10
    //   242: aconst_null
    //   243: astore 5
    //   245: aload 10
    //   247: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   250: aload 5
    //   252: ifnull +62 -> 314
    //   255: aload 5
    //   257: invokevirtual 375	java/io/BufferedReader:close	()V
    //   260: aconst_null
    //   261: areturn
    //   262: astore 11
    //   264: aload 11
    //   266: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   269: aconst_null
    //   270: areturn
    //   271: astore 7
    //   273: aconst_null
    //   274: astore 5
    //   276: aload 5
    //   278: ifnull +8 -> 286
    //   281: aload 5
    //   283: invokevirtual 375	java/io/BufferedReader:close	()V
    //   286: aload 7
    //   288: athrow
    //   289: astore 8
    //   291: aload 8
    //   293: invokevirtual 376	java/io/IOException:printStackTrace	()V
    //   296: goto -10 -> 286
    //   299: astore 7
    //   301: goto -25 -> 276
    //   304: astore 10
    //   306: goto -61 -> 245
    //   309: astore 6
    //   311: goto -97 -> 214
    //   314: aconst_null
    //   315: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   163	168	171	java/io/IOException
    //   0	12	181	java/lang/Exception
    //   14	100	181	java/lang/Exception
    //   163	168	181	java/lang/Exception
    //   173	178	181	java/lang/Exception
    //   193	198	181	java/lang/Exception
    //   202	207	181	java/lang/Exception
    //   224	229	181	java/lang/Exception
    //   233	238	181	java/lang/Exception
    //   255	260	181	java/lang/Exception
    //   264	269	181	java/lang/Exception
    //   281	286	181	java/lang/Exception
    //   286	289	181	java/lang/Exception
    //   291	296	181	java/lang/Exception
    //   193	198	200	java/io/IOException
    //   105	122	209	java/io/FileNotFoundException
    //   224	229	231	java/io/IOException
    //   105	122	240	java/io/IOException
    //   255	260	262	java/io/IOException
    //   105	122	271	finally
    //   281	286	289	java/io/IOException
    //   122	129	299	finally
    //   134	158	299	finally
    //   214	219	299	finally
    //   245	250	299	finally
    //   122	129	304	java/io/IOException
    //   134	158	304	java/io/IOException
    //   122	129	309	java/io/FileNotFoundException
    //   134	158	309	java/io/FileNotFoundException
  }

  private JSONObject e()
    throws JSONException
  {
    String str1 = UmengRegistrar.getRegistrationId(this.e);
    String str2 = DeviceConfig.getUtdid(this.e);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("header", this.b);
    localJSONObject.put("utdid", str2);
    localJSONObject.put("device_token", str1);
    return localJSONObject;
  }

  public static UTrack getInstance(Context paramContext)
  {
    try
    {
      if (c == null)
        c = new UTrack(paramContext);
      UTrack localUTrack = c;
      return localUTrack;
    }
    finally
    {
    }
  }

  void a(UMessage paramUMessage)
  {
    if ((paramUMessage == null) || (paramUMessage.msg_id == null))
      return;
    a(paramUMessage.msg_id, 0, 60000L * paramUMessage.random_min);
  }

  public boolean addAlias(String paramString1, String paramString2)
    throws aD.e, JSONException, Exception
  {
    if (TextUtils.isEmpty(paramString2))
      Log.b(a, "addAlias: empty type");
    aB.a locala;
    do
    {
      do
        return false;
      while (!c());
      if (MessageSharedPrefs.getInstance(this.e).isAliasSet(paramString1, paramString2))
      {
        Log.c(a, String.format("addAlias: <%s, %s> has been synced to the server before. Ingore this request.", new Object[] { paramString1, paramString2 }));
        return true;
      }
      if ((MessageSharedPrefs.getInstance(this.e).getAliasCount() >= 20) && (!MessageSharedPrefs.getInstance(this.e).isAliaseTypeSet(paramString2)))
      {
        Log.b(a, String.format("addAlias: <%s, %s>, More than 20 types of alias have been added. Ignore this request", new Object[] { paramString1, paramString2 }));
        return false;
      }
      JSONObject localJSONObject = e();
      localJSONObject.put("alias", paramString1);
      localJSONObject.put("type", paramString2);
      localJSONObject.put("last_alias", MessageSharedPrefs.getInstance(this.e).getLastAlias(paramString2));
      localJSONObject.put("ts", System.currentTimeMillis());
      aE localaE = new aE(this.e);
      locala = localaE.a(localaE.a(localJSONObject), MsgConstant.ALIAS_ENDPOINT);
      Log.c(a, "addAlias: " + locala.p());
    }
    while ((locala == null) || (!locala.p().equals(aB.a.d.a)));
    MessageSharedPrefs.getInstance(this.e).addAlias(paramString1, paramString2);
    return true;
  }

  public JSONObject getHeader()
  {
    return this.b;
  }

  public boolean removeAlias(String paramString1, String paramString2)
    throws aD.e, JSONException, Exception
  {
    if (TextUtils.isEmpty(paramString2))
      Log.b(a, "removeAlias: empty type");
    aB.a locala;
    do
    {
      do
        return false;
      while (!c());
      JSONObject localJSONObject = e();
      localJSONObject.put("alias", paramString1);
      localJSONObject.put("type", paramString2);
      localJSONObject.put("ts", System.currentTimeMillis());
      aE localaE = new aE(this.e);
      locala = localaE.a(localaE.a(localJSONObject), MsgConstant.DELETE_ALIAS_ENDPOINT);
      Log.c(a, "removeAlias: " + locala.p());
    }
    while ((locala == null) || (!locala.p().equals(aB.a.d.a)));
    MessageSharedPrefs.getInstance(this.e).removeAlias(paramString1, paramString2);
    return true;
  }

  public void sendCachedMsgLog(long paramLong)
  {
    if (!c())
      return;
    if (f)
    {
      Log.c(a, "sendCachedMsgLog already in queue, abort this request.");
      return;
    }
    Log.c(a, "sendCachedMsgLog start, set cacheLogSending flag");
    f = true;
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        try
        {
          ArrayList localArrayList;
          for (Object localObject2 = MsgLogStore.getInstance(UTrack.a(UTrack.this)).getMsgLogs(1); ((ArrayList)localObject2).size() > 0; localObject2 = localArrayList)
          {
            MsgLogStore.MsgLog localMsgLog = (MsgLogStore.MsgLog)((ArrayList)localObject2).get(0);
            UTrack.a(UTrack.this, localMsgLog.msgId, localMsgLog.actionType, localMsgLog.time);
            localArrayList = MsgLogStore.getInstance(UTrack.a(UTrack.this)).getMsgLogs(1);
          }
          return;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          return;
        }
        finally
        {
          Log.c(UTrack.a(), "sendCachedMsgLog finished, clear cacheLogSending flag");
          UTrack.a(false);
        }
      }
    };
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    Log.c(str, String.format("sendCachedMsgLog(delay=%d)", arrayOfObject));
    this.d.schedule(local2, paramLong, TimeUnit.MILLISECONDS);
  }

  public void trackAppLaunch(long paramLong)
  {
    if (!c())
      return;
    if (g)
    {
      Log.c(a, "trackAppLaunch already in queue, abort this request.");
      return;
    }
    Log.c(a, "trackAppLaunch start, set appLaunchSending flag");
    g = true;
    Runnable local3 = new Runnable()
    {
      public void run()
      {
        int i = -1;
        while (true)
        {
          try
          {
            JSONObject localJSONObject = UTrack.b(UTrack.this);
            aE localaE = new aE(UTrack.a(UTrack.this));
            aB.a locala = localaE.a(localaE.a(localJSONObject), MsgConstant.LAUNCH_ENDPOINT);
            if ((locala != null) && (locala.p().equals(aB.a.d.a)))
            {
              MessageSharedPrefs.getInstance(UTrack.a(UTrack.this)).setAppLaunchLogSentAt(System.currentTimeMillis());
              if ((!locala.t()) || (!locala.u().o()))
                break label265;
              j = locala.u().p();
              Log.c(UTrack.a(), "launch_policy:" + j);
              if ((locala.t()) && (locala.u().q()))
              {
                i = locala.u().r();
                Log.c(UTrack.a(), "tag_policy:" + i);
              }
              if (j > 0)
                MessageSharedPrefs.getInstance(UTrack.a(UTrack.this)).setAppLaunchLogSendPolicy(j);
              if (i > 0)
                MessageSharedPrefs.getInstance(UTrack.a(UTrack.this)).setTagSendPolicy(i);
            }
            return;
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            return;
          }
          finally
          {
            UTrack.b(false);
          }
          label265: int j = i;
        }
      }
    };
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Long.valueOf(paramLong);
    Log.c(str, String.format("trackAppLaunch(delay=%d)", arrayOfObject));
    this.d.schedule(local3, paramLong, TimeUnit.MILLISECONDS);
  }

  public void trackMsgClick(UMessage paramUMessage)
  {
    if ((paramUMessage == null) || (paramUMessage.msg_id == null))
      return;
    a(paramUMessage.msg_id, 1, 60000L * paramUMessage.random_min);
    ((UmengMessageHandler)PushAgent.getInstance(this.e).getMessageHandler()).setPrevMessage(null);
  }

  public void trackMsgDismissed(UMessage paramUMessage)
  {
    if ((paramUMessage == null) || (paramUMessage.msg_id == null))
      return;
    a(paramUMessage.msg_id, 2, 60000L * paramUMessage.random_min);
    ((UmengMessageHandler)PushAgent.getInstance(this.e).getMessageHandler()).setPrevMessage(null);
  }

  public void trackRegister()
  {
    if (!c())
      return;
    if (h)
    {
      Log.c(a, "sendRegisterLog already in queue, abort this request.");
      return;
    }
    Log.c(a, "trackRegisterLog start, set registerSending flag");
    h = true;
    Runnable local4 = new Runnable()
    {
      public void run()
      {
        try
        {
          JSONObject localJSONObject = UTrack.b(UTrack.this);
          String str = UTrack.c(UTrack.this);
          if (!ax.d(str))
          {
            Log.c(UTrack.a(), "TestDevice sign =" + str);
            localJSONObject.put("TD", str);
          }
          aE localaE = new aE(UTrack.a(UTrack.this));
          aB.a locala = localaE.a(localaE.a(localJSONObject), MsgConstant.REGISTER_ENDPOINT);
          if ((locala != null) && (locala.p().equals(aB.a.d.a)))
            UmengRegistrar.a(UTrack.a(UTrack.this), true);
          return;
        }
        catch (aD.e locale)
        {
          locale.printStackTrace();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        finally
        {
          UTrack.c(false);
        }
      }
    };
    String str = a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(0);
    Log.c(str, String.format("trackRegister(delay=%d)", arrayOfObject));
    this.d.schedule(local4, 0L, TimeUnit.MILLISECONDS);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.UTrack
 * JD-Core Version:    0.6.2
 */