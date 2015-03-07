package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.k;
import cn.jpush.android.util.m;
import cn.jpush.android.util.n;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class d
  implements Serializable
{
  private static final String[] W;
  public String A;
  public String B;
  public List<d> C;
  public int D = -1;
  public int E;
  public int F;
  public String G;
  public String H;
  public int I;
  public int J;
  public int K;
  public boolean L = false;
  public boolean M = false;
  public boolean N = false;
  public boolean O = false;
  public int P = -1;
  public String Q;
  public ArrayList<String> R = null;
  public String S = "";
  public String T;
  public String U;
  public String V;
  private boolean a = false;
  public int b;
  public String c;
  public String d;
  public boolean e;
  public int f;
  public int g = 0;
  public boolean h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public int o;
  public int p;
  public boolean q;
  public String r;
  public boolean s = false;
  public String t;
  public boolean u = false;
  public List<String> v = null;
  public boolean w;
  public int x;
  public String y;
  public int z;

  static
  {
    Object localObject1 = new String[30];
    int i1 = 0;
    String str1 = "";
    int i2 = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int i3 = localObject3.length;
    int i4 = 0;
    label36: Object localObject4;
    int i5;
    int i6;
    Object localObject5;
    label52: int i7;
    int i8;
    if (i3 <= 1)
    {
      localObject4 = localObject3;
      i5 = i4;
      i6 = i3;
      localObject5 = localObject3;
      i7 = localObject5[i4];
      switch (i5 % 5)
      {
      default:
        i8 = 108;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i4] = ((char)(i8 ^ i7));
      i4 = i5 + 1;
      if (i6 == 0)
      {
        localObject5 = localObject4;
        i5 = i4;
        i4 = i6;
        break label52;
      }
      i3 = i6;
      localObject3 = localObject4;
      if (i3 > i4)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (i2)
      {
      default:
        localObject1[i1] = str2;
        i1 = 1;
        str1 = "wS'H\tABd_\003\004J+J\b\004O)J\013A\006i\013";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "LR0[V\013\t";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "EJ(D\033{E%E\017AJ";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "ME+E";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "EV4t\030]V!";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        i1 = 7;
        str1 = "W_7t\032MC3";
        i2 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i1] = str2;
        i1 = 8;
        str1 = "Jy!S\030VG7";
        i2 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i1] = str2;
        i1 = 9;
        str1 = "Jy\"G\rC";
        i2 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i1] = str2;
        i1 = 10;
        str1 = "@C7@\030KV\033X\004KQ\033_\025TC";
        i2 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i1] = str2;
        i1 = 11;
        str1 = "IG6L\005Jy(N\nP";
        i2 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i1] = str2;
        i1 = 12;
        str1 = "ME+E3QT(";
        i2 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i1] = str2;
        i1 = 13;
        str1 = "\002S-OQ";
        i2 = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i1] = str2;
        i1 = 14;
        str1 = "IU#t\005IA\033^\036H";
        i2 = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i1] = str2;
        i1 = 15;
        str1 = "@C7@\030KV\033X\004KQ\033H\003JR!E\030";
        i2 = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i1] = str2;
        i1 = 16;
        str1 = "Jy'D\002PC*_";
        i2 = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i1] = str2;
        i1 = 17;
        str1 = "EB\033H\003JR!E\030";
        i2 = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i1] = str2;
        i1 = 18;
        str1 = "";
        i2 = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i1] = str2;
        i1 = 19;
        str1 = "IG6L\005Jy0D\034";
        i2 = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i1] = str2;
        i1 = 20;
        str1 = "Ey&Y\003WQ!Y";
        i2 = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i1] = str2;
        i1 = 21;
        str1 = "Jy0B\030HC";
        i2 = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i1] = str2;
        i1 = 22;
        str1 = "MK%L\t{S6G3HO7_";
        i2 = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i1] = str2;
        i1 = 23;
        str1 = "Jy-F\rCC\033^\036H";
        i2 = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i1] = str2;
        i1 = 24;
        str1 = "RO!\\3SO _\004";
        i2 = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i1] = str2;
        i1 = 25;
        str1 = "RO!\\3MK#t\031VJ";
        i2 = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i1] = str2;
        i1 = 26;
        str1 = "VO*L3I";
        i2 = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i1] = str2;
        i1 = 27;
        str1 = "RO!\\3LC-L\004P";
        i2 = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i1] = str2;
        i1 = 28;
        str1 = "BS(G3WE6N\tJ";
        i2 = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i1] = str2;
        i1 = 29;
        str1 = "EE0B\003J\034(D\r@o)L>AUd\006LQT(\021";
        i2 = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[i1] = str2;
        W = localObject2;
        return;
        i8 = 36;
        continue;
        i8 = 38;
        continue;
        i8 = 68;
        continue;
        i8 = 43;
      }
    }
  }

  public static d a(Context paramContext, d paramd)
  {
    String str1;
    int i1;
    if ((paramd.v != null) && (paramd.v.size() > 0))
    {
      paramd.R = new ArrayList();
      Iterator localIterator = paramd.v.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          str1 = (String)localIterator.next();
          if (!ai.a(str1))
          {
            byte[] arrayOfByte = n.a(str1, 5, 5000L, 4);
            if (arrayOfByte != null)
              try
              {
                String str2 = str1.substring(1 + str1.lastIndexOf("/"));
                String str3 = k.a(paramContext, paramd.c) + str2;
                if (m.a(str3, arrayOfByte, paramContext))
                {
                  paramd.R.add(str3);
                  new StringBuilder(W[1]).append(str3).toString();
                  x.b();
                }
              }
              catch (IOException localIOException)
              {
                x.h();
                i1 = 0;
              }
          }
        }
    }
    while (i1 != 0)
    {
      x.d();
      return paramd;
      x.f();
      i1 = 0;
      continue;
      new StringBuilder(W[0]).append(str1).toString();
      x.e();
      ServiceInterface.a(paramd.c, 1020, cn.jpush.android.util.a.b(paramContext, str1), paramContext);
      i1 = 0;
      continue;
      x.f();
      i1 = 0;
      continue;
      i1 = 1;
      continue;
      x.f();
      i1 = 0;
    }
    x.e();
    ServiceInterface.a(paramd.c, 1014, paramContext);
    return null;
  }

  static String a(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    new StringBuilder(W[29]).append(paramString1).toString();
    x.b();
    if ((p.a(paramString1)) && (paramContext != null) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      byte[] arrayOfByte = n.a(paramString1, 5, 5000L, 4);
      if (arrayOfByte != null)
        try
        {
          String str = k.a(paramContext, paramString2) + paramString3;
          m.a(str, arrayOfByte, paramContext);
          new StringBuilder(W[1]).append(str).toString();
          x.b();
          return str;
        }
        catch (IOException localIOException)
        {
          x.j();
          return "";
        }
      ServiceInterface.a(paramString2, 1020, cn.jpush.android.util.a.b(paramContext, paramString1), paramContext);
    }
    return "";
  }

  static boolean a(ArrayList<String> paramArrayList, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool1 = true;
    new StringBuilder(W[2]).append(paramString1).toString();
    x.b();
    boolean bool2;
    String str1;
    if ((p.a(paramString1)) && (paramContext != null) && (paramArrayList.size() > 0) && (!TextUtils.isEmpty(paramString2)))
    {
      Iterator localIterator = paramArrayList.iterator();
      bool2 = bool1;
      if (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        if ((str1 == null) || (str1.startsWith(W[3])))
          break label295;
      }
    }
    label295: for (String str2 = paramString1 + str1; ; str2 = str1)
    {
      byte[] arrayOfByte = n.a(str2, 5, 5000L, 4);
      if (arrayOfByte != null)
        while (true)
        {
          try
          {
            if (str1.startsWith(W[3]))
              str1 = m.c(str1);
            if (paramBoolean)
              break label236;
            localObject = k.a(paramContext, paramString2) + str1;
            m.a((String)localObject, arrayOfByte, paramContext);
            new StringBuilder(W[1]).append((String)localObject).toString();
            x.b();
          }
          catch (IOException localIOException)
          {
            x.h();
            bool2 = false;
          }
          break;
          label236: String str3 = k.b(paramContext, paramString2) + str1;
          Object localObject = str3;
        }
      ServiceInterface.a(paramString2, 1020, cn.jpush.android.util.a.b(paramContext, str2), paramContext);
      bool2 = false;
      break;
      bool1 = bool2;
      return bool1;
    }
  }

  public abstract void a(Context paramContext);

  public final void a(String paramString)
  {
    this.V = paramString;
  }

  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public final boolean a()
  {
    return (this.o == 3) || (this.o == 1);
  }

  protected abstract boolean a(Context paramContext, JSONObject paramJSONObject);

  public final boolean b()
  {
    return this.o == 2;
  }

  public final boolean b(Context paramContext, JSONObject paramJSONObject)
  {
    x.b();
    this.p = paramJSONObject.optInt(W[26], 3);
    boolean bool1;
    if (paramJSONObject.optInt(W[28], 0) > 0)
    {
      bool1 = true;
      this.q = bool1;
      if (paramJSONObject.optInt(W[20], 0) <= 0)
        break label620;
    }
    label550: label620: for (boolean bool2 = true; ; bool2 = false)
    {
      this.O = bool2;
      this.z = paramJSONObject.optInt(W[9], 0);
      this.x = paramJSONObject.optInt(W[5], 1);
      this.y = paramJSONObject.optString(W[12], "");
      this.A = paramJSONObject.optString(W[21], "");
      this.B = paramJSONObject.optString(W[16], "");
      this.r = paramJSONObject.optString(W[23]);
      this.S = paramJSONObject.optString(W[14], "");
      this.l = paramJSONObject.optString(W[8], "");
      JSONObject localJSONObject1 = paramJSONObject.optJSONObject(W[15]);
      if (localJSONObject1 != null)
      {
        x.d();
        this.D = localJSONObject1.optInt(W[10], -1);
        this.E = localJSONObject1.optInt(W[24], -1);
        this.F = localJSONObject1.optInt(W[27], -1);
        this.G = localJSONObject1.optString(W[25]);
        this.I = localJSONObject1.optInt(W[19]);
        this.J = localJSONObject1.optInt(W[11], -2147483648);
        this.K = localJSONObject1.optInt(W[6], 0);
      }
      if (!ai.a(this.S))
        this.B = this.B.replaceAll(W[18], W[13] + cn.jpush.android.util.a.s(paramContext));
      JSONObject localJSONObject2 = paramJSONObject.optJSONObject(W[7]);
      if (localJSONObject2 != null)
        x.d();
      JSONObject localJSONObject3;
      do
      {
        try
        {
          this.t = localJSONObject2.toString();
          JSONArray localJSONArray = localJSONObject2.getJSONArray(W[22]);
          int i1 = localJSONArray.length();
          this.v = new LinkedList();
          for (int i2 = 0; i2 < i1; i2++)
            this.v.add(localJSONArray.getString(i2));
          if (localJSONObject2.optInt(W[4], 1) > 0);
          for (boolean bool3 = true; ; bool3 = false)
          {
            this.w = bool3;
            if (!ai.a(this.A))
              break label550;
            if (this.h)
              break;
            x.c();
            ServiceInterface.a(this.c, 996, paramContext);
            return false;
          }
        }
        catch (Exception localException)
        {
          x.h();
          ServiceInterface.a(this.c, 996, paramContext);
          return false;
        }
        x.c();
        this.A = cn.jpush.android.a.c;
        localJSONObject3 = p.a(paramContext, this.c, paramJSONObject, W[17]);
        if (localJSONObject3 != null)
          break;
      }
      while ((!this.h) || (!this.e));
      return true;
      if ((this.h) && (this.e))
        this.a = true;
      return a(paramContext, localJSONObject3);
      bool1 = false;
      break;
    }
  }

  public final boolean c()
  {
    return this.o == 3;
  }

  public final String d()
  {
    if (a())
      return ((l)this).ac;
    if (b())
      return ((y)this).W;
    if (this.a)
      return this.V;
    return "";
  }

  public final String e()
  {
    if (a())
      return ((l)this).ah;
    if (b())
      return ((y)this).aa;
    return "";
  }

  public final boolean f()
  {
    return this.a;
  }

  public final String g()
  {
    String str2;
    if (a())
    {
      String str3 = ((l)this).ae;
      str2 = null;
      if (str3 != null)
      {
        boolean bool2 = "".equals(str3);
        str2 = null;
        if (!bool2)
          str2 = str3.trim();
      }
    }
    String str1;
    boolean bool1;
    do
    {
      do
      {
        return str2;
        if (!b())
          break;
        str1 = ((y)this).Z;
        str2 = null;
      }
      while (str1 == null);
      bool1 = "".equals(str1);
      str2 = null;
    }
    while (bool1);
    return str1.trim();
    return "";
  }

  public final e h()
  {
    return new e(this, this);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.d
 * JD-Core Version:    0.6.2
 */