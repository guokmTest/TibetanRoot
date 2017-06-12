package com.guokm.tibetanroot.domain;

/**
 * Created by Administrator on 2017/6/12.
 */

public class DataModel {

    public static final int TYPE_ONE=1;//item类型编号，也可以卸载常量类中，但是还是这样感觉整齐，容易寻找
    public static final int TYPE_TWO=2;
    public static final int TYPE_THREE=3;
    public int type; //从返回的数据中拿到jsonObject的type存入对象，为当前对象的ITEM类型
    public int avatarColor;
    public String name;
    public String content;
    public int contentColor;

    public static int getTypeOne() {
        return TYPE_ONE;
    }

    public static int getTypeTwo() {
        return TYPE_TWO;
    }

    public static int getTypeThree() {
        return TYPE_THREE;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;

    }

    @Override
    public String toString() {
        return "DataModel{" +
                "type=" + type +
                ", avatarColor=" + avatarColor +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", contentColor=" + contentColor +
                '}';
    }
}