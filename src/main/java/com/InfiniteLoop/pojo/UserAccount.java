package com.InfiniteLoop.pojo;

import java.util.Date;

public class UserAccount {
    private Integer userId;

    private String userUsername;

    private String userPassword;

    private String userNickname;

    private String userEmail;

    private Date userLastLoginTime;

    private String userLastLoginCity;

    private UserDetail userDetail;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername == null ? null : userUsername.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getUserLastLoginTime() {
        return userLastLoginTime;
    }

    public void setUserLastLoginTime(Date userLastLoginTime) {
        this.userLastLoginTime = userLastLoginTime;
    }

    public String getUserLastLoginCity() {
        return userLastLoginCity;
    }

    public void setUserLastLoginCity(String userLastLoginCity) {
        this.userLastLoginCity = userLastLoginCity == null ? null : userLastLoginCity.trim();
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "userId=" + userId +
                ", userUsername='" + userUsername + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userLastLoginTime=" + userLastLoginTime +
                ", userLastLoginCity='" + userLastLoginCity + '\'' +
                '}';
    }
}
