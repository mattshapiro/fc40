package com.allinone.free.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class MyCustomDialog extends Dialog
{
  private Context ctx;

  public MyCustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.ctx = paramContext;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
  }

  public static abstract interface OnCustomDialogListener
  {
    public abstract void back(String paramString);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.dialog.MyCustomDialog
 * JD-Core Version:    0.6.2
 */