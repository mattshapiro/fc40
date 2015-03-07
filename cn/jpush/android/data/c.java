package cn.jpush.android.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import cn.jpush.android.util.x;

public final class c extends SQLiteOpenHelper
{
  public static final String[] a;
  public static final String[] b = localObject2;
  private static c c;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[13];
    int i = 0;
    String str1 = "m\027\"c\025hZm";
    int j = -1;
    Object localObject2 = localObject1;
    label36: label52: String str2;
    while (true)
    {
      Object localObject3 = str1.toCharArray();
      int k = localObject3.length;
      int m = 0;
      Object localObject4;
      int n;
      int i1;
      Object localObject5;
      int i2;
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
          i3 = 124;
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
        str2 = new String((char[])localObject3).intern();
        switch (j)
        {
        default:
          localObject1[i] = str2;
          i = 1;
          str1 = "m\027\"c\025h";
          localObject1 = localObject2;
          j = 0;
          break;
        case 0:
          localObject1[i] = str2;
          i = 2;
          str1 = "a\006;R#e\003";
          j = 1;
          localObject1 = localObject2;
          break;
        case 1:
          localObject1[i] = str2;
          i = 3;
          str1 = "a\0245c\025h";
          j = 2;
          localObject1 = localObject2;
          break;
        case 2:
          localObject1[i] = str2;
          i = 4;
          str1 = "y\027>U\017x";
          j = 3;
          localObject1 = localObject2;
          break;
        case 3:
          localObject1[i] = str2;
          i = 5;
          str1 = "c\0217N\016e\0037c\025h";
          j = 4;
          localObject1 = localObject2;
          break;
        case 4:
          localObject1[i] = str2;
          i = 6;
          str1 = "\002 J\025o\002|X\036";
          j = 5;
          localObject1 = localObject2;
          break;
        case 5:
          localObject1[i] = str2;
          i = 7;
          str1 = "";
          j = 6;
          localObject1 = localObject2;
          break;
        case 6:
          localObject1[i] = str2;
          i = 8;
          str1 = "o\0257]\biG&]\036`\002rI\f`\016!HTS\0166\034\025b\0237[\031~G\"N\025a\006 E\\g\002+\034\035y\023=U\022o\0257Q\031b\023~Q\017k8;X\\x\002*HPm\027\"c\025hG&Y\004xK?]\025b8;X\\x\002*HP,\b$Y\016~\0166Y#e\003rH\031t\023{";
          j = 7;
          localObject1 = localObject2;
          break;
        case 7:
          localObject1[i] = str2;
          i = 9;
          str1 = "X\0177\034\023`\003\004Y\016\016=R\\e\024h\034";
          j = 8;
          localObject1 = localObject2;
          break;
        case 8:
          localObject1[i] = str2;
          i = 10;
          str1 = "h\025=L\\x\0060P\031,\003=K\022`\016!H";
          j = 9;
          localObject1 = localObject2;
          break;
        case 9:
          localObject1[i] = str2;
          i = 11;
          str1 = "h\025=L\\x\0060P\031,\022\"P\025\023";
          j = 10;
          localObject1 = localObject2;
          break;
        case 10:
          localObject1[i] = str2;
          i = 12;
          str1 = ",\023:Y\\b\002%j\031~\024;S\022,\016!\034F,";
          j = 11;
          localObject1 = localObject2;
          break;
        case 11:
          localObject1[i] = str2;
          z = localObject2;
          localObject1 = new String[6];
          str1 = "S\0166";
          j = 12;
          localObject2 = localObject1;
          i = 0;
          break;
          i3 = 12;
          continue;
          i3 = 103;
          continue;
          i3 = 82;
          continue;
          i3 = 60;
        case 12:
        case 13:
        case 14:
        case 15:
        case 16:
        case 17:
        }
      }
      localObject1[i] = str2;
      localObject2[1] = z[3];
      i = 2;
      str1 = "~\002\"Y\035x8<I\021";
      j = 13;
      localObject1 = localObject2;
      continue;
      localObject1[i] = str2;
      i = 3;
      str1 = "\0233N\bS\027=O";
      j = 14;
      localObject1 = localObject2;
      continue;
      localObject1[i] = str2;
      i = 4;
      str1 = "i\t6c\fc\024";
      j = 15;
      localObject1 = localObject2;
      continue;
      localObject1[i] = str2;
      i = 5;
      str1 = "o\b<H\031b\023";
      j = 16;
      localObject1 = localObject2;
      continue;
      localObject1[i] = str2;
      a = localObject2;
      localObject1 = new String[4];
      str1 = "S\0166";
      j = 17;
      localObject2 = localObject1;
      i = 0;
    }
    localObject1[i] = str2;
    localObject2[1] = z[3];
    localObject2[2] = z[1];
    localObject2[3] = z[2];
  }

  private c(Context paramContext)
  {
    super(paramContext, z[6], null, 3);
  }

  private static c a(Context paramContext)
  {
    if (c == null)
      c = new c(paramContext);
    return c;
  }

  // ERROR //
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 82	cn/jpush/android/data/c:a	(Landroid/content/Context;)Lcn/jpush/android/data/c;
    //   4: invokevirtual 86	cn/jpush/android/data/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   12: iconst_4
    //   13: aaload
    //   14: getstatic 68	cn/jpush/android/data/c:b	[Ljava/lang/String;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 7
    //   27: aload 7
    //   29: astore 4
    //   31: aload 4
    //   33: ifnull +280 -> 313
    //   36: aload 4
    //   38: invokeinterface 98 1 0
    //   43: iflt +270 -> 313
    //   46: aload 4
    //   48: invokeinterface 102 1 0
    //   53: ifeq +260 -> 313
    //   56: aload 4
    //   58: aload 4
    //   60: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   63: iconst_1
    //   64: aaload
    //   65: invokeinterface 106 2 0
    //   70: invokeinterface 110 2 0
    //   75: astore 16
    //   77: aload 4
    //   79: aload 4
    //   81: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   84: iconst_3
    //   85: aaload
    //   86: invokeinterface 106 2 0
    //   91: invokeinterface 110 2 0
    //   96: astore 17
    //   98: aload 4
    //   100: aload 4
    //   102: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   105: iconst_2
    //   106: aaload
    //   107: invokeinterface 106 2 0
    //   112: invokeinterface 110 2 0
    //   117: astore 18
    //   119: aload 4
    //   121: aload 4
    //   123: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   126: iconst_5
    //   127: aaload
    //   128: invokeinterface 106 2 0
    //   133: invokeinterface 110 2 0
    //   138: astore 19
    //   140: aload_1
    //   141: aload 16
    //   143: invokevirtual 114	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   146: istore 20
    //   148: iload 20
    //   150: ifeq -104 -> 46
    //   153: aload 17
    //   155: astore 11
    //   157: aload 18
    //   159: astore 10
    //   161: aload 16
    //   163: astore 9
    //   165: aload 19
    //   167: astore 8
    //   169: aload_2
    //   170: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   173: iconst_4
    //   174: aaload
    //   175: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   178: iconst_0
    //   179: aaload
    //   180: iconst_1
    //   181: anewarray 14	java/lang/String
    //   184: dup
    //   185: iconst_0
    //   186: aload 9
    //   188: aastore
    //   189: invokevirtual 118	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   192: pop
    //   193: new 120	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   200: aload 11
    //   202: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 128
    //   207: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload 10
    //   212: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 128
    //   217: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload 8
    //   222: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore 14
    //   230: aload 14
    //   232: astore 6
    //   234: aload 4
    //   236: ifnull +10 -> 246
    //   239: aload 4
    //   241: invokeinterface 134 1 0
    //   246: aload 6
    //   248: areturn
    //   249: astore 5
    //   251: aconst_null
    //   252: astore 4
    //   254: ldc 136
    //   256: astore 6
    //   258: aload 4
    //   260: ifnull -14 -> 246
    //   263: aload 4
    //   265: invokeinterface 134 1 0
    //   270: aload 6
    //   272: areturn
    //   273: astore_3
    //   274: aconst_null
    //   275: astore 4
    //   277: aload 4
    //   279: ifnull +10 -> 289
    //   282: aload 4
    //   284: invokeinterface 134 1 0
    //   289: aload_3
    //   290: athrow
    //   291: astore_3
    //   292: goto -15 -> 277
    //   295: astore 15
    //   297: ldc 136
    //   299: astore 6
    //   301: goto -43 -> 258
    //   304: astore 12
    //   306: aload 11
    //   308: astore 6
    //   310: goto -52 -> 258
    //   313: ldc 136
    //   315: astore 8
    //   317: ldc 136
    //   319: astore 9
    //   321: ldc 136
    //   323: astore 10
    //   325: ldc 136
    //   327: astore 11
    //   329: goto -160 -> 169
    //
    // Exception table:
    //   from	to	target	type
    //   8	27	249	java/lang/Exception
    //   8	27	273	finally
    //   36	46	291	finally
    //   46	148	291	finally
    //   169	230	291	finally
    //   36	46	295	java/lang/Exception
    //   46	148	295	java/lang/Exception
    //   169	230	304	java/lang/Exception
  }

  // ERROR //
  public static void a(Context paramContext, d paramd, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 142	cn/jpush/android/data/d:c	Ljava/lang/String;
    //   4: astore 4
    //   6: aload_1
    //   7: getfield 145	cn/jpush/android/data/d:d	Ljava/lang/String;
    //   10: astore 5
    //   12: aload_0
    //   13: invokestatic 82	cn/jpush/android/data/c:a	(Landroid/content/Context;)Lcn/jpush/android/data/c;
    //   16: invokevirtual 86	cn/jpush/android/data/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 6
    //   21: aload 6
    //   23: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   26: iconst_4
    //   27: aaload
    //   28: getstatic 68	cn/jpush/android/data/c:b	[Ljava/lang/String;
    //   31: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   34: iconst_0
    //   35: aaload
    //   36: iconst_1
    //   37: anewarray 14	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_2
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 92	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 11
    //   52: aload 11
    //   54: astore 10
    //   56: aload 10
    //   58: ifnull +13 -> 71
    //   61: aload 10
    //   63: invokeinterface 98 1 0
    //   68: ifgt +85 -> 153
    //   71: new 147	android/content/ContentValues
    //   74: dup
    //   75: invokespecial 148	android/content/ContentValues:<init>	()V
    //   78: astore 12
    //   80: aload 12
    //   82: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   85: iconst_3
    //   86: aaload
    //   87: aload 4
    //   89: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: aload 12
    //   94: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   97: iconst_1
    //   98: aaload
    //   99: aload_2
    //   100: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 12
    //   105: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   108: iconst_2
    //   109: aaload
    //   110: aload_3
    //   111: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aload 12
    //   116: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   119: iconst_5
    //   120: aaload
    //   121: aload 5
    //   123: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 6
    //   128: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   131: iconst_4
    //   132: aaload
    //   133: aconst_null
    //   134: aload 12
    //   136: invokevirtual 156	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   139: pop2
    //   140: aload 10
    //   142: ifnull +10 -> 152
    //   145: aload 10
    //   147: invokeinterface 134 1 0
    //   152: return
    //   153: aload 10
    //   155: invokeinterface 159 1 0
    //   160: pop
    //   161: new 147	android/content/ContentValues
    //   164: dup
    //   165: invokespecial 148	android/content/ContentValues:<init>	()V
    //   168: astore 17
    //   170: aload 17
    //   172: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   175: iconst_3
    //   176: aaload
    //   177: aload 4
    //   179: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 17
    //   184: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   187: iconst_2
    //   188: aaload
    //   189: aload_3
    //   190: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 17
    //   195: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   198: iconst_5
    //   199: aaload
    //   200: aload 5
    //   202: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload 6
    //   207: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   210: iconst_4
    //   211: aaload
    //   212: aload 17
    //   214: getstatic 54	cn/jpush/android/data/c:z	[Ljava/lang/String;
    //   217: iconst_0
    //   218: aaload
    //   219: iconst_1
    //   220: anewarray 14	java/lang/String
    //   223: dup
    //   224: iconst_0
    //   225: aload_2
    //   226: aastore
    //   227: invokevirtual 163	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   230: pop
    //   231: goto -91 -> 140
    //   234: astore 13
    //   236: aload 10
    //   238: astore 8
    //   240: aload 8
    //   242: ifnull -90 -> 152
    //   245: aload 8
    //   247: invokeinterface 134 1 0
    //   252: return
    //   253: astore 9
    //   255: aconst_null
    //   256: astore 10
    //   258: aload 10
    //   260: ifnull +10 -> 270
    //   263: aload 10
    //   265: invokeinterface 134 1 0
    //   270: aload 9
    //   272: athrow
    //   273: astore 9
    //   275: goto -17 -> 258
    //   278: astore 7
    //   280: aconst_null
    //   281: astore 8
    //   283: goto -43 -> 240
    //
    // Exception table:
    //   from	to	target	type
    //   61	71	234	java/lang/Exception
    //   71	140	234	java/lang/Exception
    //   153	231	234	java/lang/Exception
    //   21	52	253	finally
    //   61	71	273	finally
    //   71	140	273	finally
    //   153	231	273	finally
    //   21	52	278	java/lang/Exception
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    x.c();
    paramSQLiteDatabase.execSQL(z[7]);
    paramSQLiteDatabase.execSQL(z[8]);
  }

  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 11)
      super.onDowngrade(paramSQLiteDatabase, paramInt1, paramInt2);
    new StringBuilder(z[9]).append(paramInt1).append(z[12]).append(paramInt2).toString();
    x.c();
    paramSQLiteDatabase.execSQL(z[10]);
    paramSQLiteDatabase.execSQL(z[11]);
    onCreate(paramSQLiteDatabase);
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    new StringBuilder(z[9]).append(paramInt1).append(z[12]).append(paramInt2).toString();
    x.c();
    paramSQLiteDatabase.execSQL(z[10]);
    paramSQLiteDatabase.execSQL(z[11]);
    onCreate(paramSQLiteDatabase);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.c
 * JD-Core Version:    0.6.2
 */