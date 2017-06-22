package com.InfiniteLoop.pojo;

import java.util.Date;

public class Comments {
    private Integer commentId;

    private Integer questionId;

    private Integer userId;

    private Date commentedTime;

    private Integer commentLikes;

    private String content;

    private UserDetail userDetail;

    private String commentedTimeHumanReadableFormat;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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

    public Date getCommentedTime() {
        return commentedTime;
    }

    public void setCommentedTime(Date commentedTime) {
        this.commentedTime = commentedTime;
    }

    public Integer getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(Integer commentLikes) {
        this.commentLikes = commentLikes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public String getCommentedTimeHumanReadableFormat() {
        return commentedTimeHumanReadableFormat;
    }

    public void setCommentedTimeHumanReadableFormat(String questionAskedTimeHumanReadableFormat) {
        this.commentedTimeHumanReadableFormat = questionAskedTimeHumanReadableFormat;
    }
}
