package com.umeng.update;

import android.content.Context;
import com.umeng.update.util.DeltaUpdate;
import u.upd.g;

public class b extends g
{
  private static final String c = b.class.getName();
  Context a;
  private final String[] b = { "http://au.umeng.com/api/check_app_update", "http://au.umeng.co/api/check_app_update" };

  public b(Context paramContext)
  {
    this.a = paramContext;
  }

  public boolean a()
  {
    return false;
  }

  public UpdateResponse b()
  {
    String str = c;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(DeltaUpdate.a());
    u.upd.b.c(str, String.format("is .so file ready: %b", arrayOfObject));
    d locald = new d(this.a);
    UpdateResponse localUpdateResponse = null;
    for (int i = 0; ; i++)
    {
      if (i >= this.b.length);
      do
      {
        return localUpdateResponse;
        locald.a(this.b[i]);
        localUpdateResponse = (UpdateResponse)a(locald, UpdateResponse.class);
      }
      while (localUpdateResponse != null);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.b
 * JD-Core Version:    0.6.2
 */