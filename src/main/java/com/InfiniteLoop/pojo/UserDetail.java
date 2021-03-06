package com.InfiniteLoop.pojo;

public class UserDetail {
    private Integer userDetailId;

    private Integer userId;

    private String userNickname;

    private String userAvatar;

    private Byte userSex;

    private String userBirthday;

    private String userProfession;

    private String userLivingCity;

    private String userMotto;

    private String userLanguagesAttention;

    //头像存储版本，每次更新加一
    private Integer v;

    public Integer getUserDetailId() {
        return userDetailId;
    }

    public void setUserDetailId(Integer userDetailId) {
        this.userDetailId = userDetailId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar == null ? null : userAvatar.trim();
    }

    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }

    public String getUserProfession() {
        return userProfession;
    }

    public void setUserProfession(String userProfession) {
        this.userProfession = userProfession == null ? null : userProfession.trim();
    }

    public String getUserLivingCity() {
        return userLivingCity;
    }

    public void setUserLivingCity(String userLivingCity) {
        this.userLivingCity = userLivingCity == null ? null : userLivingCity.trim();
    }

    public String getUserMotto() {
        return userMotto;
    }

    public void setUserMotto(String userMotto) {
        this.userMotto = userMotto == null ? null : userMotto.trim();
    }

    public String getUserLanguagesAttention() {
        return userLanguagesAttention;
    }

    public void setUserLanguagesAttention(String userLanguagesAttention) {
        this.userLanguagesAttention = userLanguagesAttention;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
