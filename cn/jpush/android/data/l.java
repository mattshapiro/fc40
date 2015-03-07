package cn.jpush.android.data;

import android.content.Context;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.h;
import cn.jpush.android.util.x;
import org.json.JSONObject;

public class l extends d
{
  private static final String[] bb;
  public String W;
  public boolean X;
  public boolean Y;
  public int Z;
  public String a;
  public boolean aa;
  public int ab;
  public String ac;
  public o ad = new o(this);
  public String ae;
  public boolean af;
  public boolean ag = true;
  public String ah;
  public boolean ai;

  static
  {
    Object localObject1 = new String[28];
    int i = 0;
    String str1 = "2]g:\001";
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
        str1 = "";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "2rx\034\0046";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "2re\b\0254HS\020\006?";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "2Xx\n+!";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "\fZi\007$2Ji5\025'E";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "2re\013\022<";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "2]g:\032";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "2r\006\033!H";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "2]g:\0210Bb";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "2rn\027\033 Zi\027";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "2Xx\n+=";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "2]g:\0317\030";
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
        i = 14;
        str1 = "2Xx\n+>";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "\fDa\004\0236}m\021\034";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "2]g:\001!A";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "2]g:\025&Yc:\035=^x\004\030?";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "2re\006\033=ry\027\030";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "2ri\027\021 ";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "2]g:\007;B{";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "2]g:\007;B{:\022:Ce\026\0346IS\013\033'D";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "2Xx\n+!N";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "\fDo\n\032\003Lx\r";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        i = 25;
        str1 = "2ri\020\006?";
        j = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i] = str2;
        i = 26;
        str1 = "2r\f\0166";
        j = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i] = str2;
        i = 27;
        str1 = "";
        j = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i] = str2;
        bb = localObject2;
        return;
        i3 = 83;
        continue;
        i3 = 45;
        continue;
        i3 = 12;
        continue;
        i3 = 101;
      }
    }
  }

  public l()
  {
    this.o = 1;
  }

  public void a(Context paramContext)
  {
    x.b();
    boolean bool = a.f(paramContext, this.a);
    int i = 995;
    if ((!this.X) && (bool))
    {
      x.c();
      ServiceInterface.a(this.c, 997, paramContext);
      return;
    }
    if ((this.X) && (bool))
    {
      x.c();
      i = 998;
    }
    if (this.ab == 1)
    {
      new m(this, this, paramContext, i).start();
      return;
    }
    if (this.ab == 0)
    {
      new n(this, paramContext, i, this).start();
      return;
    }
    new StringBuilder(bb[27]).append(this.ab).toString();
    x.e();
  }

  public boolean a(Context paramContext, JSONObject paramJSONObject)
  {
    x.b();
    this.a = paramJSONObject.optString(bb[7], "");
    boolean bool1;
    boolean bool2;
    label56: boolean bool3;
    label93: boolean bool4;
    if (paramJSONObject.optInt(bb[0], 0) > 0)
    {
      bool1 = true;
      this.X = bool1;
      if (paramJSONObject.optInt(bb[14], 0) <= 0)
        break label249;
      bool2 = true;
      this.Y = bool2;
      this.Z = paramJSONObject.optInt(bb[11], 0);
      if (paramJSONObject.optInt(bb[4], 0) <= 0)
        break label255;
      bool3 = true;
      this.aa = bool3;
      this.ab = paramJSONObject.optInt(bb[21], 1);
      this.ac = paramJSONObject.optString(bb[17], "").trim();
      this.ae = paramJSONObject.optString(bb[12], "");
      this.W = paramJSONObject.optString(bb[23], "");
      if (paramJSONObject.optInt(bb[22], 0) <= 0)
        break label261;
      bool4 = true;
      label182: this.af = bool4;
      if (paramJSONObject.optInt(bb[18], 1) != 1)
        break label267;
    }
    JSONObject localJSONObject;
    label261: label267: for (boolean bool5 = true; ; bool5 = false)
    {
      this.ag = bool5;
      if (this.o != 1)
        break label644;
      localJSONObject = p.a(paramContext, this.c, paramJSONObject, bb[9]);
      if (localJSONObject != null)
        break label273;
      return false;
      bool1 = false;
      break;
      label249: bool2 = false;
      break label56;
      label255: bool3 = false;
      break label93;
      bool4 = false;
      break label182;
    }
    label273: o localo = this.ad;
    x.b();
    localo.a = localJSONObject.optString(bb[13], "");
    localo.b = localJSONObject.optString(bb[19], "").trim();
    localo.c = localJSONObject.optString(bb[16], "");
    localo.d = localJSONObject.optString(bb[2], "");
    boolean bool6;
    l locall;
    if (localJSONObject.optInt(bb[8], 0) == 0)
    {
      bool6 = true;
      localo.e = bool6;
      localo.f = localJSONObject.optString(bb[26], "");
      localo.g = localJSONObject.optString(bb[6], "");
      localo.h = localJSONObject.optString(bb[3], "").trim();
      localo.j = localJSONObject.optString(bb[25], "").trim();
      locall = localo.o;
      if (localJSONObject.optInt(bb[10], 0) != 1)
        break label652;
    }
    label644: label652: for (boolean bool7 = true; ; bool7 = false)
    {
      locall.O = bool7;
      int i = localJSONObject.optInt(bb[1], 0);
      boolean bool8 = false;
      if (i == 0)
        bool8 = true;
      localo.i = bool8;
      if (localo.i)
        localo.k = h.a(localJSONObject.optJSONArray(bb[20]));
      if (ai.a(localo.m))
        localo.m = localJSONObject.optString(bb[15], "").trim();
      if (ai.a(localo.l))
        localo.l = localJSONObject.optString(bb[24], "").trim();
      if (ai.a(localo.l))
        localo.l = localJSONObject.optString(bb[5], "").trim();
      return true;
      bool6 = false;
      break;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.l
 * JD-Core Version:    0.6.2
 */