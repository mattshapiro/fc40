package com.allinone.free.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends BaseAdapter
{
  Context context;
  List<String> items;

  public MyAdapter(Context paramContext, List<String> paramList)
  {
    this.context = paramContext;
    this.items = paramList;
  }

  public void addItem(String paramString)
  {
    this.items.add(paramString);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.items.size();
  }

  public Object getItem(int paramInt)
  {
    return this.items.get(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = LayoutInflater.from(this.context).inflate(2130903103, null);
    ((TextView)localView.findViewById(2131230871)).setText((CharSequence)this.items.get(paramInt));
    return localView;
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.allinone.free.adapter.MyAdapter
 * JD-Core Version:    0.6.2
 */