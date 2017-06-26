package com.guokm.tibetanroot.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.guokm.tibetanroot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/18.
 */

public class AboutActivity extends BaseActivity {
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.back_button)
    Button backButton;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.freshtime_tv)
    TextView freshtimeTv;
    @BindView(R.id.search_button)
    Button searchButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umeng_msg);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        backButton.setVisibility(View.VISIBLE);
        freshtimeTv.setVisibility(View.GONE);
        searchButton.setVisibility(View.GONE);
        titleText.setText("关于藏根");
        textView.setText("关于页面详情");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.back_button)
    public void onViewClicked() {
        finish();
    }
}
