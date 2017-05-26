package com.InfinitelyLoop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionsController {
    @RequestMapping("/")
    public String queryItems() throws Exception {
        return "/index";
    }
}
