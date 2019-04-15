package com.litchi.litchi_ctf.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.UserService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 牛奶冻荔枝
 * @date 2018/10/8
 * 登录控制器，完成登录逻辑的校验
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping(value = "/")
    public String index() {
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String getLogin(){
        Subject sub=SecurityUtils.getSubject();
        if (sub.isAuthenticated()&&sub.getSession().getAttribute("USER_SESSION")!=null){
            return "redirect:/index";
        }
        else{
            return "login";
        }
    }
    @PostMapping(value = "/login")
    public String doLogin(String vrifycode,String username, String password, HttpSession session, Map<String,String> messageMap) {
        String kaptchaId=(String) session.getAttribute("vrifyCode");
        if (!(vrifycode.equals(kaptchaId))){
            messageMap.put("msg","您输入的验证码有误");
            session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            return "login";
        }
        Subject sub = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            sub.login(token);
        } catch (UnknownAccountException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", username);
            messageMap.put("msg","您登录的用户不存在");
            session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            token.clear();
            return "login";
        }  catch (IncorrectCredentialsException e){
            log.error("对用户[{}]进行登录验证，验证未通过，密码不正确",username);
            messageMap.put("msg","您的密码错误，请重新登录");
            session.setAttribute("vrifyCode", RandomUtils.nextInt(10000,99999));
            token.clear();
            return "login";
        }
        User user=(User)sub.getSession().getAttribute("USER_SESSION");
        user=userService.getUserById(user.getUid());
        log.info("用户[{}]成功登陆",username);
        session.setAttribute("user",user);
        return "redirect:/index";
    }

}
