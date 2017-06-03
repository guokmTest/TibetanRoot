package com.guokm.tibetanroot.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/3.
 */

public class Subject implements Serializable{

    private static final long serialVersionUID = 8484938815722231349L;

    /**
     * code : 200
     * body : {"name":"杨先生","time":"昨天","address":"广西.桂林","content":"我是神经病我是神经病我是神经病","heart":123,"comment":333,"iscollect":true,"urllist":[{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/0db1bf40-62ea-4212-985e-955f98834e5a.JPG"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/528cf652-a2b8-45c8-9cf5-016c224f7155.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"}]}
     */

    private String code;
    private BodyBean body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * name : 杨先生
         * time : 昨天
         * address : 广西.桂林
         * content : 我是神经病我是神经病我是神经病
         * heart : 123
         * comment : 333
         * iscollect : true
         * urllist : [{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/0db1bf40-62ea-4212-985e-955f98834e5a.JPG"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/528cf652-a2b8-45c8-9cf5-016c224f7155.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"},{"picurl":"http://7xosde.com2.z0.glb.qiniucdn.com/8faa407a-97fa-4c67-9dac-a6f9cb2b4020.png"}]
         */

        private String name;
        private String time;
        private String address;
        private String content;
        private int heart;
        private int comment;
        private boolean iscollect;
        private List<UrllistBean> urllist;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getHeart() {
            return heart;
        }

        public void setHeart(int heart) {
            this.heart = heart;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public boolean isIscollect() {
            return iscollect;
        }

        public void setIscollect(boolean iscollect) {
            this.iscollect = iscollect;
        }

        public List<UrllistBean> getUrllist() {
            return urllist;
        }

        public void setUrllist(List<UrllistBean> urllist) {
            this.urllist = urllist;
        }

        public static class UrllistBean {
            /**
             * picurl : http://7xosde.com2.z0.glb.qiniucdn.com/0db1bf40-62ea-4212-985e-955f98834e5a.JPG
             */

            private String picurl;

            public String getPicurl() {
                return picurl;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            @Override
            public String toString() {
                return "UrllistBean{" +
                        "picurl='" + picurl + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "BodyBean{" +
                    "name='" + name + '\'' +
                    ", time='" + time + '\'' +
                    ", address='" + address + '\'' +
                    ", content='" + content + '\'' +
                    ", heart=" + heart +
                    ", comment=" + comment +
                    ", iscollect=" + iscollect +
                    ", urllist=" + urllist +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "code='" + code + '\'' +
                ", body=" + body +
                '}';
    }
}
