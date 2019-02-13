package com.litchi.litchi_ctf.controller;

import com.litchi.litchi_ctf.pojo.Challenge;
import com.litchi.litchi_ctf.pojo.User;
import com.litchi.litchi_ctf.service.ChallengeService;
import com.litchi.litchi_ctf.service.NoticeService;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class AdminEditController {
    private static final Logger log= LoggerFactory.getLogger(AdminEditController.class);
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private ChallengeService challengeService;
    @PostMapping("/admin/addChallenge")
    public ModelAndView addChalleng(HttpSession session,String msg, Challenge challenge){
        ModelAndView mv= new ModelAndView("addChallenge");
        User user=(User)session.getAttribute("user");
        try {
            challengeService.addChallenge(challenge);
            msg="您已经成功添加题目"+challenge.getTitle();
            log.info("成功添加题目"+challenge.getTitle());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            msg="添加题目失败";
            log.error("添加失败"+e.getStackTrace().toString());
        }
        mv.addObject("user",user);
        mv.addObject("msg",msg);
        return mv;
    }
    @PostMapping("/admin/editChallenge")
    public ModelAndView editChalleng(HttpSession session,String msg, Challenge challenge,RedirectAttributes redirectAttributes){
        ModelAndView mv= new ModelAndView("redirect:/admin/challengelist");
        User user=(User)session.getAttribute("user");
        mv.addObject("user",user);
        try {
            challengeService.saveChallenge(challenge);
            msg="您已经成功修改题目"+challenge.getTitle();
            log.info("修改题目"+challenge.toString());
        }
        catch (Exception e){
            msg="修改题目失败";
            log.error("修改失败"+e.getStackTrace().toString());
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        return mv;
    }
    @PostMapping("/admin/editNotice")
    public ModelAndView editNotice(String msg,String description){
        ModelAndView mv=new ModelAndView("addNotice");
        try {
            noticeService.saveNotice(description);
            msg="您已经成功发布通知";
        }catch (Exception e){
            msg="发布通知失败";
        }
        mv.addObject("msg",msg);
        return mv;
    }
    @GetMapping("/admin/deleteChallenge/{cid}")
    public ModelAndView deleteChallenge(String msg, @PathVariable(name = "cid") int cid, RedirectAttributes redirectAttributes){
        try {
            challengeService.deleteChallenge(cid);

            msg="您已经成功删除"+cid;
        }catch (Exception e){
            msg="删除失败";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        ModelAndView mv=new ModelAndView("redirect:/admin/challengelist");
        return mv;
    }
    @GetMapping("/admin/deleteNotice/{nid}")
    public ModelAndView deleteNotice(String msg, @PathVariable(name = "nid") int nid, RedirectAttributes redirectAttributes){
        try {
            noticeService.deleteNotice(nid);
            msg="您已经成功删除"+nid;
        }catch (Exception e){
            msg="删除失败";
        }
        redirectAttributes.addFlashAttribute("msg",msg);
        ModelAndView mv=new ModelAndView("redirect:/admin/noticelist");
        return mv;
    }
}
