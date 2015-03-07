package com.umeng.fb.audio;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import com.umeng.fb.fragment.FeedbackFragment;
import com.umeng.fb.opus.OpusTool;
import com.umeng.fb.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class c
{
  private final String a = c.class.getName();
  private OpusTool b;
  private int c;
  private final int d = 5;
  private Context e;
  private a f;

  public c(Context paramContext)
  {
    this.e = paramContext;
    this.b = new OpusTool(paramContext);
  }

  private void a(FileOutputStream paramFileOutputStream, long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4)
    throws IOException
  {
    byte[] arrayOfByte = new byte[44];
    arrayOfByte[0] = 82;
    arrayOfByte[1] = 73;
    arrayOfByte[2] = 70;
    arrayOfByte[3] = 70;
    arrayOfByte[4] = ((byte)(int)(0xFF & paramLong2));
    arrayOfByte[5] = ((byte)(int)(0xFF & paramLong2 >> 8));
    arrayOfByte[6] = ((byte)(int)(0xFF & paramLong2 >> 16));
    arrayOfByte[7] = ((byte)(int)(0xFF & paramLong2 >> 24));
    arrayOfByte[8] = 87;
    arrayOfByte[9] = 65;
    arrayOfByte[10] = 86;
    arrayOfByte[11] = 69;
    arrayOfByte[12] = 102;
    arrayOfByte[13] = 109;
    arrayOfByte[14] = 116;
    arrayOfByte[15] = 32;
    arrayOfByte[16] = 16;
    arrayOfByte[17] = 0;
    arrayOfByte[18] = 0;
    arrayOfByte[19] = 0;
    arrayOfByte[20] = 1;
    arrayOfByte[21] = 0;
    arrayOfByte[22] = ((byte)paramInt);
    arrayOfByte[23] = 0;
    arrayOfByte[24] = ((byte)(int)(0xFF & paramLong3));
    arrayOfByte[25] = ((byte)(int)(0xFF & paramLong3 >> 8));
    arrayOfByte[26] = ((byte)(int)(0xFF & paramLong3 >> 16));
    arrayOfByte[27] = ((byte)(int)(0xFF & paramLong3 >> 24));
    arrayOfByte[28] = ((byte)(int)(0xFF & paramLong4));
    arrayOfByte[29] = ((byte)(int)(0xFF & paramLong4 >> 8));
    arrayOfByte[30] = ((byte)(int)(0xFF & paramLong4 >> 16));
    arrayOfByte[31] = ((byte)(int)(0xFF & paramLong4 >> 24));
    arrayOfByte[32] = ((byte)(paramInt * 16 / 8));
    arrayOfByte[33] = 0;
    arrayOfByte[34] = 16;
    arrayOfByte[35] = 0;
    arrayOfByte[36] = 100;
    arrayOfByte[37] = 97;
    arrayOfByte[38] = 116;
    arrayOfByte[39] = 97;
    arrayOfByte[40] = ((byte)(int)(0xFF & paramLong1));
    arrayOfByte[41] = ((byte)(int)(0xFF & paramLong1 >> 8));
    arrayOfByte[42] = ((byte)(int)(0xFF & paramLong1 >> 16));
    arrayOfByte[43] = ((byte)(int)(0xFF & paramLong1 >> 24));
    paramFileOutputStream.write(arrayOfByte, 0, 44);
  }

  private void a(String paramString1, String paramString2, int paramInt)
  {
    long l1 = 32000;
    byte[] arrayOfByte = new byte[paramInt];
    try
    {
      File localFile1 = new File(paramString1);
      File localFile2 = new File(paramString2);
      if (!localFile1.exists())
        return;
      localFileInputStream = new FileInputStream(localFile1);
      localFileOutputStream = new FileOutputStream(localFile2);
      long l2 = localFileInputStream.available();
      a(localFileOutputStream, l2, 36L + l2, 16000L, 1, l1);
      while (localFileInputStream.read(arrayOfByte) != -1)
        localFileOutputStream.write(arrayOfByte);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      FileInputStream localFileInputStream;
      FileOutputStream localFileOutputStream;
      localFileNotFoundException.printStackTrace();
      return;
      localFileInputStream.close();
      localFileOutputStream.close();
      com.umeng.fb.util.c.b(paramString1);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramInt != -1)
    {
      File localFile1 = new File(paramString1);
      File localFile2 = new File(paramString2);
      if ((localFile1.length() / localFile2.length() > 18L) && (this.c < 5))
      {
        localFile2.delete();
        new b(paramString3, -1, c.b).execute(new Void[0]);
      }
    }
    else
    {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 0;
    FeedbackFragment.getHandler().sendMessage(localMessage);
    com.umeng.fb.util.c.b(paramString1);
  }

  private int b(String paramString1, String paramString2)
  {
    if (!com.umeng.fb.util.c.c(paramString1));
    try
    {
      Thread.sleep(300L);
      return this.b.b(paramString1, paramString2);
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        localInterruptedException.printStackTrace();
    }
  }

  private void c(String paramString, int paramInt)
  {
    new b(paramString, -1, c.b).execute(new Void[0]);
  }

  private void d(String paramString, int paramInt)
  {
    this.f.a(paramString, paramInt);
  }

  public int a(String paramString1, String paramString2)
  {
    if (!new File(paramString2).exists())
      return this.b.a(paramString1, paramString2);
    return -1;
  }

  public void a(a parama)
  {
    this.f = parama;
  }

  public void a(String paramString)
  {
    this.c = 0;
    new b(paramString, -1, c.c).execute(new Void[0]);
  }

  public void a(String paramString, int paramInt)
  {
    this.c = 0;
    b(paramString, paramInt);
  }

  public void b(String paramString, int paramInt)
  {
    new b(paramString, paramInt, c.a).execute(new Void[0]);
  }

  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt);
  }

  class b extends AsyncTask<Void, Integer, Integer>
  {
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int g;
    private c.c h;

    public b(String paramInt, int paramc, c.c arg4)
    {
      this.b = (com.umeng.fb.util.c.c(c.a(c.this)) + paramInt + ".raw");
      this.c = (com.umeng.fb.util.c.c(c.a(c.this)) + paramInt + ".wav");
      this.d = (com.umeng.fb.util.c.c(c.a(c.this)) + paramInt + "cache.wav");
      this.e = (com.umeng.fb.util.c.b(c.a(c.this)) + paramInt + ".opus");
      this.f = paramInt;
      this.g = paramc;
      Object localObject;
      this.h = localObject;
      c.b(c.this);
      Log.c(c.c(c.this), "TranscodeTask create task");
    }

    protected Integer a(Void[] paramArrayOfVoid)
    {
      int i = c.1.a[this.h.ordinal()];
      int j = 0;
      switch (i)
      {
      default:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        return Integer.valueOf(j);
        c.a(c.this, this.b, this.c, this.g);
        j = 0;
        continue;
        j = c.a(c.this, this.c, this.e);
        continue;
        j = c.this.a(this.e, this.d);
      }
    }

    protected void a(Integer paramInteger)
    {
      switch (c.1.a[this.h.ordinal()])
      {
      default:
        return;
      case 1:
        c.a(c.this, this.f, paramInteger.intValue());
        return;
      case 2:
        c.a(c.this, this.c, this.e, this.f, paramInteger.intValue());
        return;
      case 3:
      }
      c.b(c.this, this.d, paramInteger.intValue());
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

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.audio.c
 * JD-Core Version:    0.6.2
 */