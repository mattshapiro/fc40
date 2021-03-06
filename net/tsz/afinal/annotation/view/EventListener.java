package net.tsz.afinal.annotation.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import java.lang.reflect.Method;
import net.tsz.afinal.exception.ViewException;

public class EventListener
  implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, AdapterView.OnItemLongClickListener
{
  private String clickMethod;
  private Object handler;
  private String itemClickMethod;
  private String itemLongClickMehtod;
  private String itemSelectMethod;
  private String longClickMethod;
  private String nothingSelectedMethod;

  public EventListener(Object paramObject)
  {
    this.handler = paramObject;
  }

  private static Object invokeClickMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (paramObject == null)
      return null;
    try
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { View.class });
      if (localMethod != null)
        return localMethod.invoke(paramObject, paramArrayOfObject);
      throw new ViewException("no such method:" + paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private static Object invokeItemClickMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (paramObject == null)
      return null;
    try
    {
      Class localClass = paramObject.getClass();
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = AdapterView.class;
      arrayOfClass[1] = View.class;
      arrayOfClass[2] = Integer.TYPE;
      arrayOfClass[3] = Long.TYPE;
      Method localMethod = localClass.getDeclaredMethod(paramString, arrayOfClass);
      if (localMethod != null)
        return localMethod.invoke(paramObject, paramArrayOfObject);
      throw new ViewException("no such method:" + paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private static boolean invokeItemLongClickMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (paramObject == null)
      throw new ViewException("invokeItemLongClickMethod: handler is null :");
    try
    {
      Class localClass = paramObject.getClass();
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = AdapterView.class;
      arrayOfClass[1] = View.class;
      arrayOfClass[2] = Integer.TYPE;
      arrayOfClass[3] = Long.TYPE;
      Method localMethod = localClass.getDeclaredMethod(paramString, arrayOfClass);
      if (localMethod != null)
      {
        Object localObject = localMethod.invoke(paramObject, paramArrayOfObject);
        if (localObject == null);
        for (boolean bool = false; ; bool = Boolean.valueOf(localObject.toString()).booleanValue())
          return Boolean.valueOf(bool).booleanValue();
      }
      throw new ViewException("no such method:" + paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }

  private static Object invokeItemSelectMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (paramObject == null)
      return null;
    try
    {
      Class localClass = paramObject.getClass();
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = AdapterView.class;
      arrayOfClass[1] = View.class;
      arrayOfClass[2] = Integer.TYPE;
      arrayOfClass[3] = Long.TYPE;
      Method localMethod = localClass.getDeclaredMethod(paramString, arrayOfClass);
      if (localMethod != null)
        return localMethod.invoke(paramObject, paramArrayOfObject);
      throw new ViewException("no such method:" + paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  private static boolean invokeLongClickMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (paramObject == null);
    while (true)
    {
      return false;
      try
      {
        Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { View.class });
        if (localMethod != null)
        {
          Object localObject = localMethod.invoke(paramObject, paramArrayOfObject);
          if (localObject != null)
            return Boolean.valueOf(localObject.toString()).booleanValue();
        }
        else
        {
          throw new ViewException("no such method:" + paramString);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return false;
  }

  private static Object invokeNoSelectMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    if (paramObject == null)
      return null;
    try
    {
      Method localMethod = paramObject.getClass().getDeclaredMethod(paramString, new Class[] { AdapterView.class });
      if (localMethod != null)
        return localMethod.invoke(paramObject, paramArrayOfObject);
      throw new ViewException("no such method:" + paramString);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public EventListener click(String paramString)
  {
    this.clickMethod = paramString;
    return this;
  }

  public EventListener itemClick(String paramString)
  {
    this.itemClickMethod = paramString;
    return this;
  }

  public EventListener itemLongClick(String paramString)
  {
    this.itemLongClickMehtod = paramString;
    return this;
  }

  public EventListener longClick(String paramString)
  {
    this.longClickMethod = paramString;
    return this;
  }

  public EventListener noSelect(String paramString)
  {
    this.nothingSelectedMethod = paramString;
    return this;
  }

  public void onClick(View paramView)
  {
    invokeClickMethod(this.handler, this.clickMethod, new Object[] { paramView });
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.handler;
    String str = this.itemClickMethod;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramAdapterView;
    arrayOfObject[1] = paramView;
    arrayOfObject[2] = Integer.valueOf(paramInt);
    arrayOfObject[3] = Long.valueOf(paramLong);
    invokeItemClickMethod(localObject, str, arrayOfObject);
  }

  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.handler;
    String str = this.itemLongClickMehtod;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramAdapterView;
    arrayOfObject[1] = paramView;
    arrayOfObject[2] = Integer.valueOf(paramInt);
    arrayOfObject[3] = Long.valueOf(paramLong);
    return invokeItemLongClickMethod(localObject, str, arrayOfObject);
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.handler;
    String str = this.itemSelectMethod;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramAdapterView;
    arrayOfObject[1] = paramView;
    arrayOfObject[2] = Integer.valueOf(paramInt);
    arrayOfObject[3] = Long.valueOf(paramLong);
    invokeItemSelectMethod(localObject, str, arrayOfObject);
  }

  public boolean onLongClick(View paramView)
  {
    return invokeLongClickMethod(this.handler, this.longClickMethod, new Object[] { paramView });
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    invokeNoSelectMethod(this.handler, this.nothingSelectedMethod, new Object[] { paramAdapterView });
  }

  public EventListener select(String paramString)
  {
    this.itemSelectMethod = paramString;
    return this;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.annotation.view.EventListener
 * JD-Core Version:    0.6.2
 */