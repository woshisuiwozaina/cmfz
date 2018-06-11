package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


/**
 * Created by Administrator on 2018/5/28.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /*   导航菜单   */
    @ResponseBody
    @RequestMapping(value = "/menu")
    public List<Menu> menu(){
        List<Menu> menuList = menuService.querry("0");
        for (Menu me:menuList){
            System.out.println(me);
        }
        return menuList;
    }

}
