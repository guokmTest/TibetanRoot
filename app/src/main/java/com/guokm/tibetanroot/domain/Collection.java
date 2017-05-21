package com.guokm.tibetanroot.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/21.
 */

public class Collection implements Serializable {
    private String name;
    private String body;
    private  String imgUrl;

    public Collection(String name, String body, String imgUrl) {
        this.name = name;
        this.body = body;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "name='" + name + '\'' +
                ", body='" + body + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
