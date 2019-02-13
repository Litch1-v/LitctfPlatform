package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.RankService;
import com.litchi.litchi_ctf.service.SolveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
@Slf4j
@Controller
public class RankController {
    @Autowired
    private SolveService solveService;
    @Autowired
    private RankService rankService;
    @GetMapping("/rank")
    public ModelAndView getRank(HttpSession session){
        ModelAndView mv=new ModelAndView("rank");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        List<User> userRankList=rankService.getUserRankList();
        mv.addObject("userRankList",userRankList);
        return mv;
    }
}
