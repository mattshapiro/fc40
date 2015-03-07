package com.actionbarsherlock.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.widget.CursorAdapter;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.actionbarsherlock.R.attr;
import com.actionbarsherlock.R.dimen;
import com.actionbarsherlock.R.id;
import com.actionbarsherlock.R.layout;
import com.actionbarsherlock.R.styleable;
import com.actionbarsherlock.view.CollapsibleActionView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayout
  implements CollapsibleActionView
{
  private static final boolean DBG = false;
  private static final String IME_OPTION_NO_MICROPHONE = "nm";
  private static final String LOG_TAG = "SearchView";
  private Bundle mAppSearchData;
  private boolean mClearingFocus;
  private ImageView mCloseButton;
  private int mCollapsedImeOptions;
  private View mDropDownAnchor;
  private boolean mExpandedInActionView;
  private boolean mIconified;
  private boolean mIconifiedByDefault;
  private int mMaxWidth;
  private CharSequence mOldQueryText;
  private final View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (paramAnonymousView == SearchView.this.mSearchButton)
        SearchView.this.onSearchClicked();
      do
      {
        return;
        if (paramAnonymousView == SearchView.this.mCloseButton)
        {
          SearchView.this.onCloseClicked();
          return;
        }
        if (paramAnonymousView == SearchView.this.mSubmitButton)
        {
          SearchView.this.onSubmitQuery();
          return;
        }
        if (paramAnonymousView == SearchView.this.mVoiceButton)
        {
          SearchView.this.onVoiceClicked();
          return;
        }
      }
      while (paramAnonymousView != SearchView.this.mQueryTextView);
      SearchView.this.forceSuggestionQuery();
    }
  };
  private OnCloseListener mOnCloseListener;
  private final TextView.OnEditorActionListener mOnEditorActionListener = new TextView.OnEditorActionListener()
  {
    public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      SearchView.this.onSubmitQuery();
      return true;
    }
  };
  private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.onItemClicked(paramAnonymousInt, 0, null);
    }
  };
  private final AdapterView.OnItemSelectedListener mOnItemSelectedListener = new AdapterView.OnItemSelectedListener()
  {
    public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      SearchView.this.onItemSelected(paramAnonymousInt);
    }

    public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
    {
    }
  };
  private OnQueryTextListener mOnQueryChangeListener;
  private View.OnFocusChangeListener mOnQueryTextFocusChangeListener;
  private View.OnClickListener mOnSearchClickListener;
  private OnSuggestionListener mOnSuggestionListener;
  private final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache = new WeakHashMap();
  private CharSequence mQueryHint;
  private boolean mQueryRefinement;
  private SearchAutoComplete mQueryTextView;
  private Runnable mReleaseCursorRunnable = new Runnable()
  {
    public void run()
    {
      if ((SearchView.this.mSuggestionsAdapter != null) && ((SearchView.this.mSuggestionsAdapter instanceof SuggestionsAdapter)))
        SearchView.this.mSuggestionsAdapter.changeCursor(null);
    }
  };
  private View mSearchButton;
  private View mSearchEditFrame;
  private ImageView mSearchHintIcon;
  private View mSearchPlate;
  private SearchableInfo mSearchable;
  private Runnable mShowImeRunnable = new Runnable()
  {
    public void run()
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)SearchView.this.getContext().getSystemService("input_method");
      if (localInputMethodManager != null)
        SearchView.showSoftInputUnchecked(SearchView.this, localInputMethodManager, 0);
    }
  };
  private View mSubmitArea;
  private View mSubmitButton;
  private boolean mSubmitButtonEnabled;
  private CursorAdapter mSuggestionsAdapter;
  View.OnKeyListener mTextKeyListener = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if (SearchView.this.mSearchable == null);
      do
      {
        return false;
        if ((SearchView.this.mQueryTextView.isPopupShowing()) && (SearchView.this.mQueryTextView.getListSelection() != -1))
          return SearchView.this.onSuggestionsKey(paramAnonymousView, paramAnonymousInt, paramAnonymousKeyEvent);
      }
      while ((SearchView.SearchAutoComplete.access$0(SearchView.this.mQueryTextView)) || (!KeyEventCompat.hasNoModifiers(paramAnonymousKeyEvent)));
      if ((paramAnonymousKeyEvent.getAction() == 1) && (paramAnonymousInt == 66))
      {
        paramAnonymousView.cancelLongPress();
        SearchView.this.launchQuerySearch(0, null, SearchView.this.mQueryTextView.getText().toString());
        return true;
      }
      paramAnonymousKeyEvent.getAction();
      return false;
    }
  };
  private TextWatcher mTextWatcher = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      SearchView.this.onTextChanged(paramAnonymousCharSequence);
    }
  };
  private Runnable mUpdateDrawableStateRunnable = new Runnable()
  {
    public void run()
    {
      SearchView.this.updateFocusedState();
    }
  };
  private CharSequence mUserQuery;
  private final Intent mVoiceAppSearchIntent;
  private View mVoiceButton;
  private boolean mVoiceButtonEnabled;
  private final Intent mVoiceWebSearchIntent;

  public SearchView(Context paramContext)
  {
    this(paramContext, null);
  }

  public SearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (Build.VERSION.SDK_INT < 8)
      throw new IllegalStateException("SearchView is API 8+ only.");
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.abs__search_view, this, true);
    this.mSearchButton = findViewById(R.id.abs__search_button);
    this.mQueryTextView = ((SearchAutoComplete)findViewById(R.id.abs__search_src_text));
    this.mQueryTextView.setSearchView(this);
    this.mSearchEditFrame = findViewById(R.id.abs__search_edit_frame);
    this.mSearchPlate = findViewById(R.id.abs__search_plate);
    this.mSubmitArea = findViewById(R.id.abs__submit_area);
    this.mSubmitButton = findViewById(R.id.abs__search_go_btn);
    this.mCloseButton = ((ImageView)findViewById(R.id.abs__search_close_btn));
    this.mVoiceButton = findViewById(R.id.abs__search_voice_btn);
    this.mSearchHintIcon = ((ImageView)findViewById(R.id.abs__search_mag_icon));
    this.mSearchButton.setOnClickListener(this.mOnClickListener);
    this.mCloseButton.setOnClickListener(this.mOnClickListener);
    this.mSubmitButton.setOnClickListener(this.mOnClickListener);
    this.mVoiceButton.setOnClickListener(this.mOnClickListener);
    this.mQueryTextView.setOnClickListener(this.mOnClickListener);
    this.mQueryTextView.addTextChangedListener(this.mTextWatcher);
    this.mQueryTextView.setOnEditorActionListener(this.mOnEditorActionListener);
    this.mQueryTextView.setOnItemClickListener(this.mOnItemClickListener);
    this.mQueryTextView.setOnItemSelectedListener(this.mOnItemSelectedListener);
    this.mQueryTextView.setOnKeyListener(this.mTextKeyListener);
    this.mQueryTextView.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (SearchView.this.mOnQueryTextFocusChangeListener != null)
          SearchView.this.mOnQueryTextFocusChangeListener.onFocusChange(SearchView.this, paramAnonymousBoolean);
      }
    });
    TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockSearchView, 0, 0);
    setIconifiedByDefault(localTypedArray1.getBoolean(3, true));
    int i = localTypedArray1.getDimensionPixelSize(0, -1);
    if (i != -1)
      setMaxWidth(i);
    CharSequence localCharSequence = localTypedArray1.getText(4);
    if (!TextUtils.isEmpty(localCharSequence))
      setQueryHint(localCharSequence);
    int j = localTypedArray1.getInt(2, -1);
    if (j != -1)
      setImeOptions(j);
    int k = localTypedArray1.getInt(1, -1);
    if (k != -1)
      setInputType(k);
    localTypedArray1.recycle();
    TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SherlockView, 0, 0);
    boolean bool = localTypedArray2.getBoolean(0, true);
    localTypedArray2.recycle();
    setFocusable(bool);
    this.mVoiceWebSearchIntent = new Intent("android.speech.action.WEB_SEARCH");
    this.mVoiceWebSearchIntent.addFlags(268435456);
    this.mVoiceWebSearchIntent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
    this.mVoiceAppSearchIntent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
    this.mVoiceAppSearchIntent.addFlags(268435456);
    this.mDropDownAnchor = findViewById(this.mQueryTextView.getDropDownAnchor());
    if (this.mDropDownAnchor != null)
    {
      if (Build.VERSION.SDK_INT < 11)
        break label669;
      this.mDropDownAnchor.addOnLayoutChangeListener(new View.OnLayoutChangeListener()
      {
        public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
        {
          SearchView.this.adjustDropDownSizeAndPosition();
        }
      });
    }
    while (true)
    {
      updateViewsVisibility(this.mIconifiedByDefault);
      updateQueryHint();
      return;
      label669: this.mDropDownAnchor.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          SearchView.this.adjustDropDownSizeAndPosition();
        }
      });
    }
  }

  private void adjustDropDownSizeAndPosition()
  {
    Resources localResources;
    int i;
    Rect localRect;
    if (this.mDropDownAnchor.getWidth() > 1)
    {
      localResources = getContext().getResources();
      i = this.mSearchPlate.getPaddingLeft();
      localRect = new Rect();
      if (!this.mIconifiedByDefault)
        break label118;
    }
    label118: for (int j = localResources.getDimensionPixelSize(R.dimen.abs__dropdownitem_icon_width) + localResources.getDimensionPixelSize(R.dimen.abs__dropdownitem_text_padding_left); ; j = 0)
    {
      this.mQueryTextView.getDropDownBackground().getPadding(localRect);
      this.mQueryTextView.setDropDownHorizontalOffset(i + -(j + localRect.left));
      this.mQueryTextView.setDropDownWidth(j + (this.mDropDownAnchor.getWidth() + localRect.left + localRect.right) - i);
      return;
    }
  }

  private Intent createIntent(String paramString1, Uri paramUri, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    Intent localIntent = new Intent(paramString1);
    localIntent.addFlags(268435456);
    if (paramUri != null)
      localIntent.setData(paramUri);
    localIntent.putExtra("user_query", this.mUserQuery);
    if (paramString3 != null)
      localIntent.putExtra("query", paramString3);
    if (paramString2 != null)
      localIntent.putExtra("intent_extra_data_key", paramString2);
    if (this.mAppSearchData != null)
      localIntent.putExtra("app_data", this.mAppSearchData);
    if (paramInt != 0)
    {
      localIntent.putExtra("action_key", paramInt);
      localIntent.putExtra("action_msg", paramString4);
    }
    localIntent.setComponent(this.mSearchable.getSearchActivity());
    return localIntent;
  }

  private Intent createIntentFromSuggestion(Cursor paramCursor, int paramInt, String paramString)
  {
    try
    {
      str1 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_action");
      if (str1 == null)
      {
        str1 = this.mSearchable.getSuggestIntentAction();
        break label201;
        str2 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data");
        if (str2 == null)
          str2 = this.mSearchable.getSuggestIntentData();
        if (str2 == null)
          break label214;
        String str3 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_data_id");
        if (str3 == null)
          break label214;
        str2 = str2 + "/" + Uri.encode(str3);
        break label214;
        while (true)
        {
          String str4 = SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_query");
          return createIntent(str1, (Uri)localObject, SuggestionsAdapter.getColumnString(paramCursor, "suggest_intent_extra_data"), str4, paramInt, paramString);
          Uri localUri = Uri.parse(str2);
          localObject = localUri;
        }
      }
    }
    catch (RuntimeException localRuntimeException1)
    {
      while (true)
      {
        String str1;
        String str2;
        Object localObject;
        try
        {
          int j = paramCursor.getPosition();
          i = j;
          Log.w("SearchView", "Search suggestions cursor at row " + i + " returned exception.", localRuntimeException1);
          return null;
        }
        catch (RuntimeException localRuntimeException2)
        {
          int i = -1;
          continue;
        }
        label201: if (str1 == null)
        {
          str1 = "android.intent.action.SEARCH";
          continue;
          label214: if (str2 == null)
            localObject = null;
        }
      }
    }
  }

  private Intent createVoiceAppSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    Intent localIntent1 = new Intent("android.intent.action.SEARCH");
    localIntent1.setComponent(localComponentName);
    PendingIntent localPendingIntent = PendingIntent.getActivity(getContext(), 0, localIntent1, 1073741824);
    Bundle localBundle = new Bundle();
    Intent localIntent2 = new Intent(paramIntent);
    String str1 = "free_form";
    int i = 1;
    Resources localResources = getResources();
    if (paramSearchableInfo.getVoiceLanguageModeId() != 0)
      str1 = localResources.getString(paramSearchableInfo.getVoiceLanguageModeId());
    int j = paramSearchableInfo.getVoicePromptTextId();
    String str2 = null;
    if (j != 0)
      str2 = localResources.getString(paramSearchableInfo.getVoicePromptTextId());
    int k = paramSearchableInfo.getVoiceLanguageId();
    String str3 = null;
    if (k != 0)
      str3 = localResources.getString(paramSearchableInfo.getVoiceLanguageId());
    if (paramSearchableInfo.getVoiceMaxResults() != 0)
      i = paramSearchableInfo.getVoiceMaxResults();
    localIntent2.putExtra("android.speech.extra.LANGUAGE_MODEL", str1);
    localIntent2.putExtra("android.speech.extra.PROMPT", str2);
    localIntent2.putExtra("android.speech.extra.LANGUAGE", str3);
    localIntent2.putExtra("android.speech.extra.MAX_RESULTS", i);
    if (localComponentName == null);
    for (String str4 = null; ; str4 = localComponentName.flattenToShortString())
    {
      localIntent2.putExtra("calling_package", str4);
      localIntent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", localPendingIntent);
      localIntent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", localBundle);
      return localIntent2;
    }
  }

  private Intent createVoiceWebSearchIntent(Intent paramIntent, SearchableInfo paramSearchableInfo)
  {
    Intent localIntent = new Intent(paramIntent);
    ComponentName localComponentName = paramSearchableInfo.getSearchActivity();
    if (localComponentName == null);
    for (String str = null; ; str = localComponentName.flattenToShortString())
    {
      localIntent.putExtra("calling_package", str);
      return localIntent;
    }
  }

  private void dismissSuggestions()
  {
    this.mQueryTextView.dismissDropDown();
  }

  private static void ensureImeVisible(AutoCompleteTextView paramAutoCompleteTextView, boolean paramBoolean)
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      Method localMethod = AutoCompleteTextView.class.getMethod("ensureImeVisible", arrayOfClass);
      localMethod.setAccessible(true);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(paramAutoCompleteTextView, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private void forceSuggestionQuery()
  {
    try
    {
      Method localMethod1 = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      Method localMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
      localMethod1.setAccessible(true);
      localMethod2.setAccessible(true);
      localMethod1.invoke(this.mQueryTextView, new Object[0]);
      localMethod2.invoke(this.mQueryTextView, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private CharSequence getDecoratedHint(CharSequence paramCharSequence)
  {
    if (!this.mIconifiedByDefault)
      return paramCharSequence;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder("   ");
    localSpannableStringBuilder.append(paramCharSequence);
    Drawable localDrawable = getContext().getResources().getDrawable(getSearchIconId());
    int i = (int)(1.25D * this.mQueryTextView.getTextSize());
    localDrawable.setBounds(0, 0, i, i);
    localSpannableStringBuilder.setSpan(new ImageSpan(localDrawable), 1, 2, 33);
    return localSpannableStringBuilder;
  }

  private int getPreferredWidth()
  {
    return getContext().getResources().getDimensionPixelSize(R.dimen.abs__search_view_preferred_width);
  }

  private int getSearchIconId()
  {
    TypedValue localTypedValue = new TypedValue();
    getContext().getTheme().resolveAttribute(R.attr.searchViewSearchIcon, localTypedValue, true);
    return localTypedValue.resourceId;
  }

  private boolean hasVoiceSearch()
  {
    SearchableInfo localSearchableInfo = this.mSearchable;
    boolean bool1 = false;
    Intent localIntent;
    if (localSearchableInfo != null)
    {
      boolean bool2 = this.mSearchable.getVoiceSearchEnabled();
      bool1 = false;
      if (bool2)
      {
        if (!this.mSearchable.getVoiceSearchLaunchWebSearch())
          break label76;
        localIntent = this.mVoiceWebSearchIntent;
      }
    }
    while (true)
    {
      bool1 = false;
      if (localIntent != null)
      {
        ResolveInfo localResolveInfo = getContext().getPackageManager().resolveActivity(localIntent, 65536);
        bool1 = false;
        if (localResolveInfo != null)
          bool1 = true;
      }
      return bool1;
      label76: boolean bool3 = this.mSearchable.getVoiceSearchLaunchRecognizer();
      localIntent = null;
      if (bool3)
        localIntent = this.mVoiceAppSearchIntent;
    }
  }

  static boolean isLandscapeMode(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().orientation == 2;
  }

  private boolean isSubmitAreaEnabled()
  {
    return ((this.mSubmitButtonEnabled) || (this.mVoiceButtonEnabled)) && (!isIconified());
  }

  private void launchIntent(Intent paramIntent)
  {
    if (paramIntent == null)
      return;
    try
    {
      getContext().startActivity(paramIntent);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.e("SearchView", "Failed launch activity: " + paramIntent, localRuntimeException);
    }
  }

  private void launchQuerySearch(int paramInt, String paramString1, String paramString2)
  {
    Intent localIntent = createIntent("android.intent.action.SEARCH", null, null, paramString2, paramInt, paramString1);
    getContext().startActivity(localIntent);
  }

  private boolean launchSuggestion(int paramInt1, int paramInt2, String paramString)
  {
    Cursor localCursor = this.mSuggestionsAdapter.getCursor();
    if ((localCursor != null) && (localCursor.moveToPosition(paramInt1)))
    {
      launchIntent(createIntentFromSuggestion(localCursor, paramInt2, paramString));
      return true;
    }
    return false;
  }

  private void onCloseClicked()
  {
    if (TextUtils.isEmpty(this.mQueryTextView.getText()))
    {
      if ((this.mIconifiedByDefault) && ((this.mOnCloseListener == null) || (!this.mOnCloseListener.onClose())))
      {
        clearFocus();
        updateViewsVisibility(true);
      }
      return;
    }
    this.mQueryTextView.setText("");
    this.mQueryTextView.requestFocus();
    setImeVisibility(true);
  }

  private boolean onItemClicked(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool1;
    if (this.mOnSuggestionListener != null)
    {
      boolean bool2 = this.mOnSuggestionListener.onSuggestionClick(paramInt1);
      bool1 = false;
      if (bool2);
    }
    else
    {
      launchSuggestion(paramInt1, 0, null);
      setImeVisibility(false);
      dismissSuggestions();
      bool1 = true;
    }
    return bool1;
  }

  private boolean onItemSelected(int paramInt)
  {
    if ((this.mOnSuggestionListener == null) || (!this.mOnSuggestionListener.onSuggestionSelect(paramInt)))
    {
      rewriteQueryFromSuggestion(paramInt);
      return true;
    }
    return false;
  }

  private void onSearchClicked()
  {
    updateViewsVisibility(false);
    this.mQueryTextView.requestFocus();
    setImeVisibility(true);
    if (this.mOnSearchClickListener != null)
      this.mOnSearchClickListener.onClick(this);
  }

  private void onSubmitQuery()
  {
    Editable localEditable = this.mQueryTextView.getText();
    if ((localEditable != null) && (TextUtils.getTrimmedLength(localEditable) > 0) && ((this.mOnQueryChangeListener == null) || (!this.mOnQueryChangeListener.onQueryTextSubmit(localEditable.toString()))))
    {
      if (this.mSearchable != null)
      {
        launchQuerySearch(0, null, localEditable.toString());
        setImeVisibility(false);
      }
      dismissSuggestions();
    }
  }

  private boolean onSuggestionsKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mSearchable == null);
    do
    {
      do
        return false;
      while ((this.mSuggestionsAdapter == null) || (paramKeyEvent.getAction() != 0) || (!KeyEventCompat.hasNoModifiers(paramKeyEvent)));
      if ((paramInt == 66) || (paramInt == 84) || (paramInt == 61))
        return onItemClicked(this.mQueryTextView.getListSelection(), 0, null);
      if ((paramInt == 21) || (paramInt == 22))
      {
        if (paramInt == 21);
        for (int i = 0; ; i = this.mQueryTextView.length())
        {
          this.mQueryTextView.setSelection(i);
          this.mQueryTextView.setListSelection(0);
          this.mQueryTextView.clearListSelection();
          ensureImeVisible(this.mQueryTextView, true);
          return true;
        }
      }
    }
    while ((paramInt != 19) || (this.mQueryTextView.getListSelection() != 0));
    return false;
  }

  private void onTextChanged(CharSequence paramCharSequence)
  {
    Editable localEditable = this.mQueryTextView.getText();
    this.mUserQuery = localEditable;
    boolean bool1;
    boolean bool2;
    if (TextUtils.isEmpty(localEditable))
    {
      bool1 = false;
      updateSubmitButton(bool1);
      bool2 = false;
      if (!bool1)
        break label98;
    }
    while (true)
    {
      updateVoiceButton(bool2);
      updateCloseButton();
      updateSubmitArea();
      if ((this.mOnQueryChangeListener != null) && (!TextUtils.equals(paramCharSequence, this.mOldQueryText)))
        this.mOnQueryChangeListener.onQueryTextChange(paramCharSequence.toString());
      this.mOldQueryText = paramCharSequence.toString();
      return;
      bool1 = true;
      break;
      label98: bool2 = true;
    }
  }

  private void onVoiceClicked()
  {
    if (this.mSearchable == null);
    SearchableInfo localSearchableInfo;
    do
    {
      return;
      localSearchableInfo = this.mSearchable;
      try
      {
        if (localSearchableInfo.getVoiceSearchLaunchWebSearch())
        {
          Intent localIntent2 = createVoiceWebSearchIntent(this.mVoiceWebSearchIntent, localSearchableInfo);
          getContext().startActivity(localIntent2);
          return;
        }
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        Log.w("SearchView", "Could not find voice search activity");
        return;
      }
    }
    while (!localSearchableInfo.getVoiceSearchLaunchRecognizer());
    Intent localIntent1 = createVoiceAppSearchIntent(this.mVoiceAppSearchIntent, localSearchableInfo);
    getContext().startActivity(localIntent1);
  }

  private void postUpdateFocusedState()
  {
    post(this.mUpdateDrawableStateRunnable);
  }

  private void rewriteQueryFromSuggestion(int paramInt)
  {
    Editable localEditable = this.mQueryTextView.getText();
    Cursor localCursor = this.mSuggestionsAdapter.getCursor();
    if (localCursor == null)
      return;
    if (localCursor.moveToPosition(paramInt))
    {
      CharSequence localCharSequence = this.mSuggestionsAdapter.convertToString(localCursor);
      if (localCharSequence != null)
      {
        setQuery(localCharSequence);
        return;
      }
      setQuery(localEditable);
      return;
    }
    setQuery(localEditable);
  }

  private void setImeVisibility(boolean paramBoolean)
  {
    if (paramBoolean)
      post(this.mShowImeRunnable);
    InputMethodManager localInputMethodManager;
    do
    {
      return;
      removeCallbacks(this.mShowImeRunnable);
      localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    }
    while (localInputMethodManager == null);
    localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }

  private void setQuery(CharSequence paramCharSequence)
  {
    setText(this.mQueryTextView, paramCharSequence, true);
    SearchAutoComplete localSearchAutoComplete = this.mQueryTextView;
    if (TextUtils.isEmpty(paramCharSequence));
    for (int i = 0; ; i = paramCharSequence.length())
    {
      localSearchAutoComplete.setSelection(i);
      return;
    }
  }

  private static void setText(AutoCompleteTextView paramAutoCompleteTextView, CharSequence paramCharSequence, boolean paramBoolean)
  {
    try
    {
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = CharSequence.class;
      arrayOfClass[1] = Boolean.TYPE;
      Method localMethod = AutoCompleteTextView.class.getMethod("setText", arrayOfClass);
      localMethod.setAccessible(true);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramCharSequence;
      arrayOfObject[1] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(paramAutoCompleteTextView, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      paramAutoCompleteTextView.setText(paramCharSequence);
    }
  }

  private static void showSoftInputUnchecked(View paramView, InputMethodManager paramInputMethodManager, int paramInt)
  {
    try
    {
      Class localClass = paramInputMethodManager.getClass();
      Class[] arrayOfClass = new Class[2];
      arrayOfClass[0] = Integer.TYPE;
      arrayOfClass[1] = ResultReceiver.class;
      Method localMethod = localClass.getMethod("showSoftInputUnchecked", arrayOfClass);
      localMethod.setAccessible(true);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      arrayOfObject[1] = null;
      localMethod.invoke(paramInputMethodManager, arrayOfObject);
      return;
    }
    catch (Exception localException)
    {
      paramInputMethodManager.showSoftInput(paramView, paramInt);
    }
  }

  private void updateCloseButton()
  {
    int i = 1;
    int j;
    int k;
    label49: Drawable localDrawable;
    if (TextUtils.isEmpty(this.mQueryTextView.getText()))
    {
      j = 0;
      if ((j == 0) && ((!this.mIconifiedByDefault) || (this.mExpandedInActionView)))
        i = 0;
      ImageView localImageView = this.mCloseButton;
      k = 0;
      if (i == 0)
        break label87;
      localImageView.setVisibility(k);
      localDrawable = this.mCloseButton.getDrawable();
      if (j == 0)
        break label94;
    }
    label87: label94: for (int[] arrayOfInt = ENABLED_STATE_SET; ; arrayOfInt = EMPTY_STATE_SET)
    {
      localDrawable.setState(arrayOfInt);
      return;
      j = i;
      break;
      k = 8;
      break label49;
    }
  }

  private void updateFocusedState()
  {
    boolean bool = this.mQueryTextView.hasFocus();
    Drawable localDrawable1 = this.mSearchPlate.getBackground();
    int[] arrayOfInt1;
    Drawable localDrawable2;
    if (bool)
    {
      arrayOfInt1 = FOCUSED_STATE_SET;
      localDrawable1.setState(arrayOfInt1);
      localDrawable2 = this.mSubmitArea.getBackground();
      if (!bool)
        break label68;
    }
    label68: for (int[] arrayOfInt2 = FOCUSED_STATE_SET; ; arrayOfInt2 = EMPTY_STATE_SET)
    {
      localDrawable2.setState(arrayOfInt2);
      invalidate();
      return;
      arrayOfInt1 = EMPTY_STATE_SET;
      break;
    }
  }

  private void updateQueryHint()
  {
    if (this.mQueryHint != null)
      this.mQueryTextView.setHint(getDecoratedHint(this.mQueryHint));
    String str;
    do
    {
      return;
      if (this.mSearchable == null)
        break;
      int i = this.mSearchable.getHintId();
      str = null;
      if (i != 0)
        str = getContext().getString(i);
    }
    while (str == null);
    this.mQueryTextView.setHint(getDecoratedHint(str));
    return;
    this.mQueryTextView.setHint(getDecoratedHint(""));
  }

  private void updateSearchAutoComplete()
  {
    int i = 1;
    this.mQueryTextView.setThreshold(this.mSearchable.getSuggestThreshold());
    this.mQueryTextView.setImeOptions(this.mSearchable.getImeOptions());
    int j = this.mSearchable.getInputType();
    if ((j & 0xF) == i)
    {
      j &= -65537;
      if (this.mSearchable.getSuggestAuthority() != null)
        j = 0x80000 | (j | 0x10000);
    }
    this.mQueryTextView.setInputType(j);
    if (this.mSuggestionsAdapter != null)
      this.mSuggestionsAdapter.changeCursor(null);
    if (this.mSearchable.getSuggestAuthority() != null)
    {
      this.mSuggestionsAdapter = new SuggestionsAdapter(getContext(), this, this.mSearchable, this.mOutsideDrawablesCache);
      this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
      SuggestionsAdapter localSuggestionsAdapter = (SuggestionsAdapter)this.mSuggestionsAdapter;
      if (this.mQueryRefinement)
        i = 2;
      localSuggestionsAdapter.setQueryRefinement(i);
    }
  }

  private void updateSubmitArea()
  {
    int i = 8;
    if ((isSubmitAreaEnabled()) && ((this.mSubmitButton.getVisibility() == 0) || (this.mVoiceButton.getVisibility() == 0)))
      i = 0;
    this.mSubmitArea.setVisibility(i);
  }

  private void updateSubmitButton(boolean paramBoolean)
  {
    int i = 8;
    if ((this.mSubmitButtonEnabled) && (isSubmitAreaEnabled()) && (hasFocus()) && ((paramBoolean) || (!this.mVoiceButtonEnabled)))
      i = 0;
    this.mSubmitButton.setVisibility(i);
  }

  private void updateViewsVisibility(boolean paramBoolean)
  {
    int i = 8;
    this.mIconified = paramBoolean;
    int j;
    boolean bool1;
    label30: int k;
    label57: label77: boolean bool2;
    if (paramBoolean)
    {
      j = 0;
      if (!TextUtils.isEmpty(this.mQueryTextView.getText()))
        break label111;
      bool1 = false;
      this.mSearchButton.setVisibility(j);
      updateSubmitButton(bool1);
      View localView = this.mSearchEditFrame;
      if (!paramBoolean)
        break label117;
      k = i;
      localView.setVisibility(k);
      ImageView localImageView = this.mSearchHintIcon;
      if (!this.mIconifiedByDefault)
        break label123;
      localImageView.setVisibility(i);
      updateCloseButton();
      bool2 = false;
      if (!bool1)
        break label128;
    }
    while (true)
    {
      updateVoiceButton(bool2);
      updateSubmitArea();
      return;
      j = i;
      break;
      label111: bool1 = true;
      break label30;
      label117: k = 0;
      break label57;
      label123: i = 0;
      break label77;
      label128: bool2 = true;
    }
  }

  private void updateVoiceButton(boolean paramBoolean)
  {
    int i = 8;
    if ((this.mVoiceButtonEnabled) && (!isIconified()) && (paramBoolean))
    {
      i = 0;
      this.mSubmitButton.setVisibility(8);
    }
    this.mVoiceButton.setVisibility(i);
  }

  public void clearFocus()
  {
    this.mClearingFocus = true;
    setImeVisibility(false);
    super.clearFocus();
    this.mQueryTextView.clearFocus();
    this.mClearingFocus = false;
  }

  public int getImeOptions()
  {
    return this.mQueryTextView.getImeOptions();
  }

  public int getInputType()
  {
    return this.mQueryTextView.getInputType();
  }

  public int getMaxWidth()
  {
    return this.mMaxWidth;
  }

  public CharSequence getQuery()
  {
    return this.mQueryTextView.getText();
  }

  public CharSequence getQueryHint()
  {
    CharSequence localCharSequence;
    if (this.mQueryHint != null)
      localCharSequence = this.mQueryHint;
    int i;
    do
    {
      return localCharSequence;
      if (this.mSearchable == null)
        break;
      i = this.mSearchable.getHintId();
      localCharSequence = null;
    }
    while (i == 0);
    return getContext().getString(i);
    return null;
  }

  public CursorAdapter getSuggestionsAdapter()
  {
    return this.mSuggestionsAdapter;
  }

  public boolean isIconfiedByDefault()
  {
    return this.mIconifiedByDefault;
  }

  public boolean isIconified()
  {
    return this.mIconified;
  }

  public boolean isQueryRefinementEnabled()
  {
    return this.mQueryRefinement;
  }

  public boolean isSubmitButtonEnabled()
  {
    return this.mSubmitButtonEnabled;
  }

  public void onActionViewCollapsed()
  {
    clearFocus();
    updateViewsVisibility(true);
    this.mQueryTextView.setImeOptions(this.mCollapsedImeOptions);
    this.mExpandedInActionView = false;
  }

  public void onActionViewExpanded()
  {
    if (this.mExpandedInActionView)
      return;
    this.mExpandedInActionView = true;
    this.mCollapsedImeOptions = this.mQueryTextView.getImeOptions();
    this.mQueryTextView.setImeOptions(0x2000000 | this.mCollapsedImeOptions);
    this.mQueryTextView.setText("");
    setIconified(false);
  }

  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.mUpdateDrawableStateRunnable);
    post(this.mReleaseCursorRunnable);
    super.onDetachedFromWindow();
  }

  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(SearchView.class.getName());
  }

  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(SearchView.class.getName());
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mSearchable == null)
      return false;
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (isIconified())
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    switch (i)
    {
    default:
    case -2147483648:
    case 1073741824:
      while (true)
      {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(j, 1073741824), paramInt2);
        return;
        if (this.mMaxWidth > 0)
        {
          j = Math.min(this.mMaxWidth, j);
        }
        else
        {
          j = Math.min(getPreferredWidth(), j);
          continue;
          if (this.mMaxWidth > 0)
            j = Math.min(this.mMaxWidth, j);
        }
      }
    case 0:
    }
    if (this.mMaxWidth > 0);
    for (j = this.mMaxWidth; ; j = getPreferredWidth())
      break;
  }

  void onQueryRefine(CharSequence paramCharSequence)
  {
    setQuery(paramCharSequence);
  }

  void onTextFocusChanged()
  {
    updateViewsVisibility(isIconified());
    postUpdateFocusedState();
    if (this.mQueryTextView.hasFocus())
      forceSuggestionQuery();
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    postUpdateFocusedState();
  }

  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    boolean bool;
    if (this.mClearingFocus)
      bool = false;
    do
    {
      return bool;
      if (!isFocusable())
        return false;
      if (isIconified())
        break;
      bool = this.mQueryTextView.requestFocus(paramInt, paramRect);
    }
    while (!bool);
    updateViewsVisibility(false);
    return bool;
    return super.requestFocus(paramInt, paramRect);
  }

  public void setAppSearchData(Bundle paramBundle)
  {
    this.mAppSearchData = paramBundle;
  }

  public void setIconified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onCloseClicked();
      return;
    }
    onSearchClicked();
  }

  public void setIconifiedByDefault(boolean paramBoolean)
  {
    if (this.mIconifiedByDefault == paramBoolean)
      return;
    this.mIconifiedByDefault = paramBoolean;
    updateViewsVisibility(paramBoolean);
    updateQueryHint();
  }

  public void setImeOptions(int paramInt)
  {
    this.mQueryTextView.setImeOptions(paramInt);
  }

  public void setInputType(int paramInt)
  {
    this.mQueryTextView.setInputType(paramInt);
  }

  public void setMaxWidth(int paramInt)
  {
    this.mMaxWidth = paramInt;
    requestLayout();
  }

  public void setOnCloseListener(OnCloseListener paramOnCloseListener)
  {
    this.mOnCloseListener = paramOnCloseListener;
  }

  public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.mOnQueryTextFocusChangeListener = paramOnFocusChangeListener;
  }

  public void setOnQueryTextListener(OnQueryTextListener paramOnQueryTextListener)
  {
    this.mOnQueryChangeListener = paramOnQueryTextListener;
  }

  public void setOnSearchClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mOnSearchClickListener = paramOnClickListener;
  }

  public void setOnSuggestionListener(OnSuggestionListener paramOnSuggestionListener)
  {
    this.mOnSuggestionListener = paramOnSuggestionListener;
  }

  public void setQuery(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.mQueryTextView.setText(paramCharSequence);
    if (paramCharSequence != null)
    {
      this.mQueryTextView.setSelection(this.mQueryTextView.length());
      this.mUserQuery = paramCharSequence;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramCharSequence)))
      onSubmitQuery();
  }

  public void setQueryHint(CharSequence paramCharSequence)
  {
    this.mQueryHint = paramCharSequence;
    updateQueryHint();
  }

  public void setQueryRefinementEnabled(boolean paramBoolean)
  {
    this.mQueryRefinement = paramBoolean;
    SuggestionsAdapter localSuggestionsAdapter;
    if ((this.mSuggestionsAdapter instanceof SuggestionsAdapter))
    {
      localSuggestionsAdapter = (SuggestionsAdapter)this.mSuggestionsAdapter;
      if (!paramBoolean)
        break label35;
    }
    label35: for (int i = 2; ; i = 1)
    {
      localSuggestionsAdapter.setQueryRefinement(i);
      return;
    }
  }

  public void setSearchableInfo(SearchableInfo paramSearchableInfo)
  {
    this.mSearchable = paramSearchableInfo;
    if (this.mSearchable != null)
    {
      updateSearchAutoComplete();
      updateQueryHint();
    }
    this.mVoiceButtonEnabled = hasVoiceSearch();
    if (this.mVoiceButtonEnabled)
      this.mQueryTextView.setPrivateImeOptions("nm");
    updateViewsVisibility(isIconified());
  }

  public void setSubmitButtonEnabled(boolean paramBoolean)
  {
    this.mSubmitButtonEnabled = paramBoolean;
    updateViewsVisibility(isIconified());
  }

  public void setSuggestionsAdapter(CursorAdapter paramCursorAdapter)
  {
    this.mSuggestionsAdapter = paramCursorAdapter;
    this.mQueryTextView.setAdapter(this.mSuggestionsAdapter);
  }

  public static abstract interface OnCloseListener
  {
    public abstract boolean onClose();
  }

  public static abstract interface OnQueryTextListener
  {
    public abstract boolean onQueryTextChange(String paramString);

    public abstract boolean onQueryTextSubmit(String paramString);
  }

  public static abstract interface OnSuggestionListener
  {
    public abstract boolean onSuggestionClick(int paramInt);

    public abstract boolean onSuggestionSelect(int paramInt);
  }

  public static class SearchAutoComplete extends AutoCompleteTextView
  {
    private SearchView mSearchView;
    private int mThreshold = getThreshold();

    public SearchAutoComplete(Context paramContext)
    {
      super();
    }

    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }

    public SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }

    private boolean isEmpty()
    {
      return TextUtils.getTrimmedLength(getText()) == 0;
    }

    public boolean enoughToFilter()
    {
      return (this.mThreshold <= 0) || (super.enoughToFilter());
    }

    protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
    {
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.mSearchView.onTextFocusChanged();
    }

    public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
    {
      if (paramInt == 4)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          KeyEvent.DispatcherState localDispatcherState2 = getKeyDispatcherState();
          if (localDispatcherState2 != null)
            localDispatcherState2.startTracking(paramKeyEvent, this);
          return true;
        }
        if (paramKeyEvent.getAction() == 1)
        {
          KeyEvent.DispatcherState localDispatcherState1 = getKeyDispatcherState();
          if (localDispatcherState1 != null)
            localDispatcherState1.handleUpEvent(paramKeyEvent);
          if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
          {
            this.mSearchView.clearFocus();
            this.mSearchView.setImeVisibility(false);
            return true;
          }
        }
      }
      return super.onKeyPreIme(paramInt, paramKeyEvent);
    }

    public void onWindowFocusChanged(boolean paramBoolean)
    {
      super.onWindowFocusChanged(paramBoolean);
      if ((paramBoolean) && (this.mSearchView.hasFocus()) && (getVisibility() == 0))
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(this, 0);
        if (SearchView.isLandscapeMode(getContext()))
          SearchView.ensureImeVisible(this, true);
      }
    }

    public void performCompletion()
    {
    }

    protected void replaceText(CharSequence paramCharSequence)
    {
    }

    void setSearchView(SearchView paramSearchView)
    {
      this.mSearchView = paramSearchView;
    }

    public void setThreshold(int paramInt)
    {
      super.setThreshold(paramInt);
      this.mThreshold = paramInt;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.widget.SearchView
 * JD-Core Version:    0.6.2
 */