package net.tsz.afinal.db.table;

public class ManyToOne extends Property
{
  private Class<?> manyClass;

  public Class<?> getManyClass()
  {
    return this.manyClass;
  }

  public void setManyClass(Class<?> paramClass)
  {
    this.manyClass = paramClass;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.table.ManyToOne
 * JD-Core Version:    0.6.2
 */