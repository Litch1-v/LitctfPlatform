package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.ChallengeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class AdminChallengeController {
    @Autowired
    private ChallengeService challengeService;
    @GetMapping("/admin/challenge/{id}")
    public ModelAndView getChallengeDetail(@PathVariable(name = "id") int cid, HttpSession session){
        ModelAndView mv=new ModelAndView("challengeDetail");
        User user=(User)session.getAttribute("uid");
        Challenge challenge=challengeService.getChallengeById(cid);
        mv.addObject("challenge",challenge);
        mv.addObject("user",user);
        return mv;
    }
}
