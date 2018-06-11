package com.baizhi.service;


import com.baizhi.entity.BroadCast;
import com.baizhi.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public interface BroadService {
    public List<BroadCast> querryAll();

    public void set(BroadCast broadCast);

    public void delete(String id);

    public void insert(BroadCast broadCast);

}
