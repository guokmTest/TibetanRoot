package com.guokm.tibetanroot.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/5/22.
 */

public class PublishActivity extends BaseActivity {
    @BindView(R.id.back_button)
    Button backButton;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.search_button)
    Button searchButton;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.iv_add)
    ImageView ivAdd;
    @BindView(R.id.freshtime_tv)
    TextView freshtimeTv;
    @BindView(R.id.title)
    RelativeLayout title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleText.setText("发表主题");
        backButton.setVisibility(View.VISIBLE);
        searchButton.setVisibility(View.GONE);

    }

    @OnClick(R.id.iv_add)
    public void onViewClicked() {
    }

    @OnClick(R.id.back_button)
    public void onfinish() {
        finish();
    }
}
