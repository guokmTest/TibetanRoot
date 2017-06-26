package com.guokm.tibetanroot;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.util.Log;

import com.guokm.tibetanroot.activity.CollectionActivity;
import com.guokm.tibetanroot.activity.UmengMsgActivity;
import com.guokm.tibetanroot.util.StrictModeWrapper;
import com.guokm.tibetanroot.util.T;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;

import org.litepal.LitePalApplication;

/**
 * Created by Administrator on 2017/6/2.
 * 全局context
 */

public class MyApplication extends LitePalApplication {
    private static Context context;
    private PushAgent mPushAgent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initLoggerTools();
        initUmengPush();
        initUmessageCustom(mPushAgent);
        initStrictMode();

    }

    /**
     * 初始化strictMode策略：提升性能（检测内存泄漏、主线程耗时操作<磁盘读写、访问网络等等...>）
     */
    private void initStrictMode() {
        try {

            StrictModeWrapper.init(this);
        } catch (Throwable t) {
            Logger.e("StricMode", "版本低于2.3，无法运行strictMode");
        }
    }


    /**
     * 初始化友盟消息推送
     */
    private void initUmengPush() {
        mPushAgent = PushAgent.getInstance(this);

        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String devicetoken) {
                //在改方中请求接口将设备token传给服务器
                Logger.e("当前所在activity是：" + devicetoken);
                Log.e("umeng_guokm:", "devicetoken是：" + devicetoken);
                Log.e("umeng_guokm:", "devicetoken2是：" + mPushAgent.getRegistrationId());
//                mPushAgent.getRegistrationId();

            }

            @Override
            public void onFailure(String s, String s1) {
                Logger.i("umeng_guokm:", "s:" + s + ";s1:" + s1);
            }
        });


    }

    /**
     * 处理来自Umeng自定义消息，如果要打开对应的activity且传入包含内容的intent，
     * 该Handler是在BroadcastReceiver中被调用，故如果需启动Activity，需添加Intent.FLAG_ACTIVITY_NEW_TASK
     */
    private void initUmessageCustom(PushAgent mPushAgent) {
        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
            @Override
            public void dealWithCustomAction(Context context, UMessage msg) {
//                T.s(msg.custom);
                T.s(msg.url + "1111");
                Intent customIntent = new Intent(getContext(), UmengMsgActivity.class);
                customIntent.putExtra("custom", msg.custom);
                customIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(customIntent);
            }
        };
        mPushAgent.setNotificationClickHandler(notificationClickHandler);
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
