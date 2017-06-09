package com.InfinitelyLoop.pojo;

public class LanguagesCount {
    private Integer languageId;

    private String languageName;

    private Integer languageUserAttentionCount;

    private Integer languageQuestionsCount;

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName == null ? null : languageName.trim();
    }

    public Integer getLanguageUserAttentionCount() {
        return languageUserAttentionCount;
    }

    public void setLanguageUserAttentionCount(Integer languageUserAttentionCount) {
        this.languageUserAttentionCount = languageUserAttentionCount;
    }

    public Integer getLanguageQuestionsCount() {
        return languageQuestionsCount;
    }

    public void setLanguageQuestionsCount(Integer languageQuestionsCount) {
        this.languageQuestionsCount = languageQuestionsCount;
    }
}