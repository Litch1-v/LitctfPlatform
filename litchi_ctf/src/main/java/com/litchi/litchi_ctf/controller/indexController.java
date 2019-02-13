package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.ChallengeType;
import com.litchi.litchi_ctf.pojo.Notice;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
@Slf4j
@Controller
public class indexController {
    @Autowired
    private HttpSession session;
    @Autowired
    private UserService userService;
    @Autowired
    private SolveService solveService;
    @Autowired
    private RankService rankService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ChallengeService challengeService;
    @GetMapping("/index")
    public ModelAndView getindex(){
        ModelAndView mv=new ModelAndView();
        //刷新用户状态
        User user=userService.getUserById(((User)session.getAttribute("user")).getUid());
        session.setAttribute("user",user);
        //getTopFiveUserList
        List<User> userRankList=rankService.getUserRankList();
        List<User> topFive;
        if (userRankList.size()>=5){
            topFive=userRankList.subList(0,5);
        }
        else {
            topFive=userRankList;
        }
        List<Notice> noticeList=noticeService.getNoticeList();
        List<Notice> lastNoticeList=new LinkedList<>();
        if (noticeList.size()>=3){
            lastNoticeList=noticeList.subList(0,3);
        }
        else {
            lastNoticeList=noticeList;
        }
        //取出用户各个类型题目的解题总数
        int[] countSolved=new int[7];
        for (int i = 1; i <7; i++) {
            countSolved[i]=user.getSolvedChallenge().get(i).size();
            mv.addObject(ChallengeType.values()[i-1].name(),countSolved[i]);
        }
        int userNumber=userService.getUserNumber();
        mv.addObject("userNumber",userNumber);
        mv.addObject("lastNoticeList",lastNoticeList);
        mv.addObject("rank",rankService.getUserRankByUid(user.getUid()));
        mv.addObject("user",user);
        mv.addObject("topFive",topFive);
        mv.setViewName("index");
        return mv;
    }

}
