package net.tsz.afinal.db.table;

public class OneToMany extends Property
{
  private Class<?> oneClass;

  public Class<?> getOneClass()
  {
    return this.oneClass;
  }

  public void setOneClass(Class<?> paramClass)
  {
    this.oneClass = paramClass;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.table.OneToMany
 * JD-Core Version:    0.6.2
 */