package u.upd;

import org.json.JSONObject;

public abstract class h
{
  protected static String a = "POST";
  protected static String b = "GET";
  protected String c;

  public h(String paramString)
  {
    this.c = paramString;
  }

  public abstract JSONObject a();

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public abstract String b();

  protected String c()
  {
    return a;
  }

  public String d()
  {
    return this.c;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.upd.h
 * JD-Core Version:    0.6.2
 */