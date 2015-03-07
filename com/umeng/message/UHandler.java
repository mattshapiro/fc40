package com.umeng.message;

import android.content.Context;
import com.umeng.message.entity.UMessage;

public abstract interface UHandler
{
  public abstract void handleMessage(Context paramContext, UMessage paramUMessage);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.UHandler
 * JD-Core Version:    0.6.2
 */