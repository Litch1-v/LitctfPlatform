package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.mapper.Noticemapper;
import com.litchi.litchi_ctf.pojo.Local;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.ChallengeService;
import com.litchi.litchi_ctf.service.LocalService;
import com.litchi.litchi_ctf.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@Slf4j
public class AdminController {
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private LocalService localService;
    @GetMapping("/admin/index")
    public ModelAndView getAdminIndex(HttpSession session){
        ModelAndView mv=new ModelAndView("redirect:/admin/challengelist");
        return mv;
    }
    @GetMapping("/admin/notice")
    public ModelAndView getAdminNotice(HttpSession session){
        ModelAndView mv=new ModelAndView("addNotice");
        //User user=(User)session.getAttribute("user");
        User user=new User();
        user.setUsername("admin");
        mv.addObject("user",user);
        return mv;
    }
    @GetMapping("/admin/challengelist")
    public ModelAndView getChallengeList(HttpSession session){
        ModelAndView mv=new ModelAndView("challengeList");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        if (session.getAttribute("local")==null) {
            Local local = Local.getInstance();
            local.setChallengeList(challengeService.getAllChallenge());
            mv.addObject("local", local);
        }
        else {
            Local local=(Local) session.getAttribute("local");
            local.setChallengeList(challengeService.getAllChallenge());
            mv.addObject("local",local);
        }
        return mv;
    }
    @GetMapping("/admin/addchallenge")
    public ModelAndView getAddChallenge(HttpSession session){
        ModelAndView mv=new ModelAndView("addChallenge");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        return mv;
    }
    @GetMapping("/admin/noticelist")
    public ModelAndView getNoticeList(HttpSession session){
        ModelAndView mv=new ModelAndView("noticeList");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        if (session.getAttribute("local")==null) {
            Local local = Local.getInstance();
            local.setNoticeList(localService.getNoticeList());
            mv.addObject("local", local);
        }
        else {
            Local local=(Local) session.getAttribute("local");
            local.setNoticeList(localService.getNoticeList());
            mv.addObject("local",local);
        }
        return mv;
    }
}
