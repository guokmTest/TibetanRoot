package com.guokm.tibetanroot.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/4/24.
 */

public class HttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client=new OkHttpClient();//创建实例
        Request request=new Request.Builder().url(address).build();//建一个请求对象来发请求
        client.newCall(request).enqueue(callback);//发起异步请求
    }
}
