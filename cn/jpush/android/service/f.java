package cn.jpush.android.service;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

final class f extends Handler
{
  private static final String z;
  private Context b;

  static
  {
    Object localObject1 = "Gb:]\027p\006\032]\0134H\026HEcI\013W".toCharArray();
    int i = localObject1.length;
    int j = 0;
    Object localObject2;
    int k;
    int m;
    Object localObject3;
    label27: int n;
    int i1;
    if (i <= 1)
    {
      localObject2 = localObject1;
      k = j;
      m = i;
      localObject3 = localObject1;
      n = localObject3[j];
      switch (k % 5)
      {
      default:
        i1 = 101;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject3[j] = ((char)(i1 ^ n));
      j = k + 1;
      if (m == 0)
      {
        localObject3 = localObject2;
        k = j;
        j = m;
        break label27;
      }
      i = m;
      localObject1 = localObject2;
      if (i > j)
        break;
      z = new String((char[])localObject1).intern();
      return;
      i1 = 20;
      continue;
      i1 = 38;
      continue;
      i1 = 121;
      continue;
      i1 = 60;
    }
  }

  public f(DownloadService paramDownloadService, Context paramContext)
  {
    super(paramContext.getMainLooper());
    this.b = paramContext;
  }

  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Toast.makeText(this.b, z, 1).show();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.f
 * JD-Core Version:    0.6.2
 */