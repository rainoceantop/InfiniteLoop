<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/5/29
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="Login"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="登陆啊 啊啊啊啊啊啊啊啊啊"/>
    </jsp:include>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <link rel="stylesheet" href="/static/css/lr.css">
    <script src="/static/js/lr.js"></script>
</head>
<body>
<!-- 导航条 -->
<%@include file="staticHtml/nav.jsp"%>

<div class="container" style="text-align: center">
    <div class="form-login">
        <form method="post" action="/user/loginHandle">
            <div>
                <label for="username" class="pull-left">用户名</label>
                <input type="text" id="username" class="text-field" name="userUsername" title="用户名" placeholder="账号">
                <label for="password" class="pull-left">密码</label>
                <input type="password" id="password" class="text-field" name="userPassword" title="密码" placeholder="密码">
                <a href="javascript:void(0);" class="a-btn" id="login-button">登录</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
