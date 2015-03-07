package com.umeng.fb.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.umeng.fb.fragment.FeedbackFragment;

public class ConversationDetailActivity extends FragmentActivity
{
  private FeedbackFragment mFeedbackFragment;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903068);
    if (paramBundle == null)
    {
      this.mFeedbackFragment = FeedbackFragment.newInstance(getIntent().getStringExtra("conversation_id"));
      getSupportFragmentManager().beginTransaction().add(2131230806, this.mFeedbackFragment).commit();
    }
  }

  protected void onNewIntent(Intent paramIntent)
  {
    this.mFeedbackFragment.onRefresh();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.example.ConversationDetailActivity
 * JD-Core Version:    0.6.2
 */