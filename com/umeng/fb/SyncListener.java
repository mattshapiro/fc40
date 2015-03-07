package com.umeng.fb;

import com.umeng.fb.model.Reply;
import java.util.List;

public abstract interface SyncListener
{
  public abstract void onReceiveDevReply(List<Reply> paramList);

  public abstract void onSendUserReply(List<Reply> paramList);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.SyncListener
 * JD-Core Version:    0.6.2
 */