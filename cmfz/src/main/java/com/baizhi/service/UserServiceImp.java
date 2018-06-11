package com.baizhi.service;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/28 0028.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
@Order(value=2)
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;
    public Map<String,Object>  login(User user){
        User user1 = userDao.queryByName(user.getUserName());
        Map<String,Object> map = new HashMap<String,Object>();
        if(user1==null){
            map.put("用户不存在" , false);
            return map;
        }else{
            if(user1.getPassword().equals(user.getPassword())){
                map.put("OK" , user1);
                return map;
            }else{
                map.put("密码错误" , false);
                return map;
            }
        }


    }
}
