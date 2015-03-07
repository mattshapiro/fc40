package net.tsz.afinal.db.sqlite;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import net.tsz.afinal.db.table.Id;
import net.tsz.afinal.db.table.Property;
import net.tsz.afinal.db.table.TableInfo;

public class CursorUtils
{
  public static <T> T dbModel2Entity(DbModel paramDbModel, Class<?> paramClass)
  {
    HashMap localHashMap;
    if (paramDbModel != null)
      localHashMap = paramDbModel.getDataMap();
    Object localObject1;
    Map.Entry localEntry;
    String str1;
    TableInfo localTableInfo;
    label121: 
    do
      while (true)
      {
        try
        {
          localObject1 = paramClass.newInstance();
          Iterator localIterator = localHashMap.entrySet().iterator();
          if (!localIterator.hasNext())
            return localObject1;
          localEntry = (Map.Entry)localIterator.next();
          str1 = (String)localEntry.getKey();
          localTableInfo = TableInfo.get(paramClass);
          Property localProperty = (Property)localTableInfo.propertyMap.get(str1);
          if (localProperty == null)
            break;
          if (localEntry.getValue() != null)
            break label121;
          localObject2 = null;
          localProperty.setValue(localObject1, localObject2);
          continue;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        return null;
        Object localObject2 = localEntry.getValue().toString();
      }
    while (!localTableInfo.getId().getColumn().equals(str1));
    Id localId = localTableInfo.getId();
    if (localEntry.getValue() == null);
    String str2;
    for (Object localObject3 = null; ; localObject3 = str2)
    {
      localId.setValue(localObject1, localObject3);
      break;
      str2 = localEntry.getValue().toString();
    }
  }

  public static DbModel getDbModel(Cursor paramCursor)
  {
    if ((paramCursor != null) && (paramCursor.getColumnCount() > 0))
    {
      DbModel localDbModel = new DbModel();
      int i = paramCursor.getColumnCount();
      for (int j = 0; ; j++)
      {
        if (j >= i)
          return localDbModel;
        localDbModel.set(paramCursor.getColumnName(j), paramCursor.getString(j));
      }
    }
    return null;
  }

  public static <T> T getEntity(Cursor paramCursor, Class<T> paramClass)
  {
    if (paramCursor != null);
    while (true)
    {
      int i;
      Object localObject;
      int j;
      try
      {
        TableInfo localTableInfo = TableInfo.get(paramClass);
        i = paramCursor.getColumnCount();
        if (i > 0)
        {
          localObject = paramClass.newInstance();
          j = 0;
          break label123;
          String str = paramCursor.getColumnName(j);
          Property localProperty = (Property)localTableInfo.propertyMap.get(str);
          if (localProperty != null)
            localProperty.setValue(localObject, paramCursor.getString(j));
          else if (localTableInfo.getId().getColumn().equals(str))
            localTableInfo.getId().setValue(localObject, paramCursor.getString(j));
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
      label123: 
      while (j >= i)
      {
        return localObject;
        j++;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.sqlite.CursorUtils
 * JD-Core Version:    0.6.2
 */