package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.ChallengeType;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.ChallengeService;
import com.litchi.litchi_ctf.service.SolveService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Controller
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private SolveService solveService;
    @GetMapping("/challenge")
    public ModelAndView getChanllenge(HttpSession session) {
        ModelAndView mv=new ModelAndView("Challenge");
        User user=(User) session.getAttribute("user");
        mv.addObject("user",user);
        ConcurrentHashMap<Integer, List<Challenge>> typeChallengeMap=challengeService.listAllChallenges().getChallengeListMap();
        for (ChallengeType value : ChallengeType.values()) {
            mv.addObject(value.name()+"_SOLVED",user.getSolvedChallenge().get(value.getTypecode()));
        }
        mv.addObject("typeChallengeMap",typeChallengeMap);
        return mv;
    }
    @PostMapping("/challenge")
    @Transactional(rollbackFor = Exception.class)
    public ModelAndView postChallenge(String vrifycode,int cid, String flag, String msg,HttpSession session){
        Challenge challenge=challengeService.getChallengeById(cid);
        String kaptchaId=(String) session.getAttribute("vrifyCode");
        User user=(User) session.getAttribute("user");
        if (!vrifycode.equals(kaptchaId)){
            msg="对不起，您的验证码有误";
            ModelAndView mv=getChanllenge(session);
            mv.addObject("msg",msg);
            session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            return mv;
        }
        if (challenge.getFlag().equals(flag)){
            List<Integer> typeSolvedChallenge=user.getSolvedChallenge().get(challenge.getType());
            if (!typeSolvedChallenge.contains(cid)) {
                try {
                    //需要将解决的问题存入，在数据库层面操作，还需要在内存层面操作
                    solveService.saveNewSolved(challenge, user);
                    solveService.addOneSolvedNumber(cid);
                    user.setSolvedNumber(user.getSolvedNumber()+1);
                    solveService.addOneUserSolvedNumber(user.getUid());
                    typeSolvedChallenge.add(cid);
                }
                catch (Exception e){
                    msg="发生未知错误，请重试或者联系管理员";
                    ModelAndView mv=getChanllenge(session);
                    mv.addObject("msg",msg);
                    return mv;
                }
                msg="太强了，您成功做出了这道题";
            }
            else {
                msg="这题您已经做过了，换换别题吧";
                session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            }
            ModelAndView mv=getChanllenge(session);
            mv.addObject("msg",msg);
            return mv;
        }
        else{
            ModelAndView mv=getChanllenge(session);
            msg="对不起，您答错了";
            mv.addObject("msg",msg);
            session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            return mv;
        }
    }
}
