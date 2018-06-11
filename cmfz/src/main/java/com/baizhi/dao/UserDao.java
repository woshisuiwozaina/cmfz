package com.baizhi.dao;

import com.baizhi.entity.User;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public interface UserDao {
    public User queryByName(String name);
}
