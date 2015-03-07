package cn.jpush.android.a;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import cn.jpush.android.util.x;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static final String[] z;
  private int a;
  private int b;
  private int c;
  private boolean d;
  private boolean e;
  private int f;
  private double g;
  private PhoneStateListener h;
  private double i;
  private int j;
  private int k;
  private int l;
  private int m;
  private TelephonyManager n;
  private boolean o;
  private String p;
  private ArrayList<a> q = new ArrayList();

  static
  {
    Object localObject1 = new String[14];
    int i1 = 0;
    String str1 = "{['B";
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
        i8 = 12;
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
        str1 = "hW%Mi";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "yQ.Qcq[dSijR#PqP$\rM[|\017p_G|\005b^Kz\025oC[~\036jCV";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "Z>amkZ\031WmlV%M@wQ-Jxm[/";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "Z>amkZ\031WmlV%M@yK#Wy|Z";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "Z>amkZ\031WmlV%ME|";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "Z>pukK/NE|";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        i1 = 7;
        str1 = "Z>milH%QgQ[";
        i2 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i1] = str2;
        i1 = 8;
        str1 = "kV-Mmt`9W~}Q-Wd";
        i2 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i1] = str2;
        i1 = 9;
        str1 = "uP(J`}`$FxoP8HS{P.F";
        i2 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i1] = str2;
        i1 = 10;
        str1 = "yX/";
        i2 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i1] = str2;
        i1 = 11;
        str1 = "tP)BxqP$|mjZ+|ow[/";
        i2 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i1] = str2;
        i1 = 12;
        str1 = "uP(J`}`)LyvK8ZS{P.F";
        i2 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i1] = str2;
        i1 = 13;
        str1 = "{Z&OSq[";
        i2 = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i1] = str2;
        z = localObject2;
        return;
        i8 = 24;
        continue;
        i8 = 63;
        continue;
        i8 = 74;
        continue;
        i8 = 35;
      }
    }
  }

  public b(Context paramContext)
  {
    if (!cn.jpush.android.util.a.c(paramContext, z[2]))
      return;
    this.h = new c(this);
    this.n = ((TelephonyManager)paramContext.getSystemService(z[1]));
    this.n.listen(this.h, 18);
  }

  private String h()
  {
    CellLocation localCellLocation = this.n.getCellLocation();
    try
    {
      String str = this.n.getNetworkOperator();
      int i1 = str.length();
      if (i1 != 5)
        if (i1 == 6);
      while (this.n.getPhoneType() == 2)
      {
        this.o = true;
        if ((!(localCellLocation instanceof CdmaCellLocation)) || (localCellLocation == null))
          break;
        CdmaCellLocation localCdmaCellLocation = (CdmaCellLocation)localCellLocation;
        this.g = (localCdmaCellLocation.getBaseStationLatitude() / 14400.0D);
        this.i = (localCdmaCellLocation.getBaseStationLongitude() / 14400.0D);
        this.m = localCdmaCellLocation.getSystemId();
        this.b = localCdmaCellLocation.getBaseStationId();
        this.l = localCdmaCellLocation.getNetworkId();
        new StringBuilder().append(this.m).toString();
        x.d();
        new StringBuilder().append(this.b).toString();
        x.d();
        new StringBuilder().append(this.l).toString();
        x.d();
        a locala = new a();
        locala.a(this.b);
        locala.d(this.l);
        locala.c(this.m);
        locala.b(Integer.parseInt(str.substring(0, 3)));
        locala.a(z[0]);
        this.q.add(locala);
        new StringBuilder().append(locala.a()).toString();
        x.c();
        this.p = locala.toString();
        return this.p;
        this.j = Integer.parseInt(str.substring(0, 3));
        this.k = Integer.parseInt(str.substring(3, i1));
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private int i()
  {
    if (!this.o)
      j();
    return this.c;
  }

  private void j()
  {
    this.e = false;
    this.d = false;
    this.c = 0;
    this.f = 0;
    this.j = 0;
    this.k = 0;
    CellLocation localCellLocation = this.n.getCellLocation();
    if (localCellLocation == null)
      return;
    if ((this.n.getPhoneType() == 1) && ((localCellLocation instanceof GsmCellLocation)))
    {
      this.e = true;
      GsmCellLocation localGsmCellLocation = (GsmCellLocation)localCellLocation;
      int i2 = localGsmCellLocation.getCid();
      if ((i2 > 0) && (i2 != 65535))
      {
        this.c = i2;
        this.f = localGsmCellLocation.getLac();
      }
    }
    while (true)
    {
      String str;
      int i1;
      try
      {
        str = this.n.getNetworkOperator();
        i1 = str.length();
        if (i1 != 5)
        {
          if ((i1 != 6) && (this.n.getPhoneType() != 2))
            break;
          if (!(localCellLocation instanceof CdmaCellLocation))
            break label433;
          if (localCellLocation == null)
            break;
          CdmaCellLocation localCdmaCellLocation = (CdmaCellLocation)localCellLocation;
          this.g = (localCdmaCellLocation.getBaseStationLatitude() / 14400.0D);
          this.i = (localCdmaCellLocation.getBaseStationLongitude() / 14400.0D);
          this.m = localCdmaCellLocation.getSystemId();
          this.b = localCdmaCellLocation.getBaseStationId();
          this.l = localCdmaCellLocation.getNetworkId();
          new StringBuilder().append(this.m).toString();
          x.d();
          new StringBuilder().append(this.b).toString();
          x.d();
          new StringBuilder().append(this.l).toString();
          x.d();
          a locala = new a();
          locala.a(this.b);
          locala.d(this.l);
          locala.c(this.m);
          if ((str != null) && (str.length() >= 3))
            locala.b(Integer.parseInt(str.substring(0, 3)));
          locala.a(z[0]);
          this.q.add(locala);
          new StringBuilder().append(locala.a()).toString();
          x.c();
          this.p = locala.toString();
          this.d = true;
          return;
        }
      }
      catch (Exception localException)
      {
        x.j();
        return;
      }
      this.j = Integer.parseInt(str.substring(0, 3));
      this.k = Integer.parseInt(str.substring(3, i1));
    }
    label433: Class localClass = localCellLocation.getClass();
    Class[] arrayOfClass = new Class[0];
    Method localMethod1 = localClass.getMethod(z[5], arrayOfClass);
    Method localMethod2 = localClass.getMethod(z[6], arrayOfClass);
    Method localMethod3 = localClass.getMethod(z[7], arrayOfClass);
    Object[] arrayOfObject = new Object[0];
    this.b = ((Integer)localMethod1.invoke(localCellLocation, arrayOfObject)).intValue();
    this.m = ((Integer)localMethod2.invoke(localCellLocation, arrayOfObject)).intValue();
    this.l = ((Integer)localMethod3.invoke(localCellLocation, arrayOfObject)).intValue();
    Method localMethod4 = localClass.getMethod(z[4], arrayOfClass);
    Method localMethod5 = localClass.getMethod(z[3], arrayOfClass);
    this.g = ((Integer)localMethod4.invoke(localCellLocation, arrayOfObject)).intValue();
    this.i = ((Integer)localMethod5.invoke(localCellLocation, arrayOfObject)).intValue();
    this.d = true;
  }

  public final int a()
  {
    if (!this.o)
      j();
    return this.b;
  }

  public final JSONArray b()
  {
    CellLocation localCellLocation = this.n.getCellLocation();
    try
    {
      String str = this.n.getNetworkOperator();
      int i1 = str.length();
      if (i1 != 5)
        if (i1 == 6);
      while (this.n.getPhoneType() == 2)
      {
        this.o = true;
        if ((!(localCellLocation instanceof CdmaCellLocation)) || (localCellLocation == null))
          break;
        CdmaCellLocation localCdmaCellLocation = (CdmaCellLocation)localCellLocation;
        this.g = (localCdmaCellLocation.getBaseStationLatitude() / 14400.0D);
        this.i = (localCdmaCellLocation.getBaseStationLongitude() / 14400.0D);
        this.m = localCdmaCellLocation.getSystemId();
        this.b = localCdmaCellLocation.getBaseStationId();
        this.l = localCdmaCellLocation.getNetworkId();
        new StringBuilder().append(this.m).toString();
        x.d();
        new StringBuilder().append(this.b).toString();
        x.d();
        new StringBuilder().append(this.l).toString();
        x.d();
        a locala = new a();
        locala.a(this.b);
        locala.d(this.l);
        locala.c(this.m);
        locala.b(Integer.parseInt(str.substring(0, 3)));
        locala.a(z[0]);
        this.q.add(locala);
        return locala.b();
        this.j = Integer.parseInt(str.substring(0, 3));
        this.k = Integer.parseInt(str.substring(3, i1));
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public final JSONArray c()
  {
    JSONArray localJSONArray1 = new JSONArray();
    int[] arrayOfInt = d();
    if (!this.o)
      j();
    double d1 = this.f;
    if (!this.o)
      j();
    int i1 = this.j;
    if (!this.o)
      j();
    int i2 = this.k;
    if ((arrayOfInt == null) || (arrayOfInt.length < 2))
    {
      arrayOfInt = new int[2];
      arrayOfInt[0] = this.c;
      arrayOfInt[1] = -60;
    }
    int i3 = 0;
    while (true)
      if (((i3 < arrayOfInt.length) && (i3 <= 4)) || (e()))
        try
        {
          JSONObject localJSONObject1 = new JSONObject(h());
          JSONArray localJSONArray2 = new JSONArray().put(localJSONObject1);
          return localJSONArray2;
          int i4 = i3 + 1;
          int i5;
          if ((i4 >= 0) && (i4 <= 31))
            i5 = -113 + i4 * 2;
          try
          {
            while (true)
            {
              JSONObject localJSONObject2 = new JSONObject();
              localJSONObject2.put(z[13], arrayOfInt[i3]);
              localJSONObject2.put(z[11], d1);
              localJSONObject2.put(z[12], i1);
              localJSONObject2.put(z[9], i2);
              localJSONObject2.put(z[8], i5);
              localJSONObject2.put(z[10], 0);
              localJSONArray1.put(localJSONObject2);
              i3 += 2;
              break;
              i5 = 0;
            }
          }
          catch (Exception localException)
          {
            while (true)
            {
              localException.getMessage();
              x.f();
            }
          }
        }
        catch (JSONException localJSONException)
        {
        }
    return localJSONArray1;
  }

  public final int[] d()
  {
    if (i() == 0)
      return new int[0];
    List localList = this.n.getNeighboringCellInfo();
    if ((localList == null) || (localList.size() == 0))
    {
      int[] arrayOfInt1 = new int[1];
      arrayOfInt1[0] = i();
      return arrayOfInt1;
    }
    int[] arrayOfInt2 = new int[2 + 2 * localList.size()];
    arrayOfInt2[0] = i();
    arrayOfInt2[1] = this.a;
    Iterator localIterator = localList.iterator();
    int i1 = 2;
    while (localIterator.hasNext())
    {
      NeighboringCellInfo localNeighboringCellInfo = (NeighboringCellInfo)localIterator.next();
      int i2 = localNeighboringCellInfo.getCid();
      if ((i2 > 0) && (i2 != 65535))
      {
        int i3 = i1 + 1;
        arrayOfInt2[i1] = i2;
        i1 = i3 + 1;
        arrayOfInt2[i3] = localNeighboringCellInfo.getRssi();
      }
    }
    int[] arrayOfInt3 = new int[i1];
    System.arraycopy(arrayOfInt2, 0, arrayOfInt3, 0, i1);
    return arrayOfInt3;
  }

  public final boolean e()
  {
    if (!this.o)
      j();
    return this.d;
  }

  public final boolean f()
  {
    if (!this.o)
      j();
    return this.e;
  }

  public final float g()
  {
    if (e());
    while (!f())
      return 1.065353E+09F;
    d();
    return 1.065353E+09F;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.b
 * JD-Core Version:    0.6.2
 */