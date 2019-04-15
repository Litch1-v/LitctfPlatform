package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.UserService;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 牛奶冻荔枝
 * @date 2017/10/8
 *
 */
@Controller
public class RegisterController {
    private static final Logger log= LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private UserService userService;
    @PostMapping(value = "/register")
    public String register(HttpSession session, String vrifycode, User user, Map<String,String> map){
        String kaptchaId=(String) session.getAttribute("vrifyCode");
        if (!vrifycode.equals(kaptchaId)){
            map.put("msg","您输入的验证码有误");
            session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            return "register";
        }
        try {
            userService.insertUser(user);
        }catch (DuplicateKeyException e){
            map.put("msg","您输入的用户名已经存在");
            session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            return "register";
        }
        log.info("用户[{}]已经成功注册",user.getUsername());
        map.put("msg","您已经成功注册，前往登录页面登录");
        return "register";
    }
    @GetMapping(value = "/register")
    public String getRegister(){
        return "register";
    }
}
