package com.yyn.controller;

import com.yyn.bean.UserInfo;
import com.yyn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 杨以诺
 * by 2020-04-04 14:06
 */
@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/login.do")
    public ModelAndView Login(String username, String password) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userInfoService.login(username);
        if (userInfo == null) {
            mv.addObject("error_username", "账号不存在");
            mv.addObject("username", username);
            mv.addObject("password", password);
            System.out.println("登陆失败");
            mv.setViewName("../index");
        } else {
            if (password.equals(userInfo.getPassword())) {
                mv.addObject("user", userInfo);
                System.out.println("登陆成功");
                mv.setViewName("main");
            } else {
                mv.addObject("error_password", "密码错误");
                mv.addObject("username", username);
                mv.addObject("password", password);
                System.out.println("登陆失败");
                mv.setViewName("../index");
            }
        }
        return mv;
    }

    @RequestMapping("/register.do")
    public ModelAndView register(String username, String password) {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userInfoService.findAll();
        boolean flag = true;
        for (UserInfo user : userInfoList) {
            if (user.getUsername().equals(username)) {
                flag = false;
            }
        }
        if (flag) {
            UserInfo userInfo = new UserInfo(username, password);
            int i = userInfoService.addUserInfo(userInfo);
            mv.addObject("userInfo", userInfo);
            if (i > 0) {
                System.out.println("添加成功");
                mv.setViewName("../index");
            } else {
                System.out.println("添加失败");
                mv.addObject("error","添加失败");
                mv.setViewName("../register");
            }
        } else {
            System.out.println("账号已存在");
            mv.addObject("error","账号已存在");
            mv.setViewName("../register");
        }
        return mv;
    }

    @RequestMapping("/exit.do")
    public String exit(HttpSession session) {
        try {
            session.removeAttribute("userInfo");
        } catch (Exception e) {

        }
        return "redirect:/";
    }
}
