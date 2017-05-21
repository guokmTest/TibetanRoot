package com.guokm.tibetanroot.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.activity.CollectionActivity;
import com.guokm.tibetanroot.activity.TopicActivity;
import com.guokm.tibetanroot.domain.Collection;
import com.guokm.tibetanroot.domain.MessageItem;
import com.guokm.tibetanroot.domain.Topic;
import com.jauker.widget.BadgeView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public class TopicsItemAdapter extends BaseAdapter {
    private static final String TAG = "TopicItemAdapter";
    private List<?> itemList;
    Context context;

    public TopicsItemAdapter(Context context, List itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public Object getItem(int i) {
        return itemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        /**
         * 复用adapter，根据传过来的context不同来加载不同的item。
         */
        if (context instanceof CollectionActivity) {
            Collection collection = (Collection) getItem(i);
            View view;
            ViewHolder viewHolder;
            if (convertView == null) {
                view = LayoutInflater.from(context).inflate(R.layout.item_collection, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.name_tv = (TextView) view.findViewById(R.id.name_tv);
                viewHolder.body_tv = (TextView) view.findViewById(R.id.body_tv);
                viewHolder.topic_iv = (ImageView) view.findViewById(R.id.topic_iv);
                view.setTag(viewHolder);
            } else {
                view = convertView;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.name_tv.setText(collection.getName());
            viewHolder.body_tv.setText(collection.getBody());
            //设置网络获取的头像url，这里暂时不写。

            return view;
        } else if (context instanceof TopicActivity) {
        Topic topic = (Topic) getItem(i);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title_tv = (TextView) view.findViewById(R.id.title_tv);
            viewHolder.time_tv = (TextView) view.findViewById(R.id.time_tv);
            viewHolder.topic_iv = (ImageView) view.findViewById(R.id.topic_iv);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title_tv.setText(topic.getTitle());
        viewHolder.time_tv.setText(topic.getDate());
        //设置网络获取的头像url，这里暂时不写。

        return view;
        }else {
            return null;
        }
    }

}

class ViewHolder {
    TextView title_tv;
    TextView time_tv;
    ImageView topic_iv;
    TextView name_tv;
    TextView body_tv;


}
