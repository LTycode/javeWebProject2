package com.xiaohuang.controller;

import com.xiaohuang.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
@Controller
@RequestMapping("upload")
@ResponseBody
public class UploadController {

    @Autowired
    private FileService fileService;
    //实现图片上传
    @ResponseBody
    @RequestMapping("pic")
    public Map<String,Object> uploadImage(MultipartFile file){
        return fileService.uploadImage(file);
    }

}
