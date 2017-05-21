package com.guokm.tibetanroot.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/21.
 */

public class Topic implements Serializable {
    private String title;
    private String date;
    private  String imgUrl;

    public Topic(String title, String date, String imgUrl) {
        this.title = title;
        this.date = date;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
