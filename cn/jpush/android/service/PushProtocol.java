package cn.jpush.android.service;

public class PushProtocol
{
  static
  {
    Object localObject1 = "Q~5Rx\n9q".toCharArray();
    int i = localObject1.length;
    int j = 0;
    if (i <= 1);
    label132: 
    while (i > j)
    {
      Object localObject2 = localObject1;
      int k = j;
      int m = i;
      Object localObject3 = localObject1;
      int n = localObject3[j];
      int i1;
      switch (k % 5)
      {
      default:
        i1 = 16;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        localObject3[j] = ((char)(i1 ^ n));
        j = k + 1;
        if (m != 0)
          break label132;
        localObject3 = localObject2;
        k = j;
        j = m;
        break;
        i1 = 59;
        continue;
        i1 = 14;
        continue;
        i1 = 64;
        continue;
        i1 = 33;
      }
      i = m;
      localObject1 = localObject2;
    }
    System.loadLibrary(new String((char[])localObject1).intern());
  }

  public static synchronized native int Close(int paramInt);

  public static native int EnChannel(int paramInt, long paramLong, String paramString1, String paramString2);

  public static native String GetEsg(int paramInt);

  public static native int GetSdkVersion();

  public static native int HbJPush(int paramInt, long paramLong);

  public static native int InitConn();

  public static native int InitPush(int paramInt1, String paramString, int paramInt2);

  public static native int LogPushWithBack(int paramInt, byte[] paramArrayOfByte, long paramLong1, String paramString1, String paramString2, long paramLong2);

  public static native int MsgResponse(int paramInt1, int paramInt2, long paramLong1, byte paramByte, long paramLong2);

  public static native int PushTime(int paramInt, long paramLong, String paramString1, String paramString2);

  public static native int RecvPush(int paramInt1, byte[] paramArrayOfByte, int paramInt2);

  public static native int RegPush(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4);

  public static native int RepPush(int paramInt, long paramLong, byte paramByte, String paramString);

  public static native int Stop(int paramInt);

  public static native int TagAlias(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2);

  public static native int UnChnelId(int paramInt, long paramLong, String paramString1, String paramString2);
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.PushProtocol
 * JD-Core Version:    0.6.2
 */