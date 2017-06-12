package com.InfinitelyLoop.controller;

import com.InfinitelyLoop.pojo.Questions;
import com.InfinitelyLoop.service.impl.QuestionsService;
import com.InfinitelyLoop.tool.HumanReadableTimeFormat;
import com.InfinitelyLoop.tool.Languages;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private HumanReadableTimeFormat hr;
    @Autowired
    private HttpServletRequest request;


    //主页
    @RequestMapping("/")
    public String queryItems(Model model) throws Exception {
        List<Questions> questions = questionsService.selectAllWithoutBlobs();
        timeformat(questions);
        model.addAttribute("questions", questions);
        return "/index";
    }

    //提问问题转接页面
    @RequestMapping("/newQuestion")
    public String newQuestion(Model model,HttpSession httpSession) throws Exception {
        if(httpSession.getAttribute("nickname") == null){
            return "redirect:/";
        }
        EnumMap<Languages,String> languagesMap = Languages.getLanguageMap();

        model.addAttribute("languagesMap", languagesMap);
        return "/newQuestion";
    }

    //问题提交处理
    @RequestMapping(value = "/newQuestionHandle", method = RequestMethod.POST)
    public String newQuestionHandle(Questions questions, String[] language) throws Exception {
        questions.setQuestionAskedTime(new Date());
        String lan = StringUtils.join(language,",");
        questions.setQuestionLanguage(lan);
        questionsService.insertSelective(questions);
        return "redirect:/";
    }
    //问题图片处理
    @ResponseBody
    @RequestMapping(value = "/questionImgHandle", method = RequestMethod.POST)
    public String questionImgHandle(@RequestParam("questionContentImg") MultipartFile questionContentImg){
        Response response = null;
        if(!questionContentImg.isEmpty()){
            String[] contentType = {"image/jpeg","image/png","image/gif"};
            if(isContains(contentType, questionContentImg.getContentType())){
                //构造一个带指定Zone对象的配置类
                Configuration cfg = new Configuration(Zone.zone2());
                //...其他参数参考类注释
                UploadManager uploadManager = new UploadManager(cfg);
                //...生成上传凭证，然后准备上传
                String accessKey = "M2TrolxfManTFNP4Clr3M12JW0tvAaCV0xIbrZk5";
                String secretKey = "Llh0byt0KDHwiFlcNVvPiTpQSrH8IrZSt5puu1zS";
                String bucket = "infinitelyloopimg";
                //默认不指定key的情况下，以文件内容的hash值作为文件名
                String key = null;
                Auth auth = Auth.create(accessKey, secretKey);
                String upToken = auth.uploadToken(bucket);
                String pic_r_path = "/static/questionImg/";
                String pic_a_path = request.getSession().getServletContext().getRealPath("/") + pic_r_path;
                String tempUrl = pic_a_path + questionContentImg.getOriginalFilename();
                File file = new File(tempUrl);
                try {
                    questionContentImg.transferTo(file);
                    response = uploadManager.put(tempUrl, key, upToken);
                    if(file.isFile() && file.exists()){
                        file.delete();
                    }
                    //解析上传成功的结果
                    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                    return "orfbw2a1e.bkt.clouddn.com/" + putRet.hash;
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

    //查看问题
    @RequestMapping("/question/{questionId}/{questionTitle}")
    public String questionDetail(Model model, @PathVariable("questionId") Integer questionId){
        Questions question = questionsService.selectByPrimaryKey(questionId);
        question.setQuestionAskedTimeHumanReadableFormat(hr.TimeFormatByDate(question.getQuestionAskedTime()));
        model.addAttribute("question", question);
        return "/question";
    }

    //搜索tag, .+解决点号后忽略的问题
    @RequestMapping("/question/tag/{question_language:.+}")
    public String queryTag(Model model, @PathVariable("question_language") String question_language){
        //单独处理c#
        if(question_language.equals("csharp"))
            question_language = "c#";
        String tag = "Tag:" + question_language;
        List<Questions> questions = questionsService.selectByLanguageTag(question_language);
        timeformat(questions);
        model.addAttribute("questions", questions);
        model.addAttribute("TagOrString", tag);
        return "/index";
    }

    //问题搜索
    @RequestMapping("/question/query")
    public String queryString(String queryString,Model model){
        if(queryString.length() > 4 && queryString.substring(0,4).toLowerCase().equals("tag:")){
            return "forward:/question/tag/" + queryString.substring(4);
        }
        EnumMap<Languages,String> languagesMap = Languages.getLanguageMap();
        if(languagesMap.containsValue(queryString.toLowerCase())){
            return "forward:/question/tag/" + queryString;
        }
        List<Questions> questions = questionsService.selectByQuestionTitle(queryString);
        timeformat(questions);
        model.addAttribute("questions", questions);
        model.addAttribute("TagOrString", queryString);
        return "/index";
    }

    //加工时间显示
    private void timeformat(List<Questions> questions){
        for(Questions questions1:questions){
            questions1.setQuestionAskedTimeHumanReadableFormat(hr.TimeFormatByDate(questions1.getQuestionAskedTime()));
        }
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
