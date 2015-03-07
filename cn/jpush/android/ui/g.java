package cn.jpush.android.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.jpush.android.data.d;
import cn.jpush.android.util.a;
import java.util.List;

final class g
  implements AdapterView.OnItemClickListener
{
  g(ListViewActivity paramListViewActivity, List paramList)
  {
  }

  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    d locald = (d)this.a.get(paramInt);
    locald.q = false;
    Intent localIntent = a.a(this.b, locald, false);
    this.b.startActivity(localIntent);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.g
 * JD-Core Version:    0.6.2
 */