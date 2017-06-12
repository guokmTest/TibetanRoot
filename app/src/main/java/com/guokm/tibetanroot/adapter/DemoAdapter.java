package com.guokm.tibetanroot.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.domain.DataModel;
import com.guokm.tibetanroot.holder.TypeAbstractViewHolder;
import com.guokm.tibetanroot.holder.TypeOneViewHolder;
import com.guokm.tibetanroot.holder.TypeThreeViewHolder;
import com.guokm.tibetanroot.holder.TypeTwoViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/12.
 */

public class DemoAdapter extends RecyclerView.Adapter {

    private LayoutInflater mLayoutInflater;
    private List<DataModel> mlist = new ArrayList<>();

    public DemoAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case DataModel.TYPE_ONE:
                return new TypeOneViewHolder(mLayoutInflater.inflate(R.layout.item_type_one, parent, false));

            case DataModel.TYPE_TWO:
                return new TypeTwoViewHolder(mLayoutInflater.inflate(R.layout.item_type_two, parent, false));

            case DataModel.TYPE_THREE:
                return new TypeThreeViewHolder(mLayoutInflater.inflate(R.layout.item_type_three, parent, false));

        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((TypeAbstractViewHolder)holder).bindHolder(mlist.get(position));//由于是先执行的gettype，可能就记住了type，而自动识别...就酱紫，记住用法吧
    }

    @Override
    public int getItemViewType(int position) {
        return mlist.get(position).getType();//取列表类型
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void addData(List<DataModel> list) {
        mlist.addAll(list);
    }
}
