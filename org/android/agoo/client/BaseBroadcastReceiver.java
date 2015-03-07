package org.android.agoo.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.umeng.message.proguard.bz;

public abstract class BaseBroadcastReceiver extends BroadcastReceiver
{
  protected abstract String a(Context paramContext);

  protected void a(Context paramContext, Intent paramIntent)
  {
  }

  public final void onReceive(final Context paramContext, final Intent paramIntent)
  {
    try
    {
      bz.a(new Runnable()
      {
        public void run()
        {
          try
          {
            BaseBroadcastReceiver.this.a(paramContext, paramIntent);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      });
      BaseIntentService.a(paramContext, paramIntent, a(paramContext));
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     org.android.agoo.client.BaseBroadcastReceiver
 * JD-Core Version:    0.6.2
 */