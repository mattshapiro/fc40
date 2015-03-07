package net.tsz.afinal.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;

public class PreferencesCookieStore
  implements CookieStore
{
  private static final String COOKIE_NAME_PREFIX = "cookie_";
  private static final String COOKIE_NAME_STORE = "names";
  private static final String COOKIE_PREFS = "CookiePrefsFile";
  private final SharedPreferences cookiePrefs;
  private final ConcurrentHashMap<String, Cookie> cookies;

  public PreferencesCookieStore(Context paramContext)
  {
    this.cookiePrefs = paramContext.getSharedPreferences("CookiePrefsFile", 0);
    this.cookies = new ConcurrentHashMap();
    String str1 = this.cookiePrefs.getString("names", null);
    String[] arrayOfString;
    int j;
    if (str1 != null)
    {
      arrayOfString = TextUtils.split(str1, ",");
      j = arrayOfString.length;
    }
    while (true)
    {
      if (i >= j)
      {
        clearExpired(new Date());
        return;
      }
      String str2 = arrayOfString[i];
      String str3 = this.cookiePrefs.getString("cookie_" + str2, null);
      if (str3 != null)
      {
        Cookie localCookie = decodeCookie(str3);
        if (localCookie != null)
          this.cookies.put(str2, localCookie);
      }
      i++;
    }
  }

  public void addCookie(Cookie paramCookie)
  {
    String str = paramCookie.getName();
    if (!paramCookie.isExpired(new Date()))
      this.cookies.put(str, paramCookie);
    while (true)
    {
      SharedPreferences.Editor localEditor = this.cookiePrefs.edit();
      localEditor.putString("names", TextUtils.join(",", this.cookies.keySet()));
      localEditor.putString("cookie_" + str, encodeCookie(new SerializableCookie(paramCookie)));
      localEditor.commit();
      return;
      this.cookies.remove(str);
    }
  }

  protected String byteArrayToHexString(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(2 * paramArrayOfByte.length);
    int i = paramArrayOfByte.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return localStringBuffer.toString().toUpperCase();
      int k = 0xFF & paramArrayOfByte[j];
      if (k < 16)
        localStringBuffer.append('0');
      localStringBuffer.append(Integer.toHexString(k));
    }
  }

  public void clear()
  {
    this.cookies.clear();
    SharedPreferences.Editor localEditor = this.cookiePrefs.edit();
    Iterator localIterator = this.cookies.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localEditor.remove("names");
        localEditor.commit();
        return;
      }
      String str = (String)localIterator.next();
      localEditor.remove("cookie_" + str);
    }
  }

  public boolean clearExpired(Date paramDate)
  {
    boolean bool = false;
    SharedPreferences.Editor localEditor = this.cookiePrefs.edit();
    Iterator localIterator = this.cookies.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        if (bool)
          localEditor.putString("names", TextUtils.join(",", this.cookies.keySet()));
        localEditor.commit();
        return bool;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (((Cookie)localEntry.getValue()).isExpired(paramDate))
      {
        this.cookies.remove(str);
        localEditor.remove("cookie_" + str);
        bool = true;
      }
    }
  }

  protected Cookie decodeCookie(String paramString)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(hexStringToByteArray(paramString));
    try
    {
      Cookie localCookie = ((SerializableCookie)new ObjectInputStream(localByteArrayInputStream).readObject()).getCookie();
      return localCookie;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  protected String encodeCookie(SerializableCookie paramSerializableCookie)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSerializableCookie);
      return byteArrayToHexString(localByteArrayOutputStream.toByteArray());
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public List<Cookie> getCookies()
  {
    return new ArrayList(this.cookies.values());
  }

  protected byte[] hexStringToByteArray(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i / 2];
    for (int j = 0; ; j += 2)
    {
      if (j >= i)
        return arrayOfByte;
      arrayOfByte[(j / 2)] = ((byte)((Character.digit(paramString.charAt(j), 16) << 4) + Character.digit(paramString.charAt(j + 1), 16)));
    }
  }

  public class SerializableCookie
    implements Serializable
  {
    private static final long serialVersionUID = 6374381828722046732L;
    private transient BasicClientCookie clientCookie;
    private final transient Cookie cookie;

    public SerializableCookie(Cookie arg2)
    {
      Object localObject;
      this.cookie = localObject;
    }

    private void readObject(ObjectInputStream paramObjectInputStream)
      throws IOException, ClassNotFoundException
    {
      this.clientCookie = new BasicClientCookie((String)paramObjectInputStream.readObject(), (String)paramObjectInputStream.readObject());
      this.clientCookie.setComment((String)paramObjectInputStream.readObject());
      this.clientCookie.setDomain((String)paramObjectInputStream.readObject());
      this.clientCookie.setExpiryDate((Date)paramObjectInputStream.readObject());
      this.clientCookie.setPath((String)paramObjectInputStream.readObject());
      this.clientCookie.setVersion(paramObjectInputStream.readInt());
      this.clientCookie.setSecure(paramObjectInputStream.readBoolean());
    }

    private void writeObject(ObjectOutputStream paramObjectOutputStream)
      throws IOException
    {
      paramObjectOutputStream.writeObject(this.cookie.getName());
      paramObjectOutputStream.writeObject(this.cookie.getValue());
      paramObjectOutputStream.writeObject(this.cookie.getComment());
      paramObjectOutputStream.writeObject(this.cookie.getDomain());
      paramObjectOutputStream.writeObject(this.cookie.getExpiryDate());
      paramObjectOutputStream.writeObject(this.cookie.getPath());
      paramObjectOutputStream.writeInt(this.cookie.getVersion());
      paramObjectOutputStream.writeBoolean(this.cookie.isSecure());
    }

    public Cookie getCookie()
    {
      Object localObject = this.cookie;
      if (this.clientCookie != null)
        localObject = this.clientCookie;
      return localObject;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     net.tsz.afinal.http.PreferencesCookieStore
 * JD-Core Version:    0.6.2
 */