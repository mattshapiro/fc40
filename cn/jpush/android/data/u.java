package cn.jpush.android.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.jpush.android.util.x;

public final class u
{
  public static final String[] a = localObject2;
  private static final String[] z;
  private Context b;
  private v c;
  private SQLiteDatabase d;

  static
  {
    Object localObject1 = new String[19];
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
        i3 = 112;
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
        str1 = "";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "/\0066\035\0215\036\f\037";
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
        str1 = "/\027\005\036\023(R:.=t";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "/\0066\017\037(\023\005";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "6\002\034\b\030\003\001\035\032\0045\001\035\022\023/";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "/\0066\b\037.\0066\020\025%ON";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "/\0066\025\025(";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "/\0066\030\037)\034\035$A";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "/\0066\030\037)\034\035$C\003CY";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "/\0066\030\037)\034\035$Al";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "/\0066\030\037)\034\035$A\003A";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "/\0066\027\037?\023\005$\0242\001";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "/\0066\b\037.\0066\020\025%";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        z = localObject2;
        localObject1 = new String[12];
        localObject1[0] = z[18];
        i = 1;
        str1 = "\003\033\r";
        j = 18;
        localObject2 = localObject1;
        break;
        i3 = 92;
        continue;
        i3 = 114;
        continue;
        i3 = 105;
        continue;
        i3 = 123;
      case 18:
      }
    }
    localObject1[i] = str2;
    localObject2[2] = z[11];
    localObject2[3] = z[17];
    localObject2[4] = z[16];
    localObject2[5] = z[10];
    localObject2[6] = z[4];
    localObject2[7] = z[7];
    localObject2[8] = z[12];
    localObject2[9] = z[15];
    localObject2[10] = z[13];
    localObject2[11] = z[14];
  }

  public u(Context paramContext)
  {
    this.b = paramContext;
  }

  public static w a(Cursor paramCursor)
  {
    if ((paramCursor == null) || (paramCursor.getCount() == 0))
    {
      x.c();
      return null;
    }
    w localw = new w();
    localw.a(paramCursor.getString(1));
    localw.b(paramCursor.getString(2));
    localw.c(paramCursor.getString(3));
    localw.d(paramCursor.getString(4));
    localw.e(paramCursor.getString(5));
    localw.a(paramCursor.getInt(6));
    localw.b(paramCursor.getInt(7));
    localw.c(paramCursor.getInt(8));
    localw.d(paramCursor.getInt(9));
    localw.e(paramCursor.getInt(10));
    localw.f(paramCursor.getInt(11));
    localw.toString();
    x.d();
    return localw;
  }

  public final int a(boolean paramBoolean)
  {
    String str1 = z[4];
    if (paramBoolean)
      str1 = z[7];
    String str2 = z[6] + str1 + z[5];
    Cursor localCursor = this.d.rawQuery(str2, null);
    if (localCursor != null)
    {
      localCursor.moveToFirst();
      int i = localCursor.getInt(0);
      localCursor.close();
      return i;
    }
    return 0;
  }

  public final long a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(z[18], paramString1);
    localContentValues.put(z[11], paramString2);
    localContentValues.put(z[17], paramString3);
    localContentValues.put(z[16], paramString4);
    localContentValues.put(z[10], paramString5);
    localContentValues.put(z[4], Integer.valueOf(paramInt1));
    localContentValues.put(z[7], Integer.valueOf(1));
    localContentValues.put(z[12], Integer.valueOf(paramInt3));
    localContentValues.put(z[15], Integer.valueOf(paramInt4));
    localContentValues.put(z[13], Integer.valueOf(paramInt5));
    localContentValues.put(z[14], Integer.valueOf(0));
    return this.d.insert(z[8], null, localContentValues);
  }

  public final void a()
  {
    this.c = new v(this.b);
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

  public final boolean a(String paramString)
  {
    String str = z[1];
    String[] arrayOfString = { paramString };
    Cursor localCursor = this.d.rawQuery(str, arrayOfString);
    if (localCursor != null)
      localCursor.moveToFirst();
    return localCursor.getInt(0) != 0;
  }

  public final Cursor b(String paramString)
  {
    String str = z[9] + paramString + "'";
    Cursor localCursor = this.d.query(true, z[8], a, str, null, null, null, null, null);
    if (localCursor != null)
      localCursor.moveToFirst();
    return localCursor;
  }

  public final void b()
  {
    this.d.close();
  }

  public final boolean b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    String str = z[9] + paramString1 + "'";
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(z[18], paramString1);
    localContentValues.put(z[11], paramString2);
    localContentValues.put(z[17], paramString3);
    localContentValues.put(z[16], paramString4);
    localContentValues.put(z[10], paramString5);
    localContentValues.put(z[4], Integer.valueOf(paramInt1));
    localContentValues.put(z[7], Integer.valueOf(paramInt2));
    localContentValues.put(z[12], Integer.valueOf(paramInt3));
    localContentValues.put(z[15], Integer.valueOf(paramInt4));
    localContentValues.put(z[13], Integer.valueOf(paramInt5));
    localContentValues.put(z[14], Integer.valueOf(paramInt6));
    return this.d.update(z[8], localContentValues, str, null) > 0;
  }

  public final void c()
  {
    String str = z[0];
    this.d.execSQL(str);
  }

  public final Cursor d()
  {
    String str = z[2];
    Cursor localCursor = this.d.rawQuery(str, null);
    if (localCursor != null)
      localCursor.moveToFirst();
    return localCursor;
  }

  public final Cursor e()
  {
    String str = z[3];
    Cursor localCursor = this.d.rawQuery(str, null);
    if (localCursor != null)
      localCursor.moveToFirst();
    return localCursor;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.u
 * JD-Core Version:    0.6.2
 */