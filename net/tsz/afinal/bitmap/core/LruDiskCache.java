package net.tsz.afinal.bitmap.core;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class LruDiskCache
  implements Closeable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  private static final int IO_BUFFER_SIZE = 8192;
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_TMP = "journal.tmp";
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Callable<Void> cleanupCallable = new Callable()
  {
    public Void call()
      throws Exception
    {
      synchronized (LruDiskCache.this)
      {
        if (LruDiskCache.this.journalWriter == null)
          return null;
        LruDiskCache.this.trimToSize();
        if (LruDiskCache.this.journalRebuildRequired())
        {
          LruDiskCache.this.rebuildJournal();
          LruDiskCache.this.redundantOpCount = 0;
        }
        return null;
      }
    }
  };
  private final File directory;
  private final ExecutorService executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File journalFile;
  private final File journalFileTmp;
  private Writer journalWriter;
  private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private final long maxSize;
  private long nextSequenceNumber = 0L;
  private int redundantOpCount;
  private long size = 0L;
  private final int valueCount;

  private LruDiskCache(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
  }

  private void checkNotClosed()
  {
    if (this.journalWriter == null)
      throw new IllegalStateException("cache is closed");
  }

  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null);
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      throw localRuntimeException;
    }
    catch (Exception localException)
    {
    }
  }

  private void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    Entry localEntry;
    try
    {
      localEntry = paramEditor.entry;
      if (localEntry.currentEditor != paramEditor)
        throw new IllegalStateException();
    }
    finally
    {
    }
    int j;
    if ((paramBoolean) && (!localEntry.readable))
    {
      j = 0;
      if (j >= this.valueCount)
        break label381;
    }
    while (true)
    {
      if (i >= this.valueCount)
      {
        this.redundantOpCount = (1 + this.redundantOpCount);
        localEntry.currentEditor = null;
        if (!(paramBoolean | localEntry.readable))
          break label332;
        localEntry.readable = true;
        this.journalWriter.write("CLEAN " + localEntry.key + localEntry.getLengths() + '\n');
        if (paramBoolean)
        {
          long l3 = this.nextSequenceNumber;
          this.nextSequenceNumber = (1L + l3);
          localEntry.sequenceNumber = l3;
        }
      }
      while (true)
      {
        if ((this.size > this.maxSize) || (journalRebuildRequired()))
          this.executorService.submit(this.cleanupCallable);
        return;
        if (localEntry.getDirtyFile(j).exists())
          break;
        paramEditor.abort();
        throw new IllegalStateException("edit didn't create file " + j);
        File localFile1 = localEntry.getDirtyFile(i);
        if (paramBoolean)
        {
          if (!localFile1.exists())
            break label393;
          File localFile2 = localEntry.getCleanFile(i);
          localFile1.renameTo(localFile2);
          long l1 = localEntry.lengths[i];
          long l2 = localFile2.length();
          localEntry.lengths[i] = l2;
          this.size = (l2 + (this.size - l1));
          break label393;
        }
        deleteIfExists(localFile1);
        break label393;
        label332: this.lruEntries.remove(localEntry.key);
        this.journalWriter.write("REMOVE " + localEntry.key + '\n');
      }
      label381: int i = 0;
      continue;
      j++;
      break;
      label393: i++;
    }
  }

  private static <T> T[] copyOfRange(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfT.length;
    if (paramInt1 > paramInt2)
      throw new IllegalArgumentException();
    if ((paramInt1 < 0) || (paramInt1 > i))
      throw new ArrayIndexOutOfBoundsException();
    int j = paramInt2 - paramInt1;
    int k = Math.min(j, i - paramInt1);
    Object[] arrayOfObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    System.arraycopy(paramArrayOfT, paramInt1, arrayOfObject, 0, k);
    return arrayOfObject;
  }

  public static void deleteContents(File paramFile)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null);
    while (true)
    {
      return;
      int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile = arrayOfFile[j];
        if (localFile.isDirectory())
          deleteContents(localFile);
        if (!localFile.delete())
          throw new IOException("failed to delete file: " + localFile);
      }
    }
  }

  private static void deleteIfExists(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (!paramFile.delete()))
      throw new IOException();
  }

  private Editor edit(String paramString, long paramLong)
    throws IOException
  {
    while (true)
    {
      Entry localEntry;
      Editor localEditor1;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        localEntry = (Entry)this.lruEntries.get(paramString);
        if (paramLong != -1L)
        {
          localEditor1 = null;
          if (localEntry != null)
          {
            long l = localEntry.sequenceNumber;
            boolean bool = l < paramLong;
            localEditor1 = null;
            if (!bool);
          }
          else
          {
            return localEditor1;
          }
        }
        if (localEntry == null)
        {
          localEntry = new Entry(paramString, null);
          this.lruEntries.put(paramString, localEntry);
          localEditor1 = new Editor(localEntry, null);
          localEntry.currentEditor = localEditor1;
          this.journalWriter.write("DIRTY " + paramString + '\n');
          this.journalWriter.flush();
          continue;
        }
      }
      finally
      {
      }
      Editor localEditor2 = localEntry.currentEditor;
      if (localEditor2 != null)
        localEditor1 = null;
    }
  }

  private static String inputStreamToString(InputStream paramInputStream)
    throws IOException
  {
    return readFully(new InputStreamReader(paramInputStream, UTF_8));
  }

  private boolean journalRebuildRequired()
  {
    return (this.redundantOpCount >= 2000) && (this.redundantOpCount >= this.lruEntries.size());
  }

  public static LruDiskCache open(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong <= 0L)
      throw new IllegalArgumentException("maxSize <= 0");
    if (paramInt2 <= 0)
      throw new IllegalArgumentException("valueCount <= 0");
    if ((paramFile != null) && (!paramFile.exists()))
      paramFile.mkdirs();
    LruDiskCache localLruDiskCache1 = new LruDiskCache(paramFile, paramInt1, paramInt2, paramLong);
    if (localLruDiskCache1.journalFile.exists())
      try
      {
        localLruDiskCache1.readJournal();
        localLruDiskCache1.processJournal();
        localLruDiskCache1.journalWriter = new BufferedWriter(new FileWriter(localLruDiskCache1.journalFile, true), 8192);
        return localLruDiskCache1;
      }
      catch (IOException localIOException)
      {
        localLruDiskCache1.delete();
      }
    paramFile.mkdirs();
    LruDiskCache localLruDiskCache2 = new LruDiskCache(paramFile, paramInt1, paramInt2, paramLong);
    localLruDiskCache2.rebuildJournal();
    return localLruDiskCache2;
  }

  private void processJournal()
    throws IOException
  {
    deleteIfExists(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    Entry localEntry;
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      localEntry = (Entry)localIterator.next();
      if (localEntry.currentEditor != null)
        break;
      for (int j = 0; j < this.valueCount; j++)
        this.size += localEntry.lengths[j];
    }
    localEntry.currentEditor = null;
    for (int i = 0; ; i++)
    {
      if (i >= this.valueCount)
      {
        localIterator.remove();
        break;
      }
      deleteIfExists(localEntry.getCleanFile(i));
      deleteIfExists(localEntry.getDirtyFile(i));
    }
  }

  public static String readAsciiLine(InputStream paramInputStream)
    throws IOException
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    while (true)
    {
      int i = paramInputStream.read();
      if (i == -1)
        throw new EOFException();
      if (i == 10)
      {
        int j = localStringBuilder.length();
        if ((j > 0) && (localStringBuilder.charAt(j - 1) == '\r'))
          localStringBuilder.setLength(j - 1);
        return localStringBuilder.toString();
      }
      localStringBuilder.append((char)i);
    }
  }

  public static String readFully(Reader paramReader)
    throws IOException
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      char[] arrayOfChar = new char[1024];
      while (true)
      {
        int i = paramReader.read(arrayOfChar);
        if (i == -1)
        {
          String str = localStringWriter.toString();
          return str;
        }
        localStringWriter.write(arrayOfChar, 0, i);
      }
    }
    finally
    {
      paramReader.close();
    }
  }

  // ERROR //
  private void readJournal()
    throws IOException
  {
    // Byte code:
    //   0: new 467	java/io/BufferedInputStream
    //   3: dup
    //   4: new 469	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: getfield 120	net/tsz/afinal/bitmap/core/LruDiskCache:journalFile	Ljava/io/File;
    //   12: invokespecial 471	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   15: sipush 8192
    //   18: invokespecial 474	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 476	net/tsz/afinal/bitmap/core/LruDiskCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_3
    //   27: aload_1
    //   28: invokestatic 476	net/tsz/afinal/bitmap/core/LruDiskCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   31: astore 4
    //   33: aload_1
    //   34: invokestatic 476	net/tsz/afinal/bitmap/core/LruDiskCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   37: astore 5
    //   39: aload_1
    //   40: invokestatic 476	net/tsz/afinal/bitmap/core/LruDiskCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   43: astore 6
    //   45: aload_1
    //   46: invokestatic 476	net/tsz/afinal/bitmap/core/LruDiskCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   49: astore 7
    //   51: ldc 27
    //   53: aload_3
    //   54: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +54 -> 111
    //   60: ldc 36
    //   62: aload 4
    //   64: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +44 -> 111
    //   70: aload_0
    //   71: getfield 113	net/tsz/afinal/bitmap/core/LruDiskCache:appVersion	I
    //   74: invokestatic 487	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   77: aload 5
    //   79: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +29 -> 111
    //   85: aload_0
    //   86: getfield 124	net/tsz/afinal/bitmap/core/LruDiskCache:valueCount	I
    //   89: invokestatic 487	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   92: aload 6
    //   94: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +14 -> 111
    //   100: ldc_w 489
    //   103: aload 7
    //   105: invokevirtual 482	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifne +74 -> 182
    //   111: new 133	java/io/IOException
    //   114: dup
    //   115: new 212	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 491
    //   122: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_3
    //   126: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 493
    //   132: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 4
    //   137: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 493
    //   143: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload 6
    //   148: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: ldc_w 493
    //   154: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 7
    //   159: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 495
    //   165: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokespecial 341	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   174: athrow
    //   175: astore_2
    //   176: aload_1
    //   177: invokestatic 497	net/tsz/afinal/bitmap/core/LruDiskCache:closeQuietly	(Ljava/io/Closeable;)V
    //   180: aload_2
    //   181: athrow
    //   182: aload_0
    //   183: aload_1
    //   184: invokestatic 476	net/tsz/afinal/bitmap/core/LruDiskCache:readAsciiLine	(Ljava/io/InputStream;)Ljava/lang/String;
    //   187: invokespecial 500	net/tsz/afinal/bitmap/core/LruDiskCache:readJournalLine	(Ljava/lang/String;)V
    //   190: goto -8 -> 182
    //   193: astore 8
    //   195: aload_1
    //   196: invokestatic 497	net/tsz/afinal/bitmap/core/LruDiskCache:closeQuietly	(Ljava/io/Closeable;)V
    //   199: return
    //
    // Exception table:
    //   from	to	target	type
    //   22	111	175	finally
    //   111	175	175	finally
    //   182	190	175	finally
    //   182	190	193	java/io/EOFException
  }

  private void readJournalLine(String paramString)
    throws IOException
  {
    String[] arrayOfString = paramString.split(" ");
    if (arrayOfString.length < 2)
      throw new IOException("unexpected journal line: " + paramString);
    String str = arrayOfString[1];
    if ((arrayOfString[0].equals("REMOVE")) && (arrayOfString.length == 2))
      this.lruEntries.remove(str);
    do
    {
      return;
      Entry localEntry = (Entry)this.lruEntries.get(str);
      if (localEntry == null)
      {
        localEntry = new Entry(str, null);
        this.lruEntries.put(str, localEntry);
      }
      if ((arrayOfString[0].equals("CLEAN")) && (arrayOfString.length == 2 + this.valueCount))
      {
        localEntry.readable = true;
        localEntry.currentEditor = null;
        localEntry.setLengths((String[])copyOfRange(arrayOfString, 2, arrayOfString.length));
        return;
      }
      if ((arrayOfString[0].equals("DIRTY")) && (arrayOfString.length == 2))
      {
        localEntry.currentEditor = new Editor(localEntry, null);
        return;
      }
    }
    while ((arrayOfString[0].equals("READ")) && (arrayOfString.length == 2));
    throw new IOException("unexpected journal line: " + paramString);
  }

  private void rebuildJournal()
    throws IOException
  {
    while (true)
    {
      BufferedWriter localBufferedWriter;
      Entry localEntry;
      try
      {
        if (this.journalWriter != null)
          this.journalWriter.close();
        localBufferedWriter = new BufferedWriter(new FileWriter(this.journalFileTmp), 8192);
        localBufferedWriter.write("libcore.io.DiskLruCache");
        localBufferedWriter.write("\n");
        localBufferedWriter.write("1");
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.appVersion));
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.valueCount));
        localBufferedWriter.write("\n");
        localBufferedWriter.write("\n");
        Iterator localIterator = this.lruEntries.values().iterator();
        if (!localIterator.hasNext())
        {
          localBufferedWriter.close();
          this.journalFileTmp.renameTo(this.journalFile);
          this.journalWriter = new BufferedWriter(new FileWriter(this.journalFile, true), 8192);
          return;
        }
        localEntry = (Entry)localIterator.next();
        if (localEntry.currentEditor != null)
        {
          localBufferedWriter.write("DIRTY " + localEntry.key + '\n');
          continue;
        }
      }
      finally
      {
      }
      localBufferedWriter.write("CLEAN " + localEntry.key + localEntry.getLengths() + '\n');
    }
  }

  private void trimToSize()
    throws IOException
  {
    while (true)
    {
      if (this.size <= this.maxSize)
        return;
      remove((String)((Map.Entry)this.lruEntries.entrySet().iterator().next()).getKey());
    }
  }

  private void validateKey(String paramString)
  {
    if ((paramString.contains(" ")) || (paramString.contains("\n")) || (paramString.contains("\r")))
      throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + paramString + "\"");
  }

  public void close()
    throws IOException
  {
    while (true)
    {
      Iterator localIterator;
      try
      {
        Writer localWriter = this.journalWriter;
        if (localWriter == null)
          return;
        localIterator = new ArrayList(this.lruEntries.values()).iterator();
        if (!localIterator.hasNext())
        {
          trimToSize();
          this.journalWriter.close();
          this.journalWriter = null;
          continue;
        }
      }
      finally
      {
      }
      Entry localEntry = (Entry)localIterator.next();
      if (localEntry.currentEditor != null)
        localEntry.currentEditor.abort();
    }
  }

  public void delete()
    throws IOException
  {
    close();
    deleteContents(this.directory);
  }

  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }

  public void flush()
    throws IOException
  {
    try
    {
      checkNotClosed();
      trimToSize();
      this.journalWriter.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  // ERROR //
  public Snapshot get(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 344	net/tsz/afinal/bitmap/core/LruDiskCache:checkNotClosed	()V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 347	net/tsz/afinal/bitmap/core/LruDiskCache:validateKey	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: getfield 82	net/tsz/afinal/bitmap/core/LruDiskCache:lruEntries	Ljava/util/LinkedHashMap;
    //   15: aload_1
    //   16: invokevirtual 350	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   19: checkcast 197	net/tsz/afinal/bitmap/core/LruDiskCache$Entry
    //   22: astore_3
    //   23: aconst_null
    //   24: astore 4
    //   26: aload_3
    //   27: ifnonnull +8 -> 35
    //   30: aload_0
    //   31: monitorexit
    //   32: aload 4
    //   34: areturn
    //   35: aload_3
    //   36: invokestatic 204	net/tsz/afinal/bitmap/core/LruDiskCache$Entry:access$1	(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)Z
    //   39: istore 5
    //   41: aconst_null
    //   42: astore 4
    //   44: iload 5
    //   46: ifeq -16 -> 30
    //   49: aload_0
    //   50: getfield 124	net/tsz/afinal/bitmap/core/LruDiskCache:valueCount	I
    //   53: anewarray 437	java/io/InputStream
    //   56: astore 6
    //   58: iconst_0
    //   59: istore 7
    //   61: aload_0
    //   62: getfield 124	net/tsz/afinal/bitmap/core/LruDiskCache:valueCount	I
    //   65: istore 9
    //   67: iload 7
    //   69: iload 9
    //   71: if_icmplt +90 -> 161
    //   74: aload_0
    //   75: iconst_1
    //   76: aload_0
    //   77: getfield 152	net/tsz/afinal/bitmap/core/LruDiskCache:redundantOpCount	I
    //   80: iadd
    //   81: putfield 152	net/tsz/afinal/bitmap/core/LruDiskCache:redundantOpCount	I
    //   84: aload_0
    //   85: getfield 130	net/tsz/afinal/bitmap/core/LruDiskCache:journalWriter	Ljava/io/Writer;
    //   88: new 212	java/lang/StringBuilder
    //   91: dup
    //   92: ldc_w 557
    //   95: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: aload_1
    //   99: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: bipush 10
    //   104: invokevirtual 229	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   107: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokevirtual 560	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   113: pop
    //   114: aload_0
    //   115: invokespecial 144	net/tsz/afinal/bitmap/core/LruDiskCache:journalRebuildRequired	()Z
    //   118: ifeq +17 -> 135
    //   121: aload_0
    //   122: getfield 102	net/tsz/afinal/bitmap/core/LruDiskCache:executorService	Ljava/util/concurrent/ExecutorService;
    //   125: aload_0
    //   126: getfield 109	net/tsz/afinal/bitmap/core/LruDiskCache:cleanupCallable	Ljava/util/concurrent/Callable;
    //   129: invokeinterface 246 2 0
    //   134: pop
    //   135: new 562	net/tsz/afinal/bitmap/core/LruDiskCache$Snapshot
    //   138: dup
    //   139: aload_0
    //   140: aload_1
    //   141: aload_3
    //   142: invokestatic 353	net/tsz/afinal/bitmap/core/LruDiskCache$Entry:access$8	(Lnet/tsz/afinal/bitmap/core/LruDiskCache$Entry;)J
    //   145: aload 6
    //   147: aconst_null
    //   148: invokespecial 565	net/tsz/afinal/bitmap/core/LruDiskCache$Snapshot:<init>	(Lnet/tsz/afinal/bitmap/core/LruDiskCache;Ljava/lang/String;J[Ljava/io/InputStream;Lnet/tsz/afinal/bitmap/core/LruDiskCache$Snapshot;)V
    //   151: astore 4
    //   153: goto -123 -> 30
    //   156: astore_2
    //   157: aload_0
    //   158: monitorexit
    //   159: aload_2
    //   160: athrow
    //   161: aload 6
    //   163: iload 7
    //   165: new 469	java/io/FileInputStream
    //   168: dup
    //   169: aload_3
    //   170: iload 7
    //   172: invokevirtual 264	net/tsz/afinal/bitmap/core/LruDiskCache$Entry:getCleanFile	(I)Ljava/io/File;
    //   175: invokespecial 471	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: aastore
    //   179: iinc 7 1
    //   182: goto -121 -> 61
    //   185: astore 8
    //   187: aconst_null
    //   188: astore 4
    //   190: goto -160 -> 30
    //
    // Exception table:
    //   from	to	target	type
    //   2	23	156	finally
    //   35	41	156	finally
    //   49	58	156	finally
    //   61	67	156	finally
    //   74	135	156	finally
    //   135	153	156	finally
    //   161	179	156	finally
    //   61	67	185	java/io/FileNotFoundException
    //   161	179	185	java/io/FileNotFoundException
  }

  public File getDirectory()
  {
    return this.directory;
  }

  public boolean isClosed()
  {
    return this.journalWriter == null;
  }

  public long maxSize()
  {
    return this.maxSize;
  }

  public boolean remove(String paramString)
    throws IOException
  {
    while (true)
    {
      Entry localEntry;
      int i;
      try
      {
        checkNotClosed();
        validateKey(paramString);
        localEntry = (Entry)this.lruEntries.get(paramString);
        if (localEntry != null)
        {
          Editor localEditor = localEntry.currentEditor;
          if (localEditor == null);
        }
        else
        {
          bool = false;
          return bool;
        }
        i = 0;
        if (i >= this.valueCount)
        {
          this.redundantOpCount = (1 + this.redundantOpCount);
          this.journalWriter.append("REMOVE " + paramString + '\n');
          this.lruEntries.remove(paramString);
          if (!journalRebuildRequired())
            break label208;
          this.executorService.submit(this.cleanupCallable);
          break label208;
        }
        File localFile = localEntry.getCleanFile(i);
        if (!localFile.delete())
          throw new IOException("failed to delete " + localFile);
      }
      finally
      {
      }
      this.size -= localEntry.lengths[i];
      localEntry.lengths[i] = 0L;
      i++;
      continue;
      label208: boolean bool = true;
    }
  }

  public long size()
  {
    try
    {
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final class Editor
  {
    private final LruDiskCache.Entry entry;
    private boolean hasErrors;

    private Editor(LruDiskCache.Entry arg2)
    {
      Object localObject;
      this.entry = localObject;
    }

    public void abort()
      throws IOException
    {
      LruDiskCache.this.completeEdit(this, false);
    }

    public void commit()
      throws IOException
    {
      if (this.hasErrors)
      {
        LruDiskCache.this.completeEdit(this, false);
        LruDiskCache.this.remove(LruDiskCache.Entry.access$2(this.entry));
        return;
      }
      LruDiskCache.this.completeEdit(this, true);
    }

    public String getString(int paramInt)
      throws IOException
    {
      InputStream localInputStream = newInputStream(paramInt);
      if (localInputStream != null)
        return LruDiskCache.inputStreamToString(localInputStream);
      return null;
    }

    public InputStream newInputStream(int paramInt)
      throws IOException
    {
      synchronized (LruDiskCache.this)
      {
        if (LruDiskCache.Entry.access$0(this.entry) != this)
          throw new IllegalStateException();
      }
      if (!LruDiskCache.Entry.access$1(this.entry))
        return null;
      FileInputStream localFileInputStream = new FileInputStream(this.entry.getCleanFile(paramInt));
      return localFileInputStream;
    }

    public OutputStream newOutputStream(int paramInt)
      throws IOException
    {
      synchronized (LruDiskCache.this)
      {
        if (LruDiskCache.Entry.access$0(this.entry) != this)
          throw new IllegalStateException();
      }
      FaultHidingOutputStream localFaultHidingOutputStream = new FaultHidingOutputStream(new FileOutputStream(this.entry.getDirtyFile(paramInt)), null);
      return localFaultHidingOutputStream;
    }

    // ERROR //
    public void set(int paramInt, String paramString)
      throws IOException
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: new 93	java/io/OutputStreamWriter
      //   5: dup
      //   6: aload_0
      //   7: iload_1
      //   8: invokevirtual 95	net/tsz/afinal/bitmap/core/LruDiskCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
      //   11: invokestatic 99	net/tsz/afinal/bitmap/core/LruDiskCache:access$7	()Ljava/nio/charset/Charset;
      //   14: invokespecial 102	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
      //   17: astore 4
      //   19: aload 4
      //   21: aload_2
      //   22: invokevirtual 108	java/io/Writer:write	(Ljava/lang/String;)V
      //   25: aload 4
      //   27: invokestatic 112	net/tsz/afinal/bitmap/core/LruDiskCache:closeQuietly	(Ljava/io/Closeable;)V
      //   30: return
      //   31: astore 5
      //   33: aload_3
      //   34: invokestatic 112	net/tsz/afinal/bitmap/core/LruDiskCache:closeQuietly	(Ljava/io/Closeable;)V
      //   37: aload 5
      //   39: athrow
      //   40: astore 5
      //   42: aload 4
      //   44: astore_3
      //   45: goto -12 -> 33
      //
      // Exception table:
      //   from	to	target	type
      //   2	19	31	finally
      //   19	25	40	finally
    }

    private class FaultHidingOutputStream extends FilterOutputStream
    {
      private FaultHidingOutputStream(OutputStream arg2)
      {
        super();
      }

      public void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          LruDiskCache.Editor.this.hasErrors = true;
        }
      }

      public void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          LruDiskCache.Editor.this.hasErrors = true;
        }
      }

      public void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          LruDiskCache.Editor.this.hasErrors = true;
        }
      }

      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException localIOException)
        {
          LruDiskCache.Editor.this.hasErrors = true;
        }
      }
    }
  }

  private final class Entry
  {
    private LruDiskCache.Editor currentEditor;
    private final String key;
    private final long[] lengths;
    private boolean readable;
    private long sequenceNumber;

    private Entry(String arg2)
    {
      Object localObject;
      this.key = localObject;
      this.lengths = new long[LruDiskCache.this.valueCount];
    }

    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }

    private void setLengths(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != LruDiskCache.this.valueCount)
        throw invalidLengths(paramArrayOfString);
      int i = 0;
      try
      {
        while (true)
        {
          if (i >= paramArrayOfString.length)
            return;
          this.lengths[i] = Long.parseLong(paramArrayOfString[i]);
          i++;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
      throw invalidLengths(paramArrayOfString);
    }

    public File getCleanFile(int paramInt)
    {
      return new File(LruDiskCache.this.directory, this.key + "." + paramInt);
    }

    public File getDirtyFile(int paramInt)
    {
      return new File(LruDiskCache.this.directory, this.key + "." + paramInt + ".tmp");
    }

    public String getLengths()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.lengths;
      int i = arrayOfLong.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          return localStringBuilder.toString();
        long l = arrayOfLong[j];
        localStringBuilder.append(' ').append(l);
      }
    }
  }

  public final class Snapshot
    implements Closeable
  {
    private final InputStream[] ins;
    private final String key;
    private final long sequenceNumber;

    private Snapshot(String paramLong, long arg3, InputStream[] arg5)
    {
      this.key = paramLong;
      this.sequenceNumber = ???;
      Object localObject;
      this.ins = localObject;
    }

    public void close()
    {
      InputStream[] arrayOfInputStream = this.ins;
      int i = arrayOfInputStream.length;
      for (int j = 0; ; j++)
      {
        if (j >= i)
          return;
        LruDiskCache.closeQuietly(arrayOfInputStream[j]);
      }
    }

    public LruDiskCache.Editor edit()
      throws IOException
    {
      return LruDiskCache.this.edit(this.key, this.sequenceNumber);
    }

    public InputStream getInputStream(int paramInt)
    {
      return this.ins[paramInt];
    }

    public String getString(int paramInt)
      throws IOException
    {
      return LruDiskCache.inputStreamToString(getInputStream(paramInt));
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.bitmap.core.LruDiskCache
 * JD-Core Version:    0.6.2
 */