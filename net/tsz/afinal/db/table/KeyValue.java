package net.tsz.afinal.db.table;

import java.text.SimpleDateFormat;

public class KeyValue
{
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private String key;
  private Object value;

  public KeyValue()
  {
  }

  public KeyValue(String paramString, Object paramObject)
  {
    this.key = paramString;
    this.value = paramObject;
  }

  public String getKey()
  {
    return this.key;
  }

  public Object getValue()
  {
    if (((this.value instanceof java.util.Date)) || ((this.value instanceof java.sql.Date)))
      return sdf.format(this.value);
    return this.value;
  }

  public void setKey(String paramString)
  {
    this.key = paramString;
  }

  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.table.KeyValue
 * JD-Core Version:    0.6.2
 */