package com.umeng.message.proguard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class k
{
  private static String b(g paramg, a parama, String paramString)
  {
    if (parama != null)
      paramString = parama.d() + '.' + paramString;
    while (paramg.c().length() <= 0)
      return paramString;
    return paramg.c() + '.' + paramString;
  }

  public static final class a
    implements k.h
  {
    private final int a;
    private j.a b;
    private final String c;
    private final k.g d;
    private final a e;
    private final a[] f;
    private final k.d[] g;
    private final k.f[] h;
    private final k.f[] i;

    private a(j.a parama, k.g paramg, a parama1, int paramInt)
      throws k.c
    {
      this.a = paramInt;
      this.b = parama;
      this.c = k.a(paramg, parama1, parama.o());
      this.d = paramg;
      this.e = parama1;
      this.f = new a[parama.y()];
      for (int j = 0; j < parama.y(); j++)
        this.f[j] = new a(parama.e(j), paramg, this, j);
      this.g = new k.d[parama.B()];
      for (int k = 0; k < parama.B(); k++)
        this.g[k] = new k.d(parama.g(k), paramg, this, k, null);
      this.h = new k.f[parama.s()];
      for (int m = 0; m < parama.s(); m++)
        this.h[m] = new k.f(parama.a(m), paramg, this, m, false, null);
      this.i = new k.f[parama.v()];
      for (int n = 0; n < parama.v(); n++)
        this.i[n] = new k.f(parama.c(n), paramg, this, n, true, null);
      k.g.a(paramg).c(this);
    }

    private void a(j.a parama)
    {
      this.b = parama;
      for (int j = 0; j < this.f.length; j++)
        this.f[j].a(parama.e(j));
      for (int k = 0; k < this.g.length; k++)
        k.d.a(this.g[k], parama.g(k));
      int i1;
      for (int m = 0; ; m++)
      {
        int n = this.h.length;
        i1 = 0;
        if (m >= n)
          break;
        k.f.a(this.h[m], parama.a(m));
      }
      while (i1 < this.i.length)
      {
        k.f.a(this.i[i1], parama.c(i1));
        i1++;
      }
    }

    private void m()
      throws k.c
    {
      int j = 0;
      a[] arrayOfa = this.f;
      int k = arrayOfa.length;
      for (int m = 0; m < k; m++)
        arrayOfa[m].m();
      k.f[] arrayOff1 = this.h;
      int n = arrayOff1.length;
      for (int i1 = 0; i1 < n; i1++)
        k.f.b(arrayOff1[i1]);
      k.f[] arrayOff2 = this.i;
      int i2 = arrayOff2.length;
      while (j < i2)
      {
        k.f.b(arrayOff2[j]);
        j++;
      }
    }

    public int a()
    {
      return this.a;
    }

    public k.f a(String paramString)
    {
      k.h localh = k.g.a(this.d).a(this.c + '.' + paramString);
      if ((localh != null) && ((localh instanceof k.f)))
        return (k.f)localh;
      return null;
    }

    public boolean a(int paramInt)
    {
      Iterator localIterator = this.b.C().iterator();
      while (localIterator.hasNext())
      {
        j.a.b localb = (j.a.b)localIterator.next();
        if ((localb.o() <= paramInt) && (paramInt < localb.q()))
          return true;
      }
      return false;
    }

    public j.a b()
    {
      return this.b;
    }

    public a b(String paramString)
    {
      k.h localh = k.g.a(this.d).a(this.c + '.' + paramString);
      if ((localh != null) && ((localh instanceof a)))
        return (a)localh;
      return null;
    }

    public k.f b(int paramInt)
    {
      return (k.f)k.b.a(k.g.a(this.d)).get(new k.b.a(this, paramInt));
    }

    public k.d c(String paramString)
    {
      k.h localh = k.g.a(this.d).a(this.c + '.' + paramString);
      if ((localh != null) && ((localh instanceof k.d)))
        return (k.d)localh;
      return null;
    }

    public String c()
    {
      return this.b.o();
    }

    public String d()
    {
      return this.c;
    }

    public k.g e()
    {
      return this.d;
    }

    public a f()
    {
      return this.e;
    }

    public j.u g()
    {
      return this.b.G();
    }

    public List<k.f> h()
    {
      return Collections.unmodifiableList(Arrays.asList(this.h));
    }

    public List<k.f> i()
    {
      return Collections.unmodifiableList(Arrays.asList(this.i));
    }

    public List<a> j()
    {
      return Collections.unmodifiableList(Arrays.asList(this.f));
    }

    public List<k.d> k()
    {
      return Collections.unmodifiableList(Arrays.asList(this.g));
    }
  }

  private static final class b
  {
    private final Set<k.g> b = new HashSet();
    private final Map<String, k.h> c = new HashMap();
    private final Map<a, k.f> d = new HashMap();
    private final Map<a, k.e> e = new HashMap();

    static
    {
      if (!k.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        a = bool;
        return;
      }
    }

    b(k.g[] paramArrayOfg)
    {
      for (int i = 0; i < paramArrayOfg.length; i++)
      {
        this.b.add(paramArrayOfg[i]);
        a(paramArrayOfg[i]);
      }
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        k.g localg = (k.g)localIterator.next();
        try
        {
          a(localg.c(), localg);
        }
        catch (k.c localc)
        {
        }
        if (!a)
          throw new AssertionError();
      }
    }

    private void a(k.g paramg)
    {
      Iterator localIterator = paramg.j().iterator();
      while (localIterator.hasNext())
      {
        k.g localg = (k.g)localIterator.next();
        if (this.b.add(localg))
          a(localg);
      }
    }

    static void d(k.h paramh)
      throws k.c
    {
      String str = paramh.c();
      if (str.length() == 0)
        throw new k.c(paramh, "Missing name.", null);
      int i = 1;
      int j = 0;
      if (j < str.length())
      {
        char c1 = str.charAt(j);
        if (c1 >= '')
          i = 0;
        if ((Character.isLetter(c1)) || (c1 == '_') || ((Character.isDigit(c1)) && (j > 0)));
        while (true)
        {
          j++;
          break;
          i = 0;
        }
      }
      if (i == 0)
        throw new k.c(paramh, '"' + str + "\" is not a valid identifier.", null);
    }

    k.h a(String paramString)
    {
      return a(paramString, c.c);
    }

    k.h a(String paramString, c paramc)
    {
      k.h localh = (k.h)this.c.get(paramString);
      if ((localh != null) && ((paramc == c.c) || ((paramc == c.a) && (a(localh))) || ((paramc == c.b) && (b(localh)))))
        return localh;
      Iterator localIterator = this.b.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          localh = (k.h)k.g.a((k.g)localIterator.next()).c.get(paramString);
          if (localh != null)
          {
            if ((paramc == c.c) || ((paramc == c.a) && (a(localh))))
              break;
            if ((paramc == c.b) && (b(localh)))
              return localh;
          }
        }
      return null;
    }

    k.h a(String paramString, k.h paramh, c paramc)
      throws k.c
    {
      Object localObject;
      if (paramString.startsWith("."))
        localObject = a(paramString.substring(1), paramc);
      while (true)
      {
        label77: k.h localh;
        if (localObject == null)
        {
          throw new k.c(paramh, '"' + paramString + "\" is not defined.", null);
          int i = paramString.indexOf('.');
          String str;
          StringBuilder localStringBuilder;
          if (i == -1)
          {
            str = paramString;
            localStringBuilder = new StringBuilder(paramh.d());
          }
          while (true)
          {
            int j = localStringBuilder.lastIndexOf(".");
            if (j == -1)
            {
              localObject = a(paramString, paramc);
              break;
              str = paramString.substring(0, i);
              break label77;
            }
            localStringBuilder.setLength(j + 1);
            localStringBuilder.append(str);
            localh = a(localStringBuilder.toString(), c.b);
            if (localh != null)
            {
              if (i == -1)
                break label216;
              localStringBuilder.setLength(j + 1);
              localStringBuilder.append(paramString);
              localObject = a(localStringBuilder.toString(), paramc);
              break;
            }
            localStringBuilder.setLength(j);
          }
        }
        return localObject;
        label216: localObject = localh;
      }
    }

    void a(k.e parame)
    {
      a locala = new a(parame.g(), parame.a());
      k.e locale = (k.e)this.e.put(locala, parame);
      if (locale != null)
        this.e.put(locala, locale);
    }

    void a(k.f paramf)
      throws k.c
    {
      a locala = new a(paramf.u(), paramf.f());
      k.f localf = (k.f)this.d.put(locala, paramf);
      if (localf != null)
      {
        this.d.put(locala, localf);
        throw new k.c(paramf, "Field number " + paramf.f() + "has already been used in \"" + paramf.u().d() + "\" by field \"" + localf.c() + "\".", null);
      }
    }

    void a(String paramString, k.g paramg)
      throws k.c
    {
      int i = paramString.lastIndexOf('.');
      if (i == -1);
      for (String str = paramString; ; str = paramString.substring(i + 1))
      {
        k.h localh = (k.h)this.c.put(paramString, new b(str, paramString, paramg));
        if (localh == null)
          break;
        this.c.put(paramString, localh);
        if ((localh instanceof b))
          break;
        throw new k.c(paramg, '"' + str + "\" is already defined (as something other than a " + "package) in file \"" + localh.e().b() + "\".", null);
        a(paramString.substring(0, i), paramg);
      }
    }

    boolean a(k.h paramh)
    {
      return ((paramh instanceof k.a)) || ((paramh instanceof k.d));
    }

    boolean b(k.h paramh)
    {
      return ((paramh instanceof k.a)) || ((paramh instanceof k.d)) || ((paramh instanceof b)) || ((paramh instanceof k.j));
    }

    void c(k.h paramh)
      throws k.c
    {
      d(paramh);
      String str = paramh.d();
      int i = str.lastIndexOf('.');
      k.h localh = (k.h)this.c.put(str, paramh);
      if (localh != null)
      {
        this.c.put(str, localh);
        if (paramh.e() == localh.e())
        {
          if (i == -1)
            throw new k.c(paramh, '"' + str + "\" is already defined.", null);
          throw new k.c(paramh, '"' + str.substring(i + 1) + "\" is already defined in \"" + str.substring(0, i) + "\".", null);
        }
        throw new k.c(paramh, '"' + str + "\" is already defined in file \"" + localh.e().b() + "\".", null);
      }
    }

    private static final class a
    {
      private final k.h a;
      private final int b;

      a(k.h paramh, int paramInt)
      {
        this.a = paramh;
        this.b = paramInt;
      }

      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof a));
        a locala;
        do
        {
          return false;
          locala = (a)paramObject;
        }
        while ((this.a != locala.a) || (this.b != locala.b));
        return true;
      }

      public int hashCode()
      {
        return 65535 * this.a.hashCode() + this.b;
      }
    }

    private static final class b
      implements k.h
    {
      private final String a;
      private final String b;
      private final k.g c;

      b(String paramString1, String paramString2, k.g paramg)
      {
        this.c = paramg;
        this.b = paramString2;
        this.a = paramString1;
      }

      public String c()
      {
        return this.a;
      }

      public String d()
      {
        return this.b;
      }

      public k.g e()
      {
        return this.c;
      }

      public x l()
      {
        return this.c.a();
      }
    }

    static enum c
    {
      static
      {
        c[] arrayOfc = new c[3];
        arrayOfc[0] = a;
        arrayOfc[1] = b;
        arrayOfc[2] = c;
      }
    }
  }

  public static class c extends Exception
  {
    private static final long a = 5750205775490483148L;
    private final String b;
    private final x c;
    private final String d;

    private c(k.g paramg, String paramString)
    {
      super();
      this.b = paramg.b();
      this.c = paramg.a();
      this.d = paramString;
    }

    private c(k.h paramh, String paramString)
    {
      super();
      this.b = paramh.d();
      this.c = paramh.l();
      this.d = paramString;
    }

    private c(k.h paramh, String paramString, Throwable paramThrowable)
    {
      this(paramh, paramString);
      initCause(paramThrowable);
    }

    public String a()
    {
      return this.b;
    }

    public x b()
    {
      return this.c;
    }

    public String c()
    {
      return this.d;
    }
  }

  public static final class d
    implements k.h, r.b<k.e>
  {
    private final int a;
    private j.c b;
    private final String c;
    private final k.g d;
    private final k.a e;
    private k.e[] f;

    private d(j.c paramc, k.g paramg, k.a parama, int paramInt)
      throws k.c
    {
      this.a = paramInt;
      this.b = paramc;
      this.c = k.a(paramg, parama, paramc.o());
      this.d = paramg;
      this.e = parama;
      if (paramc.s() == 0)
        throw new k.c(this, "Enums must contain at least one value.", null);
      this.f = new k.e[paramc.s()];
      for (int i = 0; i < paramc.s(); i++)
        this.f[i] = new k.e(paramc.a(i), paramg, this, i, null);
      k.g.a(paramg).c(this);
    }

    private void a(j.c paramc)
    {
      this.b = paramc;
      for (int i = 0; i < this.f.length; i++)
        k.e.a(this.f[i], paramc.a(i));
    }

    public int a()
    {
      return this.a;
    }

    public k.e a(int paramInt)
    {
      return (k.e)k.b.b(k.g.a(this.d)).get(new k.b.a(this, paramInt));
    }

    public k.e a(String paramString)
    {
      k.h localh = k.g.a(this.d).a(this.c + '.' + paramString);
      if ((localh != null) && ((localh instanceof k.e)))
        return (k.e)localh;
      return null;
    }

    public j.c b()
    {
      return this.b;
    }

    public String c()
    {
      return this.b.o();
    }

    public String d()
    {
      return this.c;
    }

    public k.g e()
    {
      return this.d;
    }

    public k.a f()
    {
      return this.e;
    }

    public j.e g()
    {
      return this.b.u();
    }

    public List<k.e> h()
    {
      return Collections.unmodifiableList(Arrays.asList(this.f));
    }
  }

  public static final class e
    implements k.h, r.a
  {
    private final int a;
    private j.g b;
    private final String c;
    private final k.g d;
    private final k.d e;

    private e(j.g paramg, k.g paramg1, k.d paramd, int paramInt)
      throws k.c
    {
      this.a = paramInt;
      this.b = paramg;
      this.d = paramg1;
      this.e = paramd;
      this.c = (paramd.d() + '.' + paramg.o());
      k.g.a(paramg1).c(this);
      k.g.a(paramg1).a(this);
    }

    private void a(j.g paramg)
    {
      this.b = paramg;
    }

    public int a()
    {
      return this.b.r();
    }

    public int b()
    {
      return this.a;
    }

    public String c()
    {
      return this.b.o();
    }

    public String d()
    {
      return this.c;
    }

    public k.g e()
    {
      return this.d;
    }

    public j.g f()
    {
      return this.b;
    }

    public k.d g()
    {
      return this.e;
    }

    public j.i h()
    {
      return this.b.t();
    }
  }

  public static final class f
    implements k.h, o.a<f>, Comparable<f>
  {
    private static final S.a[] a = S.a.values();
    private final int b;
    private j.k c;
    private final String d;
    private final k.g e;
    private final k.a f;
    private b g;
    private k.a h;
    private k.a i;
    private k.d j;
    private Object k;

    static
    {
      if (b.values().length != j.k.c.values().length)
        throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
    }

    private f(j.k paramk, k.g paramg, k.a parama, int paramInt, boolean paramBoolean)
      throws k.c
    {
      this.b = paramInt;
      this.c = paramk;
      this.d = k.a(paramg, parama, paramk.o());
      this.e = paramg;
      if (paramk.u())
        this.g = b.a(paramk.v());
      if (f() <= 0)
        throw new k.c(this, "Field numbers must be positive integers.", null);
      if ((paramk.G().q()) && (!p()))
        throw new k.c(this, "[packed = true] can only be specified for repeated primitive fields.", null);
      if (paramBoolean)
      {
        if (!paramk.z())
          throw new k.c(this, "FieldDescriptorProto.extendee not set for extension field.", null);
        this.h = null;
        if (parama != null)
          this.f = parama;
      }
      while (true)
      {
        k.g.a(paramg).c(this);
        return;
        this.f = null;
        continue;
        if (paramk.z())
          throw new k.c(this, "FieldDescriptorProto.extendee set for non-extension field.", null);
        this.h = parama;
        this.f = null;
      }
    }

    private void a(j.k paramk)
    {
      this.c = paramk;
    }

    private void z()
      throws k.c
    {
      if (this.c.z())
      {
        k.h localh2 = k.g.a(this.e).a(this.c.A(), this, k.b.c.a);
        if (!(localh2 instanceof k.a))
          throw new k.c(this, '"' + this.c.A() + "\" is not a message type.", null);
        this.h = ((k.a)localh2);
        if (!u().a(f()))
          throw new k.c(this, '"' + u().d() + "\" does not declare " + f() + " as an extension number.", null);
      }
      if (this.c.w())
      {
        k.h localh1 = k.g.a(this.e).a(this.c.x(), this, k.b.c.a);
        if (!this.c.u())
        {
          if (!(localh1 instanceof k.a))
            break label272;
          this.g = b.k;
        }
        while (g() == a.i)
          if (!(localh1 instanceof k.a))
          {
            throw new k.c(this, '"' + this.c.x() + "\" is not a message type.", null);
            label272: if ((localh1 instanceof k.d))
              this.g = b.n;
            else
              throw new k.c(this, '"' + this.c.x() + "\" is not a type.", null);
          }
          else
          {
            this.i = ((k.a)localh1);
            if (!this.c.C())
              break label428;
            throw new k.c(this, "Messages can't have default values.", null);
          }
        if (g() == a.h)
        {
          if (!(localh1 instanceof k.d))
            throw new k.c(this, '"' + this.c.x() + "\" is not an enum type.", null);
          this.j = ((k.d)localh1);
        }
      }
      while (true)
        label428: if (this.c.C())
          if (n())
          {
            throw new k.c(this, "Repeated fields cannot have default values.", null);
            throw new k.c(this, "Field with primitive type has type_name.", null);
            if ((g() != a.i) && (g() != a.h))
              continue;
            throw new k.c(this, "Field with message or enum type missing type_name.", null);
          }
      while (true)
      {
        try
        {
          int m = k.1.a[i().ordinal()];
          switch (m)
          {
          default:
            if (!t())
              k.g.a(this.e).a(this);
            if ((this.h == null) || (!this.h.g().o()))
              return;
            if (!t())
              break;
            if ((m()) && (i() == b.k))
              return;
            throw new k.c(this, "Extensions of MessageSets must be optional messages.", null);
          case 1:
          case 2:
          case 3:
            this.k = Integer.valueOf(N.c(this.c.D()));
            continue;
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
          case 9:
          case 10:
          case 11:
          case 12:
          case 13:
          case 14:
          case 15:
          case 16:
          case 17:
          case 18:
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw new k.c(this, "Could not parse default value: \"" + this.c.D() + '"', localNumberFormatException, null);
        }
        this.k = Integer.valueOf(N.d(this.c.D()));
        continue;
        this.k = Long.valueOf(N.e(this.c.D()));
        continue;
        this.k = Long.valueOf(N.f(this.c.D()));
        continue;
        if (this.c.D().equals("inf"))
        {
          this.k = Float.valueOf((1.0F / 1.0F));
        }
        else if (this.c.D().equals("-inf"))
        {
          this.k = Float.valueOf((1.0F / -1.0F));
        }
        else if (this.c.D().equals("nan"))
        {
          this.k = Float.valueOf((0.0F / 0.0F));
        }
        else
        {
          this.k = Float.valueOf(this.c.D());
          continue;
          if (this.c.D().equals("inf"))
          {
            this.k = Double.valueOf((1.0D / 0.0D));
          }
          else if (this.c.D().equals("-inf"))
          {
            this.k = Double.valueOf((-1.0D / 0.0D));
          }
          else if (this.c.D().equals("nan"))
          {
            this.k = Double.valueOf((0.0D / 0.0D));
          }
          else
          {
            this.k = Double.valueOf(this.c.D());
            continue;
            this.k = Boolean.valueOf(this.c.D());
            continue;
            this.k = this.c.D();
            continue;
            try
            {
              this.k = N.a(this.c.D());
            }
            catch (N.a locala)
            {
              throw new k.c(this, "Couldn't parse default value: " + locala.getMessage(), locala, null);
            }
            this.k = this.j.a(this.c.D());
            if (this.k == null)
            {
              throw new k.c(this, "Unknown enum default value: \"" + this.c.D() + '"', null);
              throw new k.c(this, "Message type had default value.", null);
              if (n())
                this.k = Collections.emptyList();
              else
                switch (k.1.b[g().ordinal()])
                {
                default:
                  this.k = a.a(g());
                  break;
                case 1:
                  this.k = this.j.h().get(0);
                  break;
                case 2:
                  this.k = null;
                }
            }
          }
        }
      }
      throw new k.c(this, "MessageSets cannot have fields, only extensions.", null);
    }

    public int a()
    {
      return this.b;
    }

    public int a(f paramf)
    {
      if (paramf.h != this.h)
        throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
      return f() - paramf.f();
    }

    public y.a a(y.a parama, y paramy)
    {
      return ((x.a)parama).c((x)paramy);
    }

    public j.k b()
    {
      return this.c;
    }

    public String c()
    {
      return this.c.o();
    }

    public String d()
    {
      return this.d;
    }

    public k.g e()
    {
      return this.e;
    }

    public int f()
    {
      return this.c.r();
    }

    public a g()
    {
      return this.g.b();
    }

    public S.b h()
    {
      return j().a();
    }

    public b i()
    {
      return this.g;
    }

    public S.a j()
    {
      return a[this.g.ordinal()];
    }

    public boolean k()
    {
      return this.c.t() == j.k.b.b;
    }

    public boolean m()
    {
      return this.c.t() == j.k.b.a;
    }

    public boolean n()
    {
      return this.c.t() == j.k.b.c;
    }

    public boolean o()
    {
      return s().q();
    }

    public boolean p()
    {
      return (n()) && (j().c());
    }

    public boolean q()
    {
      return this.c.C();
    }

    public Object r()
    {
      if (g() == a.i)
        throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
      return this.k;
    }

    public j.m s()
    {
      return this.c.G();
    }

    public boolean t()
    {
      return this.c.z();
    }

    public k.a u()
    {
      return this.h;
    }

    public k.a v()
    {
      if (!t())
        throw new UnsupportedOperationException("This field is not an extension.");
      return this.f;
    }

    public k.a w()
    {
      if (g() != a.i)
        throw new UnsupportedOperationException("This field is not of message type.");
      return this.i;
    }

    public k.d x()
    {
      if (g() != a.h)
        throw new UnsupportedOperationException("This field is not of enum type.");
      return this.j;
    }

    public static enum a
    {
      private final Object j;

      static
      {
        a[] arrayOfa = new a[9];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
        arrayOfa[3] = d;
        arrayOfa[4] = e;
        arrayOfa[5] = f;
        arrayOfa[6] = g;
        arrayOfa[7] = h;
        arrayOfa[8] = i;
      }

      private a(Object paramObject)
      {
        this.j = paramObject;
      }
    }

    public static enum b
    {
      private k.f.a s;

      static
      {
        b[] arrayOfb = new b[18];
        arrayOfb[0] = a;
        arrayOfb[1] = b;
        arrayOfb[2] = c;
        arrayOfb[3] = d;
        arrayOfb[4] = e;
        arrayOfb[5] = f;
        arrayOfb[6] = g;
        arrayOfb[7] = h;
        arrayOfb[8] = i;
        arrayOfb[9] = j;
        arrayOfb[10] = k;
        arrayOfb[11] = l;
        arrayOfb[12] = m;
        arrayOfb[13] = n;
        arrayOfb[14] = o;
        arrayOfb[15] = p;
        arrayOfb[16] = q;
        arrayOfb[17] = r;
      }

      private b(k.f.a parama)
      {
        this.s = parama;
      }

      public static b a(j.k.c paramc)
      {
        return values()[(-1 + paramc.a())];
      }

      public j.k.c a()
      {
        return j.k.c.a(1 + ordinal());
      }

      public k.f.a b()
      {
        return this.s;
      }
    }
  }

  public static final class g
  {
    private j.o a;
    private final k.a[] b;
    private final k.d[] c;
    private final k.j[] d;
    private final k.f[] e;
    private final g[] f;
    private final g[] g;
    private final k.b h;

    private g(j.o paramo, g[] paramArrayOfg, k.b paramb)
      throws k.c
    {
      this.h = paramb;
      this.a = paramo;
      this.f = ((g[])paramArrayOfg.clone());
      this.g = new g[paramo.w()];
      for (int i = 0; i < paramo.w(); i++)
      {
        int i1 = paramo.c(i);
        if ((i1 < 0) || (i1 >= this.f.length))
          throw new k.c(this, "Invalid public dependency index.", null);
        this.g[i] = this.f[paramo.c(i)];
      }
      paramb.a(c(), this);
      this.b = new k.a[paramo.B()];
      for (int j = 0; j < paramo.B(); j++)
        this.b[j] = new k.a(paramo.e(j), this, null, j, null);
      this.c = new k.d[paramo.E()];
      for (int k = 0; k < paramo.E(); k++)
        this.c[k] = new k.d(paramo.g(k), this, null, k, null);
      this.d = new k.j[paramo.H()];
      for (int m = 0; m < paramo.H(); m++)
        this.d[m] = new k.j(paramo.i(m), this, m, null);
      this.e = new k.f[paramo.S()];
      for (int n = 0; n < paramo.S(); n++)
        this.e[n] = new k.f(paramo.k(n), this, null, n, true, null);
    }

    public static g a(j.o paramo, g[] paramArrayOfg)
      throws k.c
    {
      g localg = new g(paramo, paramArrayOfg, new k.b(paramArrayOfg));
      if (paramArrayOfg.length != paramo.u())
        throw new k.c(localg, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
      for (int i = 0; i < paramo.u(); i++)
        if (!paramArrayOfg[i].b().equals(paramo.a(i)))
          throw new k.c(localg, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", null);
      localg.k();
      return localg;
    }

    private void a(j.o paramo)
    {
      this.a = paramo;
      for (int i = 0; i < this.b.length; i++)
        k.a.a(this.b[i], paramo.e(i));
      for (int j = 0; j < this.c.length; j++)
        k.d.a(this.c[j], paramo.g(j));
      int n;
      for (int k = 0; ; k++)
      {
        int m = this.d.length;
        n = 0;
        if (k >= m)
          break;
        k.j.a(this.d[k], paramo.i(k));
      }
      while (n < this.e.length)
      {
        k.f.a(this.e[n], paramo.k(n));
        n++;
      }
    }

    // ERROR //
    public static void a(String[] paramArrayOfString, g[] paramArrayOfg, a parama)
    {
      // Byte code:
      //   0: new 160	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 161	java/lang/StringBuilder:<init>	()V
      //   7: astore_3
      //   8: aload_0
      //   9: arraylength
      //   10: istore 4
      //   12: iconst_0
      //   13: istore 5
      //   15: iload 5
      //   17: iload 4
      //   19: if_icmpge +18 -> 37
      //   22: aload_3
      //   23: aload_0
      //   24: iload 5
      //   26: aaload
      //   27: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: pop
      //   31: iinc 5 1
      //   34: goto -19 -> 15
      //   37: aload_3
      //   38: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   41: ldc 170
      //   43: invokevirtual 174	java/lang/String:getBytes	(Ljava/lang/String;)[B
      //   46: astore 7
      //   48: aload 7
      //   50: invokestatic 177	com/umeng/message/proguard/j$o:a	([B)Lcom/umeng/message/proguard/j$o;
      //   53: astore 9
      //   55: aload 9
      //   57: aload_1
      //   58: invokestatic 179	com/umeng/message/proguard/k$g:a	(Lcom/umeng/message/proguard/j$o;[Lcom/umeng/message/proguard/k$g;)Lcom/umeng/message/proguard/k$g;
      //   61: astore 11
      //   63: aload_2
      //   64: aload 11
      //   66: invokeinterface 184 2 0
      //   71: astore 12
      //   73: aload 12
      //   75: ifnull +19 -> 94
      //   78: aload 7
      //   80: aload 12
      //   82: invokestatic 187	com/umeng/message/proguard/j$o:a	([BLcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/j$o;
      //   85: astore 14
      //   87: aload 11
      //   89: aload 14
      //   91: invokespecial 189	com/umeng/message/proguard/k$g:a	(Lcom/umeng/message/proguard/j$o;)V
      //   94: return
      //   95: astore 6
      //   97: new 191	java/lang/RuntimeException
      //   100: dup
      //   101: ldc 193
      //   103: aload 6
      //   105: invokespecial 196	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   108: athrow
      //   109: astore 8
      //   111: new 198	java/lang/IllegalArgumentException
      //   114: dup
      //   115: ldc 200
      //   117: aload 8
      //   119: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   122: athrow
      //   123: astore 10
      //   125: new 198	java/lang/IllegalArgumentException
      //   128: dup
      //   129: new 160	java/lang/StringBuilder
      //   132: dup
      //   133: invokespecial 161	java/lang/StringBuilder:<init>	()V
      //   136: ldc 203
      //   138: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   141: aload 9
      //   143: invokevirtual 206	com/umeng/message/proguard/j$o:o	()Ljava/lang/String;
      //   146: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   149: ldc 208
      //   151: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   154: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   157: aload 10
      //   159: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   162: athrow
      //   163: astore 13
      //   165: new 198	java/lang/IllegalArgumentException
      //   168: dup
      //   169: ldc 200
      //   171: aload 13
      //   173: invokespecial 201	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   176: athrow
      //
      // Exception table:
      //   from	to	target	type
      //   37	48	95	java/io/UnsupportedEncodingException
      //   48	55	109	com/umeng/message/proguard/s
      //   55	63	123	com/umeng/message/proguard/k$c
      //   78	87	163	com/umeng/message/proguard/s
    }

    private void k()
      throws k.c
    {
      int i = 0;
      k.a[] arrayOfa = this.b;
      int j = arrayOfa.length;
      for (int k = 0; k < j; k++)
        k.a.a(arrayOfa[k]);
      k.j[] arrayOfj = this.d;
      int m = arrayOfj.length;
      for (int n = 0; n < m; n++)
        k.j.a(arrayOfj[n]);
      k.f[] arrayOff = this.e;
      int i1 = arrayOff.length;
      while (i < i1)
      {
        k.f.b(arrayOff[i]);
        i++;
      }
    }

    public j.o a()
    {
      return this.a;
    }

    public k.a a(String paramString)
    {
      if (paramString.indexOf('.') != -1)
        return null;
      if (c().length() > 0)
        paramString = c() + '.' + paramString;
      k.h localh = this.h.a(paramString);
      if ((localh != null) && ((localh instanceof k.a)) && (localh.e() == this))
        return (k.a)localh;
      return null;
    }

    public k.d b(String paramString)
    {
      if (paramString.indexOf('.') != -1)
        return null;
      if (c().length() > 0)
        paramString = c() + '.' + paramString;
      k.h localh = this.h.a(paramString);
      if ((localh != null) && ((localh instanceof k.d)) && (localh.e() == this))
        return (k.d)localh;
      return null;
    }

    public String b()
    {
      return this.a.o();
    }

    public k.j c(String paramString)
    {
      if (paramString.indexOf('.') != -1)
        return null;
      if (c().length() > 0)
        paramString = c() + '.' + paramString;
      k.h localh = this.h.a(paramString);
      if ((localh != null) && ((localh instanceof k.j)) && (localh.e() == this))
        return (k.j)localh;
      return null;
    }

    public String c()
    {
      return this.a.r();
    }

    public j.s d()
    {
      return this.a.U();
    }

    public k.f d(String paramString)
    {
      if (paramString.indexOf('.') != -1)
        return null;
      if (c().length() > 0)
        paramString = c() + '.' + paramString;
      k.h localh = this.h.a(paramString);
      if ((localh != null) && ((localh instanceof k.f)) && (localh.e() == this))
        return (k.f)localh;
      return null;
    }

    public List<k.a> e()
    {
      return Collections.unmodifiableList(Arrays.asList(this.b));
    }

    public List<k.d> f()
    {
      return Collections.unmodifiableList(Arrays.asList(this.c));
    }

    public List<k.j> g()
    {
      return Collections.unmodifiableList(Arrays.asList(this.d));
    }

    public List<k.f> h()
    {
      return Collections.unmodifiableList(Arrays.asList(this.e));
    }

    public List<g> i()
    {
      return Collections.unmodifiableList(Arrays.asList(this.f));
    }

    public List<g> j()
    {
      return Collections.unmodifiableList(Arrays.asList(this.g));
    }

    public static abstract interface a
    {
      public abstract m a(k.g paramg);
    }
  }

  private static abstract interface h
  {
    public abstract String c();

    public abstract String d();

    public abstract k.g e();

    public abstract x l();
  }

  public static final class i
    implements k.h
  {
    private final int a;
    private j.w b;
    private final String c;
    private final k.g d;
    private final k.j e;
    private k.a f;
    private k.a g;

    private i(j.w paramw, k.g paramg, k.j paramj, int paramInt)
      throws k.c
    {
      this.a = paramInt;
      this.b = paramw;
      this.d = paramg;
      this.e = paramj;
      this.c = (paramj.d() + '.' + paramw.o());
      k.g.a(paramg).c(this);
    }

    private void a(j.w paramw)
    {
      this.b = paramw;
    }

    private void j()
      throws k.c
    {
      k.h localh1 = k.g.a(this.d).a(this.b.r(), this, k.b.c.a);
      if (!(localh1 instanceof k.a))
        throw new k.c(this, '"' + this.b.r() + "\" is not a message type.", null);
      this.f = ((k.a)localh1);
      k.h localh2 = k.g.a(this.d).a(this.b.u(), this, k.b.c.a);
      if (!(localh2 instanceof k.a))
        throw new k.c(this, '"' + this.b.u() + "\" is not a message type.", null);
      this.g = ((k.a)localh2);
    }

    public int a()
    {
      return this.a;
    }

    public j.w b()
    {
      return this.b;
    }

    public String c()
    {
      return this.b.o();
    }

    public String d()
    {
      return this.c;
    }

    public k.g e()
    {
      return this.d;
    }

    public k.j f()
    {
      return this.e;
    }

    public k.a g()
    {
      return this.f;
    }

    public k.a h()
    {
      return this.g;
    }

    public j.y i()
    {
      return this.b.x();
    }
  }

  public static final class j
    implements k.h
  {
    private final int a;
    private j.A b;
    private final String c;
    private final k.g d;
    private k.i[] e;

    private j(j.A paramA, k.g paramg, int paramInt)
      throws k.c
    {
      this.a = paramInt;
      this.b = paramA;
      this.c = k.a(paramg, null, paramA.o());
      this.d = paramg;
      this.e = new k.i[paramA.s()];
      for (int i = 0; i < paramA.s(); i++)
        this.e[i] = new k.i(paramA.a(i), paramg, this, i, null);
      k.g.a(paramg).c(this);
    }

    private void a(j.A paramA)
    {
      this.b = paramA;
      for (int i = 0; i < this.e.length; i++)
        k.i.a(this.e[i], paramA.a(i));
    }

    private void h()
      throws k.c
    {
      k.i[] arrayOfi = this.e;
      int i = arrayOfi.length;
      for (int j = 0; j < i; j++)
        k.i.a(arrayOfi[j]);
    }

    public int a()
    {
      return this.a;
    }

    public k.i a(String paramString)
    {
      k.h localh = k.g.a(this.d).a(this.c + '.' + paramString);
      if ((localh != null) && ((localh instanceof k.i)))
        return (k.i)localh;
      return null;
    }

    public j.A b()
    {
      return this.b;
    }

    public String c()
    {
      return this.b.o();
    }

    public String d()
    {
      return this.c;
    }

    public k.g e()
    {
      return this.d;
    }

    public j.C f()
    {
      return this.b.u();
    }

    public List<k.i> g()
    {
      return Collections.unmodifiableList(Arrays.asList(this.e));
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.k
 * JD-Core Version:    0.6.2
 */