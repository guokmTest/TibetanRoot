package com.guokm.tibetanroot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.cviews.Zidingyifirst;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/9.
 */

public class SubjectDetailActivity extends BaseActivity {
    @BindView(R.id.zidingyi)
    Zidingyifirst zidingyi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.zidingyi)
    public void onViewClicked() {
        Intent intent =new Intent(this,RichStyleRvActivity.class);
        startActivity(intent);
    }
}
