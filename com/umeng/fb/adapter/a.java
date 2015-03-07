package com.umeng.fb.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.umeng.fb.audio.AudioAgent;
import com.umeng.fb.common.b;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Conversation.OnChangeListener;
import com.umeng.fb.model.Reply;
import com.umeng.fb.res.c;
import com.umeng.fb.res.d;
import com.umeng.fb.res.e;
import com.umeng.fb.res.f;
import com.umeng.fb.res.g;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class a extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  private static Handler l;
  private final String c = a.class.getName();
  private LayoutInflater d;
  private AnimationDrawable e;
  private Conversation f;
  private Context g;
  private AudioAgent h;
  private final int i = 2;
  private final int j = 0;
  private final int k = 1;

  public a(Context paramContext, Conversation paramConversation)
  {
    this.g = paramContext;
    this.d = LayoutInflater.from(this.g);
    b();
    this.f = paramConversation;
    this.f.setOnChangeListener(new Conversation.OnChangeListener()
    {
      public void onChange()
      {
        a.this.notifyDataSetChanged();
      }
    });
  }

  private int a(Context paramContext, int paramInt)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int m = localDisplayMetrics.widthPixels;
    int n = 100 + paramInt * m / 80;
    if (n > 0.7D * m)
      n = (int)(0.7D * m);
    return n;
  }

  public static Handler a()
  {
    return l;
  }

  private String a(long paramLong)
  {
    Date localDate1 = new Date();
    Date localDate2 = new Date(paramLong);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(localDate1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(localDate2);
    if (localCalendar1.get(1) == localCalendar2.get(1));
    long l1;
    for (int m = 1; ; m = 0)
    {
      l1 = TimeUnit.MILLISECONDS.toMinutes(localDate1.getTime() - paramLong);
      if (l1 >= 1L)
        break;
      return this.g.getResources().getString(g.f(this.g));
    }
    if (l1 < 30L)
    {
      String str = this.g.getResources().getString(g.g(this.g));
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(l1);
      return String.format(str, arrayOfObject);
    }
    if (m != 0)
      return new SimpleDateFormat(this.g.getResources().getString(g.h(this.g)), Locale.CHINA).format(localDate2);
    return new SimpleDateFormat(this.g.getResources().getString(g.i(this.g)), Locale.CHINA).format(localDate2);
  }

  private void a(View paramView, a parama)
  {
    a(paramView, parama);
    parama.a = paramView.findViewById(e.x(this.g));
    parama.b = paramView.findViewById(e.y(this.g));
    parama.c = ((TextView)paramView.findViewById(e.z(this.g)));
  }

  private void a(View paramView, b paramb)
  {
    paramb.e = ((TextView)paramView.findViewById(e.e(this.g)));
    paramb.g = paramView.findViewById(e.i(this.g));
    paramb.f = paramView.findViewById(e.o(this.g));
    paramb.h = ((ImageView)paramView.findViewById(e.p(this.g)));
  }

  private void a(View paramView, c paramc)
  {
    a(paramView, paramc);
    paramc.a = ((TextView)paramView.findViewById(e.b(this.g)));
  }

  private void a(final Reply paramReply, final a parama)
  {
    a(paramReply, parama);
    parama.c.setText((int)paramReply.audio_duration + "\"");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(a(this.g, (int)paramReply.audio_duration), -2);
    parama.a.setLayoutParams(localLayoutParams);
    if (!b.a(this.g).d())
      return;
    parama.a.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (a.c(a.this) == null)
          a.a(a.this, AudioAgent.getInstance(a.d(a.this)));
        a.b(a.this);
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)parama.b.getBackground();
        if (a.c(a.this).getPlayStatus())
        {
          a.c(a.this).stopPlayer();
          if ((a.e(a.this) != null) && (localAnimationDrawable.equals(a.e(a.this))))
            return;
        }
        a.a(a.this, localAnimationDrawable);
        a.e(a.this).start();
        a.c(a.this).startPlay(paramReply.reply_id);
      }
    });
  }

  private void a(final Reply paramReply, b paramb)
  {
    if ("dev_reply".equals(paramReply.type))
    {
      paramb.f.setBackgroundColor(this.g.getResources().getColor(c.a(this.g)));
      paramb.e.setText(a(paramReply.created_at));
    }
    while (true)
    {
      paramb.g.setVisibility(0);
      return;
      paramb.f.setBackgroundColor(this.g.getResources().getColor(c.c(this.g)));
      if ("not_sent".equals(paramReply.status))
      {
        paramb.e.setText(g.d(this.g));
        paramb.h.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            a.a(a.this).sendReplyOnlyOne(a.a(a.this).getId(), paramReply);
          }
        });
        paramb.h.setImageResource(d.a(this.g));
        paramb.h.setAnimation(null);
        paramb.h.setVisibility(0);
      }
      else if (("sending".equals(paramReply.status)) || ("will_sent".equals(paramReply.status)))
      {
        paramb.e.setText(g.e(this.g));
        paramb.h.setImageResource(d.a(this.g));
        paramb.h.setVisibility(0);
        RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, -360.0F, 1, 0.5F, 1, 0.5F);
        localRotateAnimation.setInterpolator(new LinearInterpolator());
        localRotateAnimation.setRepeatCount(-1);
        localRotateAnimation.setDuration(700L);
        paramb.h.startAnimation(localRotateAnimation);
        paramb.h.setOnClickListener(null);
      }
      else
      {
        paramb.e.setText(a(paramReply.created_at));
        paramb.h.setAnimation(null);
        paramb.h.setVisibility(8);
        paramb.h.setOnClickListener(null);
      }
    }
  }

  private void a(Reply paramReply, c paramc)
  {
    a(paramReply, paramc);
    paramc.a.setText(paramReply.content);
  }

  private void b()
  {
    l = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 0:
          do
          {
            return;
            a.b(a.this);
          }
          while ((a.c(a.this) == null) || (!a.c(a.this).getPlayStatus()));
          a.c(a.this).stopPlayer();
          return;
        case 1:
        }
        a.this.notifyDataSetChanged();
      }
    };
  }

  private void c()
  {
    if ((this.e != null) && (this.e.isRunning()))
    {
      this.e.stop();
      this.e.selectDrawable(0);
    }
  }

  public int getCount()
  {
    List localList = this.f.getReplyList();
    if (localList == null)
      return 0;
    return localList.size();
  }

  public Object getItem(int paramInt)
  {
    return this.f.getReplyList().get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public int getItemViewType(int paramInt)
  {
    if ("text_reply".equals(((Reply)this.f.getReplyList().get(paramInt)).content_type))
      return 0;
    return 1;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool1 = true;
    Reply localReply1 = (Reply)this.f.getReplyList().get(paramInt);
    Object localObject;
    if (paramView == null)
      if ("text_reply".equals(localReply1.content_type))
      {
        paramView = this.d.inflate(f.b(this.g), null);
        localObject = new c(null);
        paramView.setTag(localObject);
        a(paramView, (c)localObject);
      }
    while (true)
    {
      label107: int m;
      label169: boolean bool2;
      if ("text_reply".equals(localReply1.content_type))
      {
        a(localReply1, (c)localObject);
        if (paramInt + 1 < getCount())
        {
          Reply localReply2 = (Reply)this.f.getReplyList().get(paramInt + 1);
          if ((!"new_feedback".equals(localReply1.type)) || (!"user_reply".equals(localReply2.type)))
            break label303;
          m = bool1;
          bool2 = m | localReply2.type.equals(localReply1.type);
          if (paramInt + 1 != getCount())
            break label309;
        }
      }
      while (true)
      {
        if ((bool2 | bool1))
          ((b)localObject).g.setVisibility(8);
        return paramView;
        if (!"audio_reply".equals(localReply1.content_type))
          break label315;
        paramView = this.d.inflate(f.c(this.g), null);
        localObject = new a(null);
        paramView.setTag(localObject);
        a(paramView, (a)localObject);
        break;
        localObject = (b)paramView.getTag();
        break;
        a(localReply1, (a)localObject);
        break label107;
        label303: m = 0;
        break label169;
        label309: bool1 = false;
      }
      label315: localObject = null;
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  private class a extends a.b
  {
    View a;
    View b;
    TextView c;

    private a()
    {
      super(null);
    }
  }

  private class b
  {
    TextView e;
    View f;
    View g;
    ImageView h;

    private b()
    {
    }
  }

  private class c extends a.b
  {
    TextView a;

    private c()
    {
      super(null);
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.adapter.a
 * JD-Core Version:    0.6.2
 */