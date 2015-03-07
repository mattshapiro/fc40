package u.aly;

import java.io.ByteArrayOutputStream;

public class cb extends ByteArrayOutputStream
{
  public cb()
  {
  }

  public cb(int paramInt)
  {
    super(paramInt);
  }

  public byte[] a()
  {
    return this.buf;
  }

  public int b()
  {
    return this.count;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     u.aly.cb
 * JD-Core Version:    0.6.2
 */