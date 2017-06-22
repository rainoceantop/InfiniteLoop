package com.InfiniteLoop.controller;

import com.InfiniteLoop.pojo.UserAccount;
import com.InfiniteLoop.pojo.UserDetail;
import com.InfiniteLoop.service.impl.UserAccountService;
import com.InfiniteLoop.service.impl.UserDetailService;
import com.InfiniteLoop.tool.Languages;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserAccountService userAccountService;
    @Autowired
    private UserDetailService userDetailService;
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
        userDetail.setUserNickname(userAccount.getUserNickname());
        userDetail.setUserAvatar("http://orfbw2a1e.bkt.clouddn.com/avatar-default.jpg");
        userDetail.setV(1);
        userDetailService.insertSelective(userDetail);
        return "redirect:/";
    }

    //注册预处理
    @ResponseBody
    @RequestMapping(value = "/registerPreHandle", method = RequestMethod.POST)
    public String usernameHandle(String username,String user,String email){
        UserAccount ua = new UserAccount();
        ua.setUserUsername(username);
        ua.setUserNickname(user);
        ua.setUserEmail(email);
        UserAccount result = userAccountService.selectByKeyword(ua);
        if(result == null){
            return "SUCCESS";
        }
        return "ERROR";
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
        EnumMap<Languages, String> languagesMap = Languages.getLanguageMap();
        model.addAttribute("languagesMap", languagesMap);
        model.addAttribute("userDetail", userDetail);
        return "/userDetail";
    }

    //处理用户资料更新
    @RequestMapping("/detailHandle")
    public String detailHandle(UserDetail userDetail,String[] language) {
        String lan = StringUtils.join(language,",");
        userDetail.setUserLanguagesAttention(lan);
        userDetailService.updateByUserIdSelective(userDetail);
        return "redirect:/user/detail";
    }

    @ResponseBody
    @RequestMapping("/userAvatarUpdate")
    public String userAvatarUpdate(MultipartFile userAvatar, int userId){
        UserDetail userDetail = userDetailService.selectByUserId(userId);
        Response response = null;
        if(!userAvatar.isEmpty()){
            String[] contentType = {"image/jpeg","image/png","image/gif"};
            if(isContains(contentType, userAvatar.getContentType())){
                //构造一个带指定Zone对象的配置类
                Configuration cfg = new Configuration(Zone.zone2());
                //...其他参数参考类注释
                UploadManager uploadManager = new UploadManager(cfg);
                //...生成上传凭证，然后准备上传
                String accessKey = "M2TrolxfManTFNP4Clr3M12JW0tvAaCV0xIbrZk5";
                String secretKey = "Llh0byt0KDHwiFlcNVvPiTpQSrH8IrZSt5puu1zS";
                String bucket = "infinitelyloopimg";
                //默认不指定key的情况下，以文件内容的hash值作为文件名
                String key = "avatar-user-" + userId;
                Auth auth = Auth.create(accessKey, secretKey);
                String upToken = auth.uploadToken(bucket,key,3600,new StringMap().put("insertOnly",0));
                System.out.println(upToken);
                String pic_r_path = "/static/avatar/";
                String pic_a_path = request.getSession().getServletContext().getRealPath("/") + pic_r_path;
                String tempUrl = pic_a_path + userAvatar.getOriginalFilename();
                File file = new File(tempUrl);
                try {
                    //头像移至缓冲区
                    userAvatar.transferTo(file);
                    //上传新的头像
                    response = uploadManager.put(tempUrl, key, upToken);
                    //删除缓冲区头像
                    if(file.isFile() && file.exists()){
                        file.delete();
                    }
                    //解析上传成功的结果
                    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                    String url = "http://orfbw2a1e.bkt.clouddn.com/" + key + "?imageView2/0/w/400&v=" + userDetail.getV();
                    userDetail.setUserId(userId);
                    userDetail.setUserAvatar(url);
                    //更新头像版本，让cdn可立即获取到最新上传的头像
                    userDetail.setV(userDetail.getV() + 1);
                    userDetailService.updateUserAvatarByUserId(userDetail);
                    return url;

                } catch (QiniuException ex) {
                    Response r = ex.response;
                    try {
                        System.err.println(r.bodyString());
                    } catch (QiniuException ex2) {
                        //ignore
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "ERROR";
        }
        return "ERROR";
    }

    //数组是否包含
    private boolean isContains(String[] arr, String s){
        for(String a : arr){
            if(a.equals(s))
                return true;
        }
        return false;
    }
}
