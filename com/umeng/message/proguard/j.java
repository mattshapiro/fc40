package com.umeng.message.proguard;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class j
{
  private static k.a A;
  private static p.g B;
  private static k.a C;
  private static p.g D;
  private static k.a E;
  private static p.g F;
  private static k.a G;
  private static p.g H;
  private static k.a I;
  private static p.g J;
  private static k.a K;
  private static p.g L;
  private static k.a M;
  private static p.g N;
  private static k.g O;
  private static k.a a;
  private static p.g b;
  private static k.a c;
  private static p.g d;
  private static k.a e;
  private static p.g f;
  private static k.a g;
  private static p.g h;
  private static k.a i;
  private static p.g j;
  private static k.a k;
  private static p.g l;
  private static k.a m;
  private static p.g n;
  private static k.a o;
  private static p.g p;
  private static k.a q;
  private static p.g r;
  private static k.a s;
  private static p.g t;
  private static k.a u;
  private static p.g v;
  private static k.a w;
  private static p.g x;
  private static k.a y;
  private static p.g z;

  static
  {
    String[] arrayOfString = { "\n google/protobuf/descriptor.proto\022\017google.protobuf\"G\n\021FileDescriptorSet\0222\n\004file\030\001 \003(\0132$.google.protobuf.FileDescriptorProto\"Ë\003\n\023FileDescriptorProto\022\f\n\004name\030\001 \001(\t\022\017\n\007package\030\002 \001(\t\022\022\n\ndependency\030\003 \003(\t\022\031\n\021public_dependency\030\n \003(\005\022\027\n\017weak_dependency\030\013 \003(\005\0226\n\fmessage_type\030\004 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type\030\005 \003(\0132$.google.protobuf.EnumDescriptorProto\0228\n\007service\030\006 \003(\0132'.google.protobuf.", "ServiceDescriptorProto\0228\n\textension\030\007 \003(\0132%.google.protobuf.FieldDescriptorProto\022-\n\007options\030\b \001(\0132\034.google.protobuf.FileOptions\0229\n\020source_code_info\030\t \001(\0132\037.google.protobuf.SourceCodeInfo\"©\003\n\017DescriptorProto\022\f\n\004name\030\001 \001(\t\0224\n\005field\030\002 \003(\0132%.google.protobuf.FieldDescriptorProto\0228\n\textension\030\006 \003(\0132%.google.protobuf.FieldDescriptorProto\0225\n\013nested_type\030\003 \003(\0132 .google.protobuf.DescriptorProto\0227\n\tenum_type", "\030\004 \003(\0132$.google.protobuf.EnumDescriptorProto\022H\n\017extension_range\030\005 \003(\0132/.google.protobuf.DescriptorProto.ExtensionRange\0220\n\007options\030\007 \001(\0132\037.google.protobuf.MessageOptions\032,\n\016ExtensionRange\022\r\n\005start\030\001 \001(\005\022\013\n\003end\030\002 \001(\005\"\005\n\024FieldDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\003 \001(\005\022:\n\005label\030\004 \001(\0162+.google.protobuf.FieldDescriptorProto.Label\0228\n\004type\030\005 \001(\0162*.google.protobuf.FieldDescriptorProto.Type\022\021\n\ttype_name", "\030\006 \001(\t\022\020\n\bextendee\030\002 \001(\t\022\025\n\rdefault_value\030\007 \001(\t\022.\n\007options\030\b \001(\0132\035.google.protobuf.FieldOptions\"¶\002\n\004Type\022\017\n\013TYPE_DOUBLE\020\001\022\016\n\nTYPE_FLOAT\020\002\022\016\n\nTYPE_INT64\020\003\022\017\n\013TYPE_UINT64\020\004\022\016\n\nTYPE_INT32\020\005\022\020\n\fTYPE_FIXED64\020\006\022\020\n\fTYPE_FIXED32\020\007\022\r\n\tTYPE_BOOL\020\b\022\017\n\013TYPE_STRING\020\t\022\016\n\nTYPE_GROUP\020\n\022\020\n\fTYPE_MESSAGE\020\013\022\016\n\nTYPE_BYTES\020\f\022\017\n\013TYPE_UINT32\020\r\022\r\n\tTYPE_ENUM\020\016\022\021\n\rTYPE_SFIXED32\020\017\022\021\n\rTYPE_SFIXED64\020\020\022\017\n\013TYPE_SINT32\020\021\022\017\n\013TYPE_", "SINT64\020\022\"C\n\005Label\022\022\n\016LABEL_OPTIONAL\020\001\022\022\n\016LABEL_REQUIRED\020\002\022\022\n\016LABEL_REPEATED\020\003\"\001\n\023EnumDescriptorProto\022\f\n\004name\030\001 \001(\t\0228\n\005value\030\002 \003(\0132).google.protobuf.EnumValueDescriptorProto\022-\n\007options\030\003 \001(\0132\034.google.protobuf.EnumOptions\"l\n\030EnumValueDescriptorProto\022\f\n\004name\030\001 \001(\t\022\016\n\006number\030\002 \001(\005\0222\n\007options\030\003 \001(\0132!.google.protobuf.EnumValueOptions\"\001\n\026ServiceDescriptorProto\022\f\n\004name\030\001 \001(\t\0226\n\006method\030\002 \003(\0132&.google.pro", "tobuf.MethodDescriptorProto\0220\n\007options\030\003 \001(\0132\037.google.protobuf.ServiceOptions\"\n\025MethodDescriptorProto\022\f\n\004name\030\001 \001(\t\022\022\n\ninput_type\030\002 \001(\t\022\023\n\013output_type\030\003 \001(\t\022/\n\007options\030\004 \001(\0132\036.google.protobuf.MethodOptions\"é\003\n\013FileOptions\022\024\n\fjava_package\030\001 \001(\t\022\034\n\024java_outer_classname\030\b \001(\t\022\"\n\023java_multiple_files\030\n \001(\b:\005false\022,\n\035java_generate_equals_and_hash\030\024 \001(\b:\005false\022F\n\foptimize_for\030\t \001(\0162).google.protobuf.Fil", "eOptions.OptimizeMode:\005SPEED\022\022\n\ngo_package\030\013 \001(\t\022\"\n\023cc_generic_services\030\020 \001(\b:\005false\022$\n\025java_generic_services\030\021 \001(\b:\005false\022\"\n\023py_generic_services\030\022 \001(\b:\005false\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\022\t\n\005SPEED\020\001\022\r\n\tCODE_SIZE\020\002\022\020\n\fLITE_RUNTIME\020\003*\t\bè\007\020\002\"¸\001\n\016MessageOptions\022&\n\027message_set_wire_format\030\001 \001(\b:\005false\022.\n\037no_standard_descriptor_accessor\030\002 \001(\b:\005", "", "\020\002\"x\n\013EnumOptions\022\031\n\013allow_alias\030\002 \001(\b:\004true\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"b\n\020EnumValueOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"`\n\016ServiceOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.UninterpretedOption*\t\bè\007\020\002\"_\n\rMethodOptions\022C\n\024uninterpreted_option\030ç\007 \003(\0132$.google.protobuf.Uninter", "pretedOption*\t\bè\007\020\002\"\002\n\023UninterpretedOption\022;\n\004name\030\002 \003(\0132-.google.protobuf.UninterpretedOption.NamePart\022\030\n\020identifier_value\030\003 \001(\t\022\032\n\022positive_int_value\030\004 \001(\004\022\032\n\022negative_int_value\030\005 \001(\003\022\024\n\fdouble_value\030\006 \001(\001\022\024\n\fstring_value\030\007 \001(\f\022\027\n\017aggregate_value\030\b \001(\t\0323\n\bNamePart\022\021\n\tname_part\030\001 \002(\t\022\024\n\fis_extension\030\002 \002(\b\"±\001\n\016SourceCodeInfo\022:\n\blocation\030\001 \003(\0132(.google.protobuf.SourceCodeInfo.Location\032c\n\bLocat", "ion\022\020\n\004path\030\001 \003(\005B\002\020\001\022\020\n\004span\030\002 \003(\005B\002\020\001\022\030\n\020leading_comments\030\003 \001(\t\022\031\n\021trailing_comments\030\004 \001(\tB)\n\023com.google.protobufB\020DescriptorProtosH\001" };
    k.g.a local1 = new k.g.a()
    {
      public m a(k.g paramAnonymousg)
      {
        j.a(paramAnonymousg);
        j.a((k.a)j.a().e().get(0));
        j.a(new p.g(j.b(), new String[] { "File" }));
        j.b((k.a)j.a().e().get(1));
        j.b(new p.g(j.d(), new String[] { "Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo" }));
        j.c((k.a)j.a().e().get(2));
        j.c(new p.g(j.f(), new String[] { "Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options" }));
        j.d((k.a)j.f().j().get(0));
        j.d(new p.g(j.h(), new String[] { "Start", "End" }));
        j.e((k.a)j.a().e().get(3));
        j.e(new p.g(j.j(), new String[] { "Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options" }));
        j.f((k.a)j.a().e().get(4));
        j.f(new p.g(j.l(), new String[] { "Name", "Value", "Options" }));
        j.g((k.a)j.a().e().get(5));
        j.g(new p.g(j.n(), new String[] { "Name", "Number", "Options" }));
        j.h((k.a)j.a().e().get(6));
        j.h(new p.g(j.p(), new String[] { "Name", "Method", "Options" }));
        j.i((k.a)j.a().e().get(7));
        j.i(new p.g(j.r(), new String[] { "Name", "InputType", "OutputType", "Options" }));
        j.j((k.a)j.a().e().get(8));
        j.j(new p.g(j.t(), new String[] { "JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption" }));
        j.k((k.a)j.a().e().get(9));
        j.k(new p.g(j.v(), new String[] { "MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption" }));
        j.l((k.a)j.a().e().get(10));
        j.l(new p.g(j.x(), new String[] { "Ctype", "Packed", "Lazy", "Deprecated", "ExperimentalMapKey", "Weak", "UninterpretedOption" }));
        j.m((k.a)j.a().e().get(11));
        j.m(new p.g(j.z(), new String[] { "AllowAlias", "UninterpretedOption" }));
        j.n((k.a)j.a().e().get(12));
        j.n(new p.g(j.B(), new String[] { "UninterpretedOption" }));
        j.o((k.a)j.a().e().get(13));
        j.o(new p.g(j.D(), new String[] { "UninterpretedOption" }));
        j.p((k.a)j.a().e().get(14));
        j.p(new p.g(j.F(), new String[] { "UninterpretedOption" }));
        j.q((k.a)j.a().e().get(15));
        j.q(new p.g(j.H(), new String[] { "Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue" }));
        j.r((k.a)j.H().j().get(0));
        j.r(new p.g(j.J(), new String[] { "NamePart", "IsExtension" }));
        j.s((k.a)j.a().e().get(16));
        j.s(new p.g(j.L(), new String[] { "Location" }));
        j.t((k.a)j.L().j().get(0));
        j.t(new p.g(j.N(), new String[] { "Path", "Span", "LeadingComments", "TrailingComments" }));
        return null;
      }
    };
    k.g.a(arrayOfString, new k.g[0], local1);
  }

  public static k.g a()
  {
    return O;
  }

  public static void a(m paramm)
  {
  }

  public static final class A extends p
    implements j.B
  {
    public static B<A> a = new c()
    {
      public j.A c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.A(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final A e = new A(true);
    private static final long n;
    private final P f;
    private int g;
    private Object h;
    private List<j.w> i;
    private j.C j;
    private byte k = -1;
    private int l = -1;

    static
    {
      e.z();
    }

    // ERROR //
    private A(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 56	com/umeng/message/proguard/p:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 58	com/umeng/message/proguard/j$A:k	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 60	com/umeng/message/proguard/j$A:l	I
      //   16: aload_0
      //   17: invokespecial 50	com/umeng/message/proguard/j$A:z	()V
      //   20: invokestatic 65	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +306 -> 335
      //   32: aload_1
      //   33: invokevirtual 70	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+44->84, 0:+397->437, 10:+67->107, 18:+95->135, 26:+152->192
      //   85: aload_1
      //   86: aload 4
      //   88: aload_2
      //   89: iload 9
      //   91: invokevirtual 73	com/umeng/message/proguard/j$A:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   94: ifne +326 -> 420
      //   97: iconst_1
      //   98: istore 12
      //   100: iload 5
      //   102: istore 13
      //   104: goto +323 -> 427
      //   107: aload_0
      //   108: iconst_1
      //   109: aload_0
      //   110: getfield 75	com/umeng/message/proguard/j$A:g	I
      //   113: ior
      //   114: putfield 75	com/umeng/message/proguard/j$A:g	I
      //   117: aload_0
      //   118: aload_1
      //   119: invokevirtual 78	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   122: putfield 80	com/umeng/message/proguard/j$A:h	Ljava/lang/Object;
      //   125: iload_3
      //   126: istore 12
      //   128: iload 5
      //   130: istore 13
      //   132: goto +295 -> 427
      //   135: iload 5
      //   137: iconst_2
      //   138: iand
      //   139: iconst_2
      //   140: if_icmpeq +273 -> 413
      //   143: aload_0
      //   144: new 82	java/util/ArrayList
      //   147: dup
      //   148: invokespecial 83	java/util/ArrayList:<init>	()V
      //   151: putfield 85	com/umeng/message/proguard/j$A:i	Ljava/util/List;
      //   154: iload 5
      //   156: iconst_2
      //   157: ior
      //   158: istore 14
      //   160: aload_0
      //   161: getfield 85	com/umeng/message/proguard/j$A:i	Ljava/util/List;
      //   164: aload_1
      //   165: getstatic 88	com/umeng/message/proguard/j$w:a	Lcom/umeng/message/proguard/B;
      //   168: aload_2
      //   169: invokevirtual 91	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   172: invokeinterface 97 2 0
      //   177: pop
      //   178: iload_3
      //   179: istore 19
      //   181: iload 14
      //   183: istore 13
      //   185: iload 19
      //   187: istore 12
      //   189: goto +238 -> 427
      //   192: iconst_2
      //   193: aload_0
      //   194: getfield 75	com/umeng/message/proguard/j$A:g	I
      //   197: iand
      //   198: iconst_2
      //   199: if_icmpne +208 -> 407
      //   202: aload_0
      //   203: getfield 99	com/umeng/message/proguard/j$A:j	Lcom/umeng/message/proguard/j$C;
      //   206: invokevirtual 105	com/umeng/message/proguard/j$C:s	()Lcom/umeng/message/proguard/j$C$a;
      //   209: astore 10
      //   211: aload_0
      //   212: aload_1
      //   213: getstatic 106	com/umeng/message/proguard/j$C:a	Lcom/umeng/message/proguard/B;
      //   216: aload_2
      //   217: invokevirtual 91	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   220: checkcast 101	com/umeng/message/proguard/j$C
      //   223: putfield 99	com/umeng/message/proguard/j$A:j	Lcom/umeng/message/proguard/j$C;
      //   226: aload 10
      //   228: ifnull +22 -> 250
      //   231: aload 10
      //   233: aload_0
      //   234: getfield 99	com/umeng/message/proguard/j$A:j	Lcom/umeng/message/proguard/j$C;
      //   237: invokevirtual 111	com/umeng/message/proguard/j$C$a:a	(Lcom/umeng/message/proguard/j$C;)Lcom/umeng/message/proguard/j$C$a;
      //   240: pop
      //   241: aload_0
      //   242: aload 10
      //   244: invokevirtual 115	com/umeng/message/proguard/j$C$a:t	()Lcom/umeng/message/proguard/j$C;
      //   247: putfield 99	com/umeng/message/proguard/j$A:j	Lcom/umeng/message/proguard/j$C;
      //   250: aload_0
      //   251: iconst_2
      //   252: aload_0
      //   253: getfield 75	com/umeng/message/proguard/j$A:g	I
      //   256: ior
      //   257: putfield 75	com/umeng/message/proguard/j$A:g	I
      //   260: iload_3
      //   261: istore 12
      //   263: iload 5
      //   265: istore 13
      //   267: goto +160 -> 427
      //   270: astore 8
      //   272: aload 8
      //   274: aload_0
      //   275: invokevirtual 118	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   278: athrow
      //   279: astore 7
      //   281: iload 5
      //   283: iconst_2
      //   284: iand
      //   285: iconst_2
      //   286: if_icmpne +14 -> 300
      //   289: aload_0
      //   290: aload_0
      //   291: getfield 85	com/umeng/message/proguard/j$A:i	Ljava/util/List;
      //   294: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   297: putfield 85	com/umeng/message/proguard/j$A:i	Ljava/util/List;
      //   300: aload_0
      //   301: aload 4
      //   303: invokevirtual 129	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   306: putfield 131	com/umeng/message/proguard/j$A:f	Lcom/umeng/message/proguard/P;
      //   309: aload_0
      //   310: invokevirtual 134	com/umeng/message/proguard/j$A:ad	()V
      //   313: aload 7
      //   315: athrow
      //   316: astore 6
      //   318: new 53	com/umeng/message/proguard/s
      //   321: dup
      //   322: aload 6
      //   324: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
      //   327: invokespecial 141	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   330: aload_0
      //   331: invokevirtual 118	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   334: athrow
      //   335: iload 5
      //   337: iconst_2
      //   338: iand
      //   339: iconst_2
      //   340: if_icmpne +14 -> 354
      //   343: aload_0
      //   344: aload_0
      //   345: getfield 85	com/umeng/message/proguard/j$A:i	Ljava/util/List;
      //   348: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   351: putfield 85	com/umeng/message/proguard/j$A:i	Ljava/util/List;
      //   354: aload_0
      //   355: aload 4
      //   357: invokevirtual 129	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   360: putfield 131	com/umeng/message/proguard/j$A:f	Lcom/umeng/message/proguard/P;
      //   363: aload_0
      //   364: invokevirtual 134	com/umeng/message/proguard/j$A:ad	()V
      //   367: return
      //   368: astore 17
      //   370: iload 14
      //   372: istore 5
      //   374: aload 17
      //   376: astore 7
      //   378: goto -97 -> 281
      //   381: astore 16
      //   383: iload 14
      //   385: istore 5
      //   387: aload 16
      //   389: astore 6
      //   391: goto -73 -> 318
      //   394: astore 15
      //   396: iload 14
      //   398: istore 5
      //   400: aload 15
      //   402: astore 8
      //   404: goto -132 -> 272
      //   407: aconst_null
      //   408: astore 10
      //   410: goto -199 -> 211
      //   413: iload 5
      //   415: istore 14
      //   417: goto -257 -> 160
      //   420: iload_3
      //   421: istore 12
      //   423: iload 5
      //   425: istore 13
      //   427: iload 13
      //   429: istore 5
      //   431: iload 12
      //   433: istore_3
      //   434: goto -406 -> 28
      //   437: iconst_1
      //   438: istore 12
      //   440: iload 5
      //   442: istore 13
      //   444: goto -17 -> 427
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	270	com/umeng/message/proguard/s
      //   84	97	270	com/umeng/message/proguard/s
      //   107	125	270	com/umeng/message/proguard/s
      //   143	154	270	com/umeng/message/proguard/s
      //   192	211	270	com/umeng/message/proguard/s
      //   211	226	270	com/umeng/message/proguard/s
      //   231	250	270	com/umeng/message/proguard/s
      //   250	260	270	com/umeng/message/proguard/s
      //   32	38	279	finally
      //   84	97	279	finally
      //   107	125	279	finally
      //   143	154	279	finally
      //   192	211	279	finally
      //   211	226	279	finally
      //   231	250	279	finally
      //   250	260	279	finally
      //   272	279	279	finally
      //   318	335	279	finally
      //   32	38	316	java/io/IOException
      //   84	97	316	java/io/IOException
      //   107	125	316	java/io/IOException
      //   143	154	316	java/io/IOException
      //   192	211	316	java/io/IOException
      //   211	226	316	java/io/IOException
      //   231	250	316	java/io/IOException
      //   250	260	316	java/io/IOException
      //   160	178	368	finally
      //   160	178	381	java/io/IOException
      //   160	178	394	com/umeng/message/proguard/s
    }

    private A(p.a<?> parama)
    {
      super();
      this.f = parama.b_();
    }

    private A(boolean paramBoolean)
    {
      this.f = P.c();
    }

    public static a a(A paramA)
    {
      return w().a(paramA);
    }

    public static A a(g paramg)
      throws s
    {
      return (A)a.d(paramg);
    }

    public static A a(g paramg, n paramn)
      throws s
    {
      return (A)a.d(paramg, paramn);
    }

    public static A a(h paramh)
      throws IOException
    {
      return (A)a.d(paramh);
    }

    public static A a(h paramh, n paramn)
      throws IOException
    {
      return (A)a.b(paramh, paramn);
    }

    public static A a(InputStream paramInputStream)
      throws IOException
    {
      return (A)a.h(paramInputStream);
    }

    public static A a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (A)a.h(paramInputStream, paramn);
    }

    public static A a(byte[] paramArrayOfByte)
      throws s
    {
      return (A)a.d(paramArrayOfByte);
    }

    public static A a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (A)a.d(paramArrayOfByte, paramn);
    }

    public static A b(InputStream paramInputStream)
      throws IOException
    {
      return (A)a.f(paramInputStream);
    }

    public static A b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (A)a.f(paramInputStream, paramn);
    }

    public static A h()
    {
      return e;
    }

    public static final k.a k()
    {
      return j.p();
    }

    public static a w()
    {
      return a.G();
    }

    private void z()
    {
      this.h = "";
      this.i = Collections.emptyList();
      this.j = j.C.h();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public j.w a(int paramInt)
    {
      return (j.w)this.i.get(paramInt);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      if ((0x1 & this.g) == 1)
        parami.a(1, p());
      for (int m = 0; m < this.i.size(); m++)
        parami.c(2, (y)this.i.get(m));
      if ((0x2 & this.g) == 2)
        parami.c(3, this.j);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.k;
      if (m != -1)
        return m == 1;
      for (int i1 = 0; i1 < s(); i1++)
        if (!a(i1).a())
        {
          this.k = 0;
          return false;
        }
      if ((t()) && (!u().a()))
      {
        this.k = 0;
        return false;
      }
      this.k = 1;
      return true;
    }

    public j.x b(int paramInt)
    {
      return (j.x)this.i.get(paramInt);
    }

    public final P b_()
    {
      return this.f;
    }

    public int d()
    {
      int m = 0;
      int i1 = this.l;
      if (i1 != -1)
        return i1;
      if ((0x1 & this.g) == 1);
      for (int i2 = 0 + i.c(1, p()); ; i2 = 0)
      {
        int i5;
        for (int i3 = i2; m < this.i.size(); i3 = i5)
        {
          i5 = i3 + i.g(2, (y)this.i.get(m));
          m++;
        }
        if ((0x2 & this.g) == 2)
          i3 += i.g(3, this.j);
        int i4 = i3 + b_().d();
        this.l = i4;
        return i4;
      }
    }

    public A i()
    {
      return e;
    }

    protected p.g l()
    {
      return j.q().a(A.class, a.class);
    }

    public B<A> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.g) == 1;
    }

    public String o()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.h = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.h = localg;
        return localg;
      }
      return (g)localObject;
    }

    public List<j.w> q()
    {
      return this.i;
    }

    public List<? extends j.x> r()
    {
      return this.i;
    }

    public int s()
    {
      return this.i.size();
    }

    public boolean t()
    {
      return (0x2 & this.g) == 2;
    }

    public j.C u()
    {
      return this.j;
    }

    public j.D v()
    {
      return this.j;
    }

    public a x()
    {
      return w();
    }

    public a y()
    {
      return a(this);
    }

    public static final class a extends p.a<a>
      implements j.B
    {
      private int a;
      private Object b = "";
      private List<j.w> c = Collections.emptyList();
      private D<j.w, j.w.a, j.x> d;
      private j.C e = j.C.h();
      private L<j.C, j.C.a, j.D> f;

      private a()
      {
        H();
      }

      private a(p.b paramb)
      {
        super();
        H();
      }

      private void H()
      {
        if (p.m)
        {
          L();
          M();
        }
      }

      private static a I()
      {
        return new a();
      }

      private void K()
      {
        if ((0x2 & this.a) != 2)
        {
          this.c = new ArrayList(this.c);
          this.a = (0x2 | this.a);
        }
      }

      private D<j.w, j.w.a, j.x> L()
      {
        List localList;
        if (this.d == null)
        {
          localList = this.c;
          if ((0x2 & this.a) != 2)
            break label55;
        }
        label55: for (boolean bool = true; ; bool = false)
        {
          this.d = new D(localList, bool, aE(), aD());
          this.c = null;
          return this.d;
        }
      }

      private L<j.C, j.C.a, j.D> M()
      {
        if (this.f == null)
        {
          this.f = new L(this.e, aE(), aD());
          this.e = null;
        }
        return this.f;
      }

      public static final k.a k()
      {
        return j.p();
      }

      public a A()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.A.h().o();
        aF();
        return this;
      }

      public a B()
      {
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          aF();
          return this;
        }
        this.d.e();
        return this;
      }

      public j.w.a C()
      {
        return (j.w.a)L().b(j.w.h());
      }

      public List<j.w.a> D()
      {
        return L().h();
      }

      public a E()
      {
        if (this.f == null)
        {
          this.e = j.C.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFFFB & this.a);
          return this;
          this.f.g();
        }
      }

      public j.C.a F()
      {
        this.a = (0x4 | this.a);
        aF();
        return (j.C.a)M().e();
      }

      public k.a J()
      {
        return j.p();
      }

      public a a(int paramInt, j.w.a parama)
      {
        if (this.d == null)
        {
          K();
          this.c.set(paramInt, parama.B());
          aF();
          return this;
        }
        this.d.a(paramInt, parama.B());
        return this;
      }

      public a a(int paramInt, j.w paramw)
      {
        if (this.d == null)
        {
          if (paramw == null)
            throw new NullPointerException();
          K();
          this.c.set(paramInt, paramw);
          aF();
          return this;
        }
        this.d.a(paramInt, paramw);
        return this;
      }

      public a a(j.A paramA)
      {
        if (paramA == j.A.h())
          return this;
        if (paramA.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.A.b(paramA);
          aF();
        }
        if (this.d == null)
          if (!j.A.c(paramA).isEmpty())
          {
            if (!this.c.isEmpty())
              break label119;
            this.c = j.A.c(paramA);
            this.a = (0xFFFFFFFD & this.a);
            aF();
          }
        while (true)
        {
          if (paramA.t())
            b(paramA.u());
          d(paramA.b_());
          return this;
          label119: K();
          this.c.addAll(j.A.c(paramA));
          break;
          if (!j.A.c(paramA).isEmpty())
            if (this.d.d())
            {
              this.d.b();
              this.d = null;
              this.c = j.A.c(paramA);
              this.a = (0xFFFFFFFD & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = L();
              this.d = localD;
            }
            else
            {
              this.d.a(j.A.c(paramA));
            }
        }
      }

      public a a(j.C.a parama)
      {
        if (this.f == null)
        {
          this.e = parama.s();
          aF();
        }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.f.a(parama.s());
        }
      }

      public a a(j.C paramC)
      {
        if (this.f == null)
        {
          if (paramC == null)
            throw new NullPointerException();
          this.e = paramC;
          aF();
        }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.f.a(paramC);
        }
      }

      public a a(j.w.a parama)
      {
        if (this.d == null)
        {
          K();
          this.c.add(parama.B());
          aF();
          return this;
        }
        this.d.a(parama.B());
        return this;
      }

      public a a(j.w paramw)
      {
        if (this.d == null)
        {
          if (paramw == null)
            throw new NullPointerException();
          K();
          this.c.add(paramw);
          aF();
          return this;
        }
        this.d.a(paramw);
        return this;
      }

      public a a(Iterable<? extends j.w> paramIterable)
      {
        if (this.d == null)
        {
          K();
          p.a.a(paramIterable, this.c);
          aF();
          return this;
        }
        this.d.a(paramIterable);
        return this;
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public j.w a(int paramInt)
      {
        if (this.d == null)
          return (j.w)this.c.get(paramInt);
        return (j.w)this.d.a(paramInt);
      }

      public final boolean a()
      {
        int i = 0;
        if (i < s())
          if (a(i).a());
        while ((t()) && (!u().a()))
        {
          return false;
          i++;
          break;
        }
        return true;
      }

      public a b(int paramInt, j.w.a parama)
      {
        if (this.d == null)
        {
          K();
          this.c.add(paramInt, parama.B());
          aF();
          return this;
        }
        this.d.b(paramInt, parama.B());
        return this;
      }

      public a b(int paramInt, j.w paramw)
      {
        if (this.d == null)
        {
          if (paramw == null)
            throw new NullPointerException();
          K();
          this.c.add(paramInt, paramw);
          aF();
          return this;
        }
        this.d.b(paramInt, paramw);
        return this;
      }

      public a b(j.C paramC)
      {
        if (this.f == null)
          if (((0x4 & this.a) == 4) && (this.e != j.C.h()))
          {
            this.e = j.C.a(this.e).a(paramC).t();
            aF();
          }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.e = paramC;
          break;
          this.f.b(paramC);
        }
      }

      public j.x b(int paramInt)
      {
        if (this.d == null)
          return (j.x)this.c.get(paramInt);
        return (j.x)this.d.c(paramInt);
      }

      public a c(int paramInt)
      {
        if (this.d == null)
        {
          K();
          this.c.remove(paramInt);
          aF();
          return this;
        }
        this.d.d(paramInt);
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.A))
          return a((j.A)paramx);
        super.a(paramx);
        return this;
      }

      public j.w.a d(int paramInt)
      {
        return (j.w.a)L().b(paramInt);
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.A localA3 = (j.A)j.A.a.d(paramh, paramn);
          if (localA3 != null)
            a(localA3);
          return this;
        }
        catch (s locals)
        {
          j.A localA2 = (j.A)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localA1 = localA2;
          }
          if (localA1 != null)
            a(localA1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.A localA1 = null;
        }
      }

      public j.w.a e(int paramInt)
      {
        return (j.w.a)L().c(paramInt, j.w.h());
      }

      protected p.g l()
      {
        return j.q().a(j.A.class, a.class);
      }

      public a m()
      {
        super.ah();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          if (this.f != null)
            break label84;
          this.e = j.C.h();
        }
        while (true)
        {
          this.a = (0xFFFFFFFB & this.a);
          return this;
          this.d.e();
          break;
          label84: this.f.g();
        }
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public List<j.w> q()
      {
        if (this.d == null)
          return Collections.unmodifiableList(this.c);
        return this.d.g();
      }

      public List<? extends j.x> r()
      {
        if (this.d != null)
          return this.d.i();
        return Collections.unmodifiableList(this.c);
      }

      public int s()
      {
        if (this.d == null)
          return this.c.size();
        return this.d.c();
      }

      public boolean t()
      {
        return (0x4 & this.a) == 4;
      }

      public j.C u()
      {
        if (this.f == null)
          return this.e;
        return (j.C)this.f.c();
      }

      public j.D v()
      {
        if (this.f != null)
          return (j.D)this.f.f();
        return this.e;
      }

      public a w()
      {
        return I().a(z());
      }

      public j.A x()
      {
        return j.A.h();
      }

      public j.A y()
      {
        j.A localA = z();
        if (!localA.a())
          throw b(localA);
        return localA;
      }

      public j.A z()
      {
        int i = 1;
        j.A localA = new j.A(this, null);
        int j = this.a;
        if ((j & 0x1) == i);
        while (true)
        {
          j.A.a(localA, this.b);
          if (this.d == null)
          {
            if ((0x2 & this.a) == 2)
            {
              this.c = Collections.unmodifiableList(this.c);
              this.a = (0xFFFFFFFD & this.a);
            }
            j.A.a(localA, this.c);
            if ((j & 0x4) != 4)
              break label155;
          }
          label155: for (int k = i | 0x2; ; k = i)
          {
            if (this.f == null)
              j.A.a(localA, this.e);
            while (true)
            {
              j.A.a(localA, k);
              aB();
              return localA;
              j.A.a(localA, this.d.f());
              break;
              j.A.a(localA, (j.C)this.f.d());
            }
          }
          i = 0;
        }
      }
    }
  }

  public static abstract interface B extends A
  {
    public abstract j.w a(int paramInt);

    public abstract j.x b(int paramInt);

    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract List<j.w> q();

    public abstract List<? extends j.x> r();

    public abstract int s();

    public abstract boolean t();

    public abstract j.C u();

    public abstract j.D v();
  }

  public static final class C extends p.d<C>
    implements j.D
  {
    public static B<C> a = new c()
    {
      public j.C c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.C(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 999;
    private static final C c = new C(true);
    private static final long h;
    private final P d;
    private List<j.G> e;
    private byte f = -1;
    private int g = -1;

    static
    {
      c.t();
    }

    // ERROR //
    private C(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 48	com/umeng/message/proguard/p$d:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 50	com/umeng/message/proguard/j$C:f	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 52	com/umeng/message/proguard/j$C:g	I
      //   16: aload_0
      //   17: invokespecial 42	com/umeng/message/proguard/j$C:t	()V
      //   20: invokestatic 57	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +168 -> 197
      //   32: aload_1
      //   33: invokevirtual 62	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+28->68, 0:+190->230, 7994:+46->86
      //   69: aload_1
      //   70: aload 4
      //   72: aload_2
      //   73: iload 9
      //   75: invokevirtual 65	com/umeng/message/proguard/j$C:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   78: ifne -50 -> 28
      //   81: iconst_1
      //   82: istore_3
      //   83: goto -55 -> 28
      //   86: iload 5
      //   88: iconst_1
      //   89: iand
      //   90: iconst_1
      //   91: if_icmpeq +20 -> 111
      //   94: aload_0
      //   95: new 67	java/util/ArrayList
      //   98: dup
      //   99: invokespecial 68	java/util/ArrayList:<init>	()V
      //   102: putfield 70	com/umeng/message/proguard/j$C:e	Ljava/util/List;
      //   105: iload 5
      //   107: iconst_1
      //   108: ior
      //   109: istore 5
      //   111: aload_0
      //   112: getfield 70	com/umeng/message/proguard/j$C:e	Ljava/util/List;
      //   115: aload_1
      //   116: getstatic 73	com/umeng/message/proguard/j$G:a	Lcom/umeng/message/proguard/B;
      //   119: aload_2
      //   120: invokevirtual 76	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   123: invokeinterface 82 2 0
      //   128: pop
      //   129: goto -101 -> 28
      //   132: astore 8
      //   134: aload 8
      //   136: aload_0
      //   137: invokevirtual 85	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   140: athrow
      //   141: astore 7
      //   143: iload 5
      //   145: iconst_1
      //   146: iand
      //   147: iconst_1
      //   148: if_icmpne +14 -> 162
      //   151: aload_0
      //   152: aload_0
      //   153: getfield 70	com/umeng/message/proguard/j$C:e	Ljava/util/List;
      //   156: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   159: putfield 70	com/umeng/message/proguard/j$C:e	Ljava/util/List;
      //   162: aload_0
      //   163: aload 4
      //   165: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   168: putfield 98	com/umeng/message/proguard/j$C:d	Lcom/umeng/message/proguard/P;
      //   171: aload_0
      //   172: invokevirtual 101	com/umeng/message/proguard/j$C:ad	()V
      //   175: aload 7
      //   177: athrow
      //   178: astore 6
      //   180: new 45	com/umeng/message/proguard/s
      //   183: dup
      //   184: aload 6
      //   186: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
      //   189: invokespecial 108	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   192: aload_0
      //   193: invokevirtual 85	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   196: athrow
      //   197: iload 5
      //   199: iconst_1
      //   200: iand
      //   201: iconst_1
      //   202: if_icmpne +14 -> 216
      //   205: aload_0
      //   206: aload_0
      //   207: getfield 70	com/umeng/message/proguard/j$C:e	Ljava/util/List;
      //   210: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   213: putfield 70	com/umeng/message/proguard/j$C:e	Ljava/util/List;
      //   216: aload_0
      //   217: aload 4
      //   219: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   222: putfield 98	com/umeng/message/proguard/j$C:d	Lcom/umeng/message/proguard/P;
      //   225: aload_0
      //   226: invokevirtual 101	com/umeng/message/proguard/j$C:ad	()V
      //   229: return
      //   230: iconst_1
      //   231: istore_3
      //   232: goto -204 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	132	com/umeng/message/proguard/s
      //   68	81	132	com/umeng/message/proguard/s
      //   94	105	132	com/umeng/message/proguard/s
      //   111	129	132	com/umeng/message/proguard/s
      //   32	38	141	finally
      //   68	81	141	finally
      //   94	105	141	finally
      //   111	129	141	finally
      //   134	141	141	finally
      //   180	197	141	finally
      //   32	38	178	java/io/IOException
      //   68	81	178	java/io/IOException
      //   94	105	178	java/io/IOException
      //   111	129	178	java/io/IOException
    }

    private C(p.c<C, ?> paramc)
    {
      super();
      this.d = paramc.b_();
    }

    private C(boolean paramBoolean)
    {
      this.d = P.c();
    }

    public static a a(C paramC)
    {
      return q().a(paramC);
    }

    public static C a(g paramg)
      throws s
    {
      return (C)a.d(paramg);
    }

    public static C a(g paramg, n paramn)
      throws s
    {
      return (C)a.d(paramg, paramn);
    }

    public static C a(h paramh)
      throws IOException
    {
      return (C)a.d(paramh);
    }

    public static C a(h paramh, n paramn)
      throws IOException
    {
      return (C)a.b(paramh, paramn);
    }

    public static C a(InputStream paramInputStream)
      throws IOException
    {
      return (C)a.h(paramInputStream);
    }

    public static C a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (C)a.h(paramInputStream, paramn);
    }

    public static C a(byte[] paramArrayOfByte)
      throws s
    {
      return (C)a.d(paramArrayOfByte);
    }

    public static C a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (C)a.d(paramArrayOfByte, paramn);
    }

    public static C b(InputStream paramInputStream)
      throws IOException
    {
      return (C)a.f(paramInputStream);
    }

    public static C b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (C)a.f(paramInputStream, paramn);
    }

    public static C h()
    {
      return c;
    }

    public static final k.a k()
    {
      return j.D();
    }

    public static a q()
    {
      return a.x();
    }

    private void t()
    {
      this.e = Collections.emptyList();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public j.G a(int paramInt)
    {
      return (j.G)this.e.get(paramInt);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      p.d.a locala = X();
      for (int i = 0; i < this.e.size(); i++)
        parami.c(999, (y)this.e.get(i));
      locala.a(536870912, parami);
      b_().a(parami);
    }

    public final boolean a()
    {
      int i = this.f;
      if (i != -1)
        return i == 1;
      for (int j = 0; j < p(); j++)
        if (!a(j).a())
        {
          this.f = 0;
          return false;
        }
      if (!W())
      {
        this.f = 0;
        return false;
      }
      this.f = 1;
      return true;
    }

    public j.H b(int paramInt)
    {
      return (j.H)this.e.get(paramInt);
    }

    public final P b_()
    {
      return this.d;
    }

    public int d()
    {
      int i = this.g;
      if (i != -1)
        return i;
      int j = 0;
      int k = 0;
      while (j < this.e.size())
      {
        k += i.g(999, (y)this.e.get(j));
        j++;
      }
      int m = k + Z() + b_().d();
      this.g = m;
      return m;
    }

    public C i()
    {
      return c;
    }

    protected p.g l()
    {
      return j.E().a(C.class, a.class);
    }

    public B<C> m()
    {
      return a;
    }

    public List<j.G> n()
    {
      return this.e;
    }

    public List<? extends j.H> o()
    {
      return this.e;
    }

    public int p()
    {
      return this.e.size();
    }

    public a r()
    {
      return q();
    }

    public a s()
    {
      return a(this);
    }

    public static final class a extends p.c<j.C, a>
      implements j.D
    {
      private int a;
      private List<j.G> b = Collections.emptyList();
      private D<j.G, j.G.a, j.H> c;

      private a()
      {
        y();
      }

      private a(p.b paramb)
      {
        super();
        y();
      }

      private void C()
      {
        if ((0x1 & this.a) != 1)
        {
          this.b = new ArrayList(this.b);
          this.a = (0x1 | this.a);
        }
      }

      private D<j.G, j.G.a, j.H> D()
      {
        int i = 1;
        List localList;
        if (this.c == null)
        {
          localList = this.b;
          if ((0x1 & this.a) != i)
            break label55;
        }
        while (true)
        {
          this.c = new D(localList, i, aE(), aD());
          this.b = null;
          return this.c;
          label55: int j = 0;
        }
      }

      public static final k.a k()
      {
        return j.D();
      }

      private void y()
      {
        if (p.m)
          D();
      }

      private static a z()
      {
        return new a();
      }

      public k.a J()
      {
        return j.D();
      }

      public a a(int paramInt, j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.set(paramInt, parama.G());
          aF();
          return this;
        }
        this.c.a(paramInt, parama.G());
        return this;
      }

      public a a(int paramInt, j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.set(paramInt, paramG);
          aF();
          return this;
        }
        this.c.a(paramInt, paramG);
        return this;
      }

      public a a(j.C paramC)
      {
        if (paramC == j.C.h())
          return this;
        if (this.c == null)
          if (!j.C.b(paramC).isEmpty())
          {
            if (!this.b.isEmpty())
              break label79;
            this.b = j.C.b(paramC);
            this.a = (0xFFFFFFFE & this.a);
            aF();
          }
        while (true)
        {
          a(paramC);
          d(paramC.b_());
          return this;
          label79: C();
          this.b.addAll(j.C.b(paramC));
          break;
          if (!j.C.b(paramC).isEmpty())
            if (this.c.d())
            {
              this.c.b();
              this.c = null;
              this.b = j.C.b(paramC);
              this.a = (0xFFFFFFFE & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = D();
              this.c = localD;
            }
            else
            {
              this.c.a(j.C.b(paramC));
            }
        }
      }

      public a a(j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.add(parama.G());
          aF();
          return this;
        }
        this.c.a(parama.G());
        return this;
      }

      public a a(j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.add(paramG);
          aF();
          return this;
        }
        this.c.a(paramG);
        return this;
      }

      public a a(Iterable<? extends j.G> paramIterable)
      {
        if (this.c == null)
        {
          C();
          p.c.a(paramIterable, this.b);
          aF();
          return this;
        }
        this.c.a(paramIterable);
        return this;
      }

      public j.G a(int paramInt)
      {
        if (this.c == null)
          return (j.G)this.b.get(paramInt);
        return (j.G)this.c.a(paramInt);
      }

      public final boolean a()
      {
        int i = 0;
        if (i < p())
          if (a(i).a());
        while (!af())
        {
          return false;
          i++;
          break;
        }
        return true;
      }

      public a b(int paramInt, j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.add(paramInt, parama.G());
          aF();
          return this;
        }
        this.c.b(paramInt, parama.G());
        return this;
      }

      public a b(int paramInt, j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.add(paramInt, paramG);
          aF();
          return this;
        }
        this.c.b(paramInt, paramG);
        return this;
      }

      public j.H b(int paramInt)
      {
        if (this.c == null)
          return (j.H)this.b.get(paramInt);
        return (j.H)this.c.c(paramInt);
      }

      public a c(int paramInt)
      {
        if (this.c == null)
        {
          C();
          this.b.remove(paramInt);
          aF();
          return this;
        }
        this.c.d(paramInt);
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.C))
          return a((j.C)paramx);
        super.a(paramx);
        return this;
      }

      public j.G.a d(int paramInt)
      {
        return (j.G.a)D().b(paramInt);
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.C localC3 = (j.C)j.C.a.d(paramh, paramn);
          if (localC3 != null)
            a(localC3);
          return this;
        }
        catch (s locals)
        {
          j.C localC2 = (j.C)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localC1 = localC2;
          }
          if (localC1 != null)
            a(localC1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.C localC1 = null;
        }
      }

      public j.G.a e(int paramInt)
      {
        return (j.G.a)D().c(paramInt, j.G.h());
      }

      protected p.g l()
      {
        return j.E().a(j.C.class, a.class);
      }

      public a m()
      {
        super.B();
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          return this;
        }
        this.c.e();
        return this;
      }

      public List<j.G> n()
      {
        if (this.c == null)
          return Collections.unmodifiableList(this.b);
        return this.c.g();
      }

      public List<? extends j.H> o()
      {
        if (this.c != null)
          return this.c.i();
        return Collections.unmodifiableList(this.b);
      }

      public int p()
      {
        if (this.c == null)
          return this.b.size();
        return this.c.c();
      }

      public a q()
      {
        return z().a(t());
      }

      public j.C r()
      {
        return j.C.h();
      }

      public j.C s()
      {
        j.C localC = t();
        if (!localC.a())
          throw b(localC);
        return localC;
      }

      public j.C t()
      {
        j.C localC = new j.C(this, null);
        if (this.c == null)
        {
          if ((0x1 & this.a) == 1)
          {
            this.b = Collections.unmodifiableList(this.b);
            this.a = (0xFFFFFFFE & this.a);
          }
          j.C.a(localC, this.b);
        }
        while (true)
        {
          aB();
          return localC;
          j.C.a(localC, this.c.f());
        }
      }

      public a u()
      {
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          aF();
          return this;
        }
        this.c.e();
        return this;
      }

      public j.G.a v()
      {
        return (j.G.a)D().b(j.G.h());
      }

      public List<j.G.a> w()
      {
        return D().h();
      }
    }
  }

  public static abstract interface D extends p.e<j.C>
  {
    public abstract j.G a(int paramInt);

    public abstract j.H b(int paramInt);

    public abstract List<j.G> n();

    public abstract List<? extends j.H> o();

    public abstract int p();
  }

  public static final class E extends p
    implements j.F
  {
    public static B<E> a = new c()
    {
      public j.E c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.E(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    private static final E c = new E(true);
    private static final long h;
    private final P d;
    private List<b> e;
    private byte f = -1;
    private int g = -1;

    static
    {
      c.t();
    }

    // ERROR //
    private E(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 47	com/umeng/message/proguard/p:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 49	com/umeng/message/proguard/j$E:f	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 51	com/umeng/message/proguard/j$E:g	I
      //   16: aload_0
      //   17: invokespecial 41	com/umeng/message/proguard/j$E:t	()V
      //   20: invokestatic 56	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +168 -> 197
      //   32: aload_1
      //   33: invokevirtual 61	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+28->68, 0:+190->230, 10:+46->86
      //   69: aload_1
      //   70: aload 4
      //   72: aload_2
      //   73: iload 9
      //   75: invokevirtual 64	com/umeng/message/proguard/j$E:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   78: ifne -50 -> 28
      //   81: iconst_1
      //   82: istore_3
      //   83: goto -55 -> 28
      //   86: iload 5
      //   88: iconst_1
      //   89: iand
      //   90: iconst_1
      //   91: if_icmpeq +20 -> 111
      //   94: aload_0
      //   95: new 66	java/util/ArrayList
      //   98: dup
      //   99: invokespecial 67	java/util/ArrayList:<init>	()V
      //   102: putfield 69	com/umeng/message/proguard/j$E:e	Ljava/util/List;
      //   105: iload 5
      //   107: iconst_1
      //   108: ior
      //   109: istore 5
      //   111: aload_0
      //   112: getfield 69	com/umeng/message/proguard/j$E:e	Ljava/util/List;
      //   115: aload_1
      //   116: getstatic 72	com/umeng/message/proguard/j$E$b:a	Lcom/umeng/message/proguard/B;
      //   119: aload_2
      //   120: invokevirtual 75	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   123: invokeinterface 81 2 0
      //   128: pop
      //   129: goto -101 -> 28
      //   132: astore 8
      //   134: aload 8
      //   136: aload_0
      //   137: invokevirtual 84	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   140: athrow
      //   141: astore 7
      //   143: iload 5
      //   145: iconst_1
      //   146: iand
      //   147: iconst_1
      //   148: if_icmpne +14 -> 162
      //   151: aload_0
      //   152: aload_0
      //   153: getfield 69	com/umeng/message/proguard/j$E:e	Ljava/util/List;
      //   156: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   159: putfield 69	com/umeng/message/proguard/j$E:e	Ljava/util/List;
      //   162: aload_0
      //   163: aload 4
      //   165: invokevirtual 95	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   168: putfield 97	com/umeng/message/proguard/j$E:d	Lcom/umeng/message/proguard/P;
      //   171: aload_0
      //   172: invokevirtual 100	com/umeng/message/proguard/j$E:ad	()V
      //   175: aload 7
      //   177: athrow
      //   178: astore 6
      //   180: new 44	com/umeng/message/proguard/s
      //   183: dup
      //   184: aload 6
      //   186: invokevirtual 104	java/io/IOException:getMessage	()Ljava/lang/String;
      //   189: invokespecial 107	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   192: aload_0
      //   193: invokevirtual 84	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   196: athrow
      //   197: iload 5
      //   199: iconst_1
      //   200: iand
      //   201: iconst_1
      //   202: if_icmpne +14 -> 216
      //   205: aload_0
      //   206: aload_0
      //   207: getfield 69	com/umeng/message/proguard/j$E:e	Ljava/util/List;
      //   210: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   213: putfield 69	com/umeng/message/proguard/j$E:e	Ljava/util/List;
      //   216: aload_0
      //   217: aload 4
      //   219: invokevirtual 95	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   222: putfield 97	com/umeng/message/proguard/j$E:d	Lcom/umeng/message/proguard/P;
      //   225: aload_0
      //   226: invokevirtual 100	com/umeng/message/proguard/j$E:ad	()V
      //   229: return
      //   230: iconst_1
      //   231: istore_3
      //   232: goto -204 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	132	com/umeng/message/proguard/s
      //   68	81	132	com/umeng/message/proguard/s
      //   94	105	132	com/umeng/message/proguard/s
      //   111	129	132	com/umeng/message/proguard/s
      //   32	38	141	finally
      //   68	81	141	finally
      //   94	105	141	finally
      //   111	129	141	finally
      //   134	141	141	finally
      //   180	197	141	finally
      //   32	38	178	java/io/IOException
      //   68	81	178	java/io/IOException
      //   94	105	178	java/io/IOException
      //   111	129	178	java/io/IOException
    }

    private E(p.a<?> parama)
    {
      super();
      this.d = parama.b_();
    }

    private E(boolean paramBoolean)
    {
      this.d = P.c();
    }

    public static a a(E paramE)
    {
      return q().a(paramE);
    }

    public static E a(g paramg)
      throws s
    {
      return (E)a.d(paramg);
    }

    public static E a(g paramg, n paramn)
      throws s
    {
      return (E)a.d(paramg, paramn);
    }

    public static E a(h paramh)
      throws IOException
    {
      return (E)a.d(paramh);
    }

    public static E a(h paramh, n paramn)
      throws IOException
    {
      return (E)a.b(paramh, paramn);
    }

    public static E a(InputStream paramInputStream)
      throws IOException
    {
      return (E)a.h(paramInputStream);
    }

    public static E a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (E)a.h(paramInputStream, paramn);
    }

    public static E a(byte[] paramArrayOfByte)
      throws s
    {
      return (E)a.d(paramArrayOfByte);
    }

    public static E a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (E)a.d(paramArrayOfByte, paramn);
    }

    public static E b(InputStream paramInputStream)
      throws IOException
    {
      return (E)a.f(paramInputStream);
    }

    public static E b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (E)a.f(paramInputStream, paramn);
    }

    public static E h()
    {
      return c;
    }

    public static final k.a k()
    {
      return j.L();
    }

    public static a q()
    {
      return a.x();
    }

    private void t()
    {
      this.e = Collections.emptyList();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public b a(int paramInt)
    {
      return (b)this.e.get(paramInt);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      for (int i = 0; i < this.e.size(); i++)
        parami.c(1, (y)this.e.get(i));
      b_().a(parami);
    }

    public final boolean a()
    {
      int i = this.f;
      if (i != -1)
        return i == 1;
      this.f = 1;
      return true;
    }

    public c b(int paramInt)
    {
      return (c)this.e.get(paramInt);
    }

    public final P b_()
    {
      return this.d;
    }

    public int d()
    {
      int i = this.g;
      if (i != -1)
        return i;
      int j = 0;
      int k = 0;
      while (j < this.e.size())
      {
        k += i.g(1, (y)this.e.get(j));
        j++;
      }
      int m = k + b_().d();
      this.g = m;
      return m;
    }

    public E i()
    {
      return c;
    }

    protected p.g l()
    {
      return j.M().a(E.class, a.class);
    }

    public B<E> m()
    {
      return a;
    }

    public List<b> n()
    {
      return this.e;
    }

    public List<? extends c> o()
    {
      return this.e;
    }

    public int p()
    {
      return this.e.size();
    }

    public a r()
    {
      return q();
    }

    public a s()
    {
      return a(this);
    }

    public static final class a extends p.a<a>
      implements j.F
    {
      private int a;
      private List<j.E.b> b = Collections.emptyList();
      private D<j.E.b, j.E.b.a, j.E.c> c;

      private a()
      {
        y();
      }

      private a(p.b paramb)
      {
        super();
        y();
      }

      private void A()
      {
        if ((0x1 & this.a) != 1)
        {
          this.b = new ArrayList(this.b);
          this.a = (0x1 | this.a);
        }
      }

      private D<j.E.b, j.E.b.a, j.E.c> B()
      {
        int i = 1;
        List localList;
        if (this.c == null)
        {
          localList = this.b;
          if ((0x1 & this.a) != i)
            break label55;
        }
        while (true)
        {
          this.c = new D(localList, i, aE(), aD());
          this.b = null;
          return this.c;
          label55: int j = 0;
        }
      }

      public static final k.a k()
      {
        return j.L();
      }

      private void y()
      {
        if (p.m)
          B();
      }

      private static a z()
      {
        return new a();
      }

      public k.a J()
      {
        return j.L();
      }

      public a a(int paramInt, j.E.b.a parama)
      {
        if (this.c == null)
        {
          A();
          this.b.set(paramInt, parama.z());
          aF();
          return this;
        }
        this.c.a(paramInt, parama.z());
        return this;
      }

      public a a(int paramInt, j.E.b paramb)
      {
        if (this.c == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          A();
          this.b.set(paramInt, paramb);
          aF();
          return this;
        }
        this.c.a(paramInt, paramb);
        return this;
      }

      public a a(j.E.b.a parama)
      {
        if (this.c == null)
        {
          A();
          this.b.add(parama.z());
          aF();
          return this;
        }
        this.c.a(parama.z());
        return this;
      }

      public a a(j.E.b paramb)
      {
        if (this.c == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          A();
          this.b.add(paramb);
          aF();
          return this;
        }
        this.c.a(paramb);
        return this;
      }

      public a a(j.E paramE)
      {
        if (paramE == j.E.h())
          return this;
        if (this.c == null)
          if (!j.E.b(paramE).isEmpty())
          {
            if (!this.b.isEmpty())
              break label74;
            this.b = j.E.b(paramE);
            this.a = (0xFFFFFFFE & this.a);
            aF();
          }
        while (true)
        {
          d(paramE.b_());
          return this;
          label74: A();
          this.b.addAll(j.E.b(paramE));
          break;
          if (!j.E.b(paramE).isEmpty())
            if (this.c.d())
            {
              this.c.b();
              this.c = null;
              this.b = j.E.b(paramE);
              this.a = (0xFFFFFFFE & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = B();
              this.c = localD;
            }
            else
            {
              this.c.a(j.E.b(paramE));
            }
        }
      }

      public a a(Iterable<? extends j.E.b> paramIterable)
      {
        if (this.c == null)
        {
          A();
          p.a.a(paramIterable, this.b);
          aF();
          return this;
        }
        this.c.a(paramIterable);
        return this;
      }

      public j.E.b a(int paramInt)
      {
        if (this.c == null)
          return (j.E.b)this.b.get(paramInt);
        return (j.E.b)this.c.a(paramInt);
      }

      public final boolean a()
      {
        return true;
      }

      public a b(int paramInt, j.E.b.a parama)
      {
        if (this.c == null)
        {
          A();
          this.b.add(paramInt, parama.z());
          aF();
          return this;
        }
        this.c.b(paramInt, parama.z());
        return this;
      }

      public a b(int paramInt, j.E.b paramb)
      {
        if (this.c == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          A();
          this.b.add(paramInt, paramb);
          aF();
          return this;
        }
        this.c.b(paramInt, paramb);
        return this;
      }

      public j.E.c b(int paramInt)
      {
        if (this.c == null)
          return (j.E.c)this.b.get(paramInt);
        return (j.E.c)this.c.c(paramInt);
      }

      public a c(int paramInt)
      {
        if (this.c == null)
        {
          A();
          this.b.remove(paramInt);
          aF();
          return this;
        }
        this.c.d(paramInt);
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.E))
          return a((j.E)paramx);
        super.a(paramx);
        return this;
      }

      public j.E.b.a d(int paramInt)
      {
        return (j.E.b.a)B().b(paramInt);
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.E localE3 = (j.E)j.E.a.d(paramh, paramn);
          if (localE3 != null)
            a(localE3);
          return this;
        }
        catch (s locals)
        {
          j.E localE2 = (j.E)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localE1 = localE2;
          }
          if (localE1 != null)
            a(localE1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.E localE1 = null;
        }
      }

      public j.E.b.a e(int paramInt)
      {
        return (j.E.b.a)B().c(paramInt, j.E.b.h());
      }

      protected p.g l()
      {
        return j.M().a(j.E.class, a.class);
      }

      public a m()
      {
        super.ah();
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          return this;
        }
        this.c.e();
        return this;
      }

      public List<j.E.b> n()
      {
        if (this.c == null)
          return Collections.unmodifiableList(this.b);
        return this.c.g();
      }

      public List<? extends j.E.c> o()
      {
        if (this.c != null)
          return this.c.i();
        return Collections.unmodifiableList(this.b);
      }

      public int p()
      {
        if (this.c == null)
          return this.b.size();
        return this.c.c();
      }

      public a q()
      {
        return z().a(t());
      }

      public j.E r()
      {
        return j.E.h();
      }

      public j.E s()
      {
        j.E localE = t();
        if (!localE.a())
          throw b(localE);
        return localE;
      }

      public j.E t()
      {
        j.E localE = new j.E(this, null);
        if (this.c == null)
        {
          if ((0x1 & this.a) == 1)
          {
            this.b = Collections.unmodifiableList(this.b);
            this.a = (0xFFFFFFFE & this.a);
          }
          j.E.a(localE, this.b);
        }
        while (true)
        {
          aB();
          return localE;
          j.E.a(localE, this.c.f());
        }
      }

      public a u()
      {
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          aF();
          return this;
        }
        this.c.e();
        return this;
      }

      public j.E.b.a v()
      {
        return (j.E.b.a)B().b(j.E.b.h());
      }

      public List<j.E.b.a> w()
      {
        return B().h();
      }
    }

    public static final class b extends p
      implements j.E.c
    {
      public static B<b> a = new c()
      {
        public j.E.b c(h paramAnonymoush, n paramAnonymousn)
          throws s
        {
          return new j.E.b(paramAnonymoush, paramAnonymousn, null);
        }
      };
      public static final int b = 1;
      public static final int c = 2;
      public static final int d = 3;
      public static final int e = 4;
      private static final b f = new b(true);
      private static final long r;
      private final P g;
      private int h;
      private List<Integer> i;
      private int j = -1;
      private List<Integer> k;
      private int l = -1;
      private Object n;
      private Object o;
      private byte p = -1;
      private int q = -1;

      static
      {
        f.A();
      }

      // ERROR //
      private b(h paramh, n paramn)
        throws s
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_3
        //   2: aload_0
        //   3: invokespecial 60	com/umeng/message/proguard/p:<init>	()V
        //   6: aload_0
        //   7: iconst_m1
        //   8: putfield 62	com/umeng/message/proguard/j$E$b:j	I
        //   11: aload_0
        //   12: iconst_m1
        //   13: putfield 64	com/umeng/message/proguard/j$E$b:l	I
        //   16: aload_0
        //   17: iconst_m1
        //   18: putfield 66	com/umeng/message/proguard/j$E$b:p	B
        //   21: aload_0
        //   22: iconst_m1
        //   23: putfield 68	com/umeng/message/proguard/j$E$b:q	I
        //   26: aload_0
        //   27: invokespecial 54	com/umeng/message/proguard/j$E$b:A	()V
        //   30: invokestatic 73	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
        //   33: astore 4
        //   35: iconst_0
        //   36: istore 5
        //   38: iload_3
        //   39: ifne +467 -> 506
        //   42: aload_1
        //   43: invokevirtual 78	com/umeng/message/proguard/h:a	()I
        //   46: istore 9
        //   48: iload 9
        //   50: lookupswitch	default:+66->116, 0:+508->558, 8:+84->134, 10:+194->244, 16:+291->341, 18:+336->386, 26:+414->464, 34:+435->485
        //   117: aload_1
        //   118: aload 4
        //   120: aload_2
        //   121: iload 9
        //   123: invokevirtual 81	com/umeng/message/proguard/j$E$b:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
        //   126: ifne -88 -> 38
        //   129: iconst_1
        //   130: istore_3
        //   131: goto -93 -> 38
        //   134: iload 5
        //   136: iconst_1
        //   137: iand
        //   138: iconst_1
        //   139: if_icmpeq +20 -> 159
        //   142: aload_0
        //   143: new 83	java/util/ArrayList
        //   146: dup
        //   147: invokespecial 84	java/util/ArrayList:<init>	()V
        //   150: putfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   153: iload 5
        //   155: iconst_1
        //   156: ior
        //   157: istore 5
        //   159: aload_0
        //   160: getfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   163: aload_1
        //   164: invokevirtual 88	com/umeng/message/proguard/h:g	()I
        //   167: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   170: invokeinterface 100 2 0
        //   175: pop
        //   176: goto -138 -> 38
        //   179: astore 8
        //   181: aload 8
        //   183: aload_0
        //   184: invokevirtual 103	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
        //   187: athrow
        //   188: astore 7
        //   190: iload 5
        //   192: iconst_1
        //   193: iand
        //   194: iconst_1
        //   195: if_icmpne +14 -> 209
        //   198: aload_0
        //   199: aload_0
        //   200: getfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   203: invokestatic 109	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
        //   206: putfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   209: iload 5
        //   211: iconst_2
        //   212: iand
        //   213: iconst_2
        //   214: if_icmpne +14 -> 228
        //   217: aload_0
        //   218: aload_0
        //   219: getfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   222: invokestatic 109	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
        //   225: putfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   228: aload_0
        //   229: aload 4
        //   231: invokevirtual 116	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
        //   234: putfield 118	com/umeng/message/proguard/j$E$b:g	Lcom/umeng/message/proguard/P;
        //   237: aload_0
        //   238: invokevirtual 121	com/umeng/message/proguard/j$E$b:ad	()V
        //   241: aload 7
        //   243: athrow
        //   244: aload_1
        //   245: aload_1
        //   246: invokevirtual 124	com/umeng/message/proguard/h:s	()I
        //   249: invokevirtual 127	com/umeng/message/proguard/h:f	(I)I
        //   252: istore 13
        //   254: iload 5
        //   256: iconst_1
        //   257: iand
        //   258: iconst_1
        //   259: if_icmpeq +27 -> 286
        //   262: aload_1
        //   263: invokevirtual 130	com/umeng/message/proguard/h:x	()I
        //   266: ifle +20 -> 286
        //   269: aload_0
        //   270: new 83	java/util/ArrayList
        //   273: dup
        //   274: invokespecial 84	java/util/ArrayList:<init>	()V
        //   277: putfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   280: iload 5
        //   282: iconst_1
        //   283: ior
        //   284: istore 5
        //   286: aload_1
        //   287: invokevirtual 130	com/umeng/message/proguard/h:x	()I
        //   290: ifle +42 -> 332
        //   293: aload_0
        //   294: getfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   297: aload_1
        //   298: invokevirtual 88	com/umeng/message/proguard/h:g	()I
        //   301: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   304: invokeinterface 100 2 0
        //   309: pop
        //   310: goto -24 -> 286
        //   313: astore 6
        //   315: new 57	com/umeng/message/proguard/s
        //   318: dup
        //   319: aload 6
        //   321: invokevirtual 134	java/io/IOException:getMessage	()Ljava/lang/String;
        //   324: invokespecial 137	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
        //   327: aload_0
        //   328: invokevirtual 103	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
        //   331: athrow
        //   332: aload_1
        //   333: iload 13
        //   335: invokevirtual 140	com/umeng/message/proguard/h:g	(I)V
        //   338: goto -300 -> 38
        //   341: iload 5
        //   343: iconst_2
        //   344: iand
        //   345: iconst_2
        //   346: if_icmpeq +20 -> 366
        //   349: aload_0
        //   350: new 83	java/util/ArrayList
        //   353: dup
        //   354: invokespecial 84	java/util/ArrayList:<init>	()V
        //   357: putfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   360: iload 5
        //   362: iconst_2
        //   363: ior
        //   364: istore 5
        //   366: aload_0
        //   367: getfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   370: aload_1
        //   371: invokevirtual 88	com/umeng/message/proguard/h:g	()I
        //   374: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   377: invokeinterface 100 2 0
        //   382: pop
        //   383: goto -345 -> 38
        //   386: aload_1
        //   387: aload_1
        //   388: invokevirtual 124	com/umeng/message/proguard/h:s	()I
        //   391: invokevirtual 127	com/umeng/message/proguard/h:f	(I)I
        //   394: istore 10
        //   396: iload 5
        //   398: iconst_2
        //   399: iand
        //   400: iconst_2
        //   401: if_icmpeq +27 -> 428
        //   404: aload_1
        //   405: invokevirtual 130	com/umeng/message/proguard/h:x	()I
        //   408: ifle +20 -> 428
        //   411: aload_0
        //   412: new 83	java/util/ArrayList
        //   415: dup
        //   416: invokespecial 84	java/util/ArrayList:<init>	()V
        //   419: putfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   422: iload 5
        //   424: iconst_2
        //   425: ior
        //   426: istore 5
        //   428: aload_1
        //   429: invokevirtual 130	com/umeng/message/proguard/h:x	()I
        //   432: ifle +23 -> 455
        //   435: aload_0
        //   436: getfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   439: aload_1
        //   440: invokevirtual 88	com/umeng/message/proguard/h:g	()I
        //   443: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
        //   446: invokeinterface 100 2 0
        //   451: pop
        //   452: goto -24 -> 428
        //   455: aload_1
        //   456: iload 10
        //   458: invokevirtual 140	com/umeng/message/proguard/h:g	(I)V
        //   461: goto -423 -> 38
        //   464: aload_0
        //   465: iconst_1
        //   466: aload_0
        //   467: getfield 142	com/umeng/message/proguard/j$E$b:h	I
        //   470: ior
        //   471: putfield 142	com/umeng/message/proguard/j$E$b:h	I
        //   474: aload_0
        //   475: aload_1
        //   476: invokevirtual 145	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
        //   479: putfield 147	com/umeng/message/proguard/j$E$b:n	Ljava/lang/Object;
        //   482: goto -444 -> 38
        //   485: aload_0
        //   486: iconst_2
        //   487: aload_0
        //   488: getfield 142	com/umeng/message/proguard/j$E$b:h	I
        //   491: ior
        //   492: putfield 142	com/umeng/message/proguard/j$E$b:h	I
        //   495: aload_0
        //   496: aload_1
        //   497: invokevirtual 145	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
        //   500: putfield 149	com/umeng/message/proguard/j$E$b:o	Ljava/lang/Object;
        //   503: goto -465 -> 38
        //   506: iload 5
        //   508: iconst_1
        //   509: iand
        //   510: iconst_1
        //   511: if_icmpne +14 -> 525
        //   514: aload_0
        //   515: aload_0
        //   516: getfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   519: invokestatic 109	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
        //   522: putfield 86	com/umeng/message/proguard/j$E$b:i	Ljava/util/List;
        //   525: iload 5
        //   527: iconst_2
        //   528: iand
        //   529: iconst_2
        //   530: if_icmpne +14 -> 544
        //   533: aload_0
        //   534: aload_0
        //   535: getfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   538: invokestatic 109	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
        //   541: putfield 111	com/umeng/message/proguard/j$E$b:k	Ljava/util/List;
        //   544: aload_0
        //   545: aload 4
        //   547: invokevirtual 116	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
        //   550: putfield 118	com/umeng/message/proguard/j$E$b:g	Lcom/umeng/message/proguard/P;
        //   553: aload_0
        //   554: invokevirtual 121	com/umeng/message/proguard/j$E$b:ad	()V
        //   557: return
        //   558: iconst_1
        //   559: istore_3
        //   560: goto -522 -> 38
        //
        // Exception table:
        //   from	to	target	type
        //   42	48	179	com/umeng/message/proguard/s
        //   116	129	179	com/umeng/message/proguard/s
        //   142	153	179	com/umeng/message/proguard/s
        //   159	176	179	com/umeng/message/proguard/s
        //   244	254	179	com/umeng/message/proguard/s
        //   262	280	179	com/umeng/message/proguard/s
        //   286	310	179	com/umeng/message/proguard/s
        //   332	338	179	com/umeng/message/proguard/s
        //   349	360	179	com/umeng/message/proguard/s
        //   366	383	179	com/umeng/message/proguard/s
        //   386	396	179	com/umeng/message/proguard/s
        //   404	422	179	com/umeng/message/proguard/s
        //   428	452	179	com/umeng/message/proguard/s
        //   455	461	179	com/umeng/message/proguard/s
        //   464	482	179	com/umeng/message/proguard/s
        //   485	503	179	com/umeng/message/proguard/s
        //   42	48	188	finally
        //   116	129	188	finally
        //   142	153	188	finally
        //   159	176	188	finally
        //   181	188	188	finally
        //   244	254	188	finally
        //   262	280	188	finally
        //   286	310	188	finally
        //   315	332	188	finally
        //   332	338	188	finally
        //   349	360	188	finally
        //   366	383	188	finally
        //   386	396	188	finally
        //   404	422	188	finally
        //   428	452	188	finally
        //   455	461	188	finally
        //   464	482	188	finally
        //   485	503	188	finally
        //   42	48	313	java/io/IOException
        //   116	129	313	java/io/IOException
        //   142	153	313	java/io/IOException
        //   159	176	313	java/io/IOException
        //   244	254	313	java/io/IOException
        //   262	280	313	java/io/IOException
        //   286	310	313	java/io/IOException
        //   332	338	313	java/io/IOException
        //   349	360	313	java/io/IOException
        //   366	383	313	java/io/IOException
        //   386	396	313	java/io/IOException
        //   404	422	313	java/io/IOException
        //   428	452	313	java/io/IOException
        //   455	461	313	java/io/IOException
        //   464	482	313	java/io/IOException
        //   485	503	313	java/io/IOException
      }

      private b(p.a<?> parama)
      {
        super();
        this.g = parama.b_();
      }

      private b(boolean paramBoolean)
      {
        this.g = P.c();
      }

      private void A()
      {
        this.i = Collections.emptyList();
        this.k = Collections.emptyList();
        this.n = "";
        this.o = "";
      }

      public static a a(b paramb)
      {
        return x().a(paramb);
      }

      public static b a(g paramg)
        throws s
      {
        return (b)a.d(paramg);
      }

      public static b a(g paramg, n paramn)
        throws s
      {
        return (b)a.d(paramg, paramn);
      }

      public static b a(h paramh)
        throws IOException
      {
        return (b)a.d(paramh);
      }

      public static b a(h paramh, n paramn)
        throws IOException
      {
        return (b)a.b(paramh, paramn);
      }

      public static b a(InputStream paramInputStream)
        throws IOException
      {
        return (b)a.h(paramInputStream);
      }

      public static b a(InputStream paramInputStream, n paramn)
        throws IOException
      {
        return (b)a.h(paramInputStream, paramn);
      }

      public static b a(byte[] paramArrayOfByte)
        throws s
      {
        return (b)a.d(paramArrayOfByte);
      }

      public static b a(byte[] paramArrayOfByte, n paramn)
        throws s
      {
        return (b)a.d(paramArrayOfByte, paramn);
      }

      public static b b(InputStream paramInputStream)
        throws IOException
      {
        return (b)a.f(paramInputStream);
      }

      public static b b(InputStream paramInputStream, n paramn)
        throws IOException
      {
        return (b)a.f(paramInputStream, paramn);
      }

      public static b h()
      {
        return f;
      }

      public static final k.a k()
      {
        return j.N();
      }

      public static a x()
      {
        return a.F();
      }

      protected Object I()
        throws ObjectStreamException
      {
        return super.I();
      }

      public int a(int paramInt)
      {
        return ((Integer)this.i.get(paramInt)).intValue();
      }

      protected a a(p.b paramb)
      {
        return new a(paramb, null);
      }

      public void a(i parami)
        throws IOException
      {
        d();
        if (n().size() > 0)
        {
          parami.p(10);
          parami.p(this.j);
        }
        for (int m = 0; m < this.i.size(); m++)
          parami.b(((Integer)this.i.get(m)).intValue());
        int i1 = p().size();
        int i2 = 0;
        if (i1 > 0)
        {
          parami.p(18);
          parami.p(this.l);
        }
        while (i2 < this.k.size())
        {
          parami.b(((Integer)this.k.get(i2)).intValue());
          i2++;
        }
        if ((0x1 & this.h) == 1)
          parami.a(3, t());
        if ((0x2 & this.h) == 2)
          parami.a(4, w());
        b_().a(parami);
      }

      public final boolean a()
      {
        int m = this.p;
        if (m != -1)
          return m == 1;
        this.p = 1;
        return true;
      }

      public int b(int paramInt)
      {
        return ((Integer)this.k.get(paramInt)).intValue();
      }

      public final P b_()
      {
        return this.g;
      }

      public int d()
      {
        int m = 0;
        int i1 = this.q;
        if (i1 != -1)
          return i1;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.i.size())
        {
          i3 += i.h(((Integer)this.i.get(i2)).intValue());
          i2++;
        }
        int i4 = 0 + i3;
        if (!n().isEmpty());
        for (int i5 = i4 + 1 + i.h(i3); ; i5 = i4)
        {
          this.j = i3;
          int i9;
          for (int i6 = 0; m < this.k.size(); i6 = i9)
          {
            i9 = i6 + i.h(((Integer)this.k.get(m)).intValue());
            m++;
          }
          int i7 = i5 + i6;
          if (!p().isEmpty())
            i7 = i7 + 1 + i.h(i6);
          this.l = i6;
          if ((0x1 & this.h) == 1)
            i7 += i.c(3, t());
          if ((0x2 & this.h) == 2)
            i7 += i.c(4, w());
          int i8 = i7 + b_().d();
          this.q = i8;
          return i8;
        }
      }

      public b i()
      {
        return f;
      }

      protected p.g l()
      {
        return j.O().a(b.class, a.class);
      }

      public B<b> m()
      {
        return a;
      }

      public List<Integer> n()
      {
        return this.i;
      }

      public int o()
      {
        return this.i.size();
      }

      public List<Integer> p()
      {
        return this.k;
      }

      public int q()
      {
        return this.k.size();
      }

      public boolean r()
      {
        return (0x1 & this.h) == 1;
      }

      public String s()
      {
        Object localObject = this.n;
        if ((localObject instanceof String))
          return (String)localObject;
        g localg = (g)localObject;
        String str = localg.h();
        if (localg.i())
          this.n = str;
        return str;
      }

      public g t()
      {
        Object localObject = this.n;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.n = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean u()
      {
        return (0x2 & this.h) == 2;
      }

      public String v()
      {
        Object localObject = this.o;
        if ((localObject instanceof String))
          return (String)localObject;
        g localg = (g)localObject;
        String str = localg.h();
        if (localg.i())
          this.o = str;
        return str;
      }

      public g w()
      {
        Object localObject = this.o;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.o = localg;
          return localg;
        }
        return (g)localObject;
      }

      public a y()
      {
        return x();
      }

      public a z()
      {
        return a(this);
      }

      public static final class a extends p.a<a>
        implements j.E.c
      {
        private int a;
        private List<Integer> b = Collections.emptyList();
        private List<Integer> c = Collections.emptyList();
        private Object d = "";
        private Object e = "";

        private a()
        {
          G();
        }

        private a(p.b paramb)
        {
          super();
          G();
        }

        private void G()
        {
          if (p.m);
        }

        private static a H()
        {
          return new a();
        }

        private void I()
        {
          if ((0x1 & this.a) != 1)
          {
            this.b = new ArrayList(this.b);
            this.a = (0x1 | this.a);
          }
        }

        private void K()
        {
          if ((0x2 & this.a) != 2)
          {
            this.c = new ArrayList(this.c);
            this.a = (0x2 | this.a);
          }
        }

        public static final k.a k()
        {
          return j.N();
        }

        public j.E.b A()
        {
          int i = 1;
          j.E.b localb = new j.E.b(this, null);
          int j = this.a;
          if ((0x1 & this.a) == i)
          {
            this.b = Collections.unmodifiableList(this.b);
            this.a = (0xFFFFFFFE & this.a);
          }
          j.E.b.a(localb, this.b);
          if ((0x2 & this.a) == 2)
          {
            this.c = Collections.unmodifiableList(this.c);
            this.a = (0xFFFFFFFD & this.a);
          }
          j.E.b.b(localb, this.c);
          if ((j & 0x4) == 4);
          while (true)
          {
            j.E.b.a(localb, this.d);
            if ((j & 0x8) == 8)
              i |= 2;
            j.E.b.b(localb, this.e);
            j.E.b.a(localb, i);
            aB();
            return localb;
            i = 0;
          }
        }

        public a B()
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          aF();
          return this;
        }

        public a C()
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          aF();
          return this;
        }

        public a D()
        {
          this.a = (0xFFFFFFFB & this.a);
          this.d = j.E.b.h().s();
          aF();
          return this;
        }

        public a E()
        {
          this.a = (0xFFFFFFF7 & this.a);
          this.e = j.E.b.h().v();
          aF();
          return this;
        }

        public k.a J()
        {
          return j.N();
        }

        public int a(int paramInt)
        {
          return ((Integer)this.b.get(paramInt)).intValue();
        }

        public a a(int paramInt1, int paramInt2)
        {
          I();
          this.b.set(paramInt1, Integer.valueOf(paramInt2));
          aF();
          return this;
        }

        public a a(j.E.b paramb)
        {
          if (paramb == j.E.b.h())
            return this;
          if (!j.E.b.b(paramb).isEmpty())
          {
            if (this.b.isEmpty())
            {
              this.b = j.E.b.b(paramb);
              this.a = (0xFFFFFFFE & this.a);
              aF();
            }
          }
          else if (!j.E.b.c(paramb).isEmpty())
          {
            if (!this.c.isEmpty())
              break label194;
            this.c = j.E.b.c(paramb);
            this.a = (0xFFFFFFFD & this.a);
          }
          while (true)
          {
            aF();
            if (paramb.r())
            {
              this.a = (0x4 | this.a);
              this.d = j.E.b.d(paramb);
              aF();
            }
            if (paramb.u())
            {
              this.a = (0x8 | this.a);
              this.e = j.E.b.e(paramb);
              aF();
            }
            d(paramb.b_());
            return this;
            I();
            this.b.addAll(j.E.b.b(paramb));
            break;
            label194: K();
            this.c.addAll(j.E.b.c(paramb));
          }
        }

        public a a(Iterable<? extends Integer> paramIterable)
        {
          I();
          p.a.a(paramIterable, this.b);
          aF();
          return this;
        }

        public a a(String paramString)
        {
          if (paramString == null)
            throw new NullPointerException();
          this.a = (0x4 | this.a);
          this.d = paramString;
          aF();
          return this;
        }

        public final boolean a()
        {
          return true;
        }

        public int b(int paramInt)
        {
          return ((Integer)this.c.get(paramInt)).intValue();
        }

        public a b(int paramInt1, int paramInt2)
        {
          K();
          this.c.set(paramInt1, Integer.valueOf(paramInt2));
          aF();
          return this;
        }

        public a b(Iterable<? extends Integer> paramIterable)
        {
          K();
          p.a.a(paramIterable, this.c);
          aF();
          return this;
        }

        public a b(String paramString)
        {
          if (paramString == null)
            throw new NullPointerException();
          this.a = (0x8 | this.a);
          this.e = paramString;
          aF();
          return this;
        }

        public a c(int paramInt)
        {
          I();
          this.b.add(Integer.valueOf(paramInt));
          aF();
          return this;
        }

        public a d(int paramInt)
        {
          K();
          this.c.add(Integer.valueOf(paramInt));
          aF();
          return this;
        }

        public a d(x paramx)
        {
          if ((paramx instanceof j.E.b))
            return a((j.E.b)paramx);
          super.a(paramx);
          return this;
        }

        public a e(g paramg)
        {
          if (paramg == null)
            throw new NullPointerException();
          this.a = (0x4 | this.a);
          this.d = paramg;
          aF();
          return this;
        }

        public a e(h paramh, n paramn)
          throws IOException
        {
          try
          {
            j.E.b localb3 = (j.E.b)j.E.b.a.d(paramh, paramn);
            if (localb3 != null)
              a(localb3);
            return this;
          }
          catch (s locals)
          {
            j.E.b localb2 = (j.E.b)locals.a();
            Object localObject1;
            try
            {
              throw locals;
            }
            finally
            {
              localb1 = localb2;
            }
            if (localb1 != null)
              a(localb1);
            throw localObject1;
          }
          finally
          {
            while (true)
              j.E.b localb1 = null;
          }
        }

        public a f(g paramg)
        {
          if (paramg == null)
            throw new NullPointerException();
          this.a = (0x8 | this.a);
          this.e = paramg;
          aF();
          return this;
        }

        protected p.g l()
        {
          return j.O().a(j.E.b.class, a.class);
        }

        public a m()
        {
          super.ah();
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          this.d = "";
          this.a = (0xFFFFFFFB & this.a);
          this.e = "";
          this.a = (0xFFFFFFF7 & this.a);
          return this;
        }

        public List<Integer> n()
        {
          return Collections.unmodifiableList(this.b);
        }

        public int o()
        {
          return this.b.size();
        }

        public List<Integer> p()
        {
          return Collections.unmodifiableList(this.c);
        }

        public int q()
        {
          return this.c.size();
        }

        public boolean r()
        {
          return (0x4 & this.a) == 4;
        }

        public String s()
        {
          Object localObject = this.d;
          if (!(localObject instanceof String))
          {
            String str = ((g)localObject).h();
            this.d = str;
            return str;
          }
          return (String)localObject;
        }

        public g t()
        {
          Object localObject = this.d;
          if ((localObject instanceof String))
          {
            g localg = g.a((String)localObject);
            this.d = localg;
            return localg;
          }
          return (g)localObject;
        }

        public boolean u()
        {
          return (0x8 & this.a) == 8;
        }

        public String v()
        {
          Object localObject = this.e;
          if (!(localObject instanceof String))
          {
            String str = ((g)localObject).h();
            this.e = str;
            return str;
          }
          return (String)localObject;
        }

        public g w()
        {
          Object localObject = this.e;
          if ((localObject instanceof String))
          {
            g localg = g.a((String)localObject);
            this.e = localg;
            return localg;
          }
          return (g)localObject;
        }

        public a x()
        {
          return H().a(A());
        }

        public j.E.b y()
        {
          return j.E.b.h();
        }

        public j.E.b z()
        {
          j.E.b localb = A();
          if (!localb.a())
            throw b(localb);
          return localb;
        }
      }
    }

    public static abstract interface c extends A
    {
      public abstract int a(int paramInt);

      public abstract int b(int paramInt);

      public abstract List<Integer> n();

      public abstract int o();

      public abstract List<Integer> p();

      public abstract int q();

      public abstract boolean r();

      public abstract String s();

      public abstract g t();

      public abstract boolean u();

      public abstract String v();

      public abstract g w();
    }
  }

  public static abstract interface F extends A
  {
    public abstract j.E.b a(int paramInt);

    public abstract j.E.c b(int paramInt);

    public abstract List<j.E.b> n();

    public abstract List<? extends j.E.c> o();

    public abstract int p();
  }

  public static final class G extends p
    implements j.H
  {
    public static B<G> a = new c()
    {
      public j.G c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.G(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    private static final G i = new G(true);
    private static final long v;
    private final P j;
    private int k;
    private List<b> l;
    private Object n;
    private long o;
    private long p;
    private double q;
    private g r;
    private Object s;
    private byte t = -1;
    private int u = -1;

    static
    {
      i.H();
    }

    // ERROR //
    private G(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 69	com/umeng/message/proguard/p:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 71	com/umeng/message/proguard/j$G:t	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 73	com/umeng/message/proguard/j$G:u	I
      //   16: aload_0
      //   17: invokespecial 63	com/umeng/message/proguard/j$G:H	()V
      //   20: invokestatic 78	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +345 -> 374
      //   32: aload_1
      //   33: invokevirtual 83	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+76->116, 0:+367->407, 18:+94->134, 26:+186->226, 32:+226->266, 40:+247->287, 49:+268->308, 58:+290->330, 66:+312->352
      //   117: aload_1
      //   118: aload 4
      //   120: aload_2
      //   121: iload 9
      //   123: invokevirtual 86	com/umeng/message/proguard/j$G:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   126: ifne -98 -> 28
      //   129: iconst_1
      //   130: istore_3
      //   131: goto -103 -> 28
      //   134: iload 5
      //   136: iconst_1
      //   137: iand
      //   138: iconst_1
      //   139: if_icmpeq +20 -> 159
      //   142: aload_0
      //   143: new 88	java/util/ArrayList
      //   146: dup
      //   147: invokespecial 89	java/util/ArrayList:<init>	()V
      //   150: putfield 91	com/umeng/message/proguard/j$G:l	Ljava/util/List;
      //   153: iload 5
      //   155: iconst_1
      //   156: ior
      //   157: istore 5
      //   159: aload_0
      //   160: getfield 91	com/umeng/message/proguard/j$G:l	Ljava/util/List;
      //   163: aload_1
      //   164: getstatic 94	com/umeng/message/proguard/j$G$b:a	Lcom/umeng/message/proguard/B;
      //   167: aload_2
      //   168: invokevirtual 97	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   171: invokeinterface 103 2 0
      //   176: pop
      //   177: goto -149 -> 28
      //   180: astore 8
      //   182: aload 8
      //   184: aload_0
      //   185: invokevirtual 106	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   188: athrow
      //   189: astore 7
      //   191: iload 5
      //   193: iconst_1
      //   194: iand
      //   195: iconst_1
      //   196: if_icmpne +14 -> 210
      //   199: aload_0
      //   200: aload_0
      //   201: getfield 91	com/umeng/message/proguard/j$G:l	Ljava/util/List;
      //   204: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   207: putfield 91	com/umeng/message/proguard/j$G:l	Ljava/util/List;
      //   210: aload_0
      //   211: aload 4
      //   213: invokevirtual 117	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   216: putfield 119	com/umeng/message/proguard/j$G:j	Lcom/umeng/message/proguard/P;
      //   219: aload_0
      //   220: invokevirtual 122	com/umeng/message/proguard/j$G:ad	()V
      //   223: aload 7
      //   225: athrow
      //   226: aload_0
      //   227: iconst_1
      //   228: aload_0
      //   229: getfield 124	com/umeng/message/proguard/j$G:k	I
      //   232: ior
      //   233: putfield 124	com/umeng/message/proguard/j$G:k	I
      //   236: aload_0
      //   237: aload_1
      //   238: invokevirtual 127	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   241: putfield 129	com/umeng/message/proguard/j$G:n	Ljava/lang/Object;
      //   244: goto -216 -> 28
      //   247: astore 6
      //   249: new 66	com/umeng/message/proguard/s
      //   252: dup
      //   253: aload 6
      //   255: invokevirtual 133	java/io/IOException:getMessage	()Ljava/lang/String;
      //   258: invokespecial 136	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   261: aload_0
      //   262: invokevirtual 106	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   265: athrow
      //   266: aload_0
      //   267: iconst_2
      //   268: aload_0
      //   269: getfield 124	com/umeng/message/proguard/j$G:k	I
      //   272: ior
      //   273: putfield 124	com/umeng/message/proguard/j$G:k	I
      //   276: aload_0
      //   277: aload_1
      //   278: invokevirtual 139	com/umeng/message/proguard/h:e	()J
      //   281: putfield 141	com/umeng/message/proguard/j$G:o	J
      //   284: goto -256 -> 28
      //   287: aload_0
      //   288: iconst_4
      //   289: aload_0
      //   290: getfield 124	com/umeng/message/proguard/j$G:k	I
      //   293: ior
      //   294: putfield 124	com/umeng/message/proguard/j$G:k	I
      //   297: aload_0
      //   298: aload_1
      //   299: invokevirtual 143	com/umeng/message/proguard/h:f	()J
      //   302: putfield 145	com/umeng/message/proguard/j$G:p	J
      //   305: goto -277 -> 28
      //   308: aload_0
      //   309: bipush 8
      //   311: aload_0
      //   312: getfield 124	com/umeng/message/proguard/j$G:k	I
      //   315: ior
      //   316: putfield 124	com/umeng/message/proguard/j$G:k	I
      //   319: aload_0
      //   320: aload_1
      //   321: invokevirtual 148	com/umeng/message/proguard/h:c	()D
      //   324: putfield 150	com/umeng/message/proguard/j$G:q	D
      //   327: goto -299 -> 28
      //   330: aload_0
      //   331: bipush 16
      //   333: aload_0
      //   334: getfield 124	com/umeng/message/proguard/j$G:k	I
      //   337: ior
      //   338: putfield 124	com/umeng/message/proguard/j$G:k	I
      //   341: aload_0
      //   342: aload_1
      //   343: invokevirtual 127	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   346: putfield 152	com/umeng/message/proguard/j$G:r	Lcom/umeng/message/proguard/g;
      //   349: goto -321 -> 28
      //   352: aload_0
      //   353: bipush 32
      //   355: aload_0
      //   356: getfield 124	com/umeng/message/proguard/j$G:k	I
      //   359: ior
      //   360: putfield 124	com/umeng/message/proguard/j$G:k	I
      //   363: aload_0
      //   364: aload_1
      //   365: invokevirtual 127	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   368: putfield 154	com/umeng/message/proguard/j$G:s	Ljava/lang/Object;
      //   371: goto -343 -> 28
      //   374: iload 5
      //   376: iconst_1
      //   377: iand
      //   378: iconst_1
      //   379: if_icmpne +14 -> 393
      //   382: aload_0
      //   383: aload_0
      //   384: getfield 91	com/umeng/message/proguard/j$G:l	Ljava/util/List;
      //   387: invokestatic 112	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   390: putfield 91	com/umeng/message/proguard/j$G:l	Ljava/util/List;
      //   393: aload_0
      //   394: aload 4
      //   396: invokevirtual 117	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   399: putfield 119	com/umeng/message/proguard/j$G:j	Lcom/umeng/message/proguard/P;
      //   402: aload_0
      //   403: invokevirtual 122	com/umeng/message/proguard/j$G:ad	()V
      //   406: return
      //   407: iconst_1
      //   408: istore_3
      //   409: goto -381 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	180	com/umeng/message/proguard/s
      //   116	129	180	com/umeng/message/proguard/s
      //   142	153	180	com/umeng/message/proguard/s
      //   159	177	180	com/umeng/message/proguard/s
      //   226	244	180	com/umeng/message/proguard/s
      //   266	284	180	com/umeng/message/proguard/s
      //   287	305	180	com/umeng/message/proguard/s
      //   308	327	180	com/umeng/message/proguard/s
      //   330	349	180	com/umeng/message/proguard/s
      //   352	371	180	com/umeng/message/proguard/s
      //   32	38	189	finally
      //   116	129	189	finally
      //   142	153	189	finally
      //   159	177	189	finally
      //   182	189	189	finally
      //   226	244	189	finally
      //   249	266	189	finally
      //   266	284	189	finally
      //   287	305	189	finally
      //   308	327	189	finally
      //   330	349	189	finally
      //   352	371	189	finally
      //   32	38	247	java/io/IOException
      //   116	129	247	java/io/IOException
      //   142	153	247	java/io/IOException
      //   159	177	247	java/io/IOException
      //   226	244	247	java/io/IOException
      //   266	284	247	java/io/IOException
      //   287	305	247	java/io/IOException
      //   308	327	247	java/io/IOException
      //   330	349	247	java/io/IOException
      //   352	371	247	java/io/IOException
    }

    private G(p.a<?> parama)
    {
      super();
      this.j = parama.b_();
    }

    private G(boolean paramBoolean)
    {
      this.j = P.c();
    }

    public static a E()
    {
      return a.U();
    }

    private void H()
    {
      this.l = Collections.emptyList();
      this.n = "";
      this.o = 0L;
      this.p = 0L;
      this.q = 0.0D;
      this.r = g.d;
      this.s = "";
    }

    public static a a(G paramG)
    {
      return E().a(paramG);
    }

    public static G a(g paramg)
      throws s
    {
      return (G)a.d(paramg);
    }

    public static G a(g paramg, n paramn)
      throws s
    {
      return (G)a.d(paramg, paramn);
    }

    public static G a(h paramh)
      throws IOException
    {
      return (G)a.d(paramh);
    }

    public static G a(h paramh, n paramn)
      throws IOException
    {
      return (G)a.b(paramh, paramn);
    }

    public static G a(InputStream paramInputStream)
      throws IOException
    {
      return (G)a.h(paramInputStream);
    }

    public static G a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (G)a.h(paramInputStream, paramn);
    }

    public static G a(byte[] paramArrayOfByte)
      throws s
    {
      return (G)a.d(paramArrayOfByte);
    }

    public static G a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (G)a.d(paramArrayOfByte, paramn);
    }

    public static G b(InputStream paramInputStream)
      throws IOException
    {
      return (G)a.f(paramInputStream);
    }

    public static G b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (G)a.f(paramInputStream, paramn);
    }

    public static G h()
    {
      return i;
    }

    public static final k.a k()
    {
      return j.H();
    }

    public g A()
    {
      return this.r;
    }

    public boolean B()
    {
      return (0x20 & this.k) == 32;
    }

    public String C()
    {
      Object localObject = this.s;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.s = str;
      return str;
    }

    public g D()
    {
      Object localObject = this.s;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.s = localg;
        return localg;
      }
      return (g)localObject;
    }

    public a F()
    {
      return E();
    }

    public a G()
    {
      return a(this);
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public b a(int paramInt)
    {
      return (b)this.l.get(paramInt);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      for (int m = 0; m < this.l.size(); m++)
        parami.c(2, (y)this.l.get(m));
      if ((0x1 & this.k) == 1)
        parami.a(3, s());
      if ((0x2 & this.k) == 2)
        parami.a(4, this.o);
      if ((0x4 & this.k) == 4)
        parami.b(5, this.p);
      if ((0x8 & this.k) == 8)
        parami.a(6, this.q);
      if ((0x10 & this.k) == 16)
        parami.a(7, this.r);
      if ((0x20 & this.k) == 32)
        parami.a(8, D());
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.t;
      if (m != -1)
        return m == 1;
      for (int i1 = 0; i1 < p(); i1++)
        if (!a(i1).a())
        {
          this.t = 0;
          return false;
        }
      this.t = 1;
      return true;
    }

    public c b(int paramInt)
    {
      return (c)this.l.get(paramInt);
    }

    public final P b_()
    {
      return this.j;
    }

    public int d()
    {
      int m = this.u;
      if (m != -1)
        return m;
      int i1 = 0;
      int i2 = 0;
      while (i1 < this.l.size())
      {
        i2 += i.g(2, (y)this.l.get(i1));
        i1++;
      }
      if ((0x1 & this.k) == 1)
        i2 += i.c(3, s());
      if ((0x2 & this.k) == 2)
        i2 += i.f(4, this.o);
      if ((0x4 & this.k) == 4)
        i2 += i.g(5, this.p);
      if ((0x8 & this.k) == 8)
        i2 += i.b(6, this.q);
      if ((0x10 & this.k) == 16)
        i2 += i.c(7, this.r);
      if ((0x20 & this.k) == 32)
        i2 += i.c(8, D());
      int i3 = i2 + b_().d();
      this.u = i3;
      return i3;
    }

    public G i()
    {
      return i;
    }

    protected p.g l()
    {
      return j.I().a(G.class, a.class);
    }

    public B<G> m()
    {
      return a;
    }

    public List<b> n()
    {
      return this.l;
    }

    public List<? extends c> o()
    {
      return this.l;
    }

    public int p()
    {
      return this.l.size();
    }

    public boolean q()
    {
      return (0x1 & this.k) == 1;
    }

    public String r()
    {
      Object localObject = this.n;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.n = str;
      return str;
    }

    public g s()
    {
      Object localObject = this.n;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.n = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean t()
    {
      return (0x2 & this.k) == 2;
    }

    public long u()
    {
      return this.o;
    }

    public boolean v()
    {
      return (0x4 & this.k) == 4;
    }

    public long w()
    {
      return this.p;
    }

    public boolean x()
    {
      return (0x8 & this.k) == 8;
    }

    public double y()
    {
      return this.q;
    }

    public boolean z()
    {
      return (0x10 & this.k) == 16;
    }

    public static final class a extends p.a<a>
      implements j.H
    {
      private int a;
      private List<j.G.b> b = Collections.emptyList();
      private D<j.G.b, j.G.b.a, j.G.c> c;
      private Object d = "";
      private long e;
      private long f;
      private double g;
      private g h = g.d;
      private Object i = "";

      private a()
      {
        V();
      }

      private a(p.b paramb)
      {
        super();
        V();
      }

      private void V()
      {
        if (p.m)
          Y();
      }

      private static a W()
      {
        return new a();
      }

      private void X()
      {
        if ((0x1 & this.a) != 1)
        {
          this.b = new ArrayList(this.b);
          this.a = (0x1 | this.a);
        }
      }

      private D<j.G.b, j.G.b.a, j.G.c> Y()
      {
        int j = 1;
        List localList;
        if (this.c == null)
        {
          localList = this.b;
          if ((0x1 & this.a) != j)
            break label55;
        }
        while (true)
        {
          this.c = new D(localList, j, aE(), aD());
          this.b = null;
          return this.c;
          label55: int k = 0;
        }
      }

      public static final k.a k()
      {
        return j.H();
      }

      public g A()
      {
        return this.h;
      }

      public boolean B()
      {
        return (0x40 & this.a) == 64;
      }

      public String C()
      {
        Object localObject = this.i;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.i = str;
          return str;
        }
        return (String)localObject;
      }

      public g D()
      {
        Object localObject = this.i;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.i = localg;
          return localg;
        }
        return (g)localObject;
      }

      public a E()
      {
        return W().a(H());
      }

      public j.G F()
      {
        return j.G.h();
      }

      public j.G G()
      {
        j.G localG = H();
        if (!localG.a())
          throw b(localG);
        return localG;
      }

      public j.G H()
      {
        int j = 1;
        j.G localG = new j.G(this, null);
        int k = this.a;
        if (this.c == null)
        {
          if ((0x1 & this.a) == j)
          {
            this.b = Collections.unmodifiableList(this.b);
            this.a = (0xFFFFFFFE & this.a);
          }
          j.G.a(localG, this.b);
          if ((k & 0x2) != 2)
            break label219;
        }
        while (true)
        {
          j.G.a(localG, this.d);
          if ((k & 0x4) == 4)
            j |= 2;
          j.G.a(localG, this.e);
          if ((k & 0x8) == 8)
            j |= 4;
          j.G.b(localG, this.f);
          if ((k & 0x10) == 16)
            j |= 8;
          j.G.a(localG, this.g);
          if ((k & 0x20) == 32)
            j |= 16;
          j.G.a(localG, this.h);
          if ((k & 0x40) == 64)
            j |= 32;
          j.G.b(localG, this.i);
          j.G.a(localG, j);
          aB();
          return localG;
          j.G.a(localG, this.c.f());
          break;
          label219: j = 0;
        }
      }

      public a I()
      {
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          aF();
          return this;
        }
        this.c.e();
        return this;
      }

      public k.a J()
      {
        return j.H();
      }

      public j.G.b.a K()
      {
        return (j.G.b.a)Y().b(j.G.b.h());
      }

      public List<j.G.b.a> L()
      {
        return Y().h();
      }

      public a M()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.d = j.G.h().r();
        aF();
        return this;
      }

      public a N()
      {
        this.a = (0xFFFFFFFB & this.a);
        this.e = 0L;
        aF();
        return this;
      }

      public a O()
      {
        this.a = (0xFFFFFFF7 & this.a);
        this.f = 0L;
        aF();
        return this;
      }

      public a P()
      {
        this.a = (0xFFFFFFEF & this.a);
        this.g = 0.0D;
        aF();
        return this;
      }

      public a S()
      {
        this.a = (0xFFFFFFDF & this.a);
        this.h = j.G.h().A();
        aF();
        return this;
      }

      public a T()
      {
        this.a = (0xFFFFFFBF & this.a);
        this.i = j.G.h().C();
        aF();
        return this;
      }

      public a a(double paramDouble)
      {
        this.a = (0x10 | this.a);
        this.g = paramDouble;
        aF();
        return this;
      }

      public a a(int paramInt, j.G.b.a parama)
      {
        if (this.c == null)
        {
          X();
          this.b.set(paramInt, parama.u());
          aF();
          return this;
        }
        this.c.a(paramInt, parama.u());
        return this;
      }

      public a a(int paramInt, j.G.b paramb)
      {
        if (this.c == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          X();
          this.b.set(paramInt, paramb);
          aF();
          return this;
        }
        this.c.a(paramInt, paramb);
        return this;
      }

      public a a(long paramLong)
      {
        this.a = (0x4 | this.a);
        this.e = paramLong;
        aF();
        return this;
      }

      public a a(j.G.b.a parama)
      {
        if (this.c == null)
        {
          X();
          this.b.add(parama.u());
          aF();
          return this;
        }
        this.c.a(parama.u());
        return this;
      }

      public a a(j.G.b paramb)
      {
        if (this.c == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          X();
          this.b.add(paramb);
          aF();
          return this;
        }
        this.c.a(paramb);
        return this;
      }

      public a a(j.G paramG)
      {
        if (paramG == j.G.h())
          return this;
        if (this.c == null)
          if (!j.G.b(paramG).isEmpty())
          {
            if (!this.b.isEmpty())
              break label197;
            this.b = j.G.b(paramG);
            this.a = (0xFFFFFFFE & this.a);
            aF();
          }
        while (true)
        {
          if (paramG.q())
          {
            this.a = (0x2 | this.a);
            this.d = j.G.c(paramG);
            aF();
          }
          if (paramG.t())
            a(paramG.u());
          if (paramG.v())
            b(paramG.w());
          if (paramG.x())
            a(paramG.y());
          if (paramG.z())
            f(paramG.A());
          if (paramG.B())
          {
            this.a = (0x40 | this.a);
            this.i = j.G.d(paramG);
            aF();
          }
          d(paramG.b_());
          return this;
          label197: X();
          this.b.addAll(j.G.b(paramG));
          break;
          if (!j.G.b(paramG).isEmpty())
            if (this.c.d())
            {
              this.c.b();
              this.c = null;
              this.b = j.G.b(paramG);
              this.a = (0xFFFFFFFE & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = Y();
              this.c = localD;
            }
            else
            {
              this.c.a(j.G.b(paramG));
            }
        }
      }

      public a a(Iterable<? extends j.G.b> paramIterable)
      {
        if (this.c == null)
        {
          X();
          p.a.a(paramIterable, this.b);
          aF();
          return this;
        }
        this.c.a(paramIterable);
        return this;
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.d = paramString;
        aF();
        return this;
      }

      public j.G.b a(int paramInt)
      {
        if (this.c == null)
          return (j.G.b)this.b.get(paramInt);
        return (j.G.b)this.c.a(paramInt);
      }

      public final boolean a()
      {
        for (int j = 0; j < p(); j++)
          if (!a(j).a())
            return false;
        return true;
      }

      public a b(int paramInt, j.G.b.a parama)
      {
        if (this.c == null)
        {
          X();
          this.b.add(paramInt, parama.u());
          aF();
          return this;
        }
        this.c.b(paramInt, parama.u());
        return this;
      }

      public a b(int paramInt, j.G.b paramb)
      {
        if (this.c == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          X();
          this.b.add(paramInt, paramb);
          aF();
          return this;
        }
        this.c.b(paramInt, paramb);
        return this;
      }

      public a b(long paramLong)
      {
        this.a = (0x8 | this.a);
        this.f = paramLong;
        aF();
        return this;
      }

      public a b(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x40 | this.a);
        this.i = paramString;
        aF();
        return this;
      }

      public j.G.c b(int paramInt)
      {
        if (this.c == null)
          return (j.G.c)this.b.get(paramInt);
        return (j.G.c)this.c.c(paramInt);
      }

      public a c(int paramInt)
      {
        if (this.c == null)
        {
          X();
          this.b.remove(paramInt);
          aF();
          return this;
        }
        this.c.d(paramInt);
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.G))
          return a((j.G)paramx);
        super.a(paramx);
        return this;
      }

      public j.G.b.a d(int paramInt)
      {
        return (j.G.b.a)Y().b(paramInt);
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.d = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.G localG3 = (j.G)j.G.a.d(paramh, paramn);
          if (localG3 != null)
            a(localG3);
          return this;
        }
        catch (s locals)
        {
          j.G localG2 = (j.G)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localG1 = localG2;
          }
          if (localG1 != null)
            a(localG1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.G localG1 = null;
        }
      }

      public j.G.b.a e(int paramInt)
      {
        return (j.G.b.a)Y().c(paramInt, j.G.b.h());
      }

      public a f(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x20 | this.a);
        this.h = paramg;
        aF();
        return this;
      }

      public a g(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x40 | this.a);
        this.i = paramg;
        aF();
        return this;
      }

      protected p.g l()
      {
        return j.I().a(j.G.class, a.class);
      }

      public a m()
      {
        super.ah();
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
        }
        while (true)
        {
          this.d = "";
          this.a = (0xFFFFFFFD & this.a);
          this.e = 0L;
          this.a = (0xFFFFFFFB & this.a);
          this.f = 0L;
          this.a = (0xFFFFFFF7 & this.a);
          this.g = 0.0D;
          this.a = (0xFFFFFFEF & this.a);
          this.h = g.d;
          this.a = (0xFFFFFFDF & this.a);
          this.i = "";
          this.a = (0xFFFFFFBF & this.a);
          return this;
          this.c.e();
        }
      }

      public List<j.G.b> n()
      {
        if (this.c == null)
          return Collections.unmodifiableList(this.b);
        return this.c.g();
      }

      public List<? extends j.G.c> o()
      {
        if (this.c != null)
          return this.c.i();
        return Collections.unmodifiableList(this.b);
      }

      public int p()
      {
        if (this.c == null)
          return this.b.size();
        return this.c.c();
      }

      public boolean q()
      {
        return (0x2 & this.a) == 2;
      }

      public String r()
      {
        Object localObject = this.d;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.d = str;
          return str;
        }
        return (String)localObject;
      }

      public g s()
      {
        Object localObject = this.d;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.d = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean t()
      {
        return (0x4 & this.a) == 4;
      }

      public long u()
      {
        return this.e;
      }

      public boolean v()
      {
        return (0x8 & this.a) == 8;
      }

      public long w()
      {
        return this.f;
      }

      public boolean x()
      {
        return (0x10 & this.a) == 16;
      }

      public double y()
      {
        return this.g;
      }

      public boolean z()
      {
        return (0x20 & this.a) == 32;
      }
    }

    public static final class b extends p
      implements j.G.c
    {
      public static B<b> a = new c()
      {
        public j.G.b c(h paramAnonymoush, n paramAnonymousn)
          throws s
        {
          return new j.G.b(paramAnonymoush, paramAnonymousn, null);
        }
      };
      public static final int b = 1;
      public static final int c = 2;
      private static final b d = new b(true);
      private static final long k;
      private final P e;
      private int f;
      private Object g;
      private boolean h;
      private byte i = -1;
      private int j = -1;

      static
      {
        d.v();
      }

      // ERROR //
      private b(h paramh, n paramn)
        throws s
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 51	com/umeng/message/proguard/p:<init>	()V
        //   4: aload_0
        //   5: iconst_m1
        //   6: putfield 53	com/umeng/message/proguard/j$G$b:i	B
        //   9: aload_0
        //   10: iconst_m1
        //   11: putfield 55	com/umeng/message/proguard/j$G$b:j	I
        //   14: aload_0
        //   15: invokespecial 45	com/umeng/message/proguard/j$G$b:v	()V
        //   18: invokestatic 60	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
        //   21: astore_3
        //   22: iconst_0
        //   23: istore 4
        //   25: iload 4
        //   27: ifne +150 -> 177
        //   30: aload_1
        //   31: invokevirtual 65	com/umeng/message/proguard/h:a	()I
        //   34: istore 8
        //   36: iload 8
        //   38: lookupswitch	default:+34->72, 0:+152->190, 10:+52->90, 16:+99->137
        //   73: aload_1
        //   74: aload_3
        //   75: aload_2
        //   76: iload 8
        //   78: invokevirtual 68	com/umeng/message/proguard/j$G$b:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
        //   81: ifne -56 -> 25
        //   84: iconst_1
        //   85: istore 4
        //   87: goto -62 -> 25
        //   90: aload_0
        //   91: iconst_1
        //   92: aload_0
        //   93: getfield 70	com/umeng/message/proguard/j$G$b:f	I
        //   96: ior
        //   97: putfield 70	com/umeng/message/proguard/j$G$b:f	I
        //   100: aload_0
        //   101: aload_1
        //   102: invokevirtual 74	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
        //   105: putfield 76	com/umeng/message/proguard/j$G$b:g	Ljava/lang/Object;
        //   108: goto -83 -> 25
        //   111: astore 7
        //   113: aload 7
        //   115: aload_0
        //   116: invokevirtual 79	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
        //   119: athrow
        //   120: astore 6
        //   122: aload_0
        //   123: aload_3
        //   124: invokevirtual 84	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
        //   127: putfield 86	com/umeng/message/proguard/j$G$b:e	Lcom/umeng/message/proguard/P;
        //   130: aload_0
        //   131: invokevirtual 89	com/umeng/message/proguard/j$G$b:ad	()V
        //   134: aload 6
        //   136: athrow
        //   137: aload_0
        //   138: iconst_2
        //   139: aload_0
        //   140: getfield 70	com/umeng/message/proguard/j$G$b:f	I
        //   143: ior
        //   144: putfield 70	com/umeng/message/proguard/j$G$b:f	I
        //   147: aload_0
        //   148: aload_1
        //   149: invokevirtual 92	com/umeng/message/proguard/h:j	()Z
        //   152: putfield 94	com/umeng/message/proguard/j$G$b:h	Z
        //   155: goto -130 -> 25
        //   158: astore 5
        //   160: new 48	com/umeng/message/proguard/s
        //   163: dup
        //   164: aload 5
        //   166: invokevirtual 98	java/io/IOException:getMessage	()Ljava/lang/String;
        //   169: invokespecial 101	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
        //   172: aload_0
        //   173: invokevirtual 79	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
        //   176: athrow
        //   177: aload_0
        //   178: aload_3
        //   179: invokevirtual 84	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
        //   182: putfield 86	com/umeng/message/proguard/j$G$b:e	Lcom/umeng/message/proguard/P;
        //   185: aload_0
        //   186: invokevirtual 89	com/umeng/message/proguard/j$G$b:ad	()V
        //   189: return
        //   190: iconst_1
        //   191: istore 4
        //   193: goto -168 -> 25
        //
        // Exception table:
        //   from	to	target	type
        //   30	36	111	com/umeng/message/proguard/s
        //   72	84	111	com/umeng/message/proguard/s
        //   90	108	111	com/umeng/message/proguard/s
        //   137	155	111	com/umeng/message/proguard/s
        //   30	36	120	finally
        //   72	84	120	finally
        //   90	108	120	finally
        //   113	120	120	finally
        //   137	155	120	finally
        //   160	177	120	finally
        //   30	36	158	java/io/IOException
        //   72	84	158	java/io/IOException
        //   90	108	158	java/io/IOException
        //   137	155	158	java/io/IOException
      }

      private b(p.a<?> parama)
      {
        super();
        this.e = parama.b_();
      }

      private b(boolean paramBoolean)
      {
        this.e = P.c();
      }

      public static a a(b paramb)
      {
        return s().a(paramb);
      }

      public static b a(g paramg)
        throws s
      {
        return (b)a.d(paramg);
      }

      public static b a(g paramg, n paramn)
        throws s
      {
        return (b)a.d(paramg, paramn);
      }

      public static b a(h paramh)
        throws IOException
      {
        return (b)a.d(paramh);
      }

      public static b a(h paramh, n paramn)
        throws IOException
      {
        return (b)a.b(paramh, paramn);
      }

      public static b a(InputStream paramInputStream)
        throws IOException
      {
        return (b)a.h(paramInputStream);
      }

      public static b a(InputStream paramInputStream, n paramn)
        throws IOException
      {
        return (b)a.h(paramInputStream, paramn);
      }

      public static b a(byte[] paramArrayOfByte)
        throws s
      {
        return (b)a.d(paramArrayOfByte);
      }

      public static b a(byte[] paramArrayOfByte, n paramn)
        throws s
      {
        return (b)a.d(paramArrayOfByte, paramn);
      }

      public static b b(InputStream paramInputStream)
        throws IOException
      {
        return (b)a.f(paramInputStream);
      }

      public static b b(InputStream paramInputStream, n paramn)
        throws IOException
      {
        return (b)a.f(paramInputStream, paramn);
      }

      public static b h()
      {
        return d;
      }

      public static final k.a k()
      {
        return j.J();
      }

      public static a s()
      {
        return a.y();
      }

      private void v()
      {
        this.g = "";
        this.h = false;
      }

      protected Object I()
        throws ObjectStreamException
      {
        return super.I();
      }

      protected a a(p.b paramb)
      {
        return new a(paramb, null);
      }

      public void a(i parami)
        throws IOException
      {
        d();
        if ((0x1 & this.f) == 1)
          parami.a(1, p());
        if ((0x2 & this.f) == 2)
          parami.a(2, this.h);
        b_().a(parami);
      }

      public final boolean a()
      {
        int m = this.i;
        if (m != -1)
          return m == 1;
        if (!n())
        {
          this.i = 0;
          return false;
        }
        if (!q())
        {
          this.i = 0;
          return false;
        }
        this.i = 1;
        return true;
      }

      public final P b_()
      {
        return this.e;
      }

      public int d()
      {
        int m = this.j;
        if (m != -1)
          return m;
        int n = 0x1 & this.f;
        int i1 = 0;
        if (n == 1)
          i1 = 0 + i.c(1, p());
        if ((0x2 & this.f) == 2)
          i1 += i.b(2, this.h);
        int i2 = i1 + b_().d();
        this.j = i2;
        return i2;
      }

      public b i()
      {
        return d;
      }

      protected p.g l()
      {
        return j.K().a(b.class, a.class);
      }

      public B<b> m()
      {
        return a;
      }

      public boolean n()
      {
        return (0x1 & this.f) == 1;
      }

      public String o()
      {
        Object localObject = this.g;
        if ((localObject instanceof String))
          return (String)localObject;
        g localg = (g)localObject;
        String str = localg.h();
        if (localg.i())
          this.g = str;
        return str;
      }

      public g p()
      {
        Object localObject = this.g;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.g = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean q()
      {
        return (0x2 & this.f) == 2;
      }

      public boolean r()
      {
        return this.h;
      }

      public a t()
      {
        return s();
      }

      public a u()
      {
        return a(this);
      }

      public static final class a extends p.a<a>
        implements j.G.c
      {
        private int a;
        private Object b = "";
        private boolean c;

        private a()
        {
          z();
        }

        private a(p.b paramb)
        {
          super();
          z();
        }

        private static a A()
        {
          return new a();
        }

        public static final k.a k()
        {
          return j.J();
        }

        private void z()
        {
          if (p.m);
        }

        public k.a J()
        {
          return j.J();
        }

        public a a(j.G.b paramb)
        {
          if (paramb == j.G.b.h())
            return this;
          if (paramb.n())
          {
            this.a = (0x1 | this.a);
            this.b = j.G.b.b(paramb);
            aF();
          }
          if (paramb.q())
            a(paramb.r());
          d(paramb.b_());
          return this;
        }

        public a a(String paramString)
        {
          if (paramString == null)
            throw new NullPointerException();
          this.a = (0x1 | this.a);
          this.b = paramString;
          aF();
          return this;
        }

        public a a(boolean paramBoolean)
        {
          this.a = (0x2 | this.a);
          this.c = paramBoolean;
          aF();
          return this;
        }

        public final boolean a()
        {
          if (!n());
          while (!q())
            return false;
          return true;
        }

        public a d(x paramx)
        {
          if ((paramx instanceof j.G.b))
            return a((j.G.b)paramx);
          super.a(paramx);
          return this;
        }

        public a e(g paramg)
        {
          if (paramg == null)
            throw new NullPointerException();
          this.a = (0x1 | this.a);
          this.b = paramg;
          aF();
          return this;
        }

        public a e(h paramh, n paramn)
          throws IOException
        {
          try
          {
            j.G.b localb3 = (j.G.b)j.G.b.a.d(paramh, paramn);
            if (localb3 != null)
              a(localb3);
            return this;
          }
          catch (s locals)
          {
            j.G.b localb2 = (j.G.b)locals.a();
            Object localObject1;
            try
            {
              throw locals;
            }
            finally
            {
              localb1 = localb2;
            }
            if (localb1 != null)
              a(localb1);
            throw localObject1;
          }
          finally
          {
            while (true)
              j.G.b localb1 = null;
          }
        }

        protected p.g l()
        {
          return j.K().a(j.G.b.class, a.class);
        }

        public a m()
        {
          super.ah();
          this.b = "";
          this.a = (0xFFFFFFFE & this.a);
          this.c = false;
          this.a = (0xFFFFFFFD & this.a);
          return this;
        }

        public boolean n()
        {
          return (0x1 & this.a) == 1;
        }

        public String o()
        {
          Object localObject = this.b;
          if (!(localObject instanceof String))
          {
            String str = ((g)localObject).h();
            this.b = str;
            return str;
          }
          return (String)localObject;
        }

        public g p()
        {
          Object localObject = this.b;
          if ((localObject instanceof String))
          {
            g localg = g.a((String)localObject);
            this.b = localg;
            return localg;
          }
          return (g)localObject;
        }

        public boolean q()
        {
          return (0x2 & this.a) == 2;
        }

        public boolean r()
        {
          return this.c;
        }

        public a s()
        {
          return A().a(v());
        }

        public j.G.b t()
        {
          return j.G.b.h();
        }

        public j.G.b u()
        {
          j.G.b localb = v();
          if (!localb.a())
            throw b(localb);
          return localb;
        }

        public j.G.b v()
        {
          int i = 1;
          j.G.b localb = new j.G.b(this, null);
          int j = this.a;
          if ((j & 0x1) == i);
          while (true)
          {
            j.G.b.a(localb, this.b);
            if ((j & 0x2) == 2)
              i |= 2;
            j.G.b.a(localb, this.c);
            j.G.b.a(localb, i);
            aB();
            return localb;
            i = 0;
          }
        }

        public a w()
        {
          this.a = (0xFFFFFFFE & this.a);
          this.b = j.G.b.h().o();
          aF();
          return this;
        }

        public a x()
        {
          this.a = (0xFFFFFFFD & this.a);
          this.c = false;
          aF();
          return this;
        }
      }
    }

    public static abstract interface c extends A
    {
      public abstract boolean n();

      public abstract String o();

      public abstract g p();

      public abstract boolean q();

      public abstract boolean r();
    }
  }

  public static abstract interface H extends A
  {
    public abstract g A();

    public abstract boolean B();

    public abstract String C();

    public abstract g D();

    public abstract j.G.b a(int paramInt);

    public abstract j.G.c b(int paramInt);

    public abstract List<j.G.b> n();

    public abstract List<? extends j.G.c> o();

    public abstract int p();

    public abstract boolean q();

    public abstract String r();

    public abstract g s();

    public abstract boolean t();

    public abstract long u();

    public abstract boolean v();

    public abstract long w();

    public abstract boolean x();

    public abstract double y();

    public abstract boolean z();
  }

  public static final class a extends p
    implements j.b
  {
    public static B<a> a = new c()
    {
      public j.a c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.a(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 6;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 5;
    public static final int h = 7;
    private static final a i = new a(true);
    private static final long v;
    private final P j;
    private int k;
    private Object l;
    private List<j.k> n;
    private List<j.k> o;
    private List<a> p;
    private List<j.c> q;
    private List<b> r;
    private j.u s;
    private byte t = -1;
    private int u = -1;

    static
    {
      i.S();
    }

    // ERROR //
    private a(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 71	com/umeng/message/proguard/p:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 73	com/umeng/message/proguard/j$a:t	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 75	com/umeng/message/proguard/j$a:u	I
      //   14: aload_0
      //   15: invokespecial 65	com/umeng/message/proguard/j$a:S	()V
      //   18: iconst_0
      //   19: istore_3
      //   20: invokestatic 80	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload 5
      //   30: ifne +645 -> 675
      //   33: aload_1
      //   34: invokevirtual 85	com/umeng/message/proguard/h:a	()I
      //   37: istore 9
      //   39: iload 9
      //   41: lookupswitch	default:+75->116, 0:+833->874, 10:+97->138, 18:+125->166, 26:+181->222, 34:+240->281, 42:+299->340, 50:+358->399, 58:+414->455
      //   117: aload_1
      //   118: aload 4
      //   120: aload_2
      //   121: iload 9
      //   123: invokevirtual 88	com/umeng/message/proguard/j$a:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   126: ifne +731 -> 857
      //   129: iconst_1
      //   130: istore 12
      //   132: iload_3
      //   133: istore 13
      //   135: goto +729 -> 864
      //   138: aload_0
      //   139: iconst_1
      //   140: aload_0
      //   141: getfield 90	com/umeng/message/proguard/j$a:k	I
      //   144: ior
      //   145: putfield 90	com/umeng/message/proguard/j$a:k	I
      //   148: aload_0
      //   149: aload_1
      //   150: invokevirtual 93	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   153: putfield 95	com/umeng/message/proguard/j$a:l	Ljava/lang/Object;
      //   156: iload 5
      //   158: istore 12
      //   160: iload_3
      //   161: istore 13
      //   163: goto +701 -> 864
      //   166: iload_3
      //   167: iconst_2
      //   168: iand
      //   169: iconst_2
      //   170: if_icmpeq +681 -> 851
      //   173: aload_0
      //   174: new 97	java/util/ArrayList
      //   177: dup
      //   178: invokespecial 98	java/util/ArrayList:<init>	()V
      //   181: putfield 100	com/umeng/message/proguard/j$a:n	Ljava/util/List;
      //   184: iload_3
      //   185: iconst_2
      //   186: ior
      //   187: istore 14
      //   189: aload_0
      //   190: getfield 100	com/umeng/message/proguard/j$a:n	Ljava/util/List;
      //   193: aload_1
      //   194: getstatic 103	com/umeng/message/proguard/j$k:a	Lcom/umeng/message/proguard/B;
      //   197: aload_2
      //   198: invokevirtual 106	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   201: invokeinterface 112 2 0
      //   206: pop
      //   207: iload 5
      //   209: istore 27
      //   211: iload 14
      //   213: istore 13
      //   215: iload 27
      //   217: istore 12
      //   219: goto +645 -> 864
      //   222: iload_3
      //   223: bipush 8
      //   225: iand
      //   226: bipush 8
      //   228: if_icmpeq +617 -> 845
      //   231: aload_0
      //   232: new 97	java/util/ArrayList
      //   235: dup
      //   236: invokespecial 98	java/util/ArrayList:<init>	()V
      //   239: putfield 114	com/umeng/message/proguard/j$a:p	Ljava/util/List;
      //   242: iload_3
      //   243: bipush 8
      //   245: ior
      //   246: istore 14
      //   248: aload_0
      //   249: getfield 114	com/umeng/message/proguard/j$a:p	Ljava/util/List;
      //   252: aload_1
      //   253: getstatic 57	com/umeng/message/proguard/j$a:a	Lcom/umeng/message/proguard/B;
      //   256: aload_2
      //   257: invokevirtual 106	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   260: invokeinterface 112 2 0
      //   265: pop
      //   266: iload 5
      //   268: istore 25
      //   270: iload 14
      //   272: istore 13
      //   274: iload 25
      //   276: istore 12
      //   278: goto +586 -> 864
      //   281: iload_3
      //   282: bipush 16
      //   284: iand
      //   285: bipush 16
      //   287: if_icmpeq +552 -> 839
      //   290: aload_0
      //   291: new 97	java/util/ArrayList
      //   294: dup
      //   295: invokespecial 98	java/util/ArrayList:<init>	()V
      //   298: putfield 116	com/umeng/message/proguard/j$a:q	Ljava/util/List;
      //   301: iload_3
      //   302: bipush 16
      //   304: ior
      //   305: istore 14
      //   307: aload_0
      //   308: getfield 116	com/umeng/message/proguard/j$a:q	Ljava/util/List;
      //   311: aload_1
      //   312: getstatic 119	com/umeng/message/proguard/j$c:a	Lcom/umeng/message/proguard/B;
      //   315: aload_2
      //   316: invokevirtual 106	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   319: invokeinterface 112 2 0
      //   324: pop
      //   325: iload 5
      //   327: istore 23
      //   329: iload 14
      //   331: istore 13
      //   333: iload 23
      //   335: istore 12
      //   337: goto +527 -> 864
      //   340: iload_3
      //   341: bipush 32
      //   343: iand
      //   344: bipush 32
      //   346: if_icmpeq +487 -> 833
      //   349: aload_0
      //   350: new 97	java/util/ArrayList
      //   353: dup
      //   354: invokespecial 98	java/util/ArrayList:<init>	()V
      //   357: putfield 121	com/umeng/message/proguard/j$a:r	Ljava/util/List;
      //   360: iload_3
      //   361: bipush 32
      //   363: ior
      //   364: istore 14
      //   366: aload_0
      //   367: getfield 121	com/umeng/message/proguard/j$a:r	Ljava/util/List;
      //   370: aload_1
      //   371: getstatic 124	com/umeng/message/proguard/j$a$b:a	Lcom/umeng/message/proguard/B;
      //   374: aload_2
      //   375: invokevirtual 106	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   378: invokeinterface 112 2 0
      //   383: pop
      //   384: iload 5
      //   386: istore 21
      //   388: iload 14
      //   390: istore 13
      //   392: iload 21
      //   394: istore 12
      //   396: goto +468 -> 864
      //   399: iload_3
      //   400: iconst_4
      //   401: iand
      //   402: iconst_4
      //   403: if_icmpeq +424 -> 827
      //   406: aload_0
      //   407: new 97	java/util/ArrayList
      //   410: dup
      //   411: invokespecial 98	java/util/ArrayList:<init>	()V
      //   414: putfield 126	com/umeng/message/proguard/j$a:o	Ljava/util/List;
      //   417: iload_3
      //   418: iconst_4
      //   419: ior
      //   420: istore 14
      //   422: aload_0
      //   423: getfield 126	com/umeng/message/proguard/j$a:o	Ljava/util/List;
      //   426: aload_1
      //   427: getstatic 103	com/umeng/message/proguard/j$k:a	Lcom/umeng/message/proguard/B;
      //   430: aload_2
      //   431: invokevirtual 106	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   434: invokeinterface 112 2 0
      //   439: pop
      //   440: iload 5
      //   442: istore 19
      //   444: iload 14
      //   446: istore 13
      //   448: iload 19
      //   450: istore 12
      //   452: goto +412 -> 864
      //   455: iconst_2
      //   456: aload_0
      //   457: getfield 90	com/umeng/message/proguard/j$a:k	I
      //   460: iand
      //   461: iconst_2
      //   462: if_icmpne +359 -> 821
      //   465: aload_0
      //   466: getfield 128	com/umeng/message/proguard/j$a:s	Lcom/umeng/message/proguard/j$u;
      //   469: invokevirtual 134	com/umeng/message/proguard/j$u:w	()Lcom/umeng/message/proguard/j$u$a;
      //   472: astore 10
      //   474: aload_0
      //   475: aload_1
      //   476: getstatic 135	com/umeng/message/proguard/j$u:a	Lcom/umeng/message/proguard/B;
      //   479: aload_2
      //   480: invokevirtual 106	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   483: checkcast 130	com/umeng/message/proguard/j$u
      //   486: putfield 128	com/umeng/message/proguard/j$a:s	Lcom/umeng/message/proguard/j$u;
      //   489: aload 10
      //   491: ifnull +22 -> 513
      //   494: aload 10
      //   496: aload_0
      //   497: getfield 128	com/umeng/message/proguard/j$a:s	Lcom/umeng/message/proguard/j$u;
      //   500: invokevirtual 140	com/umeng/message/proguard/j$u$a:a	(Lcom/umeng/message/proguard/j$u;)Lcom/umeng/message/proguard/j$u$a;
      //   503: pop
      //   504: aload_0
      //   505: aload 10
      //   507: invokevirtual 144	com/umeng/message/proguard/j$u$a:x	()Lcom/umeng/message/proguard/j$u;
      //   510: putfield 128	com/umeng/message/proguard/j$a:s	Lcom/umeng/message/proguard/j$u;
      //   513: aload_0
      //   514: iconst_2
      //   515: aload_0
      //   516: getfield 90	com/umeng/message/proguard/j$a:k	I
      //   519: ior
      //   520: putfield 90	com/umeng/message/proguard/j$a:k	I
      //   523: iload 5
      //   525: istore 12
      //   527: iload_3
      //   528: istore 13
      //   530: goto +334 -> 864
      //   533: astore 8
      //   535: aload 8
      //   537: aload_0
      //   538: invokevirtual 147	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   541: athrow
      //   542: astore 7
      //   544: iload_3
      //   545: iconst_2
      //   546: iand
      //   547: iconst_2
      //   548: if_icmpne +14 -> 562
      //   551: aload_0
      //   552: aload_0
      //   553: getfield 100	com/umeng/message/proguard/j$a:n	Ljava/util/List;
      //   556: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   559: putfield 100	com/umeng/message/proguard/j$a:n	Ljava/util/List;
      //   562: iload_3
      //   563: bipush 8
      //   565: iand
      //   566: bipush 8
      //   568: if_icmpne +14 -> 582
      //   571: aload_0
      //   572: aload_0
      //   573: getfield 114	com/umeng/message/proguard/j$a:p	Ljava/util/List;
      //   576: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   579: putfield 114	com/umeng/message/proguard/j$a:p	Ljava/util/List;
      //   582: iload_3
      //   583: bipush 16
      //   585: iand
      //   586: bipush 16
      //   588: if_icmpne +14 -> 602
      //   591: aload_0
      //   592: aload_0
      //   593: getfield 116	com/umeng/message/proguard/j$a:q	Ljava/util/List;
      //   596: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   599: putfield 116	com/umeng/message/proguard/j$a:q	Ljava/util/List;
      //   602: iload_3
      //   603: bipush 32
      //   605: iand
      //   606: bipush 32
      //   608: if_icmpne +14 -> 622
      //   611: aload_0
      //   612: aload_0
      //   613: getfield 121	com/umeng/message/proguard/j$a:r	Ljava/util/List;
      //   616: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   619: putfield 121	com/umeng/message/proguard/j$a:r	Ljava/util/List;
      //   622: iload_3
      //   623: iconst_4
      //   624: iand
      //   625: iconst_4
      //   626: if_icmpne +14 -> 640
      //   629: aload_0
      //   630: aload_0
      //   631: getfield 126	com/umeng/message/proguard/j$a:o	Ljava/util/List;
      //   634: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   637: putfield 126	com/umeng/message/proguard/j$a:o	Ljava/util/List;
      //   640: aload_0
      //   641: aload 4
      //   643: invokevirtual 158	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   646: putfield 160	com/umeng/message/proguard/j$a:j	Lcom/umeng/message/proguard/P;
      //   649: aload_0
      //   650: invokevirtual 163	com/umeng/message/proguard/j$a:ad	()V
      //   653: aload 7
      //   655: athrow
      //   656: astore 6
      //   658: new 68	com/umeng/message/proguard/s
      //   661: dup
      //   662: aload 6
      //   664: invokevirtual 167	java/io/IOException:getMessage	()Ljava/lang/String;
      //   667: invokespecial 170	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   670: aload_0
      //   671: invokevirtual 147	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   674: athrow
      //   675: iload_3
      //   676: iconst_2
      //   677: iand
      //   678: iconst_2
      //   679: if_icmpne +14 -> 693
      //   682: aload_0
      //   683: aload_0
      //   684: getfield 100	com/umeng/message/proguard/j$a:n	Ljava/util/List;
      //   687: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   690: putfield 100	com/umeng/message/proguard/j$a:n	Ljava/util/List;
      //   693: iload_3
      //   694: bipush 8
      //   696: iand
      //   697: bipush 8
      //   699: if_icmpne +14 -> 713
      //   702: aload_0
      //   703: aload_0
      //   704: getfield 114	com/umeng/message/proguard/j$a:p	Ljava/util/List;
      //   707: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   710: putfield 114	com/umeng/message/proguard/j$a:p	Ljava/util/List;
      //   713: iload_3
      //   714: bipush 16
      //   716: iand
      //   717: bipush 16
      //   719: if_icmpne +14 -> 733
      //   722: aload_0
      //   723: aload_0
      //   724: getfield 116	com/umeng/message/proguard/j$a:q	Ljava/util/List;
      //   727: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   730: putfield 116	com/umeng/message/proguard/j$a:q	Ljava/util/List;
      //   733: iload_3
      //   734: bipush 32
      //   736: iand
      //   737: bipush 32
      //   739: if_icmpne +14 -> 753
      //   742: aload_0
      //   743: aload_0
      //   744: getfield 121	com/umeng/message/proguard/j$a:r	Ljava/util/List;
      //   747: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   750: putfield 121	com/umeng/message/proguard/j$a:r	Ljava/util/List;
      //   753: iload_3
      //   754: iconst_4
      //   755: iand
      //   756: iconst_4
      //   757: if_icmpne +14 -> 771
      //   760: aload_0
      //   761: aload_0
      //   762: getfield 126	com/umeng/message/proguard/j$a:o	Ljava/util/List;
      //   765: invokestatic 153	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   768: putfield 126	com/umeng/message/proguard/j$a:o	Ljava/util/List;
      //   771: aload_0
      //   772: aload 4
      //   774: invokevirtual 158	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   777: putfield 160	com/umeng/message/proguard/j$a:j	Lcom/umeng/message/proguard/P;
      //   780: aload_0
      //   781: invokevirtual 163	com/umeng/message/proguard/j$a:ad	()V
      //   784: return
      //   785: astore 17
      //   787: iload 14
      //   789: istore_3
      //   790: aload 17
      //   792: astore 7
      //   794: goto -250 -> 544
      //   797: astore 16
      //   799: iload 14
      //   801: istore_3
      //   802: aload 16
      //   804: astore 6
      //   806: goto -148 -> 658
      //   809: astore 15
      //   811: iload 14
      //   813: istore_3
      //   814: aload 15
      //   816: astore 8
      //   818: goto -283 -> 535
      //   821: aconst_null
      //   822: astore 10
      //   824: goto -350 -> 474
      //   827: iload_3
      //   828: istore 14
      //   830: goto -408 -> 422
      //   833: iload_3
      //   834: istore 14
      //   836: goto -470 -> 366
      //   839: iload_3
      //   840: istore 14
      //   842: goto -535 -> 307
      //   845: iload_3
      //   846: istore 14
      //   848: goto -600 -> 248
      //   851: iload_3
      //   852: istore 14
      //   854: goto -665 -> 189
      //   857: iload 5
      //   859: istore 12
      //   861: iload_3
      //   862: istore 13
      //   864: iload 13
      //   866: istore_3
      //   867: iload 12
      //   869: istore 5
      //   871: goto -843 -> 28
      //   874: iconst_1
      //   875: istore 12
      //   877: iload_3
      //   878: istore 13
      //   880: goto -16 -> 864
      //
      // Exception table:
      //   from	to	target	type
      //   33	39	533	com/umeng/message/proguard/s
      //   116	129	533	com/umeng/message/proguard/s
      //   138	156	533	com/umeng/message/proguard/s
      //   173	184	533	com/umeng/message/proguard/s
      //   231	242	533	com/umeng/message/proguard/s
      //   290	301	533	com/umeng/message/proguard/s
      //   349	360	533	com/umeng/message/proguard/s
      //   406	417	533	com/umeng/message/proguard/s
      //   455	474	533	com/umeng/message/proguard/s
      //   474	489	533	com/umeng/message/proguard/s
      //   494	513	533	com/umeng/message/proguard/s
      //   513	523	533	com/umeng/message/proguard/s
      //   33	39	542	finally
      //   116	129	542	finally
      //   138	156	542	finally
      //   173	184	542	finally
      //   231	242	542	finally
      //   290	301	542	finally
      //   349	360	542	finally
      //   406	417	542	finally
      //   455	474	542	finally
      //   474	489	542	finally
      //   494	513	542	finally
      //   513	523	542	finally
      //   535	542	542	finally
      //   658	675	542	finally
      //   33	39	656	java/io/IOException
      //   116	129	656	java/io/IOException
      //   138	156	656	java/io/IOException
      //   173	184	656	java/io/IOException
      //   231	242	656	java/io/IOException
      //   290	301	656	java/io/IOException
      //   349	360	656	java/io/IOException
      //   406	417	656	java/io/IOException
      //   455	474	656	java/io/IOException
      //   474	489	656	java/io/IOException
      //   494	513	656	java/io/IOException
      //   513	523	656	java/io/IOException
      //   189	207	785	finally
      //   248	266	785	finally
      //   307	325	785	finally
      //   366	384	785	finally
      //   422	440	785	finally
      //   189	207	797	java/io/IOException
      //   248	266	797	java/io/IOException
      //   307	325	797	java/io/IOException
      //   366	384	797	java/io/IOException
      //   422	440	797	java/io/IOException
      //   189	207	809	com/umeng/message/proguard/s
      //   248	266	809	com/umeng/message/proguard/s
      //   307	325	809	com/umeng/message/proguard/s
      //   366	384	809	com/umeng/message/proguard/s
      //   422	440	809	com/umeng/message/proguard/s
    }

    private a(p.a<?> parama)
    {
      super();
      this.j = parama.b_();
    }

    private a(boolean paramBoolean)
    {
      this.j = P.c();
    }

    private void S()
    {
      this.l = "";
      this.n = Collections.emptyList();
      this.o = Collections.emptyList();
      this.p = Collections.emptyList();
      this.q = Collections.emptyList();
      this.r = Collections.emptyList();
      this.s = j.u.h();
    }

    public static a a(a parama)
    {
      return c_().a(parama);
    }

    public static a a(g paramg)
      throws s
    {
      return (a)a.d(paramg);
    }

    public static a a(g paramg, n paramn)
      throws s
    {
      return (a)a.d(paramg, paramn);
    }

    public static a a(h paramh)
      throws IOException
    {
      return (a)a.d(paramh);
    }

    public static a a(h paramh, n paramn)
      throws IOException
    {
      return (a)a.b(paramh, paramn);
    }

    public static a a(InputStream paramInputStream)
      throws IOException
    {
      return (a)a.h(paramInputStream);
    }

    public static a a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (a)a.h(paramInputStream, paramn);
    }

    public static a a(byte[] paramArrayOfByte)
      throws s
    {
      return (a)a.d(paramArrayOfByte);
    }

    public static a a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (a)a.d(paramArrayOfByte, paramn);
    }

    public static a b(InputStream paramInputStream)
      throws IOException
    {
      return (a)a.f(paramInputStream);
    }

    public static a b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (a)a.f(paramInputStream, paramn);
    }

    public static a c_()
    {
      return a.an();
    }

    public static a h()
    {
      return i;
    }

    public static final k.a k()
    {
      return j.f();
    }

    public List<? extends j.d> A()
    {
      return this.q;
    }

    public int B()
    {
      return this.q.size();
    }

    public List<b> C()
    {
      return this.r;
    }

    public List<? extends c> D()
    {
      return this.r;
    }

    public int E()
    {
      return this.r.size();
    }

    public boolean F()
    {
      return (0x2 & this.k) == 2;
    }

    public j.u G()
    {
      return this.s;
    }

    public j.v H()
    {
      return this.s;
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public a K()
    {
      return c_();
    }

    public a L()
    {
      return a(this);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public j.k a(int paramInt)
    {
      return (j.k)this.n.get(paramInt);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      if ((0x1 & this.k) == 1)
        parami.a(1, p());
      for (int m = 0; m < this.n.size(); m++)
        parami.c(2, (y)this.n.get(m));
      for (int i1 = 0; i1 < this.p.size(); i1++)
        parami.c(3, (y)this.p.get(i1));
      for (int i2 = 0; i2 < this.q.size(); i2++)
        parami.c(4, (y)this.q.get(i2));
      int i5;
      for (int i3 = 0; ; i3++)
      {
        int i4 = this.r.size();
        i5 = 0;
        if (i3 >= i4)
          break;
        parami.c(5, (y)this.r.get(i3));
      }
      while (i5 < this.o.size())
      {
        parami.c(6, (y)this.o.get(i5));
        i5++;
      }
      if ((0x2 & this.k) == 2)
        parami.c(7, this.s);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = 1;
      int i1 = this.t;
      if (i1 != -1)
      {
        if (i1 == m);
        while (true)
        {
          return m;
          m = 0;
        }
      }
      for (int i2 = 0; i2 < s(); i2++)
        if (!a(i2).a())
        {
          this.t = 0;
          return false;
        }
      for (int i3 = 0; i3 < v(); i3++)
        if (!c(i3).a())
        {
          this.t = 0;
          return false;
        }
      for (int i4 = 0; i4 < y(); i4++)
        if (!e(i4).a())
        {
          this.t = 0;
          return false;
        }
      for (int i5 = 0; i5 < B(); i5++)
        if (!g(i5).a())
        {
          this.t = 0;
          return false;
        }
      if ((F()) && (!G().a()))
      {
        this.t = 0;
        return false;
      }
      this.t = m;
      return m;
    }

    public j.l b(int paramInt)
    {
      return (j.l)this.n.get(paramInt);
    }

    public final P b_()
    {
      return this.j;
    }

    public j.k c(int paramInt)
    {
      return (j.k)this.o.get(paramInt);
    }

    public int d()
    {
      int m = this.u;
      if (m != -1)
        return m;
      if ((0x1 & this.k) == 1);
      for (int i1 = 0 + i.c(1, p()); ; i1 = 0)
      {
        int i2 = 0;
        int i3 = i1;
        while (i2 < this.n.size())
        {
          i3 += i.g(2, (y)this.n.get(i2));
          i2++;
        }
        for (int i4 = 0; i4 < this.p.size(); i4++)
          i3 += i.g(3, (y)this.p.get(i4));
        for (int i5 = 0; i5 < this.q.size(); i5++)
          i3 += i.g(4, (y)this.q.get(i5));
        int i8;
        for (int i6 = 0; ; i6++)
        {
          int i7 = this.r.size();
          i8 = 0;
          if (i6 >= i7)
            break;
          i3 += i.g(5, (y)this.r.get(i6));
        }
        while (i8 < this.o.size())
        {
          i3 += i.g(6, (y)this.o.get(i8));
          i8++;
        }
        if ((0x2 & this.k) == 2)
          i3 += i.g(7, this.s);
        int i9 = i3 + b_().d();
        this.u = i9;
        return i9;
      }
    }

    public j.l d(int paramInt)
    {
      return (j.l)this.o.get(paramInt);
    }

    public a e(int paramInt)
    {
      return (a)this.p.get(paramInt);
    }

    public j.b f(int paramInt)
    {
      return (j.b)this.p.get(paramInt);
    }

    public j.c g(int paramInt)
    {
      return (j.c)this.q.get(paramInt);
    }

    public j.d h(int paramInt)
    {
      return (j.d)this.q.get(paramInt);
    }

    public b i(int paramInt)
    {
      return (b)this.r.get(paramInt);
    }

    public a i()
    {
      return i;
    }

    public c j(int paramInt)
    {
      return (c)this.r.get(paramInt);
    }

    protected p.g l()
    {
      return j.g().a(a.class, a.class);
    }

    public B<a> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.k) == 1;
    }

    public String o()
    {
      Object localObject = this.l;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.l = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.l;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.l = localg;
        return localg;
      }
      return (g)localObject;
    }

    public List<j.k> q()
    {
      return this.n;
    }

    public List<? extends j.l> r()
    {
      return this.n;
    }

    public int s()
    {
      return this.n.size();
    }

    public List<j.k> t()
    {
      return this.o;
    }

    public List<? extends j.l> u()
    {
      return this.o;
    }

    public int v()
    {
      return this.o.size();
    }

    public List<a> w()
    {
      return this.p;
    }

    public List<? extends j.b> x()
    {
      return this.p;
    }

    public int y()
    {
      return this.p.size();
    }

    public List<j.c> z()
    {
      return this.q;
    }

    public static final class a extends p.a<a>
      implements j.b
    {
      private int a;
      private Object b = "";
      private List<j.k> c = Collections.emptyList();
      private D<j.k, j.k.a, j.l> d;
      private List<j.k> e = Collections.emptyList();
      private D<j.k, j.k.a, j.l> f;
      private List<j.a> g = Collections.emptyList();
      private D<j.a, a, j.b> h;
      private List<j.c> i = Collections.emptyList();
      private D<j.c, j.c.a, j.d> j;
      private List<j.a.b> k = Collections.emptyList();
      private D<j.a.b, j.a.b.a, j.a.c> l;
      private j.u m = j.u.h();
      private L<j.u, j.u.a, j.v> n;

      private a()
      {
        ao();
      }

      private a(p.b paramb)
      {
        super();
        ao();
      }

      private L<j.u, j.u.a, j.v> aG()
      {
        if (this.n == null)
        {
          this.n = new L(this.m, aE(), aD());
          this.m = null;
        }
        return this.n;
      }

      private void ao()
      {
        if (p.m)
        {
          ar();
          at();
          av();
          ax();
          az();
          aG();
        }
      }

      private static a ap()
      {
        return new a();
      }

      private void aq()
      {
        if ((0x2 & this.a) != 2)
        {
          this.c = new ArrayList(this.c);
          this.a = (0x2 | this.a);
        }
      }

      private D<j.k, j.k.a, j.l> ar()
      {
        List localList;
        if (this.d == null)
        {
          localList = this.c;
          if ((0x2 & this.a) != 2)
            break label55;
        }
        label55: for (boolean bool = true; ; bool = false)
        {
          this.d = new D(localList, bool, aE(), aD());
          this.c = null;
          return this.d;
        }
      }

      private void as()
      {
        if ((0x4 & this.a) != 4)
        {
          this.e = new ArrayList(this.e);
          this.a = (0x4 | this.a);
        }
      }

      private D<j.k, j.k.a, j.l> at()
      {
        List localList;
        if (this.f == null)
        {
          localList = this.e;
          if ((0x4 & this.a) != 4)
            break label55;
        }
        label55: for (boolean bool = true; ; bool = false)
        {
          this.f = new D(localList, bool, aE(), aD());
          this.e = null;
          return this.f;
        }
      }

      private void au()
      {
        if ((0x8 & this.a) != 8)
        {
          this.g = new ArrayList(this.g);
          this.a = (0x8 | this.a);
        }
      }

      private D<j.a, a, j.b> av()
      {
        List localList;
        if (this.h == null)
        {
          localList = this.g;
          if ((0x8 & this.a) != 8)
            break label57;
        }
        label57: for (boolean bool = true; ; bool = false)
        {
          this.h = new D(localList, bool, aE(), aD());
          this.g = null;
          return this.h;
        }
      }

      private void aw()
      {
        if ((0x10 & this.a) != 16)
        {
          this.i = new ArrayList(this.i);
          this.a = (0x10 | this.a);
        }
      }

      private D<j.c, j.c.a, j.d> ax()
      {
        List localList;
        if (this.j == null)
        {
          localList = this.i;
          if ((0x10 & this.a) != 16)
            break label57;
        }
        label57: for (boolean bool = true; ; bool = false)
        {
          this.j = new D(localList, bool, aE(), aD());
          this.i = null;
          return this.j;
        }
      }

      private void ay()
      {
        if ((0x20 & this.a) != 32)
        {
          this.k = new ArrayList(this.k);
          this.a = (0x20 | this.a);
        }
      }

      private D<j.a.b, j.a.b.a, j.a.c> az()
      {
        List localList;
        if (this.l == null)
        {
          localList = this.k;
          if ((0x20 & this.a) != 32)
            break label57;
        }
        label57: for (boolean bool = true; ; bool = false)
        {
          this.l = new D(localList, bool, aE(), aD());
          this.k = null;
          return this.l;
        }
      }

      public static final k.a k()
      {
        return j.f();
      }

      public List<? extends j.d> A()
      {
        if (this.j != null)
          return this.j.i();
        return Collections.unmodifiableList(this.i);
      }

      public int B()
      {
        if (this.j == null)
          return this.i.size();
        return this.j.c();
      }

      public List<j.a.b> C()
      {
        if (this.l == null)
          return Collections.unmodifiableList(this.k);
        return this.l.g();
      }

      public List<? extends j.a.c> D()
      {
        if (this.l != null)
          return this.l.i();
        return Collections.unmodifiableList(this.k);
      }

      public int E()
      {
        if (this.l == null)
          return this.k.size();
        return this.l.c();
      }

      public boolean F()
      {
        return (0x40 & this.a) == 64;
      }

      public j.u G()
      {
        if (this.n == null)
          return this.m;
        return (j.u)this.n.c();
      }

      public j.v H()
      {
        if (this.n != null)
          return (j.v)this.n.f();
        return this.m;
      }

      public a I()
      {
        return ap().a(M());
      }

      public k.a J()
      {
        return j.f();
      }

      public j.a K()
      {
        return j.a.h();
      }

      public j.a L()
      {
        j.a locala = M();
        if (!locala.a())
          throw b(locala);
        return locala;
      }

      public j.a M()
      {
        int i1 = 1;
        j.a locala = new j.a(this, null);
        int i2 = this.a;
        if ((i2 & 0x1) == i1);
        while (true)
        {
          j.a.a(locala, this.b);
          if (this.d == null)
          {
            if ((0x2 & this.a) == 2)
            {
              this.c = Collections.unmodifiableList(this.c);
              this.a = (0xFFFFFFFD & this.a);
            }
            j.a.a(locala, this.c);
            if (this.f != null)
              break label337;
            if ((0x4 & this.a) == 4)
            {
              this.e = Collections.unmodifiableList(this.e);
              this.a = (0xFFFFFFFB & this.a);
            }
            j.a.b(locala, this.e);
            label129: if (this.h != null)
              break label352;
            if ((0x8 & this.a) == 8)
            {
              this.g = Collections.unmodifiableList(this.g);
              this.a = (0xFFFFFFF7 & this.a);
            }
            j.a.c(locala, this.g);
            label179: if (this.j != null)
              break label367;
            if ((0x10 & this.a) == 16)
            {
              this.i = Collections.unmodifiableList(this.i);
              this.a = (0xFFFFFFEF & this.a);
            }
            j.a.d(locala, this.i);
            label229: if (this.l != null)
              break label382;
            if ((0x20 & this.a) == 32)
            {
              this.k = Collections.unmodifiableList(this.k);
              this.a = (0xFFFFFFDF & this.a);
            }
            j.a.e(locala, this.k);
            label279: if ((i2 & 0x40) != 64)
              break label415;
          }
          label415: for (int i3 = i1 | 0x2; ; i3 = i1)
          {
            if (this.n == null)
              j.a.a(locala, this.m);
            while (true)
            {
              j.a.a(locala, i3);
              aB();
              return locala;
              j.a.a(locala, this.d.f());
              break;
              label337: j.a.b(locala, this.f.f());
              break label129;
              label352: j.a.c(locala, this.h.f());
              break label179;
              label367: j.a.d(locala, this.j.f());
              break label229;
              label382: j.a.e(locala, this.l.f());
              break label279;
              j.a.a(locala, (j.u)this.n.d());
            }
          }
          i1 = 0;
        }
      }

      public a N()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.a.h().o();
        aF();
        return this;
      }

      public a O()
      {
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          aF();
          return this;
        }
        this.d.e();
        return this;
      }

      public j.k.a P()
      {
        return (j.k.a)ar().b(j.k.h());
      }

      public List<j.k.a> S()
      {
        return ar().h();
      }

      public a T()
      {
        if (this.f == null)
        {
          this.e = Collections.emptyList();
          this.a = (0xFFFFFFFB & this.a);
          aF();
          return this;
        }
        this.f.e();
        return this;
      }

      public j.k.a U()
      {
        return (j.k.a)at().b(j.k.h());
      }

      public List<j.k.a> V()
      {
        return at().h();
      }

      public a W()
      {
        if (this.h == null)
        {
          this.g = Collections.emptyList();
          this.a = (0xFFFFFFF7 & this.a);
          aF();
          return this;
        }
        this.h.e();
        return this;
      }

      public a X()
      {
        return (a)av().b(j.a.h());
      }

      public List<a> Y()
      {
        return av().h();
      }

      public a Z()
      {
        if (this.j == null)
        {
          this.i = Collections.emptyList();
          this.a = (0xFFFFFFEF & this.a);
          aF();
          return this;
        }
        this.j.e();
        return this;
      }

      public a a(int paramInt, a parama)
      {
        if (this.h == null)
        {
          au();
          this.g.set(paramInt, parama.L());
          aF();
          return this;
        }
        this.h.a(paramInt, parama.L());
        return this;
      }

      public a a(int paramInt, j.a.b.a parama)
      {
        if (this.l == null)
        {
          ay();
          this.k.set(paramInt, parama.t());
          aF();
          return this;
        }
        this.l.a(paramInt, parama.t());
        return this;
      }

      public a a(int paramInt, j.a.b paramb)
      {
        if (this.l == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          ay();
          this.k.set(paramInt, paramb);
          aF();
          return this;
        }
        this.l.a(paramInt, paramb);
        return this;
      }

      public a a(int paramInt, j.a parama)
      {
        if (this.h == null)
        {
          if (parama == null)
            throw new NullPointerException();
          au();
          this.g.set(paramInt, parama);
          aF();
          return this;
        }
        this.h.a(paramInt, parama);
        return this;
      }

      public a a(int paramInt, j.c.a parama)
      {
        if (this.j == null)
        {
          aw();
          this.i.set(paramInt, parama.y());
          aF();
          return this;
        }
        this.j.a(paramInt, parama.y());
        return this;
      }

      public a a(int paramInt, j.c paramc)
      {
        if (this.j == null)
        {
          if (paramc == null)
            throw new NullPointerException();
          aw();
          this.i.set(paramInt, paramc);
          aF();
          return this;
        }
        this.j.a(paramInt, paramc);
        return this;
      }

      public a a(int paramInt, j.k.a parama)
      {
        if (this.d == null)
        {
          aq();
          this.c.set(paramInt, parama.L());
          aF();
          return this;
        }
        this.d.a(paramInt, parama.L());
        return this;
      }

      public a a(int paramInt, j.k paramk)
      {
        if (this.d == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          aq();
          this.c.set(paramInt, paramk);
          aF();
          return this;
        }
        this.d.a(paramInt, paramk);
        return this;
      }

      public a a(a parama)
      {
        if (this.h == null)
        {
          au();
          this.g.add(parama.L());
          aF();
          return this;
        }
        this.h.a(parama.L());
        return this;
      }

      public a a(j.a.b.a parama)
      {
        if (this.l == null)
        {
          ay();
          this.k.add(parama.t());
          aF();
          return this;
        }
        this.l.a(parama.t());
        return this;
      }

      public a a(j.a.b paramb)
      {
        if (this.l == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          ay();
          this.k.add(paramb);
          aF();
          return this;
        }
        this.l.a(paramb);
        return this;
      }

      public a a(j.a parama)
      {
        if (parama == j.a.h())
          return this;
        if (parama.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.a.b(parama);
          aF();
        }
        if (this.d == null)
          if (!j.a.c(parama).isEmpty())
          {
            if (this.c.isEmpty())
            {
              this.c = j.a.c(parama);
              this.a = (0xFFFFFFFD & this.a);
              aF();
            }
          }
          else
          {
            label92: if (this.f != null)
              break label472;
            if (!j.a.d(parama).isEmpty())
            {
              if (!this.e.isEmpty())
                break label451;
              this.e = j.a.d(parama);
              this.a = (0xFFFFFFFB & this.a);
              label142: aF();
            }
            label146: if (this.h != null)
              break label588;
            if (!j.a.e(parama).isEmpty())
            {
              if (!this.g.isEmpty())
                break label567;
              this.g = j.a.e(parama);
              this.a = (0xFFFFFFF7 & this.a);
              label196: aF();
            }
            label200: if (this.j != null)
              break label704;
            if (!j.a.f(parama).isEmpty())
            {
              if (!this.i.isEmpty())
                break label683;
              this.i = j.a.f(parama);
              this.a = (0xFFFFFFEF & this.a);
              label250: aF();
            }
            label254: if (this.l != null)
              break label820;
            if (!j.a.g(parama).isEmpty())
            {
              if (!this.k.isEmpty())
                break label799;
              this.k = j.a.g(parama);
              this.a = (0xFFFFFFDF & this.a);
              label304: aF();
            }
          }
        while (true)
        {
          if (parama.F())
            b(parama.G());
          d(parama.b_());
          return this;
          aq();
          this.c.addAll(j.a.c(parama));
          break;
          if (j.a.c(parama).isEmpty())
            break label92;
          if (this.d.d())
          {
            this.d.b();
            this.d = null;
            this.c = j.a.c(parama);
            this.a = (0xFFFFFFFD & this.a);
            if (p.m);
            for (D localD5 = ar(); ; localD5 = null)
            {
              this.d = localD5;
              break;
            }
          }
          this.d.a(j.a.c(parama));
          break label92;
          label451: as();
          this.e.addAll(j.a.d(parama));
          break label142;
          label472: if (j.a.d(parama).isEmpty())
            break label146;
          if (this.f.d())
          {
            this.f.b();
            this.f = null;
            this.e = j.a.d(parama);
            this.a = (0xFFFFFFFB & this.a);
            if (p.m);
            for (D localD4 = at(); ; localD4 = null)
            {
              this.f = localD4;
              break;
            }
          }
          this.f.a(j.a.d(parama));
          break label146;
          label567: au();
          this.g.addAll(j.a.e(parama));
          break label196;
          label588: if (j.a.e(parama).isEmpty())
            break label200;
          if (this.h.d())
          {
            this.h.b();
            this.h = null;
            this.g = j.a.e(parama);
            this.a = (0xFFFFFFF7 & this.a);
            if (p.m);
            for (D localD3 = av(); ; localD3 = null)
            {
              this.h = localD3;
              break;
            }
          }
          this.h.a(j.a.e(parama));
          break label200;
          label683: aw();
          this.i.addAll(j.a.f(parama));
          break label250;
          label704: if (j.a.f(parama).isEmpty())
            break label254;
          if (this.j.d())
          {
            this.j.b();
            this.j = null;
            this.i = j.a.f(parama);
            this.a = (0xFFFFFFEF & this.a);
            if (p.m);
            for (D localD2 = ax(); ; localD2 = null)
            {
              this.j = localD2;
              break;
            }
          }
          this.j.a(j.a.f(parama));
          break label254;
          label799: ay();
          this.k.addAll(j.a.g(parama));
          break label304;
          label820: if (!j.a.g(parama).isEmpty())
            if (this.l.d())
            {
              this.l.b();
              this.l = null;
              this.k = j.a.g(parama);
              this.a = (0xFFFFFFDF & this.a);
              boolean bool = p.m;
              D localD1 = null;
              if (bool)
                localD1 = az();
              this.l = localD1;
            }
            else
            {
              this.l.a(j.a.g(parama));
            }
        }
      }

      public a a(j.c.a parama)
      {
        if (this.j == null)
        {
          aw();
          this.i.add(parama.y());
          aF();
          return this;
        }
        this.j.a(parama.y());
        return this;
      }

      public a a(j.c paramc)
      {
        if (this.j == null)
        {
          if (paramc == null)
            throw new NullPointerException();
          aw();
          this.i.add(paramc);
          aF();
          return this;
        }
        this.j.a(paramc);
        return this;
      }

      public a a(j.k.a parama)
      {
        if (this.d == null)
        {
          aq();
          this.c.add(parama.L());
          aF();
          return this;
        }
        this.d.a(parama.L());
        return this;
      }

      public a a(j.k paramk)
      {
        if (this.d == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          aq();
          this.c.add(paramk);
          aF();
          return this;
        }
        this.d.a(paramk);
        return this;
      }

      public a a(j.u.a parama)
      {
        if (this.n == null)
        {
          this.m = parama.w();
          aF();
        }
        while (true)
        {
          this.a = (0x40 | this.a);
          return this;
          this.n.a(parama.w());
        }
      }

      public a a(j.u paramu)
      {
        if (this.n == null)
        {
          if (paramu == null)
            throw new NullPointerException();
          this.m = paramu;
          aF();
        }
        while (true)
        {
          this.a = (0x40 | this.a);
          return this;
          this.n.a(paramu);
        }
      }

      public a a(Iterable<? extends j.k> paramIterable)
      {
        if (this.d == null)
        {
          aq();
          p.a.a(paramIterable, this.c);
          aF();
          return this;
        }
        this.d.a(paramIterable);
        return this;
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public j.k a(int paramInt)
      {
        if (this.d == null)
          return (j.k)this.c.get(paramInt);
        return (j.k)this.d.a(paramInt);
      }

      public final boolean a()
      {
        int i1 = 0;
        if (i1 < s())
          if (a(i1).a());
        label56: label83: label113: 
        do
        {
          return false;
          i1++;
          break;
          for (int i2 = 0; ; i2++)
          {
            if (i2 >= v())
              break label56;
            if (!c(i2).a())
              break;
          }
          for (int i3 = 0; ; i3++)
          {
            if (i3 >= y())
              break label83;
            if (!e(i3).a())
              break;
          }
          for (int i4 = 0; ; i4++)
          {
            if (i4 >= B())
              break label113;
            if (!g(i4).a())
              break;
          }
        }
        while ((F()) && (!G().a()));
        return true;
      }

      public j.c.a aa()
      {
        return (j.c.a)ax().b(j.c.h());
      }

      public List<j.c.a> ab()
      {
        return ax().h();
      }

      public a ac()
      {
        if (this.l == null)
        {
          this.k = Collections.emptyList();
          this.a = (0xFFFFFFDF & this.a);
          aF();
          return this;
        }
        this.l.e();
        return this;
      }

      public j.a.b.a ad()
      {
        return (j.a.b.a)az().b(j.a.b.h());
      }

      public List<j.a.b.a> ae()
      {
        return az().h();
      }

      public a af()
      {
        if (this.n == null)
        {
          this.m = j.u.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFFBF & this.a);
          return this;
          this.n.g();
        }
      }

      public j.u.a ag()
      {
        this.a = (0x40 | this.a);
        aF();
        return (j.u.a)aG().e();
      }

      public a b(int paramInt, a parama)
      {
        if (this.h == null)
        {
          au();
          this.g.add(paramInt, parama.L());
          aF();
          return this;
        }
        this.h.b(paramInt, parama.L());
        return this;
      }

      public a b(int paramInt, j.a.b.a parama)
      {
        if (this.l == null)
        {
          ay();
          this.k.add(paramInt, parama.t());
          aF();
          return this;
        }
        this.l.b(paramInt, parama.t());
        return this;
      }

      public a b(int paramInt, j.a.b paramb)
      {
        if (this.l == null)
        {
          if (paramb == null)
            throw new NullPointerException();
          ay();
          this.k.add(paramInt, paramb);
          aF();
          return this;
        }
        this.l.b(paramInt, paramb);
        return this;
      }

      public a b(int paramInt, j.a parama)
      {
        if (this.h == null)
        {
          if (parama == null)
            throw new NullPointerException();
          au();
          this.g.add(paramInt, parama);
          aF();
          return this;
        }
        this.h.b(paramInt, parama);
        return this;
      }

      public a b(int paramInt, j.c.a parama)
      {
        if (this.j == null)
        {
          aw();
          this.i.add(paramInt, parama.y());
          aF();
          return this;
        }
        this.j.b(paramInt, parama.y());
        return this;
      }

      public a b(int paramInt, j.c paramc)
      {
        if (this.j == null)
        {
          if (paramc == null)
            throw new NullPointerException();
          aw();
          this.i.add(paramInt, paramc);
          aF();
          return this;
        }
        this.j.b(paramInt, paramc);
        return this;
      }

      public a b(int paramInt, j.k.a parama)
      {
        if (this.d == null)
        {
          aq();
          this.c.add(paramInt, parama.L());
          aF();
          return this;
        }
        this.d.b(paramInt, parama.L());
        return this;
      }

      public a b(int paramInt, j.k paramk)
      {
        if (this.d == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          aq();
          this.c.add(paramInt, paramk);
          aF();
          return this;
        }
        this.d.b(paramInt, paramk);
        return this;
      }

      public a b(j.a parama)
      {
        if (this.h == null)
        {
          if (parama == null)
            throw new NullPointerException();
          au();
          this.g.add(parama);
          aF();
          return this;
        }
        this.h.a(parama);
        return this;
      }

      public a b(j.k.a parama)
      {
        if (this.f == null)
        {
          as();
          this.e.add(parama.L());
          aF();
          return this;
        }
        this.f.a(parama.L());
        return this;
      }

      public a b(j.k paramk)
      {
        if (this.f == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          as();
          this.e.add(paramk);
          aF();
          return this;
        }
        this.f.a(paramk);
        return this;
      }

      public a b(j.u paramu)
      {
        if (this.n == null)
          if (((0x40 & this.a) == 64) && (this.m != j.u.h()))
          {
            this.m = j.u.a(this.m).a(paramu).x();
            aF();
          }
        while (true)
        {
          this.a = (0x40 | this.a);
          return this;
          this.m = paramu;
          break;
          this.n.b(paramu);
        }
      }

      public a b(Iterable<? extends j.k> paramIterable)
      {
        if (this.f == null)
        {
          as();
          p.a.a(paramIterable, this.e);
          aF();
          return this;
        }
        this.f.a(paramIterable);
        return this;
      }

      public j.l b(int paramInt)
      {
        if (this.d == null)
          return (j.l)this.c.get(paramInt);
        return (j.l)this.d.c(paramInt);
      }

      public a c(int paramInt, j.k.a parama)
      {
        if (this.f == null)
        {
          as();
          this.e.set(paramInt, parama.L());
          aF();
          return this;
        }
        this.f.a(paramInt, parama.L());
        return this;
      }

      public a c(int paramInt, j.k paramk)
      {
        if (this.f == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          as();
          this.e.set(paramInt, paramk);
          aF();
          return this;
        }
        this.f.a(paramInt, paramk);
        return this;
      }

      public a c(Iterable<? extends j.a> paramIterable)
      {
        if (this.h == null)
        {
          au();
          p.a.a(paramIterable, this.g);
          aF();
          return this;
        }
        this.h.a(paramIterable);
        return this;
      }

      public j.k c(int paramInt)
      {
        if (this.f == null)
          return (j.k)this.e.get(paramInt);
        return (j.k)this.f.a(paramInt);
      }

      public a d(int paramInt, j.k.a parama)
      {
        if (this.f == null)
        {
          as();
          this.e.add(paramInt, parama.L());
          aF();
          return this;
        }
        this.f.b(paramInt, parama.L());
        return this;
      }

      public a d(int paramInt, j.k paramk)
      {
        if (this.f == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          as();
          this.e.add(paramInt, paramk);
          aF();
          return this;
        }
        this.f.b(paramInt, paramk);
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.a))
          return a((j.a)paramx);
        super.a(paramx);
        return this;
      }

      public a d(Iterable<? extends j.c> paramIterable)
      {
        if (this.j == null)
        {
          aw();
          p.a.a(paramIterable, this.i);
          aF();
          return this;
        }
        this.j.a(paramIterable);
        return this;
      }

      public j.l d(int paramInt)
      {
        if (this.f == null)
          return (j.l)this.e.get(paramInt);
        return (j.l)this.f.c(paramInt);
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.a locala3 = (j.a)j.a.a.d(paramh, paramn);
          if (locala3 != null)
            a(locala3);
          return this;
        }
        catch (s locals)
        {
          j.a locala2 = (j.a)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            locala1 = locala2;
          }
          if (locala1 != null)
            a(locala1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.a locala1 = null;
        }
      }

      public a e(Iterable<? extends j.a.b> paramIterable)
      {
        if (this.l == null)
        {
          ay();
          p.a.a(paramIterable, this.k);
          aF();
          return this;
        }
        this.l.a(paramIterable);
        return this;
      }

      public j.a e(int paramInt)
      {
        if (this.h == null)
          return (j.a)this.g.get(paramInt);
        return (j.a)this.h.a(paramInt);
      }

      public j.b f(int paramInt)
      {
        if (this.h == null)
          return (j.b)this.g.get(paramInt);
        return (j.b)this.h.c(paramInt);
      }

      public j.c g(int paramInt)
      {
        if (this.j == null)
          return (j.c)this.i.get(paramInt);
        return (j.c)this.j.a(paramInt);
      }

      public j.d h(int paramInt)
      {
        if (this.j == null)
          return (j.d)this.i.get(paramInt);
        return (j.d)this.j.c(paramInt);
      }

      public j.a.b i(int paramInt)
      {
        if (this.l == null)
          return (j.a.b)this.k.get(paramInt);
        return (j.a.b)this.l.a(paramInt);
      }

      public j.a.c j(int paramInt)
      {
        if (this.l == null)
          return (j.a.c)this.k.get(paramInt);
        return (j.a.c)this.l.c(paramInt);
      }

      public a k(int paramInt)
      {
        if (this.d == null)
        {
          aq();
          this.c.remove(paramInt);
          aF();
          return this;
        }
        this.d.d(paramInt);
        return this;
      }

      public j.k.a l(int paramInt)
      {
        return (j.k.a)ar().b(paramInt);
      }

      protected p.g l()
      {
        return j.g().a(j.a.class, a.class);
      }

      public a m()
      {
        super.ah();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          if (this.f != null)
            break label184;
          this.e = Collections.emptyList();
          this.a = (0xFFFFFFFB & this.a);
          label72: if (this.h != null)
            break label194;
          this.g = Collections.emptyList();
          this.a = (0xFFFFFFF7 & this.a);
          label97: if (this.j != null)
            break label204;
          this.i = Collections.emptyList();
          this.a = (0xFFFFFFEF & this.a);
          label122: if (this.l != null)
            break label214;
          this.k = Collections.emptyList();
          this.a = (0xFFFFFFDF & this.a);
          label147: if (this.n != null)
            break label224;
          this.m = j.u.h();
        }
        while (true)
        {
          this.a = (0xFFFFFFBF & this.a);
          return this;
          this.d.e();
          break;
          label184: this.f.e();
          break label72;
          label194: this.h.e();
          break label97;
          label204: this.j.e();
          break label122;
          label214: this.l.e();
          break label147;
          label224: this.n.g();
        }
      }

      public j.k.a m(int paramInt)
      {
        return (j.k.a)ar().c(paramInt, j.k.h());
      }

      public a n(int paramInt)
      {
        if (this.f == null)
        {
          as();
          this.e.remove(paramInt);
          aF();
          return this;
        }
        this.f.d(paramInt);
        return this;
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public j.k.a o(int paramInt)
      {
        return (j.k.a)at().b(paramInt);
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public j.k.a p(int paramInt)
      {
        return (j.k.a)at().c(paramInt, j.k.h());
      }

      public a q(int paramInt)
      {
        if (this.h == null)
        {
          au();
          this.g.remove(paramInt);
          aF();
          return this;
        }
        this.h.d(paramInt);
        return this;
      }

      public List<j.k> q()
      {
        if (this.d == null)
          return Collections.unmodifiableList(this.c);
        return this.d.g();
      }

      public a r(int paramInt)
      {
        return (a)av().b(paramInt);
      }

      public List<? extends j.l> r()
      {
        if (this.d != null)
          return this.d.i();
        return Collections.unmodifiableList(this.c);
      }

      public int s()
      {
        if (this.d == null)
          return this.c.size();
        return this.d.c();
      }

      public a s(int paramInt)
      {
        return (a)av().c(paramInt, j.a.h());
      }

      public a t(int paramInt)
      {
        if (this.j == null)
        {
          aw();
          this.i.remove(paramInt);
          aF();
          return this;
        }
        this.j.d(paramInt);
        return this;
      }

      public List<j.k> t()
      {
        if (this.f == null)
          return Collections.unmodifiableList(this.e);
        return this.f.g();
      }

      public j.c.a u(int paramInt)
      {
        return (j.c.a)ax().b(paramInt);
      }

      public List<? extends j.l> u()
      {
        if (this.f != null)
          return this.f.i();
        return Collections.unmodifiableList(this.e);
      }

      public int v()
      {
        if (this.f == null)
          return this.e.size();
        return this.f.c();
      }

      public j.c.a v(int paramInt)
      {
        return (j.c.a)ax().c(paramInt, j.c.h());
      }

      public a w(int paramInt)
      {
        if (this.l == null)
        {
          ay();
          this.k.remove(paramInt);
          aF();
          return this;
        }
        this.l.d(paramInt);
        return this;
      }

      public List<j.a> w()
      {
        if (this.h == null)
          return Collections.unmodifiableList(this.g);
        return this.h.g();
      }

      public j.a.b.a x(int paramInt)
      {
        return (j.a.b.a)az().b(paramInt);
      }

      public List<? extends j.b> x()
      {
        if (this.h != null)
          return this.h.i();
        return Collections.unmodifiableList(this.g);
      }

      public int y()
      {
        if (this.h == null)
          return this.g.size();
        return this.h.c();
      }

      public j.a.b.a y(int paramInt)
      {
        return (j.a.b.a)az().c(paramInt, j.a.b.h());
      }

      public List<j.c> z()
      {
        if (this.j == null)
          return Collections.unmodifiableList(this.i);
        return this.j.g();
      }
    }

    public static final class b extends p
      implements j.a.c
    {
      public static B<b> a = new c()
      {
        public j.a.b c(h paramAnonymoush, n paramAnonymousn)
          throws s
        {
          return new j.a.b(paramAnonymoush, paramAnonymousn, null);
        }
      };
      public static final int b = 1;
      public static final int c = 2;
      private static final b d = new b(true);
      private static final long k;
      private final P e;
      private int f;
      private int g;
      private int h;
      private byte i = -1;
      private int j = -1;

      static
      {
        d.u();
      }

      // ERROR //
      private b(h paramh, n paramn)
        throws s
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 49	com/umeng/message/proguard/p:<init>	()V
        //   4: aload_0
        //   5: iconst_m1
        //   6: putfield 51	com/umeng/message/proguard/j$a$b:i	B
        //   9: aload_0
        //   10: iconst_m1
        //   11: putfield 53	com/umeng/message/proguard/j$a$b:j	I
        //   14: aload_0
        //   15: invokespecial 43	com/umeng/message/proguard/j$a$b:u	()V
        //   18: invokestatic 58	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
        //   21: astore_3
        //   22: iconst_0
        //   23: istore 4
        //   25: iload 4
        //   27: ifne +150 -> 177
        //   30: aload_1
        //   31: invokevirtual 63	com/umeng/message/proguard/h:a	()I
        //   34: istore 8
        //   36: iload 8
        //   38: lookupswitch	default:+34->72, 0:+152->190, 8:+52->90, 16:+99->137
        //   73: aload_1
        //   74: aload_3
        //   75: aload_2
        //   76: iload 8
        //   78: invokevirtual 66	com/umeng/message/proguard/j$a$b:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
        //   81: ifne -56 -> 25
        //   84: iconst_1
        //   85: istore 4
        //   87: goto -62 -> 25
        //   90: aload_0
        //   91: iconst_1
        //   92: aload_0
        //   93: getfield 68	com/umeng/message/proguard/j$a$b:f	I
        //   96: ior
        //   97: putfield 68	com/umeng/message/proguard/j$a$b:f	I
        //   100: aload_0
        //   101: aload_1
        //   102: invokevirtual 70	com/umeng/message/proguard/h:g	()I
        //   105: putfield 72	com/umeng/message/proguard/j$a$b:g	I
        //   108: goto -83 -> 25
        //   111: astore 7
        //   113: aload 7
        //   115: aload_0
        //   116: invokevirtual 75	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
        //   119: athrow
        //   120: astore 6
        //   122: aload_0
        //   123: aload_3
        //   124: invokevirtual 80	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
        //   127: putfield 82	com/umeng/message/proguard/j$a$b:e	Lcom/umeng/message/proguard/P;
        //   130: aload_0
        //   131: invokevirtual 85	com/umeng/message/proguard/j$a$b:ad	()V
        //   134: aload 6
        //   136: athrow
        //   137: aload_0
        //   138: iconst_2
        //   139: aload_0
        //   140: getfield 68	com/umeng/message/proguard/j$a$b:f	I
        //   143: ior
        //   144: putfield 68	com/umeng/message/proguard/j$a$b:f	I
        //   147: aload_0
        //   148: aload_1
        //   149: invokevirtual 70	com/umeng/message/proguard/h:g	()I
        //   152: putfield 87	com/umeng/message/proguard/j$a$b:h	I
        //   155: goto -130 -> 25
        //   158: astore 5
        //   160: new 46	com/umeng/message/proguard/s
        //   163: dup
        //   164: aload 5
        //   166: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
        //   169: invokespecial 94	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
        //   172: aload_0
        //   173: invokevirtual 75	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
        //   176: athrow
        //   177: aload_0
        //   178: aload_3
        //   179: invokevirtual 80	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
        //   182: putfield 82	com/umeng/message/proguard/j$a$b:e	Lcom/umeng/message/proguard/P;
        //   185: aload_0
        //   186: invokevirtual 85	com/umeng/message/proguard/j$a$b:ad	()V
        //   189: return
        //   190: iconst_1
        //   191: istore 4
        //   193: goto -168 -> 25
        //
        // Exception table:
        //   from	to	target	type
        //   30	36	111	com/umeng/message/proguard/s
        //   72	84	111	com/umeng/message/proguard/s
        //   90	108	111	com/umeng/message/proguard/s
        //   137	155	111	com/umeng/message/proguard/s
        //   30	36	120	finally
        //   72	84	120	finally
        //   90	108	120	finally
        //   113	120	120	finally
        //   137	155	120	finally
        //   160	177	120	finally
        //   30	36	158	java/io/IOException
        //   72	84	158	java/io/IOException
        //   90	108	158	java/io/IOException
        //   137	155	158	java/io/IOException
      }

      private b(p.a<?> parama)
      {
        super();
        this.e = parama.b_();
      }

      private b(boolean paramBoolean)
      {
        this.e = P.c();
      }

      public static a a(b paramb)
      {
        return r().a(paramb);
      }

      public static b a(g paramg)
        throws s
      {
        return (b)a.d(paramg);
      }

      public static b a(g paramg, n paramn)
        throws s
      {
        return (b)a.d(paramg, paramn);
      }

      public static b a(h paramh)
        throws IOException
      {
        return (b)a.d(paramh);
      }

      public static b a(h paramh, n paramn)
        throws IOException
      {
        return (b)a.b(paramh, paramn);
      }

      public static b a(InputStream paramInputStream)
        throws IOException
      {
        return (b)a.h(paramInputStream);
      }

      public static b a(InputStream paramInputStream, n paramn)
        throws IOException
      {
        return (b)a.h(paramInputStream, paramn);
      }

      public static b a(byte[] paramArrayOfByte)
        throws s
      {
        return (b)a.d(paramArrayOfByte);
      }

      public static b a(byte[] paramArrayOfByte, n paramn)
        throws s
      {
        return (b)a.d(paramArrayOfByte, paramn);
      }

      public static b b(InputStream paramInputStream)
        throws IOException
      {
        return (b)a.f(paramInputStream);
      }

      public static b b(InputStream paramInputStream, n paramn)
        throws IOException
      {
        return (b)a.f(paramInputStream, paramn);
      }

      public static b h()
      {
        return d;
      }

      public static final k.a k()
      {
        return j.h();
      }

      public static a r()
      {
        return a.x();
      }

      private void u()
      {
        this.g = 0;
        this.h = 0;
      }

      protected Object I()
        throws ObjectStreamException
      {
        return super.I();
      }

      protected a a(p.b paramb)
      {
        return new a(paramb, null);
      }

      public void a(i parami)
        throws IOException
      {
        d();
        if ((0x1 & this.f) == 1)
          parami.a(1, this.g);
        if ((0x2 & this.f) == 2)
          parami.a(2, this.h);
        b_().a(parami);
      }

      public final boolean a()
      {
        int m = this.i;
        if (m != -1)
          return m == 1;
        this.i = 1;
        return true;
      }

      public final P b_()
      {
        return this.e;
      }

      public int d()
      {
        int m = this.j;
        if (m != -1)
          return m;
        int n = 0x1 & this.f;
        int i1 = 0;
        if (n == 1)
          i1 = 0 + i.g(1, this.g);
        if ((0x2 & this.f) == 2)
          i1 += i.g(2, this.h);
        int i2 = i1 + b_().d();
        this.j = i2;
        return i2;
      }

      public b i()
      {
        return d;
      }

      protected p.g l()
      {
        return j.i().a(b.class, a.class);
      }

      public B<b> m()
      {
        return a;
      }

      public boolean n()
      {
        return (0x1 & this.f) == 1;
      }

      public int o()
      {
        return this.g;
      }

      public boolean p()
      {
        return (0x2 & this.f) == 2;
      }

      public int q()
      {
        return this.h;
      }

      public a s()
      {
        return r();
      }

      public a t()
      {
        return a(this);
      }

      public static final class a extends p.a<a>
        implements j.a.c
      {
        private int a;
        private int b;
        private int c;

        private a()
        {
          y();
        }

        private a(p.b paramb)
        {
          super();
          y();
        }

        public static final k.a k()
        {
          return j.h();
        }

        private void y()
        {
          if (p.m);
        }

        private static a z()
        {
          return new a();
        }

        public k.a J()
        {
          return j.h();
        }

        public a a(int paramInt)
        {
          this.a = (0x1 | this.a);
          this.b = paramInt;
          aF();
          return this;
        }

        public a a(j.a.b paramb)
        {
          if (paramb == j.a.b.h())
            return this;
          if (paramb.n())
            a(paramb.o());
          if (paramb.p())
            b(paramb.q());
          d(paramb.b_());
          return this;
        }

        public final boolean a()
        {
          return true;
        }

        public a b(int paramInt)
        {
          this.a = (0x2 | this.a);
          this.c = paramInt;
          aF();
          return this;
        }

        public a d(x paramx)
        {
          if ((paramx instanceof j.a.b))
            return a((j.a.b)paramx);
          super.a(paramx);
          return this;
        }

        public a e(h paramh, n paramn)
          throws IOException
        {
          try
          {
            j.a.b localb3 = (j.a.b)j.a.b.a.d(paramh, paramn);
            if (localb3 != null)
              a(localb3);
            return this;
          }
          catch (s locals)
          {
            j.a.b localb2 = (j.a.b)locals.a();
            Object localObject1;
            try
            {
              throw locals;
            }
            finally
            {
              localb1 = localb2;
            }
            if (localb1 != null)
              a(localb1);
            throw localObject1;
          }
          finally
          {
            while (true)
              j.a.b localb1 = null;
          }
        }

        protected p.g l()
        {
          return j.i().a(j.a.b.class, a.class);
        }

        public a m()
        {
          super.ah();
          this.b = 0;
          this.a = (0xFFFFFFFE & this.a);
          this.c = 0;
          this.a = (0xFFFFFFFD & this.a);
          return this;
        }

        public boolean n()
        {
          return (0x1 & this.a) == 1;
        }

        public int o()
        {
          return this.b;
        }

        public boolean p()
        {
          return (0x2 & this.a) == 2;
        }

        public int q()
        {
          return this.c;
        }

        public a r()
        {
          return z().a(u());
        }

        public j.a.b s()
        {
          return j.a.b.h();
        }

        public j.a.b t()
        {
          j.a.b localb = u();
          if (!localb.a())
            throw b(localb);
          return localb;
        }

        public j.a.b u()
        {
          int i = 1;
          j.a.b localb = new j.a.b(this, null);
          int j = this.a;
          if ((j & 0x1) == i);
          while (true)
          {
            j.a.b.a(localb, this.b);
            if ((j & 0x2) == 2)
              i |= 2;
            j.a.b.b(localb, this.c);
            j.a.b.c(localb, i);
            aB();
            return localb;
            i = 0;
          }
        }

        public a v()
        {
          this.a = (0xFFFFFFFE & this.a);
          this.b = 0;
          aF();
          return this;
        }

        public a w()
        {
          this.a = (0xFFFFFFFD & this.a);
          this.c = 0;
          aF();
          return this;
        }
      }
    }

    public static abstract interface c extends A
    {
      public abstract boolean n();

      public abstract int o();

      public abstract boolean p();

      public abstract int q();
    }
  }

  public static abstract interface b extends A
  {
    public abstract List<? extends j.d> A();

    public abstract int B();

    public abstract List<j.a.b> C();

    public abstract List<? extends j.a.c> D();

    public abstract int E();

    public abstract boolean F();

    public abstract j.u G();

    public abstract j.v H();

    public abstract j.k a(int paramInt);

    public abstract j.l b(int paramInt);

    public abstract j.k c(int paramInt);

    public abstract j.l d(int paramInt);

    public abstract j.a e(int paramInt);

    public abstract b f(int paramInt);

    public abstract j.c g(int paramInt);

    public abstract j.d h(int paramInt);

    public abstract j.a.b i(int paramInt);

    public abstract j.a.c j(int paramInt);

    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract List<j.k> q();

    public abstract List<? extends j.l> r();

    public abstract int s();

    public abstract List<j.k> t();

    public abstract List<? extends j.l> u();

    public abstract int v();

    public abstract List<j.a> w();

    public abstract List<? extends b> x();

    public abstract int y();

    public abstract List<j.c> z();
  }

  public static final class c extends p
    implements j.d
  {
    public static B<c> a = new c()
    {
      public j.c c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.c(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final c e = new c(true);
    private static final long n;
    private final P f;
    private int g;
    private Object h;
    private List<j.g> i;
    private j.e j;
    private byte k = -1;
    private int l = -1;

    static
    {
      e.z();
    }

    // ERROR //
    private c(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 56	com/umeng/message/proguard/p:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 58	com/umeng/message/proguard/j$c:k	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 60	com/umeng/message/proguard/j$c:l	I
      //   16: aload_0
      //   17: invokespecial 50	com/umeng/message/proguard/j$c:z	()V
      //   20: invokestatic 65	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +306 -> 335
      //   32: aload_1
      //   33: invokevirtual 70	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+44->84, 0:+397->437, 10:+67->107, 18:+95->135, 26:+152->192
      //   85: aload_1
      //   86: aload 4
      //   88: aload_2
      //   89: iload 9
      //   91: invokevirtual 73	com/umeng/message/proguard/j$c:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   94: ifne +326 -> 420
      //   97: iconst_1
      //   98: istore 12
      //   100: iload 5
      //   102: istore 13
      //   104: goto +323 -> 427
      //   107: aload_0
      //   108: iconst_1
      //   109: aload_0
      //   110: getfield 75	com/umeng/message/proguard/j$c:g	I
      //   113: ior
      //   114: putfield 75	com/umeng/message/proguard/j$c:g	I
      //   117: aload_0
      //   118: aload_1
      //   119: invokevirtual 78	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   122: putfield 80	com/umeng/message/proguard/j$c:h	Ljava/lang/Object;
      //   125: iload_3
      //   126: istore 12
      //   128: iload 5
      //   130: istore 13
      //   132: goto +295 -> 427
      //   135: iload 5
      //   137: iconst_2
      //   138: iand
      //   139: iconst_2
      //   140: if_icmpeq +273 -> 413
      //   143: aload_0
      //   144: new 82	java/util/ArrayList
      //   147: dup
      //   148: invokespecial 83	java/util/ArrayList:<init>	()V
      //   151: putfield 85	com/umeng/message/proguard/j$c:i	Ljava/util/List;
      //   154: iload 5
      //   156: iconst_2
      //   157: ior
      //   158: istore 14
      //   160: aload_0
      //   161: getfield 85	com/umeng/message/proguard/j$c:i	Ljava/util/List;
      //   164: aload_1
      //   165: getstatic 88	com/umeng/message/proguard/j$g:a	Lcom/umeng/message/proguard/B;
      //   168: aload_2
      //   169: invokevirtual 91	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   172: invokeinterface 97 2 0
      //   177: pop
      //   178: iload_3
      //   179: istore 19
      //   181: iload 14
      //   183: istore 13
      //   185: iload 19
      //   187: istore 12
      //   189: goto +238 -> 427
      //   192: iconst_2
      //   193: aload_0
      //   194: getfield 75	com/umeng/message/proguard/j$c:g	I
      //   197: iand
      //   198: iconst_2
      //   199: if_icmpne +208 -> 407
      //   202: aload_0
      //   203: getfield 99	com/umeng/message/proguard/j$c:j	Lcom/umeng/message/proguard/j$e;
      //   206: invokevirtual 105	com/umeng/message/proguard/j$e:u	()Lcom/umeng/message/proguard/j$e$a;
      //   209: astore 10
      //   211: aload_0
      //   212: aload_1
      //   213: getstatic 106	com/umeng/message/proguard/j$e:a	Lcom/umeng/message/proguard/B;
      //   216: aload_2
      //   217: invokevirtual 91	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   220: checkcast 101	com/umeng/message/proguard/j$e
      //   223: putfield 99	com/umeng/message/proguard/j$c:j	Lcom/umeng/message/proguard/j$e;
      //   226: aload 10
      //   228: ifnull +22 -> 250
      //   231: aload 10
      //   233: aload_0
      //   234: getfield 99	com/umeng/message/proguard/j$c:j	Lcom/umeng/message/proguard/j$e;
      //   237: invokevirtual 111	com/umeng/message/proguard/j$e$a:a	(Lcom/umeng/message/proguard/j$e;)Lcom/umeng/message/proguard/j$e$a;
      //   240: pop
      //   241: aload_0
      //   242: aload 10
      //   244: invokevirtual 115	com/umeng/message/proguard/j$e$a:v	()Lcom/umeng/message/proguard/j$e;
      //   247: putfield 99	com/umeng/message/proguard/j$c:j	Lcom/umeng/message/proguard/j$e;
      //   250: aload_0
      //   251: iconst_2
      //   252: aload_0
      //   253: getfield 75	com/umeng/message/proguard/j$c:g	I
      //   256: ior
      //   257: putfield 75	com/umeng/message/proguard/j$c:g	I
      //   260: iload_3
      //   261: istore 12
      //   263: iload 5
      //   265: istore 13
      //   267: goto +160 -> 427
      //   270: astore 8
      //   272: aload 8
      //   274: aload_0
      //   275: invokevirtual 118	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   278: athrow
      //   279: astore 7
      //   281: iload 5
      //   283: iconst_2
      //   284: iand
      //   285: iconst_2
      //   286: if_icmpne +14 -> 300
      //   289: aload_0
      //   290: aload_0
      //   291: getfield 85	com/umeng/message/proguard/j$c:i	Ljava/util/List;
      //   294: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   297: putfield 85	com/umeng/message/proguard/j$c:i	Ljava/util/List;
      //   300: aload_0
      //   301: aload 4
      //   303: invokevirtual 129	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   306: putfield 131	com/umeng/message/proguard/j$c:f	Lcom/umeng/message/proguard/P;
      //   309: aload_0
      //   310: invokevirtual 134	com/umeng/message/proguard/j$c:ad	()V
      //   313: aload 7
      //   315: athrow
      //   316: astore 6
      //   318: new 53	com/umeng/message/proguard/s
      //   321: dup
      //   322: aload 6
      //   324: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
      //   327: invokespecial 141	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   330: aload_0
      //   331: invokevirtual 118	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   334: athrow
      //   335: iload 5
      //   337: iconst_2
      //   338: iand
      //   339: iconst_2
      //   340: if_icmpne +14 -> 354
      //   343: aload_0
      //   344: aload_0
      //   345: getfield 85	com/umeng/message/proguard/j$c:i	Ljava/util/List;
      //   348: invokestatic 124	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   351: putfield 85	com/umeng/message/proguard/j$c:i	Ljava/util/List;
      //   354: aload_0
      //   355: aload 4
      //   357: invokevirtual 129	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   360: putfield 131	com/umeng/message/proguard/j$c:f	Lcom/umeng/message/proguard/P;
      //   363: aload_0
      //   364: invokevirtual 134	com/umeng/message/proguard/j$c:ad	()V
      //   367: return
      //   368: astore 17
      //   370: iload 14
      //   372: istore 5
      //   374: aload 17
      //   376: astore 7
      //   378: goto -97 -> 281
      //   381: astore 16
      //   383: iload 14
      //   385: istore 5
      //   387: aload 16
      //   389: astore 6
      //   391: goto -73 -> 318
      //   394: astore 15
      //   396: iload 14
      //   398: istore 5
      //   400: aload 15
      //   402: astore 8
      //   404: goto -132 -> 272
      //   407: aconst_null
      //   408: astore 10
      //   410: goto -199 -> 211
      //   413: iload 5
      //   415: istore 14
      //   417: goto -257 -> 160
      //   420: iload_3
      //   421: istore 12
      //   423: iload 5
      //   425: istore 13
      //   427: iload 13
      //   429: istore 5
      //   431: iload 12
      //   433: istore_3
      //   434: goto -406 -> 28
      //   437: iconst_1
      //   438: istore 12
      //   440: iload 5
      //   442: istore 13
      //   444: goto -17 -> 427
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	270	com/umeng/message/proguard/s
      //   84	97	270	com/umeng/message/proguard/s
      //   107	125	270	com/umeng/message/proguard/s
      //   143	154	270	com/umeng/message/proguard/s
      //   192	211	270	com/umeng/message/proguard/s
      //   211	226	270	com/umeng/message/proguard/s
      //   231	250	270	com/umeng/message/proguard/s
      //   250	260	270	com/umeng/message/proguard/s
      //   32	38	279	finally
      //   84	97	279	finally
      //   107	125	279	finally
      //   143	154	279	finally
      //   192	211	279	finally
      //   211	226	279	finally
      //   231	250	279	finally
      //   250	260	279	finally
      //   272	279	279	finally
      //   318	335	279	finally
      //   32	38	316	java/io/IOException
      //   84	97	316	java/io/IOException
      //   107	125	316	java/io/IOException
      //   143	154	316	java/io/IOException
      //   192	211	316	java/io/IOException
      //   211	226	316	java/io/IOException
      //   231	250	316	java/io/IOException
      //   250	260	316	java/io/IOException
      //   160	178	368	finally
      //   160	178	381	java/io/IOException
      //   160	178	394	com/umeng/message/proguard/s
    }

    private c(p.a<?> parama)
    {
      super();
      this.f = parama.b_();
    }

    private c(boolean paramBoolean)
    {
      this.f = P.c();
    }

    public static a a(c paramc)
    {
      return w().a(paramc);
    }

    public static c a(g paramg)
      throws s
    {
      return (c)a.d(paramg);
    }

    public static c a(g paramg, n paramn)
      throws s
    {
      return (c)a.d(paramg, paramn);
    }

    public static c a(h paramh)
      throws IOException
    {
      return (c)a.d(paramh);
    }

    public static c a(h paramh, n paramn)
      throws IOException
    {
      return (c)a.b(paramh, paramn);
    }

    public static c a(InputStream paramInputStream)
      throws IOException
    {
      return (c)a.h(paramInputStream);
    }

    public static c a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (c)a.h(paramInputStream, paramn);
    }

    public static c a(byte[] paramArrayOfByte)
      throws s
    {
      return (c)a.d(paramArrayOfByte);
    }

    public static c a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (c)a.d(paramArrayOfByte, paramn);
    }

    public static c b(InputStream paramInputStream)
      throws IOException
    {
      return (c)a.f(paramInputStream);
    }

    public static c b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (c)a.f(paramInputStream, paramn);
    }

    public static c h()
    {
      return e;
    }

    public static final k.a k()
    {
      return j.l();
    }

    public static a w()
    {
      return a.G();
    }

    private void z()
    {
      this.h = "";
      this.i = Collections.emptyList();
      this.j = j.e.h();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public j.g a(int paramInt)
    {
      return (j.g)this.i.get(paramInt);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      if ((0x1 & this.g) == 1)
        parami.a(1, p());
      for (int m = 0; m < this.i.size(); m++)
        parami.c(2, (y)this.i.get(m));
      if ((0x2 & this.g) == 2)
        parami.c(3, this.j);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.k;
      if (m != -1)
        return m == 1;
      for (int i1 = 0; i1 < s(); i1++)
        if (!a(i1).a())
        {
          this.k = 0;
          return false;
        }
      if ((t()) && (!u().a()))
      {
        this.k = 0;
        return false;
      }
      this.k = 1;
      return true;
    }

    public j.h b(int paramInt)
    {
      return (j.h)this.i.get(paramInt);
    }

    public final P b_()
    {
      return this.f;
    }

    public int d()
    {
      int m = 0;
      int i1 = this.l;
      if (i1 != -1)
        return i1;
      if ((0x1 & this.g) == 1);
      for (int i2 = 0 + i.c(1, p()); ; i2 = 0)
      {
        int i5;
        for (int i3 = i2; m < this.i.size(); i3 = i5)
        {
          i5 = i3 + i.g(2, (y)this.i.get(m));
          m++;
        }
        if ((0x2 & this.g) == 2)
          i3 += i.g(3, this.j);
        int i4 = i3 + b_().d();
        this.l = i4;
        return i4;
      }
    }

    public c i()
    {
      return e;
    }

    protected p.g l()
    {
      return j.m().a(c.class, a.class);
    }

    public B<c> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.g) == 1;
    }

    public String o()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.h = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.h = localg;
        return localg;
      }
      return (g)localObject;
    }

    public List<j.g> q()
    {
      return this.i;
    }

    public List<? extends j.h> r()
    {
      return this.i;
    }

    public int s()
    {
      return this.i.size();
    }

    public boolean t()
    {
      return (0x2 & this.g) == 2;
    }

    public j.e u()
    {
      return this.j;
    }

    public j.f v()
    {
      return this.j;
    }

    public a x()
    {
      return w();
    }

    public a y()
    {
      return a(this);
    }

    public static final class a extends p.a<a>
      implements j.d
    {
      private int a;
      private Object b = "";
      private List<j.g> c = Collections.emptyList();
      private D<j.g, j.g.a, j.h> d;
      private j.e e = j.e.h();
      private L<j.e, j.e.a, j.f> f;

      private a()
      {
        H();
      }

      private a(p.b paramb)
      {
        super();
        H();
      }

      private void H()
      {
        if (p.m)
        {
          L();
          M();
        }
      }

      private static a I()
      {
        return new a();
      }

      private void K()
      {
        if ((0x2 & this.a) != 2)
        {
          this.c = new ArrayList(this.c);
          this.a = (0x2 | this.a);
        }
      }

      private D<j.g, j.g.a, j.h> L()
      {
        List localList;
        if (this.d == null)
        {
          localList = this.c;
          if ((0x2 & this.a) != 2)
            break label55;
        }
        label55: for (boolean bool = true; ; bool = false)
        {
          this.d = new D(localList, bool, aE(), aD());
          this.c = null;
          return this.d;
        }
      }

      private L<j.e, j.e.a, j.f> M()
      {
        if (this.f == null)
        {
          this.f = new L(this.e, aE(), aD());
          this.e = null;
        }
        return this.f;
      }

      public static final k.a k()
      {
        return j.l();
      }

      public a A()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.c.h().o();
        aF();
        return this;
      }

      public a B()
      {
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          aF();
          return this;
        }
        this.d.e();
        return this;
      }

      public j.g.a C()
      {
        return (j.g.a)L().b(j.g.h());
      }

      public List<j.g.a> D()
      {
        return L().h();
      }

      public a E()
      {
        if (this.f == null)
        {
          this.e = j.e.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFFFB & this.a);
          return this;
          this.f.g();
        }
      }

      public j.e.a F()
      {
        this.a = (0x4 | this.a);
        aF();
        return (j.e.a)M().e();
      }

      public k.a J()
      {
        return j.l();
      }

      public a a(int paramInt, j.g.a parama)
      {
        if (this.d == null)
        {
          K();
          this.c.set(paramInt, parama.x());
          aF();
          return this;
        }
        this.d.a(paramInt, parama.x());
        return this;
      }

      public a a(int paramInt, j.g paramg)
      {
        if (this.d == null)
        {
          if (paramg == null)
            throw new NullPointerException();
          K();
          this.c.set(paramInt, paramg);
          aF();
          return this;
        }
        this.d.a(paramInt, paramg);
        return this;
      }

      public a a(j.c paramc)
      {
        if (paramc == j.c.h())
          return this;
        if (paramc.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.c.b(paramc);
          aF();
        }
        if (this.d == null)
          if (!j.c.c(paramc).isEmpty())
          {
            if (!this.c.isEmpty())
              break label119;
            this.c = j.c.c(paramc);
            this.a = (0xFFFFFFFD & this.a);
            aF();
          }
        while (true)
        {
          if (paramc.t())
            b(paramc.u());
          d(paramc.b_());
          return this;
          label119: K();
          this.c.addAll(j.c.c(paramc));
          break;
          if (!j.c.c(paramc).isEmpty())
            if (this.d.d())
            {
              this.d.b();
              this.d = null;
              this.c = j.c.c(paramc);
              this.a = (0xFFFFFFFD & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = L();
              this.d = localD;
            }
            else
            {
              this.d.a(j.c.c(paramc));
            }
        }
      }

      public a a(j.e.a parama)
      {
        if (this.f == null)
        {
          this.e = parama.u();
          aF();
        }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.f.a(parama.u());
        }
      }

      public a a(j.e parame)
      {
        if (this.f == null)
        {
          if (parame == null)
            throw new NullPointerException();
          this.e = parame;
          aF();
        }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.f.a(parame);
        }
      }

      public a a(j.g.a parama)
      {
        if (this.d == null)
        {
          K();
          this.c.add(parama.x());
          aF();
          return this;
        }
        this.d.a(parama.x());
        return this;
      }

      public a a(j.g paramg)
      {
        if (this.d == null)
        {
          if (paramg == null)
            throw new NullPointerException();
          K();
          this.c.add(paramg);
          aF();
          return this;
        }
        this.d.a(paramg);
        return this;
      }

      public a a(Iterable<? extends j.g> paramIterable)
      {
        if (this.d == null)
        {
          K();
          p.a.a(paramIterable, this.c);
          aF();
          return this;
        }
        this.d.a(paramIterable);
        return this;
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public j.g a(int paramInt)
      {
        if (this.d == null)
          return (j.g)this.c.get(paramInt);
        return (j.g)this.d.a(paramInt);
      }

      public final boolean a()
      {
        int i = 0;
        if (i < s())
          if (a(i).a());
        while ((t()) && (!u().a()))
        {
          return false;
          i++;
          break;
        }
        return true;
      }

      public a b(int paramInt, j.g.a parama)
      {
        if (this.d == null)
        {
          K();
          this.c.add(paramInt, parama.x());
          aF();
          return this;
        }
        this.d.b(paramInt, parama.x());
        return this;
      }

      public a b(int paramInt, j.g paramg)
      {
        if (this.d == null)
        {
          if (paramg == null)
            throw new NullPointerException();
          K();
          this.c.add(paramInt, paramg);
          aF();
          return this;
        }
        this.d.b(paramInt, paramg);
        return this;
      }

      public a b(j.e parame)
      {
        if (this.f == null)
          if (((0x4 & this.a) == 4) && (this.e != j.e.h()))
          {
            this.e = j.e.a(this.e).a(parame).v();
            aF();
          }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.e = parame;
          break;
          this.f.b(parame);
        }
      }

      public j.h b(int paramInt)
      {
        if (this.d == null)
          return (j.h)this.c.get(paramInt);
        return (j.h)this.d.c(paramInt);
      }

      public a c(int paramInt)
      {
        if (this.d == null)
        {
          K();
          this.c.remove(paramInt);
          aF();
          return this;
        }
        this.d.d(paramInt);
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.c))
          return a((j.c)paramx);
        super.a(paramx);
        return this;
      }

      public j.g.a d(int paramInt)
      {
        return (j.g.a)L().b(paramInt);
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.c localc3 = (j.c)j.c.a.d(paramh, paramn);
          if (localc3 != null)
            a(localc3);
          return this;
        }
        catch (s locals)
        {
          j.c localc2 = (j.c)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localc1 = localc2;
          }
          if (localc1 != null)
            a(localc1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.c localc1 = null;
        }
      }

      public j.g.a e(int paramInt)
      {
        return (j.g.a)L().c(paramInt, j.g.h());
      }

      protected p.g l()
      {
        return j.m().a(j.c.class, a.class);
      }

      public a m()
      {
        super.ah();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          if (this.f != null)
            break label84;
          this.e = j.e.h();
        }
        while (true)
        {
          this.a = (0xFFFFFFFB & this.a);
          return this;
          this.d.e();
          break;
          label84: this.f.g();
        }
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public List<j.g> q()
      {
        if (this.d == null)
          return Collections.unmodifiableList(this.c);
        return this.d.g();
      }

      public List<? extends j.h> r()
      {
        if (this.d != null)
          return this.d.i();
        return Collections.unmodifiableList(this.c);
      }

      public int s()
      {
        if (this.d == null)
          return this.c.size();
        return this.d.c();
      }

      public boolean t()
      {
        return (0x4 & this.a) == 4;
      }

      public j.e u()
      {
        if (this.f == null)
          return this.e;
        return (j.e)this.f.c();
      }

      public j.f v()
      {
        if (this.f != null)
          return (j.f)this.f.f();
        return this.e;
      }

      public a w()
      {
        return I().a(z());
      }

      public j.c x()
      {
        return j.c.h();
      }

      public j.c y()
      {
        j.c localc = z();
        if (!localc.a())
          throw b(localc);
        return localc;
      }

      public j.c z()
      {
        int i = 1;
        j.c localc = new j.c(this, null);
        int j = this.a;
        if ((j & 0x1) == i);
        while (true)
        {
          j.c.a(localc, this.b);
          if (this.d == null)
          {
            if ((0x2 & this.a) == 2)
            {
              this.c = Collections.unmodifiableList(this.c);
              this.a = (0xFFFFFFFD & this.a);
            }
            j.c.a(localc, this.c);
            if ((j & 0x4) != 4)
              break label155;
          }
          label155: for (int k = i | 0x2; ; k = i)
          {
            if (this.f == null)
              j.c.a(localc, this.e);
            while (true)
            {
              j.c.a(localc, k);
              aB();
              return localc;
              j.c.a(localc, this.d.f());
              break;
              j.c.a(localc, (j.e)this.f.d());
            }
          }
          i = 0;
        }
      }
    }
  }

  public static abstract interface d extends A
  {
    public abstract j.g a(int paramInt);

    public abstract j.h b(int paramInt);

    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract List<j.g> q();

    public abstract List<? extends j.h> r();

    public abstract int s();

    public abstract boolean t();

    public abstract j.e u();

    public abstract j.f v();
  }

  public static final class e extends p.d<e>
    implements j.f
  {
    public static B<e> a = new c()
    {
      public j.e c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.e(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 2;
    public static final int c = 999;
    private static final e d = new e(true);
    private static final long k;
    private final P e;
    private int f;
    private boolean g;
    private List<j.G> h;
    private byte i = -1;
    private int j = -1;

    static
    {
      d.v();
    }

    // ERROR //
    private e(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 53	com/umeng/message/proguard/p$d:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 55	com/umeng/message/proguard/j$e:i	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 57	com/umeng/message/proguard/j$e:j	I
      //   16: aload_0
      //   17: invokespecial 47	com/umeng/message/proguard/j$e:v	()V
      //   20: invokestatic 62	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +197 -> 226
      //   32: aload_1
      //   33: invokevirtual 67	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+36->76, 0:+219->259, 16:+54->94, 7994:+121->161
      //   77: aload_1
      //   78: aload 4
      //   80: aload_2
      //   81: iload 9
      //   83: invokevirtual 70	com/umeng/message/proguard/j$e:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   86: ifne -58 -> 28
      //   89: iconst_1
      //   90: istore_3
      //   91: goto -63 -> 28
      //   94: aload_0
      //   95: iconst_1
      //   96: aload_0
      //   97: getfield 72	com/umeng/message/proguard/j$e:f	I
      //   100: ior
      //   101: putfield 72	com/umeng/message/proguard/j$e:f	I
      //   104: aload_0
      //   105: aload_1
      //   106: invokevirtual 75	com/umeng/message/proguard/h:j	()Z
      //   109: putfield 77	com/umeng/message/proguard/j$e:g	Z
      //   112: goto -84 -> 28
      //   115: astore 8
      //   117: aload 8
      //   119: aload_0
      //   120: invokevirtual 80	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   123: athrow
      //   124: astore 7
      //   126: iload 5
      //   128: iconst_2
      //   129: iand
      //   130: iconst_2
      //   131: if_icmpne +14 -> 145
      //   134: aload_0
      //   135: aload_0
      //   136: getfield 82	com/umeng/message/proguard/j$e:h	Ljava/util/List;
      //   139: invokestatic 88	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   142: putfield 82	com/umeng/message/proguard/j$e:h	Ljava/util/List;
      //   145: aload_0
      //   146: aload 4
      //   148: invokevirtual 93	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   151: putfield 95	com/umeng/message/proguard/j$e:e	Lcom/umeng/message/proguard/P;
      //   154: aload_0
      //   155: invokevirtual 98	com/umeng/message/proguard/j$e:ad	()V
      //   158: aload 7
      //   160: athrow
      //   161: iload 5
      //   163: iconst_2
      //   164: iand
      //   165: iconst_2
      //   166: if_icmpeq +20 -> 186
      //   169: aload_0
      //   170: new 100	java/util/ArrayList
      //   173: dup
      //   174: invokespecial 101	java/util/ArrayList:<init>	()V
      //   177: putfield 82	com/umeng/message/proguard/j$e:h	Ljava/util/List;
      //   180: iload 5
      //   182: iconst_2
      //   183: ior
      //   184: istore 5
      //   186: aload_0
      //   187: getfield 82	com/umeng/message/proguard/j$e:h	Ljava/util/List;
      //   190: aload_1
      //   191: getstatic 104	com/umeng/message/proguard/j$G:a	Lcom/umeng/message/proguard/B;
      //   194: aload_2
      //   195: invokevirtual 107	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   198: invokeinterface 113 2 0
      //   203: pop
      //   204: goto -176 -> 28
      //   207: astore 6
      //   209: new 50	com/umeng/message/proguard/s
      //   212: dup
      //   213: aload 6
      //   215: invokevirtual 117	java/io/IOException:getMessage	()Ljava/lang/String;
      //   218: invokespecial 120	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   221: aload_0
      //   222: invokevirtual 80	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   225: athrow
      //   226: iload 5
      //   228: iconst_2
      //   229: iand
      //   230: iconst_2
      //   231: if_icmpne +14 -> 245
      //   234: aload_0
      //   235: aload_0
      //   236: getfield 82	com/umeng/message/proguard/j$e:h	Ljava/util/List;
      //   239: invokestatic 88	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   242: putfield 82	com/umeng/message/proguard/j$e:h	Ljava/util/List;
      //   245: aload_0
      //   246: aload 4
      //   248: invokevirtual 93	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   251: putfield 95	com/umeng/message/proguard/j$e:e	Lcom/umeng/message/proguard/P;
      //   254: aload_0
      //   255: invokevirtual 98	com/umeng/message/proguard/j$e:ad	()V
      //   258: return
      //   259: iconst_1
      //   260: istore_3
      //   261: goto -233 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	115	com/umeng/message/proguard/s
      //   76	89	115	com/umeng/message/proguard/s
      //   94	112	115	com/umeng/message/proguard/s
      //   169	180	115	com/umeng/message/proguard/s
      //   186	204	115	com/umeng/message/proguard/s
      //   32	38	124	finally
      //   76	89	124	finally
      //   94	112	124	finally
      //   117	124	124	finally
      //   169	180	124	finally
      //   186	204	124	finally
      //   209	226	124	finally
      //   32	38	207	java/io/IOException
      //   76	89	207	java/io/IOException
      //   94	112	207	java/io/IOException
      //   169	180	207	java/io/IOException
      //   186	204	207	java/io/IOException
    }

    private e(p.c<e, ?> paramc)
    {
      super();
      this.e = paramc.b_();
    }

    private e(boolean paramBoolean)
    {
      this.e = P.c();
    }

    public static a a(e parame)
    {
      return s().a(parame);
    }

    public static e a(g paramg)
      throws s
    {
      return (e)a.d(paramg);
    }

    public static e a(g paramg, n paramn)
      throws s
    {
      return (e)a.d(paramg, paramn);
    }

    public static e a(h paramh)
      throws IOException
    {
      return (e)a.d(paramh);
    }

    public static e a(h paramh, n paramn)
      throws IOException
    {
      return (e)a.b(paramh, paramn);
    }

    public static e a(InputStream paramInputStream)
      throws IOException
    {
      return (e)a.h(paramInputStream);
    }

    public static e a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (e)a.h(paramInputStream, paramn);
    }

    public static e a(byte[] paramArrayOfByte)
      throws s
    {
      return (e)a.d(paramArrayOfByte);
    }

    public static e a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (e)a.d(paramArrayOfByte, paramn);
    }

    public static e b(InputStream paramInputStream)
      throws IOException
    {
      return (e)a.f(paramInputStream);
    }

    public static e b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (e)a.f(paramInputStream, paramn);
    }

    public static e h()
    {
      return d;
    }

    public static final k.a k()
    {
      return j.z();
    }

    public static a s()
    {
      return a.C();
    }

    private void v()
    {
      this.g = true;
      this.h = Collections.emptyList();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public j.G a(int paramInt)
    {
      return (j.G)this.h.get(paramInt);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      p.d.a locala = X();
      if ((0x1 & this.f) == 1)
        parami.a(2, this.g);
      for (int m = 0; m < this.h.size(); m++)
        parami.c(999, (y)this.h.get(m));
      locala.a(536870912, parami);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.i;
      if (m != -1)
        return m == 1;
      for (int n = 0; n < r(); n++)
        if (!a(n).a())
        {
          this.i = 0;
          return false;
        }
      if (!W())
      {
        this.i = 0;
        return false;
      }
      this.i = 1;
      return true;
    }

    public j.H b(int paramInt)
    {
      return (j.H)this.h.get(paramInt);
    }

    public final P b_()
    {
      return this.e;
    }

    public int d()
    {
      int m = 0;
      int n = this.j;
      if (n != -1)
        return n;
      if ((0x1 & this.f) == 1);
      for (int i1 = 0 + i.b(2, this.g); ; i1 = 0)
      {
        int i4;
        for (int i2 = i1; m < this.h.size(); i2 = i4)
        {
          i4 = i2 + i.g(999, (y)this.h.get(m));
          m++;
        }
        int i3 = i2 + Z() + b_().d();
        this.j = i3;
        return i3;
      }
    }

    public e i()
    {
      return d;
    }

    protected p.g l()
    {
      return j.A().a(e.class, a.class);
    }

    public B<e> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.f) == 1;
    }

    public boolean o()
    {
      return this.g;
    }

    public List<j.G> p()
    {
      return this.h;
    }

    public List<? extends j.H> q()
    {
      return this.h;
    }

    public int r()
    {
      return this.h.size();
    }

    public a t()
    {
      return s();
    }

    public a u()
    {
      return a(this);
    }

    public static final class a extends p.c<j.e, a>
      implements j.f
    {
      private int a;
      private boolean b = true;
      private List<j.G> c = Collections.emptyList();
      private D<j.G, j.G.a, j.H> d;

      private a()
      {
        D();
      }

      private a(p.b paramb)
      {
        super();
        D();
      }

      private void D()
      {
        if (p.m)
          G();
      }

      private static a E()
      {
        return new a();
      }

      private void F()
      {
        if ((0x2 & this.a) != 2)
        {
          this.c = new ArrayList(this.c);
          this.a = (0x2 | this.a);
        }
      }

      private D<j.G, j.G.a, j.H> G()
      {
        List localList;
        if (this.d == null)
        {
          localList = this.c;
          if ((0x2 & this.a) != 2)
            break label55;
        }
        label55: for (boolean bool = true; ; bool = false)
        {
          this.d = new D(localList, bool, aE(), aD());
          this.c = null;
          return this.d;
        }
      }

      public static final k.a k()
      {
        return j.z();
      }

      public k.a J()
      {
        return j.z();
      }

      public j.G a(int paramInt)
      {
        if (this.d == null)
          return (j.G)this.c.get(paramInt);
        return (j.G)this.d.a(paramInt);
      }

      public a a(int paramInt, j.G.a parama)
      {
        if (this.d == null)
        {
          F();
          this.c.set(paramInt, parama.G());
          aF();
          return this;
        }
        this.d.a(paramInt, parama.G());
        return this;
      }

      public a a(int paramInt, j.G paramG)
      {
        if (this.d == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          F();
          this.c.set(paramInt, paramG);
          aF();
          return this;
        }
        this.d.a(paramInt, paramG);
        return this;
      }

      public a a(j.G.a parama)
      {
        if (this.d == null)
        {
          F();
          this.c.add(parama.G());
          aF();
          return this;
        }
        this.d.a(parama.G());
        return this;
      }

      public a a(j.G paramG)
      {
        if (this.d == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          F();
          this.c.add(paramG);
          aF();
          return this;
        }
        this.d.a(paramG);
        return this;
      }

      public a a(j.e parame)
      {
        if (parame == j.e.h())
          return this;
        if (parame.n())
          a(parame.o());
        if (this.d == null)
          if (!j.e.b(parame).isEmpty())
          {
            if (!this.c.isEmpty())
              break label95;
            this.c = j.e.b(parame);
            this.a = (0xFFFFFFFD & this.a);
            aF();
          }
        while (true)
        {
          a(parame);
          d(parame.b_());
          return this;
          label95: F();
          this.c.addAll(j.e.b(parame));
          break;
          if (!j.e.b(parame).isEmpty())
            if (this.d.d())
            {
              this.d.b();
              this.d = null;
              this.c = j.e.b(parame);
              this.a = (0xFFFFFFFD & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = G();
              this.d = localD;
            }
            else
            {
              this.d.a(j.e.b(parame));
            }
        }
      }

      public a a(Iterable<? extends j.G> paramIterable)
      {
        if (this.d == null)
        {
          F();
          p.c.a(paramIterable, this.c);
          aF();
          return this;
        }
        this.d.a(paramIterable);
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.a = (0x1 | this.a);
        this.b = paramBoolean;
        aF();
        return this;
      }

      public final boolean a()
      {
        int i = 0;
        if (i < r())
          if (a(i).a());
        while (!af())
        {
          return false;
          i++;
          break;
        }
        return true;
      }

      public j.H b(int paramInt)
      {
        if (this.d == null)
          return (j.H)this.c.get(paramInt);
        return (j.H)this.d.c(paramInt);
      }

      public a b(int paramInt, j.G.a parama)
      {
        if (this.d == null)
        {
          F();
          this.c.add(paramInt, parama.G());
          aF();
          return this;
        }
        this.d.b(paramInt, parama.G());
        return this;
      }

      public a b(int paramInt, j.G paramG)
      {
        if (this.d == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          F();
          this.c.add(paramInt, paramG);
          aF();
          return this;
        }
        this.d.b(paramInt, paramG);
        return this;
      }

      public a c(int paramInt)
      {
        if (this.d == null)
        {
          F();
          this.c.remove(paramInt);
          aF();
          return this;
        }
        this.d.d(paramInt);
        return this;
      }

      public j.G.a d(int paramInt)
      {
        return (j.G.a)G().b(paramInt);
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.e))
          return a((j.e)paramx);
        super.a(paramx);
        return this;
      }

      public j.G.a e(int paramInt)
      {
        return (j.G.a)G().c(paramInt, j.G.h());
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.e locale3 = (j.e)j.e.a.d(paramh, paramn);
          if (locale3 != null)
            a(locale3);
          return this;
        }
        catch (s locals)
        {
          j.e locale2 = (j.e)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            locale1 = locale2;
          }
          if (locale1 != null)
            a(locale1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.e locale1 = null;
        }
      }

      protected p.g l()
      {
        return j.A().a(j.e.class, a.class);
      }

      public a m()
      {
        super.B();
        this.b = true;
        this.a = (0xFFFFFFFE & this.a);
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          return this;
        }
        this.d.e();
        return this;
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public boolean o()
      {
        return this.b;
      }

      public List<j.G> p()
      {
        if (this.d == null)
          return Collections.unmodifiableList(this.c);
        return this.d.g();
      }

      public List<? extends j.H> q()
      {
        if (this.d != null)
          return this.d.i();
        return Collections.unmodifiableList(this.c);
      }

      public int r()
      {
        if (this.d == null)
          return this.c.size();
        return this.d.c();
      }

      public a s()
      {
        return E().a(v());
      }

      public j.e t()
      {
        return j.e.h();
      }

      public j.e u()
      {
        j.e locale = v();
        if (!locale.a())
          throw b(locale);
        return locale;
      }

      public j.e v()
      {
        int i = 1;
        j.e locale = new j.e(this, null);
        if ((0x1 & this.a) == i);
        while (true)
        {
          j.e.a(locale, this.b);
          if (this.d == null)
          {
            if ((0x2 & this.a) == 2)
            {
              this.c = Collections.unmodifiableList(this.c);
              this.a = (0xFFFFFFFD & this.a);
            }
            j.e.a(locale, this.c);
          }
          while (true)
          {
            j.e.a(locale, i);
            aB();
            return locale;
            j.e.a(locale, this.d.f());
          }
          i = 0;
        }
      }

      public a w()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = true;
        aF();
        return this;
      }

      public a x()
      {
        if (this.d == null)
        {
          this.c = Collections.emptyList();
          this.a = (0xFFFFFFFD & this.a);
          aF();
          return this;
        }
        this.d.e();
        return this;
      }

      public j.G.a y()
      {
        return (j.G.a)G().b(j.G.h());
      }

      public List<j.G.a> z()
      {
        return G().h();
      }
    }
  }

  public static abstract interface f extends p.e<j.e>
  {
    public abstract j.G a(int paramInt);

    public abstract j.H b(int paramInt);

    public abstract boolean n();

    public abstract boolean o();

    public abstract List<j.G> p();

    public abstract List<? extends j.H> q();

    public abstract int r();
  }

  public static final class g extends p
    implements j.h
  {
    public static B<g> a = new c()
    {
      public j.g c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.g(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    private static final g e = new g(true);
    private static final long n;
    private final P f;
    private int g;
    private Object h;
    private int i;
    private j.i j;
    private byte k = -1;
    private int l = -1;

    static
    {
      e.y();
    }

    // ERROR //
    private g(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 54	com/umeng/message/proguard/p:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 56	com/umeng/message/proguard/j$g:k	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 58	com/umeng/message/proguard/j$g:l	I
      //   14: aload_0
      //   15: invokespecial 48	com/umeng/message/proguard/j$g:y	()V
      //   18: invokestatic 63	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   21: astore_3
      //   22: iconst_0
      //   23: istore 4
      //   25: iload 4
      //   27: ifne +241 -> 268
      //   30: aload_1
      //   31: invokevirtual 68	com/umeng/message/proguard/h:a	()I
      //   34: istore 8
      //   36: iload 8
      //   38: lookupswitch	default:+42->80, 0:+260->298, 10:+60->98, 16:+85->123, 26:+110->148
      //   81: aload_1
      //   82: aload_3
      //   83: aload_2
      //   84: iload 8
      //   86: invokevirtual 71	com/umeng/message/proguard/j$g:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   89: ifne +198 -> 287
      //   92: iconst_1
      //   93: istore 11
      //   95: goto +196 -> 291
      //   98: aload_0
      //   99: iconst_1
      //   100: aload_0
      //   101: getfield 73	com/umeng/message/proguard/j$g:g	I
      //   104: ior
      //   105: putfield 73	com/umeng/message/proguard/j$g:g	I
      //   108: aload_0
      //   109: aload_1
      //   110: invokevirtual 76	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   113: putfield 78	com/umeng/message/proguard/j$g:h	Ljava/lang/Object;
      //   116: iload 4
      //   118: istore 11
      //   120: goto +171 -> 291
      //   123: aload_0
      //   124: iconst_2
      //   125: aload_0
      //   126: getfield 73	com/umeng/message/proguard/j$g:g	I
      //   129: ior
      //   130: putfield 73	com/umeng/message/proguard/j$g:g	I
      //   133: aload_0
      //   134: aload_1
      //   135: invokevirtual 80	com/umeng/message/proguard/h:g	()I
      //   138: putfield 82	com/umeng/message/proguard/j$g:i	I
      //   141: iload 4
      //   143: istore 11
      //   145: goto +146 -> 291
      //   148: iconst_4
      //   149: aload_0
      //   150: getfield 73	com/umeng/message/proguard/j$g:g	I
      //   153: iand
      //   154: iconst_4
      //   155: if_icmpne +126 -> 281
      //   158: aload_0
      //   159: getfield 84	com/umeng/message/proguard/j$g:j	Lcom/umeng/message/proguard/j$i;
      //   162: invokevirtual 90	com/umeng/message/proguard/j$i:s	()Lcom/umeng/message/proguard/j$i$a;
      //   165: astore 9
      //   167: aload_0
      //   168: aload_1
      //   169: getstatic 91	com/umeng/message/proguard/j$i:a	Lcom/umeng/message/proguard/B;
      //   172: aload_2
      //   173: invokevirtual 94	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   176: checkcast 86	com/umeng/message/proguard/j$i
      //   179: putfield 84	com/umeng/message/proguard/j$g:j	Lcom/umeng/message/proguard/j$i;
      //   182: aload 9
      //   184: ifnull +22 -> 206
      //   187: aload 9
      //   189: aload_0
      //   190: getfield 84	com/umeng/message/proguard/j$g:j	Lcom/umeng/message/proguard/j$i;
      //   193: invokevirtual 99	com/umeng/message/proguard/j$i$a:a	(Lcom/umeng/message/proguard/j$i;)Lcom/umeng/message/proguard/j$i$a;
      //   196: pop
      //   197: aload_0
      //   198: aload 9
      //   200: invokevirtual 103	com/umeng/message/proguard/j$i$a:t	()Lcom/umeng/message/proguard/j$i;
      //   203: putfield 84	com/umeng/message/proguard/j$g:j	Lcom/umeng/message/proguard/j$i;
      //   206: aload_0
      //   207: iconst_4
      //   208: aload_0
      //   209: getfield 73	com/umeng/message/proguard/j$g:g	I
      //   212: ior
      //   213: putfield 73	com/umeng/message/proguard/j$g:g	I
      //   216: iload 4
      //   218: istore 11
      //   220: goto +71 -> 291
      //   223: astore 7
      //   225: aload 7
      //   227: aload_0
      //   228: invokevirtual 106	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   231: athrow
      //   232: astore 6
      //   234: aload_0
      //   235: aload_3
      //   236: invokevirtual 111	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   239: putfield 113	com/umeng/message/proguard/j$g:f	Lcom/umeng/message/proguard/P;
      //   242: aload_0
      //   243: invokevirtual 116	com/umeng/message/proguard/j$g:ad	()V
      //   246: aload 6
      //   248: athrow
      //   249: astore 5
      //   251: new 51	com/umeng/message/proguard/s
      //   254: dup
      //   255: aload 5
      //   257: invokevirtual 120	java/io/IOException:getMessage	()Ljava/lang/String;
      //   260: invokespecial 123	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   263: aload_0
      //   264: invokevirtual 106	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   267: athrow
      //   268: aload_0
      //   269: aload_3
      //   270: invokevirtual 111	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   273: putfield 113	com/umeng/message/proguard/j$g:f	Lcom/umeng/message/proguard/P;
      //   276: aload_0
      //   277: invokevirtual 116	com/umeng/message/proguard/j$g:ad	()V
      //   280: return
      //   281: aconst_null
      //   282: astore 9
      //   284: goto -117 -> 167
      //   287: iload 4
      //   289: istore 11
      //   291: iload 11
      //   293: istore 4
      //   295: goto -270 -> 25
      //   298: iconst_1
      //   299: istore 11
      //   301: goto -10 -> 291
      //
      // Exception table:
      //   from	to	target	type
      //   30	36	223	com/umeng/message/proguard/s
      //   80	92	223	com/umeng/message/proguard/s
      //   98	116	223	com/umeng/message/proguard/s
      //   123	141	223	com/umeng/message/proguard/s
      //   148	167	223	com/umeng/message/proguard/s
      //   167	182	223	com/umeng/message/proguard/s
      //   187	206	223	com/umeng/message/proguard/s
      //   206	216	223	com/umeng/message/proguard/s
      //   30	36	232	finally
      //   80	92	232	finally
      //   98	116	232	finally
      //   123	141	232	finally
      //   148	167	232	finally
      //   167	182	232	finally
      //   187	206	232	finally
      //   206	216	232	finally
      //   225	232	232	finally
      //   251	268	232	finally
      //   30	36	249	java/io/IOException
      //   80	92	249	java/io/IOException
      //   98	116	249	java/io/IOException
      //   123	141	249	java/io/IOException
      //   148	167	249	java/io/IOException
      //   167	182	249	java/io/IOException
      //   187	206	249	java/io/IOException
      //   206	216	249	java/io/IOException
    }

    private g(p.a<?> parama)
    {
      super();
      this.f = parama.b_();
    }

    private g(boolean paramBoolean)
    {
      this.f = P.c();
    }

    public static a a(g paramg)
    {
      return v().a(paramg);
    }

    public static g a(g paramg)
      throws s
    {
      return (g)a.d(paramg);
    }

    public static g a(g paramg, n paramn)
      throws s
    {
      return (g)a.d(paramg, paramn);
    }

    public static g a(h paramh)
      throws IOException
    {
      return (g)a.d(paramh);
    }

    public static g a(h paramh, n paramn)
      throws IOException
    {
      return (g)a.b(paramh, paramn);
    }

    public static g a(InputStream paramInputStream)
      throws IOException
    {
      return (g)a.h(paramInputStream);
    }

    public static g a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (g)a.h(paramInputStream, paramn);
    }

    public static g a(byte[] paramArrayOfByte)
      throws s
    {
      return (g)a.d(paramArrayOfByte);
    }

    public static g a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (g)a.d(paramArrayOfByte, paramn);
    }

    public static g b(InputStream paramInputStream)
      throws IOException
    {
      return (g)a.f(paramInputStream);
    }

    public static g b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (g)a.f(paramInputStream, paramn);
    }

    public static g h()
    {
      return e;
    }

    public static final k.a k()
    {
      return j.n();
    }

    public static a v()
    {
      return a.D();
    }

    private void y()
    {
      this.h = "";
      this.i = 0;
      this.j = j.i.h();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      if ((0x1 & this.g) == 1)
        parami.a(1, p());
      if ((0x2 & this.g) == 2)
        parami.a(2, this.i);
      if ((0x4 & this.g) == 4)
        parami.c(3, this.j);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.k;
      if (m != -1)
        return m == 1;
      if ((s()) && (!t().a()))
      {
        this.k = 0;
        return false;
      }
      this.k = 1;
      return true;
    }

    public final P b_()
    {
      return this.f;
    }

    public int d()
    {
      int m = this.l;
      if (m != -1)
        return m;
      int i1 = 0x1 & this.g;
      int i2 = 0;
      if (i1 == 1)
        i2 = 0 + i.c(1, p());
      if ((0x2 & this.g) == 2)
        i2 += i.g(2, this.i);
      if ((0x4 & this.g) == 4)
        i2 += i.g(3, this.j);
      int i3 = i2 + b_().d();
      this.l = i3;
      return i3;
    }

    public g i()
    {
      return e;
    }

    protected p.g l()
    {
      return j.o().a(g.class, a.class);
    }

    public B<g> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.g) == 1;
    }

    public String o()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.h = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.h = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean q()
    {
      return (0x2 & this.g) == 2;
    }

    public int r()
    {
      return this.i;
    }

    public boolean s()
    {
      return (0x4 & this.g) == 4;
    }

    public j.i t()
    {
      return this.j;
    }

    public j.j u()
    {
      return this.j;
    }

    public a w()
    {
      return v();
    }

    public a x()
    {
      return a(this);
    }

    public static final class a extends p.a<a>
      implements j.h
    {
      private int a;
      private Object b = "";
      private int c;
      private j.i d = j.i.h();
      private L<j.i, j.i.a, j.j> e;

      private a()
      {
        E();
      }

      private a(p.b paramb)
      {
        super();
        E();
      }

      private void E()
      {
        if (p.m)
          G();
      }

      private static a F()
      {
        return new a();
      }

      private L<j.i, j.i.a, j.j> G()
      {
        if (this.e == null)
        {
          this.e = new L(this.d, aE(), aD());
          this.d = null;
        }
        return this.e;
      }

      public static final k.a k()
      {
        return j.n();
      }

      public a A()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.c = 0;
        aF();
        return this;
      }

      public a B()
      {
        if (this.e == null)
        {
          this.d = j.i.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFFFB & this.a);
          return this;
          this.e.g();
        }
      }

      public j.i.a C()
      {
        this.a = (0x4 | this.a);
        aF();
        return (j.i.a)G().e();
      }

      public k.a J()
      {
        return j.n();
      }

      public a a(int paramInt)
      {
        this.a = (0x2 | this.a);
        this.c = paramInt;
        aF();
        return this;
      }

      public a a(j.g paramg)
      {
        if (paramg == j.g.h())
          return this;
        if (paramg.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.g.b(paramg);
          aF();
        }
        if (paramg.q())
          a(paramg.r());
        if (paramg.s())
          b(paramg.t());
        d(paramg.b_());
        return this;
      }

      public a a(j.i.a parama)
      {
        if (this.e == null)
        {
          this.d = parama.s();
          aF();
        }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.e.a(parama.s());
        }
      }

      public a a(j.i parami)
      {
        if (this.e == null)
        {
          if (parami == null)
            throw new NullPointerException();
          this.d = parami;
          aF();
        }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.e.a(parami);
        }
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public final boolean a()
      {
        return (!s()) || (t().a());
      }

      public a b(j.i parami)
      {
        if (this.e == null)
          if (((0x4 & this.a) == 4) && (this.d != j.i.h()))
          {
            this.d = j.i.a(this.d).a(parami).t();
            aF();
          }
        while (true)
        {
          this.a = (0x4 | this.a);
          return this;
          this.d = parami;
          break;
          this.e.b(parami);
        }
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.g))
          return a((j.g)paramx);
        super.a(paramx);
        return this;
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.g localg3 = (j.g)j.g.a.d(paramh, paramn);
          if (localg3 != null)
            a(localg3);
          return this;
        }
        catch (s locals)
        {
          j.g localg2 = (j.g)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localg1 = localg2;
          }
          if (localg1 != null)
            a(localg1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.g localg1 = null;
        }
      }

      protected p.g l()
      {
        return j.o().a(j.g.class, a.class);
      }

      public a m()
      {
        super.ah();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        this.c = 0;
        this.a = (0xFFFFFFFD & this.a);
        if (this.e == null)
          this.d = j.i.h();
        while (true)
        {
          this.a = (0xFFFFFFFB & this.a);
          return this;
          this.e.g();
        }
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean q()
      {
        return (0x2 & this.a) == 2;
      }

      public int r()
      {
        return this.c;
      }

      public boolean s()
      {
        return (0x4 & this.a) == 4;
      }

      public j.i t()
      {
        if (this.e == null)
          return this.d;
        return (j.i)this.e.c();
      }

      public j.j u()
      {
        if (this.e != null)
          return (j.j)this.e.f();
        return this.d;
      }

      public a v()
      {
        return F().a(y());
      }

      public j.g w()
      {
        return j.g.h();
      }

      public j.g x()
      {
        j.g localg = y();
        if (!localg.a())
          throw b(localg);
        return localg;
      }

      public j.g y()
      {
        int i = 1;
        j.g localg = new j.g(this, null);
        int j = this.a;
        if ((j & 0x1) == i);
        while (true)
        {
          j.g.a(localg, this.b);
          if ((j & 0x2) == 2)
            i |= 2;
          j.g.a(localg, this.c);
          if ((j & 0x4) == 4);
          for (int k = i | 0x4; ; k = i)
          {
            if (this.e == null)
              j.g.a(localg, this.d);
            while (true)
            {
              j.g.b(localg, k);
              aB();
              return localg;
              j.g.a(localg, (j.i)this.e.d());
            }
          }
          i = 0;
        }
      }

      public a z()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.g.h().o();
        aF();
        return this;
      }
    }
  }

  public static abstract interface h extends A
  {
    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract boolean q();

    public abstract int r();

    public abstract boolean s();

    public abstract j.i t();

    public abstract j.j u();
  }

  public static final class i extends p.d<i>
    implements j.j
  {
    public static B<i> a = new c()
    {
      public j.i c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.i(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 999;
    private static final i c = new i(true);
    private static final long h;
    private final P d;
    private List<j.G> e;
    private byte f = -1;
    private int g = -1;

    static
    {
      c.t();
    }

    // ERROR //
    private i(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 48	com/umeng/message/proguard/p$d:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 50	com/umeng/message/proguard/j$i:f	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 52	com/umeng/message/proguard/j$i:g	I
      //   16: aload_0
      //   17: invokespecial 42	com/umeng/message/proguard/j$i:t	()V
      //   20: invokestatic 57	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +168 -> 197
      //   32: aload_1
      //   33: invokevirtual 62	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+28->68, 0:+190->230, 7994:+46->86
      //   69: aload_1
      //   70: aload 4
      //   72: aload_2
      //   73: iload 9
      //   75: invokevirtual 65	com/umeng/message/proguard/j$i:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   78: ifne -50 -> 28
      //   81: iconst_1
      //   82: istore_3
      //   83: goto -55 -> 28
      //   86: iload 5
      //   88: iconst_1
      //   89: iand
      //   90: iconst_1
      //   91: if_icmpeq +20 -> 111
      //   94: aload_0
      //   95: new 67	java/util/ArrayList
      //   98: dup
      //   99: invokespecial 68	java/util/ArrayList:<init>	()V
      //   102: putfield 70	com/umeng/message/proguard/j$i:e	Ljava/util/List;
      //   105: iload 5
      //   107: iconst_1
      //   108: ior
      //   109: istore 5
      //   111: aload_0
      //   112: getfield 70	com/umeng/message/proguard/j$i:e	Ljava/util/List;
      //   115: aload_1
      //   116: getstatic 73	com/umeng/message/proguard/j$G:a	Lcom/umeng/message/proguard/B;
      //   119: aload_2
      //   120: invokevirtual 76	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   123: invokeinterface 82 2 0
      //   128: pop
      //   129: goto -101 -> 28
      //   132: astore 8
      //   134: aload 8
      //   136: aload_0
      //   137: invokevirtual 85	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   140: athrow
      //   141: astore 7
      //   143: iload 5
      //   145: iconst_1
      //   146: iand
      //   147: iconst_1
      //   148: if_icmpne +14 -> 162
      //   151: aload_0
      //   152: aload_0
      //   153: getfield 70	com/umeng/message/proguard/j$i:e	Ljava/util/List;
      //   156: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   159: putfield 70	com/umeng/message/proguard/j$i:e	Ljava/util/List;
      //   162: aload_0
      //   163: aload 4
      //   165: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   168: putfield 98	com/umeng/message/proguard/j$i:d	Lcom/umeng/message/proguard/P;
      //   171: aload_0
      //   172: invokevirtual 101	com/umeng/message/proguard/j$i:ad	()V
      //   175: aload 7
      //   177: athrow
      //   178: astore 6
      //   180: new 45	com/umeng/message/proguard/s
      //   183: dup
      //   184: aload 6
      //   186: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
      //   189: invokespecial 108	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   192: aload_0
      //   193: invokevirtual 85	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   196: athrow
      //   197: iload 5
      //   199: iconst_1
      //   200: iand
      //   201: iconst_1
      //   202: if_icmpne +14 -> 216
      //   205: aload_0
      //   206: aload_0
      //   207: getfield 70	com/umeng/message/proguard/j$i:e	Ljava/util/List;
      //   210: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   213: putfield 70	com/umeng/message/proguard/j$i:e	Ljava/util/List;
      //   216: aload_0
      //   217: aload 4
      //   219: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   222: putfield 98	com/umeng/message/proguard/j$i:d	Lcom/umeng/message/proguard/P;
      //   225: aload_0
      //   226: invokevirtual 101	com/umeng/message/proguard/j$i:ad	()V
      //   229: return
      //   230: iconst_1
      //   231: istore_3
      //   232: goto -204 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	132	com/umeng/message/proguard/s
      //   68	81	132	com/umeng/message/proguard/s
      //   94	105	132	com/umeng/message/proguard/s
      //   111	129	132	com/umeng/message/proguard/s
      //   32	38	141	finally
      //   68	81	141	finally
      //   94	105	141	finally
      //   111	129	141	finally
      //   134	141	141	finally
      //   180	197	141	finally
      //   32	38	178	java/io/IOException
      //   68	81	178	java/io/IOException
      //   94	105	178	java/io/IOException
      //   111	129	178	java/io/IOException
    }

    private i(p.c<i, ?> paramc)
    {
      super();
      this.d = paramc.b_();
    }

    private i(boolean paramBoolean)
    {
      this.d = P.c();
    }

    public static a a(i parami)
    {
      return q().a(parami);
    }

    public static i a(g paramg)
      throws s
    {
      return (i)a.d(paramg);
    }

    public static i a(g paramg, n paramn)
      throws s
    {
      return (i)a.d(paramg, paramn);
    }

    public static i a(h paramh)
      throws IOException
    {
      return (i)a.d(paramh);
    }

    public static i a(h paramh, n paramn)
      throws IOException
    {
      return (i)a.b(paramh, paramn);
    }

    public static i a(InputStream paramInputStream)
      throws IOException
    {
      return (i)a.h(paramInputStream);
    }

    public static i a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (i)a.h(paramInputStream, paramn);
    }

    public static i a(byte[] paramArrayOfByte)
      throws s
    {
      return (i)a.d(paramArrayOfByte);
    }

    public static i a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (i)a.d(paramArrayOfByte, paramn);
    }

    public static i b(InputStream paramInputStream)
      throws IOException
    {
      return (i)a.f(paramInputStream);
    }

    public static i b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (i)a.f(paramInputStream, paramn);
    }

    public static i h()
    {
      return c;
    }

    public static final k.a k()
    {
      return j.B();
    }

    public static a q()
    {
      return a.x();
    }

    private void t()
    {
      this.e = Collections.emptyList();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public j.G a(int paramInt)
    {
      return (j.G)this.e.get(paramInt);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      p.d.a locala = X();
      for (int i = 0; i < this.e.size(); i++)
        parami.c(999, (y)this.e.get(i));
      locala.a(536870912, parami);
      b_().a(parami);
    }

    public final boolean a()
    {
      int i = this.f;
      if (i != -1)
        return i == 1;
      for (int j = 0; j < p(); j++)
        if (!a(j).a())
        {
          this.f = 0;
          return false;
        }
      if (!W())
      {
        this.f = 0;
        return false;
      }
      this.f = 1;
      return true;
    }

    public j.H b(int paramInt)
    {
      return (j.H)this.e.get(paramInt);
    }

    public final P b_()
    {
      return this.d;
    }

    public int d()
    {
      int i = this.g;
      if (i != -1)
        return i;
      int j = 0;
      int k = 0;
      while (j < this.e.size())
      {
        k += i.g(999, (y)this.e.get(j));
        j++;
      }
      int m = k + Z() + b_().d();
      this.g = m;
      return m;
    }

    public i i()
    {
      return c;
    }

    protected p.g l()
    {
      return j.C().a(i.class, a.class);
    }

    public B<i> m()
    {
      return a;
    }

    public List<j.G> n()
    {
      return this.e;
    }

    public List<? extends j.H> o()
    {
      return this.e;
    }

    public int p()
    {
      return this.e.size();
    }

    public a r()
    {
      return q();
    }

    public a s()
    {
      return a(this);
    }

    public static final class a extends p.c<j.i, a>
      implements j.j
    {
      private int a;
      private List<j.G> b = Collections.emptyList();
      private D<j.G, j.G.a, j.H> c;

      private a()
      {
        y();
      }

      private a(p.b paramb)
      {
        super();
        y();
      }

      private void C()
      {
        if ((0x1 & this.a) != 1)
        {
          this.b = new ArrayList(this.b);
          this.a = (0x1 | this.a);
        }
      }

      private D<j.G, j.G.a, j.H> D()
      {
        int i = 1;
        List localList;
        if (this.c == null)
        {
          localList = this.b;
          if ((0x1 & this.a) != i)
            break label55;
        }
        while (true)
        {
          this.c = new D(localList, i, aE(), aD());
          this.b = null;
          return this.c;
          label55: int j = 0;
        }
      }

      public static final k.a k()
      {
        return j.B();
      }

      private void y()
      {
        if (p.m)
          D();
      }

      private static a z()
      {
        return new a();
      }

      public k.a J()
      {
        return j.B();
      }

      public j.G a(int paramInt)
      {
        if (this.c == null)
          return (j.G)this.b.get(paramInt);
        return (j.G)this.c.a(paramInt);
      }

      public a a(int paramInt, j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.set(paramInt, parama.G());
          aF();
          return this;
        }
        this.c.a(paramInt, parama.G());
        return this;
      }

      public a a(int paramInt, j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.set(paramInt, paramG);
          aF();
          return this;
        }
        this.c.a(paramInt, paramG);
        return this;
      }

      public a a(j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.add(parama.G());
          aF();
          return this;
        }
        this.c.a(parama.G());
        return this;
      }

      public a a(j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.add(paramG);
          aF();
          return this;
        }
        this.c.a(paramG);
        return this;
      }

      public a a(j.i parami)
      {
        if (parami == j.i.h())
          return this;
        if (this.c == null)
          if (!j.i.b(parami).isEmpty())
          {
            if (!this.b.isEmpty())
              break label79;
            this.b = j.i.b(parami);
            this.a = (0xFFFFFFFE & this.a);
            aF();
          }
        while (true)
        {
          a(parami);
          d(parami.b_());
          return this;
          label79: C();
          this.b.addAll(j.i.b(parami));
          break;
          if (!j.i.b(parami).isEmpty())
            if (this.c.d())
            {
              this.c.b();
              this.c = null;
              this.b = j.i.b(parami);
              this.a = (0xFFFFFFFE & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = D();
              this.c = localD;
            }
            else
            {
              this.c.a(j.i.b(parami));
            }
        }
      }

      public a a(Iterable<? extends j.G> paramIterable)
      {
        if (this.c == null)
        {
          C();
          p.c.a(paramIterable, this.b);
          aF();
          return this;
        }
        this.c.a(paramIterable);
        return this;
      }

      public final boolean a()
      {
        int i = 0;
        if (i < p())
          if (a(i).a());
        while (!af())
        {
          return false;
          i++;
          break;
        }
        return true;
      }

      public j.H b(int paramInt)
      {
        if (this.c == null)
          return (j.H)this.b.get(paramInt);
        return (j.H)this.c.c(paramInt);
      }

      public a b(int paramInt, j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.add(paramInt, parama.G());
          aF();
          return this;
        }
        this.c.b(paramInt, parama.G());
        return this;
      }

      public a b(int paramInt, j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.add(paramInt, paramG);
          aF();
          return this;
        }
        this.c.b(paramInt, paramG);
        return this;
      }

      public a c(int paramInt)
      {
        if (this.c == null)
        {
          C();
          this.b.remove(paramInt);
          aF();
          return this;
        }
        this.c.d(paramInt);
        return this;
      }

      public j.G.a d(int paramInt)
      {
        return (j.G.a)D().b(paramInt);
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.i))
          return a((j.i)paramx);
        super.a(paramx);
        return this;
      }

      public j.G.a e(int paramInt)
      {
        return (j.G.a)D().c(paramInt, j.G.h());
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.i locali3 = (j.i)j.i.a.d(paramh, paramn);
          if (locali3 != null)
            a(locali3);
          return this;
        }
        catch (s locals)
        {
          j.i locali2 = (j.i)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            locali1 = locali2;
          }
          if (locali1 != null)
            a(locali1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.i locali1 = null;
        }
      }

      protected p.g l()
      {
        return j.C().a(j.i.class, a.class);
      }

      public a m()
      {
        super.B();
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          return this;
        }
        this.c.e();
        return this;
      }

      public List<j.G> n()
      {
        if (this.c == null)
          return Collections.unmodifiableList(this.b);
        return this.c.g();
      }

      public List<? extends j.H> o()
      {
        if (this.c != null)
          return this.c.i();
        return Collections.unmodifiableList(this.b);
      }

      public int p()
      {
        if (this.c == null)
          return this.b.size();
        return this.c.c();
      }

      public a q()
      {
        return z().a(t());
      }

      public j.i r()
      {
        return j.i.h();
      }

      public j.i s()
      {
        j.i locali = t();
        if (!locali.a())
          throw b(locali);
        return locali;
      }

      public j.i t()
      {
        j.i locali = new j.i(this, null);
        if (this.c == null)
        {
          if ((0x1 & this.a) == 1)
          {
            this.b = Collections.unmodifiableList(this.b);
            this.a = (0xFFFFFFFE & this.a);
          }
          j.i.a(locali, this.b);
        }
        while (true)
        {
          aB();
          return locali;
          j.i.a(locali, this.c.f());
        }
      }

      public a u()
      {
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          aF();
          return this;
        }
        this.c.e();
        return this;
      }

      public j.G.a v()
      {
        return (j.G.a)D().b(j.G.h());
      }

      public List<j.G.a> w()
      {
        return D().h();
      }
    }
  }

  public static abstract interface j extends p.e<j.i>
  {
    public abstract j.G a(int paramInt);

    public abstract j.H b(int paramInt);

    public abstract List<j.G> n();

    public abstract List<? extends j.H> o();

    public abstract int p();
  }

  public static final class k extends p
    implements j.l
  {
    public static B<k> a = new c()
    {
      public j.k c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.k(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 2;
    public static final int h = 7;
    public static final int i = 8;
    private static final k j = new k(true);
    private static final long x;
    private final P k;
    private int l;
    private Object n;
    private int o;
    private b p;
    private c q;
    private Object r;
    private Object s;
    private Object t;
    private j.m u;
    private byte v = -1;
    private int w = -1;

    static
    {
      j.T();
    }

    // ERROR //
    private k(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 71	com/umeng/message/proguard/p:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 73	com/umeng/message/proguard/j$k:v	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 75	com/umeng/message/proguard/j$k:w	I
      //   14: aload_0
      //   15: invokespecial 65	com/umeng/message/proguard/j$k:T	()V
      //   18: invokestatic 80	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   21: astore_3
      //   22: iconst_0
      //   23: istore 4
      //   25: iload 4
      //   27: ifne +478 -> 505
      //   30: aload_1
      //   31: invokevirtual 85	com/umeng/message/proguard/h:a	()I
      //   34: istore 8
      //   36: iload 8
      //   38: lookupswitch	default:+82->120, 0:+497->535, 10:+100->138, 18:+125->163, 24:+151->189, 32:+176->214, 40:+232->270, 50:+289->327, 58:+315->353, 66:+341->379
      //   121: aload_1
      //   122: aload_3
      //   123: aload_2
      //   124: iload 8
      //   126: invokevirtual 88	com/umeng/message/proguard/j$k:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   129: ifne +395 -> 524
      //   132: iconst_1
      //   133: istore 11
      //   135: goto +393 -> 528
      //   138: aload_0
      //   139: iconst_1
      //   140: aload_0
      //   141: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   144: ior
      //   145: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   148: aload_0
      //   149: aload_1
      //   150: invokevirtual 93	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   153: putfield 95	com/umeng/message/proguard/j$k:n	Ljava/lang/Object;
      //   156: iload 4
      //   158: istore 11
      //   160: goto +368 -> 528
      //   163: aload_0
      //   164: bipush 32
      //   166: aload_0
      //   167: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   170: ior
      //   171: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   174: aload_0
      //   175: aload_1
      //   176: invokevirtual 93	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   179: putfield 97	com/umeng/message/proguard/j$k:s	Ljava/lang/Object;
      //   182: iload 4
      //   184: istore 11
      //   186: goto +342 -> 528
      //   189: aload_0
      //   190: iconst_2
      //   191: aload_0
      //   192: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   195: ior
      //   196: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   199: aload_0
      //   200: aload_1
      //   201: invokevirtual 99	com/umeng/message/proguard/h:g	()I
      //   204: putfield 101	com/umeng/message/proguard/j$k:o	I
      //   207: iload 4
      //   209: istore 11
      //   211: goto +317 -> 528
      //   214: aload_1
      //   215: invokevirtual 103	com/umeng/message/proguard/h:n	()I
      //   218: istore 15
      //   220: iload 15
      //   222: invokestatic 108	com/umeng/message/proguard/j$k$b:a	(I)Lcom/umeng/message/proguard/j$k$b;
      //   225: astore 16
      //   227: aload 16
      //   229: ifnonnull +18 -> 247
      //   232: aload_3
      //   233: iconst_4
      //   234: iload 15
      //   236: invokevirtual 113	com/umeng/message/proguard/P$a:a	(II)Lcom/umeng/message/proguard/P$a;
      //   239: pop
      //   240: iload 4
      //   242: istore 11
      //   244: goto +284 -> 528
      //   247: aload_0
      //   248: iconst_4
      //   249: aload_0
      //   250: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   253: ior
      //   254: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   257: aload_0
      //   258: aload 16
      //   260: putfield 115	com/umeng/message/proguard/j$k:p	Lcom/umeng/message/proguard/j$k$b;
      //   263: iload 4
      //   265: istore 11
      //   267: goto +261 -> 528
      //   270: aload_1
      //   271: invokevirtual 103	com/umeng/message/proguard/h:n	()I
      //   274: istore 12
      //   276: iload 12
      //   278: invokestatic 120	com/umeng/message/proguard/j$k$c:a	(I)Lcom/umeng/message/proguard/j$k$c;
      //   281: astore 13
      //   283: aload 13
      //   285: ifnonnull +18 -> 303
      //   288: aload_3
      //   289: iconst_5
      //   290: iload 12
      //   292: invokevirtual 113	com/umeng/message/proguard/P$a:a	(II)Lcom/umeng/message/proguard/P$a;
      //   295: pop
      //   296: iload 4
      //   298: istore 11
      //   300: goto +228 -> 528
      //   303: aload_0
      //   304: bipush 8
      //   306: aload_0
      //   307: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   310: ior
      //   311: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   314: aload_0
      //   315: aload 13
      //   317: putfield 122	com/umeng/message/proguard/j$k:q	Lcom/umeng/message/proguard/j$k$c;
      //   320: iload 4
      //   322: istore 11
      //   324: goto +204 -> 528
      //   327: aload_0
      //   328: bipush 16
      //   330: aload_0
      //   331: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   334: ior
      //   335: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   338: aload_0
      //   339: aload_1
      //   340: invokevirtual 93	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   343: putfield 124	com/umeng/message/proguard/j$k:r	Ljava/lang/Object;
      //   346: iload 4
      //   348: istore 11
      //   350: goto +178 -> 528
      //   353: aload_0
      //   354: bipush 64
      //   356: aload_0
      //   357: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   360: ior
      //   361: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   364: aload_0
      //   365: aload_1
      //   366: invokevirtual 93	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   369: putfield 126	com/umeng/message/proguard/j$k:t	Ljava/lang/Object;
      //   372: iload 4
      //   374: istore 11
      //   376: goto +152 -> 528
      //   379: sipush 128
      //   382: aload_0
      //   383: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   386: iand
      //   387: sipush 128
      //   390: if_icmpne +128 -> 518
      //   393: aload_0
      //   394: getfield 128	com/umeng/message/proguard/j$k:u	Lcom/umeng/message/proguard/j$m;
      //   397: invokevirtual 134	com/umeng/message/proguard/j$m:F	()Lcom/umeng/message/proguard/j$m$a;
      //   400: astore 9
      //   402: aload_0
      //   403: aload_1
      //   404: getstatic 135	com/umeng/message/proguard/j$m:a	Lcom/umeng/message/proguard/B;
      //   407: aload_2
      //   408: invokevirtual 138	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   411: checkcast 130	com/umeng/message/proguard/j$m
      //   414: putfield 128	com/umeng/message/proguard/j$k:u	Lcom/umeng/message/proguard/j$m;
      //   417: aload 9
      //   419: ifnull +22 -> 441
      //   422: aload 9
      //   424: aload_0
      //   425: getfield 128	com/umeng/message/proguard/j$k:u	Lcom/umeng/message/proguard/j$m;
      //   428: invokevirtual 143	com/umeng/message/proguard/j$m$a:a	(Lcom/umeng/message/proguard/j$m;)Lcom/umeng/message/proguard/j$m$a;
      //   431: pop
      //   432: aload_0
      //   433: aload 9
      //   435: invokevirtual 147	com/umeng/message/proguard/j$m$a:G	()Lcom/umeng/message/proguard/j$m;
      //   438: putfield 128	com/umeng/message/proguard/j$k:u	Lcom/umeng/message/proguard/j$m;
      //   441: aload_0
      //   442: sipush 128
      //   445: aload_0
      //   446: getfield 90	com/umeng/message/proguard/j$k:l	I
      //   449: ior
      //   450: putfield 90	com/umeng/message/proguard/j$k:l	I
      //   453: iload 4
      //   455: istore 11
      //   457: goto +71 -> 528
      //   460: astore 7
      //   462: aload 7
      //   464: aload_0
      //   465: invokevirtual 150	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   468: athrow
      //   469: astore 6
      //   471: aload_0
      //   472: aload_3
      //   473: invokevirtual 153	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   476: putfield 155	com/umeng/message/proguard/j$k:k	Lcom/umeng/message/proguard/P;
      //   479: aload_0
      //   480: invokevirtual 158	com/umeng/message/proguard/j$k:ad	()V
      //   483: aload 6
      //   485: athrow
      //   486: astore 5
      //   488: new 68	com/umeng/message/proguard/s
      //   491: dup
      //   492: aload 5
      //   494: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
      //   497: invokespecial 165	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   500: aload_0
      //   501: invokevirtual 150	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   504: athrow
      //   505: aload_0
      //   506: aload_3
      //   507: invokevirtual 153	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   510: putfield 155	com/umeng/message/proguard/j$k:k	Lcom/umeng/message/proguard/P;
      //   513: aload_0
      //   514: invokevirtual 158	com/umeng/message/proguard/j$k:ad	()V
      //   517: return
      //   518: aconst_null
      //   519: astore 9
      //   521: goto -119 -> 402
      //   524: iload 4
      //   526: istore 11
      //   528: iload 11
      //   530: istore 4
      //   532: goto -507 -> 25
      //   535: iconst_1
      //   536: istore 11
      //   538: goto -10 -> 528
      //
      // Exception table:
      //   from	to	target	type
      //   30	36	460	com/umeng/message/proguard/s
      //   120	132	460	com/umeng/message/proguard/s
      //   138	156	460	com/umeng/message/proguard/s
      //   163	182	460	com/umeng/message/proguard/s
      //   189	207	460	com/umeng/message/proguard/s
      //   214	227	460	com/umeng/message/proguard/s
      //   232	240	460	com/umeng/message/proguard/s
      //   247	263	460	com/umeng/message/proguard/s
      //   270	283	460	com/umeng/message/proguard/s
      //   288	296	460	com/umeng/message/proguard/s
      //   303	320	460	com/umeng/message/proguard/s
      //   327	346	460	com/umeng/message/proguard/s
      //   353	372	460	com/umeng/message/proguard/s
      //   379	402	460	com/umeng/message/proguard/s
      //   402	417	460	com/umeng/message/proguard/s
      //   422	441	460	com/umeng/message/proguard/s
      //   441	453	460	com/umeng/message/proguard/s
      //   30	36	469	finally
      //   120	132	469	finally
      //   138	156	469	finally
      //   163	182	469	finally
      //   189	207	469	finally
      //   214	227	469	finally
      //   232	240	469	finally
      //   247	263	469	finally
      //   270	283	469	finally
      //   288	296	469	finally
      //   303	320	469	finally
      //   327	346	469	finally
      //   353	372	469	finally
      //   379	402	469	finally
      //   402	417	469	finally
      //   422	441	469	finally
      //   441	453	469	finally
      //   462	469	469	finally
      //   488	505	469	finally
      //   30	36	486	java/io/IOException
      //   120	132	486	java/io/IOException
      //   138	156	486	java/io/IOException
      //   163	182	486	java/io/IOException
      //   189	207	486	java/io/IOException
      //   214	227	486	java/io/IOException
      //   232	240	486	java/io/IOException
      //   247	263	486	java/io/IOException
      //   270	283	486	java/io/IOException
      //   288	296	486	java/io/IOException
      //   303	320	486	java/io/IOException
      //   327	346	486	java/io/IOException
      //   353	372	486	java/io/IOException
      //   379	402	486	java/io/IOException
      //   402	417	486	java/io/IOException
      //   422	441	486	java/io/IOException
      //   441	453	486	java/io/IOException
    }

    private k(p.a<?> parama)
    {
      super();
      this.k = parama.b_();
    }

    private k(boolean paramBoolean)
    {
      this.k = P.c();
    }

    public static a K()
    {
      return a.Y();
    }

    private void T()
    {
      this.n = "";
      this.o = 0;
      this.p = b.a;
      this.q = c.a;
      this.r = "";
      this.s = "";
      this.t = "";
      this.u = j.m.h();
    }

    public static a a(k paramk)
    {
      return K().a(paramk);
    }

    public static k a(g paramg)
      throws s
    {
      return (k)a.d(paramg);
    }

    public static k a(g paramg, n paramn)
      throws s
    {
      return (k)a.d(paramg, paramn);
    }

    public static k a(h paramh)
      throws IOException
    {
      return (k)a.d(paramh);
    }

    public static k a(h paramh, n paramn)
      throws IOException
    {
      return (k)a.b(paramh, paramn);
    }

    public static k a(InputStream paramInputStream)
      throws IOException
    {
      return (k)a.h(paramInputStream);
    }

    public static k a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (k)a.h(paramInputStream, paramn);
    }

    public static k a(byte[] paramArrayOfByte)
      throws s
    {
      return (k)a.d(paramArrayOfByte);
    }

    public static k a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (k)a.d(paramArrayOfByte, paramn);
    }

    public static k b(InputStream paramInputStream)
      throws IOException
    {
      return (k)a.f(paramInputStream);
    }

    public static k b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (k)a.f(paramInputStream, paramn);
    }

    public static k h()
    {
      return j;
    }

    public static final k.a k()
    {
      return j.j();
    }

    public String A()
    {
      Object localObject = this.s;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.s = str;
      return str;
    }

    public g B()
    {
      Object localObject = this.s;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.s = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean C()
    {
      return (0x40 & this.l) == 64;
    }

    public String D()
    {
      Object localObject = this.t;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.t = str;
      return str;
    }

    public g E()
    {
      Object localObject = this.t;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.t = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean F()
    {
      return (0x80 & this.l) == 128;
    }

    public j.m G()
    {
      return this.u;
    }

    public j.n H()
    {
      return this.u;
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public a L()
    {
      return K();
    }

    public a S()
    {
      return a(this);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      if ((0x1 & this.l) == 1)
        parami.a(1, p());
      if ((0x20 & this.l) == 32)
        parami.a(2, B());
      if ((0x2 & this.l) == 2)
        parami.a(3, this.o);
      if ((0x4 & this.l) == 4)
        parami.d(4, this.p.a());
      if ((0x8 & this.l) == 8)
        parami.d(5, this.q.a());
      if ((0x10 & this.l) == 16)
        parami.a(6, y());
      if ((0x40 & this.l) == 64)
        parami.a(7, E());
      if ((0x80 & this.l) == 128)
        parami.c(8, this.u);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.v;
      if (m != -1)
        return m == 1;
      if ((F()) && (!G().a()))
      {
        this.v = 0;
        return false;
      }
      this.v = 1;
      return true;
    }

    public final P b_()
    {
      return this.k;
    }

    public int d()
    {
      int m = this.w;
      if (m != -1)
        return m;
      int i1 = 0x1 & this.l;
      int i2 = 0;
      if (i1 == 1)
        i2 = 0 + i.c(1, p());
      if ((0x20 & this.l) == 32)
        i2 += i.c(2, B());
      if ((0x2 & this.l) == 2)
        i2 += i.g(3, this.o);
      if ((0x4 & this.l) == 4)
        i2 += i.j(4, this.p.a());
      if ((0x8 & this.l) == 8)
        i2 += i.j(5, this.q.a());
      if ((0x10 & this.l) == 16)
        i2 += i.c(6, y());
      if ((0x40 & this.l) == 64)
        i2 += i.c(7, E());
      if ((0x80 & this.l) == 128)
        i2 += i.g(8, this.u);
      int i3 = i2 + b_().d();
      this.w = i3;
      return i3;
    }

    public k i()
    {
      return j;
    }

    protected p.g l()
    {
      return j.k().a(k.class, a.class);
    }

    public B<k> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.l) == 1;
    }

    public String o()
    {
      Object localObject = this.n;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.n = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.n;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.n = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean q()
    {
      return (0x2 & this.l) == 2;
    }

    public int r()
    {
      return this.o;
    }

    public boolean s()
    {
      return (0x4 & this.l) == 4;
    }

    public b t()
    {
      return this.p;
    }

    public boolean u()
    {
      return (0x8 & this.l) == 8;
    }

    public c v()
    {
      return this.q;
    }

    public boolean w()
    {
      return (0x10 & this.l) == 16;
    }

    public String x()
    {
      Object localObject = this.r;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.r = str;
      return str;
    }

    public g y()
    {
      Object localObject = this.r;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.r = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean z()
    {
      return (0x20 & this.l) == 32;
    }

    public static final class a extends p.a<a>
      implements j.l
    {
      private int a;
      private Object b = "";
      private int c;
      private j.k.b d = j.k.b.a;
      private j.k.c e = j.k.c.a;
      private Object f = "";
      private Object g = "";
      private Object h = "";
      private j.m i = j.m.h();
      private L<j.m, j.m.a, j.n> j;

      private a()
      {
        Z();
      }

      private a(p.b paramb)
      {
        super();
        Z();
      }

      private void Z()
      {
        if (p.m)
          ab();
      }

      private static a aa()
      {
        return new a();
      }

      private L<j.m, j.m.a, j.n> ab()
      {
        if (this.j == null)
        {
          this.j = new L(this.i, aE(), aD());
          this.i = null;
        }
        return this.j;
      }

      public static final k.a k()
      {
        return j.j();
      }

      public String A()
      {
        Object localObject = this.g;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.g = str;
          return str;
        }
        return (String)localObject;
      }

      public g B()
      {
        Object localObject = this.g;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.g = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean C()
      {
        return (0x40 & this.a) == 64;
      }

      public String D()
      {
        Object localObject = this.h;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.h = str;
          return str;
        }
        return (String)localObject;
      }

      public g E()
      {
        Object localObject = this.h;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.h = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean F()
      {
        return (0x80 & this.a) == 128;
      }

      public j.m G()
      {
        if (this.j == null)
          return this.i;
        return (j.m)this.j.c();
      }

      public j.n H()
      {
        if (this.j != null)
          return (j.n)this.j.f();
        return this.i;
      }

      public a I()
      {
        return aa().a(M());
      }

      public k.a J()
      {
        return j.j();
      }

      public j.k K()
      {
        return j.k.h();
      }

      public j.k L()
      {
        j.k localk = M();
        if (!localk.a())
          throw b(localk);
        return localk;
      }

      public j.k M()
      {
        int k = 1;
        j.k localk = new j.k(this, null);
        int m = this.a;
        if ((m & 0x1) == k);
        while (true)
        {
          j.k.a(localk, this.b);
          if ((m & 0x2) == 2)
            k |= 2;
          j.k.a(localk, this.c);
          if ((m & 0x4) == 4)
            k |= 4;
          j.k.a(localk, this.d);
          if ((m & 0x8) == 8)
            k |= 8;
          j.k.a(localk, this.e);
          if ((m & 0x10) == 16)
            k |= 16;
          j.k.b(localk, this.f);
          if ((m & 0x20) == 32)
            k |= 32;
          j.k.c(localk, this.g);
          if ((m & 0x40) == 64)
            k |= 64;
          j.k.d(localk, this.h);
          if ((m & 0x80) == 128);
          for (int n = k | 0x80; ; n = k)
          {
            if (this.j == null)
              j.k.a(localk, this.i);
            while (true)
            {
              j.k.b(localk, n);
              aB();
              return localk;
              j.k.a(localk, (j.m)this.j.d());
            }
          }
          k = 0;
        }
      }

      public a N()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.k.h().o();
        aF();
        return this;
      }

      public a O()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.c = 0;
        aF();
        return this;
      }

      public a P()
      {
        this.a = (0xFFFFFFFB & this.a);
        this.d = j.k.b.a;
        aF();
        return this;
      }

      public a S()
      {
        this.a = (0xFFFFFFF7 & this.a);
        this.e = j.k.c.a;
        aF();
        return this;
      }

      public a T()
      {
        this.a = (0xFFFFFFEF & this.a);
        this.f = j.k.h().x();
        aF();
        return this;
      }

      public a U()
      {
        this.a = (0xFFFFFFDF & this.a);
        this.g = j.k.h().A();
        aF();
        return this;
      }

      public a V()
      {
        this.a = (0xFFFFFFBF & this.a);
        this.h = j.k.h().D();
        aF();
        return this;
      }

      public a W()
      {
        if (this.j == null)
        {
          this.i = j.m.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFF7F & this.a);
          return this;
          this.j.g();
        }
      }

      public j.m.a X()
      {
        this.a = (0x80 | this.a);
        aF();
        return (j.m.a)ab().e();
      }

      public a a(int paramInt)
      {
        this.a = (0x2 | this.a);
        this.c = paramInt;
        aF();
        return this;
      }

      public a a(j.k.b paramb)
      {
        if (paramb == null)
          throw new NullPointerException();
        this.a = (0x4 | this.a);
        this.d = paramb;
        aF();
        return this;
      }

      public a a(j.k.c paramc)
      {
        if (paramc == null)
          throw new NullPointerException();
        this.a = (0x8 | this.a);
        this.e = paramc;
        aF();
        return this;
      }

      public a a(j.k paramk)
      {
        if (paramk == j.k.h())
          return this;
        if (paramk.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.k.b(paramk);
          aF();
        }
        if (paramk.q())
          a(paramk.r());
        if (paramk.s())
          a(paramk.t());
        if (paramk.u())
          a(paramk.v());
        if (paramk.w())
        {
          this.a = (0x10 | this.a);
          this.f = j.k.c(paramk);
          aF();
        }
        if (paramk.z())
        {
          this.a = (0x20 | this.a);
          this.g = j.k.d(paramk);
          aF();
        }
        if (paramk.C())
        {
          this.a = (0x40 | this.a);
          this.h = j.k.e(paramk);
          aF();
        }
        if (paramk.F())
          b(paramk.G());
        d(paramk.b_());
        return this;
      }

      public a a(j.m.a parama)
      {
        if (this.j == null)
        {
          this.i = parama.F();
          aF();
        }
        while (true)
        {
          this.a = (0x80 | this.a);
          return this;
          this.j.a(parama.F());
        }
      }

      public a a(j.m paramm)
      {
        if (this.j == null)
        {
          if (paramm == null)
            throw new NullPointerException();
          this.i = paramm;
          aF();
        }
        while (true)
        {
          this.a = (0x80 | this.a);
          return this;
          this.j.a(paramm);
        }
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public final boolean a()
      {
        return (!F()) || (G().a());
      }

      public a b(j.m paramm)
      {
        if (this.j == null)
          if (((0x80 & this.a) == 128) && (this.i != j.m.h()))
          {
            this.i = j.m.a(this.i).a(paramm).G();
            aF();
          }
        while (true)
        {
          this.a = (0x80 | this.a);
          return this;
          this.i = paramm;
          break;
          this.j.b(paramm);
        }
      }

      public a b(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x10 | this.a);
        this.f = paramString;
        aF();
        return this;
      }

      public a c(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x20 | this.a);
        this.g = paramString;
        aF();
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.k))
          return a((j.k)paramx);
        super.a(paramx);
        return this;
      }

      public a d(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x40 | this.a);
        this.h = paramString;
        aF();
        return this;
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.k localk3 = (j.k)j.k.a.d(paramh, paramn);
          if (localk3 != null)
            a(localk3);
          return this;
        }
        catch (s locals)
        {
          j.k localk2 = (j.k)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localk1 = localk2;
          }
          if (localk1 != null)
            a(localk1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.k localk1 = null;
        }
      }

      public a f(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x10 | this.a);
        this.f = paramg;
        aF();
        return this;
      }

      public a g(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x20 | this.a);
        this.g = paramg;
        aF();
        return this;
      }

      public a h(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x40 | this.a);
        this.h = paramg;
        aF();
        return this;
      }

      protected p.g l()
      {
        return j.k().a(j.k.class, a.class);
      }

      public a m()
      {
        super.ah();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        this.c = 0;
        this.a = (0xFFFFFFFD & this.a);
        this.d = j.k.b.a;
        this.a = (0xFFFFFFFB & this.a);
        this.e = j.k.c.a;
        this.a = (0xFFFFFFF7 & this.a);
        this.f = "";
        this.a = (0xFFFFFFEF & this.a);
        this.g = "";
        this.a = (0xFFFFFFDF & this.a);
        this.h = "";
        this.a = (0xFFFFFFBF & this.a);
        if (this.j == null)
          this.i = j.m.h();
        while (true)
        {
          this.a = (0xFFFFFF7F & this.a);
          return this;
          this.j.g();
        }
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean q()
      {
        return (0x2 & this.a) == 2;
      }

      public int r()
      {
        return this.c;
      }

      public boolean s()
      {
        return (0x4 & this.a) == 4;
      }

      public j.k.b t()
      {
        return this.d;
      }

      public boolean u()
      {
        return (0x8 & this.a) == 8;
      }

      public j.k.c v()
      {
        return this.e;
      }

      public boolean w()
      {
        return (0x10 & this.a) == 16;
      }

      public String x()
      {
        Object localObject = this.f;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.f = str;
          return str;
        }
        return (String)localObject;
      }

      public g y()
      {
        Object localObject = this.f;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.f = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean z()
      {
        return (0x20 & this.a) == 32;
      }
    }

    public static enum b
      implements C
    {
      public static final int d = 1;
      public static final int e = 2;
      public static final int f = 3;
      private static r.b<b> g = new r.b()
      {
        public j.k.b a(int paramAnonymousInt)
        {
          return j.k.b.a(paramAnonymousInt);
        }
      };
      private static final b[] h = values();
      private final int i;
      private final int j;

      static
      {
        b[] arrayOfb = new b[3];
        arrayOfb[0] = a;
        arrayOfb[1] = b;
        arrayOfb[2] = c;
        k = arrayOfb;
      }

      private b(int paramInt1, int paramInt2)
      {
        this.i = paramInt1;
        this.j = paramInt2;
      }

      public static b a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 1:
          return a;
        case 2:
          return b;
        case 3:
        }
        return c;
      }

      public static b a(k.e parame)
      {
        if (parame.g() != e())
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        return h[parame.b()];
      }

      public static r.b<b> b()
      {
        return g;
      }

      public static final k.d e()
      {
        return (k.d)j.k.k().k().get(1);
      }

      public final int a()
      {
        return this.j;
      }

      public final k.e c()
      {
        return (k.e)e().h().get(this.i);
      }

      public final k.d d()
      {
        return e();
      }
    }

    public static enum c
      implements C
    {
      public static final int A = 9;
      public static final int B = 10;
      public static final int C = 11;
      public static final int D = 12;
      public static final int E = 13;
      public static final int F = 14;
      public static final int G = 15;
      public static final int H = 16;
      public static final int I = 17;
      public static final int J = 18;
      private static r.b<c> K = new r.b()
      {
        public j.k.c a(int paramAnonymousInt)
        {
          return j.k.c.a(paramAnonymousInt);
        }
      };
      private static final c[] L = values();
      public static final int s = 1;
      public static final int t = 2;
      public static final int u = 3;
      public static final int v = 4;
      public static final int w = 5;
      public static final int x = 6;
      public static final int y = 7;
      public static final int z = 8;
      private final int M;
      private final int N;

      static
      {
        c[] arrayOfc = new c[18];
        arrayOfc[0] = a;
        arrayOfc[1] = b;
        arrayOfc[2] = c;
        arrayOfc[3] = d;
        arrayOfc[4] = e;
        arrayOfc[5] = f;
        arrayOfc[6] = g;
        arrayOfc[7] = h;
        arrayOfc[8] = i;
        arrayOfc[9] = j;
        arrayOfc[10] = k;
        arrayOfc[11] = l;
        arrayOfc[12] = m;
        arrayOfc[13] = n;
        arrayOfc[14] = o;
        arrayOfc[15] = p;
        arrayOfc[16] = q;
        arrayOfc[17] = r;
        O = arrayOfc;
      }

      private c(int paramInt1, int paramInt2)
      {
        this.M = paramInt1;
        this.N = paramInt2;
      }

      public static c a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 1:
          return a;
        case 2:
          return b;
        case 3:
          return c;
        case 4:
          return d;
        case 5:
          return e;
        case 6:
          return f;
        case 7:
          return g;
        case 8:
          return h;
        case 9:
          return i;
        case 10:
          return j;
        case 11:
          return k;
        case 12:
          return l;
        case 13:
          return m;
        case 14:
          return n;
        case 15:
          return o;
        case 16:
          return p;
        case 17:
          return q;
        case 18:
        }
        return r;
      }

      public static c a(k.e parame)
      {
        if (parame.g() != e())
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        return L[parame.b()];
      }

      public static r.b<c> b()
      {
        return K;
      }

      public static final k.d e()
      {
        return (k.d)j.k.k().k().get(0);
      }

      public final int a()
      {
        return this.N;
      }

      public final k.e c()
      {
        return (k.e)e().h().get(this.M);
      }

      public final k.d d()
      {
        return e();
      }
    }
  }

  public static abstract interface l extends A
  {
    public abstract String A();

    public abstract g B();

    public abstract boolean C();

    public abstract String D();

    public abstract g E();

    public abstract boolean F();

    public abstract j.m G();

    public abstract j.n H();

    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract boolean q();

    public abstract int r();

    public abstract boolean s();

    public abstract j.k.b t();

    public abstract boolean u();

    public abstract j.k.c v();

    public abstract boolean w();

    public abstract String x();

    public abstract g y();

    public abstract boolean z();
  }

  public static final class m extends p.d<m>
    implements j.n
  {
    public static B<m> a = new c()
    {
      public j.m c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.m(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 5;
    public static final int e = 3;
    public static final int f = 9;
    public static final int g = 10;
    public static final int h = 999;
    private static final m i = new m(true);
    private static final long v;
    private final P j;
    private int k;
    private b l;
    private boolean n;
    private boolean o;
    private boolean p;
    private Object q;
    private boolean r;
    private List<j.G> s;
    private byte t = -1;
    private int u = -1;

    static
    {
      i.G();
    }

    // ERROR //
    private m(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 70	com/umeng/message/proguard/p$d:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 72	com/umeng/message/proguard/j$m:t	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 74	com/umeng/message/proguard/j$m:u	I
      //   16: aload_0
      //   17: invokespecial 64	com/umeng/message/proguard/j$m:G	()V
      //   20: invokestatic 79	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +378 -> 407
      //   32: aload_1
      //   33: invokevirtual 84	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+76->116, 0:+402->442, 8:+94->134, 16:+210->250, 24:+231->271, 40:+253->293, 74:+274->314, 80:+296->336, 7994:+318->358
      //   117: aload_1
      //   118: aload 4
      //   120: aload_2
      //   121: iload 9
      //   123: invokevirtual 87	com/umeng/message/proguard/j$m:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   126: ifne -98 -> 28
      //   129: iconst_1
      //   130: istore_3
      //   131: goto -103 -> 28
      //   134: aload_1
      //   135: invokevirtual 89	com/umeng/message/proguard/h:n	()I
      //   138: istore 11
      //   140: iload 11
      //   142: invokestatic 94	com/umeng/message/proguard/j$m$b:a	(I)Lcom/umeng/message/proguard/j$m$b;
      //   145: astore 12
      //   147: aload 12
      //   149: ifnonnull +63 -> 212
      //   152: aload 4
      //   154: iconst_1
      //   155: iload 11
      //   157: invokevirtual 99	com/umeng/message/proguard/P$a:a	(II)Lcom/umeng/message/proguard/P$a;
      //   160: pop
      //   161: goto -133 -> 28
      //   164: astore 8
      //   166: aload 8
      //   168: aload_0
      //   169: invokevirtual 102	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   172: athrow
      //   173: astore 7
      //   175: iload 5
      //   177: bipush 64
      //   179: iand
      //   180: bipush 64
      //   182: if_icmpne +14 -> 196
      //   185: aload_0
      //   186: aload_0
      //   187: getfield 104	com/umeng/message/proguard/j$m:s	Ljava/util/List;
      //   190: invokestatic 110	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   193: putfield 104	com/umeng/message/proguard/j$m:s	Ljava/util/List;
      //   196: aload_0
      //   197: aload 4
      //   199: invokevirtual 113	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   202: putfield 115	com/umeng/message/proguard/j$m:j	Lcom/umeng/message/proguard/P;
      //   205: aload_0
      //   206: invokevirtual 118	com/umeng/message/proguard/j$m:ad	()V
      //   209: aload 7
      //   211: athrow
      //   212: aload_0
      //   213: iconst_1
      //   214: aload_0
      //   215: getfield 120	com/umeng/message/proguard/j$m:k	I
      //   218: ior
      //   219: putfield 120	com/umeng/message/proguard/j$m:k	I
      //   222: aload_0
      //   223: aload 12
      //   225: putfield 122	com/umeng/message/proguard/j$m:l	Lcom/umeng/message/proguard/j$m$b;
      //   228: goto -200 -> 28
      //   231: astore 6
      //   233: new 67	com/umeng/message/proguard/s
      //   236: dup
      //   237: aload 6
      //   239: invokevirtual 126	java/io/IOException:getMessage	()Ljava/lang/String;
      //   242: invokespecial 129	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   245: aload_0
      //   246: invokevirtual 102	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   249: athrow
      //   250: aload_0
      //   251: iconst_2
      //   252: aload_0
      //   253: getfield 120	com/umeng/message/proguard/j$m:k	I
      //   256: ior
      //   257: putfield 120	com/umeng/message/proguard/j$m:k	I
      //   260: aload_0
      //   261: aload_1
      //   262: invokevirtual 132	com/umeng/message/proguard/h:j	()Z
      //   265: putfield 134	com/umeng/message/proguard/j$m:n	Z
      //   268: goto -240 -> 28
      //   271: aload_0
      //   272: bipush 8
      //   274: aload_0
      //   275: getfield 120	com/umeng/message/proguard/j$m:k	I
      //   278: ior
      //   279: putfield 120	com/umeng/message/proguard/j$m:k	I
      //   282: aload_0
      //   283: aload_1
      //   284: invokevirtual 132	com/umeng/message/proguard/h:j	()Z
      //   287: putfield 136	com/umeng/message/proguard/j$m:p	Z
      //   290: goto -262 -> 28
      //   293: aload_0
      //   294: iconst_4
      //   295: aload_0
      //   296: getfield 120	com/umeng/message/proguard/j$m:k	I
      //   299: ior
      //   300: putfield 120	com/umeng/message/proguard/j$m:k	I
      //   303: aload_0
      //   304: aload_1
      //   305: invokevirtual 132	com/umeng/message/proguard/h:j	()Z
      //   308: putfield 138	com/umeng/message/proguard/j$m:o	Z
      //   311: goto -283 -> 28
      //   314: aload_0
      //   315: bipush 16
      //   317: aload_0
      //   318: getfield 120	com/umeng/message/proguard/j$m:k	I
      //   321: ior
      //   322: putfield 120	com/umeng/message/proguard/j$m:k	I
      //   325: aload_0
      //   326: aload_1
      //   327: invokevirtual 141	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   330: putfield 143	com/umeng/message/proguard/j$m:q	Ljava/lang/Object;
      //   333: goto -305 -> 28
      //   336: aload_0
      //   337: bipush 32
      //   339: aload_0
      //   340: getfield 120	com/umeng/message/proguard/j$m:k	I
      //   343: ior
      //   344: putfield 120	com/umeng/message/proguard/j$m:k	I
      //   347: aload_0
      //   348: aload_1
      //   349: invokevirtual 132	com/umeng/message/proguard/h:j	()Z
      //   352: putfield 145	com/umeng/message/proguard/j$m:r	Z
      //   355: goto -327 -> 28
      //   358: iload 5
      //   360: bipush 64
      //   362: iand
      //   363: bipush 64
      //   365: if_icmpeq +21 -> 386
      //   368: aload_0
      //   369: new 147	java/util/ArrayList
      //   372: dup
      //   373: invokespecial 148	java/util/ArrayList:<init>	()V
      //   376: putfield 104	com/umeng/message/proguard/j$m:s	Ljava/util/List;
      //   379: iload 5
      //   381: bipush 64
      //   383: ior
      //   384: istore 5
      //   386: aload_0
      //   387: getfield 104	com/umeng/message/proguard/j$m:s	Ljava/util/List;
      //   390: aload_1
      //   391: getstatic 151	com/umeng/message/proguard/j$G:a	Lcom/umeng/message/proguard/B;
      //   394: aload_2
      //   395: invokevirtual 154	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   398: invokeinterface 160 2 0
      //   403: pop
      //   404: goto -376 -> 28
      //   407: iload 5
      //   409: bipush 64
      //   411: iand
      //   412: bipush 64
      //   414: if_icmpne +14 -> 428
      //   417: aload_0
      //   418: aload_0
      //   419: getfield 104	com/umeng/message/proguard/j$m:s	Ljava/util/List;
      //   422: invokestatic 110	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   425: putfield 104	com/umeng/message/proguard/j$m:s	Ljava/util/List;
      //   428: aload_0
      //   429: aload 4
      //   431: invokevirtual 113	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   434: putfield 115	com/umeng/message/proguard/j$m:j	Lcom/umeng/message/proguard/P;
      //   437: aload_0
      //   438: invokevirtual 118	com/umeng/message/proguard/j$m:ad	()V
      //   441: return
      //   442: iconst_1
      //   443: istore_3
      //   444: goto -416 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	164	com/umeng/message/proguard/s
      //   116	129	164	com/umeng/message/proguard/s
      //   134	147	164	com/umeng/message/proguard/s
      //   152	161	164	com/umeng/message/proguard/s
      //   212	228	164	com/umeng/message/proguard/s
      //   250	268	164	com/umeng/message/proguard/s
      //   271	290	164	com/umeng/message/proguard/s
      //   293	311	164	com/umeng/message/proguard/s
      //   314	333	164	com/umeng/message/proguard/s
      //   336	355	164	com/umeng/message/proguard/s
      //   368	379	164	com/umeng/message/proguard/s
      //   386	404	164	com/umeng/message/proguard/s
      //   32	38	173	finally
      //   116	129	173	finally
      //   134	147	173	finally
      //   152	161	173	finally
      //   166	173	173	finally
      //   212	228	173	finally
      //   233	250	173	finally
      //   250	268	173	finally
      //   271	290	173	finally
      //   293	311	173	finally
      //   314	333	173	finally
      //   336	355	173	finally
      //   368	379	173	finally
      //   386	404	173	finally
      //   32	38	231	java/io/IOException
      //   116	129	231	java/io/IOException
      //   134	147	231	java/io/IOException
      //   152	161	231	java/io/IOException
      //   212	228	231	java/io/IOException
      //   250	268	231	java/io/IOException
      //   271	290	231	java/io/IOException
      //   293	311	231	java/io/IOException
      //   314	333	231	java/io/IOException
      //   336	355	231	java/io/IOException
      //   368	379	231	java/io/IOException
      //   386	404	231	java/io/IOException
    }

    private m(p.c<m, ?> paramc)
    {
      super();
      this.j = paramc.b_();
    }

    private m(boolean paramBoolean)
    {
      this.j = P.c();
    }

    public static a D()
    {
      return a.T();
    }

    private void G()
    {
      this.l = b.a;
      this.n = false;
      this.o = false;
      this.p = false;
      this.q = "";
      this.r = false;
      this.s = Collections.emptyList();
    }

    public static a a(m paramm)
    {
      return D().a(paramm);
    }

    public static m a(g paramg)
      throws s
    {
      return (m)a.d(paramg);
    }

    public static m a(g paramg, n paramn)
      throws s
    {
      return (m)a.d(paramg, paramn);
    }

    public static m a(h paramh)
      throws IOException
    {
      return (m)a.d(paramh);
    }

    public static m a(h paramh, n paramn)
      throws IOException
    {
      return (m)a.b(paramh, paramn);
    }

    public static m a(InputStream paramInputStream)
      throws IOException
    {
      return (m)a.h(paramInputStream);
    }

    public static m a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (m)a.h(paramInputStream, paramn);
    }

    public static m a(byte[] paramArrayOfByte)
      throws s
    {
      return (m)a.d(paramArrayOfByte);
    }

    public static m a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (m)a.d(paramArrayOfByte, paramn);
    }

    public static m b(InputStream paramInputStream)
      throws IOException
    {
      return (m)a.f(paramInputStream);
    }

    public static m b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (m)a.f(paramInputStream, paramn);
    }

    public static m h()
    {
      return i;
    }

    public static final k.a k()
    {
      return j.x();
    }

    public int C()
    {
      return this.s.size();
    }

    public a E()
    {
      return D();
    }

    public a F()
    {
      return a(this);
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public j.G a(int paramInt)
    {
      return (j.G)this.s.get(paramInt);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      p.d.a locala = X();
      if ((0x1 & this.k) == 1)
        parami.d(1, this.l.a());
      if ((0x2 & this.k) == 2)
        parami.a(2, this.n);
      if ((0x8 & this.k) == 8)
        parami.a(3, this.p);
      if ((0x4 & this.k) == 4)
        parami.a(5, this.o);
      if ((0x10 & this.k) == 16)
        parami.a(9, x());
      if ((0x20 & this.k) == 32)
        parami.a(10, this.r);
      for (int m = 0; m < this.s.size(); m++)
        parami.c(999, (y)this.s.get(m));
      locala.a(536870912, parami);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.t;
      if (m != -1)
        return m == 1;
      for (int i1 = 0; i1 < C(); i1++)
        if (!a(i1).a())
        {
          this.t = 0;
          return false;
        }
      if (!W())
      {
        this.t = 0;
        return false;
      }
      this.t = 1;
      return true;
    }

    public j.H b(int paramInt)
    {
      return (j.H)this.s.get(paramInt);
    }

    public final P b_()
    {
      return this.j;
    }

    public int d()
    {
      int m = 0;
      int i1 = this.u;
      if (i1 != -1)
        return i1;
      if ((0x1 & this.k) == 1);
      for (int i2 = 0 + i.j(1, this.l.a()); ; i2 = 0)
      {
        if ((0x2 & this.k) == 2)
          i2 += i.b(2, this.n);
        if ((0x8 & this.k) == 8)
          i2 += i.b(3, this.p);
        if ((0x4 & this.k) == 4)
          i2 += i.b(5, this.o);
        if ((0x10 & this.k) == 16)
          i2 += i.c(9, x());
        if ((0x20 & this.k) == 32)
          i2 += i.b(10, this.r);
        int i5;
        for (int i3 = i2; m < this.s.size(); i3 = i5)
        {
          i5 = i3 + i.g(999, (y)this.s.get(m));
          m++;
        }
        int i4 = i3 + Z() + b_().d();
        this.u = i4;
        return i4;
      }
    }

    public List<j.G> d_()
    {
      return this.s;
    }

    public List<? extends j.H> e_()
    {
      return this.s;
    }

    public m i()
    {
      return i;
    }

    protected p.g l()
    {
      return j.y().a(m.class, a.class);
    }

    public B<m> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.k) == 1;
    }

    public b o()
    {
      return this.l;
    }

    public boolean p()
    {
      return (0x2 & this.k) == 2;
    }

    public boolean q()
    {
      return this.n;
    }

    public boolean r()
    {
      return (0x4 & this.k) == 4;
    }

    public boolean s()
    {
      return this.o;
    }

    public boolean t()
    {
      return (0x8 & this.k) == 8;
    }

    public boolean u()
    {
      return this.p;
    }

    public boolean v()
    {
      return (0x10 & this.k) == 16;
    }

    public String w()
    {
      Object localObject = this.q;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.q = str;
      return str;
    }

    public g x()
    {
      Object localObject = this.q;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.q = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean y()
    {
      return (0x20 & this.k) == 32;
    }

    public boolean z()
    {
      return this.r;
    }

    public static final class a extends p.c<j.m, a>
      implements j.n
    {
      private int a;
      private j.m.b b = j.m.b.a;
      private boolean c;
      private boolean d;
      private boolean e;
      private Object f = "";
      private boolean g;
      private List<j.G> h = Collections.emptyList();
      private D<j.G, j.G.a, j.H> i;

      private a()
      {
        U();
      }

      private a(p.b paramb)
      {
        super();
        U();
      }

      private void U()
      {
        if (p.m)
          X();
      }

      private static a V()
      {
        return new a();
      }

      private void W()
      {
        if ((0x40 & this.a) != 64)
        {
          this.h = new ArrayList(this.h);
          this.a = (0x40 | this.a);
        }
      }

      private D<j.G, j.G.a, j.H> X()
      {
        List localList;
        if (this.i == null)
        {
          localList = this.h;
          if ((0x40 & this.a) != 64)
            break label57;
        }
        label57: for (boolean bool = true; ; bool = false)
        {
          this.i = new D(localList, bool, aE(), aD());
          this.h = null;
          return this.i;
        }
      }

      public static final k.a k()
      {
        return j.x();
      }

      public int C()
      {
        if (this.i == null)
          return this.h.size();
        return this.i.c();
      }

      public a D()
      {
        return V().a(G());
      }

      public j.m E()
      {
        return j.m.h();
      }

      public j.m F()
      {
        j.m localm = G();
        if (!localm.a())
          throw b(localm);
        return localm;
      }

      public j.m G()
      {
        int j = 1;
        j.m localm = new j.m(this, null);
        int k = this.a;
        if ((k & 0x1) == j);
        while (true)
        {
          j.m.a(localm, this.b);
          if ((k & 0x2) == 2)
            j |= 2;
          j.m.a(localm, this.c);
          if ((k & 0x4) == 4)
            j |= 4;
          j.m.b(localm, this.d);
          if ((k & 0x8) == 8)
            j |= 8;
          j.m.c(localm, this.e);
          if ((k & 0x10) == 16)
            j |= 16;
          j.m.a(localm, this.f);
          if ((k & 0x20) == 32)
            j |= 32;
          j.m.d(localm, this.g);
          if (this.i == null)
          {
            if ((0x40 & this.a) == 64)
            {
              this.h = Collections.unmodifiableList(this.h);
              this.a = (0xFFFFFFBF & this.a);
            }
            j.m.a(localm, this.h);
          }
          while (true)
          {
            j.m.a(localm, j);
            aB();
            return localm;
            j.m.a(localm, this.i.f());
          }
          j = 0;
        }
      }

      public a H()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.m.b.a;
        aF();
        return this;
      }

      public a I()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.c = false;
        aF();
        return this;
      }

      public k.a J()
      {
        return j.x();
      }

      public a K()
      {
        this.a = (0xFFFFFFFB & this.a);
        this.d = false;
        aF();
        return this;
      }

      public a L()
      {
        this.a = (0xFFFFFFF7 & this.a);
        this.e = false;
        aF();
        return this;
      }

      public a M()
      {
        this.a = (0xFFFFFFEF & this.a);
        this.f = j.m.h().w();
        aF();
        return this;
      }

      public a N()
      {
        this.a = (0xFFFFFFDF & this.a);
        this.g = false;
        aF();
        return this;
      }

      public a O()
      {
        if (this.i == null)
        {
          this.h = Collections.emptyList();
          this.a = (0xFFFFFFBF & this.a);
          aF();
          return this;
        }
        this.i.e();
        return this;
      }

      public j.G.a P()
      {
        return (j.G.a)X().b(j.G.h());
      }

      public List<j.G.a> S()
      {
        return X().h();
      }

      public j.G a(int paramInt)
      {
        if (this.i == null)
          return (j.G)this.h.get(paramInt);
        return (j.G)this.i.a(paramInt);
      }

      public a a(int paramInt, j.G.a parama)
      {
        if (this.i == null)
        {
          W();
          this.h.set(paramInt, parama.G());
          aF();
          return this;
        }
        this.i.a(paramInt, parama.G());
        return this;
      }

      public a a(int paramInt, j.G paramG)
      {
        if (this.i == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          W();
          this.h.set(paramInt, paramG);
          aF();
          return this;
        }
        this.i.a(paramInt, paramG);
        return this;
      }

      public a a(j.G.a parama)
      {
        if (this.i == null)
        {
          W();
          this.h.add(parama.G());
          aF();
          return this;
        }
        this.i.a(parama.G());
        return this;
      }

      public a a(j.G paramG)
      {
        if (this.i == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          W();
          this.h.add(paramG);
          aF();
          return this;
        }
        this.i.a(paramG);
        return this;
      }

      public a a(j.m.b paramb)
      {
        if (paramb == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramb;
        aF();
        return this;
      }

      public a a(j.m paramm)
      {
        if (paramm == j.m.h())
          return this;
        if (paramm.n())
          a(paramm.o());
        if (paramm.p())
          a(paramm.q());
        if (paramm.r())
          b(paramm.s());
        if (paramm.t())
          c(paramm.u());
        if (paramm.v())
        {
          this.a = (0x10 | this.a);
          this.f = j.m.b(paramm);
          aF();
        }
        if (paramm.y())
          d(paramm.z());
        if (this.i == null)
          if (!j.m.c(paramm).isEmpty())
          {
            if (!this.h.isEmpty())
              break label189;
            this.h = j.m.c(paramm);
            this.a = (0xFFFFFFBF & this.a);
            aF();
          }
        while (true)
        {
          a(paramm);
          d(paramm.b_());
          return this;
          label189: W();
          this.h.addAll(j.m.c(paramm));
          break;
          if (!j.m.c(paramm).isEmpty())
            if (this.i.d())
            {
              this.i.b();
              this.i = null;
              this.h = j.m.c(paramm);
              this.a = (0xFFFFFFBF & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = X();
              this.i = localD;
            }
            else
            {
              this.i.a(j.m.c(paramm));
            }
        }
      }

      public a a(Iterable<? extends j.G> paramIterable)
      {
        if (this.i == null)
        {
          W();
          p.c.a(paramIterable, this.h);
          aF();
          return this;
        }
        this.i.a(paramIterable);
        return this;
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x10 | this.a);
        this.f = paramString;
        aF();
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.a = (0x2 | this.a);
        this.c = paramBoolean;
        aF();
        return this;
      }

      public final boolean a()
      {
        int j = 0;
        if (j < C())
          if (a(j).a());
        while (!af())
        {
          return false;
          j++;
          break;
        }
        return true;
      }

      public j.H b(int paramInt)
      {
        if (this.i == null)
          return (j.H)this.h.get(paramInt);
        return (j.H)this.i.c(paramInt);
      }

      public a b(int paramInt, j.G.a parama)
      {
        if (this.i == null)
        {
          W();
          this.h.add(paramInt, parama.G());
          aF();
          return this;
        }
        this.i.b(paramInt, parama.G());
        return this;
      }

      public a b(int paramInt, j.G paramG)
      {
        if (this.i == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          W();
          this.h.add(paramInt, paramG);
          aF();
          return this;
        }
        this.i.b(paramInt, paramG);
        return this;
      }

      public a b(boolean paramBoolean)
      {
        this.a = (0x4 | this.a);
        this.d = paramBoolean;
        aF();
        return this;
      }

      public a c(int paramInt)
      {
        if (this.i == null)
        {
          W();
          this.h.remove(paramInt);
          aF();
          return this;
        }
        this.i.d(paramInt);
        return this;
      }

      public a c(boolean paramBoolean)
      {
        this.a = (0x8 | this.a);
        this.e = paramBoolean;
        aF();
        return this;
      }

      public j.G.a d(int paramInt)
      {
        return (j.G.a)X().b(paramInt);
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.m))
          return a((j.m)paramx);
        super.a(paramx);
        return this;
      }

      public a d(boolean paramBoolean)
      {
        this.a = (0x20 | this.a);
        this.g = paramBoolean;
        aF();
        return this;
      }

      public List<j.G> d_()
      {
        if (this.i == null)
          return Collections.unmodifiableList(this.h);
        return this.i.g();
      }

      public j.G.a e(int paramInt)
      {
        return (j.G.a)X().c(paramInt, j.G.h());
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x10 | this.a);
        this.f = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.m localm3 = (j.m)j.m.a.d(paramh, paramn);
          if (localm3 != null)
            a(localm3);
          return this;
        }
        catch (s locals)
        {
          j.m localm2 = (j.m)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localm1 = localm2;
          }
          if (localm1 != null)
            a(localm1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.m localm1 = null;
        }
      }

      public List<? extends j.H> e_()
      {
        if (this.i != null)
          return this.i.i();
        return Collections.unmodifiableList(this.h);
      }

      protected p.g l()
      {
        return j.y().a(j.m.class, a.class);
      }

      public a m()
      {
        super.B();
        this.b = j.m.b.a;
        this.a = (0xFFFFFFFE & this.a);
        this.c = false;
        this.a = (0xFFFFFFFD & this.a);
        this.d = false;
        this.a = (0xFFFFFFFB & this.a);
        this.e = false;
        this.a = (0xFFFFFFF7 & this.a);
        this.f = "";
        this.a = (0xFFFFFFEF & this.a);
        this.g = false;
        this.a = (0xFFFFFFDF & this.a);
        if (this.i == null)
        {
          this.h = Collections.emptyList();
          this.a = (0xFFFFFFBF & this.a);
          return this;
        }
        this.i.e();
        return this;
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public j.m.b o()
      {
        return this.b;
      }

      public boolean p()
      {
        return (0x2 & this.a) == 2;
      }

      public boolean q()
      {
        return this.c;
      }

      public boolean r()
      {
        return (0x4 & this.a) == 4;
      }

      public boolean s()
      {
        return this.d;
      }

      public boolean t()
      {
        return (0x8 & this.a) == 8;
      }

      public boolean u()
      {
        return this.e;
      }

      public boolean v()
      {
        return (0x10 & this.a) == 16;
      }

      public String w()
      {
        Object localObject = this.f;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.f = str;
          return str;
        }
        return (String)localObject;
      }

      public g x()
      {
        Object localObject = this.f;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.f = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean y()
      {
        return (0x20 & this.a) == 32;
      }

      public boolean z()
      {
        return this.g;
      }
    }

    public static enum b
      implements C
    {
      public static final int d = 0;
      public static final int e = 1;
      public static final int f = 2;
      private static r.b<b> g = new r.b()
      {
        public j.m.b a(int paramAnonymousInt)
        {
          return j.m.b.a(paramAnonymousInt);
        }
      };
      private static final b[] h = values();
      private final int i;
      private final int j;

      static
      {
        b[] arrayOfb = new b[3];
        arrayOfb[0] = a;
        arrayOfb[1] = b;
        arrayOfb[2] = c;
        k = arrayOfb;
      }

      private b(int paramInt1, int paramInt2)
      {
        this.i = paramInt1;
        this.j = paramInt2;
      }

      public static b a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 0:
          return a;
        case 1:
          return b;
        case 2:
        }
        return c;
      }

      public static b a(k.e parame)
      {
        if (parame.g() != e())
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        return h[parame.b()];
      }

      public static r.b<b> b()
      {
        return g;
      }

      public static final k.d e()
      {
        return (k.d)j.m.k().k().get(0);
      }

      public final int a()
      {
        return this.j;
      }

      public final k.e c()
      {
        return (k.e)e().h().get(this.i);
      }

      public final k.d d()
      {
        return e();
      }
    }
  }

  public static abstract interface n extends p.e<j.m>
  {
    public abstract int C();

    public abstract j.G a(int paramInt);

    public abstract j.H b(int paramInt);

    public abstract List<j.G> d_();

    public abstract List<? extends j.H> e_();

    public abstract boolean n();

    public abstract j.m.b o();

    public abstract boolean p();

    public abstract boolean q();

    public abstract boolean r();

    public abstract boolean s();

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v();

    public abstract String w();

    public abstract g x();

    public abstract boolean y();

    public abstract boolean z();
  }

  public static final class o extends p
    implements j.p
  {
    private static final long D = 0L;
    public static B<o> a = new c()
    {
      public j.o c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.o(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 10;
    public static final int f = 11;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 8;
    public static final int l = 9;
    private static final o n = new o(true);
    private j.E A;
    private byte B = -1;
    private int C = -1;
    private final P o;
    private int p;
    private Object q;
    private Object r;
    private v s;
    private List<Integer> t;
    private List<Integer> u;
    private List<j.a> v;
    private List<j.c> w;
    private List<j.A> x;
    private List<j.k> y;
    private j.s z;

    static
    {
      n.ae();
    }

    // ERROR //
    private o(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 87	com/umeng/message/proguard/p:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 89	com/umeng/message/proguard/j$o:B	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 91	com/umeng/message/proguard/j$o:C	I
      //   14: aload_0
      //   15: invokespecial 81	com/umeng/message/proguard/j$o:ae	()V
      //   18: iconst_0
      //   19: istore_3
      //   20: invokestatic 96	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload 5
      //   30: ifne +1168 -> 1198
      //   33: aload_1
      //   34: invokevirtual 101	com/umeng/message/proguard/h:a	()I
      //   37: istore 9
      //   39: iload 9
      //   41: lookupswitch	default:+123->164, 0:+1422->1463, 10:+145->186, 18:+173->214, 26:+201->242, 34:+252->293, 42:+311->352, 50:+370->411, 58:+432->473, 66:+494->535, 74:+572->613, 80:+653->694, 82:+711->752, 88:+982->1023, 90:+1040->1081
      //   165: aload_1
      //   166: aload 4
      //   168: aload_2
      //   169: iload 9
      //   171: invokevirtual 104	com/umeng/message/proguard/j$o:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   174: ifne +1272 -> 1446
      //   177: iconst_1
      //   178: istore 16
      //   180: iload_3
      //   181: istore 15
      //   183: goto +1270 -> 1453
      //   186: aload_0
      //   187: iconst_1
      //   188: aload_0
      //   189: getfield 106	com/umeng/message/proguard/j$o:p	I
      //   192: ior
      //   193: putfield 106	com/umeng/message/proguard/j$o:p	I
      //   196: aload_0
      //   197: aload_1
      //   198: invokevirtual 109	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   201: putfield 111	com/umeng/message/proguard/j$o:q	Ljava/lang/Object;
      //   204: iload 5
      //   206: istore 16
      //   208: iload_3
      //   209: istore 15
      //   211: goto +1242 -> 1453
      //   214: aload_0
      //   215: iconst_2
      //   216: aload_0
      //   217: getfield 106	com/umeng/message/proguard/j$o:p	I
      //   220: ior
      //   221: putfield 106	com/umeng/message/proguard/j$o:p	I
      //   224: aload_0
      //   225: aload_1
      //   226: invokevirtual 109	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   229: putfield 113	com/umeng/message/proguard/j$o:r	Ljava/lang/Object;
      //   232: iload 5
      //   234: istore 16
      //   236: iload_3
      //   237: istore 15
      //   239: goto +1214 -> 1453
      //   242: iload_3
      //   243: iconst_4
      //   244: iand
      //   245: iconst_4
      //   246: if_icmpeq +1194 -> 1440
      //   249: aload_0
      //   250: new 115	com/umeng/message/proguard/u
      //   253: dup
      //   254: invokespecial 116	com/umeng/message/proguard/u:<init>	()V
      //   257: putfield 118	com/umeng/message/proguard/j$o:s	Lcom/umeng/message/proguard/v;
      //   260: iload_3
      //   261: iconst_4
      //   262: ior
      //   263: istore 11
      //   265: aload_0
      //   266: getfield 118	com/umeng/message/proguard/j$o:s	Lcom/umeng/message/proguard/v;
      //   269: aload_1
      //   270: invokevirtual 109	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   273: invokeinterface 123 2 0
      //   278: iload 5
      //   280: istore 38
      //   282: iload 11
      //   284: istore 15
      //   286: iload 38
      //   288: istore 16
      //   290: goto +1163 -> 1453
      //   293: iload_3
      //   294: bipush 32
      //   296: iand
      //   297: bipush 32
      //   299: if_icmpeq +1135 -> 1434
      //   302: aload_0
      //   303: new 125	java/util/ArrayList
      //   306: dup
      //   307: invokespecial 126	java/util/ArrayList:<init>	()V
      //   310: putfield 128	com/umeng/message/proguard/j$o:v	Ljava/util/List;
      //   313: iload_3
      //   314: bipush 32
      //   316: ior
      //   317: istore 11
      //   319: aload_0
      //   320: getfield 128	com/umeng/message/proguard/j$o:v	Ljava/util/List;
      //   323: aload_1
      //   324: getstatic 131	com/umeng/message/proguard/j$a:a	Lcom/umeng/message/proguard/B;
      //   327: aload_2
      //   328: invokevirtual 134	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   331: invokeinterface 140 2 0
      //   336: pop
      //   337: iload 5
      //   339: istore 37
      //   341: iload 11
      //   343: istore 15
      //   345: iload 37
      //   347: istore 16
      //   349: goto +1104 -> 1453
      //   352: iload_3
      //   353: bipush 64
      //   355: iand
      //   356: bipush 64
      //   358: if_icmpeq +1070 -> 1428
      //   361: aload_0
      //   362: new 125	java/util/ArrayList
      //   365: dup
      //   366: invokespecial 126	java/util/ArrayList:<init>	()V
      //   369: putfield 142	com/umeng/message/proguard/j$o:w	Ljava/util/List;
      //   372: iload_3
      //   373: bipush 64
      //   375: ior
      //   376: istore 11
      //   378: aload_0
      //   379: getfield 142	com/umeng/message/proguard/j$o:w	Ljava/util/List;
      //   382: aload_1
      //   383: getstatic 145	com/umeng/message/proguard/j$c:a	Lcom/umeng/message/proguard/B;
      //   386: aload_2
      //   387: invokevirtual 134	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   390: invokeinterface 140 2 0
      //   395: pop
      //   396: iload 5
      //   398: istore 35
      //   400: iload 11
      //   402: istore 15
      //   404: iload 35
      //   406: istore 16
      //   408: goto +1045 -> 1453
      //   411: iload_3
      //   412: sipush 128
      //   415: iand
      //   416: sipush 128
      //   419: if_icmpeq +1003 -> 1422
      //   422: aload_0
      //   423: new 125	java/util/ArrayList
      //   426: dup
      //   427: invokespecial 126	java/util/ArrayList:<init>	()V
      //   430: putfield 147	com/umeng/message/proguard/j$o:x	Ljava/util/List;
      //   433: iload_3
      //   434: sipush 128
      //   437: ior
      //   438: istore 11
      //   440: aload_0
      //   441: getfield 147	com/umeng/message/proguard/j$o:x	Ljava/util/List;
      //   444: aload_1
      //   445: getstatic 150	com/umeng/message/proguard/j$A:a	Lcom/umeng/message/proguard/B;
      //   448: aload_2
      //   449: invokevirtual 134	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   452: invokeinterface 140 2 0
      //   457: pop
      //   458: iload 5
      //   460: istore 33
      //   462: iload 11
      //   464: istore 15
      //   466: iload 33
      //   468: istore 16
      //   470: goto +983 -> 1453
      //   473: iload_3
      //   474: sipush 256
      //   477: iand
      //   478: sipush 256
      //   481: if_icmpeq +935 -> 1416
      //   484: aload_0
      //   485: new 125	java/util/ArrayList
      //   488: dup
      //   489: invokespecial 126	java/util/ArrayList:<init>	()V
      //   492: putfield 152	com/umeng/message/proguard/j$o:y	Ljava/util/List;
      //   495: iload_3
      //   496: sipush 256
      //   499: ior
      //   500: istore 11
      //   502: aload_0
      //   503: getfield 152	com/umeng/message/proguard/j$o:y	Ljava/util/List;
      //   506: aload_1
      //   507: getstatic 155	com/umeng/message/proguard/j$k:a	Lcom/umeng/message/proguard/B;
      //   510: aload_2
      //   511: invokevirtual 134	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   514: invokeinterface 140 2 0
      //   519: pop
      //   520: iload 5
      //   522: istore 31
      //   524: iload 11
      //   526: istore 15
      //   528: iload 31
      //   530: istore 16
      //   532: goto +921 -> 1453
      //   535: iconst_4
      //   536: aload_0
      //   537: getfield 106	com/umeng/message/proguard/j$o:p	I
      //   540: iand
      //   541: iconst_4
      //   542: if_icmpne +868 -> 1410
      //   545: aload_0
      //   546: getfield 157	com/umeng/message/proguard/j$o:z	Lcom/umeng/message/proguard/j$s;
      //   549: invokevirtual 163	com/umeng/message/proguard/j$s:V	()Lcom/umeng/message/proguard/j$s$a;
      //   552: astore 28
      //   554: aload_0
      //   555: aload_1
      //   556: getstatic 164	com/umeng/message/proguard/j$s:a	Lcom/umeng/message/proguard/B;
      //   559: aload_2
      //   560: invokevirtual 134	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   563: checkcast 159	com/umeng/message/proguard/j$s
      //   566: putfield 157	com/umeng/message/proguard/j$o:z	Lcom/umeng/message/proguard/j$s;
      //   569: aload 28
      //   571: ifnull +22 -> 593
      //   574: aload 28
      //   576: aload_0
      //   577: getfield 157	com/umeng/message/proguard/j$o:z	Lcom/umeng/message/proguard/j$s;
      //   580: invokevirtual 169	com/umeng/message/proguard/j$s$a:a	(Lcom/umeng/message/proguard/j$s;)Lcom/umeng/message/proguard/j$s$a;
      //   583: pop
      //   584: aload_0
      //   585: aload 28
      //   587: invokevirtual 173	com/umeng/message/proguard/j$s$a:O	()Lcom/umeng/message/proguard/j$s;
      //   590: putfield 157	com/umeng/message/proguard/j$o:z	Lcom/umeng/message/proguard/j$s;
      //   593: aload_0
      //   594: iconst_4
      //   595: aload_0
      //   596: getfield 106	com/umeng/message/proguard/j$o:p	I
      //   599: ior
      //   600: putfield 106	com/umeng/message/proguard/j$o:p	I
      //   603: iload 5
      //   605: istore 16
      //   607: iload_3
      //   608: istore 15
      //   610: goto +843 -> 1453
      //   613: bipush 8
      //   615: aload_0
      //   616: getfield 106	com/umeng/message/proguard/j$o:p	I
      //   619: iand
      //   620: bipush 8
      //   622: if_icmpne +782 -> 1404
      //   625: aload_0
      //   626: getfield 175	com/umeng/message/proguard/j$o:A	Lcom/umeng/message/proguard/j$E;
      //   629: invokevirtual 180	com/umeng/message/proguard/j$E:s	()Lcom/umeng/message/proguard/j$E$a;
      //   632: astore 26
      //   634: aload_0
      //   635: aload_1
      //   636: getstatic 181	com/umeng/message/proguard/j$E:a	Lcom/umeng/message/proguard/B;
      //   639: aload_2
      //   640: invokevirtual 134	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   643: checkcast 177	com/umeng/message/proguard/j$E
      //   646: putfield 175	com/umeng/message/proguard/j$o:A	Lcom/umeng/message/proguard/j$E;
      //   649: aload 26
      //   651: ifnull +22 -> 673
      //   654: aload 26
      //   656: aload_0
      //   657: getfield 175	com/umeng/message/proguard/j$o:A	Lcom/umeng/message/proguard/j$E;
      //   660: invokevirtual 186	com/umeng/message/proguard/j$E$a:a	(Lcom/umeng/message/proguard/j$E;)Lcom/umeng/message/proguard/j$E$a;
      //   663: pop
      //   664: aload_0
      //   665: aload 26
      //   667: invokevirtual 189	com/umeng/message/proguard/j$E$a:t	()Lcom/umeng/message/proguard/j$E;
      //   670: putfield 175	com/umeng/message/proguard/j$o:A	Lcom/umeng/message/proguard/j$E;
      //   673: aload_0
      //   674: bipush 8
      //   676: aload_0
      //   677: getfield 106	com/umeng/message/proguard/j$o:p	I
      //   680: ior
      //   681: putfield 106	com/umeng/message/proguard/j$o:p	I
      //   684: iload 5
      //   686: istore 16
      //   688: iload_3
      //   689: istore 15
      //   691: goto +762 -> 1453
      //   694: iload_3
      //   695: bipush 8
      //   697: iand
      //   698: bipush 8
      //   700: if_icmpeq +698 -> 1398
      //   703: aload_0
      //   704: new 125	java/util/ArrayList
      //   707: dup
      //   708: invokespecial 126	java/util/ArrayList:<init>	()V
      //   711: putfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   714: iload_3
      //   715: bipush 8
      //   717: ior
      //   718: istore 11
      //   720: aload_0
      //   721: getfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   724: aload_1
      //   725: invokevirtual 193	com/umeng/message/proguard/h:g	()I
      //   728: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   731: invokeinterface 140 2 0
      //   736: pop
      //   737: iload 5
      //   739: istore 25
      //   741: iload 11
      //   743: istore 15
      //   745: iload 25
      //   747: istore 16
      //   749: goto +704 -> 1453
      //   752: aload_1
      //   753: aload_1
      //   754: invokevirtual 201	com/umeng/message/proguard/h:s	()I
      //   757: invokevirtual 204	com/umeng/message/proguard/h:f	(I)I
      //   760: istore 21
      //   762: iload_3
      //   763: bipush 8
      //   765: iand
      //   766: bipush 8
      //   768: if_icmpeq +624 -> 1392
      //   771: aload_1
      //   772: invokevirtual 206	com/umeng/message/proguard/h:x	()I
      //   775: ifle +617 -> 1392
      //   778: aload_0
      //   779: new 125	java/util/ArrayList
      //   782: dup
      //   783: invokespecial 126	java/util/ArrayList:<init>	()V
      //   786: putfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   789: iload_3
      //   790: bipush 8
      //   792: ior
      //   793: istore 11
      //   795: aload_1
      //   796: invokevirtual 206	com/umeng/message/proguard/h:x	()I
      //   799: ifle +203 -> 1002
      //   802: aload_0
      //   803: getfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   806: aload_1
      //   807: invokevirtual 193	com/umeng/message/proguard/h:g	()I
      //   810: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   813: invokeinterface 140 2 0
      //   818: pop
      //   819: goto -24 -> 795
      //   822: astore 17
      //   824: iload 11
      //   826: istore_3
      //   827: aload 17
      //   829: astore 6
      //   831: aload 6
      //   833: aload_0
      //   834: invokevirtual 209	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   837: athrow
      //   838: astore 7
      //   840: iload_3
      //   841: iconst_4
      //   842: iand
      //   843: iconst_4
      //   844: if_icmpne +18 -> 862
      //   847: aload_0
      //   848: new 211	com/umeng/message/proguard/Q
      //   851: dup
      //   852: aload_0
      //   853: getfield 118	com/umeng/message/proguard/j$o:s	Lcom/umeng/message/proguard/v;
      //   856: invokespecial 214	com/umeng/message/proguard/Q:<init>	(Lcom/umeng/message/proguard/v;)V
      //   859: putfield 118	com/umeng/message/proguard/j$o:s	Lcom/umeng/message/proguard/v;
      //   862: iload_3
      //   863: bipush 32
      //   865: iand
      //   866: bipush 32
      //   868: if_icmpne +14 -> 882
      //   871: aload_0
      //   872: aload_0
      //   873: getfield 128	com/umeng/message/proguard/j$o:v	Ljava/util/List;
      //   876: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   879: putfield 128	com/umeng/message/proguard/j$o:v	Ljava/util/List;
      //   882: iload_3
      //   883: bipush 64
      //   885: iand
      //   886: bipush 64
      //   888: if_icmpne +14 -> 902
      //   891: aload_0
      //   892: aload_0
      //   893: getfield 142	com/umeng/message/proguard/j$o:w	Ljava/util/List;
      //   896: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   899: putfield 142	com/umeng/message/proguard/j$o:w	Ljava/util/List;
      //   902: iload_3
      //   903: sipush 128
      //   906: iand
      //   907: sipush 128
      //   910: if_icmpne +14 -> 924
      //   913: aload_0
      //   914: aload_0
      //   915: getfield 147	com/umeng/message/proguard/j$o:x	Ljava/util/List;
      //   918: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   921: putfield 147	com/umeng/message/proguard/j$o:x	Ljava/util/List;
      //   924: iload_3
      //   925: sipush 256
      //   928: iand
      //   929: sipush 256
      //   932: if_icmpne +14 -> 946
      //   935: aload_0
      //   936: aload_0
      //   937: getfield 152	com/umeng/message/proguard/j$o:y	Ljava/util/List;
      //   940: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   943: putfield 152	com/umeng/message/proguard/j$o:y	Ljava/util/List;
      //   946: iload_3
      //   947: bipush 8
      //   949: iand
      //   950: bipush 8
      //   952: if_icmpne +14 -> 966
      //   955: aload_0
      //   956: aload_0
      //   957: getfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   960: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   963: putfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   966: iload_3
      //   967: bipush 16
      //   969: iand
      //   970: bipush 16
      //   972: if_icmpne +14 -> 986
      //   975: aload_0
      //   976: aload_0
      //   977: getfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   980: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   983: putfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   986: aload_0
      //   987: aload 4
      //   989: invokevirtual 227	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   992: putfield 229	com/umeng/message/proguard/j$o:o	Lcom/umeng/message/proguard/P;
      //   995: aload_0
      //   996: invokevirtual 232	com/umeng/message/proguard/j$o:ad	()V
      //   999: aload 7
      //   1001: athrow
      //   1002: aload_1
      //   1003: iload 21
      //   1005: invokevirtual 235	com/umeng/message/proguard/h:g	(I)V
      //   1008: iload 5
      //   1010: istore 22
      //   1012: iload 11
      //   1014: istore 15
      //   1016: iload 22
      //   1018: istore 16
      //   1020: goto +433 -> 1453
      //   1023: iload_3
      //   1024: bipush 16
      //   1026: iand
      //   1027: bipush 16
      //   1029: if_icmpeq +357 -> 1386
      //   1032: aload_0
      //   1033: new 125	java/util/ArrayList
      //   1036: dup
      //   1037: invokespecial 126	java/util/ArrayList:<init>	()V
      //   1040: putfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   1043: iload_3
      //   1044: bipush 16
      //   1046: ior
      //   1047: istore 11
      //   1049: aload_0
      //   1050: getfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   1053: aload_1
      //   1054: invokevirtual 193	com/umeng/message/proguard/h:g	()I
      //   1057: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1060: invokeinterface 140 2 0
      //   1065: pop
      //   1066: iload 5
      //   1068: istore 20
      //   1070: iload 11
      //   1072: istore 15
      //   1074: iload 20
      //   1076: istore 16
      //   1078: goto +375 -> 1453
      //   1081: aload_1
      //   1082: aload_1
      //   1083: invokevirtual 201	com/umeng/message/proguard/h:s	()I
      //   1086: invokevirtual 204	com/umeng/message/proguard/h:f	(I)I
      //   1089: istore 10
      //   1091: iload_3
      //   1092: bipush 16
      //   1094: iand
      //   1095: bipush 16
      //   1097: if_icmpeq +283 -> 1380
      //   1100: aload_1
      //   1101: invokevirtual 206	com/umeng/message/proguard/h:x	()I
      //   1104: ifle +276 -> 1380
      //   1107: aload_0
      //   1108: new 125	java/util/ArrayList
      //   1111: dup
      //   1112: invokespecial 126	java/util/ArrayList:<init>	()V
      //   1115: putfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   1118: iload_3
      //   1119: bipush 16
      //   1121: ior
      //   1122: istore 11
      //   1124: aload_1
      //   1125: invokevirtual 206	com/umeng/message/proguard/h:x	()I
      //   1128: ifle +49 -> 1177
      //   1131: aload_0
      //   1132: getfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   1135: aload_1
      //   1136: invokevirtual 193	com/umeng/message/proguard/h:g	()I
      //   1139: invokestatic 199	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   1142: invokeinterface 140 2 0
      //   1147: pop
      //   1148: goto -24 -> 1124
      //   1151: astore 13
      //   1153: iload 11
      //   1155: istore_3
      //   1156: aload 13
      //   1158: astore 8
      //   1160: new 84	com/umeng/message/proguard/s
      //   1163: dup
      //   1164: aload 8
      //   1166: invokevirtual 239	java/io/IOException:getMessage	()Ljava/lang/String;
      //   1169: invokespecial 242	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   1172: aload_0
      //   1173: invokevirtual 209	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   1176: athrow
      //   1177: aload_1
      //   1178: iload 10
      //   1180: invokevirtual 235	com/umeng/message/proguard/h:g	(I)V
      //   1183: iload 5
      //   1185: istore 14
      //   1187: iload 11
      //   1189: istore 15
      //   1191: iload 14
      //   1193: istore 16
      //   1195: goto +258 -> 1453
      //   1198: iload_3
      //   1199: iconst_4
      //   1200: iand
      //   1201: iconst_4
      //   1202: if_icmpne +18 -> 1220
      //   1205: aload_0
      //   1206: new 211	com/umeng/message/proguard/Q
      //   1209: dup
      //   1210: aload_0
      //   1211: getfield 118	com/umeng/message/proguard/j$o:s	Lcom/umeng/message/proguard/v;
      //   1214: invokespecial 214	com/umeng/message/proguard/Q:<init>	(Lcom/umeng/message/proguard/v;)V
      //   1217: putfield 118	com/umeng/message/proguard/j$o:s	Lcom/umeng/message/proguard/v;
      //   1220: iload_3
      //   1221: bipush 32
      //   1223: iand
      //   1224: bipush 32
      //   1226: if_icmpne +14 -> 1240
      //   1229: aload_0
      //   1230: aload_0
      //   1231: getfield 128	com/umeng/message/proguard/j$o:v	Ljava/util/List;
      //   1234: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1237: putfield 128	com/umeng/message/proguard/j$o:v	Ljava/util/List;
      //   1240: iload_3
      //   1241: bipush 64
      //   1243: iand
      //   1244: bipush 64
      //   1246: if_icmpne +14 -> 1260
      //   1249: aload_0
      //   1250: aload_0
      //   1251: getfield 142	com/umeng/message/proguard/j$o:w	Ljava/util/List;
      //   1254: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1257: putfield 142	com/umeng/message/proguard/j$o:w	Ljava/util/List;
      //   1260: iload_3
      //   1261: sipush 128
      //   1264: iand
      //   1265: sipush 128
      //   1268: if_icmpne +14 -> 1282
      //   1271: aload_0
      //   1272: aload_0
      //   1273: getfield 147	com/umeng/message/proguard/j$o:x	Ljava/util/List;
      //   1276: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1279: putfield 147	com/umeng/message/proguard/j$o:x	Ljava/util/List;
      //   1282: iload_3
      //   1283: sipush 256
      //   1286: iand
      //   1287: sipush 256
      //   1290: if_icmpne +14 -> 1304
      //   1293: aload_0
      //   1294: aload_0
      //   1295: getfield 152	com/umeng/message/proguard/j$o:y	Ljava/util/List;
      //   1298: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1301: putfield 152	com/umeng/message/proguard/j$o:y	Ljava/util/List;
      //   1304: iload_3
      //   1305: bipush 8
      //   1307: iand
      //   1308: bipush 8
      //   1310: if_icmpne +14 -> 1324
      //   1313: aload_0
      //   1314: aload_0
      //   1315: getfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   1318: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1321: putfield 191	com/umeng/message/proguard/j$o:t	Ljava/util/List;
      //   1324: iload_3
      //   1325: bipush 16
      //   1327: iand
      //   1328: bipush 16
      //   1330: if_icmpne +14 -> 1344
      //   1333: aload_0
      //   1334: aload_0
      //   1335: getfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   1338: invokestatic 220	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   1341: putfield 222	com/umeng/message/proguard/j$o:u	Ljava/util/List;
      //   1344: aload_0
      //   1345: aload 4
      //   1347: invokevirtual 227	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   1350: putfield 229	com/umeng/message/proguard/j$o:o	Lcom/umeng/message/proguard/P;
      //   1353: aload_0
      //   1354: invokevirtual 232	com/umeng/message/proguard/j$o:ad	()V
      //   1357: return
      //   1358: astore 12
      //   1360: iload 11
      //   1362: istore_3
      //   1363: aload 12
      //   1365: astore 7
      //   1367: goto -527 -> 840
      //   1370: astore 8
      //   1372: goto -212 -> 1160
      //   1375: astore 6
      //   1377: goto -546 -> 831
      //   1380: iload_3
      //   1381: istore 11
      //   1383: goto -259 -> 1124
      //   1386: iload_3
      //   1387: istore 11
      //   1389: goto -340 -> 1049
      //   1392: iload_3
      //   1393: istore 11
      //   1395: goto -600 -> 795
      //   1398: iload_3
      //   1399: istore 11
      //   1401: goto -681 -> 720
      //   1404: aconst_null
      //   1405: astore 26
      //   1407: goto -773 -> 634
      //   1410: aconst_null
      //   1411: astore 28
      //   1413: goto -859 -> 554
      //   1416: iload_3
      //   1417: istore 11
      //   1419: goto -917 -> 502
      //   1422: iload_3
      //   1423: istore 11
      //   1425: goto -985 -> 440
      //   1428: iload_3
      //   1429: istore 11
      //   1431: goto -1053 -> 378
      //   1434: iload_3
      //   1435: istore 11
      //   1437: goto -1118 -> 319
      //   1440: iload_3
      //   1441: istore 11
      //   1443: goto -1178 -> 265
      //   1446: iload 5
      //   1448: istore 16
      //   1450: iload_3
      //   1451: istore 15
      //   1453: iload 15
      //   1455: istore_3
      //   1456: iload 16
      //   1458: istore 5
      //   1460: goto -1432 -> 28
      //   1463: iconst_1
      //   1464: istore 16
      //   1466: iload_3
      //   1467: istore 15
      //   1469: goto -16 -> 1453
      //
      // Exception table:
      //   from	to	target	type
      //   265	278	822	com/umeng/message/proguard/s
      //   319	337	822	com/umeng/message/proguard/s
      //   378	396	822	com/umeng/message/proguard/s
      //   440	458	822	com/umeng/message/proguard/s
      //   502	520	822	com/umeng/message/proguard/s
      //   720	737	822	com/umeng/message/proguard/s
      //   795	819	822	com/umeng/message/proguard/s
      //   1002	1008	822	com/umeng/message/proguard/s
      //   1049	1066	822	com/umeng/message/proguard/s
      //   1124	1148	822	com/umeng/message/proguard/s
      //   1177	1183	822	com/umeng/message/proguard/s
      //   33	39	838	finally
      //   164	177	838	finally
      //   186	204	838	finally
      //   214	232	838	finally
      //   249	260	838	finally
      //   302	313	838	finally
      //   361	372	838	finally
      //   422	433	838	finally
      //   484	495	838	finally
      //   535	554	838	finally
      //   554	569	838	finally
      //   574	593	838	finally
      //   593	603	838	finally
      //   613	634	838	finally
      //   634	649	838	finally
      //   654	673	838	finally
      //   673	684	838	finally
      //   703	714	838	finally
      //   752	762	838	finally
      //   771	789	838	finally
      //   831	838	838	finally
      //   1032	1043	838	finally
      //   1081	1091	838	finally
      //   1100	1118	838	finally
      //   1160	1177	838	finally
      //   265	278	1151	java/io/IOException
      //   319	337	1151	java/io/IOException
      //   378	396	1151	java/io/IOException
      //   440	458	1151	java/io/IOException
      //   502	520	1151	java/io/IOException
      //   720	737	1151	java/io/IOException
      //   795	819	1151	java/io/IOException
      //   1002	1008	1151	java/io/IOException
      //   1049	1066	1151	java/io/IOException
      //   1124	1148	1151	java/io/IOException
      //   1177	1183	1151	java/io/IOException
      //   265	278	1358	finally
      //   319	337	1358	finally
      //   378	396	1358	finally
      //   440	458	1358	finally
      //   502	520	1358	finally
      //   720	737	1358	finally
      //   795	819	1358	finally
      //   1002	1008	1358	finally
      //   1049	1066	1358	finally
      //   1124	1148	1358	finally
      //   1177	1183	1358	finally
      //   33	39	1370	java/io/IOException
      //   164	177	1370	java/io/IOException
      //   186	204	1370	java/io/IOException
      //   214	232	1370	java/io/IOException
      //   249	260	1370	java/io/IOException
      //   302	313	1370	java/io/IOException
      //   361	372	1370	java/io/IOException
      //   422	433	1370	java/io/IOException
      //   484	495	1370	java/io/IOException
      //   535	554	1370	java/io/IOException
      //   554	569	1370	java/io/IOException
      //   574	593	1370	java/io/IOException
      //   593	603	1370	java/io/IOException
      //   613	634	1370	java/io/IOException
      //   634	649	1370	java/io/IOException
      //   654	673	1370	java/io/IOException
      //   673	684	1370	java/io/IOException
      //   703	714	1370	java/io/IOException
      //   752	762	1370	java/io/IOException
      //   771	789	1370	java/io/IOException
      //   1032	1043	1370	java/io/IOException
      //   1081	1091	1370	java/io/IOException
      //   1100	1118	1370	java/io/IOException
      //   33	39	1375	com/umeng/message/proguard/s
      //   164	177	1375	com/umeng/message/proguard/s
      //   186	204	1375	com/umeng/message/proguard/s
      //   214	232	1375	com/umeng/message/proguard/s
      //   249	260	1375	com/umeng/message/proguard/s
      //   302	313	1375	com/umeng/message/proguard/s
      //   361	372	1375	com/umeng/message/proguard/s
      //   422	433	1375	com/umeng/message/proguard/s
      //   484	495	1375	com/umeng/message/proguard/s
      //   535	554	1375	com/umeng/message/proguard/s
      //   554	569	1375	com/umeng/message/proguard/s
      //   574	593	1375	com/umeng/message/proguard/s
      //   593	603	1375	com/umeng/message/proguard/s
      //   613	634	1375	com/umeng/message/proguard/s
      //   634	649	1375	com/umeng/message/proguard/s
      //   654	673	1375	com/umeng/message/proguard/s
      //   673	684	1375	com/umeng/message/proguard/s
      //   703	714	1375	com/umeng/message/proguard/s
      //   752	762	1375	com/umeng/message/proguard/s
      //   771	789	1375	com/umeng/message/proguard/s
      //   1032	1043	1375	com/umeng/message/proguard/s
      //   1081	1091	1375	com/umeng/message/proguard/s
      //   1100	1118	1375	com/umeng/message/proguard/s
    }

    private o(p.a<?> parama)
    {
      super();
      this.o = parama.b_();
    }

    private o(boolean paramBoolean)
    {
      this.o = P.c();
    }

    public static a Z()
    {
      return a.az();
    }

    public static a a(o paramo)
    {
      return Z().a(paramo);
    }

    public static o a(g paramg)
      throws s
    {
      return (o)a.d(paramg);
    }

    public static o a(g paramg, n paramn)
      throws s
    {
      return (o)a.d(paramg, paramn);
    }

    public static o a(h paramh)
      throws IOException
    {
      return (o)a.d(paramh);
    }

    public static o a(h paramh, n paramn)
      throws IOException
    {
      return (o)a.b(paramh, paramn);
    }

    public static o a(InputStream paramInputStream)
      throws IOException
    {
      return (o)a.h(paramInputStream);
    }

    public static o a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (o)a.h(paramInputStream, paramn);
    }

    public static o a(byte[] paramArrayOfByte)
      throws s
    {
      return (o)a.d(paramArrayOfByte);
    }

    public static o a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (o)a.d(paramArrayOfByte, paramn);
    }

    private void ae()
    {
      this.q = "";
      this.r = "";
      this.s = u.a;
      this.t = Collections.emptyList();
      this.u = Collections.emptyList();
      this.v = Collections.emptyList();
      this.w = Collections.emptyList();
      this.x = Collections.emptyList();
      this.y = Collections.emptyList();
      this.z = j.s.h();
      this.A = j.E.h();
    }

    public static o b(InputStream paramInputStream)
      throws IOException
    {
      return (o)a.f(paramInputStream);
    }

    public static o b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (o)a.f(paramInputStream, paramn);
    }

    public static o h()
    {
      return n;
    }

    public static final k.a k()
    {
      return j.d();
    }

    public List<? extends j.b> A()
    {
      return this.v;
    }

    public int B()
    {
      return this.v.size();
    }

    public List<j.c> C()
    {
      return this.w;
    }

    public List<? extends j.d> D()
    {
      return this.w;
    }

    public int E()
    {
      return this.w.size();
    }

    public List<j.A> F()
    {
      return this.x;
    }

    public List<? extends j.B> G()
    {
      return this.x;
    }

    public int H()
    {
      return this.x.size();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public List<j.k> K()
    {
      return this.y;
    }

    public List<? extends j.l> L()
    {
      return this.y;
    }

    public int S()
    {
      return this.y.size();
    }

    public boolean T()
    {
      return (0x4 & this.p) == 4;
    }

    public j.s U()
    {
      return this.z;
    }

    public j.t V()
    {
      return this.z;
    }

    public boolean W()
    {
      return (0x8 & this.p) == 8;
    }

    public j.E X()
    {
      return this.A;
    }

    public j.F Y()
    {
      return this.A;
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public String a(int paramInt)
    {
      return (String)this.s.get(paramInt);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      if ((0x1 & this.p) == 1)
        parami.a(1, p());
      if ((0x2 & this.p) == 2)
        parami.a(2, s());
      for (int m = 0; m < this.s.size(); m++)
        parami.a(3, this.s.c(m));
      for (int i1 = 0; i1 < this.v.size(); i1++)
        parami.c(4, (y)this.v.get(i1));
      for (int i2 = 0; i2 < this.w.size(); i2++)
        parami.c(5, (y)this.w.get(i2));
      for (int i3 = 0; i3 < this.x.size(); i3++)
        parami.c(6, (y)this.x.get(i3));
      for (int i4 = 0; i4 < this.y.size(); i4++)
        parami.c(7, (y)this.y.get(i4));
      if ((0x4 & this.p) == 4)
        parami.c(8, this.z);
      if ((0x8 & this.p) == 8)
        parami.c(9, this.A);
      int i7;
      for (int i5 = 0; ; i5++)
      {
        int i6 = this.t.size();
        i7 = 0;
        if (i5 >= i6)
          break;
        parami.a(10, ((Integer)this.t.get(i5)).intValue());
      }
      while (i7 < this.u.size())
      {
        parami.a(11, ((Integer)this.u.get(i7)).intValue());
        i7++;
      }
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = 1;
      int i1 = this.B;
      if (i1 != -1)
      {
        if (i1 == m);
        while (true)
        {
          return m;
          m = 0;
        }
      }
      for (int i2 = 0; i2 < B(); i2++)
        if (!e(i2).a())
        {
          this.B = 0;
          return false;
        }
      for (int i3 = 0; i3 < E(); i3++)
        if (!g(i3).a())
        {
          this.B = 0;
          return false;
        }
      for (int i4 = 0; i4 < H(); i4++)
        if (!i(i4).a())
        {
          this.B = 0;
          return false;
        }
      for (int i5 = 0; i5 < S(); i5++)
        if (!k(i5).a())
        {
          this.B = 0;
          return false;
        }
      if ((T()) && (!U().a()))
      {
        this.B = 0;
        return false;
      }
      this.B = m;
      return m;
    }

    public a aa()
    {
      return Z();
    }

    public a ab()
    {
      return a(this);
    }

    public g b(int paramInt)
    {
      return this.s.c(paramInt);
    }

    public final P b_()
    {
      return this.o;
    }

    public int c(int paramInt)
    {
      return ((Integer)this.t.get(paramInt)).intValue();
    }

    public int d()
    {
      int m = 0;
      int i1 = this.C;
      if (i1 != -1)
        return i1;
      if ((0x1 & this.p) == 1);
      for (int i2 = 0 + i.c(1, p()); ; i2 = 0)
      {
        if ((0x2 & this.p) == 2)
          i2 += i.c(2, s());
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.s.size())
        {
          i4 += i.b(this.s.c(i3));
          i3++;
        }
        int i5 = i2 + i4 + 1 * t().size();
        int i6 = 0;
        int i7 = i5;
        while (i6 < this.v.size())
        {
          i7 += i.g(4, (y)this.v.get(i6));
          i6++;
        }
        for (int i8 = 0; i8 < this.w.size(); i8++)
          i7 += i.g(5, (y)this.w.get(i8));
        for (int i9 = 0; i9 < this.x.size(); i9++)
          i7 += i.g(6, (y)this.x.get(i9));
        for (int i10 = 0; i10 < this.y.size(); i10++)
          i7 += i.g(7, (y)this.y.get(i10));
        if ((0x4 & this.p) == 4)
          i7 += i.g(8, this.z);
        if ((0x8 & this.p) == 8)
          i7 += i.g(9, this.A);
        int i11 = 0;
        int i12 = 0;
        while (i11 < this.t.size())
        {
          i12 += i.h(((Integer)this.t.get(i11)).intValue());
          i11++;
        }
        int i13 = i7 + i12 + 1 * v().size();
        int i16;
        for (int i14 = 0; m < this.u.size(); i14 = i16)
        {
          i16 = i14 + i.h(((Integer)this.u.get(m)).intValue());
          m++;
        }
        int i15 = i13 + i14 + 1 * x().size() + b_().d();
        this.C = i15;
        return i15;
      }
    }

    public int d(int paramInt)
    {
      return ((Integer)this.u.get(paramInt)).intValue();
    }

    public j.a e(int paramInt)
    {
      return (j.a)this.v.get(paramInt);
    }

    public j.b f(int paramInt)
    {
      return (j.b)this.v.get(paramInt);
    }

    public j.c g(int paramInt)
    {
      return (j.c)this.w.get(paramInt);
    }

    public j.d h(int paramInt)
    {
      return (j.d)this.w.get(paramInt);
    }

    public j.A i(int paramInt)
    {
      return (j.A)this.x.get(paramInt);
    }

    public o i()
    {
      return n;
    }

    public j.B j(int paramInt)
    {
      return (j.B)this.x.get(paramInt);
    }

    public j.k k(int paramInt)
    {
      return (j.k)this.y.get(paramInt);
    }

    public j.l l(int paramInt)
    {
      return (j.l)this.y.get(paramInt);
    }

    protected p.g l()
    {
      return j.e().a(o.class, a.class);
    }

    public B<o> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.p) == 1;
    }

    public String o()
    {
      Object localObject = this.q;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.q = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.q;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.q = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean q()
    {
      return (0x2 & this.p) == 2;
    }

    public String r()
    {
      Object localObject = this.r;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.r = str;
      return str;
    }

    public g s()
    {
      Object localObject = this.r;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.r = localg;
        return localg;
      }
      return (g)localObject;
    }

    public List<String> t()
    {
      return this.s;
    }

    public int u()
    {
      return this.s.size();
    }

    public List<Integer> v()
    {
      return this.t;
    }

    public int w()
    {
      return this.t.size();
    }

    public List<Integer> x()
    {
      return this.u;
    }

    public int y()
    {
      return this.u.size();
    }

    public List<j.a> z()
    {
      return this.v;
    }

    public static final class a extends p.a<a>
      implements j.p
    {
      private int a;
      private Object b = "";
      private Object c = "";
      private v d = u.a;
      private List<Integer> e = Collections.emptyList();
      private List<Integer> f = Collections.emptyList();
      private List<j.a> g = Collections.emptyList();
      private D<j.a, j.a.a, j.b> h;
      private List<j.c> i = Collections.emptyList();
      private D<j.c, j.c.a, j.d> j;
      private List<j.A> k = Collections.emptyList();
      private D<j.A, j.A.a, j.B> l;
      private List<j.k> m = Collections.emptyList();
      private D<j.k, j.k.a, j.l> n;
      private j.s o = j.s.h();
      private L<j.s, j.s.a, j.t> p;
      private j.E q = j.E.h();
      private L<j.E, j.E.a, j.F> r;

      private a()
      {
        aG();
      }

      private a(p.b paramb)
      {
        super();
        aG();
      }

      private void aG()
      {
        if (p.m)
        {
          aM();
          aO();
          aQ();
          aS();
          aT();
          aU();
        }
      }

      private static a aH()
      {
        return new a();
      }

      private void aI()
      {
        if ((0x4 & this.a) != 4)
        {
          this.d = new u(this.d);
          this.a = (0x4 | this.a);
        }
      }

      private void aJ()
      {
        if ((0x8 & this.a) != 8)
        {
          this.e = new ArrayList(this.e);
          this.a = (0x8 | this.a);
        }
      }

      private void aK()
      {
        if ((0x10 & this.a) != 16)
        {
          this.f = new ArrayList(this.f);
          this.a = (0x10 | this.a);
        }
      }

      private void aL()
      {
        if ((0x20 & this.a) != 32)
        {
          this.g = new ArrayList(this.g);
          this.a = (0x20 | this.a);
        }
      }

      private D<j.a, j.a.a, j.b> aM()
      {
        List localList;
        if (this.h == null)
        {
          localList = this.g;
          if ((0x20 & this.a) != 32)
            break label57;
        }
        label57: for (boolean bool = true; ; bool = false)
        {
          this.h = new D(localList, bool, aE(), aD());
          this.g = null;
          return this.h;
        }
      }

      private void aN()
      {
        if ((0x40 & this.a) != 64)
        {
          this.i = new ArrayList(this.i);
          this.a = (0x40 | this.a);
        }
      }

      private D<j.c, j.c.a, j.d> aO()
      {
        List localList;
        if (this.j == null)
        {
          localList = this.i;
          if ((0x40 & this.a) != 64)
            break label57;
        }
        label57: for (boolean bool = true; ; bool = false)
        {
          this.j = new D(localList, bool, aE(), aD());
          this.i = null;
          return this.j;
        }
      }

      private void aP()
      {
        if ((0x80 & this.a) != 128)
        {
          this.k = new ArrayList(this.k);
          this.a = (0x80 | this.a);
        }
      }

      private D<j.A, j.A.a, j.B> aQ()
      {
        List localList;
        if (this.l == null)
        {
          localList = this.k;
          if ((0x80 & this.a) != 128)
            break label59;
        }
        label59: for (boolean bool = true; ; bool = false)
        {
          this.l = new D(localList, bool, aE(), aD());
          this.k = null;
          return this.l;
        }
      }

      private void aR()
      {
        if ((0x100 & this.a) != 256)
        {
          this.m = new ArrayList(this.m);
          this.a = (0x100 | this.a);
        }
      }

      private D<j.k, j.k.a, j.l> aS()
      {
        List localList;
        if (this.n == null)
        {
          localList = this.m;
          if ((0x100 & this.a) != 256)
            break label59;
        }
        label59: for (boolean bool = true; ; bool = false)
        {
          this.n = new D(localList, bool, aE(), aD());
          this.m = null;
          return this.n;
        }
      }

      private L<j.s, j.s.a, j.t> aT()
      {
        if (this.p == null)
        {
          this.p = new L(this.o, aE(), aD());
          this.o = null;
        }
        return this.p;
      }

      private L<j.E, j.E.a, j.F> aU()
      {
        if (this.r == null)
        {
          this.r = new L(this.q, aE(), aD());
          this.q = null;
        }
        return this.r;
      }

      public static final k.a k()
      {
        return j.d();
      }

      public List<? extends j.b> A()
      {
        if (this.h != null)
          return this.h.i();
        return Collections.unmodifiableList(this.g);
      }

      public int B()
      {
        if (this.h == null)
          return this.g.size();
        return this.h.c();
      }

      public List<j.c> C()
      {
        if (this.j == null)
          return Collections.unmodifiableList(this.i);
        return this.j.g();
      }

      public List<? extends j.d> D()
      {
        if (this.j != null)
          return this.j.i();
        return Collections.unmodifiableList(this.i);
      }

      public int E()
      {
        if (this.j == null)
          return this.i.size();
        return this.j.c();
      }

      public List<j.A> F()
      {
        if (this.l == null)
          return Collections.unmodifiableList(this.k);
        return this.l.g();
      }

      public List<? extends j.B> G()
      {
        if (this.l != null)
          return this.l.i();
        return Collections.unmodifiableList(this.k);
      }

      public int H()
      {
        if (this.l == null)
          return this.k.size();
        return this.l.c();
      }

      public a I()
      {
        return aH().a(O());
      }

      public k.a J()
      {
        return j.d();
      }

      public List<j.k> K()
      {
        if (this.n == null)
          return Collections.unmodifiableList(this.m);
        return this.n.g();
      }

      public List<? extends j.l> L()
      {
        if (this.n != null)
          return this.n.i();
        return Collections.unmodifiableList(this.m);
      }

      public j.o M()
      {
        return j.o.h();
      }

      public j.o N()
      {
        j.o localo = O();
        if (!localo.a())
          throw b(localo);
        return localo;
      }

      public j.o O()
      {
        int i1 = 1;
        j.o localo = new j.o(this, null);
        int i2 = this.a;
        if ((i2 & 0x1) == i1);
        while (true)
        {
          j.o.a(localo, this.b);
          if ((i2 & 0x2) == 2)
            i1 |= 2;
          j.o.b(localo, this.c);
          if ((0x4 & this.a) == 4)
          {
            this.d = new Q(this.d);
            this.a = (0xFFFFFFFB & this.a);
          }
          j.o.a(localo, this.d);
          if ((0x8 & this.a) == 8)
          {
            this.e = Collections.unmodifiableList(this.e);
            this.a = (0xFFFFFFF7 & this.a);
          }
          j.o.a(localo, this.e);
          if ((0x10 & this.a) == 16)
          {
            this.f = Collections.unmodifiableList(this.f);
            this.a = (0xFFFFFFEF & this.a);
          }
          j.o.b(localo, this.f);
          if (this.h == null)
          {
            if ((0x20 & this.a) == 32)
            {
              this.g = Collections.unmodifiableList(this.g);
              this.a = (0xFFFFFFDF & this.a);
            }
            j.o.c(localo, this.g);
            if (this.j != null)
              break label484;
            if ((0x40 & this.a) == 64)
            {
              this.i = Collections.unmodifiableList(this.i);
              this.a = (0xFFFFFFBF & this.a);
            }
            j.o.d(localo, this.i);
            label284: if (this.l != null)
              break label499;
            if ((0x80 & this.a) == 128)
            {
              this.k = Collections.unmodifiableList(this.k);
              this.a = (0xFFFFFF7F & this.a);
            }
            j.o.e(localo, this.k);
            label337: if (this.n != null)
              break label514;
            if ((0x100 & this.a) == 256)
            {
              this.m = Collections.unmodifiableList(this.m);
              this.a = (0xFFFFFEFF & this.a);
            }
            j.o.f(localo, this.m);
            label390: if ((i2 & 0x200) != 512)
              break label565;
          }
          label422: label565: for (int i3 = i1 | 0x4; ; i3 = i1)
          {
            if (this.p == null)
            {
              j.o.a(localo, this.o);
              if ((i2 & 0x400) == 1024)
                i3 |= 8;
              if (this.r != null)
                break label547;
              j.o.a(localo, this.q);
            }
            while (true)
            {
              j.o.a(localo, i3);
              aB();
              return localo;
              j.o.c(localo, this.h.f());
              break;
              label484: j.o.d(localo, this.j.f());
              break label284;
              label499: j.o.e(localo, this.l.f());
              break label337;
              j.o.f(localo, this.n.f());
              break label390;
              j.o.a(localo, (j.s)this.p.d());
              break label422;
              j.o.a(localo, (j.E)this.r.d());
            }
          }
          label514: label547: i1 = 0;
        }
      }

      public a P()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.o.h().o();
        aF();
        return this;
      }

      public int S()
      {
        if (this.n == null)
          return this.m.size();
        return this.n.c();
      }

      public boolean T()
      {
        return (0x200 & this.a) == 512;
      }

      public j.s U()
      {
        if (this.p == null)
          return this.o;
        return (j.s)this.p.c();
      }

      public j.t V()
      {
        if (this.p != null)
          return (j.t)this.p.f();
        return this.o;
      }

      public boolean W()
      {
        return (0x400 & this.a) == 1024;
      }

      public j.E X()
      {
        if (this.r == null)
          return this.q;
        return (j.E)this.r.c();
      }

      public j.F Y()
      {
        if (this.r != null)
          return (j.F)this.r.f();
        return this.q;
      }

      public a Z()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.c = j.o.h().r();
        aF();
        return this;
      }

      public a a(int paramInt1, int paramInt2)
      {
        aJ();
        this.e.set(paramInt1, Integer.valueOf(paramInt2));
        aF();
        return this;
      }

      public a a(int paramInt, j.A.a parama)
      {
        if (this.l == null)
        {
          aP();
          this.k.set(paramInt, parama.y());
          aF();
          return this;
        }
        this.l.a(paramInt, parama.y());
        return this;
      }

      public a a(int paramInt, j.A paramA)
      {
        if (this.l == null)
        {
          if (paramA == null)
            throw new NullPointerException();
          aP();
          this.k.set(paramInt, paramA);
          aF();
          return this;
        }
        this.l.a(paramInt, paramA);
        return this;
      }

      public a a(int paramInt, j.a.a parama)
      {
        if (this.h == null)
        {
          aL();
          this.g.set(paramInt, parama.L());
          aF();
          return this;
        }
        this.h.a(paramInt, parama.L());
        return this;
      }

      public a a(int paramInt, j.a parama)
      {
        if (this.h == null)
        {
          if (parama == null)
            throw new NullPointerException();
          aL();
          this.g.set(paramInt, parama);
          aF();
          return this;
        }
        this.h.a(paramInt, parama);
        return this;
      }

      public a a(int paramInt, j.c.a parama)
      {
        if (this.j == null)
        {
          aN();
          this.i.set(paramInt, parama.y());
          aF();
          return this;
        }
        this.j.a(paramInt, parama.y());
        return this;
      }

      public a a(int paramInt, j.c paramc)
      {
        if (this.j == null)
        {
          if (paramc == null)
            throw new NullPointerException();
          aN();
          this.i.set(paramInt, paramc);
          aF();
          return this;
        }
        this.j.a(paramInt, paramc);
        return this;
      }

      public a a(int paramInt, j.k.a parama)
      {
        if (this.n == null)
        {
          aR();
          this.m.set(paramInt, parama.L());
          aF();
          return this;
        }
        this.n.a(paramInt, parama.L());
        return this;
      }

      public a a(int paramInt, j.k paramk)
      {
        if (this.n == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          aR();
          this.m.set(paramInt, paramk);
          aF();
          return this;
        }
        this.n.a(paramInt, paramk);
        return this;
      }

      public a a(int paramInt, String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        aI();
        this.d.set(paramInt, paramString);
        aF();
        return this;
      }

      public a a(j.A.a parama)
      {
        if (this.l == null)
        {
          aP();
          this.k.add(parama.y());
          aF();
          return this;
        }
        this.l.a(parama.y());
        return this;
      }

      public a a(j.A paramA)
      {
        if (this.l == null)
        {
          if (paramA == null)
            throw new NullPointerException();
          aP();
          this.k.add(paramA);
          aF();
          return this;
        }
        this.l.a(paramA);
        return this;
      }

      public a a(j.E.a parama)
      {
        if (this.r == null)
        {
          this.q = parama.s();
          aF();
        }
        while (true)
        {
          this.a = (0x400 | this.a);
          return this;
          this.r.a(parama.s());
        }
      }

      public a a(j.E paramE)
      {
        if (this.r == null)
        {
          if (paramE == null)
            throw new NullPointerException();
          this.q = paramE;
          aF();
        }
        while (true)
        {
          this.a = (0x400 | this.a);
          return this;
          this.r.a(paramE);
        }
      }

      public a a(j.a.a parama)
      {
        if (this.h == null)
        {
          aL();
          this.g.add(parama.L());
          aF();
          return this;
        }
        this.h.a(parama.L());
        return this;
      }

      public a a(j.a parama)
      {
        if (this.h == null)
        {
          if (parama == null)
            throw new NullPointerException();
          aL();
          this.g.add(parama);
          aF();
          return this;
        }
        this.h.a(parama);
        return this;
      }

      public a a(j.c.a parama)
      {
        if (this.j == null)
        {
          aN();
          this.i.add(parama.y());
          aF();
          return this;
        }
        this.j.a(parama.y());
        return this;
      }

      public a a(j.c paramc)
      {
        if (this.j == null)
        {
          if (paramc == null)
            throw new NullPointerException();
          aN();
          this.i.add(paramc);
          aF();
          return this;
        }
        this.j.a(paramc);
        return this;
      }

      public a a(j.k.a parama)
      {
        if (this.n == null)
        {
          aR();
          this.m.add(parama.L());
          aF();
          return this;
        }
        this.n.a(parama.L());
        return this;
      }

      public a a(j.k paramk)
      {
        if (this.n == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          aR();
          this.m.add(paramk);
          aF();
          return this;
        }
        this.n.a(paramk);
        return this;
      }

      public a a(j.o paramo)
      {
        if (paramo == j.o.h())
          return this;
        if (paramo.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.o.b(paramo);
          aF();
        }
        if (paramo.q())
        {
          this.a = (0x2 | this.a);
          this.c = j.o.c(paramo);
          aF();
        }
        if (!j.o.d(paramo).isEmpty())
        {
          if (this.d.isEmpty())
          {
            this.d = j.o.d(paramo);
            this.a = (0xFFFFFFFB & this.a);
            aF();
          }
        }
        else
        {
          if (!j.o.e(paramo).isEmpty())
          {
            if (!this.e.isEmpty())
              break label490;
            this.e = j.o.e(paramo);
            this.a = (0xFFFFFFF7 & this.a);
            label157: aF();
          }
          if (!j.o.f(paramo).isEmpty())
          {
            if (!this.f.isEmpty())
              break label511;
            this.f = j.o.f(paramo);
            this.a = (0xFFFFFFEF & this.a);
            label204: aF();
          }
          if (this.h != null)
            break label553;
          if (!j.o.g(paramo).isEmpty())
          {
            if (!this.g.isEmpty())
              break label532;
            this.g = j.o.g(paramo);
            this.a = (0xFFFFFFDF & this.a);
            label258: aF();
          }
          label262: if (this.j != null)
            break label669;
          if (!j.o.h(paramo).isEmpty())
          {
            if (!this.i.isEmpty())
              break label648;
            this.i = j.o.h(paramo);
            this.a = (0xFFFFFFBF & this.a);
            label312: aF();
          }
          label316: if (this.l != null)
            break label785;
          if (!j.o.i(paramo).isEmpty())
          {
            if (!this.k.isEmpty())
              break label764;
            this.k = j.o.i(paramo);
            this.a = (0xFFFFFF7F & this.a);
            label367: aF();
          }
          label371: if (this.n != null)
            break label902;
          if (!j.o.j(paramo).isEmpty())
          {
            if (!this.m.isEmpty())
              break label881;
            this.m = j.o.j(paramo);
            this.a = (0xFFFFFEFF & this.a);
            label422: aF();
          }
        }
        while (true)
        {
          if (paramo.T())
            b(paramo.U());
          if (paramo.W())
            b(paramo.X());
          d(paramo.b_());
          return this;
          aI();
          this.d.addAll(j.o.d(paramo));
          break;
          label490: aJ();
          this.e.addAll(j.o.e(paramo));
          break label157;
          label511: aK();
          this.f.addAll(j.o.f(paramo));
          break label204;
          label532: aL();
          this.g.addAll(j.o.g(paramo));
          break label258;
          label553: if (j.o.g(paramo).isEmpty())
            break label262;
          if (this.h.d())
          {
            this.h.b();
            this.h = null;
            this.g = j.o.g(paramo);
            this.a = (0xFFFFFFDF & this.a);
            if (p.m);
            for (D localD4 = aM(); ; localD4 = null)
            {
              this.h = localD4;
              break;
            }
          }
          this.h.a(j.o.g(paramo));
          break label262;
          label648: aN();
          this.i.addAll(j.o.h(paramo));
          break label312;
          label669: if (j.o.h(paramo).isEmpty())
            break label316;
          if (this.j.d())
          {
            this.j.b();
            this.j = null;
            this.i = j.o.h(paramo);
            this.a = (0xFFFFFFBF & this.a);
            if (p.m);
            for (D localD3 = aO(); ; localD3 = null)
            {
              this.j = localD3;
              break;
            }
          }
          this.j.a(j.o.h(paramo));
          break label316;
          label764: aP();
          this.k.addAll(j.o.i(paramo));
          break label367;
          label785: if (j.o.i(paramo).isEmpty())
            break label371;
          if (this.l.d())
          {
            this.l.b();
            this.l = null;
            this.k = j.o.i(paramo);
            this.a = (0xFFFFFF7F & this.a);
            if (p.m);
            for (D localD2 = aQ(); ; localD2 = null)
            {
              this.l = localD2;
              break;
            }
          }
          this.l.a(j.o.i(paramo));
          break label371;
          label881: aR();
          this.m.addAll(j.o.j(paramo));
          break label422;
          label902: if (!j.o.j(paramo).isEmpty())
            if (this.n.d())
            {
              this.n.b();
              this.n = null;
              this.m = j.o.j(paramo);
              this.a = (0xFFFFFEFF & this.a);
              boolean bool = p.m;
              D localD1 = null;
              if (bool)
                localD1 = aS();
              this.n = localD1;
            }
            else
            {
              this.n.a(j.o.j(paramo));
            }
        }
      }

      public a a(j.s.a parama)
      {
        if (this.p == null)
        {
          this.o = parama.N();
          aF();
        }
        while (true)
        {
          this.a = (0x200 | this.a);
          return this;
          this.p.a(parama.N());
        }
      }

      public a a(j.s params)
      {
        if (this.p == null)
        {
          if (params == null)
            throw new NullPointerException();
          this.o = params;
          aF();
        }
        while (true)
        {
          this.a = (0x200 | this.a);
          return this;
          this.p.a(params);
        }
      }

      public a a(Iterable<String> paramIterable)
      {
        aI();
        p.a.a(paramIterable, this.d);
        aF();
        return this;
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public String a(int paramInt)
      {
        return (String)this.d.get(paramInt);
      }

      public final boolean a()
      {
        int i1 = 0;
        if (i1 < B())
          if (e(i1).a());
        label56: label83: label113: 
        do
        {
          return false;
          i1++;
          break;
          for (int i2 = 0; ; i2++)
          {
            if (i2 >= E())
              break label56;
            if (!g(i2).a())
              break;
          }
          for (int i3 = 0; ; i3++)
          {
            if (i3 >= H())
              break label83;
            if (!i(i3).a())
              break;
          }
          for (int i4 = 0; ; i4++)
          {
            if (i4 >= S())
              break label113;
            if (!k(i4).a())
              break;
          }
        }
        while ((T()) && (!U().a()));
        return true;
      }

      public a aa()
      {
        this.d = u.a;
        this.a = (0xFFFFFFFB & this.a);
        aF();
        return this;
      }

      public a ab()
      {
        this.e = Collections.emptyList();
        this.a = (0xFFFFFFF7 & this.a);
        aF();
        return this;
      }

      public a ac()
      {
        this.f = Collections.emptyList();
        this.a = (0xFFFFFFEF & this.a);
        aF();
        return this;
      }

      public a ad()
      {
        if (this.h == null)
        {
          this.g = Collections.emptyList();
          this.a = (0xFFFFFFDF & this.a);
          aF();
          return this;
        }
        this.h.e();
        return this;
      }

      public j.a.a ae()
      {
        return (j.a.a)aM().b(j.a.h());
      }

      public List<j.a.a> af()
      {
        return aM().h();
      }

      public a ag()
      {
        if (this.j == null)
        {
          this.i = Collections.emptyList();
          this.a = (0xFFFFFFBF & this.a);
          aF();
          return this;
        }
        this.j.e();
        return this;
      }

      public j.c.a an()
      {
        return (j.c.a)aO().b(j.c.h());
      }

      public List<j.c.a> ao()
      {
        return aO().h();
      }

      public a ap()
      {
        if (this.l == null)
        {
          this.k = Collections.emptyList();
          this.a = (0xFFFFFF7F & this.a);
          aF();
          return this;
        }
        this.l.e();
        return this;
      }

      public j.A.a aq()
      {
        return (j.A.a)aQ().b(j.A.h());
      }

      public List<j.A.a> ar()
      {
        return aQ().h();
      }

      public a as()
      {
        if (this.n == null)
        {
          this.m = Collections.emptyList();
          this.a = (0xFFFFFEFF & this.a);
          aF();
          return this;
        }
        this.n.e();
        return this;
      }

      public j.k.a at()
      {
        return (j.k.a)aS().b(j.k.h());
      }

      public List<j.k.a> au()
      {
        return aS().h();
      }

      public a av()
      {
        if (this.p == null)
        {
          this.o = j.s.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFDFF & this.a);
          return this;
          this.p.g();
        }
      }

      public j.s.a aw()
      {
        this.a = (0x200 | this.a);
        aF();
        return (j.s.a)aT().e();
      }

      public a ax()
      {
        if (this.r == null)
        {
          this.q = j.E.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFBFF & this.a);
          return this;
          this.r.g();
        }
      }

      public j.E.a ay()
      {
        this.a = (0x400 | this.a);
        aF();
        return (j.E.a)aU().e();
      }

      public g b(int paramInt)
      {
        return this.d.c(paramInt);
      }

      public a b(int paramInt1, int paramInt2)
      {
        aK();
        this.f.set(paramInt1, Integer.valueOf(paramInt2));
        aF();
        return this;
      }

      public a b(int paramInt, j.A.a parama)
      {
        if (this.l == null)
        {
          aP();
          this.k.add(paramInt, parama.y());
          aF();
          return this;
        }
        this.l.b(paramInt, parama.y());
        return this;
      }

      public a b(int paramInt, j.A paramA)
      {
        if (this.l == null)
        {
          if (paramA == null)
            throw new NullPointerException();
          aP();
          this.k.add(paramInt, paramA);
          aF();
          return this;
        }
        this.l.b(paramInt, paramA);
        return this;
      }

      public a b(int paramInt, j.a.a parama)
      {
        if (this.h == null)
        {
          aL();
          this.g.add(paramInt, parama.L());
          aF();
          return this;
        }
        this.h.b(paramInt, parama.L());
        return this;
      }

      public a b(int paramInt, j.a parama)
      {
        if (this.h == null)
        {
          if (parama == null)
            throw new NullPointerException();
          aL();
          this.g.add(paramInt, parama);
          aF();
          return this;
        }
        this.h.b(paramInt, parama);
        return this;
      }

      public a b(int paramInt, j.c.a parama)
      {
        if (this.j == null)
        {
          aN();
          this.i.add(paramInt, parama.y());
          aF();
          return this;
        }
        this.j.b(paramInt, parama.y());
        return this;
      }

      public a b(int paramInt, j.c paramc)
      {
        if (this.j == null)
        {
          if (paramc == null)
            throw new NullPointerException();
          aN();
          this.i.add(paramInt, paramc);
          aF();
          return this;
        }
        this.j.b(paramInt, paramc);
        return this;
      }

      public a b(int paramInt, j.k.a parama)
      {
        if (this.n == null)
        {
          aR();
          this.m.add(paramInt, parama.L());
          aF();
          return this;
        }
        this.n.b(paramInt, parama.L());
        return this;
      }

      public a b(int paramInt, j.k paramk)
      {
        if (this.n == null)
        {
          if (paramk == null)
            throw new NullPointerException();
          aR();
          this.m.add(paramInt, paramk);
          aF();
          return this;
        }
        this.n.b(paramInt, paramk);
        return this;
      }

      public a b(j.E paramE)
      {
        if (this.r == null)
          if (((0x400 & this.a) == 1024) && (this.q != j.E.h()))
          {
            this.q = j.E.a(this.q).a(paramE).t();
            aF();
          }
        while (true)
        {
          this.a = (0x400 | this.a);
          return this;
          this.q = paramE;
          break;
          this.r.b(paramE);
        }
      }

      public a b(j.s params)
      {
        if (this.p == null)
          if (((0x200 & this.a) == 512) && (this.o != j.s.h()))
          {
            this.o = j.s.a(this.o).a(params).O();
            aF();
          }
        while (true)
        {
          this.a = (0x200 | this.a);
          return this;
          this.o = params;
          break;
          this.p.b(params);
        }
      }

      public a b(Iterable<? extends Integer> paramIterable)
      {
        aJ();
        p.a.a(paramIterable, this.e);
        aF();
        return this;
      }

      public a b(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.c = paramString;
        aF();
        return this;
      }

      public int c(int paramInt)
      {
        return ((Integer)this.e.get(paramInt)).intValue();
      }

      public a c(Iterable<? extends Integer> paramIterable)
      {
        aK();
        p.a.a(paramIterable, this.f);
        aF();
        return this;
      }

      public a c(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        aI();
        this.d.add(paramString);
        aF();
        return this;
      }

      public int d(int paramInt)
      {
        return ((Integer)this.f.get(paramInt)).intValue();
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.o))
          return a((j.o)paramx);
        super.a(paramx);
        return this;
      }

      public a d(Iterable<? extends j.a> paramIterable)
      {
        if (this.h == null)
        {
          aL();
          p.a.a(paramIterable, this.g);
          aF();
          return this;
        }
        this.h.a(paramIterable);
        return this;
      }

      public j.a e(int paramInt)
      {
        if (this.h == null)
          return (j.a)this.g.get(paramInt);
        return (j.a)this.h.a(paramInt);
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.o localo3 = (j.o)j.o.a.d(paramh, paramn);
          if (localo3 != null)
            a(localo3);
          return this;
        }
        catch (s locals)
        {
          j.o localo2 = (j.o)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localo1 = localo2;
          }
          if (localo1 != null)
            a(localo1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.o localo1 = null;
        }
      }

      public a e(Iterable<? extends j.c> paramIterable)
      {
        if (this.j == null)
        {
          aN();
          p.a.a(paramIterable, this.i);
          aF();
          return this;
        }
        this.j.a(paramIterable);
        return this;
      }

      public j.b f(int paramInt)
      {
        if (this.h == null)
          return (j.b)this.g.get(paramInt);
        return (j.b)this.h.c(paramInt);
      }

      public a f(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.c = paramg;
        aF();
        return this;
      }

      public a f(Iterable<? extends j.A> paramIterable)
      {
        if (this.l == null)
        {
          aP();
          p.a.a(paramIterable, this.k);
          aF();
          return this;
        }
        this.l.a(paramIterable);
        return this;
      }

      public j.c g(int paramInt)
      {
        if (this.j == null)
          return (j.c)this.i.get(paramInt);
        return (j.c)this.j.a(paramInt);
      }

      public a g(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        aI();
        this.d.a(paramg);
        aF();
        return this;
      }

      public a g(Iterable<? extends j.k> paramIterable)
      {
        if (this.n == null)
        {
          aR();
          p.a.a(paramIterable, this.m);
          aF();
          return this;
        }
        this.n.a(paramIterable);
        return this;
      }

      public j.d h(int paramInt)
      {
        if (this.j == null)
          return (j.d)this.i.get(paramInt);
        return (j.d)this.j.c(paramInt);
      }

      public j.A i(int paramInt)
      {
        if (this.l == null)
          return (j.A)this.k.get(paramInt);
        return (j.A)this.l.a(paramInt);
      }

      public j.B j(int paramInt)
      {
        if (this.l == null)
          return (j.B)this.k.get(paramInt);
        return (j.B)this.l.c(paramInt);
      }

      public j.k k(int paramInt)
      {
        if (this.n == null)
          return (j.k)this.m.get(paramInt);
        return (j.k)this.n.a(paramInt);
      }

      public j.l l(int paramInt)
      {
        if (this.n == null)
          return (j.l)this.m.get(paramInt);
        return (j.l)this.n.c(paramInt);
      }

      protected p.g l()
      {
        return j.e().a(j.o.class, a.class);
      }

      public a m()
      {
        super.ah();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        this.c = "";
        this.a = (0xFFFFFFFD & this.a);
        this.d = u.a;
        this.a = (0xFFFFFFFB & this.a);
        this.e = Collections.emptyList();
        this.a = (0xFFFFFFF7 & this.a);
        this.f = Collections.emptyList();
        this.a = (0xFFFFFFEF & this.a);
        if (this.h == null)
        {
          this.g = Collections.emptyList();
          this.a = (0xFFFFFFDF & this.a);
          if (this.j != null)
            break label259;
          this.i = Collections.emptyList();
          this.a = (0xFFFFFFBF & this.a);
          label143: if (this.l != null)
            break label269;
          this.k = Collections.emptyList();
          this.a = (0xFFFFFF7F & this.a);
          label169: if (this.n != null)
            break label279;
          this.m = Collections.emptyList();
          this.a = (0xFFFFFEFF & this.a);
          label195: if (this.p != null)
            break label289;
          this.o = j.s.h();
          label209: this.a = (0xFFFFFDFF & this.a);
          if (this.r != null)
            break label300;
          this.q = j.E.h();
        }
        while (true)
        {
          this.a = (0xFFFFFBFF & this.a);
          return this;
          this.h.e();
          break;
          label259: this.j.e();
          break label143;
          label269: this.l.e();
          break label169;
          label279: this.n.e();
          break label195;
          label289: this.p.g();
          break label209;
          label300: this.r.g();
        }
      }

      public a m(int paramInt)
      {
        aJ();
        this.e.add(Integer.valueOf(paramInt));
        aF();
        return this;
      }

      public a n(int paramInt)
      {
        aK();
        this.f.add(Integer.valueOf(paramInt));
        aF();
        return this;
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public a o(int paramInt)
      {
        if (this.h == null)
        {
          aL();
          this.g.remove(paramInt);
          aF();
          return this;
        }
        this.h.d(paramInt);
        return this;
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public j.a.a p(int paramInt)
      {
        return (j.a.a)aM().b(paramInt);
      }

      public j.a.a q(int paramInt)
      {
        return (j.a.a)aM().c(paramInt, j.a.h());
      }

      public boolean q()
      {
        return (0x2 & this.a) == 2;
      }

      public a r(int paramInt)
      {
        if (this.j == null)
        {
          aN();
          this.i.remove(paramInt);
          aF();
          return this;
        }
        this.j.d(paramInt);
        return this;
      }

      public String r()
      {
        Object localObject = this.c;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.c = str;
          return str;
        }
        return (String)localObject;
      }

      public g s()
      {
        Object localObject = this.c;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.c = localg;
          return localg;
        }
        return (g)localObject;
      }

      public j.c.a s(int paramInt)
      {
        return (j.c.a)aO().b(paramInt);
      }

      public j.c.a t(int paramInt)
      {
        return (j.c.a)aO().c(paramInt, j.c.h());
      }

      public List<String> t()
      {
        return Collections.unmodifiableList(this.d);
      }

      public int u()
      {
        return this.d.size();
      }

      public a u(int paramInt)
      {
        if (this.l == null)
        {
          aP();
          this.k.remove(paramInt);
          aF();
          return this;
        }
        this.l.d(paramInt);
        return this;
      }

      public j.A.a v(int paramInt)
      {
        return (j.A.a)aQ().b(paramInt);
      }

      public List<Integer> v()
      {
        return Collections.unmodifiableList(this.e);
      }

      public int w()
      {
        return this.e.size();
      }

      public j.A.a w(int paramInt)
      {
        return (j.A.a)aQ().c(paramInt, j.A.h());
      }

      public a x(int paramInt)
      {
        if (this.n == null)
        {
          aR();
          this.m.remove(paramInt);
          aF();
          return this;
        }
        this.n.d(paramInt);
        return this;
      }

      public List<Integer> x()
      {
        return Collections.unmodifiableList(this.f);
      }

      public int y()
      {
        return this.f.size();
      }

      public j.k.a y(int paramInt)
      {
        return (j.k.a)aS().b(paramInt);
      }

      public j.k.a z(int paramInt)
      {
        return (j.k.a)aS().c(paramInt, j.k.h());
      }

      public List<j.a> z()
      {
        if (this.h == null)
          return Collections.unmodifiableList(this.g);
        return this.h.g();
      }
    }
  }

  public static abstract interface p extends A
  {
    public abstract List<? extends j.b> A();

    public abstract int B();

    public abstract List<j.c> C();

    public abstract List<? extends j.d> D();

    public abstract int E();

    public abstract List<j.A> F();

    public abstract List<? extends j.B> G();

    public abstract int H();

    public abstract List<j.k> K();

    public abstract List<? extends j.l> L();

    public abstract int S();

    public abstract boolean T();

    public abstract j.s U();

    public abstract j.t V();

    public abstract boolean W();

    public abstract j.E X();

    public abstract j.F Y();

    public abstract String a(int paramInt);

    public abstract g b(int paramInt);

    public abstract int c(int paramInt);

    public abstract int d(int paramInt);

    public abstract j.a e(int paramInt);

    public abstract j.b f(int paramInt);

    public abstract j.c g(int paramInt);

    public abstract j.d h(int paramInt);

    public abstract j.A i(int paramInt);

    public abstract j.B j(int paramInt);

    public abstract j.k k(int paramInt);

    public abstract j.l l(int paramInt);

    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract boolean q();

    public abstract String r();

    public abstract g s();

    public abstract List<String> t();

    public abstract int u();

    public abstract List<Integer> v();

    public abstract int w();

    public abstract List<Integer> x();

    public abstract int y();

    public abstract List<j.a> z();
  }

  public static final class q extends p
    implements j.r
  {
    public static B<q> a = new c()
    {
      public j.q c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.q(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    private static final q c = new q(true);
    private static final long h;
    private final P d;
    private List<j.o> e;
    private byte f = -1;
    private int g = -1;

    static
    {
      c.t();
    }

    // ERROR //
    private q(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 47	com/umeng/message/proguard/p:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 49	com/umeng/message/proguard/j$q:f	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 51	com/umeng/message/proguard/j$q:g	I
      //   16: aload_0
      //   17: invokespecial 41	com/umeng/message/proguard/j$q:t	()V
      //   20: invokestatic 56	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +149 -> 178
      //   32: aload_1
      //   33: invokevirtual 61	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+28->68, 0:+190->230, 10:+46->86
      //   69: aload_1
      //   70: aload 4
      //   72: aload_2
      //   73: iload 9
      //   75: invokevirtual 64	com/umeng/message/proguard/j$q:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   78: ifne -50 -> 28
      //   81: iconst_1
      //   82: istore_3
      //   83: goto -55 -> 28
      //   86: iload 5
      //   88: iconst_1
      //   89: iand
      //   90: iconst_1
      //   91: if_icmpeq +20 -> 111
      //   94: aload_0
      //   95: new 66	java/util/ArrayList
      //   98: dup
      //   99: invokespecial 67	java/util/ArrayList:<init>	()V
      //   102: putfield 69	com/umeng/message/proguard/j$q:e	Ljava/util/List;
      //   105: iload 5
      //   107: iconst_1
      //   108: ior
      //   109: istore 5
      //   111: aload_0
      //   112: getfield 69	com/umeng/message/proguard/j$q:e	Ljava/util/List;
      //   115: aload_1
      //   116: getstatic 72	com/umeng/message/proguard/j$o:a	Lcom/umeng/message/proguard/B;
      //   119: aload_2
      //   120: invokevirtual 75	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   123: invokeinterface 81 2 0
      //   128: pop
      //   129: goto -101 -> 28
      //   132: astore 8
      //   134: aload 8
      //   136: aload_0
      //   137: invokevirtual 84	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   140: athrow
      //   141: astore 7
      //   143: iload 5
      //   145: iconst_1
      //   146: iand
      //   147: iconst_1
      //   148: if_icmpne +14 -> 162
      //   151: aload_0
      //   152: aload_0
      //   153: getfield 69	com/umeng/message/proguard/j$q:e	Ljava/util/List;
      //   156: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   159: putfield 69	com/umeng/message/proguard/j$q:e	Ljava/util/List;
      //   162: aload_0
      //   163: aload 4
      //   165: invokevirtual 95	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   168: putfield 97	com/umeng/message/proguard/j$q:d	Lcom/umeng/message/proguard/P;
      //   171: aload_0
      //   172: invokevirtual 100	com/umeng/message/proguard/j$q:ad	()V
      //   175: aload 7
      //   177: athrow
      //   178: iload 5
      //   180: iconst_1
      //   181: iand
      //   182: iconst_1
      //   183: if_icmpne +14 -> 197
      //   186: aload_0
      //   187: aload_0
      //   188: getfield 69	com/umeng/message/proguard/j$q:e	Ljava/util/List;
      //   191: invokestatic 90	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   194: putfield 69	com/umeng/message/proguard/j$q:e	Ljava/util/List;
      //   197: aload_0
      //   198: aload 4
      //   200: invokevirtual 95	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   203: putfield 97	com/umeng/message/proguard/j$q:d	Lcom/umeng/message/proguard/P;
      //   206: aload_0
      //   207: invokevirtual 100	com/umeng/message/proguard/j$q:ad	()V
      //   210: return
      //   211: astore 6
      //   213: new 44	com/umeng/message/proguard/s
      //   216: dup
      //   217: aload 6
      //   219: invokevirtual 104	java/io/IOException:getMessage	()Ljava/lang/String;
      //   222: invokespecial 107	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   225: aload_0
      //   226: invokevirtual 84	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   229: athrow
      //   230: iconst_1
      //   231: istore_3
      //   232: goto -204 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	132	com/umeng/message/proguard/s
      //   68	81	132	com/umeng/message/proguard/s
      //   94	105	132	com/umeng/message/proguard/s
      //   111	129	132	com/umeng/message/proguard/s
      //   32	38	141	finally
      //   68	81	141	finally
      //   94	105	141	finally
      //   111	129	141	finally
      //   134	141	141	finally
      //   213	230	141	finally
      //   32	38	211	java/io/IOException
      //   68	81	211	java/io/IOException
      //   94	105	211	java/io/IOException
      //   111	129	211	java/io/IOException
    }

    private q(p.a<?> parama)
    {
      super();
      this.d = parama.b_();
    }

    private q(boolean paramBoolean)
    {
      this.d = P.c();
    }

    public static a a(q paramq)
    {
      return q().a(paramq);
    }

    public static q a(g paramg)
      throws s
    {
      return (q)a.d(paramg);
    }

    public static q a(g paramg, n paramn)
      throws s
    {
      return (q)a.d(paramg, paramn);
    }

    public static q a(h paramh)
      throws IOException
    {
      return (q)a.d(paramh);
    }

    public static q a(h paramh, n paramn)
      throws IOException
    {
      return (q)a.b(paramh, paramn);
    }

    public static q a(InputStream paramInputStream)
      throws IOException
    {
      return (q)a.h(paramInputStream);
    }

    public static q a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (q)a.h(paramInputStream, paramn);
    }

    public static q a(byte[] paramArrayOfByte)
      throws s
    {
      return (q)a.d(paramArrayOfByte);
    }

    public static q a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (q)a.d(paramArrayOfByte, paramn);
    }

    public static q b(InputStream paramInputStream)
      throws IOException
    {
      return (q)a.f(paramInputStream);
    }

    public static q b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (q)a.f(paramInputStream, paramn);
    }

    public static q h()
    {
      return c;
    }

    public static final k.a k()
    {
      return j.b();
    }

    public static a q()
    {
      return a.x();
    }

    private void t()
    {
      this.e = Collections.emptyList();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public j.o a(int paramInt)
    {
      return (j.o)this.e.get(paramInt);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      for (int i = 0; i < this.e.size(); i++)
        parami.c(1, (y)this.e.get(i));
      b_().a(parami);
    }

    public final boolean a()
    {
      int i = this.f;
      if (i != -1)
        return i == 1;
      for (int j = 0; j < p(); j++)
        if (!a(j).a())
        {
          this.f = 0;
          return false;
        }
      this.f = 1;
      return true;
    }

    public j.p b(int paramInt)
    {
      return (j.p)this.e.get(paramInt);
    }

    public final P b_()
    {
      return this.d;
    }

    public int d()
    {
      int i = this.g;
      if (i != -1)
        return i;
      int j = 0;
      int k = 0;
      while (j < this.e.size())
      {
        k += i.g(1, (y)this.e.get(j));
        j++;
      }
      int m = k + b_().d();
      this.g = m;
      return m;
    }

    public q i()
    {
      return c;
    }

    protected p.g l()
    {
      return j.c().a(q.class, a.class);
    }

    public B<q> m()
    {
      return a;
    }

    public List<j.o> n()
    {
      return this.e;
    }

    public List<? extends j.p> o()
    {
      return this.e;
    }

    public int p()
    {
      return this.e.size();
    }

    public a r()
    {
      return q();
    }

    public a s()
    {
      return a(this);
    }

    public static final class a extends p.a<a>
      implements j.r
    {
      private int a;
      private List<j.o> b = Collections.emptyList();
      private D<j.o, j.o.a, j.p> c;

      private a()
      {
        y();
      }

      private a(p.b paramb)
      {
        super();
        y();
      }

      private void A()
      {
        if ((0x1 & this.a) != 1)
        {
          this.b = new ArrayList(this.b);
          this.a = (0x1 | this.a);
        }
      }

      private D<j.o, j.o.a, j.p> B()
      {
        int i = 1;
        List localList;
        if (this.c == null)
        {
          localList = this.b;
          if ((0x1 & this.a) != i)
            break label55;
        }
        while (true)
        {
          this.c = new D(localList, i, aE(), aD());
          this.b = null;
          return this.c;
          label55: int j = 0;
        }
      }

      public static final k.a k()
      {
        return j.b();
      }

      private void y()
      {
        if (p.m)
          B();
      }

      private static a z()
      {
        return new a();
      }

      public k.a J()
      {
        return j.b();
      }

      public j.o a(int paramInt)
      {
        if (this.c == null)
          return (j.o)this.b.get(paramInt);
        return (j.o)this.c.a(paramInt);
      }

      public a a(int paramInt, j.o.a parama)
      {
        if (this.c == null)
        {
          A();
          this.b.set(paramInt, parama.N());
          aF();
          return this;
        }
        this.c.a(paramInt, parama.N());
        return this;
      }

      public a a(int paramInt, j.o paramo)
      {
        if (this.c == null)
        {
          if (paramo == null)
            throw new NullPointerException();
          A();
          this.b.set(paramInt, paramo);
          aF();
          return this;
        }
        this.c.a(paramInt, paramo);
        return this;
      }

      public a a(j.o.a parama)
      {
        if (this.c == null)
        {
          A();
          this.b.add(parama.N());
          aF();
          return this;
        }
        this.c.a(parama.N());
        return this;
      }

      public a a(j.o paramo)
      {
        if (this.c == null)
        {
          if (paramo == null)
            throw new NullPointerException();
          A();
          this.b.add(paramo);
          aF();
          return this;
        }
        this.c.a(paramo);
        return this;
      }

      public a a(j.q paramq)
      {
        if (paramq == j.q.h())
          return this;
        if (this.c == null)
          if (!j.q.b(paramq).isEmpty())
          {
            if (!this.b.isEmpty())
              break label74;
            this.b = j.q.b(paramq);
            this.a = (0xFFFFFFFE & this.a);
            aF();
          }
        while (true)
        {
          d(paramq.b_());
          return this;
          label74: A();
          this.b.addAll(j.q.b(paramq));
          break;
          if (!j.q.b(paramq).isEmpty())
            if (this.c.d())
            {
              this.c.b();
              this.c = null;
              this.b = j.q.b(paramq);
              this.a = (0xFFFFFFFE & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = B();
              this.c = localD;
            }
            else
            {
              this.c.a(j.q.b(paramq));
            }
        }
      }

      public a a(Iterable<? extends j.o> paramIterable)
      {
        if (this.c == null)
        {
          A();
          p.a.a(paramIterable, this.b);
          aF();
          return this;
        }
        this.c.a(paramIterable);
        return this;
      }

      public final boolean a()
      {
        for (int i = 0; i < p(); i++)
          if (!a(i).a())
            return false;
        return true;
      }

      public j.p b(int paramInt)
      {
        if (this.c == null)
          return (j.p)this.b.get(paramInt);
        return (j.p)this.c.c(paramInt);
      }

      public a b(int paramInt, j.o.a parama)
      {
        if (this.c == null)
        {
          A();
          this.b.add(paramInt, parama.N());
          aF();
          return this;
        }
        this.c.b(paramInt, parama.N());
        return this;
      }

      public a b(int paramInt, j.o paramo)
      {
        if (this.c == null)
        {
          if (paramo == null)
            throw new NullPointerException();
          A();
          this.b.add(paramInt, paramo);
          aF();
          return this;
        }
        this.c.b(paramInt, paramo);
        return this;
      }

      public a c(int paramInt)
      {
        if (this.c == null)
        {
          A();
          this.b.remove(paramInt);
          aF();
          return this;
        }
        this.c.d(paramInt);
        return this;
      }

      public j.o.a d(int paramInt)
      {
        return (j.o.a)B().b(paramInt);
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.q))
          return a((j.q)paramx);
        super.a(paramx);
        return this;
      }

      public j.o.a e(int paramInt)
      {
        return (j.o.a)B().c(paramInt, j.o.h());
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.q localq3 = (j.q)j.q.a.d(paramh, paramn);
          if (localq3 != null)
            a(localq3);
          return this;
        }
        catch (s locals)
        {
          j.q localq2 = (j.q)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localq1 = localq2;
          }
          if (localq1 != null)
            a(localq1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.q localq1 = null;
        }
      }

      protected p.g l()
      {
        return j.c().a(j.q.class, a.class);
      }

      public a m()
      {
        super.ah();
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          return this;
        }
        this.c.e();
        return this;
      }

      public List<j.o> n()
      {
        if (this.c == null)
          return Collections.unmodifiableList(this.b);
        return this.c.g();
      }

      public List<? extends j.p> o()
      {
        if (this.c != null)
          return this.c.i();
        return Collections.unmodifiableList(this.b);
      }

      public int p()
      {
        if (this.c == null)
          return this.b.size();
        return this.c.c();
      }

      public a q()
      {
        return z().a(t());
      }

      public j.q r()
      {
        return j.q.h();
      }

      public j.q s()
      {
        j.q localq = t();
        if (!localq.a())
          throw b(localq);
        return localq;
      }

      public j.q t()
      {
        j.q localq = new j.q(this, null);
        if (this.c == null)
        {
          if ((0x1 & this.a) == 1)
          {
            this.b = Collections.unmodifiableList(this.b);
            this.a = (0xFFFFFFFE & this.a);
          }
          j.q.a(localq, this.b);
        }
        while (true)
        {
          aB();
          return localq;
          j.q.a(localq, this.c.f());
        }
      }

      public a u()
      {
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          aF();
          return this;
        }
        this.c.e();
        return this;
      }

      public j.o.a v()
      {
        return (j.o.a)B().b(j.o.h());
      }

      public List<j.o.a> w()
      {
        return B().h();
      }
    }
  }

  public static abstract interface r extends A
  {
    public abstract j.o a(int paramInt);

    public abstract j.p b(int paramInt);

    public abstract List<j.o> n();

    public abstract List<? extends j.p> o();

    public abstract int p();
  }

  public static final class s extends p.d<s>
    implements j.t
  {
    private static final long B = 0L;
    public static B<s> a = new c()
    {
      public j.s c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.s(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 8;
    public static final int d = 10;
    public static final int e = 20;
    public static final int f = 9;
    public static final int g = 11;
    public static final int h = 16;
    public static final int i = 17;
    public static final int j = 18;
    public static final int k = 999;
    private static final s l = new s(true);
    private int A = -1;
    private final P n;
    private int o;
    private Object p;
    private Object q;
    private boolean r;
    private boolean s;
    private b t;
    private Object u;
    private boolean v;
    private boolean w;
    private boolean x;
    private List<j.G> y;
    private byte z = -1;

    static
    {
      l.ae();
    }

    // ERROR //
    private s(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 80	com/umeng/message/proguard/p$d:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 82	com/umeng/message/proguard/j$s:z	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 84	com/umeng/message/proguard/j$s:A	I
      //   16: aload_0
      //   17: invokespecial 74	com/umeng/message/proguard/j$s:ae	()V
      //   20: invokestatic 89	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +476 -> 505
      //   32: aload_1
      //   33: invokevirtual 94	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+100->140, 0:+502->542, 10:+118->158, 66:+189->229, 72:+229->269, 80:+280->320, 90:+301->341, 128:+323->363, 136:+345->385, 144:+368->408, 160:+391->431, 7994:+413->453
      //   141: aload_1
      //   142: aload 4
      //   144: aload_2
      //   145: iload 9
      //   147: invokevirtual 97	com/umeng/message/proguard/j$s:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   150: ifne -122 -> 28
      //   153: iconst_1
      //   154: istore_3
      //   155: goto -127 -> 28
      //   158: aload_0
      //   159: iconst_1
      //   160: aload_0
      //   161: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   164: ior
      //   165: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   168: aload_0
      //   169: aload_1
      //   170: invokevirtual 102	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   173: putfield 104	com/umeng/message/proguard/j$s:p	Ljava/lang/Object;
      //   176: goto -148 -> 28
      //   179: astore 8
      //   181: aload 8
      //   183: aload_0
      //   184: invokevirtual 107	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   187: athrow
      //   188: astore 7
      //   190: iload 5
      //   192: sipush 512
      //   195: iand
      //   196: sipush 512
      //   199: if_icmpne +14 -> 213
      //   202: aload_0
      //   203: aload_0
      //   204: getfield 109	com/umeng/message/proguard/j$s:y	Ljava/util/List;
      //   207: invokestatic 115	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   210: putfield 109	com/umeng/message/proguard/j$s:y	Ljava/util/List;
      //   213: aload_0
      //   214: aload 4
      //   216: invokevirtual 120	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   219: putfield 122	com/umeng/message/proguard/j$s:n	Lcom/umeng/message/proguard/P;
      //   222: aload_0
      //   223: invokevirtual 125	com/umeng/message/proguard/j$s:ad	()V
      //   226: aload 7
      //   228: athrow
      //   229: aload_0
      //   230: iconst_2
      //   231: aload_0
      //   232: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   235: ior
      //   236: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   239: aload_0
      //   240: aload_1
      //   241: invokevirtual 102	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   244: putfield 127	com/umeng/message/proguard/j$s:q	Ljava/lang/Object;
      //   247: goto -219 -> 28
      //   250: astore 6
      //   252: new 77	com/umeng/message/proguard/s
      //   255: dup
      //   256: aload 6
      //   258: invokevirtual 131	java/io/IOException:getMessage	()Ljava/lang/String;
      //   261: invokespecial 134	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   264: aload_0
      //   265: invokevirtual 107	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   268: athrow
      //   269: aload_1
      //   270: invokevirtual 136	com/umeng/message/proguard/h:n	()I
      //   273: istore 11
      //   275: iload 11
      //   277: invokestatic 141	com/umeng/message/proguard/j$s$b:a	(I)Lcom/umeng/message/proguard/j$s$b;
      //   280: astore 12
      //   282: aload 12
      //   284: ifnonnull +16 -> 300
      //   287: aload 4
      //   289: bipush 9
      //   291: iload 11
      //   293: invokevirtual 144	com/umeng/message/proguard/P$a:a	(II)Lcom/umeng/message/proguard/P$a;
      //   296: pop
      //   297: goto -269 -> 28
      //   300: aload_0
      //   301: bipush 16
      //   303: aload_0
      //   304: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   307: ior
      //   308: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   311: aload_0
      //   312: aload 12
      //   314: putfield 146	com/umeng/message/proguard/j$s:t	Lcom/umeng/message/proguard/j$s$b;
      //   317: goto -289 -> 28
      //   320: aload_0
      //   321: iconst_4
      //   322: aload_0
      //   323: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   326: ior
      //   327: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   330: aload_0
      //   331: aload_1
      //   332: invokevirtual 149	com/umeng/message/proguard/h:j	()Z
      //   335: putfield 151	com/umeng/message/proguard/j$s:r	Z
      //   338: goto -310 -> 28
      //   341: aload_0
      //   342: bipush 32
      //   344: aload_0
      //   345: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   348: ior
      //   349: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   352: aload_0
      //   353: aload_1
      //   354: invokevirtual 102	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   357: putfield 153	com/umeng/message/proguard/j$s:u	Ljava/lang/Object;
      //   360: goto -332 -> 28
      //   363: aload_0
      //   364: bipush 64
      //   366: aload_0
      //   367: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   370: ior
      //   371: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   374: aload_0
      //   375: aload_1
      //   376: invokevirtual 149	com/umeng/message/proguard/h:j	()Z
      //   379: putfield 155	com/umeng/message/proguard/j$s:v	Z
      //   382: goto -354 -> 28
      //   385: aload_0
      //   386: sipush 128
      //   389: aload_0
      //   390: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   393: ior
      //   394: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   397: aload_0
      //   398: aload_1
      //   399: invokevirtual 149	com/umeng/message/proguard/h:j	()Z
      //   402: putfield 157	com/umeng/message/proguard/j$s:w	Z
      //   405: goto -377 -> 28
      //   408: aload_0
      //   409: sipush 256
      //   412: aload_0
      //   413: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   416: ior
      //   417: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   420: aload_0
      //   421: aload_1
      //   422: invokevirtual 149	com/umeng/message/proguard/h:j	()Z
      //   425: putfield 159	com/umeng/message/proguard/j$s:x	Z
      //   428: goto -400 -> 28
      //   431: aload_0
      //   432: bipush 8
      //   434: aload_0
      //   435: getfield 99	com/umeng/message/proguard/j$s:o	I
      //   438: ior
      //   439: putfield 99	com/umeng/message/proguard/j$s:o	I
      //   442: aload_0
      //   443: aload_1
      //   444: invokevirtual 149	com/umeng/message/proguard/h:j	()Z
      //   447: putfield 161	com/umeng/message/proguard/j$s:s	Z
      //   450: goto -422 -> 28
      //   453: iload 5
      //   455: sipush 512
      //   458: iand
      //   459: sipush 512
      //   462: if_icmpeq +22 -> 484
      //   465: aload_0
      //   466: new 163	java/util/ArrayList
      //   469: dup
      //   470: invokespecial 164	java/util/ArrayList:<init>	()V
      //   473: putfield 109	com/umeng/message/proguard/j$s:y	Ljava/util/List;
      //   476: iload 5
      //   478: sipush 512
      //   481: ior
      //   482: istore 5
      //   484: aload_0
      //   485: getfield 109	com/umeng/message/proguard/j$s:y	Ljava/util/List;
      //   488: aload_1
      //   489: getstatic 167	com/umeng/message/proguard/j$G:a	Lcom/umeng/message/proguard/B;
      //   492: aload_2
      //   493: invokevirtual 170	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   496: invokeinterface 176 2 0
      //   501: pop
      //   502: goto -474 -> 28
      //   505: iload 5
      //   507: sipush 512
      //   510: iand
      //   511: sipush 512
      //   514: if_icmpne +14 -> 528
      //   517: aload_0
      //   518: aload_0
      //   519: getfield 109	com/umeng/message/proguard/j$s:y	Ljava/util/List;
      //   522: invokestatic 115	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   525: putfield 109	com/umeng/message/proguard/j$s:y	Ljava/util/List;
      //   528: aload_0
      //   529: aload 4
      //   531: invokevirtual 120	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   534: putfield 122	com/umeng/message/proguard/j$s:n	Lcom/umeng/message/proguard/P;
      //   537: aload_0
      //   538: invokevirtual 125	com/umeng/message/proguard/j$s:ad	()V
      //   541: return
      //   542: iconst_1
      //   543: istore_3
      //   544: goto -516 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	179	com/umeng/message/proguard/s
      //   140	153	179	com/umeng/message/proguard/s
      //   158	176	179	com/umeng/message/proguard/s
      //   229	247	179	com/umeng/message/proguard/s
      //   269	282	179	com/umeng/message/proguard/s
      //   287	297	179	com/umeng/message/proguard/s
      //   300	317	179	com/umeng/message/proguard/s
      //   320	338	179	com/umeng/message/proguard/s
      //   341	360	179	com/umeng/message/proguard/s
      //   363	382	179	com/umeng/message/proguard/s
      //   385	405	179	com/umeng/message/proguard/s
      //   408	428	179	com/umeng/message/proguard/s
      //   431	450	179	com/umeng/message/proguard/s
      //   465	476	179	com/umeng/message/proguard/s
      //   484	502	179	com/umeng/message/proguard/s
      //   32	38	188	finally
      //   140	153	188	finally
      //   158	176	188	finally
      //   181	188	188	finally
      //   229	247	188	finally
      //   252	269	188	finally
      //   269	282	188	finally
      //   287	297	188	finally
      //   300	317	188	finally
      //   320	338	188	finally
      //   341	360	188	finally
      //   363	382	188	finally
      //   385	405	188	finally
      //   408	428	188	finally
      //   431	450	188	finally
      //   465	476	188	finally
      //   484	502	188	finally
      //   32	38	250	java/io/IOException
      //   140	153	250	java/io/IOException
      //   158	176	250	java/io/IOException
      //   229	247	250	java/io/IOException
      //   269	282	250	java/io/IOException
      //   287	297	250	java/io/IOException
      //   300	317	250	java/io/IOException
      //   320	338	250	java/io/IOException
      //   341	360	250	java/io/IOException
      //   363	382	250	java/io/IOException
      //   385	405	250	java/io/IOException
      //   408	428	250	java/io/IOException
      //   431	450	250	java/io/IOException
      //   465	476	250	java/io/IOException
      //   484	502	250	java/io/IOException
    }

    private s(p.c<s, ?> paramc)
    {
      super();
      this.n = paramc.b_();
    }

    private s(boolean paramBoolean)
    {
      this.n = P.c();
    }

    public static a T()
    {
      return a.ae();
    }

    public static a a(s params)
    {
      return T().a(params);
    }

    public static s a(g paramg)
      throws s
    {
      return (s)a.d(paramg);
    }

    public static s a(g paramg, n paramn)
      throws s
    {
      return (s)a.d(paramg, paramn);
    }

    public static s a(h paramh)
      throws IOException
    {
      return (s)a.d(paramh);
    }

    public static s a(h paramh, n paramn)
      throws IOException
    {
      return (s)a.b(paramh, paramn);
    }

    public static s a(InputStream paramInputStream)
      throws IOException
    {
      return (s)a.h(paramInputStream);
    }

    public static s a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (s)a.h(paramInputStream, paramn);
    }

    public static s a(byte[] paramArrayOfByte)
      throws s
    {
      return (s)a.d(paramArrayOfByte);
    }

    public static s a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (s)a.d(paramArrayOfByte, paramn);
    }

    private void ae()
    {
      this.p = "";
      this.q = "";
      this.r = false;
      this.s = false;
      this.t = b.a;
      this.u = "";
      this.v = false;
      this.w = false;
      this.x = false;
      this.y = Collections.emptyList();
    }

    public static s b(InputStream paramInputStream)
      throws IOException
    {
      return (s)a.f(paramInputStream);
    }

    public static s b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (s)a.f(paramInputStream, paramn);
    }

    public static s h()
    {
      return l;
    }

    public static final k.a k()
    {
      return j.t();
    }

    public boolean C()
    {
      return (0x40 & this.o) == 64;
    }

    public boolean D()
    {
      return this.v;
    }

    public boolean E()
    {
      return (0x80 & this.o) == 128;
    }

    public boolean F()
    {
      return this.w;
    }

    public boolean G()
    {
      return (0x100 & this.o) == 256;
    }

    public boolean H()
    {
      return this.x;
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public List<j.G> K()
    {
      return this.y;
    }

    public List<? extends j.H> L()
    {
      return this.y;
    }

    public int S()
    {
      return this.y.size();
    }

    public a U()
    {
      return T();
    }

    public a V()
    {
      return a(this);
    }

    public j.G a(int paramInt)
    {
      return (j.G)this.y.get(paramInt);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      p.d.a locala = X();
      if ((0x1 & this.o) == 1)
        parami.a(1, p());
      if ((0x2 & this.o) == 2)
        parami.a(8, s());
      if ((0x10 & this.o) == 16)
        parami.d(9, this.t.a());
      if ((0x4 & this.o) == 4)
        parami.a(10, this.r);
      if ((0x20 & this.o) == 32)
        parami.a(11, g_());
      if ((0x40 & this.o) == 64)
        parami.a(16, this.v);
      if ((0x80 & this.o) == 128)
        parami.a(17, this.w);
      if ((0x100 & this.o) == 256)
        parami.a(18, this.x);
      if ((0x8 & this.o) == 8)
        parami.a(20, this.s);
      for (int m = 0; m < this.y.size(); m++)
        parami.c(999, (y)this.y.get(m));
      locala.a(536870912, parami);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.z;
      if (m != -1)
        return m == 1;
      for (int i1 = 0; i1 < S(); i1++)
        if (!a(i1).a())
        {
          this.z = 0;
          return false;
        }
      if (!W())
      {
        this.z = 0;
        return false;
      }
      this.z = 1;
      return true;
    }

    public j.H b(int paramInt)
    {
      return (j.H)this.y.get(paramInt);
    }

    public final P b_()
    {
      return this.n;
    }

    public int d()
    {
      int m = 0;
      int i1 = this.A;
      if (i1 != -1)
        return i1;
      if ((0x1 & this.o) == 1);
      for (int i2 = 0 + i.c(1, p()); ; i2 = 0)
      {
        if ((0x2 & this.o) == 2)
          i2 += i.c(8, s());
        if ((0x10 & this.o) == 16)
          i2 += i.j(9, this.t.a());
        if ((0x4 & this.o) == 4)
          i2 += i.b(10, this.r);
        if ((0x20 & this.o) == 32)
          i2 += i.c(11, g_());
        if ((0x40 & this.o) == 64)
          i2 += i.b(16, this.v);
        if ((0x80 & this.o) == 128)
          i2 += i.b(17, this.w);
        if ((0x100 & this.o) == 256)
          i2 += i.b(18, this.x);
        if ((0x8 & this.o) == 8)
          i2 += i.b(20, this.s);
        int i5;
        for (int i3 = i2; m < this.y.size(); i3 = i5)
        {
          i5 = i3 + i.g(999, (y)this.y.get(m));
          m++;
        }
        int i4 = i3 + Z() + b_().d();
        this.A = i4;
        return i4;
      }
    }

    public String f_()
    {
      Object localObject = this.u;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.u = str;
      return str;
    }

    public g g_()
    {
      Object localObject = this.u;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.u = localg;
        return localg;
      }
      return (g)localObject;
    }

    public s i()
    {
      return l;
    }

    protected p.g l()
    {
      return j.u().a(s.class, a.class);
    }

    public B<s> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.o) == 1;
    }

    public String o()
    {
      Object localObject = this.p;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.p = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.p;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.p = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean q()
    {
      return (0x2 & this.o) == 2;
    }

    public String r()
    {
      Object localObject = this.q;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.q = str;
      return str;
    }

    public g s()
    {
      Object localObject = this.q;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.q = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean t()
    {
      return (0x4 & this.o) == 4;
    }

    public boolean u()
    {
      return this.r;
    }

    public boolean v()
    {
      return (0x8 & this.o) == 8;
    }

    public boolean w()
    {
      return this.s;
    }

    public boolean x()
    {
      return (0x10 & this.o) == 16;
    }

    public b y()
    {
      return this.t;
    }

    public boolean z()
    {
      return (0x20 & this.o) == 32;
    }

    public static final class a extends p.c<j.s, a>
      implements j.t
    {
      private int a;
      private Object b = "";
      private Object c = "";
      private boolean d;
      private boolean e;
      private j.s.b f = j.s.b.a;
      private Object g = "";
      private boolean h;
      private boolean i;
      private boolean j;
      private List<j.G> k = Collections.emptyList();
      private D<j.G, j.G.a, j.H> l;

      private a()
      {
        ag();
      }

      private a(p.b paramb)
      {
        super();
        ag();
      }

      private void ag()
      {
        if (p.m)
          ap();
      }

      private static a an()
      {
        return new a();
      }

      private void ao()
      {
        if ((0x200 & this.a) != 512)
        {
          this.k = new ArrayList(this.k);
          this.a = (0x200 | this.a);
        }
      }

      private D<j.G, j.G.a, j.H> ap()
      {
        List localList;
        if (this.l == null)
        {
          localList = this.k;
          if ((0x200 & this.a) != 512)
            break label59;
        }
        label59: for (boolean bool = true; ; bool = false)
        {
          this.l = new D(localList, bool, aE(), aD());
          this.k = null;
          return this.l;
        }
      }

      public static final k.a k()
      {
        return j.t();
      }

      public boolean C()
      {
        return (0x40 & this.a) == 64;
      }

      public boolean D()
      {
        return this.h;
      }

      public boolean E()
      {
        return (0x80 & this.a) == 128;
      }

      public boolean F()
      {
        return this.i;
      }

      public boolean G()
      {
        return (0x100 & this.a) == 256;
      }

      public boolean H()
      {
        return this.j;
      }

      public a I()
      {
        return an().a(O());
      }

      public k.a J()
      {
        return j.t();
      }

      public List<j.G> K()
      {
        if (this.l == null)
          return Collections.unmodifiableList(this.k);
        return this.l.g();
      }

      public List<? extends j.H> L()
      {
        if (this.l != null)
          return this.l.i();
        return Collections.unmodifiableList(this.k);
      }

      public j.s M()
      {
        return j.s.h();
      }

      public j.s N()
      {
        j.s locals = O();
        if (!locals.a())
          throw b(locals);
        return locals;
      }

      public j.s O()
      {
        int m = 1;
        j.s locals = new j.s(this, null);
        int n = this.a;
        if ((n & 0x1) == m);
        while (true)
        {
          j.s.a(locals, this.b);
          if ((n & 0x2) == 2)
            m |= 2;
          j.s.b(locals, this.c);
          if ((n & 0x4) == 4)
            m |= 4;
          j.s.a(locals, this.d);
          if ((n & 0x8) == 8)
            m |= 8;
          j.s.b(locals, this.e);
          if ((n & 0x10) == 16)
            m |= 16;
          j.s.a(locals, this.f);
          if ((n & 0x20) == 32)
            m |= 32;
          j.s.c(locals, this.g);
          if ((n & 0x40) == 64)
            m |= 64;
          j.s.c(locals, this.h);
          if ((n & 0x80) == 128)
            m |= 128;
          j.s.d(locals, this.i);
          if ((n & 0x100) == 256)
            m |= 256;
          j.s.e(locals, this.j);
          if (this.l == null)
          {
            if ((0x200 & this.a) == 512)
            {
              this.k = Collections.unmodifiableList(this.k);
              this.a = (0xFFFFFDFF & this.a);
            }
            j.s.a(locals, this.k);
          }
          while (true)
          {
            j.s.a(locals, m);
            aB();
            return locals;
            j.s.a(locals, this.l.f());
          }
          m = 0;
        }
      }

      public a P()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.s.h().o();
        aF();
        return this;
      }

      public int S()
      {
        if (this.l == null)
          return this.k.size();
        return this.l.c();
      }

      public a T()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.c = j.s.h().r();
        aF();
        return this;
      }

      public a U()
      {
        this.a = (0xFFFFFFFB & this.a);
        this.d = false;
        aF();
        return this;
      }

      public a V()
      {
        this.a = (0xFFFFFFF7 & this.a);
        this.e = false;
        aF();
        return this;
      }

      public a W()
      {
        this.a = (0xFFFFFFEF & this.a);
        this.f = j.s.b.a;
        aF();
        return this;
      }

      public a X()
      {
        this.a = (0xFFFFFFDF & this.a);
        this.g = j.s.h().f_();
        aF();
        return this;
      }

      public a Y()
      {
        this.a = (0xFFFFFFBF & this.a);
        this.h = false;
        aF();
        return this;
      }

      public a Z()
      {
        this.a = (0xFFFFFF7F & this.a);
        this.i = false;
        aF();
        return this;
      }

      public j.G a(int paramInt)
      {
        if (this.l == null)
          return (j.G)this.k.get(paramInt);
        return (j.G)this.l.a(paramInt);
      }

      public a a(int paramInt, j.G.a parama)
      {
        if (this.l == null)
        {
          ao();
          this.k.set(paramInt, parama.G());
          aF();
          return this;
        }
        this.l.a(paramInt, parama.G());
        return this;
      }

      public a a(int paramInt, j.G paramG)
      {
        if (this.l == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          ao();
          this.k.set(paramInt, paramG);
          aF();
          return this;
        }
        this.l.a(paramInt, paramG);
        return this;
      }

      public a a(j.G.a parama)
      {
        if (this.l == null)
        {
          ao();
          this.k.add(parama.G());
          aF();
          return this;
        }
        this.l.a(parama.G());
        return this;
      }

      public a a(j.G paramG)
      {
        if (this.l == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          ao();
          this.k.add(paramG);
          aF();
          return this;
        }
        this.l.a(paramG);
        return this;
      }

      public a a(j.s.b paramb)
      {
        if (paramb == null)
          throw new NullPointerException();
        this.a = (0x10 | this.a);
        this.f = paramb;
        aF();
        return this;
      }

      public a a(j.s params)
      {
        if (params == j.s.h())
          return this;
        if (params.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.s.b(params);
          aF();
        }
        if (params.q())
        {
          this.a = (0x2 | this.a);
          this.c = j.s.c(params);
          aF();
        }
        if (params.t())
          a(params.u());
        if (params.v())
          b(params.w());
        if (params.x())
          a(params.y());
        if (params.z())
        {
          this.a = (0x20 | this.a);
          this.g = j.s.d(params);
          aF();
        }
        if (params.C())
          c(params.D());
        if (params.E())
          d(params.F());
        if (params.G())
          e(params.H());
        if (this.l == null)
          if (!j.s.e(params).isEmpty())
          {
            if (!this.k.isEmpty())
              break label264;
            this.k = j.s.e(params);
            this.a = (0xFFFFFDFF & this.a);
            aF();
          }
        while (true)
        {
          a(params);
          d(params.b_());
          return this;
          label264: ao();
          this.k.addAll(j.s.e(params));
          break;
          if (!j.s.e(params).isEmpty())
            if (this.l.d())
            {
              this.l.b();
              this.l = null;
              this.k = j.s.e(params);
              this.a = (0xFFFFFDFF & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = ap();
              this.l = localD;
            }
            else
            {
              this.l.a(j.s.e(params));
            }
        }
      }

      public a a(Iterable<? extends j.G> paramIterable)
      {
        if (this.l == null)
        {
          ao();
          p.c.a(paramIterable, this.k);
          aF();
          return this;
        }
        this.l.a(paramIterable);
        return this;
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.a = (0x4 | this.a);
        this.d = paramBoolean;
        aF();
        return this;
      }

      public final boolean a()
      {
        int m = 0;
        if (m < S())
          if (a(m).a());
        while (!af())
        {
          return false;
          m++;
          break;
        }
        return true;
      }

      public a aa()
      {
        this.a = (0xFFFFFEFF & this.a);
        this.j = false;
        aF();
        return this;
      }

      public a ab()
      {
        if (this.l == null)
        {
          this.k = Collections.emptyList();
          this.a = (0xFFFFFDFF & this.a);
          aF();
          return this;
        }
        this.l.e();
        return this;
      }

      public j.G.a ac()
      {
        return (j.G.a)ap().b(j.G.h());
      }

      public List<j.G.a> ad()
      {
        return ap().h();
      }

      public j.H b(int paramInt)
      {
        if (this.l == null)
          return (j.H)this.k.get(paramInt);
        return (j.H)this.l.c(paramInt);
      }

      public a b(int paramInt, j.G.a parama)
      {
        if (this.l == null)
        {
          ao();
          this.k.add(paramInt, parama.G());
          aF();
          return this;
        }
        this.l.b(paramInt, parama.G());
        return this;
      }

      public a b(int paramInt, j.G paramG)
      {
        if (this.l == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          ao();
          this.k.add(paramInt, paramG);
          aF();
          return this;
        }
        this.l.b(paramInt, paramG);
        return this;
      }

      public a b(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.c = paramString;
        aF();
        return this;
      }

      public a b(boolean paramBoolean)
      {
        this.a = (0x8 | this.a);
        this.e = paramBoolean;
        aF();
        return this;
      }

      public a c(int paramInt)
      {
        if (this.l == null)
        {
          ao();
          this.k.remove(paramInt);
          aF();
          return this;
        }
        this.l.d(paramInt);
        return this;
      }

      public a c(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x20 | this.a);
        this.g = paramString;
        aF();
        return this;
      }

      public a c(boolean paramBoolean)
      {
        this.a = (0x40 | this.a);
        this.h = paramBoolean;
        aF();
        return this;
      }

      public j.G.a d(int paramInt)
      {
        return (j.G.a)ap().b(paramInt);
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.s))
          return a((j.s)paramx);
        super.a(paramx);
        return this;
      }

      public a d(boolean paramBoolean)
      {
        this.a = (0x80 | this.a);
        this.i = paramBoolean;
        aF();
        return this;
      }

      public j.G.a e(int paramInt)
      {
        return (j.G.a)ap().c(paramInt, j.G.h());
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.s locals3 = (j.s)j.s.a.d(paramh, paramn);
          if (locals3 != null)
            a(locals3);
          return this;
        }
        catch (s locals)
        {
          j.s locals2 = (j.s)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            locals1 = locals2;
          }
          if (locals1 != null)
            a(locals1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.s locals1 = null;
        }
      }

      public a e(boolean paramBoolean)
      {
        this.a = (0x100 | this.a);
        this.j = paramBoolean;
        aF();
        return this;
      }

      public a f(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.c = paramg;
        aF();
        return this;
      }

      public String f_()
      {
        Object localObject = this.g;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.g = str;
          return str;
        }
        return (String)localObject;
      }

      public a g(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x20 | this.a);
        this.g = paramg;
        aF();
        return this;
      }

      public g g_()
      {
        Object localObject = this.g;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.g = localg;
          return localg;
        }
        return (g)localObject;
      }

      protected p.g l()
      {
        return j.u().a(j.s.class, a.class);
      }

      public a m()
      {
        super.B();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        this.c = "";
        this.a = (0xFFFFFFFD & this.a);
        this.d = false;
        this.a = (0xFFFFFFFB & this.a);
        this.e = false;
        this.a = (0xFFFFFFF7 & this.a);
        this.f = j.s.b.a;
        this.a = (0xFFFFFFEF & this.a);
        this.g = "";
        this.a = (0xFFFFFFDF & this.a);
        this.h = false;
        this.a = (0xFFFFFFBF & this.a);
        this.i = false;
        this.a = (0xFFFFFF7F & this.a);
        this.j = false;
        this.a = (0xFFFFFEFF & this.a);
        if (this.l == null)
        {
          this.k = Collections.emptyList();
          this.a = (0xFFFFFDFF & this.a);
          return this;
        }
        this.l.e();
        return this;
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean q()
      {
        return (0x2 & this.a) == 2;
      }

      public String r()
      {
        Object localObject = this.c;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.c = str;
          return str;
        }
        return (String)localObject;
      }

      public g s()
      {
        Object localObject = this.c;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.c = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean t()
      {
        return (0x4 & this.a) == 4;
      }

      public boolean u()
      {
        return this.d;
      }

      public boolean v()
      {
        return (0x8 & this.a) == 8;
      }

      public boolean w()
      {
        return this.e;
      }

      public boolean x()
      {
        return (0x10 & this.a) == 16;
      }

      public j.s.b y()
      {
        return this.f;
      }

      public boolean z()
      {
        return (0x20 & this.a) == 32;
      }
    }

    public static enum b
      implements C
    {
      public static final int d = 1;
      public static final int e = 2;
      public static final int f = 3;
      private static r.b<b> g = new r.b()
      {
        public j.s.b a(int paramAnonymousInt)
        {
          return j.s.b.a(paramAnonymousInt);
        }
      };
      private static final b[] h = values();
      private final int i;
      private final int j;

      static
      {
        b[] arrayOfb = new b[3];
        arrayOfb[0] = a;
        arrayOfb[1] = b;
        arrayOfb[2] = c;
        k = arrayOfb;
      }

      private b(int paramInt1, int paramInt2)
      {
        this.i = paramInt1;
        this.j = paramInt2;
      }

      public static b a(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 1:
          return a;
        case 2:
          return b;
        case 3:
        }
        return c;
      }

      public static b a(k.e parame)
      {
        if (parame.g() != e())
          throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        return h[parame.b()];
      }

      public static r.b<b> b()
      {
        return g;
      }

      public static final k.d e()
      {
        return (k.d)j.s.k().k().get(0);
      }

      public final int a()
      {
        return this.j;
      }

      public final k.e c()
      {
        return (k.e)e().h().get(this.i);
      }

      public final k.d d()
      {
        return e();
      }
    }
  }

  public static abstract interface t extends p.e<j.s>
  {
    public abstract boolean C();

    public abstract boolean D();

    public abstract boolean E();

    public abstract boolean F();

    public abstract boolean G();

    public abstract boolean H();

    public abstract List<j.G> K();

    public abstract List<? extends j.H> L();

    public abstract int S();

    public abstract j.G a(int paramInt);

    public abstract j.H b(int paramInt);

    public abstract String f_();

    public abstract g g_();

    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract boolean q();

    public abstract String r();

    public abstract g s();

    public abstract boolean t();

    public abstract boolean u();

    public abstract boolean v();

    public abstract boolean w();

    public abstract boolean x();

    public abstract j.s.b y();

    public abstract boolean z();
  }

  public static final class u extends p.d<u>
    implements j.v
  {
    public static B<u> a = new c()
    {
      public j.u c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.u(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 999;
    private static final u e = new u(true);
    private static final long n;
    private final P f;
    private int g;
    private boolean h;
    private boolean i;
    private List<j.G> j;
    private byte k = -1;
    private int l = -1;

    static
    {
      e.x();
    }

    // ERROR //
    private u(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 56	com/umeng/message/proguard/p$d:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 58	com/umeng/message/proguard/j$u:k	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 60	com/umeng/message/proguard/j$u:l	I
      //   16: aload_0
      //   17: invokespecial 50	com/umeng/message/proguard/j$u:x	()V
      //   20: invokestatic 65	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +226 -> 255
      //   32: aload_1
      //   33: invokevirtual 70	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+44->84, 0:+248->288, 8:+62->102, 16:+129->169, 7994:+169->209
      //   85: aload_1
      //   86: aload 4
      //   88: aload_2
      //   89: iload 9
      //   91: invokevirtual 73	com/umeng/message/proguard/j$u:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   94: ifne -66 -> 28
      //   97: iconst_1
      //   98: istore_3
      //   99: goto -71 -> 28
      //   102: aload_0
      //   103: iconst_1
      //   104: aload_0
      //   105: getfield 75	com/umeng/message/proguard/j$u:g	I
      //   108: ior
      //   109: putfield 75	com/umeng/message/proguard/j$u:g	I
      //   112: aload_0
      //   113: aload_1
      //   114: invokevirtual 78	com/umeng/message/proguard/h:j	()Z
      //   117: putfield 80	com/umeng/message/proguard/j$u:h	Z
      //   120: goto -92 -> 28
      //   123: astore 8
      //   125: aload 8
      //   127: aload_0
      //   128: invokevirtual 83	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   131: athrow
      //   132: astore 7
      //   134: iload 5
      //   136: iconst_4
      //   137: iand
      //   138: iconst_4
      //   139: if_icmpne +14 -> 153
      //   142: aload_0
      //   143: aload_0
      //   144: getfield 85	com/umeng/message/proguard/j$u:j	Ljava/util/List;
      //   147: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   150: putfield 85	com/umeng/message/proguard/j$u:j	Ljava/util/List;
      //   153: aload_0
      //   154: aload 4
      //   156: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   159: putfield 98	com/umeng/message/proguard/j$u:f	Lcom/umeng/message/proguard/P;
      //   162: aload_0
      //   163: invokevirtual 101	com/umeng/message/proguard/j$u:ad	()V
      //   166: aload 7
      //   168: athrow
      //   169: aload_0
      //   170: iconst_2
      //   171: aload_0
      //   172: getfield 75	com/umeng/message/proguard/j$u:g	I
      //   175: ior
      //   176: putfield 75	com/umeng/message/proguard/j$u:g	I
      //   179: aload_0
      //   180: aload_1
      //   181: invokevirtual 78	com/umeng/message/proguard/h:j	()Z
      //   184: putfield 103	com/umeng/message/proguard/j$u:i	Z
      //   187: goto -159 -> 28
      //   190: astore 6
      //   192: new 53	com/umeng/message/proguard/s
      //   195: dup
      //   196: aload 6
      //   198: invokevirtual 107	java/io/IOException:getMessage	()Ljava/lang/String;
      //   201: invokespecial 110	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   204: aload_0
      //   205: invokevirtual 83	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   208: athrow
      //   209: iload 5
      //   211: iconst_4
      //   212: iand
      //   213: iconst_4
      //   214: if_icmpeq +20 -> 234
      //   217: aload_0
      //   218: new 112	java/util/ArrayList
      //   221: dup
      //   222: invokespecial 113	java/util/ArrayList:<init>	()V
      //   225: putfield 85	com/umeng/message/proguard/j$u:j	Ljava/util/List;
      //   228: iload 5
      //   230: iconst_4
      //   231: ior
      //   232: istore 5
      //   234: aload_0
      //   235: getfield 85	com/umeng/message/proguard/j$u:j	Ljava/util/List;
      //   238: aload_1
      //   239: getstatic 116	com/umeng/message/proguard/j$G:a	Lcom/umeng/message/proguard/B;
      //   242: aload_2
      //   243: invokevirtual 119	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   246: invokeinterface 125 2 0
      //   251: pop
      //   252: goto -224 -> 28
      //   255: iload 5
      //   257: iconst_4
      //   258: iand
      //   259: iconst_4
      //   260: if_icmpne +14 -> 274
      //   263: aload_0
      //   264: aload_0
      //   265: getfield 85	com/umeng/message/proguard/j$u:j	Ljava/util/List;
      //   268: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   271: putfield 85	com/umeng/message/proguard/j$u:j	Ljava/util/List;
      //   274: aload_0
      //   275: aload 4
      //   277: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   280: putfield 98	com/umeng/message/proguard/j$u:f	Lcom/umeng/message/proguard/P;
      //   283: aload_0
      //   284: invokevirtual 101	com/umeng/message/proguard/j$u:ad	()V
      //   287: return
      //   288: iconst_1
      //   289: istore_3
      //   290: goto -262 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	123	com/umeng/message/proguard/s
      //   84	97	123	com/umeng/message/proguard/s
      //   102	120	123	com/umeng/message/proguard/s
      //   169	187	123	com/umeng/message/proguard/s
      //   217	228	123	com/umeng/message/proguard/s
      //   234	252	123	com/umeng/message/proguard/s
      //   32	38	132	finally
      //   84	97	132	finally
      //   102	120	132	finally
      //   125	132	132	finally
      //   169	187	132	finally
      //   192	209	132	finally
      //   217	228	132	finally
      //   234	252	132	finally
      //   32	38	190	java/io/IOException
      //   84	97	190	java/io/IOException
      //   102	120	190	java/io/IOException
      //   169	187	190	java/io/IOException
      //   217	228	190	java/io/IOException
      //   234	252	190	java/io/IOException
    }

    private u(p.c<u, ?> paramc)
    {
      super();
      this.f = paramc.b_();
    }

    private u(boolean paramBoolean)
    {
      this.f = P.c();
    }

    public static a a(u paramu)
    {
      return u().a(paramu);
    }

    public static u a(g paramg)
      throws s
    {
      return (u)a.d(paramg);
    }

    public static u a(g paramg, n paramn)
      throws s
    {
      return (u)a.d(paramg, paramn);
    }

    public static u a(h paramh)
      throws IOException
    {
      return (u)a.d(paramh);
    }

    public static u a(h paramh, n paramn)
      throws IOException
    {
      return (u)a.b(paramh, paramn);
    }

    public static u a(InputStream paramInputStream)
      throws IOException
    {
      return (u)a.h(paramInputStream);
    }

    public static u a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (u)a.h(paramInputStream, paramn);
    }

    public static u a(byte[] paramArrayOfByte)
      throws s
    {
      return (u)a.d(paramArrayOfByte);
    }

    public static u a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (u)a.d(paramArrayOfByte, paramn);
    }

    public static u b(InputStream paramInputStream)
      throws IOException
    {
      return (u)a.f(paramInputStream);
    }

    public static u b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (u)a.f(paramInputStream, paramn);
    }

    public static u h()
    {
      return e;
    }

    public static final k.a k()
    {
      return j.v();
    }

    public static a u()
    {
      return a.F();
    }

    private void x()
    {
      this.h = false;
      this.i = false;
      this.j = Collections.emptyList();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public j.G a(int paramInt)
    {
      return (j.G)this.j.get(paramInt);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      p.d.a locala = X();
      if ((0x1 & this.g) == 1)
        parami.a(1, this.h);
      if ((0x2 & this.g) == 2)
        parami.a(2, this.i);
      for (int m = 0; m < this.j.size(); m++)
        parami.c(999, (y)this.j.get(m));
      locala.a(536870912, parami);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.k;
      if (m != -1)
        return m == 1;
      for (int i1 = 0; i1 < t(); i1++)
        if (!a(i1).a())
        {
          this.k = 0;
          return false;
        }
      if (!W())
      {
        this.k = 0;
        return false;
      }
      this.k = 1;
      return true;
    }

    public j.H b(int paramInt)
    {
      return (j.H)this.j.get(paramInt);
    }

    public final P b_()
    {
      return this.f;
    }

    public int d()
    {
      int m = 0;
      int i1 = this.l;
      if (i1 != -1)
        return i1;
      if ((0x1 & this.g) == 1);
      for (int i2 = 0 + i.b(1, this.h); ; i2 = 0)
      {
        if ((0x2 & this.g) == 2)
          i2 += i.b(2, this.i);
        int i5;
        for (int i3 = i2; m < this.j.size(); i3 = i5)
        {
          i5 = i3 + i.g(999, (y)this.j.get(m));
          m++;
        }
        int i4 = i3 + Z() + b_().d();
        this.l = i4;
        return i4;
      }
    }

    public u i()
    {
      return e;
    }

    protected p.g l()
    {
      return j.w().a(u.class, a.class);
    }

    public B<u> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.g) == 1;
    }

    public boolean o()
    {
      return this.h;
    }

    public boolean p()
    {
      return (0x2 & this.g) == 2;
    }

    public boolean q()
    {
      return this.i;
    }

    public List<j.G> r()
    {
      return this.j;
    }

    public List<? extends j.H> s()
    {
      return this.j;
    }

    public int t()
    {
      return this.j.size();
    }

    public a v()
    {
      return u();
    }

    public a w()
    {
      return a(this);
    }

    public static final class a extends p.c<j.u, a>
      implements j.v
    {
      private int a;
      private boolean b;
      private boolean c;
      private List<j.G> d = Collections.emptyList();
      private D<j.G, j.G.a, j.H> e;

      private a()
      {
        G();
      }

      private a(p.b paramb)
      {
        super();
        G();
      }

      private void G()
      {
        if (p.m)
          K();
      }

      private static a H()
      {
        return new a();
      }

      private void I()
      {
        if ((0x4 & this.a) != 4)
        {
          this.d = new ArrayList(this.d);
          this.a = (0x4 | this.a);
        }
      }

      private D<j.G, j.G.a, j.H> K()
      {
        List localList;
        if (this.e == null)
        {
          localList = this.d;
          if ((0x4 & this.a) != 4)
            break label55;
        }
        label55: for (boolean bool = true; ; bool = false)
        {
          this.e = new D(localList, bool, aE(), aD());
          this.d = null;
          return this.e;
        }
      }

      public static final k.a k()
      {
        return j.v();
      }

      public a C()
      {
        if (this.e == null)
        {
          this.d = Collections.emptyList();
          this.a = (0xFFFFFFFB & this.a);
          aF();
          return this;
        }
        this.e.e();
        return this;
      }

      public j.G.a D()
      {
        return (j.G.a)K().b(j.G.h());
      }

      public List<j.G.a> E()
      {
        return K().h();
      }

      public k.a J()
      {
        return j.v();
      }

      public j.G a(int paramInt)
      {
        if (this.e == null)
          return (j.G)this.d.get(paramInt);
        return (j.G)this.e.a(paramInt);
      }

      public a a(int paramInt, j.G.a parama)
      {
        if (this.e == null)
        {
          I();
          this.d.set(paramInt, parama.G());
          aF();
          return this;
        }
        this.e.a(paramInt, parama.G());
        return this;
      }

      public a a(int paramInt, j.G paramG)
      {
        if (this.e == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          I();
          this.d.set(paramInt, paramG);
          aF();
          return this;
        }
        this.e.a(paramInt, paramG);
        return this;
      }

      public a a(j.G.a parama)
      {
        if (this.e == null)
        {
          I();
          this.d.add(parama.G());
          aF();
          return this;
        }
        this.e.a(parama.G());
        return this;
      }

      public a a(j.G paramG)
      {
        if (this.e == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          I();
          this.d.add(paramG);
          aF();
          return this;
        }
        this.e.a(paramG);
        return this;
      }

      public a a(j.u paramu)
      {
        if (paramu == j.u.h())
          return this;
        if (paramu.n())
          a(paramu.o());
        if (paramu.p())
          b(paramu.q());
        if (this.e == null)
          if (!j.u.b(paramu).isEmpty())
          {
            if (!this.d.isEmpty())
              break label111;
            this.d = j.u.b(paramu);
            this.a = (0xFFFFFFFB & this.a);
            aF();
          }
        while (true)
        {
          a(paramu);
          d(paramu.b_());
          return this;
          label111: I();
          this.d.addAll(j.u.b(paramu));
          break;
          if (!j.u.b(paramu).isEmpty())
            if (this.e.d())
            {
              this.e.b();
              this.e = null;
              this.d = j.u.b(paramu);
              this.a = (0xFFFFFFFB & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = K();
              this.e = localD;
            }
            else
            {
              this.e.a(j.u.b(paramu));
            }
        }
      }

      public a a(Iterable<? extends j.G> paramIterable)
      {
        if (this.e == null)
        {
          I();
          p.c.a(paramIterable, this.d);
          aF();
          return this;
        }
        this.e.a(paramIterable);
        return this;
      }

      public a a(boolean paramBoolean)
      {
        this.a = (0x1 | this.a);
        this.b = paramBoolean;
        aF();
        return this;
      }

      public final boolean a()
      {
        int i = 0;
        if (i < t())
          if (a(i).a());
        while (!af())
        {
          return false;
          i++;
          break;
        }
        return true;
      }

      public j.H b(int paramInt)
      {
        if (this.e == null)
          return (j.H)this.d.get(paramInt);
        return (j.H)this.e.c(paramInt);
      }

      public a b(int paramInt, j.G.a parama)
      {
        if (this.e == null)
        {
          I();
          this.d.add(paramInt, parama.G());
          aF();
          return this;
        }
        this.e.b(paramInt, parama.G());
        return this;
      }

      public a b(int paramInt, j.G paramG)
      {
        if (this.e == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          I();
          this.d.add(paramInt, paramG);
          aF();
          return this;
        }
        this.e.b(paramInt, paramG);
        return this;
      }

      public a b(boolean paramBoolean)
      {
        this.a = (0x2 | this.a);
        this.c = paramBoolean;
        aF();
        return this;
      }

      public a c(int paramInt)
      {
        if (this.e == null)
        {
          I();
          this.d.remove(paramInt);
          aF();
          return this;
        }
        this.e.d(paramInt);
        return this;
      }

      public j.G.a d(int paramInt)
      {
        return (j.G.a)K().b(paramInt);
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.u))
          return a((j.u)paramx);
        super.a(paramx);
        return this;
      }

      public j.G.a e(int paramInt)
      {
        return (j.G.a)K().c(paramInt, j.G.h());
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.u localu3 = (j.u)j.u.a.d(paramh, paramn);
          if (localu3 != null)
            a(localu3);
          return this;
        }
        catch (s locals)
        {
          j.u localu2 = (j.u)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localu1 = localu2;
          }
          if (localu1 != null)
            a(localu1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.u localu1 = null;
        }
      }

      protected p.g l()
      {
        return j.w().a(j.u.class, a.class);
      }

      public a m()
      {
        super.B();
        this.b = false;
        this.a = (0xFFFFFFFE & this.a);
        this.c = false;
        this.a = (0xFFFFFFFD & this.a);
        if (this.e == null)
        {
          this.d = Collections.emptyList();
          this.a = (0xFFFFFFFB & this.a);
          return this;
        }
        this.e.e();
        return this;
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public boolean o()
      {
        return this.b;
      }

      public boolean p()
      {
        return (0x2 & this.a) == 2;
      }

      public boolean q()
      {
        return this.c;
      }

      public List<j.G> r()
      {
        if (this.e == null)
          return Collections.unmodifiableList(this.d);
        return this.e.g();
      }

      public List<? extends j.H> s()
      {
        if (this.e != null)
          return this.e.i();
        return Collections.unmodifiableList(this.d);
      }

      public int t()
      {
        if (this.e == null)
          return this.d.size();
        return this.e.c();
      }

      public a u()
      {
        return H().a(x());
      }

      public j.u v()
      {
        return j.u.h();
      }

      public j.u w()
      {
        j.u localu = x();
        if (!localu.a())
          throw b(localu);
        return localu;
      }

      public j.u x()
      {
        int i = 1;
        j.u localu = new j.u(this, null);
        int j = this.a;
        if ((j & 0x1) == i);
        while (true)
        {
          j.u.a(localu, this.b);
          if ((j & 0x2) == 2)
            i |= 2;
          j.u.b(localu, this.c);
          if (this.e == null)
          {
            if ((0x4 & this.a) == 4)
            {
              this.d = Collections.unmodifiableList(this.d);
              this.a = (0xFFFFFFFB & this.a);
            }
            j.u.a(localu, this.d);
          }
          while (true)
          {
            j.u.a(localu, i);
            aB();
            return localu;
            j.u.a(localu, this.e.f());
          }
          i = 0;
        }
      }

      public a y()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = false;
        aF();
        return this;
      }

      public a z()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.c = false;
        aF();
        return this;
      }
    }
  }

  public static abstract interface v extends p.e<j.u>
  {
    public abstract j.G a(int paramInt);

    public abstract j.H b(int paramInt);

    public abstract boolean n();

    public abstract boolean o();

    public abstract boolean p();

    public abstract boolean q();

    public abstract List<j.G> r();

    public abstract List<? extends j.H> s();

    public abstract int t();
  }

  public static final class w extends p
    implements j.x
  {
    public static B<w> a = new c()
    {
      public j.w c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.w(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = 4;
    private static final w f = new w(true);
    private static final long p;
    private final P g;
    private int h;
    private Object i;
    private Object j;
    private Object k;
    private j.y l;
    private byte n = -1;
    private int o = -1;

    static
    {
      f.C();
    }

    // ERROR //
    private w(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 57	com/umeng/message/proguard/p:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 59	com/umeng/message/proguard/j$w:n	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 61	com/umeng/message/proguard/j$w:o	I
      //   14: aload_0
      //   15: invokespecial 51	com/umeng/message/proguard/j$w:C	()V
      //   18: invokestatic 66	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   21: astore_3
      //   22: iconst_0
      //   23: istore 4
      //   25: iload 4
      //   27: ifne +277 -> 304
      //   30: aload_1
      //   31: invokevirtual 71	com/umeng/message/proguard/h:a	()I
      //   34: istore 8
      //   36: iload 8
      //   38: lookupswitch	default:+50->88, 0:+296->334, 10:+68->106, 18:+93->131, 26:+118->156, 34:+143->181
      //   89: aload_1
      //   90: aload_3
      //   91: aload_2
      //   92: iload 8
      //   94: invokevirtual 74	com/umeng/message/proguard/j$w:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   97: ifne +226 -> 323
      //   100: iconst_1
      //   101: istore 11
      //   103: goto +224 -> 327
      //   106: aload_0
      //   107: iconst_1
      //   108: aload_0
      //   109: getfield 76	com/umeng/message/proguard/j$w:h	I
      //   112: ior
      //   113: putfield 76	com/umeng/message/proguard/j$w:h	I
      //   116: aload_0
      //   117: aload_1
      //   118: invokevirtual 79	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   121: putfield 81	com/umeng/message/proguard/j$w:i	Ljava/lang/Object;
      //   124: iload 4
      //   126: istore 11
      //   128: goto +199 -> 327
      //   131: aload_0
      //   132: iconst_2
      //   133: aload_0
      //   134: getfield 76	com/umeng/message/proguard/j$w:h	I
      //   137: ior
      //   138: putfield 76	com/umeng/message/proguard/j$w:h	I
      //   141: aload_0
      //   142: aload_1
      //   143: invokevirtual 79	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   146: putfield 83	com/umeng/message/proguard/j$w:j	Ljava/lang/Object;
      //   149: iload 4
      //   151: istore 11
      //   153: goto +174 -> 327
      //   156: aload_0
      //   157: iconst_4
      //   158: aload_0
      //   159: getfield 76	com/umeng/message/proguard/j$w:h	I
      //   162: ior
      //   163: putfield 76	com/umeng/message/proguard/j$w:h	I
      //   166: aload_0
      //   167: aload_1
      //   168: invokevirtual 79	com/umeng/message/proguard/h:l	()Lcom/umeng/message/proguard/g;
      //   171: putfield 85	com/umeng/message/proguard/j$w:k	Ljava/lang/Object;
      //   174: iload 4
      //   176: istore 11
      //   178: goto +149 -> 327
      //   181: bipush 8
      //   183: aload_0
      //   184: getfield 76	com/umeng/message/proguard/j$w:h	I
      //   187: iand
      //   188: bipush 8
      //   190: if_icmpne +127 -> 317
      //   193: aload_0
      //   194: getfield 87	com/umeng/message/proguard/j$w:l	Lcom/umeng/message/proguard/j$y;
      //   197: invokevirtual 93	com/umeng/message/proguard/j$y:s	()Lcom/umeng/message/proguard/j$y$a;
      //   200: astore 9
      //   202: aload_0
      //   203: aload_1
      //   204: getstatic 94	com/umeng/message/proguard/j$y:a	Lcom/umeng/message/proguard/B;
      //   207: aload_2
      //   208: invokevirtual 97	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   211: checkcast 89	com/umeng/message/proguard/j$y
      //   214: putfield 87	com/umeng/message/proguard/j$w:l	Lcom/umeng/message/proguard/j$y;
      //   217: aload 9
      //   219: ifnull +22 -> 241
      //   222: aload 9
      //   224: aload_0
      //   225: getfield 87	com/umeng/message/proguard/j$w:l	Lcom/umeng/message/proguard/j$y;
      //   228: invokevirtual 102	com/umeng/message/proguard/j$y$a:a	(Lcom/umeng/message/proguard/j$y;)Lcom/umeng/message/proguard/j$y$a;
      //   231: pop
      //   232: aload_0
      //   233: aload 9
      //   235: invokevirtual 106	com/umeng/message/proguard/j$y$a:t	()Lcom/umeng/message/proguard/j$y;
      //   238: putfield 87	com/umeng/message/proguard/j$w:l	Lcom/umeng/message/proguard/j$y;
      //   241: aload_0
      //   242: bipush 8
      //   244: aload_0
      //   245: getfield 76	com/umeng/message/proguard/j$w:h	I
      //   248: ior
      //   249: putfield 76	com/umeng/message/proguard/j$w:h	I
      //   252: iload 4
      //   254: istore 11
      //   256: goto +71 -> 327
      //   259: astore 7
      //   261: aload 7
      //   263: aload_0
      //   264: invokevirtual 109	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   267: athrow
      //   268: astore 6
      //   270: aload_0
      //   271: aload_3
      //   272: invokevirtual 114	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   275: putfield 116	com/umeng/message/proguard/j$w:g	Lcom/umeng/message/proguard/P;
      //   278: aload_0
      //   279: invokevirtual 119	com/umeng/message/proguard/j$w:ad	()V
      //   282: aload 6
      //   284: athrow
      //   285: astore 5
      //   287: new 54	com/umeng/message/proguard/s
      //   290: dup
      //   291: aload 5
      //   293: invokevirtual 123	java/io/IOException:getMessage	()Ljava/lang/String;
      //   296: invokespecial 126	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   299: aload_0
      //   300: invokevirtual 109	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   303: athrow
      //   304: aload_0
      //   305: aload_3
      //   306: invokevirtual 114	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   309: putfield 116	com/umeng/message/proguard/j$w:g	Lcom/umeng/message/proguard/P;
      //   312: aload_0
      //   313: invokevirtual 119	com/umeng/message/proguard/j$w:ad	()V
      //   316: return
      //   317: aconst_null
      //   318: astore 9
      //   320: goto -118 -> 202
      //   323: iload 4
      //   325: istore 11
      //   327: iload 11
      //   329: istore 4
      //   331: goto -306 -> 25
      //   334: iconst_1
      //   335: istore 11
      //   337: goto -10 -> 327
      //
      // Exception table:
      //   from	to	target	type
      //   30	36	259	com/umeng/message/proguard/s
      //   88	100	259	com/umeng/message/proguard/s
      //   106	124	259	com/umeng/message/proguard/s
      //   131	149	259	com/umeng/message/proguard/s
      //   156	174	259	com/umeng/message/proguard/s
      //   181	202	259	com/umeng/message/proguard/s
      //   202	217	259	com/umeng/message/proguard/s
      //   222	241	259	com/umeng/message/proguard/s
      //   241	252	259	com/umeng/message/proguard/s
      //   30	36	268	finally
      //   88	100	268	finally
      //   106	124	268	finally
      //   131	149	268	finally
      //   156	174	268	finally
      //   181	202	268	finally
      //   202	217	268	finally
      //   222	241	268	finally
      //   241	252	268	finally
      //   261	268	268	finally
      //   287	304	268	finally
      //   30	36	285	java/io/IOException
      //   88	100	285	java/io/IOException
      //   106	124	285	java/io/IOException
      //   131	149	285	java/io/IOException
      //   156	174	285	java/io/IOException
      //   181	202	285	java/io/IOException
      //   202	217	285	java/io/IOException
      //   222	241	285	java/io/IOException
      //   241	252	285	java/io/IOException
    }

    private w(p.a<?> parama)
    {
      super();
      this.g = parama.b_();
    }

    private w(boolean paramBoolean)
    {
      this.g = P.c();
    }

    private void C()
    {
      this.i = "";
      this.j = "";
      this.k = "";
      this.l = j.y.h();
    }

    public static a a(w paramw)
    {
      return z().a(paramw);
    }

    public static w a(g paramg)
      throws s
    {
      return (w)a.d(paramg);
    }

    public static w a(g paramg, n paramn)
      throws s
    {
      return (w)a.d(paramg, paramn);
    }

    public static w a(h paramh)
      throws IOException
    {
      return (w)a.d(paramh);
    }

    public static w a(h paramh, n paramn)
      throws IOException
    {
      return (w)a.b(paramh, paramn);
    }

    public static w a(InputStream paramInputStream)
      throws IOException
    {
      return (w)a.h(paramInputStream);
    }

    public static w a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (w)a.h(paramInputStream, paramn);
    }

    public static w a(byte[] paramArrayOfByte)
      throws s
    {
      return (w)a.d(paramArrayOfByte);
    }

    public static w a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (w)a.d(paramArrayOfByte, paramn);
    }

    public static w b(InputStream paramInputStream)
      throws IOException
    {
      return (w)a.f(paramInputStream);
    }

    public static w b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (w)a.f(paramInputStream, paramn);
    }

    public static w h()
    {
      return f;
    }

    public static final k.a k()
    {
      return j.r();
    }

    public static a z()
    {
      return a.I();
    }

    public a A()
    {
      return z();
    }

    public a B()
    {
      return a(this);
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      if ((0x1 & this.h) == 1)
        parami.a(1, p());
      if ((0x2 & this.h) == 2)
        parami.a(2, s());
      if ((0x4 & this.h) == 4)
        parami.a(3, v());
      if ((0x8 & this.h) == 8)
        parami.c(4, this.l);
      b_().a(parami);
    }

    public final boolean a()
    {
      int m = this.n;
      if (m != -1)
        return m == 1;
      if ((w()) && (!x().a()))
      {
        this.n = 0;
        return false;
      }
      this.n = 1;
      return true;
    }

    public final P b_()
    {
      return this.g;
    }

    public int d()
    {
      int m = this.o;
      if (m != -1)
        return m;
      int i1 = 0x1 & this.h;
      int i2 = 0;
      if (i1 == 1)
        i2 = 0 + i.c(1, p());
      if ((0x2 & this.h) == 2)
        i2 += i.c(2, s());
      if ((0x4 & this.h) == 4)
        i2 += i.c(3, v());
      if ((0x8 & this.h) == 8)
        i2 += i.g(4, this.l);
      int i3 = i2 + b_().d();
      this.o = i3;
      return i3;
    }

    public w i()
    {
      return f;
    }

    protected p.g l()
    {
      return j.s().a(w.class, a.class);
    }

    public B<w> m()
    {
      return a;
    }

    public boolean n()
    {
      return (0x1 & this.h) == 1;
    }

    public String o()
    {
      Object localObject = this.i;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.i = str;
      return str;
    }

    public g p()
    {
      Object localObject = this.i;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.i = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean q()
    {
      return (0x2 & this.h) == 2;
    }

    public String r()
    {
      Object localObject = this.j;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.j = str;
      return str;
    }

    public g s()
    {
      Object localObject = this.j;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.j = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean t()
    {
      return (0x4 & this.h) == 4;
    }

    public String u()
    {
      Object localObject = this.k;
      if ((localObject instanceof String))
        return (String)localObject;
      g localg = (g)localObject;
      String str = localg.h();
      if (localg.i())
        this.k = str;
      return str;
    }

    public g v()
    {
      Object localObject = this.k;
      if ((localObject instanceof String))
      {
        g localg = g.a((String)localObject);
        this.k = localg;
        return localg;
      }
      return (g)localObject;
    }

    public boolean w()
    {
      return (0x8 & this.h) == 8;
    }

    public j.y x()
    {
      return this.l;
    }

    public j.z y()
    {
      return this.l;
    }

    public static final class a extends p.a<a>
      implements j.x
    {
      private int a;
      private Object b = "";
      private Object c = "";
      private Object d = "";
      private j.y e = j.y.h();
      private L<j.y, j.y.a, j.z> f;

      private a()
      {
        K();
      }

      private a(p.b paramb)
      {
        super();
        K();
      }

      private void K()
      {
        if (p.m)
          M();
      }

      private static a L()
      {
        return new a();
      }

      private L<j.y, j.y.a, j.z> M()
      {
        if (this.f == null)
        {
          this.f = new L(this.e, aE(), aD());
          this.e = null;
        }
        return this.f;
      }

      public static final k.a k()
      {
        return j.r();
      }

      public j.w A()
      {
        return j.w.h();
      }

      public j.w B()
      {
        j.w localw = C();
        if (!localw.a())
          throw b(localw);
        return localw;
      }

      public j.w C()
      {
        int i = 1;
        j.w localw = new j.w(this, null);
        int j = this.a;
        if ((j & 0x1) == i);
        while (true)
        {
          j.w.a(localw, this.b);
          if ((j & 0x2) == 2)
            i |= 2;
          j.w.b(localw, this.c);
          if ((j & 0x4) == 4)
            i |= 4;
          j.w.c(localw, this.d);
          if ((j & 0x8) == 8);
          for (int k = i | 0x8; ; k = i)
          {
            if (this.f == null)
              j.w.a(localw, this.e);
            while (true)
            {
              j.w.a(localw, k);
              aB();
              return localw;
              j.w.a(localw, (j.y)this.f.d());
            }
          }
          i = 0;
        }
      }

      public a D()
      {
        this.a = (0xFFFFFFFE & this.a);
        this.b = j.w.h().o();
        aF();
        return this;
      }

      public a E()
      {
        this.a = (0xFFFFFFFD & this.a);
        this.c = j.w.h().r();
        aF();
        return this;
      }

      public a F()
      {
        this.a = (0xFFFFFFFB & this.a);
        this.d = j.w.h().u();
        aF();
        return this;
      }

      public a G()
      {
        if (this.f == null)
        {
          this.e = j.y.h();
          aF();
        }
        while (true)
        {
          this.a = (0xFFFFFFF7 & this.a);
          return this;
          this.f.g();
        }
      }

      public j.y.a H()
      {
        this.a = (0x8 | this.a);
        aF();
        return (j.y.a)M().e();
      }

      public k.a J()
      {
        return j.r();
      }

      public a a(j.w paramw)
      {
        if (paramw == j.w.h())
          return this;
        if (paramw.n())
        {
          this.a = (0x1 | this.a);
          this.b = j.w.b(paramw);
          aF();
        }
        if (paramw.q())
        {
          this.a = (0x2 | this.a);
          this.c = j.w.c(paramw);
          aF();
        }
        if (paramw.t())
        {
          this.a = (0x4 | this.a);
          this.d = j.w.d(paramw);
          aF();
        }
        if (paramw.w())
          b(paramw.x());
        d(paramw.b_());
        return this;
      }

      public a a(j.y.a parama)
      {
        if (this.f == null)
        {
          this.e = parama.s();
          aF();
        }
        while (true)
        {
          this.a = (0x8 | this.a);
          return this;
          this.f.a(parama.s());
        }
      }

      public a a(j.y paramy)
      {
        if (this.f == null)
        {
          if (paramy == null)
            throw new NullPointerException();
          this.e = paramy;
          aF();
        }
        while (true)
        {
          this.a = (0x8 | this.a);
          return this;
          this.f.a(paramy);
        }
      }

      public a a(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramString;
        aF();
        return this;
      }

      public final boolean a()
      {
        return (!w()) || (x().a());
      }

      public a b(j.y paramy)
      {
        if (this.f == null)
          if (((0x8 & this.a) == 8) && (this.e != j.y.h()))
          {
            this.e = j.y.a(this.e).a(paramy).t();
            aF();
          }
        while (true)
        {
          this.a = (0x8 | this.a);
          return this;
          this.e = paramy;
          break;
          this.f.b(paramy);
        }
      }

      public a b(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.c = paramString;
        aF();
        return this;
      }

      public a c(String paramString)
      {
        if (paramString == null)
          throw new NullPointerException();
        this.a = (0x4 | this.a);
        this.d = paramString;
        aF();
        return this;
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.w))
          return a((j.w)paramx);
        super.a(paramx);
        return this;
      }

      public a e(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x1 | this.a);
        this.b = paramg;
        aF();
        return this;
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.w localw3 = (j.w)j.w.a.d(paramh, paramn);
          if (localw3 != null)
            a(localw3);
          return this;
        }
        catch (s locals)
        {
          j.w localw2 = (j.w)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localw1 = localw2;
          }
          if (localw1 != null)
            a(localw1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.w localw1 = null;
        }
      }

      public a f(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x2 | this.a);
        this.c = paramg;
        aF();
        return this;
      }

      public a g(g paramg)
      {
        if (paramg == null)
          throw new NullPointerException();
        this.a = (0x4 | this.a);
        this.d = paramg;
        aF();
        return this;
      }

      protected p.g l()
      {
        return j.s().a(j.w.class, a.class);
      }

      public a m()
      {
        super.ah();
        this.b = "";
        this.a = (0xFFFFFFFE & this.a);
        this.c = "";
        this.a = (0xFFFFFFFD & this.a);
        this.d = "";
        this.a = (0xFFFFFFFB & this.a);
        if (this.f == null)
          this.e = j.y.h();
        while (true)
        {
          this.a = (0xFFFFFFF7 & this.a);
          return this;
          this.f.g();
        }
      }

      public boolean n()
      {
        return (0x1 & this.a) == 1;
      }

      public String o()
      {
        Object localObject = this.b;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.b = str;
          return str;
        }
        return (String)localObject;
      }

      public g p()
      {
        Object localObject = this.b;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.b = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean q()
      {
        return (0x2 & this.a) == 2;
      }

      public String r()
      {
        Object localObject = this.c;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.c = str;
          return str;
        }
        return (String)localObject;
      }

      public g s()
      {
        Object localObject = this.c;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.c = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean t()
      {
        return (0x4 & this.a) == 4;
      }

      public String u()
      {
        Object localObject = this.d;
        if (!(localObject instanceof String))
        {
          String str = ((g)localObject).h();
          this.d = str;
          return str;
        }
        return (String)localObject;
      }

      public g v()
      {
        Object localObject = this.d;
        if ((localObject instanceof String))
        {
          g localg = g.a((String)localObject);
          this.d = localg;
          return localg;
        }
        return (g)localObject;
      }

      public boolean w()
      {
        return (0x8 & this.a) == 8;
      }

      public j.y x()
      {
        if (this.f == null)
          return this.e;
        return (j.y)this.f.c();
      }

      public j.z y()
      {
        if (this.f != null)
          return (j.z)this.f.f();
        return this.e;
      }

      public a z()
      {
        return L().a(C());
      }
    }
  }

  public static abstract interface x extends A
  {
    public abstract boolean n();

    public abstract String o();

    public abstract g p();

    public abstract boolean q();

    public abstract String r();

    public abstract g s();

    public abstract boolean t();

    public abstract String u();

    public abstract g v();

    public abstract boolean w();

    public abstract j.y x();

    public abstract j.z y();
  }

  public static final class y extends p.d<y>
    implements j.z
  {
    public static B<y> a = new c()
    {
      public j.y c(h paramAnonymoush, n paramAnonymousn)
        throws s
      {
        return new j.y(paramAnonymoush, paramAnonymousn, null);
      }
    };
    public static final int b = 999;
    private static final y c = new y(true);
    private static final long h;
    private final P d;
    private List<j.G> e;
    private byte f = -1;
    private int g = -1;

    static
    {
      c.t();
    }

    // ERROR //
    private y(h paramh, n paramn)
      throws s
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 48	com/umeng/message/proguard/p$d:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 50	com/umeng/message/proguard/j$y:f	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 52	com/umeng/message/proguard/j$y:g	I
      //   16: aload_0
      //   17: invokespecial 42	com/umeng/message/proguard/j$y:t	()V
      //   20: invokestatic 57	com/umeng/message/proguard/P:b	()Lcom/umeng/message/proguard/P$a;
      //   23: astore 4
      //   25: iconst_0
      //   26: istore 5
      //   28: iload_3
      //   29: ifne +168 -> 197
      //   32: aload_1
      //   33: invokevirtual 62	com/umeng/message/proguard/h:a	()I
      //   36: istore 9
      //   38: iload 9
      //   40: lookupswitch	default:+28->68, 0:+190->230, 7994:+46->86
      //   69: aload_1
      //   70: aload 4
      //   72: aload_2
      //   73: iload 9
      //   75: invokevirtual 65	com/umeng/message/proguard/j$y:a	(Lcom/umeng/message/proguard/h;Lcom/umeng/message/proguard/P$a;Lcom/umeng/message/proguard/n;I)Z
      //   78: ifne -50 -> 28
      //   81: iconst_1
      //   82: istore_3
      //   83: goto -55 -> 28
      //   86: iload 5
      //   88: iconst_1
      //   89: iand
      //   90: iconst_1
      //   91: if_icmpeq +20 -> 111
      //   94: aload_0
      //   95: new 67	java/util/ArrayList
      //   98: dup
      //   99: invokespecial 68	java/util/ArrayList:<init>	()V
      //   102: putfield 70	com/umeng/message/proguard/j$y:e	Ljava/util/List;
      //   105: iload 5
      //   107: iconst_1
      //   108: ior
      //   109: istore 5
      //   111: aload_0
      //   112: getfield 70	com/umeng/message/proguard/j$y:e	Ljava/util/List;
      //   115: aload_1
      //   116: getstatic 73	com/umeng/message/proguard/j$G:a	Lcom/umeng/message/proguard/B;
      //   119: aload_2
      //   120: invokevirtual 76	com/umeng/message/proguard/h:a	(Lcom/umeng/message/proguard/B;Lcom/umeng/message/proguard/n;)Lcom/umeng/message/proguard/y;
      //   123: invokeinterface 82 2 0
      //   128: pop
      //   129: goto -101 -> 28
      //   132: astore 8
      //   134: aload 8
      //   136: aload_0
      //   137: invokevirtual 85	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   140: athrow
      //   141: astore 7
      //   143: iload 5
      //   145: iconst_1
      //   146: iand
      //   147: iconst_1
      //   148: if_icmpne +14 -> 162
      //   151: aload_0
      //   152: aload_0
      //   153: getfield 70	com/umeng/message/proguard/j$y:e	Ljava/util/List;
      //   156: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   159: putfield 70	com/umeng/message/proguard/j$y:e	Ljava/util/List;
      //   162: aload_0
      //   163: aload 4
      //   165: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   168: putfield 98	com/umeng/message/proguard/j$y:d	Lcom/umeng/message/proguard/P;
      //   171: aload_0
      //   172: invokevirtual 101	com/umeng/message/proguard/j$y:ad	()V
      //   175: aload 7
      //   177: athrow
      //   178: astore 6
      //   180: new 45	com/umeng/message/proguard/s
      //   183: dup
      //   184: aload 6
      //   186: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
      //   189: invokespecial 108	com/umeng/message/proguard/s:<init>	(Ljava/lang/String;)V
      //   192: aload_0
      //   193: invokevirtual 85	com/umeng/message/proguard/s:a	(Lcom/umeng/message/proguard/y;)Lcom/umeng/message/proguard/s;
      //   196: athrow
      //   197: iload 5
      //   199: iconst_1
      //   200: iand
      //   201: iconst_1
      //   202: if_icmpne +14 -> 216
      //   205: aload_0
      //   206: aload_0
      //   207: getfield 70	com/umeng/message/proguard/j$y:e	Ljava/util/List;
      //   210: invokestatic 91	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   213: putfield 70	com/umeng/message/proguard/j$y:e	Ljava/util/List;
      //   216: aload_0
      //   217: aload 4
      //   219: invokevirtual 96	com/umeng/message/proguard/P$a:b	()Lcom/umeng/message/proguard/P;
      //   222: putfield 98	com/umeng/message/proguard/j$y:d	Lcom/umeng/message/proguard/P;
      //   225: aload_0
      //   226: invokevirtual 101	com/umeng/message/proguard/j$y:ad	()V
      //   229: return
      //   230: iconst_1
      //   231: istore_3
      //   232: goto -204 -> 28
      //
      // Exception table:
      //   from	to	target	type
      //   32	38	132	com/umeng/message/proguard/s
      //   68	81	132	com/umeng/message/proguard/s
      //   94	105	132	com/umeng/message/proguard/s
      //   111	129	132	com/umeng/message/proguard/s
      //   32	38	141	finally
      //   68	81	141	finally
      //   94	105	141	finally
      //   111	129	141	finally
      //   134	141	141	finally
      //   180	197	141	finally
      //   32	38	178	java/io/IOException
      //   68	81	178	java/io/IOException
      //   94	105	178	java/io/IOException
      //   111	129	178	java/io/IOException
    }

    private y(p.c<y, ?> paramc)
    {
      super();
      this.d = paramc.b_();
    }

    private y(boolean paramBoolean)
    {
      this.d = P.c();
    }

    public static a a(y paramy)
    {
      return q().a(paramy);
    }

    public static y a(g paramg)
      throws s
    {
      return (y)a.d(paramg);
    }

    public static y a(g paramg, n paramn)
      throws s
    {
      return (y)a.d(paramg, paramn);
    }

    public static y a(h paramh)
      throws IOException
    {
      return (y)a.d(paramh);
    }

    public static y a(h paramh, n paramn)
      throws IOException
    {
      return (y)a.b(paramh, paramn);
    }

    public static y a(InputStream paramInputStream)
      throws IOException
    {
      return (y)a.h(paramInputStream);
    }

    public static y a(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (y)a.h(paramInputStream, paramn);
    }

    public static y a(byte[] paramArrayOfByte)
      throws s
    {
      return (y)a.d(paramArrayOfByte);
    }

    public static y a(byte[] paramArrayOfByte, n paramn)
      throws s
    {
      return (y)a.d(paramArrayOfByte, paramn);
    }

    public static y b(InputStream paramInputStream)
      throws IOException
    {
      return (y)a.f(paramInputStream);
    }

    public static y b(InputStream paramInputStream, n paramn)
      throws IOException
    {
      return (y)a.f(paramInputStream, paramn);
    }

    public static y h()
    {
      return c;
    }

    public static final k.a k()
    {
      return j.F();
    }

    public static a q()
    {
      return a.x();
    }

    private void t()
    {
      this.e = Collections.emptyList();
    }

    protected Object I()
      throws ObjectStreamException
    {
      return super.I();
    }

    public j.G a(int paramInt)
    {
      return (j.G)this.e.get(paramInt);
    }

    protected a a(p.b paramb)
    {
      return new a(paramb, null);
    }

    public void a(i parami)
      throws IOException
    {
      d();
      p.d.a locala = X();
      for (int i = 0; i < this.e.size(); i++)
        parami.c(999, (y)this.e.get(i));
      locala.a(536870912, parami);
      b_().a(parami);
    }

    public final boolean a()
    {
      int i = this.f;
      if (i != -1)
        return i == 1;
      for (int j = 0; j < p(); j++)
        if (!a(j).a())
        {
          this.f = 0;
          return false;
        }
      if (!W())
      {
        this.f = 0;
        return false;
      }
      this.f = 1;
      return true;
    }

    public j.H b(int paramInt)
    {
      return (j.H)this.e.get(paramInt);
    }

    public final P b_()
    {
      return this.d;
    }

    public int d()
    {
      int i = this.g;
      if (i != -1)
        return i;
      int j = 0;
      int k = 0;
      while (j < this.e.size())
      {
        k += i.g(999, (y)this.e.get(j));
        j++;
      }
      int m = k + Z() + b_().d();
      this.g = m;
      return m;
    }

    public y i()
    {
      return c;
    }

    protected p.g l()
    {
      return j.G().a(y.class, a.class);
    }

    public B<y> m()
    {
      return a;
    }

    public List<j.G> n()
    {
      return this.e;
    }

    public List<? extends j.H> o()
    {
      return this.e;
    }

    public int p()
    {
      return this.e.size();
    }

    public a r()
    {
      return q();
    }

    public a s()
    {
      return a(this);
    }

    public static final class a extends p.c<j.y, a>
      implements j.z
    {
      private int a;
      private List<j.G> b = Collections.emptyList();
      private D<j.G, j.G.a, j.H> c;

      private a()
      {
        y();
      }

      private a(p.b paramb)
      {
        super();
        y();
      }

      private void C()
      {
        if ((0x1 & this.a) != 1)
        {
          this.b = new ArrayList(this.b);
          this.a = (0x1 | this.a);
        }
      }

      private D<j.G, j.G.a, j.H> D()
      {
        int i = 1;
        List localList;
        if (this.c == null)
        {
          localList = this.b;
          if ((0x1 & this.a) != i)
            break label55;
        }
        while (true)
        {
          this.c = new D(localList, i, aE(), aD());
          this.b = null;
          return this.c;
          label55: int j = 0;
        }
      }

      public static final k.a k()
      {
        return j.F();
      }

      private void y()
      {
        if (p.m)
          D();
      }

      private static a z()
      {
        return new a();
      }

      public k.a J()
      {
        return j.F();
      }

      public j.G a(int paramInt)
      {
        if (this.c == null)
          return (j.G)this.b.get(paramInt);
        return (j.G)this.c.a(paramInt);
      }

      public a a(int paramInt, j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.set(paramInt, parama.G());
          aF();
          return this;
        }
        this.c.a(paramInt, parama.G());
        return this;
      }

      public a a(int paramInt, j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.set(paramInt, paramG);
          aF();
          return this;
        }
        this.c.a(paramInt, paramG);
        return this;
      }

      public a a(j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.add(parama.G());
          aF();
          return this;
        }
        this.c.a(parama.G());
        return this;
      }

      public a a(j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.add(paramG);
          aF();
          return this;
        }
        this.c.a(paramG);
        return this;
      }

      public a a(j.y paramy)
      {
        if (paramy == j.y.h())
          return this;
        if (this.c == null)
          if (!j.y.b(paramy).isEmpty())
          {
            if (!this.b.isEmpty())
              break label79;
            this.b = j.y.b(paramy);
            this.a = (0xFFFFFFFE & this.a);
            aF();
          }
        while (true)
        {
          a(paramy);
          d(paramy.b_());
          return this;
          label79: C();
          this.b.addAll(j.y.b(paramy));
          break;
          if (!j.y.b(paramy).isEmpty())
            if (this.c.d())
            {
              this.c.b();
              this.c = null;
              this.b = j.y.b(paramy);
              this.a = (0xFFFFFFFE & this.a);
              boolean bool = p.m;
              D localD = null;
              if (bool)
                localD = D();
              this.c = localD;
            }
            else
            {
              this.c.a(j.y.b(paramy));
            }
        }
      }

      public a a(Iterable<? extends j.G> paramIterable)
      {
        if (this.c == null)
        {
          C();
          p.c.a(paramIterable, this.b);
          aF();
          return this;
        }
        this.c.a(paramIterable);
        return this;
      }

      public final boolean a()
      {
        int i = 0;
        if (i < p())
          if (a(i).a());
        while (!af())
        {
          return false;
          i++;
          break;
        }
        return true;
      }

      public j.H b(int paramInt)
      {
        if (this.c == null)
          return (j.H)this.b.get(paramInt);
        return (j.H)this.c.c(paramInt);
      }

      public a b(int paramInt, j.G.a parama)
      {
        if (this.c == null)
        {
          C();
          this.b.add(paramInt, parama.G());
          aF();
          return this;
        }
        this.c.b(paramInt, parama.G());
        return this;
      }

      public a b(int paramInt, j.G paramG)
      {
        if (this.c == null)
        {
          if (paramG == null)
            throw new NullPointerException();
          C();
          this.b.add(paramInt, paramG);
          aF();
          return this;
        }
        this.c.b(paramInt, paramG);
        return this;
      }

      public a c(int paramInt)
      {
        if (this.c == null)
        {
          C();
          this.b.remove(paramInt);
          aF();
          return this;
        }
        this.c.d(paramInt);
        return this;
      }

      public j.G.a d(int paramInt)
      {
        return (j.G.a)D().b(paramInt);
      }

      public a d(x paramx)
      {
        if ((paramx instanceof j.y))
          return a((j.y)paramx);
        super.a(paramx);
        return this;
      }

      public j.G.a e(int paramInt)
      {
        return (j.G.a)D().c(paramInt, j.G.h());
      }

      public a e(h paramh, n paramn)
        throws IOException
      {
        try
        {
          j.y localy3 = (j.y)j.y.a.d(paramh, paramn);
          if (localy3 != null)
            a(localy3);
          return this;
        }
        catch (s locals)
        {
          j.y localy2 = (j.y)locals.a();
          Object localObject1;
          try
          {
            throw locals;
          }
          finally
          {
            localy1 = localy2;
          }
          if (localy1 != null)
            a(localy1);
          throw localObject1;
        }
        finally
        {
          while (true)
            j.y localy1 = null;
        }
      }

      protected p.g l()
      {
        return j.G().a(j.y.class, a.class);
      }

      public a m()
      {
        super.B();
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          return this;
        }
        this.c.e();
        return this;
      }

      public List<j.G> n()
      {
        if (this.c == null)
          return Collections.unmodifiableList(this.b);
        return this.c.g();
      }

      public List<? extends j.H> o()
      {
        if (this.c != null)
          return this.c.i();
        return Collections.unmodifiableList(this.b);
      }

      public int p()
      {
        if (this.c == null)
          return this.b.size();
        return this.c.c();
      }

      public a q()
      {
        return z().a(t());
      }

      public j.y r()
      {
        return j.y.h();
      }

      public j.y s()
      {
        j.y localy = t();
        if (!localy.a())
          throw b(localy);
        return localy;
      }

      public j.y t()
      {
        j.y localy = new j.y(this, null);
        if (this.c == null)
        {
          if ((0x1 & this.a) == 1)
          {
            this.b = Collections.unmodifiableList(this.b);
            this.a = (0xFFFFFFFE & this.a);
          }
          j.y.a(localy, this.b);
        }
        while (true)
        {
          aB();
          return localy;
          j.y.a(localy, this.c.f());
        }
      }

      public a u()
      {
        if (this.c == null)
        {
          this.b = Collections.emptyList();
          this.a = (0xFFFFFFFE & this.a);
          aF();
          return this;
        }
        this.c.e();
        return this;
      }

      public j.G.a v()
      {
        return (j.G.a)D().b(j.G.h());
      }

      public List<j.G.a> w()
      {
        return D().h();
      }
    }
  }

  public static abstract interface z extends p.e<j.y>
  {
    public abstract j.G a(int paramInt);

    public abstract j.H b(int paramInt);

    public abstract List<j.G> n();

    public abstract List<? extends j.H> o();

    public abstract int p();
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.message.proguard.j
 * JD-Core Version:    0.6.2
 */