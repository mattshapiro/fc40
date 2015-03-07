package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jpush.android.api.m;
import cn.jpush.android.data.c;
import cn.jpush.android.data.d;
import cn.jpush.android.data.l;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.k;
import cn.jpush.android.util.x;
import java.io.File;

public class PushReceiver extends BroadcastReceiver
{
  public static d a;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[47];
    int i = 0;
    String str1 = "\017pZ85O?j?|O70";
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
        i3 = 21;
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
        str1 = "斘沅丳泶朜谢畸";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "B>0=eT#vytO4l8|E~P\030Ah\026W\024Tu\031Q\031Ju\tN\022";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "`\023J\036Zo\017P\030Ah\026W\024Tu\031Q\031Js\025]\022\\w\025Z\bEs\037F\0165\001pp8aH6w4tU9q9JU)n25\034p";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "+Z朲掇礯友坸弞历扆匤狦怟乜凯玑|叏幔扆匤九伄冭玥\017";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "+\032N\"fI\031p#pS64p\017?p\005pR%s2=\b";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "R$l\031AX {w(\001";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "Q1}<tF5$";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "U)n2";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "@>z%zH40>{U5p#;@3j>zO~N\026Vj\021Y\022J`\024Z\022Q";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "@3j>cH$g";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "@>z%zH40>{U5p#;@3j>zO~\\\030Zu\017]\030Xq\034[\003Pe";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "B>0=eT#vytO4l8|E~w9aD>jy[n\004W\021\\b\021J\036Zo\017Q\007Po\025Z";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "C?z.";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "B>0=eT#vytO4l8|E~w9aD>jy[n\004W\021\\b\021J\036Zo\017W\031Fu\021R\033Jb\034W\024^d\024";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "@ n;|B1j>zOh9q\0171p3gN9zye@3u6rD}%vI9h2";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "O5j zS;W9sN";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "B>0=eT#vytO4l8|E~w9aD>jy[n\004W\021\\b\021J\036Zo\017Q\007Po\025Z\bEs\037F\016";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "E5|\"r~>q#|G9}6aH?p";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "O?]8{O5}#|W9j.";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "+盔\0248{q1k$p\ty\024";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "@>z%zH40>{U5p#;@3j>zO~K\004Ps\017N\005Pr\025P\003";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "@ n";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "N$v2g\001>{#bN\"uwfU1j25\fp";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        i = 25;
        str1 = "O?j>sH3>zO\017j.eD";
        j = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i] = str2;
        i = 26;
        str1 = "N>L2vD9h25\fp";
        j = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i] = str2;
        i = 27;
        str1 = "b?p9pB$w8{\001#j6aDp}?tO7{35U?>z5";
        j = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i] = str2;
        i = 28;
        str1 = "";
        j = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i] = str2;
        i = 29;
        str1 = "";
        j = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[i] = str2;
        i = 30;
        str1 = "U?$au5f#";
        j = 29;
        localObject1 = localObject2;
        break;
      case 29:
        localObject1[i] = str2;
        i = 31;
        str1 = "q%m?GD3{>cD\"";
        j = 30;
        localObject1 = localObject2;
        break;
      case 30:
        localObject1[i] = str2;
        i = 32;
        str1 = "L5m$tF5";
        j = 31;
        localObject1 = localObject2;
        break;
      case 31:
        localObject1[i] = str2;
        i = 33;
        str1 = "@>z%zH40>{U5p#;@3j>zO~H\036Pv";
        j = 32;
        localObject1 = localObject2;
        break;
      case 32:
        localObject1[i] = str2;
        i = 34;
        str1 = "O?j\btT$q%`O";
        j = 33;
        localObject1 = localObject2;
        break;
      case 33:
        localObject1[i] = str2;
        i = 35;
        str1 = "L#y\b|E";
        j = 34;
        localObject1 = localObject2;
        break;
      case 34:
        localObject1[i] = str2;
        i = 36;
        str1 = "R5p3pS\031z";
        j = 35;
        localObject1 = localObject2;
        break;
      case 35:
        localObject1[i] = str2;
        i = 37;
        str1 = "+盔\0248{s5m\"xDx7]";
        j = 36;
        localObject1 = localObject2;
        break;
      case 36:
        localObject1[i] = str2;
        i = 38;
        str1 = "@ n\036q";
        j = 37;
        localObject1 = localObject2;
        break;
      case 37:
        localObject1[i] = str2;
        i = 39;
        str1 = "@>z%zH409pU~}8{O~]\030[o\025]\003\\w\031J\016Jb\030_\031Rd";
        j = 38;
        localObject1 = localObject2;
        break;
      case 38:
        localObject1[i] = str2;
        i = 40;
        str1 = "o?>\026Vu\031Q\031Jo\037J\036Sh\023_\003\\n\036A\030Ed\036[\0235E5x>{D4>>{\001=9|G5m#9\001?n2{\001$v25E5x6`M$>:tH>>6vU9h>aX";
        j = 39;
        localObject1 = localObject2;
        break;
      case 39:
        localObject1[i] = str2;
        i = 41;
        str1 = "@>z%zH40>{U5p#;@3j>zO~N\026Vj\021Y\022Js\025S\030Cd\024";
        j = 40;
        localObject1 = localObject2;
        break;
      case 40:
        localObject1[i] = str2;
        i = 42;
        str1 = "B>0=eT#vytO4l8|E~N\002Fi\017W\023";
        j = 41;
        localObject1 = localObject2;
        break;
      case 41:
        localObject1[i] = str2;
        i = 43;
        str1 = "+\032N\"fI\031p#pS64p\017?p\005pR%s2=\bZT\007`R8W9aD\"x6vD~q9E@%m2=\b";
        j = 42;
        localObject1 = localObject2;
        break;
      case 42:
        localObject1[i] = str2;
        i = 44;
        str1 = "r5p35C\"q6qB1m#5U?>6eQj>";
        j = 43;
        localObject1 = localObject2;
        break;
      case 43:
        localObject1[i] = str2;
        i = 45;
        str1 = "\017 {%xH#m>zO~T\007@r\030A\032Pr\003_\020P";
        j = 44;
        localObject1 = localObject2;
        break;
      case 44:
        localObject1[i] = str2;
        i = 46;
        str1 = "+\032N\"fI\031p#pS64p\017?p\007tT#{<";
        j = 45;
        localObject1 = localObject2;
        break;
      case 45:
        localObject1[i] = str2;
        z = localObject2;
        a = null;
        return;
        i3 = 33;
        continue;
        i3 = 80;
        continue;
        i3 = 30;
        continue;
        i3 = 87;
      }
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getAction();
    new StringBuilder(z[26]).append(str1).toString();
    x.c();
    if (!cn.jpush.android.a.a(paramContext.getApplicationContext()))
    {
      break label39;
      break label39;
      break label39;
      break label39;
      break label39;
      break label39;
    }
    label39: 
    while (str1 == null)
      return;
    if (str1.equals(z[11]))
    {
      ae.a(paramContext);
      k.d(paramContext);
      if (PushService.a())
      {
        ServiceInterface.c(paramContext, 500);
        return;
      }
      x.d();
      return;
    }
    String str13;
    String str14;
    if (str1.equals(z[9]))
    {
      str13 = paramIntent.getDataString().replace(z[7], "");
      str14 = c.a(paramContext, str13);
      ServiceInterface.a(paramContext, p.a(str13));
    }
    while (true)
    {
      String str15;
      try
      {
        if (TextUtils.isEmpty(str14))
          break label39;
        String[] arrayOfString = str14.split(",");
        if (arrayOfString.length <= 0)
          break label39;
        str15 = arrayOfString[0];
        ServiceInterface.a(str15, 1002, paramContext);
        if (arrayOfString.length < 2)
          break label1605;
        str16 = arrayOfString[1];
        str17 = "";
        if (arrayOfString.length >= 3)
          str17 = arrayOfString[2];
        x.f();
        if ((!str16.equals(z[34])) && (!cn.jpush.android.util.a.a(paramContext, str13, str16)))
        {
          x.c();
          ServiceInterface.a(str15, 1100, paramContext);
        }
        if (ai.a(str17))
          break label1598;
        m.a(paramContext, str17);
        return;
      }
      catch (Exception localException)
      {
        localException.getMessage();
        x.f();
        return;
      }
      if (str1.equals(z[41]))
      {
        ServiceInterface.a(paramContext, p.b(paramIntent.getDataString().replace(z[7], "")));
        return;
      }
      if (str1.equals(z[21]))
      {
        if ((!PushService.q) || (!PushService.a()))
          break;
        ServiceInterface.c(paramContext);
        return;
      }
      if (str1.equals(z[14]))
      {
        d locald = (d)paramIntent.getSerializableExtra(z[13]);
        if ((locald == null) || (!locald.a()))
          break;
        ServiceInterface.a(locald.c, 1015, paramContext);
        l locall = (l)locald;
        Intent localIntent2 = new Intent();
        localIntent2.addFlags(268435456);
        localIntent2.setAction(z[33]);
        localIntent2.setDataAndType(Uri.fromFile(new File(locall.ah)), z[15]);
        paramContext.startActivity(localIntent2);
        return;
      }
      if (str1.startsWith(z[29]))
      {
        int i4 = paramIntent.getIntExtra(z[25], 0);
        new StringBuilder(z[3]).append(i4).toString();
        x.c();
        if (i4 == 0)
        {
          if (ServiceInterface.j(paramContext))
          {
            x.d();
            return;
          }
          if (!cn.jpush.android.util.a.o(paramContext))
          {
            x.d();
            return;
          }
        }
        String str11 = paramIntent.getStringExtra(z[32]);
        if (ai.a(str11))
          break;
        String str12 = paramIntent.getStringExtra(z[36]);
        cn.jpush.android.data.a locala = cn.jpush.android.data.p.a(paramContext, str11, paramIntent.getStringExtra(z[38]), str12, paramIntent.getStringExtra(z[35]));
        if (locala == null)
        {
          x.e();
          return;
        }
        if (locala.e)
        {
          locala.h = true;
          cn.jpush.android.data.p.a(paramContext, locala);
        }
        abortBroadcast();
        return;
      }
      String str2;
      if (str1.startsWith(z[17]))
      {
        if (paramIntent.getBooleanExtra(z[18], false))
        {
          String str5 = paramIntent.getStringExtra(z[10]);
          int j = paramIntent.getIntExtra(z[8], -1);
          if (j == -1)
          {
            String str10 = paramIntent.getStringExtra(z[30]);
            Toast localToast2 = Toast.makeText(paramContext, str5, 1);
            View localView3 = localToast2.getView();
            if ((localView3 instanceof LinearLayout))
            {
              View localView4 = ((LinearLayout)localView3).getChildAt(0);
              if ((localView4 instanceof TextView))
              {
                TextView localTextView2 = (TextView)localView4;
                if (!ai.a(str10))
                  localTextView2.setText(str10);
                localTextView2.setTextSize(13.0F);
              }
            }
            localToast2.show();
            return;
          }
          if (ai.a(str5))
            break;
          String str6 = z[23];
          String str7 = z[37];
          String str8 = z[1];
          String str9 = z[5];
          switch (j)
          {
          case 0:
          default:
          case 1:
          case 2:
          }
          while (true)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str6).append(str5).append(str7).append(str8).append(str9).append(z[4]);
            SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localStringBuilder);
            int k = str6.length();
            int m = k + str5.length();
            localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-13527041), k, m, 33);
            int n = m + 2;
            int i1 = -2 + (n + str7.length());
            localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-13527041), n, i1, 33);
            int i2 = i1 + str8.length();
            int i3 = i2 + str9.length();
            localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-13527041), i2, i3, 33);
            Toast localToast1 = Toast.makeText(paramContext, str5, 1);
            View localView1 = localToast1.getView();
            if ((localView1 instanceof LinearLayout))
            {
              View localView2 = ((LinearLayout)localView1).getChildAt(0);
              if ((localView2 instanceof TextView))
              {
                TextView localTextView1 = (TextView)localView2;
                if (localSpannableStringBuilder != null)
                  localTextView1.setText(localSpannableStringBuilder);
                localTextView1.setTextSize(13.0F);
              }
            }
            localToast1.show();
            return;
            str7 = z[20];
            str8 = z[1];
            str9 = z[46];
            continue;
            str7 = z[28];
            str8 = z[1];
            str9 = z[43];
          }
        }
        str2 = paramIntent.getStringExtra(z[42]);
        if (!ai.a(str2))
        {
          String str4 = paramIntent.getStringExtra(z[2]);
          new StringBuilder(z[6]).append(str4).toString();
          x.c();
          if ((str4 == null) || (!"1".equals(str4)))
            break label1592;
        }
      }
      label1592: for (int i = 1; ; i = 0)
      {
        if (1 != i)
          ServiceInterface.a(str2, 1000, paramContext);
        if (!cn.jpush.android.util.a.a(paramContext, z[12], true))
        {
          x.b(z[31], z[40]);
          cn.jpush.android.util.a.f(paramContext);
          return;
        }
        Intent localIntent1 = new Intent(z[12]);
        localIntent1.putExtras(paramIntent.getExtras());
        String str3 = paramIntent.getStringExtra(z[22]);
        if (ai.a(str3))
          str3 = paramContext.getPackageName();
        localIntent1.addCategory(str3);
        new StringBuilder(z[44]).append(str3).toString();
        x.d();
        paramContext.sendBroadcast(localIntent1, str3 + z[45]);
        return;
        if (!str1.equalsIgnoreCase(z[39]))
          break;
        NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra(z[16]);
        if (localNetworkInfo == null)
          break;
        new StringBuilder(z[27]).append(localNetworkInfo.toString()).toString();
        x.b();
        if (paramIntent.getBooleanExtra(z[19], false))
        {
          x.b();
          a.b = false;
          ServiceInterface.b(paramContext);
          return;
        }
        if (NetworkInfo.State.CONNECTED == localNetworkInfo.getState())
        {
          ServiceInterface.f(paramContext);
          x.b();
          a.b = true;
          if (DownloadService.a())
            DownloadService.a(paramContext);
          if (PushService.r)
            ServiceInterface.c(paramContext, 3000);
          if (a == null)
            break;
          m.b(paramContext, a);
          return;
        }
        if (NetworkInfo.State.DISCONNECTED == localNetworkInfo.getState())
        {
          x.b();
          a.b = false;
          ServiceInterface.b(paramContext);
          return;
        }
        new StringBuilder(z[24]).append(localNetworkInfo.getState()).append(z[0]).toString();
        x.b();
        return;
      }
      label1598: String str17 = str15;
      continue;
      label1605: String str16 = "";
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.PushReceiver
 * JD-Core Version:    0.6.2
 */