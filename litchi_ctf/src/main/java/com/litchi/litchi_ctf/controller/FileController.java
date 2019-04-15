package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
public class FileController {
    private final static Logger log= LoggerFactory.getLogger(FileController.class);
    @Autowired
    private StorageService storageService;
    @GetMapping("/file/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);

    }
    @PostMapping("/admin/uploadFile")
    public ModelAndView adminPostFile(String msg,HttpSession session, MultipartFile file)throws IOException {
        ModelAndView mv=new ModelAndView("addChallenge");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        try {
            storageService.init();
            storageService.store(file);
            msg="您已经成功上传文件"+file.getOriginalFilename()+"路径为/file/"+file.getOriginalFilename();
            log.info("上传文件"+file.getOriginalFilename());
        }
        catch (Exception e){
            msg="上传失败";
            log.error("上传错误",e);
        }
        mv.addObject("msg",msg);
        return mv;
    }


}
