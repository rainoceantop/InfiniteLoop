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
    <div class="text-right">
        <a href="/newQuestion">提问问题</a>
    </div>
    <hr>
    <!-- 问题陈列 -->
    <c:forEach items="${questions}" var="question">
        <div class="question_box">
            <div class="q_title">
                <a href="#">${question.questionTitle}</a>
            </div>
            <div class="q_language">
                <div class="q_language_box">
                    java
                </div>
                <div class="q_language_box">
                    H5
                </div>
            </div>
        </div>
        <hr>
    </c:forEach>
</div>
</body>
</html>


