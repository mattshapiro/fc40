package com.umeng.message.tag;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.common.message.DeviceConfig;
import com.umeng.common.message.Log;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.UmengRegistrar;
import com.umeng.message.proguard.aB.a;
import com.umeng.message.proguard.aB.a.b;
import com.umeng.message.proguard.aB.a.d;
import com.umeng.message.proguard.aD;
import com.umeng.message.proguard.aE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TagManager
{
  private static final String a = TagManager.class.getName();
  private static final String b = "ok";
  private static final String c = "fail";
  private static TagManager d;
  private Context e;

  private TagManager(Context paramContext)
  {
    this.e = paramContext.getApplicationContext();
  }

  private static String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localStringBuilder.append((String)localIterator.next()).append(",");
    if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(-1 + localStringBuilder.length()) == ','))
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private static String a(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
      localStringBuilder.append(paramArrayOfString[j]).append(",");
    if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(-1 + localStringBuilder.length()) == ','))
      localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private JSONObject a()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("header", UTrack.getInstance(this.e).getHeader());
    localJSONObject.put("utdid", DeviceConfig.getUtdid(this.e));
    localJSONObject.put("device_token", UmengRegistrar.getRegistrationId(this.e));
    localJSONObject.put("ts", System.currentTimeMillis());
    return localJSONObject;
  }

  private static JSONObject a(JSONObject paramJSONObject, String paramString)
    throws JSONException
  {
    String str = aD.c(paramString).H().r("application/json").i(paramJSONObject.toString()).b("UTF-8");
    Log.c(a, "postJson() url=" + paramString + "\n request = " + paramJSONObject + "\n response = " + str);
    return new JSONObject(str);
  }

  private boolean b()
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

  private boolean c()
  {
    int i = 1;
    if (MessageSharedPrefs.getInstance(this.e).getTagSendPolicy() == i);
    while (true)
    {
      if (i != 0)
        Log.c(a, "tag is disabled by the server");
      return i;
      int j = 0;
    }
  }

  private Result d()
  {
    Result localResult = new Result(new JSONObject());
    localResult.remain = MessageSharedPrefs.getInstance(this.e).getTagRemain();
    localResult.status = "ok";
    localResult.jsonString = ("status:" + localResult.status + "," + " remain:" + localResult.remain + "," + "description:" + localResult.status);
    return localResult;
  }

  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (d == null)
        d = new TagManager(paramContext.getApplicationContext());
      TagManager localTagManager = d;
      return localTagManager;
    }
    finally
    {
    }
  }

  public Result add(String[] paramArrayOfString)
    throws Exception
  {
    if (c())
      throw new Exception("Tag API is disabled by the server.");
    if (!b())
      throw new Exception("No utdid or device_token");
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      throw new Exception("No tags");
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString[j];
      if ((!MessageSharedPrefs.getInstance(this.e).isTagSet(str)) && (!localArrayList.contains(str)))
        localArrayList.add(str);
    }
    Result localResult;
    if (localArrayList.size() == 0)
      localResult = d();
    aB.a locala;
    do
    {
      return localResult;
      JSONObject localJSONObject = a();
      localJSONObject.put("tags", a(localArrayList));
      aE localaE = new aE(this.e);
      locala = localaE.a(localaE.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/add");
      localResult = new Result(locala);
    }
    while ((locala == null) || (!locala.p().equals(aB.a.d.a)));
    MessageSharedPrefs.getInstance(this.e).addTags(paramArrayOfString);
    MessageSharedPrefs.getInstance(this.e).setTagRemain(localResult.remain);
    return localResult;
  }

  public Result delete(String[] paramArrayOfString)
    throws Exception
  {
    if (c())
      throw new Exception("Tag API is disabled by the server.");
    if (!b())
      throw new Exception("No utdid or device_token");
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      throw new Exception("No tags");
    JSONObject localJSONObject = a();
    localJSONObject.put("tags", a(paramArrayOfString));
    aE localaE = new aE(this.e);
    aB.a locala = localaE.a(localaE.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/delete");
    Result localResult = new Result(locala);
    if ((locala != null) && (locala.p().equals(aB.a.d.a)))
    {
      MessageSharedPrefs.getInstance(this.e).removeTags(paramArrayOfString);
      MessageSharedPrefs.getInstance(this.e).setTagRemain(localResult.remain);
    }
    return localResult;
  }

  public List<String> list()
    throws Exception
  {
    if (c())
      throw new Exception("Tag API is disabled by the server.");
    if (!b())
      throw new Exception("No utdid or device_token");
    JSONObject localJSONObject = a();
    aE localaE = new aE(this.e);
    aB.a locala = localaE.a(localaE.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/get");
    if ((locala != null) && (locala.p().equals(aB.a.d.a)) && (locala.t()) && (locala.u().x()))
    {
      Log.c(a, locala.u().y());
      return Arrays.asList(locala.u().y().split(","));
    }
    return null;
  }

  public Result reset()
    throws Exception
  {
    if (c())
      throw new Exception("Tag API is disabled by the server.");
    if (!b())
      throw new Exception("No utdid or device_token");
    JSONObject localJSONObject = a();
    aE localaE = new aE(this.e);
    aB.a locala = localaE.a(localaE.a(localJSONObject), MsgConstant.TAG_ENDPOINT + "/reset");
    Result localResult = new Result(locala);
    if ((locala != null) && (locala.p().equals(aB.a.d.a)))
      MessageSharedPrefs.getInstance(this.e).resetTags();
    return localResult;
  }

  public static class Result
  {
    public String errors;
    public String jsonString;
    public int remain;
    public String status;

    public Result(aB.a parama)
    {
      if (parama.p().equals(aB.a.d.a))
        this.status = "success";
      while (true)
      {
        this.remain = parama.u().w();
        this.errors = parama.r();
        this.jsonString = ("status:" + this.status + "," + " remain:" + this.remain + "," + "description:" + this.errors);
        return;
        if (parama.p().equals(aB.a.d.b))
          this.status = "invalid_request";
        else if (parama.p().equals(aB.a.d.c))
          this.status = "server_exception";
      }
    }

    public Result(JSONObject paramJSONObject)
    {
      this.status = paramJSONObject.optString("success", "fail");
      this.remain = paramJSONObject.optInt("remain", 0);
      this.errors = paramJSONObject.optString("errors");
      this.jsonString = paramJSONObject.toString();
    }

    public String toString()
    {
      return this.jsonString;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.tag.TagManager
 * JD-Core Version:    0.6.2
 */