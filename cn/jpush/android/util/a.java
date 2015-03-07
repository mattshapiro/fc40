package cn.jpush.android.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.InstrumentedListActivity;
import cn.jpush.android.data.d;
import cn.jpush.android.service.AlarmReceiver;
import cn.jpush.android.service.DownloadService;
import cn.jpush.android.service.PushReceiver;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.service.q;
import cn.jpush.android.service.r;
import cn.jpush.android.ui.PushActivity;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.security.auth.x500.X500Principal;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static int a;
  private static List<String> b;
  private static final X500Principal c;
  private static final String d;
  private static final String e;
  private static final String f;
  private static final ArrayList<String> g;
  private static final ArrayList<String> h;
  private static final ArrayList<String> i;
  private static PushReceiver j;
  private static final String[] z;

  static
  {
    String[] arrayOfString1 = new String[''];
    int k = 0;
    String[] arrayOfString2 = arrayOfString1;
    String str1 = "^k.*ZGj9";
    int m = -1;
    String str2;
    while (true)
    {
      str2 = z(z(str1));
      switch (m)
      {
      default:
        arrayOfString2[k] = str2;
        str1 = "Fo1\020";
        k = 1;
        arrayOfString2 = arrayOfString1;
        m = 0;
        break;
      case 0:
        arrayOfString2[k] = str2;
        str1 = "Xe;";
        k = 2;
        arrayOfString2 = arrayOfString1;
        m = 1;
        break;
      case 1:
        arrayOfString2[k] = str2;
        k = 3;
        arrayOfString2 = arrayOfString1;
        str1 = "^k.*WIc9";
        m = 2;
        break;
      case 2:
        arrayOfString2[k] = str2;
        k = 4;
        str1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \0214pf";
        m = 3;
        arrayOfString2 = arrayOfString1;
        break;
      case 3:
        arrayOfString2[k] = str2;
        k = 5;
        str1 = "I`8\007VAjr\034W\\k2\001\027Ko(\020^G|%[ui[\0226qm\\";
        m = 4;
        arrayOfString2 = arrayOfString1;
        break;
      case 4:
        arrayOfString2[k] = str2;
        k = 6;
        str1 = "Ka2\033\\Kz5\003P\\w";
        m = 5;
        arrayOfString2 = arrayOfString1;
        break;
      case 5:
        arrayOfString2[k] = str2;
        str1 = "I`8\007VAjr\005\\Zc5\006JAa2[nzG\b0fmV\b0kfO\020*j|A\0164~m";
        m = 6;
        k = 7;
        arrayOfString2 = arrayOfString1;
        break;
      case 6:
        arrayOfString2[k] = str2;
        k = 8;
        arrayOfString2 = arrayOfString1;
        str1 = "Mc,\001@\b~=\007XE}";
        m = 7;
        break;
      case 7:
        arrayOfString2[k] = str2;
        k = 9;
        str1 = "oa(UJLm=\007]\bh5\031\\\b}=\003\\L.8\020OAm9<]\b#|";
        m = 8;
        arrayOfString2 = arrayOfString1;
        break;
      case 8:
        arrayOfString2[k] = str2;
        k = 10;
        str1 = "Kf=\033WMb";
        m = 9;
        arrayOfString2 = arrayOfString1;
        break;
      case 9:
        arrayOfString2[k] = str2;
        k = 11;
        str1 = "Lk*\034ZM";
        m = 10;
        arrayOfString2 = arrayOfString1;
        break;
      case 10:
        arrayOfString2[k] = str2;
        k = 12;
        str1 = "I`8\007VAj\017\021R~k.\006PG`";
        m = 11;
        arrayOfString2 = arrayOfString1;
        break;
      case 11:
        arrayOfString2[k] = str2;
        k = 13;
        str1 = "Ea8\020U";
        m = 12;
        arrayOfString2 = arrayOfString1;
        break;
      case 12:
        arrayOfString2[k] = str2;
        k = 14;
        str1 = "Jo/\020[I`8";
        m = 13;
        arrayOfString2 = arrayOfString1;
        break;
      case 13:
        arrayOfString2[k] = str2;
        k = 15;
        str1 = "Fk(\002VZe";
        m = 14;
        arrayOfString2 = arrayOfString1;
        break;
      case 14:
        arrayOfString2[k] = str2;
        k = 16;
        str1 = "]|0";
        m = 15;
        arrayOfString2 = arrayOfString1;
        break;
      case 15:
        arrayOfString2[k] = str2;
        k = 17;
        str1 = "O}1[OM|/\034VF >\024JMl=\033]";
        m = 16;
        arrayOfString2 = arrayOfString1;
        break;
      case 16:
        arrayOfString2[k] = str2;
        k = 18;
        str1 = "Xf3\033\\";
        m = 17;
        arrayOfString2 = arrayOfString1;
        break;
      case 17:
        arrayOfString2[k] = str2;
        k = 19;
        str1 = "I`8\007VAjr\005\\Zc5\006JAa2[kmO\030*i`A\0220f{Z\035!|";
        m = 18;
        arrayOfString2 = arrayOfString1;
        break;
      case 18:
        arrayOfString2[k] = str2;
        k = 20;
        str1 = "Kb3\006\\X{/\035";
        m = 19;
        arrayOfString2 = arrayOfString1;
        break;
      case 19:
        arrayOfString2[k] = str2;
        k = 21;
        str1 = "X{/\035\031\\g1\020\031A}|ｯ";
        m = 20;
        arrayOfString2 = arrayOfString1;
        break;
      case 20:
        arrayOfString2[k] = str2;
        k = 22;
        str1 = "tP";
        m = 21;
        arrayOfString2 = arrayOfString1;
        break;
      case 21:
        arrayOfString2[k] = str2;
        k = 23;
        str1 = "X{/\035MAc9";
        m = 22;
        arrayOfString2 = arrayOfString1;
        break;
      case 22:
        arrayOfString2[k] = str2;
        k = 24;
        str1 = "og*\020\031]~|\001V\b}(\024K\\.=\005I\bh3\007\031A`*\024UAj|\005XZo1\006\031\005.,\024ZCo;\020wIc9O";
        m = 23;
        arrayOfString2 = arrayOfString1;
        break;
      case 23:
        arrayOfString2[k] = str2;
        k = 25;
        str1 = "f[\0209\031Ka2\001\\Pz";
        m = 24;
        arrayOfString2 = arrayOfString1;
        break;
      case 24:
        arrayOfString2[k] = str2;
        k = 26;
        str1 = "zk0\020X[k|\002XCk|\031VKe|\024_\\k.U\f\030>l\030J\022";
        m = 25;
        arrayOfString2 = arrayOfString1;
        break;
      case 25:
        arrayOfString2[k] = str2;
        k = 27;
        str1 = "eJi";
        m = 26;
        arrayOfString2 = arrayOfString1;
        break;
      case 26:
        arrayOfString2[k] = str2;
        k = 28;
        str1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \n<|";
        m = 27;
        arrayOfString2 = arrayOfString1;
        break;
      case 27:
        arrayOfString2[k] = str2;
        k = 29;
        str1 = "I~,\031PKo(\034VF!*\033]\006o2\021KGg8[IIm7\024^M#=\007Z@g*\020";
        m = 28;
        arrayOfString2 = arrayOfString1;
        break;
      case 28:
        arrayOfString2[k] = str2;
        k = 30;
        str1 = "\034i";
        m = 29;
        arrayOfString2 = arrayOfString1;
        break;
      case 29:
        arrayOfString2[k] = str2;
        k = 31;
        str1 = "\033i";
        m = 30;
        arrayOfString2 = arrayOfString1;
        break;
      case 30:
        arrayOfString2[k] = str2;
        k = 32;
        str1 = "_g:\034";
        m = 31;
        arrayOfString2 = arrayOfString1;
        break;
      case 31:
        arrayOfString2[k] = str2;
        k = 33;
        str1 = "F{0\031";
        m = 32;
        arrayOfString2 = arrayOfString1;
        break;
      case 32:
        arrayOfString2[k] = str2;
        k = 34;
        str1 = "\032i";
        m = 33;
        arrayOfString2 = arrayOfString1;
        break;
      case 33:
        arrayOfString2[k] = str2;
        k = 35;
        str1 = "I`8\007VAjr\005\\Zc5\006JAa2[nzG\b0f{K\b!pfI\017";
        m = 34;
        arrayOfString2 = arrayOfString1;
        break;
      case 34:
        arrayOfString2[k] = str2;
        k = 36;
        str1 = "b^)\006QwJ9\003PKk\025\021";
        m = 35;
        arrayOfString2 = arrayOfString1;
        break;
      case 35:
        arrayOfString2[k] = str2;
        k = 37;
        str1 = "K`r\037I]}4[XFj.\032PL \031-mzO";
        m = 36;
        arrayOfString2 = arrayOfString1;
        break;
      case 36:
        arrayOfString2[k] = str2;
        k = 38;
        str1 = "ko2UWGz|\022\\\\.,\024ZCo;\020\031Fo1\020\027";
        m = 37;
        arrayOfString2 = arrayOfString1;
        break;
      case 37:
        arrayOfString2[k] = str2;
        k = 39;
        str1 = "i`8\007VAj\t\001PD";
        m = 38;
        arrayOfString2 = arrayOfString1;
        break;
      case 38:
        arrayOfString2[k] = str2;
        k = 40;
        str1 = "\r}r\005\\Zc5\006JAa2[sx[\017=feK\017&xoK";
        m = 39;
        arrayOfString2 = arrayOfString1;
        break;
      case 39:
        arrayOfString2[k] = str2;
        k = 41;
        str1 = "Xb)\022^Mj";
        m = 40;
        arrayOfString2 = arrayOfString1;
        break;
      case 40:
        arrayOfString2[k] = str2;
        k = 42;
        str1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \0364m|K\016,fkF\035;~mJ";
        m = 41;
        arrayOfString2 = arrayOfString1;
        break;
      case 41:
        arrayOfString2[k] = str2;
        k = 43;
        str1 = "[z=\001L[";
        m = 42;
        arrayOfString2 = arrayOfString1;
        break;
      case 42:
        arrayOfString2[k] = str2;
        k = 44;
        str1 = "";
        m = 43;
        arrayOfString2 = arrayOfString1;
        break;
      case 43:
        arrayOfString2[k] = str2;
        k = 45;
        str1 = "b^)\006Q揸礴ｆ罏尨绷讯亿硴";
        m = 44;
        arrayOfString2 = arrayOfString1;
        break;
      case 44:
        arrayOfString2[k] = str2;
        k = 46;
        str1 = "\\w,\020";
        m = 45;
        arrayOfString2 = arrayOfString1;
        break;
      case 45:
        arrayOfString2[k] = str2;
        k = 47;
        str1 = "Fa(\034_Am=\001PG`";
        m = 46;
        arrayOfString2 = arrayOfString1;
        break;
      case 46:
        arrayOfString2[k] = str2;
        k = 48;
        str1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([wgZ\0253pkO\b<vfQ\023%|fK\030*izA\004,";
        m = 47;
        arrayOfString2 = arrayOfString1;
        break;
      case 47:
        arrayOfString2[k] = str2;
        k = 49;
        str1 = "棨浅剬隳戩\b]\030>\031朂淵勼纪讘介砏ぞ烌凂柍眅论悰";
        m = 48;
        arrayOfString2 = arrayOfString1;
        break;
      case 48:
        arrayOfString2[k] = str2;
        k = 50;
        str1 = "Im(\034OAz%";
        m = 49;
        arrayOfString2 = arrayOfString1;
        break;
      case 49:
        arrayOfString2[k] = str2;
        k = 51;
        str1 = "aC\031<";
        m = 50;
        arrayOfString2 = arrayOfString1;
        break;
      case 50:
        arrayOfString2[k] = str2;
        k = 52;
        str1 = "oa(UJLm=\007]\bh5\031\\\b}=\003\\L.)\021PL.qU";
        m = 51;
        arrayOfString2 = arrayOfString1;
        break;
      case 51:
        arrayOfString2[k] = str2;
        k = 53;
        str1 = "x|9\023Jng0\020";
        m = 52;
        arrayOfString2 = arrayOfString1;
        break;
      case 52:
        arrayOfString2[k] = str2;
        k = 54;
        str1 = "X{/\035f]j5\021";
        m = 53;
        arrayOfString2 = arrayOfString1;
        break;
      case 53:
        arrayOfString2[k] = str2;
        k = 55;
        str1 = "Ck%";
        m = 54;
        arrayOfString2 = arrayOfString1;
        break;
      case 54:
        arrayOfString2[k] = str2;
        k = 56;
        str1 = "Xa+\020K";
        m = 55;
        arrayOfString2 = arrayOfString1;
        break;
      case 55:
        arrayOfString2[k] = str2;
        k = 57;
        str1 = "x{/\035";
        m = 56;
        arrayOfString2 = arrayOfString1;
        break;
      case 56:
        arrayOfString2[k] = str2;
        k = 58;
        str1 = "Lo(\024";
        m = 57;
        arrayOfString2 = arrayOfString1;
        break;
      case 57:
        arrayOfString2[k] = str2;
        k = 59;
        str1 = "Az5\030\\";
        m = 58;
        arrayOfString2 = arrayOfString1;
        break;
      case 58:
        arrayOfString2[k] = str2;
        k = 60;
        str1 = "b^\t&qwO\f%rmW";
        m = 59;
        arrayOfString2 = arrayOfString1;
        break;
      case 59:
        arrayOfString2[k] = str2;
        k = 61;
        str1 = "";
        m = 60;
        arrayOfString2 = arrayOfString1;
        break;
      case 60:
        arrayOfString2[k] = str2;
        k = 62;
        str1 = "";
        m = 61;
        arrayOfString2 = arrayOfString1;
        break;
      case 61:
        arrayOfString2[k] = str2;
        k = 63;
        str1 = "ok2\020KIz9U}Mx5\026\\aj|\006LKm9\006J\b";
        m = 62;
        arrayOfString2 = arrayOfString1;
        break;
      case 62:
        arrayOfString2[k] = str2;
        k = 64;
        str1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([wgZ\0253pkO\b<vfQ\0160zmG\n0}w^\016:aq";
        m = 63;
        arrayOfString2 = arrayOfString1;
        break;
      case 63:
        arrayOfString2[k] = str2;
        k = 65;
        str1 = "I`8\007VAjr\033\\\\ ?\032WF \037:wfK\037!p~G\b,fkF\035;~m";
        m = 64;
        arrayOfString2 = arrayOfString1;
        break;
      case 64:
        arrayOfString2[k] = str2;
        k = 66;
        str1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \f4zcO\0330fzK\021:omJ";
        m = 65;
        arrayOfString2 = arrayOfString1;
        break;
      case 65:
        arrayOfString2[k] = str2;
        k = 67;
        str1 = "Xo?\036XOk";
        m = 66;
        arrayOfString2 = arrayOfString1;
        break;
      case 66:
        arrayOfString2[k] = str2;
        k = 68;
        str1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \t&|zQ\f'|{K\022!";
        m = 67;
        arrayOfString2 = arrayOfString1;
        break;
      case 67:
        arrayOfString2[k] = str2;
        k = 69;
        str1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \f4zcO\0330fiJ\0300}";
        m = 68;
        arrayOfString2 = arrayOfString1;
        break;
      case 68:
        arrayOfString2[k] = str2;
        k = 70;
        str1 = "eo5\033\031Kb=\006J\bg/U";
        m = 69;
        arrayOfString2 = arrayOfString1;
        break;
      case 69:
        arrayOfString2[k] = str2;
        k = 71;
        str1 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwY\0253pw]\b4mm";
        m = 70;
        arrayOfString2 = arrayOfString1;
        break;
      case 70:
        arrayOfString2[k] = str2;
        k = 72;
        str1 = "K`r\037I]}4[XFj.\032PL )\034\027x{/\035xKz5\003P\\w";
        m = 71;
        arrayOfString2 = arrayOfString1;
        break;
      case 71:
        arrayOfString2[k] = str2;
        k = 73;
        str1 = "Ja8\f";
        m = 72;
        arrayOfString2 = arrayOfString1;
        break;
      case 72:
        arrayOfString2[k] = str2;
        k = 74;
        str1 = "A}\t\005]Iz9#\\Z}5\032W";
        m = 73;
        arrayOfString2 = arrayOfString1;
        break;
      case 73:
        arrayOfString2[k] = str2;
        k = 75;
        str1 = "K`r\037I]}4[XFj.\032PL \035%icK\005";
        m = 74;
        arrayOfString2 = arrayOfString1;
        break;
      case 74:
        arrayOfString2[k] = str2;
        k = 76;
        str1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([tm]\0174~mQ\0160zmG\n0}";
        m = 75;
        arrayOfString2 = arrayOfString1;
        break;
      case 75:
        arrayOfString2[k] = str2;
        k = 77;
        str1 = "K`r\037I]}4[XFj.\032PL \0210j{O\0330";
        m = 76;
        arrayOfString2 = arrayOfString1;
        break;
      case 76:
        arrayOfString2[k] = str2;
        k = 78;
        str1 = "{k2\021\031J|3\024]Ko/\001\031\\a|\024IX4|";
        m = 77;
        arrayOfString2 = arrayOfString1;
        break;
      case 77:
        arrayOfString2[k] = str2;
        k = 79;
        str1 = "K`r\037I]}4[XFj.\032PL \021&~wG\030";
        m = 78;
        arrayOfString2 = arrayOfString1;
        break;
      case 78:
        arrayOfString2[k] = str2;
        k = 80;
        str1 = "K`r\037I]}4[XFj.\032PL \037:w|K\022!f|W\f0";
        m = 79;
        arrayOfString2 = arrayOfString1;
        break;
      case 79:
        arrayOfString2[k] = str2;
        k = 81;
        str1 = "K`r\037I]}4[XFj.\032PL \032<umQ\f4m`";
        m = 80;
        arrayOfString2 = arrayOfString1;
        break;
      case 80:
        arrayOfString2[k] = str2;
        k = 82;
        str1 = "K`r\037I]}4[XFj.\032PL \b<mdK";
        m = 81;
        arrayOfString2 = arrayOfString1;
        break;
      case 81:
        arrayOfString2[k] = str2;
        k = 83;
        str1 = "}`7\033V_`";
        m = 82;
        arrayOfString2 = arrayOfString1;
        break;
      case 82:
        arrayOfString2[k] = str2;
        k = 84;
        str1 = "]z:X\001";
        m = 83;
        arrayOfString2 = arrayOfString1;
        break;
      case 83:
        arrayOfString2[k] = str2;
        k = 85;
        str1 = "Ea)\033MMj";
        m = 84;
        arrayOfString2 = arrayOfString1;
        break;
      case 84:
        arrayOfString2[k] = str2;
        k = 86;
        str1 = "I`8\007VAj\003\034]";
        m = 85;
        arrayOfString2 = arrayOfString1;
        break;
      case 85:
        arrayOfString2[k] = str2;
        k = 87;
        str1 = "";
        m = 86;
        arrayOfString2 = arrayOfString1;
        break;
      case 86:
        arrayOfString2[k] = str2;
        k = 88;
        str1 = "x|3\026\\[}3\007";
        m = 87;
        arrayOfString2 = arrayOfString1;
        break;
      case 87:
        arrayOfString2[k] = str2;
        k = 89;
        str1 = "\\a=\006M|k$\001";
        m = 88;
        arrayOfString2 = arrayOfString1;
        break;
      case 88:
        arrayOfString2[k] = str2;
        k = 90;
        str1 = "b^)\006Q揸礴ｆ印吴咤O,\005rMw乑卌酴";
        m = 89;
        arrayOfString2 = arrayOfString1;
        break;
      case 89:
        arrayOfString2[k] = str2;
        k = 91;
        str1 = "诟刾|%VZz=\031\031丢莹厊惝皽匭吃哐4IXE9\f幏曜斾\035\033]Za5\021tI`5\023\\[z皤廡孮殝";
        m = 90;
        arrayOfString2 = arrayOfString1;
        break;
      case 90:
        arrayOfString2[k] = str2;
        k = 92;
        str1 = "I`8\007VAjr\034W\\k2\001\027Mv(\007X\006}4\032K\\m)\001\027a@\b0w|";
        m = 91;
        arrayOfString2 = arrayOfString1;
        break;
      case 91:
        arrayOfString2[k] = str2;
        k = 93;
        str1 = "Ka1[XFj.\032PL 0\024LFm4\020K\006o?\001PG`r<w{Z\0359uw]\024:k|M\t!";
        m = 92;
        arrayOfString2 = arrayOfString1;
        break;
      case 92:
        arrayOfString2[k] = str2;
        k = 94;
        str1 = "}`9\rIMm(\020]\022.5\033OIb5\021\031]|0U\024\b";
        m = 93;
        arrayOfString2 = arrayOfString1;
        break;
      case 93:
        arrayOfString2[k] = str2;
        k = 95;
        str1 = "I`8\007VAjr\034W\\k2\001\027Mv(\007X\006}4\032K\\m)\001\027aM\023;fzK\017:lzM\031";
        m = 94;
        arrayOfString2 = arrayOfString1;
        break;
      case 94:
        arrayOfString2[k] = str2;
        k = 96;
        str1 = "I`8\007VAjr\034W\\k2\001\027Mv(\007X\006}4\032K\\m)\001\027fO\0210";
        m = 95;
        arrayOfString2 = arrayOfString1;
        break;
      case 95:
        arrayOfString2[k] = str2;
        k = 97;
        str1 = "L{,\031PKo(\020";
        m = 96;
        arrayOfString2 = arrayOfString1;
        break;
      case 96:
        arrayOfString2[k] = str2;
        k = 98;
        str1 = "Zk;\034J\\|=\001PG`\003\034]";
        m = 97;
        arrayOfString2 = arrayOfString1;
        break;
      case 97:
        arrayOfString2[k] = str2;
        k = 99;
        str1 = "\030$l";
        m = 98;
        arrayOfString2 = arrayOfString1;
        break;
      case 98:
        arrayOfString2[k] = str2;
        k = 100;
        str1 = "\f*";
        m = 99;
        arrayOfString2 = arrayOfString1;
        break;
      case 99:
        arrayOfString2[k] = str2;
        k = 101;
        str1 = "k{.\007\\Fz|\005R\bg2\006MIb0\020]\b~=\001Q\022.";
        m = 100;
        arrayOfString2 = arrayOfString1;
        break;
      case 100:
        arrayOfString2[k] = str2;
        k = 102;
        str1 = "\007}%\006MMcs\024IX!";
        m = 101;
        arrayOfString2 = arrayOfString1;
        break;
      case 101:
        arrayOfString2[k] = str2;
        k = 103;
        str1 = "\007j=\001X\007o,\005\026";
        m = 102;
        arrayOfString2 = arrayOfString1;
        break;
      case 102:
        arrayOfString2[k] = str2;
        k = 104;
        str1 = "Ac9\034";
        m = 103;
        arrayOfString2 = arrayOfString1;
        break;
      case 103:
        arrayOfString2[k] = str2;
        k = 105;
        str1 = "eO\037UXLj.UPFh3X\024\005#|";
        m = 104;
        arrayOfString2 = arrayOfString1;
        break;
      case 104:
        arrayOfString2[k] = str2;
        k = 106;
        str1 = "[z=\007Meg2\006";
        m = 105;
        arrayOfString2 = arrayOfString1;
        break;
      case 105:
        arrayOfString2[k] = str2;
        k = 107;
        str1 = "M`8\001tA`/";
        m = 106;
        arrayOfString2 = arrayOfString1;
        break;
      case 106:
        arrayOfString2[k] = str2;
        k = 108;
        str1 = "M`8=V]|";
        m = 107;
        arrayOfString2 = arrayOfString1;
        break;
      case 107:
        arrayOfString2[k] = str2;
        k = 109;
        str1 = "[z=\007M`a)\007";
        m = 108;
        arrayOfString2 = arrayOfString1;
        break;
      case 108:
        arrayOfString2[k] = str2;
        k = 110;
        str1 = "";
        m = 109;
        arrayOfString2 = arrayOfString1;
        break;
      case 109:
        arrayOfString2[k] = str2;
        k = 111;
        str1 = "";
        m = 110;
        arrayOfString2 = arrayOfString1;
        break;
      case 110:
        arrayOfString2[k] = str2;
        k = 112;
        str1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L./\020K^g?\020\003\b";
        m = 111;
        arrayOfString2 = arrayOfString1;
        break;
      case 111:
        arrayOfString2[k] = str2;
        k = 113;
        str1 = "|f9UIM|1\034J[a5\033\031A}|\007\\Y{5\007\\L.qU";
        m = 112;
        arrayOfString2 = arrayOfString1;
        break;
      case 112:
        arrayOfString2[k] = str2;
        k = 114;
        str1 = "|f9UIM|1\034J[a5\033\031A}|\007\\Y{5\007\\L.qUXFj.\032PL ,\020KEg/\006PG`r\"kaZ\031*jmZ\b<wo]";
        m = 113;
        arrayOfString2 = arrayOfString1;
        break;
      case 113:
        arrayOfString2[k] = str2;
        k = 115;
        str1 = "Im(\034VF4?\035\\Ke\n\024UAj\021\024WAh9\006M";
        m = 114;
        arrayOfString2 = arrayOfString1;
        break;
      case 114:
        arrayOfString2[k] = str2;
        k = 116;
        str1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L..\020ZMg*\020K\022.";
        m = 115;
        arrayOfString2 = arrayOfString1;
        break;
      case 115:
        arrayOfString2[k] = str2;
        k = 117;
        str1 = "I`8\007VAjr\034W\\k2\001\027Im(\034VF \036:v|Q\037:txB\031!|l";
        m = 116;
        arrayOfString2 = arrayOfString1;
        break;
      case 116:
        arrayOfString2[k] = str2;
        k = 118;
        str1 = "";
        m = 117;
        arrayOfString2 = arrayOfString1;
        break;
      case 117:
        arrayOfString2[k] = str2;
        k = 119;
        str1 = "i`8\007VAj\021\024WAh9\006M\006v1\031\031Eg/\006PFi|\007\\Y{5\007\\L.5\033MM`(U_Ab(\020K\bh3\007\031x{/\035kMm9\034OM|fUZF 6\005L[fr\024WL|3\034]\006g2\001\\Fzr;v|G\032<ziZ\025:ww\\\0316|aX\0311fx\\\023-`";
        m = 118;
        arrayOfString2 = arrayOfString1;
        break;
      case 118:
        arrayOfString2[k] = str2;
        k = 120;
        str1 = "k|\007\\Ka1\030\\Fj|\fV].=\021]\bz4\020\031Xk.\030P[}5\032W\b#|";
        m = 119;
        arrayOfString2 = arrayOfString1;
        break;
      case 119:
        arrayOfString2[k] = str2;
        k = 121;
        str1 = "";
        m = 120;
        arrayOfString2 = arrayOfString1;
        break;
      case 120:
        arrayOfString2[k] = str2;
        k = 122;
        str1 = "";
        m = 121;
        arrayOfString2 = arrayOfString1;
        break;
      case 121:
        arrayOfString2[k] = str2;
        k = 123;
        str1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([km^\023'm";
        m = 122;
        arrayOfString2 = arrayOfString1;
        break;
      case 122:
        arrayOfString2[k] = str2;
        k = 124;
        str1 = "\004.3\001QM|+\034JM.%\032L\bm=\033\031Fa(UUGm=\001\\\bz4\020\031Lk*\034ZM}r";
        m = 123;
        arrayOfString2 = arrayOfString1;
        break;
      case 123:
        arrayOfString2[k] = str2;
        k = 125;
        str1 = "K`r\037I]}4[XFj.\032PL 5\033MM`([kmI\025&mm\\";
        m = 124;
        arrayOfString2 = arrayOfString1;
        break;
      case 124:
        arrayOfString2[k] = str2;
        k = 126;
        str1 = "x{/\035kMm9\034OM||\006QG{0\021\031Fa(UQIx9UPFz9\033M\bh5\031MM||X\024\bo2\021KGg8[PFz9\033M\006o?\001PG`r7vgZ\0036ve^\0200mmJpUiDk=\006\\\b|9\030V^k|\001QM.5\033MM`(U_Ab(\020K\bg2UxFj.\032PLC=\033PNk/\001\027Pc0";
        m = 125;
        arrayOfString2 = arrayOfString1;
        break;
      case 125:
        arrayOfString2[k] = str2;
        k = 127;
        str1 = "\006~9\007TA}/\034VF \026%l{F\0038|{]\0352|";
        m = 126;
        arrayOfString2 = arrayOfString1;
        break;
      case 126:
        arrayOfString2[k] = str2;
        k = 128;
        str1 = "";
        m = 127;
        arrayOfString2 = arrayOfString1;
        break;
      case 127:
        arrayOfString2[k] = str2;
        k = 129;
        str1 = "k@a4WL|3\034]\bJ9\027LO\"\023HxFj.\032PL\"\037Hl{";
        m = 128;
        arrayOfString2 = arrayOfString1;
      case 128:
      }
    }
    arrayOfString2[k] = str2;
    z = arrayOfString1;
    ArrayList localArrayList1 = new ArrayList();
    b = localArrayList1;
    ArrayList localArrayList2 = localArrayList1;
    String str3 = "\033;dC\016\033>mF\016\021;dL\f";
    int n = -1;
    String str4;
    while (true)
    {
      str4 = z(z(str3));
      switch (n)
      {
      default:
        localArrayList2.add(str4);
        List localList = b;
        String str5 = "";
        String str6;
        for (int i1 = -1; ; i1 = 0)
        {
          str6 = z(z(str5));
          switch (i1)
          {
          default:
            localList.add(str6);
            localList = b;
            str5 = "\030>lE\t\030>lE\t\030>lE";
          case 1:
          case 0:
          }
        }
        localList.add(str6);
        c = new X500Principal(z['']);
        StringBuilder localStringBuilder = new StringBuilder().append(Environment.getExternalStorageDirectory().getPath());
        String str7 = "\007j=\001X\007";
        int i2 = -1;
        String str8;
        while (true)
        {
          str8 = z(z(str7));
          switch (i2)
          {
          default:
            d = str8;
            localStringBuilder = new StringBuilder().append(Environment.getExternalStorageDirectory().getPath());
            str7 = "";
            i2 = 0;
            continue;
            localList.add(str6);
            localList = b;
            str5 = "\030>lE\t\030>lE\t\030>lE\t";
            i1 = 1;
            break;
          case 0:
            e = str8;
            localStringBuilder = new StringBuilder().append(Environment.getExternalStorageDirectory().getPath());
            str7 = "";
            i2 = 1;
          case 1:
          }
        }
        f = str8;
        a = 1;
        g = new ArrayList();
        h = new ArrayList();
        localArrayList2 = g;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[pfZ\031'wmZ";
        n = 0;
        break;
      case 0:
        localArrayList2.add(str4);
        localArrayList2 = g;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[niE\031*ugM\027";
        n = 1;
        break;
      case 1:
        localArrayList2.add(str4);
        g.add(z[7]);
        localArrayList2 = g;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jw@\031!ng\\\027*j|O\b0";
        n = 2;
        break;
      case 2:
        localArrayList2.add(str4);
        localArrayList2 = h;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[oaL\0164mm";
        n = 3;
        break;
      case 3:
        localArrayList2.add(str4);
        localArrayList2 = h;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[z`O\0222|wY\0253pw]\b4mm";
        n = 4;
        break;
      case 4:
        localArrayList2.add(str4);
        localArrayList2 = new ArrayList();
        i = localArrayList2;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwH\025;|wB\0236x|G\023;";
        n = 5;
        break;
      case 5:
        localArrayList2.add(str4);
        localArrayList2 = i;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwM\0234k{K\0039vkO\b<vf";
        n = 6;
        break;
      case 6:
        localArrayList2.add(str4);
        localArrayList2 = i;
        str3 = "I`8\007VAjr\005\\Zc5\006JAa2[xkM\031&jwB\0236x|G\023;fmV\b'xwM\0238ti@\030&";
        n = 7;
      case 7:
      }
    }
    localArrayList2.add(str4);
    i.add(z[71]);
  }

  private static String A(Context paramContext)
  {
    if ((!a()) || (!c(paramContext, z[7])))
    {
      x.f();
      return null;
    }
    File localFile = new File(f);
    if (localFile.exists())
      try
      {
        ArrayList localArrayList = m.a(new FileInputStream(localFile));
        if (localArrayList.size() > 0)
        {
          String str = (String)localArrayList.get(0);
          new StringBuilder(z[9]).append(str).toString();
          x.d();
          return str;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        return null;
      }
    return null;
  }

  private static String B(Context paramContext)
  {
    String str = k(paramContext);
    if ((!ai.a(str)) && (d(str)));
    label79: 
    while (true)
    {
      return str;
      if (Build.VERSION.SDK_INT >= 9);
      for (str = Build.SERIAL; ; str = null)
      {
        if ((!ai.a(str)) && (d(str)))
          break label79;
        str = i(paramContext, " ");
        if ((!ai.a(str)) && (d(str)))
          break;
        return UUID.randomUUID().toString();
      }
    }
  }

  private static boolean C(Context paramContext)
  {
    try
    {
      String str = Settings.System.getString(paramContext.getContentResolver(), z[51]);
      if (TextUtils.isEmpty(str))
        str = i(paramContext, "");
      Settings.System.putString(paramContext.getContentResolver(), z[51], str);
      x.d();
      return true;
    }
    catch (Exception localException)
    {
      x.f();
    }
    return false;
  }

  private static boolean D(Context paramContext)
  {
    try
    {
      Intent localIntent = new Intent(z[4]);
      localIntent.setPackage(paramContext.getPackageName());
      localIntent.addCategory(z[5]);
      ActivityInfo localActivityInfo = paramContext.getPackageManager().resolveActivity(localIntent, 0).activityInfo;
      if (localActivityInfo != null)
      {
        Class localClass = Class.forName(localActivityInfo.name);
        if (localClass == null)
          return false;
        if (!InstrumentedActivity.class.isAssignableFrom(localClass))
        {
          boolean bool = InstrumentedListActivity.class.isAssignableFrom(localClass);
          if (!bool);
        }
        else
        {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
    }
    return false;
  }

  private static void E(Context paramContext)
  {
    x.d();
    if (j == null)
      j = new PushReceiver();
    paramContext.registerReceiver(j, new IntentFilter(z[68]));
    paramContext.registerReceiver(j, new IntentFilter(z[65]));
    try
    {
      IntentFilter localIntentFilter1 = new IntentFilter(z[69]);
      localIntentFilter1.addDataScheme(z[67]);
      IntentFilter localIntentFilter2 = new IntentFilter(z[66]);
      localIntentFilter2.addDataScheme(z[67]);
      IntentFilter localIntentFilter3 = new IntentFilter(z[64]);
      localIntentFilter3.setPriority(1000);
      localIntentFilter3.addCategory(paramContext.getPackageName());
      paramContext.registerReceiver(j, localIntentFilter1);
      paramContext.registerReceiver(j, localIntentFilter2);
      paramContext.registerReceiver(j, localIntentFilter3);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public static int a(byte paramByte)
  {
    return paramByte & 0xFF;
  }

  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density);
  }

  public static Intent a(Context paramContext, d paramd, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra(z[74], paramBoolean);
    localIntent.putExtra(z[73], paramd);
    localIntent.setAction(z[72]);
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.addFlags(268435456);
    return localIntent;
  }

  public static String a(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics == null)
      return z[99];
    int k = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    return k + "*" + m;
  }

  public static String a(Context paramContext, String paramString)
  {
    String str1 = Build.VERSION.RELEASE + "," + Integer.toString(Build.VERSION.SDK_INT);
    String str2 = Build.MODEL;
    String str3 = q.a(paramContext, z[17], z[14]);
    String str4 = Build.DEVICE;
    String str5;
    StringBuilder localStringBuilder;
    String str6;
    int k;
    if (ai.a(cn.jpush.android.a.e))
    {
      str5 = " ";
      localStringBuilder = new StringBuilder().append(str1).append(z[100]).append(str2).append(z[100]).append(str3).append(z[100]).append(str4).append(z[100]).append(str5).append(z[100]).append(paramString).append(z[100]);
      str6 = paramContext.getApplicationInfo().sourceDir;
      if (!ai.a(str6))
        break label229;
      x.f();
      k = 0;
      label186: if (k == 0)
        break label303;
    }
    label303: for (int m = 1; ; m = 0)
    {
      return m + z[100] + a(paramContext);
      str5 = cn.jpush.android.a.e;
      break;
      label229: new StringBuilder(z[101]).append(str6).toString();
      x.c();
      if (str6.startsWith(z[102]))
      {
        k = 1;
        break label186;
      }
      if (str6.startsWith(z[103]))
      {
        k = 0;
        break label186;
      }
      x.d();
      k = 0;
      break label186;
    }
  }

  public static String a(String paramString)
  {
    int k = 0;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(z[27]);
      char[] arrayOfChar = paramString.toCharArray();
      byte[] arrayOfByte1 = new byte[arrayOfChar.length];
      for (int m = 0; m < arrayOfChar.length; m++)
        arrayOfByte1[m] = ((byte)arrayOfChar[m]);
      byte[] arrayOfByte2 = localMessageDigest.digest(arrayOfByte1);
      StringBuffer localStringBuffer = new StringBuffer();
      while (k < arrayOfByte2.length)
      {
        int n = 0xFF & arrayOfByte2[k];
        if (n < 16)
          localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(n));
        k++;
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Exception localException)
    {
      x.c();
    }
    return "";
  }

  public static String a(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance(z[27]).digest(paramArrayOfByte);
      StringBuffer localStringBuffer = new StringBuffer();
      for (int k = 0; k < arrayOfByte.length; k++)
      {
        int m = 0xFF & arrayOfByte[k];
        if (m < 16)
          localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(m));
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Exception localException)
    {
      x.c();
    }
    return "";
  }

  public static JSONObject a(String paramString, JSONArray paramJSONArray)
  {
    if ((paramJSONArray == null) || (paramJSONArray.length() == 0))
      return null;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put(z[58], paramJSONArray);
      localJSONObject.put(z[46], paramString);
      localJSONObject.put(z[59], PushService.m + Math.abs(System.currentTimeMillis() / 1000L - PushService.n));
      return localJSONObject;
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
    }
    return null;
  }

  public static void a(Context paramContext, d paramd)
  {
    try
    {
      Intent localIntent = new Intent(z[76]);
      localIntent.putExtra(z[75], paramd.n);
      localIntent.putExtra(z[77], paramd.i);
      localIntent.putExtra(z[80], paramd.j);
      localIntent.putExtra(z[82], paramd.k);
      localIntent.putExtra(z[37], paramd.l);
      localIntent.putExtra(z[79], paramd.c);
      if (paramd.f())
        localIntent.putExtra(z[81], paramd.U);
      localIntent.addCategory(paramd.m);
      String str1 = z[40];
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramd.m;
      paramContext.sendBroadcast(localIntent, String.format(str1, arrayOfObject1));
      StringBuilder localStringBuilder = new StringBuilder(z[78]);
      String str2 = z[40];
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramd.m;
      localStringBuilder.append(String.format(str2, arrayOfObject2)).toString();
      x.d();
      ServiceInterface.a(paramd.c, 1018, paramContext);
      return;
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Uri localUri = Uri.parse(paramString2);
    if (localUri == null)
    {
      new StringBuilder(z[94]).append(paramString2).toString();
      x.c();
      return;
    }
    Intent localIntent1 = new Intent(z[28], localUri);
    localIntent1.setFlags(335544320);
    Intent.ShortcutIconResource localShortcutIconResource = Intent.ShortcutIconResource.fromContext(paramContext, paramInt);
    Intent localIntent2 = new Intent(z[93]);
    localIntent2.putExtra(z[97], false);
    localIntent2.putExtra(z[96], paramString1);
    localIntent2.putExtra(z[92], localIntent1);
    localIntent2.putExtra(z[95], localShortcutIconResource);
    paramContext.sendBroadcast(localIntent2);
  }

  public static boolean a()
  {
    boolean bool = Environment.getExternalStorageState().equals(z[85]);
    if (!bool)
      x.c();
    return bool;
  }

  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
      throw new IllegalArgumentException(z[25]);
    if (TextUtils.isEmpty(paramString1))
    {
      new StringBuilder(z[24]).append(paramString1).toString();
      x.e();
      return false;
    }
    Intent localIntent = n(paramContext, paramString1);
    if (localIntent == null)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          x.c();
          return false;
        }
      }
      catch (Exception localException)
      {
        x.h();
        return false;
      }
      localIntent = new Intent();
      localIntent.setClassName(paramString1, paramString2);
      localIntent.addCategory(z[5]);
    }
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
    return true;
  }

  public static boolean a(Context paramContext, String paramString, boolean paramBoolean)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString);
    localIntent.addCategory(paramContext.getPackageName());
    return !localPackageManager.queryBroadcastReceivers(localIntent, 0).isEmpty();
  }

  public static int b(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 20))
      return -1;
    return 0xFF & paramArrayOfByte[3];
  }

  public static String b(Context paramContext, String paramString)
  {
    String str1 = Build.VERSION.RELEASE + "," + Integer.toString(Build.VERSION.SDK_INT);
    String str2 = Build.MODEL;
    String str3 = q.a(paramContext, z[17], z[14]);
    String str4 = Build.DEVICE;
    String str5;
    if (ai.a(cn.jpush.android.a.e))
      str5 = " ";
    while (true)
    {
      String str6 = d(paramContext);
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put(z[12], str1);
        localJSONObject.put(z[13], str2);
        localJSONObject.put(z[14], str3);
        localJSONObject.put(z[11], str4);
        localJSONObject.put(z[10], str5);
        localJSONObject.put(z[15], str6);
        localJSONObject.put(z[16], paramString);
        label183: return localJSONObject.toString();
        str5 = cn.jpush.android.a.e;
      }
      catch (JSONException localJSONException)
      {
        break label183;
      }
    }
  }

  public static String b(String paramString)
  {
    try
    {
      byte[] arrayOfByte = MessageDigest.getInstance(z[27]).digest(paramString.getBytes(z[84]));
      StringBuffer localStringBuffer = new StringBuffer();
      for (int k = 0; k < arrayOfByte.length; k++)
      {
        int m = 0xFF & arrayOfByte[k];
        if (m < 16)
          localStringBuffer.append("0");
        localStringBuffer.append(Integer.toHexString(m));
      }
      String str = localStringBuffer.toString();
      return str;
    }
    catch (Exception localException)
    {
      x.c();
    }
    return "";
  }

  public static void b()
  {
    PowerManager.WakeLock localWakeLock = r.a().b();
    if ((localWakeLock == null) || (localWakeLock.isHeld()));
    try
    {
      localWakeLock.release();
      x.c();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (true)
      {
        new StringBuilder(z[26]).append(localRuntimeException).toString();
        x.c();
      }
    }
  }

  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Intent localIntent = new Intent(paramString1);
      localIntent.putExtra(z[37], paramString2);
      String str = paramContext.getPackageName();
      if (ai.a(str))
        x.e(z[39], z[38]);
      localIntent.addCategory(str);
      paramContext.sendBroadcast(localIntent, String.format(z[40], new Object[] { str }));
      return;
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
    }
  }

  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, PushReceiver.class);
    localIntent.setAction(z[48]);
    localIntent.putExtra(z[44], true);
    localIntent.putExtra(z[50], paramString2);
    localIntent.putExtra(z[46], paramInt);
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728);
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService(z[47]);
    int k = -1;
    try
    {
      k = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 256).applicationInfo.icon;
      label116: if (k < 0)
        k = 17301586;
      String str1 = z[45];
      String str2 = z[49];
      Notification localNotification = new Notification(k, paramString1, System.currentTimeMillis());
      localNotification.flags = 34;
      localNotification.setLatestEventInfo(paramContext, str1, str2, localPendingIntent);
      localNotificationManager.notify(paramString1.hashCode(), localNotification);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label116;
    }
  }

  public static boolean b(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(z[6])).getActiveNetworkInfo();
    return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
  }

  private static boolean b(Context paramContext, String paramString, boolean paramBoolean)
  {
    return !paramContext.getPackageManager().queryIntentServices(new Intent(paramString), 0).isEmpty();
  }

  public static int c(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte != null)
    {
      int m = paramArrayOfByte.length;
      k = 0;
      if (m >= 6)
        break label19;
    }
    while (true)
    {
      return k;
      label19: int n = 0;
      while (n < 2)
      {
        int i1 = (k << 8) + (0xFF & paramArrayOfByte[n]);
        n++;
        k = i1;
      }
    }
  }

  public static String c()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    BufferedReader localBufferedReader;
    if (new File(z[87]).exists())
      try
      {
        localBufferedReader = new BufferedReader(new FileReader(new File(z[87])));
        while (true)
        {
          String str = localBufferedReader.readLine();
          if (str == null)
            break;
          if (str.contains(z[88]))
          {
            int k = str.indexOf(":");
            if ((k >= 0) && (k < -1 + str.length()))
              localStringBuffer.append(str.substring(k + 1).trim());
          }
        }
      }
      catch (IOException localIOException)
      {
      }
    while (true)
    {
      return localStringBuffer.toString();
      localBufferedReader.close();
    }
  }

  public static short c(Context paramContext)
  {
    return ae.b(paramContext);
  }

  public static void c(Context paramContext, String paramString1, String paramString2)
  {
    if (!i(paramContext))
      return;
    x.c();
    Intent localIntent = new Intent(paramContext, PushReceiver.class);
    localIntent.setAction(z[48]);
    localIntent.putExtra(z[44], true);
    localIntent.putExtra(z[89], paramString2);
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, localIntent, 134217728);
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService(z[47]);
    int k = -1;
    try
    {
      k = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 256).applicationInfo.icon;
      label109: if (k < 0)
        k = 17301586;
      String str1 = z[90];
      String str2 = z[91];
      Notification localNotification = new Notification(k, paramString1, System.currentTimeMillis());
      localNotification.flags = 34;
      localNotification.setLatestEventInfo(paramContext, str1, str2, localPendingIntent);
      localNotificationManager.notify(paramString1.hashCode(), localNotification);
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label109;
    }
  }

  public static void c(String paramString)
  {
    b.add(paramString);
  }

  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
      throw new IllegalArgumentException(z[8]);
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }

  public static String d()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration2;
        while (!localEnumeration2.hasMoreElements())
        {
          if (!localEnumeration1.hasMoreElements())
            break;
          localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration2.nextElement();
      }
      while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      String str = localInetAddress.getHostAddress().toString();
      return str;
    }
    catch (Exception localException)
    {
      x.e();
      localException.printStackTrace();
    }
    return "";
  }

  public static String d(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(z[6])).getActiveNetworkInfo();
    String str1;
    if (localNetworkInfo == null)
      str1 = z[83];
    String str2;
    do
    {
      return str1;
      str1 = localNetworkInfo.getTypeName();
      str2 = localNetworkInfo.getSubtypeName();
      if (str1 == null)
        return z[83];
    }
    while (str2 == null);
    return str1 + "," + str2;
  }

  public static boolean d(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), paramString);
    try
    {
      localPackageManager.getReceiverInfo(localComponentName, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private static boolean d(Context paramContext, String paramString1, String paramString2)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Intent localIntent = new Intent(paramString2);
    localIntent.setPackage(paramContext.getPackageName());
    Iterator localIterator = localPackageManager.queryBroadcastReceivers(localIntent, 0).iterator();
    while (localIterator.hasNext())
    {
      ActivityInfo localActivityInfo = ((ResolveInfo)localIterator.next()).activityInfo;
      if ((localActivityInfo != null) && (localActivityInfo.name.equals(paramString1)))
        return true;
    }
    return false;
  }

  private static boolean d(String paramString)
  {
    if (ai.a(paramString));
    while (paramString.length() < 10)
      return false;
    for (int k = 0; ; k++)
    {
      if (k >= b.size())
        break label73;
      if ((paramString.equals(b.get(k))) || (paramString.startsWith((String)b.get(k))))
        break;
    }
    label73: return true;
  }

  public static String e(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(z[6])).getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return "";
    return localNetworkInfo.getTypeName().toUpperCase(Locale.getDefault());
  }

  public static void e(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.setAction(z[28]);
    localIntent.setDataAndType(Uri.fromFile(new File(paramString)), z[29]);
    paramContext.startActivity(localIntent);
  }

  public static void f(Context paramContext)
  {
    h(paramContext, null);
  }

  public static boolean f(Context paramContext, String paramString)
  {
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 0);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static String g(Context paramContext, String paramString)
  {
    if (!c(paramContext, z[71]));
    while (true)
    {
      return paramString;
      try
      {
        String str = ((WifiManager)paramContext.getSystemService(z[32])).getConnectionInfo().getMacAddress();
        boolean bool = ai.a(str);
        if (!bool)
          return str;
      }
      catch (Exception localException)
      {
        x.j();
      }
    }
    return paramString;
  }

  public static boolean g(Context paramContext)
  {
    return ((PowerManager)paramContext.getSystemService(z[56])).isScreenOn();
  }

  public static int h(Context paramContext)
  {
    Intent localIntent = paramContext.registerReceiver(null, new IntentFilter(z[42]));
    int k = localIntent.getIntExtra(z[43], -1);
    if ((k == 2) || (k == 5));
    for (int m = 1; m == 0; m = 0)
      return -1;
    return localIntent.getIntExtra(z[41], -1);
  }

  public static void h(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(z[4]);
    String str = paramContext.getPackageName();
    localIntent.setPackage(str);
    if (!ai.a(paramString))
      localIntent.putExtra(z[37], paramString);
    localIntent.addCategory(z[5]);
    ResolveInfo localResolveInfo = paramContext.getPackageManager().resolveActivity(localIntent, 0);
    new StringBuilder(z[70]).append(localResolveInfo.activityInfo.name).toString();
    x.d();
    localIntent.setClassName(str, localResolveInfo.activityInfo.name);
    localIntent.setFlags(268435456);
    paramContext.startActivity(localIntent);
  }

  public static String i(Context paramContext, String paramString)
  {
    if (c(paramContext, z[19]))
      paramString = ((TelephonyManager)paramContext.getSystemService(z[18])).getDeviceId();
    return paramString;
  }

  public static boolean i(Context paramContext)
  {
    boolean bool1 = false;
    try
    {
      Signature[] arrayOfSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures;
      CertificateFactory localCertificateFactory = CertificateFactory.getInstance(z[62]);
      int k = 0;
      while (true)
      {
        if (k >= arrayOfSignature.length)
          break label104;
        boolean bool3 = ((X509Certificate)localCertificateFactory.generateCertificate(new ByteArrayInputStream(arrayOfSignature[k].toByteArray()))).getSubjectX500Principal().equals(c);
        bool2 = bool3;
        if (bool2)
          break;
        k++;
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      boolean bool2 = bool1;
      return bool2;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      return bool1;
    }
    label104: return bool1;
  }

  public static String j(Context paramContext)
  {
    String str1 = ae.a(paramContext, z[104], "");
    if ((!ai.a(str1)) && (d(str1)))
      return str1;
    String str2 = y(paramContext);
    ae.b(paramContext, z[104], str2);
    return str2;
  }

  public static void j(Context paramContext, String paramString)
  {
    if (!ai.a(paramString))
    {
      q(paramContext, paramString);
      o(paramContext, paramString);
      ae.b(paramContext, z[36], paramString);
    }
  }

  public static String k(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), z[86]);
  }

  private static boolean k(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString)))
      throw new IllegalArgumentException(z[8]);
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      localPackageManager.getPermissionInfo(paramString, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static String l(Context paramContext)
  {
    String str1 = ae.a(paramContext, z[36], null);
    if (!ai.a(str1))
    {
      a = b.d.ordinal();
      return str1;
    }
    String str2 = p(paramContext, str1);
    if (!ai.a(str2))
    {
      a = b.b.ordinal();
      o(paramContext, str2);
      ae.b(paramContext, z[36], str2);
      return str2;
    }
    String str3 = A(paramContext);
    if (!ai.a(str3))
    {
      a = b.c.ordinal();
      q(paramContext, str3);
      ae.b(paramContext, z[36], str3);
      return str3;
    }
    boolean bool1 = c(paramContext, z[35]);
    int k;
    boolean bool2;
    if ((c(paramContext, z[7])) && (a()))
    {
      k = 1;
      if (bool1)
        break label183;
      bool2 = false;
      if (k != 0)
        break label183;
    }
    while (true)
    {
      if (bool2)
        break label208;
      a = b.e.ordinal();
      return B(paramContext);
      k = 0;
      break;
      label183: if ((k == 0) && (bool1))
        bool2 = C(paramContext);
      else
        bool2 = true;
    }
    label208: String str4 = i(paramContext, str3);
    String str5 = k(paramContext);
    String str6 = g(paramContext, "");
    Object localObject = UUID.randomUUID().toString();
    String str7 = a(str4 + str5 + str6 + (String)localObject);
    if (ai.a(str7));
    while (true)
    {
      String str8 = q(paramContext, (String)localObject);
      if ((!ai.a(o(paramContext, (String)localObject))) || (!ai.a(str8)))
      {
        new StringBuilder(z[63]).append((String)localObject).toString();
        x.c();
        ae.b(paramContext, z[36], (String)localObject);
        a = b.a.ordinal();
        return localObject;
      }
      a = b.e.ordinal();
      x.c();
      return B(paramContext);
      localObject = str7;
    }
  }

  private static boolean l(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), paramString);
    try
    {
      localPackageManager.getServiceInfo(localComponentName, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  public static void m(Context paramContext)
  {
    PowerManager.WakeLock localWakeLock = ((PowerManager)paramContext.getSystemService(z[56])).newWakeLock(1, z[57]);
    localWakeLock.setReferenceCounted(false);
    r.a().a(localWakeLock);
    if (!r.a().b().isHeld())
      r.a().b().acquire();
    x.c();
  }

  private static boolean m(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), paramString);
    try
    {
      localPackageManager.getActivityInfo(localComponentName, 128);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return false;
  }

  private static Intent n(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager.getPackageInfo(paramString, 256) != null)
      {
        Intent localIntent = localPackageManager.getLaunchIntentForPackage(paramString);
        return localIntent;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return null;
  }

  public static JSONArray n(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramContext.getPackageManager().getInstalledPackages(0);
    for (int k = 0; k < localList.size(); k++)
    {
      PackageInfo localPackageInfo = (PackageInfo)localList.get(k);
      y localy2 = new y();
      localy2.a = localPackageInfo.applicationInfo.loadLabel(paramContext.getPackageManager()).toString();
      localy2.b = localPackageInfo.packageName;
      localy2.c = localPackageInfo.versionName;
      localy2.d = localPackageInfo.versionCode;
      localArrayList.add(localy2);
    }
    JSONArray localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        y localy1 = (y)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put(z[1], localy1.a);
        localJSONObject.put(z[2], localy1.b);
        localJSONObject.put(z[3], localy1.c);
        localJSONObject.put(z[0], localy1.d);
        localJSONArray.put(localJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONArray;
  }

  // ERROR //
  private static String o(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 390	cn/jpush/android/util/a:a	()Z
    //   3: ifeq +16 -> 19
    //   6: aload_0
    //   7: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   10: bipush 7
    //   12: aaload
    //   13: invokestatic 393	cn/jpush/android/util/a:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   16: ifne +7 -> 23
    //   19: aconst_null
    //   20: astore_1
    //   21: aload_1
    //   22: areturn
    //   23: new 333	java/io/File
    //   26: dup
    //   27: getstatic 348	cn/jpush/android/util/a:d	Ljava/lang/String;
    //   30: invokespecial 398	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore_2
    //   34: aload_2
    //   35: invokevirtual 401	java/io/File:exists	()Z
    //   38: ifne +8 -> 46
    //   41: aload_2
    //   42: invokevirtual 1209	java/io/File:mkdir	()Z
    //   45: pop
    //   46: new 333	java/io/File
    //   49: dup
    //   50: getstatic 358	cn/jpush/android/util/a:f	Ljava/lang/String;
    //   53: invokespecial 398	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: aload_3
    //   58: invokevirtual 401	java/io/File:exists	()Z
    //   61: ifeq +8 -> 69
    //   64: aload_3
    //   65: invokevirtual 1212	java/io/File:delete	()Z
    //   68: pop
    //   69: aload_3
    //   70: invokevirtual 1215	java/io/File:createNewFile	()Z
    //   73: pop
    //   74: new 1217	java/io/FileOutputStream
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 1218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   82: astore 6
    //   84: aload 6
    //   86: aload_1
    //   87: invokevirtual 1220	java/lang/String:getBytes	()[B
    //   90: invokevirtual 1223	java/io/FileOutputStream:write	([B)V
    //   93: aload 6
    //   95: invokevirtual 1226	java/io/FileOutputStream:flush	()V
    //   98: invokestatic 422	cn/jpush/android/util/x:d	()V
    //   101: aload 6
    //   103: ifnull -82 -> 21
    //   106: aload 6
    //   108: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   111: aload_1
    //   112: areturn
    //   113: astore 11
    //   115: aload_1
    //   116: areturn
    //   117: astore 16
    //   119: invokestatic 1049	cn/jpush/android/util/x:j	()V
    //   122: goto -76 -> 46
    //   125: astore 14
    //   127: aconst_null
    //   128: areturn
    //   129: astore 4
    //   131: invokestatic 1049	cn/jpush/android/util/x:j	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore 13
    //   138: aconst_null
    //   139: astore 6
    //   141: invokestatic 1049	cn/jpush/android/util/x:j	()V
    //   144: aload 6
    //   146: ifnull +8 -> 154
    //   149: aload 6
    //   151: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore 12
    //   158: aconst_null
    //   159: astore 6
    //   161: aload 12
    //   163: astore 8
    //   165: aload 6
    //   167: ifnull +8 -> 175
    //   170: aload 6
    //   172: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   175: aload 8
    //   177: athrow
    //   178: astore 10
    //   180: goto -26 -> 154
    //   183: astore 9
    //   185: goto -10 -> 175
    //   188: astore 8
    //   190: goto -25 -> 165
    //   193: astore 7
    //   195: goto -54 -> 141
    //
    // Exception table:
    //   from	to	target	type
    //   106	111	113	java/io/IOException
    //   41	46	117	java/lang/Exception
    //   64	69	125	java/lang/SecurityException
    //   69	74	129	java/io/IOException
    //   74	84	136	java/io/IOException
    //   74	84	156	finally
    //   149	154	178	java/io/IOException
    //   170	175	183	java/io/IOException
    //   84	101	188	finally
    //   141	144	188	finally
    //   84	101	193	java/io/IOException
  }

  public static boolean o(Context paramContext)
  {
    boolean bool;
    try
    {
      if (ae.a(paramContext, z[20], "0").equals("1"))
      {
        x.d();
        return false;
      }
      String str1 = ae.a(paramContext, z[23], "");
      if (ai.a(str1))
      {
        x.d();
        return true;
      }
      new StringBuilder(z[21]).append(str1).toString();
      x.d();
      String[] arrayOfString1 = str1.split("_");
      String str2 = arrayOfString1[0];
      String str3 = arrayOfString1[1];
      char[] arrayOfChar = str2.toCharArray();
      String[] arrayOfString2 = str3.split(z[22]);
      Calendar localCalendar = Calendar.getInstance();
      int k = localCalendar.get(7);
      int m = localCalendar.get(11);
      int n = arrayOfChar.length;
      for (int i1 = 0; ; i1++)
      {
        bool = false;
        if (i1 >= n)
          break;
        if (k == 1 + Integer.valueOf(String.valueOf(arrayOfChar[i1])).intValue())
        {
          int i2 = Integer.valueOf(arrayOfString2[0]).intValue();
          int i3 = Integer.valueOf(arrayOfString2[1]).intValue();
          if ((m >= i2) && (m <= i3))
            return true;
        }
      }
    }
    catch (Exception localException)
    {
      bool = true;
    }
    return bool;
  }

  private static String p(Context paramContext, String paramString)
  {
    if (c(paramContext, z[35]));
    try
    {
      String str = Settings.System.getString(paramContext.getContentResolver(), z[36]);
      paramString = str;
      return paramString;
    }
    catch (Exception localException)
    {
      x.f();
    }
    return paramString;
  }

  public static boolean p(Context paramContext)
  {
    String str = ae.a(paramContext, z[110], "");
    if (TextUtils.isEmpty(str));
    while (true)
    {
      return false;
      try
      {
        JSONObject localJSONObject = new JSONObject(str);
        int k = localJSONObject.optInt(z[109], -1);
        int m = localJSONObject.optInt(z[106], -1);
        int n = localJSONObject.optInt(z[108], -1);
        int i1 = localJSONObject.optInt(z[107], -1);
        if ((k >= 0) && (m >= 0) && (n >= 0) && (i1 >= 0) && (m <= 59) && (i1 <= 59) && (n <= 23) && (k <= 23))
        {
          Calendar localCalendar = Calendar.getInstance();
          int i2 = localCalendar.get(11);
          int i3 = localCalendar.get(12);
          if (k < n)
          {
            if (((i2 > k) && (i2 < n)) || ((i2 == k) && (i3 >= m)) || ((i2 == n) && (i3 <= i1)))
              return true;
          }
          else if (k == n)
          {
            if ((i2 == k) && (i3 >= m) && (i3 <= i1))
              return true;
          }
          else if ((k > n) && (((i2 > k) && (i2 <= 23)) || ((i2 >= 0) && (i2 < n)) || ((i2 == k) && (i3 >= m)) || ((i2 == n) && (i3 <= i1))))
            return true;
        }
      }
      catch (JSONException localJSONException)
      {
      }
    }
    return false;
  }

  private static String q(Context paramContext, String paramString)
  {
    if (c(paramContext, z[35]))
      try
      {
        boolean bool = Settings.System.putString(paramContext.getContentResolver(), z[36], paramString);
        if (bool)
          return paramString;
      }
      catch (Exception localException)
      {
        x.f();
      }
    return null;
  }

  public static boolean q(Context paramContext)
  {
    x.b(z[39], z[115]);
    int k;
    if (!l(paramContext, PushService.class.getCanonicalName()))
    {
      x.e(z[39], z[112] + PushService.class.getCanonicalName());
      k = 0;
      if (ai.a(cn.jpush.android.a.f))
        break label801;
    }
    for (int m = 1; ; m = 0)
    {
      if ((!cn.jpush.android.a.i) && (!D(paramContext)))
        x.d(z[39], z[122]);
      if ((m == 0) || (k == 0))
        break label822;
      return true;
      if (!b(paramContext, z[125], false))
      {
        x.e(z[39], z[121]);
        k = 0;
        break;
      }
      if (!b(paramContext, z[123], false))
      {
        x.e(z[39], z[118]);
        k = 0;
        break;
      }
      l(paramContext, DownloadService.class.getCanonicalName());
      if (!d(paramContext, PushReceiver.class.getCanonicalName()))
      {
        x.e(z[39], z[116] + PushReceiver.class.getCanonicalName());
        E(paramContext);
      }
      while (true)
      {
        k = 1;
        break;
        if (d(paramContext, PushReceiver.class.getCanonicalName(), z[117]))
          x.d(z[39], z[126]);
        if (!a(paramContext, z[64], true))
        {
          x.e(z[39], z[119]);
          k = 0;
          break;
        }
        if (!d(paramContext, AlarmReceiver.class.getCanonicalName()))
        {
          x.e(z[39], z[116] + AlarmReceiver.class.getCanonicalName());
          k = 0;
          break;
        }
        m(paramContext, PushActivity.class.getCanonicalName());
        String str1 = z[72];
        PackageManager localPackageManager = paramContext.getPackageManager();
        Intent localIntent = new Intent(str1);
        localIntent.addCategory(paramContext.getPackageName());
        if (localPackageManager.queryIntentActivities(localIntent, 0).isEmpty());
        String str2 = paramContext.getPackageName() + z[127];
        if (!k(paramContext, str2))
        {
          x.e(z[39], z[''] + str2);
          k = 0;
          break;
        }
        g.add(str2);
        Iterator localIterator1 = g.iterator();
        while (true)
        {
          Iterator localIterator2;
          Iterator localIterator3;
          if (localIterator1.hasNext())
          {
            String str5 = (String)localIterator1.next();
            if (!c(paramContext.getApplicationContext(), str5))
            {
              x.e(z[39], z[113] + str5);
              k = 0;
              break;
            }
          }
        }
        if ((i(paramContext)) && (!c(paramContext.getApplicationContext(), z[35])))
        {
          x.e(z[39], z[114]);
          k = 0;
          break;
        }
        localIterator2 = h.iterator();
        while (localIterator2.hasNext())
        {
          String str4 = (String)localIterator2.next();
          if (!c(paramContext.getApplicationContext(), str4))
            x.d(z[39], z[120] + str4);
        }
        localIterator3 = i.iterator();
        while (localIterator3.hasNext())
        {
          String str3 = (String)localIterator3.next();
          if (!c(paramContext.getApplicationContext(), str3))
            x.d(z[39], z[120] + str3 + z[124]);
        }
      }
      label801: x.d(z[39], z[111]);
    }
    label822: return false;
  }

  public static void r(Context paramContext)
  {
    if ((j != null) && (!d(paramContext, PushReceiver.class.getCanonicalName())));
    try
    {
      paramContext.unregisterReceiver(j);
      return;
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
    }
  }

  public static long s(Context paramContext)
  {
    return PushService.a(paramContext);
  }

  public static String t(Context paramContext)
  {
    return PushService.b(paramContext);
  }

  public static String u(Context paramContext)
  {
    return ae.a(paramContext, z[98], "");
  }

  public static String v(Context paramContext)
  {
    Object localObject = cn.jpush.android.a.f;
    PackageManager localPackageManager;
    if (ai.a((String)localObject))
      localPackageManager = paramContext.getPackageManager();
    try
    {
      ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null))
      {
        String str = localApplicationInfo.metaData.getString(z[60]);
        localObject = str;
      }
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
    }
    return localObject;
  }

  public static String w(Context paramContext)
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService(z[6])).getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return z[33];
    if (localNetworkInfo.getType() == 1)
      return z[32];
    if (localNetworkInfo.getType() == 0)
    {
      int k = localNetworkInfo.getSubtype();
      if ((k == 4) || (k == 1) || (k == 2))
        return z[34];
      if ((k == 3) || (k == 8) || (k == 6) || (k == 5) || (k == 12))
        return z[31];
      if (k == 13)
        return z[30];
    }
    return "";
  }

  private static String x(Context paramContext)
  {
    if (!c(paramContext, z[71]))
      return null;
    try
    {
      String str1 = ((WifiManager)paramContext.getSystemService(z[32])).getConnectionInfo().getMacAddress();
      if ((str1 != null) && (!str1.equals("")))
      {
        new StringBuilder(z[105]).append(str1).toString();
        x.d();
        String str2 = a(str1 + Build.MODEL);
        return str2;
      }
    }
    catch (Exception localException)
    {
      x.j();
      return null;
    }
    return null;
  }

  private static String y(Context paramContext)
  {
    String str1;
    try
    {
      String str2 = i(paramContext, "");
      if (d(str2))
        return str2;
      str1 = k(paramContext);
      if ((ai.a(str1)) || (!d(str1)) || (z[61].equals(str1.toLowerCase(Locale.getDefault()))))
      {
        str1 = x(paramContext);
        if ((ai.a(str1)) || (!d(str1)))
        {
          str1 = z(paramContext);
          if (str1 == null)
            return " ";
        }
      }
    }
    catch (Exception localException)
    {
      x.j();
      str1 = z(paramContext);
    }
    return str1;
  }

  // ERROR //
  private static String z(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 638	cn/jpush/android/util/x:c	()V
    //   3: aload_0
    //   4: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   7: bipush 53
    //   9: aaload
    //   10: iconst_0
    //   11: invokevirtual 1340	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   14: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   17: bipush 55
    //   19: aaload
    //   20: aconst_null
    //   21: invokeinterface 1345 3 0
    //   26: astore_1
    //   27: aload_1
    //   28: invokestatic 431	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   31: ifne +5 -> 36
    //   34: aload_1
    //   35: areturn
    //   36: invokestatic 390	cn/jpush/android/util/a:a	()Z
    //   39: ifne +79 -> 118
    //   42: aload_0
    //   43: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   46: bipush 53
    //   48: aaload
    //   49: iconst_0
    //   50: invokevirtual 1340	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   53: astore 16
    //   55: aload 16
    //   57: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   60: bipush 55
    //   62: aaload
    //   63: aconst_null
    //   64: invokeinterface 1345 3 0
    //   69: astore_1
    //   70: aload_1
    //   71: ifnonnull -37 -> 34
    //   74: invokestatic 454	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   77: invokevirtual 455	java/util/UUID:toString	()Ljava/lang/String;
    //   80: astore 17
    //   82: aload 16
    //   84: invokeinterface 1349 1 0
    //   89: astore 18
    //   91: aload 18
    //   93: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   96: bipush 55
    //   98: aaload
    //   99: aload 17
    //   101: invokeinterface 1354 3 0
    //   106: pop
    //   107: aload 18
    //   109: invokeinterface 1357 1 0
    //   114: pop
    //   115: aload 17
    //   117: areturn
    //   118: aload_0
    //   119: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   122: bipush 54
    //   124: aaload
    //   125: aconst_null
    //   126: invokestatic 1096	cn/jpush/android/util/ae:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnonnull -97 -> 34
    //   134: new 333	java/io/File
    //   137: dup
    //   138: getstatic 354	cn/jpush/android/util/a:e	Ljava/lang/String;
    //   141: invokespecial 398	java/io/File:<init>	(Ljava/lang/String;)V
    //   144: astore_2
    //   145: aload_2
    //   146: invokevirtual 401	java/io/File:exists	()Z
    //   149: ifeq +77 -> 226
    //   152: new 403	java/io/FileInputStream
    //   155: dup
    //   156: aload_2
    //   157: invokespecial 406	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   160: invokestatic 411	cn/jpush/android/util/m:a	(Ljava/io/InputStream;)Ljava/util/ArrayList;
    //   163: astore 13
    //   165: aload 13
    //   167: invokevirtual 415	java/util/ArrayList:size	()I
    //   170: ifle +56 -> 226
    //   173: aload 13
    //   175: iconst_0
    //   176: invokevirtual 419	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   179: checkcast 28	java/lang/String
    //   182: astore 14
    //   184: aload_0
    //   185: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   188: bipush 54
    //   190: aaload
    //   191: aload 14
    //   193: invokestatic 1101	cn/jpush/android/util/ae:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   196: new 324	java/lang/StringBuilder
    //   199: dup
    //   200: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   203: bipush 52
    //   205: aaload
    //   206: invokespecial 420	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: aload 14
    //   211: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: pop
    //   218: invokestatic 422	cn/jpush/android/util/x:d	()V
    //   221: aload 14
    //   223: areturn
    //   224: astore 12
    //   226: new 324	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 325	java/lang/StringBuilder:<init>	()V
    //   233: invokestatic 694	java/lang/System:currentTimeMillis	()J
    //   236: invokevirtual 1360	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   239: invokevirtual 346	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokevirtual 1220	java/lang/String:getBytes	()[B
    //   245: invokestatic 1364	java/util/UUID:nameUUIDFromBytes	([B)Ljava/util/UUID;
    //   248: invokevirtual 455	java/util/UUID:toString	()Ljava/lang/String;
    //   251: invokestatic 1366	cn/jpush/android/util/ai:b	(Ljava/lang/String;)Ljava/lang/String;
    //   254: astore_1
    //   255: aload_0
    //   256: getstatic 296	cn/jpush/android/util/a:z	[Ljava/lang/String;
    //   259: bipush 54
    //   261: aaload
    //   262: aload_1
    //   263: invokestatic 1101	cn/jpush/android/util/ae:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload_2
    //   267: invokevirtual 1215	java/io/File:createNewFile	()Z
    //   270: pop
    //   271: new 1217	java/io/FileOutputStream
    //   274: dup
    //   275: aload_2
    //   276: invokespecial 1218	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   279: astore 5
    //   281: aload 5
    //   283: aload_1
    //   284: invokevirtual 1220	java/lang/String:getBytes	()[B
    //   287: invokevirtual 1223	java/io/FileOutputStream:write	([B)V
    //   290: aload 5
    //   292: invokevirtual 1226	java/io/FileOutputStream:flush	()V
    //   295: invokestatic 422	cn/jpush/android/util/x:d	()V
    //   298: aload 5
    //   300: ifnull -266 -> 34
    //   303: aload 5
    //   305: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   308: aload_1
    //   309: areturn
    //   310: astore 10
    //   312: aload_1
    //   313: areturn
    //   314: astore_3
    //   315: invokestatic 1049	cn/jpush/android/util/x:j	()V
    //   318: aload_1
    //   319: areturn
    //   320: astore 11
    //   322: aconst_null
    //   323: astore 5
    //   325: invokestatic 1049	cn/jpush/android/util/x:j	()V
    //   328: aload 5
    //   330: ifnull -296 -> 34
    //   333: aload 5
    //   335: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   338: aload_1
    //   339: areturn
    //   340: astore 9
    //   342: aload_1
    //   343: areturn
    //   344: astore 7
    //   346: aconst_null
    //   347: astore 5
    //   349: aload 5
    //   351: ifnull +8 -> 359
    //   354: aload 5
    //   356: invokevirtual 1227	java/io/FileOutputStream:close	()V
    //   359: aload 7
    //   361: athrow
    //   362: astore 8
    //   364: goto -5 -> 359
    //   367: astore 7
    //   369: goto -20 -> 349
    //   372: astore 6
    //   374: goto -49 -> 325
    //
    // Exception table:
    //   from	to	target	type
    //   152	221	224	java/io/FileNotFoundException
    //   303	308	310	java/io/IOException
    //   266	271	314	java/io/IOException
    //   271	281	320	java/io/IOException
    //   333	338	340	java/io/IOException
    //   271	281	344	finally
    //   354	359	362	java/io/IOException
    //   281	298	367	finally
    //   325	328	367	finally
    //   281	298	372	java/io/IOException
  }

  private static String z(char[] paramArrayOfChar)
  {
    int k = paramArrayOfChar.length;
    int m = 0;
    if (k <= 1);
    label116: 
    while (k > m)
    {
      char[] arrayOfChar = paramArrayOfChar;
      int n = m;
      int i1 = paramArrayOfChar[m];
      int i2;
      switch (n % 5)
      {
      default:
        i2 = 57;
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        paramArrayOfChar[m] = ((char)(i2 ^ i1));
        m = n + 1;
        if (k != 0)
          break label116;
        paramArrayOfChar = arrayOfChar;
        n = m;
        m = k;
        break;
        i2 = 40;
        continue;
        i2 = 14;
        continue;
        i2 = 92;
        continue;
        i2 = 117;
      }
      paramArrayOfChar = arrayOfChar;
    }
    return new String(paramArrayOfChar).intern();
  }

  private static char[] z(String paramString)
  {
    Object localObject1 = paramString.toCharArray();
    Object localObject2 = localObject1;
    while (true)
    {
      int k = localObject1.length;
      if (k < 2)
      {
        if (k != 0)
          localObject2[0] = ((char)(0x39 ^ localObject2[0]));
      }
      else
        return localObject2;
      localObject1 = localObject2;
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.util.a
 * JD-Core Version:    0.6.2
 */