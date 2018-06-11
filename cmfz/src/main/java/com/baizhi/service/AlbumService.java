package com.baizhi.service;


import com.baizhi.entity.Character1;
import com.baizhi.entity.Title;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Administrator on 2018/5/31 0031.
 */
public interface AlbumService  {
    public List<Title> queryAll();
    public String insert(Title title , MultipartFile img, HttpServletRequest request);
    public String add(Character1 character1 , MultipartFile map3 , HttpServletRequest request);
}
