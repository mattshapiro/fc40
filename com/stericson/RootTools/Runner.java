package com.stericson.RootTools;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

class Runner extends Thread
{
  private static final String LOG_TAG = "RootTools::Runner";
  String binaryName;
  Context context;
  String parameter;

  public Runner(Context paramContext, String paramString1, String paramString2)
  {
    this.context = paramContext;
    this.binaryName = paramString1;
    this.parameter = paramString2;
  }

  public void run()
  {
    try
    {
      String str2 = this.context.getFilesDir().getCanonicalPath();
      str1 = str2;
      if (str1 == null);
    }
    catch (IOException localIOException)
    {
      try
      {
        InternalMethods localInternalMethods = new InternalMethods();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = (str1 + "/" + this.binaryName + " " + this.parameter);
        localInternalMethods.doExec(arrayOfString, -1);
        return;
        localIOException = localIOException;
        if (RootTools.debugMode)
          Log.e("RootTools::Runner", "Problem occured while trying to locate private files directory!");
        localIOException.printStackTrace();
        String str1 = null;
      }
      catch (TimeoutException localTimeoutException)
      {
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.stericson.RootTools.Runner
 * JD-Core Version:    0.6.2
 */