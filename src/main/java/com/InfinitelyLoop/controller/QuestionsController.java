package com.InfinitelyLoop.controller;

import com.InfinitelyLoop.pojo.Questions;
import com.InfinitelyLoop.service.impl.QuestionLanguageService;
import com.InfinitelyLoop.service.impl.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
public class QuestionsController {

    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private QuestionLanguageService questionLanguageService;

    //主页
    @RequestMapping("/")
    public String queryItems(Model model) throws Exception {
        List<Questions> questions = questionsService.selectAllWithoutBlobs();

        model.addAttribute("questions", questions);

        return "/index";
    }

    //提问问题转接页面
    @RequestMapping("/newQuestion")
    public String newQuestion(Model model) throws Exception {

        List<String> questionLanguage = questionLanguageService.selectColumnName();
        questionLanguage.remove("language_id");
        questionLanguage.remove("question_id");

        model.addAttribute("questionLanguage", questionLanguage);


        return "/newQuestion";
    }

    //问题提交处理
    @RequestMapping(value = "/newQuestionHandle", method = RequestMethod.POST)
    public String newQuestionHandle(Questions questions) throws Exception {
        questions.setQuestionAskedTime(new Date());
       questionsService.insertSelective(questions);
       return "redirect:/";
    }

}
