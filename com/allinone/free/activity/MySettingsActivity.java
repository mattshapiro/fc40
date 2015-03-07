package com.allinone.free.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.allinone.free.dialog.AboutCustomDialog;
import com.allinone.free.dialog.DownloadpathCustomDialog;
import com.allinone.free.dialog.DownloadsettingDialog;
import com.allinone.free.dialog.HelpusShareDialog;
import com.allinone.free.dialog.NoupdareversionDialog;
import com.allinone.free.dialog.UpdateDialogVerison;
import com.allinone.free.model.GameInfosVersionModel;
import com.allinone.free.utils.Myutils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.example.CustomActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class MySettingsActivity extends Activity
  implements View.OnClickListener
{
  public static final int UPDATE_TAG = 564;
  private static Typeface typeFace = null;
  private RelativeLayout aboutus;
  private RelativeLayout checkforupdate;
  private RelativeLayout cleancache;
  private RelativeLayout contactus;
  private DownloadsettingDialog downloadingdialog;
  private RelativeLayout downloadpath;
  private RelativeLayout downloadsetting;
  private ImageView fan;
  Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 564)
      {
        GameInfosVersionModel localGameInfosVersionModel = (GameInfosVersionModel)paramAnonymousMessage.obj;
        MySettingsActivity.this.newVersionUrl = localGameInfosVersionModel.getUpdatePath();
        if (!MySettingsActivity.this.newVersionUrl.equals(""))
        {
          View.OnClickListener local1 = new View.OnClickListener()
          {
            public void onClick(View paramAnonymous2View)
            {
              MySettingsActivity.this.updateDialog.dismiss();
              switch (paramAnonymous2View.getId())
              {
              case 2131230879:
              case 2131230880:
              default:
                return;
              case 2131230881:
              }
              Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(MySettingsActivity.this.newVersionUrl));
              MySettingsActivity.this.startActivity(localIntent);
            }
          };
          MySettingsActivity.this.updateDialog = new UpdateDialogVerison(MySettingsActivity.this, 2131165281, local1);
          MySettingsActivity.this.updateDialog.show();
          MySettingsActivity.this.updateDialog.setTvTitle(MySettingsActivity.this.getString(2131099693));
          MySettingsActivity.this.updateDialog.setTvContent(MySettingsActivity.this.getString(2131099694));
        }
      }
      else
      {
        return;
      }
      final NoupdareversionDialog localNoupdareversionDialog = new NoupdareversionDialog(MySettingsActivity.this, 2131165279);
      localNoupdareversionDialog.setCanceledOnTouchOutside(false);
      localNoupdareversionDialog.show();
      ((TextView)localNoupdareversionDialog.findViewById(2131230943)).setText("Current version: 2.0.4 is the latest version.");
      ((Button)localNoupdareversionDialog.findViewById(2131230997)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymous2View)
        {
          localNoupdareversionDialog.dismiss();
        }
      });
    }
  };
  private RelativeLayout helpus;
  private ImageLoader imageLoader = ImageLoader.getInstance();
  private TextView mysettingtv;
  private String newVersionUrl = "";
  private SharedPreferences spnetwork;
  private UpdateDialogVerison updateDialog;
  private ToggleButton wifi_download;

  private void buildListerrn()
  {
    this.fan.setOnClickListener(this);
    this.downloadsetting.setOnClickListener(this);
    this.cleancache.setOnClickListener(this);
    this.checkforupdate.setOnClickListener(this);
    this.contactus.setOnClickListener(this);
    this.aboutus.setOnClickListener(this);
    this.downloadpath.setOnClickListener(this);
    this.helpus.setOnClickListener(this);
  }

  private void init()
  {
    this.spnetwork = getSharedPreferences("network", 0);
    this.fan = ((ImageView)findViewById(2131230808));
    this.mysettingtv = ((TextView)findViewById(2131230985));
    if (typeFace == null)
      typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.mysettingtv.setTypeface(typeFace);
    this.downloadsetting = ((RelativeLayout)findViewById(2131230986));
    this.cleancache = ((RelativeLayout)findViewById(2131230987));
    this.checkforupdate = ((RelativeLayout)findViewById(2131230988));
    this.contactus = ((RelativeLayout)findViewById(2131230989));
    this.aboutus = ((RelativeLayout)findViewById(2131230990));
    this.downloadpath = ((RelativeLayout)findViewById(2131230991));
    this.helpus = ((RelativeLayout)findViewById(2131230992));
  }

  public void delAllFile(String paramString)
  {
    File localFile1 = new File(paramString);
    if (!localFile1.exists());
    while (!localFile1.isDirectory())
      return;
    String[] arrayOfString = localFile1.list();
    int i = 0;
    label32: if (i < arrayOfString.length)
      if (!paramString.endsWith(File.separator))
        break label167;
    label167: for (File localFile2 = new File(paramString + arrayOfString[i]); ; localFile2 = new File(paramString + File.separator + arrayOfString[i]))
    {
      if (localFile2.isFile())
        localFile2.delete();
      if (localFile2.isDirectory())
      {
        delAllFile(paramString + "/" + arrayOfString[i]);
        delFolder(paramString + "/" + arrayOfString[i]);
      }
      i++;
      break label32;
      break;
    }
  }

  public void delFolder(String paramString)
  {
    try
    {
      delAllFile(paramString);
      new File(paramString.toString()).delete();
      getSharedPreferences("Data", 0).edit().clear();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131230808:
      finish();
      return;
    case 2131230986:
      this.downloadingdialog = new DownloadsettingDialog(this, 2131165279);
      this.downloadingdialog.setCanceledOnTouchOutside(false);
      this.downloadingdialog.show();
      this.wifi_download = ((ToggleButton)this.downloadingdialog.findViewById(2131230896));
      try
      {
        if (this.spnetwork.getBoolean("isopen", false))
          this.wifi_download.setChecked(true);
        while (true)
        {
          this.wifi_download.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
          {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
              if (paramAnonymousBoolean)
              {
                MySettingsActivity.this.spnetwork.edit().putBoolean("isopen", true).commit();
                return;
              }
              MySettingsActivity.this.spnetwork.edit().putBoolean("isopen", false).commit();
            }
          });
          Button localButton3 = (Button)this.downloadingdialog.findViewById(2131230898);
          Button localButton4 = (Button)this.downloadingdialog.findViewById(2131230897);
          localButton3.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              MySettingsActivity.this.downloadingdialog.dismiss();
            }
          });
          localButton4.setOnClickListener(new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              MySettingsActivity.this.downloadingdialog.dismiss();
            }
          });
          return;
          this.wifi_download.setChecked(false);
        }
      }
      catch (Exception localException)
      {
        break label154;
      }
    case 2131230987:
      new MyAsyncTask().execute(new Void[0]);
      this.imageLoader.clearDiscCache();
      return;
    case 2131230988:
      new MyAsyncTaskVersion().execute(new Void[0]);
      return;
    case 2131230989:
      startActivity(new Intent(this, CustomActivity.class));
      return;
    case 2131230990:
      final AboutCustomDialog localAboutCustomDialog = new AboutCustomDialog(this, 2131165279);
      localAboutCustomDialog.setCanceledOnTouchOutside(false);
      localAboutCustomDialog.show();
      ((Button)localAboutCustomDialog.findViewById(2131230753)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localAboutCustomDialog.dismiss();
        }
      });
      return;
    case 2131230991:
      label154: final DownloadpathCustomDialog localDownloadpathCustomDialog = new DownloadpathCustomDialog(this, 2131165279);
      localDownloadpathCustomDialog.setCanceledOnTouchOutside(false);
      localDownloadpathCustomDialog.show();
      ((Button)localDownloadpathCustomDialog.findViewById(2131230895)).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          localDownloadpathCustomDialog.dismiss();
        }
      });
      return;
    case 2131230992:
    }
    final HelpusShareDialog localHelpusShareDialog = new HelpusShareDialog(this, 2131165279);
    localHelpusShareDialog.setCanceledOnTouchOutside(false);
    localHelpusShareDialog.show();
    Button localButton1 = (Button)localHelpusShareDialog.findViewById(2131230909);
    Button localButton2 = (Button)localHelpusShareDialog.findViewById(2131230910);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        localHelpusShareDialog.dismiss();
      }
    });
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
        localIntent.setType("text/plain");
        localIntent.setFlags(268435456);
        MySettingsActivity.this.startActivity(Intent.createChooser(localIntent, "Share a free tool to download music & app..."));
        localHelpusShareDialog.dismiss();
      }
    });
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903111);
    init();
    buildListerrn();
  }

  protected void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(this);
  }

  class MyAsyncTask extends AsyncTask<Void, Void, Void>
  {
    private ProgressDialog mProgressDialog;

    MyAsyncTask()
    {
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      MySettingsActivity.this.delFolder(Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache");
      Log.v("hjhj", Environment.getExternalStorageDirectory() + "/" + Myutils.packagename + "/" + "webcache");
      return null;
    }

    protected void onPostExecute(Void paramVoid)
    {
      super.onPostExecute(paramVoid);
      if ((this.mProgressDialog != null) && (this.mProgressDialog.isShowing()))
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
      Toast.makeText(MySettingsActivity.this.getApplicationContext(), "done", 1).show();
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      this.mProgressDialog = ProgressDialog.show(MySettingsActivity.this, null, MySettingsActivity.this.getString(2131099725));
    }
  }

  class MyAsyncTaskVersion extends AsyncTask<Void, Void, Void>
  {
    private ProgressDialog mProgressDialog;

    MyAsyncTaskVersion()
    {
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      try
      {
        Thread.sleep(1000L);
        HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=" + Myutils.packagename2 + "&version=" + "2.0.4").openConnection();
        localHttpURLConnection.setConnectTimeout(5000);
        localHttpURLConnection.setRequestMethod("GET");
        Log.v("ggg", localHttpURLConnection.getResponseCode());
        if (localHttpURLConnection.getResponseCode() == 200)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localHttpURLConnection.getInputStream()));
          while (true)
          {
            String str = localBufferedReader.readLine();
            if (str == null)
            {
              JSONObject localJSONObject = new JSONObject(localStringBuffer.toString());
              if (localJSONObject.getInt("status") != 1)
                break;
              GameInfosVersionModel localGameInfosVersionModel = new GameInfosVersionModel();
              localGameInfosVersionModel.setUpdatePath(localJSONObject.getString("update_url"));
              MySettingsActivity.this.handler.sendMessage(MySettingsActivity.this.handler.obtainMessage(564, localGameInfosVersionModel));
              break;
            }
            localStringBuffer.append(str);
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }

    protected void onPostExecute(Void paramVoid)
    {
      super.onPostExecute(paramVoid);
      if ((this.mProgressDialog != null) && (this.mProgressDialog.isShowing()))
      {
        this.mProgressDialog.dismiss();
        this.mProgressDialog = null;
      }
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      this.mProgressDialog = ProgressDialog.show(MySettingsActivity.this, null, "Loading......");
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.activity.MySettingsActivity
 * JD-Core Version:    0.6.2
 */