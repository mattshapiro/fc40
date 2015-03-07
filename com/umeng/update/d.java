package com.umeng.update;

import android.content.Context;
import com.umeng.update.util.DeltaUpdate;
import org.json.JSONObject;
import u.upd.a;
import u.upd.b;
import u.upd.h;
import u.upd.n;

public class d extends h
{
  private final String d = d.class.getName();
  private final String e = "update";
  private JSONObject f = a(paramContext);

  public d(Context paramContext)
  {
    super(null);
  }

  private JSONObject a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "update");
      localJSONObject.put("appkey", UpdateConfig.getAppkey(paramContext));
      localJSONObject.put("version_code", a.c(paramContext));
      localJSONObject.put("package", a.u(paramContext));
      localJSONObject.put("idmd5", n.b(a.f(paramContext)));
      localJSONObject.put("channel", UpdateConfig.getChannel(paramContext));
      localJSONObject.put("proto_ver", "1.4");
      localJSONObject.put("sdk_version", "2.4.2.20140520");
      localJSONObject.put("old_md5", DeltaUpdate.b(paramContext));
      if ((DeltaUpdate.a()) && (UpdateConfig.isDeltaUpdate()));
      for (boolean bool = true; ; bool = false)
      {
        localJSONObject.put("delta", bool);
        return localJSONObject;
      }
    }
    catch (Exception localException)
    {
      b.b(this.d, "exception in updateInternal", localException);
    }
    return null;
  }

  public JSONObject a()
  {
    return this.f;
  }

  public String b()
  {
    return this.c;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.d
 * JD-Core Version:    0.6.2
 */