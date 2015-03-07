package cn.jpush.android.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import cn.jpush.android.data.d;
import cn.jpush.android.util.x;
import java.util.List;

public class ListViewActivity extends Activity
{
  private static final String z;
  private d a;

  static
  {
    Object localObject1 = "l\031N\030".toCharArray();
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
        i1 = 48;
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
      i1 = 14;
      continue;
      i1 = 118;
      continue;
      i1 = 42;
      continue;
      i1 = 97;
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    x.d();
    super.onCreate(paramBundle);
    if (getIntent() != null)
    {
      this.a = ((d)getIntent().getSerializableExtra(z));
      d locald = this.a;
      x.d();
      GridView localGridView = new GridView(getApplicationContext());
      localGridView.setNumColumns(2);
      List localList = locald.C;
      localGridView.setAdapter(new h(this, -2147483648, localList));
      localGridView.setOnItemClickListener(new g(this, localList));
      setContentView(localGridView);
      return;
    }
    x.e();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.ListViewActivity
 * JD-Core Version:    0.6.2
 */