package com.InfiniteLoop.pojo;

import java.util.Date;

public class Answers {
    private Integer answerId;

    private Integer questionId;

    private Integer userId;

    private Date answeredTime;

    private Integer answerLikes;

    private String content;

    private UserDetail userDetail;

    private String answeredTimeHumanReadableFormat;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

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

    public Date getAnsweredTime() {
        return answeredTime;
    }

    public void setAnsweredTime(Date answeredTime) {
        this.answeredTime = answeredTime;
    }

    public Integer getAnswerLikes() {
        return answerLikes;
    }

    public void setAnswerLikes(Integer answerLikes) {
        this.answerLikes = answerLikes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getAnsweredTimeHumanReadableFormat() {
        return answeredTimeHumanReadableFormat;
    }

    public void setAnsweredTimeHumanReadableFormat(String answeredTimeHumanReadableFormat) {
        this.answeredTimeHumanReadableFormat = answeredTimeHumanReadableFormat;
    }
}
