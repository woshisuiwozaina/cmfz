package com.baizhi.service;

import com.baizhi.dao.UserCountDao;
import com.baizhi.entity.China;
import com.baizhi.entity.UserCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2018/5/28 0028.
 */
@Service
@Transactional
public class UserCountServiceImp implements UserCountService{
    @Autowired
    private UserCountDao userCountDao;
    @Transactional
    public List<Integer> queryCount(){

        UserCount count1 = userCountDao.queryDays(7);
        UserCount count2 = userCountDao.queryDays(15);
        UserCount count3 = userCountDao.queryDays(30);
        UserCount count4 = userCountDao.queryDays(90);
        UserCount count5 = userCountDao.queryDays(180);
        UserCount count6 = userCountDao.queryDays(365);

        List<Integer> lists = new ArrayList<Integer>();
        lists.add(count1.getCount());
        lists.add(count2.getCount());
        lists.add(count3.getCount());
        lists.add(count4.getCount());
        lists.add(count5.getCount());
        lists.add(count6.getCount());
        return lists;
    }
    /* 查询男 */

    public List<China> queryByAddress(String sex){

        List<China> list = new ArrayList<China>();
        China beijin = userCountDao.queryByAddress("北京", sex);
        beijin.setName("北京");
        list.add(beijin);
        China tianjin = userCountDao.queryByAddress("天津", sex);
        tianjin.setName("天津");
        list.add(tianjin);
        China shanghai = userCountDao.queryByAddress("上海", sex);
        shanghai.setName("上海");
        list.add(shanghai);
        China chongqing = userCountDao.queryByAddress("重庆", sex);
        chongqing.setName("重庆");
        list.add(chongqing);
        China hebei = userCountDao.queryByAddress("河北", sex);
        hebei.setName("河北");
        list.add(hebei);
        China henan = userCountDao.queryByAddress("河南", sex);
        henan.setName("河南");
        list.add(henan);
        China yunnan = userCountDao.queryByAddress("云南", sex);
        yunnan.setName("云南");
        list.add(yunnan);
        China liaoning = userCountDao.queryByAddress("辽宁", sex);
        liaoning.setName("辽宁");
        list.add(liaoning);
        China heilongjiang = userCountDao.queryByAddress("黑龙江", sex);
        heilongjiang.setName("黑龙江");
        list.add(heilongjiang);
        China hunan = userCountDao.queryByAddress("湖南", sex);
        hunan.setName("湖南");
        list.add(hunan);
        China anhui = userCountDao.queryByAddress("安徽", sex);
        anhui.setName("安徽");
        list.add(anhui);
        China shandong = userCountDao.queryByAddress("山东", sex);
        shandong.setName("山东");
        list.add(shandong);
        China xinjiang = userCountDao.queryByAddress("新疆", sex);
        xinjiang.setName("新疆");
        list.add(xinjiang);
        China jiangsu = userCountDao.queryByAddress("江苏", sex);
        jiangsu.setName("江苏");
        list.add(jiangsu);
        China zhejiang = userCountDao.queryByAddress("浙江", sex);
        zhejiang.setName("浙江");
        list.add(zhejiang);
        China jiangxi = userCountDao.queryByAddress("江西", sex);
        jiangxi.setName("江西");
        list.add(jiangxi);
        China hubei = userCountDao.queryByAddress("湖北", sex);
        hubei.setName("湖北");
        list.add(hubei);
        China guangxi = userCountDao.queryByAddress("广西", sex);
        guangxi.setName("广西");
        list.add(guangxi);
        China neimenggu = userCountDao.queryByAddress("内蒙古", sex);
        neimenggu.setName("内蒙古");
        list.add(neimenggu);


        return list;
    }
   
   
}
