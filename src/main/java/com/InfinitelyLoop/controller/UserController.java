package com.InfinitelyLoop.controller;

import com.InfinitelyLoop.pojo.UserAccount;
import com.InfinitelyLoop.pojo.UserDetail;
import com.InfinitelyLoop.service.impl.LanguageService;
import com.InfinitelyLoop.service.impl.UserAccountService;
import com.InfinitelyLoop.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private HttpServletRequest request;


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

    //处理用户资料更新
    @RequestMapping("detailHandle")
    public String detailHandle(UserDetail userDetail, MultipartFile avatar){
        if(!avatar.isEmpty()){
            String pic_r_path = "/static/avatar/";
            String pic_a_path = request.getSession().getServletContext().getRealPath("/") + pic_r_path;
            System.out.println(pic_a_path + "----------------------------------");
            String originalName = avatar.getOriginalFilename();
            String newFileName = userDetail.getUserId() + originalName.substring(originalName.lastIndexOf("."));
            File file = new File(pic_a_path+newFileName);
            try {
                avatar.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            userDetail.setUserAvatar(pic_r_path+newFileName);
        }
        userDetailService.updateByPrimaryKeySelective(userDetail);
        return "redirect:/user/detail";
    }
}
