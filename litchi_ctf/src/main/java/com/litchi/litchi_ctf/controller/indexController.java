package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.mapper.Solvemapper;
import com.litchi.litchi_ctf.pojo.*;
import com.litchi.litchi_ctf.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
@Slf4j
@Controller
public class indexController {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;
    @Autowired
    private SolveService solveService;
    @Autowired
    private RankService rankService;
    @Autowired
    private LocalService localService;
    @Autowired
    private ChallengeService challengeService;
    @GetMapping("/index")
    public ModelAndView getindex(){
        ModelAndView mv=new ModelAndView();
        User user=(User)session.getAttribute("user");
        Solved solved=solveService.getUserSolved(user);
        Rank rank=Rank.getInstance();
        List<User> userList=rankService.getUserRank(rank);
        List<User> firstFive=new LinkedList<>();
        if (userList.size()>=5){
            firstFive=userList.subList(0,5);
        }
        else {
            firstFive=userList;
        }
        Local local=Local.getInstance();
        List<Notice> noticeList=localService.getNoticeList();
        List<Notice> lastNoticeList=new LinkedList<>();
        if (noticeList.size()>=3){
            lastNoticeList=noticeList.subList(0,3);
        }
        else {
            lastNoticeList=noticeList;
        }
        local.setNoticeList(localService.getNoticeList());
        local.setRank(rank);
        local.setUserNumber(localService.getUserNumber());
        local.setChallengeList(challengeService.getAllChallenge());
        session.setAttribute("local",local);
        session.setAttribute("solved",solved);
        mv.addObject("lastNoticeList",lastNoticeList);
        mv.addObject("rank",rankService.getUserRankByUid(user.getUid(),rank));
        mv.addObject("user",user);
        mv.addObject("solved",solved);
        mv.addObject("firstFive",firstFive);
        mv.setViewName("index");
        return mv;
    }

}
