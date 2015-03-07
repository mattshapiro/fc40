package com.umeng.update;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import java.io.File;
import u.upd.a;
import u.upd.c;

public class UpdateDialogActivity extends Activity
{
  int a = 6;
  UpdateResponse b;
  boolean c = false;
  File d = null;

  protected void onCreate(Bundle paramBundle)
  {
    int i = 1;
    super.onCreate(paramBundle);
    requestWindowFeature(i);
    setContentView(c.a(this).d("umeng_update_dialog"));
    this.b = ((UpdateResponse)getIntent().getExtras().getSerializable("response"));
    String str1 = getIntent().getExtras().getString("file");
    boolean bool = getIntent().getExtras().getBoolean("force");
    int k;
    int m;
    final int n;
    int i1;
    final int i2;
    int i3;
    int i4;
    View.OnClickListener local1;
    CompoundButton.OnCheckedChangeListener local2;
    if (str1 != null)
    {
      if (i != 0)
        this.d = new File(str1);
      k = c.a(this).b("umeng_update_content");
      m = c.a(this).b("umeng_update_wifi_indicator");
      n = c.a(this).b("umeng_update_id_ok");
      i1 = c.a(this).b("umeng_update_id_cancel");
      i2 = c.a(this).b("umeng_update_id_ignore");
      i3 = c.a(this).b("umeng_update_id_close");
      i4 = c.a(this).b("umeng_update_id_check");
      local1 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (n == paramAnonymousView.getId())
            UpdateDialogActivity.this.a = 5;
          while (true)
          {
            UpdateDialogActivity.this.finish();
            return;
            if (i2 == paramAnonymousView.getId())
              UpdateDialogActivity.this.a = 7;
            else if (UpdateDialogActivity.this.c)
              UpdateDialogActivity.this.a = 7;
          }
        }
      };
      local2 = new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          UpdateDialogActivity.this.c = paramAnonymousBoolean;
        }
      };
      if (m > 0)
        if (!a.k(this))
          break label338;
    }
    label338: for (int i5 = 8; ; i5 = 0)
    {
      findViewById(m).setVisibility(i5);
      if (bool)
        findViewById(i4).setVisibility(8);
      findViewById(n).setOnClickListener(local1);
      findViewById(i1).setOnClickListener(local1);
      findViewById(i2).setOnClickListener(local1);
      findViewById(i3).setOnClickListener(local1);
      ((CheckBox)findViewById(i4)).setOnCheckedChangeListener(local2);
      String str2 = this.b.a(this, i);
      TextView localTextView = (TextView)findViewById(k);
      localTextView.requestFocus();
      localTextView.setText(str2);
      return;
      int j = 0;
      break;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    UmengUpdateAgent.a(this.a, this, this.b, this.d);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.update.UpdateDialogActivity
 * JD-Core Version:    0.6.2
 */