package com.baizhi.service;

import com.baizhi.dao.BroadDao;
import com.baizhi.entity.BroadCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class BroadCastImp implements BroadService {
    @Autowired
    private BroadDao broad;
    public List<BroadCast> querryAll() {
        List<BroadCast> lists = broad.queryAll();
        return lists;
    }
    @Transactional
    public void set(BroadCast broadCast){
        broad.set(broadCast);
    }

    @Transactional
    public void delete(String  id){
        broad.delete(id);
    }

    @Transactional
    public void insert(BroadCast broadCast){
        broad.insert(broadCast);
    }
}
