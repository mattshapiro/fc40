package com.umeng.message.proguard;

import java.io.IOException;

public class s extends IOException
{
  private static final long a = -1616151763072450476L;
  private y b = null;

  public s(String paramString)
  {
    super(paramString);
  }

  static s b()
  {
    return new s("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
  }

  static s c()
  {
    return new s("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
  }

  static s d()
  {
    return new s("CodedInputStream encountered a malformed varint.");
  }

  static s e()
  {
    return new s("Protocol message contained an invalid tag (zero).");
  }

  static s f()
  {
    return new s("Protocol message end-group tag did not match expected tag.");
  }

  static s g()
  {
    return new s("Protocol message tag had invalid wire type.");
  }

  static s h()
  {
    return new s("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
  }

  static s i()
  {
    return new s("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
  }

  public s a(y paramy)
  {
    this.b = paramy;
    return this;
  }

  public y a()
  {
    return this.b;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.s
 * JD-Core Version:    0.6.2
 */