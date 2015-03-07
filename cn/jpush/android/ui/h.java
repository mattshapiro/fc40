package cn.jpush.android.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.jpush.android.data.d;
import cn.jpush.android.data.l;
import cn.jpush.android.data.o;
import cn.jpush.android.util.a;
import cn.jpush.android.util.x;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class h extends ArrayAdapter<d>
{
  private static final String[] z;
  private Context a = null;

  static
  {
    String[] arrayOfString1 = new String[3];
    String str1 = "";
    int i = -1;
    String[] arrayOfString2 = arrayOfString1;
    int j = 0;
    Object localObject1 = str1.toCharArray();
    int k = localObject1.length;
    int m;
    label35: int i3;
    if (k <= 1)
    {
      m = 0;
      Object localObject2 = localObject1;
      int n = m;
      int i1 = k;
      Object localObject3 = localObject1;
      while (true)
      {
        int i2 = localObject3[m];
        switch (n % 5)
        {
        default:
          i3 = 112;
          label96: localObject3[m] = ((char)(i3 ^ i2));
          m = n + 1;
          if (i1 != 0)
            break label133;
          localObject3 = localObject2;
          n = m;
          m = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label133: k = i1;
      localObject1 = localObject2;
    }
    while (true)
    {
      if (k > m)
        break label35;
      String str2 = new String((char[])localObject1).intern();
      switch (i)
      {
      default:
        arrayOfString2[j] = str2;
        str1 = "";
        j = 1;
        arrayOfString2 = arrayOfString1;
        i = 0;
        break;
      case 0:
        arrayOfString2[j] = str2;
        j = 2;
        arrayOfString2 = arrayOfString1;
        str1 = "ah>\026\025qX.\025^:)<\034\027";
        i = 1;
        break;
      case 1:
        arrayOfString2[j] = str2;
        z = arrayOfString1;
        return;
        i3 = 3;
        break label96;
        i3 = 7;
        break label96;
        i3 = 76;
        break label96;
        i3 = 114;
        break label96;
        m = 0;
      }
    }
  }

  public h(Context paramContext, int paramInt, List<d> paramList)
  {
    super(paramContext, -2147483648, paramList);
    this.a = paramContext;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      d locald = (d)getItem(paramInt);
      int i = a.a(this.a, 5.0F);
      paramView = new FrameLayout(this.a);
      LinearLayout localLinearLayout1 = new LinearLayout(this.a);
      localLinearLayout1.setPadding(i, i, i, i);
      localLinearLayout1.setOrientation(1);
      try
      {
        localInputStream = this.a.getResources().getAssets().open(z[2]);
        localBitmap2 = BitmapFactory.decodeStream(localInputStream);
        if (localBitmap2 == null)
          throw new RuntimeException(z[1]);
      }
      catch (IOException localIOException1)
      {
        RelativeLayout localRelativeLayout;
        LinearLayout localLinearLayout4;
        while (true)
        {
          InputStream localInputStream;
          Bitmap localBitmap2;
          LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-2, -2);
          LinearLayout localLinearLayout2 = new LinearLayout(this.a);
          localLinearLayout2.setOrientation(0);
          localLinearLayout1.addView(localLinearLayout2, localLayoutParams1);
          ImageView localImageView1 = new ImageView(this.a);
          localImageView1.setBackgroundColor(-16711936);
          localImageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
          Bitmap localBitmap1 = BitmapFactory.decodeFile(((l)locald).ad.l);
          if (localBitmap1 != null)
            localImageView1.setImageBitmap(localBitmap1);
          int j = a.a(this.a, 45.0F);
          localLinearLayout2.addView(localImageView1, new LinearLayout.LayoutParams(j, j));
          LinearLayout localLinearLayout3 = new LinearLayout(this.a);
          localLinearLayout3.setOrientation(1);
          TextView localTextView1 = new TextView(this.a);
          localTextView1.setTextSize(22.0F);
          localTextView1.setSingleLine();
          localTextView1.setEllipsize(TextUtils.TruncateAt.END);
          localTextView1.setText(locald.c);
          localLinearLayout3.addView(localTextView1);
          TextView localTextView2 = new TextView(this.a);
          localTextView2.setSingleLine();
          localTextView2.setEllipsize(TextUtils.TruncateAt.END);
          localTextView2.setText(locald.c);
          localLinearLayout3.addView(localTextView2);
          LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-2, -2);
          localLayoutParams2.gravity = 16;
          localLayoutParams2.leftMargin = a.a(this.a, 5.0F);
          localLayoutParams2.rightMargin = a.a(this.a, 5.0F);
          localLinearLayout2.addView(localLinearLayout3, localLayoutParams2);
          localRelativeLayout = new RelativeLayout(this.a);
          int k = a.a(this.a, 18.0F);
          LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(k, k);
          localLinearLayout4 = new LinearLayout(this.a);
          localLinearLayout4.setOrientation(0);
          int m = 0;
          label470: if (m < 3)
          {
            ImageView localImageView2 = new ImageView(this.a);
            try
            {
              localImageView2.setImageBitmap(BitmapFactory.decodeStream(this.a.getAssets().open(z[0])));
              localLinearLayout4.addView(localImageView2, localLayoutParams3);
              m++;
              break label470;
              paramView.setBackgroundDrawable(new NinePatchDrawable(this.a.getResources(), new NinePatch(localBitmap2, localBitmap2.getNinePatchChunk(), null)));
              localInputStream.close();
            }
            catch (IOException localIOException2)
            {
              while (true)
              {
                h.class.getSimpleName();
                localIOException2.getMessage();
                x.f();
              }
            }
          }
        }
        RelativeLayout.LayoutParams localLayoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams4.addRule(9, -1);
        localLayoutParams4.addRule(15, -1);
        localRelativeLayout.addView(localLinearLayout4, localLayoutParams4);
        RelativeLayout.LayoutParams localLayoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams5.addRule(11, -1);
        localLayoutParams5.addRule(15, -1);
        localRelativeLayout.addView(new TextView(this.a), localLayoutParams5);
        LinearLayout.LayoutParams localLayoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams6.topMargin = a.a(this.a, 5.0F);
        localLinearLayout1.addView(localRelativeLayout, localLayoutParams6);
        FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2);
        localLayoutParams.gravity = 17;
        localLayoutParams.topMargin = a.a(this.a, 2.0F);
        localLayoutParams.leftMargin = localLayoutParams.topMargin;
        localLayoutParams.bottomMargin = localLayoutParams.topMargin;
        localLayoutParams.rightMargin = localLayoutParams.topMargin;
        paramView.addView(localLinearLayout1, localLayoutParams);
      }
    }
    return paramView;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.ui.h
 * JD-Core Version:    0.6.2
 */