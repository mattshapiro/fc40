package com.allinone.free.mydownload;

import android.graphics.Bitmap;
import java.io.Serializable;
import net.tsz.afinal.annotation.sqlite.Table;

@Table(name="downloadtask")
public class DownloadMovieItem
  implements Serializable
{
  private static final long serialVersionUID = 12L;
  private String album_title;
  private String artist_title;
  private String author_title;
  private String cat;
  private Long create_time;
  private Long currentProgress = Long.valueOf(0L);
  private String detail;
  private DownloadFile downloadFile;
  private Integer downloadState = Integer.valueOf(0);
  private String downloadUrl;
  private String downloads;
  private boolean editState;
  private String filePath;
  private String fileSize;
  private String file_id;
  private String has_apk;
  private int has_next_page;
  private String icon;
  private String id;
  private boolean isSelected;
  private Bitmap movieHeadImage;
  private String movieHeadImagePath;
  private String movieId;
  private String movieName;
  private String percentage = "%0";
  private int position;
  private String ppshort_desc;
  private String price;
  private Long progressCount = Long.valueOf(0L);
  private Float rating;
  private String release_date;
  private String screenshots;
  private String serial;
  private String setCount;
  private String size;
  private String title;
  private String type;
  private Long uuid;
  private String version;

  public static long getSerialversionuid()
  {
    return 12L;
  }

  public String getAlbum_title()
  {
    return this.album_title;
  }

  public String getArtist_title()
  {
    return this.artist_title;
  }

  public String getAuthor_title()
  {
    return this.author_title;
  }

  public String getCat()
  {
    return this.cat;
  }

  public Long getCreate_time()
  {
    return this.create_time;
  }

  public Long getCurrentProgress()
  {
    return this.currentProgress;
  }

  public String getDetail()
  {
    return this.detail;
  }

  public DownloadFile getDownloadFile()
  {
    return this.downloadFile;
  }

  public Integer getDownloadState()
  {
    return this.downloadState;
  }

  public String getDownloadUrl()
  {
    return this.downloadUrl;
  }

  public String getDownloads()
  {
    return this.downloads;
  }

  public String getFilePath()
  {
    return this.filePath;
  }

  public String getFileSize()
  {
    return this.fileSize;
  }

  public String getFile_id()
  {
    return this.file_id;
  }

  public String getHas_apk()
  {
    return this.has_apk;
  }

  public int getHas_next_page()
  {
    return this.has_next_page;
  }

  public String getIcon()
  {
    return this.icon;
  }

  public String getId()
  {
    return this.id;
  }

  public Bitmap getMovieHeadImage()
  {
    return this.movieHeadImage;
  }

  public String getMovieHeadImagePath()
  {
    return this.movieHeadImagePath;
  }

  public String getMovieId()
  {
    return this.movieId;
  }

  public String getMovieName()
  {
    return this.movieName;
  }

  public String getPercentage()
  {
    return this.percentage;
  }

  public int getPosition()
  {
    return this.position;
  }

  public String getPpshort_desc()
  {
    return this.ppshort_desc;
  }

  public String getPrice()
  {
    return this.price;
  }

  public Long getProgressCount()
  {
    return this.progressCount;
  }

  public Float getRating()
  {
    return this.rating;
  }

  public String getRelease_date()
  {
    return this.release_date;
  }

  public String getScreenshots()
  {
    return this.screenshots;
  }

  public String getSerial()
  {
    return this.serial;
  }

  public String getSetCount()
  {
    return this.setCount;
  }

  public String getShort_desc()
  {
    return this.ppshort_desc;
  }

  public String getSize()
  {
    return this.size;
  }

  public String getTitle()
  {
    return this.title;
  }

  public String getType()
  {
    return this.type;
  }

  public Long getUuid()
  {
    return this.uuid;
  }

  public String getVersion()
  {
    return this.version;
  }

  public boolean isEditState()
  {
    return this.editState;
  }

  public boolean isSelected()
  {
    return this.isSelected;
  }

  public void setAlbum_title(String paramString)
  {
    this.album_title = paramString;
  }

  public void setArtist_title(String paramString)
  {
    this.artist_title = paramString;
  }

  public void setAuthor_title(String paramString)
  {
    this.author_title = paramString;
  }

  public void setCat(String paramString)
  {
    this.cat = paramString;
  }

  public void setCreate_time(Long paramLong)
  {
    this.create_time = paramLong;
  }

  public void setCurrentProgress(Long paramLong)
  {
    this.currentProgress = paramLong;
  }

  public void setDetail(String paramString)
  {
    this.detail = paramString;
  }

  public void setDownloadFile(DownloadFile paramDownloadFile)
  {
    this.downloadFile = paramDownloadFile;
  }

  public void setDownloadState(Integer paramInteger)
  {
    this.downloadState = paramInteger;
  }

  public void setDownloadUrl(String paramString)
  {
    this.downloadUrl = paramString;
  }

  public void setDownloads(String paramString)
  {
    this.downloads = paramString;
  }

  public void setEditState(boolean paramBoolean)
  {
    this.editState = paramBoolean;
  }

  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }

  public void setFileSize(String paramString)
  {
    this.fileSize = paramString;
  }

  public void setFile_id(String paramString)
  {
    this.file_id = paramString;
  }

  public void setHas_apk(String paramString)
  {
    this.has_apk = paramString;
  }

  public void setHas_next_page(int paramInt)
  {
    this.has_next_page = paramInt;
  }

  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setMovieHeadImage(Bitmap paramBitmap)
  {
    this.movieHeadImage = paramBitmap;
  }

  public void setMovieHeadImagePath(String paramString)
  {
    this.movieHeadImagePath = paramString;
  }

  public void setMovieId(String paramString)
  {
    this.movieId = paramString;
  }

  public void setMovieName(String paramString)
  {
    this.movieName = paramString;
  }

  public void setPercentage(String paramString)
  {
    this.percentage = paramString;
  }

  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }

  public void setPpshort_desc(String paramString)
  {
    this.ppshort_desc = paramString;
  }

  public void setPrice(String paramString)
  {
    this.price = paramString;
  }

  public void setProgressCount(Long paramLong)
  {
    this.progressCount = paramLong;
  }

  public void setRating(Float paramFloat)
  {
    this.rating = paramFloat;
  }

  public void setRelease_date(String paramString)
  {
    this.release_date = paramString;
  }

  public void setScreenshots(String paramString)
  {
    this.screenshots = paramString;
  }

  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }

  public void setSerial(String paramString)
  {
    this.serial = paramString;
  }

  public void setSetCount(String paramString)
  {
    this.setCount = paramString;
  }

  public void setShort_desc(String paramString)
  {
    this.ppshort_desc = paramString;
  }

  public void setSize(String paramString)
  {
    this.size = paramString;
  }

  public void setTitle(String paramString)
  {
    this.title = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setUuid(Long paramLong)
  {
    this.uuid = paramLong;
  }

  public void setVersion(String paramString)
  {
    this.version = paramString;
  }

  public String toString()
  {
    return "DownloadMovieItem [progressCount=" + this.progressCount + ", currentProgress=" + this.currentProgress + ", downloadState=" + this.downloadState + ", editState=" + this.editState + ", movieHeadImage=" + this.movieHeadImage + ", fileSize=" + this.fileSize + ", movieName=" + this.movieName + "]";
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.mydownload.DownloadMovieItem
 * JD-Core Version:    0.6.2
 */