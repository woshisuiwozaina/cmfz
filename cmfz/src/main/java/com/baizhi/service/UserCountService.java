package com.baizhi.service;

import com.baizhi.entity.China;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/3 0003.
 */
public interface UserCountService {
    public List<Integer> queryCount();
    public List<China> queryByAddress(String sex);

}
