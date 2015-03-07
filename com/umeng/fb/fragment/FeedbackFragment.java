package com.umeng.fb.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.SyncListener;
import com.umeng.fb.audio.AudioAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.Store;
import com.umeng.fb.model.UserInfo;
import com.umeng.fb.opus.OpusTool;
import com.umeng.fb.push.FeedbackPush;
import com.umeng.fb.push.c.a;
import com.umeng.fb.res.d;
import com.umeng.fb.res.e;
import com.umeng.fb.res.f;
import com.umeng.fb.res.g;
import com.umeng.fb.res.h;
import com.umeng.fb.util.Log;
import com.umeng.fb.widget.InterceptTouchSwipeRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class FeedbackFragment extends Fragment
  implements SwipeRefreshLayout.OnRefreshListener, View.OnTouchListener
{
  private static final int A = 2;
  private static final int B = 3;
  public static final String BUNDLE_KEY_CONVERSATION_ID = "conversation_id";
  private static final int C = 4;
  private static final int D = 5;
  private static final int E = 1000;
  private static final int F = 51000;
  private static final int G = 300;
  private static final int H = 1000;
  public static final int HANDLE_MASSAGE_TYPE_REFRESH_START = 0;
  private static final float I = 0.5F;
  private static Handler S;
  private static final String a = FeedbackFragment.class.getName();
  private static final int r = 0;
  private static final int s = 1;
  private static final int t = 2;
  private static final int v = 0;
  private static final int w = 1;
  private static final int x = 2;
  private static final int y = 3;
  private static final int z = 1;
  private String J;
  private Context K;
  private List<Map<String, String>> L;
  private AudioAgent M;
  private Timer N;
  private String O;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = false;
  private Dialog T;
  private View U;
  private TextView V;
  private TextView W;
  private Button b;
  private Button c;
  private EditText d;
  private TextView e;
  private TextView f;
  private TextView g;
  private InterceptTouchSwipeRefreshLayout h;
  private ListView i;
  private Spinner j;
  private com.umeng.fb.adapter.a k;
  private FeedbackAgent l;
  private Conversation m;
  private FeedbackPush n;
  private View o;
  private String[] p;
  private String[] q;
  private int u = 1;

  private String a(String paramString)
  {
    UserInfo localUserInfo = this.l.getUserInfo();
    Map localMap;
    Object localObject1;
    String str;
    if (localUserInfo != null)
    {
      localMap = localUserInfo.getContact();
      if (localMap != null)
      {
        localObject1 = "";
        if (paramString == null)
        {
          Iterator localIterator = localMap.keySet().iterator();
          if (localIterator.hasNext())
          {
            str = (String)localIterator.next();
            if ((localMap.get(str) == null) || (d(str) == null))
              break label172;
          }
        }
      }
    }
    label172: for (Object localObject2 = (String)localObject1 + d(str) + ": " + (String)localMap.get(str) + "\t"; ; localObject2 = localObject1)
    {
      localObject1 = localObject2;
      break;
      if ("".equals(localObject1))
        localObject1 = null;
      return localObject1;
      return (String)localMap.get(paramString);
      return null;
      return null;
    }
  }

  private void a(final int paramInt)
  {
    if (2 == paramInt);
    for (int i1 = 300; ; i1 = 1000)
    {
      new Timer().schedule(new TimerTask()
      {
        public void run()
        {
          FeedbackFragment.a(FeedbackFragment.this, paramInt);
        }
      }
      , i1);
      return;
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    S.sendMessage(localMessage);
  }

  private void a(final int paramInt, final View paramView)
  {
    this.u = paramInt;
    if (paramInt == 0)
    {
      View localView3 = View.inflate(getActivity(), f.g(this.K), null);
      this.j = ((Spinner)localView3.findViewById(e.l(this.K)));
      ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(getActivity(), com.umeng.fb.res.b.a(this.K), f.h(this.K));
      localArrayAdapter.setDropDownViewResource(17367049);
      this.j.setAdapter(localArrayAdapter);
      ((ViewGroup)paramView).removeAllViews();
      ((ViewGroup)paramView).addView(localView3);
      this.d = ((EditText)paramView.findViewById(e.n(this.K)));
      this.b = ((Button)paramView.findViewById(e.m(this.K)));
      if ((paramInt != 0) || (this.j == null))
        break label447;
      if (this.L == null)
        this.L = new ArrayList();
      this.d.requestFocus();
      this.j.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          switch (paramAnonymousInt)
          {
          default:
          case 0:
          case 1:
          case 2:
          case 3:
          }
          while (true)
          {
            FeedbackFragment.l(FeedbackFragment.this).setText(FeedbackFragment.a(FeedbackFragment.this, FeedbackFragment.m(FeedbackFragment.this)[paramAnonymousInt]));
            FeedbackFragment.l(FeedbackFragment.this).requestFocus();
            return;
            FeedbackFragment.l(FeedbackFragment.this).setInputType(33);
            continue;
            FeedbackFragment.l(FeedbackFragment.this).setInputType(2);
            continue;
            FeedbackFragment.l(FeedbackFragment.this).setInputType(3);
            continue;
            FeedbackFragment.l(FeedbackFragment.this).setInputType(131073);
          }
        }

        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
        {
          FeedbackFragment.l(FeedbackFragment.this).setInputType(131073);
        }
      });
      this.j.setSelection(d());
    }
    while (true)
    {
      if ((paramInt != 2) && (this.d != null))
      {
        c();
        this.b.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            String str = FeedbackFragment.l(FeedbackFragment.this).getEditableText().toString().trim();
            FeedbackFragment.l(FeedbackFragment.this).getEditableText().clear();
            if (paramInt == 0)
            {
              FeedbackFragment.b(FeedbackFragment.this, str);
              FeedbackFragment.a(FeedbackFragment.this, 1, paramView);
            }
            while (paramInt != 1)
              return;
            FeedbackFragment.n(FeedbackFragment.this).addUserReply(str);
            FeedbackFragment.this.a();
            FeedbackFragment.this.refresh();
          }
        });
      }
      return;
      if (paramInt == 1)
      {
        View localView2 = View.inflate(getActivity(), f.i(this.K), null);
        ((ViewGroup)paramView).removeAllViews();
        ((ViewGroup)paramView).addView(localView2);
        this.d = ((EditText)paramView.findViewById(e.n(this.K)));
        ImageButton localImageButton = (ImageButton)paramView.findViewById(e.r(this.K));
        if (!OpusTool.a())
          localImageButton.setVisibility(8);
        localImageButton.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            FeedbackFragment.a(FeedbackFragment.this, 2, FeedbackFragment.k(FeedbackFragment.this));
          }
        });
        break;
      }
      if (paramInt != 2)
        break;
      if (this.M == null)
        this.M = AudioAgent.getInstance(this.K);
      j();
      View localView1 = View.inflate(getActivity(), f.j(this.K), null);
      ((ViewGroup)paramView).removeAllViews();
      ((ViewGroup)paramView).addView(localView1);
      ((ImageButton)paramView.findViewById(e.s(this.K))).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedbackFragment.a(FeedbackFragment.this, 1, FeedbackFragment.k(FeedbackFragment.this));
        }
      });
      this.c = ((Button)paramView.findViewById(e.t(this.K)));
      this.c.setOnTouchListener(this);
      break;
      label447: this.d.setInputType(131073);
    }
  }

  private void a(Button paramButton, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return;
    case 0:
      paramButton.setText(g.t(this.K));
      paramButton.setBackgroundDrawable(getResources().getDrawable(com.umeng.fb.res.c.a(this.K)));
      paramButton.setTextColor(getResources().getColor(17170443));
      return;
    case 1:
      paramButton.setText(g.s(this.K));
      paramButton.setBackgroundDrawable(getResources().getDrawable(com.umeng.fb.res.c.c(this.K)));
      paramButton.setTextColor(getResources().getColor(17170444));
      return;
    case 2:
      paramButton.setEnabled(true);
      paramButton.setTextColor(getResources().getColor(17170444));
      return;
    case 3:
    }
    paramButton.setEnabled(false);
    paramButton.setTextColor(getResources().getColor(com.umeng.fb.res.c.c(this.K)));
  }

  private void a(DialogStatus paramDialogStatus)
  {
    switch (13.a[paramDialogStatus.ordinal()])
    {
    default:
      return;
    case 1:
      this.U.setVisibility(0);
      this.V.setVisibility(8);
      this.U.setBackgroundDrawable(getResources().getDrawable(d.b(this.K)));
      this.W.setText(getResources().getString(g.v(this.K)));
      return;
    case 2:
      this.U.setBackgroundDrawable(getResources().getDrawable(d.c(this.K)));
      this.W.setText(getResources().getString(g.u(this.K)));
      return;
    case 3:
      this.U.setVisibility(8);
      this.V.setVisibility(0);
      this.W.setText(getResources().getString(g.w(this.K)));
      return;
    case 4:
      this.W.setText(getResources().getString(g.x(this.K)));
      return;
    case 5:
      this.W.setText(g.y(this.K));
      return;
    case 6:
    }
    this.W.setText(g.z(this.K));
  }

  private void b()
  {
    S = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 1:
        case 0:
        case 3:
        case 4:
        case 5:
        case 2:
        }
        do
        {
          return;
          FeedbackFragment.a(FeedbackFragment.this).setRefreshing(false);
          return;
          FeedbackFragment.this.refresh();
          return;
          FeedbackFragment.b(FeedbackFragment.this);
          return;
          FeedbackFragment.c(FeedbackFragment.this).setVisibility(8);
          FeedbackFragment.d(FeedbackFragment.this).setVisibility(0);
          FeedbackFragment.d(FeedbackFragment.this).setText("" + paramAnonymousMessage.arg1);
          FeedbackFragment.f(FeedbackFragment.this).setText(FeedbackFragment.this.getResources().getString(g.w(FeedbackFragment.e(FeedbackFragment.this))));
          return;
          FeedbackFragment.g(FeedbackFragment.this);
          return;
        }
        while (FeedbackFragment.h(FeedbackFragment.this));
        FeedbackFragment.i(FeedbackFragment.this);
        FeedbackFragment.a(FeedbackFragment.this, true);
      }
    };
  }

  private void b(int paramInt)
  {
    Message localMessage = Message.obtain();
    localMessage.what = paramInt;
    S.sendMessage(localMessage);
  }

  private void b(String paramString)
  {
    if (paramString != null)
    {
      this.e.setText(paramString);
      this.f.setText(getResources().getString(g.j(this.K)));
      return;
    }
    this.e.setText(getResources().getString(g.k(this.K)));
    this.f.setText(getResources().getString(g.l(this.K)));
  }

  private void c()
  {
    if (TextUtils.isEmpty(this.d.getText().toString()))
      a(this.b, 3);
    this.d.addTextChangedListener(new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        if (!TextUtils.isEmpty(FeedbackFragment.l(FeedbackFragment.this).getText().toString()))
        {
          FeedbackFragment.a(FeedbackFragment.this, FeedbackFragment.o(FeedbackFragment.this), 2);
          return;
        }
        FeedbackFragment.a(FeedbackFragment.this, FeedbackFragment.o(FeedbackFragment.this), 3);
      }

      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }

      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
      }
    });
  }

  private void c(String paramString)
  {
    String str = this.p[this.j.getSelectedItemPosition()];
    if (paramString.equals(a(str)))
      return;
    UserInfo localUserInfo = this.l.getUserInfo();
    if (localUserInfo == null)
      localUserInfo = new UserInfo();
    Object localObject = localUserInfo.getContact();
    if (localObject == null)
      localObject = new HashMap();
    ((Map)localObject).put(str, paramString);
    localUserInfo.setContact((Map)localObject);
    this.l.setUserInfo(localUserInfo);
    b(a(null));
    new Thread(new Runnable()
    {
      public void run()
      {
        new com.umeng.fb.net.a(FeedbackFragment.this.getActivity()).a(Store.getInstance(FeedbackFragment.this.getActivity()).getUserInfo().toJson());
      }
    }).start();
  }

  private int d()
  {
    for (int i1 = 0; i1 < this.p.length; i1++)
      if (a(this.p[i1]) != null)
        return i1;
    return 0;
  }

  private String d(String paramString)
  {
    for (int i1 = 0; i1 < this.p.length; i1++)
      if (this.p[i1].endsWith(paramString))
        return this.q[i1];
    return null;
  }

  private void e()
  {
    a(DialogStatus.SlideUpCancel);
    this.J = l();
    this.T.show();
    this.P = false;
    this.Q = false;
    f();
    if (!m())
    {
      a(DialogStatus.NoRecordPermission);
      a(5);
      return;
    }
    if (!this.M.recordStart(this.J))
    {
      a(DialogStatus.AudioRecordErr);
      a(5);
      return;
    }
    k();
  }

  private void f()
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    com.umeng.fb.adapter.a.a().sendMessage(localMessage);
  }

  private void g()
  {
    this.R = true;
    if (this.N != null)
      this.N.cancel();
    if ((this.M == null) || (!this.M.getAudioInitStatus()))
      h();
    do
    {
      return;
      if ((this.O != null) && (this.O.equals(this.J)))
      {
        h();
        return;
      }
      if (this.Q)
      {
        h();
        this.M.recordShortStop();
        com.umeng.fb.util.c.a(this.K, this.J);
        return;
      }
      if (this.M.getAudioDuration() < 0.5F)
      {
        a(DialogStatus.TimeShort);
        this.M.recordShortStop();
        a(5);
        return;
      }
      if (!this.M.getRecordStatus())
        break;
      h();
    }
    while (this.M.recordStop() <= 0);
    this.m.addUserReply("voice", this.J, "audio_reply", this.M.getAudioDuration());
    this.O = this.J;
    a();
    return;
    h();
  }

  public static Handler getHandler()
  {
    return S;
  }

  private void h()
  {
    if (this.T.isShowing())
      this.T.dismiss();
    a(this.c, 1);
  }

  private void i()
  {
    this.T = new Dialog(this.K, h.a(this.K));
    this.T.requestWindowFeature(1);
    this.T.getWindow().setFlags(1024, 1024);
    this.T.setContentView(f.k(this.K));
    this.T.setCanceledOnTouchOutside(true);
    this.U = this.T.findViewById(e.u(this.K));
    this.V = ((TextView)this.T.findViewById(e.w(this.K)));
    this.W = ((TextView)this.T.findViewById(e.v(this.K)));
  }

  private void j()
  {
    ((InputMethodManager)this.K.getSystemService("input_method")).hideSoftInputFromWindow(this.d.getWindowToken(), 2);
  }

  private void k()
  {
    if (this.N != null)
      this.N.cancel();
    this.N = new Timer();
    this.N.schedule(new TimerTask()
    {
      int a = 10;

      public void run()
      {
        FeedbackFragment.b(FeedbackFragment.this, true);
        if (FeedbackFragment.q(FeedbackFragment.this).isShowing())
        {
          if (this.a > 0)
          {
            FeedbackFragment.a(FeedbackFragment.this, 4, this.a);
            this.a = (-1 + this.a);
          }
        }
        else
          return;
        FeedbackFragment.a(FeedbackFragment.this, 3);
        FeedbackFragment.c(FeedbackFragment.this, false);
        cancel();
      }
    }
    , 51000L, 1000L);
  }

  private String l()
  {
    return "R" + UUID.randomUUID().toString();
  }

  private boolean m()
  {
    return com.umeng.fb.util.b.a(this.K, "android.permission.RECORD_AUDIO");
  }

  public static FeedbackFragment newInstance(String paramString)
  {
    Log.c(a, String.format("newInstance(id=%s)", new Object[] { paramString }));
    FeedbackFragment localFeedbackFragment = new FeedbackFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("conversation_id", paramString);
    localFeedbackFragment.setArguments(localBundle);
    return localFeedbackFragment;
  }

  void a()
  {
    if (this.k.getCount() > 0)
      this.i.smoothScrollToPosition(this.k.getCount());
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.K = getActivity();
    i();
    b();
    Log.c(a, String.format("onCreateView(savedInstanceState=%s)", new Object[] { paramBundle }));
    this.p = getResources().getStringArray(com.umeng.fb.res.b.b(this.K));
    this.q = getResources().getStringArray(com.umeng.fb.res.b.a(this.K));
    View localView1 = paramLayoutInflater.inflate(f.d(this.K), null, false);
    this.l = new FeedbackAgent(getActivity());
    this.n = FeedbackPush.getInstance(getActivity());
    this.n.setFBPushCallbacks(new FeedbackPushCallbacks());
    String str = getArguments().getString("conversation_id");
    this.n.setConversationId(str);
    if (TextUtils.isEmpty(str))
      return localView1;
    this.m = this.l.getConversationById(str);
    this.n.clearPushInfo();
    if (this.m == null)
      return localView1;
    this.i = ((ListView)localView1.findViewById(e.a(this.K)));
    this.o = localView1.findViewById(e.g(this.K));
    View localView2 = paramLayoutInflater.inflate(f.e(this.K), null, false);
    View localView3 = localView2.findViewById(e.h(this.K));
    this.f = ((TextView)localView3.findViewById(e.b(this.K)));
    this.e = ((TextView)localView3.findViewById(e.e(this.K)));
    b(a(null));
    this.f.setTextColor(getResources().getColor(com.umeng.fb.res.c.a(this.K)));
    localView2.findViewById(e.i(this.K)).setBackgroundColor(getResources().getColor(com.umeng.fb.res.c.a(this.K)));
    localView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (FeedbackFragment.j(FeedbackFragment.this) != 0)
          FeedbackFragment.a(FeedbackFragment.this, 0, FeedbackFragment.k(FeedbackFragment.this));
      }
    });
    this.i.setHeaderDividersEnabled(true);
    this.i.addHeaderView(localView2);
    if (com.umeng.fb.common.b.a(this.K).b())
    {
      View localView4 = paramLayoutInflater.inflate(f.f(this.K), null, false);
      this.g = ((TextView)localView4.findViewById(e.j(this.K)));
      if (com.umeng.fb.common.b.a(this.K).c() != null)
        this.g.setText(com.umeng.fb.common.b.a(this.K).c());
      this.i.addHeaderView(localView4);
    }
    this.k = new com.umeng.fb.adapter.a(getActivity(), this.m);
    this.i.setAdapter(this.k);
    this.h = ((InterceptTouchSwipeRefreshLayout)localView1.findViewById(e.k(this.K)));
    this.h.setOnRefreshListener(this);
    InterceptTouchSwipeRefreshLayout localInterceptTouchSwipeRefreshLayout = this.h;
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = com.umeng.fb.res.c.a(this.K);
    arrayOfInt[1] = com.umeng.fb.res.c.b(this.K);
    arrayOfInt[2] = com.umeng.fb.res.c.a(this.K);
    arrayOfInt[3] = com.umeng.fb.res.c.b(this.K);
    localInterceptTouchSwipeRefreshLayout.setColorSchemeResources(arrayOfInt);
    this.h.setInterceptTouch(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((FeedbackFragment.j(FeedbackFragment.this) != 1) && (paramAnonymousMotionEvent.getAction() == 1))
          FeedbackFragment.a(FeedbackFragment.this, 1, FeedbackFragment.k(FeedbackFragment.this));
        paramAnonymousView.performClick();
        return false;
      }
    });
    a(1, this.o);
    refresh();
    return localView1;
  }

  public void onDestroy()
  {
    super.onDestroy();
    com.umeng.fb.util.c.a(this.K);
  }

  public void onPause()
  {
    super.onPause();
    this.n.setFbFragmentTag(false);
    if (this.N != null)
      this.N.cancel();
    f();
  }

  public void onRefresh()
  {
    Log.c(a, "onRefreshonRefresh");
    refresh();
  }

  public void onResume()
  {
    super.onResume();
    this.n.setFbFragmentTag(true);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    case 2:
      float f1;
      do
      {
        return false;
        paramMotionEvent.getY();
        this.R = false;
        a(this.c, 0);
        a(2);
        return false;
        a(this.c, 1);
        if (this.R)
        {
          g();
          return false;
        }
        this.R = true;
        return false;
        f1 = paramMotionEvent.getY();
      }
      while (!this.R);
      if (0.0F - f1 > 80.0F)
      {
        a(DialogStatus.ReleaseCancel);
        this.Q = true;
        return false;
      }
      if (!this.P)
        a(DialogStatus.SlideUpCancel);
      this.Q = false;
      return false;
    case 3:
    }
    a(this.c, 1);
    if (this.R)
    {
      g();
      return false;
    }
    this.R = true;
    return false;
  }

  public void refresh()
  {
    SyncListener local9 = new SyncListener()
    {
      public void onReceiveDevReply(List<Reply> paramAnonymousList)
      {
        FeedbackFragment.a(FeedbackFragment.this, 1);
        FeedbackFragment.this.a();
      }

      public void onSendUserReply(List<Reply> paramAnonymousList)
      {
      }
    };
    this.m.sync(local9);
  }

  private static enum DialogStatus
  {
    static
    {
      ReleaseCancel = new DialogStatus("ReleaseCancel", 1);
      CuntDown = new DialogStatus("CuntDown", 2);
      TimeShort = new DialogStatus("TimeShort", 3);
      NoRecordPermission = new DialogStatus("NoRecordPermission", 4);
      AudioRecordErr = new DialogStatus("AudioRecordErr", 5);
      DialogStatus[] arrayOfDialogStatus = new DialogStatus[6];
      arrayOfDialogStatus[0] = SlideUpCancel;
      arrayOfDialogStatus[1] = ReleaseCancel;
      arrayOfDialogStatus[2] = CuntDown;
      arrayOfDialogStatus[3] = TimeShort;
      arrayOfDialogStatus[4] = NoRecordPermission;
      arrayOfDialogStatus[5] = AudioRecordErr;
    }
  }

  class FeedbackPushCallbacks
    implements c.a
  {
    FeedbackPushCallbacks()
    {
    }

    public void onAddPushDevReply()
    {
      FeedbackFragment.a(FeedbackFragment.this, 0);
      FeedbackFragment.p(FeedbackFragment.this).clearPushInfo();
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.fragment.FeedbackFragment
 * JD-Core Version:    0.6.2
 */