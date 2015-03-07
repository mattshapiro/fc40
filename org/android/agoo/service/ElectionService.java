package org.android.agoo.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.by;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.client.AgooSettings;
import org.android.agoo.client.BaseRegistrar;
import org.android.agoo.net.mtop.MtopAsyncClientV3;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopResponseHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ElectionService extends Service
  implements Handler.Callback
{
  private static final String a = "ElectionService";
  private static final int e = 100;
  private static final int f = 101;
  private static final int g = 102;
  private static final int h = 103;
  private static Random s = new Random();
  private volatile Map<Long, List<String>> b = new ConcurrentHashMap();
  private volatile Map<String, String> c = new ConcurrentHashMap();
  private volatile Map<String, Long> d = new ConcurrentHashMap();
  private volatile String i = "local";
  private Handler j = null;
  private volatile List<String> k = null;
  private volatile long l = -1L;
  private volatile boolean m = false;
  private HandlerThread n = null;
  private AtomicInteger o = new AtomicInteger(0);
  private volatile long p = -1L;
  private volatile Context q;
  private final IElectionService.Stub r = new IElectionService.Stub()
  {
    public void election(String paramAnonymousString1, long paramAnonymousLong, String paramAnonymousString2)
      throws RemoteException
    {
      if (ElectionService.a(ElectionService.this))
        return;
      ElectionService.a(ElectionService.this, paramAnonymousString1, paramAnonymousLong);
    }
  };
  private ElectionResult t;

  private String a(List<String> paramList)
  {
    String str = null;
    if (paramList != null)
    {
      int i1 = paramList.size();
      int i2 = s.nextInt(10000);
      int i3 = i2 % i1;
      aJ.c("ElectionService", "random [" + i2 + "][" + i1 + "]");
      aJ.c("ElectionService", "random index[" + paramList.toString() + "][" + i3 + "]");
      str = (String)paramList.get(i3);
    }
    if (TextUtils.isEmpty(str))
      str = this.q.getPackageName();
    return str;
  }

  private void a()
  {
    String str1 = a((List)this.b.get(Long.valueOf(this.l)));
    Iterator localIterator = this.d.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      this.c.put(str2, str1);
    }
    a("local");
  }

  private void a(String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 102;
    this.i = paramString;
    this.j.sendMessage(localMessage);
    this.j.sendEmptyMessageDelayed(103, 600000L);
  }

  private void a(String paramString, long paramLong)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramLong > -1L))
      {
        this.d.put(paramString, Long.valueOf(paramLong));
        aJ.c("ElectionService", "addElection[pack:" + paramString + "][priority:" + paramLong + "]");
        if (paramLong > this.l)
          this.l = paramLong;
        this.k = ((List)this.b.get(Long.valueOf(paramLong)));
        if (this.k == null)
          this.k = new ArrayList();
        if (!this.k.contains(paramString))
          this.k.add(paramString);
        this.b.put(Long.valueOf(paramLong), this.k);
      }
      if (this.o.get() < 1)
      {
        this.o.incrementAndGet();
        Message localMessage = Message.obtain();
        localMessage.what = 100;
        this.j.removeMessages(103);
        this.j.sendMessageDelayed(localMessage, 10000L);
      }
      return;
    }
    finally
    {
    }
  }

  private void b()
  {
    String str1 = aI.n(this.q);
    String str2 = aI.o(this.q);
    if ((!BaseRegistrar.isRegistered(this.q)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      aJ.c("ElectionService", "remote registered==null");
      c();
      return;
    }
    MtopRequest localMtopRequest = new MtopRequest();
    localMtopRequest.setApi("mtop.push.channel.vote");
    localMtopRequest.setV("6.0");
    localMtopRequest.setTtId(aI.o(this.q));
    localMtopRequest.setDeviceId(BaseRegistrar.getRegistrationId(this.q));
    localMtopRequest.putParams("vote_factors", new JSONObject(this.d).toString());
    MtopAsyncClientV3 localMtopAsyncClientV3 = new MtopAsyncClientV3();
    localMtopAsyncClientV3.setDefaultAppkey(aI.n(this.q));
    localMtopAsyncClientV3.setDefaultAppSecret(aI.p(this.q));
    localMtopAsyncClientV3.setBaseUrl(AgooSettings.getPullUrl(this.q));
    localMtopAsyncClientV3.getV3(this.q, localMtopRequest, new MtopResponseHandler()
    {
      public void onFailure(String paramAnonymousString1, String paramAnonymousString2)
      {
        aJ.d("ElectionService", "errCode[" + paramAnonymousString1 + "]errDesc[" + paramAnonymousString2 + "]");
        ElectionService.b(ElectionService.this);
      }

      public void onSuccess(String paramAnonymousString)
      {
        if (TextUtils.isEmpty(paramAnonymousString))
        {
          aJ.c("ElectionService", "remote content==null");
          ElectionService.b(ElectionService.this);
          return;
        }
        aJ.c("ElectionService", "remote election result[" + paramAnonymousString + "] ");
        JSONArray localJSONArray1;
        try
        {
          JSONObject localJSONObject1 = new JSONObject(paramAnonymousString);
          ElectionService.a(ElectionService.this, Long.parseLong(localJSONObject1.getString("time_out")));
          localJSONArray1 = localJSONObject1.getJSONArray("vote_list");
          if (localJSONArray1 == null)
          {
            aJ.c("ElectionService", "remote vote_list==null");
            ElectionService.b(ElectionService.this);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          aJ.d("ElectionService", "remote--JSONException", localThrowable);
          ElectionService.b(ElectionService.this);
          return;
        }
        int i = localJSONArray1.length();
        if (i <= 0)
        {
          aJ.c("ElectionService", "remote vote_list.length==0");
          ElectionService.b(ElectionService.this);
          return;
        }
        while (true)
        {
          int j;
          String str1;
          JSONArray localJSONArray2;
          int k;
          if (j < i)
          {
            JSONObject localJSONObject2 = localJSONArray1.getJSONObject(j);
            if (localJSONObject2 == null)
            {
              ElectionService.b(ElectionService.this);
              return;
            }
            str1 = localJSONObject2.getString("package_name");
            if (TextUtils.isEmpty(str1))
            {
              aJ.c("ElectionService", "sudoPack==null");
              ElectionService.b(ElectionService.this);
              return;
            }
            if (ElectionService.c(ElectionService.this).get(str1) == null)
            {
              aJ.c("ElectionService", "elctionResults not found[" + str1 + "]");
              ElectionService.b(ElectionService.this);
              return;
            }
            localJSONArray2 = localJSONObject2.getJSONArray("package_name_list");
            if (localJSONArray2 == null)
            {
              aJ.c("ElectionService", "remote package_name_list==null");
              ElectionService.b(ElectionService.this);
              return;
            }
            k = localJSONArray2.length();
            if (k > 0)
              break label376;
            aJ.c("ElectionService", "remote package_name_list.length==0");
            ElectionService.b(ElectionService.this);
          }
          while (true)
          {
            if (m >= k)
              break label382;
            String str2 = localJSONArray2.getString(m);
            ElectionService.d(ElectionService.this).put(str2, str1);
            m++;
            continue;
            ElectionService.a(ElectionService.this, "remote");
            return;
            j = 0;
            break;
            label376: int m = 0;
          }
          label382: j++;
        }
      }
    });
  }

  private void c()
  {
    this.j.sendEmptyMessage(101);
  }

  private void d()
  {
    Iterator localIterator = this.c.entrySet().iterator();
    this.t = new ElectionResult();
    this.t.setTimeout(this.p);
    this.t.setElectionSource(this.i);
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str1 = (String)localEntry.getKey();
      String str2 = (String)localEntry.getValue();
      try
      {
        aJ.c("ElectionService", "finish[clientPack:" + str1 + "][sudo:" + str2 + "][electionSource:" + this.i + "]");
        this.t.putSudo(str1, str2);
      }
      catch (Throwable localThrowable)
      {
        aJ.d("ElectionService", "finish--Exception", localThrowable);
      }
    }
    this.c.clear();
    this.d.clear();
    this.b.clear();
  }

  private void e()
  {
    if (this.q != null)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("org.agoo.android.intent.action.RE_ELECTION_V2");
      localIntent.putExtra("election_result", this.t);
      localIntent.putExtra("election_type", "election_notice");
      localIntent.addFlags(32);
      this.q.sendBroadcast(localIntent);
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    try
    {
      switch (paramMessage.what)
      {
      case 100:
        this.o.set(0);
        this.m = true;
        b();
        return true;
      case 101:
      case 102:
      case 103:
      }
    }
    catch (Throwable localThrowable)
    {
      aJ.d("ElectionService", "destroy  exception", localThrowable);
      return true;
    }
    this.o.set(0);
    this.m = true;
    a();
    return true;
    this.o.set(0);
    d();
    e();
    this.m = false;
    return true;
    stopSelf();
    return true;
  }

  public IBinder onBind(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, "org.agoo.android.intent.action.ELECTION_V2")))
      return this.r;
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    this.q = this;
    aJ.a(this.q);
    aJ.c("ElectionService", "create");
    try
    {
      this.n = new HandlerThread("election_service");
      this.n.start();
      this.j = new Handler(this.n.getLooper(), this);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("ElectionService", "election_service_handlerthread", localThrowable);
    }
  }

  public void onDestroy()
  {
    try
    {
      aJ.c("ElectionService", "destroy");
      super.onDestroy();
      this.b.clear();
      this.o.set(0);
      this.l = -1L;
      this.m = false;
      by.a(this.q);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }

  public boolean onUnbind(Intent paramIntent)
  {
    return super.onUnbind(paramIntent);
  }

  public static class ElectionResult
    implements Parcelable
  {
    public static final Parcelable.Creator<ElectionResult> CREATOR = new Parcelable.Creator()
    {
      public ElectionService.ElectionResult createFromParcel(Parcel paramAnonymousParcel)
      {
        return new ElectionService.ElectionResult(paramAnonymousParcel, null);
      }

      public ElectionService.ElectionResult[] newArray(int paramAnonymousInt)
      {
        return null;
      }
    };
    private long a = -1L;
    private String b;
    private HashMap<String, String> c = new HashMap();

    public ElectionResult()
    {
    }

    private ElectionResult(Parcel paramParcel)
    {
      this.a = paramParcel.readLong();
      this.c = paramParcel.readHashMap(HashMap.class.getClassLoader());
      this.b = paramParcel.readString();
    }

    public int describeContents()
    {
      return 0;
    }

    public String getElectionSource()
    {
      return this.b;
    }

    public HashMap<String, String> getSudoMap()
    {
      return this.c;
    }

    public long getTimeout()
    {
      return this.a;
    }

    public void putSudo(String paramString1, String paramString2)
    {
      this.c.put(paramString1, paramString2);
    }

    public void setElectionSource(String paramString)
    {
      this.b = paramString;
    }

    public void setSudoMap(HashMap<String, String> paramHashMap)
    {
      this.c = paramHashMap;
    }

    public void setTimeout(long paramLong)
    {
      this.a = paramLong;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.a);
      paramParcel.writeMap(this.c);
      paramParcel.writeString(this.b);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.service.ElectionService
 * JD-Core Version:    0.6.2
 */