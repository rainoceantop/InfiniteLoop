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
</head>
<body>
<%@include file="staticHtml/nav.jsp"%>
<div class="container">
    <h3>全部问题</h3>
    <hr>
    <div class="question">
        <div class="q_title">

        </div>
        <div class="q_language">

        </div>
    </div>
</div>
</body>
</html>


