package cn.jpush.android.a;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.util.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

final class f extends Handler
{
  private static final String[] z;
  private float b;
  private JSONArray c;

  static
  {
    Object localObject1 = new String[6];
    int i = 0;
    String str1 = "\\QIT\030pCK]>Ugjvv?\024";
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
        i3 = 76;
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
        str1 = "H}cq\030pCK]>Ugjvv?";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "?\n\005";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "?\037\005";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "Oflu\rMm\005{\tSx\005{\004^zb}\b";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "O[VLluGJV";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 31;
        continue;
        i3 = 52;
        continue;
        i3 = 37;
        continue;
        i3 = 56;
      }
    }
  }

  public final void handleMessage(Message paramMessage)
  {
    int i = 1;
    if (d.c(this.a) != this);
    int n;
    int i1;
    int i2;
    int i4;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              switch (paramMessage.what)
              {
              default:
                return;
              case 1:
                this.c = null;
                this.b = 1.4E-45F;
              case 2:
              case 5:
              case 10:
              }
            }
            while (d.d(this.a) != 2);
            JSONArray localJSONArray = d.b(this.a).c();
            d.b(this.a).g();
            if ((localJSONArray != null) && (1.065353E+09F > this.b))
            {
              this.c = localJSONArray;
              this.b = 1.065353E+09F;
            }
            sendEmptyMessageDelayed(2, 600L);
            return;
          }
          while (d.d(this.a) != 2);
          removeMessages(2);
          removeMessages(10);
          d.a(this.a, 3);
          if (d.b(this.a).f())
            d.b(this.a).d();
          d.b(this.a).a();
          JSONArray[] arrayOfJSONArray = new JSONArray[2];
          arrayOfJSONArray[0] = this.c;
          if (d.e(this.a).a())
            arrayOfJSONArray[i] = d.e(this.a).c();
          if (this.c != null)
          {
            new StringBuilder(z[0]).append(this.c.toString()).toString();
            x.d();
            this.a.a(this.c);
          }
          if (arrayOfJSONArray[i] != null)
          {
            new StringBuilder(z[i]).append(arrayOfJSONArray[i].toString()).toString();
            x.d();
            this.a.b(arrayOfJSONArray[i]);
          }
          d.a(this.a, z[5]);
          return;
        }
        while ((d.d(this.a) != i) || (d.f(this.a)));
        if (!d.b(this.a).f())
        {
          if (d.g(this.a) == d.b(this.a).a());
          while (i == 0)
          {
            sendEmptyMessageDelayed(10, d.b);
            return;
            i = 0;
          }
        }
      }
      while ((d.h(this.a) == null) || (d.h(this.a).length == 0));
      int[] arrayOfInt = d.b(this.a).d();
      if ((arrayOfInt == null) || (arrayOfInt.length == 0))
        break label760;
      if (d.h(this.a)[0] != arrayOfInt[0])
        break;
      ArrayList localArrayList1 = new ArrayList(d.h(this.a).length / 2);
      ArrayList localArrayList2 = new ArrayList(arrayOfInt.length / 2);
      int j = d.h(this.a).length;
      for (int k = 0; k < j; k += 2)
        localArrayList1.add(Integer.valueOf(d.h(this.a)[k]));
      for (int m = 0; m < arrayOfInt.length; m += 2)
        localArrayList2.add(Integer.valueOf(arrayOfInt[m]));
      Iterator localIterator = localArrayList1.iterator();
      n = 0;
      while (localIterator.hasNext())
        if (localArrayList2.contains(localIterator.next()))
          n++;
      i1 = localArrayList1.size() - n;
      i2 = localArrayList2.size() - n;
      int i3 = i1 + i2;
      i4 = 0;
      if (i3 > n)
        i4 = i;
    }
    while (i4 == 0);
    StringBuilder localStringBuilder = new StringBuilder(i1).append(z[3]);
    localStringBuilder.append(i2).append(z[2]);
    localStringBuilder.append(n);
    d.a(this.a, localStringBuilder.toString());
    return;
    d.a(this.a, z[4]);
    label760: this.a.e();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.a.f
 * JD-Core Version:    0.6.2
 */