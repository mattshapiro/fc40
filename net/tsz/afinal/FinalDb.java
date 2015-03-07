package net.tsz.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.tsz.afinal.db.sqlite.CursorUtils;
import net.tsz.afinal.db.sqlite.DbModel;
import net.tsz.afinal.db.sqlite.SqlBuilder;
import net.tsz.afinal.db.sqlite.SqlInfo;
import net.tsz.afinal.db.table.Id;
import net.tsz.afinal.db.table.KeyValue;
import net.tsz.afinal.db.table.ManyToOne;
import net.tsz.afinal.db.table.OneToMany;
import net.tsz.afinal.db.table.TableInfo;

public class FinalDb
{
  private static final String TAG = "FinalDb";
  private static HashMap<String, FinalDb> daoMap = new HashMap();
  private DaoConfig config;
  private SQLiteDatabase db;

  private FinalDb(DaoConfig paramDaoConfig)
  {
    if (paramDaoConfig == null)
      throw new RuntimeException("daoConfig is null");
    if (paramDaoConfig.getContext() == null)
      throw new RuntimeException("android context is null");
    this.db = new SqliteDbHelper(paramDaoConfig.getContext().getApplicationContext(), paramDaoConfig.getDbName(), paramDaoConfig.getDbVersion(), paramDaoConfig.getDbUpdateListener()).getWritableDatabase();
    this.config = paramDaoConfig;
  }

  private void checkTableExist(Class<?> paramClass)
  {
    if (!tableIsExist(TableInfo.get(paramClass)))
    {
      String str = SqlBuilder.getCreatTableSQL(paramClass);
      debugSql(str);
      this.db.execSQL(str);
    }
  }

  public static FinalDb create(Context paramContext)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    return getInstance(localDaoConfig);
  }

  public static FinalDb create(Context paramContext, String paramString)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDbName(paramString);
    return getInstance(localDaoConfig);
  }

  public static FinalDb create(Context paramContext, String paramString, boolean paramBoolean)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDbName(paramString);
    localDaoConfig.setDebug(paramBoolean);
    return getInstance(localDaoConfig);
  }

  public static FinalDb create(Context paramContext, String paramString, boolean paramBoolean, int paramInt, DbUpdateListener paramDbUpdateListener)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDbName(paramString);
    localDaoConfig.setDebug(paramBoolean);
    localDaoConfig.setDbVersion(paramInt);
    localDaoConfig.setDbUpdateListener(paramDbUpdateListener);
    return getInstance(localDaoConfig);
  }

  public static FinalDb create(Context paramContext, boolean paramBoolean)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDebug(paramBoolean);
    return getInstance(localDaoConfig);
  }

  public static FinalDb create(DaoConfig paramDaoConfig)
  {
    return getInstance(paramDaoConfig);
  }

  private void debugSql(String paramString)
  {
    if ((this.config != null) && (this.config.isDebug()))
      Log.d("Debug SQL", ">>>>>>  " + paramString);
  }

  private void exeSqlInfo(SqlInfo paramSqlInfo)
  {
    if (paramSqlInfo != null)
    {
      debugSql(paramSqlInfo.getSql());
      this.db.execSQL(paramSqlInfo.getSql(), paramSqlInfo.getBindArgsAsArray());
      return;
    }
    Log.e("FinalDb", "sava error:sqlInfo is null");
  }

  private <T> List<T> findAllBySql(Class<T> paramClass, String paramString)
  {
    checkTableExist(paramClass);
    debugSql(paramString);
    Cursor localCursor = this.db.rawQuery(paramString, null);
    try
    {
      ArrayList localArrayList = new ArrayList();
      while (true)
      {
        boolean bool = localCursor.moveToNext();
        if (!bool)
          return localArrayList;
        localArrayList.add(CursorUtils.getEntity(localCursor, paramClass));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    finally
    {
      if (localCursor != null)
        localCursor.close();
    }
  }

  private static FinalDb getInstance(DaoConfig paramDaoConfig)
  {
    try
    {
      FinalDb localFinalDb = (FinalDb)daoMap.get(paramDaoConfig.getDbName());
      if (localFinalDb == null)
      {
        localFinalDb = new FinalDb(paramDaoConfig);
        daoMap.put(paramDaoConfig.getDbName(), localFinalDb);
      }
      return localFinalDb;
    }
    finally
    {
    }
  }

  private void insertContentValues(List<KeyValue> paramList, ContentValues paramContentValues)
  {
    if ((paramList != null) && (paramContentValues != null))
    {
      Iterator localIterator = paramList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        KeyValue localKeyValue = (KeyValue)localIterator.next();
        paramContentValues.put(localKeyValue.getKey(), localKeyValue.getValue().toString());
      }
    }
    Log.w("FinalDb", "insertContentValues: List<KeyValue> is empty or ContentValues is empty!");
  }

  private boolean tableIsExist(TableInfo paramTableInfo)
  {
    if (paramTableInfo.isCheckDatabese())
      return true;
    Cursor localCursor = null;
    while (true)
    {
      try
      {
        String str = "SELECT COUNT(*) AS c FROM sqlite_master WHERE type ='table' AND name ='" + paramTableInfo.getTableName() + "' ";
        debugSql(str);
        localCursor = this.db.rawQuery(str, null);
        if ((localCursor != null) && (localCursor.moveToNext()) && (localCursor.getInt(0) > 0))
        {
          paramTableInfo.setCheckDatabese(true);
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
      finally
      {
        if (localCursor != null)
          localCursor.close();
      }
      if (localCursor != null)
        localCursor.close();
    }
  }

  public void delete(Object paramObject)
  {
    checkTableExist(paramObject.getClass());
    exeSqlInfo(SqlBuilder.buildDeleteSql(paramObject));
  }

  public void deleteById(Class<?> paramClass, Object paramObject)
  {
    checkTableExist(paramClass);
    exeSqlInfo(SqlBuilder.buildDeleteSql(paramClass, paramObject));
  }

  public void deleteByWhere(Class<?> paramClass, String paramString)
  {
    checkTableExist(paramClass);
    String str = SqlBuilder.buildDeleteSql(paramClass, paramString);
    debugSql(str);
    this.db.execSQL(str);
  }

  public <T> List<T> findAll(Class<T> paramClass)
  {
    checkTableExist(paramClass);
    return findAllBySql(paramClass, SqlBuilder.getSelectSQL(paramClass));
  }

  public <T> List<T> findAll(Class<T> paramClass, String paramString)
  {
    checkTableExist(paramClass);
    return findAllBySql(paramClass, SqlBuilder.getSelectSQL(paramClass) + " ORDER BY " + paramString + " DESC");
  }

  public <T> List<T> findAllByWhere(Class<T> paramClass, String paramString)
  {
    checkTableExist(paramClass);
    return findAllBySql(paramClass, SqlBuilder.getSelectSQLByWhere(paramClass, paramString));
  }

  public <T> List<T> findAllByWhere(Class<T> paramClass, String paramString1, String paramString2)
  {
    checkTableExist(paramClass);
    return findAllBySql(paramClass, SqlBuilder.getSelectSQLByWhere(paramClass, paramString1) + " ORDER BY '" + paramString2 + "' DESC");
  }

  public <T> T findById(Object paramObject, Class<T> paramClass)
  {
    checkTableExist(paramClass);
    SqlInfo localSqlInfo = SqlBuilder.getSelectSqlAsSqlInfo(paramClass, paramObject);
    Cursor localCursor;
    if (localSqlInfo != null)
    {
      debugSql(localSqlInfo.getSql());
      localCursor = this.db.rawQuery(localSqlInfo.getSql(), localSqlInfo.getBindArgsAsStringArray());
    }
    while (true)
    {
      try
      {
        if (localCursor.moveToNext())
        {
          Object localObject2 = CursorUtils.getEntity(localCursor, paramClass);
          return localObject2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      finally
      {
        localCursor.close();
      }
      localCursor.close();
    }
  }

  public DbModel findDbModelBySQL(String paramString)
  {
    debugSql(paramString);
    Cursor localCursor = this.db.rawQuery(paramString, null);
    try
    {
      if (localCursor.moveToNext())
      {
        DbModel localDbModel = CursorUtils.getDbModel(localCursor);
        return localDbModel;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return null;
    }
    finally
    {
      localCursor.close();
    }
    localCursor.close();
    return null;
  }

  public List<DbModel> findDbModelListBySQL(String paramString)
  {
    debugSql(paramString);
    Cursor localCursor = this.db.rawQuery(paramString, null);
    ArrayList localArrayList = new ArrayList();
    try
    {
      while (true)
      {
        boolean bool = localCursor.moveToNext();
        if (!bool)
          return localArrayList;
        localArrayList.add(CursorUtils.getDbModel(localCursor));
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return localArrayList;
    }
    finally
    {
      localCursor.close();
    }
  }

  public <T> T findWithManyToOneById(Object paramObject, Class<T> paramClass)
  {
    checkTableExist(paramClass);
    String str = SqlBuilder.getSelectSQL(paramClass, paramObject);
    debugSql(str);
    DbModel localDbModel = findDbModelBySQL(str);
    if (localDbModel != null)
    {
      localObject1 = CursorUtils.dbModel2Entity(localDbModel, paramClass);
      if (localObject1 == null)
        break label149;
      try
      {
        Iterator localIterator = TableInfo.get(paramClass).manyToOneMap.values().iterator();
        while (true)
        {
          if (!localIterator.hasNext())
            return localObject1;
          ManyToOne localManyToOne = (ManyToOne)localIterator.next();
          Object localObject2 = localDbModel.get(localManyToOne.getColumn());
          if (localObject2 != null)
          {
            Object localObject3 = findById(Integer.valueOf(localObject2.toString()), localManyToOne.getDataType());
            if (localObject3 != null)
              localManyToOne.setValue(localObject1, localObject3);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localObject1;
      }
    }
    Object localObject1 = null;
    label149: return localObject1;
  }

  public <T> T findWithManyToOneById(Object paramObject, Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    checkTableExist(paramClass);
    String str = SqlBuilder.getSelectSQL(paramClass, paramObject);
    debugSql(str);
    DbModel localDbModel = findDbModelBySQL(str);
    Object localObject1;
    if (localDbModel != null)
    {
      localObject1 = CursorUtils.dbModel2Entity(localDbModel, paramClass);
      if (localObject1 == null)
        break label184;
    }
    while (true)
    {
      ManyToOne localManyToOne;
      int i;
      int j;
      try
      {
        Iterator localIterator = TableInfo.get(paramClass).manyToOneMap.values().iterator();
        if (!localIterator.hasNext())
          return localObject1;
        localManyToOne = (ManyToOne)localIterator.next();
        i = paramArrayOfClass.length;
        j = 0;
        break label187;
        if (k == 0)
          continue;
        Object localObject2 = findById(localDbModel.get(localManyToOne.getColumn()), localManyToOne.getDataType());
        if (localObject2 == null)
          continue;
        localManyToOne.setValue(localObject1, localObject2);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localObject1;
      }
      label184: label187: 
      while (j < i)
      {
        Class<?> localClass = paramArrayOfClass[j];
        Class localClass1 = localManyToOne.getManyClass();
        if (localClass1 == localClass)
        {
          k = 1;
          break;
        }
        j++;
        continue;
        localObject1 = null;
        return localObject1;
      }
      int k = 0;
    }
  }

  public <T> T findWithOneToManyById(Object paramObject, Class<T> paramClass)
  {
    checkTableExist(paramClass);
    String str = SqlBuilder.getSelectSQL(paramClass, paramObject);
    debugSql(str);
    DbModel localDbModel = findDbModelBySQL(str);
    if (localDbModel != null)
    {
      localObject = CursorUtils.dbModel2Entity(localDbModel, paramClass);
      if (localObject == null)
        break label152;
      try
      {
        Iterator localIterator = TableInfo.get(paramClass).oneToManyMap.values().iterator();
        while (true)
        {
          if (!localIterator.hasNext())
            return localObject;
          OneToMany localOneToMany = (OneToMany)localIterator.next();
          List localList = findAllByWhere(localOneToMany.getOneClass(), localOneToMany.getColumn() + "=" + paramObject);
          if (localList != null)
            localOneToMany.setValue(localObject, localList);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localObject;
      }
    }
    Object localObject = null;
    label152: return localObject;
  }

  public <T> T findWithOneToManyById(Object paramObject, Class<T> paramClass, Class<?>[] paramArrayOfClass)
  {
    checkTableExist(paramClass);
    String str = SqlBuilder.getSelectSQL(paramClass, paramObject);
    debugSql(str);
    DbModel localDbModel = findDbModelBySQL(str);
    Object localObject;
    if (localDbModel != null)
    {
      localObject = CursorUtils.dbModel2Entity(localDbModel, paramClass);
      if (localObject == null)
        break label208;
    }
    while (true)
    {
      OneToMany localOneToMany;
      int i;
      int j;
      try
      {
        Iterator localIterator = TableInfo.get(paramClass).oneToManyMap.values().iterator();
        if (!localIterator.hasNext())
          return localObject;
        localOneToMany = (OneToMany)localIterator.next();
        i = paramArrayOfClass.length;
        j = 0;
        break label211;
        if (k == 0)
          continue;
        List localList = findAllByWhere(localOneToMany.getOneClass(), localOneToMany.getColumn() + "=" + paramObject);
        if (localList == null)
          continue;
        localOneToMany.setValue(localObject, localList);
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return localObject;
      }
      label208: label211: 
      while (j < i)
      {
        Class<?> localClass = paramArrayOfClass[j];
        boolean bool = localOneToMany.getOneClass().equals(localClass.getName());
        if (bool)
        {
          k = 1;
          break;
        }
        j++;
        continue;
        localObject = null;
        return localObject;
      }
      int k = 0;
    }
  }

  public void save(Object paramObject)
  {
    checkTableExist(paramObject.getClass());
    exeSqlInfo(SqlBuilder.buildInsertSql(paramObject));
  }

  public boolean saveBindId(Object paramObject)
  {
    checkTableExist(paramObject.getClass());
    List localList = SqlBuilder.getSaveKeyValueListByEntity(paramObject);
    TableInfo localTableInfo;
    Long localLong;
    if ((localList != null) && (localList.size() > 0))
    {
      localTableInfo = TableInfo.get(paramObject.getClass());
      ContentValues localContentValues = new ContentValues();
      insertContentValues(localList, localContentValues);
      localLong = Long.valueOf(this.db.insert(localTableInfo.getTableName(), null, localContentValues));
      if (localLong.longValue() != -1L);
    }
    else
    {
      return false;
    }
    localTableInfo.getId().setValue(paramObject, localLong);
    return true;
  }

  public void update(Object paramObject)
  {
    checkTableExist(paramObject.getClass());
    exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(paramObject));
  }

  public void update(Object paramObject, String paramString)
  {
    checkTableExist(paramObject.getClass());
    exeSqlInfo(SqlBuilder.getUpdateSqlAsSqlInfo(paramObject, paramString));
  }

  public static class DaoConfig
  {
    private Context context = null;
    private String dbName = "afinal.db";
    private FinalDb.DbUpdateListener dbUpdateListener;
    private int dbVersion = 1;
    private boolean debug = true;

    public Context getContext()
    {
      return this.context;
    }

    public String getDbName()
    {
      return this.dbName;
    }

    public FinalDb.DbUpdateListener getDbUpdateListener()
    {
      return this.dbUpdateListener;
    }

    public int getDbVersion()
    {
      return this.dbVersion;
    }

    public boolean isDebug()
    {
      return this.debug;
    }

    public void setContext(Context paramContext)
    {
      this.context = paramContext;
    }

    public void setDbName(String paramString)
    {
      this.dbName = paramString;
    }

    public void setDbUpdateListener(FinalDb.DbUpdateListener paramDbUpdateListener)
    {
      this.dbUpdateListener = paramDbUpdateListener;
    }

    public void setDbVersion(int paramInt)
    {
      this.dbVersion = paramInt;
    }

    public void setDebug(boolean paramBoolean)
    {
      this.debug = paramBoolean;
    }
  }

  public static abstract interface DbUpdateListener
  {
    public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  }

  class SqliteDbHelper extends SQLiteOpenHelper
  {
    private FinalDb.DbUpdateListener mDbUpdateListener;

    public SqliteDbHelper(Context paramString, String paramInt, int paramDbUpdateListener, FinalDb.DbUpdateListener arg5)
    {
      super(paramInt, null, paramDbUpdateListener);
      Object localObject;
      this.mDbUpdateListener = localObject;
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      if (this.mDbUpdateListener != null)
      {
        this.mDbUpdateListener.onUpgrade(paramSQLiteDatabase, paramInt1, paramInt2);
        return;
      }
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT name FROM sqlite_master WHERE type ='table'", null);
      if (localCursor != null);
      while (true)
      {
        if (!localCursor.moveToNext())
        {
          if (localCursor == null)
            break;
          localCursor.close();
          return;
        }
        paramSQLiteDatabase.execSQL("DROP TABLE " + localCursor.getString(0));
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.FinalDb
 * JD-Core Version:    0.6.2
 */