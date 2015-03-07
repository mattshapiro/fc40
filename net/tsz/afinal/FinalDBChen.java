package net.tsz.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.tsz.afinal.db.sqlite.MySqliteOpenHelper;

public class FinalDBChen
{
  private SQLiteDatabase database;
  private String sel = "SELECT * FROM ";
  public MySqliteOpenHelper sqlOpenHelper;
  private String tabName;
  private String where = " WHERE ";

  @Deprecated
  public FinalDBChen(Context paramContext, String paramString)
  {
    this.database = MySqliteOpenHelper.create(paramContext, paramString, null, null, null).getWritableDatabase();
  }

  public FinalDBChen(Context paramContext, String paramString1, Object paramObject, String paramString2, String paramString3)
  {
    this.tabName = paramString2;
    if (TextUtils.isEmpty(paramString2))
      paramString2 = paramContext.getPackageName();
    this.sqlOpenHelper = MySqliteOpenHelper.create(paramContext, paramString1, paramObject, paramString2, "");
    this.database = this.sqlOpenHelper.getDb();
  }

  public FinalDBChen(SQLiteDatabase paramSQLiteDatabase)
  {
    this.database = paramSQLiteDatabase;
  }

  public void addTable(String paramString, Object paramObject)
  {
    if (this.database != null)
      UtilChen.addTab(paramString, this.database, paramObject);
  }

  public void closeDb()
  {
  }

  public void deleteItem(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    this.database.delete(paramString1, paramString2, paramArrayOfString);
  }

  public <T> List<T> findItemsByWhereAndWhereValue(String paramString1, String paramString2, Class<T> paramClass, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = null;
    while (true)
    {
      int n;
      try
      {
        if (TextUtils.isEmpty(paramString3))
          paramString3 = this.tabName;
        arrayOfField = paramClass.getDeclaredFields();
        arrayOfString1 = new String[arrayOfField.length];
        int i = 0;
        int j = arrayOfField.length;
        localCursor = null;
        String str1;
        String[] arrayOfString2;
        if (i >= j)
        {
          str1 = paramString1 + "=?";
          arrayOfString2 = new String[] { paramString2 };
          boolean bool1 = TextUtils.isEmpty(paramString1);
          localCursor = null;
          if ((bool1) && (TextUtils.isEmpty(paramString2)))
          {
            localCursor = this.database.query(paramString3, arrayOfString1, null, null, null, null, paramString4);
            boolean bool5 = localCursor.moveToNext();
            if (bool5)
              continue;
            return localArrayList;
          }
        }
        else
        {
          arrayOfField[i].setAccessible(true);
          arrayOfString1[i] = arrayOfField[i].getName();
          i++;
          continue;
        }
        boolean bool2 = TextUtils.isEmpty(paramString1);
        localCursor = null;
        if (!bool2)
        {
          boolean bool3 = TextUtils.isEmpty(paramString2);
          localCursor = null;
          if (bool3)
          {
            String str2 = this.sel + paramString3 + this.where + paramString1;
            boolean bool4 = TextUtils.isEmpty(paramString4);
            localCursor = null;
            if (!bool4)
              str2 = str2 + " " + paramString4;
            localCursor = this.database.rawQuery(str2, null);
            continue;
          }
        }
        localCursor = this.database.query(paramString3, arrayOfString1, str1, arrayOfString2, null, null, paramString4);
        continue;
        localObject2 = paramClass.newInstance();
        k = 0;
        int m = arrayOfString1.length;
        if (k >= m)
        {
          localArrayList.add(localObject2);
          continue;
        }
      }
      catch (SecurityException localSecurityException)
      {
        Field[] arrayOfField;
        String[] arrayOfString1;
        Object localObject2;
        int k;
        localSecurityException.printStackTrace();
        return localArrayList;
        String str3 = arrayOfString1[k];
        n = 0;
        Object localObject3 = null;
        if (n >= arrayOfField.length)
        {
          k++;
          continue;
        }
        arrayOfField[n].setAccessible(true);
        if (arrayOfField[n].getName().equals(str3))
        {
          String str4 = arrayOfField[n].getType().getSimpleName();
          if (str4.equals("String"))
          {
            localObject3 = localCursor.getString(localCursor.getColumnIndex(str3));
            arrayOfField[n].set(localObject2, localObject3);
          }
          else
          {
            if ((str4.equals("Long")) || (str4.equals("long")))
            {
              localObject3 = Long.valueOf(localCursor.getLong(localCursor.getColumnIndex(str3)));
              continue;
            }
            if ((str4.equals("Integer")) || (str4.equals("int")))
            {
              localObject3 = Integer.valueOf(localCursor.getInt(localCursor.getColumnIndex(str3)));
              continue;
            }
            if (str4.equals("boolean"))
            {
              localObject3 = Boolean.valueOf(Boolean.parseBoolean(localCursor.getString(localCursor.getColumnIndex(str3))));
              continue;
            }
            if ((str4.equals("Float")) || (str4.equals("float")))
            {
              localObject3 = Float.valueOf(localCursor.getFloat(localCursor.getColumnIndex(str3)));
              continue;
            }
            if ((str4.equals("Double")) || (str4.equals("double")))
            {
              localObject3 = Double.valueOf(localCursor.getDouble(localCursor.getColumnIndex(str3)));
              continue;
            }
            if ((!str4.equals("Short")) && (!str4.equals("short")))
              continue;
            Short localShort = Short.valueOf(localCursor.getShort(localCursor.getColumnIndex(str3)));
            localObject3 = localShort;
            continue;
          }
        }
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        return localArrayList;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        return localArrayList;
      }
      finally
      {
        localCursor.close();
      }
      n++;
    }
  }

  public SQLiteDatabase getDatabase()
  {
    return this.database;
  }

  public <T> long insertBeanList(List<? extends Object> paramList, String paramString)
  {
    long l = -1L;
    if (paramList != null)
    {
      int i;
      int j;
      do
        try
        {
          if (paramList.size() == 0)
            break;
          i = paramList.size();
          j = 0;
          continue;
          Field[] arrayOfField = paramList.get(j).getClass().getDeclaredFields();
          ContentValues localContentValues = new ContentValues();
          for (int k = 0; ; k++)
          {
            if (k >= arrayOfField.length)
            {
              l = this.database.insert(paramString, null, localContentValues);
              j++;
              break;
            }
            Field localField = arrayOfField[k];
            localField.setAccessible(true);
            localContentValues.put(localField.getName(), localField.get(paramList.get(j)));
          }
        }
        catch (SecurityException localSecurityException)
        {
          localSecurityException.printStackTrace();
          return l;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
          return l;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
          return l;
        }
      while (j < i);
    }
    return l;
  }

  public long insertMap(Map<String, String> paramMap, String paramString)
  {
    long l = -1L;
    ContentValues localContentValues;
    Iterator localIterator;
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      localContentValues = new ContentValues();
      localIterator = paramMap.keySet().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        l = this.database.insert(paramString, null, localContentValues);
        return l;
      }
      String str = (String)localIterator.next();
      localContentValues.put(str, (String)paramMap.get(str));
    }
  }

  public <T> long insertObject(T paramT, String paramString)
  {
    if (paramT != null)
      try
      {
        if (TextUtils.isEmpty(paramString))
          paramString = this.tabName;
        ContentValues localContentValues = new ContentValues();
        Field[] arrayOfField = paramT.getClass().getDeclaredFields();
        for (int i = 0; ; i++)
        {
          if (i >= arrayOfField.length)
            return this.database.insert(paramString, null, localContentValues);
          Field localField = arrayOfField[i];
          localField.setAccessible(true);
          localContentValues.put(localField.getName(), localField.get(paramT));
        }
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
        return -1L;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return -1L;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    return -1L;
  }

  public String quer(String paramString1, String paramString2)
  {
    this.database.query(paramString1, null, "file_id='" + paramString2 + "'", null, null, null, null);
    return paramString2;
  }

  public void setDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    this.database = paramSQLiteDatabase;
  }

  public void updateValue(String paramString1, String paramString2, String[] paramArrayOfString, ContentValues paramContentValues)
  {
    this.database.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
  }

  public void updateValuesByJavaBean(String paramString1, String paramString2, String[] paramArrayOfString, Object paramObject)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
      int i = arrayOfField.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
        {
          updateValue(paramString1, paramString2, paramArrayOfString, localContentValues);
          return;
        }
        Field localField = arrayOfField[j];
        localField.setAccessible(true);
        localContentValues.put(localField.getName(), localField.get(paramObject));
      }
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.FinalDBChen
 * JD-Core Version:    0.6.2
 */