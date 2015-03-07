package cn.jpush.android.service;

final class i
  implements Runnable
{
  i(g paramg, long paramLong)
  {
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   3: ifnonnull +31 -> 34
    //   6: aload_0
    //   7: getfield 14	cn/jpush/android/service/i:b	Lcn/jpush/android/service/g;
    //   10: invokestatic 30	cn/jpush/android/service/g:a	(Lcn/jpush/android/service/g;)Landroid/content/Context;
    //   13: ifnull +21 -> 34
    //   16: new 32	cn/jpush/android/data/i
    //   19: dup
    //   20: aload_0
    //   21: getfield 14	cn/jpush/android/service/i:b	Lcn/jpush/android/service/g;
    //   24: invokestatic 30	cn/jpush/android/service/g:a	(Lcn/jpush/android/service/g;)Landroid/content/Context;
    //   27: invokespecial 35	cn/jpush/android/data/i:<init>	(Landroid/content/Context;)V
    //   30: invokestatic 38	cn/jpush/android/service/g:a	(Lcn/jpush/android/data/i;)Lcn/jpush/android/data/i;
    //   33: pop
    //   34: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   37: invokevirtual 40	cn/jpush/android/data/i:a	()V
    //   40: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   43: aload_0
    //   44: getfield 16	cn/jpush/android/service/i:a	J
    //   47: iconst_0
    //   48: invokevirtual 43	cn/jpush/android/data/i:a	(JI)Landroid/database/Cursor;
    //   51: astore 6
    //   53: aload 6
    //   55: astore 5
    //   57: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   60: pop
    //   61: aload 5
    //   63: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   66: invokestatic 49	cn/jpush/android/data/i:a	(Landroid/database/Cursor;Lcn/jpush/android/data/k;)V
    //   69: iconst_1
    //   70: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   73: invokevirtual 55	cn/jpush/android/data/k:c	()I
    //   76: if_icmpne +60 -> 136
    //   79: invokestatic 59	cn/jpush/android/util/x:c	()V
    //   82: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   85: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   88: invokevirtual 61	cn/jpush/android/data/k:a	()I
    //   91: i2l
    //   92: iconst_0
    //   93: iconst_1
    //   94: iconst_0
    //   95: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   98: invokevirtual 65	cn/jpush/android/data/k:d	()Ljava/lang/String;
    //   101: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   104: invokevirtual 69	cn/jpush/android/data/k:f	()J
    //   107: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   110: invokevirtual 72	cn/jpush/android/data/k:e	()J
    //   113: invokevirtual 75	cn/jpush/android/data/i:b	(JIIILjava/lang/String;JJ)Z
    //   116: pop
    //   117: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   120: invokevirtual 77	cn/jpush/android/data/i:b	()V
    //   123: aload 5
    //   125: ifnull +10 -> 135
    //   128: aload 5
    //   130: invokeinterface 82 1 0
    //   135: return
    //   136: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   139: invokevirtual 84	cn/jpush/android/data/k:b	()I
    //   142: iconst_1
    //   143: if_icmple +67 -> 210
    //   146: invokestatic 59	cn/jpush/android/util/x:c	()V
    //   149: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   152: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   155: invokevirtual 61	cn/jpush/android/data/k:a	()I
    //   158: i2l
    //   159: iconst_m1
    //   160: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   163: invokevirtual 84	cn/jpush/android/data/k:b	()I
    //   166: iadd
    //   167: iconst_0
    //   168: iconst_0
    //   169: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   172: invokevirtual 65	cn/jpush/android/data/k:d	()Ljava/lang/String;
    //   175: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   178: invokevirtual 69	cn/jpush/android/data/k:f	()J
    //   181: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   184: invokevirtual 72	cn/jpush/android/data/k:e	()J
    //   187: invokevirtual 75	cn/jpush/android/data/i:b	(JIIILjava/lang/String;JJ)Z
    //   190: pop
    //   191: goto -74 -> 117
    //   194: astore 7
    //   196: aload 5
    //   198: astore_2
    //   199: aload_2
    //   200: ifnull -65 -> 135
    //   203: aload_2
    //   204: invokeinterface 82 1 0
    //   209: return
    //   210: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   213: invokevirtual 84	cn/jpush/android/data/k:b	()I
    //   216: iconst_1
    //   217: if_icmpne +113 -> 330
    //   220: invokestatic 59	cn/jpush/android/util/x:c	()V
    //   223: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   226: lstore 9
    //   228: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   231: invokevirtual 69	cn/jpush/android/data/k:f	()J
    //   234: lload 9
    //   236: lcmp
    //   237: ifle +26 -> 263
    //   240: invokestatic 59	cn/jpush/android/util/x:c	()V
    //   243: goto -126 -> 117
    //   246: astore 4
    //   248: aload 5
    //   250: ifnull +10 -> 260
    //   253: aload 5
    //   255: invokeinterface 82 1 0
    //   260: aload 4
    //   262: athrow
    //   263: aload_0
    //   264: getfield 14	cn/jpush/android/service/i:b	Lcn/jpush/android/service/g;
    //   267: aload_0
    //   268: getfield 14	cn/jpush/android/service/i:b	Lcn/jpush/android/service/g;
    //   271: invokestatic 30	cn/jpush/android/service/g:a	(Lcn/jpush/android/service/g;)Landroid/content/Context;
    //   274: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   277: invokevirtual 65	cn/jpush/android/data/k:d	()Ljava/lang/String;
    //   280: aload_0
    //   281: getfield 14	cn/jpush/android/service/i:b	Lcn/jpush/android/service/g;
    //   284: invokestatic 92	cn/jpush/android/service/g:b	(Lcn/jpush/android/service/g;)Ljava/lang/String;
    //   287: ldc 94
    //   289: invokestatic 97	cn/jpush/android/service/g:a	(Lcn/jpush/android/service/g;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   292: invokestatic 27	cn/jpush/android/service/g:a	()Lcn/jpush/android/data/i;
    //   295: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   298: invokevirtual 61	cn/jpush/android/data/k:a	()I
    //   301: i2l
    //   302: iconst_0
    //   303: iconst_0
    //   304: iconst_0
    //   305: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   308: invokevirtual 65	cn/jpush/android/data/k:d	()Ljava/lang/String;
    //   311: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   314: invokevirtual 69	cn/jpush/android/data/k:f	()J
    //   317: invokestatic 46	cn/jpush/android/service/g:b	()Lcn/jpush/android/data/k;
    //   320: invokevirtual 72	cn/jpush/android/data/k:e	()J
    //   323: invokevirtual 75	cn/jpush/android/data/i:b	(JIIILjava/lang/String;JJ)Z
    //   326: pop
    //   327: goto -210 -> 117
    //   330: invokestatic 59	cn/jpush/android/util/x:c	()V
    //   333: goto -216 -> 117
    //   336: astore_3
    //   337: aload_3
    //   338: astore 4
    //   340: aconst_null
    //   341: astore 5
    //   343: goto -95 -> 248
    //   346: astore_1
    //   347: aconst_null
    //   348: astore_2
    //   349: goto -150 -> 199
    //
    // Exception table:
    //   from	to	target	type
    //   57	117	194	java/lang/Exception
    //   117	123	194	java/lang/Exception
    //   136	191	194	java/lang/Exception
    //   210	243	194	java/lang/Exception
    //   263	327	194	java/lang/Exception
    //   330	333	194	java/lang/Exception
    //   57	117	246	finally
    //   117	123	246	finally
    //   136	191	246	finally
    //   210	243	246	finally
    //   263	327	246	finally
    //   330	333	246	finally
    //   34	53	336	finally
    //   34	53	346	java/lang/Exception
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.i
 * JD-Core Version:    0.6.2
 */