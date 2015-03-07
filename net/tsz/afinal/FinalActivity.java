package net.tsz.afinal;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import java.lang.reflect.Field;
import net.tsz.afinal.annotation.view.EventListener;
import net.tsz.afinal.annotation.view.Select;
import net.tsz.afinal.annotation.view.ViewInject;

public class FinalActivity extends Activity
{
  private void initView()
  {
    Field[] arrayOfField = getClass().getDeclaredFields();
    int i;
    int j;
    if ((arrayOfField != null) && (arrayOfField.length > 0))
    {
      i = arrayOfField.length;
      j = 0;
    }
    while (true)
    {
      if (j >= i)
        return;
      Field localField = arrayOfField[j];
      ViewInject localViewInject = (ViewInject)localField.getAnnotation(ViewInject.class);
      int k;
      if (localViewInject != null)
        k = localViewInject.id();
      try
      {
        localField.setAccessible(true);
        localField.set(this, findViewById(k));
        String str1 = localViewInject.click();
        if (!TextUtils.isEmpty(str1))
          setViewClickListener(localField, str1);
        String str2 = localViewInject.longClick();
        if (!TextUtils.isEmpty(str2))
          setViewLongClickListener(localField, str2);
        String str3 = localViewInject.itemClick();
        if (!TextUtils.isEmpty(str3))
          setItemClickListener(localField, str3);
        String str4 = localViewInject.itemLongClick();
        if (!TextUtils.isEmpty(str4))
          setItemLongClickListener(localField, str4);
        Select localSelect = localViewInject.select();
        if (!TextUtils.isEmpty(localSelect.selected()))
          setViewSelectListener(localField, localSelect.selected(), localSelect.noSelected());
        j++;
      }
      catch (Exception localException)
      {
        while (true)
          localException.printStackTrace();
      }
    }
  }

  private void setItemClickListener(Field paramField, String paramString)
  {
    try
    {
      Object localObject = paramField.get(this);
      if ((localObject instanceof AbsListView))
        ((AbsListView)localObject).setOnItemClickListener(new EventListener(this).itemClick(paramString));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void setItemLongClickListener(Field paramField, String paramString)
  {
    try
    {
      Object localObject = paramField.get(this);
      if ((localObject instanceof AbsListView))
        ((AbsListView)localObject).setOnItemLongClickListener(new EventListener(this).itemLongClick(paramString));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void setViewClickListener(Field paramField, String paramString)
  {
    try
    {
      Object localObject = paramField.get(this);
      if ((localObject instanceof View))
        ((View)localObject).setOnClickListener(new EventListener(this).click(paramString));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void setViewLongClickListener(Field paramField, String paramString)
  {
    try
    {
      Object localObject = paramField.get(this);
      if ((localObject instanceof View))
        ((View)localObject).setOnLongClickListener(new EventListener(this).longClick(paramString));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  private void setViewSelectListener(Field paramField, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = paramField.get(this);
      if ((localObject instanceof View))
        ((AbsListView)localObject).setOnItemSelectedListener(new EventListener(this).select(paramString1).noSelect(paramString2));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    initView();
  }

  public void setContentView(View paramView)
  {
    super.setContentView(paramView);
    initView();
  }

  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setContentView(paramView, paramLayoutParams);
    initView();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.FinalActivity
 * JD-Core Version:    0.6.2
 */