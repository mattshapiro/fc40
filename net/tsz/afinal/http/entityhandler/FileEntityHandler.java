package net.tsz.afinal.http.entityhandler;

import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.HttpEntity;

public class FileEntityHandler
{
  private boolean mStop = false;

  public Object handleEntity(HttpEntity paramHttpEntity, EntityCallBack paramEntityCallBack, String paramString, boolean paramBoolean)
    throws IOException
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramString.trim().length() == 0))
      localObject = null;
    long l1;
    FileOutputStream localFileOutputStream;
    label80: InputStream localInputStream;
    long l2;
    do
    {
      do
      {
        return localObject;
        localObject = new File(paramString);
        if (!((File)localObject).exists())
          ((File)localObject).createNewFile();
      }
      while (this.mStop);
      l1 = 0L;
      if (!paramBoolean)
        break;
      l1 = ((File)localObject).length();
      localFileOutputStream = new FileOutputStream(paramString, true);
      if (this.mStop)
        break label208;
      localInputStream = paramHttpEntity.getContent();
      l2 = l1 + paramHttpEntity.getContentLength();
    }
    while ((l1 >= l2) || (this.mStop));
    byte[] arrayOfByte = new byte[1024];
    while (true)
    {
      int i;
      if ((!this.mStop) && (l1 < l2))
      {
        i = localInputStream.read(arrayOfByte, 0, 1024);
        if (i > 0);
      }
      else
      {
        paramEntityCallBack.callBack(l2, l1, true);
        if ((!this.mStop) || (l1 >= l2))
          break;
        throw new IOException("user stop download thread");
        localFileOutputStream = new FileOutputStream(paramString);
        break label80;
        label208: break;
      }
      localFileOutputStream.write(arrayOfByte, 0, i);
      l1 += i;
      paramEntityCallBack.callBack(l2, l1, false);
    }
  }

  public boolean isStop()
  {
    return this.mStop;
  }

  public void setStop(boolean paramBoolean)
  {
    this.mStop = paramBoolean;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.entityhandler.FileEntityHandler
 * JD-Core Version:    0.6.2
 */