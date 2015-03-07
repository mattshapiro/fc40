package com.umeng.fb.example;

import android.content.Context;
import android.content.Intent;
import com.umeng.fb.push.FBMessage;
import com.umeng.fb.push.FeedbackPush;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

public class AppPush
{
  private static AppPush mAppPush;
  private Context context;
  public UmengMessageHandler mMessageHandler;

  public AppPush(Context paramContext)
  {
    this.context = paramContext;
  }

  public static AppPush getInstance(Context paramContext)
  {
    if (mAppPush == null)
      mAppPush = new AppPush(paramContext);
    return mAppPush;
  }

  public void init()
  {
    this.mMessageHandler = new UmengMessageHandler()
    {
      public void dealWithCustomMessage(Context paramAnonymousContext, UMessage paramAnonymousUMessage)
      {
        if (FeedbackPush.getInstance(paramAnonymousContext).dealFBMessage(new FBMessage(paramAnonymousUMessage.custom)))
          return;
        paramAnonymousContext.startActivity(new Intent(paramAnonymousContext, CustomActivity.class));
      }
    };
    PushAgent.getInstance(this.context).setMessageHandler(this.mMessageHandler);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.example.AppPush
 * JD-Core Version:    0.6.2
 */