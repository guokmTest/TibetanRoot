package com.guokm.tibetanroot;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Administrator on 2017/6/2.
 * 全局context
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initLoggerTools();
    }

    private void initLoggerTools() {
        Logger.init("TRLog---:::").methodCount(3).methodOffset(0).logLevel(LogLevel.FULL); // 设置Log的是否输出，LogLevel.NONE即无Log输出
    }

    public static Context getContext() {
        return context;
    }

}
