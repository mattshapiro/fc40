package com.allinone.free.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.SeekBar;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Player
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener
{
  Context ctx;
  Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int i = Player.this.mediaPlayer.getCurrentPosition();
      int j = Player.this.mediaPlayer.getDuration();
      if (j > 0)
      {
        long l = i * Player.this.seekBar.getMax() / j;
        Player.this.seekBar.setProgress((int)l);
      }
    }
  };
  private Timer mTimer = new Timer();
  public MediaPlayer mediaPlayer;
  private SeekBar seekBar;
  TimerTask timerTask = new TimerTask()
  {
    public void run()
    {
      if (Player.this.mediaPlayer == null);
      while ((!Player.this.mediaPlayer.isPlaying()) || (Player.this.seekBar.isPressed()))
        return;
      Player.this.handler.sendEmptyMessage(0);
    }
  };

  public Player(Context paramContext, SeekBar paramSeekBar)
  {
    this.seekBar = paramSeekBar;
    this.ctx = paramContext;
    try
    {
      this.mediaPlayer = new MediaPlayer();
      this.mediaPlayer.setAudioStreamType(3);
      this.mediaPlayer.setOnBufferingUpdateListener(this);
      this.mediaPlayer.setOnPreparedListener(this);
      this.mTimer.schedule(this.timerTask, 0L, 1000L);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public static String formatTime(long paramLong)
  {
    String str1 = paramLong / 60000L;
    String str2 = paramLong % 60000L;
    String str3;
    if (str1.length() < 2)
    {
      str3 = "0" + paramLong / 60000L;
      if (str2.length() != 4)
        break label153;
      str2 = "0" + paramLong % 60000L;
    }
    while (true)
    {
      return str3 + ":" + str2.trim().substring(0, 2);
      str3 = paramLong / 60000L;
      break;
      label153: if (str2.length() == 3)
        str2 = "00" + paramLong % 60000L;
      else if (str2.length() == 2)
        str2 = "000" + paramLong % 60000L;
      else if (str2.length() == 1)
        str2 = "0000" + paramLong % 60000L;
    }
  }

  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    this.seekBar.setSecondaryProgress(paramInt);
    Log.e(this.seekBar.getMax() * this.mediaPlayer.getCurrentPosition() / this.mediaPlayer.getDuration() + "% play", paramInt + " buffer");
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    Log.e("mediaPlayer", "onCompletion");
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("show");
    this.ctx.sendBroadcast(localIntent);
    paramMediaPlayer.start();
    Log.e("mediaPlayer", "onPrepared");
  }

  public void pause()
  {
    this.mediaPlayer.pause();
  }

  public void play()
  {
    this.mediaPlayer.start();
  }

  public void playUrl(String paramString)
  {
    try
    {
      if (this.mediaPlayer.getCurrentPosition() != 0)
        this.mediaPlayer.reset();
      this.mediaPlayer.setDataSource(paramString);
      this.mediaPlayer.prepare();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      localIllegalStateException.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void stop()
  {
    if (this.mediaPlayer != null)
    {
      this.mediaPlayer.stop();
      this.mediaPlayer.release();
      this.mediaPlayer = null;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.utils.Player
 * JD-Core Version:    0.6.2
 */