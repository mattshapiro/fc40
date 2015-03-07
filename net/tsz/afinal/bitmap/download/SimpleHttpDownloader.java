package net.tsz.afinal.bitmap.download;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SimpleHttpDownloader
  implements Downloader
{
  private static final int IO_BUFFER_SIZE = 8192;
  private static final String TAG = "BitmapDownloader";

  // ERROR //
  public boolean downloadToLocalStreamByUrl(String paramString, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: new 23	java/net/URL
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 26	java/net/URL:<init>	(Ljava/lang/String;)V
    //   16: invokevirtual 30	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 32	java/net/HttpURLConnection
    //   22: astore_3
    //   23: new 34	net/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream
    //   26: dup
    //   27: aload_0
    //   28: new 36	java/io/BufferedInputStream
    //   31: dup
    //   32: aload_3
    //   33: invokevirtual 40	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   36: sipush 8192
    //   39: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   42: invokespecial 46	net/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream:<init>	(Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader;Ljava/io/InputStream;)V
    //   45: astore 11
    //   47: new 48	java/io/BufferedOutputStream
    //   50: dup
    //   51: aload_2
    //   52: sipush 8192
    //   55: invokespecial 51	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   58: astore 12
    //   60: aload 11
    //   62: invokevirtual 55	net/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream:read	()I
    //   65: istore 13
    //   67: iload 13
    //   69: iconst_m1
    //   70: if_icmpne +33 -> 103
    //   73: aload_3
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   81: aload 12
    //   83: ifnull +8 -> 91
    //   86: aload 12
    //   88: invokevirtual 61	java/io/BufferedOutputStream:close	()V
    //   91: aload 11
    //   93: ifnull +8 -> 101
    //   96: aload 11
    //   98: invokevirtual 62	net/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream:close	()V
    //   101: iconst_1
    //   102: ireturn
    //   103: aload 12
    //   105: iload 13
    //   107: invokevirtual 66	java/io/BufferedOutputStream:write	(I)V
    //   110: goto -50 -> 60
    //   113: astore 6
    //   115: aload 11
    //   117: astore 5
    //   119: aload 12
    //   121: astore 4
    //   123: ldc 13
    //   125: new 68	java/lang/StringBuilder
    //   128: dup
    //   129: ldc 70
    //   131: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   134: aload_1
    //   135: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 77
    //   140: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload 6
    //   145: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 90	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload_3
    //   156: ifnull +7 -> 163
    //   159: aload_3
    //   160: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 61	java/io/BufferedOutputStream:close	()V
    //   173: aload 5
    //   175: ifnull +8 -> 183
    //   178: aload 5
    //   180: invokevirtual 62	net/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream:close	()V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 7
    //   187: aload_3
    //   188: ifnull +7 -> 195
    //   191: aload_3
    //   192: invokevirtual 58	java/net/HttpURLConnection:disconnect	()V
    //   195: aload 4
    //   197: ifnull +8 -> 205
    //   200: aload 4
    //   202: invokevirtual 61	java/io/BufferedOutputStream:close	()V
    //   205: aload 5
    //   207: ifnull +8 -> 215
    //   210: aload 5
    //   212: invokevirtual 62	net/tsz/afinal/bitmap/download/SimpleHttpDownloader$FlushedInputStream:close	()V
    //   215: aload 7
    //   217: athrow
    //   218: astore 8
    //   220: goto -5 -> 215
    //   223: astore 7
    //   225: aload 11
    //   227: astore 5
    //   229: aconst_null
    //   230: astore 4
    //   232: goto -45 -> 187
    //   235: astore 7
    //   237: aload 11
    //   239: astore 5
    //   241: aload 12
    //   243: astore 4
    //   245: goto -58 -> 187
    //   248: astore 10
    //   250: goto -67 -> 183
    //   253: astore 6
    //   255: aconst_null
    //   256: astore 5
    //   258: aconst_null
    //   259: astore 4
    //   261: goto -138 -> 123
    //   264: astore 6
    //   266: aload 11
    //   268: astore 5
    //   270: aconst_null
    //   271: astore 4
    //   273: goto -150 -> 123
    //   276: astore 14
    //   278: goto -177 -> 101
    //
    // Exception table:
    //   from	to	target	type
    //   60	67	113	java/io/IOException
    //   103	110	113	java/io/IOException
    //   8	47	185	finally
    //   123	155	185	finally
    //   200	205	218	java/io/IOException
    //   210	215	218	java/io/IOException
    //   47	60	223	finally
    //   60	67	235	finally
    //   103	110	235	finally
    //   168	173	248	java/io/IOException
    //   178	183	248	java/io/IOException
    //   8	47	253	java/io/IOException
    //   47	60	264	java/io/IOException
    //   86	91	276	java/io/IOException
    //   96	101	276	java/io/IOException
  }

  public class FlushedInputStream extends FilterInputStream
  {
    public FlushedInputStream(InputStream arg2)
    {
      super();
    }

    public long skip(long paramLong)
      throws IOException
    {
      long l2;
      for (long l1 = 0L; ; l1 += l2)
      {
        if (l1 >= paramLong);
        do
        {
          return l1;
          l2 = this.in.skip(paramLong - l1);
          if (l2 != 0L)
            break;
        }
        while (read() < 0);
        l2 = 1L;
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.download.SimpleHttpDownloader
 * JD-Core Version:    0.6.2
 */