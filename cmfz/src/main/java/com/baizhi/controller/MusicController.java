package com.baizhi.controller;

import com.baizhi.entity.BroadCast;
import com.baizhi.service.BroadService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/5/29 0029.
 */
@Controller
@RequestMapping(value = "/music")
public class MusicController {
    @Autowired
    private BroadService broadService;
    /*查询所有*/
    @ResponseBody
    @RequestMapping(value = "/broad" ,produces ={"application/json;charset=UTF-8"} )
    public List<BroadCast> broad(){
        List<BroadCast> lists = broadService.querryAll();
        for (BroadCast b:lists) {
            System.out.println(b);
        }
        return lists;
    }


}
