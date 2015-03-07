package u.aly;

import java.util.BitSet;

public final class de extends cs
{
  public de(dm paramdm)
  {
    super(paramdm);
  }

  public static BitSet a(byte[] paramArrayOfByte)
  {
    BitSet localBitSet = new BitSet();
    for (int i = 0; ; i++)
    {
      if (i >= 8 * paramArrayOfByte.length)
        return localBitSet;
      if ((paramArrayOfByte[(-1 + (paramArrayOfByte.length - i / 8))] & 1 << i % 8) > 0)
        localBitSet.set(i);
    }
  }

  public static byte[] b(BitSet paramBitSet, int paramInt)
  {
    byte[] arrayOfByte = new byte[(int)Math.ceil(paramInt / 8.0D)];
    for (int i = 0; ; i++)
    {
      if (i >= paramBitSet.length())
        return arrayOfByte;
      if (paramBitSet.get(i))
      {
        int j = -1 + (arrayOfByte.length - i / 8);
        arrayOfByte[j] = ((byte)(arrayOfByte[j] | 1 << i % 8));
      }
    }
  }

  public Class<? extends dg> D()
  {
    return dj.class;
  }

  public void a(BitSet paramBitSet, int paramInt)
    throws cf
  {
    byte[] arrayOfByte = b(paramBitSet, paramInt);
    int i = arrayOfByte.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return;
      a(arrayOfByte[j]);
    }
  }

  public BitSet b(int paramInt)
    throws cf
  {
    int i = (int)Math.ceil(paramInt / 8.0D);
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return a(arrayOfByte);
      arrayOfByte[j] = u();
    }
  }

  public static class a
    implements da
  {
    public cy a(dm paramdm)
    {
      return new de(paramdm);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.de
 * JD-Core Version:    0.6.2
 */