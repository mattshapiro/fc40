package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ao
  implements Serializable, Cloneable, bz<ao, e>
{
  public static final Map<e, cl> f;
  private static final dd g = new dd("Event");
  private static final ct h = new ct("name", (byte)11, (short)1);
  private static final ct i = new ct("properties", (byte)13, (short)2);
  private static final ct j = new ct("duration", (byte)10, (short)3);
  private static final ct k = new ct("acc", (byte)8, (short)4);
  private static final ct l = new ct("ts", (byte)10, (short)5);
  private static final Map<Class<? extends dg>, dh> m = new HashMap();
  private static final int n = 0;
  private static final int o = 1;
  private static final int p = 2;
  public String a;
  public Map<String, az> b;
  public long c;
  public int d;
  public long e;
  private byte q = 0;
  private e[] r;

  static
  {
    m.put(di.class, new b(null));
    m.put(dj.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cl("name", (byte)1, new cm((byte)11)));
    localEnumMap.put(e.b, new cl("properties", (byte)1, new co((byte)13, new cm((byte)11), new cq((byte)12, az.class))));
    localEnumMap.put(e.c, new cl("duration", (byte)2, new cm((byte)10)));
    localEnumMap.put(e.d, new cl("acc", (byte)2, new cm((byte)8)));
    localEnumMap.put(e.e, new cl("ts", (byte)1, new cm((byte)10)));
    f = Collections.unmodifiableMap(localEnumMap);
    cl.a(ao.class, f);
  }

  public ao()
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.c;
    arrayOfe[1] = e.d;
    this.r = arrayOfe;
  }

  public ao(String paramString, Map<String, az> paramMap, long paramLong)
  {
    this();
    this.a = paramString;
    this.b = paramMap;
    this.e = paramLong;
    e(true);
  }

  public ao(ao paramao)
  {
    e[] arrayOfe = new e[2];
    arrayOfe[0] = e.c;
    arrayOfe[1] = e.d;
    this.r = arrayOfe;
    this.q = paramao.q;
    if (paramao.e())
      this.a = paramao.a;
    HashMap localHashMap;
    Iterator localIterator;
    if (paramao.j())
    {
      localHashMap = new HashMap();
      localIterator = paramao.b.entrySet().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.b = localHashMap;
        this.c = paramao.c;
        this.d = paramao.d;
        this.e = paramao.e;
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put((String)localEntry.getKey(), new az((az)localEntry.getValue()));
    }
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
      this.q = 0;
      a(new cs(new dk(paramObjectInputStream)));
      return;
    }
    catch (cf localcf)
    {
      throw new IOException(localcf.getMessage());
    }
  }

  private void a(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    try
    {
      b(new cs(new dk(paramObjectOutputStream)));
      return;
    }
    catch (cf localcf)
    {
      throw new IOException(localcf.getMessage());
    }
  }

  public ao a()
  {
    return new ao(this);
  }

  public ao a(int paramInt)
  {
    this.d = paramInt;
    d(true);
    return this;
  }

  public ao a(long paramLong)
  {
    this.c = paramLong;
    c(true);
    return this;
  }

  public ao a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public ao a(Map<String, az> paramMap)
  {
    this.b = paramMap;
    return this;
  }

  public void a(String paramString, az paramaz)
  {
    if (this.b == null)
      this.b = new HashMap();
    this.b.put(paramString, paramaz);
  }

  public void a(cy paramcy)
    throws cf
  {
    ((dh)m.get(paramcy.D())).b().a(paramcy, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public ao b(long paramLong)
  {
    this.e = paramLong;
    e(true);
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
    c(false);
    this.c = 0L;
    d(false);
    this.d = 0;
    e(false);
    this.e = 0L;
  }

  public void b(cy paramcy)
    throws cf
  {
    ((dh)m.get(paramcy.D())).b().b(paramcy, this);
  }

  public void b(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.b = null;
  }

  public String c()
  {
    return this.a;
  }

  public e c(int paramInt)
  {
    return e.a(paramInt);
  }

  public void c(boolean paramBoolean)
  {
    this.q = bw.a(this.q, 0, paramBoolean);
  }

  public void d()
  {
    this.a = null;
  }

  public void d(boolean paramBoolean)
  {
    this.q = bw.a(this.q, 1, paramBoolean);
  }

  public void e(boolean paramBoolean)
  {
    this.q = bw.a(this.q, 2, paramBoolean);
  }

  public boolean e()
  {
    return this.a != null;
  }

  public int f()
  {
    if (this.b == null)
      return 0;
    return this.b.size();
  }

  public Map<String, az> h()
  {
    return this.b;
  }

  public void i()
  {
    this.b = null;
  }

  public boolean j()
  {
    return this.b != null;
  }

  public long k()
  {
    return this.c;
  }

  public void l()
  {
    this.q = bw.b(this.q, 0);
  }

  public boolean m()
  {
    return bw.a(this.q, 0);
  }

  public int n()
  {
    return this.d;
  }

  public void o()
  {
    this.q = bw.b(this.q, 1);
  }

  public boolean p()
  {
    return bw.a(this.q, 1);
  }

  public long q()
  {
    return this.e;
  }

  public void r()
  {
    this.q = bw.b(this.q, 2);
  }

  public boolean s()
  {
    return bw.a(this.q, 2);
  }

  public void t()
    throws cf
  {
    if (this.a == null)
      throw new cz("Required field 'name' was not present! Struct: " + toString());
    if (this.b == null)
      throw new cz("Required field 'properties' was not present! Struct: " + toString());
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Event(");
    localStringBuilder.append("name:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      localStringBuilder.append(", ");
      localStringBuilder.append("properties:");
      if (this.b != null)
        break label179;
      localStringBuilder.append("null");
    }
    while (true)
    {
      if (m())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("duration:");
        localStringBuilder.append(this.c);
      }
      if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("acc:");
        localStringBuilder.append(this.d);
      }
      localStringBuilder.append(", ");
      localStringBuilder.append("ts:");
      localStringBuilder.append(this.e);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label179: localStringBuilder.append(this.b);
    }
  }

  private static class a extends di<ao>
  {
    public void a(cy paramcy, ao paramao)
      throws cf
    {
      paramcy.j();
      ct localct = paramcy.l();
      if (localct.b == 0)
      {
        paramcy.k();
        if (!paramao.s())
          throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
      }
      else
      {
        switch (localct.c)
        {
        default:
          db.a(paramcy, localct.b);
        case 1:
        case 2:
        case 3:
        case 4:
        case 5:
        }
        while (true)
        {
          paramcy.m();
          break;
          if (localct.b == 11)
          {
            paramao.a = paramcy.z();
            paramao.a(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 13)
            {
              cv localcv = paramcy.n();
              paramao.b = new HashMap(2 * localcv.c);
              for (int i = 0; ; i++)
              {
                if (i >= localcv.c)
                {
                  paramcy.o();
                  paramao.b(true);
                  break;
                }
                String str = paramcy.z();
                az localaz = new az();
                localaz.a(paramcy);
                paramao.b.put(str, localaz);
              }
            }
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 10)
            {
              paramao.c = paramcy.x();
              paramao.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 8)
              {
                paramao.d = paramcy.w();
                paramao.d(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 10)
                {
                  paramao.e = paramcy.x();
                  paramao.e(true);
                }
                else
                {
                  db.a(paramcy, localct.b);
                }
              }
            }
          }
        }
      }
      paramao.t();
    }

    public void b(cy paramcy, ao paramao)
      throws cf
    {
      paramao.t();
      paramcy.a(ao.u());
      if (paramao.a != null)
      {
        paramcy.a(ao.v());
        paramcy.a(paramao.a);
        paramcy.c();
      }
      Iterator localIterator;
      if (paramao.b != null)
      {
        paramcy.a(ao.w());
        paramcy.a(new cv((byte)11, (byte)12, paramao.b.size()));
        localIterator = paramao.b.entrySet().iterator();
      }
      while (true)
      {
        if (!localIterator.hasNext())
        {
          paramcy.e();
          paramcy.c();
          if (paramao.m())
          {
            paramcy.a(ao.x());
            paramcy.a(paramao.c);
            paramcy.c();
          }
          if (paramao.p())
          {
            paramcy.a(ao.y());
            paramcy.a(paramao.d);
            paramcy.c();
          }
          paramcy.a(ao.z());
          paramcy.a(paramao.e);
          paramcy.c();
          paramcy.d();
          paramcy.b();
          return;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        paramcy.a((String)localEntry.getKey());
        ((az)localEntry.getValue()).b(paramcy);
      }
    }
  }

  private static class b
    implements dh
  {
    public ao.a a()
    {
      return new ao.a(null);
    }
  }

  private static class c extends dj<ao>
  {
    public void a(cy paramcy, ao paramao)
      throws cf
    {
      de localde = (de)paramcy;
      localde.a(paramao.a);
      localde.a(paramao.b.size());
      Iterator localIterator = paramao.b.entrySet().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          localde.a(paramao.e);
          BitSet localBitSet = new BitSet();
          if (paramao.m())
            localBitSet.set(0);
          if (paramao.p())
            localBitSet.set(1);
          localde.a(localBitSet, 2);
          if (paramao.m())
            localde.a(paramao.c);
          if (paramao.p())
            localde.a(paramao.d);
          return;
        }
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localde.a((String)localEntry.getKey());
        ((az)localEntry.getValue()).b(localde);
      }
    }

    public void b(cy paramcy, ao paramao)
      throws cf
    {
      de localde = (de)paramcy;
      paramao.a = localde.z();
      paramao.a(true);
      cv localcv = new cv((byte)11, (byte)12, localde.w());
      paramao.b = new HashMap(2 * localcv.c);
      for (int i = 0; ; i++)
      {
        if (i >= localcv.c)
        {
          paramao.b(true);
          paramao.e = localde.x();
          paramao.e(true);
          BitSet localBitSet = localde.b(2);
          if (localBitSet.get(0))
          {
            paramao.c = localde.x();
            paramao.c(true);
          }
          if (localBitSet.get(1))
          {
            paramao.d = localde.w();
            paramao.d(true);
          }
          return;
        }
        String str = localde.z();
        az localaz = new az();
        localaz.a(localde);
        paramao.b.put(str, localaz);
      }
    }
  }

  private static class d
    implements dh
  {
    public ao.c a()
    {
      return new ao.c(null);
    }
  }

  public static enum e
    implements cg
  {
    private static final Map<String, e> f;
    private final short g;
    private final String h;

    static
    {
      e[] arrayOfe = new e[5];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      arrayOfe[4] = e;
      i = arrayOfe;
      f = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        e locale = (e)localIterator.next();
        f.put(locale.b(), locale);
      }
    }

    private e(short arg3, String arg4)
    {
      short s;
      this.g = s;
      Object localObject;
      this.h = localObject;
    }

    public static e a(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 1:
        return a;
      case 2:
        return b;
      case 3:
        return c;
      case 4:
        return d;
      case 5:
      }
      return e;
    }

    public static e a(String paramString)
    {
      return (e)f.get(paramString);
    }

    public static e b(int paramInt)
    {
      e locale = a(paramInt);
      if (locale == null)
        throw new IllegalArgumentException("Field " + paramInt + " doesn't exist!");
      return locale;
    }

    public short a()
    {
      return this.g;
    }

    public String b()
    {
      return this.h;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.ao
 * JD-Core Version:    0.6.2
 */