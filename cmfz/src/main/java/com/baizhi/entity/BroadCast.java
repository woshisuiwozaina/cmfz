package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import java.util.Date;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public class BroadCast implements Serializable {
    private String id;
    private String title;
    private String imgPath;
    private String desc;
    private String status;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    //@JSONFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone="GMT+8")
    //@JsonSerialize(using=JsonDateSerilizer.class)
    //@JsonDeserialize(using=JsonDateDeserilizer.class)
    @JSONField(format = "yyyy-MM-dd")
    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BroadCast{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", desc='" + desc + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
