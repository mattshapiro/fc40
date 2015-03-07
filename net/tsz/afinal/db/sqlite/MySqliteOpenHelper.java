package net.tsz.afinal.db.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.widget.Toast;
import net.tsz.afinal.UtilChen;

public class MySqliteOpenHelper extends SQLiteOpenHelper
{
  private static MySqliteOpenHelper dbHelper;
  private String defaultSql;
  private String defaultTableName;
  private Context mContext;
  private Object obj;

  private MySqliteOpenHelper(Context paramContext, String paramString1, Object paramObject, String paramString2, String paramString3)
  {
    super(paramContext, paramString1, null, 1);
    this.mContext = paramContext;
    this.obj = paramObject;
    this.defaultTableName = paramString2;
    this.defaultSql = paramString3;
  }

  public static MySqliteOpenHelper create(Context paramContext, String paramString1, Object paramObject, String paramString2, String paramString3)
  {
    try
    {
      if (dbHelper == null)
        dbHelper = new MySqliteOpenHelper(paramContext, paramString1, paramObject, paramString2, paramString3);
      MySqliteOpenHelper localMySqliteOpenHelper = dbHelper;
      return localMySqliteOpenHelper;
    }
    finally
    {
    }
  }

  public SQLiteDatabase getDb()
  {
    return getWritableDatabase();
  }

  public void initDB(SQLiteDatabase paramSQLiteDatabase)
  {
    UtilChen.addTab(this.defaultTableName, paramSQLiteDatabase, this.obj);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    if (!TextUtils.isEmpty(this.defaultSql))
    {
      paramSQLiteDatabase.execSQL(this.defaultSql);
      return;
    }
    if (this.obj != null)
    {
      initDB(paramSQLiteDatabase);
      return;
    }
    Toast.makeText(this.mContext, "不能创建一个空的数据表", 0).show();
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.sqlite.MySqliteOpenHelper
 * JD-Core Version:    0.6.2
 */