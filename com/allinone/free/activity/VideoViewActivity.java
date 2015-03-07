package com.allinone.free.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

public class VideoViewActivity extends Activity
{
  private boolean fullscreen = false;
  private MediaController mController;
  private VideoView videoView;
  private String video_item_url;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903145);
    this.videoView = ((VideoView)findViewById(2131231097));
    this.mController = new MediaController(this);
    this.video_item_url = getIntent().getStringExtra("playurl");
    File localFile = new File(this.video_item_url);
    if (!this.fullscreen)
    {
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams1.addRule(12);
      localLayoutParams1.addRule(10);
      localLayoutParams1.addRule(9);
      localLayoutParams1.addRule(11);
      this.videoView.setLayoutParams(localLayoutParams1);
    }
    for (this.fullscreen = true; ; this.fullscreen = false)
    {
      if (localFile.exists())
      {
        this.videoView.setVideoPath(localFile.getAbsolutePath());
        this.videoView.setMediaController(this.mController);
        this.mController.setMediaPlayer(this.videoView);
        this.videoView.requestFocus();
        this.videoView.start();
      }
      this.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
      {
        public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
        {
          VideoViewActivity.this.finish();
        }
      });
      return;
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(13);
      this.videoView.setLayoutParams(localLayoutParams2);
    }
  }

  protected void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(this);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.VideoViewActivity
 * JD-Core Version:    0.6.2
 */