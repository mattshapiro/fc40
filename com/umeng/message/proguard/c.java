package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;

public abstract class c<MessageType extends y>
  implements B<MessageType>
{
  private static final n a = n.g();

  private O a(MessageType paramMessageType)
  {
    if ((paramMessageType instanceof b))
      return ((b)paramMessageType).e();
    return new O(paramMessageType);
  }

  private MessageType b(MessageType paramMessageType)
    throws s
  {
    if ((paramMessageType != null) && (!paramMessageType.a()))
      throw a(paramMessageType).b().a(paramMessageType);
    return paramMessageType;
  }

  public MessageType a(g paramg)
    throws s
  {
    return a(paramg, a);
  }

  public MessageType a(g paramg, n paramn)
    throws s
  {
    try
    {
      h localh = paramg.k();
      y localy = (y)d(localh, paramn);
      try
      {
        localh.a(0);
        return localy;
      }
      catch (s locals2)
      {
        throw locals2.a(localy);
      }
    }
    catch (s locals1)
    {
      throw locals1;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", localIOException);
    }
  }

  public MessageType a(h paramh)
    throws s
  {
    return (y)d(paramh, a);
  }

  public MessageType a(h paramh, n paramn)
    throws s
  {
    return b((y)d(paramh, paramn));
  }

  public MessageType a(InputStream paramInputStream)
    throws s
  {
    return a(paramInputStream, a);
  }

  public MessageType a(InputStream paramInputStream, n paramn)
    throws s
  {
    h localh = h.a(paramInputStream);
    y localy = (y)d(localh, paramn);
    try
    {
      localh.a(0);
      return localy;
    }
    catch (s locals)
    {
      throw locals.a(localy);
    }
  }

  public MessageType a(byte[] paramArrayOfByte)
    throws s
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, a);
  }

  public MessageType a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws s
  {
    return a(paramArrayOfByte, paramInt1, paramInt2, a);
  }

  public MessageType a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, n paramn)
    throws s
  {
    try
    {
      h localh = h.a(paramArrayOfByte, paramInt1, paramInt2);
      y localy = (y)d(localh, paramn);
      try
      {
        localh.a(0);
        return localy;
      }
      catch (s locals2)
      {
        throw locals2.a(localy);
      }
    }
    catch (s locals1)
    {
      throw locals1;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", localIOException);
    }
  }

  public MessageType a(byte[] paramArrayOfByte, n paramn)
    throws s
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramn);
  }

  public MessageType b(g paramg)
    throws s
  {
    return b(paramg, a);
  }

  public MessageType b(g paramg, n paramn)
    throws s
  {
    return b(a(paramg, paramn));
  }

  public MessageType b(h paramh)
    throws s
  {
    return a(paramh, a);
  }

  public MessageType b(InputStream paramInputStream)
    throws s
  {
    return b(paramInputStream, a);
  }

  public MessageType b(InputStream paramInputStream, n paramn)
    throws s
  {
    return b(a(paramInputStream, paramn));
  }

  public MessageType b(byte[] paramArrayOfByte)
    throws s
  {
    return b(paramArrayOfByte, a);
  }

  public MessageType b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws s
  {
    return b(paramArrayOfByte, paramInt1, paramInt2, a);
  }

  public MessageType b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, n paramn)
    throws s
  {
    return b(a(paramArrayOfByte, paramInt1, paramInt2, paramn));
  }

  public MessageType b(byte[] paramArrayOfByte, n paramn)
    throws s
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramn);
  }

  public MessageType c(InputStream paramInputStream)
    throws s
  {
    return c(paramInputStream, a);
  }

  public MessageType c(InputStream paramInputStream, n paramn)
    throws s
  {
    try
    {
      int i = paramInputStream.read();
      if (i == -1)
        return null;
      int j = h.a(i, paramInputStream);
      return a(new b.a.a(paramInputStream, j), paramn);
    }
    catch (IOException localIOException)
    {
      throw new s(localIOException.getMessage());
    }
  }

  public MessageType d(InputStream paramInputStream)
    throws s
  {
    return d(paramInputStream, a);
  }

  public MessageType d(InputStream paramInputStream, n paramn)
    throws s
  {
    return b(c(paramInputStream, paramn));
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.c
 * JD-Core Version:    0.6.2
 */