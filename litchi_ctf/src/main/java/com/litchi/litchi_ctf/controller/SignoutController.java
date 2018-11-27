package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignoutController {
    private static final Logger log= LoggerFactory.getLogger(SignoutController.class);
    @GetMapping("/sign_out")
    public String signOut(User user){
        Subject subject= SecurityUtils.getSubject();
        if (subject.isAuthenticated()){
            subject.logout();
            log.info("用户[{}]登出",user.getUsername());

        }
        return "redirect:/home";
    }
}
