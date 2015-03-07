package com.umeng.analytics;

import java.util.Locale;
import u.aly.ap;

public enum Gender
{
  public int value;

  static
  {
    // Byte code:
    //   0: new 19	com/umeng/analytics/Gender$1
    //   3: dup
    //   4: ldc 20
    //   6: iconst_0
    //   7: iconst_1
    //   8: invokespecial 24	com/umeng/analytics/Gender$1:<init>	(Ljava/lang/String;II)V
    //   11: putstatic 26	com/umeng/analytics/Gender:Male	Lcom/umeng/analytics/Gender;
    //   14: new 28	com/umeng/analytics/Gender$2
    //   17: dup
    //   18: ldc 29
    //   20: iconst_1
    //   21: iconst_2
    //   22: invokespecial 30	com/umeng/analytics/Gender$2:<init>	(Ljava/lang/String;II)V
    //   25: putstatic 32	com/umeng/analytics/Gender:Female	Lcom/umeng/analytics/Gender;
    //   28: new 34	com/umeng/analytics/Gender$3
    //   31: dup
    //   32: ldc 35
    //   34: iconst_2
    //   35: iconst_0
    //   36: invokespecial 36	com/umeng/analytics/Gender$3:<init>	(Ljava/lang/String;II)V
    //   39: putstatic 38	com/umeng/analytics/Gender:Unknown	Lcom/umeng/analytics/Gender;
    //   42: iconst_3
    //   43: anewarray 2	com/umeng/analytics/Gender
    //   46: astore_0
    //   47: aload_0
    //   48: iconst_0
    //   49: getstatic 26	com/umeng/analytics/Gender:Male	Lcom/umeng/analytics/Gender;
    //   52: aastore
    //   53: aload_0
    //   54: iconst_1
    //   55: getstatic 32	com/umeng/analytics/Gender:Female	Lcom/umeng/analytics/Gender;
    //   58: aastore
    //   59: aload_0
    //   60: iconst_2
    //   61: getstatic 38	com/umeng/analytics/Gender:Unknown	Lcom/umeng/analytics/Gender;
    //   64: aastore
    //   65: aload_0
    //   66: putstatic 40	com/umeng/analytics/Gender:b	[Lcom/umeng/analytics/Gender;
    //   69: return
  }

  private Gender(int arg3)
  {
    int j;
    this.value = j;
  }

  public static Gender getGender(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return Unknown;
    case 1:
      return Male;
    case 2:
    }
    return Female;
  }

  public static ap transGender(Gender paramGender)
  {
    switch (a()[paramGender.ordinal()])
    {
    default:
      return ap.c;
    case 1:
      return ap.a;
    case 2:
    }
    return ap.b;
  }

  public int value()
  {
    return this.value;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.Gender
 * JD-Core Version:    0.6.2
 */