package com.guokm.tibetanroot.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;
import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.util.PermissionUtils;
import com.guokm.tibetanroot.util.SplashPictureUtils;
import com.guokm.tibetanroot.util.T;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/6/21.
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.iv_splash_root_bg)
    ImageView iv_splash_root_bg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
/*        if (PermissionUtils.isPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            initView();
        }*/

        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_PHONE_STATE}, new PermissionsResultAction() {

                    @Override
                    public void onGranted() {
                        initView();
                    }

                    @Override
                    public void onDenied(String permission) {
                        T.s(
                                "Sorry, we need the Storage Permission to do that"
                        );
                    }
                });

        return;

    }

    private void initView() {

        SplashPictureUtils splashPictureUtils = new SplashPictureUtils(this);
        splashPictureUtils.setSplashBg(iv_splash_root_bg);
        //先加载本地的,然后请求网络，当网络返回的url与sp存的url不一致，下载网络的，且替换该url

        delayToHomePage();
    }

    private void delayToHomePage() {
        //使用异步任务去替代new Thread
        new AsyncTask<Void, Integer, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                OpenMainActivity();
            }


        }.execute();
    }

    private void OpenMainActivity() {
        Intent intent = new Intent();
        intent.setClass(SplashActivity.this, MainActivity.class);
/*        if (!CMethod.isEmpty(openTag)) {
            intent.putExtra(IntentAction.OPEN_SPLASH_TAB, openTag);
        }*/
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    initView();
                } else {
                    T.s("You denied the permission/程式2S后即将退出");
                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 1000 * 2);
                }
        }
    }
}
