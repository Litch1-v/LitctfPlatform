package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.Notice;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.ChallengeService;
import com.litchi.litchi_ctf.service.NoticeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@Slf4j
public class AdminController {
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/admin/index")
    public ModelAndView getAdminIndex(HttpSession session){
        ModelAndView mv=new ModelAndView("redirect:/admin/challengelist");
        return mv;
    }
    @GetMapping("/admin/notice")
    public ModelAndView getAdminNotice(HttpSession session){
        ModelAndView mv=new ModelAndView("addNotice");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        return mv;
    }
    @GetMapping("/admin/challengelist")
    public ModelAndView getChallengeList(HttpSession session){
        ModelAndView mv=new ModelAndView("challengeList");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        ConcurrentHashMap<Integer, List<Challenge>> typeChallengeMap=challengeService.listAllChallenges().getChallengeListMap();
        List<Challenge> allChallengesList=new LinkedList<>();
        typeChallengeMap.values().forEach(typeChallengeList->allChallengesList.addAll(typeChallengeList));
        mv.addObject("allChallengeList",allChallengesList);
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
        List<Notice> noticeList=noticeService.getNoticeList();
        mv.addObject("noticeList",noticeList);
        return mv;
    }
}
