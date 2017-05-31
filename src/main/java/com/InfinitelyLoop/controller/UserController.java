package com.InfinitelyLoop.controller;

import com.InfinitelyLoop.pojo.UserAccount;
import com.InfinitelyLoop.pojo.UserDetail;
import com.InfinitelyLoop.service.impl.LanguageService;
import com.InfinitelyLoop.service.impl.UserAccountService;
import com.InfinitelyLoop.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private LanguageService languageService;


    //跳转到注册页面
    @RequestMapping("/register")
    public String register(){
        return "/userRegister";
    }

    //注册数据处理
    @RequestMapping(value = "/registerHandle", method = RequestMethod.POST)
    public String registerHandle(UserAccount userAccount){
        userAccountService.insertSelective(userAccount);
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(userAccount.getUserId());
        userDetailService.insertSelective(userDetail);
        return "redirect:/";
    }


    //跳转到登陆页面
    @RequestMapping("/login")
    public String login(){
        return "/userLogin";
    }

    //登陆处理
    @RequestMapping("/loginHandle")
    public String loginHandle(UserAccount userAccount, HttpSession httpSession){
        UserAccount ua = userAccountService.selectByUsername(userAccount.getUserUsername());
        if(ua != null){
            if(ua.getUserPassword().equals(userAccount.getUserPassword())){
                httpSession.setAttribute("userId", ua.getUserId());
                httpSession.setAttribute("nickname",ua.getUserNickname());
                return "redirect:/";
            }
            else
                return "redirect:/";
        }
        return "redirect:/";
    }


    //注销
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }


    //获取用户资料
    @RequestMapping("/detail")
    public String detail(HttpSession httpSession,Model model){
        UserDetail userDetail = userDetailService.selectByUserId((Integer) httpSession.getAttribute("userId"));
        model.addAttribute("userDetail", userDetail);
        return "/userDetail";
    }

    //修改用户资料
    @RequestMapping("/detail-update")
    public String detailUpdate(HttpSession httpSession,Model model){
        UserDetail userDetail = userDetailService.selectByUserId((Integer) httpSession.getAttribute("userId"));
        model.addAttribute("userDetail", userDetail);
        return "/userDetailUpdate";
    }

    @RequestMapping("detailHandle")
    public String detailHandle(UserDetail userDetail){
        userDetailService.updateByPrimaryKeySelective(userDetail);
        return "redirect:/user/detail";
    }
}
