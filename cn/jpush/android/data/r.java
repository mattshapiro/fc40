package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import cn.jpush.android.util.x;

public final class r extends SQLiteOpenHelper
{
  private static r a;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[14];
    int i = 0;
    String str1 = "";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label36: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label52: int i2;
    int i3;
    if (k <= 1)
    {
      localObject4 = localObject3;
      n = m;
      i1 = k;
      localObject5 = localObject3;
      i2 = localObject5[m];
      switch (n % 5)
      {
      default:
        i3 = 116;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[m] = ((char)(i3 ^ i2));
      m = n + 1;
      if (i1 == 0)
      {
        localObject5 = localObject4;
        n = m;
        m = i1;
        break label52;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "\032\025\004c\035\f";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "\034\023\004c\020\t\004\025";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "\032\025\004c\035\fM";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "\032\025\004\022\020\n";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "\032\025\004c\004\032\025\022U\f";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\032\025\004c\020\t\004\025";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "H\004\034YT\006\025\003j\021\032\003\035S\032H\031\007\034NH";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "\f\002\033LT\034\021\026P\021H92\034109'h'H\002\021L+\034\021\026P\021";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "<\030\021\034\033\004\024\"Y\006\033\031\033RT\001\003N\034";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "\f\002\033LT\034\021\026P\021H92\034109'h'H\004\027L+\034\021\026P\021";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 104;
        continue;
        i3 = 112;
        continue;
        i3 = 116;
        continue;
        i3 = 60;
      }
    }
  }

  private r(Context paramContext)
  {
    super(paramContext, z[4], null, 3);
  }

  public static Cursor a(Context paramContext)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c(paramContext).getWritableDatabase();
      String str = z[5];
      String[] arrayOfString = new String[3];
      arrayOfString[0] = z[1];
      arrayOfString[1] = z[7];
      arrayOfString[2] = z[6];
      Cursor localCursor = localSQLiteDatabase.query(str, arrayOfString, null, null, null, null, z[1]);
      return localCursor;
    }
    catch (Exception localException)
    {
      x.h();
    }
    return null;
  }

  public static boolean a(Context paramContext, int paramInt)
  {
    try
    {
      int i = c(paramContext).getWritableDatabase().delete(z[5], z[3] + paramInt, null);
      boolean bool = false;
      if (i > 0)
        bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      x.h();
    }
    return false;
  }

  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c(paramContext).getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(z[2], paramString);
      long l = localSQLiteDatabase.insert(z[0], z[1], localContentValues);
      return l > 0L;
    }
    catch (Exception localException)
    {
      x.h();
    }
    return false;
  }

  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c(paramContext).getWritableDatabase();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put(z[6], paramString1);
      localContentValues.put(z[7], paramString2);
      long l = localSQLiteDatabase.insert(z[5], z[1], localContentValues);
      return l > 0L;
    }
    catch (Exception localException)
    {
      x.h();
    }
    return false;
  }

  public static Cursor b(Context paramContext)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c(paramContext).getWritableDatabase();
      String str = z[0];
      String[] arrayOfString = new String[2];
      arrayOfString[0] = z[1];
      arrayOfString[1] = z[2];
      Cursor localCursor = localSQLiteDatabase.query(str, arrayOfString, null, null, null, null, z[1]);
      return localCursor;
    }
    catch (Exception localException)
    {
      x.h();
    }
    return null;
  }

  public static boolean b(Context paramContext, int paramInt)
  {
    try
    {
      int i = c(paramContext).getWritableDatabase().delete(z[0], z[3] + paramInt, null);
      boolean bool = false;
      if (i > 0)
        bool = true;
      return bool;
    }
    catch (Exception localException)
    {
      x.h();
    }
    return false;
  }

  private static r c(Context paramContext)
  {
    if (a == null)
      a = new r(paramContext);
    return a;
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    x.d();
    paramSQLiteDatabase.execSQL(z[13]);
    paramSQLiteDatabase.execSQL(z[12]);
  }

  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 11)
      super.onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
    new StringBuilder(z[10]).append(paramInt1).append(z[8]).append(paramInt2).toString();
    x.c();
    paramSQLiteDatabase.execSQL(z[9]);
    paramSQLiteDatabase.execSQL(z[11]);
    onCreate(paramSQLiteDatabase);
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    new StringBuilder(z[10]).append(paramInt1).append(z[8]).append(paramInt2).toString();
    x.c();
    paramSQLiteDatabase.execSQL(z[9]);
    paramSQLiteDatabase.execSQL(z[11]);
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.r
 * JD-Core Version:    0.6.2
 */