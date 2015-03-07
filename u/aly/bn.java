package u.aly;

import org.json.JSONObject;

public class bn extends bq
{
  public a a;

  public bn(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (("ok".equalsIgnoreCase(paramJSONObject.optString("status"))) || ("ok".equalsIgnoreCase(paramJSONObject.optString("success"))))
    {
      this.a = a.a;
      return;
    }
    this.a = a.b;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.bn
 * JD-Core Version:    0.6.2
 */