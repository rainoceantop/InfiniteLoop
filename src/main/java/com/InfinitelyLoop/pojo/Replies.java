package com.InfinitelyLoop.pojo;

public class Replies {
    private Integer replyId;

    private Integer commentId;

    private Integer fromUserId;

    private Integer toUserId;

    private String content;

    private Integer replyLikes;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getReplyLikes() {
        return replyLikes;
    }

    public void setReplyLikes(Integer replyLikes) {
        this.replyLikes = replyLikes;
    }
}
