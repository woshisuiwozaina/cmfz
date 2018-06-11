package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/31 0031.
 */
public class Character1  implements Serializable{
    private String id;
    private String name;
    private String size;
    private String url;
    private String time1;//时长
    private String pid;

    @Override
    public String toString() {
        return "Character1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", url='" + url + '\'' +
                ", time1='" + time1 + '\'' +
                ", pid='" + pid + '\'' +
                '}';
    }

    public Character1() {

    }

    public Character1(String id, String name, String size, String url, String time1, String pid) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.url = url;
        this.time1 = time1;
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }
}
