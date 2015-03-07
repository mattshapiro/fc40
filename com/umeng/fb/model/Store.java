package com.umeng.fb.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.fb.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Store
{
  private static final String a = Store.class.getName();
  private static Store b;
  private static final String d = "umeng_feedback_conversations";
  private static final String e = "umeng_feedback_user_info";
  private static final String f = "user";
  private static final String g = "uid";
  private static final String h = "device_uuid";
  private static final String i = "conversation_format_version";
  private static final String j = "last_update_at";
  private static final String k = "last_sync_at";
  private Context c;
  private SharedPreferences l;
  private SharedPreferences m;
  private Map<String, Conversation> n = new HashMap();

  private Store(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.l = this.c.getSharedPreferences("umeng_feedback_conversations", 0);
    this.m = this.c.getSharedPreferences("umeng_feedback_user_info", 0);
  }

  public static Store getInstance(Context paramContext)
  {
    if (b == null)
      b = new Store(paramContext);
    return b;
  }

  void a()
  {
    this.l.edit().clear().apply();
    this.m.edit().clear().apply();
  }

  public List<String> getAllConversationIds()
  {
    Map localMap = this.l.getAll();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
      localArrayList.add((String)localIterator.next());
    Collections.sort(localArrayList);
    return localArrayList;
  }

  public Conversation getConversationById(String paramString)
  {
    if (!this.n.containsKey(paramString));
    try
    {
      String str = this.l.getString(paramString, "");
      Conversation localConversation = Conversation.a(this.c, new JSONArray(str), paramString);
      this.n.put(paramString, localConversation);
      return (Conversation)this.n.get(paramString);
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  public String getDeviceUUID()
  {
    String str = this.m.getString("device_uuid", "");
    if (TextUtils.isEmpty(str))
    {
      str = UUID.randomUUID().toString();
      this.m.edit().putString("device_uuid", str).apply();
    }
    return str;
  }

  public String getUid()
  {
    return this.m.getString("uid", "");
  }

  public UserInfo getUserInfo()
  {
    String str = this.m.getString("user", "");
    if ("".equals(str))
      return new UserInfo();
    try
    {
      UserInfo localUserInfo = new UserInfo(new JSONObject(str));
      return localUserInfo;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return new UserInfo();
  }

  public long getUserInfoLastSyncAt()
  {
    return this.m.getLong("last_sync_at", 0L);
  }

  public long getUserInfoLastUpdateAt()
  {
    return this.m.getLong("last_update_at", 0L);
  }

  public boolean isMigrated()
  {
    int i1 = this.m.getInt("conversation_format_version", 0);
    boolean bool = false;
    if (i1 >= 5)
      bool = true;
    return bool;
  }

  public void migrateData()
  {
    while (true)
    {
      String str1;
      String str2;
      Conversation localConversation;
      try
      {
        Map localMap = this.l.getAll();
        Iterator localIterator = localMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          str2 = (String)localMap.get(str1);
          localConversation = Conversation.newInstance(this.c, str1);
          JSONArray localJSONArray = new JSONArray(str2);
          int i1 = 0;
          if (i1 >= localJSONArray.length())
            break label243;
          JSONObject localJSONObject = localJSONArray.getJSONObject(i1);
          try
          {
            String str3 = localJSONObject.optString("content");
            String str4 = localJSONObject.optString("reply_id");
            String str5 = localJSONObject.optString("status");
            new Date();
            Date localDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(localJSONObject.optString("datetime"));
            Reply localReply = new Reply(str3, str4, localJSONObject.optString("type"), localDate.getTime());
            localReply.status = str5;
            localConversation.addReply(localReply);
            i1++;
          }
          catch (ParseException localParseException)
          {
            localParseException.printStackTrace();
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        this.m.edit().putInt("conversation_format_version", 5).apply();
        return;
      }
      label243: Log.c(a, "migrate data: id=" + str1 + "\n ");
      Log.c(a, "old: \n" + str2 + "\n");
      Log.c(a, "new :\n" + localConversation.toString());
    }
  }

  public void removeConversation(String paramString)
  {
    this.l.edit().remove(paramString).apply();
    this.n.remove(paramString);
  }

  public void saveConversation(String paramString, Conversation paramConversation)
  {
    this.l.edit().putString(paramString, paramConversation.toJson().toString()).apply();
    this.n.put(paramString, paramConversation);
  }

  public void saveUserInfo(UserInfo paramUserInfo)
  {
    this.m.edit().putString("user", paramUserInfo.toJson().toString()).putLong("last_update_at", System.currentTimeMillis()).apply();
  }

  public void setUid(String paramString)
  {
    this.m.edit().putString("uid", paramString).apply();
  }

  public void setUserInfoLastSyncAt(long paramLong)
  {
    this.m.edit().putLong("last_sync_at", paramLong).apply();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.model.Store
 * JD-Core Version:    0.6.2
 */