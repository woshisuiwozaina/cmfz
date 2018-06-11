package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public class Special implements Serializable {
    private String id;
    private String title;
    private String coverimg;
    private Integer cont;
    private Double score;
    private String author;
    private String broadCate;
    private String brief;
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

    public String getCoverimg() {
        return coverimg;
    }

    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    public Integer getCont() {
        return cont;
    }

    public void setCont(Integer cont) {
        this.cont = cont;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBroadCate() {
        return broadCate;
    }

    public void setBroadCate(String broadCate) {
        this.broadCate = broadCate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Special{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", coverimg='" + coverimg + '\'' +
                ", cont=" + cont +
                ", score=" + score +
                ", author='" + author + '\'' +
                ", broadCate='" + broadCate + '\'' +
                ", brief='" + brief + '\'' +
                ", date=" + date +
                '}';
    }
}
