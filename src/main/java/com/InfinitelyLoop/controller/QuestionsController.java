package com.InfinitelyLoop.controller;

import com.InfinitelyLoop.pojo.Questions;
import com.InfinitelyLoop.service.impl.QuestionsService;
import com.InfinitelyLoop.tool.HumanReadableTimeFormat;
import com.InfinitelyLoop.tool.Languages;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;

@Controller
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private HumanReadableTimeFormat hr;


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
}
