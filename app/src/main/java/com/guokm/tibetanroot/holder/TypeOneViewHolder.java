package com.guokm.tibetanroot.holder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guokm.tibetanroot.MyApplication;
import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.activity.MyViewPagerActivity;
import com.guokm.tibetanroot.domain.DataModel;
import com.guokm.tibetanroot.util.T;

/**
 * Created by Administrator on 2017/6/12.
 */
public class TypeOneViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;
    public TextView name;
    public View rootView;

    public TypeOneViewHolder(View itemView) {
        super(itemView);
        rootView=itemView;
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    @Override
    public void bindHolder(DataModel model) {
        avatar.setBackgroundColor(model.getAvatarColor());
        name.setText(model.getName());
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.s("点击了列表");
                Intent i=new Intent(MyApplication.getContext(),MyViewPagerActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//非activity调用startActivity需要设置Task
                MyApplication.getContext().startActivity(i);
            }
        });
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                T.s("点击了头像");
            }
        });
    }
}
