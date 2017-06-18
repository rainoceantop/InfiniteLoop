package com.InfiniteLoop.pojo;

import java.util.List;

public class Language {
    private Integer languageId;

    private Integer userId;

    private Byte java;

    private Byte php;

    private Byte python;

    private Byte javascript;

    private Byte golang;

    private Byte c;

    private Byte csharp;

    private Byte cpp;

    private Byte swift;

    private Byte h5;

    private Byte css3;

    private Byte kotlin;

    private Byte nodejs;

    private Byte net;

    private Byte ruby;

    private Byte sql;

    private Byte objectiveC;

    private Byte r;

    private Byte visualBasic;

    private Byte perl;

    private Integer questionId;


    public Language(Integer userId, List<Byte> language, Integer questionId) {
        this.userId = userId;
        this.java = language.get(0);
        this.php = language.get(1);
        this.python = language.get(2);
        this.javascript = language.get(3);
        this.golang = language.get(4);
        this.c = language.get(5);
        this.csharp = language.get(6);
        this.cpp = language.get(7);
        this.swift = language.get(8);
        this.h5 = language.get(9);
        this.css3 = language.get(10);
        this.kotlin = language.get(11);
        this.nodejs = language.get(12);
        this.net = language.get(13);
        this.ruby = language.get(14);
        this.sql = language.get(15);
        this.objectiveC = language.get(16);
        this.r = language.get(17);
        this.visualBasic = language.get(18);
        this.perl = language.get(19);
        this.questionId = questionId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getJava() {
        return java;
    }

    public void setJava(Byte java) {
        this.java = java;
    }

    public Byte getPhp() {
        return php;
    }

    public void setPhp(Byte php) {
        this.php = php;
    }

    public Byte getPython() {
        return python;
    }

    public void setPython(Byte python) {
        this.python = python;
    }

    public Byte getJavascript() {
        return javascript;
    }

    public void setJavascript(Byte javascript) {
        this.javascript = javascript;
    }

    public Byte getGolang() {
        return golang;
    }

    public void setGolang(Byte golang) {
        this.golang = golang;
    }

    public Byte getC() {
        return c;
    }

    public void setC(Byte c) {
        this.c = c;
    }

    public Byte getCsharp() {
        return csharp;
    }

    public void setCsharp(Byte csharp) {
        this.csharp = csharp;
    }

    public Byte getCpp() {
        return cpp;
    }

    public void setCpp(Byte cpp) {
        this.cpp = cpp;
    }

    public Byte getSwift() {
        return swift;
    }

    public void setSwift(Byte swift) {
        this.swift = swift;
    }

    public Byte getH5() {
        return h5;
    }

    public void setH5(Byte h5) {
        this.h5 = h5;
    }

    public Byte getCss3() {
        return css3;
    }

    public void setCss3(Byte css3) {
        this.css3 = css3;
    }

    public Byte getKotlin() {
        return kotlin;
    }

    public void setKotlin(Byte kotlin) {
        this.kotlin = kotlin;
    }

    public Byte getNodejs() {
        return nodejs;
    }

    public void setNodejs(Byte nodejs) {
        this.nodejs = nodejs;
    }

    public Byte getNet() {
        return net;
    }

    public void setNet(Byte net) {
        this.net = net;
    }

    public Byte getRuby() {
        return ruby;
    }

    public void setRuby(Byte ruby) {
        this.ruby = ruby;
    }

    public Byte getSql() {
        return sql;
    }

    public void setSql(Byte sql) {
        this.sql = sql;
    }

    public Byte getObjectiveC() {
        return objectiveC;
    }

    public void setObjectiveC(Byte objectiveC) {
        this.objectiveC = objectiveC;
    }

    public Byte getR() {
        return r;
    }

    public void setR(Byte r) {
        this.r = r;
    }

    public Byte getVisualBasic() {
        return visualBasic;
    }

    public void setVisualBasic(Byte visualBasic) {
        this.visualBasic = visualBasic;
    }

    public Byte getPerl() {
        return perl;
    }

    public void setPerl(Byte perl) {
        this.perl = perl;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}
