package com.baizhi.service;

import com.baizhi.dao.MenuDao;

import com.baizhi.entity.Menu;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Administrator on 2018/5/28 0028.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class MenuServiceImp implements MenuService {
    @Autowired
    private MenuDao menuDao;
   public List<Menu> querry(String pid){
       List<Menu> menus = menuDao.queryByPID(pid);
       return menus;
   }
}
