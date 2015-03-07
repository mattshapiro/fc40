package com.umeng.fb.model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import com.umeng.fb.SyncListener;
import com.umeng.fb.net.a;
import com.umeng.fb.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;

public class Conversation
{
  private static final String a = Conversation.class.getName();
  private List<Reply> b = new ArrayList();
  private Context c;
  private String d;
  private boolean e = false;
  private OnChangeListener f;

  private Conversation(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }

  protected static Conversation a(Context paramContext, JSONArray paramJSONArray, String paramString)
    throws JSONException
  {
    Conversation localConversation = new Conversation(paramContext);
    for (int i = 0; i < paramJSONArray.length(); i++)
    {
      Reply localReply = Reply.fromJson(paramJSONArray.getJSONObject(i));
      localConversation.b.add(localReply);
      if ("new_feedback".equals(localReply.type))
        localConversation.e = true;
    }
    localConversation.d = paramString;
    Collections.sort(localConversation.b);
    Log.c(a, "fromJson: json = " + paramJSONArray.toString() + "\n" + "fromJson: conversation = " + localConversation.toString());
    return localConversation;
  }

  private boolean a(Reply paramReply)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      Reply localReply = (Reply)localIterator.next();
      if ((!TextUtils.isEmpty(localReply.reply_id)) && ("dev_reply".equals(localReply.type)) && ((localReply.reply_id.equals(paramReply.reply_id)) || (localReply.reply_id.equals("RP" + paramReply.created_at + "1111"))))
        return true;
    }
    return false;
  }

  private void b()
  {
    Log.c(a, "onChange: " + toString());
    Store.getInstance(this.c).saveConversation(this.d, this);
    if (this.f != null)
      this.f.onChange();
  }

  private static String c()
  {
    return "R" + UUID.randomUUID().toString();
  }

  private static String d()
  {
    return "C" + UUID.randomUUID().toString();
  }

  public static Conversation newInstance(Context paramContext)
  {
    return newInstance(paramContext, d());
  }

  public static Conversation newInstance(Context paramContext, String paramString)
  {
    Conversation localConversation = new Conversation(paramContext);
    localConversation.b = new ArrayList();
    localConversation.d = paramString;
    Store.getInstance(paramContext).saveConversation(localConversation.d, localConversation);
    return localConversation;
  }

  public void addReply(Reply paramReply)
  {
    this.b.add(paramReply);
    b();
  }

  public void addUserReply(String paramString)
  {
    addUserReply(paramString, c(), "text_reply", -1.0F);
  }

  public void addUserReply(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    Reply localReply;
    if ((this.e) || (this.b.size() > 0))
      localReply = new Reply(paramString1, paramString2, "user_reply", new Date().getTime(), paramString3, paramFloat);
    while (true)
    {
      localReply.status = "will_sent";
      addReply(localReply);
      return;
      localReply = new Reply(paramString1, paramString2, "new_feedback", new Date().getTime(), paramString3, paramFloat);
      this.e = true;
    }
  }

  public String getId()
  {
    return this.d;
  }

  public List<Reply> getReplyList()
  {
    return this.b;
  }

  public void sendReplyOnlyOne(final String paramString, final Reply paramReply)
  {
    Runnable local2 = new Runnable()
    {
      public void run()
      {
        paramReply.status = "sending";
        this.b.post(new Runnable()
        {
          public void run()
          {
            Conversation.a(Conversation.this);
          }
        });
        if ("user_reply".equals(paramReply.type));
        for (final Map localMap = new a(Conversation.c(Conversation.this)).a(paramString, paramReply); (localMap != null) && (localMap.size() == 2); localMap = new a(Conversation.c(Conversation.this)).b(paramString, paramReply))
        {
          this.b.post(new Runnable()
          {
            public void run()
            {
              Conversation.2.this.a.created_at = ((Long)localMap.get("created_at")).longValue();
              Conversation.2.this.a.status = "sent";
              Collections.sort(Conversation.d(Conversation.this));
              Conversation.a(Conversation.this);
            }
          });
          return;
        }
        this.b.post(new Runnable()
        {
          public void run()
          {
            Conversation.2.this.a.status = "not_sent";
            Conversation.a(Conversation.this);
          }
        });
      }
    };
    String str = Store.getInstance(this.c).getUid();
    if ((str == null) || ("".equals(str)))
    {
      new GetUidTask(local2).execute(new Void[0]);
      return;
    }
    new Thread(local2).start();
  }

  public void setOnChangeListener(OnChangeListener paramOnChangeListener)
  {
    this.f = paramOnChangeListener;
  }

  public void sync(final SyncListener paramSyncListener)
  {
    if (getReplyList().size() == 0)
      return;
    Log.c(a, "sync id=" + this.d + ":\t " + this);
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        final ArrayList localArrayList1 = new ArrayList();
        final ArrayList localArrayList2 = new ArrayList();
        long l = 0L;
        int i = 0;
        if (i < Conversation.this.getReplyList().size())
        {
          final Reply localReply2 = (Reply)Conversation.this.getReplyList().get(i);
          final Map localMap;
          if (("user_reply".equals(localReply2.type)) || ("new_feedback".equals(localReply2.type)))
            if (("not_sent".equals(localReply2.status)) || ("will_sent".equals(localReply2.status)))
            {
              localReply2.status = "sending";
              localArrayList1.add(localReply2);
              this.a.post(new Runnable()
              {
                public void run()
                {
                  Conversation.a(Conversation.this);
                }
              });
              if (!"new_feedback".equals(localReply2.type))
                break label250;
              localMap = new a(Conversation.c(Conversation.this)).b(Conversation.b(Conversation.this), localReply2);
              label182: Log.c(Conversation.a(), "result - " + localMap);
              if ((localMap == null) || (localMap.size() != 2))
                break label281;
              this.a.post(new Runnable()
              {
                public void run()
                {
                  localReply2.created_at = ((Long)localMap.get("created_at")).longValue();
                  localReply2.status = "sent";
                  Conversation.a(Conversation.this);
                }
              });
            }
          while (true)
          {
            i++;
            break;
            label250: localMap = new a(Conversation.c(Conversation.this)).a(Conversation.b(Conversation.this), localReply2);
            break label182;
            label281: this.a.post(new Runnable()
            {
              public void run()
              {
                localReply2.status = "not_sent";
                Conversation.a(Conversation.this);
              }
            });
            continue;
            if (("dev_reply".equals(localReply2.type)) && (l <= localReply2.created_at))
              l = localReply2.created_at;
          }
        }
        try
        {
          Iterator localIterator = new a(Conversation.c(Conversation.this)).a(Conversation.b(Conversation.this), l).iterator();
          while (localIterator.hasNext())
          {
            Reply localReply1 = (Reply)localIterator.next();
            if (("dev_reply".equals(localReply1.type)) && (!Conversation.a(Conversation.this, localReply1)))
              localArrayList2.add(localReply1);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        this.a.post(new Runnable()
        {
          public void run()
          {
            Conversation.d(Conversation.this).addAll(localArrayList2);
            Collections.sort(Conversation.d(Conversation.this));
            Conversation.a(Conversation.this);
            if (Conversation.1.this.b != null)
            {
              Conversation.1.this.b.onReceiveDevReply(localArrayList2);
              Conversation.1.this.b.onSendUserReply(localArrayList1);
            }
          }
        });
      }
    };
    String str = Store.getInstance(this.c).getUid();
    if ((str == null) || ("".equals(str)))
    {
      new GetUidTask(local1).execute(new Void[0]);
      return;
    }
    new Thread(local1).start();
  }

  public JSONArray toJson()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
      localJSONArray.put(((Reply)localIterator.next()).toJson());
    return localJSONArray;
  }

  public String toString()
  {
    return toJson().toString();
  }

  class GetUidTask extends AsyncTask<Void, Integer, Boolean>
  {
    private Runnable b;

    public GetUidTask(Runnable arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    protected Boolean a(Void[] paramArrayOfVoid)
    {
      a locala = new a(Conversation.c(Conversation.this));
      String str = locala.a();
      if ((str == null) || ("".equals(str)))
        locala.a();
      return Boolean.valueOf(true);
    }

    protected void a(Boolean paramBoolean)
    {
      String str = Store.getInstance(Conversation.c(Conversation.this)).getUid();
      if ((str != null) && (!"".equals(str)))
      {
        new Thread(this.b).start();
        return;
      }
      Log.c(Conversation.a(), "get uid fail");
    }
  }

  public static abstract interface OnChangeListener
  {
    public abstract void onChange();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.model.Conversation
 * JD-Core Version:    0.6.2
 */