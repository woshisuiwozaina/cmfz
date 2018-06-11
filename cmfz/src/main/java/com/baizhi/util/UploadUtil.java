package com.baizhi.util;

import com.baizhi.entity.FileParam;
import org.apache.commons.io.FilenameUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Administrator on 2018/6/1 0001.
 */
public class UploadUtil {
    public static final String FILE = "FILE";
    public static final String bIMG = "IMG";
    public static FileParam addFile(MultipartFile multipartFile , HttpServletRequest request, String type){
        String projectPath = request.getSession().getServletContext().getRealPath("/");

        File file = new File(projectPath);
        String webappsPath = file.getParent();
        File uploadPath;
        String url;
        if(type.equals(FILE)){
            uploadPath = new File(webappsPath+"/audio");
            url="/audio";
        } else {
            uploadPath = new File(webappsPath + "/upload");
            url = "/upload";
        }
        if (!uploadPath.exists()) {
            uploadPath.mkdir();
        }
        String oldFilename = multipartFile.getOriginalFilename();
        String extension = FilenameUtils.getBaseName(oldFilename);
        String newName = UUID.randomUUID().toString();
        newName= newName+"."+extension;
        try {
            multipartFile.transferTo(new File(uploadPath.getPath(), newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new FileParam(url + "/" + newName, oldFilename);
    }
}
