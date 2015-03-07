package org.android.agoo.client;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.text.TextUtils;
import com.umeng.message.proguard.aI;
import com.umeng.message.proguard.aJ;
import com.umeng.message.proguard.aN;
import com.umeng.message.proguard.aU;
import com.umeng.message.proguard.bp;
import com.umeng.message.proguard.br;
import com.umeng.message.proguard.bu;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.by;
import com.umeng.message.proguard.bz;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.android.agoo.helper.PhoneHelper;
import org.android.agoo.net.mtop.IMtopSynClient;
import org.android.agoo.net.mtop.MtopRequest;
import org.android.agoo.net.mtop.MtopSyncClientV3;
import org.android.agoo.net.mtop.Result;
import org.android.agoo.service.AgooService;
import org.android.agoo.service.ElectionService.ElectionResult;
import org.android.agoo.service.IElectionService;
import org.android.agoo.service.IElectionService.Stub;
import org.android.agoo.service.IMessageService;
import org.android.agoo.service.IMessageService.Stub;
import org.json.JSONObject;

public abstract class BaseIntentService extends IntentService
{
  private static final String a = "SERVICE_NOT_AVAILABLE";
  private static final String f = "report";
  private static final String g = "time";
  private static final String h = "BaseIntentService";
  private static final String i = "AGOO_LIB";
  private static volatile PowerManager.WakeLock j;
  private static final Object k = BaseIntentService.class;
  private static final Random l = new Random();
  private static final int m = 3600000;
  private volatile IMtopSynClient b = null;
  private volatile String c;
  private volatile String d;
  private volatile String e;
  private volatile IElectionService n = null;
  private ServiceConnection o = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      aJ.c("BaseIntentService", "electionConnection pack[" + paramAnonymousComponentName.getPackageName() + "]");
      try
      {
        Context localContext = BaseIntentService.this.getApplicationContext();
        BaseIntentService.a(BaseIntentService.this, IElectionService.Stub.asInterface(paramAnonymousIBinder));
        if (BaseIntentService.a(BaseIntentService.this) != null)
        {
          BaseIntentService.a(BaseIntentService.this).election(localContext.getPackageName(), AgooSettings.getAgooReleaseTime(), "token");
          BaseIntentService.a(BaseIntentService.this, localContext);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        aJ.d("BaseIntentService", "onServiceConnected", localThrowable);
      }
    }

    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      aJ.c("BaseIntentService", "electionDisconnected pack[" + paramAnonymousComponentName.getPackageName() + "]");
      BaseIntentService.a(BaseIntentService.this, null);
    }
  };
  private volatile boolean p = false;
  private volatile IMessageService q = null;
  private ServiceConnection r = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      aJ.c("BaseIntentService", "messageConnected pack[" + paramAnonymousComponentName.getPackageName() + "]");
      BaseIntentService.a(BaseIntentService.this, true);
      BaseIntentService.a(BaseIntentService.this, IMessageService.Stub.asInterface(paramAnonymousIBinder));
      Context localContext = BaseIntentService.this.getApplicationContext();
      BaseIntentService.b(BaseIntentService.this, localContext);
      BaseIntentService.c(BaseIntentService.this, localContext);
    }

    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      aJ.c("BaseIntentService", "messageDisconnected pack[" + paramAnonymousComponentName.getPackageName() + "]");
    }
  };

  protected BaseIntentService()
  {
    super("AgooDynamicSenderIds");
    a();
    setIntentRedelivery(false);
  }

  private void a()
  {
    this.b = new MtopSyncClientV3();
  }

  private void a(Context paramContext, Intent paramIntent)
  {
    if (!BaseRegistrar.isRegistered(paramContext))
    {
      aJ.c("BaseIntentService", "deviceToken is null--->[re-registration]");
      k(paramContext, paramIntent);
      return;
    }
    if (!aU.a(paramContext))
    {
      aJ.c("BaseIntentService", "connectManager[network connectedOrConnecting failed]");
      return;
    }
    MessageService.getSingleton(paramContext).reloadMessageAtTime();
    String str1 = paramContext.getPackageName();
    String str2 = aI.d(paramContext);
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (TextUtils.equals(str1, str2)))
    {
      a(paramContext, paramContext.getPackageName(), str2);
      return;
    }
    h(paramContext);
  }

  static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    try
    {
      synchronized (k)
      {
        if (j == null)
        {
          j = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(1, "AGOO_LIB");
          j.setReferenceCounted(false);
        }
        j.acquire(5000L);
        paramIntent.setClassName(paramContext, paramString);
        paramContext.startService(paramIntent);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      aJ.d("BaseIntentService", "runIntentInService--Throwable", localThrowable);
    }
  }

  private void a(Context paramContext, String paramString)
  {
    try
    {
      if ("SERVICE_NOT_AVAILABLE".equals(paramString))
      {
        if (onRecoverableError(paramContext, paramString))
        {
          int i1 = aI.k(paramContext);
          int i2 = i1 / 2 + l.nextInt(i1);
          aJ.c("BaseIntentService", "registration retry--->[nextAttempt:" + i2 + "|backoffTimeMs:" + i1 + "]");
          Intent localIntent = IntentHelper.createComandIntent(paramContext, "register_retry");
          localIntent.setPackage(paramContext.getPackageName());
          PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 0);
          ((AlarmManager)paramContext.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + i2, localPendingIntent);
          if (i1 < 3600000)
            aI.a(paramContext, i1 * 2);
        }
        else
        {
          aJ.c("BaseIntentService", "Not retrying failed operation");
        }
      }
      else
        onError(paramContext, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void a(final Context paramContext, final String paramString1, final String paramString2)
  {
    try
    {
      bz.a(new Runnable()
      {
        public void run()
        {
          if ((!TextUtils.isEmpty(paramString2)) && (TextUtils.equals(paramString2, paramString1)))
          {
            aJ.c("BaseIntentService", "restart---->[currentSudoPack:" + paramString2 + "]:[start]");
            if (BaseIntentService.b(BaseIntentService.this))
            {
              aJ.c("BaseIntentService", "enabledService---->[" + paramString1 + "/" + BaseIntentService.this.getAgooService() + "]");
              bx.b(paramContext, BaseIntentService.this.getAgooService());
            }
            by.a(paramContext, BaseIntentService.this.getAgooService());
            return;
          }
          aJ.c("BaseIntentService", "restart---->[currentSudoPack:" + paramString2 + "][currentPack:" + paramString1 + "]:[stop]");
          if (BaseIntentService.b(BaseIntentService.this))
          {
            aJ.c("BaseIntentService", "disableService---->[" + paramString1 + "/" + BaseIntentService.this.getAgooService() + "]");
            bx.a(paramContext, BaseIntentService.this.getAgooService());
          }
          by.b(paramContext, BaseIntentService.this.getAgooService());
        }
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    if (TextUtils.equals(paramString, "channel"))
      b(paramContext, paramString, paramArrayOfString);
  }

  private boolean a(Context paramContext)
  {
    String str1 = aI.n(paramContext);
    String str2 = aI.o(paramContext);
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
    String str3;
    do
    {
      return false;
      this.c = str1;
      this.d = str2;
      this.b.setDefaultAppkey(str1);
      str3 = aI.p(paramContext);
    }
    while ((TextUtils.isEmpty(str3)) && (!AgooSettings.isAgooSoSecurityMode(paramContext)));
    this.e = str3;
    this.b.setDefaultAppSecret(str3);
    this.b.setBaseUrl(AgooSettings.getPullUrl(paramContext));
    return true;
  }

  private void b(Context paramContext)
  {
    Intent localIntent = IntentHelper.createComandIntent(paramContext, "registration");
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.sendBroadcast(localIntent);
  }

  private void b(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("id");
    MessageService.getSingleton(paramContext).notice(str);
    onMessage(paramContext, paramIntent);
  }

  private final void b(Context paramContext, String paramString)
  {
    try
    {
      String str = new JSONObject(paramString).getString("device_id");
      if (TextUtils.isEmpty(str))
      {
        a(paramContext, "SERVICE_NOT_AVAILABLE");
        return;
      }
      aI.b(paramContext, str);
      aI.t(paramContext);
      b(paramContext);
      aN.g(paramContext);
      return;
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, "SERVICE_NOT_AVAILABLE");
      aN.h(paramContext, "data_parse_error");
    }
  }

  private void b(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (2 <= paramArrayOfString.length))
      try
      {
        if ((TextUtils.equals(paramArrayOfString[0], "multiplex")) && (!aI.w(paramContext)))
        {
          aI.a(paramContext, true, -1L);
          f(paramContext);
          return;
        }
        long l1 = Long.parseLong(paramArrayOfString[1]);
        if ((TextUtils.equals(paramArrayOfString[0], "single")) && (aI.w(paramContext)) && (l1 >= 300000L + System.currentTimeMillis()))
        {
          aI.a(paramContext, false, l1);
          if (b())
          {
            aJ.c("BaseIntentService", "enabledService---->[" + getAgooService() + "]");
            bx.b(paramContext, getAgooService());
          }
          by.a(paramContext, getAgooService());
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        aJ.d("BaseIntentService", "commandByChannel", localThrowable);
      }
  }

  private boolean b()
  {
    return (getAgooService() != null) && (TextUtils.equals(getAgooService().getSuperclass().getName(), AgooService.class.getName()));
  }

  private void c()
  {
    Context localContext = getApplicationContext();
    String str = aI.d(localContext);
    if (TextUtils.isEmpty(str))
    {
      aJ.c("BaseIntentService", "onPingMessage:[currentPack==null][retry election]");
      f(localContext);
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("org.agoo.android.intent.action.PING");
      localIntent.setPackage(str);
      localContext.bindService(localIntent, this.r, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("BaseIntentService", "onPingMessage", localThrowable);
    }
  }

  private void c(Context paramContext)
  {
    if ((BaseRegistrar.isRegistered(paramContext)) && (a(paramContext)))
    {
      String str = BaseRegistrar.getRegistrationId(paramContext);
      MtopRequest localMtopRequest = new MtopRequest();
      localMtopRequest.setApi("mtop.push.device.unregister");
      localMtopRequest.setV("4.0");
      localMtopRequest.setTtId(this.d);
      localMtopRequest.setDeviceId(str);
      localMtopRequest.putParams("app_version", bp.a(paramContext));
      localMtopRequest.putParams("sdk_version", Long.valueOf(AgooSettings.getAgooReleaseTime()));
      localMtopRequest.putParams("app_pack", paramContext.getPackageName());
      this.b.setBaseUrl(AgooSettings.getPullUrl(paramContext));
      Result localResult = this.b.getV3(paramContext, localMtopRequest);
      aJ.c("BaseIntentService", "unregister--->[server result:" + localResult.getData() + "]");
    }
  }

  private void c(Context paramContext, Intent paramIntent)
  {
    String[] arrayOfString1 = paramIntent.getStringExtra("x_command").split(";");
    int i1 = arrayOfString1.length;
    int i2 = 0;
    if (i2 < i1)
    {
      String str = arrayOfString1[i2];
      if (TextUtils.isEmpty(str));
      while (true)
      {
        i2++;
        break;
        String[] arrayOfString2 = str.split("=");
        if ((arrayOfString2 != null) && (arrayOfString2.length == 2) && (!TextUtils.isEmpty(arrayOfString2[0])) && (!TextUtils.isEmpty(arrayOfString2[1])))
        {
          String[] arrayOfString3 = arrayOfString2[1].split(",");
          if (arrayOfString3 != null)
            a(paramContext, arrayOfString2[0], arrayOfString3);
        }
      }
    }
  }

  private void c(Context paramContext, String paramString)
  {
    if ((BaseRegistrar.isRegistered(paramContext)) && (a(paramContext)))
    {
      String str = BaseRegistrar.getRegistrationId(paramContext);
      MtopRequest localMtopRequest = new MtopRequest();
      localMtopRequest.setApi("mtop.push.device.uninstall");
      localMtopRequest.setV("4.0");
      localMtopRequest.setTtId(this.d);
      localMtopRequest.setDeviceId(str);
      localMtopRequest.putParams("app_version", bp.a(paramContext));
      localMtopRequest.putParams("sdk_version", Long.valueOf(AgooSettings.getAgooReleaseTime()));
      localMtopRequest.putParams("app_pack", paramString);
      this.b.setBaseUrl(AgooSettings.getPullUrl(paramContext));
      Result localResult = this.b.getV3(paramContext, localMtopRequest);
      aJ.c("BaseIntentService", "uninstall--->[result:" + localResult.getData() + "]");
    }
  }

  private void d(Context paramContext)
  {
    MtopRequest localMtopRequest = new MtopRequest();
    localMtopRequest.setApi("mtop.push.device.createAndRegister");
    localMtopRequest.setV("4.0");
    localMtopRequest.setTtId(this.d);
    localMtopRequest.putParams("new_device", "true");
    localMtopRequest.putParams("device_global_id", aN.c(paramContext));
    localMtopRequest.putParams("c0", Build.BRAND);
    localMtopRequest.putParams("c1", Build.MODEL);
    localMtopRequest.putParams("c2", "umeng");
    localMtopRequest.putParams("c3", "umeng");
    localMtopRequest.putParams("c4", PhoneHelper.getLocalMacAddress(paramContext));
    localMtopRequest.putParams("c5", PhoneHelper.getSerialNum());
    localMtopRequest.putParams("c6", PhoneHelper.getAndroidId(paramContext));
    localMtopRequest.putParams("app_version", bp.a(paramContext));
    localMtopRequest.putParams("sdk_version", Long.valueOf(AgooSettings.getAgooReleaseTime()));
    localMtopRequest.putParams("package_name", paramContext.getPackageName());
    if (BaseRegistrar.isRegistered(paramContext))
      localMtopRequest.putParams("old_device_id", aI.q(paramContext));
    Result localResult = this.b.getV3(paramContext, localMtopRequest);
    if (localResult != null)
    {
      if (localResult.isSuccess())
      {
        aJ.c("BaseIntentService", "register--->[result:" + localResult.getData() + "]");
        b(paramContext, localResult.getData());
        return;
      }
      if (localResult.getHttpCode() == 302)
      {
        aJ.d("BaseIntentService", "doRegister---->[failed][" + localResult.getHttpCode() + "]");
        return;
      }
      String str = localResult.getRetCode();
      if (!TextUtils.isEmpty(str))
      {
        aJ.d("BaseIntentService", "doRegister---->[" + str + "]");
        aN.h(paramContext, str);
        if (str.indexOf("ERRCODE_AUTH_REJECT") != -1)
        {
          aI.s(paramContext);
          return;
        }
      }
    }
    a(paramContext, "SERVICE_NOT_AVAILABLE");
  }

  private void d(Context paramContext, Intent paramIntent)
  {
    h(paramContext);
    if (paramIntent.getBooleanExtra("x_command_type", false))
      c(paramContext, paramIntent);
    while (true)
    {
      return;
      if (!BaseRegistrar.isRegistered(paramContext))
      {
        aJ.c("BaseIntentService", "handleRemoteMessage[deviceToken==null]");
        return;
      }
      String str1 = paramIntent.getStringExtra("id");
      String str2 = paramIntent.getStringExtra("body");
      String str3 = paramIntent.getStringExtra("type");
      if (TextUtils.isEmpty(str2))
      {
        aJ.c("BaseIntentService", "handleMessage--->[null]");
        aN.e(paramContext, str1);
        return;
      }
      String str4;
      try
      {
        str4 = paramIntent.getStringExtra("encrypted");
        if (!TextUtils.equals("1", str4))
          break label181;
        str2 = bu.a(BaseRegistrar.getRegistrationId(paramContext), str2, 0);
        if (TextUtils.isEmpty(str2))
        {
          aN.b(paramContext, str1, str2);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        aJ.d("BaseIntentService", "encrypt--aesdecrypt[" + str2 + "]", localThrowable1);
        return;
      }
      paramIntent.putExtra("body", str2);
      label181: if (TextUtils.equals("2", str4))
      {
        str2 = bu.a(BaseRegistrar.getRegistrationId(paramContext), str2, 1);
        if (TextUtils.isEmpty(str2))
        {
          aN.b(paramContext, str1, str2);
          return;
        }
        paramIntent.putExtra("body", str2);
      }
      if (TextUtils.equals("3", str4))
      {
        str2 = bu.a(BaseRegistrar.getRegistrationId(paramContext), str2, 2);
        if (TextUtils.isEmpty(str2))
        {
          aN.b(paramContext, str1, str2);
          return;
        }
        paramIntent.putExtra("body", str2);
      }
      try
      {
        String str9 = paramIntent.getStringExtra("task_id");
        str5 = str9;
        try
        {
          String str7 = paramIntent.getStringExtra("message_source");
          String str8 = paramIntent.getStringExtra("report");
          if (MessageService.getSingleton(paramContext).report(str1, str5, str8, str7))
            paramIntent.removeExtra("report");
          label332: aJ.c("BaseIntentService", "handleMessage--->[" + str2 + "]");
          aN.b(paramContext, str1);
          int i1 = str2.hashCode();
          if (MessageService.getSingleton(paramContext).hasMessageDuplicate(str1, i1))
            continue;
          int i2 = -1;
          try
          {
            int i3 = Integer.parseInt(paramIntent.getStringExtra("notify"));
            i2 = i3;
            label407: String str6 = paramIntent.getStringExtra("time");
            if (!TextUtils.isEmpty(str6))
            {
              MessageService.getSingleton(paramContext).handleMessageAtTime(str1, str2, str3, str6, i2);
              return;
            }
            long l1 = AgooSettings.getTargetTime(paramContext);
            if (l1 != -1L)
            {
              MessageService.getSingleton(paramContext).handleMessageAtTime(str1, str2, str3, l1 + "_30", i2);
              return;
            }
            MessageService.getSingleton(paramContext).addMessage(str1, str2, str3, i2);
            onMessage(paramContext, paramIntent);
            return;
          }
          catch (Throwable localThrowable4)
          {
            break label407;
          }
        }
        catch (Throwable localThrowable3)
        {
          break label332;
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          String str5 = null;
      }
    }
  }

  private void e(Context paramContext)
  {
    aI.s(paramContext);
  }

  private void e(Context paramContext, Intent paramIntent)
  {
    if (!shouldProcessMessage(paramContext, paramIntent))
      return;
    if (aI.u(paramContext))
    {
      aJ.a("BaseIntentService", "handleMessage[" + paramContext.getPackageName() + "]--->[disable]");
      return;
    }
    if (paramIntent.getBooleanExtra("local", false))
    {
      b(paramContext, paramIntent);
      return;
    }
    d(paramContext, paramIntent);
  }

  private void f(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("org.agoo.android.intent.action.RE_ELECTION_V2");
    localIntent.setFlags(32);
    paramContext.sendBroadcast(localIntent);
  }

  private void f(Context paramContext, Intent paramIntent)
  {
    if (!a(paramContext))
    {
      aJ.c("BaseIntentService", "handleAddPackage---->[appkey or appSecret ===null]");
      return;
    }
    if (!BaseRegistrar.isRegistered(paramContext))
    {
      aJ.c("BaseIntentService", "handleAddPackage---->[devicetoken ===null]");
      return;
    }
    f(paramContext);
  }

  private void g(Context paramContext)
  {
    if (paramContext != null);
    try
    {
      paramContext.unbindService(this.o);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void g(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null));
    String str1;
    String str2;
    do
    {
      do
      {
        return;
        Uri localUri = paramIntent.getData();
        str1 = null;
        if (localUri != null)
          str1 = localUri.getSchemeSpecificPart();
      }
      while (TextUtils.isEmpty(str1));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.equals(str1, paramContext.getPackageName())))
        c(paramContext, str1);
      str2 = aI.d(paramContext);
    }
    while ((TextUtils.isEmpty(str2)) || (TextUtils.equals(str1, paramContext.getPackageName())) || (!TextUtils.equals(str1, str2)));
    i(paramContext, paramIntent);
  }

  private void h(Context paramContext)
  {
    if ((this.p) && (this.q != null));
    try
    {
      boolean bool = this.q.ping();
      if (!bool)
        f(paramContext);
      aJ.c("BaseIntentService", "pingMessage[ping:" + bool + "]");
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("BaseIntentService", "pingMessage", localThrowable);
    }
  }

  private final void h(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("command");
    aJ.c("BaseIntentService", "command --->[" + str + "]");
    if (str.equals("registration"))
    {
      onRegistered(paramContext, BaseRegistrar.getRegistrationId(paramContext));
      f(paramContext, paramIntent);
      return;
    }
    if (str.equals("unregister"))
    {
      m(paramContext, paramIntent);
      return;
    }
    if (str.equals("error"))
    {
      l(paramContext, paramIntent);
      return;
    }
    if (str.equals("register"))
    {
      j(paramContext, paramIntent);
      return;
    }
    if (str.equals("register_retry"))
    {
      k(paramContext, paramIntent);
      return;
    }
    onUserCommand(paramContext, paramIntent);
  }

  private void i(Context paramContext)
  {
    try
    {
      paramContext.unbindService(this.r);
      return;
    }
    catch (Throwable localThrowable)
    {
      aJ.d("BaseIntentService", "closeElection", localThrowable);
    }
  }

  private void i(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (!BaseRegistrar.isRegistered(paramContext))
      {
        aJ.c("BaseIntentService", "handleElection---->[devicetoken == null]");
        return;
      }
      if (aI.u(paramContext))
      {
        aJ.c("BaseIntentService", "handleElection--->[app:disable]");
        return;
      }
      if (!aI.w(paramContext))
      {
        aJ.c("BaseIntentService", "handleElection--->[channel:single]");
        return;
      }
      if (TextUtils.equals(paramIntent.getStringExtra("election_type"), "election_notice"))
      {
        ElectionService.ElectionResult localElectionResult = (ElectionService.ElectionResult)paramIntent.getParcelableExtra("election_result");
        HashMap localHashMap = localElectionResult.getSudoMap();
        long l1 = localElectionResult.getTimeout();
        String str1 = localElectionResult.getElectionSource();
        Iterator localIterator = localHashMap.entrySet().iterator();
        String str2 = paramContext.getPackageName();
        String str3;
        String str4;
        do
        {
          if (!localIterator.hasNext())
            break;
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          str3 = (String)localEntry.getKey();
          str4 = (String)localEntry.getValue();
        }
        while (!TextUtils.equals(str3, str2));
        aI.a(paramContext, str4, l1, str1);
        a(paramContext, str2, str4);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("org.agoo.android.intent.action.ELECTION_V2");
      paramContext.startService(localIntent);
      paramContext.bindService(localIntent, this.o, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void j(Context paramContext, Intent paramIntent)
  {
    if (!a(paramContext))
    {
      aJ.a("BaseIntentService", "handleRegister[" + paramContext.getPackageName() + "]--->[appkey==null,appSecret==nullttid,ttid==null]");
      e(paramContext);
      return;
    }
    if (!BaseRegistrar.isRegistered(paramContext))
    {
      aJ.a("BaseIntentService", "handleRegister[" + paramContext.getPackageName() + "]--->[deviceToken==null]");
      aI.t(paramContext);
      br.a(paramContext);
      d(paramContext);
      return;
    }
    if (aI.b(paramContext, true))
    {
      aJ.a("BaseIntentService", "handleRegister[" + paramContext.getPackageName() + "]--->[disable]");
      return;
    }
    bx.a(paramContext);
    c();
  }

  private void k(Context paramContext, Intent paramIntent)
  {
    if (BaseRegistrar.isRegistered(paramContext))
      return;
    BaseRegistrar.b(paramContext);
  }

  private void l(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("error");
    if (TextUtils.equals(str, "ERROR_NEED_ELECTION"))
    {
      f(paramContext);
      return;
    }
    if (TextUtils.equals(str, "ERRCODE_AUTH_REJECT"))
    {
      e(paramContext);
      f(paramContext);
      return;
    }
    if ("ERROR_DEVICETOKEN_NULL".equals(str))
    {
      aN.g(paramContext, "ERROR_DEVICETOKEN_NULL");
      BaseRegistrar.b(paramContext);
      return;
    }
    if ("ERROR_NEED_REGISTER".equals(str))
      aN.g(paramContext, "ERROR_NEED_REGISTER");
    if (("ERROR_APPKEY_NULL".equals(str)) || ("ERROR_APPSECRET_NULL".equals(str)) || ("ERROR_TTID_NULL".equals(str)))
    {
      aN.g(paramContext, "APPKEY_OR_SECRET_IS_NULL");
      onError(paramContext, str);
      return;
    }
    onError(paramContext, str);
  }

  private void m(Context paramContext, Intent paramIntent)
  {
    String str1 = paramContext.getPackageName();
    String str2 = aI.d(paramContext);
    if ((TextUtils.isEmpty(str2)) || (TextUtils.equals(str1, str2)))
    {
      aJ.c("BaseIntentService", "handleUnRegister---->[currentPack:" + str1 + "][currentSudoPack:" + str2 + "]:[retryElection]");
      if (b())
      {
        aJ.c("BaseIntentService", "disableService---->[" + getAgooService() + "]");
        bx.a(paramContext, getAgooService());
      }
      by.b(paramContext, getAgooService());
      f(paramContext);
    }
    c(paramContext);
    String str3 = aI.q(paramContext);
    aI.j(paramContext);
    aI.a(paramContext, true);
    onUnregistered(paramContext, str3);
  }

  protected Class<?> getAgooService()
  {
    return null;
  }

  protected void onDeletedMessages(Context paramContext, int paramInt)
  {
  }

  protected abstract void onError(Context paramContext, String paramString);

  // ERROR //
  public final void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 424	org/android/agoo/client/BaseIntentService:getApplicationContext	()Landroid/content/Context;
    //   4: astore 10
    //   6: aload_1
    //   7: invokevirtual 882	android/content/Intent:getAction	()Ljava/lang/String;
    //   10: astore 11
    //   12: aload 10
    //   14: invokestatic 885	org/android/agoo/client/IntentHelper:getAgooCommand	(Landroid/content/Context;)Ljava/lang/String;
    //   17: astore 12
    //   19: ldc_w 887
    //   22: aload 11
    //   24: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   27: ifne +8 -> 35
    //   30: aload 10
    //   32: invokestatic 888	com/umeng/message/proguard/aJ:a	(Landroid/content/Context;)V
    //   35: aload 11
    //   37: aload 12
    //   39: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   42: ifeq +34 -> 76
    //   45: aload_0
    //   46: aload 10
    //   48: aload_1
    //   49: invokespecial 890	org/android/agoo/client/BaseIntentService:h	(Landroid/content/Context;Landroid/content/Intent;)V
    //   52: getstatic 47	org/android/agoo/client/BaseIntentService:k	Ljava/lang/Object;
    //   55: astore 14
    //   57: aload 14
    //   59: monitorenter
    //   60: getstatic 154	org/android/agoo/client/BaseIntentService:j	Landroid/os/PowerManager$WakeLock;
    //   63: ifnull +9 -> 72
    //   66: getstatic 154	org/android/agoo/client/BaseIntentService:j	Landroid/os/PowerManager$WakeLock;
    //   69: invokevirtual 893	android/os/PowerManager$WakeLock:release	()V
    //   72: aload 14
    //   74: monitorexit
    //   75: return
    //   76: ldc_w 887
    //   79: aload 11
    //   81: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   84: ifeq +70 -> 154
    //   87: aload_0
    //   88: aload 10
    //   90: aload_1
    //   91: invokespecial 895	org/android/agoo/client/BaseIntentService:g	(Landroid/content/Context;Landroid/content/Intent;)V
    //   94: goto -42 -> 52
    //   97: astore 6
    //   99: ldc 17
    //   101: ldc_w 896
    //   104: aload 6
    //   106: invokestatic 192	com/umeng/message/proguard/aJ:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: getstatic 47	org/android/agoo/client/BaseIntentService:k	Ljava/lang/Object;
    //   112: astore 8
    //   114: aload 8
    //   116: monitorenter
    //   117: getstatic 154	org/android/agoo/client/BaseIntentService:j	Landroid/os/PowerManager$WakeLock;
    //   120: ifnull +9 -> 129
    //   123: getstatic 154	org/android/agoo/client/BaseIntentService:j	Landroid/os/PowerManager$WakeLock;
    //   126: invokevirtual 893	android/os/PowerManager$WakeLock:release	()V
    //   129: aload 8
    //   131: monitorexit
    //   132: return
    //   133: astore 9
    //   135: aload 8
    //   137: monitorexit
    //   138: aload 9
    //   140: athrow
    //   141: astore 7
    //   143: ldc 17
    //   145: ldc_w 898
    //   148: aload 7
    //   150: invokestatic 192	com/umeng/message/proguard/aJ:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: return
    //   154: aload 11
    //   156: ldc_w 900
    //   159: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   162: ifeq +39 -> 201
    //   165: aload_0
    //   166: aload 10
    //   168: aload_1
    //   169: invokespecial 902	org/android/agoo/client/BaseIntentService:e	(Landroid/content/Context;Landroid/content/Intent;)V
    //   172: goto -120 -> 52
    //   175: astore_2
    //   176: getstatic 47	org/android/agoo/client/BaseIntentService:k	Ljava/lang/Object;
    //   179: astore 4
    //   181: aload 4
    //   183: monitorenter
    //   184: getstatic 154	org/android/agoo/client/BaseIntentService:j	Landroid/os/PowerManager$WakeLock;
    //   187: ifnull +9 -> 196
    //   190: getstatic 154	org/android/agoo/client/BaseIntentService:j	Landroid/os/PowerManager$WakeLock;
    //   193: invokevirtual 893	android/os/PowerManager$WakeLock:release	()V
    //   196: aload 4
    //   198: monitorexit
    //   199: aload_2
    //   200: athrow
    //   201: aload 11
    //   203: ldc_w 696
    //   206: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   209: ifeq +13 -> 222
    //   212: aload_0
    //   213: aload 10
    //   215: aload_1
    //   216: invokespecial 720	org/android/agoo/client/BaseIntentService:i	(Landroid/content/Context;Landroid/content/Intent;)V
    //   219: goto -167 -> 52
    //   222: aload 11
    //   224: ldc_w 904
    //   227: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   230: ifne +47 -> 277
    //   233: aload 11
    //   235: ldc_w 906
    //   238: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   241: ifne +36 -> 277
    //   244: aload 11
    //   246: ldc_w 908
    //   249: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   252: ifne +25 -> 277
    //   255: aload 11
    //   257: ldc_w 910
    //   260: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   263: ifne +14 -> 277
    //   266: aload 11
    //   268: ldc_w 912
    //   271: invokestatic 143	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   274: ifeq +13 -> 287
    //   277: aload_0
    //   278: aload 10
    //   280: aload_1
    //   281: invokespecial 914	org/android/agoo/client/BaseIntentService:a	(Landroid/content/Context;Landroid/content/Intent;)V
    //   284: goto -232 -> 52
    //   287: aload_0
    //   288: aload 10
    //   290: aload_1
    //   291: invokevirtual 917	org/android/agoo/client/BaseIntentService:onUserHandleIntent	(Landroid/content/Context;Landroid/content/Intent;)V
    //   294: goto -242 -> 52
    //   297: astore 15
    //   299: aload 14
    //   301: monitorexit
    //   302: aload 15
    //   304: athrow
    //   305: astore 13
    //   307: ldc 17
    //   309: ldc_w 898
    //   312: aload 13
    //   314: invokestatic 192	com/umeng/message/proguard/aJ:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   317: return
    //   318: astore 5
    //   320: aload 4
    //   322: monitorexit
    //   323: aload 5
    //   325: athrow
    //   326: astore_3
    //   327: ldc 17
    //   329: ldc_w 898
    //   332: aload_3
    //   333: invokestatic 192	com/umeng/message/proguard/aJ:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   336: goto -137 -> 199
    //
    // Exception table:
    //   from	to	target	type
    //   0	35	97	java/lang/Throwable
    //   35	52	97	java/lang/Throwable
    //   76	94	97	java/lang/Throwable
    //   154	172	97	java/lang/Throwable
    //   201	219	97	java/lang/Throwable
    //   222	277	97	java/lang/Throwable
    //   277	284	97	java/lang/Throwable
    //   287	294	97	java/lang/Throwable
    //   117	129	133	finally
    //   129	132	133	finally
    //   135	138	133	finally
    //   109	117	141	java/lang/Throwable
    //   138	141	141	java/lang/Throwable
    //   0	35	175	finally
    //   35	52	175	finally
    //   76	94	175	finally
    //   99	109	175	finally
    //   154	172	175	finally
    //   201	219	175	finally
    //   222	277	175	finally
    //   277	284	175	finally
    //   287	294	175	finally
    //   60	72	297	finally
    //   72	75	297	finally
    //   299	302	297	finally
    //   52	60	305	java/lang/Throwable
    //   302	305	305	java/lang/Throwable
    //   184	196	318	finally
    //   196	199	318	finally
    //   320	323	318	finally
    //   176	184	326	java/lang/Throwable
    //   323	326	326	java/lang/Throwable
  }

  protected abstract void onMessage(Context paramContext, Intent paramIntent);

  protected boolean onRecoverableError(Context paramContext, String paramString)
  {
    return true;
  }

  protected abstract void onRegistered(Context paramContext, String paramString);

  protected abstract void onUnregistered(Context paramContext, String paramString);

  protected void onUserCommand(Context paramContext, Intent paramIntent)
  {
  }

  protected void onUserHandleIntent(Context paramContext, Intent paramIntent)
  {
  }

  protected boolean shouldProcessMessage(Context paramContext, Intent paramIntent)
  {
    return true;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.client.BaseIntentService
 * JD-Core Version:    0.6.2
 */