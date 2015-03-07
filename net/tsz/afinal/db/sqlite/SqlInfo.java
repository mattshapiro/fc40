package net.tsz.afinal.db.sqlite;

import java.util.LinkedList;

public class SqlInfo
{
  private LinkedList<Object> bindArgs;
  private String sql;

  public void addValue(Object paramObject)
  {
    if (this.bindArgs == null)
      this.bindArgs = new LinkedList();
    this.bindArgs.add(paramObject);
  }

  public LinkedList<Object> getBindArgs()
  {
    return this.bindArgs;
  }

  public Object[] getBindArgsAsArray()
  {
    if (this.bindArgs != null)
      return this.bindArgs.toArray();
    return null;
  }

  public String[] getBindArgsAsStringArray()
  {
    if (this.bindArgs != null)
    {
      String[] arrayOfString = new String[this.bindArgs.size()];
      for (int i = 0; ; i++)
      {
        if (i >= this.bindArgs.size())
          return arrayOfString;
        arrayOfString[i] = this.bindArgs.get(i).toString();
      }
    }
    return null;
  }

  public String getSql()
  {
    return this.sql;
  }

  public void setBindArgs(LinkedList<Object> paramLinkedList)
  {
    this.bindArgs = paramLinkedList;
  }

  public void setSql(String paramString)
  {
    this.sql = paramString;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.sqlite.SqlInfo
 * JD-Core Version:    0.6.2
 */