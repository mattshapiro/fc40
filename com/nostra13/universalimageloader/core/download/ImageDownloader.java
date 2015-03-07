package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;

public abstract interface ImageDownloader
{
  public abstract InputStream getStream(String paramString, Object paramObject)
    throws IOException;

  public static enum Scheme
  {
    private String scheme;
    private String uriPrefix;

    static
    {
      FILE = new Scheme("FILE", 2, "file");
      CONTENT = new Scheme("CONTENT", 3, "content");
      ASSETS = new Scheme("ASSETS", 4, "assets");
      DRAWABLE = new Scheme("DRAWABLE", 5, "drawable");
      UNKNOWN = new Scheme("UNKNOWN", 6, "");
      Scheme[] arrayOfScheme = new Scheme[7];
      arrayOfScheme[0] = HTTP;
      arrayOfScheme[1] = HTTPS;
      arrayOfScheme[2] = FILE;
      arrayOfScheme[3] = CONTENT;
      arrayOfScheme[4] = ASSETS;
      arrayOfScheme[5] = DRAWABLE;
      arrayOfScheme[6] = UNKNOWN;
    }

    private Scheme(String arg3)
    {
      Object localObject;
      this.scheme = localObject;
      this.uriPrefix = (localObject + "://");
    }

    private boolean belongsTo(String paramString)
    {
      return paramString.startsWith(this.uriPrefix);
    }

    public static Scheme ofUri(String paramString)
    {
      Scheme[] arrayOfScheme;
      int i;
      if (paramString != null)
      {
        arrayOfScheme = values();
        i = arrayOfScheme.length;
      }
      for (int j = 0; ; j++)
      {
        Scheme localScheme;
        if (j >= i)
          localScheme = UNKNOWN;
        do
        {
          return localScheme;
          localScheme = arrayOfScheme[j];
        }
        while (localScheme.belongsTo(paramString));
      }
    }

    public String crop(String paramString)
    {
      if (!belongsTo(paramString))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramString;
        arrayOfObject[1] = this.scheme;
        throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", arrayOfObject));
      }
      return paramString.substring(this.uriPrefix.length());
    }

    public String wrap(String paramString)
    {
      return this.uriPrefix + paramString;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.download.ImageDownloader
 * JD-Core Version:    0.6.2
 */