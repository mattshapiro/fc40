package cn.jpush.android.data;

import cn.jpush.android.util.ai;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public class JPushLocalNotification
  implements Serializable
{
  private static final String[] z;
  private int a = 1;
  private String b = "";
  private String c = z[0];
  private String d = z[0];
  private long e = 0L;
  private String f;
  private String g;
  private String h;
  private long i;
  private long j = 1L;
  private int k = 1;
  private String l = "";
  private String m = "";

  static
  {
    Object localObject1 = new String[13];
    int n = 0;
    String str1 = "\002?";
    int i1 = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int i2 = localObject3.length;
    int i3 = 0;
    label36: Object localObject4;
    int i4;
    int i5;
    Object localObject5;
    label52: int i6;
    int i7;
    if (i2 <= 1)
    {
      localObject4 = localObject3;
      i4 = i3;
      i5 = i2;
      localObject5 = localObject3;
      i6 = localObject5[i3];
      switch (i4 % 5)
      {
      default:
        i7 = 91;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[i3] = ((char)(i7 ^ i6));
      i3 = i4 + 1;
      if (i5 == 0)
      {
        localObject5 = localObject4;
        i4 = i3;
        i3 = i5;
        break label52;
      }
      i2 = i5;
      localObject3 = localObject4;
      if (i2 > i3)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (i1)
      {
      default:
        localObject1[n] = str2;
        n = 1;
        str1 = "\\`\036=[l\0134\\P\036o+W";
        localObject1 = localObject2;
        i1 = 0;
        break;
      case 0:
        localObject1[n] = str2;
        n = 2;
        str1 = "]y\017d)[k\017I6Ah5?";
        i1 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[n] = str2;
        n = 3;
        str1 = "\\P\036/^j";
        i1 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[n] = str2;
        n = 4;
        str1 = "Ag\005a\004Fv\032s";
        i1 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[n] = str2;
        n = 5;
        str1 = "_|\rI2V";
        i1 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[n] = str2;
        n = 6;
        str1 = "_P\ty5Fj\004b";
        i1 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[n] = str2;
        n = 7;
        str1 = "\\P\bc2^k\017d\004[k";
        i1 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[n] = str2;
        n = 8;
        str1 = "Q`\004b>\\{5b\"Bj";
        i1 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[n] = str2;
        n = 9;
        str1 = "\\P\017n/@n\031";
        i1 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[n] = str2;
        n = 10;
        str1 = "Sk5b";
        i1 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[n] = str2;
        n = 11;
        str1 = "\\P\ty5Fj\004b";
        i1 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[n] = str2;
        n = 12;
        str1 = "\\P\005x7K";
        i1 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[n] = str2;
        z = localObject2;
        return;
        i7 = 50;
        continue;
        i7 = 15;
        continue;
        i7 = 106;
        continue;
        i7 = 22;
      }
    }
  }

  private static void a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    if (!ai.a(paramString2))
      paramJSONObject.put(paramString1, paramString2);
  }

  public boolean equals(Object paramObject)
  {
    return this.j == ((JPushLocalNotification)paramObject).j;
  }

  public long getBroadcastTime()
  {
    return this.e;
  }

  public long getBuilderId()
  {
    return this.i;
  }

  public String getContent()
  {
    return this.f;
  }

  public String getExtras()
  {
    return this.h;
  }

  public long getNotificationId()
  {
    return this.j;
  }

  public String getTitle()
  {
    return this.g;
  }

  public int hashCode()
  {
    return this.j.hashCode();
  }

  public void setBroadcastTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance();
    int i2;
    int i1;
    int i3;
    label72: int i4;
    label81: Date localDate;
    if (paramInt1 <= localCalendar.get(1))
    {
      paramInt1 = localCalendar.get(1);
      if (paramInt2 - 1 <= localCalendar.get(2))
      {
        n = localCalendar.get(2);
        if (paramInt3 <= localCalendar.get(5))
        {
          i2 = localCalendar.get(5);
          i1 = paramInt1;
        }
      }
      while (true)
      {
        if (paramInt4 <= 0)
          break label203;
        i3 = paramInt4;
        if (paramInt5 <= 0)
          break label197;
        i4 = paramInt5;
        int i5 = 0;
        if (paramInt6 > 0)
          i5 = paramInt6;
        localCalendar.set(i1, n, i2, i3, i4, i5);
        localDate = localCalendar.getTime();
        long l1 = System.currentTimeMillis();
        if (localDate.getTime() >= l1)
          break;
        this.e = l1;
        return;
        i2 = paramInt3;
        i1 = paramInt1;
        continue;
        n = paramInt2 - 1;
        if (paramInt3 <= 0)
          break label209;
        i2 = paramInt3;
        i1 = paramInt1;
      }
    }
    if (paramInt2 > 0);
    for (int n = paramInt2; ; n = 0)
    {
      if (paramInt3 > 0)
      {
        i2 = paramInt3;
        i1 = paramInt1;
        break;
        this.e = localDate.getTime();
        return;
        label197: i4 = 0;
        break label81;
        label203: i3 = 0;
        break label72;
      }
      label209: i1 = paramInt1;
      i2 = 0;
      break;
    }
  }

  public void setBroadcastTime(long paramLong)
  {
    this.e = paramLong;
  }

  public void setBroadcastTime(Date paramDate)
  {
    this.e = paramDate.getTime();
  }

  public void setBuilderId(long paramLong)
  {
    this.i = paramLong;
  }

  public void setContent(String paramString)
  {
    this.f = paramString;
  }

  public void setExtras(String paramString)
  {
    this.h = paramString;
  }

  public void setNotificationId(long paramLong)
  {
    this.j = paramLong;
  }

  public void setTitle(String paramString)
  {
    this.g = paramString;
  }

  public String toJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (!ai.a(this.h))
      {
        JSONObject localJSONObject3 = new JSONObject(this.h);
        localJSONObject2.put(z[9], localJSONObject3);
      }
      a(z[11], this.f, localJSONObject2);
      a(z[3], this.g, localJSONObject2);
      a(z[11], this.f, localJSONObject2);
      localJSONObject2.put(z[10], 0);
      localJSONObject1.put(z[6], localJSONObject2);
      a(z[5], this.j, localJSONObject1);
      a(z[8], this.m, localJSONObject1);
      a(z[2], this.l, localJSONObject1);
      localJSONObject1.put(z[12], this.k);
      localJSONObject1.put(z[7], this.i);
      localJSONObject1.put(z[4], 3);
      localJSONObject1.put(z[1], 1);
      return localJSONObject1.toString();
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.data.JPushLocalNotification
 * JD-Core Version:    0.6.2
 */