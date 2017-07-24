package com.InfiniteLoop.controller;

import com.InfiniteLoop.pojo.Answers;
import com.InfiniteLoop.pojo.Questions;
import com.InfiniteLoop.service.impl.AnswersService;
import com.InfiniteLoop.service.impl.QuestionsService;
import com.InfiniteLoop.service.impl.UserDetailService;
import com.InfiniteLoop.tool.HumanReadableTimeFormat;
import com.InfiniteLoop.tool.Languages;
import com.InfiniteLoop.tool.Page;
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
    private AnswersService answersService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private HumanReadableTimeFormat hr;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private Page page;


    //过滤html标签正则表达式
    private String filterHtml = "</?[a-zA-z]+>|</?h.+?>";
    //当前的相对位置
    private String rurl = "";
    //url是否已经带参
    private boolean isParam = false;


    //主页
    @RequestMapping({"/","/questions"})
    public String queryItems(Model model,@RequestParam(value = "page",required = false) Integer p) throws Exception {
        page.setRecords(questionsService.recordsCount());
        page.setRecordsPerPage(15);
        System.out.println(p);
        pageResolve(p);
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("beginIndex",page.getBeginIndex());
        map.put("recordsPerPage",page.getRecordsPerPage());
        List<Questions> questions = questionsService.selectAllWithoutBlobs(map);
        timeformat(questions);
        for(Questions q : questions){
            q.setUserDetail(userDetailService.selectByUserId(q.getUserId()));
        }
        rurl = request.getServletPath();
        isParam = false;
        model.addAttribute("questions", questions);
        model.addAttribute("page",page);
        model.addAttribute("rurl",rurl);
        model.addAttribute("isParam",isParam);
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
        questions.setQuestionLikes(0);
        questions.setQuestionUpId("0");
        questions.setQuestionDownId("0");
        questionsService.insertSelective(questions);
        return "redirect:/";
    }
    //问题图片处理
    @ResponseBody
    @RequestMapping(value = "/questionImgHandle", method = RequestMethod.POST)
    public String questionImgHandle(@RequestParam("questionContentImg") MultipartFile questionContentImg,@RequestParam(value = "editType") int editType, @RequestParam(value = "imgWidth",required = false) String w, @RequestParam(value = "imgHeight", required = false) String h){
        Response response ;
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
                    String url = "orfbw2a1e.bkt.clouddn.com/" + putRet.hash;
                    if (editType == -1){
                        return url;
                    }
                    else{
                        url += "?imageView2";
                        if (editType == 0){
                            url += "/0";
                        }
                        if (editType == 1){
                            url += "/1";
                        }
                        url += "/w/" + (w.equals("") ? "500" : w);
                        url += "/h/" + (h.equals("") ? "300" : h);
                        return url;
                    }
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
        List<Answers> answers = answersService.selectByQuestionId(questionId);
        //获取每个回答的user资料
        for(Answers c : answers){
            c.setUserDetail(userDetailService.selectByUserId(c.getUserId()));
            c.setAnsweredTimeHumanReadableFormat(new HumanReadableTimeFormat().TimeFormatByDate(c.getAnsweredTime()));
        }
        int answersCount = answers.size();
        question.setQuestionAskedTimeHumanReadableFormat(hr.TimeFormatByDate(question.getQuestionAskedTime()));
        question.setUserDetail(userDetailService.selectByUserId(question.getUserId()));
        String result = question.getQuestionContent().replaceAll(filterHtml,"").replaceAll("\"","'").replaceAll("[ ]{2,}"," ").replaceAll("\\\\s*|\\t|\\r|\\n","");
        question.setDescription(result.substring(0,result.length()>100?100:result.length()));
        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        model.addAttribute("answersCount",answersCount);
        return "/question";
    }
    //like处理
    @ResponseBody
    @RequestMapping(value = "/question/likesHandle",method = RequestMethod.POST)
    public String likesHandle(@RequestParam("questionId") Integer questionId,@RequestParam("rank") String rank,@RequestParam("userId") Integer userId){
        String[] a = questionsService.selectQuestionUpId(questionId).split(",");
        if(isContains(a,userId.toString())){
            return "ERROR";
        }
        String[] b = questionsService.selectQuestionDownId(questionId).split(",");
        if(isContains(b,userId.toString())){
            return "ERROR";
        }
        Map m = new HashMap();
        m.put("questionId",questionId);
        m.put("rank",rank);
        m.put("userId",userId);
        try {
            questionsService.updateQuestionLikesByQuestionId(m);
            if(rank.equals("up"))
                questionsService.updateQuestionUpId(m);
            if(rank.equals("down"))
                questionsService.updateQuestionDownId(m);
            return "SUCCESS";
        }
        catch (Exception e){
            return "ERROR";
        }
    }

    //搜索tag, .+解决点号后忽略的问题
    @RequestMapping("/question/tag/{question_language:.+}")
    public String queryTag(Model model, @PathVariable("question_language") String question_language,@RequestParam(value = "page",required = false) Integer p){
        //单独处理c#
        if(question_language.equals("csharp"))
            question_language = "c#";
        String tag = "Tag:" + question_language;
        page.setRecords(questionsService.selectTagRecordsCount(question_language));
        page.setBeginIndex(0);
        pageResolve(p);
        Map map = new HashMap();
        map.put("beginIndex",page.getBeginIndex());
        map.put("recordsPerPage",page.getRecordsPerPage());
        map.put("tag",question_language);
        List<Questions> questions = questionsService.selectByLanguageTag(map);
        timeformat(questions);
        for(Questions q : questions){
            q.setUserDetail(userDetailService.selectByUserId(q.getUserId()));
        }
        rurl = request.getServletPath();
        isParam = false;
        model.addAttribute("questions", questions);
        model.addAttribute("TagOrString", tag);
        model.addAttribute("page",page);
        model.addAttribute("rurl",rurl);
        model.addAttribute("isParam",isParam);
        return "/index";
    }

    //问题搜索
    @RequestMapping("/question/query")
    public String queryString(String queryString,Model model,@RequestParam(value = "page",required = false) Integer p){
        if(queryString.length() > 4 && queryString.substring(0,4).toLowerCase().equals("tag:")){
            return "forward:/question/tag/" + queryString.substring(4);
        }
        EnumMap<Languages,String> languagesMap = Languages.getLanguageMap();
        if(languagesMap.containsValue(queryString.toLowerCase())){
            return "forward:/question/tag/" + queryString;
        }
        page.setRecords(questionsService.selectTitleRecordsCount(queryString));
        page.setBeginIndex(0);
        pageResolve(p);
        Map map = new HashMap();
        map.put("beginIndex",page.getBeginIndex());
        map.put("recordsPerPage",page.getRecordsPerPage());
        map.put("queryString",queryString);
        List<Questions> questions = questionsService.selectByQuestionTitle(map);
        timeformat(questions);
        for(Questions q : questions){
            q.setUserDetail(userDetailService.selectByUserId(q.getUserId()));
        }
        rurl = request.getServletPath()+"?queryString=" + queryString;
        isParam = true;
        model.addAttribute("questions", questions);
        model.addAttribute("TagOrString", queryString);
        model.addAttribute("page",page);
        model.addAttribute("rurl",rurl);
        model.addAttribute("isParam",isParam);
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

    //判断页数传参
    private void pageResolve(Integer p){
        if (p != null){
            if(p > page.getPages())
                page.setCurrentPage(page.getPages());
            else if(p < 1)
                page.setCurrentPage(1);
            else
                page.setCurrentPage(p);
        }
        else{
            page.setCurrentPage(1);
        }
    }

}
