package com.guokm.tibetanroot.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.StrictMode;

/**
 * Created by Administrator on 2017/6/20.
 */

public class StrictModeWrapper {


    /**
     * 初始化strictMode策略：提升性能（检测内存泄漏、主线程耗时操作<磁盘读写、访问网络等等...>）
     */
    public static void init(Context context) {
        //检查当前是否是debug模式
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int appFlags = applicationInfo.flags;
        if ((appFlags & ApplicationInfo.FLAG_DEBUGGABLE) != 0) {

            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog()
                    .build()
            );
            //
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }
}
