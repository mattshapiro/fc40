package u.aly;

public class db
{
  private static int a = 2147483647;

  public static da a(byte[] paramArrayOfByte, da paramda)
  {
    if (paramArrayOfByte[0] > 16)
      paramda = new cs.a();
    while ((paramArrayOfByte.length <= 1) || ((0x80 & paramArrayOfByte[1]) == 0))
      return paramda;
    return new cs.a();
  }

  public static void a(int paramInt)
  {
    a = paramInt;
  }

  public static void a(cy paramcy, byte paramByte)
    throws cf
  {
    a(paramcy, paramByte, a);
  }

  public static void a(cy paramcy, byte paramByte, int paramInt)
    throws cf
  {
    int i = 0;
    if (paramInt <= 0)
      throw new cf("Maximum skip depth exceeded");
    switch (paramByte)
    {
    case 5:
    case 7:
    case 9:
    default:
      return;
    case 2:
      paramcy.t();
      return;
    case 3:
      paramcy.u();
      return;
    case 6:
      paramcy.v();
      return;
    case 8:
      paramcy.w();
      return;
    case 10:
      paramcy.x();
      return;
    case 4:
      paramcy.y();
      return;
    case 11:
      paramcy.A();
      return;
    case 12:
      paramcy.j();
      while (true)
      {
        ct localct = paramcy.l();
        if (localct.b == 0)
        {
          paramcy.k();
          return;
        }
        a(paramcy, localct.b, paramInt - 1);
        paramcy.m();
      }
    case 13:
      cv localcv = paramcy.n();
      while (true)
      {
        if (i >= localcv.c)
        {
          paramcy.o();
          return;
        }
        a(paramcy, localcv.a, paramInt - 1);
        a(paramcy, localcv.b, paramInt - 1);
        i++;
      }
    case 14:
      dc localdc = paramcy.r();
      while (true)
      {
        if (i >= localdc.b)
        {
          paramcy.s();
          return;
        }
        a(paramcy, localdc.a, paramInt - 1);
        i++;
      }
    case 15:
    }
    cu localcu = paramcy.p();
    while (true)
    {
      if (i >= localcu.b)
      {
        paramcy.q();
        return;
      }
      a(paramcy, localcu.a, paramInt - 1);
      i++;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.db
 * JD-Core Version:    0.6.2
 */