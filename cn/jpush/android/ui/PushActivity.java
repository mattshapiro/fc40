package cn.jpush.android.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import cn.jpush.android.api.m;
import cn.jpush.android.data.d;
import cn.jpush.android.data.g;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.util.x;

public class PushActivity extends Activity
{
  private static final String[] z;
  private d a;
  private String b;
  private g c;
  private a d;
  private boolean e = false;
  private ProgressDialog f;
  private Handler g = new k(this);

  static
  {
    Object localObject1 = new String[4];
    int i = 0;
    String str1 = "jsA>#5";
    int j = -1;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label35: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label51: int i2;
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
        i3 = 4;
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
        break label51;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "nuIc";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "Et[{he~\rwwk:Ycti:Yu$rBm$!:";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "eixj`mnHLa~iDuj";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        z = localObject2;
        return;
        i3 = 12;
        continue;
        i3 = 26;
        continue;
        i3 = 45;
        continue;
        i3 = 26;
      }
    }
  }

  private void a(Intent paramIntent)
  {
    boolean bool = paramIntent.getBooleanExtra(z[3], false);
    this.a = ((d)paramIntent.getSerializableExtra(z[1]));
    this.b = this.a.c;
    if (bool)
    {
      if (this.a != null);
      return;
    }
    if (this.a != null);
    switch (this.a.o)
    {
    case 2:
    default:
      new StringBuilder(z[2]).append(this.a.o).toString();
      x.e();
      m.a(this, this.a, 0);
      finish();
      return;
    case 1:
      this.g.removeMessages(2);
      this.g.removeMessages(3);
      this.g.sendEmptyMessageDelayed(2, 500L);
      return;
    case 0:
    }
    this.g.removeMessages(4);
    this.g.removeMessages(5);
    this.g.sendEmptyMessageDelayed(4, 500L);
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.e)
      ServiceInterface.a(this.b, 1008, this);
    while (true)
    {
      finish();
      return;
      ServiceInterface.a(this.b, 1006, this);
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    x.c();
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      this.a = ((d)getIntent().getSerializableExtra(z[1]));
      if ((this.a != null) && (this.a.z == 2))
      {
        this.a.z = 1;
        this.a.p = 3;
        m.a(this, this.a);
      }
      requestWindowFeature(1);
      if (this.a.q)
        getWindow().setFlags(1024, 1024);
      a(getIntent());
      return;
    }
    x.e();
  }

  protected void onDestroy()
  {
    if (this.c != null)
      this.c.a();
    if (this.d != null)
      this.d.a();
    if (this.f != null)
      this.f.dismiss();
    super.onDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    a(paramIntent);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.PushActivity
 * JD-Core Version:    0.6.2
 */