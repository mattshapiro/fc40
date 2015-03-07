package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.Serializable;
import u.aly.s;
import u.aly.u;

public class b
{
  public String a;
  public String b;
  private Context c;
  private final String d = "um_g_cache";
  private final String e = "single_level";
  private final String f = "stat_player_level";
  private final String g = "stat_game_level";
  private a h = null;

  public b(Context paramContext)
  {
    this.c = paramContext;
  }

  public a a(String paramString)
  {
    this.h = new a(paramString);
    this.h.a();
    return this.h;
  }

  public void a()
  {
    if (this.h != null)
    {
      this.h.b();
      SharedPreferences.Editor localEditor = this.c.getSharedPreferences("um_g_cache", 0).edit();
      localEditor.putString("single_level", s.a(this.h));
      localEditor.putString("stat_player_level", this.b);
      localEditor.putString("stat_game_level", this.a);
      localEditor.commit();
    }
  }

  public a b(String paramString)
  {
    if (this.h != null)
    {
      this.h.d();
      if (this.h.a(paramString))
      {
        a locala = this.h;
        this.h = null;
        return locala;
      }
    }
    return null;
  }

  public void b()
  {
    SharedPreferences localSharedPreferences = u.a(this.c, "um_g_cache");
    String str = localSharedPreferences.getString("single_level", null);
    if (str != null)
    {
      this.h = ((a)s.a(str));
      if (this.h != null)
        this.h.c();
    }
    if (this.b == null)
      this.b = localSharedPreferences.getString("stat_player_level", null);
    if (this.a == null)
      this.a = localSharedPreferences.getString("stat_game_level", null);
  }

  static class a
    implements Serializable
  {
    private static final long a = 20140327L;
    private String b;
    private long c;
    private long d;

    public a(String paramString)
    {
      this.b = paramString;
    }

    public void a()
    {
      this.d = System.currentTimeMillis();
    }

    public boolean a(String paramString)
    {
      return this.b.equals(paramString);
    }

    public void b()
    {
      this.c += System.currentTimeMillis() - this.d;
      this.d = 0L;
    }

    public void c()
    {
      a();
    }

    public void d()
    {
      b();
    }

    public long e()
    {
      return this.c;
    }

    public String f()
    {
      return this.b;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.game.b
 * JD-Core Version:    0.6.2
 */