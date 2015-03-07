package com.umeng.fb.example;

import android.content.Context;
import android.content.Intent;
import com.umeng.common.message.Log;
import com.umeng.message.UmengBaseIntentService;
import com.umeng.message.entity.UMessage;
import org.json.JSONObject;

public class MyPushIntentService extends UmengBaseIntentService
{
  private static final String TAG = MyPushIntentService.class.getName();

  protected void onMessage(Context paramContext, Intent paramIntent)
  {
    super.onMessage(paramContext, paramIntent);
    try
    {
      String str = paramIntent.getStringExtra("body");
      UMessage localUMessage = new UMessage(new JSONObject(str));
      Log.e("aaa", str + "-----------" + localUMessage.custom);
      return;
    }
    catch (Exception localException)
    {
      Log.e(TAG, localException.getMessage());
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.example.MyPushIntentService
 * JD-Core Version:    0.6.2
 */