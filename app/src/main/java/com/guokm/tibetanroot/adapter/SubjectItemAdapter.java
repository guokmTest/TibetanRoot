package com.guokm.tibetanroot.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.domain.MessageItem;
import com.guokm.tibetanroot.domain.Subject;
import com.guokm.tibetanroot.util.JJLImageLoader;
import com.jauker.widget.BadgeView;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by Administrator on 2017/5/19.
 */

public class SubjectItemAdapter extends BaseAdapter {
    private static final String TAG = "SubjectItemAdapter";
    private List<Subject> itemList;
    Context context;

    public SubjectItemAdapter(Context context, List itemList) {
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
        Subject subject = (Subject) getItem(i);
        Logger.i(subject.toString());
        Logger.i(subject.getBody().toString());
        Logger.i(subject.getBody().getName());
        String name = subject.getBody().getName();
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_subject, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.topic_iv = (ImageView) view.findViewById(R.id.topic_iv);
            viewHolder.heart_iv = (ImageView) view.findViewById(R.id.heart_iv);
            viewHolder.comment_iv = (ImageView) view.findViewById(R.id.comment_iv);
            viewHolder.coll_iv = (ImageView) view.findViewById(R.id.coll_iv);
            viewHolder.name_tv = (TextView) view.findViewById(R.id.name_tv);
            viewHolder.time_tv = (TextView) view.findViewById(R.id.time_tv);
            viewHolder.address_tv = (TextView) view.findViewById(R.id.address_tv);
            viewHolder.suject_body = (TextView) view.findViewById(R.id.suject_body);
            viewHolder.heart_tv = (TextView) view.findViewById(R.id.heart_tv);
            viewHolder.comment_tv = (TextView) view.findViewById(R.id.comment_tv);
            viewHolder.subject_rv = (RecyclerView) view.findViewById(R.id.subject_rv);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
//        JJLImageLoader.download(context, subject.getTopic(), viewHolder.topic_iv);
//        viewHolder.heart_iv.setImageResource(R.drawable.xxx);判断是否点过赞，来显示红心还是没有颜色的心
//        viewHolder.coll_iv.setImageResource(R.drawable.xxx);判断是否收藏，来显示收藏还是没有收藏的图标
        viewHolder.name_tv.setText(subject.getBody().getName());
        viewHolder.time_tv.setText(subject.getBody().getTime());
        viewHolder.address_tv.setText(subject.getBody().getAddress());
        viewHolder.suject_body.setText(subject.getBody().getContent());
        viewHolder.heart_tv.setText(String.valueOf(subject.getBody().getHeart()));
        viewHolder.comment_tv.setText(String.valueOf(subject.getBody().getComment()));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewHolder.subject_rv.setLayoutManager(linearLayoutManager);
        List rvlist = subject.getBody().getUrllist();
        RvAdapter rvAdapter = new RvAdapter(rvlist,context);
        viewHolder.subject_rv.setAdapter(rvAdapter);


        return view;
    }

    static class ViewHolder {
        ImageView topic_iv;
        ImageView heart_iv;
        ImageView comment_iv;
        ImageView coll_iv;
        TextView name_tv;
        TextView time_tv;
        TextView address_tv;
        TextView suject_body;
        TextView heart_tv;
        TextView comment_tv;
        RecyclerView subject_rv;
    }

    public static class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
        private List rvlist;
        private Context context;

        public RvAdapter(List<Subject.BodyBean.UrllistBean> rvlist, Context context) {
            this.rvlist = rvlist;
            this.context=context;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public ViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView) itemView.findViewById(R.id.rv_iv);
            }
        }

        @Override
        public RvAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_subject_rv, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(RvAdapter.ViewHolder holder, int position) {
            Subject.BodyBean.UrllistBean urllistBean = (Subject.BodyBean.UrllistBean) rvlist.get(position);
            Logger.i(urllistBean.toString());
            JJLImageLoader.downloadSmall(context, urllistBean.getPicurl(), holder.imageView);
        }

        @Override
        public int getItemCount() {
            return rvlist.size();
        }
    }

}
