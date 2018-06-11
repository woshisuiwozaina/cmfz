package com.baizhi.controller;

import com.baizhi.entity.Character1;
import com.baizhi.entity.Title;
import com.baizhi.service.AlbumService;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2018/5/31 0031.
 */
@Controller
@RequestMapping(value = "/album")
public class AlbumController {
    @Autowired
    private AlbumService albumServiceImp;

    /*展示所有*/
    @ResponseBody
    @RequestMapping(value = "/all")

    public List<Title> querryAll(){

        List<Title> list = albumServiceImp.queryAll();
        for (Title t:list
             ) {
            System.out.println(t);
        }
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/insert" )
    public String insert(Title title , MultipartFile img1 , HttpServletRequest request) {
        String result = albumServiceImp.insert(title, img1, request);
        return result ;

    }

    /* 章节的上传 */
    @ResponseBody
    @RequestMapping(value = "add")
    public String add(Character1 character1 ,String cname, HttpServletRequest request , MultipartFile mp3){
        character1.setName(cname);
        String result = albumServiceImp.add(character1, mp3, request);
        return result;
    }

    /* 文件的下载*/
    @ResponseBody
    @RequestMapping(value = "down")
    public void down(String url , String name , HttpServletResponse response, HttpServletRequest request){
        String projectPath = request.getSession().getServletContext().getRealPath("/");
        File  file = new File(projectPath);
        String webappsPath = file.getParent();
        String filePath = webappsPath + url;

        File downFile = new File(filePath);
        String fileName = null;
        try {
            fileName = new String(name.getBytes("UTF-8"), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setHeader("content-disposition", "attachment;fileName=" + fileName);
        response.setContentType("audio/mpeg");
        //响应出去
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(FileUtils.readFileToByteArray(downFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
