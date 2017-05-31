package com.InfinitelyLoop.controller;

import com.InfinitelyLoop.pojo.Questions;
import com.InfinitelyLoop.service.impl.QuestionsService;
import com.InfinitelyLoop.service.impl.LanguageService;
import com.InfinitelyLoop.tool.humanReadableTimeFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private LanguageService languageService;

    //主页
    @RequestMapping("/")
    public String queryItems(Model model) throws Exception {
        List<Questions> questions = questionsService.selectAllWithoutBlobs();
        humanReadableTimeFormat hr = new humanReadableTimeFormat();
        //format
        for(Questions questions1:questions){
            questions1.setQuestionAskedTimeHumanReadableFormat(hr.TimeFormat(new Date().getTime() - questions1.getQuestionAskedTime().getTime()));
        }
        model.addAttribute("questions", questions);
        return "/index";
    }

    //提问问题转接页面
    @RequestMapping("/newQuestion")
    public String newQuestion(Model model,HttpSession httpSession) throws Exception {
        if(httpSession.getAttribute("nickname") == null){
            return "redirect:/";
        }

        List<String> questionLanguage = languageService.selectColumnName();
        questionLanguage.remove("language_id");
        questionLanguage.remove("user_id");
        questionLanguage.remove("question_id");
        model.addAttribute("questionLanguage", questionLanguage);
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

}
