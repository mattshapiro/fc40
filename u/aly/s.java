package u.aly;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class s
{
  public static Object a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return null;
    try
    {
      Object localObject = new ObjectInputStream(new ByteArrayInputStream(b(paramString))).readObject();
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public static String a(Serializable paramSerializable)
  {
    if (paramSerializable == null)
      return "";
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramSerializable);
      localObjectOutputStream.close();
      String str = a(localByteArrayOutputStream.toByteArray());
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; ; i++)
    {
      if (i >= paramArrayOfByte.length)
        return localStringBuffer.toString();
      localStringBuffer.append((char)(97 + (0xF & paramArrayOfByte[i] >> 4)));
      localStringBuffer.append((char)(97 + (0xF & paramArrayOfByte[i])));
    }
  }

  public static byte[] b(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    for (int i = 0; ; i += 2)
    {
      if (i >= paramString.length())
        return arrayOfByte;
      int j = paramString.charAt(i);
      arrayOfByte[(i / 2)] = ((byte)(j - 97 << 4));
      int k = paramString.charAt(i + 1);
      int m = i / 2;
      arrayOfByte[m] = ((byte)(arrayOfByte[m] + (k - 97)));
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.s
 * JD-Core Version:    0.6.2
 */