package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.Button;
import java.util.Locale;

public class CapitalizingButton extends Button
{
  private static final boolean IS_GINGERBREAD;
  private static final int[] R_styleable_Button;
  private static final int R_styleable_Button_textAppearance;
  private static final int[] R_styleable_TextAppearance;
  private static final int R_styleable_TextAppearance_textAllCaps;
  private static final boolean SANS_ICE_CREAM;
  private boolean mAllCaps;

  static
  {
    boolean bool1;
    if (Build.VERSION.SDK_INT < 14)
    {
      bool1 = true;
      SANS_ICE_CREAM = bool1;
      if (Build.VERSION.SDK_INT < 9)
        break label56;
    }
    label56: for (boolean bool2 = true; ; bool2 = false)
    {
      IS_GINGERBREAD = bool2;
      R_styleable_Button = new int[] { 16842804 };
      R_styleable_TextAppearance = new int[] { 16843660 };
      return;
      bool1 = false;
      break;
    }
  }

  public CapitalizingButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R_styleable_Button);
    int i = localTypedArray1.getResourceId(0, -1);
    localTypedArray1.recycle();
    if (i != -1)
    {
      TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(i, R_styleable_TextAppearance);
      if (localTypedArray2 != null)
      {
        this.mAllCaps = localTypedArray2.getBoolean(0, true);
        localTypedArray2.recycle();
      }
    }
  }

  public void setTextCompat(CharSequence paramCharSequence)
  {
    if ((SANS_ICE_CREAM) && (this.mAllCaps) && (paramCharSequence != null))
    {
      if (IS_GINGERBREAD)
        try
        {
          setText(paramCharSequence.toString().toUpperCase(Locale.ROOT));
          return;
        }
        catch (NoSuchFieldError localNoSuchFieldError)
        {
          setText(paramCharSequence.toString().toUpperCase());
          return;
        }
      setText(paramCharSequence.toString().toUpperCase());
      return;
    }
    setText(paramCharSequence);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.internal.widget.CapitalizingButton
 * JD-Core Version:    0.6.2
 */