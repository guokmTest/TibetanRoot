package com.guokm.tibetanroot.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/19.
 */

public class MessageItem implements Serializable {
    private String title;
    private String date;

    public MessageItem(String title, String date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MessageItem{" +
                "title='" + title + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
