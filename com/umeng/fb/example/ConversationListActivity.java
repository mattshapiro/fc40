package com.umeng.fb.example;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.umeng.fb.fragment.FeedbackFragment;

public class ConversationListActivity extends FragmentActivity
  implements ConversationListFragment.Callbacks
{
  private boolean mTwoPane;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903064);
    getActionBar().setDisplayHomeAsUpEnabled(true);
    if (findViewById(2131230796) != null)
    {
      this.mTwoPane = true;
      ((ConversationListFragment)getFragmentManager().findFragmentById(2131230797)).setActivateOnItemClick(true);
    }
  }

  public void onItemSelected(String paramString)
  {
    if (this.mTwoPane)
    {
      getSupportFragmentManager().beginTransaction().add(2131230796, FeedbackFragment.newInstance(paramString)).commit();
      return;
    }
    Intent localIntent = new Intent(this, ConversationDetailActivity.class);
    localIntent.putExtra("conversation_id", paramString);
    startActivity(localIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    finish();
    return true;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.example.ConversationListActivity
 * JD-Core Version:    0.6.2
 */