package com.catsic.recycler_swipedemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.catsic.recycler_swipedemo.swipe.adapters.BaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Litao-pc on 2016/5/16.
 */
public class MyAdapter extends BaseRecyclerAdapter<MyAdapter.ViewHolder> {
    public List<String> mDatas;

    public MyAdapter(Context mContext) {
        super(mContext);
        mDatas = new ArrayList<>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        closeAllItems();
        ViewHolder viewHolder = (ViewHolder) holder;
        mItemManger.bind(viewHolder.itemView, position);
        viewHolder.position.setText(mDatas.get(position)+position);

    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @InjectView(R.id.trash)
        TextView trash;
        @InjectView(R.id.position)
        TextView position;

        ViewHolder(View view) {
            super(view);
            ButterKnife.inject(this, view);
        }
    }
}
