package cn.jpush.android.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.api.b;
import cn.jpush.android.c;
import cn.jpush.android.data.e;
import cn.jpush.android.data.r;
import cn.jpush.android.util.JLogger;
import cn.jpush.android.util.JRecorder;
import cn.jpush.android.util.aa;
import cn.jpush.android.util.ae;
import cn.jpush.android.util.ai;
import cn.jpush.android.util.aj;
import cn.jpush.android.util.q;
import cn.jpush.android.util.x;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class PushService extends Service
{
  public static String A;
  public static boolean B;
  public static boolean C;
  public static int D = 0;
  private static long E;
  private static long F;
  private static boolean G;
  private static boolean H;
  private static String I;
  private static String J;
  private static int K;
  private static String L;
  private static String M;
  private static int N;
  private static int O;
  private static String P;
  private static boolean V;
  private static boolean W;
  private static int X;
  private static boolean Z;
  public static long a;
  private static List<String> aa;
  private static Queue<e> aj = new LinkedList();
  private static String ak = null;
  private static String al = null;
  private static String am = null;
  public static boolean b;
  private static final String[] bb;
  public static boolean c;
  public static int d;
  public static long e;
  public static long f;
  public static long g;
  public static long h;
  public static int i;
  public static long j;
  public static long k;
  public static long l;
  public static long m;
  public static long n;
  public static String o;
  public static int p;
  public static boolean q;
  public static boolean r;
  protected static long s;
  protected static String t;
  protected static String u;
  public static boolean z;
  private n Q;
  private boolean R;
  private boolean S;
  private boolean T = false;
  private boolean U = true;
  private cn.jpush.android.a.d Y;
  private int ab;
  private int ac;
  private long ad;
  private long ae;
  private int af;
  private int ag = -1;
  private int ah = -1;
  private volatile boolean ai = false;
  private Handler an = new m(this);
  protected int v = 0;
  protected byte[] w = new byte[2048];
  Queue<String> x = new LinkedList();
  Queue<String> y = new ConcurrentLinkedQueue();

  static
  {
    Object localObject1 = new String['Þ'];
    int i1 = 0;
    String str1 = ")l\tfk?";
    int i2 = -1;
    Object localObject2 = localObject1;
    int i15;
    label136: String str2;
    while (true)
    {
      Object localObject3 = str1.toCharArray();
      int i3 = localObject3.length;
      int i4 = 0;
      if (i3 <= 1);
      while (i3 > i4)
      {
        Object localObject7 = localObject3;
        int i12 = i4;
        int i13 = i3;
        Object localObject8 = localObject3;
        while (true)
        {
          int i14 = localObject8[i4];
          switch (i12 % 5)
          {
          default:
            i15 = 2;
            localObject8[i4] = ((char)(i15 ^ i14));
            i4 = i12 + 1;
            if (i13 != 0)
              break label136;
            localObject8 = localObject7;
            i12 = i4;
            i4 = i13;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        i3 = i13;
        localObject3 = localObject7;
      }
      str2 = new String((char[])localObject3).intern();
      switch (i2)
      {
      default:
        localObject1[i1] = str2;
        i1 = 1;
        str1 = "8gWSr.z\021\027c5m\013Vk?'8iR\020L ";
        localObject1 = localObject2;
        i2 = 0;
        break;
      case 0:
        localObject1[i1] = str2;
        i1 = 2;
        str1 = "\034l\r\031\"/j\t\031f:}\030\031d)f\024\031F\031%YMj>)\032Vw5}YPqa)";
        i2 = 1;
        localObject1 = localObject2;
        break;
      case 1:
        localObject1[i1] = str2;
        i1 = 3;
        str1 = "\034l\r\031v8yY]c/hY_p4dY}@a)";
        i2 = 2;
        localObject1 = localObject2;
        break;
      case 2:
        localObject1[i1] = str2;
        i1 = 4;
        str1 = "/j\tff:}\030";
        i2 = 3;
        localObject1 = localObject2;
        break;
      case 3:
        localObject1[i1] = str2;
        i1 = 5;
        str1 = "\036{\013Vp{}\030^c7`\030J";
        i2 = 4;
        localObject1 = localObject2;
        break;
      case 4:
        localObject1[i1] = str2;
        i1 = 6;
        str1 = "\007-%\035";
        i2 = 5;
        localObject1 = localObject2;
        break;
      case 5:
        localObject1[i1] = str2;
        i1 = 7;
        str1 = "(}\026IR.z\021\025";
        i2 = 6;
        localObject1 = localObject2;
        break;
      case 6:
        localObject1[i1] = str2;
        i1 = 8;
        str1 = "\013|\nQQ>{\017Pa>";
        i2 = 7;
        localObject1 = localObject2;
        break;
      case 7:
        localObject1[i1] = str2;
        i1 = 9;
        str1 = "\bl\027]\"\bl\rmc<z8Wf\032e\020Xq{{\034Hw>z\r\031v4)\n\\p-l\013\031/{";
        i2 = 8;
        localObject1 = localObject2;
        break;
      case 8:
        localObject1[i1] = str2;
        i1 = 10;
        str1 = ">{\013Vp(";
        i2 = 9;
        localObject1 = localObject2;
        break;
      case 9:
        localObject1[i1] = str2;
        i1 = 11;
        str1 = "/{\f\\";
        i2 = 10;
        localObject1 = localObject2;
        break;
      case 10:
        localObject1[i1] = str2;
        i1 = 12;
        str1 = "2z8Wq,l\013";
        i2 = 11;
        localObject1 = localObject2;
        break;
      case 11:
        localObject1[i1] = str2;
        i1 = 13;
        str1 = "(l\013Og))\032Vl=`\036\031q.j\032\\q(";
        i2 = 12;
        localObject1 = localObject2;
        break;
      case 12:
        localObject1[i1] = str2;
        i1 = 14;
        str1 = "\032e\030Ko{z\rXp/l\035\031u2}\021\031k5}\034Kt:eC\031'?z";
        i2 = 13;
        localObject1 = localObject2;
        break;
      case 13:
        localObject1[i1] = str2;
        i1 = 15;
        str1 = ":e\030Ko";
        i2 = 14;
        localObject1 = localObject2;
        break;
      case 14:
        localObject1[i1] = str2;
        i1 = 16;
        str1 = "(}\030KP/jYNk/aYTK5}\034Kt:eY\004\"";
        i2 = 15;
        localObject1 = localObject2;
        break;
      case 15:
        localObject1[i1] = str2;
        i1 = 17;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027A\024G7|A\017@6w";
        i2 = 16;
        localObject1 = localObject2;
        break;
      case 16:
        localObject1[i1] = str2;
        i1 = 18;
        str1 = "3h\027]n>Z\rVr\013|\nQ\":y\t\025\"(l\027]g))\034Kp4{C\031'()\\J";
        i2 = 17;
        localObject1 = localObject2;
        break;
      case 17:
        localObject1[i1] = str2;
        i1 = 19;
        str1 = "3h\027]n>Z\rVr\013|\nQ\"(|\032Zg(zC\031";
        i2 = 18;
        localObject1 = localObject2;
        break;
      case 18:
        localObject1[i1] = str2;
        i1 = 20;
        str1 = ":g\035Km2mWIg)d\020Jq2f\027\027P\036H=fR\023F7|]\b]8mG";
        i2 = 19;
        localObject1 = localObject2;
        break;
      case 19:
        localObject1[i1] = str2;
        i1 = 21;
        str1 = "\tl\036Pq/l\013\031P>j\017\031d:`\025\\f{$YKg/3";
        i2 = 20;
        localObject1 = localObject2;
        break;
      case 20:
        localObject1[i1] = str2;
        i1 = 22;
        str1 = "{d)Vp/)D\031";
        i2 = 21;
        localObject1 = localObject2;
        break;
      case 21:
        localObject1[i1] = str2;
        i1 = 23;
        str1 = "j'N\0273";
        i2 = 22;
        localObject1 = localObject2;
        break;
      case 22:
        localObject1[i1] = str2;
        i1 = 24;
        str1 = "/f\rVn\027l\027\031?{";
        i2 = 23;
        localObject1 = localObject2;
        break;
      case 23:
        localObject1[i1] = str2;
        i1 = 25;
        str1 = "\tl\036Pq/l\013\031e>}YX\">{\013Vp{j\026To:g\035\031";
        i2 = 24;
        localObject1 = localObject2;
        break;
      case 24:
        localObject1[i1] = str2;
        i1 = 26;
        str1 = "\022g\020M\",`\rQ\"v)";
        i2 = 25;
        localObject1 = localObject2;
        break;
      case 25:
        localObject1[i1] = str2;
        i1 = 27;
        str1 = "?l\013Ok>@\035\031?{";
        i2 = 26;
        localObject1 = localObject2;
        break;
      case 26:
        localObject1[i1] = str2;
        i1 = 28;
        str1 = "\021Y,jJ\004H)iI\036P";
        i2 = 27;
        localObject1 = localObject2;
        break;
      case 27:
        localObject1[i1] = str2;
        i1 = 29;
        str1 = "-";
        i2 = 28;
        localObject1 = localObject2;
        break;
      case 28:
        localObject1[i1] = str2;
        i1 = 30;
        str1 = "乖匰鄴";
        i2 = 29;
        localObject1 = localObject2;
        break;
      case 29:
        localObject1[i1] = str2;
        i1 = 31;
        str1 = ")l\036Pq/{\030Mk4g&Pf";
        i2 = 30;
        localObject1 = localObject2;
        break;
      case 30:
        localObject1[i1] = str2;
        i1 = 32;
        str1 = ")l\036Pq/l\013\031q.j\032\\g?3YLk?4";
        i2 = 31;
        localObject1 = localObject2;
        break;
      case 31:
        localObject1[i1] = str2;
        i1 = 33;
        str1 = ")l\036Pq/@=\031?{";
        i2 = 32;
        localObject1 = localObject2;
        break;
      case 32:
        localObject1[i1] = str2;
        i1 = 34;
        str1 = "\tl\036Pq/l\013\003\"";
        i2 = 33;
        localObject1 = localObject2;
        break;
      case 33:
        localObject1[i1] = str2;
        i1 = 35;
        str1 = "\021Y\fJj{|\t]c/lYZm5o\020^\"=h\020U8";
        i2 = 34;
        localObject1 = localObject2;
        break;
      case 34:
        localObject1[i1] = str2;
        i1 = 36;
        str1 = "卞各C\031";
        i2 = 35;
        localObject1 = localObject2;
        break;
      case 35:
        localObject1[i1] = str2;
        i1 = 37;
        str1 = "\013{\034_q\035`\025\\";
        i2 = 36;
        localObject1 = localObject2;
        break;
      case 36:
        localObject1[i1] = str2;
        i1 = 38;
        str1 = "{万Yxr+B\034@8";
        i2 = 37;
        localObject1 = localObject2;
        break;
      case 37:
        localObject1[i1] = str2;
        i1 = 39;
        str1 = "2g\017Xn\022l\024P\"={\026T\"(l\013Og))R\031";
        i2 = 38;
        localObject1 = localObject2;
        break;
      case 38:
        localObject1[i1] = str2;
        i1 = 40;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027P\036N0jV\tH-pM\025";
        i2 = 39;
        localObject1 = localObject2;
        break;
      case 39:
        localObject1[i1] = str2;
        i1 = 41;
        str1 = "+bYOg)z\020Vla)";
        i2 = 40;
        localObject1 = localObject2;
        break;
      case 40:
        localObject1[i1] = str2;
        i1 = 42;
        str1 = "6[\034Zt\031|\037_g))D\031";
        i2 = 41;
        localObject1 = localObject2;
        break;
      case 41:
        localObject1[i1] = str2;
        i1 = 43;
        str1 = "\tl\036Pq/l\013\031D:`\025\\f{~\020Mj{l\013Km))\032Vf>3Y";
        i2 = 42;
        localObject1 = localObject2;
        break;
      case 42:
        localObject1[i1] = str2;
        i1 = 44;
        str1 = "+a\026Wg";
        i2 = 43;
        localObject1 = localObject2;
        break;
      case 43:
        localObject1[i1] = str2;
        i1 = 45;
        str1 = ">{\013Vp{m\034Ja)`\tMk4gC3";
        i2 = 44;
        localObject1 = localObject2;
        break;
      case 44:
        localObject1[i1] = str2;
        i1 = 46;
        str1 = "6@\027Mg)\030U";
        i2 = 45;
        localObject1 = localObject2;
        break;
      case 45:
        localObject1[i1] = str2;
        i1 = 47;
        str1 = "/h\036JC5m8Uk:z]\035";
        i2 = 46;
        localObject1 = localObject2;
        break;
      case 46:
        localObject1[i1] = str2;
        i1 = 48;
        str1 = "\026l\013^g?)\rXe\032g\035xn2h\n\031";
        i2 = 47;
        localObject1 = localObject2;
        break;
      case 47:
        localObject1[i1] = str2;
        i1 = 49;
        str1 = "uy\034Ko2z\nPm5'3iW\bA&tG\bZ8~G";
        i2 = 48;
        localObject1 = localObject2;
        break;
      case 48:
        localObject1[i1] = str2;
        i1 = 50;
        str1 = "6z\036fk?";
        i2 = 49;
        localObject1 = localObject2;
        break;
      case 49:
        localObject1[i1] = str2;
        i1 = 51;
        str1 = "\017`\024\\\"/fYIp4j\034Jq{{\034Zg2\034]\"6z\036\027";
        i2 = 50;
        localObject1 = localObject2;
        break;
      case 50:
        localObject1[i1] = str2;
        i1 = 52;
        str1 = "4g)Xp(l8Wf\tl\032OO(n4\\q(h\036\\\"{d\n^K?)D\031";
        i2 = 51;
        localObject1 = localObject2;
        break;
      case 51:
        localObject1[i1] = str2;
        i1 = 53;
        str1 = "\017a\034\031r:j\022Xe>)\025\\l<a\r\031k()C\031";
        i2 = 52;
        localObject1 = localObject2;
        break;
      case 52:
        localObject1[i1] = str2;
        i1 = 54;
        str1 = "lo\034_4:>\035\01648>A\013`joI\\f:=M\017`ijOZ6kh";
        i2 = 53;
        localObject1 = localObject2;
        break;
      case 53:
        localObject1[i1] = str2;
        i1 = 55;
        str1 = "(l\027]g)@\035";
        i2 = 54;
        localObject1 = localObject2;
        break;
      case 54:
        localObject1[i1] = str2;
        i1 = 56;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027P\036Z-vP\036Y,jJ";
        i2 = 55;
        localObject1 = localObject2;
        break;
      case 55:
        localObject1[i1] = str2;
        i1 = 57;
        str1 = "\tl\035Lr7`\032Xv>)\024Je{$Y";
        i2 = 56;
        localObject1 = localObject2;
        break;
      case 56:
        localObject1[i1] = str2;
        i1 = 58;
        str1 = "\035h\020Ug?)\rV\")l\tVp/)\013\\a>`\017\\f{$Y";
        i2 = 57;
        localObject1 = localObject2;
        break;
      case 57:
        localObject1[i1] = str2;
        i1 = 59;
        str1 = "";
        i2 = 58;
        localObject1 = localObject2;
        break;
      case 58:
        localObject1[i1] = str2;
        i1 = 60;
        str1 = ":j\rPm53\026WP>j\017zm6d\030Wfa)";
        i2 = 59;
        localObject1 = localObject2;
        break;
      case 59:
        localObject1[i1] = str2;
        i1 = 61;
        str1 = "\022g\017Xn2mYCk+O\025Xe{`\n\0318{";
        i2 = 60;
        localObject1 = localObject2;
        break;
      case 60:
        localObject1[i1] = str2;
        i1 = 62;
        str1 = "\016g\034Ar>j\r\\fa)\fWi5f\016W\"6z\036\031v\"y\034\031/";
        i2 = 61;
        localObject1 = localObject2;
        break;
      case 61:
        localObject1[i1] = str2;
        i1 = 63;
        str1 = "\b|\032Zg>mYMm{{\034Im)}YKg8l\020Og?)T\031";
        i2 = 62;
        localObject1 = localObject2;
        break;
      case 62:
        localObject1[i1] = str2;
        i1 = 64;
        str1 = "8gWSr.z\021\027c5m\013Vk?'7vV\022O0zC\017@6w]\017P)|";
        i2 = 63;
        localObject1 = localObject2;
        break;
      case 63:
        localObject1[i1] = str2;
        i1 = 65;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027Q\017F)iW\bA";
        i2 = 64;
        localObject1 = localObject2;
        break;
      case 64:
        localObject1[i1] = str2;
        i1 = 66;
        str1 = "w)\024Je\030f\027Mg5}C";
        i2 = 65;
        localObject1 = localObject2;
        break;
      case 65:
        localObject1[i1] = str2;
        i1 = 67;
        str1 = "!`\tn:nYPq{3Y";
        i2 = 66;
        localObject1 = localObject2;
        break;
      case 66:
        localObject1[i1] = str2;
        i1 = 68;
        str1 = ":j\rPm53\013\\a>`\017\\f\013|\nQO>z\nXe>)\024Je\022mY\004\"";
        i2 = 67;
        localObject1 = localObject2;
        break;
      case 67:
        localObject1[i1] = str2;
        i1 = 69;
        str1 = "w)\n\\l?l\013pfa";
        i2 = 68;
        localObject1 = localObject2;
        break;
      case 68:
        localObject1[i1] = str2;
        i1 = 70;
        str1 = "6l\nJc<l";
        i2 = 69;
        localObject1 = localObject2;
        break;
      case 69:
        localObject1[i1] = str2;
        i1 = 71;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027L\024]0K\030H-pM\025V+|A\036@/|F\004Y+vZ\002";
        i2 = 70;
        localObject1 = localObject2;
        break;
      case 70:
        localObject1[i1] = str2;
        i1 = 72;
        str1 = "\016g\022Wm,gYZo?)T\031";
        i2 = 71;
        localObject1 = localObject2;
        break;
      case 71:
        localObject1[i1] = str2;
        i1 = 73;
        str1 = "w)\024Je\022mY\004\"";
        i2 = 72;
        localObject1 = localObject2;
        break;
      case 72:
        localObject1[i1] = str2;
        i1 = 74;
        str1 = "6z\036m{+lY\004\"";
        i2 = 73;
        localObject1 = localObject2;
        break;
      case 73:
        localObject1[i1] = str2;
        i1 = 75;
        str1 = "\026l\nJc<lYk>e\035J\"v)\030Ir\022mC";
        i2 = 74;
        localObject1 = localObject2;
        break;
      case 74:
        localObject1[i1] = str2;
        i1 = 76;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027W\025[<~K\b]+xV\022F7";
        i2 = 75;
        localObject1 = localObject2;
        break;
      case 75:
        localObject1[i1] = str2;
        i1 = 77;
        str1 = ":y\tpf";
        i2 = 76;
        localObject1 = localObject2;
        break;
      case 76:
        localObject1[i1] = str2;
        i1 = 78;
        str1 = "4g=\\q/{\026@\"v)\tKm8l\nJK?3";
        i2 = 77;
        localObject1 = localObject2;
        break;
      case 77:
        localObject1[i1] = str2;
        i1 = 79;
        str1 = "7f\036Pl\004{\034Im)}&Mk6l";
        i2 = 78;
        localObject1 = localObject2;
        break;
      case 78:
        localObject1[i1] = str2;
        i1 = 80;
        str1 = "(l\013Og)]\020Tg{4Y";
        i2 = 79;
        localObject1 = localObject2;
        break;
      case 79:
        localObject1[i1] = str2;
        i1 = 81;
        str1 = "4g+\\a\032j\022\003\"(l\bpf{4Y";
        i2 = 80;
        localObject1 = localObject2;
        break;
      case 80:
        localObject1[i1] = str2;
        i1 = 82;
        str1 = "{)Y\031p>y\026Kv\017`\024\\\"f)";
        i2 = 81;
        localObject1 = localObject2;
        break;
      case 81:
        localObject1[i1] = str2;
        i1 = 83;
        str1 = "7f\036Pl\004z\034Kt>{&Mk6l";
        i2 = 82;
        localObject1 = localObject2;
        break;
      case 82:
        localObject1[i1] = str2;
        i1 = 84;
        str1 = "\016O";
        i2 = 83;
        localObject1 = localObject2;
        break;
      case 83:
        localObject1[i1] = str2;
        i1 = 85;
        str1 = "2y\n";
        i2 = 84;
        localObject1 = localObject2;
        break;
      case 84:
        localObject1[i1] = str2;
        i1 = 86;
        str1 = "\016z\034\031\"+f\013M8{";
        i2 = 85;
        localObject1 = localObject2;
        break;
      case 85:
        localObject1[i1] = str2;
        i1 = 87;
        str1 = "\037G*\031k5o\026\031k(3Y";
        i2 = 86;
        localObject1 = localObject2;
        break;
      case 86:
        localObject1[i1] = str2;
        i1 = 88;
        str1 = "\bl\r\031f>o\030Ln/@)\031?{";
        i2 = 87;
        localObject1 = localObject2;
        break;
      case 87:
        localObject1[i1] = str2;
        i1 = 89;
        str1 = "6Y\026Kv";
        i2 = 88;
        localObject1 = localObject2;
        break;
      case 88:
        localObject1[i1] = str2;
        i1 = 90;
        str1 = "3}\rI])l\tVp/V\nPq\004|\013U";
        i2 = 89;
        localObject1 = localObject2;
        break;
      case 89:
        localObject1[i1] = str2;
        i1 = 91;
        str1 = "\007-";
        i2 = 90;
        localObject1 = localObject2;
        break;
      case 90:
        localObject1[i1] = str2;
        i1 = 92;
        str1 = "6J\fKp>g\rjk(Y\026J";
        i2 = 91;
        localObject1 = localObject2;
        break;
      case 91:
        localObject1[i1] = str2;
        i1 = 93;
        str1 = "\016z\034\031Q\022ZYIm)}C\031";
        i2 = 92;
        localObject1 = localObject2;
        break;
      case 92:
        localObject1[i1] = str2;
        i1 = 94;
        str1 = "\b@*\031P>j\034Pt>mYjv)`\027^8{";
        i2 = 93;
        localObject1 = localObject2;
        break;
      case 93:
        localObject1[i1] = str2;
        i1 = 95;
        str1 = "\bl\r\031o\037l\037Xw7})Vp/)D\031";
        i2 = 94;
        localObject1 = localObject2;
        break;
      case 94:
        localObject1[i1] = str2;
        i1 = 96;
        str1 = "\b@*\031Q.j\032\\q(";
        i2 = 95;
        localObject1 = localObject2;
        break;
      case 95:
        localObject1[i1] = str2;
        i1 = 97;
        str1 = "6@)";
        i2 = 96;
        localObject1 = localObject2;
        break;
      case 96:
        localObject1[i1] = str2;
        i1 = 98;
        str1 = "\034l\r\031q>{\017\\p{`\t\031g){\026K\",`\rQ8{";
        i2 = 97;
        localObject1 = localObject2;
        break;
      case 97:
        localObject1[i1] = str2;
        i1 = 99;
        str1 = ")l\032\\k-l\035\035&";
        i2 = 98;
        localObject1 = localObject2;
        break;
      case 98:
        localObject1[i1] = str2;
        i1 = 100;
        str1 = "+e\030Md4{\024";
        i2 = 99;
        localObject1 = localObject2;
        break;
      case 99:
        localObject1[i1] = str2;
        i1 = 101;
        str1 = "\016g\022Wm,g";
        i2 = 100;
        localObject1 = localObject2;
        break;
      case 100:
        localObject1[i1] = str2;
        i1 = 102;
        str1 = "\017a\034\031t>{\nPm5G\030Tg{`\n\031l4}YOc7`\035\025\"\013e\034Xq>)\032Qg8bY@m.{Yxl?{\026Pf\026h\027Pd>z\r\027z6e";
        i2 = 101;
        localObject1 = localObject2;
        break;
      case 101:
        localObject1[i1] = str2;
        i1 = 103;
        str1 = "+h\032Rc<lYWc6lC\031";
        i2 = 102;
        localObject1 = localObject2;
        break;
      case 102:
        localObject1[i1] = str2;
        i1 = 104;
        str1 = ".`\035\004'?";
        i2 = 103;
        localObject1 = localObject2;
        break;
      case 103:
        localObject1[i1] = str2;
        i1 = 105;
        str1 = "(l\027]g))0}8{";
        i2 = 104;
        localObject1 = localObject2;
        break;
      case 104:
        localObject1[i1] = str2;
        i1 = 106;
        str1 = ")l\nIA4m\034\004'?";
        i2 = 105;
        localObject1 = localObject2;
        break;
      case 105:
        localObject1[i1] = str2;
        i1 = 107;
        str1 = ")l\036Pq/{\030Mk4gYpFa)";
        i2 = 106;
        localObject1 = localObject2;
        break;
      case 106:
        localObject1[i1] = str2;
        i1 = 108;
        str1 = "~9Ka";
        i2 = 107;
        localObject1 = localObject2;
        break;
      case 107:
        localObject1[i1] = str2;
        i1 = 109;
        str1 = ")l\036Pq/{\030Mk4gY_c2e\034]8{,\035";
        i2 = 108;
        localObject1 = localObject2;
        break;
      case 108:
        localObject1[i1] = str2;
        i1 = 110;
        str1 = "\035h\020Ug?)\rV\"\036g\030[n>J\021Xl5l\025\031/{{\034M8{";
        i2 = 109;
        localObject1 = localObject2;
        break;
      case 109:
        localObject1[i1] = str2;
        i1 = 111;
        str1 = "6O\020Kq/E\026^e>m0W";
        i2 = 110;
        localObject1 = localObject2;
        break;
      case 110:
        localObject1[i1] = str2;
        i1 = 112;
        str1 = "\022g\017Xn2mY}g\030a\030Wl>eYZm6d\030Wfa)";
        i2 = 111;
        localObject1 = localObject2;
        break;
      case 111:
        localObject1[i1] = str2;
        i1 = 113;
        str1 = ")l\tVp/";
        i2 = 112;
        localObject1 = localObject2;
        break;
      case 112:
        localObject1[i1] = str2;
        i1 = 114;
        str1 = "2z+\\q/h\013MP/j";
        i2 = 113;
        localObject1 = localObject2;
        break;
      case 113:
        localObject1[i1] = str2;
        i1 = 115;
        str1 = "=h\025Jg";
        i2 = 114;
        localObject1 = localObject2;
        break;
      case 114:
        localObject1[i1] = str2;
        i1 = 116;
        str1 = ">g\030[n>J\021Xl5l\025";
        i2 = 115;
        localObject1 = localObject2;
        break;
      case 115:
        localObject1[i1] = str2;
        i1 = 117;
        str1 = "/h\036JC5m8Uk:z";
        i2 = 116;
        localObject1 = localObject2;
        break;
      case 116:
        localObject1[i1] = str2;
        i1 = 118;
        str1 = "\b|\032Zg>mYMm{z\rVr\013|\nQ\"v)";
        i2 = 117;
        localObject1 = localObject2;
        break;
      case 117:
        localObject1[i1] = str2;
        i1 = 119;
        str1 = "\b|\032Zg>mYMm{L\027X`7l:Qc5g\034U\"v)";
        i2 = 118;
        localObject1 = localObject2;
        break;
      case 118:
        localObject1[i1] = str2;
        i1 = 120;
        str1 = "(}\026IR.z\021";
        i2 = 119;
        localObject1 = localObject2;
        break;
      case 119:
        localObject1[i1] = str2;
        i1 = 121;
        str1 = "\035h\020Ug?)\rV\"(}\026IR.z\021\031/{{\034M8{";
        i2 = 120;
        localObject1 = localObject2;
        break;
      case 120:
        localObject1[i1] = str2;
        i1 = 122;
        str1 = "\022g\017Xn2mYJg/]\030^q\032g\035xk:zYZm6d\030Wfa)";
        i2 = 121;
        localObject1 = localObject2;
        break;
      case 121:
        localObject1[i1] = str2;
        i1 = 123;
        str1 = ":y\tPf";
        i2 = 122;
        localObject1 = localObject2;
        break;
      case 122:
        localObject1[i1] = str2;
        i1 = 124;
        str1 = "+|\nQV2d\034";
        i2 = 123;
        localObject1 = localObject2;
        break;
      case 123:
        localObject1[i1] = str2;
        i1 = 125;
        str1 = ")l\032\\k-l\035";
        i2 = 124;
        localObject1 = localObject2;
        break;
      case 124:
        localObject1[i1] = str2;
        i1 = 126;
        str1 = "{3Y";
        i2 = 125;
        localObject1 = localObject2;
        break;
      case 125:
        localObject1[i1] = str2;
        i1 = 127;
        str1 = "\022g\017Xn2mYKg+f\013M\")l\032\\k-l\035\031a4d\024Xl?3Y";
        i2 = 126;
        localObject1 = localObject2;
        break;
      case 126:
        localObject1[i1] = str2;
        i1 = 128;
        str1 = "\035h\020Ug?)\rV\"(l\r\031r.z\021mk6lY\024\")l\r\003\"";
        i2 = 127;
        localObject1 = localObject2;
        break;
      case 127:
        localObject1[i1] = str2;
        i1 = 129;
        str1 = "\b|\032Zg>mYMm{z\034M\"+|\nQV2d\034\031/{";
        i2 = 128;
        localObject1 = localObject2;
        break;
      case 128:
        localObject1[i1] = str2;
        i1 = 130;
        str1 = "v$T";
        i2 = 129;
        localObject1 = localObject2;
        break;
      case 129:
        localObject1[i1] = str2;
        i1 = 131;
        str1 = "\023h\027]n2g\036\031p>x\f\\q/3Y";
        i2 = 130;
        localObject1 = localObject2;
        break;
      case 130:
        localObject1[i1] = str2;
        i1 = 132;
        str1 = "\022g\017Xn2mYJg/)\tLq3]\020Tg{j\026To:g\035\003\"";
        i2 = 131;
        localObject1 = localObject2;
        break;
      case 131:
        localObject1[i1] = str2;
        i1 = 133;
        str1 = "\022g\017Xn2mY|l:k\025\\A3h\027Wg7)\032Vo6h\027]8{";
        i2 = 132;
        localObject1 = localObject2;
        break;
      case 132:
        localObject1[i1] = str2;
        i1 = 134;
        str1 = "\035h\020Ug?)\rV\"(l\r\031v:n\nxl?H\025Pc()T\031p>}C\031";
        i2 = 133;
        localObject1 = localObject2;
        break;
      case 133:
        localObject1[i1] = str2;
        i1 = 135;
        str1 = "\b|\032Zg>mYMm{{\034Im)}YPl=fY\024\"";
        i2 = 134;
        localObject1 = localObject2;
        break;
      case 134:
        localObject1[i1] = str2;
        i1 = 136;
        str1 = "\035h\020Ug?)\rV\")l\tVp/)\020Wd4)T\031p>}C";
        i2 = 135;
        localObject1 = localObject2;
        break;
      case 135:
        localObject1[i1] = str2;
        i1 = 137;
        str1 = "(l\027]g)`\035";
        i2 = 136;
        localObject1 = localObject2;
        break;
      case 136:
        localObject1[i1] = str2;
        i1 = 138;
        str1 = ")}\032\031k5)";
        i2 = 137;
        localObject1 = localObject2;
        break;
      case 137:
        localObject1[i1] = str2;
        i1 = 139;
        str1 = "{e\030Mg)";
        i2 = 138;
        localObject1 = localObject2;
        break;
      case 138:
        localObject1[i1] = str2;
        i1 = 140;
        str1 = "\bl\r\031o\b}\030Kv\024g,Jg)Y\013\\q>g\r\031v4)";
        i2 = 139;
        localObject1 = localObject2;
        break;
      case 139:
        localObject1[i1] = str2;
        i1 = 141;
        str1 = ">q\020M";
        i2 = 140;
        localObject1 = localObject2;
        break;
      case 140:
        localObject1[i1] = str2;
        i1 = 142;
        str1 = "\bl\r\031Q\017H+m]\bL+oK\030L&vL\004F)|L{}\026\031";
        i2 = 141;
        localObject1 = localObject2;
        break;
      case 141:
        localObject1[i1] = str2;
        i1 = 143;
        str1 = ".z\t";
        i2 = 142;
        localObject1 = localObject2;
        break;
      case 142:
        localObject1[i1] = str2;
        i1 = 144;
        str1 = "(g\032";
        i2 = 143;
        localObject1 = localObject2;
        break;
      case 143:
        localObject1[i1] = str2;
        i1 = 145;
        str1 = ")}\032";
        i2 = 144;
        localObject1 = localObject2;
        break;
      case 144:
        localObject1[i1] = str2;
        i1 = 146;
        str1 = "6Z\rXp/F\027lq>{)Kg(l\027M";
        i2 = 145;
        localObject1 = localObject2;
        break;
      case 145:
        localObject1[i1] = str2;
        i1 = 147;
        str1 = "(z\026V";
        i2 = 146;
        localObject1 = localObject2;
        break;
      case 146:
        localObject1[i1] = str2;
        i1 = 148;
        str1 = "\bl\r\031o\b}\030Kv\024g7\\v,f\013RA4g\027\\a/l\035\031v4)";
        i2 = 147;
        localObject1 = localObject2;
        break;
      case 147:
        localObject1[i1] = str2;
        i1 = 149;
        str1 = "\016y\035Xv>)\013Ma{`\027Mg)\030U\"/fY";
        i2 = 148;
        localObject1 = localObject2;
        break;
      case 148:
        localObject1[i1] = str2;
        i1 = 150;
        str1 = ")l\tVp/%";
        i2 = 149;
        localObject1 = localObject2;
        break;
      case 149:
        localObject1[i1] = str2;
        i1 = 151;
        str1 = "\017a\034\031q>{\017Pa>)\016Pn7)\022Pn7)\020Mq>e\037\031k5)";
        i2 = 150;
        localObject1 = localObject2;
        break;
      case 150:
        localObject1[i1] = str2;
        i1 = 152;
        str1 = "断闽｣\031";
        i2 = 151;
        localObject1 = localObject2;
        break;
      case 151:
        localObject1[i1] = str2;
        i1 = 153;
        str1 = "?l\017fk5o\026fp>y&Mk6l";
        i2 = 152;
        localObject1 = localObject2;
        break;
      case 152:
        localObject1[i1] = str2;
        i1 = 154;
        str1 = "6]\021Kg:mYPq{g\026M\"2z8Uk-lU\031p>z\rXp/)\rQg{}\021Kg:mU\031k?)D\031";
        i2 = 153;
        localObject1 = localObject2;
        break;
      case 153:
        localObject1[i1] = str2;
        i1 = 155;
        str1 = "";
        i2 = 154;
        localObject1 = localObject2;
        break;
      case 154:
        localObject1[i1] = str2;
        i1 = 156;
        str1 = "7j\rPo>";
        i2 = 155;
        localObject1 = localObject2;
        break;
      case 155:
        localObject1[i1] = str2;
        i1 = 157;
        str1 = "v$T\024/v";
        i2 = 156;
        localObject1 = localObject2;
        break;
      case 156:
        localObject1[i1] = str2;
        i1 = 158;
        str1 = "V\003";
        i2 = 157;
        localObject1 = localObject2;
        break;
      case 157:
        localObject1[i1] = str2;
        i1 = 159;
        str1 = "6]\021Kg:mYPq{g\fUnw)\013\\q/h\013M\"/a\034\031v3{\034Xfw)\020]\"f)";
        i2 = 158;
        localObject1 = localObject2;
        break;
      case 158:
        localObject1[i1] = str2;
        i1 = 160;
        str1 = "6]\021Kg:mYPq{h\025Pt>)\020]\"f)";
        i2 = 159;
        localObject1 = localObject2;
        break;
      case 159:
        localObject1[i1] = str2;
        i1 = 161;
        str1 = "2z>\\v\034f\026^n>H\035]p>z\n\003\"";
        i2 = 160;
        localObject1 = localObject2;
        break;
      case 160:
        localObject1[i1] = str2;
        i1 = 162;
        str1 = "2z>\\v\034f\026^n>H\035]p>z\n";
        i2 = 161;
        localObject1 = localObject2;
        break;
      case 161:
        localObject1[i1] = str2;
        i1 = 163;
        str1 = "8f\025m{+l";
        i2 = 162;
        localObject1 = localObject2;
        break;
      case 162:
        localObject1[i1] = str2;
        i1 = 164;
        str1 = "2z5Va:}\020Vl\036g\030[n>m";
        i2 = 163;
        localObject1 = localObject2;
        break;
      case 163:
        localObject1[i1] = str2;
        i1 = 165;
        str1 = ",`\037P]/f\016\\p(";
        i2 = 164;
        localObject1 = localObject2;
        break;
      case 164:
        localObject1[i1] = str2;
        i1 = 166;
        str1 = "8l\025U]/f\016\\p(";
        i2 = 165;
        localObject1 = localObject2;
        break;
      case 165:
        localObject1[i1] = str2;
        i1 = 167;
        str1 = ":f\016";
        i2 = 166;
        localObject1 = localObject2;
        break;
      case 166:
        localObject1[i1] = str2;
        i1 = 168;
        str1 = ":e\025";
        i2 = 167;
        localObject1 = localObject2;
        break;
      case 167:
        localObject1[i1] = str2;
        i1 = 169;
        str1 = "<y\n";
        i2 = 168;
        localObject1 = localObject2;
        break;
      case 168:
        localObject1[i1] = str2;
        i1 = 170;
        str1 = "7f\032m{+l";
        i2 = 169;
        localObject1 = localObject2;
        break;
      case 169:
        localObject1[i1] = str2;
        i1 = 171;
        str1 = "/h\036Xn2h\n\031?{";
        i2 = 170;
        localObject1 = localObject2;
        break;
      case 170:
        localObject1[i1] = str2;
        i1 = 172;
        str1 = ":e\020Xq";
        i2 = 171;
        localObject1 = localObject2;
        break;
      case 171:
        localObject1[i1] = str2;
        i1 = 173;
        str1 = "/h\036J";
        i2 = 172;
        localObject1 = localObject2;
        break;
      case 172:
        localObject1[i1] = str2;
        i1 = 174;
        str1 = ":y\t\031r:j\022Xe>)\027Xo>)\025\\l<}\021\031?{)";
        i2 = 173;
        localObject1 = localObject2;
        break;
      case 173:
        localObject1[i1] = str2;
        i1 = 175;
        str1 = "8gWSr.z\021\027c5m\013Vk?'+|E\022Z-kC\017@6w]\022M";
        i2 = 174;
        localObject1 = localObject2;
        break;
      case 174:
        localObject1[i1] = str2;
        i1 = 176;
        str1 = "(l\013Ok8l&Kg<`\nMg)";
        i2 = 175;
        localObject1 = localObject2;
        break;
      case 175:
        localObject1[i1] = str2;
        i1 = 177;
        str1 = "~zWIg)d\020Jq2f\027\027H\013\\*q]\026L*jC\034L";
        i2 = 176;
        localObject1 = localObject2;
        break;
      case 176:
        localObject1[i1] = str2;
        i1 = 178;
        str1 = "8gWSr.z\021\027c5m\013Vk?':vL\025L:mK\024G&zJ\032G>|";
        i2 = 177;
        localObject1 = localObject2;
        break;
      case 177:
        localObject1[i1] = str2;
        i1 = 179;
        str1 = "(l\013Ok8l&Zm5g\034Zg/";
        i2 = 178;
        localObject1 = localObject2;
        break;
      case 178:
        localObject1[i1] = str2;
        i1 = 180;
        str1 = "w)\013\\va";
        i2 = 179;
        localObject1 = localObject2;
        break;
      case 179:
        localObject1[i1] = str2;
        i1 = 181;
        str1 = "\035h\020Ug?)\rV\")l\tVp/)\t\\p6`\nJk4gYPl=fY\024\"+h\036\\8{";
        i2 = 180;
        localObject1 = localObject2;
        break;
      case 180:
        localObject1[i1] = str2;
        i1 = 182;
        str1 = " +\rVv:e[\003'?%[Ic<l[\003'?%[Jg5m\034Kk?+C\033'(+U\033w2m[\003'(%[Ig)d\020Jq2f\027fn2z\r\0338~z\004";
        i2 = 181;
        localObject1 = localObject2;
        break;
      case 181:
        localObject1[i1] = str2;
        i1 = 183;
        str1 = "w+";
        i2 = 182;
        localObject1 = localObject2;
        break;
      case 182:
        localObject1[i1] = str2;
        i1 = 184;
        str1 = "\036g\030[n>J\021Xl5l\025kg*|\034Jv{h\tI.{z\034Wf>{Y\\p)f\013\003\"~zY\034q";
        i2 = 183;
        localObject1 = localObject2;
        break;
      case 183:
        localObject1[i1] = str2;
        i1 = 185;
        str1 = "\036g\030[n>):Qc5g\034U\"(|\032Zg(zC\031";
        i2 = 184;
        localObject1 = localObject2;
        break;
      case 184:
        localObject1[i1] = str2;
        i1 = 186;
        str1 = "\032e\013\\c?pYum<n\034]\"\022g";
        i2 = 185;
        localObject1 = localObject2;
        break;
      case 185:
        localObject1[i1] = str2;
        i1 = 187;
        str1 = "7f\032m{+l\n\031k(3Y";
        i2 = 186;
        localObject1 = localObject2;
        break;
      case 186:
        localObject1[i1] = str2;
        i1 = 188;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027R\016Z1fV\022D<";
        i2 = 187;
        localObject1 = localObject2;
        break;
      case 187:
        localObject1[i1] = str2;
        i1 = 189;
        str1 = "(l\bfk?";
        i2 = 188;
        localObject1 = localObject2;
        break;
      case 188:
        localObject1[i1] = str2;
        i1 = 190;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027P\036N0jV\036[";
        i2 = 189;
        localObject1 = localObject2;
        break;
      case 189:
        localObject1[i1] = str2;
        i1 = 191;
        str1 = "\007$";
        i2 = 190;
        localObject1 = localObject2;
        break;
      case 190:
        localObject1[i1] = str2;
        i1 = 192;
        str1 = "\bl\013Ok8lY[w5m\025\\\"v)";
        i2 = 191;
        localObject1 = localObject2;
        break;
      case 191:
        localObject1[i1] = str2;
        i1 = 193;
        str1 = "=f\013Nc)mYXa/`\026W8{";
        i2 = 192;
        localObject1 = localObject2;
        break;
      case 192:
        localObject1[i1] = str2;
        i1 = 194;
        str1 = ")l\nMc)}&Kv8";
        i2 = 193;
        localObject1 = localObject2;
        break;
      case 193:
        localObject1[i1] = str2;
        i1 = 195;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027P\036Y6kV";
        i2 = 194;
        localObject1 = localObject2;
        break;
      case 194:
        localObject1[i1] = str2;
        i1 = 196;
        str1 = "(}\026I]/a\013\\c?";
        i2 = 195;
        localObject1 = localObject2;
        break;
      case 195:
        localObject1[i1] = str2;
        i1 = 197;
        str1 = ":y\t";
        i2 = 196;
        localObject1 = localObject2;
        break;
      case 196:
        localObject1[i1] = str2;
        i1 = 198;
        str1 = "3h\027]n>Z\034MR.z\021mk6lYJw8j\034Jq{$Y";
        i2 = 197;
        localObject1 = localObject2;
        break;
      case 197:
        localObject1[i1] = str2;
        i1 = 199;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027C\027@8j]\017H>j";
        i2 = 198;
        localObject1 = localObject2;
        break;
      case 198:
        localObject1[i1] = str2;
        i1 = 200;
        str1 = "\032e\013\\c?pYjg/Y\fJj\017`\024\\.{n\020Og{|\t\031/{";
        i2 = 199;
        localObject1 = localObject2;
        break;
      case 199:
        localObject1[i1] = str2;
        i1 = 201;
        str1 = "+|\nQv2d\034";
        i2 = 200;
        localObject1 = localObject2;
        break;
      case 200:
        localObject1[i1] = str2;
        i1 = 202;
        str1 = "+|\nQV2d\034\035&";
        i2 = 201;
        localObject1 = localObject2;
        break;
      case 201:
        localObject1[i1] = str2;
        i1 = 203;
        str1 = ".z\034K]<{\026Ll?";
        i2 = 202;
        localObject1 = localObject2;
        break;
      case 202:
        localObject1[i1] = str2;
        i1 = 204;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027K\025@-";
        i2 = 203;
        localObject1 = localObject2;
        break;
      case 203:
        localObject1[i1] = str2;
        i1 = 205;
        str1 = "8e\026Jg+|\nQ";
        i2 = 204;
        localObject1 = localObject2;
        break;
      case 204:
        localObject1[i1] = str2;
        i1 = 206;
        str1 = ":j\rPm53\021Xl?e\034pl=f+\\r4{\r\031/{";
        i2 = 205;
        localObject1 = localObject2;
        break;
      case 205:
        localObject1[i1] = str2;
        i1 = 207;
        str1 = "\007V";
        i2 = 206;
        localObject1 = localObject2;
        break;
      case 206:
        localObject1[i1] = str2;
        i1 = 208;
        str1 = "8gWSr.z\021\027c5m\013Vk?'\020Wv>g\r\027W\bL+fE\tF,wF";
        i2 = 207;
        localObject1 = localObject2;
        break;
      case 207:
        localObject1[i1] = str2;
        i1 = 209;
        str1 = "w)";
        i2 = 208;
        localObject1 = localObject2;
        break;
      case 208:
        localObject1[i1] = str2;
        i1 = 210;
        str1 = "6J\026Wl>j\rPm5)D\031";
        i2 = 209;
        localObject1 = localObject2;
        break;
      case 209:
        localObject1[i1] = str2;
        i1 = 211;
        str1 = "4g*Mc)}:Vo6h\027]\"v)\nMc)}0]8";
        i2 = 210;
        localObject1 = localObject2;
        break;
      case 210:
        localObject1[i1] = str2;
        i1 = 212;
        str1 = ")}\032ff>e\030@";
        i2 = 211;
        localObject1 = localObject2;
        break;
      case 211:
        localObject1[i1] = str2;
        i1 = 213;
        str1 = ">g\030[n>J\021Xl5l\025\025";
        i2 = 212;
        localObject1 = localObject2;
        break;
      case 212:
        localObject1[i1] = str2;
        i1 = 214;
        str1 = "8f\035\\";
        i2 = 213;
        localObject1 = localObject2;
        break;
      case 213:
        localObject1[i1] = str2;
        i1 = 215;
        str1 = "5|\025U\"8h\025U`:j\022\031\"v)";
        i2 = 214;
        localObject1 = localObject2;
        break;
      case 214:
        localObject1[i1] = str2;
        i1 = 216;
        str1 = "\b|\032Zg>mYNk/aYJg*@\035\031\"v)";
        i2 = 215;
        localObject1 = localObject2;
        break;
      case 215:
        localObject1[i1] = str2;
        i1 = 217;
        str1 = "(l\bLg5j\034";
        i2 = 216;
        localObject1 = localObject2;
        break;
      case 216:
        localObject1[i1] = str2;
        i1 = 218;
        str1 = "4g=Pq8f\027Wg8}\034]";
        i2 = 217;
        localObject1 = localObject2;
        break;
      case 217:
        localObject1[i1] = str2;
        i1 = 219;
        str1 = "4g=Pq8f\027Wg8}\034]\":g\035\031p>}\013@\"\026Z>fI\036L)fC\027@/|]\025F4xN{";
        i2 = 218;
        localObject1 = localObject2;
        break;
      case 218:
        localObject1[i1] = str2;
        i1 = 220;
        str1 = "<f\026Wa3l\032R,8f\024\035";
        i2 = 219;
        localObject1 = localObject2;
        break;
      case 219:
        localObject1[i1] = str2;
        i1 = 221;
        str1 = ">h\n@v4d\034Jq:n\034\027a4d]";
        i2 = 220;
        localObject1 = localObject2;
      case 220:
      }
    }
    localObject1[i1] = str2;
    bb = localObject2;
    b = false;
    c = false;
    d = 2;
    e = 7200000L;
    f = 86400000L;
    g = 300000L;
    h = 3600000L;
    i = 300;
    j = 0L;
    k = 0L;
    l = 0L;
    m = 0L;
    n = 0L;
    E = 86400L;
    F = 360L;
    G = false;
    H = true;
    String str3 = "j8H\0273h'M\016,n=";
    int i5 = -1;
    label5941: label6080: String str4;
    while (true)
    {
      Object localObject4 = str3.toCharArray();
      int i6 = localObject4.length;
      int i7 = 0;
      if (i6 <= 1);
      while (i6 > i7)
      {
        Object localObject5 = localObject4;
        int i8 = i7;
        int i9 = i6;
        Object localObject6 = localObject4;
        int i10 = localObject6[i7];
        int i11;
        switch (i8 % 5)
        {
        default:
          i11 = 2;
        case 0:
        case 1:
        case 2:
        case 3:
        }
        while (true)
        {
          localObject6[i7] = ((char)(i11 ^ i10));
          i7 = i8 + 1;
          if (i9 != 0)
            break label6080;
          localObject6 = localObject5;
          i8 = i7;
          i7 = i9;
          break label5941;
          i15 = 91;
          break;
          i15 = 9;
          break;
          i15 = 121;
          break;
          i15 = 57;
          break;
          i11 = 91;
          continue;
          i11 = 9;
          continue;
          i11 = 121;
          continue;
          i11 = 57;
        }
        i6 = i9;
        localObject4 = localObject5;
      }
      str4 = new String((char[])localObject4).intern();
      switch (i5)
      {
      default:
        o = str4;
        p = 3000;
        str3 = "j8N\0273h<W\b4k'M\016";
        i5 = 0;
        break;
      case 0:
        I = str4;
        str3 = "2dO\r,1y\fJjuj\027";
        i5 = 1;
        break;
      case 1:
        J = str4;
        K = 3000;
        str3 = "('\023Iw(aWZl";
        i5 = 2;
        break;
      case 2:
        L = str4;
        str3 = "j8H\0273h'M\001,j9M";
        i5 = 3;
        break;
      case 3:
        M = str4;
        N = 9000;
        O = 0;
        q = true;
        r = true;
        str3 = "5|\025U";
        i5 = 4;
      case 4:
      }
    }
    P = str4;
    s = 0L;
    t = null;
    u = "";
    V = false;
    W = false;
    X = 10;
    z = false;
    Z = true;
    A = bb['¨'];
    B = false;
    C = false;
    ArrayList localArrayList = new ArrayList();
    aa = localArrayList;
    localArrayList.add(L + "$" + M);
    aa.add(bb['Ý'] + M);
    aa.add(bb['Ü'] + M);
  }

  private void A()
  {
    new StringBuilder(bb[16]).append(i).toString();
    x.c();
    int i1 = i;
    boolean bool = H;
    H = bool;
    if (bool)
    {
      x.c();
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(this, AlarmReceiver.class), 0);
      ((AlarmManager)getSystemService(bb[15])).set(0, System.currentTimeMillis() + i1 * 1000, localPendingIntent);
      String str = bb[14];
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(i1);
      String.format(str, arrayOfObject);
      x.d();
    }
  }

  private void B()
  {
    x.c();
    w();
    q();
  }

  private void C()
  {
    this.an.removeMessages(1007);
  }

  private void D()
  {
    x.c();
    this.Y = a(this, A, C, B);
    this.Y.f();
  }

  private static int a(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString2);
      localJSONObject.put(bb[100], "a");
      if ((paramInt1 != 0) && (paramLong != 0L))
      {
        int i1 = PushProtocol.TagAlias(paramInt1, paramLong, paramString1, localJSONObject.toString(), paramInt2);
        return i1;
      }
    }
    catch (Exception localException)
    {
    }
    return -1;
  }

  public static long a(Context paramContext)
  {
    if (s != 0L)
      return s;
    V = c(paramContext);
    return s;
  }

  private cn.jpush.android.a.d a(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new l(this, paramContext, paramString, paramBoolean1, paramBoolean2);
  }

  public static void a(int paramInt)
  {
    K = paramInt;
  }

  private void a(int paramInt, long paramLong)
  {
    String str = bb[99] + paramInt + bb[29] + paramLong;
    if (!this.x.contains(str))
      this.x.offer(str);
  }

  private void a(Context paramContext, String paramString)
  {
    x.b();
    String[] arrayOfString = q.a(paramContext);
    if ((arrayOfString == null) || (arrayOfString.length == 0))
    {
      x.f();
      return;
    }
    int i1 = arrayOfString.length;
    String str1 = "[";
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    label39: String str2;
    if (i2 < i1)
    {
      str2 = arrayOfString[i2];
      if (i3 != 0)
        break label342;
    }
    label342: for (str1 = str1 + "\"" + str2 + "\""; ; str1 = str1 + bb['·'] + str2 + "\"")
    {
      int i5 = i2 + 1;
      int i6 = i3 + 1;
      if ((i6 >= 50) || (str1.length() > 1000) || (i5 == i1))
      {
        String str3 = str1 + "]";
        String str4 = bb['¶'];
        Object[] arrayOfObject = new Object[5];
        arrayOfObject[0] = Integer.valueOf(i1);
        arrayOfObject[1] = Integer.valueOf(i4);
        arrayOfObject[2] = paramString;
        arrayOfObject[3] = Long.valueOf(s);
        arrayOfObject[4] = str3;
        String str5 = String.format(str4, arrayOfObject);
        x.c();
        if (W)
          q();
        if ((this.v != 0) && (this.Q != null) && (this.Q.isAlive()))
        {
          int i8 = PushProtocol.RepPush(this.v, s, (byte)8, str5);
          if (i8 != 0)
          {
            new StringBuilder(bb['µ']).append(i4).append(bb['´']).append(i8).toString();
            x.b();
          }
        }
        int i7 = i4 + 1;
        str1 = "[";
        i4 = i7;
        i6 = 0;
      }
      i3 = i6;
      i2 = i5;
      break label39;
      break;
    }
  }

  public static void a(String paramString)
  {
    I = paramString;
  }

  private void a(String paramString, int paramInt)
  {
    if (paramInt != 0)
    {
      b localb = (b)ServiceInterface.d.get(Integer.valueOf(paramInt));
      if ((localb != null) && (localb.c != null))
      {
        Message localMessage = new Message();
        localMessage.obj = Integer.valueOf(paramInt);
        localMessage.what = 1006;
        this.an.sendMessageDelayed(localMessage, 20000L);
      }
    }
    for (int i1 = paramInt; ; i1 = ae.b(getApplicationContext()))
    {
      b(paramString, P, i1);
      if ((this.v != 0) && (s != 0L))
        break;
      x.c();
      y();
      return;
    }
    if (a(this.v, s, P, paramString, i1) < 0)
    {
      y();
      return;
    }
    h(i1);
    x.c(bb[8], bb[9] + paramString);
  }

  private void a(String paramString1, String paramString2)
  {
    A();
    y();
    if ((paramString1 == null) || (paramString2 == null))
    {
      String.format(bb['¸'], new Object[] { paramString1, paramString2 });
      x.f();
      return;
    }
    if ((this.v == 0) || (s == 0L))
    {
      x.c();
      d(paramString1, paramString2);
      y();
      return;
    }
    int i1 = PushProtocol.EnChannel(this.v, s, paramString1, paramString2);
    if (i1 < 0)
    {
      d(paramString1, paramString2);
      y();
      return;
    }
    new StringBuilder(bb['¹']).append(i1).toString();
    x.d();
  }

  private void a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      Iterator localIterator = this.x.iterator();
      String[] arrayOfString;
      String str3;
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (str2.startsWith(bb[47]))
        {
          arrayOfString = str2.split(bb[6]);
          if (arrayOfString.length > 3)
          {
            str3 = f(arrayOfString[2], paramString1);
            if (!ai.a(str3))
              this.x.remove(str2);
          }
        }
      }
      try
      {
        ServiceInterface.b(Integer.valueOf(arrayOfString[3]).intValue());
        paramString1 = str3;
        String str1 = bb[47] + paramString2 + bb[29] + paramString1 + bb[29] + paramInt;
        new StringBuilder(bb[48]).append(paramString1).toString();
        x.c();
        this.x.offer(str1);
        return;
      }
      catch (Exception localException2)
      {
        while (true)
          paramString1 = str3;
      }
    }
    catch (Exception localException1)
    {
    }
  }

  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramString4.equals(bb[76]))
      this.ah = 0;
    while (true)
    {
      ae.b(getApplicationContext(), bb['°'], this.ah);
      Intent localIntent = new Intent(paramString4);
      if (paramString2 != null)
        localIntent.putExtra(bb[1], paramString2);
      localIntent.putExtra(bb['¯'], paramString3);
      localIntent.addCategory(paramString1);
      sendBroadcast(localIntent, String.format(bb['±'], new Object[] { paramString1 }));
      return;
      if (paramString4.equals(bb[40]))
        this.ah = 1;
    }
  }

  public static void a(boolean paramBoolean)
  {
    G = paramBoolean;
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    x.c();
    if (paramBoolean3)
      x.c();
    TelephonyManager localTelephonyManager;
    String str1;
    try
    {
      ApplicationInfo localApplicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
      if (localApplicationInfo != null)
        P = localApplicationInfo.metaData.getString(bb[28]);
      if (paramBoolean2)
      {
        if (this.v != 0)
          this.v = PushProtocol.Close(this.v);
        this.v = PushProtocol.InitConn();
        d();
        new StringBuilder(bb[26]).append(I).append(bb[22]).append(K).toString();
        x.c();
        if (PushProtocol.InitPush(this.v, I, K) != 0)
        {
          x.c();
          if (this.v != 0)
            this.v = PushProtocol.Close(this.v);
          if (!paramBoolean3)
            f(0);
          return;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      do
        while (true)
        {
          new StringBuilder(bb[35]).append(localNameNotFoundException).toString();
          x.f();
        }
      while (this.v == 0);
      localTelephonyManager = (TelephonyManager)getSystemService(bb[44]);
      str1 = cn.jpush.android.util.a.j(getApplicationContext());
      if (!cn.jpush.android.util.a.c(getApplicationContext(), bb[20]));
    }
    for (String str2 = localTelephonyManager.getSubscriberId(); ; str2 = null)
    {
      if (str1 == null)
        str1 = " ";
      if (str2 == null)
        str2 = " ";
      String str3 = getPackageName();
      String str4 = str1 + bb[29] + str2 + bb[29] + str3 + bb[29] + P;
      String str5 = u();
      String str6 = cn.jpush.android.util.a.a(getApplicationContext(), bb[23]);
      new StringBuilder(bb[34]).append(str4).toString();
      x.c();
      new StringBuilder(bb[41]).append(str5).toString();
      x.c();
      x.c();
      int i1 = this.v;
      String str7 = cn.jpush.android.util.a.l(getApplicationContext());
      String str8 = cn.jpush.android.util.a.k(getApplicationContext());
      String str9 = cn.jpush.android.util.a.g(getApplicationContext(), " ");
      String str10 = cn.jpush.android.util.a.i(getApplicationContext(), " ");
      if (ai.a(str7))
        str7 = " ";
      if (ai.a(str8))
        str8 = " ";
      if (ai.a(str9))
        str9 = " ";
      PushProtocol.RegPush(i1, str4, str5, str6, cn.jpush.android.util.a.a + bb[29] + str7 + bb[29] + str10 + bb[29] + str8 + bb[29] + str9);
      int i2 = 0;
      int i3 = PushProtocol.RecvPush(this.v, this.w, 30);
      if (i3 > 0)
      {
        int i4 = cn.jpush.android.util.a.b(this.w);
        int i5 = cn.jpush.android.util.a.c(this.w);
        new StringBuilder(bb[24]).append(i5).toString();
        x.d();
        new StringBuilder(bb[42]).append(b(this.w, i5)).toString();
        x.d();
        if (i4 != c.a.ordinal())
        {
          new StringBuilder(bb[25]).append(i4).toString();
          x.f();
          return;
        }
        for (int i6 = 0; i6 < 2; i6++)
          i2 = (i2 << 8) + (0xFF & this.w[(i6 + 20)]);
        if (i2 == 0)
        {
          if (i == 86401)
          {
            x.c();
            ae.b(getApplicationContext(), bb[46], 300);
            i = 300;
            A();
          }
          int i10 = 0;
          long l2;
          for (long l1 = 0L; i10 < 8; l1 = l2)
          {
            l2 = (l1 << 8) + (0xFF & this.w[(i10 + 22)]);
            i10++;
          }
          int i11 = 0;
          int i24;
          for (int i12 = 0; i11 < 2; i12 = i24)
          {
            i24 = (i12 << 8) + (0xFF & this.w[(i11 + 30)]);
            i11++;
          }
          byte[] arrayOfByte2 = new byte[i12];
          for (int i13 = 0; i13 < arrayOfByte2.length; i13++)
            arrayOfByte2[i13] = ((byte)(0xFF & this.w[(i13 + 32)]));
          String str13 = new String(arrayOfByte2);
          new StringBuilder(bb[32]).append(l1).toString();
          x.d();
          s = l1;
          t = str13;
          V = true;
          int i19;
          try
          {
            FileOutputStream localFileOutputStream = openFileOutput(bb[37], 0);
            localFileOutputStream.write(ByteBuffer.allocate(8).putLong(s).array());
            localFileOutputStream.write(t.getBytes());
            localFileOutputStream.close();
            i14 = i12 + 32;
            i15 = 0;
            for (int i16 = 0; i16 < 2; i16++)
              i15 = (i15 << 8) + (0xFF & this.w[(i14 + i16)]);
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            while (true)
              x.h();
          }
          catch (IOException localIOException)
          {
            int i14;
            int i15;
            while (true)
              x.h();
            int i17 = i14 + 2;
            byte[] arrayOfByte3 = new byte[i15];
            for (int i18 = 0; i18 < arrayOfByte3.length; i18++)
              arrayOfByte3[i18] = ((byte)(0xFF & this.w[(i17 + i18)]));
            String str14 = new String(arrayOfByte3);
            new StringBuilder(bb[33]).append(str14).toString();
            x.c();
            if (!ai.a(str14))
            {
              ae.b(getApplicationContext(), bb[31], str14);
              if (!paramBoolean3)
                a(cn.jpush.android.a.b, cn.jpush.android.a.f, str14, bb[40]);
            }
            i19 = i17 + i15;
          }
          if (i19 >= i5)
            break;
          int i20 = 0;
          for (int i21 = 0; i21 < 2; i21++)
            i20 = (i20 << 8) + (0xFF & this.w[(i19 + i21)]);
          int i22 = i19 + 2;
          byte[] arrayOfByte4 = new byte[i20];
          if (i5 != i20 + i22)
          {
            x.f();
            return;
          }
          for (int i23 = 0; i23 < arrayOfByte4.length; i23++)
            arrayOfByte4[i23] = ((byte)(0xFF & this.w[(i22 + i23)]));
          String str15 = new String(arrayOfByte4);
          new StringBuilder(bb[27]).append(str15).toString();
          x.c();
          cn.jpush.android.util.a.j(getApplicationContext(), str15);
          return;
        }
        if (i2 == 1007)
        {
          int i7 = 0;
          for (int i8 = 0; i8 < 2; i8++)
            i7 = (i7 << 8) + (0xFF & this.w[(i8 + 22)]);
          byte[] arrayOfByte1 = new byte[i7];
          for (int i9 = 0; i9 < arrayOfByte1.length; i9++)
            arrayOfByte1[i9] = ((byte)(0xFF & this.w[(i9 + 24)]));
          String str12 = new String(arrayOfByte1);
          new StringBuilder(bb[39]).append(str12).toString();
          x.f();
          cn.jpush.android.util.a.c(str12);
          if (paramBoolean1)
            break;
          a(true, false, paramBoolean3);
          return;
        }
        x.e(bb[8], bb[43] + i2);
        String str11 = p.a(i2);
        if (str11 != null)
          x.e(bb[8], bb[45] + str11);
        if (1006 == i2)
        {
          t();
          return;
        }
        if (1007 == i2)
        {
          x.d();
          return;
        }
        if (1005 != i2)
          break;
        cn.jpush.android.util.a.c(getApplicationContext(), bb[36] + getPackageName() + bb[38] + cn.jpush.android.a.f + bb[30], bb[36] + getPackageName() + bb[38] + cn.jpush.android.a.f + bb[30]);
        t();
        return;
      }
      x.e(bb[8], bb[21] + i3);
      this.ae = 0L;
      return;
    }
  }

  public static boolean a()
  {
    return H;
  }

  public static String b()
  {
    return I;
  }

  public static String b(Context paramContext)
  {
    if (!ai.a(t))
      return t;
    V = c(paramContext);
    return t;
  }

  private static String b(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i1 = 0; i1 < paramInt; i1++)
    {
      String str = Integer.toHexString(0xFF & paramArrayOfByte[i1]);
      if (str.length() == 1)
        str = "0" + str;
      localStringBuffer.append(str.toUpperCase() + " ");
    }
    return "[" + localStringBuffer.toString() + "]";
  }

  public static void b(int paramInt)
  {
    N = paramInt;
  }

  public static void b(String paramString)
  {
    J = paramString;
  }

  private void b(String paramString1, String paramString2)
  {
    try
    {
      if ((ai.a(paramString1)) || (ai.a(paramString2)))
      {
        String.format(bb[18], new Object[] { paramString1, paramString2 });
        x.f();
        return;
      }
      if (this.v == 0)
      {
        x.c();
        c(paramString1, paramString2);
        y();
      }
      while (true)
      {
        return;
        i1 = PushProtocol.UnChnelId(this.v, s, paramString1, paramString2);
        if (i1 >= 0)
          break;
        c(paramString1, paramString2);
        y();
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        int i1;
        return;
        new StringBuilder(bb[19]).append(i1).toString();
        x.d();
      }
    }
    finally
    {
      a(0, bb[17]);
      B();
      stopSelf();
    }
  }

  private void b(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt).append(bb[29]).append(paramString2).append(bb[29]).append(paramString1);
      String str = localStringBuilder.toString();
      e(paramString1, paramString2);
      this.y.offer(str);
      if (this.y.size() >= 200)
        this.y.poll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static void b(boolean paramBoolean)
  {
    H = paramBoolean;
  }

  public static void c(int paramInt)
  {
    O = paramInt;
  }

  public static void c(String paramString)
  {
    L = paramString;
  }

  private void c(String paramString1, String paramString2)
  {
    String str = bb[7] + paramString1 + "," + paramString2;
    if (this.x.contains(str))
      return;
    this.x.offer(str);
  }

  public static void c(boolean paramBoolean)
  {
    W = paramBoolean;
  }

  public static boolean c()
  {
    return true;
  }

  protected static boolean c(Context paramContext)
  {
    while (true)
    {
      boolean bool2;
      try
      {
        x.d();
        try
        {
          byte[] arrayOfByte = new byte[8];
          localFileInputStream = paramContext.openFileInput(bb[37]);
          localFileInputStream.read(arrayOfByte, 0, 8);
          s = 0L;
          int i1 = 0;
          if (i1 < 8)
          {
            s = (s << 8) + (0xFF & arrayOfByte[i1]);
            i1++;
            continue;
          }
          localStringBuilder = new StringBuilder();
          int i2 = localFileInputStream.read();
          if (i2 != -1)
          {
            localStringBuilder.append((char)i2);
            continue;
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          FileInputStream localFileInputStream;
          StringBuilder localStringBuilder;
          x.c();
          s = 0L;
          long l1 = s;
          boolean bool1 = l1 < 0L;
          bool2 = false;
          if (!bool1)
          {
            return bool2;
            localFileInputStream.close();
            t = localStringBuilder.toString();
            continue;
          }
        }
        catch (IOException localIOException)
        {
          x.h();
          continue;
        }
      }
      finally
      {
      }
      if (ai.a(u))
        u = cn.jpush.android.util.a.u(paramContext);
      if (ai.a(u))
      {
        x.c();
        bool2 = false;
      }
      else
      {
        bool2 = true;
      }
    }
  }

  public static void d(int paramInt)
  {
    X = paramInt;
  }

  public static void d(String paramString)
  {
    M = paramString;
  }

  private void d(String paramString1, String paramString2)
  {
    String str = bb['Õ'] + paramString1 + "," + paramString2;
    if (this.x.contains(str))
      return;
    this.x.offer(str);
  }

  public static void d(boolean paramBoolean)
  {
    Z = paramBoolean;
  }

  private void e(String paramString1, String paramString2)
  {
    if ((ai.a(paramString1)) || (ai.a(paramString2)))
      return;
    while (true)
    {
      String str1;
      try
      {
        Iterator localIterator = this.y.iterator();
        if (!localIterator.hasNext())
          break;
        str1 = (String)localIterator.next();
        if (ai.a(str1))
          continue;
        String[] arrayOfString = str1.split(bb[6]);
        if (arrayOfString.length > 2)
        {
          int i1 = Integer.valueOf(arrayOfString[0]).intValue();
          String str2 = arrayOfString[1];
          if ((!paramString1.equals(arrayOfString[2])) || (!paramString2.equals(str2)))
            continue;
          this.y.remove(str1);
          i(i1);
          continue;
        }
      }
      catch (Exception localException)
      {
        localException.getMessage();
        x.f();
        return;
      }
      new StringBuilder(bb[5]).append(str1).toString();
      x.f();
      this.y.remove(str1);
    }
  }

  private static String f(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString1);
      JSONObject localJSONObject2 = new JSONObject(paramString2);
      if (localJSONObject2.has(bb['¬']))
        localJSONObject1.put(bb['¬'], localJSONObject2.get(bb['¬']));
      if (localJSONObject2.has(bb['­']))
        localJSONObject1.put(bb['­'], localJSONObject2.get(bb['­']));
      String str = localJSONObject1.toString();
      return str;
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
    }
    return null;
  }

  private void g(int paramInt)
  {
    new StringBuilder(bb['']).append(paramInt).append(bb['']).toString();
    x.c();
    this.an.removeMessages(1005);
    this.an.removeMessages(1004);
    this.an.sendEmptyMessageDelayed(1004, paramInt);
  }

  private void g(String paramString1, String paramString2)
  {
    this.x.offer(bb[''] + paramString1 + "," + paramString2);
  }

  private void h(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.obj = Integer.valueOf(paramInt);
    localMessage.what = 1008;
    this.an.sendMessageDelayed(localMessage, 10000L);
  }

  private void i(int paramInt)
  {
    this.an.removeMessages(1008, Integer.valueOf(paramInt));
  }

  private void i(String paramString)
  {
    x.c();
    int i1 = 0;
    int i6;
    for (int i2 = 0; i1 < 2; i2 = i6)
    {
      i6 = (i2 << 8) + (0xFF & this.w[(i1 + 20)]);
      i1++;
    }
    String str1 = bb[106];
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(i2);
    String.format(str1, arrayOfObject1);
    x.c();
    long l1 = 0L;
    for (int i3 = 0; i3 < 4; i3++)
      l1 = (l1 << 8) + (0xFF & this.w[(i3 + 22)]);
    String str2 = bb[104];
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Long.valueOf(l1);
    String.format(str2, arrayOfObject2);
    x.c();
    byte[] arrayOfByte1 = new byte[100];
    for (int i4 = 0; (i4 < arrayOfByte1.length) && (this.w[(i4 + 26)] != 0); i4++)
      arrayOfByte1[i4] = ((byte)(0xFF & this.w[(i4 + 26)]));
    String str3 = new String(arrayOfByte1, 0, i4);
    new StringBuilder(bb[103]).append(str3).toString();
    x.c();
    byte[] arrayOfByte2 = new byte[30];
    for (int i5 = 0; (i5 < arrayOfByte2.length) && (this.w[(i5 + 126)] != 0); i5++)
      arrayOfByte2[i5] = ((byte)(0xFF & this.w[(i5 + 126)]));
    String str4 = new String(arrayOfByte2, 0, i5);
    new StringBuilder(bb[105]).append(str4).toString();
    x.c();
    if (i2 == 0)
    {
      Intent localIntent = new Intent(paramString);
      localIntent.putExtra(bb[1], str4);
      localIntent.addCategory(str3);
      sendBroadcast(localIntent, String.format(bb['±'], new Object[] { str3 }));
    }
  }

  private void j(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      int i1 = localJSONObject.optInt(bb['Ö'], cn.jpush.android.api.d.i);
      int i2 = localJSONObject.optInt(bb['Ù']);
      if (i2 != 0)
      {
        b localb = ServiceInterface.a(i2);
        if (localb != null)
        {
          TagAliasCallback localTagAliasCallback = localb.c;
          new StringBuilder(bb['Ø']).append(i2).toString();
          x.c();
          if (localTagAliasCallback != null)
          {
            ServiceInterface.b(i2);
            k(i2);
            this.an.removeMessages(1006, Integer.valueOf(i2));
            localTagAliasCallback.gotResult(i1, localb.a, localb.b);
            return;
          }
          new StringBuilder(bb['×']).append(i2).toString();
          x.f();
          return;
        }
      }
    }
    catch (Exception localException)
    {
    }
  }

  private boolean j(int paramInt)
  {
    try
    {
      Iterator localIterator = this.y.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!ai.a(str))
        {
          String[] arrayOfString = str.split(bb[6]);
          if (arrayOfString.length > 2)
          {
            int i1 = Integer.valueOf(arrayOfString[0]).intValue();
            if (paramInt == i1)
              return true;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException.getMessage();
      x.f();
    }
    return false;
  }

  private void k(int paramInt)
  {
    try
    {
      Iterator localIterator = this.y.iterator();
      while (true)
      {
        String str;
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          String[] arrayOfString = str.split(bb[6]);
          if (arrayOfString.length >= 2)
          {
            int i1 = Integer.valueOf(arrayOfString[0]).intValue();
            this.y.remove(str);
            i(i1);
            if (i1 != paramInt)
              continue;
          }
        }
        else
        {
          return;
          new StringBuilder(bb[5]).append(str).toString();
          x.f();
          this.y.remove(str);
        }
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.getMessage();
        x.f();
      }
    }
    finally
    {
    }
  }

  private void k(String paramString)
  {
    x.c();
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      ae.a(getApplicationContext(), localJSONObject);
      if (ae.a(this, bb[12], bb[10]).toLowerCase().equals(bb[11]))
      {
        x.c();
        if (this.v != 0)
          PushProtocol.RepPush(this.v, s, (byte)3, bb[13]);
      }
      return;
    }
    catch (Exception localException)
    {
      x.h();
    }
  }

  private void l(String paramString)
  {
    x.c();
    JSONObject localJSONObject;
    int i1;
    HashMap localHashMap;
    while (true)
    {
      int i5;
      String str;
      try
      {
        localJSONObject = new JSONObject(paramString);
        i1 = localJSONObject.optInt(bb['£'], -1);
        if (i1 == -1)
          return;
        localHashMap = new HashMap();
        int i2 = localJSONObject.optInt(bb['¤'], -1);
        if (i2 != -1)
        {
          if (i2 == 0)
          {
            Z = true;
            localHashMap.put(bb['¤'], Boolean.valueOf(true));
          }
        }
        else
        {
          int i3 = localJSONObject.optInt(bb['¢'], -1);
          new StringBuilder(bb['¡']).append(i3).toString();
          x.c();
          if (i3 != -1)
          {
            if (i3 != 0)
              break label429;
            localHashMap.put(bb['¢'], Boolean.valueOf(true));
          }
          int i4 = localJSONObject.optInt(bb['§'], -1);
          if (i4 != -1)
          {
            if (i4 != 0)
              break label449;
            localHashMap.put(bb['§'], Boolean.valueOf(true));
          }
          localHashMap.toString();
          x.c();
          if (i1 != 2)
            break;
          i5 = localJSONObject.optInt(bb['ª'], -1);
          str = bb['¨'];
          if (i5 != -1)
          {
            if (i5 != 0)
              break label469;
            str = bb['¨'];
          }
          Intent localIntent1 = new Intent(this, PushService.class);
          Bundle localBundle1 = new Bundle();
          localBundle1.putString(bb['ª'], str);
          if (localHashMap.get(bb['¢']) != null)
            localBundle1.putBoolean(bb['¢'], ((Boolean)localHashMap.get(bb['¢'])).booleanValue());
          if (localHashMap.get(bb['§']) != null)
            localBundle1.putBoolean(bb['§'], ((Boolean)localHashMap.get(bb['§'])).booleanValue());
          localIntent1.putExtras(localBundle1);
          startService(localIntent1);
          return;
        }
        localHashMap.put(bb['¤'], Boolean.valueOf(false));
        continue;
      }
      catch (JSONException localJSONException)
      {
        x.h();
        return;
      }
      label429: localHashMap.put(bb['¢'], Boolean.valueOf(false));
      continue;
      label449: localHashMap.put(bb['§'], Boolean.valueOf(false));
      continue;
      label469: if (i5 == 1)
        str = bb['¦'];
      else if (i5 == 2)
        str = bb['¥'];
      else if (i5 == 3)
        str = bb['©'];
    }
    if (localHashMap.get(bb['§']) != null)
      B = ((Boolean)localHashMap.get(bb['§'])).booleanValue();
    if (localHashMap.get(bb['¢']) != null)
      C = ((Boolean)localHashMap.get(bb['¢'])).booleanValue();
    if (localHashMap.get(bb['¤']) != null)
      Z = ((Boolean)localHashMap.get(bb['¤'])).booleanValue();
    int i6 = localJSONObject.optInt(bb['ª'], -1);
    if (i6 != -1)
    {
      if (i6 != 0)
        break label739;
      A = bb['¨'];
    }
    while (i1 == 0)
    {
      Intent localIntent2 = new Intent(this, PushService.class);
      Bundle localBundle2 = new Bundle();
      localBundle2.putString(bb[''], bb['']);
      localIntent2.putExtras(localBundle2);
      startService(localIntent2);
      return;
      label739: if (i6 == 1)
        A = bb['¦'];
      else if (i6 == 2)
        A = bb['¥'];
      else if (i6 == 3)
        A = bb['©'];
    }
  }

  private void m(String paramString)
  {
    int i1 = 0;
    try
    {
      x.c();
      int i2 = 0;
      int i4;
      for (int i3 = 0; i2 < 2; i3 = i4)
      {
        i4 = (i3 << 8) + (0xFF & this.w[(i2 + 20)]);
        i2++;
      }
      String str1 = bb[106];
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i3);
      String.format(str1, arrayOfObject1);
      x.c();
      byte[] arrayOfByte1 = new byte[8];
      for (int i5 = 0; i5 < arrayOfByte1.length; i5++)
        arrayOfByte1[i5] = ((byte)(0xFF & this.w[(i5 + 22)]));
      StringBuilder localStringBuilder = new StringBuilder(2 * arrayOfByte1.length);
      int i6 = arrayOfByte1.length;
      for (int i7 = 0; i7 < i6; i7++)
      {
        int i8 = arrayOfByte1[i7];
        String str2 = bb[108];
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Integer.valueOf(i8 & 0xFF);
        localStringBuilder.append(String.format(str2, arrayOfObject2));
      }
      String str3 = localStringBuilder.toString();
      new StringBuilder(bb[107]).append(str3).toString();
      x.c();
      int i9 = 0;
      int i10 = 0;
      while (i9 < 2)
      {
        i10 = (i10 << 8) + (0xFF & this.w[(i9 + 30)]);
        i9++;
      }
      new StringBuilder(bb['®']).append(i10).toString();
      x.c();
      byte[] arrayOfByte2 = new byte[100];
      while ((i1 < arrayOfByte2.length) && (this.w[(i1 + 32)] != 0))
      {
        arrayOfByte2[i1] = ((byte)(0xFF & this.w[(i1 + 32)]));
        i1++;
      }
      String str4 = new String(arrayOfByte2, 0, i1);
      new StringBuilder(bb[103]).append(str4).toString();
      x.c();
      if (i3 == 0)
      {
        a(str4, null, str3, paramString);
        return;
      }
      String str5 = bb[109];
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(i3);
      String.format(str5, arrayOfObject3);
      x.d();
      return;
    }
    catch (Exception localException)
    {
      x.j();
    }
  }

  private void n(String paramString)
  {
    int i1 = 0;
    try
    {
      x.c();
      int i2 = 0;
      int i4;
      for (int i3 = 0; i2 < 2; i3 = i4)
      {
        i4 = (i3 << 8) + (0xFF & this.w[(i2 + 20)]);
        i2++;
      }
      String str1 = bb[106];
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i3);
      String.format(str1, arrayOfObject1);
      x.c();
      long l1 = 0L;
      for (int i5 = 0; i5 < 4; i5++)
        l1 = (l1 << 8) + (0xFF & this.w[(i5 + 22)]);
      String str2 = bb[104];
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Long.valueOf(l1);
      String.format(str2, arrayOfObject2);
      x.c();
      byte[] arrayOfByte1 = new byte[8];
      for (int i6 = 0; i6 < arrayOfByte1.length; i6++)
        arrayOfByte1[i6] = ((byte)(0xFF & this.w[(i6 + 26)]));
      StringBuilder localStringBuilder = new StringBuilder(2 * arrayOfByte1.length);
      int i7 = arrayOfByte1.length;
      for (int i8 = 0; i8 < i7; i8++)
      {
        int i9 = arrayOfByte1[i8];
        String str3 = bb[108];
        Object[] arrayOfObject3 = new Object[1];
        arrayOfObject3[0] = Integer.valueOf(i9 & 0xFF);
        localStringBuilder.append(String.format(str3, arrayOfObject3));
      }
      String str4 = localStringBuilder.toString();
      new StringBuilder(bb[107]).append(str4).toString();
      x.c();
      byte[] arrayOfByte2 = new byte[100];
      for (int i10 = 0; (i10 < arrayOfByte2.length) && (this.w[(i10 + 34)] != 0); i10++)
        arrayOfByte2[i10] = ((byte)(0xFF & this.w[(i10 + 34)]));
      String str5 = new String(arrayOfByte2, 0, i10);
      new StringBuilder(bb[103]).append(str5).toString();
      x.c();
      byte[] arrayOfByte3 = new byte[30];
      while ((i1 < arrayOfByte3.length) && (this.w[(i1 + 134)] != 0))
      {
        arrayOfByte3[i1] = ((byte)(0xFF & this.w[(i1 + 134)]));
        i1++;
      }
      String str6 = new String(arrayOfByte3, 0, i1);
      new StringBuilder(bb[105]).append(str6).toString();
      x.c();
      if (i3 == 0)
      {
        a(str5, str6, str4, paramString);
        return;
      }
      String str7 = bb[109];
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Integer.valueOf(i3);
      String.format(str7, arrayOfObject4);
      x.d();
      return;
    }
    catch (Exception localException)
    {
      x.j();
    }
  }

  private void o(String paramString)
  {
    x.b();
    int i5;
    while (true)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        int i1 = localJSONObject.optInt(bb[''], -1);
        if (i1 != -1)
        {
          new StringBuilder(bb['']).append(Integer.toString(i1)).toString();
          x.c();
          i = i1 * 60;
          ae.b(this, bb[46], i);
        }
        int i2 = localJSONObject.optInt(bb[''], -1);
        if (i2 != -1)
        {
          new StringBuilder(bb['']).append(Integer.toString(i2)).toString();
          x.c();
          if (i2 == 0)
          {
            q = false;
            ae.b(this, bb[''], bb[115]);
          }
        }
        else
        {
          int i3 = localJSONObject.optInt(bb[''], -1);
          if (i3 != -1)
          {
            new StringBuilder(bb['']).append(Integer.toString(i3)).toString();
            x.c();
            if (i3 != 0)
              break label368;
            r = false;
            ae.b(this, bb[''], i3);
          }
          int i4 = localJSONObject.optInt(bb[''], -1);
          if (i4 != -1)
          {
            new StringBuilder(bb['']).append(Integer.toString(i4)).toString();
            x.c();
            ae.b(this, bb[''], i4);
          }
          i5 = localJSONObject.optInt(bb[''], -1);
          if (i5 == -1)
            return;
          if (i5 != 0)
            break;
          ae.b(this, bb[114], bb[115]);
          x.c();
          stopSelf();
          return;
        }
        q = true;
        ae.b(this, bb[''], bb[11]);
        continue;
      }
      catch (JSONException localJSONException)
      {
        x.h();
        return;
      }
      label368: r = true;
    }
    if (i5 == 1)
    {
      x.c();
      stopSelf();
      return;
    }
    if (i5 == 2)
      ServiceInterface.d(getApplicationContext());
  }

  private void q()
  {
    new StringBuilder(bb['']).append(X).append("s").toString();
    x.c();
    this.an.removeMessages(1001);
    this.an.sendEmptyMessageDelayed(1001, 1000 * X);
  }

  private byte[] r()
  {
    String str1 = cn.jpush.android.util.a.d(this);
    String str2 = ((TelephonyManager)getSystemService(bb[44])).getNetworkOperator();
    String str3 = bb[84] + str1;
    try
    {
      int i3 = Integer.valueOf(str2).intValue();
      i1 = i3;
      byte[] arrayOfByte1 = new byte[''];
      byte[] arrayOfByte2 = { 0, 80 };
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
      aa.a(arrayOfByte1, str3, 2);
      aa.e(arrayOfByte1, i1, 34);
      aa.e(arrayOfByte1, Integer.parseInt(s), 38);
      if (P.length() > 50)
        P = P.substring(0, 49);
      aa.a(arrayOfByte1, P, 42);
      aa.a(arrayOfByte1, bb[23], 92);
      boolean bool = c;
      int i2 = 0;
      if (bool)
        i2 = 1;
      aa.e(arrayOfByte1, i2, 102);
      return arrayOfByte1;
    }
    catch (Exception localException)
    {
      while (true)
        int i1 = 0;
    }
  }

  // ERROR //
  private void s()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   5: aload_0
    //   6: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   9: bipush 37
    //   11: aaload
    //   12: invokevirtual 1434	cn/jpush/android/service/PushService:deleteFile	(Ljava/lang/String;)Z
    //   15: pop
    //   16: iconst_0
    //   17: putstatic 636	cn/jpush/android/service/PushService:V	Z
    //   20: lconst_0
    //   21: putstatic 628	cn/jpush/android/service/PushService:s	J
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: astore_1
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: astore_2
    //   33: goto -9 -> 24
    //
    // Exception table:
    //   from	to	target	type
    //   2	5	27	finally
    //   5	24	27	finally
    //   5	24	32	java/lang/Exception
  }

  private void t()
  {
    x.c();
    ae.b(getApplicationContext(), bb[46], 86401);
    i = 86401;
    stopSelf();
  }

  private String u()
  {
    try
    {
      Object localObject = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
      if (((String)localObject).length() > 30)
      {
        x.e(bb[8], bb[102]);
        String str = ((String)localObject).substring(0, 30);
        localObject = str;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return bb[101];
  }

  private void v()
  {
    int i1 = 0;
    if (this.w.length < 31)
    {
      x.f();
      return;
    }
    int i2 = cn.jpush.android.util.a.a(this.w[20]);
    for (int i3 = 0; i3 < 8; i3++);
    if (i2 == 2)
    {
      m = ae.a(getApplicationContext(), bb[83], m);
      n = ae.a(getApplicationContext(), bb[79], n);
      new StringBuilder(bb[80]).append(m).append(bb[82]).append(n).toString();
      x.d();
      x.c();
      C();
      return;
    }
    if (i2 == 10)
    {
      for (int i4 = 0; i4 < 2; i4++)
        i1 = (i1 << 8) + (0xFF & this.w[(i4 + 4)]);
      new StringBuilder(bb[81]).append(i1).toString();
      x.c();
      i(i1);
      k(i1);
      return;
    }
    new StringBuilder(bb[72]).append(i2).toString();
    x.e();
  }

  private void w()
  {
    try
    {
      x.c();
      if (this.v != 0)
        PushProtocol.Stop(this.v);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void x()
  {
    try
    {
      this.an.removeMessages(1008);
      while (true)
      {
        String str1;
        try
        {
          Iterator localIterator = this.y.iterator();
          if (localIterator.hasNext())
          {
            str1 = (String)localIterator.next();
            new StringBuilder(bb['«']).append(str1).toString();
            x.f();
            if (ai.a(str1))
              continue;
            String[] arrayOfString = str1.split(bb[6]);
            if (arrayOfString.length <= 2)
              break label161;
            int i1 = Integer.valueOf(arrayOfString[0]).intValue();
            String str2 = arrayOfString[1];
            String str3 = arrayOfString[2];
            a(this.v, s, str2, str3, i1);
            h(i1);
            continue;
          }
        }
        catch (Exception localException)
        {
          localException.getMessage();
          x.f();
          return;
        }
        label161: new StringBuilder(bb[5]).append(str1).toString();
        x.f();
        this.y.remove(str1);
      }
    }
    finally
    {
    }
  }

  private void y()
  {
    x.c();
    C();
    if (this.Q != null)
    {
      if (!this.Q.isAlive());
      while (true)
      {
        try
        {
          this.Q.join();
          this.Q = new n(this);
          this.Q.start();
          return;
        }
        catch (Exception localException3)
        {
          x.h();
          return;
        }
        new StringBuilder(bb[' ']).append(this.Q.getId()).toString();
        x.c();
        try
        {
          if (!this.Q.a)
          {
            x.c();
            this.Q = new n(this);
            this.Q.start();
            return;
          }
        }
        catch (Exception localException2)
        {
          x.h();
          return;
        }
      }
    }
    try
    {
      this.Q = new n(this);
      this.Q.start();
      return;
    }
    catch (Exception localException1)
    {
      x.h();
    }
  }

  private void z()
  {
    x.c();
    while (true)
    {
      String str = (String)this.x.poll();
      if (str == null)
        break;
      r.a(getApplicationContext(), str);
    }
  }

  protected final void a(int paramInt, String paramString)
  {
    String str1 = cn.jpush.android.a.b;
    String str2 = cn.jpush.android.a.f;
    x.c();
    if (paramInt == this.ag)
      return;
    this.ag = paramInt;
    ae.b(getApplicationContext(), bb['³'], paramInt);
    Intent localIntent = new Intent(paramString);
    if (str2 != null)
      localIntent.putExtra(bb[1], str2);
    String str3 = bb['²'];
    boolean bool;
    if (paramInt == 1)
    {
      bool = true;
      localIntent.putExtra(str3, bool);
      if (!ai.a(str1))
        break label149;
    }
    label149: for (String str4 = getPackageName(); ; str4 = str1)
    {
      localIntent.addCategory(str4);
      sendBroadcast(localIntent, String.format(bb['±'], new Object[] { str4 }));
      return;
      bool = false;
      break;
    }
  }

  // ERROR //
  public final void d()
  {
    // Byte code:
    //   0: invokestatic 751	java/lang/System:currentTimeMillis	()J
    //   3: aload_0
    //   4: getfield 815	cn/jpush/android/service/PushService:ae	J
    //   7: lsub
    //   8: invokestatic 1198	java/lang/Math:abs	(J)J
    //   11: ldc2_w 1463
    //   14: lcmp
    //   15: ifge +7 -> 22
    //   18: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   21: return
    //   22: new 1466	java/net/DatagramSocket
    //   25: dup
    //   26: invokespecial 1467	java/net/DatagramSocket:<init>	()V
    //   29: astore_1
    //   30: sipush 1024
    //   33: newarray byte
    //   35: astore 6
    //   37: getstatic 656	cn/jpush/android/service/PushService:aa	Ljava/util/List;
    //   40: getstatic 679	cn/jpush/android/service/PushService:D	I
    //   43: invokeinterface 1470 2 0
    //   48: checkcast 86	java/lang/String
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +66 -> 121
    //   58: aload 7
    //   60: ldc_w 665
    //   63: invokevirtual 1473	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   66: ifle +55 -> 121
    //   69: new 658	java/lang/StringBuilder
    //   72: dup
    //   73: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   76: bipush 87
    //   78: aaload
    //   79: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload 7
    //   84: invokevirtual 663	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: pop
    //   91: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   94: aload 7
    //   96: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   99: bipush 91
    //   101: aaload
    //   102: invokevirtual 958	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   105: astore 36
    //   107: aload 36
    //   109: iconst_0
    //   110: aaload
    //   111: putstatic 610	cn/jpush/android/service/PushService:L	Ljava/lang/String;
    //   114: aload 36
    //   116: iconst_1
    //   117: aaload
    //   118: putstatic 614	cn/jpush/android/service/PushService:M	Ljava/lang/String;
    //   121: getstatic 610	cn/jpush/android/service/PushService:L	Ljava/lang/String;
    //   124: invokestatic 1479	java/net/InetAddress:getAllByName	(Ljava/lang/String;)[Ljava/net/InetAddress;
    //   127: iconst_0
    //   128: aaload
    //   129: astore 34
    //   131: aload 34
    //   133: astore 11
    //   135: aload_0
    //   136: invokespecial 1481	cn/jpush/android/service/PushService:r	()[B
    //   139: astore 12
    //   141: aload 12
    //   143: arraylength
    //   144: istore 13
    //   146: iload 13
    //   148: sipush 256
    //   151: if_icmple +742 -> 893
    //   154: sipush 256
    //   157: istore 14
    //   159: getstatic 616	cn/jpush/android/service/PushService:N	I
    //   162: bipush 80
    //   164: if_icmpne +297 -> 461
    //   167: new 658	java/lang/StringBuilder
    //   170: dup
    //   171: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   174: bipush 86
    //   176: aaload
    //   177: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: getstatic 616	cn/jpush/android/service/PushService:N	I
    //   183: invokevirtual 722	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: pop
    //   190: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   193: new 1483	java/net/DatagramPacket
    //   196: dup
    //   197: aload 12
    //   199: iload 14
    //   201: aload 11
    //   203: getstatic 616	cn/jpush/android/service/PushService:N	I
    //   206: invokespecial 1486	java/net/DatagramPacket:<init>	([BILjava/net/InetAddress;I)V
    //   209: astore 16
    //   211: aload_1
    //   212: sipush 3000
    //   215: invokevirtual 1489	java/net/DatagramSocket:setSoTimeout	(I)V
    //   218: aload_1
    //   219: aload 16
    //   221: invokevirtual 1493	java/net/DatagramSocket:send	(Ljava/net/DatagramPacket;)V
    //   224: new 1483	java/net/DatagramPacket
    //   227: dup
    //   228: aload 6
    //   230: aload 6
    //   232: arraylength
    //   233: invokespecial 1496	java/net/DatagramPacket:<init>	([BI)V
    //   236: astore 17
    //   238: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   241: aload_1
    //   242: aload 17
    //   244: invokevirtual 1499	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   247: aload 17
    //   249: invokevirtual 1502	java/net/DatagramPacket:getLength	()I
    //   252: newarray byte
    //   254: astore 18
    //   256: aload 17
    //   258: invokevirtual 1505	java/net/DatagramPacket:getData	()[B
    //   261: iconst_0
    //   262: aload 18
    //   264: iconst_0
    //   265: aload 18
    //   267: arraylength
    //   268: invokestatic 1416	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   271: new 86	java/lang/String
    //   274: dup
    //   275: aload 18
    //   277: invokespecial 1100	java/lang/String:<init>	([B)V
    //   280: astore 19
    //   282: new 658	java/lang/StringBuilder
    //   285: dup
    //   286: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   289: bipush 94
    //   291: aaload
    //   292: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   295: aload 19
    //   297: invokevirtual 663	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: pop
    //   304: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   307: aconst_null
    //   308: putstatic 604	cn/jpush/android/service/PushService:J	Ljava/lang/String;
    //   311: new 793	org/json/JSONObject
    //   314: dup
    //   315: aload 19
    //   317: invokespecial 794	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   320: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   323: bipush 85
    //   325: aaload
    //   326: invokevirtual 1509	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   329: astore 21
    //   331: aload 21
    //   333: ifnull +15 -> 348
    //   336: aload 21
    //   338: invokevirtual 1512	org/json/JSONArray:length	()I
    //   341: istore 22
    //   343: iload 22
    //   345: ifne +182 -> 527
    //   348: aload_1
    //   349: ifnull -328 -> 21
    //   352: aload_1
    //   353: invokevirtual 1513	java/net/DatagramSocket:close	()V
    //   356: return
    //   357: astore 8
    //   359: getstatic 614	cn/jpush/android/service/PushService:M	Ljava/lang/String;
    //   362: invokestatic 1517	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   365: astore 9
    //   367: new 658	java/lang/StringBuilder
    //   370: dup
    //   371: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   374: bipush 98
    //   376: aaload
    //   377: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: getstatic 610	cn/jpush/android/service/PushService:L	Ljava/lang/String;
    //   383: invokevirtual 663	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: pop
    //   390: aload 9
    //   392: astore 11
    //   394: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   397: goto -262 -> 135
    //   400: astore_3
    //   401: aload_1
    //   402: astore 4
    //   404: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   407: getstatic 616	cn/jpush/android/service/PushService:N	I
    //   410: bipush 80
    //   412: if_icmpeq +435 -> 847
    //   415: bipush 80
    //   417: putstatic 616	cn/jpush/android/service/PushService:N	I
    //   420: aload_0
    //   421: invokevirtual 1036	cn/jpush/android/service/PushService:d	()V
    //   424: iconst_1
    //   425: getstatic 679	cn/jpush/android/service/PushService:D	I
    //   428: iadd
    //   429: iconst_3
    //   430: irem
    //   431: putstatic 679	cn/jpush/android/service/PushService:D	I
    //   434: aload_0
    //   435: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   438: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   441: bipush 92
    //   443: aaload
    //   444: getstatic 679	cn/jpush/android/service/PushService:D	I
    //   447: invokestatic 983	cn/jpush/android/util/ae:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   450: aload 4
    //   452: ifnull -431 -> 21
    //   455: aload 4
    //   457: invokevirtual 1513	java/net/DatagramSocket:close	()V
    //   460: return
    //   461: new 658	java/lang/StringBuilder
    //   464: dup
    //   465: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   468: bipush 93
    //   470: aaload
    //   471: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   474: sipush 10000
    //   477: getstatic 616	cn/jpush/android/service/PushService:N	I
    //   480: iadd
    //   481: invokevirtual 722	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: pop
    //   488: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   491: new 1483	java/net/DatagramPacket
    //   494: dup
    //   495: aload 12
    //   497: iload 14
    //   499: aload 11
    //   501: sipush 10000
    //   504: getstatic 616	cn/jpush/android/service/PushService:N	I
    //   507: iadd
    //   508: invokespecial 1486	java/net/DatagramPacket:<init>	([BILjava/net/InetAddress;I)V
    //   511: astore 16
    //   513: goto -302 -> 211
    //   516: astore_2
    //   517: aload_1
    //   518: ifnull +7 -> 525
    //   521: aload_1
    //   522: invokevirtual 1513	java/net/DatagramSocket:close	()V
    //   525: aload_2
    //   526: athrow
    //   527: aload 21
    //   529: invokevirtual 1512	org/json/JSONArray:length	()I
    //   532: ifle +31 -> 563
    //   535: aload 21
    //   537: iconst_0
    //   538: invokevirtual 1520	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   541: astore 31
    //   543: aload 31
    //   545: bipush 58
    //   547: invokevirtual 1522	java/lang/String:indexOf	(I)I
    //   550: istore 32
    //   552: iload 32
    //   554: iconst_m1
    //   555: if_icmpne +248 -> 803
    //   558: aload 31
    //   560: putstatic 600	cn/jpush/android/service/PushService:I	Ljava/lang/String;
    //   563: aload 21
    //   565: invokevirtual 1512	org/json/JSONArray:length	()I
    //   568: iconst_2
    //   569: if_icmplt +224 -> 793
    //   572: aload 21
    //   574: iconst_1
    //   575: invokevirtual 1520	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   578: astore 23
    //   580: aload 23
    //   582: invokestatic 965	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   585: ifne +151 -> 736
    //   588: aload 23
    //   590: bipush 58
    //   592: invokevirtual 1522	java/lang/String:indexOf	(I)I
    //   595: istore 26
    //   597: iload 26
    //   599: ifle +137 -> 736
    //   602: aload 23
    //   604: iconst_0
    //   605: iload 26
    //   607: invokevirtual 1431	java/lang/String:substring	(II)Ljava/lang/String;
    //   610: astore 27
    //   612: getstatic 594	cn/jpush/android/service/PushService:o	Ljava/lang/String;
    //   615: aload 27
    //   617: invokevirtual 980	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   620: ifne +48 -> 668
    //   623: aload 27
    //   625: putstatic 594	cn/jpush/android/service/PushService:o	Ljava/lang/String;
    //   628: new 658	java/lang/StringBuilder
    //   631: dup
    //   632: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   635: bipush 88
    //   637: aaload
    //   638: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   641: aload 27
    //   643: invokevirtual 663	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: pop
    //   650: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   653: aload_0
    //   654: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   657: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   660: bipush 97
    //   662: aaload
    //   663: aload 27
    //   665: invokestatic 1134	cn/jpush/android/util/ae:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   668: aload 23
    //   670: iload 26
    //   672: iconst_1
    //   673: iadd
    //   674: invokevirtual 1524	java/lang/String:substring	(I)Ljava/lang/String;
    //   677: invokestatic 1427	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   680: istore 28
    //   682: getstatic 596	cn/jpush/android/service/PushService:p	I
    //   685: iload 28
    //   687: if_icmpeq +49 -> 736
    //   690: iload 28
    //   692: putstatic 596	cn/jpush/android/service/PushService:p	I
    //   695: new 658	java/lang/StringBuilder
    //   698: dup
    //   699: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   702: bipush 95
    //   704: aaload
    //   705: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   708: iload 28
    //   710: invokevirtual 722	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: pop
    //   717: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   720: aload_0
    //   721: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   724: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   727: bipush 89
    //   729: aaload
    //   730: getstatic 596	cn/jpush/android/service/PushService:p	I
    //   733: invokestatic 983	cn/jpush/android/util/ae:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   736: aload 21
    //   738: invokevirtual 1512	org/json/JSONArray:length	()I
    //   741: iconst_3
    //   742: if_icmplt +51 -> 793
    //   745: aload 21
    //   747: iconst_2
    //   748: invokevirtual 1520	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   751: astore 24
    //   753: aload 24
    //   755: invokestatic 965	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   758: ifne +35 -> 793
    //   761: invokestatic 1528	cn/jpush/android/util/ac:a	()Ljava/lang/String;
    //   764: aload 24
    //   766: invokevirtual 1531	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   769: ifne +24 -> 793
    //   772: aload 24
    //   774: invokestatic 1533	cn/jpush/android/util/ac:a	(Ljava/lang/String;)Ljava/lang/String;
    //   777: pop
    //   778: aload_0
    //   779: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   782: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   785: bipush 90
    //   787: aaload
    //   788: aload 24
    //   790: invokestatic 1134	cn/jpush/android/util/ae:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   793: aload_0
    //   794: invokestatic 751	java/lang/System:currentTimeMillis	()J
    //   797: putfield 815	cn/jpush/android/service/PushService:ae	J
    //   800: goto -452 -> 348
    //   803: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   806: bipush 8
    //   808: aaload
    //   809: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   812: bipush 96
    //   814: aaload
    //   815: invokestatic 1535	cn/jpush/android/util/x:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   818: aload 31
    //   820: iconst_0
    //   821: iload 32
    //   823: invokevirtual 1431	java/lang/String:substring	(II)Ljava/lang/String;
    //   826: putstatic 600	cn/jpush/android/service/PushService:I	Ljava/lang/String;
    //   829: aload 31
    //   831: iload 32
    //   833: iconst_1
    //   834: iadd
    //   835: invokevirtual 1524	java/lang/String:substring	(I)Ljava/lang/String;
    //   838: invokestatic 1427	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   841: putstatic 606	cn/jpush/android/service/PushService:K	I
    //   844: goto -281 -> 563
    //   847: sipush 9000
    //   850: putstatic 616	cn/jpush/android/service/PushService:N	I
    //   853: aload 4
    //   855: ifnull -834 -> 21
    //   858: aload 4
    //   860: invokevirtual 1513	java/net/DatagramSocket:close	()V
    //   863: return
    //   864: astore 38
    //   866: aload 38
    //   868: astore_2
    //   869: aconst_null
    //   870: astore_1
    //   871: goto -354 -> 517
    //   874: astore 5
    //   876: aload 4
    //   878: astore_1
    //   879: aload 5
    //   881: astore_2
    //   882: goto -365 -> 517
    //   885: astore 37
    //   887: aconst_null
    //   888: astore 4
    //   890: goto -486 -> 404
    //   893: iload 13
    //   895: istore 14
    //   897: goto -738 -> 159
    //
    // Exception table:
    //   from	to	target	type
    //   121	131	357	java/net/UnknownHostException
    //   30	53	400	java/lang/Exception
    //   58	121	400	java/lang/Exception
    //   121	131	400	java/lang/Exception
    //   135	146	400	java/lang/Exception
    //   159	211	400	java/lang/Exception
    //   211	331	400	java/lang/Exception
    //   336	343	400	java/lang/Exception
    //   359	390	400	java/lang/Exception
    //   394	397	400	java/lang/Exception
    //   461	513	400	java/lang/Exception
    //   527	552	400	java/lang/Exception
    //   558	563	400	java/lang/Exception
    //   563	597	400	java/lang/Exception
    //   602	668	400	java/lang/Exception
    //   668	736	400	java/lang/Exception
    //   736	793	400	java/lang/Exception
    //   793	800	400	java/lang/Exception
    //   803	844	400	java/lang/Exception
    //   30	53	516	finally
    //   58	121	516	finally
    //   121	131	516	finally
    //   135	146	516	finally
    //   159	211	516	finally
    //   211	331	516	finally
    //   336	343	516	finally
    //   359	390	516	finally
    //   394	397	516	finally
    //   461	513	516	finally
    //   527	552	516	finally
    //   558	563	516	finally
    //   563	597	516	finally
    //   602	668	516	finally
    //   668	736	516	finally
    //   736	793	516	finally
    //   793	800	516	finally
    //   803	844	516	finally
    //   22	30	864	finally
    //   404	450	874	finally
    //   847	853	874	finally
    //   22	30	885	java/lang/Exception
  }

  protected final void e()
  {
    a(false, false, false);
  }

  protected final void e(int paramInt)
  {
    if (this.v == 0);
    int i1;
    label60: int i3;
    long l1;
    String str4;
    Object localObject1;
    Object localObject2;
    label504: 
    do
    {
      return;
      i1 = cn.jpush.android.util.a.b(this.w);
      new StringBuilder(bb[60]).append(i1).toString();
      x.e();
      if ((i1 != 3) && (i1 != 9))
        break;
      int i2;
      String str6;
      String str7;
      int i12;
      int i14;
      int i15;
      if (i1 == 9)
      {
        i2 = 1;
        new StringBuilder(bb[53]).append(paramInt).toString();
        x.c();
        i3 = aa.b(this.w, 20, 1);
        l1 = aa.c(this.w, 21, 8);
        new StringBuilder(bb[74]).append(i3).append(bb[73]).append(l1).toString();
        x.c();
        if (i2 == 0)
          break label572;
        int i7 = aa.b(this.w, 29, 2);
        str6 = aa.d(this.w, 31, i7);
        int i8 = i7 + 31;
        int i9 = aa.b(this.w, i8, 2);
        int i10 = i8 + 2;
        str7 = aa.d(this.w, i10, i9);
        int i11 = i10 + i9;
        i12 = aa.b(this.w, i11, 1);
        new StringBuilder(bb[67]).append(i12).toString();
        x.d();
        int i13 = i11 + 1;
        i14 = aa.b(this.w, i13, 2);
        i15 = i13 + 2;
        if (i12 != 1)
          break label504;
        str4 = aa.a(this.w, i15, i14);
        localObject1 = str7;
        localObject2 = str6;
      }
      while (true)
      {
        new StringBuilder(bb[75]).append((String)localObject2).append(bb[69]).append((String)localObject1).append(bb[66]).append(str4).toString();
        x.c();
        switch (i3)
        {
        case 1:
        case 7:
        case 8:
        case 10:
        case 11:
        case 12:
        case 13:
        case 16:
        case 17:
        case 18:
        case 19:
        default:
          new StringBuilder(bb[62]).append(i3).toString();
          x.c();
          return;
          i2 = 0;
          break label60;
          if (i12 == 0)
          {
            str4 = aa.d(this.w, i15, i14);
            localObject1 = str7;
            localObject2 = str6;
          }
          else
          {
            new StringBuilder(bb[61]).append(i12).toString();
            x.f();
            localObject1 = str7;
            localObject2 = str6;
            str4 = null;
            continue;
            int i4 = aa.b(this.w, 29, 2);
            String str1 = aa.d(this.w, 31, i4);
            LineNumberReader localLineNumberReader = new LineNumberReader(new StringReader(str1));
            String str2;
            try
            {
              str2 = localLineNumberReader.readLine();
              if (str2 == null)
              {
                x.f();
                return;
              }
            }
            catch (IOException localIOException)
            {
              x.j();
              return;
            }
            String str3 = localLineNumberReader.readLine();
            if (str3 == null)
            {
              x.f();
              return;
            }
            int i5 = 2 + (str2.length() + str3.length());
            if (str1.length() > i5 + 1)
            {
              str4 = str1.substring(i5);
              localObject1 = str3;
              localObject2 = str2;
            }
            else
            {
              x.c();
              str4 = "";
              localObject1 = str3;
              localObject2 = str2;
            }
          }
          break;
        case 0:
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 9:
        case 14:
        case 15:
        case 20:
        case 21:
        case 22:
        }
      }
    }
    while (paramInt <= 20);
    try
    {
      label572: new StringBuilder(bb[52]).append(l1).toString();
      x.c();
      if (ServiceInterface.j(getApplicationContext()))
      {
        x.d();
        return;
      }
    }
    catch (Exception localException)
    {
      x.j();
      return;
    }
    if (!cn.jpush.android.util.a.o(getApplicationContext()))
    {
      if (this.v != 0)
        PushProtocol.MsgResponse(this.v, 0, s, (byte)i3, l1);
      cn.jpush.android.data.a locala2 = cn.jpush.android.data.p.a(getApplicationContext(), str4, (String)localObject2, (String)localObject1, l1);
      if (locala2 == null);
      while (true)
      {
        x.d();
        return;
        ServiceInterface.a(locala2.c, 1030, cn.jpush.android.a.d);
      }
    }
    aj localaj;
    cn.jpush.android.data.a locala1;
    if (this.v == 0)
    {
      a(i3, l1);
      new StringBuilder(bb[58]).append(l1).toString();
      x.f();
      localaj = new aj(bb[8], bb[51]);
      if ((TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)))
        break label1485;
      if (TextUtils.isEmpty(str4))
        break label1479;
      new StringBuilder(bb[68]).append(l1).toString();
      x.c();
      locala1 = cn.jpush.android.data.p.a(getApplicationContext(), str4, (String)localObject2, (String)localObject1, l1);
      if (locala1 != null)
        break label1069;
    }
    label1005: e locale;
    while (true)
    {
      localaj.a();
      return;
      if (PushProtocol.MsgResponse(this.v, 0, s, (byte)i3, l1) != 0)
      {
        a(i3, l1);
        break;
      }
      new StringBuilder(bb[63]).append(l1).toString();
      x.b();
      break;
      label1069: locale = locala1.h();
      if (!aj.contains(locale))
        break label1117;
      new StringBuilder(bb[57]).append(locale).toString();
      x.f();
    }
    label1117: if (aj.size() >= 200)
      aj.poll();
    aj.offer(locale);
    int i6 = 0;
    if (((String)localObject1).equalsIgnoreCase(bb[54]))
      cn.jpush.android.data.p.a(getApplicationContext(), locala1);
    while (true)
    {
      String str5 = l1;
      new StringBuilder(bb[59]).append(i6).toString();
      x.c();
      if ((i6 & 0x1) != 0)
      {
        x.c();
        locala1.h = true;
        Intent localIntent = new Intent(bb[71]);
        localIntent.putExtra(bb[55], (String)localObject1);
        localIntent.putExtra(bb[77], (String)localObject2);
        localIntent.putExtra(bb[70], str4);
        localIntent.putExtra(bb[50], str5);
        localIntent.putExtra(bb[64], locala1.g);
        localIntent.addCategory((String)localObject2);
        sendOrderedBroadcast(localIntent, (String)localObject2 + bb[49]);
      }
      if ((i6 & 0x2) == 0)
        break label1005;
      x.c();
      if ((ai.a(locala1.i)) && (ai.a(locala1.l)))
        break label1005;
      locala1.m = ((String)localObject2);
      locala1.n = ((String)localObject1);
      if (!locala1.f())
      {
        cn.jpush.android.util.a.a(getApplicationContext(), locala1);
        break label1005;
        if (!locala1.e)
          break label1717;
        i6 = 1;
        if (locala1.b != 4)
          continue;
        i6 = 3;
        continue;
      }
      new Thread(new j(this, cn.jpush.android.data.a.a(locala1))).start();
      break label1005;
      label1479: x.f();
      break label1005;
      label1485: x.e();
      break label1005;
      o(str4);
      return;
      ServiceInterface.e(getApplicationContext());
      return;
      l(str4);
      return;
      k(str4);
      return;
      a(getApplicationContext(), P);
      return;
      a((String)localObject2, P);
      return;
      a(str4, 0);
      return;
      j(str4);
      return;
      JLogger.parseModalJson(str4, getApplicationContext());
      return;
      JRecorder.parseRecordCommand(str4);
      return;
      if (i1 == 6)
      {
        n(bb[40]);
        return;
      }
      if (i1 == 7)
      {
        i(bb[65]);
        return;
      }
      if (i1 == 11)
      {
        i(bb[56]);
        return;
      }
      if (i1 == 14)
      {
        n(bb[76]);
        return;
      }
      if (i1 == 16)
      {
        m(bb[40]);
        return;
      }
      if (i1 == 17)
      {
        m(bb[76]);
        return;
      }
      if (i1 == 10)
        break;
      if (i1 == 19)
      {
        v();
        return;
      }
      new StringBuilder(bb[72]).append(i1).toString();
      x.c();
      return;
      label1717: i6 = 2;
    }
  }

  protected final void f()
  {
    a(false, true, false);
  }

  protected final void f(int paramInt)
  {
    x.b(bb[8], bb['Ú']);
    a(0, bb[17]);
    if (paramInt == -991)
      return;
    if ((!ServiceInterface.j(getApplicationContext())) && (cn.jpush.android.util.a.b(getApplicationContext())))
      if (i != 86401)
        break label256;
    label256: for (int i1 = 1; ; i1 = 0)
    {
      if (i1 == 0)
      {
        int i2 = cn.jpush.android.util.a.h(getApplicationContext());
        if ((cn.jpush.android.util.a.g(getApplicationContext())) || (i2 > 0))
        {
          int i3 = (int)(1000.0D * (3.0D * Math.pow(2.0D, this.ac)));
          this.ac = (1 + this.ac);
          if (i3 > 500 * i)
            i3 = 500 * i;
          if (((this.ac <= 5) || (i2 == 1)) && (!this.an.hasMessages(1005)) && (!this.an.hasMessages(1004)))
          {
            new StringBuilder(bb['Û']).append(i3).toString();
            x.c();
            this.an.sendEmptyMessageDelayed(1005, i3);
          }
        }
      }
      this.ab = 0;
      this.af = (1 + this.af);
      if (!W)
        break;
      this.an.removeMessages(1002);
      return;
    }
  }

  protected final void g()
  {
    x.c();
    this.ac = 0;
    while (true)
    {
      String str1 = (String)this.x.poll();
      if (str1 == null)
        break;
      new StringBuilder(bb['']).append(str1).toString();
      x.c();
      if (str1.startsWith(bb[113]))
      {
        String[] arrayOfString6 = str1.split(",");
        String str2 = str1.substring(1 + str1.indexOf(",", 1 + str1.indexOf(",")));
        if (str2 != null)
        {
          int i8 = PushProtocol.RepPush(this.v, s, Integer.valueOf(arrayOfString6[1]).byteValue(), str2);
          if (i8 >= 0)
          {
            new StringBuilder(bb['']).append(str2).toString();
            x.b();
          }
          else
          {
            new StringBuilder(bb['']).append(i8).toString();
            x.b();
          }
        }
      }
      else if (str1.startsWith(bb[117]))
      {
        String[] arrayOfString5 = str1.split(bb[6]);
        if (arrayOfString5.length > 3)
        {
          try
          {
            int i7 = Integer.valueOf(arrayOfString5[3]).intValue();
            i5 = i7;
            i6 = a(this.v, s, arrayOfString5[1], arrayOfString5[2], i5);
            if (i6 >= 0)
              x.c(bb[8], bb[9] + arrayOfString5[2]);
          }
          catch (Exception localException2)
          {
            int i5;
            int i6;
            while (true)
              i5 = 0;
            a(arrayOfString5[2], P, i5);
            x.c(bb[8], bb[''] + i6);
          }
        }
        else
        {
          new StringBuilder(bb[122]).append(str1).toString();
          x.f();
        }
      }
      else if (str1.startsWith(bb[116]))
      {
        String[] arrayOfString4 = str1.split(",");
        if (arrayOfString4.length > 2)
        {
          int i4 = PushProtocol.EnChannel(this.v, s, arrayOfString4[1], arrayOfString4[2]);
          if (i4 >= 0)
          {
            new StringBuilder(bb[119]).append(arrayOfString4[1]).append(bb[126]).append(arrayOfString4[2]).toString();
            x.b();
          }
          else
          {
            new StringBuilder(bb[110]).append(i4).toString();
            x.b();
          }
        }
        else
        {
          new StringBuilder(bb['']).append(str1).toString();
          x.f();
        }
      }
      else if (str1.startsWith(bb[120]))
      {
        String[] arrayOfString3 = str1.split(",");
        if (arrayOfString3.length > 2)
        {
          int i3 = PushProtocol.UnChnelId(this.v, s, arrayOfString3[1], arrayOfString3[2]);
          if (i3 >= 0)
          {
            new StringBuilder(bb[118]).append(arrayOfString3[1]).append(bb[126]).append(arrayOfString3[2]).toString();
            x.b();
          }
          else
          {
            new StringBuilder(bb[121]).append(i3).toString();
            x.b();
          }
        }
        else
        {
          new StringBuilder(bb[112]).append(str1).toString();
          x.f();
        }
      }
      else if (str1.startsWith(bb[124]))
      {
        String[] arrayOfString2 = str1.split(bb[6]);
        if (arrayOfString2.length > 2)
        {
          int i2 = PushProtocol.PushTime(this.v, s, arrayOfString2[1], arrayOfString2[2]);
          if (i2 >= 0)
          {
            new StringBuilder(bb['']).append(arrayOfString2[1]).append(bb[126]).append(arrayOfString2[2]).toString();
            x.b();
          }
          else
          {
            new StringBuilder(bb['']).append(i2).toString();
            x.b();
          }
        }
        else
        {
          new StringBuilder(bb['']).append(str1).toString();
          x.f();
        }
      }
      else if (str1.startsWith(bb[125]))
      {
        String[] arrayOfString1 = str1.split(bb[6]);
        if (arrayOfString1.length >= 2)
        {
          long l1;
          try
          {
            int i1 = Integer.parseInt(arrayOfString1[0]);
            l1 = Long.parseLong(arrayOfString1[1]);
            new StringBuilder().append(i1).append(bb['']).append(l1).toString();
            x.f();
            if (PushProtocol.MsgResponse(this.v, 0, s, (byte)i1, l1) == 0)
              break label980;
            a(i1, l1);
          }
          catch (Exception localException1)
          {
            localException1.getMessage();
            x.f();
          }
          continue;
          label980: new StringBuilder(bb[63]).append(l1).toString();
          x.b();
        }
        else
        {
          new StringBuilder(bb[127]).append(str1).toString();
          x.f();
        }
      }
    }
    x();
    C();
    JSONObject localJSONObject;
    if (ae.a(getApplicationContext(), bb[114], bb[11]).equals(bb[115]))
      if (this.v != 0)
      {
        x.d();
        localJSONObject = new JSONObject();
      }
    try
    {
      localJSONObject.put(bb[123], getPackageName());
      localJSONObject.put(bb[''], P);
      label1122: if (ServiceInterface.j(getApplicationContext()))
        PushProtocol.RepPush(this.v, s, (byte)4, localJSONObject.toString());
      while (true)
      {
        q();
        if (G)
          ServiceInterface.e(getApplicationContext());
        if (W)
        {
          x.c();
          this.an.sendEmptyMessageDelayed(1002, 0L);
        }
        if (O <= 0)
        {
          O = 1 + O;
          ae.b(getApplicationContext(), bb[111], O);
        }
        return;
        PushProtocol.RepPush(this.v, s, (byte)5, localJSONObject.toString());
      }
    }
    catch (JSONException localJSONException)
    {
      break label1122;
    }
  }

  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  // ERROR //
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   4: invokestatic 1558	cn/jpush/android/service/ServiceInterface:j	(Landroid/content/Context;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   14: invokestatic 1719	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: invokevirtual 1720	java/lang/Thread:getId	()J
    //   20: putstatic 1722	cn/jpush/android/service/PushService:a	J
    //   23: aload_0
    //   24: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   27: invokestatic 1724	cn/jpush/android/a:a	(Landroid/content/Context;)Z
    //   30: ifeq -20 -> 10
    //   33: aload_0
    //   34: aload_0
    //   35: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   38: invokestatic 1726	cn/jpush/android/util/a:q	(Landroid/content/Context;)Z
    //   41: putfield 706	cn/jpush/android/service/PushService:U	Z
    //   44: aload_0
    //   45: getfield 706	cn/jpush/android/service/PushService:U	Z
    //   48: ifeq -38 -> 10
    //   51: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   54: getstatic 1140	cn/jpush/android/a:f	Ljava/lang/String;
    //   57: invokestatic 965	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   60: ifne +9 -> 69
    //   63: getstatic 1140	cn/jpush/android/a:f	Ljava/lang/String;
    //   66: putstatic 626	cn/jpush/android/service/PushService:P	Ljava/lang/String;
    //   69: aload_0
    //   70: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   73: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   76: iconst_1
    //   77: aaload
    //   78: ldc_w 632
    //   81: invokestatic 1358	cn/jpush/android/util/ae:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_1
    //   85: aload_1
    //   86: invokestatic 965	cn/jpush/android/util/ai:a	(Ljava/lang/String;)Z
    //   89: ifne +17 -> 106
    //   92: aload_1
    //   93: getstatic 626	cn/jpush/android/service/PushService:P	Ljava/lang/String;
    //   96: invokevirtual 980	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifne +7 -> 106
    //   102: aload_0
    //   103: invokespecial 1728	cn/jpush/android/service/PushService:s	()V
    //   106: aload_0
    //   107: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   110: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   113: iconst_1
    //   114: aaload
    //   115: getstatic 626	cn/jpush/android/service/PushService:P	Ljava/lang/String;
    //   118: invokestatic 1134	cn/jpush/android/util/ae:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_0
    //   122: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   125: invokestatic 1729	cn/jpush/android/util/ae:a	(Landroid/content/Context;)V
    //   128: aload_0
    //   129: iconst_0
    //   130: putfield 1731	cn/jpush/android/service/PushService:R	Z
    //   133: aload_0
    //   134: iconst_0
    //   135: putfield 1733	cn/jpush/android/service/PushService:S	Z
    //   138: getstatic 1576	cn/jpush/android/a:d	Landroid/content/Context;
    //   141: astore_2
    //   142: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   145: aconst_null
    //   146: astore_3
    //   147: aload_2
    //   148: invokestatic 1736	cn/jpush/android/data/r:b	(Landroid/content/Context;)Landroid/database/Cursor;
    //   151: astore 9
    //   153: aload 9
    //   155: astore_3
    //   156: aload_3
    //   157: ifnull +222 -> 379
    //   160: aload_3
    //   161: invokeinterface 1741 1 0
    //   166: ifle +213 -> 379
    //   169: new 658	java/lang/StringBuilder
    //   172: dup
    //   173: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   176: iconst_2
    //   177: aaload
    //   178: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   181: aload_3
    //   182: invokeinterface 1741 1 0
    //   187: invokevirtual 722	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: pop
    //   194: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   197: aload_3
    //   198: invokeinterface 1744 1 0
    //   203: pop
    //   204: aload_3
    //   205: invokeinterface 1747 1 0
    //   210: ifne +169 -> 379
    //   213: aload_3
    //   214: aload_3
    //   215: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   218: iconst_0
    //   219: aaload
    //   220: invokeinterface 1750 2 0
    //   225: invokeinterface 1753 2 0
    //   230: istore 12
    //   232: aload_3
    //   233: aload_3
    //   234: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   237: iconst_4
    //   238: aaload
    //   239: invokeinterface 1750 2 0
    //   244: invokeinterface 1755 2 0
    //   249: astore 13
    //   251: aload_0
    //   252: getfield 697	cn/jpush/android/service/PushService:x	Ljava/util/Queue;
    //   255: aload 13
    //   257: invokeinterface 835 2 0
    //   262: ifeq +37 -> 299
    //   265: new 658	java/lang/StringBuilder
    //   268: dup
    //   269: getstatic 544	cn/jpush/android/service/PushService:bb	[Ljava/lang/String;
    //   272: iconst_3
    //   273: aaload
    //   274: invokespecial 677	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: aload 13
    //   279: invokevirtual 663	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 668	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: pop
    //   286: invokestatic 769	cn/jpush/android/util/x:d	()V
    //   289: aload_0
    //   290: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   293: iload 12
    //   295: invokestatic 1758	cn/jpush/android/data/r:b	(Landroid/content/Context;I)Z
    //   298: pop
    //   299: aload_3
    //   300: invokeinterface 1761 1 0
    //   305: pop
    //   306: goto -102 -> 204
    //   309: astore 7
    //   311: invokestatic 1401	cn/jpush/android/util/x:j	()V
    //   314: aload_3
    //   315: ifnull +9 -> 324
    //   318: aload_3
    //   319: invokeinterface 1762 1 0
    //   324: aload_0
    //   325: getfield 1731	cn/jpush/android/service/PushService:R	Z
    //   328: ifeq +88 -> 416
    //   331: aload_0
    //   332: iconst_1
    //   333: putfield 704	cn/jpush/android/service/PushService:T	Z
    //   336: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   339: aload_0
    //   340: iconst_1
    //   341: putfield 704	cn/jpush/android/service/PushService:T	Z
    //   344: invokestatic 726	cn/jpush/android/util/x:c	()V
    //   347: aload_0
    //   348: getfield 704	cn/jpush/android/service/PushService:T	Z
    //   351: ifeq -341 -> 10
    //   354: getstatic 638	cn/jpush/android/service/PushService:W	Z
    //   357: ifeq +13 -> 370
    //   360: aload_0
    //   361: invokevirtual 917	cn/jpush/android/service/PushService:getApplicationContext	()Landroid/content/Context;
    //   364: invokestatic 1677	cn/jpush/android/util/a:b	(Landroid/content/Context;)Z
    //   367: ifeq +7 -> 374
    //   370: aload_0
    //   371: invokespecial 913	cn/jpush/android/service/PushService:y	()V
    //   374: aload_0
    //   375: invokespecial 931	cn/jpush/android/service/PushService:A	()V
    //   378: return
    //   379: aload_3
    //   380: ifnull -56 -> 324
    //   383: aload_3
    //   384: invokeinterface 1762 1 0
    //   389: goto -65 -> 324
    //   392: astore 4
    //   394: aconst_null
    //   395: astore 5
    //   397: aload 4
    //   399: astore 6
    //   401: aload 5
    //   403: ifnull +10 -> 413
    //   406: aload 5
    //   408: invokeinterface 1762 1 0
    //   413: aload 6
    //   415: athrow
    //   416: aload_0
    //   417: getfield 1733	cn/jpush/android/service/PushService:S	Z
    //   420: ifne -84 -> 336
    //   423: aload_0
    //   424: iconst_1
    //   425: putfield 704	cn/jpush/android/service/PushService:T	Z
    //   428: goto -92 -> 336
    //   431: astore 8
    //   433: aload_3
    //   434: astore 5
    //   436: aload 8
    //   438: astore 6
    //   440: goto -39 -> 401
    //
    // Exception table:
    //   from	to	target	type
    //   147	153	309	java/lang/Exception
    //   160	204	309	java/lang/Exception
    //   204	299	309	java/lang/Exception
    //   299	306	309	java/lang/Exception
    //   147	153	392	finally
    //   160	204	431	finally
    //   204	299	431	finally
    //   299	306	431	finally
    //   311	314	431	finally
  }

  public void onDestroy()
  {
    new StringBuilder(bb[78]).append(Process.myPid()).toString();
    x.c();
    z();
    super.onDestroy();
    w();
    this.an.removeCallbacksAndMessages(null);
    cn.jpush.android.util.a.r(getApplicationContext());
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    new StringBuilder(bb['Ó']).append(paramInt2).append(bb['Ñ']).append(paramIntent).toString();
    x.b();
    if (!this.U)
    {
      this.an.sendEmptyMessageDelayed(1003, 100L);
      return 1;
    }
    if ((W) && (!cn.jpush.android.util.a.b(getApplicationContext())))
    {
      x.b();
      this.an.sendEmptyMessageDelayed(1003, 100L);
      return 1;
    }
    Bundle localBundle;
    String str1;
    if (paramIntent != null)
    {
      String str12 = paramIntent.getAction();
      localBundle = paramIntent.getExtras();
      str1 = str12;
      if ((str1 != null) && (localBundle != null))
      {
        if (!bb['Ì'].equals(str1))
          break label560;
        String str11 = localBundle.getString(bb[1]);
        localBundle.getString(bb['Å']);
        if (str11 != null)
          P = str11;
        if ((this.v != 0) && (this.Q != null) && (this.Q.isAlive()))
          break label541;
        new StringBuilder(bb['Ò']).append(this.v).toString();
        x.c();
        y();
      }
    }
    while (true)
      while (true)
      {
        label233: x.b();
        int i1;
        if (localBundle != null)
        {
          new StringBuilder(bb['À']).append(localBundle.toString()).toString();
          x.b();
          String str2 = localBundle.getString(bb['']);
          i1 = localBundle.getInt(bb['Ô'], 0);
          if (str2 != null)
          {
            if (i1 != 0)
              break label1646;
            this.an.removeMessages(1005);
            if (!this.an.hasMessages(1004))
              this.an.sendEmptyMessage(1005);
          }
          String str3 = localBundle.getString(bb['ª']);
          if (str3 != null)
          {
            new StringBuilder(bb['»']).append(str3).toString();
            x.b();
            a(this, str3, localBundle.getBoolean(bb['¢'], false), localBundle.getBoolean(bb['§'], false)).f();
          }
        }
        boolean bool1 = ae.a(getApplicationContext(), bb[114], bb[11]).equals(bb[115]);
        if ((W) || (!this.T) || (bool1))
          q();
        if ((str1 == null) || (localBundle != null) || (!bb['Â'].equals(str1)))
          break;
        A();
        this.an.removeMessages(1005);
        this.an.removeMessages(1004);
        this.an.sendEmptyMessageDelayed(1004, 500L);
        return 1;
        label541: x.b(bb[8], bb['º']);
        continue;
        label560: if (bb[65].equals(str1))
        {
          if (this.T)
          {
            b(localBundle.getString(bb['Å']), P);
          }
          else if ((ServiceInterface.i(this) == 2) && (ServiceInterface.h(this)))
          {
            x.c();
            b(localBundle.getString(bb['Å']), P);
          }
          else
          {
            x.c();
          }
        }
        else if (bb['Ã'].equals(str1))
        {
          String str10 = localBundle.getString(bb[113]);
          if (str10 != null)
            if (this.T)
            {
              new StringBuilder(bb['Î']).append(str10).toString();
              x.d();
              if (this.v == 0)
              {
                g(Integer.toString(3), str10);
              }
              else if (PushProtocol.RepPush(this.v, s, (byte)3, str10) < 0)
              {
                g(Integer.toString(3), str10);
              }
              else
              {
                new StringBuilder(bb['']).append(str10).toString();
                x.b();
              }
            }
            else
            {
              x.c();
            }
        }
        else if (bb['Ð'].equals(str1))
        {
          if (localBundle.getInt(bb['Ë'], -1) != -1)
            x.c();
        }
        else
        {
          String str7;
          String str8;
          int i2;
          JSONObject localJSONObject2;
          if (bb['Ç'].equals(str1))
          {
            str7 = localBundle.getString(bb['¬']);
            str8 = localBundle.getString(bb['­']);
            i2 = localBundle.getInt(bb['½'], 0);
            if ((str7 != null) || (str8 != null))
            {
              localJSONObject2 = new JSONObject();
              if (str7 == null);
            }
          }
          else
          {
            try
            {
              while (true)
              {
                localJSONObject2.put(bb['¬'], str7);
                if (str8 != null)
                  localJSONObject2.put(bb['­'], str8);
                String str9 = localJSONObject2.toString();
                if (localJSONObject2.length() <= 0)
                  break label233;
                if (this.T)
                {
                  a(str9, i2);
                  break label233;
                }
                new StringBuilder(bb['Á']).append(str1).toString();
                x.c();
                break label233;
                if (bb[56].equals(str1))
                {
                  if (this.T)
                  {
                    a(localBundle.getString(bb['Å']), P);
                    break label233;
                  }
                  new StringBuilder(bb['Á']).append(str1).toString();
                  x.c();
                  break label233;
                }
                String str4;
                String str5;
                label1245: JSONObject localJSONObject1;
                if (bb['¼'].equals(str1))
                  if (this.T)
                  {
                    boolean bool2 = localBundle.getBoolean(bb['Í'], true);
                    str4 = localBundle.getString(bb['É']);
                    if (bool2);
                    for (str5 = "0"; ; str5 = "1")
                    {
                      if ((!ae.a(getApplicationContext(), bb['Í'], "0").equals(str5)) || (!str4.equals(ae.a(getApplicationContext(), bb['É'], ""))))
                        break label1245;
                      x.b(bb[8], bb['È'] + str4);
                      break;
                    }
                    localJSONObject1 = new JSONObject();
                  }
                try
                {
                  while (true)
                  {
                    localJSONObject1.put(bb['Í'], str5);
                    if (!ai.a(str4))
                      localJSONObject1.put(bb['É'], str4.replaceAll(bb['Ï'], bb['¿']));
                    String str6 = localJSONObject1.toString();
                    try
                    {
                      ae.b(getApplicationContext(), bb['Í'], localJSONObject1.getString(bb['Í']));
                      ae.b(getApplicationContext(), bb['É'], str4);
                      if ((this.v == 0) || (s == 0L))
                      {
                        x.c();
                        this.x.offer(bb['Ê'] + P + bb[29] + str6);
                        y();
                      }
                    }
                    catch (Exception localException)
                    {
                      while (true)
                        x.j();
                      if (PushProtocol.PushTime(this.v, s, P, str6) < 0)
                      {
                        this.x.offer(bb['Ê'] + P + bb[29] + str6);
                        y();
                        break;
                      }
                      x.c(bb[8], bb['Æ'] + str6);
                    }
                  }
                  break label233;
                  new StringBuilder(bb['Á']).append(str1).toString();
                  x.c();
                  break label233;
                  if (bb['Ä'].equals(str1))
                  {
                    w();
                    break label233;
                  }
                  if (bb['¾'].equals(str1))
                  {
                    x.b();
                    if (this.ai)
                      break;
                    new Thread(new k(this)).start();
                    return 1;
                  }
                  x.b();
                  break label233;
                  label1646: g(i1);
                }
                catch (JSONException localJSONException1)
                {
                }
              }
              continue;
              str1 = null;
              localBundle = null;
            }
            catch (JSONException localJSONException2)
            {
            }
          }
        }
      }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     cn.jpush.android.service.PushService
 * JD-Core Version:    0.6.2
 */