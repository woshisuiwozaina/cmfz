package com.baizhi.dao;


import com.baizhi.entity.China;
import com.baizhi.entity.UserCount;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
public interface UserCountDao {
    public UserCount queryDays(Integer days);
    public China queryByAddress(@Param("province") String province , @Param("sex")String sex);
}
