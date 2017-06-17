package com.guokm.tibetanroot;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import org.litepal.LitePalApplication;

/**
 * Created by Administrator on 2017/6/2.
 * 全局context
 */

public class MyApplication extends LitePalApplication {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initLoggerTools();
        initUmengPush();

    }

    /**
     * 初始化友盟消息推送
     */
    private void initUmengPush() {
        final PushAgent mPushAgent = PushAgent.getInstance(this);

        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String devicetoken) {
                Log.e("umeng_guokm:", "devicetoken是："+devicetoken);
                Log.e("umeng_guokm:", "devicetoken2是："+mPushAgent.getRegistrationId());
                mPushAgent.getRegistrationId();
            }

            @Override
            public void onFailure(String s, String s1) {
                Logger.i("umeng_guokm:", "s:" + s + ";s1:" + s1);
            }
        });

    }

    /**
     * 初始化日志工具
     */
    private void initLoggerTools() {
        Logger.init("TRLog---:::").methodCount(3).methodOffset(0).logLevel(LogLevel.FULL); // 设置Log的是否输出，LogLevel.NONE即无Log输出
    }

    public static Context getContext() {
        return context;
    }

}
