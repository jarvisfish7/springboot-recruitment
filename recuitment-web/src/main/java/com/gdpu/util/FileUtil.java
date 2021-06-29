package com.gdpu.util;

import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileUtil {

    public String uploadFile(String path, MultipartFile file) {
        String name = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String suffix = name.substring(name.lastIndexOf("."));
        File local = new File(path + uuid + suffix);
        if(!local.getParentFile().exists()) {
            local.getParentFile().mkdirs();
        }
        try {
            file.transferTo(local);
            return uuid + suffix;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
    }

    public String uploadImage(MultipartFile image) {
        String path = ClassUtils.getDefaultClassLoader().getResource("static/img/").getPath();
        System.out.println("第一个目录是:"+path);
        String name = uploadFile(path, image);
        System.out.println(name);

        return name;
    }

    public void deleteImage(String src) {
        if (src==""){
            return;
        }
        String path = ClassUtils.getDefaultClassLoader().getResource("static/img/").getPath();
//        String name = src.replace("/img/", "");

        deleteFile(path + src);
        System.out.println(path + src+"被删除！");
    }

    /**
     * 返回static拼接文件目录
     * @param uri
     * @return
     */
    public String  getAbsolute(String uri){
        String path = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        return path+uri;
    }

    /**
     * 返回img目录绝对目录
     */
    public String getImg(){
        String path = ClassUtils.getDefaultClassLoader().getResource("static/img/").getPath();
        StringBuffer sb = new StringBuffer(path);
        sb.deleteCharAt(0);
        sb.insert(0,"file:");
        return sb.toString();
    }


}
