package com.InfiniteLoop.controller;

import com.InfiniteLoop.pojo.Answers;
import com.InfiniteLoop.service.impl.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private AnswersService answersService;

    @ResponseBody
    @RequestMapping("/questionCommentsHandle")
    public String questionCommentsHandle(Answers answers){
        answers.setAnsweredTime(new Date());
        answers.setAnswerLikes(0);
        try {
            answersService.insert(answers);
            return "SUCCESS";
        }catch (Exception e){
            return "ERROR";
        }
    }

    @ResponseBody
    @RequestMapping("/commentLikesUpdate")
    public String commentLikesUpdate(Answers answers){
        answersService.updateByPrimaryKeySelective(answers);
        return "SUCCESS";
    }
}
