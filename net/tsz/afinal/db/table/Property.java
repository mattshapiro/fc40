package net.tsz.afinal.db.table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Property
{
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private String column;
  private Class<?> dataType;
  private String defaultValue;
  private Field field;
  private String fieldName;
  private Method get;
  private Method set;

  private static java.util.Date stringToDateTime(String paramString)
  {
    if (paramString != null)
      try
      {
        java.util.Date localDate = sdf.parse(paramString);
        return localDate;
      }
      catch (ParseException localParseException)
      {
        localParseException.printStackTrace();
      }
    return null;
  }

  public String getColumn()
  {
    return this.column;
  }

  public Class<?> getDataType()
  {
    return this.dataType;
  }

  public String getDefaultValue()
  {
    return this.defaultValue;
  }

  public Field getField()
  {
    return this.field;
  }

  public String getFieldName()
  {
    return this.fieldName;
  }

  public Method getGet()
  {
    return this.get;
  }

  public Method getSet()
  {
    return this.set;
  }

  public <T> T getValue(Object paramObject)
  {
    if ((paramObject != null) && (this.get != null));
    try
    {
      Object localObject = this.get.invoke(paramObject, new Object[0]);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      while (true)
        localIllegalAccessException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      while (true)
        localInvocationTargetException.printStackTrace();
    }
  }

  public void setColumn(String paramString)
  {
    this.column = paramString;
  }

  public void setDataType(Class<?> paramClass)
  {
    this.dataType = paramClass;
  }

  public void setDefaultValue(String paramString)
  {
    this.defaultValue = paramString;
  }

  public void setField(Field paramField)
  {
    this.field = paramField;
  }

  public void setFieldName(String paramString)
  {
    this.fieldName = paramString;
  }

  public void setGet(Method paramMethod)
  {
    this.get = paramMethod;
  }

  public void setSet(Method paramMethod)
  {
    this.set = paramMethod;
  }

  public void setValue(Object paramObject1, Object paramObject2)
  {
    if ((this.set != null) && (paramObject2 != null))
    {
      while (true)
      {
        try
        {
          if (this.dataType == String.class)
          {
            Method localMethod7 = this.set;
            Object[] arrayOfObject7 = new Object[1];
            arrayOfObject7[0] = paramObject2.toString();
            localMethod7.invoke(paramObject1, arrayOfObject7);
            return;
          }
          if ((this.dataType != Integer.TYPE) && (this.dataType != Integer.class))
            break;
          Method localMethod1 = this.set;
          Object[] arrayOfObject1 = new Object[1];
          if (paramObject2 == null)
          {
            i = null.intValue();
            arrayOfObject1[0] = Integer.valueOf(i);
            localMethod1.invoke(paramObject1, arrayOfObject1);
            return;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return;
        }
        int i = Integer.parseInt(paramObject2.toString());
      }
      if ((this.dataType == Float.TYPE) || (this.dataType == Float.class))
      {
        Method localMethod2 = this.set;
        Object[] arrayOfObject2 = new Object[1];
        if (paramObject2 == null);
        for (float f = null.floatValue(); ; f = Float.parseFloat(paramObject2.toString()))
        {
          arrayOfObject2[0] = Float.valueOf(f);
          localMethod2.invoke(paramObject1, arrayOfObject2);
          return;
        }
      }
      if ((this.dataType == Double.TYPE) || (this.dataType == Double.class))
      {
        Method localMethod3 = this.set;
        Object[] arrayOfObject3 = new Object[1];
        if (paramObject2 == null);
        for (double d = null.doubleValue(); ; d = Double.parseDouble(paramObject2.toString()))
        {
          arrayOfObject3[0] = Double.valueOf(d);
          localMethod3.invoke(paramObject1, arrayOfObject3);
          return;
        }
      }
      if ((this.dataType == Long.TYPE) || (this.dataType == Long.class))
      {
        Method localMethod4 = this.set;
        Object[] arrayOfObject4 = new Object[1];
        if (paramObject2 == null);
        for (long l = null.longValue(); ; l = Long.parseLong(paramObject2.toString()))
        {
          arrayOfObject4[0] = Long.valueOf(l);
          localMethod4.invoke(paramObject1, arrayOfObject4);
          return;
        }
      }
      if ((this.dataType == java.util.Date.class) || (this.dataType == java.sql.Date.class))
      {
        Method localMethod5 = this.set;
        Object[] arrayOfObject5 = new Object[1];
        java.util.Date localDate = null;
        if (paramObject2 == null);
        while (true)
        {
          arrayOfObject5[0] = localDate;
          localMethod5.invoke(paramObject1, arrayOfObject5);
          return;
          localDate = stringToDateTime(paramObject2.toString());
        }
      }
      if ((this.dataType == Boolean.TYPE) || (this.dataType == Boolean.class))
      {
        Method localMethod6 = this.set;
        Object[] arrayOfObject6 = new Object[1];
        if (paramObject2 == null);
        for (boolean bool = null.booleanValue(); ; bool = "1".equals(paramObject2.toString()))
        {
          arrayOfObject6[0] = Boolean.valueOf(bool);
          localMethod6.invoke(paramObject1, arrayOfObject6);
          return;
        }
      }
      this.set.invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    try
    {
      this.field.setAccessible(true);
      this.field.set(paramObject1, paramObject2);
      return;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.db.table.Property
 * JD-Core Version:    0.6.2
 */