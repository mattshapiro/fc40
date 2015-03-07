package com.umeng.fb.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class b
{
  private static b a;
  private static Context b;
  private final String c = "fb_push_switch";
  private final String d = "fb_welcome_info";
  private final String e = "fb_welcome_info_switch";
  private final String f = "fb_audio_switch";
  private final String g = "fb_push_switch_key";
  private final String h = "fb_welcome_info_key";
  private final String i = "fb_welcome_info_switch_key";
  private final String j = "fb_audio_switch_key";
  private SharedPreferences k;
  private SharedPreferences l;
  private SharedPreferences m;
  private SharedPreferences n;

  private b(Context paramContext)
  {
    b = paramContext;
    this.k = b.getSharedPreferences("fb_push_switch", 0);
    this.l = b.getSharedPreferences("fb_welcome_info", 0);
    this.m = b.getSharedPreferences("fb_welcome_info_switch", 0);
    this.n = b.getSharedPreferences("fb_audio_switch", 0);
  }

  public static b a(Context paramContext)
  {
    if (a == null)
      a = new b(paramContext);
    return a;
  }

  public void a(String paramString)
  {
    b(true);
    if (paramString != null)
      this.l.edit().putString("fb_welcome_info_key", paramString).apply();
  }

  public void a(boolean paramBoolean)
  {
    this.k.edit().putBoolean("fb_push_switch_key", paramBoolean).apply();
  }

  public boolean a()
  {
    return this.k.getBoolean("fb_push_switch_key", true);
  }

  public void b(boolean paramBoolean)
  {
    this.m.edit().putBoolean("fb_welcome_info_switch_key", paramBoolean).apply();
  }

  public boolean b()
  {
    return this.m.getBoolean("fb_welcome_info_switch_key", true);
  }

  public String c()
  {
    return this.l.getString("fb_welcome_info_key", null);
  }

  public void c(boolean paramBoolean)
  {
    this.n.edit().putBoolean("fb_audio_switch_key", paramBoolean).apply();
  }

  public boolean d()
  {
    return this.n.getBoolean("fb_audio_switch_key", true);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.common.b
 * JD-Core Version:    0.6.2
 */