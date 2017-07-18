package com.guokm.tibetanroot.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.cviews.Zidingyifirst;
import com.guokm.tibetanroot.interfaces.TestInterface;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/6/9.
 */

public class SubjectDetailActivity extends BaseActivity implements TestInterface {
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
        Intent intent = new Intent(this, RichStyleRvActivity.class);
        startActivity(intent);
    }

    @Override
    public void test1() {
        Logger.e("guoguo", "我是被设置过监听的，我是test1我被执行了");
    }

    @Override
    public void test2() {
        Logger.e("guoguo", "我是没有被设置过监听的，我是test2我被执行了");
    }


}
