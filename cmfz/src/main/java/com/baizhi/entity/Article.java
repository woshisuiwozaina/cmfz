package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public class Article implements Serializable {
    private String id;
    private String title;
    private String content;
    private String insertImgPath;
    private Date publishDate;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInsertImgPath() {
        return insertImgPath;
    }

    public void setInsertImgPath(String insertImgPath) {
        this.insertImgPath = insertImgPath;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", insertImgPath='" + insertImgPath + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
