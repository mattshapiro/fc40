package net.tsz.afinal.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;
import net.tsz.afinal.db.table.ManyToOne;
import net.tsz.afinal.db.table.OneToMany;
import net.tsz.afinal.db.table.Property;
import net.tsz.afinal.exception.DbException;

public class ClassUtils
{
  public static List<ManyToOne> getManyToOneList(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    do
      try
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        i = arrayOfField.length;
        j = 0;
        continue;
        Field localField = arrayOfField[j];
        if ((!FieldUtils.isTransient(localField)) && (FieldUtils.isManyToOne(localField)))
        {
          ManyToOne localManyToOne = new ManyToOne();
          localManyToOne.setManyClass(localField.getType());
          localManyToOne.setColumn(FieldUtils.getColumnByField(localField));
          localManyToOne.setFieldName(localField.getName());
          localManyToOne.setDataType(localField.getType());
          localManyToOne.setSet(FieldUtils.getFieldSetMethod(paramClass, localField));
          localManyToOne.setGet(FieldUtils.getFieldGetMethod(paramClass, localField));
          localArrayList.add(localManyToOne);
        }
        j++;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.getMessage(), localException);
      }
    while (j < i);
    return localArrayList;
  }

  public static List<OneToMany> getOneToManyList(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      int i;
      int j;
      try
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        i = arrayOfField.length;
        j = 0;
        break label208;
        Field localField = arrayOfField[j];
        if ((!FieldUtils.isTransient(localField)) && (FieldUtils.isOneToMany(localField)))
        {
          OneToMany localOneToMany = new OneToMany();
          localOneToMany.setColumn(FieldUtils.getColumnByField(localField));
          localOneToMany.setFieldName(localField.getName());
          if ((localField.getGenericType() instanceof ParameterizedType))
          {
            Class localClass = (Class)((ParameterizedType)localField.getGenericType()).getActualTypeArguments()[0];
            if (localClass != null)
              localOneToMany.setOneClass(localClass);
            localOneToMany.setDataType(localField.getClass());
            localOneToMany.setSet(FieldUtils.getFieldSetMethod(paramClass, localField));
            localOneToMany.setGet(FieldUtils.getFieldGetMethod(paramClass, localField));
            localArrayList.add(localOneToMany);
          }
          else
          {
            throw new DbException("getOneToManyList Exception:" + localField.getName() + "'s type is null");
          }
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.getMessage(), localException);
      }
      label208: 
      while (j >= i)
      {
        return localArrayList;
        j++;
      }
    }
  }

  public static String getPrimaryKeyColumn(Class<?> paramClass)
  {
    int i = 0;
    Field[] arrayOfField = paramClass.getDeclaredFields();
    if (arrayOfField != null)
    {
      Id localId = null;
      int j = arrayOfField.length;
      String str;
      for (int k = 0; ; k++)
      {
        Object localObject = null;
        if (k >= j);
        while (true)
        {
          if (localId == null)
            break label102;
          str = localId.column();
          if ((str == null) || (str.trim().length() == 0))
            str = localObject.getName();
          return str;
          Field localField = arrayOfField[k];
          localId = (Id)localField.getAnnotation(Id.class);
          if (localId == null)
            break;
          localObject = localField;
        }
      }
      label102: int m = arrayOfField.length;
      int n = 0;
      label109: int i1;
      if (n >= m)
        i1 = arrayOfField.length;
      while (true)
      {
        str = null;
        if (i >= i1)
          break;
        if ("id".equals(arrayOfField[i].getName()))
        {
          return "id";
          if ("_id".equals(arrayOfField[n].getName()))
            return "_id";
          n++;
          break label109;
        }
        i++;
      }
    }
    throw new RuntimeException("this model[" + paramClass + "] has no field");
  }

  public static Field getPrimaryKeyField(Class<?> paramClass)
  {
    int i = 0;
    Field[] arrayOfField = paramClass.getDeclaredFields();
    if (arrayOfField != null)
    {
      int j = arrayOfField.length;
      int k = 0;
      Object localObject = null;
      label26: int i1;
      label38: label45: int m;
      if (k >= j)
      {
        if (localObject == null)
        {
          int n = arrayOfField.length;
          i1 = 0;
          if (i1 < n)
            break label92;
        }
        if (localObject == null)
          m = arrayOfField.length;
      }
      while (true)
      {
        if (i >= m)
        {
          return localObject;
          Field localField1 = arrayOfField[k];
          if (localField1.getAnnotation(Id.class) != null)
          {
            localObject = localField1;
            break label26;
          }
          k++;
          break;
          label92: Field localField3 = arrayOfField[i1];
          if ("_id".equals(localField3.getName()))
          {
            localObject = localField3;
            break label45;
          }
          i1++;
          break label38;
        }
        Field localField2 = arrayOfField[i];
        if ("id".equals(localField2.getName()))
          return localField2;
        i++;
      }
    }
    throw new RuntimeException("this model[" + paramClass + "] has no field");
  }

  public static String getPrimaryKeyFieldName(Class<?> paramClass)
  {
    Field localField = getPrimaryKeyField(paramClass);
    if (localField == null)
      return null;
    return localField.getName();
  }

  public static Object getPrimaryKeyValue(Object paramObject)
  {
    return FieldUtils.getFieldValue(paramObject, getPrimaryKeyField(paramObject.getClass()));
  }

  public static List<Property> getPropertyList(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      int i;
      int j;
      try
      {
        Field[] arrayOfField = paramClass.getDeclaredFields();
        String str = getPrimaryKeyFieldName(paramClass);
        i = arrayOfField.length;
        j = 0;
        break label171;
        Field localField = arrayOfField[j];
        if ((!FieldUtils.isTransient(localField)) && (FieldUtils.isBaseDateType(localField)) && (!localField.getName().equals(str)))
        {
          Property localProperty = new Property();
          localProperty.setColumn(FieldUtils.getColumnByField(localField));
          localProperty.setFieldName(localField.getName());
          localProperty.setDataType(localField.getType());
          localProperty.setDefaultValue(FieldUtils.getPropertyDefaultValue(localField));
          localProperty.setSet(FieldUtils.getFieldSetMethod(paramClass, localField));
          localProperty.setGet(FieldUtils.getFieldGetMethod(paramClass, localField));
          localProperty.setField(localField);
          localArrayList.add(localProperty);
        }
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException.getMessage(), localException);
      }
      label171: 
      while (j >= i)
      {
        return localArrayList;
        j++;
      }
    }
  }

  public static String getTableName(Class<?> paramClass)
  {
    Table localTable = (Table)paramClass.getAnnotation(Table.class);
    if ((localTable == null) || (localTable.name().trim().length() == 0))
      return paramClass.getName().replace('.', '_');
    return localTable.name();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.reflect.ClassUtils
 * JD-Core Version:    0.6.2
 */