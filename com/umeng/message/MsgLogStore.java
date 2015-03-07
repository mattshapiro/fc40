package com.umeng.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import org.json.JSONObject;

public class MsgLogStore
{
  public static final String ActionType = "ActionType";
  public static final String MsgId = "MsgId";
  public static final String MsgType = "MsgType";
  public static final String Time = "Time";
  private static MsgLogStore a;
  private static final String e = " And ";
  private static final String f = " Asc ";
  private static final String g = " Desc ";
  private static final String h = "MsgLogStore.db";
  private static final int i = 2;
  private static final String j = "MsgLogStore";
  private static final String k = "MsgLogIdTypeStore";
  private SQLiteDatabase b;
  private MsgLogStoreHelper c;
  private Context d;

  private MsgLogStore(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.c = new MsgLogStoreHelper(paramContext);
    this.b = this.c.getWritableDatabase();
  }

  private void a()
  {
    if (MessageSharedPrefs.getInstance(this.d).h())
      return;
    File[] arrayOfFile = this.d.getCacheDir().listFiles(new FilenameFilter()
    {
      public boolean accept(File paramAnonymousFile, String paramAnonymousString)
      {
        return (!TextUtils.isEmpty(paramAnonymousString)) && (paramAnonymousString.startsWith("umeng_message_log_cache_"));
      }
    });
    if (arrayOfFile != null)
    {
      int m = arrayOfFile.length;
      for (int n = 0; n < m; n++)
      {
        File localFile = arrayOfFile[n];
        a(localFile);
        localFile.delete();
      }
    }
    MessageSharedPrefs.getInstance(this.d).i();
  }

  private void a(File paramFile)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(b(paramFile));
      addLog(localJSONObject.optString("msg_id"), localJSONObject.optInt("action_type"), localJSONObject.optLong("ts"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  // ERROR //
  private String b(File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: new 139	java/io/BufferedReader
    //   3: dup
    //   4: new 141	java/io/FileReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 143	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   12: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 148	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   23: astore_3
    //   24: aload_2
    //   25: invokevirtual 153	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore 6
    //   30: aload 6
    //   32: ifnull +26 -> 58
    //   35: aload_3
    //   36: aload 6
    //   38: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: goto -18 -> 24
    //   45: astore 4
    //   47: aload_2
    //   48: ifnull +7 -> 55
    //   51: aload_2
    //   52: invokevirtual 160	java/io/BufferedReader:close	()V
    //   55: aload 4
    //   57: athrow
    //   58: aload_3
    //   59: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: astore 8
    //   64: aload_2
    //   65: ifnull +7 -> 72
    //   68: aload_2
    //   69: invokevirtual 160	java/io/BufferedReader:close	()V
    //   72: aload 8
    //   74: areturn
    //   75: astore 9
    //   77: aload 9
    //   79: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   82: aload 8
    //   84: areturn
    //   85: astore 5
    //   87: aload 5
    //   89: invokevirtual 164	java/io/IOException:printStackTrace	()V
    //   92: goto -37 -> 55
    //   95: astore 4
    //   97: aconst_null
    //   98: astore_2
    //   99: goto -52 -> 47
    //
    // Exception table:
    //   from	to	target	type
    //   16	24	45	finally
    //   24	30	45	finally
    //   35	42	45	finally
    //   58	64	45	finally
    //   68	72	75	java/io/IOException
    //   51	55	85	java/io/IOException
    //   0	16	95	finally
  }

  public static MsgLogStore getInstance(Context paramContext)
  {
    if (a == null)
    {
      a = new MsgLogStore(paramContext);
      a.a();
    }
    return a;
  }

  public boolean addLog(String paramString, int paramInt, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
      return false;
    MsgLog localMsgLog = new MsgLog(paramString, paramInt, paramLong);
    if (this.b.insert("MsgLogStore", null, localMsgLog.getContentValues()) != -1L);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean addLogIdType(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1));
    MsgLogIdType localMsgLogIdType;
    do
    {
      return false;
      localMsgLogIdType = new MsgLogIdType(paramString1, paramString2);
    }
    while (this.b.insert("MsgLogIdTypeStore", null, localMsgLogIdType.getContentValues()) == -1L);
    return true;
  }

  public MsgLog getMsgLog(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return null;
    String[] arrayOfString = { paramString };
    Cursor localCursor = this.b.query("MsgLogStore", null, "MsgId=?", arrayOfString, null, null, null, null);
    boolean bool = localCursor.moveToFirst();
    MsgLog localMsgLog = null;
    if (bool)
      localMsgLog = new MsgLog(localCursor);
    localCursor.close();
    return localMsgLog;
  }

  public ArrayList<MsgLogIdType> getMsgLogIdTypes()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.b.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", null);
    for (boolean bool = localCursor.moveToFirst(); bool; bool = localCursor.moveToNext())
      localArrayList.add(new MsgLogIdType(localCursor));
    localCursor.close();
    return localArrayList;
  }

  public ArrayList<MsgLogIdType> getMsgLogIdTypes(int paramInt)
  {
    if (paramInt < 1)
      return null;
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.b.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", paramInt + "");
    for (boolean bool = localCursor.moveToFirst(); bool; bool = localCursor.moveToNext())
      localArrayList.add(new MsgLogIdType(localCursor));
    localCursor.close();
    return localArrayList;
  }

  public ArrayList<MsgLog> getMsgLogs(int paramInt)
  {
    if (paramInt < 1)
      return null;
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = this.b.query("MsgLogStore", null, null, null, null, null, "Time Asc ", paramInt + "");
    for (boolean bool = localCursor.moveToFirst(); bool; bool = localCursor.moveToNext())
      localArrayList.add(new MsgLog(localCursor));
    localCursor.close();
    return localArrayList;
  }

  public boolean removeLog(String paramString, int paramInt)
  {
    int m = 1;
    if (TextUtils.isEmpty(paramString))
      return false;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = paramString;
    arrayOfString[m] = (paramInt + "");
    if (this.b.delete("MsgLogStore", "MsgId=? And ActionType=?", arrayOfString) == m);
    while (true)
    {
      return m;
      int n = 0;
    }
  }

  public boolean removeLogIdType(String paramString)
  {
    int m = 1;
    if (TextUtils.isEmpty(paramString))
      return false;
    String[] arrayOfString = new String[m];
    arrayOfString[0] = paramString;
    if (this.b.delete("MsgLogIdTypeStore", "MsgId=?", arrayOfString) == m);
    while (true)
    {
      return m;
      int n = 0;
    }
  }

  public class MsgLog
  {
    public int actionType;
    public String msgId;
    public long time;

    public MsgLog(Cursor arg2)
    {
      Object localObject;
      this.msgId = localObject.getString(localObject.getColumnIndex("MsgId"));
      this.time = localObject.getLong(localObject.getColumnIndex("Time"));
      this.actionType = localObject.getInt(localObject.getColumnIndex("ActionType"));
    }

    public MsgLog(String paramInt, int paramLong, long arg4)
    {
      this.msgId = paramInt;
      this.actionType = paramLong;
      Object localObject;
      this.time = localObject;
    }

    public ContentValues getContentValues()
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("MsgId", this.msgId);
      localContentValues.put("Time", Long.valueOf(this.time));
      localContentValues.put("ActionType", Integer.valueOf(this.actionType));
      return localContentValues;
    }
  }

  public class MsgLogIdType
  {
    public String msgId;
    public String msgType;

    public MsgLogIdType(Cursor arg2)
    {
      Object localObject;
      this.msgId = localObject.getString(localObject.getColumnIndex("MsgId"));
      this.msgType = localObject.getString(localObject.getColumnIndex("MsgType"));
    }

    public MsgLogIdType(String paramString1, String arg3)
    {
      this.msgId = paramString1;
      Object localObject;
      this.msgType = localObject;
    }

    public ContentValues getContentValues()
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("MsgId", this.msgId);
      localContentValues.put("MsgType", this.msgType);
      return localContentValues;
    }
  }

  private class MsgLogStoreHelper extends SQLiteOpenHelper
  {
    public MsgLogStoreHelper(Context arg2)
    {
      super("MsgLogStore.db", null, 2);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("create table if not exists MsgLogStore ( MsgId varchar, ActionType Integer, Time long, PRIMARY KEY(MsgId, ActionType))");
      paramSQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.MsgLogStore
 * JD-Core Version:    0.6.2
 */