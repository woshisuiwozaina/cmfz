package com.baizhi.service;

import com.baizhi.dao.MusicDao;
import com.baizhi.entity.Character1;
import com.baizhi.entity.FileParam;
import com.baizhi.entity.Title;
import com.baizhi.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2018/5/31 0031.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AlbumServiceImp implements AlbumService {
    @Autowired
    private MusicDao musicDao;
    public List<Title> queryAll() {
        List<Title> lists = musicDao.queryByAll();
        return lists;
    }

    /*  添加 */
    @Transactional
    public String insert(Title title , MultipartFile img, HttpServletRequest request) {
        String id = UUID.randomUUID().toString().replace("-", "");
        title.setId(id);
        FileParam addFile = UploadUtil.addFile(img, request, "IMG");
        String url = addFile.getUrl();
        title.setImg(url);
        try{
            musicDao.insert(title);
            return "ok";
        }catch (Exception e){

            e.printStackTrace();
            return "false";
        }

    }
    @Transactional
    public String add(Character1 character1, MultipartFile mp3, HttpServletRequest request) {
       String id = UUID.randomUUID().toString()+1111111111;
       character1.setId(id);
       long size1 = mp3.getSize();
       double size = (double)size1/1024/1000;
       character1.setSize(size+""+"MB");
       character1.setTime1("10分钟");
        FileParam addFile = UploadUtil.addFile(mp3, request, "FILE");
        String url = addFile.getUrl();
        character1.setUrl(url);
        try{
            System.out.println(character1+"=============================================================");
            musicDao.add(character1);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "false";
        }
    }
}
