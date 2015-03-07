package com.actionbarsherlock.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.Handler;
import android.text.TextUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class ActivityChooserModel extends DataSetObservable
{
  private static final String ATTRIBUTE_ACTIVITY = "activity";
  private static final String ATTRIBUTE_TIME = "time";
  private static final String ATTRIBUTE_WEIGHT = "weight";
  private static final boolean DEBUG = false;
  private static final int DEFAULT_ACTIVITY_INFLATION = 5;
  private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0F;
  public static final String DEFAULT_HISTORY_FILE_NAME = "activity_choser_model_history.xml";
  public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
  private static final String HISTORY_FILE_EXTENSION = ".xml";
  private static final int INVALID_INDEX = -1;
  private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
  private static final Executor SERIAL_EXECUTOR = Executors.newSingleThreadExecutor();
  private static final String TAG_HISTORICAL_RECORD = "historical-record";
  private static final String TAG_HISTORICAL_RECORDS = "historical-records";
  private static final Map<String, ActivityChooserModel> sDataModelRegistry;
  private static final Object sRegistryLock = new Object();
  private final List<ActivityResolveInfo> mActivites = new ArrayList();
  private OnChooseActivityListener mActivityChoserModelPolicy;
  private ActivitySorter mActivitySorter = new DefaultSorter(null);
  private boolean mCanReadHistoricalData = true;
  private final Context mContext;
  private final Handler mHandler = new Handler();
  private final List<HistoricalRecord> mHistoricalRecords = new ArrayList();
  private boolean mHistoricalRecordsChanged = true;
  private final String mHistoryFileName;
  private int mHistoryMaxSize = 50;
  private final Object mInstanceLock = new Object();
  private Intent mIntent;
  private boolean mReadShareHistoryCalled = false;

  static
  {
    sDataModelRegistry = new HashMap();
  }

  private ActivityChooserModel(Context paramContext, String paramString)
  {
    this.mContext = paramContext.getApplicationContext();
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.endsWith(".xml")))
    {
      this.mHistoryFileName = (paramString + ".xml");
      return;
    }
    this.mHistoryFileName = paramString;
  }

  private boolean addHisoricalRecord(HistoricalRecord paramHistoricalRecord)
  {
    synchronized (this.mInstanceLock)
    {
      boolean bool = this.mHistoricalRecords.add(paramHistoricalRecord);
      if (bool)
      {
        this.mHistoricalRecordsChanged = true;
        pruneExcessiveHistoricalRecordsLocked();
        persistHistoricalData();
        sortActivities();
      }
      return bool;
    }
  }

  public static ActivityChooserModel get(Context paramContext, String paramString)
  {
    synchronized (sRegistryLock)
    {
      ActivityChooserModel localActivityChooserModel = (ActivityChooserModel)sDataModelRegistry.get(paramString);
      if (localActivityChooserModel == null)
      {
        localActivityChooserModel = new ActivityChooserModel(paramContext, paramString);
        sDataModelRegistry.put(paramString, localActivityChooserModel);
      }
      localActivityChooserModel.readHistoricalData();
      return localActivityChooserModel;
    }
  }

  private void loadActivitiesLocked()
  {
    this.mActivites.clear();
    if (this.mIntent != null)
    {
      List localList = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
      int i = localList.size();
      for (int j = 0; ; j++)
      {
        if (j >= i)
        {
          sortActivities();
          return;
        }
        ResolveInfo localResolveInfo = (ResolveInfo)localList.get(j);
        this.mActivites.add(new ActivityResolveInfo(localResolveInfo));
      }
    }
    notifyChanged();
  }

  private void persistHistoricalData()
  {
    synchronized (this.mInstanceLock)
    {
      if (!this.mReadShareHistoryCalled)
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }
    if (!this.mHistoricalRecordsChanged)
      return;
    this.mHistoricalRecordsChanged = false;
    this.mCanReadHistoricalData = true;
    if (!TextUtils.isEmpty(this.mHistoryFileName))
      SERIAL_EXECUTOR.execute(new HistoryPersister(null));
  }

  private void pruneExcessiveHistoricalRecordsLocked()
  {
    List localList = this.mHistoricalRecords;
    int i = localList.size() - this.mHistoryMaxSize;
    if (i <= 0);
    while (true)
    {
      return;
      this.mHistoricalRecordsChanged = true;
      for (int j = 0; j < i; j++)
        ((HistoricalRecord)localList.remove(0));
    }
  }

  private void readHistoricalData()
  {
    synchronized (this.mInstanceLock)
    {
      if ((!this.mCanReadHistoricalData) || (!this.mHistoricalRecordsChanged))
        return;
      this.mCanReadHistoricalData = false;
      this.mReadShareHistoryCalled = true;
      if (!TextUtils.isEmpty(this.mHistoryFileName))
        SERIAL_EXECUTOR.execute(new HistoryLoader(null));
      return;
    }
  }

  private void sortActivities()
  {
    synchronized (this.mInstanceLock)
    {
      if ((this.mActivitySorter != null) && (!this.mActivites.isEmpty()))
      {
        this.mActivitySorter.sort(this.mIntent, this.mActivites, Collections.unmodifiableList(this.mHistoricalRecords));
        notifyChanged();
      }
      return;
    }
  }

  public Intent chooseActivity(int paramInt)
  {
    ActivityResolveInfo localActivityResolveInfo = (ActivityResolveInfo)this.mActivites.get(paramInt);
    ComponentName localComponentName = new ComponentName(localActivityResolveInfo.resolveInfo.activityInfo.packageName, localActivityResolveInfo.resolveInfo.activityInfo.name);
    Intent localIntent1 = new Intent(this.mIntent);
    localIntent1.setComponent(localComponentName);
    if (this.mActivityChoserModelPolicy != null)
    {
      Intent localIntent2 = new Intent(localIntent1);
      if (this.mActivityChoserModelPolicy.onChooseActivity(this, localIntent2))
        return null;
    }
    addHisoricalRecord(new HistoricalRecord(localComponentName, System.currentTimeMillis(), 1.0F));
    return localIntent1;
  }

  public ResolveInfo getActivity(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivites.get(paramInt)).resolveInfo;
      return localResolveInfo;
    }
  }

  public int getActivityCount()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mActivites.size();
      return i;
    }
  }

  public int getActivityIndex(ResolveInfo paramResolveInfo)
  {
    List localList = this.mActivites;
    int i = localList.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
        j = -1;
      while (((ActivityResolveInfo)localList.get(j)).resolveInfo == paramResolveInfo)
        return j;
    }
  }

  public ResolveInfo getDefaultActivity()
  {
    synchronized (this.mInstanceLock)
    {
      if (!this.mActivites.isEmpty())
      {
        ResolveInfo localResolveInfo = ((ActivityResolveInfo)this.mActivites.get(0)).resolveInfo;
        return localResolveInfo;
      }
      return null;
    }
  }

  public int getHistoryMaxSize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoryMaxSize;
      return i;
    }
  }

  public int getHistorySize()
  {
    synchronized (this.mInstanceLock)
    {
      int i = this.mHistoricalRecords.size();
      return i;
    }
  }

  public Intent getIntent()
  {
    synchronized (this.mInstanceLock)
    {
      Intent localIntent = this.mIntent;
      return localIntent;
    }
  }

  public void setActivitySorter(ActivitySorter paramActivitySorter)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mActivitySorter == paramActivitySorter)
        return;
      this.mActivitySorter = paramActivitySorter;
      sortActivities();
      return;
    }
  }

  public void setDefaultActivity(int paramInt)
  {
    ActivityResolveInfo localActivityResolveInfo1 = (ActivityResolveInfo)this.mActivites.get(paramInt);
    ActivityResolveInfo localActivityResolveInfo2 = (ActivityResolveInfo)this.mActivites.get(0);
    if (localActivityResolveInfo2 != null);
    for (float f = 5.0F + (localActivityResolveInfo2.weight - localActivityResolveInfo1.weight); ; f = 1.0F)
    {
      addHisoricalRecord(new HistoricalRecord(new ComponentName(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
      return;
    }
  }

  public void setHistoryMaxSize(int paramInt)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mHistoryMaxSize == paramInt)
        return;
      this.mHistoryMaxSize = paramInt;
      pruneExcessiveHistoricalRecordsLocked();
      sortActivities();
      return;
    }
  }

  public void setIntent(Intent paramIntent)
  {
    synchronized (this.mInstanceLock)
    {
      if (this.mIntent == paramIntent)
        return;
      this.mIntent = paramIntent;
      loadActivitiesLocked();
      return;
    }
  }

  public void setOnChooseActivityListener(OnChooseActivityListener paramOnChooseActivityListener)
  {
    this.mActivityChoserModelPolicy = paramOnChooseActivityListener;
  }

  public static abstract interface ActivityChooserModelClient
  {
    public abstract void setActivityChooserModel(ActivityChooserModel paramActivityChooserModel);
  }

  public final class ActivityResolveInfo
    implements Comparable<ActivityResolveInfo>
  {
    public final ResolveInfo resolveInfo;
    public float weight;

    public ActivityResolveInfo(ResolveInfo arg2)
    {
      Object localObject;
      this.resolveInfo = localObject;
    }

    public int compareTo(ActivityResolveInfo paramActivityResolveInfo)
    {
      return Float.floatToIntBits(paramActivityResolveInfo.weight) - Float.floatToIntBits(this.weight);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      ActivityResolveInfo localActivityResolveInfo;
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localActivityResolveInfo = (ActivityResolveInfo)paramObject;
      }
      while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(localActivityResolveInfo.weight));
      return false;
    }

    public int hashCode()
    {
      return 31 + Float.floatToIntBits(this.weight);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  public static abstract interface ActivitySorter
  {
    public abstract void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1);
  }

  private final class DefaultSorter
    implements ActivityChooserModel.ActivitySorter
  {
    private static final float WEIGHT_DECAY_COEFFICIENT = 0.95F;
    private final Map<String, ActivityChooserModel.ActivityResolveInfo> mPackageNameToActivityMap = new HashMap();

    private DefaultSorter()
    {
    }

    public void sort(Intent paramIntent, List<ActivityChooserModel.ActivityResolveInfo> paramList, List<ActivityChooserModel.HistoricalRecord> paramList1)
    {
      Map localMap = this.mPackageNameToActivityMap;
      localMap.clear();
      int i = paramList.size();
      int j = 0;
      int k;
      float f;
      if (j >= i)
      {
        k = -1 + paramList1.size();
        f = 1.0F;
      }
      for (int m = k; ; m--)
      {
        if (m < 0)
        {
          Collections.sort(paramList);
          return;
          ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo1 = (ActivityChooserModel.ActivityResolveInfo)paramList.get(j);
          localActivityResolveInfo1.weight = 0.0F;
          localMap.put(localActivityResolveInfo1.resolveInfo.activityInfo.packageName, localActivityResolveInfo1);
          j++;
          break;
        }
        ActivityChooserModel.HistoricalRecord localHistoricalRecord = (ActivityChooserModel.HistoricalRecord)paramList1.get(m);
        ActivityChooserModel.ActivityResolveInfo localActivityResolveInfo2 = (ActivityChooserModel.ActivityResolveInfo)localMap.get(localHistoricalRecord.activity.getPackageName());
        if (localActivityResolveInfo2 != null)
        {
          localActivityResolveInfo2.weight += f * localHistoricalRecord.weight;
          f *= 0.95F;
        }
      }
    }
  }

  public static final class HistoricalRecord
  {
    public final ComponentName activity;
    public final long time;
    public final float weight;

    public HistoricalRecord(ComponentName paramComponentName, long paramLong, float paramFloat)
    {
      this.activity = paramComponentName;
      this.time = paramLong;
      this.weight = paramFloat;
    }

    public HistoricalRecord(String paramString, long paramLong, float paramFloat)
    {
      this(ComponentName.unflattenFromString(paramString), paramLong, paramFloat);
    }

    public boolean equals(Object paramObject)
    {
      if (this == paramObject);
      HistoricalRecord localHistoricalRecord;
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localHistoricalRecord = (HistoricalRecord)paramObject;
        if (this.activity == null)
        {
          if (localHistoricalRecord.activity != null)
            return false;
        }
        else if (!this.activity.equals(localHistoricalRecord.activity))
          return false;
        if (this.time != localHistoricalRecord.time)
          return false;
      }
      while (Float.floatToIntBits(this.weight) == Float.floatToIntBits(localHistoricalRecord.weight));
      return false;
    }

    public int hashCode()
    {
      if (this.activity == null);
      for (int i = 0; ; i = this.activity.hashCode())
        return 31 * (31 * (i + 31) + (int)(this.time ^ this.time >>> 32)) + Float.floatToIntBits(this.weight);
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append("; activity:").append(this.activity);
      localStringBuilder.append("; time:").append(this.time);
      localStringBuilder.append("; weight:").append(new BigDecimal(this.weight));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }

  private final class HistoryLoader
    implements Runnable
  {
    private HistoryLoader()
    {
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   4: invokestatic 33	com/actionbarsherlock/widget/ActivityChooserModel:access$0	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/content/Context;
      //   7: aload_0
      //   8: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   11: invokestatic 36	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   14: invokevirtual 42	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
      //   17: astore_2
      //   18: invokestatic 48	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
      //   21: astore 11
      //   23: aload 11
      //   25: aload_2
      //   26: aconst_null
      //   27: invokeinterface 54 3 0
      //   32: iconst_0
      //   33: istore 12
      //   35: goto +436 -> 471
      //   38: ldc 56
      //   40: aload 11
      //   42: invokeinterface 60 1 0
      //   47: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   50: ifne +69 -> 119
      //   53: new 25	org/xmlpull/v1/XmlPullParserException
      //   56: dup
      //   57: ldc 68
      //   59: invokespecial 71	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
      //   62: athrow
      //   63: astore 8
      //   65: invokestatic 74	com/actionbarsherlock/widget/ActivityChooserModel:access$8	()Ljava/lang/String;
      //   68: new 76	java/lang/StringBuilder
      //   71: dup
      //   72: ldc 78
      //   74: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   77: aload_0
      //   78: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   81: invokestatic 36	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   84: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   87: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   90: aload 8
      //   92: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   95: pop
      //   96: aload_2
      //   97: ifnull +7 -> 104
      //   100: aload_2
      //   101: invokevirtual 97	java/io/FileInputStream:close	()V
      //   104: return
      //   105: astore_1
      //   106: return
      //   107: aload 11
      //   109: invokeinterface 101 1 0
      //   114: istore 12
      //   116: goto +355 -> 471
      //   119: new 103	java/util/ArrayList
      //   122: dup
      //   123: invokespecial 104	java/util/ArrayList:<init>	()V
      //   126: astore 13
      //   128: aload 11
      //   130: invokeinterface 101 1 0
      //   135: istore 14
      //   137: iload 14
      //   139: iconst_1
      //   140: if_icmpne +83 -> 223
      //   143: aload_0
      //   144: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   147: invokestatic 108	com/actionbarsherlock/widget/ActivityChooserModel:access$2	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/Object;
      //   150: astore 15
      //   152: aload 15
      //   154: monitorenter
      //   155: new 110	java/util/LinkedHashSet
      //   158: dup
      //   159: aload 13
      //   161: invokespecial 113	java/util/LinkedHashSet:<init>	(Ljava/util/Collection;)V
      //   164: astore 16
      //   166: aload_0
      //   167: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   170: invokestatic 117	com/actionbarsherlock/widget/ActivityChooserModel:access$3	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/util/List;
      //   173: astore 18
      //   175: iconst_m1
      //   176: aload 18
      //   178: invokeinterface 122 1 0
      //   183: iadd
      //   184: istore 19
      //   186: iload 19
      //   188: ifge +182 -> 370
      //   191: aload 18
      //   193: invokeinterface 122 1 0
      //   198: aload 16
      //   200: invokeinterface 125 1 0
      //   205: if_icmpne +191 -> 396
      //   208: aload 15
      //   210: monitorexit
      //   211: aload_2
      //   212: ifnull -108 -> 104
      //   215: aload_2
      //   216: invokevirtual 97	java/io/FileInputStream:close	()V
      //   219: return
      //   220: astore 23
      //   222: return
      //   223: iload 14
      //   225: iconst_3
      //   226: if_icmpeq -98 -> 128
      //   229: iload 14
      //   231: iconst_4
      //   232: if_icmpeq -104 -> 128
      //   235: ldc 127
      //   237: aload 11
      //   239: invokeinterface 60 1 0
      //   244: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   247: ifne +58 -> 305
      //   250: new 25	org/xmlpull/v1/XmlPullParserException
      //   253: dup
      //   254: ldc 129
      //   256: invokespecial 71	org/xmlpull/v1/XmlPullParserException:<init>	(Ljava/lang/String;)V
      //   259: athrow
      //   260: astore 5
      //   262: invokestatic 74	com/actionbarsherlock/widget/ActivityChooserModel:access$8	()Ljava/lang/String;
      //   265: new 76	java/lang/StringBuilder
      //   268: dup
      //   269: ldc 78
      //   271: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   274: aload_0
      //   275: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   278: invokestatic 36	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   281: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   284: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   287: aload 5
      //   289: invokestatic 92	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   292: pop
      //   293: aload_2
      //   294: ifnull -190 -> 104
      //   297: aload_2
      //   298: invokevirtual 97	java/io/FileInputStream:close	()V
      //   301: return
      //   302: astore 7
      //   304: return
      //   305: aload 13
      //   307: new 131	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   310: dup
      //   311: aload 11
      //   313: aconst_null
      //   314: ldc 133
      //   316: invokeinterface 137 3 0
      //   321: aload 11
      //   323: aconst_null
      //   324: ldc 139
      //   326: invokeinterface 137 3 0
      //   331: invokestatic 145	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   334: aload 11
      //   336: aconst_null
      //   337: ldc 147
      //   339: invokeinterface 137 3 0
      //   344: invokestatic 153	java/lang/Float:parseFloat	(Ljava/lang/String;)F
      //   347: invokespecial 156	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:<init>	(Ljava/lang/String;JF)V
      //   350: invokeinterface 159 2 0
      //   355: pop
      //   356: goto -228 -> 128
      //   359: astore_3
      //   360: aload_2
      //   361: ifnull +7 -> 368
      //   364: aload_2
      //   365: invokevirtual 97	java/io/FileInputStream:close	()V
      //   368: aload_3
      //   369: athrow
      //   370: aload 16
      //   372: aload 18
      //   374: iload 19
      //   376: invokeinterface 163 2 0
      //   381: checkcast 131	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   384: invokeinterface 164 2 0
      //   389: pop
      //   390: iinc 19 255
      //   393: goto -207 -> 186
      //   396: aload 18
      //   398: invokeinterface 167 1 0
      //   403: aload 18
      //   405: aload 16
      //   407: invokeinterface 171 2 0
      //   412: pop
      //   413: aload_0
      //   414: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   417: iconst_1
      //   418: invokestatic 175	com/actionbarsherlock/widget/ActivityChooserModel:access$4	(Lcom/actionbarsherlock/widget/ActivityChooserModel;Z)V
      //   421: aload_0
      //   422: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   425: invokestatic 179	com/actionbarsherlock/widget/ActivityChooserModel:access$5	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/os/Handler;
      //   428: new 181	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1
      //   431: dup
      //   432: aload_0
      //   433: invokespecial 184	com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1:<init>	(Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader;)V
      //   436: invokevirtual 190	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   439: pop
      //   440: aload 15
      //   442: monitorexit
      //   443: aload_2
      //   444: ifnull -340 -> 104
      //   447: aload_2
      //   448: invokevirtual 97	java/io/FileInputStream:close	()V
      //   451: return
      //   452: astore 22
      //   454: return
      //   455: astore 17
      //   457: aload 15
      //   459: monitorexit
      //   460: aload 17
      //   462: athrow
      //   463: astore 10
      //   465: return
      //   466: astore 4
      //   468: goto -100 -> 368
      //   471: iload 12
      //   473: iconst_1
      //   474: if_icmpeq -436 -> 38
      //   477: iload 12
      //   479: iconst_2
      //   480: if_icmpne -373 -> 107
      //   483: goto -445 -> 38
      //
      // Exception table:
      //   from	to	target	type
      //   18	32	63	org/xmlpull/v1/XmlPullParserException
      //   38	63	63	org/xmlpull/v1/XmlPullParserException
      //   107	116	63	org/xmlpull/v1/XmlPullParserException
      //   119	128	63	org/xmlpull/v1/XmlPullParserException
      //   128	137	63	org/xmlpull/v1/XmlPullParserException
      //   143	155	63	org/xmlpull/v1/XmlPullParserException
      //   235	260	63	org/xmlpull/v1/XmlPullParserException
      //   305	356	63	org/xmlpull/v1/XmlPullParserException
      //   460	463	63	org/xmlpull/v1/XmlPullParserException
      //   0	18	105	java/io/FileNotFoundException
      //   215	219	220	java/io/IOException
      //   18	32	260	java/io/IOException
      //   38	63	260	java/io/IOException
      //   107	116	260	java/io/IOException
      //   119	128	260	java/io/IOException
      //   128	137	260	java/io/IOException
      //   143	155	260	java/io/IOException
      //   235	260	260	java/io/IOException
      //   305	356	260	java/io/IOException
      //   460	463	260	java/io/IOException
      //   297	301	302	java/io/IOException
      //   18	32	359	finally
      //   38	63	359	finally
      //   65	96	359	finally
      //   107	116	359	finally
      //   119	128	359	finally
      //   128	137	359	finally
      //   143	155	359	finally
      //   235	260	359	finally
      //   262	293	359	finally
      //   305	356	359	finally
      //   460	463	359	finally
      //   447	451	452	java/io/IOException
      //   155	186	455	finally
      //   191	211	455	finally
      //   370	390	455	finally
      //   396	443	455	finally
      //   457	460	455	finally
      //   100	104	463	java/io/IOException
      //   364	368	466	java/io/IOException
    }
  }

  private final class HistoryPersister
    implements Runnable
  {
    private HistoryPersister()
    {
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   4: invokestatic 33	com/actionbarsherlock/widget/ActivityChooserModel:access$2	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/Object;
      //   7: astore_1
      //   8: aload_1
      //   9: monitorenter
      //   10: new 35	java/util/ArrayList
      //   13: dup
      //   14: aload_0
      //   15: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   18: invokestatic 39	com/actionbarsherlock/widget/ActivityChooserModel:access$3	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/util/List;
      //   21: invokespecial 42	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
      //   24: astore_2
      //   25: aload_1
      //   26: monitorexit
      //   27: aload_0
      //   28: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   31: invokestatic 46	com/actionbarsherlock/widget/ActivityChooserModel:access$0	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/content/Context;
      //   34: aload_0
      //   35: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   38: invokestatic 50	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   41: iconst_0
      //   42: invokevirtual 56	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
      //   45: astore 6
      //   47: invokestatic 62	android/util/Xml:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
      //   50: astore 7
      //   52: aload 7
      //   54: aload 6
      //   56: aconst_null
      //   57: invokeinterface 68 3 0
      //   62: aload 7
      //   64: ldc 70
      //   66: iconst_1
      //   67: invokestatic 76	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   70: invokeinterface 80 3 0
      //   75: aload 7
      //   77: aconst_null
      //   78: ldc 82
      //   80: invokeinterface 86 3 0
      //   85: pop
      //   86: aload_2
      //   87: invokeinterface 92 1 0
      //   92: istore 20
      //   94: iconst_0
      //   95: istore 21
      //   97: iload 21
      //   99: iload 20
      //   101: if_icmplt +71 -> 172
      //   104: aload 7
      //   106: aconst_null
      //   107: ldc 82
      //   109: invokeinterface 95 3 0
      //   114: pop
      //   115: aload 7
      //   117: invokeinterface 98 1 0
      //   122: aload 6
      //   124: ifnull +8 -> 132
      //   127: aload 6
      //   129: invokevirtual 103	java/io/FileOutputStream:close	()V
      //   132: return
      //   133: astore_3
      //   134: aload_1
      //   135: monitorexit
      //   136: aload_3
      //   137: athrow
      //   138: astore 4
      //   140: invokestatic 107	com/actionbarsherlock/widget/ActivityChooserModel:access$8	()Ljava/lang/String;
      //   143: new 109	java/lang/StringBuilder
      //   146: dup
      //   147: ldc 111
      //   149: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   152: aload_0
      //   153: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   156: invokestatic 50	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   159: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   162: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   165: aload 4
      //   167: invokestatic 127	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   170: pop
      //   171: return
      //   172: aload_2
      //   173: iconst_0
      //   174: invokeinterface 131 2 0
      //   179: checkcast 133	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord
      //   182: astore 24
      //   184: aload 7
      //   186: aconst_null
      //   187: ldc 135
      //   189: invokeinterface 86 3 0
      //   194: pop
      //   195: aload 7
      //   197: aconst_null
      //   198: ldc 137
      //   200: aload 24
      //   202: getfield 140	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:activity	Landroid/content/ComponentName;
      //   205: invokevirtual 145	android/content/ComponentName:flattenToString	()Ljava/lang/String;
      //   208: invokeinterface 149 4 0
      //   213: pop
      //   214: aload 7
      //   216: aconst_null
      //   217: ldc 151
      //   219: aload 24
      //   221: getfield 154	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:time	J
      //   224: invokestatic 159	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   227: invokeinterface 149 4 0
      //   232: pop
      //   233: aload 7
      //   235: aconst_null
      //   236: ldc 161
      //   238: aload 24
      //   240: getfield 164	com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord:weight	F
      //   243: invokestatic 167	java/lang/String:valueOf	(F)Ljava/lang/String;
      //   246: invokeinterface 149 4 0
      //   251: pop
      //   252: aload 7
      //   254: aconst_null
      //   255: ldc 135
      //   257: invokeinterface 95 3 0
      //   262: pop
      //   263: iinc 21 1
      //   266: goto -169 -> 97
      //   269: astore 16
      //   271: invokestatic 107	com/actionbarsherlock/widget/ActivityChooserModel:access$8	()Ljava/lang/String;
      //   274: new 109	java/lang/StringBuilder
      //   277: dup
      //   278: ldc 111
      //   280: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   283: aload_0
      //   284: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   287: invokestatic 50	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   290: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   293: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   296: aload 16
      //   298: invokestatic 127	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   301: pop
      //   302: aload 6
      //   304: ifnull -172 -> 132
      //   307: aload 6
      //   309: invokevirtual 103	java/io/FileOutputStream:close	()V
      //   312: return
      //   313: astore 18
      //   315: return
      //   316: astore 13
      //   318: invokestatic 107	com/actionbarsherlock/widget/ActivityChooserModel:access$8	()Ljava/lang/String;
      //   321: new 109	java/lang/StringBuilder
      //   324: dup
      //   325: ldc 111
      //   327: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   330: aload_0
      //   331: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   334: invokestatic 50	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   337: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   340: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   343: aload 13
      //   345: invokestatic 127	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   348: pop
      //   349: aload 6
      //   351: ifnull -219 -> 132
      //   354: aload 6
      //   356: invokevirtual 103	java/io/FileOutputStream:close	()V
      //   359: return
      //   360: astore 15
      //   362: return
      //   363: astore 10
      //   365: invokestatic 107	com/actionbarsherlock/widget/ActivityChooserModel:access$8	()Ljava/lang/String;
      //   368: new 109	java/lang/StringBuilder
      //   371: dup
      //   372: ldc 111
      //   374: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   377: aload_0
      //   378: getfield 12	com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister:this$0	Lcom/actionbarsherlock/widget/ActivityChooserModel;
      //   381: invokestatic 50	com/actionbarsherlock/widget/ActivityChooserModel:access$1	(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
      //   384: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   387: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   390: aload 10
      //   392: invokestatic 127	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   395: pop
      //   396: aload 6
      //   398: ifnull -266 -> 132
      //   401: aload 6
      //   403: invokevirtual 103	java/io/FileOutputStream:close	()V
      //   406: return
      //   407: astore 12
      //   409: return
      //   410: astore 8
      //   412: aload 6
      //   414: ifnull +8 -> 422
      //   417: aload 6
      //   419: invokevirtual 103	java/io/FileOutputStream:close	()V
      //   422: aload 8
      //   424: athrow
      //   425: astore 9
      //   427: goto -5 -> 422
      //   430: astore 23
      //   432: return
      //   433: astore_3
      //   434: goto -300 -> 134
      //
      // Exception table:
      //   from	to	target	type
      //   10	25	133	finally
      //   134	136	133	finally
      //   27	47	138	java/io/FileNotFoundException
      //   52	94	269	java/lang/IllegalArgumentException
      //   104	122	269	java/lang/IllegalArgumentException
      //   172	263	269	java/lang/IllegalArgumentException
      //   307	312	313	java/io/IOException
      //   52	94	316	java/lang/IllegalStateException
      //   104	122	316	java/lang/IllegalStateException
      //   172	263	316	java/lang/IllegalStateException
      //   354	359	360	java/io/IOException
      //   52	94	363	java/io/IOException
      //   104	122	363	java/io/IOException
      //   172	263	363	java/io/IOException
      //   401	406	407	java/io/IOException
      //   52	94	410	finally
      //   104	122	410	finally
      //   172	263	410	finally
      //   271	302	410	finally
      //   318	349	410	finally
      //   365	396	410	finally
      //   417	422	425	java/io/IOException
      //   127	132	430	java/io/IOException
      //   25	27	433	finally
    }
  }

  public static abstract interface OnChooseActivityListener
  {
    public abstract boolean onChooseActivity(ActivityChooserModel paramActivityChooserModel, Intent paramIntent);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.actionbarsherlock.widget.ActivityChooserModel
 * JD-Core Version:    0.6.2
 */