package com.InfinitelyLoop.pojo;

import java.util.Date;

public class Questions {
    private Integer questionId;

    private Integer userId;

    private Date questionAskedTime;

    private String questionTitle;

    private Integer questionsLikes;

    private String questionContent;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getQuestionAskedTime() {
        return questionAskedTime;
    }

    public void setQuestionAskedTime(Date questionAskedTime) {
        this.questionAskedTime = questionAskedTime;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle == null ? null : questionTitle.trim();
    }

    public Integer getQuestionsLikes() {
        return questionsLikes;
    }

    public void setQuestionsLikes(Integer questionsLikes) {
        this.questionsLikes = questionsLikes;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }
}
