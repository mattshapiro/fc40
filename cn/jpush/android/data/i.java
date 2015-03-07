package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.util.x;

public final class i
{
  public static final String[] a = localObject2;
  private static final String[] z;
  private Context b;
  private j c;
  private SQLiteDatabase d;

  static
  {
    Object localObject1 = new String[15];
    int i = 0;
    String str1 = "\004\r8vm\f<\023~d\r";
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
        i3 = 9;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    String str2;
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
      str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "\004\r8rq\034\021\006";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "\004\r8cp\030\006";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "\004\r8el\005\f\021r";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "\034<\013xj\t\017\tx}\001\005\016th\034\n\by";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\004\r8tf\035\r\023";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "\004\r8~m";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "\004\r8~mU";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "US";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "H\002\ts)\004\r8cp\030\006";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "";
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
        str1 = "\004\r8tf\035\r\023)9";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "\004\r8tf\035\r\023*";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        z = localObject2;
        localObject1 = new String[8];
        str1 = "7\n\003";
        j = 14;
        localObject2 = localObject1;
        i = 0;
        break;
        i3 = 104;
        continue;
        i3 = 99;
        continue;
        i3 = 103;
        continue;
        i3 = 23;
      case 14:
      }
    }
    localObject1[i] = str2;
    localObject2[1] = z[7];
    localObject2[2] = z[5];
    localObject2[3] = z[3];
    localObject2[4] = z[2];
    localObject2[5] = z[1];
    localObject2[6] = z[6];
    localObject2[7] = z[0];
  }

  public i(Context paramContext)
  {
    this.b = paramContext;
  }

  public static void a(Cursor paramCursor, k paramk)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0))
    {
      x.c();
      return;
    }
    if (paramk == null)
      paramk = new k();
    paramk.a(paramCursor.getInt(1));
    paramk.b(paramCursor.getInt(2));
    paramk.c(paramCursor.getInt(3));
    paramk.d(paramCursor.getInt(4));
    paramk.a(paramCursor.getString(5));
    paramk.b(paramCursor.getLong(6));
    paramk.a(paramCursor.getLong(7));
    paramk.toString();
    x.d();
  }

  public final long a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong2, long paramLong3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(z[7], Long.valueOf(paramLong1));
    localContentValues.put(z[5], Integer.valueOf(1));
    localContentValues.put(z[3], Integer.valueOf(0));
    localContentValues.put(z[2], Integer.valueOf(0));
    localContentValues.put(z[1], paramString);
    localContentValues.put(z[6], Long.valueOf(paramLong2));
    localContentValues.put(z[0], Long.valueOf(paramLong3));
    return this.d.insert(z[4], null, localContentValues);
  }

  public final Cursor a(int paramInt, long paramLong)
  {
    String str = z[14] + 1 + z[11] + "<" + paramLong;
    Cursor localCursor = this.d.query(true, z[4], a, str, null, null, null, null, null);
    if (localCursor != null)
      localCursor.moveToFirst();
    return localCursor;
  }

  public final Cursor a(long paramLong, int paramInt)
  {
    String str = z[8] + paramLong + z[10] + z[9];
    Cursor localCursor = this.d.query(true, z[4], a, str, null, null, null, null, null);
    if (localCursor != null)
      localCursor.moveToFirst();
    return localCursor;
  }

  public final Cursor a(long paramLong1, long paramLong2)
  {
    long l = 300000L + paramLong1;
    String str = z[12] + l + z[11] + ">" + paramLong1;
    Cursor localCursor = this.d.query(true, z[4], a, str, null, null, null, null, null);
    if (localCursor != null)
      localCursor.moveToFirst();
    return localCursor;
  }

  public final void a()
  {
    this.c = new j(this.b);
    try
    {
      this.d = this.c.getWritableDatabase();
      return;
    }
    catch (Exception localException)
    {
      this.d = this.c.getReadableDatabase();
    }
  }

  public final void b()
  {
    this.d.close();
  }

  public final boolean b(long paramLong1, int paramInt1, int paramInt2, int paramInt3, String paramString, long paramLong2, long paramLong3)
  {
    String str = z[8] + paramLong1;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(z[7], Long.valueOf(paramLong1));
    localContentValues.put(z[5], Integer.valueOf(paramInt1));
    localContentValues.put(z[3], Integer.valueOf(paramInt2));
    localContentValues.put(z[2], Integer.valueOf(0));
    localContentValues.put(z[1], paramString);
    localContentValues.put(z[6], Long.valueOf(paramLong2));
    localContentValues.put(z[0], Long.valueOf(paramLong3));
    return this.d.update(z[4], localContentValues, str, null) > 0;
  }

  public final boolean c()
  {
    String str = z[13];
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(z[5], Integer.valueOf(0));
    localContentValues.put(z[3], Integer.valueOf(1));
    localContentValues.put(z[2], Integer.valueOf(0));
    return this.d.update(z[4], localContentValues, str, null) > 0;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.i
 * JD-Core Version:    0.6.2
 */