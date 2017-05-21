package com.guokm.tibetanroot.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.activity.CollectionActivity;
import com.guokm.tibetanroot.activity.MessageActivity;
import com.guokm.tibetanroot.activity.PersonInfoActivity;
import com.guokm.tibetanroot.activity.SetUpActivity;
import com.guokm.tibetanroot.activity.TopicActivity;
import com.jauker.widget.BadgeView;

/**
 * Created by Administrator on 2017/5/18.
 */

public class MineFragment extends BaseFragment {

    private TextView message_tv;
    private BadgeView badgeView;
    private TextView username_tv;
    private TextView subject_tv;
    private TextView favorites_tv;
    private TextView setup;

    public static MineFragment newInstance(String param1) {
        MineFragment fragment = new MineFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    public MineFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agrs1");
        TextView tv = (TextView)view.findViewById(R.id.tv);
        tv.setText(agrs1);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        username_tv = (TextView) getActivity().findViewById(R.id.username_tv);
        message_tv = (TextView) getActivity().findViewById(R.id.message_tv);
        subject_tv = (TextView) getActivity().findViewById(R.id.subject_tv);
        favorites_tv = (TextView) getActivity().findViewById(R.id.favorites_tv);
        setup = (TextView) getActivity().findViewById(R.id.setup);

        int unreadCount=5;
        badgeView = new BadgeView(getActivity());
        badgeView.setTargetView(message_tv);
//        badgeView.setBackgroundColor(Color.BLUE);
        badgeView.setBackground(7,Color.RED);
        badgeView.setBadgeCount(unreadCount);
        badgeView.setBadgeGravity(Gravity.CENTER);
        setOnClick();
    }

    private void setOnClick() {
        username_tv.setOnClickListener(this);
        message_tv.setOnClickListener(this);
        subject_tv.setOnClickListener(this);
        favorites_tv.setOnClickListener(this);
        setup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.username_tv:
                //
                Intent i=new Intent(getActivity(), PersonInfoActivity.class);
                startActivity(i);
                break;
            case R.id.message_tv:
                Intent iMessage=new Intent(getActivity(), MessageActivity.class);
                startActivity(iMessage);
                break;
            case R.id.subject_tv:
                //
                Intent iTopic=new Intent(getActivity(), TopicActivity.class);
                startActivity(iTopic);
                break;
            case R.id.favorites_tv:
                //
                Intent iCollection=new Intent(getActivity(), CollectionActivity.class);
                startActivity(iCollection);
                break;
            case R.id.setup:
                Intent iSetUp=new Intent(getActivity(), SetUpActivity.class);
                startActivity(iSetUp);
                break;
        }
    }

    private void intent2Activity() {

    }
}
