package net.tsz.afinal.http.entityhandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

public class StringEntityHandler
{
  public Object handleEntity(HttpEntity paramHttpEntity, EntityCallBack paramEntityCallBack, String paramString)
    throws IOException
  {
    if (paramHttpEntity == null)
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte1 = new byte[1024];
    long l1 = paramHttpEntity.getContentLength();
    long l2 = 0L;
    InputStream localInputStream = paramHttpEntity.getContent();
    while (true)
    {
      int i = localInputStream.read(arrayOfByte1);
      if (i == -1)
      {
        if (paramEntityCallBack != null)
          paramEntityCallBack.callBack(l1, l2, true);
        byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        localInputStream.close();
        return new String(arrayOfByte2, paramString);
      }
      localByteArrayOutputStream.write(arrayOfByte1, 0, i);
      l2 += i;
      if (paramEntityCallBack != null)
        paramEntityCallBack.callBack(l1, l2, false);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.entityhandler.StringEntityHandler
 * JD-Core Version:    0.6.2
 */