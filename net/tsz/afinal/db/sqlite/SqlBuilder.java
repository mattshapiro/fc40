package net.tsz.afinal.db.sqlite;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.tsz.afinal.db.table.Id;
import net.tsz.afinal.db.table.KeyValue;
import net.tsz.afinal.db.table.ManyToOne;
import net.tsz.afinal.db.table.Property;
import net.tsz.afinal.db.table.TableInfo;
import net.tsz.afinal.exception.DbException;

public class SqlBuilder
{
  public static String buildDeleteSql(Class<?> paramClass, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(getDeleteSqlBytableName(TableInfo.get(paramClass).getTableName()));
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuffer.append(" WHERE ");
      localStringBuffer.append(paramString);
    }
    return localStringBuffer.toString();
  }

  public static SqlInfo buildDeleteSql(Class<?> paramClass, Object paramObject)
  {
    TableInfo localTableInfo = TableInfo.get(paramClass);
    Id localId = localTableInfo.getId();
    if (paramObject == null)
      throw new DbException("getDeleteSQL:idValue is null");
    StringBuffer localStringBuffer = new StringBuffer(getDeleteSqlBytableName(localTableInfo.getTableName()));
    localStringBuffer.append(" WHERE ").append(localId.getColumn()).append("=?");
    SqlInfo localSqlInfo = new SqlInfo();
    localSqlInfo.setSql(localStringBuffer.toString());
    localSqlInfo.addValue(paramObject);
    return localSqlInfo;
  }

  public static SqlInfo buildDeleteSql(Object paramObject)
  {
    TableInfo localTableInfo = TableInfo.get(paramObject.getClass());
    Id localId = localTableInfo.getId();
    Object localObject = localId.getValue(paramObject);
    if (localObject == null)
      throw new DbException("getDeleteSQL:" + paramObject.getClass() + " id value is null");
    StringBuffer localStringBuffer = new StringBuffer(getDeleteSqlBytableName(localTableInfo.getTableName()));
    localStringBuffer.append(" WHERE ").append(localId.getColumn()).append("=?");
    SqlInfo localSqlInfo = new SqlInfo();
    localSqlInfo.setSql(localStringBuffer.toString());
    localSqlInfo.addValue(localObject);
    return localSqlInfo;
  }

  public static SqlInfo buildInsertSql(Object paramObject)
  {
    List localList = getSaveKeyValueListByEntity(paramObject);
    StringBuffer localStringBuffer = new StringBuffer();
    SqlInfo localSqlInfo = null;
    Iterator localIterator;
    int j;
    if (localList != null)
    {
      int i = localList.size();
      localSqlInfo = null;
      if (i > 0)
      {
        localSqlInfo = new SqlInfo();
        localStringBuffer.append("INSERT INTO ");
        localStringBuffer.append(TableInfo.get(paramObject.getClass()).getTableName());
        localStringBuffer.append(" (");
        localIterator = localList.iterator();
        if (localIterator.hasNext())
          break label153;
        localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
        localStringBuffer.append(") VALUES ( ");
        j = localList.size();
      }
    }
    for (int k = 0; ; k++)
    {
      if (k >= j)
      {
        localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
        localStringBuffer.append(")");
        localSqlInfo.setSql(localStringBuffer.toString());
        return localSqlInfo;
        label153: KeyValue localKeyValue = (KeyValue)localIterator.next();
        localStringBuffer.append(localKeyValue.getKey()).append(",");
        localSqlInfo.addValue(localKeyValue.getValue());
        break;
      }
      localStringBuffer.append("?,");
    }
  }

  public static String getCreatTableSQL(Class<?> paramClass)
  {
    TableInfo localTableInfo = TableInfo.get(paramClass);
    Id localId = localTableInfo.getId();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CREATE TABLE IF NOT EXISTS ");
    localStringBuffer.append(localTableInfo.getTableName());
    localStringBuffer.append(" ( ");
    Class localClass = localId.getDataType();
    Iterator localIterator1;
    label100: Iterator localIterator2;
    if ((localClass == Integer.TYPE) || (localClass == Integer.class))
    {
      localStringBuffer.append("\"").append(localId.getColumn()).append("\"    ").append("INTEGER PRIMARY KEY AUTOINCREMENT,");
      localIterator1 = localTableInfo.propertyMap.values().iterator();
      if (localIterator1.hasNext())
        break label184;
      localIterator2 = localTableInfo.manyToOneMap.values().iterator();
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
        localStringBuffer.append(" )");
        return localStringBuffer.toString();
        localStringBuffer.append("\"").append(localId.getColumn()).append("\"    ").append("TEXT PRIMARY KEY,");
        break;
        label184: Property localProperty = (Property)localIterator1.next();
        localStringBuffer.append("\"").append(localProperty.getColumn());
        localStringBuffer.append("\",");
        break label100;
      }
      ManyToOne localManyToOne = (ManyToOne)localIterator2.next();
      localStringBuffer.append("\"").append(localManyToOne.getColumn()).append("\",");
    }
  }

  private static String getDeleteSqlBytableName(String paramString)
  {
    return "DELETE FROM " + paramString;
  }

  private static String getPropertyStrSql(String paramString, Object paramObject)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString).append("=");
    if (((paramObject instanceof String)) || ((paramObject instanceof java.util.Date)) || ((paramObject instanceof java.sql.Date)))
      localStringBuffer.append("'").append(paramObject).append("'");
    while (true)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(paramObject);
    }
  }

  public static List<KeyValue> getSaveKeyValueListByEntity(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    TableInfo localTableInfo = TableInfo.get(paramObject.getClass());
    Object localObject = localTableInfo.getId().getValue(paramObject);
    if ((!(localObject instanceof Integer)) && ((localObject instanceof String)) && (localObject != null))
      localArrayList.add(new KeyValue(localTableInfo.getId().getColumn(), localObject));
    Iterator localIterator1 = localTableInfo.propertyMap.values().iterator();
    Iterator localIterator2;
    if (!localIterator1.hasNext())
      localIterator2 = localTableInfo.manyToOneMap.values().iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        return localArrayList;
        KeyValue localKeyValue1 = property2KeyValue((Property)localIterator1.next(), paramObject);
        if (localKeyValue1 == null)
          break;
        localArrayList.add(localKeyValue1);
        break;
      }
      KeyValue localKeyValue2 = manyToOne2KeyValue((ManyToOne)localIterator2.next(), paramObject);
      if (localKeyValue2 != null)
        localArrayList.add(localKeyValue2);
    }
  }

  public static String getSelectSQL(Class<?> paramClass)
  {
    return getSelectSqlByTableName(TableInfo.get(paramClass).getTableName());
  }

  public static String getSelectSQL(Class<?> paramClass, Object paramObject)
  {
    TableInfo localTableInfo = TableInfo.get(paramClass);
    StringBuffer localStringBuffer = new StringBuffer(getSelectSqlByTableName(localTableInfo.getTableName()));
    localStringBuffer.append(" WHERE ");
    localStringBuffer.append(getPropertyStrSql(localTableInfo.getId().getColumn(), paramObject));
    return localStringBuffer.toString();
  }

  public static String getSelectSQLByWhere(Class<?> paramClass, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(getSelectSqlByTableName(TableInfo.get(paramClass).getTableName()));
    if (!TextUtils.isEmpty(paramString))
      localStringBuffer.append(" WHERE ").append(paramString);
    return localStringBuffer.toString();
  }

  public static SqlInfo getSelectSqlAsSqlInfo(Class<?> paramClass, Object paramObject)
  {
    TableInfo localTableInfo = TableInfo.get(paramClass);
    StringBuffer localStringBuffer = new StringBuffer(getSelectSqlByTableName(localTableInfo.getTableName()));
    localStringBuffer.append(" WHERE ").append(localTableInfo.getId().getColumn()).append("=?");
    SqlInfo localSqlInfo = new SqlInfo();
    localSqlInfo.setSql(localStringBuffer.toString());
    localSqlInfo.addValue(paramObject);
    return localSqlInfo;
  }

  private static String getSelectSqlByTableName(String paramString)
  {
    return "SELECT * FROM " + paramString;
  }

  public static SqlInfo getUpdateSqlAsSqlInfo(Object paramObject)
  {
    TableInfo localTableInfo = TableInfo.get(paramObject.getClass());
    Object localObject = localTableInfo.getId().getValue(paramObject);
    if (localObject == null)
      throw new DbException("this entity[" + paramObject.getClass() + "]'s id value is null");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localTableInfo.propertyMap.values().iterator();
    Iterator localIterator2;
    if (!localIterator1.hasNext())
      localIterator2 = localTableInfo.manyToOneMap.values().iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        if ((localArrayList != null) && (localArrayList.size() != 0))
          break label190;
        return null;
        KeyValue localKeyValue1 = property2KeyValue((Property)localIterator1.next(), paramObject);
        if (localKeyValue1 == null)
          break;
        localArrayList.add(localKeyValue1);
        break;
      }
      KeyValue localKeyValue2 = manyToOne2KeyValue((ManyToOne)localIterator2.next(), paramObject);
      if (localKeyValue2 != null)
        localArrayList.add(localKeyValue2);
    }
    label190: SqlInfo localSqlInfo = new SqlInfo();
    StringBuffer localStringBuffer = new StringBuffer("UPDATE ");
    localStringBuffer.append(localTableInfo.getTableName());
    localStringBuffer.append(" SET ");
    Iterator localIterator3 = localArrayList.iterator();
    while (true)
    {
      if (!localIterator3.hasNext())
      {
        localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
        localStringBuffer.append(" WHERE ").append(localTableInfo.getId().getColumn()).append("=?");
        localSqlInfo.addValue(localObject);
        localSqlInfo.setSql(localStringBuffer.toString());
        return localSqlInfo;
      }
      KeyValue localKeyValue3 = (KeyValue)localIterator3.next();
      localStringBuffer.append(localKeyValue3.getKey()).append("=?,");
      localSqlInfo.addValue(localKeyValue3.getValue());
    }
  }

  public static SqlInfo getUpdateSqlAsSqlInfo(Object paramObject, String paramString)
  {
    TableInfo localTableInfo = TableInfo.get(paramObject.getClass());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = localTableInfo.propertyMap.values().iterator();
    Iterator localIterator2;
    if (!localIterator1.hasNext())
      localIterator2 = localTableInfo.manyToOneMap.values().iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        if ((localArrayList != null) && (localArrayList.size() != 0))
          break label175;
        throw new DbException("this entity[" + paramObject.getClass() + "] has no property");
        KeyValue localKeyValue1 = property2KeyValue((Property)localIterator1.next(), paramObject);
        if (localKeyValue1 == null)
          break;
        localArrayList.add(localKeyValue1);
        break;
      }
      KeyValue localKeyValue2 = manyToOne2KeyValue((ManyToOne)localIterator2.next(), paramObject);
      if (localKeyValue2 != null)
        localArrayList.add(localKeyValue2);
    }
    label175: SqlInfo localSqlInfo = new SqlInfo();
    StringBuffer localStringBuffer = new StringBuffer("UPDATE ");
    localStringBuffer.append(localTableInfo.getTableName());
    localStringBuffer.append(" SET ");
    Iterator localIterator3 = localArrayList.iterator();
    while (true)
    {
      if (!localIterator3.hasNext())
      {
        localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
        if (!TextUtils.isEmpty(paramString))
          localStringBuffer.append(" WHERE ").append(paramString);
        localSqlInfo.setSql(localStringBuffer.toString());
        return localSqlInfo;
      }
      KeyValue localKeyValue3 = (KeyValue)localIterator3.next();
      localStringBuffer.append(localKeyValue3.getKey()).append("=?,");
      localSqlInfo.addValue(localKeyValue3.getValue());
    }
  }

  private static KeyValue manyToOne2KeyValue(ManyToOne paramManyToOne, Object paramObject)
  {
    String str = paramManyToOne.getColumn();
    Object localObject1 = paramManyToOne.getValue(paramObject);
    KeyValue localKeyValue = null;
    if (localObject1 != null)
    {
      Object localObject2 = TableInfo.get(localObject1.getClass()).getId().getValue(localObject1);
      localKeyValue = null;
      if (str != null)
      {
        localKeyValue = null;
        if (localObject2 != null)
          localKeyValue = new KeyValue(str, localObject2);
      }
    }
    return localKeyValue;
  }

  private static KeyValue property2KeyValue(Property paramProperty, Object paramObject)
  {
    String str1 = paramProperty.getColumn();
    Object localObject = paramProperty.getValue(paramObject);
    KeyValue localKeyValue;
    if (localObject != null)
      localKeyValue = new KeyValue(str1, localObject);
    int i;
    do
    {
      String str2;
      do
      {
        return localKeyValue;
        str2 = paramProperty.getDefaultValue();
        localKeyValue = null;
      }
      while (str2 == null);
      i = paramProperty.getDefaultValue().trim().length();
      localKeyValue = null;
    }
    while (i == 0);
    return new KeyValue(str1, paramProperty.getDefaultValue());
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.sqlite.SqlBuilder
 * JD-Core Version:    0.6.2
 */