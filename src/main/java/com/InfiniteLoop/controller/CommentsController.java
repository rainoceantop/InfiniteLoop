package com.InfiniteLoop.controller;

import com.InfiniteLoop.pojo.Comments;
import com.InfiniteLoop.service.impl.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @ResponseBody
    @RequestMapping("/questionCommentsHandle")
    public String questionCommentsHandle(Comments comments){
        comments.setCommentedTime(new Date());
        comments.setCommentLikes(0);
        commentsService.insert(comments);
        return "SUCCESS";
    }

    @ResponseBody
    @RequestMapping("/commentLikesUpdate")
    public String commentLikesUpdate(Comments comments){
        commentsService.updateByPrimaryKeySelective(comments);
        return "SUCCESS";
    }
}
