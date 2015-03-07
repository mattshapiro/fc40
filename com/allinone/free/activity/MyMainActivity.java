package com.allinone.free.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;
import cn.jpush.android.api.JPushInterface;
import com.allinone.free.dialog.NointentDialog;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.dialog.UpdateDialogVerison2;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.utils.Myutils;
import com.allinone.free.utils.publicTools;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;
import com.umeng.message.PushAgent;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

public class MyMainActivity extends TabActivity
  implements RadioGroup.OnCheckedChangeListener, AdListener
{
  public static final int UPDATE_TAG = 564;
  private static Typeface typeFace = null;
  private AdView adView;
  private LinearLayout banner;
  private String banner_type_name = "";
  private long firstTime = 0L;
  Handler handlertimer = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 10000:
      case 20:
      case 10:
      }
      while (true)
      {
        super.handleMessage(paramAnonymousMessage);
        return;
        try
        {
          if (System.currentTimeMillis() - Myutils.setting_json.getLong("neitui_time") <= 43200000L)
            continue;
          MyMainActivity.this.updateDialogVersion2 = new UpdateDialogVerison2(MyMainActivity.this, 2131165281, MyMainActivity.this.itemsOnClick2);
          MyMainActivity.this.updateDialogVersion2.setCanceledOnTouchOutside(false);
          MyMainActivity.this.updateDialogVersion2.show();
          MyMainActivity.this.updateDialogVersion2.setTvTitle(MyMainActivity.this.info.getNtTitle());
          MyMainActivity.this.updateDialogVersion2.setTvContent(MyMainActivity.this.info.getNtMsg());
          MyMainActivity.this.updateDialogVersion2.setImgIcon(MyMainActivity.this.info.getPicPath());
          Myutils.setting_json.put("neitui_time", System.currentTimeMillis());
          Myutils.saveSetting();
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          try
          {
            Myutils.setting_json.put("neitui_time", System.currentTimeMillis());
            Myutils.saveSetting();
            MyMainActivity.this.updateDialogVersion2 = new UpdateDialogVerison2(MyMainActivity.this, 2131165281, MyMainActivity.this.itemsOnClick2);
            MyMainActivity.this.updateDialogVersion2.setCanceledOnTouchOutside(false);
            MyMainActivity.this.updateDialogVersion2.show();
            MyMainActivity.this.updateDialogVersion2.setTvTitle(MyMainActivity.this.info.getNtTitle());
            MyMainActivity.this.updateDialogVersion2.setTvContent(MyMainActivity.this.info.getNtMsg());
            MyMainActivity.this.updateDialogVersion2.setImgIcon(MyMainActivity.this.info.getPicPath());
          }
          catch (JSONException localJSONException2)
          {
            while (true)
              localJSONException2.printStackTrace();
          }
        }
        if (MyMainActivity.this.windowFocus)
        {
          MyMainActivity.this.show_big_ad();
          continue;
          Log.v("banner_type_name", "333333" + MyMainActivity.this.banner_type_name);
          MyMainActivity.this.adView = new AdView(MyMainActivity.this, AdSize.SMART_BANNER, "ca-app-pub-1054623928013334/2194439000");
          MyMainActivity.this.banner.addView(MyMainActivity.this.adView);
          MyMainActivity.this.adView.loadAd(new AdRequest());
        }
      }
    }
  };
  Handler handlerversoin = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      String str1;
      if ((paramAnonymousMessage.what == 564) && (MyMainActivity.this.windowFocus))
      {
        MyMainActivity.this.info = ((GameInfosVersionModel)paramAnonymousMessage.obj);
        str1 = MyMainActivity.this.info.getNtId();
        MyMainActivity.this.newVersionUrl = MyMainActivity.this.info.getUpdatePath();
        if (!MyMainActivity.this.newVersionUrl.equals(""))
        {
          Log.v("version", "777777");
          View.OnClickListener local1 = new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              switch (paramAnonymous2View.getId())
              {
              case 2131230880:
              default:
                return;
              case 2131230879:
                MyMainActivity.this.updateDialogVersion.dismiss();
                return;
              case 2131230881:
              }
              Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(MyMainActivity.this.newVersionUrl));
              MyMainActivity.this.updateDialogVersion.dismiss();
              MyMainActivity.this.startActivity(localIntent);
            }
          };
          MyMainActivity.this.updateDialogVersion = new UpdateDialogVerison(MyMainActivity.this, 2131165281, local1);
          MyMainActivity.this.updateDialogVersion.setCanceledOnTouchOutside(false);
          MyMainActivity.this.updateDialogVersion.show();
          MyMainActivity.this.updateDialogVersion.setTvTitle(MyMainActivity.this.getString(2131099693));
          MyMainActivity.this.updateDialogVersion.setTvContent(MyMainActivity.this.getString(2131099694));
        }
        if ((str1 == null) || ("".equals(str1)));
      }
      try
      {
        MyMainActivity.this.packageInfo = MyMainActivity.this.getPackageManager().getPackageInfo(str1, 0);
        final String str2 = MyMainActivity.this.info.getNtPath();
        if ((MyMainActivity.this.packageInfo == null) && (str2 != null) && (!"".equals(str2)))
        {
          MyMainActivity.this.itemsOnClick2 = new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              switch (paramAnonymous2View.getId())
              {
              default:
                return;
              case 2131230882:
                MyMainActivity.this.updateDialogVersion2.dismiss();
                return;
              case 2131230883:
              }
              Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
              MyMainActivity.this.updateDialogVersion2.dismiss();
              MyMainActivity.this.startActivity(localIntent);
            }
          };
          Message localMessage = new Message();
          localMessage.what = 10000;
          MyMainActivity.this.handlertimer.sendMessageDelayed(localMessage, 5000L);
          Log.v("ppp", "10000");
        }
        return;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (true)
        {
          MyMainActivity.this.packageInfo = null;
          localNameNotFoundException.printStackTrace();
        }
      }
    }
  };
  public int in_control;
  GameInfosVersionModel info;
  private InterstitialAd interstitial;
  private Boolean is_neitui_time = Boolean.valueOf(true);
  View.OnClickListener itemsOnClick2;
  private PushAgent mPushAgent;
  private RadioGroup mainTab;
  private String myid = "";
  private String newVersionUrl = "";
  PackageInfo packageInfo;
  public RadioButton radio_button_download;
  public RadioButton radio_button_file;
  public RadioButton radio_button_home;
  public RadioButton radio_button_recommend;
  private SharedPreferences sp_config = null;
  private SharedPreferences sp_neitui_time;
  public int status;
  private TabHost tabhost;
  private Intent tidownload;
  private Intent tifile;
  private Intent tihome;
  private Intent tirecommend;
  UpdateDialogVerison updateDialogVersion = null;
  UpdateDialogVerison2 updateDialogVersion2 = null;
  private boolean windowFocus = false;

  private void Myfont()
  {
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.radio_button_home.setTypeface(typeFace);
    this.radio_button_download.setTypeface(typeFace);
    this.radio_button_file.setTypeface(typeFace);
    this.radio_button_recommend.setTypeface(typeFace);
  }

  private void init()
  {
    this.banner = ((LinearLayout)findViewById(2131230805));
    this.radio_button_home = ((RadioButton)findViewById(2131230801));
    this.radio_button_download = ((RadioButton)findViewById(2131230802));
    this.radio_button_file = ((RadioButton)findViewById(2131230803));
    this.radio_button_recommend = ((RadioButton)findViewById(2131230804));
    Myutils.packagename = getPackageName();
    publicTools.make_path_ready(Environment.getExternalStorageDirectory() + "/" + Myutils.packagename);
    Myutils.recoverSetting();
    Myutils.record_run_times();
    Myutils.saveSetting();
    Myfont();
    this.sp_config = getSharedPreferences("banner_type", 0);
    this.sp_neitui_time = getSharedPreferences("time", 0);
    Log.v("banner_type_name", "22222" + this.banner_type_name);
  }

  private void neiTui()
  {
    new Thread(new Runnable()
    {
      // ERROR //
      public void run()
      {
        // Byte code:
        //   0: ldc 26
        //   2: ldc 28
        //   4: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   7: pop
        //   8: ldc2_w 35
        //   11: invokestatic 42	java/lang/Thread:sleep	(J)V
        //   14: new 44	java/lang/StringBuilder
        //   17: dup
        //   18: ldc 46
        //   20: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   23: getstatic 55	com/allinone/free/utils/Myutils:packagename2	Ljava/lang/String;
        //   26: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   29: ldc 61
        //   31: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   34: ldc 63
        //   36: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   39: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   42: astore_3
        //   43: ldc 69
        //   45: aload_3
        //   46: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   49: pop
        //   50: new 71	java/net/URL
        //   53: dup
        //   54: aload_3
        //   55: invokespecial 72	java/net/URL:<init>	(Ljava/lang/String;)V
        //   58: invokevirtual 76	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   61: checkcast 78	java/net/HttpURLConnection
        //   64: astore 5
        //   66: aload 5
        //   68: ldc 79
        //   70: invokevirtual 83	java/net/HttpURLConnection:setConnectTimeout	(I)V
        //   73: aload 5
        //   75: ldc 85
        //   77: invokevirtual 88	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
        //   80: aload 5
        //   82: invokevirtual 92	java/net/HttpURLConnection:getResponseCode	()I
        //   85: sipush 200
        //   88: if_icmpne +640 -> 728
        //   91: new 94	java/lang/StringBuffer
        //   94: dup
        //   95: invokespecial 95	java/lang/StringBuffer:<init>	()V
        //   98: astore 6
        //   100: new 97	java/io/BufferedReader
        //   103: dup
        //   104: new 99	java/io/InputStreamReader
        //   107: dup
        //   108: aload 5
        //   110: invokevirtual 103	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   113: invokespecial 106	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
        //   116: invokespecial 109	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   119: astore 7
        //   121: aload 7
        //   123: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   126: astore 8
        //   128: aload 8
        //   130: ifnonnull +576 -> 706
        //   133: new 114	org/json/JSONObject
        //   136: dup
        //   137: aload 6
        //   139: invokevirtual 115	java/lang/StringBuffer:toString	()Ljava/lang/String;
        //   142: invokespecial 116	org/json/JSONObject:<init>	(Ljava/lang/String;)V
        //   145: astore 9
        //   147: aload_0
        //   148: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   151: aload 9
        //   153: ldc 118
        //   155: invokevirtual 122	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   158: putfield 125	com/allinone/free/activity/MyMainActivity:status	I
        //   161: aload_0
        //   162: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   165: aload 9
        //   167: ldc 127
        //   169: invokevirtual 122	org/json/JSONObject:getInt	(Ljava/lang/String;)I
        //   172: putfield 129	com/allinone/free/activity/MyMainActivity:in_control	I
        //   175: aload_0
        //   176: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   179: aload 9
        //   181: ldc 131
        //   183: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   186: invokestatic 139	com/allinone/free/activity/MyMainActivity:access$7	(Lcom/allinone/free/activity/MyMainActivity;Ljava/lang/String;)V
        //   189: aload_0
        //   190: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   193: invokestatic 143	com/allinone/free/activity/MyMainActivity:access$3	(Lcom/allinone/free/activity/MyMainActivity;)Ljava/lang/String;
        //   196: ldc 145
        //   198: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   201: ifeq +32 -> 233
        //   204: new 153	android/os/Message
        //   207: dup
        //   208: invokespecial 154	android/os/Message:<init>	()V
        //   211: astore 10
        //   213: aload 10
        //   215: bipush 10
        //   217: putfield 157	android/os/Message:what	I
        //   220: aload_0
        //   221: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   224: getfield 161	com/allinone/free/activity/MyMainActivity:handlertimer	Landroid/os/Handler;
        //   227: aload 10
        //   229: invokevirtual 167	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
        //   232: pop
        //   233: ldc 169
        //   235: new 44	java/lang/StringBuilder
        //   238: dup
        //   239: ldc 171
        //   241: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   244: aload_0
        //   245: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   248: invokestatic 143	com/allinone/free/activity/MyMainActivity:access$3	(Lcom/allinone/free/activity/MyMainActivity;)Ljava/lang/String;
        //   251: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   254: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   257: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   260: pop
        //   261: aload_0
        //   262: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   265: invokestatic 175	com/allinone/free/activity/MyMainActivity:access$8	(Lcom/allinone/free/activity/MyMainActivity;)Landroid/content/SharedPreferences;
        //   268: invokeinterface 181 1 0
        //   273: ldc 183
        //   275: aload_0
        //   276: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   279: invokestatic 143	com/allinone/free/activity/MyMainActivity:access$3	(Lcom/allinone/free/activity/MyMainActivity;)Ljava/lang/String;
        //   282: invokeinterface 189 3 0
        //   287: invokeinterface 193 1 0
        //   292: pop
        //   293: ldc 26
        //   295: new 44	java/lang/StringBuilder
        //   298: dup
        //   299: ldc 195
        //   301: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   304: aload_0
        //   305: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   308: getfield 125	com/allinone/free/activity/MyMainActivity:status	I
        //   311: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   314: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   317: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   320: pop
        //   321: ldc 26
        //   323: new 44	java/lang/StringBuilder
        //   326: dup
        //   327: ldc 200
        //   329: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   332: aload_0
        //   333: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   336: getfield 129	com/allinone/free/activity/MyMainActivity:in_control	I
        //   339: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   342: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   345: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   348: pop
        //   349: aload_0
        //   350: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   353: getfield 125	com/allinone/free/activity/MyMainActivity:status	I
        //   356: iconst_1
        //   357: if_icmpne +371 -> 728
        //   360: aload_0
        //   361: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   364: getfield 129	com/allinone/free/activity/MyMainActivity:in_control	I
        //   367: ifne +361 -> 728
        //   370: new 202	com/allinone/free/model/GameInfosVersionModel
        //   373: dup
        //   374: invokespecial 203	com/allinone/free/model/GameInfosVersionModel:<init>	()V
        //   377: astore 16
        //   379: aload 16
        //   381: aload 9
        //   383: ldc 205
        //   385: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   388: invokevirtual 208	com/allinone/free/model/GameInfosVersionModel:setUpdatePath	(Ljava/lang/String;)V
        //   391: sipush 1000
        //   394: aload 9
        //   396: ldc 210
        //   398: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   401: invokestatic 215	java/lang/Integer:parseInt	(Ljava/lang/String;)I
        //   404: imul
        //   405: putstatic 217	com/allinone/free/utils/Myutils:big_ad_interval	I
        //   408: ldc 219
        //   410: new 44	java/lang/StringBuilder
        //   413: dup
        //   414: ldc 221
        //   416: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   419: getstatic 217	com/allinone/free/utils/Myutils:big_ad_interval	I
        //   422: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
        //   425: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   428: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   431: pop
        //   432: aload 9
        //   434: ldc 210
        //   436: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   439: ldc 223
        //   441: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   444: ifne +38 -> 482
        //   447: new 225	java/util/Timer
        //   450: dup
        //   451: invokespecial 226	java/util/Timer:<init>	()V
        //   454: astore 18
        //   456: ldc 26
        //   458: ldc 228
        //   460: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   463: pop
        //   464: aload 18
        //   466: new 230	com/allinone/free/activity/MyMainActivity$5$1
        //   469: dup
        //   470: aload_0
        //   471: invokespecial 233	com/allinone/free/activity/MyMainActivity$5$1:<init>	(Lcom/allinone/free/activity/MyMainActivity$5;)V
        //   474: lconst_0
        //   475: getstatic 217	com/allinone/free/utils/Myutils:big_ad_interval	I
        //   478: i2l
        //   479: invokevirtual 237	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
        //   482: iconst_0
        //   483: invokestatic 243	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   486: astore 20
        //   488: iconst_0
        //   489: invokestatic 243	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   492: astore 21
        //   494: aload 21
        //   496: astore 22
        //   498: aload 9
        //   500: ldc 245
        //   502: invokevirtual 249	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
        //   505: astore 27
        //   507: aload 27
        //   509: invokevirtual 254	org/json/JSONArray:length	()I
        //   512: ifle +91 -> 603
        //   515: iconst_1
        //   516: invokestatic 243	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   519: astore 20
        //   521: aload 27
        //   523: iconst_0
        //   524: invokevirtual 258	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
        //   527: astore 28
        //   529: aload 16
        //   531: aload 28
        //   533: ldc_w 260
        //   536: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   539: invokevirtual 263	com/allinone/free/model/GameInfosVersionModel:setNtTitle	(Ljava/lang/String;)V
        //   542: aload 16
        //   544: aload 28
        //   546: ldc_w 265
        //   549: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   552: invokevirtual 268	com/allinone/free/model/GameInfosVersionModel:setNtMsg	(Ljava/lang/String;)V
        //   555: aload 16
        //   557: aload 28
        //   559: ldc_w 270
        //   562: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   565: invokevirtual 273	com/allinone/free/model/GameInfosVersionModel:setPicPath	(Ljava/lang/String;)V
        //   568: aload 16
        //   570: aload 28
        //   572: ldc_w 275
        //   575: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   578: invokevirtual 278	com/allinone/free/model/GameInfosVersionModel:setNtPath	(Ljava/lang/String;)V
        //   581: aload 16
        //   583: aload 28
        //   585: ldc_w 280
        //   588: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   591: invokevirtual 283	com/allinone/free/model/GameInfosVersionModel:setNtId	(Ljava/lang/String;)V
        //   594: ldc 26
        //   596: ldc_w 285
        //   599: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   602: pop
        //   603: aload 20
        //   605: invokevirtual 288	java/lang/Boolean:booleanValue	()Z
        //   608: ifne +46 -> 654
        //   611: aload 9
        //   613: ldc 205
        //   615: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   618: ldc_w 290
        //   621: invokevirtual 151	java/lang/String:equals	(Ljava/lang/Object;)Z
        //   624: ifne +30 -> 654
        //   627: iconst_1
        //   628: invokestatic 243	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   631: astore 22
        //   633: aload 16
        //   635: aload 9
        //   637: ldc 205
        //   639: invokevirtual 135	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
        //   642: invokevirtual 278	com/allinone/free/model/GameInfosVersionModel:setNtPath	(Ljava/lang/String;)V
        //   645: ldc 26
        //   647: ldc_w 292
        //   650: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   653: pop
        //   654: aload 20
        //   656: invokevirtual 288	java/lang/Boolean:booleanValue	()Z
        //   659: ifne +11 -> 670
        //   662: aload 22
        //   664: invokevirtual 288	java/lang/Boolean:booleanValue	()Z
        //   667: ifeq +61 -> 728
        //   670: aload_0
        //   671: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   674: getfield 295	com/allinone/free/activity/MyMainActivity:handlerversoin	Landroid/os/Handler;
        //   677: aload_0
        //   678: getfield 17	com/allinone/free/activity/MyMainActivity$5:this$0	Lcom/allinone/free/activity/MyMainActivity;
        //   681: getfield 295	com/allinone/free/activity/MyMainActivity:handlerversoin	Landroid/os/Handler;
        //   684: sipush 564
        //   687: aload 16
        //   689: invokevirtual 299	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
        //   692: invokevirtual 167	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
        //   695: pop
        //   696: ldc 26
        //   698: ldc_w 301
        //   701: invokestatic 34	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
        //   704: pop
        //   705: return
        //   706: aload 6
        //   708: aload 8
        //   710: invokevirtual 304	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
        //   713: pop
        //   714: goto -593 -> 121
        //   717: astore_2
        //   718: aload_2
        //   719: invokevirtual 307	java/lang/Exception:printStackTrace	()V
        //   722: return
        //   723: astore 23
        //   725: goto -122 -> 603
        //   728: return
        //
        // Exception table:
        //   from	to	target	type
        //   8	121	717	java/lang/Exception
        //   121	128	717	java/lang/Exception
        //   133	233	717	java/lang/Exception
        //   233	482	717	java/lang/Exception
        //   482	494	717	java/lang/Exception
        //   603	654	717	java/lang/Exception
        //   654	670	717	java/lang/Exception
        //   670	705	717	java/lang/Exception
        //   706	714	717	java/lang/Exception
        //   498	603	723	java/lang/Exception
      }
    }).start();
  }

  public void finish()
  {
    long l = System.currentTimeMillis();
    if (l - this.firstTime > 2000L)
    {
      Toast.makeText(this, getString(2131099724), 0).show();
      this.firstTime = l;
      return;
    }
    System.exit(0);
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 2131230801:
      this.tabhost.setCurrentTabByTag("tihome");
      this.banner.setVisibility(0);
      return;
    case 2131230802:
      this.tabhost.setCurrentTabByTag("tidownload");
      this.banner.setVisibility(0);
      return;
    case 2131230803:
      this.tabhost.setCurrentTabByTag("tifile");
      this.banner.setVisibility(8);
      return;
    case 2131230804:
    }
    this.tabhost.setCurrentTabByTag("tirecommend");
    this.banner.setVisibility(0);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903067);
    JPushInterface.init(this);
    this.mPushAgent = PushAgent.getInstance(this);
    this.mPushAgent.onAppStart();
    this.mPushAgent.enable();
    init();
    this.mainTab = ((RadioGroup)findViewById(2131230800));
    this.mainTab.setOnCheckedChangeListener(this);
    this.tabhost = getTabHost();
    this.tihome = new Intent(this, HomeActivity.class);
    this.tabhost.addTab(this.tabhost.newTabSpec("tihome").setIndicator(getResources().getString(2131099675)).setContent(this.tihome));
    this.tidownload = new Intent(this, DownlaodActivity.class);
    this.tabhost.addTab(this.tabhost.newTabSpec("tidownload").setIndicator(getResources().getString(2131099676)).setContent(this.tidownload));
    this.tifile = new Intent(this, FileActivity.class);
    this.tabhost.addTab(this.tabhost.newTabSpec("tifile").setIndicator(getResources().getString(2131099677)).setContent(this.tifile));
    this.tirecommend = new Intent(this, PopularActivity.class);
    this.tabhost.addTab(this.tabhost.newTabSpec("tirecommend").setIndicator(getResources().getString(2131099678)).setContent(this.tirecommend));
    try
    {
      if (Myutils.setting_json.getInt("run_times") == 1)
      {
        this.radio_button_recommend.setChecked(true);
        neiTui();
        if (!publicTools.isNetworkAvailable(this))
        {
          final NointentDialog localNointentDialog = new NointentDialog(this, 2131165279);
          localNointentDialog.setCanceledOnTouchOutside(false);
          localNointentDialog.show();
          Button localButton1 = (Button)localNointentDialog.findViewById(2131230944);
          Button localButton2 = (Button)localNointentDialog.findViewById(2131230945);
          localButton1.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              localNointentDialog.dismiss();
            }
          });
          localButton2.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              MyMainActivity.this.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
              localNointentDialog.dismiss();
            }
          });
        }
        return;
      }
      this.radio_button_home.setChecked(true);
    }
    catch (JSONException localJSONException)
    {
      try
      {
        while (true)
        {
          this.myid = getIntent().getStringExtra("myid");
          Log.v("ghgh", "+++++++" + this.myid);
          label448: if (this.myid != null)
          {
            this.tirecommend.putExtra("myid", this.myid);
            this.radio_button_recommend.setChecked(true);
          }
        }
        localJSONException = localJSONException;
        localJSONException.printStackTrace();
      }
      catch (Exception localException)
      {
        break label448;
      }
    }
  }

  public void onDismissScreen(Ad paramAd)
  {
  }

  public void onFailedToReceiveAd(Ad paramAd, AdRequest.ErrorCode paramErrorCode)
  {
  }

  public void onLeaveApplication(Ad paramAd)
  {
  }

  public void onPause()
  {
    super.onPause();
    this.windowFocus = false;
    JPushInterface.onPause(this);
  }

  public void onPresentScreen(Ad paramAd)
  {
  }

  public void onReceiveAd(Ad paramAd)
  {
    if (paramAd == this.interstitial)
      this.interstitial.show();
  }

  protected void onResume()
  {
    super.onResume();
    this.windowFocus = true;
    JPushInterface.onResume(this);
  }

  public void show_big_ad()
  {
    Log.v("cc", "ss111111111111");
    this.interstitial = new InterstitialAd(this, "ca-app-pub-1054623928013334/3671172209");
    AdRequest localAdRequest = new AdRequest();
    this.interstitial.loadAd(localAdRequest);
    this.interstitial.setAdListener(this);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.MyMainActivity
 * JD-Core Version:    0.6.2
 */