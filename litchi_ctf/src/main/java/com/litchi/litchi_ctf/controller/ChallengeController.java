package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.Local;
import com.litchi.litchi_ctf.pojo.Solved;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.ChallengeService;
import com.litchi.litchi_ctf.service.SolveService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.ArrayUtils;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
@Slf4j
@Controller
public class ChallengeController {
    @Autowired
    private HttpSession session;
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private SolveService solveService;
    @GetMapping("/challenge")
    public ModelAndView getChanllenge() {
        ModelAndView mv=new ModelAndView("Challenge");
        User user=(User) session.getAttribute("user");
        Local local=(Local) session.getAttribute("local");
        Solved solved=solveService.getUserSolved(user);
        mv.addObject("user",user);
        mv.addObject("local",local);
        mv.addObject("solved",solved);
        return mv;
    }
    @PostMapping("/challenge")
    public ModelAndView postChallenge(String vrifycode,int cid, String flag, String msg){
        ModelAndView mv=new ModelAndView("Challenge");
        User user=(User) session.getAttribute("user");
        Local local=(Local) session.getAttribute("local");
        local.setChallengeList(challengeService.getAllChallenge());
        mv.addObject("user",user);
        mv.addObject("local",local);
        Challenge challenge=challengeService.getChallengeById(cid);
        String kaptchaId=(String) session.getAttribute("vrifyCode");
        if (!vrifycode.equals(kaptchaId)){
            msg="对不起，您的验证码有误";
            mv.addObject("msg",msg);
            Solved solved=solveService.getUserSolved(user);
            mv.addObject("solved",solved);
            return mv;
        }
        if (challenge.getFlag().equals(flag)){
            int[] solvedChallengeId=solveService.solvedChallengeId(user.getUid());
            Arrays.sort(solvedChallengeId);
            if (Arrays.binarySearch(solvedChallengeId, cid)<0) {
                solveService.saveNewSolved(challenge, user);
                solveService.addOneSolvedNumber(cid);
                solveService.addOneUserSolvedNumber(user.getUid());
                msg="太强了，您成功做出了这道题";
            }
            else {
                msg="这题您已经做过了，换换别题吧";
            }
            mv.addObject("msg",msg);
            Solved solved=solveService.getUserSolved(user);
            mv.addObject("solved",solved);
            return mv;
        }
        else{
            msg="对不起，您答错了";
            mv.addObject("msg",msg);
            Solved solved=solveService.getUserSolved(user);
            mv.addObject("solved",solved);
            return mv;
        }
    }
}
