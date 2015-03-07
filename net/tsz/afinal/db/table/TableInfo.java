package net.tsz.afinal.db.table;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.tsz.afinal.exception.DbException;
import net.tsz.afinal.reflect.ClassUtils;
import net.tsz.afinal.reflect.FieldUtils;

public class TableInfo
{
  private static final HashMap<String, TableInfo> tableInfoMap = new HashMap();
  private boolean checkDatabese;
  private String className;
  private Id id;
  public final HashMap<String, ManyToOne> manyToOneMap = new HashMap();
  public final HashMap<String, OneToMany> oneToManyMap = new HashMap();
  public final HashMap<String, Property> propertyMap = new HashMap();
  private String tableName;

  public static TableInfo get(Class<?> paramClass)
  {
    if (paramClass == null)
      throw new DbException("table info get error,because the clazz is null");
    TableInfo localTableInfo = (TableInfo)tableInfoMap.get(paramClass.getName());
    Iterator localIterator3;
    Iterator localIterator2;
    label170: Iterator localIterator1;
    if (localTableInfo == null)
    {
      localTableInfo = new TableInfo();
      localTableInfo.setTableName(ClassUtils.getTableName(paramClass));
      localTableInfo.setClassName(paramClass.getName());
      Field localField = ClassUtils.getPrimaryKeyField(paramClass);
      if (localField == null)
        break label255;
      Id localId = new Id();
      localId.setColumn(FieldUtils.getColumnByField(localField));
      localId.setFieldName(localField.getName());
      localId.setSet(FieldUtils.getFieldSetMethod(paramClass, localField));
      localId.setGet(FieldUtils.getFieldGetMethod(paramClass, localField));
      localId.setDataType(localField.getType());
      localTableInfo.setId(localId);
      List localList1 = ClassUtils.getPropertyList(paramClass);
      if (localList1 != null)
      {
        localIterator3 = localList1.iterator();
        if (localIterator3.hasNext())
          break label284;
      }
      List localList2 = ClassUtils.getManyToOneList(paramClass);
      if (localList2 != null)
      {
        localIterator2 = localList2.iterator();
        if (localIterator2.hasNext())
          break label319;
      }
      List localList3 = ClassUtils.getOneToManyList(paramClass);
      if (localList3 != null)
        localIterator1 = localList3.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        tableInfoMap.put(paramClass.getName(), localTableInfo);
        if (localTableInfo != null)
          break label389;
        throw new DbException("the class[" + paramClass + "]'s table is null");
        label255: throw new DbException("the class[" + paramClass + "]'s idField is null , \n you can define _id,id property or use annotation @id to solution this exception");
        label284: Property localProperty = (Property)localIterator3.next();
        if (localProperty == null)
          break;
        localTableInfo.propertyMap.put(localProperty.getColumn(), localProperty);
        break;
        label319: ManyToOne localManyToOne = (ManyToOne)localIterator2.next();
        if (localManyToOne == null)
          break label170;
        localTableInfo.manyToOneMap.put(localManyToOne.getColumn(), localManyToOne);
        break label170;
      }
      OneToMany localOneToMany = (OneToMany)localIterator1.next();
      if (localOneToMany != null)
        localTableInfo.oneToManyMap.put(localOneToMany.getColumn(), localOneToMany);
    }
    label389: return localTableInfo;
  }

  public static TableInfo get(String paramString)
  {
    try
    {
      TableInfo localTableInfo = get(Class.forName(paramString));
      return localTableInfo;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    return null;
  }

  public String getClassName()
  {
    return this.className;
  }

  public Id getId()
  {
    return this.id;
  }

  public String getTableName()
  {
    return this.tableName;
  }

  public boolean isCheckDatabese()
  {
    return this.checkDatabese;
  }

  public void setCheckDatabese(boolean paramBoolean)
  {
    this.checkDatabese = paramBoolean;
  }

  public void setClassName(String paramString)
  {
    this.className = paramString;
  }

  public void setId(Id paramId)
  {
    this.id = paramId;
  }

  public void setTableName(String paramString)
  {
    this.tableName = paramString;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.table.TableInfo
 * JD-Core Version:    0.6.2
 */