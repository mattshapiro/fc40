package com.haarman.listviewanimations.itemmanipulation;

import android.widget.BaseAdapter;
import android.widget.ListView;
import com.haarman.listviewanimations.BaseAdapterDecorator;

public class SwipeDismissAdapter extends BaseAdapterDecorator
{
  private OnDismissCallback mCallback;

  public SwipeDismissAdapter(BaseAdapter paramBaseAdapter, OnDismissCallback paramOnDismissCallback)
  {
    super(paramBaseAdapter);
    this.mCallback = paramOnDismissCallback;
  }

  public void setListView(ListView paramListView)
  {
    super.setListView(paramListView);
    paramListView.setOnTouchListener(new SwipeDismissListViewTouchListener(paramListView, this.mCallback));
  }
}

/* Location:           /Users/mattshapiro/Downloads/dex2jar/com.dji.smartphone.downloader-dex2jar.jar
 * Qualified Name:     com.haarman.listviewanimations.itemmanipulation.SwipeDismissAdapter
 * JD-Core Version:    0.6.2
 */