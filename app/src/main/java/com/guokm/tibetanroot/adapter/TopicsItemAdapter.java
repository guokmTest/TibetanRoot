package com.guokm.tibetanroot.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.domain.MessageItem;
import com.jauker.widget.BadgeView;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public class TopicsItemAdapter extends BaseAdapter {
    private static final String TAG = "TopicItemAdapter";
    private List<MessageItem> itemList;
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
        MessageItem messageItem = (MessageItem) getItem(i);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title_tv = (TextView) view.findViewById(R.id.title_message_tv);
            viewHolder.time_tv = (TextView) view.findViewById(R.id.time_message_tv);
            viewHolder.message_item_layout = (RelativeLayout) view.findViewById(R.id.message_item_layout);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title_tv.setText(messageItem.getTitle());
        viewHolder.time_tv.setText(messageItem.getDate());

        return view;
    }

    static class ViewHolder {
        TextView title_tv;
        TextView time_tv;
        RelativeLayout message_item_layout;

    }
}
