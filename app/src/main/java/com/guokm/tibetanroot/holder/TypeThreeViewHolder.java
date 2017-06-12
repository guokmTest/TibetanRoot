package com.guokm.tibetanroot.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.domain.DataModel;

/**
 * Created by Administrator on 2017/6/12.
 */
public class TypeThreeViewHolder extends TypeAbstractViewHolder {
    public ImageView avatar;
    public TextView name;
    public TextView content;
    public ImageView contentImage;

    public TypeThreeViewHolder(View itemView) {
        super(itemView);
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        name = (TextView) itemView.findViewById(R.id.name);
        content= (TextView) itemView.findViewById(R.id.content);
        contentImage= (ImageView) itemView.findViewById(R.id.contentImg);
    }

    @Override
    public void bindHolder(DataModel model) {
        avatar.setBackgroundColor(model.getAvatarColor());
        name.setText(model.getName());
        content.setText(model.getContent());
        contentImage.setBackgroundColor(model.getContentColor());
    }
}
