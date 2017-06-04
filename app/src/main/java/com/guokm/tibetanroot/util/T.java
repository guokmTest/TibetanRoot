package com.guokm.tibetanroot.util;

import android.widget.Toast;

import com.guokm.tibetanroot.MyApplication;

/**
 * Toast 显示的通用工具
 * <p>
 * Created by athena on 2015/11/19.
 * Email: lizhiqiang@bjjajale.com
 */
public class T {
    public static void s(String text) {
        Toast.makeText(MyApplication.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    public static void s(int resid) {
        Toast.makeText(MyApplication.getContext(), resid, Toast.LENGTH_SHORT).show();
    }
}