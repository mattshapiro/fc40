package com.umeng.fb.audio;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;

class a
{
  private final String a = a.class.getName();
  private AudioTrack b;
  private String c;

  public a(String paramString)
  {
    this.c = paramString;
  }

  protected void a()
  {
    File localFile = new File(this.c);
    int i = AudioTrack.getMinBufferSize(16000, 4, 2);
    byte[] arrayOfByte = new byte[i];
    this.b = new AudioTrack(3, 16000, 4, 2, i * 2, 1);
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      this.b.play();
      localFileInputStream.read(arrayOfByte);
      while (localFileInputStream.read(arrayOfByte) != -1)
        this.b.write(arrayOfByte, 0, i);
    }
    catch (Throwable localThrowable)
    {
      Log.d(this.a, "Playback Failed");
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 0;
    com.umeng.fb.adapter.a.a().sendMessage(localMessage);
  }

  protected void b()
  {
    if (this.b != null)
    {
      this.b.release();
      this.b = null;
    }
  }

  protected Boolean c()
  {
    if (this.b.getPlayState() == 3);
    for (boolean bool = true; ; bool = false)
      return Boolean.valueOf(bool);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.audio.a
 * JD-Core Version:    0.6.2
 */