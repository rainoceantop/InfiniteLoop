<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="我是标题"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="请问这里出了什么错了。。。。"/>
    </jsp:include>
    <link rel="stylesheet" href="/static/css/index.css">
    <script src="/static/js/index.js"></script>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>
<!-- 导航条 -->
<%@include file="staticHtml/nav.jsp"%>


<div class="container">
    <h3 class="text-left">全部问题</h3>
    <a href="/newQuestion" class="text-right">提问问题</a>
    <hr>
    <!-- 问题陈列 -->
    <c:forEach items="${questions}" var="question">
        <div class="question_box">
            <div class="q_title">
                <a href="/question/${question.questionId}/${question.questionTitle}">${question.questionTitle}</a>
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
             ${question.questionAskedTimeHumanReadableFormat} &middot; <a href="#">${question.userDetail.userNickname}</a>
            </div>
        </div>
        <hr>
    </c:forEach>
    <c:if test="${page.currentPage ne page.firstPage}">
        <a href="/questions/page/${page.prePage}">pre</a>
    </c:if>
    <c:forEach var="p" begin="1" end="${page.pages}" step="1">
        <a href="/questions/page/${p}">${p}</a>
    </c:forEach>
    <c:if test="${page.currentPage ne page.lastPage}">
        <a href="/questions/page/${page.nextPage}">next</a>
    </c:if>
</div>
</body>
</html>


