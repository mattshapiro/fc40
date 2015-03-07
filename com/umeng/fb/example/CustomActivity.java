package com.umeng.fb.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;
import com.allinone.free.activity.MyMainActivity;
import com.umeng.analytics.MobclickAgent;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.SyncListener;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import com.umeng.fb.model.UserInfo;
import com.umeng.message.PushAgent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomActivity extends Activity
{
  private static Typeface typeFace = null;
  private final String TAG = CustomActivity.class.getName();
  private final int VIEW_TYPE_COUNT = 2;
  private final int VIEW_TYPE_DEV = 1;
  private final int VIEW_TYPE_USER = 0;
  private ReplyAdapter adapter;
  private ImageView appfan;
  private TextView feedbacktv;
  private EditText inputEdit;
  private String jpushfan = "";
  private FeedbackAgent mAgent;
  private Conversation mComversation;
  private Context mContext;
  private ListView mListView;
  private PushAgent mPushAgent;
  private SwipeRefreshLayout mSwipeRefreshLayout;
  private Button sendBtn;

  private void initView()
  {
    this.appfan = ((ImageView)findViewById(2131230789));
    this.feedbacktv = ((TextView)findViewById(2131230790));
    typeFace = Typeface.createFromAsset(getAssets(), "font.ttf");
    this.feedbacktv.setTypeface(typeFace);
    this.appfan.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CustomActivity.this.jpushfan = CustomActivity.this.getIntent().getStringExtra("jpush");
        if (TextUtils.isEmpty(CustomActivity.this.jpushfan))
        {
          CustomActivity.this.finish();
          return;
        }
        CustomActivity.this.startActivity(new Intent(CustomActivity.this, MyMainActivity.class));
        CustomActivity.this.finish();
      }
    });
    this.mListView = ((ListView)findViewById(2131230795));
    this.sendBtn = ((Button)findViewById(2131230792));
    this.inputEdit = ((EditText)findViewById(2131230793));
    this.mSwipeRefreshLayout = ((SwipeRefreshLayout)findViewById(2131230794));
    this.sendBtn.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = CustomActivity.this.inputEdit.getText().toString();
        CustomActivity.this.inputEdit.getEditableText().clear();
        if (!TextUtils.isEmpty(str))
        {
          CustomActivity.this.mComversation.addUserReply(str);
          CustomActivity.this.adapter.notifyDataSetChanged();
          CustomActivity.this.scrollToBottom();
          CustomActivity.this.sync();
        }
      }
    });
    this.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
    {
      public void onRefresh()
      {
        CustomActivity.this.sync();
      }
    });
  }

  private void scrollToBottom()
  {
    if (this.adapter.getCount() > 0)
      this.mListView.smoothScrollToPosition(this.adapter.getCount());
  }

  private void sync()
  {
    this.mComversation.sync(new SyncListener()
    {
      public void onReceiveDevReply(List<Reply> paramAnonymousList)
      {
        CustomActivity.this.mSwipeRefreshLayout.setRefreshing(false);
        CustomActivity.this.adapter.notifyDataSetChanged();
        CustomActivity.this.scrollToBottom();
      }

      public void onSendUserReply(List<Reply> paramAnonymousList)
      {
      }
    });
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903062);
    JPushInterface.init(this);
    this.mContext = this;
    initView();
    View localView = View.inflate(this, 2130903120, null);
    this.mListView.addHeaderView(localView, null, false);
    this.mAgent = new FeedbackAgent(this);
    this.mComversation = new FeedbackAgent(this).getDefaultConversation();
    this.adapter = new ReplyAdapter();
    this.mListView.setAdapter(this.adapter);
    sync();
    this.mPushAgent = PushAgent.getInstance(this);
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(2000L);
          UserInfo localUserInfo = CustomActivity.this.mAgent.getUserInfo();
          if (localUserInfo == null)
            localUserInfo = new UserInfo();
          localUserInfo.getContact();
          HashMap localHashMap = new HashMap();
          localHashMap.put("user_id", JPushInterface.getRegistrationID(CustomActivity.this));
          localUserInfo.setContact(localHashMap);
          CustomActivity.this.mAgent.setUserInfo(localUserInfo);
          CustomActivity.this.mAgent.updateUserInfo();
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }).start();
  }

  protected void onPause()
  {
    super.onPause();
    MobclickAgent.onPause(this);
    JPushInterface.onPause(this);
  }

  protected void onResume()
  {
    super.onResume();
    MobclickAgent.onResume(this);
    JPushInterface.onResume(this);
  }

  class ReplyAdapter extends BaseAdapter
  {
    ReplyAdapter()
    {
    }

    public int getCount()
    {
      return CustomActivity.this.mComversation.getReplyList().size();
    }

    public Object getItem(int paramInt)
    {
      return CustomActivity.this.mComversation.getReplyList().get(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public int getItemViewType(int paramInt)
    {
      if ("dev_reply".equals(((Reply)CustomActivity.this.mComversation.getReplyList().get(paramInt)).type))
        return 1;
      return 0;
    }

    @SuppressLint({"SimpleDateFormat"})
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Reply localReply = (Reply)CustomActivity.this.mComversation.getReplyList().get(paramInt);
      ViewHolder localViewHolder;
      if (paramView == null)
        if ("dev_reply".equals(localReply.type))
        {
          paramView = LayoutInflater.from(CustomActivity.this.mContext).inflate(2130903080, null);
          localViewHolder = new ViewHolder();
          localViewHolder.replyContent = ((TextView)paramView.findViewById(2131230876));
          localViewHolder.replyProgressBar = ((ProgressBar)paramView.findViewById(2131230875));
          localViewHolder.replyStateFailed = ((ImageView)paramView.findViewById(2131230874));
          localViewHolder.replyData = ((TextView)paramView.findViewById(2131230877));
          paramView.setTag(localViewHolder);
          label127: localViewHolder.replyContent.setText(localReply.content);
          if (!"dev_reply".equals(localReply.type))
          {
            if (!"not_sent".equals(localReply.status))
              break label231;
            localViewHolder.replyStateFailed.setVisibility(0);
          }
        }
      while (true)
      {
        if (!"sending".equals(localReply.status))
          break label244;
        localViewHolder.replyProgressBar.setVisibility(0);
        return paramView;
        paramView = LayoutInflater.from(CustomActivity.this.mContext).inflate(2130903081, null);
        break;
        localViewHolder = (ViewHolder)paramView.getTag();
        break label127;
        label231: localViewHolder.replyStateFailed.setVisibility(8);
      }
      label244: localViewHolder.replyProgressBar.setVisibility(8);
      return paramView;
    }

    public int getViewTypeCount()
    {
      return 2;
    }

    class ViewHolder
    {
      TextView replyContent;
      TextView replyData;
      ProgressBar replyProgressBar;
      ImageView replyStateFailed;

      ViewHolder()
      {
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.example.CustomActivity
 * JD-Core Version:    0.6.2
 */