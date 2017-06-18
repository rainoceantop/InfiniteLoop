<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/6/6
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="${question.questionTitle}"/>
        <jsp:param name="keywords" value="${question.questionLanguage}"/>
        <jsp:param name="description" value="请问这里出了什么错了。。。。"/>
    </jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link rel="stylesheet" href="/static/css/question.css">
    <link rel="stylesheet" href="/static/css/tomorrow-night-eighties.css">
    <script src="/static/js/highlight.pack.js"></script>
</head>
<body>
<!-- 导航条 -->
<%@include file="staticHtml/nav.jsp"%>

<div class="container">
    <div class="question-title">
        ${question.questionTitle}
    </div>
    <div class="question-content">
        ${question.questionContent}
    </div>

    <div class="q_language">
        <c:forEach items="${question.questionLanguage}" var="question_language">
            <a href="/question/tag/${question_language ne 'c#' ? question_language : 'csharp'}">
                <div class="q_language_box">
                        ${question_language}
                </div>
            </a>
        </c:forEach>
    </div>
    <div class="post_time">
        ${question.questionAskedTimeHumanReadableFormat}
    </div>
</div>
<script>hljs.initHighlightingOnLoad();</script>
<style>
    .hljs{
        padding: 0;
    }
</style>
</body>
</html>
