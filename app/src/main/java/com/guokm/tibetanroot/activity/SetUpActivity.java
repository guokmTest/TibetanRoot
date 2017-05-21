package com.guokm.tibetanroot.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.guokm.tibetanroot.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/5/22.
 */

public class SetUpActivity extends BaseActivity {
    @BindView(R.id.back_button)
    Button backButton;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.search_button)
    Button searchButton;
    @BindView(R.id.grade_tv)
    TextView gradeTv;
    @BindView(R.id.about_tv)
    TextView aboutTv;
    @BindView(R.id.wipecache_tv)
    TextView wipecacheTv;
    @BindView(R.id.logout_btn)
    Button logoutBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        titleText.setText("设置");
        backButton.setVisibility(View.VISIBLE);
        searchButton.setVisibility(View.GONE);
    }

    @OnClick({R.id.back_button,  R.id.grade_tv, R.id.about_tv, R.id.wipecache_tv, R.id.logout_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.grade_tv:
                //评分
                break;
            case R.id.about_tv:
                break;
            case R.id.wipecache_tv:
                //清缓存
                break;
            case R.id.logout_btn:
                //登出--弹出dialog
                break;
        }
    }
}
