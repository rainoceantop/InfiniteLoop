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
    <script src="/static/js/question.js"></script>
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
        ${question.questionAskedTimeHumanReadableFormat} &middot; <a
                href="#">${question.userDetail.userNickname}</a>
    </div>

    <div class="comments">

        <c:if test="${not empty comments}">
            <div style="border-bottom: 1px solid #F0F3FF;width: 100%">
                <h4>${commentsCount}个回答</h4>
            </div>
        </c:if>
        <c:if test="${empty comments}">
            <p class="text-center">暂无评论</p>
        </c:if>
        <c:forEach items="${comments}" var="comment">
            <div class="comment">
                <div class="comment-content">
                    ${comment.content}
                </div>
                <div class="comment-footer">
                    <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                    <c:if test="${comment.commentLikes > 0}">
                        <span>${comment.commentLikes}</span>
                    </c:if>
                    <span class="pull-right time-user">${comment.commentedTimeHumanReadableFormat} &middot; <a
                            href="#">${comment.userDetail.userNickname}</a></span>
                </div>
            </div>
        </c:forEach>
        <div id="newComment"></div>
    </div>

    <div class="question-comments">
        <h3><label for="comment-panel">你的回答</label></h3>
        <form action="/comments/questionCommentsHandle" method="post">
            <input type="hidden" name="questionId" value="${question.questionId}">
            <input type="hidden" name="userId" value="${sessionScope.userId}">
            <input type="hidden" name="userNickname" value="${sessionScope.nickname}">
            <textarea name="content" id="comment-panel"></textarea>
            <a href="javascript:void(0)" class="a-btn" id="comment-button">回答</a>
        </form>
    </div>
</div>
<script>hljs.initHighlightingOnLoad();</script>
</body>
</html>
