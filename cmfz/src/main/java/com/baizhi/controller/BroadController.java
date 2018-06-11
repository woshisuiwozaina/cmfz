package com.baizhi.controller;

import com.baizhi.entity.BroadCast;
import com.baizhi.service.BroadService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value = "/broad")
public class BroadController {
    @Autowired
    private BroadService broadService;
    @ResponseBody
    @RequestMapping(value = "/broad" ,produces ={"application/json;charset=UTF-8"} )
    public List<BroadCast> broad(){
        List<BroadCast> lists = broadService.querryAll();
        for (BroadCast b:lists) {
            System.out.println(b);
        }
        return lists;
    }
    /*  修改  */
    @ResponseBody
    @RequestMapping(value = "/set" )
    public void set(String  id , String status){

        BroadCast broadCast = new BroadCast();
        broadCast.setId(id);
        broadCast.setStatus(status);
        broadService.set(broadCast);

    }

   /*删除*/
   @ResponseBody
   @RequestMapping(value = "/delete" )
   public String delete(BroadCast broadCast){

       broadService.delete(broadCast.getId());
       List<BroadCast> lists = broadService.querryAll();
       for (BroadCast b:lists) {
           System.out.println(b);
       }
       return "redirect:/menu/broadCast.jsp";
   }
   /* 增加 */

   @RequestMapping(value = "/insert")
   @ResponseBody
   public void  insert(MultipartFile img, BroadCast broadCast , HttpServletRequest request){
       Date date = new Date();
       broadCast.setDate(date);
       String id = UUID.randomUUID().toString().replace("-" , "");
       broadCast.setId(id);


       String projectPath = request.getSession().getServletContext().getRealPath("/");

       //获取当前项目路径
       File file = new File(projectPath);
       //获取web项目的路径
       String webappsPath = file.getParent();
       //上传文件夹的路径
       File uploadPath = new File(webappsPath+"//upload");
       if(!uploadPath.exists()){
           uploadPath.mkdir();
       }

       // 获取源文件名
       String oldFilename = img.getOriginalFilename();
        //获取后缀名
       String extension = FilenameUtils.getExtension(oldFilename);
       String  newName = UUID.randomUUID().toString();
       newName = newName + "." + extension;
       try {
           //上传到指定的文件夹
           img.transferTo(new File(uploadPath.getPath(), newName));
       } catch (IOException e) {
           e.printStackTrace();
       }

       broadCast.setImgPath(newName);
       System.out.println(broadCast);
       broadService.insert(broadCast);
       List<BroadCast> lists = broadService.querryAll();
       for (BroadCast b:lists) {
           System.out.println(b);
       }

   }

}
