package com.catsic.recycler_swipedemo.swipe.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.catsic.recycler_swipedemo.swipe.SwipeLayout;
import com.catsic.recycler_swipedemo.swipe.implments.SwipeItemMangerImpl;
import com.catsic.recycler_swipedemo.swipe.interfaces.SwipeAdapterInterface;
import com.catsic.recycler_swipedemo.swipe.interfaces.SwipeItemMangerInterface;
import com.catsic.recycler_swipedemo.swipe.util.Attributes;

import java.util.List;

/**
 * Created by Litao-pc on 2016/5/16.
 */
public abstract class BaseRecyclerAdapter<V> extends RecyclerView.Adapter implements SwipeItemMangerInterface, SwipeAdapterInterface {
    protected SwipeItemMangerImpl mItemManger = new SwipeItemMangerImpl(this);
    protected Context mContext;

    public BaseRecyclerAdapter(Context mContext){
        this.mContext=mContext;
    }

    public abstract int getSwipeLayoutResourceId(int position);

    @Override
    public void openItem(int position) {
        mItemManger.openItem(position);
    }

    @Override
    public void closeItem(int position) {
        mItemManger.closeItem(position);
    }

    @Override
    public void closeAllExcept(SwipeLayout layout) {
        mItemManger.closeAllExcept(layout);
    }

    @Override
    public void closeAllItems() {
        mItemManger.closeAllItems();
    }

    @Override
    public List<Integer> getOpenItems() {
        return mItemManger.getOpenItems();
    }

    @Override
    public List<SwipeLayout> getOpenLayouts() {
        return mItemManger.getOpenLayouts();
    }

    @Override
    public void removeShownLayouts(SwipeLayout layout) {
        mItemManger.removeShownLayouts(layout);
    }

    @Override
    public boolean isOpen(int position) {
        return mItemManger.isOpen(position);
    }

    @Override
    public Attributes.Mode getMode() {
        return mItemManger.getMode();
    }

    @Override
    public void setMode(Attributes.Mode mode) {
        mItemManger.setMode(mode);
    }

    @Override
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

}
