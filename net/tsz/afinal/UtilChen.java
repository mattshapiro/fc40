package net.tsz.afinal;

import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Field;

public class UtilChen
{
  public static void addTab(String paramString, SQLiteDatabase paramSQLiteDatabase, Object paramObject)
  {
    try
    {
      String str1 = "CREATE TABLE IF NOT EXISTS " + paramString;
      StringBuffer localStringBuffer = new StringBuffer();
      String str2 = "VARCHAR(200)" + ",";
      Field[] arrayOfField = paramObject.getClass().getDeclaredFields();
      int i = arrayOfField.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
        {
          localStringBuffer.deleteCharAt(localStringBuffer.lastIndexOf(","));
          paramSQLiteDatabase.execSQL(str1 + "(" + localStringBuffer.toString() + ")");
          return;
        }
        Field localField = arrayOfField[j];
        localField.setAccessible(true);
        localStringBuffer.append(new StringBuilder(String.valueOf(localField.getName())).append(" ").toString() + str2);
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
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.UtilChen
 * JD-Core Version:    0.6.2
 */