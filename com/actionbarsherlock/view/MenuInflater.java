package com.actionbarsherlock.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.View;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.internal.view.menu.MenuItemImpl;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MenuInflater
{
  private static final Class<?>[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
  private static final Class<?>[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE = { Context.class };
  private static final String LOG_TAG = "MenuInflater";
  private static final int NO_ID = 0;
  private static final String XML_GROUP = "group";
  private static final String XML_ITEM = "item";
  private static final String XML_MENU = "menu";
  private final Object[] mActionProviderConstructorArguments;
  private final Object[] mActionViewConstructorArguments;
  private Context mContext;
  private Object mRealOwner;

  public MenuInflater(Context paramContext)
  {
    this.mContext = paramContext;
    this.mRealOwner = paramContext;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }

  public MenuInflater(Context paramContext, Object paramObject)
  {
    this.mContext = paramContext;
    this.mRealOwner = paramObject;
    this.mActionViewConstructorArguments = new Object[] { paramContext };
    this.mActionProviderConstructorArguments = this.mActionViewConstructorArguments;
  }

  private void parseMenu(XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Menu paramMenu)
    throws XmlPullParserException, IOException
  {
    MenuState localMenuState = new MenuState(paramMenu);
    int i = paramXmlPullParser.getEventType();
    int j = 0;
    Object localObject = null;
    String str3;
    if (i == 2)
    {
      str3 = paramXmlPullParser.getName();
      if (str3.equals("menu"))
        i = paramXmlPullParser.next();
    }
    int k;
    while (true)
    {
      k = 0;
      if (k == 0)
        break label108;
      return;
      throw new RuntimeException("Expecting menu, got " + str3);
      i = paramXmlPullParser.next();
      if (i != 1)
        break;
    }
    switch (i)
    {
    default:
    case 2:
    case 3:
      while (true)
      {
        label108: i = paramXmlPullParser.next();
        break;
        if (j == 0)
        {
          String str2 = paramXmlPullParser.getName();
          if (str2.equals("group"))
          {
            localMenuState.readGroup(paramAttributeSet);
          }
          else if (str2.equals("item"))
          {
            localMenuState.readItem(paramAttributeSet);
          }
          else if (str2.equals("menu"))
          {
            parseMenu(paramXmlPullParser, paramAttributeSet, localMenuState.addSubMenuItem());
          }
          else
          {
            j = 1;
            localObject = str2;
            continue;
            String str1 = paramXmlPullParser.getName();
            if ((j != 0) && (str1.equals(localObject)))
            {
              j = 0;
              localObject = null;
            }
            else if (str1.equals("group"))
            {
              localMenuState.resetGroup();
            }
            else if (str1.equals("item"))
            {
              if (!localMenuState.hasAddedItem())
                if ((localMenuState.itemActionProvider != null) && (localMenuState.itemActionProvider.hasSubMenu()))
                  localMenuState.addSubMenuItem();
                else
                  localMenuState.addItem();
            }
            else if (str1.equals("menu"))
            {
              k = 1;
            }
          }
        }
      }
    case 1:
    }
    throw new RuntimeException("Unexpected end of document");
  }

  // ERROR //
  public void inflate(int paramInt, Menu paramMenu)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 47	com/actionbarsherlock/view/MenuInflater:mContext	Landroid/content/Context;
    //   6: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: iload_1
    //   10: invokevirtual 156	android/content/res/Resources:getLayout	(I)Landroid/content/res/XmlResourceParser;
    //   13: astore_3
    //   14: aload_0
    //   15: aload_3
    //   16: aload_3
    //   17: invokestatic 162	android/util/Xml:asAttributeSet	(Lorg/xmlpull/v1/XmlPullParser;)Landroid/util/AttributeSet;
    //   20: aload_2
    //   21: invokespecial 124	com/actionbarsherlock/view/MenuInflater:parseMenu	(Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Lcom/actionbarsherlock/view/Menu;)V
    //   24: aload_3
    //   25: ifnull +9 -> 34
    //   28: aload_3
    //   29: invokeinterface 167 1 0
    //   34: return
    //   35: astore 6
    //   37: new 169	android/view/InflateException
    //   40: dup
    //   41: ldc 171
    //   43: aload 6
    //   45: invokespecial 174	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: athrow
    //   49: astore 5
    //   51: aload_3
    //   52: ifnull +9 -> 61
    //   55: aload_3
    //   56: invokeinterface 167 1 0
    //   61: aload 5
    //   63: athrow
    //   64: astore 4
    //   66: new 169	android/view/InflateException
    //   69: dup
    //   70: ldc 171
    //   72: aload 4
    //   74: invokespecial 174	android/view/InflateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	24	35	org/xmlpull/v1/XmlPullParserException
    //   2	24	49	finally
    //   37	49	49	finally
    //   66	78	49	finally
    //   2	24	64	java/io/IOException
  }

  private static class InflatedOnMenuItemClickListener
    implements MenuItem.OnMenuItemClickListener
  {
    private static final Class<?>[] PARAM_TYPES = { MenuItem.class };
    private Method mMethod;
    private Object mRealOwner;

    public InflatedOnMenuItemClickListener(Object paramObject, String paramString)
    {
      this.mRealOwner = paramObject;
      Class localClass = paramObject.getClass();
      try
      {
        this.mMethod = localClass.getMethod(paramString, PARAM_TYPES);
        return;
      }
      catch (Exception localException)
      {
        InflateException localInflateException = new InflateException("Couldn't resolve menu item onClick handler " + paramString + " in class " + localClass.getName());
        localInflateException.initCause(localException);
        throw localInflateException;
      }
    }

    public boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      try
      {
        if (this.mMethod.getReturnType() == Boolean.TYPE)
          return ((Boolean)this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem })).booleanValue();
        this.mMethod.invoke(this.mRealOwner, new Object[] { paramMenuItem });
        return true;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
  }

  private class MenuState
  {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    private ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private boolean itemEnabled;
    private int itemIconResId;
    private int itemId;
    private String itemListenerMethodName;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private boolean itemVisible;
    private Menu menu;

    public MenuState(Menu arg2)
    {
      Object localObject;
      this.menu = localObject;
      resetGroup();
    }

    private char getShortcut(String paramString)
    {
      if (paramString == null)
        return '\000';
      return paramString.charAt(0);
    }

    private <T> T newInstance(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
    {
      try
      {
        Object localObject = MenuInflater.this.mContext.getClassLoader().loadClass(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.w("MenuInflater", "Cannot instantiate class: " + paramString, localException);
      }
      return null;
    }

    private void setItem(MenuItem paramMenuItem)
    {
      MenuItem localMenuItem = paramMenuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
      if (this.itemCheckable >= 1);
      for (boolean bool = true; ; bool = false)
      {
        localMenuItem.setCheckable(bool).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId).setAlphabeticShortcut(this.itemAlphabeticShortcut).setNumericShortcut(this.itemNumericShortcut);
        if (this.itemShowAsAction >= 0)
          paramMenuItem.setShowAsAction(this.itemShowAsAction);
        if (this.itemListenerMethodName == null)
          break label160;
        if (!MenuInflater.this.mContext.isRestricted())
          break;
        throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
      }
      paramMenuItem.setOnMenuItemClickListener(new MenuInflater.InflatedOnMenuItemClickListener(MenuInflater.this.mRealOwner, this.itemListenerMethodName));
      label160: if (this.itemCheckable >= 2)
      {
        if ((paramMenuItem instanceof MenuItemImpl))
          ((MenuItemImpl)paramMenuItem).setExclusiveCheckable(true);
      }
      else
      {
        String str = this.itemActionViewClassName;
        int i = 0;
        if (str != null)
        {
          paramMenuItem.setActionView((View)newInstance(this.itemActionViewClassName, MenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionViewConstructorArguments));
          i = 1;
        }
        if (this.itemActionViewLayout > 0)
        {
          if (i != 0)
            break label288;
          paramMenuItem.setActionView(this.itemActionViewLayout);
        }
      }
      while (true)
      {
        if (this.itemActionProvider != null)
          paramMenuItem.setActionProvider(this.itemActionProvider);
        return;
        this.menu.setGroupCheckable(this.groupId, true, true);
        break;
        label288: Log.w("MenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
      }
    }

    public void addItem()
    {
      this.itemAdded = true;
      setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }

    public SubMenu addSubMenuItem()
    {
      this.itemAdded = true;
      SubMenu localSubMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
      setItem(localSubMenu.getItem());
      return localSubMenu;
    }

    public boolean hasAddedItem()
    {
      return this.itemAdded;
    }

    public void readGroup(AttributeSet paramAttributeSet)
    {
      TypedArray localTypedArray = MenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockMenuGroup);
      this.groupId = localTypedArray.getResourceId(1, 0);
      this.groupCategory = localTypedArray.getInt(3, 0);
      this.groupOrder = localTypedArray.getInt(4, 0);
      this.groupCheckable = localTypedArray.getInt(5, 0);
      this.groupVisible = localTypedArray.getBoolean(2, true);
      this.groupEnabled = localTypedArray.getBoolean(0, true);
      localTypedArray.recycle();
    }

    public void readItem(AttributeSet paramAttributeSet)
    {
      TypedArray localTypedArray = MenuInflater.this.mContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockMenuItem);
      this.itemId = localTypedArray.getResourceId(2, 0);
      int i = localTypedArray.getInt(5, this.groupCategory);
      int j = localTypedArray.getInt(6, this.groupOrder);
      this.itemCategoryOrder = (0xFFFF0000 & i | 0xFFFF & j);
      this.itemTitle = localTypedArray.getText(7);
      this.itemTitleCondensed = localTypedArray.getText(8);
      this.itemIconResId = localTypedArray.getResourceId(0, 0);
      this.itemAlphabeticShortcut = getShortcut(localTypedArray.getString(9));
      this.itemNumericShortcut = getShortcut(localTypedArray.getString(10));
      int n;
      label149: int k;
      label220: String str1;
      label286: String str2;
      label331: int m;
      if (localTypedArray.hasValue(11))
        if (localTypedArray.getBoolean(11, false))
        {
          n = 1;
          this.itemCheckable = n;
          this.itemChecked = localTypedArray.getBoolean(3, false);
          this.itemVisible = localTypedArray.getBoolean(4, this.groupVisible);
          this.itemEnabled = localTypedArray.getBoolean(1, this.groupEnabled);
          TypedValue localTypedValue1 = new TypedValue();
          localTypedArray.getValue(13, localTypedValue1);
          if (localTypedValue1.type != 17)
            break label418;
          k = localTypedValue1.data;
          this.itemShowAsAction = k;
          this.itemListenerMethodName = localTypedArray.getString(12);
          this.itemActionViewLayout = localTypedArray.getResourceId(14, 0);
          TypedValue localTypedValue2 = new TypedValue();
          localTypedArray.getValue(15, localTypedValue2);
          if (localTypedValue2.type != 3)
            break label424;
          str1 = localTypedValue2.string.toString();
          this.itemActionViewClassName = str1;
          TypedValue localTypedValue3 = new TypedValue();
          localTypedArray.getValue(16, localTypedValue3);
          if (localTypedValue3.type != 3)
            break label430;
          str2 = localTypedValue3.string.toString();
          this.itemActionProviderClassName = str2;
          if (this.itemActionProviderClassName == null)
            break label436;
          m = 1;
          label347: if ((m == 0) || (this.itemActionViewLayout != 0) || (this.itemActionViewClassName != null))
            break label442;
        }
      for (this.itemActionProvider = ((ActionProvider)newInstance(this.itemActionProviderClassName, MenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, MenuInflater.this.mActionProviderConstructorArguments)); ; this.itemActionProvider = null)
      {
        localTypedArray.recycle();
        this.itemAdded = false;
        return;
        n = 0;
        break;
        this.itemCheckable = this.groupCheckable;
        break label149;
        label418: k = -1;
        break label220;
        label424: str1 = null;
        break label286;
        label430: str2 = null;
        break label331;
        label436: m = 0;
        break label347;
        label442: if (m != 0)
          Log.w("MenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
      }
    }

    public void resetGroup()
    {
      this.groupId = 0;
      this.groupCategory = 0;
      this.groupOrder = 0;
      this.groupCheckable = 0;
      this.groupVisible = true;
      this.groupEnabled = true;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.view.MenuInflater
 * JD-Core Version:    0.6.2
 */