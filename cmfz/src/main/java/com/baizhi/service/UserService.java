package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public interface UserService {
    public Map<String,Object> login(User user);
}
