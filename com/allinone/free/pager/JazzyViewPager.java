package com.allinone.free.pager;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.allinone.free.R.styleable;
import com.nineoldandroids.view.ViewHelper;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class JazzyViewPager extends ViewPager
{
  private static final boolean API_11 = false;
  private static final float ROT_MAX = 15.0F;
  private static final float SCALE_MAX = 0.5F;
  public static final String TAG = "JazzyViewPager";
  private static final float ZOOM_MAX = 0.5F;
  public static int sOutlineColor = -1;
  private Camera mCamera = new Camera();
  private TransitionEffect mEffect = TransitionEffect.RotateUp;
  private boolean mEnabled = true;
  private boolean mFadeEnabled = false;
  private View mLeft;
  private Matrix mMatrix = new Matrix();
  private HashMap<Integer, Object> mObjs = new LinkedHashMap();
  private boolean mOutlineEnabled = false;
  private View mRight;
  private float mRot;
  private float mScale;
  private State mState;
  private float[] mTempFloat2 = new float[2];
  private float mTrans;
  private int oldPage;

  static
  {
    if (Build.VERSION.SDK_INT >= 11);
    for (boolean bool = true; ; bool = false)
    {
      API_11 = bool;
      return;
    }
  }

  public JazzyViewPager(Context paramContext)
  {
    this(paramContext, null);
  }

  public JazzyViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setClipChildren(false);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.JazzyViewPager);
    int i = localTypedArray.getInt(0, 0);
    setTransitionEffect(TransitionEffect.valueOf(getResources().getStringArray(2131558400)[i]));
    setFadeEnabled(localTypedArray.getBoolean(1, false));
    setOutlineEnabled(localTypedArray.getBoolean(2, false));
    setOutlineColor(localTypedArray.getColor(3, -1));
    switch ($SWITCH_TABLE$com$allinone$free$pager$JazzyViewPager$TransitionEffect()[this.mEffect.ordinal()])
    {
    case 11:
    default:
    case 10:
    case 12:
    }
    while (true)
    {
      localTypedArray.recycle();
      return;
      setFadeEnabled(true);
    }
  }

  private void animateAccordion(View paramView1, View paramView2, float paramFloat)
  {
    if (this.mState != State.IDLE)
    {
      if (paramView1 != null)
      {
        manageLayer(paramView1, true);
        ViewHelper.setPivotX(paramView1, paramView1.getMeasuredWidth());
        ViewHelper.setPivotY(paramView1, 0.0F);
        ViewHelper.setScaleX(paramView1, 1.0F - paramFloat);
      }
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        ViewHelper.setPivotX(paramView2, 0.0F);
        ViewHelper.setPivotY(paramView2, 0.0F);
        ViewHelper.setScaleX(paramView2, paramFloat);
      }
    }
  }

  private void animateCube(View paramView1, View paramView2, float paramFloat, boolean paramBoolean)
  {
    float f1 = 90.0F;
    float f2;
    if (this.mState != State.IDLE)
    {
      if (paramView1 != null)
      {
        manageLayer(paramView1, true);
        if (!paramBoolean)
          break label122;
        f2 = f1;
        this.mRot = (f2 * paramFloat);
        ViewHelper.setPivotX(paramView1, paramView1.getMeasuredWidth());
        ViewHelper.setPivotY(paramView1, 0.5F * paramView1.getMeasuredHeight());
        ViewHelper.setRotationY(paramView1, this.mRot);
      }
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        if (!paramBoolean)
          break label129;
      }
    }
    while (true)
    {
      this.mRot = (-f1 * (1.0F - paramFloat));
      ViewHelper.setPivotX(paramView2, 0.0F);
      ViewHelper.setPivotY(paramView2, 0.5F * paramView2.getMeasuredHeight());
      ViewHelper.setRotationY(paramView2, this.mRot);
      return;
      label122: f2 = -90.0F;
      break;
      label129: f1 = -90.0F;
    }
  }

  private void animateFlipHorizontal(View paramView1, View paramView2, float paramFloat, int paramInt)
  {
    if (this.mState != State.IDLE)
      if (paramView1 != null)
      {
        manageLayer(paramView1, true);
        this.mRot = (180.0F * paramFloat);
        if (this.mRot <= 90.0F)
          break label79;
        paramView1.setVisibility(4);
      }
    while (true)
    {
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        this.mRot = (-180.0F * (1.0F - paramFloat));
        if (this.mRot >= -90.0F)
          break;
        paramView2.setVisibility(4);
      }
      return;
      label79: if (paramView1.getVisibility() == 4)
        paramView1.setVisibility(0);
      this.mTrans = paramInt;
      ViewHelper.setPivotX(paramView1, 0.5F * paramView1.getMeasuredWidth());
      ViewHelper.setPivotY(paramView1, 0.5F * paramView1.getMeasuredHeight());
      ViewHelper.setTranslationX(paramView1, this.mTrans);
      ViewHelper.setRotationY(paramView1, this.mRot);
    }
    if (paramView2.getVisibility() == 4)
      paramView2.setVisibility(0);
    this.mTrans = (paramInt + (-getWidth() - getPageMargin()));
    ViewHelper.setPivotX(paramView2, 0.5F * paramView2.getMeasuredWidth());
    ViewHelper.setPivotY(paramView2, 0.5F * paramView2.getMeasuredHeight());
    ViewHelper.setTranslationX(paramView2, this.mTrans);
    ViewHelper.setRotationY(paramView2, this.mRot);
  }

  private void animateFlipVertical(View paramView1, View paramView2, float paramFloat, int paramInt)
  {
    if (this.mState != State.IDLE)
      if (paramView1 != null)
      {
        manageLayer(paramView1, true);
        this.mRot = (180.0F * paramFloat);
        if (this.mRot <= 90.0F)
          break label79;
        paramView1.setVisibility(4);
      }
    while (true)
    {
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        this.mRot = (-180.0F * (1.0F - paramFloat));
        if (this.mRot >= -90.0F)
          break;
        paramView2.setVisibility(4);
      }
      return;
      label79: if (paramView1.getVisibility() == 4)
        paramView1.setVisibility(0);
      this.mTrans = paramInt;
      ViewHelper.setPivotX(paramView1, 0.5F * paramView1.getMeasuredWidth());
      ViewHelper.setPivotY(paramView1, 0.5F * paramView1.getMeasuredHeight());
      ViewHelper.setTranslationX(paramView1, this.mTrans);
      ViewHelper.setRotationX(paramView1, this.mRot);
    }
    if (paramView2.getVisibility() == 4)
      paramView2.setVisibility(0);
    this.mTrans = (paramInt + (-getWidth() - getPageMargin()));
    ViewHelper.setPivotX(paramView2, 0.5F * paramView2.getMeasuredWidth());
    ViewHelper.setPivotY(paramView2, 0.5F * paramView2.getMeasuredHeight());
    ViewHelper.setTranslationX(paramView2, this.mTrans);
    ViewHelper.setRotationX(paramView2, this.mRot);
  }

  private void animateRotate(View paramView1, View paramView2, float paramFloat, boolean paramBoolean)
  {
    int m;
    int n;
    label48: int i1;
    label105: int i;
    label146: int j;
    if (this.mState != State.IDLE)
    {
      if (paramView1 != null)
      {
        manageLayer(paramView1, true);
        if (!paramBoolean)
          break label251;
        m = 1;
        this.mRot = (m * (15.0F * paramFloat));
        if (!paramBoolean)
          break label257;
        n = -1;
        this.mTrans = (n * (float)(getMeasuredHeight() - getMeasuredHeight() * Math.cos(3.141592653589793D * this.mRot / 180.0D)));
        ViewHelper.setPivotX(paramView1, 0.5F * paramView1.getMeasuredWidth());
        if (!paramBoolean)
          break label263;
        i1 = 0;
        ViewHelper.setPivotY(paramView1, i1);
        ViewHelper.setTranslationY(paramView1, this.mTrans);
        ViewHelper.setRotation(paramView1, this.mRot);
      }
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        if (!paramBoolean)
          break label272;
        i = 1;
        this.mRot = (i * (-15.0F + 15.0F * paramFloat));
        if (!paramBoolean)
          break label278;
        j = -1;
        label170: this.mTrans = (j * (float)(getMeasuredHeight() - getMeasuredHeight() * Math.cos(3.141592653589793D * this.mRot / 180.0D)));
        ViewHelper.setPivotX(paramView2, 0.5F * paramView2.getMeasuredWidth());
        if (!paramBoolean)
          break label284;
      }
    }
    label257: label263: label272: label278: label284: for (int k = 0; ; k = paramView2.getMeasuredHeight())
    {
      ViewHelper.setPivotY(paramView2, k);
      ViewHelper.setTranslationY(paramView2, this.mTrans);
      ViewHelper.setRotation(paramView2, this.mRot);
      return;
      label251: m = -1;
      break;
      n = 1;
      break label48;
      i1 = paramView1.getMeasuredHeight();
      break label105;
      i = -1;
      break label146;
      j = 1;
      break label170;
    }
  }

  private void animateZoom(View paramView1, View paramView2, float paramFloat, boolean paramBoolean)
  {
    float f2;
    if (this.mState != State.IDLE)
    {
      if (paramView1 != null)
      {
        manageLayer(paramView1, true);
        if (!paramBoolean)
          break label153;
        f2 = 0.5F + 0.5F * (1.0F - paramFloat);
        this.mScale = f2;
        ViewHelper.setPivotX(paramView1, 0.5F * paramView1.getMeasuredWidth());
        ViewHelper.setPivotY(paramView1, 0.5F * paramView1.getMeasuredHeight());
        ViewHelper.setScaleX(paramView1, this.mScale);
        ViewHelper.setScaleY(paramView1, this.mScale);
      }
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        if (!paramBoolean)
          break label168;
      }
    }
    label153: label168: for (float f1 = 0.5F + 0.5F * paramFloat; ; f1 = 1.5F - 0.5F * paramFloat)
    {
      this.mScale = f1;
      ViewHelper.setPivotX(paramView2, 0.5F * paramView2.getMeasuredWidth());
      ViewHelper.setPivotY(paramView2, 0.5F * paramView2.getMeasuredHeight());
      ViewHelper.setScaleX(paramView2, this.mScale);
      ViewHelper.setScaleY(paramView2, this.mScale);
      return;
      f2 = 1.5F - 0.5F * (1.0F - paramFloat);
      break;
    }
  }

  @TargetApi(11)
  private void disableHardwareLayer()
  {
    if (!API_11);
    while (true)
    {
      return;
      for (int i = 0; i < getChildCount(); i++)
      {
        View localView = getChildAt(i);
        if (localView.getLayerType() != 0)
          localView.setLayerType(0, null);
      }
    }
  }

  private boolean isSmall(float paramFloat)
  {
    return Math.abs(paramFloat) < 0.0001D;
  }

  private void logState(View paramView, String paramString)
  {
    Log.v("JazzyViewPager", paramString + ": ROT (" + ViewHelper.getRotation(paramView) + ", " + ViewHelper.getRotationX(paramView) + ", " + ViewHelper.getRotationY(paramView) + "), TRANS (" + ViewHelper.getTranslationX(paramView) + ", " + ViewHelper.getTranslationY(paramView) + "), SCALE (" + ViewHelper.getScaleX(paramView) + ", " + ViewHelper.getScaleY(paramView) + "), ALPHA " + ViewHelper.getAlpha(paramView));
  }

  @TargetApi(11)
  private void manageLayer(View paramView, boolean paramBoolean)
  {
    if (!API_11);
    while (true)
    {
      return;
      if (paramBoolean);
      for (int i = 2; i != paramView.getLayerType(); i = 0)
      {
        paramView.setLayerType(i, null);
        return;
      }
    }
  }

  private View wrapChild(View paramView)
  {
    if ((!this.mOutlineEnabled) || ((paramView instanceof OutlineContainer)))
      return paramView;
    OutlineContainer localOutlineContainer = new OutlineContainer(getContext());
    localOutlineContainer.setLayoutParams(generateDefaultLayoutParams());
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    localOutlineContainer.addView(paramView);
    return localOutlineContainer;
  }

  private void wrapWithOutlines()
  {
    for (int i = 0; ; i++)
    {
      if (i >= getChildCount())
        return;
      View localView = getChildAt(i);
      if (!(localView instanceof OutlineContainer))
      {
        removeView(localView);
        super.addView(wrapChild(localView), i);
      }
    }
  }

  public void addView(View paramView)
  {
    super.addView(wrapChild(paramView));
  }

  public void addView(View paramView, int paramInt)
  {
    super.addView(wrapChild(paramView), paramInt);
  }

  public void addView(View paramView, int paramInt1, int paramInt2)
  {
    super.addView(wrapChild(paramView), paramInt1, paramInt2);
  }

  public void addView(View paramView, int paramInt, ViewPager.LayoutParams paramLayoutParams)
  {
    super.addView(wrapChild(paramView), paramInt, paramLayoutParams);
  }

  public void addView(View paramView, ViewPager.LayoutParams paramLayoutParams)
  {
    super.addView(wrapChild(paramView), paramLayoutParams);
  }

  protected void animateFade(View paramView1, View paramView2, float paramFloat)
  {
    if (paramView1 != null)
      ViewHelper.setAlpha(paramView1, 1.0F - paramFloat);
    if (paramView2 != null)
      ViewHelper.setAlpha(paramView2, paramFloat);
  }

  protected void animateOutline(View paramView1, View paramView2)
  {
    if (!(paramView1 instanceof OutlineContainer));
    do
    {
      do
      {
        return;
        if (this.mState == State.IDLE)
          break;
        if (paramView1 != null)
        {
          manageLayer(paramView1, true);
          ((OutlineContainer)paramView1).setOutlineAlpha(1.0F);
        }
      }
      while (paramView2 == null);
      manageLayer(paramView2, true);
      ((OutlineContainer)paramView2).setOutlineAlpha(1.0F);
      return;
      if (paramView1 != null)
        ((OutlineContainer)paramView1).start();
    }
    while (paramView2 == null);
    ((OutlineContainer)paramView2).start();
  }

  protected void animateScroll(int paramInt, float paramFloat)
  {
    if (this.mState != State.IDLE)
    {
      this.mRot = (30.0F * ((float)(1.0D - Math.cos(6.283185307179586D * paramFloat)) / 2.0F));
      if (this.mState != State.GOING_RIGHT)
        break label77;
    }
    label77: for (float f = this.mRot; ; f = -this.mRot)
    {
      ViewHelper.setRotationY(this, f);
      ViewHelper.setPivotX(this, 0.5F * getMeasuredWidth());
      ViewHelper.setPivotY(this, 0.5F * getMeasuredHeight());
      return;
    }
  }

  protected void animateStack(View paramView1, View paramView2, float paramFloat, int paramInt)
  {
    if (this.mState != State.IDLE)
    {
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        this.mScale = (0.5F + 0.5F * paramFloat);
        this.mTrans = (paramInt + (-getWidth() - getPageMargin()));
        ViewHelper.setScaleX(paramView2, this.mScale);
        ViewHelper.setScaleY(paramView2, this.mScale);
        ViewHelper.setTranslationX(paramView2, this.mTrans);
      }
      if (paramView1 != null)
        paramView1.bringToFront();
    }
  }

  protected void animateTablet(View paramView1, View paramView2, float paramFloat)
  {
    if (this.mState != State.IDLE)
    {
      if (paramView1 != null)
      {
        manageLayer(paramView1, true);
        this.mRot = (30.0F * paramFloat);
        this.mTrans = getOffsetXForRotation(this.mRot, paramView1.getMeasuredWidth(), paramView1.getMeasuredHeight());
        ViewHelper.setPivotX(paramView1, paramView1.getMeasuredWidth() / 2);
        ViewHelper.setPivotY(paramView1, paramView1.getMeasuredHeight() / 2);
        ViewHelper.setTranslationX(paramView1, this.mTrans);
        ViewHelper.setRotationY(paramView1, this.mRot);
        logState(paramView1, "Left");
      }
      if (paramView2 != null)
      {
        manageLayer(paramView2, true);
        this.mRot = (-30.0F * (1.0F - paramFloat));
        this.mTrans = getOffsetXForRotation(this.mRot, paramView2.getMeasuredWidth(), paramView2.getMeasuredHeight());
        ViewHelper.setPivotX(paramView2, 0.5F * paramView2.getMeasuredWidth());
        ViewHelper.setPivotY(paramView2, 0.5F * paramView2.getMeasuredHeight());
        ViewHelper.setTranslationX(paramView2, this.mTrans);
        ViewHelper.setRotationY(paramView2, this.mRot);
        logState(paramView2, "Right");
      }
    }
  }

  public View findViewFromObject(int paramInt)
  {
    Object localObject = this.mObjs.get(Integer.valueOf(paramInt));
    View localView;
    if (localObject == null)
    {
      localView = null;
      return localView;
    }
    PagerAdapter localPagerAdapter = getAdapter();
    for (int i = 0; ; i++)
    {
      if (i >= getChildCount())
        return null;
      localView = getChildAt(i);
      if (localPagerAdapter.isViewFromObject(localView, localObject))
        break;
    }
  }

  public boolean getFadeEnabled()
  {
    return this.mFadeEnabled;
  }

  protected float getOffsetXForRotation(float paramFloat, int paramInt1, int paramInt2)
  {
    this.mMatrix.reset();
    this.mCamera.save();
    this.mCamera.rotateY(Math.abs(paramFloat));
    this.mCamera.getMatrix(this.mMatrix);
    this.mCamera.restore();
    this.mMatrix.preTranslate(0.5F * -paramInt1, 0.5F * -paramInt2);
    this.mMatrix.postTranslate(0.5F * paramInt1, 0.5F * paramInt2);
    this.mTempFloat2[0] = paramInt1;
    this.mTempFloat2[1] = paramInt2;
    this.mMatrix.mapPoints(this.mTempFloat2);
    float f1 = paramInt1 - this.mTempFloat2[0];
    if (paramFloat > 0.0F);
    for (float f2 = 1.0F; ; f2 = -1.0F)
      return f2 * f1;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mEnabled)
      return super.onInterceptTouchEvent(paramMotionEvent);
    return false;
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    State localState;
    int i;
    label54: label76: float f;
    if ((this.mState == State.IDLE) && (paramFloat > 0.0F))
    {
      this.oldPage = getCurrentItem();
      if (paramInt1 == this.oldPage)
      {
        localState = State.GOING_RIGHT;
        this.mState = localState;
      }
    }
    else
    {
      if (paramInt1 != this.oldPage)
        break label254;
      i = 1;
      if ((this.mState != State.GOING_RIGHT) || (i != 0))
        break label260;
      this.mState = State.GOING_LEFT;
      if (!isSmall(paramFloat))
        break label285;
      f = 0.0F;
      label87: this.mLeft = findViewFromObject(paramInt1);
      this.mRight = findViewFromObject(paramInt1 + 1);
      if (this.mFadeEnabled)
        animateFade(this.mLeft, this.mRight, f);
      if (this.mOutlineEnabled)
        animateOutline(this.mLeft, this.mRight);
      switch ($SWITCH_TABLE$com$allinone$free$pager$JazzyViewPager$TransitionEffect()[this.mEffect.ordinal()])
      {
      case 1:
      default:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      }
    }
    while (true)
    {
      super.onPageScrolled(paramInt1, paramFloat, paramInt2);
      if (f == 0.0F)
      {
        disableHardwareLayer();
        this.mState = State.IDLE;
      }
      return;
      localState = State.GOING_LEFT;
      break;
      label254: i = 0;
      break label54;
      label260: if ((this.mState != State.GOING_LEFT) || (i == 0))
        break label76;
      this.mState = State.GOING_RIGHT;
      break label76;
      label285: f = paramFloat;
      break label87;
      animateTablet(this.mLeft, this.mRight, f);
      continue;
      animateCube(this.mLeft, this.mRight, f, true);
      continue;
      animateCube(this.mLeft, this.mRight, f, false);
      continue;
      animateFlipVertical(this.mLeft, this.mRight, paramFloat, paramInt2);
      continue;
      animateFlipHorizontal(this.mLeft, this.mRight, f, paramInt2);
      animateStack(this.mLeft, this.mRight, f, paramInt2);
      continue;
      animateZoom(this.mLeft, this.mRight, f, true);
      continue;
      animateZoom(this.mLeft, this.mRight, f, false);
      continue;
      animateRotate(this.mLeft, this.mRight, f, true);
      continue;
      animateRotate(this.mLeft, this.mRight, f, false);
      continue;
      animateAccordion(this.mLeft, this.mRight, f);
    }
  }

  public void setFadeEnabled(boolean paramBoolean)
  {
    this.mFadeEnabled = paramBoolean;
  }

  public void setObjectForPosition(Object paramObject, int paramInt)
  {
    this.mObjs.put(Integer.valueOf(paramInt), paramObject);
  }

  public void setOutlineColor(int paramInt)
  {
    sOutlineColor = paramInt;
  }

  public void setOutlineEnabled(boolean paramBoolean)
  {
    this.mOutlineEnabled = paramBoolean;
    wrapWithOutlines();
  }

  public void setPagingEnabled(boolean paramBoolean)
  {
    this.mEnabled = paramBoolean;
  }

  public void setTransitionEffect(TransitionEffect paramTransitionEffect)
  {
    this.mEffect = paramTransitionEffect;
  }

  private static enum State
  {
    static
    {
      GOING_LEFT = new State("GOING_LEFT", 1);
      GOING_RIGHT = new State("GOING_RIGHT", 2);
      State[] arrayOfState = new State[3];
      arrayOfState[0] = IDLE;
      arrayOfState[1] = GOING_LEFT;
      arrayOfState[2] = GOING_RIGHT;
    }
  }

  public static enum TransitionEffect
  {
    static
    {
      CubeIn = new TransitionEffect("CubeIn", 2);
      CubeOut = new TransitionEffect("CubeOut", 3);
      FlipVertical = new TransitionEffect("FlipVertical", 4);
      FlipHorizontal = new TransitionEffect("FlipHorizontal", 5);
      Stack = new TransitionEffect("Stack", 6);
      ZoomIn = new TransitionEffect("ZoomIn", 7);
      ZoomOut = new TransitionEffect("ZoomOut", 8);
      RotateUp = new TransitionEffect("RotateUp", 9);
      RotateDown = new TransitionEffect("RotateDown", 10);
      Accordion = new TransitionEffect("Accordion", 11);
      TransitionEffect[] arrayOfTransitionEffect = new TransitionEffect[12];
      arrayOfTransitionEffect[0] = Standard;
      arrayOfTransitionEffect[1] = Tablet;
      arrayOfTransitionEffect[2] = CubeIn;
      arrayOfTransitionEffect[3] = CubeOut;
      arrayOfTransitionEffect[4] = FlipVertical;
      arrayOfTransitionEffect[5] = FlipHorizontal;
      arrayOfTransitionEffect[6] = Stack;
      arrayOfTransitionEffect[7] = ZoomIn;
      arrayOfTransitionEffect[8] = ZoomOut;
      arrayOfTransitionEffect[9] = RotateUp;
      arrayOfTransitionEffect[10] = RotateDown;
      arrayOfTransitionEffect[11] = Accordion;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.pager.JazzyViewPager
 * JD-Core Version:    0.6.2
 */