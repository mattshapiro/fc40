package u.aly;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class av
  implements Serializable, Cloneable, bz<av, e>
{
  public static final Map<e, cl> e;
  private static final dd f = new dd("InstantMsg");
  private static final ct g = new ct("id", (byte)11, (short)1);
  private static final ct h = new ct("errors", (byte)15, (short)2);
  private static final ct i = new ct("events", (byte)15, (short)3);
  private static final ct j = new ct("game_events", (byte)15, (short)4);
  private static final Map<Class<? extends dg>, dh> k = new HashMap();
  public String a;
  public List<am> b;
  public List<ao> c;
  public List<ao> d;
  private e[] l;

  static
  {
    k.put(di.class, new b(null));
    k.put(dj.class, new d(null));
    EnumMap localEnumMap = new EnumMap(e.class);
    localEnumMap.put(e.a, new cl("id", (byte)1, new cm((byte)11)));
    localEnumMap.put(e.b, new cl("errors", (byte)2, new cn((byte)15, new cq((byte)12, am.class))));
    localEnumMap.put(e.c, new cl("events", (byte)2, new cn((byte)15, new cq((byte)12, ao.class))));
    localEnumMap.put(e.d, new cl("game_events", (byte)2, new cn((byte)15, new cq((byte)12, ao.class))));
    e = Collections.unmodifiableMap(localEnumMap);
    cl.a(av.class, e);
  }

  public av()
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    arrayOfe[2] = e.d;
    this.l = arrayOfe;
  }

  public av(String paramString)
  {
    this();
    this.a = paramString;
  }

  public av(av paramav)
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = e.b;
    arrayOfe[1] = e.c;
    arrayOfe[2] = e.d;
    this.l = arrayOfe;
    if (paramav.e())
      this.a = paramav.a;
    ArrayList localArrayList1;
    Iterator localIterator1;
    ArrayList localArrayList2;
    Iterator localIterator2;
    label115: ArrayList localArrayList3;
    Iterator localIterator3;
    if (paramav.k())
    {
      localArrayList1 = new ArrayList();
      localIterator1 = paramav.b.iterator();
      if (!localIterator1.hasNext())
        this.b = localArrayList1;
    }
    else
    {
      if (paramav.p())
      {
        localArrayList2 = new ArrayList();
        localIterator2 = paramav.c.iterator();
        if (localIterator2.hasNext())
          break label202;
        this.c = localArrayList2;
      }
      if (paramav.u())
      {
        localArrayList3 = new ArrayList();
        localIterator3 = paramav.d.iterator();
      }
    }
    while (true)
    {
      if (!localIterator3.hasNext())
      {
        this.d = localArrayList3;
        return;
        localArrayList1.add(new am((am)localIterator1.next()));
        break;
        label202: localArrayList2.add(new ao((ao)localIterator2.next()));
        break label115;
      }
      localArrayList3.add(new ao((ao)localIterator3.next()));
    }
  }

  private void a(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    try
    {
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

  public e a(int paramInt)
  {
    return e.a(paramInt);
  }

  public av a()
  {
    return new av(this);
  }

  public av a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public av a(List<am> paramList)
  {
    this.b = paramList;
    return this;
  }

  public void a(am paramam)
  {
    if (this.b == null)
      this.b = new ArrayList();
    this.b.add(paramam);
  }

  public void a(ao paramao)
  {
    if (this.c == null)
      this.c = new ArrayList();
    this.c.add(paramao);
  }

  public void a(cy paramcy)
    throws cf
  {
    ((dh)k.get(paramcy.D())).b().a(paramcy, this);
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.a = null;
  }

  public av b(List<ao> paramList)
  {
    this.c = paramList;
    return this;
  }

  public void b()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }

  public void b(ao paramao)
  {
    if (this.d == null)
      this.d = new ArrayList();
    this.d.add(paramao);
  }

  public void b(cy paramcy)
    throws cf
  {
    ((dh)k.get(paramcy.D())).b().b(paramcy, this);
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

  public av c(List<ao> paramList)
  {
    this.d = paramList;
    return this;
  }

  public void c(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.c = null;
  }

  public void d()
  {
    this.a = null;
  }

  public void d(boolean paramBoolean)
  {
    if (!paramBoolean)
      this.d = null;
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

  public Iterator<am> h()
  {
    if (this.b == null)
      return null;
    return this.b.iterator();
  }

  public List<am> i()
  {
    return this.b;
  }

  public void j()
  {
    this.b = null;
  }

  public boolean k()
  {
    return this.b != null;
  }

  public int l()
  {
    if (this.c == null)
      return 0;
    return this.c.size();
  }

  public Iterator<ao> m()
  {
    if (this.c == null)
      return null;
    return this.c.iterator();
  }

  public List<ao> n()
  {
    return this.c;
  }

  public void o()
  {
    this.c = null;
  }

  public boolean p()
  {
    return this.c != null;
  }

  public int q()
  {
    if (this.d == null)
      return 0;
    return this.d.size();
  }

  public Iterator<ao> r()
  {
    if (this.d == null)
      return null;
    return this.d.iterator();
  }

  public List<ao> s()
  {
    return this.d;
  }

  public void t()
  {
    this.d = null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("InstantMsg(");
    localStringBuilder.append("id:");
    if (this.a == null)
    {
      localStringBuilder.append("null");
      if (k())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("errors:");
        if (this.b != null)
          break label173;
        localStringBuilder.append("null");
      }
      label72: if (p())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("events:");
        if (this.c != null)
          break label185;
        localStringBuilder.append("null");
      }
      label110: if (u())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append("game_events:");
        if (this.d != null)
          break label197;
        localStringBuilder.append("null");
      }
    }
    while (true)
    {
      localStringBuilder.append(")");
      return localStringBuilder.toString();
      localStringBuilder.append(this.a);
      break;
      label173: localStringBuilder.append(this.b);
      break label72;
      label185: localStringBuilder.append(this.c);
      break label110;
      label197: localStringBuilder.append(this.d);
    }
  }

  public boolean u()
  {
    return this.d != null;
  }

  public void v()
    throws cf
  {
    if (this.a == null)
      throw new cz("Required field 'id' was not present! Struct: " + toString());
  }

  private static class a extends di<av>
  {
    public void a(cy paramcy, av paramav)
      throws cf
    {
      paramcy.j();
      ct localct = paramcy.l();
      if (localct.b == 0)
      {
        paramcy.k();
        paramav.v();
        return;
      }
      switch (localct.c)
      {
      default:
        db.a(paramcy, localct.b);
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 11)
        {
          paramav.a = paramcy.z();
          paramav.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 15)
          {
            cu localcu3 = paramcy.p();
            paramav.b = new ArrayList(localcu3.b);
            for (int k = 0; ; k++)
            {
              if (k >= localcu3.b)
              {
                paramcy.q();
                paramav.b(true);
                break;
              }
              am localam = new am();
              localam.a(paramcy);
              paramav.b.add(localam);
            }
          }
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 15)
          {
            cu localcu2 = paramcy.p();
            paramav.c = new ArrayList(localcu2.b);
            for (int j = 0; ; j++)
            {
              if (j >= localcu2.b)
              {
                paramcy.q();
                paramav.c(true);
                break;
              }
              ao localao2 = new ao();
              localao2.a(paramcy);
              paramav.c.add(localao2);
            }
          }
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 15)
          {
            cu localcu1 = paramcy.p();
            paramav.d = new ArrayList(localcu1.b);
            for (int i = 0; ; i++)
            {
              if (i >= localcu1.b)
              {
                paramcy.q();
                paramav.d(true);
                break;
              }
              ao localao1 = new ao();
              localao1.a(paramcy);
              paramav.d.add(localao1);
            }
          }
          db.a(paramcy, localct.b);
        }
      }
    }

    public void b(cy paramcy, av paramav)
      throws cf
    {
      paramav.v();
      paramcy.a(av.w());
      if (paramav.a != null)
      {
        paramcy.a(av.x());
        paramcy.a(paramav.a);
        paramcy.c();
      }
      Iterator localIterator3;
      Iterator localIterator2;
      label163: Iterator localIterator1;
      if ((paramav.b != null) && (paramav.k()))
      {
        paramcy.a(av.y());
        paramcy.a(new cu((byte)12, paramav.b.size()));
        localIterator3 = paramav.b.iterator();
        if (!localIterator3.hasNext())
        {
          paramcy.f();
          paramcy.c();
        }
      }
      else
      {
        if ((paramav.c != null) && (paramav.p()))
        {
          paramcy.a(av.z());
          paramcy.a(new cu((byte)12, paramav.c.size()));
          localIterator2 = paramav.c.iterator();
          if (localIterator2.hasNext())
            break label277;
          paramcy.f();
          paramcy.c();
        }
        if ((paramav.d != null) && (paramav.u()))
        {
          paramcy.a(av.A());
          paramcy.a(new cu((byte)12, paramav.d.size()));
          localIterator1 = paramav.d.iterator();
        }
      }
      while (true)
      {
        if (!localIterator1.hasNext())
        {
          paramcy.f();
          paramcy.c();
          paramcy.d();
          paramcy.b();
          return;
          ((am)localIterator3.next()).b(paramcy);
          break;
          label277: ((ao)localIterator2.next()).b(paramcy);
          break label163;
        }
        ((ao)localIterator1.next()).b(paramcy);
      }
    }
  }

  private static class b
    implements dh
  {
    public av.a a()
    {
      return new av.a(null);
    }
  }

  private static class c extends dj<av>
  {
    public void a(cy paramcy, av paramav)
      throws cf
    {
      de localde = (de)paramcy;
      localde.a(paramav.a);
      BitSet localBitSet = new BitSet();
      if (paramav.k())
        localBitSet.set(0);
      if (paramav.p())
        localBitSet.set(1);
      if (paramav.u())
        localBitSet.set(2);
      localde.a(localBitSet, 3);
      Iterator localIterator3;
      Iterator localIterator2;
      label140: Iterator localIterator1;
      if (paramav.k())
      {
        localde.a(paramav.b.size());
        localIterator3 = paramav.b.iterator();
        if (localIterator3.hasNext());
      }
      else
      {
        if (paramav.p())
        {
          localde.a(paramav.c.size());
          localIterator2 = paramav.c.iterator();
          if (localIterator2.hasNext())
            break label209;
        }
        if (paramav.u())
        {
          localde.a(paramav.d.size());
          localIterator1 = paramav.d.iterator();
        }
      }
      while (true)
      {
        if (!localIterator1.hasNext())
        {
          return;
          ((am)localIterator3.next()).b(localde);
          break;
          label209: ((ao)localIterator2.next()).b(localde);
          break label140;
        }
        ((ao)localIterator1.next()).b(localde);
      }
    }

    public void b(cy paramcy, av paramav)
      throws cf
    {
      int i = 0;
      de localde = (de)paramcy;
      paramav.a = localde.z();
      paramav.a(true);
      BitSet localBitSet = localde.b(3);
      int j;
      int k;
      label133: cu localcu3;
      if (localBitSet.get(0))
      {
        cu localcu1 = new cu((byte)12, localde.w());
        paramav.b = new ArrayList(localcu1.b);
        j = 0;
        if (j >= localcu1.b)
          paramav.b(true);
      }
      else
      {
        if (localBitSet.get(1))
        {
          cu localcu2 = new cu((byte)12, localde.w());
          paramav.c = new ArrayList(localcu2.b);
          k = 0;
          if (k < localcu2.b)
            break label238;
          paramav.c(true);
        }
        if (localBitSet.get(2))
        {
          localcu3 = new cu((byte)12, localde.w());
          paramav.d = new ArrayList(localcu3.b);
        }
      }
      while (true)
      {
        if (i >= localcu3.b)
        {
          paramav.d(true);
          return;
          am localam = new am();
          localam.a(localde);
          paramav.b.add(localam);
          j++;
          break;
          label238: ao localao1 = new ao();
          localao1.a(localde);
          paramav.c.add(localao1);
          k++;
          break label133;
        }
        ao localao2 = new ao();
        localao2.a(localde);
        paramav.d.add(localao2);
        i++;
      }
    }
  }

  private static class d
    implements dh
  {
    public av.c a()
    {
      return new av.c(null);
    }
  }

  public static enum e
    implements cg
  {
    private static final Map<String, e> e;
    private final short f;
    private final String g;

    static
    {
      e[] arrayOfe = new e[4];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      arrayOfe[3] = d;
      h = arrayOfe;
      e = new HashMap();
      Iterator localIterator = EnumSet.allOf(e.class).iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        e locale = (e)localIterator.next();
        e.put(locale.b(), locale);
      }
    }

    private e(short arg3, String arg4)
    {
      short s;
      this.f = s;
      Object localObject;
      this.g = localObject;
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
      }
      return d;
    }

    public static e a(String paramString)
    {
      return (e)e.get(paramString);
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
      return this.f;
    }

    public String b()
    {
      return this.g;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.av
 * JD-Core Version:    0.6.2
 */