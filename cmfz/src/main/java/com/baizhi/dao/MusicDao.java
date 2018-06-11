package com.baizhi.dao;

import com.baizhi.entity.Character1;
import com.baizhi.entity.Title;

import java.util.List;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
public interface MusicDao {
    public List<Title> queryByAll();
    public List<Character1>queryByID(String pp);
    public void insert(Title title);
    public void add(Character1 character1);
}
