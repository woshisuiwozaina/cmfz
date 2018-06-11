package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public class Guru implements Serializable {
    private String id;
    private String name;
    private String head_pic;
    private String sex;

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

    public String getHead_pic() {
        return head_pic;
    }

    public void setHead_pic(String head_pic) {
        this.head_pic = head_pic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Guru{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", head_pic='" + head_pic + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
