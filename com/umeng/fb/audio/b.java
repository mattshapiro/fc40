package com.umeng.fb.audio;

import android.media.AudioRecord;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class b
{
  private static String e;
  private static String f;
  private final String a = b.class.getName();
  private int b = 0;
  private AudioRecord c;
  private boolean d = false;
  private long g;

  private boolean d()
  {
    int i = 1;
    this.b = (2 * AudioRecord.getMinBufferSize(16000, 16, 2));
    if (-2 == this.b)
      i = 0;
    do
    {
      return i;
      this.c = new AudioRecord(i, 16000, 16, 2, this.b);
    }
    while (this.c.getState() == i);
    return false;
  }

  private void e()
  {
    if (this.c == null)
      return;
    byte[] arrayOfByte = new byte[this.b];
    try
    {
      File localFile = new File(e);
      if (localFile.exists())
        localFile.delete();
      localFileOutputStream = new FileOutputStream(localFile);
      this.c.startRecording();
      if ((this.d != true) || (-3 == this.c.read(arrayOfByte, 0, this.b)))
      {
        a();
        try
        {
          localFileOutputStream.close();
          return;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return;
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        FileOutputStream localFileOutputStream = null;
        continue;
        try
        {
          localFileOutputStream.write(arrayOfByte);
          this.g += this.b;
        }
        catch (IOException localIOException2)
        {
          localIOException2.printStackTrace();
        }
      }
    }
  }

  protected int a()
  {
    try
    {
      this.d = false;
      if (this.c != null)
      {
        int j = this.c.getRecordingState();
        if (1 != j);
      }
      for (int i = -1; ; i = this.b)
      {
        return i;
        this.c.stop();
        this.c.release();
        this.c = null;
      }
    }
    finally
    {
    }
  }

  protected boolean a(String paramString1, String paramString2)
  {
    try
    {
      e = paramString1;
      f = paramString2;
      boolean bool = d();
      if (bool)
      {
        this.d = true;
        this.g = 0L;
        new Thread(new a()).start();
      }
      return bool;
    }
    finally
    {
    }
  }

  protected boolean b()
  {
    int i = 1;
    if (this.c.getRecordingState() == i)
      i = 0;
    return i;
  }

  public long c()
  {
    return this.g / 16000L / 2L;
  }

  class a
    implements Runnable
  {
    a()
    {
    }

    public void run()
    {
      if (b.a(b.this) != null)
        b.b(b.this);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.audio.b
 * JD-Core Version:    0.6.2
 */