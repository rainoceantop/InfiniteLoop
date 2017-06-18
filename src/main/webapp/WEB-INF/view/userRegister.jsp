<%--
  Created by IntelliJ IDEA.
  User: ZJX
  Date: 2017/5/29
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% request.setCharacterEncoding("UTF-8"); %>
    <jsp:include page="staticHtml/header.jsp">
        <jsp:param name="title" value="Register"/>
        <jsp:param name="keywords" value="java,spring,springmvc"/>
        <jsp:param name="description" value="无限循环官方网站用户注册"/>
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
    <div class="form-register">
        <form method="post" action="/user/registerHandle" id="register-form">
            <label for="username" class="pull-left">用户名</label>
            <input type="text" id="username" class="text-field" name="userUsername" title="用户名:6-15位字母数字组成" placeholder="账号" autocomplete="on" required pattern="\w{6,15}">
            <label for="password" class="pull-left">密码</label>
            <input type="password" id="password" class="text-field" name="userPassword" title="密码:6-15位字符组成" placeholder="密码" required pattern=".{6,15}">
            <label for="user" class="pull-left">名称(不可修改)</label>
            <input type="text" id="user" autocomplete="on" class="text-field" name="userNickname" title="名称:1-15位字符组成" placeholder="名称" required pattern=".{1,15}">
            <label for="email" class="pull-left">e-mail</label>
            <input type="email" autocomplete="on" id="email" class="text-field" name="userEmail" title="e-mail" placeholder="电子邮箱" required pattern="^[\w-]+@[\w-]+(\.[\w-]+)+$">
            <a href="javascript:void(0);" class="a-btn" id="register-button">注册</a>
            <input type="submit" style="display: none">
        </form>
    </div>
</div>
</body>
</html>
