package com.guokm.tibetanroot.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.guokm.tibetanroot.ActivityCollector;
import com.guokm.tibetanroot.MyApplication;
import com.orhanobut.logger.Logger;
import com.umeng.message.PushAgent;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/5/18.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUmengAppStartCount();

        /**
         * 背景图和通知栏融合
         */
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActivityCollector.addActivity(this);
    }

    /**
     * Umeng统计应用启动数据,初始化
     */
    private void initUmengAppStartCount() {
        PushAgent.getInstance(MyApplication.getContext()).onAppStart();//
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.i("当前所在activity是：" + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    public void onClick(View view) {

    }
}
