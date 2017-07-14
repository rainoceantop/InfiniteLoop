<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/6/6
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="${question.questionTitle}"/>
        <jsp:param name="keywords" value="${question.questionLanguage}"/>
        <jsp:param name="description" value="${question.description}"/>
    </jsp:include>
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

        <div class="question-attr">
            <div class="q_language pull-right">
                <!-- rank -->
                <div class="up-down">
                    <a class="question-rank-button" data-rank="up" data-question_id="${question.questionId}" data-user_id="${sessionScope.userId}" href="javascript:void(0);"><i class="fa fa-plus" aria-hidden="true"></i></a>&emsp;
                    <span class="rank-count">${question.questionLikes}</span>&emsp;
                    <a class="question-rank-button" data-rank="down" data-question_id="${question.questionId}" data-user_id="${sessionScope.userId}" href="javascript:void(0);"><i class="fa fa-minus" aria-hidden="true"></i></a>
                </div>
                <c:forEach items="${question.questionLanguage}" var="question_language">
                    <a href="/question/tag/${question_language ne 'c#' ? question_language : 'csharp'}">
                        <div class="q_language_box">
                                ${question_language}
                        </div>
                    </a>
                </c:forEach>
            </div>
            <div class="post_time">
                <div class="user">
                    <p>由&nbsp;<a href="#">${question.userDetail.userNickname}</a>&nbsp;于${question.questionAskedTimeHumanReadableFormat}提问</p>
                    <img src="${question.userDetail.userAvatar}" style="width: 50px;height: 50px;float: left;margin-right: 10px;">
                    <p>${question.userDetail.userNickname}</p>
                    <p style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">${question.userDetail.userMotto}</p>
                </div>
            </div>
        </div>
    </div>
    <div class="comments">
            <div class="answer-count-display" ${answersCount > 0 ? "" : 'style="display:none;"'}>
                <h4><span class="answer-count">${answersCount}</span>个回答</h4>
            </div>
        <%--<c:if test="${empty answers}">--%>
            <%--<p class="text-center if-not-answer">暂无评论</p>--%>
        <%--</c:if>--%>
        <c:if test="${not empty answers}">
        <c:forEach items="${answers}" var="answer">
            <div class="comment">
                <div class="comment-content">
                    ${answer.content}
                </div>
                <div class="comment-footer">
                    <i class="fa fa-thumbs-o-up" aria-hidden="true"></i>
                    <c:if test="${answer.answerLikes > 0}">
                        <span>${answer.answerLikes}</span>
                    </c:if>
                    <span class="pull-right time-user">${answer.answeredTimeHumanReadableFormat} &middot; <a
                            href="#">${answer.userDetail.userNickname}</a></span>
                </div>
            </div>
        </c:forEach>
        </c:if>
        <div id="newComment"></div>
    </div>

    <div class="question-answers">
        <h3><label for="comment-panel">你的回答</label></h3>
        <form action="/answers/questionAnswersHandle" method="post">
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
