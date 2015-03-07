package com.nostra13.universalimageloader.core.decode;

import android.graphics.Bitmap;
import java.io.IOException;

public abstract interface ImageDecoder
{
  public abstract Bitmap decode(ImageDecodingInfo paramImageDecodingInfo)
    throws IOException;
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.ImageDecoder
 * JD-Core Version:    0.6.2
 */