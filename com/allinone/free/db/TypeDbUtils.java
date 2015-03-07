package com.allinone.free.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.allinone.free.mydownload.ContentValue;
import com.allinone.free.mydownload.DownloadMovieItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

public class TypeDbUtils
  implements ContentValue
{
  private TypeDb db;
  private FinalDBChen finalDBChen;

  public TypeDbUtils(Context paramContext)
  {
    this.db = new TypeDb(paramContext);
    this.finalDBChen = new FinalDBChen(paramContext, paramContext.getDatabasePath("download.db").getAbsolutePath());
  }

  public void deleteallfile(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.db.getWritableDatabase();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    localSQLiteDatabase.delete("file_list", "typ=?", arrayOfString);
  }

  public void deletefile(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.db.getWritableDatabase();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    localSQLiteDatabase.delete("file_list", "id=?", arrayOfString);
  }

  public void insertApk(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = this.db.getWritableDatabase();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("id", paramString1);
    localContentValues.put("typ", paramString2);
    localContentValues.put("title", paramString3);
    localContentValues.put("icon", paramString4);
    localContentValues.put("size", paramString5);
    localContentValues.put("path", paramString6);
    localContentValues.put("create_time", paramLong);
    localSQLiteDatabase.insert("file_list", null, localContentValues);
    localSQLiteDatabase.close();
  }

  public List<DownloadMovieItem> queryApk(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.db.getWritableDatabase();
    Cursor localCursor;
    ArrayList localArrayList;
    if (paramString2.equals("timesort"))
    {
      localCursor = localSQLiteDatabase.query("file_list", null, "typ='" + paramString1 + "'", null, null, null, "create_time DESC");
      localArrayList = new ArrayList();
      if (localCursor == null);
    }
    while (true)
    {
      if (!localCursor.moveToNext())
      {
        if (localCursor != null)
          break label309;
        return null;
        boolean bool = paramString2.equals("zimusort");
        localCursor = null;
        if (!bool)
          break;
        localCursor = localSQLiteDatabase.query("file_list", null, "typ='" + paramString1 + "'", null, null, null, "title ASC");
        break;
      }
      DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
      localDownloadMovieItem.setFile_id(localCursor.getString(localCursor.getColumnIndex("id")));
      localDownloadMovieItem.setType(localCursor.getString(localCursor.getColumnIndex("typ")));
      localDownloadMovieItem.setMovieName(localCursor.getString(localCursor.getColumnIndex("title")));
      localDownloadMovieItem.setMovieHeadImagePath(localCursor.getString(localCursor.getColumnIndex("icon")));
      localDownloadMovieItem.setFileSize(localCursor.getString(localCursor.getColumnIndex("size")));
      localDownloadMovieItem.setFilePath(localCursor.getString(localCursor.getColumnIndex("path")));
      localDownloadMovieItem.setCreate_time(Long.valueOf(localCursor.getLong(localCursor.getColumnIndex("create_time"))));
      localArrayList.add(localDownloadMovieItem);
    }
    label309: if (localCursor.getCount() == 0)
    {
      localSQLiteDatabase.close();
      return null;
    }
    localSQLiteDatabase.close();
    return localArrayList;
  }

  public String querydownloading(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.finalDBChen.getDatabase();
    Cursor localCursor = localSQLiteDatabase.query("downloadtask", null, "file_id='" + paramString + "'", null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor != null);
    while (true)
    {
      if (!localCursor.moveToNext())
      {
        if (localCursor != null)
          break;
        return null;
      }
      DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
      localDownloadMovieItem.setFile_id(localCursor.getString(localCursor.getColumnIndex("file_id")));
      localArrayList.add(localDownloadMovieItem);
    }
    if (localCursor.getCount() == 0)
    {
      localSQLiteDatabase.close();
      return null;
    }
    localSQLiteDatabase.close();
    return ((DownloadMovieItem)localArrayList.get(0)).getFile_id();
  }

  public String queryfile(String paramString)
  {
    Cursor localCursor = this.db.getWritableDatabase().query("file_list", null, "id='" + paramString + "'", null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor != null);
    while (true)
    {
      if (!localCursor.moveToNext())
      {
        if (localCursor != null)
          break;
        return null;
      }
      DownloadMovieItem localDownloadMovieItem = new DownloadMovieItem();
      localDownloadMovieItem.setFile_id(localCursor.getString(localCursor.getColumnIndex("id")));
      localArrayList.add(localDownloadMovieItem);
    }
    if (localCursor.getCount() == 0)
    {
      this.db.close();
      return null;
    }
    return ((DownloadMovieItem)localArrayList.get(0)).getFile_id();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.db.TypeDbUtils
 * JD-Core Version:    0.6.2
 */