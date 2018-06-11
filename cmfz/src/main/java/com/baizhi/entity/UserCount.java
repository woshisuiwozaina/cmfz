package com.baizhi.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/2 0002.
 */
public class UserCount implements Serializable {
    private Integer count;

    @Override
    public String toString() {
        return "UserCount{" +
                "count=" + count +
                '}';
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
