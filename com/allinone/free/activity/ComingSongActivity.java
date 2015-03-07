package com.allinone.free.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.umeng.analytics.MobclickAgent;

public class ComingSongActivity extends Activity
  implements View.OnClickListener
{
  private static Typeface typeFace = null;
  private ImageView appfan;
  private EditText et_search_keywords;
  private String searchtitle;

  private void buildListener()
  {
    this.appfan.setOnClickListener(this);
  }

  private void init()
  {
    this.appfan = ((ImageView)findViewById(2131230789));
    this.et_search_keywords = ((EditText)findViewById(2131230856));
    this.et_search_keywords.setHint(this.searchtitle);
    typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.et_search_keywords.setTypeface(typeFace);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230789:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903077);
    this.searchtitle = getIntent().getStringExtra("title");
    init();
    buildListener();
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
 * Qualified Name:     com.allinone.free.activity.ComingSongActivity
 * JD-Core Version:    0.6.2
 */