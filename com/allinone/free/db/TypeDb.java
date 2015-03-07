package com.allinone.free.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TypeDb extends SQLiteOpenHelper
{
  public static final String CREATE_TIME = "create_time";
  private static final String DATABASE_APK = "create table file_list(id VARCHAR(255) PRIMARY KEY, typ VARCHAR(20), title VARCHAR(255), icon VARCHAR(255), size VARCHAR(20), path VARCHAR(255),create_time INT(10))";
  public static final String ICON = "icon";
  public static final String PATH = "path";
  public static final String SIZE = "size";
  public static final String TABLE_NAME = "file_list";
  public static final String TITLE = "title";
  public static final String TYPE = "typ";
  public static final String _ID = "id";

  public TypeDb(Context paramContext)
  {
    super(paramContext, "file_list", null, 1);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table file_list(id VARCHAR(255) PRIMARY KEY, typ VARCHAR(20), title VARCHAR(255), icon VARCHAR(255), size VARCHAR(20), path VARCHAR(255),create_time INT(10))");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.db.TypeDb
 * JD-Core Version:    0.6.2
 */