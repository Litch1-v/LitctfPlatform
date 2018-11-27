package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.Local;
import com.litchi.litchi_ctf.pojo.Notice;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.LocalService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
@Controller
public class NoticeController {
    @Autowired
    private LocalService localService;
    @GetMapping("/notice")
    public ModelAndView getNotice(HttpSession session){
        ModelAndView mv=new ModelAndView("notice");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        List< Notice > noticeList=localService.getNoticeList();
        Local.getInstance().setNoticeList(noticeList);
        mv.addObject("local",Local.getInstance());
        return mv;
    }
}
