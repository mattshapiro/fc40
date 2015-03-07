package cn.jpush.android.api;

import android.app.NotificationManager;
import android.content.Context;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.service.PushService;
import cn.jpush.android.service.ServiceInterface;
import cn.jpush.android.service.g;
import cn.jpush.android.util.a;
import cn.jpush.android.util.ab;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.x;
import cn.jpush.android.util.z;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JPushInterface
{
  public static final String ACTION_ACTIVITY_OPENDED;
  public static final String ACTION_CONNECTION_CHANGE;
  public static final String ACTION_MESSAGE_RECEIVED;
  public static final String ACTION_NOTIFICATION_OPENED;
  public static final String ACTION_NOTIFICATION_RECEIVED;
  public static final String ACTION_NOTIFICATION_RECEIVED_PROXY;
  public static final String ACTION_REGISTRATION_ID;
  public static final String ACTION_RESTOREPUSH;
  public static final String ACTION_RICHPUSH_CALLBACK;
  public static final String ACTION_STATUS;
  public static final String ACTION_STOPPUSH;
  public static final String ACTION_UNREGISTER;
  public static final String EXTRA_ACTIVITY_PARAM;
  public static final String EXTRA_ALERT;
  public static final String EXTRA_APP_KEY;
  public static final String EXTRA_CONNECTION_CHANGE;
  public static final String EXTRA_CONTENT_TYPE;
  public static final String EXTRA_EXTRA;
  public static final String EXTRA_MESSAGE;
  public static final String EXTRA_MSG_ID;
  public static final String EXTRA_NOTIFICATION_DEVELOPER_ARG0;
  public static final String EXTRA_NOTIFICATION_ID;
  public static final String EXTRA_NOTIFICATION_TITLE;
  public static final String EXTRA_NOTI_TYPE;
  public static final String EXTRA_PUSH_ID;
  public static final String EXTRA_REGISTRATION_ID;
  public static final String EXTRA_RICHPUSH_FILE_PATH;
  public static final String EXTRA_RICHPUSH_FILE_TYPE;
  public static final String EXTRA_RICHPUSH_HTML_PATH;
  public static final String EXTRA_RICHPUSH_HTML_RES;
  public static final String EXTRA_STATUS;
  public static final String EXTRA_TITLE;
  private static final Integer a;
  private static ConcurrentHashMap<Integer, PushNotificationBuilder> b;
  private static e c;
  private static ConcurrentLinkedQueue<Long> d;
  private static final String[] z;

  static
  {
    Object localObject1 = new String[50];
    int i = 0;
    String str1 = "}{1 kfw;1pqmz9z;O@\003VJVQ";
    int j = 49;
    Object localObject2 = localObject1;
    Object localObject3 = str1.toCharArray();
    int k = localObject3.length;
    int m = 0;
    label37: Object localObject4;
    int n;
    int i1;
    Object localObject5;
    label53: int i2;
    int i3;
    if (k <= 1)
    {
      localObject4 = localObject3;
      n = m;
      i1 = k;
      localObject5 = localObject3;
      i2 = localObject5[m];
      switch (n % 5)
      {
      default:
        i3 = 80;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      localObject5[m] = ((char)(i3 ^ i2));
      m = n + 1;
      if (i1 == 0)
      {
        localObject5 = localObject4;
        n = m;
        m = i1;
        break label53;
        EXTRA_PUSH_ID = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\021]AVZ\036AT\\A\031H\\KL\017QEZ[\024[Q";
        j = 50;
        break;
        ACTION_ACTIVITY_OPENDED = str2;
        str1 = "}{1 kfw;1pqmz9z;K\\\004RP";
        j = 51;
        break;
        EXTRA_TITLE = str2;
        str1 = "}{1 kfw;1pqmz9z;QZ\004WSVV\021J\\P[\017JLOP";
        j = 52;
        break;
        EXTRA_NOTI_TYPE = str2;
        str1 = "}{1 kfw;1pqmz9z;ZM\004LT";
        j = 53;
        break;
        EXTRA_EXTRA = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\002[RVF\004LTK\\\037P";
        j = 54;
        break;
        ACTION_REGISTRATION_ID = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\036QAVS\031]TK\\\037PJMP\023[\\IP\024AEMZ\bG";
        j = 55;
        break;
        ACTION_NOTIFICATION_RECEIVED_PROXY = str2;
        str1 = "}{1 kfw;1pqmz9z;QZ\004WSVV\021J\\P[\017WQ";
        j = 56;
        break;
        EXTRA_NOTIFICATION_ID = str2;
        str1 = "}{1 kfw;1pqmz9z;^V\004WCVA\tAE^G\021S";
        j = 57;
        break;
        EXTRA_ACTIVITY_PARAM = str2;
        str1 = "}{1 kfw;1pqmz9z;RF\027A\\[";
        j = 58;
        break;
        EXTRA_MSG_ID = str2;
        str1 = "}{1 kfw;1pqmz9z;Y\\\034[JOT\004V";
        j = 59;
        break;
        EXTRA_RICHPUSH_FILE_PATH = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\036QAVS\031]TK\\\037PJMP\023[\\IP\024";
        j = 60;
        break;
        ACTION_NOTIFICATION_RECEIVED = str2;
        str1 = "}{1 kfw;1pqmz9z;\\Z\036JPQA\017JLOP";
        j = 61;
        break;
        EXTRA_CONTENT_TYPE = str2;
        str1 = "";
        j = 62;
        break;
        EXTRA_APP_KEY = str2;
        str1 = "}{1 kfw;1pqmz9z;QZ\004WSVV\021J\\P[\017ZPIP\034QEZG\017_GX%";
        j = 63;
        break;
        EXTRA_NOTIFICATION_DEVELOPER_ARG0 = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\021]AVZ\036AGVV\030N@L]\017]TSY\022_VT";
        j = 64;
        break;
        ACTION_RICHPUSH_CALLBACK = str2;
        str1 = "}{1 kfw;1pqmz9z;WA\035RJMP\003";
        j = 65;
        break;
        EXTRA_RICHPUSH_HTML_RES = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\035[FLT\027[JMP\023[\\IP\024";
        j = 66;
        break;
        ACTION_MESSAGE_RECEIVED = str2;
        str1 = "";
        j = 67;
        break;
        EXTRA_RICHPUSH_FILE_TYPE = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\005PGZR\031MAMT\004WZQ";
        j = 68;
        break;
        ACTION_UNREGISTER = str2;
        str1 = "}{1 kfw;1pqmz9z;WA\035RJOT\004V";
        j = 69;
        break;
        EXTRA_RICHPUSH_HTML_PATH = str2;
        str1 = "}{1 kfw;1pqmz9z;^Y\025LA";
        j = 70;
        break;
        EXTRA_ALERT = str2;
        str1 = "}{1 kfw;1pqmz9z;RP\003MTXP";
        j = 71;
        break;
        EXTRA_MESSAGE = str2;
        str1 = "}{1 kfw;1pqmz9z;\\Z\036PP\\A\031Q[@V\030_[XP";
        j = 72;
        break;
        EXTRA_CONNECTION_CHANGE = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\023Q[QP\023J\\P[";
        j = 73;
        break;
        ACTION_CONNECTION_CHANGE = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\002[FKZ\002[EJF\030";
        j = 74;
        break;
        ACTION_RESTOREPUSH = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\003JZOE\005M]";
        j = 75;
        break;
        ACTION_STOPPUSH = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\036QAVS\031]TK\\\037PJPE\025PP[";
        j = 76;
        break;
        ACTION_NOTIFICATION_OPENED = str2;
        str1 = "}{1 kfw;1pqmz9z;MP\027WFKG\021J\\P[\017WQ";
        j = 77;
        break;
        EXTRA_REGISTRATION_ID = str2;
        str1 = "}{1 kfw;1pqmz9z;QZ\004WSVV\021J\\P[\017]ZQA\025PA@A\031JYZ";
        j = 78;
        break;
        EXTRA_NOTIFICATION_TITLE = str2;
        str1 = "}{1 kfw;1pqmz9z;v{${{k;\003JTK@\003";
        j = 79;
        break;
        ACTION_STATUS = str2;
        str1 = "}{1 kfw;1pqmz9z;LA\021J@L";
        j = 80;
        break;
        EXTRA_STATUS = str2;
        str1 = "P@SYppzk|6wv~a9q{";
        j = -1;
        break;
      }
      k = i1;
      localObject3 = localObject4;
      if (k > m)
        break label37;
      String str2 = new String((char[])localObject3).intern();
      switch (j)
      {
      case 49:
      case 50:
      case 51:
      case 52:
      case 53:
      case 54:
      case 55:
      case 56:
      case 57:
      case 58:
      case 59:
      case 60:
      case 61:
      case 62:
      case 63:
      case 64:
      case 65:
      case 66:
      case 67:
      case 68:
      case 69:
      case 70:
      case 71:
      case 72:
      case 73:
      case 74:
      case 75:
      case 76:
      case 77:
      case 78:
      case 79:
      case 80:
      default:
        localObject1[i] = str2;
        i = 1;
        str1 = "vk|?p/xp$N`l}\036qavs9}tk|?pWj|<zpm5j>";
        localObject1 = localObject2;
        j = 0;
        break;
      case 0:
        localObject1[i] = str2;
        i = 2;
        str1 = "]`la?s|ep4>wj|<zpm56lzr5#czqpngzs5lpqv5>8?";
        j = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i] = str2;
        i = 3;
        str1 = "TEjf8W{kp\"xt|p";
        j = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i] = str2;
        i = 4;
        str1 = "P@SYp}zqa5fa";
        j = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i] = str2;
        i = 5;
        str1 = "W{it<wq?a1y5%5";
        j = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i] = str2;
        i = 6;
        str1 = "J}z5<{{x}$>zy5$rl5=l}ppszmppj}~{p/%/;";
        j = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i] = str2;
        i = 7;
        str1 = "25h|<r5qz$>fzapyvt#>aw|#>avx50";
        j = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i] = str2;
        i = 8;
        str1 = "25kt7m/";
        j = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i] = str2;
        i = 9;
        str1 = "vk|?p/lp$_yvt#_{{A1yf?8pyvt#$";
        j = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i] = str2;
        i = 10;
        str1 = "W{it<wq?t<wtl/p";
        j = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i] = str2;
        i = 11;
        str1 = "W{it<wq?a1yf35'wys5>qa?f5j5kt7m5k}9m5k|={;";
        j = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i] = str2;
        i = 12;
        str1 = "P@SYpyvt#>tqqpjtxf~>Rvc5>`o51}avz>0";
        j = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i] = str2;
        i = 13;
        str1 = "棞浞刯彆初沿朜罎绉げ歺劽佃尓坸朗罄练旣膺劶绲绲扲蠜〜";
        j = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i] = str2;
        i = 14;
        str1 = "J}z5<{{xa8>zy5$rl5#vzjy4>wz5<{fl5$vtq5a.'+52gazf~";
        j = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i] = str2;
        i = 15;
        str1 = "J}z5=mrVqpwf?{?j5it<wq?8p";
        j = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i] = str2;
        i = 16;
        str1 = "pzk|6vk|?pJq`=";
        j = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i] = str2;
        i = 17;
        str1 = "vk|?p/v{9j9?A8{5lq;>czg#wzq59m5";
        j = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i] = str2;
        i = 18;
        str1 = "";
        j = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i] = str2;
        i = 19;
        str1 = "pzk|6wv~a9q{";
        j = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i] = str2;
        i = 20;
        str1 = "W{it<wq?{?j|y|3avz>Wq35\027wcz5%n5~v$wzq;~";
        j = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i] = str2;
        i = 21;
        str1 = "mpmc9}p@v?p{zv5j";
        j = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i] = str2;
        i = 22;
        str1 = "vk|?p/la?nEjf8";
        j = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i] = str2;
        i = 23;
        str1 = "7i7";
        j = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i] = str2;
        i = 24;
        str1 = "6N/8iCi.N`3,BibE%2&\r7IA=\013.8&H,/N/8iCi-N`3&B<";
        j = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i] = str2;
        i = 25;
        str1 = "vk|?p/lp$N`l}\004wxz5}>vsz#{q";
        j = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i] = str2;
        i = 26;
        str1 = "vk|?p/lp$N`l}\004wxz5}>pqt2rp{/";
        j = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i] = str2;
        i = 27;
        str1 = "6N/8fCn/9gc<@=x";
        j = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i] = str2;
        i = 28;
        str1 = "W{it<wq?a9sp?s?lx~ap35";
        j = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i] = str2;
        i = 29;
        str1 = "7<";
        j = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[i] = str2;
        i = 30;
        str1 = "3<4=";
        j = 29;
        localObject1 = localObject2;
        break;
      case 29:
        localObject1[i] = str2;
        i = 31;
        str1 = "25o`#vAvx5$";
        j = 30;
        localObject1 = localObject2;
        break;
      case 30:
        localObject1[i] = str2;
        i = 32;
        str1 = ".$-&d+#@%\016,&";
        j = 31;
        localObject1 = localObject2;
        break;
      case 31:
        localObject1[i] = str2;
        i = 33;
        str1 = "W{it<wq?a9sp?s?lx~ap35la1laWz%l5l}?ky{5<{fl5$vtq55pqWz%l";
        j = 32;
        localObject1 = localObject2;
        break;
      case 32:
        localObject1[i] = str2;
        i = 34;
        str1 = "W{it<wq?q1g5yz\"stk5}>";
        j = 33;
        localObject1 = localObject2;
        break;
      case 33:
        localObject1[i] = str2;
        i = 35;
        str1 = "stg[%s5l}?ky{5n>%35\027wcz5%n5~v$wzq;~";
        j = 34;
        localObject1 = localObject2;
        break;
      case 34:
        localObject1[i] = str2;
        i = 36;
        str1 = "W{it<wq?a1y/?";
        j = 35;
        localObject1 = localObject2;
        break;
      case 35:
        localObject1[i] = str2;
        i = 37;
        str1 = "vk|?p/mp#kxzE%m}";
        j = 36;
        localObject1 = localObject2;
        break;
      case 36:
        localObject1[i] = str2;
        i = 38;
        str1 = "mplf5wzq5$wxzz%j5st\"ypm5$vtq5aztf";
        j = 37;
        localObject1 = localObject2;
        break;
      case 37:
        localObject1[i] = str2;
        i = 39;
        str1 = "mplf5wzq5$wxzz%j5sp#m5k}1p5.%#";
        j = 38;
        localObject1 = localObject2;
        break;
      case 38:
        localObject1[i] = str2;
        i = 40;
        str1 = "J}z5\036qavs9}tk|?p5]`9rqzgpwq?t<lp~q)>pgf9jf?8p";
        j = 39;
        localObject1 = localObject2;
        break;
      case 39:
        localObject1[i] = str2;
        i = 41;
        str1 = "wq?f8q`sqp|p?y1lrzgpj}~{p.";
        j = 40;
        localObject1 = localObject2;
        break;
      case 40:
        localObject1[i] = str2;
        i = 42;
        str1 = "P@SYpn`l}\036qavs9}tk|?pWj|<zpm";
        j = 41;
        localObject1 = localObject2;
        break;
      case 41:
        localObject1[i] = str2;
        i = 43;
        str1 = "vk|?p/lp$N`l}\036qavs9}tk|?pWj|<zpm5}>|{/";
        j = 42;
        localObject1 = localObject2;
        break;
      case 42:
        localObject1[i] = str2;
        i = 44;
        str1 = "W{it<wq?a9sp?s?lx~ap35la1laK|={5l}?ky{5<{fl5$vtq55pqK|={";
        j = 43;
        localObject1 = localObject2;
        break;
      case 43:
        localObject1[i] = str2;
        i = 45;
        str1 = ">825";
        j = 44;
        localObject1 = localObject2;
        break;
      case 44:
        localObject1[i] = str2;
        i = 46;
        str1 = ">/?";
        j = 45;
        localObject1 = localObject2;
        break;
      case 45:
        localObject1[i] = str2;
        i = 47;
        str1 = "Mpk5\003wyz{3{5O`#vAvx5>8?";
        j = 46;
        localObject1 = localObject2;
        break;
      case 46:
        localObject1[i] = str2;
        i = 48;
        str1 = "W{it<wq?e1ltrp${g?s?lx~a|>fkt\"j]p`\">tqqp{{{]?kg?f8q`sqp|pkb5{{?%p`5-&|>fkt\"jXv{#>tqqp{{{X9pf?f8q`sqp|pkb5{{?%p`5*,~>";
        j = 47;
        localObject1 = localObject2;
        break;
      case 47:
        localObject1[i] = str2;
        i = 49;
        str1 = "Mpk5\003wyz{3{5O`#vAvx5>S~|<{q";
        j = 48;
        localObject1 = localObject2;
        break;
      case 48:
        localObject1[i] = str2;
        z = localObject2;
        a = Integer.valueOf(0);
        b = new ConcurrentHashMap();
        c = e.b();
        d = new ConcurrentLinkedQueue();
        return;
        i3 = 30;
        continue;
        i3 = 21;
        continue;
        i3 = 31;
        continue;
        i3 = 21;
      }
    }
  }

  private static String a(Set<String> paramSet)
  {
    Object localObject1 = null;
    if (paramSet == null);
    int i;
    label30: String str;
    label73: int j;
    do
    {
      return localObject1;
      if (paramSet.isEmpty())
        return "";
      i = 0;
      Iterator localIterator = paramSet.iterator();
      if (!localIterator.hasNext())
        break;
      str = (String)localIterator.next();
      if ((ai.a(str)) || (!z.a(str)))
        break label126;
      if (localObject1 != null)
        break label97;
      localObject1 = str;
      j = i + 1;
    }
    while (j >= 100);
    for (Object localObject2 = localObject1; ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      i = j;
      break label30;
      break;
      label97: localObject1 = (String)localObject1 + "," + str;
      break label73;
      label126: x.e(z[3], z[36] + str);
      j = i;
    }
  }

  private static void a(Context paramContext, String paramString, Set<String> paramSet, TagAliasCallback paramTagAliasCallback, boolean paramBoolean)
  {
    if (paramContext == null)
      throw new IllegalArgumentException(z[4]);
    if ((PushService.b) && (!a.b(paramContext)))
      x.b(z[3], z[13]);
    if (paramString != null)
    {
      int m = z.b(paramString);
      if (m != 0)
      {
        x.b(z[3], z[10] + paramString + z[7]);
        if (paramTagAliasCallback != null)
          paramTagAliasCallback.gotResult(m, paramString, paramSet);
      }
    }
    String str1;
    do
    {
      int k;
      do
      {
        return;
        if ((paramTagAliasCallback == null) && (!paramBoolean))
          paramSet = filterValidTags(paramSet);
        if (paramSet == null)
          break;
        k = z.a(paramSet);
        if (k == 0)
          break;
        x.b(z[3], z[11]);
      }
      while (paramTagAliasCallback == null);
      paramTagAliasCallback.gotResult(k, paramString, paramSet);
      return;
      str1 = a(paramSet);
      if ((paramString != null) || (str1 != null))
        break;
      x.e(z[3], z[12]);
    }
    while (paramTagAliasCallback == null);
    paramTagAliasCallback.gotResult(d.a, paramString, paramSet);
    return;
    String str2;
    if (str1 != null)
    {
      str2 = str1.replaceAll(",", "");
      if (ai.a(str2))
        break label359;
    }
    label359: for (int i = 0 + str2.getBytes().length; ; i = 0)
    {
      int j = 0;
      if (i <= 1000)
        j = 1;
      if (j == 0)
      {
        if (paramTagAliasCallback != null)
          paramTagAliasCallback.gotResult(d.h, paramString, paramSet);
        x.e(z[3], z[14]);
        return;
      }
      x.b(z[3], z[9] + paramString + z[8] + str1);
      ServiceInterface.a(paramContext, paramString, str1, new b(paramString, paramSet, paramTagAliasCallback));
      return;
    }
  }

  private static void a(Context paramContext, boolean paramBoolean, String paramString)
  {
    x.c();
    if (paramContext == null)
      throw new IllegalArgumentException(z[4]);
    if (!paramBoolean)
    {
      ServiceInterface.a(paramContext, paramBoolean, paramString);
      x.b(z[3], z[25]);
      return;
    }
    String str = z[24];
    if (Pattern.compile(z[27] + str + z[23] + str + z[30] + str + z[29]).matcher(paramString).matches())
    {
      ServiceInterface.a(paramContext, paramBoolean, paramString);
      x.b(z[3], z[26] + paramBoolean + z[31] + paramString);
      return;
    }
    x.e(z[3], z[28] + paramString);
  }

  static boolean a(int paramInt)
  {
    if (paramInt <= 0);
    while (b.get(Integer.valueOf(paramInt)) == null)
      return false;
    return true;
  }

  public static void addLocalNotification(Context paramContext, JPushLocalNotification paramJPushLocalNotification)
  {
    g.a(paramContext).a(paramContext, paramJPushLocalNotification);
  }

  static PushNotificationBuilder b(int paramInt)
  {
    x.a(z[3], z[1] + paramInt);
    if (paramInt <= 0)
      paramInt = a.intValue();
    Object localObject = (PushNotificationBuilder)b.get(Integer.valueOf(paramInt));
    if (localObject == null)
      x.c();
    try
    {
      String str = ab.a(paramInt);
      boolean bool = ai.a(str);
      if (bool);
      PushNotificationBuilder localPushNotificationBuilder;
      for (localObject = null; ; localObject = localPushNotificationBuilder)
      {
        if (localObject == null)
        {
          x.c();
          localObject = new DefaultPushNotificationBuilder();
        }
        return localObject;
        new StringBuilder(z[2]).append(str).toString();
        x.b();
        localPushNotificationBuilder = BasicPushNotificationBuilder.a(str);
      }
    }
    catch (Exception localException)
    {
      while (true)
        x.h();
    }
  }

  public static void clearAllNotifications(Context paramContext)
  {
    ServiceInterface.g(paramContext);
  }

  public static void clearLocalNotifications(Context paramContext)
  {
    g.a(paramContext);
    g.b(paramContext);
  }

  public static void clearNotificationById(Context paramContext, int paramInt)
  {
    if (paramInt <= 0)
    {
      x.e(z[3], z[20]);
      return;
    }
    ((NotificationManager)paramContext.getSystemService(z[19])).cancel(paramInt);
  }

  public static Set<String> filterValidTags(Set<String> paramSet)
  {
    if (paramSet == null)
      paramSet = null;
    while (paramSet.isEmpty())
      return paramSet;
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    Iterator localIterator = paramSet.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      String str = (String)localIterator.next();
      if ((!ai.a(str)) && (z.a(str)))
      {
        localLinkedHashSet.add(str);
        j = i + 1;
        if (j >= 100)
        {
          x.d(z[3], z[6]);
          return localLinkedHashSet;
        }
      }
      else
      {
        x.e(z[3], z[5] + str);
        j = i;
      }
    }
    return localLinkedHashSet;
  }

  public static boolean getConnectionState(Context paramContext)
  {
    return ae.a(paramContext, z[21], 0) == 1;
  }

  public static String getRegistrationID(Context paramContext)
  {
    return a.u(paramContext);
  }

  public static String getUdid(Context paramContext)
  {
    return a.l(paramContext);
  }

  public static void init(Context paramContext)
  {
    x.b(z[3], z[17] + ServiceInterface.b());
    if (paramContext == null)
      throw new IllegalArgumentException(z[4]);
    if ((PushService.b) && (!a.b(paramContext)))
      x.b(z[3], z[13]);
    ab.a(paramContext.getApplicationContext());
    if (ae.a(paramContext, z[16], -1) == -1)
      setLatestNotificationNumber(paramContext, 5);
    if (!ServiceInterface.a())
    {
      x.e(z[3], z[18]);
      System.exit(-1);
    }
    ServiceInterface.a(paramContext);
  }

  public static void initCrashHandler(Context paramContext)
  {
    c.a().a(paramContext);
  }

  public static boolean isPushStopped(Context paramContext)
  {
    if (paramContext == null)
      throw new IllegalArgumentException(z[4]);
    return ServiceInterface.h(paramContext);
  }

  public static void onFragmentPause(Context paramContext, String paramString)
  {
    c.b(paramContext, paramString);
  }

  public static void onFragmentResume(Context paramContext, String paramString)
  {
    c.a(paramContext, paramString);
  }

  public static void onKillProcess(Context paramContext)
  {
    c.c(paramContext);
  }

  public static void onPause(Context paramContext)
  {
    c.b(paramContext);
  }

  public static void onResume(Context paramContext)
  {
    c.a(paramContext);
  }

  public static void removeLocalNotification(Context paramContext, long paramLong)
  {
    g.a(paramContext);
    g.a(paramContext, paramLong);
  }

  public static void reportNotificationOpened(Context paramContext, String paramString)
  {
    if (ai.a(paramString))
      x.e(z[3], z[15] + paramString);
    ServiceInterface.a(paramString, 1028, paramContext);
  }

  public static void resumePush(Context paramContext)
  {
    x.b(z[3], z[37]);
    if (paramContext == null)
      throw new IllegalArgumentException(z[4]);
    ServiceInterface.b(paramContext, 1);
  }

  public static void setAlias(Context paramContext, String paramString, TagAliasCallback paramTagAliasCallback)
  {
    setAliasAndTags(paramContext, paramString, null, paramTagAliasCallback);
  }

  public static void setAliasAndTags(Context paramContext, String paramString, Set<String> paramSet)
  {
    a(paramContext, paramString, paramSet, null, false);
  }

  public static void setAliasAndTags(Context paramContext, String paramString, Set<String> paramSet, TagAliasCallback paramTagAliasCallback)
  {
    long l = System.currentTimeMillis();
    int i;
    if (d.size() < 10)
    {
      d.offer(Long.valueOf(l));
      i = 1;
    }
    while (i == 0)
    {
      x.e();
      if (paramTagAliasCallback != null)
        paramTagAliasCallback.gotResult(d.k, paramString, paramSet);
      return;
      if (l - ((Long)d.element()).longValue() > 10000L)
      {
        while (d.size() >= 10)
          d.poll();
        d.offer(Long.valueOf(l));
        i = 1;
      }
      else
      {
        i = 0;
      }
    }
    a(paramContext, paramString, paramSet, paramTagAliasCallback, true);
  }

  public static void setDebugMode(boolean paramBoolean)
  {
    PushService.b = paramBoolean;
  }

  public static void setDefaultPushNotificationBuilder(BasicPushNotificationBuilder paramBasicPushNotificationBuilder)
  {
    if (paramBasicPushNotificationBuilder == null)
      throw new IllegalArgumentException(z[0]);
    b.put(a, paramBasicPushNotificationBuilder);
    ab.c(a, paramBasicPushNotificationBuilder.toString());
  }

  public static void setLatestNotificationNumber(Context paramContext, int paramInt)
  {
    if (paramInt <= 0)
    {
      x.e(z[3], z[35]);
      return;
    }
    ServiceInterface.d(paramContext, paramInt);
  }

  public static void setPushNotificationBuilder(Integer paramInteger, BasicPushNotificationBuilder paramBasicPushNotificationBuilder)
  {
    x.a(z[3], z[43] + paramInteger);
    if (paramBasicPushNotificationBuilder == null)
      throw new IllegalArgumentException(z[42]);
    if (paramInteger.intValue() <= 0)
    {
      x.e(z[3], z[41]);
      return;
    }
    if (b.containsKey(paramInteger))
      x.d(z[3], z[40] + paramInteger);
    ab.c(paramInteger, paramBasicPushNotificationBuilder.toString());
    b.put(paramInteger, paramBasicPushNotificationBuilder);
  }

  public static void setPushTime(Context paramContext, Set<Integer> paramSet, int paramInt1, int paramInt2)
  {
    if ((PushService.b) && (!a.b(paramContext)))
      x.b(z[3], z[13]);
    if (paramSet == null)
    {
      a(paramContext, true, z[32]);
      return;
    }
    if ((paramSet.size() == 0) || (paramSet.isEmpty()))
    {
      a(paramContext, false, z[32]);
      return;
    }
    if (paramInt1 > paramInt2)
    {
      x.e(z[3], z[33]);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      if ((localInteger.intValue() > 6) || (localInteger.intValue() < 0))
      {
        x.e(z[3], z[34] + localInteger);
        return;
      }
      localStringBuilder.append(localInteger);
    }
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("^");
    localStringBuilder.append(paramInt2);
    a(paramContext, true, localStringBuilder.toString());
  }

  public static void setSilenceTime(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt3 < 0) || (paramInt4 < 0) || (paramInt2 > 59) || (paramInt4 > 59) || (paramInt3 > 23) || (paramInt1 > 23))
    {
      x.e(z[3], z[48]);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0))
    {
      ServiceInterface.a(paramContext, "");
      return;
    }
    if ((paramInt1 == paramInt3) && (paramInt2 > paramInt4))
    {
      x.e(z[3], z[44]);
      return;
    }
    if (ServiceInterface.a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4))
    {
      x.b(z[3], z[47] + paramInt1 + z[46] + paramInt2 + z[45] + paramInt3 + z[46] + paramInt4);
      return;
    }
    x.e(z[3], z[49]);
  }

  public static void setStatisticsEnable(boolean paramBoolean)
  {
    c.a(paramBoolean);
  }

  public static void setStatisticsSessionTimeout(long paramLong)
  {
    if (paramLong < 10L)
    {
      x.d(z[3], z[39]);
      return;
    }
    if (paramLong > 86400L)
    {
      x.d(z[3], z[38]);
      return;
    }
    c.a(paramLong);
  }

  public static void setTags(Context paramContext, Set<String> paramSet, TagAliasCallback paramTagAliasCallback)
  {
    setAliasAndTags(paramContext, null, paramSet, paramTagAliasCallback);
  }

  public static void stopPush(Context paramContext)
  {
    x.b(z[3], z[22]);
    if (paramContext == null)
      throw new IllegalArgumentException(z[4]);
    ServiceInterface.a(paramContext, 1);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.api.JPushInterface
 * JD-Core Version:    0.6.2
 */