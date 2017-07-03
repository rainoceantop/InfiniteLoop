package com.InfiniteLoop.pojo;


import java.util.Date;

public class Questions {
    private Integer questionId;

    private Integer userId;

    //store in the database
    private Date questionAskedTime;
    //get questionAskedTime from database and format it then show this var instead of questionAskedTime
    private String questionAskedTimeHumanReadableFormat;

    //format
    public void setQuestionAskedTimeHumanReadableFormat(String questionAskedTimeHumanReadableFormat) {
        this.questionAskedTimeHumanReadableFormat = questionAskedTimeHumanReadableFormat;
    }

    private String questionTitle;

    private Integer questionLikes;

    private String questionContent;
    private String questionLanguage;

    private UserDetail userDetail;
    private String description;

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

    public Integer getQuestionLikes() {
        return questionLikes;
    }

    public void setQuestionLikes(Integer questionsLikes) {
        this.questionLikes = questionsLikes;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public String getQuestionLanguage() {
        return questionLanguage;
    }

    public void setQuestionLanguage(String questionLanguage) {
        this.questionLanguage = questionLanguage;
    }

    public String getQuestionAskedTimeHumanReadableFormat() {
        return questionAskedTimeHumanReadableFormat;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
