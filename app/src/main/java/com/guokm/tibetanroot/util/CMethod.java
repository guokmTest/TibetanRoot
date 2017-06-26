package com.guokm.tibetanroot.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.guokm.tibetanroot.R;
import com.guokm.tibetanroot.activity.SplashActivity;

/**
 * Created by Administrator on 2017/6/20.
 */

public class CMethod {
    // 判读是否已经存在快捷方式
    public static boolean isExistShortCut(Context context) {
        boolean isInstallShortcut = false;
        final ContentResolver cr = context.getContentResolver();
        // 本人的2.2系统是”com.android.launcher2.settings”,网上见其他的为"com.android.launcher.settings"
        final String AUTHORITY = "com.android.launcher2.settings";
        final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/favorites?notify=true");
        Cursor c = cr.query(CONTENT_URI, new String[]{"title", "iconResource"}, "title=?", new String[]{context.getString(R.string.app_name)}, null);
        if (c != null && c.getCount() > 0) {
            isInstallShortcut = true;
        }
        return isInstallShortcut;
    }

    /**
     * 创建快捷方式
     *
     * @param context
     */
    public static void createShortcut(Context context) {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, context.getString(R.string.app_name));
        shortcut.putExtra("duplicate", false);//设置是否重复创建
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setClass(context, SplashActivity.class);//设置第一个页面
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(context, R.mipmap.ic_launcher);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        context.sendBroadcast(shortcut);
    }


    /**
     * 判断是否有网络连接
     *
     * @return
     */
    public static boolean isNet(Context context) {
        boolean flag = false;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        int leng = 0;
        NetworkInfo[] arrayOfNetworkInfo = manager.getAllNetworkInfo();
        if (arrayOfNetworkInfo != null) {
            leng = arrayOfNetworkInfo.length;
        }
        for (int i = 0; i < leng; i++) {
            if (arrayOfNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
