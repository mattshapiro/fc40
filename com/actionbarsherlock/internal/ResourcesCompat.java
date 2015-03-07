package com.actionbarsherlock.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.actionbarsherlock.R.bool;
import com.actionbarsherlock.R.integer;

public final class ResourcesCompat
{
  private static final String TAG = "ResourcesCompat";

  public static boolean getResources_getBoolean(Context paramContext, int paramInt)
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 14)
      bool = paramContext.getResources().getBoolean(paramInt);
    float f1;
    label89: 
    do
    {
      float f3;
      do
      {
        do
        {
          return bool;
          DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
          f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.density;
          float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.density;
          if (f1 < f2);
          for (f3 = f1; ; f3 = f2)
          {
            if (paramInt != R.bool.abs__action_bar_embed_tabs)
              break label89;
            if (f1 >= 480.0F)
              break;
            return false;
          }
          if (paramInt != R.bool.abs__split_action_bar_is_narrow)
            break;
        }
        while (f1 < 480.0F);
        return false;
        if (paramInt != R.bool.abs__action_bar_expanded_action_views_exclusive)
          break;
      }
      while (f3 < 600.0F);
      return false;
      if (paramInt != R.bool.abs__config_allowActionMenuItemTextWithIcon)
        break;
    }
    while (f1 >= 480.0F);
    return false;
    throw new IllegalArgumentException("Unknown boolean resource ID " + paramInt);
  }

  public static int getResources_getInteger(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 13)
      return paramContext.getResources().getInteger(paramInt);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    float f = localDisplayMetrics.widthPixels / localDisplayMetrics.density;
    if (paramInt == R.integer.abs__max_action_buttons)
    {
      if (f >= 600.0F)
        return 5;
      if (f >= 500.0F)
        return 4;
      if (f >= 360.0F)
        return 3;
      return 2;
    }
    throw new IllegalArgumentException("Unknown integer resource ID " + paramInt);
  }

  public static int loadLogoFromManifest(Activity paramActivity)
  {
    int i = 0;
    label272: label280: label288: label292: label294: label299: label306: label310: 
    while (true)
    {
      int j;
      int n;
      int k;
      int m;
      try
      {
        String str1 = paramActivity.getClass().getName();
        String str2 = paramActivity.getApplicationInfo().packageName;
        XmlResourceParser localXmlResourceParser = paramActivity.createPackageContext(str2, 0).getAssets().openXmlResourceParser("AndroidManifest.xml");
        j = localXmlResourceParser.getEventType();
        i = 0;
        break label272;
        String str3;
        if (j == 2)
        {
          str3 = localXmlResourceParser.getName();
          if ("application".equals(str3))
          {
            n = -1 + localXmlResourceParser.getAttributeCount();
            break label280;
          }
        }
        else
        {
          j = localXmlResourceParser.nextToken();
          break label272;
          if (!"logo".equals(localXmlResourceParser.getAttributeName(n)))
            break label288;
          i = localXmlResourceParser.getAttributeResourceValue(n, 0);
          continue;
        }
        if (!"activity".equals(str3))
          continue;
        k = -1 + localXmlResourceParser.getAttributeCount();
        Integer localInteger = null;
        String str4 = null;
        m = 0;
        break label294;
        String str5 = localXmlResourceParser.getAttributeName(k);
        if ("logo".equals(str5))
        {
          localInteger = Integer.valueOf(localXmlResourceParser.getAttributeResourceValue(k, 0));
          if ((localInteger == null) || (str4 == null))
            break label306;
          i = localInteger.intValue();
          break label306;
        }
        if (!"name".equals(str5))
          continue;
        str4 = ActionBarSherlockCompat.cleanActivityName(str2, localXmlResourceParser.getAttributeValue(k));
        boolean bool = str1.equals(str4);
        if (!bool)
          break label299;
        m = 1;
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return i;
      }
      if (j == 1)
      {
        return i;
        while (true)
        {
          if (n >= 0)
            break label292;
          break;
          n--;
        }
        continue;
        while (true)
        {
          if (k >= 0)
            break label310;
          if (m == 0)
            break;
          return i;
          k--;
        }
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.ResourcesCompat
 * JD-Core Version:    0.6.2
 */