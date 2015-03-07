package net.tsz.afinal.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.ManyToOne;
import net.tsz.afinal.annotation.sqlite.OneToMany;
import net.tsz.afinal.annotation.sqlite.Property;
import net.tsz.afinal.annotation.sqlite.Transient;

public class FieldUtils
{
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  public static Method getBooleanFieldGetMethod(Class<?> paramClass, String paramString)
  {
    String str = "is" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
    if (isISStart(paramString))
      str = paramString;
    try
    {
      Method localMethod = paramClass.getDeclaredMethod(str, new Class[0]);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    return null;
  }

  public static Method getBooleanFieldSetMethod(Class<?> paramClass, Field paramField)
  {
    String str1 = paramField.getName();
    String str2 = "set" + str1.substring(0, 1).toUpperCase() + str1.substring(1);
    if (isISStart(paramField.getName()))
      str2 = "set" + str1.substring(2, 3).toUpperCase() + str1.substring(3);
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = paramField.getType();
      Method localMethod = paramClass.getDeclaredMethod(str2, arrayOfClass);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    return null;
  }

  public static String getColumnByField(Field paramField)
  {
    Property localProperty = (Property)paramField.getAnnotation(Property.class);
    if ((localProperty != null) && (localProperty.column().trim().length() != 0))
      return localProperty.column();
    ManyToOne localManyToOne = (ManyToOne)paramField.getAnnotation(ManyToOne.class);
    if ((localManyToOne != null) && (localManyToOne.column().trim().length() != 0))
      return localManyToOne.column();
    OneToMany localOneToMany = (OneToMany)paramField.getAnnotation(OneToMany.class);
    if ((localOneToMany != null) && (localOneToMany.manyColumn() != null) && (localOneToMany.manyColumn().trim().length() != 0))
      return localOneToMany.manyColumn();
    Id localId = (Id)paramField.getAnnotation(Id.class);
    if ((localId != null) && (localId.column().trim().length() != 0))
      return localId.column();
    return paramField.getName();
  }

  public static Field getFieldByColumnName(Class<?> paramClass, String paramString)
  {
    Object localObject = null;
    Field[] arrayOfField;
    int j;
    if (paramString != null)
    {
      arrayOfField = paramClass.getDeclaredFields();
      localObject = null;
      if (arrayOfField != null)
      {
        int i = arrayOfField.length;
        localObject = null;
        if (i > 0)
        {
          boolean bool = paramString.equals(ClassUtils.getPrimaryKeyColumn(paramClass));
          localObject = null;
          if (bool)
            localObject = ClassUtils.getPrimaryKeyField(paramClass);
          if (localObject == null)
            j = arrayOfField.length;
        }
      }
    }
    for (int k = 0; ; k++)
    {
      if (k >= j);
      while (true)
      {
        if (localObject == null)
          localObject = getFieldByName(paramClass, paramString);
        return localObject;
        Field localField = arrayOfField[k];
        Property localProperty = (Property)localField.getAnnotation(Property.class);
        if ((localProperty != null) && (paramString.equals(localProperty.column())))
        {
          localObject = localField;
        }
        else
        {
          ManyToOne localManyToOne = (ManyToOne)localField.getAnnotation(ManyToOne.class);
          if ((localManyToOne == null) || (localManyToOne.column().trim().length() == 0))
            break;
          localObject = localField;
        }
      }
    }
  }

  public static Field getFieldByName(Class<?> paramClass, String paramString)
  {
    Object localObject = null;
    if (paramString != null);
    try
    {
      Field localField = paramClass.getDeclaredField(paramString);
      localObject = localField;
      return localObject;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
    }
    return null;
  }

  public static Method getFieldGetMethod(Class<?> paramClass, String paramString)
  {
    String str = "get" + paramString.substring(0, 1).toUpperCase() + paramString.substring(1);
    try
    {
      Method localMethod = paramClass.getDeclaredMethod(str, new Class[0]);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    return null;
  }

  public static Method getFieldGetMethod(Class<?> paramClass, Field paramField)
  {
    String str = paramField.getName();
    Class localClass1 = paramField.getType();
    Class localClass2 = Boolean.TYPE;
    Method localMethod = null;
    if (localClass1 == localClass2)
      localMethod = getBooleanFieldGetMethod(paramClass, str);
    if (localMethod == null)
      localMethod = getFieldGetMethod(paramClass, str);
    return localMethod;
  }

  public static Method getFieldSetMethod(Class<?> paramClass, String paramString)
  {
    try
    {
      Method localMethod = getFieldSetMethod(paramClass, paramClass.getDeclaredField(paramString));
      return localMethod;
    }
    catch (SecurityException localSecurityException)
    {
      localSecurityException.printStackTrace();
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      while (true)
        localNoSuchFieldException.printStackTrace();
    }
  }

  public static Method getFieldSetMethod(Class<?> paramClass, Field paramField)
  {
    String str1 = paramField.getName();
    String str2 = "set" + str1.substring(0, 1).toUpperCase() + str1.substring(1);
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = paramField.getType();
      Method localMethod = paramClass.getDeclaredMethod(str2, arrayOfClass);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      if (paramField.getType() == Boolean.TYPE)
        return getBooleanFieldSetMethod(paramClass, paramField);
    }
    return null;
  }

  public static Object getFieldValue(Object paramObject, String paramString)
  {
    return invoke(paramObject, getFieldGetMethod(paramObject.getClass(), paramString));
  }

  public static Object getFieldValue(Object paramObject, Field paramField)
  {
    return invoke(paramObject, getFieldGetMethod(paramObject.getClass(), paramField));
  }

  public static String getPropertyDefaultValue(Field paramField)
  {
    Property localProperty = (Property)paramField.getAnnotation(Property.class);
    if ((localProperty != null) && (localProperty.defaultValue().trim().length() != 0))
      return localProperty.defaultValue();
    return null;
  }

  private static Object invoke(Object paramObject, Method paramMethod)
  {
    if ((paramObject == null) || (paramMethod == null))
      return null;
    try
    {
      Object localObject = paramMethod.invoke(paramObject, new Object[0]);
      return localObject;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return null;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
    return null;
  }

  public static boolean isBaseDateType(Field paramField)
  {
    Class localClass = paramField.getType();
    return (localClass.equals(String.class)) || (localClass.equals(Integer.class)) || (localClass.equals(Byte.class)) || (localClass.equals(Long.class)) || (localClass.equals(Double.class)) || (localClass.equals(Float.class)) || (localClass.equals(Character.class)) || (localClass.equals(Short.class)) || (localClass.equals(Boolean.class)) || (localClass.equals(java.util.Date.class)) || (localClass.equals(java.util.Date.class)) || (localClass.equals(java.sql.Date.class)) || (localClass.isPrimitive());
  }

  private static boolean isISStart(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0));
    while ((!paramString.startsWith("is")) || (Character.isLowerCase(paramString.charAt(2))))
      return false;
    return true;
  }

  public static boolean isManyToOne(Field paramField)
  {
    return paramField.getAnnotation(ManyToOne.class) != null;
  }

  public static boolean isManyToOneOrOneToMany(Field paramField)
  {
    return (isManyToOne(paramField)) || (isOneToMany(paramField));
  }

  public static boolean isOneToMany(Field paramField)
  {
    return paramField.getAnnotation(OneToMany.class) != null;
  }

  public static boolean isTransient(Field paramField)
  {
    return paramField.getAnnotation(Transient.class) != null;
  }

  public static void setFieldValue(Object paramObject1, Field paramField, Object paramObject2)
  {
    Method localMethod;
    Class localClass;
    while (true)
    {
      try
      {
        localMethod = getFieldSetMethod(paramObject1.getClass(), paramField);
        if (localMethod == null)
          return;
        localMethod.setAccessible(true);
        localClass = paramField.getType();
        if (localClass == String.class)
        {
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = paramObject2.toString();
          localMethod.invoke(paramObject1, arrayOfObject1);
          return;
        }
        if ((localClass != Integer.TYPE) && (localClass != Integer.class))
          break;
        Object[] arrayOfObject5 = new Object[1];
        if (paramObject2 == null)
        {
          i = null.intValue();
          arrayOfObject5[0] = Integer.valueOf(i);
          localMethod.invoke(paramObject1, arrayOfObject5);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      int i = Integer.parseInt(paramObject2.toString());
    }
    if ((localClass == Float.TYPE) || (localClass == Float.class))
    {
      Object[] arrayOfObject4 = new Object[1];
      if (paramObject2 == null);
      for (float f = null.floatValue(); ; f = Float.parseFloat(paramObject2.toString()))
      {
        arrayOfObject4[0] = Float.valueOf(f);
        localMethod.invoke(paramObject1, arrayOfObject4);
        return;
      }
    }
    if ((localClass == Long.TYPE) || (localClass == Long.class))
    {
      Object[] arrayOfObject3 = new Object[1];
      if (paramObject2 == null);
      for (long l = null.longValue(); ; l = Long.parseLong(paramObject2.toString()))
      {
        arrayOfObject3[0] = Long.valueOf(l);
        localMethod.invoke(paramObject1, arrayOfObject3);
        return;
      }
    }
    if (localClass == java.util.Date.class)
    {
      Object[] arrayOfObject2 = new Object[1];
      java.util.Date localDate = null;
      if (paramObject2 == null);
      while (true)
      {
        arrayOfObject2[0] = localDate;
        localMethod.invoke(paramObject1, arrayOfObject2);
        return;
        localDate = stringToDateTime(paramObject2.toString());
      }
    }
    localMethod.invoke(paramObject1, new Object[] { paramObject2 });
  }

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
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.reflect.FieldUtils
 * JD-Core Version:    0.6.2
 */