package com.umeng.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.message.entity.UMessage;
import org.json.JSONObject;

public class MessageStore
{
  public static final String ActionType = "ActionType";
  public static final String ArrivalTime = "ArrivalTime";
  public static final String Id = "_id";
  public static final String Json = "Json";
  public static final String MsgId = "MsdId";
  public static final String SdkVersion = "SdkVersion";
  private static final String d = "MessageStore.db";
  private static final String e = "MessageStore";
  private static final int f = 1;
  private static final String g = " PRIMARY KEY ";
  private static final String h = " AUTOINCREMENT ";
  private static final String i = "CREATE TABLE IF NOT EXISTS ";
  public static MessageStore instance;
  private static final String j = " Integer ";
  private static final String k = " Long ";
  private static final String l = " Varchar ";
  private static final String m = "(";
  private static final String n = ")";
  private static final String o = " , ";
  private static final String p = " And ";
  private static final String q = " desc ";
  private static final String r = " asc ";
  private Context a;
  private SQLiteDatabase b;
  private MessageStoreHelper c;

  private MessageStore(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.c = new MessageStoreHelper(paramContext);
    this.b = this.c.getWritableDatabase();
  }

  public static MessageStore getInstance(Context paramContext)
  {
    if (instance == null)
      instance = new MessageStore(paramContext);
    return instance;
  }

  boolean a(UMessage paramUMessage)
  {
    if (paramUMessage == null)
      return false;
    synchronized (instance)
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("MsdId", paramUMessage.msg_id);
      localContentValues.put("Json", paramUMessage.getRaw().toString());
      localContentValues.put("SdkVersion", "1.7.0");
      localContentValues.put("ArrivalTime", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("ActionType", Integer.valueOf(0));
      boolean bool1 = this.b.insert("MessageStore", null, localContentValues) < -1L;
      boolean bool2 = false;
      if (bool1)
        bool2 = true;
      return bool2;
    }
  }

  boolean a(String paramString)
  {
    return a(paramString, 1);
  }

  boolean a(String paramString, int paramInt)
  {
    int i2;
    for (int i1 = 1; ; i2 = 0)
      synchronized (instance)
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("ActionType", Integer.valueOf(paramInt));
        String[] arrayOfString = { paramString };
        if (this.b.update("MessageStore", localContentValues, "MsdId=?", arrayOfString) == i1)
          return i1;
      }
  }

  boolean b(String paramString)
  {
    return a(paramString, 2);
  }

  private class MessageStoreHelper extends SQLiteOpenHelper
  {
    public MessageStoreHelper(Context arg2)
    {
      super("MessageStore.db", null, 1);
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MessageStore(_id Integer  PRIMARY KEY  AUTOINCREMENT  , MsdId Varchar  , Json Varchar  , SdkVersion Varchar  , ArrivalTime Long  , ActionType Integer )");
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.MessageStore
 * JD-Core Version:    0.6.2
 */