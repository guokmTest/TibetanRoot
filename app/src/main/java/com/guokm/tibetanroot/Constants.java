package com.guokm.tibetanroot;

/**
 * Created by Administrator on 2017/4/24.
 */

public class Constants {
    public final static String addressOnline = "http://guolin.tech/api/china";//地区列表获取url
    public final static String requestWeatherUrl = "http://guolin.tech/api/weather?cityid=";
    public final static String APIKEY = "bc0418b57b2d4918819d3974ac1285d9";
    public final static String urlPicNow="https://cdn.heweather.com/cond_icon/";
    public final static String bingImgUrl="http://guolin.tech/api/bing_pic";//必应每日一图接口

    public static String getWeatherUrl(String weatherid) {
        return requestWeatherUrl + weatherid + "&key=" + APIKEY;
    }
    public static String getPicNowUrl(String code){
        return urlPicNow+code+".png";
    }
}
