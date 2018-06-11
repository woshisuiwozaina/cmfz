package com.baizhi.dao;

import com.baizhi.entity.BroadCast;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public interface BroadDao {
    public List<BroadCast> queryAll();
    public void set(@Param("broad") BroadCast broad);
    public void delete(String id);
    public void insert(BroadCast broad);
}
