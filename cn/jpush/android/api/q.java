package cn.jpush.android.api;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import cn.jpush.android.data.d;

public final class q
{
  private static int a;
  private static int b;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[7];
    int i = 0;
    String str1 = "7\003\033\026Z\002\020\002\nA8]\036\013U";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label36: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label52: int i2;
    int i3;
    if (k <= 1)
    {
      localObject4 = localObject3;
      n = m;
      i1 = k;
      localObject5 = localObject3;
      i2 = localObject5[m];
      switch (n % 5)
      {
      default:
        i3 = 50;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[m] = ((char)(i3 ^ i2));
      m = n + 1;
      if (i1 == 0)
      {
        localObject5 = localObject4;
        n = m;
        m = i1;
        break label52;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label36;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "$\027\036\f\022gS";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "%\027\036\f\022gS";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "*\032\n\021Z}IN";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "5\026\007\002Z)STE";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        z = localObject2;
        a = 400;
        b = 600;
        return;
        i3 = 93;
        continue;
        i3 = 115;
        continue;
        i3 = 110;
        continue;
        i3 = 101;
      }
    }
  }

  public static int a()
  {
    return a;
  }

  // ERROR //
  private static android.graphics.Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 55	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 61	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   7: astore_2
    //   8: aload_2
    //   9: aload_1
    //   10: invokevirtual 67	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore 6
    //   15: aload 6
    //   17: invokestatic 73	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   20: astore 7
    //   22: aload 7
    //   24: astore 4
    //   26: aload 6
    //   28: invokevirtual 78	java/io/InputStream:close	()V
    //   31: aload 4
    //   33: areturn
    //   34: astore_3
    //   35: aconst_null
    //   36: astore 4
    //   38: aload_3
    //   39: astore 5
    //   41: aload 5
    //   43: invokevirtual 81	java/io/IOException:printStackTrace	()V
    //   46: aload 4
    //   48: areturn
    //   49: astore 5
    //   51: goto -10 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   8	22	34	java/io/IOException
    //   26	31	49	java/io/IOException
  }

  public static void a(Context paramContext, d paramd)
  {
    new Handler(Looper.getMainLooper()).post(new r(paramd, paramContext));
  }

  public static void a(WindowManager paramWindowManager, WebView paramWebView, ImageButton paramImageButton)
  {
    paramWindowManager.removeView(paramWebView);
    paramWindowManager.removeView(paramImageButton);
  }

  public static int b()
  {
    return b;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.q
 * JD-Core Version:    0.6.2
 */