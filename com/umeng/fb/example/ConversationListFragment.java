package com.umeng.fb.example;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.umeng.fb.FeedbackAgent;
import com.umeng.fb.model.Conversation;
import com.umeng.fb.model.Reply;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ConversationListFragment extends ListFragment
{
  private static final String STATE_ACTIVATED_POSITION = "activated_position";
  private static final String TAG = ConversationListFragment.class.getName();
  private static Callbacks sDummyCallbacks = new Callbacks()
  {
    public void onItemSelected(String paramAnonymousString)
    {
    }
  };
  private int mActivatedPosition = -1;
  private Callbacks mCallbacks = sDummyCallbacks;
  private ConversationListAdapter mConversationListAdapter;

  private void setActivatedPosition(int paramInt)
  {
    getListView().setItemChecked(paramInt, true);
  }

  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!(paramActivity instanceof Callbacks))
      throw new IllegalStateException("Activity must implement fragment's callbacks.");
    this.mCallbacks = ((Callbacks)paramActivity);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mConversationListAdapter = new ConversationListAdapter(getActivity());
    setListAdapter(this.mConversationListAdapter);
    setHasOptionsMenu(true);
  }

  public void onDetach()
  {
    super.onDetach();
    this.mCallbacks = sDummyCallbacks;
  }

  public void onListItemClick(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    super.onListItemClick(paramListView, paramView, paramInt, paramLong);
    this.mCallbacks.onItemSelected(this.mConversationListAdapter.getConversationId(paramInt));
  }

  public void onResume()
  {
    super.onResume();
    this.mConversationListAdapter.notifyDataSetChanged();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.mActivatedPosition != -1)
      paramBundle.putInt("activated_position", this.mActivatedPosition);
  }

  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.mActivatedPosition = 0;
    if ((paramBundle != null) && (paramBundle.containsKey("activated_position")))
    {
      this.mActivatedPosition = paramBundle.getInt("activated_position");
      setActivatedPosition(this.mActivatedPosition);
    }
  }

  public void setActivateOnItemClick(boolean paramBoolean)
  {
    ListView localListView = getListView();
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      localListView.setChoiceMode(i);
      return;
    }
  }

  public static abstract interface Callbacks
  {
    public abstract void onItemSelected(String paramString);
  }

  class ConversationListAdapter extends ArrayAdapter
  {
    private FeedbackAgent agent;
    private Context context;
    private List<Conversation> conversationList;
    LayoutInflater mInflater;

    public ConversationListAdapter(Context arg2)
    {
      super(17367063);
      this.context = localContext;
      this.conversationList = new ArrayList();
      this.agent = new FeedbackAgent(localContext);
      Iterator localIterator = this.agent.getAllConversationIds().iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this.mInflater = LayoutInflater.from(localContext);
          return;
        }
        String str = (String)localIterator.next();
        this.conversationList.add(this.agent.getConversationById(str));
      }
    }

    public void addConversation(Conversation paramConversation)
    {
      this.conversationList.add(paramConversation);
      notifyDataSetChanged();
    }

    public String getConversationId(int paramInt)
    {
      return ((Conversation)this.conversationList.get(paramInt)).getId();
    }

    public int getCount()
    {
      if (this.conversationList == null)
        return 0;
      return this.conversationList.size();
    }

    public Object getItem(int paramInt)
    {
      if (this.conversationList == null)
        return null;
      return (Conversation)this.conversationList.get(paramInt);
    }

    public long getItemId(int paramInt)
    {
      return super.getItemId(paramInt);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ViewHolder localViewHolder;
      if (paramView == null)
      {
        paramView = this.mInflater.inflate(17367063, null);
        localViewHolder = new ViewHolder();
        localViewHolder.text1 = ((TextView)paramView.findViewById(16908308));
        localViewHolder.text2 = ((TextView)paramView.findViewById(16908309));
        paramView.setTag(localViewHolder);
      }
      while (true)
      {
        Conversation localConversation = (Conversation)this.conversationList.get(paramInt);
        if (localConversation.getReplyList().size() > 0)
        {
          long l = ((Reply)localConversation.getReplyList().get(-1 + localConversation.getReplyList().size())).created_at;
          String str = new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(new Date(l));
          localViewHolder.text1.setText(((Reply)localConversation.getReplyList().get(0)).content);
          localViewHolder.text2.setText("last replied: " + str);
        }
        return paramView;
        localViewHolder = (ViewHolder)paramView.getTag();
      }
    }

    class ViewHolder
    {
      TextView text1;
      TextView text2;

      ViewHolder()
      {
      }
    }
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.umeng.fb.example.ConversationListFragment
 * JD-Core Version:    0.6.2
 */