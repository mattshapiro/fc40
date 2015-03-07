package com.allinone.free.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;

public class TouchImageView extends ImageView
{
  private static final String DEBUG = "DEBUG";
  private static final float SUPER_MAX_MULTIPLIER = 1.25F;
  private static final float SUPER_MIN_MULTIPLIER = 0.75F;
  private Context context;
  private ZoomVariables delayedZoomVariables;
  private GestureDetector.OnDoubleTapListener doubleTapListener = null;
  private Fling fling;
  private boolean imageRenderedAtLeastOnce;
  private float[] m;
  private GestureDetector mGestureDetector;
  private ScaleGestureDetector mScaleDetector;
  private ImageView.ScaleType mScaleType;
  private float matchViewHeight;
  private float matchViewWidth;
  private Matrix matrix;
  private float maxScale;
  private float minScale;
  private float normalizedScale;
  private boolean onDrawReady;
  private float prevMatchViewHeight;
  private float prevMatchViewWidth;
  private Matrix prevMatrix;
  private int prevViewHeight;
  private int prevViewWidth;
  private State state;
  private float superMaxScale;
  private float superMinScale;
  private OnTouchImageViewListener touchImageViewListener = null;
  private View.OnTouchListener userTouchListener = null;
  private int viewHeight;
  private int viewWidth;

  public TouchImageView(Context paramContext)
  {
    super(paramContext);
    sharedConstructing(paramContext);
  }

  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    sharedConstructing(paramContext);
  }

  public TouchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    sharedConstructing(paramContext);
  }

  @TargetApi(16)
  private void compatPostOnAnimation(Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      postOnAnimation(paramRunnable);
      return;
    }
    postDelayed(paramRunnable, 16L);
  }

  private void fitImageToView()
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0));
    while ((this.matrix == null) || (this.prevMatrix == null))
      return;
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    float f1 = this.viewWidth / i;
    float f2 = this.viewHeight / j;
    switch ($SWITCH_TABLE$android$widget$ImageView$ScaleType()[this.mScaleType.ordinal()])
    {
    case 5:
    case 6:
    default:
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    case 1:
      f2 = 1.0F;
      f1 = f2;
    case 7:
      float f3 = this.viewWidth - f1 * i;
      float f4 = this.viewHeight - f2 * j;
      this.matchViewWidth = (this.viewWidth - f3);
      this.matchViewHeight = (this.viewHeight - f4);
      if ((!isZoomed()) && (!this.imageRenderedAtLeastOnce))
      {
        this.matrix.setScale(f1, f2);
        this.matrix.postTranslate(f3 / 2.0F, f4 / 2.0F);
        this.normalizedScale = 1.0F;
      }
      break;
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      fixTrans();
      setImageMatrix(this.matrix);
      return;
      f2 = Math.max(f1, f2);
      f1 = f2;
      break;
      f2 = Math.min(1.0F, Math.min(f1, f2));
      f1 = f2;
      f2 = Math.min(f1, f2);
      f1 = f2;
      break;
      if ((this.prevMatchViewWidth == 0.0F) || (this.prevMatchViewHeight == 0.0F))
        savePreviousImageValues();
      this.prevMatrix.getValues(this.m);
      this.m[0] = (this.matchViewWidth / i * this.normalizedScale);
      this.m[4] = (this.matchViewHeight / j * this.normalizedScale);
      float f5 = this.m[2];
      float f6 = this.m[5];
      translateMatrixAfterRotate(2, f5, this.prevMatchViewWidth * this.normalizedScale, getImageWidth(), this.prevViewWidth, this.viewWidth, i);
      translateMatrixAfterRotate(5, f6, this.prevMatchViewHeight * this.normalizedScale, getImageHeight(), this.prevViewHeight, this.viewHeight, j);
      this.matrix.setValues(this.m);
    }
  }

  private void fixScaleTrans()
  {
    fixTrans();
    this.matrix.getValues(this.m);
    if (getImageWidth() < this.viewWidth)
      this.m[2] = ((this.viewWidth - getImageWidth()) / 2.0F);
    if (getImageHeight() < this.viewHeight)
      this.m[5] = ((this.viewHeight - getImageHeight()) / 2.0F);
    this.matrix.setValues(this.m);
  }

  private void fixTrans()
  {
    this.matrix.getValues(this.m);
    float f1 = this.m[2];
    float f2 = this.m[5];
    float f3 = getFixTrans(f1, this.viewWidth, getImageWidth());
    float f4 = getFixTrans(f2, this.viewHeight, getImageHeight());
    if ((f3 != 0.0F) || (f4 != 0.0F))
      this.matrix.postTranslate(f3, f4);
  }

  private float getFixDragTrans(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat3 <= paramFloat2)
      paramFloat1 = 0.0F;
    return paramFloat1;
  }

  private float getFixTrans(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1;
    if (paramFloat3 <= paramFloat2)
      f1 = 0.0F;
    for (float f2 = paramFloat2 - paramFloat3; paramFloat1 < f1; f2 = 0.0F)
    {
      return f1 + -paramFloat1;
      f1 = paramFloat2 - paramFloat3;
    }
    if (paramFloat1 > f2)
      return f2 + -paramFloat1;
    return 0.0F;
  }

  private float getImageHeight()
  {
    return this.matchViewHeight * this.normalizedScale;
  }

  private float getImageWidth()
  {
    return this.matchViewWidth * this.normalizedScale;
  }

  private void printMatrixInfo()
  {
    float[] arrayOfFloat = new float[9];
    this.matrix.getValues(arrayOfFloat);
    Log.d("DEBUG", "Scale: " + arrayOfFloat[0] + " TransX: " + arrayOfFloat[2] + " TransY: " + arrayOfFloat[5]);
  }

  private void savePreviousImageValues()
  {
    if ((this.matrix != null) && (this.viewHeight != 0) && (this.viewWidth != 0))
    {
      this.matrix.getValues(this.m);
      this.prevMatrix.setValues(this.m);
      this.prevMatchViewHeight = this.matchViewHeight;
      this.prevMatchViewWidth = this.matchViewWidth;
      this.prevViewHeight = this.viewHeight;
      this.prevViewWidth = this.viewWidth;
    }
  }

  private void scaleImage(double paramDouble, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1;
    float f2;
    float f3;
    if (paramBoolean)
    {
      f1 = this.superMinScale;
      f2 = this.superMaxScale;
      f3 = this.normalizedScale;
      this.normalizedScale = ((float)(paramDouble * this.normalizedScale));
      if (this.normalizedScale <= f2)
        break label93;
      this.normalizedScale = f2;
      paramDouble = f2 / f3;
    }
    while (true)
    {
      this.matrix.postScale((float)paramDouble, (float)paramDouble, paramFloat1, paramFloat2);
      fixScaleTrans();
      return;
      f1 = this.minScale;
      f2 = this.maxScale;
      break;
      label93: if (this.normalizedScale < f1)
      {
        this.normalizedScale = f1;
        paramDouble = f1 / f3;
      }
    }
  }

  private void setState(State paramState)
  {
    this.state = paramState;
  }

  private int setViewSize(int paramInt1, int paramInt2, int paramInt3)
  {
    switch (paramInt1)
    {
    default:
      return paramInt2;
    case 1073741824:
      return paramInt2;
    case -2147483648:
      return Math.min(paramInt3, paramInt2);
    case 0:
    }
    return paramInt3;
  }

  private void sharedConstructing(Context paramContext)
  {
    super.setClickable(true);
    this.context = paramContext;
    this.mScaleDetector = new ScaleGestureDetector(paramContext, new ScaleListener(null));
    this.mGestureDetector = new GestureDetector(paramContext, new GestureListener(null));
    this.matrix = new Matrix();
    this.prevMatrix = new Matrix();
    this.m = new float[9];
    this.normalizedScale = 1.0F;
    if (this.mScaleType == null)
      this.mScaleType = ImageView.ScaleType.FIT_CENTER;
    this.minScale = 1.0F;
    this.maxScale = 3.0F;
    this.superMinScale = (0.75F * this.minScale);
    this.superMaxScale = (1.25F * this.maxScale);
    setImageMatrix(this.matrix);
    setScaleType(ImageView.ScaleType.MATRIX);
    setState(State.NONE);
    this.onDrawReady = false;
    super.setOnTouchListener(new PrivateOnTouchListener(null));
  }

  private PointF transformCoordBitmapToTouch(float paramFloat1, float paramFloat2)
  {
    this.matrix.getValues(this.m);
    float f1 = getDrawable().getIntrinsicWidth();
    float f2 = getDrawable().getIntrinsicHeight();
    float f3 = paramFloat1 / f1;
    float f4 = paramFloat2 / f2;
    return new PointF(this.m[2] + f3 * getImageWidth(), this.m[5] + f4 * getImageHeight());
  }

  private PointF transformCoordTouchToBitmap(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.matrix.getValues(this.m);
    float f1 = getDrawable().getIntrinsicWidth();
    float f2 = getDrawable().getIntrinsicHeight();
    float f3 = this.m[2];
    float f4 = this.m[5];
    float f5 = f1 * (paramFloat1 - f3) / getImageWidth();
    float f6 = f2 * (paramFloat2 - f4) / getImageHeight();
    if (paramBoolean)
    {
      f5 = Math.min(Math.max(f5, 0.0F), f1);
      f6 = Math.min(Math.max(f6, 0.0F), f2);
    }
    return new PointF(f5, f6);
  }

  private void translateMatrixAfterRotate(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramFloat3 < paramInt3)
    {
      this.m[paramInt1] = (0.5F * (paramInt3 - paramInt4 * this.m[0]));
      return;
    }
    if (paramFloat1 > 0.0F)
    {
      this.m[paramInt1] = (-(0.5F * (paramFloat3 - paramInt3)));
      return;
    }
    float f = (Math.abs(paramFloat1) + 0.5F * paramInt2) / paramFloat2;
    this.m[paramInt1] = (-(f * paramFloat3 - 0.5F * paramInt3));
  }

  public boolean canScrollHorizontally(int paramInt)
  {
    this.matrix.getValues(this.m);
    float f = this.m[2];
    if (getImageWidth() < this.viewWidth);
    while (((f >= -1.0F) && (paramInt < 0)) || ((1.0F + (Math.abs(f) + this.viewWidth) >= getImageWidth()) && (paramInt > 0)))
      return false;
    return true;
  }

  public boolean canScrollHorizontallyFroyo(int paramInt)
  {
    return canScrollHorizontally(paramInt);
  }

  public float getCurrentZoom()
  {
    return this.normalizedScale;
  }

  public float getMaxZoom()
  {
    return this.maxScale;
  }

  public float getMinZoom()
  {
    return this.minScale;
  }

  public ImageView.ScaleType getScaleType()
  {
    return this.mScaleType;
  }

  public PointF getScrollPosition()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null)
      return null;
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    PointF localPointF = transformCoordTouchToBitmap(this.viewWidth / 2, this.viewHeight / 2, true);
    localPointF.x /= i;
    localPointF.y /= j;
    return localPointF;
  }

  public RectF getZoomedRect()
  {
    if (this.mScaleType == ImageView.ScaleType.FIT_XY)
      throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
    PointF localPointF1 = transformCoordTouchToBitmap(0.0F, 0.0F, true);
    PointF localPointF2 = transformCoordTouchToBitmap(this.viewWidth, this.viewHeight, true);
    float f1 = getDrawable().getIntrinsicWidth();
    float f2 = getDrawable().getIntrinsicHeight();
    return new RectF(localPointF1.x / f1, localPointF1.y / f2, localPointF2.x / f1, localPointF2.y / f2);
  }

  public boolean isZoomed()
  {
    return this.normalizedScale != 1.0F;
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    savePreviousImageValues();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.onDrawReady = true;
    this.imageRenderedAtLeastOnce = true;
    if (this.delayedZoomVariables != null)
    {
      setZoom(this.delayedZoomVariables.scale, this.delayedZoomVariables.focusX, this.delayedZoomVariables.focusY, this.delayedZoomVariables.scaleType);
      this.delayedZoomVariables = null;
    }
    super.onDraw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = getDrawable();
    if ((localDrawable == null) || (localDrawable.getIntrinsicWidth() == 0) || (localDrawable.getIntrinsicHeight() == 0))
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    int k = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt2);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    this.viewWidth = setViewSize(n, k, i);
    this.viewHeight = setViewSize(i2, i1, j);
    setMeasuredDimension(this.viewWidth, this.viewHeight);
    fitImageToView();
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      this.normalizedScale = localBundle.getFloat("saveScale");
      this.m = localBundle.getFloatArray("matrix");
      this.prevMatrix.setValues(this.m);
      this.prevMatchViewHeight = localBundle.getFloat("matchViewHeight");
      this.prevMatchViewWidth = localBundle.getFloat("matchViewWidth");
      this.prevViewHeight = localBundle.getInt("viewHeight");
      this.prevViewWidth = localBundle.getInt("viewWidth");
      this.imageRenderedAtLeastOnce = localBundle.getBoolean("imageRendered");
      super.onRestoreInstanceState(localBundle.getParcelable("instanceState"));
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("instanceState", super.onSaveInstanceState());
    localBundle.putFloat("saveScale", this.normalizedScale);
    localBundle.putFloat("matchViewHeight", this.matchViewHeight);
    localBundle.putFloat("matchViewWidth", this.matchViewWidth);
    localBundle.putInt("viewWidth", this.viewWidth);
    localBundle.putInt("viewHeight", this.viewHeight);
    this.matrix.getValues(this.m);
    localBundle.putFloatArray("matrix", this.m);
    localBundle.putBoolean("imageRendered", this.imageRenderedAtLeastOnce);
    return localBundle;
  }

  public void resetZoom()
  {
    this.normalizedScale = 1.0F;
    fitImageToView();
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    savePreviousImageValues();
    fitImageToView();
  }

  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    savePreviousImageValues();
    fitImageToView();
  }

  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    savePreviousImageValues();
    fitImageToView();
  }

  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    savePreviousImageValues();
    fitImageToView();
  }

  public void setMaxZoom(float paramFloat)
  {
    this.maxScale = paramFloat;
    this.superMaxScale = (1.25F * this.maxScale);
  }

  public void setMinZoom(float paramFloat)
  {
    this.minScale = paramFloat;
    this.superMinScale = (0.75F * this.minScale);
  }

  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    this.doubleTapListener = paramOnDoubleTapListener;
  }

  public void setOnTouchImageViewListener(OnTouchImageViewListener paramOnTouchImageViewListener)
  {
    this.touchImageViewListener = paramOnTouchImageViewListener;
  }

  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.userTouchListener = paramOnTouchListener;
  }

  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.FIT_START) || (paramScaleType == ImageView.ScaleType.FIT_END))
      throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    if (paramScaleType == ImageView.ScaleType.MATRIX)
      super.setScaleType(ImageView.ScaleType.MATRIX);
    do
    {
      return;
      this.mScaleType = paramScaleType;
    }
    while (!this.onDrawReady);
    setZoom(this);
  }

  public void setScrollPosition(float paramFloat1, float paramFloat2)
  {
    setZoom(this.normalizedScale, paramFloat1, paramFloat2);
  }

  public void setZoom(float paramFloat)
  {
    setZoom(paramFloat, 0.5F, 0.5F);
  }

  public void setZoom(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    setZoom(paramFloat1, paramFloat2, paramFloat3, this.mScaleType);
  }

  public void setZoom(float paramFloat1, float paramFloat2, float paramFloat3, ImageView.ScaleType paramScaleType)
  {
    if (!this.onDrawReady)
    {
      this.delayedZoomVariables = new ZoomVariables(paramFloat1, paramFloat2, paramFloat3, paramScaleType);
      return;
    }
    if (paramScaleType != this.mScaleType)
      setScaleType(paramScaleType);
    resetZoom();
    scaleImage(paramFloat1, this.viewWidth / 2, this.viewHeight / 2, true);
    this.matrix.getValues(this.m);
    this.m[2] = (-(paramFloat2 * getImageWidth() - 0.5F * this.viewWidth));
    this.m[5] = (-(paramFloat3 * getImageHeight() - 0.5F * this.viewHeight));
    this.matrix.setValues(this.m);
    fixTrans();
    setImageMatrix(this.matrix);
  }

  public void setZoom(TouchImageView paramTouchImageView)
  {
    PointF localPointF = paramTouchImageView.getScrollPosition();
    setZoom(paramTouchImageView.getCurrentZoom(), localPointF.x, localPointF.y, paramTouchImageView.getScaleType());
  }

  @TargetApi(9)
  private class CompatScroller
  {
    boolean isPreGingerbread;
    OverScroller overScroller;
    Scroller scroller;

    public CompatScroller(Context arg2)
    {
      Context localContext;
      if (Build.VERSION.SDK_INT < 9)
      {
        this.isPreGingerbread = true;
        this.scroller = new Scroller(localContext);
        return;
      }
      this.isPreGingerbread = false;
      this.overScroller = new OverScroller(localContext);
    }

    public boolean computeScrollOffset()
    {
      if (this.isPreGingerbread)
        return this.scroller.computeScrollOffset();
      this.overScroller.computeScrollOffset();
      return this.overScroller.computeScrollOffset();
    }

    public void fling(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      if (this.isPreGingerbread)
      {
        this.scroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
        return;
      }
      this.overScroller.fling(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
    }

    public void forceFinished(boolean paramBoolean)
    {
      if (this.isPreGingerbread)
      {
        this.scroller.forceFinished(paramBoolean);
        return;
      }
      this.overScroller.forceFinished(paramBoolean);
    }

    public int getCurrX()
    {
      if (this.isPreGingerbread)
        return this.scroller.getCurrX();
      return this.overScroller.getCurrX();
    }

    public int getCurrY()
    {
      if (this.isPreGingerbread)
        return this.scroller.getCurrY();
      return this.overScroller.getCurrY();
    }

    public boolean isFinished()
    {
      if (this.isPreGingerbread)
        return this.scroller.isFinished();
      return this.overScroller.isFinished();
    }
  }

  private class DoubleTapZoom
    implements Runnable
  {
    private static final float ZOOM_TIME = 500.0F;
    private float bitmapX;
    private float bitmapY;
    private PointF endTouch;
    private AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
    private long startTime;
    private PointF startTouch;
    private float startZoom;
    private boolean stretchImageToSuper;
    private float targetZoom;

    DoubleTapZoom(float paramFloat1, float paramFloat2, float paramBoolean, boolean arg5)
    {
      TouchImageView.this.setState(TouchImageView.State.ANIMATE_ZOOM);
      this.startTime = System.currentTimeMillis();
      this.startZoom = TouchImageView.this.normalizedScale;
      this.targetZoom = paramFloat1;
      boolean bool;
      this.stretchImageToSuper = bool;
      PointF localPointF = TouchImageView.this.transformCoordTouchToBitmap(paramFloat2, paramBoolean, false);
      this.bitmapX = localPointF.x;
      this.bitmapY = localPointF.y;
      this.startTouch = TouchImageView.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
      this.endTouch = new PointF(TouchImageView.this.viewWidth / 2, TouchImageView.this.viewHeight / 2);
    }

    private double calculateDeltaScale(float paramFloat)
    {
      return (this.startZoom + paramFloat * (this.targetZoom - this.startZoom)) / TouchImageView.this.normalizedScale;
    }

    private float interpolate()
    {
      float f = Math.min(1.0F, (float)(System.currentTimeMillis() - this.startTime) / 500.0F);
      return this.interpolator.getInterpolation(f);
    }

    private void translateImageToCenterTouchPosition(float paramFloat)
    {
      float f1 = this.startTouch.x + paramFloat * (this.endTouch.x - this.startTouch.x);
      float f2 = this.startTouch.y + paramFloat * (this.endTouch.y - this.startTouch.y);
      PointF localPointF = TouchImageView.this.transformCoordBitmapToTouch(this.bitmapX, this.bitmapY);
      TouchImageView.this.matrix.postTranslate(f1 - localPointF.x, f2 - localPointF.y);
    }

    public void run()
    {
      float f = interpolate();
      double d = calculateDeltaScale(f);
      TouchImageView.this.scaleImage(d, this.bitmapX, this.bitmapY, this.stretchImageToSuper);
      translateImageToCenterTouchPosition(f);
      TouchImageView.this.fixScaleTrans();
      TouchImageView.this.setImageMatrix(TouchImageView.this.matrix);
      if (TouchImageView.this.touchImageViewListener != null)
        TouchImageView.this.touchImageViewListener.onMove();
      if (f < 1.0F)
      {
        TouchImageView.this.compatPostOnAnimation(this);
        return;
      }
      TouchImageView.this.setState(TouchImageView.State.NONE);
    }
  }

  private class Fling
    implements Runnable
  {
    int currX;
    int currY;
    TouchImageView.CompatScroller scroller;

    Fling(int paramInt1, int arg3)
    {
      TouchImageView.this.setState(TouchImageView.State.FLING);
      this.scroller = new TouchImageView.CompatScroller(TouchImageView.this, TouchImageView.this.context);
      TouchImageView.this.matrix.getValues(TouchImageView.this.m);
      int j = (int)TouchImageView.this.m[2];
      int k = (int)TouchImageView.this.m[5];
      int n;
      int m;
      int i2;
      int i1;
      if (TouchImageView.this.getImageWidth() > TouchImageView.this.viewWidth)
      {
        n = TouchImageView.this.viewWidth - (int)TouchImageView.this.getImageWidth();
        m = 0;
        if (TouchImageView.this.getImageHeight() <= TouchImageView.this.viewHeight)
          break label162;
        i2 = TouchImageView.this.viewHeight - (int)TouchImageView.this.getImageHeight();
        i1 = 0;
      }
      while (true)
      {
        int i;
        this.scroller.fling(j, k, paramInt1, i, n, m, i2, i1);
        this.currX = j;
        this.currY = k;
        return;
        m = j;
        n = j;
        break;
        label162: i1 = k;
        i2 = k;
      }
    }

    public void cancelFling()
    {
      if (this.scroller != null)
      {
        TouchImageView.this.setState(TouchImageView.State.NONE);
        this.scroller.forceFinished(true);
      }
    }

    public void run()
    {
      if (TouchImageView.this.touchImageViewListener != null)
        TouchImageView.this.touchImageViewListener.onMove();
      if (this.scroller.isFinished())
        this.scroller = null;
      while (!this.scroller.computeScrollOffset())
        return;
      int i = this.scroller.getCurrX();
      int j = this.scroller.getCurrY();
      int k = i - this.currX;
      int m = j - this.currY;
      this.currX = i;
      this.currY = j;
      TouchImageView.this.matrix.postTranslate(k, m);
      TouchImageView.this.fixTrans();
      TouchImageView.this.setImageMatrix(TouchImageView.this.matrix);
      TouchImageView.this.compatPostOnAnimation(this);
    }
  }

  private class GestureListener extends GestureDetector.SimpleOnGestureListener
  {
    private GestureListener()
    {
    }

    public boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      GestureDetector.OnDoubleTapListener localOnDoubleTapListener = TouchImageView.this.doubleTapListener;
      boolean bool = false;
      if (localOnDoubleTapListener != null)
        bool = TouchImageView.this.doubleTapListener.onDoubleTap(paramMotionEvent);
      if (TouchImageView.this.state == TouchImageView.State.NONE)
        if (TouchImageView.this.normalizedScale != TouchImageView.this.minScale)
          break label105;
      label105: for (float f = TouchImageView.this.maxScale; ; f = TouchImageView.this.minScale)
      {
        TouchImageView.DoubleTapZoom localDoubleTapZoom = new TouchImageView.DoubleTapZoom(TouchImageView.this, f, paramMotionEvent.getX(), paramMotionEvent.getY(), false);
        TouchImageView.this.compatPostOnAnimation(localDoubleTapZoom);
        bool = true;
        return bool;
      }
    }

    public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.this.doubleTapListener != null)
        return TouchImageView.this.doubleTapListener.onDoubleTapEvent(paramMotionEvent);
      return false;
    }

    public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      if (TouchImageView.this.fling != null)
        TouchImageView.this.fling.cancelFling();
      TouchImageView.this.fling = new TouchImageView.Fling(TouchImageView.this, (int)paramFloat1, (int)paramFloat2);
      TouchImageView.this.compatPostOnAnimation(TouchImageView.this.fling);
      return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }

    public void onLongPress(MotionEvent paramMotionEvent)
    {
      TouchImageView.this.performLongClick();
    }

    public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
    {
      if (TouchImageView.this.doubleTapListener != null)
        return TouchImageView.this.doubleTapListener.onSingleTapConfirmed(paramMotionEvent);
      return TouchImageView.this.performClick();
    }
  }

  public static abstract interface OnTouchImageViewListener
  {
    public abstract void onMove();
  }

  private class PrivateOnTouchListener
    implements View.OnTouchListener
  {
    private PointF last = new PointF();

    private PrivateOnTouchListener()
    {
    }

    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      TouchImageView.this.mScaleDetector.onTouchEvent(paramMotionEvent);
      TouchImageView.this.mGestureDetector.onTouchEvent(paramMotionEvent);
      PointF localPointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((TouchImageView.this.state == TouchImageView.State.NONE) || (TouchImageView.this.state == TouchImageView.State.DRAG) || (TouchImageView.this.state == TouchImageView.State.FLING))
        switch (paramMotionEvent.getAction())
        {
        case 3:
        case 4:
        case 5:
        default:
        case 0:
        case 2:
        case 1:
        case 6:
        }
      while (true)
      {
        TouchImageView.this.setImageMatrix(TouchImageView.this.matrix);
        if (TouchImageView.this.userTouchListener != null)
          TouchImageView.this.userTouchListener.onTouch(paramView, paramMotionEvent);
        if (TouchImageView.this.touchImageViewListener != null)
          TouchImageView.this.touchImageViewListener.onMove();
        return true;
        this.last.set(localPointF);
        if (TouchImageView.this.fling != null)
          TouchImageView.this.fling.cancelFling();
        TouchImageView.this.setState(TouchImageView.State.DRAG);
        continue;
        if (TouchImageView.this.state == TouchImageView.State.DRAG)
        {
          float f1 = localPointF.x - this.last.x;
          float f2 = localPointF.y - this.last.y;
          float f3 = TouchImageView.this.getFixDragTrans(f1, TouchImageView.this.viewWidth, TouchImageView.access$12(TouchImageView.this));
          float f4 = TouchImageView.this.getFixDragTrans(f2, TouchImageView.this.viewHeight, TouchImageView.access$15(TouchImageView.this));
          TouchImageView.this.matrix.postTranslate(f3, f4);
          TouchImageView.this.fixTrans();
          this.last.set(localPointF.x, localPointF.y);
          continue;
          TouchImageView.this.setState(TouchImageView.State.NONE);
        }
      }
    }
  }

  private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener
  {
    private ScaleListener()
    {
    }

    public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.this.scaleImage(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getFocusX(), paramScaleGestureDetector.getFocusY(), true);
      if (TouchImageView.this.touchImageViewListener != null)
        TouchImageView.this.touchImageViewListener.onMove();
      return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
    {
      TouchImageView.this.setState(TouchImageView.State.ZOOM);
      return true;
    }

    public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
    {
      super.onScaleEnd(paramScaleGestureDetector);
      TouchImageView.this.setState(TouchImageView.State.NONE);
      float f = TouchImageView.this.normalizedScale;
      int i;
      if (TouchImageView.this.normalizedScale > TouchImageView.this.maxScale)
      {
        f = TouchImageView.this.maxScale;
        i = 1;
      }
      while (true)
      {
        if (i != 0)
        {
          TouchImageView.DoubleTapZoom localDoubleTapZoom = new TouchImageView.DoubleTapZoom(TouchImageView.this, f, TouchImageView.this.viewWidth / 2, TouchImageView.this.viewHeight / 2, true);
          TouchImageView.this.compatPostOnAnimation(localDoubleTapZoom);
        }
        return;
        boolean bool = TouchImageView.this.normalizedScale < TouchImageView.this.minScale;
        i = 0;
        if (bool)
        {
          f = TouchImageView.this.minScale;
          i = 1;
        }
      }
    }
  }

  private static enum State
  {
    static
    {
      DRAG = new State("DRAG", 1);
      ZOOM = new State("ZOOM", 2);
      FLING = new State("FLING", 3);
      ANIMATE_ZOOM = new State("ANIMATE_ZOOM", 4);
      State[] arrayOfState = new State[5];
      arrayOfState[0] = NONE;
      arrayOfState[1] = DRAG;
      arrayOfState[2] = ZOOM;
      arrayOfState[3] = FLING;
      arrayOfState[4] = ANIMATE_ZOOM;
    }
  }

  private class ZoomVariables
  {
    public float focusX;
    public float focusY;
    public float scale;
    public ImageView.ScaleType scaleType;

    public ZoomVariables(float paramFloat1, float paramFloat2, float paramScaleType, ImageView.ScaleType arg5)
    {
      this.scale = paramFloat1;
      this.focusX = paramFloat2;
      this.focusY = paramScaleType;
      Object localObject;
      this.scaleType = localObject;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.views.TouchImageView
 * JD-Core Version:    0.6.2
 */