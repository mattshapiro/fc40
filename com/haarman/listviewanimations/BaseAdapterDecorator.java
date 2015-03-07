package com.haarman.listviewanimations;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public abstract class BaseAdapterDecorator extends BaseAdapter
{
  protected final BaseAdapter mDecoratedBaseAdapter;
  private ListView mListView;

  public BaseAdapterDecorator(BaseAdapter paramBaseAdapter)
  {
    this.mDecoratedBaseAdapter = paramBaseAdapter;
  }

  public boolean areAllItemsEnabled()
  {
    return this.mDecoratedBaseAdapter.areAllItemsEnabled();
  }

  public int getCount()
  {
    return this.mDecoratedBaseAdapter.getCount();
  }

  public BaseAdapter getDecoratedBaseAdapter()
  {
    return this.mDecoratedBaseAdapter;
  }

  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.mDecoratedBaseAdapter.getDropDownView(paramInt, paramView, paramViewGroup);
  }

  public Object getItem(int paramInt)
  {
    return this.mDecoratedBaseAdapter.getItem(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return this.mDecoratedBaseAdapter.getItemId(paramInt);
  }

  public int getItemViewType(int paramInt)
  {
    return this.mDecoratedBaseAdapter.getItemViewType(paramInt);
  }

  public ListView getListView()
  {
    return this.mListView;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.mDecoratedBaseAdapter.getView(paramInt, paramView, paramViewGroup);
  }

  public int getViewTypeCount()
  {
    return this.mDecoratedBaseAdapter.getViewTypeCount();
  }

  public boolean hasStableIds()
  {
    return this.mDecoratedBaseAdapter.hasStableIds();
  }

  public boolean isEmpty()
  {
    return this.mDecoratedBaseAdapter.isEmpty();
  }

  public boolean isEnabled(int paramInt)
  {
    return this.mDecoratedBaseAdapter.isEnabled(paramInt);
  }

  public void notifyDataSetChanged()
  {
    this.mDecoratedBaseAdapter.notifyDataSetChanged();
  }

  public void notifyDataSetInvalidated()
  {
    this.mDecoratedBaseAdapter.notifyDataSetInvalidated();
  }

  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDecoratedBaseAdapter.registerDataSetObserver(paramDataSetObserver);
  }

  public void setListView(ListView paramListView)
  {
    this.mListView = paramListView;
    if ((this.mDecoratedBaseAdapter instanceof BaseAdapterDecorator))
      ((BaseAdapterDecorator)this.mDecoratedBaseAdapter).setListView(paramListView);
  }

  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    this.mDecoratedBaseAdapter.unregisterDataSetObserver(paramDataSetObserver);
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.BaseAdapterDecorator
 * JD-Core Version:    0.6.2
 */