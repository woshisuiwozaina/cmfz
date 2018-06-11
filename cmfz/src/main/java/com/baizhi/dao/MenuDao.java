package com.baizhi.dao;

import com.baizhi.entity.Menu;


import java.util.List;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public interface MenuDao {
    public List<Menu> queryByPID(String pid);
    public List<Menu> queryByID(String id);
}
