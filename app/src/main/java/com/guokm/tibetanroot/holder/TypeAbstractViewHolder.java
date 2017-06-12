package com.guokm.tibetanroot.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.guokm.tibetanroot.domain.DataModel;

/**
 * Created by Administrator on 2017/6/12.
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {
    public TypeAbstractViewHolder(View itemView) {
        super(itemView);

    }

    public abstract void bindHolder(DataModel model);
}
