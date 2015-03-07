package com.allinone.free.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.ProgressWheel;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentUsActivity extends Activity
  implements View.OnClickListener
{
  private static Typeface typeFace = null;
  private TextView back;
  private ImageView fan;
  private ImageView finishcha;
  private String guanggao_url = null;
  private WebView guanggaowebview;
  private ProgressWheel progressWheel = null;
  private Mywebview webviewclient;

  private void bulidListenrn()
  {
    this.fan.setOnClickListener(this);
    this.finishcha.setOnClickListener(this);
    try
    {
      this.guanggaowebview.getSettings().setUserAgentString(Myutils.setting_json.getString("agent"));
      HashMap localHashMap = new HashMap();
      localHashMap.put("AIOD", "1");
      this.guanggaowebview.loadUrl(this.guanggao_url, localHashMap);
      this.webviewclient = new Mywebview();
      this.guanggaowebview.setWebViewClient(this.webviewclient);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
  }

  @SuppressLint({"SetJavaScriptEnabled"})
  private void init()
  {
    this.progressWheel = ((ProgressWheel)findViewById(2131230812));
    this.guanggao_url = getIntent().getStringExtra("guanggao_url");
    this.guanggaowebview = ((WebView)findViewById(2131230870));
    this.fan = ((ImageView)findViewById(2131230808));
    this.finishcha = ((ImageView)findViewById(2131230869));
    this.back = ((TextView)findViewById(2131230868));
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.back.setTypeface(typeFace);
    this.guanggaowebview.getSettings().setJavaScriptEnabled(true);
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230808:
      if (this.guanggaowebview.canGoBack())
      {
        this.guanggaowebview.goBack();
        return;
      }
      finish();
      return;
    case 2131230869:
    }
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903078);
    init();
    bulidListenrn();
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

  public class Mywebview extends WebViewClient
  {
    public Mywebview()
    {
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      ContentUsActivity.this.progressWheel.setVisibility(8);
      super.onPageFinished(paramWebView, paramString);
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      ContentUsActivity.this.progressWheel.setVisibility(0);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      super.shouldOverrideUrlLoading(paramWebView, paramString);
      paramWebView.loadUrl(paramString);
      return true;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.ContentUsActivity
 * JD-Core Version:    0.6.2
 */