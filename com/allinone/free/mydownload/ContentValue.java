package com.allinone.free.mydownload;

public abstract interface ContentValue
{
  public static final String CACHE_DIR = "cacheDir";
  public static final String DBNAME = "download.db";
  public static final int DOWNLOAD_DB = 13;
  public static final int DOWNLOAD_STATE_CLEAR = 9;
  public static final int DOWNLOAD_STATE_DELETE = 8;
  public static final int DOWNLOAD_STATE_DOWNLOADING = 2;
  public static final int DOWNLOAD_STATE_EXCLOUDDOWNLOAD = 12;
  public static final int DOWNLOAD_STATE_FAIL = 5;
  public static final int DOWNLOAD_STATE_NONE = 0;
  public static final int DOWNLOAD_STATE_START = 7;
  public static final int DOWNLOAD_STATE_SUCCESS = 6;
  public static final int DOWNLOAD_STATE_SUSPEND = 3;
  public static final int DOWNLOAD_STATE_WATTING = 4;
  public static final String DOWNLOAD_TAG_BY_INTENT = "downloadurl";
  public static final String DOWNLOAD_TYPE = "downloadType";
  public static final int ERROR_CODE = -1;
  public static final String SERVICE_TYPE_NAME = "servicetype";
  public static final int START_DOWNLOAD_ALLSUSPEND = 11;
  public static final int START_DOWNLOAD_LOADITEM = 10;
  public static final int START_DOWNLOAD_MOVIE = 99;
  public static final String TABNAME_DOWNLOADTASK = "downloadtask";
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.mydownload.ContentValue
 * JD-Core Version:    0.6.2
 */